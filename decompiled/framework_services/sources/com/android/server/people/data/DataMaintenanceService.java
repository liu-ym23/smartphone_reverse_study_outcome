package com.android.server.people.data;

import android.app.job.JobInfo;
import android.app.job.JobParameters;
import android.app.job.JobScheduler;
import android.app.job.JobService;
import android.content.ComponentName;
import android.content.Context;
import android.os.CancellationSignal;
import com.android.server.LocalServices;
import com.android.server.people.PeopleServiceInternal;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class DataMaintenanceService extends JobService {
    private static final int BASE_JOB_ID = 204561367;
    private static final long JOB_RUN_INTERVAL = 0;
    private CancellationSignal mSignal;

    public static /* synthetic */ void $r8$lambda$kolm1Usqgw5loMXBvPGzy8r4PBk(DataMaintenanceService r0, int r1, JobParameters r2) {
        r0.lambda$onStartJob$0(r1, r2);
    }

    public DataMaintenanceService() {
    }

    static {
        JOB_RUN_INTERVAL = TimeUnit.HOURS.toMillis(24);
    }

    static void scheduleJob(Context context, int userId) {
        int jobId = getJobId(userId);
        JobScheduler jobScheduler = (JobScheduler) context.getSystemService(JobScheduler.class);
        if (jobScheduler.getPendingJob(jobId) != null) goto L6;
        ComponentName component = new ComponentName(context, DataMaintenanceService.class);
        JobInfo newJob = new JobInfo.Builder(jobId, component).setRequiresDeviceIdle(true).setPeriodic(JOB_RUN_INTERVAL).build();
        jobScheduler.schedule(newJob);
        return;
    }

    static void cancelJob(Context context, int userId) {
        JobScheduler jobScheduler = (JobScheduler) context.getSystemService(JobScheduler.class);
        jobScheduler.cancel(getJobId(userId));
    }

    @Override // android.app.job.JobService
    public boolean onStartJob(final JobParameters params) {
        final int userId = getUserId(params.getJobId());
        this.mSignal = new CancellationSignal();
        new Thread(new DataMaintenanceService$$ExternalSyntheticLambda0(this, userId, params)).start();
        return true;
    }

    private /* synthetic */ void lambda$onStartJob$0(int userId, JobParameters params) {
        PeopleServiceInternal peopleServiceInternal = (PeopleServiceInternal) LocalServices.getService(PeopleServiceInternal.class);
        peopleServiceInternal.pruneDataForUser(userId, this.mSignal);
        jobFinished(params, this.mSignal.isCanceled());
    }

    @Override // android.app.job.JobService
    public boolean onStopJob(JobParameters params) {
        if (this.mSignal == null) goto L7;
        this.mSignal.cancel();
        return false;
    L7:
        return false;
    }

    private static int getJobId(int userId) {
        return BASE_JOB_ID + userId;
    }

    private static int getUserId(int jobId) {
        return jobId - BASE_JOB_ID;
    }
}
