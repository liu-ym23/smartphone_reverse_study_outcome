package com.android.ttcjpaysdk.thirdparty.data;

import com.android.ttcjpaysdk.base.json.CJPayObject;
import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
public class CJPayCreditItem implements CJPayObject {
    public String credit_pay_installment;
    public String decision_id;

    public JSONObject toJson() {
        JSONObject r100 = new JSONObject();
        r100.put("credit_pay_installment", this.credit_pay_installment);     // Catch: JSONException -> L5
        r100.put("decision_id", this.decision_id);     // Catch: JSONException -> L5
        return r100;
    L5:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("CJPayCreditItem#toJson", e);
        CJBasicCommonUtils.logCatch("CJCatch", "CJPayCreditItem#toJson", e);
        e.printStackTrace();
        return null;
    }

    public CJPayCreditItem() {
        this.credit_pay_installment = "";
        this.decision_id = "";
    }
}
