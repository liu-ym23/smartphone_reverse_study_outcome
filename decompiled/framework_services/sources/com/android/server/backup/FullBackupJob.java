package com.android.server.backup;

import android.app.job.JobInfo;
import android.app.job.JobParameters;
import android.app.job.JobScheduler;
import android.app.job.JobService;
import android.content.ComponentName;
import android.content.Context;
import android.os.Bundle;
import android.util.SparseArray;
import com.android.server.pm.PackageManagerService;

/* JADX INFO: loaded from: classes.dex */
public class FullBackupJob extends JobService {
    public static final int MAX_JOB_ID = 52419896;
    public static final int MIN_JOB_ID = 52418896;
    private static final String USER_ID_EXTRA_KEY = "userId";
    private static ComponentName sIdleService;
    private final SparseArray<JobParameters> mParamsForUser;

    public FullBackupJob() {
        this.mParamsForUser = new SparseArray();
    }

    static {
        sIdleService = new ComponentName(PackageManagerService.PLATFORM_PACKAGE_NAME, FullBackupJob.class.getName());
    }

    public static void schedule(int userId, Context ctx, long minDelay, UserBackupManagerService userBackupManagerService) {
        if (userBackupManagerService.isFrameworkSchedulingEnabled() == true) goto L5;
        return;
    L5:
        JobScheduler js = (JobScheduler) ctx.getSystemService("jobscheduler");
        JobInfo.Builder builder = new JobInfo.Builder(getJobIdForUserId(userId), sIdleService);
        BackupManagerConstants constants = userBackupManagerService.getConstants();
        monitor-enter(constants);
        builder.setRequiredNetworkType(constants.getFullBackupRequiredNetworkType()).setRequiresCharging(constants.getFullBackupRequireCharging());     // Catch: Throwable -> L17
        monitor-exit(constants);     // Catch: Throwable -> L17
        if (minDelay <= 0) goto L13;
        builder.setMinimumLatency(minDelay);
    L13:
        if (ctx.getPackageManager().hasSystemFeature("android.hardware.type.watch") == true) goto L15;
        builder.setRequiresDeviceIdle(true);
    L15:
        Bundle extraInfo = new Bundle();
        extraInfo.putInt("userId", userId);
        builder.setTransientExtras(extraInfo);
        js.schedule(builder.build());
        return;
    L17:
        th = move-exception;
        throw th;
    }

    public static void cancel(int userId, Context ctx) {
        JobScheduler js = (JobScheduler) ctx.getSystemService("jobscheduler");
        js.cancel(getJobIdForUserId(userId));
    }

    public void finishBackupPass(int userId) {
        SparseArray<JobParameters> r0 = this.mParamsForUser;
        monitor-enter(r0);
        JobParameters jobParameters = this.mParamsForUser.get(userId);     // Catch: Throwable -> L7
        if (jobParameters == null) goto L9;
        jobFinished(jobParameters, false);     // Catch: Throwable -> L7
        this.mParamsForUser.remove(userId);     // Catch: Throwable -> L7
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // android.app.job.JobService
    public boolean onStartJob(JobParameters params) {
        int userId = params.getTransientExtras().getInt("userId");
        SparseArray<JobParameters> r1 = this.mParamsForUser;
        monitor-enter(r1);
        this.mParamsForUser.put(userId, params);     // Catch: Throwable -> L8
        monitor-exit(r1);     // Catch: Throwable -> L8
        BackupManagerService service = BackupManagerService.getInstance();
        return service.beginFullBackup(userId, this);
    L8:
        th = move-exception;
        throw th;
    }

    @Override // android.app.job.JobService
    public boolean onStopJob(JobParameters params) {
        int userId = params.getTransientExtras().getInt("userId");
        SparseArray<JobParameters> r1 = this.mParamsForUser;
        monitor-enter(r1);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.mParamsForUser.removeReturnOld(userId) != null) goto L10;
        monitor-exit(r1);     // Catch: Throwable -> L8
        return false;
    L10:
        monitor-exit(r1);     // Catch: Throwable -> L8
        BackupManagerService service = BackupManagerService.getInstance();
        service.endFullBackup(userId);
        return false;
    }

    static int getJobIdForUserId(int userId) {
        return JobIdManager.getJobIdForUserId(52418896, MAX_JOB_ID, userId);
    }
}
