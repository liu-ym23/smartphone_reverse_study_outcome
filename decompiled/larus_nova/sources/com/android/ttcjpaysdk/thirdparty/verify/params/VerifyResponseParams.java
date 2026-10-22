package com.android.ttcjpaysdk.thirdparty.verify.params;

import com.android.ttcjpaysdk.thirdparty.data.CJPayTradeConfirmResponseBean;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
public interface VerifyResponseParams {
    CJPayTradeConfirmResponseBean parseTradeConfirmResponse(JSONObject r100);
}
