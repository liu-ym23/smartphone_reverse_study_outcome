package com.stepos.common.drawble;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableWrapper;
import j4.g;
import j4.k;
import kotlin.ranges.l;

/* loaded from: classes.dex */
public class SmoothCornerDrawableWrapper extends DrawableWrapper {
    private Bitmap bitmapWithTransparency;
    private float heightFloat;
    private boolean needRegenPath;
    private Path path;
    private boolean provideOutline;
    private float radius;
    private boolean smoothCornerEnable;
    private float smoothness;
    private int strokeColor;
    private final Paint strokePaint;
    private float strokeWidthExt;
    private final Canvas tmpCanvas;
    private float widthFloat;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SmoothCornerDrawableWrapper(Drawable drawable) {
        super(drawable);
        k.g(drawable, "drawable");
        this.tmpCanvas = new Canvas();
        this.path = new Path();
        this.provideOutline = true;
        this.smoothCornerEnable = true;
        this.smoothness = 0.2f;
        this.radius = 0.2f;
        this.strokeColor = -16777216;
        Paint paint = new Paint();
        paint.setColor(this.strokeColor);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeCap(Paint.Cap.BUTT);
        this.strokePaint = paint;
    }

    private final void setHeightFloat(float f5) {
        if (this.heightFloat == f5) {
            return;
        }
        this.heightFloat = f5;
        this.needRegenPath = true;
    }

    private final void setWidthFloat(float f5) {
        if (this.widthFloat == f5) {
            return;
        }
        this.widthFloat = f5;
        this.needRegenPath = true;
    }

    private final void trySmoothPath() {
        if (this.needRegenPath) {
            Path pathB = N1.k.b(0.0f, 0.0f, this.widthFloat, this.heightFloat, this.smoothness, getRadius(), false, 64, null);
            pathB.setFillType(Path.FillType.INVERSE_WINDING);
            this.path = pathB;
            this.needRegenPath = false;
        }
    }

    @Override // android.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        k.g(canvas, "canvas");
        if (!this.smoothCornerEnable) {
            super.draw(canvas);
            return;
        }
        this.tmpCanvas.drawColor(0);
        super.draw(this.tmpCanvas);
        this.tmpCanvas.drawPath(this.path, N1.k.f4211a.c());
        if (this.strokePaint.getStrokeWidth() > 0.0f) {
            float f5 = 2;
            Path pathB = N1.k.b((this.strokePaint.getStrokeWidth() / f5) + 0.0f, (this.strokePaint.getStrokeWidth() / f5) + 0.0f, this.widthFloat - (this.strokePaint.getStrokeWidth() / f5), this.heightFloat - (this.strokePaint.getStrokeWidth() / f5), this.smoothness, getRadius() - (this.strokePaint.getStrokeWidth() / f5), false, 64, null);
            pathB.setFillType(Path.FillType.WINDING);
            this.tmpCanvas.drawPath(pathB, this.strokePaint);
        }
        Bitmap bitmap = this.bitmapWithTransparency;
        if (bitmap == null) {
            k.t("bitmapWithTransparency");
            bitmap = null;
        }
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
    }

    public final float getMaxSmoothRadius() {
        return N1.k.f4211a.e(this.widthFloat, this.heightFloat, this.smoothness);
    }

    @Override // android.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        k.g(outline, "outline");
        super.getOutline(outline);
        if (this.smoothCornerEnable && this.provideOutline) {
            outline.setPath(this.path);
        }
    }

    public final boolean getProvideOutline() {
        return this.provideOutline;
    }

    public final float getRadius() {
        return l.g(this.radius, 0.0f, getMaxSmoothRadius());
    }

    public final boolean getSmoothCornerEnable() {
        return this.smoothCornerEnable;
    }

    public final float getSmoothness() {
        return this.smoothness;
    }

    public final int getStrokeColor() {
        return this.strokeColor;
    }

    public final Paint getStrokePaint() {
        return this.strokePaint;
    }

    public final float getStrokeWidthExt() {
        return this.strokeWidthExt;
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        if (!this.smoothCornerEnable) {
            super.invalidateSelf();
        } else {
            trySmoothPath();
            super.invalidateSelf();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00b3  */
    @Override // android.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void onBoundsChange(android.graphics.Rect r7) {
        /*
            r6 = this;
            java.lang.String r0 = "bounds"
            j4.k.g(r7, r0)
            boolean r0 = r6.smoothCornerEnable
            if (r0 != 0) goto Ld
            super.onBoundsChange(r7)
            return
        Ld:
            int r0 = r7.width()
            float r0 = (float) r0
            r6.setWidthFloat(r0)
            int r0 = r7.height()
            float r0 = (float) r0
            r6.setHeightFloat(r0)
            android.graphics.Bitmap r0 = r6.bitmapWithTransparency
            java.lang.String r1 = "createBitmap(bounds.widt… Bitmap.Config.ARGB_8888)"
            r2 = 0
            java.lang.String r3 = "bitmapWithTransparency"
            if (r0 == 0) goto Lb3
            if (r0 != 0) goto L2c
            j4.k.t(r3)
            r0 = r2
        L2c:
            boolean r0 = r0.isRecycled()
            if (r0 == 0) goto L34
            goto Lb3
        L34:
            android.graphics.Bitmap r0 = r6.bitmapWithTransparency
            if (r0 != 0) goto L3c
            j4.k.t(r3)
            r0 = r2
        L3c:
            int r0 = r0.getWidth()
            int r4 = r7.width()
            if (r0 != r4) goto L58
            android.graphics.Bitmap r0 = r6.bitmapWithTransparency
            if (r0 != 0) goto L4e
            j4.k.t(r3)
            r0 = r2
        L4e:
            int r0 = r0.getHeight()
            int r4 = r7.height()
            if (r0 == r4) goto Ld2
        L58:
            int r0 = r7.width()
            android.graphics.Bitmap r4 = r6.bitmapWithTransparency
            if (r4 != 0) goto L64
            j4.k.t(r3)
            r4 = r2
        L64:
            int r4 = r4.getWidth()
            if (r0 > r4) goto L93
            int r0 = r7.height()
            android.graphics.Bitmap r4 = r6.bitmapWithTransparency
            if (r4 != 0) goto L76
            j4.k.t(r3)
            r4 = r2
        L76:
            int r4 = r4.getHeight()
            if (r0 > r4) goto L93
            android.graphics.Bitmap r0 = r6.bitmapWithTransparency
            if (r0 != 0) goto L84
            j4.k.t(r3)
            goto L85
        L84:
            r2 = r0
        L85:
            int r0 = r7.width()
            int r1 = r7.height()
            android.graphics.Bitmap$Config r3 = android.graphics.Bitmap.Config.ARGB_8888
            r2.reconfigure(r0, r1, r3)
            goto Ld2
        L93:
            int r0 = r7.width()
            int r4 = r7.height()
            android.graphics.Bitmap$Config r5 = android.graphics.Bitmap.Config.ARGB_8888
            android.graphics.Bitmap r0 = android.graphics.Bitmap.createBitmap(r0, r4, r5)
            j4.k.f(r0, r1)
            r6.bitmapWithTransparency = r0
            android.graphics.Canvas r1 = r6.tmpCanvas
            if (r0 != 0) goto Lae
            j4.k.t(r3)
            goto Laf
        Lae:
            r2 = r0
        Laf:
            r1.setBitmap(r2)
            goto Ld2
        Lb3:
            int r0 = r7.width()
            int r4 = r7.height()
            android.graphics.Bitmap$Config r5 = android.graphics.Bitmap.Config.ARGB_8888
            android.graphics.Bitmap r0 = android.graphics.Bitmap.createBitmap(r0, r4, r5)
            j4.k.f(r0, r1)
            r6.bitmapWithTransparency = r0
            android.graphics.Canvas r1 = r6.tmpCanvas
            if (r0 != 0) goto Lce
            j4.k.t(r3)
            goto Lcf
        Lce:
            r2 = r0
        Lcf:
            r1.setBitmap(r2)
        Ld2:
            r6.trySmoothPath()
            super.onBoundsChange(r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.common.drawble.SmoothCornerDrawableWrapper.onBoundsChange(android.graphics.Rect):void");
    }

    public final void setProvideOutline(boolean z5) {
        this.provideOutline = z5;
    }

    public final void setRadius(float f5) {
        if (f5 == this.radius) {
            return;
        }
        this.radius = f5;
        this.needRegenPath = true;
        invalidateSelf();
    }

    public final void setSmoothCornerEnable(boolean z5) {
        if (z5 != this.smoothCornerEnable) {
            this.smoothCornerEnable = z5;
            this.needRegenPath = true;
            invalidateSelf();
        }
    }

    public final void setSmoothness(float f5) {
        float fG = l.g(f5, 0.0f, 1.0f);
        if (fG == this.smoothness) {
            return;
        }
        this.smoothness = fG;
        this.needRegenPath = true;
        invalidateSelf();
    }

    public final void setStrokeColor(int i5) {
        if (i5 != this.strokeColor) {
            this.strokeColor = i5;
            this.needRegenPath = true;
            invalidateSelf();
        }
    }

    public final void setStrokeWidthExt(float f5) {
        if (f5 == this.strokeWidthExt) {
            return;
        }
        this.strokeWidthExt = f5;
        this.needRegenPath = true;
        this.strokePaint.setStrokeWidth(f5);
        invalidateSelf();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SmoothCornerDrawableWrapper(Drawable drawable, float f5, float f6) {
        this(drawable);
        k.g(drawable, "drawable");
        setSmoothness(f5);
        setRadius(f6);
    }

    public /* synthetic */ SmoothCornerDrawableWrapper(Drawable drawable, float f5, float f6, float f7, int i5, int i6, g gVar) {
        this(drawable, f5, f6, (i6 & 8) != 0 ? 0.0f : f7, (i6 & 16) != 0 ? -16777216 : i5);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SmoothCornerDrawableWrapper(Drawable drawable, float f5, float f6, float f7, int i5) {
        this(drawable, f5, f6);
        k.g(drawable, "drawable");
        setStrokeColor(i5);
        setStrokeWidthExt(f7);
    }
}
