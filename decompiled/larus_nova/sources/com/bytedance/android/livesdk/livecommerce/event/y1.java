package com.bytedance.android.livesdk.livecommerce.event;

import com.bytedance.android.livesdk.livecommerce.room.controller.business.RoomContextController;

/* JADX INFO: loaded from: classes10.dex */
public final class y1 extends u0 {
    public y1(RoomContextController r100) {
        super(r100, "livesdk_popup_card_show_duration");
        f("page_name", "live_list");
        f("source_page", l0.n());
        f("anchor_id", l0.i("anchor_id"));
        f("group_id", l0.i("group_id"));
        f(com.bytedance.android.ec.core.event.a.KEY_CARRIER_SOURCE, l0.d());
        f(com.bytedance.android.ec.core.event.a.KEY_SOURCE_METHOD, l0.e());
        f("enter_from_merge", l0.d());
        f("enter_method", l0.i("enter_method"));
        f("room_id", l0.i("room_id"));
    }
}
