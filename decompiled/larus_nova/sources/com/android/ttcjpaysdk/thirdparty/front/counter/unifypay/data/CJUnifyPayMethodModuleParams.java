package com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.data;

import com.android.ttcjpaysdk.thirdparty.data.unifypay.UnifyCashierRenderInfo;
import com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.method.data.CJUnifyMethodListScene;
import com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.method.data.CJUnifyPayMethodTuple;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B%\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\r\u001a\u0004\u0018\u00010\u0003R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/data/CJUnifyPayMethodModuleParams;", "", "unifyCashierRenderInfo", "Lcom/android/ttcjpaysdk/thirdparty/data/unifypay/UnifyCashierRenderInfo;", "payMethodTuple", "Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/method/data/CJUnifyPayMethodTuple;", "scene", "Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/method/data/CJUnifyMethodListScene;", "(Lcom/android/ttcjpaysdk/thirdparty/data/unifypay/UnifyCashierRenderInfo;Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/method/data/CJUnifyPayMethodTuple;Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/method/data/CJUnifyMethodListScene;)V", "getPayMethodTuple", "()Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/method/data/CJUnifyPayMethodTuple;", "getScene", "()Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/method/data/CJUnifyMethodListScene;", "getCashierInfo", "bdpay-front-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJUnifyPayMethodModuleParams {
    private final CJUnifyPayMethodTuple payMethodTuple;
    private final CJUnifyMethodListScene scene;
    private final UnifyCashierRenderInfo unifyCashierRenderInfo;

    public final UnifyCashierRenderInfo getCashierInfo() {
        return this.unifyCashierRenderInfo;
    }

    public final CJUnifyPayMethodTuple getPayMethodTuple() {
        return this.payMethodTuple;
    }

    public final CJUnifyMethodListScene getScene() {
        return this.scene;
    }

    public CJUnifyPayMethodModuleParams(UnifyCashierRenderInfo r100, CJUnifyPayMethodTuple r101, CJUnifyMethodListScene r102) {
        Intrinsics.checkNotNullParameter(r102, "scene");
        this.unifyCashierRenderInfo = r100;
        this.payMethodTuple = r101;
        this.scene = r102;
    }

    public /* synthetic */ CJUnifyPayMethodModuleParams(UnifyCashierRenderInfo r100, CJUnifyPayMethodTuple r101, CJUnifyMethodListScene r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r103 & 4) == 0) goto L8;
        r102 = CJUnifyMethodListScene.SCENE_INIT;
    L8:
        this(r100, r101, r102);
    }
}
