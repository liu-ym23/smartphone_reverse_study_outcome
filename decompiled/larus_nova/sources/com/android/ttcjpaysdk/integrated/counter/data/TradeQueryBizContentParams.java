package com.android.ttcjpaysdk.integrated.counter.data;

import com.alipay.sdk.m.k.b;
import com.alipay.sdk.m.p.e;
import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.constants.CJUnifyPayConstants;
import com.android.ttcjpaysdk.verify.constants.DyVerifyReqConstants;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
public class TradeQueryBizContentParams {
    public JSONObject byte_pay_param;
    public String method;
    public RiskInfo risk_info;
    public String trade_no;

    public String toJsonString() {
        JSONObject r100 = new JSONObject();
        r100.put(e.f25671s, this.method);     // Catch: JSONException -> L14
        String r101 = this.trade_no;     // Catch: JSONException -> L14
        if (r101 == null) goto L6;
        r100.put(b.B0, r101);     // Catch: JSONException -> L14
    L6:
        RiskInfo r102 = this.risk_info;     // Catch: JSONException -> L14
        if (r102 == null) goto L9;
        r100.put(DyVerifyReqConstants.Key.RISK_INFO, r102.toJson());     // Catch: JSONException -> L14
    L9:
        JSONObject r103 = this.byte_pay_param;     // Catch: JSONException -> L14
        if (r103 == null) goto L12;
        r100.put("byte_pay_param", r103.toString());     // Catch: JSONException -> L14
    L12:
        return r100.toString();
    L14:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("TradeQueryBizContentParams#toJsonString", e);
        CJBasicCommonUtils.logCatch("CJCatch", "TradeQueryBizContentParams#toJsonString", e);
        e.printStackTrace();
        return null;
    }

    public TradeQueryBizContentParams() {
        this.method = CJUnifyPayConstants.Method.TRADE_QUERY_INTEGRATED;
    }
}
