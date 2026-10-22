package com.stepos.common.drawble;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableWrapper;
import androidx.annotation.FloatRange;
import androidx.annotation.RequiresApi;
import com.baidu.mapapi.map.WeightedLatLng;
import com.stepos.alphame.utils.Property;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import m2.l;
import m2.m;
import org.jetbrains.annotations.NotNull;

@RequiresApi(23)
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0017\u0018\u00002\u00020\u0001B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007B5\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\fJ\u0010\u00105\u001a\u0002062\u0006\u00107\u001a\u000202H\u0016J\u0010\u00108\u001a\u0002062\u0006\u00109\u001a\u00020:H\u0016J\b\u0010;\u001a\u000206H\u0016J\u0010\u0010<\u001a\u0002062\u0006\u0010=\u001a\u00020>H\u0014J\b\u0010?\u001a\u000206H\u0002R\u000e\u0010\r\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000R\u001e\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0005@BX\u0082\u000e¢\u0006\b\n\u0000\"\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0013\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001a\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR&\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00058F@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0015\"\u0004\b \u0010\u0012R$\u0010!\u001a\u00020\u00172\u0006\u0010\u000f\u001a\u00020\u0017@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u001c\"\u0004\b#\u0010\u001eR$\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0005@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0015\"\u0004\b%\u0010\u0012R$\u0010\t\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\n@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u0011\u0010*\u001a\u00020+¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R$\u0010.\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0005@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u0015\"\u0004\b0\u0010\u0012R\u000e\u00101\u001a\u000202X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u00103\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0005@BX\u0082\u000e¢\u0006\b\n\u0000\"\u0004\b4\u0010\u0012¨\u0006@"}, d2 = {"Lcom/stepos/common/drawble/SmoothCornerDrawableWrapper;", "Landroid/graphics/drawable/DrawableWrapper;", "drawable", "Landroid/graphics/drawable/Drawable;", "smoothness", "", "radius", "(Landroid/graphics/drawable/Drawable;FF)V", "strokeWidth", "strokeColor", "", "(Landroid/graphics/drawable/Drawable;FFFI)V", "(Landroid/graphics/drawable/Drawable;)V", "bitmapWithTransparency", "Landroid/graphics/Bitmap;", "value", "heightFloat", "setHeightFloat", "(F)V", "maxSmoothRadius", "getMaxSmoothRadius", "()F", "needRegenPath", "", "path", "Landroid/graphics/Path;", "provideOutline", "getProvideOutline", "()Z", "setProvideOutline", "(Z)V", "getRadius", "setRadius", "smoothCornerEnable", "getSmoothCornerEnable", "setSmoothCornerEnable", "getSmoothness", "setSmoothness", "getStrokeColor", "()I", "setStrokeColor", "(I)V", "strokePaint", "Landroid/graphics/Paint;", "getStrokePaint", "()Landroid/graphics/Paint;", "strokeWidthExt", "getStrokeWidthExt", "setStrokeWidthExt", "tmpCanvas", "Landroid/graphics/Canvas;", "widthFloat", "setWidthFloat", "draw", "", "canvas", "getOutline", "outline", "Landroid/graphics/Outline;", "invalidateSelf", "onBoundsChange", "bounds", "Landroid/graphics/Rect;", "trySmoothPath", "StepOSCommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes.dex */
public class SmoothCornerDrawableWrapper extends DrawableWrapper {
    private Bitmap bitmapWithTransparency;
    private float heightFloat;
    private boolean needRegenPath;

    @NotNull
    private Path path;
    private boolean provideOutline;
    private float radius;
    private boolean smoothCornerEnable;
    private float smoothness;
    private int strokeColor;

    @NotNull
    private final Paint strokePaint;
    private float strokeWidthExt;

    @NotNull
    private final Canvas tmpCanvas;
    private float widthFloat;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SmoothCornerDrawableWrapper(@NotNull Drawable drawable) {
        super(drawable);
        Intrinsics.checkNotNullParameter(drawable, "drawable");
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

    private final void setHeightFloat(float f4) {
        if (this.heightFloat == f4) {
            return;
        }
        this.heightFloat = f4;
        this.needRegenPath = true;
    }

    private final void setWidthFloat(float f4) {
        if (this.widthFloat == f4) {
            return;
        }
        this.widthFloat = f4;
        this.needRegenPath = true;
    }

    private final void trySmoothPath() {
        if (this.needRegenPath) {
            Path pathA = m.a(Property.DEFAULT_FLOAT_VALUE, Property.DEFAULT_FLOAT_VALUE, this.widthFloat, this.heightFloat, this.smoothness, getRadius(), false);
            pathA.setFillType(Path.FillType.INVERSE_WINDING);
            this.path = pathA;
            this.needRegenPath = false;
        }
    }

    @Override // android.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
    public void draw(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        if (!this.smoothCornerEnable) {
            super.draw(canvas);
            return;
        }
        this.tmpCanvas.drawColor(0);
        super.draw(this.tmpCanvas);
        this.tmpCanvas.drawPath(this.path, m.f13584b);
        if (this.strokePaint.getStrokeWidth() > Property.DEFAULT_FLOAT_VALUE) {
            float f4 = 2;
            Path pathA = m.a((this.strokePaint.getStrokeWidth() / f4) + Property.DEFAULT_FLOAT_VALUE, (this.strokePaint.getStrokeWidth() / f4) + Property.DEFAULT_FLOAT_VALUE, this.widthFloat - (this.strokePaint.getStrokeWidth() / f4), this.heightFloat - (this.strokePaint.getStrokeWidth() / f4), this.smoothness, getRadius() - (this.strokePaint.getStrokeWidth() / f4), false);
            pathA.setFillType(Path.FillType.WINDING);
            this.tmpCanvas.drawPath(pathA, this.strokePaint);
        }
        Bitmap bitmap = this.bitmapWithTransparency;
        if (bitmap == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bitmapWithTransparency");
            bitmap = null;
        }
        canvas.drawBitmap(bitmap, Property.DEFAULT_FLOAT_VALUE, Property.DEFAULT_FLOAT_VALUE, (Paint) null);
    }

    public final float getMaxSmoothRadius() {
        l lVar = m.f13583a;
        return m.b(this.widthFloat, this.heightFloat, this.smoothness);
    }

    @Override // android.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
    public void getOutline(@NotNull Outline outline) {
        Intrinsics.checkNotNullParameter(outline, "outline");
        super.getOutline(outline);
        if (this.smoothCornerEnable && this.provideOutline) {
            outline.setPath(this.path);
        }
    }

    public final boolean getProvideOutline() {
        return this.provideOutline;
    }

    public final float getRadius() {
        return RangesKt___RangesKt.coerceIn(this.radius, Property.DEFAULT_FLOAT_VALUE, getMaxSmoothRadius());
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

    @NotNull
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
    public void onBoundsChange(@org.jetbrains.annotations.NotNull android.graphics.Rect r7) {
        /*
            r6 = this;
            java.lang.String r0 = "bounds"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
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
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r3)
            r0 = r2
        L2c:
            boolean r0 = r0.isRecycled()
            if (r0 == 0) goto L34
            goto Lb3
        L34:
            android.graphics.Bitmap r0 = r6.bitmapWithTransparency
            if (r0 != 0) goto L3c
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r3)
            r0 = r2
        L3c:
            int r0 = r0.getWidth()
            int r4 = r7.width()
            if (r0 != r4) goto L58
            android.graphics.Bitmap r0 = r6.bitmapWithTransparency
            if (r0 != 0) goto L4e
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r3)
            r0 = r2
        L4e:
            int r0 = r0.getHeight()
            int r4 = r7.height()
            if (r0 == r4) goto Ld2
        L58:
            int r0 = r7.width()
            android.graphics.Bitmap r4 = r6.bitmapWithTransparency
            if (r4 != 0) goto L64
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r3)
            r4 = r2
        L64:
            int r4 = r4.getWidth()
            if (r0 > r4) goto L93
            int r0 = r7.height()
            android.graphics.Bitmap r4 = r6.bitmapWithTransparency
            if (r4 != 0) goto L76
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r3)
            r4 = r2
        L76:
            int r4 = r4.getHeight()
            if (r0 > r4) goto L93
            android.graphics.Bitmap r0 = r6.bitmapWithTransparency
            if (r0 != 0) goto L84
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r3)
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
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            r6.bitmapWithTransparency = r0
            android.graphics.Canvas r1 = r6.tmpCanvas
            if (r0 != 0) goto Lae
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r3)
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
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            r6.bitmapWithTransparency = r0
            android.graphics.Canvas r1 = r6.tmpCanvas
            if (r0 != 0) goto Lce
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r3)
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

    public final void setProvideOutline(boolean z4) {
        this.provideOutline = z4;
    }

    public final void setRadius(float f4) {
        if (f4 == this.radius) {
            return;
        }
        this.radius = f4;
        this.needRegenPath = true;
        invalidateSelf();
    }

    public final void setSmoothCornerEnable(boolean z4) {
        if (z4 != this.smoothCornerEnable) {
            this.smoothCornerEnable = z4;
            this.needRegenPath = true;
            invalidateSelf();
        }
    }

    public final void setSmoothness(float f4) {
        float fCoerceIn = RangesKt___RangesKt.coerceIn(f4, Property.DEFAULT_FLOAT_VALUE, 1.0f);
        if (fCoerceIn == this.smoothness) {
            return;
        }
        this.smoothness = fCoerceIn;
        this.needRegenPath = true;
        invalidateSelf();
    }

    public final void setStrokeColor(int i4) {
        if (i4 != this.strokeColor) {
            this.strokeColor = i4;
            this.needRegenPath = true;
            invalidateSelf();
        }
    }

    public final void setStrokeWidthExt(float f4) {
        if (f4 == this.strokeWidthExt) {
            return;
        }
        this.strokeWidthExt = f4;
        this.needRegenPath = true;
        this.strokePaint.setStrokeWidth(f4);
        invalidateSelf();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SmoothCornerDrawableWrapper(@NotNull Drawable drawable, @FloatRange(from = 0.0d, to = WeightedLatLng.DEFAULT_INTENSITY) float f4, float f5) {
        this(drawable);
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        setSmoothness(f4);
        setRadius(f5);
    }

    public /* synthetic */ SmoothCornerDrawableWrapper(Drawable drawable, float f4, float f5, float f6, int i4, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this(drawable, f4, f5, (i5 & 8) != 0 ? Property.DEFAULT_FLOAT_VALUE : f6, (i5 & 16) != 0 ? -16777216 : i4);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SmoothCornerDrawableWrapper(@NotNull Drawable drawable, @FloatRange(from = 0.0d, to = WeightedLatLng.DEFAULT_INTENSITY) float f4, float f5, float f6, int i4) {
        this(drawable, f4, f5);
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        setStrokeColor(i4);
        setStrokeWidthExt(f6);
    }
}
