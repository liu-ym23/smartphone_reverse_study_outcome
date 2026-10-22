package com.bytedance.android.livesdk.livecommerce.event;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class r1 extends ECEventV3 {
    public r1(String r100, String r101, int r102, long r103, long r104, boolean r105, boolean r110, boolean r111, boolean r112, String r113, long r114) {
        Intrinsics.checkNotNullParameter(r100, "roomId");
        Intrinsics.checkNotNullParameter(r101, "anchorId");
        Intrinsics.checkNotNullParameter(r113, "preloadTiming");
        super("livesdk_room_promotion_list_trace");
        f("room_id", r100);
        f("anchor_id", r101);
        d("list_showed_times", r102);
        if (r103 <= 0) goto L5;
        e("list_first_show_time", r103);
    L5:
        e("live_room_duration", r104);
        String r106 = "1";
        if (r105 == false) goto L8;
        String r107 = "1";
    L9:
        f("preload_list_data", r107);
        if (r110 == false) goto L12;
        String r108 = "1";
    L13:
        f("preload_list_layout", r108);
        if (r111 == false) goto L16;
        String r109 = "1";
    L17:
        f("first_show_hit_cache_data", r109);
        if (r112 == true) goto L21;
        r106 = "0";
    L21:
        f("first_show_hit_cache_layout", r106);
        f("preload_timing", r113);
        if (r114 <= 0) goto L25;
        e("preload_time_after_entering_room", r114);
        return;
    L25:
        return;
    L16:
        r109 = "0";
        goto L17
    L12:
        r108 = "0";
        goto L13
    L8:
        r107 = "0";
        goto L9
    }
}
