package com.android.server;

import android.app.job.JobInfo;
import android.app.job.JobParameters;
import android.app.job.JobScheduler;
import android.app.job.JobService;
import android.content.ComponentName;
import android.content.Context;
import android.os.FileUtils;
import android.os.SystemProperties;
import android.util.Slog;
import com.android.server.pm.PackageManagerService;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class ZramWriteback extends JobService {
    private static final String BDEV_SYS = "/sys/block/zram%d/backing_dev";
    private static final boolean DEBUG = false;
    private static final String FIRST_WB_DELAY_PROP = "ro.zram.first_wb_delay_mins";
    private static final String FORCE_WRITEBACK_PROP = "zram.force_writeback";
    private static final String IDLE_SYS = "/sys/block/zram%d/idle";
    private static final String IDLE_SYS_ALL_PAGES = "all";
    private static final String MARK_IDLE_DELAY_PROP = "ro.zram.mark_idle_delay_mins";
    private static final int MARK_IDLE_JOB_ID = 811;
    private static final int MAX_ZRAM_DEVICES = 256;
    private static final String PERIODIC_WB_DELAY_PROP = "ro.zram.periodic_wb_delay_hours";
    private static final String TAG = "ZramWriteback";
    private static final int WB_STATS_MAX_FILE_SIZE = 128;
    private static final String WB_STATS_SYS = "/sys/block/zram%d/bd_stat";
    private static final String WB_SYS = "/sys/block/zram%d/writeback";
    private static final String WB_SYS_IDLE_PAGES = "idle";
    private static final int WRITEBACK_IDLE_JOB_ID = 812;
    private static int sZramDeviceId;
    private static final ComponentName sZramWriteback = null;

    /* JADX INFO: renamed from: -$$Nest$mmarkAndFlushPages, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m527$$Nest$mmarkAndFlushPages(ZramWriteback r0) {
        r0.markAndFlushPages();
    }

    /* JADX INFO: renamed from: -$$Nest$smschedNextWriteback, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m528$$Nest$smschedNextWriteback(Context r0) {
        schedNextWriteback(r0);
    }

    public ZramWriteback() {
    }

    static {
        sZramWriteback = new ComponentName(PackageManagerService.PLATFORM_PACKAGE_NAME, ZramWriteback.class.getName());
        sZramDeviceId = 0;
    }

    private void markPagesAsIdle() {
        String idlePath = String.format(IDLE_SYS, new Object[]{Integer.valueOf(sZramDeviceId)});
        FileUtils.stringToFile(new File(idlePath), "all");     // Catch: IOException -> L5
        return;
    L6:
        Slog.e(TAG, "Failed to write to " + idlePath);
    }

    private void flushIdlePages() {
        String wbPath = String.format(WB_SYS, new Object[]{Integer.valueOf(sZramDeviceId)});
        FileUtils.stringToFile(new File(wbPath), WB_SYS_IDLE_PAGES);     // Catch: IOException -> L5
        return;
    L6:
        Slog.e(TAG, "Failed to write to " + wbPath);
    }

    private int getWrittenPageCount() {
        String wbStatsPath = String.format(WB_STATS_SYS, new Object[]{Integer.valueOf(sZramDeviceId)});
        String wbStats = FileUtils.readTextFile(new File(wbStatsPath), 128, "");     // Catch: IOException -> L5
        return Integer.parseInt(wbStats.trim().split("\\s+")[2], 10);
    L6:
        Slog.e(TAG, "Failed to read writeback stats from " + wbStatsPath);
        return -1;
    }

    private void markAndFlushPages() {
        int pageCount = getWrittenPageCount();
        flushIdlePages();
        markPagesAsIdle();
        if (pageCount == (-1)) goto L6;
        Slog.i(TAG, "Total pages written to disk is " + (getWrittenPageCount() - pageCount));
        return;
    }

    private static boolean isWritebackEnabled() {
        String backingDev = FileUtils.readTextFile(new File(String.format(BDEV_SYS, new Object[]{Integer.valueOf(sZramDeviceId)})), 128, "");     // Catch: IOException -> L9
        if ("none".equals(backingDev.trim()) == true) goto L7;
        return true;
    L7:
        Slog.w(TAG, "Writeback device is not set");     // Catch: IOException -> L9
        return false;
    L10:
        Slog.w(TAG, "Writeback is not enabled on zram");
        return false;
    }

    private static void schedNextWriteback(Context context) {
        int nextWbDelay = SystemProperties.getInt(PERIODIC_WB_DELAY_PROP, 24);
        boolean forceWb = SystemProperties.getBoolean(FORCE_WRITEBACK_PROP, false);
        JobScheduler js = (JobScheduler) context.getSystemService("jobscheduler");
        js.schedule(new JobInfo.Builder(WRITEBACK_IDLE_JOB_ID, sZramWriteback).setMinimumLatency(TimeUnit.HOURS.toMillis(nextWbDelay)).setRequiresDeviceIdle(!forceWb).build());
    }

    @Override // android.app.job.JobService
    public boolean onStartJob(final JobParameters params) {
        if (isWritebackEnabled() == true) goto L7;
        jobFinished(params, false);
        return false;
    L7:
        if (params.getJobId() != MARK_IDLE_JOB_ID) goto L10;
        markPagesAsIdle();
        jobFinished(params, false);
        return false;
    L10:
        final String r1 = "ZramWriteback_WritebackIdlePages";
        new AnonymousClass1(this, r1, params).start();
        return true;
    }

    @Override // android.app.job.JobService
    public boolean onStopJob(JobParameters params) {
        return false;
    }

    public static void scheduleZramWriteback(Context context) {
        int markIdleDelay = SystemProperties.getInt(MARK_IDLE_DELAY_PROP, 20);
        int firstWbDelay = SystemProperties.getInt(FIRST_WB_DELAY_PROP, 180);
        boolean forceWb = SystemProperties.getBoolean(FORCE_WRITEBACK_PROP, false);
        JobScheduler js = (JobScheduler) context.getSystemService("jobscheduler");
        js.schedule(new JobInfo.Builder(MARK_IDLE_JOB_ID, sZramWriteback).setMinimumLatency(TimeUnit.MINUTES.toMillis(markIdleDelay)).build());
        js.schedule(new JobInfo.Builder(WRITEBACK_IDLE_JOB_ID, sZramWriteback).setMinimumLatency(TimeUnit.MINUTES.toMillis(firstWbDelay)).setRequiresDeviceIdle(!forceWb).build());
    }
}
