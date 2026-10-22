package com.bytedance.android.livesdk.livecommerce.event;

/* JADX INFO: loaded from: classes10.dex */
public final class p1 extends ECEventV3 {
    public p1(String r100, String r101, String r102, String r103, long r104) {
        super("livesdk_product_explain_duration");
        this.f147721c.c("room_id", r100);
        this.f147721c.c("anchor_id", r101);
        this.f147721c.c(com.bytedance.android.ec.core.event.a.KEY_COMMODITY_ID, r102);
        this.f147721c.c(com.bytedance.android.ec.core.event.a.KEY_COMMODITY_TYPE, r103);
        this.f147721c.b("duration", r104);
    }
}
