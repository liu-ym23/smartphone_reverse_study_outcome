package com.google.android.material.progressindicator;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import com.google.android.material.color.MaterialColors;

/* JADX INFO: loaded from: classes2.dex */
final class LinearDrawingDelegate extends DrawingDelegate<LinearProgressIndicatorSpec> {
    private float displayedCornerRadius;
    private Path displayedTrackPath;
    private float displayedTrackThickness;
    private float trackLength;

    @Override // com.google.android.material.progressindicator.DrawingDelegate
    public int getPreferredWidth() {
        return -1;
    }

    public LinearDrawingDelegate(LinearProgressIndicatorSpec r1) {
        super(r1);
        this.trackLength = 300.0f;
    }

    @Override // com.google.android.material.progressindicator.DrawingDelegate
    public int getPreferredHeight() {
        return ((LinearProgressIndicatorSpec) this.spec).trackThickness;
    }

    @Override // com.google.android.material.progressindicator.DrawingDelegate
    public void adjustCanvas(Canvas r7, Rect r8, float r9) {
        this.trackLength = r8.width();
        float r0 = ((LinearProgressIndicatorSpec) this.spec).trackThickness;
        r7.translate(r8.left + (r8.width() / 2.0f), (r8.top + (r8.height() / 2.0f)) + Math.max(0.0f, (r8.height() - ((LinearProgressIndicatorSpec) this.spec).trackThickness) / 2.0f));
        if (((LinearProgressIndicatorSpec) this.spec).drawHorizontallyInverse == false) goto L6;
        r7.scale(-1.0f, 1.0f);
    L6:
        if (this.drawable.isShowing() == false) goto L10;
        if (((LinearProgressIndicatorSpec) this.spec).showAnimationBehavior != 1) goto L10;
    L13:
        r7.scale(1.0f, -1.0f);
    L15:
        if (this.drawable.isShowing() == false) goto L17;
    L18:
        r7.translate(0.0f, (((LinearProgressIndicatorSpec) this.spec).trackThickness * (r9 - 1.0f)) / 2.0f);
    L19:
        float r10 = this.trackLength;
        r7.clipRect((-r10) / 2.0f, (-r0) / 2.0f, r10 / 2.0f, r0 / 2.0f);
        this.displayedTrackThickness = ((LinearProgressIndicatorSpec) this.spec).trackThickness * r9;
        this.displayedCornerRadius = ((LinearProgressIndicatorSpec) this.spec).trackCornerRadius * r9;
        return;
    L17:
        if (this.drawable.isHiding() == false) goto L19;
    L10:
        if (this.drawable.isHiding() == false) goto L15;
        if (((LinearProgressIndicatorSpec) this.spec).hideAnimationBehavior != 2) goto L15;
        goto L13
    }

    @Override // com.google.android.material.progressindicator.DrawingDelegate
    public void fillIndicator(Canvas r5, Paint r6, float r7, float r8, int r9) {
        if (r7 != r8) goto L5;
        return;
    L5:
        float r0 = this.trackLength;
        float r1 = (-r0) / 2.0f;
        float r10 = ((r7 * r0) + r1) - (this.displayedCornerRadius * 2.0f);
        float r2 = r1 + (r8 * r0);
        r6.setStyle(Paint.Style.FILL);
        r6.setAntiAlias(true);
        r6.setColor(r9);
        r5.save();
        r5.clipPath(this.displayedTrackPath);
        float r11 = this.displayedTrackThickness;
        RectF r12 = new RectF(r10, (-r11) / 2.0f, r2, r11 / 2.0f);
        float r4 = this.displayedCornerRadius;
        r5.drawRoundRect(r12, r4, r4, r6);
        r5.restore();
    }

    @Override // com.google.android.material.progressindicator.DrawingDelegate
    void fillTrack(Canvas r8, Paint r9) {
        int r0 = MaterialColors.compositeARGBWithAlpha(((LinearProgressIndicatorSpec) this.spec).trackColor, this.drawable.getAlpha());
        r9.setStyle(Paint.Style.FILL);
        r9.setAntiAlias(true);
        r9.setColor(r0);
        Path r1 = new Path();
        this.displayedTrackPath = r1;
        float r2 = this.trackLength;
        float r5 = this.displayedTrackThickness;
        RectF r3 = new RectF((-r2) / 2.0f, (-r5) / 2.0f, r2 / 2.0f, r5 / 2.0f);
        float r4 = this.displayedCornerRadius;
        r1.addRoundRect(r3, r4, r4, Path.Direction.CCW);
        r8.drawPath(this.displayedTrackPath, r9);
    }
}
