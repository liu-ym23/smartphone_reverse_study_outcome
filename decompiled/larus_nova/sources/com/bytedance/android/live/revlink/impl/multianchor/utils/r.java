package com.bytedance.android.live.revlink.impl.multianchor.utils;

import com.bytedance.android.livesdk.link.model.IBattleConfigSetting;
import com.bytedance.android.livesdk.link.model.u2;
import com.bytedance.android.livesdk.link.model.v2;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class r {
    public static final void a(IBattleConfigSetting r100, Map<String, String> r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$packetCustomizeData");
        Intrinsics.checkNotNullParameter(r101, "logMap");
        u2 r102 = r100.getSelfData();
        if (r102 == null) goto L5;
        int r103 = r102.getPkValueType();
    L7:
        if (1 <= r103) goto L10;
        return;
    L10:
        if (99 < r103) goto L39;
        r101.put("customize_pk_type", String.valueOf(r103));
        u2 r104 = r100.getSelfData();
        String r105 = "";
        if (r104 == null) goto L15;
        String r106 = String.valueOf(r104.getPkGiftValueLevel());
        if (r106 == null) goto L15;
    L16:
        r101.put("giftvalue_exchange_rate", r106);
        u2 r107 = r100.getSelfData();
        if (r107 == null) goto L20;
        String r108 = String.valueOf(r107.getPkUVLevel());
        if (r108 == null) goto L20;
    L21:
        r101.put("giftuv_exchange_rate", r108);
        u2 r109 = r100.getSelfData();
        if (r109 == null) goto L25;
        String r110 = String.valueOf(r109.getPkTicketLevel());
        if (r110 == null) goto L25;
    L26:
        r101.put("ticket_exchange_rate", r110);
        u2 r111 = r100.getSelfData();
        if (r111 == null) goto L30;
        String r112 = String.valueOf(r111.getPkLikeLevel());
        if (r112 == null) goto L30;
    L31:
        r101.put("like_exchange_rate", r112);
        v2 r113 = r100.getSelfSettingRate();
        if (r113 == null) goto L37;
        String r114 = String.valueOf(r113.getPkVIPRate());
        if (r114 == null) goto L37;
        r105 = r114;
    L37:
        r101.put("membership_exchange_rate", r105);
        return;
    L30:
        r112 = "";
    L25:
        r110 = "";
    L20:
        r108 = "";
    L15:
        r106 = "";
        goto L16
    L39:
        return;
    L5:
        r103 = 0;
        goto L7
    }
}
