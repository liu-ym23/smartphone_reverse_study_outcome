package com.bytedance.android.livesdk.livecommerce.event;

import com.bytedance.android.livesdk.livecommerce.room.controller.business.RoomContextController;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class q1 extends u0 {
    public q1(RoomContextController r100) {
        Intrinsics.checkNotNullParameter(r100, "controller");
        super(r100, "livesdk_ecom_product_introduce");
        f("room_id", l0.j("room_id", r100));
        f("anchor_id", l0.j("anchor_id", r100));
        f("enter_from_merge", l0.j("enter_from_merge", r100));
        f("enter_method", l0.j("enter_method", r100));
        f(com.bytedance.android.ec.core.event.a.KEY_ECOM_GROUP_TYPE, l0.j(com.bytedance.android.ec.core.event.a.KEY_ECOM_GROUP_TYPE, r100));
        f("action_type", l0.j("action_type", r100));
    }
}
