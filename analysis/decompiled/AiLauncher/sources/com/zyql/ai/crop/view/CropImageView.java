package com.zyql.ai.crop.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.zyql.ai.crop.callback.BitmapCropCallback;
import com.zyql.ai.crop.callback.CropBoundsChangeListener;
import com.zyql.ai.crop.model.CropParameters;
import com.zyql.ai.crop.model.ImageState;
import com.zyql.ai.crop.task.BitmapCropTask;
import com.zyql.ai.crop.util.CubicEasing;
import com.zyql.ai.crop.util.RectUtils;
import com.zyql.ai.crop.view.TransformImageView;
import com.zyql.ai.selector.R;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.concurrent.Executors;

/* loaded from: classes4.dex */
public class CropImageView extends TransformImageView {
    public static final float DEFAULT_ASPECT_RATIO = 0.0f;
    public static final int DEFAULT_IMAGE_TO_CROP_BOUNDS_ANIM_DURATION = 500;
    public static final int DEFAULT_MAX_BITMAP_SIZE = 0;
    public static final float DEFAULT_MAX_SCALE_MULTIPLIER = 10.0f;
    public static final float SOURCE_IMAGE_ASPECT_RATIO = 0.0f;
    private CropBoundsChangeListener mCropBoundsChangeListener;
    private final RectF mCropRect;
    private long mImageToWrapCropBoundsAnimDuration;
    private int mMaxResultImageSizeX;
    private int mMaxResultImageSizeY;
    private float mMaxScale;
    private float mMaxScaleMultiplier;
    private float mMinScale;
    private float mTargetAspectRatio;
    private final Matrix mTempMatrix;
    private Runnable mWrapCropBoundsRunnable;
    private Runnable mZoomImageToPositionRunnable;

    public static class WrapCropBoundsRunnable implements Runnable {
        private final float mCenterDiffX;
        private final float mCenterDiffY;
        private final WeakReference<CropImageView> mCropImageView;
        private final float mDeltaScale;
        private final long mDurationMs;
        private final float mOldScale;
        private final float mOldX;
        private final float mOldY;
        private final long mStartTime = System.currentTimeMillis();
        private final boolean mWillBeImageInBoundsAfterTranslate;

        public WrapCropBoundsRunnable(CropImageView cropImageView, long j10, float f10, float f11, float f12, float f13, float f14, float f15, boolean z10) {
            this.mCropImageView = new WeakReference<>(cropImageView);
            this.mDurationMs = j10;
            this.mOldX = f10;
            this.mOldY = f11;
            this.mCenterDiffX = f12;
            this.mCenterDiffY = f13;
            this.mOldScale = f14;
            this.mDeltaScale = f15;
            this.mWillBeImageInBoundsAfterTranslate = z10;
        }

        @Override // java.lang.Runnable
        public void run() {
            CropImageView cropImageView = this.mCropImageView.get();
            if (cropImageView == null) {
                return;
            }
            float fMin = Math.min(this.mDurationMs, System.currentTimeMillis() - this.mStartTime);
            float fEaseOut = CubicEasing.easeOut(fMin, 0.0f, this.mCenterDiffX, this.mDurationMs);
            float fEaseOut2 = CubicEasing.easeOut(fMin, 0.0f, this.mCenterDiffY, this.mDurationMs);
            float fEaseInOut = CubicEasing.easeInOut(fMin, 0.0f, this.mDeltaScale, this.mDurationMs);
            if (fMin < this.mDurationMs) {
                float[] fArr = cropImageView.mCurrentImageCenter;
                cropImageView.postTranslate(fEaseOut - (fArr[0] - this.mOldX), fEaseOut2 - (fArr[1] - this.mOldY));
                if (!this.mWillBeImageInBoundsAfterTranslate) {
                    cropImageView.zoomInImage(this.mOldScale + fEaseInOut, cropImageView.mCropRect.centerX(), cropImageView.mCropRect.centerY());
                }
                if (cropImageView.isImageWrapCropBounds()) {
                    return;
                }
                cropImageView.post(this);
            }
        }
    }

    public static class ZoomImageToPosition implements Runnable {
        private final WeakReference<CropImageView> mCropImageView;
        private final float mDeltaScale;
        private final float mDestX;
        private final float mDestY;
        private final long mDurationMs;
        private final float mOldScale;
        private final long mStartTime = System.currentTimeMillis();

        public ZoomImageToPosition(CropImageView cropImageView, long j10, float f10, float f11, float f12, float f13) {
            this.mCropImageView = new WeakReference<>(cropImageView);
            this.mDurationMs = j10;
            this.mOldScale = f10;
            this.mDeltaScale = f11;
            this.mDestX = f12;
            this.mDestY = f13;
        }

        @Override // java.lang.Runnable
        public void run() {
            CropImageView cropImageView = this.mCropImageView.get();
            if (cropImageView == null) {
                return;
            }
            float fMin = Math.min(this.mDurationMs, System.currentTimeMillis() - this.mStartTime);
            float fEaseInOut = CubicEasing.easeInOut(fMin, 0.0f, this.mDeltaScale, this.mDurationMs);
            if (fMin >= this.mDurationMs) {
                cropImageView.setImageToWrapCropBounds();
            } else {
                cropImageView.zoomInImage(this.mOldScale + fEaseInOut, this.mDestX, this.mDestY);
                cropImageView.post(this);
            }
        }
    }

    public CropImageView(Context context) {
        this(context, null);
    }

    private float[] calculateImageIndents() {
        this.mTempMatrix.reset();
        this.mTempMatrix.setRotate(-getCurrentAngle());
        float[] fArr = this.mCurrentImageCorners;
        float[] fArrCopyOf = Arrays.copyOf(fArr, fArr.length);
        float[] cornersFromRect = RectUtils.getCornersFromRect(this.mCropRect);
        this.mTempMatrix.mapPoints(fArrCopyOf);
        this.mTempMatrix.mapPoints(cornersFromRect);
        RectF rectFTrapToRect = RectUtils.trapToRect(fArrCopyOf);
        RectF rectFTrapToRect2 = RectUtils.trapToRect(cornersFromRect);
        float f10 = rectFTrapToRect.left - rectFTrapToRect2.left;
        float f11 = rectFTrapToRect.top - rectFTrapToRect2.top;
        float f12 = rectFTrapToRect.right - rectFTrapToRect2.right;
        float f13 = rectFTrapToRect.bottom - rectFTrapToRect2.bottom;
        if (f10 <= 0.0f) {
            f10 = 0.0f;
        }
        if (f11 <= 0.0f) {
            f11 = 0.0f;
        }
        if (f12 >= 0.0f) {
            f12 = 0.0f;
        }
        if (f13 >= 0.0f) {
            f13 = 0.0f;
        }
        float[] fArr2 = {f10, f11, f12, f13};
        this.mTempMatrix.reset();
        this.mTempMatrix.setRotate(getCurrentAngle());
        this.mTempMatrix.mapPoints(fArr2);
        return fArr2;
    }

    private void calculateImageScaleBounds() {
        if (getDrawable() == null) {
            return;
        }
        calculateImageScaleBounds(r0.getIntrinsicWidth(), r0.getIntrinsicHeight());
    }

    private void setupInitialImagePosition(float f10, float f11) {
        float fWidth = this.mCropRect.width();
        float fHeight = this.mCropRect.height();
        float fMax = Math.max(this.mCropRect.width() / f10, this.mCropRect.height() / f11);
        RectF rectF = this.mCropRect;
        float f12 = ((fWidth - (f10 * fMax)) / 2.0f) + rectF.left;
        float f13 = ((fHeight - (f11 * fMax)) / 2.0f) + rectF.top;
        this.mCurrentImageMatrix.reset();
        this.mCurrentImageMatrix.postScale(fMax, fMax);
        this.mCurrentImageMatrix.postTranslate(f12, f13);
        setImageMatrix(this.mCurrentImageMatrix);
    }

    public void cancelAllAnimations() {
        removeCallbacks(this.mWrapCropBoundsRunnable);
        removeCallbacks(this.mZoomImageToPositionRunnable);
    }

    public void cropAndSaveImage(Bitmap.CompressFormat compressFormat, int i10, BitmapCropCallback bitmapCropCallback) {
        cancelAllAnimations();
        setImageToWrapCropBounds(false);
        new BitmapCropTask(getContext(), getViewBitmap(), new ImageState(this.mCropRect, RectUtils.trapToRect(this.mCurrentImageCorners), getCurrentScale(), getCurrentAngle()), new CropParameters(this.mMaxResultImageSizeX, this.mMaxResultImageSizeY, compressFormat, i10, getImageInputPath(), getImageOutputPath(), getExifInfo()), bitmapCropCallback).executeOnExecutor(Executors.newCachedThreadPool(), new Void[0]);
    }

    public CropBoundsChangeListener getCropBoundsChangeListener() {
        return this.mCropBoundsChangeListener;
    }

    public float getMaxScale() {
        return this.mMaxScale;
    }

    public float getMinScale() {
        return this.mMinScale;
    }

    public float getTargetAspectRatio() {
        return this.mTargetAspectRatio;
    }

    public boolean isImageWrapCropBounds() {
        return isImageWrapCropBounds(this.mCurrentImageCorners);
    }

    @Override // com.zyql.ai.crop.view.TransformImageView
    public void onImageLaidOut() {
        super.onImageLaidOut();
        Drawable drawable = getDrawable();
        if (drawable == null) {
            return;
        }
        float intrinsicWidth = drawable.getIntrinsicWidth();
        float intrinsicHeight = drawable.getIntrinsicHeight();
        if (this.mTargetAspectRatio == 0.0f) {
            this.mTargetAspectRatio = intrinsicWidth / intrinsicHeight;
        }
        int i10 = this.mThisWidth;
        float f10 = this.mTargetAspectRatio;
        int i11 = (int) (i10 / f10);
        int i12 = this.mThisHeight;
        if (i11 > i12) {
            this.mCropRect.set((i10 - ((int) (i12 * f10))) / 2, 0.0f, r4 + r2, i12);
        } else {
            this.mCropRect.set(0.0f, (i12 - i11) / 2, i10, i11 + r6);
        }
        calculateImageScaleBounds(intrinsicWidth, intrinsicHeight);
        setupInitialImagePosition(intrinsicWidth, intrinsicHeight);
        CropBoundsChangeListener cropBoundsChangeListener = this.mCropBoundsChangeListener;
        if (cropBoundsChangeListener != null) {
            cropBoundsChangeListener.onCropAspectRatioChanged(this.mTargetAspectRatio);
        }
        TransformImageView.TransformImageListener transformImageListener = this.mTransformImageListener;
        if (transformImageListener != null) {
            transformImageListener.onScale(getCurrentScale());
            this.mTransformImageListener.onRotate(getCurrentAngle());
        }
    }

    public void postRotate(float f10) {
        postRotate(f10, this.mCropRect.centerX(), this.mCropRect.centerY());
    }

    @Override // com.zyql.ai.crop.view.TransformImageView
    public void postScale(float f10, float f11, float f12) {
        if (f10 > 1.0f && getCurrentScale() * f10 <= getMaxScale()) {
            super.postScale(f10, f11, f12);
        } else {
            if (f10 >= 1.0f || getCurrentScale() * f10 < getMinScale()) {
                return;
            }
            super.postScale(f10, f11, f12);
        }
    }

    public void processStyledAttributes(TypedArray typedArray) {
        float fAbs = Math.abs(typedArray.getFloat(R.styleable.ucrop_UCropView_ucrop_aspect_ratio_x, 0.0f));
        float fAbs2 = Math.abs(typedArray.getFloat(R.styleable.ucrop_UCropView_ucrop_aspect_ratio_y, 0.0f));
        if (fAbs == 0.0f || fAbs2 == 0.0f) {
            this.mTargetAspectRatio = 0.0f;
        } else {
            this.mTargetAspectRatio = fAbs / fAbs2;
        }
    }

    public void setCropBoundsChangeListener(CropBoundsChangeListener cropBoundsChangeListener) {
        this.mCropBoundsChangeListener = cropBoundsChangeListener;
    }

    public void setCropRect(RectF rectF) {
        this.mTargetAspectRatio = rectF.width() / rectF.height();
        this.mCropRect.set(rectF.left - getPaddingLeft(), rectF.top - getPaddingTop(), rectF.right - getPaddingRight(), rectF.bottom - getPaddingBottom());
        calculateImageScaleBounds();
        setImageToWrapCropBounds();
    }

    public void setImageToWrapCropBounds() {
        setImageToWrapCropBounds(true);
    }

    public void setImageToWrapCropBoundsAnimDuration(long j10) {
        if (j10 <= 0) {
            throw new IllegalArgumentException("Animation duration cannot be negative value.");
        }
        this.mImageToWrapCropBoundsAnimDuration = j10;
    }

    public void setMaxResultImageSizeX(int i10) {
        this.mMaxResultImageSizeX = i10;
    }

    public void setMaxResultImageSizeY(int i10) {
        this.mMaxResultImageSizeY = i10;
    }

    public void setMaxScaleMultiplier(float f10) {
        this.mMaxScaleMultiplier = f10;
    }

    public void setTargetAspectRatio(float f10) {
        if (getDrawable() == null) {
            this.mTargetAspectRatio = f10;
            return;
        }
        if (f10 == 0.0f) {
            this.mTargetAspectRatio = r0.getIntrinsicWidth() / r0.getIntrinsicHeight();
        } else {
            this.mTargetAspectRatio = f10;
        }
        CropBoundsChangeListener cropBoundsChangeListener = this.mCropBoundsChangeListener;
        if (cropBoundsChangeListener != null) {
            cropBoundsChangeListener.onCropAspectRatioChanged(this.mTargetAspectRatio);
        }
    }

    public void zoomImageToPosition(float f10, float f11, float f12, long j10) {
        if (f10 > getMaxScale()) {
            f10 = getMaxScale();
        }
        float currentScale = getCurrentScale();
        ZoomImageToPosition zoomImageToPosition = new ZoomImageToPosition(this, j10, currentScale, f10 - currentScale, f11, f12);
        this.mZoomImageToPositionRunnable = zoomImageToPosition;
        post(zoomImageToPosition);
    }

    public void zoomInImage(float f10) {
        zoomInImage(f10, this.mCropRect.centerX(), this.mCropRect.centerY());
    }

    public void zoomOutImage(float f10) {
        zoomOutImage(f10, this.mCropRect.centerX(), this.mCropRect.centerY());
    }

    public CropImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public boolean isImageWrapCropBounds(float[] fArr) {
        this.mTempMatrix.reset();
        this.mTempMatrix.setRotate(-getCurrentAngle());
        float[] fArrCopyOf = Arrays.copyOf(fArr, fArr.length);
        this.mTempMatrix.mapPoints(fArrCopyOf);
        float[] cornersFromRect = RectUtils.getCornersFromRect(this.mCropRect);
        this.mTempMatrix.mapPoints(cornersFromRect);
        return RectUtils.trapToRect(fArrCopyOf).contains(RectUtils.trapToRect(cornersFromRect));
    }

    public void setImageToWrapCropBounds(boolean z10) {
        float f10;
        float fMax;
        if (!this.mBitmapLaidOut || isImageWrapCropBounds()) {
            return;
        }
        float[] fArr = this.mCurrentImageCenter;
        float f11 = fArr[0];
        float f12 = fArr[1];
        float currentScale = getCurrentScale();
        float fCenterX = this.mCropRect.centerX() - f11;
        float fCenterY = this.mCropRect.centerY() - f12;
        this.mTempMatrix.reset();
        this.mTempMatrix.setTranslate(fCenterX, fCenterY);
        float[] fArr2 = this.mCurrentImageCorners;
        float[] fArrCopyOf = Arrays.copyOf(fArr2, fArr2.length);
        this.mTempMatrix.mapPoints(fArrCopyOf);
        boolean zIsImageWrapCropBounds = isImageWrapCropBounds(fArrCopyOf);
        if (zIsImageWrapCropBounds) {
            float[] fArrCalculateImageIndents = calculateImageIndents();
            float f13 = -(fArrCalculateImageIndents[0] + fArrCalculateImageIndents[2]);
            fCenterY = -(fArrCalculateImageIndents[1] + fArrCalculateImageIndents[3]);
            fMax = 0.0f;
            f10 = f13;
        } else {
            RectF rectF = new RectF(this.mCropRect);
            this.mTempMatrix.reset();
            this.mTempMatrix.setRotate(getCurrentAngle());
            this.mTempMatrix.mapRect(rectF);
            float[] rectSidesFromCorners = RectUtils.getRectSidesFromCorners(this.mCurrentImageCorners);
            f10 = fCenterX;
            fMax = (Math.max(rectF.width() / rectSidesFromCorners[0], rectF.height() / rectSidesFromCorners[1]) * currentScale) - currentScale;
        }
        float f14 = fCenterY;
        if (z10) {
            WrapCropBoundsRunnable wrapCropBoundsRunnable = new WrapCropBoundsRunnable(this, this.mImageToWrapCropBoundsAnimDuration, f11, f12, f10, f14, currentScale, fMax, zIsImageWrapCropBounds);
            this.mWrapCropBoundsRunnable = wrapCropBoundsRunnable;
            post(wrapCropBoundsRunnable);
        } else {
            postTranslate(f10, f14);
            if (zIsImageWrapCropBounds) {
                return;
            }
            zoomInImage(currentScale + fMax, this.mCropRect.centerX(), this.mCropRect.centerY());
        }
    }

    public void zoomInImage(float f10, float f11, float f12) {
        if (f10 <= getMaxScale()) {
            postScale(f10 / getCurrentScale(), f11, f12);
        }
    }

    public void zoomOutImage(float f10, float f11, float f12) {
        if (f10 >= getMinScale()) {
            postScale(f10 / getCurrentScale(), f11, f12);
        }
    }

    public CropImageView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.mCropRect = new RectF();
        this.mTempMatrix = new Matrix();
        this.mMaxScaleMultiplier = 10.0f;
        this.mZoomImageToPositionRunnable = null;
        this.mMaxResultImageSizeX = 0;
        this.mMaxResultImageSizeY = 0;
        this.mImageToWrapCropBoundsAnimDuration = 500L;
    }

    private void calculateImageScaleBounds(float f10, float f11) {
        float fMin = Math.min(Math.min(this.mCropRect.width() / f10, this.mCropRect.width() / f11), Math.min(this.mCropRect.height() / f11, this.mCropRect.height() / f10));
        this.mMinScale = fMin;
        this.mMaxScale = fMin * this.mMaxScaleMultiplier;
    }
}
