package com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.data.response;

import com.android.ttcjpaysdk.base.json.CJPayObject;
import com.android.ttcjpaysdk.integrated.counter.data.CounterTradeErrorBean;
import com.android.ttcjpaysdk.thirdparty.data.CJPayTradeInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\n\u0010\u000b\u001a\u0004\u0018\u00010\u0005H\u0016J\n\u0010\f\u001a\u0004\u0018\u00010\u0007H\u0016J\n\u0010\r\u001a\u0004\u0018\u00010\tH\u0016J\n\u0010\u000e\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010\u000f\u001a\u00020\u0005H\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016R\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/data/response/CJUnifyPayTradeQueryBean;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/data/response/ICJUnifyPayTradeQueryResp;", "()V", "code", "", "data", "Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/data/response/CJUnifyPayTradeQueryDataBean;", "error", "Lcom/android/ttcjpaysdk/integrated/counter/data/CounterTradeErrorBean;", "log_id", "getCode", "getData", "getError", "getLogId", "getTradeStatus", "isSuccess", "", "bdpay-front-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJUnifyPayTradeQueryBean implements CJPayObject, ICJUnifyPayTradeQueryResp {
    public String code;
    public CJUnifyPayTradeQueryDataBean data;
    public CounterTradeErrorBean error;
    public String log_id;

    public CJUnifyPayTradeQueryBean() {
    }

    @Override // com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.data.response.ICJUnifyPayTradeQueryResp
    public String getTradeStatus() {
        CJUnifyPayTradeQueryDataBean r100 = this.data;
        if (r100 == null) goto L7;
        CJPayTradeInfo r101 = r100.trade_info;
        if (r101 == null) goto L7;
        String r102 = r101.status;
    L8:
        if (r102 != null) goto L11;
        return "";
    L11:
        return r102;
    L7:
        r102 = null;
        goto L8
    }

    @Override // com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.data.response.ICJUnifyPayTradeQueryResp
    public boolean isSuccess() {
        return Intrinsics.areEqual("CA0000", this.code);
    }

    @Override // com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.data.response.ICJUnifyPayTradeQueryResp
    public String getCode() {
        return this.code;
    }

    @Override // com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.data.response.ICJUnifyPayTradeQueryResp
    public CJUnifyPayTradeQueryDataBean getData() {
        return this.data;
    }

    @Override // com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.data.response.ICJUnifyPayTradeQueryResp
    public CounterTradeErrorBean getError() {
        return this.error;
    }

    @Override // com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.data.response.ICJUnifyPayTradeQueryResp
    public String getLogId() {
        return this.log_id;
    }
}
