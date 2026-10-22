package com.google.android.material.progressindicator;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import com.google.android.material.color.MaterialColors;

/* JADX INFO: loaded from: classes2.dex */
final class CircularDrawingDelegate extends DrawingDelegate<CircularProgressIndicatorSpec> {
    private float adjustedRadius;
    private int arcDirectionFactor;
    private float displayedCornerRadius;
    private float displayedTrackThickness;

    public CircularDrawingDelegate(CircularProgressIndicatorSpec r1) {
        super(r1);
        this.arcDirectionFactor = 1;
    }

    @Override // com.google.android.material.progressindicator.DrawingDelegate
    public int getPreferredWidth() {
        return getSize();
    }

    @Override // com.google.android.material.progressindicator.DrawingDelegate
    public int getPreferredHeight() {
        return getSize();
    }

    @Override // com.google.android.material.progressindicator.DrawingDelegate
    public void adjustCanvas(Canvas r8, Rect r9, float r10) {
        float r0 = r9.width() / getPreferredWidth();
        float r1 = r9.height() / getPreferredHeight();
        float r2 = (((CircularProgressIndicatorSpec) this.spec).indicatorSize / 2.0f) + ((CircularProgressIndicatorSpec) this.spec).indicatorInset;
        r8.translate((r2 * r0) + r9.left, (r2 * r1) + r9.top);
        r8.scale(r0, r1);
        r8.rotate(-90.0f);
        float r11 = -r2;
        r8.clipRect(r11, r11, r2, r2);
        if (((CircularProgressIndicatorSpec) this.spec).indicatorDirection != 0) goto L5;
        int r12 = 1;
    L6:
        this.arcDirectionFactor = r12;
        this.displayedTrackThickness = ((CircularProgressIndicatorSpec) this.spec).trackThickness * r10;
        this.displayedCornerRadius = ((CircularProgressIndicatorSpec) this.spec).trackCornerRadius * r10;
        this.adjustedRadius = (((CircularProgressIndicatorSpec) this.spec).indicatorSize - ((CircularProgressIndicatorSpec) this.spec).trackThickness) / 2.0f;
        if (this.drawable.isShowing() == false) goto L11;
        if (((CircularProgressIndicatorSpec) this.spec).showAnimationBehavior != 2) goto L11;
    L14:
        this.adjustedRadius += ((1.0f - r10) * ((CircularProgressIndicatorSpec) this.spec).trackThickness) / 2.0f;
        return;
    L11:
        if (this.drawable.isHiding() == false) goto L16;
        if (((CircularProgressIndicatorSpec) this.spec).hideAnimationBehavior == 1) goto L14;
    L16:
        if (this.drawable.isShowing() == false) goto L20;
        if (((CircularProgressIndicatorSpec) this.spec).showAnimationBehavior != 1) goto L20;
    L23:
        this.adjustedRadius -= ((1.0f - r10) * ((CircularProgressIndicatorSpec) this.spec).trackThickness) / 2.0f;
        return;
    L20:
        if (this.drawable.isHiding() == true) goto L22;
        return;
    L22:
        if (((CircularProgressIndicatorSpec) this.spec).hideAnimationBehavior == 2) goto L23;
        return;
    L5:
        r12 = -1;
        goto L6
    }

    @Override // com.google.android.material.progressindicator.DrawingDelegate
    void fillIndicator(Canvas r12, Paint r13, float r14, float r15, int r16) {
        if (r14 != r15) goto L5;
        return;
    L5:
        r13.setStyle(Paint.Style.STROKE);
        r13.setStrokeCap(Paint.Cap.BUTT);
        r13.setAntiAlias(true);
        r13.setColor(r16);
        r13.setStrokeWidth(this.displayedTrackThickness);
        int r1 = this.arcDirectionFactor;
        float r9 = (r14 * 360.0f) * r1;
        if (r15 < r14) goto L8;
        float r0 = r15 - r14;
    L9:
        float r2 = (r0 * 360.0f) * r1;
        float r3 = this.adjustedRadius;
        r12.drawArc(new RectF(-r3, -r3, r3, r3), r9, r2, false, r13);
        if (this.displayedCornerRadius > 0.0f) goto L12;
        return;
    L12:
        if (Math.abs(r2) >= 360.0f) goto L16;
        r13.setStyle(Paint.Style.FILL);
        drawRoundedEnd(r12, r13, this.displayedTrackThickness, this.displayedCornerRadius, r9);
        drawRoundedEnd(r12, r13, this.displayedTrackThickness, this.displayedCornerRadius, r9 + r2);
        return;
    L16:
        return;
    L8:
        r0 = (1.0f + r15) - r14;
        goto L9
    }

    @Override // com.google.android.material.progressindicator.DrawingDelegate
    void fillTrack(Canvas r8, Paint r9) {
        int r0 = MaterialColors.compositeARGBWithAlpha(((CircularProgressIndicatorSpec) this.spec).trackColor, this.drawable.getAlpha());
        r9.setStyle(Paint.Style.STROKE);
        r9.setStrokeCap(Paint.Cap.BUTT);
        r9.setAntiAlias(true);
        r9.setColor(r0);
        r9.setStrokeWidth(this.displayedTrackThickness);
        float r7 = this.adjustedRadius;
        r8.drawArc(new RectF(-r7, -r7, r7, r7), 0.0f, 360.0f, false, r9);
    }

    private int getSize() {
        return ((CircularProgressIndicatorSpec) this.spec).indicatorSize + (((CircularProgressIndicatorSpec) this.spec).indicatorInset * 2);
    }

    private void drawRoundedEnd(Canvas r2, Paint r3, float r4, float r5, float r6) {
        r2.save();
        r2.rotate(r6);
        float r1 = this.adjustedRadius;
        float r7 = r4 / 2.0f;
        r2.drawRoundRect(new RectF(r1 - r7, r5, r1 + r7, -r5), r5, r5, r3);
        r2.restore();
    }
}
