package com.stepos.statsapp.v3.lib.plugin.utils;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;

/* loaded from: classes2.dex */
public abstract class IntervalTimer {
    private static final int MSG = 1;
    private static final int SKIP = -1;
    private boolean mCancelled;
    private final long mCountdownInterval;
    private Handler mHandler;
    private long mTriggerTimeInFuture;

    public IntervalTimer(long j10) {
        this(null, j10);
    }

    public synchronized void cancel() {
        this.mCancelled = true;
        this.mHandler.removeMessages(1);
        this.mHandler.removeMessages(-1);
    }

    public abstract void onTrigger();

    public void skip() {
        this.mHandler.sendEmptyMessage(-1);
    }

    public synchronized IntervalTimer start() {
        this.mCancelled = false;
        this.mTriggerTimeInFuture = SystemClock.elapsedRealtime() + this.mCountdownInterval;
        Handler handler = this.mHandler;
        handler.sendMessage(handler.obtainMessage(1));
        return this;
    }

    public IntervalTimer(Looper looper, long j10) {
        this.mCancelled = false;
        this.mCountdownInterval = j10;
        this.mHandler = new Handler(looper == null ? Looper.getMainLooper() : looper) { // from class: com.stepos.statsapp.v3.lib.plugin.utils.IntervalTimer.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                synchronized (IntervalTimer.this) {
                    try {
                        if (!IntervalTimer.this.mCancelled) {
                            int i10 = message.what;
                            if (i10 == -1) {
                                IntervalTimer.this.mTriggerTimeInFuture = SystemClock.elapsedRealtime() + IntervalTimer.this.mCountdownInterval;
                            } else if (i10 == 1) {
                                long jElapsedRealtime = IntervalTimer.this.mTriggerTimeInFuture - SystemClock.elapsedRealtime();
                                if (jElapsedRealtime <= 0) {
                                    IntervalTimer.this.onTrigger();
                                    IntervalTimer intervalTimer = IntervalTimer.this;
                                    intervalTimer.mTriggerTimeInFuture = (intervalTimer.mTriggerTimeInFuture + IntervalTimer.this.mCountdownInterval) - jElapsedRealtime;
                                    sendMessageDelayed(obtainMessage(1), IntervalTimer.this.mCountdownInterval);
                                } else if (jElapsedRealtime <= IntervalTimer.this.mCountdownInterval) {
                                    sendMessageDelayed(obtainMessage(1), jElapsedRealtime);
                                }
                            }
                        }
                    } finally {
                    }
                }
            }
        };
    }
}
