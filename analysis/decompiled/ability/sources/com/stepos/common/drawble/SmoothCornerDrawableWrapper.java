package com.stepos.common.drawble;

import a5.i;
import a5.j;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableWrapper;
import androidx.annotation.FloatRange;
import androidx.annotation.RequiresApi;
import androidx.core.view.ViewCompat;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.aiengine.args.SingleFileBundle;
import g1.AbstractC1451a;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@RequiresApi(23)
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0017\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B#\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0001\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006¢\u0006\u0004\b\u0004\u0010\tB7\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0001\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\n\u001a\u00020\u0006\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u0004\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0011H\u0014¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u001d\u0010\u0010R\u0016\u0010\u001f\u001a\u00020\u001e8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0014\u0010!\u001a\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010$\u001a\u00020#8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010'\u001a\u00020&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010(R$\u0010*\u001a\u00020\u00062\u0006\u0010)\u001a\u00020\u00068\u0002@BX\u0082\u000e¢\u0006\f\n\u0004\b*\u0010+\"\u0004\b,\u0010-R$\u0010.\u001a\u00020\u00062\u0006\u0010)\u001a\u00020\u00068\u0002@BX\u0082\u000e¢\u0006\f\n\u0004\b.\u0010+\"\u0004\b/\u0010-R\"\u00100\u001a\u00020&8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b0\u0010(\u001a\u0004\b1\u00102\"\u0004\b3\u00104R*\u00105\u001a\u00020&2\u0006\u0010)\u001a\u00020&8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b5\u0010(\u001a\u0004\b6\u00102\"\u0004\b7\u00104R*\u0010\u0007\u001a\u00020\u00062\u0006\u0010)\u001a\u00020\u00068\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010+\u001a\u0004\b8\u00109\"\u0004\b:\u0010-R*\u0010\b\u001a\u00020\u00062\u0006\u0010)\u001a\u00020\u00068F@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010+\u001a\u0004\b;\u00109\"\u0004\b<\u0010-R*\u0010\f\u001a\u00020\u000b2\u0006\u0010)\u001a\u00020\u000b8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010=\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR*\u0010B\u001a\u00020\u00062\u0006\u0010)\u001a\u00020\u00068\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\bB\u0010+\u001a\u0004\bC\u00109\"\u0004\bD\u0010-R\u0017\u0010F\u001a\u00020E8\u0006¢\u0006\f\n\u0004\bF\u0010G\u001a\u0004\bH\u0010IR\u0011\u0010K\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\bJ\u00109¨\u0006L"}, d2 = {"Lcom/stepos/common/drawble/SmoothCornerDrawableWrapper;", "Landroid/graphics/drawable/DrawableWrapper;", "Landroid/graphics/drawable/Drawable;", "drawable", AppAgent.CONSTRUCT, "(Landroid/graphics/drawable/Drawable;)V", "", "smoothness", "radius", "(Landroid/graphics/drawable/Drawable;FF)V", "strokeWidth", "", "strokeColor", "(Landroid/graphics/drawable/Drawable;FFFI)V", "LC7/r;", "trySmoothPath", "()V", "Landroid/graphics/Rect;", "bounds", "onBoundsChange", "(Landroid/graphics/Rect;)V", "Landroid/graphics/Canvas;", "canvas", "draw", "(Landroid/graphics/Canvas;)V", "Landroid/graphics/Outline;", "outline", "getOutline", "(Landroid/graphics/Outline;)V", "invalidateSelf", "Landroid/graphics/Bitmap;", "bitmapWithTransparency", "Landroid/graphics/Bitmap;", "tmpCanvas", "Landroid/graphics/Canvas;", "Landroid/graphics/Path;", SingleFileBundle.KEY_PATH, "Landroid/graphics/Path;", "", "needRegenPath", "Z", "value", "widthFloat", "F", "setWidthFloat", "(F)V", "heightFloat", "setHeightFloat", "provideOutline", "getProvideOutline", "()Z", "setProvideOutline", "(Z)V", "smoothCornerEnable", "getSmoothCornerEnable", "setSmoothCornerEnable", "getSmoothness", "()F", "setSmoothness", "getRadius", "setRadius", "I", "getStrokeColor", "()I", "setStrokeColor", "(I)V", "strokeWidthExt", "getStrokeWidthExt", "setStrokeWidthExt", "Landroid/graphics/Paint;", "strokePaint", "Landroid/graphics/Paint;", "getStrokePaint", "()Landroid/graphics/Paint;", "getMaxSmoothRadius", "maxSmoothRadius", "StepOSCommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
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
        k.f(drawable, "drawable");
        this.tmpCanvas = new Canvas();
        this.path = new Path();
        this.provideOutline = true;
        this.smoothCornerEnable = true;
        this.smoothness = 0.2f;
        this.radius = 0.2f;
        this.strokeColor = ViewCompat.MEASURED_STATE_MASK;
        Paint paint = new Paint();
        paint.setColor(this.strokeColor);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeCap(Paint.Cap.BUTT);
        this.strokePaint = paint;
    }

    private final void setHeightFloat(float f) {
        if (this.heightFloat == f) {
            return;
        }
        this.heightFloat = f;
        this.needRegenPath = true;
    }

    private final void setWidthFloat(float f) {
        if (this.widthFloat == f) {
            return;
        }
        this.widthFloat = f;
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
        k.f(canvas, "canvas");
        if (!this.smoothCornerEnable) {
            super.draw(canvas);
            return;
        }
        this.tmpCanvas.drawColor(0);
        super.draw(this.tmpCanvas);
        this.tmpCanvas.drawPath(this.path, j.b);
        if (this.strokePaint.getStrokeWidth() > 0.0f) {
            float f = 2;
            Path pathA = j.a((this.strokePaint.getStrokeWidth() / f) + 0.0f, (this.strokePaint.getStrokeWidth() / f) + 0.0f, this.widthFloat - (this.strokePaint.getStrokeWidth() / f), this.heightFloat - (this.strokePaint.getStrokeWidth() / f), this.smoothness, getRadius() - (this.strokePaint.getStrokeWidth() / f), false);
            pathA.setFillType(Path.FillType.WINDING);
            this.tmpCanvas.drawPath(pathA, this.strokePaint);
        }
        Bitmap bitmap = this.bitmapWithTransparency;
        if (bitmap != null) {
            canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        } else {
            k.n("bitmapWithTransparency");
            throw null;
        }
    }

    public final float getMaxSmoothRadius() {
        i iVar = j.f1645a;
        return j.b(this.widthFloat, this.heightFloat, this.smoothness);
    }

    @Override // android.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        k.f(outline, "outline");
        super.getOutline(outline);
        if (this.smoothCornerEnable && this.provideOutline) {
            outline.setPath(this.path);
        }
    }

    public final boolean getProvideOutline() {
        return this.provideOutline;
    }

    public final float getRadius() {
        return AbstractC1451a.t(this.radius, 0.0f, getMaxSmoothRadius());
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
            kotlin.jvm.internal.k.f(r6, r0)
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
            kotlin.jvm.internal.k.n(r3)
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
            kotlin.jvm.internal.k.n(r3)
            throw r2
        L83:
            kotlin.jvm.internal.k.n(r3)
            throw r2
        L87:
            int r0 = r6.width()
            int r2 = r6.height()
            android.graphics.Bitmap$Config r3 = android.graphics.Bitmap.Config.ARGB_8888
            android.graphics.Bitmap r0 = android.graphics.Bitmap.createBitmap(r0, r2, r3)
            kotlin.jvm.internal.k.e(r0, r1)
            r5.bitmapWithTransparency = r0
            android.graphics.Canvas r1 = r5.tmpCanvas
            r1.setBitmap(r0)
            goto Lc4
        La0:
            kotlin.jvm.internal.k.n(r3)
            throw r2
        La4:
            kotlin.jvm.internal.k.n(r3)
            throw r2
        La8:
            kotlin.jvm.internal.k.n(r3)
            throw r2
        Lac:
            int r0 = r6.width()
            int r2 = r6.height()
            android.graphics.Bitmap$Config r3 = android.graphics.Bitmap.Config.ARGB_8888
            android.graphics.Bitmap r0 = android.graphics.Bitmap.createBitmap(r0, r2, r3)
            kotlin.jvm.internal.k.e(r0, r1)
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

    public final void setProvideOutline(boolean z10) {
        this.provideOutline = z10;
    }

    public final void setRadius(float f) {
        if (f == this.radius) {
            return;
        }
        this.radius = f;
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

    public final void setSmoothness(float f) {
        float fT = AbstractC1451a.t(f, 0.0f, 1.0f);
        if (fT == this.smoothness) {
            return;
        }
        this.smoothness = fT;
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

    public final void setStrokeWidthExt(float f) {
        if (f == this.strokeWidthExt) {
            return;
        }
        this.strokeWidthExt = f;
        this.needRegenPath = true;
        this.strokePaint.setStrokeWidth(f);
        invalidateSelf();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SmoothCornerDrawableWrapper(Drawable drawable, @FloatRange(from = 0.0d, to = 1.0d) float f, float f7) {
        this(drawable);
        k.f(drawable, "drawable");
        setSmoothness(f);
        setRadius(f7);
    }

    public /* synthetic */ SmoothCornerDrawableWrapper(Drawable drawable, float f, float f7, float f9, int i, int i6, e eVar) {
        this(drawable, f, f7, (i6 & 8) != 0 ? 0.0f : f9, (i6 & 16) != 0 ? ViewCompat.MEASURED_STATE_MASK : i);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SmoothCornerDrawableWrapper(Drawable drawable, @FloatRange(from = 0.0d, to = 1.0d) float f, float f7, float f9, int i) {
        this(drawable, f, f7);
        k.f(drawable, "drawable");
        setStrokeColor(i);
        setStrokeWidthExt(f9);
    }
}
