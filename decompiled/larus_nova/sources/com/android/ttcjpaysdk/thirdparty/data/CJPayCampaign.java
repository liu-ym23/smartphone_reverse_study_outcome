package com.android.ttcjpaysdk.thirdparty.data;

import com.android.ttcjpaysdk.base.json.CJPayObject;
import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import com.bytedance.android.ec.core.event.a;
import java.math.BigDecimal;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
public class CJPayCampaign implements CJPayObject {
    public long after_reduce_order_amount;
    public String campaign_no;
    public int campaign_type;
    public String card_type;
    public String front_bank_code;
    public String label;
    public String new_card_label;
    public long reduce;

    public String getDiscountYuan() {
        return BigDecimal.valueOf(this.reduce).divide(new BigDecimal(100)).setScale(2, 4).toString();
    }

    public JSONObject toJson() {
        JSONObject r100 = new JSONObject();
        r100.put("campaign_no", this.campaign_no);     // Catch: JSONException -> L5
        r100.put("campaign_type", this.campaign_type);     // Catch: JSONException -> L5
        r100.put("front_bank_code", this.front_bank_code);     // Catch: JSONException -> L5
        r100.put(a.KEY_CARD_TYPE, this.card_type);     // Catch: JSONException -> L5
        r100.put("reduce", this.reduce);     // Catch: JSONException -> L5
        r100.put("after_reduce_order_amount", this.after_reduce_order_amount);     // Catch: JSONException -> L5
        r100.put("label", this.label);     // Catch: JSONException -> L5
        r100.put("new_card_label", this.new_card_label);     // Catch: JSONException -> L5
        return r100;
    L5:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("CJPayCampaign#toJson", e);
        CJBasicCommonUtils.logCatch("CJCatch", "CJPayCampaign#toJson", e);
        e.printStackTrace();
        return null;
    }

    public CJPayCampaign() {
        this.campaign_no = "";
        this.campaign_type = 0;
        this.front_bank_code = "";
        this.card_type = "";
        this.reduce = 0;
        this.after_reduce_order_amount = 0;
        this.label = "";
        this.new_card_label = "";
    }
}
