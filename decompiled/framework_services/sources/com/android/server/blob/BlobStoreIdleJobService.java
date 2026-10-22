package com.android.server.blob;

import android.app.job.JobInfo;
import android.app.job.JobParameters;
import android.app.job.JobScheduler;
import android.app.job.JobService;
import android.content.ComponentName;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Slog;
import com.android.server.LocalServices;

/* JADX INFO: loaded from: classes.dex */
public class BlobStoreIdleJobService extends JobService {
    public static /* synthetic */ void $r8$lambda$dX5rsh28FGLJacLVZFuY1GxKlOY(BlobStoreIdleJobService r0, JobParameters r1) {
        r0.lambda$onStartJob$0(r1);
    }

    public BlobStoreIdleJobService() {
    }

    @Override // android.app.job.JobService
    public boolean onStartJob(final JobParameters params) {
        AsyncTask.execute(new BlobStoreIdleJobService$$ExternalSyntheticLambda0(this, params));
        return true;
    }

    private /* synthetic */ void lambda$onStartJob$0(JobParameters params) {
        BlobStoreManagerInternal blobStoreManagerInternal = (BlobStoreManagerInternal) LocalServices.getService(BlobStoreManagerInternal.class);
        blobStoreManagerInternal.onIdleMaintenance();
        jobFinished(params, false);
    }

    @Override // android.app.job.JobService
    public boolean onStopJob(JobParameters params) {
        Slog.d(BlobStoreConfig.TAG, "Idle maintenance job is stopped; id=" + params.getJobId() + ", reason=" + JobParameters.getInternalReasonCodeDescription(params.getInternalStopReasonCode()));
        return false;
    }

    static void schedule(Context context) {
        JobScheduler jobScheduler = (JobScheduler) context.getSystemService("jobscheduler");
        JobInfo job = new JobInfo.Builder(BlobStoreConfig.IDLE_JOB_ID, new ComponentName(context, BlobStoreIdleJobService.class)).setRequiresDeviceIdle(true).setRequiresCharging(true).setPeriodic(BlobStoreConfig.getIdleJobPeriodMs()).build();
        jobScheduler.schedule(job);
        if (BlobStoreConfig.LOGV == false) goto L6;
        Slog.v(BlobStoreConfig.TAG, "Scheduling the idle maintenance job");
        return;
    }
}
