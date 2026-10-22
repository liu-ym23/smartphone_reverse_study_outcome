package com.android.ttcjpaysdk.bindcard.base.bean;

import android.text.TextUtils;
import com.android.ttcjpaysdk.base.json.CJPayJsonParser;
import com.android.ttcjpaysdk.base.json.CJPayObject;
import com.android.ttcjpaysdk.base.ktextension.KtSafeMethodExtensionKt;
import com.android.ttcjpaysdk.base.ui.data.AssetInfoBean;
import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import com.android.ttcjpaysdk.thirdparty.data.CJPayDoubleCheckVerifyInfo;
import com.android.ttcjpaysdk.thirdparty.data.CJPayFaceVerifyInfo;
import com.android.ttcjpaysdk.thirdparty.data.CJPayInsufficientBalanceHintInfo;
import com.android.ttcjpaysdk.thirdparty.data.CJPayProcessInfo;
import com.android.ttcjpaysdk.thirdparty.data.CJPayThreeDomainSecurityEnroll;
import com.android.ttcjpaysdk.thirdparty.data.CombineLimitInfo;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
public class CJPayNewCardBean extends CJPayBindCardBaseBean {
    public String bank_card_id;
    public String biz_fail_reason;
    public com.android.ttcjpaysdk.base.ui.data.CJPayButtonInfo button_info;
    public ArrayList<String> cashier_tag;
    public CombineLimitInfo combine_limit_button;
    public String combine_type;
    public CJPayDoubleCheckVerifyInfo double_check_resp;
    public CJPayExts exts;
    public CJPayFaceVerifyInfo face_verify_info;
    public AssetInfoBean fail_reason_asset_info;
    public CJPayInsufficientBalanceHintInfo hint_info;
    public String mobile;
    public String pay_type;
    public CJPayProcessInfo process_info;
    public CJPayThreeDomainSecurityEnroll three_domain_security_enroll_info;
    public String unavailable_pay_type_sub_title;
    public AssetInfoBean used_asset_info;

    public static class CJPayExts implements CJPayObject {
        public String activity_id;
        public String bill_page_display_text;
        public String ext_param;
        public String pay_after_use_open_status;

        public CJPayExts() {
            this.ext_param = "";
            this.pay_after_use_open_status = "";
            this.activity_id = "";
            this.bill_page_display_text = "";
        }
    }

    public JSONObject getPayParams() {
        JSONObject r100 = new JSONObject();
        r100.put("code", this.code);     // Catch: JSONException -> L5
        r100.put("msg", this.msg);     // Catch: JSONException -> L5
        r100.put("pay_type", this.pay_type);     // Catch: JSONException -> L5
        r100.put("combine_type", this.combine_type);     // Catch: JSONException -> L5
        r100.put("bank_card_id", this.bank_card_id);     // Catch: JSONException -> L5
        r100.put("unavailable_pay_type_sub_title", this.unavailable_pay_type_sub_title);     // Catch: JSONException -> L5
        r100.put("combine_limit_button", CJPayJsonParser.toJsonObject(this.combine_limit_button));     // Catch: JSONException -> L5
        r100.put("hint_info", CJPayJsonParser.toJsonObject(this.hint_info));     // Catch: JSONException -> L5
        r100.put("cashier_tag", KtSafeMethodExtensionKt.toJsonArray(this.cashier_tag));     // Catch: JSONException -> L5
        r100.put("exts", CJPayJsonParser.toJsonObject(this.exts));     // Catch: JSONException -> L5
        r100.put("biz_fail_reason", this.biz_fail_reason);     // Catch: JSONException -> L5
        r100.put("process_info", CJPayJsonParser.toJsonObject(this.process_info));     // Catch: JSONException -> L5
        r100.put("used_asset_info", CJPayJsonParser.toJsonObject(this.used_asset_info));     // Catch: JSONException -> L5
        r100.put("fail_reason_asset_info", CJPayJsonParser.toJsonObject(this.fail_reason_asset_info));     // Catch: JSONException -> L5
    L7:
        return r100;
    L5:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("CJPayNewCardBean#getPayParams", e);
        CJBasicCommonUtils.logCatch("CJCatch", "CJPayNewCardBean#getPayParams", e);
        goto L7
    }

    public boolean isCombinePay() {
        return TextUtils.equals("combinepay", this.pay_type);
    }

    public CJPayNewCardBean() {
        this.mobile = "";
        this.face_verify_info = new CJPayFaceVerifyInfo();
        this.button_info = new com.android.ttcjpaysdk.base.ui.data.CJPayButtonInfo();
        this.bank_card_id = "";
        this.pay_type = "";
        this.combine_type = "";
        this.combine_limit_button = new CombineLimitInfo();
        this.hint_info = new CJPayInsufficientBalanceHintInfo();
        this.cashier_tag = new ArrayList();
        this.exts = new CJPayExts();
        this.process_info = new CJPayProcessInfo();
        this.used_asset_info = new AssetInfoBean();
        this.fail_reason_asset_info = new AssetInfoBean();
        this.three_domain_security_enroll_info = new CJPayThreeDomainSecurityEnroll();
        this.double_check_resp = new CJPayDoubleCheckVerifyInfo();
        this.unavailable_pay_type_sub_title = "";
        this.biz_fail_reason = "";
    }
}
