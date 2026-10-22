package com.android.ttcjpaysdk.thirdparty.supplementarysign.data;

import com.android.ttcjpaysdk.base.ui.data.CJPayButtonInfo;
import com.android.ttcjpaysdk.thirdparty.data.CJPayCard;

/* JADX INFO: loaded from: classes39.dex */
public class CJPaySSSignCardBean extends CJPaySSBaseBean {
    public String bank_card_id;
    public CJPayButtonInfo button_info;
    public CJPayCard card_info;
    public String pwd_token;
    public String sign_no;

    public String toString() {
        return "CJPaySmsSignResponse{, code='" + this.code + "', msg='" + this.msg + "', sign_no='" + this.sign_no + "', bank_card_id='" + this.bank_card_id + "', pwd_token='" + this.pwd_token + "'}";
    }

    public CJPaySSSignCardBean() {
        this.sign_no = "";
        this.bank_card_id = "";
        this.pwd_token = "";
        this.button_info = new CJPayButtonInfo();
        this.card_info = new CJPayCard();
    }
}
