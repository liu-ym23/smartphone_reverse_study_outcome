package com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.data.req;

import com.alipay.sdk.m.k.b;
import com.android.ttcjpaysdk.base.json.CJPayJsonParser;
import com.android.ttcjpaysdk.base.json.CJPayObject;
import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import com.android.ttcjpaysdk.bindcard.base.constants.BindCardPayConfirmConstants;
import com.android.ttcjpaysdk.thirdparty.data.CJPayRiskInfo;
import com.android.ttcjpaysdk.verify.constants.DyVerifyReqConstants;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010$\u001a\u00020\u0004R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0006\"\u0004\b\u001d\u0010\bR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0006\"\u0004\b \u0010\bR\u001c\u0010!\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0006\"\u0004\b#\u0010\b¨\u0006%"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/data/req/CJUnifyPayTradeConfirmBizContentIntegratedParams;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "()V", "jh_pass_through", "", "getJh_pass_through", "()Ljava/lang/String;", "setJh_pass_through", "(Ljava/lang/String;)V", "process_pass_through", "getProcess_pass_through", "setProcess_pass_through", "ptcode", "getPtcode", "setPtcode", "ptcode_info", "getPtcode_info", "setPtcode_info", DyVerifyReqConstants.Key.RISK_INFO, "Lcom/android/ttcjpaysdk/thirdparty/data/CJPayRiskInfo;", "getRisk_info", "()Lcom/android/ttcjpaysdk/thirdparty/data/CJPayRiskInfo;", "setRisk_info", "(Lcom/android/ttcjpaysdk/thirdparty/data/CJPayRiskInfo;)V", "support_evoke_channels", "getSupport_evoke_channels", "setSupport_evoke_channels", BindCardPayConfirmConstants.Key.TRACE_ID, "getTrace_id", "setTrace_id", b.B0, "getTrade_no", "setTrade_no", "unify_cashier_param", "getUnify_cashier_param", "setUnify_cashier_param", "toJsonString", "bdpay-front-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJUnifyPayTradeConfirmBizContentIntegratedParams implements CJPayObject {
    private String jh_pass_through;
    private String process_pass_through;
    private String ptcode;
    private String ptcode_info;
    private CJPayRiskInfo risk_info;
    private String support_evoke_channels;
    private String trace_id;
    private String trade_no;
    private String unify_cashier_param;

    public CJUnifyPayTradeConfirmBizContentIntegratedParams() {
        this.process_pass_through = "";
    }

    public final String toJsonString() {
        return CJPayJsonParser.toJsonObject(this).toString();
    L4:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("CJUnifyPayTradeConfirmBizContentIntegratedParams#toJsonString", e);
        CJBasicCommonUtils.logCatch("CJCatch", "CJUnifyPayTradeConfirmBizContentIntegratedParams#toJsonString", e);
        return "";
    }

    public final String getJh_pass_through() {
        return this.jh_pass_through;
    }

    public final String getProcess_pass_through() {
        return this.process_pass_through;
    }

    public final String getPtcode() {
        return this.ptcode;
    }

    public final String getPtcode_info() {
        return this.ptcode_info;
    }

    public final CJPayRiskInfo getRisk_info() {
        return this.risk_info;
    }

    public final String getSupport_evoke_channels() {
        return this.support_evoke_channels;
    }

    public final String getTrace_id() {
        return this.trace_id;
    }

    public final String getTrade_no() {
        return this.trade_no;
    }

    public final String getUnify_cashier_param() {
        return this.unify_cashier_param;
    }

    public final void setJh_pass_through(String r100) {
        this.jh_pass_through = r100;
    }

    public final void setProcess_pass_through(String r100) {
        this.process_pass_through = r100;
    }

    public final void setPtcode(String r100) {
        this.ptcode = r100;
    }

    public final void setPtcode_info(String r100) {
        this.ptcode_info = r100;
    }

    public final void setRisk_info(CJPayRiskInfo r100) {
        this.risk_info = r100;
    }

    public final void setSupport_evoke_channels(String r100) {
        this.support_evoke_channels = r100;
    }

    public final void setTrace_id(String r100) {
        this.trace_id = r100;
    }

    public final void setTrade_no(String r100) {
        this.trade_no = r100;
    }

    public final void setUnify_cashier_param(String r100) {
        this.unify_cashier_param = r100;
    }
}
