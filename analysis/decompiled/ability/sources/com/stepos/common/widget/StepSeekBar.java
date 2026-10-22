package com.stepos.common.widget;

import a5.AbstractC0301a;
import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
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
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;

/* loaded from: classes3.dex */
public class StepSeekBar extends View {
    private static final int MIN_WIDTH = 64;
    private static final float SCALE_X_DEFAULT = 1.05f;
    private static final float SCALE_Y_DEFAULT = 1.05f;
    private static final String TAG = "StepSeekBar";
    private static final int TIMEOUT_SEND_ACCESSIBILITY_EVENT = 200;
    private boolean hasMoved;
    private boolean isDrag;
    private AccessibilityEventSender mAccessibilityEventSender;
    private boolean mAccessibilityFocused;
    private com.stepos.common.animator.a mAnimHelper;
    private ValueAnimator mDrawablePositionAnimator;
    private DrawableXYHolder mDrawableXYHolder;
    private boolean mEnableEngine;
    private XYHolder mEndXY;
    private int mHalfThumbHeight;
    private int mHalfThumbWidth;
    private float mInitialThumbX;
    private float mInitialTouchX;
    private boolean mIsDragging;
    private boolean mIsInItemPositon;
    private Interpolator mLocationInterpolator;
    private int mMax;
    private OnStepSeekBarChangeListener mOnStepSeekBarChangeListener;
    private Paint mPaint;
    private int mPaintColor;
    private ColorStateList mPaintColorStateList;
    private int mProgress;
    private int mScaledTouchSlop;
    private int mSpotColor;
    private ColorStateList mSpotColorStateList;
    private float mSpotPadding;
    private float mSpotRadius;
    private XYHolder mStartXY;
    private int mStrokeColor;
    private ColorStateList mStrokeColorStateList;
    private int mStrokeWidth;
    private Drawable mThumb;
    private float mThumbScaleValue;
    private int mTouchDownProgress;
    private XYEvaluator mXYEvaluator;

    public class AccessibilityEventSender implements Runnable {
        private AccessibilityEventSender() {
        }

        @Override // java.lang.Runnable
        public void run() {
            StepSeekBar.this.sendAccessibilityEvent(4);
        }
    }

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
            return StepSeekBar.this.new XYHolder(bounds.left, bounds.top);
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
            StepSeekBar.this.invalidate();
        }

        public DrawableXYHolder(Drawable drawable) {
            this.mDrawable = drawable;
        }
    }

    public interface OnStepSeekBarChangeListener {
        void onProgressChanged(StepSeekBar stepSeekBar, int i);

        void onProgressDragging(StepSeekBar stepSeekBar, int i);

        void onStartTrackingTouch(StepSeekBar stepSeekBar);

        void onStopTrackingTouch(StepSeekBar stepSeekBar);
    }

    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.stepos.common.widget.StepSeekBar.SavedState.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        int progress;

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
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

    public class XYEvaluator implements TypeEvaluator {
        private XYEvaluator() {
        }

        @Override // android.animation.TypeEvaluator
        public Object evaluate(float f, Object obj, Object obj2) {
            XYHolder xYHolder = (XYHolder) obj;
            XYHolder xYHolder2 = (XYHolder) obj2;
            return StepSeekBar.this.new XYHolder(B7.a.b(xYHolder2.getX(), xYHolder.getX(), f, xYHolder.getX()), B7.a.b(xYHolder2.getY(), xYHolder.getY(), f, xYHolder.getY()));
        }
    }

    public StepSeekBar(Context context) {
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
            getWidth();
            int progressAvailableWidth = getProgressAvailableWidth();
            int x10 = (int) motionEvent.getX();
            Rect bounds = this.mThumb.getBounds();
            int i = (int) ((this.mInitialThumbX + x10) - this.mInitialTouchX);
            if (i < 0) {
                i = 0;
            } else if (i > progressAvailableWidth) {
                i = progressAvailableWidth;
            }
            int iRound = isRTL() ? Math.round((1.0f - (i / progressAvailableWidth)) * getMax()) : Math.round((i / progressAvailableWidth) * getMax());
            setProgress(iRound, true, true);
            int max = isRTL() ? (int) ((1.0f - (iRound / getMax())) * progressAvailableWidth) : (progressAvailableWidth * iRound) / getMax();
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
        return colorStateList.getColorForState(new int[]{R.attr.state_enabled}, 0);
    }

    private int getProgressAvailableWidth() {
        return ((getWidth() - getPaddingLeft()) - getPaddingRight()) - this.mStrokeWidth;
    }

    public static String getTAG() {
        return TAG;
    }

    private int getTouchWidth() {
        return (getWidth() - getPaddingLeft()) - getPaddingRight();
    }

    private boolean isPointInside(int i, int i6) {
        return true;
    }

    private boolean isRTL() {
        return getContext().getResources().getConfiguration().getLayoutDirection() == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyProgressChanged() {
        OnStepSeekBarChangeListener onStepSeekBarChangeListener = this.mOnStepSeekBarChangeListener;
        if (onStepSeekBarChangeListener != null) {
            onStepSeekBarChangeListener.onProgressChanged(this, getProgress());
        }
    }

    private void onProgressRefresh(float f) {
        Drawable drawable = this.mThumb;
        if (drawable != null) {
            setThumbPos(getWidth(), drawable, f, Integer.MIN_VALUE);
        }
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

    private synchronized void setMax(int i) {
        if (i < 0) {
            i = 0;
        }
        try {
            if (i != this.mMax) {
                this.mMax = i;
                if (this.mProgress > i) {
                    this.mProgress = i;
                }
                onProgressRefresh(i > 0 ? this.mProgress / i : 0.0f);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    private void setThumbPos(int i, Drawable drawable, float f, int i6) {
        int iRound;
        int i10;
        int intrinsicHeight;
        int i11;
        boolean z10;
        int paddingLeft = ((i - getPaddingLeft()) - getPaddingRight()) - this.mStrokeWidth;
        int intrinsicWidth = drawable.getIntrinsicWidth();
        if (isRTL()) {
            iRound = paddingLeft - Math.round(f * paddingLeft);
            i10 = paddingLeft - iRound;
        } else {
            iRound = paddingLeft - Math.round((1.0f - f) * paddingLeft);
            i10 = iRound;
        }
        int i12 = intrinsicWidth + i10;
        boolean z11 = false;
        if (i6 == Integer.MIN_VALUE) {
            Rect bounds = drawable.getBounds();
            i11 = bounds.top;
            intrinsicHeight = bounds.bottom;
            z10 = true;
        } else {
            intrinsicHeight = drawable.getIntrinsicHeight() + i6;
            i11 = i6;
            z10 = false;
        }
        ValueAnimator valueAnimator = this.mDrawablePositionAnimator;
        if (valueAnimator == null) {
            z11 = z10;
        } else {
            if (!z10) {
                valueAnimator.cancel();
                this.mDrawablePositionAnimator = null;
            } else if (!valueAnimator.isStarted()) {
            }
            z11 = z10;
        }
        if (z11) {
            int i13 = drawable.getBounds().left;
            if (i13 == iRound) {
                this.mIsInItemPositon = true;
                if (i6 == Integer.MIN_VALUE) {
                    notifyProgressChanged();
                    return;
                }
                return;
            }
            float f7 = i11;
            this.mStartXY.setXY(i13, f7);
            this.mEndXY.setXY(iRound, f7);
            this.mDrawableXYHolder.setDrawable(drawable);
            this.mDrawablePositionAnimator = ValueAnimator.ofObject(this.mXYEvaluator, this.mStartXY, this.mEndXY);
            this.mDrawablePositionAnimator.setDuration((int) (Math.abs(this.mEndXY.getX() - this.mStartXY.getX()) * 0.44444445f));
            this.mDrawablePositionAnimator.setInterpolator(this.mLocationInterpolator);
            this.mDrawablePositionAnimator.addListener(new AnimatorListenerAdapter() { // from class: com.stepos.common.widget.StepSeekBar.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    StepSeekBar.this.notifyProgressChanged();
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    StepSeekBar.this.notifyProgressChanged();
                }
            });
            this.mDrawablePositionAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.stepos.common.widget.StepSeekBar.2
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator2) {
                    StepSeekBar.this.mDrawableXYHolder.setXY((XYHolder) valueAnimator2.getAnimatedValue());
                }
            });
            this.mDrawablePositionAnimator.start();
        } else {
            this.mThumb.setBounds(i10, i11, i12, intrinsicHeight);
            invalidate();
        }
        this.mIsInItemPositon = true;
    }

    private void trackTapUpTouchEvent(MotionEvent motionEvent) {
        int iRound;
        int i;
        int progress;
        int progress2;
        float f;
        ValueAnimator valueAnimator = this.mDrawablePositionAnimator;
        if (valueAnimator == null || !valueAnimator.isStarted()) {
            getWidth();
            int touchWidth = getTouchWidth();
            float x10 = (int) motionEvent.getX();
            float f7 = 0.0f;
            if (x10 < getPaddingLeft()) {
                if (isRTL()) {
                    int progress3 = getProgress() + 1;
                    i = this.mMax;
                    if (progress3 <= i) {
                        progress = getProgress();
                        iRound = progress + 1;
                        f = iRound;
                    }
                    f = i;
                } else {
                    if (getProgress() - 1 >= 0) {
                        progress2 = getProgress();
                        f7 = progress2 - 1;
                    }
                    f = f7;
                }
            } else if (x10 <= getPaddingLeft() + touchWidth) {
                iRound = isRTL() ? Math.round((1.0f - ((x10 - getPaddingLeft()) / touchWidth)) * this.mMax) : Math.round(((x10 - getPaddingLeft()) / touchWidth) * this.mMax);
                f = iRound;
            } else if (isRTL()) {
                if (getProgress() - 1 >= 0) {
                    progress2 = getProgress();
                    f7 = progress2 - 1;
                }
                f = f7;
            } else {
                int progress4 = getProgress() + 1;
                i = this.mMax;
                if (progress4 <= i) {
                    progress = getProgress();
                    iRound = progress + 1;
                    f = iRound;
                }
                f = i;
            }
            setProgress((int) f, true, true);
            setThumbPos(getWidth(), this.mThumb, f / this.mMax, Integer.MIN_VALUE);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void trackTouchEvent(android.view.MotionEvent r6) {
        /*
            r5 = this;
            int r0 = r5.getWidth()
            int r1 = r5.getProgressAvailableWidth()
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
            if (r6 >= 0) goto L23
            boolean r6 = r5.isRTL()
            if (r6 == 0) goto L21
            goto L45
        L21:
            r2 = r3
            goto L45
        L23:
            int r4 = r5.getPaddingRight()
            int r0 = r0 - r4
            int r4 = r5.mHalfThumbWidth
            int r4 = r4 * 2
            int r0 = r0 - r4
            if (r6 <= r0) goto L36
            boolean r6 = r5.isRTL()
            if (r6 == 0) goto L45
            goto L21
        L36:
            boolean r0 = r5.isRTL()
            if (r0 == 0) goto L41
            float r6 = (float) r6
            float r0 = (float) r1
            float r6 = r6 / r0
            float r2 = r2 - r6
            goto L45
        L41:
            float r6 = (float) r6
            float r0 = (float) r1
            float r2 = r6 / r0
        L45:
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
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.common.widget.StepSeekBar.trackTouchEvent(android.view.MotionEvent):void");
    }

    private void updateThumbPos(int i, int i6) {
        Drawable drawable = this.mThumb;
        int max = getMax();
        float f = max > 0 ? isRTL() ? 1.0f - (this.mProgress / max) : this.mProgress / max : 0.0f;
        if (drawable != null) {
            setThumbPos(i, drawable, f, 0);
        }
    }

    @Override // android.view.View
    public void drawableStateChanged() {
        int[] drawableState = getDrawableState();
        Drawable drawable = this.mThumb;
        if (drawable != null && drawable.isStateful()) {
            this.mThumb.setState(drawableState);
        }
        super.drawableStateChanged();
        invalidate();
    }

    @Override // android.view.View
    public CharSequence getAccessibilityClassName() {
        return StepSeekBar.class.getName();
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

    public Drawable getThumb() {
        return this.mThumb;
    }

    @Override // android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.mPaintColorStateList = getResources().getColorStateList(com.stepos.ability.R.color.stepos_seekbar_background_state_color);
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
            if (this.mThumb != null) {
                getMeasuredHeight();
                Rect bounds = this.mThumb.getBounds();
                canvas.save();
                canvas.translate(getPaddingLeft(), getPaddingTop() + (this.mStrokeWidth / 2));
                float progressAvailableWidth = getProgressAvailableWidth();
                this.mPaint.setStrokeWidth(this.mStrokeWidth);
                this.mPaint.setColor(this.mPaintColor);
                this.mPaint.setAntiAlias(true);
                this.mPaint.setStrokeCap(Paint.Cap.ROUND);
                int i = this.mStrokeWidth;
                canvas.drawLine(i / 2, 0.0f, progressAvailableWidth + (i / 2), 0.0f, this.mPaint);
                canvas.restore();
                canvas.save();
                int max = getMax();
                float f = max > 0 ? progressAvailableWidth / max : 0.0f;
                canvas.translate(getPaddingLeft() + this.mSpotPadding, getPaddingTop() + (this.mStrokeWidth / 2));
                for (int i6 = 0; i6 <= max; i6++) {
                    this.mPaint.setColor(this.mSpotColor);
                    float f7 = this.mSpotRadius;
                    canvas.drawCircle((i6 * f) + f7, 0.0f, f7, this.mPaint);
                }
                canvas.restore();
                canvas.save();
                canvas.translate(((this.mSpotPadding + this.mSpotRadius) - this.mHalfThumbWidth) + getPaddingLeft(), ((this.mStrokeWidth / 2) - this.mHalfThumbHeight) + getPaddingTop());
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
            motionEvent.setAction(action);
        }
        return super.onHoverEvent(motionEvent);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(StepSeekBar.class.getName());
        accessibilityEvent.setItemCount(this.mMax);
        accessibilityEvent.setCurrentItemIndex(this.mProgress);
    }

    @Override // android.view.View
    @RequiresApi(api = 19)
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(StepSeekBar.class.getName());
        if (isEnabled()) {
            int progress = getProgress();
            accessibilityNodeInfo.setRangeInfo(AccessibilityNodeInfo.RangeInfo.obtain(0, 0.0f, getMax(), progress));
            accessibilityNodeInfo.addAction(AccessibilityNodeInfo.AccessibilityAction.ACTION_SET_PROGRESS);
            if (progress > 0) {
                accessibilityNodeInfo.addAction(8192);
            }
            if (progress < getMax()) {
                accessibilityNodeInfo.addAction(4096);
            }
        }
    }

    @Override // android.view.View
    public synchronized void onMeasure(int i, int i6) {
        try {
            Drawable drawable = this.mThumb;
            int intrinsicHeight = drawable == null ? 0 : drawable.getIntrinsicHeight();
            int minimumHeight = getMinimumHeight();
            int paddingLeft = getPaddingLeft() + 64 + getPaddingRight();
            if (intrinsicHeight != 0) {
                minimumHeight = Math.max(intrinsicHeight, minimumHeight);
            }
            setMeasuredDimension(View.resolveSizeAndState(Math.max(paddingLeft, View.MeasureSpec.getSize(i)), i, 0), View.resolveSizeAndState(getPaddingTop() + getPaddingBottom() + minimumHeight, i6, 0));
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
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
    public void onSizeChanged(int i, int i6, int i10, int i11) {
        updateThumbPos(i, i6);
    }

    public void onStartTrackingTouch() {
        this.mIsDragging = true;
        OnStepSeekBarChangeListener onStepSeekBarChangeListener = this.mOnStepSeekBarChangeListener;
        if (onStepSeekBarChangeListener != null) {
            onStepSeekBarChangeListener.onStartTrackingTouch(this);
        }
    }

    public void onStopTrackingTouch() {
        this.mIsDragging = false;
        OnStepSeekBarChangeListener onStepSeekBarChangeListener = this.mOnStepSeekBarChangeListener;
        if (onStepSeekBarChangeListener != null) {
            onStepSeekBarChangeListener.onStopTrackingTouch(this);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!isEnabled() || getMax() == 0) {
            return false;
        }
        float x10 = motionEvent.getX();
        int action = motionEvent.getAction();
        if (action == 0) {
            this.isDrag = false;
            this.mTouchDownProgress = Math.round(((x10 - getPaddingLeft()) / getProgressAvailableWidth()) * getMax());
            trackTapUpTouchEvent(motionEvent);
            if (isPointInside((int) motionEvent.getX(), (int) motionEvent.getY())) {
                setPressed(true);
                Drawable drawable = this.mThumb;
                if (drawable != null) {
                    invalidate(drawable.getBounds());
                }
                onStartTrackingTouch();
            }
            Drawable drawable2 = this.mThumb;
            if (drawable2 != null) {
                float f = drawable2.getBounds().left;
                this.mInitialThumbX = f;
                this.mInitialTouchX = f;
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
                    Drawable drawable3 = this.mThumb;
                    if (drawable3 != null) {
                        invalidate(drawable3.getBounds());
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
            Drawable drawable4 = this.mThumb;
            if (drawable4 != null) {
                invalidate(drawable4.getBounds());
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
            Drawable drawable5 = this.mThumb;
            if (drawable5 != null) {
                invalidate(drawable5.getBounds());
            }
        }
        com.stepos.common.animator.a aVar = this.mAnimHelper;
        if (aVar != null && aVar.f) {
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked == 0) {
                aVar.a(true);
            } else if (actionMasked == 1 || actionMasked == 3) {
                aVar.a(false);
            }
        }
        return true;
    }

    @Override // android.view.View
    public boolean performAccessibilityAction(int i, Bundle bundle) {
        if (i == 64) {
            this.mAccessibilityFocused = true;
        } else if (i == 128) {
            this.mAccessibilityFocused = false;
        }
        if (super.performAccessibilityAction(i, bundle)) {
            return true;
        }
        if (!isEnabled()) {
            return false;
        }
        int progress = getProgress();
        if (i == 4096) {
            if (progress >= getMax()) {
                return false;
            }
            setProgress(progress + 1, false, false);
            return true;
        }
        if (i == 8192) {
            if (progress <= 0) {
                return false;
            }
            setProgress(progress - 1, false, false);
            return true;
        }
        if (i != 16908349 || !isEnabled() || bundle == null || !bundle.containsKey(AccessibilityNodeInfoCompat.ACTION_ARGUMENT_PROGRESS_VALUE)) {
            return false;
        }
        setProgress((int) bundle.getFloat(AccessibilityNodeInfoCompat.ACTION_ARGUMENT_PROGRESS_VALUE), true, true);
        return true;
    }

    public void setEnableEngine(boolean z10) {
        this.mEnableEngine = z10;
    }

    @Override // android.view.View
    public void setEnabled(boolean z10) {
        super.setEnabled(z10);
        refreshRes();
        invalidate();
    }

    public void setItemsCount(int i) {
        if (i < 1) {
            setMax(0);
        } else {
            setMax(i - 1);
        }
    }

    public void setOnStepSeekBarChangeListener(OnStepSeekBarChangeListener onStepSeekBarChangeListener) {
        this.mOnStepSeekBarChangeListener = onStepSeekBarChangeListener;
    }

    public void setPaintColor(int i) {
        this.mPaintColor = i;
    }

    public synchronized void setProgress(int i) {
        setProgress(i, false, false);
    }

    public void setStrokeColor(int i) {
        this.mStrokeColor = i;
    }

    public void setStrokeWidth(int i) {
        this.mStrokeWidth = i;
    }

    public final void setThumb(Drawable drawable) throws Resources.NotFoundException {
        boolean z10;
        if (drawable == null) {
            drawable = getResources().getDrawable(com.stepos.ability.R.drawable.stepos_step_seekbar_thumb);
        }
        Drawable drawable2 = this.mThumb;
        if (drawable2 == null || drawable == drawable2) {
            z10 = false;
        } else {
            drawable2.setCallback(null);
            this.mThumb.getIntrinsicWidth();
            z10 = true;
        }
        if (drawable != null) {
            drawable.setCallback(this);
            if (z10 && (drawable.getIntrinsicWidth() != this.mThumb.getIntrinsicWidth() || drawable.getIntrinsicHeight() != this.mThumb.getIntrinsicHeight())) {
                requestLayout();
            }
            this.mHalfThumbWidth = drawable.getIntrinsicWidth() / 2;
            this.mHalfThumbHeight = drawable.getIntrinsicHeight() / 2;
        }
        this.mThumb = drawable;
        invalidate();
        if (z10) {
            updateThumbPos(getWidth(), getHeight());
            if (drawable == null || !drawable.isStateful()) {
                return;
            }
            drawable.setState(getDrawableState());
        }
    }

    public void setTouchScaleEnable(boolean z10) {
        com.stepos.common.animator.a aVar = this.mAnimHelper;
        if (aVar != null) {
            aVar.f = z10;
        }
    }

    public void setTouchScaleRatio(float f, float f7) {
        com.stepos.common.animator.a aVar = this.mAnimHelper;
        if (aVar != null) {
            aVar.d = f;
            aVar.e = f7;
        }
    }

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

        public void setX(float f) {
            this.mX = f;
        }

        public void setXY(float f, float f7) {
            this.mX = f;
            this.mY = f7;
        }

        public void setY(float f) {
            this.mY = f;
        }

        public XYHolder(float f, float f7) {
            this.mX = f;
            this.mY = f7;
        }
    }

    public StepSeekBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, com.stepos.ability.R.attr.StepOSCommon_StepSeekBarStyle);
    }

    public StepSeekBar(Context context, AttributeSet attributeSet, int i) throws Resources.NotFoundException {
        super(context, attributeSet, i);
        this.isDrag = false;
        this.mTouchDownProgress = 0;
        this.mHalfThumbWidth = 0;
        this.mHalfThumbHeight = 0;
        this.mThumbScaleValue = 1.0f;
        this.mStartXY = new XYHolder();
        this.mEndXY = new XYHolder();
        this.mXYEvaluator = new XYEvaluator();
        this.mDrawableXYHolder = new DrawableXYHolder();
        this.hasMoved = false;
        this.mAccessibilityFocused = false;
        this.mEnableEngine = true;
        this.mScaledTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, V4.s.f1376t, i, com.stepos.ability.R.style.Widget_StepOSCommon_StepSeekBar);
        setItemsCount(typedArrayObtainStyledAttributes.getInt(0, 1));
        setProgress(typedArrayObtainStyledAttributes.getInt(1, 0));
        Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(4);
        drawable = drawable == null ? context.getResources().getDrawable(com.stepos.ability.R.drawable.stepos_step_seekbar_thumb) : drawable;
        this.mStrokeWidth = (int) typedArrayObtainStyledAttributes.getDimension(3, getResources().getDimension(com.stepos.ability.R.dimen.mc_enhance_seekbar_stroke_width));
        this.mStrokeColorStateList = typedArrayObtainStyledAttributes.getColorStateList(2);
        setThumb(drawable);
        this.mPaintColorStateList = getResources().getColorStateList(com.stepos.ability.R.color.stepos_seekbar_background_state_color);
        this.mSpotColorStateList = getResources().getColorStateList(com.stepos.ability.R.color.stepos_enhance_seekbar_spot_color);
        this.mSpotRadius = getResources().getDimension(com.stepos.ability.R.dimen.mc_enhance_seekbar_spot_radius);
        this.mSpotPadding = typedArrayObtainStyledAttributes.getDimensionPixelOffset(5, 0);
        typedArrayObtainStyledAttributes.recycle();
        refreshDrawableState();
        refreshRes();
        Paint paint = new Paint();
        this.mPaint = paint;
        paint.setColor(this.mPaintColor);
        this.mLocationInterpolator = new PathInterpolator(0.2f, 0.31f, 0.34f, 1.0f);
        if (getImportantForAccessibility() == 0) {
            setImportantForAccessibility(1);
        }
        setForceDarkAllowed(false);
        com.stepos.common.animator.a aVar = new com.stepos.common.animator.a();
        aVar.f = true;
        aVar.c = this;
        this.mAnimHelper = aVar;
        aVar.d = 1.05f;
        aVar.e = 1.05f;
    }

    public synchronized void setProgress(int i, boolean z10, boolean z11) {
        if (i < 0) {
            i = 0;
        }
        try {
            int i6 = this.mMax;
            if (i > i6) {
                i = i6;
            }
            if (i != this.mProgress && z11 && this.mEnableEngine) {
                if (AbstractC0301a.b()) {
                    performHapticFeedback(31015);
                } else {
                    performHapticFeedback(26);
                }
            }
            if (i != this.mProgress || !this.mIsInItemPositon) {
                this.mProgress = i;
                if (!z10) {
                    int i10 = this.mMax;
                    onProgressRefresh(i10 > 0 ? i / i10 : 0.0f);
                } else {
                    OnStepSeekBarChangeListener onStepSeekBarChangeListener = this.mOnStepSeekBarChangeListener;
                    if (onStepSeekBarChangeListener != null && this.mIsDragging) {
                        onStepSeekBarChangeListener.onProgressDragging(this, getProgress());
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
