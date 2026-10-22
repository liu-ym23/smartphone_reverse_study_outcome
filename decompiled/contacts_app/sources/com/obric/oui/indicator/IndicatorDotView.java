package com.obric.oui.indicator;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.obric.oui.common.style.SmoothCornerH;
import com.obric.oui.material.MaterialConfigFormatNames;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: IndicatorDotView.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B%\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0010\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%H\u0014J\u0010\u0010&\u001a\u00020#2\u0006\u0010'\u001a\u00020\bH\u0016J\u0010\u0010(\u001a\u00020#2\u0006\u0010)\u001a\u00020\bH\u0016J\u0010\u0010*\u001a\u00020#2\u0006\u0010'\u001a\u00020\bH\u0016J\u0010\u0010+\u001a\u00020#2\u0006\u0010,\u001a\u00020\bH\u0016R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u00020\rX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R$\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\b@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\b@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0015\"\u0004\b\u001c\u0010\u0017R\u000e\u0010\u001d\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u001f\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\r@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u000f\"\u0004\b!\u0010\u0011¨\u0006-"}, d2 = {"Lcom/obric/oui/indicator/IndicatorDotView;", "Landroid/view/View;", "Lcom/obric/oui/indicator/IndicatorIcon;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "bgRectF", "Landroid/graphics/RectF;", "cornerRadius", "", "getCornerRadius", "()F", "setCornerRadius", "(F)V", "value", "dotColor", "getDotColor", "()I", "setDotColor", "(I)V", "dotPaint", "Landroid/graphics/Paint;", "strokeColor", "getStrokeColor", "setStrokeColor", "strokePaint", "strokeRectF", "strokeWidth", "getStrokeWidth", "setStrokeWidth", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "setEndMargin", "margin", "setHorizontalMargin", "horizontalMargin", "setStartMargin", "setWidth", MaterialConfigFormatNames.WIDTH, "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class IndicatorDotView extends View implements IndicatorIcon {
    private final RectF bgRectF;
    private float cornerRadius;
    private int dotColor;
    private final Paint dotPaint;
    private int strokeColor;
    private final Paint strokePaint;
    private final RectF strokeRectF;
    private float strokeWidth;

    public IndicatorDotView(Context r8) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, null, 0, 6, null);
    }

    public IndicatorDotView(Context r8, AttributeSet r9) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, r9, 0, 4, null);
    }

    public /* synthetic */ IndicatorDotView(Context r1, AttributeSet r2, int r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = 0;
    L8:
        this(r1, r2, r3);
    }

    public IndicatorDotView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.bgRectF = new RectF();
        this.strokeRectF = new RectF();
        Paint r5 = new Paint(1);
        r5.setStyle(Paint.Style.FILL);
        this.dotPaint = r5;
        Paint r6 = new Paint(1);
        r6.setStyle(Paint.Style.STROKE);
        this.strokePaint = r6;
        this.dotColor = -7829368;
    }

    @Override // com.obric.oui.indicator.IndicatorIcon
    public int getDotColor() {
        return this.dotColor;
    }

    @Override // com.obric.oui.indicator.IndicatorIcon
    public void setDotColor(int r2) {
        if (this.dotColor == r2) goto L5;
        this.dotColor = r2;
    L5:
        this.dotPaint.setColor(r2);
    }

    @Override // com.obric.oui.indicator.IndicatorIcon
    public void setWidth(int r1) {
        IndicatorExternalsKt.setWidth(this, r1);
    }

    @Override // com.obric.oui.indicator.IndicatorIcon
    public void setHorizontalMargin(int r1) {
        IndicatorExternalsKt.setHorizontalMargin(this, r1);
    }

    @Override // com.obric.oui.indicator.IndicatorIcon
    public void setStartMargin(int r4) {
        ViewGroup.LayoutParams r0 = getLayoutParams();
        ViewGroup.MarginLayoutParams r2 = null;
        if ((r0 instanceof ViewGroup.MarginLayoutParams) == false) goto L5;
        ViewGroup.MarginLayoutParams r1 = (ViewGroup.MarginLayoutParams) r0;
    L6:
        if (r1 == null) goto L9;
        r1.setMarginStart(r4);
        requestLayout();
        r2 = r1;
    L9:
        setLayoutParams(r2);
        return;
    L5:
        r1 = null;
        goto L6
    }

    @Override // com.obric.oui.indicator.IndicatorIcon
    public void setEndMargin(int r4) {
        ViewGroup.LayoutParams r0 = getLayoutParams();
        ViewGroup.MarginLayoutParams r2 = null;
        if ((r0 instanceof ViewGroup.MarginLayoutParams) == false) goto L5;
        ViewGroup.MarginLayoutParams r1 = (ViewGroup.MarginLayoutParams) r0;
    L6:
        if (r1 == null) goto L9;
        r1.setMarginEnd(r4);
        requestLayout();
        r2 = r1;
    L9:
        setLayoutParams(r2);
        return;
    L5:
        r1 = null;
        goto L6
    }

    @Override // com.obric.oui.indicator.IndicatorIcon
    public int getStrokeColor() {
        return this.strokeColor;
    }

    @Override // com.obric.oui.indicator.IndicatorIcon
    public void setStrokeColor(int r2) {
        if (this.strokeColor == r2) goto L5;
        this.strokeColor = r2;
    L5:
        this.strokePaint.setColor(r2);
    }

    @Override // com.obric.oui.indicator.IndicatorIcon
    public float getStrokeWidth() {
        return this.strokeWidth;
    }

    @Override // com.obric.oui.indicator.IndicatorIcon
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

    @Override // com.obric.oui.indicator.IndicatorIcon
    public float getCornerRadius() {
        return this.cornerRadius;
    }

    @Override // com.obric.oui.indicator.IndicatorIcon
    public void setCornerRadius(float r1) {
        this.cornerRadius = r1;
    }

    @Override // android.view.View
    protected void onDraw(Canvas r8) {
        Intrinsics.checkNotNullParameter(r8, "canvas");
        super.onDraw(r8);
        this.bgRectF.set(0.0f, 0.0f, getWidth(), getHeight());
        SmoothCornerH.drawRoundRect(r8, this.bgRectF, getCornerRadius(), this.dotPaint);
        if (getStrokeWidth() <= 0.0f) goto L6;
        float r2 = 2;
        this.strokeRectF.set(getStrokeWidth() / r2, getStrokeWidth() / r2, getWidth() - (getStrokeWidth() / r2), getHeight() - (getStrokeWidth() / r2));
        SmoothCornerH.drawRoundRect(r8, this.strokeRectF, getCornerRadius(), this.strokePaint);
        return;
    }
}
