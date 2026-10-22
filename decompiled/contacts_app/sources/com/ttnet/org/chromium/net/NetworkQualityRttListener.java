package com.ttnet.org.chromium.net;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes4.dex */
public abstract class NetworkQualityRttListener {
    private final Executor mExecutor;

    public abstract void onRttObservation(int r1, long r2, int r4);

    public NetworkQualityRttListener(Executor r1) {
        if (r1 == null) goto L7;
        this.mExecutor = r1;
        return;
    L7:
        throw new IllegalStateException("Executor must not be null");
    }

    public Executor getExecutor() {
        return this.mExecutor;
    }
}
