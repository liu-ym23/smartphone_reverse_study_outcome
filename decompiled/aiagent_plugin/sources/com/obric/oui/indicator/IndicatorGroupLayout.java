package com.obric.oui.indicator;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.obric.oui.common.style.l;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: IndicatorGroupLayout.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class IndicatorGroupLayout extends LinearLayout {
    private int bgColor;
    private final Paint bgPaint;
    private int cornerRadius;
    private boolean drawSelf;
    private Integer fixedContentWidthPx;
    private final RectF rectF;

    public IndicatorGroupLayout(Context r7) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");
        o.e(r1, "context");
        this(r1, null, 0, 6, null);
    }

    public IndicatorGroupLayout(Context r9, AttributeSet r10) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r3, "context");
        this(r3, r4, 0, 4, null);
    }

    public /* synthetic */ IndicatorGroupLayout(Context r2, AttributeSet r3, int r4, int r5, d.h.b.h r6) {
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

    public IndicatorGroupLayout(Context r3, AttributeSet r4, int r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r6, "context");
        super(r6, r7, r5);
        this.rectF = new RectF();
        Paint r8 = new Paint(1);
        r8.setStyle(Paint.Style.FILL);
        this.bgPaint = r8;
        setBackgroundColor(0);
    }

    public final int getCornerRadius() {
        return this.cornerRadius;
    }

    public final void setCornerRadius(int r1) {
        this.cornerRadius = r1;
    }

    public final Integer getFixedContentWidthPx() {
        return this.fixedContentWidthPx;
    }

    public final void setFixedContentWidthPx(Integer r2) {
        if (o.a(this.fixedContentWidthPx, r2) == true) goto L6;
        this.fixedContentWidthPx = r2;
        requestLayout();
        invalidate();
        return;
    }

    public final int getBgColor() {
        return this.bgColor;
    }

    public final void setBgColor(int r2) {
        if (this.bgColor == r2) goto L5;
        this.bgColor = r2;
    L5:
        this.bgPaint.setColor(r2);
    }

    public final void setDrawBackground(boolean r1) {
        this.drawSelf = r1;
        invalidate();
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int r2, int r3) {
        super.onMeasure(r2, r3);
        Integer r4 = this.fixedContentWidthPx;
        if (r4 != null) goto L5;
        return;
    L5:
        int r5 = r4.intValue();
        int r6 = LinearLayout.resolveSize((getPaddingLeft() + r5) + getPaddingRight(), r2);
        if (getMeasuredWidth() == r6) goto L9;
        setMeasuredDimension(r6, getMeasuredHeight());
        return;
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onDraw(Canvas r5) {
        o.e(r5, "canvas");
        if (this.drawSelf == false) goto L5;
        this.rectF.set(0.0f, 0.0f, getWidth(), getHeight());
        l.a(r5, this.rectF, this.cornerRadius * 1.0f, this.bgPaint);
    L5:
        super.onDraw(r5);
    }
}
