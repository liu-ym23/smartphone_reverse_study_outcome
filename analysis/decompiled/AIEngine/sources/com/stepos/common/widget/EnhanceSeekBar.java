package com.stepos.common.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
import com.stepos.aiengine.R;
import com.stepos.core.ability.speech.PcmDumpBudget;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class EnhanceSeekBar extends View {
    private static final int AURA_HIDE_ANIM_TIME = 200;
    private static final float AURA_SCALE_BASELINE = 1.0f;
    private static final float AURA_SCALE_TARGET = 0.5f;
    private static final int AURA_SHOW_ANIM_TIME = 180;
    private static final int MIN_HEIGHT = 20;
    private static final int MIN_WIDTH = 64;
    private static final String TAG = "EnhanceSeekBar";
    private static final float THUMB_SCALE_BASELINE = 1.0f;
    private static final float THUMB_SCALE_TARGET = 0.7f;
    private static final int TIMEOUT_SEND_ACCESSIBILITY_EVENT = 200;
    private boolean hasMoved;
    private int iconPadding;
    private int iconWidth;
    private boolean isAuraShow;
    private boolean isDrag;
    private AccessibilityEventSender mAccessibilityEventSender;
    private boolean mAccessibilityFocused;
    private Drawable mAuraDrawble;
    private int mAuraHeight;
    private ValueAnimator mAuraHideAnimator;
    private Interpolator mAuraHideInterpolator;
    private int mAuraRadius;
    private ValueAnimator mAuraShowAnimator;
    private Interpolator mAuraShowInterpolator;
    private int mAuraWidth;
    private int mDistance;
    private ValueAnimator mDrawablePositionAnimator;
    private DrawableXYHolder mDrawableXYHolder;
    private boolean mEnableEngine;
    private XYHolder mEndXY;
    private int mFontHeight;
    private int mHalfThumbHeight;
    private int mHalfThumbWidth;
    private float mInitialThumbX;
    private float mInitialTouchX;
    private boolean mIsDragging;
    private boolean mIsInItemPositon;
    private int mItemTextColor;
    private int mItemTextPosition;
    private CharSequence[] mItems;
    private Drawable mLeftIcon;
    private Rect mLeftIconRect;
    private Interpolator mLocationInterpolator;
    private int mMax;
    private OnEnhanceSeekBarChangeListener mOnEnhanceSeekBarChangeListener;
    private Paint mPaint;
    private int mPaintColor;
    private ColorStateList mPaintColorStateList;
    private int mProgress;
    private Drawable mRightIcon;
    private Rect mRightIconRect;
    private int mScaledTouchSlop;
    private int mSpotColor;
    private ColorStateList mSpotColorStateList;
    private float mSpotRadius;
    private XYHolder mStartXY;
    private int mStrokeColor;
    private ColorStateList mStrokeColorStateList;
    private int mStrokeWidth;
    private Paint mTextPaint;
    private int mTextSize;
    private Drawable mThumb;
    private int mThumbOffset;
    private ValueAnimator mThumbRecoverAnimator;
    private Interpolator mThumbRecoverInterpolator;
    private float mThumbScaleValue;
    private ValueAnimator mThumbShrinkAnimator;
    private Interpolator mThumbShrinkInterpolator;
    private int mTouchDownProgress;
    private XYEvaluator mXYEvaluator;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class AccessibilityEventSender implements Runnable {
        private AccessibilityEventSender() {
        }

        @Override // java.lang.Runnable
        public void run() {
            EnhanceSeekBar.this.sendAccessibilityEvent(4);
            EnhanceSeekBar enhanceSeekBar = EnhanceSeekBar.this;
            enhanceSeekBar.announceForAccessibility(String.format(enhanceSeekBar.getResources().getString(R.string.mc_enhanceseekbar), EnhanceSeekBar.this.mItems[EnhanceSeekBar.this.mProgress]));
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class DrawableXYHolder {
        private Drawable mDrawable;

        public DrawableXYHolder() {
        }

        public XYHolder getXY() {
            Drawable drawable = this.mDrawable;
            if (drawable == null) {
                return null;
            }
            Rect bounds = drawable.getBounds();
            return EnhanceSeekBar.this.new XYHolder(bounds.left, bounds.top);
        }

        public void setDrawable(Drawable drawable) {
            this.mDrawable = drawable;
        }

        public void setXY(XYHolder xYHolder) {
            Drawable drawable = this.mDrawable;
            if (drawable == null) {
                return;
            }
            drawable.setBounds((int) xYHolder.getX(), (int) xYHolder.getY(), (int) (xYHolder.getX() + this.mDrawable.getIntrinsicWidth()), (int) (xYHolder.getY() + this.mDrawable.getIntrinsicHeight()));
            EnhanceSeekBar.this.invalidate();
        }

        public DrawableXYHolder(Drawable drawable) {
            this.mDrawable = drawable;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public interface OnEnhanceSeekBarChangeListener {
        void onProgressChanged(EnhanceSeekBar enhanceSeekBar, int i10);

        void onProgressDragging(EnhanceSeekBar enhanceSeekBar, int i10);

        void onStartTrackingTouch(EnhanceSeekBar enhanceSeekBar);

        void onStopTrackingTouch(EnhanceSeekBar enhanceSeekBar);
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.stepos.common.widget.EnhanceSeekBar.SavedState.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SavedState[] newArray(int i10) {
                return new SavedState[i10];
            }
        };
        int progress;

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeInt(this.progress);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.progress = parcel.readInt();
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class XYEvaluator implements TypeEvaluator {
        private XYEvaluator() {
        }

        @Override // android.animation.TypeEvaluator
        public Object evaluate(float f8, Object obj, Object obj2) {
            XYHolder xYHolder = (XYHolder) obj;
            XYHolder xYHolder2 = (XYHolder) obj2;
            return EnhanceSeekBar.this.new XYHolder(h0.e.a(xYHolder2.getX(), xYHolder.getX(), f8, xYHolder.getX()), h0.e.a(xYHolder2.getY(), xYHolder.getY(), f8, xYHolder.getY()));
        }
    }

    public EnhanceSeekBar(Context context) {
        this(context, null);
    }

    private void attemptClaimDrag() {
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(true);
        }
    }

    private void flingThumb(MotionEvent motionEvent) {
        ValueAnimator valueAnimator = this.mDrawablePositionAnimator;
        if (valueAnimator == null || !valueAnimator.isStarted()) {
            int width = ((getWidth() - getPaddingLeft()) - getPaddingRight()) - (this.iconWidth * 2);
            int x3 = (int) motionEvent.getX();
            Rect bounds = this.mThumb.getBounds();
            int i10 = (int) ((this.mInitialThumbX + x3) - this.mInitialTouchX);
            if (i10 < 0) {
                i10 = 0;
            } else if (i10 > width) {
                i10 = width;
            }
            int iRound = isRTL() ? Math.round((1.0f - (i10 / width)) * getMax()) : Math.round((i10 / width) * getMax());
            setProgress(iRound, true, true);
            int max = isRTL() ? (int) ((1.0f - (iRound / getMax())) * width) : (width * iRound) / getMax();
            Drawable drawable = this.mThumb;
            drawable.setBounds(max, bounds.top, drawable.getIntrinsicWidth() + max, bounds.bottom);
            invalidate();
        }
    }

    private int getDisabledColor(ColorStateList colorStateList) {
        return colorStateList.getColorForState(new int[]{-16842910}, 0);
    }

    private synchronized int getMax() {
        return this.mMax;
    }

    private int getNormalColor(ColorStateList colorStateList) {
        return colorStateList.getColorForState(new int[]{android.R.attr.state_enabled}, 0);
    }

    public static String getTAG() {
        return TAG;
    }

    private boolean isPointInside(int i10, int i11) {
        return true;
    }

    private boolean isRTL() {
        return getContext().getResources().getConfiguration().getLayoutDirection() == 1;
    }

    private void onProgressRefresh(float f8) {
        Drawable drawable = this.mThumb;
        if (drawable != null) {
            setThumbPos(getWidth(), drawable, f8, Integer.MIN_VALUE);
        }
    }

    private void prepareStartAuraHide() {
        this.isAuraShow = false;
        if (this.mAuraDrawble == null || this.mThumb == null) {
            return;
        }
        startAuraHideAnim();
    }

    private void prepareStartAuraShow() {
        if (this.mThumb == null || this.mAuraDrawble == null || this.isAuraShow) {
            return;
        }
        startAuraShowAnim();
    }

    private void refreshRes() {
        if (isEnabled()) {
            this.mStrokeColor = getNormalColor(this.mStrokeColorStateList);
            this.mSpotColor = getNormalColor(this.mSpotColorStateList);
            this.mPaintColor = getNormalColor(this.mPaintColorStateList);
        } else {
            this.mStrokeColor = getDisabledColor(this.mStrokeColorStateList);
            this.mSpotColor = getDisabledColor(this.mSpotColorStateList);
            this.mPaintColor = getDisabledColor(this.mPaintColorStateList);
        }
    }

    private void scheduleAccessibilityEventSender() {
        AccessibilityEventSender accessibilityEventSender = this.mAccessibilityEventSender;
        if (accessibilityEventSender == null) {
            this.mAccessibilityEventSender = new AccessibilityEventSender();
        } else {
            removeCallbacks(accessibilityEventSender);
        }
        postDelayed(this.mAccessibilityEventSender, 200L);
    }

    private void setIconRect() {
        this.mLeftIconRect = new Rect(getPaddingLeft(), ((getPaddingTop() + this.mFontHeight) + this.mHalfThumbHeight) - ((this.iconWidth - this.iconPadding) / 2), (getPaddingLeft() + this.iconWidth) - this.iconPadding, ((this.iconWidth - this.iconPadding) / 2) + getPaddingTop() + this.mFontHeight + this.mHalfThumbHeight);
        this.mRightIconRect = new Rect(((getWidth() - getPaddingRight()) - this.iconWidth) + this.iconPadding, ((getPaddingTop() + this.mFontHeight) + this.mHalfThumbHeight) - ((this.iconWidth - this.iconPadding) / 2), getWidth() - getPaddingRight(), ((this.iconWidth - this.iconPadding) / 2) + getPaddingTop() + this.mFontHeight + this.mHalfThumbHeight);
    }

    private void setLeftIcon(Drawable drawable) {
        this.mRightIcon = drawable;
        drawable.setCallback(this);
    }

    private synchronized void setMax(int i10) {
        if (i10 < 0) {
            i10 = 0;
        }
        try {
            if (i10 != this.mMax) {
                this.mMax = i10;
                if (this.mProgress > i10) {
                    this.mProgress = i10;
                }
                onProgressRefresh(i10 > 0 ? this.mProgress / i10 : 0.0f);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    private void setRightIcon(Drawable drawable) {
        this.mLeftIcon = drawable;
        drawable.setCallback(this);
    }

    private void setThumbOffset(int i10) {
        this.mThumbOffset = i10;
        invalidate();
    }

    private void setThumbPos(int i10, Drawable drawable, float f8, int i11) {
        int iRound;
        int i12;
        int intrinsicHeight;
        int i13;
        boolean z;
        OnEnhanceSeekBarChangeListener onEnhanceSeekBarChangeListener;
        int paddingLeft = ((i10 - getPaddingLeft()) - getPaddingRight()) - (this.iconWidth * 2);
        int intrinsicWidth = drawable.getIntrinsicWidth();
        if (isRTL()) {
            iRound = paddingLeft - Math.round(f8 * paddingLeft);
            i12 = paddingLeft - iRound;
        } else {
            iRound = paddingLeft - Math.round((1.0f - f8) * paddingLeft);
            i12 = iRound;
        }
        int i14 = intrinsicWidth + i12;
        boolean z3 = false;
        if (i11 == Integer.MIN_VALUE) {
            Rect bounds = drawable.getBounds();
            i13 = bounds.top;
            intrinsicHeight = bounds.bottom;
            z = true;
        } else {
            intrinsicHeight = drawable.getIntrinsicHeight() + i11;
            i13 = i11;
            z = false;
        }
        ValueAnimator valueAnimator = this.mDrawablePositionAnimator;
        if (valueAnimator == null) {
            z3 = z;
        } else {
            if (!z) {
                valueAnimator.cancel();
                this.mDrawablePositionAnimator = null;
            } else if (!valueAnimator.isStarted()) {
            }
            z3 = z;
        }
        if (z3) {
            int i15 = drawable.getBounds().left;
            if (i15 == iRound) {
                this.mIsInItemPositon = true;
                if (i11 != Integer.MIN_VALUE || (onEnhanceSeekBarChangeListener = this.mOnEnhanceSeekBarChangeListener) == null) {
                    return;
                }
                onEnhanceSeekBarChangeListener.onProgressChanged(this, getProgress());
                return;
            }
            float f9 = i13;
            this.mStartXY.setXY(i15, f9);
            this.mEndXY.setXY(iRound, f9);
            this.mDrawableXYHolder.setDrawable(drawable);
            this.mDrawablePositionAnimator = ObjectAnimator.ofObject(this.mXYEvaluator, this.mStartXY, this.mEndXY);
            this.mDrawablePositionAnimator.setDuration((int) (Math.abs(this.mEndXY.getX() - this.mStartXY.getX()) * 0.44444445f));
            this.mDrawablePositionAnimator.setInterpolator(this.mLocationInterpolator);
            this.mDrawablePositionAnimator.addListener(new AnimatorListenerAdapter() { // from class: com.stepos.common.widget.EnhanceSeekBar.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    if (EnhanceSeekBar.this.mOnEnhanceSeekBarChangeListener != null) {
                        OnEnhanceSeekBarChangeListener onEnhanceSeekBarChangeListener2 = EnhanceSeekBar.this.mOnEnhanceSeekBarChangeListener;
                        EnhanceSeekBar enhanceSeekBar = EnhanceSeekBar.this;
                        onEnhanceSeekBarChangeListener2.onProgressChanged(enhanceSeekBar, enhanceSeekBar.getProgress());
                    }
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (EnhanceSeekBar.this.mOnEnhanceSeekBarChangeListener != null) {
                        OnEnhanceSeekBarChangeListener onEnhanceSeekBarChangeListener2 = EnhanceSeekBar.this.mOnEnhanceSeekBarChangeListener;
                        EnhanceSeekBar enhanceSeekBar = EnhanceSeekBar.this;
                        onEnhanceSeekBarChangeListener2.onProgressChanged(enhanceSeekBar, enhanceSeekBar.getProgress());
                    }
                }
            });
            this.mDrawablePositionAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.stepos.common.widget.EnhanceSeekBar.2
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                    EnhanceSeekBar.this.mDrawableXYHolder.setXY((XYHolder) valueAnimator2.getAnimatedValue());
                }
            });
            this.mDrawablePositionAnimator.start();
        } else {
            this.mThumb.setBounds(i12, i13, i14, intrinsicHeight);
            invalidate();
        }
        this.mIsInItemPositon = true;
    }

    private void startAuraHideAnim() {
        if (this.mAuraHideAnimator == null) {
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(1.0f, 0.5f);
            this.mAuraHideAnimator = valueAnimatorOfFloat;
            valueAnimatorOfFloat.setDuration(200L);
            this.mAuraHideAnimator.setInterpolator(this.mAuraHideInterpolator);
            this.mAuraHideAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.stepos.common.widget.EnhanceSeekBar.5
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    EnhanceSeekBar.this.mAuraRadius = (int) ((r0.mAuraHeight / 2) * fFloatValue);
                    EnhanceSeekBar.this.invalidate();
                }
            });
            this.mAuraHideAnimator.addListener(new AnimatorListenerAdapter() { // from class: com.stepos.common.widget.EnhanceSeekBar.6
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    EnhanceSeekBar.this.isDrag = false;
                }
            });
        }
        this.mAuraHideAnimator.start();
        if (this.mThumbRecoverAnimator == null) {
            ValueAnimator valueAnimatorOfFloat2 = ValueAnimator.ofFloat(THUMB_SCALE_TARGET, 1.0f);
            this.mThumbRecoverAnimator = valueAnimatorOfFloat2;
            valueAnimatorOfFloat2.setDuration(200L);
            this.mThumbRecoverAnimator.setInterpolator(this.mThumbRecoverInterpolator);
            this.mThumbRecoverAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.stepos.common.widget.EnhanceSeekBar.7
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    EnhanceSeekBar.this.mThumbScaleValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    EnhanceSeekBar.this.invalidate();
                }
            });
            this.mThumbRecoverAnimator.addListener(new AnimatorListenerAdapter() { // from class: com.stepos.common.widget.EnhanceSeekBar.8
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                }
            });
        }
        this.mThumbRecoverAnimator.start();
    }

    private void startAuraShowAnim() {
        this.isAuraShow = true;
        if (this.mAuraShowAnimator == null) {
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.5f, 1.0f);
            this.mAuraShowAnimator = valueAnimatorOfFloat;
            valueAnimatorOfFloat.setDuration(180L);
            this.mAuraShowAnimator.setInterpolator(this.mAuraShowInterpolator);
            this.mAuraShowAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.stepos.common.widget.EnhanceSeekBar.3
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    EnhanceSeekBar.this.mAuraRadius = (int) ((r0.mAuraHeight / 2) * fFloatValue);
                    EnhanceSeekBar.this.invalidate();
                }
            });
        }
        this.mAuraShowAnimator.start();
        if (this.mThumbShrinkAnimator == null) {
            ValueAnimator valueAnimatorOfFloat2 = ValueAnimator.ofFloat(1.0f, THUMB_SCALE_TARGET);
            this.mThumbShrinkAnimator = valueAnimatorOfFloat2;
            valueAnimatorOfFloat2.setDuration(180L);
            this.mThumbShrinkAnimator.setInterpolator(this.mThumbShrinkInterpolator);
            this.mThumbShrinkAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.stepos.common.widget.EnhanceSeekBar.4
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    EnhanceSeekBar.this.mThumbScaleValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    EnhanceSeekBar.this.invalidate();
                }
            });
        }
        this.mThumbShrinkAnimator.start();
    }

    private void stopAuraHideAnim() {
        ValueAnimator valueAnimator = this.mAuraHideAnimator;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.mAuraHideAnimator.cancel();
        }
        ValueAnimator valueAnimator2 = this.mThumbRecoverAnimator;
        if (valueAnimator2 == null || !valueAnimator2.isRunning()) {
            return;
        }
        this.mThumbRecoverAnimator.cancel();
    }

    private void stopAuraShowAnim() {
        ValueAnimator valueAnimator = this.mAuraShowAnimator;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.mAuraShowAnimator.cancel();
        }
        ValueAnimator valueAnimator2 = this.mThumbShrinkAnimator;
        if (valueAnimator2 == null || !valueAnimator2.isRunning()) {
            return;
        }
        this.mThumbShrinkAnimator.cancel();
    }

    private void trackTapUpTouchEvent(MotionEvent motionEvent) {
        int iRound;
        int i10;
        int progress;
        int progress2;
        float f8;
        ValueAnimator valueAnimator = this.mDrawablePositionAnimator;
        if (valueAnimator == null || !valueAnimator.isStarted()) {
            int width = ((getWidth() - getPaddingLeft()) - getPaddingRight()) - (this.iconWidth * 2);
            float x3 = (int) motionEvent.getX();
            float f9 = 0.0f;
            if (x3 < (getPaddingLeft() + this.iconWidth) - this.iconPadding) {
                if (isRTL()) {
                    int progress3 = getProgress() + 1;
                    i10 = this.mMax;
                    if (progress3 <= i10) {
                        progress = getProgress();
                        iRound = progress + 1;
                        f8 = iRound;
                    }
                    f8 = i10;
                } else {
                    if (getProgress() - 1 >= 0) {
                        progress2 = getProgress();
                        f9 = progress2 - 1;
                    }
                    f8 = f9;
                }
            } else if (x3 <= getPaddingLeft() + this.iconWidth + width + this.iconPadding) {
                iRound = isRTL() ? Math.round((1.0f - (((x3 - getPaddingLeft()) - this.iconWidth) / width)) * this.mMax) : Math.round((((x3 - getPaddingLeft()) - this.iconWidth) / width) * this.mMax);
                f8 = iRound;
            } else if (isRTL()) {
                if (getProgress() - 1 >= 0) {
                    progress2 = getProgress();
                    f9 = progress2 - 1;
                }
                f8 = f9;
            } else {
                int progress4 = getProgress() + 1;
                i10 = this.mMax;
                if (progress4 <= i10) {
                    progress = getProgress();
                    iRound = progress + 1;
                    f8 = iRound;
                }
                f8 = i10;
            }
            setProgress((int) f8, true, true);
            setThumbPos(getWidth(), this.mThumb, f8 / this.mMax, Integer.MIN_VALUE);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x002d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void trackTouchEvent(android.view.MotionEvent r6) {
        /*
            r5 = this;
            int r0 = r5.getWidth()
            int r1 = r5.getPaddingLeft()
            int r1 = r0 - r1
            int r2 = r5.getPaddingRight()
            int r1 = r1 - r2
            int r2 = r5.iconWidth
            int r2 = r2 * 2
            int r1 = r1 - r2
            float r6 = r6.getX()
            int r6 = (int) r6
            float r2 = r5.mInitialThumbX
            float r6 = (float) r6
            float r2 = r2 + r6
            float r6 = r5.mInitialTouchX
            float r2 = r2 - r6
            int r6 = (int) r2
            r2 = 1065353216(0x3f800000, float:1.0)
            r3 = 0
            if (r6 >= 0) goto L2f
            boolean r6 = r5.isRTL()
            if (r6 == 0) goto L2d
            goto L51
        L2d:
            r2 = r3
            goto L51
        L2f:
            int r4 = r5.getPaddingRight()
            int r0 = r0 - r4
            int r4 = r5.mHalfThumbWidth
            int r4 = r4 * 2
            int r0 = r0 - r4
            if (r6 <= r0) goto L42
            boolean r6 = r5.isRTL()
            if (r6 == 0) goto L51
            goto L2d
        L42:
            boolean r0 = r5.isRTL()
            if (r0 == 0) goto L4d
            float r6 = (float) r6
            float r0 = (float) r1
            float r6 = r6 / r0
            float r2 = r2 - r6
            goto L51
        L4d:
            float r6 = (float) r6
            float r0 = (float) r1
            float r2 = r6 / r0
        L51:
            int r6 = r5.getMax()
            float r6 = (float) r6
            float r2 = r2 * r6
            float r2 = r2 + r3
            int r6 = java.lang.Math.round(r2)
            r0 = 0
            r1 = 1
            r5.setProgress(r6, r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.common.widget.EnhanceSeekBar.trackTouchEvent(android.view.MotionEvent):void");
    }

    private void updateThumbPos(int i10, int i11) {
        Drawable drawable = this.mThumb;
        int max = getMax();
        float f8 = max > 0 ? isRTL() ? 1.0f - (this.mProgress / max) : this.mProgress / max : 0.0f;
        if (drawable != null) {
            setThumbPos(i10, drawable, f8, 0);
        }
    }

    @Override // android.view.View
    public void drawableStateChanged() {
        int[] drawableState = getDrawableState();
        Drawable drawable = this.mThumb;
        if (drawable != null && drawable.isStateful()) {
            this.mThumb.setState(drawableState);
        }
        Drawable drawable2 = this.mLeftIcon;
        if (drawable2 != null && drawable2.isStateful()) {
            this.mLeftIcon.setState(drawableState);
        }
        Drawable drawable3 = this.mRightIcon;
        if (drawable3 != null && drawable3.isStateful()) {
            this.mRightIcon.setState(drawableState);
        }
        super.drawableStateChanged();
        invalidate();
    }

    public int getDistance() {
        return this.mDistance;
    }

    public synchronized int getItemsCount() {
        CharSequence[] charSequenceArr;
        try {
            charSequenceArr = this.mItems;
        } catch (Throwable th) {
            throw th;
        }
        return charSequenceArr != null ? charSequenceArr.length : this.mMax;
    }

    public synchronized int getProgress() {
        return this.mProgress;
    }

    public int getStrokeColor() {
        return this.mStrokeColor;
    }

    public int getStrokeWidth() {
        return this.mStrokeWidth;
    }

    public int getTextSize() {
        return this.mTextSize;
    }

    public Drawable getThumb() {
        return this.mThumb;
    }

    @Override // android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.mLeftIcon;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
        Drawable drawable2 = this.mRightIcon;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
        }
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.mPaintColorStateList = getResources().getColorStateList(R.color.stepos_seekbar_background_color);
        refreshDrawableState();
        refreshRes();
        invalidate();
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        AccessibilityEventSender accessibilityEventSender = this.mAccessibilityEventSender;
        if (accessibilityEventSender != null) {
            this.mAccessibilityFocused = false;
            removeCallbacks(accessibilityEventSender);
        }
    }

    @Override // android.view.View
    public synchronized void onDraw(Canvas canvas) {
        try {
            super.onDraw(canvas);
            Drawable drawable = this.mThumb;
            if (drawable != null) {
                Rect bounds = drawable.getBounds();
                canvas.save();
                if (this.mItems != null) {
                    canvas.translate(getPaddingLeft() + this.iconWidth, getPaddingTop() + this.mFontHeight + this.mHalfThumbHeight + this.mDistance);
                } else {
                    canvas.translate(getPaddingLeft() + this.iconWidth, getPaddingTop() + this.mHalfThumbHeight);
                }
                float width = ((getWidth() - getPaddingLeft()) - getPaddingRight()) - (this.iconWidth * 2);
                int max = getMax();
                float f8 = max > 0 ? width / max : 0.0f;
                this.mPaint.setStrokeWidth(this.mStrokeWidth);
                this.mPaint.setColor(this.mPaintColor);
                this.mPaint.setAntiAlias(true);
                this.mPaint.setStrokeCap(Paint.Cap.ROUND);
                canvas.drawLine(0.0f, 0.0f, width, 0.0f, this.mPaint);
                for (int i10 = 0; i10 <= max; i10++) {
                    if (isRTL()) {
                        int i11 = max - i10;
                        if (getProgress() == i11) {
                            String str = (String) this.mItems[i11];
                            canvas.drawText(str, (((getItemsCount() - 1) - this.mItemTextPosition) * f8) - (this.mTextPaint.measureText(str) / 2.0f), -(this.mHalfThumbHeight + this.mDistance), this.mTextPaint);
                        }
                    } else if (getProgress() == i10) {
                        String str2 = (String) this.mItems[i10];
                        canvas.drawText(str2, (this.mItemTextPosition * f8) - (this.mTextPaint.measureText(str2) / 2.0f), -(this.mHalfThumbHeight + this.mDistance), this.mTextPaint);
                    }
                }
                canvas.restore();
                canvas.save();
                if (this.mItems != null) {
                    canvas.translate(getPaddingLeft() + this.iconWidth, getPaddingTop() + this.mFontHeight + this.mHalfThumbHeight + this.mDistance);
                } else {
                    canvas.translate(getPaddingLeft() + this.iconWidth, getPaddingTop() + this.mHalfThumbHeight);
                }
                for (int i12 = 0; i12 <= max; i12++) {
                    this.mPaint.setColor(this.mSpotColor);
                    canvas.drawCircle(i12 * f8, 0.0f, this.mSpotRadius, this.mPaint);
                }
                canvas.restore();
                canvas.save();
                if (this.mItems != null) {
                    canvas.translate((getPaddingLeft() + this.iconWidth) - this.mHalfThumbWidth, getPaddingTop() + this.mFontHeight + this.mDistance);
                } else {
                    canvas.translate((getPaddingLeft() + this.iconWidth) - this.mHalfThumbWidth, getPaddingTop());
                }
                float f9 = this.mThumbScaleValue;
                canvas.scale(f9, f9, bounds.centerX(), bounds.centerY());
                this.mThumb.draw(canvas);
                canvas.restore();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        AccessibilityManager accessibilityManager = (AccessibilityManager) getContext().getSystemService("accessibility");
        if (accessibilityManager != null && accessibilityManager.isTouchExplorationEnabled()) {
            int action = motionEvent.getAction();
            if (action == 7) {
                motionEvent.setAction(2);
            } else if (action == 9) {
                motionEvent.setAction(0);
            } else if (action == 10) {
                motionEvent.setAction(1);
            }
            onTouchEvent(motionEvent);
            motionEvent.setAction(action);
        }
        return super.onHoverEvent(motionEvent);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(EnhanceSeekBar.class.getName());
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(EnhanceSeekBar.class.getName());
        if (isEnabled()) {
            int progress = getProgress();
            if (progress > 0) {
                accessibilityNodeInfo.addAction(PcmDumpBudget.HARD_MAX_DIR_MB);
            }
            if (progress < getMax()) {
                accessibilityNodeInfo.addAction(4096);
            }
        }
    }

    @Override // android.view.View
    public void onLayout(boolean z, int i10, int i11, int i12, int i13) {
        setIconRect();
        super.onLayout(z, i10, i11, i12, i13);
    }

    @Override // android.view.View
    public synchronized void onMeasure(int i10, int i11) {
        int iMax;
        int iMax2;
        try {
            int mode = View.MeasureSpec.getMode(i10);
            int mode2 = View.MeasureSpec.getMode(i11);
            int size = View.MeasureSpec.getSize(i10);
            int size2 = View.MeasureSpec.getSize(i11);
            if (this.mItems != null) {
                Rect rect = new Rect();
                int i12 = 0;
                int iMax3 = 0;
                while (true) {
                    CharSequence[] charSequenceArr = this.mItems;
                    if (i12 >= charSequenceArr.length) {
                        break;
                    }
                    Paint paint = this.mTextPaint;
                    CharSequence charSequence = charSequenceArr[i12];
                    paint.getTextBounds(charSequence, 0, charSequence.length(), rect);
                    iMax3 = Math.max(iMax3, rect.height());
                    i12++;
                }
                this.mFontHeight = iMax3;
            } else {
                this.mFontHeight = 0;
            }
            if (mode != 1073741824) {
                if (this.mItems != null) {
                    int i13 = 0;
                    iMax2 = 0;
                    while (true) {
                        CharSequence[] charSequenceArr2 = this.mItems;
                        if (i13 >= charSequenceArr2.length) {
                            break;
                        }
                        iMax2 = Math.max(iMax2, (int) this.mTextPaint.measureText(charSequenceArr2[i13].toString()));
                        i13++;
                    }
                } else {
                    iMax2 = 0;
                }
                iMax = Math.max(iMax2, 64) + getPaddingLeft() + getPaddingRight();
            } else {
                iMax = Math.max(size, getPaddingLeft() + 64 + getPaddingRight());
            }
            Drawable drawable = this.mAuraDrawble;
            this.mAuraHeight = drawable == null ? 0 : drawable.getIntrinsicHeight();
            if (mode2 != 1073741824) {
                Drawable drawable2 = this.mThumb;
                size2 = getPaddingTop() + getPaddingBottom() + (drawable2 == null ? 0 : drawable2.getIntrinsicHeight()) + (this.mItems != null ? this.mFontHeight + this.mDistance : 0);
            }
            setMeasuredDimension(iMax, size2);
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setProgress(savedState.progress, true, false);
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.progress = this.mProgress;
        return savedState;
    }

    @Override // android.view.View
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        updateThumbPos(i10, i11);
    }

    public void onStartTrackingTouch() {
        this.mIsDragging = true;
        OnEnhanceSeekBarChangeListener onEnhanceSeekBarChangeListener = this.mOnEnhanceSeekBarChangeListener;
        if (onEnhanceSeekBarChangeListener != null) {
            onEnhanceSeekBarChangeListener.onStartTrackingTouch(this);
        }
    }

    public void onStopTrackingTouch() {
        this.mIsDragging = false;
        OnEnhanceSeekBarChangeListener onEnhanceSeekBarChangeListener = this.mOnEnhanceSeekBarChangeListener;
        if (onEnhanceSeekBarChangeListener != null) {
            onEnhanceSeekBarChangeListener.onStopTrackingTouch(this);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!isEnabled() || getMax() == 0) {
            return false;
        }
        float x3 = motionEvent.getX();
        int action = motionEvent.getAction();
        if (action == 0) {
            this.mInitialTouchX = x3;
            this.isDrag = false;
            if (this.mThumb != null) {
                this.mInitialThumbX = r2.getBounds().left;
            }
            this.mTouchDownProgress = Math.round(((x3 - getPaddingLeft()) / (((getWidth() - getPaddingLeft()) - getPaddingRight()) - (this.iconWidth * 2))) * getMax());
            if (isPointInside((int) motionEvent.getX(), (int) motionEvent.getY())) {
                setPressed(true);
                Drawable drawable = this.mThumb;
                if (drawable != null) {
                    invalidate(drawable.getBounds());
                }
                onStartTrackingTouch();
            }
            attemptClaimDrag();
            this.hasMoved = false;
        } else if (action != 1) {
            if (action == 2) {
                ValueAnimator valueAnimator = this.mDrawablePositionAnimator;
                if (valueAnimator != null && valueAnimator.isStarted()) {
                    return true;
                }
                if (this.mIsDragging) {
                    this.mIsInItemPositon = false;
                    flingThumb(motionEvent);
                    attemptClaimDrag();
                }
                if (Math.abs(motionEvent.getX() - this.mInitialTouchX) > this.mScaledTouchSlop) {
                    this.hasMoved = true;
                    this.isDrag = true;
                    Drawable drawable2 = this.mThumb;
                    if (drawable2 != null) {
                        invalidate(drawable2.getBounds());
                    }
                } else {
                    this.hasMoved = false;
                }
            } else if (action == 3) {
                if (this.mIsDragging) {
                    onStopTrackingTouch();
                    setPressed(false);
                }
                invalidate();
            }
        } else if (this.hasMoved) {
            Drawable drawable3 = this.mThumb;
            if (drawable3 != null) {
                invalidate(drawable3.getBounds());
            }
            if (this.mIsDragging) {
                trackTouchEvent(motionEvent);
                onStopTrackingTouch();
                setPressed(false);
            } else {
                setProgress(this.mTouchDownProgress, false, true);
            }
        } else {
            trackTapUpTouchEvent(motionEvent);
            setPressed(false);
            Drawable drawable4 = this.mThumb;
            if (drawable4 != null) {
                invalidate(drawable4.getBounds());
            }
        }
        return true;
    }

    @Override // android.view.View
    public boolean performAccessibilityAction(int i10, Bundle bundle) {
        if (i10 == 64) {
            this.mAccessibilityFocused = true;
        } else if (i10 == 128) {
            this.mAccessibilityFocused = false;
        }
        if (super.performAccessibilityAction(i10, bundle)) {
            return true;
        }
        if (!isEnabled()) {
            return false;
        }
        int progress = getProgress();
        int iMax = Math.max(1, Math.round(getMax() / 5.0f));
        if (i10 == 4096) {
            if (progress >= getMax()) {
                return false;
            }
            setProgress(progress + iMax, false, false);
            return true;
        }
        if (i10 != 8192 || progress <= 0) {
            return false;
        }
        setProgress(progress - iMax, false, false);
        return true;
    }

    public void setDistance(int i10) {
        this.mDistance = i10;
    }

    public void setEnableEngine(boolean z) {
        this.mEnableEngine = z;
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        refreshRes();
        invalidate();
    }

    public void setItemPosition(int i10) {
        CharSequence[] charSequenceArr = this.mItems;
        if (charSequenceArr == null || charSequenceArr.length <= i10 || i10 < 0) {
            this.mItemTextPosition = 0;
        } else {
            this.mItemTextPosition = i10;
        }
    }

    public void setItems(CharSequence[] charSequenceArr) {
        if (charSequenceArr == null || charSequenceArr.length == 0) {
            this.mItems = null;
            setMax(0);
            return;
        }
        int length = charSequenceArr.length;
        CharSequence[] charSequenceArr2 = new CharSequence[length];
        this.mItems = charSequenceArr2;
        System.arraycopy(charSequenceArr, 0, charSequenceArr2, 0, length);
        setMax(length - 1);
    }

    public void setItemsCount(int i10) {
        CharSequence[] charSequenceArr = this.mItems;
        if (charSequenceArr != null && charSequenceArr.length < i10) {
            setMax(charSequenceArr.length - 1);
        } else if (i10 < 1) {
            setMax(0);
        } else {
            setMax(i10 - 1);
        }
    }

    public void setOnEnhanceSeekBarChangeListener(OnEnhanceSeekBarChangeListener onEnhanceSeekBarChangeListener) {
        this.mOnEnhanceSeekBarChangeListener = onEnhanceSeekBarChangeListener;
    }

    public void setPaintColor(int i10) {
        this.mPaintColor = i10;
    }

    public synchronized void setProgress(int i10) {
        setProgress(i10, false, false);
    }

    public void setStrokeColor(int i10) {
        this.mStrokeColor = i10;
    }

    public void setStrokeWidth(int i10) {
        this.mStrokeWidth = i10;
    }

    public void setTextSize(int i10) {
        if (this.mTextSize != i10) {
            this.mTextSize = i10;
            this.mTextPaint.setTextSize(i10);
            requestLayout();
            invalidate();
        }
    }

    public void setThumb(Drawable drawable) throws Resources.NotFoundException {
        boolean z;
        if (drawable == null) {
            drawable = getResources().getDrawable(R.drawable.stepos_step_seekbar_thumb);
        }
        Drawable drawable2 = this.mThumb;
        if (drawable2 == null || drawable == drawable2) {
            z = false;
        } else {
            drawable2.setCallback(null);
            this.mThumb.getIntrinsicWidth();
            z = true;
        }
        if (drawable != null) {
            drawable.setCallback(this);
            this.mThumbOffset = drawable.getIntrinsicWidth() / 2;
            if (z && (drawable.getIntrinsicWidth() != this.mThumb.getIntrinsicWidth() || drawable.getIntrinsicHeight() != this.mThumb.getIntrinsicHeight())) {
                requestLayout();
            }
            this.mHalfThumbWidth = drawable.getIntrinsicWidth() / 2;
            this.mHalfThumbHeight = drawable.getIntrinsicHeight() / 2;
        }
        this.mThumb = drawable;
        invalidate();
        if (z) {
            updateThumbPos(getWidth(), getHeight());
            if (drawable == null || !drawable.isStateful()) {
                return;
            }
            drawable.setState(getDrawableState());
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class XYHolder {
        private float mX;
        private float mY;

        public XYHolder() {
            this.mY = 0.0f;
            this.mX = 0.0f;
        }

        public float getX() {
            return this.mX;
        }

        public float getY() {
            return this.mY;
        }

        public void setX(float f8) {
            this.mX = f8;
        }

        public void setXY(float f8, float f9) {
            this.mX = f8;
            this.mY = f9;
        }

        public void setY(float f8) {
            this.mY = f8;
        }

        public XYHolder(float f8, float f9) {
            this.mX = f8;
            this.mY = f9;
        }
    }

    public EnhanceSeekBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.StepOSCommon_EnhanceSeekBarStyle);
    }

    public EnhanceSeekBar(Context context, AttributeSet attributeSet, int i10) throws Resources.NotFoundException {
        super(context, attributeSet, i10);
        this.isDrag = false;
        this.mTouchDownProgress = 0;
        this.mHalfThumbWidth = 0;
        this.mHalfThumbHeight = 0;
        this.mThumbScaleValue = 1.0f;
        this.mAuraRadius = 0;
        this.mStartXY = new XYHolder();
        this.mEndXY = new XYHolder();
        this.mXYEvaluator = new XYEvaluator();
        this.mDrawableXYHolder = new DrawableXYHolder();
        this.hasMoved = false;
        this.mAccessibilityFocused = false;
        this.isAuraShow = false;
        this.mScaledTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, g8.a.f9078d, i10, 0);
        setItems(typedArrayObtainStyledAttributes.getTextArray(2));
        setProgress(typedArrayObtainStyledAttributes.getInt(5, 0));
        setItemsCount(typedArrayObtainStyledAttributes.getInt(3, 1));
        setItemPosition(typedArrayObtainStyledAttributes.getInt(4, 1));
        Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(6);
        drawable = drawable == null ? context.getResources().getDrawable(R.drawable.stepos_step_seekbar_thumb) : drawable;
        this.mDistance = (int) typedArrayObtainStyledAttributes.getDimension(7, getResources().getDimension(R.dimen.mc_enhance_seekbar_distance));
        this.mStrokeWidth = (int) typedArrayObtainStyledAttributes.getDimension(13, getResources().getDimension(R.dimen.mc_enhance_seekbar_stroke_width));
        this.mTextSize = (int) typedArrayObtainStyledAttributes.getDimension(10, getResources().getDimensionPixelSize(R.dimen.mc_enhance_seekbar_item_text_size));
        this.mStrokeColorStateList = typedArrayObtainStyledAttributes.getColorStateList(8);
        this.mItemTextColor = typedArrayObtainStyledAttributes.getColor(9, R.attr.steposThemeColor);
        setThumb(drawable);
        this.mAuraDrawble = typedArrayObtainStyledAttributes.getDrawable(1);
        this.iconWidth = getResources().getDimensionPixelSize(R.dimen.mc_enhance_seekbar_icon_width);
        this.iconPadding = getResources().getDimensionPixelSize(R.dimen.mc_enhance_seekbar_icon_padding);
        Drawable drawable2 = typedArrayObtainStyledAttributes.getDrawable(11);
        drawable2 = drawable2 == null ? context.getDrawable(R.drawable.stepos_enhance_seekbar_ic_decrease) : drawable2;
        Drawable drawable3 = typedArrayObtainStyledAttributes.getDrawable(12);
        setLeftIcon(drawable3 == null ? context.getDrawable(R.drawable.stepos_enhance_seekbar_ic_increase) : drawable3);
        setRightIcon(drawable2);
        this.mPaintColorStateList = getResources().getColorStateList(R.color.stepos_seekbar_background_color);
        this.mSpotColorStateList = getResources().getColorStateList(R.color.stepos_enhance_seekbar_spot_color);
        this.mSpotRadius = getResources().getDimension(R.dimen.mc_enhance_seekbar_spot_radius);
        typedArrayObtainStyledAttributes.recycle();
        refreshDrawableState();
        refreshRes();
        Paint paint = new Paint();
        this.mPaint = paint;
        paint.setColor(this.mPaintColor);
        TextPaint textPaint = new TextPaint();
        this.mTextPaint = textPaint;
        textPaint.setAntiAlias(true);
        this.mTextPaint.setTextSize(this.mTextSize);
        this.mTextPaint.setColor(this.mItemTextColor);
        this.mLocationInterpolator = new PathInterpolator(0.2f, 0.31f, 0.34f, 1.0f);
        this.mAuraShowInterpolator = new PathInterpolator(0.2f, 0.43f, 0.2f, 1.0f);
        this.mAuraHideInterpolator = new PathInterpolator(0.17f, 0.0f, 0.2f, 1.0f);
        this.mThumbShrinkInterpolator = new PathInterpolator(0.2f, 0.43f, 0.2f, 1.0f);
        this.mThumbRecoverInterpolator = new PathInterpolator(0.17f, 0.0f, 0.2f, 1.0f);
        setForceDarkAllowed(false);
    }

    public synchronized void setProgress(int i10, boolean z, boolean z3) {
        if (i10 < 0) {
            i10 = 0;
        }
        try {
            int i11 = this.mMax;
            if (i10 > i11) {
                i10 = i11;
            }
            if (i10 != this.mProgress && z3 && this.mEnableEngine && l8.a.c(getContext()) && l8.a.b()) {
                performHapticFeedback(20120);
            }
            if (i10 != this.mProgress || !this.mIsInItemPositon) {
                this.mProgress = i10;
                if (!z) {
                    int i12 = this.mMax;
                    onProgressRefresh(i12 > 0 ? i10 / i12 : 0.0f);
                } else {
                    OnEnhanceSeekBarChangeListener onEnhanceSeekBarChangeListener = this.mOnEnhanceSeekBarChangeListener;
                    if (onEnhanceSeekBarChangeListener != null && this.mIsDragging) {
                        onEnhanceSeekBarChangeListener.onProgressDragging(this, getProgress());
                    }
                }
                AccessibilityManager accessibilityManager = (AccessibilityManager) getContext().getSystemService("accessibility");
                if (accessibilityManager != null && accessibilityManager.isTouchExplorationEnabled() && this.mAccessibilityFocused) {
                    scheduleAccessibilityEventSender();
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}
