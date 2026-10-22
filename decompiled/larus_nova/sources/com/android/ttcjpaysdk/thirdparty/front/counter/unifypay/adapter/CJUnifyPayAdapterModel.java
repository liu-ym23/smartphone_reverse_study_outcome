package com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.adapter;

import com.android.ttcjpaysdk.thirdparty.data.unifypay.CJUnifyPayCommonBizModel;
import com.android.ttcjpaysdk.thirdparty.data.unifypay.UnifyCashierRenderInfo;
import java.util.Map;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/adapter/CJUnifyPayAdapterModel;", "", "()V", "bizEventSpecialParams", "", "", "businessModel", "Lcom/android/ttcjpaysdk/thirdparty/data/unifypay/CJUnifyPayCommonBizModel;", "hostInfoJSON", "Lorg/json/JSONObject;", "initRenderData", "Lcom/android/ttcjpaysdk/thirdparty/data/unifypay/UnifyCashierRenderInfo;", "bdpay-front-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJUnifyPayAdapterModel {
    public Map<String, ? extends Object> bizEventSpecialParams;
    public CJUnifyPayCommonBizModel businessModel;
    public JSONObject hostInfoJSON;
    public UnifyCashierRenderInfo initRenderData;

    public CJUnifyPayAdapterModel() {
        this.businessModel = new CJUnifyPayCommonBizModel();
    }
}
