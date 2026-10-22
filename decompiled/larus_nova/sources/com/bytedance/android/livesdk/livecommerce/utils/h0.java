package com.bytedance.android.livesdk.livecommerce.utils;

import com.bytedance.android.livesdkapi.IStartLiveInterceptor;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public final class h0 extends a1 {
    public h0(String r100, boolean r101, boolean r102, boolean r103, boolean r104, boolean r105) {
        Intrinsics.checkNotNullParameter(r100, "logId");
        super("enter");
        JSONObject r106 = this.f153061a;
        r106.put("log_id", r100);
        r106.put("toolbar_control", r101 ? 1 : 0);
        r106.put(IStartLiveInterceptor.StartLiveParams.KEY_COMMERCE_LIVE_ENABLED, r102 ? 1 : 0);
        r106.put("room_cart", r103 ? 1 : 0);
        if (r103 == false) goto L5;
        r106.put("room_cart.show_cart", r104 ? 1 : 0);
    L5:
        if (r101 == false) goto L9;
        if (r103 == false) goto L10;
        r106.put("toolbar_equal_cart", r105 ? 1 : 0);
        return;
    L10:
        return;
    }
}
