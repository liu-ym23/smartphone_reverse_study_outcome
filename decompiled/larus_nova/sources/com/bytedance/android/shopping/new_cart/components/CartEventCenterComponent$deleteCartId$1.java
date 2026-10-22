package com.bytedance.android.shopping.new_cart.components;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public final class CartEventCenterComponent$deleteCartId$1 implements ti.j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CartEventCenterComponent f178720a;

    public CartEventCenterComponent$deleteCartId$1(CartEventCenterComponent r100) {
        this.f178720a = r100;
    }

    @Override // ti.j
    public final void a(final JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        CartEventCenterComponent.n(this.f178720a, r100, new CartEventCenterComponent$deleteCartId$1$onReceiveJsEvent$1(this, r100));
    }
}
