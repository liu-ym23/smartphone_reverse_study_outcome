package com.bytedanceos.common.ui.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.LinearInterpolator;
import androidx.annotation.Nullable;
import com.bytedanceos.common.R$drawable;

/* JADX INFO: loaded from: classes2.dex */
public class CircleLightAnimationView extends View {
    private static final int OFFSET_X = -205;
    private static final int OFFSET_Y = -200;
    ValueAnimator mAnimator;
    private int mCenterX;
    Matrix mMatrix;
    Bitmap mRotatingLightBitmap;

    public CircleLightAnimationView(Context r10) {
        this(r10, null);
    }

    public static /* synthetic */ int access$000(CircleLightAnimationView r10) {
        return r10.mCenterX;
    }

    private Bitmap decodeResource(Resources r10, int r11) {
        TypedValue r12 = new TypedValue();
        r10.openRawResource(r11, r12);
        BitmapFactory.Options r13 = new BitmapFactory.Options();
        r13.inTargetDensity = r12.density;
        return BitmapFactory.decodeResource(r10, r11, r13);
    }

    private Bitmap getBitmap() {
        if (this.mRotatingLightBitmap != null) goto L6;
        this.mRotatingLightBitmap = decodeResource(getResources(), R$drawable.rotating_light);
    L6:
        return this.mRotatingLightBitmap;
    }

    private void init() {
        this.mCenterX = getResources().getDisplayMetrics().widthPixels / 2;
        getBitmap();
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Bitmap r10 = this.mRotatingLightBitmap;
        if (r10 != null) goto L5;
        return;
    L5:
        if (r10.isRecycled() == true) goto L9;
        this.mRotatingLightBitmap.recycle();
        this.mRotatingLightBitmap = null;
        return;
    }

    @Override // android.view.View
    public void onDraw(Canvas r10) {
        super.onDraw(r10);
        r10.save();
        getBitmap();
        Bitmap r11 = this.mRotatingLightBitmap;
        if (r11 != null) goto L5;
    L7:
        r10.restore();
        return;
    L5:
        if (r11.isRecycled() == true) goto L7;
        r10.drawBitmap(this.mRotatingLightBitmap, this.mMatrix, null);
        goto L7
    }

    public void releaseAnimator() {
        ValueAnimator r10 = this.mAnimator;
        if (r10 == null) goto L6;
        r10.cancel();
        this.mAnimator = null;
        return;
    }

    public void startAnimator() {
        if (this.mAnimator != null) goto L5;
        ValueAnimator r10 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.mAnimator = r10;
        r10.setDuration(20000);
        this.mAnimator.setRepeatCount(-1);
        this.mAnimator.setInterpolator(new LinearInterpolator());
        this.mAnimator.addUpdateListener(new AnonymousClass1(this));
    L5:
        this.mAnimator.start();
    }

    public CircleLightAnimationView(Context r10, @Nullable AttributeSet r11) {
        this(r10, r11, 0);
    }

    public CircleLightAnimationView(Context r10, @Nullable AttributeSet r11, int r12) {
        this(r10, r11, r12, 0);
    }

    public CircleLightAnimationView(Context r10, @Nullable AttributeSet r11, int r12, int r13) {
        super(r10, r11, r12, r13);
        this.mMatrix = new Matrix();
        init();
    }
}
