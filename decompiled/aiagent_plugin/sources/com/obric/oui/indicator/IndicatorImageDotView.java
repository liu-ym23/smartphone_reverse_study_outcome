package com.obric.oui.indicator;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: IndicatorImageDotView.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class IndicatorImageDotView extends AppCompatImageView implements e {
    private float cornerRadius;
    private int dotColor;
    private int strokeColor;
    private float strokeWidth;

    public IndicatorImageDotView(Context r3, Drawable r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        o.e(r5, "context");
        super(r5);
        this.dotColor = -7829368;
        setImageDrawable(r4);
        setScaleType(ImageView.ScaleType.CENTER_INSIDE);
    }

    public int getDotColor() {
        return this.dotColor;
    }

    @Override // com.obric.oui.indicator.e
    public void setDotColor(int r2) {
        if (this.dotColor == r2) goto L5;
        this.dotColor = r2;
    L5:
        setColorFilter(r2);
    }

    public void setWidth(int r3) {
        d.a((View) ZeusTransformUtils.preCheckCast((AppCompatImageView) ZeusTransformUtils.preCheckCast(this, AppCompatImageView.class, "com.obric.aiagent.plugin"), View.class, "com.obric.aiagent.plugin"), r3);
    }

    public float getCornerRadius() {
        return this.cornerRadius;
    }

    @Override // com.obric.oui.indicator.e
    public void setCornerRadius(float r1) {
        this.cornerRadius = r1;
    }

    public float getStrokeWidth() {
        return this.strokeWidth;
    }

    @Override // com.obric.oui.indicator.e
    public void setStrokeWidth(float r1) {
        this.strokeWidth = r1;
    }

    public int getStrokeColor() {
        return this.strokeColor;
    }

    @Override // com.obric.oui.indicator.e
    public void setStrokeColor(int r1) {
        this.strokeColor = r1;
    }

    @Override // com.obric.oui.indicator.e
    public void setHorizontalMargin(int r3) {
        d.c((View) ZeusTransformUtils.preCheckCast((AppCompatImageView) ZeusTransformUtils.preCheckCast(this, AppCompatImageView.class, "com.obric.aiagent.plugin"), View.class, "com.obric.aiagent.plugin"), r3);
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
}
