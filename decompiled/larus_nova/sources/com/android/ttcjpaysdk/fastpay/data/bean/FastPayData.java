package com.android.ttcjpaysdk.fastpay.data.bean;

import com.android.ttcjpaysdk.base.json.CJPayObject;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
public class FastPayData implements CJPayObject {
    public FastPayTradeInfo.DirectPayShowConf direct_pay_show_conf;
    public JSONObject fe_metrics;
    public FastPayParams pay_params;
    public FastPayTradeInfo trade_info;

    public FastPayData() {
        this.direct_pay_show_conf = new FastPayTradeInfo.DirectPayShowConf();
        this.trade_info = new FastPayTradeInfo();
        this.pay_params = new FastPayParams();
        this.fe_metrics = new JSONObject();
    }
}
