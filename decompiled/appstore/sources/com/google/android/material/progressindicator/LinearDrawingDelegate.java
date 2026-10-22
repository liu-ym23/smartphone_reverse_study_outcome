package com.google.android.material.progressindicator;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import com.google.android.material.color.MaterialColors;

/* JADX INFO: loaded from: classes3.dex */
final class LinearDrawingDelegate extends DrawingDelegate<LinearProgressIndicatorSpec> {
    private float displayedCornerRadius;
    private float displayedTrackThickness;
    private float trackLength;

    public LinearDrawingDelegate(@NonNull LinearProgressIndicatorSpec r10) {
        super(r10);
        this.trackLength = 300.0f;
    }

    private static void drawRoundedEnd(Canvas r10, Paint r11, float r12, float r13, float r14, boolean r15, RectF r16) {
        r10.save();
        r10.translate(r14, 0.0f);
        if (r15 == true) goto L5;
        r10.rotate(180.0f);
    L5:
        float r17 = ((-r12) / 2.0f) + r13;
        float r18 = (r12 / 2.0f) - r13;
        r10.drawRect(-r13, r17, 0.0f, r18, r11);
        r10.save();
        r10.translate(0.0f, r17);
        r10.drawArc(r16, 180.0f, 90.0f, true, r11);
        r10.restore();
        r10.translate(0.0f, r18);
        r10.drawArc(r16, 180.0f, -90.0f, true, r11);
        r10.restore();
    }

    @Override // com.google.android.material.progressindicator.DrawingDelegate
    public void adjustCanvas(@NonNull Canvas r10, @FloatRange(from = 0.0d, to = 1.0d) float r11) {
        Rect r12 = r10.getClipBounds();
        this.trackLength = r12.width();
        float r13 = ((LinearProgressIndicatorSpec) this.spec).trackThickness;
        r10.translate(r12.left + (r12.width() / 2.0f), (r12.top + (r12.height() / 2.0f)) + Math.max(0.0f, (r12.height() - ((LinearProgressIndicatorSpec) this.spec).trackThickness) / 2.0f));
        if (((LinearProgressIndicatorSpec) this.spec).drawHorizontallyInverse == false) goto L6;
        r10.scale(-1.0f, 1.0f);
    L6:
        if (this.drawable.isShowing() == false) goto L10;
        if (((LinearProgressIndicatorSpec) this.spec).showAnimationBehavior != 1) goto L10;
    L13:
        r10.scale(1.0f, -1.0f);
    L15:
        if (this.drawable.isShowing() == false) goto L17;
    L18:
        r10.translate(0.0f, (((LinearProgressIndicatorSpec) this.spec).trackThickness * (r11 - 1.0f)) / 2.0f);
    L19:
        float r14 = this.trackLength;
        r10.clipRect((-r14) / 2.0f, (-r13) / 2.0f, r14 / 2.0f, r13 / 2.0f);
        S r15 = this.spec;
        this.displayedTrackThickness = ((LinearProgressIndicatorSpec) r15).trackThickness * r11;
        this.displayedCornerRadius = ((LinearProgressIndicatorSpec) r15).trackCornerRadius * r11;
        return;
    L17:
        if (this.drawable.isHiding() == false) goto L19;
    L10:
        if (this.drawable.isHiding() == false) goto L15;
        if (((LinearProgressIndicatorSpec) this.spec).hideAnimationBehavior != 2) goto L15;
        goto L13
    }

    @Override // com.google.android.material.progressindicator.DrawingDelegate
    public void fillIndicator(@NonNull Canvas r12, @NonNull Paint r13, @FloatRange(from = 0.0d, to = 1.0d) float r14, @FloatRange(from = 0.0d, to = 1.0d) float r15, @ColorInt int r16) {
        if (r14 != r15) goto L5;
        return;
    L5:
        float r10 = this.trackLength;
        float r11 = this.displayedCornerRadius;
        float r17 = (((-r10) / 2.0f) + r11) + ((r10 - (r11 * 2.0f)) * r14);
        float r18 = (((-r10) / 2.0f) + r11) + ((r10 - (r11 * 2.0f)) * r15);
        r13.setStyle(Paint.Style.FILL);
        r13.setAntiAlias(true);
        r13.setColor(r16);
        float r19 = this.displayedTrackThickness;
        r12.drawRect(r17, (-r19) / 2.0f, r18, r19 / 2.0f, r13);
        float r20 = this.displayedCornerRadius;
        RectF r110 = new RectF(-r20, -r20, r20, r20);
        drawRoundedEnd(r12, r13, this.displayedTrackThickness, this.displayedCornerRadius, r17, true, r110);
        drawRoundedEnd(r12, r13, this.displayedTrackThickness, this.displayedCornerRadius, r18, false, r110);
    }

    @Override // com.google.android.material.progressindicator.DrawingDelegate
    public void fillTrack(@NonNull Canvas r13, @NonNull Paint r14) {
        int r10 = MaterialColors.compositeARGBWithAlpha(((LinearProgressIndicatorSpec) this.spec).trackColor, this.drawable.getAlpha());
        float r11 = ((-this.trackLength) / 2.0f) + this.displayedCornerRadius;
        float r12 = -r11;
        r14.setStyle(Paint.Style.FILL);
        r14.setAntiAlias(true);
        r14.setColor(r10);
        float r15 = this.displayedTrackThickness;
        r13.drawRect(r11, (-r15) / 2.0f, r12, r15 / 2.0f, r14);
        float r16 = this.displayedCornerRadius;
        RectF r17 = new RectF(-r16, -r16, r16, r16);
        drawRoundedEnd(r13, r14, this.displayedTrackThickness, this.displayedCornerRadius, r11, true, r17);
        drawRoundedEnd(r13, r14, this.displayedTrackThickness, this.displayedCornerRadius, r12, false, r17);
    }

    @Override // com.google.android.material.progressindicator.DrawingDelegate
    public int getPreferredHeight() {
        return ((LinearProgressIndicatorSpec) this.spec).trackThickness;
    }

    @Override // com.google.android.material.progressindicator.DrawingDelegate
    public int getPreferredWidth() {
        return -1;
    }
}
