package com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.data.response;

import com.android.ttcjpaysdk.base.json.CJPayObject;
import com.android.ttcjpaysdk.base.ui.data.AssetInfoBean;
import com.android.ttcjpaysdk.base.ui.data.CJPayButtonInfo;
import com.android.ttcjpaysdk.integrated.counter.data.CounterTradeErrorBean;
import com.android.ttcjpaysdk.thirdparty.data.CJPayCardSignInfo;
import com.android.ttcjpaysdk.thirdparty.data.CJPayResultRespExts;
import com.android.ttcjpaysdk.thirdparty.data.ForgetPwdInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\n\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\n\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0005H\u0016J\n\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\n\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0005H\u0016J\n\u0010\u0015\u001a\u0004\u0018\u00010\u0005H\u0016J\n\u0010\u0016\u001a\u0004\u0018\u00010\u0005H\u0016J\n\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\n\u0010\u0019\u001a\u0004\u0018\u00010\u0005H\u0016J\n\u0010\u001a\u001a\u0004\u0018\u00010\u0018H\u0016J\n\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\n\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\b\u0010\u001f\u001a\u00020 H\u0016R\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/data/response/CJUnifyPayTradeConfirmBean;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/data/response/ICJUnifyPayTradeConfirmResp;", "()V", "code", "", "data", "Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/data/response/CJUnifyPayTradeConfirmDataBean;", "error", "Lcom/android/ttcjpaysdk/integrated/counter/data/CounterTradeErrorBean;", "log_id", "getButtonInfo", "Lcom/android/ttcjpaysdk/base/ui/data/CJPayButtonInfo;", "getCardSignInfo", "Lcom/android/ttcjpaysdk/thirdparty/data/CJPayCardSignInfo;", "getCode", "getExts", "Lcom/android/ttcjpaysdk/thirdparty/data/CJPayResultRespExts;", "getForgetPwdInfo", "Lcom/android/ttcjpaysdk/thirdparty/data/ForgetPwdInfo;", "getLogId", "getMobile", "getMsg", "getProcessInfo", "Lorg/json/JSONObject;", "getProcessPassThrough", "getPwdErrorPop", "getUnifyCashierResult", "Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/data/response/CJUnifyPayCashierResultResponseBean;", "getUsedAssetInfo", "Lcom/android/ttcjpaysdk/base/ui/data/AssetInfoBean;", "isSuccess", "", "bdpay-front-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJUnifyPayTradeConfirmBean implements CJPayObject, ICJUnifyPayTradeConfirmResp {
    public String code;
    public CJUnifyPayTradeConfirmDataBean data;
    public CounterTradeErrorBean error;
    public String log_id;

    public CJUnifyPayTradeConfirmBean() {
    }

    @Override // com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.data.response.ICJUnifyPayTradeConfirmResp
    public String getCode() {
        String r100 = this.code;
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100;
    }

    @Override // com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.data.response.ICJUnifyPayTradeConfirmResp
    public String getLogId() {
        String r100 = this.log_id;
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100;
    }

    @Override // com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.data.response.ICJUnifyPayTradeConfirmResp
    public String getProcessPassThrough() {
        CJUnifyPayTradeConfirmDataBean r100 = this.data;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.process_pass_through;
    }

    @Override // com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.data.response.ICJUnifyPayTradeConfirmResp
    public CJUnifyPayCashierResultResponseBean getUnifyCashierResult() {
        CJUnifyPayTradeConfirmDataBean r100 = this.data;
        if (r100 == null) goto L7;
        CJUnifyPayTradeConfirmDataBean.UnifyCashierPayResult r101 = r100.unify_cashier_pay_result;
        if (r101 == null) goto L7;
        return r101.response;
    L7:
        return null;
    }

    @Override // com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.data.response.ICJUnifyPayTradeConfirmResp
    public boolean isSuccess() {
        if (Intrinsics.areEqual(this.code, "CA0000") == false) goto L18;
        CJUnifyPayTradeConfirmDataBean r100 = this.data;
        if (r100 == null) goto L11;
        CJUnifyPayTradeConfirmDataBean.UnifyCashierPayResult r101 = r100.unify_cashier_pay_result;
        if (r101 == null) goto L11;
        CJUnifyPayCashierResultResponseBean r102 = r101.response;
        if (r102 == null) goto L11;
        Boolean r103 = Boolean.valueOf(r102.isSuccess());
    L12:
        if (r103 == null) goto L14;
        boolean r104 = r103.booleanValue();
    L15:
        if (r104 == false) goto L19;
        return true;
    L19:
        return false;
    L14:
        r104 = false;
    L11:
        r103 = null;
        goto L12
    L18:
        return false;
    }

    @Override // com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.data.response.ICJUnifyPayTradeConfirmResp
    public CJPayButtonInfo getButtonInfo() {
        CJUnifyPayCashierResultResponseBean r100 = getUnifyCashierResult();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.button_info;
    }

    @Override // com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.data.response.ICJUnifyPayTradeConfirmResp
    public CJPayCardSignInfo getCardSignInfo() {
        CJUnifyPayCashierResultResponseBean r100 = getUnifyCashierResult();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.card_sign_info;
    }

    @Override // com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.data.response.ICJUnifyPayTradeConfirmResp
    public CJPayResultRespExts getExts() {
        CJUnifyPayCashierResultResponseBean r100 = getUnifyCashierResult();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.exts;
    }

    @Override // com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.data.response.ICJUnifyPayTradeConfirmResp
    public ForgetPwdInfo getForgetPwdInfo() {
        CJUnifyPayCashierResultResponseBean r100 = getUnifyCashierResult();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.forget_pwd_info;
    }

    @Override // com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.data.response.ICJUnifyPayTradeConfirmResp
    public String getMobile() {
        CJUnifyPayCashierResultResponseBean r100 = getUnifyCashierResult();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.mobile;
    }

    @Override // com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.data.response.ICJUnifyPayTradeConfirmResp
    public String getMsg() {
        CJUnifyPayCashierResultResponseBean r100 = getUnifyCashierResult();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.msg;
    }

    @Override // com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.data.response.ICJUnifyPayTradeConfirmResp
    public JSONObject getProcessInfo() {
        CJUnifyPayCashierResultResponseBean r100 = getUnifyCashierResult();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.process_info;
    }

    @Override // com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.data.response.ICJUnifyPayTradeConfirmResp
    public JSONObject getPwdErrorPop() {
        CJUnifyPayCashierResultResponseBean r100 = getUnifyCashierResult();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.pwd_error_pop;
    }

    @Override // com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.data.response.ICJUnifyPayTradeConfirmResp
    public AssetInfoBean getUsedAssetInfo() {
        CJUnifyPayCashierResultResponseBean r100 = getUnifyCashierResult();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.used_asset_info;
    }
}
