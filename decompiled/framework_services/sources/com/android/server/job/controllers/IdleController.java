package com.android.server.job.controllers;

import android.os.UserHandle;
import android.provider.DeviceConfig;
import android.util.ArraySet;
import android.util.IndentingPrintWriter;
import android.util.proto.ProtoOutputStream;
import com.android.server.job.JobSchedulerService;
import com.android.server.job.controllers.idle.CarIdlenessTracker;
import com.android.server.job.controllers.idle.DeviceIdlenessTracker;
import com.android.server.job.controllers.idle.IdlenessListener;
import com.android.server.job.controllers.idle.IdlenessTracker;
import java.util.function.Predicate;

/* JADX INFO: loaded from: classes2.dex */
public final class IdleController extends RestrictingController implements IdlenessListener {
    private static final String TAG = "JobScheduler.IdleController";
    private final FlexibilityController mFlexibilityController;
    IdlenessTracker mIdleTracker;
    final ArraySet<JobStatus> mTrackedTasks;

    public IdleController(JobSchedulerService service, FlexibilityController flexibilityController) {
        super(service);
        this.mTrackedTasks = new ArraySet();
        initIdleStateTracker();
        this.mFlexibilityController = flexibilityController;
    }

    @Override // com.android.server.job.controllers.StateController
    public void maybeStartTrackingJobLocked(JobStatus taskStatus, JobStatus lastJob) {
        if (taskStatus.hasIdleConstraint() == false) goto L6;
        long nowElapsed = JobSchedulerService.sElapsedRealtimeClock.millis();
        this.mTrackedTasks.add(taskStatus);
        taskStatus.setTrackingController(8);
        taskStatus.setIdleConstraintSatisfied(nowElapsed, this.mIdleTracker.isIdle());
        return;
    }

    @Override // com.android.server.job.controllers.RestrictingController
    public void startTrackingRestrictedJobLocked(JobStatus jobStatus) {
        maybeStartTrackingJobLocked(jobStatus, null);
    }

    @Override // com.android.server.job.controllers.StateController
    public void maybeStopTrackingJobLocked(JobStatus taskStatus, JobStatus incomingJob) {
        if (taskStatus.clearTrackingController(8) == false) goto L6;
        this.mTrackedTasks.remove(taskStatus);
        return;
    }

    @Override // com.android.server.job.controllers.RestrictingController
    public void stopTrackingRestrictedJobLocked(JobStatus jobStatus) {
        if (jobStatus.hasIdleConstraint() == true) goto L6;
        maybeStopTrackingJobLocked(jobStatus, null);
        return;
    }

    @Override // com.android.server.job.controllers.StateController
    public void processConstantLocked(DeviceConfig.Properties properties, String key) {
        this.mIdleTracker.processConstant(properties, key);
    }

    @Override // com.android.server.job.controllers.StateController
    public void onBatteryStateChangedLocked() {
        this.mIdleTracker.onBatteryStateChanged(this.mService.isBatteryCharging(), this.mService.isBatteryNotLow());
    }

    @Override // com.android.server.job.controllers.idle.IdlenessListener
    public void reportNewIdleState(boolean isIdle) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        logDeviceWideConstraintStateToStatsd(4, isIdle);     // Catch: Throwable -> L8
        long nowElapsed = JobSchedulerService.sElapsedRealtimeClock.millis();     // Catch: Throwable -> L8
        this.mFlexibilityController.setConstraintSatisfied(4, isIdle, nowElapsed);     // Catch: Throwable -> L8
        int i = this.mTrackedTasks.size() - 1;     // Catch: Throwable -> L8
    L6:
        if (i < 0) goto L11;
        this.mTrackedTasks.valueAt(i).setIdleConstraintSatisfied(nowElapsed, isIdle);     // Catch: Throwable -> L8
        i = i - 1;     // Catch: Throwable -> L8
        goto L6
    L11:
        if (this.mTrackedTasks.isEmpty() == true) goto L13;
        this.mStateChangedListener.onControllerStateChanged(this.mTrackedTasks);     // Catch: Throwable -> L8
    L13:
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    private void initIdleStateTracker() {
        boolean isCar = this.mContext.getPackageManager().hasSystemFeature("android.hardware.type.automotive");
        if (isCar == false) goto L5;
        this.mIdleTracker = new CarIdlenessTracker();
        return;
    L5:
        this.mIdleTracker = new DeviceIdlenessTracker();
    }

    @Override // com.android.server.job.controllers.StateController
    public void startTrackingLocked() {
        this.mIdleTracker.startTracking(this.mContext, this.mService, this);
    }

    @Override // com.android.server.job.controllers.StateController
    public void dumpConstants(IndentingPrintWriter pw) {
        pw.println();
        pw.println("IdleController:");
        pw.increaseIndent();
        this.mIdleTracker.dumpConstants(pw);
        pw.decreaseIndent();
    }

    @Override // com.android.server.job.controllers.StateController
    public void dumpControllerStateLocked(IndentingPrintWriter pw, Predicate<JobStatus> predicate) {
        pw.println("Currently idle: " + this.mIdleTracker.isIdle());
        pw.println("Idleness tracker:");
        this.mIdleTracker.dump(pw);
        pw.println();
        int i = 0;
    L4:
        if (i >= this.mTrackedTasks.size()) goto L11;
        JobStatus js = this.mTrackedTasks.valueAt(i);
        if (predicate.test(js) == false) goto L9;
        pw.print("#");
        js.printUniqueId(pw);
        pw.print(" from ");
        UserHandle.formatUid(pw, js.getSourceUid());
        pw.println();
    L9:
        i = i + 1;
        goto L4
    }

    @Override // com.android.server.job.controllers.StateController
    public void dumpControllerStateLocked(ProtoOutputStream proto, long fieldId, Predicate<JobStatus> predicate) {
        long token = proto.start(fieldId);
        long mToken = proto.start(1146756268038L);
        proto.write(1133871366145L, this.mIdleTracker.isIdle());
        this.mIdleTracker.dump(proto, 1146756268035L);
        int i = 0;
    L4:
        if (i >= this.mTrackedTasks.size()) goto L10;
        JobStatus js = this.mTrackedTasks.valueAt(i);
        if (predicate.test(js) == false) goto L9;
        long jsToken = proto.start(2246267895810L);
        js.writeToShortProto(proto, 1146756268033L);
        proto.write(1120986464258L, js.getSourceUid());
        proto.end(jsToken);
    L9:
        i = i + 1;
        goto L4
    L10:
        proto.end(mToken);
        proto.end(token);
    }
}
