package com.bytedance.android.shopping.slice.elements.shoprecommend;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.ecom.arch.slice.action.SlcCommonAction;
import com.bytedance.android.ecom.arch.slice.render.context.SlcRenderContext;
import com.bytedance.android.ecom.arch.slice.render.context.SlcTemplateContext;
import com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewManager;
import com.bytedance.android.ecom.arch.slice.render.elements.scroll.SlcScrollElementView;
import com.bytedance.android.ecom.arch.slice.render.util.SlcViewExtensionsKt;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.card.plugin.ReportCardMonitorPlugin;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class a extends SlcScrollElementView {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f183333f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f183334g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f183335h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f183336i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Function1<? super Integer, Unit> f183337j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f183338k;

    /* JADX INFO: renamed from: com.bytedance.android.shopping.slice.elements.shoprecommend.a$a, reason: collision with other inner class name */
    public static final class RunnableC2726a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f183339a;

        public RunnableC2726a(a r100) {
            this.f183339a = r100;
        }

        public final void a() {
            a r100 = this.f183339a;
            int r101 = r100.getWidth();
            a r102 = this.f183339a;
            r100.f183333f = r101 * r102.f183335h;
            r102.scrollTo(r102.f183333f, 0);
            if (this.f183339a.getChildCount() <= 0) goto L13;
            int r103 = com.bytedance.commerce.base.view.b.a((View) ListProtector.get(com.bytedance.commerce.base.view.b.a(this.f183339a), 0)).size();
            a r104 = this.f183339a;
            if (r103 <= r104.f183335h) goto L14;
            Object r105 = ListProtector.get(com.bytedance.commerce.base.view.b.a((View) ListProtector.get(com.bytedance.commerce.base.view.b.a((View) ListProtector.get(com.bytedance.commerce.base.view.b.a(r104), 0)), this.f183339a.f183335h)), 0);
            if ((r105 instanceof ki3.a) == true) goto L9;
            r105 = null;
        L9:
            ki3.a r106 = (ki3.a) r105;
            if (r106 == null) goto L15;
            r106.scrollTo(0, 0);
            return;
        L15:
            return;
        L14:
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

    public final void c() {
        if (this.f183335h >= 0) goto L6;
        setPosition(0);
        this.f183336i = System.currentTimeMillis();
        return;
    L6:
        long r100 = System.currentTimeMillis() - this.f183336i;
        BaseSlcViewManager<?> r101 = SlcViewExtensionsKt.g(this);
        if (r101 == null) goto L11;
        SlcTemplateContext r102 = r101.f50260a;
        if (r102 == null) goto L11;
        SlcTemplateContext.e(r102, new SlcCommonAction(com.bytedance.android.ec.core.event.a.KEY_TRACKER, MapsKt.mapOf(new Pair[]{TuplesKt.to(ReportCardMonitorPlugin.EVENT_NAME, "pdp_shop_recommend_tab_duration"), TuplesKt.to("params", MapsKt.mapOf(new Pair[]{TuplesKt.to("shop_recommend_tab_index", Integer.valueOf(this.f183335h)), TuplesKt.to("shop_recommend_tab_duration", Long.valueOf(r100))}))})), this, null, null, 24);
    L11:
        this.f183336i = System.currentTimeMillis();
    }

    private final int getBaseScrollX() {
        return getScrollX() - this.f183333f;
    }

    public final int getTabCount() {
        return this.f183334g;
    }

    public a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        super(r100, r101, 6, 0);
        setOverScrollMode(2);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.f183335h = -1;
    }

    private final void setPosition(int r100) {
        this.f183335h = r100;
        post(new c(this));
        Function1<? super Integer, Unit> r101 = this.f183337j;
        if (r101 == null) goto L6;
        Unit r102 = r101.invoke(Integer.valueOf(this.f183335h));
        return;
    }

    public final void e(int r100) {
        c();
        setPosition(r100);
        post(new RunnableC2726a(this));
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "ev");
        int r101 = getWidth();
        int r102 = r100.getAction();
        if (r102 == 1) goto L13;
        if (r102 != 2) goto L11;
        if (this.f183338k != 0.0f) goto L11;
        this.f183338k = r100.getX();
    L11:
        return super.onTouchEvent(r100);
    L13:
        if (getScrollX() >= (getChildAt(0).getWidth() - getWidth())) goto L15;
    L18:
        int r103 = getBaseScrollX();
        if (r103 <= (r101 / 4)) goto L21;
        smoothScrollTo(this.f183333f + r101, 0);
        this.f183333f += r101;
        c();
        int r104 = this.f183335h;
        d(r104 + 1, r104);
        setPosition(this.f183335h + 1);
    L27:
        this.f183338k = 0.0f;
        return true;
    L21:
        if (r103 <= 0) goto L23;
        smoothScrollTo(this.f183333f + 0, 0);
        goto L27
    L23:
        int r105 = -r101;
        if (r103 <= (r105 / 4)) goto L26;
        smoothScrollTo(this.f183333f + 0, 0);
        goto L27
    L26:
        smoothScrollTo(r105 + this.f183333f, 0);
        this.f183333f -= r101;
        post(new b(this, this.f183335h - 1));
        c();
        int r106 = this.f183335h;
        d(r106 - 1, r106);
        setPosition(this.f183335h - 1);
        goto L27
    L15:
        if ((r100.getX() - this.f183338k) >= 0) goto L18;
        callOnClick();
        this.f183338k = 0.0f;
        return true;
    }

    public final void setOnTabChangeListener(Function1<? super Integer, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f183337j = r100;
    }

    public final void setTabCount(int r100) {
        this.f183334g = r100;
    }

    public final void d(int r100, int r101) {
        BaseSlcViewManager<?> r102 = SlcViewExtensionsKt.g(this);
        if (r102 == null) goto L8;
        SlcTemplateContext r103 = r102.f50260a;
        if (r103 == null) goto L9;
        SlcTemplateContext.e(r103, new SlcCommonAction(com.bytedance.android.ec.core.event.a.KEY_TRACKER, MapsKt.mapOf(new Pair[]{TuplesKt.to(ReportCardMonitorPlugin.EVENT_NAME, "pdp_shop_recommend_tab_slide"), TuplesKt.to("params", MapsKt.mapOf(new Pair[]{TuplesKt.to("shop_recommend_tab_index", Integer.valueOf(r100)), TuplesKt.to("shop_recommend_last_tab_index", Integer.valueOf(r101))}))})), this, null, null, 24);
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.ecom.arch.slice.render.elements.scroll.SlcScrollElementView, android.view.View
    public final void onScrollChanged(int r100, int r101, int r102, int r103) {
        super.onScrollChanged(r100, r101, r102, r103);
        float r104 = r100;
        BaseSlcViewManager<?> r105 = SlcViewExtensionsKt.g(this);
        View r106 = null;
        if (r105 == null) goto L9;
        SlcTemplateContext r107 = r105.f50260a;
        if (r107 == null) goto L9;
        if (r107.f50235w == null) goto L9;
        View r108 = SlcRenderContext.f(this, "iesec_pdp_shop_recommend_bottom_slider_core");
    L10:
        BaseSlcViewManager<?> r109 = SlcViewExtensionsKt.g(this);
        if (r109 == null) goto L17;
        SlcTemplateContext r110 = r109.f50260a;
        if (r110 == null) goto L17;
        if (r110.f50235w == null) goto L17;
        r106 = SlcRenderContext.f(this, "iesec_pdp_shop_recommend_bottom_slider");
    L17:
        if (r108 == null) goto L21;
        if (r106 == null) goto L22;
        r108.setX((r106.getWidth() - r108.getWidth()) * (r104 / ((this.f183334g - 1) * getWidth())));
        requestLayout();
        return;
    L22:
        return;
    L21:
        return;
    L9:
        r108 = null;
        goto L10
    }
}
