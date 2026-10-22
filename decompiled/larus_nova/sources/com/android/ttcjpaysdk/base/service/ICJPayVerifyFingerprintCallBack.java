package com.android.ttcjpaysdk.base.service;

/* JADX INFO: loaded from: classes28.dex */
public interface ICJPayVerifyFingerprintCallBack {
    void onFingerprintCancel(String r100);

    void onFingerprintStart();

    void onTradeConfirmFailed(String r100, String r101);

    void onTradeConfirmStart();
}
