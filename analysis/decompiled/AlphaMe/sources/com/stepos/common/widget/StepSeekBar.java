package com.stepos.common.widget;

import android.R;
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
import androidx.annotation.RequiresApi;
import com.stepos.alphame.utils.Property;
import i2.AbstractC0620a;
import m2.AbstractC0770a;
import s.AbstractC0831a;

/* loaded from: classes.dex */
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
        void onProgressChanged(StepSeekBar stepSeekBar, int i4);

        void onProgressDragging(StepSeekBar stepSeekBar, int i4);

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
            public SavedState[] newArray(int i4) {
                return new SavedState[i4];
            }
        };
        int progress;

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i4) {
            super.writeToParcel(parcel, i4);
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
        public Object evaluate(float f4, Object obj, Object obj2) {
            XYHolder xYHolder = (XYHolder) obj;
            XYHolder xYHolder2 = (XYHolder) obj2;
            return StepSeekBar.this.new XYHolder(AbstractC0831a.c(xYHolder2.getX(), xYHolder.getX(), f4, xYHolder.getX()), AbstractC0831a.c(xYHolder2.getY(), xYHolder.getY(), f4, xYHolder.getY()));
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
            int x4 = (int) motionEvent.getX();
            Rect bounds = this.mThumb.getBounds();
            int i4 = (int) ((this.mInitialThumbX + x4) - this.mInitialTouchX);
            if (i4 < 0) {
                i4 = 0;
            } else if (i4 > progressAvailableWidth) {
                i4 = progressAvailableWidth;
            }
            int iRound = isRTL() ? Math.round((1.0f - (i4 / progressAvailableWidth)) * getMax()) : Math.round((i4 / progressAvailableWidth) * getMax());
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

    private boolean isPointInside(int i4, int i5) {
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

    private void onProgressRefresh(float f4) {
        Drawable drawable = this.mThumb;
        if (drawable != null) {
            setThumbPos(getWidth(), drawable, f4, Integer.MIN_VALUE);
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

    private synchronized void setMax(int i4) {
        if (i4 < 0) {
            i4 = 0;
        }
        try {
            if (i4 != this.mMax) {
                this.mMax = i4;
                if (this.mProgress > i4) {
                    this.mProgress = i4;
                }
                onProgressRefresh(i4 > 0 ? this.mProgress / i4 : Property.DEFAULT_FLOAT_VALUE);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00ca  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void setThumbPos(int r8, android.graphics.drawable.Drawable r9, float r10, int r11) {
        /*
            r7 = this;
            int r0 = r7.getPaddingLeft()
            int r8 = r8 - r0
            int r0 = r7.getPaddingRight()
            int r8 = r8 - r0
            int r0 = r7.mStrokeWidth
            int r8 = r8 - r0
            int r0 = r9.getIntrinsicWidth()
            boolean r1 = r7.isRTL()
            if (r1 == 0) goto L21
            float r1 = (float) r8
            float r10 = r10 * r1
            int r10 = java.lang.Math.round(r10)
            int r10 = r8 - r10
            int r8 = r8 - r10
            goto L2d
        L21:
            r1 = 1065353216(0x3f800000, float:1.0)
            float r1 = r1 - r10
            float r10 = (float) r8
            float r1 = r1 * r10
            int r10 = java.lang.Math.round(r1)
            int r10 = r8 - r10
            r8 = r10
        L2d:
            int r0 = r0 + r8
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = 1
            if (r11 != r1) goto L3e
            android.graphics.Rect r3 = r9.getBounds()
            int r4 = r3.top
            int r3 = r3.bottom
            r5 = r4
            r4 = r2
            goto L45
        L3e:
            int r3 = r9.getIntrinsicHeight()
            int r3 = r3 + r11
            r4 = 0
            r5 = r11
        L45:
            android.animation.ValueAnimator r6 = r7.mDrawablePositionAnimator
            if (r6 == 0) goto L59
            if (r4 != 0) goto L52
            r6.cancel()
            r6 = 0
            r7.mDrawablePositionAnimator = r6
            goto L59
        L52:
            boolean r6 = r6.isStarted()
            if (r6 == 0) goto L59
            goto Lca
        L59:
            if (r4 == 0) goto Lca
            android.graphics.Rect r8 = r9.getBounds()
            int r8 = r8.left
            if (r8 != r10) goto L6b
            r7.mIsInItemPositon = r2
            if (r11 != r1) goto L6a
            r7.notifyProgressChanged()
        L6a:
            return
        L6b:
            com.stepos.common.widget.StepSeekBar$XYHolder r11 = r7.mStartXY
            float r8 = (float) r8
            float r0 = (float) r5
            r11.setXY(r8, r0)
            com.stepos.common.widget.StepSeekBar$XYHolder r8 = r7.mEndXY
            float r10 = (float) r10
            r8.setXY(r10, r0)
            com.stepos.common.widget.StepSeekBar$DrawableXYHolder r8 = r7.mDrawableXYHolder
            r8.setDrawable(r9)
            com.stepos.common.widget.StepSeekBar$XYEvaluator r8 = r7.mXYEvaluator
            com.stepos.common.widget.StepSeekBar$XYHolder r9 = r7.mStartXY
            com.stepos.common.widget.StepSeekBar$XYHolder r10 = r7.mEndXY
            java.lang.Object[] r9 = new java.lang.Object[]{r9, r10}
            android.animation.ValueAnimator r8 = android.animation.ValueAnimator.ofObject(r8, r9)
            r7.mDrawablePositionAnimator = r8
            com.stepos.common.widget.StepSeekBar$XYHolder r8 = r7.mEndXY
            float r8 = r8.getX()
            com.stepos.common.widget.StepSeekBar$XYHolder r9 = r7.mStartXY
            float r9 = r9.getX()
            float r8 = r8 - r9
            float r8 = java.lang.Math.abs(r8)
            r9 = 1055100473(0x3ee38e39, float:0.44444445)
            float r8 = r8 * r9
            int r8 = (int) r8
            android.animation.ValueAnimator r9 = r7.mDrawablePositionAnimator
            long r10 = (long) r8
            r9.setDuration(r10)
            android.animation.ValueAnimator r8 = r7.mDrawablePositionAnimator
            android.view.animation.Interpolator r9 = r7.mLocationInterpolator
            r8.setInterpolator(r9)
            android.animation.ValueAnimator r8 = r7.mDrawablePositionAnimator
            com.stepos.common.widget.StepSeekBar$1 r9 = new com.stepos.common.widget.StepSeekBar$1
            r9.<init>()
            r8.addListener(r9)
            android.animation.ValueAnimator r8 = r7.mDrawablePositionAnimator
            com.stepos.common.widget.StepSeekBar$2 r9 = new com.stepos.common.widget.StepSeekBar$2
            r9.<init>()
            r8.addUpdateListener(r9)
            android.animation.ValueAnimator r8 = r7.mDrawablePositionAnimator
            r8.start()
            goto Ld2
        Lca:
            android.graphics.drawable.Drawable r9 = r7.mThumb
            r9.setBounds(r8, r5, r0, r3)
            r7.invalidate()
        Ld2:
            r7.mIsInItemPositon = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.common.widget.StepSeekBar.setThumbPos(int, android.graphics.drawable.Drawable, float, int):void");
    }

    private void trackTapUpTouchEvent(MotionEvent motionEvent) {
        int iRound;
        int i4;
        int progress;
        int progress2;
        float f4;
        ValueAnimator valueAnimator = this.mDrawablePositionAnimator;
        if (valueAnimator == null || !valueAnimator.isStarted()) {
            getWidth();
            int touchWidth = getTouchWidth();
            float x4 = (int) motionEvent.getX();
            float paddingLeft = getPaddingLeft();
            float f5 = Property.DEFAULT_FLOAT_VALUE;
            if (x4 < paddingLeft) {
                if (isRTL()) {
                    int progress3 = getProgress() + 1;
                    i4 = this.mMax;
                    if (progress3 <= i4) {
                        progress = getProgress();
                        iRound = progress + 1;
                        f4 = iRound;
                    }
                    f4 = i4;
                } else {
                    if (getProgress() - 1 >= 0) {
                        progress2 = getProgress();
                        f5 = progress2 - 1;
                    }
                    f4 = f5;
                }
            } else if (x4 <= getPaddingLeft() + touchWidth) {
                iRound = isRTL() ? Math.round((1.0f - ((x4 - getPaddingLeft()) / touchWidth)) * this.mMax) : Math.round(((x4 - getPaddingLeft()) / touchWidth) * this.mMax);
                f4 = iRound;
            } else if (isRTL()) {
                if (getProgress() - 1 >= 0) {
                    progress2 = getProgress();
                    f5 = progress2 - 1;
                }
                f4 = f5;
            } else {
                int progress4 = getProgress() + 1;
                i4 = this.mMax;
                if (progress4 <= i4) {
                    progress = getProgress();
                    iRound = progress + 1;
                    f4 = iRound;
                }
                f4 = i4;
            }
            setProgress((int) f4, true, true);
            setThumbPos(getWidth(), this.mThumb, f4 / this.mMax, Integer.MIN_VALUE);
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

    private void updateThumbPos(int i4, int i5) {
        Drawable drawable = this.mThumb;
        int max = getMax();
        float f4 = max > 0 ? isRTL() ? 1.0f - (this.mProgress / max) : this.mProgress / max : Property.DEFAULT_FLOAT_VALUE;
        if (drawable != null) {
            setThumbPos(i4, drawable, f4, 0);
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
        this.mPaintColorStateList = getResources().getColorStateList(com.stepos.alphame.R.color.stepos_seekbar_background_state_color);
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
                int i4 = this.mStrokeWidth;
                canvas.drawLine(i4 / 2, Property.DEFAULT_FLOAT_VALUE, progressAvailableWidth + (i4 / 2), Property.DEFAULT_FLOAT_VALUE, this.mPaint);
                canvas.restore();
                canvas.save();
                int max = getMax();
                float f4 = max > 0 ? progressAvailableWidth / max : 0.0f;
                canvas.translate(getPaddingLeft() + this.mSpotPadding, getPaddingTop() + (this.mStrokeWidth / 2));
                for (int i5 = 0; i5 <= max; i5++) {
                    this.mPaint.setColor(this.mSpotColor);
                    float f5 = this.mSpotRadius;
                    canvas.drawCircle((i5 * f4) + f5, Property.DEFAULT_FLOAT_VALUE, f5, this.mPaint);
                }
                canvas.restore();
                canvas.save();
                canvas.translate(((this.mSpotPadding + this.mSpotRadius) - this.mHalfThumbWidth) + getPaddingLeft(), ((this.mStrokeWidth / 2) - this.mHalfThumbHeight) + getPaddingTop());
                float f6 = this.mThumbScaleValue;
                canvas.scale(f6, f6, bounds.centerX(), bounds.centerY());
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
            accessibilityNodeInfo.setRangeInfo(AccessibilityNodeInfo.RangeInfo.obtain(0, Property.DEFAULT_FLOAT_VALUE, getMax(), progress));
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
    public synchronized void onMeasure(int i4, int i5) {
        try {
            Drawable drawable = this.mThumb;
            int intrinsicHeight = drawable == null ? 0 : drawable.getIntrinsicHeight();
            int minimumHeight = getMinimumHeight();
            int paddingLeft = getPaddingLeft() + 64 + getPaddingRight();
            if (intrinsicHeight != 0) {
                minimumHeight = Math.max(intrinsicHeight, minimumHeight);
            }
            setMeasuredDimension(View.resolveSizeAndState(Math.max(paddingLeft, View.MeasureSpec.getSize(i4)), i4, 0), View.resolveSizeAndState(getPaddingTop() + getPaddingBottom() + minimumHeight, i5, 0));
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
    public void onSizeChanged(int i4, int i5, int i6, int i7) {
        updateThumbPos(i4, i5);
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
        float x4 = motionEvent.getX();
        int action = motionEvent.getAction();
        if (action == 0) {
            this.isDrag = false;
            this.mTouchDownProgress = Math.round(((x4 - getPaddingLeft()) / getProgressAvailableWidth()) * getMax());
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
                float f4 = drawable2.getBounds().left;
                this.mInitialThumbX = f4;
                this.mInitialTouchX = f4;
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
        if (aVar != null && aVar.f11273f) {
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
    public boolean performAccessibilityAction(int i4, Bundle bundle) {
        if (i4 == 64) {
            this.mAccessibilityFocused = true;
        } else if (i4 == 128) {
            this.mAccessibilityFocused = false;
        }
        if (super.performAccessibilityAction(i4, bundle)) {
            return true;
        }
        if (!isEnabled()) {
            return false;
        }
        int progress = getProgress();
        if (i4 == 4096) {
            if (progress >= getMax()) {
                return false;
            }
            setProgress(progress + 1, false, false);
            return true;
        }
        if (i4 == 8192) {
            if (progress <= 0) {
                return false;
            }
            setProgress(progress - 1, false, false);
            return true;
        }
        if (i4 != 16908349 || !isEnabled() || bundle == null || !bundle.containsKey("android.view.accessibility.action.ARGUMENT_PROGRESS_VALUE")) {
            return false;
        }
        setProgress((int) bundle.getFloat("android.view.accessibility.action.ARGUMENT_PROGRESS_VALUE"), true, true);
        return true;
    }

    public void setEnableEngine(boolean z4) {
        this.mEnableEngine = z4;
    }

    @Override // android.view.View
    public void setEnabled(boolean z4) {
        super.setEnabled(z4);
        refreshRes();
        invalidate();
    }

    public void setItemsCount(int i4) {
        if (i4 < 1) {
            setMax(0);
        } else {
            setMax(i4 - 1);
        }
    }

    public void setOnStepSeekBarChangeListener(OnStepSeekBarChangeListener onStepSeekBarChangeListener) {
        this.mOnStepSeekBarChangeListener = onStepSeekBarChangeListener;
    }

    public void setPaintColor(int i4) {
        this.mPaintColor = i4;
    }

    public synchronized void setProgress(int i4) {
        setProgress(i4, false, false);
    }

    public void setStrokeColor(int i4) {
        this.mStrokeColor = i4;
    }

    public void setStrokeWidth(int i4) {
        this.mStrokeWidth = i4;
    }

    public final void setThumb(Drawable drawable) throws Resources.NotFoundException {
        boolean z4;
        if (drawable == null) {
            drawable = getResources().getDrawable(com.stepos.alphame.R.drawable.stepos_step_seekbar_thumb);
        }
        Drawable drawable2 = this.mThumb;
        if (drawable2 == null || drawable == drawable2) {
            z4 = false;
        } else {
            drawable2.setCallback(null);
            this.mThumb.getIntrinsicWidth();
            z4 = true;
        }
        if (drawable != null) {
            drawable.setCallback(this);
            if (z4 && (drawable.getIntrinsicWidth() != this.mThumb.getIntrinsicWidth() || drawable.getIntrinsicHeight() != this.mThumb.getIntrinsicHeight())) {
                requestLayout();
            }
            this.mHalfThumbWidth = drawable.getIntrinsicWidth() / 2;
            this.mHalfThumbHeight = drawable.getIntrinsicHeight() / 2;
        }
        this.mThumb = drawable;
        invalidate();
        if (z4) {
            updateThumbPos(getWidth(), getHeight());
            if (drawable == null || !drawable.isStateful()) {
                return;
            }
            drawable.setState(getDrawableState());
        }
    }

    public void setTouchScaleEnable(boolean z4) {
        com.stepos.common.animator.a aVar = this.mAnimHelper;
        if (aVar != null) {
            aVar.f11273f = z4;
        }
    }

    public void setTouchScaleRatio(float f4, float f5) {
        com.stepos.common.animator.a aVar = this.mAnimHelper;
        if (aVar != null) {
            aVar.f11271d = f4;
            aVar.f11272e = f5;
        }
    }

    public class XYHolder {
        private float mX;
        private float mY;

        public XYHolder() {
            this.mY = Property.DEFAULT_FLOAT_VALUE;
            this.mX = Property.DEFAULT_FLOAT_VALUE;
        }

        public float getX() {
            return this.mX;
        }

        public float getY() {
            return this.mY;
        }

        public void setX(float f4) {
            this.mX = f4;
        }

        public void setXY(float f4, float f5) {
            this.mX = f4;
            this.mY = f5;
        }

        public void setY(float f4) {
            this.mY = f4;
        }

        public XYHolder(float f4, float f5) {
            this.mX = f4;
            this.mY = f5;
        }
    }

    public StepSeekBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, com.stepos.alphame.R.attr.StepOSCommon_StepSeekBarStyle);
    }

    public StepSeekBar(Context context, AttributeSet attributeSet, int i4) throws Resources.NotFoundException {
        super(context, attributeSet, i4);
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
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC0620a.f13038t, i4, com.stepos.alphame.R.style.Widget_StepOSCommon_StepSeekBar);
        setItemsCount(typedArrayObtainStyledAttributes.getInt(0, 1));
        setProgress(typedArrayObtainStyledAttributes.getInt(1, 0));
        Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(4);
        drawable = drawable == null ? context.getResources().getDrawable(com.stepos.alphame.R.drawable.stepos_step_seekbar_thumb) : drawable;
        this.mStrokeWidth = (int) typedArrayObtainStyledAttributes.getDimension(3, getResources().getDimension(com.stepos.alphame.R.dimen.mc_enhance_seekbar_stroke_width));
        this.mStrokeColorStateList = typedArrayObtainStyledAttributes.getColorStateList(2);
        setThumb(drawable);
        this.mPaintColorStateList = getResources().getColorStateList(com.stepos.alphame.R.color.stepos_seekbar_background_state_color);
        this.mSpotColorStateList = getResources().getColorStateList(com.stepos.alphame.R.color.stepos_enhance_seekbar_spot_color);
        this.mSpotRadius = getResources().getDimension(com.stepos.alphame.R.dimen.mc_enhance_seekbar_spot_radius);
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
        AbstractC0770a.c(this);
        com.stepos.common.animator.a aVar = new com.stepos.common.animator.a();
        aVar.f11273f = true;
        aVar.f11270c = this;
        this.mAnimHelper = aVar;
        aVar.f11271d = 1.05f;
        aVar.f11272e = 1.05f;
    }

    public synchronized void setProgress(int i4, boolean z4, boolean z5) {
        if (i4 < 0) {
            i4 = 0;
        }
        try {
            int i5 = this.mMax;
            if (i4 > i5) {
                i4 = i5;
            }
            if (i4 != this.mProgress && z5 && this.mEnableEngine) {
                if (AbstractC0770a.b()) {
                    performHapticFeedback(31015);
                } else {
                    performHapticFeedback(26);
                }
            }
            if (i4 != this.mProgress || !this.mIsInItemPositon) {
                this.mProgress = i4;
                if (!z4) {
                    int i6 = this.mMax;
                    onProgressRefresh(i6 > 0 ? i4 / i6 : Property.DEFAULT_FLOAT_VALUE);
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
