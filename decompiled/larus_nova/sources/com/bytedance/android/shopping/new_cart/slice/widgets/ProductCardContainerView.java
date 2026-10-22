package com.bytedance.android.shopping.new_cart.slice.widgets;

import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.Scroller;
import com.bytedance.android.ecom.arch.slice.render.elements.flexbox.SlcFlexElementView;
import com.bytedance.android.shopping.new_cart.container.CartObjectContainer;
import com.bytedance.android.shopping.new_cart.container.b0;
import com.bytedance.android.shopping.new_cart.utils.CartCommonLog;
import com.bytedance.android.shopping.new_cart.viewmodel.CartViewModel;
import com.larus.apm.impl.protector.RunnableProtector;
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
    public final Scroller f179260e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f179261f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f179262g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f179263h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f179264i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f179265j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Lazy f179266k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f179267l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f179268m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public List<String> f179269n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f179270o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final b0 f179271p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final CartObjectContainer f179272q;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ProductCardContainerView f179273a;

        public a(ProductCardContainerView r100) {
            this.f179273a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        L13:
            return;
        L3:
            if (this.f179273a.f179260e.computeScrollOffset() == false) goto L9;
            ProductCardContainerView r100 = this.f179273a;     // Catch: Throwable -> L6
            r100.setTranslationX(r100.f179260e.getCurrX());     // Catch: Throwable -> L6
            this.f179273a.invalidate();     // Catch: Throwable -> L6
            return;
        }
    }

    private final CartViewModel getCartVM() {
        return (CartViewModel) this.f179266k.getValue();
    }

    public final void h() {
        b0 r100 = this.f179271p;
        if (r100 == null) goto L7;
        Function1<WeakReference<ProductCardContainerView>, Unit> r101 = r100.f178998b;
        if (r101 == null) goto L7;
        r101.invoke(new WeakReference(null));
        Unit r102 = Unit.INSTANCE;
    L7:
        this.f179260e.forceFinished(true);
        setTranslationX(0.0f);
    }

    @Override // android.view.View
    public final void computeScroll() {
        super.computeScroll();
        bg3.a r100 = com.bytedance.android.shopping.new_cart.utils.a.f179357a;
        com.bytedance.android.shopping.new_cart.utils.a.c(getCartVM(), "productContainerComputeScroll", new a(this), null);
    }

    public final b0 getActions() {
        return this.f179271p;
    }

    public final CartObjectContainer getObjectContainer() {
        return this.f179272q;
    }

    @Override // com.bytedance.android.ecom.arch.slice.render.widget.yoga.SlcYogaLayout, android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(final MotionEvent r110) {
        if (r110 != null) goto L5;
        return false;
    L5:
        b0 r100 = this.f179271p;
        if (r100 == null) goto L16;
        Function0<WeakReference<ProductCardContainerView>> r101 = r100.f178997a;
        if (r101 == null) goto L16;
        WeakReference<ProductCardContainerView> r102 = r101.invoke();
        if (r102 == null) goto L16;
        ProductCardContainerView r103 = r102.get();
        if (r103 == null) goto L16;
        if ((!Intrinsics.areEqual(r103, this)) == false) goto L16;
        g(r103, false);
    L16:
        Lazy r104 = CartCommonLog.f179348a;
        CartCommonLog.a("ProductCardContainerView", new AnonymousClass3(r110));
        int r105 = (int) getTranslationX();
        int r106 = (int) r110.getRawX();
        int r107 = r110.getAction();
        if (r107 != 0) goto L19;
        this.f179267l = System.currentTimeMillis();
        this.f179263h = (int) r110.getRawX();
        this.f179264i = (int) r110.getRawY();
        this.f179261f = (int) r110.getRawX();
    L51:
        return super.dispatchTouchEvent(r110);
    L19:
        if (r107 == 1) goto L27;
        if (r107 != 2) goto L51;
        int r108 = this.f179261f - r106;
        this.f179261f = r106;
        int r109 = Math.abs(r106 - this.f179263h);
        int r111 = Math.abs(((int) r110.getRawY()) - this.f179264i);
        if (r109 <= ViewConfiguration.get(getContext()).getScaledTouchSlop()) goto L51;
        if (r109 <= r111) goto L51;
        getParent().requestDisallowInterceptTouchEvent(true);
        setTranslationX(-Math.min(this.f179262g, Math.max(0, r108 - r105)));
        return true;
    L27:
        this.f179268m = System.currentTimeMillis();
        final int r112 = r106 - this.f179263h;
        CartCommonLog.a("ProductCardContainerView", new AnonymousClass4(this, r112));
        if (Math.abs(r112) <= ViewConfiguration.get(getContext()).getScaledTouchSlop()) goto L51;
        CartObjectContainer r113 = this.f179272q;
        if (r113 == null) goto L36;
        com.bytedance.android.shopping.new_cart.container.b r114 = r113.f178935e;
        if (r114 == null) goto L36;
        Map<String, ?> r115 = r114.a();
        if (r115 == null) goto L36;
        Object r116 = r115.get("new_del_express");
    L37:
        boolean r117 = com.bytedance.android.ecom.arch.slice.render.util.b.a(r116);
        if ((this.f179268m - this.f179267l) >= this.f179265j) goto L44;
        if (r117 == false) goto L44;
        if (r112 >= 0) goto L42;
        g(this, true);
        CartCommonLog.a("ProductCardContainerView", AnonymousClass5.INSTANCE);
    L48:
        return true;
    L42:
        g(this, false);
        CartCommonLog.a("ProductCardContainerView", AnonymousClass6.INSTANCE);
    L44:
        if (Math.abs(r105) >= (this.f179262g / 2)) goto L46;
        g(this, false);
    L47:
        CartCommonLog.a("ProductCardContainerView", AnonymousClass7.INSTANCE);
        goto L48
    L46:
        g(this, true);
    L36:
        r116 = null;
        goto L37
    }

    public static void g(ProductCardContainerView r100, boolean r101) {
        int r102 = (int) r100.getTranslationX();
        if (r101 == false) goto L15;
        b0 r103 = r100.f179271p;
        if (r103 == null) goto L9;
        Function1<WeakReference<ProductCardContainerView>, Unit> r104 = r103.f178998b;
        if (r104 == null) goto L9;
        r104.invoke(new WeakReference(r100));
    L9:
        r100.f179260e.startScroll(r102, 0, (-r100.f179262g) - r102, 0, 200);
        Iterator<T> r105 = r100.f179269n.iterator();
    L11:
        if (r105.hasNext() == false) goto L20;
        String r106 = (String) r105.next();
        CartViewModel r107 = r100.getCartVM();
        if (r107 == null) goto L11;
        CartViewModel.doEventAction$default(r107, "cart_list_tab_show", MapsKt.mapOf(new Pair[]{TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_TAB_NAME, r106), TuplesKt.to("product_id", r100.f179270o)}), null, 4, null);
    L20:
        r100.invalidate();
        return;
    L15:
        r100.f179260e.startScroll(r102, 0, -r102, 0, 200);
        b0 r108 = r100.f179271p;
        if (r108 == null) goto L20;
        Function1<WeakReference<ProductCardContainerView>, Unit> r109 = r108.f178998b;
        if (r109 == null) goto L20;
        r109.invoke(new WeakReference(null));
        goto L20
    }

    public ProductCardContainerView(Context r100, b0 r101, CartObjectContainer r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, null, 0);
        this.f179271p = r101;
        this.f179272q = r102;
        this.f179260e = new Scroller(r100);
        Resources r103 = Resources.getSystem();
        this.f179262g = MathKt.roundToInt(TypedValue.applyDimension(1, 210, WindowDisplayMetricsOverride.apply(r103, r103.getDisplayMetrics())));
        this.f179265j = 400;
        this.f179266k = LazyKt.lazy(new ProductCardContainerView$cartVM$2(this));
        this.f179269n = CollectionsKt.emptyList();
        this.f179270o = "";
    }
}
