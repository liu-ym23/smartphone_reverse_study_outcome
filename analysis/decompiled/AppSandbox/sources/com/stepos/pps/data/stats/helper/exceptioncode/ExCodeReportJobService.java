package com.stepos.pps.data.stats.helper.exceptioncode;

import android.app.job.JobInfo;
import android.app.job.JobParameters;
import android.app.job.JobScheduler;
import android.app.job.JobService;
import android.content.ComponentName;
import android.content.Context;
import android.util.Log;
import com.stepos.pps.PPSApplication;
import com.stepos.pps.data.util.Utils;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class ExCodeReportJobService extends JobService {
    private static final long FLEX_MILLIS;
    private static final long INTERVAL_MILLIS;
    private static final boolean ISDEBUG;
    private static final int JOB_ID;
    private static final String TAG = "ExCodeReportJobService";

    static {
        TimeUnit timeUnit;
        long j;
        boolean z = Utils.sTestMode;
        ISDEBUG = z;
        JOB_ID = "stepos_exception_code_job".hashCode();
        INTERVAL_MILLIS = TimeUnit.MINUTES.toMillis(z ? 2L : 15L);
        if (z) {
            timeUnit = TimeUnit.MINUTES;
            j = 1;
        } else {
            timeUnit = TimeUnit.MINUTES;
            j = 5;
        }
        FLEX_MILLIS = timeUnit.toMillis(j);
    }

    @Override // android.app.job.JobService
    public boolean onStartJob(JobParameters jobParameters) {
        Log.d(TAG, "==onStartJob==");
        PPSApplication.getInstance().getExCodeStatsCollector().getMetrics();
        return false;
    }

    @Override // android.app.job.JobService
    public boolean onStopJob(JobParameters jobParameters) {
        Log.d(TAG, "==onStopJob==");
        return true;
    }

    public static void scheduleReportJob(Context context) {
        JobScheduler jobScheduler = (JobScheduler) context.getSystemService("jobscheduler");
        if (jobScheduler != null) {
            JobInfo.Builder builder = new JobInfo.Builder(JOB_ID, new ComponentName(context, (Class<?>) ExCodeReportJobService.class));
            builder.setPeriodic(INTERVAL_MILLIS, FLEX_MILLIS);
            builder.setRequiresDeviceIdle(true);
            builder.setRequiresBatteryNotLow(true);
            jobScheduler.schedule(builder.build());
        }
    }

    public static void cancelSchedule(Context context) {
        JobScheduler jobScheduler = (JobScheduler) context.getSystemService("jobscheduler");
        if (jobScheduler != null) {
            jobScheduler.cancel(JOB_ID);
        }
    }
}
