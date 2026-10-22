package com.android.ttcjpaysdk.integrated.counter.data;

import com.alipay.sdk.m.k.b;
import com.android.ttcjpaysdk.base.json.CJPayObject;
import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
public class TradeInfo implements CJPayObject, Serializable {
    public long amount;
    public String amount_can_change;
    public long create_time;
    public String currency;
    public long expire_time;
    public String ext_uid;
    public String extension;
    public String merchant_id;
    public String out_trade_no;
    public long pay_amount;
    public long pay_time;
    public String pay_trade_no;
    public String pay_type;
    public String ptcode;
    public int real_amount;
    public String return_url;
    public String stat_info;
    public String status;
    public long trade_amount;
    public String trade_desc;
    public String trade_name;
    public String trade_no;
    public String trade_status;
    public String trade_status_desc_msg;
    public long trade_time;
    public String trade_type;
    public String uid;

    public String toJsonString() {
        JSONObject r100 = new JSONObject();
        r100.put("create_time", this.create_time);     // Catch: JSONException -> L5
        r100.put("expire_time", this.expire_time);     // Catch: JSONException -> L5
        r100.put("pay_time", this.pay_time);     // Catch: JSONException -> L5
        r100.put("merchant_id", this.merchant_id);     // Catch: JSONException -> L5
        r100.put(b.A0, this.out_trade_no);     // Catch: JSONException -> L5
        r100.put("amount", this.amount);     // Catch: JSONException -> L5
        r100.put("trade_desc", this.trade_desc);     // Catch: JSONException -> L5
        r100.put("trade_name", this.trade_name);     // Catch: JSONException -> L5
        r100.put(b.B0, this.trade_no);     // Catch: JSONException -> L5
        r100.put("status", this.status);     // Catch: JSONException -> L5
        r100.put("trade_time", this.trade_time);     // Catch: JSONException -> L5
        r100.put("pay_type", this.pay_type);     // Catch: JSONException -> L5
        r100.put("ptcode", this.ptcode);     // Catch: JSONException -> L5
        r100.put("real_amount", this.real_amount);     // Catch: JSONException -> L5
        r100.put("uid", this.uid);     // Catch: JSONException -> L5
        return r100.toString();
    L5:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("TradeInfo#toJsonString", e);
        CJBasicCommonUtils.logCatch("CJCatch", "TradeInfo#toJsonString", e);
        e.printStackTrace();
        return "";
    }

    public TradeInfo() {
        this.create_time = 0;
        this.expire_time = 0;
        this.out_trade_no = "";
        this.return_url = "";
        this.trade_amount = 0;
        this.trade_desc = "";
        this.trade_name = "";
        this.trade_no = "";
        this.trade_status = "";
        this.trade_time = 0;
        this.trade_type = "";
        this.pay_amount = 0;
        this.amount_can_change = "";
        this.trade_status_desc_msg = "";
        this.amount = 0;
        this.real_amount = 0;
        this.ext_uid = "";
        this.merchant_id = "";
        this.pay_time = 0;
        this.pay_trade_no = "";
        this.pay_type = "";
        this.ptcode = "";
        this.status = "";
        this.uid = "";
        this.stat_info = "";
        this.extension = "";
    }
}
