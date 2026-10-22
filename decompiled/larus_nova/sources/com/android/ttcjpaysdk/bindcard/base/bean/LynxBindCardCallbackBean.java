package com.android.ttcjpaysdk.bindcard.base.bean;

import com.android.ttcjpaysdk.base.json.CJPayObject;
import com.android.ttcjpaysdk.thirdparty.data.CJPayTradeConfirmBizContentParams;
import java.io.Serializable;

/* JADX INFO: loaded from: classes28.dex */
public class LynxBindCardCallbackBean implements CJPayObject, Serializable {
    public String bank_card_id;
    public String bind_card_ext;
    public String cancel_reason;
    public CJPayFrontBindCardInfo card_info;
    public int code;
    public String cvv;
    public CJPayTradeConfirmBizContentParams.ForeignCardPayExt foreign_card_pay_ext;
    public int is_cancel_pay;
    public int is_cancel_set_password;
    public String member_biz_order_no;
    public String process;
    public String sign_no;
    public String token;

    public boolean isBindCardAndPay() {
        return "bind_card_pay".equals(this.process);
    }

    public boolean isCancelPay() {
        if (1 == this.is_cancel_pay) goto L7;
        return false;
    L7:
        return true;
    }

    public boolean isSuccess() {
        if (1 == this.code) goto L7;
        return false;
    L7:
        return true;
    }

    public LynxBindCardCallbackBean() {
        this.sign_no = "";
        this.bank_card_id = "";
        this.token = "";
        this.cvv = "";
        this.is_cancel_pay = 0;
        this.cancel_reason = "";
        this.member_biz_order_no = "";
        this.card_info = new CJPayFrontBindCardInfo();
        this.bind_card_ext = "";
    }
}
