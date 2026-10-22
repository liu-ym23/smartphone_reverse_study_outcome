package com.android.server.job.controllers;

import android.app.usage.UsageStatsManagerInternal;
import android.appwidget.AppWidgetManager;
import android.content.Context;
import android.content.pm.UserPackage;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.UserHandle;
import android.provider.DeviceConfig;
import android.util.ArraySet;
import android.util.IndentingPrintWriter;
import android.util.Log;
import android.util.Slog;
import android.util.SparseArrayMap;
import android.util.TimeUtils;
import com.android.internal.os.SomeArgs;
import com.android.server.AppSchedulingModuleThread;
import com.android.server.LocalServices;
import com.android.server.job.JobSchedulerService;
import com.android.server.utils.AlarmQueue;
import java.util.function.Predicate;

/* JADX INFO: loaded from: classes2.dex */
public class PrefetchController extends StateController {
    private static final boolean DEBUG = false;
    private static final int MSG_PROCESS_TOP_STATE_CHANGE = 2;
    private static final int MSG_PROCESS_UPDATED_ESTIMATED_LAUNCH_TIME = 1;
    private static final int MSG_RETRIEVE_ESTIMATED_LAUNCH_TIME = 0;
    private static final String TAG = "JobScheduler.Prefetch";
    private AppWidgetManager mAppWidgetManager;
    private final UsageStatsManagerInternal.EstimatedLaunchTimeChangedListener mEstimatedLaunchTimeChangedListener;
    private final SparseArrayMap<String, Long> mEstimatedLaunchTimes;
    private final PcHandler mHandler;
    private long mLaunchTimeAllowanceMs;
    private long mLaunchTimeThresholdMs;
    private final PcConstants mPcConstants;
    private final ArraySet<PrefetchChangedListener> mPrefetchChangedListeners;
    private final ThresholdAlarmListener mThresholdAlarmListener;
    private final SparseArrayMap<String, ArraySet<JobStatus>> mTrackedJobs;
    private final UsageStatsManagerInternal mUsageStatsManagerInternal;

    class PcConstants {
        private static final long DEFAULT_LAUNCH_TIME_ALLOWANCE_MS = 1800000;
        private static final long DEFAULT_LAUNCH_TIME_THRESHOLD_MS = 3600000;
        static final String KEY_LAUNCH_TIME_ALLOWANCE_MS = "pc_launch_time_allowance_ms";
        static final String KEY_LAUNCH_TIME_THRESHOLD_MS = "pc_launch_time_threshold_ms";
        private static final String PC_CONSTANT_PREFIX = "pc_";
        public long LAUNCH_TIME_ALLOWANCE_MS;
        public long LAUNCH_TIME_THRESHOLD_MS;
        private boolean mShouldReevaluateConstraints;
        final /* synthetic */ PrefetchController this$0;

        /* JADX INFO: renamed from: -$$Nest$fgetmShouldReevaluateConstraints, reason: not valid java name */
        static /* bridge */ /* synthetic */ boolean m5010$$Nest$fgetmShouldReevaluateConstraints(PcConstants r0) {
            return r0.mShouldReevaluateConstraints;
        }

        /* JADX INFO: renamed from: -$$Nest$fputmShouldReevaluateConstraints, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m5011$$Nest$fputmShouldReevaluateConstraints(PcConstants r0, boolean r1) {
            r0.mShouldReevaluateConstraints = r1;
        }

        /* JADX INFO: renamed from: -$$Nest$mdump, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m5012$$Nest$mdump(PcConstants r0, IndentingPrintWriter r1) {
            r0.dump(r1);
        }

        PcConstants(PrefetchController this$0) {
            this.this$0 = this$0;
            this.mShouldReevaluateConstraints = false;
            this.LAUNCH_TIME_THRESHOLD_MS = 3600000;
            this.LAUNCH_TIME_ALLOWANCE_MS = 1800000;
        }

        public void processConstantLocked(DeviceConfig.Properties properties, String key) {
            switch(key.hashCode()) {
                case 1521894047: goto L9;
                case 1566126444: goto L6;
                default: goto L11;
            };
        L11:
            byte r0 = -1;
        L12:
            switch(r0) {
                case 0: goto L17;
                case 1: goto L14;
                default: goto L24;
            };
        L14:
            this.LAUNCH_TIME_THRESHOLD_MS = properties.getLong(key, 3600000);
            long newLaunchTimeThresholdMs = Math.min(86400000, Math.max(3600000, this.LAUNCH_TIME_THRESHOLD_MS));
            if (PrefetchController.m4998$$Nest$fgetmLaunchTimeThresholdMs(this.this$0) == newLaunchTimeThresholdMs) goto L21;
            PrefetchController.m5003$$Nest$fputmLaunchTimeThresholdMs(this.this$0, newLaunchTimeThresholdMs);
            this.mShouldReevaluateConstraints = true;
            PrefetchController.m4999$$Nest$fgetmThresholdAlarmListener(this.this$0).setMinTimeBetweenAlarmsMs(PrefetchController.m4998$$Nest$fgetmLaunchTimeThresholdMs(this.this$0) / 10);
            return;
        L21:
            return;
        L17:
            this.LAUNCH_TIME_ALLOWANCE_MS = properties.getLong(key, 1800000);
            long newLaunchTimeAllowanceMs = Math.min(7200000, Math.max(0, this.LAUNCH_TIME_ALLOWANCE_MS));
            if (PrefetchController.m4997$$Nest$fgetmLaunchTimeAllowanceMs(this.this$0) == newLaunchTimeAllowanceMs) goto L23;
            PrefetchController.m5002$$Nest$fputmLaunchTimeAllowanceMs(this.this$0, newLaunchTimeAllowanceMs);
            this.mShouldReevaluateConstraints = true;
            return;
        L23:
            return;
        L24:
            return;
        L6:
            if (key.equals(KEY_LAUNCH_TIME_THRESHOLD_MS) == false) goto L11;
            r0 = 1;
            goto L12
        L9:
            if (key.equals(KEY_LAUNCH_TIME_ALLOWANCE_MS) == false) goto L11;
            r0 = 0;
            goto L12
        }

        private void dump(IndentingPrintWriter pw) {
            pw.println();
            pw.print(PrefetchController.class.getSimpleName());
            pw.println(":");
            pw.increaseIndent();
            pw.print(KEY_LAUNCH_TIME_THRESHOLD_MS, Long.valueOf(this.LAUNCH_TIME_THRESHOLD_MS)).println();
            pw.print(KEY_LAUNCH_TIME_ALLOWANCE_MS, Long.valueOf(this.LAUNCH_TIME_ALLOWANCE_MS)).println();
            pw.decreaseIndent();
        }
    }

    private class PcHandler extends Handler {
        final /* synthetic */ PrefetchController this$0;

        PcHandler(PrefetchController r1, Looper looper) {
            this.this$0 = r1;
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            switch(msg.what) {
                case 0: goto L7;
                case 1: goto L6;
                case 2: goto L5;
                default: goto L28;
            };
        L5:
            int uid = msg.arg1;
            PrefetchController.m5005$$Nest$mmaybeUpdateConstraintForUid(this.this$0, uid);
            return;
        L6:
            SomeArgs args = (SomeArgs) msg.obj;
            PrefetchController.m5006$$Nest$mprocessUpdatedEstimatedLaunchTime(this.this$0, args.argi1, (String) args.arg1, args.argl1);
            args.recycle();
            return;
        L7:
            int userId = msg.arg1;
            String pkgName = (String) msg.obj;
            long nextEstimatedLaunchTime = PrefetchController.m5001$$Nest$fgetmUsageStatsManagerInternal(this.this$0).getEstimatedPackageLaunchTime(pkgName, userId);
            if (PrefetchController.m5009$$Nest$sfgetDEBUG() == false) goto L10;
            Slog.d(PrefetchController.TAG, "Retrieved launch time for " + StateController.packageToString(userId, pkgName) + " of " + nextEstimatedLaunchTime + " (" + TimeUtils.formatDuration(nextEstimatedLaunchTime - JobSchedulerService.sSystemClock.millis()) + " from now)");
        L10:
            Object r4 = this.this$0.mLock;
            monitor-enter(r4);
            Long curEstimatedLaunchTime = (Long) PrefetchController.m4995$$Nest$fgetmEstimatedLaunchTimes(this.this$0).get(userId, pkgName);     // Catch: Throwable -> L17
            if (curEstimatedLaunchTime != null) goto L15;
        L19:
            PrefetchController.m5006$$Nest$mprocessUpdatedEstimatedLaunchTime(this.this$0, userId, pkgName, nextEstimatedLaunchTime);     // Catch: Throwable -> L17
        L20:
            monitor-exit(r4);     // Catch: Throwable -> L17
            return;
        L15:
            if (nextEstimatedLaunchTime == curEstimatedLaunchTime.longValue()) goto L20;
        L17:
            th = move-exception;
            throw th;
        }
    }

    public interface PrefetchChangedListener {
        void onPrefetchCacheUpdated(ArraySet<JobStatus> r1, int r2, String r3, long r4, long r6, long r8);
    }

    private class ThresholdAlarmListener extends AlarmQueue<UserPackage> {
        final /* synthetic */ PrefetchController this$0;

        /* synthetic */ ThresholdAlarmListener(PrefetchController r1, Context r2, Looper r3, PrefetchControllerIA r4) {
            this(r1, r2, r3);
        }

        @Override // com.android.server.utils.AlarmQueue
        protected /* bridge */ /* synthetic */ boolean isForUser(UserPackage r1, int r2) {
            return isForUser2(r1, r2);
        }

        private ThresholdAlarmListener(PrefetchController r9, Context context, Looper looper) {
            this.this$0 = r9;
            super(context, looper, "*job.prefetch*", "Prefetch threshold", false, 360000);
        }

        /* JADX INFO: renamed from: isForUser, reason: avoid collision after fix types in other method */
        protected boolean isForUser2(UserPackage key, int userId) {
            if (key.userId != userId) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.android.server.utils.AlarmQueue
        protected void processExpiredAlarms(ArraySet<UserPackage> expired) {
            ArraySet<JobStatus> changedJobs = new ArraySet();
            Object r2 = this.this$0.mLock;
            monitor-enter(r2);
            long now = JobSchedulerService.sSystemClock.millis();     // Catch: Throwable -> L10
            long now2 = JobSchedulerService.sElapsedRealtimeClock.millis();     // Catch: Throwable -> L10
            int i = 0;
        L6:
            if (i >= expired.size()) goto L17;
            UserPackage p = expired.valueAt(i);     // Catch: Throwable -> L10
            if (PrefetchController.m5008$$Nest$mwillBeLaunchedSoonLocked(this.this$0, p.userId, p.packageName, now) == true) goto L12;
            Slog.e(PrefetchController.TAG, "Alarm expired for " + StateController.packageToString(p.userId, p.packageName) + " at the wrong time");     // Catch: Throwable -> L10
            long nowElapsed = now2;
            long nowElapsed2 = now;
            PrefetchController.m5007$$Nest$mupdateThresholdAlarmLocked(this.this$0, p.userId, p.packageName, nowElapsed2, nowElapsed);     // Catch: Throwable -> L10
        L15:
            i = i + 1;     // Catch: Throwable -> L10
            now = nowElapsed2;
            now2 = nowElapsed;
            goto L6
        L12:
            long nowElapsed3 = now2;
            long nowElapsed4 = now;
            boolean r4 = PrefetchController.m5004$$Nest$mmaybeUpdateConstraintForPkgLocked(this.this$0, nowElapsed4, nowElapsed3, p.userId, p.packageName);     // Catch: Throwable -> L10
            nowElapsed = nowElapsed3;
            nowElapsed2 = nowElapsed4;
            if (r4 == false) goto L15;
            changedJobs.addAll((ArraySet) PrefetchController.m5000$$Nest$fgetmTrackedJobs(this.this$0).get(p.userId, p.packageName));     // Catch: Throwable -> L10
            goto L15
        L17:
            monitor-exit(r2);     // Catch: Throwable -> L10
            if (changedJobs.size() <= 0) goto L30;
            this.this$0.mStateChangedListener.onControllerStateChanged(changedJobs);
            return;
        L30:
            return;
        L10:
            th = move-exception;
            throw th;
        }
    }

    public static /* synthetic */ void $r8$lambda$BFFxIkqJJt_2lyMqlqgaHSZOKzI(Predicate r0, IndentingPrintWriter r1, ArraySet r2) {
        lambda$dumpControllerStateLocked$1(r0, r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$gh1bNa_9ifjYJLmF_wg478zhPO0(PrefetchController r0) {
        r0.lambda$onConstantsUpdatedLocked$0();
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmEstimatedLaunchTimes, reason: not valid java name */
    static /* bridge */ /* synthetic */ SparseArrayMap m4995$$Nest$fgetmEstimatedLaunchTimes(PrefetchController r0) {
        return r0.mEstimatedLaunchTimes;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmHandler, reason: not valid java name */
    static /* bridge */ /* synthetic */ PcHandler m4996$$Nest$fgetmHandler(PrefetchController r0) {
        return r0.mHandler;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmLaunchTimeAllowanceMs, reason: not valid java name */
    static /* bridge */ /* synthetic */ long m4997$$Nest$fgetmLaunchTimeAllowanceMs(PrefetchController r2) {
        return r2.mLaunchTimeAllowanceMs;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmLaunchTimeThresholdMs, reason: not valid java name */
    static /* bridge */ /* synthetic */ long m4998$$Nest$fgetmLaunchTimeThresholdMs(PrefetchController r2) {
        return r2.mLaunchTimeThresholdMs;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmThresholdAlarmListener, reason: not valid java name */
    static /* bridge */ /* synthetic */ ThresholdAlarmListener m4999$$Nest$fgetmThresholdAlarmListener(PrefetchController r0) {
        return r0.mThresholdAlarmListener;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmTrackedJobs, reason: not valid java name */
    static /* bridge */ /* synthetic */ SparseArrayMap m5000$$Nest$fgetmTrackedJobs(PrefetchController r0) {
        return r0.mTrackedJobs;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmUsageStatsManagerInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ UsageStatsManagerInternal m5001$$Nest$fgetmUsageStatsManagerInternal(PrefetchController r0) {
        return r0.mUsageStatsManagerInternal;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmLaunchTimeAllowanceMs, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5002$$Nest$fputmLaunchTimeAllowanceMs(PrefetchController r0, long r1) {
        r0.mLaunchTimeAllowanceMs = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmLaunchTimeThresholdMs, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5003$$Nest$fputmLaunchTimeThresholdMs(PrefetchController r0, long r1) {
        r0.mLaunchTimeThresholdMs = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$mmaybeUpdateConstraintForPkgLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m5004$$Nest$mmaybeUpdateConstraintForPkgLocked(PrefetchController r0, long r1, long r3, int r5, String r6) {
        return r0.maybeUpdateConstraintForPkgLocked(r1, r3, r5, r6);
    }

    /* JADX INFO: renamed from: -$$Nest$mmaybeUpdateConstraintForUid, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5005$$Nest$mmaybeUpdateConstraintForUid(PrefetchController r0, int r1) {
        r0.maybeUpdateConstraintForUid(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mprocessUpdatedEstimatedLaunchTime, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5006$$Nest$mprocessUpdatedEstimatedLaunchTime(PrefetchController r0, int r1, String r2, long r3) {
        r0.processUpdatedEstimatedLaunchTime(r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateThresholdAlarmLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5007$$Nest$mupdateThresholdAlarmLocked(PrefetchController r0, int r1, String r2, long r3, long r5) {
        r0.updateThresholdAlarmLocked(r1, r2, r3, r5);
    }

    /* JADX INFO: renamed from: -$$Nest$mwillBeLaunchedSoonLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m5008$$Nest$mwillBeLaunchedSoonLocked(PrefetchController r0, int r1, String r2, long r3) {
        return r0.willBeLaunchedSoonLocked(r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetDEBUG, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m5009$$Nest$sfgetDEBUG() {
        return DEBUG;
    }

    static {
        if (JobSchedulerService.DEBUG == false) goto L5;
    L8:
        boolean r0 = true;
    L9:
        DEBUG = r0;
        return;
    L5:
        if (Log.isLoggable(TAG, 3) == true) goto L8;
        r0 = false;
        goto L9
    }

    public PrefetchController(JobSchedulerService service) {
        super(service);
        this.mTrackedJobs = new SparseArrayMap();
        this.mEstimatedLaunchTimes = new SparseArrayMap();
        this.mPrefetchChangedListeners = new ArraySet();
        this.mLaunchTimeThresholdMs = 3600000;
        this.mLaunchTimeAllowanceMs = 1800000;
        this.mEstimatedLaunchTimeChangedListener = new AnonymousClass1(this);
        this.mPcConstants = new PcConstants(this);
        this.mHandler = new PcHandler(this, AppSchedulingModuleThread.get().getLooper());
        this.mThresholdAlarmListener = new ThresholdAlarmListener(this, this.mContext, AppSchedulingModuleThread.get().getLooper(), null);
        this.mUsageStatsManagerInternal = (UsageStatsManagerInternal) LocalServices.getService(UsageStatsManagerInternal.class);
    }

    @Override // com.android.server.job.controllers.StateController
    public void startTrackingLocked() {
        this.mUsageStatsManagerInternal.registerLaunchTimeChangedListener(this.mEstimatedLaunchTimeChangedListener);
    }

    @Override // com.android.server.job.controllers.StateController
    public void onSystemServicesReady() {
        this.mAppWidgetManager = (AppWidgetManager) this.mContext.getSystemService(AppWidgetManager.class);
    }

    @Override // com.android.server.job.controllers.StateController
    public void maybeStartTrackingJobLocked(JobStatus jobStatus, JobStatus lastJob) {
        if (jobStatus.getJob().isPrefetch() == false) goto L16;
        int userId = jobStatus.getSourceUserId();
        String pkgName = jobStatus.getSourcePackageName();
        ArraySet<JobStatus> jobs = (ArraySet) this.mTrackedJobs.get(userId, pkgName);
        if (jobs != null) goto L7;
        jobs = new ArraySet();
        this.mTrackedJobs.add(userId, pkgName, jobs);
    L7:
        long now = JobSchedulerService.sSystemClock.millis();
        long nowElapsed = JobSchedulerService.sElapsedRealtimeClock.millis();
        if (jobs.add(jobStatus) == true) goto L10;
    L14:
        updateConstraintLocked(jobStatus, now, nowElapsed);
        return;
    L10:
        if (jobs.size() != 1) goto L14;
        if (willBeLaunchedSoonLocked(userId, pkgName, now) == true) goto L14;
        updateThresholdAlarmLocked(userId, pkgName, now, nowElapsed);
        goto L14
    }

    @Override // com.android.server.job.controllers.StateController
    public void maybeStopTrackingJobLocked(JobStatus jobStatus, JobStatus incomingJob) {
        int userId = jobStatus.getSourceUserId();
        String pkgName = jobStatus.getSourcePackageName();
        ArraySet<JobStatus> jobs = (ArraySet) this.mTrackedJobs.get(userId, pkgName);
        if (jobs != null) goto L5;
        return;
    L5:
        if (jobs.remove(jobStatus) == true) goto L7;
        return;
    L7:
        if (jobs.size() != 0) goto L12;
        this.mThresholdAlarmListener.removeAlarmForKey(UserPackage.of(userId, pkgName));
        return;
    }

    @Override // com.android.server.job.controllers.StateController
    public void onAppRemovedLocked(String packageName, int uid) {
        if (packageName != null) goto L5;
        Slog.wtf(TAG, "Told app removed but given null package name.");
        return;
    L5:
        int userId = UserHandle.getUserId(uid);
        this.mTrackedJobs.delete(userId, packageName);
        this.mEstimatedLaunchTimes.delete(userId, packageName);
        this.mThresholdAlarmListener.removeAlarmForKey(UserPackage.of(userId, packageName));
    }

    @Override // com.android.server.job.controllers.StateController
    public void onUserRemovedLocked(int userId) {
        this.mTrackedJobs.delete(userId);
        this.mEstimatedLaunchTimes.delete(userId);
        this.mThresholdAlarmListener.removeAlarmsForUserId(userId);
    }

    @Override // com.android.server.job.controllers.StateController
    public void onUidBiasChangedLocked(int uid, int prevBias, int newBias) {
        boolean wasTop = true;
        if (newBias != 40) goto L5;
        boolean isNowTop = true;
    L6:
        if (prevBias == 40) goto L9;
        wasTop = false;
    L9:
        if (isNowTop == wasTop) goto L12;
        this.mHandler.obtainMessage(2, uid, 0).sendToTarget();
        return;
    L12:
        return;
    L5:
        isNowTop = false;
        goto L6
    }

    public long getNextEstimatedLaunchTimeLocked(JobStatus jobStatus) {
        int userId = jobStatus.getSourceUserId();
        String pkgName = jobStatus.getSourcePackageName();
        return getNextEstimatedLaunchTimeLocked(userId, pkgName, JobSchedulerService.sSystemClock.millis());
    }

    private long getNextEstimatedLaunchTimeLocked(int userId, String pkgName, long now) {
        Long nextEstimatedLaunchTime = (Long) this.mEstimatedLaunchTimes.get(userId, pkgName);
        if (nextEstimatedLaunchTime != null) goto L5;
    L9:
        this.mHandler.obtainMessage(0, userId, 0, pkgName).sendToTarget();
        this.mEstimatedLaunchTimes.add(userId, pkgName, Long.MAX_VALUE);
        return Long.MAX_VALUE;
    L5:
        if (nextEstimatedLaunchTime.longValue() < (now - this.mLaunchTimeAllowanceMs)) goto L9;
        return nextEstimatedLaunchTime.longValue();
    }

    private boolean maybeUpdateConstraintForPkgLocked(long now, long nowElapsed, int userId, String pkgName) {
        ArraySet<JobStatus> jobs = (ArraySet) this.mTrackedJobs.get(userId, pkgName);
        if (jobs != null) goto L6;
        return false;
    L6:
        boolean changed = false;
        int i = 0;
    L8:
        if (i >= jobs.size()) goto L11;
        JobStatus js = jobs.valueAt(i);
        changed = changed | updateConstraintLocked(js, now, nowElapsed);
        i = i + 1;
        goto L8
    L11:
        return changed;
    }

    private void maybeUpdateConstraintForUid(int uid) {
        Object r7 = this.mLock;
        monitor-enter(r7);
        ArraySet<String> pkgs = this.mService.getPackagesForUidLocked(uid);     // Catch: Throwable -> L10
        if (pkgs != null) goto L12;
        monitor-exit(r7);     // Catch: Throwable -> L10
        return;
    L12:
        int userId = UserHandle.getUserId(uid);     // Catch: Throwable -> L10
        ArraySet<JobStatus> changedJobs = new ArraySet();     // Catch: Throwable -> L10
        long now = JobSchedulerService.sSystemClock.millis();     // Catch: Throwable -> L10
        long nowElapsed = JobSchedulerService.sElapsedRealtimeClock.millis();     // Catch: Throwable -> L10
        int p = pkgs.size() - 1;     // Catch: Throwable -> L10
    L13:
        if (p < 0) goto L26;
        String pkgName = pkgs.valueAt(p);     // Catch: Throwable -> L10
        ArraySet<JobStatus> jobs = (ArraySet) this.mTrackedJobs.get(userId, pkgName);     // Catch: Throwable -> L10
        if (jobs == null) goto L24;
        int i = 0;
    L19:
        if (i >= jobs.size()) goto L24;
        JobStatus js = jobs.valueAt(i);     // Catch: Throwable -> L10
        if (updateConstraintLocked(js, now, nowElapsed) == false) goto L23;
        changedJobs.add(js);     // Catch: Throwable -> L10
    L23:
        i = i + 1;     // Catch: Throwable -> L10
    L24:
        p = p - 1;     // Catch: Throwable -> L10
        goto L13
    L26:
        if (changedJobs.size() <= 0) goto L28;
        this.mStateChangedListener.onControllerStateChanged(changedJobs);     // Catch: Throwable -> L10
    L28:
        monitor-exit(r7);     // Catch: Throwable -> L10
        return;
    L10:
        th = th;
    L32:
        monitor-exit(r7);     // Catch: Throwable -> L10
        throw th;
    L30:
        th = th;
        goto L32
    }

    private void processUpdatedEstimatedLaunchTime(int userId, String pkgName, long newEstimatedLaunchTime) {
        long prevEstimatedLaunchTime = newEstimatedLaunchTime;
        if (DEBUG == false) goto L5;
        Slog.d(TAG, "Estimated launch time for " + StateController.packageToString(userId, pkgName) + " changed to " + prevEstimatedLaunchTime + " (" + TimeUtils.formatDuration(prevEstimatedLaunchTime - JobSchedulerService.sSystemClock.millis()) + " from now)");
    L5:
        Object r10 = this.mLock;
        monitor-enter(r10);
        ArraySet<JobStatus> jobs = (ArraySet) this.mTrackedJobs.get(userId, pkgName);     // Catch: Throwable -> L12
        if (jobs == null) goto L10;
        long prevEstimatedLaunchTime2 = ((Long) this.mEstimatedLaunchTimes.get(userId, pkgName)).longValue();     // Catch: Throwable -> L12
        this.mEstimatedLaunchTimes.add(userId, pkgName, Long.valueOf(prevEstimatedLaunchTime));     // Catch: Throwable -> L12
        if (jobs.isEmpty() == true) goto L29;
        long now = JobSchedulerService.sSystemClock.millis();     // Catch: Throwable -> L12
        long nowElapsed = JobSchedulerService.sElapsedRealtimeClock.millis();     // Catch: Throwable -> L12
        updateThresholdAlarmLocked(userId, pkgName, now, nowElapsed);     // Catch: Throwable -> L12
        long prevEstimatedLaunchTime3 = nowElapsed;
        int i = 0;
    L34:
    L22:
        th = th;
    L31:
        monitor-exit(r10);     // Catch: Throwable -> L12
        throw th;
    L19:
        if (i >= this.mPrefetchChangedListeners.size()) goto L26;
        PrefetchChangedListener r2 = this.mPrefetchChangedListeners.valueAt(i);     // Catch: Throwable -> L22
        long r6 = prevEstimatedLaunchTime;
        long nowElapsed2 = prevEstimatedLaunchTime3;
        long nowElapsed3 = prevEstimatedLaunchTime2;
        int i2 = i;
        ArraySet<JobStatus> jobs2 = jobs;
        r2.onPrefetchCacheUpdated(jobs2, userId, pkgName, nowElapsed3, r6, nowElapsed2);     // Catch: Throwable -> L22
        prevEstimatedLaunchTime3 = nowElapsed2;
        jobs = jobs2;
        i = i2 + 1;
        prevEstimatedLaunchTime2 = nowElapsed3;
        prevEstimatedLaunchTime = newEstimatedLaunchTime;
        goto L34
    L26:
        if (maybeUpdateConstraintForPkgLocked(now, prevEstimatedLaunchTime3, userId, pkgName) == false) goto L29;
        this.mStateChangedListener.onControllerStateChanged(jobs);     // Catch: Throwable -> L12
    L29:
        monitor-exit(r10);     // Catch: Throwable -> L12
        return;
    L10:
        if (DEBUG == false) goto L29;
        Slog.i(TAG, "Not caching launch time since we haven't seen any prefetch jobs for " + StateController.packageToString(userId, pkgName));     // Catch: Throwable -> L12
    L12:
        th = th;
        goto L31
    }

    private boolean updateConstraintLocked(JobStatus jobStatus, long now, long nowElapsed) {
        boolean satisfied = false;
        if (this.mService.getUidBias(jobStatus.getSourceUid()) != 40) goto L5;
        boolean appIsOpen = true;
    L6:
        if (appIsOpen == true) goto L17;
        int userId = jobStatus.getSourceUserId();
        String pkgName = jobStatus.getSourcePackageName();
        if (willBeLaunchedSoonLocked(userId, pkgName, now) == false) goto L10;
    L15:
        satisfied = true;
    L19:
        return jobStatus.setPrefetchConstraintSatisfied(nowElapsed, satisfied);
    L10:
        if (this.mAppWidgetManager == null) goto L19;
        if (this.mAppWidgetManager.isBoundWidgetPackage(pkgName, userId) == false) goto L19;
    L17:
        satisfied = this.mService.isCurrentlyRunningLocked(jobStatus);
        goto L19
    L5:
        appIsOpen = false;
        goto L6
    }

    private void updateThresholdAlarmLocked(int userId, String pkgName, long now, long nowElapsed) {
        ArraySet<JobStatus> jobs = (ArraySet) this.mTrackedJobs.get(userId, pkgName);
        if (jobs != null) goto L5;
    L14:
        this.mThresholdAlarmListener.removeAlarmForKey(UserPackage.of(userId, pkgName));
        return;
    L5:
        if (jobs.size() == 0) goto L14;
        long nextEstimatedLaunchTime = getNextEstimatedLaunchTimeLocked(userId, pkgName, now);
        if (nextEstimatedLaunchTime != Long.MAX_VALUE) goto L10;
    L12:
        this.mThresholdAlarmListener.removeAlarmForKey(UserPackage.of(userId, pkgName));
        return;
    L10:
        if ((nextEstimatedLaunchTime - now) <= this.mLaunchTimeThresholdMs) goto L12;
        long timeToCrossThresholdMs = nextEstimatedLaunchTime - (this.mLaunchTimeThresholdMs + now);
        this.mThresholdAlarmListener.addAlarm(UserPackage.of(userId, pkgName), nowElapsed + timeToCrossThresholdMs);
    }

    private boolean willBeLaunchedSoonLocked(int userId, String pkgName, long now) {
        if (getNextEstimatedLaunchTimeLocked(userId, pkgName, now) > ((this.mLaunchTimeThresholdMs + now) - this.mLaunchTimeAllowanceMs)) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.android.server.job.controllers.StateController
    public void prepareForUpdatedConstantsLocked() {
        PcConstants.m5011$$Nest$fputmShouldReevaluateConstraints(this.mPcConstants, false);
    }

    @Override // com.android.server.job.controllers.StateController
    public void processConstantLocked(DeviceConfig.Properties properties, String key) {
        this.mPcConstants.processConstantLocked(properties, key);
    }

    @Override // com.android.server.job.controllers.StateController
    public void onConstantsUpdatedLocked() {
        if (PcConstants.m5010$$Nest$fgetmShouldReevaluateConstraints(this.mPcConstants) == false) goto L6;
        AppSchedulingModuleThread.getHandler().post(new PrefetchController$$ExternalSyntheticLambda0(this));
        return;
    }

    private /* synthetic */ void lambda$onConstantsUpdatedLocked$0() {
        ArraySet<JobStatus> changedJobs = new ArraySet();
        Object r2 = this.mLock;
        monitor-enter(r2);
        long now = JobSchedulerService.sElapsedRealtimeClock.millis();     // Catch: Throwable -> L21
        long now2 = JobSchedulerService.sSystemClock.millis();     // Catch: Throwable -> L21
        int u = 0;
    L6:
        if (u >= this.mTrackedJobs.numMaps()) goto L25;
        int userId = this.mTrackedJobs.keyAt(u);     // Catch: Throwable -> L21
        int p = 0;
    L9:
        if (p >= this.mTrackedJobs.numElementsForKey(userId)) goto L23;
        String packageName = (String) this.mTrackedJobs.keyAt(u, p);     // Catch: Throwable -> L21
    L15:
        th = th;
    L30:
        monitor-exit(r2);     // Catch: Throwable -> L15
        throw th;
    L13:
        if (maybeUpdateConstraintForPkgLocked(now2, now, userId, packageName) == false) goto L18;
        changedJobs.addAll((ArraySet) this.mTrackedJobs.valueAt(u, p));     // Catch: Throwable -> L15
    L18:
        if (willBeLaunchedSoonLocked(userId, packageName, now2) == true) goto L20;
        long now3 = now2;
        int userId2 = userId;
        long nowElapsed = now;
        updateThresholdAlarmLocked(userId2, packageName, now3, nowElapsed);     // Catch: Throwable -> L15
        userId = userId2;
        now2 = now3;
        now = nowElapsed;
    L20:
        p = p + 1;     // Catch: Throwable -> L15
        goto L9
    L23:
        u = u + 1;     // Catch: Throwable -> L15
        goto L6
    L25:
        monitor-exit(r2);     // Catch: Throwable -> L15
        if (changedJobs.size() <= 0) goto L39;
        this.mStateChangedListener.onControllerStateChanged(changedJobs);
        return;
    L39:
        return;
    L21:
        th = th;
        goto L30
    }

    void registerPrefetchChangedListener(PrefetchChangedListener listener) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mPrefetchChangedListeners.add(listener);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    void unRegisterPrefetchChangedListener(PrefetchChangedListener listener) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mPrefetchChangedListeners.remove(listener);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    long getLaunchTimeAllowanceMs() {
        return this.mLaunchTimeAllowanceMs;
    }

    long getLaunchTimeThresholdMs() {
        return this.mLaunchTimeThresholdMs;
    }

    PcConstants getPcConstants() {
        return this.mPcConstants;
    }

    @Override // com.android.server.job.controllers.StateController
    public void dumpControllerStateLocked(final IndentingPrintWriter pw, final Predicate<JobStatus> predicate) {
        long now = JobSchedulerService.sSystemClock.millis();
        pw.println("Cached launch times:");
        pw.increaseIndent();
        int u = 0;
    L4:
        if (u >= this.mEstimatedLaunchTimes.numMaps()) goto L10;
        int userId = this.mEstimatedLaunchTimes.keyAt(u);
        int p = 0;
    L7:
        if (p >= this.mEstimatedLaunchTimes.numElementsForKey(userId)) goto L9;
        String pkgName = (String) this.mEstimatedLaunchTimes.keyAt(u, p);
        long estimatedLaunchTime = ((Long) this.mEstimatedLaunchTimes.valueAt(u, p)).longValue();
        pw.print(StateController.packageToString(userId, pkgName));
        pw.print(": ");
        pw.print(estimatedLaunchTime);
        pw.print(" (");
        TimeUtils.formatDuration(estimatedLaunchTime - now, pw, 19);
        pw.println(" from now)");
        p = p + 1;
        goto L7
    L9:
        u = u + 1;
        goto L4
    L10:
        pw.decreaseIndent();
        pw.println();
        this.mTrackedJobs.forEach(new PrefetchController$$ExternalSyntheticLambda1(predicate, pw));
        pw.println();
        this.mThresholdAlarmListener.dump(pw);
    }

    private static /* synthetic */ void lambda$dumpControllerStateLocked$1(Predicate predicate, IndentingPrintWriter pw, ArraySet jobs) {
        int j = 0;
    L4:
        if (j >= jobs.size()) goto L11;
        JobStatus js = (JobStatus) jobs.valueAt(j);
        if (predicate.test(js) == false) goto L9;
        pw.print("#");
        js.printUniqueId(pw);
        pw.print(" from ");
        UserHandle.formatUid(pw, js.getSourceUid());
        pw.println();
    L9:
        j = j + 1;
        goto L4
    }

    @Override // com.android.server.job.controllers.StateController
    public void dumpConstants(IndentingPrintWriter pw) {
        PcConstants.m5012$$Nest$mdump(this.mPcConstants, pw);
    }
}
