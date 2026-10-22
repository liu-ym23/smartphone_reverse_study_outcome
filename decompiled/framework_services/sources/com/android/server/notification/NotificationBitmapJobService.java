package com.android.server.notification;

import android.app.job.JobInfo;
import android.app.job.JobParameters;
import android.app.job.JobScheduler;
import android.app.job.JobService;
import android.content.ComponentName;
import android.content.Context;
import android.util.Slog;
import com.android.server.LocalServices;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

/* JADX INFO: loaded from: classes2.dex */
public class NotificationBitmapJobService extends JobService {
    static final int BASE_JOB_ID = 290381858;
    static final String TAG = "NotificationBitmapJob";

    /* JADX INFO: renamed from: $r8$lambda$B6y94-Bm2syGb4kH-v-OjmYgWHs, reason: not valid java name */
    public static /* synthetic */ void m6109$r8$lambda$B6y94Bm2syGb4kHvOjmYgWHs(NotificationBitmapJobService r0, JobParameters r1) {
        r0.lambda$onStartJob$0(r1);
    }

    public NotificationBitmapJobService() {
    }

    static void scheduleJob(Context context) {
        if (context != null) goto L14;
        return;
    L14:
        JobScheduler jobScheduler = ((JobScheduler) context.getSystemService(JobScheduler.class)).forNamespace(TAG);     // Catch: Throwable -> L9
        ComponentName component = new ComponentName(context, NotificationBitmapJobService.class);     // Catch: Throwable -> L9
        JobInfo jobInfo = new JobInfo.Builder(BASE_JOB_ID, component).setRequiresDeviceIdle(true).setMinimumLatency(getRunAfterMs()).build();     // Catch: Throwable -> L9
        int result = jobScheduler.schedule(jobInfo);     // Catch: Throwable -> L9
        if (result == 1) goto L16;
        Slog.e(TAG, "Failed to schedule bitmap removal job");     // Catch: Throwable -> L9
        return;
    L16:
        return;
    L9:
        e = move-exception;
        Slog.wtf(TAG, "Failed bitmap removal job", e);
    }

    private static long getRunAfterMs() {
        ZoneId zoneId = ZoneId.systemDefault();
        ZonedDateTime now = Instant.now().atZone(zoneId);
        LocalDate today = now.toLocalDate();
        LocalTime twoAM = LocalTime.of(2, 0);
        ZonedDateTime today2AM = ZonedDateTime.of(today, twoAM, zoneId);
        ZonedDateTime tomorrow2AM = today2AM.plusDays(1);
        return getTimeUntilRemoval(now, today2AM, tomorrow2AM);
    }

    static long getTimeUntilRemoval(ZonedDateTime now, ZonedDateTime today2AM, ZonedDateTime tomorrow2AM) {
        if (Duration.between(now, today2AM).isNegative() == false) goto L7;
        return Duration.between(now, tomorrow2AM).toMillis();
    L7:
        return Duration.between(now, today2AM).toMillis();
    }

    @Override // android.app.job.JobService
    public boolean onStartJob(final JobParameters params) {
        new Thread(new NotificationBitmapJobService$$ExternalSyntheticLambda0(this, params)).start();
        return true;
    }

    private /* synthetic */ void lambda$onStartJob$0(JobParameters params) {
        NotificationManagerInternal nmInternal = (NotificationManagerInternal) LocalServices.getService(NotificationManagerInternal.class);
        nmInternal.removeBitmaps();
        scheduleJob(this);
        jobFinished(params, false);
    }

    @Override // android.app.job.JobService
    public boolean onStopJob(JobParameters params) {
        return false;
    }

    @Override // android.app.Service, android.content.ContextWrapper
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
    }
}
