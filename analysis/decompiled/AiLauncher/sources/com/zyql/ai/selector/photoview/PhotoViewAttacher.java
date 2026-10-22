package com.zyql.ai.selector.photoview;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import android.widget.OverScroller;

/* loaded from: classes4.dex */
public class PhotoViewAttacher implements View.OnTouchListener, View.OnLayoutChangeListener {
    private static final float DEFAULT_MAX_SCALE = 3.0f;
    private static final float DEFAULT_MID_SCALE = 1.75f;
    private static final float DEFAULT_MIN_SCALE = 1.0f;
    private static final int DEFAULT_ZOOM_DURATION = 200;
    private static final int HORIZONTAL_EDGE_BOTH = 2;
    private static final int HORIZONTAL_EDGE_LEFT = 0;
    private static final int HORIZONTAL_EDGE_NONE = -1;
    private static final int HORIZONTAL_EDGE_RIGHT = 1;
    private static final int SINGLE_TOUCH = 1;
    private static final int VERTICAL_EDGE_BOTH = 2;
    private static final int VERTICAL_EDGE_BOTTOM = 1;
    private static final int VERTICAL_EDGE_NONE = -1;
    private static final int VERTICAL_EDGE_TOP = 0;
    private float mBaseRotation;
    private FlingRunnable mCurrentFlingRunnable;
    private GestureDetector mGestureDetector;
    private final ImageView mImageView;
    private View.OnLongClickListener mLongClickListener;
    private OnMatrixChangedListener mMatrixChangeListener;
    private View.OnClickListener mOnClickListener;
    private OnViewDragListener mOnViewDragListener;
    private OnOutsidePhotoTapListener mOutsidePhotoTapListener;
    private OnPhotoTapListener mPhotoTapListener;
    private OnScaleChangedListener mScaleChangeListener;
    private CustomGestureDetector mScaleDragDetector;
    private OnSingleFlingListener mSingleFlingListener;
    private OnViewTapListener mViewTapListener;
    private final OnGestureListener onGestureListener;
    private Interpolator mInterpolator = new AccelerateDecelerateInterpolator();
    private int mZoomDuration = 200;
    private float mMinScale = 1.0f;
    private float mMidScale = DEFAULT_MID_SCALE;
    private float mMaxScale = 3.0f;
    private boolean mAllowParentInterceptOnEdge = true;
    private boolean mBlockParentIntercept = false;
    private final Matrix mBaseMatrix = new Matrix();
    private final Matrix mDrawMatrix = new Matrix();
    private final Matrix mSuppMatrix = new Matrix();
    private final RectF mDisplayRect = new RectF();
    private final float[] mMatrixValues = new float[9];
    private int mHorizontalScrollEdge = 2;
    private int mVerticalScrollEdge = 2;
    private boolean mZoomEnabled = true;
    private ImageView.ScaleType mScaleType = ImageView.ScaleType.FIT_CENTER;

    /* renamed from: com.zyql.ai.selector.photoview.PhotoViewAttacher$4, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass4 {
        static final /* synthetic */ int[] $SwitchMap$android$widget$ImageView$ScaleType;

        static {
            int[] iArr = new int[ImageView.ScaleType.values().length];
            $SwitchMap$android$widget$ImageView$ScaleType = iArr;
            try {
                iArr[ImageView.ScaleType.FIT_CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$android$widget$ImageView$ScaleType[ImageView.ScaleType.FIT_START.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$android$widget$ImageView$ScaleType[ImageView.ScaleType.FIT_END.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$android$widget$ImageView$ScaleType[ImageView.ScaleType.FIT_XY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public class AnimatedZoomRunnable implements Runnable {
        private final float mFocalX;
        private final float mFocalY;
        private final long mStartTime = System.currentTimeMillis();
        private final float mZoomEnd;
        private final float mZoomStart;

        public AnimatedZoomRunnable(float f10, float f11, float f12, float f13) {
            this.mFocalX = f12;
            this.mFocalY = f13;
            this.mZoomStart = f10;
            this.mZoomEnd = f11;
        }

        private float interpolate() {
            return PhotoViewAttacher.this.mInterpolator.getInterpolation(Math.min(1.0f, ((System.currentTimeMillis() - this.mStartTime) * 1.0f) / PhotoViewAttacher.this.mZoomDuration));
        }

        @Override // java.lang.Runnable
        public void run() {
            float fInterpolate = interpolate();
            float f10 = this.mZoomStart;
            PhotoViewAttacher.this.onGestureListener.onScale((f10 + ((this.mZoomEnd - f10) * fInterpolate)) / PhotoViewAttacher.this.getScale(), this.mFocalX, this.mFocalY);
            if (fInterpolate < 1.0f) {
                Compat.postOnAnimation(PhotoViewAttacher.this.mImageView, this);
            }
        }
    }

    public class FlingRunnable implements Runnable {
        private int mCurrentX;
        private int mCurrentY;
        private final OverScroller mScroller;

        public FlingRunnable(Context context) {
            this.mScroller = new OverScroller(context);
        }

        public void cancelFling() {
            this.mScroller.forceFinished(true);
        }

        public void fling(int i10, int i11, int i12, int i13) {
            int i14;
            int iRound;
            int i15;
            int iRound2;
            RectF displayRect = PhotoViewAttacher.this.getDisplayRect();
            if (displayRect == null) {
                return;
            }
            int iRound3 = Math.round(-displayRect.left);
            float f10 = i10;
            if (f10 < displayRect.width()) {
                iRound = Math.round(displayRect.width() - f10);
                i14 = 0;
            } else {
                i14 = iRound3;
                iRound = i14;
            }
            int iRound4 = Math.round(-displayRect.top);
            float f11 = i11;
            if (f11 < displayRect.height()) {
                iRound2 = Math.round(displayRect.height() - f11);
                i15 = 0;
            } else {
                i15 = iRound4;
                iRound2 = i15;
            }
            this.mCurrentX = iRound3;
            this.mCurrentY = iRound4;
            if (iRound3 == iRound && iRound4 == iRound2) {
                return;
            }
            this.mScroller.fling(iRound3, iRound4, i12, i13, i14, iRound, i15, iRound2, 0, 0);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.mScroller.isFinished() && this.mScroller.computeScrollOffset()) {
                int currX = this.mScroller.getCurrX();
                int currY = this.mScroller.getCurrY();
                PhotoViewAttacher.this.mSuppMatrix.postTranslate(this.mCurrentX - currX, this.mCurrentY - currY);
                PhotoViewAttacher.this.checkAndDisplayMatrix();
                this.mCurrentX = currX;
                this.mCurrentY = currY;
                Compat.postOnAnimation(PhotoViewAttacher.this.mImageView, this);
            }
        }
    }

    public PhotoViewAttacher(ImageView imageView) {
        OnGestureListener onGestureListener = new OnGestureListener() { // from class: com.zyql.ai.selector.photoview.PhotoViewAttacher.1
            @Override // com.zyql.ai.selector.photoview.OnGestureListener
            public void onDrag(float f10, float f11) {
                if (PhotoViewAttacher.this.mScaleDragDetector.isScaling()) {
                    return;
                }
                if (PhotoViewAttacher.this.mOnViewDragListener != null) {
                    PhotoViewAttacher.this.mOnViewDragListener.onDrag(f10, f11);
                }
                PhotoViewAttacher.this.mSuppMatrix.postTranslate(f10, f11);
                PhotoViewAttacher.this.checkAndDisplayMatrix();
                ViewParent parent = PhotoViewAttacher.this.mImageView.getParent();
                if (!PhotoViewAttacher.this.mAllowParentInterceptOnEdge || PhotoViewAttacher.this.mScaleDragDetector.isScaling() || PhotoViewAttacher.this.mBlockParentIntercept) {
                    if (parent != null) {
                        parent.requestDisallowInterceptTouchEvent(true);
                    }
                } else if ((PhotoViewAttacher.this.mHorizontalScrollEdge == 2 || ((PhotoViewAttacher.this.mHorizontalScrollEdge == 0 && f10 >= 1.0f) || ((PhotoViewAttacher.this.mHorizontalScrollEdge == 1 && f10 <= -1.0f) || ((PhotoViewAttacher.this.mVerticalScrollEdge == 0 && f11 >= 1.0f) || (PhotoViewAttacher.this.mVerticalScrollEdge == 1 && f11 <= -1.0f))))) && parent != null) {
                    parent.requestDisallowInterceptTouchEvent(false);
                }
            }

            @Override // com.zyql.ai.selector.photoview.OnGestureListener
            public void onFling(float f10, float f11, float f12, float f13) {
                PhotoViewAttacher photoViewAttacher = PhotoViewAttacher.this;
                photoViewAttacher.mCurrentFlingRunnable = photoViewAttacher.new FlingRunnable(photoViewAttacher.mImageView.getContext());
                FlingRunnable flingRunnable = PhotoViewAttacher.this.mCurrentFlingRunnable;
                PhotoViewAttacher photoViewAttacher2 = PhotoViewAttacher.this;
                int imageViewWidth = photoViewAttacher2.getImageViewWidth(photoViewAttacher2.mImageView);
                PhotoViewAttacher photoViewAttacher3 = PhotoViewAttacher.this;
                flingRunnable.fling(imageViewWidth, photoViewAttacher3.getImageViewHeight(photoViewAttacher3.mImageView), (int) f12, (int) f13);
                PhotoViewAttacher.this.mImageView.post(PhotoViewAttacher.this.mCurrentFlingRunnable);
            }

            @Override // com.zyql.ai.selector.photoview.OnGestureListener
            public void onScale(float f10, float f11, float f12) {
                onScale(f10, f11, f12, 0.0f, 0.0f);
            }

            @Override // com.zyql.ai.selector.photoview.OnGestureListener
            public void onScale(float f10, float f11, float f12, float f13, float f14) {
                if (PhotoViewAttacher.this.getScale() < PhotoViewAttacher.this.mMaxScale || f10 < 1.0f) {
                    if (PhotoViewAttacher.this.mScaleChangeListener != null) {
                        PhotoViewAttacher.this.mScaleChangeListener.onScaleChange(f10, f11, f12);
                    }
                    PhotoViewAttacher.this.mSuppMatrix.postScale(f10, f10, f11, f12);
                    PhotoViewAttacher.this.mSuppMatrix.postTranslate(f13, f14);
                    PhotoViewAttacher.this.checkAndDisplayMatrix();
                }
            }
        };
        this.onGestureListener = onGestureListener;
        this.mImageView = imageView;
        imageView.setOnTouchListener(this);
        imageView.addOnLayoutChangeListener(this);
        if (imageView.isInEditMode()) {
            return;
        }
        this.mBaseRotation = 0.0f;
        this.mScaleDragDetector = new CustomGestureDetector(imageView.getContext(), onGestureListener);
        GestureDetector gestureDetector = new GestureDetector(imageView.getContext(), new GestureDetector.SimpleOnGestureListener() { // from class: com.zyql.ai.selector.photoview.PhotoViewAttacher.2
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f10, float f11) {
                if (PhotoViewAttacher.this.mSingleFlingListener == null || PhotoViewAttacher.this.getScale() > 1.0f || motionEvent.getPointerCount() > 1 || motionEvent2.getPointerCount() > 1) {
                    return false;
                }
                return PhotoViewAttacher.this.mSingleFlingListener.onFling(motionEvent, motionEvent2, f10, f11);
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public void onLongPress(MotionEvent motionEvent) {
                if (PhotoViewAttacher.this.mLongClickListener != null) {
                    PhotoViewAttacher.this.mLongClickListener.onLongClick(PhotoViewAttacher.this.mImageView);
                }
            }
        });
        this.mGestureDetector = gestureDetector;
        gestureDetector.setOnDoubleTapListener(new GestureDetector.OnDoubleTapListener() { // from class: com.zyql.ai.selector.photoview.PhotoViewAttacher.3
            @Override // android.view.GestureDetector.OnDoubleTapListener
            public boolean onDoubleTap(MotionEvent motionEvent) {
                try {
                    float scale = PhotoViewAttacher.this.getScale();
                    float x10 = motionEvent.getX();
                    float y10 = motionEvent.getY();
                    if (scale < PhotoViewAttacher.this.getMediumScale()) {
                        PhotoViewAttacher photoViewAttacher = PhotoViewAttacher.this;
                        photoViewAttacher.setScale(photoViewAttacher.getMediumScale(), x10, y10, true);
                    } else if (scale < PhotoViewAttacher.this.getMediumScale() || scale >= PhotoViewAttacher.this.getMaximumScale()) {
                        PhotoViewAttacher photoViewAttacher2 = PhotoViewAttacher.this;
                        photoViewAttacher2.setScale(photoViewAttacher2.getMinimumScale(), x10, y10, true);
                    } else {
                        PhotoViewAttacher photoViewAttacher3 = PhotoViewAttacher.this;
                        photoViewAttacher3.setScale(photoViewAttacher3.getMaximumScale(), x10, y10, true);
                    }
                } catch (ArrayIndexOutOfBoundsException unused) {
                }
                return true;
            }

            @Override // android.view.GestureDetector.OnDoubleTapListener
            public boolean onDoubleTapEvent(MotionEvent motionEvent) {
                return false;
            }

            @Override // android.view.GestureDetector.OnDoubleTapListener
            public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                if (PhotoViewAttacher.this.mOnClickListener != null) {
                    PhotoViewAttacher.this.mOnClickListener.onClick(PhotoViewAttacher.this.mImageView);
                }
                RectF displayRect = PhotoViewAttacher.this.getDisplayRect();
                float x10 = motionEvent.getX();
                float y10 = motionEvent.getY();
                if (PhotoViewAttacher.this.mViewTapListener != null) {
                    PhotoViewAttacher.this.mViewTapListener.onViewTap(PhotoViewAttacher.this.mImageView, x10, y10);
                }
                if (displayRect == null) {
                    return false;
                }
                if (!displayRect.contains(x10, y10)) {
                    if (PhotoViewAttacher.this.mOutsidePhotoTapListener == null) {
                        return false;
                    }
                    PhotoViewAttacher.this.mOutsidePhotoTapListener.onOutsidePhotoTap(PhotoViewAttacher.this.mImageView);
                    return false;
                }
                float fWidth = (x10 - displayRect.left) / displayRect.width();
                float fHeight = (y10 - displayRect.top) / displayRect.height();
                if (PhotoViewAttacher.this.mPhotoTapListener == null) {
                    return true;
                }
                PhotoViewAttacher.this.mPhotoTapListener.onPhotoTap(PhotoViewAttacher.this.mImageView, fWidth, fHeight);
                return true;
            }
        });
    }

    private void cancelFling() {
        FlingRunnable flingRunnable = this.mCurrentFlingRunnable;
        if (flingRunnable != null) {
            flingRunnable.cancelFling();
            this.mCurrentFlingRunnable = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkAndDisplayMatrix() {
        if (checkMatrixBounds()) {
            setImageViewMatrix(getDrawMatrix());
        }
    }

    private boolean checkMatrixBounds() {
        float f10;
        float f11;
        float f12;
        float f13;
        float f14;
        RectF displayRect = getDisplayRect(getDrawMatrix());
        if (displayRect == null) {
            return false;
        }
        float fHeight = displayRect.height();
        float fWidth = displayRect.width();
        float imageViewHeight = getImageViewHeight(this.mImageView);
        float f15 = 0.0f;
        if (fHeight <= imageViewHeight) {
            int i10 = AnonymousClass4.$SwitchMap$android$widget$ImageView$ScaleType[this.mScaleType.ordinal()];
            if (i10 != 2) {
                if (i10 != 3) {
                    f13 = (imageViewHeight - fHeight) / 2.0f;
                    f14 = displayRect.top;
                } else {
                    f13 = imageViewHeight - fHeight;
                    f14 = displayRect.top;
                }
                f10 = f13 - f14;
            } else {
                f10 = -displayRect.top;
            }
            this.mVerticalScrollEdge = 2;
        } else {
            float f16 = displayRect.top;
            if (f16 > 0.0f) {
                this.mVerticalScrollEdge = 0;
                f10 = -f16;
            } else {
                float f17 = displayRect.bottom;
                if (f17 < imageViewHeight) {
                    this.mVerticalScrollEdge = 1;
                    f10 = imageViewHeight - f17;
                } else {
                    this.mVerticalScrollEdge = -1;
                    f10 = 0.0f;
                }
            }
        }
        float imageViewWidth = getImageViewWidth(this.mImageView);
        if (fWidth <= imageViewWidth) {
            int i11 = AnonymousClass4.$SwitchMap$android$widget$ImageView$ScaleType[this.mScaleType.ordinal()];
            if (i11 != 2) {
                if (i11 != 3) {
                    f11 = (imageViewWidth - fWidth) / 2.0f;
                    f12 = displayRect.left;
                } else {
                    f11 = imageViewWidth - fWidth;
                    f12 = displayRect.left;
                }
                f15 = f11 - f12;
            } else {
                f15 = -displayRect.left;
            }
            this.mHorizontalScrollEdge = 2;
        } else {
            float f18 = displayRect.left;
            if (f18 > 0.0f) {
                this.mHorizontalScrollEdge = 0;
                f15 = -f18;
            } else {
                float f19 = displayRect.right;
                if (f19 < imageViewWidth) {
                    f15 = imageViewWidth - f19;
                    this.mHorizontalScrollEdge = 1;
                } else {
                    this.mHorizontalScrollEdge = -1;
                }
            }
        }
        this.mSuppMatrix.postTranslate(f15, f10);
        return true;
    }

    private Matrix getDrawMatrix() {
        this.mDrawMatrix.set(this.mBaseMatrix);
        this.mDrawMatrix.postConcat(this.mSuppMatrix);
        return this.mDrawMatrix;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getImageViewHeight(ImageView imageView) {
        return (imageView.getHeight() - imageView.getPaddingTop()) - imageView.getPaddingBottom();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getImageViewWidth(ImageView imageView) {
        return (imageView.getWidth() - imageView.getPaddingLeft()) - imageView.getPaddingRight();
    }

    private float getValue(Matrix matrix, int i10) {
        matrix.getValues(this.mMatrixValues);
        return this.mMatrixValues[i10];
    }

    private void resetMatrix() {
        this.mSuppMatrix.reset();
        setRotationBy(this.mBaseRotation);
        setImageViewMatrix(getDrawMatrix());
        checkMatrixBounds();
    }

    private void setImageViewMatrix(Matrix matrix) {
        RectF displayRect;
        this.mImageView.setImageMatrix(matrix);
        if (this.mMatrixChangeListener == null || (displayRect = getDisplayRect(matrix)) == null) {
            return;
        }
        this.mMatrixChangeListener.onMatrixChanged(displayRect);
    }

    private void updateBaseMatrix(Drawable drawable) {
        if (drawable == null) {
            return;
        }
        float imageViewWidth = getImageViewWidth(this.mImageView);
        float imageViewHeight = getImageViewHeight(this.mImageView);
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        this.mBaseMatrix.reset();
        float f10 = intrinsicWidth;
        float f11 = imageViewWidth / f10;
        float f12 = intrinsicHeight;
        float f13 = imageViewHeight / f12;
        ImageView.ScaleType scaleType = this.mScaleType;
        if (scaleType == ImageView.ScaleType.CENTER) {
            this.mBaseMatrix.postTranslate((imageViewWidth - f10) / 2.0f, (imageViewHeight - f12) / 2.0f);
        } else if (scaleType == ImageView.ScaleType.CENTER_CROP) {
            float fMax = Math.max(f11, f13);
            this.mBaseMatrix.postScale(fMax, fMax);
            this.mBaseMatrix.postTranslate((imageViewWidth - (f10 * fMax)) / 2.0f, (imageViewHeight - (f12 * fMax)) / 2.0f);
        } else if (scaleType == ImageView.ScaleType.CENTER_INSIDE) {
            float fMin = Math.min(1.0f, Math.min(f11, f13));
            this.mBaseMatrix.postScale(fMin, fMin);
            this.mBaseMatrix.postTranslate((imageViewWidth - (f10 * fMin)) / 2.0f, (imageViewHeight - (f12 * fMin)) / 2.0f);
        } else {
            RectF rectF = new RectF(0.0f, 0.0f, f10, f12);
            RectF rectF2 = new RectF(0.0f, 0.0f, imageViewWidth, imageViewHeight);
            if (((int) this.mBaseRotation) % 180 != 0) {
                rectF = new RectF(0.0f, 0.0f, f12, f10);
            }
            int i10 = AnonymousClass4.$SwitchMap$android$widget$ImageView$ScaleType[this.mScaleType.ordinal()];
            if (i10 == 1) {
                this.mBaseMatrix.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.CENTER);
            } else if (i10 == 2) {
                this.mBaseMatrix.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.START);
            } else if (i10 == 3) {
                this.mBaseMatrix.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.END);
            } else if (i10 == 4) {
                this.mBaseMatrix.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.FILL);
            }
        }
        resetMatrix();
    }

    public void getDisplayMatrix(Matrix matrix) {
        matrix.set(getDrawMatrix());
    }

    public RectF getDisplayRect() {
        checkMatrixBounds();
        return getDisplayRect(getDrawMatrix());
    }

    public Matrix getImageMatrix() {
        return this.mDrawMatrix;
    }

    public float getMaximumScale() {
        return this.mMaxScale;
    }

    public float getMediumScale() {
        return this.mMidScale;
    }

    public float getMinimumScale() {
        return this.mMinScale;
    }

    public float getScale() {
        return (float) Math.sqrt(((float) Math.pow(getValue(this.mSuppMatrix, 0), 2.0d)) + ((float) Math.pow(getValue(this.mSuppMatrix, 3), 2.0d)));
    }

    public ImageView.ScaleType getScaleType() {
        return this.mScaleType;
    }

    public void getSuppMatrix(Matrix matrix) {
        matrix.set(this.mSuppMatrix);
    }

    @Deprecated
    public boolean isZoomEnabled() {
        return this.mZoomEnabled;
    }

    public boolean isZoomable() {
        return this.mZoomEnabled;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public void onLayoutChange(View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
        if (i10 == i14 && i11 == i15 && i12 == i16 && i13 == i17) {
            return;
        }
        updateBaseMatrix(this.mImageView.getDrawable());
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0086  */
    @Override // android.view.View.OnTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouch(android.view.View r9, android.view.MotionEvent r10) {
        /*
            r8 = this;
            boolean r0 = r8.mZoomEnabled
            r6 = 0
            if (r0 == 0) goto Lc4
            r0 = r9
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            boolean r0 = com.zyql.ai.selector.photoview.Util.hasDrawable(r0)
            if (r0 == 0) goto Lc4
            int r0 = r10.getAction()
            r7 = 1
            if (r0 == 0) goto L75
            if (r0 == r7) goto L1c
            r2 = 3
            if (r0 == r2) goto L1c
            goto L81
        L1c:
            float r0 = r8.getScale()
            float r2 = r8.mMinScale
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 >= 0) goto L48
            android.graphics.RectF r0 = r8.getDisplayRect()
            if (r0 == 0) goto L81
            r2 = r0
            com.zyql.ai.selector.photoview.PhotoViewAttacher$AnimatedZoomRunnable r0 = new com.zyql.ai.selector.photoview.PhotoViewAttacher$AnimatedZoomRunnable
            r3 = r2
            float r2 = r8.getScale()
            r4 = r3
            float r3 = r8.mMinScale
            r5 = r4
            float r4 = r5.centerX()
            float r5 = r5.centerY()
            r1 = r8
            r0.<init>(r2, r3, r4, r5)
            r9.post(r0)
            goto L73
        L48:
            float r0 = r8.getScale()
            float r2 = r8.mMaxScale
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 <= 0) goto L81
            android.graphics.RectF r0 = r8.getDisplayRect()
            if (r0 == 0) goto L81
            r2 = r0
            com.zyql.ai.selector.photoview.PhotoViewAttacher$AnimatedZoomRunnable r0 = new com.zyql.ai.selector.photoview.PhotoViewAttacher$AnimatedZoomRunnable
            r3 = r2
            float r2 = r8.getScale()
            r4 = r3
            float r3 = r8.mMaxScale
            r5 = r4
            float r4 = r5.centerX()
            float r5 = r5.centerY()
            r1 = r8
            r0.<init>(r2, r3, r4, r5)
            r9.post(r0)
        L73:
            r0 = r7
            goto L82
        L75:
            android.view.ViewParent r0 = r9.getParent()
            if (r0 == 0) goto L7e
            r0.requestDisallowInterceptTouchEvent(r7)
        L7e:
            r8.cancelFling()
        L81:
            r0 = r6
        L82:
            com.zyql.ai.selector.photoview.CustomGestureDetector r2 = r8.mScaleDragDetector
            if (r2 == 0) goto Lb8
            boolean r0 = r2.isScaling()
            com.zyql.ai.selector.photoview.CustomGestureDetector r2 = r8.mScaleDragDetector
            boolean r2 = r2.isDragging()
            com.zyql.ai.selector.photoview.CustomGestureDetector r3 = r8.mScaleDragDetector
            boolean r3 = r3.onTouchEvent(r10)
            if (r0 != 0) goto La2
            com.zyql.ai.selector.photoview.CustomGestureDetector r0 = r8.mScaleDragDetector
            boolean r0 = r0.isScaling()
            if (r0 != 0) goto La2
            r0 = r7
            goto La3
        La2:
            r0 = r6
        La3:
            if (r2 != 0) goto Laf
            com.zyql.ai.selector.photoview.CustomGestureDetector r2 = r8.mScaleDragDetector
            boolean r2 = r2.isDragging()
            if (r2 != 0) goto Laf
            r2 = r7
            goto Lb0
        Laf:
            r2 = r6
        Lb0:
            if (r0 == 0) goto Lb5
            if (r2 == 0) goto Lb5
            r6 = r7
        Lb5:
            r8.mBlockParentIntercept = r6
            r0 = r3
        Lb8:
            android.view.GestureDetector r1 = r8.mGestureDetector
            if (r1 == 0) goto Lc3
            boolean r1 = r1.onTouchEvent(r10)
            if (r1 == 0) goto Lc3
            return r7
        Lc3:
            return r0
        Lc4:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zyql.ai.selector.photoview.PhotoViewAttacher.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }

    public void setAllowParentInterceptOnEdge(boolean z10) {
        this.mAllowParentInterceptOnEdge = z10;
    }

    public void setBaseRotation(float f10) {
        this.mBaseRotation = f10 % 360.0f;
        update();
        setRotationBy(this.mBaseRotation);
        checkAndDisplayMatrix();
    }

    public boolean setDisplayMatrix(Matrix matrix) {
        if (matrix == null) {
            throw new IllegalArgumentException("Matrix cannot be null");
        }
        if (this.mImageView.getDrawable() == null) {
            return false;
        }
        this.mSuppMatrix.set(matrix);
        checkAndDisplayMatrix();
        return true;
    }

    public void setMaximumScale(float f10) {
        Util.checkZoomLevels(this.mMinScale, this.mMidScale, f10);
        this.mMaxScale = f10;
    }

    public void setMediumScale(float f10) {
        Util.checkZoomLevels(this.mMinScale, f10, this.mMaxScale);
        this.mMidScale = f10;
    }

    public void setMinimumScale(float f10) {
        Util.checkZoomLevels(f10, this.mMidScale, this.mMaxScale);
        this.mMinScale = f10;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
        this.mGestureDetector.setOnDoubleTapListener(onDoubleTapListener);
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mLongClickListener = onLongClickListener;
    }

    public void setOnMatrixChangeListener(OnMatrixChangedListener onMatrixChangedListener) {
        this.mMatrixChangeListener = onMatrixChangedListener;
    }

    public void setOnOutsidePhotoTapListener(OnOutsidePhotoTapListener onOutsidePhotoTapListener) {
        this.mOutsidePhotoTapListener = onOutsidePhotoTapListener;
    }

    public void setOnPhotoTapListener(OnPhotoTapListener onPhotoTapListener) {
        this.mPhotoTapListener = onPhotoTapListener;
    }

    public void setOnScaleChangeListener(OnScaleChangedListener onScaleChangedListener) {
        this.mScaleChangeListener = onScaleChangedListener;
    }

    public void setOnSingleFlingListener(OnSingleFlingListener onSingleFlingListener) {
        this.mSingleFlingListener = onSingleFlingListener;
    }

    public void setOnViewDragListener(OnViewDragListener onViewDragListener) {
        this.mOnViewDragListener = onViewDragListener;
    }

    public void setOnViewTapListener(OnViewTapListener onViewTapListener) {
        this.mViewTapListener = onViewTapListener;
    }

    public void setRotationBy(float f10) {
        this.mSuppMatrix.postRotate(f10 % 360.0f);
        checkAndDisplayMatrix();
    }

    public void setRotationTo(float f10) {
        this.mSuppMatrix.setRotate(f10 % 360.0f);
        checkAndDisplayMatrix();
    }

    public void setScale(float f10) {
        setScale(f10, false);
    }

    public void setScaleLevels(float f10, float f11, float f12) {
        Util.checkZoomLevels(f10, f11, f12);
        this.mMinScale = f10;
        this.mMidScale = f11;
        this.mMaxScale = f12;
    }

    public void setScaleType(ImageView.ScaleType scaleType) {
        if (!Util.isSupportedScaleType(scaleType) || scaleType == this.mScaleType) {
            return;
        }
        this.mScaleType = scaleType;
        update();
    }

    public void setZoomInterpolator(Interpolator interpolator) {
        this.mInterpolator = interpolator;
    }

    public void setZoomTransitionDuration(int i10) {
        this.mZoomDuration = i10;
    }

    public void setZoomable(boolean z10) {
        this.mZoomEnabled = z10;
        update();
    }

    public void update() {
        if (this.mZoomEnabled) {
            updateBaseMatrix(this.mImageView.getDrawable());
        } else {
            resetMatrix();
        }
    }

    public void setScale(float f10, boolean z10) {
        setScale(f10, this.mImageView.getRight() / 2, this.mImageView.getBottom() / 2, z10);
    }

    private RectF getDisplayRect(Matrix matrix) {
        if (this.mImageView.getDrawable() == null) {
            return null;
        }
        this.mDisplayRect.set(0.0f, 0.0f, r0.getIntrinsicWidth(), r0.getIntrinsicHeight());
        matrix.mapRect(this.mDisplayRect);
        return this.mDisplayRect;
    }

    public void setScale(float f10, float f11, float f12, boolean z10) {
        if (f10 < this.mMinScale || f10 > this.mMaxScale) {
            throw new IllegalArgumentException("Scale must be within the range of minScale and maxScale");
        }
        if (z10) {
            this.mImageView.post(new AnimatedZoomRunnable(getScale(), f10, f11, f12));
        } else {
            this.mSuppMatrix.setScale(f10, f10, f11, f12);
            checkAndDisplayMatrix();
        }
    }
}
