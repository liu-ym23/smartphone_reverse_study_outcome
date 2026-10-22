package com.android.ttcjpaysdk.integrated.counter.data;

import android.text.TextUtils;
import com.android.ttcjpaysdk.base.json.CJPayObject;
import com.android.ttcjpaysdk.integrated.counter.data.unifypay.ICJUnifyPayTradeCreateResp;
import com.android.ttcjpaysdk.thirdparty.data.unifypay.UnifyCashierRenderInfo;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
public class CounterResponseBean implements CJPayObject, ICJUnifyPayTradeCreateResp {
    public String code;
    public IntegratedCounterResponseData data;
    public CounterTradeErrorBean error;
    public String process;
    public String rawData;
    public String scheme;
    public String source;
    public String typecnt;

    @Override // com.android.ttcjpaysdk.integrated.counter.data.unifypay.ICJUnifyPayTradeCreateResp
    public String getErrorMsg() {
        return this.error.msg;
    }

    @Override // com.android.ttcjpaysdk.integrated.counter.data.unifypay.ICJUnifyPayTradeCreateResp
    public JSONObject getFeMetrics() {
        return this.data.fe_metrics;
    }

    public int getPayItemsShowNum() {
        return this.data.show_num;
    }

    @Override // com.android.ttcjpaysdk.integrated.counter.data.unifypay.ICJUnifyPayTradeCreateResp
    public UnifyCashierRenderInfo getUnifyCashierRenderInfo() {
        return this.data.unify_cashier_render_info;
    }

    public boolean isResponseOk() {
        if (TextUtils.isEmpty(this.code) == false) goto L5;
    L7:
        return false;
    L5:
        if ("CA0000".equals(this.code) == false) goto L7;
        return true;
    }

    public CounterResponseBean() {
        this.code = "";
        this.error = new CounterTradeErrorBean();
        this.typecnt = "";
        this.process = "";
        this.data = new IntegratedCounterResponseData();
        this.source = "";
        this.scheme = "";
        this.rawData = "";
    }

    @Override // com.android.ttcjpaysdk.integrated.counter.data.unifypay.ICJUnifyPayTradeCreateResp
    public boolean isSuccess() {
        return isResponseOk();
    }

    @Override // com.android.ttcjpaysdk.integrated.counter.data.unifypay.ICJUnifyPayTradeCreateResp
    public String getCode() {
        return this.code;
    }

    @Override // com.android.ttcjpaysdk.integrated.counter.data.unifypay.ICJUnifyPayTradeCreateResp
    public String getProcess() {
        return this.process;
    }
}
