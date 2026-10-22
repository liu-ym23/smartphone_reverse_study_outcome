package com.android.server.display;

import android.app.job.JobInfo;
import android.app.job.JobParameters;
import android.app.job.JobScheduler;
import android.app.job.JobService;
import android.content.ComponentName;
import android.content.Context;
import android.hardware.display.DisplayManagerInternal;
import android.util.Slog;
import com.android.server.LocalServices;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class BrightnessIdleJob extends JobService {
    private static final int JOB_ID = 3923512;

    public BrightnessIdleJob() {
    }

    public static void scheduleJob(Context context) {
        JobScheduler jobScheduler = (JobScheduler) context.getSystemService(JobScheduler.class);
        JobInfo pending = jobScheduler.getPendingJob(JOB_ID);
        JobInfo jobInfo = new JobInfo.Builder(JOB_ID, new ComponentName(context, BrightnessIdleJob.class)).setRequiresDeviceIdle(true).setRequiresCharging(true).setPeriodic(TimeUnit.HOURS.toMillis(24)).build();
        if (pending != null) goto L5;
    L7:
        if (pending != null) goto L10;
        jobScheduler.schedule(jobInfo);
        return;
    L10:
        return;
    L5:
        if (pending.equals(jobInfo) == true) goto L7;
        jobScheduler.cancel(JOB_ID);
        pending = null;
        goto L7
    }

    public static void cancelJob(Context context) {
        JobScheduler jobScheduler = (JobScheduler) context.getSystemService(JobScheduler.class);
        jobScheduler.cancel(JOB_ID);
    }

    @Override // android.app.job.JobService
    public boolean onStartJob(JobParameters params) {
        if (BrightnessTracker.DEBUG == false) goto L5;
        Slog.d("BrightnessTracker", "Scheduled write of brightness events");
    L5:
        DisplayManagerInternal dmi = (DisplayManagerInternal) LocalServices.getService(DisplayManagerInternal.class);
        dmi.persistBrightnessTrackerState();
        return false;
    }

    @Override // android.app.job.JobService
    public boolean onStopJob(JobParameters params) {
        return false;
    }
}
