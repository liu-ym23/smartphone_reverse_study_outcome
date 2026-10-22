package com.facebook.rebound;

/* JADX INFO: loaded from: classes2.dex */
public abstract class SpringLooper {
    protected BaseSpringSystem mSpringSystem;

    public SpringLooper() {
    }

    public void setSpringSystem(BaseSpringSystem r10) {
        this.mSpringSystem = r10;
    }

    public abstract void start();

    public abstract void stop();
}
