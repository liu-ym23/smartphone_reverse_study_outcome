package com.android.server.am;

import android.app.ActivityThread;
import android.app.IApplicationThread;
import android.app.ProfilerInfo;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Binder;
import android.os.Build;
import android.os.Debug;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.os.SystemClock;
import android.os.SystemProperties;
import android.os.UserHandle;
import android.provider.DeviceConfig;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.DebugUtils;
import android.util.FeatureFlagUtils;
import android.util.Pair;
import android.util.Slog;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.util.StatsEvent;
import android.util.proto.ProtoOutputStream;
import com.android.internal.app.ProcessMap;
import com.android.internal.os.BackgroundThread;
import com.android.internal.os.BinderInternal;
import com.android.internal.os.ProcessCpuTracker;
import com.android.internal.util.FrameworkStatsLog;
import com.android.internal.util.MemInfoReader;
import com.android.internal.util.QuickSelect;
import com.android.server.SysOptBridge;
import com.android.server.pm.PackageManagerService;
import com.android.server.power.stats.BatteryStatsImpl;
import com.android.server.slice.SliceClientPermissions;
import com.android.server.storage.DeviceStorageMonitorServiceSmtEx;
import com.android.server.utils.PriorityDump;
import com.android.server.wm.ActivityTaskManagerDebugConfig;
import com.android.server.wm.ActivityTaskManagerInternal;
import com.android.server.wm.WindowProcessController;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Consumer;
import java.util.function.Predicate;

/* JADX INFO: loaded from: classes.dex */
public class AppProfiler {
    private static final String ACTION_HEAP_DUMP_FINISHED = "com.android.internal.intent.action.HEAP_DUMP_FINISHED";
    static final String ACTIVITY_START_PSS_DEFER_CONFIG = "activity_start_pss_defer";
    static final long BATTERY_STATS_TIME = 1800000;
    private static final String EXTRA_HEAP_DUMP_IS_USER_INITIATED = "com.android.internal.extra.heap_dump.IS_USER_INITIATED";
    private static final String EXTRA_HEAP_DUMP_PROCESS_NAME = "com.android.internal.extra.heap_dump.PROCESS_NAME";
    private static final String EXTRA_HEAP_DUMP_REPORT_PACKAGE = "com.android.internal.extra.heap_dump.REPORT_PACKAGE";
    private static final String EXTRA_HEAP_DUMP_SIZE_BYTES = "com.android.internal.extra.heap_dump.SIZE_BYTES";
    static final long MONITOR_CPU_MAX_TIME = 268435455;
    static final long MONITOR_CPU_MIN_TIME = 5000;
    static final boolean MONITOR_CPU_USAGE = true;
    static final boolean MONITOR_THREAD_CPU_USAGE = false;
    private static final String TAG = "ActivityManager";
    static final String TAG_OOM_ADJ = "ActivityManager";
    static final String TAG_PSS = "ActivityManager";
    static final String TAG_RSS = "ActivityManager";
    private static int getPssMaxCount;
    private static int getPssMaxDelayTime;
    private final AtomicInteger mActivityStartingNesting;
    private boolean mAllowLowerMemLevel;
    private Map<String, String> mAppAgentMap;
    private final Handler mBgHandler;
    final CachedAppsWatermarkData mCachedAppsWatermarkData;
    private boolean mFullPssOrRssPending;
    boolean mHasHomeProcess;
    boolean mHasPreviousProcess;
    private boolean mIsRequestGetPss;
    private final AtomicLong mLastCpuTime;
    private long mLastFullPssTime;
    private long mLastMemUsageReportTime;
    private int mLastMemoryLevel;
    private int mLastNumProcesses;
    private volatile long mLastWriteTime;
    private final LowMemDetector mLowMemDetector;
    private long mLowRamStartTime;
    private long mLowRamTimeSinceLastIdle;
    private int mMemFactorOverride;
    private int mMemWatchDumpPid;
    private String mMemWatchDumpProcName;
    private int mMemWatchDumpUid;
    private Uri mMemWatchDumpUri;
    private boolean mMemWatchIsUserInitiated;
    private final ProcessMap<Pair<Long, String>> mMemWatchProcesses;
    private final ArrayList<ProcessProfileRecord> mPendingPssOrRssProfiles;
    final ActivityManagerGlobalLock mProcLock;
    private final CountDownLatch mProcessCpuInitLatch;
    private final AtomicBoolean mProcessCpuMutexFree;
    private final Thread mProcessCpuThread;
    public final ProcessCpuTracker mProcessCpuTracker;
    private final ArrayList<ProcessRecord> mProcessesToGc;
    private final ProfileData mProfileData;
    private int mProfileType;
    final Object mProfilerLock;
    private volatile long mPssDeferralTime;
    private final DeviceConfig.OnPropertiesChangedListener mPssDelayConfigListener;
    private final ActivityManagerService mService;
    private final AppProfilerSmtBase mSmtEx;
    private volatile boolean mTestPssOrRssMode;

    private class BgHandler extends Handler {
        static final int COLLECT_PSS_BG_MSG = 1;
        static final int DEFER_PSS_MSG = 2;
        static final int MEMORY_PRESSURE_CHANGED = 4;
        static final int STOP_DEFERRING_PSS_MSG = 3;
        final /* synthetic */ AppProfiler this$0;

        BgHandler(AppProfiler r1, Looper looper) {
            this.this$0 = r1;
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            switch(msg.what) {
                case 1: goto L17;
                case 2: goto L15;
                case 3: goto L14;
                case 4: goto L5;
                default: goto L20;
            };
        L5:
            ActivityManagerService r0 = AppProfiler.m1331$$Nest$fgetmService(this.this$0);
            ActivityManagerService.boostPriorityForLockedSection();
            monitor-enter(r0);
            AppProfiler.m1337$$Nest$mhandleMemoryPressureChangedLocked(this.this$0, msg.arg1, msg.arg2);     // Catch: Throwable -> L10
            monitor-exit(r0);     // Catch: Throwable -> L10
            ActivityManagerService.resetPriorityAfterLockedSection();
        L10:
            th = move-exception;
            ActivityManagerService.resetPriorityAfterLockedSection();
            throw th;
        L14:
            AppProfiler.m1338$$Nest$mstopDeferPss(this.this$0);
            goto L20
        L15:
            AppProfiler.m1336$$Nest$mdeferPssForActivityStart(this.this$0);
        L20:
            SysOptBridge.getFactory().getActivityManager(AppProfiler.m1331$$Nest$fgetmService(this.this$0)).handleBgMessageOpt(msg);
            return;
        L17:
            if (this.this$0.isProfilingPss() == false) goto L19;
            AppProfiler.m1334$$Nest$mcollectPssInBackground(this.this$0);
            goto L20
        L19:
            AppProfiler.m1335$$Nest$mcollectRssInBackground(this.this$0);
            goto L20
        }
    }

    class CachedAppsWatermarkData {
        int mAverageFrozenTimeInSeconds;
        int mBinderProxySnapshot;
        private long[] mCachedAppFrozenDurations;
        int mCachedAppHighWatermark;
        int mCachedInKb;
        private long mEarliestFrozenTimestamp;
        int mFreeInKb;
        int mKernelInKb;
        private long mLatestFrozenTimestamp;
        int mLongestFrozenTimeInSeconds;
        int mMeanFrozenTimeInSeconds;
        int mNumOfFrozenApps;
        int mShortestFrozenTimeInSeconds;
        private long mTotalFrozenDurations;
        int mUptimeInSeconds;
        int mZramInKb;
        final /* synthetic */ AppProfiler this$0;

        public static /* synthetic */ void $r8$lambda$zI0BBTvUIJgiEIeZIL8U6fuo_8Y(CachedAppsWatermarkData r0, long r1, ProcessRecord r3) {
            r0.lambda$updateCachedAppsSnapshot$0(r1, r3);
        }

        CachedAppsWatermarkData(AppProfiler this$0) {
            this.this$0 = this$0;
        }

        void updateCachedAppsHighWatermarkIfNecessaryLocked(int numOfCachedApps, long now) {
            if (numOfCachedApps <= this.mCachedAppHighWatermark) goto L6;
            this.mCachedAppHighWatermark = numOfCachedApps;
            this.mUptimeInSeconds = (int) (now / 1000);
            AppProfiler.m1331$$Nest$fgetmService(this.this$0).mHandler.removeMessages(79);
            AppProfiler.m1331$$Nest$fgetmService(this.this$0).mHandler.obtainMessage(79, Long.valueOf(now)).sendToTarget();
            return;
        }

        void updateCachedAppsSnapshot(final long now) {
            ActivityManagerGlobalLock r0 = this.this$0.mProcLock;
            ActivityManagerService.boostPriorityForProcLockedSection();
            monitor-enter(r0);
            this.mEarliestFrozenTimestamp = now;     // Catch: Throwable -> L9
            this.mLatestFrozenTimestamp = 0;     // Catch: Throwable -> L9
            this.mTotalFrozenDurations = 0;     // Catch: Throwable -> L9
            this.mNumOfFrozenApps = 0;     // Catch: Throwable -> L9
            int lruSize = AppProfiler.m1331$$Nest$fgetmService(this.this$0).mProcessList.getLruSizeLOSP();     // Catch: Throwable -> L9
            if (this.mCachedAppFrozenDurations == null) goto L11;
            if (this.mCachedAppFrozenDurations.length < lruSize) goto L11;
        L12:
            AppProfiler.m1331$$Nest$fgetmService(this.this$0).mProcessList.forEachLruProcessesLOSP(true, new AppProfiler$CachedAppsWatermarkData$$ExternalSyntheticLambda0(this, now));     // Catch: Throwable -> L9
            if (this.mNumOfFrozenApps <= 0) goto L15;
            this.mLongestFrozenTimeInSeconds = (int) ((now - this.mEarliestFrozenTimestamp) / 1000);     // Catch: Throwable -> L9
            this.mShortestFrozenTimeInSeconds = (int) ((now - this.mLatestFrozenTimestamp) / 1000);     // Catch: Throwable -> L9
            this.mAverageFrozenTimeInSeconds = (int) ((this.mTotalFrozenDurations / ((long) this.mNumOfFrozenApps)) / 1000);     // Catch: Throwable -> L9
            this.mMeanFrozenTimeInSeconds = (int) (QuickSelect.select(this.mCachedAppFrozenDurations, 0, this.mNumOfFrozenApps, this.mNumOfFrozenApps / 2) / 1000);     // Catch: Throwable -> L9
        L15:
            this.mBinderProxySnapshot = 0;     // Catch: Throwable -> L9
            SparseIntArray counts = BinderInternal.nGetBinderProxyPerUidCounts();     // Catch: Throwable -> L9
            if (counts == null) goto L23;
            int i = 0;
            int size = counts.size();     // Catch: Throwable -> L9
        L18:
            if (i >= size) goto L23;
            int uid = counts.keyAt(i);     // Catch: Throwable -> L9
            UidRecord uidRec = AppProfiler.m1331$$Nest$fgetmService(this.this$0).mProcessList.getUidRecordLOSP(uid);     // Catch: Throwable -> L9
            if (uidRec == null) goto L22;
            this.mBinderProxySnapshot += counts.valueAt(i);     // Catch: Throwable -> L9
        L22:
            i = i + 1;     // Catch: Throwable -> L9
        L23:
            MemInfoReader memInfo = new MemInfoReader();     // Catch: Throwable -> L9
            memInfo.readMemInfo();     // Catch: Throwable -> L9
            this.mFreeInKb = (int) memInfo.getFreeSizeKb();     // Catch: Throwable -> L9
            this.mCachedInKb = (int) memInfo.getCachedSizeKb();     // Catch: Throwable -> L9
            this.mZramInKb = (int) memInfo.getZramTotalSizeKb();     // Catch: Throwable -> L9
            this.mKernelInKb = (int) memInfo.getKernelUsedSizeKb();     // Catch: Throwable -> L9
            monitor-exit(r0);     // Catch: Throwable -> L9
            ActivityManagerService.resetPriorityAfterProcLockedSection();
            return;
        L11:
            this.mCachedAppFrozenDurations = new long[Math.max(lruSize, AppProfiler.m1331$$Nest$fgetmService(this.this$0).mConstants.CUR_MAX_CACHED_PROCESSES)];     // Catch: Throwable -> L9
        L9:
            th = move-exception;
            ActivityManagerService.resetPriorityAfterProcLockedSection();
            throw th;
        }

        private /* synthetic */ void lambda$updateCachedAppsSnapshot$0(long now, ProcessRecord app) {
            if (app.mOptRecord.isFrozen() == false) goto L12;
            long freezeTime = app.mOptRecord.getFreezeUnfreezeTime();
            if (freezeTime >= this.mEarliestFrozenTimestamp) goto L8;
            this.mEarliestFrozenTimestamp = freezeTime;
        L8:
            if (freezeTime <= this.mLatestFrozenTimestamp) goto L10;
            this.mLatestFrozenTimestamp = freezeTime;
        L10:
            long duration = now - freezeTime;
            this.mTotalFrozenDurations += duration;
            long[] r4 = this.mCachedAppFrozenDurations;
            int r5 = this.mNumOfFrozenApps;
            this.mNumOfFrozenApps = r5 + 1;
            r4[r5] = duration;
            return;
        }

        StatsEvent getCachedAppsHighWatermarkStats(int atomTag, boolean resetAfterPull) {
            ActivityManagerGlobalLock r2 = this.this$0.mProcLock;
            ActivityManagerService.boostPriorityForProcLockedSection();
            monitor-enter(r2);
            StatsEvent event = FrameworkStatsLog.buildStatsEvent(atomTag, this.mCachedAppHighWatermark, this.mUptimeInSeconds, this.mBinderProxySnapshot, this.mFreeInKb, this.mCachedInKb, this.mZramInKb, this.mKernelInKb, this.mNumOfFrozenApps, this.mLongestFrozenTimeInSeconds, this.mShortestFrozenTimeInSeconds, this.mMeanFrozenTimeInSeconds, this.mAverageFrozenTimeInSeconds);     // Catch: Throwable -> L7
            if (resetAfterPull == false) goto L9;
            this.mCachedAppHighWatermark = 0;     // Catch: Throwable -> L7
            this.mUptimeInSeconds = 0;     // Catch: Throwable -> L7
            this.mBinderProxySnapshot = 0;     // Catch: Throwable -> L7
            this.mFreeInKb = 0;     // Catch: Throwable -> L7
            this.mCachedInKb = 0;     // Catch: Throwable -> L7
            this.mZramInKb = 0;     // Catch: Throwable -> L7
            this.mKernelInKb = 0;     // Catch: Throwable -> L7
            this.mNumOfFrozenApps = 0;     // Catch: Throwable -> L7
            this.mLongestFrozenTimeInSeconds = 0;     // Catch: Throwable -> L7
            this.mShortestFrozenTimeInSeconds = 0;     // Catch: Throwable -> L7
            this.mMeanFrozenTimeInSeconds = 0;     // Catch: Throwable -> L7
            this.mAverageFrozenTimeInSeconds = 0;     // Catch: Throwable -> L7
        L9:
            monitor-exit(r2);     // Catch: Throwable -> L7
            ActivityManagerService.resetPriorityAfterProcLockedSection();
            return event;
        L7:
            th = move-exception;
            ActivityManagerService.resetPriorityAfterProcLockedSection();
            throw th;
        }
    }

    class CpuBinder extends Binder {
        private final PriorityDump.PriorityDumper mPriorityDumper;
        final /* synthetic */ AppProfiler this$0;

        CpuBinder(AppProfiler this$0) {
            this.this$0 = this$0;
            this.mPriorityDumper = new AnonymousClass1(this);
        }

        @Override // android.os.Binder
        protected void dump(FileDescriptor fd, PrintWriter pw, String[] args) {
            PriorityDump.dump(this.mPriorityDumper, fd, pw, args);
        }
    }

    private class ProcessCpuThread extends Thread {
        final /* synthetic */ AppProfiler this$0;

        ProcessCpuThread(AppProfiler r1, String name) {
            this.this$0 = r1;
            super(name);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            ProcessCpuTracker r0 = this.this$0.mProcessCpuTracker;
            monitor-enter(r0);
            AppProfiler.m1328$$Nest$fgetmProcessCpuInitLatch(this.this$0).countDown();     // Catch: Throwable -> L25
            this.this$0.mProcessCpuTracker.init();     // Catch: Throwable -> L25
            monitor-exit(r0);     // Catch: Throwable -> L25
        L30:
            monitor-enter(this);     // Catch: Exception -> L19 InterruptedException -> L21
            long now = SystemClock.uptimeMillis();     // Catch: Throwable -> L13
            long nextCpuDelay = (AppProfiler.m1326$$Nest$fgetmLastCpuTime(this.this$0).get() + AppProfiler.MONITOR_CPU_MAX_TIME) - now;     // Catch: Throwable -> L13
            long nextWriteDelay = (AppProfiler.m1327$$Nest$fgetmLastWriteTime(this.this$0) + 1800000) - now;     // Catch: Throwable -> L13
            if (nextWriteDelay >= nextCpuDelay) goto L11;
            nextCpuDelay = nextWriteDelay;
        L11:
            if (nextCpuDelay <= 0) goto L15;
            AppProfiler.m1329$$Nest$fgetmProcessCpuMutexFree(this.this$0).set(true);     // Catch: Throwable -> L13
            wait(nextCpuDelay);     // Catch: Throwable -> L13
        L15:
            monitor-exit(this);     // Catch: Throwable -> L13
        L13:
            th = move-exception;
            throw th;     // Catch: Exception -> L19 InterruptedException -> L21
        L19:
            e = move-exception;
            Slog.e("ActivityManager", "Unexpected exception collecting process stats", e);
        L22:
            this.this$0.updateCpuStatsNow();     // Catch: Exception -> L19
        L25:
            th = th;
        L34:
            throw th;
        L28:
            th = th;
            goto L34
        }
    }

    private class ProfileData {
        private String mProfileApp;
        private ProcessRecord mProfileProc;
        private ProfilerInfo mProfilerInfo;
        final /* synthetic */ AppProfiler this$0;

        /* synthetic */ ProfileData(AppProfiler r1, AppProfilerIA r2) {
            this(r1);
        }

        private ProfileData(AppProfiler r1) {
            this.this$0 = r1;
            this.mProfileApp = null;
            this.mProfileProc = null;
            this.mProfilerInfo = null;
        }

        void setProfileApp(String profileApp) {
            this.mProfileApp = profileApp;
            if (AppProfiler.m1331$$Nest$fgetmService(this.this$0).mAtmInternal == null) goto L6;
            AppProfiler.m1331$$Nest$fgetmService(this.this$0).mAtmInternal.setProfileApp(profileApp);
            return;
        }

        String getProfileApp() {
            return this.mProfileApp;
        }

        void setProfileProc(ProcessRecord profileProc) {
            this.mProfileProc = profileProc;
            if (AppProfiler.m1331$$Nest$fgetmService(this.this$0).mAtmInternal == null) goto L10;
            ActivityTaskManagerInternal r0 = AppProfiler.m1331$$Nest$fgetmService(this.this$0).mAtmInternal;
            if (profileProc != null) goto L7;
            WindowProcessController r1 = null;
        L8:
            r0.setProfileProc(r1);
            return;
        L7:
            r1 = profileProc.getWindowProcessController();
            goto L8
        }

        ProcessRecord getProfileProc() {
            return this.mProfileProc;
        }

        void setProfilerInfo(ProfilerInfo profilerInfo) {
            this.mProfilerInfo = profilerInfo;
            if (AppProfiler.m1331$$Nest$fgetmService(this.this$0).mAtmInternal == null) goto L6;
            AppProfiler.m1331$$Nest$fgetmService(this.this$0).mAtmInternal.setProfilerInfo(profilerInfo);
            return;
        }

        ProfilerInfo getProfilerInfo() {
            return this.mProfilerInfo;
        }
    }

    private final class RecordPssRunnable implements Runnable {
        private final ContentResolver mContentResolver;
        private final Uri mDumpUri;
        private final ProcessProfileRecord mProfile;
        final /* synthetic */ AppProfiler this$0;

        RecordPssRunnable(AppProfiler r1, ProcessProfileRecord profile, Uri dumpUri, ContentResolver contentResolver) {
            this.this$0 = r1;
            this.mProfile = profile;
            this.mDumpUri = dumpUri;
            this.mContentResolver = contentResolver;
        }

        @Override // java.lang.Runnable
        public void run() {
            ParcelFileDescriptor fd = this.mContentResolver.openFileDescriptor(this.mDumpUri, "rw");     // Catch: IOException -> L18
            IApplicationThread thread = this.mProfile.getThread();     // Catch: Throwable -> L10
            if (thread != null) goto L34;
        L15:
            if (fd == null) goto L38;
            fd.close();     // Catch: IOException -> L18
            return;
        L38:
            return;
        L34:
            if (ActivityManagerDebugConfig.DEBUG_PSS == false) goto L14;
            Slog.d("ActivityManager", "Requesting dump heap from " + this.mProfile.mApp + " to " + this.mDumpUri.getPath());     // Catch: Throwable -> L10 RemoteException -> L12
        L14:
            thread.dumpHeap(true, false, false, null, this.mDumpUri.getPath(), fd, null);     // Catch: Throwable -> L10 RemoteException -> L12
        L10:
            th = move-exception;
            if (fd == null) goto L36;
            fd.close();     // Catch: Throwable -> L24
        L37:
            throw th;     // Catch: IOException -> L18
        L24:
            th = move-exception;
            th.addSuppressed(th);     // Catch: IOException -> L18
            throw th;     // Catch: IOException -> L18
        L36:
            throw th;     // Catch: IOException -> L18
        L18:
            e = move-exception;
            Slog.e("ActivityManager", "Failed to dump heap", e);
            AppProfiler.m1333$$Nest$mabortHeapDump(this.this$0, this.mProfile.mApp.processName);
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$5OBAsIN8AUD6oXr1UL23SzYui-A, reason: not valid java name */
    public static /* synthetic */ boolean m1322$r8$lambda$5OBAsIN8AUD6oXr1UL23SzYuiA(ProcessCpuTracker.Stats r0) {
        return lambda$reportMemUsage$5(r0);
    }

    public static /* synthetic */ boolean $r8$lambda$Mu4Mmv7nLKTnNFWY9SGxNTlQQHE(ProcessCpuTracker.Stats r0) {
        return lambda$collectRssInBackground$1(r0);
    }

    /* JADX INFO: renamed from: $r8$lambda$O0KXijwG7-p0M_PB8ZuTBcOSGho, reason: not valid java name */
    public static /* synthetic */ void m1323$r8$lambda$O0KXijwG7p0M_PB8ZuTBcOSGho(ProcessRecord r0) {
        lambda$updateLowMemStateLSP$3(r0);
    }

    /* JADX INFO: renamed from: $r8$lambda$Z9mDQXO9b6I541heYJg3Dye-gv4, reason: not valid java name */
    public static /* synthetic */ void m1324$r8$lambda$Z9mDQXO9b6I541heYJg3Dyegv4(AppProfiler r0, ProcessRecord r1, ArrayList r2, long r3, ProcessRecord r5) {
        r0.lambda$doLowMemReportIfNeededLocked$4(r1, r2, r3, r5);
    }

    /* JADX INFO: renamed from: $r8$lambda$aB4rfrc1k-58zrhIodLdNJI2deY, reason: not valid java name */
    public static /* synthetic */ void m1325$r8$lambda$aB4rfrc1k58zrhIodLdNJI2deY(AppProfiler r0, boolean r1, boolean r2, long r3, ProcessRecord r5) {
        r0.lambda$requestPssAllProcsLPr$2(r1, r2, r3, r5);
    }

    public static /* synthetic */ boolean $r8$lambda$bWbwHOlSw54MLlfLuHPQWGs2h6Y(ProcessCpuTracker.Stats r0) {
        return lambda$collectPssInBackground$0(r0);
    }

    public static /* synthetic */ boolean $r8$lambda$hjeAJXDhcV6uScFkM6n_Owtv5tE(Predicate r0, ProcessCpuTracker.Stats r1) {
        return lambda$getCpuStats$6(r0, r1);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmLastCpuTime, reason: not valid java name */
    static /* bridge */ /* synthetic */ AtomicLong m1326$$Nest$fgetmLastCpuTime(AppProfiler r0) {
        return r0.mLastCpuTime;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmLastWriteTime, reason: not valid java name */
    static /* bridge */ /* synthetic */ long m1327$$Nest$fgetmLastWriteTime(AppProfiler r2) {
        return r2.mLastWriteTime;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmProcessCpuInitLatch, reason: not valid java name */
    static /* bridge */ /* synthetic */ CountDownLatch m1328$$Nest$fgetmProcessCpuInitLatch(AppProfiler r0) {
        return r0.mProcessCpuInitLatch;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmProcessCpuMutexFree, reason: not valid java name */
    static /* bridge */ /* synthetic */ AtomicBoolean m1329$$Nest$fgetmProcessCpuMutexFree(AppProfiler r0) {
        return r0.mProcessCpuMutexFree;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmPssDeferralTime, reason: not valid java name */
    static /* bridge */ /* synthetic */ long m1330$$Nest$fgetmPssDeferralTime(AppProfiler r2) {
        return r2.mPssDeferralTime;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmService, reason: not valid java name */
    static /* bridge */ /* synthetic */ ActivityManagerService m1331$$Nest$fgetmService(AppProfiler r0) {
        return r0.mService;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmPssDeferralTime, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1332$$Nest$fputmPssDeferralTime(AppProfiler r0, long r1) {
        r0.mPssDeferralTime = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$mabortHeapDump, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1333$$Nest$mabortHeapDump(AppProfiler r0, String r1) {
        r0.abortHeapDump(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mcollectPssInBackground, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1334$$Nest$mcollectPssInBackground(AppProfiler r0) {
        r0.collectPssInBackground();
    }

    /* JADX INFO: renamed from: -$$Nest$mcollectRssInBackground, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1335$$Nest$mcollectRssInBackground(AppProfiler r0) {
        r0.collectRssInBackground();
    }

    /* JADX INFO: renamed from: -$$Nest$mdeferPssForActivityStart, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1336$$Nest$mdeferPssForActivityStart(AppProfiler r0) {
        r0.deferPssForActivityStart();
    }

    /* JADX INFO: renamed from: -$$Nest$mhandleMemoryPressureChangedLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1337$$Nest$mhandleMemoryPressureChangedLocked(AppProfiler r0, int r1, int r2) {
        r0.handleMemoryPressureChangedLocked(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mstopDeferPss, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1338$$Nest$mstopDeferPss(AppProfiler r0) {
        r0.stopDeferPss();
    }

    static {
        getPssMaxCount = 10;
        getPssMaxDelayTime = 1000;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v56 */
    /* JADX WARN: Type inference failed for: r0v57 */
    /* JADX WARN: Type inference failed for: r0v78 */
    /* JADX WARN: Type inference failed for: r24v3 */
    /* JADX WARN: Type inference failed for: r24v4 */
    /* JADX WARN: Type inference failed for: r25v4 */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r4v14 */
    /* JADX WARN: Type inference failed for: r4v31 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:196:? -> B:150:0x03aa). Please report as a decompilation issue!!! */
    private void collectPssInBackground() {
        AppProfiler r1 = this;
        long r17 = SystemClock.uptimeMillis();
        Object r3 = r1.mProfilerLock;
        monitor-enter(r3);
        ?? r4 = 0;
        if (r1.mFullPssOrRssPending == false) goto L10;
        r1.mFullPssOrRssPending = false;     // Catch: Throwable -> L8
        MemInfoReader r19 = new MemInfoReader();     // Catch: Throwable -> L8
    L191:
        monitor-exit(r3);     // Catch: Throwable -> L183
        int r2 = 3;
        long[] r5 = new long[3];
        int r6 = 0;
    L13:
        Object r7 = r1.mProfilerLock;
        monitor-enter(r7);
        int r8 = 2;
        if (r1.mPendingPssOrRssProfiles.size() <= 0) goto L19;
        if (r6 >= getPssMaxCount) goto L71;
        ProcessProfileRecord r0 = r1.mPendingPssOrRssProfiles.remove(r4 == true ? 1 : 0);     // Catch: Throwable -> L177
        int r9 = r0.getPssProcState();     // Catch: Throwable -> L177
        int r12 = r0.getPssStatType();     // Catch: Throwable -> L177
        long r10 = r0.getLastPssTime();     // Catch: Throwable -> L177
        long r11 = SystemClock.uptimeMillis();     // Catch: Throwable -> L177
        if (r0.getThread() != null) goto L80;
    L23:
        th = th;
    L189:
        monitor-exit(r7);     // Catch: Throwable -> L181
        throw th;
    L181:
        th = th;
        goto L189
    L78:
        if (r0.mApp.getSmtEx().inFreezeStat() == true) goto L80;
    L85:
        r0.abortNextPssTime();     // Catch: Throwable -> L177
        if (ActivityManagerDebugConfig.DEBUG_PSS == false) goto L90;
        Slog.d("ActivityManager", "Skipped pss collection of -1: still need " + ((r10 + 1000) - r11) + "ms until safe");     // Catch: Throwable -> L23
    L90:
        int r13 = 0;
        ProcessProfileRecord r14 = null;
        ?? r24 = r4;
    L207:
        monitor-exit(r7);     // Catch: Throwable -> L175
        if (r14 == null) goto L173;
        long r22 = SystemClock.uptimeMillis();
        if (r14.mApp.mOptRecord == null) goto L98;
        if (r14.mApp.mOptRecord.skipPSSCollectionBecauseFrozen() == false) goto L98;
    L103:
        ?? r15 = 1;
    L104:
        ?? r25 = r15;
        long[] r16 = new long[1];
        if (r25 == 0) goto L107;
        long r31 = 0;
    L108:
        r1.mSmtEx.executeMemoryStrategyPss(r14.mApp.processName, r14.mApp.mPid, r31, r14.mApp.mState.getSetAdjWithServices());
        long r28 = SystemClock.uptimeMillis();
        Object r18 = r1.mProfilerLock;
        monitor-enter(r18);
        if (r31 != 0) goto L205;
    L142:
        int r27 = 3;
    L213:
        r14.abortNextPssTime();     // Catch: Throwable -> L166
        if (ActivityManagerDebugConfig.DEBUG_PSS == false) goto L195;
        StringBuilder r20 = new StringBuilder();     // Catch: Throwable -> L166
        r20.append("Skipped pss collection of ");     // Catch: Throwable -> L166
        int r21 = r13;
        r20.append(r21);     // Catch: Throwable -> L150
        r20.append(": ");     // Catch: Throwable -> L150
        if (r14.getThread() != null) goto L152;
        String r23 = "NO_THREAD ";
    L153:
        r20.append(r23);     // Catch: Throwable -> L150
        if (r25 == 0) goto L156;
        String r26 = "SKIP_PSS_COLLECTION ";
    L157:
        r20.append(r26);     // Catch: Throwable -> L150
        if (r14.getPid() == r21) goto L160;
        String r29 = "PID_CHANGED ";
    L161:
        r20.append(r29);     // Catch: Throwable -> L150
        r20.append(" initState=");     // Catch: Throwable -> L150
        r20.append(r9);     // Catch: Throwable -> L150
        r20.append(" curState=");     // Catch: Throwable -> L150
        r20.append(r14.getSetProcState());     // Catch: Throwable -> L150
        r20.append(" ");     // Catch: Throwable -> L150
        if (r14.getLastPssTime() == r10) goto L164;
        String r30 = "TIME_CHANGED";
    L165:
        r20.append(r30);     // Catch: Throwable -> L150
        Slog.d("ActivityManager", r20.toString());     // Catch: Throwable -> L150
        goto L195
    L164:
        r30 = "";
        goto L165
    L160:
        r29 = "";
        goto L161
    L156:
        r26 = "";
        goto L157
    L152:
        r23 = "";
    L195:
        monitor-exit(r18);     // Catch: Throwable -> L150
    L174:
        r1 = this;
        r4 = r24;
        r2 = r27;
        r5 = r5;
    L150:
        th = th;
    L171:
        monitor-exit(r18);     // Catch: Throwable -> L150
        throw th;
    L166:
        th = th;
        goto L171
    L205:
    L139:
        th = th;
        r18 = r18;
        goto L171
    L113:
        if (r14.getThread() == null) goto L142;
        if (r14.getSetProcState() == r9) goto L117;
        r27 = 3;
        goto L213
    L117:
        if (r14.getPid() != r13) goto L138;
        if (r14.getLastPssTime() != r10) goto L138;
        int r210 = r6 + 1;
        r14.commitNextPssTime();     // Catch: Throwable -> L136
        long[] r32 = r5;
        r18 = r18;
        r27 = 3;
        r5 = r32;
        r1.recordPssSampleLPf(r14, r9, r31, r32[r24], r32[1], r32[r8], r12, r28 - r22, SystemClock.uptimeMillis());     // Catch: Throwable -> L130
        r6 = r210;
    L130:
        th = th;
    L132:
        th = th;
    L134:
        th = th;
        r18 = r18;
    L136:
        th = th;
        r18 = r18;
    L138:
        r27 = 3;
        goto L213
    L107:
        r31 = SysOptBridge.getFactory().getActivityManager(r1.mService).getMemInfoCache(r14.mApp, r5, r16);
    L98:
        if (r1.mService.isCameraActiveForUid(r14.mApp.uid) == true) goto L103;
        if (r1.mService.mConstants.APP_PROFILER_PSS_PROFILING_DISABLED == true) goto L103;
        r15 = r24;
        goto L104
    L173:
        r5 = r5;
        r27 = 3;
    L175:
        th = th;
    L80:
        if (r9 != r0.getSetProcState()) goto L85;
        if ((r10 + 1000) >= r11) goto L85;
        int r110 = r0.getPid();     // Catch: Throwable -> L23
        r24 = r4 == true ? 1 : 0;
        r8 = 2;
        r13 = r110;
        r14 = r0;
        goto L207
    L71:
        r1.mIsRequestGetPss = true;     // Catch: Throwable -> L23
        r1.mFullPssOrRssPending = true;     // Catch: Throwable -> L23
        Slog.d("ActivityManager", "FEAT_ADJUST_GET_PSS_INTERVAL delay COLLECT_PSS_BG_MSG");     // Catch: Throwable -> L23
        r1.mBgHandler.sendEmptyMessageDelayed(1, getPssMaxDelayTime);     // Catch: Throwable -> L23
        monitor-exit(r7);     // Catch: Throwable -> L23
        return;
    L19:
        if (r1.mTestPssOrRssMode == true) goto L25;
        if (ActivityManagerDebugConfig.DEBUG_PSS == true) goto L25;
    L26:
        r1.mPendingPssOrRssProfiles.clear();     // Catch: Throwable -> L23
        r1.mIsRequestGetPss = r4;     // Catch: Throwable -> L23
        monitor-exit(r7);     // Catch: Throwable -> L23
        if (r19 == null) goto L67;
        r1.updateCpuStatsNow();
        ProcessCpuTracker r111 = r1.mProcessCpuTracker;
        monitor-enter(r111);
        List r33 = r1.mProcessCpuTracker.getStats(new AppProfiler$$ExternalSyntheticLambda2());     // Catch: Throwable -> L64
        monitor-exit(r111);     // Catch: Throwable -> L64
        int r112 = r33.size();
        long r211 = 0;
        int r34 = 0;
    L34:
        if (r34 >= r112) goto L48;
        ActivityManagerService.PidMap r35 = r1.mService.mPidsSelfLocked;
        monitor-enter(r35);
        if (r1.mService.mPidsSelfLocked.indexOfKey(((ProcessCpuTracker.Stats) r33.get(r34)).pid) < 0) goto L43;
        monitor-exit(r35);     // Catch: Throwable -> L41
    L45:
        r34 = r34 + 1;
        r2 = 3;
        goto L34
    L43:
        monitor-exit(r35);     // Catch: Throwable -> L41
        long[] r36 = new long[r2];
        long[] r37 = new long[1];
        long r38 = Debug.getPss(((ProcessCpuTracker.Stats) r33.get(r34)).pid, r36, null, r37);
        SysMonitorSvcBridge.getFactory().getProcessStatsServiceOptEx().addNativeMemUsage(((ProcessCpuTracker.Stats) r33.get(r34)).name, ((ProcessCpuTracker.Stats) r33.get(r34)).uid, ((ProcessCpuTracker.Stats) r33.get(r34)).pid, r38, r36[r4 == true ? 1 : 0], r36[2]);
        r1.mSmtEx.collectCachedPss(r38, r37[r4 == true ? 1 : 0], 0, true);
        r211 = r211 + r38;
    L41:
        th = move-exception;
        throw th;
    L48:
        r19.readMemInfo();
        Object r39 = r1.mService.mProcessStats.mLock;
        monitor-enter(r39);
    L53:
        th = move-exception;
        throw th;
    L51:
        if (ActivityManagerDebugConfig.DEBUG_PSS == false) goto L55;
        Slog.d("ActivityManager", "Collected native and kernel memory in " + (SystemClock.uptimeMillis() - r17) + "ms");     // Catch: Throwable -> L53
    L55:
        long r212 = r19.getCachedSizeKb();     // Catch: Throwable -> L53
        long r213 = r19.getFreeSizeKb();     // Catch: Throwable -> L53
        long r214 = r19.getZramTotalSizeKb();     // Catch: Throwable -> L53
        long r215 = r19.getKernelUsedSizeKb();     // Catch: Throwable -> L53
        long r113 = Debug.getIonHeapsSizeKb();     // Catch: Throwable -> L53
        if (r113 <= 0) goto L58;
        long r114 = 0;
        long r310 = r113 - r1.mSmtEx.mTotalEGL;     // Catch: Throwable -> L53
    L59:
        long r311 = ((r310 + r215) + r1.mSmtEx.mTotalPss) - r1.mSmtEx.mCachedPss;     // Catch: Throwable -> L53
        long r312 = r1.mSmtEx.mCachedPss + r114;     // Catch: Throwable -> L53
        EventLogTags.writeAmMeminfo(r212 * DeviceStorageMonitorServiceSmtEx.TrafficStats.KB_IN_BYTES, r213 * DeviceStorageMonitorServiceSmtEx.TrafficStats.KB_IN_BYTES, r214 * DeviceStorageMonitorServiceSmtEx.TrafficStats.KB_IN_BYTES, r215 * DeviceStorageMonitorServiceSmtEx.TrafficStats.KB_IN_BYTES, r211 * DeviceStorageMonitorServiceSmtEx.TrafficStats.KB_IN_BYTES);     // Catch: Throwable -> L53
        r1.mService.mProcessStats.addSysMemUsageLocked(r212, r213, r214, r215, r211, r310, r311, r312, r1.mSmtEx.mTotalPss, r1.mSmtEx.mCachedPss);     // Catch: Throwable -> L53
        r1.mSmtEx.resetProcStatsCollectData();     // Catch: Throwable -> L53
        monitor-exit(r39);     // Catch: Throwable -> L53
        return;
    L58:
        r114 = 0;
        r310 = 0;
    L64:
        th = move-exception;
        throw th;
    L67:
        return;
    L25:
        Slog.d("ActivityManager", "Collected pss of " + r6 + " processes in " + (SystemClock.uptimeMillis() - r17) + "ms");     // Catch: Throwable -> L23
    L177:
        th = th;
    L183:
        th = th;
    L185:
        monitor-exit(r3);     // Catch: Throwable -> L8
    L8:
        th = th;
        goto L185
    L186:
        throw th;
    L10:
        r19 = null;
        goto L191
    L218:
        th = th;
        goto L185
    }

    private static /* synthetic */ boolean lambda$collectPssInBackground$0(ProcessCpuTracker.Stats st) {
        if (st.vsize > 0) goto L5;
    L7:
        return false;
    L5:
        if (st.uid >= 10000) goto L7;
        return true;
    }

    boolean isProfilingPss() {
        return true;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:144:0x0287 -> B:164:0x02e1). Please report as a decompilation issue!!! */
    private void collectRssInBackground() {
        AppProfiler r1 = this;
        long start = SystemClock.uptimeMillis();
        Object r3 = r1.mProfilerLock;
        monitor-enter(r3);
        int pid = 0;
        if (r1.mFullPssOrRssPending == false) goto L10;
        r1.mFullPssOrRssPending = false;     // Catch: Throwable -> L8
        MemInfoReader memInfo = new MemInfoReader();     // Catch: Throwable -> L8
        MemInfoReader memInfo2 = memInfo;
    L198:
        monitor-exit(r3);     // Catch: Throwable -> L174
        if (memInfo2 == null) goto L52;
        r1.updateCpuStatsNow();
        long nativeTotalRss = 0;
        ProcessCpuTracker r4 = r1.mProcessCpuTracker;
        monitor-enter(r4);
        List<ProcessCpuTracker.Stats> stats = r1.mProcessCpuTracker.getStats(new AppProfiler$$ExternalSyntheticLambda0());     // Catch: Throwable -> L49
        monitor-exit(r4);     // Catch: Throwable -> L49
        if (r1.mService.mConstants.APP_PROFILER_PSS_PROFILING_DISABLED == true) goto L36;
        int numOfStats = stats.size();
        int j = 0;
    L21:
        if (j >= numOfStats) goto L35;
        ActivityManagerService.PidMap r7 = r1.mService.mPidsSelfLocked;
        monitor-enter(r7);
        if (r1.mService.mPidsSelfLocked.indexOfKey(stats.get(j).pid) < 0) goto L30;
        monitor-exit(r7);     // Catch: Throwable -> L28
    L32:
        j = j + 1;
        goto L21
    L30:
        monitor-exit(r7);     // Catch: Throwable -> L28
        nativeTotalRss = nativeTotalRss + Debug.getRss(stats.get(j).pid, null);
    L28:
        th = move-exception;
        throw th;
    L35:
        long nativeTotalRss2 = nativeTotalRss;
    L37:
        memInfo2.readMemInfo();
        Object r6 = r1.mService.mProcessStats.mLock;
        monitor-enter(r6);
    L42:
        th = move-exception;
        throw th;
    L40:
        if (ActivityManagerDebugConfig.DEBUG_RSS == false) goto L44;
        Slog.d("ActivityManager", "Collected native and kernel memory in " + (SystemClock.uptimeMillis() - start) + "ms");     // Catch: Throwable -> L42
    L44:
        long cachedKb = memInfo2.getCachedSizeKb();     // Catch: Throwable -> L42
        long freeKb = memInfo2.getFreeSizeKb();     // Catch: Throwable -> L42
        long zramKb = memInfo2.getZramTotalSizeKb();     // Catch: Throwable -> L42
        long kernelKb = memInfo2.getKernelUsedSizeKb();     // Catch: Throwable -> L42
        EventLogTags.writeAmMeminfo(cachedKb * DeviceStorageMonitorServiceSmtEx.TrafficStats.KB_IN_BYTES, freeKb * DeviceStorageMonitorServiceSmtEx.TrafficStats.KB_IN_BYTES, zramKb * DeviceStorageMonitorServiceSmtEx.TrafficStats.KB_IN_BYTES, kernelKb * DeviceStorageMonitorServiceSmtEx.TrafficStats.KB_IN_BYTES, nativeTotalRss2 * DeviceStorageMonitorServiceSmtEx.TrafficStats.KB_IN_BYTES);     // Catch: Throwable -> L42
        r1.mService.mProcessStats.addSysMemUsageLocked(cachedKb, freeKb, zramKb, kernelKb, nativeTotalRss2);     // Catch: Throwable -> L42
        monitor-exit(r6);     // Catch: Throwable -> L42
        goto L52
    L36:
        nativeTotalRss2 = 0;
    L49:
        th = move-exception;
        throw th;
    L52:
        int num = 0;
    L53:
        Object r5 = r1.mProfilerLock;
        monitor-enter(r5);
    L85:
        th = th;
    L192:
        monitor-exit(r5);     // Catch: Throwable -> L172
        throw th;
    L172:
        th = th;
        goto L192
    L56:
        if (r1.mPendingPssOrRssProfiles.size() <= 0) goto L58;
        ProcessProfileRecord profile = r1.mPendingPssOrRssProfiles.remove(pid);     // Catch: Throwable -> L85
        int procState = profile.getPssProcState();     // Catch: Throwable -> L85
        int statType = profile.getPssStatType();     // Catch: Throwable -> L85
        long lastRssTime = profile.getLastPssTime();     // Catch: Throwable -> L85
        long now = SystemClock.uptimeMillis();     // Catch: Throwable -> L85
        if (profile.getThread() != null) goto L186;
    L77:
        profile.abortNextPssTime();     // Catch: Throwable -> L85
        if (ActivityManagerDebugConfig.DEBUG_RSS == false) goto L88;
        StringBuilder r13 = new StringBuilder();     // Catch: Throwable -> L85
        r13.append("Skipped rss collection of ");     // Catch: Throwable -> L85
        r13.append(-1);     // Catch: Throwable -> L85
        r13.append(": still need ");     // Catch: Throwable -> L85
        r13.append((lastRssTime + 1000) - now);     // Catch: Throwable -> L83
        r13.append("ms until safe");     // Catch: Throwable -> L83
        Slog.d("ActivityManager", r13.toString());     // Catch: Throwable -> L83
    L83:
        th = th;
    L88:
        int pid2 = 0;
        ProcessProfileRecord profile2 = null;
    L188:
        monitor-exit(r5);     // Catch: Throwable -> L168
        if (profile2 == null) goto L166;
        long startTime = SystemClock.uptimeMillis();
        if (profile2.mApp.mOptRecord == null) goto L96;
        if (profile2.mApp.mOptRecord.skipPSSCollectionBecauseFrozen() == false) goto L96;
    L101:
        boolean r0 = true;
    L102:
        boolean skipRSSCollection = r0;
        if (skipRSSCollection == false) goto L105;
        long r8 = 0;
    L106:
        long rss = r8;
        int oomAdj = profile2.mApp.mState.getSetAdjWithServices();
        r1.mSmtEx.executeMemoryStrategyRss(profile2.mApp.processName, profile2.mApp.mPid, rss, oomAdj);
        long endTime = SystemClock.uptimeMillis();
        Object r9 = r1.mProfilerLock;
        monitor-enter(r9);
        if (rss == 0) goto L180;
    L134:
        th = th;
        r9 = r9;
    L164:
        monitor-exit(r9);     // Catch: Throwable -> L143
        throw th;
    L143:
        th = th;
        goto L164
    L111:
        if (profile2.getThread() == null) goto L180;
        if (profile2.getSetProcState() != procState) goto L180;
        if (profile2.getPid() != pid2) goto L180;
        if (profile2.getLastPssTime() != lastRssTime) goto L180;
        int num2 = num + 1;
        profile2.commitNextPssTime();     // Catch: Throwable -> L131
        r9 = r9;
        r1.recordRssSampleLPf(profile2, procState, rss, statType, endTime - startTime, SystemClock.uptimeMillis());     // Catch: Throwable -> L126
    L208:
        monitor-exit(r9);     // Catch: Throwable -> L162
        num = num2;
    L167:
        pid = 0;
        r1 = this;
    L162:
        th = th;
    L126:
        th = th;
    L128:
        th = th;
        r9 = r9;
    L131:
        th = th;
        r9 = r9;
    L180:
        profile2.abortNextPssTime();     // Catch: Throwable -> L143
        if (ActivityManagerDebugConfig.DEBUG_RSS == false) goto L159;
        StringBuilder r10 = new StringBuilder();     // Catch: Throwable -> L143
        r10.append("Skipped rss collection of ");     // Catch: Throwable -> L143
        r10.append(pid2);     // Catch: Throwable -> L143
        r10.append(": ");     // Catch: Throwable -> L143
        if (profile2.getThread() != null) goto L145;
        String r11 = "NO_THREAD ";
    L146:
        r10.append(r11);     // Catch: Throwable -> L143
        if (skipRSSCollection == false) goto L149;
        String r12 = "SKIP_RSS_COLLECTION ";
    L150:
        r10.append(r12);     // Catch: Throwable -> L143
        if (profile2.getPid() == pid2) goto L153;
        String r14 = "PID_CHANGED ";
    L154:
        r10.append(r14);     // Catch: Throwable -> L143
        r10.append(" initState=");     // Catch: Throwable -> L143
        r10.append(procState);     // Catch: Throwable -> L143
        r10.append(" curState=");     // Catch: Throwable -> L143
        r10.append(profile2.getSetProcState());     // Catch: Throwable -> L143
        r10.append(" ");     // Catch: Throwable -> L143
        if (profile2.getLastPssTime() == lastRssTime) goto L157;
        String r15 = "TIME_CHANGED";
    L158:
        r10.append(r15);     // Catch: Throwable -> L143
        Slog.d("ActivityManager", r10.toString());     // Catch: Throwable -> L143
        goto L159
    L157:
        r15 = "";
        goto L158
    L153:
        r14 = "";
        goto L154
    L149:
        r12 = "";
        goto L150
    L145:
        r11 = "";
    L159:
        num2 = num;
        goto L208
    L105:
        r8 = Debug.getRss(pid2, null);
    L96:
        if (r1.mService.isCameraActiveForUid(profile2.mApp.uid) == true) goto L101;
        if (r1.mService.mConstants.APP_PROFILER_PSS_PROFILING_DISABLED == true) goto L101;
        r0 = false;
        goto L102
    L166:
        num = num;
    L168:
        th = th;
        goto L192
    L186:
    L62:
        th = th;
        goto L192
    L72:
        if (procState != profile.getSetProcState()) goto L77;
        if ((lastRssTime + 1000) >= now) goto L77;
        num = num;
        pid2 = profile.getPid();     // Catch: Throwable -> L62
        profile2 = profile;
        goto L188
    L58:
        if (r1.mTestPssOrRssMode == true) goto L64;
        if (ActivityManagerDebugConfig.DEBUG_RSS == true) goto L64;
    L65:
        r1.mPendingPssOrRssProfiles.clear();     // Catch: Throwable -> L62
        monitor-exit(r5);     // Catch: Throwable -> L62
        return;
    L64:
        Slog.d("ActivityManager", "Collected rss of " + num + " processes in " + (SystemClock.uptimeMillis() - start) + "ms");     // Catch: Throwable -> L62
    L174:
        th = th;
    L176:
        monitor-exit(r3);     // Catch: Throwable -> L8
    L8:
        th = th;
        goto L176
    L177:
        throw th;
    L10:
        memInfo2 = null;
        goto L198
    L210:
        th = th;
        goto L176
    }

    private static /* synthetic */ boolean lambda$collectRssInBackground$1(ProcessCpuTracker.Stats st) {
        if (st.vsize > 0) goto L5;
    L7:
        return false;
    L5:
        if (st.uid >= 10000) goto L7;
        return true;
    }

    void updateNextPssTimeLPf(int procState, ProcessProfileRecord profile, long now, boolean forceUpdate) {
        if (forceUpdate == false) goto L4;
    L11:
        profile.setNextPssTime(profile.computeNextPssTime(procState, this.mTestPssOrRssMode, this.mService.mAtmInternal.isSleeping(), now));
        return;
    L4:
        if (now > profile.getNextPssTime()) goto L9;
        if (now > Math.max(profile.getLastPssTime() + 3600000, profile.getLastStateTime() + ProcessList.minTimeFromStateChange(this.mTestPssOrRssMode))) goto L9;
        return;
    L9:
        if (requestPssLPf(profile, procState, now) == true) goto L11;
    }

    private void recordPssSampleLPf(ProcessProfileRecord profile, int procState, long pss, long uss, long swapPss, long rss, int statType, long pssDuration, long now) {
        ProcessRecord proc = profile.mApp;
        EventLogTags.writeAmPss(profile.getPid(), proc.uid, proc.processName, pss * DeviceStorageMonitorServiceSmtEx.TrafficStats.KB_IN_BYTES, uss * DeviceStorageMonitorServiceSmtEx.TrafficStats.KB_IN_BYTES, swapPss * DeviceStorageMonitorServiceSmtEx.TrafficStats.KB_IN_BYTES, rss * DeviceStorageMonitorServiceSmtEx.TrafficStats.KB_IN_BYTES, statType, procState, pssDuration);
        proc.mSmtEx.addPssHistoryLocked(now, pss, proc);
        profile.setLastPssTime(now);
        profile.addPss(pss, uss, rss, true, statType, pssDuration);
        if (ActivityManagerDebugConfig.DEBUG_PSS == false) goto L6;
        Slog.d("ActivityManager", "pss of " + proc.toShortString() + ": " + pss + " lastPss=" + profile.getLastPss() + " state=" + ProcessList.makeProcStateString(procState));
    L6:
        if (profile.getInitialIdlePssOrRss() != 0) goto L8;
        profile.setInitialIdlePssOrRss(pss);
    L8:
        profile.setLastPss(pss);
        profile.setLastSwapPss(swapPss);
        if (procState < 14) goto L11;
        profile.setLastCachedPss(pss);
        profile.setLastCachedSwapPss(swapPss);
    L11:
        profile.setLastRss(rss);
        SparseArray<Pair<Long, String>> watchUids = (SparseArray) this.mMemWatchProcesses.getMap().get(proc.processName);
        Long check = null;
        if (watchUids == null) goto L18;
        Pair<Long, String> val = watchUids.get(proc.uid);
        if (val != null) goto L16;
        val = watchUids.get(0);
    L16:
        if (val == null) goto L18;
        check = (Long) val.first;
    L18:
        if (check != null) goto L20;
        return;
    L20:
        if ((pss * DeviceStorageMonitorServiceSmtEx.TrafficStats.KB_IN_BYTES) >= check.longValue()) goto L22;
        return;
    L22:
        if (profile.getThread() != null) goto L24;
        return;
    L24:
        if (this.mMemWatchDumpProcName == null) goto L26;
        return;
    L26:
        if (Build.IS_DEBUGGABLE == false) goto L28;
    L31:
        Slog.w("ActivityManager", "Process " + proc + " exceeded pss limit " + check + "; reporting");
        startHeapDumpLPf(profile, false);
        return;
    L28:
        if (proc.isDebuggable() == true) goto L31;
        Slog.w("ActivityManager", "Process " + proc + " exceeded pss limit " + check + ", but debugging not enabled");
    }

    private void recordRssSampleLPf(ProcessProfileRecord profile, int procState, long rss, int statType, long rssDuration, long now) {
        ProcessRecord proc = profile.mApp;
        EventLogTags.writeAmPss(profile.getPid(), proc.uid, proc.processName, 0, 0, 0, rss * DeviceStorageMonitorServiceSmtEx.TrafficStats.KB_IN_BYTES, statType, procState, rssDuration);
        profile.setLastPssTime(now);
        profile.addPss(0, 0, rss, true, statType, rssDuration);
        if (ActivityManagerDebugConfig.DEBUG_RSS == false) goto L6;
        Slog.d("ActivityManager", "rss of " + proc.toShortString() + ": " + rss + " lastRss=" + profile.getLastRss() + " state=" + ProcessList.makeProcStateString(procState));
    L6:
        if (profile.getInitialIdlePssOrRss() != 0) goto L8;
        profile.setInitialIdlePssOrRss(rss);
    L8:
        profile.setLastRss(rss);
        if (procState < 14) goto L11;
        profile.setLastCachedRss(rss);
    L11:
        SparseArray<Pair<Long, String>> watchUids = (SparseArray) this.mMemWatchProcesses.getMap().get(proc.processName);
        Long check = null;
        if (watchUids == null) goto L18;
        Pair<Long, String> val = watchUids.get(proc.uid);
        if (val != null) goto L16;
        val = watchUids.get(0);
    L16:
        if (val == null) goto L18;
        check = (Long) val.first;
    L18:
        if (check == null) goto L33;
        long pss = Debug.getPss(profile.getPid(), null, null);
        if ((DeviceStorageMonitorServiceSmtEx.TrafficStats.KB_IN_BYTES * pss) >= check.longValue()) goto L22;
        return;
    L22:
        if (profile.getThread() != null) goto L24;
        return;
    L24:
        if (this.mMemWatchDumpProcName == null) goto L26;
        return;
    L26:
        if (Build.IS_DEBUGGABLE == false) goto L28;
    L31:
        Slog.w("ActivityManager", "Process " + proc + " exceeded pss limit " + check + "; reporting");
        startHeapDumpLPf(profile, false);
        return;
    L28:
        if (proc.isDebuggable() == true) goto L31;
        Slog.w("ActivityManager", "Process " + proc + " exceeded pss limit " + check + ", but debugging not enabled");
        return;
    }

    void startHeapDumpLPf(ProcessProfileRecord profile, boolean isUserInitiated) {
        ProcessRecord proc = profile.mApp;
        this.mMemWatchDumpProcName = proc.processName;
        this.mMemWatchDumpUri = makeHeapDumpUri(proc.processName);
        this.mMemWatchDumpPid = profile.getPid();
        this.mMemWatchDumpUid = proc.uid;
        this.mMemWatchIsUserInitiated = isUserInitiated;
        Context ctx = this.mService.mContext.createPackageContextAsUser(PackageManagerService.PLATFORM_PACKAGE_NAME, 0, UserHandle.getUserHandleForUid(this.mMemWatchDumpUid));     // Catch: PackageManager.NameNotFoundException -> L6
        BackgroundThread.getHandler().post(new RecordPssRunnable(this, profile, this.mMemWatchDumpUri, ctx.getContentResolver()));
        return;
    L8:
        throw new RuntimeException("android package not found.");
    }

    void dumpHeapFinished(String path, int callerPid) {
        Object r0 = this.mProfilerLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (callerPid == this.mMemWatchDumpPid) goto L12;
        Slog.w("ActivityManager", "dumpHeapFinished: Calling pid " + Binder.getCallingPid() + " does not match last pid " + this.mMemWatchDumpPid);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L12:
        if (this.mMemWatchDumpUri == null) goto L22;
        if (this.mMemWatchDumpUri.getPath().equals(path) == false) goto L22;
        if (ActivityManagerDebugConfig.DEBUG_PSS == false) goto L19;
        Slog.d("ActivityManager", "Dump heap finished for " + path);     // Catch: Throwable -> L9
    L19:
        this.mService.mHandler.sendEmptyMessage(50);     // Catch: Throwable -> L9
        Runtime.getRuntime().gc();     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L22:
        Slog.w("ActivityManager", "dumpHeapFinished: Calling path " + path + " does not match last path " + this.mMemWatchDumpUri);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
    }

    void handlePostDumpHeapNotification() {
        Object r0 = this.mProfilerLock;
        monitor-enter(r0);
        int uid = this.mMemWatchDumpUid;     // Catch: Throwable -> L7
        String procName = this.mMemWatchDumpProcName;     // Catch: Throwable -> L7
        Pair<Long, String> val = (Pair) this.mMemWatchProcesses.get(procName, uid);     // Catch: Throwable -> L7
        if (val != null) goto L9;
        val = (Pair) this.mMemWatchProcesses.get(procName, 0);     // Catch: Throwable -> L7
    L9:
        if (val == null) goto L11;
        long memLimit = ((Long) val.first).longValue();     // Catch: Throwable -> L7
        String reportPackage = (String) val.second;     // Catch: Throwable -> L7
    L12:
        boolean isUserInitiated = this.mMemWatchIsUserInitiated;     // Catch: Throwable -> L7
        this.mMemWatchDumpUri = null;     // Catch: Throwable -> L7
        this.mMemWatchDumpProcName = null;     // Catch: Throwable -> L7
        this.mMemWatchDumpPid = -1;     // Catch: Throwable -> L7
        this.mMemWatchDumpUid = -1;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        if (procName != null) goto L17;
        return;
    L17:
        if (ActivityManagerDebugConfig.DEBUG_PSS == false) goto L19;
        Slog.d("ActivityManager", "Showing dump heap notification from " + procName + SliceClientPermissions.SliceAuthority.DELIMITER + uid);
    L19:
        Intent dumpFinishedIntent = new Intent(ACTION_HEAP_DUMP_FINISHED);
        dumpFinishedIntent.setPackage("com.android.shell");
        dumpFinishedIntent.putExtra("android.intent.extra.UID", uid);
        dumpFinishedIntent.putExtra(EXTRA_HEAP_DUMP_IS_USER_INITIATED, isUserInitiated);
        dumpFinishedIntent.putExtra(EXTRA_HEAP_DUMP_SIZE_BYTES, memLimit);
        dumpFinishedIntent.putExtra(EXTRA_HEAP_DUMP_REPORT_PACKAGE, reportPackage);
        dumpFinishedIntent.putExtra(EXTRA_HEAP_DUMP_PROCESS_NAME, procName);
        this.mService.mContext.sendBroadcastAsUser(dumpFinishedIntent, UserHandle.getUserHandleForUid(uid));
        return;
    L11:
        memLimit = 0;
        reportPackage = null;
    L7:
        th = move-exception;
        throw th;
    }

    void setDumpHeapDebugLimit(String processName, int uid, long maxMemSize, String reportPackage) {
        Object r0 = this.mProfilerLock;
        monitor-enter(r0);
        if (maxMemSize <= 0) goto L9;
        this.mMemWatchProcesses.put(processName, uid, new Pair(Long.valueOf(maxMemSize), reportPackage));     // Catch: Throwable -> L7
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L9:
        if (uid == 0) goto L11;
        this.mMemWatchProcesses.remove(processName, uid);     // Catch: Throwable -> L7
        goto L12
    L11:
        this.mMemWatchProcesses.getMap().remove(processName);     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        throw th;
    }

    private void abortHeapDump(String procName) {
        Message msg = this.mService.mHandler.obtainMessage(51);
        msg.obj = procName;
        this.mService.mHandler.sendMessage(msg);
    }

    void handleAbortDumpHeap(String procName) {
        if (procName == null) goto L14;
        Object r0 = this.mProfilerLock;
        monitor-enter(r0);
    L8:
        th = move-exception;
        throw th;
    L6:
        if (procName.equals(this.mMemWatchDumpProcName) == false) goto L10;
        this.mMemWatchDumpProcName = null;     // Catch: Throwable -> L8
        this.mMemWatchDumpUri = null;     // Catch: Throwable -> L8
        this.mMemWatchDumpPid = -1;     // Catch: Throwable -> L8
        this.mMemWatchDumpUid = -1;     // Catch: Throwable -> L8
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    }

    private static Uri makeHeapDumpUri(String procName) {
        return Uri.parse("content://com.android.shell.heapdump/" + procName + "_javaheap.bin");
    }

    private boolean requestPssLPf(ProcessProfileRecord profile, int procState, long now) {
        if (this.mPendingPssOrRssProfiles.contains(profile) == false) goto L6;
        return false;
    L6:
        if (this.mPendingPssOrRssProfiles.size() != 0) goto L20;
        if (this.mPssDeferralTime > 0) goto L10;
    L12:
        long deferral = 0;
    L14:
        if (ActivityManagerDebugConfig.DEBUG_PSS == true) goto L16;
    L18:
        this.mBgHandler.sendEmptyMessageDelayed(1, deferral);
        goto L20
    L16:
        if (deferral <= 0) goto L18;
        Slog.d("ActivityManager", "requestPssLPf() deferring PSS request by " + deferral + " ms");
        goto L18
    L10:
        if (this.mActivityStartingNesting.get() <= 0) goto L12;
        deferral = this.mPssDeferralTime;
    L20:
        if (ActivityManagerDebugConfig.DEBUG_PSS == false) goto L23;
        Slog.d("ActivityManager", "Requesting pss of: " + profile.mApp);
    L23:
        if (ProcessRecordSmtBase.allowPssCollect(profile.mApp, false, false, now) == true) goto L25;
        return false;
    L25:
        profile.setPssProcState(procState);
        profile.setPssStatType(0);
        this.mPendingPssOrRssProfiles.add(profile);
        return true;
    }

    private void deferPssIfNeededLPf() {
        if (this.mPendingPssOrRssProfiles.size() <= 0) goto L6;
        this.mBgHandler.removeMessages(1);
        this.mBgHandler.sendEmptyMessageDelayed(1, this.mPssDeferralTime);
        return;
    }

    private void deferPssForActivityStart() {
        if (this.mPssDeferralTime > 0) goto L5;
        return;
    L5:
        if (ActivityManagerDebugConfig.DEBUG_PSS == false) goto L7;
        Slog.d("ActivityManager", "Deferring PSS collection for activity start");
    L7:
        Object r0 = this.mProfilerLock;
        monitor-enter(r0);
        deferPssIfNeededLPf();     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        this.mActivityStartingNesting.getAndIncrement();
        this.mBgHandler.sendEmptyMessageDelayed(3, this.mPssDeferralTime);
        return;
    L12:
        th = move-exception;
        throw th;
    }

    private void stopDeferPss() {
        int nesting = this.mActivityStartingNesting.decrementAndGet();
        if (nesting > 0) goto L10;
        if (ActivityManagerDebugConfig.DEBUG_PSS == false) goto L7;
        Slog.d("ActivityManager", "PSS activity start deferral interval ended; now " + nesting);
    L7:
        if (nesting >= 0) goto L13;
        Slog.wtf("ActivityManager", "Activity start nesting undercount!");
        this.mActivityStartingNesting.incrementAndGet();
        return;
    L13:
        return;
    L10:
        if (ActivityManagerDebugConfig.DEBUG_PSS == false) goto L15;
        Slog.d("ActivityManager", "Still deferring PSS, nesting=" + nesting);
        return;
    }

    void requestPssAllProcsLPr(final long now, final boolean always, final boolean memLowered) {
        Object r1 = this.mProfilerLock;
        monitor-enter(r1);
        if (always == true) goto L43;
        long r2 = this.mLastFullPssTime;     // Catch: Throwable -> L8
        if (memLowered == false) goto L10;
        long r4 = this.mService.mConstants.FULL_PSS_LOWERED_INTERVAL;     // Catch: Throwable -> L8
    L12:
        if (now >= (r2 + r4)) goto L43;
        monitor-exit(r1);     // Catch: Throwable -> L8
        return;
    L10:
        r4 = this.mService.mConstants.FULL_PSS_MIN_INTERVAL;     // Catch: Throwable -> L8
    L8:
        th = th;
    L39:
        monitor-exit(r1);     // Catch: Throwable -> L33
        throw th;
    L43:
    L37:
        th = th;
        goto L39
    L16:
        if (this.mIsRequestGetPss == false) goto L20;
        monitor-exit(r1);     // Catch: Throwable -> L8
        return;
    L20:
        if (ActivityManagerDebugConfig.DEBUG_PSS == false) goto L22;
        Slog.d("ActivityManager", "Requesting pss of all procs!  memLowered=" + memLowered);     // Catch: Throwable -> L8
    L22:
        this.mLastFullPssTime = now;     // Catch: Throwable -> L37
        this.mFullPssOrRssPending = true;     // Catch: Throwable -> L37
        int i = this.mPendingPssOrRssProfiles.size() - 1;
    L24:
        if (i < 0) goto L28;
        this.mPendingPssOrRssProfiles.get(i).abortNextPssTime();     // Catch: Throwable -> L8
        i = i - 1;
        goto L24
    L28:
        this.mPendingPssOrRssProfiles.ensureCapacity(this.mService.mProcessList.getLruSizeLOSP());     // Catch: Throwable -> L37
        this.mPendingPssOrRssProfiles.clear();     // Catch: Throwable -> L37
        this.mService.mProcessList.forEachLruProcessesLOSP(false, new AppProfiler$$ExternalSyntheticLambda5(this, memLowered, always, now));     // Catch: Throwable -> L33
        if (this.mBgHandler.hasMessages(1) == true) goto L35;
        this.mBgHandler.sendEmptyMessage(1);     // Catch: Throwable -> L33
    L35:
        monitor-exit(r1);     // Catch: Throwable -> L33
        return;
    L33:
        th = th;
        goto L39
    }

    private /* synthetic */ void lambda$requestPssAllProcsLPr$2(boolean memLowered, boolean always, long now, ProcessRecord app) {
        ProcessProfileRecord profile = app.mProfile;
        if (profile.getThread() != null) goto L7;
        if (app.getSmtEx().inFreezeStat() == true) goto L7;
        return;
    L7:
        if (profile.getSetProcState() == 20) goto L28;
        long lastStateTime = profile.getLastStateTime();
        if (memLowered == true) goto L18;
        if (always == false) goto L15;
        if (now > (1000 + lastStateTime)) goto L18;
    L15:
        if (now > (1200000 + lastStateTime)) goto L18;
        this.mSmtEx.collectCachedPss(app);
        return;
    L18:
        int r0 = 1;
        if (ProcessRecordSmtBase.allowPssCollect(app, memLowered, true, now) == true) goto L22;
        this.mService.getSmtEx().collectCachedPss(app);
        return;
    L22:
        profile.setPssProcState(profile.getSetProcState());
        if (always == false) goto L26;
        r0 = 2;
    L26:
        profile.setPssStatType(r0);
        updateNextPssTimeLPf(profile.getSetProcState(), profile, now, true);
        this.mPendingPssOrRssProfiles.add(profile);
        return;
    }

    void setTestPssMode(boolean enabled) {
        ActivityManagerGlobalLock r0 = this.mProcLock;
        ActivityManagerService.boostPriorityForProcLockedSection();
        monitor-enter(r0);
        this.mTestPssOrRssMode = enabled;     // Catch: Throwable -> L7
        if (enabled == false) goto L9;
        requestPssAllProcsLPr(SystemClock.uptimeMillis(), true, true);     // Catch: Throwable -> L7
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L7
        ActivityManagerService.resetPriorityAfterProcLockedSection();
        return;
    L7:
        th = move-exception;
        ActivityManagerService.resetPriorityAfterProcLockedSection();
        throw th;
    }

    boolean getTestPssMode() {
        return this.mTestPssOrRssMode;
    }

    int getLastMemoryLevelLocked() {
        if (this.mMemFactorOverride == (-1)) goto L7;
        return this.mMemFactorOverride;
    L7:
        return this.mLastMemoryLevel;
    }

    boolean isLastMemoryLevelNormal() {
        if (this.mMemFactorOverride == (-1)) goto L9;
        if (this.mMemFactorOverride <= 0) goto L7;
        return false;
    L7:
        return true;
    L9:
        if (this.mLastMemoryLevel <= 0) goto L11;
        return false;
    L11:
        return true;
    }

    void updateLowRamTimestampLPr(long now) {
        this.mLowRamTimeSinceLastIdle = 0;
        if (this.mLowRamStartTime == 0) goto L6;
        this.mLowRamStartTime = now;
        return;
    }

    void setAllowLowerMemLevelLocked(boolean allowLowerMemLevel) {
        this.mAllowLowerMemLevel = allowLowerMemLevel;
    }

    boolean allowLowerMemLevelLocked() {
        return this.mAllowLowerMemLevel;
    }

    void setMemFactorOverrideLocked(int factor) {
        this.mMemFactorOverride = factor;
        this.mService.mProcessStateController.setIsLastMemoryLevelNormal(isLastMemoryLevelNormal());
    }

    void updateLowMemStateLSP(int numCached, int numEmpty, int numTrimming, long now) {
        if (this.mLowMemDetector == null) goto L8;
        if (this.mLowMemDetector.isAvailable() == false) goto L8;
        int memFactor = this.mLowMemDetector.getMemFactor();
    L21:
        if (ActivityManagerDebugConfig.DEBUG_OOM_ADJ == false) goto L23;
        Slog.d("ActivityManager", "oom: memFactor=" + memFactor + " override=" + this.mMemFactorOverride + " last=" + this.mLastMemoryLevel + " allowLow=" + this.mAllowLowerMemLevel + " numProcs=" + this.mService.mProcessList.getLruSizeLOSP() + " last=" + this.mLastNumProcesses);
    L23:
        boolean r3 = false;
        if (this.mMemFactorOverride == (-1)) goto L26;
        boolean r1 = true;
    L27:
        boolean override = r1;
        if (r1 == false) goto L31;
        memFactor = this.mMemFactorOverride;
    L31:
        if (memFactor <= this.mLastMemoryLevel) goto L41;
        if (override == true) goto L41;
        if (this.mAllowLowerMemLevel == true) goto L36;
    L37:
        memFactor = this.mLastMemoryLevel;
        if (ActivityManagerDebugConfig.DEBUG_OOM_ADJ == false) goto L41;
        Slog.d("ActivityManager", "Keeping last mem factor!");
        goto L41
    L36:
        if (this.mService.mProcessList.getLruSizeLOSP() >= this.mLastNumProcesses) goto L37;
    L41:
        if (memFactor == this.mLastMemoryLevel) goto L43;
        EventLogTags.writeAmMemFactor(memFactor, this.mLastMemoryLevel);
        FrameworkStatsLog.write(15, memFactor);
        this.mBgHandler.obtainMessage(4, this.mLastMemoryLevel, memFactor).sendToTarget();
    L43:
        this.mCachedAppsWatermarkData.updateCachedAppsHighWatermarkIfNecessaryLocked(numCached + numEmpty, now);
        Object r2 = this.mService.mProcessStats.mLock;
        monitor-enter(r2);
        ProcessStatsService r5 = this.mService.mProcessStats;     // Catch: Throwable -> L50
        if (this.mService.mAtmInternal != null) goto L48;
    L52:
        r3 = true;
    L53:
        r5.setMemFactorLocked(memFactor, r3, SystemClock.uptimeMillis());     // Catch: Throwable -> L50
        this.mService.mProcessStats.getMemFactorLocked();     // Catch: Throwable -> L50
        monitor-exit(r2);     // Catch: Throwable -> L50
        this.mLastMemoryLevel = memFactor;
        this.mService.mProcessStateController.setIsLastMemoryLevelNormal(isLastMemoryLevelNormal());
        this.mLastNumProcesses = this.mService.mProcessList.getLruSizeLOSP();
        this.mService.mProcessList.forEachLruProcessesLOSP(true, new AppProfiler$$ExternalSyntheticLambda1());
        return;
    L48:
        if (this.mService.mAtmInternal.isSleeping() == true) goto L53;
    L50:
        th = move-exception;
        throw th;
    L26:
        r1 = false;
    L8:
        if (numCached <= this.mService.mConstants.CUR_TRIM_CACHED_PROCESSES) goto L10;
    L19:
        memFactor = 0;
        goto L21
    L10:
        if (numEmpty > this.mService.mConstants.CUR_TRIM_EMPTY_PROCESSES) goto L19;
        int numCachedAndEmpty = numCached + numEmpty;
        if (numCachedAndEmpty > 3) goto L15;
        memFactor = 3;
        goto L21
    L15:
        if (numCachedAndEmpty > 5) goto L17;
        memFactor = 2;
        goto L21
    L17:
        memFactor = 1;
        goto L21
    }

    private static /* synthetic */ void lambda$updateLowMemStateLSP$3(ProcessRecord app) {
        ProcessProfileRecord r0 = app.mProfile;
        ProcessStateRecord state = app.mState;
        if (state.hasProcStateChanged() == false) goto L5;
        state.setProcStateChanged(false);
    L5:
        int procState = app.mState.getCurProcState();
        if (procState < 7) goto L10;
        if (procState >= 16) goto L10;
    L12:
        if (app.mProfile.hasPendingUiClean() == false) goto L23;
        IApplicationThread thread = app.getThread();
        if (thread != null) goto L20;
        return;
    L20:
        thread.scheduleTrimMemory(20);     // Catch: RemoteException -> L18
        app.mProfile.setPendingUiClean(false);     // Catch: RemoteException -> L18
        return;
    L19:
        return;
    L23:
        return;
    L10:
        if (app.mState.isSystemNoUi() == true) goto L12;
    }

    private void trimMemoryUiHiddenIfNecessaryLSP(ProcessRecord app) {
        if (app.mState.getCurProcState() >= 7) goto L7;
        if (app.mState.isSystemNoUi() == true) goto L7;
        return;
    L7:
        if (app.mProfile.hasPendingUiClean() == false) goto L11;
        scheduleTrimMemoryLSP(app, 20, "Trimming memory of bg-ui ");
        app.mProfile.setPendingUiClean(false);
        return;
    }

    private void scheduleTrimMemoryLSP(ProcessRecord app, int level, String msg) {
        if (app.mProfile.getTrimMemoryLevel() >= level) goto L18;
        IApplicationThread thread = app.getThread();
        if (thread == null) goto L19;
        if (ActivityTaskManagerDebugConfig.DEBUG_SWITCH == true) goto L13;
        if (ActivityManagerDebugConfig.DEBUG_OOM_ADJ == true) goto L13;
    L14:
        this.mService.mOomAdjuster.mCachedAppOptimizer.unfreezeTemporarily(app, 13);     // Catch: RemoteException -> L11
        thread.scheduleTrimMemory(level);     // Catch: RemoteException -> L11
        return;
    L13:
        Slog.v("ActivityManager", msg + app.processName + " to " + level);     // Catch: RemoteException -> L11
    L20:
        return;
    L19:
        return;
    }

    long getLowRamTimeSinceIdleLPr(long now) {
        long r0 = this.mLowRamTimeSinceLastIdle;
        long r4 = 0;
        if (this.mLowRamStartTime <= 0) goto L6;
        r4 = now - this.mLowRamStartTime;
    L6:
        return r0 + r4;
    }

    private void performAppGcLPf(ProcessRecord app) {
        ProcessProfileRecord profile = app.mProfile;     // Catch: Exception -> L7
        profile.setLastRequestedGc(SystemClock.uptimeMillis());     // Catch: Exception -> L7
        IApplicationThread thread = profile.getThread();     // Catch: Exception -> L7
        if (thread != null) goto L5;
    L12:
        return;
    L5:
        if (profile.getReportLowMemory() == false) goto L9;
        profile.setReportLowMemory(false);     // Catch: Exception -> L7
        thread.scheduleLowMemory();     // Catch: Exception -> L7
        goto L12
    L9:
        thread.processInBackground();     // Catch: Exception -> L7
    }

    private void performAppGcsLPf() {
        if (this.mProcessesToGc.size() > 0) goto L6;
        return;
    L6:
        if (this.mProcessesToGc.size() <= 0) goto L18;
        ProcessRecord proc = this.mProcessesToGc.remove(0);
        ProcessProfileRecord profile = proc.mProfile;
        if (profile.getCurRawAdj() > 200) goto L14;
        if (profile.getReportLowMemory() == false) goto L6;
    L14:
        if ((profile.getLastRequestedGc() + this.mService.mConstants.GC_MIN_INTERVAL) > SystemClock.uptimeMillis()) goto L17;
        performAppGcLPf(proc);
        scheduleAppGcsLPf();
        return;
    L17:
        addProcessToGcListLPf(proc);
    L18:
        scheduleAppGcsLPf();
    }

    final void performAppGcsIfAppropriateLocked() {
        Object r0 = this.mProfilerLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mService.canGcNowLocked() == false) goto L11;
        performAppGcsLPf();     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L11:
        scheduleAppGcsLPf();     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
    }

    final void scheduleAppGcsLPf() {
        this.mService.mHandler.removeMessages(5);
        if (this.mProcessesToGc.size() <= 0) goto L9;
        ProcessRecord proc = this.mProcessesToGc.get(0);
        Message msg = this.mService.mHandler.obtainMessage(5);
        long when = proc.mProfile.getLastRequestedGc() + this.mService.mConstants.GC_MIN_INTERVAL;
        long now = SystemClock.uptimeMillis();
        if (when >= (this.mService.mConstants.GC_TIMEOUT + now)) goto L7;
        when = now + this.mService.mConstants.GC_TIMEOUT;
    L7:
        this.mService.mHandler.sendMessageAtTime(msg, when);
        return;
    }

    private void addProcessToGcListLPf(ProcessRecord proc) {
        boolean added = false;
        int i = this.mProcessesToGc.size() - 1;
    L3:
        if (i < 0) goto L8;
        if (this.mProcessesToGc.get(i).mProfile.getLastRequestedGc() < proc.mProfile.getLastRequestedGc()) goto L6;
        i = i - 1;
        goto L3
    L6:
        added = true;
        this.mProcessesToGc.add(i + 1, proc);
    L8:
        if (added == true) goto L13;
        this.mProcessesToGc.add(0, proc);
        return;
    }

    final void doLowMemReportIfNeededLocked(final ProcessRecord dyingProc) {
        if (this.mService.mProcessList.haveBackgroundProcessLOSP() == true) goto L18;
        boolean doReport = Build.IS_DEBUGGABLE;
        final long now = SystemClock.uptimeMillis();
        if (doReport == true) goto L7;
    L10:
        int lruSize = this.mService.mProcessList.getLruSizeLOSP();
        if (doReport == false) goto L14;
        ArrayList<ProcessMemInfo> r1 = new ArrayList(lruSize);
    L13:
        final ArrayList<ProcessMemInfo> memInfos = r1;
        EventLogTags.writeAmLowMemory(lruSize);
        final AppProfiler r2 = this;
        this.mService.mProcessList.forEachLruProcessesLOSP(false, new AppProfiler$$ExternalSyntheticLambda4(r2, dyingProc, memInfos, now));
        if (doReport == false) goto L19;
        Message msg = r2.mService.mHandler.obtainMessage(33, memInfos);
        r2.mService.mHandler.sendMessage(msg);
    L19:
        Object r10 = r2.mProfilerLock;
        monitor-enter(r10);
        scheduleAppGcsLPf();     // Catch: Throwable -> L24
        monitor-exit(r10);     // Catch: Throwable -> L24
        return;
    L24:
        th = move-exception;
        throw th;
    L14:
        r1 = null;
        goto L13
    L7:
        if (now >= (this.mLastMemUsageReportTime + 300000)) goto L9;
        doReport = false;
        goto L10
    L9:
        this.mLastMemUsageReportTime = now;
        goto L10
    L18:
        r2 = this;
        goto L19
    }

    private /* synthetic */ void lambda$doLowMemReportIfNeededLocked$4(ProcessRecord dyingProc, ArrayList memInfos, long now, ProcessRecord rec) {
        if (rec != dyingProc) goto L4;
        return;
    L4:
        if (rec.getThread() == null) goto L29;
        ProcessStateRecord state = rec.mState;
        if (memInfos == null) goto L9;
        memInfos.add(new ProcessMemInfo(rec.processName, rec.getPid(), state.getSetAdj(), state.getSetProcState(), state.getAdjType(), state.makeAdjReason()));
    L9:
        ProcessProfileRecord profile = rec.mProfile;
        if ((profile.getLastLowMemory() + this.mService.mConstants.GC_MIN_INTERVAL) > now) goto L24;
        Object r3 = this.mProfilerLock;
        monitor-enter(r3);
    L16:
        th = move-exception;
        throw th;
    L14:
        if (state.getSetAdj() > 400) goto L18;
        profile.setLastRequestedGc(0);     // Catch: Throwable -> L16
    L19:
        profile.setReportLowMemory(true);     // Catch: Throwable -> L16
        profile.setLastLowMemory(now);     // Catch: Throwable -> L16
        this.mProcessesToGc.remove(rec);     // Catch: Throwable -> L16
        addProcessToGcListLPf(rec);     // Catch: Throwable -> L16
        monitor-exit(r3);     // Catch: Throwable -> L16
        return;
    L18:
        profile.setLastRequestedGc(profile.getLastLowMemory());     // Catch: Throwable -> L16
        goto L19
    L24:
        return;
    }

    /* JADX WARN: Failed to apply debug info
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r4v1 ??, new type: long[]
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.applyDebugInfo(TypeUpdate.java:77)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoApplyVisitor.applyDebugInfo(DebugInfoApplyVisitor.java:137)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoApplyVisitor.applyDebugInfo(DebugInfoApplyVisitor.java:133)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoApplyVisitor.searchAndApplyVarDebugInfo(DebugInfoApplyVisitor.java:79)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoApplyVisitor.lambda$applyDebugInfo$0(DebugInfoApplyVisitor.java:68)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoApplyVisitor.applyDebugInfo(DebugInfoApplyVisitor.java:68)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoApplyVisitor.visit(DebugInfoApplyVisitor.java:55)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:488)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 8 more
     */
    /* JADX WARN: Failed to calculate best type for var: r11v0 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r11v0 ??, new type: long
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:488)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r11v1 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r11v1 ??, new type: long
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:488)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r11v11 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r11v11 ??, new type: long
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:488)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r11v2 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r11v2 ??, new type: long
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:488)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r11v27 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r11v27 ??, new type: long
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:488)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r11v28 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r11v28 ??, new type: long
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:488)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r11v29 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r11v29 ??, new type: long
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:488)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r11v30 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r11v30 ??, new type: long
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:488)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r13v2 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r13v2 ??, new type: long
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:488)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r13v3 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r13v3 ??, new type: long
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:488)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r13v39 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r13v39 ??, new type: long
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:488)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r13v46 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r13v46 ??, new type: long
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:488)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r13v48 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r13v48 ??, new type: long
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:488)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r17v10 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r17v10 ??, new type: long
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:488)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r17v11 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r17v11 ??, new type: long
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:488)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r17v12 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r17v12 ??, new type: long
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:488)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r17v13 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r17v13 ??, new type: long
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:488)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r17v14 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r17v14 ??, new type: long
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:488)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r17v5 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r17v5 ??, new type: long
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:488)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r17v6 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r17v6 ??, new type: long
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:488)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r17v7 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r17v7 ??, new type: long
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:488)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r17v8 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r17v8 ??, new type: long
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:488)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r17v9 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r17v9 ??, new type: long
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:488)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r19v1 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r19v1 ??, new type: long
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:488)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r19v10 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r19v10 ??, new type: long
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:488)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r19v2 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r19v2 ??, new type: long
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:488)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r19v3 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r19v3 ??, new type: long
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:488)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r19v4 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r19v4 ??, new type: long
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:488)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r19v5 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r19v5 ??, new type: long
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:488)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r19v6 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r19v6 ??, new type: long
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:488)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r19v7 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r19v7 ??, new type: long
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:488)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r19v8 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r19v8 ??, new type: long
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:488)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r26v0 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r26v0 ??, new type: long
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:488)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r26v1 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r26v1 ??, new type: long
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:488)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r26v2 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r26v2 ??, new type: long
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:488)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r31v1 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r31v1 ??, new type: long
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:488)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r31v2 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r31v2 ??, new type: long
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:488)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r31v4 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r31v4 ??, new type: long
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:488)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r31v5 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r31v5 ??, new type: long
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:488)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r3v8 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r3v8 ??, new type: long
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:488)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r3v9 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r3v9 ??, new type: long
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:488)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r40v0 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r40v0 ??, new type: long
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:488)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r44v0 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r44v0 ??, new type: long
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:488)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r46v1 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r46v1 ??, new type: long
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:488)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r46v2 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r46v2 ??, new type: long
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:488)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r48v0 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r48v0 ??, new type: long
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:488)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r4v1 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r4v1 ??, new type: long[]
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.calculateFromBounds(FixTypesVisitor.java:159)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.setBestType(FixTypesVisitor.java:136)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:241)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:488)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 6 more
     */
    /* JADX WARN: Failed to calculate best type for var: r4v1 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r4v1 ??, new type: long[]
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:488)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r4v2 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r4v2 ??, new type: long[]
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:488)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r4v8 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r4v8 ??, new type: long[]
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:488)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r50v0 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r50v0 ??, new type: long
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:488)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r52v0 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r52v0 ??, new type: long
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:488)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r52v1 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r52v1 ??, new type: long
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:488)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r52v2 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r52v2 ??, new type: long
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:488)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r54v1 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r54v1 ??, new type: long
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:488)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r54v10 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r54v10 ??, new type: long
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:488)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r54v11 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r54v11 ??, new type: long
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:488)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r54v2 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r54v2 ??, new type: long
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:488)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r54v3 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r54v3 ??, new type: long
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:488)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r54v4 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r54v4 ??, new type: long
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:488)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r54v5 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r54v5 ??, new type: long
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:488)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r7v10 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r7v10 ??, new type: long
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:488)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r7v11 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r7v11 ??, new type: long
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:488)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r7v12 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r7v12 ??, new type: long
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:488)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r7v13 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r7v13 ??, new type: long
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:488)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r7v16 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r7v16 ??, new type: long
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:488)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r7v17 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r7v17 ??, new type: long
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:488)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r7v18 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r7v18 ??, new type: long
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:488)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r7v3 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r7v3 ??, new type: long
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:488)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r7v4 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r7v4 ??, new type: long
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:488)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r7v5 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r7v5 ??, new type: long
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:488)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r7v6 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r7v6 ??, new type: long
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:488)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r7v7 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r7v7 ??, new type: long
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:488)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r7v8 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r7v8 ??, new type: long
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:488)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r7v9 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r7v9 ??, new type: long
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:488)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r9v0 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r9v0 ??, new type: long
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.calculateFromBounds(FixTypesVisitor.java:159)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.setBestType(FixTypesVisitor.java:136)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:241)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:488)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 6 more
     */
    /* JADX WARN: Failed to calculate best type for var: r9v0 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r9v0 ??, new type: long
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:488)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r9v1 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r9v1 ??, new type: long
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:488)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r9v11 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r9v11 ??, new type: long
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:488)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r9v12 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r9v12 ??, new type: long
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:488)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r9v13 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r9v13 ??, new type: long
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:488)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r9v14 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r9v14 ??, new type: long
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:488)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r9v15 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r9v15 ??, new type: long
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:488)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r9v6 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r9v6 ??, new type: long
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:488)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r9v7 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r9v7 ??, new type: long
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:488)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /*  JADX ERROR: Types fix failed
        jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r9v0 ??, new type: long
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryPossibleTypes(FixTypesVisitor.java:186)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:245)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
        Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:488)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
        	... 5 more
        */
    void reportMemUsage(java.util.ArrayList<com.android.server.am.ProcessMemInfo> r72) {
        /*  JADX ERROR: Simple mode code generation failed
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0028: NEW_ARRAY (r4v1 ?? I:long[]) = (4 int) A[DECLARE_VAR] (LINE:1840) type: long[] in method: com.android.server.am.AppProfiler.reportMemUsage(java.util.ArrayList<com.android.server.am.ProcessMemInfo>):void, file: classes.dex
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
            	at jadx.core.codegen.MethodGen.generateSimpleCode(MethodGen.java:348)
            	at jadx.core.codegen.MethodGen.addSimpleMethodCode(MethodGen.java:316)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:279)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
            Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.ArgType.getPrimitiveType()" because "type" is null
            	at jadx.core.codegen.ClassGen.useType(ClassGen.java:564)
            	at jadx.core.codegen.InsnGen.useType(InsnGen.java:269)
            	at jadx.core.codegen.InsnGen.declareVar(InsnGen.java:166)
            	at jadx.core.codegen.InsnGen.declareVar(InsnGen.java:159)
            	at jadx.core.codegen.InsnGen.assignVar(InsnGen.java:152)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:299)
            	... 31 more
            */
        /*
            Method dump skipped, instruction units count: 1634
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.server.am.AppProfiler.reportMemUsage(java.util.ArrayList):void");
    }

    private static /* synthetic */ boolean lambda$reportMemUsage$5(ProcessCpuTracker.Stats st) {
        if (st.vsize <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    private void handleMemoryPressureChangedLocked(int oldMemFactor, int newMemFactor) {
        this.mService.mServices.rescheduleServiceRestartOnMemoryPressureIfNeededLocked(oldMemFactor, newMemFactor, "mem-pressure-event", SystemClock.uptimeMillis());
    }

    private void stopProfilerLPf(ProcessRecord proc, ProfilerInfo profilerInfo, int profileType) {
        if (proc != null) goto L4;
    L5:
        proc = this.mProfileData.getProfileProc();
        profileType = this.mProfileType;
        clearProfilerLPf();
    L6:
        if (proc != null) goto L8;
        return;
    L8:
        IApplicationThread thread = proc.mProfile.getThread();
        if (thread != null) goto L17;
        return;
    L17:
        thread.profilerControl(false, profilerInfo, profileType);     // Catch: RemoteException -> L14
        return;
    L16:
        throw new IllegalStateException("Process disappeared");
    L4:
        if (proc != this.mProfileData.getProfileProc()) goto L6;
        goto L5
    }

    void clearProfilerLPf() {
        if (this.mProfileData.getProfilerInfo() != null) goto L5;
    L9:
        this.mProfileData.setProfileApp(null);
        this.mProfileData.setProfileProc(null);
        this.mProfileData.setProfilerInfo(null);
        return;
    L5:
        if (this.mProfileData.getProfilerInfo().profileFd == null) goto L9;
        this.mProfileData.getProfilerInfo().profileFd.close();     // Catch: IOException -> L8
        goto L9
    }

    void clearProfilerLPf(ProcessRecord app) {
        if (this.mProfileData.getProfileProc() != null) goto L5;
        return;
    L5:
        if (this.mProfileData.getProfilerInfo() != null) goto L7;
        return;
    L7:
        if (this.mProfileData.getProfileProc() != app) goto L13;
        clearProfilerLPf();
        return;
    }

    boolean profileControlLPf(ProcessRecord proc, boolean start, ProfilerInfo profilerInfo, int profileType) {
        boolean r0 = false;
        if (start == false) goto L46;
        if (profileType != 0) goto L6;
        boolean needsFile = true;
    L95:
        stopProfilerLPf(null, null, 0);     // Catch: Throwable -> L41 RemoteException -> L43
        ActivityManagerService r4 = this.mService;     // Catch: Throwable -> L41 RemoteException -> L43
        ApplicationInfo r5 = proc.info;     // Catch: Throwable -> L41 RemoteException -> L43
        String r6 = proc.processName;     // Catch: Throwable -> L41 RemoteException -> L43
        if (proc.isSdkSandbox == true) goto L93;
        ApplicationInfo r8 = null;
    L18:
        r4.setProfileApp(r5, r6, profilerInfo, r8, profileType);     // Catch: Throwable -> L23 RemoteException -> L25
        this.mProfileData.setProfileProc(proc);     // Catch: Throwable -> L23 RemoteException -> L25
        this.mProfileType = profileType;     // Catch: Throwable -> L23 RemoteException -> L25
        if (needsFile == true) goto L85;
    L30:
        proc.mProfile.getThread().profilerControl(start, profilerInfo, profileType);     // Catch: Throwable -> L23 RemoteException -> L25
        if (needsFile == true) goto L89;
    L39:
        ProfilerInfo profilerInfo2 = profilerInfo;
    L64:
        if (profilerInfo2 != null) goto L66;
    L70:
        return true;
    L66:
        if (profilerInfo2.profileFd == null) goto L70;
        profilerInfo2.profileFd.close();     // Catch: IOException -> L69
        goto L70
    L89:
        this.mProfileData.getProfilerInfo().profileFd.close();     // Catch: Throwable -> L23 RemoteException -> L25 IOException -> L35
    L36:
        this.mProfileData.getProfilerInfo().profileFd = null;     // Catch: Throwable -> L23 RemoteException -> L25
        if (proc.getPid() != ActivityManagerService.MY_PID) goto L39;
        profilerInfo2 = null;
        goto L64
    L85:
        ParcelFileDescriptor fd = profilerInfo.profileFd.dup();     // Catch: Throwable -> L23 RemoteException -> L25 IOException -> L27
    L29:
        profilerInfo.profileFd = fd;     // Catch: Throwable -> L23 RemoteException -> L25
    L28:
        fd = null;
        goto L29
    L93:
        r8 = proc.getClientInfoForSdkSandbox();     // Catch: Throwable -> L12 RemoteException -> L14
        goto L18
    L12:
        th = move-exception;
        Throwable r13 = th;
    L74:
        if (profilerInfo != 0) goto L76;
        throw r13;
    L76:
        if (profilerInfo.profileFd == null) goto L98;
        profilerInfo.profileFd.close();     // Catch: IOException -> L79
        throw r13;
    L80:
        throw r13;
    L98:
        throw r13;
    L41:
        th = move-exception;
        r13 = th;
        goto L74
    L6:
        needsFile = false;
        goto L95
    L46:
        if (profileType != 1) goto L48;
        r0 = true;
    L48:
        boolean mayNeedFile = r0;
        if (profilerInfo != null) goto L51;
    L61:
        stopProfilerLPf(proc, profilerInfo, profileType);     // Catch: Throwable -> L23 RemoteException -> L25
        profilerInfo2 = profilerInfo;
        goto L64
    L51:
        if (profilerInfo.profileFd == null) goto L61;
        ParcelFileDescriptor fd2 = profilerInfo.profileFd;     // Catch: Throwable -> L23 RemoteException -> L25
        if (mayNeedFile == false) goto L57;
        fd2 = fd2.dup();     // Catch: Throwable -> L23 RemoteException -> L25 IOException -> L55
    L81:
    L60:
        profilerInfo.profileFd = fd2;     // Catch: Throwable -> L23 RemoteException -> L25
        goto L61
    L57:
        fd2.close();     // Catch: Throwable -> L23 RemoteException -> L25 IOException -> L55
    L59:
        fd2 = null;
    L23:
        th = move-exception;
        r13 = th;
    L73:
        throw new IllegalStateException("Process disappeared");     // Catch: Throwable -> L23
    }

    void setProfileAppLPf(String processName, ProfilerInfo profilerInfo, int profileType) {
        this.mProfileData.setProfileApp(processName);
        if (this.mProfileData.getProfilerInfo() != null) goto L5;
    L9:
        if (profilerInfo == null) goto L11;
        this.mProfileData.setProfilerInfo(new ProfilerInfo(profilerInfo));
    L11:
        this.mProfileType = profileType;
        return;
    L5:
        if (this.mProfileData.getProfilerInfo().profileFd == null) goto L9;
        this.mProfileData.getProfilerInfo().profileFd.close();     // Catch: IOException -> L8
        goto L9
    }

    void setProfileProcLPf(ProcessRecord proc) {
        this.mProfileData.setProfileProc(proc);
    }

    void setAgentAppLPf(String packageName, String agent) {
        if (agent != null) goto L9;
        if (this.mAppAgentMap == null) goto L17;
        this.mAppAgentMap.remove(packageName);
        if (this.mAppAgentMap.isEmpty() == false) goto L18;
        this.mAppAgentMap = null;
        return;
    L18:
        return;
    L17:
        return;
    L9:
        if (this.mAppAgentMap != null) goto L12;
        this.mAppAgentMap = new HashMap();
    L12:
        if (this.mAppAgentMap.size() < 100) goto L15;
        Slog.e("ActivityManager", "App agent map has too many entries, cannot add " + packageName + SliceClientPermissions.SliceAuthority.DELIMITER + agent);
        return;
    L15:
        this.mAppAgentMap.put(packageName, agent);
    }

    void updateCpuStats() {
        long now = SystemClock.uptimeMillis();
        if (this.mLastCpuTime.get() < (now - MONITOR_CPU_MIN_TIME)) goto L6;
        return;
    L6:
        if (this.mProcessCpuMutexFree.compareAndSet(true, false) == false) goto L15;
        Thread r2 = this.mProcessCpuThread;
        monitor-enter(r2);
        this.mProcessCpuThread.notify();     // Catch: Throwable -> L12
        monitor-exit(r2);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    }

    void updateCpuStatsNow() {
        if (this.mService.mSystemReady == true) goto L5;
    L7:
        boolean r0 = false;
    L8:
        boolean monitorPhantomProcs = r0;
        ProcessCpuTracker r4 = this.mProcessCpuTracker;
        monitor-enter(r4);
        this.mProcessCpuMutexFree.set(false);     // Catch: Throwable -> L127
        long now = SystemClock.uptimeMillis();     // Catch: Throwable -> L127
        boolean haveNewCpuStats = false;
        if (this.mLastCpuTime.get() < (now - MONITOR_CPU_MIN_TIME)) goto L141;
    L23:
        boolean haveNewCpuStats2 = haveNewCpuStats;
        if (monitorPhantomProcs == false) goto L27;
        if (haveNewCpuStats2 == false) goto L27;
        this.mService.mPhantomProcessList.updateProcessCpuStatesLocked(this.mProcessCpuTracker);     // Catch: Throwable -> L21
    L21:
        th = th;
    L129:
        monitor-exit(r4);     // Catch: Throwable -> L123
        throw th;
    L27:
        BatteryStatsImpl bstats = this.mService.mBatteryStatsService.getActiveStatistics();     // Catch: Throwable -> L127
        monitor-enter(bstats);     // Catch: Throwable -> L127
        if (haveNewCpuStats2 == true) goto L156;
        ProcessCpuTracker r21 = r4;
    L118:
        if (this.mLastWriteTime >= (now - 1800000)) goto L120;
        this.mLastWriteTime = now;     // Catch: Throwable -> L105
        this.mService.mBatteryStatsService.scheduleWriteToDisk();     // Catch: Throwable -> L105
    L120:
        monitor-exit(bstats);     // Catch: Throwable -> L105
        monitor-exit(r21);     // Catch: Throwable -> L123
        return;
    L156:
    L113:
        th = th;
    L125:
        monitor-exit(bstats);     // Catch: Throwable -> L105
        throw th;     // Catch: Throwable -> L123
    L31:
        if (bstats.startAddingCpuStatsLocked() == false) goto L115;
        int statsCount = this.mProcessCpuTracker.countStats();     // Catch: Throwable -> L113
        long elapsedRealtime = SystemClock.elapsedRealtime();     // Catch: Throwable -> L113
        long uptime = SystemClock.uptimeMillis();     // Catch: Throwable -> L113
        ActivityManagerService.PidMap r15 = this.mService.mPidsSelfLocked;     // Catch: Throwable -> L113
        monitor-enter(r15);     // Catch: Throwable -> L113
        int totalSTime = 0;
        int totalUTime = 0;
        int totalSTime2 = 0;
    L35:
        if (totalUTime >= statsCount) goto L101;
        boolean haveNewCpuStats3 = haveNewCpuStats2;
        ProcessCpuTracker.Stats st = this.mProcessCpuTracker.getStats(totalUTime);     // Catch: Throwable -> L99
        int i = totalUTime;
        if (st.working == true) goto L40;
        long elapsedRealtime2 = elapsedRealtime;
        uptime = uptime;
    L86:
        totalUTime = i + 1;
        haveNewCpuStats2 = haveNewCpuStats3;
        monitorPhantomProcs = monitorPhantomProcs;
        r4 = r4;
        elapsedRealtime = elapsedRealtime2;
        uptime = uptime;
        goto L35
    L40:
        ProcessRecord pr = this.mService.mPidsSelfLocked.get(st.pid);     // Catch: Throwable -> L97
        int totalUTime2 = st.rel_utime + totalSTime;
        int totalUTime3 = st.rel_stime;     // Catch: Throwable -> L95
        int totalSTime3 = totalSTime2 + totalUTime3;
        if (pr != null) goto L154;
        int totalUTime4 = totalUTime2;
        elapsedRealtime2 = elapsedRealtime;
        BatteryStatsImpl.Uid.Proc ps = (BatteryStatsImpl.Uid.Proc) st.batteryStats;     // Catch: Throwable -> L93
        if (ps != null) goto L73;
    L76:
        BatteryStatsImpl.Uid.Proc r3 = bstats.getProcessStatsLocked(st.uid, st.name, elapsedRealtime2, uptime);     // Catch: Throwable -> L91
        ps = r3;
        st.batteryStats = r3;     // Catch: Throwable -> L89
    L81:
        ps.addCpuTimeLocked(st.rel_utime, st.rel_stime);     // Catch: Throwable -> L89
    L144:
        EventLogTags.writeAmCpu(st.pid, st.uid, st.baseName, st.rel_uptime, st.rel_utime, st.rel_stime);     // Catch: Throwable -> L87
        totalSTime2 = totalSTime3;
        totalSTime = totalUTime4;
    L87:
        th = th;
    L150:
        monitor-exit(r15);     // Catch: Throwable -> L111
        throw th;     // Catch: Throwable -> L105
    L111:
        th = th;
    L89:
        th = th;
    L91:
        th = th;
        goto L150
    L73:
        if (ps.isActive() == true) goto L81;
    L93:
        th = th;
        goto L150
    L154:
        ProcessProfileRecord profile = pr.mProfile;     // Catch: Throwable -> L67
        BatteryStatsImpl.Uid.Proc ps2 = profile.getCurProcBatteryStats();     // Catch: Throwable -> L67
        if (ps2 != null) goto L152;
    L56:
        int r9 = pr.info.uid;     // Catch: Throwable -> L67
        String r10 = pr.processName;     // Catch: Throwable -> L67
        ProcessProfileRecord profile2 = profile;
        BatteryStatsImpl.Uid.Proc ps3 = bstats.getProcessStatsLocked(r9, r10, elapsedRealtime, uptime);     // Catch: Throwable -> L67
        profile2.setCurProcBatteryStats(ps3);     // Catch: Throwable -> L67
        BatteryStatsImpl.Uid.Proc ps4 = ps3;
    L57:
        int r11 = st.rel_utime;     // Catch: Throwable -> L67
        totalUTime4 = totalUTime2;
        int totalUTime5 = st.rel_stime;     // Catch: Throwable -> L65
        ps4.addCpuTimeLocked(r11, totalUTime5);     // Catch: Throwable -> L65
        long curCpuTime = profile2.mCurCpuTime.addAndGet(st.rel_utime + st.rel_stime);     // Catch: Throwable -> L65
        elapsedRealtime2 = elapsedRealtime;
        profile2.mLastCpuTime.compareAndSet(0, curCpuTime);     // Catch: Throwable -> L63
        uptime = uptime;
    L63:
        th = th;
    L65:
        th = th;
        goto L150
    L152:
        if (ps2.isActive() == false) goto L56;
        profile2 = profile;
        ps4 = ps2;
    L54:
        th = th;
    L67:
        th = th;
    L95:
        th = th;
    L97:
        th = th;
    L99:
        th = th;
        goto L150
    L101:
        r21 = r4;
        monitor-exit(r15);     // Catch: Throwable -> L107
        int userTime = this.mProcessCpuTracker.getLastUserTime();     // Catch: Throwable -> L105
        int systemTime = this.mProcessCpuTracker.getLastSystemTime();     // Catch: Throwable -> L105
        int iowaitTime = this.mProcessCpuTracker.getLastIoWaitTime();     // Catch: Throwable -> L105
        int irqTime = this.mProcessCpuTracker.getLastIrqTime();     // Catch: Throwable -> L105
        int softIrqTime = this.mProcessCpuTracker.getLastSoftIrqTime();     // Catch: Throwable -> L105
        int idleTime = this.mProcessCpuTracker.getLastIdleTime();     // Catch: Throwable -> L105
        bstats.addCpuStatsLocked(totalSTime, totalSTime2, userTime, systemTime, iowaitTime, irqTime, softIrqTime, idleTime);     // Catch: Throwable -> L105
        bstats.finishAddingCpuStatsLocked();     // Catch: Throwable -> L105
    L107:
        th = th;
        goto L150
    L115:
        r21 = r4;
    L105:
        th = th;
        goto L125
    L141:
        this.mLastCpuTime.set(now);     // Catch: Throwable -> L21
        this.mProcessCpuTracker.update();     // Catch: Throwable -> L21
        if (this.mProcessCpuTracker.hasGoodLastStats() == false) goto L23;
        haveNewCpuStats = true;
        if ("true".equals(SystemProperties.get("events.cpu")) == false) goto L23;
        int user = this.mProcessCpuTracker.getLastUserTime();     // Catch: Throwable -> L21
        int system = this.mProcessCpuTracker.getLastSystemTime();     // Catch: Throwable -> L21
        int iowait = this.mProcessCpuTracker.getLastIoWaitTime();     // Catch: Throwable -> L21
        int irq = this.mProcessCpuTracker.getLastIrqTime();     // Catch: Throwable -> L21
        int softIrq = this.mProcessCpuTracker.getLastSoftIrqTime();     // Catch: Throwable -> L21
        int idle = this.mProcessCpuTracker.getLastIdleTime();     // Catch: Throwable -> L21
        int total = ((((user + system) + iowait) + irq) + softIrq) + idle;     // Catch: Throwable -> L21
        if (total != 0) goto L20;
        total = 1;
    L20:
        EventLogTags.writeCpu((((((user + system) + iowait) + irq) + softIrq) * 100) / total, (user * 100) / total, (system * 100) / total, (iowait * 100) / total, (irq * 100) / total, (softIrq * 100) / total);     // Catch: Throwable -> L21
    L127:
        th = th;
    L123:
        th = th;
        goto L129
    L5:
        if (FeatureFlagUtils.isEnabled(this.mService.mContext, "settings_enable_monitor_phantom_procs") == false) goto L7;
        r0 = true;
        goto L8
    }

    long getCpuTimeForPid(int pid) {
        return this.mProcessCpuTracker.getCpuTimeForPid(pid);
    }

    long getCpuDelayTimeForPid(int pid) {
        return this.mProcessCpuTracker.getCpuDelayTimeForPid(pid);
    }

    List<ProcessCpuTracker.Stats> getCpuStats(final Predicate<ProcessCpuTracker.Stats> predicate) {
        ProcessCpuTracker r0 = this.mProcessCpuTracker;
        monitor-enter(r0);
        List<ProcessCpuTracker.Stats> r1 = this.mProcessCpuTracker.getStats(new AppProfiler$$ExternalSyntheticLambda6(predicate));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    private static /* synthetic */ boolean lambda$getCpuStats$6(Predicate predicate, ProcessCpuTracker.Stats st) {
        return predicate.test(st);
    }

    void forAllCpuStats(Consumer<ProcessCpuTracker.Stats> consumer) {
        ProcessCpuTracker r0 = this.mProcessCpuTracker;
        monitor-enter(r0);
        int numOfStats = this.mProcessCpuTracker.countStats();     // Catch: Throwable -> L7
        int i = 0;
    L5:
        if (i >= numOfStats) goto L10;
        consumer.accept(this.mProcessCpuTracker.getStats(i));     // Catch: Throwable -> L7
        i = i + 1;     // Catch: Throwable -> L7
        goto L5
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    void setCpuInfoService() {
        ServiceManager.addService("cpuinfo", new CpuBinder(this), false, 1);
    }

    AppProfiler(ActivityManagerService service, Looper bgLooper, LowMemDetector detector) {
        this.mPssDeferralTime = 0;
        this.mPendingPssOrRssProfiles = new ArrayList();
        this.mActivityStartingNesting = new AtomicInteger(0);
        this.mLastFullPssTime = SystemClock.uptimeMillis();
        this.mFullPssOrRssPending = false;
        this.mTestPssOrRssMode = false;
        this.mAllowLowerMemLevel = false;
        this.mLastMemoryLevel = 0;
        this.mMemFactorOverride = -1;
        this.mLowRamTimeSinceLastIdle = 0;
        this.mLowRamStartTime = 0;
        this.mLastMemUsageReportTime = 0;
        this.mProcessesToGc = new ArrayList();
        this.mAppAgentMap = null;
        this.mProfileType = 0;
        this.mProfileData = new ProfileData(this, null);
        this.mMemWatchProcesses = new ProcessMap();
        this.mProcessCpuTracker = new ProcessCpuTracker(false);
        this.mLastCpuTime = new AtomicLong(0);
        this.mProcessCpuMutexFree = new AtomicBoolean(true);
        this.mProcessCpuInitLatch = new CountDownLatch(1);
        this.mLastWriteTime = 0;
        this.mCachedAppsWatermarkData = new CachedAppsWatermarkData(this);
        this.mProfilerLock = new Object();
        this.mPssDelayConfigListener = new AnonymousClass1(this);
        this.mSmtEx = new AppProfilerSmtBase();
        this.mService = service;
        this.mProcLock = service.mProcLock;
        this.mBgHandler = new BgHandler(this, bgLooper);
        this.mLowMemDetector = detector;
        this.mProcessCpuThread = new ProcessCpuThread(this, "CpuTracker");
    }

    void retrieveSettings() {
        long pssDeferralMs = DeviceConfig.getLong("activity_manager", ACTIVITY_START_PSS_DEFER_CONFIG, 0);
        DeviceConfig.addOnPropertiesChangedListener("activity_manager", ActivityThread.currentApplication().getMainExecutor(), this.mPssDelayConfigListener);
        this.mPssDeferralTime = pssDeferralMs;
    }

    void onActivityManagerInternalAdded() {
        this.mProcessCpuThread.start();
        this.mProcessCpuInitLatch.await();     // Catch: InterruptedException -> L5
        return;
    L5:
        e = move-exception;
        Slog.wtf("ActivityManager", "Interrupted wait during start", e);
        Thread.currentThread().interrupt();
        throw new IllegalStateException("Interrupted wait during start");
    }

    void onActivityLaunched() {
        if (this.mPssDeferralTime <= 0) goto L6;
        Message msg = this.mBgHandler.obtainMessage(2);
        this.mBgHandler.sendMessageAtFrontOfQueue(msg);
        return;
    }

    ProfilerInfo setupProfilerInfoLocked(IApplicationThread thread, ProcessRecord app, ActiveInstrumentation instr) throws IOException, RemoteException {
        ProfilerInfo profilerInfo = null;
        String preBindAgent = null;
        String processName = app.processName;
        Object r8 = this.mProfilerLock;
        monitor-enter(r8);
    L16:
        th = move-exception;
        throw th;
    L5:
        if (this.mProfileData.getProfileApp() != null) goto L7;
    L27:
        if (instr != null) goto L29;
    L32:
        if (this.mAppAgentMap != null) goto L34;
    L43:
        if (profilerInfo != null) goto L45;
    L51:
        monitor-exit(r8);     // Catch: Throwable -> L16
        if (this.mService.mActiveInstrumentation.size() <= 0) goto L84;
        if (instr != null) goto L84;
        int i = this.mService.mActiveInstrumentation.size() - 1;
    L56:
        if (i < 0) goto L84;
        if (app.getActiveInstrumentation() != null) goto L84;
        ActiveInstrumentation aInstr = this.mService.mActiveInstrumentation.get(i);
        if (aInstr.mFinished == true) goto L83;
        if (aInstr.mTargetInfo.uid != app.uid) goto L83;
        ActivityManagerGlobalLock r11 = this.mProcLock;
        ActivityManagerService.boostPriorityForProcLockedSection();
        monitor-enter(r11);
        if (aInstr.mTargetProcesses.length == 0) goto L68;
        String[] r0 = aInstr.mTargetProcesses;     // Catch: Throwable -> L70
        int r12 = r0.length;     // Catch: Throwable -> L70
        int r13 = 0;
    L73:
        if (r13 >= r12) goto L78;
        String proc = r0[r13];     // Catch: Throwable -> L70
        if (proc.equals(app.processName) == true) goto L76;
        r13 = r13 + 1;     // Catch: Throwable -> L70
        goto L73
    L76:
        this.mService.mProcessStateController.setActiveInstrumentation(app, aInstr);     // Catch: Throwable -> L70
        aInstr.mRunningProcesses.add(app);     // Catch: Throwable -> L70
    L78:
        monitor-exit(r11);     // Catch: Throwable -> L70
        ActivityManagerService.resetPriorityAfterProcLockedSection();
        goto L83
    L68:
        if (aInstr.mTargetInfo.packageName.equals(app.info.packageName) == false) goto L78;
        this.mService.mProcessStateController.setActiveInstrumentation(app, aInstr);     // Catch: Throwable -> L70
        aInstr.mRunningProcesses.add(app);     // Catch: Throwable -> L70
    L70:
        th = move-exception;
        ActivityManagerService.resetPriorityAfterProcLockedSection();
        throw th;
    L83:
        i = i - 1;
    L84:
        if (preBindAgent == null) goto L87;
        thread.attachAgent(preBindAgent);
    L87:
        if (app.isDebuggable() == false) goto L89;
        thread.attachStartupAgents(app.info.dataDir);
    L89:
        return profilerInfo;
    L45:
        if (profilerInfo.profileFd == null) goto L51;
        profilerInfo.profileFd = profilerInfo.profileFd.dup();     // Catch: Throwable -> L16
        if (TextUtils.equals(this.mProfileData.getProfileApp(), processName) == false) goto L51;
        if (this.mProfileData.getProfilerInfo() == null) goto L51;
        clearProfilerLPf();     // Catch: Throwable -> L16
        goto L51
    L34:
        if (this.mAppAgentMap.containsKey(processName) == false) goto L43;
        if (app.isDebuggable() == false) goto L43;
        String r1 = this.mAppAgentMap.get(processName);     // Catch: Throwable -> L16
        if (profilerInfo != null) goto L41;
        profilerInfo = new ProfilerInfo(null, null, 0, false, false, this.mAppAgentMap.get(processName), true, 0, 1);     // Catch: Throwable -> L16
        goto L43
    L41:
        if (profilerInfo.agent != null) goto L43;
        profilerInfo = profilerInfo.setAgent(this.mAppAgentMap.get(processName), true);     // Catch: Throwable -> L16
        goto L43
    L29:
        if (instr.mProfileFile == null) goto L32;
        profilerInfo = new ProfilerInfo(instr.mProfileFile, null, 0, false, false, null, false, 0, 1);     // Catch: Throwable -> L16
        goto L32
    L7:
        if (this.mProfileData.getProfileApp().equals(processName) == false) goto L27;
        this.mProfileData.setProfileProc(app);     // Catch: Throwable -> L16
        if (this.mProfileData.getProfilerInfo() == null) goto L32;
        if (this.mProfileData.getProfilerInfo().profileFile == null) goto L13;
    L18:
        boolean needsInfo = true;
    L20:
        if (needsInfo == false) goto L22;
        ProfilerInfo r14 = new ProfilerInfo(this.mProfileData.getProfilerInfo());     // Catch: Throwable -> L16
    L23:
        profilerInfo = r14;
        if (this.mProfileData.getProfilerInfo().agent == null) goto L32;
        preBindAgent = this.mProfileData.getProfilerInfo().agent;     // Catch: Throwable -> L16
        goto L32
    L22:
        r14 = null;
        goto L23
    L13:
        if (this.mProfileData.getProfilerInfo().attachAgentDuringBind == true) goto L18;
        needsInfo = false;
        goto L20
    }

    void onCleanupApplicationRecordLocked(ProcessRecord app) {
        Object r0 = this.mProfilerLock;
        monitor-enter(r0);
        ProcessProfileRecord profile = app.mProfile;     // Catch: Throwable -> L7
        this.mProcessesToGc.remove(app);     // Catch: Throwable -> L7
        this.mPendingPssOrRssProfiles.remove(profile);     // Catch: Throwable -> L7
        profile.abortNextPssTime();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    void onAppDiedLocked(ProcessRecord app) {
        Object r0 = this.mProfilerLock;
        monitor-enter(r0);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (this.mProfileData.getProfileProc() != app) goto L9;
        clearProfilerLPf();     // Catch: Throwable -> L7
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L7
    }

    boolean dumpMemWatchProcessesLPf(PrintWriter pw, boolean needSep) {
        if (this.mMemWatchProcesses.getMap().size() <= 0) goto L16;
        pw.println("  Mem watch processes:");
        ArrayMap<String, SparseArray<Pair<Long, String>>> procs = this.mMemWatchProcesses.getMap();
        int i = procs.size() - 1;
    L5:
        if (i < 0) goto L15;
        String proc = procs.keyAt(i);
        SparseArray<Pair<Long, String>> uids = procs.valueAt(i);
        int j = uids.size() - 1;
    L7:
        if (j < 0) goto L14;
        if (needSep == false) goto L10;
        pw.println();
        needSep = false;
    L10:
        StringBuilder sb = new StringBuilder();
        sb.append("    ");
        sb.append(proc);
        sb.append('/');
        UserHandle.formatUid(sb, uids.keyAt(j));
        Pair<Long, String> val = uids.valueAt(j);
        sb.append(": ");
        DebugUtils.sizeValueToString(((Long) val.first).longValue(), sb);
        if (val.second == null) goto L13;
        sb.append(", report to ");
        sb.append((String) val.second);
    L13:
        pw.println(sb.toString());
        j = j - 1;
        goto L7
    L14:
        i = i - 1;
        goto L5
    L15:
        pw.print("  mMemWatchDumpProcName=");
        pw.println(this.mMemWatchDumpProcName);
        pw.print("  mMemWatchDumpUri=");
        pw.println(this.mMemWatchDumpUri);
        pw.print("  mMemWatchDumpPid=");
        pw.println(this.mMemWatchDumpPid);
        pw.print("  mMemWatchDumpUid=");
        pw.println(this.mMemWatchDumpUid);
        pw.print("  mMemWatchIsUserInitiated=");
        pw.println(this.mMemWatchIsUserInitiated);
    L16:
        return needSep;
    }

    boolean dumpProfileDataLocked(PrintWriter pw, String dumpPackage, boolean needSep) {
        if (this.mProfileData.getProfileApp() == null) goto L5;
    L12:
        if (dumpPackage != null) goto L14;
    L15:
        if (needSep == false) goto L17;
        pw.println();
        needSep = false;
    L17:
        pw.println("  mProfileApp=" + this.mProfileData.getProfileApp() + " mProfileProc=" + this.mProfileData.getProfileProc());
        if (this.mProfileData.getProfilerInfo() == null) goto L20;
        pw.println("  mProfileFile=" + this.mProfileData.getProfilerInfo().profileFile + " mProfileFd=" + this.mProfileData.getProfilerInfo().profileFd);
        pw.println("  mSamplingInterval=" + this.mProfileData.getProfilerInfo().samplingInterval + " mAutoStopProfiler=" + this.mProfileData.getProfilerInfo().autoStopProfiler + " mStreamingOutput=" + this.mProfileData.getProfilerInfo().streamingOutput + " mClockType=" + this.mProfileData.getProfilerInfo().clockType + " mProfilerOutputVersion=" + this.mProfileData.getProfilerInfo().profilerOutputVersion);
        StringBuilder r0 = new StringBuilder();
        r0.append("  mProfileType=");
        r0.append(this.mProfileType);
        pw.println(r0.toString());
    L20:
        return needSep;
    L14:
        if (dumpPackage.equals(this.mProfileData.getProfileApp()) == false) goto L20;
    L5:
        if (this.mProfileData.getProfileProc() != null) goto L12;
        if (this.mProfileData.getProfilerInfo() == null) goto L20;
        if (this.mProfileData.getProfilerInfo().profileFile != null) goto L12;
        if (this.mProfileData.getProfilerInfo().profileFd == null) goto L20;
        goto L12
    }

    void dumpLastMemoryLevelLocked(PrintWriter pw) {
        switch(this.mLastMemoryLevel) {
            case 0: goto L8;
            case 1: goto L7;
            case 2: goto L6;
            case 3: goto L5;
            default: goto L4;
        };
    L4:
        pw.print(this.mLastMemoryLevel);
        pw.println(")");
        return;
    L5:
        pw.println("critical)");
        return;
    L6:
        pw.println("low)");
        return;
    L7:
        pw.println("moderate)");
        return;
    L8:
        pw.println("normal)");
    }

    void dumpMemoryLevelsLocked(PrintWriter pw) {
        pw.println("  mAllowLowerMemLevel=" + this.mAllowLowerMemLevel + " mLastMemoryLevel=" + this.mLastMemoryLevel + " mLastNumProcesses=" + this.mLastNumProcesses);
    }

    void writeMemWatchProcessToProtoLPf(ProtoOutputStream proto) {
        if (this.mMemWatchProcesses.getMap().size() <= 0) goto L15;
        long token = proto.start(1146756268064L);
        ArrayMap<String, SparseArray<Pair<Long, String>>> procs = this.mMemWatchProcesses.getMap();
        int i = 0;
    L6:
        if (i >= procs.size()) goto L11;
        String proc = procs.keyAt(i);
        SparseArray<Pair<Long, String>> uids = procs.valueAt(i);
        long ptoken = proto.start(2246267895809L);
        proto.write(1138166333441L, proc);
        int j = uids.size() - 1;
    L8:
        if (j < 0) goto L10;
        long utoken = proto.start(2246267895810L);
        Pair<Long, String> val = uids.valueAt(j);
        ArrayMap<String, SparseArray<Pair<Long, String>>> procs2 = procs;
        proto.write(1120986464257L, uids.keyAt(j));
        proto.write(1138166333442L, DebugUtils.sizeValueToString(((Long) val.first).longValue(), new StringBuilder()));
        proto.write(1138166333443L, (String) val.second);
        proto.end(utoken);
        j = j - 1;
        proc = proc;
        procs = procs2;
        i = i;
        goto L8
    L10:
        proto.end(ptoken);
        i = i + 1;
        goto L6
    L11:
        long dtoken = proto.start(1146756268034L);
        proto.write(1138166333441L, this.mMemWatchDumpProcName);
        proto.write(1138166333446L, this.mMemWatchDumpUri.toString());
        proto.write(1120986464259L, this.mMemWatchDumpPid);
        proto.write(1120986464260L, this.mMemWatchDumpUid);
        proto.write(1133871366149L, this.mMemWatchIsUserInitiated);
        proto.end(dtoken);
        proto.end(token);
        return;
    }

    void writeProfileDataToProtoLocked(ProtoOutputStream proto, String dumpPackage) {
        if (this.mProfileData.getProfileApp() == null) goto L5;
    L12:
        if (dumpPackage != null) goto L14;
    L15:
        long token = proto.start(1146756268066L);
        proto.write(1138166333441L, this.mProfileData.getProfileApp());
        this.mProfileData.getProfileProc().dumpDebug(proto, 1146756268034L);
        if (this.mProfileData.getProfilerInfo() == null) goto L18;
        this.mProfileData.getProfilerInfo().dumpDebug(proto, 1146756268035L);
        proto.write(1120986464260L, this.mProfileType);
    L18:
        proto.end(token);
        return;
    L14:
        if (dumpPackage.equals(this.mProfileData.getProfileApp()) == true) goto L15;
        return;
    L5:
        if (this.mProfileData.getProfileProc() != null) goto L12;
        if (this.mProfileData.getProfilerInfo() != null) goto L9;
        return;
    L9:
        if (this.mProfileData.getProfilerInfo().profileFile != null) goto L12;
        if (this.mProfileData.getProfilerInfo().profileFd != null) goto L12;
    }

    void writeMemoryLevelsToProtoLocked(ProtoOutputStream proto) {
        proto.write(1133871366199L, this.mAllowLowerMemLevel);
        proto.write(1120986464312L, this.mLastMemoryLevel);
        proto.write(1120986464313L, this.mLastNumProcesses);
    }

    void printCurrentCpuState(StringBuilder report, long time) {
        ProcessCpuTracker r0 = this.mProcessCpuTracker;
        monitor-enter(r0);
        report.append(this.mProcessCpuTracker.printCurrentState(time, 10));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    Pair<String, String> getAppProfileStatsForDebugging(long time, int linesOfStats) {
        ProcessCpuTracker r2 = this.mProcessCpuTracker;
        monitor-enter(r2);
        updateCpuStatsNow();     // Catch: Throwable -> L14
        String cpuLoad = this.mProcessCpuTracker.printCurrentLoad();     // Catch: Throwable -> L14
        String stats = this.mProcessCpuTracker.printCurrentState(time);     // Catch: Throwable -> L14
        monitor-exit(r2);     // Catch: Throwable -> L14
        int toIndex = 0;
        int i = 0;
    L7:
        if (i > linesOfStats) goto L13;
        int nextIndex = stats.indexOf(10, toIndex);
        if (nextIndex == (-1)) goto L10;
        toIndex = nextIndex + 1;
        i = i + 1;
        goto L7
    L10:
        toIndex = stats.length();
    L13:
        return new Pair(cpuLoad, stats.substring(0, toIndex));
    L14:
        th = move-exception;
        throw th;
    }

    void writeProcessesToGcToProto(ProtoOutputStream proto, long fieldId, String dumpPackage) {
        if (this.mProcessesToGc.size() <= 0) goto L13;
        long now = SystemClock.uptimeMillis();
        int i = 0;
        int size = this.mProcessesToGc.size();
    L5:
        if (i >= size) goto L17;
        ProcessRecord r = this.mProcessesToGc.get(i);
        if (dumpPackage != null) goto L9;
    L11:
        long token = proto.start(fieldId);
        ProcessProfileRecord profile = r.mProfile;
        r.dumpDebug(proto, 1146756268033L);
        proto.write(1133871366146L, profile.getReportLowMemory());
        proto.write(1112396529667L, now);
        proto.write(1112396529668L, profile.getLastRequestedGc());
        proto.write(1112396529669L, profile.getLastLowMemory());
        proto.end(token);
    L12:
        i = i + 1;
        goto L5
    L9:
        if (dumpPackage.equals(r.info.packageName) == true) goto L11;
    L17:
        return;
    }

    boolean dumpProcessesToGc(PrintWriter pw, boolean needSep, String dumpPackage) {
        if (this.mProcessesToGc.size() <= 0) goto L17;
        boolean printed = false;
        long now = SystemClock.uptimeMillis();
        int i = 0;
        int size = this.mProcessesToGc.size();
    L5:
        if (i >= size) goto L17;
        ProcessRecord proc = this.mProcessesToGc.get(i);
        if (dumpPackage != null) goto L9;
    L11:
        if (printed == true) goto L15;
        if (needSep == false) goto L14;
        pw.println();
    L14:
        needSep = true;
        pw.println("  Processes that are waiting to GC:");
        printed = true;
    L15:
        pw.print("    Process ");
        pw.println(proc);
        ProcessProfileRecord profile = proc.mProfile;
        pw.print("      lowMem=");
        pw.print(profile.getReportLowMemory());
        pw.print(", last gced=");
        pw.print(now - profile.getLastRequestedGc());
        pw.print(" ms ago, last lowMem=");
        pw.print(now - profile.getLastLowMemory());
        pw.println(" ms ago");
    L16:
        i = i + 1;
        goto L5
    L9:
        if (dumpPackage.equals(proc.info.packageName) == true) goto L11;
    L17:
        return needSep;
    }

    public LowMemDetector getLowMemDetector() {
        return this.mLowMemDetector;
    }

    public Handler getBgHandler() {
        return this.mBgHandler;
    }
}
