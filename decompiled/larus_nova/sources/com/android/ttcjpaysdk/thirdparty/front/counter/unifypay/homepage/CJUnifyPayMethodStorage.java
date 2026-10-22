package com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.homepage;

import com.alipay.sdk.m.p.e;
import com.android.ttcjpaysdk.thirdparty.data.unifypay.UnifyCashierRenderInfo;
import com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.method.data.CJUnifyPayMethodTuple;
import com.android.ttcjpaysdk.thirdparty.front.counter.utils.CJUnifyPayAssetInfoUtils;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u0012\u0010\u000e\u001a\u00020\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004H\u0016R\"\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004@RX\u0096\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\"\u0010\b\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004@RX\u0096\u000e¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/homepage/CJUnifyPayMethodStorage;", "Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/homepage/IUnifyPayMethodStorage;", "()V", "<set-?>", "Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/method/data/CJUnifyPayMethodTuple;", "currentMethod", "getCurrentMethod", "()Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/method/data/CJUnifyPayMethodTuple;", "defaultMethod", "getDefaultMethod", "initDefaultMethod", "", "renderInfo", "Lcom/android/ttcjpaysdk/thirdparty/data/unifypay/UnifyCashierRenderInfo;", "updateCurrentMethod", e.f25671s, "bdpay-front-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJUnifyPayMethodStorage implements IUnifyPayMethodStorage {
    private CJUnifyPayMethodTuple currentMethod;
    private CJUnifyPayMethodTuple defaultMethod;

    public CJUnifyPayMethodStorage() {
    }

    @Override // com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.homepage.IUnifyPayMethodStorage
    public CJUnifyPayMethodTuple getCurrentMethod() {
        return this.currentMethod;
    }

    @Override // com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.homepage.IUnifyPayMethodStorage
    public CJUnifyPayMethodTuple getDefaultMethod() {
        return this.defaultMethod;
    }

    @Override // com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.homepage.IUnifyPayMethodStorage
    public void initDefaultMethod(UnifyCashierRenderInfo r100) {
        if (getDefaultMethod() != null) goto L5;
        CJUnifyPayMethodTuple r101 = CJUnifyPayAssetInfoUtils.INSTANCE.buildDefaultSelectMethod(r100);
        this.defaultMethod = r101;
        if (getCurrentMethod() != null) goto L13;
        this.currentMethod = r101;
        return;
    L13:
        return;
    L5:
        if (getCurrentMethod() != null) goto L12;
        this.currentMethod = getDefaultMethod();
        return;
    }

    @Override // com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.homepage.IUnifyPayMethodStorage
    public void updateCurrentMethod(CJUnifyPayMethodTuple r100) {
        this.currentMethod = r100;
        if (getDefaultMethod() != null) goto L7;
        if (r100 == null) goto L8;
        this.defaultMethod = r100;
        return;
    L8:
        return;
    }
}
