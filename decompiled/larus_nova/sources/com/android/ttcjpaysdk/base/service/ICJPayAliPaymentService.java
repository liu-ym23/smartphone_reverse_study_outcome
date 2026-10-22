package com.android.ttcjpaysdk.base.service;

import android.app.Activity;
import android.content.Context;

/* JADX INFO: loaded from: classes28.dex */
public interface ICJPayAliPaymentService extends ICJPayBasisPaymentService {

    public interface OnSignResultCallback {
        void onResult(int r100, String r101);
    }

    void independentSign(Activity r100, String r101, String r102, String r103, OnSignResultCallback r104);

    void independentSignWithH5(Activity r100, String r101);

    void payWithAlipayH5(Context r100, String r101);
}
