package com.bytedance.android.shopping.new_cart.components;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public final class CartEventCenterComponent$deleteShops$1 implements ti.j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CartEventCenterComponent f178721a;

    public CartEventCenterComponent$deleteShops$1(CartEventCenterComponent r100) {
        this.f178721a = r100;
    }

    @Override // ti.j
    public final void a(final JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        CartEventCenterComponent.n(this.f178721a, r100, new CartEventCenterComponent$deleteShops$1$onReceiveJsEvent$1(this, r100));
    }
}
