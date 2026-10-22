package com.monitor.cloudmessage.callback;

/* JADX INFO: loaded from: classes3.dex */
public interface IABTestConsumer extends IConsumerResultCallback {
    boolean isUpdateABTestInfoInSP();

    void notifyABTestModelUpdate(String r10, Object r11);

    void notifyABTestSPUpdate(String r10, Object r11);
}
