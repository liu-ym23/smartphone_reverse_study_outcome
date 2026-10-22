package com.stepos.pps.logpull;

import android.app.job.JobInfo;
import android.app.job.JobParameters;
import android.app.job.JobScheduler;
import android.app.job.JobService;
import android.content.ComponentName;
import android.content.Context;
import android.util.Log;
import com.stepos.pps.PPSApplication;

/* loaded from: classes.dex */
public class LogPullDeadlineJobService extends JobService {
    private static final long FLEX_MS = 60000;
    private static final int JOB_ID = "pps_logpull_deadline".hashCode();
    private static final String TAG = "LogPull.DeadlineJob";

    @Override // android.app.job.JobService
    public boolean onStopJob(JobParameters jobParameters) {
        return true;
    }

    @Override // android.app.job.JobService
    public boolean onStartJob(final JobParameters jobParameters) {
        Log.i(TAG, "onStartJob：到点检查 deadline");
        new Thread(new Runnable() { // from class: com.stepos.pps.logpull.LogPullDeadlineJobService$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$onStartJob$0(jobParameters);
            }
        }, "LogPullDeadlineJob").start();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onStartJob$0(JobParameters jobParameters) {
        try {
            PPSApplication pPSApplication = PPSApplication.getInstance();
            LogPullPoller logPullPoller = pPSApplication != null ? pPSApplication.getLogPullPoller() : null;
            if (logPullPoller == null) {
                Log.w(TAG, "Poller 未就绪，跳过 deadline 检查");
            } else {
                logPullPoller.onDeadlineCheck();
            }
        } catch (Exception e) {
            Log.e(TAG, "deadline 检查异常", e);
        } finally {
            jobFinished(jobParameters, false);
        }
    }

    public static void schedule(Context context, long j) {
        JobScheduler jobScheduler = (JobScheduler) context.getSystemService("jobscheduler");
        if (jobScheduler == null) {
            Log.e(TAG, "JobScheduler 不可用");
            return;
        }
        long jCurrentTimeMillis = j - System.currentTimeMillis();
        if (jCurrentTimeMillis < 0) {
            jCurrentTimeMillis = 0;
        }
        Log.i(TAG, "scheduled deadline check in " + jCurrentTimeMillis + "ms result=" + jobScheduler.schedule(new JobInfo.Builder(JOB_ID, new ComponentName(context, (Class<?>) LogPullDeadlineJobService.class)).setMinimumLatency(jCurrentTimeMillis).setOverrideDeadline(FLEX_MS + jCurrentTimeMillis).setPersisted(true).build()));
    }

    public static void cancel(Context context) {
        JobScheduler jobScheduler = (JobScheduler) context.getSystemService("jobscheduler");
        if (jobScheduler != null) {
            jobScheduler.cancel(JOB_ID);
        }
    }
}
