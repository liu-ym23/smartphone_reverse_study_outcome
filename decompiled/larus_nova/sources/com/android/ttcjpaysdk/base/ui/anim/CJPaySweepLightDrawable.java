package com.android.ttcjpaysdk.base.ui.anim;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\fH\u0002J\u0010\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0017H\u0016J\u0010\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u001bH\u0014J\u0010\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\u0017H\u0016J\u0012\u0010\u001e\u001a\u00020\u00102\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\u000e\u0010!\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\fJ\u0014\u0010\"\u001a\u00020\u0017*\u00020\u00172\u0006\u0010\u001d\u001a\u00020\fH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/anim/CJPaySweepLightDrawable;", "Landroid/graphics/drawable/Drawable;", "config", "Lcom/android/ttcjpaysdk/base/ui/anim/CJPaySweepLightConfig;", "(Lcom/android/ttcjpaysdk/base/ui/anim/CJPaySweepLightConfig;)V", "drawRect", "Landroid/graphics/RectF;", "gradientMatrix", "Landroid/graphics/Matrix;", "paint", "Landroid/graphics/Paint;", "progress", "", "shader", "Landroid/graphics/LinearGradient;", "buildShader", "", "width", "height", "draw", "canvas", "Landroid/graphics/Canvas;", "getAlpha", "", "getOpacity", "onBoundsChange", "bounds", "Landroid/graphics/Rect;", "setAlpha", "alpha", "setColorFilter", "colorFilter", "Landroid/graphics/ColorFilter;", "updateProgress", "withAlpha", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPaySweepLightDrawable extends Drawable {
    private final CJPaySweepLightConfig config;
    private final RectF drawRect;
    private final Matrix gradientMatrix;
    private final Paint paint;
    private float progress;
    private LinearGradient shader;

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.paint.getAlpha();
    }

    public CJPaySweepLightDrawable(CJPaySweepLightConfig r100) {
        Intrinsics.checkNotNullParameter(r100, "config");
        this.config = r100;
        this.paint = new Paint(1);
        this.drawRect = new RectF();
        this.gradientMatrix = new Matrix();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        LinearGradient r101 = this.shader;
        if (r101 != null) goto L6;
        return;
    L6:
        if (this.drawRect.isEmpty() == false) goto L8;
        return;
    L8:
        float r102 = (-this.drawRect.width()) + ((this.drawRect.width() * 2.0f) * this.progress);
        this.gradientMatrix.reset();
        this.gradientMatrix.setTranslate(r102, 0.0f);
        r101.setLocalMatrix(this.gradientMatrix);
        r100.drawRoundRect(this.drawRect, this.config.getCornerRadius(), this.config.getCornerRadius(), this.paint);
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect r100) {
        Intrinsics.checkNotNullParameter(r100, "bounds");
        super.onBoundsChange(r100);
        this.drawRect.set(r100);
        buildShader(r100.width(), r100.height());
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int r100) {
        this.paint.setAlpha(r100);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter r100) {
        this.paint.setColorFilter(r100);
    }

    public final void updateProgress(float r100) {
        this.progress = RangesKt.coerceIn(r100, 0.0f, 1.0f);
        invalidateSelf();
    }

    private final void buildShader(float r110, float r111) {
        if (r110 > 0.0f) goto L5;
    L9:
        this.shader = null;
        return;
    L5:
        if (r111 <= 0.0f) goto L9;
        LinearGradient r112 = new LinearGradient(r110 * this.config.getGradientStartPoint().x, r111 * this.config.getGradientStartPoint().y, r110 * this.config.getGradientEndPoint().x, r111 * this.config.getGradientEndPoint().y, new int[]{withAlpha(this.config.getBaseColor(), this.config.getSideAlpha()), withAlpha(this.config.getBaseColor(), this.config.getCenterAlpha()), withAlpha(this.config.getBaseColor(), this.config.getSideAlpha())}, new float[]{0.0f, 0.5f, 1.0f}, Shader.TileMode.CLAMP);
        this.paint.setShader(r112);
        this.shader = r112;
    }

    private final int withAlpha(int r100, float r101) {
        return Color.argb((int) (RangesKt.coerceIn(r101, 0.0f, 1.0f) * Color.alpha(r100)), Color.red(r100), Color.green(r100), Color.blue(r100));
    }
}
