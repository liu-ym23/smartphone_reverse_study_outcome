package com.android.ttcjpaysdk.base.framework.container.drawable;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import com.android.ttcjpaysdk.base.ktextension.CJPayBasicExtensionKt;
import com.android.ttcjpaysdk.base.utils.CJPayAnimationUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\b\u0010\u001d\u001a\u00020\fH\u0016J\u0010\u0010\u001e\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020\fH\u0016J\u0012\u0010 \u001a\u00020\u001a2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/android/ttcjpaysdk/base/framework/container/drawable/CJPayStdSweepingDrawable;", "Landroid/graphics/drawable/Drawable;", "()V", "animator", "Landroid/animation/ValueAnimator;", "beamAngle", "", "beamAngleRadians", "", "beamHeight", "beamWidth", "beamXPosition", "", "curBounds", "Landroid/graphics/Rect;", "endX", "gradientColors", "", "gradientPositions", "", "mGradient", "Landroid/graphics/LinearGradient;", "mPaint", "Landroid/graphics/Paint;", "startX", "draw", "", "canvas", "Landroid/graphics/Canvas;", "getOpacity", "setAlpha", "alpha", "setColorFilter", "colorFilter", "Landroid/graphics/ColorFilter;", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPayStdSweepingDrawable extends Drawable {
    private ValueAnimator animator;
    private final float beamAngle;
    private final double beamAngleRadians;
    private float beamHeight;
    private final float beamWidth;
    private int beamXPosition;
    private Rect curBounds;
    private int endX;
    private int[] gradientColors;
    private float[] gradientPositions;
    private LinearGradient mGradient;
    private final Paint mPaint;
    private int startX;

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public CJPayStdSweepingDrawable() {
        Paint r100 = new Paint(1);
        r100.setStyle(Paint.Style.FILL);
        this.mPaint = r100;
        this.gradientColors = new int[]{16777215, 1291845631, 16777215};
        this.gradientPositions = new float[]{0.0f, 0.5f, 1.0f};
        this.beamWidth = CJPayBasicExtensionKt.dpF(50);
        this.beamAngle = 15.0f;
        this.beamAngleRadians = Math.toRadians(15.0f);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas r110) {
        Intrinsics.checkNotNullParameter(r110, "canvas");
        Rect r100 = getBounds();
        if (Intrinsics.areEqual(this.curBounds, r100) == true) goto L5;
        this.curBounds = new Rect(r100);
        float r101 = 2;
        this.startX = (r100.left - ((int) (((double) (r100.height() / 2)) * Math.tan(this.beamAngleRadians)))) - ((int) (((double) (this.beamWidth / r101)) / Math.cos(this.beamAngleRadians)));
        this.endX = (r100.right + ((int) (((double) (r100.height() / 2)) * Math.tan(this.beamAngleRadians)))) + ((int) (((double) (this.beamWidth / r101)) / Math.cos(this.beamAngleRadians)));
        this.beamHeight = (r100.height() / ((float) Math.cos(this.beamAngleRadians))) + (this.beamWidth * ((float) Math.tan(this.beamAngleRadians)));
        ValueAnimator r102 = ValueAnimator.ofInt(new int[]{this.startX, this.endX});
        r102.setDuration(1000);
        r102.setRepeatCount(-1);
        r102.setInterpolator(CJPayAnimationUtils.getBaseAnimationInterpolator());
        r102.addUpdateListener(new CJPayStdSweepingDrawable$draw$1$1(this));
        this.animator = r102;
        r102.start();
    L5:
        float r103 = this.beamXPosition;
        float r104 = r100.centerY();
        float r105 = this.beamWidth;
        float r106 = 2;
        float r107 = this.beamHeight;
        RectF r108 = new RectF(r103 - (r105 / r106), r104 - (r107 / r106), (r105 / r106) + r103, (r107 / r106) + r104);
        Matrix r111 = new Matrix();
        r111.postRotate(this.beamAngle, r103, r104);
        r111.mapRect(r108);
        float r109 = this.beamWidth;
        LinearGradient r112 = new LinearGradient(r103 - (r109 / r106), r104, r103 + (r109 / r106), r104, this.gradientColors, this.gradientPositions, Shader.TileMode.CLAMP);
        this.mGradient = r112;
        r112.setLocalMatrix(r111);
        this.mPaint.setShader(this.mGradient);
        r110.drawRect(r108, this.mPaint);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int r100) {
        this.mPaint.setAlpha(r100);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter r100) {
        this.mPaint.setColorFilter(r100);
        invalidateSelf();
    }

    public static final /* synthetic */ void access$setBeamXPosition$p(CJPayStdSweepingDrawable r100, int r101) {
        r100.beamXPosition = r101;
    }
}
