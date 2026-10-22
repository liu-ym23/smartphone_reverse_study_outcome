package com.android.ttcjpaysdk.bindcard.base.bean;

import android.text.TextUtils;
import com.android.ttcjpaysdk.base.json.CJPayObject;
import java.io.Serializable;

/* JADX INFO: loaded from: classes28.dex */
public class CJPayBindCardParamsBean implements CJPayObject, Serializable {
    public String ab_version;
    public String allow_trans_card_type;
    public String app_id;
    public CJPayOneKeyCopyWritingInfo card_copywriting_info;
    public String id_code_mask;
    public String id_name_mask;
    public String id_type;
    public String is_authed;
    public String is_set_pwd;
    public String jump_one_key_sign;
    public String merchant_id;
    public String mobile_mask;
    public CJPayBankInfoBean one_key_bank_info;
    public String order_amount;
    public String pay_uid;
    public String sign;
    public String sign_order_no;
    public String skip_pwd;
    public String smch_id;
    public String uid_mobile_mask;

    public boolean isAuth() {
        return TextUtils.equals("1", this.is_authed);
    }

    public boolean isSetPwd() {
        return TextUtils.equals("1", this.is_set_pwd);
    }

    public CJPayBindCardParamsBean() {
        this.allow_trans_card_type = "1";
        this.sign_order_no = "";
        this.pay_uid = "";
        this.smch_id = "";
        this.is_set_pwd = "";
        this.is_authed = "";
        this.id_name_mask = "";
        this.mobile_mask = "";
        this.id_type = "";
        this.id_code_mask = "";
        this.app_id = "";
        this.merchant_id = "";
        this.sign = "";
        this.uid_mobile_mask = "";
        this.skip_pwd = "";
        this.jump_one_key_sign = "";
        this.card_copywriting_info = new CJPayOneKeyCopyWritingInfo();
        this.one_key_bank_info = new CJPayBankInfoBean();
        this.ab_version = "";
        this.order_amount = "";
    }
}
