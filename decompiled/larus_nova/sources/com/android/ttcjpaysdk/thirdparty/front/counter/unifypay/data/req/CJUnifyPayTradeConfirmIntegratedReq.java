package com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.data.req;

import com.alipay.sdk.m.k.b;
import com.android.ttcjpaysdk.base.json.CJPayJsonParser;
import com.android.ttcjpaysdk.base.json.CJPayObject;
import com.android.ttcjpaysdk.bindcard.base.constants.BindCardPayConfirmConstants;
import com.android.ttcjpaysdk.thirdparty.data.CJPayRiskInfo;
import com.android.ttcjpaysdk.verify.constants.DyVerifyReqConstants;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\f\u001a\u0004\u0018\u00010\u0006J\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u000eR\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/data/req/CJUnifyPayTradeConfirmIntegratedReq;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "()V", b.C0, "Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/data/req/CJUnifyPayTradeConfirmBizContentIntegratedParams;", "channel_support_scene", "", "process", DyVerifyReqConstants.Key.RISK_INFO, "Lcom/android/ttcjpaysdk/thirdparty/data/CJPayRiskInfo;", "sub_way", BindCardPayConfirmConstants.Key.TRACE_ID, "toJsonString", "toMap", "", "bdpay-front-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJUnifyPayTradeConfirmIntegratedReq implements CJPayObject {
    public CJUnifyPayTradeConfirmBizContentIntegratedParams biz_content;
    public String channel_support_scene;
    public String process;
    public CJPayRiskInfo risk_info;
    public String sub_way;
    public String trace_id;

    public final Map<String, String> toMap() {
        HashMap r100 = new HashMap();
        String r101 = this.channel_support_scene;
        boolean r102 = true;
        String r103 = null;
        if (r101 != null) goto L5;
    L13:
        String r104 = this.sub_way;
        if (r104 != null) goto L16;
    L24:
        CJUnifyPayTradeConfirmBizContentIntegratedParams r105 = this.biz_content;
        if (r105 == null) goto L28;
        String r106 = r105.toJsonString();
        if (r106 == null) goto L28;
    L29:
        r100.put(b.C0, r106);
        String r107 = this.trace_id;
        if (r107 != null) goto L32;
    L40:
        CJPayRiskInfo r108 = this.risk_info;
        if (r108 == null) goto L43;
        JSONObject r109 = r108.toJson();
    L44:
        r100.put(DyVerifyReqConstants.Key.RISK_INFO, String.valueOf(r109));
        String r110 = this.process;
        if (r110 != null) goto L47;
    L54:
        return r100;
    L47:
        if (r110.length() > 0) goto L50;
        r102 = false;
    L50:
        if (r102 == false) goto L52;
        r103 = r110;
    L52:
        if (r103 == null) goto L54;
        r100.put("process", r103);
        goto L54
    L43:
        r109 = null;
        goto L44
    L32:
        if (r107.length() <= 0) goto L34;
        boolean r111 = true;
    L35:
        if (r111 == true) goto L38;
        r107 = null;
    L38:
        if (r107 == null) goto L40;
        r100.put(BindCardPayConfirmConstants.Key.TRACE_ID, r107);
        goto L40
    L34:
        r111 = false;
    L28:
        r106 = "";
        goto L29
    L16:
        if (r104.length() <= 0) goto L18;
        boolean r112 = true;
    L19:
        if (r112 == true) goto L22;
        r104 = null;
    L22:
        if (r104 == null) goto L24;
        r100.put("sub_way", r104);
        goto L24
    L18:
        r112 = false;
        goto L19
    L5:
        if (r101.length() <= 0) goto L7;
        boolean r113 = true;
    L8:
        if (r113 == true) goto L11;
        r101 = null;
    L11:
        if (r101 == null) goto L13;
        r100.put("channel_support_scene", r101);
        goto L13
    L7:
        r113 = false;
        goto L8
    }

    public CJUnifyPayTradeConfirmIntegratedReq() {
        this.process = "";
    }

    public final String toJsonString() {
        JSONObject r100 = CJPayJsonParser.toJsonObject(this);
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.toString();
    }
}
