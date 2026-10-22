package com.bytedance.android.ui.ec.widget.photodraweeview;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;
import android.view.MotionEvent;
import com.bytedance.android.ui.ec.widget.photodraweeview.gestures.GestureListener;
import com.bytedance.android.ui.ec.widget.photodraweeview.gestures.TransformGestureDetector;

/* JADX INFO: loaded from: classes14.dex */
public abstract class ABSZoomableController implements ZoomableController, GestureListener<TransformGestureDetector> {
    private static final float DEFAULT_MIN_SCALE_FACTOR = 1.0f;
    protected static final float EPS = 0.001f;
    private static final float SCALE_FACTOR_UNDEFINE = 0.0f;
    private final Matrix mActiveTransform;
    private final Matrix mActiveTransformInverse;
    private TransformGestureDetector mGestureDetector;
    private final RectF mImageBounds;
    private ImageBoundsListener mImageBoundsListener;
    private boolean mIsEnabled;
    private boolean mIsScaleEnabled;
    private boolean mIsTranslationEnabled;
    private ZoomableController.Listener mListener;
    private float mMaxScaleFactor;
    private float mMinScaleFactor;
    private float mRecommendedMaxScaleFactor;
    private final float[] mTempValues;
    private final RectF mTransformedImageBounds;
    private final RectF mViewBounds;

    public interface ImageBoundsListener {
        void onImageBoundsSet(RectF r100);
    }

    @Override // com.bytedance.android.ui.ec.widget.photodraweeview.ZoomableController
    public void computeScroll() {
    }

    /* JADX INFO: renamed from: onGestureBegin, reason: avoid collision after fix types in other method */
    public void onGestureBegin2(TransformGestureDetector r100) {
    }

    /* JADX INFO: renamed from: onGestureEnd, reason: avoid collision after fix types in other method */
    public void onGestureEnd2(TransformGestureDetector r100) {
    }

    @Override // com.bytedance.android.ui.ec.widget.photodraweeview.ZoomableController
    public int computeHorizontalScrollExtent() {
        return (int) this.mViewBounds.width();
    }

    @Override // com.bytedance.android.ui.ec.widget.photodraweeview.ZoomableController
    public int computeHorizontalScrollOffset() {
        return (int) (this.mViewBounds.left - this.mTransformedImageBounds.left);
    }

    @Override // com.bytedance.android.ui.ec.widget.photodraweeview.ZoomableController
    public int computeHorizontalScrollRange() {
        return (int) this.mTransformedImageBounds.width();
    }

    @Override // com.bytedance.android.ui.ec.widget.photodraweeview.ZoomableController
    public int computeVerticalScrollExtent() {
        return (int) this.mViewBounds.height();
    }

    @Override // com.bytedance.android.ui.ec.widget.photodraweeview.ZoomableController
    public int computeVerticalScrollOffset() {
        return (int) (this.mViewBounds.top - this.mTransformedImageBounds.top);
    }

    @Override // com.bytedance.android.ui.ec.widget.photodraweeview.ZoomableController
    public int computeVerticalScrollRange() {
        return (int) this.mTransformedImageBounds.height();
    }

    public float getMaxScaleFactor() {
        float r100 = this.mMaxScaleFactor;
        if (r100 == 0.0f) goto L5;
        return r100;
    L5:
        return this.mRecommendedMaxScaleFactor;
    }

    @Override // com.bytedance.android.ui.ec.widget.photodraweeview.ZoomableController
    public float getScaleFactor() {
        return getMatrixScaleFactor(this.mActiveTransform);
    }

    @Override // com.bytedance.android.ui.ec.widget.photodraweeview.ZoomableController
    public boolean isIdentity() {
        return isMatrixIdentity(this.mActiveTransform, 0.001f);
    }

    public boolean isImageInBottomEdge() {
        if (Math.abs(this.mTransformedImageBounds.bottom - this.mViewBounds.bottom) >= 0.001f) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isImageInLeftEdge() {
        if (Math.abs(this.mTransformedImageBounds.left - this.mViewBounds.left) >= 0.001f) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isImageInRightEdge() {
        if (Math.abs(this.mTransformedImageBounds.right - this.mViewBounds.right) >= 0.001f) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isImageInTopEdge() {
        if (Math.abs(this.mTransformedImageBounds.top - this.mViewBounds.top) >= 0.001f) goto L5;
        return true;
    L5:
        return false;
    }

    public void onTransformChanged() {
        this.mActiveTransform.mapRect(this.mTransformedImageBounds, this.mImageBounds);
        if (this.mListener != null) goto L5;
        return;
    L5:
        if (isEnabled() == false) goto L9;
        this.mListener.onTransformChanged(this.mActiveTransform);
        return;
    }

    public void reset() {
        this.mActiveTransform.reset();
        onTransformChanged();
    }

    private void updateRecommendedMaxScale() {
        RectF r100 = getViewBounds();
        RectF r101 = getImageBounds();
        if (r101.width() <= r100.width()) goto L5;
    L8:
        this.mRecommendedMaxScaleFactor = Math.max(r101.width() / r100.width(), r101.height() / r100.height());
        return;
    L5:
        if (r101.height() > r100.height()) goto L8;
        this.mRecommendedMaxScaleFactor = Math.max(r100.width() / r101.width(), r100.height() / r101.height());
    }

    @Override // com.bytedance.android.ui.ec.widget.photodraweeview.ZoomableController
    public Matrix getActiveTransform() {
        return this.mActiveTransform;
    }

    public TransformGestureDetector getDetector() {
        return this.mGestureDetector;
    }

    public RectF getImageBounds() {
        return this.mImageBounds;
    }

    public ImageBoundsListener getImageBoundsListener() {
        return this.mImageBoundsListener;
    }

    public ZoomableController.Listener getListener() {
        return this.mListener;
    }

    public float getMinScaleFactor() {
        return this.mMinScaleFactor;
    }

    public RectF getTransformedImageBounds() {
        return this.mTransformedImageBounds;
    }

    public RectF getViewBounds() {
        return this.mViewBounds;
    }

    @Override // com.bytedance.android.ui.ec.widget.photodraweeview.ZoomableController
    public boolean isEnabled() {
        return this.mIsEnabled;
    }

    public boolean isScaleEnabled() {
        return this.mIsScaleEnabled;
    }

    public boolean isTranslationEnabled() {
        return this.mIsTranslationEnabled;
    }

    public ABSZoomableController(TransformGestureDetector r100) {
        this.mListener = null;
        this.mIsEnabled = false;
        this.mIsScaleEnabled = true;
        this.mIsTranslationEnabled = true;
        this.mMinScaleFactor = 1.0f;
        this.mMaxScaleFactor = 0.0f;
        this.mRecommendedMaxScaleFactor = 0.0f;
        this.mViewBounds = new RectF();
        this.mImageBounds = new RectF();
        this.mTransformedImageBounds = new RectF();
        this.mActiveTransform = new Matrix();
        this.mActiveTransformInverse = new Matrix();
        this.mTempValues = new float[9];
        this.mGestureDetector = r100;
        r100.addListener(this);
    }

    public float getMatrixScaleFactor(Matrix r100) {
        r100.getValues(this.mTempValues);
        return this.mTempValues[0];
    }

    public PointF mapViewToImage(PointF r110) {
        float[] r100 = this.mTempValues;
        r100[0] = r110.x;
        r100[1] = r110.y;
        this.mActiveTransform.invert(this.mActiveTransformInverse);
        this.mActiveTransformInverse.mapPoints(r100, 0, r100, 0, 1);
        return new PointF(r100[0], r100[1]);
    }

    @Override // com.bytedance.android.ui.ec.widget.photodraweeview.gestures.GestureListener
    public /* bridge */ /* synthetic */ void onGestureBegin(TransformGestureDetector r100) {
        onGestureBegin2(r100);
    }

    @Override // com.bytedance.android.ui.ec.widget.photodraweeview.gestures.GestureListener
    public /* bridge */ /* synthetic */ void onGestureEnd(TransformGestureDetector r100) {
        onGestureEnd2(r100);
    }

    @Override // com.bytedance.android.ui.ec.widget.photodraweeview.gestures.GestureListener
    public /* bridge */ /* synthetic */ void onGestureUpdate(TransformGestureDetector r100) {
        onGestureUpdate2(r100);
    }

    @Override // com.bytedance.android.ui.ec.widget.photodraweeview.ZoomableController
    public boolean onTouchEvent(MotionEvent r100) {
        if (this.mIsEnabled == true) goto L5;
        return false;
    L5:
        return this.mGestureDetector.onTouchEvent(r100);
    }

    @Override // com.bytedance.android.ui.ec.widget.photodraweeview.ZoomableController
    public void setEnabled(boolean r100) {
        this.mIsEnabled = r100;
        if (r100 == true) goto L6;
        reset();
        return;
    }

    @Override // com.bytedance.android.ui.ec.widget.photodraweeview.ZoomableController
    public void setImageBounds(RectF r100) {
        if (r100.equals(this.mImageBounds) == true) goto L8;
        this.mImageBounds.set(r100);
        updateRecommendedMaxScale();
        onTransformChanged();
        ImageBoundsListener r101 = this.mImageBoundsListener;
        if (r101 == null) goto L9;
        r101.onImageBoundsSet(this.mImageBounds);
        return;
    L9:
        return;
    }

    public void setImageBoundsListener(ImageBoundsListener r100) {
        this.mImageBoundsListener = r100;
    }

    @Override // com.bytedance.android.ui.ec.widget.photodraweeview.ZoomableController
    public void setListener(ZoomableController.Listener r100) {
        this.mListener = r100;
    }

    public void setMaxScaleFactor(float r100) {
        if (r100 >= 1.0f) goto L5;
        return;
    L5:
        if (r100 < this.mMinScaleFactor) goto L10;
        this.mMaxScaleFactor = r100;
        return;
    }

    public void setMinScaleFactor(float r100) {
        if (r100 >= 1.0f) goto L5;
        return;
    L5:
        if (r100 > this.mMaxScaleFactor) goto L10;
        this.mMinScaleFactor = r100;
        return;
    }

    public void setScaleEnabled(boolean r100) {
        this.mIsScaleEnabled = r100;
    }

    public void setTransform(Matrix r100) {
        this.mActiveTransform.set(r100);
        onTransformChanged();
    }

    public void setTranslationEnabled(boolean r100) {
        this.mIsTranslationEnabled = r100;
    }

    @Override // com.bytedance.android.ui.ec.widget.photodraweeview.ZoomableController
    public void setViewBounds(RectF r100) {
        this.mViewBounds.set(r100);
        updateRecommendedMaxScale();
    }

    /* JADX INFO: renamed from: onGestureUpdate, reason: avoid collision after fix types in other method */
    public void onGestureUpdate2(TransformGestureDetector r100) {
        onTransformChanged();
    }

    private boolean isMatrixIdentity(Matrix r100, float r101) {
        r100.getValues(this.mTempValues);
        float[] r102 = this.mTempValues;
        r102[0] = r102[0] - 1.0f;
        r102[4] = r102[4] - 1.0f;
        r102[8] = r102[8] - 1.0f;
        int r103 = 0;
    L4:
        if (r103 >= 9) goto L9;
        if (Math.abs(this.mTempValues[r103]) > r101) goto L7;
        r103 = r103 + 1;
        goto L4
    L7:
        return false;
    L9:
        return true;
    }
}
