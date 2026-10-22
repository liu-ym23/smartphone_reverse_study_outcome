package com.bytedance.android.livesdk.livecommerce.event;

import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class u1 extends ECEventV3 {
    @Override // com.bytedance.android.livesdk.livecommerce.event.ECEventV3
    public final void k() {
        f("source_page", i("enter_from_merge") + "_temai_" + i("enter_method"));
        super.k();
    }

    public u1(Map r100) {
        Intrinsics.checkNotNullParameter(r100, "enterRoomParams");
        Intrinsics.checkNotNullParameter("livesdk_ec_room_enter_success", "eventName");
        super("livesdk_ec_room_enter_success");
        String r101 = (String) r100.get("ec_room_enter");
        if (r101 != null) goto L5;
        r101 = "0";
    L5:
        f("ec_room_enter", r101);
        if (Intrinsics.areEqual("1", (String) r100.get("is_ec_open")) == false) goto L8;
        f("is_ec_open", "1");
    L9:
        String r102 = (String) r100.get("is_ec_open");
        String r103 = (String) r100.get("ec_room_enter_start_time");
        if (Intrinsics.areEqual("1", r102) == false) goto L13;
        if (r103 == null) goto L13;
        long r104 = CastLongProtector.parseLong(r103);
        e("ec_room_enter_duration", System.currentTimeMillis() - r104);
    L13:
        f(ILiveRoomPlayFragmentConstant.ENTER_ECOM_LIVE_PARAMS, cd.a.c(r100).toString());
        return;
    L8:
        f("is_ec_open", "0");
        goto L9
    }
}
