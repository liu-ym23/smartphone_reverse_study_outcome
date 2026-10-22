package com.android.server.job.controllers;

import android.R;
import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.PowerManager;
import android.os.UserHandle;
import android.provider.DeviceConfig;
import android.util.ArraySet;
import android.util.IndentingPrintWriter;
import android.util.Log;
import android.util.Slog;
import android.util.SparseBooleanArray;
import android.util.proto.ProtoOutputStream;
import com.android.internal.util.jobs.ArrayUtils;
import com.android.server.AppSchedulingModuleThread;
import com.android.server.DeviceIdleInternal;
import com.android.server.LocalServices;
import com.android.server.job.JobSchedulerService;
import com.android.server.pm.verify.domain.DomainVerificationPersistence;
import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Predicate;

/* JADX INFO: loaded from: classes2.dex */
public final class DeviceIdleJobsController extends StateController {
    private static final boolean DEBUG = false;
    private static final String DIJC_CONSTANT_PREFIX = "dijc_";
    private static final String KEY_BACKGROUND_JOBS_DELAY_MS = "dijc_background_jobs_delay_ms";
    static final int PROCESS_BACKGROUND_JOBS = 1;
    private static final String TAG = "JobScheduler.DeviceIdle";
    private final ArraySet<JobStatus> mAllowInIdleJobs;
    private long mBackgroundJobsDelay;
    private final BroadcastReceiver mBroadcastReceiver;
    private boolean mDeviceIdleMode;
    private final DeviceIdleUpdateFunctor mDeviceIdleUpdateFunctor;
    private int[] mDeviceIdleWhitelistAppIds;
    private final SparseBooleanArray mForegroundUids;
    private final DeviceIdleJobsDelayHandler mHandler;
    private final DeviceIdleInternal mLocalDeviceIdleController;
    private final PowerManager mPowerManager;
    private int[] mPowerSaveTempWhitelistAppIds;
    private final Predicate<JobStatus> mShouldRushEvaluation;

    final class DeviceIdleJobsDelayHandler extends Handler {
        final /* synthetic */ DeviceIdleJobsController this$0;

        public DeviceIdleJobsDelayHandler(DeviceIdleJobsController this$0, Looper looper) {
            this.this$0 = this$0;
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            switch(msg.what) {
                case 1: goto L5;
                default: goto L18;
            };
        L5:
            Object r0 = this.this$0.mLock;
            monitor-enter(r0);
            DeviceIdleJobsController.m4939$$Nest$fgetmDeviceIdleUpdateFunctor(this.this$0).prepare();     // Catch: Throwable -> L10
            this.this$0.mService.getJobStore().forEachJob(DeviceIdleJobsController.m4939$$Nest$fgetmDeviceIdleUpdateFunctor(this.this$0));     // Catch: Throwable -> L10
            if (DeviceIdleJobsController.m4939$$Nest$fgetmDeviceIdleUpdateFunctor(this.this$0).mChangedJobs.size() <= 0) goto L12;
            this.this$0.mStateChangedListener.onControllerStateChanged(DeviceIdleJobsController.m4939$$Nest$fgetmDeviceIdleUpdateFunctor(this.this$0).mChangedJobs);     // Catch: Throwable -> L10
        L12:
            monitor-exit(r0);     // Catch: Throwable -> L10
            return;
        L10:
            th = move-exception;
            throw th;
        }
    }

    final class DeviceIdleUpdateFunctor implements Consumer<JobStatus> {
        final ArraySet<JobStatus> mChangedJobs;
        long mUpdateTimeElapsed;
        final /* synthetic */ DeviceIdleJobsController this$0;

        DeviceIdleUpdateFunctor(DeviceIdleJobsController this$0) {
            this.this$0 = this$0;
            this.mChangedJobs = new ArraySet();
            this.mUpdateTimeElapsed = 0;
        }

        @Override // java.util.function.Consumer
        public /* bridge */ /* synthetic */ void accept(JobStatus r1) {
            accept2(r1);
        }

        void prepare() {
            this.mChangedJobs.clear();
            this.mUpdateTimeElapsed = JobSchedulerService.sElapsedRealtimeClock.millis();
        }

        /* JADX INFO: renamed from: accept, reason: avoid collision after fix types in other method */
        public void accept2(JobStatus jobStatus) {
            if (DeviceIdleJobsController.m4946$$Nest$mupdateTaskStateLocked(this.this$0, jobStatus, this.mUpdateTimeElapsed) == false) goto L6;
            this.mChangedJobs.add(jobStatus);
            return;
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$Q9EdxkMtHl-3qS60h2Bo2_oejDE, reason: not valid java name */
    public static /* synthetic */ boolean m4937$r8$lambda$Q9EdxkMtHl3qS60h2Bo2_oejDE(DeviceIdleJobsController r0, JobStatus r1) {
        return r0.lambda$new$0(r1);
    }

    public static /* synthetic */ void $r8$lambda$cj0sn9aHGVem_QZGinJ4MccfiBI(DeviceIdleJobsController r0, ProtoOutputStream r1, JobStatus r2) {
        r0.lambda$dumpControllerStateLocked$2(r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$ovm5qI3TjEGdNWAaHu0p8oTDJGA(DeviceIdleJobsController r0, IndentingPrintWriter r1, JobStatus r2) {
        r0.lambda$dumpControllerStateLocked$1(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmAllowInIdleJobs, reason: not valid java name */
    static /* bridge */ /* synthetic */ ArraySet m4938$$Nest$fgetmAllowInIdleJobs(DeviceIdleJobsController r0) {
        return r0.mAllowInIdleJobs;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmDeviceIdleUpdateFunctor, reason: not valid java name */
    static /* bridge */ /* synthetic */ DeviceIdleUpdateFunctor m4939$$Nest$fgetmDeviceIdleUpdateFunctor(DeviceIdleJobsController r0) {
        return r0.mDeviceIdleUpdateFunctor;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmDeviceIdleWhitelistAppIds, reason: not valid java name */
    static /* bridge */ /* synthetic */ int[] m4940$$Nest$fgetmDeviceIdleWhitelistAppIds(DeviceIdleJobsController r0) {
        return r0.mDeviceIdleWhitelistAppIds;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmLocalDeviceIdleController, reason: not valid java name */
    static /* bridge */ /* synthetic */ DeviceIdleInternal m4941$$Nest$fgetmLocalDeviceIdleController(DeviceIdleJobsController r0) {
        return r0.mLocalDeviceIdleController;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmPowerManager, reason: not valid java name */
    static /* bridge */ /* synthetic */ PowerManager m4942$$Nest$fgetmPowerManager(DeviceIdleJobsController r0) {
        return r0.mPowerManager;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmPowerSaveTempWhitelistAppIds, reason: not valid java name */
    static /* bridge */ /* synthetic */ int[] m4943$$Nest$fgetmPowerSaveTempWhitelistAppIds(DeviceIdleJobsController r0) {
        return r0.mPowerSaveTempWhitelistAppIds;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmDeviceIdleWhitelistAppIds, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4944$$Nest$fputmDeviceIdleWhitelistAppIds(DeviceIdleJobsController r0, int[] r1) {
        r0.mDeviceIdleWhitelistAppIds = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmPowerSaveTempWhitelistAppIds, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4945$$Nest$fputmPowerSaveTempWhitelistAppIds(DeviceIdleJobsController r0, int[] r1) {
        r0.mPowerSaveTempWhitelistAppIds = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateTaskStateLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m4946$$Nest$mupdateTaskStateLocked(DeviceIdleJobsController r0, JobStatus r1, long r2) {
        return r0.updateTaskStateLocked(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetDEBUG, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m4947$$Nest$sfgetDEBUG() {
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

    private /* synthetic */ boolean lambda$new$0(JobStatus jobStatus) {
        if (jobStatus.isRequestedExpeditedJob() == false) goto L5;
    L8:
        return true;
    L5:
        if (this.mForegroundUids.get(jobStatus.getSourceUid()) == true) goto L8;
        return false;
    }

    public DeviceIdleJobsController(JobSchedulerService service) {
        super(service);
        this.mForegroundUids = new SparseBooleanArray();
        this.mBroadcastReceiver = new AnonymousClass1(this);
        this.mShouldRushEvaluation = new DeviceIdleJobsController$$ExternalSyntheticLambda2(this);
        this.mBackgroundJobsDelay = this.mContext.getResources().getInteger(R.integer.config_letterboxDefaultPositionForHorizontalReachability);
        this.mHandler = new DeviceIdleJobsDelayHandler(this, AppSchedulingModuleThread.get().getLooper());
        this.mPowerManager = (PowerManager) this.mContext.getSystemService("power");
        this.mLocalDeviceIdleController = (DeviceIdleInternal) LocalServices.getService(DeviceIdleInternal.class);
        this.mDeviceIdleWhitelistAppIds = this.mLocalDeviceIdleController.getPowerSaveWhitelistUserAppIds();
        this.mPowerSaveTempWhitelistAppIds = this.mLocalDeviceIdleController.getPowerSaveTempWhitelistAppIds();
        this.mDeviceIdleUpdateFunctor = new DeviceIdleUpdateFunctor(this);
        this.mAllowInIdleJobs = new ArraySet();
        IntentFilter filter = new IntentFilter();
        filter.addAction("android.os.action.DEVICE_IDLE_MODE_CHANGED");
        filter.addAction("android.os.action.LIGHT_DEVICE_IDLE_MODE_CHANGED");
        filter.addAction("android.os.action.POWER_SAVE_WHITELIST_CHANGED");
        filter.addAction("android.os.action.POWER_SAVE_TEMP_WHITELIST_CHANGED");
        this.mContext.registerReceiverAsUser(this.mBroadcastReceiver, UserHandle.ALL, filter, null, null);
    }

    void updateIdleMode(boolean enabled) {
        boolean changed = false;
        Object r1 = this.mLock;
        monitor-enter(r1);
    L14:
        th = move-exception;
        throw th;
    L5:
        if (this.mDeviceIdleMode == enabled) goto L7;
        changed = true;
    L7:
        this.mDeviceIdleMode = enabled;     // Catch: Throwable -> L14
        if (this.mDeviceIdleMode == true) goto L10;
        boolean r2 = true;
    L11:
        logDeviceWideConstraintStateToStatsd(33554432, r2);     // Catch: Throwable -> L14
        if (DEBUG == false) goto L16;
        Slog.d(TAG, "mDeviceIdleMode=" + this.mDeviceIdleMode);     // Catch: Throwable -> L14
    L16:
        this.mDeviceIdleUpdateFunctor.prepare();     // Catch: Throwable -> L14
        if (enabled == false) goto L19;
        this.mHandler.removeMessages(1);     // Catch: Throwable -> L14
        this.mService.getJobStore().forEachJob(this.mDeviceIdleUpdateFunctor);     // Catch: Throwable -> L14
    L20:
        monitor-exit(r1);     // Catch: Throwable -> L14
        if (changed == false) goto L28;
        this.mStateChangedListener.onDeviceIdleStateChanged(enabled);
        return;
    L28:
        return;
    L19:
        this.mService.getJobStore().forEachJob(this.mShouldRushEvaluation, this.mDeviceIdleUpdateFunctor);     // Catch: Throwable -> L14
        this.mHandler.sendEmptyMessageDelayed(1, this.mBackgroundJobsDelay);     // Catch: Throwable -> L14
        goto L20
    L10:
        r2 = false;
        goto L11
    }

    public void setUidActiveLocked(int uid, boolean active) {
        if (active == this.mForegroundUids.get(uid)) goto L5;
        boolean changed = true;
    L6:
        if (changed == true) goto L9;
        return;
    L9:
        if (DEBUG == false) goto L15;
        StringBuilder r1 = new StringBuilder();
        r1.append("uid ");
        r1.append(uid);
        r1.append(" going ");
        if (active == false) goto L13;
        String r2 = DomainVerificationPersistence.TAG_ACTIVE;
    L14:
        r1.append(r2);
        Slog.d(TAG, r1.toString());
        goto L15
    L13:
        r2 = "inactive";
    L15:
        this.mForegroundUids.put(uid, active);
        this.mDeviceIdleUpdateFunctor.prepare();
        this.mService.getJobStore().forEachJobForSourceUid(uid, this.mDeviceIdleUpdateFunctor);
        if (this.mDeviceIdleUpdateFunctor.mChangedJobs.size() <= 0) goto L19;
        this.mStateChangedListener.onControllerStateChanged(this.mDeviceIdleUpdateFunctor.mChangedJobs);
        return;
    L19:
        return;
    L5:
        changed = false;
        goto L6
    }

    boolean isWhitelistedLocked(JobStatus job) {
        if (Arrays.binarySearch(this.mDeviceIdleWhitelistAppIds, UserHandle.getAppId(job.getSourceUid())) < 0) goto L5;
        return true;
    L5:
        return false;
    }

    boolean isTempWhitelistedLocked(JobStatus job) {
        return ArrayUtils.contains(this.mPowerSaveTempWhitelistAppIds, UserHandle.getAppId(job.getSourceUid()));
    }

    private boolean updateTaskStateLocked(JobStatus task, long nowElapsed) {
        boolean enableTask = false;
        boolean whitelisted = isWhitelistedLocked(task);
        if (this.mDeviceIdleMode == false) goto L6;
        if (whitelisted == true) goto L6;
        if (0 != 0) goto L6;
    L8:
        return task.setDeviceNotDozingConstraintSatisfied(nowElapsed, enableTask, whitelisted);
    L6:
        enableTask = true;
        goto L8
    }

    @Override // com.android.server.job.controllers.StateController
    public void maybeStartTrackingJobLocked(JobStatus jobStatus, JobStatus lastJob) {
        updateTaskStateLocked(jobStatus, JobSchedulerService.sElapsedRealtimeClock.millis());
    }

    @Override // com.android.server.job.controllers.StateController
    public void maybeStopTrackingJobLocked(JobStatus jobStatus, JobStatus incomingJob) {
    }

    @Override // com.android.server.job.controllers.StateController
    public void processConstantLocked(DeviceConfig.Properties properties, String key) {
        switch(key.hashCode()) {
            case 200338171: goto L6;
            default: goto L8;
        };
    L8:
        byte r0 = -1;
    L9:
        switch(r0) {
            case 0: goto L11;
            default: goto L13;
        };
    L11:
        this.mBackgroundJobsDelay = Math.max(0, properties.getLong(key, this.mBackgroundJobsDelay));
        return;
    L13:
        return;
    L6:
        if (key.equals(KEY_BACKGROUND_JOBS_DELAY_MS) == false) goto L8;
        r0 = 0;
        goto L9
    }

    @Override // com.android.server.job.controllers.StateController
    public void dumpConstants(IndentingPrintWriter pw) {
        pw.println();
        pw.print(DeviceIdleJobsController.class.getSimpleName());
        pw.println(":");
        pw.increaseIndent();
        pw.print(KEY_BACKGROUND_JOBS_DELAY_MS, Long.valueOf(this.mBackgroundJobsDelay)).println();
        pw.decreaseIndent();
    }

    @Override // com.android.server.job.controllers.StateController
    public void dumpControllerStateLocked(final IndentingPrintWriter pw, Predicate<JobStatus> predicate) {
        pw.println("Idle mode: " + this.mDeviceIdleMode);
        pw.println();
        this.mService.getJobStore().forEachJob(predicate, new DeviceIdleJobsController$$ExternalSyntheticLambda0(this, pw));
    }

    private /* synthetic */ void lambda$dumpControllerStateLocked$1(IndentingPrintWriter pw, JobStatus jobStatus) {
        pw.print("#");
        jobStatus.printUniqueId(pw);
        pw.print(" from ");
        UserHandle.formatUid(pw, jobStatus.getSourceUid());
        pw.print(": ");
        pw.print(jobStatus.getSourcePackageName());
        if ((jobStatus.satisfiedConstraints & 33554432) == 0) goto L5;
        String r0 = " RUNNABLE";
    L6:
        pw.print(r0);
        if (jobStatus.appHasDozeExemption == false) goto L10;
        pw.print(" WHITELISTED");
    L10:
        if (this.mAllowInIdleJobs.contains(jobStatus) == false) goto L12;
        pw.print(" ALLOWED_IN_DOZE");
    L12:
        pw.println();
        return;
    L5:
        r0 = " WAITING";
        goto L6
    }

    @Override // com.android.server.job.controllers.StateController
    public void dumpControllerStateLocked(final ProtoOutputStream proto, long fieldId, Predicate<JobStatus> predicate) {
        long token = proto.start(fieldId);
        long mToken = proto.start(1146756268037L);
        proto.write(1133871366145L, this.mDeviceIdleMode);
        this.mService.getJobStore().forEachJob(predicate, new DeviceIdleJobsController$$ExternalSyntheticLambda1(this, proto));
        proto.end(mToken);
        proto.end(token);
    }

    private /* synthetic */ void lambda$dumpControllerStateLocked$2(ProtoOutputStream proto, JobStatus jobStatus) {
        long jsToken = proto.start(2246267895810L);
        jobStatus.writeToShortProto(proto, 1146756268033L);
        proto.write(1120986464258L, jobStatus.getSourceUid());
        proto.write(1138166333443L, jobStatus.getSourcePackageName());
        if ((jobStatus.satisfiedConstraints & 33554432) == 0) goto L5;
        boolean r2 = true;
    L6:
        proto.write(1133871366148L, r2);
        proto.write(1133871366149L, jobStatus.appHasDozeExemption);
        proto.write(1133871366150L, this.mAllowInIdleJobs.contains(jobStatus));
        proto.end(jsToken);
        return;
    L5:
        r2 = false;
        goto L6
    }
}
