package com.bytedance.android.livesdk.livecommerce.hybrid.bridges;

import com.bytedance.android.ec.core.utils.a2;
import com.bytedance.android.ec.core.utils.w0;
import com.bytedance.android.ec.host.api.hybrid.ECBaseBridgeMethod;
import com.bytedance.android.ec.model.response.IconItem;
import com.bytedance.android.livesdk.livecommerce.room.coupon.EnterRequestHandler;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/hybrid/bridges/ECInsertCartIconAnimationMethod;", "Lcom/bytedance/android/ec/host/api/hybrid/ECBaseBridgeMethod;", "<init>", "()V", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECInsertCartIconAnimationMethod extends ECBaseBridgeMethod {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f147825e;

    public ECInsertCartIconAnimationMethod() {
        this.f147825e = "ecInsertCartIconAnimation";
    }

    @Override // com.bytedance.android.ec.model.hybrid.IECBridgeMethod
    public final String getName() {
        return this.f147825e;
    }

    @Override // com.bytedance.android.ec.host.api.hybrid.ECBaseBridgeMethod
    public final void c(JSONObject r100, ECBaseBridgeMethod.a r101) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, "iReturn");
        String r102 = a2.d(r100.optString("icon"));
        if (r102 == null) goto L5;
        Lazy r103 = EnterRequestHandler.f151767a;
        int r104 = w0.f45736a;
        EnterRequestHandler.f151770d = (IconItem) w0.b(r102, IconItem.class);
    L5:
        r101.onSuccess(null);
    }
}
