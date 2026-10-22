package com.android.server.job.restrictions;

import android.util.IndentingPrintWriter;
import com.android.server.job.JobSchedulerService;
import com.android.server.job.controllers.JobStatus;

/* JADX INFO: loaded from: classes2.dex */
public class IPowerSaverRestriction extends JobRestriction {
    public IPowerSaverRestriction(JobSchedulerService service) {
        super(service, 4, 12, 14);
    }

    @Override // com.android.server.job.restrictions.JobRestriction
    public boolean isJobRestricted(JobStatus job, int bias) {
        return false;
    }

    @Override // com.android.server.job.restrictions.JobRestriction
    public void dumpConstants(IndentingPrintWriter pw) {
    }
}
