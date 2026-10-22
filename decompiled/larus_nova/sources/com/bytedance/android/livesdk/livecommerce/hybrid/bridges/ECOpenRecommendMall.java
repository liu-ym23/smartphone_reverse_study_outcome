package com.bytedance.android.livesdk.livecommerce.hybrid.bridges;

import android.content.Context;
import com.bytedance.android.bcm.api.model.BcmParams;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.btm.api.model.d;
import com.bytedance.android.ec.core.utils.BtmUtilsKt;
import com.bytedance.android.ec.host.api.hybrid.ECBaseBridgeMethod;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/hybrid/bridges/ECOpenRecommendMall;", "Lcom/bytedance/android/ec/host/api/hybrid/ECBaseBridgeMethod;", "<init>", "()V", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECOpenRecommendMall extends ECBaseBridgeMethod {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f147837e;

    public ECOpenRecommendMall() {
        this.f147837e = "ecOpenRecommendMall";
    }

    @Override // com.bytedance.android.ec.model.hybrid.IECBridgeMethod
    public final String getName() {
        return this.f147837e;
    }

    @Override // com.bytedance.android.ec.host.api.hybrid.ECBaseBridgeMethod
    public final void c(final JSONObject r100, final ECBaseBridgeMethod.a r101) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, "iReturn");
        String r102 = r100.optString("btm");
        String r103 = r100.optString("bcm");
        Context r104 = getContext();
        String r105 = r100.optString("mallScheme");
        if (r105.length() <= 0) goto L5;
        boolean r106 = true;
    L7:
        if (r106 == true) goto L10;
        r105 = null;
    L10:
        BcmParams.Companion.getClass();
        d r107 = BtmUtilsKt.d(r102, BcmParams.a.a(r103), PageFinder.via(b().f545990a));
        if (r105 == null) goto L13;
        String r108 = BtmUtilsKt.b(r105, r107);
    L15:
        if (((Unit) UtilityKotlinExtentionsKt.f(r104, r108, new ECOpenRecommendMall$handle$3(r100, r101))) != null) goto L18;
        r101.onFailed(0, null);
        Unit r109 = Unit.INSTANCE;
        return;
    L18:
        return;
    L13:
        r108 = null;
        goto L15
    L5:
        r106 = false;
        goto L7
    }
}
