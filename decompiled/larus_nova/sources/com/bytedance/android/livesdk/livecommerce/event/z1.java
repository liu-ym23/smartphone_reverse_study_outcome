package com.bytedance.android.livesdk.livecommerce.event;

import com.bytedance.android.livesdk.livecommerce.room.controller.business.RoomContextController;
import java.util.Map;

/* JADX INFO: loaded from: classes10.dex */
public final class z1 extends u0 {

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.livecommerce.event.ECEventV3
    public final ECEventV3 g(Map r100) {
        super.g(r100);
        return this;
    }

    public final void p(Map r100) {
        super.g(r100);
    }

    public final void q(Map r100) {
        super.g(r100);
    }

    public z1(int r100, RoomContextController r101) {
        if (r100 == 9) goto L5;
        String r102 = "livesdk_show_product";
    L6:
        super(r101, r102);
        return;
    L5:
        r102 = "livesdk_unrec_show_product";
        goto L6
    }

    public final void o(boolean r100, String r101) {
        if (this.f147721c.g("is_exist_matching_button").booleanValue() == true) goto L8;
        if (r100 == false) goto L6;
        String r102 = "1";
    L7:
        f("is_exist_matching_button", r102);
        goto L8
    L6:
        r102 = "0";
    L8:
        if (r100 == false) goto L12;
        if (r101 == null) goto L13;
        f(com.bytedance.android.ec.core.event.a.KEY_COMBINATION_ID, r101);
        return;
    L13:
        return;
    }
}
