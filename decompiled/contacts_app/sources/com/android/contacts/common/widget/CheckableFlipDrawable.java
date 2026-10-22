package com.android.contacts.common.widget;

import android.animation.ValueAnimator;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.android.contacts.common.R;

/* JADX INFO: loaded from: classes.dex */
public class CheckableFlipDrawable extends FlipDrawable implements ValueAnimator.AnimatorUpdateListener {
    private static final float CHECKMARK_ALPHA_BEGIN_VALUE = 0.0f;
    private static final float CHECKMARK_SCALE_BEGIN_VALUE = 0.2f;
    private static final float END_VALUE = 1.0f;
    private static final int POST_FLIP_DURATION_MS = 150;
    private final ValueAnimator mCheckmarkAlphaAnimator;
    private final CheckmarkDrawable mCheckmarkDrawable;
    private final ValueAnimator mCheckmarkScaleAnimator;
    private final FrontDrawable mFrontDrawable;

    private static class CheckmarkDrawable extends Drawable {
        private static Bitmap sCheckMark;
        private static final Matrix sMatrix = null;
        private float mAlphaFraction;
        private final Paint mPaint;
        private float mScaleFraction;

        @Override // android.graphics.drawable.Drawable
        public int getOpacity() {
            return -1;
        }

        static {
            sMatrix = new Matrix();
        }

        public CheckmarkDrawable(Resources r2, int r3) {
            if (sCheckMark != null) goto L5;
            sCheckMark = BitmapFactory.decodeResource(r2, R.drawable.ic_check_wht_24dp);
        L5:
            Paint r4 = new Paint();
            this.mPaint = r4;
            r4.setAntiAlias(true);
            r4.setFilterBitmap(true);
            r4.setColor(r3);
        }

        public void setBackgroundColor(int r1) {
            this.mPaint.setColor(r1);
        }

        @Override // android.graphics.drawable.Drawable
        public void draw(Canvas r6) {
            Rect r0 = getBounds();
            if (isVisible() == true) goto L5;
            return;
        L5:
            if (r0.isEmpty() == true) goto L10;
            r6.drawCircle(r0.centerX(), r0.centerY(), r0.width() / 2, this.mPaint);
            Matrix r1 = sMatrix;
            r1.reset();
            float r2 = this.mScaleFraction;
            r1.setScale(r2, r2, sCheckMark.getWidth() / 2, sCheckMark.getHeight() / 2);
            r1.postTranslate(r0.centerX() - (sCheckMark.getWidth() / 2), r0.centerY() - (sCheckMark.getHeight() / 2));
            int r3 = this.mPaint.getAlpha();
            this.mPaint.setAlpha((int) (r3 * this.mAlphaFraction));
            r6.drawBitmap(sCheckMark, r1, this.mPaint);
            this.mPaint.setAlpha(r3);
            return;
        }

        @Override // android.graphics.drawable.Drawable
        public void setAlpha(int r1) {
            this.mPaint.setAlpha(r1);
        }

        @Override // android.graphics.drawable.Drawable
        public void setColorFilter(ColorFilter r1) {
            this.mPaint.setColorFilter(r1);
        }

        public void setScaleAnimatorValue(float r2) {
            float r0 = this.mScaleFraction;
            this.mScaleFraction = r2;
            if (r0 == r2) goto L6;
            invalidateSelf();
            return;
        }

        public void setAlphaAnimatorValue(float r2) {
            float r0 = this.mAlphaFraction;
            this.mAlphaFraction = r2;
            if (r0 == r2) goto L6;
            invalidateSelf();
            return;
        }
    }

    private static class FrontDrawable extends Drawable implements Drawable.Callback {
        private Drawable mDrawable;

        public FrontDrawable(Drawable r1) {
            this.mDrawable = r1;
            r1.setCallback(this);
        }

        public Drawable getInnerDrawable() {
            return this.mDrawable;
        }

        public void setInnerDrawable(Drawable r3) {
            this.mDrawable.setCallback(null);
            this.mDrawable = r3;
            r3.setCallback(this);
            assignDrawableBounds(getBounds());
            invalidateSelf();
        }

        @Override // android.graphics.drawable.Drawable
        public void setTintMode(PorterDuff.Mode r1) {
            this.mDrawable.setTintMode(r1);
        }

        @Override // android.graphics.drawable.Drawable
        public void setTintList(ColorStateList r1) {
            this.mDrawable.setTintList(r1);
        }

        @Override // android.graphics.drawable.Drawable
        public boolean setState(int[] r1) {
            return this.mDrawable.setState(r1);
        }

        @Override // android.graphics.drawable.Drawable
        protected void onBoundsChange(Rect r1) {
            super.onBoundsChange(r1);
            assignDrawableBounds(r1);
        }

        private void assignDrawableBounds(Rect r3) {
            int r0 = this.mDrawable.getIntrinsicWidth();
            int r1 = this.mDrawable.getIntrinsicHeight();
            if (r0 <= 0) goto L6;
            if (r1 <= 0) goto L6;
            this.mDrawable.setBounds(0, 0, r0, r1);
            return;
        L6:
            this.mDrawable.setBounds(r3);
        }

        @Override // android.graphics.drawable.Drawable
        public void draw(Canvas r5) {
            Rect r0 = getBounds();
            if (isVisible() == true) goto L5;
            return;
        L5:
            if (r0.isEmpty() == true) goto L16;
            int r1 = this.mDrawable.getIntrinsicWidth();
            int r2 = this.mDrawable.getIntrinsicHeight();
            if (r1 <= 0) goto L12;
            if (r2 <= 0) goto L12;
            float r3 = Math.max(r0.width() / r1, r0.height() / r2);
            r5.save();
            r5.scale(r3, r3);
            r5.translate(r0.left, r0.top);
            this.mDrawable.draw(r5);
            r5.restore();
            return;
        L12:
            this.mDrawable.draw(r5);
            return;
        }

        @Override // android.graphics.drawable.Drawable
        public void setAlpha(int r1) {
            this.mDrawable.setAlpha(r1);
        }

        @Override // android.graphics.drawable.Drawable
        public void setColorFilter(ColorFilter r1) {
            this.mDrawable.setColorFilter(r1);
        }

        @Override // android.graphics.drawable.Drawable
        public int getOpacity() {
            return this.mDrawable.getOpacity();
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void invalidateDrawable(Drawable r1) {
            invalidateSelf();
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void scheduleDrawable(Drawable r1, Runnable r2, long r3) {
            scheduleSelf(r2, r3);
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void unscheduleDrawable(Drawable r1, Runnable r2) {
            unscheduleSelf(r2);
        }
    }

    public CheckableFlipDrawable(Drawable r7, Resources r8, int r9, int r10) {
        super(new FrontDrawable(r7), new CheckmarkDrawable(r8, r9), r10, 0, 150);
        this.mFrontDrawable = (FrontDrawable) this.mFront;
        this.mCheckmarkDrawable = (CheckmarkDrawable) this.mBack;
        long r11 = this.mPreFlipDurationMs + (this.mFlipDurationMs / 2);
        long r0 = (this.mFlipDurationMs / 2) + this.mPostFlipDurationMs;
        ValueAnimator r12 = ValueAnimator.ofFloat(new float[]{0.2f, 1.0f}).setDuration(r0);
        this.mCheckmarkScaleAnimator = r12;
        r12.setStartDelay(r11);
        r12.addUpdateListener(this);
        ValueAnimator r13 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f}).setDuration(r0);
        this.mCheckmarkAlphaAnimator = r13;
        r13.setStartDelay(r11);
        r13.addUpdateListener(this);
    }

    public void setFront(Drawable r2) {
        this.mFrontDrawable.setInnerDrawable(r2);
        invalidateSelf();
    }

    public void setCheckMarkBackgroundColor(int r2) {
        this.mCheckmarkDrawable.setBackgroundColor(r2);
        invalidateSelf();
    }

    public Drawable getFrontDrawable() {
        return this.mFrontDrawable.getInnerDrawable();
    }

    @Override // com.android.contacts.common.widget.FlipDrawable
    public void reset() {
        ValueAnimator r0 = this.mCheckmarkScaleAnimator;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.cancel();
        this.mCheckmarkAlphaAnimator.cancel();
        boolean r1 = getSideFlippingTowards();
        CheckmarkDrawable r2 = this.mCheckmarkDrawable;
        float r3 = 1.0f;
        if (r1 == false) goto L8;
        float r4 = 0.2f;
    L9:
        r2.setScaleAnimatorValue(r4);
        CheckmarkDrawable r5 = this.mCheckmarkDrawable;
        if (r1 == false) goto L12;
        r3 = 0.0f;
    L12:
        r5.setAlphaAnimatorValue(r3);
        super.reset();
        return;
    L8:
        r4 = 1.0f;
        goto L9
    }

    @Override // com.android.contacts.common.widget.FlipDrawable
    public void flip() {
        super.flip();
        if (this.mCheckmarkScaleAnimator.isStarted() == false) goto L6;
        this.mCheckmarkScaleAnimator.reverse();
        this.mCheckmarkAlphaAnimator.reverse();
        return;
    L6:
        if (getSideFlippingTowards() == true) goto L8;
        this.mCheckmarkScaleAnimator.start();
        this.mCheckmarkAlphaAnimator.start();
        return;
    L8:
        this.mCheckmarkScaleAnimator.reverse();
        this.mCheckmarkAlphaAnimator.reverse();
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator r3) {
        Object r0 = r3.getAnimatedValue();
        if (r0 != null) goto L5;
        return;
    L5:
        float r1 = ((Float) r0).floatValue();
        if (r3 != this.mCheckmarkScaleAnimator) goto L9;
        this.mCheckmarkDrawable.setScaleAnimatorValue(r1);
        return;
    L9:
        if (r3 != this.mCheckmarkAlphaAnimator) goto L13;
        this.mCheckmarkDrawable.setAlphaAnimatorValue(r1);
        return;
    }
}
