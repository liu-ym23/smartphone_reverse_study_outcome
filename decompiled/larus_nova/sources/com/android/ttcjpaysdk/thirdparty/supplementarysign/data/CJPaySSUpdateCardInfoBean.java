package com.android.ttcjpaysdk.thirdparty.supplementarysign.data;

import com.android.ttcjpaysdk.base.encrypt.CJPaySecureRequestParams;
import java.io.Serializable;

/* JADX INFO: loaded from: classes39.dex */
public class CJPaySSUpdateCardInfoBean implements Serializable {
    public String bank_card_id;
    public String bank_mobile_no;
    public String bank_name;
    public String card_no;
    public boolean is_need_card_info;
    public String pay_route_id;
    public String pay_uid;
    public CJPaySecureRequestParams secure_request_params;
    public String sign_order_no;
    public String smch_id;

    public CJPaySSUpdateCardInfoBean() {
        this.card_no = "";
        this.bank_mobile_no = "";
        this.bank_name = "";
        this.is_need_card_info = false;
        this.sign_order_no = "";
        this.smch_id = "";
        this.pay_uid = "";
        this.bank_card_id = "";
        this.pay_route_id = "";
        this.secure_request_params = new CJPaySecureRequestParams();
    }
}
