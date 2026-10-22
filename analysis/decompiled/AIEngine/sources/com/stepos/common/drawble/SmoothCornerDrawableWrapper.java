package com.stepos.common.drawble;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableWrapper;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.g;
import l8.h;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
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
        g.f(drawable, "drawable");
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

    private final void setHeightFloat(float f8) {
        if (this.heightFloat == f8) {
            return;
        }
        this.heightFloat = f8;
        this.needRegenPath = true;
    }

    private final void setWidthFloat(float f8) {
        if (this.widthFloat == f8) {
            return;
        }
        this.widthFloat = f8;
        this.needRegenPath = true;
    }

    private final void trySmoothPath() {
        if (this.needRegenPath) {
            Path pathA = h.a(0.0f, 0.0f, this.widthFloat, this.heightFloat, this.smoothness, getRadius(), false);
            pathA.setFillType(Path.FillType.INVERSE_WINDING);
            this.path = pathA;
            this.needRegenPath = false;
        }
    }

    @Override // android.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        g.f(canvas, "canvas");
        if (!this.smoothCornerEnable) {
            super.draw(canvas);
            return;
        }
        this.tmpCanvas.drawColor(0);
        super.draw(this.tmpCanvas);
        this.tmpCanvas.drawPath(this.path, h.f10360b);
        if (this.strokePaint.getStrokeWidth() > 0.0f) {
            float f8 = 2;
            Path pathA = h.a((this.strokePaint.getStrokeWidth() / f8) + 0.0f, (this.strokePaint.getStrokeWidth() / f8) + 0.0f, this.widthFloat - (this.strokePaint.getStrokeWidth() / f8), this.heightFloat - (this.strokePaint.getStrokeWidth() / f8), this.smoothness, getRadius() - (this.strokePaint.getStrokeWidth() / f8), false);
            pathA.setFillType(Path.FillType.WINDING);
            this.tmpCanvas.drawPath(pathA, this.strokePaint);
        }
        Bitmap bitmap = this.bitmapWithTransparency;
        if (bitmap != null) {
            canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        } else {
            g.l("bitmapWithTransparency");
            throw null;
        }
    }

    public final float getMaxSmoothRadius() {
        h.c cVar = h.f10359a;
        return h.b(this.widthFloat, this.heightFloat, this.smoothness);
    }

    @Override // android.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        g.f(outline, "outline");
        super.getOutline(outline);
        if (this.smoothCornerEnable && this.provideOutline) {
            outline.setPath(this.path);
        }
    }

    public final boolean getProvideOutline() {
        return this.provideOutline;
    }

    public final float getRadius() {
        return dc.h.Z(this.radius, 0.0f, getMaxSmoothRadius());
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

    /* JADX WARN: Removed duplicated region for block: B:24:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00ac  */
    @Override // android.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onBoundsChange(android.graphics.Rect r6) {
        /*
            r5 = this;
            java.lang.String r0 = "bounds"
            kotlin.jvm.internal.g.f(r6, r0)
            boolean r0 = r5.smoothCornerEnable
            if (r0 != 0) goto Ld
            super.onBoundsChange(r6)
            return
        Ld:
            int r0 = r6.width()
            float r0 = (float) r0
            r5.setWidthFloat(r0)
            int r0 = r6.height()
            float r0 = (float) r0
            r5.setHeightFloat(r0)
            android.graphics.Bitmap r0 = r5.bitmapWithTransparency
            java.lang.String r1 = "createBitmap(bounds.widt… Bitmap.Config.ARGB_8888)"
            if (r0 == 0) goto Lac
            r2 = 0
            java.lang.String r3 = "bitmapWithTransparency"
            if (r0 == 0) goto La8
            boolean r0 = r0.isRecycled()
            if (r0 == 0) goto L30
            goto Lac
        L30:
            android.graphics.Bitmap r0 = r5.bitmapWithTransparency
            if (r0 == 0) goto La4
            int r0 = r0.getWidth()
            int r4 = r6.width()
            if (r0 != r4) goto L51
            android.graphics.Bitmap r0 = r5.bitmapWithTransparency
            if (r0 == 0) goto L4d
            int r0 = r0.getHeight()
            int r4 = r6.height()
            if (r0 == r4) goto Lc4
            goto L51
        L4d:
            kotlin.jvm.internal.g.l(r3)
            throw r2
        L51:
            int r0 = r6.width()
            android.graphics.Bitmap r4 = r5.bitmapWithTransparency
            if (r4 == 0) goto La0
            int r4 = r4.getWidth()
            if (r0 > r4) goto L87
            int r0 = r6.height()
            android.graphics.Bitmap r4 = r5.bitmapWithTransparency
            if (r4 == 0) goto L83
            int r4 = r4.getHeight()
            if (r0 > r4) goto L87
            android.graphics.Bitmap r0 = r5.bitmapWithTransparency
            if (r0 == 0) goto L7f
            int r1 = r6.width()
            int r2 = r6.height()
            android.graphics.Bitmap$Config r3 = android.graphics.Bitmap.Config.ARGB_8888
            r0.reconfigure(r1, r2, r3)
            goto Lc4
        L7f:
            kotlin.jvm.internal.g.l(r3)
            throw r2
        L83:
            kotlin.jvm.internal.g.l(r3)
            throw r2
        L87:
            int r0 = r6.width()
            int r2 = r6.height()
            android.graphics.Bitmap$Config r3 = android.graphics.Bitmap.Config.ARGB_8888
            android.graphics.Bitmap r0 = android.graphics.Bitmap.createBitmap(r0, r2, r3)
            kotlin.jvm.internal.g.e(r0, r1)
            r5.bitmapWithTransparency = r0
            android.graphics.Canvas r1 = r5.tmpCanvas
            r1.setBitmap(r0)
            goto Lc4
        La0:
            kotlin.jvm.internal.g.l(r3)
            throw r2
        La4:
            kotlin.jvm.internal.g.l(r3)
            throw r2
        La8:
            kotlin.jvm.internal.g.l(r3)
            throw r2
        Lac:
            int r0 = r6.width()
            int r2 = r6.height()
            android.graphics.Bitmap$Config r3 = android.graphics.Bitmap.Config.ARGB_8888
            android.graphics.Bitmap r0 = android.graphics.Bitmap.createBitmap(r0, r2, r3)
            kotlin.jvm.internal.g.e(r0, r1)
            r5.bitmapWithTransparency = r0
            android.graphics.Canvas r1 = r5.tmpCanvas
            r1.setBitmap(r0)
        Lc4:
            r5.trySmoothPath()
            super.onBoundsChange(r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.common.drawble.SmoothCornerDrawableWrapper.onBoundsChange(android.graphics.Rect):void");
    }

    public final void setProvideOutline(boolean z) {
        this.provideOutline = z;
    }

    public final void setRadius(float f8) {
        if (f8 == this.radius) {
            return;
        }
        this.radius = f8;
        this.needRegenPath = true;
        invalidateSelf();
    }

    public final void setSmoothCornerEnable(boolean z) {
        if (z != this.smoothCornerEnable) {
            this.smoothCornerEnable = z;
            this.needRegenPath = true;
            invalidateSelf();
        }
    }

    public final void setSmoothness(float f8) {
        float fZ = dc.h.Z(f8, 0.0f, 1.0f);
        if (fZ == this.smoothness) {
            return;
        }
        this.smoothness = fZ;
        this.needRegenPath = true;
        invalidateSelf();
    }

    public final void setStrokeColor(int i10) {
        if (i10 != this.strokeColor) {
            this.strokeColor = i10;
            this.needRegenPath = true;
            invalidateSelf();
        }
    }

    public final void setStrokeWidthExt(float f8) {
        if (f8 == this.strokeWidthExt) {
            return;
        }
        this.strokeWidthExt = f8;
        this.needRegenPath = true;
        this.strokePaint.setStrokeWidth(f8);
        invalidateSelf();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SmoothCornerDrawableWrapper(Drawable drawable, float f8, float f9) {
        this(drawable);
        g.f(drawable, "drawable");
        setSmoothness(f8);
        setRadius(f9);
    }

    public /* synthetic */ SmoothCornerDrawableWrapper(Drawable drawable, float f8, float f9, float f10, int i10, int i11, e eVar) {
        this(drawable, f8, f9, (i11 & 8) != 0 ? 0.0f : f10, (i11 & 16) != 0 ? -16777216 : i10);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SmoothCornerDrawableWrapper(Drawable drawable, float f8, float f9, float f10, int i10) {
        this(drawable, f8, f9);
        g.f(drawable, "drawable");
        setStrokeColor(i10);
        setStrokeWidthExt(f10);
    }
}
