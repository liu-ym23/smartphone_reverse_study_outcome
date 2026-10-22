package com.android.ttcjpaysdk.base.service;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
public interface ICJPayVerifyQueryParams {
    String getAppId();

    JSONObject getHttpRiskInfo(boolean r100);

    String getMerchantId();

    JSONObject getProcessInfo();

    String getQueryMethod();

    int getQueryResultTimes();

    String getTradeNo();
}
