package com.airbnb.lottie.utils;

/* JADX INFO: loaded from: classes.dex */
public class MeanCalculator {
    private int n;
    private float sum;

    public MeanCalculator() {
    }

    public void add(float r3) {
        float r0 = this.sum + r3;
        this.sum = r0;
        int r4 = this.n + 1;
        this.n = r4;
        if (r4 != Integer.MAX_VALUE) goto L6;
        this.sum = r0 / 2.0f;
        this.n = r4 / 2;
        return;
    }

    public float getMean() {
        int r0 = this.n;
        if (r0 != 0) goto L7;
        return 0.0f;
    L7:
        return this.sum / r0;
    }
}
