package com.bytedance.android.livesdk.livecommerce.event;

import com.bytedance.android.livesdk.livecommerce.room.controller.business.RoomContextController;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class s0 extends u0 {

    public static final class a {
    }

    static {
    }

    public s0(String r100, RoomContextController r101) {
        Intrinsics.checkNotNullParameter("live_popup_card", "carrierType");
        super(r101, "livesdk_show_".concat(r100));
        f("room_id", l0.i("room_id"));
        f("anchor_id", l0.i("anchor_id"));
        f("enter_from_merge", l0.d());
        f("enter_method", l0.i("enter_method"));
        f(com.bytedance.android.ec.core.event.a.KEY_ECOM_GROUP_TYPE, l0.i(com.bytedance.android.ec.core.event.a.KEY_ECOM_GROUP_TYPE));
        f("action_type", l0.i("action_type"));
        f("label_type", "label");
        f(com.bytedance.android.ec.core.event.a.KEY_ECOM_ENTRANCE_FORM, "live_popup_card");
    }
}
