package com.bytedance.android.shopping.sku.common.slice.element;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.ecom.arch.slice.render.SliceRender;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/shopping/sku/common/slice/element/SkuCommonTagFlowLayout;", "Landroid/view/ViewGroup;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SkuCommonTagFlowLayout extends ViewGroup {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f182768a;

    public SkuCommonTagFlowLayout(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public SkuCommonTagFlowLayout(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet r100) {
        return new ViewGroup.MarginLayoutParams(getContext(), r100);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r100) {
        return new ViewGroup.MarginLayoutParams(r100);
    }

    @Override // android.view.View
    public final void onMeasure(int r110, int r111) {
        super.onMeasure(r110, r111);
        int r100 = View.MeasureSpec.getSize(r110);
        int r101 = getChildCount();
        int r102 = getPaddingStart() + getPaddingEnd();
        int r112 = r102;
        int r113 = getPaddingTop() + getPaddingBottom();
        int r114 = 0;
    L3:
        if (r114 >= r101) goto L16;
        View r115 = getChildAt(r114);
        ViewGroup.LayoutParams r116 = r115.getLayoutParams();
        if ((r116 instanceof ViewGroup.MarginLayoutParams) == false) goto L11;
        SliceRender.f50121o.getClass();
        if (SliceRender.d() == false) goto L9;
        int r103 = 0;
    L10:
        measureChildWithMargins(r115, r110, 0, r111, r103);
        ViewGroup.MarginLayoutParams r117 = (ViewGroup.MarginLayoutParams) r116;
        int r104 = r117.leftMargin + r117.rightMargin;
        int r105 = r117.topMargin + r117.bottomMargin;
        int r106 = r104;
        int r107 = r105;
    L12:
        int r108 = r115.getMeasuredWidth() + r106;
        int r109 = r115.getMeasuredHeight() + r107;
        Pair r118 = TuplesKt.to(Integer.valueOf(r108), Integer.valueOf(r109));
        int r119 = ((Number) r118.getFirst()).intValue();
        int r120 = ((Number) r118.getSecond()).intValue();
        int r121 = r119 + r112;
        if (r121 > r100) goto L16;
        this.f182768a = r114;
        r113 = Math.max(r113, r120);
        r114 = r114 + 1;
        r112 = r121;
        goto L3
    L9:
        r103 = getMeasuredHeight();
        goto L10
    L11:
        measureChild(r115, r110, r111);
        r106 = 0;
        r107 = 0;
    L16:
        setMeasuredDimension(r112, r113);
    }

    public SkuCommonTagFlowLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
    }

    public /* synthetic */ SkuCommonTagFlowLayout(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        int r105 = getPaddingStart();
        int r106 = this.f182768a;
        if (r106 < 0) goto L11;
        int r107 = 0;
    L5:
        View r108 = getChildAt(r107);
        if (r108 == null) goto L9;
        int r109 = getPaddingTop();
        int r110 = r108.getMeasuredWidth() + r105;
        r108.layout(r105, r109, r110, r108.getMeasuredHeight() + r109);
        r105 = r110;
    L9:
        if (r107 == r106) goto L13;
        r107 = r107 + 1;
        goto L5
    L13:
        return;
    }
}
