package com.android.ttcjpaysdk.bindcard.base.bean;

import android.content.Context;
import com.android.ttcjpaysdk.base.encrypt.CJPaySecureRequestParams;
import com.android.ttcjpaysdk.thirdparty.data.CJPayIdType;
import com.larus.nova.R;
import java.io.Serializable;

/* JADX INFO: loaded from: classes28.dex */
public class CJPayRealNameBean implements Serializable {
    public String activity_info;
    public String bankCardId;
    public String bank_mobile_no;
    public String bank_name;
    public String card_no;
    public String card_type;
    public CJPayBindCardCommonBean commonBean;
    public String country;
    public String encryptedMobileNumber;
    public String end_page_url;
    public boolean goSetPwd;
    public String id_no;
    public CJPayIdType id_type;
    public boolean isAuth;
    public boolean isUnionPay;
    public boolean is_need_card_info;
    public boolean is_skip_set_pwd;
    public String payUid;
    public CJPaySecureRequestParams secure_request_params;
    public String user_name;

    public CJPayRealNameBean() {
        this.user_name = "";
        this.id_no = "";
        this.card_no = "";
        this.bank_mobile_no = "";
        this.bank_name = "";
        this.card_type = "";
        this.bankCardId = "";
        this.country = "";
        this.is_need_card_info = false;
        this.commonBean = new CJPayBindCardCommonBean();
        this.payUid = "";
        this.goSetPwd = false;
        this.secure_request_params = new CJPaySecureRequestParams();
        this.id_type = CJPayIdType.MAINLAND;
        this.encryptedMobileNumber = "";
        this.activity_info = "";
        this.isUnionPay = false;
        this.is_skip_set_pwd = false;
        this.end_page_url = "";
    }

    public String getCardTypeStr(Context r100) {
        if (this.card_type.equalsIgnoreCase("DEBIT") == false) goto L7;
        return r100.getString(R.string.cj_pay_debit_card);
    L7:
        return r100.getString(R.string.cj_pay_credit_card);
    }

    public boolean isContentEqual(CJPayRealNameBean r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if (this.user_name.equals(r100.user_name) == true) goto L8;
        return false;
    L8:
        if (this.id_no.equals(r100.id_no) == true) goto L10;
        return false;
    L10:
        if (this.card_no.equals(r100.card_no) == true) goto L12;
        return false;
    L12:
        if (this.bank_mobile_no.equals(r100.bank_mobile_no) == true) goto L14;
        return false;
    L14:
        if (this.bank_name.equals(r100.bank_name) == true) goto L16;
        return false;
    L16:
        if (this.card_type.equals(r100.card_type) == true) goto L18;
        return false;
    L18:
        if (this.country.equals(r100.country) == true) goto L20;
        return false;
    L20:
        if (this.is_need_card_info == r100.is_need_card_info) goto L22;
        return false;
    L22:
        if (this.payUid.equals(r100.payUid) == true) goto L24;
        return false;
    L24:
        if (this.goSetPwd == r100.goSetPwd) goto L26;
        return false;
    L26:
        if (this.isAuth != r100.isAuth) goto L39;
        return true;
    L39:
        return false;
    }
}
