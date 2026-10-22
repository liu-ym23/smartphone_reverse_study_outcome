package com.stepos.pps.data.ouc;

import android.app.job.JobInfo;
import android.app.job.JobParameters;
import android.app.job.JobScheduler;
import android.app.job.JobService;
import android.content.ComponentName;
import android.content.Context;
import android.util.Log;
import com.stepos.pps.data.util.Utils;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class ErrorLogUploaderJobService extends JobService {
    private static final long FLEX_MILLIS;
    private static final long INTERVAL_MILLIS;
    private static final boolean ISDEBUG;
    private static final int JOB_ID;
    private static final String TAG = "ErrorLogUploaderJob";

    static {
        TimeUnit timeUnit;
        boolean z = Utils.sTestMode;
        ISDEBUG = z;
        JOB_ID = "zyql_error_log_uploader_job".hashCode();
        long j = 15;
        INTERVAL_MILLIS = z ? TimeUnit.MINUTES.toMillis(15L) : TimeUnit.HOURS.toMillis(1L);
        if (z) {
            timeUnit = TimeUnit.MINUTES;
            j = 5;
        } else {
            timeUnit = TimeUnit.MINUTES;
        }
        FLEX_MILLIS = timeUnit.toMillis(j);
    }

    @Override // android.app.job.JobService
    public boolean onStartJob(JobParameters jobParameters) {
        Log.d(TAG, "onStartJob: Triggering ErrorLog upload");
        ErrorLogManager.getInstance(this).checkUpload(true);
        return false;
    }

    @Override // android.app.job.JobService
    public boolean onStopJob(JobParameters jobParameters) {
        Log.d(TAG, "onStopJob");
        return true;
    }

    public static void schedule(Context context) {
        JobScheduler jobScheduler = (JobScheduler) context.getSystemService("jobscheduler");
        if (jobScheduler != null) {
            JobInfo.Builder builder = new JobInfo.Builder(JOB_ID, new ComponentName(context, (Class<?>) ErrorLogUploaderJobService.class));
            builder.setPeriodic(INTERVAL_MILLIS, FLEX_MILLIS);
            builder.setRequiredNetworkType(2);
            builder.setRequiresCharging(true);
            builder.setRequiresDeviceIdle(true);
            if (jobScheduler.schedule(builder.build()) == 1) {
                Log.d(TAG, "schedule: Job scheduled successfully");
            } else {
                Log.e(TAG, "schedule: Job scheduling failed");
            }
        }
    }

    public static void cancel(Context context) {
        JobScheduler jobScheduler = (JobScheduler) context.getSystemService("jobscheduler");
        if (jobScheduler != null) {
            jobScheduler.cancel(JOB_ID);
            Log.d(TAG, "cancel: Job cancelled");
        }
    }
}
