package com.android.server.backup;

import android.app.job.JobInfo;
import android.app.job.JobParameters;
import android.app.job.JobScheduler;
import android.app.job.JobService;
import android.content.ComponentName;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.Slog;
import android.util.SparseBooleanArray;
import android.util.SparseLongArray;
import com.android.server.pm.PackageManagerService;
import java.util.Random;

/* JADX INFO: loaded from: classes.dex */
public class KeyValueBackupJob extends JobService {
    private static final long MAX_DEFERRAL = 86400000;
    public static final int MAX_JOB_ID = 52418896;
    public static final int MIN_JOB_ID = 52417896;
    private static final String TAG = "KeyValueBackupJob";
    private static final String USER_ID_EXTRA_KEY = "userId";
    private static ComponentName sKeyValueJobService;
    private static final SparseLongArray sNextScheduledForUserId = null;
    private static final SparseBooleanArray sScheduledForUserId = null;

    public KeyValueBackupJob() {
    }

    static {
        sKeyValueJobService = new ComponentName(PackageManagerService.PLATFORM_PACKAGE_NAME, KeyValueBackupJob.class.getName());
        sScheduledForUserId = new SparseBooleanArray();
        sNextScheduledForUserId = new SparseLongArray();
    }

    public static void schedule(int userId, Context ctx, UserBackupManagerService userBackupManagerService) {
        schedule(userId, ctx, 0, userBackupManagerService);
    }

    public static void schedule(int userId, Context ctx, long delay, UserBackupManagerService userBackupManagerService) {
        monitor-enter(KeyValueBackupJob.class);
    L26:
        th = th;
    L41:
        monitor-exit(KeyValueBackupJob.class);     // Catch: Throwable -> L26
        throw th;
    L17:
        th = th;
        goto L41
    L49:
        if (sScheduledForUserId.get(userId) == true) goto L39;
        if (userBackupManagerService.isFrameworkSchedulingEnabled() == false) goto L39;
        BackupManagerConstants constants = userBackupManagerService.getConstants();     // Catch: Throwable -> L17
        monitor-enter(constants);     // Catch: Throwable -> L17
        long interval = constants.getKeyValueBackupIntervalMilliseconds();     // Catch: Throwable -> L30
        long fuzz = constants.getKeyValueBackupFuzzMilliseconds();     // Catch: Throwable -> L30
        int networkType = constants.getKeyValueBackupRequiredNetworkType();     // Catch: Throwable -> L30
        boolean needsCharging = constants.getKeyValueBackupRequireCharging();     // Catch: Throwable -> L30
        monitor-exit(constants);     // Catch: Throwable -> L30
    L14:
        if (delay > 0) goto L20;
        long delay2 = ((long) new Random().nextInt((int) fuzz)) + interval;
    L45:
        Slog.d(TAG, "Scheduling k/v pass in " + ((delay2 / 1000) / 60) + " minutes");     // Catch: Throwable -> L28
        JobInfo.Builder builder = new JobInfo.Builder(getJobIdForUserId(userId), sKeyValueJobService).setMinimumLatency(delay2).setRequiredNetworkType(networkType).setRequiresCharging(needsCharging).setOverrideDeadline(86400000);     // Catch: Throwable -> L28
        Bundle extraInfo = new Bundle();     // Catch: Throwable -> L28
        extraInfo.putInt("userId", userId);     // Catch: Throwable -> L28
        builder.setTransientExtras(extraInfo);     // Catch: Throwable -> L28
        JobScheduler js = (JobScheduler) ctx.getSystemService("jobscheduler");     // Catch: Throwable -> L26
        js.schedule(builder.build());     // Catch: Throwable -> L26
        sScheduledForUserId.put(userId, true);     // Catch: Throwable -> L26
        SparseLongArray r0 = sNextScheduledForUserId;     // Catch: Throwable -> L26
        long interval2 = System.currentTimeMillis() + delay2;     // Catch: Throwable -> L26
        r0.put(userId, interval2);     // Catch: Throwable -> L26
        monitor-exit(KeyValueBackupJob.class);     // Catch: Throwable -> L26
        return;
    L28:
        th = th;
        goto L41
    L20:
        delay2 = delay;
    L30:
        th = th;
    L50:
        throw th;     // Catch: Throwable -> L34
    L36:
        th = th;
    L39:
        monitor-exit(KeyValueBackupJob.class);     // Catch: Throwable -> L34
        return;
    L34:
        th = th;
        goto L41
    }

    public static void cancel(int userId, Context ctx) {
        monitor-enter(KeyValueBackupJob.class);
        JobScheduler js = (JobScheduler) ctx.getSystemService("jobscheduler");     // Catch: Throwable -> L7
        js.cancel(getJobIdForUserId(userId));     // Catch: Throwable -> L7
        clearScheduledForUserId(userId);     // Catch: Throwable -> L7
        monitor-exit(KeyValueBackupJob.class);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static long nextScheduled(int userId) {
        monitor-enter(KeyValueBackupJob.class);
        long r1 = sNextScheduledForUserId.get(userId);     // Catch: Throwable -> L7
        monitor-exit(KeyValueBackupJob.class);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public static boolean isScheduled(int userId) {
        monitor-enter(KeyValueBackupJob.class);
        boolean r1 = sScheduledForUserId.get(userId);     // Catch: Throwable -> L7
        monitor-exit(KeyValueBackupJob.class);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // android.app.job.JobService
    public boolean onStartJob(JobParameters params) {
        int userId = params.getTransientExtras().getInt("userId");
        monitor-enter(KeyValueBackupJob.class);
        clearScheduledForUserId(userId);     // Catch: Throwable -> L13
        monitor-exit(KeyValueBackupJob.class);     // Catch: Throwable -> L13
        BackupManagerService service = BackupManagerService.getInstance();
        service.backupNowForUser(userId);     // Catch: RemoteException -> L9
        return false;
    L20:
        return false;
    L13:
        th = move-exception;
        throw th;
    }

    @Override // android.app.job.JobService
    public boolean onStopJob(JobParameters params) {
        return false;
    }

    private static void clearScheduledForUserId(int userId) {
        sScheduledForUserId.delete(userId);
        sNextScheduledForUserId.delete(userId);
    }

    static int getJobIdForUserId(int userId) {
        return JobIdManager.getJobIdForUserId(MIN_JOB_ID, 52418896, userId);
    }
}
