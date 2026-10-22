package com.google.android.material.textfield;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Region;
import android.os.Build;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.m;

/* JADX INFO: loaded from: classes2.dex */
class CutoutDrawable extends MaterialShapeDrawable {
    private final RectF cutoutBounds;
    private final Paint cutoutPaint;

    CutoutDrawable() {
        this(null);
    }

    CutoutDrawable(m r2) {
        if (r2 != null) goto L5;
        r2 = new m();
    L5:
        super(r2);
        this.cutoutPaint = new Paint(1);
        setPaintStyles();
        this.cutoutBounds = new RectF();
    }

    private void setPaintStyles() {
        this.cutoutPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        this.cutoutPaint.setColor(-1);
        this.cutoutPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
    }

    boolean hasCutout() {
        return !this.cutoutBounds.isEmpty();
    }

    void setCutout(float r2, float r3, float r4, float r5) {
        if (r2 == this.cutoutBounds.left) goto L5;
    L10:
        this.cutoutBounds.set(r2, r3, r4, r5);
        invalidateSelf();
        return;
    L5:
        if (r3 != this.cutoutBounds.top) goto L10;
        if (r4 != this.cutoutBounds.right) goto L10;
        if (r5 != this.cutoutBounds.bottom) goto L10;
    }

    void setCutout(RectF r4) {
        setCutout(r4.left, r4.top, r4.right, r4.bottom);
    }

    void removeCutout() {
        setCutout(0.0f, 0.0f, 0.0f, 0.0f);
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable
    public void drawStrokeShape(Canvas r3) {
        if (this.cutoutBounds.isEmpty() == false) goto L5;
        super.drawStrokeShape(r3);
        return;
    L5:
        r3.save();
        if (Build.VERSION.SDK_INT < 26) goto L8;
        r3.clipOutRect(this.cutoutBounds);
    L9:
        super.drawStrokeShape(r3);
        r3.restore();
        return;
    L8:
        r3.clipRect(this.cutoutBounds, Region.Op.DIFFERENCE);
        goto L9
    }
}
