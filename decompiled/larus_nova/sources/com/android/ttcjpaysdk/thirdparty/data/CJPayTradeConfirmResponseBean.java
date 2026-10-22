package com.android.ttcjpaysdk.thirdparty.data;

import com.android.ttcjpaysdk.base.json.CJPayObject;
import com.android.ttcjpaysdk.base.ui.data.AssetInfoBean;
import com.android.ttcjpaysdk.base.ui.data.CJPayButtonInfo;
import com.android.ttcjpaysdk.base.ui.data.IconTips;
import java.util.ArrayList;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
public class CJPayTradeConfirmResponseBean implements CJPayObject {
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
    public CJPayProcessInfo process_info;
    public PwdErrorAction pwd_error_action;
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

    public static class ThreeDSChallengeInfo implements CJPayObject {
        public String accessToken;
        public String stepUpUrl;

        public ThreeDSChallengeInfo() {
            this.accessToken = "";
            this.stepUpUrl = "";
        }
    }

    public CJPayTradeConfirmResponseBean() {
        this.code = "";
        this.msg = "";
        this.out_trade_no = "";
        this.pwd_left_retry_time = 0;
        this.pwd_left_lock_time = 0;
        this.pwd_left_lock_time_desc = "";
        this.button_info = new CJPayButtonInfo();
        this.pwd_error_pop = null;
        this.process_info = new CJPayProcessInfo();
        this.paytype_info = new CJPayPayTypeInfo();
        this.jump_url = "";
        this.mobile = "";
        this.face_verify_info = new CJPayFaceVerifyInfo();
        this.combine_limit_button = new CombineLimitInfo();
        this.forget_pwd_info = new ForgetPwdInfo();
        this.pwd_error_action = new PwdErrorAction();
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
        this.double_check_resp = new CJPayDoubleCheckVerifyInfo();
        this.trade_confirm_result_info = new TradeConfirmResultInfo();
    }
}
