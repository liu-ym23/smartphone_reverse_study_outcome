package com.obric.autoaction.vdplayer.components.panel;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.obric.oui.markdown.OMarkdownView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import d.l.n;

/* JADX INFO: compiled from: VDPlayerMarkdownView.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class VDPlayerMarkdownView extends FrameLayout {
    private final OMarkdownView markdownView;
    private int maxMarkdownHeightPx;

    /* JADX WARN: Multi-variable type inference failed */
    public VDPlayerMarkdownView(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        o.e(r4, "context");
        this(r4, null, 2, 0 == true ? 1 : 0);
    }

    public /* synthetic */ VDPlayerMarkdownView(Context r2, AttributeSet r3, int r4, h r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.aiagent.plugin");
        if ((r4 & 2) == 0) goto L5;
        r7 = null;
    L5:
        this(r6, r7);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public VDPlayerMarkdownView(Context r4, AttributeSet r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r5, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r6, "context");
        super(r6, r7);
        OMarkdownView r8 = new OMarkdownView(r6, null, 2, 0 == true ? 1 : 0);
        r8.setOverScrollMode(2);
        r8.setVerticalFadingEdgeEnabled(true);
        r8.setFadingEdgeLength(d.i.a.a(20 * ZeusTransformUtils.getResources(r8, "com.obric.aiagent.plugin").getDisplayMetrics().density));
        this.markdownView = r8;
        this.maxMarkdownHeightPx = Integer.MAX_VALUE;
        addView((View) ZeusTransformUtils.preCheckCast(r8, View.class, "com.obric.aiagent.plugin"), (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(new FrameLayout.LayoutParams(-1, -2), ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
    }

    public final int getMaxMarkdownHeightPx() {
        return this.maxMarkdownHeightPx;
    }

    public final void setMaxMarkdownHeightPx(int r1) {
        this.maxMarkdownHeightPx = r1;
    }

    public final OMarkdownView.a getDelegate() {
        return this.markdownView.getDelegate();
    }

    public final void setDelegate(OMarkdownView.a r3) {
        OMarkdownView.a r4 = (OMarkdownView.a) ZeusTransformUtils.wrapperContextForParams(r3, OMarkdownView.a.class, "com.obric.aiagent.plugin");
        this.markdownView.setDelegate(r4);
    }

    public final void setStyle(com.obric.oui.markdown.d r2) {
        o.e(r2, "style");
        this.markdownView.setStyle(r2);
    }

    public final void setMarkdownContent(String r2) {
        o.e(r2, "content");
        this.markdownView.setMarkdownContent(r2);
        this.markdownView.requestLayout();
        requestLayout();
    }

    public final void scrollContentToTop() {
        this.markdownView.scrollTo(0, 0);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int r7, int r8) {
        int r0 = FrameLayout.getChildMeasureSpec(r7, getPaddingLeft() + getPaddingRight(), -1);
        this.markdownView.measure(r0, View.MeasureSpec.makeMeasureSpec(0, 0));
        int r1 = this.markdownView.getContentHeight();
        if (r1 > 0) goto L6;
        super.onMeasure(r7, r8);
        return;
    L6:
        int r2 = (r1 + getPaddingTop()) + getPaddingBottom();
        int r3 = View.MeasureSpec.getMode(r8);
        if (r3 == Integer.MIN_VALUE) goto L11;
        if (r3 != 1073741824) goto L12;
        r2 = View.MeasureSpec.getSize(r8);
    L12:
        int r9 = n.d(r2, this.maxMarkdownHeightPx);
        int r4 = n.c((r9 - getPaddingTop()) - getPaddingBottom(), 0);
        this.markdownView.measure(r0, View.MeasureSpec.makeMeasureSpec(r4, 1073741824));
        int r5 = View.MeasureSpec.getMode(r7);
        if (r5 == Integer.MIN_VALUE) goto L16;
        if (r5 == 1073741824) goto L16;
        int r10 = (this.markdownView.getMeasuredWidth() + getPaddingLeft()) + getPaddingRight();
    L17:
        setMeasuredDimension(r10, r9);
        return;
    L16:
        r10 = View.MeasureSpec.getSize(r7);
        goto L17
    L11:
        r2 = n.d(r2, View.MeasureSpec.getSize(r8));
        goto L12
    }
}
