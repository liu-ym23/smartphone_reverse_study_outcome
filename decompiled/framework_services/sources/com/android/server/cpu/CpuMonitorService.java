package com.android.server.cpu;

import android.content.Context;
import android.os.Binder;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.SystemClock;
import android.util.IndentingPrintWriter;
import android.util.IntArray;
import android.util.Log;
import android.util.LongSparseArray;
import android.util.SparseArray;
import android.util.SparseArrayMap;
import com.android.internal.util.Preconditions;
import com.android.server.ServiceThread;
import com.android.server.SystemService;
import com.android.server.Watchdog;
import com.android.server.utils.PriorityDump;
import com.android.server.utils.Slogf;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class CpuMonitorService extends SystemService {
    private static final long CACHE_DURATION_MILLISECONDS = 0;
    static final boolean DEBUG = false;
    private static final long DEBUG_MONITORING_INTERVAL_MILLISECONDS = 0;
    static final long DEFAULT_MONITORING_INTERVAL_MILLISECONDS = -1;
    private static final int DELAY_INTERVAL = 5000;
    private static final long LATEST_AVAILABILITY_DURATION_MILLISECONDS = 0;
    private static final int MAX_DELAY_COUNT = 20;
    private static final long NORMAL_MONITORING_INTERVAL_MILLISECONDS = 0;
    private static final long STOP_PERIODIC_CPUSET_READING_DELAY_MILLISECONDS = 0;
    static final String TAG = null;
    private final SparseArrayMap<CpuMonitorInternal.CpuAvailabilityCallback, CpuAvailabilityCallbackInfo> mAvailabilityCallbackInfosByCallbacksByCpuset;
    private final Context mContext;
    private final CpuInfoReader mCpuInfoReader;
    private final SparseArray<CpusetInfo> mCpusetInfosByCpuset;
    private int mCurrentDelayCount;
    private long mCurrentMonitoringIntervalMillis;
    private final long mDebugMonitoringIntervalMillis;
    private Handler mHandler;
    private final HandlerThread mHandlerThread;
    private final long mLatestAvailabilityDurationMillis;
    private final CpuMonitorInternal mLocalService;
    private final Object mLock;
    private final Runnable mMonitorCpuStats;
    private Runnable mMonitorCpuset;
    private final long mNormalMonitoringIntervalMillis;
    private final boolean mShouldDebugMonitor;
    private final long mStopPeriodicCpusetReadingDelayMillis;

    private static final class CpuAvailabilityCallbackInfo {
        public final CpuMonitorInternal.CpuAvailabilityCallback callback;
        public final CpuAvailabilityMonitoringConfig config;
        public final Executor executor;
        public final NotifyCpuAvailabilityChangeRunnable notifyCpuAvailabilityChangeRunnable;
        public final Runnable notifyMonitoringIntervalChangeRunnable;
        public final CpuMonitorService service;

        private final class NotifyCpuAvailabilityChangeRunnable implements Runnable {
            private CpuAvailabilityInfo mCpuAvailabilityInfo;
            private final Object mLock;
            final /* synthetic */ CpuAvailabilityCallbackInfo this$0;

            /* synthetic */ NotifyCpuAvailabilityChangeRunnable(CpuAvailabilityCallbackInfo r1, CpuMonitorServiceIA r2) {
                this(r1);
            }

            private NotifyCpuAvailabilityChangeRunnable(CpuAvailabilityCallbackInfo r1) {
                this.this$0 = r1;
                this.mLock = new Object();
            }

            public void prepare(CpuAvailabilityInfo cpuAvailabilityInfo) {
                Object r0 = this.mLock;
                monitor-enter(r0);
                this.mCpuAvailabilityInfo = cpuAvailabilityInfo;     // Catch: Throwable -> L7
                monitor-exit(r0);     // Catch: Throwable -> L7
                return;
            L7:
                th = move-exception;
                throw th;
            }

            @Override // java.lang.Runnable
            public void run() {
                Object r0 = this.mLock;
                monitor-enter(r0);
                this.this$0.callback.onAvailabilityChanged(this.mCpuAvailabilityInfo);     // Catch: Throwable -> L7
                monitor-exit(r0);     // Catch: Throwable -> L7
                return;
            L7:
                th = move-exception;
                throw th;
            }
        }

        CpuAvailabilityCallbackInfo(CpuMonitorService service, CpuAvailabilityMonitoringConfig config, CpuMonitorInternal.CpuAvailabilityCallback callback, Executor executor) {
            this.notifyMonitoringIntervalChangeRunnable = new AnonymousClass1(this);
            this.notifyCpuAvailabilityChangeRunnable = new NotifyCpuAvailabilityChangeRunnable(this, null);
            this.service = service;
            this.config = config;
            this.callback = callback;
            this.executor = executor;
        }

        public String toString() {
            return "CpuAvailabilityCallbackInfo{config = " + this.config + ", callback = " + this.callback + ", mExecutor = " + this.executor + '}';
        }
    }

    private final class CpuMonitorBinder extends Binder {
        private final PriorityDump.PriorityDumper mPriorityDumper;
        final /* synthetic */ CpuMonitorService this$0;

        /* synthetic */ CpuMonitorBinder(CpuMonitorService r1, CpuMonitorServiceIA r2) {
            this(r1);
        }

        private CpuMonitorBinder(CpuMonitorService r1) {
            this.this$0 = r1;
            this.mPriorityDumper = new AnonymousClass1(this);
        }

        @Override // android.os.Binder
        protected void dump(FileDescriptor fd, PrintWriter pw, String[] args) {
            PriorityDump.dump(this.mPriorityDumper, fd, pw, args);
        }
    }

    private static final class CpusetInfo {
        public final int cpuset;
        private CpuAvailabilityInfo mLatestCpuAvailabilityInfo;
        private final LongSparseArray<Snapshot> mSnapshotsByUptime;

        private static final class Snapshot {
            public long totalNormalizedAvailableCpuFreqKHz;
            public int totalOfflineCpus;
            public long totalOfflineMaxCpuFreqKHz;
            public int totalOnlineCpus;
            public long totalOnlineMaxCpuFreqKHz;
            public final long uptimeMillis;

            Snapshot(long uptimeMillis) {
                this.uptimeMillis = uptimeMillis;
            }

            public void appendCpuInfo(CpuInfoReader.CpuInfo cpuInfo) {
                if (cpuInfo.isOnline == true) goto L6;
                this.totalOfflineCpus++;
                this.totalOfflineMaxCpuFreqKHz += cpuInfo.maxCpuFreqKHz;
                return;
            L6:
                this.totalOnlineCpus++;
                this.totalNormalizedAvailableCpuFreqKHz += cpuInfo.getNormalizedAvailableCpuFreqKHz();
                this.totalOnlineMaxCpuFreqKHz += cpuInfo.maxCpuFreqKHz;
            }

            public int getAverageAvailableCpuFreqPercent() {
                int percent = (int) ((this.totalNormalizedAvailableCpuFreqKHz * 100.0d) / this.totalOnlineMaxCpuFreqKHz);
                if (percent >= 0) goto L6;
                Slogf.wtf(CpuMonitorService.TAG, "Computed negative CPU availability percent(%d) for %s ", new Object[]{Integer.valueOf(percent), toString()});
                return 0;
            L6:
                return percent;
            }

            public String toString() {
                return "Snapshot{uptimeMillis = " + this.uptimeMillis + ", totalOnlineCpus = " + this.totalOnlineCpus + ", totalOfflineCpus = " + this.totalOfflineCpus + ", totalNormalizedAvailableCpuFreqKHz = " + this.totalNormalizedAvailableCpuFreqKHz + ", totalOnlineMaxCpuFreqKHz = " + this.totalOnlineMaxCpuFreqKHz + ", totalOfflineMaxCpuFreqKHz = " + this.totalOfflineMaxCpuFreqKHz + '}';
            }
        }

        CpusetInfo(int cpuset) {
            this.cpuset = cpuset;
            this.mSnapshotsByUptime = new LongSparseArray();
        }

        public void appendCpuInfo(long uptimeMillis, CpuInfoReader.CpuInfo cpuInfo) {
            if (CpuMonitorService.m3273$$Nest$smcontainsCpuset(cpuInfo.cpusetCategories, this.cpuset) == true) goto L5;
            return;
        L5:
            Snapshot currentSnapshot = this.mSnapshotsByUptime.get(uptimeMillis);
            if (currentSnapshot != null) goto L12;
            currentSnapshot = new Snapshot(uptimeMillis);
            this.mSnapshotsByUptime.append(uptimeMillis, currentSnapshot);
            if (this.mSnapshotsByUptime.size() <= 0) goto L12;
            if ((uptimeMillis - this.mSnapshotsByUptime.valueAt(0).uptimeMillis) <= CpuMonitorService.m3272$$Nest$sfgetCACHE_DURATION_MILLISECONDS()) goto L12;
            this.mSnapshotsByUptime.removeAt(0);
        L12:
            currentSnapshot.appendCpuInfo(cpuInfo);
        }

        public CpuAvailabilityInfo getLatestCpuAvailabilityInfo() {
            return this.mLatestCpuAvailabilityInfo;
        }

        public void populateLatestCpuAvailabilityInfo(long currentUptimeMillis, long latestAvailabilityDurationMillis) {
            int numSnapshots = this.mSnapshotsByUptime.size();
            if (numSnapshots != 0) goto L6;
            this.mLatestCpuAvailabilityInfo = null;
            return;
        L6:
            Snapshot latestSnapshot = this.mSnapshotsByUptime.valueAt(numSnapshots - 1);
            if (latestSnapshot.uptimeMillis == currentUptimeMillis) goto L14;
            if (CpuMonitorService.DEBUG == false) goto L11;
            Slogf.d(CpuMonitorService.TAG, "Skipping stale CPU availability information for cpuset %s", new Object[]{CpuAvailabilityMonitoringConfig.toCpusetString(this.cpuset)});
        L11:
            this.mLatestCpuAvailabilityInfo = null;
            return;
        L14:
            if (this.mLatestCpuAvailabilityInfo != null) goto L16;
        L18:
            long earliestUptimeMillis = currentUptimeMillis - latestAvailabilityDurationMillis;
            this.mLatestCpuAvailabilityInfo = new CpuAvailabilityInfo(this.cpuset, latestSnapshot.uptimeMillis, latestSnapshot.getAverageAvailableCpuFreqPercent(), getCumulativeAvgAvailabilityPercent(earliestUptimeMillis), latestAvailabilityDurationMillis);
            return;
        L16:
            if (this.mLatestCpuAvailabilityInfo.dataTimestampUptimeMillis != latestSnapshot.uptimeMillis) goto L18;
        }

        public int getPrevCpuAvailabilityPercent() {
            int numSnapshots = this.mSnapshotsByUptime.size();
            if (numSnapshots >= 2) goto L7;
            return -1;
        L7:
            return this.mSnapshotsByUptime.valueAt(numSnapshots - 2).getAverageAvailableCpuFreqPercent();
        }

        private int getCumulativeAvgAvailabilityPercent(long earliestUptimeMillis) {
            long totalAvailableCpuFreqKHz = 0;
            long totalOnlineMaxCpuFreqKHz = 0;
            int totalAccountedSnapshots = 0;
            long earliestSeenUptimeMillis = Long.MAX_VALUE;
            int i = this.mSnapshotsByUptime.size() - 1;
        L3:
            if (i < 0) goto L9;
            Snapshot snapshot = this.mSnapshotsByUptime.valueAt(i);
            earliestSeenUptimeMillis = snapshot.uptimeMillis;
            if (snapshot.uptimeMillis <= earliestUptimeMillis) goto L9;
            totalAccountedSnapshots = totalAccountedSnapshots + 1;
            totalAvailableCpuFreqKHz = totalAvailableCpuFreqKHz + snapshot.totalNormalizedAvailableCpuFreqKHz;
            totalOnlineMaxCpuFreqKHz = totalOnlineMaxCpuFreqKHz + snapshot.totalOnlineMaxCpuFreqKHz;
            i = i - 1;
        L9:
            if (earliestSeenUptimeMillis <= earliestUptimeMillis) goto L11;
            return -1;
        L11:
            if (totalAccountedSnapshots >= 2) goto L14;
            return -1;
        L14:
            return (int) ((totalAvailableCpuFreqKHz * 100.0d) / totalOnlineMaxCpuFreqKHz);
        }

        public void clear() {
            this.mLatestCpuAvailabilityInfo = null;
            this.mSnapshotsByUptime.clear();
        }

        public String toString() {
            return "CpusetInfo{cpuset = " + CpuAvailabilityMonitoringConfig.toCpusetString(this.cpuset) + ", mSnapshotsByUptime = " + this.mSnapshotsByUptime + ", mLatestCpuAvailabilityInfo = " + this.mLatestCpuAvailabilityInfo + '}';
        }
    }

    public static /* synthetic */ void $r8$lambda$5b7hWobM0wDK4hsjD37skajm2e8(CpuMonitorService r0) {
        r0.monitorCpuStats();
    }

    public static /* synthetic */ void $r8$lambda$TV0CVirPDbqD4sfaM3usT_B8O50(CpuMonitorService r0) {
        r0.lambda$onBootPhase$0();
    }

    public static /* synthetic */ void $r8$lambda$yhw1p2fEy0d9XrfYZa7jeG2YtJc(IndentingPrintWriter r0, CpuAvailabilityCallbackInfo r1) {
        lambda$doDump$1(r0, r1);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmAvailabilityCallbackInfosByCallbacksByCpuset, reason: not valid java name */
    static /* bridge */ /* synthetic */ SparseArrayMap m3261$$Nest$fgetmAvailabilityCallbackInfosByCallbacksByCpuset(CpuMonitorService r0) {
        return r0.mAvailabilityCallbackInfosByCallbacksByCpuset;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmContext, reason: not valid java name */
    static /* bridge */ /* synthetic */ Context m3262$$Nest$fgetmContext(CpuMonitorService r0) {
        return r0.mContext;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmCpuInfoReader, reason: not valid java name */
    static /* bridge */ /* synthetic */ CpuInfoReader m3263$$Nest$fgetmCpuInfoReader(CpuMonitorService r0) {
        return r0.mCpuInfoReader;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmCurrentDelayCount, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m3264$$Nest$fgetmCurrentDelayCount(CpuMonitorService r0) {
        return r0.mCurrentDelayCount;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmHandler, reason: not valid java name */
    static /* bridge */ /* synthetic */ Handler m3265$$Nest$fgetmHandler(CpuMonitorService r0) {
        return r0.mHandler;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m3266$$Nest$fgetmLock(CpuMonitorService r0) {
        return r0.mLock;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmCurrentDelayCount, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3267$$Nest$fputmCurrentDelayCount(CpuMonitorService r0, int r1) {
        r0.mCurrentDelayCount = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$masyncNotifyMonitoringIntervalChangeToClient, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3268$$Nest$masyncNotifyMonitoringIntervalChangeToClient(CpuMonitorService r0, CpuAvailabilityCallbackInfo r1) {
        r0.asyncNotifyMonitoringIntervalChangeToClient(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mcheckAndStopMonitoringLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3269$$Nest$mcheckAndStopMonitoringLocked(CpuMonitorService r0) {
        r0.checkAndStopMonitoringLocked();
    }

    /* JADX INFO: renamed from: -$$Nest$mdoDump, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3270$$Nest$mdoDump(CpuMonitorService r0, IndentingPrintWriter r1) {
        r0.doDump(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mnewCallbackInfoLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ CpuAvailabilityCallbackInfo m3271$$Nest$mnewCallbackInfoLocked(CpuMonitorService r0, CpuAvailabilityMonitoringConfig r1, CpuMonitorInternal.CpuAvailabilityCallback r2, Executor r3) {
        return r0.newCallbackInfoLocked(r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetCACHE_DURATION_MILLISECONDS, reason: not valid java name */
    static /* bridge */ /* synthetic */ long m3272$$Nest$sfgetCACHE_DURATION_MILLISECONDS() {
        return CACHE_DURATION_MILLISECONDS;
    }

    /* JADX INFO: renamed from: -$$Nest$smcontainsCpuset, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m3273$$Nest$smcontainsCpuset(int r0, int r1) {
        return containsCpuset(r0, r1);
    }

    static {
        TAG = CpuMonitorService.class.getSimpleName();
        DEBUG = Log.isLoggable(TAG, 3);
        NORMAL_MONITORING_INTERVAL_MILLISECONDS = TimeUnit.SECONDS.toMillis(5);
        DEBUG_MONITORING_INTERVAL_MILLISECONDS = TimeUnit.MINUTES.toMillis(1);
        if (Build.IS_USERDEBUG == false) goto L5;
    L8:
        long r3 = TimeUnit.MINUTES.toMillis(30);
    L9:
        CACHE_DURATION_MILLISECONDS = r3;
        LATEST_AVAILABILITY_DURATION_MILLISECONDS = TimeUnit.SECONDS.toMillis(30);
        STOP_PERIODIC_CPUSET_READING_DELAY_MILLISECONDS = TimeUnit.MINUTES.toMillis(2);
        return;
    L5:
        if (Build.IS_ENG == true) goto L8;
        r3 = TimeUnit.MINUTES.toMillis(10);
        goto L9
    }

    public CpuMonitorService(Context context) {
        CpuInfoReader r2 = new CpuInfoReader();
        boolean r4 = true;
        ServiceThread r3 = new ServiceThread(TAG, 10, true);
        if (Build.IS_USERDEBUG == false) goto L5;
    L8:
        this(context, r2, r3, r4, NORMAL_MONITORING_INTERVAL_MILLISECONDS, DEBUG_MONITORING_INTERVAL_MILLISECONDS, LATEST_AVAILABILITY_DURATION_MILLISECONDS, STOP_PERIODIC_CPUSET_READING_DELAY_MILLISECONDS);
        return;
    L5:
        if (Build.IS_ENG == true) goto L8;
        r4 = false;
        goto L8
    }

    CpuMonitorService(Context context, CpuInfoReader cpuInfoReader, HandlerThread handlerThread, boolean shouldDebugMonitor, long normalMonitoringIntervalMillis, long debugMonitoringIntervalMillis, long latestAvailabilityDurationMillis, long stopPeriodicCpusetReadingDelayMillis) {
        super(context);
        this.mLock = new Object();
        this.mMonitorCpuStats = new CpuMonitorService$$ExternalSyntheticLambda2(this);
        this.mCurrentMonitoringIntervalMillis = -1;
        this.mCurrentDelayCount = 0;
        this.mLocalService = new AnonymousClass1(this);
        this.mContext = context;
        this.mHandlerThread = handlerThread;
        this.mShouldDebugMonitor = shouldDebugMonitor;
        this.mNormalMonitoringIntervalMillis = normalMonitoringIntervalMillis;
        this.mDebugMonitoringIntervalMillis = debugMonitoringIntervalMillis;
        this.mLatestAvailabilityDurationMillis = latestAvailabilityDurationMillis;
        this.mStopPeriodicCpusetReadingDelayMillis = stopPeriodicCpusetReadingDelayMillis;
        this.mCpuInfoReader = cpuInfoReader;
        this.mCpusetInfosByCpuset = new SparseArray(2);
        this.mCpusetInfosByCpuset.append(1, new CpusetInfo(1));
        this.mCpusetInfosByCpuset.append(2, new CpusetInfo(2));
        this.mAvailabilityCallbackInfosByCallbacksByCpuset = new SparseArrayMap();
    }

    @Override // com.android.server.SystemService
    public void onStart() {
        if (this.mCpuInfoReader.init() == true) goto L5;
    L21:
        Slogf.wtf(TAG, "Failed to initialize CPU info reader. This happens when the CPU frequency stats are not available or the sysfs interface has changed in the Kernel. Cannot monitor CPU without these stats. Terminating CPU monitor service");
        return;
    L5:
        if (this.mCpuInfoReader.readCpuInfos() == null) goto L21;
        this.mHandlerThread.start();
        this.mHandler = new Handler(this.mHandlerThread.getLooper());
        publishLocalService(CpuMonitorInternal.class, this.mLocalService);
        publishBinderService("cpu_monitor", new CpuMonitorBinder(this, null), false, 1);
        Watchdog.getInstance().addThread(this.mHandler);
        Object r0 = this.mLock;
        monitor-enter(r0);
    L14:
        th = move-exception;
        throw th;
    L10:
        if (this.mShouldDebugMonitor == true) goto L12;
    L16:
        monitor-exit(r0);     // Catch: Throwable -> L14
        this.mMonitorCpuset = new AnonymousClass2(this);
        this.mHandler.postDelayed(this.mMonitorCpuset, 5000);
        return;
    L12:
        if (this.mHandler.hasCallbacks(this.mMonitorCpuStats) == true) goto L16;
        this.mCurrentMonitoringIntervalMillis = this.mDebugMonitoringIntervalMillis;     // Catch: Throwable -> L14
        Slogf.i(TAG, "Starting debug monitoring");     // Catch: Throwable -> L14
        this.mHandler.post(this.mMonitorCpuStats);     // Catch: Throwable -> L14
        goto L16
    }

    @Override // com.android.server.SystemService
    public void onBootPhase(int phase) {
        if (phase == 1000) goto L5;
        return;
    L5:
        if (this.mHandler == null) goto L10;
        Slogf.i(TAG, "Stopping periodic cpuset reading on boot complete");
        this.mHandler.postDelayed(new CpuMonitorService$$ExternalSyntheticLambda0(this), this.mStopPeriodicCpusetReadingDelayMillis);
        return;
    }

    private /* synthetic */ void lambda$onBootPhase$0() {
        this.mCpuInfoReader.stopPeriodicCpusetReading();
    }

    long getCurrentMonitoringIntervalMillis() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        long r1 = this.mCurrentMonitoringIntervalMillis;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    private void doDump(final IndentingPrintWriter writer) {
        writer.printf("*%s*\n", new Object[]{getClass().getSimpleName()});
        writer.increaseIndent();
        this.mCpuInfoReader.dump(writer);
        if (this.mShouldDebugMonitor == false) goto L5;
        String r1 = "Yes";
    L6:
        writer.printf("mShouldDebugMonitor = %s\n", new Object[]{r1});
        writer.printf("mNormalMonitoringIntervalMillis = %d\n", new Object[]{Long.valueOf(this.mNormalMonitoringIntervalMillis)});
        writer.printf("mDebugMonitoringIntervalMillis = %d\n", new Object[]{Long.valueOf(this.mDebugMonitoringIntervalMillis)});
        writer.printf("mLatestAvailabilityDurationMillis = %d\n", new Object[]{Long.valueOf(this.mLatestAvailabilityDurationMillis)});
        Object r0 = this.mLock;
        monitor-enter(r0);
        writer.printf("mCurrentMonitoringIntervalMillis = %d\n", new Object[]{Long.valueOf(this.mCurrentMonitoringIntervalMillis)});     // Catch: Throwable -> L11
        if (hasClientCallbacksLocked() == false) goto L14;
        writer.println("CPU availability change callbacks:");     // Catch: Throwable -> L11
        writer.increaseIndent();     // Catch: Throwable -> L11
        this.mAvailabilityCallbackInfosByCallbacksByCpuset.forEach(new CpuMonitorService$$ExternalSyntheticLambda1(writer));     // Catch: Throwable -> L11
        writer.decreaseIndent();     // Catch: Throwable -> L11
    L14:
        if (this.mCpusetInfosByCpuset.size() <= 0) goto L20;
        writer.println("Cpuset infos:");     // Catch: Throwable -> L11
        writer.increaseIndent();     // Catch: Throwable -> L11
        int i = 0;
    L17:
        if (i >= this.mCpusetInfosByCpuset.size()) goto L19;
        writer.printf("%s\n", new Object[]{this.mCpusetInfosByCpuset.valueAt(i)});     // Catch: Throwable -> L11
        i = i + 1;     // Catch: Throwable -> L11
        goto L17
    L19:
        writer.decreaseIndent();     // Catch: Throwable -> L11
    L20:
        monitor-exit(r0);     // Catch: Throwable -> L11
        writer.decreaseIndent();
        return;
    L11:
        th = move-exception;
        throw th;
    L5:
        r1 = "No";
        goto L6
    }

    private static /* synthetic */ void lambda$doDump$1(IndentingPrintWriter writer, CpuAvailabilityCallbackInfo callbackInfo) {
        writer.printf("%s\n", new Object[]{callbackInfo});
    }

    private void monitorCpuStats() {
        long uptimeMillis = SystemClock.uptimeMillis();
        this.mHandler.removeCallbacks(this.mMonitorCpuStats);
        SparseArray<CpuInfoReader.CpuInfo> cpuInfosByCoreId = this.mCpuInfoReader.readCpuInfos();
        if (cpuInfosByCoreId != null) goto L12;
        Slogf.wtf(TAG, "Failed to read CPU info from device");
        Object r3 = this.mLock;
        monitor-enter(r3);
        stopMonitoringCpuStatsLocked();     // Catch: Throwable -> L9
        monitor-exit(r3);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    L12:
        Object r4 = this.mLock;
        monitor-enter(r4);
        int i = 0;
    L42:
    L21:
        th = move-exception;
        throw th;
    L16:
        if (i >= cpuInfosByCoreId.size()) goto L24;
        CpuInfoReader.CpuInfo cpuInfo = cpuInfosByCoreId.valueAt(i);     // Catch: Throwable -> L21
        int j = 0;
    L19:
        if (j >= this.mCpusetInfosByCpuset.size()) goto L23;
        this.mCpusetInfosByCpuset.valueAt(j).appendCpuInfo(uptimeMillis, cpuInfo);     // Catch: Throwable -> L21
        j = j + 1;     // Catch: Throwable -> L21
        goto L19
    L23:
        i = i + 1;     // Catch: Throwable -> L21
        goto L42
    L24:
        int i2 = 0;
    L26:
        if (i2 >= this.mCpusetInfosByCpuset.size()) goto L29;
        CpusetInfo cpusetInfo = this.mCpusetInfosByCpuset.valueAt(i2);     // Catch: Throwable -> L21
        cpusetInfo.populateLatestCpuAvailabilityInfo(uptimeMillis, this.mLatestAvailabilityDurationMillis);     // Catch: Throwable -> L21
        checkClientThresholdsAndNotifyLocked(cpusetInfo);     // Catch: Throwable -> L21
        i2 = i2 + 1;     // Catch: Throwable -> L21
        goto L26
    L29:
        if (this.mCurrentMonitoringIntervalMillis > 0) goto L31;
    L35:
        stopMonitoringCpuStatsLocked();     // Catch: Throwable -> L21
    L36:
        monitor-exit(r4);     // Catch: Throwable -> L21
        return;
    L31:
        if (hasClientCallbacksLocked() == false) goto L33;
    L34:
        this.mHandler.postAtTime(this.mMonitorCpuStats, this.mCurrentMonitoringIntervalMillis + uptimeMillis);     // Catch: Throwable -> L21
        goto L36
    L33:
        if (this.mShouldDebugMonitor == false) goto L35;
        goto L34
    }

    private void checkClientThresholdsAndNotifyLocked(CpusetInfo cpusetInfo) {
        int prevAvailabilityPercent = cpusetInfo.getPrevCpuAvailabilityPercent();
        CpuAvailabilityInfo latestAvailabilityInfo = cpusetInfo.getLatestCpuAvailabilityInfo();
        if (latestAvailabilityInfo == null) goto L24;
        if (prevAvailabilityPercent >= 0) goto L6;
        return;
    L6:
        if (this.mAvailabilityCallbackInfosByCallbacksByCpuset.numElementsForKey(cpusetInfo.cpuset) == 0) goto L31;
        int i = 0;
    L10:
        if (i >= this.mAvailabilityCallbackInfosByCallbacksByCpuset.numMaps()) goto L23;
        int j = 0;
    L13:
        if (j >= this.mAvailabilityCallbackInfosByCallbacksByCpuset.numElementsForKeyAt(i)) goto L21;
        CpuAvailabilityCallbackInfo callbackInfo = (CpuAvailabilityCallbackInfo) this.mAvailabilityCallbackInfosByCallbacksByCpuset.valueAt(i, j);
        if (callbackInfo.config.cpuset != cpusetInfo.cpuset) goto L20;
        if (didCrossAnyThreshold(prevAvailabilityPercent, latestAvailabilityInfo.latestAvgAvailabilityPercent, callbackInfo.config.getThresholds()) == false) goto L20;
        asyncNotifyCpuAvailabilityToClient(latestAvailabilityInfo, callbackInfo);
    L20:
        j = j + 1;
        goto L13
    L21:
        i = i + 1;
        goto L10
    L23:
        return;
    L31:
        return;
    }

    private void asyncNotifyMonitoringIntervalChangeToClient(CpuAvailabilityCallbackInfo callbackInfo) {
        if (callbackInfo.executor != null) goto L5;
        this.mHandler.post(callbackInfo.notifyMonitoringIntervalChangeRunnable);
        return;
    L5:
        callbackInfo.executor.execute(callbackInfo.notifyMonitoringIntervalChangeRunnable);
    }

    private void asyncNotifyCpuAvailabilityToClient(CpuAvailabilityInfo availabilityInfo, CpuAvailabilityCallbackInfo callbackInfo) {
        callbackInfo.notifyCpuAvailabilityChangeRunnable.prepare(availabilityInfo);
        if (callbackInfo.executor != null) goto L5;
        this.mHandler.post(callbackInfo.notifyCpuAvailabilityChangeRunnable);
        return;
    L5:
        callbackInfo.executor.execute(callbackInfo.notifyCpuAvailabilityChangeRunnable);
    }

    private CpuAvailabilityCallbackInfo newCallbackInfoLocked(CpuAvailabilityMonitoringConfig config, CpuMonitorInternal.CpuAvailabilityCallback callback, Executor executor) {
        CpuAvailabilityCallbackInfo callbackInfo = new CpuAvailabilityCallbackInfo(this, config, callback, executor);
        String cpusetStr = CpuAvailabilityMonitoringConfig.toCpusetString(callbackInfo.config.cpuset);
        CpusetInfo cpusetInfo = this.mCpusetInfosByCpuset.get(callbackInfo.config.cpuset);
        if (cpusetInfo == null) goto L5;
        boolean r3 = true;
    L6:
        Preconditions.checkState(r3, "Missing cpuset info for cpuset %s", new Object[]{cpusetStr});
        boolean hasExistingClientCallbacks = hasClientCallbacksLocked();
        this.mAvailabilityCallbackInfosByCallbacksByCpuset.add(callbackInfo.config.cpuset, callbackInfo.callback, callbackInfo);
        if (DEBUG == false) goto L9;
        Slogf.d(TAG, "Added a CPU availability callback: %s", new Object[]{callbackInfo});
    L9:
        CpuAvailabilityInfo latestInfo = cpusetInfo.getLatestCpuAvailabilityInfo();
        if (latestInfo == null) goto L12;
        asyncNotifyCpuAvailabilityToClient(latestInfo, callbackInfo);
    L12:
        if (hasExistingClientCallbacks == true) goto L14;
    L16:
        this.mHandler.removeCallbacks(this.mMonitorCpuStats);
        this.mCurrentMonitoringIntervalMillis = this.mNormalMonitoringIntervalMillis;
        this.mHandler.post(this.mMonitorCpuStats);
        return callbackInfo;
    L14:
        if (this.mHandler.hasCallbacks(this.mMonitorCpuStats) == false) goto L16;
        return callbackInfo;
    L5:
        r3 = false;
        goto L6
    }

    private void checkAndStopMonitoringLocked() {
        if (hasClientCallbacksLocked() == false) goto L6;
        return;
    L6:
        if (this.mShouldDebugMonitor == true) goto L8;
        stopMonitoringCpuStatsLocked();
        return;
    L8:
        if (DEBUG == false) goto L10;
        Slogf.e(TAG, "Switching to debug monitoring");
    L10:
        this.mCurrentMonitoringIntervalMillis = this.mDebugMonitoringIntervalMillis;
    }

    private boolean hasClientCallbacksLocked() {
        int i = 0;
    L4:
        if (i >= this.mAvailabilityCallbackInfosByCallbacksByCpuset.numMaps()) goto L10;
        if (this.mAvailabilityCallbackInfosByCallbacksByCpuset.numElementsForKeyAt(i) > 0) goto L7;
        i = i + 1;
        goto L4
    L7:
        return true;
    L10:
        return false;
    }

    private void stopMonitoringCpuStatsLocked() {
        this.mHandler.removeCallbacks(this.mMonitorCpuStats);
        this.mCurrentMonitoringIntervalMillis = -1;
        int i = 0;
    L4:
        if (i >= this.mCpusetInfosByCpuset.size()) goto L7;
        this.mCpusetInfosByCpuset.valueAt(i).clear();
        i = i + 1;
        goto L4
    }

    private static boolean containsCpuset(int cpusetCategories, int expectedCpuset) {
        switch(expectedCpuset) {
            case 1: goto L12;
            case 2: goto L7;
            default: goto L4;
        };
    L4:
        Slogf.wtf(TAG, "Provided invalid expectedCpuset %d", new Object[]{Integer.valueOf(expectedCpuset)});
        return false;
    L7:
        if ((cpusetCategories & 2) == 0) goto L10;
        return true;
    L10:
        return false;
    L12:
        if ((cpusetCategories & 1) == 0) goto L15;
        return true;
    L15:
        return false;
    }

    private static boolean didCrossAnyThreshold(int prevAvailabilityPercent, int curAvailabilityPercent, IntArray thresholds) {
        if (prevAvailabilityPercent != curAvailabilityPercent) goto L5;
        return false;
    L5:
        int i = 0;
    L7:
        if (i >= thresholds.size()) goto L17;
        int threshold = thresholds.get(i);
        if (prevAvailabilityPercent >= threshold) goto L12;
        if (curAvailabilityPercent < threshold) goto L12;
        return true;
    L12:
        if (prevAvailabilityPercent < threshold) goto L15;
        if (curAvailabilityPercent >= threshold) goto L15;
        return true;
    L15:
        i = i + 1;
        goto L7
    L17:
        return false;
    }
}
