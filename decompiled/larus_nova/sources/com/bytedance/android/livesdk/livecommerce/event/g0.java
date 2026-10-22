package com.bytedance.android.livesdk.livecommerce.event;

import com.bytedance.android.livesdk.livecommerce.promotionlist.model.LivePromotionPageRoomInfo;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class g0 extends u0 {
    public g0(String r100, gi2.a r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        super(r100);
        f("source_page", l0.n());
        f(com.bytedance.android.ec.core.event.a.KEY_ECOM_ENTRANCE_FORM, "live_list_card");
        f("anchor_id", l0.i("anchor_id"));
        f("group_id", l0.i("group_id"));
        f(com.bytedance.android.ec.core.event.a.KEY_CARRIER_SOURCE, l0.d());
        f(com.bytedance.android.ec.core.event.a.KEY_SOURCE_METHOD, l0.e());
        f("enter_from_merge", l0.d());
        f("enter_method", l0.i("enter_method"));
        f("room_id", l0.i("room_id"));
        f("action_type", l0.i("action_type"));
        f("request_id", l0.i("request_id"));
        f("screen_type", l0.m(null, null));
        if (r101 == null) goto L18;
        Function0<LivePromotionPageRoomInfo> r102 = r101.f481339e;
        if (r102 == null) goto L19;
        LivePromotionPageRoomInfo r103 = r102.invoke();
        if (r103 == null) goto L20;
        f(IPerformanceManager.Params.room_type, String.valueOf(r103.getRoomType()));
        f("instant_room_type", String.valueOf(r103.getInstantRoomType()));
        String r104 = r103.getReceiveAddressId();
        if (r104 == null) goto L11;
        f("receive_address_id", r104);
    L11:
        String r105 = r103.getAddressType();
        if (r105 == null) goto L14;
        f("address_type", r105);
    L14:
        String r106 = r103.getAddressStrategy();
        if (r106 == null) goto L21;
        f("address_strategy_type", r106);
        return;
    L21:
        return;
    L20:
        return;
    L19:
        return;
    }
}
