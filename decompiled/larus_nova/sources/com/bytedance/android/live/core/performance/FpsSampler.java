package com.bytedance.android.live.core.performance;

import android.view.Choreographer;

/* JADX INFO: loaded from: classes45.dex */
public class FpsSampler extends BaseSampler<Double> implements Choreographer.FrameCallback {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f65105d;

    @Override // java.lang.Runnable
    public final void run() {
    }

    @Override // android.view.Choreographer.FrameCallback
    public final void doFrame(long r100) {
        if (this.f65105d != (-1)) goto L6;
        this.f65105d = r100;
    L6:
        throw null;
    }
}
