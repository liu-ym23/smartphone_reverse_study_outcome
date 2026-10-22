package com.android.ttcjpaysdk.fastpay.data.bean;

import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import com.android.ttcjpaysdk.verify.constants.DyVerifyReqConstants;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
public class FastPayBizContent {
    public String cd_raw_url;
    public Map<String, String> params;
    public String ptcode;
    public FastPayRiskInfo risk_info;
    public String service;

    public FastPayBizContent() {
    }

    public String toJsonString() {
        JSONObject r100 = new JSONObject();
        Map<String, String> r101 = this.params;     // Catch: JSONException -> L25
        if (r101 == null) goto L10;
        JSONObject r102 = mapToJSONObj(r101);     // Catch: JSONException -> L25
        if (r102 == null) goto L9;
        r100.put("params", r102);     // Catch: JSONException -> L25
    L11:
        String r103 = this.service;     // Catch: JSONException -> L25
        if (r103 == null) goto L14;
        r100.put("service", r103);     // Catch: JSONException -> L25
    L14:
        String r104 = this.cd_raw_url;     // Catch: JSONException -> L25
        if (r104 == null) goto L17;
        r100.put("cd_raw_url", r104);     // Catch: JSONException -> L25
    L17:
        FastPayRiskInfo r105 = this.risk_info;     // Catch: JSONException -> L25
        if (r105 == null) goto L20;
        r100.put(DyVerifyReqConstants.Key.RISK_INFO, r105.toJson());     // Catch: JSONException -> L25
    L20:
        String r106 = this.ptcode;     // Catch: JSONException -> L25
        if (r106 == null) goto L23;
        r100.put("ptcode", r106);     // Catch: JSONException -> L25
    L23:
        return r100.toString();
    L9:
        r100.put("params", "");     // Catch: JSONException -> L25
        goto L11
    L10:
        r100.put("params", "");     // Catch: JSONException -> L25
    L25:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("FastPayBizContent#toJsonString", e);
        CJBasicCommonUtils.logCatch("CJCatch", "FastPayBizContent#toJsonString", e);
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
        CJBasicCommonUtils.reportCatchException("FastPayBizContent#mapToJSONObj", e);
        CJBasicCommonUtils.logCatch("CJCatch", "FastPayBizContent#mapToJSONObj", e);
        e.printStackTrace();
        return null;
    }
}
