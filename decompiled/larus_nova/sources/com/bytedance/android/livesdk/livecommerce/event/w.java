package com.bytedance.android.livesdk.livecommerce.event;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class w extends ECEventV3 {
    public w(String r100, String r101, long r102, String r103, boolean r104) {
        Intrinsics.checkNotNullParameter(r103, "productType");
        super("livesdk_create_product_duration");
        f("anchor_id", r100);
        f("room_id", r101);
        f("duration", String.valueOf(r102));
        f("live_product_type", r103);
        if (r104 == false) goto L5;
        String r105 = "1";
    L6:
        f("has_aftersale_insurance", r105);
        return;
    L5:
        r105 = "0";
        goto L6
    }
}
