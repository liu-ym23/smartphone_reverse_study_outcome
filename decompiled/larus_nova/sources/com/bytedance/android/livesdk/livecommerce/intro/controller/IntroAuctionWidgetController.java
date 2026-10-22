package com.bytedance.android.livesdk.livecommerce.intro.controller;

import android.content.Context;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.android.ec.common.api.jump.model.LiveRoomParams;
import com.bytedance.android.ec.core.monitor.MetricNames;
import com.bytedance.android.ec.core.utils.OptCardUtil;
import com.bytedance.android.livesdk.livecommerce.ab.ECLiveABUtils;
import com.bytedance.android.livesdk.livecommerce.intro.auction.IntroAuctionViewModel;
import com.bytedance.android.livesdk.livecommerce.intro.event.IntroCardEventCenter;
import com.bytedance.android.livesdk.livecommerce.intro.manager.IntroCardAnimController;
import com.bytedance.android.livesdk.livecommerce.intro.manager.u;
import com.bytedance.android.livesdk.livecommerce.intro.model.req.IntroCardScene;
import com.bytedance.android.livesdk.livecommerce.intro.model.resp.IntroProduct;
import com.bytedance.android.livesdk.livecommerce.intro.model.resp.r0;
import com.bytedance.android.livesdk.livecommerce.intro.model.resp.s0;
import com.bytedance.android.livesdk.livecommerce.intro.model.vo.IntroAuctionPromotionVO;
import com.bytedance.android.livesdk.livecommerce.intro.utils.IntroCardLoadOpt;
import com.bytedance.android.livesdk.livecommerce.opt.ECLivePerformanceMonitor;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.RoomContextController;
import com.bytedance.android.livesdk.livecommerce.room.quick.ActionObserver;
import com.bytedance.android.livesdk.livecommerce.utils.ECLiveDegradeHelper;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.livecommerce.utils.n;
import com.bytedance.android.livesdk.livecommerce.utils.t0;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.kiwi.ui.QUIManager;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import sg2.y;

/* JADX INFO: loaded from: classes10.dex */
public final class IntroAuctionWidgetController implements com.bytedance.android.livesdk.livecommerce.intro.controller.b {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final Lazy f148113w = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f148114a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final QUIManager f148115b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final IntroAuctionViewModel f148116c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Disposable f148117d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f148118e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f148119f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f148120g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f148121h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public c f148122i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f148123j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f148124k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f148125l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Lazy f148126m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Lazy f148127n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final RoomContextController f148128o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final com.bytedance.android.livesdk.livecommerce.room.model.e f148129p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final ViewGroup f148130q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final com.bytedance.android.livesdk.livecommerce.intro.manager.d f148131r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final IntroCardAnimController f148132s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final u f148133t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final qh2.b f148134u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final com.bytedance.android.livesdk.livecommerce.intro.controller.a f148135v;

    public static final class a {
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IntroAuctionWidgetController f148136a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ IntroAuctionPromotionVO f148137b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f148138c;

        public b(IntroAuctionWidgetController r100, IntroAuctionPromotionVO r101, String r102, boolean r103) {
            this.f148136a = r100;
            this.f148137b = r101;
            this.f148138c = r103;
        }

        @Override // java.lang.Runnable
        public final void run() {
            IntroAuctionWidgetController r100 = this.f148136a;     // Catch: Throwable -> L7
            IntroAuctionPromotionVO r101 = this.f148137b;     // Catch: Throwable -> L7
            if (r101 == null) goto L5;
            r101.getPromotionId();     // Catch: Throwable -> L7
        L5:
            r100.d(IntroAuctionWidgetController$cancelIntroCard$1$1.INSTANCE, IntroAuctionWidgetController$cancelIntroCard$1$2.INSTANCE, this.f148138c);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L11;
            return;
        L11:
            throw th;
        }
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IntroAuctionWidgetController f148139a;

        public c(IntroAuctionWidgetController r100) {
            this.f148139a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            IntroAuctionWidgetController r100 = this.f148139a;     // Catch: Throwable -> L4
            r100.getClass();     // Catch: Throwable -> L4
            int r101 = g.f148210a;     // Catch: Throwable -> L4
            g.c(false, new IntroAuctionWidgetController$onCardVisible$1(r100), r100.f148128o);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class d implements Action {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IntroAuctionWidgetController f148140a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ IntroAuctionPromotionVO f148141b;

        public static final class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ r0 f148142a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ d f148143b;

            public a(r0 r100, d r101) {
                this.f148142a = r100;
                this.f148143b = r101;
            }

            @Override // java.lang.Runnable
            public final void run() {
                com.bytedance.android.livesdk.livecommerce.intro.controller.a r100 = this.f148143b.f148140a.f148135v;     // Catch: Throwable -> L6
                if (r100 == null) goto L9;
                r100.d(this.f148142a);     // Catch: Throwable -> L6
                return;
            L9:
                return;
            L6:
                th = move-exception;
                if (RunnableProtector.intercept(th) == true) goto L13;
                throw th;
            }
        }

        public d(IntroAuctionWidgetController r100, IntroAuctionPromotionVO r101) {
            this.f148140a = r100;
            this.f148141b = r101;
        }

        @Override // io.reactivex.functions.Action
        public final void run() {
            com.bytedance.android.livesdk.livecommerce.intro.controller.b.a.a(this.f148140a, null, this.f148141b.getPromotionId(), false, false, 13);
            s0 r100 = this.f148141b.getControl();
            if (r100 == null) goto L8;
            r0 r101 = r100.a();
            if (r101 == null) goto L9;
            UtilityKotlinExtentionsKt.f153057b.post(new a(r101, this));
            return;
        L9:
            return;
        }
    }

    public static final class e<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IntroAuctionPromotionVO f148144a;

        public e(IntroAuctionPromotionVO r100) {
            this.f148144a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            this.f148144a.setExposureTime(((Long) r100).longValue());
        }
    }

    static {
        f148113w = LazyKt.lazy(IntroAuctionWidgetController$Companion$disableCardLinkedAnimOnEnter$2.INSTANCE);
    }

    @Override // com.bytedance.android.livesdk.livecommerce.intro.controller.b
    public final boolean i() {
        if (this.f148116c.getCardState().a() == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.intro.controller.b
    public final String j() {
        IntroAuctionPromotionVO r100 = this.f148116c.getCardState().a();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getPromotionId();
    }

    @Override // com.bytedance.android.livesdk.livecommerce.intro.controller.b
    public final boolean n() {
        IntroAuctionPromotionVO r100 = this.f148116c.getCardState().a();
        if (r100 == null) goto L9;
        IntroProduct r101 = r100.getProduct();
        if (r101 == null) goto L9;
        if (r101.h() != 2) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.intro.controller.b
    public final void o() {
        if (this.f148120g == false) goto L10;
        this.f148120g = false;
        int r100 = g.f148210a;
        ECLivePerformanceMonitor r101 = g.a(this.f148128o);
        if (r101 == null) goto L10;
        r101.u("ec_perf_duration_intro_card", "card_visible_end", Long.valueOf(SystemClock.elapsedRealtime()));
        String r102 = r101.f149762p;
        if (r102 == null) goto L10;
        Map<String, com.bytedance.android.ec.core.monitor.a> r103 = com.bytedance.android.ec.core.monitor.c.f45142a;
        com.bytedance.android.ec.core.monitor.c.j(r102, MetricNames.POP_CARD_VISIBLE_DURATION);
    L10:
        if (this.f148121h == false) goto L18;
        this.f148121h = false;
        int r104 = g.f148210a;
        ECLivePerformanceMonitor r105 = g.a(this.f148128o);
        if (r105 == null) goto L16;
        r105.u("ec_perf_duration_intro_card", "main_image_visible_end", Long.valueOf(SystemClock.elapsedRealtime()));
        String r106 = r105.f149762p;
        if (r106 == null) goto L16;
        Map<String, com.bytedance.android.ec.core.monitor.a> r107 = com.bytedance.android.ec.core.monitor.c.f45142a;
        com.bytedance.android.ec.core.monitor.c.j(r106, MetricNames.POP_CARD_MAIN_IMAGE_VISIBLE_DURATION);
    L16:
        this.f148122i = new c(this);
    L18:
        if (this.f148119f == false) goto L26;
        c r108 = this.f148122i;
        if (r108 == null) goto L26;
        this.f148119f = false;
        r108.run();
        this.f148122i = null;
        if (this.f148123j == false) goto L26;
        int r109 = g.f148210a;
        ECLivePerformanceMonitor r110 = g.a(this.f148128o);
        if (r110 == null) goto L26;
        r110.z(this.f148124k);
    L26:
        OptCardUtil.b(null, "call dispatchDraw of card");
    }

    @Override // com.bytedance.android.livesdk.livecommerce.intro.controller.b
    public final void onDestroy() {
        ((bk2.d) this.f148118e.getValue()).clearDisposable();
        Disposable r100 = this.f148117d;
        if (r100 == null) goto L5;
        r100.dispose();
    L5:
        this.f148117d = null;
        this.f148115b.r(com.bytedance.android.livesdk.livecommerce.intro.auction.f.class);
        this.f148116c.onDestroy();
    }

    public static final boolean b(IntroAuctionWidgetController r100) {
        return ((Boolean) r100.f148127n.getValue()).booleanValue();
    }

    public static final boolean c(IntroAuctionWidgetController r100) {
        r100.getClass();
        if (n.c() == true) goto L5;
    L6:
        ECLiveDegradeHelper.f153042c.getClass();
        if (ECLiveDegradeHelper.c() == 1) goto L12;
        return false;
    L12:
        return true;
    L5:
        if (com.bytedance.android.livesdk.livecommerce.room.widgets.shoppingcart.a.C2352a.e(com.bytedance.android.livesdk.livecommerce.room.widgets.shoppingcart.a.f152743e) == true) goto L6;
        return true;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.intro.controller.b
    public final void a(JSONObject r100) {
        Intrinsics.checkNotNullParameter("closeExplainCard", "event");
        Intrinsics.checkNotNullParameter(r100, "params");
        IntroAuctionPromotionVO r101 = this.f148116c.getCardState().a();
        if (r101 == null) goto L8;
        String r102 = r101.getProductId();
        if (r102 == null) goto L9;
        com.bytedance.android.livesdk.livecommerce.intro.controller.b.a.a(this, r102, null, false, false, 14);
        return;
    L9:
        return;
    }

    public final void e(IntroAuctionPromotionVO r110) {
        s0 r100 = r110.getControl();
        if (r100 == null) goto L5;
        long r101 = r100.c();
    L6:
        long r102 = r101 / 1000;
        if (r102 > 0) goto L9;
        return;
    L9:
        Disposable r103 = this.f148117d;
        if (r103 == null) goto L12;
        r103.dispose();
    L12:
        int r104 = t0.f153116a;
        this.f148117d = bk2.c.a(t0.b(0, 1, TimeUnit.SECONDS, Schedulers.io()).take(r102 + 1).observeOn(AndroidSchedulers.mainThread()).doOnComplete(new d(this, r110)).subscribe(new e(r110)), (bk2.d) this.f148118e.getValue());
        return;
    L5:
        r101 = 0;
        goto L6
    }

    @Override // com.bytedance.android.livesdk.livecommerce.intro.controller.b
    public final void k(boolean r100) {
        IntroAuctionPromotionVO r101 = this.f148116c.getCardState().a();
        if (r101 == null) goto L6;
        r101.getPromotionId();
        d(null, null, r100);
        return;
    }

    public final void d(Function0 r110, Function0 r111, boolean r112) {
        fk2.b r100 = (fk2.b) this.f148126m.getValue();
        if (r100 == null) goto L5;
        r100.a();
    L5:
        this.f148119f = false;
        this.f148120g = false;
        this.f148121h = false;
        this.f148122i = null;
        IntroCardAnimController r101 = this.f148132s;
        IntroAuctionPromotionVO r102 = this.f148116c.getCardState().a();
        if (r102 == null) goto L9;
        String r103 = r102.getPromotionId();
        if (r103 == null) goto L9;
    L10:
        r101.f(new com.bytedance.android.livesdk.livecommerce.intro.controller.e(this, r110, r111, r103, this.f148115b.p(), new IntroAuctionWidgetController$hideIntroCard$2(this, r112)));
        return;
    L9:
        r103 = "";
        goto L10
    }

    @Override // com.bytedance.android.livesdk.livecommerce.intro.controller.b
    public final void m(uh2.a r110, final boolean r111, final boolean r112) {
        if ((r110 instanceof IntroAuctionPromotionVO) == true) goto L5;
        r110 = null;
    L5:
        final IntroAuctionPromotionVO r100 = (IntroAuctionPromotionVO) r110;
        if (r100 == null) goto L58;
        if (r111 == false) goto L9;
        this.f148116c.getCardState().g(r100);
    L59:
        IntroCardLoadOpt.f148509n = false;
        if (this.f148125l == false) goto L63;
        this.f148125l = false;
        this.f148116c.setEnterRoom(false);
        return;
    L63:
        return;
    L9:
        IntroProduct r101 = r100.getProduct();
        if (r101 == null) goto L12;
        int r102 = r101.h();
    L13:
        this.f148124k = r102;
        IntroCardScene r103 = r100.getCardReqScene();
        if (r103 == null) goto L16;
        boolean r104 = sh2.f.b(r103);
    L17:
        if (r104 == true) goto L24;
        int r105 = g.f148210a;
        ECLivePerformanceMonitor r106 = g.a(this.f148128o);
        if (r106 == null) goto L21;
        ECLivePerformanceMonitor.y(r106, Boolean.FALSE, new gf.a(0));
    L21:
        y r107 = this.f148128o.f151594c;
        if (r107 == null) goto L24;
        r107.f(r100.getPromotionId());
    L24:
        com.bytedance.android.livesdk.livecommerce.room.utils.d r108 = this.f148128o.f151595d;
        String r109 = r100.getPromotionId();
        r108.getClass();
        Intrinsics.checkNotNullParameter(r109, "<set-?>");
        r108.f151935d = r109;
        IntroAuctionPromotionVO r113 = this.f148116c.getCardState().a();
        com.bytedance.android.livesdk.livecommerce.intro.manager.a r114 = this.f148132s.f148348a;
        if (r113 == null) goto L27;
        String r115 = r113.getPromotionId();
    L29:
        if (Intrinsics.areEqual(r115, r100.getPromotionId()) == false) goto L38;
        if (r114 != null) goto L32;
    L35:
        e(r100);
        if (ECLiveABUtils.INSTANCE.getEC_LIVE_POP_SAME_CARD_EXTEND() == false) goto L59;
        this.f148116c.getCardState().g(r100);
        goto L59
    L32:
        if (r114.f148378d != 1) goto L35;
        if (r114.d() == false) goto L35;
    L38:
        com.bytedance.android.livesdk.livecommerce.intro.controller.a r116 = this.f148135v;
        if (r116 == null) goto L41;
        r116.a(r112);
    L41:
        Function0<Unit> r117 = new IntroAuctionWidgetController$handleIntroVO$$inlined$also$lambda$1(r100, this, r111, r112);
        OptCardUtil.b(null, "call showExplainCard");
        fk2.b r118 = (fk2.b) this.f148126m.getValue();
        if (r118 == null) goto L49;
        long r119 = SystemClock.elapsedRealtime();
        r118.f477605f = r119;
        if (r118.f477604e <= 0) goto L46;
        boolean r120 = true;
    L47:
        if (r120 == true) goto L49;
        r118.f477606g = r119;
        goto L49
    L46:
        r120 = false;
    L49:
        r100.setShowTimestamp(System.currentTimeMillis());
        this.f148119f = false;
        this.f148120g = false;
        this.f148121h = false;
        this.f148122i = null;
        IntroCardScene r121 = r100.getCardReqScene();
        if (r121 != null) goto L52;
    L54:
        boolean r122 = false;
    L55:
        this.f148132s.f(new f(this, r122, r117, r100, r100.getPromotionId(), this.f148115b.p(), new IntroAuctionWidgetController$showIntroCard$2(this, r122, r112)));
        if (this.f148125l == false) goto L59;
        IntroCardEventCenter r123 = this.f148116c.getCardArgument().f523252a;
        r123.getClass();
        IntroCardEventCenter.b(new com.bytedance.android.livesdk.livecommerce.intro.event.g(r123));
        goto L59
    L52:
        if (sh2.f.a(r121) != true) goto L54;
        r122 = true;
        goto L55
    L27:
        r115 = null;
        goto L29
    L16:
        r104 = false;
        goto L17
    L12:
        r102 = 1;
        goto L13
    L58:
        com.bytedance.android.livesdk.livecommerce.intro.controller.b.a.a(this, null, null, false, false, 15);
        Unit r124 = Unit.INSTANCE;
        goto L59
    }

    @Override // com.bytedance.android.livesdk.livecommerce.intro.controller.b
    public final void l(String r100, String r101, boolean r102, boolean r103) {
        IntroAuctionPromotionVO r104 = this.f148116c.getCardState().a();
        if (r102 == true) goto L18;
        String r105 = null;
        if (r100 == null) goto L12;
        if (r104 == null) goto L8;
        String r106 = r104.getProductId();
    L10:
        if ((!Intrinsics.areEqual(r100, r106)) == false) goto L12;
        return;
    L8:
        r106 = null;
    L12:
        if (r101 == null) goto L18;
        if (r104 == null) goto L16;
        r105 = r104.getPromotionId();
    L16:
        if ((!Intrinsics.areEqual(r101, r105)) == false) goto L18;
        return;
    L18:
        this.f148131r.i(this.f148114a, new b(this, r104, r101, r103));
    }

    public IntroAuctionWidgetController(Context r110, RoomContextController r111, com.bytedance.android.livesdk.livecommerce.room.model.g r112, LiveRoomParams r113, com.bytedance.android.livesdk.livecommerce.intro.manager.h r114, qh2.d.b r115, com.bytedance.android.livesdk.livecommerce.intro.manager.d r210, IntroCardAnimController r211, u r212, qh2.b r213, com.bytedance.android.livesdk.livecommerce.intro.manager.k r214) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r111, "roomContextController");
        Intrinsics.checkNotNullParameter(r112, "liveRoomInfo");
        Intrinsics.checkNotNullParameter(r114, "rootView");
        Intrinsics.checkNotNullParameter(r115, "btmInfo");
        Intrinsics.checkNotNullParameter(r210, "cardQueue");
        Intrinsics.checkNotNullParameter(r211, "animController");
        Intrinsics.checkNotNullParameter(r212, "animDelegate");
        this.f148128o = r111;
        this.f148129p = r112;
        this.f148130q = r114;
        this.f148131r = r210;
        this.f148132s = r211;
        this.f148133t = r212;
        this.f148134u = r213;
        this.f148135v = r214;
        this.f148114a = 2;
        QUIManager r116 = new QUIManager();
        this.f148115b = r116;
        this.f148118e = LazyKt.lazy(IntroAuctionWidgetController$disposableContext$2.INSTANCE);
        this.f148123j = true;
        this.f148124k = 1;
        this.f148125l = true;
        this.f148126m = LazyKt.lazy(new IntroAuctionWidgetController$durationMonitor$2(this));
        this.f148127n = LazyKt.lazy(IntroAuctionWidgetController$enableEnterRoomAnim$2.INSTANCE);
        IntroAuctionViewModel r117 = new IntroAuctionViewModel(r112, r113, r115, jf.b.e.f498853b, r111, r212);
        r117.setCardCallback(new com.bytedance.android.livesdk.livecommerce.intro.controller.c(this));
        r117.setEnterRoom(this.f148125l);
        Unit r100 = Unit.INSTANCE;
        this.f148116c = r117;
        r116.l(new com.bytedance.android.livesdk.livecommerce.intro.auction.f(r117, r117.getCardArgument(), r117.getContainerAbility()), r114.getContext(), true);
        r116.c(com.bytedance.android.livesdk.livecommerce.intro.auction.f.class, new com.bytedance.android.livesdk.livecommerce.intro.controller.d(this));
        r117.getClickCloseAction().b(g.b(r111), new ActionObserver(new IntroAuctionWidgetController$observeData$1(this)));
        View r101 = r116.p();
        FrameLayout.LayoutParams r102 = new FrameLayout.LayoutParams(r101.getLayoutParams());
        r102.gravity = 80;
        r101.setLayoutParams(r102);
        r114.addView(r101);
    }
}
