package com.android.server.job.controllers;

import com.android.server.job.JobSchedulerService;

/* JADX INFO: loaded from: classes2.dex */
public abstract class RestrictingController extends StateController {
    public abstract void startTrackingRestrictedJobLocked(JobStatus r1);

    public abstract void stopTrackingRestrictedJobLocked(JobStatus r1);

    RestrictingController(JobSchedulerService service) {
        super(service);
    }
}
