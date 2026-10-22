package com.bytedance.android.livesdk.livecommerce.event;

/* JADX INFO: loaded from: classes10.dex */
public final class h1 extends ECEventV3 {
    public h1(String r100, String r101, String r102, int r103) {
        super("livesdk_present_coupon");
        f("room_id", r100);
        f("coupon_id", r101);
        f(com.bytedance.android.ec.core.event.a.KEY_SHOP_ID, r102);
        f("self_shop", String.valueOf(r103));
    }
}
