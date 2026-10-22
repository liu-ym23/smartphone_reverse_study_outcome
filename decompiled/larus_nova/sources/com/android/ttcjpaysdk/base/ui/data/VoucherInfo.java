package com.android.ttcjpaysdk.base.ui.data;

import com.android.ttcjpaysdk.base.json.CJPayObject;
import java.io.Serializable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes28.dex */
public class VoucherInfo implements CJPayObject, Serializable {
    public long order_sub_fixed_voucher_amount;
    public ArrayList<Voucher> vouchers;
    public int vouchers_amount;
    public int vouchers_channel_num;
    public String vouchers_label;
    public int vouchers_max_amount;
    public int vouchers_plat_num;
    public int vouchers_random_num;
    public int vouchers_used_amount;

    public static class Voucher implements CJPayObject, Serializable {
        public String batch_no;
        public String label;
        public String promotion_product_code;
        public int random_max_reduce_amount;
        public int reached_amount;
        public int reduce_amount;
        public int used_amount;
        public String voucher_name;
        public String voucher_no;
        public String voucher_type;

        public Voucher() {
            this.voucher_no = "";
            this.batch_no = "";
            this.promotion_product_code = "";
            this.voucher_type = "";
            this.voucher_name = "";
            this.random_max_reduce_amount = 0;
            this.reached_amount = 0;
            this.used_amount = 0;
            this.label = "";
        }
    }

    public VoucherInfo() {
        this.vouchers_label = "";
        this.order_sub_fixed_voucher_amount = 0;
        this.vouchers = new ArrayList();
        this.vouchers_amount = 0;
        this.vouchers_max_amount = 0;
        this.vouchers_used_amount = 0;
        this.vouchers_channel_num = 0;
        this.vouchers_plat_num = 0;
        this.vouchers_random_num = 0;
    }
}
