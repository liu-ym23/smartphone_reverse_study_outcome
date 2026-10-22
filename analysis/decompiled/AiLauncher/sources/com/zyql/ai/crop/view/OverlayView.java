package com.zyql.ai.crop.view;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.RectF;
import android.graphics.Region;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.OvershootInterpolator;
import com.zyql.ai.crop.callback.OverlayViewChangeListener;
import com.zyql.ai.crop.util.RectUtils;
import com.zyql.ai.selector.R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes4.dex */
public class OverlayView extends View {
    public static final boolean DEFAULT_CIRCLE_DIMMED_LAYER = false;
    public static final int DEFAULT_CROP_GRID_COLUMN_COUNT = 2;
    public static final int DEFAULT_CROP_GRID_ROW_COUNT = 2;
    public static final boolean DEFAULT_DRAG_FRAME = true;
    public static final int DEFAULT_FREESTYLE_CROP_MODE = 0;
    public static final boolean DEFAULT_SHOW_CROP_FRAME = true;
    public static final boolean DEFAULT_SHOW_CROP_GRID = true;
    public static final int FREESTYLE_CROP_MODE_DISABLE = 0;
    public static final int FREESTYLE_CROP_MODE_ENABLE = 1;
    public static final int FREESTYLE_CROP_MODE_ENABLE_WITH_PASS_THROUGH = 2;
    private OverlayViewChangeListener mCallback;
    private boolean mCircleDimmedLayer;
    private Path mCircularPath;
    private Paint mCropFrameCornersPaint;
    private Paint mCropFramePaint;
    protected float[] mCropGridCenter;
    private int mCropGridColumnCount;
    protected float[] mCropGridCorners;
    private Paint mCropGridPaint;
    private int mCropGridRowCount;
    private int mCropRectCornerTouchAreaLineLength;
    private int mCropRectMinSize;
    private final RectF mCropViewRect;
    private int mCurrentTouchCornerIndex;
    private int mDimmedBorderColor;
    private int mDimmedColor;
    private Paint mDimmedStrokePaint;
    private int mFreestyleCropMode;
    private float[] mGridPoints;
    private boolean mIsDragFrame;
    private float mPreviousTouchX;
    private float mPreviousTouchY;
    private boolean mShouldSetupCropBounds;
    private boolean mShowCropFrame;
    private boolean mShowCropGrid;
    private int mStrokeWidth;
    private float mTargetAspectRatio;
    private final RectF mTempRect;
    protected int mThisHeight;
    protected int mThisWidth;
    private int mTouchPointThreshold;
    private ValueAnimator smoothAnimator;

    @Retention(RetentionPolicy.SOURCE)
    public @interface FreestyleMode {
    }

    public OverlayView(Context context) {
        this(context, null);
    }

    private int getCurrentTouchIndex(float f10, float f11) {
        double d10 = this.mTouchPointThreshold;
        int i10 = -1;
        for (int i11 = 0; i11 < 8; i11 += 2) {
            double dSqrt = Math.sqrt(Math.pow(f10 - this.mCropGridCorners[i11], 2.0d) + Math.pow(f11 - this.mCropGridCorners[i11 + 1], 2.0d));
            if (dSqrt < d10) {
                i10 = i11 / 2;
                d10 = dSqrt;
            }
        }
        if (this.mFreestyleCropMode == 1 && i10 < 0 && this.mCropViewRect.contains(f10, f11)) {
            return 4;
        }
        return i10;
    }

    private void initCropFrameStyle(TypedArray typedArray) {
        int dimensionPixelSize = typedArray.getDimensionPixelSize(R.styleable.ucrop_UCropView_ucrop_frame_stroke_size, getResources().getDimensionPixelSize(R.dimen.ucrop_default_crop_frame_stoke_width));
        int color = typedArray.getColor(R.styleable.ucrop_UCropView_ucrop_frame_color, getResources().getColor(R.color.ucrop_color_default_crop_frame));
        this.mCropFramePaint.setStrokeWidth(dimensionPixelSize);
        this.mCropFramePaint.setColor(color);
        Paint paint = this.mCropFramePaint;
        Paint.Style style = Paint.Style.STROKE;
        paint.setStyle(style);
        this.mCropFrameCornersPaint.setStrokeWidth(dimensionPixelSize * 3);
        this.mCropFrameCornersPaint.setColor(color);
        this.mCropFrameCornersPaint.setStyle(style);
    }

    private void initCropGridStyle(TypedArray typedArray) {
        int dimensionPixelSize = typedArray.getDimensionPixelSize(R.styleable.ucrop_UCropView_ucrop_grid_stroke_size, getResources().getDimensionPixelSize(R.dimen.ucrop_default_crop_grid_stoke_width));
        int color = typedArray.getColor(R.styleable.ucrop_UCropView_ucrop_grid_color, getResources().getColor(R.color.ucrop_color_default_crop_grid));
        this.mCropGridPaint.setStrokeWidth(dimensionPixelSize);
        this.mCropGridPaint.setColor(color);
        this.mCropGridRowCount = typedArray.getInt(R.styleable.ucrop_UCropView_ucrop_grid_row_count, 2);
        this.mCropGridColumnCount = typedArray.getInt(R.styleable.ucrop_UCropView_ucrop_grid_column_count, 2);
    }

    private void smoothToCenter() {
        Point point = new Point((getRight() + getLeft()) / 2, (getTop() + getBottom()) / 2);
        final int iCenterY = (int) (point.y - this.mCropViewRect.centerY());
        final int iCenterX = (int) (point.x - this.mCropViewRect.centerX());
        final RectF rectF = new RectF(this.mCropViewRect);
        Log.d("pisa", "pre" + this.mCropViewRect);
        RectF rectF2 = new RectF(this.mCropViewRect);
        rectF2.offset((float) iCenterX, (float) iCenterY);
        Log.d("pisa", "after" + rectF2);
        ValueAnimator valueAnimator = this.smoothAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.smoothAnimator = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(1000L);
        this.smoothAnimator.setInterpolator(new OvershootInterpolator());
        this.smoothAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.zyql.ai.crop.view.OverlayView.1
            float lastAnimationValue = 0.0f;

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                float fFloatValue = iCenterX * ((Float) valueAnimator2.getAnimatedValue()).floatValue();
                float fFloatValue2 = iCenterY * ((Float) valueAnimator2.getAnimatedValue()).floatValue();
                RectF rectF3 = OverlayView.this.mCropViewRect;
                RectF rectF4 = rectF;
                rectF3.set(new RectF(rectF4.left + fFloatValue, rectF4.top + fFloatValue2, rectF4.right + fFloatValue, rectF4.bottom + fFloatValue2));
                OverlayView.this.updateGridPoints();
                OverlayView.this.postInvalidate();
                if (OverlayView.this.mCallback != null) {
                    OverlayView.this.mCallback.postTranslate(iCenterX * (((Float) valueAnimator2.getAnimatedValue()).floatValue() - this.lastAnimationValue), iCenterY * (((Float) valueAnimator2.getAnimatedValue()).floatValue() - this.lastAnimationValue));
                }
                this.lastAnimationValue = ((Float) valueAnimator2.getAnimatedValue()).floatValue();
            }
        });
        this.smoothAnimator.addListener(new Animator.AnimatorListener() { // from class: com.zyql.ai.crop.view.OverlayView.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (OverlayView.this.mCallback != null) {
                    OverlayView.this.mCallback.onCropRectUpdated(OverlayView.this.mCropViewRect);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        });
        this.smoothAnimator.start();
    }

    private void updateCropViewRect(float f10, float f11) {
        this.mTempRect.set(this.mCropViewRect);
        int i10 = this.mCurrentTouchCornerIndex;
        if (i10 != 0) {
            if (i10 != 1) {
                if (i10 != 2) {
                    if (i10 != 3) {
                        if (i10 == 4) {
                            this.mTempRect.offset(f10 - this.mPreviousTouchX, f11 - this.mPreviousTouchY);
                            if (this.mTempRect.left <= getLeft() || this.mTempRect.top <= getTop() || this.mTempRect.right >= getRight() || this.mTempRect.bottom >= getBottom()) {
                                return;
                            }
                            this.mCropViewRect.set(this.mTempRect);
                            updateGridPoints();
                            postInvalidate();
                            return;
                        }
                    } else if (isDragFrame()) {
                        RectF rectF = this.mTempRect;
                        RectF rectF2 = this.mCropViewRect;
                        rectF.set(f10, rectF2.top, rectF2.right, f11);
                    }
                } else if (isDragFrame()) {
                    RectF rectF3 = this.mTempRect;
                    RectF rectF4 = this.mCropViewRect;
                    rectF3.set(rectF4.left, rectF4.top, f10, f11);
                }
            } else if (isDragFrame()) {
                RectF rectF5 = this.mTempRect;
                RectF rectF6 = this.mCropViewRect;
                rectF5.set(rectF6.left, f11, f10, rectF6.bottom);
            }
        } else if (isDragFrame()) {
            RectF rectF7 = this.mTempRect;
            RectF rectF8 = this.mCropViewRect;
            rectF7.set(f10, f11, rectF8.right, rectF8.bottom);
        }
        boolean z10 = this.mTempRect.height() >= ((float) this.mCropRectMinSize);
        boolean z11 = this.mTempRect.width() >= ((float) this.mCropRectMinSize);
        RectF rectF9 = this.mCropViewRect;
        rectF9.set(z11 ? this.mTempRect.left : rectF9.left, z10 ? this.mTempRect.top : rectF9.top, z11 ? this.mTempRect.right : rectF9.right, z10 ? this.mTempRect.bottom : rectF9.bottom);
        if (z10 || z11) {
            updateGridPoints();
            postInvalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateGridPoints() {
        this.mCropGridCorners = RectUtils.getCornersFromRect(this.mCropViewRect);
        this.mCropGridCenter = RectUtils.getCenterFromRect(this.mCropViewRect);
        this.mGridPoints = null;
        this.mCircularPath.reset();
        this.mCircularPath.addCircle(this.mCropViewRect.centerX(), this.mCropViewRect.centerY(), Math.min(this.mCropViewRect.width(), this.mCropViewRect.height()) / 2.0f, Path.Direction.CW);
    }

    public void drawCropGrid(Canvas canvas) {
        if (this.mShowCropGrid) {
            if (this.mGridPoints == null && !this.mCropViewRect.isEmpty()) {
                this.mGridPoints = new float[(this.mCropGridRowCount * 4) + (this.mCropGridColumnCount * 4)];
                int i10 = 0;
                for (int i11 = 0; i11 < this.mCropGridRowCount; i11++) {
                    float[] fArr = this.mGridPoints;
                    RectF rectF = this.mCropViewRect;
                    fArr[i10] = rectF.left;
                    float f10 = i11 + 1.0f;
                    float fHeight = rectF.height() * (f10 / (this.mCropGridRowCount + 1));
                    RectF rectF2 = this.mCropViewRect;
                    fArr[i10 + 1] = fHeight + rectF2.top;
                    float[] fArr2 = this.mGridPoints;
                    int i12 = i10 + 3;
                    fArr2[i10 + 2] = rectF2.right;
                    i10 += 4;
                    fArr2[i12] = (rectF2.height() * (f10 / (this.mCropGridRowCount + 1))) + this.mCropViewRect.top;
                }
                for (int i13 = 0; i13 < this.mCropGridColumnCount; i13++) {
                    float[] fArr3 = this.mGridPoints;
                    float f11 = i13 + 1.0f;
                    float fWidth = this.mCropViewRect.width() * (f11 / (this.mCropGridColumnCount + 1));
                    RectF rectF3 = this.mCropViewRect;
                    fArr3[i10] = fWidth + rectF3.left;
                    float[] fArr4 = this.mGridPoints;
                    fArr4[i10 + 1] = rectF3.top;
                    int i14 = i10 + 3;
                    float fWidth2 = rectF3.width() * (f11 / (this.mCropGridColumnCount + 1));
                    RectF rectF4 = this.mCropViewRect;
                    fArr4[i10 + 2] = fWidth2 + rectF4.left;
                    i10 += 4;
                    this.mGridPoints[i14] = rectF4.bottom;
                }
            }
            float[] fArr5 = this.mGridPoints;
            if (fArr5 != null) {
                canvas.drawLines(fArr5, this.mCropGridPaint);
            }
        }
        if (this.mShowCropFrame) {
            canvas.drawRect(this.mCropViewRect, this.mCropFramePaint);
        }
        if (this.mFreestyleCropMode != 0) {
            canvas.save();
            this.mTempRect.set(this.mCropViewRect);
            this.mTempRect.inset(this.mCropRectCornerTouchAreaLineLength, -r1);
            RectF rectF5 = this.mTempRect;
            Region.Op op = Region.Op.DIFFERENCE;
            canvas.clipRect(rectF5, op);
            this.mTempRect.set(this.mCropViewRect);
            this.mTempRect.inset(-r2, this.mCropRectCornerTouchAreaLineLength);
            canvas.clipRect(this.mTempRect, op);
            canvas.drawRect(this.mCropViewRect, this.mCropFrameCornersPaint);
            canvas.restore();
        }
    }

    public void drawDimmedLayer(Canvas canvas) {
        canvas.save();
        if (this.mCircleDimmedLayer) {
            canvas.clipPath(this.mCircularPath, Region.Op.DIFFERENCE);
        } else {
            canvas.clipRect(this.mCropViewRect, Region.Op.DIFFERENCE);
        }
        canvas.drawColor(this.mDimmedColor);
        canvas.restore();
        if (this.mCircleDimmedLayer) {
            canvas.drawCircle(this.mCropViewRect.centerX(), this.mCropViewRect.centerY(), Math.min(this.mCropViewRect.width(), this.mCropViewRect.height()) / 2.0f, this.mDimmedStrokePaint);
        }
    }

    public RectF getCropViewRect() {
        return this.mCropViewRect;
    }

    public int getFreestyleCropMode() {
        return this.mFreestyleCropMode;
    }

    public OverlayViewChangeListener getOverlayViewChangeListener() {
        return this.mCallback;
    }

    public void init() {
    }

    public boolean isDragFrame() {
        return this.mIsDragFrame;
    }

    @Deprecated
    public boolean isFreestyleCropEnabled() {
        return this.mFreestyleCropMode == 1;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawDimmedLayer(canvas);
        drawCropGrid(canvas);
    }

    @Override // android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        if (z10) {
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int width = getWidth() - getPaddingRight();
            int height = getHeight() - getPaddingBottom();
            this.mThisWidth = width - paddingLeft;
            this.mThisHeight = height - paddingTop;
            if (this.mShouldSetupCropBounds) {
                this.mShouldSetupCropBounds = false;
                setTargetAspectRatio(this.mTargetAspectRatio);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z10 = false;
        if (!this.mCropViewRect.isEmpty() && this.mFreestyleCropMode != 0) {
            float x10 = motionEvent.getX();
            float y10 = motionEvent.getY();
            if ((motionEvent.getAction() & 255) == 0) {
                ValueAnimator valueAnimator = this.smoothAnimator;
                if (valueAnimator != null) {
                    valueAnimator.cancel();
                }
                int currentTouchIndex = getCurrentTouchIndex(x10, y10);
                this.mCurrentTouchCornerIndex = currentTouchIndex;
                if (currentTouchIndex != -1 && currentTouchIndex != 4) {
                    z10 = true;
                }
                if (!z10) {
                    this.mPreviousTouchX = -1.0f;
                    this.mPreviousTouchY = -1.0f;
                    return z10;
                }
                if (this.mPreviousTouchX < 0.0f) {
                    this.mPreviousTouchX = x10;
                    this.mPreviousTouchY = y10;
                }
                return z10;
            }
            if ((motionEvent.getAction() & 255) == 2 && motionEvent.getPointerCount() == 1 && this.mCurrentTouchCornerIndex != -1) {
                float fMin = Math.min(Math.max(x10, getPaddingLeft()), getWidth() - getPaddingRight());
                float fMin2 = Math.min(Math.max(y10, getPaddingTop()), getHeight() - getPaddingBottom());
                updateCropViewRect(fMin, fMin2);
                this.mPreviousTouchX = fMin;
                this.mPreviousTouchY = fMin2;
                return true;
            }
            if ((motionEvent.getAction() & 255) == 1) {
                this.mPreviousTouchX = -1.0f;
                this.mPreviousTouchY = -1.0f;
                this.mCurrentTouchCornerIndex = -1;
                OverlayViewChangeListener overlayViewChangeListener = this.mCallback;
                if (overlayViewChangeListener != null) {
                    overlayViewChangeListener.onCropRectUpdated(this.mCropViewRect);
                }
                smoothToCenter();
            }
        }
        return false;
    }

    public void processStyledAttributes(TypedArray typedArray) {
        this.mCircleDimmedLayer = typedArray.getBoolean(R.styleable.ucrop_UCropView_ucrop_circle_dimmed_layer, false);
        this.mDimmedColor = typedArray.getColor(R.styleable.ucrop_UCropView_ucrop_dimmed_color, getResources().getColor(R.color.ucrop_color_default_dimmed));
        this.mDimmedStrokePaint.setColor(this.mDimmedBorderColor);
        this.mDimmedStrokePaint.setStyle(Paint.Style.STROKE);
        this.mDimmedStrokePaint.setStrokeWidth(this.mStrokeWidth);
        initCropFrameStyle(typedArray);
        this.mShowCropFrame = typedArray.getBoolean(R.styleable.ucrop_UCropView_ucrop_show_frame, true);
        initCropGridStyle(typedArray);
        this.mShowCropGrid = typedArray.getBoolean(R.styleable.ucrop_UCropView_ucrop_show_grid, true);
    }

    public void setCircleDimmedLayer(boolean z10) {
        this.mCircleDimmedLayer = z10;
    }

    public void setCropFrameColor(int i10) {
        this.mCropFramePaint.setColor(i10);
    }

    public void setCropFrameStrokeWidth(int i10) {
        this.mCropFramePaint.setStrokeWidth(i10);
    }

    public void setCropGridColor(int i10) {
        this.mCropGridPaint.setColor(i10);
    }

    public void setCropGridColumnCount(int i10) {
        this.mCropGridColumnCount = i10;
        this.mGridPoints = null;
    }

    public void setCropGridRowCount(int i10) {
        this.mCropGridRowCount = i10;
        this.mGridPoints = null;
    }

    public void setCropGridStrokeWidth(int i10) {
        this.mCropGridPaint.setStrokeWidth(i10);
    }

    public void setDimmedBorderColor(int i10) {
        this.mDimmedBorderColor = i10;
        Paint paint = this.mDimmedStrokePaint;
        if (paint != null) {
            paint.setColor(i10);
        }
    }

    public void setDimmedColor(int i10) {
        this.mDimmedColor = i10;
    }

    public void setDimmedStrokeWidth(int i10) {
        this.mStrokeWidth = i10;
        Paint paint = this.mDimmedStrokePaint;
        if (paint != null) {
            paint.setStrokeWidth(i10);
        }
    }

    public void setDragFrame(boolean z10) {
        this.mIsDragFrame = z10;
    }

    @Deprecated
    public void setFreestyleCropEnabled(boolean z10) {
        this.mFreestyleCropMode = z10 ? 1 : 0;
    }

    public void setFreestyleCropMode(int i10) {
        this.mFreestyleCropMode = i10;
        postInvalidate();
    }

    public void setOverlayViewChangeListener(OverlayViewChangeListener overlayViewChangeListener) {
        this.mCallback = overlayViewChangeListener;
    }

    public void setShowCropFrame(boolean z10) {
        this.mShowCropFrame = z10;
    }

    public void setShowCropGrid(boolean z10) {
        this.mShowCropGrid = z10;
    }

    public void setTargetAspectRatio(float f10) {
        this.mTargetAspectRatio = f10;
        if (this.mThisWidth <= 0) {
            this.mShouldSetupCropBounds = true;
        } else {
            setupCropBounds();
            postInvalidate();
        }
    }

    public void setupCropBounds() {
        int i10 = this.mThisWidth;
        float f10 = this.mTargetAspectRatio;
        int i11 = (int) (i10 / f10);
        int i12 = this.mThisHeight;
        if (i11 > i12) {
            int i13 = (i10 - ((int) (i12 * f10))) / 2;
            this.mCropViewRect.set(getPaddingLeft() + i13, getPaddingTop(), getPaddingLeft() + r1 + i13, getPaddingTop() + this.mThisHeight);
        } else {
            int i14 = (i12 - i11) / 2;
            this.mCropViewRect.set(getPaddingLeft(), getPaddingTop() + i14, getPaddingLeft() + this.mThisWidth, getPaddingTop() + i11 + i14);
        }
        OverlayViewChangeListener overlayViewChangeListener = this.mCallback;
        if (overlayViewChangeListener != null) {
            overlayViewChangeListener.onCropRectUpdated(this.mCropViewRect);
        }
        updateGridPoints();
    }

    public OverlayView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public OverlayView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.mCropViewRect = new RectF();
        this.mTempRect = new RectF();
        this.mGridPoints = null;
        this.mCircularPath = new Path();
        this.mDimmedStrokePaint = new Paint(1);
        this.mCropGridPaint = new Paint(1);
        this.mCropFramePaint = new Paint(1);
        this.mCropFrameCornersPaint = new Paint(1);
        this.mFreestyleCropMode = 0;
        this.mPreviousTouchX = -1.0f;
        this.mPreviousTouchY = -1.0f;
        this.mCurrentTouchCornerIndex = -1;
        this.mStrokeWidth = 1;
        this.mIsDragFrame = true;
        this.mTouchPointThreshold = getResources().getDimensionPixelSize(R.dimen.ucrop_default_crop_rect_corner_touch_threshold);
        this.mCropRectMinSize = getResources().getDimensionPixelSize(R.dimen.ucrop_default_crop_rect_min_size);
        this.mCropRectCornerTouchAreaLineLength = getResources().getDimensionPixelSize(R.dimen.ucrop_default_crop_rect_corner_touch_area_line_length);
        init();
    }
}
