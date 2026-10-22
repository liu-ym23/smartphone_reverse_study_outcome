package com.obric.oui.indicator;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.obric.oui.common.style.l;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: IndicatorDotView.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class IndicatorDotView extends View implements e {
    private final RectF bgRectF;
    private float cornerRadius;
    private int dotColor;
    private final Paint dotPaint;
    private int strokeColor;
    private final Paint strokePaint;
    private final RectF strokeRectF;
    private float strokeWidth;

    public IndicatorDotView(Context r7) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");
        o.e(r1, "context");
        this(r1, null, 0, 6, null);
    }

    public IndicatorDotView(Context r9, AttributeSet r10) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r3, "context");
        this(r3, r4, 0, 4, null);
    }

    public /* synthetic */ IndicatorDotView(Context r2, AttributeSet r3, int r4, int r5, d.h.b.h r6) {
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

    public IndicatorDotView(Context r3, AttributeSet r4, int r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r6, "context");
        super(r6, r7, r5);
        this.bgRectF = new RectF();
        this.strokeRectF = new RectF();
        Paint r8 = new Paint(1);
        r8.setStyle(Paint.Style.FILL);
        this.dotPaint = r8;
        Paint r9 = new Paint(1);
        r9.setStyle(Paint.Style.STROKE);
        this.strokePaint = r9;
        this.dotColor = -7829368;
    }

    public int getDotColor() {
        return this.dotColor;
    }

    @Override // com.obric.oui.indicator.e
    public void setDotColor(int r2) {
        if (this.dotColor == r2) goto L5;
        this.dotColor = r2;
    L5:
        this.dotPaint.setColor(r2);
    }

    public void setWidth(int r3) {
        d.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), r3);
    }

    @Override // com.obric.oui.indicator.e
    public void setHorizontalMargin(int r3) {
        d.c((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), r3);
    }

    @Override // com.obric.oui.indicator.e
    public void setStartMargin(int r5) {
        ViewGroup.LayoutParams r0 = getLayoutParams();
        ViewGroup.MarginLayoutParams r3 = null;
        if (ZeusTransformUtils.instanceOf(r0, ViewGroup.MarginLayoutParams.class) == false) goto L5;
        ViewGroup.MarginLayoutParams r1 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r0, ViewGroup.MarginLayoutParams.class, "com.obric.aiagent.plugin");
    L6:
        if (r1 == null) goto L9;
        r1.setMarginStart(r5);
        requestLayout();
        r3 = r1;
    L9:
        setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r3, ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
        return;
    L5:
        r1 = null;
        goto L6
    }

    @Override // com.obric.oui.indicator.e
    public void setEndMargin(int r5) {
        ViewGroup.LayoutParams r0 = getLayoutParams();
        ViewGroup.MarginLayoutParams r3 = null;
        if (ZeusTransformUtils.instanceOf(r0, ViewGroup.MarginLayoutParams.class) == false) goto L5;
        ViewGroup.MarginLayoutParams r1 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r0, ViewGroup.MarginLayoutParams.class, "com.obric.aiagent.plugin");
    L6:
        if (r1 == null) goto L9;
        r1.setMarginEnd(r5);
        requestLayout();
        r3 = r1;
    L9:
        setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r3, ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
        return;
    L5:
        r1 = null;
        goto L6
    }

    public int getStrokeColor() {
        return this.strokeColor;
    }

    @Override // com.obric.oui.indicator.e
    public void setStrokeColor(int r2) {
        if (this.strokeColor == r2) goto L5;
        this.strokeColor = r2;
    L5:
        this.strokePaint.setColor(r2);
    }

    public float getStrokeWidth() {
        return this.strokeWidth;
    }

    @Override // com.obric.oui.indicator.e
    public void setStrokeWidth(float r2) {
        if (this.strokeWidth != r2) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L8;
        this.strokeWidth = r2;
    L8:
        this.strokePaint.setStrokeWidth(r2);
        return;
    L5:
        r0 = false;
        goto L6
    }

    public float getCornerRadius() {
        return this.cornerRadius;
    }

    @Override // com.obric.oui.indicator.e
    public void setCornerRadius(float r1) {
        this.cornerRadius = r1;
    }

    @Override // android.view.View
    public void onDraw(Canvas r8) {
        o.e(r8, "canvas");
        super.onDraw(r8);
        this.bgRectF.set(0.0f, 0.0f, getWidth(), getHeight());
        l.a(r8, this.bgRectF, getCornerRadius(), this.dotPaint);
        if (getStrokeWidth() <= 0.0f) goto L6;
        float r2 = 2;
        this.strokeRectF.set(getStrokeWidth() / r2, getStrokeWidth() / r2, getWidth() - (getStrokeWidth() / r2), getHeight() - (getStrokeWidth() / r2));
        l.a(r8, this.strokeRectF, getCornerRadius(), this.strokePaint);
        return;
    }
}
