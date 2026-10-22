package com.obric.oui.common.widget;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.widget.NestedScrollView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import d.l.n;

/* JADX INFO: compiled from: MaxHeightNestedScrollView.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class MaxHeightNestedScrollView extends NestedScrollView {
    private int maxHeightPx;

    public MaxHeightNestedScrollView(Context r7) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");
        o.e(r1, "context");
        this(r1, null, 0, 6, null);
    }

    public MaxHeightNestedScrollView(Context r9, AttributeSet r10) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r3, "context");
        this(r3, r4, 0, 4, null);
    }

    public /* synthetic */ MaxHeightNestedScrollView(Context r2, AttributeSet r3, int r4, int r5, h r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.aiagent.plugin");
        if ((r5 & 2) == 0) goto L6;
        r8 = null;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = 0;
    L8:
        this(r7, r8, r4);
    }

    public MaxHeightNestedScrollView(Context r4, AttributeSet r5, int r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r5, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r7, "context");
        super(r7, r8, r6);
        this.maxHeightPx = Integer.MAX_VALUE;
        if (r8 == null) goto L6;
        TypedArray r9 = r7.obtainStyledAttributes(r8, new int[]{R.attr.maxHeight});
        o.c(r9, "context.obtainStyledAttr…ndroid.R.attr.maxHeight))");
        this.maxHeightPx = r9.getDimensionPixelSize(0, Integer.MAX_VALUE);
        r9.recycle();
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
    public void onMeasure(int r3, int r4) {
        if (this.maxHeightPx == Integer.MAX_VALUE) goto L5;
        int r0 = View.MeasureSpec.getMode(r4);
        r4 = View.MeasureSpec.makeMeasureSpec(n.d(View.MeasureSpec.getSize(r4), this.maxHeightPx), r0);
    L5:
        super.onMeasure(r3, r4);
        if (getMeasuredHeight() <= this.maxHeightPx) goto L9;
        setMeasuredDimension(getMeasuredWidth(), this.maxHeightPx);
        return;
    }
}
