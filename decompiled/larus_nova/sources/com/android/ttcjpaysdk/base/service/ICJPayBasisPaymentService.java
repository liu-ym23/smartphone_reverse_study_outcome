package com.android.ttcjpaysdk.base.service;

import android.content.Context;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
public interface ICJPayBasisPaymentService extends ICJPayService {
    public static final String USE_VISIBLE_CALLBACK = "use_visible_callback";

    public interface OnPayResultCallback {
        void onCancel(int r100);

        void onDisplayCMBEnterToast(Context r100, String r101);

        void onEvent(String r100, String r101);

        void onFailure(int r100);

        void onPayStart();

        void onProcessing(int r100);

        void onShowErrorInfo(Context r100, String r101);

        void onSuccess(int r100);
    }

    public interface OnResultCallback {
        void onResult(JSONObject r100);
    }

    void executePay(Context r100, String r101, JSONObject r102, OnPayResultCallback r103, OnResultCallback r104);

    void pay(Context r100, String r101, String r102, OnPayResultCallback r103, OnResultCallback r104, JSONObject r105);

    void releasePaySession();
}
