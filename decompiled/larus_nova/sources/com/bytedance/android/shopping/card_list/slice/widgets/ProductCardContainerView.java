package com.bytedance.android.shopping.card_list.slice.widgets;

import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.Scroller;
import com.bytedance.android.ecom.arch.slice.action.SlcCommonAction;
import com.bytedance.android.ecom.arch.slice.render.context.SlcTemplateContext;
import com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewManager;
import com.bytedance.android.ecom.arch.slice.render.elements.flexbox.SlcFlexElementView;
import com.bytedance.android.ecom.arch.slice.render.util.SlcViewExtensionsKt;
import com.bytedance.android.shopping.card_list.common_params.CardListContainerConfig;
import com.bytedance.android.shopping.card_list.components.CardListSliceCustomWidgetAdapterComponent;
import com.bytedance.android.shopping.card_list.components.CardListTrackerComponent;
import com.bytedance.android.shopping.card_list.components.s;
import com.bytedance.android.shopping.card_list.container.init.CardListObjectContainer;
import com.bytedance.android.shopping.card_list.container.init.LauncherBizType;
import com.bytedance.android.shopping.card_list.monitor.error.CardListRunCatchExtKt;
import com.bytedance.android.shopping.new_cart.utils.CartCommonLog;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes13.dex */
public final class ProductCardContainerView extends SlcFlexElementView {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Scroller f171794e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f171795f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f171796g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f171797h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f171798i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f171799j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public List<String> f171800k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f171801l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f171802m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public long f171803n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Lazy f171804o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Lazy f171805p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Lazy f171806q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Lazy f171807r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Lazy f171808s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Lazy f171809t;

    private final s getActions() {
        return (s) this.f171807r.getValue();
    }

    private final String getMonitorId() {
        return (String) this.f171806q.getValue();
    }

    private final CardListObjectContainer getObjectContainer() {
        return (CardListObjectContainer) this.f171805p.getValue();
    }

    private final CardListSliceCustomWidgetAdapterComponent getProvider() {
        return (CardListSliceCustomWidgetAdapterComponent) this.f171804o.getValue();
    }

    private final CardListTrackerComponent getTrackerComponent() {
        return (CardListTrackerComponent) this.f171808s.getValue();
    }

    @Override // android.view.View
    public final void computeScroll() {
        super.computeScroll();
        CardListRunCatchExtKt.a(getMonitorId(), "productContainerComputeScroll", new AnonymousClass1(this));
    }

    public final void j() {
        s r100 = getActions();
        if (r100 == null) goto L7;
        Function1<WeakReference<ProductCardContainerView>, Unit> r101 = r100.f171482b;
        if (r101 == null) goto L7;
        r101.invoke(new WeakReference(null));
        Unit r102 = Unit.INSTANCE;
    L7:
        this.f171794e.forceFinished(true);
        setTranslationX(0.0f);
    }

    public static final /* synthetic */ CardListObjectContainer g(ProductCardContainerView r100) {
        return r100.getObjectContainer();
    }

    public static final /* synthetic */ CardListSliceCustomWidgetAdapterComponent h(ProductCardContainerView r100) {
        return r100.getProvider();
    }

    @Override // com.bytedance.android.ecom.arch.slice.render.widget.yoga.SlcYogaLayout, android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(final MotionEvent r110) {
        if (r110 != null) goto L5;
        return false;
    L5:
        s r100 = getActions();
        if (r100 == null) goto L17;
        Function0<WeakReference<ProductCardContainerView>> r101 = r100.f171481a;
        if (r101 == null) goto L17;
        WeakReference<ProductCardContainerView> r102 = r101.invoke();
        if (r102 == null) goto L17;
        ProductCardContainerView r103 = r102.get();
        if (r103 == null) goto L17;
        if ((!Intrinsics.areEqual(r103, this)) == false) goto L17;
        i(r103, false);
    L17:
        if (((Boolean) this.f171809t.getValue()).booleanValue() == true) goto L19;
        s r104 = getActions();
        if (r104 == null) goto L25;
        Function1<WeakReference<ProductCardContainerView>, Unit> r105 = r104.f171487g;
        if (r105 == null) goto L25;
        r105.invoke(new WeakReference(this));
    L25:
        Lazy r106 = CartCommonLog.f179348a;
        CartCommonLog.a("ProductCardContainerView", new AnonymousClass4(r110));
        int r107 = (int) getTranslationX();
        int r108 = (int) r110.getRawX();
        int r109 = r110.getAction();
        if (r109 != 0) goto L28;
        this.f171802m = System.currentTimeMillis();
        this.f171797h = (int) r110.getRawX();
        this.f171798i = (int) r110.getRawY();
        this.f171795f = (int) r110.getRawX();
    L61:
        return super.dispatchTouchEvent(r110);
    L28:
        if (r109 == 1) goto L36;
        if (r109 != 2) goto L61;
        int r111 = this.f171795f - r108;
        this.f171795f = r108;
        int r112 = Math.abs(r108 - this.f171797h);
        int r113 = Math.abs(((int) r110.getRawY()) - this.f171798i);
        if (r112 <= ViewConfiguration.get(getContext()).getScaledTouchSlop()) goto L61;
        if (r112 <= r113) goto L61;
        getParent().requestDisallowInterceptTouchEvent(true);
        setTranslationX(-Math.min(this.f171796g, Math.max(0, r111 - r107)));
        return true;
    L36:
        this.f171803n = System.currentTimeMillis();
        final int r114 = r108 - this.f171797h;
        CartCommonLog.a("ProductCardContainerView", new AnonymousClass5(this, r114));
        if (Math.abs(r114) <= ViewConfiguration.get(getContext()).getScaledTouchSlop()) goto L61;
        CardListObjectContainer r115 = getObjectContainer();
        if (r115 == null) goto L45;
        com.bytedance.android.shopping.card_list.common_params.a r116 = r115.f171545e;
        if (r116 == null) goto L45;
        Map<String, ?> r117 = r116.a();
        if (r117 == null) goto L45;
        Object r118 = r117.get("new_del_express");
    L46:
        boolean r119 = com.bytedance.android.ecom.arch.slice.render.util.b.a(r118);
        if ((this.f171803n - this.f171802m) >= this.f171799j) goto L53;
        if (r119 == false) goto L53;
        if (r114 >= 0) goto L51;
        i(this, true);
        CartCommonLog.a("ProductCardContainerView", AnonymousClass6.INSTANCE);
    L57:
        cancelLongPress();
        return true;
    L51:
        i(this, false);
        CartCommonLog.a("ProductCardContainerView", AnonymousClass7.INSTANCE);
    L53:
        if (Math.abs(r107) >= (this.f171796g / 2)) goto L55;
        i(this, false);
    L56:
        CartCommonLog.a("ProductCardContainerView", AnonymousClass8.INSTANCE);
        goto L57
    L55:
        i(this, true);
    L45:
        r118 = null;
        goto L46
    L19:
        return super.dispatchTouchEvent(r110);
    }

    public ProductCardContainerView(Context r100, final SlcTemplateContext r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "slcTemplateContext");
        super(r100, null, 0);
        this.f171794e = new Scroller(r100);
        Resources r102 = Resources.getSystem();
        this.f171796g = MathKt.roundToInt(TypedValue.applyDimension(1, 210, WindowDisplayMetricsOverride.apply(r102, r102.getDisplayMetrics())));
        this.f171799j = 400;
        this.f171800k = CollectionsKt.emptyList();
        this.f171801l = "";
        this.f171804o = LazyKt.lazy(new ProductCardContainerView$provider$2(r101));
        this.f171805p = LazyKt.lazy(new ProductCardContainerView$objectContainer$2(this));
        this.f171806q = LazyKt.lazy(new ProductCardContainerView$monitorId$2(this));
        this.f171807r = LazyKt.lazy(new ProductCardContainerView$actions$2(this));
        this.f171808s = LazyKt.lazy(new ProductCardContainerView$trackerComponent$2(this));
        this.f171809t = LazyKt.lazy(new ProductCardContainerView$isFromGuest$2(this));
    }

    public static void i(ProductCardContainerView r110, boolean r111) {
        int r100 = (int) r110.getTranslationX();
        if (r111 == false) goto L41;
        s r112 = r110.getActions();
        if (r112 == null) goto L9;
        Function1<WeakReference<ProductCardContainerView>, Unit> r113 = r112.f171482b;
        if (r113 == null) goto L9;
        r113.invoke(new WeakReference(r110));
    L9:
        r110.f171794e.startScroll(r100, 0, (-r110.f171796g) - r100, 0, 200);
        Iterator<T> r114 = r110.f171800k.iterator();
    L11:
        if (r114.hasNext() == false) goto L30;
        String r101 = (String) r114.next();
        CardListObjectContainer r102 = r110.getObjectContainer();
        if (r102 == null) goto L17;
        CardListContainerConfig r103 = r102.f171546f;
        if (r103 == null) goto L17;
        LauncherBizType r104 = r103.getBizType();
    L19:
        if (r104 != LauncherBizType.CART) goto L11;
        CardListObjectContainer r105 = r110.getObjectContainer();
        if (r105 == null) goto L26;
        CardListContainerConfig r106 = r105.f171546f;
        if (r106 == null) goto L26;
        String r107 = r106.getStandardShowEventName();
        if (r107 == null) goto L26;
    L27:
        CardListTrackerComponent r108 = r110.getTrackerComponent();
        if (r108 == null) goto L11;
        CardListTrackerComponent.h(r108, r107, MapsKt.mapOf(new Pair[]{TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_TAB_NAME, r101), TuplesKt.to("product_id", r110.f171801l)}), 4);
    L26:
        r107 = "card_list_tab_show";
    L17:
        r104 = null;
        goto L19
    L30:
        CardListObjectContainer r115 = r110.getObjectContainer();
        if (r115 == null) goto L35;
        CardListContainerConfig r116 = r115.f171546f;
        if (r116 == null) goto L35;
        LauncherBizType r117 = r116.getBizType();
    L37:
        if (r117 != LauncherBizType.COLLECT) goto L46;
        BaseSlcViewManager<?> r118 = SlcViewExtensionsKt.g(r110);
        if (r118 == null) goto L46;
        r118.f50260a.d(new SlcCommonAction("collectListDeleteShow", null, 2, null), r110, r118.l(), null, null);
    L46:
        r110.invalidate();
        return;
    L35:
        r117 = null;
        goto L37
    L41:
        r110.f171794e.startScroll(r100, 0, -r100, 0, 200);
        s r119 = r110.getActions();
        if (r119 == null) goto L46;
        Function1<WeakReference<ProductCardContainerView>, Unit> r120 = r119.f171482b;
        if (r120 == null) goto L46;
        r120.invoke(new WeakReference(null));
        goto L46
    }
}
