package com.android.server;

import android.app.job.JobInfo;
import android.app.job.JobParameters;
import android.app.job.JobScheduler;
import android.app.job.JobService;
import android.content.ComponentName;
import android.content.Context;
import com.android.server.pm.PackageManagerService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public class SmartStorageMaintIdler extends JobService {
    private static final int SMART_MAINT_JOB_ID = 2808;
    private static final ComponentName SMART_STORAGE_MAINT_SERVICE = null;
    private static final String TAG = "SmartStorageMaintIdler";
    private final Runnable mFinishCallback;
    private JobParameters mJobParams;
    private final AtomicBoolean mStarted;

    /* JADX INFO: renamed from: -$$Nest$fgetmFinishCallback, reason: not valid java name */
    static /* bridge */ /* synthetic */ Runnable m307$$Nest$fgetmFinishCallback(SmartStorageMaintIdler r0) {
        return r0.mFinishCallback;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmJobParams, reason: not valid java name */
    static /* bridge */ /* synthetic */ JobParameters m308$$Nest$fgetmJobParams(SmartStorageMaintIdler r0) {
        return r0.mJobParams;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmStarted, reason: not valid java name */
    static /* bridge */ /* synthetic */ AtomicBoolean m309$$Nest$fgetmStarted(SmartStorageMaintIdler r0) {
        return r0.mStarted;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmJobParams, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m310$$Nest$fputmJobParams(SmartStorageMaintIdler r0, JobParameters r1) {
        r0.mJobParams = r1;
    }

    public SmartStorageMaintIdler() {
        this.mStarted = new AtomicBoolean(false);
        this.mFinishCallback = new AnonymousClass1(this);
    }

    static {
        SMART_STORAGE_MAINT_SERVICE = new ComponentName(PackageManagerService.PLATFORM_PACKAGE_NAME, SmartStorageMaintIdler.class.getName());
    }

    @Override // android.app.job.JobService
    public boolean onStartJob(final JobParameters params) {
        final StorageManagerService ms = StorageManagerService.sSelf;
        if (this.mStarted.compareAndSet(false, true) == false) goto L8;
        new AnonymousClass2(this, params, ms).start();
        if (ms != null) goto L7;
        return false;
    L7:
        return true;
    L8:
        return false;
    }

    @Override // android.app.job.JobService
    public boolean onStopJob(JobParameters params) {
        this.mStarted.set(false);
        return false;
    }

    public static void scheduleSmartIdlePass(Context context, int nMinutes) {
        StorageManagerService ms = StorageManagerService.sSelf;
        if (ms != null) goto L5;
        return;
    L5:
        if (ms.isPassedLifetimeThresh() == true) goto L10;
        JobScheduler tm = (JobScheduler) context.getSystemService(JobScheduler.class);
        long nextScheduleTime = TimeUnit.MINUTES.toMillis(nMinutes);
        JobInfo.Builder builder = new JobInfo.Builder(2808, SMART_STORAGE_MAINT_SERVICE);
        builder.setMinimumLatency(nextScheduleTime);
        tm.schedule(builder.build());
        return;
    }
}
