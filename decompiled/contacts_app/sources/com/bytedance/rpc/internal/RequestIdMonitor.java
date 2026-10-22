package com.bytedance.rpc.internal;

import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
public class RequestIdMonitor {
    private int mMaxValue;
    private int mMinValue;
    private AtomicInteger mSeqIdProducer;

    public RequestIdMonitor(int r2, int r3) {
        this.mSeqIdProducer = new AtomicInteger(r2);
        this.mMinValue = r2;
        this.mMaxValue = r3;
    }

    public int generateRingId() {
        int r0 = this.mSeqIdProducer.getAndIncrement();
        if (r0 < this.mMaxValue) goto L5;
        this.mSeqIdProducer.set(this.mMinValue);
    L5:
        return r0;
    }
}
