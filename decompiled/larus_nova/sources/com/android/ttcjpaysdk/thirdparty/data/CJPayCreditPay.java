package com.android.ttcjpaysdk.thirdparty.data;

import com.android.ttcjpaysdk.base.json.CJPayObject;
import com.android.ttcjpaysdk.base.ui.data.CJPayVoucherInfo;
import java.io.Serializable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes39.dex */
public class CJPayCreditPay implements CJPayObject, Serializable {
    public ArrayList<CJPayCreditPayMethods> credit_pay_methods;
    public ArrayList<String> voucher_msg_list;

    public static class CJPayCreditPayMethods implements CJPayObject, Serializable {
        public int fee;
        public String icon_url;
        public String installment;
        public String msg;
        public int pay_amount_per_installment;
        public String status;
        public int total_amount_per_installment;
        public String voucher_fee_msg;
        public CJPayVoucherInfo voucher_info;
        public String voucher_platform_msg;

        public CJPayCreditPayMethods() {
            this.status = "";
            this.msg = "";
            this.installment = "";
            this.voucher_fee_msg = "";
            this.voucher_platform_msg = "";
            this.icon_url = "";
            this.voucher_info = new CJPayVoucherInfo();
        }
    }

    public CJPayCreditPay() {
        this.voucher_msg_list = new ArrayList();
        this.credit_pay_methods = new ArrayList();
    }
}
