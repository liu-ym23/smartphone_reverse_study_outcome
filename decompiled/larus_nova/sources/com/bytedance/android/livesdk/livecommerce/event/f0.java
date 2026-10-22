package com.bytedance.android.livesdk.livecommerce.event;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class f0 extends ECEventV3 {

    public static final class a {
    }

    static {
    }

    public f0(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r102, "productType");
        super("livesdk_create_product_buynow_sku_success");
        f("anchor_id", r100);
        f("room_id", r101);
        f("live_product_type", r102);
    }
}
