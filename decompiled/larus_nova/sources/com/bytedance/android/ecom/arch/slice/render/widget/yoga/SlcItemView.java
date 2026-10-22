package com.bytedance.android.ecom.arch.slice.render.widget.yoga;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.accessibility.AccessibilityNodeProvider;
import androidx.core.view.ViewCompat;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.bytedance.android.ecom.arch.slice.render.SliceRender;
import com.bytedance.android.ecom.arch.slice.render.context.SlcTemplateContext;
import com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewManager;
import com.bytedance.android.ecom.arch.slice.render.util.accessibility.SlcA11yDelegate;
import com.facebook.yoga.YogaAlign;
import com.facebook.yoga.YogaFlexDirection;
import com.facebook.yoga.YogaNode;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0012\u0010\u0005\u001a\u00020\u00042\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002J\f\u0010\u0006\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0002J\n\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/ecom/arch/slice/render/widget/yoga/SlcItemView;", "Lcom/bytedance/android/ecom/arch/slice/render/widget/yoga/SlcYogaLayout;", "Lcom/bytedance/android/ecom/arch/slice/render/elements/BaseSlcViewManager;", "viewManager", "", "setRootViewManager", "getRootViewManager", "Landroid/view/accessibility/AccessibilityNodeProvider;", "getAccessibilityNodeProvider", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "slice-render_release"}, k = 1, mv = {1, 4, 0})
public final class SlcItemView extends SlcYogaLayout {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final YogaNode f51016e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public BaseSlcViewManager<?> f51017f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public SlcA11yDelegate f51018g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f51019h;

    @Override // android.view.View
    public AccessibilityNodeProvider getAccessibilityNodeProvider() {
        SliceRender.f50121o.getClass();
        if (SliceRender.b() == false) goto L21;
        if (this.f51019h == false) goto L7;
        return null;
    L7:
        BaseSlcViewManager<?> r100 = this.f51017f;
        if (r100 == null) goto L19;
        SlcA11yDelegate r101 = this.f51018g;
        if (r101 != null) goto L12;
        this.f51019h = true;
        r101 = new SlcA11yDelegate(this, r100);
        this.f51018g = r101;
        ViewCompat.setAccessibilityDelegate(this, r101);
        this.f51019h = false;
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

    public final BaseSlcViewManager<?> getRootViewManager() {
        return this.f51017f;
    }

    public SlcItemView(Context r100) {
        this(r100, null);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchHoverEvent(MotionEvent r100) {
        BaseSlcViewManager<?> r101 = this.f51017f;
        SliceRender.f50121o.getClass();
        if (SliceRender.b() == false) goto L17;
        if (com.bytedance.android.ecom.arch.slice.render.util.accessibility.a.f50730d.c(getContext()) == false) goto L17;
        if (r101 == null) goto L17;
        SlcA11yDelegate r102 = this.f51018g;     // Catch: Throwable -> L13
        if (r102 != null) goto L11;
        this.f51019h = true;     // Catch: Throwable -> L13
        r102 = new SlcA11yDelegate(this, r101);     // Catch: Throwable -> L13
        this.f51018g = r102;     // Catch: Throwable -> L13
        ViewCompat.setAccessibilityDelegate(this, r102);     // Catch: Throwable -> L13
        this.f51019h = false;     // Catch: Throwable -> L13
    L11:
        return r102.dispatchHoverEvent(r100);
    L13:
        th = move-exception;
        nq.a.f(th, null);
        return false;
    L17:
        return super.dispatchHoverEvent(r100);
    }

    public final void setRootViewManager(BaseSlcViewManager<?> r100) {
        if (this.f51017f == null) goto L5;
        return;
    L5:
        this.f51017f = r100;
        this.f51016e.addChildAt(r100.f50272f, 0);
        addView(r100.getView(), 0);
    }

    public SlcItemView(Context r100, AttributeSet r101) {
        super(r100, r101, 4, 0);
        YogaNode r102 = c.f(this, false);
        r102.setFlexDirection(YogaFlexDirection.COLUMN);
        r102.setAlignItems(YogaAlign.STRETCH);
        r102.setMeasureFunction(null);
        this.f51016e = r102;
        this.f51020a = r102;
        SliceRender.f50121o.getClass();
        if (SliceRender.f() == false) goto L6;
        setClipChildren(false);
        return;
    }

    public final void g(SlcTemplateContext r100, SlcElement r101) {
        if (this.f51017f == null) goto L5;
        return;
    L5:
        BaseSlcViewManager<?> r102 = r100.c(r101.getType(), true, false);
        setRootViewManager(r102);
        r102.m0(r101);
    }
}
