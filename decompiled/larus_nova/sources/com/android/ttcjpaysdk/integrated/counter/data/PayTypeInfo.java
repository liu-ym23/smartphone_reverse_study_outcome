package com.android.ttcjpaysdk.integrated.counter.data;

import com.android.ttcjpaysdk.base.json.CJPayObject;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes28.dex */
public class PayTypeInfo implements CJPayObject {
    public Balance balance;
    public String default_pay_channel;
    public String home_page_picture_url;
    public NoPwdPayParams nopwd_pay_params;
    public ArrayList<String> pay_channels;
    public QuickPay quick_pay;
    public SubPayTypeSumInfo sub_pay_type_sum_info;

    public static class NoPwdPayParams implements CJPayObject {
        public String nopwd_combine_confirm;
        public String nopwd_pre_show;

        public boolean isNoPwdCombineConfirm() {
            return "1".equals(this.nopwd_combine_confirm);
        }

        public boolean isNoPwdPreShow() {
            return "1".equals(this.nopwd_pre_show);
        }

        public NoPwdPayParams() {
            this.nopwd_combine_confirm = "";
            this.nopwd_pre_show = "";
        }
    }

    public PayTypeInfo() {
        this.quick_pay = new QuickPay();
        this.balance = new Balance();
        this.default_pay_channel = "";
        this.pay_channels = new ArrayList();
        this.sub_pay_type_sum_info = new SubPayTypeSumInfo();
        this.home_page_picture_url = "";
        this.nopwd_pay_params = new NoPwdPayParams();
    }
}
