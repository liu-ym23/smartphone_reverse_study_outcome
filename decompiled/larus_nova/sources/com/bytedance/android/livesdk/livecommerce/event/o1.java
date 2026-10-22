package com.bytedance.android.livesdk.livecommerce.event;

/* JADX INFO: loaded from: classes10.dex */
public final class o1 extends ECEventV3 {
    public o1(String r100, String r101, String r102, long r103) {
        super("livesdk_product_entrance_time");
        this.f147721c.c("anchor_id", r100);
        this.f147721c.c("room_id", r101);
        this.f147721c.c("follow_status", r102);
        this.f147721c.b("duration", r103);
    }
}
