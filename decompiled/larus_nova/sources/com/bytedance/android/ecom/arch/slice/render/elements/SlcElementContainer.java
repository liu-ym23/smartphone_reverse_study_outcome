package com.bytedance.android.ecom.arch.slice.render.elements;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.ecom.arch.slice.render.util.SlcViewExtensionsKt;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0013\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R.\u0010\u000e\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0011\u0010\u0010\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/ecom/arch/slice/render/elements/SlcElementContainer;", "Landroid/view/ViewGroup;", "", "clipChildren", "", "setClipChildren", "Landroid/view/View;", "view", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Landroid/view/View;", "getContentView", "()Landroid/view/View;", "setContentView", "(Landroid/view/View;)V", "contentView", "getContentViewNotNull", "contentViewNotNull", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "slice-render_release"}, k = 1, mv = {1, 4, 0})
public class SlcElementContainer extends ViewGroup {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f50339a;

    public SlcElementContainer(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public SlcElementContainer(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final View getContentViewNotNull() {
        View r100 = this.f50339a;
        if (r100 == null) goto L6;
        return r100;
    L6:
        throw new IllegalStateException("Required value was null.".toString());
    }

    public final View getContentView() {
        return this.f50339a;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(final Canvas r100) {
        SlcViewExtensionsKt.b(this, r100, new AnonymousClass1(this, r100));
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchHoverEvent(MotionEvent r100) {
        return super.dispatchHoverEvent(r100);
    }

    @Override // android.view.View
    public final void forceHasOverlappingRendering(boolean r100) {
        super.forceHasOverlappingRendering(r100);
        if (Build.VERSION.SDK_INT < 24) goto L8;
        View r101 = this.f50339a;
        if (r101 == null) goto L9;
        r101.forceHasOverlappingRendering(r100);
        return;
    L9:
        return;
    }

    @Override // android.view.ViewGroup
    public void setClipChildren(boolean r100) {
        super.setClipChildren(r100);
        View r101 = this.f50339a;
        if ((r101 instanceof ViewGroup) == false) goto L6;
        ((ViewGroup) r101).setClipChildren(r100);
        return;
    }

    public final void setContentView(View r100) {
        if (this.f50339a == null) goto L8;
        nq.a.c(null, SlcElementContainer$contentView$1.INSTANCE, 1);
        if (Intrinsics.areEqual(r100, this.f50339a) == false) goto L7;
        return;
    L7:
        removeView(this.f50339a);
    L8:
        this.f50339a = r100;
        addView(r100);
    }

    public static final /* synthetic */ void a(SlcElementContainer r100, Canvas r101) {
        super.dispatchDraw(r101);
    }

    @Override // android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        View r102 = this.f50339a;
        if (r102 == null) goto L5;
        int r103 = getPaddingLeft() + getPaddingRight();
        int r104 = getPaddingTop() + getPaddingBottom();
        int r105 = View.MeasureSpec.getMode(r100);
        int r106 = View.MeasureSpec.makeMeasureSpec(Math.max(0, View.MeasureSpec.getSize(r100) - r103), r105);
        int r107 = View.MeasureSpec.getMode(r101);
        r102.measure(r106, View.MeasureSpec.makeMeasureSpec(Math.max(0, View.MeasureSpec.getSize(r101) - r104), r107));
        setMeasuredDimension(r102.getMeasuredWidth() + r103, r102.getMeasuredHeight() + r104);
        return;
    L5:
        setMeasuredDimension(0, 0);
    }

    public SlcElementContainer(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
    }

    public /* synthetic */ SlcElementContainer(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        View r105 = this.f50339a;
        if (r105 == null) goto L6;
        r105.layout(getPaddingLeft(), getPaddingTop(), (r103 - r101) - getPaddingRight(), (r104 - r102) - getPaddingBottom());
        return;
    }
}
