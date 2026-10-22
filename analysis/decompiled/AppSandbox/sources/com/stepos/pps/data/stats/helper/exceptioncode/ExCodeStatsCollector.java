package com.stepos.pps.data.stats.helper.exceptioncode;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.BatteryManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.SystemClock;
import android.provider.Settings;
import com.stepos.pps.common.ThreadPool;
import com.stepos.pps.data.stats.utilities.ICollector;
import com.stepos.pps.data.util.Constants;
import com.stepos.pps.data.util.DataFinderHelper;
import com.stepos.pps.data.util.LogUtil;
import com.stepos.pps.data.util.Utils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class ExCodeStatsCollector {
    private static final long GET_METRICS_DELAY_MS = 60000;
    private static final long NON_CHARGING_MIN_INTERVAL_MS = 10800000;
    private static final String TAG = "ExCodeStatsCollector";
    private List<ICollector> mCollectors = new ArrayList();
    private final Context mContext;
    private ExCodeSettingsObserver mExCodeCollectingSettingsObserver;
    private boolean mExceptionCodeCollecting;
    private final Runnable mGetMetricsRunnable;
    private final Handler mHandler;
    private final HandlerThread mHandlerThread;
    private long mLastGetMetricsElapsed;
    private final BroadcastReceiver mScreenReceiver;

    /* JADX INFO: Access modifiers changed from: private */
    public boolean shouldGetMetricsNow() {
        if (isCharging()) {
            LogUtil.d(TAG, "Charging, run getMetrics directly");
            return true;
        }
        if (this.mLastGetMetricsElapsed != 0) {
            long jElapsedRealtime = SystemClock.elapsedRealtime() - this.mLastGetMetricsElapsed;
            if (jElapsedRealtime < NON_CHARGING_MIN_INTERVAL_MS) {
                LogUtil.d(TAG, "Not charging and last getMetrics was " + jElapsedRealtime + "ms ago (< 3h), skip");
                return false;
            }
        }
        return true;
    }

    private boolean isCharging() {
        BatteryManager batteryManager = (BatteryManager) this.mContext.getSystemService("batterymanager");
        if (batteryManager != null) {
            return batteryManager.isCharging();
        }
        Intent intentRegisterReceiver = this.mContext.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        return (intentRegisterReceiver == null || intentRegisterReceiver.getIntExtra("plugged", 0) == 0) ? false : true;
    }

    public ExCodeStatsCollector(Context context) {
        HandlerThread handlerThread = new HandlerThread("ExCodeHandlerThread");
        this.mHandlerThread = handlerThread;
        this.mLastGetMetricsElapsed = 0L;
        this.mExceptionCodeCollecting = true;
        this.mExCodeCollectingSettingsObserver = null;
        this.mGetMetricsRunnable = new Runnable() { // from class: com.stepos.pps.data.stats.helper.exceptioncode.ExCodeStatsCollector.1
            @Override // java.lang.Runnable
            public void run() {
                if (!ExCodeStatsCollector.this.mExceptionCodeCollecting) {
                    LogUtil.d(ExCodeStatsCollector.TAG, "Skipping delayed getMetrics: exception code collecting disabled");
                } else if (ExCodeStatsCollector.this.shouldGetMetricsNow()) {
                    ExCodeStatsCollector.this.mLastGetMetricsElapsed = SystemClock.elapsedRealtime();
                    LogUtil.d(ExCodeStatsCollector.TAG, "Executing delayed getMetrics after screen off");
                    ExCodeStatsCollector.this.getMetrics();
                }
            }
        };
        this.mScreenReceiver = new BroadcastReceiver() { // from class: com.stepos.pps.data.stats.helper.exceptioncode.ExCodeStatsCollector.2
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context2, Intent intent) {
                String action = intent.getAction();
                if ("android.intent.action.SCREEN_OFF".equals(action)) {
                    if (!ExCodeStatsCollector.this.mExceptionCodeCollecting) {
                        LogUtil.d(ExCodeStatsCollector.TAG, "Screen off but collecting disabled, skip scheduling getMetrics");
                        return;
                    }
                    LogUtil.d(ExCodeStatsCollector.TAG, "Screen off detected, scheduling getMetrics in 1 minute");
                    ExCodeStatsCollector.this.mHandler.removeCallbacks(ExCodeStatsCollector.this.mGetMetricsRunnable);
                    ExCodeStatsCollector.this.mHandler.postDelayed(ExCodeStatsCollector.this.mGetMetricsRunnable, ExCodeStatsCollector.GET_METRICS_DELAY_MS);
                    return;
                }
                if ("android.intent.action.SCREEN_ON".equals(action)) {
                    LogUtil.d(ExCodeStatsCollector.TAG, "Screen on detected, cancelling pending getMetrics");
                    ExCodeStatsCollector.this.mHandler.removeCallbacks(ExCodeStatsCollector.this.mGetMetricsRunnable);
                }
            }
        };
        this.mCollectors.add(new ExCodeMetricsCollector(context));
        this.mContext = context;
        handlerThread.start();
        Handler handler = new Handler(handlerThread.getLooper());
        this.mHandler = handler;
        this.mExceptionCodeCollecting = Utils.canDataCollect(context);
        this.mExCodeCollectingSettingsObserver = new ExCodeSettingsObserver(handler);
        context.getContentResolver().registerContentObserver(Settings.System.getUriFor(Constants.SETTINGS_KEY_DATA_COLLECT), true, this.mExCodeCollectingSettingsObserver);
        doChangeCollect();
        registerScreenReceiver();
    }

    private void registerScreenReceiver() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        this.mContext.registerReceiver(this.mScreenReceiver, intentFilter, null, this.mHandler);
    }

    public void startCollecting() {
        Iterator<ICollector> it = this.mCollectors.iterator();
        while (it.hasNext()) {
            it.next().startCollecting();
        }
        setupJobScheduler();
    }

    public void stopCollecting() {
        cancelJobScheduler();
        Iterator<ICollector> it = this.mCollectors.iterator();
        while (it.hasNext()) {
            it.next().stopCollecting();
        }
    }

    private void setupJobScheduler() {
        ExCodeReportJobService.scheduleReportJob(this.mContext);
    }

    private void cancelJobScheduler() {
        ExCodeReportJobService.cancelSchedule(this.mContext);
    }

    public void getMetrics() {
        if (!Utils.canDataCollect(this.mContext)) {
            LogUtil.w(TAG, "Ignore getMetrics for user privacy!!!");
        } else {
            ThreadPool.getInstance().execute(new Runnable() { // from class: com.stepos.pps.data.stats.helper.exceptioncode.ExCodeStatsCollector$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.getMetricsInner();
                }
            });
        }
    }

    public void getMetricsInner() {
        Iterator<ICollector> it = this.mCollectors.iterator();
        while (it.hasNext()) {
            it.next().getMetrics();
        }
    }

    public void doChangeCollect() {
        if (this.mExceptionCodeCollecting) {
            startCollecting();
        } else {
            this.mHandler.removeCallbacks(this.mGetMetricsRunnable);
            stopCollecting();
        }
    }

    public void onUserTypeChanged() {
        this.mHandler.post(new Runnable() { // from class: com.stepos.pps.data.stats.helper.exceptioncode.ExCodeStatsCollector$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$onUserTypeChanged$0();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onUserTypeChanged$0() {
        boolean zCanDataCollect = Utils.canDataCollect(this.mContext);
        if (this.mExceptionCodeCollecting != zCanDataCollect) {
            this.mExceptionCodeCollecting = zCanDataCollect;
            LogUtil.d(TAG, "user_type changed, exception code collecting = " + this.mExceptionCodeCollecting);
            doChangeCollect();
            DataFinderHelper.onDataCollectConsentChanged(this.mContext);
        }
    }

    private class ExCodeSettingsObserver extends ContentObserver {
        ExCodeSettingsObserver(Handler handler) {
            super(handler);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z, Uri uri) {
            boolean zCanDataCollect = Utils.canDataCollect(ExCodeStatsCollector.this.mContext);
            if (ExCodeStatsCollector.this.mExceptionCodeCollecting != zCanDataCollect) {
                ExCodeStatsCollector.this.mExceptionCodeCollecting = zCanDataCollect;
                LogUtil.d(ExCodeStatsCollector.TAG, "change collect state exception code collecting = " + ExCodeStatsCollector.this.mExceptionCodeCollecting);
                ExCodeStatsCollector.this.doChangeCollect();
                DataFinderHelper.onDataCollectConsentChanged(ExCodeStatsCollector.this.mContext);
            }
        }
    }
}
