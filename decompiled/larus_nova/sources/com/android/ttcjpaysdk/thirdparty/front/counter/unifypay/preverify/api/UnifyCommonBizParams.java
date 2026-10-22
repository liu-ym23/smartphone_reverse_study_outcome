package com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.preverify.api;

import com.android.ttcjpaysdk.base.ui.data.CJPayPayInfo;
import com.android.ttcjpaysdk.thirdparty.data.CJPayCardSignBizContentParams;
import com.android.ttcjpaysdk.thirdparty.data.CJPayMerchantInfo;
import com.android.ttcjpaysdk.thirdparty.data.CJPayRiskInfo;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\tH&J\n\u0010\u000b\u001a\u0004\u0018\u00010\u0003H&J\n\u0010\f\u001a\u0004\u0018\u00010\rH&J\n\u0010\u000e\u001a\u0004\u0018\u00010\u0003H&J\b\u0010\u000f\u001a\u00020\u0003H&J\n\u0010\u0010\u001a\u0004\u0018\u00010\u0011H&J\n\u0010\u0012\u001a\u0004\u0018\u00010\u0003H&J\b\u0010\u0013\u001a\u00020\u0003H&J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\tH&¨\u0006\u0017"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/preverify/api/UnifyCommonBizParams;", "", "getAppId", "", "getCardSignBizContentParams", "Lcom/android/ttcjpaysdk/thirdparty/data/CJPayCardSignBizContentParams;", "getHttpRiskInfo", "Lcom/android/ttcjpaysdk/thirdparty/data/CJPayRiskInfo;", "resetIdentityToken", "", "getIsPayAgainScene", "getMerchantId", "getMerchantInfo", "Lcom/android/ttcjpaysdk/thirdparty/data/CJPayMerchantInfo;", "getOptionShowInfoDesc", "getOutTradeNo", "getProcessInfo", "Lorg/json/JSONObject;", "getPromotionScene", "getTradeNo", "getVerifyDescRegionInfo", "Lcom/android/ttcjpaysdk/base/ui/data/CJPayPayInfo$VerifyDescRegionInfo;", "isPwd", "bdpay-front-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface UnifyCommonBizParams {
    String getAppId();

    CJPayCardSignBizContentParams getCardSignBizContentParams();

    CJPayRiskInfo getHttpRiskInfo(boolean r100);

    boolean getIsPayAgainScene();

    String getMerchantId();

    CJPayMerchantInfo getMerchantInfo();

    String getOptionShowInfoDesc();

    String getOutTradeNo();

    JSONObject getProcessInfo();

    String getPromotionScene();

    String getTradeNo();

    CJPayPayInfo.VerifyDescRegionInfo getVerifyDescRegionInfo(boolean r100);
}
