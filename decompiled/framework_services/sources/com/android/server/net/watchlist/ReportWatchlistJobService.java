package com.android.server.net.watchlist;

import android.app.job.JobInfo;
import android.app.job.JobParameters;
import android.app.job.JobScheduler;
import android.app.job.JobService;
import android.content.ComponentName;
import android.content.Context;
import android.net.NetworkWatchlistManager;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class ReportWatchlistJobService extends JobService {
    private static final boolean DEBUG = false;
    public static final int REPORT_WATCHLIST_RECORDS_JOB_ID = 882313;
    public static final long REPORT_WATCHLIST_RECORDS_PERIOD_MILLIS = 0;
    private static final String TAG = "WatchlistJobService";

    public ReportWatchlistJobService() {
    }

    static {
        REPORT_WATCHLIST_RECORDS_PERIOD_MILLIS = TimeUnit.HOURS.toMillis(12);
    }

    @Override // android.app.job.JobService
    public boolean onStartJob(JobParameters jobParameters) {
        if (jobParameters.getJobId() == 882313) goto L5;
        return false;
    L5:
        new NetworkWatchlistManager(this).reportWatchlistIfNecessary();
        jobFinished(jobParameters, false);
        return true;
    }

    @Override // android.app.job.JobService
    public boolean onStopJob(JobParameters jobParameters) {
        return true;
    }

    public static void schedule(Context context) {
        JobScheduler scheduler = (JobScheduler) context.getSystemService("jobscheduler");
        scheduler.schedule(new JobInfo.Builder(REPORT_WATCHLIST_RECORDS_JOB_ID, new ComponentName(context, ReportWatchlistJobService.class)).setPeriodic(REPORT_WATCHLIST_RECORDS_PERIOD_MILLIS).setRequiresDeviceIdle(true).setRequiresBatteryNotLow(true).setPersisted(false).build());
    }
}
