package com.bytedance.android.livesdk.utils;

import android.content.Context;
import com.bytedance.android.live.browser.IBrowserService;
import com.bytedance.android.livesdk.TTLiveSDKContext;
import com.bytedance.android.livesdk.config.LiveConfigSettingKeys;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class x6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f159218a = 0;

    static {
    }

    public static void a(Context r100, String r101, Map r110, int r111) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "userId");
        Intrinsics.checkNotNullParameter(r110, "params");
        if (r111 != 1) goto L5;
        ((com.bytedance.android.livesdk.service.f) TTLiveSDKContext.getHostService()).a().openUserProfilePage(r101, r110);
        return;
    L5:
        if (r111 != 2) goto L7;
        ((IBrowserService) jc1.k.n(IBrowserService.class)).openHybridUserProfilePage(r100, r101, r110);
        return;
    L7:
        if (r111 == 3) goto L10;
        return;
    L10:
        if (LiveConfigSettingKeys.LIVE_ENABLE_NAVIGATE_DOUYIN_SDK_PROFILE_PAGE.getValue().booleanValue() == false) goto L36;
        com.bytedance.android.livesdk.log.filter.o r112 = com.bytedance.android.livesdk.log.u.l().c(am2.x.class);
        String r113 = "";
        if (r112 == null) goto L21;
        String r102 = r112.getMap().get("enter_from_merge");
        if (r102 != null) goto L16;
        r102 = "";
    L16:
        String r114 = r112.getMap().get("enter_method");
        if (r114 != null) goto L19;
        r114 = "";
    L19:
        Map<String, String> r103 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("enter_from", "live_detail"), TuplesKt.to("enter_method", r114), TuplesKt.to("author_openid", r101), TuplesKt.to("enter_from_merge", r102)});
        if (r103 == null) goto L21;
    L22:
        com.bytedance.android.livesdk.log.filter.o r115 = com.bytedance.android.livesdk.log.u.l().c(Room.class);
        if (r115 == null) goto L32;
        String r104 = r115.getMap().get("request_id");
        if (r104 != null) goto L27;
        r104 = "";
    L27:
        r103.put("impr", r104);
        String r116 = r115.getMap().get("room_id");
        if (r116 == null) goto L31;
        r113 = r116;
    L31:
        String r117 = r103.put("room_id", r113);
    L32:
        ((com.bytedance.android.livesdk.service.f) TTLiveSDKContext.getHostService()).a().openDouyinProfilePage(r101, r103);
        return;
    L21:
        r103 = new LinkedHashMap();
        goto L22
    }
}
