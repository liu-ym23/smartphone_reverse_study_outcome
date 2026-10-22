package com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.data.response;

import com.android.ttcjpaysdk.base.ui.data.AssetInfoBean;
import com.android.ttcjpaysdk.base.ui.data.CJPayButtonInfo;
import com.android.ttcjpaysdk.thirdparty.data.CJPayCardSignInfo;
import com.android.ttcjpaysdk.thirdparty.data.CJPayResultRespExts;
import com.android.ttcjpaysdk.thirdparty.data.ForgetPwdInfo;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&J\n\u0010\b\u001a\u0004\u0018\u00010\tH&J\n\u0010\n\u001a\u0004\u0018\u00010\u000bH&J\b\u0010\f\u001a\u00020\u0007H&J\n\u0010\r\u001a\u0004\u0018\u00010\u0007H&J\n\u0010\u000e\u001a\u0004\u0018\u00010\u0007H&J\n\u0010\u000f\u001a\u0004\u0018\u00010\u0010H&J\n\u0010\u0011\u001a\u0004\u0018\u00010\u0007H&J\n\u0010\u0012\u001a\u0004\u0018\u00010\u0010H&J\n\u0010\u0013\u001a\u0004\u0018\u00010\u0014H&J\n\u0010\u0015\u001a\u0004\u0018\u00010\u0016H&J\b\u0010\u0017\u001a\u00020\u0018H&¨\u0006\u0019"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/data/response/ICJUnifyPayTradeConfirmResp;", "", "getButtonInfo", "Lcom/android/ttcjpaysdk/base/ui/data/CJPayButtonInfo;", "getCardSignInfo", "Lcom/android/ttcjpaysdk/thirdparty/data/CJPayCardSignInfo;", "getCode", "", "getExts", "Lcom/android/ttcjpaysdk/thirdparty/data/CJPayResultRespExts;", "getForgetPwdInfo", "Lcom/android/ttcjpaysdk/thirdparty/data/ForgetPwdInfo;", "getLogId", "getMobile", "getMsg", "getProcessInfo", "Lorg/json/JSONObject;", "getProcessPassThrough", "getPwdErrorPop", "getUnifyCashierResult", "Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/data/response/CJUnifyPayCashierResultResponseBean;", "getUsedAssetInfo", "Lcom/android/ttcjpaysdk/base/ui/data/AssetInfoBean;", "isSuccess", "", "bdpay-front-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface ICJUnifyPayTradeConfirmResp {
    CJPayButtonInfo getButtonInfo();

    CJPayCardSignInfo getCardSignInfo();

    String getCode();

    CJPayResultRespExts getExts();

    ForgetPwdInfo getForgetPwdInfo();

    String getLogId();

    String getMobile();

    String getMsg();

    JSONObject getProcessInfo();

    String getProcessPassThrough();

    JSONObject getPwdErrorPop();

    CJUnifyPayCashierResultResponseBean getUnifyCashierResult();

    AssetInfoBean getUsedAssetInfo();

    boolean isSuccess();
}
