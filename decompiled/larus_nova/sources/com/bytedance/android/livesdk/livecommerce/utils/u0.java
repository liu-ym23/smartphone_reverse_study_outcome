package com.bytedance.android.livesdk.livecommerce.utils;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public final class u0 extends a1 {
    public u0(boolean r100, String r101) {
        Intrinsics.checkNotNullParameter("", "logId");
        super("promotions");
        JSONObject r102 = this.f153061a;
        r102.put("log_id", "");
        if (r101 == null) goto L5;
        r102.put("error", r101);
    L5:
        r102.put("show_cart", r100 ? 1 : 0);
    }
}
