package com.android.server.usage;

import android.app.job.JobInfo;
import android.app.job.JobParameters;
import android.app.job.JobScheduler;
import android.app.job.JobService;
import android.app.usage.UsageStatsManagerInternal;
import android.content.ComponentName;
import android.content.Context;
import android.os.AsyncTask;
import android.os.PersistableBundle;
import com.android.server.LocalServices;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public class UsageStatsIdleService extends JobService {
    private static final String PRUNE_JOB_NS = "usagestats_prune";
    private static final String UPDATE_MAPPINGS_JOB_NS = "usagestats_mapping";
    private static final String USER_ID_KEY = "user_id";

    public static /* synthetic */ void $r8$lambda$KuQoq8cHCLRKU1N4IbiKONHBE18(UsageStatsIdleService r0, JobParameters r1, int r2) {
        r0.lambda$onStartJob$0(r1, r2);
    }

    public UsageStatsIdleService() {
    }

    static void schedulePruneJob(Context context, int userId) {
        ComponentName component = new ComponentName(context.getPackageName(), UsageStatsIdleService.class.getName());
        PersistableBundle bundle = new PersistableBundle();
        bundle.putInt(USER_ID_KEY, userId);
        JobInfo pruneJob = new JobInfo.Builder(userId, component).setRequiresDeviceIdle(true).setExtras(bundle).setPersisted(true).build();
        scheduleJobInternal(context, pruneJob, PRUNE_JOB_NS, userId);
    }

    static void scheduleUpdateMappingsJob(Context context, int userId) {
        ComponentName component = new ComponentName(context.getPackageName(), UsageStatsIdleService.class.getName());
        PersistableBundle bundle = new PersistableBundle();
        bundle.putInt(USER_ID_KEY, userId);
        JobInfo updateMappingsJob = new JobInfo.Builder(userId, component).setPersisted(true).setMinimumLatency(TimeUnit.DAYS.toMillis(1)).setOverrideDeadline(TimeUnit.DAYS.toMillis(2)).setExtras(bundle).build();
        scheduleJobInternal(context, updateMappingsJob, UPDATE_MAPPINGS_JOB_NS, userId);
    }

    private static void scheduleJobInternal(Context context, JobInfo jobInfo, String namespace, int jobId) {
        JobScheduler jobScheduler = ((JobScheduler) context.getSystemService(JobScheduler.class)).forNamespace(namespace);
        JobInfo pendingJob = jobScheduler.getPendingJob(jobId);
        if (jobInfo.equals(pendingJob) == true) goto L6;
        jobScheduler.cancel(jobId);
        jobScheduler.schedule(jobInfo);
        return;
    }

    static void cancelPruneJob(Context context, int userId) {
        cancelJobInternal(context, PRUNE_JOB_NS, userId);
    }

    static void cancelUpdateMappingsJob(Context context, int userId) {
        cancelJobInternal(context, UPDATE_MAPPINGS_JOB_NS, userId);
    }

    private static void cancelJobInternal(Context context, String namespace, int jobId) {
        JobScheduler jobScheduler = (JobScheduler) context.getSystemService(JobScheduler.class);
        if (jobScheduler == null) goto L6;
        jobScheduler.forNamespace(namespace).cancel(jobId);
        return;
    }

    @Override // android.app.job.JobService
    public boolean onStartJob(final JobParameters params) {
        PersistableBundle bundle = params.getExtras();
        final int userId = bundle.getInt(USER_ID_KEY, -1);
        if (userId != (-1)) goto L6;
        return false;
    L6:
        AsyncTask.execute(new UsageStatsIdleService$$ExternalSyntheticLambda0(this, params, userId));
        return true;
    }

    private /* synthetic */ void lambda$onStartJob$0(JobParameters params, int userId) {
        UsageStatsManagerInternal usageStatsManagerInternal = (UsageStatsManagerInternal) LocalServices.getService(UsageStatsManagerInternal.class);
        String jobNs = params.getJobNamespace();
        if (UPDATE_MAPPINGS_JOB_NS.equals(jobNs) == false) goto L5;
        boolean jobFinished = usageStatsManagerInternal.updatePackageMappingsData(userId);
        jobFinished(params, !jobFinished);
        return;
    L5:
        boolean jobFinished2 = usageStatsManagerInternal.pruneUninstalledPackagesData(userId);
        jobFinished(params, !jobFinished2);
    }

    @Override // android.app.job.JobService
    public boolean onStopJob(JobParameters params) {
        return false;
    }
}
