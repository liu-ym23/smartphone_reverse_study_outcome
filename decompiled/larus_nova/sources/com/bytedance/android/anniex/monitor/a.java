package com.bytedance.android.anniex.monitor;

import com.bytedance.android.monitorV2.g;
import jz2.d;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
public final class a {
    static {
    }

    public static void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "errorMsg");
        d.a r101 = new d.a("bdx_anniex_card_props_error");
        r101.f501114b = "bullet_custom_bid";
        r101.b(0);
        JSONObject r102 = new JSONObject();
        r102.put("scene", "anniex_card");
        r102.put("error_msg", r100);
        r101.f501116d = r102;
        d r103 = r101.a();
        g.e().getClass();
        g.c(r103);
    }
}
