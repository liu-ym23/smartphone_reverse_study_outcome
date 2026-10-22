package com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.strategy;

import android.content.Context;
import android.os.Handler;
import com.bytedance.android.ec.model.promotion.ECUIPromotion;
import com.bytedance.android.ec.model.response.ECHotAtmosphere;
import com.bytedance.android.livesdk.livecommerce.ability.g;
import com.bytedance.android.livesdk.livecommerce.dynamiccontext.LiveDynamicContext;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.RoomContextController;
import com.bytedance.android.livesdk.livecommerce.room.store.ECContext;
import com.bytedance.android.livesdk.livecommerce.room.widgets.bottom_right.i;
import com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.ExplainCardViewModel;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.live.datacontext.n;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.cert.manager.constants.EventConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.kiwi.viewmodel.QLiveData;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import si2.e0;
import si2.f0;

/* JADX INFO: loaded from: classes10.dex */
public final class QueryWithMsgCacheCardShowStrategy implements com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.strategy.a {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final String f152655p = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile boolean f152656b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f152657c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public g f152658d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f152659e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public b f152660f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f152661g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.strategy.b f152662h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public com.bytedance.android.shopping.ligo.strategy.decision.scheduler.a f152663i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Runnable f152664j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Context f152665k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.strategy.a f152666l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final i f152667m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final tk2.b f152668n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final boolean f152669o;

    public static final class a {
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ QueryWithMsgCacheCardShowStrategy f152670a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.strategy.b f152671b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f152672c;

        public b(QueryWithMsgCacheCardShowStrategy r100, com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.strategy.b r101, boolean r102) {
            this.f152670a = r100;
            this.f152671b = r101;
            this.f152672c = r102;
        }

        public final void a() {
            dm.a.b r100 = dm.a.f469202a;
            dm.a.a(QueryWithMsgCacheCardShowStrategy.f152655p).a("real exec cancel msg, promotionId=" + this.f152671b.f152684c);
            this.f152670a.f152666l.p(this.f152671b, this.f152672c);
            this.f152670a.f("FromMsg");
            fk2.a r101 = this.f152670a.f152667m.g();
            if (r101 == null) goto L6;
            r101.a(this.f152671b, false);
            return;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class c implements com.bytedance.android.shopping.ligo.strategy.decision.scheduler.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ QueryWithMsgCacheCardShowStrategy f152673a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ECUIPromotion f152674b;

        @Override // com.bytedance.android.shopping.ligo.strategy.decision.scheduler.b
        public final void b() {
        }

        @Override // com.bytedance.android.shopping.ligo.strategy.decision.scheduler.b
        public final void a() {
            this.f152673a.i().post(new com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.strategy.c(this));
        }

        public c(QueryWithMsgCacheCardShowStrategy r100, ECUIPromotion r101) {
            this.f152673a = r100;
            this.f152674b = r101;
        }
    }

    public static final class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.android.livesdk.livecommerce.ability.f f152675a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.android.shopping.ligo.strategy.decision.scheduler.a f152676b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ QueryWithMsgCacheCardShowStrategy f152677c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ ECUIPromotion f152678d;

        public d(com.bytedance.android.livesdk.livecommerce.ability.f r100, com.bytedance.android.shopping.ligo.strategy.decision.scheduler.a r101, QueryWithMsgCacheCardShowStrategy r102, ECUIPromotion r103) {
            this.f152675a = r100;
            this.f152676b = r101;
            this.f152677c = r102;
            this.f152678d = r103;
        }

        public final void a() {
            dm.a.b r100 = dm.a.f469202a;
            dm.a.a(QueryWithMsgCacheCardShowStrategy.f152655p).a(">>> start show card runnable, promotionId=" + this.f152678d.getPromotionId());
            Lazy r101 = LiveDynamicContext.f147714c;
            LiveDynamicContext.a.a().a().a(this.f152677c.f152665k, this.f152675a, this.f152676b);
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.strategy.a
    public final void g(String r100, ECHotAtmosphere r101) {
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.strategy.a
    public final void h() {
    }

    public final Handler i() {
        return (Handler) this.f152659e.getValue();
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.strategy.a
    public final void j(ECUIPromotion r100) {
    }

    static {
        f152655p = QueryWithMsgCacheCardShowStrategy.class.getSimpleName();
    }

    public final void c() {
        dm.a.b r100 = dm.a.f469202a;
        dm.a.a(f152655p).a("clearDelayedTask");
        b r101 = this.f152660f;
        if (r101 == null) goto L5;
        i().removeCallbacks(r101);
    L5:
        this.f152660f = null;
        this.f152661g = 0;
        this.f152662h = null;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.strategy.a
    public final void o() {
        f("LiveEnd");
        i().removeCallbacksAndMessages(null);
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.strategy.a
    public final void a(boolean r100) {
        com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.strategy.a.b.a(r100);
        this.f152666l.a(r100);
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.strategy.a
    public final void d(ECUIPromotion r100) {
        Intrinsics.checkNotNullParameter(r100, "uiPromotion");
        if (this.f152656b == true) goto L5;
        return;
    L5:
        this.f152666l.d(r100);
        dm.a.b r101 = dm.a.f469202a;
        dm.a.a(f152655p).a("START scheduler, enter room, promotionId=" + r100.getPromotionId());
        f("EnterRoom");
        q(r100);
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.strategy.a
    public final void e(boolean r100) {
        this.f152666l.e(r100);
    }

    public final void f(String r100) {
        dm.a.b r101 = dm.a.f469202a;
        String r102 = f152655p;
        dm.a.a(r102).a("startClearAllTasks, reason=".concat(r100));
        c();
        dm.a.a(r102).a("cancelDelayStart");
        Runnable r103 = this.f152664j;
        if (r103 == null) goto L5;
        i().removeCallbacks(r103);
    L5:
        Runnable r104 = this.f152664j;
        if (r104 == null) goto L8;
        i().removeCallbacks(r104);
    L8:
        this.f152664j = null;
        dm.a.a(r102).a("cancelScheduler");
        com.bytedance.android.shopping.ligo.strategy.decision.scheduler.a r105 = this.f152663i;
        if (r105 == null) goto L11;
        r105.cancel();
    L11:
        com.bytedance.android.shopping.ligo.strategy.decision.scheduler.a r106 = this.f152663i;
        if (r106 == null) goto L14;
        r106.cancel();
    L14:
        this.f152663i = null;
        dm.a.a(r102).a("endClearAllTasks");
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.strategy.a
    public final void k(boolean r100) {
        com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.strategy.a.b.b(r100);
        this.f152666l.k(r100);
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.strategy.a
    public final void m(ECLiveCardPanelType r100) {
        Intrinsics.checkNotNullParameter(r100, "panelType");
        Intrinsics.checkNotNullParameter(r100, "panelType");
    }

    public final void q(ECUIPromotion r110) {
        if (r110 != null) goto L4;
        return;
    L4:
        g r100 = this.f152658d;
        if (r100 != null) goto L7;
        return;
    L7:
        boolean r101 = r110.isAuction();
        String r102 = f152655p;
        if (r101 == false) goto L11;
        dm.a.a(r102).a("auction card cannot auto schedule, skipped.");
        f("AuctionCard");
        return;
    L11:
        c93.b r103 = r100.c();
        int r104 = 0;
        if (r103 == null) goto L14;
        int r105 = r103.c();
    L16:
        if (r105 != 0) goto L18;
        boolean r106 = true;
    L19:
        Intrinsics.checkNotNullParameter(r100, "$this$convert2Standard");
        String r107 = r100.d();
        com.bytedance.android.shopping.ligo.strategy.decision.scheduler.a r108 = null;
        if (r107 == null) goto L24;
        String r109 = r100.a();
        if (r109 == null) goto L24;
        com.bytedance.android.livesdk.livecommerce.ability.f r111 = new com.bytedance.android.livesdk.livecommerce.ability.f(r107, r109, com.bytedance.android.livesdk.livecommerce.eventcenter.b.a(r109, r100.b()));
    L26:
        if (r111 == null) goto L56;
        dm.a.a(r102).a(">>> [" + (System.currentTimeMillis() / 1000) + "] start scheduler, promotionId=" + r110.getPromotionId() + ", title=" + r110.title + ", skip_first=" + r106);
        int r112 = RoomContextController.f151593h;
        ECContext r113 = RoomContextController.a.a().r();
        if (r113 == null) goto L32;
        n<ECUIPromotion> r114 = r113.getExplainPromotion();
        if (r114 == null) goto L32;
        r114.setValue(r110);
    L32:
        int r115 = com.bytedance.android.shopping.ligo.strategy.decision.scheduler.e.f176479a;
        c93.b r116 = r100.c();
        c r117 = new c(this, r110);
        if (r116 != null) goto L35;
        com.bytedance.android.shopping.ligo.strategy.decision.scheduler.a r118 = new com.bytedance.android.shopping.ligo.strategy.decision.scheduler.c(r117);
    L45:
        dm.a.b r119 = dm.a.a(r102);
        StringBuilder r120 = new StringBuilder("new scheduler [");
        if (r118 == null) goto L48;
        r104 = r118.hashCode();
    L48:
        r120.append(r104);
        r120.append(']');
        r119.a(r120.toString());
        d r121 = new d(r111, r118, this, r110);
        Runnable r122 = this.f152664j;
        if (r122 == null) goto L51;
        i().removeCallbacks(r122);
    L51:
        this.f152664j = r121;
        i().post(r121);
        com.bytedance.android.shopping.ligo.strategy.decision.scheduler.a r123 = this.f152663i;
        if (r123 == null) goto L54;
        r123.cancel();
    L54:
        this.f152663i = r118;
        return;
    L35:
        int r124 = r116.getType();
        if (r124 == 0) goto L43;
        if (r124 != 1) goto L39;
        r108 = new com.bytedance.android.shopping.ligo.strategy.decision.scheduler.d(r116.c(), r117);
    L44:
        r118 = r108;
        goto L45
    L39:
        if (r124 == 2) goto L41;
        int r125 = ye3.a.f567389a;
        String r126 = "create scheduler fail, pls check type or params: " + r116;
        Intrinsics.checkNotNullParameter(BdpAppEventConstant.PARAMS_STRATEGY_NAME, EventConstant.Key.MODULE);
        Intrinsics.checkNotNullParameter(r126, "message");
        dm.a.a("LIGO").w("[strategy] " + r126, null);
        goto L44
    L41:
        r108 = new com.bytedance.android.shopping.ligo.strategy.decision.scheduler.f(r116.c(), r116.a(), r116.b(), r106, r117);
        goto L44
    L43:
        r108 = new com.bytedance.android.shopping.ligo.strategy.decision.scheduler.c(r117);
        goto L44
    L56:
        return;
    L24:
        r111 = null;
        goto L26
    L18:
        r106 = false;
        goto L19
    L14:
        r105 = 0;
        goto L16
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.strategy.a
    public final void p(com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.strategy.b r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "message");
        if (this.f152656b == true) goto L8;
        this.f152666l.p(r100, r101);
        fk2.a r102 = this.f152667m.g();
        if (r102 == null) goto L32;
        r102.a(r100, false);
        return;
    L32:
        return;
    L8:
        dm.a.b r103 = dm.a.f469202a;
        dm.a.a(f152655p).a("recv cancel msg, promotionId=" + r100.f152684c + ", bubbleType=" + r100.f152683b);
        boolean r104 = true;
        if (r100.f152683b != 0) goto L12;
        if (r101 == true) goto L12;
        boolean r105 = true;
    L13:
        if (r105 == false) goto L28;
        ExplainCardViewModel r106 = this.f152667m.j();
        if (r106 == null) goto L23;
        QLiveData<ECUIPromotion> r107 = r106.getPromotionState();
        if (r107 == null) goto L23;
        ECUIPromotion r108 = r107.a();
        if (r108 == null) goto L23;
        if (r108.isAuction() != true) goto L23;
    L24:
        if (r104 == true) goto L28;
        if (this.f152669o == true) goto L28;
        c();
        b r109 = new b(this, r100, r101);
        this.f152660f = r109;
        this.f152661g = r100.f152684c;
        this.f152662h = r100;
        i().postDelayed(r109, this.f152657c);
        return;
    L23:
        r104 = false;
    L28:
        f("FromMsg");
        this.f152666l.p(r100, r101);
        fk2.a r110 = this.f152667m.g();
        if (r110 == null) goto L34;
        r110.a(r100, false);
        return;
    L34:
        return;
    L12:
        r105 = false;
        goto L13
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.strategy.a
    public final void b(com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.strategy.b r110, boolean r111, final Function1<? super ECUIPromotion, Unit> r112) {
        Intrinsics.checkNotNullParameter(r110, "msg");
        boolean r100 = false;
        if (this.f152656b == true) goto L8;
        this.f152666l.b(r110, r111, r112);
        fk2.a r113 = this.f152667m.g();
        if (r113 == null) goto L39;
        r113.a(r110, false);
        return;
    L39:
        return;
    L8:
        dm.a.b r101 = dm.a.f469202a;
        String r102 = f152655p;
        dm.a.a(r102).a("recv show msg, promotionId=" + r110.f152684c);
        if (r110.f152683b != 0) goto L12;
        if (r111 == true) goto L12;
        boolean r103 = true;
    L14:
        if (r103 == true) goto L16;
        dm.a.a(r102).a("NOT hit popcard cache, show new promotion, promotionId=" + r110.f152684c);
        f("FromMsg");
        this.f152666l.b(r110, r111, r112);
    L35:
        fk2.a r114 = this.f152667m.g();
        if (r114 == null) goto L40;
        r114.a(r110, r100);
        return;
    L40:
        return;
    L16:
        if (r110.f152684c != this.f152661g) goto L18;
        boolean r104 = true;
    L19:
        if (r104 == false) goto L33;
        com.bytedance.android.shopping.ligo.strategy.decision.scheduler.a r105 = this.f152663i;
        if (r105 != null) goto L23;
    L25:
        boolean r106 = false;
    L26:
        if (r106 == false) goto L33;
        com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.strategy.b r115 = this.f152662h;
        if (r115 == null) goto L32;
        fk2.a r116 = this.f152667m.g();
        if (r116 == null) goto L32;
        r116.a(r115, true);
    L32:
        c();
        dm.a.a(r102).a("HIT popcard cache, scheduler started, discard this msg, promotionId=" + r110.f152684c);
        r100 = true;
        goto L35
    L23:
        if (r105.isCompleted() == true) goto L25;
        r106 = true;
    L33:
        dm.a.a(r102).a("NOT hit popcard cache or schedulerNOTstarted, start scheduler, promotionId=" + r110.f152684c);
        f("FromMsg");
        this.f152666l.b(r110, r111, new QueryWithMsgCacheCardShowStrategy$onReceiveCardAppearMsg$2(this, r112));
        goto L35
    L18:
        r104 = false;
    L12:
        r103 = false;
        goto L14
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.strategy.a
    public final void l(f0 r100, boolean r101, boolean r102, Function1<? super ECUIPromotion, Unit> r103) {
        Intrinsics.checkNotNullParameter(r100, "message");
        Intrinsics.checkNotNullParameter(r103, "callback");
        com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.strategy.a r104 = this.f152666l;
        com.bytedance.android.shopping.ligo.strategy.decision.scheduler.a r105 = this.f152663i;
        if (r105 != null) goto L5;
    L7:
        boolean r106 = false;
    L8:
        r104.l(r100, r101, r106, r103);
        return;
    L5:
        if (r105.isCompleted() == true) goto L7;
        r106 = true;
        goto L8
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.strategy.a
    public final void n(e0 r100, boolean r101, boolean r102, Function2<? super ECUIPromotion, ? super Integer, Unit> r103) {
        Intrinsics.checkNotNullParameter(r100, "message");
        Intrinsics.checkNotNullParameter(r103, "callback");
        com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.strategy.a r104 = this.f152666l;
        com.bytedance.android.shopping.ligo.strategy.decision.scheduler.a r105 = this.f152663i;
        if (r105 != null) goto L5;
    L7:
        boolean r106 = false;
    L8:
        r104.n(r100, r101, r106, r103);
        return;
    L5:
        if (r105.isCompleted() == true) goto L7;
        r106 = true;
        goto L8
    }

    public QueryWithMsgCacheCardShowStrategy(Context r100, DefaultCardShowStrategy r101, i r102, ok2.a r103, tk2.a r104, boolean r105) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "defaultStrategy");
        Intrinsics.checkNotNullParameter(r102, "bottomRightCardLiveManager");
        Intrinsics.checkNotNullParameter(r103, "autoPopConfig");
        Intrinsics.checkNotNullParameter(r104, "cardFreqManager");
        this.f152665k = r100;
        this.f152666l = r101;
        this.f152667m = r102;
        this.f152668n = r104;
        this.f152669o = r105;
        this.f152659e = LazyKt.lazy(QueryWithMsgCacheCardShowStrategy$mainHandler$2.INSTANCE);
        if (r103.a() == null) goto L5;
        boolean r106 = true;
    L6:
        if (r106 == true) goto L9;
        r103 = null;
    L9:
        if (r103 == null) goto L11;
        this.f152657c = r103.b();
        this.f152658d = r103.a();
        this.f152656b = true;
    L11:
        dm.a.b r107 = dm.a.f469202a;
        dm.a.a(f152655p).a("config initialized=" + this.f152656b + ", cacheWaitTime=" + this.f152657c);
        return;
    L5:
        r106 = false;
        goto L6
    }
}
