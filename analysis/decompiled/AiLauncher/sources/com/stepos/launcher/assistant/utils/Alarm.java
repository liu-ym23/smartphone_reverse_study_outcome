package com.stepos.launcher.assistant.utils;

import android.os.Handler;
import android.os.SystemClock;

/* loaded from: classes.dex */
public class Alarm implements Runnable {
    private OnAlarmListener mAlarmListener;
    private long mAlarmTriggerTime;
    private boolean mWaitingForCallback;
    private boolean mAlarmPending = false;
    private Handler mHandler = new Handler();

    public boolean alarmPending() {
        return this.mAlarmPending;
    }

    public void cancelAlarm() {
        this.mAlarmPending = false;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.mWaitingForCallback = false;
        if (this.mAlarmPending) {
            long jUptimeMillis = SystemClock.uptimeMillis();
            long j10 = this.mAlarmTriggerTime;
            if (j10 > jUptimeMillis) {
                this.mHandler.postDelayed(this, Math.max(0L, j10 - jUptimeMillis));
                this.mWaitingForCallback = true;
                return;
            }
            this.mAlarmPending = false;
            OnAlarmListener onAlarmListener = this.mAlarmListener;
            if (onAlarmListener != null) {
                onAlarmListener.onAlarm(this);
            }
        }
    }

    public void setAlarm(long j10) {
        long jUptimeMillis = SystemClock.uptimeMillis();
        this.mAlarmPending = true;
        long j11 = this.mAlarmTriggerTime;
        long j12 = j10 + jUptimeMillis;
        this.mAlarmTriggerTime = j12;
        if (this.mWaitingForCallback && j11 > j12) {
            this.mHandler.removeCallbacks(this);
            this.mWaitingForCallback = false;
        }
        if (this.mWaitingForCallback) {
            return;
        }
        this.mHandler.postDelayed(this, this.mAlarmTriggerTime - jUptimeMillis);
        this.mWaitingForCallback = true;
    }

    public void setOnAlarmListener(OnAlarmListener onAlarmListener) {
        this.mAlarmListener = onAlarmListener;
    }
}
