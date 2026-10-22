package com.android.server.job.controllers;

import android.os.UserHandle;
import android.util.ArraySet;
import android.util.IndentingPrintWriter;
import android.util.Log;
import android.util.Slog;
import android.util.proto.ProtoOutputStream;
import com.android.server.AppSchedulingModuleThread;
import com.android.server.job.JobSchedulerService;
import com.android.server.slice.SliceClientPermissions;
import java.util.function.Predicate;

/* JADX INFO: loaded from: classes2.dex */
public final class BatteryController extends RestrictingController {
    private static final boolean DEBUG = false;
    private static final String TAG = "JobScheduler.Battery";
    private final ArraySet<JobStatus> mChangedJobs;
    private final FlexibilityController mFlexibilityController;
    private Boolean mLastReportedStatsdBatteryNotLow;
    private Boolean mLastReportedStatsdStablePower;
    private final ArraySet<JobStatus> mTopStartedJobs;
    private final ArraySet<JobStatus> mTrackedTasks;

    public static /* synthetic */ void $r8$lambda$DwuA24RhfmVhbCbTaQHfw8G5JE4(BatteryController r0) {
        r0.lambda$onBatteryStateChangedLocked$0();
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

    public BatteryController(JobSchedulerService service, FlexibilityController flexibilityController) {
        super(service);
        this.mTrackedTasks = new ArraySet();
        this.mTopStartedJobs = new ArraySet();
        this.mChangedJobs = new ArraySet();
        this.mLastReportedStatsdBatteryNotLow = null;
        this.mLastReportedStatsdStablePower = null;
        this.mFlexibilityController = flexibilityController;
    }

    @Override // com.android.server.job.controllers.StateController
    public void maybeStartTrackingJobLocked(JobStatus taskStatus, JobStatus lastJob) {
        if (taskStatus.hasPowerConstraint() == false) goto L18;
        long nowElapsed = JobSchedulerService.sElapsedRealtimeClock.millis();
        this.mTrackedTasks.add(taskStatus);
        boolean r2 = true;
        taskStatus.setTrackingController(1);
        if (taskStatus.hasChargingConstraint() == true) goto L7;
    L16:
        taskStatus.setBatteryNotLowConstraintSatisfied(nowElapsed, this.mService.isBatteryNotLow());
        return;
    L7:
        if (hasTopExemptionLocked(taskStatus) == false) goto L10;
        taskStatus.setChargingConstraintSatisfied(nowElapsed, this.mService.isPowerConnected());
        goto L16
    L10:
        if (this.mService.isBatteryCharging() == true) goto L12;
    L14:
        r2 = false;
    L15:
        taskStatus.setChargingConstraintSatisfied(nowElapsed, r2);
        goto L16
    L12:
        if (this.mService.isBatteryNotLow() == false) goto L14;
    }

    @Override // com.android.server.job.controllers.RestrictingController
    public void startTrackingRestrictedJobLocked(JobStatus jobStatus) {
        maybeStartTrackingJobLocked(jobStatus, null);
    }

    @Override // com.android.server.job.controllers.StateController
    public void prepareForExecutionLocked(JobStatus jobStatus) {
        if (jobStatus.hasPowerConstraint() == true) goto L6;
        return;
    L6:
        if (DEBUG == false) goto L8;
        Slog.d(TAG, "Prepping for " + jobStatus.toShortString());
    L8:
        int uid = jobStatus.getSourceUid();
        if (this.mService.getUidBias(uid) == 40) goto L11;
        return;
    L11:
        if (DEBUG == false) goto L13;
        Slog.d(TAG, jobStatus.toShortString() + " is top started job");
    L13:
        this.mTopStartedJobs.add(jobStatus);
    }

    @Override // com.android.server.job.controllers.StateController
    public void unprepareFromExecutionLocked(JobStatus jobStatus) {
        this.mTopStartedJobs.remove(jobStatus);
    }

    @Override // com.android.server.job.controllers.StateController
    public void maybeStopTrackingJobLocked(JobStatus taskStatus, JobStatus incomingJob) {
        if (taskStatus.clearTrackingController(1) == false) goto L6;
        this.mTrackedTasks.remove(taskStatus);
        this.mTopStartedJobs.remove(taskStatus);
        return;
    }

    @Override // com.android.server.job.controllers.RestrictingController
    public void stopTrackingRestrictedJobLocked(JobStatus jobStatus) {
        if (jobStatus.hasPowerConstraint() == true) goto L6;
        maybeStopTrackingJobLocked(jobStatus, null);
        return;
    }

    @Override // com.android.server.job.controllers.StateController
    public void onBatteryStateChangedLocked() {
        AppSchedulingModuleThread.getHandler().post(new BatteryController$$ExternalSyntheticLambda0(this));
    }

    private /* synthetic */ void lambda$onBatteryStateChangedLocked$0() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        maybeReportNewChargingStateLocked();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.job.controllers.StateController
    public void onUidBiasChangedLocked(int uid, int prevBias, int newBias) {
        if (prevBias == 40) goto L5;
        if (newBias == 40) goto L5;
        return;
    L5:
        maybeReportNewChargingStateLocked();
    }

    private boolean hasTopExemptionLocked(JobStatus taskStatus) {
        if (this.mService.getUidBias(taskStatus.getSourceUid()) != 40) goto L5;
    L8:
        return true;
    L5:
        if (this.mTopStartedJobs.contains(taskStatus) == true) goto L8;
        return false;
    }

    private void maybeReportNewChargingStateLocked() {
        boolean powerConnected = this.mService.isPowerConnected();
        if (this.mService.isBatteryCharging() == true) goto L5;
    L7:
        boolean stablePower = false;
    L8:
        boolean batteryNotLow = this.mService.isBatteryNotLow();
        if (DEBUG == false) goto L12;
        Slog.d(TAG, "maybeReportNewChargingStateLocked: " + powerConnected + SliceClientPermissions.SliceAuthority.DELIMITER + stablePower + SliceClientPermissions.SliceAuthority.DELIMITER + batteryNotLow);
    L12:
        if (this.mLastReportedStatsdStablePower != null) goto L14;
    L15:
        logDeviceWideConstraintStateToStatsd(1, stablePower);
        this.mLastReportedStatsdStablePower = Boolean.valueOf(stablePower);
    L17:
        if (this.mLastReportedStatsdBatteryNotLow != null) goto L19;
    L20:
        logDeviceWideConstraintStateToStatsd(2, batteryNotLow);
        this.mLastReportedStatsdBatteryNotLow = Boolean.valueOf(batteryNotLow);
    L21:
        long nowElapsed = JobSchedulerService.sElapsedRealtimeClock.millis();
        this.mFlexibilityController.setConstraintSatisfied(1, this.mService.isBatteryCharging(), nowElapsed);
        this.mFlexibilityController.setConstraintSatisfied(2, batteryNotLow, nowElapsed);
        int i = this.mTrackedTasks.size() - 1;
    L22:
        if (i < 0) goto L42;
        JobStatus ts = this.mTrackedTasks.valueAt(i);
        if (ts.hasChargingConstraint() == false) goto L36;
        if (hasTopExemptionLocked(ts) == false) goto L33;
        if (ts.getEffectivePriority() < 300) goto L33;
        if (ts.setChargingConstraintSatisfied(nowElapsed, powerConnected) == false) goto L36;
        this.mChangedJobs.add(ts);
    L33:
        if (ts.setChargingConstraintSatisfied(nowElapsed, stablePower) == false) goto L36;
        this.mChangedJobs.add(ts);
    L36:
        if (ts.hasBatteryNotLowConstraint() == false) goto L40;
        if (ts.setBatteryNotLowConstraintSatisfied(nowElapsed, batteryNotLow) == false) goto L40;
        this.mChangedJobs.add(ts);
    L40:
        i = i - 1;
        goto L22
    L42:
        if (stablePower == true) goto L48;
        if (batteryNotLow == true) goto L48;
        if (this.mChangedJobs.size() <= 0) goto L49;
        this.mStateChangedListener.onControllerStateChanged(this.mChangedJobs);
    L49:
        this.mChangedJobs.clear();
        return;
    L48:
        this.mStateChangedListener.onRunJobNow(null);
        goto L49
    L19:
        if (this.mLastReportedStatsdBatteryNotLow.booleanValue() == batteryNotLow) goto L21;
    L14:
        if (this.mLastReportedStatsdStablePower.booleanValue() == stablePower) goto L17;
    L5:
        if (this.mService.isBatteryNotLow() == false) goto L7;
        stablePower = true;
        goto L8
    }

    ArraySet<JobStatus> getTrackedJobs() {
        return this.mTrackedTasks;
    }

    ArraySet<JobStatus> getTopStartedJobs() {
        return this.mTopStartedJobs;
    }

    @Override // com.android.server.job.controllers.StateController
    public void dumpControllerStateLocked(IndentingPrintWriter pw, Predicate<JobStatus> predicate) {
        StringBuilder r0 = new StringBuilder();
        r0.append("Stable power: ");
        if (this.mService.isBatteryCharging() == true) goto L5;
    L7:
        boolean r1 = false;
    L8:
        r0.append(r1);
        pw.println(r0.toString());
        pw.println("Not low: " + this.mService.isBatteryNotLow());
        int i = 0;
    L10:
        if (i >= this.mTrackedTasks.size()) goto L17;
        JobStatus js = this.mTrackedTasks.valueAt(i);
        if (predicate.test(js) == false) goto L15;
        pw.print("#");
        js.printUniqueId(pw);
        pw.print(" from ");
        UserHandle.formatUid(pw, js.getSourceUid());
        pw.println();
    L15:
        i = i + 1;
        goto L10
    L17:
        return;
    L5:
        if (this.mService.isBatteryNotLow() == false) goto L7;
        r1 = true;
        goto L8
    }

    @Override // com.android.server.job.controllers.StateController
    public void dumpControllerStateLocked(ProtoOutputStream proto, long fieldId, Predicate<JobStatus> predicate) {
        long token = proto.start(fieldId);
        long mToken = proto.start(1146756268034L);
        if (this.mService.isBatteryCharging() == true) goto L5;
    L7:
        boolean r4 = false;
    L8:
        proto.write(1133871366145L, r4);
        proto.write(1133871366146L, this.mService.isBatteryNotLow());
        int i = 0;
    L10:
        if (i >= this.mTrackedTasks.size()) goto L16;
        JobStatus js = this.mTrackedTasks.valueAt(i);
        if (predicate.test(js) == false) goto L15;
        long jsToken = proto.start(2246267895813L);
        js.writeToShortProto(proto, 1146756268033L);
        proto.write(1120986464258L, js.getSourceUid());
        proto.end(jsToken);
    L15:
        i = i + 1;
        goto L10
    L16:
        proto.end(mToken);
        proto.end(token);
        return;
    L5:
        if (this.mService.isBatteryNotLow() == false) goto L7;
        r4 = true;
        goto L8
    }
}
