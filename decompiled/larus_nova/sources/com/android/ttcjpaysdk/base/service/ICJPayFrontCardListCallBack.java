package com.android.ttcjpaysdk.base.service;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
public interface ICJPayFrontCardListCallBack extends ICJPayServiceCallBack {
    JSONObject getCommonParams();

    JSONObject getPayNewCardConfigs();

    void onCardListResult(JSONObject r100, int r101, String r102);

    void onClose();

    void showLoading(Boolean r100, String r101);
}
