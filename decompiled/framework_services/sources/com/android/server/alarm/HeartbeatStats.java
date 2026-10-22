package com.android.server.alarm;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.database.ContentObserver;
import android.os.Binder;
import android.os.Handler;
import android.os.Parcel;
import android.os.SystemClock;
import android.os.SystemProperties;
import android.os.UserHandle;
import android.provider.Settings;
import android.util.AtomicFile;
import android.util.Slog;
import com.android.server.notification.NotificationUsageStats;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class HeartbeatStats {
    static final boolean DEBUG_HEARTBEAT = false;
    static final boolean DEBUG_HEARTBEAT_V = false;
    static final boolean DEBUG_TRACE_ALARM = false;
    private static final Map<String, String> FORCE_HEARTBEAT_PKG_MAP = null;
    public static final String KEY_HEARTBEAT_INTERVAL = "matrix_ws_heartbeat_interval_ms";
    private static final int MAGIC = 1752457844;
    public static final long MAX_NAT_TIME_MS = 900000;
    public static final long MIN_NAT_TIME_MS = 120000;
    private static final int PARCEL_VERSION = 3;
    private static final String SHOW_DEMO_PKG = "com.zte.showdemo";
    static final String TAG = "HeartbeatStats";
    static final String buzzwords = ".*heartbeat.*|.*push.*|.*keep_alive.*|.*alarmtaskschedule.*";
    static HashMap<String, HashMap<String, HeartbeatInfo>> heartbeatPkgs = null;
    static final boolean localLOGV = false;
    private static final List<String> mWhiteHeartbeatPkgList = null;
    private static final String sDataFile = "/data/system/heartbeatstats.bin";
    private static final String sDefaultDataFile = "/system/etc/heartbeatstats.bin";
    private static final int sDetectDuration = 0;
    private static final boolean sDetectHeartbeat = false;
    static final boolean sEnabled = false;
    private static final int sFullStep = 5;
    private static final int sHeartbeatCheckInterval = 43200000;
    private static final int sHeartbeatCheckIntervalCount = 50;
    private static int sHeartbeatMonitorCount = 0;
    private static final int sHeartbeatThresholdMax = 0;
    private static final int sHeartbeatThresholdMin = 0;
    private static final int sHeartbeatValidateInterval = 259200000;
    private static final int sInitStep = 1;
    private static final int sMinHeartbeatInterval = 0;
    static ArrayList<Alarm> sTmpAlarmList;
    private static final boolean sUseList = false;
    private static final int sValidCountOneGroup = 0;
    private int mCheckCount;
    Context mContext;
    private HeartbeatInfo mFullStepInfo;
    private long mLastCheckRTC;
    long mLastWakedupElapsed;
    private long mLastWriteRTC;
    private long mNatTime;
    AlarmManagerService mService;

    class HeartbeatInfo {
        long mRefreshedRTC;
        int mStep;
        int mValidateCounter;
        final /* synthetic */ HeartbeatStats this$0;

        HeartbeatInfo(HeartbeatStats this$0, int step, long rtc) {
            this.this$0 = this$0;
            this.mStep = step;
            this.mRefreshedRTC = rtc;
        }

        HeartbeatInfo(HeartbeatStats this$0, int step) {
            this.this$0 = this$0;
            this.mStep = step;
            this.mRefreshedRTC = Long.MAX_VALUE;
        }

        long getHeartbeatInterval() {
            if (this.mStep >= 1) goto L7;
            return -1;
        L7:
            return HeartbeatStats.m1043$$Nest$fgetmNatTime(this.this$0);
        }

        int increaseStep() {
            if (this.mRefreshedRTC == Long.MAX_VALUE) goto L6;
            this.mStep++;
        L6:
            return this.mStep;
        }

        boolean updateStep(long orignInterval) {
            if (this.mRefreshedRTC != Long.MAX_VALUE) goto L6;
            return false;
        L6:
            this.mStep = ((int) ((5 * orignInterval) / ((long) HeartbeatStats.m1045$$Nest$sfgetsMinHeartbeatInterval()))) + 1;
            if (this.mStep <= 5) goto L13;
            if (HeartbeatStats.DEBUG_HEARTBEAT_V == false) goto L11;
            Slog.i(HeartbeatStats.TAG, "heartbeat step, too large : " + this.mStep);
        L11:
            this.mStep = 5;
        L18:
            return true;
        L13:
            if (this.mStep >= 1) goto L18;
            if (HeartbeatStats.DEBUG_HEARTBEAT_V == false) goto L17;
            Slog.i(HeartbeatStats.TAG, "heartbeat step, too small : " + this.mStep);
        L17:
            this.mStep = 1;
            goto L18
        }

        public void writeToParcel(Parcel out, int flags) {
            out.writeLong(this.mRefreshedRTC);
        }

        public String toString() {
            StringBuilder b = new StringBuilder();
            b.append("HeartbeatInfo@");
            b.append(Integer.toHexString(System.identityHashCode(this)));
            b.append("{ mStep=");
            b.append(this.mStep);
            if (this.mRefreshedRTC >= Long.MAX_VALUE) goto L5;
            b.append(", mRefreshedRTC=");
            b.append(HeartbeatStats.intToDotedString(this.mRefreshedRTC));
        L6:
            b.append(", mValidateCounter=");
            b.append(this.mValidateCounter);
            b.append("}");
            return b.toString();
        L5:
            b.append(", mRefreshedRTC=maxRTC");
            goto L6
        }
    }

    interface HeartbeatInfoCallback {
        boolean update(HeartbeatInfo r1);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmNatTime, reason: not valid java name */
    static /* bridge */ /* synthetic */ long m1043$$Nest$fgetmNatTime(HeartbeatStats r2) {
        return r2.mNatTime;
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateNatTime, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1044$$Nest$mupdateNatTime(HeartbeatStats r0) {
        r0.updateNatTime();
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetsMinHeartbeatInterval, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m1045$$Nest$sfgetsMinHeartbeatInterval() {
        return sMinHeartbeatInterval;
    }

    static {
        sHeartbeatMonitorCount = 2;
        localLOGV = AlarmManagerService.localLOGV;
        DEBUG_HEARTBEAT = SystemProperties.getBoolean("persist.alarm.hb.debug", true);
        DEBUG_HEARTBEAT_V = SystemProperties.getBoolean("debug.alarm.hb.v", false);
        DEBUG_TRACE_ALARM = SystemProperties.getBoolean("debug.power.trace", false);
        sEnabled = SystemProperties.getBoolean("persist.alarm.hb.align", true);
        sDetectHeartbeat = SystemProperties.getBoolean("alarm.hb.detect", true);
        sUseList = SystemProperties.getBoolean("alarm.hb.uselist", true);
        sHeartbeatThresholdMax = SystemProperties.getInt("alarm.hb.threshold", 900000);
        sHeartbeatThresholdMin = SystemProperties.getInt("alarm.hb.threshold", 120000);
        sMinHeartbeatInterval = SystemProperties.getInt("alarm.hb.mininterval", 300000);
        sDetectDuration = SystemProperties.getInt("alarm.hb.detect.duration", NotificationUsageStats.FOUR_HOURS);
        sValidCountOneGroup = SystemProperties.getInt("alarm.hb.validcount", 3);
        FORCE_HEARTBEAT_PKG_MAP = new AnonymousClass1();
        mWhiteHeartbeatPkgList = List.of("com.tencent.mm");
        heartbeatPkgs = new HashMap(20);
        sTmpAlarmList = new ArrayList(5);
    }

    public HeartbeatStats() {
        this.mFullStepInfo = new HeartbeatInfo(this, 5);
        this.mNatTime = sMinHeartbeatInterval;
        int count = sDetectDuration / sHeartbeatThresholdMax;
        if (count <= 1) goto L5;
        int r1 = count;
    L6:
        sHeartbeatMonitorCount = r1;
        return;
    L5:
        r1 = 2;
        goto L6
    }

    ArrayList<String> getTargetProcsByPkgName(String pkgName) {
        ArrayList<String> procList = new ArrayList(2);
        Iterator<String> r1 = heartbeatPkgs.keySet().iterator();
    L4:
        if (r1.hasNext() == false) goto L13;
        String pkgNameWithProc = r1.next();
        if (pkgNameWithProc.startsWith(pkgName + "#") == false) goto L4;
        int index = pkgNameWithProc.indexOf(35);
        if (index < 0) goto L4;
        if (index >= (pkgNameWithProc.length() - 1)) goto L4;
        procList.add(pkgNameWithProc.substring(index + 1));
        goto L4
    L13:
        return procList;
    }

    HashMap<String, HeartbeatInfo> getTargets(String pkgName, String procName) {
        return heartbeatPkgs.get(pkgName + "#" + procName);
    }

    void addTargets(String pkgName, String procName, HashMap<String, HeartbeatInfo> heartbeatTargets) {
        heartbeatPkgs.put(pkgName + "#" + procName, heartbeatTargets);
    }

    boolean isHeartbeatType(int type) {
        if (type != 0) goto L4;
    L7:
        return true;
    L4:
        if (2 == type) goto L7;
        return false;
    }

    HeartbeatInfo getHeartbeatInfo(Alarm alarm) {
        if (sEnabled == true) goto L5;
        return null;
    L5:
        if (isHeartbeatType(alarm.type) == true) goto L7;
        return null;
    L7:
        return getHeartbeatInfo(alarm.operation, alarm.repeatInterval, alarm.windowLength, alarm.processName);
    }

    HeartbeatInfo getHeartbeatInfo(PendingIntent pi, long repeatInterval, long windowLength, String procName) {
        if (sEnabled == false) goto L44;
        if (pi == null) goto L44;
        if (procName == null) goto L44;
        String pkgName = pi.getTargetPackage();
        if (pkgName != null) goto L11;
        return null;
    L11:
        if (mWhiteHeartbeatPkgList.contains(pkgName) == false) goto L14;
        return null;
    L14:
        if (sDetectHeartbeat == false) goto L40;
        if (windowLength < 0) goto L40;
        if (repeatInterval > sHeartbeatThresholdMin) goto L20;
    L22:
        String tag = FORCE_HEARTBEAT_PKG_MAP.get(pkgName);
        if (tag != null) goto L25;
    L30:
        HashMap<String, HeartbeatInfo> heartbeatTargets = getTargets(pkgName, procName);
        if (heartbeatTargets == null) goto L38;
        long ident = Binder.clearCallingIdentity();
        Intent intent = pi.getIntent();
        if (intent != null) goto L36;
        Binder.restoreCallingIdentity(ident);
        return null;
    L36:
        Binder.restoreCallingIdentity(ident);
        return heartbeatTargets.get(Alarm.makeTag(pi, null, 2));
    L38:
        return null;
    L25:
        if ("".equals(tag) == true) goto L29;
        if (tag.equals(Alarm.makeTag(pi, null, 2)) == false) goto L30;
    L29:
        return this.mFullStepInfo;
    L20:
        if (repeatInterval >= sHeartbeatThresholdMax) goto L22;
    L40:
        if (DEBUG_HEARTBEAT_V == false) goto L43;
        Slog.i(TAG, "give sFullStep, repeatInterval=" + repeatInterval);
    L43:
        return this.mFullStepInfo;
    L44:
        return null;
    }

    long getHeartbeatTime() {
        return this.mLastWakedupElapsed + ((long) sMinHeartbeatInterval);
    }

    long getIdealWakeupTime(long nowElapsed) {
        long heartbeat = this.mLastWakedupElapsed + ((long) sMinHeartbeatInterval);
        if (heartbeat <= nowElapsed) goto L5;
        return heartbeat;
    L5:
        return ((long) sMinHeartbeatInterval) + nowElapsed;
    }

    static String filterAction(String action) {
        if (sEnabled == false) goto L17;
        if (action != null) goto L6;
        return null;
    L6:
        if (action.matches("ALARM_ACTION\\([1-9][0-9]*\\)") == false) goto L10;
        return "*walarm*:ALARM_ACTION(PID)";
    L10:
        if (action.matches("com.tencent.mobileqq:MSF_[0-9][0-9]*") == false) goto L14;
        return "*walarm*:com.tencent.mobileqq:MSF_SOME_ID";
    L14:
        if (action.matches("com.tencent.tim:MSF_[0-9][0-9]*") == false) goto L20;
        return "*walarm*:com.tencent.tim:MSF_SOME_ID";
    L20:
        return null;
    L17:
        return null;
    }

    void checkHeartbeatTime(Alarm alarm, long nowELAPSED) {
        if (isHeartbeatType(alarm.type) == true) goto L5;
        return;
    L5:
        if ((nowELAPSED - this.mLastWakedupElapsed) < sMinHeartbeatInterval) goto L13;
        this.mLastWakedupElapsed = nowELAPSED;
        if (localLOGV == false) goto L9;
    L10:
        Slog.v(TAG, "mLastWakedupElapsed=" + this.mLastWakedupElapsed + ", by alarm=" + alarm);
        return;
    L9:
        if (DEBUG_TRACE_ALARM == true) goto L10;
        return;
    }

    void countOneWakeupTrigger(Alarm alarm, AlarmManagerService.FilterStats fs, long nowELAPSED, long nowRTC, Context context) {
        if (isHeartbeatType(alarm.type) == true) goto L5;
        return;
    L5:
        int elapsedTime = (int) (nowELAPSED / 1000);
        int N = fs.triggerHistory.size();
        if (N <= 0) goto L14;
        if (elapsedTime != fs.triggerHistory.get(N - 1)) goto L14;
        if (DEBUG_HEARTBEAT_V == false) goto L99;
        Slog.i(TAG, "duplicated wakeup, dropped");
        return;
    L99:
        return;
    L14:
        if (fs.heartbeatInfo == null) goto L18;
        fs.heartbeatInfo.increaseStep();
        if (DEBUG_HEARTBEAT_V == false) goto L18;
        Slog.i(TAG, "increase heartbeat step, fs=" + fs + ", fs.heartbeatInfo=" + fs.heartbeatInfo);
    L18:
        fs.triggerHistory.add(elapsedTime);
        int N2 = fs.triggerHistory.size();
        boolean enoughSample = true;
        int totalTime = (elapsedTime - fs.triggerHistory.get(0)) * 1000;
        if (DEBUG_HEARTBEAT_V == false) goto L22;
        Slog.i(TAG, "countOneWakeupTrigger, N=" + N2 + ", elapsedTime=" + elapsedTime + ", totalTime=" + totalTime + ", fs=" + fs);
    L22:
        if (N2 >= sHeartbeatMonitorCount) goto L25;
        enoughSample = false;
    L29:
        if (enoughSample == true) goto L31;
        return;
    L31:
        boolean changed = false;
        int triggerInterval = totalTime / N2;
        if (triggerInterval <= sHeartbeatThresholdMax) goto L65;
        int realTotalTime = 0;
        int tempTime = sMinHeartbeatInterval;
        int realCount = 0;
        int lastGroupStart = 0;
        int elapsedTime2 = 0;
        int tempCount = 1;
    L34:
        int N3 = N2;
        if (elapsedTime2 >= (N3 - 1)) goto L51;
        boolean enoughSample2 = enoughSample;
        int deltaTime = (fs.triggerHistory.get(elapsedTime2 + 1) - fs.triggerHistory.get(elapsedTime2)) * 1000;
        if (deltaTime <= 0) goto L41;
        int triggerInterval2 = triggerInterval;
        int realTotalTime2 = realTotalTime;
        if (deltaTime >= 1800000) goto L43;
        tempTime = tempTime + deltaTime;
        tempCount = tempCount + 1;
        realTotalTime = realTotalTime2;
    L50:
        elapsedTime2 = elapsedTime2 + 1;
        triggerInterval = triggerInterval2;
        N2 = N3;
        enoughSample = enoughSample2;
    L43:
        if (deltaTime <= 1800000) goto L49;
        int lastGroupStart2 = elapsedTime2 + 1;
        if (tempCount < sValidCountOneGroup) goto L47;
        realTotalTime = realTotalTime2 + tempTime;
        realCount = realCount + tempCount;
    L48:
        tempCount = 1;
        tempTime = sMinHeartbeatInterval;
        lastGroupStart = lastGroupStart2;
        goto L50
    L47:
        realTotalTime = realTotalTime2;
        goto L48
    L49:
        realTotalTime = realTotalTime2;
        goto L50
    L41:
        triggerInterval2 = triggerInterval;
        realTotalTime2 = realTotalTime;
        goto L43
    L51:
        int realTotalTime3 = realTotalTime + tempTime;
        int realCount2 = realCount + tempCount;
        if (lastGroupStart <= 0) goto L54;
        fs.triggerHistory.removeFront(lastGroupStart - 1);
    L55:
        long r12 = realCount2;
        int tempCount2 = sHeartbeatThresholdMax;
        if (r12 < (7200000 / ((long) tempCount2))) goto L58;
        triggerInterval = realTotalTime3 / realCount2;
        if (DEBUG_HEARTBEAT == false) goto L66;
        Slog.i(TAG, "countOneWakeupTrigger, realTotalTime=" + realTotalTime3 + ", realCount = " + realCount2 + ", triggerInterval =" + triggerInterval + ", totalTime = " + totalTime + ", pkgName=" + fs.mBroadcastStats.mPackageName + ", fs=" + fs);
    L66:
        boolean isHeartBeat = true;
        int isInList = checkList(fs, alarm.flags, context);
        if (isInList != 2) goto L69;
        isHeartBeat = false;
    L73:
        if (isHeartBeat == true) goto L76;
        return;
    L76:
        if (fs.heartbeatInfo != null) goto L86;
        String pkgName = fs.mBroadcastStats.mPackageName;
        String processName = alarm.processName;
        HashMap<String, HeartbeatInfo> heartbeatTargets = getTargets(pkgName, processName);
        if (heartbeatTargets != null) goto L81;
        heartbeatTargets = new HashMap(5);
        addTargets(pkgName, processName, heartbeatTargets);
    L81:
        fs.heartbeatInfo = new HeartbeatInfo(this, 1);
        heartbeatTargets.put(fs.mTag, fs.heartbeatInfo);
        if (DEBUG_HEARTBEAT == false) goto L84;
        Slog.i(TAG, "add to Heartbeat detction list, processName=" + processName + ", heartbeatTargets=" + heartbeatTargets + ", fs=" + fs + ", this=" + this);
    L84:
        changed = true;
    L86:
        fs.heartbeatInfo.mRefreshedRTC = nowRTC;
        long writeInterval = nowRTC - this.mLastWriteRTC;
        if (writeInterval > 43200000) goto L89;
    L92:
        if (changed == false) goto L101;
        writeToFile();
        return;
    L101:
        return;
    L89:
        if (DEBUG_HEARTBEAT == false) goto L91;
        Slog.i(TAG, "long enough to write to file, writeInterval=" + writeInterval + ", nowRTC=" + nowRTC + ", mLastWriteRTC=" + this.mLastWriteRTC + " heartbeatPkgs=" + heartbeatPkgs);
    L91:
        changed = true;
        this.mLastWriteRTC = nowRTC;
        goto L92
    L69:
        if (isInList != 0) goto L73;
        if (triggerInterval <= sHeartbeatThresholdMax) goto L73;
        isHeartBeat = false;
        goto L73
    L58:
        if (DEBUG_HEARTBEAT == false) goto L100;
        Slog.i(TAG, "Sample too less to heartbeat realCount = " + realCount2);
        return;
    L100:
        return;
    L54:
        fs.triggerHistory.removeFront(N3 / 2);
        goto L55
    L65:
        fs.triggerHistory.removeFront(N2 / 2);
        goto L66
    L25:
        if (totalTime >= (sDetectDuration / 2)) goto L29;
        if (N2 >= fs.triggerHistory.capacity()) goto L29;
        enoughSample = false;
        goto L29
    }

    void checkHeartbeatValidationLocked() {
        int r0 = this.mCheckCount + 1;
        this.mCheckCount = r0;
        if ((r0 % 50) == 0) goto L5;
        return;
    L5:
        final long nowRTC = System.currentTimeMillis();
        if (this.mLastCheckRTC <= nowRTC) goto L8;
        this.mLastCheckRTC = nowRTC;
    L8:
        long interval = nowRTC - this.mLastCheckRTC;
        if (interval <= 43200000) goto L14;
        Slog.i(TAG, "checking heartbeats validation, mLastCheckRTC=" + this.mLastCheckRTC + ", nowRTC=" + nowRTC);
        this.mLastCheckRTC = nowRTC;
        boolean changed = traversalHeartbeatInfos(heartbeatPkgs, new AnonymousClass2(this, nowRTC));
        if (changed == false) goto L15;
        writeToFile();
        return;
    L15:
        return;
    }

    public static boolean traversalHeartbeatInfos(HashMap<String, HashMap<String, HeartbeatInfo>> htbts, HeartbeatInfoCallback callback) {
        boolean changed = false;
        Iterator<Map.Entry<String, HashMap<String, HeartbeatInfo>>> r1 = htbts.entrySet().iterator();
    L4:
        if (r1.hasNext() == false) goto L15;
        Map.Entry<String, HashMap<String, HeartbeatInfo>> pkgEntry = r1.next();
        HashMap<String, HeartbeatInfo> tgtMap = pkgEntry.getValue();
        Iterator<Map.Entry<String, HeartbeatInfo>> r4 = tgtMap.entrySet().iterator();
    L7:
        if (r4.hasNext() == false) goto L4;
        Map.Entry<String, HeartbeatInfo> tgtEntry = r4.next();
        HeartbeatInfo hbInfo = tgtEntry.getValue();
        if (callback.update(hbInfo) == false) goto L7;
        changed = true;
        r4.remove();
        Slog.i(TAG, "detected one heartbeatInfo, removed tgtEntry=" + tgtEntry);
        if (tgtMap.size() != 0) goto L7;
        r1.remove();
        Slog.i(TAG, "removed empty package pkgEntry=" + pkgEntry);
        goto L7
    L15:
        return changed;
    }

    int checkList(AlarmManagerService.FilterStats fs, int flags, Context context) {
        if (sUseList == false) goto L21;
        String pkgName = fs.mBroadcastStats.mPackageName;
        String act = fs.mTag;
        int uid = fs.mBroadcastStats.mUid;
        int appId = UserHandle.getAppId(uid);
        if (appId >= 10000) goto L7;
        return 2;
    L7:
        if ((flags & 12) != 0) goto L9;
    L11:
        if (act != null) goto L13;
        return 0;
    L13:
        if (act.toLowerCase().matches(buzzwords) == true) goto L15;
        return 0;
    L15:
        if (DEBUG_HEARTBEAT == false) goto L23;
        Slog.d(TAG, "HTBT buzzword " + act);
        return 1;
    L23:
        return 1;
    L9:
        if (isSystemApp(pkgName, context) == false) goto L11;
        return 2;
    L21:
        return 0;
    }

    private boolean isSystemApp(String pkg, Context context) {
        PackageManager pm = context.getPackageManager();
        boolean isSystem = false;
        boolean r2 = false;
        if (pm != null) goto L8;
        Slog.w(TAG, "pm is null. sysApp judge failed!");     // Catch: PackageManager.NameNotFoundException -> L6
        return false;
    L8:
        ApplicationInfo appInfo = pm.getApplicationInfo(pkg, 0);     // Catch: PackageManager.NameNotFoundException -> L6
        if (appInfo != null) goto L13;
        Slog.w(TAG, "appInfo is null. sysApp judge failed!");     // Catch: PackageManager.NameNotFoundException -> L6
        return false;
    L13:
        if ((appInfo.flags & 129) == 0) goto L15;
        r2 = true;
    L15:
        isSystem = r2;
        if (DEBUG_HEARTBEAT == false) goto L21;
        if (isSystem == false) goto L21;
        Slog.i(TAG, pkg + " is SystemApp");     // Catch: PackageManager.NameNotFoundException -> L6
    L21:
        return isSystem;
    L20:
        Slog.w(TAG, "get app info failed");
        goto L21
    }

    boolean readFromFile() {
        String dataFile = sDataFile;
        if (new File(sDataFile).exists() == true) goto L22;
        dataFile = sDefaultDataFile;
    L22:
        AtomicFile file = new AtomicFile(new File(dataFile));     // Catch: Throwable -> L12 FileNotFoundException -> L14
        FileInputStream stream = file.openRead();     // Catch: Throwable -> L12 FileNotFoundException -> L14
        int[] len = new int[1];     // Catch: Throwable -> L12 FileNotFoundException -> L14
        byte[] raw = readFully(stream, len);     // Catch: Throwable -> L12 FileNotFoundException -> L14
        Parcel in = Parcel.obtain();     // Catch: Throwable -> L12 FileNotFoundException -> L14
        in.unmarshall(raw, 0, len[0]);     // Catch: Throwable -> L12 FileNotFoundException -> L14
        in.setDataPosition(0);     // Catch: Throwable -> L12 FileNotFoundException -> L14
        stream.close();     // Catch: Throwable -> L12 FileNotFoundException -> L14
        readFromParcel(in);     // Catch: Throwable -> L12 FileNotFoundException -> L14
        in.recycle();     // Catch: Throwable -> L12 FileNotFoundException -> L14
        goto L19
    L9:
        if (DEBUG_HEARTBEAT == false) goto L11;
        Slog.i(TAG, "read HeartbeatStats from file:" + dataFile + ", this=" + this);
    L11:
        return true;
    L12:
        e = move-exception;
        reset();
        Slog.e(TAG, "Error reading History Heartbeat statistics", e);
        return false;
    L19:
        if (DEBUG_HEARTBEAT == false) goto L21;
        Slog.i(TAG, "read HeartbeatStats with error, dataFile=" + dataFile);
    L21:
        return false;
    }

    static byte[] readFully(InputStream stream, int[] outLen) throws IOException {
        int pos = 0;
        int initialAvail = stream.available();
        if (initialAvail <= 0) goto L5;
        int r2 = initialAvail + 1;
    L6:
        byte[] data = new byte[r2];
    L7:
        int amt = stream.read(data, pos, data.length - pos);
        if (amt < 0) goto L9;
        pos = pos + amt;
        if (pos < data.length) goto L7;
        byte[] newData = new byte[pos + 16384];
        System.arraycopy(data, 0, newData, 0, pos);
        data = newData;
        goto L7
    L9:
        outLen[0] = pos;
        return data;
    L5:
        r2 = 16384;
        goto L6
    }

    void writeToFile() {
        FileOutputStream fout = null;
        AtomicFile file = new AtomicFile(new File(sDataFile));
        Parcel out = Parcel.obtain();     // Catch: Throwable -> L7 IOException -> L9
        writeToParcel(out, 0);     // Catch: Throwable -> L7 IOException -> L9
        byte[] outData = out.marshall();     // Catch: Throwable -> L7 IOException -> L9
        out.recycle();     // Catch: Throwable -> L7 IOException -> L9
        fout = file.startWrite();     // Catch: Throwable -> L7 IOException -> L9
        fout.write(outData);     // Catch: Throwable -> L7 IOException -> L9
        file.finishWrite(fout);     // Catch: Throwable -> L7 IOException -> L9
        if (DEBUG_HEARTBEAT == false) goto L12;
        Slog.i(TAG, "write HeartbeatStats to file this=" + this);     // Catch: Throwable -> L7 IOException -> L9
    L12:
        fout.close();     // Catch: IOException -> L14
    L34:
        return;
    L7:
        th = move-exception;
        if (fout != null) goto L30;
    L29:
        throw th;
    L30:
        fout.close();     // Catch: IOException -> L27
    L27:
        e = move-exception;
        e.printStackTrace();
    L9:
        e = move-exception;
        Slog.w(TAG, "Error writing heartbeat stats", e);     // Catch: Throwable -> L7
        if (fout == null) goto L20;
        file.failWrite(fout);     // Catch: Throwable -> L7
    L20:
        if (fout == null) goto L37;
        fout.close();     // Catch: IOException -> L14
        goto L34
    L37:
        return;
    L14:
        e = move-exception;
        e.printStackTrace();
    }

    void reset() {
        this.mLastCheckRTC = 0;
        this.mLastWriteRTC = 0;
        heartbeatPkgs.clear();
    }

    public void readFromParcel(Parcel in) {
        int magic = in.readInt();
        if (MAGIC == magic) goto L6;
        Slog.i(TAG, "Error MAGIC number magic=" + magic);
        return;
    L6:
        int version = in.readInt();
        if (3 == version) goto L10;
        Slog.i(TAG, "Error version=" + version);
        return;
    L10:
        long checkRTC = in.readLong();
        if (0 != this.mLastCheckRTC) goto L13;
        this.mLastCheckRTC = checkRTC;
    L13:
        long writeRTC = in.readLong();
        if (0 != this.mLastWriteRTC) goto L16;
        this.mLastWriteRTC = writeRTC;
    L16:
        int pkgN = in.readInt();
        int i = 0;
    L17:
        if (i >= pkgN) goto L35;
        int tgtN = in.readInt();
        String pkgName = in.readString();
        HashMap<String, HeartbeatInfo> tgtMap = heartbeatPkgs.get(pkgName);
        boolean newPackage = false;
        if (tgtMap != null) goto L21;
        tgtMap = new HashMap(tgtN);
        newPackage = true;
    L21:
        int j = 0;
    L22:
        if (j >= tgtN) goto L30;
        String act = null;
        int magic2 = magic;
        if (1 != in.readInt()) goto L26;
        act = in.readString();
    L26:
        HeartbeatInfo hbInfo = parseFromParcelToHb(in);
        if (tgtMap.get(act) != null) goto L29;
        tgtMap.put(act, hbInfo);
    L29:
        j = j + 1;
        magic = magic2;
        goto L22
    L30:
        int magic3 = magic;
        if (newPackage == false) goto L33;
        heartbeatPkgs.put(pkgName, tgtMap);
    L33:
        i = i + 1;
        magic = magic3;
        goto L17
    }

    public void writeToParcel(Parcel out, int flags) {
        out.writeInt(MAGIC);
        out.writeInt(3);
        out.writeLong(this.mLastCheckRTC);
        out.writeLong(this.mLastWriteRTC);
        int pkgN = heartbeatPkgs.size();
        out.writeInt(pkgN);
        Iterator<Map.Entry<String, HashMap<String, HeartbeatInfo>>> r1 = heartbeatPkgs.entrySet().iterator();
    L4:
        if (r1.hasNext() == false) goto L14;
        Map.Entry<String, HashMap<String, HeartbeatInfo>> pkgEntry = r1.next();
        HashMap<String, HeartbeatInfo> tgtMap = pkgEntry.getValue();
        int tgtN = tgtMap.size();
        out.writeInt(tgtN);
        String pkgName = pkgEntry.getKey();
        out.writeString(pkgName);
        Iterator<Map.Entry<String, HeartbeatInfo>> r6 = tgtMap.entrySet().iterator();
    L7:
        if (r6.hasNext() == false) goto L4;
        Map.Entry<String, HeartbeatInfo> tgtEntry = r6.next();
        String target = tgtEntry.getKey();
        if (target == null) goto L11;
        out.writeInt(1);
        out.writeString(target);
    L12:
        HeartbeatInfo hbInfo = tgtEntry.getValue();
        hbInfo.writeToParcel(out, 0);
        goto L7
    L11:
        out.writeInt(0);
        goto L12
    }

    void printTargetMap(HashMap<String, HeartbeatInfo> targetMap, StringBuilder b) {
        int i = 0;
        Iterator<Map.Entry<String, HeartbeatInfo>> r1 = targetMap.entrySet().iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        Map.Entry<String, HeartbeatInfo> entry = r1.next();
        b.append("    ");
        int i2 = i + 1;
        b.append(i);
        b.append(" : ");
        b.append(entry.getValue());
        b.append(" : ");
        String target = entry.getKey();
        b.append(target);
        b.append("\n");
        i = i2;
        goto L4
    }

    AlarmRingBuffer getHistoryBuffer() {
        if (sEnabled == true) goto L5;
        return null;
    L5:
        return new AlarmRingBuffer(sHeartbeatMonitorCount * 2);
    }

    void init(AlarmManagerService service, Context context, final Handler handler) {
        Slog.i(TAG, "init HBEnable: " + sEnabled + ", DEBUG_HEARTBEAT: " + DEBUG_HEARTBEAT + ", DEBUG_HEARTBEAT_V: " + DEBUG_HEARTBEAT_V + ", DEBUG_TRACE_ALARM: " + DEBUG_TRACE_ALARM);
        if (sEnabled == false) goto L6;
        readFromFile();
    L6:
        if (Boolean.parseBoolean(System.getProperty("ro.vendor.feature.retail_show_mode", "false")) == false) goto L8;
        mWhiteHeartbeatPkgList.add(SHOW_DEMO_PKG);
    L8:
        this.mLastWakedupElapsed = SystemClock.elapsedRealtime();
        this.mService = service;
        this.mContext = context;
        updateNatTime();
        ContentObserver settingsObserver = new AnonymousClass3(this, handler);
        this.mContext.getContentResolver().registerContentObserver(Settings.Global.getUriFor(KEY_HEARTBEAT_INTERVAL), false, settingsObserver);
    }

    private void updateNatTime() {
        long natTime = Settings.Global.getLong(this.mContext.getContentResolver(), KEY_HEARTBEAT_INTERVAL, sMinHeartbeatInterval);
        this.mNatTime = Math.max(120000, Math.min(MAX_NAT_TIME_MS, natTime));
        Slog.i(TAG, "update nat time : " + this.mNatTime);
    }

    static String intToDotedString(long i) {
        StringBuilder b = new StringBuilder(40);
        b.append(i);
        int len = b.length();
        if (6 >= len) goto L6;
        b.insert(len - 6, '\'');
        len = b.length();
    L6:
        if (3 >= len) goto L9;
        b.insert(len - 3, '\'');
    L9:
        return b.toString();
    }

    public String toString() {
        StringBuilder b = new StringBuilder(2048);
        b.append("\nHeartbeatStatHeartbeatStats@{");
        b.append(Integer.toHexString(System.identityHashCode(heartbeatPkgs)));
        b.append("}\nsEnabled = ");
        b.append(sEnabled);
        b.append("\nsDetectHeartbeat = ");
        b.append(sDetectHeartbeat);
        b.append("\nsUseList = ");
        b.append(sUseList);
        b.append("\nsHeartbeatThresholdMax = ");
        b.append(sHeartbeatThresholdMax);
        b.append("\nsHeartbeatThresholdMin = ");
        b.append(sHeartbeatThresholdMin);
        b.append("\nsMinHeartbeatInterval = ");
        b.append(sMinHeartbeatInterval);
        b.append("\nsDetectDuration = ");
        b.append(sDetectDuration);
        b.append("\nmLastCheckRTC = ");
        b.append(this.mLastCheckRTC);
        b.append("\nmLastWriteRTC = ");
        b.append(this.mLastWriteRTC);
        b.append("\n");
        int i = 0;
        Iterator<Map.Entry<String, HashMap<String, HeartbeatInfo>>> r2 = heartbeatPkgs.entrySet().iterator();
    L4:
        if (r2.hasNext() == false) goto L7;
        Map.Entry<String, HashMap<String, HeartbeatInfo>> entry = r2.next();
        int i2 = i + 1;
        b.append(i);
        b.append(" : ");
        b.append(entry.getKey());
        b.append(" : targetMap@  ");
        HashMap<String, HeartbeatInfo> map = entry.getValue();
        b.append(Integer.toHexString(System.identityHashCode(map)));
        b.append(" :\n");
        printTargetMap(map, b);
        i = i2;
        goto L4
    L7:
        return b.toString();
    }

    public void dump(PrintWriter pw) {
        if (sEnabled == false) goto L6;
        pw.println("  Heartbeat Stats:");
        pw.print(toString());
        return;
    }

    private HeartbeatInfo parseFromParcelToHb(Parcel in) {
        long rtc = in.readLong();
        if (Long.MAX_VALUE != rtc) goto L6;
        rtc = System.currentTimeMillis();
    L6:
        return new HeartbeatInfo(this, 5, rtc);
    }
}
