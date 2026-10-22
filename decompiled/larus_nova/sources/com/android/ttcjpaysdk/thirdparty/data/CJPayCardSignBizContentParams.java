package com.android.ttcjpaysdk.thirdparty.data;

import com.alipay.sdk.m.p.e;
import com.android.ttcjpaysdk.base.json.CJPayObject;
import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import com.android.ttcjpaysdk.verify.constants.DyVerifyReqConstants;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
public class CJPayCardSignBizContentParams implements CJPayObject {
    public String bank_card_id;
    public String fund_bill_index;
    public String method;
    public JSONObject process_info;
    public CJPayRiskInfo risk_info;

    public String toJsonString() {
        JSONObject r100 = new JSONObject();
        r100.put(e.f25671s, this.method);     // Catch: JSONException -> L17
        JSONObject r101 = this.process_info;     // Catch: JSONException -> L17
        if (r101 == null) goto L6;
        r100.put("process_info", r101);     // Catch: JSONException -> L17
    L6:
        CJPayRiskInfo r102 = this.risk_info;     // Catch: JSONException -> L17
        if (r102 == null) goto L9;
        r100.put(DyVerifyReqConstants.Key.RISK_INFO, r102.toJson());     // Catch: JSONException -> L17
    L9:
        String r103 = this.bank_card_id;     // Catch: JSONException -> L17
        if (r103 == null) goto L12;
        r100.put("bank_card_id", r103);     // Catch: JSONException -> L17
    L12:
        String r104 = this.fund_bill_index;     // Catch: JSONException -> L17
        if (r104 == null) goto L15;
        r100.put("fund_bill_index", r104);     // Catch: JSONException -> L17
    L15:
        return r100.toString();
    L17:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("CJPayCardSignBizContentParams#toJsonString", e);
        CJBasicCommonUtils.logCatch("CJCatch", "CJPayCardSignBizContentParams#toJsonString", e);
        e.printStackTrace();
        return null;
    }

    public CJPayCardSignBizContentParams() {
        this.method = "cashdesk.sdk.user.cardsign";
    }
}
