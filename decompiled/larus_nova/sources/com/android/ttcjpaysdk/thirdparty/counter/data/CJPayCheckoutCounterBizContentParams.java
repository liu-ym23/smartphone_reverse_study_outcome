package com.android.ttcjpaysdk.thirdparty.counter.data;

import com.alipay.sdk.m.p.e;
import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import com.android.ttcjpaysdk.thirdparty.data.CJPayRiskInfo;
import com.android.ttcjpaysdk.verify.constants.DyVerifyReqConstants;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
public class CJPayCheckoutCounterBizContentParams {
    public String cd_raw_url;
    public String method;
    public Map<String, String> params;
    public CJPayRiskInfo risk_info;
    public String service;

    public String toJsonString() {
        JSONObject r100 = new JSONObject();
        r100.put(e.f25671s, this.method);     // Catch: JSONException -> L22
        String r101 = this.service;     // Catch: JSONException -> L22
        if (r101 == null) goto L6;
        r100.put("service", r101);     // Catch: JSONException -> L22
    L6:
        String r102 = this.cd_raw_url;     // Catch: JSONException -> L22
        if (r102 == null) goto L9;
        r100.put("cd_raw_url", r102);     // Catch: JSONException -> L22
    L9:
        CJPayRiskInfo r103 = this.risk_info;     // Catch: JSONException -> L22
        if (r103 == null) goto L12;
        r100.put(DyVerifyReqConstants.Key.RISK_INFO, r103.toJson());     // Catch: JSONException -> L22
    L12:
        Map<String, String> r104 = this.params;     // Catch: JSONException -> L22
        if (r104 == null) goto L19;
        JSONObject r105 = mapToJSONObj(r104);     // Catch: JSONException -> L22
        if (r105 == null) goto L18;
        r100.put("params", r105);     // Catch: JSONException -> L22
    L20:
        return r100.toString();
    L18:
        r100.put("params", "");     // Catch: JSONException -> L22
        goto L20
    L19:
        r100.put("params", "");     // Catch: JSONException -> L22
    L22:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("CJPayCheckoutCounterBizContentParams#toJsonString", e);
        CJBasicCommonUtils.logCatch("CJCatch", "CJPayCheckoutCounterBizContentParams#toJsonString", e);
        e.printStackTrace();
        return null;
    }

    public CJPayCheckoutCounterBizContentParams() {
        this.method = "cashdesk.sdk.pay.create";
    }

    private JSONObject mapToJSONObj(Map<String, String> r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        JSONObject r101 = new JSONObject();
        Iterator<Map.Entry<String, String>> r102 = r100.entrySet().iterator();     // Catch: JSONException -> L12
    L8:
        if (r102.hasNext() == false) goto L11;
        Map.Entry<String, String> r103 = r102.next();     // Catch: JSONException -> L12
        r101.put(r103.getKey(), r103.getValue());     // Catch: JSONException -> L12
        goto L8
    L11:
        return r101;
    L12:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("CJPayCheckoutCounterBizContentParams#mapToJSONObj", e);
        CJBasicCommonUtils.logCatch("CJCatch", "CJPayCheckoutCounterBizContentParams#mapToJSONObj", e);
        e.printStackTrace();
        return null;
    }
}
