package com.android.ttcjpaysdk.base.ui.data;

import com.android.ttcjpaysdk.base.json.CJPayObject;
import java.io.Serializable;

/* JADX INFO: loaded from: classes28.dex */
public class TradeAreaVoucher implements CJPayObject, Serializable {
    public String order_amount_text;
    public String pay_back_voucher;
    public String sub_pay_type_combine_voucher;
    public String sub_pay_type_voucher;

    public TradeAreaVoucher() {
        this.pay_back_voucher = "";
        this.sub_pay_type_voucher = "";
        this.sub_pay_type_combine_voucher = "";
        this.order_amount_text = "";
    }
}
