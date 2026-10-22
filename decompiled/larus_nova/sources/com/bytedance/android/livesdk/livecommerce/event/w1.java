package com.bytedance.android.livesdk.livecommerce.event;

/* JADX INFO: loaded from: classes10.dex */
public final class w1 extends ECEventV3 {
    public w1(String r100, String r101, String r102, int r103, long r104) {
        super("livesdk_send_coupons_duration");
        f("coupon_id", r100);
        f("anchor_id", r101);
        f("room_id", r102);
        d(com.bytedance.android.ec.core.event.a.KEY_COUPON_TYPE, r103);
        f("duration", String.valueOf(r104));
        f("type", "stop");
    }
}
