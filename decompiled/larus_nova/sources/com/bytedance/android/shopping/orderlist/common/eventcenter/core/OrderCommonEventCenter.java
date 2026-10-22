package com.bytedance.android.shopping.orderlist.common.eventcenter.core;

import android.app.Activity;
import com.bytedance.android.shopping.orderlist.common.eventcenter.function.OrderCommonAddPreloadTaskFunction;
import com.bytedance.android.shopping.orderlist.common.eventcenter.function.a0;
import com.bytedance.android.shopping.orderlist.common.eventcenter.function.b0;
import com.bytedance.android.shopping.orderlist.common.eventcenter.function.c0;
import com.bytedance.android.shopping.orderlist.common.eventcenter.function.d0;
import com.bytedance.android.shopping.orderlist.common.eventcenter.function.e;
import com.bytedance.android.shopping.orderlist.common.eventcenter.function.e0;
import com.bytedance.android.shopping.orderlist.common.eventcenter.function.f;
import com.bytedance.android.shopping.orderlist.common.eventcenter.function.f0;
import com.bytedance.android.shopping.orderlist.common.eventcenter.function.g0;
import com.bytedance.android.shopping.orderlist.common.eventcenter.function.h;
import com.bytedance.android.shopping.orderlist.common.eventcenter.function.h0;
import com.bytedance.android.shopping.orderlist.common.eventcenter.function.i;
import com.bytedance.android.shopping.orderlist.common.eventcenter.function.i0;
import com.bytedance.android.shopping.orderlist.common.eventcenter.function.k;
import com.bytedance.android.shopping.orderlist.common.eventcenter.function.l;
import com.bytedance.android.shopping.orderlist.common.eventcenter.function.m;
import com.bytedance.android.shopping.orderlist.common.eventcenter.function.n;
import com.bytedance.android.shopping.orderlist.common.eventcenter.function.o;
import com.bytedance.android.shopping.orderlist.common.eventcenter.function.p;
import com.bytedance.android.shopping.orderlist.common.eventcenter.function.q;
import com.bytedance.android.shopping.orderlist.common.eventcenter.function.r;
import com.bytedance.android.shopping.orderlist.common.eventcenter.function.s;
import com.bytedance.android.shopping.orderlist.common.eventcenter.function.t;
import com.bytedance.android.shopping.orderlist.common.eventcenter.function.u;
import com.bytedance.android.shopping.orderlist.common.eventcenter.function.v;
import com.bytedance.android.shopping.orderlist.common.eventcenter.function.w;
import com.bytedance.android.shopping.orderlist.common.eventcenter.function.x;
import com.bytedance.android.shopping.orderlist.common.eventcenter.function.y;
import com.bytedance.android.shopping.orderlist.common.eventcenter.function.z;
import com.bytedance.android.shopping.orderlist.common.eventcenter.lynxbridge.c;
import com.bytedance.android.shopping.orderlist.common.freq.func.b;
import com.bytedance.android.shopping.orderlist.common.monitor.error.OrderCommonErrorMonitorKt;
import com.bytedance.kmp.ec.yata.AndroidYaTaInstance;
import com.bytedance.kmp.ec.yata.event.common.d;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class OrderCommonEventCenter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f179763a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, OrderCommonEventCenter$jsFuncSubscriber$1> f179764b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<Pair<String, d>> f179765c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Activity f179766d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final eg3.a f179767e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final AndroidYaTaInstance f179768f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final com.bytedance.android.shopping.orderlist.common.eventcenter.core.a f179769g;

    public static final class a {
    }

    static {
    }

    public final void a() {
        OrderCommonErrorMonitorKt.c(this.f179769g.E0(), "OrderCommonEventCenter-registerAll", new OrderCommonEventCenter$registerAll$1(this));
    }

    public final void b() {
        OrderCommonErrorMonitorKt.c(this.f179769g.E0(), "OrderCommonEventCenter-unregisterAll", new OrderCommonEventCenter$unregisterAll$1(this));
    }

    public OrderCommonEventCenter(Activity r110, eg3.a r111, AndroidYaTaInstance r112, com.bytedance.android.shopping.orderlist.common.eventcenter.core.a r113) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r111, "orderCommonPage");
        Intrinsics.checkNotNullParameter(r113, "ability");
        this.f179766d = r110;
        this.f179767e = r111;
        this.f179768f = r112;
        this.f179769g = r113;
        if (r112 != null) goto L5;
        OrderCommonErrorMonitorKt.b(r113.E0(), "SERIOUS_BUSINESS_ERROR", "OrderCommonEventCenter-init: yataInstance is null");
    L5:
        Lazy r100 = LazyKt.lazy(new OrderCommonEventCenter$bridgeComponent$2(this));
        this.f179763a = r100;
        this.f179764b = MapsKt.mapOf(new Pair[]{TuplesKt.to("operate_success", new OrderCommonEventCenter$jsFuncSubscriber$1(this, "operateSuccess")), TuplesKt.to("operate_fail", new OrderCommonEventCenter$jsFuncSubscriber$1(this, "operateFail")), TuplesKt.to("continue_pay_success", new OrderCommonEventCenter$jsFuncSubscriber$1(this, "continuePaySuccess")), TuplesKt.to("ecom.sku.add.cart", new OrderCommonEventCenter$jsFuncSubscriber$1(this, "ecomSkuAddCart"))});
        this.f179765c = CollectionsKt.listOf(new Pair[]{TuplesKt.to("selfScrollToTop", new q(r113)), TuplesKt.to("selfQueryWhenAppear", new k(r113)), TuplesKt.to("selfQuitPage", new l(r113)), TuplesKt.to("selfQuitSplitContainer", new m(r113)), TuplesKt.to("selfUseBridge", new y(r113, r112, (c) r100.getValue())), TuplesKt.to("selfOrderShowMoreMenu", new i(r113, r110, r112)), TuplesKt.to("selfHeaderShowMenu", new f(r113, r110, r112)), TuplesKt.to("selfScrollToGuessYouLike", new p(r113)), TuplesKt.to("selfToTab", new v(r113)), TuplesKt.to("selfDelay", new com.bytedance.android.shopping.orderlist.common.eventcenter.function.d(r113)), TuplesKt.to("selfSetStatusBar", new u(r110, r113)), TuplesKt.to("selfShowBottomBar", new f0(r113, r111.Md())), TuplesKt.to("selfCloseBottomBar", new b0(r113, r111.Md())), TuplesKt.to("selfSaveNode", new r(r113)), TuplesKt.to("selfDoOnce", new e(r113)), TuplesKt.to("selfRegisterScrollStrategy", new n(r113)), TuplesKt.to("selfUpdateRawParams", new x(r113)), TuplesKt.to("selfResetGuessYouLike", new o(r113)), TuplesKt.to("selfUpdateCustomFields", new i0()), TuplesKt.to("selfRegisterBridgeEvent", new c0(r113, r112)), TuplesKt.to("selfUnregisterBridgeEvent", new h0(r113)), TuplesKt.to("selfScrollMainList", new e0(r113)), TuplesKt.to("selfScrollToPosition", new z(r113)), TuplesKt.to("selfJudgeFrequency", new b(r113)), TuplesKt.to("selfControlFrequency", new com.bytedance.android.shopping.orderlist.common.freq.func.a(r113)), TuplesKt.to("selfTabBubble", new g0(r113)), TuplesKt.to("selfTransformLocation", new w(r113, r112)), TuplesKt.to("selfOpenMaskLayer", new h(r113)), TuplesKt.to("selfCloseMaskLayer", new com.bytedance.android.shopping.orderlist.common.eventcenter.function.c(r113)), TuplesKt.to("selfSaveTrigger", new s(r113)), TuplesKt.to("selfAddPreloadTask", new OrderCommonAddPreloadTaskFunction(r113)), TuplesKt.to("selfAddExParams", new a0(r113)), TuplesKt.to("selfRemoveExParams", new d0(r113)), TuplesKt.to("selfBeforeChangeTab", new com.bytedance.android.shopping.orderlist.common.eventcenter.function.b(r113)), TuplesKt.to("selfUIAction", new t(r113, r112))});
    }
}
