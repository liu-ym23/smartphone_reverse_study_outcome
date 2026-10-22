package com.bytedance.android.livesdk.livecommerce.event;

/* JADX INFO: loaded from: classes10.dex */
public final class n extends ECEventV3 {
    public n() {
        super("livesdk_ec_card_on_close_list");
        String r100 = l0.i("room_id");
        f("enter_method", l0.e());
        f("anchor_id", l0.i("anchor_id"));
        f("room_id", r100);
    }
}
