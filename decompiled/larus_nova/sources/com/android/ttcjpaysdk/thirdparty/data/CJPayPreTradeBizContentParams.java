package com.android.ttcjpaysdk.thirdparty.data;

import com.alipay.sdk.m.p.e;
import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import com.android.ttcjpaysdk.verify.constants.DyVerifyReqConstants;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
public class CJPayPreTradeBizContentParams {
    public String method;
    public Map<String, String> params;
    public CJPayProcessInfo process_info;
    public CJPayRiskInfo risk_info;
    public String service;
    public String sign_no;

    public CJPayPreTradeBizContentParams() {
    }

    public String toJsonString() {
        JSONObject r100 = new JSONObject();
        String r101 = this.method;     // Catch: JSONException -> L28
        if (r101 == null) goto L6;
        r100.put(e.f25671s, r101);     // Catch: JSONException -> L28
    L6:
        String r102 = this.service;     // Catch: JSONException -> L28
        if (r102 == null) goto L9;
        r100.put("service", r102);     // Catch: JSONException -> L28
    L9:
        String r103 = this.sign_no;     // Catch: JSONException -> L28
        if (r103 == null) goto L12;
        r100.put("sign_no", r103);     // Catch: JSONException -> L28
    L12:
        CJPayProcessInfo r104 = this.process_info;     // Catch: JSONException -> L28
        if (r104 == null) goto L15;
        r100.put("process_info", r104.toJson());     // Catch: JSONException -> L28
    L15:
        CJPayRiskInfo r105 = this.risk_info;     // Catch: JSONException -> L28
        if (r105 == null) goto L18;
        r100.put(DyVerifyReqConstants.Key.RISK_INFO, r105.toJson());     // Catch: JSONException -> L28
    L18:
        Map<String, String> r106 = this.params;     // Catch: JSONException -> L28
        if (r106 == null) goto L25;
        JSONObject r107 = mapToJSONObj(r106);     // Catch: JSONException -> L28
        if (r107 == null) goto L24;
        r100.put("params", r107);     // Catch: JSONException -> L28
    L26:
        return r100.toString();
    L24:
        r100.put("params", "");     // Catch: JSONException -> L28
        goto L26
    L25:
        r100.put("params", "");     // Catch: JSONException -> L28
    L28:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("CJPayPreTradeBizContentParams#toJsonString", e);
        CJBasicCommonUtils.logCatch("CJCatch", "CJPayPreTradeBizContentParams#toJsonString", e);
        e.printStackTrace();
        return null;
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
        CJBasicCommonUtils.reportCatchException("CJPayPreTradeBizContentParams#mapToJSONObj", e);
        CJBasicCommonUtils.logCatch("CJCatch", "CJPayPreTradeBizContentParams#mapToJSONObj", e);
        e.printStackTrace();
        return null;
    }
}
