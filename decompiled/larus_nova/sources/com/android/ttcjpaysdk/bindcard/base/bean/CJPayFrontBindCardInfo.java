package com.android.ttcjpaysdk.bindcard.base.bean;

import android.content.Context;
import com.android.ttcjpaysdk.base.json.CJPayObject;
import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.preverify.vm.UnifyPreVerifySmsVM;
import com.bytedance.android.ec.core.event.a;
import com.larus.nova.R;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
public class CJPayFrontBindCardInfo implements CJPayObject, Serializable {
    public String bank_card_id;
    public String bank_code;
    public String bank_name;
    public String card_no_mask;
    public String card_type;
    public String icon_url;
    public String mobile_mask;
    public String name_mask;
    public String perday_limit;
    public String perpay_limit;
    public String status;

    public JSONObject toJSONObject() {
        JSONObject r100 = new JSONObject();
        r100.put("bank_card_id", this.bank_card_id);     // Catch: JSONException -> L5
        r100.put("bank_code", this.bank_code);     // Catch: JSONException -> L5
        r100.put("bank_name", this.bank_name);     // Catch: JSONException -> L5
        r100.put("icon_url", this.icon_url);     // Catch: JSONException -> L5
        r100.put(a.KEY_CARD_TYPE, this.card_type);     // Catch: JSONException -> L5
        r100.put("card_no_mask", this.card_no_mask);     // Catch: JSONException -> L5
        r100.put("status", this.status);     // Catch: JSONException -> L5
        r100.put(UnifyPreVerifySmsVM.KEY_MOBILE_MASK, this.mobile_mask);     // Catch: JSONException -> L5
        r100.put("name_mask", this.name_mask);     // Catch: JSONException -> L5
        r100.put("perday_limit", this.perday_limit);     // Catch: JSONException -> L5
        r100.put("perpay_limit", this.perpay_limit);     // Catch: JSONException -> L5
    L7:
        return r100;
    L5:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("CJPayFrontBindCardInfo#toJSONObject", e);
        CJBasicCommonUtils.logCatch("CJCatch", "CJPayFrontBindCardInfo#toJSONObject", e);
        goto L7
    }

    public CJPayFrontBindCardInfo() {
        this.bank_card_id = "";
        this.bank_code = "";
        this.bank_name = "";
        this.icon_url = "";
        this.card_type = "";
        this.card_no_mask = "";
        this.status = "";
        this.mobile_mask = "";
        this.name_mask = "";
        this.perday_limit = "";
        this.perpay_limit = "";
    }

    public String getCardTypeStr(Context r100) {
        if (this.card_type.equalsIgnoreCase("DEBIT") == false) goto L7;
        return r100.getString(R.string.cj_pay_debit_card);
    L7:
        return r100.getString(R.string.cj_pay_credit_card);
    }
}
