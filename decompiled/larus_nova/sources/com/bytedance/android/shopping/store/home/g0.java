package com.bytedance.android.shopping.store.home;

import com.bytedance.android.shopping.store.home.entity.ToolType;
import com.larus.nova.R;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class g0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f183779a = 0;

    static {
    }

    public static void a(List r110, boolean r111, Function0 r112, String r113, Function0 r114, boolean r115, String r116, Function0 r117, boolean r210, String r211, Function0 r212) {
        Intrinsics.checkNotNullParameter(r110, "entryList");
        Intrinsics.checkNotNullParameter(r113, "couponLabelText");
        Intrinsics.checkNotNullParameter(r114, "onCouponClick");
        Intrinsics.checkNotNullParameter(r116, "cartLabelText");
        Intrinsics.checkNotNullParameter(r117, "onCartClick");
        Intrinsics.checkNotNullParameter(r211, "orderLabelText");
        Intrinsics.checkNotNullParameter(r212, "onOrderClick");
        if (r111 == false) goto L5;
        Unit r100 = (Unit) r112.invoke();
        com.bytedance.android.ec.model.h r101 = new com.bytedance.android.ec.model.h(r114, R.drawable.ic_shop_coupon_center, "shop_coupon_red_pack", r113, ToolType.COUPON_RED_PACK.getType());
        ((ArrayList) r110).add(r101);
    L5:
        if (r115 == false) goto L7;
        com.bytedance.android.ec.model.h r102 = new com.bytedance.android.ec.model.h(r117, R.drawable.ic_share_shop_cart, "shop_cart", r116, ToolType.CART.getType());
        ((ArrayList) r110).add(r102);
    L7:
        if (r210 == false) goto L10;
        ArrayList r103 = (ArrayList) r110;
        r103.add(new com.bytedance.android.ec.model.h(r212, R.drawable.ic_share_shop_order, "shop_order", r211, ToolType.ORDER.getType()));
        return;
    }
}
