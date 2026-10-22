package com.bytedance.android.livesdk.utils;

import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import com.ss.mediakit.medialoader.AVMDLDataLoaderConfigure;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes11.dex */
public final class k6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f159042a = 0;

    @JvmStatic
    public static final String a() {
        com.bytedance.android.live.profit.vip.e r100 = yt0.c.l();
        if (r100 == null) goto L9;
        com.bytedance.live.datacontext.m<? extends com.bytedance.android.live.profit.vip.h> r101 = r100.getSubscribeInfo();
        if (r101 == null) goto L9;
        com.bytedance.android.live.profit.vip.h r102 = r101.getValue();
        if (r102 == null) goto L9;
        int r103 = r102.f89136d;
    L10:
        if (r103 == 0) goto L44;
        long r104 = 0;
        boolean r105 = true;
        if (r103 != 1) goto L14;
        long r106 = System.currentTimeMillis() / ((long) 1000);
        com.bytedance.android.live.profit.vip.e r107 = yt0.c.l();
        if (r107 == null) goto L38;
        com.bytedance.live.datacontext.m<? extends com.bytedance.android.live.profit.vip.h> r108 = r107.getSubscribeInfo();
        if (r108 == null) goto L38;
        com.bytedance.android.live.profit.vip.h r109 = r108.getValue();
        if (r109 == null) goto L38;
        r104 = r109.f89142j;
    L38:
        if ((r104 - r106) > 604800) goto L41;
        r105 = false;
    L41:
        if (r105 == false) goto L43;
        return "activated_over_7d";
    L43:
        return "activated_in_7d";
    L14:
        if (r103 == 2) goto L16;
        return "null";
    L16:
        long r110 = System.currentTimeMillis() / ((long) 1000);
        com.bytedance.android.live.profit.vip.e r111 = yt0.c.l();
        if (r111 == null) goto L24;
        com.bytedance.live.datacontext.m<? extends com.bytedance.android.live.profit.vip.h> r112 = r111.getSubscribeInfo();
        if (r112 == null) goto L24;
        com.bytedance.android.live.profit.vip.h r113 = r112.getValue();
        if (r113 == null) goto L24;
        r104 = r113.f89142j;
    L24:
        if ((r110 - r104) > AVMDLDataLoaderConfigure.DEFAULT_MAX_CACHE_AGE) goto L27;
        r105 = false;
    L27:
        if (r105 == false) goto L29;
        return "expired_out_14d";
    L29:
        return "expired_in_14d";
    L44:
        return "nonactivated";
    L9:
        r103 = -1;
        goto L10
    }

    static {
    }

    public static void b(int r100, boolean r101) {
        Pair[] r102 = new Pair[3];
        r102[0] = TuplesKt.to("livevip_status", a());
        com.bytedance.android.live.profit.vip.e r103 = yt0.c.l();
        if (r103 == null) goto L9;
        com.bytedance.live.datacontext.i<Boolean> r104 = r103.isAnchor();
        if (r104 == null) goto L9;
        Boolean r105 = r104.getValue();
        if (r105 == null) goto L9;
        boolean r106 = r105.booleanValue();
    L10:
        String r107 = "1";
        if (r106 == false) goto L13;
        Object r108 = "1";
    L14:
        r102[1] = TuplesKt.to(IPerformanceManager.Params.is_anchor, r108);
        if (r101 == true) goto L18;
        r107 = "0";
    L18:
        r102[2] = TuplesKt.to("is_dotted", r107);
        Map<String, String> r109 = MapsKt.mutableMapOf(r102);
        if (r100 == 2) goto L21;
    L25:
        if (r100 != 1) goto L27;
        String r110 = "livesdk_livevip_emoji_tab_show";
    L28:
        com.bytedance.android.livesdk.log.j0.l().sendLog(r110, r109, new Object[]{IRoom.class, am2.x.class});
        return;
    L27:
        r110 = "livesdk_livevip_emoji_tab_click";
        goto L28
    L21:
        if (l42.a.f507334u.getValue().booleanValue() == false) goto L23;
        String r111 = "vip_page";
    L24:
        r109.put("request_page", r111);
        goto L25
    L23:
        r111 = "comment";
        goto L24
    L13:
        r108 = "0";
    L9:
        r106 = false;
        goto L10
    }
}
