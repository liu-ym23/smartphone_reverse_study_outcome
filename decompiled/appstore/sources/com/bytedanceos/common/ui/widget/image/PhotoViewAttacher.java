package com.bytedanceos.common.ui.widget.image;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import com.bytedanceos.common.toolbox.j;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
public class PhotoViewAttacher implements IPhotoView, View.OnTouchListener, VersionedGestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener, ViewTreeObserver.OnGlobalLayoutListener {
    public static final float DEFAULT_MAX_SCALE = 3.0f;
    public static final float DEFAULT_MID_SCALE = 1.75f;
    public static final float DEFAULT_MIN_SCALE = 1.0f;
    static final int EDGE_BOTH = 2;
    static final int EDGE_LEFT = 0;
    static final int EDGE_NONE = -1;
    static final int EDGE_RIGHT = 1;
    private boolean mAllowParentInterceptOnEdge;
    private final Matrix mBaseMatrix;
    private FlingRunnable mCurrentFlingRunnable;
    private final RectF mDisplayRect;
    private final Matrix mDrawMatrix;
    private GestureDetector mGestureDetector;
    private WeakReference<ImageView> mImageView;
    private int mIvBottom;
    private int mIvLeft;
    private int mIvRight;
    private int mIvTop;
    private View.OnLongClickListener mLongClickListener;
    private OnMatrixChangedListener mMatrixChangeListener;
    private final float[] mMatrixValues;
    private float mMaxScale;
    private float mMidScale;
    private float mMinScale;
    private OnPhotoTapListener mPhotoTapListener;
    private VersionedGestureDetector mScaleDragDetector;
    private ImageView.ScaleType mScaleType;
    private int mScrollEdge;
    private final Matrix mSuppMatrix;
    private OnViewTapListener mViewTapListener;
    private ViewTreeObserver mViewTreeObserver;
    private boolean mZoomEnabled;

    /* JADX INFO: renamed from: com.bytedanceos.common.ui.widget.image.PhotoViewAttacher$2, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$android$widget$ImageView$ScaleType = null;

        static {
            int[] r10 = new int[ImageView.ScaleType.values().length];
            $SwitchMap$android$widget$ImageView$ScaleType = r10;
            r10[ImageView.ScaleType.MATRIX.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L14:
            $SwitchMap$android$widget$ImageView$ScaleType[ImageView.ScaleType.FIT_START.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L18:
            $SwitchMap$android$widget$ImageView$ScaleType[ImageView.ScaleType.FIT_END.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L22:
            $SwitchMap$android$widget$ImageView$ScaleType[ImageView.ScaleType.FIT_CENTER.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L16:
            $SwitchMap$android$widget$ImageView$ScaleType[ImageView.ScaleType.FIT_XY.ordinal()] = 5;     // Catch: NoSuchFieldError -> L13
            return;
        }
    }

    public class AnimatedZoomRunnable implements Runnable {
        static final float ANIMATION_SCALE_PER_ITERATION_IN = 1.07f;
        static final float ANIMATION_SCALE_PER_ITERATION_OUT = 0.93f;
        private final float mDeltaScale;
        private final float mFocalX;
        private final float mFocalY;
        private final float mTargetZoom;
        final /* synthetic */ PhotoViewAttacher this$0;

        public AnimatedZoomRunnable(PhotoViewAttacher r10, float r11, float r12, float r13, float r14) {
            this.this$0 = r10;
            this.mTargetZoom = r12;
            this.mFocalX = r13;
            this.mFocalY = r14;
            if (r11 >= r12) goto L5;
            this.mDeltaScale = ANIMATION_SCALE_PER_ITERATION_IN;
            return;
        L5:
            this.mDeltaScale = ANIMATION_SCALE_PER_ITERATION_OUT;
        }

        @Override // java.lang.Runnable
        public void run() {
            ImageView r10 = this.this$0.getImageView();
            if (r10 == null) goto L15;
            Matrix r11 = PhotoViewAttacher.access$200(this.this$0);
            float r12 = this.mDeltaScale;
            r11.postScale(r12, r12, this.mFocalX, this.mFocalY);
            PhotoViewAttacher.access$300(this.this$0);
            float r13 = this.this$0.getScale();
            float r14 = this.mDeltaScale;
            if (r14 <= 1.0f) goto L9;
            if (r13 >= this.mTargetZoom) goto L9;
        L12:
            Compat.postOnAnimation(r10, this);
            return;
        L9:
            if (r14 < 1.0f) goto L11;
        L13:
            float r15 = this.mTargetZoom / r13;
            PhotoViewAttacher.access$200(this.this$0).postScale(r15, r15, this.mFocalX, this.mFocalY);
            PhotoViewAttacher.access$300(this.this$0);
            return;
        L11:
            if (this.mTargetZoom >= r13) goto L13;
        }
    }

    public class FlingRunnable implements Runnable {
        private int mCurrentX;
        private int mCurrentY;
        private final ScrollerProxy mScroller;
        final /* synthetic */ PhotoViewAttacher this$0;

        public FlingRunnable(PhotoViewAttacher r10, Context r11) {
            this.this$0 = r10;
            this.mScroller = ScrollerProxy.getScroller(r11);
        }

        public void cancelFling() {
            j.a("Cancel Fling");
            this.mScroller.forceFinished(true);
        }

        public void fling(int r15, int r16, int r17, int r18) {
            RectF r10 = this.this$0.getDisplayRect();
            if (r10 != null) goto L5;
            return;
        L5:
            int r11 = Math.round(-r10.left);
            float r12 = r15;
            if (r12 >= r10.width()) goto L8;
            int r13 = Math.round(r10.width() - r12);
            int r14 = 0;
        L9:
            int r19 = Math.round(-r10.top);
            float r20 = r16;
            if (r20 >= r10.height()) goto L12;
            int r110 = Math.round(r10.height() - r20);
            int r111 = 0;
        L13:
            this.mCurrentX = r11;
            this.mCurrentY = r19;
            j.a("fling. StartX:" + r11 + " StartY:" + r19 + " MaxX:" + r13 + " MaxY:" + r110);
            if (r11 != r13) goto L16;
            if (r19 != r110) goto L16;
            return;
        L16:
            this.mScroller.fling(r11, r19, r17, r18, r14, r13, r111, r110, 0, 0);
            return;
        L12:
            r111 = r19;
            r110 = r111;
            goto L13
        L8:
            r14 = r11;
            r13 = r14;
            goto L9
        }

        @Override // java.lang.Runnable
        public void run() {
            ImageView r10 = this.this$0.getImageView();
            if (r10 != null) goto L5;
            return;
        L5:
            if (this.mScroller.computeScrollOffset() == false) goto L9;
            int r11 = this.mScroller.getCurrX();
            int r12 = this.mScroller.getCurrY();
            j.a("fling run(). CurrentX:" + this.mCurrentX + " CurrentY:" + this.mCurrentY + " NewX:" + r11 + " NewY:" + r12);
            PhotoViewAttacher.access$200(this.this$0).postTranslate((float) (this.mCurrentX - r11), (float) (this.mCurrentY - r12));
            PhotoViewAttacher r13 = this.this$0;
            PhotoViewAttacher.access$400(r13, r13.getDisplayMatrix());
            this.mCurrentX = r11;
            this.mCurrentY = r12;
            Compat.postOnAnimation(r10, this);
            return;
        }
    }

    public interface OnMatrixChangedListener {
        void onMatrixChanged(RectF r10);
    }

    public interface OnPhotoTapListener {
        void onPhotoTap(View r10, float r11, float r12);
    }

    public interface OnViewTapListener {
        void onViewTap(View r10, float r11, float r12);
    }

    public PhotoViewAttacher(ImageView r10) {
        this.mMinScale = 1.0f;
        this.mMidScale = 1.75f;
        this.mMaxScale = 3.0f;
        this.mAllowParentInterceptOnEdge = true;
        this.mBaseMatrix = new Matrix();
        this.mDrawMatrix = new Matrix();
        this.mSuppMatrix = new Matrix();
        this.mDisplayRect = new RectF();
        this.mMatrixValues = new float[9];
        this.mScrollEdge = 2;
        this.mScaleType = ImageView.ScaleType.FIT_CENTER;
        this.mImageView = new WeakReference(r10);
        r10.setOnTouchListener(this);
        ViewTreeObserver r11 = r10.getViewTreeObserver();
        this.mViewTreeObserver = r11;
        r11.addOnGlobalLayoutListener(this);
        setImageViewScaleTypeMatrix(r10);
        if (r10.isInEditMode() == true) goto L6;
        this.mScaleDragDetector = VersionedGestureDetector.newInstance(r10.getContext(), this);
        GestureDetector r12 = new GestureDetector(r10.getContext(), new AnonymousClass1(this));
        this.mGestureDetector = r12;
        r12.setOnDoubleTapListener(this);
        this.mGestureDetector.setIsLongpressEnabled(false);
        setZoomable(true);
        return;
    }

    public static /* synthetic */ View.OnLongClickListener access$000(PhotoViewAttacher r10) {
        return r10.mLongClickListener;
    }

    public static /* synthetic */ WeakReference access$100(PhotoViewAttacher r10) {
        return r10.mImageView;
    }

    public static /* synthetic */ Matrix access$200(PhotoViewAttacher r10) {
        return r10.mSuppMatrix;
    }

    public static /* synthetic */ void access$300(PhotoViewAttacher r10) {
        r10.checkAndDisplayMatrix();
    }

    public static /* synthetic */ void access$400(PhotoViewAttacher r10, Matrix r11) {
        r10.setImageViewMatrix(r11);
    }

    private void cancelFling() {
        FlingRunnable r10 = this.mCurrentFlingRunnable;
        if (r10 == null) goto L6;
        r10.cancelFling();
        this.mCurrentFlingRunnable = null;
        return;
    }

    private void checkAndDisplayMatrix() {
        checkMatrixBounds();
        setImageViewMatrix(getDisplayMatrix());
    }

    private void checkImageViewScaleType() {
        ImageView r10 = getImageView();
        if (r10 != null) goto L5;
        return;
    L5:
        if ((r10 instanceof PhotoView) == false) goto L7;
        return;
    L7:
        if (r10.getScaleType() != ImageView.ScaleType.MATRIX) goto L10;
        return;
    L10:
        throw new IllegalStateException("The ImageView's ScaleType has been changed since attaching a PhotoViewAttacher");
    }

    private void checkMatrixBounds() {
        ImageView r10 = getImageView();
        if (r10 != null) goto L5;
        return;
    L5:
        RectF r11 = getDisplayRect(getDisplayMatrix());
        if (r11 != null) goto L8;
        return;
    L8:
        float r12 = r11.height();
        float r13 = r11.width();
        float r14 = r10.getHeight();
        float r15 = 0.0f;
        if (r12 > r14) goto L18;
        int r16 = AnonymousClass2.$SwitchMap$android$widget$ImageView$ScaleType[this.mScaleType.ordinal()];
        if (r16 == 2) goto L16;
        if (r16 == 3) goto L15;
        r14 = (r14 - r12) / 2.0f;
        float r17 = r11.top;
    L14:
        float r18 = r14 - r17;
    L25:
        float r19 = r10.getWidth();
        if (r13 > r19) goto L36;
        int r20 = AnonymousClass2.$SwitchMap$android$widget$ImageView$ScaleType[this.mScaleType.ordinal()];
        if (r20 == 2) goto L34;
        if (r20 == 3) goto L33;
        float r21 = (r19 - r13) / 2.0f;
        float r22 = r11.left;
    L31:
        float r23 = r21 - r22;
    L32:
        r15 = r23;
        this.mScrollEdge = 2;
    L43:
        this.mSuppMatrix.postTranslate(r15, r18);
        return;
    L33:
        r21 = r19 - r13;
        r22 = r11.left;
        goto L31
    L34:
        r23 = -r11.left;
        goto L32
    L36:
        float r24 = r11.left;
        if (r24 <= 0.0f) goto L39;
        this.mScrollEdge = 0;
        r15 = -r24;
        goto L43
    L39:
        float r25 = r11.right;
        if (r25 >= r19) goto L42;
        r15 = r19 - r25;
        this.mScrollEdge = 1;
        goto L43
    L42:
        this.mScrollEdge = -1;
        goto L43
    L15:
        r14 = r14 - r12;
        r17 = r11.top;
        goto L14
    L16:
        float r26 = r11.top;
    L17:
        r18 = -r26;
        goto L25
    L18:
        r26 = r11.top;
        if (r26 > 0.0f) goto L17;
        r17 = r11.bottom;
        if (r17 < r14) goto L14;
        r18 = 0.0f;
        goto L25
    }

    private static void checkZoomLevels(float r10, float r11, float r12) {
        if (r10 >= r11) goto L10;
        if (r11 >= r12) goto L8;
        return;
    L8:
        throw new IllegalArgumentException("MidZoom should be less than MaxZoom");
    L10:
        throw new IllegalArgumentException("MinZoom should be less than MidZoom");
    }

    private float getValue(Matrix r10, int r11) {
        r10.getValues(this.mMatrixValues);
        return this.mMatrixValues[r11];
    }

    private static boolean hasDrawable(ImageView r10) {
        if (r10 != null) goto L4;
    L6:
        return false;
    L4:
        if (r10.getDrawable() == null) goto L6;
        return true;
    }

    private static boolean isSupportedScaleType(ImageView.ScaleType r10) {
        if (r10 != null) goto L6;
        return false;
    L6:
        if (AnonymousClass2.$SwitchMap$android$widget$ImageView$ScaleType[r10.ordinal()] == 1) goto L9;
        return true;
    L9:
        throw new IllegalArgumentException(r10.name() + " is not supported in PhotoView");
    }

    private void resetMatrix() {
        this.mSuppMatrix.reset();
        setImageViewMatrix(getDisplayMatrix());
        checkMatrixBounds();
    }

    private void setImageViewMatrix(Matrix r10) {
        ImageView r11 = getImageView();
        if (r11 == null) goto L10;
        checkImageViewScaleType();
        r11.setImageMatrix(r10);
        if (this.mMatrixChangeListener == null) goto L11;
        RectF r12 = getDisplayRect(r10);
        if (r12 == null) goto L12;
        this.mMatrixChangeListener.onMatrixChanged(r12);
        return;
    L12:
        return;
    L11:
        return;
    }

    private static void setImageViewScaleTypeMatrix(ImageView r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        if ((r10 instanceof PhotoView) == true) goto L9;
        r10.setScaleType(ImageView.ScaleType.MATRIX);
        return;
    }

    private void updateBaseMatrix(Drawable r10) {
        ImageView r11 = getImageView();
        if (r11 == null) goto L30;
        if (r10 == null) goto L31;
        float r12 = r11.getWidth();
        float r13 = r11.getHeight();
        int r14 = r10.getIntrinsicWidth();
        int r15 = r10.getIntrinsicHeight();
        this.mBaseMatrix.reset();
        float r16 = r14;
        float r17 = r12 / r16;
        float r18 = r15;
        float r19 = r13 / r18;
        ImageView.ScaleType r20 = this.mScaleType;
        if (r20 != ImageView.ScaleType.CENTER) goto L10;
        this.mBaseMatrix.postTranslate((r12 - r16) / 2.0f, (r13 - r18) / 2.0f);
    L28:
        resetMatrix();
        return;
    L10:
        if (r20 != ImageView.ScaleType.CENTER_CROP) goto L13;
        float r21 = Math.max(r17, r19);
        this.mBaseMatrix.postScale(r21, r21);
        this.mBaseMatrix.postTranslate((r12 - (r16 * r21)) / 2.0f, (r13 - (r18 * r21)) / 2.0f);
        goto L28
    L13:
        if (r20 != ImageView.ScaleType.CENTER_INSIDE) goto L15;
        float r22 = Math.min(1.0f, Math.min(r17, r19));
        this.mBaseMatrix.postScale(r22, r22);
        this.mBaseMatrix.postTranslate((r12 - (r16 * r22)) / 2.0f, (r13 - (r18 * r22)) / 2.0f);
        goto L28
    L15:
        RectF r23 = new RectF(0.0f, 0.0f, r16, r18);
        RectF r24 = new RectF(0.0f, 0.0f, r12, r13);
        int r25 = AnonymousClass2.$SwitchMap$android$widget$ImageView$ScaleType[this.mScaleType.ordinal()];
        if (r25 != 2) goto L18;
        this.mBaseMatrix.setRectToRect(r23, r24, Matrix.ScaleToFit.START);
        goto L28
    L18:
        if (r25 != 3) goto L20;
        this.mBaseMatrix.setRectToRect(r23, r24, Matrix.ScaleToFit.END);
        goto L28
    L20:
        if (r25 != 4) goto L22;
        this.mBaseMatrix.setRectToRect(r23, r24, Matrix.ScaleToFit.CENTER);
        goto L28
    L22:
        if (r25 != 5) goto L28;
        this.mBaseMatrix.setRectToRect(r23, r24, Matrix.ScaleToFit.FILL);
        goto L28
    L31:
        return;
    }

    @Override // com.bytedanceos.common.ui.widget.image.IPhotoView
    public final boolean canZoom() {
        return this.mZoomEnabled;
    }

    public final void cleanup() {
        WeakReference<ImageView> r10 = this.mImageView;
        if (r10 == null) goto L5;
        r10.get().getViewTreeObserver().removeGlobalOnLayoutListener(this);
    L5:
        this.mViewTreeObserver = null;
        this.mMatrixChangeListener = null;
        this.mPhotoTapListener = null;
        this.mViewTapListener = null;
        this.mImageView = null;
    }

    public Matrix getDisplayMatrix() {
        this.mDrawMatrix.set(this.mBaseMatrix);
        this.mDrawMatrix.postConcat(this.mSuppMatrix);
        return this.mDrawMatrix;
    }

    @Override // com.bytedanceos.common.ui.widget.image.IPhotoView
    public final RectF getDisplayRect() {
        checkMatrixBounds();
        return getDisplayRect(getDisplayMatrix());
    }

    public final ImageView getImageView() {
        WeakReference<ImageView> r10 = this.mImageView;
        if (r10 == null) goto L5;
        ImageView r11 = r10.get();
    L6:
        if (r11 != null) goto L8;
        cleanup();
    L8:
        return r11;
    L5:
        r11 = null;
        goto L6
    }

    @Override // com.bytedanceos.common.ui.widget.image.IPhotoView
    public float getMaxScale() {
        return this.mMaxScale;
    }

    @Override // com.bytedanceos.common.ui.widget.image.IPhotoView
    public float getMidScale() {
        return this.mMidScale;
    }

    @Override // com.bytedanceos.common.ui.widget.image.IPhotoView
    public float getMinScale() {
        return this.mMinScale;
    }

    @Override // com.bytedanceos.common.ui.widget.image.IPhotoView
    public final float getScale() {
        return getValue(this.mSuppMatrix, 0);
    }

    @Override // com.bytedanceos.common.ui.widget.image.IPhotoView
    public final ImageView.ScaleType getScaleType() {
        return this.mScaleType;
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public final boolean onDoubleTap(MotionEvent r10) {
        float r11 = getScale();     // Catch: ArrayIndexOutOfBoundsException -> L13
        float r12 = r10.getX();     // Catch: ArrayIndexOutOfBoundsException -> L13
        float r13 = r10.getY();     // Catch: ArrayIndexOutOfBoundsException -> L13
        float r14 = this.mMidScale;     // Catch: ArrayIndexOutOfBoundsException -> L13
        if (r11 >= r14) goto L6;
        zoomTo(r14, r12, r13);     // Catch: ArrayIndexOutOfBoundsException -> L13
    L14:
        return true;
    L6:
        if (r11 < r14) goto L10;
        float r15 = this.mMaxScale;     // Catch: ArrayIndexOutOfBoundsException -> L13
        if (r11 >= r15) goto L10;
        zoomTo(r15, r12, r13);     // Catch: ArrayIndexOutOfBoundsException -> L13
    L10:
        zoomTo(this.mMinScale, r12, r13);     // Catch: ArrayIndexOutOfBoundsException -> L13
    L17:
        return true;
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public final boolean onDoubleTapEvent(MotionEvent r10) {
        return false;
    }

    @Override // com.bytedanceos.common.ui.widget.image.VersionedGestureDetector.OnGestureListener
    public final void onDrag(float r10, float r11) {
        j.a(String.format("onDrag: dx: %.2f. dy: %.2f", new Object[]{Float.valueOf(r10), Float.valueOf(r11)}));
        ImageView r12 = getImageView();
        if (r12 != null) goto L5;
        return;
    L5:
        if (hasDrawable(r12) == false) goto L22;
        this.mSuppMatrix.postTranslate(r10, r11);
        checkAndDisplayMatrix();
        if (this.mAllowParentInterceptOnEdge == true) goto L9;
        return;
    L9:
        if (this.mScaleDragDetector.isScaling() == true) goto L24;
        int r13 = this.mScrollEdge;
        if (r13 == 2) goto L19;
        if (r13 != 0) goto L16;
        if (r10 >= 1.0f) goto L19;
    L16:
        if (r13 == 1) goto L18;
        return;
    L18:
        if (r10 <= (-1.0f)) goto L19;
        return;
    L19:
        r12.getParent().requestDisallowInterceptTouchEvent(false);
        return;
    L24:
        return;
    }

    @Override // com.bytedanceos.common.ui.widget.image.VersionedGestureDetector.OnGestureListener
    public final void onFling(float r10, float r11, float r12, float r13) {
        j.a("onFling. sX: " + r10 + " sY: " + r11 + " Vx: " + r12 + " Vy: " + r13);
        ImageView r14 = getImageView();
        if (hasDrawable(r14) == false) goto L6;
        FlingRunnable r15 = new FlingRunnable(this, r14.getContext());
        this.mCurrentFlingRunnable = r15;
        r15.fling(r14.getWidth(), r14.getHeight(), (int) r12, (int) r13);
        r14.post(this.mCurrentFlingRunnable);
        return;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        ImageView r10 = getImageView();
        if (r10 != null) goto L5;
        return;
    L5:
        if (this.mZoomEnabled == false) goto L17;
        int r11 = r10.getTop();
        int r12 = r10.getRight();
        int r13 = r10.getBottom();
        int r14 = r10.getLeft();
        if (r11 == this.mIvTop) goto L9;
    L14:
        updateBaseMatrix(r10.getDrawable());
        this.mIvTop = r11;
        this.mIvRight = r12;
        this.mIvBottom = r13;
        this.mIvLeft = r14;
        return;
    L9:
        if (r13 != this.mIvBottom) goto L14;
        if (r14 != this.mIvLeft) goto L14;
        if (r12 != this.mIvRight) goto L14;
        return;
    }

    @Override // com.bytedanceos.common.ui.widget.image.VersionedGestureDetector.OnGestureListener
    public final void onScale(float r10, float r11, float r12) {
        j.a(String.format("onScale: scale: %.2f. fX: %.2f. fY: %.2f", new Object[]{Float.valueOf(r10), Float.valueOf(r11), Float.valueOf(r12)}));
        if (hasDrawable(getImageView()) == true) goto L5;
        return;
    L5:
        if (getScale() >= this.mMaxScale) goto L7;
    L8:
        this.mSuppMatrix.postScale(r10, r10, r11, r12);
        checkAndDisplayMatrix();
        return;
    L7:
        if (r10 < 1.0f) goto L8;
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public final boolean onSingleTapConfirmed(MotionEvent r10) {
        ImageView r11 = getImageView();
        if (r11 != null) goto L5;
        return false;
    L5:
        if (this.mPhotoTapListener == null) goto L12;
        RectF r12 = getDisplayRect();
        if (r12 == null) goto L12;
        float r13 = r10.getX();
        float r14 = r10.getY();
        if (r12.contains(r13, r14) == false) goto L12;
        float r15 = (r13 - r12.left) / r12.width();
        float r16 = (r14 - r12.top) / r12.height();
        this.mPhotoTapListener.onPhotoTap(r11, r15, r16);
        return true;
    L12:
        OnViewTapListener r17 = this.mViewTapListener;
        if (r17 == null) goto L18;
        r17.onViewTap(r11, r10.getX(), r10.getY());
        return false;
    L18:
        return false;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r10, MotionEvent r11) {
        boolean r12 = false;
        if (this.mZoomEnabled == false) goto L27;
        int r13 = r11.getAction();
        if (r13 == 0) goto L15;
        if (r13 == 1) goto L11;
        if (r13 == 3) goto L11;
    L16:
        GestureDetector r14 = this.mGestureDetector;
        if (r14 != null) goto L19;
    L21:
        VersionedGestureDetector r15 = this.mScaleDragDetector;
        if (r15 != null) goto L24;
        return r12;
    L24:
        if (r15.onTouchEvent(r11) == true) goto L26;
        return r12;
    L26:
        return true;
    L19:
        if (r14.onTouchEvent(r11) == false) goto L21;
        r12 = true;
    L11:
        if (getScale() >= this.mMinScale) goto L16;
        RectF r16 = getDisplayRect();
        if (r16 == null) goto L16;
        r10.post(new AnimatedZoomRunnable(this, getScale(), this.mMinScale, r16.centerX(), r16.centerY()));
        r12 = true;
        goto L16
    L15:
        r10.getParent().requestDisallowInterceptTouchEvent(true);
        cancelFling();
        goto L16
    L27:
        return false;
    }

    @Override // com.bytedanceos.common.ui.widget.image.IPhotoView
    public void setAllowParentInterceptOnEdge(boolean r10) {
        this.mAllowParentInterceptOnEdge = r10;
    }

    @Override // com.bytedanceos.common.ui.widget.image.IPhotoView
    public void setMaxScale(float r10) {
        checkZoomLevels(this.mMinScale, this.mMidScale, r10);
        this.mMaxScale = r10;
    }

    @Override // com.bytedanceos.common.ui.widget.image.IPhotoView
    public void setMidScale(float r10) {
        checkZoomLevels(this.mMinScale, r10, this.mMaxScale);
        this.mMidScale = r10;
    }

    @Override // com.bytedanceos.common.ui.widget.image.IPhotoView
    public void setMinScale(float r10) {
        checkZoomLevels(r10, this.mMidScale, this.mMaxScale);
        this.mMinScale = r10;
    }

    @Override // com.bytedanceos.common.ui.widget.image.IPhotoView
    public final void setOnLongClickListener(View.OnLongClickListener r10) {
        this.mLongClickListener = r10;
    }

    @Override // com.bytedanceos.common.ui.widget.image.IPhotoView
    public final void setOnMatrixChangeListener(OnMatrixChangedListener r10) {
        this.mMatrixChangeListener = r10;
    }

    @Override // com.bytedanceos.common.ui.widget.image.IPhotoView
    public final void setOnPhotoTapListener(OnPhotoTapListener r10) {
        this.mPhotoTapListener = r10;
    }

    @Override // com.bytedanceos.common.ui.widget.image.IPhotoView
    public final void setOnViewTapListener(OnViewTapListener r10) {
        this.mViewTapListener = r10;
    }

    @Override // com.bytedanceos.common.ui.widget.image.IPhotoView
    public final void setScaleType(ImageView.ScaleType r10) {
        if (isSupportedScaleType(r10) == true) goto L5;
        return;
    L5:
        if (r10 == this.mScaleType) goto L9;
        this.mScaleType = r10;
        update();
        return;
    }

    @Override // com.bytedanceos.common.ui.widget.image.IPhotoView
    public final void setZoomable(boolean r10) {
        this.mZoomEnabled = r10;
        update();
    }

    public final void update() {
        ImageView r10 = getImageView();
        if (r10 != null) goto L5;
        return;
    L5:
        if (this.mZoomEnabled == false) goto L7;
        setImageViewScaleTypeMatrix(r10);
        updateBaseMatrix(r10.getDrawable());
        return;
    L7:
        resetMatrix();
    }

    @Override // com.bytedanceos.common.ui.widget.image.IPhotoView
    public final void zoomTo(float r10, float r11, float r12) {
        ImageView r13 = getImageView();
        if (r13 == null) goto L6;
        r13.post(new AnimatedZoomRunnable(this, getScale(), r10, r11, r12));
        return;
    }

    private RectF getDisplayRect(Matrix r10) {
        ImageView r11 = getImageView();
        if (r11 == null) goto L8;
        Drawable r12 = r11.getDrawable();
        if (r12 == null) goto L10;
        this.mDisplayRect.set(0.0f, 0.0f, r12.getIntrinsicWidth(), r12.getIntrinsicHeight());
        r10.mapRect(this.mDisplayRect);
        return this.mDisplayRect;
    L10:
        return null;
    L8:
        return null;
    }
}
