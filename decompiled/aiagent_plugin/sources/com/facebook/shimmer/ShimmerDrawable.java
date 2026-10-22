package com.facebook.shimmer;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes.dex */
public final class ShimmerDrawable extends Drawable {
    private final Rect mDrawRect;
    private final Matrix mShaderMatrix;
    private a mShimmer;
    private final Paint mShimmerPaint;
    private final ValueAnimator.AnimatorUpdateListener mUpdateListener;
    private ValueAnimator mValueAnimator;

    private float offset(float r1, float r2, float r3) {
        return r1 + ((r2 - r1) * r3);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int r1) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter r1) {
    }

    public ShimmerDrawable() {
        this.mUpdateListener = new AnonymousClass1(this);
        Paint r0 = new Paint();
        this.mShimmerPaint = r0;
        this.mDrawRect = new Rect();
        this.mShaderMatrix = new Matrix();
        r0.setAntiAlias(true);
    }

    public void setShimmer(a r3) {
        this.mShimmer = r3;
        if (r3 == null) goto L9;
        Paint r4 = this.mShimmerPaint;
        if (this.mShimmer.q == false) goto L7;
        PorterDuff.Mode r1 = PorterDuff.Mode.DST_IN;
    L8:
        r4.setXfermode(new PorterDuffXfermode(r1));
        goto L9
    L7:
        r1 = PorterDuff.Mode.SRC_IN;
    L9:
        updateShader();
        updateValueAnimator();
        invalidateSelf();
    }

    public void startShimmer() {
        if (this.mValueAnimator != null) goto L5;
        return;
    L5:
        if (isShimmerStarted() == false) goto L7;
        return;
    L7:
        if (getCallback() == null) goto L12;
        this.mValueAnimator.start();
        return;
    }

    public void stopShimmer() {
        if (this.mValueAnimator != null) goto L5;
        return;
    L5:
        if (isShimmerStarted() == false) goto L9;
        this.mValueAnimator.cancel();
        return;
    }

    public boolean isShimmerStarted() {
        ValueAnimator r0 = this.mValueAnimator;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.isStarted() == false) goto L7;
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect r4) {
        super.onBoundsChange(r4);
        int r0 = r4.width();
        int r5 = r4.height();
        this.mDrawRect.set(0, 0, r0, r5);
        updateShader();
        maybeStartShimmer();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas r9) {
        if (this.mShimmer != null) goto L5;
        return;
    L5:
        if (this.mShimmerPaint.getShader() == null) goto L25;
        float r0 = (float) Math.tan(Math.toRadians(this.mShimmer.n));
        float r1 = this.mDrawRect.height() + (this.mDrawRect.width() * r0);
        float r2 = this.mDrawRect.width() + (r0 * this.mDrawRect.height());
        ValueAnimator r3 = this.mValueAnimator;
        float r4 = 0.0f;
        if (r3 == null) goto L10;
        float r5 = r3.getAnimatedFraction();
    L11:
        int r6 = this.mShimmer.f11961d;
        if (r6 != 1) goto L14;
        float r7 = offset(-r1, r1, r5);
    L22:
        this.mShaderMatrix.reset();
        this.mShaderMatrix.setRotate(this.mShimmer.n, this.mDrawRect.width() / 2.0f, this.mDrawRect.height() / 2.0f);
        this.mShaderMatrix.postTranslate(r4, r7);
        this.mShimmerPaint.getShader().setLocalMatrix(this.mShaderMatrix);
        r9.drawRect(this.mDrawRect, this.mShimmerPaint);
        return;
    L14:
        if (r6 != 2) goto L16;
        float r8 = offset(r2, -r2, r5);
    L18:
        r4 = r8;
        r7 = 0.0f;
        goto L22
    L16:
        if (r6 == 3) goto L19;
        r8 = offset(-r2, r2, r5);
        goto L18
    L19:
        r7 = offset(r1, -r1, r5);
        goto L22
    L10:
        r5 = 0.0f;
        goto L11
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        a r0 = this.mShimmer;
        if (r0 != null) goto L5;
    L9:
        return -1;
    L5:
        if (r0.o == false) goto L7;
    L8:
        return -3;
    L7:
        if (this.mShimmer.q == false) goto L9;
        goto L8
    }

    private void updateValueAnimator() {
        if (this.mShimmer != null) goto L5;
        return;
    L5:
        ValueAnimator r0 = this.mValueAnimator;
        if (r0 == null) goto L8;
        boolean r1 = r0.isStarted();
        this.mValueAnimator.cancel();
        this.mValueAnimator.removeAllUpdateListeners();
    L9:
        ValueAnimator r2 = ValueAnimator.ofFloat(new float[]{0.0f, (this.mShimmer.u / this.mShimmer.t) + 1.0f});
        this.mValueAnimator = r2;
        r2.setRepeatMode(this.mShimmer.s);
        this.mValueAnimator.setRepeatCount(this.mShimmer.r);
        this.mValueAnimator.setDuration(this.mShimmer.t + this.mShimmer.u);
        this.mValueAnimator.addUpdateListener(this.mUpdateListener);
        if (r1 == false) goto L13;
        this.mValueAnimator.start();
        return;
    L13:
        return;
    L8:
        r1 = false;
        goto L9
    }

    void maybeStartShimmer() {
        ValueAnimator r0 = this.mValueAnimator;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isStarted() == true) goto L15;
        a r1 = this.mShimmer;
        if (r1 != null) goto L9;
        return;
    L9:
        if (r1.p == true) goto L11;
        return;
    L11:
        if (getCallback() == null) goto L18;
        this.mValueAnimator.start();
        return;
    L18:
        return;
    }

    private void updateShader() {
        Rect r1 = getBounds();
        int r2 = r1.width();
        int r3 = r1.height();
        if (r2 == 0) goto L25;
        if (r3 == 0) goto L26;
        a r4 = this.mShimmer;
        if (r4 == null) goto L27;
        int r5 = r4.a(r2);
        int r6 = this.mShimmer.b(r3);
        boolean r7 = true;
        if (this.mShimmer.g != 1) goto L11;
        Shader r11 = new RadialGradient(r5 / 2.0f, r6 / 2.0f, (float) (((double) Math.max(r5, r6)) / Math.sqrt(2.0d)), this.mShimmer.f11959b, this.mShimmer.f11958a, Shader.TileMode.CLAMP);
    L23:
        this.mShimmerPaint.setShader(r11);
        return;
    L11:
        if (this.mShimmer.f11961d != 1) goto L13;
    L16:
        if (r7 == false) goto L18;
        r5 = 0;
    L18:
        if (r7 == true) goto L21;
        r6 = 0;
    L21:
        r11 = new LinearGradient(0.0f, 0.0f, r5, r6, this.mShimmer.f11959b, this.mShimmer.f11958a, Shader.TileMode.CLAMP);
        goto L23
    L13:
        if (this.mShimmer.f11961d == 3) goto L16;
        r7 = false;
        goto L16
    L27:
        return;
    L26:
        return;
    }
}
