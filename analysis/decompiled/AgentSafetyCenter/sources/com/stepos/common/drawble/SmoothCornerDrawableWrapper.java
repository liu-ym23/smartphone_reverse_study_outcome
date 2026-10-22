package com.stepos.common.drawble;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableWrapper;
import p5.f;
import u9.i;
import u9.j;
import yb.k;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
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
        drawable.getClass();
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
            Path pathA = j.a(0.0f, 0.0f, this.widthFloat, this.heightFloat, this.smoothness, getRadius(), false);
            pathA.setFillType(Path.FillType.INVERSE_WINDING);
            this.path = pathA;
            this.needRegenPath = false;
        }
    }

    @Override // android.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        canvas.getClass();
        if (!this.smoothCornerEnable) {
            super.draw(canvas);
            return;
        }
        this.tmpCanvas.drawColor(0);
        super.draw(this.tmpCanvas);
        this.tmpCanvas.drawPath(this.path, j.f14274b);
        if (this.strokePaint.getStrokeWidth() > 0.0f) {
            float f5 = 2;
            Path pathA = j.a((this.strokePaint.getStrokeWidth() / f5) + 0.0f, (this.strokePaint.getStrokeWidth() / f5) + 0.0f, this.widthFloat - (this.strokePaint.getStrokeWidth() / f5), this.heightFloat - (this.strokePaint.getStrokeWidth() / f5), this.smoothness, getRadius() - (this.strokePaint.getStrokeWidth() / f5), false);
            pathA.setFillType(Path.FillType.WINDING);
            this.tmpCanvas.drawPath(pathA, this.strokePaint);
        }
        Bitmap bitmap = this.bitmapWithTransparency;
        if (bitmap != null) {
            canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        } else {
            k.f("bitmapWithTransparency");
            throw null;
        }
    }

    public final float getMaxSmoothRadius() {
        i iVar = j.f14273a;
        return j.b(this.widthFloat, this.heightFloat, this.smoothness);
    }

    @Override // android.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        outline.getClass();
        super.getOutline(outline);
        if (this.smoothCornerEnable && this.provideOutline) {
            outline.setPath(this.path);
        }
    }

    public final boolean getProvideOutline() {
        return this.provideOutline;
    }

    public final float getRadius() {
        return f.p(this.radius, 0.0f, getMaxSmoothRadius());
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

    /* JADX WARN: Removed duplicated region for block: B:24:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00a8  */
    @Override // android.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onBoundsChange(android.graphics.Rect r5) {
        /*
            r4 = this;
            r5.getClass()
            boolean r0 = r4.smoothCornerEnable
            if (r0 != 0) goto Lb
            super.onBoundsChange(r5)
            return
        Lb:
            int r0 = r5.width()
            float r0 = (float) r0
            r4.setWidthFloat(r0)
            int r0 = r5.height()
            float r0 = (float) r0
            r4.setHeightFloat(r0)
            android.graphics.Bitmap r0 = r4.bitmapWithTransparency
            if (r0 == 0) goto La8
            r1 = 0
            java.lang.String r2 = "bitmapWithTransparency"
            if (r0 == 0) goto La4
            boolean r0 = r0.isRecycled()
            if (r0 == 0) goto L2c
            goto La8
        L2c:
            android.graphics.Bitmap r0 = r4.bitmapWithTransparency
            if (r0 == 0) goto La0
            int r0 = r0.getWidth()
            int r3 = r5.width()
            if (r0 != r3) goto L4d
            android.graphics.Bitmap r0 = r4.bitmapWithTransparency
            if (r0 == 0) goto L49
            int r0 = r0.getHeight()
            int r3 = r5.height()
            if (r0 == r3) goto Lc0
            goto L4d
        L49:
            yb.k.f(r2)
            throw r1
        L4d:
            int r0 = r5.width()
            android.graphics.Bitmap r3 = r4.bitmapWithTransparency
            if (r3 == 0) goto L9c
            int r3 = r3.getWidth()
            if (r0 > r3) goto L83
            int r0 = r5.height()
            android.graphics.Bitmap r3 = r4.bitmapWithTransparency
            if (r3 == 0) goto L7f
            int r3 = r3.getHeight()
            if (r0 > r3) goto L83
            android.graphics.Bitmap r0 = r4.bitmapWithTransparency
            if (r0 == 0) goto L7b
            int r1 = r5.width()
            int r2 = r5.height()
            android.graphics.Bitmap$Config r3 = android.graphics.Bitmap.Config.ARGB_8888
            r0.reconfigure(r1, r2, r3)
            goto Lc0
        L7b:
            yb.k.f(r2)
            throw r1
        L7f:
            yb.k.f(r2)
            throw r1
        L83:
            int r0 = r5.width()
            int r1 = r5.height()
            android.graphics.Bitmap$Config r2 = android.graphics.Bitmap.Config.ARGB_8888
            android.graphics.Bitmap r0 = android.graphics.Bitmap.createBitmap(r0, r1, r2)
            r0.getClass()
            r4.bitmapWithTransparency = r0
            android.graphics.Canvas r1 = r4.tmpCanvas
            r1.setBitmap(r0)
            goto Lc0
        L9c:
            yb.k.f(r2)
            throw r1
        La0:
            yb.k.f(r2)
            throw r1
        La4:
            yb.k.f(r2)
            throw r1
        La8:
            int r0 = r5.width()
            int r1 = r5.height()
            android.graphics.Bitmap$Config r2 = android.graphics.Bitmap.Config.ARGB_8888
            android.graphics.Bitmap r0 = android.graphics.Bitmap.createBitmap(r0, r1, r2)
            r0.getClass()
            r4.bitmapWithTransparency = r0
            android.graphics.Canvas r1 = r4.tmpCanvas
            r1.setBitmap(r0)
        Lc0:
            r4.trySmoothPath()
            super.onBoundsChange(r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.common.drawble.SmoothCornerDrawableWrapper.onBoundsChange(android.graphics.Rect):void");
    }

    public final void setProvideOutline(boolean z10) {
        this.provideOutline = z10;
    }

    public final void setRadius(float f5) {
        if (f5 == this.radius) {
            return;
        }
        this.radius = f5;
        this.needRegenPath = true;
        invalidateSelf();
    }

    public final void setSmoothCornerEnable(boolean z10) {
        if (z10 != this.smoothCornerEnable) {
            this.smoothCornerEnable = z10;
            this.needRegenPath = true;
            invalidateSelf();
        }
    }

    public final void setSmoothness(float f5) {
        float fP = f.p(f5, 0.0f, 1.0f);
        if (fP == this.smoothness) {
            return;
        }
        this.smoothness = fP;
        this.needRegenPath = true;
        invalidateSelf();
    }

    public final void setStrokeColor(int i) {
        if (i != this.strokeColor) {
            this.strokeColor = i;
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
    public SmoothCornerDrawableWrapper(Drawable drawable, float f5, float f10) {
        this(drawable);
        drawable.getClass();
        setSmoothness(f5);
        setRadius(f10);
    }

    public /* synthetic */ SmoothCornerDrawableWrapper(Drawable drawable, float f5, float f10, float f11, int i, int i3, yb.f fVar) {
        this(drawable, f5, f10, (i3 & 8) != 0 ? 0.0f : f11, (i3 & 16) != 0 ? -16777216 : i);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SmoothCornerDrawableWrapper(Drawable drawable, float f5, float f10, float f11, int i) {
        this(drawable, f5, f10);
        drawable.getClass();
        setStrokeColor(i);
        setStrokeWidthExt(f11);
    }
}
