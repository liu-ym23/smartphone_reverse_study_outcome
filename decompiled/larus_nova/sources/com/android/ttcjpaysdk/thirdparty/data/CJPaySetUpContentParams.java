package com.android.ttcjpaysdk.thirdparty.data;

import com.android.ttcjpaysdk.base.json.CJPayJsonParser;
import com.android.ttcjpaysdk.base.json.CJPayObject;
import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
public class CJPaySetUpContentParams implements CJPayObject {
    public String app_id;
    public String auth_order_no;
    public ThreeDomainSecurityCardInfo card_info;
    public String merchant_id;

    public static class ThreeDomainSecurityCardInfo implements CJPayObject {
        public String bank_card_id;

        public ThreeDomainSecurityCardInfo() {
        }
    }

    public CJPaySetUpContentParams() {
    }

    public String toJsonString() {
        JSONObject r100 = new JSONObject();
        r100.put("merchant_id", this.merchant_id);     // Catch: JSONException -> L7
        r100.put("app_id", this.app_id);     // Catch: JSONException -> L7
        r100.put("auth_order_no", this.auth_order_no);     // Catch: JSONException -> L7
        ThreeDomainSecurityCardInfo r101 = this.card_info;     // Catch: JSONException -> L7
        if (r101 == null) goto L10;
        r100.put("card_info", CJPayJsonParser.toJsonObject(r101));     // Catch: JSONException -> L7
    L10:
        return r100.toString();
    L7:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("CJPaySetUpContentParams#toJsonString", e);
        CJBasicCommonUtils.logCatch("CJCatch", "CJPaySetUpContentParams#toJsonString", e);
        goto L10
    }
}
