package com.bytedance.android.livesdk.livecommerce.event;

/* JADX INFO: loaded from: classes10.dex */
public final class l1 extends ECEventV3 {
    public l1(String r100, String r101, long r102) {
        super("livesdk_product_card_time");
        this.f147721c.c("anchor_id", r100);
        this.f147721c.c("room_id", r101);
        this.f147721c.b("duration", r102);
    }
}
