package com.bytedance.android.ecom.arch.slice.render.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeProvider;
import androidx.core.view.ViewCompat;
import com.amap.api.col.s.ce;
import com.bytedance.android.ecom.arch.slice.render.SliceRender;
import com.bytedance.android.ecom.arch.slice.render.context.SlcTemplateContext;
import com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewManager;
import com.bytedance.android.ecom.arch.slice.render.util.accessibility.SlcA11yDelegate;
import com.bytedance.android.ecom.arch.slice.render.widget.yoga.SlcYogaLayout;
import com.bytedance.android.ecom.arch.slice.render.widget.yoga.c;
import com.facebook.yoga.YogaAlign;
import com.facebook.yoga.YogaFlexDirection;
import com.facebook.yoga.YogaNode;
import com.facebook.yoga.YogaUnit;
import com.facebook.yoga.YogaValue;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0002\u001f B'\b\u0007\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001a\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u000f¢\u0006\u0004\b\u001d\u0010\u001eJ\u001b\u0010\u0007\u001a\u00020\u00042\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0000¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\f\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0000¢\u0006\u0004\b\n\u0010\u000bJ\n\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016R\u001b\u0010\u0014\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001b\u0010\u0017\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0011\u001a\u0004\b\u0016\u0010\u0013¨\u0006!"}, d2 = {"Lcom/bytedance/android/ecom/arch/slice/render/widget/SlcRootView;", "Lcom/bytedance/android/ecom/arch/slice/render/widget/yoga/SlcYogaLayout;", "Lcom/bytedance/android/ecom/arch/slice/render/elements/BaseSlcViewManager;", "viewManager", "", "setRootViewManager$slice_render_release", "(Lcom/bytedance/android/ecom/arch/slice/render/elements/BaseSlcViewManager;)V", "setRootViewManager", "Lcom/bytedance/android/ecom/arch/slice/render/widget/SlcRootView$b;", "listener", "setCreateLayoutListener$slice_render_release", "(Lcom/bytedance/android/ecom/arch/slice/render/widget/SlcRootView$b;)V", "setCreateLayoutListener", "Landroid/view/accessibility/AccessibilityNodeProvider;", "getAccessibilityNodeProvider", "", ce.f26391f, "Lkotlin/Lazy;", "getTagHeight", "()I", "tagHeight", "h", "getTagWidth", "tagWidth", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "slice-render_release"}, k = 1, mv = {1, 4, 0})
public final class SlcRootView extends SlcYogaLayout {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f50779s = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final YogaNode f50780e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f50781f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f50782g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f50783h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public BaseSlcViewManager<?> f50784i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public YogaNode f50785j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public b f50786k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f50787l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f50788m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f50789n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f50790o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f50791p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public SlcA11yDelegate f50792q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f50793r;

    public static final class a {
    }

    public interface b {
        void a(boolean r100);

        void onStart();
    }

    static {
        f50779s = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(SlcRootView.class), "tagHeight", "getTagHeight()I")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(SlcRootView.class), "tagWidth", "getTagWidth()I"))};
    }

    public SlcRootView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public SlcRootView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    private final int getTagHeight() {
        Lazy r100 = this.f50782g;
        KProperty r101 = f50779s[0];
        return ((Number) r100.getValue()).intValue();
    }

    private final int getTagWidth() {
        Lazy r100 = this.f50783h;
        KProperty r101 = f50779s[1];
        return ((Number) r100.getValue()).intValue();
    }

    public final void g() {
        YogaNode r100 = this.f50785j;
        if (r100 == null) goto L11;
        int r101 = this.f50780e.getChildCount();
        int r102 = 0;
    L5:
        if (r102 >= r101) goto L14;
        if (Intrinsics.areEqual(this.f50780e.getChildAt(r102).getData(), r100.getData()) == true) goto L8;
        r102 = r102 + 1;
        goto L5
    L8:
        this.f50780e.removeChildAt(r102);
        return;
    L14:
        return;
    }

    @Override // android.view.View
    public AccessibilityNodeProvider getAccessibilityNodeProvider() {
        SliceRender.f50121o.getClass();
        if (SliceRender.b() == false) goto L21;
        if (this.f50793r == false) goto L7;
        return null;
    L7:
        BaseSlcViewManager<?> r100 = this.f50784i;
        if (r100 == null) goto L19;
        SlcA11yDelegate r101 = this.f50792q;
        if (r101 != null) goto L12;
        this.f50793r = true;
        r101 = new SlcA11yDelegate(this, r100);
        this.f50792q = r101;
        ViewCompat.setAccessibilityDelegate(this, r101);
        this.f50793r = false;
    L12:
        Object r102 = r101.f50716a.getProvider();
        if ((r102 instanceof AccessibilityNodeProvider) == true) goto L15;
        r102 = null;
    L15:
        AccessibilityNodeProvider r103 = (AccessibilityNodeProvider) r102;
        if (r103 == null) goto L18;
        return r103;
    L18:
        nq.a.b(null, AnonymousClass1.INSTANCE);
    L19:
        return null;
    L21:
        return super.getAccessibilityNodeProvider();
    }

    @Override // android.view.View, android.view.ViewParent
    public final void requestLayout() {
        if (this.f50781f == false) goto L5;
        this.f50787l = true;
    L5:
        super.requestLayout();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchHoverEvent(MotionEvent r100) {
        BaseSlcViewManager<?> r101 = this.f50784i;
        SliceRender.f50121o.getClass();
        if (SliceRender.b() == false) goto L17;
        if (com.bytedance.android.ecom.arch.slice.render.util.accessibility.a.f50730d.c(getContext()) == false) goto L17;
        if (r101 == null) goto L17;
        SlcA11yDelegate r102 = this.f50792q;     // Catch: Throwable -> L13
        if (r102 != null) goto L11;
        this.f50793r = true;     // Catch: Throwable -> L13
        r102 = new SlcA11yDelegate(this, r101);     // Catch: Throwable -> L13
        this.f50792q = r102;     // Catch: Throwable -> L13
        ViewCompat.setAccessibilityDelegate(this, r102);     // Catch: Throwable -> L13
        this.f50793r = false;     // Catch: Throwable -> L13
    L11:
        return r102.dispatchHoverEvent(r100);
    L13:
        th = move-exception;
        nq.a.f(th, null);
        return false;
    L17:
        return super.dispatchHoverEvent(r100);
    }

    @Override // com.bytedance.android.ecom.arch.slice.render.widget.yoga.SlcYogaLayout, android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r100) {
        BaseSlcViewManager<?> r101 = this.f50784i;
        if (r101 == null) goto L8;
        if (r101.f50260a.f50231s <= 0) goto L8;
        MotionEvent r102 = MotionEvent.obtain(r100);
        r101.F(r102);
        r102.recycle();
    L8:
        return super.dispatchTouchEvent(r100);
    }

    public final void setCreateLayoutListener$slice_render_release(b r100) {
        this.f50786k = r100;
    }

    public final void setRootViewManager$slice_render_release(BaseSlcViewManager<?> r100) {
        if (this.f50784i != null) goto L5;
        boolean r101 = true;
    L6:
        nq.a.d(r101, null, null);
        g();
        this.f50784i = r100;
        this.f50781f = r100.f50260a.f50235w.S;
        this.f50780e.addChildAt(r100.f50272f, 0);
        addView(r100.getView(), 0);
        return;
    L5:
        r101 = false;
        goto L6
    }

    @Override // com.bytedance.android.ecom.arch.slice.render.widget.yoga.SlcYogaLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        if (this.f50781f == true) goto L5;
    L12:
        b r102 = this.f50786k;
        if (r102 == null) goto L15;
        r102.onStart();
    L15:
        super.onMeasure(r100, r101);
        b r103 = this.f50786k;
        if (r103 == null) goto L19;
        r103.a(false);
    L19:
        if (this.f50781f == false) goto L22;
        this.f50788m = r100;
        this.f50789n = r101;
        this.f50790o = getMeasuredWidth();
        this.f50791p = getMeasuredHeight();
        this.f50787l = false;
        return;
    L22:
        return;
    L5:
        if (this.f50787l == true) goto L12;
        if (r100 != this.f50788m) goto L12;
        if (r101 != this.f50789n) goto L12;
        setMeasuredDimension(this.f50790o, this.f50791p);
    }

    public SlcRootView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        YogaNode r103 = c.f(this, false);
        r103.setFlexDirection(YogaFlexDirection.COLUMN);
        r103.setAlignItems(YogaAlign.STRETCH);
        r103.setMeasureFunction(null);
        this.f50780e = r103;
        this.f50782g = LazyKt.lazy(new SlcRootView$tagHeight$2(this));
        this.f50783h = LazyKt.lazy(new SlcRootView$tagWidth$2(this));
        setId(2022101921);
        this.f51020a = r103;
        SliceRender.f50121o.getClass();
        if (SliceRender.b() == true) goto L5;
        setImportantForAccessibility(2);
    L5:
        pq.a r104 = SliceRender.f50108b;
        if (r104 == null) goto L9;
        r104.f();
    L9:
        if (SliceRender.f() == false) goto L11;
        setClipChildren(false);
    L11:
        this.f50787l = true;
    }

    public /* synthetic */ SlcRootView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    @Override // com.bytedance.android.ecom.arch.slice.render.widget.yoga.SlcYogaLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r110, int r111, int r210, int r211, int r212) {
        b r100 = this.f50786k;
        if (r100 == null) goto L5;
        r100.onStart();
    L5:
        super.onLayout(r110, r111, r210, r211, r212);
        b r101 = this.f50786k;
        if (r101 == null) goto L8;
        r101.a(true);
    L8:
        BaseSlcViewManager<?> r102 = this.f50784i;
        if (r102 != null) goto L11;
        return;
    L11:
        if (r102.f50260a.f50235w.f50170e == true) goto L84;
        if (r110 == true) goto L14;
        return;
    L14:
        if (isAttachedToWindow() == true) goto L16;
        return;
    L16:
        if ((r211 - r111) != 0) goto L18;
    L19:
        boolean r103 = r102.r0();
        SlcTemplateContext r104 = r102.f50260a;
        ViewGroup.LayoutParams r105 = getLayoutParams();
        if (r103 == false) goto L22;
        return;
    L22:
        if (r104.f50223k != 0) goto L24;
        return;
    L24:
        if (r105.height != 0) goto L26;
        return;
    L26:
        if (r105.width == 0) goto L91;
        YogaNode r106 = this.f50780e;
        YogaValue r107 = r106.getWidth();
        YogaValue r112 = r106.getHeight();
        YogaValue r113 = r106.getMaxWidth();
        YogaValue r108 = r106.getMaxHeight();
        YogaUnit r114 = r112.unit;
        YogaUnit r115 = YogaUnit.POINT;
        if (r114 == r115) goto L32;
        if (r114 == YogaUnit.PERCENT) goto L32;
    L33:
        YogaUnit r116 = r107.unit;
        if (r116 == r115) goto L38;
        if (r116 == YogaUnit.PERCENT) goto L38;
    L39:
        YogaUnit r109 = r108.unit;
        if (r109 == r115) goto L44;
        if (r109 == YogaUnit.PERCENT) goto L44;
    L45:
        YogaUnit r117 = r113.unit;
        if (r117 == r115) goto L50;
        if (r117 == YogaUnit.PERCENT) goto L50;
    L51:
        boolean r118 = true;
    L53:
        if (r118 == false) goto L92;
        YogaNode r119 = r102.f50272f;
        YogaValue r120 = r119.getWidth();
        YogaValue r121 = r119.getHeight();
        YogaValue r122 = r119.getMaxWidth();
        YogaValue r123 = r119.getMaxHeight();
        YogaUnit r124 = r121.unit;
        if (r124 == r115) goto L59;
        if (r124 == YogaUnit.PERCENT) goto L59;
    L60:
        YogaUnit r125 = r120.unit;
        if (r125 == r115) goto L65;
        if (r125 == YogaUnit.PERCENT) goto L65;
    L66:
        YogaUnit r126 = r123.unit;
        if (r126 == r115) goto L71;
        if (r126 == YogaUnit.PERCENT) goto L71;
    L72:
        YogaUnit r127 = r122.unit;
        if (r127 == r115) goto L77;
        if (r127 == YogaUnit.PERCENT) goto L77;
    L78:
        boolean r128 = true;
    L80:
        if (r128 == false) goto L93;
        com.bytedance.android.ecom.arch.slice.render.event.monitor.a.a(new com.bytedance.android.ecom.arch.slice.render.event.monitor.a("SIZE_INVALID", "layout_size_invalid", "l:" + r111 + ",t:" + r210 + ",r:" + r211 + ",b:" + r212 + ",bindCount:" + r104.f50223k, null, null, null, 56), r104, null, false, 6);
        return;
    L93:
        return;
    L77:
        if (r122.value != 0.0f) goto L78;
    L79:
        r128 = false;
    L71:
        if (r123.value == 0.0f) goto L79;
    L65:
        if (r120.value == 0.0f) goto L79;
    L59:
        if (r121.value == 0.0f) goto L79;
    L92:
        return;
    L50:
        if (r113.value != 0.0f) goto L51;
    L52:
        r118 = false;
    L44:
        if (r108.value == 0.0f) goto L52;
    L38:
        if (r107.value == 0.0f) goto L52;
    L32:
        if (r112.value == 0.0f) goto L52;
    L91:
        return;
    L18:
        if ((r212 - r210) == 0) goto L19;
        return;
    }
}
