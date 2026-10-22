package com.tmall.wireless.tangram.support;

import android.os.Handler;
import android.os.Looper;

/* JADX INFO: loaded from: classes4.dex */
public class HandlerTimer implements Runnable, ITimer {
    private Handler mHandler;
    private long mInterval;
    private long mStartTS;
    private TimerStatus mStatus;
    private Runnable mTask;

    public static final enum TimerStatus extends Enum<TimerStatus> {
        private static final /* synthetic */ TimerStatus[] $VALUES = null;
        public static final TimerStatus Paused = null;
        public static final TimerStatus Running = null;
        public static final TimerStatus Stopped = null;
        public static final TimerStatus Waiting = null;
        private int code;
        private String desc;

        private static /* synthetic */ TimerStatus[] $values() {
            return new TimerStatus[]{Waiting, Running, Paused, Stopped};
        }

        static {
            Waiting = new TimerStatus("Waiting", 0, 0, "Wating");
            Running = new TimerStatus("Running", 1, 1, "Running");
            Paused = new TimerStatus("Paused", 2, -1, "Paused");
            Stopped = new TimerStatus("Stopped", 3, -2, "Stopped");
            $VALUES = $values();
        }

        private TimerStatus(String r10, int r11, int r12, String r13) {
            super(r10, r11);
            this.code = r12;
            this.desc = r13;
        }

        public static TimerStatus valueOf(String r10) {
            return (TimerStatus) Enum.valueOf(TimerStatus.class, r10);
        }

        public static TimerStatus[] values() {
            return (TimerStatus[]) $VALUES.clone();
        }

        public int getCode() {
            return this.code;
        }

        public String getDesc() {
            return this.desc;
        }

        public void setCode(int r10) {
            this.code = r10;
        }

        public void setDesc(String r10) {
            this.desc = r10;
        }
    }

    public HandlerTimer(Runnable r10) {
        this(1000, r10);
    }

    @Override // com.tmall.wireless.tangram.support.ITimer
    public void cancel() {
        this.mStatus = TimerStatus.Stopped;
        this.mHandler.removeCallbacks(this);
    }

    public TimerStatus getStatus() {
        return this.mStatus;
    }

    @Override // com.tmall.wireless.tangram.support.ITimer
    public void pause() {
        this.mStatus = TimerStatus.Paused;
        this.mHandler.removeCallbacks(this);
    }

    @Override // com.tmall.wireless.tangram.support.ITimer
    public void restart() {
        this.mHandler.removeCallbacks(this);
        this.mStatus = TimerStatus.Running;
        this.mHandler.postDelayed(this, this.mInterval);
    }

    @Override // java.lang.Runnable
    public final void run() {
        TimerStatus r10 = this.mStatus;
        if (r10 != TimerStatus.Waiting) goto L5;
        return;
    L5:
        if (r10 != TimerStatus.Paused) goto L7;
        return;
    L7:
        if (r10 == TimerStatus.Stopped) goto L17;
        this.mTask.run();
        long r11 = this.mInterval;
        long r12 = System.currentTimeMillis() - this.mStartTS;
        long r13 = this.mInterval;
        long r14 = r11 - (r12 % r13);
        Handler r15 = this.mHandler;
        if (r14 == 0) goto L13;
        r13 = r14;
    L13:
        r15.postDelayed(this, r13);
        return;
    }

    @Override // com.tmall.wireless.tangram.support.ITimer
    public void start() {
        start(false);
    }

    @Override // com.tmall.wireless.tangram.support.ITimer
    public void stop() {
        this.mStatus = TimerStatus.Stopped;
        this.mHandler.removeCallbacks(this);
    }

    public HandlerTimer(long r10, Runnable r11) {
        this(r10, r11, new Handler(Looper.getMainLooper()));
    }

    @Override // com.tmall.wireless.tangram.support.ITimer
    public void start(boolean r10) {
        TimerStatus r11 = this.mStatus;
        TimerStatus r12 = TimerStatus.Running;
        if (r11 == r12) goto L9;
        if (r10 == false) goto L6;
        long r13 = 0;
    L7:
        this.mStartTS = r13;
        this.mHandler.removeCallbacks(this);
        this.mStatus = r12;
        long r14 = this.mInterval - ((System.currentTimeMillis() - this.mStartTS) % this.mInterval);
        this.mHandler.postDelayed(this, r14);
        return;
    L6:
        r13 = System.currentTimeMillis();
        goto L7
    }

    public HandlerTimer(long r10, Runnable r11, Handler r12) {
        this.mStartTS = 0;
        if (r12 == null) goto L8;
        if (r11 == null) goto L8;
        this.mInterval = r10;
        this.mTask = r11;
        this.mHandler = r12;
        this.mStatus = TimerStatus.Waiting;
        return;
    L8:
        throw new NullPointerException("handler or task must not be null");
    }
}
