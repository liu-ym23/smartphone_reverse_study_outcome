package com.android.server.job.controllers;

import android.content.Context;
import android.provider.DeviceConfig;
import android.util.IndentingPrintWriter;
import android.util.Slog;
import android.util.proto.ProtoOutputStream;
import com.android.internal.util.FrameworkStatsLog;
import com.android.server.job.JobSchedulerService;
import com.android.server.job.StateChangedListener;
import java.util.function.Predicate;

/* JADX INFO: loaded from: classes2.dex */
public abstract class StateController {
    private static final String TAG = "JobScheduler.SC";
    protected final JobSchedulerService.Constants mConstants;
    protected final Context mContext;
    protected final Object mLock;
    protected final JobSchedulerService mService;
    protected final StateChangedListener mStateChangedListener;

    public abstract void dumpControllerStateLocked(IndentingPrintWriter r1, Predicate<JobStatus> r2);

    public abstract void maybeStartTrackingJobLocked(JobStatus r1, JobStatus r2);

    public abstract void maybeStopTrackingJobLocked(JobStatus r1, JobStatus r2);

    StateController(JobSchedulerService service) {
        this.mService = service;
        this.mStateChangedListener = service;
        this.mContext = service.getTestableContext();
        this.mLock = service.getLock();
        this.mConstants = service.getConstants();
    }

    public void startTrackingLocked() {
    }

    public void onSystemServicesReady() {
    }

    public void prepareForExecutionLocked(JobStatus jobStatus) {
    }

    public void unprepareFromExecutionLocked(JobStatus jobStatus) {
    }

    public void rescheduleForFailureLocked(JobStatus newJob, JobStatus failureToReschedule) {
    }

    public void prepareForUpdatedConstantsLocked() {
    }

    public void processConstantLocked(DeviceConfig.Properties properties, String key) {
    }

    public void onConstantsUpdatedLocked() {
    }

    public void onAppRemovedLocked(String packageName, int uid) {
    }

    public void onUserAddedLocked(int userId) {
    }

    public void onUserRemovedLocked(int userId) {
    }

    public void evaluateStateLocked(JobStatus jobStatus) {
    }

    public void reevaluateStateLocked(int uid) {
    }

    public void onBatteryStateChangedLocked() {
    }

    public void onUidBiasChangedLocked(int uid, int prevBias, int newBias) {
    }

    protected boolean wouldBeReadyWithConstraintLocked(JobStatus jobStatus, int constraint) {
        boolean jobWouldBeReady = jobStatus.wouldBeReadyWithConstraint(constraint);
        if (JobSchedulerService.DEBUG == false) goto L5;
        Slog.v(TAG, "wouldBeReadyWithConstraintLocked: " + jobStatus.toShortString() + " constraint=" + constraint + " readyWithConstraint=" + jobWouldBeReady);
    L5:
        if (jobWouldBeReady == true) goto L9;
        return false;
    L9:
        return this.mService.areComponentsInPlaceLocked(jobStatus);
    }

    protected void logDeviceWideConstraintStateToStatsd(int constraint, boolean satisfied) {
        int r0 = JobStatus.getProtoConstraint(constraint);
        if (satisfied == false) goto L5;
        int r1 = 2;
    L6:
        FrameworkStatsLog.write(514, r0, r1);
        return;
    L5:
        r1 = 1;
        goto L6
    }

    public void dumpControllerStateLocked(ProtoOutputStream proto, long fieldId, Predicate<JobStatus> predicate) {
    }

    public void dumpConstants(IndentingPrintWriter pw) {
    }

    public void dumpConstants(ProtoOutputStream proto) {
    }

    static String packageToString(int userId, String packageName) {
        return "<" + userId + ">" + packageName;
    }
}
