package com.android.ttcjpaysdk.thirdparty.verify.params;

import com.android.ttcjpaysdk.thirdparty.data.CJPayProcessInfo;
import com.android.ttcjpaysdk.thirdparty.data.CJPayRiskInfo;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
public interface VerifyTradeQueryParams {
    String getAppId();

    JSONObject getExts();

    CJPayRiskInfo getHttpRiskInfo(boolean r100);

    String getMerchantId();

    String getMethod();

    CJPayProcessInfo getProcessInfo();

    int getQueryResultTimes();

    String getTradeNo();

    JSONObject getVerifyInfo();
}
