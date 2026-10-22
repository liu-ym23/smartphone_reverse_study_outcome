package com.android.ttcjpaysdk.base.service;

import android.content.Context;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
public interface ICJPayWXPaymentService extends ICJPayBasisPaymentService {
    void endSession();

    void executePay(Context r100, String r101, JSONObject r102, ICJPayBasisPaymentService.OnPayResultCallback r103, ICJPayBasisPaymentService.OnResultCallback r104, String r105);

    boolean isWXUnInstalled(Context r100, String r101);
}
