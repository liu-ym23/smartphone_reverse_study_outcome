package com.android.server.job.restrictions;

import android.os.PowerManager;
import android.util.IndentingPrintWriter;
import com.android.server.job.JobSchedulerService;
import com.android.server.job.controllers.JobStatus;

/* JADX INFO: loaded from: classes2.dex */
public class ThermalStatusRestriction extends JobRestriction {
    private static final int HIGHER_PRIORITY_THRESHOLD = 2;
    private static final int LOWER_THRESHOLD = 1;
    private static final int LOW_PRIORITY_THRESHOLD = 1;
    private static final String TAG = "ThermalStatusRestriction";
    private static final int UPPER_THRESHOLD = 3;
    private volatile int mThermalStatus;

    /* JADX INFO: renamed from: -$$Nest$fgetmThermalStatus, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m5095$$Nest$fgetmThermalStatus(ThermalStatusRestriction r0) {
        return r0.mThermalStatus;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmThermalStatus, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5096$$Nest$fputmThermalStatus(ThermalStatusRestriction r0, int r1) {
        r0.mThermalStatus = r1;
    }

    public ThermalStatusRestriction(JobSchedulerService service) {
        super(service, 4, 12, 5);
        this.mThermalStatus = 0;
    }

    @Override // com.android.server.job.restrictions.JobRestriction
    public void onSystemServicesReady() {
        PowerManager powerManager = (PowerManager) this.mService.getTestableContext().getSystemService(PowerManager.class);
        powerManager.addThermalStatusListener(new AnonymousClass1(this));
    }

    @Override // com.android.server.job.restrictions.JobRestriction
    public boolean isJobRestricted(JobStatus job, int bias) {
        if (bias < 40) goto L6;
        return false;
    L6:
        if (this.mThermalStatus < 3) goto L8;
        return true;
    L8:
        int priority = job.getEffectivePriority();
        if (this.mThermalStatus < 2) goto L49;
        if (job.shouldTreatAsUserInitiatedJob() == false) goto L14;
        return false;
    L14:
        if (job.shouldTreatAsExpeditedJob() == true) goto L16;
        if (bias < 35) goto L40;
        if (job.getJob().isImportantWhileForeground() == false) goto L40;
        if (job.getNumPreviousAttempts() > 0) goto L38;
        if (this.mService.isCurrentlyRunningLocked(job) == true) goto L34;
        return false;
    L34:
        if (this.mService.isJobInOvertimeLocked(job) == true) goto L38;
        return false;
    L38:
        return true;
    L40:
        if (priority == 400) goto L42;
        return true;
    L42:
        if (this.mService.isCurrentlyRunningLocked(job) == false) goto L46;
        if (this.mService.isJobInOvertimeLocked(job) == true) goto L46;
        return false;
    L46:
        return true;
    L16:
        if (job.getNumPreviousAttempts() > 0) goto L24;
        if (this.mService.isCurrentlyRunningLocked(job) == true) goto L20;
        return false;
    L20:
        if (this.mService.isJobInOvertimeLocked(job) == true) goto L24;
        return false;
    L24:
        return true;
    L49:
        if (this.mThermalStatus < 1) goto L64;
        if (bias < 35) goto L53;
        return false;
    L53:
        if (priority == 100) goto L63;
        if (priority == 200) goto L57;
        return false;
    L57:
        if (this.mService.isCurrentlyRunningLocked(job) == false) goto L63;
        if (this.mService.isJobInOvertimeLocked(job) == true) goto L63;
        return false;
    L63:
        return true;
    L64:
        return false;
    }

    int getThermalStatus() {
        return this.mThermalStatus;
    }

    @Override // com.android.server.job.restrictions.JobRestriction
    public void dumpConstants(IndentingPrintWriter pw) {
        pw.print("Thermal status: ");
        pw.println(this.mThermalStatus);
    }
}
