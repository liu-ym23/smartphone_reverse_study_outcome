package com.android.server;

import android.app.ActivityManager;
import android.app.job.JobInfo;
import android.app.job.JobParameters;
import android.app.job.JobScheduler;
import android.app.job.JobService;
import android.content.ComponentName;
import android.content.Context;
import android.os.RemoteException;
import com.android.server.pm.PackageManagerService;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class MountServiceIdler extends JobService {
    private static int MOUNT_JOB_ID = 0;
    private static final String TAG = "MountServiceIdler";
    private static ComponentName sIdleService;
    private static long sLastRunTime;
    private Runnable mFinishCallback;
    private JobParameters mJobParams;
    private boolean mStarted;

    /* JADX INFO: renamed from: -$$Nest$fgetmFinishCallback, reason: not valid java name */
    static /* bridge */ /* synthetic */ Runnable m279$$Nest$fgetmFinishCallback(MountServiceIdler r0) {
        return r0.mFinishCallback;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmJobParams, reason: not valid java name */
    static /* bridge */ /* synthetic */ JobParameters m280$$Nest$fgetmJobParams(MountServiceIdler r0) {
        return r0.mJobParams;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmStarted, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m281$$Nest$fgetmStarted(MountServiceIdler r0) {
        return r0.mStarted;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmStarted, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m282$$Nest$fputmStarted(MountServiceIdler r0, boolean r1) {
        r0.mStarted = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$sfputsLastRunTime, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m283$$Nest$sfputsLastRunTime(long r0) {
        sLastRunTime = r0;
    }

    public MountServiceIdler() {
        this.mFinishCallback = new AnonymousClass1(this);
    }

    static {
        sIdleService = new ComponentName(PackageManagerService.PLATFORM_PACKAGE_NAME, MountServiceIdler.class.getName());
        MOUNT_JOB_ID = 808;
        sLastRunTime = 0;
    }

    @Override // android.app.job.JobService
    public boolean onStartJob(JobParameters params) {
        ActivityManager.getService().performIdleMaintenance();     // Catch: RemoteException -> L4
    L5:
        this.mJobParams = params;
        StorageManagerService ms = StorageManagerService.sSelf;
        if (ms == null) goto L15;
        Runnable r2 = this.mFinishCallback;
        monitor-enter(r2);
        this.mStarted = true;     // Catch: Throwable -> L12
        monitor-exit(r2);     // Catch: Throwable -> L12
        ms.runIdleMaint(this.mFinishCallback);
    L12:
        th = move-exception;
        throw th;
    L15:
        if (ms != null) goto L23;
        return false;
    L23:
        return true;
    }

    @Override // android.app.job.JobService
    public boolean onStopJob(JobParameters params) {
        StorageManagerService ms = StorageManagerService.sSelf;
        if (ms == null) goto L12;
        ms.abortIdleMaint(this.mFinishCallback);
        Runnable r2 = this.mFinishCallback;
        monitor-enter(r2);
        this.mStarted = false;     // Catch: Throwable -> L9
        monitor-exit(r2);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    L12:
        return false;
    }

    public static void scheduleIdlePass(Context context) {
        JobScheduler tm = (JobScheduler) context.getSystemService("jobscheduler");
        long currentTime = System.currentTimeMillis();
        long timeSinceLastRun = currentTime - sLastRunTime;
        long minInterval = TimeUnit.HOURS.toMillis(2);
        if (sLastRunTime != 0) goto L6;
        long nextScheduleTime = minInterval;
    L9:
        JobInfo.Builder builder = new JobInfo.Builder(MOUNT_JOB_ID, sIdleService);
        builder.setRequiresDeviceIdle(true);
        builder.setRequiresBatteryNotLow(true);
        builder.setRequiresCharging(true);
        builder.setMinimumLatency(nextScheduleTime);
        tm.schedule(builder.build());
        return;
    L6:
        if (timeSinceLastRun >= minInterval) goto L8;
        long remainingTime = minInterval - timeSinceLastRun;
        nextScheduleTime = Math.max(TimeUnit.MINUTES.toMillis(5), remainingTime);
        goto L9
    L8:
        nextScheduleTime = TimeUnit.MINUTES.toMillis(5);
        goto L9
    }

    private static Calendar offsetFromTodayMidnight(int nDays, int nHours) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.set(11, nHours);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        calendar.add(5, nDays);
        return calendar;
    }
}
