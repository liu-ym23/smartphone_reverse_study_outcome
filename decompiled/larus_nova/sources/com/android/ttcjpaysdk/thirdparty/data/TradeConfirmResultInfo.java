package com.android.ttcjpaysdk.thirdparty.data;

import com.android.ttcjpaysdk.base.json.CJPayObject;

/* JADX INFO: loaded from: classes39.dex */
public class TradeConfirmResultInfo implements CJPayObject {
    public PayResultShowInfo pay_result_show_info;

    public static class PayResultShowInfo implements CJPayObject {
        public String min_time;
        public String sub_text;
        public String text;
        public String type;
        public String url;

        public PayResultShowInfo() {
            this.text = "";
            this.sub_text = "";
            this.type = "";
            this.url = "";
            this.min_time = "";
        }
    }

    public TradeConfirmResultInfo() {
        this.pay_result_show_info = new PayResultShowInfo();
    }
}
