package com.bytedance.android.livesdk.livecommerce.opt;

import android.os.SystemClock;
import android.view.Choreographer;
import android.view.View;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.BtmItemBuilder;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.adapter.api.IAdapterService;
import com.bytedance.android.ec.core.monitor.MetricNames;
import com.bytedance.android.ec.core.monitor.MonitorScenes;
import com.bytedance.android.ec.core.monitor.n;
import com.bytedance.android.ec.monitor.duration.h;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.livesdk.livecommerce.event.g1;
import com.bytedance.android.livesdk.livecommerce.event.l0;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.RoomContextController;
import com.bytedance.android.livesdk.livecommerce.room.store.ECContext;
import com.bytedance.android.livesdk.livecommerce.room.widgets.shoppingcart.ECToolbarHandler;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.bytedance.live.datacontext.i;
import com.bytedance.live.datacontext.m;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.downloadlib.constants.ComplianceConstants;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class ECLivePerformanceMonitor {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final b f149745x = null;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final a f149746y = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f149747a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f149748b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Long f149749c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f149750d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f149751e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f149752f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f149753g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f149754h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f149755i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f149756j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f149757k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f149758l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f149759m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f149760n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f149761o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public String f149762p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f149763q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public String f149764r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public String f149765s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public Long f149766t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public Long f149767u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Map<String, String> f149768v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Map<String, g1> f149769w;

    public static final class a implements n {
        public a() {
        }

        @Override // com.bytedance.android.ec.core.monitor.n
        public final Long b(Map<String, Long> r100) {
            Intrinsics.checkNotNullParameter(r100, "durationOfMetrics");
            return null;
        }

        @Override // com.bytedance.android.ec.core.monitor.n
        public final void a(Map<String, Long> r100) {
            Intrinsics.checkNotNullParameter(r100, "durationOfMetrics");
            Lazy r101 = ECToolbarHandler.f152739a;
            boolean r102 = ECToolbarHandler.f152741c;
            ECToolbarHandler.f152741c = false;
            if (r102 == false) goto L6;
            r100.put(MetricNames.DURATION.getMetricNames(), 1L);
            return;
        }
    }

    public static final class b implements n {
        public b() {
        }

        @Override // com.bytedance.android.ec.core.monitor.n
        public final Long b(Map<String, Long> r100) {
            Intrinsics.checkNotNullParameter(r100, "durationOfMetrics");
            return null;
        }

        @Override // com.bytedance.android.ec.core.monitor.n
        public final void a(Map<String, Long> r100) {
            Intrinsics.checkNotNullParameter(r100, "durationOfMetrics");
            Intrinsics.checkNotNullParameter(r100, "durationOfMetrics");
        }
    }

    public static final class c {
        @JvmStatic
        public static ECLivePerformanceMonitor a(String r100, String r101) {
            int r102 = RoomContextController.f151593h;
            ECContext r103 = RoomContextController.a.b(r100, r101).r();
            if (r103 == null) goto L7;
            i<ECLivePerformanceMonitor> r104 = r103.getEcLivePerformanceMonitor();
            if (r104 == null) goto L7;
            return r104.getValue();
        L7:
            return null;
        }
    }

    public static final class d<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ECLivePerformanceMonitor f149770a;

        public d(ECLivePerformanceMonitor r100) {
            this.f149770a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            this.f149770a.p(2, ((Boolean) r100).booleanValue());
        }
    }

    public static final class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f149771a;

        public e(String r100) {
            this.f149771a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Map<String, com.bytedance.android.ec.core.monitor.a> r100 = com.bytedance.android.ec.core.monitor.c.f45142a;     // Catch: Throwable -> L4
            com.bytedance.android.ec.core.monitor.c.d(this.f149771a);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
        f149745x = new b();
        f149746y = new a();
    }

    public final void e() {
        int r100 = ECSdk.f48106a;
        ECSdk.b(IAdapterService.class, new ECLivePerformanceMonitor$initBasicInfo$1(this));
        int r101 = RoomContextController.f151593h;
        ECContext r102 = RoomContextController.a.b(this.f149747a, this.f149748b).r();
        if (r102 == null) goto L10;
        m<Boolean> r103 = r102.isBottomCardVisible();
        if (r103 == null) goto L11;
        Observable<Boolean> r104 = r103.a();
        if (r104 == null) goto L12;
        r104.subscribe(new d(this));
        return;
    L12:
        return;
    L11:
        return;
    }

    public final void g() {
        String r100 = this.f149762p;
        if (r100 == null) goto L6;
        Map<String, com.bytedance.android.ec.core.monitor.a> r101 = com.bytedance.android.ec.core.monitor.c.f45142a;
        com.bytedance.android.ec.core.monitor.c.j(r100, MetricNames.POP_CARD_ANIM_DELAY_DURATION);
        com.bytedance.android.ec.core.monitor.c.h(r100, MetricNames.POP_CARD_ANIM_DURATION, null);
        return;
    }

    public final void h() {
        v("ec_perf_duration_shopping_card", CollectionsKt.listOf(new String[]{"enter_room_end", "enter_ec_room_end"}), Long.valueOf(SystemClock.elapsedRealtime()));
        v("ec_perf_duration_shopping_related_card", CollectionsKt.listOf(new String[]{"enter_room_end", "enter_ec_room_end"}), Long.valueOf(SystemClock.elapsedRealtime()));
        v("ec_perf_duration_intro_card", CollectionsKt.listOf(new String[]{"enter_room_end", "enter_ec_room_end"}), Long.valueOf(SystemClock.elapsedRealtime()));
        String r100 = this.f149762p;
        if (r100 == null) goto L6;
        Map<String, com.bytedance.android.ec.core.monitor.a> r101 = com.bytedance.android.ec.core.monitor.c.f45142a;
        com.bytedance.android.ec.core.monitor.c.j(r100, MetricNames.ENTER_ROOM_DURATION);
        return;
    }

    public final void j() {
        final String r100 = this.f149761o;
        if (r100 == null) goto L6;
        v("ec_perf_duration_live_shopping_bag", CollectionsKt.listOf(new String[]{"enter_room_end", "enter_ec_room_end", "real_render_start", "render_start"}), Long.valueOf(SystemClock.elapsedRealtime()));
        Map<String, com.bytedance.android.ec.core.monitor.a> r101 = com.bytedance.android.ec.core.monitor.c.f45142a;
        com.bytedance.android.ec.core.monitor.c.j(r100, MetricNames.ENTER_ROOM_DURATION);
        com.bytedance.android.ec.core.monitor.c.h(r100, MetricNames.RENDER_DURATION, null);
        com.bytedance.android.ec.core.monitor.c.h(r100, MetricNames.LIVE_CART_REAL_RENDER_DURATION, null);
        com.bytedance.android.ec.core.monitor.c.h(r100, MetricNames.LIVE_CART_NEXT_FRAME_RENDER_DURATION, null);
        int r102 = ECSdk.f48106a;
        ECSdk.b(IAdapterService.class, new ECLivePerformanceMonitor$onCartEnterRoom$$inlined$let$lambda$1(r100, this));
        return;
    }

    public final void k() {
        v("ec_perf_duration_live_shopping_bag", CollectionsKt.listOf(new String[]{"real_end", "real_render_end"}), Long.valueOf(SystemClock.elapsedRealtime()));
        String r100 = this.f149761o;
        if (r100 == null) goto L5;
        Map<String, com.bytedance.android.ec.core.monitor.a> r101 = com.bytedance.android.ec.core.monitor.c.f45142a;
        com.bytedance.android.ec.core.monitor.c.j(r100, MetricNames.LIVE_CART_REAL_SHOW_DURATION);
        com.bytedance.android.ec.core.monitor.c.j(r100, MetricNames.LIVE_CART_REAL_RENDER_DURATION);
    L5:
        Function0<Unit> r102 = new ECLivePerformanceMonitor$recordNextFrameDuration$1(this);
        Choreographer.getInstance().postFrameCallback(new com.bytedance.android.livesdk.livecommerce.opt.a(r102));
    }

    public ECLivePerformanceMonitor() {
        this.f149751e = "";
        this.f149752f = "";
        this.f149768v = new LinkedHashMap();
        this.f149769w = new LinkedHashMap();
    }

    public final void i() {
        u("ec_perf_duration_shopping_card", "request_end", Long.valueOf(SystemClock.elapsedRealtime()));
        String r100 = this.f149762p;
        if (r100 == null) goto L6;
        Map<String, com.bytedance.android.ec.core.monitor.a> r101 = com.bytedance.android.ec.core.monitor.c.f45142a;
        com.bytedance.android.ec.core.monitor.c.j(r100, MetricNames.POP_API_DURATION);
        return;
    }

    public final void l() {
        u("ec_perf_duration_intro_card", "request_end", Long.valueOf(SystemClock.elapsedRealtime()));
        String r100 = this.f149762p;
        if (r100 == null) goto L6;
        Map<String, com.bytedance.android.ec.core.monitor.a> r101 = com.bytedance.android.ec.core.monitor.c.f45142a;
        com.bytedance.android.ec.core.monitor.c.j(r100, MetricNames.POP_API_DURATION);
        return;
    }

    public final void B(boolean r100) {
        String r101 = "1";
        if (r100 == false) goto L5;
        String r102 = "1";
    L6:
        b("ec_perf_duration_shopping_card", "is_preload_ready", r102);
        String r103 = this.f149762p;
        if (r103 == null) goto L14;
        Map<String, com.bytedance.android.ec.core.monitor.a> r104 = com.bytedance.android.ec.core.monitor.c.f45142a;
        if (r100 == true) goto L12;
        r101 = "0";
    L12:
        com.bytedance.android.ec.core.monitor.c.e(r103, "is_preload_ready", r101);
        return;
    L14:
        return;
    L5:
        r102 = "0";
        goto L6
    }

    public final void C(boolean r100) {
        String r101 = "1";
        if (r100 == false) goto L5;
        String r102 = "1";
    L6:
        b("ec_perf_duration_intro_card", "is_preload_ready", r102);
        String r103 = this.f149762p;
        if (r103 == null) goto L14;
        Map<String, com.bytedance.android.ec.core.monitor.a> r104 = com.bytedance.android.ec.core.monitor.c.f45142a;
        if (r100 == true) goto L12;
        r101 = "0";
    L12:
        com.bytedance.android.ec.core.monitor.c.e(r103, "is_preload_ready", r101);
        return;
    L14:
        return;
    L5:
        r102 = "0";
        goto L6
    }

    public final void n(boolean r100) {
        u("ec_perf_duration_promotion_list", "request_start", null);
        if (r100 == false) goto L5;
        String r101 = "1";
    L6:
        b("ec_perf_duration_promotion_list", "is_request_on_show_fragment", r101);
        String r102 = this.f149764r;
        if (r102 == null) goto L10;
        Map<String, com.bytedance.android.ec.core.monitor.a> r103 = com.bytedance.android.ec.core.monitor.c.f45142a;
        com.bytedance.android.ec.core.monitor.c.h(r102, MetricNames.LIVE_PROMOTIONS_API_DURATION, null);
        return;
    L10:
        return;
    L5:
        r101 = "0";
        goto L6
    }

    public final void o(String r100) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        String r101 = this.f149765s;
        if (r101 == null) goto L6;
        Map<String, com.bytedance.android.ec.core.monitor.a> r102 = com.bytedance.android.ec.core.monitor.c.f45142a;
        com.bytedance.android.ec.core.monitor.c.j(r101, MetricNames.DURATION);
        com.bytedance.android.ec.core.monitor.c.e(r101, "scene", r100);
        com.bytedance.android.ec.core.monitor.c.d(r101);
        return;
    }

    public final void q(String r100) {
        Intrinsics.checkNotNullParameter(r100, "roomId");
        Map<String, com.bytedance.android.ec.core.monitor.a> r101 = com.bytedance.android.ec.core.monitor.c.f45142a;
        String r102 = com.bytedance.android.ec.core.monitor.c.c(MonitorScenes.DURATION_LIVE_EC_ROOM_ENTER_AUTO_POP, null);
        this.f149765s = r102;
        com.bytedance.android.ec.core.monitor.c.e(r102, "room_id", r100);
        String r103 = this.f149760n;
        if (r103 != null) goto L5;
        r103 = "";
    L5:
        com.bytedance.android.ec.core.monitor.c.e(r102, "enter_room_type", r103);
        com.bytedance.android.ec.core.monitor.c.h(r102, MetricNames.DURATION, this.f149749c);
        com.bytedance.android.ec.core.monitor.c.h(r102, MetricNames.ENTER_ROOM_DURATION, this.f149749c);
        com.bytedance.android.ec.core.monitor.c.e(r102, "room_id", r100);
        com.bytedance.android.ec.core.monitor.c.e(r102, "enter_from_merge", l0.d());
        com.bytedance.android.ec.core.monitor.c.e(r102, "enter_method", l0.e());
    }

    public final void z(int r100) {
        if (r100 == 2) goto L5;
        String r101 = null;
    L6:
        w(this, "ec_perf_duration_intro_card", null, r101, 2);
        String r102 = this.f149762p;
        if (r102 == null) goto L9;
        UtilityKotlinExtentionsKt.f153057b.post(new e(r102));
    L9:
        this.f149762p = null;
        return;
    L5:
        r101 = "ec_perf_duration_intro_related_card";
        goto L6
    }

    public final void c(Long r100, Long r101) {
        if (r100 == null) goto L9;
        r100.longValue();
        if (r101 == null) goto L10;
        r101.longValue();
        u("ec_perf_duration_shopping_card", "request_start", r100);
        u("ec_perf_duration_shopping_card", "request_end", r101);
        String r102 = this.f149762p;
        if (r102 == null) goto L11;
        Map<String, com.bytedance.android.ec.core.monitor.a> r103 = com.bytedance.android.ec.core.monitor.c.f45142a;
        com.bytedance.android.ec.core.monitor.c.a(r102, MetricNames.POP_API_DURATION, r101.longValue() - r100.longValue());
        return;
    L11:
        return;
    L10:
        return;
    }

    public final String d(String r100, boolean r101) {
        if (r101 == true) goto L9;
        Map<String, String> r102 = this.f149768v;
        String r103 = (String) ((LinkedHashMap) r102).get(r100);
        if (r103 != null) goto L7;
        r103 = com.bytedance.android.ec.monitor.duration.i.f47987a.create(r100);
    L7:
        r102.put(r100, r103);
        return (String) ((LinkedHashMap) this.f149768v).get(r100);
    L9:
        return (String) ((LinkedHashMap) this.f149768v).get(r100);
    }

    public final void f(Long r100, Long r101) {
        if (r100 == null) goto L9;
        r100.longValue();
        if (r101 == null) goto L10;
        r101.longValue();
        u("ec_perf_duration_intro_card", "request_start", r100);
        u("ec_perf_duration_intro_card", "request_end", r101);
        String r102 = this.f149762p;
        if (r102 == null) goto L11;
        Map<String, com.bytedance.android.ec.core.monitor.a> r103 = com.bytedance.android.ec.core.monitor.c.f45142a;
        com.bytedance.android.ec.core.monitor.c.a(r102, MetricNames.POP_API_DURATION, r101.longValue() - r100.longValue());
        return;
    L11:
        return;
    L10:
        return;
    }

    public final void p(int r100, boolean r101) {
        if (r100 != 0) goto L4;
        this.f149754h = r101;
    L20:
        LinkedHashMap r102 = new LinkedHashMap();
        String r103 = "1";
        if (this.f149754h == false) goto L23;
        Object r104 = "1";
    L24:
        r102.put("is_shopping", r104);
        if (this.f149755i == false) goto L27;
        Object r105 = "1";
    L28:
        r102.put("shopping_list_show", r105);
        if (this.f149756j == false) goto L31;
        Object r106 = "1";
    L32:
        r102.put("shopping_card_show", r106);
        if (this.f149759m == false) goto L35;
        Object r107 = "1";
    L36:
        r102.put("shopping_detail_show", r107);
        if (this.f149758l == false) goto L39;
        Object r108 = "1";
    L40:
        r102.put("shopping_preload_view", r108);
        if (this.f149757k == true) goto L44;
        r103 = "0";
    L44:
        r102.put("shopping_preload_data", r103);
        if (this.f149754h == false) goto L49;
        int r109 = ECSdk.f48106a;
        IAdapterService r110 = (IAdapterService) ECSdk.a(IAdapterService.class);
        if (r110 == null) goto L53;
        r110.getLivePerformanceManager();
        return;
    L53:
        return;
    L49:
        int r111 = ECSdk.f48106a;
        IAdapterService r112 = (IAdapterService) ECSdk.a(IAdapterService.class);
        if (r112 == null) goto L55;
        r112.getLivePerformanceManager();
        return;
    L55:
        return;
    L39:
        r108 = "0";
        goto L40
    L35:
        r107 = "0";
        goto L36
    L31:
        r106 = "0";
        goto L32
    L27:
        r105 = "0";
        goto L28
    L23:
        r104 = "0";
        goto L24
    L4:
        if (r100 != 1) goto L6;
        this.f149755i = r101;
        goto L20
    L6:
        if (r100 != 2) goto L8;
        this.f149756j = r101;
        goto L20
    L8:
        if (r100 != 3) goto L10;
        this.f149759m = r101;
        goto L20
    L10:
        if (r100 != 4) goto L12;
        this.f149757k = r101;
        goto L20
    L12:
        if (r100 != 5) goto L20;
        this.f149758l = r101;
        goto L20
    }

    public final void t(boolean r100, int r101) {
        String r102 = this.f149760n;
        if (r102 != null) goto L5;
        r102 = "";
    L5:
        b("ec_perf_duration_shopping_related_card", "enter_room_type", r102);
        b("ec_perf_duration_shopping_related_card", "enter_from_merge", l0.d());
        b("ec_perf_duration_shopping_related_card", "enter_method", l0.e());
        b("ec_perf_duration_shopping_related_card", "instant_type", String.valueOf(r101));
        if (r100 == false) goto L8;
        String r103 = "message";
    L9:
        b("ec_perf_duration_shopping_related_card", "scene", r103);
        if (r100 == false) goto L12;
        u("ec_perf_duration_shopping_related_card", "initial", Long.valueOf(SystemClock.elapsedRealtime()));
        return;
    L12:
        v("ec_perf_duration_shopping_related_card", CollectionsKt.listOf(new String[]{"initial", "enter_room_start", "enter_ec_room_start", "card_visible_start", "main_image_visible_start"}), this.f149749c);
        return;
    L8:
        r103 = "enter_room";
        goto L9
    }

    public static /* synthetic */ void y(ECLivePerformanceMonitor r100, Boolean r101, gf.a r102) {
        r100.x(true, r101, r102, null, null);
    }

    public final void b(String r100, String r101, String r102) {
        String r103 = d(r100, false);
        if (r103 == null) goto L9;
        if (r102 == null) goto L10;
        com.bytedance.android.ec.monitor.duration.d r104 = com.bytedance.android.ec.monitor.duration.i.f47987a.get(r103);
        if (r104 == null) goto L11;
        r104.b(r101, r102);
        return;
    L11:
        return;
    L10:
        return;
    }

    public final void m(boolean r100, boolean r101, int r102) {
        if (r101 == false) goto L5;
        u("ec_perf_duration_intro_card", "render_end", Long.valueOf(SystemClock.elapsedRealtime()));
    L7:
        if (r100 == true) goto L9;
    L13:
        String r103 = this.f149762p;
        if (r103 == null) goto L19;
        Map<String, com.bytedance.android.ec.core.monitor.a> r104 = com.bytedance.android.ec.core.monitor.c.f45142a;
        com.bytedance.android.ec.core.monitor.c.j(r103, MetricNames.POP_CARD_ANIM_DURATION);
        com.bytedance.android.ec.core.monitor.c.j(r103, MetricNames.RENDER_DURATION);
        com.bytedance.android.ec.core.monitor.c.j(r103, MetricNames.DURATION);
        if (r100 == false) goto L20;
        com.bytedance.android.ec.core.monitor.c.d(r103);
        this.f149762p = null;
        return;
    L20:
        return;
    L19:
        return;
    L9:
        if (r102 == 2) goto L11;
        String r105 = null;
    L12:
        w(this, "ec_perf_duration_intro_card", null, r105, 2);
        goto L13
    L11:
        r105 = "ec_perf_duration_intro_related_card";
        goto L12
    L5:
        v("ec_perf_duration_intro_card", CollectionsKt.listOf("render_end"), Long.valueOf(SystemClock.elapsedRealtime()));
        goto L7
    }

    public final void r(boolean r110, String r111, int r112) {
        Intrinsics.checkNotNullParameter(r111, "roomId");
        String r100 = this.f149762p;
        if (r100 == null) goto L5;
        ((HashMap) com.bytedance.android.ec.core.monitor.c.f45142a).remove(r100);
        this.f149762p = null;
    L5:
        this.f149763q = r110;
        b("ec_perf_duration_shopping_card", "room_id", r111);
        String r101 = this.f149760n;
        String r102 = "";
        if (r101 != null) goto L8;
        r101 = "";
    L8:
        b("ec_perf_duration_shopping_card", "enter_room_type", r101);
        b("ec_perf_duration_shopping_card", "enter_from_merge", l0.d());
        b("ec_perf_duration_shopping_card", "enter_method", l0.e());
        b("ec_perf_duration_shopping_card", "instant_type", String.valueOf(r112));
        String r103 = "message";
        if (r110 == false) goto L11;
        String r113 = "message";
    L12:
        b("ec_perf_duration_shopping_card", "scene", r113);
        if (r110 == false) goto L15;
        u("ec_perf_duration_shopping_card", "initial", Long.valueOf(SystemClock.elapsedRealtime()));
    L16:
        Map<String, com.bytedance.android.ec.core.monitor.a> r104 = com.bytedance.android.ec.core.monitor.c.f45142a;
        String r105 = com.bytedance.android.ec.core.monitor.c.c(MonitorScenes.EC_LIVE_SHOP_CARD_SHOW_DURATION, f149745x);
        this.f149762p = r105;
        String r106 = this.f149760n;
        if (r106 == null) goto L20;
        r102 = r106;
    L20:
        com.bytedance.android.ec.core.monitor.c.e(r105, "enter_room_type", r102);
        com.bytedance.android.ec.core.monitor.c.e(r105, "enter_from_merge", l0.d());
        com.bytedance.android.ec.core.monitor.c.e(r105, "enter_method", l0.e());
        com.bytedance.android.ec.core.monitor.c.e(r105, "instant_type", String.valueOf(r112));
        if (r110 == true) goto L24;
        r103 = "enter_room";
    L24:
        com.bytedance.android.ec.core.monitor.c.e(r105, "scene", r103);
        if (r110 == false) goto L27;
        com.bytedance.android.ec.core.monitor.c.h(r105, MetricNames.DURATION, null);
        return;
    L27:
        com.bytedance.android.ec.core.monitor.c.h(r105, MetricNames.DURATION, this.f149749c);
        com.bytedance.android.ec.core.monitor.c.h(r105, MetricNames.ENTER_ROOM_DURATION, this.f149749c);
        com.bytedance.android.ec.core.monitor.c.h(r105, MetricNames.POP_CARD_VISIBLE_DURATION, this.f149749c);
        com.bytedance.android.ec.core.monitor.c.h(r105, MetricNames.POP_CARD_MAIN_IMAGE_VISIBLE_DURATION, this.f149749c);
        return;
    L15:
        v("ec_perf_duration_shopping_card", CollectionsKt.listOf(new String[]{"initial", "enter_room_start", "enter_ec_room_start", "card_visible_start", "main_image_visible_start"}), this.f149749c);
        goto L16
    L11:
        r113 = "enter_room";
        goto L12
    }

    public final void s(boolean r110, String r111, int r112) {
        Intrinsics.checkNotNullParameter(r111, "roomId");
        String r100 = this.f149762p;
        if (r100 == null) goto L5;
        ((HashMap) com.bytedance.android.ec.core.monitor.c.f45142a).remove(r100);
        this.f149762p = null;
    L5:
        this.f149763q = r110;
        b("ec_perf_duration_intro_card", "room_id", r111);
        String r101 = this.f149760n;
        String r102 = "";
        if (r101 != null) goto L8;
        r101 = "";
    L8:
        b("ec_perf_duration_intro_card", "enter_room_type", r101);
        b("ec_perf_duration_intro_card", "enter_from_merge", l0.d());
        b("ec_perf_duration_intro_card", "enter_method", l0.e());
        b("ec_perf_duration_intro_card", "instant_type", String.valueOf(r112));
        String r103 = "message";
        if (r110 == false) goto L11;
        String r113 = "message";
    L12:
        b("ec_perf_duration_intro_card", "scene", r113);
        if (r110 == false) goto L15;
        u("ec_perf_duration_intro_card", "initial", Long.valueOf(SystemClock.elapsedRealtime()));
    L16:
        Map<String, com.bytedance.android.ec.core.monitor.a> r104 = com.bytedance.android.ec.core.monitor.c.f45142a;
        String r105 = com.bytedance.android.ec.core.monitor.c.c(MonitorScenes.EC_LIVE_INTRO_CARD_SHOW_DURATION, f149745x);
        this.f149762p = r105;
        String r106 = this.f149760n;
        if (r106 == null) goto L20;
        r102 = r106;
    L20:
        com.bytedance.android.ec.core.monitor.c.e(r105, "enter_room_type", r102);
        com.bytedance.android.ec.core.monitor.c.e(r105, "enter_from_merge", l0.d());
        com.bytedance.android.ec.core.monitor.c.e(r105, "enter_method", l0.e());
        com.bytedance.android.ec.core.monitor.c.e(r105, "instant_type", String.valueOf(r112));
        if (r110 == true) goto L24;
        r103 = "enter_room";
    L24:
        com.bytedance.android.ec.core.monitor.c.e(r105, "scene", r103);
        if (r110 == false) goto L27;
        com.bytedance.android.ec.core.monitor.c.h(r105, MetricNames.DURATION, null);
        return;
    L27:
        com.bytedance.android.ec.core.monitor.c.h(r105, MetricNames.DURATION, this.f149749c);
        com.bytedance.android.ec.core.monitor.c.h(r105, MetricNames.ENTER_ROOM_DURATION, this.f149749c);
        com.bytedance.android.ec.core.monitor.c.h(r105, MetricNames.POP_CARD_VISIBLE_DURATION, this.f149749c);
        com.bytedance.android.ec.core.monitor.c.h(r105, MetricNames.POP_CARD_MAIN_IMAGE_VISIBLE_DURATION, this.f149749c);
        return;
    L15:
        v("ec_perf_duration_intro_card", CollectionsKt.listOf(new String[]{"initial", "enter_room_start", "enter_ec_room_start", "card_visible_start", "main_image_visible_start"}), this.f149749c);
        goto L16
    L11:
        r113 = "enter_room";
        goto L12
    }

    public final void u(String r100, String r101, Long r102) {
        String r103 = d(r100, false);
        if (r103 == null) goto L12;
        if (r102 == null) goto L8;
        com.bytedance.android.ec.monitor.duration.d r104 = com.bytedance.android.ec.monitor.duration.i.f47987a.get(r103);
        if (r104 == null) goto L13;
        r104.d(r101, r102.longValue());
        return;
    L13:
        return;
    L8:
        com.bytedance.android.ec.monitor.duration.d r105 = com.bytedance.android.ec.monitor.duration.i.f47987a.get(r103);
        if (r105 == null) goto L15;
        r105.a(r101);
        return;
    L15:
        return;
    }

    public final void v(String r100, List<String> r101, Long r102) {
        Iterator<T> r103 = r101.iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        u(r100, (String) r103.next(), r102);
        goto L4
    }

    public static void A(ECLivePerformanceMonitor r100, boolean r101, String r102, View r103, int r110) {
        if ((r110 & 2) == 0) goto L6;
        r102 = "";
    L6:
        if ((r110 & 8) == 0) goto L8;
        r103 = null;
    L8:
        Intrinsics.checkNotNullParameter(r102, "status");
        if (r101 == false) goto L11;
        String r104 = "ec_perf_page_start_live_product_list";
    L12:
        Map<String, g1> r105 = r100.f149769w;
        g1 r106 = (g1) ((LinkedHashMap) r105).get(r104);
        if (r106 != null) goto L15;
        r106 = new g1(r104);
    L15:
        PageFinder r107 = PageFinder.via(r103);
        BtmItemBuilder r108 = new BtmItemBuilder("a1.b0715", Boolean.FALSE).withPageFinder(r107);
        String r109 = BtmSDK.INSTANCE.createBtmId(r108.build());
        r106.f("scene", r100.f149751e);
        r106.f("live_list_from", r100.f149752f);
        r106.f("btm_id", r109);
        if (r101 == true) goto L18;
        r106.f("status", r102);
    L18:
        r106.k();
        Unit r111 = Unit.INSTANCE;
        r105.put(r104, r106);
        return;
    L11:
        r104 = "ec_perf_page_show_live_product_list";
        goto L12
    }

    public static void w(ECLivePerformanceMonitor r100, String r101, h r102, String r103, int r104) {
        if ((r104 & 2) == 0) goto L6;
        r102 = null;
    L6:
        if ((r104 & 4) == 0) goto L8;
        r103 = null;
    L8:
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "business");
        String r105 = r100.d(r101, true);
        if (r105 == null) goto L23;
        if (r102 == null) goto L14;
        com.bytedance.android.ec.monitor.duration.d r106 = com.bytedance.android.ec.monitor.duration.i.f47987a.get(r105);
        if (r106 == null) goto L14;
        r106.e(new com.bytedance.android.livesdk.livecommerce.opt.c(r102));
    L14:
        if (r103 == null) goto L18;
        com.bytedance.android.ec.monitor.duration.d r107 = com.bytedance.android.ec.monitor.duration.i.f47987a.get(r105);
        if (r107 == null) goto L21;
        r107.c(r103);
    L21:
        String r108 = r100.f149768v.remove(r101);
        return;
    L18:
        com.bytedance.android.ec.monitor.duration.d r109 = com.bytedance.android.ec.monitor.duration.i.f47987a.get(r105);
        if (r109 == null) goto L21;
        r109.report();
        goto L21
    }

    public final void x(boolean r100, Boolean r101, gf.a r102, View r110, String r111) {
        if (r100 == false) goto L4;
        String r103 = "ec_perf_page_start_live_guide_card";
    L5:
        Map<String, g1> r104 = this.f149769w;
        g1 r105 = (g1) ((LinkedHashMap) r104).get(r103);
        if (r105 != null) goto L8;
        r105 = new g1(r103);
    L8:
        BtmItemBuilder r112 = new BtmItemBuilder("c2627.d4434", Boolean.FALSE).withPageFinder(PageFinder.via(r110));
        String r113 = BtmSDK.INSTANCE.createBtmId(r112.build());
        if (r101 != null) goto L11;
    L15:
        if (r102 != null) goto L17;
    L21:
        r105.f("btm_id", r113);
        if (r100 == true) goto L24;
        r105.f("status", r111);
    L24:
        r105.k();
        Unit r106 = Unit.INSTANCE;
        r104.put(r103, r105);
        return;
    L17:
        if (r102.a() == false) goto L19;
        String r107 = "live";
    L20:
        r105.f("from_type", r107);
        goto L21
    L19:
        r107 = ComplianceConstants.ComplianceRequest.MARKET_STORE;
        goto L20
    L11:
        if (r101.booleanValue() == false) goto L13;
        String r108 = "message";
    L14:
        r105.f("scene", r108);
        goto L15
    L13:
        r108 = "enter_room";
        goto L14
    L4:
        r103 = "ec_perf_page_show_live_guide_card";
        goto L5
    }

    public static final void a(ECLivePerformanceMonitor r100, com.bytedance.android.ec.adapter.api.i r101, String r102, boolean r103, String r104, MetricNames r105) {
        r100.getClass();
        if (r103 == false) goto L5;
        r101.getSingleTimeStamp(r102);
        long r106 = 0;
    L6:
        long r107 = r101.a("enter_room");
        if (r107 > 0) goto L9;
    L11:
        long r108 = 0;
    L13:
        if (r108 <= 0) goto L16;
        Map<String, com.bytedance.android.ec.core.monitor.a> r109 = com.bytedance.android.ec.core.monitor.c.f45142a;
        com.bytedance.android.ec.core.monitor.c.a(r104, r105, r108);
        return;
    L16:
        return;
    L9:
        if (r106 <= 0) goto L11;
        r108 = r106 - r107;
        goto L13
    L5:
        r106 = r101.a(r102);
        goto L6
    }
}
