package com.bytedance.android.shopping.new_cart.components;

import com.bytedance.android.shopping.new_cart.utils.CartSettingUtils;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public final class CartEventCenterComponent$addCartSubscriber$1 implements ti.j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CartEventCenterComponent f178712a;

    public CartEventCenterComponent$addCartSubscriber$1(CartEventCenterComponent r100) {
        this.f178712a = r100;
    }

    @Override // ti.j
    public final void a(final JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Lazy r101 = CartSettingUtils.f179349a;
        Function0<Unit> r102 = new CartEventCenterComponent$addCartSubscriber$1$onReceiveJsEvent$1(this, r100);
        Intrinsics.checkNotNullParameter(r102, "action");
        r102.invoke();
    }
}
