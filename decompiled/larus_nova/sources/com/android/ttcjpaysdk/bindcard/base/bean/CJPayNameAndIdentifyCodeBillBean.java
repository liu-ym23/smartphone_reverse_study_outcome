package com.android.ttcjpaysdk.bindcard.base.bean;

import android.text.TextUtils;
import com.android.ttcjpaysdk.base.json.CJPayJsonParser;
import com.android.ttcjpaysdk.base.json.CJPayObject;
import java.io.Serializable;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
public class CJPayNameAndIdentifyCodeBillBean implements CJPayObject, Serializable {
    public CJPayBusiAuthorizeInfo busi_authorize_info;
    public String busi_authorize_info_str;
    public String code;
    public String member_biz_order_no;
    public String member_biz_url;
    public String msg;
    public CJPayKeepDialogBean retention_msg;
    public CJPaySignCardMapInfo sign_card_map;
    public String sign_order_no;
    public String status;

    public boolean isResponseOK() {
        if (TextUtils.equals("MP000000", this.code) == false) goto L5;
    L8:
        return true;
    L5:
        if (TextUtils.equals("CD000000", this.code) == true) goto L8;
        return false;
    }

    public CJPayCardAddBean toCardAddBean() {
        CJPayCardAddBean r100 = new CJPayCardAddBean();
        r100.busi_authorize_info = this.busi_authorize_info;
        if (TextUtils.isEmpty(this.busi_authorize_info_str) == true) goto L5;
        r100.busi_authorize_info_str = this.busi_authorize_info_str;
    L8:
        CJPayBindCardParamsBean r101 = r100.url_params;
        CJPaySignCardMapInfo r102 = this.sign_card_map;
        r101.is_authed = r102.is_authed;
        String r103 = r102.is_set_pwd;
        r101.is_set_pwd = r103;
        r101.sign_order_no = this.member_biz_order_no;
        r101.id_name_mask = r102.id_name_mask;
        String r104 = r102.mobile_mask;
        r101.mobile_mask = r104;
        r101.smch_id = r102.smch_id;
        r101.one_key_bank_info = r102.one_key_bank_info;
        r101.uid_mobile_mask = r102.uid_mobile_mask;
        r101.mobile_mask = r104;
        r101.skip_pwd = r102.skip_pwd;
        r101.id_type = r102.id_type;
        r100.goSetPwd = !"1".equals(r103);
        r100.url_params.allow_trans_card_type = this.sign_card_map.allow_trans_card_type;
        r100.retention_msg = this.retention_msg;
        return r100;
    L5:
        JSONObject r105 = CJPayJsonParser.toJsonObject(this.busi_authorize_info);
        if (r105 == null) goto L8;
        r100.busi_authorize_info_str = r105.toString();
        goto L8
    }

    public CJPayNameAndIdentifyCodeBillBean() {
        this.member_biz_order_no = "";
        this.sign_order_no = "";
        this.member_biz_url = "";
        this.code = "";
        this.msg = "";
        this.status = "";
        this.busi_authorize_info = new CJPayBusiAuthorizeInfo();
        this.busi_authorize_info_str = "";
        this.retention_msg = null;
        this.sign_card_map = new CJPaySignCardMapInfo();
    }
}
