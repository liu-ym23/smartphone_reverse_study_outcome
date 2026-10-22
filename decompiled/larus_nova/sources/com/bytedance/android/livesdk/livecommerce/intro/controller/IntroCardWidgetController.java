package com.bytedance.android.livesdk.livecommerce.intro.controller;

import android.content.Context;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.bytedance.android.ec.common.api.jump.model.LiveRoomParams;
import com.bytedance.android.ec.core.monitor.MetricNames;
import com.bytedance.android.ec.core.utils.OptCardUtil;
import com.bytedance.android.livesdk.livecommerce.ab.ECLiveABUtils;
import com.bytedance.android.livesdk.livecommerce.intro.card.vm.IntroCardViewModel;
import com.bytedance.android.livesdk.livecommerce.intro.event.IntroCardEventCenter;
import com.bytedance.android.livesdk.livecommerce.intro.manager.IntroCardAnimController;
import com.bytedance.android.livesdk.livecommerce.intro.manager.u;
import com.bytedance.android.livesdk.livecommerce.intro.model.req.IntroCardScene;
import com.bytedance.android.livesdk.livecommerce.intro.model.resp.IntroProduct;
import com.bytedance.android.livesdk.livecommerce.intro.model.resp.r0;
import com.bytedance.android.livesdk.livecommerce.intro.model.resp.s0;
import com.bytedance.android.livesdk.livecommerce.intro.model.vo.IntroPromotionVO;
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
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import sg2.v;
import sg2.y;

/* JADX INFO: loaded from: classes10.dex */
public final class IntroCardWidgetController implements com.bytedance.android.livesdk.livecommerce.intro.controller.b {

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final Lazy f148155y = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f148156a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final QUIManager f148157b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ph2.g f148158c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final IntroCardViewModel f148159d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Disposable f148160e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f148161f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f148162g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f148163h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f148164i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public c f148165j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f148166k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f148167l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f148168m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Lazy f148169n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Lazy f148170o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final RoomContextController f148171p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final com.bytedance.android.livesdk.livecommerce.room.model.e f148172q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final ViewGroup f148173r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final com.bytedance.android.livesdk.livecommerce.intro.manager.d f148174s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final IntroCardAnimController f148175t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final u f148176u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final com.bytedance.android.livesdk.livecommerce.intro.event.j f148177v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final qh2.b f148178w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final com.bytedance.android.livesdk.livecommerce.intro.controller.a f148179x;

    public static final class a {
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IntroCardWidgetController f148180a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ IntroPromotionVO f148181b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f148182c;

        public b(IntroCardWidgetController r100, IntroPromotionVO r101, String r102, boolean r103) {
            this.f148180a = r100;
            this.f148181b = r101;
            this.f148182c = r103;
        }

        @Override // java.lang.Runnable
        public final void run() {
            IntroCardWidgetController r100 = this.f148180a;     // Catch: Throwable -> L7
            IntroPromotionVO r101 = this.f148181b;     // Catch: Throwable -> L7
            if (r101 == null) goto L5;
            r101.getPromotionId();     // Catch: Throwable -> L7
        L5:
            r100.d(IntroCardWidgetController$cancelIntroCard$1$1.INSTANCE, IntroCardWidgetController$cancelIntroCard$1$2.INSTANCE, this.f148182c);     // Catch: Throwable -> L7
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
        public final /* synthetic */ IntroCardWidgetController f148183a;

        public c(IntroCardWidgetController r100) {
            this.f148183a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            IntroCardWidgetController r100 = this.f148183a;     // Catch: Throwable -> L4
            r100.getClass();     // Catch: Throwable -> L4
            int r101 = g.f148210a;     // Catch: Throwable -> L4
            g.c(false, new IntroCardWidgetController$onCardVisible$1(r100), r100.f148171p);     // Catch: Throwable -> L4
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
        public final /* synthetic */ IntroCardWidgetController f148184a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ IntroPromotionVO f148185b;

        public static final class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ r0 f148186a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ d f148187b;

            public a(r0 r100, d r101) {
                this.f148186a = r100;
                this.f148187b = r101;
            }

            @Override // java.lang.Runnable
            public final void run() {
                com.bytedance.android.livesdk.livecommerce.intro.controller.a r100 = this.f148187b.f148184a.f148179x;     // Catch: Throwable -> L6
                if (r100 == null) goto L9;
                r100.d(this.f148186a);     // Catch: Throwable -> L6
                return;
            L9:
                return;
            L6:
                th = move-exception;
                if (RunnableProtector.intercept(th) == true) goto L13;
                throw th;
            }
        }

        public d(IntroCardWidgetController r100, IntroPromotionVO r101) {
            this.f148184a = r100;
            this.f148185b = r101;
        }

        @Override // io.reactivex.functions.Action
        public final void run() {
            com.bytedance.android.livesdk.livecommerce.intro.controller.b.a.a(this.f148184a, null, this.f148185b.getPromotionId(), false, false, 13);
            s0 r100 = this.f148185b.getControl();
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
        public final /* synthetic */ IntroPromotionVO f148188a;

        public e(IntroPromotionVO r100) {
            this.f148188a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            this.f148188a.setExposureTime(((Long) r100).longValue());
        }
    }

    static {
        f148155y = LazyKt.lazy(IntroCardWidgetController$Companion$disableCardLinkedAnimOnEnter$2.INSTANCE);
    }

    @Override // com.bytedance.android.livesdk.livecommerce.intro.controller.b
    public final boolean i() {
        if (this.f148159d.getCardState().a() == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.intro.controller.b
    public final String j() {
        IntroPromotionVO r100 = this.f148159d.getCardState().a();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getPromotionId();
    }

    @Override // com.bytedance.android.livesdk.livecommerce.intro.controller.b
    public final boolean n() {
        IntroPromotionVO r100 = this.f148159d.getCardState().a();
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
        if (this.f148163h == false) goto L10;
        this.f148163h = false;
        int r100 = g.f148210a;
        ECLivePerformanceMonitor r101 = g.a(this.f148171p);
        if (r101 == null) goto L10;
        r101.u("ec_perf_duration_intro_card", "card_visible_end", Long.valueOf(SystemClock.elapsedRealtime()));
        String r102 = r101.f149762p;
        if (r102 == null) goto L10;
        Map<String, com.bytedance.android.ec.core.monitor.a> r103 = com.bytedance.android.ec.core.monitor.c.f45142a;
        com.bytedance.android.ec.core.monitor.c.j(r102, MetricNames.POP_CARD_VISIBLE_DURATION);
    L10:
        if (this.f148164i == false) goto L18;
        this.f148164i = false;
        int r104 = g.f148210a;
        ECLivePerformanceMonitor r105 = g.a(this.f148171p);
        if (r105 == null) goto L16;
        r105.u("ec_perf_duration_intro_card", "main_image_visible_end", Long.valueOf(SystemClock.elapsedRealtime()));
        String r106 = r105.f149762p;
        if (r106 == null) goto L16;
        Map<String, com.bytedance.android.ec.core.monitor.a> r107 = com.bytedance.android.ec.core.monitor.c.f45142a;
        com.bytedance.android.ec.core.monitor.c.j(r106, MetricNames.POP_CARD_MAIN_IMAGE_VISIBLE_DURATION);
    L16:
        this.f148165j = new c(this);
    L18:
        if (this.f148162g == false) goto L26;
        c r108 = this.f148165j;
        if (r108 == null) goto L26;
        this.f148162g = false;
        r108.run();
        this.f148165j = null;
        if (this.f148166k == false) goto L26;
        int r109 = g.f148210a;
        ECLivePerformanceMonitor r110 = g.a(this.f148171p);
        if (r110 == null) goto L26;
        r110.z(this.f148167l);
    L26:
        OptCardUtil.b(null, "call dispatchDraw of card");
    }

    @Override // com.bytedance.android.livesdk.livecommerce.intro.controller.b
    public final void onDestroy() {
        ((bk2.d) this.f148161f.getValue()).clearDisposable();
        Disposable r100 = this.f148160e;
        if (r100 == null) goto L5;
        r100.dispose();
    L5:
        this.f148160e = null;
        ph2.g r101 = this.f148158c;
        if ((r101 instanceof ph2.h) == true) goto L8;
        Object r102 = null;
    L9:
        ph2.h r103 = (ph2.h) r102;
        if (r103 == null) goto L26;
        View r104 = r103.f529256n;
        if (r104 == null) goto L26;
        Result.Companion r105 = Result.Companion;     // Catch: Throwable -> L16
        int r106 = nh2.a.f519160a;     // Catch: Throwable -> L16
        Intrinsics.checkNotNullParameter(r104, "view");     // Catch: Throwable -> L16
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L16
    L18:
        ViewParent r107 = r104.getParent();
        if ((r107 instanceof ViewGroup) == true) goto L21;
        r107 = null;
    L21:
        ViewGroup r108 = (ViewGroup) r107;
        if (r108 == null) goto L24;
        r108.removeView(r104);
    L24:
        r103.f529256n = null;
        throw null;
    L16:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    L26:
        this.f148157b.r(r101.getClass());
        this.f148159d.onDestroy();
        return;
    L8:
        r102 = r101;
        goto L9
    }

    public static final boolean b(IntroCardWidgetController r100) {
        return ((Boolean) r100.f148170o.getValue()).booleanValue();
    }

    public static final boolean c(IntroCardWidgetController r100) {
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
        IntroPromotionVO r101 = this.f148159d.getCardState().a();
        if (r101 == null) goto L8;
        String r102 = r101.getProductId();
        if (r102 == null) goto L9;
        com.bytedance.android.livesdk.livecommerce.intro.controller.b.a.a(this, r102, null, false, false, 14);
        return;
    L9:
        return;
    }

    public final void e(IntroPromotionVO r110) {
        s0 r100 = r110.getControl();
        if (r100 == null) goto L5;
        long r101 = r100.c();
    L6:
        long r102 = r101 / 1000;
        if (r102 > 0) goto L9;
        return;
    L9:
        Disposable r103 = this.f148160e;
        if (r103 == null) goto L12;
        r103.dispose();
    L12:
        int r104 = t0.f153116a;
        this.f148160e = bk2.c.a(t0.b(0, 1, TimeUnit.SECONDS, Schedulers.io()).take(r102 + 1).observeOn(AndroidSchedulers.mainThread()).doOnComplete(new d(this, r110)).subscribe(new e(r110)), (bk2.d) this.f148161f.getValue());
        return;
    L5:
        r101 = 0;
        goto L6
    }

    @Override // com.bytedance.android.livesdk.livecommerce.intro.controller.b
    public final void k(boolean r100) {
        IntroPromotionVO r101 = this.f148159d.getCardState().a();
        if (r101 == null) goto L6;
        r101.getPromotionId();
        d(null, null, r100);
        return;
    }

    public final void d(Function0 r110, Function0 r111, boolean r112) {
        fk2.b r100 = (fk2.b) this.f148169n.getValue();
        if (r100 == null) goto L5;
        r100.a();
    L5:
        this.f148162g = false;
        this.f148163h = false;
        this.f148164i = false;
        this.f148165j = null;
        IntroCardAnimController r101 = this.f148175t;
        IntroPromotionVO r102 = this.f148159d.getCardState().a();
        if (r102 == null) goto L9;
        String r103 = r102.getPromotionId();
        if (r103 == null) goto L9;
    L10:
        r101.f(new j(this, r110, r111, r103, this.f148157b.p(), new IntroCardWidgetController$hideIntroCard$2(this, r112)));
        return;
    L9:
        r103 = "";
        goto L10
    }

    @Override // com.bytedance.android.livesdk.livecommerce.intro.controller.b
    public final void m(uh2.a r110, final boolean r111, final boolean r112) {
        if ((r110 instanceof IntroPromotionVO) == true) goto L5;
        r110 = null;
    L5:
        final IntroPromotionVO r113 = (IntroPromotionVO) r110;
        if (r113 == null) goto L84;
        if (r111 == false) goto L9;
        this.f148159d.getCardState().g(r113);
    L85:
        IntroCardLoadOpt.f148509n = false;
        if (this.f148168m == false) goto L89;
        this.f148168m = false;
        this.f148159d.setEnterRoom(false);
        return;
    L89:
        return;
    L9:
        IntroProduct r100 = r113.getProduct();
        if (r100 == null) goto L12;
        int r101 = r100.h();
    L13:
        this.f148167l = r101;
        IntroCardScene r102 = r113.getCardReqScene();
        if (r102 == null) goto L16;
        boolean r103 = sh2.f.b(r102);
    L17:
        if (r103 == true) goto L24;
        int r104 = g.f148210a;
        ECLivePerformanceMonitor r105 = g.a(this.f148171p);
        if (r105 == null) goto L21;
        ECLivePerformanceMonitor.y(r105, Boolean.FALSE, new gf.a(0));
    L21:
        y r106 = this.f148171p.f151594c;
        if (r106 == null) goto L24;
        r106.f(r113.getPromotionId());
    L24:
        com.bytedance.android.livesdk.livecommerce.room.utils.d r107 = this.f148171p.f151595d;
        String r108 = r113.getPromotionId();
        r107.getClass();
        Intrinsics.checkNotNullParameter(r108, "<set-?>");
        r107.f151935d = r108;
        IntroPromotionVO r109 = this.f148159d.getCardState().a();
        com.bytedance.android.livesdk.livecommerce.intro.manager.a r114 = this.f148175t.f148348a;
        if (r109 == null) goto L27;
        String r115 = r109.getPromotionId();
    L29:
        if (Intrinsics.areEqual(r115, r113.getPromotionId()) == false) goto L40;
        if (r114 != null) goto L32;
    L35:
        e(r113);
        if (ECLiveABUtils.INSTANCE.getEC_LIVE_POP_SAME_CARD_EXTEND() == false) goto L38;
    L39:
        this.f148159d.getCardState().g(r113);
        goto L85
    L38:
        if (r113.getShouldExtendSameCardDuration() == false) goto L85;
    L32:
        if (r114.f148378d != 1) goto L35;
        if (r114.d() == false) goto L35;
    L40:
        com.bytedance.android.livesdk.livecommerce.intro.controller.a r116 = this.f148179x;
        if (r116 == null) goto L43;
        r116.a(r112);
    L43:
        Function0<Unit> r117 = new IntroCardWidgetController$handleIntroVO$$inlined$also$lambda$1(r113, this, r111, r112);
        OptCardUtil.b(null, "call showExplainCard");
        fk2.b r118 = (fk2.b) this.f148169n.getValue();
        if (r118 == null) goto L51;
        long r119 = SystemClock.elapsedRealtime();
        r118.f477605f = r119;
        if (r118.f477604e <= 0) goto L48;
        boolean r120 = true;
    L49:
        if (r120 == true) goto L51;
        r118.f477606g = r119;
        goto L51
    L48:
        r120 = false;
    L51:
        r113.setShowTimestamp(System.currentTimeMillis());
        this.f148162g = false;
        this.f148163h = false;
        this.f148164i = false;
        this.f148165j = null;
        IntroCardScene r121 = r113.getCardReqScene();
        if (r121 != null) goto L54;
    L56:
        boolean r122 = false;
    L57:
        this.f148175t.f(new k(this, r122, r117, r113, r113.getPromotionId(), this.f148157b.p(), new IntroCardWidgetController$showIntroCard$2(this, r122, r112)));
        if (this.f148168m == false) goto L60;
        IntroCardEventCenter r123 = this.f148159d.getCardArgument().f523252a;
        r123.getClass();
        IntroCardEventCenter.b(new com.bytedance.android.livesdk.livecommerce.intro.event.g(r123));
    L60:
        com.bytedance.android.livesdk.livecommerce.intro.event.j r124 = this.f148177v;
        if (r124 == null) goto L85;
        Intrinsics.checkNotNullParameter(r113, "introPromotionVO");
        IntroProduct r125 = r113.getProduct();
        if (r125 != null) goto L65;
    L67:
        IntroCardScene r126 = r113.getCardReqScene();
        if (r126 != null) goto L70;
    L72:
        String r127 = "message";
    L73:
        v r128 = new v("livesdk_popup_card_show", r124.f148276d);
        IntroProduct r129 = r113.getProduct();
        if (r129 == null) goto L76;
        String r130 = String.valueOf(r129.h());
    L77:
        r128.c("product_type", r130);
        r128.c("from_scene", r127);
        IntroProduct r131 = r113.getProduct();
        if (r131 == null) goto L80;
        String r132 = r131.i();
    L81:
        r128.c("promotion_id", r132);
        if (r124.f148275c == false) goto L85;
        r128.i(null);
        goto L85
    L80:
        r132 = null;
        goto L81
    L76:
        r130 = null;
        goto L77
    L70:
        if (sh2.f.a(r126) != true) goto L72;
        r127 = "enter_room";
        goto L73
    L65:
        if (r125.h() != 2) goto L67;
        r127 = "related_card";
        goto L73
    L54:
        if (sh2.f.a(r121) != true) goto L56;
        r122 = true;
        goto L57
    L27:
        r115 = null;
        goto L29
    L16:
        r103 = false;
        goto L17
    L12:
        r101 = 1;
        goto L13
    L84:
        com.bytedance.android.livesdk.livecommerce.intro.controller.b.a.a(this, null, null, false, false, 15);
        Unit r133 = Unit.INSTANCE;
        goto L85
    }

    @Override // com.bytedance.android.livesdk.livecommerce.intro.controller.b
    public final void l(String r100, String r101, boolean r102, boolean r103) {
        IntroPromotionVO r104 = this.f148159d.getCardState().a();
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
        this.f148174s.i(1, new b(this, r104, r101, r103));
    }

    public IntroCardWidgetController(Context r110, RoomContextController r111, com.bytedance.android.livesdk.livecommerce.room.model.g r112, LiveRoomParams r113, com.bytedance.android.livesdk.livecommerce.intro.manager.h r114, qh2.d.b r115, com.bytedance.android.livesdk.livecommerce.intro.manager.d r116, IntroCardAnimController r117, u r118, com.bytedance.android.livesdk.livecommerce.intro.event.j r119, qh2.b r210, com.bytedance.android.livesdk.livecommerce.intro.manager.k r211) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r111, "roomContextController");
        Intrinsics.checkNotNullParameter(r112, "liveRoomInfo");
        Intrinsics.checkNotNullParameter(r114, "rootView");
        Intrinsics.checkNotNullParameter(r115, "btmInfo");
        Intrinsics.checkNotNullParameter(r116, "cardQueue");
        Intrinsics.checkNotNullParameter(r117, "animController");
        Intrinsics.checkNotNullParameter(r118, "animDelegate");
        this.f148171p = r111;
        this.f148172q = r112;
        this.f148173r = r114;
        this.f148174s = r116;
        this.f148175t = r117;
        this.f148176u = r118;
        this.f148177v = r119;
        this.f148178w = r210;
        this.f148179x = r211;
        this.f148156a = 1;
        QUIManager r100 = new QUIManager();
        this.f148157b = r100;
        this.f148161f = LazyKt.lazy(IntroCardWidgetController$disposableContext$2.INSTANCE);
        this.f148166k = true;
        this.f148167l = 1;
        this.f148168m = true;
        this.f148169n = LazyKt.lazy(new IntroCardWidgetController$durationMonitor$2(this));
        this.f148170o = LazyKt.lazy(IntroCardWidgetController$enableEnterRoomAnim$2.INSTANCE);
        IntroCardViewModel r101 = new IntroCardViewModel(r112, r113, r115, jf.b.g.f498855b, r111);
        r101.setCardCallback(new h(this));
        r101.setEnterRoom(this.f148168m);
        Unit r102 = Unit.INSTANCE;
        this.f148159d = r101;
        if (ECLiveABUtils.INSTANCE.getEC_LIVE_INTRO_KMP_UI() == false) goto L5;
        int r103 = ph2.h.f529255o;
        int r104 = nh2.a.f519160a;
    L5:
        ph2.g r105 = new ph2.g(r101, r101.getCardArgument(), r101.getContainerAbility());
        this.f148158c = r105;
        r100.l(r105, r114.getContext(), true);
        r100.c(ph2.g.class, new i(this));
        r101.getClickCloseAction().b(g.b(r111), new ActionObserver(new IntroCardWidgetController$observeData$1(this)));
        r101.getOpenPriceAnimationFinishedAction$livecommerce_saasRelease().b(g.b(r111), new ActionObserver(new IntroCardWidgetController$observeData$2(this)));
        r101.getOpenPriceAnimationStateAction$livecommerce_saasRelease().b(g.b(r111), new ActionObserver(new IntroCardWidgetController$observeData$3(this)));
        View r106 = r100.p();
        FrameLayout.LayoutParams r107 = new FrameLayout.LayoutParams(r106.getLayoutParams());
        r107.gravity = 80;
        r106.setLayoutParams(r107);
        r114.addView(r106);
    }
}
