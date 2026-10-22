package com.bytedance.android.livesdk.gift.platform.core;

import android.text.TextUtils;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.revenue.common.r0;
import com.bytedance.android.livesdk.gift.model.h2;
import com.bytedance.android.livesdk.gift.platform.core.manager.GiftManagerKt;
import com.bytedance.android.livesdk.revenue.monitor.EventModule;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.performance.IPerformanceStrategyManager;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import defpackage.l0;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
public final class c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c0 f130474a = null;

    public c0() {
    }

    static {
        f130474a = new c0();
    }

    public static void f(int r110) {
        JSONObject r100 = new JSONObject();
        r(r100, "gift_page_type", Integer.valueOf(r110));
        yz0.k r111 = (yz0.k) com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), yz0.k.class);
        if (r111 == null) goto L5;
        IRoom r112 = r111.getRoom();
    L6:
        if (r112 == null) goto L11;
        String r101 = r112.getAnchorId();
        if (r101 != null) goto L10;
        r101 = "";
    L10:
        r(r100, "anchor_id", r101);
        r(r100, "room_id", Long.valueOf(r112.getId()));
    L11:
        String r102 = com.bytedance.android.livesdk.gift.platform.core.utils.z.a("ttlive_gift_panel_red_dot_show");
        JSONObject r103 = new JSONObject();
        JSONObject r104 = new JSONObject();
        JSONObject r105 = new JSONObject();
        Intrinsics.checkNotNullParameter(r105, "extra");
        Intrinsics.checkNotNullParameter(r104, "metric");
        EventModule r113 = EventModule.LIVE_GIFT;
        Intrinsics.checkNotNullParameter(r113, "eventModule");
        String r106 = r113.getValue();
        r104.put("status", String.valueOf(0));
        Intrinsics.checkNotNullParameter(r105, "map");
        Iterator<String> r114 = r100.keys();
    L13:
        if (r114.hasNext() == false) goto L15;
        String r107 = r114.next();
        Object r108 = r100.get(r107);
        Intrinsics.checkNotNullParameter(r107, "key");
        Intrinsics.checkNotNullParameter(r108, "value");
        r105.put(r107, r108);
        goto L13
    L15:
        cy0.e.f465759a.getClass();
        cy0.j r109 = cy0.e.a.f465760a;
        com.bytedance.android.scope.m.f163449e.getClass();
        Object r115 = com.bytedance.android.scope.m.b(r109).b(n97.a.class);
        Intrinsics.checkNotNull(r115);
        ((n97.a) ((com.bytedance.live.kmp.core.c) r115)).g(r102, r106, "bussiness_api_call", r103, r104, r105);
        return;
    L5:
        r112 = null;
        goto L6
    }

    public static void h(int r100) {
        JSONObject r101 = new JSONObject();
        JSONObject r102 = new JSONObject();
        JSONObject r103 = new JSONObject();
        Intrinsics.checkNotNullParameter(r103, "extra");
        Intrinsics.checkNotNullParameter(r102, "metric");
        EventModule r104 = EventModule.LIVE_GIFT;
        Intrinsics.checkNotNullParameter(r104, "eventModule");
        String r105 = r104.getValue();
        r102.put("status", String.valueOf(r100));
        cy0.e.f465759a.getClass();
        cy0.j r106 = cy0.e.a.f465760a;
        com.bytedance.android.scope.m.f163449e.getClass();
        Object r107 = com.bytedance.android.scope.m.b(r106).b(n97.a.class);
        Intrinsics.checkNotNull(r107);
        ((n97.a) ((com.bytedance.live.kmp.core.c) r107)).g("ttlive_gift_prop_timeout_report_status", r105, "bussiness_api_call", r101, r102, r103);
    }

    public static void m(int r100) {
        JSONObject r101 = new JSONObject();
        JSONObject r102 = new JSONObject();
        JSONObject r103 = new JSONObject();
        Intrinsics.checkNotNullParameter(r103, "extra");
        Intrinsics.checkNotNullParameter(r102, "metric");
        EventModule r104 = EventModule.LIVE_GIFT;
        Intrinsics.checkNotNullParameter(r104, "eventModule");
        String r105 = r104.getValue();
        r102.put("status", String.valueOf(r100));
        cy0.e.f465759a.getClass();
        cy0.j r106 = cy0.e.a.f465760a;
        com.bytedance.android.scope.m.f163449e.getClass();
        Object r107 = com.bytedance.android.scope.m.b(r106).b(n97.a.class);
        Intrinsics.checkNotNull(r107);
        ((n97.a) ((com.bytedance.live.kmp.core.c) r107)).g("ttlive_gift_send_timeout_report_status", r105, "bussiness_api_call", r101, r102, r103);
    }

    public static void e(long r110, int r111) {
        String r100 = com.bytedance.android.livesdk.gift.platform.core.utils.z.a("ttlive_gift_list_status");
        JSONObject r101 = new JSONObject();
        JSONObject r102 = new JSONObject();
        JSONObject r103 = new JSONObject();
        Intrinsics.checkNotNullParameter(r103, "extra");
        Intrinsics.checkNotNullParameter(r102, "metric");
        EventModule r104 = EventModule.LIVE_GIFT;
        Intrinsics.checkNotNullParameter(r104, "eventModule");
        String r105 = r104.getValue();
        r102.put("status", String.valueOf(0));
        Intrinsics.checkNotNullParameter(r101, "map");
        Integer r112 = Integer.valueOf(r111);
        Intrinsics.checkNotNullParameter("source", "key");
        Intrinsics.checkNotNullParameter(r112, "value");
        r101.put("source", r112);
        Intrinsics.checkNotNullParameter(r103, "map");
        Long r113 = Long.valueOf(r110);
        Intrinsics.checkNotNullParameter("duration", "key");
        Intrinsics.checkNotNullParameter(r113, "value");
        r103.put("duration", r113);
        cy0.e.f465759a.getClass();
        cy0.j r114 = cy0.e.a.f465760a;
        com.bytedance.android.scope.m.f163449e.getClass();
        Object r115 = com.bytedance.android.scope.m.b(r114).b(n97.a.class);
        Intrinsics.checkNotNull(r115);
        ((n97.a) ((com.bytedance.live.kmp.core.c) r115)).g(r100, r105, "bussiness_api_call", r101, r102, r103);
    }

    public final void a(long r100, long r101) {
        JSONObject r102 = new JSONObject();
        r(r102, ILiveRoomPlayFragmentConstant.ENTER_LIVE_GITF_ID, Long.valueOf(r100));
        r(r102, "asset_id", Long.valueOf(r101));
        yz0.k r103 = (yz0.k) com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), yz0.k.class);
        IRoom r104 = null;
        if (r103 == null) goto L5;
        IRoom r105 = r103.getRoom();
    L7:
        if ((r105 instanceof Room) == false) goto L10;
        r104 = r105;
    L10:
        Room r106 = (Room) r104;
        if (r106 == null) goto L16;
        r(r102, IPerformanceManager.Params.room_type, Integer.valueOf(r106.orientation));
        r(r102, "room_id", Long.valueOf(r106.f162599id));
        String r107 = r106.getAnchorId();
        if (r107 != null) goto L15;
        r107 = "";
    L15:
        r(r102, "anchor_id", r107);
    L16:
        n(this, com.bytedance.android.livesdk.gift.platform.core.utils.z.b("ttlive_asset_id_not_found"), r102, 1);
        return;
    L5:
        r105 = null;
        goto L7
    }

    public final void o(String r100, JSONObject r101) {
        n(this, com.bytedance.android.livesdk.gift.platform.core.utils.z.a(r100), r101, 1);
        n(this, com.bytedance.android.livesdk.gift.platform.core.utils.z.b(r100), r101, 1);
    }

    public final void p(String r100, JSONObject r101) {
        n(this, com.bytedance.android.livesdk.gift.platform.core.utils.z.b(r100), r101, 1);
        r(r101, "duration", 0L);
        n(this, com.bytedance.android.livesdk.gift.platform.core.utils.z.a(r100), r101, 1);
    }

    @JvmStatic
    public static final void i(String r100, int r101, Boolean r102) {
        JSONObject r103 = new JSONObject();
        c0 r104 = f130474a;
        r(r103, "error_code", Integer.valueOf(r101));
        String r105 = "";
        if (r100 != null) goto L5;
        r100 = "";
    L5:
        r(r103, "error_msg", r100);
        yz0.k r106 = (yz0.k) com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), yz0.k.class);
        if (r106 == null) goto L8;
        IRoom r107 = r106.getRoom();
    L9:
        if (r107 == null) goto L15;
        r(r103, "room_id", Long.valueOf(r107.getId()));
        String r108 = r107.getAnchorId();
        if (r108 == null) goto L14;
        r105 = r108;
    L14:
        r(r103, "anchor_id", r105);
    L15:
        com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.f r109 = com.bytedance.android.livesdk.gift.platform.core.utils.s.c();
        if (r109 == null) goto L21;
        IBaseUser r110 = r109.f128462a;
        if (r110 == null) goto L21;
        Object r111 = r110.getIdString();
        if (r111 == null) goto L21;
    L22:
        r(r103, "to_anchor_id", r111);
        r(new JSONObject(), "use_uplink", Boolean.valueOf(Intrinsics.areEqual(r102, Boolean.TRUE)));
        r104.p("ttlive_prop_list_status", r103);
        return;
    L21:
        r111 = 0L;
        goto L22
    L8:
        r107 = null;
        goto L9
    }

    @JvmStatic
    public static final void j(long r110, int r111, boolean r112) {
        String r100 = com.bytedance.android.livesdk.gift.platform.core.utils.z.a("ttlive_prop_list_status");
        JSONObject r101 = new JSONObject();
        JSONObject r102 = new JSONObject();
        JSONObject r103 = new JSONObject();
        Intrinsics.checkNotNullParameter(r103, "extra");
        Intrinsics.checkNotNullParameter(r102, "metric");
        Intrinsics.checkNotNullParameter(r101, "map");
        Boolean r113 = Boolean.valueOf(r112);
        Intrinsics.checkNotNullParameter("use_uplink", "key");
        Intrinsics.checkNotNullParameter(r113, "value");
        r101.put("use_uplink", r113);
        EventModule r114 = EventModule.LIVE_GIFT;
        Intrinsics.checkNotNullParameter(r114, "eventModule");
        String r115 = r114.getValue();
        r102.put("status", String.valueOf(0));
        Intrinsics.checkNotNullParameter(r103, "map");
        Long r116 = Long.valueOf(r110);
        Intrinsics.checkNotNullParameter("duration", "key");
        Intrinsics.checkNotNullParameter(r116, "value");
        r103.put("duration", r116);
        Integer r117 = Integer.valueOf(r111);
        Intrinsics.checkNotNullParameter("prop_count", "key");
        Intrinsics.checkNotNullParameter(r117, "value");
        r103.put("prop_count", r117);
        cy0.e.f465759a.getClass();
        cy0.j r118 = cy0.e.a.f465760a;
        com.bytedance.android.scope.m.f163449e.getClass();
        Object r119 = com.bytedance.android.scope.m.b(r118).b(n97.a.class);
        Intrinsics.checkNotNull(r119);
        ((n97.a) ((com.bytedance.live.kmp.core.c) r119)).g(r100, r115, "bussiness_api_call", r101, r102, r103);
    }

    public static void r(JSONObject r100, String r101, Object r102) {
        Intrinsics.checkNotNullParameter(r100, "$this$safePut");
        Intrinsics.checkNotNullParameter(r101, "key");
        Intrinsics.checkNotNullParameter(r102, "value");
        r100.put(r101, r102);     // Catch: JSONException -> L5
        return;
    L5:
        e = move-exception;
        String r103 = e.getMessage();
        if (r103 != null) goto L9;
        r103 = "";
    L9:
        jy0.b.c("LiveGiftMonitor", r103, null, 4);
    }

    public final void d(String r100, int r101, int r102) {
        JSONObject r103 = new JSONObject();
        r(r103, "error_code", Integer.valueOf(r101));
        String r104 = "";
        if (r100 != null) goto L5;
        r100 = "";
    L5:
        r(r103, "error_msg", r100);
        yz0.k r105 = (yz0.k) com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), yz0.k.class);
        Object r106 = null;
        if (r105 == null) goto L8;
        IRoom r107 = r105.getRoom();
    L9:
        if (r107 == null) goto L15;
        r(r103, "room_id", Long.valueOf(r107.getId()));
        String r108 = r107.getAnchorId();
        if (r108 == null) goto L14;
        r104 = r108;
    L14:
        r(r103, "anchor_id", r104);
    L15:
        com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.f r109 = com.bytedance.android.livesdk.gift.platform.core.utils.s.c();
        if (r109 == null) goto L21;
        IBaseUser r110 = r109.f128462a;
        if (r110 == null) goto L21;
        r106 = r110;
    L23:
        if (r106 != null) goto L25;
        r106 = "0";
    L25:
        r(r103, "to_anchor_id", r106);
        r(r103, "source", Integer.valueOf(r102));
        p("ttlive_gift_list_status", r103);
        return;
    L21:
        if (r107 == null) goto L23;
        r106 = r107.getAnchorId();
        goto L23
    L8:
        r107 = null;
        goto L9
    }

    @JvmStatic
    public static final void c(long r100, String r101, List<String> r102, String r103) {
        JSONObject r104 = new JSONObject();
        c0 r105 = f130474a;
        r(r104, ILiveRoomPlayFragmentConstant.ENTER_LIVE_GITF_ID, Long.valueOf(r100));
        if (r101 != null) goto L5;
        r101 = "";
    L5:
        r(r104, "gift_icon_url", r101);
        if (r103 != null) goto L8;
        r103 = "";
    L8:
        r(r104, "error_msg", r103);
        r(r104, "domain_opt", Integer.valueOf(com.bytedance.android.livesdk.gift.platform.business.i.h().w0() ? 1 : 0));
        r(r104, "domain_check", Integer.valueOf(w12.b.a() ? 1 : 0));
        if (r102 == null) goto L14;
        Iterator<T> r106 = r102.iterator();
    L12:
        if (r106.hasNext() == false) goto L14;
        r104.put("url_0", (String) r106.next());
    L14:
        r105.o("ttlive_gift_icon_load_status", r104);
    }

    public static void n(c0 r100, String r101, JSONObject r102, int r110) {
        r100.getClass();
        JSONObject r103 = new JSONObject();
        JSONObject r104 = new JSONObject();
        JSONObject r105 = new JSONObject();
        Intrinsics.checkNotNullParameter(r105, "extra");
        Intrinsics.checkNotNullParameter(r104, "metric");
        EventModule r106 = EventModule.LIVE_GIFT;
        Intrinsics.checkNotNullParameter(r106, "eventModule");
        String r107 = r106.getValue();
        r104.put("status", String.valueOf(r110));
        Intrinsics.checkNotNullParameter(r105, "map");
        Iterator<String> r108 = r102.keys();
    L4:
        if (r108.hasNext() == false) goto L6;
        String r111 = r108.next();
        Object r109 = r102.get(r111);
        Intrinsics.checkNotNullParameter(r111, "key");
        Intrinsics.checkNotNullParameter(r109, "value");
        r105.put(r111, r109);
        goto L4
    L6:
        cy0.e.f465759a.getClass();
        cy0.j r112 = cy0.e.a.f465760a;
        com.bytedance.android.scope.m.f163449e.getClass();
        Object r113 = com.bytedance.android.scope.m.b(r112).b(n97.a.class);
        Intrinsics.checkNotNull(r113);
        ((n97.a) ((com.bytedance.live.kmp.core.c) r113)).g(r101, r107, "bussiness_api_call", r103, r104, r105);
    }

    public final void k(long r100, long r101, Throwable r102, IBaseUser r103) {
        Intrinsics.checkNotNullParameter(r102, "error");
        Intrinsics.checkNotNullParameter(r103, "toUser");
        JSONObject r104 = new JSONObject();
        r(r104, "room_id", Long.valueOf(r101));
        r(r104, ILiveRoomPlayFragmentConstant.ENTER_LIVE_GITF_ID, Long.valueOf(r100));
        yz0.k r105 = (yz0.k) com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), yz0.k.class);
        if (r105 == null) goto L5;
        IRoom r106 = r105.getRoom();
    L6:
        if (r106 == null) goto L11;
        String r107 = r106.getAnchorId();
        if (r107 != null) goto L10;
        r107 = "";
    L10:
        r(r104, "anchor_id", r107);
    L11:
        r(r104, "to_anchor_id", r103.getIdString());
        r(r104, "error_code", Integer.valueOf(r0.a(r102)));
        r(r104, "error_msg", Arrays.toString(r102.getStackTrace()));
        h2 r108 = GiftManagerKt.l(r100);
        if (r108 != null) goto L14;
    L17:
        p("ttlive_gift_send_status", r104);
        return;
    L14:
        if (l0.e(r108) == false) goto L16;
        r(r104, "free_display", 1);
        goto L17
    L16:
        r(r104, "free_display", 0);
        goto L17
    L5:
        r106 = null;
        goto L6
    }

    public final void q(String r100, long r101, int r102, Throwable r103) {
        Intrinsics.checkNotNullParameter(r100, "giftIds");
        JSONObject r104 = new JSONObject();
        r(r104, "room_id", Long.valueOf(r101));
        r(r104, ILiveRoomPlayFragmentConstant.ENTER_LIVE_GITF_ID, r100);
        r(r104, "fetch_from", Integer.valueOf(r102));
        if (r103 == null) goto L5;
        r(r104, "error", String.valueOf(r103.getMessage()));
        n(this, com.bytedance.android.livesdk.gift.platform.core.utils.z.b("ttlive_gift_detail_status"), r104, 1);
        return;
    L5:
        n(this, com.bytedance.android.livesdk.gift.platform.core.utils.z.a("ttlive_gift_detail_status"), r104, 0);
    }

    public static void l(long r100, long r110, String r111, long r112, IBaseUser r113) {
        Intrinsics.checkNotNullParameter(r113, "toUser");
        JSONObject r101 = new JSONObject();
        r(r101, "room_id", Long.valueOf(r110));
        r(r101, ILiveRoomPlayFragmentConstant.ENTER_LIVE_GITF_ID, Long.valueOf(r100));
        String r114 = "";
        if (r111 != null) goto L5;
        r111 = "";
    L5:
        r(r101, "log_id", r111);
        yz0.k r115 = (yz0.k) com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), yz0.k.class);
        if (r115 == null) goto L8;
        IRoom r116 = r115.getRoom();
    L9:
        if (r116 == null) goto L15;
        String r117 = r116.getAnchorId();
        if (r117 == null) goto L14;
        r114 = r117;
    L14:
        r(r101, "anchor_id", r114);
    L15:
        r(r101, "to_anchor_id", r113.getIdString());
        h2 r102 = GiftManagerKt.l(r100);
        if (r102 != null) goto L18;
    L21:
        r(r101, "duration", Long.valueOf(r112));
        String r103 = com.bytedance.android.livesdk.gift.platform.core.utils.z.a("ttlive_gift_send_status");
        JSONObject r104 = new JSONObject();
        JSONObject r105 = new JSONObject();
        JSONObject r106 = new JSONObject();
        Intrinsics.checkNotNullParameter(r106, "extra");
        Intrinsics.checkNotNullParameter(r105, "metric");
        EventModule r107 = EventModule.LIVE_GIFT;
        Intrinsics.checkNotNullParameter(r107, "eventModule");
        String r108 = r107.getValue();
        r105.put("status", String.valueOf(0));
        Intrinsics.checkNotNullParameter(r106, "map");
        Iterator<String> r109 = r101.keys();
    L23:
        if (r109.hasNext() == false) goto L25;
        String r118 = r109.next();
        Object r119 = r101.get(r118);
        Intrinsics.checkNotNullParameter(r118, "key");
        Intrinsics.checkNotNullParameter(r119, "value");
        r106.put(r118, r119);
        goto L23
    L25:
        cy0.e.f465759a.getClass();
        cy0.j r120 = cy0.e.a.f465760a;
        com.bytedance.android.scope.m.f163449e.getClass();
        Object r121 = com.bytedance.android.scope.m.b(r120).b(n97.a.class);
        Intrinsics.checkNotNull(r121);
        ((n97.a) ((com.bytedance.live.kmp.core.c) r121)).g(r103, r108, "bussiness_api_call", r104, r105, r106);
        return;
    L18:
        if (l0.e(r102) == false) goto L20;
        r(r101, "free_display", 1);
        goto L21
    L20:
        r(r101, "free_display", 0);
        goto L21
    L8:
        r116 = null;
        goto L9
    }

    @JvmStatic
    public static final void s(long r110, int r111, String r112, boolean r113, boolean r114, boolean r115) {
        Intrinsics.checkNotNullParameter(r112, "msg");
        JSONObject r100 = new JSONObject();
        c0 r101 = f130474a;
        r(r100, "asset_id", Long.valueOf(r110));
        r(r100, "open_sr", Boolean.valueOf(r113));
        r(r100, "use_sr", Boolean.valueOf(r114));
        r(r100, "msg", r112);
        r(r100, "error_code", Integer.valueOf(r111));
        if (r115 == false) goto L9;
        String r102 = com.bytedance.android.livesdk.gift.platform.core.utils.z.a("ttlive_gift_open_sr_status");
        JSONObject r103 = new JSONObject();
        JSONObject r104 = new JSONObject();
        JSONObject r105 = new JSONObject();
        Intrinsics.checkNotNullParameter(r105, "extra");
        Intrinsics.checkNotNullParameter(r104, "metric");
        EventModule r106 = EventModule.LIVE_GIFT;
        Intrinsics.checkNotNullParameter(r106, "eventModule");
        String r107 = r106.getValue();
        r104.put("status", String.valueOf(0));
        Intrinsics.checkNotNullParameter(r105, "map");
        Iterator<String> r108 = r100.keys();
    L6:
        if (r108.hasNext() == false) goto L8;
        String r109 = r108.next();
        Object r116 = r100.get(r109);
        Intrinsics.checkNotNullParameter(r109, "key");
        Intrinsics.checkNotNullParameter(r116, "value");
        r105.put(r109, r116);
        goto L6
    L8:
        cy0.e.f465759a.getClass();
        cy0.j r117 = cy0.e.a.f465760a;
        com.bytedance.android.scope.m.f163449e.getClass();
        Object r118 = com.bytedance.android.scope.m.b(r117).b(n97.a.class);
        Intrinsics.checkNotNull(r118);
        ((n97.a) ((com.bytedance.live.kmp.core.c) r118)).g(r102, r107, "bussiness_api_call", r103, r104, r105);
        return;
    L9:
        r101.o("ttlive_gift_open_sr_status", r100);
    }

    public static void g(long r110, int r111, long r112, long r113, int r210, float r211, double r212, double r213, double r214, boolean r215, int r216, boolean r310) {
        JSONObject r100 = new JSONObject();
        r(r100, "room_id", Long.valueOf(r110));
        r(r100, ILiveRoomPlayFragmentConstant.ENTER_LIVE_GITF_ID, Long.valueOf(r112));
        r(r100, IPerformanceManager.Params.is_anchor, Integer.valueOf(r111));
        r(r100, "asset_id", Long.valueOf(r113));
        r(r100, "stay_room_duration", Integer.valueOf(r210));
        r(r100, IPerformanceStrategyManager.KEY_FLOAT_TEMPERATURE, Float.valueOf(r211));
        r(r100, "GPU", Double.valueOf(r213));
        r(r100, "CPU", Double.valueOf(r214));
        r(r100, "FPS", Double.valueOf(r212));
        r(r100, "video_asset_type", Integer.valueOf(r216));
        r(r100, "enable_sr", Boolean.valueOf(r310));
        if (r215 == false) goto L9;
        JSONObject r114 = new JSONObject();
        JSONObject r115 = new JSONObject();
        JSONObject r116 = new JSONObject();
        Intrinsics.checkNotNullParameter(r116, "extra");
        Intrinsics.checkNotNullParameter(r115, "metric");
        EventModule r101 = EventModule.LIVE_GIFT;
        Intrinsics.checkNotNullParameter(r101, "eventModule");
        String r102 = r101.getValue();
        r115.put("status", String.valueOf(0));
        Intrinsics.checkNotNullParameter(r116, "map");
        Iterator<String> r103 = r100.keys();
    L6:
        if (r103.hasNext() == false) goto L8;
        String r104 = r103.next();
        Object r105 = r100.get(r104);
        Intrinsics.checkNotNullParameter(r104, "key");
        Intrinsics.checkNotNullParameter(r105, "value");
        r116.put(r104, r105);
        goto L6
    L8:
        cy0.e.f465759a.getClass();
        cy0.j r106 = cy0.e.a.f465760a;
        com.bytedance.android.scope.m.f163449e.getClass();
        Object r107 = com.bytedance.android.scope.m.b(r106).b(n97.a.class);
        Intrinsics.checkNotNull(r107);
        ((n97.a) ((com.bytedance.live.kmp.core.c) r107)).g("ttlive_gift_effect_play_perf_status_post", r102, "bussiness_api_call", r114, r115, r116);
        return;
    L9:
        JSONObject r117 = new JSONObject();
        JSONObject r118 = new JSONObject();
        JSONObject r119 = new JSONObject();
        Intrinsics.checkNotNullParameter(r119, "extra");
        Intrinsics.checkNotNullParameter(r118, "metric");
        EventModule r108 = EventModule.LIVE_GIFT;
        Intrinsics.checkNotNullParameter(r108, "eventModule");
        String r109 = r108.getValue();
        r118.put("status", String.valueOf(0));
        Intrinsics.checkNotNullParameter(r119, "map");
        Iterator<String> r120 = r100.keys();
    L11:
        if (r120.hasNext() == false) goto L13;
        String r121 = r120.next();
        Object r122 = r100.get(r121);
        Intrinsics.checkNotNullParameter(r121, "key");
        Intrinsics.checkNotNullParameter(r122, "value");
        r119.put(r121, r122);
        goto L11
    L13:
        cy0.e.f465759a.getClass();
        cy0.j r123 = cy0.e.a.f465760a;
        com.bytedance.android.scope.m.f163449e.getClass();
        Object r124 = com.bytedance.android.scope.m.b(r123).b(n97.a.class);
        Intrinsics.checkNotNull(r124);
        ((n97.a) ((com.bytedance.live.kmp.core.c) r124)).g("ttlive_gift_effect_play_perf_status_during", r109, "bussiness_api_call", r117, r118, r119);
    }

    public static void b(boolean r110, long r210, String r211, int r212, String r213, int r214, String r215, String r216, Map r217, Map r218, boolean r310, boolean r311, boolean r312) {
        boolean r100 = d0.f130477a;
        if (r218 != null) goto L5;
        Map r101 = MapsKt.emptyMap();
    L6:
        d0.g(r101);
        LinkedHashMap r102 = new LinkedHashMap();
        if (r217 == null) goto L12;
        Iterator r103 = r217.entrySet().iterator();
    L10:
        if (r103.hasNext() == false) goto L12;
        Map.Entry r104 = (Map.Entry) r103.next();
        r102.put((String) r104.getKey(), r104.getValue());
    L12:
        String r105 = "";
        if (r211 != null) goto L15;
        String r106 = "";
    L16:
        r102.put("url", r106);
        if (r213 != null) goto L19;
        String r107 = "";
    L20:
        r102.put("error_msg", r107);
        r102.put("asset_show_extra", Integer.valueOf(r214));
        LinkedHashMap r108 = new LinkedHashMap();
        r108.put("error_code", Integer.valueOf(r212));
        if (r215 != null) goto L23;
        String r109 = "";
    L24:
        r108.put("gift_player_type", r109);
        String r111 = "1";
        if (r310 == false) goto L27;
        Object r112 = "1";
    L28:
        r108.put(IPerformanceManager.Params.is_anchor, r112);
        if (r311 == false) goto L31;
        Object r113 = "1";
    L32:
        r108.put("is_gift_receiver", r113);
        if (r312 == true) goto L36;
        r111 = "0";
    L36:
        r108.put("is_gift_sender", r111);
        LinkedHashMap r114 = new LinkedHashMap();
        r114.put("asset_id", Long.valueOf(r210));
        if (r216 == null) goto L40;
        r105 = r216;
    L40:
        r114.put("log_id", r105);
        if (TextUtils.equals("TTGiftPlayerImpl", r215) == false) goto L43;
    L44:
        r114.put("gift_ttplayer_hardcore", Integer.valueOf(com.bytedance.android.livesdk.gift.platform.business.effect.a.h()));
    L45:
        String r115 = com.bytedance.android.livesdk.gift.platform.core.utils.z.a("ttlive_gift_asset_show_status");
        JSONObject r116 = new JSONObject();
        JSONObject r117 = new JSONObject();
        JSONObject r118 = new JSONObject();
        Intrinsics.checkNotNullParameter(r118, "extra");
        Intrinsics.checkNotNullParameter(r117, "metric");
        EventModule r119 = EventModule.LIVE_GIFT;
        String r120 = "eventModule";
        Intrinsics.checkNotNullParameter(r119, "eventModule");
        String r121 = r119.getValue();
        String r122 = "status";
        if (r110 == false) goto L48;
        r117.put("status", String.valueOf(0));
    L49:
        Intrinsics.checkNotNullParameter(r116, "map");
        Iterator r123 = r108.entrySet().iterator();
    L50:
        LinkedHashMap r219 = r108;
        if (r123.hasNext() == false) goto L53;
        Map.Entry r124 = (Map.Entry) r123.next();
        String r220 = r122;
        String r125 = (String) r124.getKey();
        String r313 = r120;
        Object r126 = r124.getValue();
        Intrinsics.checkNotNullParameter(r125, "key");
        Intrinsics.checkNotNullParameter(r126, "value");
        r116.put(r125, r126);
        r108 = r219;
        r122 = r220;
        r120 = r313;
        goto L50
    L53:
        String r314 = r120;
        String r221 = r122;
        Intrinsics.checkNotNullParameter(r117, "map");
        Iterator r127 = r114.entrySet().iterator();
    L55:
        if (r127.hasNext() == false) goto L57;
        Map.Entry r128 = (Map.Entry) r127.next();
        Iterator r222 = r127;
        String r129 = (String) r128.getKey();
        Object r130 = r128.getValue();
        Intrinsics.checkNotNullParameter(r129, "key");
        Intrinsics.checkNotNullParameter(r130, "value");
        r117.put(r129, r130);
        r127 = r222;
        goto L55
    L57:
        Intrinsics.checkNotNullParameter(r118, "map");
        Iterator r131 = r102.entrySet().iterator();
    L59:
        if (r131.hasNext() == false) goto L61;
        Map.Entry r132 = (Map.Entry) r131.next();
        Iterator r223 = r131;
        String r133 = (String) r132.getKey();
        Object r134 = r132.getValue();
        Intrinsics.checkNotNullParameter(r133, "key");
        Intrinsics.checkNotNullParameter(r134, "value");
        r118.put(r133, r134);
        r131 = r223;
        goto L59
    L61:
        cy0.e.f465759a.getClass();
        cy0.j r135 = cy0.e.a.f465760a;
        com.bytedance.android.scope.m.f163449e.getClass();
        Object r136 = com.bytedance.android.scope.m.b(r135).b(n97.a.class);
        Intrinsics.checkNotNull(r136);
        ((n97.a) ((com.bytedance.live.kmp.core.c) r136)).g(r115, r121, "bussiness_api_call", r116, r117, r118);
        if (r110 == true) goto L84;
        String r137 = com.bytedance.android.livesdk.gift.platform.core.utils.z.b("ttlive_gift_asset_show_status");
        JSONObject r138 = new JSONObject();
        JSONObject r139 = new JSONObject();
        JSONObject r140 = new JSONObject();
        Intrinsics.checkNotNullParameter(r140, "extra");
        Intrinsics.checkNotNullParameter(r139, "metric");
        EventModule r141 = EventModule.LIVE_GIFT;
        Intrinsics.checkNotNullParameter(r141, r314);
        String r142 = r141.getValue();
        r139.put(r221, String.valueOf(1));
        Intrinsics.checkNotNullParameter(r138, "map");
        Iterator r143 = r219.entrySet().iterator();
    L65:
        if (r143.hasNext() == false) goto L67;
        Map.Entry r144 = (Map.Entry) r143.next();
        String r145 = (String) r144.getKey();
        Object r146 = r144.getValue();
        Intrinsics.checkNotNullParameter(r145, "key");
        Intrinsics.checkNotNullParameter(r146, "value");
        r138.put(r145, r146);
        goto L65
    L67:
        Intrinsics.checkNotNullParameter(r139, "map");
        Iterator r147 = r114.entrySet().iterator();
    L69:
        if (r147.hasNext() == false) goto L71;
        Map.Entry r148 = (Map.Entry) r147.next();
        String r149 = (String) r148.getKey();
        Object r150 = r148.getValue();
        Intrinsics.checkNotNullParameter(r149, "key");
        Intrinsics.checkNotNullParameter(r150, "value");
        r139.put(r149, r150);
        goto L69
    L71:
        Intrinsics.checkNotNullParameter(r140, "map");
        Iterator r151 = r102.entrySet().iterator();
    L73:
        if (r151.hasNext() == false) goto L75;
        Map.Entry r152 = (Map.Entry) r151.next();
        String r153 = (String) r152.getKey();
        Object r154 = r152.getValue();
        Intrinsics.checkNotNullParameter(r153, "key");
        Intrinsics.checkNotNullParameter(r154, "value");
        r140.put(r153, r154);
        goto L73
    L75:
        cy0.e.f465759a.getClass();
        cy0.j r155 = cy0.e.a.f465760a;
        com.bytedance.android.scope.m.f163449e.getClass();
        Object r156 = com.bytedance.android.scope.m.b(r155).b(n97.a.class);
        Intrinsics.checkNotNull(r156);
        ((n97.a) ((com.bytedance.live.kmp.core.c) r156)).g(r137, r142, "bussiness_api_call", r138, r139, r140);
        return;
    L84:
        return;
    L48:
        r117.put("status", String.valueOf(1));
        goto L49
    L43:
        if (TextUtils.equals("TTEnginePlayerImpl", r215) == false) goto L45;
    L31:
        r113 = "0";
        goto L32
    L27:
        r112 = "0";
        goto L28
    L23:
        r109 = r215;
        goto L24
    L19:
        r107 = r213;
        goto L20
    L15:
        r106 = r211;
        goto L16
    L5:
        r101 = r218;
        goto L6
    }
}
