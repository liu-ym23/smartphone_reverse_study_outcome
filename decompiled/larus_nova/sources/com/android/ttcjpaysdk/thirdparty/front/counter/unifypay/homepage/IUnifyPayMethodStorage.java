package com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.homepage;

import com.alipay.sdk.m.p.e;
import com.android.ttcjpaysdk.thirdparty.data.unifypay.UnifyCashierRenderInfo;
import com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.method.data.CJUnifyPayMethodTuple;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH&J\u0012\u0010\f\u001a\u00020\t2\b\u0010\r\u001a\u0004\u0018\u00010\u0003H&R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005¨\u0006\u000e"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/homepage/IUnifyPayMethodStorage;", "", "currentMethod", "Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/method/data/CJUnifyPayMethodTuple;", "getCurrentMethod", "()Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/method/data/CJUnifyPayMethodTuple;", "defaultMethod", "getDefaultMethod", "initDefaultMethod", "", "renderInfo", "Lcom/android/ttcjpaysdk/thirdparty/data/unifypay/UnifyCashierRenderInfo;", "updateCurrentMethod", e.f25671s, "bdpay-front-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface IUnifyPayMethodStorage {
    CJUnifyPayMethodTuple getCurrentMethod();

    CJUnifyPayMethodTuple getDefaultMethod();

    void initDefaultMethod(UnifyCashierRenderInfo r100);

    void updateCurrentMethod(CJUnifyPayMethodTuple r100);
}
