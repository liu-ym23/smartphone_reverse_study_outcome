package com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.data.response;

import com.alipay.sdk.m.k.b;
import com.android.ttcjpaysdk.base.json.CJPayObject;
import com.android.ttcjpaysdk.base.ui.data.AssetInfoBean;
import com.android.ttcjpaysdk.base.ui.data.CJPayButtonInfo;
import com.android.ttcjpaysdk.base.ui.data.IconTips;
import com.android.ttcjpaysdk.thirdparty.data.CJPayCardSignInfo;
import com.android.ttcjpaysdk.thirdparty.data.CJPayDoubleCheckVerifyInfo;
import com.android.ttcjpaysdk.thirdparty.data.CJPayFaceVerifyInfo;
import com.android.ttcjpaysdk.thirdparty.data.CJPayInsufficientBalanceHintInfo;
import com.android.ttcjpaysdk.thirdparty.data.CJPayPayTypeInfo;
import com.android.ttcjpaysdk.thirdparty.data.CJPayResultRespExts;
import com.android.ttcjpaysdk.thirdparty.data.CJPayThreeDomainSecurityEnroll;
import com.android.ttcjpaysdk.thirdparty.data.CombineLimitInfo;
import com.android.ttcjpaysdk.thirdparty.data.ForgetPwdInfo;
import com.android.ttcjpaysdk.thirdparty.data.RecommendVerifyInfo;
import com.android.ttcjpaysdk.thirdparty.data.TradeConfirmResultInfo;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u00108\u001a\u00020\bH\u0016J\b\u00109\u001a\u00020\nH\u0016J\b\u0010:\u001a\u00020\u0005H\u0016J\b\u0010;\u001a\u00020\u0016H\u0016J\b\u0010<\u001a\u00020\u001cH\u0016J\b\u0010=\u001a\u00020\u0005H\u0016J\n\u0010>\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010?\u001a\u00020\u0005H\u0016J\b\u0010@\u001a\u00020)H\u0016J\n\u0010A\u001a\u0004\u0018\u00010\u0005H\u0016J\n\u0010B\u001a\u0004\u0018\u00010)H\u0016J\b\u0010C\u001a\u00020\u0000H\u0016J\n\u0010D\u001a\u0004\u0018\u00010\u001aH\u0016J\b\u0010E\u001a\u00020FH\u0016R\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\"\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\u00050\fj\b\u0012\u0004\u0012\u00020\u0005`\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000e\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000f\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0010\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0012\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\u0004\u0018\u00010\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0015\u001a\u00020\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0017\u001a\u00020\u00188\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001b\u001a\u00020\u001c8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001d\u001a\u00020\u001e8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001f\u001a\u00020 8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010!\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\"\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010#\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010$\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010%\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010&\u001a\u00020'8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010(\u001a\u00020)8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010*\u001a\u0004\u0018\u00010)8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010+\u001a\u00020,8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010-\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010.\u001a\u00020,8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010/\u001a\u0002008\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u00101\u001a\u0002028\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u00103\u001a\u0002048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u00105\u001a\u0004\u0018\u00010)8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u00106\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u00107\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006G"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/data/response/CJUnifyPayCashierResultResponseBean;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/data/response/ICJUnifyPayTradeConfirmResp;", "()V", "bank_card_id", "", "biz_fail_reason", "button_info", "Lcom/android/ttcjpaysdk/base/ui/data/CJPayButtonInfo;", "card_sign_info", "Lcom/android/ttcjpaysdk/thirdparty/data/CJPayCardSignInfo;", "cashier_tag", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "change_pay_type_desc", "code", "combine_limit_button", "Lcom/android/ttcjpaysdk/thirdparty/data/CombineLimitInfo;", "combine_type", "double_check_resp", "Lcom/android/ttcjpaysdk/thirdparty/data/CJPayDoubleCheckVerifyInfo;", "exts", "Lcom/android/ttcjpaysdk/thirdparty/data/CJPayResultRespExts;", "face_verify_info", "Lcom/android/ttcjpaysdk/thirdparty/data/CJPayFaceVerifyInfo;", "fail_reason_asset_info", "Lcom/android/ttcjpaysdk/base/ui/data/AssetInfoBean;", "forget_pwd_info", "Lcom/android/ttcjpaysdk/thirdparty/data/ForgetPwdInfo;", "hint_info", "Lcom/android/ttcjpaysdk/thirdparty/data/CJPayInsufficientBalanceHintInfo;", "icon_tips", "Lcom/android/ttcjpaysdk/base/ui/data/IconTips;", "jump_url", "mobile", "msg", b.A0, "pay_type", "paytype_info", "Lcom/android/ttcjpaysdk/thirdparty/data/CJPayPayTypeInfo;", "process_info", "Lorg/json/JSONObject;", "pwd_error_pop", "pwd_left_lock_time", "", "pwd_left_lock_time_desc", "pwd_left_retry_time", "recommend_verify_info", "Lcom/android/ttcjpaysdk/thirdparty/data/RecommendVerifyInfo;", "three_domain_security_enroll_info", "Lcom/android/ttcjpaysdk/thirdparty/data/CJPayThreeDomainSecurityEnroll;", "trade_confirm_result_info", "Lcom/android/ttcjpaysdk/thirdparty/data/TradeConfirmResultInfo;", "trade_query_response", "unavailable_pay_type_sub_title", "used_asset_info", "getButtonInfo", "getCardSignInfo", "getCode", "getExts", "getForgetPwdInfo", "getLogId", "getMobile", "getMsg", "getProcessInfo", "getProcessPassThrough", "getPwdErrorPop", "getUnifyCashierResult", "getUsedAssetInfo", "isSuccess", "", "bdpay-front-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJUnifyPayCashierResultResponseBean implements CJPayObject, ICJUnifyPayTradeConfirmResp {
    public String bank_card_id;
    public String biz_fail_reason;
    public CJPayButtonInfo button_info;
    public CJPayCardSignInfo card_sign_info;
    public ArrayList<String> cashier_tag;
    public String change_pay_type_desc;
    public String code;
    public CombineLimitInfo combine_limit_button;
    public String combine_type;
    public CJPayDoubleCheckVerifyInfo double_check_resp;
    public CJPayResultRespExts exts;
    public CJPayFaceVerifyInfo face_verify_info;
    public AssetInfoBean fail_reason_asset_info;
    public ForgetPwdInfo forget_pwd_info;
    public CJPayInsufficientBalanceHintInfo hint_info;
    public IconTips icon_tips;
    public String jump_url;
    public String mobile;
    public String msg;
    public String out_trade_no;
    public String pay_type;
    public CJPayPayTypeInfo paytype_info;
    public JSONObject process_info;
    public JSONObject pwd_error_pop;
    public int pwd_left_lock_time;
    public String pwd_left_lock_time_desc;
    public int pwd_left_retry_time;
    public RecommendVerifyInfo recommend_verify_info;
    public CJPayThreeDomainSecurityEnroll three_domain_security_enroll_info;
    public TradeConfirmResultInfo trade_confirm_result_info;
    public JSONObject trade_query_response;
    public String unavailable_pay_type_sub_title;
    public AssetInfoBean used_asset_info;

    @Override // com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.data.response.ICJUnifyPayTradeConfirmResp
    public String getLogId() {
        return "";
    }

    @Override // com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.data.response.ICJUnifyPayTradeConfirmResp
    public String getProcessPassThrough() {
        return null;
    }

    @Override // com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.data.response.ICJUnifyPayTradeConfirmResp
    public CJUnifyPayCashierResultResponseBean getUnifyCashierResult() {
        return this;
    }

    public CJUnifyPayCashierResultResponseBean() {
        this.code = "";
        this.msg = "";
        this.out_trade_no = "";
        this.pwd_left_lock_time_desc = "";
        this.button_info = new CJPayButtonInfo();
        this.process_info = new JSONObject();
        this.paytype_info = new CJPayPayTypeInfo();
        this.jump_url = "";
        this.mobile = "";
        this.face_verify_info = new CJPayFaceVerifyInfo(null, null, null, null, null, null, null, false, null, null, null, null, false, null, null, null, null, null, null, null, null, null, 4194303, null);
        this.combine_limit_button = new CombineLimitInfo();
        this.forget_pwd_info = new ForgetPwdInfo();
        this.recommend_verify_info = new RecommendVerifyInfo();
        this.pay_type = "";
        this.combine_type = "";
        this.bank_card_id = "";
        this.exts = new CJPayResultRespExts();
        this.hint_info = new CJPayInsufficientBalanceHintInfo();
        this.change_pay_type_desc = "";
        this.unavailable_pay_type_sub_title = "";
        this.icon_tips = new IconTips();
        this.biz_fail_reason = "";
        this.three_domain_security_enroll_info = new CJPayThreeDomainSecurityEnroll();
        this.cashier_tag = new ArrayList();
        this.card_sign_info = new CJPayCardSignInfo();
        this.trade_confirm_result_info = new TradeConfirmResultInfo();
    }

    @Override // com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.data.response.ICJUnifyPayTradeConfirmResp
    public boolean isSuccess() {
        return Intrinsics.areEqual(this.code, "CD000000");
    }

    @Override // com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.data.response.ICJUnifyPayTradeConfirmResp
    public CJPayButtonInfo getButtonInfo() {
        return this.button_info;
    }

    @Override // com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.data.response.ICJUnifyPayTradeConfirmResp
    public CJPayCardSignInfo getCardSignInfo() {
        return this.card_sign_info;
    }

    @Override // com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.data.response.ICJUnifyPayTradeConfirmResp
    public String getCode() {
        return this.code;
    }

    @Override // com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.data.response.ICJUnifyPayTradeConfirmResp
    public CJPayResultRespExts getExts() {
        return this.exts;
    }

    @Override // com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.data.response.ICJUnifyPayTradeConfirmResp
    public ForgetPwdInfo getForgetPwdInfo() {
        return this.forget_pwd_info;
    }

    @Override // com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.data.response.ICJUnifyPayTradeConfirmResp
    public String getMobile() {
        return this.mobile;
    }

    @Override // com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.data.response.ICJUnifyPayTradeConfirmResp
    public String getMsg() {
        return this.msg;
    }

    @Override // com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.data.response.ICJUnifyPayTradeConfirmResp
    public JSONObject getProcessInfo() {
        return this.process_info;
    }

    @Override // com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.data.response.ICJUnifyPayTradeConfirmResp
    public JSONObject getPwdErrorPop() {
        return this.pwd_error_pop;
    }

    @Override // com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.data.response.ICJUnifyPayTradeConfirmResp
    public AssetInfoBean getUsedAssetInfo() {
        return this.used_asset_info;
    }
}
