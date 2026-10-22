package com.android.ttcjpaysdk.thirdparty.data.unifypay;

import com.android.ttcjpaysdk.base.json.CJPayObject;
import com.android.ttcjpaysdk.thirdparty.data.CJPayMerchantInfo;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/data/unifypay/CJUnifyPayCommonBizModel;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "()V", "feMetrics", "Lorg/json/JSONObject;", "getFeMetrics", "()Lorg/json/JSONObject;", "setFeMetrics", "(Lorg/json/JSONObject;)V", "jhMerchantInfo", "Lcom/android/ttcjpaysdk/thirdparty/data/CJPayMerchantInfo;", "getJhMerchantInfo", "()Lcom/android/ttcjpaysdk/thirdparty/data/CJPayMerchantInfo;", "setJhMerchantInfo", "(Lcom/android/ttcjpaysdk/thirdparty/data/CJPayMerchantInfo;)V", "bdpay-base_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJUnifyPayCommonBizModel implements CJPayObject {
    private JSONObject feMetrics;
    private CJPayMerchantInfo jhMerchantInfo;

    public CJUnifyPayCommonBizModel() {
    }

    public final JSONObject getFeMetrics() {
        return this.feMetrics;
    }

    public final CJPayMerchantInfo getJhMerchantInfo() {
        return this.jhMerchantInfo;
    }

    public final void setFeMetrics(JSONObject r100) {
        this.feMetrics = r100;
    }

    public final void setJhMerchantInfo(CJPayMerchantInfo r100) {
        this.jhMerchantInfo = r100;
    }
}
