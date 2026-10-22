package com.android.ttcjpaysdk.fastpay.data.bean;

import com.alipay.sdk.m.k.b;
import com.alipay.sdk.m.p.e;
import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import com.android.ttcjpaysdk.fastpay.data.ProcessInfo;
import com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.constants.CJUnifyPayConstants;
import com.android.ttcjpaysdk.verify.constants.DyVerifyReqConstants;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
public class FastPayTradeQueryBizContentParams {
    public JSONObject byte_pay_param;
    public String method;
    public ProcessInfo process_info;
    public FastPayRiskInfo risk_info;
    public String trade_no;

    public String toJsonString() {
        JSONObject r100 = new JSONObject();
        r100.put(e.f25671s, this.method);     // Catch: JSONException -> L17
        ProcessInfo r101 = this.process_info;     // Catch: JSONException -> L17
        if (r101 == null) goto L6;
        r100.put("process_info", r101.toJson());     // Catch: JSONException -> L17
    L6:
        String r102 = this.trade_no;     // Catch: JSONException -> L17
        if (r102 == null) goto L9;
        r100.put(b.B0, r102);     // Catch: JSONException -> L17
    L9:
        FastPayRiskInfo r103 = this.risk_info;     // Catch: JSONException -> L17
        if (r103 == null) goto L12;
        r100.put(DyVerifyReqConstants.Key.RISK_INFO, r103.toJson());     // Catch: JSONException -> L17
    L12:
        JSONObject r104 = this.byte_pay_param;     // Catch: JSONException -> L17
        if (r104 == null) goto L15;
        r100.put("byte_pay_param", r104);     // Catch: JSONException -> L17
    L15:
        return r100.toString();
    L17:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("FastPayTradeQueryBizContentParams#toJsonString", e);
        CJBasicCommonUtils.logCatch("CJCatch", "FastPayTradeQueryBizContentParams#toJsonString", e);
        e.printStackTrace();
        return null;
    }

    public FastPayTradeQueryBizContentParams() {
        this.method = CJUnifyPayConstants.Method.TRADE_QUERY_INTEGRATED;
    }
}
