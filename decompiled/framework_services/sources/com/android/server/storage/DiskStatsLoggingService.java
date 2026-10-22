package com.android.server.storage;

import android.app.job.JobInfo;
import android.app.job.JobParameters;
import android.app.job.JobScheduler;
import android.app.job.JobService;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.PackageStats;
import android.os.AsyncTask;
import android.os.BatteryManager;
import android.os.Environment;
import android.os.UserHandle;
import android.os.storage.VolumeInfo;
import android.provider.Settings;
import android.util.Log;
import com.android.server.pm.PackageManagerService;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public class DiskStatsLoggingService extends JobService {
    public static final String DUMPSYS_CACHE_PATH = "/data/system/diskstats_cache.json";
    private static final int JOB_DISKSTATS_LOGGING = 1145656139;
    private static final String TAG = "DiskStatsLogService";
    private static ComponentName sDiskStatsLoggingService;

    static class LogRunnable implements Runnable {
        private static final long TIMEOUT_MILLIS = 0;
        private AppCollector mCollector;
        private Context mContext;
        private File mDownloadsDirectory;
        private JobService mJobService;
        private File mOutputFile;
        private JobParameters mParams;
        private long mSystemSize;

        LogRunnable() {
        }

        static {
            TIMEOUT_MILLIS = TimeUnit.MINUTES.toMillis(10);
        }

        public void setDownloadsDirectory(File file) {
            this.mDownloadsDirectory = file;
        }

        public void setAppCollector(AppCollector collector) {
            this.mCollector = collector;
        }

        public void setLogOutputFile(File file) {
            this.mOutputFile = file;
        }

        public void setSystemSize(long size) {
            this.mSystemSize = size;
        }

        public void setContext(Context context) {
            this.mContext = context;
        }

        public void setJobService(JobService jobService, JobParameters params) {
            this.mJobService = jobService;
            this.mParams = params;
        }

        @Override // java.lang.Runnable
        public void run() {
            FileCollector.MeasurementResult mainCategories = FileCollector.getMeasurementResult(this.mContext);     // Catch: IllegalStateException -> L10
            FileCollector.MeasurementResult downloads = FileCollector.getMeasurementResult(this.mDownloadsDirectory);
            boolean needsReschedule = true;
            List<PackageStats> stats = this.mCollector.getPackageStats(TIMEOUT_MILLIS);
            if (stats == null) goto L7;
            needsReschedule = false;
            logToFile(mainCategories, downloads, stats, this.mSystemSize);
        L8:
            finishJob(needsReschedule);
            return;
        L7:
            Log.w(DiskStatsLoggingService.TAG, "Timed out while fetching package stats.");
        L10:
            e = move-exception;
            Log.e(DiskStatsLoggingService.TAG, "Error while measuring storage", e);
            finishJob(true);
        }

        private void logToFile(FileCollector.MeasurementResult mainCategories, FileCollector.MeasurementResult downloads, List<PackageStats> stats, long systemSize) {
            DiskStatsFileLogger logger = new DiskStatsFileLogger(mainCategories, downloads, stats, systemSize);
            this.mOutputFile.createNewFile();     // Catch: IOException -> L5
            logger.dumpToFile(this.mOutputFile);     // Catch: IOException -> L5
            return;
        L5:
            e = move-exception;
            Log.e(DiskStatsLoggingService.TAG, "Exception while writing opportunistic disk file cache.", e);
        }

        private void finishJob(boolean needsReschedule) {
            if (this.mJobService == null) goto L6;
            this.mJobService.jobFinished(this.mParams, needsReschedule);
            return;
        }
    }

    public DiskStatsLoggingService() {
    }

    static {
        sDiskStatsLoggingService = new ComponentName(PackageManagerService.PLATFORM_PACKAGE_NAME, DiskStatsLoggingService.class.getName());
    }

    @Override // android.app.job.JobService
    public boolean onStartJob(JobParameters params) {
        if (isCharging(this) == true) goto L5;
    L12:
        jobFinished(params, true);
        return false;
    L5:
        if (isDumpsysTaskEnabled(getContentResolver()) == false) goto L12;
        VolumeInfo volume = getPackageManager().getPrimaryStorageCurrentVolume();
        if (volume != null) goto L10;
        return false;
    L10:
        AppCollector collector = new AppCollector(this, volume);
        int userId = UserHandle.myUserId();
        Environment.UserEnvironment environment = new Environment.UserEnvironment(userId);
        LogRunnable task = new LogRunnable();
        task.setDownloadsDirectory(environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS));
        task.setSystemSize(FileCollector.getSystemSize(this));
        task.setLogOutputFile(new File(DUMPSYS_CACHE_PATH));
        task.setAppCollector(collector);
        task.setJobService(this, params);
        task.setContext(this);
        AsyncTask.execute(task);
        return true;
    }

    @Override // android.app.job.JobService
    public boolean onStopJob(JobParameters params) {
        return false;
    }

    public static void schedule(Context context) {
        JobScheduler js = (JobScheduler) context.getSystemService("jobscheduler");
        js.schedule(new JobInfo.Builder(JOB_DISKSTATS_LOGGING, sDiskStatsLoggingService).setRequiresDeviceIdle(true).setRequiresCharging(true).setPeriodic(TimeUnit.DAYS.toMillis(1)).build());
    }

    private static boolean isCharging(Context context) {
        BatteryManager batteryManager = (BatteryManager) context.getSystemService("batterymanager");
        if (batteryManager != null) goto L5;
        return false;
    L5:
        return batteryManager.isCharging();
    }

    static boolean isDumpsysTaskEnabled(ContentResolver resolver) {
        if (Settings.Global.getInt(resolver, "enable_diskstats_logging", 1) != 0) goto L7;
        return false;
    L7:
        return true;
    }
}
