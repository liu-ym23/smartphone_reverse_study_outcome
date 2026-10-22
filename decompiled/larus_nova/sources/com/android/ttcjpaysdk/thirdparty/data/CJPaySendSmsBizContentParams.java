package com.android.ttcjpaysdk.thirdparty.data;

import com.alipay.sdk.m.p.e;
import com.android.ttcjpaysdk.base.encrypt.CJEncryptScene;
import com.android.ttcjpaysdk.base.encrypt.CJPaySecureRequestParams;
import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import com.android.ttcjpaysdk.verify.constants.DyVerifyReqConstants;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
public class CJPaySendSmsBizContentParams {
    public String merchant_id;
    public String method;
    public JSONObject process_info;
    public String pwd_level;
    public CJPayRiskInfo risk_info;
    public CJPaySecureRequestParams secure_request_params;
    public String service;

    public String toJsonString() {
        JSONObject r100 = new JSONObject();
        r100.put(e.f25671s, this.method);     // Catch: JSONException -> L17
        r100.put("pwd_level", this.pwd_level);     // Catch: JSONException -> L17
        r100.put("service", this.service);     // Catch: JSONException -> L17
        String r101 = this.merchant_id;     // Catch: JSONException -> L17
        if (r101 == null) goto L6;
        r100.put("merchant_id", r101);     // Catch: JSONException -> L17
    L6:
        JSONObject r102 = this.process_info;     // Catch: JSONException -> L17
        if (r102 == null) goto L9;
        r100.put("process_info", r102);     // Catch: JSONException -> L17
    L9:
        CJPayRiskInfo r103 = this.risk_info;     // Catch: JSONException -> L17
        if (r103 == null) goto L12;
        r100.put(DyVerifyReqConstants.Key.RISK_INFO, r103.toJson());     // Catch: JSONException -> L17
    L12:
        CJPaySecureRequestParams r104 = this.secure_request_params;     // Catch: JSONException -> L17
        if (r104 == null) goto L15;
        r100.put(DyVerifyReqConstants.Key.SECURE_REQUEST_PARAMS, r104.toJson(CJEncryptScene.UNKNOWN));     // Catch: JSONException -> L17
    L15:
        return r100.toString();
    L17:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("CJPaySendSmsBizContentParams#toJsonString", e);
        CJBasicCommonUtils.logCatch("CJCatch", "CJPaySendSmsBizContentParams#toJsonString", e);
        e.printStackTrace();
        return null;
    }

    public CJPaySendSmsBizContentParams() {
        this.method = "cashdesk.wap.user.sendsms";
        this.pwd_level = "2";
        this.service = "pay";
    }
}
