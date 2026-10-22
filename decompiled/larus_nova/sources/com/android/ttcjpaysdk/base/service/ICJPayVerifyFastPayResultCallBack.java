package com.android.ttcjpaysdk.base.service;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
public interface ICJPayVerifyFastPayResultCallBack {
    void onCancel();

    void onFailed(JSONObject r100, boolean r101);

    void onHideLoading(String r100);

    void onShowLoading();

    void onSuccess(JSONObject r100, boolean r101);
}
