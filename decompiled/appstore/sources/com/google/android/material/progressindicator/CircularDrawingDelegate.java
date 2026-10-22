package com.google.android.material.progressindicator;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import com.google.android.material.color.MaterialColors;

/* JADX INFO: loaded from: classes3.dex */
final class CircularDrawingDelegate extends DrawingDelegate<CircularProgressIndicatorSpec> {
    private float adjustedRadius;
    private int arcDirectionFactor;
    private float displayedCornerRadius;
    private float displayedTrackThickness;

    public CircularDrawingDelegate(@NonNull CircularProgressIndicatorSpec r10) {
        super(r10);
        this.arcDirectionFactor = 1;
    }

    private void drawRoundedEnd(Canvas r13, Paint r14, float r15, float r16, float r17, boolean r18, RectF r19) {
        if (r18 == false) goto L6;
        float r10 = -1.0f;
    L5:
        float r11 = r10;
        r13.save();
        r13.rotate(r17);
        float r12 = r15 / 2.0f;
        float r20 = r11 * r16;
        r13.drawRect((this.adjustedRadius - r12) + r16, Math.min(0.0f, this.arcDirectionFactor * r20), (this.adjustedRadius + r12) - r16, Math.max(0.0f, r20 * this.arcDirectionFactor), r14);
        r13.translate((this.adjustedRadius - r12) + r16, 0.0f);
        r13.drawArc(r19, 180.0f, ((-r11) * 90.0f) * this.arcDirectionFactor, true, r14);
        r13.translate(r15 - (r16 * 2.0f), 0.0f);
        r13.drawArc(r19, 0.0f, (r11 * 90.0f) * this.arcDirectionFactor, true, r14);
        r13.restore();
        return;
    L6:
        r10 = 1.0f;
        goto L5
    }

    private int getSize() {
        S r10 = this.spec;
        return ((CircularProgressIndicatorSpec) r10).indicatorSize + (((CircularProgressIndicatorSpec) r10).indicatorInset * 2);
    }

    @Override // com.google.android.material.progressindicator.DrawingDelegate
    public void adjustCanvas(@NonNull Canvas r10, @FloatRange(from = 0.0d, to = 1.0d) float r11) {
        S r12 = this.spec;
        float r13 = (((CircularProgressIndicatorSpec) r12).indicatorSize / 2.0f) + ((CircularProgressIndicatorSpec) r12).indicatorInset;
        r10.translate(r13, r13);
        r10.rotate(-90.0f);
        float r14 = -r13;
        r10.clipRect(r14, r14, r13, r13);
        S r15 = this.spec;
        if (((CircularProgressIndicatorSpec) r15).indicatorDirection != 0) goto L5;
        int r16 = 1;
    L6:
        this.arcDirectionFactor = r16;
        this.displayedTrackThickness = ((CircularProgressIndicatorSpec) r15).trackThickness * r11;
        this.displayedCornerRadius = ((CircularProgressIndicatorSpec) r15).trackCornerRadius * r11;
        this.adjustedRadius = (((CircularProgressIndicatorSpec) r15).indicatorSize - ((CircularProgressIndicatorSpec) r15).trackThickness) / 2.0f;
        if (this.drawable.isShowing() == false) goto L11;
        if (((CircularProgressIndicatorSpec) this.spec).showAnimationBehavior != 2) goto L11;
    L14:
        this.adjustedRadius += ((1.0f - r11) * ((CircularProgressIndicatorSpec) this.spec).trackThickness) / 2.0f;
        return;
    L11:
        if (this.drawable.isHiding() == false) goto L16;
        if (((CircularProgressIndicatorSpec) this.spec).hideAnimationBehavior == 1) goto L14;
    L16:
        if (this.drawable.isShowing() == false) goto L20;
        if (((CircularProgressIndicatorSpec) this.spec).showAnimationBehavior != 1) goto L20;
    L23:
        this.adjustedRadius -= ((1.0f - r11) * ((CircularProgressIndicatorSpec) this.spec).trackThickness) / 2.0f;
        return;
    L20:
        if (this.drawable.isHiding() == true) goto L22;
        return;
    L22:
        if (((CircularProgressIndicatorSpec) this.spec).hideAnimationBehavior == 2) goto L23;
        return;
    L5:
        r16 = -1;
        goto L6
    }

    @Override // com.google.android.material.progressindicator.DrawingDelegate
    public void fillIndicator(@NonNull Canvas r14, @NonNull Paint r15, @FloatRange(from = 0.0d, to = 1.0d) float r16, @FloatRange(from = 0.0d, to = 1.0d) float r17, @ColorInt int r18) {
        if (r16 != r17) goto L5;
        return;
    L5:
        r15.setStyle(Paint.Style.STROKE);
        r15.setStrokeCap(Paint.Cap.BUTT);
        r15.setAntiAlias(true);
        r15.setColor(r18);
        r15.setStrokeWidth(this.displayedTrackThickness);
        int r10 = this.arcDirectionFactor;
        float r11 = (r16 * 360.0f) * r10;
        if (r17 < r16) goto L9;
        float r12 = r17 - r16;
    L8:
        float r13 = (r12 * 360.0f) * r10;
        float r19 = this.adjustedRadius;
        r14.drawArc(new RectF(-r19, -r19, r19, r19), r11, r13, false, r15);
        if (this.displayedCornerRadius > 0.0f) goto L13;
        return;
    L13:
        if (Math.abs(r13) >= 360.0f) goto L17;
        r15.setStyle(Paint.Style.FILL);
        float r20 = this.displayedCornerRadius;
        RectF r110 = new RectF(-r20, -r20, r20, r20);
        drawRoundedEnd(r14, r15, this.displayedTrackThickness, this.displayedCornerRadius, r11, true, r110);
        drawRoundedEnd(r14, r15, this.displayedTrackThickness, this.displayedCornerRadius, r11 + r13, false, r110);
        return;
    L17:
        return;
    L9:
        r12 = (r17 + 1.0f) - r16;
        goto L8
    }

    @Override // com.google.android.material.progressindicator.DrawingDelegate
    public void fillTrack(@NonNull Canvas r10, @NonNull Paint r11) {
        int r12 = MaterialColors.compositeARGBWithAlpha(((CircularProgressIndicatorSpec) this.spec).trackColor, this.drawable.getAlpha());
        r11.setStyle(Paint.Style.STROKE);
        r11.setStrokeCap(Paint.Cap.BUTT);
        r11.setAntiAlias(true);
        r11.setColor(r12);
        r11.setStrokeWidth(this.displayedTrackThickness);
        float r13 = this.adjustedRadius;
        r10.drawArc(new RectF(-r13, -r13, r13, r13), 0.0f, 360.0f, false, r11);
    }

    @Override // com.google.android.material.progressindicator.DrawingDelegate
    public int getPreferredHeight() {
        return getSize();
    }

    @Override // com.google.android.material.progressindicator.DrawingDelegate
    public int getPreferredWidth() {
        return getSize();
    }
}
