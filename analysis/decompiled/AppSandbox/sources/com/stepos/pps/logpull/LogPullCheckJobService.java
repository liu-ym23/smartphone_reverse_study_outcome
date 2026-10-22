package com.stepos.pps.logpull;

import android.app.job.JobInfo;
import android.app.job.JobParameters;
import android.app.job.JobScheduler;
import android.app.job.JobService;
import android.content.ComponentName;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import com.stepos.pps.PPSApplication;
import com.stepos.pps.data.util.Constants;

/* loaded from: classes.dex */
public class LogPullCheckJobService extends JobService {
    static final long BASE_INTERVAL_MS = 900000;
    private static final long FLEX_MS = 300000;
    private static final int JOB_ID = "pps_logpull_config_check".hashCode();
    private static final String KEY_EMPTY_STREAK = "empty_streak";
    static final long MAX_BACKOFF_MS = 14400000;
    private static final String PREFS = "logpull_check_job";
    static final long RETRY_INTERVAL_MS = 300000;
    private static final String TAG = "LogPull.CheckJob";

    @Override // android.app.job.JobService
    public boolean onStartJob(final JobParameters jobParameters) {
        Log.i(TAG, "onStartJob");
        new Thread(new Runnable() { // from class: com.stepos.pps.logpull.LogPullCheckJobService$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$onStartJob$0(jobParameters);
            }
        }, "LogPullCheckJob").start();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onStartJob$0(JobParameters jobParameters) {
        PPSApplication pPSApplication;
        try {
            try {
                pPSApplication = PPSApplication.getInstance();
            } finally {
                try {
                    LogPullDateCleanupReceiver.cleanupNow(getApplicationContext());
                } catch (Exception e) {
                    Log.w(TAG, "残留清理异常", e);
                }
                jobFinished(jobParameters, false);
            }
        } catch (Exception e2) {
            Log.e(TAG, "check job 异常", e2);
            scheduleNext(this, Constants.SYSTEM_SERVER_INTERVAL);
            try {
                LogPullDateCleanupReceiver.cleanupNow(getApplicationContext());
            } catch (Exception e3) {
                e = e3;
                Log.w(TAG, "残留清理异常", e);
                jobFinished(jobParameters, false);
            }
        }
        if (pPSApplication == null) {
            Log.w(TAG, "PPSApplication 未就绪，稍后重试");
            scheduleNext(this, Constants.SYSTEM_SERVER_INTERVAL);
            return;
        }
        if (!LogCollectionGate.isLogPullAllowed(pPSApplication)) {
            Log.i(TAG, "check job gated: 稳定性体验计划未开启或 mp 机型");
            cancel(this);
            try {
                LogPullDateCleanupReceiver.cleanupNow(getApplicationContext());
            } catch (Exception e4) {
                Log.w(TAG, "残留清理异常", e4);
            }
            jobFinished(jobParameters, false);
            return;
        }
        LogPullPoller logPullPoller = pPSApplication.getLogPullPoller();
        if (logPullPoller == null) {
            Log.w(TAG, "LogPullPoller 未启动，稍后重试");
            scheduleNext(this, Constants.SYSTEM_SERVER_INTERVAL);
            try {
                LogPullDateCleanupReceiver.cleanupNow(getApplicationContext());
            } catch (Exception e5) {
                Log.w(TAG, "残留清理异常", e5);
            }
            jobFinished(jobParameters, false);
            return;
        }
        int iRunScheduledCheck = logPullPoller.runScheduledCheck();
        long jDelayAfterResult = delayAfterResult(this, iRunScheduledCheck);
        scheduleNext(this, jDelayAfterResult);
        Log.i(TAG, "check 完成 result=" + iRunScheduledCheck + " nextDelayMs=" + jDelayAfterResult);
        try {
            LogPullDateCleanupReceiver.cleanupNow(getApplicationContext());
        } catch (Exception e6) {
            e = e6;
            Log.w(TAG, "残留清理异常", e);
            jobFinished(jobParameters, false);
        }
        jobFinished(jobParameters, false);
    }

    @Override // android.app.job.JobService
    public boolean onStopJob(JobParameters jobParameters) {
        Log.w(TAG, "onStopJob — 请求重试");
        return true;
    }

    public static void ensureScheduled(Context context) {
        scheduleNext(context, 0L);
    }

    public static void scheduleImmediate(Context context) {
        resetEmptyStreak(context);
        scheduleNext(context, 0L);
    }

    public static void resetBackoffToBase(Context context) {
        resetEmptyStreak(context);
        scheduleNext(context, BASE_INTERVAL_MS);
        Log.i(TAG, "跨天重置退避：下一轮 check 回到 900000ms");
    }

    public static void cancel(Context context) {
        JobScheduler jobScheduler = (JobScheduler) context.getSystemService("jobscheduler");
        if (jobScheduler != null) {
            jobScheduler.cancel(JOB_ID);
            Log.i(TAG, "job cancelled");
        }
    }

    static long delayAfterResult(Context context, int i) {
        SharedPreferences sharedPreferencesPrefs = prefs(context);
        long jMin = BASE_INTERVAL_MS;
        if (i == 1) {
            sharedPreferencesPrefs.edit().putInt(KEY_EMPTY_STREAK, 0).apply();
            return BASE_INTERVAL_MS;
        }
        int i2 = sharedPreferencesPrefs.getInt(KEY_EMPTY_STREAK, 0) + 1;
        sharedPreferencesPrefs.edit().putInt(KEY_EMPTY_STREAK, i2).apply();
        for (int i3 = 1; i3 < i2 && jMin < 14400000; i3++) {
            jMin = Math.min(jMin * 2, 14400000L);
        }
        return jMin;
    }

    static void resetEmptyStreak(Context context) {
        prefs(context).edit().putInt(KEY_EMPTY_STREAK, 0).apply();
    }

    private static SharedPreferences prefs(Context context) {
        return context.getApplicationContext().getSharedPreferences(PREFS, 0);
    }

    private static void scheduleNext(Context context, long j) {
        JobScheduler jobScheduler = (JobScheduler) context.getSystemService("jobscheduler");
        if (jobScheduler == null) {
            Log.e(TAG, "JobScheduler 不可用");
            return;
        }
        long jMax = Math.max(0L, j);
        int iSchedule = jobScheduler.schedule(new JobInfo.Builder(JOB_ID, new ComponentName(context, (Class<?>) LogPullCheckJobService.class)).setRequiredNetworkType(1).setMinimumLatency(jMax).setOverrideDeadline(Constants.SYSTEM_SERVER_INTERVAL + jMax).setPersisted(true).build());
        if (iSchedule == 1) {
            Log.i(TAG, "scheduled latencyMs=" + jMax);
        } else {
            Log.e(TAG, "schedule failed result=" + iSchedule);
        }
    }
}
