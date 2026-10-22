package com.bytedance.android.marketing.sdk.impl.utils;

import com.bytedance.ies.bullet.service.base.c1;
import com.bytedance.ies.bullet.service.base.r;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public final class c {
    public c() {
    }

    static {
    }

    public static void a(String r100, JSONObject r110, JSONObject r111, int r112) {
        if ((r112 & 4) == 0) goto L5;
        JSONObject r101 = null;
    L7:
        if ((r112 & 8) == 0) goto L9;
        JSONObject r102 = null;
    L10:
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter("cardx_hybrid", "bid");
        c1 r113 = new c1(r100, null, r101, r102, null, 100);
        r113.f247800j = "cardx_hybrid";
        r113.f247802l = 1;
        s26.d r103 = s26.d.f540305c;
        r r104 = (r) s26.d.f540305c.d("cardx_hybrid", r.class);
        if (r104 != null) goto L13;
        r104 = (r) s26.d.f540305c.c(r.class);
    L13:
        if (r104 == null) goto L16;
        r104.S(r113);
        return;
    L16:
        return;
    L9:
        r102 = r111;
        goto L10
    L5:
        r101 = r110;
        goto L7
    }
}
