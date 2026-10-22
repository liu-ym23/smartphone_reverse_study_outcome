package com.ttnet.org.chromium.base.metrics;

/* JADX INFO: loaded from: classes4.dex */
interface NativeUmaRecorder$Natives {
    long recordBooleanHistogram(String r10, long r11, boolean r12);

    long recordExponentialHistogram(String r10, long r11, int r12, int r13, int r14, int r15);

    long recordLinearHistogram(String r10, long r11, int r12, int r13, int r14, int r15);

    long recordSparseHistogram(String r10, long r11, int r12);

    void recordUserAction(String r10, long r11);
}
