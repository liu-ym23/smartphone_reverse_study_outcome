package com.stepos.pps.data.systemusage;

import android.app.ActivityManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.stepos.pps.data.util.Constants;
import com.stepos.pps.data.util.DeviceUtils;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.function.BiFunction;
import kotlin.jvm.internal.LongCompanionObject;
import org.json.JSONException;

/* loaded from: classes.dex */
class ProcessLifecycleCollector {
    private static final int CLOCK_TICKS_PER_SECOND = 100;
    private static final String EVENT_NAME = "8010003003";
    static final long FIVE_MIN_MS = 300000;
    private static final String K_ACC_DATE = "acc_date";
    private static final String K_ALIVE_PREFIX = "alive.";
    private static final String K_DAILY_PREFIX = "daily.";
    private static final String K_HEARTBEAT = "heartbeat";
    private static final String K_HEARTBEAT_ELAPSED_RT = "heartbeat_elapsed_rt";
    private static final String K_LAST_REPORT_DATE = "last_report_date";
    private static final long MAX_SESSION_MS = 86400000;
    private static final long ONE_DAY_MS = 86400000;
    private static final long ONE_HOUR_MS = 3600000;
    private static final String SP_NAME = "process_lifecycle";
    private static final String TAG = "ProcLifeCollect";
    private final Context mContext;
    private final Handler mHandler;
    private final SharedPreferences mPrefs;
    private final Map<Integer, ProcessSession> mAliveProcess = new HashMap();
    private final Map<String, Long> mDailyActiveDuration = new HashMap();
    private final Map<String, Long> mDailyVersion = new HashMap();
    private String mAccDate = "";
    private final Runnable mHeartbeatRunnable = new Runnable() { // from class: com.stepos.pps.data.systemusage.ProcessLifecycleCollector.1
        @Override // java.lang.Runnable
        public void run() {
            ProcessLifecycleCollector.this.heartbeat();
            ProcessLifecycleCollector.this.mHandler.postDelayed(this, 300000L);
        }
    };

    static class ProcessSession {
        int pid;
        String pkg;
        long startElapsedRT;
        long startMs;
        int uid;
        long versionCode;

        ProcessSession() {
        }
    }

    ProcessLifecycleCollector(Context context, Handler handler) {
        Context applicationContext = context.getApplicationContext();
        this.mContext = applicationContext;
        this.mPrefs = applicationContext.getSharedPreferences(SP_NAME, 0);
        this.mHandler = handler;
    }

    /* JADX WARN: Multi-variable type inference failed */
    void recover() throws JSONException, NumberFormatException {
        int i;
        Map<String, ?> map;
        int i2;
        long j;
        long j2;
        long j3;
        String str;
        String str2;
        String str3;
        int i3;
        String[] strArrSplit;
        int i4;
        String str4;
        long j4;
        Object[] objArr;
        long j5;
        long j6;
        long jCurrentTimeMillis = System.currentTimeMillis();
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        String date = formatDate(jCurrentTimeMillis);
        long j7 = this.mPrefs.getLong(K_HEARTBEAT, -1L);
        long j8 = this.mPrefs.getLong(K_HEARTBEAT_ELAPSED_RT, -1L);
        long j9 = 0;
        Object[] objArr2 = (j7 <= 0 || j8 < 0 || j8 > jElapsedRealtime) ? false : jCurrentTimeMillis - ((jElapsedRealtime - j8) + j7) > ONE_HOUR_MS;
        this.mDailyActiveDuration.clear();
        this.mDailyVersion.clear();
        this.mAliveProcess.clear();
        Map<String, ?> all = this.mPrefs.getAll();
        Iterator<Map.Entry<String, ?>> it = all.entrySet().iterator();
        while (true) {
            i = 6;
            if (!it.hasNext()) {
                break;
            }
            Map.Entry<String, ?> next = it.next();
            String key = next.getKey();
            if (key.startsWith(K_DAILY_PREFIX)) {
                String strSubstring = key.substring(6);
                Long l = (Long) next.getValue();
                l.longValue();
                this.mDailyActiveDuration.put(strSubstring, l);
            }
        }
        Map<Integer, ProcessSession> mapSnapshotLiveProcsFromProc = snapshotLiveProcsFromProc();
        ArrayList<String> arrayList = new ArrayList();
        for (String str5 : all.keySet()) {
            if (str5.startsWith(K_ALIVE_PREFIX)) {
                arrayList.add(str5);
            }
        }
        for (String str6 : arrayList) {
            String strValueOf = String.valueOf(all.get(str6));
            try {
                try {
                    i3 = Integer.parseInt(str6.substring(i));
                    j3 = j9;
                    try {
                        strArrSplit = strValueOf.split("\\|");
                        map = all;
                    } catch (Throwable unused) {
                        map = all;
                    }
                    try {
                        i4 = Integer.parseInt(strArrSplit[0]);
                    } catch (Throwable unused2) {
                        j = jCurrentTimeMillis;
                        j2 = jElapsedRealtime;
                        i2 = 6;
                        str = str6;
                        str2 = TAG;
                        str3 = strValueOf;
                        Log.w(str2, "replay bad alive entry " + str + " = " + str3);
                        all = map;
                        i = i2;
                        j9 = j3;
                        jCurrentTimeMillis = j;
                        jElapsedRealtime = j2;
                    }
                    try {
                        str4 = strArrSplit[1];
                        j4 = Long.parseLong(strArrSplit[2]);
                    } catch (Throwable unused3) {
                        j = jCurrentTimeMillis;
                        j2 = jElapsedRealtime;
                        str = str6;
                        i2 = 6;
                        str2 = TAG;
                        str3 = strValueOf;
                        Log.w(str2, "replay bad alive entry " + str + " = " + str3);
                        all = map;
                        i = i2;
                        j9 = j3;
                        jCurrentTimeMillis = j;
                        jElapsedRealtime = j2;
                    }
                } catch (Throwable unused4) {
                    map = all;
                    j = jCurrentTimeMillis;
                    j2 = jElapsedRealtime;
                    j3 = j9;
                }
            } catch (Throwable unused5) {
                map = all;
                i2 = i;
                j = jCurrentTimeMillis;
                j2 = jElapsedRealtime;
                j3 = j9;
            }
            try {
                if (strArrSplit.length >= 4) {
                    try {
                        objArr = 4;
                        j = jCurrentTimeMillis;
                        j5 = Long.parseLong(strArrSplit[3]);
                    } catch (Throwable unused6) {
                        j = jCurrentTimeMillis;
                        j2 = jElapsedRealtime;
                        str = str6;
                        str2 = TAG;
                        str3 = strValueOf;
                        i2 = 6;
                        Log.w(str2, "replay bad alive entry " + str + " = " + str3);
                        all = map;
                        i = i2;
                        j9 = j3;
                        jCurrentTimeMillis = j;
                        jElapsedRealtime = j2;
                    }
                } else {
                    objArr = 4;
                    j = jCurrentTimeMillis;
                    j5 = j3;
                }
                try {
                    Object[] objArr3 = objArr;
                    if (strArrSplit.length >= 5) {
                        long j10 = Long.parseLong(strArrSplit[objArr3 == true ? 1 : 0]);
                        j2 = jElapsedRealtime;
                        j6 = j10;
                    } else {
                        j2 = jElapsedRealtime;
                        j6 = -1;
                    }
                } catch (Throwable unused7) {
                    j2 = jElapsedRealtime;
                    str = str6;
                    str2 = TAG;
                    str3 = strValueOf;
                    i2 = 6;
                    Log.w(str2, "replay bad alive entry " + str + " = " + str3);
                    all = map;
                    i = i2;
                    j9 = j3;
                    jCurrentTimeMillis = j;
                    jElapsedRealtime = j2;
                }
                try {
                } catch (Throwable unused8) {
                    str = str6;
                    str2 = TAG;
                    str3 = strValueOf;
                    i2 = 6;
                    Log.w(str2, "replay bad alive entry " + str + " = " + str3);
                    all = map;
                    i = i2;
                    j9 = j3;
                    jCurrentTimeMillis = j;
                    jElapsedRealtime = j2;
                }
            } catch (Throwable unused9) {
                j = jCurrentTimeMillis;
                j2 = jElapsedRealtime;
                str = str6;
                str2 = TAG;
                i2 = 6;
                str3 = strValueOf;
                Log.w(str2, "replay bad alive entry " + str + " = " + str3);
                all = map;
                i = i2;
                j9 = j3;
                jCurrentTimeMillis = j;
                jElapsedRealtime = j2;
            }
            if (mapSnapshotLiveProcsFromProc.containsKey(Integer.valueOf(i3))) {
                ProcessSession processSession = mapSnapshotLiveProcsFromProc.get(Integer.valueOf(i3));
                ProcessSession processSession2 = new ProcessSession();
                processSession2.pid = i3;
                processSession2.uid = i4;
                processSession2.pkg = str4;
                processSession2.versionCode = j5;
                if (j6 >= j3 && j6 <= j2) {
                    processSession2.startElapsedRT = j6;
                } else {
                    processSession2.startElapsedRT = processSession.startElapsedRT;
                }
                processSession2.startMs = j - (j2 - processSession2.startElapsedRT);
                this.mAliveProcess.put(Integer.valueOf(i3), processSession2);
                mapSnapshotLiveProcsFromProc.remove(Integer.valueOf(i3));
            } else {
                long j11 = (j7 > 0 ? j7 : j) - j4;
                if (j11 > j3 && j11 <= Constants.CLEAN_CHECK_INTERVAL) {
                    long j12 = j5;
                    str = str6;
                    str2 = TAG;
                    str3 = strValueOf;
                    i2 = 6;
                    try {
                        addToBucket(str4, j11, j12);
                    } catch (Throwable unused10) {
                        Log.w(str2, "replay bad alive entry " + str + " = " + str3);
                        all = map;
                        i = i2;
                        j9 = j3;
                        jCurrentTimeMillis = j;
                        jElapsedRealtime = j2;
                    }
                }
                all = map;
                i = i2;
                j9 = j3;
                jCurrentTimeMillis = j;
                jElapsedRealtime = j2;
            }
            i2 = 6;
            all = map;
            i = i2;
            j9 = j3;
            jCurrentTimeMillis = j;
            jElapsedRealtime = j2;
        }
        long j13 = jCurrentTimeMillis;
        for (ProcessSession processSession3 : mapSnapshotLiveProcsFromProc.values()) {
            this.mAliveProcess.put(Integer.valueOf(processSession3.pid), processSession3);
        }
        String string = this.mPrefs.getString(K_ACC_DATE, "");
        if (!TextUtils.isEmpty(string) && !date.equals(string)) {
            if (objArr2 != false) {
                Log.w(TAG, "Wall-clock forward jump detected; keeping " + this.mDailyActiveDuration.size() + " buckets under today=" + date + " (skip phantom report to " + string + ")");
            } else {
                tryReport(string);
                this.mDailyActiveDuration.clear();
                this.mDailyVersion.clear();
            }
        }
        this.mAccDate = date;
        persistFull(j13);
        this.mHandler.removeCallbacks(this.mHeartbeatRunnable);
        this.mHandler.postDelayed(this.mHeartbeatRunnable, 300000L);
        Log.i(TAG, "recover: accDate=" + this.mAccDate + " alive=" + this.mAliveProcess.size() + " accBuckets=" + this.mDailyActiveDuration.size());
    }

    void onProcessStarted(int i, int i2, String str, long j, long j2) {
        if (TextUtils.isEmpty(str) || shouldSkip(str, i2) || isSubProcess(readProcName(i))) {
            return;
        }
        long jElapsedRtToWallclock = elapsedRtToWallclock(j);
        ProcessSession processSession = new ProcessSession();
        processSession.pid = i;
        processSession.uid = i2;
        processSession.pkg = str;
        processSession.startMs = jElapsedRtToWallclock;
        processSession.startElapsedRT = j;
        processSession.versionCode = j2;
        ProcessSession processSessionPut = this.mAliveProcess.put(Integer.valueOf(i), processSession);
        if (processSessionPut != null && processSessionPut.pkg.equals(str)) {
            processSession.startMs = Math.min(processSessionPut.startMs, jElapsedRtToWallclock);
            processSession.startElapsedRT = Math.min(processSessionPut.startElapsedRT > 0 ? processSessionPut.startElapsedRT : LongCompanionObject.MAX_VALUE, j);
            this.mAliveProcess.put(Integer.valueOf(i), processSession);
        }
        this.mPrefs.edit().putString(K_ALIVE_PREFIX + i, i2 + "|" + str + "|" + processSession.startMs + "|" + j2 + "|" + processSession.startElapsedRT).apply();
    }

    void onProcessDied(int i, long j) {
        long j2;
        ProcessLifecycleCollector processLifecycleCollector;
        ProcessSession processSessionRemove = this.mAliveProcess.remove(Integer.valueOf(i));
        if (processSessionRemove == null) {
            Log.e(TAG, "can not find died process, just skip.");
            return;
        }
        if (processSessionRemove.startElapsedRT > 0 && j >= processSessionRemove.startElapsedRT) {
            j2 = processSessionRemove.startElapsedRT;
        } else {
            j = elapsedRtToWallclock(j);
            j2 = processSessionRemove.startMs;
        }
        long j3 = j - j2;
        if (j3 <= 0 || j3 > Constants.CLEAN_CHECK_INTERVAL) {
            processLifecycleCollector = this;
        } else {
            processLifecycleCollector = this;
            processLifecycleCollector.addToBucket(processSessionRemove.pkg, j3, processSessionRemove.versionCode);
        }
        SharedPreferences.Editor editorRemove = processLifecycleCollector.mPrefs.edit().remove(K_ALIVE_PREFIX + i);
        long jLongValue = processLifecycleCollector.mDailyActiveDuration.getOrDefault(processSessionRemove.pkg, 0L).longValue();
        Log.e(TAG, "process die, add " + processSessionRemove.pkg + ", total time " + (jLongValue / 1000) + " to daily.pacakge");
        StringBuilder sb = new StringBuilder(K_DAILY_PREFIX);
        sb.append(processSessionRemove.pkg);
        editorRemove.putLong(sb.toString(), jLongValue).apply();
    }

    void onDateChanged() throws JSONException {
        long jCurrentTimeMillis = System.currentTimeMillis();
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        long jStartOfDay = startOfDay(jCurrentTimeMillis);
        String date = formatDate(jCurrentTimeMillis);
        long j = jElapsedRealtime - (jCurrentTimeMillis - jStartOfDay);
        for (ProcessSession processSession : this.mAliveProcess.values()) {
            if (processSession.startElapsedRT > 0 && processSession.startElapsedRT < j) {
                long j2 = j - processSession.startElapsedRT;
                if (j2 > 0 && j2 <= Constants.CLEAN_CHECK_INTERVAL) {
                    addToBucket(processSession.pkg, j2, processSession.versionCode);
                }
                processSession.startElapsedRT = j;
                processSession.startMs = jStartOfDay;
            } else if (processSession.startElapsedRT <= 0 && processSession.startMs < jStartOfDay) {
                long j3 = jStartOfDay - processSession.startMs;
                if (j3 > 0 && j3 <= Constants.CLEAN_CHECK_INTERVAL) {
                    addToBucket(processSession.pkg, j3, processSession.versionCode);
                }
                processSession.startMs = jStartOfDay;
                processSession.startElapsedRT = j;
            }
        }
        tryReport(this.mAccDate);
        this.mDailyActiveDuration.clear();
        this.mDailyVersion.clear();
        this.mAccDate = date;
        SharedPreferences.Editor editorEdit = this.mPrefs.edit();
        for (String str : this.mPrefs.getAll().keySet()) {
            if (str.startsWith(K_DAILY_PREFIX) || str.startsWith(K_ALIVE_PREFIX)) {
                editorEdit.remove(str);
            }
        }
        editorEdit.putString(K_ACC_DATE, date);
        for (ProcessSession processSession2 : this.mAliveProcess.values()) {
            editorEdit.putString(K_ALIVE_PREFIX + processSession2.pid, processSession2.uid + "|" + processSession2.pkg + "|" + processSession2.startMs + "|" + processSession2.versionCode + "|" + processSession2.startElapsedRT);
        }
        editorEdit.commit();
    }

    void reportYesterday() throws JSONException {
        String date = formatDate(startOfDay(System.currentTimeMillis() - Constants.CLEAN_CHECK_INTERVAL));
        if (date.equals(this.mAccDate)) {
            onDateChanged();
        } else {
            tryReport(date);
        }
    }

    void heartbeat() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        this.mPrefs.edit().putLong(K_HEARTBEAT, jCurrentTimeMillis).putLong(K_HEARTBEAT_ELAPSED_RT, SystemClock.elapsedRealtime()).apply();
    }

    private void persistFull(long j) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        SharedPreferences.Editor editorEdit = this.mPrefs.edit();
        for (String str : this.mPrefs.getAll().keySet()) {
            if (str.startsWith(K_DAILY_PREFIX) || str.startsWith(K_ALIVE_PREFIX)) {
                editorEdit.remove(str);
            }
        }
        editorEdit.putString(K_ACC_DATE, this.mAccDate);
        editorEdit.putLong(K_HEARTBEAT, j);
        editorEdit.putLong(K_HEARTBEAT_ELAPSED_RT, jElapsedRealtime);
        for (Map.Entry<String, Long> entry : this.mDailyActiveDuration.entrySet()) {
            editorEdit.putLong(K_DAILY_PREFIX + entry.getKey(), entry.getValue().longValue());
        }
        for (ProcessSession processSession : this.mAliveProcess.values()) {
            editorEdit.putString(K_ALIVE_PREFIX + processSession.pid, processSession.uid + "|" + processSession.pkg + "|" + processSession.startMs + "|" + processSession.versionCode + "|" + processSession.startElapsedRT);
        }
        editorEdit.commit();
    }

    private void addToBucket(String str, long j, long j2) {
        if (TextUtils.isEmpty(str) || j <= 0) {
            Log.e(TAG, "something wrong with pkg or dur.");
            return;
        }
        this.mDailyActiveDuration.merge(str, Long.valueOf(j), new BiFunction() { // from class: com.stepos.pps.data.systemusage.ProcessLifecycleCollector$$ExternalSyntheticLambda0
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return Long.valueOf(Long.sum(((Long) obj).longValue(), ((Long) obj2).longValue()));
            }
        });
        if (j2 > 0) {
            this.mDailyVersion.put(str, Long.valueOf(j2));
        }
    }

    private void tryReport(String str) throws JSONException {
        if (TextUtils.isEmpty(str) || this.mDailyActiveDuration.isEmpty() || str.equals(this.mPrefs.getString(K_LAST_REPORT_DATE, ""))) {
            return;
        }
        String strSafeGetOaid = safeGetOaid();
        String strCurrentTriggerTime = UsageReport.currentTriggerTime();
        for (Map.Entry<String, Long> entry : this.mDailyActiveDuration.entrySet()) {
            String key = entry.getKey();
            long jLongValue = entry.getValue().longValue();
            if (jLongValue > 0) {
                HashMap map = new HashMap();
                map.put("pkg_name", key);
                map.put("daily_date", str);
                map.put("app_active_duration", String.valueOf(jLongValue));
                map.put("app_code", String.valueOf(this.mDailyVersion.getOrDefault(key, 0L).longValue()));
                map.put("deviceOAID", strSafeGetOaid);
                map.put("trigger_time", strCurrentTriggerTime);
                UsageReport.ReportDailyUsage(EVENT_NAME, map);
            }
        }
        this.mPrefs.edit().putString(K_LAST_REPORT_DATE, str).commit();
        Log.i(TAG, "Reported " + this.mDailyActiveDuration.size() + " entries for " + str);
    }

    private Map<Integer, ProcessSession> snapshotLiveProcsFromProc() {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        HashMap map = new HashMap();
        try {
            ActivityManager activityManager = (ActivityManager) this.mContext.getSystemService("activity");
            if (activityManager != null && (runningAppProcesses = activityManager.getRunningAppProcesses()) != null) {
                long uptimeMs = readUptimeMs();
                long jCurrentTimeMillis = System.currentTimeMillis();
                long jElapsedRealtime = SystemClock.elapsedRealtime();
                PackageManager packageManager = this.mContext.getPackageManager();
                Iterator<ActivityManager.RunningAppProcessInfo> it = runningAppProcesses.iterator();
                while (it.hasNext()) {
                    ActivityManager.RunningAppProcessInfo next = it.next();
                    if (next.pkgList != null && next.pkgList.length != 0) {
                        String str = next.pkgList[0];
                        if (!shouldSkip(str, next.uid) && !isSubProcess(next.processName)) {
                            long procStartUptimeMs = readProcStartUptimeMs(next.pid);
                            long longVersionCode = 0;
                            long j = procStartUptimeMs >= 0 ? procStartUptimeMs : jElapsedRealtime;
                            long j2 = (uptimeMs <= 0 || procStartUptimeMs < 0) ? jCurrentTimeMillis : (jCurrentTimeMillis - uptimeMs) + procStartUptimeMs;
                            try {
                                longVersionCode = packageManager.getPackageInfo(str, 0).getLongVersionCode();
                            } catch (Throwable unused) {
                            }
                            long j3 = uptimeMs;
                            Iterator<ActivityManager.RunningAppProcessInfo> it2 = it;
                            long j4 = longVersionCode;
                            ProcessSession processSession = new ProcessSession();
                            processSession.pid = next.pid;
                            processSession.uid = next.uid;
                            processSession.pkg = str;
                            processSession.startMs = j2;
                            processSession.startElapsedRT = j;
                            processSession.versionCode = j4;
                            map.put(Integer.valueOf(next.pid), processSession);
                            it = it2;
                            uptimeMs = j3;
                        }
                    }
                }
            }
        } catch (Throwable th) {
            Log.e(TAG, "snapshotLiveProcsFromProc fail: " + th.getMessage());
        }
        return map;
    }

    private static long readUptimeMs() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("/proc/uptime"));
            try {
                String line = bufferedReader.readLine();
                if (line != null) {
                    long j = (long) (Double.parseDouble(line.split("\\s+")[0]) * 1000.0d);
                    bufferedReader.close();
                    return j;
                }
                bufferedReader.close();
                return -1L;
            } finally {
            }
        } catch (Throwable unused) {
            return -1L;
        }
    }

    private static long readProcStartMs(int i, long j, long j2) {
        if (j2 <= 0) {
            return -1L;
        }
        long procStartUptimeMs = readProcStartUptimeMs(i);
        if (procStartUptimeMs < 0) {
            return -1L;
        }
        return (j - j2) + procStartUptimeMs;
    }

    private static long readProcStartUptimeMs(int i) {
        int iLastIndexOf;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("/proc/" + i + "/stat"));
            try {
                String line = bufferedReader.readLine();
                if (line != null && (iLastIndexOf = line.lastIndexOf(41)) >= 0) {
                    String[] strArrSplit = line.substring(iLastIndexOf + 2).split(" ");
                    if (strArrSplit.length > 19) {
                        long j = (Long.parseLong(strArrSplit[19]) * 1000) / 100;
                        bufferedReader.close();
                        return j;
                    }
                }
                bufferedReader.close();
                return -1L;
            } finally {
            }
        } catch (Throwable unused) {
            return -1L;
        }
    }

    private static boolean isSubProcess(String str) {
        return str != null && str.indexOf(58) >= 0;
    }

    private static String readProcName(int i) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("/proc/" + i + "/cmdline"));
            try {
                String line = bufferedReader.readLine();
                if (line != null) {
                    int iIndexOf = line.indexOf(0);
                    if (iIndexOf >= 0) {
                        line = line.substring(0, iIndexOf);
                    }
                    String strTrim = line.trim();
                    if (strTrim.isEmpty()) {
                        strTrim = null;
                    }
                    bufferedReader.close();
                    return strTrim;
                }
                bufferedReader.close();
                return null;
            } finally {
            }
        } catch (Throwable unused) {
            return null;
        }
    }

    private boolean shouldSkip(String str, int i) {
        if (TextUtils.isEmpty(str) || i < 10000 || "com.stepos.pps".equals(str)) {
            return true;
        }
        try {
            return (this.mContext.getPackageManager().getApplicationInfo(str, 0).flags & 8) != 0;
        } catch (PackageManager.NameNotFoundException unused) {
            return true;
        }
    }

    private static long elapsedRtToWallclock(long j) {
        return System.currentTimeMillis() - (SystemClock.elapsedRealtime() - j);
    }

    private static long startOfDay(long j) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j);
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar.getTimeInMillis();
    }

    private static String formatDate(long j) {
        return new SimpleDateFormat("yyyy-MM-dd", Locale.US).format(new Date(j));
    }

    private static String safeGetOaid() {
        try {
            return DeviceUtils.getDeviceId();
        } catch (Throwable unused) {
            return "";
        }
    }

    void dump(PrintWriter printWriter) {
        printWriter.println("ProcessLifecycleCollector State:");
        printWriter.println("  Account Date: " + this.mAccDate);
        printWriter.println("  Daily Accumulated Durations:");
        if (this.mDailyActiveDuration.isEmpty()) {
            printWriter.println("    (none)");
        } else {
            for (Map.Entry<String, Long> entry : this.mDailyActiveDuration.entrySet()) {
                printWriter.println(String.format("    %s: %d ms (%.2f s)", entry.getKey(), entry.getValue(), Double.valueOf(r3.longValue() / 1000.0d)));
            }
        }
        printWriter.println("  Currently Alive Processes:");
        if (this.mAliveProcess.isEmpty()) {
            printWriter.println("    (none)");
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        for (ProcessSession processSession : this.mAliveProcess.values()) {
            printWriter.println(String.format("    pid=%-6d pkg=%s, started=%s, current_dur=%.2f min", Integer.valueOf(processSession.pid), processSession.pkg, formatDate(processSession.startMs), Double.valueOf((jCurrentTimeMillis - processSession.startMs) / 60000.0d)));
        }
    }
}
