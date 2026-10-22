package com.android.server.notification;

import android.app.job.JobInfo;
import android.app.job.JobParameters;
import android.app.job.JobScheduler;
import android.app.job.JobService;
import android.content.ComponentName;
import android.content.Context;
import android.os.CancellationSignal;
import android.util.Slog;
import com.android.server.LocalServices;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class NotificationHistoryJobService extends JobService {
    static final int BASE_JOB_ID = 237039804;
    private static final long JOB_RUN_INTERVAL = 0;
    private static final String TAG = "NotificationHistoryJob";
    private CancellationSignal mSignal;

    /* JADX INFO: renamed from: $r8$lambda$PfUuCVFQEsG_hup-ySw0DwJnttY, reason: not valid java name */
    public static /* synthetic */ void m6120$r8$lambda$PfUuCVFQEsG_hupySw0DwJnttY(NotificationHistoryJobService r0, JobParameters r1) {
        r0.lambda$onStartJob$0(r1);
    }

    public NotificationHistoryJobService() {
    }

    static {
        JOB_RUN_INTERVAL = TimeUnit.MINUTES.toMillis(20);
    }

    static void scheduleJob(Context context) {
        JobScheduler jobScheduler = (JobScheduler) context.getSystemService(JobScheduler.class);
        if (jobScheduler.getPendingJob(BASE_JOB_ID) != null) goto L8;
        ComponentName component = new ComponentName(context, NotificationHistoryJobService.class);
        JobInfo newJob = new JobInfo.Builder(BASE_JOB_ID, component).setRequiresDeviceIdle(false).setPeriodic(JOB_RUN_INTERVAL).build();
        if (jobScheduler.schedule(newJob) == 1) goto L9;
        Slog.w(TAG, "Failed to schedule history cleanup job");
        return;
    L9:
        return;
    }

    @Override // android.app.job.JobService
    public boolean onStartJob(final JobParameters params) {
        this.mSignal = new CancellationSignal();
        new Thread(new NotificationHistoryJobService$$ExternalSyntheticLambda0(this, params)).start();
        return true;
    }

    private /* synthetic */ void lambda$onStartJob$0(JobParameters params) {
        NotificationManagerInternal nmInternal = (NotificationManagerInternal) LocalServices.getService(NotificationManagerInternal.class);
        nmInternal.cleanupHistoryFiles();
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

    @Override // android.app.Service, android.content.ContextWrapper
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
    }
}
