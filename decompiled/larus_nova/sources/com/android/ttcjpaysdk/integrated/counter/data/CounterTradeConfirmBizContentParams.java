package com.android.ttcjpaysdk.integrated.counter.data;

import com.android.ttcjpaysdk.base.json.CJPayJsonParser;
import com.android.ttcjpaysdk.base.json.CJPayObject;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
public class CounterTradeConfirmBizContentParams implements CJPayObject {
    public String jh_pass_through;
    public String ptcode;
    public String ptcode_info;
    public RiskInfo risk_info;
    public String support_evoke_channels;
    public String trade_no;

    public CounterTradeConfirmBizContentParams() {
    }

    public String toJsonString() {
        JSONObject r100 = CJPayJsonParser.toJsonObject(this);
        if (r100 != null) goto L5;
        return null;
    L5:
        return r100.toString();
    }
}
