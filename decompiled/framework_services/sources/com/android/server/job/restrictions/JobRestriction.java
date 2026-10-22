package com.android.server.job.restrictions;

import android.util.IndentingPrintWriter;
import android.util.proto.ProtoOutputStream;
import com.android.server.job.JobSchedulerService;
import com.android.server.job.controllers.JobStatus;

/* JADX INFO: loaded from: classes2.dex */
public abstract class JobRestriction {
    private final int mInternalReason;
    private final int mPendingReason;
    final JobSchedulerService mService;
    private final int mStopReason;

    public abstract void dumpConstants(IndentingPrintWriter r1);

    public abstract boolean isJobRestricted(JobStatus r1, int r2);

    protected JobRestriction(JobSchedulerService service, int stopReason, int pendingReason, int internalReason) {
        this.mService = service;
        this.mPendingReason = pendingReason;
        this.mStopReason = stopReason;
        this.mInternalReason = internalReason;
    }

    public void onSystemServicesReady() {
    }

    public void dumpConstants(ProtoOutputStream proto) {
    }

    public final int getPendingReason() {
        return this.mPendingReason;
    }

    public final int getStopReason() {
        return this.mStopReason;
    }

    public final int getInternalReason() {
        return this.mInternalReason;
    }
}
