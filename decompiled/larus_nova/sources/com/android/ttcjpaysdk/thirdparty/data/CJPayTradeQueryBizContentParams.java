package com.android.ttcjpaysdk.thirdparty.data;

import com.alipay.sdk.m.k.b;
import com.alipay.sdk.m.p.e;
import com.android.ttcjpaysdk.base.json.CJPayJsonParser;
import com.android.ttcjpaysdk.base.json.CJPayObject;
import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import com.android.ttcjpaysdk.verify.constants.DyVerifyReqConstants;
import java.io.Serializable;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
public class CJPayTradeQueryBizContentParams {
    public JSONObject exts;
    public String method;
    public CJPayProcessInfo process_info;
    public CJPayRiskInfo risk_info;
    public String trade_no;
    public UserRetainInfo user_retain_info;
    public VerifyInfo verify_info;

    public static class UserRetainInfo implements CJPayObject, Serializable {
        public Boolean is_retained;
        public String position;
        public String retain_type;

        public String toJson() {
            JSONObject r100 = new JSONObject();
            Boolean r101 = this.is_retained;     // Catch: Exception -> L14
            if (r101 == null) goto L6;
            r100.put("is_retained", r101);     // Catch: Exception -> L14
        L6:
            String r102 = this.retain_type;     // Catch: Exception -> L14
            if (r102 == null) goto L9;
            r100.put("retain_type", r102);     // Catch: Exception -> L14
        L9:
            String r103 = this.position;     // Catch: Exception -> L14
            if (r103 == null) goto L13;
            r100.put("position", r103);     // Catch: Exception -> L14
        L13:
            return r100.toString();
        L14:
            e = move-exception;
            CJBasicCommonUtils.reportCatchException("CJPayTradeQueryBizContentParams#toJson", e);
            CJBasicCommonUtils.logCatch("CJCatch", "CJPayTradeQueryBizContentParams#toJson", e);
            return null;
        }

        public UserRetainInfo() {
            this.is_retained = Boolean.FALSE;
            this.retain_type = "";
            this.position = "";
        }
    }

    public static class VerifyInfo implements CJPayObject, Serializable {
        public int check_count;
        public String check_type_list;
        public String current_verify_type;
        public String verify_change_type;

        public VerifyInfo() {
            this.verify_change_type = "";
            this.current_verify_type = "";
            this.check_type_list = "";
            this.check_count = 0;
        }
    }

    public String toJsonString() {
        JSONObject r100 = new JSONObject();
        r100.put(e.f25671s, this.method);     // Catch: JSONException -> L29
        CJPayProcessInfo r101 = this.process_info;     // Catch: JSONException -> L29
        if (r101 == null) goto L6;
        r100.put("process_info", r101.toJson());     // Catch: JSONException -> L29
    L6:
        String r102 = this.trade_no;     // Catch: JSONException -> L29
        if (r102 == null) goto L9;
        r100.put(b.B0, r102);     // Catch: JSONException -> L29
    L9:
        CJPayRiskInfo r103 = this.risk_info;     // Catch: JSONException -> L29
        if (r103 == null) goto L12;
        r100.put(DyVerifyReqConstants.Key.RISK_INFO, r103.toJson());     // Catch: JSONException -> L29
    L12:
        JSONObject r104 = new JSONObject();     // Catch: JSONException -> L29
        UserRetainInfo r105 = this.user_retain_info;     // Catch: JSONException -> L29
        if (r105 == null) goto L15;
        r104.put("user_retain_info", r105.toJson());     // Catch: JSONException -> L29
    L15:
        VerifyInfo r106 = this.verify_info;     // Catch: JSONException -> L29
        if (r106 == null) goto L18;
        r104.put("verify_info", CJPayJsonParser.toJsonObject(r106));     // Catch: JSONException -> L29
    L18:
        JSONObject r107 = this.exts;     // Catch: JSONException -> L29
        if (r107 != null) goto L35;
    L27:
        r100.put("exts", r104);     // Catch: JSONException -> L29
        return r100.toString();
    L35:
        Iterator<String> r108 = r107.keys();     // Catch: Exception -> L32
    L22:
        if (r108.hasNext() == false) goto L27;
        String r109 = r108.next();     // Catch: Exception -> L32
        Object r110 = this.exts.opt(r109);     // Catch: Exception -> L32
        if (r110 == null) goto L22;
        r104.put(r109, r110);     // Catch: Exception -> L32
    L29:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("CJPayTradeQueryBizContentParams#toJsonString", e);
        CJBasicCommonUtils.logCatch("CJCatch", "CJPayTradeQueryBizContentParams#toJsonString", e);
        e.printStackTrace();
        return null;
    }

    public CJPayTradeQueryBizContentParams() {
        this.method = "cashdesk.sdk.pay.query";
    }
}
