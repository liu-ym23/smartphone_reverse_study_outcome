package com.android.ttcjpaysdk.fastpay.data;

import com.android.ttcjpaysdk.base.json.CJPayJsonParser;
import com.android.ttcjpaysdk.base.json.CJPayObject;
import com.android.ttcjpaysdk.fastpay.data.bean.FastPayRiskInfo;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
public class VerifyFastPayBizContentParams implements CJPayObject {
    public String merchant_id;
    public String method;
    public ProcessInfo process_info;
    public FastPayRiskInfo risk_info;

    public VerifyFastPayBizContentParams() {
        this.method = "cashdesk.sdk.pay.verify_and_one_key_pay";
    }

    public String toJsonString() {
        JSONObject r100 = CJPayJsonParser.toJsonObject(this);
        if (r100 != null) goto L5;
        return null;
    L5:
        return r100.toString();
    }
}
