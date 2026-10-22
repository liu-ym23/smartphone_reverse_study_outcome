package com.android.server.job;

import android.R;
import android.app.ActivityManager;
import android.app.ActivityManagerInternal;
import android.app.BackgroundStartPrivileges;
import android.app.UserSwitchObserver;
import android.app.job.JobInfo;
import android.app.job.JobParameters;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.content.pm.UserInfo;
import android.os.Handler;
import android.os.Looper;
import android.os.PowerManager;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.os.UserHandle;
import android.provider.DeviceConfig;
import android.util.ArraySet;
import android.util.DataUnit;
import android.util.IndentingPrintWriter;
import android.util.Pair;
import android.util.Pools;
import android.util.Slog;
import android.util.SparseArrayMap;
import android.util.SparseIntArray;
import android.util.SparseLongArray;
import android.util.TimeUtils;
import android.util.proto.ProtoOutputStream;
import com.android.internal.app.IBatteryStats;
import com.android.internal.util.MemInfoReader;
import com.android.internal.util.jobs.StatLogger;
import com.android.modules.expresslog.Histogram;
import com.android.server.AppSchedulingModuleThread;
import com.android.server.LocalServices;
import com.android.server.job.controllers.JobStatus;
import com.android.server.job.controllers.StateController;
import com.android.server.job.restrictions.JobRestriction;
import com.android.server.pm.UserManagerInternal;
import com.android.server.slice.SliceClientPermissions;
import java.io.PrintWriter;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/* JADX INFO: loaded from: classes2.dex */
class JobConcurrencyManager {
    private static final int ALL_WORK_TYPES = 127;
    static final String CONFIG_KEY_PREFIX_CONCURRENCY = "concurrency_";
    private static final WorkConfigLimitsPerMemoryTrimLevel CONFIG_LIMITS_SCREEN_OFF = null;
    private static final WorkConfigLimitsPerMemoryTrimLevel CONFIG_LIMITS_SCREEN_ON = null;
    private static final boolean DEBUG = false;
    static final int DEFAULT_CONCURRENCY_LIMIT = 0;
    private static final boolean DEFAULT_ENABLE_MAX_WAIT_TIME_BYPASS = true;
    static final long DEFAULT_MAX_WAIT_EJ_MS = 300000;
    static final long DEFAULT_MAX_WAIT_REGULAR_MS = 1800000;
    static final long DEFAULT_MAX_WAIT_UI_MS = 300000;
    private static final int DEFAULT_PKG_CONCURRENCY_LIMIT_EJ = 3;
    private static final int DEFAULT_PKG_CONCURRENCY_LIMIT_REGULAR = 0;
    private static final long DEFAULT_SCREEN_OFF_ADJUSTMENT_DELAY_MS = 30000;
    private static final String KEY_CONCURRENCY_LIMIT = "concurrency_limit";
    static final String KEY_ENABLE_MAX_WAIT_TIME_BYPASS = "concurrency_enable_max_wait_time_bypass";
    private static final String KEY_MAX_WAIT_EJ_MS = "concurrency_max_wait_ej_ms";
    private static final String KEY_MAX_WAIT_REGULAR_MS = "concurrency_max_wait_regular_ms";
    static final String KEY_MAX_WAIT_UI_MS = "concurrency_max_wait_ui_ms";
    static final String KEY_PKG_CONCURRENCY_LIMIT_EJ = "concurrency_pkg_concurrency_limit_ej";
    static final String KEY_PKG_CONCURRENCY_LIMIT_REGULAR = "concurrency_pkg_concurrency_limit_regular";
    private static final String KEY_SCREEN_OFF_ADJUSTMENT_DELAY_MS = "concurrency_screen_off_adjustment_delay_ms";
    static final int MAX_CONCURRENCY_LIMIT = 64;
    private static final int MAX_RETAINED_OBJECTS = 96;
    static final int NUM_WORK_TYPES = 7;
    private static final int PRIVILEGED_STATE_BAL = 2;
    private static final int PRIVILEGED_STATE_NONE = 1;
    private static final int PRIVILEGED_STATE_TOP = 3;
    private static final int PRIVILEGED_STATE_UNDEFINED = 0;
    private static final int SYSTEM_STATE_REFRESH_MIN_INTERVAL = 1000;
    private static final String TAG = "JobScheduler.Concurrency";
    static final int WORK_TYPE_BG = 16;
    static final int WORK_TYPE_BGUSER = 64;
    static final int WORK_TYPE_BGUSER_IMPORTANT = 32;
    static final int WORK_TYPE_EJ = 8;
    static final int WORK_TYPE_FGS = 2;
    static final int WORK_TYPE_NONE = 0;
    static final int WORK_TYPE_TOP = 1;
    static final int WORK_TYPE_UI = 4;
    private static final Histogram sConcurrencyHistogramLogger = null;
    private static final Comparator<ContextAssignment> sDeterminationComparator = null;
    private final SparseArrayMap<String, PackageStats> mActivePkgStats;
    final List<JobServiceContext> mActiveServices;
    private final ActivityManagerInternal mActivityManagerInternal;
    private final Context mContext;
    private final Pools.Pool<ContextAssignment> mContextAssignmentPool;
    private boolean mCurrentInteractiveState;
    private boolean mEffectiveInteractiveState;
    GracePeriodObserver mGracePeriodObserver;
    private final Handler mHandler;
    private final ArraySet<JobServiceContext> mIdleContexts;
    private final Injector mInjector;
    private int mLastMemoryTrimLevel;
    private long mLastScreenOffRealtime;
    private long mLastScreenOnRealtime;
    private final Object mLock;
    private long mMaxWaitEjMs;
    private long mMaxWaitRegularMs;
    private boolean mMaxWaitTimeBypassEnabled;
    private long mMaxWaitUIMs;
    private long mNextSystemStateRefreshTime;
    private final JobNotificationCoordinator mNotificationCoordinator;
    private int mNumDroppedContexts;
    private final Consumer<PackageStats> mPackageStatsStagingCountClearer;
    private int mPkgConcurrencyLimitEj;
    private int mPkgConcurrencyLimitRegular;
    private final Pools.Pool<PackageStats> mPkgStatsPool;
    private PowerManager mPowerManager;
    private final Runnable mRampUpForScreenOff;
    private final BroadcastReceiver mReceiver;
    private final AssignmentInfo mRecycledAssignmentInfo;
    private final ArraySet<ContextAssignment> mRecycledChanged;
    private final ArraySet<ContextAssignment> mRecycledIdle;
    private final ArrayList<ContextAssignment> mRecycledPreferredUidOnly;
    private final SparseIntArray mRecycledPrivilegedState;
    private final ArrayList<ContextAssignment> mRecycledStoppable;
    private final ArraySet<JobStatus> mRunningJobs;
    private long mScreenOffAdjustmentDelayMs;
    private final JobSchedulerService mService;
    boolean mShouldRestrictBgUser;
    private final StatLogger mStatLogger;
    private int mSteadyStateConcurrencyLimit;
    private final UserManagerInternal mUserManagerInternal;
    private final WorkCountTracker mWorkCountTracker;
    private WorkTypeConfig mWorkTypeConfig;

    static final class AssignmentInfo {
        public long minPreferredUidOnlyWaitingTimeMs;
        public int numRunningEj;
        public int numRunningImmediacyPrivileged;
        public int numRunningReg;
        public int numRunningUi;

        AssignmentInfo() {
        }

        void clear() {
            this.minPreferredUidOnlyWaitingTimeMs = 0;
            this.numRunningImmediacyPrivileged = 0;
            this.numRunningUi = 0;
            this.numRunningEj = 0;
            this.numRunningReg = 0;
        }
    }

    static final class ContextAssignment {
        public JobServiceContext context;
        public JobStatus newJob;
        public int newWorkType;
        public String preemptReason;
        public int preemptReasonCode;
        public int preferredUid;
        public String shouldStopJobReason;
        public long timeUntilStoppableMs;
        public int workType;

        ContextAssignment() {
            this.preferredUid = -1;
            this.workType = 0;
            this.preemptReasonCode = 0;
            this.newWorkType = 0;
        }

        void clear() {
            this.context = null;
            this.preferredUid = -1;
            this.workType = 0;
            this.preemptReason = null;
            this.preemptReasonCode = 0;
            this.timeUntilStoppableMs = 0;
            this.shouldStopJobReason = null;
            this.newJob = null;
            this.newWorkType = 0;
        }
    }

    static class GracePeriodObserver extends UserSwitchObserver {
        private int mCurrentUserId;
        int mGracePeriod;
        final SparseLongArray mGracePeriodExpiration;
        final Object mLock;
        private final UserManagerInternal mUserManagerInternal;

        GracePeriodObserver(Context context) {
            this.mGracePeriodExpiration = new SparseLongArray();
            this.mLock = new Object();
            this.mCurrentUserId = ((ActivityManagerInternal) LocalServices.getService(ActivityManagerInternal.class)).getCurrentUserId();
            this.mUserManagerInternal = (UserManagerInternal) LocalServices.getService(UserManagerInternal.class);
            this.mGracePeriod = Math.max(0, context.getResources().getInteger(R.integer.config_lidNavigationAccessibility));
        }

        public void onUserSwitchComplete(int newUserId) {
            long expiration = JobSchedulerService.sElapsedRealtimeClock.millis() + ((long) this.mGracePeriod);
            Object r2 = this.mLock;
            monitor-enter(r2);
        L9:
            th = move-exception;
            throw th;
        L5:
            if (this.mCurrentUserId != (-10000)) goto L7;
        L11:
            this.mGracePeriodExpiration.delete(newUserId);     // Catch: Throwable -> L9
            this.mCurrentUserId = newUserId;     // Catch: Throwable -> L9
            monitor-exit(r2);     // Catch: Throwable -> L9
            return;
        L7:
            if (this.mUserManagerInternal.exists(this.mCurrentUserId) == false) goto L11;
            this.mGracePeriodExpiration.append(this.mCurrentUserId, expiration);     // Catch: Throwable -> L9
            goto L11
        }

        void onUserRemoved(int userId) {
            Object r0 = this.mLock;
            monitor-enter(r0);
            this.mGracePeriodExpiration.delete(userId);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        public boolean isWithinGracePeriodForUser(int userId) {
            Object r0 = this.mLock;
            monitor-enter(r0);
        L10:
            th = move-exception;
            throw th;
        L5:
            if (userId != this.mCurrentUserId) goto L7;
        L12:
            boolean r1 = true;
        L13:
            monitor-exit(r0);     // Catch: Throwable -> L10
            return r1;
        L7:
            if (JobSchedulerService.sElapsedRealtimeClock.millis() < this.mGracePeriodExpiration.get(userId, Long.MAX_VALUE)) goto L12;
            r1 = false;
            goto L13
        }
    }

    static class Injector {
        Injector() {
        }

        JobServiceContext createJobServiceContext(JobSchedulerService service, JobConcurrencyManager concurrencyManager, JobNotificationCoordinator notificationCoordinator, IBatteryStats batteryStats, JobPackageTracker tracker, Looper looper) {
            return new JobServiceContext(service, concurrencyManager, notificationCoordinator, batteryStats, tracker, looper);
        }
    }

    static class PackageStats {
        public int numRunningEj;
        public int numRunningRegular;
        public int numStagedEj;
        public int numStagedRegular;
        public String packageName;
        public int userId;

        /* JADX INFO: renamed from: -$$Nest$madjustRunningCount, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m4807$$Nest$madjustRunningCount(PackageStats r0, boolean r1, boolean r2) {
            r0.adjustRunningCount(r1, r2);
        }

        /* JADX INFO: renamed from: -$$Nest$madjustStagedCount, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m4808$$Nest$madjustStagedCount(PackageStats r0, boolean r1, boolean r2) {
            r0.adjustStagedCount(r1, r2);
        }

        /* JADX INFO: renamed from: -$$Nest$mdumpLocked, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m4809$$Nest$mdumpLocked(PackageStats r0, IndentingPrintWriter r1) {
            r0.dumpLocked(r1);
        }

        /* JADX INFO: renamed from: -$$Nest$mresetStagedCount, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m4810$$Nest$mresetStagedCount(PackageStats r0) {
            r0.resetStagedCount();
        }

        /* JADX INFO: renamed from: -$$Nest$msetPackage, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m4811$$Nest$msetPackage(PackageStats r0, int r1, String r2) {
            r0.setPackage(r1, r2);
        }

        PackageStats() {
        }

        private void setPackage(int userId, String packageName) {
            this.userId = userId;
            this.packageName = packageName;
            this.numRunningRegular = 0;
            this.numRunningEj = 0;
            resetStagedCount();
        }

        private void resetStagedCount() {
            this.numStagedRegular = 0;
            this.numStagedEj = 0;
        }

        private void adjustRunningCount(boolean add, boolean forEj) {
            int r0 = -1;
            if (forEj == false) goto L8;
            int r3 = this.numRunningEj;
            if (add == false) goto L7;
            r0 = 1;
        L7:
            this.numRunningEj = Math.max(0, r3 + r0);
            return;
        L8:
            int r4 = this.numRunningRegular;
            if (add == false) goto L11;
            r0 = 1;
        L11:
            this.numRunningRegular = Math.max(0, r4 + r0);
        }

        private void adjustStagedCount(boolean add, boolean forEj) {
            int r0 = -1;
            if (forEj == false) goto L8;
            int r3 = this.numStagedEj;
            if (add == false) goto L7;
            r0 = 1;
        L7:
            this.numStagedEj = Math.max(0, r3 + r0);
            return;
        L8:
            int r4 = this.numStagedRegular;
            if (add == false) goto L11;
            r0 = 1;
        L11:
            this.numStagedRegular = Math.max(0, r4 + r0);
        }

        private void dumpLocked(IndentingPrintWriter pw) {
            pw.print("PackageStats{");
            pw.print(this.userId);
            pw.print("-");
            pw.print(this.packageName);
            pw.print("#runEJ", Integer.valueOf(this.numRunningEj));
            pw.print("#runReg", Integer.valueOf(this.numRunningRegular));
            pw.print("#stagedEJ", Integer.valueOf(this.numStagedEj));
            pw.print("#stagedReg", Integer.valueOf(this.numStagedRegular));
            pw.println("}");
        }
    }

    interface Stats {
        public static final int ASSIGN_JOBS_TO_CONTEXTS = 0;
        public static final int COUNT = 2;
        public static final int REFRESH_SYSTEM_STATE = 1;
    }

    static class WorkConfigLimitsPerMemoryTrimLevel {
        public final WorkTypeConfig critical;
        public final WorkTypeConfig low;
        public final WorkTypeConfig moderate;
        public final WorkTypeConfig normal;

        WorkConfigLimitsPerMemoryTrimLevel(WorkTypeConfig normal, WorkTypeConfig moderate, WorkTypeConfig low, WorkTypeConfig critical) {
            this.normal = normal;
            this.moderate = moderate;
            this.low = low;
            this.critical = critical;
        }
    }

    static class WorkCountTracker {
        private final SparseIntArray mConfigAbsoluteMaxSlots;
        private int mConfigMaxTotal;
        private final SparseIntArray mConfigNumReservedSlots;
        private final SparseIntArray mNumActuallyReservedSlots;
        private final SparseIntArray mNumPendingJobs;
        private final SparseIntArray mNumRunningJobs;
        private final SparseIntArray mNumStartingJobs;
        private int mNumUnspecializedRemaining;
        private final SparseIntArray mRecycledReserved;

        WorkCountTracker() {
            this.mConfigNumReservedSlots = new SparseIntArray(7);
            this.mConfigAbsoluteMaxSlots = new SparseIntArray(7);
            this.mRecycledReserved = new SparseIntArray(7);
            this.mNumActuallyReservedSlots = new SparseIntArray(7);
            this.mNumPendingJobs = new SparseIntArray(7);
            this.mNumRunningJobs = new SparseIntArray(7);
            this.mNumStartingJobs = new SparseIntArray(7);
            this.mNumUnspecializedRemaining = 0;
        }

        void setConfig(WorkTypeConfig workTypeConfig) {
            this.mConfigMaxTotal = workTypeConfig.getMaxTotal();
            int workType = 1;
        L4:
            if (workType >= 127) goto L6;
            this.mConfigNumReservedSlots.put(workType, workTypeConfig.getMinReserved(workType));
            this.mConfigAbsoluteMaxSlots.put(workType, workTypeConfig.getMax(workType));
            workType = workType << 1;
            goto L4
        L6:
            int workType2 = this.mConfigMaxTotal;
            this.mNumUnspecializedRemaining = workType2;
            int i = this.mNumRunningJobs.size() - 1;
        L7:
            if (i < 0) goto L10;
            this.mNumUnspecializedRemaining -= Math.max(this.mNumRunningJobs.valueAt(i), this.mConfigNumReservedSlots.get(this.mNumRunningJobs.keyAt(i)));
            i = i - 1;
            goto L7
        }

        void resetCounts() {
            this.mNumActuallyReservedSlots.clear();
            this.mNumPendingJobs.clear();
            this.mNumRunningJobs.clear();
            resetStagingCount();
        }

        void resetStagingCount() {
            this.mNumStartingJobs.clear();
        }

        void incrementRunningJobCount(int workType) {
            this.mNumRunningJobs.put(workType, this.mNumRunningJobs.get(workType) + 1);
        }

        void incrementPendingJobCount(int workTypes) {
            adjustPendingJobCount(workTypes, true);
        }

        void decrementPendingJobCount(int workTypes) {
            if (adjustPendingJobCount(workTypes, false) <= 1) goto L10;
            int workType = 1;
        L5:
            if (workType > workTypes) goto L14;
            if ((workType & workTypes) != workType) goto L9;
            maybeAdjustReservations(workType);
        L9:
            workType = workType << 1;
            goto L5
        L14:
            return;
        }

        private int adjustPendingJobCount(int workTypes, boolean add) {
            if (add == false) goto L4;
            int adj = 1;
        L5:
            int numAdj = 0;
            int workType = 1;
        L6:
            if (workType > workTypes) goto L12;
            if ((workTypes & workType) != workType) goto L10;
            this.mNumPendingJobs.put(workType, this.mNumPendingJobs.get(workType) + adj);
            numAdj = numAdj + 1;
        L10:
            workType = workType << 1;
            goto L6
        L12:
            return numAdj;
        L4:
            adj = -1;
            goto L5
        }

        void stageJob(int workType, int allWorkTypes) {
            int newNumStartingJobs = this.mNumStartingJobs.get(workType) + 1;
            this.mNumStartingJobs.put(workType, newNumStartingJobs);
            decrementPendingJobCount(allWorkTypes);
            if ((this.mNumRunningJobs.get(workType) + newNumStartingJobs) <= this.mNumActuallyReservedSlots.get(workType)) goto L6;
            this.mNumUnspecializedRemaining--;
            return;
        }

        void onStagedJobFailed(int workType) {
            int oldNumStartingJobs = this.mNumStartingJobs.get(workType);
            if (oldNumStartingJobs != 0) goto L6;
            Slog.e(JobConcurrencyManager.TAG, "# staged jobs for " + workType + " went negative.");
            return;
        L6:
            this.mNumStartingJobs.put(workType, oldNumStartingJobs - 1);
            maybeAdjustReservations(workType);
        }

        private void maybeAdjustReservations(int workType) {
            int numRemainingForType = Math.max(this.mConfigNumReservedSlots.get(workType), (this.mNumRunningJobs.get(workType) + this.mNumStartingJobs.get(workType)) + this.mNumPendingJobs.get(workType));
            if (numRemainingForType >= this.mNumActuallyReservedSlots.get(workType)) goto L26;
            this.mNumActuallyReservedSlots.put(workType, numRemainingForType);
            int assignWorkType = 0;
            int i = 0;
        L6:
            if (i >= this.mNumActuallyReservedSlots.size()) goto L17;
            int wt = this.mNumActuallyReservedSlots.keyAt(i);
            if (assignWorkType == 0) goto L10;
            if (wt < assignWorkType) goto L10;
        L15:
            i = i + 1;
        L10:
            int total = (this.mNumRunningJobs.get(wt) + this.mNumStartingJobs.get(wt)) + this.mNumPendingJobs.get(wt);
            if (this.mNumActuallyReservedSlots.valueAt(i) >= this.mConfigAbsoluteMaxSlots.get(wt)) goto L15;
            if (total <= this.mNumActuallyReservedSlots.valueAt(i)) goto L15;
            assignWorkType = wt;
            goto L15
        L17:
            if (assignWorkType == 0) goto L19;
            this.mNumActuallyReservedSlots.put(assignWorkType, this.mNumActuallyReservedSlots.get(assignWorkType) + 1);
            return;
        L19:
            this.mNumUnspecializedRemaining++;
            return;
        }

        void onJobStarted(int workType) {
            this.mNumRunningJobs.put(workType, this.mNumRunningJobs.get(workType) + 1);
            int oldNumStartingJobs = this.mNumStartingJobs.get(workType);
            if (oldNumStartingJobs != 0) goto L5;
            Slog.e(JobConcurrencyManager.TAG, "# stated jobs for " + workType + " went negative.");
            return;
        L5:
            this.mNumStartingJobs.put(workType, oldNumStartingJobs - 1);
        }

        void onJobFinished(int workType) {
            int newNumRunningJobs = this.mNumRunningJobs.get(workType) - 1;
            if (newNumRunningJobs >= 0) goto L6;
            Slog.e(JobConcurrencyManager.TAG, "# running jobs for " + workType + " went negative.");
            return;
        L6:
            this.mNumRunningJobs.put(workType, newNumRunningJobs);
            maybeAdjustReservations(workType);
        }

        void onCountDone() {
            this.mNumUnspecializedRemaining = this.mConfigMaxTotal;
            int workType = 1;
        L4:
            if (workType >= 127) goto L6;
            int run = this.mNumRunningJobs.get(workType);
            this.mRecycledReserved.put(workType, run);
            this.mNumUnspecializedRemaining -= run;
            workType = workType << 1;
            goto L4
        L6:
            int workType2 = 1;
        L8:
            if (workType2 >= 127) goto L10;
            int num = this.mNumRunningJobs.get(workType2) + this.mNumPendingJobs.get(workType2);
            int res = this.mRecycledReserved.get(workType2);
            int fillUp = Math.max(0, Math.min(this.mNumUnspecializedRemaining, Math.min(num, this.mConfigNumReservedSlots.get(workType2) - res)));
            this.mRecycledReserved.put(workType2, res + fillUp);
            this.mNumUnspecializedRemaining -= fillUp;
            workType2 = workType2 << 1;
            goto L8
        L10:
            int workType3 = 1;
        L11:
            if (workType3 >= 127) goto L14;
            int num2 = this.mNumRunningJobs.get(workType3) + this.mNumPendingJobs.get(workType3);
            int res2 = this.mRecycledReserved.get(workType3);
            int unspecializedAssigned = Math.max(0, Math.min(this.mNumUnspecializedRemaining, Math.min(this.mConfigAbsoluteMaxSlots.get(workType3), num2) - res2));
            this.mNumActuallyReservedSlots.put(workType3, res2 + unspecializedAssigned);
            this.mNumUnspecializedRemaining -= unspecializedAssigned;
            workType3 = workType3 << 1;
            goto L11
        }

        int canJobStart(int workTypes) {
            int workType = 1;
        L3:
            if (workType > workTypes) goto L10;
            if ((workTypes & workType) != workType) goto L9;
            int maxAllowed = Math.min(this.mConfigAbsoluteMaxSlots.get(workType), this.mNumActuallyReservedSlots.get(workType) + this.mNumUnspecializedRemaining);
            if ((this.mNumRunningJobs.get(workType) + this.mNumStartingJobs.get(workType)) >= maxAllowed) goto L9;
            return workType;
        L9:
            workType = workType << 1;
            goto L3
        L10:
            return 0;
        }

        int canJobStart(int workTypes, int replacingWorkType) {
            int oldNumRunning = this.mNumRunningJobs.get(replacingWorkType);
            if (replacingWorkType == 0) goto L6;
            if (oldNumRunning <= 0) goto L6;
            this.mNumRunningJobs.put(replacingWorkType, oldNumRunning - 1);
            this.mNumUnspecializedRemaining++;
            boolean changedNums = true;
        L7:
            int ret = canJobStart(workTypes);
            if (changedNums == false) goto L10;
            this.mNumRunningJobs.put(replacingWorkType, oldNumRunning);
            this.mNumUnspecializedRemaining--;
        L10:
            return ret;
        L6:
            changedNums = false;
            goto L7
        }

        int getPendingJobCount(int workType) {
            return this.mNumPendingJobs.get(workType, 0);
        }

        int getRunningJobCount(int workType) {
            return this.mNumRunningJobs.get(workType, 0);
        }

        boolean isOverTypeLimit(int workType) {
            if (getRunningJobCount(workType) <= this.mConfigAbsoluteMaxSlots.get(workType)) goto L5;
            return true;
        L5:
            return false;
        }

        public String toString() {
            return "Config={tot=" + this.mConfigMaxTotal + " mins=" + this.mConfigNumReservedSlots + " maxs=" + this.mConfigAbsoluteMaxSlots + "}, act res=" + this.mNumActuallyReservedSlots + ", Pending=" + this.mNumPendingJobs + ", Running=" + this.mNumRunningJobs + ", Staged=" + this.mNumStartingJobs + ", # unspecialized remaining=" + this.mNumUnspecializedRemaining;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface WorkType {
    }

    static class WorkTypeConfig {
        private static final String KEY_PREFIX_MAX = "concurrency_max_";
        static final String KEY_PREFIX_MAX_RATIO = "concurrency_max_ratio_";
        private static final String KEY_PREFIX_MAX_RATIO_BG = "concurrency_max_ratio_bg_";
        private static final String KEY_PREFIX_MAX_RATIO_BGUSER = "concurrency_max_ratio_bguser_";
        private static final String KEY_PREFIX_MAX_RATIO_BGUSER_IMPORTANT = "concurrency_max_ratio_bguser_important_";
        private static final String KEY_PREFIX_MAX_RATIO_EJ = "concurrency_max_ratio_ej_";
        private static final String KEY_PREFIX_MAX_RATIO_FGS = "concurrency_max_ratio_fgs_";
        private static final String KEY_PREFIX_MAX_RATIO_TOP = "concurrency_max_ratio_top_";
        private static final String KEY_PREFIX_MAX_RATIO_UI = "concurrency_max_ratio_ui_";
        static final String KEY_PREFIX_MAX_TOTAL = "concurrency_max_total_";
        private static final String KEY_PREFIX_MIN = "concurrency_min_";
        static final String KEY_PREFIX_MIN_RATIO = "concurrency_min_ratio_";
        private static final String KEY_PREFIX_MIN_RATIO_BG = "concurrency_min_ratio_bg_";
        private static final String KEY_PREFIX_MIN_RATIO_BGUSER = "concurrency_min_ratio_bguser_";
        private static final String KEY_PREFIX_MIN_RATIO_BGUSER_IMPORTANT = "concurrency_min_ratio_bguser_important_";
        private static final String KEY_PREFIX_MIN_RATIO_EJ = "concurrency_min_ratio_ej_";
        private static final String KEY_PREFIX_MIN_RATIO_FGS = "concurrency_min_ratio_fgs_";
        private static final String KEY_PREFIX_MIN_RATIO_TOP = "concurrency_min_ratio_top_";
        private static final String KEY_PREFIX_MIN_RATIO_UI = "concurrency_min_ratio_ui_";
        private final String mConfigIdentifier;
        private final SparseIntArray mDefaultMaxAllowedSlotsRatio;
        private final int mDefaultMaxTotal;
        private final SparseIntArray mDefaultMinReservedSlotsRatio;
        private final SparseIntArray mMaxAllowedSlots;
        private int mMaxTotal;
        private final SparseIntArray mMinReservedSlots;

        WorkTypeConfig(String configIdentifier, int steadyStateConcurrencyLimit, int defaultMaxTotal, List<Pair<Integer, Float>> defaultMinRatio, List<Pair<Integer, Float>> defaultMaxRatio) {
            this.mMinReservedSlots = new SparseIntArray(7);
            this.mMaxAllowedSlots = new SparseIntArray(7);
            this.mDefaultMinReservedSlotsRatio = new SparseIntArray(7);
            this.mDefaultMaxAllowedSlotsRatio = new SparseIntArray(7);
            this.mConfigIdentifier = configIdentifier;
            int r6 = Math.min(defaultMaxTotal, steadyStateConcurrencyLimit);
            this.mMaxTotal = r6;
            this.mDefaultMaxTotal = r6;
            int numReserved = 0;
            int i = defaultMinRatio.size();
        L3:
            i = i - 1;
            float r8 = 0.0f;
            if (i < 0) goto L12;
            float ratio = ((Float) defaultMinRatio.get(i).second).floatValue();
            int wt = ((Integer) defaultMinRatio.get(i).first).intValue();
            if (ratio < 0.0f) goto L11;
            if (1.0f <= ratio) goto L11;
            this.mDefaultMinReservedSlotsRatio.put(wt, Float.floatToRawIntBits(ratio));
            numReserved = (int) (numReserved + (this.mMaxTotal * ratio));
        L11:
            throw new IllegalArgumentException("Invalid default min ratio: wt=" + wt + " minRatio=" + ratio);
        L12:
            int i2 = this.mDefaultMaxTotal;
            if (i2 < 0) goto L28;
            if (numReserved > this.mDefaultMaxTotal) goto L28;
            int i3 = defaultMaxRatio.size() - 1;
        L17:
            if (i3 < 0) goto L25;
            float ratio2 = ((Float) defaultMaxRatio.get(i3).second).floatValue();
            int wt2 = ((Integer) defaultMaxRatio.get(i3).first).intValue();
            float minRatio = Float.intBitsToFloat(this.mDefaultMinReservedSlotsRatio.get(wt2, 0));
            if (ratio2 < minRatio) goto L24;
            if (ratio2 <= r8) goto L24;
            this.mDefaultMaxAllowedSlotsRatio.put(wt2, Float.floatToRawIntBits(ratio2));
            i3 = i3 - 1;
            r8 = 0.0f;
        L24:
            throw new IllegalArgumentException("Invalid default config: t=" + defaultMaxTotal + " min=" + defaultMinRatio + " max=" + defaultMaxRatio);
        L25:
            update(new DeviceConfig.Properties.Builder("jobscheduler").build(), steadyStateConcurrencyLimit);
            return;
        L28:
            throw new IllegalArgumentException("Invalid default config: t=" + defaultMaxTotal + " min=" + defaultMinRatio + " max=" + defaultMaxRatio);
        }

        void update(DeviceConfig.Properties properties, int steadyStateConcurrencyLimit) {
            this.mMaxTotal = Math.max(1, Math.min(steadyStateConcurrencyLimit, properties.getInt(KEY_PREFIX_MAX_TOTAL + this.mConfigIdentifier, this.mDefaultMaxTotal)));
            int oneIntBits = Float.floatToIntBits(1.0f);
            this.mMaxAllowedSlots.clear();
            int maxTop = getMaxValue(properties, KEY_PREFIX_MAX_RATIO_TOP + this.mConfigIdentifier, 1, oneIntBits);
            this.mMaxAllowedSlots.put(1, maxTop);
            int maxFgs = getMaxValue(properties, KEY_PREFIX_MAX_RATIO_FGS + this.mConfigIdentifier, 2, oneIntBits);
            this.mMaxAllowedSlots.put(2, maxFgs);
            int maxUi = getMaxValue(properties, KEY_PREFIX_MAX_RATIO_UI + this.mConfigIdentifier, 4, oneIntBits);
            this.mMaxAllowedSlots.put(4, maxUi);
            int maxEj = getMaxValue(properties, KEY_PREFIX_MAX_RATIO_EJ + this.mConfigIdentifier, 8, oneIntBits);
            this.mMaxAllowedSlots.put(8, maxEj);
            int maxBg = getMaxValue(properties, KEY_PREFIX_MAX_RATIO_BG + this.mConfigIdentifier, 16, oneIntBits);
            this.mMaxAllowedSlots.put(16, maxBg);
            int maxBgUserImp = getMaxValue(properties, KEY_PREFIX_MAX_RATIO_BGUSER_IMPORTANT + this.mConfigIdentifier, 32, oneIntBits);
            this.mMaxAllowedSlots.put(32, maxBgUserImp);
            int maxBgUser = getMaxValue(properties, KEY_PREFIX_MAX_RATIO_BGUSER + this.mConfigIdentifier, 64, oneIntBits);
            this.mMaxAllowedSlots.put(64, maxBgUser);
            int remaining = this.mMaxTotal;
            this.mMinReservedSlots.clear();
            int minTop = getMinValue(properties, KEY_PREFIX_MIN_RATIO_TOP + this.mConfigIdentifier, 1, 1, Math.min(maxTop, this.mMaxTotal));
            this.mMinReservedSlots.put(1, minTop);
            int remaining2 = remaining - minTop;
            int minFgs = getMinValue(properties, KEY_PREFIX_MIN_RATIO_FGS + this.mConfigIdentifier, 2, 0, Math.min(maxFgs, remaining2));
            this.mMinReservedSlots.put(2, minFgs);
            int remaining3 = remaining2 - minFgs;
            int minUi = getMinValue(properties, KEY_PREFIX_MIN_RATIO_UI + this.mConfigIdentifier, 4, 0, Math.min(maxUi, remaining3));
            this.mMinReservedSlots.put(4, minUi);
            int remaining4 = remaining3 - minUi;
            int minEj = getMinValue(properties, KEY_PREFIX_MIN_RATIO_EJ + this.mConfigIdentifier, 8, 0, Math.min(maxEj, remaining4));
            this.mMinReservedSlots.put(8, minEj);
            int remaining5 = remaining4 - minEj;
            int minBg = getMinValue(properties, KEY_PREFIX_MIN_RATIO_BG + this.mConfigIdentifier, 16, 0, Math.min(maxBg, remaining5));
            this.mMinReservedSlots.put(16, minBg);
            int remaining6 = remaining5 - minBg;
            int minBgUserImp = getMinValue(properties, KEY_PREFIX_MIN_RATIO_BGUSER_IMPORTANT + this.mConfigIdentifier, 32, 0, Math.min(maxBgUserImp, remaining6));
            this.mMinReservedSlots.put(32, minBgUserImp);
            int minBgUser = getMinValue(properties, KEY_PREFIX_MIN_RATIO_BGUSER + this.mConfigIdentifier, 64, 0, Math.min(maxBgUser, remaining6 - minBgUserImp));
            this.mMinReservedSlots.put(64, minBgUser);
        }

        private int getMaxValue(DeviceConfig.Properties properties, String key, int workType, int defaultFloatInIntBits) {
            float maxRatio = Math.min(1.0f, properties.getFloat(key, Float.intBitsToFloat(this.mDefaultMaxAllowedSlotsRatio.get(workType, defaultFloatInIntBits))));
            return Math.max(1, (int) (this.mMaxTotal * maxRatio));
        }

        private int getMinValue(DeviceConfig.Properties properties, String key, int workType, int lowerLimit, int upperLimit) {
            float minRatio = Math.min(1.0f, properties.getFloat(key, Float.intBitsToFloat(this.mDefaultMinReservedSlotsRatio.get(workType))));
            return Math.max(lowerLimit, Math.min(upperLimit, (int) (this.mMaxTotal * minRatio)));
        }

        int getMaxTotal() {
            return this.mMaxTotal;
        }

        int getMax(int workType) {
            return this.mMaxAllowedSlots.get(workType, this.mMaxTotal);
        }

        int getMinReserved(int workType) {
            return this.mMinReservedSlots.get(workType);
        }

        void dump(IndentingPrintWriter pw) {
            pw.print(KEY_PREFIX_MAX_TOTAL + this.mConfigIdentifier, Integer.valueOf(this.mMaxTotal)).println();
            pw.print(KEY_PREFIX_MIN_RATIO_TOP + this.mConfigIdentifier, Integer.valueOf(this.mMinReservedSlots.get(1))).println();
            pw.print(KEY_PREFIX_MAX_RATIO_TOP + this.mConfigIdentifier, Integer.valueOf(this.mMaxAllowedSlots.get(1))).println();
            pw.print(KEY_PREFIX_MIN_RATIO_FGS + this.mConfigIdentifier, Integer.valueOf(this.mMinReservedSlots.get(2))).println();
            pw.print(KEY_PREFIX_MAX_RATIO_FGS + this.mConfigIdentifier, Integer.valueOf(this.mMaxAllowedSlots.get(2))).println();
            pw.print(KEY_PREFIX_MIN_RATIO_UI + this.mConfigIdentifier, Integer.valueOf(this.mMinReservedSlots.get(4))).println();
            pw.print(KEY_PREFIX_MAX_RATIO_UI + this.mConfigIdentifier, Integer.valueOf(this.mMaxAllowedSlots.get(4))).println();
            pw.print(KEY_PREFIX_MIN_RATIO_EJ + this.mConfigIdentifier, Integer.valueOf(this.mMinReservedSlots.get(8))).println();
            pw.print(KEY_PREFIX_MAX_RATIO_EJ + this.mConfigIdentifier, Integer.valueOf(this.mMaxAllowedSlots.get(8))).println();
            pw.print(KEY_PREFIX_MIN_RATIO_BG + this.mConfigIdentifier, Integer.valueOf(this.mMinReservedSlots.get(16))).println();
            pw.print(KEY_PREFIX_MAX_RATIO_BG + this.mConfigIdentifier, Integer.valueOf(this.mMaxAllowedSlots.get(16))).println();
            pw.print(KEY_PREFIX_MIN_RATIO_BGUSER + this.mConfigIdentifier, Integer.valueOf(this.mMinReservedSlots.get(32))).println();
            pw.print(KEY_PREFIX_MAX_RATIO_BGUSER + this.mConfigIdentifier, Integer.valueOf(this.mMaxAllowedSlots.get(32))).println();
            pw.print(KEY_PREFIX_MIN_RATIO_BGUSER + this.mConfigIdentifier, Integer.valueOf(this.mMinReservedSlots.get(64))).println();
            pw.print(KEY_PREFIX_MAX_RATIO_BGUSER + this.mConfigIdentifier, Integer.valueOf(this.mMaxAllowedSlots.get(64))).println();
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$2kTQ5uVCnwIBu08oo2Y0ld4bb-s, reason: not valid java name */
    public static /* synthetic */ void m4798$r8$lambda$2kTQ5uVCnwIBu08oo2Y0ld4bbs(JobConcurrencyManager r0) {
        r0.rampUpForScreenOff();
    }

    /* JADX INFO: renamed from: $r8$lambda$JWaSmpy-skpvcLp4dKxayoZ4Bpk, reason: not valid java name */
    public static /* synthetic */ void m4799$r8$lambda$JWaSmpyskpvcLp4dKxayoZ4Bpk(IndentingPrintWriter r0, PackageStats r1) {
        lambda$dumpLocked$1(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$VhD--0a_vmTAP5SEQ54BuaJ_sSE, reason: not valid java name */
    public static /* synthetic */ int m4800$r8$lambda$VhD0a_vmTAP5SEQ54BuaJ_sSE(ContextAssignment r0, ContextAssignment r1) {
        return lambda$static$0(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$nNxi-L4_H0efU9cBGIS9vGrT-zc, reason: not valid java name */
    public static /* synthetic */ void m4801$r8$lambda$nNxiL4_H0efU9cBGIS9vGrTzc(PackageStats r0) {
        PackageStats.m4810$$Nest$mresetStagedCount(r0);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m4802$$Nest$fgetmLock(JobConcurrencyManager r0) {
        return r0.mLock;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmPowerManager, reason: not valid java name */
    static /* bridge */ /* synthetic */ PowerManager m4803$$Nest$fgetmPowerManager(JobConcurrencyManager r0) {
        return r0.mPowerManager;
    }

    /* JADX INFO: renamed from: -$$Nest$monInteractiveStateChanged, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4804$$Nest$monInteractiveStateChanged(JobConcurrencyManager r0, boolean r1) {
        r0.onInteractiveStateChanged(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mstopOvertimeJobsLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4805$$Nest$mstopOvertimeJobsLocked(JobConcurrencyManager r0, String r1) {
        r0.stopOvertimeJobsLocked(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mstopUnexemptedJobsForDoze, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4806$$Nest$mstopUnexemptedJobsForDoze(JobConcurrencyManager r0) {
        r0.stopUnexemptedJobsForDoze();
    }

    static {
        DEBUG = JobSchedulerService.DEBUG;
        if (ActivityManager.isLowRamDeviceStatic() == false) goto L5;
        DEFAULT_CONCURRENCY_LIMIT = 8;
    L15:
        DEFAULT_PKG_CONCURRENCY_LIMIT_REGULAR = DEFAULT_CONCURRENCY_LIMIT / 2;
        CONFIG_LIMITS_SCREEN_ON = new WorkConfigLimitsPerMemoryTrimLevel(new WorkTypeConfig("screen_on_normal", DEFAULT_CONCURRENCY_LIMIT, (DEFAULT_CONCURRENCY_LIMIT * 3) / 4, List.of(Pair.create(1, Float.valueOf(0.4f)), Pair.create(2, Float.valueOf(0.2f)), Pair.create(4, Float.valueOf(0.1f)), Pair.create(8, Float.valueOf(0.1f)), Pair.create(16, Float.valueOf(0.05f)), Pair.create(32, Float.valueOf(0.05f))), List.of(Pair.create(16, Float.valueOf(0.5f)), Pair.create(32, Float.valueOf(0.25f)), Pair.create(64, Float.valueOf(0.2f)))), new WorkTypeConfig("screen_on_moderate", DEFAULT_CONCURRENCY_LIMIT, DEFAULT_CONCURRENCY_LIMIT / 2, List.of(Pair.create(1, Float.valueOf(0.4f)), Pair.create(2, Float.valueOf(0.1f)), Pair.create(4, Float.valueOf(0.1f)), Pair.create(8, Float.valueOf(0.1f)), Pair.create(16, Float.valueOf(0.1f)), Pair.create(32, Float.valueOf(0.1f))), List.of(Pair.create(16, Float.valueOf(0.4f)), Pair.create(32, Float.valueOf(0.1f)), Pair.create(64, Float.valueOf(0.1f)))), new WorkTypeConfig("screen_on_low", DEFAULT_CONCURRENCY_LIMIT, (DEFAULT_CONCURRENCY_LIMIT * 4) / 10, List.of(Pair.create(1, Float.valueOf(0.6f)), Pair.create(2, Float.valueOf(0.1f)), Pair.create(4, Float.valueOf(0.1f)), Pair.create(8, Float.valueOf(0.1f))), List.of(Pair.create(16, Float.valueOf(0.33333334f)), Pair.create(32, Float.valueOf(0.16666667f)), Pair.create(64, Float.valueOf(0.16666667f)))), new WorkTypeConfig("screen_on_critical", DEFAULT_CONCURRENCY_LIMIT, (DEFAULT_CONCURRENCY_LIMIT * 4) / 10, List.of(Pair.create(1, Float.valueOf(0.7f)), Pair.create(2, Float.valueOf(0.1f)), Pair.create(4, Float.valueOf(0.1f)), Pair.create(8, Float.valueOf(0.05f))), List.of(Pair.create(16, Float.valueOf(0.16666667f)), Pair.create(32, Float.valueOf(0.16666667f)), Pair.create(64, Float.valueOf(0.16666667f)))));
        CONFIG_LIMITS_SCREEN_OFF = new WorkConfigLimitsPerMemoryTrimLevel(new WorkTypeConfig("screen_off_normal", DEFAULT_CONCURRENCY_LIMIT, DEFAULT_CONCURRENCY_LIMIT, List.of(Pair.create(1, Float.valueOf(0.3f)), Pair.create(2, Float.valueOf(0.2f)), Pair.create(4, Float.valueOf(0.2f)), Pair.create(8, Float.valueOf(0.15f)), Pair.create(16, Float.valueOf(0.1f)), Pair.create(32, Float.valueOf(0.05f))), List.of(Pair.create(16, Float.valueOf(0.6f)), Pair.create(32, Float.valueOf(0.2f)), Pair.create(64, Float.valueOf(0.2f)))), new WorkTypeConfig("screen_off_moderate", DEFAULT_CONCURRENCY_LIMIT, (DEFAULT_CONCURRENCY_LIMIT * 9) / 10, List.of(Pair.create(1, Float.valueOf(0.3f)), Pair.create(2, Float.valueOf(0.2f)), Pair.create(4, Float.valueOf(0.2f)), Pair.create(8, Float.valueOf(0.15f)), Pair.create(16, Float.valueOf(0.1f)), Pair.create(32, Float.valueOf(0.05f))), List.of(Pair.create(16, Float.valueOf(0.5f)), Pair.create(32, Float.valueOf(0.1f)), Pair.create(64, Float.valueOf(0.1f)))), new WorkTypeConfig("screen_off_low", DEFAULT_CONCURRENCY_LIMIT, (DEFAULT_CONCURRENCY_LIMIT * 6) / 10, List.of(Pair.create(1, Float.valueOf(0.3f)), Pair.create(2, Float.valueOf(0.15f)), Pair.create(4, Float.valueOf(0.15f)), Pair.create(8, Float.valueOf(0.1f)), Pair.create(16, Float.valueOf(0.05f)), Pair.create(32, Float.valueOf(0.05f))), List.of(Pair.create(16, Float.valueOf(0.25f)), Pair.create(32, Float.valueOf(0.1f)), Pair.create(64, Float.valueOf(0.1f)))), new WorkTypeConfig("screen_off_critical", DEFAULT_CONCURRENCY_LIMIT, (DEFAULT_CONCURRENCY_LIMIT * 4) / 10, List.of(Pair.create(1, Float.valueOf(0.3f)), Pair.create(2, Float.valueOf(0.1f)), Pair.create(4, Float.valueOf(0.1f)), Pair.create(8, Float.valueOf(0.05f))), List.of(Pair.create(16, Float.valueOf(0.1f)), Pair.create(32, Float.valueOf(0.1f)), Pair.create(64, Float.valueOf(0.1f)))));
        sDeterminationComparator = new JobConcurrencyManager$$ExternalSyntheticLambda2();
        sConcurrencyHistogramLogger = new Histogram("job_scheduler.value_hist_job_concurrency", new Histogram.UniformOptions(100, 0.0f, 99.0f));
        return;
    L5:
        long ramBytes = new MemInfoReader().getTotalSize();
        if (ramBytes > DataUnit.GIGABYTES.toBytes(6)) goto L9;
        DEFAULT_CONCURRENCY_LIMIT = 16;
        goto L15
    L9:
        if (ramBytes > DataUnit.GIGABYTES.toBytes(8)) goto L12;
        DEFAULT_CONCURRENCY_LIMIT = 20;
        goto L15
    L12:
        if (ramBytes > DataUnit.GIGABYTES.toBytes(12)) goto L14;
        DEFAULT_CONCURRENCY_LIMIT = 32;
        goto L15
    L14:
        DEFAULT_CONCURRENCY_LIMIT = 40;
        goto L15
    }

    static String workTypeToString(int workType) {
        switch(workType) {
            case 0: goto L19;
            case 1: goto L17;
            case 2: goto L15;
            case 4: goto L13;
            case 8: goto L11;
            case 16: goto L9;
            case 32: goto L7;
            case 64: goto L5;
            default: goto L4;
        };
    L5:
        return "BGUSER";
    L7:
        return "BGUSER_IMPORTANT";
    L9:
        return "BG";
    L11:
        return "EJ";
    L13:
        return "UI";
    L15:
        return "FGS";
    L17:
        return "TOP";
    L19:
        return "NONE";
    L4:
        return "WORK(" + workType + ")";
    }

    private static /* synthetic */ int lambda$static$0(ContextAssignment ca1, ContextAssignment ca2) {
        if (ca1 != ca2) goto L5;
        return 0;
    L5:
        JobStatus js1 = ca1.context.getRunningJobLocked();
        JobStatus js2 = ca2.context.getRunningJobLocked();
        if (js1 != null) goto L11;
        if (js2 != null) goto L9;
        return 0;
    L9:
        return 1;
    L11:
        if (js2 != null) goto L14;
        return -1;
    L14:
        if (js1.lastEvaluatedBias != 40) goto L19;
        if (js2.lastEvaluatedBias == 40) goto L22;
        return -1;
    L22:
        return Long.compare(ca2.context.getExecutionStartTimeElapsed(), ca1.context.getExecutionStartTimeElapsed());
    L19:
        if (js2.lastEvaluatedBias != 40) goto L22;
        return 1;
    }

    JobConcurrencyManager(JobSchedulerService service) {
        this(service, new Injector());
    }

    JobConcurrencyManager(JobSchedulerService service, Injector injector) {
        this.mRecycledChanged = new ArraySet();
        this.mRecycledIdle = new ArraySet();
        this.mRecycledPreferredUidOnly = new ArrayList();
        this.mRecycledStoppable = new ArrayList();
        this.mRecycledAssignmentInfo = new AssignmentInfo();
        this.mRecycledPrivilegedState = new SparseIntArray();
        this.mContextAssignmentPool = new Pools.SimplePool(96);
        this.mActiveServices = new ArrayList();
        this.mIdleContexts = new ArraySet();
        this.mNumDroppedContexts = 0;
        this.mRunningJobs = new ArraySet();
        this.mWorkCountTracker = new WorkCountTracker();
        this.mPkgStatsPool = new Pools.SimplePool(96);
        this.mActivePkgStats = new SparseArrayMap();
        this.mWorkTypeConfig = CONFIG_LIMITS_SCREEN_OFF.normal;
        this.mScreenOffAdjustmentDelayMs = 30000;
        this.mSteadyStateConcurrencyLimit = DEFAULT_CONCURRENCY_LIMIT;
        this.mPkgConcurrencyLimitEj = 3;
        this.mPkgConcurrencyLimitRegular = DEFAULT_PKG_CONCURRENCY_LIMIT_REGULAR;
        this.mMaxWaitTimeBypassEnabled = true;
        this.mMaxWaitUIMs = 300000;
        this.mMaxWaitEjMs = 300000;
        this.mMaxWaitRegularMs = 1800000;
        this.mPackageStatsStagingCountClearer = new JobConcurrencyManager$$ExternalSyntheticLambda0();
        this.mStatLogger = new StatLogger(new String[]{"assignJobsToContexts", "refreshSystemState"});
        this.mReceiver = new AnonymousClass1(this);
        this.mRampUpForScreenOff = new JobConcurrencyManager$$ExternalSyntheticLambda1(this);
        this.mService = service;
        this.mLock = this.mService.getLock();
        this.mContext = service.getTestableContext();
        this.mInjector = injector;
        this.mNotificationCoordinator = new JobNotificationCoordinator();
        this.mActivityManagerInternal = (ActivityManagerInternal) LocalServices.getService(ActivityManagerInternal.class);
        this.mUserManagerInternal = (UserManagerInternal) LocalServices.getService(UserManagerInternal.class);
        this.mHandler = AppSchedulingModuleThread.getHandler();
        this.mGracePeriodObserver = new GracePeriodObserver(this.mContext);
        this.mShouldRestrictBgUser = this.mContext.getResources().getBoolean(R.bool.config_leftRightSplitInPortrait);
    }

    public void onSystemReady() {
        this.mPowerManager = (PowerManager) this.mContext.getSystemService(PowerManager.class);
        IntentFilter filter = new IntentFilter("android.intent.action.SCREEN_ON");
        filter.addAction("android.intent.action.SCREEN_OFF");
        filter.addAction("android.os.action.DEVICE_IDLE_MODE_CHANGED");
        filter.addAction("android.os.action.POWER_SAVE_MODE_CHANGED");
        this.mContext.registerReceiver(this.mReceiver, filter);
        ActivityManager.getService().registerUserSwitchObserver(this.mGracePeriodObserver, TAG);     // Catch: RemoteException -> L5
    L6:
        onInteractiveStateChanged(this.mPowerManager.isInteractive());
    }

    void onThirdPartyAppsCanStart() {
        IBatteryStats batteryStats = IBatteryStats.Stub.asInterface(ServiceManager.getService("batterystats"));
        int i = 0;
    L4:
        if (i >= this.mSteadyStateConcurrencyLimit) goto L7;
        this.mIdleContexts.add(this.mInjector.createJobServiceContext(this.mService, this, this.mNotificationCoordinator, batteryStats, this.mService.mJobPackageTracker, AppSchedulingModuleThread.get().getLooper()));
        i = i + 1;
        goto L4
    }

    void onAppRemovedLocked(String pkgName, int uid) {
        PackageStats packageStats = (PackageStats) this.mActivePkgStats.get(UserHandle.getUserId(uid), pkgName);
        if (packageStats != null) goto L5;
        return;
    L5:
        if (packageStats.numRunningEj <= 0) goto L7;
    L10:
        Slog.w(TAG, pkgName + "(" + uid + ") marked as removed before jobs stopped running");
        return;
    L7:
        if (packageStats.numRunningRegular > 0) goto L10;
        this.mActivePkgStats.delete(UserHandle.getUserId(uid), pkgName);
    }

    void onUserRemoved(int userId) {
        this.mGracePeriodObserver.onUserRemoved(userId);
    }

    private void onInteractiveStateChanged(boolean interactive) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.mCurrentInteractiveState != interactive) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        this.mCurrentInteractiveState = interactive;     // Catch: Throwable -> L8
        if (DEBUG == false) goto L13;
        Slog.d(TAG, "Interactive: " + interactive);     // Catch: Throwable -> L8
    L13:
        long nowRealtime = JobSchedulerService.sElapsedRealtimeClock.millis();     // Catch: Throwable -> L8
        if (interactive == false) goto L16;
        this.mLastScreenOnRealtime = nowRealtime;     // Catch: Throwable -> L8
        this.mEffectiveInteractiveState = true;     // Catch: Throwable -> L8
        this.mHandler.removeCallbacks(this.mRampUpForScreenOff);     // Catch: Throwable -> L8
    L17:
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L16:
        this.mLastScreenOffRealtime = nowRealtime;     // Catch: Throwable -> L8
        this.mHandler.postDelayed(this.mRampUpForScreenOff, this.mScreenOffAdjustmentDelayMs);     // Catch: Throwable -> L8
        goto L17
    }

    private void rampUpForScreenOff() {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.mEffectiveInteractiveState == true) goto L11;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L11:
        if (this.mLastScreenOnRealtime <= this.mLastScreenOffRealtime) goto L14;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L14:
        long now = JobSchedulerService.sElapsedRealtimeClock.millis();     // Catch: Throwable -> L8
        if ((this.mLastScreenOffRealtime + this.mScreenOffAdjustmentDelayMs) <= now) goto L18;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L18:
        this.mEffectiveInteractiveState = false;     // Catch: Throwable -> L8
        if (DEBUG == false) goto L21;
        Slog.d(TAG, "Ramping up concurrency");     // Catch: Throwable -> L8
    L21:
        this.mService.maybeRunPendingJobsLocked();     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
    }

    ArraySet<JobStatus> getRunningJobsLocked() {
        return this.mRunningJobs;
    }

    boolean isJobRunningLocked(JobStatus job) {
        return this.mRunningJobs.contains(job);
    }

    boolean isJobInOvertimeLocked(JobStatus job) {
        if (this.mRunningJobs.contains(job) == true) goto L5;
        return false;
    L5:
        int i = this.mActiveServices.size() - 1;
    L6:
        if (i < 0) goto L12;
        JobServiceContext jsc = this.mActiveServices.get(i);
        JobStatus jobStatus = jsc.getRunningJobLocked();
        if (jobStatus == job) goto L10;
        i = i - 1;
        goto L6
    L10:
        return !jsc.isWithinExecutionGuaranteeTime();
    L12:
        Slog.wtf(TAG, "Couldn't find long running job on a context");
        this.mRunningJobs.remove(job);
        return false;
    }

    private boolean isSimilarJobRunningLocked(JobStatus job) {
        int i = this.mRunningJobs.size() - 1;
    L3:
        if (i < 0) goto L8;
        JobStatus js = this.mRunningJobs.valueAt(i);
        if (job.matches(js.getUid(), js.getNamespace(), js.getJobId()) == true) goto L6;
        i = i - 1;
        goto L3
    L6:
        return true;
    L8:
        return false;
    }

    private boolean refreshSystemStateLocked() {
        long nowUptime = JobSchedulerService.sUptimeMillisClock.millis();
        if (nowUptime >= this.mNextSystemStateRefreshTime) goto L5;
        return false;
    L5:
        long start = this.mStatLogger.getTime();
        this.mNextSystemStateRefreshTime = 1000 + nowUptime;
        this.mLastMemoryTrimLevel = 0;
        this.mLastMemoryTrimLevel = ActivityManager.getService().getMemoryTrimLevel();     // Catch: RemoteException -> L8
    L9:
        this.mStatLogger.logDurationStat(1, start);
        return true;
    }

    private void updateCounterConfigLocked() {
        if (refreshSystemStateLocked() == true) goto L6;
        return;
    L6:
        if (this.mEffectiveInteractiveState == false) goto L8;
        WorkConfigLimitsPerMemoryTrimLevel workConfigs = CONFIG_LIMITS_SCREEN_ON;
    L10:
        switch(this.mLastMemoryTrimLevel) {
            case 1: goto L14;
            case 2: goto L13;
            case 3: goto L12;
            default: goto L11;
        };
    L11:
        this.mWorkTypeConfig = workConfigs.normal;
    L15:
        this.mWorkCountTracker.setConfig(this.mWorkTypeConfig);
        return;
    L12:
        this.mWorkTypeConfig = workConfigs.critical;
        goto L15
    L13:
        this.mWorkTypeConfig = workConfigs.low;
        goto L15
    L14:
        this.mWorkTypeConfig = workConfigs.moderate;
        goto L15
    L8:
        workConfigs = CONFIG_LIMITS_SCREEN_OFF;
        goto L10
    }

    void assignJobsToContextsLocked() {
        long start = this.mStatLogger.getTime();
        assignJobsToContextsInternalLocked();
        this.mStatLogger.logDurationStat(0, start);
    }

    private void assignJobsToContextsInternalLocked() {
        if (DEBUG == false) goto L6;
        Slog.d(TAG, printPendingQueueLocked());
    L6:
        if (this.mService.getPendingJobQueue().size() != 0) goto L8;
        return;
    L8:
        prepareForAssignmentDeterminationLocked(this.mRecycledIdle, this.mRecycledPreferredUidOnly, this.mRecycledStoppable, this.mRecycledAssignmentInfo);
        if (DEBUG == false) goto L11;
        Slog.d(TAG, printAssignments("running jobs initial", new Collection[]{this.mRecycledStoppable, this.mRecycledPreferredUidOnly}));
    L11:
        determineAssignmentsLocked(this.mRecycledChanged, this.mRecycledIdle, this.mRecycledPreferredUidOnly, this.mRecycledStoppable, this.mRecycledAssignmentInfo);
        if (DEBUG == false) goto L14;
        Slog.d(TAG, printAssignments("running jobs final", new Collection[]{this.mRecycledStoppable, this.mRecycledPreferredUidOnly, this.mRecycledChanged}));
        Slog.d(TAG, "work count results: " + this.mWorkCountTracker);
    L14:
        carryOutAssignmentChangesLocked(this.mRecycledChanged);
        cleanUpAfterAssignmentChangesLocked(this.mRecycledChanged, this.mRecycledIdle, this.mRecycledPreferredUidOnly, this.mRecycledStoppable, this.mRecycledAssignmentInfo, this.mRecycledPrivilegedState);
        noteConcurrency(true);
    }

    void prepareForAssignmentDeterminationLocked(ArraySet<ContextAssignment> idle, List<ContextAssignment> preferredUidOnly, List<ContextAssignment> stoppable, AssignmentInfo info) {
        PendingJobQueue pendingJobQueue = this.mService.getPendingJobQueue();
        List<JobServiceContext> activeServices = this.mActiveServices;
        updateCounterConfigLocked();
        this.mWorkCountTracker.resetCounts();
        boolean r6 = true;
        updateNonRunningPrioritiesLocked(pendingJobQueue, true);
        int numRunningJobs = activeServices.size();
        long nowElapsed = JobSchedulerService.sElapsedRealtimeClock.millis();
        long minPreferredUidOnlyWaitingTimeMs = Long.MAX_VALUE;
        int i = 0;
    L3:
        if (i >= numRunningJobs) goto L25;
        JobServiceContext jsc = activeServices.get(i);
        JobStatus js = jsc.getRunningJobLocked();
        ContextAssignment assignment = (ContextAssignment) this.mContextAssignmentPool.acquire();
        if (assignment != null) goto L7;
        assignment = new ContextAssignment();
    L7:
        assignment.context = jsc;
        if (js == null) goto L19;
        boolean r16 = r6;
        PendingJobQueue pendingJobQueue2 = pendingJobQueue;
        this.mWorkCountTracker.incrementRunningJobCount(jsc.getRunningJobWorkType());
        assignment.workType = jsc.getRunningJobWorkType();
        if (js.startedWithImmediacyPrivilege == false) goto L13;
        info.numRunningImmediacyPrivileged++;
    L13:
        if (js.shouldTreatAsUserInitiatedJob() == false) goto L16;
        info.numRunningUi++;
    L20:
        assignment.preferredUid = jsc.getPreferredUid();
        String r4 = shouldStopRunningJobLocked(jsc);
        assignment.shouldStopJobReason = r4;
        if (r4 == null) goto L23;
        stoppable.add(assignment);
    L24:
        i = i + 1;
        activeServices = activeServices;
        r6 = r16;
        pendingJobQueue = pendingJobQueue2;
        goto L3
    L23:
        assignment.timeUntilStoppableMs = jsc.getRemainingGuaranteedTimeMs(nowElapsed);
        long minPreferredUidOnlyWaitingTimeMs2 = Math.min(minPreferredUidOnlyWaitingTimeMs, assignment.timeUntilStoppableMs);
        preferredUidOnly.add(assignment);
        minPreferredUidOnlyWaitingTimeMs = minPreferredUidOnlyWaitingTimeMs2;
        goto L24
    L16:
        if (js.startedAsExpeditedJob == false) goto L18;
        info.numRunningEj++;
        goto L20
    L18:
        info.numRunningReg++;
        goto L20
    L19:
        pendingJobQueue2 = pendingJobQueue;
        r16 = r6;
        goto L20
    L25:
        preferredUidOnly.sort(sDeterminationComparator);
        stoppable.sort(sDeterminationComparator);
        int i2 = numRunningJobs;
    L27:
        if (i2 >= this.mSteadyStateConcurrencyLimit) goto L36;
        int numIdleContexts = this.mIdleContexts.size();
        if (numIdleContexts <= 0) goto L31;
        JobServiceContext jsc2 = this.mIdleContexts.removeAt(numIdleContexts - 1);
    L32:
        ContextAssignment assignment2 = (ContextAssignment) this.mContextAssignmentPool.acquire();
        if (assignment2 != null) goto L35;
        assignment2 = new ContextAssignment();
    L35:
        assignment2.context = jsc2;
        idle.add(assignment2);
        i2 = i2 + 1;
        goto L27
    L31:
        Slog.w(TAG, "Had fewer than " + this.mSteadyStateConcurrencyLimit + " in existence");
        jsc2 = createNewJobServiceContext();
        goto L32
    L36:
        this.mWorkCountTracker.onCountDone();
        if (minPreferredUidOnlyWaitingTimeMs != Long.MAX_VALUE) goto L39;
        long r5 = 0;
    L40:
        info.minPreferredUidOnlyWaitingTimeMs = r5;
        return;
    L39:
        r5 = minPreferredUidOnlyWaitingTimeMs;
        goto L40
    }

    void determineAssignmentsLocked(ArraySet<ContextAssignment> changed, ArraySet<ContextAssignment> idle, List<ContextAssignment> preferredUidOnly, List<ContextAssignment> stoppable, AssignmentInfo info) {
        JobConcurrencyManager r0 = this;
        ArraySet<ContextAssignment> r2 = idle;
        List<ContextAssignment> r3 = preferredUidOnly;
        List<ContextAssignment> r4 = stoppable;
        PendingJobQueue pendingJobQueue = r0.mService.getPendingJobQueue();
        List<JobServiceContext> activeServices = r0.mActiveServices;
        pendingJobQueue.resetIterator();
        int projectedRunningCount = activeServices.size();
        long minChangedWaitingTimeMs = Long.MAX_VALUE;
        if (info.numRunningUi != 0) goto L5;
        boolean allowMaxWaitContextBypassUi = true;
    L7:
        if (info.numRunningEj != 0) goto L9;
        boolean allowMaxWaitContextBypassEj = true;
    L11:
        if (info.numRunningReg != 0) goto L13;
        boolean allowMaxWaitContextBypassOthers = true;
    L14:
        JobStatus nextPending = pendingJobQueue.next();
        if (nextPending == null) goto L228;
        activeServices = activeServices;
        if (r0.mRunningJobs.contains(nextPending) == true) goto L18;
        boolean allowMaxWaitContextBypassUi2 = allowMaxWaitContextBypassUi;
        boolean hasImmediacyPrivilege = r0.hasImmediacyPrivilegeLocked(nextPending, r0.mRecycledPrivilegedState);
        if (DEBUG == false) goto L29;
        if (r0.isSimilarJobRunningLocked(nextPending) == false) goto L29;
        Slog.w(TAG, "Already running similar job to: " + nextPending);
    L29:
        boolean allowMaxWaitContextBypassEj2 = allowMaxWaitContextBypassEj;
        long minWaitingTimeMs = Math.min(info.minPreferredUidOnlyWaitingTimeMs, minChangedWaitingTimeMs);
        ContextAssignment selectedContext = null;
        int allWorkTypes = r0.getJobWorkTypes(nextPending);
        boolean pkgConcurrencyOkay = !r0.isPkgConcurrencyLimitedLocked(nextPending);
        if (projectedRunningCount <= r0.mSteadyStateConcurrencyLimit) goto L32;
        boolean isInOverage = true;
    L34:
        if (r2.size() <= 0) goto L47;
        int projectedRunningCount2 = projectedRunningCount;
        int projectedRunningCount3 = r2.size() - 1;
        boolean isInOverage2 = isInOverage;
        ContextAssignment assignment = r2.valueAt(projectedRunningCount3);
        boolean startingJob = false;
        boolean allowMaxWaitContextBypassOthers2 = allowMaxWaitContextBypassOthers;
        if (assignment.preferredUid != nextPending.getUid()) goto L38;
    L41:
        boolean preferredUidOkay = true;
    L42:
        int workType = r0.mWorkCountTracker.canJobStart(allWorkTypes);
        if (preferredUidOkay == false) goto L48;
        if (pkgConcurrencyOkay == false) goto L48;
        if (workType == 0) goto L48;
        selectedContext = assignment;
        r2.removeAt(projectedRunningCount3);
        assignment.newJob = nextPending;
        assignment.newWorkType = workType;
        boolean preferredUidOkay2 = true;
    L49:
        if (selectedContext == null) goto L51;
    L96:
        long minChangedWaitingTimeMs2 = minChangedWaitingTimeMs;
        preferredUidOkay2 = preferredUidOkay2;
        int r25 = 2;
    L97:
        if (selectedContext != null) goto L126;
        if (isInOverage2 == false) goto L102;
        if (hasImmediacyPrivilege == false) goto L126;
    L102:
        int lowestBiasSeen = Integer.MAX_VALUE;
        long newMinPreferredUidOnlyWaitingTimeMs = Long.MAX_VALUE;
        int p = r3.size() - 1;
        ContextAssignment selectedContext2 = selectedContext;
    L103:
        if (p < 0) goto L122;
        ContextAssignment assignment2 = r3.get(p);
        JobStatus runningJob = assignment2.context.getRunningJobLocked();
        if (runningJob == null) goto L120;
        int r5 = runningJob.getUid();
        int p2 = p;
        int p3 = nextPending.getUid();
        if (r5 == p3) goto L109;
        hasImmediacyPrivilege = hasImmediacyPrivilege;
        int r11 = r25;
    L121:
        p = p2 - 1;
        r25 = r11;
        hasImmediacyPrivilege = hasImmediacyPrivilege;
        goto L103
    L109:
        int jobBias = r0.mService.evaluateJobBiasLocked(runningJob);
        if (jobBias < nextPending.lastEvaluatedBias) goto L112;
        hasImmediacyPrivilege = hasImmediacyPrivilege;
        r11 = r25;
        goto L121
    L112:
        if (selectedContext2 == null) goto L117;
        if (lowestBiasSeen > jobBias) goto L117;
        hasImmediacyPrivilege = hasImmediacyPrivilege;
        newMinPreferredUidOnlyWaitingTimeMs = Math.min(newMinPreferredUidOnlyWaitingTimeMs, assignment2.timeUntilStoppableMs);
        r11 = r25;
    L117:
        if (selectedContext2 == null) goto L119;
        newMinPreferredUidOnlyWaitingTimeMs = Math.min(newMinPreferredUidOnlyWaitingTimeMs, selectedContext2.timeUntilStoppableMs);
    L119:
        lowestBiasSeen = jobBias;
        assignment2.preemptReason = "higher bias job found";
        r11 = r25;
        assignment2.preemptReasonCode = r11;
        selectedContext2 = assignment2;
        goto L121
    L120:
        p2 = p;
        hasImmediacyPrivilege = hasImmediacyPrivilege;
        r11 = r25;
        goto L121
    L122:
        hasImmediacyPrivilege = hasImmediacyPrivilege;
        if (selectedContext2 == null) goto L127;
        selectedContext2.newJob = nextPending;
        r3.remove(selectedContext2);
        info.minPreferredUidOnlyWaitingTimeMs = newMinPreferredUidOnlyWaitingTimeMs;
    L127:
        if (hasImmediacyPrivilege == false) goto L154;
        if (selectedContext2 == null) goto L134;
        if (selectedContext2.context.getRunningJobLocked() == null) goto L134;
        changed.add(selectedContext2);
        int projectedRunningCount4 = projectedRunningCount2 - 1;
        selectedContext2.newJob = null;
        selectedContext2.newWorkType = 0;
        selectedContext2 = null;
    L135:
        if (selectedContext2 == null) goto L137;
        allowMaxWaitContextBypassUi = allowMaxWaitContextBypassUi2;
        allowMaxWaitContextBypassEj = allowMaxWaitContextBypassEj2;
        allowMaxWaitContextBypassOthers = allowMaxWaitContextBypassOthers2;
    L214:
        PackageStats packageStats = r0.getPkgStatsLocked(nextPending.getSourceUserId(), nextPending.getSourcePackageName());
        if (selectedContext2 == null) goto L224;
        changed.add(selectedContext2);
        if (selectedContext2.context.getRunningJobLocked() == null) goto L220;
        projectedRunningCount4 = projectedRunningCount4 - 1;
    L220:
        if (selectedContext2.newJob == null) goto L222;
        selectedContext2.newJob.startedWithImmediacyPrivilege = hasImmediacyPrivilege;
        long minChangedWaitingTimeMs3 = Math.min(minChangedWaitingTimeMs2, r0.mService.getMinJobExecutionGuaranteeMs(selectedContext2.newJob));
        projectedRunningCount = projectedRunningCount4 + 1;
    L223:
        PackageStats.m4808$$Nest$madjustStagedCount(packageStats, true, nextPending.shouldTreatAsExpeditedJob());
    L225:
        if (preferredUidOkay2 == false) goto L227;
        r0.mWorkCountTracker.stageJob(selectedContext2.newWorkType, allWorkTypes);
        r0.mActivePkgStats.add(nextPending.getSourceUserId(), nextPending.getSourcePackageName(), packageStats);
    L227:
        r0 = this;
        r4 = stoppable;
        minChangedWaitingTimeMs = minChangedWaitingTimeMs3;
        pendingJobQueue = pendingJobQueue;
        r2 = idle;
        r3 = preferredUidOnly;
        goto L14
    L222:
        projectedRunningCount = projectedRunningCount4;
        minChangedWaitingTimeMs3 = minChangedWaitingTimeMs2;
        goto L223
    L224:
        minChangedWaitingTimeMs3 = minChangedWaitingTimeMs2;
        projectedRunningCount = projectedRunningCount4;
        goto L225
    L137:
        if (DEBUG == false) goto L139;
        Slog.d(TAG, "Allowing additional context because EJ would wait too long");
    L139:
        ContextAssignment selectedContext3 = (ContextAssignment) r0.mContextAssignmentPool.acquire();
        if (selectedContext3 != null) goto L142;
        selectedContext2 = new ContextAssignment();
    L144:
        if (r0.mIdleContexts.size() <= 0) goto L146;
        JobServiceContext r6 = r0.mIdleContexts.removeAt(r0.mIdleContexts.size() - 1);
    L147:
        selectedContext2.context = r6;
        selectedContext2.newJob = nextPending;
        int workType2 = r0.mWorkCountTracker.canJobStart(allWorkTypes);
        if (workType2 == 0) goto L150;
        int r7 = workType2;
    L151:
        selectedContext2.newWorkType = r7;
        allowMaxWaitContextBypassUi = allowMaxWaitContextBypassUi2;
        allowMaxWaitContextBypassEj = allowMaxWaitContextBypassEj2;
        allowMaxWaitContextBypassOthers = allowMaxWaitContextBypassOthers2;
        goto L214
    L150:
        r7 = 1;
        goto L151
    L146:
        r6 = r0.createNewJobServiceContext();
        goto L147
    L142:
        selectedContext2 = selectedContext3;
    L134:
        projectedRunningCount4 = projectedRunningCount2;
        goto L135
    L154:
        if (selectedContext2 == null) goto L156;
    L213:
        allowMaxWaitContextBypassUi = allowMaxWaitContextBypassUi2;
        allowMaxWaitContextBypassEj = allowMaxWaitContextBypassEj2;
        projectedRunningCount4 = projectedRunningCount2;
        allowMaxWaitContextBypassOthers = allowMaxWaitContextBypassOthers2;
        goto L214
    L156:
        if (r0.mMaxWaitTimeBypassEnabled == false) goto L213;
        if (nextPending.shouldTreatAsUserInitiatedJob() == false) goto L168;
        if (allowMaxWaitContextBypassUi2 == false) goto L168;
        if (minWaitingTimeMs < r0.mMaxWaitUIMs) goto L163;
        boolean wouldBeWaitingTooLong = true;
    L164:
        if (wouldBeWaitingTooLong == true) goto L166;
        boolean r8 = true;
    L167:
        allowMaxWaitContextBypassUi = r8;
        allowMaxWaitContextBypassEj = allowMaxWaitContextBypassEj2;
        allowMaxWaitContextBypassOthers = allowMaxWaitContextBypassOthers2;
    L189:
        if (wouldBeWaitingTooLong == true) goto L191;
        projectedRunningCount4 = projectedRunningCount2;
        goto L214
    L191:
        if (DEBUG == false) goto L193;
        Slog.d(TAG, "Allowing additional context because job would wait too long");
    L193:
        ContextAssignment selectedContext4 = (ContextAssignment) r0.mContextAssignmentPool.acquire();
        if (selectedContext4 != null) goto L196;
        selectedContext2 = new ContextAssignment();
    L198:
        if (r0.mIdleContexts.size() <= 0) goto L200;
        JobServiceContext r9 = r0.mIdleContexts.removeAt(r0.mIdleContexts.size() - 1);
    L201:
        selectedContext2.context = r9;
        selectedContext2.newJob = nextPending;
        int workType3 = r0.mWorkCountTracker.canJobStart(allWorkTypes);
        if (workType3 == 0) goto L204;
        selectedContext2.newWorkType = workType3;
    L211:
        projectedRunningCount4 = projectedRunningCount2;
        goto L214
    L204:
        int type = 1;
    L206:
        if (type > 127) goto L211;
        if ((type & allWorkTypes) != 0) goto L209;
        type = type << 1;
        goto L206
    L209:
        selectedContext2.newWorkType = type;
        goto L211
    L200:
        r9 = r0.createNewJobServiceContext();
        goto L201
    L196:
        selectedContext2 = selectedContext4;
        goto L198
    L166:
        r8 = false;
        goto L167
    L163:
        wouldBeWaitingTooLong = false;
    L168:
        boolean wouldBeWaitingTooLong2 = nextPending.shouldTreatAsExpeditedJob();
        if (wouldBeWaitingTooLong2 == false) goto L179;
        if (allowMaxWaitContextBypassEj2 == false) goto L179;
        if (minWaitingTimeMs < r0.mMaxWaitEjMs) goto L174;
        wouldBeWaitingTooLong = true;
    L175:
        if (wouldBeWaitingTooLong == true) goto L177;
        boolean r10 = true;
    L178:
        allowMaxWaitContextBypassEj = r10;
        allowMaxWaitContextBypassUi = allowMaxWaitContextBypassUi2;
        allowMaxWaitContextBypassOthers = allowMaxWaitContextBypassOthers2;
        goto L189
    L177:
        r10 = false;
        goto L178
    L174:
        wouldBeWaitingTooLong = false;
    L179:
        if (allowMaxWaitContextBypassOthers2 == true) goto L181;
        wouldBeWaitingTooLong = false;
        allowMaxWaitContextBypassUi = allowMaxWaitContextBypassUi2;
        allowMaxWaitContextBypassEj = allowMaxWaitContextBypassEj2;
        allowMaxWaitContextBypassOthers = allowMaxWaitContextBypassOthers2;
        goto L189
    L181:
        if (minWaitingTimeMs < r0.mMaxWaitRegularMs) goto L183;
        wouldBeWaitingTooLong = true;
    L184:
        if (wouldBeWaitingTooLong == true) goto L186;
        boolean r12 = true;
    L187:
        allowMaxWaitContextBypassOthers = r12;
        allowMaxWaitContextBypassUi = allowMaxWaitContextBypassUi2;
        allowMaxWaitContextBypassEj = allowMaxWaitContextBypassEj2;
        goto L189
    L186:
        r12 = false;
        goto L187
    L183:
        wouldBeWaitingTooLong = false;
    L126:
        selectedContext2 = selectedContext;
        goto L127
    L51:
        if (r4.size() <= 0) goto L96;
        int s = r4.size() - 1;
    L53:
        if (s < 0) goto L95;
        ContextAssignment assignment3 = r4.get(s);
        r25 = 2;
        JobStatus runningJob2 = assignment3.context.getRunningJobLocked();
        boolean canReplace = hasImmediacyPrivilege;
        if (canReplace == true) goto L67;
        if (isInOverage2 == true) goto L67;
        int currentJobBias = r0.mService.evaluateJobBiasLocked(runningJob2);
        if (runningJob2.lastEvaluatedBias < 40) goto L64;
        if (currentJobBias < 40) goto L64;
        if (info.numRunningImmediacyPrivileged > (r0.mWorkTypeConfig.getMaxTotal() / 2)) goto L64;
        boolean r13 = false;
    L65:
        canReplace = r13;
    L64:
        r13 = true;
    L67:
        if (canReplace == false) goto L69;
    L89:
        minChangedWaitingTimeMs2 = minChangedWaitingTimeMs;
    L90:
        if (canReplace == false) goto L94;
        int replaceWorkType = r0.mWorkCountTracker.canJobStart(allWorkTypes, assignment3.context.getRunningJobWorkType());
        if (replaceWorkType == 0) goto L94;
        assignment3.preemptReason = assignment3.shouldStopJobReason;
        assignment3.preemptReasonCode = 4;
        selectedContext = assignment3;
        r4.remove(s);
        assignment3.newJob = nextPending;
        assignment3.newWorkType = replaceWorkType;
    L94:
        s = s - 1;
        preferredUidOkay2 = preferredUidOkay2;
        minChangedWaitingTimeMs = minChangedWaitingTimeMs2;
        goto L53
    L69:
        if (r0.mMaxWaitTimeBypassEnabled == false) goto L89;
        if (nextPending.shouldTreatAsUserInitiatedJob() == false) goto L77;
        minChangedWaitingTimeMs2 = minChangedWaitingTimeMs;
        if (minWaitingTimeMs < r0.mMaxWaitUIMs) goto L75;
        boolean r14 = true;
    L76:
        canReplace = r14;
        goto L90
    L75:
        r14 = false;
        goto L76
    L77:
        minChangedWaitingTimeMs2 = minChangedWaitingTimeMs;
        if (nextPending.shouldTreatAsExpeditedJob() == false) goto L85;
        if (minWaitingTimeMs < r0.mMaxWaitEjMs) goto L82;
        boolean r15 = true;
    L83:
        canReplace = r15;
        goto L90
    L82:
        r15 = false;
        goto L83
    L85:
        if (minWaitingTimeMs < r0.mMaxWaitRegularMs) goto L87;
        boolean r16 = true;
    L88:
        canReplace = r16;
        goto L90
    L87:
        r16 = false;
        goto L88
    L95:
        minChangedWaitingTimeMs2 = minChangedWaitingTimeMs;
        preferredUidOkay2 = preferredUidOkay2;
        r25 = 2;
    L48:
        preferredUidOkay2 = startingJob;
        goto L49
    L38:
        if (assignment.preferredUid == (-1)) goto L41;
        preferredUidOkay = false;
        goto L42
    L47:
        projectedRunningCount2 = projectedRunningCount;
        isInOverage2 = isInOverage;
        startingJob = false;
        allowMaxWaitContextBypassOthers2 = allowMaxWaitContextBypassOthers;
        goto L48
    L32:
        isInOverage = false;
        goto L34
    L18:
        Slog.wtf(TAG, "Pending queue contained a running job");
        if (DEBUG == false) goto L22;
        Slog.e(TAG, "Pending+running job: " + nextPending);
    L22:
        pendingJobQueue.remove(nextPending);
        allowMaxWaitContextBypassUi = allowMaxWaitContextBypassUi;
        goto L14
    L228:
        return;
    L13:
        allowMaxWaitContextBypassOthers = false;
        goto L14
    L9:
        allowMaxWaitContextBypassEj = false;
        goto L11
    L5:
        allowMaxWaitContextBypassUi = false;
        goto L7
    }

    private void carryOutAssignmentChangesLocked(ArraySet<ContextAssignment> changed) {
        int c = changed.size() - 1;
    L3:
        if (c < 0) goto L16;
        ContextAssignment assignment = changed.valueAt(c);
        JobStatus js = assignment.context.getRunningJobLocked();
        if (js != null) goto L7;
        JobStatus pendingJob = assignment.newJob;
        if (DEBUG == false) goto L13;
        Slog.d(TAG, "About to run job on context " + assignment.context.getId() + ", job: " + pendingJob);
    L13:
        startJobLocked(assignment.context, pendingJob, assignment.newWorkType);
    L14:
        assignment.clear();
        this.mContextAssignmentPool.release(assignment);
        c = c - 1;
        goto L3
    L7:
        if (DEBUG == false) goto L9;
        Slog.d(TAG, "preempting job: " + js);
    L9:
        assignment.context.cancelExecutingJobLocked(assignment.preemptReasonCode, 2, assignment.preemptReason);
        goto L14
    }

    private void cleanUpAfterAssignmentChangesLocked(ArraySet<ContextAssignment> changed, ArraySet<ContextAssignment> idle, List<ContextAssignment> preferredUidOnly, List<ContextAssignment> stoppable, AssignmentInfo assignmentInfo, SparseIntArray privilegedState) {
        int s = stoppable.size() - 1;
    L3:
        if (s < 0) goto L5;
        ContextAssignment assignment = stoppable.get(s);
        assignment.clear();
        this.mContextAssignmentPool.release(assignment);
        s = s - 1;
        goto L3
    L5:
        int s2 = preferredUidOnly.size();
        int p = s2 - 1;
    L6:
        if (p < 0) goto L8;
        ContextAssignment assignment2 = preferredUidOnly.get(p);
        assignment2.clear();
        this.mContextAssignmentPool.release(assignment2);
        p = p - 1;
        goto L6
    L8:
        int p2 = idle.size();
        int i = p2 - 1;
    L9:
        if (i < 0) goto L11;
        ContextAssignment assignment3 = idle.valueAt(i);
        this.mIdleContexts.add(assignment3.context);
        assignment3.clear();
        this.mContextAssignmentPool.release(assignment3);
        i = i - 1;
        goto L9
    L11:
        changed.clear();
        idle.clear();
        stoppable.clear();
        preferredUidOnly.clear();
        assignmentInfo.clear();
        privilegedState.clear();
        this.mWorkCountTracker.resetStagingCount();
        this.mActivePkgStats.forEach(this.mPackageStatsStagingCountClearer);
    }

    boolean hasImmediacyPrivilegeLocked(JobStatus job, SparseIntArray cachedPrivilegedState) {
        if (job.shouldTreatAsExpeditedJob() == false) goto L5;
    L7:
        int r3 = 1;
        if (job.lastEvaluatedBias != 40) goto L10;
        return true;
    L10:
        int uid = job.getSourceUid();
        int privilegedState = cachedPrivilegedState.get(uid, 0);
        switch(privilegedState) {
            case 1: goto L30;
            case 2: goto L29;
            case 3: goto L27;
            default: goto L12;
        };
    L12:
        int procState = this.mActivityManagerInternal.getUidProcessState(uid);
        if (procState != 2) goto L17;
        cachedPrivilegedState.put(uid, 3);
        return true;
    L17:
        if (job.shouldTreatAsExpeditedJob() == false) goto L19;
        return false;
    L19:
        BackgroundStartPrivileges bsp = this.mActivityManagerInternal.getBackgroundStartPrivileges(uid);
        if (DEBUG == false) goto L22;
        Slog.d(TAG, "Job " + job.toShortString() + " bsp state: " + bsp);
    L22:
        boolean balAllowed = bsp.allowsBackgroundActivityStarts();
        if (balAllowed == false) goto L25;
        r3 = 2;
    L25:
        cachedPrivilegedState.put(uid, r3);
        return balAllowed;
    L27:
        return true;
    L30:
        return false;
    L29:
        return job.shouldTreatAsUserInitiatedJob();
    L5:
        if (job.shouldTreatAsUserInitiatedJob() == true) goto L7;
        return false;
    }

    void onUidBiasChangedLocked(int prevBias, int newBias) {
        if (prevBias == 40) goto L7;
        if (newBias == 40) goto L7;
        return;
    L7:
        if (this.mService.getPendingJobQueue().size() != 0) goto L9;
        return;
    L9:
        assignJobsToContextsLocked();
    }

    JobServiceContext getRunningJobServiceContextLocked(JobStatus job) {
        if (this.mRunningJobs.contains(job) == true) goto L5;
        return null;
    L5:
        int i = 0;
    L7:
        if (i >= this.mActiveServices.size()) goto L12;
        JobServiceContext jsc = this.mActiveServices.get(i);
        JobStatus executing = jsc.getRunningJobLocked();
        if (executing == job) goto L10;
        i = i + 1;
        goto L7
    L10:
        return jsc;
    L12:
        Slog.wtf(TAG, "Couldn't find running job on a context");
        this.mRunningJobs.remove(job);
        return null;
    }

    boolean stopJobOnServiceContextLocked(JobStatus job, int reason, int internalReasonCode, String debugReason) {
        if (this.mRunningJobs.contains(job) == true) goto L5;
        return false;
    L5:
        int i = 0;
    L7:
        if (i >= this.mActiveServices.size()) goto L13;
        JobServiceContext jsc = this.mActiveServices.get(i);
        JobStatus executing = jsc.getRunningJobLocked();
        if (executing == job) goto L10;
        i = i + 1;
        goto L7
    L10:
        jsc.cancelExecutingJobLocked(reason, internalReasonCode, debugReason);
        return true;
    L13:
        Slog.wtf(TAG, "Couldn't find running job on a context");
        this.mRunningJobs.remove(job);
        return false;
    }

    private void stopUnexemptedJobsForDoze() {
        int i = 0;
    L4:
        if (i >= this.mActiveServices.size()) goto L12;
        JobServiceContext jsc = this.mActiveServices.get(i);
        JobStatus executing = jsc.getRunningJobLocked();
        if (executing == null) goto L10;
        if (executing.canRunInDoze() == true) goto L10;
        jsc.cancelExecutingJobLocked(4, 4, "cancelled due to doze");
    L10:
        i = i + 1;
        goto L4
    }

    private void stopOvertimeJobsLocked(String debugReason) {
        int i = 0;
    L4:
        if (i >= this.mActiveServices.size()) goto L12;
        JobServiceContext jsc = this.mActiveServices.get(i);
        JobStatus jobStatus = jsc.getRunningJobLocked();
        if (jobStatus == null) goto L10;
        if (jsc.isWithinExecutionGuaranteeTime() == true) goto L10;
        jsc.cancelExecutingJobLocked(4, 3, debugReason);
    L10:
        i = i + 1;
        goto L4
    }

    void maybeStopOvertimeJobsLocked(JobRestriction restriction) {
        int i = this.mActiveServices.size() - 1;
    L3:
        if (i < 0) goto L13;
        JobServiceContext jsc = this.mActiveServices.get(i);
        JobStatus jobStatus = jsc.getRunningJobLocked();
        if (jobStatus == null) goto L11;
        if (jsc.isWithinExecutionGuaranteeTime() == true) goto L11;
        if (restriction.isJobRestricted(jobStatus, this.mService.evaluateJobBiasLocked(jobStatus)) == false) goto L11;
        jsc.cancelExecutingJobLocked(restriction.getStopReason(), restriction.getInternalReason(), JobParameters.getInternalReasonCodeDescription(restriction.getInternalReason()));
    L11:
        i = i - 1;
        goto L3
    }

    void markJobsForUserStopLocked(int userId, String packageName, String debugReason) {
        int i = this.mActiveServices.size() - 1;
    L3:
        if (i < 0) goto L13;
        JobServiceContext jsc = this.mActiveServices.get(i);
        JobStatus jobStatus = jsc.getRunningJobLocked();
        if (jobStatus == null) goto L11;
        if (userId != jobStatus.getUserId()) goto L11;
        if (jobStatus.getServiceComponent().getPackageName().equals(packageName) == false) goto L11;
        jsc.markForProcessDeathLocked(13, 11, debugReason);
    L11:
        i = i - 1;
        goto L3
    }

    void stopNonReadyActiveJobsLocked() {
        int i = 0;
    L4:
        if (i >= this.mActiveServices.size()) goto L21;
        JobServiceContext serviceContext = this.mActiveServices.get(i);
        JobStatus running = serviceContext.getRunningJobLocked();
        if (running == null) goto L19;
        if (running.isReady() == false) goto L11;
        JobRestriction restriction = this.mService.checkIfRestricted(running);
        if (restriction == null) goto L19;
        int internalReasonCode = restriction.getInternalReason();
        serviceContext.cancelExecutingJobLocked(restriction.getStopReason(), internalReasonCode, "restricted due to " + JobParameters.getInternalReasonCodeDescription(internalReasonCode));
        goto L19
    L11:
        if (running.getEffectiveStandbyBucket() == 5) goto L13;
    L15:
        serviceContext.cancelExecutingJobLocked(running.getStopReason(), 1, "cancelled due to unsatisfied constraints");
        goto L19
    L13:
        if (running.getStopReason() != 12) goto L15;
        serviceContext.cancelExecutingJobLocked(running.getStopReason(), 6, "cancelled due to restricted bucket");
    L19:
        i = i + 1;
        goto L4
    }

    private void noteConcurrency(boolean logForHistogram) {
        this.mService.mJobPackageTracker.noteConcurrency(this.mRunningJobs.size(), this.mWorkCountTracker.getRunningJobCount(1));
        if (logForHistogram == false) goto L6;
        sConcurrencyHistogramLogger.logSample(this.mActiveServices.size());
        return;
    }

    private void updateNonRunningPrioritiesLocked(PendingJobQueue jobQueue, boolean updateCounter) {
        jobQueue.resetIterator();
    L3:
        JobStatus pending = jobQueue.next();
        if (pending == null) goto L11;
        if (this.mRunningJobs.contains(pending) == true) goto L3;
        pending.lastEvaluatedBias = this.mService.evaluateJobBiasLocked(pending);
        if (updateCounter == false) goto L3;
        this.mWorkCountTracker.incrementPendingJobCount(getJobWorkTypes(pending));
        goto L3
    }

    private PackageStats getPkgStatsLocked(int userId, String packageName) {
        PackageStats packageStats = (PackageStats) this.mActivePkgStats.get(userId, packageName);
        if (packageStats != null) goto L8;
        packageStats = (PackageStats) this.mPkgStatsPool.acquire();
        if (packageStats != null) goto L7;
        packageStats = new PackageStats();
    L7:
        PackageStats.m4811$$Nest$msetPackage(packageStats, userId, packageName);
    L8:
        return packageStats;
    }

    boolean isPkgConcurrencyLimitedLocked(JobStatus jobStatus) {
        if (jobStatus.lastEvaluatedBias < 40) goto L6;
        return false;
    L6:
        if ((this.mService.getPendingJobQueue().size() + this.mRunningJobs.size()) >= this.mWorkTypeConfig.getMaxTotal()) goto L8;
        return false;
    L8:
        PackageStats packageStats = (PackageStats) this.mActivePkgStats.get(jobStatus.getSourceUserId(), jobStatus.getSourcePackageName());
        if (packageStats != null) goto L12;
        return false;
    L12:
        if (jobStatus.shouldTreatAsExpeditedJob() == false) goto L18;
        if ((packageStats.numRunningEj + packageStats.numStagedEj) >= this.mPkgConcurrencyLimitEj) goto L16;
        return false;
    L16:
        return true;
    L18:
        if ((packageStats.numRunningRegular + packageStats.numStagedRegular) >= this.mPkgConcurrencyLimitRegular) goto L20;
        return false;
    L20:
        return true;
    }

    private void startJobLocked(JobServiceContext worker, JobStatus jobStatus, int workType) {
        List<StateController> controllers = this.mService.mControllers;
        int numControllers = controllers.size();
        PowerManager.WakeLock wl = this.mPowerManager.newWakeLock(1, jobStatus.getWakelockTag());
        wl.setWorkSource(this.mService.deriveWorkSource(jobStatus.getSourceUid(), jobStatus.getSourcePackageName()));
        wl.setReferenceCounted(false);
        wl.acquire();
        int ic = 0;
    L3:
        if (ic >= numControllers) goto L7;
        controllers.get(ic).prepareForExecutionLocked(jobStatus);     // Catch: Throwable -> L5
        ic = ic + 1;     // Catch: Throwable -> L5
    L5:
        th = move-exception;
        wl.release();
        throw th;
    L7:
        PackageStats packageStats = getPkgStatsLocked(jobStatus.getSourceUserId(), jobStatus.getSourcePackageName());     // Catch: Throwable -> L5
        PackageStats.m4808$$Nest$madjustStagedCount(packageStats, false, jobStatus.shouldTreatAsExpeditedJob());     // Catch: Throwable -> L5
        if (worker.executeRunnableJob(jobStatus, workType) == true) goto L13;
        Slog.e(TAG, "Error executing " + jobStatus);     // Catch: Throwable -> L5
        this.mWorkCountTracker.onStagedJobFailed(workType);     // Catch: Throwable -> L5
        int ic2 = 0;
    L10:
        if (ic2 >= numControllers) goto L15;
        controllers.get(ic2).unprepareFromExecutionLocked(jobStatus);     // Catch: Throwable -> L5
        ic2 = ic2 + 1;     // Catch: Throwable -> L5
    L15:
        if (this.mService.getPendingJobQueue().remove(jobStatus) == false) goto L17;
        this.mService.mJobPackageTracker.noteNonpending(jobStatus);     // Catch: Throwable -> L5
    L17:
        wl.release();
        return;
    L13:
        this.mRunningJobs.add(jobStatus);     // Catch: Throwable -> L5
        this.mActiveServices.add(worker);     // Catch: Throwable -> L5
        this.mIdleContexts.remove(worker);     // Catch: Throwable -> L5
        this.mWorkCountTracker.onJobStarted(workType);     // Catch: Throwable -> L5
        PackageStats.m4807$$Nest$madjustRunningCount(packageStats, true, jobStatus.shouldTreatAsExpeditedJob());     // Catch: Throwable -> L5
        this.mActivePkgStats.add(jobStatus.getSourceUserId(), jobStatus.getSourcePackageName(), packageStats);     // Catch: Throwable -> L5
        this.mService.resetPendingJobReasonsCache(jobStatus);     // Catch: Throwable -> L5
        goto L15
    }

    void onJobCompletedLocked(JobServiceContext worker, JobStatus jobStatus, int workType) {
        this.mWorkCountTracker.onJobFinished(workType);
        this.mRunningJobs.remove(jobStatus);
        this.mActiveServices.remove(worker);
        boolean respectConcurrencyLimit = true;
        if (this.mIdleContexts.size() >= 96) goto L5;
        this.mIdleContexts.add(worker);
    L6:
        PackageStats packageStats = (PackageStats) this.mActivePkgStats.get(jobStatus.getSourceUserId(), jobStatus.getSourcePackageName());
        if (packageStats != null) goto L9;
        Slog.wtf(TAG, "Running job didn't have an active PackageStats object");
    L14:
        PendingJobQueue pendingJobQueue = this.mService.getPendingJobQueue();
        if (pendingJobQueue.size() != 0) goto L19;
        worker.clearPreferredUid();
        noteConcurrency(false);
        return;
    L19:
        if (this.mActiveServices.size() >= this.mSteadyStateConcurrencyLimit) goto L21;
    L50:
        String r9 = "Already running similar job to: ";
        if (worker.getPreferredUid() == (-1)) goto L113;
        updateCounterConfigLocked();
        updateNonRunningPrioritiesLocked(pendingJobQueue, false);
        JobStatus highestBiasJob = null;
        int highBiasWorkType = workType;
        int highBiasAllWorkTypes = workType;
        JobStatus backupJob = null;
        pendingJobQueue.resetIterator();
        int backupAllWorkTypes = 0;
        int backupWorkType = 0;
    L53:
        JobStatus nextPending = pendingJobQueue.next();
        if (nextPending == null) goto L96;
        int backupAllWorkTypes2 = backupAllWorkTypes;
        if (this.mRunningJobs.contains(nextPending) == true) goto L57;
        if (nextPending.isReady() == false) goto L64;
        if (DEBUG == true) goto L70;
    L72:
        String r19 = r9;
        if (worker.getPreferredUid() != nextPending.getUid()) goto L74;
        if (nextPending.lastEvaluatedBias <= jobStatus.lastEvaluatedBias) goto L84;
    L86:
        if (highestBiasJob == null) goto L91;
        if (highestBiasJob.lastEvaluatedBias < nextPending.lastEvaluatedBias) goto L91;
    L90:
        backupAllWorkTypes = backupAllWorkTypes2;
        r9 = r19;
    L91:
        highestBiasJob = nextPending;
        highBiasAllWorkTypes = getJobWorkTypes(nextPending);
        int workAsType = this.mWorkCountTracker.canJobStart(highBiasAllWorkTypes);
        if (workAsType != 0) goto L94;
        int highBiasWorkType2 = workType;
    L95:
        highBiasWorkType = highBiasWorkType2;
        backupAllWorkTypes = backupAllWorkTypes2;
        r9 = r19;
        goto L53
    L94:
        highBiasWorkType2 = workAsType;
        goto L95
    L84:
        if (isPkgConcurrencyLimitedLocked(nextPending) == false) goto L86;
    L74:
        if (backupJob != null) goto L90;
        if (isPkgConcurrencyLimitedLocked(nextPending) == true) goto L90;
        int allWorkTypes = getJobWorkTypes(nextPending);
        int workAsType2 = this.mWorkCountTracker.canJobStart(allWorkTypes);
        if (workAsType2 == 0) goto L80;
        backupJob = nextPending;
        backupWorkType = workAsType2;
        backupAllWorkTypes2 = allWorkTypes;
    L80:
        backupAllWorkTypes = backupAllWorkTypes2;
        r9 = r19;
        goto L53
    L70:
        if (isSimilarJobRunningLocked(nextPending) == false) goto L72;
        Slog.w(TAG, r9 + nextPending);
        goto L72
    L64:
        if (DEBUG == false) goto L66;
        Slog.w(TAG, "Pending+not ready job: " + nextPending);
    L66:
        pendingJobQueue.remove(nextPending);
        r19 = r9;
        goto L90
    L57:
        Slog.wtf(TAG, "Pending queue contained a running job");
        if (DEBUG == false) goto L60;
        Slog.e(TAG, "Pending+running job: " + nextPending);
    L60:
        pendingJobQueue.remove(nextPending);
        r19 = r9;
        goto L90
    L96:
        int backupAllWorkTypes3 = backupAllWorkTypes;
        if (highestBiasJob == null) goto L103;
        if (DEBUG == false) goto L101;
        Slog.d(TAG, "Running job " + highestBiasJob + " as preemption");
    L101:
        this.mWorkCountTracker.stageJob(highBiasWorkType, highBiasAllWorkTypes);
        startJobLocked(worker, highestBiasJob, highBiasWorkType);
    L152:
        noteConcurrency(false);
        return;
    L103:
        if (DEBUG == false) goto L105;
        Slog.d(TAG, "Couldn't find preemption job for uid " + worker.getPreferredUid());
    L105:
        worker.clearPreferredUid();
        if (backupJob == null) goto L152;
        if (DEBUG == false) goto L110;
        Slog.d(TAG, "Running job " + backupJob + " instead");
    L110:
        this.mWorkCountTracker.stageJob(backupWorkType, backupAllWorkTypes3);
        startJobLocked(worker, backupJob, backupWorkType);
        goto L152
    L113:
        String r110 = "Already running similar job to: ";
        if (pendingJobQueue.size() <= 0) goto L152;
        updateCounterConfigLocked();
        updateNonRunningPrioritiesLocked(pendingJobQueue, false);
        JobStatus highestBiasJob2 = null;
        int highBiasWorkType3 = workType;
        int highBiasAllWorkTypes2 = workType;
        pendingJobQueue.resetIterator();
    L116:
        JobStatus nextPending2 = pendingJobQueue.next();
        if (nextPending2 == null) goto L147;
        if (this.mRunningJobs.contains(nextPending2) == true) goto L120;
        if (nextPending2.isReady() == false) goto L127;
        if (DEBUG == true) goto L133;
    L135:
        String r13 = r110;
    L137:
        if (isPkgConcurrencyLimitedLocked(nextPending2) == true) goto L141;
        int allWorkTypes2 = getJobWorkTypes(nextPending2);
        int workAsType3 = this.mWorkCountTracker.canJobStart(allWorkTypes2);
        if (workAsType3 == 0) goto L141;
        if (highestBiasJob2 != null) goto L144;
    L145:
        highBiasAllWorkTypes2 = allWorkTypes2;
        highBiasWorkType3 = workAsType3;
        highestBiasJob2 = nextPending2;
    L146:
        r110 = r13;
        goto L116
    L144:
        if (highestBiasJob2.lastEvaluatedBias >= nextPending2.lastEvaluatedBias) goto L146;
    L141:
        r110 = r13;
        goto L116
    L133:
        if (isSimilarJobRunningLocked(nextPending2) == false) goto L135;
        StringBuilder r6 = new StringBuilder();
        r13 = r110;
        r6.append(r13);
        r6.append(nextPending2);
        Slog.w(TAG, r6.toString());
        goto L137
    L127:
        if (DEBUG == false) goto L129;
        Slog.w(TAG, "Pending+not ready job: " + nextPending2);
    L129:
        pendingJobQueue.remove(nextPending2);
        r13 = r110;
        goto L141
    L120:
        Slog.wtf(TAG, "Pending queue contained a running job");
        if (DEBUG == false) goto L123;
        Slog.e(TAG, "Pending+running job: " + nextPending2);
    L123:
        pendingJobQueue.remove(nextPending2);
        r13 = r110;
        goto L141
    L147:
        if (highestBiasJob2 == null) goto L152;
        if (DEBUG == false) goto L151;
        Slog.d(TAG, "About to run job: " + highestBiasJob2);
    L151:
        this.mWorkCountTracker.stageJob(highBiasWorkType3, highBiasAllWorkTypes2);
        startJobLocked(worker, highestBiasJob2, highBiasWorkType3);
        goto L152
    L21:
        if (this.mMaxWaitTimeBypassEnabled == true) goto L23;
        respectConcurrencyLimit = true;
    L47:
        if (respectConcurrencyLimit == false) goto L50;
        worker.clearPreferredUid();
        noteConcurrency(false);
        return;
    L23:
        long minWaitingTimeMs = Long.MAX_VALUE;
        long nowElapsed = JobSchedulerService.sElapsedRealtimeClock.millis();
        int i = this.mActiveServices.size() - 1;
    L24:
        if (i < 0) goto L27;
        minWaitingTimeMs = Math.min(minWaitingTimeMs, this.mActiveServices.get(i).getRemainingGuaranteedTimeMs(nowElapsed));
        i = i - 1;
        goto L24
    L27:
        if (this.mWorkCountTracker.getPendingJobCount(4) <= 0) goto L34;
        if (minWaitingTimeMs < this.mMaxWaitUIMs) goto L31;
        boolean wouldBeWaitingTooLong = true;
    L44:
        if (wouldBeWaitingTooLong == false) goto L47;
        respectConcurrencyLimit = false;
        goto L47
    L31:
        wouldBeWaitingTooLong = false;
        goto L44
    L34:
        if (this.mWorkCountTracker.getPendingJobCount(8) <= 0) goto L41;
        if (minWaitingTimeMs < this.mMaxWaitEjMs) goto L38;
        wouldBeWaitingTooLong = true;
        goto L44
    L38:
        wouldBeWaitingTooLong = false;
        goto L44
    L41:
        if (minWaitingTimeMs < this.mMaxWaitRegularMs) goto L43;
        wouldBeWaitingTooLong = true;
        goto L44
    L43:
        wouldBeWaitingTooLong = false;
        goto L44
    L9:
        PackageStats.m4807$$Nest$madjustRunningCount(packageStats, false, jobStatus.startedAsExpeditedJob);
        if (packageStats.numRunningEj > 0) goto L14;
        if (packageStats.numRunningRegular > 0) goto L14;
        this.mActivePkgStats.delete(packageStats.userId, packageStats.packageName);
        this.mPkgStatsPool.release(packageStats);
        goto L14
    L5:
        this.mNumDroppedContexts++;
        goto L6
    }

    String shouldStopRunningJobLocked(JobServiceContext context) {
        JobStatus js = context.getRunningJobLocked();
        if (js != null) goto L6;
        return null;
    L6:
        if (context.isWithinExecutionGuaranteeTime() == false) goto L9;
        return null;
    L9:
        if (this.mPowerManager.isPowerSaveMode() == false) goto L13;
        return "battery saver";
    L13:
        if (this.mPowerManager.isDeviceIdleMode() == false) goto L16;
        return "deep doze";
    L16:
        JobRestriction jobRestriction = this.mService.checkIfRestricted(js);
        if (jobRestriction != null) goto L19;
        updateCounterConfigLocked();
        int workType = context.getRunningJobWorkType();
        if (this.mRunningJobs.size() <= this.mWorkTypeConfig.getMaxTotal()) goto L23;
        return "too many jobs running";
    L23:
        if (this.mWorkCountTracker.isOverTypeLimit(workType) == true) goto L92;
        PendingJobQueue pendingJobQueue = this.mService.getPendingJobQueue();
        int numPending = pendingJobQueue.size();
        if (numPending != 0) goto L29;
        return null;
    L29:
        if (js.shouldTreatAsExpeditedJob() == true) goto L52;
        if (js.startedAsExpeditedJob == true) goto L52;
        if (this.mWorkCountTracker.getPendingJobCount(workType) > 0) goto L36;
        int remainingWorkTypes = 127;
        pendingJobQueue.resetIterator();
    L38:
        JobStatus pending = pendingJobQueue.next();
        if (pending == null) goto L50;
        int workTypes = getJobWorkTypes(pending);
        if ((workTypes & remainingWorkTypes) > 0) goto L43;
    L46:
        remainingWorkTypes = remainingWorkTypes & (~workTypes);
        if (remainingWorkTypes != 0) goto L38;
    L43:
        if (this.mWorkCountTracker.canJobStart(workTypes, workType) == 0) goto L46;
        return "blocking other pending jobs";
    L50:
        return null;
    L36:
        return "blocking " + workTypeToString(workType) + " queue";
    L52:
        if (workType == 32) goto L73;
        if (workType == 64) goto L73;
        if (this.mWorkCountTracker.getPendingJobCount(8) <= 0) goto L61;
        return "blocking " + workTypeToString(8) + " queue";
    L61:
        if (js.startedWithImmediacyPrivilege == false) goto L82;
        int immediacyPrivilegeCount = 0;
        int r = this.mRunningJobs.size() - 1;
    L63:
        if (r < 0) goto L69;
        JobStatus j = this.mRunningJobs.valueAt(r);
        if (j.startedWithImmediacyPrivilege == false) goto L67;
        immediacyPrivilegeCount = immediacyPrivilegeCount + 1;
    L67:
        r = r - 1;
        goto L63
    L69:
        if (immediacyPrivilegeCount <= (this.mWorkTypeConfig.getMaxTotal() / 2)) goto L82;
        return "prevent immediacy privilege dominance";
    L82:
        return null;
    L73:
        if (this.mWorkCountTracker.getPendingJobCount(32) <= 0) goto L77;
        return "blocking " + workTypeToString(32) + " queue";
    L77:
        if (this.mWorkCountTracker.getPendingJobCount(8) <= 0) goto L82;
        if (this.mWorkCountTracker.canJobStart(8, workType) == 0) goto L82;
        return "blocking " + workTypeToString(8) + " queue";
    L92:
        return "too many jobs running";
    L19:
        return "restriction:" + JobParameters.getInternalReasonCodeDescription(jobRestriction.getInternalReason());
    }

    boolean executeStopCommandLocked(PrintWriter pw, String pkgName, int userId, String namespace, boolean matchJobId, int jobId, int stopReason, int internalStopReason) {
        boolean foundSome = false;
        int i = 0;
    L4:
        if (i >= this.mActiveServices.size()) goto L12;
        JobServiceContext jc = this.mActiveServices.get(i);
        JobStatus js = jc.getRunningJobLocked();
        if (js == null) goto L10;
        if (jc.stopIfExecutingLocked(pkgName, userId, namespace, matchJobId, jobId, stopReason, internalStopReason) == false) goto L10;
        foundSome = true;
        pw.print("Stopping job: ");
        js.printUniqueId(pw);
        pw.print(" ");
        pw.println(js.getServiceComponent().flattenToShortString());
    L10:
        i = i + 1;
        goto L4
    L12:
        return foundSome;
    }

    Pair<Long, Long> getEstimatedNetworkBytesLocked(String pkgName, int uid, String namespace, int jobId) {
        int i = 0;
    L4:
        if (i >= this.mActiveServices.size()) goto L14;
        JobServiceContext jc = this.mActiveServices.get(i);
        JobStatus js = jc.getRunningJobLocked();
        if (js == null) goto L13;
        if (js.matches(uid, namespace, jobId) == false) goto L13;
        if (js.getSourcePackageName().equals(pkgName) == false) goto L13;
        return jc.getEstimatedNetworkBytes();
    L13:
        i = i + 1;
        goto L4
    L14:
        return null;
    }

    Pair<Long, Long> getTransferredNetworkBytesLocked(String pkgName, int uid, String namespace, int jobId) {
        int i = 0;
    L4:
        if (i >= this.mActiveServices.size()) goto L14;
        JobServiceContext jc = this.mActiveServices.get(i);
        JobStatus js = jc.getRunningJobLocked();
        if (js == null) goto L13;
        if (js.matches(uid, namespace, jobId) == false) goto L13;
        if (js.getSourcePackageName().equals(pkgName) == false) goto L13;
        return jc.getTransferredNetworkBytes();
    L13:
        i = i + 1;
        goto L4
    L14:
        return null;
    }

    boolean isNotificationAssociatedWithAnyUserInitiatedJobs(int notificationId, int userId, String packageName) {
        return this.mNotificationCoordinator.isNotificationAssociatedWithAnyUserInitiatedJobs(notificationId, userId, packageName);
    }

    boolean isNotificationChannelAssociatedWithAnyUserInitiatedJobs(String notificationChannel, int userId, String packageName) {
        return this.mNotificationCoordinator.isNotificationChannelAssociatedWithAnyUserInitiatedJobs(notificationChannel, userId, packageName);
    }

    private JobServiceContext createNewJobServiceContext() {
        return this.mInjector.createJobServiceContext(this.mService, this, this.mNotificationCoordinator, IBatteryStats.Stub.asInterface(ServiceManager.getService("batterystats")), this.mService.mJobPackageTracker, AppSchedulingModuleThread.get().getLooper());
    }

    private String printPendingQueueLocked() {
        StringBuilder s = new StringBuilder("Pending queue: ");
        PendingJobQueue pendingJobQueue = this.mService.getPendingJobQueue();
        pendingJobQueue.resetIterator();
    L3:
        JobStatus js = pendingJobQueue.next();
        if (js == null) goto L7;
        s.append("(");
        s.append("{");
        s.append(js.getNamespace());
        s.append("} ");
        s.append(js.getJob().getId());
        s.append(", ");
        s.append(js.getUid());
        s.append(") ");
        goto L3
    L7:
        return s.toString();
    }

    private static String printAssignments(String header, Collection<ContextAssignment>... list) {
        StringBuilder s = new StringBuilder(header + ": ");
        int l = 0;
    L4:
        if (l >= list.length) goto L25;
        Collection<ContextAssignment> assignments = list[l];
        int c = 0;
        Iterator<ContextAssignment> r4 = assignments.iterator();
    L7:
        if (r4.hasNext() == false) goto L23;
        ContextAssignment assignment = r4.next();
        if (assignment.newJob != null) goto L11;
        JobStatus job = assignment.context.getRunningJobLocked();
    L12:
        if (l > 0) goto L14;
        if (c > 0) goto L14;
    L15:
        s.append("(");
        s.append(assignment.context.getId());
        s.append("=");
        if (job != null) goto L19;
        s.append("nothing");
    L22:
        s.append(")");
        c = c + 1;
        goto L7
    L19:
        if (job.getNamespace() == null) goto L21;
        s.append(job.getNamespace());
        s.append(":");
    L21:
        s.append(job.getJobId());
        s.append(SliceClientPermissions.SliceAuthority.DELIMITER);
        s.append(job.getUid());
    L14:
        s.append(" ");
        goto L15
    L11:
        job = assignment.newJob;
        goto L12
    L23:
        l = l + 1;
        goto L4
    L25:
        return s.toString();
    }

    void updateConfigLocked() {
        DeviceConfig.Properties properties = DeviceConfig.getProperties("jobscheduler", new String[0]);
        this.mSteadyStateConcurrencyLimit = Math.max(1, Math.min(64, properties.getInt(KEY_CONCURRENCY_LIMIT, DEFAULT_CONCURRENCY_LIMIT)));
        this.mScreenOffAdjustmentDelayMs = properties.getLong(KEY_SCREEN_OFF_ADJUSTMENT_DELAY_MS, 30000);
        CONFIG_LIMITS_SCREEN_ON.normal.update(properties, this.mSteadyStateConcurrencyLimit);
        CONFIG_LIMITS_SCREEN_ON.moderate.update(properties, this.mSteadyStateConcurrencyLimit);
        CONFIG_LIMITS_SCREEN_ON.low.update(properties, this.mSteadyStateConcurrencyLimit);
        CONFIG_LIMITS_SCREEN_ON.critical.update(properties, this.mSteadyStateConcurrencyLimit);
        CONFIG_LIMITS_SCREEN_OFF.normal.update(properties, this.mSteadyStateConcurrencyLimit);
        CONFIG_LIMITS_SCREEN_OFF.moderate.update(properties, this.mSteadyStateConcurrencyLimit);
        CONFIG_LIMITS_SCREEN_OFF.low.update(properties, this.mSteadyStateConcurrencyLimit);
        CONFIG_LIMITS_SCREEN_OFF.critical.update(properties, this.mSteadyStateConcurrencyLimit);
        this.mPkgConcurrencyLimitEj = Math.max(1, Math.min(this.mSteadyStateConcurrencyLimit, properties.getInt(KEY_PKG_CONCURRENCY_LIMIT_EJ, 3)));
        this.mPkgConcurrencyLimitRegular = Math.max(1, Math.min(this.mSteadyStateConcurrencyLimit, properties.getInt(KEY_PKG_CONCURRENCY_LIMIT_REGULAR, DEFAULT_PKG_CONCURRENCY_LIMIT_REGULAR)));
        this.mMaxWaitTimeBypassEnabled = properties.getBoolean(KEY_ENABLE_MAX_WAIT_TIME_BYPASS, true);
        this.mMaxWaitUIMs = Math.max(0, properties.getLong(KEY_MAX_WAIT_UI_MS, 300000));
        this.mMaxWaitEjMs = Math.max(this.mMaxWaitUIMs, properties.getLong(KEY_MAX_WAIT_EJ_MS, 300000));
        this.mMaxWaitRegularMs = Math.max(this.mMaxWaitEjMs, properties.getLong(KEY_MAX_WAIT_REGULAR_MS, 1800000));
    }

    public void dumpLocked(final IndentingPrintWriter pw, long now, long nowRealtime) {
        pw.println("Concurrency:");
        pw.increaseIndent();
        pw.println("Configuration:");     // Catch: Throwable -> L14
        pw.increaseIndent();     // Catch: Throwable -> L14
        pw.print(KEY_CONCURRENCY_LIMIT, Integer.valueOf(this.mSteadyStateConcurrencyLimit)).println();     // Catch: Throwable -> L14
        pw.print(KEY_SCREEN_OFF_ADJUSTMENT_DELAY_MS, Long.valueOf(this.mScreenOffAdjustmentDelayMs)).println();     // Catch: Throwable -> L14
        pw.print(KEY_PKG_CONCURRENCY_LIMIT_EJ, Integer.valueOf(this.mPkgConcurrencyLimitEj)).println();     // Catch: Throwable -> L14
        pw.print(KEY_PKG_CONCURRENCY_LIMIT_REGULAR, Integer.valueOf(this.mPkgConcurrencyLimitRegular)).println();     // Catch: Throwable -> L14
        pw.print(KEY_ENABLE_MAX_WAIT_TIME_BYPASS, Boolean.valueOf(this.mMaxWaitTimeBypassEnabled)).println();     // Catch: Throwable -> L14
        pw.print(KEY_MAX_WAIT_UI_MS, Long.valueOf(this.mMaxWaitUIMs)).println();     // Catch: Throwable -> L14
        pw.print(KEY_MAX_WAIT_EJ_MS, Long.valueOf(this.mMaxWaitEjMs)).println();     // Catch: Throwable -> L14
        pw.print(KEY_MAX_WAIT_REGULAR_MS, Long.valueOf(this.mMaxWaitRegularMs)).println();     // Catch: Throwable -> L14
        pw.println();     // Catch: Throwable -> L14
        CONFIG_LIMITS_SCREEN_ON.normal.dump(pw);     // Catch: Throwable -> L14
        pw.println();     // Catch: Throwable -> L14
        CONFIG_LIMITS_SCREEN_ON.moderate.dump(pw);     // Catch: Throwable -> L14
        pw.println();     // Catch: Throwable -> L14
        CONFIG_LIMITS_SCREEN_ON.low.dump(pw);     // Catch: Throwable -> L14
        pw.println();     // Catch: Throwable -> L14
        CONFIG_LIMITS_SCREEN_ON.critical.dump(pw);     // Catch: Throwable -> L14
        pw.println();     // Catch: Throwable -> L14
        CONFIG_LIMITS_SCREEN_OFF.normal.dump(pw);     // Catch: Throwable -> L14
        pw.println();     // Catch: Throwable -> L14
        CONFIG_LIMITS_SCREEN_OFF.moderate.dump(pw);     // Catch: Throwable -> L14
        pw.println();     // Catch: Throwable -> L14
        CONFIG_LIMITS_SCREEN_OFF.low.dump(pw);     // Catch: Throwable -> L14
        pw.println();     // Catch: Throwable -> L14
        CONFIG_LIMITS_SCREEN_OFF.critical.dump(pw);     // Catch: Throwable -> L14
        pw.println();     // Catch: Throwable -> L14
        pw.decreaseIndent();     // Catch: Throwable -> L14
        pw.print("Screen state: current ");     // Catch: Throwable -> L14
        String r1 = "OFF";
        if (this.mCurrentInteractiveState == false) goto L7;
        String r0 = "ON";
    L8:
        pw.print(r0);     // Catch: Throwable -> L14
        pw.print("  effective ");     // Catch: Throwable -> L14
        if (this.mEffectiveInteractiveState == false) goto L11;
        r1 = "ON";
    L11:
        pw.print(r1);     // Catch: Throwable -> L14
        pw.println();     // Catch: Throwable -> L14
        pw.print("Last screen ON: ");     // Catch: Throwable -> L14
        TimeUtils.dumpTimeWithDelta(pw, (now - nowRealtime) + this.mLastScreenOnRealtime, now);     // Catch: Throwable -> L14
        pw.println();     // Catch: Throwable -> L14
        pw.print("Last screen OFF: ");     // Catch: Throwable -> L14
        TimeUtils.dumpTimeWithDelta(pw, (now - nowRealtime) + this.mLastScreenOffRealtime, now);     // Catch: Throwable -> L14
        pw.println();     // Catch: Throwable -> L14
        pw.println();     // Catch: Throwable -> L14
        pw.print("Current work counts: ");     // Catch: Throwable -> L14
        pw.println(this.mWorkCountTracker);     // Catch: Throwable -> L14
        pw.println();     // Catch: Throwable -> L14
        pw.print("mLastMemoryTrimLevel: ");     // Catch: Throwable -> L14
        pw.println(this.mLastMemoryTrimLevel);     // Catch: Throwable -> L14
        pw.println();     // Catch: Throwable -> L14
        pw.println("Active Package stats:");     // Catch: Throwable -> L14
        pw.increaseIndent();     // Catch: Throwable -> L14
        this.mActivePkgStats.forEach(new JobConcurrencyManager$$ExternalSyntheticLambda3(pw));     // Catch: Throwable -> L14
        pw.decreaseIndent();     // Catch: Throwable -> L14
        pw.println();     // Catch: Throwable -> L14
        pw.print("User Grace Period: ");     // Catch: Throwable -> L14
        pw.println(this.mGracePeriodObserver.mGracePeriodExpiration);     // Catch: Throwable -> L14
        pw.println();     // Catch: Throwable -> L14
        this.mStatLogger.dump(pw);     // Catch: Throwable -> L14
        pw.decreaseIndent();
        return;
    L7:
        r0 = "OFF";
    L14:
        th = move-exception;
        pw.decreaseIndent();
        throw th;
    }

    private static /* synthetic */ void lambda$dumpLocked$1(IndentingPrintWriter pw, PackageStats pkgStats) {
        PackageStats.m4809$$Nest$mdumpLocked(pkgStats, pw);
    }

    void dumpContextInfoLocked(IndentingPrintWriter pw, Predicate<JobStatus> predicate, long nowElapsed, long nowUptime) {
        pw.println("Active jobs:");
        pw.increaseIndent();
        if (this.mActiveServices.size() != 0) goto L5;
        pw.println("N/A");
    L5:
        int i = 0;
    L7:
        if (i >= this.mActiveServices.size()) goto L17;
        JobServiceContext jsc = this.mActiveServices.get(i);
        JobStatus job = jsc.getRunningJobLocked();
        if (job != null) goto L11;
    L13:
        pw.print("Slot #");
        pw.print(i);
        pw.print("(ID=");
        pw.print(jsc.getId());
        pw.print("): ");
        jsc.dumpLocked(pw, nowElapsed);
        if (job == null) goto L16;
        pw.increaseIndent();
        pw.increaseIndent();
        job.dump(pw, false, nowElapsed);
        pw.decreaseIndent();
        pw.print("Evaluated bias: ");
        pw.println(JobInfo.getBiasString(job.lastEvaluatedBias));
        pw.print("Active at ");
        TimeUtils.formatDuration(job.madeActive - nowUptime, pw);
        pw.print(", pending for ");
        TimeUtils.formatDuration(job.madeActive - job.madePending, pw);
        pw.decreaseIndent();
        pw.println();
    L16:
        i = i + 1;
        goto L7
    L11:
        if (predicate.test(job) == true) goto L13;
    L17:
        pw.decreaseIndent();
        pw.println();
        pw.print("Idle contexts (");
        pw.print(this.mIdleContexts.size());
        pw.println("):");
        pw.increaseIndent();
        int i2 = 0;
    L19:
        if (i2 >= this.mIdleContexts.size()) goto L21;
        JobServiceContext jsc2 = this.mIdleContexts.valueAt(i2);
        pw.print("ID=");
        pw.print(jsc2.getId());
        pw.print(": ");
        jsc2.dumpLocked(pw, nowElapsed);
        i2 = i2 + 1;
        goto L19
    L21:
        pw.decreaseIndent();
        if (this.mNumDroppedContexts <= 0) goto L30;
        pw.println();
        pw.print("Dropped ");
        pw.print(this.mNumDroppedContexts);
        pw.println(" contexts");
        return;
    }

    public void dumpProtoLocked(ProtoOutputStream proto, long tag, long now, long nowRealtime) {
        long token = proto.start(tag);
        proto.write(1133871366145L, this.mCurrentInteractiveState);
        proto.write(1133871366146L, this.mEffectiveInteractiveState);
        proto.write(1112396529667L, nowRealtime - this.mLastScreenOnRealtime);
        proto.write(1112396529668L, nowRealtime - this.mLastScreenOffRealtime);
        proto.write(1120986464262L, this.mLastMemoryTrimLevel);
        this.mStatLogger.dumpProto(proto, 1146756268039L);
        proto.end(token);
    }

    boolean shouldRunAsFgUserJob(JobStatus job) {
        if (this.mShouldRestrictBgUser == true) goto L5;
        return true;
    L5:
        int userId = job.getSourceUserId();
        UserInfo userInfo = this.mUserManagerInternal.getUserInfo(userId);
        if (userInfo.profileGroupId != (-10000)) goto L8;
    L10:
        int currentUser = this.mActivityManagerInternal.getCurrentUserId();
        if (currentUser != userId) goto L13;
        return true;
    L13:
        if (userInfo.isPrimary() == false) goto L15;
        return true;
    L15:
        if (this.mGracePeriodObserver.isWithinGracePeriodForUser(userId) == true) goto L22;
        return false;
    L22:
        return true;
    L8:
        if (userInfo.profileGroupId == userId) goto L10;
        userId = userInfo.profileGroupId;
        userInfo = this.mUserManagerInternal.getUserInfo(userId);
        goto L10
    }

    int getJobWorkTypes(JobStatus js) {
        int classification = 0;
        if (shouldRunAsFgUserJob(js) == false) goto L18;
        if (js.lastEvaluatedBias < 40) goto L8;
        int classification2 = 0 | 1;
    L12:
        if (js.shouldTreatAsExpeditedJob() == false) goto L15;
        return classification2 | 8;
    L15:
        if (js.shouldTreatAsUserInitiatedJob() == true) goto L28;
        return classification2;
    L28:
        return classification2 | 4;
    L8:
        if (js.lastEvaluatedBias < 35) goto L10;
        classification2 = 0 | 2;
        goto L12
    L10:
        classification2 = 0 | 16;
        goto L12
    L18:
        if (js.lastEvaluatedBias < 35) goto L20;
    L23:
        classification = 0 | 32;
    L25:
        return classification | 64;
    L20:
        if (js.shouldTreatAsExpeditedJob() == true) goto L23;
        if (js.shouldTreatAsUserInitiatedJob() == false) goto L25;
        goto L23
    }

    void addRunningJobForTesting(JobStatus job) {
        this.mRunningJobs.add(job);
        PackageStats packageStats = getPackageStatsForTesting(job.getSourceUserId(), job.getSourcePackageName());
        PackageStats.m4807$$Nest$madjustRunningCount(packageStats, true, job.shouldTreatAsExpeditedJob());
        if (this.mIdleContexts.size() <= 0) goto L5;
        JobServiceContext context = this.mIdleContexts.removeAt(this.mIdleContexts.size() - 1);
    L6:
        context.executeRunnableJob(job, this.mWorkCountTracker.canJobStart(getJobWorkTypes(job)));
        this.mActiveServices.add(context);
        return;
    L5:
        context = createNewJobServiceContext();
        goto L6
    }

    int getPackageConcurrencyLimitEj() {
        return this.mPkgConcurrencyLimitEj;
    }

    int getPackageConcurrencyLimitRegular() {
        return this.mPkgConcurrencyLimitRegular;
    }

    PackageStats getPackageStatsForTesting(int userId, String packageName) {
        PackageStats packageStats = getPkgStatsLocked(userId, packageName);
        this.mActivePkgStats.add(userId, packageName, packageStats);
        return packageStats;
    }
}
