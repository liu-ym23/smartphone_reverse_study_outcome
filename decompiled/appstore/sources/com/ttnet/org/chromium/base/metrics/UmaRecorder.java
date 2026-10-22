package com.ttnet.org.chromium.base.metrics;

/* JADX INFO: loaded from: classes4.dex */
public interface UmaRecorder {
    void recordBooleanHistogram(String r10, boolean r11);

    void recordExponentialHistogram(String r10, int r11, int r12, int r13, int r14);

    void recordLinearHistogram(String r10, int r11, int r12, int r13, int r14);

    void recordSparseHistogram(String r10, int r11);

    void recordUserAction(String r10, long r11);
}
