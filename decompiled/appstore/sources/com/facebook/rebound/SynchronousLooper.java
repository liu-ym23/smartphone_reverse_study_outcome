package com.facebook.rebound;

/* JADX INFO: loaded from: classes2.dex */
public class SynchronousLooper extends SpringLooper {
    public static double SIXTY_FPS = 16.6667d;
    private boolean mRunning;
    private double mTimeStep;

    static {
    }

    public SynchronousLooper() {
        this.mTimeStep = SIXTY_FPS;
    }

    public double getTimeStep() {
        return this.mTimeStep;
    }

    public void setTimeStep(double r10) {
        this.mTimeStep = r10;
    }

    @Override // com.facebook.rebound.SpringLooper
    public void start() {
        this.mRunning = true;
    L4:
        if (this.mSpringSystem.getIsIdle() == true) goto L9;
        if (this.mRunning == false) goto L12;
        this.mSpringSystem.loop(this.mTimeStep);
        goto L4
    L12:
        return;
    }

    @Override // com.facebook.rebound.SpringLooper
    public void stop() {
        this.mRunning = false;
    }
}
