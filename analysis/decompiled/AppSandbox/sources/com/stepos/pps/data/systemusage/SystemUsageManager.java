package com.stepos.pps.data.systemusage;

import android.app.job.JobInfo;
import android.app.job.JobParameters;
import android.app.job.JobScheduler;
import android.app.job.JobService;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Log;
import com.stepos.pps.PPSApplication;
import com.stepos.pps.common.ThreadPool;
import java.io.PrintWriter;
import java.util.Objects;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;

/* loaded from: classes.dex */
public class SystemUsageManager {
    private static final long FLEX_MS = 1800000;
    private static final int JOB_ID_DAILY = 279248897;
    private static final long ONE_DAY_MS = 86400000;
    private static final String TAG = "SystemUsageManager";
    private static volatile SystemUsageManager sInstance;
    private final BootDurationDataCollect mBootDuration;
    private final Context mContext;
    private final DeviceUsageDataCollect mDeviceUsage;
    private final Handler mHandler;
    private final ProcessLifecycleCollector mProcLife;
    private final BroadcastReceiver mReceiver = new SystemReceiver();
    private final UptimeProcessCollector mUptime;

    public SystemUsageManager(PPSApplication pPSApplication) {
        Context applicationContext = pPSApplication.getApplicationContext();
        this.mContext = applicationContext;
        HandlerThread handlerThread = new HandlerThread("SystemUsage");
        handlerThread.start();
        Handler handler = new Handler(handlerThread.getLooper());
        this.mHandler = handler;
        this.mDeviceUsage = new DeviceUsageDataCollect(applicationContext, handler);
        final ProcessLifecycleCollector processLifecycleCollector = new ProcessLifecycleCollector(applicationContext, handler);
        this.mProcLife = processLifecycleCollector;
        final BootDurationDataCollect bootDurationDataCollect = new BootDurationDataCollect(applicationContext, handler);
        this.mBootDuration = bootDurationDataCollect;
        this.mUptime = new UptimeProcessCollector(applicationContext);
        sInstance = this;
        registerReceivers();
        scheduleDailyJob();
        ThreadPool.getInstance().execute(new Runnable() { // from class: com.stepos.pps.data.systemusage.SystemUsageManager$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() throws JSONException {
                this.f$0.lambda$new$0();
            }
        });
        Objects.requireNonNull(processLifecycleCollector);
        handler.post(new Runnable() { // from class: com.stepos.pps.data.systemusage.SystemUsageManager$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() throws JSONException, NumberFormatException {
                processLifecycleCollector.recover();
            }
        });
        Objects.requireNonNull(bootDurationDataCollect);
        handler.post(new Runnable() { // from class: com.stepos.pps.data.systemusage.SystemUsageManager$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                bootDurationDataCollect.recover();
            }
        });
        handler.post(new Runnable() { // from class: com.stepos.pps.data.systemusage.SystemUsageManager$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.reportUptimeProcs();
            }
        });
        Log.i(TAG, "SystemUsageManager initialized");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0() throws JSONException {
        this.mDeviceUsage.recover();
    }

    public static SystemUsageManager getInstance() {
        return sInstance;
    }

    private void registerReceivers() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        intentFilter.addAction("android.intent.action.USER_PRESENT");
        intentFilter.addAction("android.intent.action.DATE_CHANGED");
        intentFilter.addAction("android.intent.action.TIME_SET");
        intentFilter.addAction("android.intent.action.TIMEZONE_CHANGED");
        intentFilter.addAction("android.intent.action.ACTION_SHUTDOWN");
        try {
            this.mContext.registerReceiver(this.mReceiver, intentFilter);
            Log.d(TAG, "system receiver registered");
        } catch (Throwable th) {
            Log.e(TAG, "registerReceivers failed: " + th.getMessage());
        }
    }

    private void scheduleDailyJob() {
        try {
            JobScheduler jobScheduler = (JobScheduler) this.mContext.getSystemService("jobscheduler");
            if (jobScheduler != null && jobScheduler.getPendingJob(JOB_ID_DAILY) == null) {
                JobInfo.Builder requiredNetworkType = new JobInfo.Builder(JOB_ID_DAILY, new ComponentName(this.mContext, (Class<?>) DailyJobService.class)).setPersisted(true).setRequiredNetworkType(1);
                requiredNetworkType.setPeriodic(86400000L, FLEX_MS);
                Log.d(TAG, "scheduleDailyJob ret=" + jobScheduler.schedule(requiredNetworkType.build()));
            }
        } catch (Throwable th) {
            Log.e(TAG, "scheduleDailyJob failed: " + th.getMessage());
        }
    }

    void onDateChanged() throws JSONException {
        Log.i(TAG, "onDateChanged");
        this.mDeviceUsage.onDateChanged();
        this.mProcLife.onDateChanged();
        this.mBootDuration.onDateChanged();
        reportUptimeProcs();
    }

    void onTimeOrTimezoneChanged() throws JSONException, NumberFormatException {
        Log.w(TAG, "time/timezone changed; recover state and check backfill");
        this.mDeviceUsage.recover();
        this.mProcLife.recover();
        this.mBootDuration.recover();
        reportUptimeProcs();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportUptimeProcs() {
        this.mUptime.reportFor(this.mBootDuration.getLastReportedDate(), this.mBootDuration.getLastReportedOnMs());
    }

    void onScreenOn(long j) throws JSONException {
        this.mDeviceUsage.onScreenOn(j);
    }

    void onScreenOff(long j) {
        this.mDeviceUsage.onScreenOff(j);
    }

    void onUserPresent() {
        this.mDeviceUsage.heartbeat();
    }

    void onShutdown() {
        Log.w(TAG, "ACTION_SHUTDOWN received");
        this.mBootDuration.onShutdown();
        this.mDeviceUsage.onShutdown();
    }

    void onDailyJob() throws JSONException {
        this.mDeviceUsage.reportYesterday();
        this.mProcLife.reportYesterday();
        this.mBootDuration.reportYesterday();
        reportUptimeProcs();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onProcStarted$1(int i, int i2, String str, long j, long j2) {
        this.mProcLife.onProcessStarted(i, i2, str, j, j2);
    }

    public void onProcStarted(final int i, final int i2, final String str, final long j, final long j2) {
        this.mHandler.post(new Runnable() { // from class: com.stepos.pps.data.systemusage.SystemUsageManager$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$onProcStarted$1(i, i2, str, j, j2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onProcDied$2(int i, long j) {
        this.mProcLife.onProcessDied(i, j);
    }

    public void onProcDied(final int i, final long j) {
        this.mHandler.post(new Runnable() { // from class: com.stepos.pps.data.systemusage.SystemUsageManager$$ExternalSyntheticLambda6
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$onProcDied$2(i, j);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    final class SystemReceiver extends BroadcastReceiver {
        private SystemReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            final String action = intent == null ? null : intent.getAction();
            if (action == null) {
                return;
            }
            final long jCurrentTimeMillis = System.currentTimeMillis();
            SystemUsageManager.this.mHandler.post(new Runnable() { // from class: com.stepos.pps.data.systemusage.SystemUsageManager$SystemReceiver$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() throws JSONException, NumberFormatException {
                    this.f$0.lambda$onReceive$0(action, jCurrentTimeMillis);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onReceive$0(String str, long j) throws JSONException, NumberFormatException {
            str.hashCode();
            switch (str) {
                case "android.intent.action.SCREEN_OFF":
                    SystemUsageManager.this.onScreenOff(j);
                    break;
                case "android.intent.action.SCREEN_ON":
                    SystemUsageManager.this.onScreenOn(j);
                    break;
                case "android.intent.action.TIMEZONE_CHANGED":
                case "android.intent.action.TIME_SET":
                    SystemUsageManager.this.onTimeOrTimezoneChanged();
                    break;
                case "android.intent.action.USER_PRESENT":
                    SystemUsageManager.this.onUserPresent();
                    break;
                case "android.intent.action.DATE_CHANGED":
                    SystemUsageManager.this.onDateChanged();
                    break;
                case "android.intent.action.ACTION_SHUTDOWN":
                    SystemUsageManager.this.onShutdown();
                    break;
            }
        }
    }

    public static class DailyJobService extends JobService {
        @Override // android.app.job.JobService
        public boolean onStopJob(JobParameters jobParameters) {
            return true;
        }

        @Override // android.app.job.JobService
        public boolean onStartJob(final JobParameters jobParameters) {
            Log.d(SystemUsageManager.TAG, "DailyJobService onStartJob");
            ThreadPool.getInstance().execute(new Runnable() { // from class: com.stepos.pps.data.systemusage.SystemUsageManager$DailyJobService$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onStartJob$0(jobParameters);
                }
            });
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onStartJob$0(JobParameters jobParameters) {
            PPSApplication pPSApplication;
            try {
                SystemUsageManager systemUsageManager = SystemUsageManager.sInstance;
                if (systemUsageManager == null && (pPSApplication = PPSApplication.getInstance()) != null) {
                    systemUsageManager = new SystemUsageManager(pPSApplication);
                }
                if (systemUsageManager != null) {
                    systemUsageManager.onDailyJob();
                }
            } catch (Throwable th) {
                try {
                    Log.e(SystemUsageManager.TAG, "Job execute error: " + th.getMessage(), th);
                } finally {
                    jobFinished(jobParameters, false);
                }
            }
        }
    }

    public void dumpAppAlive(final PrintWriter printWriter) {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        this.mHandler.post(new Runnable() { // from class: com.stepos.pps.data.systemusage.SystemUsageManager$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$dumpAppAlive$3(printWriter, countDownLatch);
            }
        });
        try {
            countDownLatch.await(2L, TimeUnit.SECONDS);
        } catch (InterruptedException unused) {
            printWriter.println("Dump timed out while waiting for SystemUsage thread");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$dumpAppAlive$3(PrintWriter printWriter, CountDownLatch countDownLatch) {
        try {
            this.mProcLife.dump(printWriter);
        } finally {
            countDownLatch.countDown();
        }
    }

    public void dumpBootDur(PrintWriter printWriter) {
        BootDurationDataCollect bootDurationDataCollect = this.mBootDuration;
        if (bootDurationDataCollect != null) {
            bootDurationDataCollect.dump(printWriter);
        }
        UptimeProcessCollector uptimeProcessCollector = this.mUptime;
        if (uptimeProcessCollector != null) {
            uptimeProcessCollector.dump(printWriter);
        }
    }

    public void dumpDeviceUsage(PrintWriter printWriter) {
        DeviceUsageDataCollect deviceUsageDataCollect = this.mDeviceUsage;
        if (deviceUsageDataCollect != null) {
            deviceUsageDataCollect.dump(printWriter);
        }
    }
}
