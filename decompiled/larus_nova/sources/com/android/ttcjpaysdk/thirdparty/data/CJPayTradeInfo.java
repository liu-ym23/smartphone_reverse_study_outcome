package com.android.ttcjpaysdk.thirdparty.data;

import android.text.TextUtils;
import com.alipay.sdk.m.k.b;
import com.android.ttcjpaysdk.base.json.CJPayObject;
import com.android.ttcjpaysdk.base.ui.data.FundBillItem;
import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import com.android.ttcjpaysdk.bdpay.counter.outer.bean.CJDyPayResult;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
public class CJPayTradeInfo implements CJPayObject, Serializable {
    public String amount_can_change;
    public String balance_amount;
    public String bank_amount;
    public String bank_code_mask;
    public String bank_name;
    public String card_type;
    public ArrayList<CJPayCombinePayInfo> combine_pay_fund_list;
    public long create_time;
    public String credit_pay_installment_desc;
    public String discount_amount;
    public String discount_desc;
    public long expire_time;
    public String extension;
    public HashMap<String, String> extension_pb;
    public ArrayList<FundBillItem> fund_bill_list;
    public String icon_url;
    public boolean is_pay_new_card;
    public String is_trade_create_again;
    public String out_trade_no;
    public long pay_amount;
    public String pay_type;
    public String return_url;
    public String secondary_trade_name;
    public String sell_product_code;
    public String status;
    public long trade_amount;
    public String trade_desc;
    public String trade_name;
    public String trade_no;
    public String trade_status;
    public String trade_status_desc_msg;
    public long trade_time;
    public String trade_type;

    public static class CJPayCombinePayInfo implements CJPayObject {
        public int fund_amount;
        public String fund_amount_desc;
        public String fund_type;
        public String fund_type_desc;

        public CJPayCombinePayInfo() {
            this.fund_type_desc = "";
            this.fund_amount_desc = "";
            this.fund_type = "";
        }
    }

    public void afterProtoDecode() {
        HashMap<String, String> r100 = this.extension_pb;
        if (r100 != null) goto L5;
    L7:
        this.extension_pb = null;
        return;
    L5:
        if (r100.isEmpty() == true) goto L7;
        this.extension = new JSONObject(this.extension_pb).toString();
        goto L7
    }

    public boolean isTradeAgain() {
        return TextUtils.equals("1", this.is_trade_create_again);
    }

    public String toJsonString() {
        JSONObject r100 = new JSONObject();
        r100.put("create_time", this.create_time);     // Catch: JSONException -> L5
        r100.put("expire_time", this.expire_time);     // Catch: JSONException -> L5
        r100.put(b.A0, this.out_trade_no);     // Catch: JSONException -> L5
        r100.put(CJDyPayResult.EXT_K_RETURN_URL, this.return_url);     // Catch: JSONException -> L5
        r100.put("trade_amount", this.trade_amount);     // Catch: JSONException -> L5
        r100.put("trade_desc", this.trade_desc);     // Catch: JSONException -> L5
        r100.put("trade_name", this.trade_name);     // Catch: JSONException -> L5
        r100.put(b.B0, this.trade_no);     // Catch: JSONException -> L5
        r100.put("trade_status", this.trade_status);     // Catch: JSONException -> L5
        r100.put("trade_time", this.trade_time);     // Catch: JSONException -> L5
        r100.put("trade_type", this.trade_type);     // Catch: JSONException -> L5
        r100.put("pay_amount", this.pay_amount);     // Catch: JSONException -> L5
        r100.put("amount_can_change", this.amount_can_change);     // Catch: JSONException -> L5
        r100.put("trade_status_desc_msg", this.trade_status_desc_msg);     // Catch: JSONException -> L5
        r100.put("status", this.status);     // Catch: JSONException -> L5
        r100.put("pay_type", this.pay_type);     // Catch: JSONException -> L5
        return r100.toString();
    L5:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("CJPayTradeInfo#toJsonString", e);
        CJBasicCommonUtils.logCatch("CJCatch", "CJPayTradeInfo#toJsonString", e);
        e.printStackTrace();
        return "";
    }

    public CJPayTradeInfo() {
        this.create_time = 0;
        this.expire_time = 0;
        this.out_trade_no = "";
        this.return_url = "";
        this.trade_amount = 0;
        this.trade_desc = "";
        this.trade_name = "";
        this.secondary_trade_name = "";
        this.trade_no = "";
        this.trade_status = "";
        this.status = "";
        this.trade_time = 0;
        this.trade_type = "";
        this.pay_amount = 0;
        this.amount_can_change = "";
        this.trade_status_desc_msg = "";
        this.is_pay_new_card = false;
        this.pay_type = "";
        this.balance_amount = "";
        this.bank_amount = "";
        this.discount_amount = "";
        this.combine_pay_fund_list = new ArrayList();
        this.fund_bill_list = new ArrayList();
        this.bank_name = "";
        this.card_type = "";
        this.credit_pay_installment_desc = "";
        this.is_trade_create_again = "0";
        this.discount_desc = "";
        this.bank_code_mask = "";
        this.icon_url = "";
        this.sell_product_code = "";
        this.extension = "";
        this.extension_pb = null;
    }

    public void setDataForRestricted(String r100) {
        if (r100 == null) goto L10;
        JSONObject r101 = new JSONObject(r100);     // Catch: JSONException -> L5
        this.trade_no = r101.optString(b.B0);     // Catch: JSONException -> L5
        this.trade_amount = r101.optLong("trade_amount");     // Catch: JSONException -> L5
        return;
    L5:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("CJPayTradeInfo#setDataForRestricted", e);
        CJBasicCommonUtils.logCatch("CJCatch", "CJPayTradeInfo#setDataForRestricted", e);
        e.printStackTrace();
        return;
    }
}
