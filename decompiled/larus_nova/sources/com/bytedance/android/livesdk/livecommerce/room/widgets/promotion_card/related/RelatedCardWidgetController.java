package com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.related;

import android.content.Context;
import android.os.SystemClock;
import android.view.View;
import android.widget.FrameLayout;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.ec.common.api.card.CardType;
import com.bytedance.android.ec.common.api.jump.model.LiveRoomParams;
import com.bytedance.android.ec.core.utils.ECQuickUtilKt;
import com.bytedance.android.ec.core.utils.OptCardUtil;
import com.bytedance.android.ec.model.promotion.ECUIPromotion;
import com.bytedance.android.livesdk.livecommerce.model.ProductInfo;
import com.bytedance.android.livesdk.livecommerce.opt.ECLivePerformanceMonitor;
import com.bytedance.android.livesdk.livecommerce.room.api.ControllerExtensionsKt;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.RoomContextController;
import com.bytedance.android.livesdk.livecommerce.room.quick.ActionObserver;
import com.bytedance.android.livesdk.livecommerce.room.quick.LiveRoomLifecycleOwner;
import com.bytedance.android.livesdk.livecommerce.room.store.ECContext;
import com.bytedance.android.livesdk.livecommerce.room.widgets.anim.BottomRightAnimController;
import com.bytedance.android.livesdk.livecommerce.room.widgets.bottom_right.BottomRightCardManager;
import com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.ExplainCardViewModel;
import com.bytedance.android.livesdk.livecommerce.utils.ECLiveDegradeHelper;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.livecommerce.utils.t0;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.kiwi.ui.QUIManager;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import sg2.y;

/* JADX INFO: loaded from: classes10.dex */
public final class RelatedCardWidgetController implements com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.related.b {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final /* synthetic */ int f152558s = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final gf.a f152559a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public com.bytedance.android.livesdk.livecommerce.room.widgets.bottom_right.h f152560b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f152561c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Map<String, ? extends Map<String, String>> f152562d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final QUIManager f152563e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ExplainCardViewModel f152564f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Disposable f152565g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f152566h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f152567i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f152568j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public w f152569k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Context f152570l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final ml.b f152571m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final BottomRightAnimController f152572n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final fk2.a f152573o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Function0<Unit> f152574p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final ef.a f152575q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final RoomContextController f152576r;

    public static final class a {
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RelatedCardWidgetController f152577a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f152578b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f152579c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Function1 f152580d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ Pair f152581e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.android.ec.model.response.s f152582f;

        public b(RelatedCardWidgetController r100, boolean r101, String r102, Function1 r103, Pair r104, com.bytedance.android.ec.model.response.s r105) {
            this.f152577a = r100;
            this.f152578b = r101;
            this.f152579c = r102;
            this.f152580d = r103;
            this.f152581e = r104;
            this.f152582f = r105;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f152577a.k(this.f152578b, false, this.f152579c, this.f152580d, this.f152581e, this.f152582f);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RelatedCardWidgetController f152583a;

        public c(RelatedCardWidgetController r100) {
            this.f152583a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.related.b.a.a(this.f152583a, null, null, 7);     // Catch: Throwable -> L4
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
        public final /* synthetic */ RelatedCardWidgetController f152587a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ECUIPromotion f152588b;

        public d(RelatedCardWidgetController r100, ECUIPromotion r101) {
            this.f152587a = r100;
            this.f152588b = r101;
        }

        @Override // io.reactivex.functions.Action
        public final void run() {
            com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.related.b.a.a(this.f152587a, this.f152588b.getPromotionId(), null, 6);
        }
    }

    public static final class e<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ECUIPromotion f152589a;

        public e(ECUIPromotion r100) {
            this.f152589a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            this.f152589a.exposureTime = (Long) r100;
        }
    }

    static {
    }

    public final ECLivePerformanceMonitor h() {
        if (this.f152559a.a() == false) goto L14;
        RoomContextController r100 = this.f152576r;
        ml.b r101 = this.f152571m;
        if (r101 == null) goto L7;
        String r102 = r101.roomId();
    L8:
        ECContext r103 = ControllerExtensionsKt.c(r100, r102).r();
        if (r103 == null) goto L15;
        com.bytedance.live.datacontext.i<ECLivePerformanceMonitor> r104 = r103.getEcLivePerformanceMonitor();
        if (r104 != null) goto L13;
        return null;
    L13:
        return r104.getValue();
    L15:
        return null;
    L7:
        r102 = null;
        goto L8
    L14:
        return null;
    }

    public final LifecycleOwner i() {
        Object r100 = null;
        LiveRoomLifecycleOwner r101 = null;
        r101 = null;
        if (this.f152559a.a() == false) goto L13;
        RoomContextController r102 = this.f152576r;
        ml.b r103 = this.f152571m;
        if (r103 == null) goto L7;
        String r104 = r103.roomId();
    L8:
        ECContext r105 = ControllerExtensionsKt.c(r102, r104).r();
        if (r105 == null) goto L18;
        com.bytedance.live.datacontext.i<LiveRoomLifecycleOwner> r106 = r105.getLifecycleOwner();
        if (r106 == null) goto L18;
        r101 = r106.getValue();
    L18:
        if (r101 == null) goto L20;
        return r101;
    L20:
        return ECQuickUtilKt.f45526b;
    L7:
        r104 = null;
        goto L8
    L13:
        Object r107 = com.bytedance.android.ec.sdk.plugin.e.getActivity(this.f152570l);
        if ((r107 instanceof LifecycleOwner) == false) goto L17;
        r100 = r107;
    L17:
        r101 = (LifecycleOwner) r100;
        goto L18
    }

    public static final boolean e(RelatedCardWidgetController r100) {
        if (r100.f152559a.a() == true) goto L5;
    L11:
        return false;
    L5:
        if (com.bytedance.android.livesdk.livecommerce.utils.n.c() == true) goto L7;
    L8:
        ECLiveDegradeHelper.f153042c.getClass();
        if (ECLiveDegradeHelper.c() != 1) goto L11;
        return true;
    L7:
        if (com.bytedance.android.livesdk.livecommerce.room.widgets.shoppingcart.a.C2352a.e(com.bytedance.android.livesdk.livecommerce.room.widgets.shoppingcart.a.f152743e) == true) goto L8;
        return true;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.related.b
    public final void a(String r100) {
        ECUIPromotion r101 = this.f152564f.getPromotionState().a();
        if (r101 != null) goto L5;
        return;
    L5:
        if (Intrinsics.areEqual(r101.getPromotionId(), r100) == false) goto L9;
        k(true, true, null, null, null, null);
        return;
    }

    public final void l(ECUIPromotion r100) {
        if ((!r100.isAuction()) == true) goto L6;
        return;
    L6:
        if (com.bytedance.android.ec.core.abtest.d.G() == false) goto L8;
        long r101 = com.bytedance.android.ec.core.abtest.d.H();
    L10:
        if (r101 > 0) goto L12;
        return;
    L12:
        Disposable r102 = this.f152565g;
        if (r102 == null) goto L15;
        r102.dispose();
    L15:
        int r103 = t0.f153116a;
        this.f152565g = bk2.c.a(t0.a(0, 1, TimeUnit.SECONDS).take(r101 + 1).observeOn(AndroidSchedulers.mainThread()).doOnComplete(new d(this, r100)).subscribe(new e(r100)), (bk2.d) this.f152561c.getValue());
        return;
    L8:
        r101 = r100.showDuration;
        goto L10
    }

    public static final void f(RelatedCardWidgetController r100, boolean r101) {
        r100.getClass();
        String r102 = null;
        OptCardUtil.b(null, "call onCardLoadFinish isShow=" + r101);
        if (r100.f152559a.a() == false) goto L9;
        RoomContextController r103 = r100.f152576r;
        ml.b r104 = r100.f152571m;
        if (r104 == null) goto L7;
        r102 = r104.roomId();
    L7:
        ControllerExtensionsKt.c(r103, r102).A().f151429t.Y();
        return;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.related.b
    public final void b(final String r100, final String r101) {
        this.f152575q.c(CardType.RELATED_CARD, new RelatedCardWidgetController$cancelCard$1(this, r100, r101));
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.related.b
    public final void c(String r100, ProductInfo r101) {
        Intrinsics.checkNotNullParameter(r100, "promotionId");
        Intrinsics.checkNotNullParameter(r101, "productInfo");
        ECUIPromotion r102 = this.f152564f.getPromotionState().a();
        if (r102 != null) goto L5;
        return;
    L5:
        if (Intrinsics.areEqual(r102.getPromotionId(), r100) == false) goto L15;
        String r103 = r101.title;
        if (r103 == null) goto L9;
        r102.title = r103;
    L9:
        String r104 = r101.cover;
        if (r104 == null) goto L12;
        r102.setCover(r104);
    L12:
        this.f152564f.getPromotionState().e(r102);
        return;
    }

    public static void j(final RelatedCardWidgetController r100, Function0 r101, int r102) {
        if ((r102 & 2) == 0) goto L5;
        Function0 r103 = null;
    L6:
        r100.f152566h = false;
        r100.f152567i = false;
        r100.f152568j = false;
        r100.f152569k = null;
        BottomRightAnimController r104 = r100.f152572n;
        ECUIPromotion r105 = r100.f152564f.getPromotionState().a();
        if (r105 == null) goto L10;
        String r106 = r105.getPromotionId();
        if (r106 == null) goto L10;
    L11:
        r104.f(new u(r100, null, r103, r106, r100.f152563e.p(), new RelatedCardWidgetController$hideExplainCard$2(r100)));
        return;
    L10:
        r106 = "";
        goto L11
    L5:
        r103 = r101;
        goto L6
    }

    public static final void d(final RelatedCardWidgetController r110, final ECUIPromotion r111, final boolean r112, final boolean r113, Function1 r210) {
        ECLivePerformanceMonitor r100 = r110.h();
        if (r100 == null) goto L5;
        r100.v("ec_perf_duration_shopping_related_card", CollectionsKt.listOf("render_start"), Long.valueOf(SystemClock.elapsedRealtime()));
    L5:
        if (r113 == true) goto L9;
        if (r111 != null) goto L9;
        UtilityKotlinExtentionsKt.f153057b.post(new t(r110));
    L9:
        if (r111 == null) goto L45;
        r110.f152574p.invoke();
        RoomContextController r101 = r110.f152576r;
        ml.b r102 = r110.f152571m;
        if (r102 == null) goto L13;
        String r103 = r102.roomId();
    L14:
        RoomContextController r104 = ControllerExtensionsKt.c(r101, r103);
        if (r113 == true) goto L22;
        if (r110.f152559a.a() == false) goto L22;
        y r105 = r104.f151594c;
        if (r105 == null) goto L22;
        r105.f(r111.getPromotionId());
    L22:
        if (r110.f152559a.a() == false) goto L27;
        com.bytedance.android.livesdk.livecommerce.room.utils.d r106 = r104.f151595d;
        String r107 = r111.getProductId();
        if (r107 != null) goto L26;
        r107 = "";
    L26:
        r106.getClass();
        Intrinsics.checkNotNullParameter(r107, "<set-?>");
        r106.f151935d = r107;
    L27:
        ECUIPromotion r108 = r110.f152564f.getPromotionState().a();
        if (r108 == null) goto L30;
        String r109 = r108.getPromotionId();
    L32:
        if (Intrinsics.areEqual(r109, r111.getProductId()) == false) goto L36;
        if (r112 == false) goto L35;
        r110.f152564f.getPromotionState().e(r111);
    L46:
        if (r210 == null) goto L49;
        Unit r114 = (Unit) r210.invoke(r111);
        return;
    L49:
        return;
    L35:
        r110.l(r111);
        goto L46
    L36:
        if (r108 == null) goto L38;
        j(r110, null, 3);
    L38:
        Function0<Unit> r115 = new RelatedCardWidgetController$handlePromotion$$inlined$let$lambda$1(r111, r110, r113, r111, r112);
        OptCardUtil.b(null, "call showExplainCard");
        r110.f152566h = false;
        r110.f152567i = false;
        r110.f152568j = false;
        r110.f152569k = null;
        ExplainCardViewModel r116 = r110.f152564f;
        BottomRightAnimController r117 = r110.f152572n;
        String r118 = r111.getPromotionId();
        if (r118 != null) goto L41;
        String r119 = "";
    L42:
        r117.f(new x(r110, r115, r116, r111, r113, r119, r110.f152563e.p(), new RelatedCardWidgetController$showExplainCard$2(r110, r116, r113)));
        fk2.a r120 = r110.f152573o;
        if (r120 == null) goto L46;
        r120.b(r110.f152559a.a(), r113, false, r111.getPromotionId(), true);
        goto L46
    L41:
        r119 = r118;
        goto L42
    L30:
        r109 = null;
        goto L32
    L13:
        r103 = null;
        goto L14
    L45:
        com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.related.b.a.a(r110, null, null, 7);
        goto L46
    }

    public final void g(String r110, Function1<? super ECUIPromotion, Unit> r111, boolean r112, Pair<Long, Long> r113, com.bytedance.android.ec.model.response.s r114) {
        this.f152575q.l(new ef.d(30, CardType.RELATED_CARD, new b(this, r112, r110, r111, r113, r114), new c(this)));
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void k(final boolean r110, final boolean r111, String r112, final Function1<? super ECUIPromotion, Unit> r210, Pair<Long, Long> r211, com.bytedance.android.ec.model.response.s r212) {
        if (r110 == true) goto L68;
        if (r111 == true) goto L68;
        if (this.f152559a.a() == false) goto L68;
        ml.b r100 = this.f152571m;
        Boolean r101 = null;
        ECLivePerformanceMonitor r102 = null;
        r102 = null;
        r101 = null;
        if (r100 == null) goto L66;
        String r103 = r100.roomId();
        if (r103 == null) goto L66;
        com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.p r104 = this.f152576r.A().f151429t.V;
        dm.a.a("LiveCardLoader").i("try to consume related card data, instantRoomCardLoader = " + r104);
        PromotionCardLoadOptUtils.f152542p.getClass();
        final PromotionCardLoadOptUtils r105 = PromotionCardLoadOptUtils.Companion.c(r103);
        final Function1<ECUIPromotion, Unit> r106 = new RelatedCardWidgetController$queryPromotion$$inlined$let$lambda$1(this, r111, r210);
        Intrinsics.checkNotNullParameter(r106, "callback");
        OptCardUtil.b(null, "consumeCachedPromotion isCacheAvailable=" + r105.f152547e);
        dm.a.b r107 = dm.a.a("LiveCardLoad");
        StringBuilder r113 = new StringBuilder("consume related card promotion, isInstant = ");
        boolean r114 = false;
        boolean r115 = true;
        if (r104 == null) goto L14;
        boolean r116 = true;
    L15:
        r113.append(r116);
        r107.i(r113.toString());
        if (r104 == null) goto L32;
        Function1<ECUIPromotion, Unit> r108 = new PromotionCardLoadOptUtils$consumeCachedPromotion$1(r106);
        Intrinsics.checkNotNullParameter(r108, "callback");
        com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.p.a("getRelatedCardData, isApiLoading = " + r104.f152283b);
        if (r104.f152283b == false) goto L20;
        r104.f152285d = r108;
    L64:
        r101 = Boolean.valueOf(r115);
        goto L66
    L20:
        com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.p.a r109 = r104.f152284c;
        if (r109 == null) goto L64;
        ECUIPromotion r117 = r109.f152289a;
        ECUIPromotion r118 = r109.f152290b;
        if (r118 != null) goto L25;
        r108.invoke(null);
        goto L64
    L25:
        if (r117 == null) goto L27;
        long r119 = r117.showPriority;
    L29:
        if (r119 < r118.showPriority) goto L31;
        r108.invoke(null);
        goto L64
    L31:
        r108.invoke(r118);
        r104.b(r118);
        goto L64
    L27:
        r119 = 0;
        goto L29
    L32:
        com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.y.f152727o.getClass();
        boolean r120 = com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.y.f152722j;
        if (r120 == true) goto L38;
        if (com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.t.f152699f == true) goto L38;
    L58:
        com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.related.a r121 = r105.f152555m;
        ECContext r122 = r105.f152550h;
        if (r122 == null) goto L63;
        com.bytedance.live.datacontext.i<ECLivePerformanceMonitor> r123 = r122.getEcLivePerformanceMonitor();
        if (r123 == null) goto L63;
        r102 = r123.getValue();
    L63:
        r121.d(r102, r105.f152547e);
        r115 = r114;
    L38:
        if (r105.f152543a == false) goto L41;
        r105.f152549g = new PromotionCardLoadOptUtils$consumeCachedPromotion$2(r105, r106);
    L57:
        r114 = true;
        goto L58
    L41:
        if (r105.f152547e == false) goto L58;
        com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.related.a r124 = r105.f152555m;
        ECContext r125 = r105.f152550h;
        if (r125 == null) goto L47;
        com.bytedance.live.datacontext.i<ECLivePerformanceMonitor> r126 = r125.getEcLivePerformanceMonitor();
        if (r126 == null) goto L47;
        ECLivePerformanceMonitor r127 = r126.getValue();
    L48:
        r124.d(r127, true);
        r106.invoke(r105.f152546d);
        if (r120 == false) goto L57;
        com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.related.a r128 = r105.f152555m;
        ECContext r129 = r105.f152550h;
        if (r129 == null) goto L55;
        com.bytedance.live.datacontext.i<ECLivePerformanceMonitor> r130 = r129.getEcLivePerformanceMonitor();
        if (r130 == null) goto L55;
        ECLivePerformanceMonitor r131 = r130.getValue();
    L56:
        r128.a(r131, r105.f152544b, r105.f152545c);
    L55:
        r131 = null;
    L47:
        r127 = null;
        goto L48
    L14:
        r116 = false;
    L66:
        if (Intrinsics.areEqual(r101, Boolean.TRUE) == false) goto L68;
        return;
    L68:
        if (r110 == false) goto L72;
        ECLivePerformanceMonitor r132 = h();
        if (r132 == null) goto L72;
        r132.t(r110, this.f152576r.A().f151429t.U);
    L72:
        ExplainCardViewModel r133 = this.f152564f;
        ECLivePerformanceMonitor r134 = h();
        if (r134 == null) goto L75;
        r134.u("ec_perf_duration_shopping_related_card", "request_start", Long.valueOf(SystemClock.elapsedRealtime()));
    L75:
        if (r133 == null) goto L78;
        ExplainCardViewModel.queryPopPromotion$default(r133, r112, !r110, r211, r212, null, null, new RelatedCardWidgetController$queryPromotion$2(this, r111, r110, r210), 48, null);
        return;
    }

    public RelatedCardWidgetController(Context r110, ml.b r111, LiveRoomParams r112, BottomRightCardManager.b r113, BottomRightAnimController r114, fk2.a r115, int r210, cf.c r211, Function0 r212, ef.a r213, RoomContextController r214) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r113, "rootView");
        Intrinsics.checkNotNullParameter(r114, "animController");
        Intrinsics.checkNotNullParameter(r211, "btmInfo");
        Intrinsics.checkNotNullParameter(r212, "onRealShowRelated");
        Intrinsics.checkNotNullParameter(r213, "cardManager");
        Intrinsics.checkNotNullParameter(r214, "roomContextController");
        this.f152570l = r110;
        this.f152571m = r111;
        this.f152572n = r114;
        this.f152573o = r115;
        this.f152574p = r212;
        this.f152575q = r213;
        this.f152576r = r214;
        this.f152559a = new gf.a(r210);
        this.f152561c = LazyKt.lazy(RelatedCardWidgetController$disposableContext$2.INSTANCE);
        QUIManager r116 = new QUIManager();
        this.f152563e = r116;
        final ExplainCardViewModel r117 = new ExplainCardViewModel(new s(this), new gf.a(0), r111, r112, r211, jf.b.h.f498856b, r214);
        r117.setEventPassthroughParams(new RelatedCardWidgetController$$special$$inlined$also$lambda$1(this));
        r117.setCardCallback(new q(this));
        Unit r100 = Unit.INSTANCE;
        this.f152564f = r117;
        r116.l(new rk2.g(r117), r113.getContext(), true);
        r116.c(rk2.g.class, new r(this));
        r117.getClickCloseAction().b(i(), new ActionObserver(new RelatedCardWidgetController$observeData$1(this, r117)));
        View r101 = r116.p();
        FrameLayout.LayoutParams r102 = new FrameLayout.LayoutParams(r101.getLayoutParams());
        r102.gravity = 80;
        r101.setLayoutParams(r102);
        r113.addView(r101);
    }
}
