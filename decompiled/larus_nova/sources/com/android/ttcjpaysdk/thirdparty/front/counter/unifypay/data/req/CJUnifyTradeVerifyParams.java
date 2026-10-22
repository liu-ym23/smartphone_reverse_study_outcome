package com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.data.req;

import com.alipay.sdk.m.k.b;
import com.alipay.sdk.m.p.e;
import com.android.ttcjpaysdk.base.json.CJPayJsonParser;
import com.android.ttcjpaysdk.base.json.CJPayObject;
import com.android.ttcjpaysdk.thirdparty.data.CJPayRiskInfo;
import com.android.ttcjpaysdk.verify.constants.DyVerifyReqConstants;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004R\u0012\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000e\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/data/req/CJUnifyTradeVerifyParams;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "()V", "app_id", "", "dev_info", "Lorg/json/JSONObject;", "exts", "fund_bill_index", "merchant_id", e.f25671s, "process_info", DyVerifyReqConstants.Key.RISK_INFO, "Lcom/android/ttcjpaysdk/thirdparty/data/CJPayRiskInfo;", b.B0, "toJsonString", "bdpay-front-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJUnifyTradeVerifyParams implements CJPayObject {
    public String app_id;
    public JSONObject dev_info;
    public JSONObject exts;
    public String fund_bill_index;
    public String merchant_id;
    public String method;
    public JSONObject process_info;
    public CJPayRiskInfo risk_info;
    public String trade_no;

    public CJUnifyTradeVerifyParams() {
        this.trade_no = "";
        this.merchant_id = "";
        this.app_id = "";
        this.method = "";
        this.fund_bill_index = "";
        this.risk_info = new CJPayRiskInfo();
    }

    public final String toJsonString() {
        JSONObject r100 = CJPayJsonParser.toJsonObject(this);
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.toString();
    }
}
