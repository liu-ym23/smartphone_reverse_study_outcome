package com.android.ttcjpaysdk.integrated.counter.data.unifypay;

import com.android.ttcjpaysdk.thirdparty.data.unifypay.UnifyCashierRenderInfo;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0003H&J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0006H&J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0003H&J\b\u0010\b\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\u000bH&¨\u0006\f"}, d2 = {"Lcom/android/ttcjpaysdk/integrated/counter/data/unifypay/ICJUnifyPayTradeCreateResp;", "", "getCode", "", "getErrorMsg", "getFeMetrics", "Lorg/json/JSONObject;", "getProcess", "getUnifyCashierRenderInfo", "Lcom/android/ttcjpaysdk/thirdparty/data/unifypay/UnifyCashierRenderInfo;", "isSuccess", "", "bdpay-base_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface ICJUnifyPayTradeCreateResp {
    String getCode();

    String getErrorMsg();

    JSONObject getFeMetrics();

    String getProcess();

    UnifyCashierRenderInfo getUnifyCashierRenderInfo();

    boolean isSuccess();
}
