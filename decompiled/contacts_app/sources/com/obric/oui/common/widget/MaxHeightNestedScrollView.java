package com.obric.oui.common.widget;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.widget.NestedScrollView;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: MaxHeightNestedScrollView.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0007H\u0014J\u000e\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u0007R\u000e\u0010\t\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/obric/oui/common/widget/MaxHeightNestedScrollView;", "Landroidx/core/widget/NestedScrollView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "maxHeightPx", "onMeasure", "", "widthMeasureSpec", "heightMeasureSpec", "setMaxHeight", "maxHeight", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class MaxHeightNestedScrollView extends NestedScrollView {
    private int maxHeightPx;

    public MaxHeightNestedScrollView(Context r8) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, null, 0, 6, null);
    }

    public MaxHeightNestedScrollView(Context r8, AttributeSet r9) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, r9, 0, 4, null);
    }

    public /* synthetic */ MaxHeightNestedScrollView(Context r1, AttributeSet r2, int r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = 0;
    L8:
        this(r1, r2, r3);
    }

    public MaxHeightNestedScrollView(Context r4, AttributeSet r5, int r6) {
        Intrinsics.checkNotNullParameter(r4, "context");
        super(r4, r5, r6);
        this.maxHeightPx = Integer.MAX_VALUE;
        if (r5 == null) goto L6;
        TypedArray r7 = r4.obtainStyledAttributes(r5, new int[]{R.attr.maxHeight});
        Intrinsics.checkNotNullExpressionValue(r7, "context.obtainStyledAttr…ndroid.R.attr.maxHeight))");
        this.maxHeightPx = r7.getDimensionPixelSize(0, Integer.MAX_VALUE);
        r7.recycle();
        return;
    }

    public final void setMaxHeight(int r2) {
        if (this.maxHeightPx != r2) goto L5;
        return;
    L5:
        this.maxHeightPx = r2;
        requestLayout();
    }

    @Override // androidx.core.widget.NestedScrollView, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int r3, int r4) {
        if (this.maxHeightPx == Integer.MAX_VALUE) goto L5;
        int r0 = View.MeasureSpec.getMode(r4);
        r4 = View.MeasureSpec.makeMeasureSpec(RangesKt.coerceAtMost(View.MeasureSpec.getSize(r4), this.maxHeightPx), r0);
    L5:
        super.onMeasure(r3, r4);
        if (getMeasuredHeight() <= this.maxHeightPx) goto L9;
        setMeasuredDimension(getMeasuredWidth(), this.maxHeightPx);
        return;
    }
}
