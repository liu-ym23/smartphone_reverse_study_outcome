package com.bytedance.android.shopping.collect.slice.widgets;

import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.Scroller;
import androidx.core.view.NestedScrollingParent3;
import com.amap.api.col.s.ce;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.android.ec.core.abtest.ECSettingKeys;
import com.bytedance.android.ecom.arch.slice.action.SlcCommonAction;
import com.bytedance.android.ecom.arch.slice.render.context.SlcTemplateContext;
import com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewManager;
import com.bytedance.android.ecom.arch.slice.render.elements.flexbox.SlcFlexElementView;
import com.bytedance.android.ecom.arch.slice.render.util.SlcViewExtensionsKt;
import com.bytedance.android.shopping.extensions.k;
import com.bytedance.kmp.ec.yata.AndroidYaTaInstance;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u000fR\u0017\u0010\b\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u0019\u0010\u000e\u001a\u0004\u0018\u00010\t8\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/shopping/collect/slice/widgets/ProductCardContainerView;", "Lcom/bytedance/android/ecom/arch/slice/render/elements/flexbox/SlcFlexElementView;", "Landroidx/core/view/NestedScrollingParent3;", "Lcom/bytedance/android/ecom/arch/slice/render/context/SlcTemplateContext;", ce.f26396k, "Lcom/bytedance/android/ecom/arch/slice/render/context/SlcTemplateContext;", "getSlcTemplateContext", "()Lcom/bytedance/android/ecom/arch/slice/render/context/SlcTemplateContext;", "slcTemplateContext", "Lcom/bytedance/android/shopping/collect/slice/a;", "l", "Lcom/bytedance/android/shopping/collect/slice/a;", "getActions", "()Lcom/bytedance/android/shopping/collect/slice/a;", SlcCommonAction.KEY_ACTIONS, BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ProductCardContainerView extends SlcFlexElementView implements NestedScrollingParent3 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Scroller f172281e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f172282f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f172283g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f172284h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f172285i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public List<String> f172286j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final SlcTemplateContext f172287k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final com.bytedance.android.shopping.collect.slice.a f172288l;

    public static final class a {
    }

    static {
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public final void onNestedPreScroll(View r100, int r101, int r102, int[] r103, int r104) {
        Intrinsics.checkNotNullParameter(r100, PickerReporterConstants.KEY.TARGET);
        Intrinsics.checkNotNullParameter(r103, "consumed");
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public final void onNestedScroll(View r100, int r101, int r102, int r103, int r104, int r105) {
        Intrinsics.checkNotNullParameter(r100, PickerReporterConstants.KEY.TARGET);
    }

    @Override // androidx.core.view.NestedScrollingParent3
    public final void onNestedScroll(View r100, int r101, int r102, int r103, int r104, int r105, int[] r106) {
        Intrinsics.checkNotNullParameter(r100, PickerReporterConstants.KEY.TARGET);
        Intrinsics.checkNotNullParameter(r106, "consumed");
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public final void onNestedScrollAccepted(View r100, View r101, int r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        Intrinsics.checkNotNullParameter(r101, PickerReporterConstants.KEY.TARGET);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public final boolean onStartNestedScroll(View r100, View r101, int r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        Intrinsics.checkNotNullParameter(r101, PickerReporterConstants.KEY.TARGET);
        return true;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public final void onStopNestedScroll(View r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, PickerReporterConstants.KEY.TARGET);
    }

    public final void h() {
        com.bytedance.android.shopping.collect.slice.a r100 = this.f172288l;
        if (r100 == null) goto L5;
        Function0<ProductCardContainerView> r101 = r100.f172277a;
    L6:
        if (r101 != null) goto L8;
    L10:
        this.f172281e.forceFinished(true);
        setTranslationX(0.0f);
        return;
    L8:
        if (Intrinsics.areEqual(r100.f172277a.invoke(), this) == false) goto L10;
        this.f172288l.f172278b.invoke(null);
        goto L10
    L5:
        r101 = null;
        goto L6
    }

    @Override // android.view.View
    public final void computeScroll() {
        super.computeScroll();
        if (this.f172281e.computeScrollOffset() == false) goto L6;
        setTranslationX(this.f172281e.getCurrX());
        invalidate();
        return;
    }

    public final com.bytedance.android.shopping.collect.slice.a getActions() {
        return this.f172288l;
    }

    public final SlcTemplateContext getSlcTemplateContext() {
        return this.f172287k;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override // com.bytedance.android.ecom.arch.slice.render.widget.yoga.SlcYogaLayout, android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r100) {
        Object r101 = this.f172287k.f50235w.g("yataInstance");
        Function0<ProductCardContainerView> r102 = null;
        if ((r101 instanceof AndroidYaTaInstance) == true) goto L5;
        r101 = null;
    L5:
        AndroidYaTaInstance r103 = (AndroidYaTaInstance) r101;
        if (r103 == null) goto L12;
        Object r104 = r103.i("is_from_guest");
        if (r104 == null) goto L12;
        String r105 = r104.toString();
        if (r105 == null) goto L12;
        boolean r106 = k.n(r105, false);
    L13:
        if (r106 == true) goto L15;
        if (r100 != null) goto L18;
        return false;
    L18:
        com.bytedance.android.shopping.collect.slice.a r107 = this.f172288l;
        if (r107 == null) goto L23;
        Function1<ProductCardContainerView, Unit> r108 = r107.f172280d;
        if (r108 == null) goto L23;
        r108.invoke(this);
    L23:
        com.bytedance.android.shopping.collect.slice.a r109 = this.f172288l;
        if (r109 == null) goto L27;
        r102 = r109.f172277a;
    L27:
        if (r102 != null) goto L29;
    L35:
        int r110 = (int) getTranslationX();
        int r111 = (int) r100.getRawX();
        int r112 = r100.getAction();
        if (r112 != 0) goto L38;
        this.f172284h = r111;
        this.f172282f = r111;
        this.f172285i = 0;
    L57:
        if (this.f172285i != 1) goto L59;
    L60:
        return true;
    L59:
        if (super.dispatchTouchEvent(r100) == true) goto L60;
        return false;
    L38:
        if (r112 == 1) goto L46;
        if (r112 != 2) goto L41;
        int r113 = this.f172282f - r111;
        this.f172282f = r111;
        if (Math.abs(r111 - this.f172284h) <= ViewConfiguration.get(getContext()).getScaledTouchSlop()) goto L57;
        getParent().requestDisallowInterceptTouchEvent(true);
        setTranslationX(-Math.min(this.f172283g, Math.max(0, r113 - r110)));
        this.f172285i = 1;
        goto L57
    L41:
        if (r112 != 3) goto L57;
    L46:
        this.f172282f = 0;
        this.f172284h = 0;
        if (this.f172285i != 1) goto L57;
        if (ECSettingKeys.s() == false) goto L52;
        cancelLongPress();
    L52:
        if (Math.abs(r110) >= (this.f172283g / 2)) goto L54;
        g(this, false);
        goto L57
    L54:
        g(this, true);
        goto L57
    L29:
        if (r109.f172277a.invoke() == null) goto L35;
        if ((!Intrinsics.areEqual(this.f172288l.f172277a.invoke(), this)) == false) goto L35;
        ProductCardContainerView r114 = this.f172288l.f172277a.invoke();
        if (r114 == null) goto L35;
        g(r114, false);
        goto L35
    L15:
        return super.dispatchTouchEvent(r100);
    L12:
        r106 = false;
        goto L13
    }

    public static void g(ProductCardContainerView r100, boolean r101) {
        int r102 = (int) r100.getTranslationX();
        if (r101 == false) goto L12;
        com.bytedance.android.shopping.collect.slice.a r103 = r100.f172288l;
        if (r103 == null) goto L9;
        Function1<ProductCardContainerView, Unit> r104 = r103.f172278b;
        if (r104 == null) goto L9;
        r104.invoke(r100);
    L9:
        r100.f172281e.startScroll(r102, 0, (-r100.f172283g) - r102, 0, 200);
        BaseSlcViewManager<?> r105 = SlcViewExtensionsKt.g(r100);
        if (r105 == null) goto L20;
        r105.f50260a.d(new SlcCommonAction("collectListDeleteShow", null, 2, null), r100, r105.l(), null, null);
    L20:
        r100.invalidate();
        return;
    L12:
        r100.f172281e.startScroll(r102, 0, -r102, 0, 200);
        com.bytedance.android.shopping.collect.slice.a r106 = r100.f172288l;
        if (r106 == null) goto L15;
        Function0<ProductCardContainerView> r107 = r106.f172277a;
    L16:
        if (r107 == null) goto L20;
        if (Intrinsics.areEqual(r106.f172277a.invoke(), r100) == false) goto L20;
        r100.f172288l.f172278b.invoke(null);
        goto L20
    L15:
        r107 = null;
        goto L16
    }

    public ProductCardContainerView(Context r100, SlcTemplateContext r101, com.bytedance.android.shopping.collect.slice.a r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "slcTemplateContext");
        super(r100, null, 0);
        this.f172287k = r101;
        this.f172288l = r102;
        this.f172281e = new Scroller(r100);
        Resources r103 = Resources.getSystem();
        this.f172283g = MathKt.roundToInt(TypedValue.applyDimension(1, 210, WindowDisplayMetricsOverride.apply(r103, r103.getDisplayMetrics())));
        this.f172286j = CollectionsKt.emptyList();
    }
}
