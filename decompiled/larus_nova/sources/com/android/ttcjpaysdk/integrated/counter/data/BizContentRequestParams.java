package com.android.ttcjpaysdk.integrated.counter.data;

import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import com.android.ttcjpaysdk.verify.constants.DyVerifyReqConstants;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
public class BizContentRequestParams {
    public String cd_raw_url;
    public JSONObject params;
    public RiskInfo risk_info;
    public String service;

    public BizContentRequestParams() {
    }

    public String toJsonString() {
        JSONObject r100 = new JSONObject();
        JSONObject r101 = this.params;     // Catch: JSONException -> L19
        if (r101 == null) goto L7;
        r100.put("params", r101);     // Catch: JSONException -> L19
    L8:
        String r102 = this.service;     // Catch: JSONException -> L19
        if (r102 == null) goto L11;
        r100.put("service", r102);     // Catch: JSONException -> L19
    L11:
        String r103 = this.cd_raw_url;     // Catch: JSONException -> L19
        if (r103 == null) goto L14;
        r100.put("cd_raw_url", r103);     // Catch: JSONException -> L19
    L14:
        RiskInfo r104 = this.risk_info;     // Catch: JSONException -> L19
        if (r104 == null) goto L17;
        r100.put(DyVerifyReqConstants.Key.RISK_INFO, r104.toJson());     // Catch: JSONException -> L19
    L17:
        return r100.toString();
    L7:
        r100.put("params", "");     // Catch: JSONException -> L19
    L19:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("BizContentRequestParams#toJsonString", e);
        CJBasicCommonUtils.logCatch("CJCatch", "BizContentRequestParams#toJsonString", e);
        e.printStackTrace();
        return null;
    }
}
