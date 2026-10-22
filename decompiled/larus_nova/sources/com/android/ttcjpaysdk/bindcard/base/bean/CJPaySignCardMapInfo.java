package com.android.ttcjpaysdk.bindcard.base.bean;

import com.android.ttcjpaysdk.base.json.CJPayObject;
import java.io.Serializable;

/* JADX INFO: loaded from: classes28.dex */
public class CJPaySignCardMapInfo implements CJPayObject, Serializable {
    public String allow_trans_card_type;
    public String app_id;
    public String button_description;
    public String id_name_mask;
    public String id_type;
    public String is_authed;
    public String is_set_pwd;
    public String jump_one_key_sign;
    public String member_biz_order_no;
    public String merchant_id;
    public String mobile_mask;
    public CJPayBankInfoBean one_key_bank_info;
    public String protocol_description;
    public String skip_pwd;
    public String smch_id;
    public String uid_mobile_mask;

    public CJPaySignCardMapInfo() {
        this.merchant_id = "";
        this.app_id = "";
        this.allow_trans_card_type = "";
        this.id_name_mask = "";
        this.is_authed = "";
        this.is_set_pwd = "";
        this.mobile_mask = "";
        this.smch_id = "";
        this.uid_mobile_mask = "";
        this.member_biz_order_no = "";
        this.skip_pwd = "";
        this.id_type = "";
        this.protocol_description = "";
        this.button_description = "";
        this.jump_one_key_sign = "";
        this.one_key_bank_info = new CJPayBankInfoBean();
    }
}
