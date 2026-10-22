package com.facebook.rebound;

/* JADX INFO: loaded from: classes2.dex */
public class SteppingLooper extends SpringLooper {
    private long mLastTime;
    private boolean mStarted;

    public SteppingLooper() {
    }

    @Override // com.facebook.rebound.SpringLooper
    public void start() {
        this.mStarted = true;
        this.mLastTime = 0;
    }

    public boolean step(long r10) {
        BaseSpringSystem r11 = this.mSpringSystem;
        if (r11 != null) goto L5;
        return false;
    L5:
        if (this.mStarted == false) goto L11;
        long r12 = this.mLastTime + r10;
        r11.loop(r12);
        this.mLastTime = r12;
        return this.mSpringSystem.getIsIdle();
    L11:
        return false;
    }

    @Override // com.facebook.rebound.SpringLooper
    public void stop() {
        this.mStarted = false;
    }
}
