package com.android.ttcjpaysdk.superpay.bean;

import com.android.ttcjpaysdk.base.json.CJPayObject;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes39.dex */
public class CJPayVoucherInfo implements CJPayObject, Serializable {
    public String bin_voucher_msg;
    public String home_page_voucher_msg;
    public int is_not_show_promotion;
    public long order_sub_fixed_voucher_amount;
    public String voucher_msg;
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
        public String front_bank_code;
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
            this.voucher_type = "";
            this.label = "";
            this.batch_no = "";
            this.promotion_product_code = "";
            this.voucher_name = "";
            this.front_bank_code = "";
        }
    }

    public JSONArray getVoucherNoList() {
        JSONArray r100 = new JSONArray();
        Iterator<Voucher> r101 = this.vouchers.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        r100.put(r101.next().voucher_no);
        goto L4
    L6:
        return r100;
    }

    public CJPayVoucherInfo() {
        this.vouchers_label = "";
        this.vouchers = new ArrayList();
        this.voucher_msg = "";
        this.bin_voucher_msg = "";
        this.home_page_voucher_msg = "";
        this.is_not_show_promotion = 0;
        this.order_sub_fixed_voucher_amount = 0;
    }
}
