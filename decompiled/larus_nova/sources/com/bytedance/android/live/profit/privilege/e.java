package com.bytedance.android.live.profit.privilege;

import com.bytedance.android.live.profit.dress.api.OpenAssetPlayErrorType;
import com.bytedance.android.livesdk.revenue.monitor.EventModule;
import com.bytedance.android.scope.m;
import cy0.j;
import java.util.Iterator;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import zt0.f;

/* JADX INFO: loaded from: classes47.dex */
public final class e implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f88414a = null;

    public e() {
    }

    static {
        f88414a = new e();
    }

    public static JSONObject n(Long r100) {
        return s(new Pair[]{TuplesKt.to("duration", r100)});
    }

    public static JSONObject s(Pair... r100) {
        JSONObject r101 = new JSONObject();
        int r102 = r100.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L5;
        Pair r104 = r100[r103];
        r101.put((String) r104.getFirst(), r104.getSecond());
        r103 = r103 + 1;
        goto L3
    L5:
        return r101;
    }

    public static JSONObject l(Long r100, String r101) {
        JSONObject r102 = new JSONObject();
        if (r100 == null) goto L5;
        t(r102, "room_id", Long.valueOf(r100.longValue()));
    L5:
        if (r101 == null) goto L7;
        t(r102, "anchor_id", r101);
    L7:
        return r102;
    }

    public static void o(JSONObject r100, JSONObject r101) {
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L8
        Iterator<String> r103 = r101.keys();     // Catch: Throwable -> L8
    L4:
        if (r103.hasNext() == false) goto L6;
        String r104 = r103.next();     // Catch: Throwable -> L8
        r100.put(r104, r101.get(r104));     // Catch: Throwable -> L8
        goto L4
    L6:
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }

    @Override // zt0.f
    public final void b(String r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "dressId");
        JSONObject r102 = s(new Pair[]{TuplesKt.to("dress_id", r100), TuplesKt.to("asset_id", Long.valueOf(r101))});
        JSONObject r103 = k(true, null, null);
        o(r103, r102);
        p("ttlive_open_asset_play_status", r103, null, r102);
    }

    public static JSONObject k(boolean r100, String r101, Integer r102) {
        JSONObject r103 = new JSONObject();
        if (r100 == false) goto L5;
        int r104 = 0;
    L6:
        t(r103, "status", Integer.valueOf(r104));
        t(r103, "error_msg", r101);
        t(r103, "error_code", r102);
        return r103;
    L5:
        r104 = -1;
        goto L6
    }

    public static /* synthetic */ JSONObject m(e r100, Long r101, int r102) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        r100.getClass();
        return l(r101, null);
    }

    public static void t(JSONObject r100, String r101, Object r102) {
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L7
        if (r102 == null) goto L5;
        r100.put(r101, r102);     // Catch: Throwable -> L7
    L5:
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        Result.Companion r104 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }

    @Override // zt0.f
    public final void c(JSONObject r100, JSONObject r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "category");
        Intrinsics.checkNotNullParameter(r101, "metrics");
        Intrinsics.checkNotNullParameter(r102, "userId");
        JSONObject r103 = new JSONObject();
        t(r103, "msg_id", r102);
        p("ttlive_enter_anim_resource_load_status", r100, r101, r103);
    }

    @Override // zt0.f
    public final void h(String r100, int r101, long r102) {
        Intrinsics.checkNotNullParameter(r100, "userId");
        JSONObject r103 = k(true, null, null);
        JSONObject r104 = n(Long.valueOf(r102));
        JSONObject r105 = m(this, null, 6);
        t(r105, "emoji_size", Integer.valueOf(r101));
        p("ttlive_subscribe_emoji_add_all", r103, r104, r105);
    }

    @Override // zt0.f
    public final void j(JSONObject r100, JSONObject r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "category");
        Intrinsics.checkNotNullParameter(r101, "metrics");
        Intrinsics.checkNotNullParameter(r102, "userId");
        JSONObject r103 = new JSONObject();
        t(r103, "msg_id", r102);
        p("ttlive_enter_anim_show_time", r100, r101, r103);
    }

    public static void p(String r110, JSONObject r111, JSONObject r112, JSONObject r113) {
        JSONObject r100 = new JSONObject();
        JSONObject r101 = new JSONObject();
        JSONObject r102 = new JSONObject();
        Intrinsics.checkNotNullParameter(r102, "extra");
        Intrinsics.checkNotNullParameter(r101, "metric");
        EventModule r103 = EventModule.DRESS;
        Intrinsics.checkNotNullParameter(r103, "eventModule");
        String r104 = r103.getValue();
        Intrinsics.checkNotNullParameter(r100, "map");
        Iterator<String> r105 = r111.keys();
        if (r105 != null) goto L5;
    L12:
        Intrinsics.checkNotNullParameter(r101, "map");
        if (r112 == null) goto L24;
        Iterator<String> r114 = r112.keys();
        if (r114 == null) goto L24;
    L17:
        if (r114.hasNext() == false) goto L24;
        String r106 = r114.next();
        Object r115 = r112.opt(r106);
        if (r115 == null) goto L22;
        String r116 = r115.toString();
        if (r116 == null) goto L22;
    L23:
        Intrinsics.checkNotNullParameter(r106, "key");
        Intrinsics.checkNotNullParameter(r116, "value");
        r101.put(r106, r116);
    L22:
        r116 = "";
    L24:
        Intrinsics.checkNotNullParameter(r102, "map");
        Iterator<String> r117 = r113.keys();
        if (r117 != null) goto L27;
    L34:
        cy0.e.f465759a.getClass();
        j r118 = cy0.e.a.f465760a;
        m.f163449e.getClass();
        Object r119 = m.b(r118).b(n97.a.class);
        Intrinsics.checkNotNull(r119);
        ((n97.a) ((com.bytedance.live.kmp.core.c) r119)).g(r110, r104, "bussiness_api_call", r100, r101, r102);
        return;
    L27:
        if (r117.hasNext() == false) goto L34;
        String r120 = r117.next();
        Object r107 = r113.opt(r120);
        if (r107 == null) goto L32;
        String r108 = r107.toString();
        if (r108 == null) goto L32;
    L33:
        Intrinsics.checkNotNullParameter(r120, "key");
        Intrinsics.checkNotNullParameter(r108, "value");
        r102.put(r120, r108);
    L32:
        r108 = "";
    L5:
        if (r105.hasNext() == false) goto L12;
        String r121 = r105.next();
        Object r122 = r111.opt(r121);
        if (r122 == null) goto L10;
        String r123 = r122.toString();
        if (r123 == null) goto L10;
    L11:
        Intrinsics.checkNotNullParameter(r121, "key");
        Intrinsics.checkNotNullParameter(r123, "value");
        r100.put(r121, r123);
    L10:
        r123 = "";
        goto L11
    }

    @Override // zt0.f
    public final void d(String r100, long r101, long r102, long r103) {
        Intrinsics.checkNotNullParameter(r100, "userId");
        JSONObject r104 = k(true, null, null);
        JSONObject r105 = n(Long.valueOf(r103));
        JSONObject r106 = m(this, Long.valueOf(r101), 4);
        t(r106, "emoji_id", Long.valueOf(r102));
        p("ttlive_subscribe_send_emoji_all", r104, r105, r106);
    }

    @Override // zt0.f
    public final void e(String r100, long r101, OpenAssetPlayErrorType r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "dressId");
        Intrinsics.checkNotNullParameter(r102, "errorType");
        Intrinsics.checkNotNullParameter(r103, "reason");
        JSONObject r104 = s(new Pair[]{TuplesKt.to("dress_id", r100), TuplesKt.to("asset_id", Long.valueOf(r101))});
        JSONObject r105 = k(false, r103, Integer.valueOf(r102.getValue()));
        o(r105, r104);
        p("ttlive_open_asset_play_status_error", r105, null, r104);
        p("ttlive_open_asset_play_status", r105, null, r104);
    }

    @Override // zt0.f
    public final void g(String r100, int r101, String r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, "userId");
        Intrinsics.checkNotNullParameter(r102, "errorMsg");
        JSONObject r104 = k(false, r102, Integer.valueOf(r103));
        JSONObject r105 = n(null);
        JSONObject r106 = m(this, null, 6);
        t(r106, "emoji_size", Integer.valueOf(r101));
        p("ttlive_subscribe_emoji_add_all", r104, r105, r106);
    }

    @Override // zt0.f
    public final void i(String r100, long r101, long r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, "userId");
        JSONObject r104 = k(true, null, null);
        JSONObject r105 = n(Long.valueOf(r102));
        JSONObject r106 = m(this, Long.valueOf(r101), 4);
        t(r106, "style", Integer.valueOf(r103));
        p("ttlive_privilege_danmaku_send_status_all", r104, r105, r106);
    }

    @Override // zt0.f
    public final void a(String r100, long r101, long r102, String r103, int r104) {
        Intrinsics.checkNotNullParameter(r100, "userId");
        Intrinsics.checkNotNullParameter(r103, "errorMsg");
        JSONObject r105 = k(false, r103, Integer.valueOf(r104));
        JSONObject r106 = n(null);
        JSONObject r107 = m(this, Long.valueOf(r101), 4);
        t(r107, "emoji_id", Long.valueOf(r102));
        p("ttlive_subscribe_send_emoji_all", r105, r106, r107);
    }

    @Override // zt0.f
    public final void f(String r100, long r101, int r102, String r103, int r104) {
        Intrinsics.checkNotNullParameter(r100, "userId");
        Intrinsics.checkNotNullParameter(r103, "errorMsg");
        JSONObject r105 = k(false, r103, Integer.valueOf(r104));
        JSONObject r106 = n(null);
        JSONObject r107 = m(this, Long.valueOf(r101), 4);
        t(r107, "style", Integer.valueOf(r102));
        p("ttlive_privilege_danmaku_send_status_all", r105, r106, r107);
    }

    public final void r(String r100, String r101, long r102, long r103, boolean r104) {
        Intrinsics.checkNotNullParameter(r100, "userId");
        Intrinsics.checkNotNullParameter(r101, "anchorId");
        JSONObject r105 = k(true, null, null);
        JSONObject r106 = n(Long.valueOf(r103));
        JSONObject r107 = l(Long.valueOf(r102), r101);
        t(r107, "is_vs", Integer.valueOf(r104 ? 1 : 0));
        p("ttlive_fansclub_me_status_all", r105, r106, r107);
    }

    public static void q(String r100, String r101, long r102, String r103, int r104, boolean r105) {
        Intrinsics.checkNotNullParameter(r100, "userId");
        Intrinsics.checkNotNullParameter(r101, "anchorId");
        Intrinsics.checkNotNullParameter(r103, "errorMsg");
        JSONObject r106 = k(false, r103, Integer.valueOf(r104));
        JSONObject r107 = n(null);
        JSONObject r108 = l(Long.valueOf(r102), r101);
        t(r108, "is_vs", Integer.valueOf(r105 ? 1 : 0));
        p("ttlive_fansclub_me_status_all", r106, r107, r108);
        p("ttlive_fansclub_me_status_error", r106, r107, r108);
    }
}
