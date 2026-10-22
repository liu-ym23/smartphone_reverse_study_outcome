package com.bytedance.android.livesdk.livecommerce.event;

/* JADX INFO: loaded from: classes10.dex */
public final class q0 extends ECEventV3 {
    public q0(String r100, String r101) {
        super("livesdk_show_guide_bubble");
        f("room_id", r100);
        f("anchor_id", r101);
        f("page_name", "within_live");
        f("bubble_type", "coupon_detail");
    }
}
