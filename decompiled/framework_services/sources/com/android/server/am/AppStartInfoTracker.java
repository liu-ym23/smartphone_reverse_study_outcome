package com.android.server.am;

import android.app.ApplicationStartInfo;
import android.app.IApplicationStartInfoCompleteListener;
import android.content.ComponentName;
import android.content.Intent;
import android.content.IntentFilter;
import android.icu.text.SimpleDateFormat;
import android.os.Binder;
import android.os.FileUtils;
import android.os.Handler;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.UserHandle;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.AtomicFile;
import android.util.Slog;
import android.util.SparseArray;
import android.util.proto.ProtoInputStream;
import android.util.proto.ProtoOutputStream;
import android.util.proto.WireTypeMismatchException;
import com.android.internal.app.ProcessMap;
import com.android.internal.os.Clock;
import com.android.internal.os.MonotonicClock;
import com.android.modules.utils.TypedXmlPullParser;
import com.android.modules.utils.TypedXmlSerializer;
import com.android.server.IoThread;
import com.android.server.ServiceThread;
import com.android.server.SystemServiceManager;
import com.android.server.pm.Settings;
import com.android.server.wm.WindowProcessController;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.BiFunction;

/* JADX INFO: loaded from: classes.dex */
public final class AppStartInfoTracker {
    static final String APP_START_INFO_FILE = "procstartinfo";
    static final long APP_START_INFO_HISTORY_LENGTH_MS = 0;
    static final int APP_START_INFO_HISTORY_LIST_SIZE = 16;
    private static final int APP_START_INFO_MONITORING_MODE_LIST_SIZE = 100;
    private static final long APP_START_INFO_PERSIST_INTERVAL = 0;
    static final String APP_START_STORE_DIR = "procstartstore";
    private static final boolean DEBUG = false;
    private static final int FOREACH_ACTION_NONE = 0;
    private static final int FOREACH_ACTION_REMOVE_AND_STOP_ITERATION = 3;
    private static final int FOREACH_ACTION_REMOVE_ITEM = 1;
    private static final int FOREACH_ACTION_STOP_ITERATION = 2;
    static final int MAX_IN_PROGRESS_RECORDS = 5;
    private static final String MONITORING_MODE_EMPTY_TEXT = "No records";
    private static final String TAG = "ActivityManager";
    int mAppStartInfoHistoryListSize;
    AtomicBoolean mAppStartInfoLoaded;
    private Runnable mAppStartInfoPersistTask;
    private final SparseArray<ArrayList<ApplicationStartInfoCompleteCallback>> mCallbacks;
    private final ProcessMap<AppStartInfoContainer> mData;
    boolean mEnabled;
    private Handler mHandler;
    final ArrayMap<Long, ApplicationStartInfo> mInProgressRecords;
    private long mLastAppStartInfoPersistTimestamp;
    final Object mLock;
    MonotonicClock mMonotonicClock;
    File mProcStartInfoFile;
    File mProcStartStoreDir;
    ActivityManagerService mService;
    final ArrayList<Integer> mTemporaryInProgressIndexes;
    final ArrayList<ApplicationStartInfo> mTmpStartInfoList;

    final class AppStartInfoContainer {
        private ArrayList<ApplicationStartInfo> mInfos;
        private int mMaxCapacity;
        private boolean mMonitoringModeEnabled;
        private int mUid;
        final /* synthetic */ AppStartInfoTracker this$0;

        /* JADX INFO: renamed from: $r8$lambda$FN7Wkbk6-gglPVAtfDcpk3X1Nps, reason: not valid java name */
        public static /* synthetic */ double m1383$r8$lambda$FN7Wkbk6gglPVAtfDcpk3X1Nps(Long r2) {
            return lambda$calculateAverage$2(r2);
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmInfos, reason: not valid java name */
        static /* bridge */ /* synthetic */ ArrayList m1384$$Nest$fgetmInfos(AppStartInfoContainer r0) {
            return r0.mInfos;
        }

        /* JADX INFO: renamed from: -$$Nest$fputmUid, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m1385$$Nest$fputmUid(AppStartInfoContainer r0, int r1) {
            r0.mUid = r1;
        }

        AppStartInfoContainer(AppStartInfoTracker this$0, int maxCapacity) {
            this.this$0 = this$0;
            this.mMonitoringModeEnabled = false;
            this.mInfos = new ArrayList();
            this.mMaxCapacity = maxCapacity;
        }

        int getMaxCapacity() {
            if (this.mMonitoringModeEnabled == false) goto L6;
            return 100;
        L6:
            return this.mMaxCapacity;
        }

        void enableAppMonitoringModeForUser(int userId) {
            if (UserHandle.getUserId(this.mUid) != userId) goto L6;
            this.mMonitoringModeEnabled = true;
            return;
        }

        void disableAppMonitoringMode() {
            this.mMonitoringModeEnabled = false;
            if (this.mInfos.size() > getMaxCapacity()) goto L5;
            return;
        L5:
            this.mInfos.subList(0, this.mInfos.size() - getMaxCapacity()).clear();
            this.mInfos.trimToSize();
        }

        private static /* synthetic */ int lambda$disableAppMonitoringMode$0(ApplicationStartInfo a, ApplicationStartInfo b) {
            return Long.compare(b.getMonotonicCreationTimeMs(), a.getMonotonicCreationTimeMs());
        }

        void getStartInfoLocked(int filterPid, int maxNum, ArrayList<ApplicationStartInfo> results) {
            if (this.mInfos.size() > maxNum) goto L5;
            int r0 = 0;
        L6:
            results.addAll(r0, this.mInfos);
            return;
        L5:
            r0 = this.mInfos.size() - maxNum;
            goto L6
        }

        void addStartInfoLocked(ApplicationStartInfo info) {
        L3:
            if (this.mInfos.size() < getMaxCapacity()) goto L5;
            this.mInfos.removeLast();
            goto L3
        L5:
            this.mInfos.addFirst(info);
        }

        private static /* synthetic */ int lambda$addStartInfoLocked$1(ApplicationStartInfo a, ApplicationStartInfo b) {
            return Long.compare(b.getMonotonicCreationTimeMs(), a.getMonotonicCreationTimeMs());
        }

        void addTimestampToStartLocked(int key, long timestampNs) {
            if (this.mInfos.isEmpty() == false) goto L5;
            return;
        L5:
            ApplicationStartInfo startInfo = this.mInfos.get(0);
            if (isAddTimestampAllowed(startInfo, key, timestampNs) == true) goto L8;
            return;
        L8:
            startInfo.addStartupTimestamp(key, timestampNs);
            if (key != 4) goto L12;
            startInfo.setStartupState(2);
            AppStartInfoTracker.m1382$$Nest$mcheckCompletenessAndCallback(this.this$0, startInfo);
            return;
        }

        private boolean isAddTimestampAllowed(ApplicationStartInfo startInfo, int key, long timestampNs) {
            int startupState = startInfo.getStartupState();
            if (startupState != 1) goto L5;
            return false;
        L5:
            Map<Integer, Long> timestamps = startInfo.getStartupTimestamps();
            if (startupState != 2) goto L18;
            switch(key) {
                case 5: goto L18;
                case 6: goto L10;
                case 7: goto L18;
                default: goto L8;
            };
        L8:
            return false;
        L10:
            Long firstFrameTimeNs = timestamps.get(4);
            if (firstFrameTimeNs != null) goto L14;
            return false;
        L14:
            if (timestampNs <= firstFrameTimeNs.longValue()) goto L18;
            return false;
        L18:
            if (timestamps.get(Integer.valueOf(key)) == null) goto L20;
            return false;
        L20:
            return true;
        }

        void dumpLocked(PrintWriter pw, String prefix, SimpleDateFormat sdf) {
            if (this.mMonitoringModeEnabled == false) goto L31;
            List<Long> coldStartTimes = new ArrayList();
            List<Long> warmStartTimes = new ArrayList();
            List<Long> hotStartTimes = new ArrayList();
            int i = 0;
        L6:
            if (i >= this.mInfos.size()) goto L18;
            ApplicationStartInfo startInfo = this.mInfos.get(i);
            Map<Integer, Long> timestamps = startInfo.getStartupTimestamps();
            if (timestamps.containsKey(0) == false) goto L17;
            if (timestamps.containsKey(4) == false) goto L17;
            long time = timestamps.get(4).longValue() - timestamps.get(0).longValue();
            switch(startInfo.getStartType()) {
                case 1: goto L16;
                case 2: goto L15;
                case 3: goto L14;
                default: goto L17;
            };
        L14:
            hotStartTimes.add(Long.valueOf(time));
            goto L17
        L15:
            warmStartTimes.add(Long.valueOf(time));
            goto L17
        L16:
            coldStartTimes.add(Long.valueOf(time));
        L17:
            i = i + 1;
            goto L6
        L18:
            StringBuilder r3 = new StringBuilder();
            r3.append(prefix);
            r3.append("  Average Start Time in ns for Cold Starts: ");
            boolean r4 = coldStartTimes.isEmpty();
            Object r5 = AppStartInfoTracker.MONITORING_MODE_EMPTY_TEXT;
            if (r4 == false) goto L21;
            Object r6 = AppStartInfoTracker.MONITORING_MODE_EMPTY_TEXT;
        L22:
            r3.append(r6);
            pw.println(r3.toString());
            StringBuilder r7 = new StringBuilder();
            r7.append(prefix);
            r7.append("  Average Start Time in ns for Warm Starts: ");
            if (warmStartTimes.isEmpty() == false) goto L25;
            Object r8 = AppStartInfoTracker.MONITORING_MODE_EMPTY_TEXT;
        L26:
            r7.append(r8);
            pw.println(r7.toString());
            StringBuilder r9 = new StringBuilder();
            r9.append(prefix);
            r9.append("  Average Start Time in ns for Hot Starts: ");
            if (hotStartTimes.isEmpty() == true) goto L30;
            r5 = Long.valueOf(calculateAverage(hotStartTimes));
        L30:
            r9.append(r5);
            pw.println(r9.toString());
            goto L31
        L25:
            r8 = Long.valueOf(calculateAverage(warmStartTimes));
            goto L26
        L21:
            r6 = Long.valueOf(calculateAverage(coldStartTimes));
        L31:
            int size = this.mInfos.size();
            int i2 = 0;
        L32:
            if (i2 >= size) goto L35;
            this.mInfos.get(i2).dump(pw, prefix + "  ", "#" + i2, sdf);
            i2 = i2 + 1;
            goto L32
        }

        private long calculateAverage(List<Long> vals) {
            return (long) vals.stream().mapToDouble(new AppStartInfoTracker$AppStartInfoContainer$$ExternalSyntheticLambda0()).average().orElse(0.0d);
        }

        private static /* synthetic */ double lambda$calculateAverage$2(Long a) {
            return a.longValue();
        }

        void writeToProto(ProtoOutputStream proto, long fieldId, ByteArrayOutputStream byteArrayOutputStream, ObjectOutputStream objectOutputStream, TypedXmlSerializer typedXmlSerializer) throws IOException {
            long token = proto.start(fieldId);
            proto.write(1120986464257L, this.mUid);
            int size = this.mInfos.size();
            long removeOlderThan = this.this$0.getMonotonicTimeMs() - AppStartInfoTracker.APP_START_INFO_HISTORY_LENGTH_MS;
            int i = size - 1;
        L3:
            if (i < 0) goto L9;
            if (this.mInfos.get(i).getMonotonicCreationTimeMs() >= removeOlderThan) goto L7;
            this.mInfos.remove(i);
        L8:
            i = i - 1;
            goto L3
        L7:
            this.mInfos.get(i).writeToProto(proto, 2246267895810L, byteArrayOutputStream, objectOutputStream, typedXmlSerializer);
            goto L8
        L9:
            proto.write(1133871366147L, this.mMonitoringModeEnabled);
            proto.end(token);
        }

        int readFromProto(ProtoInputStream proto, long fieldId, String packageName, ByteArrayInputStream byteArrayInputStream, ObjectInputStream objectInputStream, TypedXmlPullParser typedXmlPullParser) throws IOException, WireTypeMismatchException, ClassNotFoundException {
            long token = proto.start(fieldId);
            int next = proto.nextField();
        L4:
            if (next == (-1)) goto L11;
            switch(next) {
                case 1: goto L9;
                case 2: goto L8;
                case 3: goto L7;
                default: goto L10;
            };
        L7:
            this.mMonitoringModeEnabled = proto.readBoolean(1133871366147L);
            goto L10
        L8:
            ApplicationStartInfo info = new ApplicationStartInfo(0);
            info.readFromProto(proto, 2246267895810L, byteArrayInputStream, objectInputStream, typedXmlPullParser);
            info.setPackageName(packageName);
            this.mInfos.addFirst(info);
            goto L10
        L9:
            this.mUid = proto.readInt(1120986464257L);
        L10:
            next = proto.nextField();
            goto L4
        L11:
            proto.end(token);
            return this.mUid;
        }
    }

    final class ApplicationStartInfoCompleteCallback implements IBinder.DeathRecipient {
        private final IApplicationStartInfoCompleteListener mCallback;
        private final int mUid;
        final /* synthetic */ AppStartInfoTracker this$0;

        /* JADX INFO: renamed from: -$$Nest$fgetmCallback, reason: not valid java name */
        static /* bridge */ /* synthetic */ IApplicationStartInfoCompleteListener m1386$$Nest$fgetmCallback(ApplicationStartInfoCompleteCallback r0) {
            return r0.mCallback;
        }

        ApplicationStartInfoCompleteCallback(AppStartInfoTracker this$0, IApplicationStartInfoCompleteListener callback, int uid) {
            this.this$0 = this$0;
            this.mCallback = callback;
            this.mUid = uid;
            this.mCallback.asBinder().linkToDeath(this, 0);     // Catch: RemoteException -> L5
            return;
        }

        void onApplicationStartInfoComplete(ApplicationStartInfo startInfo) {
            this.mCallback.onApplicationStartInfoComplete(startInfo);     // Catch: RemoteException -> L4
            return;
        }

        void unlinkToDeath() {
            this.mCallback.asBinder().unlinkToDeath(this, 0);
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            this.this$0.removeStartInfoCompleteListener(this.mCallback, this.mUid, false);
        }
    }

    public static /* synthetic */ Integer $r8$lambda$KV3NBYR4Jya7P9QoojzvC9rr4KE(AppStartInfoTracker r0, PrintWriter r1, SimpleDateFormat r2, String r3, SparseArray r4) {
        return r0.lambda$dumpHistoryProcessStartInfo$7(r1, r2, r3, r4);
    }

    /* JADX INFO: renamed from: $r8$lambda$NYsQh-8lM7FDsO3bJCG0ECUX12o, reason: not valid java name */
    public static /* synthetic */ int m1379$r8$lambda$NYsQh8lM7FDsO3bJCG0ECUX12o(AppStartInfoTracker r0, Integer r1, Integer r2) {
        return r0.lambda$maybeTrimInProgressRecordsLocked$1(r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$OAAONl-88gSRJWsYfe-6xUhxybY, reason: not valid java name */
    public static /* synthetic */ Integer m1380$r8$lambda$OAAONl88gSRJWsYfe6xUhxybY(int r0, String r1, SparseArray r2) {
        return lambda$removeByUserIdLocked$5(r0, r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$VdR_UMu5lcdcEkpdcV9tz9DCksE(AppStartInfoTracker r0) {
        r0.lambda$onSystemReady$0();
    }

    public static /* synthetic */ Integer $r8$lambda$e8bB6slpx0Xgy9r3R5ue8hao6m0(ProtoOutputStream r0, ByteArrayOutputStream r1, ObjectOutputStream r2, TypedXmlSerializer r3, String r4, SparseArray r5) {
        return lambda$persistProcessStartInfo$6(r0, r1, r2, r3, r4, r5);
    }

    public static /* synthetic */ Integer $r8$lambda$q83gRHliZ6lknI1uFyqnNAujwE8(int r0, ArrayList r1, String r2, SparseArray r3) {
        return lambda$getStartInfo$3(r0, r1, r2, r3);
    }

    public static /* synthetic */ Integer $r8$lambda$u6qs2IdvBWItgRWSSXIvHozrGxQ(String r0, SparseArray r1) {
        return lambda$configureDetailedMonitoring$2(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$w9zNHkWKHXjwRe_q1c5gg2-70ps, reason: not valid java name */
    public static /* synthetic */ int m1381$r8$lambda$w9zNHkWKHXjwRe_q1c5gg270ps(ApplicationStartInfo r0, ApplicationStartInfo r1) {
        return lambda$getStartInfo$4(r0, r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mcheckCompletenessAndCallback, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1382$$Nest$mcheckCompletenessAndCallback(AppStartInfoTracker r0, ApplicationStartInfo r1) {
        r0.checkCompletenessAndCallback(r1);
    }

    static {
        APP_START_INFO_PERSIST_INTERVAL = TimeUnit.MINUTES.toMillis(30);
        APP_START_INFO_HISTORY_LENGTH_MS = TimeUnit.DAYS.toMillis(14);
    }

    AppStartInfoTracker() {
        this.mLock = new Object();
        this.mEnabled = false;
        this.mMonotonicClock = null;
        this.mAppStartInfoPersistTask = null;
        this.mLastAppStartInfoPersistTimestamp = 0;
        this.mAppStartInfoLoaded = new AtomicBoolean();
        this.mTmpStartInfoList = new ArrayList();
        this.mInProgressRecords = new ArrayMap();
        this.mTemporaryInProgressIndexes = new ArrayList();
        this.mCallbacks = new SparseArray();
        this.mData = new ProcessMap();
    }

    void init(ActivityManagerService service) {
        this.mService = service;
        ServiceThread thread = new ServiceThread("ActivityManager:handler", 10, true);
        thread.start();
        this.mHandler = new Handler(thread.getLooper());
        this.mProcStartStoreDir = new File(SystemServiceManager.ensureSystemDir(), APP_START_STORE_DIR);
        if (FileUtils.createDir(this.mProcStartStoreDir) == true) goto L6;
        Slog.e(TAG, "Unable to create " + this.mProcStartStoreDir);
        return;
    L6:
        this.mProcStartInfoFile = new File(this.mProcStartStoreDir, APP_START_INFO_FILE);
        this.mAppStartInfoHistoryListSize = 16;
    }

    void onSystemReady() {
        this.mEnabled = true;
        if (this.mEnabled == true) goto L5;
        return;
    L5:
        registerForUserRemoval();
        registerForPackageRemoval();
        IoThread.getHandler().post(new AppStartInfoTracker$$ExternalSyntheticLambda7(this));
        if (this.mMonotonicClock != null) goto L9;
        this.mMonotonicClock = new MonotonicClock(Clock.SYSTEM_CLOCK.elapsedRealtime(), Clock.SYSTEM_CLOCK);
        return;
    }

    private /* synthetic */ void lambda$onSystemReady$0() {
        loadExistingProcessStartInfo();
    }

    private void maybeTrimInProgressRecordsLocked() {
        if (this.mInProgressRecords.size() > 5) goto L5;
        return;
    L5:
        this.mTemporaryInProgressIndexes.clear();
        int i = 0;
    L7:
        if (i >= this.mInProgressRecords.size()) goto L9;
        this.mTemporaryInProgressIndexes.add(i, Integer.valueOf(i));
        i = i + 1;
        goto L7
    L9:
        Collections.sort(this.mTemporaryInProgressIndexes, new AppStartInfoTracker$$ExternalSyntheticLambda2(this));
        if (this.mTemporaryInProgressIndexes.size() != 6) goto L12;
        this.mInProgressRecords.removeAt(this.mTemporaryInProgressIndexes.get(0).intValue());
    L15:
        this.mTemporaryInProgressIndexes.clear();
        return;
    L12:
        this.mTemporaryInProgressIndexes.subList(this.mTemporaryInProgressIndexes.size() - 5, this.mTemporaryInProgressIndexes.size()).clear();
        Collections.sort(this.mTemporaryInProgressIndexes);
        int i2 = this.mTemporaryInProgressIndexes.size() - 1;
    L13:
        if (i2 < 0) goto L15;
        this.mInProgressRecords.removeAt(this.mTemporaryInProgressIndexes.get(i2).intValue());
        i2 = i2 - 1;
        goto L13
    }

    private /* synthetic */ int lambda$maybeTrimInProgressRecordsLocked$1(Integer a, Integer b) {
        return Long.compare(this.mInProgressRecords.keyAt(a.intValue()).longValue(), this.mInProgressRecords.keyAt(b.intValue()).longValue());
    }

    void onActivityIntentStarted(Intent intent, long timestampNanos) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.mEnabled == true) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        ApplicationStartInfo start = new ApplicationStartInfo(getMonotonicTimeMs());     // Catch: Throwable -> L8
        start.setStartupState(0);     // Catch: Throwable -> L8
        start.setIntent(intent);     // Catch: Throwable -> L8
        start.setStartType(0);     // Catch: Throwable -> L8
        start.addStartupTimestamp(0, timestampNanos);     // Catch: Throwable -> L8
        start.setStartComponent(1);     // Catch: Throwable -> L8
        if (intent != null) goto L13;
    L17:
        start.setReason(11);     // Catch: Throwable -> L8
    L18:
        this.mInProgressRecords.put(Long.valueOf(timestampNanos), start);     // Catch: Throwable -> L8
        maybeTrimInProgressRecordsLocked();     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L13:
        if (intent.getCategories() == null) goto L17;
        if (intent.getCategories().contains("android.intent.category.LAUNCHER") == false) goto L17;
        start.setReason(6);     // Catch: Throwable -> L8
        goto L18
    }

    void onActivityIntentFailed(long id) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.mEnabled == true) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        int index = this.mInProgressRecords.indexOfKey(Long.valueOf(id));     // Catch: Throwable -> L8
        if (index >= 0) goto L14;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L14:
        ApplicationStartInfo info = this.mInProgressRecords.valueAt(index);     // Catch: Throwable -> L8
        if (info != null) goto L19;
        this.mInProgressRecords.removeAt(index);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L19:
        info.setStartupState(1);     // Catch: Throwable -> L8
        this.mInProgressRecords.removeAt(index);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
    }

    void onActivityLaunched(long id, ComponentName name, long temperature, ProcessRecord app) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.mEnabled == true) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        int index = this.mInProgressRecords.indexOfKey(Long.valueOf(id));     // Catch: Throwable -> L8
        if (index >= 0) goto L14;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L14:
        ApplicationStartInfo info = this.mInProgressRecords.valueAt(index);     // Catch: Throwable -> L8
        if (info == null) goto L24;
        if (app == null) goto L24;
        info.setStartType((int) temperature);     // Catch: Throwable -> L8
        addBaseFieldsFromProcessRecord(info, app);     // Catch: Throwable -> L8
        ApplicationStartInfo newInfo = addStartInfoLocked(info);     // Catch: Throwable -> L8
        if (newInfo != null) goto L21;
        this.mInProgressRecords.removeAt(index);     // Catch: Throwable -> L8
    L22:
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L21:
        this.mInProgressRecords.setValueAt(index, newInfo);     // Catch: Throwable -> L8
    L24:
        this.mInProgressRecords.removeAt(index);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
    }

    void onActivityLaunchCancelled(long id) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.mEnabled == true) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        int index = this.mInProgressRecords.indexOfKey(Long.valueOf(id));     // Catch: Throwable -> L8
        if (index >= 0) goto L14;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L14:
        ApplicationStartInfo info = this.mInProgressRecords.valueAt(index);     // Catch: Throwable -> L8
        if (info != null) goto L19;
        this.mInProgressRecords.removeAt(index);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L19:
        info.setStartupState(1);     // Catch: Throwable -> L8
        this.mInProgressRecords.removeAt(index);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
    }

    void onActivityLaunchFinished(long id, ComponentName name, long timestampNanos, int launchMode) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.mEnabled == true) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        int index = this.mInProgressRecords.indexOfKey(Long.valueOf(id));     // Catch: Throwable -> L8
        if (index >= 0) goto L14;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L14:
        ApplicationStartInfo info = this.mInProgressRecords.valueAt(index);     // Catch: Throwable -> L8
        if (info != null) goto L19;
        this.mInProgressRecords.removeAt(index);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L19:
        info.setLaunchMode(launchMode);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
    }

    ApplicationStartInfo onActivityReportFullyDrawn(long id, long timestampNanos) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.mEnabled == true) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return null;
    L10:
        int index = this.mInProgressRecords.indexOfKey(Long.valueOf(id));     // Catch: Throwable -> L8
        if (index >= 0) goto L14;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return null;
    L14:
        ApplicationStartInfo info = this.mInProgressRecords.valueAt(index);     // Catch: Throwable -> L8
        if (info != null) goto L19;
        this.mInProgressRecords.removeAt(index);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return null;
    L19:
        info.addStartupTimestamp(5, timestampNanos);     // Catch: Throwable -> L8
        this.mInProgressRecords.removeAt(index);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return info;
    }

    public void handleProcessServiceStart(long startTimeNs, ProcessRecord app, ServiceRecord serviceRecord) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.mEnabled == true) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        ApplicationStartInfo start = new ApplicationStartInfo(getMonotonicTimeMs());     // Catch: Throwable -> L8
        addBaseFieldsFromProcessRecord(start, app);     // Catch: Throwable -> L8
        start.setStartupState(0);     // Catch: Throwable -> L8
        start.addStartupTimestamp(0, startTimeNs);     // Catch: Throwable -> L8
        start.setStartType(1);     // Catch: Throwable -> L8
        start.setStartComponent(4);     // Catch: Throwable -> L8
        if (serviceRecord.permission != null) goto L13;
    L15:
        int r2 = 10;
    L16:
        start.setReason(r2);     // Catch: Throwable -> L8
        if (serviceRecord.intent == null) goto L19;
        start.setIntent(serviceRecord.intent.getIntent());     // Catch: Throwable -> L8
    L19:
        addStartInfoLocked(start);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L13:
        if (serviceRecord.permission.contains("android.permission.BIND_JOB_SERVICE") == false) goto L15;
        r2 = 5;
        goto L16
    }

    public void handleProcessBroadcastStart(long startTimeNs, ProcessRecord app, Intent intent, boolean isAlarm) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.mEnabled == true) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        ApplicationStartInfo start = new ApplicationStartInfo(getMonotonicTimeMs());     // Catch: Throwable -> L8
        addBaseFieldsFromProcessRecord(start, app);     // Catch: Throwable -> L8
        start.setStartupState(0);     // Catch: Throwable -> L8
        start.addStartupTimestamp(0, startTimeNs);     // Catch: Throwable -> L8
        start.setStartType(1);     // Catch: Throwable -> L8
        if (isAlarm == false) goto L13;
        start.setReason(0);     // Catch: Throwable -> L8
    L14:
        start.setIntent(intent);     // Catch: Throwable -> L8
        start.setStartComponent(2);     // Catch: Throwable -> L8
        addStartInfoLocked(start);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L13:
        start.setReason(3);     // Catch: Throwable -> L8
        goto L14
    }

    public void handleProcessContentProviderStart(long startTimeNs, ProcessRecord app) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.mEnabled == true) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        ApplicationStartInfo start = new ApplicationStartInfo(getMonotonicTimeMs());     // Catch: Throwable -> L8
        addBaseFieldsFromProcessRecord(start, app);     // Catch: Throwable -> L8
        start.setStartupState(0);     // Catch: Throwable -> L8
        start.addStartupTimestamp(0, startTimeNs);     // Catch: Throwable -> L8
        start.setStartType(1);     // Catch: Throwable -> L8
        start.setReason(4);     // Catch: Throwable -> L8
        start.setStartComponent(3);     // Catch: Throwable -> L8
        addStartInfoLocked(start);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
    }

    public void handleProcessBackupStart(long startTimeNs, ProcessRecord app, BackupRecord backupRecord, boolean cold) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.mEnabled == true) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        ApplicationStartInfo start = new ApplicationStartInfo(getMonotonicTimeMs());     // Catch: Throwable -> L8
        addBaseFieldsFromProcessRecord(start, app);     // Catch: Throwable -> L8
        start.setStartupState(0);     // Catch: Throwable -> L8
        start.addStartupTimestamp(0, startTimeNs);     // Catch: Throwable -> L8
        if (cold == false) goto L13;
        int r3 = 1;
    L14:
        start.setStartType(r3);     // Catch: Throwable -> L8
        start.setReason(1);     // Catch: Throwable -> L8
        start.setStartComponent(5);     // Catch: Throwable -> L8
        addStartInfoLocked(start);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L13:
        r3 = 2;
        goto L14
    }

    private void addBaseFieldsFromProcessRecord(ApplicationStartInfo start, ProcessRecord app) {
        if (app != null) goto L4;
        return;
    L4:
        boolean r1 = false;
        if (app.getHostingRecord() == null) goto L7;
        int definingUid = app.getHostingRecord().getDefiningUid();
    L8:
        start.setPid(app.getPid());
        start.setRealUid(app.uid);
        start.setPackageUid(app.info.uid);
        if (definingUid <= 0) goto L11;
        int r2 = definingUid;
    L12:
        start.setDefiningUid(r2);
        start.setProcessName(app.processName);
        start.setPackageName(app.info.packageName);
        WindowProcessController wpc = app.getWindowProcessController();
        if (app.wasForceStopped() == true) goto L19;
        if (wpc != null) goto L16;
    L20:
        start.setForceStopped(r1);
        return;
    L16:
        if (wpc.wasForceStopped() == false) goto L20;
    L19:
        r1 = true;
        goto L20
    L11:
        r2 = app.info.uid;
        goto L12
    L7:
        definingUid = 0;
        goto L8
    }

    void configureDetailedMonitoring(PrintWriter pw, String packageName, int userId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.mEnabled == true) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        forEachPackageLocked(new AppStartInfoTracker$$ExternalSyntheticLambda6());     // Catch: Throwable -> L8
        if (TextUtils.isEmpty(packageName) == false) goto L13;
        pw.println("ActivityManager AppStartInfo detailed monitoring disabled");     // Catch: Throwable -> L8
    L21:
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L13:
        SparseArray<AppStartInfoContainer> array = (SparseArray) this.mData.getMap().get(packageName);     // Catch: Throwable -> L8
        if (array == null) goto L20;
        int i = 0;
    L17:
        if (i >= array.size()) goto L19;
        array.valueAt(i).enableAppMonitoringModeForUser(userId);     // Catch: Throwable -> L8
        i = i + 1;     // Catch: Throwable -> L8
        goto L17
    L19:
        pw.println("ActivityManager AppStartInfo detailed monitoring enabled for " + packageName);     // Catch: Throwable -> L8
        goto L21
    L20:
        pw.println("Package " + packageName + " not found");     // Catch: Throwable -> L8
        goto L21
    }

    private static /* synthetic */ Integer lambda$configureDetailedMonitoring$2(String name, SparseArray records) {
        int i = 0;
    L4:
        if (i >= records.size()) goto L7;
        ((AppStartInfoContainer) records.valueAt(i)).disableAppMonitoringMode();
        i = i + 1;
        goto L4
    L7:
        return 0;
    }

    void addTimestampToStart(ProcessRecord app, long timeNs, int key) {
        addTimestampToStart(app.info.packageName, app.uid, timeNs, key);
    }

    void addTimestampToStart(String packageName, int uid, long timeNs, int key) {
        if (this.mEnabled == true) goto L5;
        return;
    L5:
        Object r0 = this.mLock;
        monitor-enter(r0);
        AppStartInfoContainer container = (AppStartInfoContainer) this.mData.get(packageName, uid);     // Catch: Throwable -> L11
        if (container != null) goto L13;
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L13:
        container.addTimestampToStartLocked(key, timeNs);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    }

    private ApplicationStartInfo addStartInfoLocked(ApplicationStartInfo raw) {
        if (this.mAppStartInfoLoaded.get() == true) goto L6;
        Slog.w(TAG, "Skipping saving the start info due to ongoing loading from storage");
        return null;
    L6:
        ApplicationStartInfo info = new ApplicationStartInfo(raw);
        int uid = raw.getRealUid();
        if (UserHandle.isIsolated(uid) == false) goto L9;
        return null;
    L9:
        AppStartInfoContainer container = (AppStartInfoContainer) this.mData.get(raw.getPackageName(), uid);
        if (container != null) goto L12;
        container = new AppStartInfoContainer(this, this.mAppStartInfoHistoryListSize);
        AppStartInfoContainer.m1385$$Nest$fputmUid(container, uid);
        this.mData.put(raw.getPackageName(), uid, container);
    L12:
        container.addStartInfoLocked(info);
        schedulePersistProcessStartInfo(false);
        return info;
    }

    private void checkCompletenessAndCallback(ApplicationStartInfo startInfo) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (startInfo.getStartupState() != 2) goto L19;
        List<ApplicationStartInfoCompleteCallback> callbacks = this.mCallbacks.get(startInfo.getRealUid());     // Catch: Throwable -> L10
        if (callbacks != null) goto L12;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L12:
        int size = callbacks.size();     // Catch: Throwable -> L10
        int i = 0;
    L13:
        if (i >= size) goto L18;
        if (callbacks.get(i) == null) goto L17;
        callbacks.get(i).onApplicationStartInfoComplete(startInfo);     // Catch: Throwable -> L10
    L17:
        i = i + 1;     // Catch: Throwable -> L10
        goto L13
    L18:
        this.mCallbacks.remove(startInfo.getRealUid());     // Catch: Throwable -> L10
    L19:
        monitor-exit(r0);     // Catch: Throwable -> L10
    }

    void getStartInfo(String packageName, final int filterUid, int filterPid, int maxNum, ArrayList<ApplicationStartInfo> results) {
        if (this.mEnabled == true) goto L5;
        return;
    L5:
        if (maxNum != 0) goto L7;
        maxNum = 16;
    L7:
        long identity = Binder.clearCallingIdentity();
        Object r2 = this.mLock;     // Catch: Throwable -> L30
        monitor-enter(r2);     // Catch: Throwable -> L30
        boolean emptyPackageName = TextUtils.isEmpty(packageName);     // Catch: Throwable -> L15
        if (emptyPackageName == true) goto L18;
        AppStartInfoContainer container = (AppStartInfoContainer) this.mData.get(packageName, filterUid);     // Catch: Throwable -> L15
        if (container == null) goto L25;
        container.getStartInfoLocked(filterPid, maxNum, results);     // Catch: Throwable -> L15
    L25:
        monitor-exit(r2);     // Catch: Throwable -> L15
        Binder.restoreCallingIdentity(identity);
        return;
    L18:
        final ArrayList<ApplicationStartInfo> list = this.mTmpStartInfoList;     // Catch: Throwable -> L15
        list.clear();     // Catch: Throwable -> L15
        forEachPackageLocked(new AppStartInfoTracker$$ExternalSyntheticLambda0(filterUid, list));     // Catch: Throwable -> L15
        Collections.sort(list, new AppStartInfoTracker$$ExternalSyntheticLambda1());     // Catch: Throwable -> L15
        int size = list.size();     // Catch: Throwable -> L15
        if (maxNum <= 0) goto L21;
        size = Math.min(size, maxNum);     // Catch: Throwable -> L15
    L21:
        int i = 0;
    L22:
        if (i >= size) goto L24;
        results.add(list.get(i));     // Catch: Throwable -> L15
        i = i + 1;     // Catch: Throwable -> L15
        goto L22
    L24:
        list.clear();     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        throw th;     // Catch: Throwable -> L30
    L30:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);
        throw th;
    }

    private static /* synthetic */ Integer lambda$getStartInfo$3(int filterUid, ArrayList list, String name, SparseArray records) {
        AppStartInfoContainer container = (AppStartInfoContainer) records.get(filterUid);
        if (container == null) goto L6;
        list.addAll(AppStartInfoContainer.m1384$$Nest$fgetmInfos(container));
    L6:
        return 0;
    }

    private static /* synthetic */ int lambda$getStartInfo$4(ApplicationStartInfo a, ApplicationStartInfo b) {
        return Long.compare(b.getMonotonicCreationTimeMs(), a.getMonotonicCreationTimeMs());
    }

    void addStartInfoCompleteListener(IApplicationStartInfoCompleteListener listener, int uid) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.mEnabled == true) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        ArrayList<ApplicationStartInfoCompleteCallback> callbacks = this.mCallbacks.get(uid);     // Catch: Throwable -> L8
        if (callbacks != null) goto L13;
        SparseArray<ArrayList<ApplicationStartInfoCompleteCallback>> r2 = this.mCallbacks;     // Catch: Throwable -> L8
        ArrayList<ApplicationStartInfoCompleteCallback> r3 = new ArrayList();     // Catch: Throwable -> L8
        callbacks = r3;
        r2.set(uid, r3);     // Catch: Throwable -> L8
    L13:
        callbacks.add(new ApplicationStartInfoCompleteCallback(this, listener, uid));     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
    }

    void removeStartInfoCompleteListener(IApplicationStartInfoCompleteListener listener, int uid, boolean unlinkDeathRecipient) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.mEnabled == true) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        ArrayList<ApplicationStartInfoCompleteCallback> callbacks = this.mCallbacks.get(uid);     // Catch: Throwable -> L8
        if (callbacks != null) goto L14;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L14:
        int size = callbacks.size();     // Catch: Throwable -> L8
        int index = 0;
    L15:
        if (index >= size) goto L21;
        ApplicationStartInfoCompleteCallback callback = callbacks.get(index);     // Catch: Throwable -> L8
        if (ApplicationStartInfoCompleteCallback.m1386$$Nest$fgetmCallback(callback) == listener) goto L18;
        index = index + 1;     // Catch: Throwable -> L8
        goto L15
    L18:
        if (unlinkDeathRecipient == false) goto L21;
        callback.unlinkToDeath();     // Catch: Throwable -> L8
    L21:
        if (index >= size) goto L24;
        callbacks.remove(index);     // Catch: Throwable -> L8
    L24:
        if (callbacks.isEmpty() == false) goto L26;
        this.mCallbacks.remove(uid);     // Catch: Throwable -> L8
    L26:
        monitor-exit(r0);     // Catch: Throwable -> L8
    }

    private boolean forEachPackageLocked(BiFunction<String, SparseArray<AppStartInfoContainer>, Integer> callback) {
        if (callback == null) goto L14;
        ArrayMap<String, SparseArray<AppStartInfoContainer>> map = this.mData.getMap();
        int i = map.size() - 1;
    L5:
        if (i < 0) goto L14;
        switch(callback.apply(map.keyAt(i), map.valueAt(i)).intValue()) {
            case 1: goto L12;
            case 2: goto L11;
            case 3: goto L9;
            default: goto L13;
        };
    L12:
        map.removeAt(i);
        goto L13
    L9:
        map.removeAt(i);
        return false;
    L11:
        return false;
    L13:
        i = i - 1;
    L14:
        return true;
    }

    private void removePackageLocked(String packageName, int uid, boolean removeUid, int userId) {
        ArrayMap<String, SparseArray<AppStartInfoContainer>> map = this.mData.getMap();
        SparseArray<AppStartInfoContainer> array = map.get(packageName);
        if (array != null) goto L6;
        return;
    L6:
        if (userId != (-1)) goto L8;
        this.mData.getMap().remove(packageName);
        return;
    L8:
        int i = array.size() - 1;
    L9:
        if (i < 0) goto L14;
        if (UserHandle.getUserId(array.keyAt(i)) == userId) goto L12;
        i = i - 1;
        goto L9
    L12:
        array.removeAt(i);
    L14:
        int i2 = array.size();
        if (i2 != 0) goto L21;
        map.remove(packageName);
        return;
    }

    private void removeByUserIdLocked(final int userId) {
        if (userId != (-1)) goto L6;
        this.mData.getMap().clear();
        return;
    L6:
        forEachPackageLocked(new AppStartInfoTracker$$ExternalSyntheticLambda4(userId));
    }

    private static /* synthetic */ Integer lambda$removeByUserIdLocked$5(int userId, String packageName, SparseArray records) {
        int r1 = 1;
        int i = records.size() - 1;
    L3:
        if (i < 0) goto L8;
        if (UserHandle.getUserId(records.keyAt(i)) == userId) goto L6;
        i = i - 1;
        goto L3
    L6:
        records.removeAt(i);
    L8:
        int i2 = records.size();
        if (i2 == 0) goto L13;
        r1 = 0;
    L13:
        return Integer.valueOf(r1);
    }

    void onUserRemoved(int userId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.mEnabled == true) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        removeByUserIdLocked(userId);     // Catch: Throwable -> L8
        schedulePersistProcessStartInfo(true);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
    }

    void onPackageRemoved(String packageName, int uid, boolean allUsers) {
        if (this.mEnabled == true) goto L5;
        return;
    L5:
        if (packageName == null) goto L17;
        boolean removeUid = TextUtils.isEmpty(this.mService.mPackageManagerInt.getNameForUid(uid));
        Object r1 = this.mLock;
        monitor-enter(r1);
        if (allUsers == false) goto L18;
        int r2 = -1;
    L11:
        removePackageLocked(packageName, uid, removeUid, r2);     // Catch: Throwable -> L14
        schedulePersistProcessStartInfo(true);     // Catch: Throwable -> L14
        monitor-exit(r1);     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        throw th;
    L18:
        r2 = UserHandle.getUserId(uid);     // Catch: Throwable -> L14
        goto L11
    }

    private void registerForUserRemoval() {
        IntentFilter filter = new IntentFilter();
        filter.addAction("android.intent.action.USER_REMOVED");
        this.mService.mContext.registerReceiverForAllUsers(new AnonymousClass1(this), filter, null, this.mHandler);
    }

    private void registerForPackageRemoval() {
        IntentFilter filter = new IntentFilter();
        filter.addAction("android.intent.action.PACKAGE_REMOVED");
        filter.addDataScheme(Settings.ATTR_PACKAGE);
        this.mService.mContext.registerReceiverForAllUsers(new AnonymousClass2(this), filter, null, this.mHandler);
    }

    void loadExistingProcessStartInfo() {
        if (this.mEnabled == true) goto L6;
        return;
    L6:
        if (this.mProcStartInfoFile.canRead() == true) goto L9;
        this.mAppStartInfoLoaded.set(true);
        return;
    L9:
        FileInputStream fin = null;
        AtomicFile af = new AtomicFile(this.mProcStartInfoFile);     // Catch: Throwable -> L16 Throwable -> L18
        fin = af.openRead();     // Catch: Throwable -> L16 Throwable -> L18
        ProtoInputStream proto = new ProtoInputStream(fin);     // Catch: Throwable -> L16 Throwable -> L18
        int next = proto.nextField();     // Catch: Throwable -> L16 Throwable -> L18
    L12:
        if (next == (-1)) goto L32;
        switch(next) {
            case 1: goto L21;
            case 2: goto L20;
            case 3: goto L15;
            default: goto L27;
        };     // Catch: Throwable -> L16 Throwable -> L18
    L15:
        long monotonicTime = proto.readLong(1112396529667L);     // Catch: Throwable -> L16 Throwable -> L18
        this.mMonotonicClock = new MonotonicClock(monotonicTime, Clock.SYSTEM_CLOCK);     // Catch: Throwable -> L16 Throwable -> L18
        goto L27
    L20:
        loadPackagesFromProto(proto, next);     // Catch: Throwable -> L16 Throwable -> L18
        goto L27
    L21:
        Object r5 = this.mLock;     // Catch: Throwable -> L16 Throwable -> L18
        monitor-enter(r5);     // Catch: Throwable -> L16 Throwable -> L18
        this.mLastAppStartInfoPersistTimestamp = proto.readLong(1112396529665L);     // Catch: Throwable -> L28
        monitor-exit(r5);     // Catch: Throwable -> L28
    L28:
        th = move-exception;
        throw th;     // Catch: Throwable -> L16 Throwable -> L18 Throwable -> L18 Throwable -> L18 Throwable -> L18
    L27:
        next = proto.nextField();     // Catch: Throwable -> L16 Throwable -> L18 Throwable -> L18 Throwable -> L18 Throwable -> L18
        goto L12
    L32:
        if (fin == null) goto L42;
        fin.close();     // Catch: IOException -> L35
    L54:
    L16:
        th = move-exception;
        if (fin != null) goto L49;
    L48:
        throw th;
    L49:
        fin.close();     // Catch: IOException -> L47
    L18:
        e = move-exception;
        Slog.w(TAG, "Error in loading historical app start info from persistent storage: " + e);     // Catch: Throwable -> L16
        if (fin == null) goto L42;
        fin.close();     // Catch: IOException -> L35
    L42:
        this.mAppStartInfoLoaded.set(true);
    }

    private void loadPackagesFromProto(ProtoInputStream proto, long fieldId) throws IOException, WireTypeMismatchException, ClassNotFoundException {
        long token = proto.start(fieldId);
        String pkgName = "";
        int next = proto.nextField();
    L4:
        if (next == (-1)) goto L20;
        switch(next) {
            case 1: goto L18;
            case 2: goto L7;
            default: goto L6;
        };
    L6:
        ProtoInputStream proto2 = proto;
    L19:
        next = proto2.nextField();
        proto = proto2;
        goto L4
    L7:
        AppStartInfoContainer container = new AppStartInfoContainer(this, this.mAppStartInfoHistoryListSize);
        proto2 = proto;
        int uid = container.readFromProto(proto2, 2246267895810L, pkgName, null, null, null);
        if (UserHandle.isIsolated(uid) == true) goto L19;
        Object r5 = this.mLock;
        monitor-enter(r5);
        this.mData.put(pkgName, uid, container);     // Catch: Throwable -> L15
        monitor-exit(r5);     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        throw th;
    L18:
        proto2 = proto;
        String pkgName2 = proto2.readString(1138166333441L);
        pkgName = pkgName2;
        goto L19
    L20:
        proto.end(token);
    }

    void persistProcessStartInfo() {
        if (this.mEnabled == true) goto L5;
        return;
    L5:
        AtomicFile af = new AtomicFile(this.mProcStartInfoFile);
        FileOutputStream out = null;
        long now = System.currentTimeMillis();
        out = af.startWrite();     // Catch: IOException -> L17
        final ProtoOutputStream proto = new ProtoOutputStream(out);     // Catch: IOException -> L17
        proto.write(1112396529665L, now);     // Catch: IOException -> L17
        final ByteArrayOutputStream byteArrayOutputStream = null;
        final ObjectOutputStream objectOutputStream = null;
        final TypedXmlSerializer typedXmlSerializer = null;
        Object r8 = this.mLock;     // Catch: IOException -> L17
        monitor-enter(r8);     // Catch: IOException -> L17
        boolean succeeded = forEachPackageLocked(new AppStartInfoTracker$$ExternalSyntheticLambda3(proto, byteArrayOutputStream, objectOutputStream, typedXmlSerializer));     // Catch: Throwable -> L11
        if (succeeded == false) goto L13;
        this.mLastAppStartInfoPersistTimestamp = now;     // Catch: Throwable -> L11
    L13:
        monitor-exit(r8);     // Catch: Throwable -> L11
        proto.write(1112396529667L, getMonotonicTimeMs());     // Catch: IOException -> L17
        if (succeeded == false) goto L19;
        proto.flush();     // Catch: IOException -> L17
        af.finishWrite(out);     // Catch: IOException -> L17
    L24:
        Object r4 = this.mLock;
        monitor-enter(r4);
        this.mAppStartInfoPersistTask = null;     // Catch: Throwable -> L30
        monitor-exit(r4);     // Catch: Throwable -> L30
        return;
    L30:
        th = move-exception;
        throw th;
    L19:
        af.failWrite(out);     // Catch: IOException -> L17
        goto L24
    L11:
        th = move-exception;
        throw th;     // Catch: IOException -> L17
    L17:
        e = move-exception;
        Slog.w(TAG, "Unable to write historical app start info into persistent storage: " + e);
        af.failWrite(out);
        goto L24
    }

    private static /* synthetic */ Integer lambda$persistProcessStartInfo$6(ProtoOutputStream proto, ByteArrayOutputStream byteArrayOutputStream, ObjectOutputStream objectOutputStream, TypedXmlSerializer typedXmlSerializer, String packageName, SparseArray records) {
        long token = proto.start(2246267895810L);
        proto.write(1138166333441L, packageName);
        int uidArraySize = records.size();
        int j = 0;
    L3:
        if (j >= uidArraySize) goto L10;
        ((AppStartInfoContainer) records.valueAt(j)).writeToProto(proto, 2246267895810L, byteArrayOutputStream, objectOutputStream, typedXmlSerializer);     // Catch: IOException -> L7
        j = j + 1;
    L7:
        e = move-exception;
        Slog.w(TAG, "Unable to write app start info into persistentstorage: " + e);
        return 3;
    L10:
        proto.end(token);
        return 0;
    }

    void schedulePersistProcessStartInfo(boolean immediately) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.mEnabled == true) goto L11;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L11:
        if (this.mAppStartInfoPersistTask == null) goto L14;
        if (immediately == true) goto L14;
    L21:
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L14:
        if (this.mAppStartInfoPersistTask == null) goto L16;
        IoThread.getHandler().removeCallbacks(this.mAppStartInfoPersistTask);     // Catch: Throwable -> L8
    L16:
        this.mAppStartInfoPersistTask = new AppStartInfoTracker$$ExternalSyntheticLambda5(this);     // Catch: Throwable -> L8
        Handler r1 = IoThread.getHandler();     // Catch: Throwable -> L8
        Runnable r2 = this.mAppStartInfoPersistTask;     // Catch: Throwable -> L8
        if (immediately == false) goto L19;
        long r3 = 0;
    L20:
        r1.postDelayed(r2, r3);     // Catch: Throwable -> L8
        goto L21
    L19:
        r3 = APP_START_INFO_PERSIST_INTERVAL;     // Catch: Throwable -> L8
        goto L20
    }

    void clearProcessStartInfo(boolean removeFile) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.mEnabled == true) goto L11;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L11:
        if (this.mAppStartInfoPersistTask == null) goto L13;
        IoThread.getHandler().removeCallbacks(this.mAppStartInfoPersistTask);     // Catch: Throwable -> L8
        this.mAppStartInfoPersistTask = null;     // Catch: Throwable -> L8
    L13:
        if (removeFile == true) goto L15;
    L17:
        this.mData.getMap().clear();     // Catch: Throwable -> L8
        this.mInProgressRecords.clear();     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L15:
        if (this.mProcStartInfoFile == null) goto L17;
        this.mProcStartInfoFile.delete();     // Catch: Throwable -> L8
        goto L17
    }

    void clearHistoryProcessStartInfo(String packageName, int userId) {
        if (this.mEnabled == true) goto L5;
        return;
    L5:
        Optional.empty();
        if (TextUtils.isEmpty(packageName) == false) goto L15;
        Object r1 = this.mLock;
        monitor-enter(r1);
        removeByUserIdLocked(userId);     // Catch: Throwable -> L12
        monitor-exit(r1);     // Catch: Throwable -> L12
    L19:
        schedulePersistProcessStartInfo(true);
        return;
    L12:
        th = move-exception;
        throw th;
    L15:
        int uid = this.mService.mPackageManagerInt.getPackageUid(packageName, 131072, userId);
        Optional.of(Integer.valueOf(UserHandle.getAppId(uid)));
        Object r3 = this.mLock;
        monitor-enter(r3);
        removePackageLocked(packageName, uid, true, userId);     // Catch: Throwable -> L21
        monitor-exit(r3);     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        throw th;
    }

    void dumpHistoryProcessStartInfo(final PrintWriter pw, String packageName) {
        if (this.mEnabled == true) goto L5;
        return;
    L5:
        pw.println("ACTIVITY MANAGER LRU PROCESSES (dumpsys activity start-info)");
        final SimpleDateFormat sdf = new SimpleDateFormat();
        Object r7 = this.mLock;
        monitor-enter(r7);
        pw.println("Last Timestamp of Persistence Into Persistent Storage: " + sdf.format(new Date(this.mLastAppStartInfoPersistTimestamp)));     // Catch: Throwable -> L20
        if (TextUtils.isEmpty(packageName) == true) goto L29;
        SparseArray<AppStartInfoContainer> array = (SparseArray) this.mData.getMap().get(packageName);     // Catch: Throwable -> L20
        if (array == null) goto L23;
        dumpHistoryProcessStartInfoLocked(pw, "  ", packageName, array, sdf);     // Catch: Throwable -> L18
    L23:
        monitor-exit(r7);     // Catch: Throwable -> L18
        return;
    L29:
        forEachPackageLocked(new AppStartInfoTracker$$ExternalSyntheticLambda8(this, pw, sdf));     // Catch: Throwable -> L11
    L11:
        th = th;
    L25:
        monitor-exit(r7);     // Catch: Throwable -> L18
        throw th;
    L20:
        th = th;
    L18:
        th = th;
        goto L25
    }

    private /* synthetic */ Integer lambda$dumpHistoryProcessStartInfo$7(PrintWriter pw, SimpleDateFormat sdf, String name, SparseArray records) {
        dumpHistoryProcessStartInfoLocked(pw, "  ", name, records, sdf);
        return 0;
    }

    private void dumpHistoryProcessStartInfoLocked(PrintWriter pw, String prefix, String packageName, SparseArray<AppStartInfoContainer> array, SimpleDateFormat sdf) {
        pw.println(prefix + "package: " + packageName);
        int size = array.size();
        int i = 0;
    L3:
        if (i >= size) goto L6;
        pw.println(prefix + "  Historical Process Start for userId=" + array.keyAt(i));
        array.valueAt(i).dumpLocked(pw, prefix + "    ", sdf);
        i = i + 1;
        goto L3
    }

    public long getMonotonicTimeMs() {
        if (this.mMonotonicClock != null) goto L7;
        return 0;
    L7:
        return this.mMonotonicClock.monotonicTime();
    }
}
