package com.bytedance.android.livesdk.livecommerce.room.widgets.bottom_right;

import android.content.ComponentCallbacks2;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.ec.common.api.card.CardType;
import com.bytedance.android.ec.common.api.jump.model.LiveRoomParams;
import com.bytedance.android.ec.core.abtest.ECSettingKeys;
import com.bytedance.android.ec.core.hybrid.utils.ECLiveHybridUtil;
import com.bytedance.android.ec.core.monitor.MetricNames;
import com.bytedance.android.ec.core.opt.ab.p;
import com.bytedance.android.ec.core.utils.ECQuickUtilKt;
import com.bytedance.android.ec.core.utils.OptCardUtil;
import com.bytedance.android.ec.model.promotion.ECUICampaign;
import com.bytedance.android.ec.model.promotion.ECUIPromotion;
import com.bytedance.android.ec.model.response.s;
import com.bytedance.android.ec.opt.messagequeue.ForceDoFrameMessage;
import com.bytedance.android.livesdk.livecommerce.ab.ECLiveABUtils;
import com.bytedance.android.livesdk.livecommerce.event.l0;
import com.bytedance.android.livesdk.livecommerce.eventcenter.LiveEventCenter;
import com.bytedance.android.livesdk.livecommerce.opt.ECLivePerformanceMonitor;
import com.bytedance.android.livesdk.livecommerce.room.api.ControllerExtensionsKt;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.EntryController;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.RoomContextController;
import com.bytedance.android.livesdk.livecommerce.room.controller.related.IRelatedInfoManager$Scene;
import com.bytedance.android.livesdk.livecommerce.room.widgets.anim.BottomRightAnimController;
import com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.ExplainCardLiveMessageListener;
import com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.ExplainCardWidgetController;
import com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.l;
import com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.m;
import com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.n;
import com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.ExplainCardViewModel;
import com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.related.RelatedCardMessageController;
import com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.related.RelatedCardWidgetController;
import com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.related.w;
import com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.t;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.disposables.Disposable;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import sg2.v;
import ti.j;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/room/widgets/bottom_right/BottomRightCardManager;", "Lcf/d;", "Lcom/bytedance/android/livesdk/livecommerce/room/widgets/bottom_right/i;", "Landroidx/lifecycle/LifecycleEventObserver;", "Lef/a;", "c", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class BottomRightCardManager implements cf.d, i, LifecycleEventObserver, ef.a {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final /* synthetic */ int f152005t = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final BottomRightAnimController f152006a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ExplainCardWidgetController f152007b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final RelatedCardWidgetController f152008c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ef.b f152009d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final gf.a f152010e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final b f152011f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f152012g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final d f152013h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f152014i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f152015j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.a f152016k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public RelatedCardMessageController f152017l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public com.bytedance.android.ec.core.frontier.c f152018m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Lazy f152019n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Context f152020o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final ml.b f152021p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final int f152022q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final RoomContextController f152023r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final /* synthetic */ ik2.a f152024s;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f152025a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ BottomRightCardManager f152026b;

        public a(b r100, BottomRightCardManager r101) {
            this.f152025a = r100;
            this.f152026b = r101;
        }

        public final void a() {
            Lazy r100 = ECSettingKeys.f43616a;
            int r101 = p.f45243a;
            Object r102 = 0;
            Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L7
            jj4.b r104 = jj4.b.f499326b;     // Catch: Throwable -> L7
            Object r105 = jj4.a.a("ecom_live_explain_card_click_area_extend_size", Integer.class, r102, false);     // Catch: Throwable -> L7
            if (r105 != null) goto L13;
            Intrinsics.throwNpe();     // Catch: Throwable -> L7
        L13:
            int r106 = ((Number) r105).intValue();
            if (r106 <= 0) goto L45;
            BottomRightCardManager r107 = this.f152026b;
            b r108 = this.f152025a;
            int r109 = BottomRightCardManager.f152005t;
            r107.getClass();
            int r110 = UtilityKotlinExtentionsKt.d(Integer.valueOf(r106));
            Rect r111 = new Rect();
            r111.left = 0;
            int r112 = 5;
            View r113 = r108;
        L16:
            Object r114 = null;
            if (r113 == null) goto L27;
            r113.getHitRect(r111);
            if (r111.left > r110) goto L27;
            Object r115 = r113.getParent();
            if ((r115 instanceof View) == true) goto L25;
            r115 = null;
        L25:
            r113 = (View) r115;
            r112 = r112 - 1;
            if (r112 > 0) goto L16;
        L27:
            if (r113 != null) goto L29;
            return;
        L29:
            if (r111.left == 0) goto L48;
            ViewParent r116 = r113.getParent();
            if ((r116 instanceof View) == false) goto L35;
            r114 = r116;
        L35:
            View r117 = (View) r114;
            if (r117 == null) goto L47;
            Rect r118 = new Rect(r111);
            r118.left -= r110;
            Unit r119 = Unit.INSTANCE;
            r117.setTouchDelegate(new g(r111, r118, r108));
            return;
        L47:
            return;
        L48:
            return;
        L45:
            return;
        L7:
            th = move-exception;
            Result.Companion r120 = Result.Companion;
            Object r121 = Result.m9449constructorimpl(ResultKt.createFailure(th));
            if (Result.m9455isFailureimpl(r121) == true) goto L12;
            r102 = r121;
        L12:
            r105 = r102;
            goto L13
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

    public static final class b extends FrameLayout {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BottomRightCardManager f152027a;

        @Override // android.view.ViewGroup, android.view.View
        public final void onAttachedToWindow() {
            super.onAttachedToWindow();
            if (this.f152027a.f152010e.a() == false) goto L10;
            OptCardUtil.b(null, "call onAttachedToWindow of card");
            OptCardUtil.f45547e = true;
            if (t.f152704k == true) goto L7;
            return;
        L7:
            if (Intrinsics.areEqual(t.f152710q, Boolean.TRUE) == false) goto L12;
            OptCardUtil.b(null, "call forceDoFrame");
            ForceDoFrameMessage.a();
            return;
        L12:
            return;
        }

        @Override // android.view.ViewGroup, android.view.View
        public final void dispatchDraw(Canvas r110) {
            Intrinsics.checkNotNullParameter(r110, "canvas");
            super.dispatchDraw(r110);
            if (this.f152027a.f152010e.a() == false) goto L60;
            ExplainCardWidgetController r111 = this.f152027a.f152007b;
            if (r111 != null) goto L7;
        L36:
            RelatedCardWidgetController r112 = this.f152027a.f152008c;
            if (r112 != null) goto L39;
            return;
        L39:
            if (r112.f152559a.a() == true) goto L41;
            return;
        L41:
            if (r112.f152567i == false) goto L46;
            r112.f152567i = false;
            ECLivePerformanceMonitor r100 = r112.h();
            if (r100 == null) goto L46;
            r100.u("ec_perf_duration_shopping_related_card", "card_visible_end", Long.valueOf(SystemClock.elapsedRealtime()));
        L46:
            if (r112.f152568j == false) goto L52;
            r112.f152568j = false;
            ECLivePerformanceMonitor r101 = r112.h();
            if (r101 == null) goto L50;
            r101.u("ec_perf_duration_shopping_related_card", "main_image_visible_end", Long.valueOf(SystemClock.elapsedRealtime()));
        L50:
            r112.f152569k = new w(r112);
        L52:
            if (r112.f152566h == false) goto L58;
            w r102 = r112.f152569k;
            if (r102 == null) goto L58;
            r112.f152566h = false;
            r102.run();
            r112.f152569k = null;
            ECLivePerformanceMonitor r113 = r112.h();
            if (r113 == null) goto L58;
            ECLivePerformanceMonitor.w(r113, "ec_perf_duration_shopping_related_card", null, null, 6);
        L58:
            OptCardUtil.b(null, "call dispatchDraw of card");
            return;
        L7:
            if (r111.f152200a.a() == false) goto L36;
            if (r111.f152214o == false) goto L16;
            r111.f152214o = false;
            ECLivePerformanceMonitor r103 = r111.h();
            if (r103 == null) goto L16;
            r103.u("ec_perf_duration_shopping_card", "card_visible_end", Long.valueOf(SystemClock.elapsedRealtime()));
            String r104 = r103.f149762p;
            if (r104 == null) goto L16;
            Map<String, com.bytedance.android.ec.core.monitor.a> r105 = com.bytedance.android.ec.core.monitor.c.f45142a;
            com.bytedance.android.ec.core.monitor.c.j(r104, MetricNames.POP_CARD_VISIBLE_DURATION);
        L16:
            if (r111.f152215p == false) goto L24;
            r111.f152215p = false;
            ECLivePerformanceMonitor r106 = r111.h();
            if (r106 == null) goto L22;
            r106.u("ec_perf_duration_shopping_card", "main_image_visible_end", Long.valueOf(SystemClock.elapsedRealtime()));
            String r107 = r106.f149762p;
            if (r107 == null) goto L22;
            Map<String, com.bytedance.android.ec.core.monitor.a> r108 = com.bytedance.android.ec.core.monitor.c.f45142a;
            com.bytedance.android.ec.core.monitor.c.j(r107, MetricNames.POP_CARD_MAIN_IMAGE_VISIBLE_DURATION);
        L22:
            r111.f152216q = new com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.i(r111);
        L24:
            if (r111.f152213n == false) goto L35;
            com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.i r109 = r111.f152216q;
            if (r109 == null) goto L35;
            r111.f152213n = false;
            r109.run();
            r111.f152216q = null;
            if (r111.f152217r == false) goto L35;
            ECLivePerformanceMonitor r114 = r111.h();
            if (r114 == null) goto L35;
            ECLivePerformanceMonitor.w(r114, "ec_perf_duration_shopping_card", null, null, 6);
            String r115 = r114.f149762p;
            if (r115 == null) goto L34;
            UtilityKotlinExtentionsKt.f153057b.post(new com.bytedance.android.livesdk.livecommerce.opt.b(r115));
        L34:
            r114.f149762p = null;
        L35:
            OptCardUtil.b(null, "call dispatchDraw of card");
            goto L36
        }

        public b(BottomRightCardManager r100, Context r101) {
            this.f152027a = r100;
            super(r101);
        }

        @Override // android.widget.FrameLayout, android.view.View
        public final void onMeasure(int r100, int r101) {
            super.onMeasure(r100, r101);
            if (this.f152027a.f152010e.a() == false) goto L8;
            boolean r102 = OptCardUtil.f45543a;
            if (OptCardUtil.f45547e == false) goto L9;
            OptCardUtil.f45547e = false;
            OptCardUtil.b(null, "call onMeasure of card");
            return;
        L9:
            return;
        }
    }

    public static final class c {
    }

    public static final class d implements j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BottomRightCardManager f152028a;

        public d(BottomRightCardManager r100) {
            this.f152028a = r100;
        }

        @Override // ti.j
        public final void a(JSONObject r110) {
            Intrinsics.checkNotNullParameter(r110, "params");
            ExplainCardWidgetController r100 = this.f152028a.f152007b;
            if (r100 == null) goto L15;
            Intrinsics.checkNotNullParameter(r110, "params");
            ECUIPromotion r101 = r100.f152204e.getPromotionState().a();
            if (r101 == null) goto L15;
            int r102 = r110.optInt("campaignType", -1);
            if (r102 != (-1)) goto L9;
        L14:
            n.a.a(r100, r101.getProductId(), null, 6);
            goto L15
        L9:
            if (r101.isCampaign == false) goto L15;
            ECUICampaign r103 = r101.campaign;
            if (r103 == null) goto L15;
            if (r102 == r103.campaignType) goto L14;
        L15:
            RelatedCardWidgetController r104 = this.f152028a.f152008c;
            if (r104 == null) goto L29;
            Intrinsics.checkNotNullParameter(r110, "params");
            ECUIPromotion r105 = r104.f152564f.getPromotionState().a();
            if (r105 == null) goto L30;
            int r111 = r110.optInt("campaignType", -1);
            if (r111 != (-1)) goto L22;
        L27:
            com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.related.b.a.a(r104, r105.getProductId(), null, 6);
            return;
        L22:
            if (r105.isCampaign == false) goto L31;
            ECUICampaign r106 = r105.campaign;
            if (r106 != null) goto L26;
            return;
        L26:
            if (r111 == r106.campaignType) goto L27;
            return;
        L31:
            return;
        L30:
            return;
        }
    }

    static {
    }

    @Override // ef.a
    public final void c(CardType r100, Runnable r101) {
        Intrinsics.checkNotNullParameter(r100, "cardType");
        this.f152024s.c(r100, r101);
    }

    @Override // ef.a
    public final void l(ef.d r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        this.f152024s.l(r100);
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.widgets.bottom_right.i
    public final void b() {
        dm.a.a("BottomRightCardManager").i("Receive bridge event, cancel external card.");
        ef.b r100 = this.f152009d;
        if (r100 == null) goto L6;
        r100.b();
        return;
    }

    @Override // cf.d
    public final void d() {
        boolean r100 = t.f152699f;
        t.a.a(this.f152020o);
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.widgets.bottom_right.i
    public final fk2.a g() {
        return (fk2.a) this.f152019n.getValue();
    }

    @Override // cf.d
    public final View getView() {
        if (this.f152014i == false) goto L18;
        this.f152014i = false;
        ComponentCallbacks2 r100 = com.bytedance.android.ec.sdk.plugin.e.getActivity(this.f152020o);
        if ((r100 instanceof LifecycleOwner) == true) goto L7;
        r100 = null;
    L7:
        LifecycleOwner r101 = (LifecycleOwner) r100;
        if (r101 != null) goto L10;
        r101 = ECQuickUtilKt.f45526b;
    L10:
        r101.getLifecycle().addObserver(this);
        s();
        ExplainCardWidgetController r102 = this.f152007b;
        if (r102 == null) goto L18;
        if (r102.f152209j == false) goto L18;
        if (r102.f152200a.a() == true) goto L18;
        n.a.b(r102);
    L18:
        return this.f152011f;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.widgets.bottom_right.i
    public final ExplainCardViewModel j() {
        ExplainCardWidgetController r100 = this.f152007b;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.f152204e;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.widgets.bottom_right.i
    public final Context n() {
        return this.f152011f.getContext();
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.widgets.bottom_right.i
    public final void r() {
        ExplainCardWidgetController r100 = this.f152007b;
        if (r100 == null) goto L6;
        r100.l(null, null, null);
        return;
    }

    public final void s() {
        if (this.f152015j == false) goto L6;
        return;
    L6:
        if (this.f152010e.f481036a != 1) goto L8;
        boolean r100 = true;
    L9:
        String r101 = null;
        if (r100 == false) goto L17;
        this.f152016k = new com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.a(new WeakReference(this.f152011f.getContext()), this);
        ml.b r102 = this.f152021p;
        if (r102 == null) goto L14;
        String r103 = r102.roomId();
    L15:
        com.bytedance.android.ec.core.frontier.c r104 = new com.bytedance.android.ec.core.frontier.c("StoreLiveRoom", r103);
        this.f152018m = r104;
        UtilityKotlinExtentionsKt.f(this.f152016k, r104, BottomRightCardManager$registerMessage$1.INSTANCE);
        goto L17
    L14:
        r103 = null;
    L17:
        if (this.f152010e.a() == true) goto L19;
    L39:
        this.f152015j = true;
        return;
    L19:
        if (ECLiveABUtils.INSTANCE.getENABLE_CONTROLLER_OPT() == false) goto L22;
        com.bytedance.android.livesdk.livecommerce.room.controller.business.n r105 = this.f152023r.A().f151426q;
    L29:
        Context r106 = this.f152020o;
        ml.b r107 = this.f152021p;
        if (r107 == null) goto L32;
        String r108 = r107.roomId();
    L33:
        r105.f151647f = new ExplainCardLiveMessageListener(r106, this, r108, r105);
        RelatedCardWidgetController r109 = this.f152008c;
        if (r109 == null) goto L39;
        this.f152017l = new RelatedCardMessageController(r109);
        RoomContextController r110 = this.f152023r;
        ml.b r111 = this.f152021p;
        if (r111 == null) goto L38;
        r101 = r111.roomId();
    L38:
        ControllerExtensionsKt.c(r110, r101).A().f151426q.f151646e = this.f152017l;
        goto L39
    L32:
        r108 = null;
        goto L33
    L22:
        if (this.f152023r.v() == false) goto L24;
        r105 = this.f152023r.A().f151426q;
        goto L29
    L24:
        int r112 = com.bytedance.android.livesdk.livecommerce.room.controller.business.n.f151643o;
        ml.b r113 = this.f152021p;
        if (r113 == null) goto L27;
        String r114 = r113.roomId();
    L28:
        r105 = com.bytedance.android.livesdk.livecommerce.room.controller.business.n.a.a(r114, this.f152023r.D());
        goto L29
    L27:
        r114 = null;
        goto L28
    L8:
        r100 = false;
        goto L9
    }

    public final void t() {
        RelatedCardWidgetController r100 = this.f152008c;
        if (r100 == null) goto L6;
        r100.g(null, null, false, null, null);
        return;
    }

    public final void u() {
        if (this.f152015j == true) goto L5;
        return;
    L5:
        UtilityKotlinExtentionsKt.f(this.f152016k, this.f152018m, new BottomRightCardManager$unRegisterMessage$1(this));
        if (this.f152010e.a() == false) goto L15;
        this.f152017l = null;
        if (this.f152023r.v() == false) goto L10;
        com.bytedance.android.livesdk.livecommerce.room.controller.business.n r100 = this.f152023r.A().f151426q;
        r100.f151647f = null;
        r100.f151646e = null;
        r100.f151651j = null;
        goto L15
    L10:
        RoomContextController r101 = this.f152023r;
        ml.b r102 = this.f152021p;
        if (r102 == null) goto L13;
        String r103 = r102.roomId();
    L14:
        com.bytedance.android.livesdk.livecommerce.room.controller.business.n r104 = ControllerExtensionsKt.c(r101, r103).A().f151426q;
        r104.f151647f = null;
        r104.f151646e = null;
        r104.f151651j = null;
        goto L15
    L13:
        r103 = null;
    L15:
        this.f152015j = false;
    }

    @Override // cf.d
    public final void onDestroy() {
        u();
        ECLiveHybridUtil.p("closeExplainCard", this.f152013h);
        ComponentCallbacks2 r100 = com.bytedance.android.ec.sdk.plugin.e.getActivity(this.f152020o);
        if ((r100 instanceof LifecycleOwner) == true) goto L5;
        r100 = null;
    L5:
        LifecycleOwner r101 = (LifecycleOwner) r100;
        if (r101 != null) goto L8;
        r101 = ECQuickUtilKt.f45526b;
    L8:
        r101.getLifecycle().removeObserver(this);
        ExplainCardWidgetController r102 = this.f152007b;
        if (r102 == null) goto L17;
        r102.f152212m = true;
        ((bk2.d) r102.f152206g.getValue()).clearDisposable();
        Disposable r103 = r102.f152205f;
        if (r103 == null) goto L13;
        r103.dispose();
    L13:
        r102.f152205f = null;
        Runnable r104 = r102.f152207h;
        if (r104 == null) goto L16;
        UtilityKotlinExtentionsKt.f153057b.removeCallbacks(r104);
    L16:
        r102.f152207h = null;
        r102.f152203d.r(rk2.g.class);
        r102.f152204e.onDestroy();
        Lazy r105 = LiveEventCenter.f147750b;
        LiveEventCenter.a.a().a(r102.f152208i);
    L17:
        RelatedCardWidgetController r106 = this.f152008c;
        if (r106 == null) goto L23;
        ((bk2.d) r106.f152561c.getValue()).clearDisposable();
        Disposable r107 = r106.f152565g;
        if (r107 == null) goto L22;
        r107.dispose();
    L22:
        r106.f152565g = null;
        r106.f152563e.r(rk2.g.class);
        r106.f152564f.onDestroy();
    L23:
        ef.b r108 = this.f152009d;
        if (r108 == null) goto L26;
        r108.a(false);
    L26:
        BottomRightAnimController r109 = this.f152006a;
        r109.f151970h.set(true);
        Iterator<T> r110 = r109.f151969g.iterator();
    L28:
        if (r110.hasNext() == false) goto L30;
        ((Handler) r109.f151967e.getValue()).removeCallbacksAndMessages((Message) r110.next());
        goto L28
    L30:
        Iterator<T> r111 = r109.f151968f.iterator();
    L32:
        if (r111.hasNext() == false) goto L34;
        r109.f151966d.removeCallbacksAndMessages((Message) r111.next());
        goto L32
    L34:
        this.f152024s.b();
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.widgets.bottom_right.i
    public final RoomContextController i() {
        return this.f152023r;
    }

    @Override // cf.d
    public final void a(com.bytedance.android.livesdk.livecommerce.saascoupon.e r100) {
        Intrinsics.checkNotNullParameter(r100, "cardControllerProvider");
        if (this.f152009d == null) goto L5;
        return;
    L5:
        com.bytedance.android.livesdk.livecommerce.saascoupon.lynxcoupon.a r101 = r100.a(this.f152020o, this.f152022q, l0.l(), this.f152006a, new com.bytedance.android.livesdk.livecommerce.room.widgets.bottom_right.b(this), this);
        r101.c();
        Unit r102 = Unit.INSTANCE;
        this.f152009d = r101;
    }

    @Override // cf.d
    public final void e(Map<String, ? extends Map<String, String>> r100) {
        ExplainCardWidgetController r101 = this.f152007b;
        RelatedCardWidgetController r102 = null;
        if ((r101 instanceof ExplainCardWidgetController) == true) goto L5;
        r101 = null;
    L5:
        if (r101 == null) goto L7;
        r101.f152218s = r100;
    L7:
        RelatedCardWidgetController r103 = this.f152008c;
        if ((r103 instanceof RelatedCardWidgetController) == false) goto L11;
        r102 = r103;
    L11:
        if (r102 == null) goto L14;
        r102.f152562d = r100;
        return;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.widgets.bottom_right.i
    public final void f(ECUIPromotion r100) {
        Intrinsics.checkNotNullParameter(r100, "uiPromotion");
        ExplainCardWidgetController r101 = this.f152007b;
        if (r101 == null) goto L12;
        Intrinsics.checkNotNullParameter(r100, "uiPromotion");
        ECUIPromotion r102 = r101.f152204e.getPromotionState().a();
        if (r102 == null) goto L7;
        String r103 = r102.getPromotionId();
    L9:
        if (Intrinsics.areEqual(r103, r100.getPromotionId()) == false) goto L13;
        r101.f152204e.getPromotionState().e(r100);
        return;
    L13:
        return;
    L7:
        r103 = null;
        goto L9
    }

    @Override // cf.d
    public final void m(com.bytedance.android.shopping.store.home.presenter.preview.b r100) {
        ExplainCardWidgetController r101 = this.f152007b;
        if (r101 == null) goto L5;
        r101.f152210k = r100;
        r101.f152204e.setOpenSchemaProxy(r100);
    L5:
        RelatedCardWidgetController r102 = this.f152008c;
        if (r102 == null) goto L9;
        r102.f152564f.setOpenSchemaProxy(r100);
        return;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.widgets.bottom_right.i
    public final void h(String r100, long r101) {
        ExplainCardWidgetController r102 = this.f152007b;
        if (r102 == null) goto L15;
        if (r100 == null) goto L18;
        ECUIPromotion r103 = r102.f152204e.getPromotionState().a();
        if (r103 != null) goto L9;
        return;
    L9:
        if (Intrinsics.areEqual(r103.getPromotionId(), r100) == true) goto L12;
        r103 = null;
    L12:
        if (r103 == null) goto L17;
        dm.a.a("BottomRightCardManager").i("reset card(" + r100 + ") show time for " + r101 + " ms");
        r102.m(r103, r101 / 1000);
        return;
    L17:
        return;
    L18:
        return;
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public final void onStateChanged(LifecycleOwner r100, Lifecycle.Event r101) {
        Intrinsics.checkNotNullParameter(r100, "source");
        Intrinsics.checkNotNullParameter(r101, "event");
        int r102 = com.bytedance.android.livesdk.livecommerce.room.widgets.bottom_right.a.f152047a[r101.ordinal()];
        boolean r103 = false;
        boolean r104 = true;
        if (r102 == 1) goto L13;
        if (r102 == 2) goto L8;
        return;
    L8:
        if (this.f152010e.f481036a != 1) goto L10;
        r103 = true;
    L10:
        if (r103 == false) goto L24;
        u();
        this.f152012g = true;
        return;
    L24:
        return;
    L13:
        if (this.f152010e.f481036a == 1) goto L16;
        r104 = false;
    L16:
        if (r104 == false) goto L26;
        s();
        if (this.f152012g == false) goto L27;
        ExplainCardWidgetController r105 = this.f152007b;
        if (r105 == null) goto L22;
        n.a.b(r105);
    L22:
        this.f152012g = false;
        return;
    L27:
        return;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.widgets.bottom_right.i
    public final void q(String r100, long r101) {
        ExplainCardWidgetController r102 = this.f152007b;
        if (r102 == null) goto L6;
        r102.g(r100, r101);
        return;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.widgets.bottom_right.i
    public final void k(String r100, String r101, boolean r102) {
        ExplainCardWidgetController r103 = this.f152007b;
        if (r103 == null) goto L6;
        r103.a(r100, r101);
        return;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.widgets.bottom_right.i
    public final void o(ECUIPromotion r110, boolean r111, String r112, Function1<? super ECUIPromotion, Unit> r113) {
        Intrinsics.checkNotNullParameter(r110, "uiPromotion");
        ExplainCardWidgetController r100 = this.f152007b;
        if (r100 == null) goto L6;
        Intrinsics.checkNotNullParameter(r110, "uiPromotion");
        r100.f152224y.l(new ef.d(10, CardType.EXPLAIN_CARD, new l(r100, r110, r111, r112, r113), new m(r100)));
        return;
    }

    public BottomRightCardManager(Context r210, ml.b r211, LiveRoomParams r212, cf.i r213, int r214, cf.c r215, RoomContextController r216) {
        Intrinsics.checkNotNullParameter(r210, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r213, "getExplainPromotion");
        Intrinsics.checkNotNullParameter(r215, "btmInfo");
        Intrinsics.checkNotNullParameter(r216, "roomContextController");
        this.f152024s = new ik2.a();
        this.f152020o = r210;
        this.f152021p = r211;
        this.f152022q = r214;
        this.f152023r = r216;
        BottomRightAnimController r100 = new BottomRightAnimController(r216);
        this.f152006a = r100;
        gf.a r101 = new gf.a(r214);
        this.f152010e = r101;
        d r102 = new d(this);
        this.f152013h = r102;
        this.f152014i = true;
        Lazy r103 = LazyKt.lazy(new BottomRightCardManager$cardMonitor$2(this));
        this.f152019n = r103;
        b r104 = new b(this, r210);
        r104.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        r104.post(new a(r104, this));
        Unit r105 = Unit.INSTANCE;
        this.f152011f = r104;
        d r110 = r102;
        ExplainCardWidgetController r106 = new ExplainCardWidgetController(r210, r211, r212, r213, r104, r100, r214, r215, this, (fk2.a) r103.getValue(), r216);
        this.f152007b = r106;
        if (r101.a() == true) goto L5;
        r110 = r110;
    L22:
        ECLiveHybridUtil.m("closeExplainCard", r110);
        return;
    L5:
        if (ECLiveABUtils.INSTANCE.getENABLE_CONTROLLER_OPT() == false) goto L8;
        EntryController r107 = r216.A().f151429t;
    L11:
        String r108 = r107.M().f(IRelatedInfoManager$Scene.CARRY_ON_CARD);
        if (r216.A().f151429t.V == null) goto L14;
        boolean r109 = true;
    L15:
        if (r108 != null) goto L19;
        if (r109 == true) goto L19;
    L20:
        s();
        r106.f152201b = ControllerExtensionsKt.c(r216, r211.roomId()).A().f151429t.T;
        ControllerExtensionsKt.c(r216, r211.roomId()).A().f151426q.f151649h = this;
    L19:
        this.f152008c = new RelatedCardWidgetController(r210, r211, r212, r104, r100, (fk2.a) r103.getValue(), r214, r215, new AnonymousClass3(this), this, r216);
        goto L20
    L14:
        r109 = false;
        goto L15
    L8:
        if (r216.v() == false) goto L10;
        r107 = r216.A().f151429t;
        goto L11
    L10:
        boolean r111 = EntryController.M1;
        r107 = EntryController.a.b(r211.roomId(), r216.D());
        goto L11
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.widgets.bottom_right.i
    public final void p(String r110, Function1<? super ECUIPromotion, Unit> r111, boolean r112, Pair<Long, Long> r113, s r114, String r115, Map<String, String> r116) {
        fk2.a r100 = (fk2.a) this.f152019n.getValue();
        if (r100 != null) goto L5;
    L13:
        ExplainCardWidgetController r101 = this.f152007b;
        if (r101 == null) goto L17;
        r101.f(r110, r111, r112, r113, r114, r115, r116);
        return;
    L17:
        return;
    L5:
        if (this.f152010e.a() == false) goto L13;
        if (r112 == true) goto L9;
        String r102 = "enter_room";
    L10:
        v r103 = new v("livesdk_popup_card_request_show", r100.f477599d);
        r103.c("from_scene", r102);
        Unit r104 = Unit.INSTANCE;
        if (r100.f477598c == false) goto L13;
        r103.i(null);
        goto L13
    L9:
        r102 = "message";
        goto L10
    }
}
