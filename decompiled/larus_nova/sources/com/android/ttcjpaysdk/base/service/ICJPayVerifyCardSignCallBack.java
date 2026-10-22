package com.android.ttcjpaysdk.base.service;

/* JADX INFO: loaded from: classes28.dex */
public interface ICJPayVerifyCardSignCallBack {
    void onCardSignFailed(String r100);

    void onCardSignStart();

    void onCardSignSuccess();

    void onTradeConfirmFailed(String r100);

    void onTradeConfirmStart();
}
