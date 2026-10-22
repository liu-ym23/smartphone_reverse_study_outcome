package com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.process.mode;

import com.android.ttcjpaysdk.thirdparty.data.CJPayRiskInfo;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\u0003H&J\b\u0010\u000b\u001a\u00020\u0003H&J\b\u0010\f\u001a\u00020\u0003H&J\b\u0010\r\u001a\u00020\u0003H&J\b\u0010\u000e\u001a\u00020\u0003H&J\b\u0010\u000f\u001a\u00020\u0005H&J\b\u0010\u0010\u001a\u00020\u0011H&J\b\u0010\u0012\u001a\u00020\u0003H&¨\u0006\u0013"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/process/mode/CJUnifyTradeQueryReqParams;", "", "getAppId", "", "getExts", "Lorg/json/JSONObject;", "getHttpRiskInfo", "Lcom/android/ttcjpaysdk/thirdparty/data/CJPayRiskInfo;", "resetIdentityToken", "", "getIntegratedAppId", "getIntegratedMerchantId", "getIntegratedProcessInfo", "getMerchantId", "getMethod", "getProcessInfo", "getQueryResultTimes", "", "getTradeNo", "bdpay-front-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface CJUnifyTradeQueryReqParams {
    String getAppId();

    JSONObject getExts();

    CJPayRiskInfo getHttpRiskInfo(boolean r100);

    String getIntegratedAppId();

    String getIntegratedMerchantId();

    String getIntegratedProcessInfo();

    String getMerchantId();

    String getMethod();

    JSONObject getProcessInfo();

    int getQueryResultTimes();

    String getTradeNo();
}
