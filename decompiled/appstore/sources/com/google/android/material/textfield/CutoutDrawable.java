package com.google.android.material.textfield;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;

/* JADX INFO: loaded from: classes3.dex */
class CutoutDrawable extends MaterialShapeDrawable {

    @NonNull
    private final RectF cutoutBounds;

    @NonNull
    private final Paint cutoutPaint;
    private int savedLayer;

    public CutoutDrawable() {
        this(null);
    }

    private void postDraw(@NonNull Canvas r10) {
        if (useHardwareLayer(getCallback()) == true) goto L6;
        r10.restoreToCount(this.savedLayer);
        return;
    }

    private void preDraw(@NonNull Canvas r10) {
        Drawable.Callback r11 = getCallback();
        if (useHardwareLayer(r11) == false) goto L7;
        View r12 = (View) r11;
        if (r12.getLayerType() == 2) goto L9;
        r12.setLayerType(2, null);
        return;
    L9:
        return;
    L7:
        saveCanvasLayer(r10);
    }

    private void saveCanvasLayer(@NonNull Canvas r10) {
        this.savedLayer = r10.saveLayer(0.0f, 0.0f, r10.getWidth(), r10.getHeight(), null);
    }

    private void setPaintStyles() {
        this.cutoutPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        this.cutoutPaint.setColor(-1);
        this.cutoutPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
    }

    private boolean useHardwareLayer(Drawable.Callback r10) {
        return r10 instanceof View;
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas r10) {
        preDraw(r10);
        super.draw(r10);
        r10.drawRect(this.cutoutBounds, this.cutoutPaint);
        postDraw(r10);
    }

    public boolean hasCutout() {
        return !this.cutoutBounds.isEmpty();
    }

    public void removeCutout() {
        setCutout(0.0f, 0.0f, 0.0f, 0.0f);
    }

    public void setCutout(float r10, float r11, float r12, float r13) {
        RectF r14 = this.cutoutBounds;
        if (r10 == r14.left) goto L5;
    L10:
        r14.set(r10, r11, r12, r13);
        invalidateSelf();
        return;
    L5:
        if (r11 != r14.top) goto L10;
        if (r12 != r14.right) goto L10;
        if (r13 != r14.bottom) goto L10;
    }

    public CutoutDrawable(@Nullable ShapeAppearanceModel r10) {
        if (r10 != null) goto L5;
        r10 = new ShapeAppearanceModel();
    L5:
        super(r10);
        this.cutoutPaint = new Paint(1);
        setPaintStyles();
        this.cutoutBounds = new RectF();
    }

    public void setCutout(@NonNull RectF r10) {
        setCutout(r10.left, r10.top, r10.right, r10.bottom);
    }
}
