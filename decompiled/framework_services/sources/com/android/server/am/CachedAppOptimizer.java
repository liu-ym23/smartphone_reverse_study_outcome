package com.android.server.am;

import android.app.ActivityManagerInternal;
import android.app.ActivityThread;
import android.app.IApplicationThread;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.os.Process;
import android.os.RemoteException;
import android.os.SystemClock;
import android.os.SystemProperties;
import android.os.Trace;
import android.provider.DeviceConfig;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.ArraySet;
import android.util.BoostFramework;
import android.util.EventLog;
import android.util.IntArray;
import android.util.Pair;
import android.util.Slog;
import android.util.SparseArray;
import com.android.internal.os.BinderfsStatsReader;
import com.android.internal.os.ProcLocksReader;
import com.android.internal.util.FrameworkStatsLog;
import com.android.server.ServiceThread;
import com.android.server.SysOptBridge;
import com.android.server.am.compaction.CompactionStatsManager;
import com.android.server.am.compaction.SingleCompactionStats;
import com.android.server.job.controllers.JobStatus;
import com.android.server.slice.SliceClientPermissions;
import com.android.server.timezonedetector.ServiceConfigAccessor;
import dalvik.annotation.optimization.NeverCompile;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public class CachedAppOptimizer {
    static final int ASYNC_RECEIVED_WHILE_FROZEN = 2;
    private static final String ATRACE_COMPACTION_TRACK = "Compaction";
    public static final String ATRACE_FREEZER_TRACK = "Freezer";
    static final int BINDER_ERROR_MSG = 8;
    static final Uri CACHED_APP_FREEZER_ENABLED_URI = null;
    private static final int COMPACT_ACTION_ANON_FLAG = 2;
    private static final int COMPACT_ACTION_FILE_FLAG = 1;
    static final double COMPACT_DOWNGRADE_FREE_SWAP_THRESHOLD = 0.6d;
    static final int COMPACT_NATIVE_MSG = 5;
    static final int COMPACT_PROCESS_MSG = 1;
    static final int COMPACT_SYSTEM_MSG = 2;
    static final int DEADLOCK_WATCHDOG_MSG = 7;
    static final long DEFAULT_COMPACT_FULL_DELTA_RSS_THROTTLE_KB = 8000;
    static final long DEFAULT_COMPACT_FULL_RSS_THROTTLE_KB = 12000;
    static final String DEFAULT_COMPACT_PROC_STATE_THROTTLE = null;
    static final long DEFAULT_COMPACT_THROTTLE_1 = 5000;
    static final long DEFAULT_COMPACT_THROTTLE_2 = 10000;
    static final long DEFAULT_COMPACT_THROTTLE_3 = 500;
    static final long DEFAULT_COMPACT_THROTTLE_4 = 300000;
    static final long DEFAULT_COMPACT_THROTTLE_5 = 600000;
    static final long DEFAULT_COMPACT_THROTTLE_6 = 600000;
    static final long DEFAULT_COMPACT_THROTTLE_MAX_OOM_ADJ = 999;
    static final long DEFAULT_COMPACT_THROTTLE_MIN_OOM_ADJ = 900;
    static final int DEFAULT_FREEZER_BINDER_ASYNC_THRESHOLD = 1024;
    static final boolean DEFAULT_FREEZER_BINDER_CALLBACK_ENABLED = true;
    static final long DEFAULT_FREEZER_BINDER_CALLBACK_THROTTLE = 10000;
    static final long DEFAULT_FREEZER_BINDER_DIVISOR = 4;
    static final boolean DEFAULT_FREEZER_BINDER_ENABLED = true;
    static final int DEFAULT_FREEZER_BINDER_OFFSET = 500;
    static final long DEFAULT_FREEZER_BINDER_THRESHOLD = 1000;
    static final long DEFAULT_FREEZER_DEBOUNCE_TIMEOUT = 10000;
    static final boolean DEFAULT_FREEZER_EXEMPT_INST_PKG = false;
    static final float DEFAULT_STATSD_SAMPLE_RATE = 0.1f;
    static final boolean DEFAULT_USE_COMPACTION = true;
    static final boolean DEFAULT_USE_FREEZER = true;
    static final int DO_FREEZE = 1;
    static final boolean ENABLE_SHARED_AND_CODE_COMPACT = false;
    private static final int FREEZE_BINDER_TIMEOUT_MS = 0;
    private static final int FREEZE_DEADLOCK_TIMEOUT_MS = 1000;
    static final String KEY_COMPACTION_PRIORITY = "compaction_priority";
    static final String KEY_COMPACT_FULL_DELTA_RSS_THROTTLE_KB = "compact_full_delta_rss_throttle_kb";
    static final String KEY_COMPACT_FULL_RSS_THROTTLE_KB = "compact_full_rss_throttle_kb";
    static final String KEY_COMPACT_PROC_STATE_THROTTLE = "compact_proc_state_throttle";
    static final String KEY_COMPACT_STATSD_SAMPLE_RATE = "compact_statsd_sample_rate";
    static final String KEY_COMPACT_THROTTLE_1 = "compact_throttle_1";
    static final String KEY_COMPACT_THROTTLE_2 = "compact_throttle_2";
    static final String KEY_COMPACT_THROTTLE_3 = "compact_throttle_3";
    static final String KEY_COMPACT_THROTTLE_4 = "compact_throttle_4";
    static final String KEY_COMPACT_THROTTLE_5 = "compact_throttle_5";
    static final String KEY_COMPACT_THROTTLE_6 = "compact_throttle_6";
    static final String KEY_COMPACT_THROTTLE_MAX_OOM_ADJ = "compact_throttle_max_oom_adj";
    static final String KEY_COMPACT_THROTTLE_MIN_OOM_ADJ = "compact_throttle_min_oom_adj";
    static final String KEY_DEBUG_COMPACTION = "debug_compaction";
    static final String KEY_FREEZER_BINDER_ASYNC_THRESHOLD = "freeze_binder_async_threshold";
    static final String KEY_FREEZER_BINDER_CALLBACK_ENABLED = "freeze_binder_callback_enabled";
    static final String KEY_FREEZER_BINDER_CALLBACK_THROTTLE = "freeze_binder_callback_throttle";
    static final String KEY_FREEZER_BINDER_DIVISOR = "freeze_binder_divisor";
    static final String KEY_FREEZER_BINDER_ENABLED = "freeze_binder_enabled";
    static final String KEY_FREEZER_BINDER_OFFSET = "freeze_binder_offset";
    static final String KEY_FREEZER_BINDER_THRESHOLD = "freeze_binder_threshold";
    static final String KEY_FREEZER_DEBOUNCE_TIMEOUT = "freeze_debounce_timeout";
    static final String KEY_FREEZER_EXEMPT_INST_PKG = "freeze_exempt_inst_pkg";
    static final String KEY_FREEZER_STATSD_SAMPLE_RATE = "freeze_statsd_sample_rate";
    static final String KEY_USE_COMPACTION = "use_compaction";
    static final String KEY_USE_FREEZER = "use_freezer";
    static final int REPORT_UNFREEZE = 2;
    static final int REPORT_UNFREEZE_MSG = 4;
    private static final int RSS_ANON_INDEX = 2;
    private static final int RSS_FILE_INDEX = 1;
    private static final int RSS_SWAP_INDEX = 3;
    private static final int RSS_TOTAL_INDEX = 0;
    static final int SET_FROZEN_PROCESS_MSG = 3;
    static final int SYNC_RECEIVED_WHILE_FROZEN = 1;
    static final int TXNS_PENDING_WHILE_FROZEN = 4;
    static final int UID_FROZEN_STATE_CHANGED_MSG = 6;
    static final int UNFREEZE_REASON_ACTIVITY = 1;
    static final int UNFREEZE_REASON_ALLOWLIST = 10;
    static final int UNFREEZE_REASON_BACKUP = 22;
    static final int UNFREEZE_REASON_BINDER_TXNS = 18;
    static final int UNFREEZE_REASON_BIND_SERVICE = 4;
    static final int UNFREEZE_REASON_COMPONENT_DISABLED = 29;
    static final int UNFREEZE_REASON_EXECUTING_SERVICE = 27;
    static final int UNFREEZE_REASON_FEATURE_FLAGS = 19;
    static final int UNFREEZE_REASON_FILE_LOCKS = 16;
    static final int UNFREEZE_REASON_FILE_LOCK_CHECK_FAILURE = 17;
    static final int UNFREEZE_REASON_FINISH_RECEIVER = 2;
    static final int UNFREEZE_REASON_GET_PROVIDER = 7;
    static final int UNFREEZE_REASON_NONE = 0;
    static final int UNFREEZE_REASON_OOM_ADJ_FOLLOW_UP = 30;
    static final int UNFREEZE_REASON_OOM_ADJ_RECONFIGURATION = 31;
    static final int UNFREEZE_REASON_PING = 15;
    static final int UNFREEZE_REASON_PROCESS_BEGIN = 11;
    static final int UNFREEZE_REASON_PROCESS_END = 12;
    static final int UNFREEZE_REASON_REMOVE_PROVIDER = 8;
    static final int UNFREEZE_REASON_REMOVE_TASK = 24;
    static final int UNFREEZE_REASON_RESTRICTION_CHANGE = 28;
    static final int UNFREEZE_REASON_SHELL = 23;
    static final int UNFREEZE_REASON_SHORT_FGS_TIMEOUT = 20;
    static final int UNFREEZE_REASON_START_RECEIVER = 3;
    static final int UNFREEZE_REASON_START_SERVICE = 6;
    static final int UNFREEZE_REASON_STOP_SERVICE = 26;
    static final int UNFREEZE_REASON_SYSTEM_INIT = 21;
    static final int UNFREEZE_REASON_TRIM_MEMORY = 13;
    static final int UNFREEZE_REASON_UID_IDLE = 25;
    static final int UNFREEZE_REASON_UI_VISIBILITY = 9;
    static final int UNFREEZE_REASON_UNBIND_SERVICE = 5;
    public static BoostFramework mPerf;
    private final ActivityManagerService mAm;
    final ServiceThread mCachedAppOptimizerThread;
    CompactionStatsManager mCompactStatsManager;
    volatile float mCompactStatsdSampleRate;
    volatile long mCompactThrottleFullFull;
    volatile long mCompactThrottleFullSome;
    volatile long mCompactThrottleMaxOomAdj;
    volatile long mCompactThrottleMinOomAdj;
    volatile long mCompactThrottleSomeFull;
    volatile long mCompactThrottleSomeSome;
    Handler mCompactionHandler;
    public volatile int mCompactionPriority;
    private volatile boolean mDebugCompaction;
    private Handler mFreezeHandler;
    private final Freezer mFreezer;
    volatile int mFreezerBinderAsyncThreshold;
    volatile boolean mFreezerBinderCallbackEnabled;
    private long mFreezerBinderCallbackLast;
    volatile long mFreezerBinderCallbackThrottle;
    volatile long mFreezerBinderDivisor;
    volatile boolean mFreezerBinderEnabled;
    volatile int mFreezerBinderOffset;
    volatile long mFreezerBinderThreshold;
    volatile long mFreezerDebounceTimeout;
    private int mFreezerDisableCount;
    volatile boolean mFreezerExemptInstPkg;
    public final Object mFreezerLock;
    private boolean mFreezerOverride;
    volatile float mFreezerStatsdSampleRate;
    private final SparseArray<ProcessRecord> mFrozenProcesses;
    volatile long mFullAnonRssThrottleKb;
    volatile long mFullDeltaRssThrottleKb;
    private final DeviceConfig.OnPropertiesChangedListener mOnFlagsChangedListener;
    private final DeviceConfig.OnPropertiesChangedListener mOnNativeBootFlagsChangedListener;
    private ICachedAppOptimizerOptEx mOptEx;
    private final ArrayList<ProcessRecord> mPendingCompactionProcesses;
    final Object mPhenotypeFlagLock;
    private final ActivityManagerGlobalLock mProcLock;
    private final ProcLocksReader mProcLocksReader;
    final Set<Integer> mProcStateThrottle;
    private final ProcessDependencies mProcessDependencies;
    private final Random mRandom;
    private final SettingsContentObserver mSettingsObserver;
    private PropertyChangedCallbackForTest mTestCallback;
    private volatile boolean mUseCompaction;
    private volatile boolean mUseFreezer;

    public static final enum CancelCompactReason extends Enum<CancelCompactReason> {
        private static final /* synthetic */ CancelCompactReason[] $VALUES = null;
        public static final CancelCompactReason OOM_IMPROVEMENT = null;
        public static final CancelCompactReason SCREEN_ON = null;

        private static /* synthetic */ CancelCompactReason[] $values() {
            return new CancelCompactReason[]{SCREEN_ON, OOM_IMPROVEMENT};
        }

        private CancelCompactReason(String r1, int r2) {
            super(r1, r2);
        }

        public static CancelCompactReason valueOf(String name) {
            return (CancelCompactReason) Enum.valueOf(CancelCompactReason.class, name);
        }

        public static CancelCompactReason[] values() {
            return (CancelCompactReason[]) $VALUES.clone();
        }

        static {
            SCREEN_ON = new CancelCompactReason("SCREEN_ON", 0);
            OOM_IMPROVEMENT = new CancelCompactReason("OOM_IMPROVEMENT", 1);
            $VALUES = $values();
        }
    }

    public static final enum CompactProfile extends Enum<CompactProfile> {
        private static final /* synthetic */ CompactProfile[] $VALUES = null;
        public static final CompactProfile ANON = null;
        public static final CompactProfile FULL = null;
        public static final CompactProfile NONE = null;
        public static final CompactProfile SOME = null;

        private static /* synthetic */ CompactProfile[] $values() {
            return new CompactProfile[]{NONE, SOME, ANON, FULL};
        }

        private CompactProfile(String r1, int r2) {
            super(r1, r2);
        }

        public static CompactProfile valueOf(String name) {
            return (CompactProfile) Enum.valueOf(CompactProfile.class, name);
        }

        public static CompactProfile[] values() {
            return (CompactProfile[]) $VALUES.clone();
        }

        static {
            NONE = new CompactProfile("NONE", 0);
            SOME = new CompactProfile("SOME", 1);
            ANON = new CompactProfile("ANON", 2);
            FULL = new CompactProfile("FULL", 3);
            $VALUES = $values();
        }
    }

    public static final enum CompactSource extends Enum<CompactSource> {
        private static final /* synthetic */ CompactSource[] $VALUES = null;
        public static final CompactSource APP = null;
        public static final CompactSource SHELL = null;

        private static /* synthetic */ CompactSource[] $values() {
            return new CompactSource[]{APP, SHELL};
        }

        static {
            APP = new CompactSource("APP", 0);
            SHELL = new CompactSource("SHELL", 1);
            $VALUES = $values();
        }

        private CompactSource(String r1, int r2) {
            super(r1, r2);
        }

        public static CompactSource valueOf(String name) {
            return (CompactSource) Enum.valueOf(CompactSource.class, name);
        }

        public static CompactSource[] values() {
            return (CompactSource[]) $VALUES.clone();
        }
    }

    private static final class DefaultProcessDependencies implements ProcessDependencies {
        public static volatile int mPidCompacting;

        /* synthetic */ DefaultProcessDependencies(CachedAppOptimizerIA r1) {
            this();
        }

        private DefaultProcessDependencies() {
        }

        static {
            mPidCompacting = -1;
        }

        @Override // com.android.server.am.CachedAppOptimizer.ProcessDependencies
        public long[] getRss(int pid) {
            return Process.getRss(pid);
        }

        @Override // com.android.server.am.CachedAppOptimizer.ProcessDependencies
        public void performCompaction(CompactProfile profile, int pid) throws IOException {
            mPidCompacting = pid;
            if (profile != CompactProfile.FULL) goto L6;
            CachedAppOptimizer.m1489$$Nest$smcompactProcess(pid, 3);
        L11:
            mPidCompacting = -1;
            return;
        L6:
            if (profile != CompactProfile.SOME) goto L9;
            CachedAppOptimizer.m1489$$Nest$smcompactProcess(pid, 1);
            goto L11
        L9:
            if (profile != CompactProfile.ANON) goto L11;
            CachedAppOptimizer.m1489$$Nest$smcompactProcess(pid, 2);
            goto L11
        }
    }

    private final class FreezeHandler extends Handler implements ProcLocksReader.ProcLocksReaderCallback {
        final /* synthetic */ CachedAppOptimizer this$0;

        public static /* synthetic */ void $r8$lambda$IAfIfEcFxcOjA58aDQgnJCZBAt4(FreezeHandler r0, ProcessRecord r1) {
            r0.lambda$freezeProcess$2(r1);
        }

        /* JADX INFO: renamed from: $r8$lambda$JrdK-GOHWyvTveD-A9PVDkKW66c, reason: not valid java name */
        public static /* synthetic */ void m1494$r8$lambda$JrdKGOHWyvTveDA9PVDkKW66c(FreezeHandler r0, ProcessRecord r1) {
            r0.lambda$freezeProcess$1(r1);
        }

        public static /* synthetic */ void $r8$lambda$dwqBiMSA3Eh5CYi4YkeM0J8Nh5U(FreezeHandler r0, ProcessRecord r1) {
            r0.lambda$handleBinderFreezerFailure$0(r1);
        }

        /* synthetic */ FreezeHandler(CachedAppOptimizer r1, CachedAppOptimizerIA r2) {
            this(r1);
        }

        private FreezeHandler(CachedAppOptimizer r1) {
            this.this$0 = r1;
            super(r1.mCachedAppOptimizerThread.getLooper());
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            switch(msg.what) {
                case 3: goto L32;
                case 4: goto L31;
                case 5: goto L4;
                case 6: goto L26;
                case 7: goto L54;
                case 8: goto L5;
                default: goto L4;
            };
        L4:
            return;
        L5:
            IntArray pids = new IntArray();
            ActivityManagerGlobalLock r2 = CachedAppOptimizer.m1465$$Nest$fgetmProcLock(this.this$0);
            ActivityManagerService.boostPriorityForProcLockedSection();
            monitor-enter(r2);
            int size = CachedAppOptimizer.m1462$$Nest$fgetmFrozenProcesses(this.this$0).size();     // Catch: Throwable -> L10
            int i = 0;
        L8:
            if (i >= size) goto L13;
            pids.add(CachedAppOptimizer.m1462$$Nest$fgetmFrozenProcesses(this.this$0).keyAt(i));     // Catch: Throwable -> L10
            i = i + 1;     // Catch: Throwable -> L10
            goto L8
        L13:
            monitor-exit(r2);     // Catch: Throwable -> L10
            ActivityManagerService.resetPriorityAfterProcLockedSection();
            CachedAppOptimizer.m1470$$Nest$mbinderErrorInternal(this.this$0, pids);
            return;
        L10:
            th = move-exception;
            ActivityManagerService.resetPriorityAfterProcLockedSection();
            throw th;
        L26:
            boolean frozen = true;
            if (msg.arg1 == 1) goto L30;
            frozen = false;
        L30:
            int uid = ((Integer) msg.obj).intValue();
            CachedAppOptimizer.m1474$$Nest$mreportOneUidFrozenStateChanged(this.this$0, uid, frozen);
            return;
        L31:
            int pid = msg.arg1;
            int frozenDuration = msg.arg2;
            Pair<ProcessRecord, Integer> obj = (Pair) msg.obj;
            ProcessRecord app = (ProcessRecord) obj.first;
            String processName = app.processName;
            int reason = ((Integer) obj.second).intValue();
            reportUnfreeze(app, pid, frozenDuration, processName, reason);
            return;
        L32:
            ProcessRecord proc = (ProcessRecord) msg.obj;
            ActivityManagerService r3 = CachedAppOptimizer.m1457$$Nest$fgetmAm(this.this$0);
            ActivityManagerService.boostPriorityForLockedSection();
            monitor-enter(r3);
        L39:
            th = move-exception;
            ActivityManagerService.resetPriorityAfterLockedSection();
            throw th;
        L35:
            if (proc.mOptRecord.isPendingFreeze() == true) goto L41;
            monitor-exit(r3);     // Catch: Throwable -> L39
            ActivityManagerService.resetPriorityAfterLockedSection();
            return;
        L41:
            freezeProcess(proc);     // Catch: Throwable -> L39
            monitor-exit(r3);     // Catch: Throwable -> L39
            ActivityManagerService.resetPriorityAfterLockedSection();
            if (proc.mOptRecord.isFrozen() == false) goto L46;
            this.this$0.onProcessFrozen(proc);
            removeMessages(7);
            sendEmptyMessageDelayed(7, 1000);
            return;
        L46:
            this.this$0.onProcessFrozenCancelled(proc);
            return;
        L54:
            if (ActivityManagerDebugConfig.DEBUG_FREEZER == false) goto L23;
            Slog.d("ActivityManager", "Freezer deadlock watchdog");     // Catch: IOException -> L21
        L23:
            CachedAppOptimizer.m1466$$Nest$fgetmProcLocksReader(this.this$0).handleBlockingFileLocks(this);     // Catch: IOException -> L21
            return;
        L25:
            Slog.w("ActivityManager", "Unable to check file locks");
        }

        private void handleBinderFreezerFailure(final ProcessRecord proc, String reason) {
            if (this.this$0.mFreezerBinderEnabled == true) goto L7;
            this.this$0.unfreezeAppLSP(proc, 18);
            this.this$0.freezeAppAsyncLSP(proc);
            return;
        L7:
            if (proc.mOptRecord.getLastUsedTimeout() > this.this$0.mFreezerBinderThreshold) goto L10;
            Slog.d("ActivityManager", "Kill app due to repeated failure to freeze binder: " + proc.getPid() + " " + proc.processName);
            CachedAppOptimizer.m1457$$Nest$fgetmAm(this.this$0).mHandler.post(new CachedAppOptimizer$FreezeHandler$$ExternalSyntheticLambda2(this, proc));
            return;
        L10:
            long timeout = proc.mOptRecord.getLastUsedTimeout() / this.this$0.mFreezerBinderDivisor;
            int offset = CachedAppOptimizer.m1468$$Nest$fgetmRandom(this.this$0).nextInt(this.this$0.mFreezerBinderOffset * 2) - this.this$0.mFreezerBinderOffset;
            long timeout2 = Math.max(((long) offset) + timeout, this.this$0.mFreezerBinderThreshold);
            Slog.d("ActivityManager", "Reschedule freeze for process " + proc.getPid() + " " + proc.processName + " (" + reason + "), timeout=" + timeout2);
            Trace.instantForTrack(64, CachedAppOptimizer.ATRACE_FREEZER_TRACK, "Reschedule freeze " + proc.processName + ":" + proc.getPid() + " timeout=" + timeout2 + ", reason=" + reason);
            this.this$0.unfreezeAppLSP(proc, 18);
            CachedAppOptimizer.m1472$$Nest$mfreezeAppAsyncLSP(this.this$0, proc, timeout2);
        }

        private /* synthetic */ void lambda$handleBinderFreezerFailure$0(ProcessRecord proc) {
            ActivityManagerService r0 = CachedAppOptimizer.m1457$$Nest$fgetmAm(this.this$0);
            ActivityManagerService.boostPriorityForLockedSection();
            monitor-enter(r0);
        L9:
            th = move-exception;
            ActivityManagerService.resetPriorityAfterLockedSection();
            throw th;
        L5:
            if (proc.getThread() != null) goto L11;
            monitor-exit(r0);     // Catch: Throwable -> L9
            ActivityManagerService.resetPriorityAfterLockedSection();
            return;
        L11:
            proc.killLocked("excessive binder traffic during cached", 9, 7, true);     // Catch: Throwable -> L9
            monitor-exit(r0);     // Catch: Throwable -> L9
            ActivityManagerService.resetPriorityAfterLockedSection();
        }

        private void freezeProcess(final ProcessRecord proc) {
            proc.getPid();
            String name = proc.processName;
            ProcessCachedOptimizerRecord opt = proc.mOptRecord;
            ActivityManagerGlobalLock r2 = CachedAppOptimizer.m1465$$Nest$fgetmProcLock(this.this$0);
            ActivityManagerService.boostPriorityForProcLockedSection();
            monitor-enter(r2);
        L9:
            th = th;
        L89:
            monitor-exit(r2);     // Catch: Throwable -> L9
            ActivityManagerService.resetPriorityAfterProcLockedSection();
            throw th;
        L5:
            if (opt.isPendingFreeze() == true) goto L12;
            monitor-exit(r2);     // Catch: Throwable -> L9
            ActivityManagerService.resetPriorityAfterProcLockedSection();
            return;
        L12:
            opt.setPendingFreeze(false);     // Catch: Throwable -> L9
            int pid = proc.getPid();     // Catch: Throwable -> L9
        L19:
            th = th;
            goto L89
        L14:
            if (CachedAppOptimizer.m1461$$Nest$fgetmFreezerOverride(this.this$0) == false) goto L22;
            opt.setFreezerOverride(true);     // Catch: Throwable -> L19
            Slog.d("ActivityManager", "Skipping freeze for process " + pid + " " + name + " curAdj = " + proc.mState.getCurAdj() + "(override)");     // Catch: Throwable -> L19
            monitor-exit(r2);     // Catch: Throwable -> L19
            ActivityManagerService.resetPriorityAfterProcLockedSection();
            return;
        L22:
            if (opt.shouldNotFreeze() == true) goto L24;
            if (pid == 0) goto L84;
            if (opt.isFrozen() == true) goto L84;
            Slog.d("ActivityManager", "freezing " + pid + " " + name);     // Catch: Throwable -> L19
            if (CachedAppOptimizer.m1460$$Nest$fgetmFreezer(this.this$0).freezeBinder(pid, true, 0) == 0) goto L46;
            handleBinderFreezerFailure(proc, "outstanding txns");     // Catch: Throwable -> L19 RuntimeException -> L41
            monitor-exit(r2);     // Catch: Throwable -> L19
            ActivityManagerService.resetPriorityAfterProcLockedSection();
            return;
        L46:
            long unfreezeTime = opt.getFreezeUnfreezeTime();     // Catch: Throwable -> L19
            CachedAppOptimizer.m1493$$Nest$smtraceAppFreeze(proc.processName, pid, -1);     // Catch: Throwable -> L19 Exception -> L49
            CachedAppOptimizer.m1460$$Nest$fgetmFreezer(this.this$0).setProcessFrozen(pid, proc.uid, true);     // Catch: Throwable -> L19 Exception -> L49
            opt.setFreezeUnfreezeTime(SystemClock.uptimeMillis());     // Catch: Throwable -> L19 Exception -> L49
            opt.setFrozen(true);     // Catch: Throwable -> L19 Exception -> L49
            opt.setHasCollectedFrozenPSS(false);     // Catch: Throwable -> L19 Exception -> L49
            CachedAppOptimizer.m1462$$Nest$fgetmFrozenProcesses(this.this$0).put(pid, proc);     // Catch: Throwable -> L19 Exception -> L49
        L51:
            long unfrozenDuration = opt.getFreezeUnfreezeTime() - unfreezeTime;     // Catch: Throwable -> L19
            boolean frozen = opt.isFrozen();     // Catch: Throwable -> L19
            UidRecord uidRec = proc.getUidRecord();     // Catch: Throwable -> L19
            if (frozen == false) goto L57;
            if (uidRec == null) goto L57;
            if (uidRec.areAllProcessesFrozen() == false) goto L57;
            uidRec.setFrozen(true);     // Catch: Throwable -> L19
            CachedAppOptimizer.m1473$$Nest$mpostUidFrozenMessage(this.this$0, uidRec.getUid(), true);     // Catch: Throwable -> L19
        L57:
            monitor-exit(r2);     // Catch: Throwable -> L19
            ActivityManagerService.resetPriorityAfterProcLockedSection();
            if (frozen == true) goto L61;
            return;
        L61:
            EventLog.writeEvent(EventLogTags.AM_FREEZE, new Object[]{Integer.valueOf(pid), name});
            if (CachedAppOptimizer.m1468$$Nest$fgetmRandom(this.this$0).nextFloat() >= this.this$0.mFreezerStatsdSampleRate) goto L94;
            FrameworkStatsLog.write(254, 1, pid, name, unfrozenDuration, 0, 0);
        L94:
            int freezeInfo = CachedAppOptimizer.m1460$$Nest$fgetmFreezer(this.this$0).getBinderFreezeInfo(pid);     // Catch: RuntimeException -> L73
            if ((freezeInfo & 4) == 0) goto L81;
            ActivityManagerGlobalLock r3 = CachedAppOptimizer.m1465$$Nest$fgetmProcLock(this.this$0);     // Catch: RuntimeException -> L73
            ActivityManagerService.boostPriorityForProcLockedSection();     // Catch: RuntimeException -> L73
            monitor-enter(r3);     // Catch: RuntimeException -> L73
            handleBinderFreezerFailure(proc, "new pending txns");     // Catch: Throwable -> L75
            monitor-exit(r3);     // Catch: Throwable -> L75
            ActivityManagerService.resetPriorityAfterProcLockedSection();     // Catch: RuntimeException -> L73
            return;
        L75:
            th = move-exception;
            ActivityManagerService.resetPriorityAfterProcLockedSection();     // Catch: RuntimeException -> L73
            throw th;     // Catch: RuntimeException -> L73
        L81:
            opt.dispatchFrozenEvent();
            return;
        L80:
            Slog.e("ActivityManager", "Unable to freeze binder for " + pid + " " + name);
            CachedAppOptimizer.m1459$$Nest$fgetmFreezeHandler(this.this$0).post(new CachedAppOptimizer$FreezeHandler$$ExternalSyntheticLambda1(this, proc));
            goto L81
        L50:
            Slog.w("ActivityManager", "Unable to freeze " + pid + " " + name);     // Catch: Throwable -> L19
        L45:
            Slog.e("ActivityManager", "Unable to freeze binder for " + pid + " " + name);     // Catch: Throwable -> L19
            CachedAppOptimizer.m1459$$Nest$fgetmFreezeHandler(this.this$0).post(new CachedAppOptimizer$FreezeHandler$$ExternalSyntheticLambda0(this, proc));     // Catch: Throwable -> L19
        L84:
            if (ActivityManagerDebugConfig.DEBUG_FREEZER == false) goto L86;
            Slog.d("ActivityManager", "Skipping freeze for process " + pid + " " + name + ". Already frozen or not a real process");     // Catch: Throwable -> L19
        L86:
            monitor-exit(r2);     // Catch: Throwable -> L19
            ActivityManagerService.resetPriorityAfterProcLockedSection();
            return;
        L24:
            if (ActivityManagerDebugConfig.DEBUG_FREEZER == false) goto L26;
            Slog.d("ActivityManager", "Skipping freeze because process is marked should not be frozen");     // Catch: Throwable -> L19
        L26:
            CachedAppOptimizer.m1475$$Nest$mreportProcessFreezableChangedLocked(this.this$0, proc);     // Catch: Throwable -> L19
            monitor-exit(r2);     // Catch: Throwable -> L19
            ActivityManagerService.resetPriorityAfterProcLockedSection();
        }

        private /* synthetic */ void lambda$freezeProcess$1(ProcessRecord proc) {
            ActivityManagerService r0 = CachedAppOptimizer.m1457$$Nest$fgetmAm(this.this$0);
            ActivityManagerService.boostPriorityForLockedSection();
            monitor-enter(r0);
            proc.killLocked("Unable to freeze binder interface", 14, 19, true);     // Catch: Throwable -> L8
            monitor-exit(r0);     // Catch: Throwable -> L8
            ActivityManagerService.resetPriorityAfterLockedSection();
            return;
        L8:
            th = move-exception;
            ActivityManagerService.resetPriorityAfterLockedSection();
            throw th;
        }

        private /* synthetic */ void lambda$freezeProcess$2(ProcessRecord proc) {
            ActivityManagerService r0 = CachedAppOptimizer.m1457$$Nest$fgetmAm(this.this$0);
            ActivityManagerService.boostPriorityForLockedSection();
            monitor-enter(r0);
            proc.killLocked("Unable to freeze binder interface", 14, 19, true);     // Catch: Throwable -> L8
            monitor-exit(r0);     // Catch: Throwable -> L8
            ActivityManagerService.resetPriorityAfterLockedSection();
            return;
        L8:
            th = move-exception;
            ActivityManagerService.resetPriorityAfterLockedSection();
            throw th;
        }

        private void reportUnfreeze(ProcessRecord app, int pid, int frozenDuration, String processName, int reason) {
            EventLog.writeEvent(EventLogTags.AM_UNFREEZE, new Object[]{Integer.valueOf(pid), processName, Integer.valueOf(reason)});
            app.onProcessUnfrozen();
            if (CachedAppOptimizer.m1468$$Nest$fgetmRandom(this.this$0).nextFloat() >= this.this$0.mFreezerStatsdSampleRate) goto L6;
            FrameworkStatsLog.write(254, 2, pid, processName, frozenDuration, 0, reason);
            return;
        }

        public void onBlockingFileLock(IntArray pids) {
            if (ActivityManagerDebugConfig.DEBUG_FREEZER == false) goto L5;
            Slog.d("ActivityManager", "Blocking file lock found: " + pids);
        L5:
            ActivityManagerService r0 = CachedAppOptimizer.m1457$$Nest$fgetmAm(this.this$0);
            ActivityManagerService.boostPriorityForLockedSection();
            monitor-enter(r0);
            ActivityManagerGlobalLock r1 = CachedAppOptimizer.m1465$$Nest$fgetmProcLock(this.this$0);     // Catch: Throwable -> L35
            ActivityManagerService.boostPriorityForProcLockedSection();     // Catch: Throwable -> L35
            monitor-enter(r1);     // Catch: Throwable -> L35
            int pid = pids.get(0);     // Catch: Throwable -> L24
            ProcessRecord app = (ProcessRecord) CachedAppOptimizer.m1462$$Nest$fgetmFrozenProcesses(this.this$0).get(pid);     // Catch: Throwable -> L24
            if (app == null) goto L30;
            int i = 1;
        L14:
            if (i >= pids.size()) goto L30;
            int blocked = pids.get(i);     // Catch: Throwable -> L24
            ActivityManagerService.PidMap r6 = CachedAppOptimizer.m1457$$Nest$fgetmAm(this.this$0).mPidsSelfLocked;     // Catch: Throwable -> L24
            monitor-enter(r6);     // Catch: Throwable -> L24
            ProcessRecord pr = CachedAppOptimizer.m1457$$Nest$fgetmAm(this.this$0).mPidsSelfLocked.get(blocked);     // Catch: Throwable -> L27
            monitor-exit(r6);     // Catch: Throwable -> L27
            if (pr == null) goto L26;
            if (pr.mState.getCurAdj() >= CachedAppOptimizer.m1457$$Nest$fgetmAm(this.this$0).mConstants.FREEZER_CUTOFF_ADJ) goto L26;
            Slog.d("ActivityManager", app.processName + " (" + pid + ") blocks " + pr.processName + " (" + blocked + ")");     // Catch: Throwable -> L24
            this.this$0.unfreezeAppLSP(app, 16);     // Catch: Throwable -> L24
        L26:
            i = i + 1;
            goto L14
        L27:
            th = move-exception;
            throw th;     // Catch: Throwable -> L24
        L30:
            monitor-exit(r1);     // Catch: Throwable -> L24
            ActivityManagerService.resetPriorityAfterProcLockedSection();     // Catch: Throwable -> L35
            monitor-exit(r0);     // Catch: Throwable -> L35
            ActivityManagerService.resetPriorityAfterLockedSection();
            return;
        L24:
            th = move-exception;
            ActivityManagerService.resetPriorityAfterProcLockedSection();     // Catch: Throwable -> L35
            throw th;     // Catch: Throwable -> L35
        L35:
            th = move-exception;
            ActivityManagerService.resetPriorityAfterLockedSection();
            throw th;
        }
    }

    private final class MemCompactionHandler extends Handler {
        final /* synthetic */ CachedAppOptimizer this$0;

        /* synthetic */ MemCompactionHandler(CachedAppOptimizer r1, CachedAppOptimizerIA r2) {
            this(r1);
        }

        private MemCompactionHandler(CachedAppOptimizer r1) {
            this.this$0 = r1;
            super(r1.mCachedAppOptimizerThread.getLooper());
        }

        private boolean shouldOomAdjThrottleCompaction(ProcessRecord proc) {
            String name = proc.processName;
            ProcessCachedOptimizerRecord opt = proc.mOptRecord;
            CompactSource compactSource = opt.getReqCompactSource();
            if (compactSource == CompactSource.APP) goto L5;
            return false;
        L5:
            if (proc.mState.getSetAdj() <= 200) goto L7;
            return false;
        L7:
            if (CachedAppOptimizer.m1458$$Nest$fgetmDebugCompaction(this.this$0) == false) goto L13;
            Slog.d("ActivityManager", "Skipping compaction as process " + name + " is now perceptible.");
            return true;
        L13:
            return true;
        }

        private boolean shouldTimeThrottleCompaction(ProcessRecord proc, long start, CompactProfile pendingProfile, CompactSource source) {
            ProcessCachedOptimizerRecord opt = proc.mOptRecord;
            String name = proc.processName;
            CompactProfile lastCompactProfile = opt.getLastCompactProfile();
            long lastCompactTime = opt.getLastCompactTime();
            if (lastCompactTime == 0) goto L40;
            if (source != CompactSource.APP) goto L47;
            if (pendingProfile != CompactProfile.SOME) goto L25;
            if (lastCompactProfile != CompactProfile.SOME) goto L14;
            String r19 = "ms ago";
            boolean r18 = true;
            if ((start - lastCompactTime) >= this.this$0.mCompactThrottleSomeSome) goto L16;
        L20:
            if (CachedAppOptimizer.m1458$$Nest$fgetmDebugCompaction(this.this$0) == false) goto L22;
            Slog.d("ActivityManager", "Skipping some compaction for " + name + ": too soon. throttle=" + this.this$0.mCompactThrottleSomeSome + SliceClientPermissions.SliceAuthority.DELIMITER + this.this$0.mCompactThrottleSomeFull + " last=" + (start - lastCompactTime) + r19);
        L22:
            return r18;
        L16:
            if (lastCompactProfile != CompactProfile.FULL) goto L43;
            if ((start - lastCompactTime) < this.this$0.mCompactThrottleSomeFull) goto L20;
            return false;
        L43:
            return false;
        L14:
            r19 = "ms ago";
            r18 = true;
            goto L16
        L25:
            if (pendingProfile == CompactProfile.FULL) goto L27;
            return false;
        L27:
            if (lastCompactProfile != CompactProfile.SOME) goto L31;
            if ((start - lastCompactTime) >= this.this$0.mCompactThrottleFullSome) goto L31;
        L35:
            if (CachedAppOptimizer.m1458$$Nest$fgetmDebugCompaction(this.this$0) == false) goto L37;
            Slog.d("ActivityManager", "Skipping full compaction for " + name + ": too soon. throttle=" + this.this$0.mCompactThrottleFullSome + SliceClientPermissions.SliceAuthority.DELIMITER + this.this$0.mCompactThrottleFullFull + " last=" + (start - lastCompactTime) + "ms ago");
        L37:
            return true;
        L31:
            if (lastCompactProfile == CompactProfile.FULL) goto L33;
            return false;
        L33:
            if ((start - lastCompactTime) < this.this$0.mCompactThrottleFullFull) goto L35;
            return false;
        L47:
            return false;
        L40:
            return false;
        }

        private boolean shouldThrottleMiscCompaction(ProcessRecord proc, int procState) {
            if (this.this$0.mProcStateThrottle.contains(Integer.valueOf(procState)) == true) goto L5;
            return false;
        L5:
            if (CachedAppOptimizer.m1458$$Nest$fgetmDebugCompaction(this.this$0) == false) goto L11;
            String name = proc.processName;
            Slog.d("ActivityManager", "Skipping full compaction for process " + name + "; proc state is " + procState);
            return true;
        L11:
            return true;
        }

        private boolean shouldRssThrottleCompaction(CompactProfile profile, int pid, String name, long[] rssBefore) {
            long anonRssBefore = rssBefore[2];
            SingleCompactionStats lastCompactionStats = this.this$0.mCompactStatsManager.getLastCompactionStats(pid);
            if (rssBefore[0] != 0) goto L15;
            if (rssBefore[1] != 0) goto L15;
            if (rssBefore[2] != 0) goto L15;
            if (rssBefore[3] != 0) goto L15;
            if (CachedAppOptimizer.m1458$$Nest$fgetmDebugCompaction(this.this$0) == false) goto L13;
            Slog.d("ActivityManager", "Skipping compaction forprocess " + pid + " with no memory usage. Dead?");
        L13:
            return true;
        L15:
            if (profile != CompactProfile.FULL) goto L35;
            if (this.this$0.mFullAnonRssThrottleKb <= 0) goto L25;
            if (anonRssBefore >= this.this$0.mFullAnonRssThrottleKb) goto L25;
            if (CachedAppOptimizer.m1458$$Nest$fgetmDebugCompaction(this.this$0) == false) goto L23;
            Slog.d("ActivityManager", "Skipping full compaction for process " + name + "; anon RSS is too small: " + anonRssBefore + "KB.");
        L23:
            return true;
        L25:
            if (lastCompactionStats != null) goto L27;
            return false;
        L27:
            if (this.this$0.mFullDeltaRssThrottleKb <= 0) goto L37;
            long[] lastRss = lastCompactionStats.getRssAfterCompaction();
            long absDelta = (Math.abs(rssBefore[1] - lastRss[1]) + Math.abs(rssBefore[2] - lastRss[2])) + Math.abs(rssBefore[3] - lastRss[3]);
            if (absDelta <= this.this$0.mFullDeltaRssThrottleKb) goto L31;
            return false;
        L31:
            if (CachedAppOptimizer.m1458$$Nest$fgetmDebugCompaction(this.this$0) == false) goto L33;
            Slog.d("ActivityManager", "Skipping full compaction for process " + name + "; abs delta is too small: " + absDelta + "KB.");
        L33:
            return true;
        L37:
            return false;
        L35:
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // android.os.Handler
        public void handleMessage(Message r78) {
            switch(r78.what) {
                case 1: goto L12;
                case 2: goto L11;
                case 3: goto L166;
                case 4: goto L166;
                case 5: goto L5;
                default: goto L166;
            };
        L5:
            int r2 = r78.arg1;
            CompactProfile r3 = CompactProfile.values()[r78.arg2];
            Slog.d("ActivityManager", "Performing native compaction for pid=" + r2 + " type=" + r3.name());
            Trace.traceBegin(64, "compactNative");
            CachedAppOptimizer.m1467$$Nest$fgetmProcessDependencies(this.this$0).performCompaction(r3, r2);     // Catch: Exception -> L8
        L10:
            Trace.traceEnd(64);
            return;
        L9:
            Slog.d("ActivityManager", "Failed compacting native pid= " + r2);
            goto L10
        L11:
            Trace.traceBegin(64, "compactSystem");
            long r4 = CachedAppOptimizer.m1490$$Nest$smgetMemoryFreedCompaction();
            CachedAppOptimizer.m1471$$Nest$mcompactSystem(this.this$0);
            this.this$0.mCompactStatsManager.logSystemCompactionPerformed(CachedAppOptimizer.m1490$$Nest$smgetMemoryFreedCompaction() - r4);
            Trace.traceEnd(64);
            return;
        L12:
            long r5 = SystemClock.uptimeMillis();
            int r10 = r78.arg1;
            int r11 = r78.arg2;
            ActivityManagerGlobalLock r6 = CachedAppOptimizer.m1465$$Nest$fgetmProcLock(this.this$0);
            ActivityManagerService.boostPriorityForProcLockedSection();
            monitor-enter(r6);
        L131:
            th = th;
        L146:
            monitor-exit(r6);     // Catch: Throwable -> L136
            ActivityManagerService.resetPriorityAfterProcLockedSection();
            throw th;
        L136:
            th = th;
            goto L146
        L15:
            if (CachedAppOptimizer.m1464$$Nest$fgetmPendingCompactionProcesses(this.this$0).isEmpty() == true) goto L142;
            char r12 = 0;
            ProcessRecord r0 = (ProcessRecord) CachedAppOptimizer.m1464$$Nest$fgetmPendingCompactionProcesses(this.this$0).remove(0);     // Catch: Throwable -> L131
            ProcessCachedOptimizerRecord r1 = r0.mOptRecord;     // Catch: Throwable -> L131
            boolean r7 = r1.isForceCompact();     // Catch: Throwable -> L131
            r1.setForceCompact(false);     // Catch: Throwable -> L131
            int r28 = r0.getPid();     // Catch: Throwable -> L131
            String r8 = r0.processName;     // Catch: Throwable -> L131
            r1.setHasPendingCompact(false);     // Catch: Throwable -> L131
            CompactSource r9 = r1.getReqCompactSource();     // Catch: Throwable -> L131
            CompactProfile r13 = r1.getReqCompactProfile();     // Catch: Throwable -> L131
            CompactProfile r14 = r1.getLastCompactProfile();     // Catch: Throwable -> L131
            long r17 = r1.getLastCompactTime();     // Catch: Throwable -> L131
            int r26 = r1.getLastOomAdjChangeReason();     // Catch: Throwable -> L131
            monitor-exit(r6);     // Catch: Throwable -> L131
            ActivityManagerService.resetPriorityAfterProcLockedSection();
            if (r28 != 0) goto L34;
            if (CachedAppOptimizer.m1458$$Nest$fgetmDebugCompaction(this.this$0) == false) goto L31;
            Slog.d("ActivityManager", "Compaction failed, pid is 0");
        L31:
            this.this$0.mCompactStatsManager.logCompactionThrottled(0, r9, r8);
            return;
        L34:
            if (r7 == false) goto L36;
            char r15 = 2;
            ProcessRecord r16 = r0;
            CompactProfile r18 = r13;
            long[] r19 = CachedAppOptimizer.m1467$$Nest$fgetmProcessDependencies(this.this$0).getRss(r28);
            if (CachedAppOptimizer.m1458$$Nest$fgetmDebugCompaction(this.this$0) == false) goto L56;
            Slog.d("ActivityManager", "Forcing compaction for " + r8);
        L56:
            long[] r20 = r19;
        L57:
            CompactProfile r21 = CachedAppOptimizer.m1463$$Nest$fgetmOptEx(this.this$0).downgradeCompactIfNecessary(r16, this.this$0.resolveCompactionProfile(r18));
            StringBuilder r110 = new StringBuilder();
            r110.append("requestedProfile:");
            r110.append(r18.name());
            r110.append(", resolvedAction:");
            r110.append(r21.name());
            Slog.i("ActivityManager", r110.toString());
            if (r21 == CompactProfile.NONE) goto L60;
            StringBuilder r22 = new StringBuilder();     // Catch: Throwable -> L120 Exception -> L122
            r22.append("Compact ");     // Catch: Throwable -> L120 Exception -> L122
            r22.append(r21.name());     // Catch: Throwable -> L120 Exception -> L122
            r22.append(": ");     // Catch: Throwable -> L120 Exception -> L122
            r22.append(r8);     // Catch: Throwable -> L120 Exception -> L122
            r22.append(" lastOomAdjReason: ");     // Catch: Throwable -> L120 Exception -> L122
        L156:
            r22.append(r26);     // Catch: Throwable -> L116 Exception -> L118
            r22.append(" source: ");     // Catch: Throwable -> L116 Exception -> L118
            r22.append(r9.name());     // Catch: Throwable -> L116 Exception -> L118
        L160:
            Trace.traceBegin(64, r22.toString());     // Catch: Throwable -> L112 Exception -> L114
            long r23 = CachedAppOptimizer.m1491$$Nest$smgetUsedZramMemory();     // Catch: Throwable -> L112 Exception -> L114
            long r111 = CachedAppOptimizer.m1492$$Nest$smthreadCpuTimeNs();     // Catch: Throwable -> L112 Exception -> L114
            CachedAppOptimizer.m1467$$Nest$fgetmProcessDependencies(this.this$0).performCompaction(r21, r28);     // Catch: Throwable -> L112 Exception -> L114
            long r112 = CachedAppOptimizer.m1492$$Nest$smthreadCpuTimeNs();     // Catch: Throwable -> L112 Exception -> L114
            long[] r24 = CachedAppOptimizer.m1467$$Nest$fgetmProcessDependencies(this.this$0).getRss(r28);     // Catch: Throwable -> L112 Exception -> L114
            long r113 = SystemClock.uptimeMillis();     // Catch: Throwable -> L112 Exception -> L114
            long r62 = r113 - r5;     // Catch: Throwable -> L112 Exception -> L114
            long r64 = r112 - r111;     // Catch: Throwable -> L112 Exception -> L114
            long r114 = CachedAppOptimizer.m1491$$Nest$smgetUsedZramMemory();     // Catch: Throwable -> L112 Exception -> L114
            long r68 = r24[r12] - r20[r12];     // Catch: Throwable -> L112 Exception -> L114
            long r70 = r24[r8] - r20[r8];     // Catch: Throwable -> L112 Exception -> L114
            long r25 = r24[r15] - r20[r15];     // Catch: Throwable -> L112 Exception -> L114
            long r74 = r24[r0] - r20[r0];     // Catch: Throwable -> L112 Exception -> L114
            switch(r1.getReqCompactProfile().ordinal()) {
                case 1: goto L91;
                case 2: goto L158;
                case 3: goto L76;
                default: goto L158;
            };
        L76:
            int r29 = r28;
            long r115 = -r25;
            String r116 = r8;
            long r117 = r114 - r23;
            long r118 = r115 - r117;
            long r27 = r64 / 1000000;     // Catch: Throwable -> L87 Exception -> L89
            long r210 = r20[r15];     // Catch: Throwable -> L87 Exception -> L89
            CompactionStatsManager r30 = this.this$0.mCompactStatsManager;     // Catch: Throwable -> L87 Exception -> L89
            int r31 = r16.uid;     // Catch: Throwable -> L87 Exception -> L89
            if (r7 == true) goto L80;
            boolean r211 = true;
        L81:
            ProcessCachedOptimizerRecord r32 = r1;
            int r212 = r11;
            int r213 = r10;
            char r33 = 0;
            r30.logFullCompactionPerformed(r9, r116, r115, r117, r118, r210, r27, r24, r212, r213, r26, r31, r29, r211);     // Catch: Throwable -> L83 Exception -> L85
            String r119 = r116;
        L93:
            String r34 = r119;
        L96:
            EventLog.writeEvent(EventLogTags.AM_COMPACT, new Object[]{Integer.valueOf(r29), r34, r21.name(), Long.valueOf(r20[r33]), Long.valueOf(r20[r8]), Long.valueOf(r20[r15]), Long.valueOf(r20[3]), Long.valueOf(r68), Long.valueOf(r70), Long.valueOf(r25), Long.valueOf(r74), Long.valueOf(r62), r14.name(), Long.valueOf(r17), Integer.valueOf(r213), Integer.valueOf(r212), Long.valueOf(r23), Long.valueOf(r23 - r114)});     // Catch: Throwable -> L83 Exception -> L85
            ActivityManagerGlobalLock r120 = CachedAppOptimizer.m1465$$Nest$fgetmProcLock(this.this$0);     // Catch: Throwable -> L83 Exception -> L85
            ActivityManagerService.boostPriorityForProcLockedSection();     // Catch: Throwable -> L83 Exception -> L85
            monitor-enter(r120);     // Catch: Throwable -> L83 Exception -> L85
            r32.setLastCompactTime(r113);     // Catch: Throwable -> L104
            r32.setLastCompactProfile(r18);     // Catch: Throwable -> L104
            monitor-exit(r120);     // Catch: Throwable -> L104
            ActivityManagerService.resetPriorityAfterProcLockedSection();     // Catch: Throwable -> L83 Exception -> L85
            long r52 = 64;
        L103:
            Trace.traceEnd(r52);
            return;
        L104:
            th = move-exception;
            ActivityManagerService.resetPriorityAfterProcLockedSection();     // Catch: Throwable -> L83 Exception -> L85
            throw th;     // Catch: Throwable -> L83 Exception -> L85
        L110:
            e = e;
            String r121 = r34;
        L125:
            Slog.d("ActivityManager", "Exception occurred while compacting pid: " + r121 + ". Exception:" + e.getMessage());     // Catch: Throwable -> L83
            r52 = 64;
        L108:
            th = th;
        L129:
            Trace.traceEnd(64);
            throw th;
        L80:
            r211 = false;
            goto L81
        L89:
            e = e;
            r121 = r116;
        L87:
            th = th;
            goto L129
        L91:
            r213 = r10;
            r212 = r11;
            r29 = r28;
            String r122 = r8;
            r33 = r12;
            r32 = r1;
            this.this$0.mCompactStatsManager.logSomeCompactionPerformed(r9, r122);     // Catch: Throwable -> L83 Exception -> L85
            r119 = r122;
            goto L93
        L158:
            Slog.wtf("ActivityManager", "Compaction: Unknown requested action");     // Catch: Throwable -> L72 Exception -> L74
            Trace.traceEnd(64);
            return;
        L74:
            e = e;
            r121 = r8;
        L72:
            th = th;
        L85:
            e = e;
            r121 = r110;
            goto L125
        L114:
            e = e;
            r121 = r8;
        L112:
            th = th;
        L118:
            e = e;
            r121 = r8;
        L116:
            th = th;
        L122:
            e = e;
            r121 = r8;
        L120:
            th = th;
            goto L129
        L60:
            if (ActivityManagerDebugConfig.DEBUG_COMPACTION == false) goto L164;
            Slog.d("ActivityManager", "Resolved no compaction for " + r8 + " requested profile=" + r18);
            return;
        L164:
            return;
        L83:
            th = th;
            goto L129
        L36:
            if (shouldOomAdjThrottleCompaction(r0) == false) goto L39;
            this.this$0.mCompactStatsManager.logCompactionThrottled(1, r9, r8);
            return;
        L39:
            r16 = r0;
            r18 = r13;
            if (shouldTimeThrottleCompaction(r16, r5, r18, r9) == false) goto L44;
            this.this$0.mCompactStatsManager.logCompactionThrottled(2, r9, r8);
            return;
        L44:
            if (shouldThrottleMiscCompaction(r16, r11) == false) goto L47;
            this.this$0.mCompactStatsManager.logCompactionThrottled(3, r9, r8);
            return;
        L47:
            long[] r35 = CachedAppOptimizer.m1467$$Nest$fgetmProcessDependencies(this.this$0).getRss(r28);
            if (shouldRssThrottleCompaction(r18, r28, r8, r35) == false) goto L51;
            this.this$0.mCompactStatsManager.logCompactionThrottled(4, r9, r8);
            return;
        L51:
            r15 = 2;
            r12 = 0;
            r20 = r35;
            goto L57
        L142:
        L19:
            th = th;
            goto L146
        L17:
            if (CachedAppOptimizer.m1458$$Nest$fgetmDebugCompaction(this.this$0) == false) goto L21;
            Slog.d("ActivityManager", "No processes pending compaction, bail out");     // Catch: Throwable -> L19
        L21:
            monitor-exit(r6);     // Catch: Throwable -> L19
            ActivityManagerService.resetPriorityAfterProcLockedSection();
            return;
        }
    }

    interface ProcessDependencies {
        long[] getRss(int r1);

        void performCompaction(CompactProfile r1, int r2) throws IOException;
    }

    interface PropertyChangedCallbackForTest {
        void onPropertyChanged();
    }

    private final class SettingsContentObserver extends ContentObserver {
        final /* synthetic */ CachedAppOptimizer this$0;

        SettingsContentObserver(CachedAppOptimizer r1) {
            this.this$0 = r1;
            super(CachedAppOptimizer.m1457$$Nest$fgetmAm(r1).mHandler);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean selfChange, Uri uri) {
            if (CachedAppOptimizer.CACHED_APP_FREEZER_ENABLED_URI.equals(uri) == false) goto L12;
            Object r0 = this.this$0.mPhenotypeFlagLock;
            monitor-enter(r0);
            CachedAppOptimizer.m1488$$Nest$mupdateUseFreezer(this.this$0);     // Catch: Throwable -> L9
            monitor-exit(r0);     // Catch: Throwable -> L9
            return;
        L9:
            th = move-exception;
            throw th;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface UnfreezeReason {
    }

    /* JADX INFO: renamed from: $r8$lambda$-upOzpyY65gWLMI4KJxyfInRtPg, reason: not valid java name */
    public static /* synthetic */ void m1453$r8$lambda$upOzpyY65gWLMI4KJxyfInRtPg(Exception r0) {
        lambda$binderErrorInternal$4(r0);
    }

    /* JADX INFO: renamed from: $r8$lambda$50-5szAMI3_Lo87NbZnc0_MNRnM, reason: not valid java name */
    public static /* synthetic */ void m1454$r8$lambda$505szAMI3_Lo87NbZnc0_MNRnM(CachedAppOptimizer r0, int r1, String r2, int r3, int r4) {
        r0.lambda$killProcess$2(r1, r2, r3, r4);
    }

    /* JADX INFO: renamed from: $r8$lambda$JxGAByAESCLWWhMw0Ii9S5PJx-0, reason: not valid java name */
    public static /* synthetic */ void m1455$r8$lambda$JxGAByAESCLWWhMw0Ii9S5PJx0(CachedAppOptimizer r0, boolean r1) {
        r0.lambda$updateUseFreezer$1(r1);
    }

    public static /* synthetic */ void $r8$lambda$ZH029cmpkk4u9PrurAANG_5gCdM(CachedAppOptimizer r0, boolean r1, ProcessRecord r2) {
        r0.lambda$enableFreezer$0(r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$jm2CpzGukzi3xkht-MuVyob5M48, reason: not valid java name */
    public static /* synthetic */ void m1456$r8$lambda$jm2CpzGukzi3xkhtMuVyob5M48(CachedAppOptimizer r0, Integer r1, Integer r2) {
        r0.lambda$binderErrorInternal$3(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmAm, reason: not valid java name */
    static /* bridge */ /* synthetic */ ActivityManagerService m1457$$Nest$fgetmAm(CachedAppOptimizer r0) {
        return r0.mAm;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmDebugCompaction, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m1458$$Nest$fgetmDebugCompaction(CachedAppOptimizer r0) {
        return r0.mDebugCompaction;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmFreezeHandler, reason: not valid java name */
    static /* bridge */ /* synthetic */ Handler m1459$$Nest$fgetmFreezeHandler(CachedAppOptimizer r0) {
        return r0.mFreezeHandler;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmFreezer, reason: not valid java name */
    static /* bridge */ /* synthetic */ Freezer m1460$$Nest$fgetmFreezer(CachedAppOptimizer r0) {
        return r0.mFreezer;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmFreezerOverride, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m1461$$Nest$fgetmFreezerOverride(CachedAppOptimizer r0) {
        return r0.mFreezerOverride;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmFrozenProcesses, reason: not valid java name */
    static /* bridge */ /* synthetic */ SparseArray m1462$$Nest$fgetmFrozenProcesses(CachedAppOptimizer r0) {
        return r0.mFrozenProcesses;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmOptEx, reason: not valid java name */
    static /* bridge */ /* synthetic */ ICachedAppOptimizerOptEx m1463$$Nest$fgetmOptEx(CachedAppOptimizer r0) {
        return r0.mOptEx;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmPendingCompactionProcesses, reason: not valid java name */
    static /* bridge */ /* synthetic */ ArrayList m1464$$Nest$fgetmPendingCompactionProcesses(CachedAppOptimizer r0) {
        return r0.mPendingCompactionProcesses;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmProcLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ ActivityManagerGlobalLock m1465$$Nest$fgetmProcLock(CachedAppOptimizer r0) {
        return r0.mProcLock;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmProcLocksReader, reason: not valid java name */
    static /* bridge */ /* synthetic */ ProcLocksReader m1466$$Nest$fgetmProcLocksReader(CachedAppOptimizer r0) {
        return r0.mProcLocksReader;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmProcessDependencies, reason: not valid java name */
    static /* bridge */ /* synthetic */ ProcessDependencies m1467$$Nest$fgetmProcessDependencies(CachedAppOptimizer r0) {
        return r0.mProcessDependencies;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmRandom, reason: not valid java name */
    static /* bridge */ /* synthetic */ Random m1468$$Nest$fgetmRandom(CachedAppOptimizer r0) {
        return r0.mRandom;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmTestCallback, reason: not valid java name */
    static /* bridge */ /* synthetic */ PropertyChangedCallbackForTest m1469$$Nest$fgetmTestCallback(CachedAppOptimizer r0) {
        return r0.mTestCallback;
    }

    /* JADX INFO: renamed from: -$$Nest$mbinderErrorInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1470$$Nest$mbinderErrorInternal(CachedAppOptimizer r0, IntArray r1) {
        r0.binderErrorInternal(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mcompactSystem, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1471$$Nest$mcompactSystem(CachedAppOptimizer r0) {
        r0.compactSystem();
    }

    /* JADX INFO: renamed from: -$$Nest$mfreezeAppAsyncLSP, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1472$$Nest$mfreezeAppAsyncLSP(CachedAppOptimizer r0, ProcessRecord r1, long r2) {
        r0.freezeAppAsyncLSP(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mpostUidFrozenMessage, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1473$$Nest$mpostUidFrozenMessage(CachedAppOptimizer r0, int r1, boolean r2) {
        r0.postUidFrozenMessage(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mreportOneUidFrozenStateChanged, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1474$$Nest$mreportOneUidFrozenStateChanged(CachedAppOptimizer r0, int r1, boolean r2) {
        r0.reportOneUidFrozenStateChanged(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mreportProcessFreezableChangedLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1475$$Nest$mreportProcessFreezableChangedLocked(CachedAppOptimizer r0, ProcessRecord r1) {
        r0.reportProcessFreezableChangedLocked(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateCompactStatsdSampleRate, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1476$$Nest$mupdateCompactStatsdSampleRate(CachedAppOptimizer r0) {
        r0.updateCompactStatsdSampleRate();
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateCompactionThrottles, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1477$$Nest$mupdateCompactionThrottles(CachedAppOptimizer r0) {
        r0.updateCompactionThrottles();
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateFreezerBinderState, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1478$$Nest$mupdateFreezerBinderState(CachedAppOptimizer r0) {
        r0.updateFreezerBinderState();
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateFreezerDebounceTimeout, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1479$$Nest$mupdateFreezerDebounceTimeout(CachedAppOptimizer r0) {
        r0.updateFreezerDebounceTimeout();
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateFreezerExemptInstPkg, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1480$$Nest$mupdateFreezerExemptInstPkg(CachedAppOptimizer r0) {
        r0.updateFreezerExemptInstPkg();
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateFreezerStatsdSampleRate, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1481$$Nest$mupdateFreezerStatsdSampleRate(CachedAppOptimizer r0) {
        r0.updateFreezerStatsdSampleRate();
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateFullDeltaRssThrottle, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1482$$Nest$mupdateFullDeltaRssThrottle(CachedAppOptimizer r0) {
        r0.updateFullDeltaRssThrottle();
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateFullRssThrottle, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1483$$Nest$mupdateFullRssThrottle(CachedAppOptimizer r0) {
        r0.updateFullRssThrottle();
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateMaxOomAdjThrottle, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1484$$Nest$mupdateMaxOomAdjThrottle(CachedAppOptimizer r0) {
        r0.updateMaxOomAdjThrottle();
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateMinOomAdjThrottle, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1485$$Nest$mupdateMinOomAdjThrottle(CachedAppOptimizer r0) {
        r0.updateMinOomAdjThrottle();
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateProcStateThrottle, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1486$$Nest$mupdateProcStateThrottle(CachedAppOptimizer r0) {
        r0.updateProcStateThrottle();
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateUseCompaction, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1487$$Nest$mupdateUseCompaction(CachedAppOptimizer r0) {
        r0.updateUseCompaction();
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateUseFreezer, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1488$$Nest$mupdateUseFreezer(CachedAppOptimizer r0) {
        r0.updateUseFreezer();
    }

    /* JADX INFO: renamed from: -$$Nest$smcompactProcess, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1489$$Nest$smcompactProcess(int r0, int r1) {
        compactProcess(r0, r1);
    }

    /* JADX INFO: renamed from: -$$Nest$smgetMemoryFreedCompaction, reason: not valid java name */
    static /* bridge */ /* synthetic */ long m1490$$Nest$smgetMemoryFreedCompaction() {
        return getMemoryFreedCompaction();
    }

    /* JADX INFO: renamed from: -$$Nest$smgetUsedZramMemory, reason: not valid java name */
    static /* bridge */ /* synthetic */ long m1491$$Nest$smgetUsedZramMemory() {
        return getUsedZramMemory();
    }

    /* JADX INFO: renamed from: -$$Nest$smthreadCpuTimeNs, reason: not valid java name */
    static /* bridge */ /* synthetic */ long m1492$$Nest$smthreadCpuTimeNs() {
        return threadCpuTimeNs();
    }

    /* JADX INFO: renamed from: -$$Nest$smtraceAppFreeze, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1493$$Nest$smtraceAppFreeze(String r0, int r1, int r2) {
        traceAppFreeze(r0, r1, r2);
    }

    private static native void cancelCompaction();

    private static native void compactProcess(int r0, int r1);

    private native void compactSystem();

    static native double getFreeSwapPercent();

    private static native long getMemoryFreedCompaction();

    private static native long getUsedZramMemory();

    private static native long threadCpuTimeNs();

    static {
        DEFAULT_COMPACT_PROC_STATE_THROTTLE = String.valueOf(11);
        CACHED_APP_FREEZER_ENABLED_URI = Settings.Global.getUriFor("cached_apps_freezer");
        mPerf = new BoostFramework();
    }

    public CachedAppOptimizer(ActivityManagerService am) {
        this(am, null, new DefaultProcessDependencies(null));
    }

    CachedAppOptimizer(ActivityManagerService am, PropertyChangedCallbackForTest callback, ProcessDependencies processDependencies) {
        this.mPendingCompactionProcesses = new ArrayList();
        this.mFrozenProcesses = new SparseArray();
        this.mFreezerLock = new Object();
        this.mOnFlagsChangedListener = new AnonymousClass1(this);
        this.mOnNativeBootFlagsChangedListener = new AnonymousClass2(this);
        this.mPhenotypeFlagLock = new Object();
        this.mCompactThrottleSomeSome = DEFAULT_COMPACT_THROTTLE_1;
        this.mCompactThrottleSomeFull = JobStatus.DEFAULT_TRIGGER_UPDATE_DELAY;
        this.mCompactThrottleFullSome = 500;
        this.mCompactThrottleFullFull = 300000;
        this.mCompactThrottleMinOomAdj = DEFAULT_COMPACT_THROTTLE_MIN_OOM_ADJ;
        this.mCompactThrottleMaxOomAdj = DEFAULT_COMPACT_THROTTLE_MAX_OOM_ADJ;
        this.mUseCompaction = true;
        this.mDebugCompaction = ActivityManagerDebugConfig.DEBUG_COMPACTION;
        this.mUseFreezer = false;
        this.mFreezerDisableCount = 1;
        this.mCompactionPriority = 0;
        this.mRandom = new Random();
        this.mCompactStatsdSampleRate = DEFAULT_STATSD_SAMPLE_RATE;
        this.mFreezerStatsdSampleRate = DEFAULT_STATSD_SAMPLE_RATE;
        this.mFullAnonRssThrottleKb = DEFAULT_COMPACT_FULL_RSS_THROTTLE_KB;
        this.mFullDeltaRssThrottleKb = DEFAULT_COMPACT_FULL_DELTA_RSS_THROTTLE_KB;
        this.mFreezerBinderEnabled = true;
        this.mFreezerBinderDivisor = 4;
        this.mFreezerBinderOffset = 500;
        this.mFreezerBinderThreshold = 1000;
        this.mFreezerBinderCallbackEnabled = true;
        this.mFreezerBinderCallbackThrottle = JobStatus.DEFAULT_TRIGGER_UPDATE_DELAY;
        this.mFreezerBinderAsyncThreshold = 1024;
        this.mFreezerOverride = false;
        this.mFreezerBinderCallbackLast = -1;
        this.mFreezerDebounceTimeout = JobStatus.DEFAULT_TRIGGER_UPDATE_DELAY;
        this.mFreezerExemptInstPkg = false;
        this.mAm = am;
        this.mProcLock = am.mProcLock;
        this.mCachedAppOptimizerThread = new ServiceThread("CachedAppOptimizerThread", this.mCompactionPriority, true);
        this.mProcStateThrottle = new HashSet();
        this.mProcessDependencies = processDependencies;
        this.mTestCallback = callback;
        this.mSettingsObserver = new SettingsContentObserver(this);
        this.mProcLocksReader = new ProcLocksReader();
        this.mFreezer = this.mAm.getFreezer();
    }

    public void init() {
        DeviceConfig.addOnPropertiesChangedListener("activity_manager", ActivityThread.currentApplication().getMainExecutor(), this.mOnFlagsChangedListener);
        DeviceConfig.addOnPropertiesChangedListener("activity_manager_native_boot", ActivityThread.currentApplication().getMainExecutor(), this.mOnNativeBootFlagsChangedListener);
        this.mAm.mContext.getContentResolver().registerContentObserver(CACHED_APP_FREEZER_ENABLED_URI, false, this.mSettingsObserver);
        Object r0 = this.mPhenotypeFlagLock;
        monitor-enter(r0);
        updateUseCompaction();     // Catch: Throwable -> L8
        updateCompactionThrottles();     // Catch: Throwable -> L8
        updateCompactStatsdSampleRate();     // Catch: Throwable -> L8
        updateFreezerStatsdSampleRate();     // Catch: Throwable -> L8
        updateFullRssThrottle();     // Catch: Throwable -> L8
        updateFullDeltaRssThrottle();     // Catch: Throwable -> L8
        updateProcStateThrottle();     // Catch: Throwable -> L8
        updateUseFreezer();     // Catch: Throwable -> L8
        updateMinOomAdjThrottle();     // Catch: Throwable -> L8
        updateMaxOomAdjThrottle();     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        setAppCompactProperties();
        this.mOptEx = SysOptBridge.getFactory().getCachedAppOptimizerOptEx();
        return;
    L8:
        th = move-exception;
        throw th;
    }

    private void setAppCompactProperties() {
        boolean r0 = Boolean.valueOf(mPerf.perfGetProp("vendor.appcompact.enable_app_compact", "false")).booleanValue();
        boolean debugCompaction = Boolean.valueOf(mPerf.perfGetProp("vendor.appcompact.debug_app_compact", "false")).booleanValue();
        int threadPriority = Integer.valueOf(mPerf.perfGetProp("vendor.appcompact.thread_priority", String.valueOf(0))).intValue();
        if (threadPriority == 2) goto L5;
        threadPriority = 0;
    L5:
        Integer.valueOf(mPerf.perfGetProp("vendor.appcompact.some_compact_type", String.valueOf(2))).intValue();
        Integer.valueOf(mPerf.perfGetProp("vendor.appcompact.full_compact_type", String.valueOf(2))).intValue();
        int compactThrottleSomeSome = Integer.valueOf(mPerf.perfGetProp("vendor.appcompact.compact_throttle_somesome", String.valueOf(DEFAULT_COMPACT_THROTTLE_1))).intValue();
        int compactThrottleSomeFull = Integer.valueOf(mPerf.perfGetProp("vendor.appcompact.compact_throttle_somefull", String.valueOf(JobStatus.DEFAULT_TRIGGER_UPDATE_DELAY))).intValue();
        int compactThrottleFullSome = Integer.valueOf(mPerf.perfGetProp("vendor.appcompact.compact_throttle_fullsome", String.valueOf(500))).intValue();
        int compactThrottleFullFull = Integer.valueOf(mPerf.perfGetProp("vendor.appcompact.compact_throttle_fullfull", String.valueOf(300000))).intValue();
        int compactThrottleBfgs = Integer.valueOf(mPerf.perfGetProp("vendor.appcompact.compact_throttle_bfgs", String.valueOf(600000))).intValue();
        int compactThrottlePersistent = Integer.valueOf(mPerf.perfGetProp("vendor.appcompact.compact_throttle_persistent", String.valueOf(600000))).intValue();
        int fullRssThrottleKB = Integer.valueOf(mPerf.perfGetProp("vendor.appcompact.rss_throttle_kb", String.valueOf(DEFAULT_COMPACT_FULL_RSS_THROTTLE_KB))).intValue();
        int deltaRssThrottleKB = Integer.valueOf(mPerf.perfGetProp("vendor.appcompact.delta_rss_throttle_kb", String.valueOf(DEFAULT_COMPACT_FULL_DELTA_RSS_THROTTLE_KB))).intValue();
        DeviceConfig.setProperty("activity_manager", KEY_COMPACT_THROTTLE_1, String.valueOf(compactThrottleSomeSome), true);
        DeviceConfig.setProperty("activity_manager", KEY_COMPACT_THROTTLE_2, String.valueOf(compactThrottleSomeFull), true);
        DeviceConfig.setProperty("activity_manager", KEY_COMPACT_THROTTLE_3, String.valueOf(compactThrottleFullSome), true);
        DeviceConfig.setProperty("activity_manager", KEY_COMPACT_THROTTLE_4, String.valueOf(compactThrottleFullFull), true);
        DeviceConfig.setProperty("activity_manager", KEY_COMPACT_THROTTLE_5, String.valueOf(compactThrottleBfgs), true);
        DeviceConfig.setProperty("activity_manager", KEY_COMPACT_THROTTLE_6, String.valueOf(compactThrottlePersistent), true);
        DeviceConfig.setProperty("activity_manager", KEY_COMPACT_FULL_RSS_THROTTLE_KB, String.valueOf(fullRssThrottleKB), true);
        DeviceConfig.setProperty("activity_manager", KEY_COMPACT_FULL_DELTA_RSS_THROTTLE_KB, String.valueOf(deltaRssThrottleKB), true);
        DeviceConfig.setProperty("activity_manager", KEY_USE_COMPACTION, String.valueOf(SystemProperties.getBoolean("persist.sys.cachedappoipt.usecompaction", true)), true);
        DeviceConfig.setProperty("activity_manager", KEY_DEBUG_COMPACTION, String.valueOf(debugCompaction), true);
        DeviceConfig.setProperty("activity_manager", KEY_COMPACTION_PRIORITY, String.valueOf(threadPriority), true);
    }

    public boolean useCompaction() {
        Object r0 = this.mPhenotypeFlagLock;
        monitor-enter(r0);
        boolean r1 = this.mUseCompaction;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public boolean useFreezer() {
        Object r0 = this.mPhenotypeFlagLock;
        monitor-enter(r0);
        boolean r1 = this.mUseFreezer;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public boolean freezerExemptInstPkg() {
        Object r0 = this.mPhenotypeFlagLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mUseFreezer == true) goto L7;
    L11:
        boolean r1 = false;
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r1;
    L7:
        if (this.mFreezerExemptInstPkg == false) goto L11;
        r1 = true;
        goto L12
    }

    @NeverCompile
    void dump(PrintWriter pw) {
        dumpCompact(pw);
        dumpFreezer(pw);
    }

    @NeverCompile
    void dumpCompact(PrintWriter pw) {
        pw.println("Compaction settings");
        Object r0 = this.mPhenotypeFlagLock;
        monitor-enter(r0);
        pw.println("  use_compaction=" + this.mUseCompaction);     // Catch: Throwable -> L21
        pw.println("  debug_compaction=" + this.mDebugCompaction);     // Catch: Throwable -> L21
        pw.println("  compaction_priority=" + this.mCompactionPriority);     // Catch: Throwable -> L21
        pw.println("  compact_throttle_1=" + this.mCompactThrottleSomeSome);     // Catch: Throwable -> L21
        pw.println("  compact_throttle_2=" + this.mCompactThrottleSomeFull);     // Catch: Throwable -> L21
        pw.println("  compact_throttle_3=" + this.mCompactThrottleFullSome);     // Catch: Throwable -> L21
        pw.println("  compact_throttle_4=" + this.mCompactThrottleFullFull);     // Catch: Throwable -> L21
        pw.println("  compact_throttle_min_oom_adj=" + this.mCompactThrottleMinOomAdj);     // Catch: Throwable -> L21
        pw.println("  compact_throttle_max_oom_adj=" + this.mCompactThrottleMaxOomAdj);     // Catch: Throwable -> L21
        pw.println("  compact_statsd_sample_rate=" + this.mCompactStatsdSampleRate);     // Catch: Throwable -> L21
        pw.println("  compact_full_rss_throttle_kb=" + this.mFullAnonRssThrottleKb);     // Catch: Throwable -> L21
        pw.println("  compact_full_delta_rss_throttle_kb=" + this.mFullDeltaRssThrottleKb);     // Catch: Throwable -> L21
        pw.println("  compact_proc_state_throttle=" + Arrays.toString(this.mProcStateThrottle.toArray(new Integer[0])));     // Catch: Throwable -> L21
        monitor-exit(r0);     // Catch: Throwable -> L21
        this.mCompactStatsManager.dump(pw);
        ActivityManagerGlobalLock r1 = this.mProcLock;
        ActivityManagerService.boostPriorityForProcLockedSection();
        monitor-enter(r1);
    L13:
        th = move-exception;
        ActivityManagerService.resetPriorityAfterProcLockedSection();
        throw th;
    L9:
        if (this.mPendingCompactionProcesses.isEmpty() == true) goto L15;
        pw.println("  Pending compactions:");     // Catch: Throwable -> L13
        int size = this.mPendingCompactionProcesses.size();     // Catch: Throwable -> L13
        int i = 0;
    L11:
        if (i >= size) goto L15;
        ProcessRecord app = this.mPendingCompactionProcesses.get(i);     // Catch: Throwable -> L13
        pw.println("    pid: " + app.getPid() + ". name: " + app.processName + ". hasPendingCompact: " + app.mOptRecord.hasPendingCompact());     // Catch: Throwable -> L13
        i = i + 1;     // Catch: Throwable -> L13
    L15:
        monitor-exit(r1);     // Catch: Throwable -> L13
        ActivityManagerService.resetPriorityAfterProcLockedSection();
        pw.println();
        return;
    L21:
        th = move-exception;
        throw th;
    }

    @NeverCompile
    void dumpFreezer(PrintWriter pw) {
        pw.println("Freezer settings");
        Object r0 = this.mPhenotypeFlagLock;
        monitor-enter(r0);
        pw.println("  use_freezer=" + this.mUseFreezer);     // Catch: Throwable -> L20
        pw.println("  freeze_statsd_sample_rate=" + this.mFreezerStatsdSampleRate);     // Catch: Throwable -> L20
        pw.println("  freeze_debounce_timeout=" + this.mFreezerDebounceTimeout);     // Catch: Throwable -> L20
        pw.println("  freeze_exempt_inst_pkg=" + this.mFreezerExemptInstPkg);     // Catch: Throwable -> L20
        pw.println("  freeze_binder_enabled=" + this.mFreezerBinderEnabled);     // Catch: Throwable -> L20
        pw.println("  freeze_binder_threshold=" + this.mFreezerBinderThreshold);     // Catch: Throwable -> L20
        pw.println("  freeze_binder_divisor=" + this.mFreezerBinderDivisor);     // Catch: Throwable -> L20
        pw.println("  freeze_binder_offset=" + this.mFreezerBinderOffset);     // Catch: Throwable -> L20
        pw.println("  freeze_binder_callback_enabled=" + this.mFreezerBinderCallbackEnabled);     // Catch: Throwable -> L20
        pw.println("  freeze_binder_callback_throttle=" + this.mFreezerBinderCallbackThrottle);     // Catch: Throwable -> L20
        pw.println("  freeze_binder_async_threshold=" + this.mFreezerBinderAsyncThreshold);     // Catch: Throwable -> L20
        ActivityManagerGlobalLock r1 = this.mProcLock;     // Catch: Throwable -> L20
        ActivityManagerService.boostPriorityForProcLockedSection();     // Catch: Throwable -> L20
        monitor-enter(r1);     // Catch: Throwable -> L20
        int size = this.mFrozenProcesses.size();     // Catch: Throwable -> L11
        pw.println("  Apps frozen: " + size);     // Catch: Throwable -> L11
        int i = 0;
    L7:
        if (i >= size) goto L16;
        ProcessRecord app = this.mFrozenProcesses.valueAt(i);     // Catch: Throwable -> L11
        StringBuilder r5 = new StringBuilder();     // Catch: Throwable -> L11
        r5.append("    ");     // Catch: Throwable -> L11
        r5.append(app.mOptRecord.getFreezeUnfreezeTime());     // Catch: Throwable -> L11
        r5.append(": ");     // Catch: Throwable -> L11
        r5.append(app.getPid());     // Catch: Throwable -> L11
        r5.append(" ");     // Catch: Throwable -> L11
        r5.append(app.processName);     // Catch: Throwable -> L11
        if (app.mOptRecord.isFreezeSticky() == false) goto L13;
        String r6 = " (sticky)";
    L14:
        r5.append(r6);     // Catch: Throwable -> L11
        pw.println(r5.toString());     // Catch: Throwable -> L11
        i = i + 1;     // Catch: Throwable -> L11
        goto L7
    L13:
        r6 = "";
        goto L14
    L16:
        monitor-exit(r1);     // Catch: Throwable -> L11
        ActivityManagerService.resetPriorityAfterProcLockedSection();     // Catch: Throwable -> L20
        monitor-exit(r0);     // Catch: Throwable -> L20
        return;
    L11:
        th = move-exception;
        ActivityManagerService.resetPriorityAfterProcLockedSection();     // Catch: Throwable -> L20
        throw th;     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        throw th;
    }

    boolean compactApp(ProcessRecord app, CompactProfile compactProfile, CompactSource source, boolean force) {
        app.mOptRecord.setReqCompactSource(source);
        app.mOptRecord.setReqCompactProfile(compactProfile);
        if (compactProfile != null) goto L5;
    L28:
        return false;
    L5:
        if (compactProfile.equals(CompactProfile.NONE) == true) goto L28;
        if (app.processName == null) goto L10;
        String processName = app.processName;
    L11:
        this.mCompactStatsManager.logCompactionRequested(source, compactProfile, processName);
        if ((app.info.getSysEx().compactFlags & 1) == 0) goto L18;
        if (this.mDebugCompaction == false) goto L16;
        Slog.e("ActivityManager", "Skip compaction as process " + app.processName + " is forbidden compacted");
    L16:
        return false;
    L18:
        if (app.mOptRecord.hasPendingCompact() == true) goto L25;
        if (this.mDebugCompaction == false) goto L22;
        Slog.d("ActivityManager", "compactApp " + app.mOptRecord.getReqCompactSource().name() + " " + app.mOptRecord.getReqCompactProfile().name() + " " + processName);
    L22:
        app.mOptRecord.setHasPendingCompact(true);
        app.mOptRecord.setForceCompact(force);
        this.mPendingCompactionProcesses.add(app);
        this.mCompactionHandler.sendMessage(this.mCompactionHandler.obtainMessage(1, app.mState.getCurAdj(), app.mState.getSetProcState()));
        return true;
    L25:
        if (this.mDebugCompaction == false) goto L27;
        Slog.d("ActivityManager", " compactApp Skipped for " + app.processName + " pendingCompact= " + app.mOptRecord.hasPendingCompact() + ". Requested compact profile: " + app.mOptRecord.getReqCompactProfile().name() + ". Compact source " + app.mOptRecord.getReqCompactSource().name());
    L27:
        return false;
    L10:
        processName = "";
        goto L11
    }

    void compactNative(CompactProfile compactProfile, int pid) {
        this.mCompactionHandler.sendMessage(this.mCompactionHandler.obtainMessage(5, pid, compactProfile.ordinal()));
    }

    void compactAllSystem() {
        if (useCompaction() == true) goto L5;
        return;
    L5:
        if (this.mDebugCompaction == false) goto L7;
        Slog.d("ActivityManager", "compactAllSystem");
    L7:
        Trace.instantForTrack(64, ATRACE_COMPACTION_TRACK, "compactAllSystem");
        this.mCompactionHandler.sendMessage(this.mCompactionHandler.obtainMessage(2));
    }

    private void updateUseCompaction() {
        String useCompaction = DeviceConfig.getProperty("activity_manager", KEY_USE_COMPACTION);
        if (useCompaction != null) goto L5;
        setAppCompactProperties();
    L5:
        this.mUseCompaction = DeviceConfig.getBoolean("activity_manager", KEY_USE_COMPACTION, true);
        this.mDebugCompaction = DeviceConfig.getBoolean("activity_manager", KEY_DEBUG_COMPACTION, ActivityManagerDebugConfig.DEBUG_COMPACTION);
        this.mCompactionPriority = DeviceConfig.getInt("activity_manager", KEY_COMPACTION_PRIORITY, 0);
        if (this.mUseCompaction == true) goto L8;
    L13:
        Process.setThreadGroupAndCpuset(this.mCachedAppOptimizerThread.getThreadId(), this.mCompactionPriority);
        return;
    L8:
        if (this.mCompactionHandler != null) goto L13;
        if (this.mCachedAppOptimizerThread.isAlive() == true) goto L12;
        this.mCachedAppOptimizerThread.start();
    L12:
        this.mCompactionHandler = new MemCompactionHandler(this, null);
        this.mCompactStatsManager = CompactionStatsManager.getInstance();
        goto L13
    }

    public synchronized boolean enableFreezer(final boolean enable) {
        monitor-enter(this);
    L19:
        th = move-exception;
        throw th;
    L4:
        boolean r1 = false;
        if (this.mUseFreezer == true) goto L9;
        monitor-exit(this);
        return false;
    L9:
        if (enable == false) goto L21;
        this.mFreezerDisableCount--;     // Catch: Throwable -> L19
        if (this.mFreezerDisableCount <= 0) goto L15;
        monitor-exit(this);
        return true;
    L15:
        if (this.mFreezerDisableCount >= 0) goto L25;
        Slog.e("ActivityManager", "unbalanced call to enableFreezer, ignoring");     // Catch: Throwable -> L19
        this.mFreezerDisableCount = 0;     // Catch: Throwable -> L19
        monitor-exit(this);
        return false;
    L25:
        ActivityManagerService r2 = this.mAm;     // Catch: Throwable -> L19
        ActivityManagerService.boostPriorityForLockedSection();     // Catch: Throwable -> L19
        monitor-enter(r2);     // Catch: Throwable -> L19
        ActivityManagerGlobalLock r3 = this.mProcLock;     // Catch: Throwable -> L44
        ActivityManagerService.boostPriorityForProcLockedSection();     // Catch: Throwable -> L44
        monitor-enter(r3);     // Catch: Throwable -> L44
        if (enable == true) goto L54;
        r1 = true;
    L54:
        this.mFreezerOverride = r1;     // Catch: Throwable -> L40
        Slog.d("ActivityManager", "freezer override set to " + this.mFreezerOverride);     // Catch: Throwable -> L40
        this.mAm.mProcessList.forEachLruProcessesLOSP(true, new CachedAppOptimizer$$ExternalSyntheticLambda1(this, enable));     // Catch: Throwable -> L40
        monitor-exit(r3);     // Catch: Throwable -> L40
        ActivityManagerService.resetPriorityAfterProcLockedSection();     // Catch: Throwable -> L38
        monitor-exit(r2);     // Catch: Throwable -> L38
        ActivityManagerService.resetPriorityAfterLockedSection();     // Catch: Throwable -> L19
        monitor-exit(this);
        return true;
    L40:
        th = th;
    L59:
        ActivityManagerService.resetPriorityAfterProcLockedSection();     // Catch: Throwable -> L44
        throw th;     // Catch: Throwable -> L44
    L46:
        th = th;
    L44:
        th = th;
    L48:
        monitor-exit(r2);     // Catch: Throwable -> L38
        ActivityManagerService.resetPriorityAfterLockedSection();     // Catch: Throwable -> L19
        throw th;     // Catch: Throwable -> L19
    L38:
        th = th;
        goto L48
    L21:
        this.mFreezerDisableCount++;     // Catch: Throwable -> L19
        if (this.mFreezerDisableCount <= 1) goto L25;
        monitor-exit(this);
        return true;
    }

    private /* synthetic */ void lambda$enableFreezer$0(boolean enable, ProcessRecord process) {
        if (process != null) goto L4;
        return;
    L4:
        ProcessCachedOptimizerRecord opt = process.mOptRecord;
        if (enable == true) goto L7;
    L12:
        if (enable == false) goto L14;
        return;
    L14:
        if (opt.isFrozen() == false) goto L18;
        unfreezeAppLSP(process, 19);
        opt.setFreezerOverride(true);
        return;
    L18:
        return;
    L7:
        if (opt.hasFreezerOverride() == false) goto L12;
        if (process.mState.getCurAdj() < this.mAm.mConstants.FREEZER_CUTOFF_ADJ) goto L11;
        freezeAppAsyncLSP(process);
    L11:
        opt.setFreezerOverride(false);
        goto L12
    }

    public void updateUseFreezer(boolean fromFreeze) {
        String configOverride = Settings.Global.getString(this.mAm.mContext.getContentResolver(), "cached_apps_freezer");
        if (ServiceConfigAccessor.PROVIDER_MODE_ENABLED.equals(configOverride) == false) goto L5;
    L6:
        Object r1 = this.mPhenotypeFlagLock;
        monitor-enter(r1);
        this.mUseFreezer = this.mFreezer.isFreezerSupported();     // Catch: Throwable -> L21
        updateFreezerDebounceTimeout();     // Catch: Throwable -> L21
        updateFreezerExemptInstPkg();     // Catch: Throwable -> L21
        monitor-exit(r1);     // Catch: Throwable -> L21
    L10:
        boolean useFreezer = this.mUseFreezer;
        if (useFreezer == false) goto L19;
        Slog.d("ActivityManager", "Freezer enabled by opt and cfg");
        enableFreezer(true);
        if (this.mCachedAppOptimizerThread.isAlive() == true) goto L16;
        this.mCachedAppOptimizerThread.start();
    L16:
        if (this.mFreezeHandler != null) goto L18;
        this.mFreezeHandler = new FreezeHandler(this, null);
    L18:
        Process.setThreadGroupAndCpuset(this.mCachedAppOptimizerThread.getThreadId(), this.mCompactionPriority);
        return;
    L19:
        Slog.d("ActivityManager", "Freezer disabled by opt and cfg");
        enableFreezer(false);
        return;
    L21:
        th = move-exception;
        throw th;
    L5:
        if (DeviceConfig.getBoolean("activity_manager_native_boot", KEY_USE_FREEZER, true) == false) goto L10;
        goto L6
    }

    private void updateUseFreezer() {
        String configOverride = Settings.Global.getString(this.mAm.mContext.getContentResolver(), "cached_apps_freezer");
        if (ServiceConfigAccessor.PROVIDER_MODE_DISABLED.equals(configOverride) == false) goto L6;
        this.mUseFreezer = false;
    L11:
        final boolean useFreezer = this.mUseFreezer;
        this.mAm.mHandler.post(new CachedAppOptimizer$$ExternalSyntheticLambda2(this, useFreezer));
        return;
    L6:
        if (ServiceConfigAccessor.PROVIDER_MODE_ENABLED.equals(configOverride) == true) goto L11;
        if (DeviceConfig.getBoolean("activity_manager_native_boot", KEY_USE_FREEZER, true) == true) goto L11;
        this.mUseFreezer = false;
        goto L11
    }

    private /* synthetic */ void lambda$updateUseFreezer$1(boolean useFreezer) {
        if (useFreezer == false) goto L11;
        Slog.d("ActivityManager", "Freezer enabled");
        enableFreezer(true);
        if (this.mCachedAppOptimizerThread.isAlive() == true) goto L8;
        this.mCachedAppOptimizerThread.start();
    L8:
        if (this.mFreezeHandler != null) goto L10;
        this.mFreezeHandler = new FreezeHandler(this, null);
    L10:
        Process.setThreadGroupAndCpuset(this.mCachedAppOptimizerThread.getThreadId(), this.mCompactionPriority);
        return;
    L11:
        Slog.d("ActivityManager", "Freezer disabled");
        enableFreezer(false);
    }

    private void updateCompactionThrottles() {
        boolean useThrottleDefaults = false;
        String throttleSomeSomeFlag = DeviceConfig.getProperty("activity_manager", KEY_COMPACT_THROTTLE_1);
        String throttleSomeFullFlag = DeviceConfig.getProperty("activity_manager", KEY_COMPACT_THROTTLE_2);
        String throttleFullSomeFlag = DeviceConfig.getProperty("activity_manager", KEY_COMPACT_THROTTLE_3);
        String throttleFullFullFlag = DeviceConfig.getProperty("activity_manager", KEY_COMPACT_THROTTLE_4);
        String throttleBFGSFlag = DeviceConfig.getProperty("activity_manager", KEY_COMPACT_THROTTLE_5);
        String throttlePersistentFlag = DeviceConfig.getProperty("activity_manager", KEY_COMPACT_THROTTLE_6);
        String throttleMinOomAdjFlag = DeviceConfig.getProperty("activity_manager", KEY_COMPACT_THROTTLE_MIN_OOM_ADJ);
        String throttleMaxOomAdjFlag = DeviceConfig.getProperty("activity_manager", KEY_COMPACT_THROTTLE_MAX_OOM_ADJ);
        if (TextUtils.isEmpty(throttleSomeSomeFlag) == false) goto L5;
    L23:
        useThrottleDefaults = true;
    L24:
        if (useThrottleDefaults == false) goto L29;
        this.mCompactThrottleSomeSome = DEFAULT_COMPACT_THROTTLE_1;
        this.mCompactThrottleSomeFull = JobStatus.DEFAULT_TRIGGER_UPDATE_DELAY;
        this.mCompactThrottleFullSome = 500;
        this.mCompactThrottleFullFull = 300000;
        this.mCompactThrottleMinOomAdj = DEFAULT_COMPACT_THROTTLE_MIN_OOM_ADJ;
        this.mCompactThrottleMaxOomAdj = DEFAULT_COMPACT_THROTTLE_MAX_OOM_ADJ;
        return;
    L29:
        return;
    L5:
        if (TextUtils.isEmpty(throttleSomeFullFlag) == true) goto L23;
        if (TextUtils.isEmpty(throttleFullSomeFlag) == true) goto L23;
        if (TextUtils.isEmpty(throttleFullFullFlag) == true) goto L23;
        if (TextUtils.isEmpty(throttleBFGSFlag) == true) goto L23;
        if (TextUtils.isEmpty(throttlePersistentFlag) == true) goto L23;
        if (TextUtils.isEmpty(throttleMinOomAdjFlag) == true) goto L23;
        if (TextUtils.isEmpty(throttleMaxOomAdjFlag) == true) goto L23;
        this.mCompactThrottleSomeSome = Integer.parseInt(throttleSomeSomeFlag);     // Catch: NumberFormatException -> L21
        this.mCompactThrottleSomeFull = Integer.parseInt(throttleSomeFullFlag);     // Catch: NumberFormatException -> L21
        this.mCompactThrottleFullSome = Integer.parseInt(throttleFullSomeFlag);     // Catch: NumberFormatException -> L21
        this.mCompactThrottleFullFull = Integer.parseInt(throttleFullFullFlag);     // Catch: NumberFormatException -> L21
        this.mCompactThrottleMinOomAdj = Long.parseLong(throttleMinOomAdjFlag);     // Catch: NumberFormatException -> L21
        this.mCompactThrottleMaxOomAdj = Long.parseLong(throttleMaxOomAdjFlag);     // Catch: NumberFormatException -> L21
    L22:
        useThrottleDefaults = true;
        goto L24
    }

    private void updateCompactStatsdSampleRate() {
        this.mCompactStatsdSampleRate = DeviceConfig.getFloat("activity_manager", KEY_COMPACT_STATSD_SAMPLE_RATE, DEFAULT_STATSD_SAMPLE_RATE);
        this.mCompactStatsdSampleRate = Math.min(1.0f, Math.max(0.0f, this.mCompactStatsdSampleRate));
    }

    private void updateFreezerStatsdSampleRate() {
        this.mFreezerStatsdSampleRate = DeviceConfig.getFloat("activity_manager", KEY_FREEZER_STATSD_SAMPLE_RATE, DEFAULT_STATSD_SAMPLE_RATE);
        this.mFreezerStatsdSampleRate = Math.min(1.0f, Math.max(0.0f, this.mFreezerStatsdSampleRate));
    }

    private void updateFullRssThrottle() {
        this.mFullAnonRssThrottleKb = DeviceConfig.getLong("activity_manager", KEY_COMPACT_FULL_RSS_THROTTLE_KB, DEFAULT_COMPACT_FULL_RSS_THROTTLE_KB);
        if (this.mFullAnonRssThrottleKb >= 0) goto L6;
        this.mFullAnonRssThrottleKb = DEFAULT_COMPACT_FULL_RSS_THROTTLE_KB;
        return;
    }

    private void updateFullDeltaRssThrottle() {
        this.mFullDeltaRssThrottleKb = DeviceConfig.getLong("activity_manager", KEY_COMPACT_FULL_DELTA_RSS_THROTTLE_KB, DEFAULT_COMPACT_FULL_DELTA_RSS_THROTTLE_KB);
        if (this.mFullDeltaRssThrottleKb >= 0) goto L6;
        this.mFullDeltaRssThrottleKb = DEFAULT_COMPACT_FULL_DELTA_RSS_THROTTLE_KB;
        return;
    }

    private void updateProcStateThrottle() {
        String procStateThrottleString = DeviceConfig.getString("activity_manager", KEY_COMPACT_PROC_STATE_THROTTLE, DEFAULT_COMPACT_PROC_STATE_THROTTLE);
        if (parseProcStateThrottle(procStateThrottleString) == true) goto L8;
        Slog.w("ActivityManager", "Unable to parse app compact proc state throttle \"" + procStateThrottleString + "\" falling back to default.");
        if (parseProcStateThrottle(DEFAULT_COMPACT_PROC_STATE_THROTTLE) == true) goto L9;
        Slog.wtf("ActivityManager", "Unable to parse default app compact proc state throttle " + DEFAULT_COMPACT_PROC_STATE_THROTTLE);
        return;
    L9:
        return;
    }

    private void updateMinOomAdjThrottle() {
        this.mCompactThrottleMinOomAdj = DeviceConfig.getLong("activity_manager", KEY_COMPACT_THROTTLE_MIN_OOM_ADJ, DEFAULT_COMPACT_THROTTLE_MIN_OOM_ADJ);
        if (this.mCompactThrottleMinOomAdj >= DEFAULT_COMPACT_THROTTLE_MIN_OOM_ADJ) goto L6;
        this.mCompactThrottleMinOomAdj = DEFAULT_COMPACT_THROTTLE_MIN_OOM_ADJ;
        return;
    }

    private void updateMaxOomAdjThrottle() {
        this.mCompactThrottleMaxOomAdj = DeviceConfig.getLong("activity_manager", KEY_COMPACT_THROTTLE_MAX_OOM_ADJ, DEFAULT_COMPACT_THROTTLE_MAX_OOM_ADJ);
        if (this.mCompactThrottleMaxOomAdj <= DEFAULT_COMPACT_THROTTLE_MAX_OOM_ADJ) goto L6;
        this.mCompactThrottleMaxOomAdj = DEFAULT_COMPACT_THROTTLE_MAX_OOM_ADJ;
        return;
    }

    private void updateFreezerDebounceTimeout() {
        this.mFreezerDebounceTimeout = DeviceConfig.getLong("activity_manager_native_boot", KEY_FREEZER_DEBOUNCE_TIMEOUT, JobStatus.DEFAULT_TRIGGER_UPDATE_DELAY);
        if (this.mFreezerDebounceTimeout >= 0) goto L5;
        this.mFreezerDebounceTimeout = JobStatus.DEFAULT_TRIGGER_UPDATE_DELAY;
    L5:
        Slog.d("ActivityManager", "Freezer timeout set to " + this.mFreezerDebounceTimeout);
    }

    private void updateFreezerExemptInstPkg() {
        this.mFreezerExemptInstPkg = DeviceConfig.getBoolean("activity_manager_native_boot", KEY_FREEZER_EXEMPT_INST_PKG, false);
        Slog.d("ActivityManager", "Freezer exemption set to " + this.mFreezerExemptInstPkg);
    }

    private void updateFreezerBinderState() {
        this.mFreezerBinderEnabled = DeviceConfig.getBoolean("activity_manager_native_boot", KEY_FREEZER_BINDER_ENABLED, true);
        this.mFreezerBinderDivisor = DeviceConfig.getLong("activity_manager_native_boot", KEY_FREEZER_BINDER_DIVISOR, 4);
        this.mFreezerBinderOffset = DeviceConfig.getInt("activity_manager_native_boot", KEY_FREEZER_BINDER_OFFSET, 500);
        this.mFreezerBinderThreshold = DeviceConfig.getLong("activity_manager_native_boot", KEY_FREEZER_BINDER_THRESHOLD, 1000);
        this.mFreezerBinderCallbackEnabled = DeviceConfig.getBoolean("activity_manager_native_boot", KEY_FREEZER_BINDER_CALLBACK_ENABLED, true);
        this.mFreezerBinderCallbackThrottle = DeviceConfig.getLong("activity_manager_native_boot", KEY_FREEZER_BINDER_CALLBACK_THROTTLE, JobStatus.DEFAULT_TRIGGER_UPDATE_DELAY);
        this.mFreezerBinderAsyncThreshold = DeviceConfig.getInt("activity_manager_native_boot", KEY_FREEZER_BINDER_ASYNC_THRESHOLD, 1024);
        Slog.d("ActivityManager", "Freezer binder state set to enabled=" + this.mFreezerBinderEnabled + ", divisor=" + this.mFreezerBinderDivisor + ", offset=" + this.mFreezerBinderOffset + ", threshold=" + this.mFreezerBinderThreshold + ", callback enabled=" + this.mFreezerBinderCallbackEnabled + ", callback throttle=" + this.mFreezerBinderCallbackThrottle + ", async threshold=" + this.mFreezerBinderAsyncThreshold);
    }

    private boolean parseProcStateThrottle(String procStateThrottleString) {
        String[] procStates = TextUtils.split(procStateThrottleString, ",");
        this.mProcStateThrottle.clear();
        int r1 = procStates.length;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L10;
        String procState = procStates[r3];
        this.mProcStateThrottle.add(Integer.valueOf(Integer.parseInt(procState)));     // Catch: NumberFormatException -> L7
        r3 = r3 + 1;
    L8:
        Slog.e("ActivityManager", "Failed to parse default app compaction proc state: " + procState);
        return false;
    L10:
        return true;
    }

    private long updateEarliestFreezableTime(ProcessRecord app, long delayMillis) {
        long now = SystemClock.uptimeMillis();
        app.mOptRecord.setEarliestFreezableTime(Math.max(app.mOptRecord.getEarliestFreezableTime(), now + delayMillis));
        return app.mOptRecord.getEarliestFreezableTime() - now;
    }

    void unfreezeTemporarily(ProcessRecord app, int reason) {
        unfreezeTemporarily(app, reason, this.mFreezerDebounceTimeout);
    }

    void unfreezeTemporarily(ProcessRecord app, int reason, long delayMillis) {
        if (this.mUseFreezer == false) goto L19;
        ActivityManagerGlobalLock r0 = this.mProcLock;
        ActivityManagerService.boostPriorityForProcLockedSection();
        monitor-enter(r0);
        long delay = updateEarliestFreezableTime(app, delayMillis);     // Catch: Throwable -> L11
        if (app.mOptRecord.isFrozen() == true) goto L13;
        if (app.mOptRecord.isPendingFreeze() == true) goto L13;
    L14:
        monitor-exit(r0);     // Catch: Throwable -> L11
        ActivityManagerService.resetPriorityAfterProcLockedSection();
        return;
    L13:
        unfreezeAppLSP(app, reason);     // Catch: Throwable -> L11
        freezeAppAsyncLSP(app, delay);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        ActivityManagerService.resetPriorityAfterProcLockedSection();
        throw th;
    }

    void freezeAppAsyncLSP(ProcessRecord app) {
        freezeAppAsyncLSP(app, updateEarliestFreezableTime(app, this.mFreezerDebounceTimeout));
    }

    void forceFreezeAppAsyncLSP(ProcessRecord app) {
        freezeAppAsyncInternalLSP(app, 0, true);
    }

    private void freezeAppAsyncLSP(ProcessRecord app, long delayMillis) {
        freezeAppAsyncInternalLSP(app, delayMillis, false);
    }

    void freezeAppAsyncAtEarliestLSP(ProcessRecord app) {
        freezeAppAsyncLSP(app, updateEarliestFreezableTime(app, 0));
    }

    void freezeAppAsyncImmediateLSP(ProcessRecord app) {
        freezeAppAsyncInternalLSP(app, 0, false);
    }

    private void freezeAppAsyncInternalLSP(ProcessRecord app, long delayMillis, boolean force) {
        ProcessCachedOptimizerRecord opt = app.mOptRecord;
        if (opt.isPendingFreeze() == false) goto L9;
        if (delayMillis != 0) goto L29;
        this.mFreezeHandler.removeMessages(3, app);
        this.mFreezeHandler.sendMessage(this.mFreezeHandler.obtainMessage(3, 1, 0, app));
        return;
    L29:
        return;
    L9:
        if (opt.isFreezeSticky() == false) goto L16;
        if (force == true) goto L16;
        if (ActivityManagerDebugConfig.DEBUG_FREEZER == false) goto L30;
        Slog.d("ActivityManager", "Skip freezing because unfrozen state is sticky pid=" + app.getPid() + " " + app.processName);
        return;
    L30:
        return;
    L16:
        if (app.mState.getSetAdj() < 900) goto L23;
        IApplicationThread thread = app.getThread();
        if (thread == null) goto L23;
        thread.scheduleTrimMemory(40);     // Catch: RemoteException -> L22
    L23:
        reportProcessFreezableChangedLocked(app);
        app.mOptRecord.setLastUsedTimeout(delayMillis);
        this.mFreezeHandler.sendMessageDelayed(this.mFreezeHandler.obtainMessage(3, 1, 0, app), delayMillis);
        opt.setPendingFreeze(true);
        if (ActivityManagerDebugConfig.DEBUG_FREEZER == false) goto L31;
        Slog.d("ActivityManager", "Async freezing " + app.getPid() + " " + app.processName);
        return;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private boolean unfreezeAppInternalLSP(ProcessRecord r21, int r22, boolean r23) {
        int r4 = r21.getPid();
        ProcessCachedOptimizerRecord r5 = r21.mOptRecord;
        if (r5.isFreezeSticky() == false) goto L10;
        if (r23 == true) goto L10;
        if (ActivityManagerDebugConfig.DEBUG_FREEZER == false) goto L8;
        Slog.d("ActivityManager", "Skip unfreezing because frozen state is sticky pid=" + r4 + " " + r21.processName);
    L8:
        return false;
    L10:
        if (r5.isPendingFreeze() == false) goto L15;
        this.mFreezeHandler.removeMessages(3, r21);
        r5.setPendingFreeze(false);
        reportProcessFreezableChangedLocked(r21);
        if (ActivityManagerDebugConfig.DEBUG_FREEZER == false) goto L14;
        Slog.d("ActivityManager", "Cancel freezing " + r4 + " " + r21.processName);
    L14:
        boolean r10 = true;
    L16:
        UidRecord r11 = r21.getUidRecord();
        if (r11 != null) goto L19;
    L21:
        r5.setFreezerOverride(false);
        if (r4 == 0) goto L73;
        if (r5.isFrozen() == false) goto L86;
        boolean r12 = false;
        int r0 = this.mFreezer.getBinderFreezeInfo(r4);     // Catch: Exception -> L45
        boolean r17 = false;
        if ((r0 & 1) == 0) goto L40;
        Slog.d("ActivityManager", "pid " + r4 + " " + r21.processName + " received sync transactions while frozen, killing");     // Catch: Exception -> L35
        r21.killLocked("Sync transaction while in frozen state", 14, 20, true);     // Catch: Exception -> L33
        r12 = true;
    L33:
        e = e;
    L47:
        Slog.d("ActivityManager", "Unable to query binder frozen info for pid " + r4 + " " + r21.processName + ". Killing it. Exception: " + e);
        r21.killLocked("Unable to query binder frozen stats", 14, 19, true);
        r12 = true;
    L48:
        if (r12 == false) goto L50;
        return r17;
    L50:
        if (r10 == true) goto L52;
        reportProcessFreezableChangedLocked(r21);
    L52:
        long r13 = r5.getFreezeUnfreezeTime();
        boolean r6 = r17;
        this.mFreezer.freezeBinder(r4, r6, r6 ? 1 : 0);     // Catch: RuntimeException -> L69
        traceAppFreeze(r21.processName, r4, r22);     // Catch: Exception -> L60
        this.mFreezer.setProcessFrozen(r4, r21.uid, false);     // Catch: Exception -> L60
        boolean r7 = r10;
        r5.setFreezeUnfreezeTime(SystemClock.uptimeMillis());     // Catch: Exception -> L58
        r5.setFrozen(false);     // Catch: Exception -> L58
        this.mFrozenProcesses.delete(r4);     // Catch: Exception -> L58
        boolean r8 = r7;
    L64:
        if (r5.isFrozen() == true) goto L67;
        Slog.d("ActivityManager", "sync unfroze " + r4 + " " + r21.processName + " for " + r22);
        this.mFreezeHandler.sendMessage(this.mFreezeHandler.obtainMessage(4, r4, (int) Math.min(r5.getFreezeUnfreezeTime() - r13, 2147483647L), new Pair(r21, Integer.valueOf(r22))));
        return true;
    L67:
        return false;
    L62:
        Slog.e("ActivityManager", "Unable to unfreeze " + r4 + " " + r21.processName + ". This might cause inconsistency or UI hangs.");
        r8 = r7;
    L61:
        r7 = r10;
    L70:
        Slog.e("ActivityManager", "Unable to unfreeze binder for " + r4 + " " + r21.processName + ". Killing it");
        r21.killLocked("Unable to unfreeze", 14, 19, true);
        return false;
    L35:
        e = e;
    L40:
        if ((r0 & 2) == 0) goto L48;
        if (ActivityManagerDebugConfig.DEBUG_FREEZER == false) goto L48;
        Slog.d("ActivityManager", "pid " + r4 + " " + r21.processName + " received async transactions while frozen");     // Catch: Exception -> L33
    L45:
        e = e;
        r17 = false;
        goto L47
    L86:
        return false;
    L73:
        return false;
    L19:
        if (r11.isFrozen() == false) goto L21;
        r11.setFrozen(false);
        postUidFrozenMessage(r11.getUid(), false);
        goto L21
    L15:
        r10 = false;
        goto L16
    }

    void unfreezeAppLSP(ProcessRecord app, int reason, boolean force) {
        Object r0 = this.mFreezerLock;
        monitor-enter(r0);
        boolean shouldDispatch = unfreezeAppInternalLSP(app, reason, force);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        if (shouldDispatch == false) goto L14;
        app.mOptRecord.dispatchUnfrozenEvent();
        return;
    L14:
        return;
    L9:
        th = move-exception;
        throw th;
    }

    void unfreezeAppLSP(ProcessRecord app, int reason) {
        unfreezeAppLSP(app, reason, false);
    }

    void unfreezeProcess(int pid, int reason) {
        Object r0 = this.mFreezerLock;
        monitor-enter(r0);
        ProcessRecord app = this.mFrozenProcesses.get(pid);     // Catch: Throwable -> L8
        if (app != null) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        Slog.d("ActivityManager", "quick sync unfreeze " + pid + " for " + reason);     // Catch: Throwable -> L8
        this.mFreezer.freezeBinder(pid, false, 0);     // Catch: Throwable -> L8 RuntimeException -> L19
        goto L20
    L27:
        traceAppFreeze(app.processName, pid, reason);     // Catch: Throwable -> L8 Exception -> L14
        this.mFreezer.setProcessFrozen(pid, app.uid, false);     // Catch: Throwable -> L8 Exception -> L14
    L16:
        monitor-exit(r0);     // Catch: Throwable -> L8
        app.mOptRecord.dispatchUnfrozenEvent();
        return;
    L15:
        Slog.e("ActivityManager", "Unable to quick unfreeze " + pid);     // Catch: Throwable -> L8
    L20:
        Slog.e("ActivityManager", "Unable to quick unfreeze binder for " + pid);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    private static void traceAppFreeze(String processName, int pid, int reason) {
        StringBuilder r0 = new StringBuilder();
        if (reason >= 0) goto L5;
        String r1 = "Freeze ";
    L6:
        r0.append(r1);
        r0.append(processName);
        r0.append(":");
        r0.append(pid);
        r0.append(" ");
        r0.append(reason);
        Trace.instantForTrack(64, ATRACE_FREEZER_TRACK, r0.toString());
        return;
    L5:
        r1 = "Unfreeze ";
        goto L6
    }

    void onCleanupApplicationRecordLocked(ProcessRecord app) {
        if (this.mUseFreezer == false) goto L20;
        ProcessCachedOptimizerRecord opt = app.mOptRecord;
        boolean isFrozen = false;
        if (opt.isPendingFreeze() == false) goto L7;
        this.mFreezeHandler.removeMessages(3, app);
        opt.setPendingFreeze(false);
    L7:
        UidRecord uidRec = app.getUidRecord();
        if (uidRec != null) goto L10;
    L18:
        this.mFrozenProcesses.delete(app.getPid());
        return;
    L10:
        if (uidRec.getNumOfProcs() <= 1) goto L16;
        if (uidRec.areAllProcessesFrozen(app) == false) goto L16;
        isFrozen = true;
    L16:
        if (isFrozen == uidRec.isFrozen()) goto L18;
        uidRec.setFrozen(isFrozen);
        postUidFrozenMessage(uidRec.getUid(), isFrozen);
        goto L18
    }

    void onWakefulnessChanged(int wakefulness) {
        if (wakefulness == 1) goto L5;
        return;
    L5:
        if (useCompaction() == false) goto L9;
        cancelAllCompactions(CancelCompactReason.SCREEN_ON);
        return;
    }

    void cancelAllCompactions(CancelCompactReason reason) {
        ActivityManagerGlobalLock r0 = this.mProcLock;
        ActivityManagerService.boostPriorityForProcLockedSection();
        monitor-enter(r0);
    L19:
    L9:
        th = move-exception;
        ActivityManagerService.resetPriorityAfterProcLockedSection();
        throw th;
    L5:
        if (this.mPendingCompactionProcesses.isEmpty() == true) goto L12;
        if (ActivityManagerDebugConfig.DEBUG_COMPACTION == false) goto L11;
        Slog.e("ActivityManager", "Cancel pending compaction as system is awake for process=" + this.mPendingCompactionProcesses.get(0).processName);     // Catch: Throwable -> L9
    L11:
        cancelCompactionForProcess(this.mPendingCompactionProcesses.get(0), reason);     // Catch: Throwable -> L9
        goto L19
    L12:
        this.mPendingCompactionProcesses.clear();     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        ActivityManagerService.resetPriorityAfterProcLockedSection();
    }

    void cancelCompactionForProcess(ProcessRecord app, CancelCompactReason cancelReason) {
        boolean cancelled = false;
        if (this.mPendingCompactionProcesses.contains(app) == false) goto L6;
        app.mOptRecord.setHasPendingCompact(false);
        this.mPendingCompactionProcesses.remove(app);
        cancelled = true;
    L6:
        if (DefaultProcessDependencies.mPidCompacting != app.mPid) goto L8;
        cancelCompaction();
        cancelled = true;
    L8:
        if (cancelled == false) goto L17;
        this.mCompactStatsManager.logCompactionCancelled(cancelReason);
        if (this.mDebugCompaction == true) goto L12;
        return;
    L12:
        if (("Cancelled pending or running compactions for process: " + app.processName) == null) goto L14;
        String r1 = app.processName;
    L15:
        Slog.d("ActivityManager", r1);
        return;
    L14:
        r1 = " reason: " + cancelReason.name();
        goto L15
    }

    void onOomAdjustChanged(int oldAdj, int newAdj, ProcessRecord app) {
        if (useCompaction() == false) goto L9;
        if (newAdj < oldAdj) goto L6;
        return;
    L6:
        if (newAdj >= 900) goto L11;
        cancelCompactionForProcess(app, CancelCompactReason.OOM_IMPROVEMENT);
        return;
    L11:
        return;
    }

    void onProcessFrozen(ProcessRecord frozenProc) {
        if (useCompaction() == false) goto L16;
        ActivityManagerGlobalLock r0 = this.mProcLock;
        ActivityManagerService.boostPriorityForProcLockedSection();
        monitor-enter(r0);
    L9:
        th = move-exception;
        ActivityManagerService.resetPriorityAfterProcLockedSection();
        throw th;
    L7:
        if (frozenProc.mState.getSetAdj() < this.mCompactThrottleMinOomAdj) goto L11;
        compactApp(frozenProc, CompactProfile.FULL, CompactSource.APP, false);     // Catch: Throwable -> L9
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L9
        ActivityManagerService.resetPriorityAfterProcLockedSection();
    L16:
        frozenProc.onProcessFrozen();
    }

    void onProcessFrozenCancelled(ProcessRecord app) {
        app.onProcessFrozenCancelled();
    }

    CompactProfile resolveCompactionProfile(CompactProfile profile) {
        if (profile != CompactProfile.FULL) goto L10;
        double swapFreePercent = getFreeSwapPercent();
        if (swapFreePercent >= COMPACT_DOWNGRADE_FREE_SWAP_THRESHOLD) goto L10;
        profile = CompactProfile.SOME;
        this.mCompactStatsManager.logCompactionDowngrade();
        if (this.mDebugCompaction == false) goto L10;
        Slog.d("ActivityManager", "Downgraded compaction to " + profile + " due to low swap. Swap Free% " + swapFreePercent);
    L10:
        if (profile != CompactProfile.SOME) goto L13;
        profile = CompactProfile.NONE;
    L16:
        if (ActivityManagerDebugConfig.DEBUG_COMPACTION == false) goto L18;
        Slog.d("ActivityManager", "Final compaction profile " + profile + " due to file compact disabled");
    L18:
        return profile;
    L13:
        if (profile != CompactProfile.FULL) goto L16;
        profile = CompactProfile.ANON;
        goto L16
    }

    boolean isProcessFrozen(int pid) {
        ActivityManagerGlobalLock r0 = this.mProcLock;
        ActivityManagerService.boostPriorityForProcLockedSection();
        monitor-enter(r0);
        boolean r1 = this.mFrozenProcesses.contains(pid);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        ActivityManagerService.resetPriorityAfterProcLockedSection();
        return r1;
    L8:
        th = move-exception;
        ActivityManagerService.resetPriorityAfterProcLockedSection();
        throw th;
    }

    private void reportOneUidFrozenStateChanged(int uid, boolean frozen) {
        int r0 = 1;
        int[] frozenStates = new int[1];
        int[] uids = {uid};
        if (frozen == true) goto L6;
        r0 = 2;
    L6:
        frozenStates[0] = r0;
        if (ActivityManagerDebugConfig.DEBUG_FREEZER == false) goto L9;
        Slog.d("ActivityManager", "reportOneUidFrozenStateChanged uid " + uid + " frozen = " + frozen);
    L9:
        this.mAm.reportUidFrozenStateChanged(uids, frozenStates);
    }

    private void postUidFrozenMessage(int r7, boolean r8) {
        Integer r0 = Integer.valueOf(r7);
        this.mFreezeHandler.removeEqualMessages(6, r0);
        this.mFreezeHandler.sendMessage(this.mFreezeHandler.obtainMessage(6, r8 ? 1 : 0, 0, r0));
    }

    private void reportProcessFreezableChangedLocked(ProcessRecord app) {
        this.mAm.onProcessFreezableChangedLocked(app);
    }

    static int getUnfreezeReasonCodeFromOomAdjReason(int oomAdjReason) {
        switch(oomAdjReason) {
            case 1: goto L51;
            case 2: goto L49;
            case 3: goto L47;
            case 4: goto L45;
            case 5: goto L43;
            case 6: goto L41;
            case 7: goto L39;
            case 8: goto L37;
            case 9: goto L35;
            case 10: goto L33;
            case 11: goto L31;
            case 12: goto L29;
            case 13: goto L27;
            case 14: goto L25;
            case 15: goto L23;
            case 16: goto L21;
            case 17: goto L19;
            case 18: goto L17;
            case 19: goto L15;
            case 20: goto L13;
            case 21: goto L11;
            case 22: goto L9;
            case 23: goto L7;
            case 24: goto L5;
            default: goto L3;
        };
    L3:
        return 0;
    L5:
        return 31;
    L7:
        return 30;
    L9:
        return 29;
    L11:
        return 28;
    L13:
        return 27;
    L15:
        return 26;
    L17:
        return 25;
    L19:
        return 24;
    L21:
        return 23;
    L23:
        return 22;
    L25:
        return 21;
    L27:
        return 20;
    L29:
        return 12;
    L31:
        return 11;
    L33:
        return 10;
    L35:
        return 9;
    L37:
        return 8;
    L39:
        return 7;
    L41:
        return 6;
    L43:
        return 5;
    L45:
        return 4;
    L47:
        return 3;
    L49:
        return 2;
    L51:
        return 1;
    }

    public void killProcess(final int pid, final String reason, final int reasonCode, final int subReason) {
        this.mAm.mHandler.post(new CachedAppOptimizer$$ExternalSyntheticLambda0(this, pid, reason, reasonCode, subReason));
    }

    private /* synthetic */ void lambda$killProcess$2(int pid, String reason, int reasonCode, int subReason) {
        ActivityManagerService r0 = this.mAm;
        ActivityManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
        ActivityManagerGlobalLock r1 = this.mProcLock;     // Catch: Throwable -> L20
        ActivityManagerService.boostPriorityForProcLockedSection();     // Catch: Throwable -> L20
        monitor-enter(r1);     // Catch: Throwable -> L20
        ProcessRecord proc = this.mFrozenProcesses.get(pid);     // Catch: Throwable -> L13
        if (proc != null) goto L9;
    L15:
        monitor-exit(r1);     // Catch: Throwable -> L13
        ActivityManagerService.resetPriorityAfterProcLockedSection();     // Catch: Throwable -> L20
        monitor-exit(r0);     // Catch: Throwable -> L20
        ActivityManagerService.resetPriorityAfterLockedSection();
        return;
    L9:
        if (proc.getThread() == null) goto L15;
        if (proc.isKilledByAm() == true) goto L15;
        proc.killLocked(reason, reasonCode, subReason, true);     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        ActivityManagerService.resetPriorityAfterProcLockedSection();     // Catch: Throwable -> L20
        throw th;     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        ActivityManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    void forceFreezeForTest(ProcessRecord proc, boolean freeze) {
        ActivityManagerService r0 = this.mAm;
        ActivityManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
        ActivityManagerGlobalLock r1 = this.mProcLock;     // Catch: Throwable -> L16
        ActivityManagerService.boostPriorityForProcLockedSection();     // Catch: Throwable -> L16
        monitor-enter(r1);     // Catch: Throwable -> L16
        if (freeze == false) goto L10;
        forceFreezeAppAsyncLSP(proc);     // Catch: Throwable -> L8
    L11:
        monitor-exit(r1);     // Catch: Throwable -> L8
        ActivityManagerService.resetPriorityAfterProcLockedSection();     // Catch: Throwable -> L16
        monitor-exit(r0);     // Catch: Throwable -> L16
        ActivityManagerService.resetPriorityAfterLockedSection();
        return;
    L10:
        unfreezeAppLSP(proc, 0, true);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        ActivityManagerService.resetPriorityAfterProcLockedSection();     // Catch: Throwable -> L16
        throw th;     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        ActivityManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    public void binderError(int debugPid, ProcessRecord app, int code, int flags, int err) {
        if (ActivityManagerDebugConfig.DEBUG_FREEZER == false) goto L5;
    L8:
        StringBuilder r0 = new StringBuilder();
        r0.append("pid ");
        r0.append(debugPid);
        r0.append(" ");
        if (app != null) goto L11;
        String r2 = "null";
    L12:
        r0.append(r2);
        r0.append(" sent binder code ");
        r0.append(code);
        r0.append(" with flags ");
        r0.append(flags);
        r0.append(" to frozen apps and got error ");
        r0.append(err);
        Slog.w("ActivityManager", r0.toString());
    L14:
        if (this.mUseFreezer == true) goto L16;
        return;
    L16:
        if (this.mFreezerBinderCallbackEnabled == false) goto L25;
        long now = SystemClock.uptimeMillis();
        if (now >= (this.mFreezerBinderCallbackLast + this.mFreezerBinderCallbackThrottle)) goto L22;
        Slog.d("ActivityManager", "Too many transaction errors, throttling freezer binder callback.");
        return;
    L22:
        this.mFreezerBinderCallbackLast = now;
        this.mFreezeHandler.sendEmptyMessage(8);
        return;
    L25:
        return;
    L11:
        r2 = app.processName;
        goto L12
    L5:
        if (this.mUseFreezer == false) goto L14;
        if (this.mFreezerBinderCallbackEnabled == false) goto L14;
        goto L8
    }

    private void binderErrorInternal(IntArray pids) {
        if (this.mFreezerBinderAsyncThreshold >= 0) goto L5;
        final ArraySet<Integer> pidsAsync = null;
    L6:
        Trace.traceBegin(64, "binderErrorSync");
        int i = 0;
    L8:
        if (i >= pids.size()) goto L25;
        int current = pids.get(i);
        int freezeInfo = this.mFreezer.getBinderFreezeInfo(current);     // Catch: Exception -> L13
        if ((freezeInfo & 1) == 0) goto L16;
        killProcess(current, "Sync transaction while frozen", 14, 20);     // Catch: Exception -> L13
    L24:
        i = i + 1;
        goto L8
    L16:
        if ((freezeInfo & 2) == 0) goto L24;
        if (pidsAsync == null) goto L20;
        pidsAsync.add(Integer.valueOf(current));     // Catch: Exception -> L13
    L20:
        if (ActivityManagerDebugConfig.DEBUG_FREEZER == false) goto L24;
        Slog.w("ActivityManager", "pid " + current + " received async transactions while frozen");     // Catch: Exception -> L13
    L23:
        Slog.w("ActivityManager", "Unable to query binder frozen stats for pid " + current);
        goto L24
    L25:
        Trace.traceEnd(64);
        if (pidsAsync != null) goto L28;
        return;
    L28:
        if (pidsAsync.size() == 0) goto L41;
        Trace.traceBegin(64, "binderErrorAsync");
        BinderfsStatsReader r0 = new BinderfsStatsReader();
        pidsAsync.getClass();
        r0.handleFreeAsyncSpace(new CachedAppOptimizer$$ExternalSyntheticLambda3(pidsAsync), new CachedAppOptimizer$$ExternalSyntheticLambda4(this), new CachedAppOptimizer$$ExternalSyntheticLambda5());
        Trace.traceEnd(64);
        return;
    L41:
        return;
    L5:
        pidsAsync = new ArraySet();
        goto L6
    }

    private /* synthetic */ void lambda$binderErrorInternal$3(Integer current, Integer free) {
        if (free.intValue() >= this.mFreezerBinderAsyncThreshold) goto L6;
        Slog.w("ActivityManager", "pid " + current + " has " + free + " free async space, killing");
        killProcess(current.intValue(), "Async binder space running out while frozen", 14, 31);
        return;
    }

    private static /* synthetic */ void lambda$binderErrorInternal$4(Exception exception) {
        Slog.e("ActivityManager", "Unable to parse binderfs stats");
    }

    public void addFrozenProcessListener(ProcessRecord app, Executor executor, ActivityManagerInternal.FrozenProcessListener listener) {
        app.mOptRecord.addFrozenProcessListener(executor, listener);
    }
}
