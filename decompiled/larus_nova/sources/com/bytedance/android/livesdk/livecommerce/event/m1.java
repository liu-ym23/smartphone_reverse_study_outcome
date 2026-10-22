package com.bytedance.android.livesdk.livecommerce.event;

import android.text.TextUtils;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.RoomContextController;
import java.util.Map;

/* JADX INFO: loaded from: classes10.dex */
public final class m1 extends u0 {
    @Override // com.bytedance.android.livesdk.livecommerce.event.ECEventV3
    public final ECEventV3 g(Map r100) {
        super.g(r100);
        return this;
    }

    public final void o(Map r100) {
        super.g(r100);
    }

    public m1(String r100, String r101, String r102, String r103, RoomContextController r104) {
        super(r104, "livesdk_product_entrance_click");
        f("anchor_id", r100);
        f("room_id", r101);
        if (TextUtils.equals(r103, "not_report") == true) goto L5;
        f(com.bytedance.android.ec.core.event.a.KEY_CLICK_AREA, r103);
    L5:
        f(com.bytedance.android.ec.core.event.a.KEY_ECOM_ENTRANCE_FORM, r102);
    }

    public final void p(String r100, String r101, String r102, Map r103, Map r104) {
        super.g(r103);
        super.g(r104);
        f(com.bytedance.android.ec.core.event.a.KEY_COMMODITY_ID, r100);
        f(com.bytedance.android.ec.core.event.a.KEY_COMMODITY_TYPE, r101);
        f("product_id", r102);
    }
}
