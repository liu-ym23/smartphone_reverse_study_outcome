package com.bytedance.android.livesdk.livecommerce.event;

import com.bytedance.android.livesdkapi.IStartLiveInterceptor;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes10.dex */
public final class d1 extends ECEventV3 {
    public d1(Map<String, String> r100, int r101, int r102, String r103, String r104, int r105, int r106, int r110, int r111, int r112, int r113) {
        super("livesdk_ecom_entrance_show_status");
        Iterator<Map.Entry<String, String>> r107 = r100.entrySet().iterator();
    L4:
        if (r107.hasNext() == false) goto L6;
        Map.Entry<String, String> r108 = r107.next();
        f(r108.getKey(), r108.getValue());
        goto L4
    L6:
        d("anchor_with_commerce_permission", r101);
        d(IStartLiveInterceptor.StartLiveParams.KEY_COMMERCE_LIVE_ENABLED, r102);
        f("ecom_entrance_show_status", r103);
        f("extra_message", r104);
        d("report_when_enter", r105);
        d("room_cart_valid", r106);
        d("room_cart_show_cart", r110);
        d("request_live_promotions", r111);
        d("request_has_goods", r112);
        d("request_show_cart", r113);
    }
}
