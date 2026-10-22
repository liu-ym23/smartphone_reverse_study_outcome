package com.android.server.powerstats;

import android.app.AlarmManager;
import android.content.Context;
import android.os.Handler;

/* JADX INFO: loaded from: classes3.dex */
public final class TimerTrigger extends PowerStatsLogTrigger {
    private static final boolean DEBUG = false;
    private static final long LOG_PERIOD_MS_HIGH_FREQUENCY = 120000;
    private static final long LOG_PERIOD_MS_LOW_FREQUENCY = 3600000;
    private static final String TAG = null;
    private final AlarmManager mAlarmManager;
    private final Handler mHandler;

    class PeriodicTimer implements Runnable, AlarmManager.OnAlarmListener {
        private final int mMsgType;
        private final String mName;
        private final long mPeriodMs;
        final /* synthetic */ TimerTrigger this$0;

        PeriodicTimer(TimerTrigger this$0, String name, long periodMs, int msgType) {
            this.this$0 = this$0;
            this.mName = name;
            this.mPeriodMs = periodMs;
            this.mMsgType = msgType;
        }

        @Override // android.app.AlarmManager.OnAlarmListener
        public void onAlarm() {
            run();
        }

        @Override // java.lang.Runnable
        public void run() {
            TimerTrigger.m7888$$Nest$fgetmHandler(this.this$0).postDelayed(this, this.mPeriodMs);
            this.this$0.logPowerStatsData(this.mMsgType);
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmHandler, reason: not valid java name */
    static /* bridge */ /* synthetic */ Handler m7888$$Nest$fgetmHandler(TimerTrigger r0) {
        return r0.mHandler;
    }

    static {
        TAG = TimerTrigger.class.getSimpleName();
    }

    public TimerTrigger(Context context, PowerStatsLogger powerStatsLogger, boolean triggerEnabled) {
        super(context, powerStatsLogger);
        this.mHandler = this.mContext.getMainThreadHandler();
        this.mAlarmManager = (AlarmManager) this.mContext.getSystemService(AlarmManager.class);
        if (triggerEnabled == false) goto L6;
        PeriodicTimer logDataLowFrequency = new PeriodicTimer(this, "PowerStatsLowFreqLog", 3600000, 1);
        PeriodicTimer logDataHighFrequency = new PeriodicTimer(this, "PowerStatsHighFreqLog", 120000, 2);
        logDataLowFrequency.run();
        logDataHighFrequency.run();
        return;
    }
}
