package com.android.ttcjpaysdk.thirdparty.data;

import com.alipay.sdk.m.k.b;
import com.alipay.sdk.m.p.e;
import com.android.ttcjpaysdk.base.json.CJPayObject;
import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import com.android.ttcjpaysdk.verify.constants.DyVerifyReqConstants;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
public class CJPayGetVerifyInfoParams implements CJPayObject {
    public JSONObject exts;
    public String merchant_id;
    public String method;
    public JSONObject process_info;
    public CJPayRiskInfo risk_info;
    public String trade_no;

    public String toJsonString() {
        JSONObject r100 = new JSONObject();
        r100.put(e.f25671s, this.method);     // Catch: JSONException -> L20
        String r101 = this.trade_no;     // Catch: JSONException -> L20
        if (r101 == null) goto L6;
        r100.put(b.B0, r101);     // Catch: JSONException -> L20
    L6:
        String r102 = this.merchant_id;     // Catch: JSONException -> L20
        if (r102 == null) goto L9;
        r100.put("merchant_id", r102);     // Catch: JSONException -> L20
    L9:
        JSONObject r103 = this.process_info;     // Catch: JSONException -> L20
        if (r103 == null) goto L12;
        r100.put("process_info", r103);     // Catch: JSONException -> L20
    L12:
        CJPayRiskInfo r104 = this.risk_info;     // Catch: JSONException -> L20
        if (r104 == null) goto L15;
        r100.put(DyVerifyReqConstants.Key.RISK_INFO, r104.toJson());     // Catch: JSONException -> L20
    L15:
        JSONObject r105 = this.exts;     // Catch: JSONException -> L20
        if (r105 == null) goto L18;
        r100.put("exts", r105);     // Catch: JSONException -> L20
    L18:
        return r100.toString();
    L20:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("CJPayGetVerifyInfoParams#toJsonString", e);
        CJBasicCommonUtils.logCatch("CJCatch", "CJPayGetVerifyInfoParams#toJsonString", e);
        e.printStackTrace();
        return null;
    }

    public CJPayGetVerifyInfoParams() {
        this.method = "bytepay.cashdesk.get_verify_info";
    }
}
