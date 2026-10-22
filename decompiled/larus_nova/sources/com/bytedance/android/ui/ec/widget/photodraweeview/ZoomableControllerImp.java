package com.bytedance.android.ui.ec.widget.photodraweeview;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.animation.DecelerateInterpolator;
import android.widget.Scroller;
import com.bytedance.android.ui.ec.widget.photodraweeview.gestures.TransformGestureDetector;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes14.dex */
public class ZoomableControllerImp extends ABSZoomableController {
    public static final long DEFAULT_ANIMATION_DURATION = 400;
    public static final int LIMIT_ALL = 7;
    public static final int LIMIT_NONE = 0;
    public static final int LIMIT_SCALE = 4;
    public static final int LIMIT_TRANSLATION_X = 1;
    public static final int LIMIT_TRANSLATION_Y = 2;
    private long animationDuration;
    private Runnable enableGestureWhenCompleted;
    private final Matrix mAnimeWorkingTransform;
    private Context mContext;
    private final float[] mCurrentValues;
    private boolean mDisableGesture;
    private final Matrix mFlingStartTempTransform;
    private boolean mHorizontalNestedScrollEnabled;
    private final Matrix mNewTransform;
    private Scroller mScroller;
    private final float[] mStartValues;
    private final float[] mStopValues;
    private final RectF mTempRect;
    private final ValueAnimator mValueAnimator;

    @Retention(RetentionPolicy.SOURCE)
    public @interface LimitFlag {
    }

    public static /* synthetic */ void a(ZoomableControllerImp r100, Runnable r101) {
        r100.lambda$zoomToPoint$1(r101);
    }

    public static /* synthetic */ void b(ZoomableControllerImp r100) {
        r100.lambda$new$0();
    }

    public static /* synthetic */ void c(ZoomableControllerImp r100, ValueAnimator.AnimatorUpdateListener r101, ValueAnimator r102) {
        r100.lambda$setTransformAnimated$2(r101, r102);
    }

    private /* synthetic */ void lambda$new$0() {
        setDisableGesture(false);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.android.ui.ec.widget.photodraweeview.ABSZoomableController
    public void onGestureEnd(TransformGestureDetector r100) {
    }

    @Override // com.bytedance.android.ui.ec.widget.photodraweeview.ABSZoomableController, com.bytedance.android.ui.ec.widget.photodraweeview.ZoomableController
    public void computeScroll() {
        if (this.mScroller.computeScrollOffset() == false) goto L6;
        int r100 = this.mScroller.getCurrX();
        int r101 = this.mScroller.getCurrY();
        this.mNewTransform.set(this.mFlingStartTempTransform);
        calculateTranslateToPointTransform(this.mNewTransform, r100, r101);
        setTransformImmediate(this.mNewTransform);
        return;
    }

    public boolean isAnimating() {
        return this.mValueAnimator.isRunning();
    }

    public boolean isAnimatingOrScrolling() {
        if (this.mValueAnimator.isRunning() == false) goto L5;
    L8:
        return true;
    L5:
        if (this.mScroller.computeScrollOffset() == true) goto L8;
        return false;
    }

    public boolean isScrolling() {
        return this.mScroller.computeScrollOffset();
    }

    public void trySpringBack() {
        this.mNewTransform.set(getActiveTransform());
        RectF r100 = getViewBounds();
        if ((limitScale(this.mNewTransform, r100.centerX(), r100.centerY()) | limitTranslation(this.mNewTransform)) == false) goto L6;
        setDisableGesture(true);
        setTransformAnimated(this.mNewTransform, this.animationDuration, this.enableGestureWhenCompleted, null);
        return;
    }

    @Override // com.bytedance.android.ui.ec.widget.photodraweeview.ABSZoomableController, com.bytedance.android.ui.ec.widget.photodraweeview.ZoomableController
    public boolean isIdentity() {
        if (isAnimatingOrScrolling() == false) goto L5;
    L7:
        return false;
    L5:
        if (super.isIdentity() == false) goto L7;
        return true;
    }

    public boolean isImageOutTopEdge() {
        if ((getViewBounds().top - getTransformedImageBounds().top) <= 0.001f) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isParentScrollEnabled() {
        if (isHorizontalNestedScrollEnabled() == false) goto L18;
        TransformGestureDetector r100 = getDetector();
        if (isImageInLeftEdge() == true) goto L9;
        if (isIdentity() == true) goto L9;
    L12:
        if (isImageInRightEdge() == true) goto L16;
        if (isIdentity() == true) goto L16;
        return false;
    L16:
        if (r100.getGestureIntent() != 1) goto L21;
        return true;
    L21:
        return false;
    L9:
        if (r100.getGestureIntent() != 3) goto L12;
        return true;
    L18:
        return false;
    }

    @Override // com.bytedance.android.ui.ec.widget.photodraweeview.ABSZoomableController
    public void reset() {
        stopAnimatingAndScrolling();
        this.mAnimeWorkingTransform.reset();
        this.mNewTransform.reset();
        super.reset();
    }

    public void stopAnimating() {
        if (isAnimating() == false) goto L6;
        this.mValueAnimator.cancel();
        this.mValueAnimator.removeAllUpdateListeners();
        this.mValueAnimator.removeAllListeners();
        return;
    }

    public void stopAnimatingAndScrolling() {
        stopAnimating();
        stopScrolling();
    }

    public void stopScrolling() {
        if (isScrolling() == false) goto L6;
        this.mScroller.forceFinished(true);
        return;
    }

    public long getAnimationDuration() {
        return this.animationDuration;
    }

    public Matrix getAnimeWorkingTransform() {
        return this.mAnimeWorkingTransform;
    }

    public boolean isDisableGesture() {
        return this.mDisableGesture;
    }

    public boolean isHorizontalNestedScrollEnabled() {
        return this.mHorizontalNestedScrollEnabled;
    }

    public static /* synthetic */ ValueAnimator access$000(ZoomableControllerImp r100) {
        return r100.mValueAnimator;
    }

    private /* synthetic */ void lambda$zoomToPoint$1(Runnable r100) {
        setDisableGesture(false);
        if (r100 == null) goto L6;
        r100.run();
        return;
    }

    private void setTransformImmediate(Matrix r100) {
        if (isAnimating() == false) goto L5;
        stopAnimating();
    L5:
        this.mAnimeWorkingTransform.set(r100);
        super.setTransform(r100);
    }

    public boolean calculateGestureTransform(Matrix r100) {
        TransformGestureDetector r101 = getDetector();
        r100.set(getActiveTransform());
        if (isTranslationEnabled() == false) goto L6;
        r100.postTranslate(r101.getDeltaTranslationX(), r101.getDeltaTranslationY());
    L6:
        if (isScaleEnabled() == false) goto L11;
        if (r101.isMultiPointer() == false) goto L11;
        r100.postScale(r101.getDeltaScale(), r101.getDeltaScale(), r101.getPivotX(), r101.getPivotY());
    L11:
        if (r101.isSinglePointer() == false) goto L13;
    L14:
        limitTranslation(r100);
        return true;
    L13:
        if (isScaleEnabled() == false) goto L14;
        return true;
    }

    public boolean limitTranslation(Matrix r110) {
        RectF r100 = this.mTempRect;
        RectF r101 = getImageBounds();
        RectF r102 = getViewBounds();
        r100.set(r101);
        r110.mapRect(r100);
        float r103 = getOffset(r100.left, r100.right, r102.left, r102.right, r101.centerX());
        float r104 = getOffset(r100.top, r100.bottom, r102.top, r102.bottom, r101.centerY());
        if (r103 == 0.0f) goto L5;
    L9:
        r110.postTranslate(r103, r104);
        return true;
    L5:
        if (r104 != 0.0f) goto L9;
        return false;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.android.ui.ec.widget.photodraweeview.ABSZoomableController
    public void onGestureBegin(TransformGestureDetector r100) {
        if (this.mDisableGesture == false) goto L5;
        return;
    L5:
        stopAnimatingAndScrolling();
    }

    @Override // com.bytedance.android.ui.ec.widget.photodraweeview.ABSZoomableController, com.bytedance.android.ui.ec.widget.photodraweeview.gestures.GestureListener
    public /* bridge */ /* synthetic */ void onGestureEnd(TransformGestureDetector r100) {
        onGestureEnd(r100);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.android.ui.ec.widget.photodraweeview.ABSZoomableController
    public void onGestureUpdate(TransformGestureDetector r100) {
        if (this.mDisableGesture == false) goto L6;
        return;
    L6:
        if (isAnimatingOrScrolling() == false) goto L9;
        return;
    L9:
        if (r100.isPointerCountChanged() == true) goto L11;
    L13:
        calculateGestureTransform(getActiveTransform());
        onTransformChanged();
        return;
    L11:
        if (r100.isSinglePointer() == false) goto L13;
        trySpringBack();
    }

    @Override // com.bytedance.android.ui.ec.widget.photodraweeview.ABSZoomableController, com.bytedance.android.ui.ec.widget.photodraweeview.ZoomableController
    public boolean onTouchEvent(MotionEvent r100) {
        if (r100.getAction() != 3) goto L7;
        return super.onTouchEvent(r100);
    L7:
        if (isParentScrollEnabled() == false) goto L11;
        return false;
    L11:
        return super.onTouchEvent(r100);
    }

    public void setAnimationDuration(long r100) {
        this.animationDuration = r100;
    }

    public void setDisableGesture(boolean r100) {
        this.mDisableGesture = r100;
    }

    public void setHorizontalNestedScrollEnabled(boolean r100) {
        this.mHorizontalNestedScrollEnabled = r100;
    }

    @Override // com.bytedance.android.ui.ec.widget.photodraweeview.ABSZoomableController, com.bytedance.android.ui.ec.widget.photodraweeview.gestures.GestureListener
    public /* bridge */ /* synthetic */ void onGestureBegin(TransformGestureDetector r100) {
        onGestureBegin(r100);
    }

    @Override // com.bytedance.android.ui.ec.widget.photodraweeview.ABSZoomableController, com.bytedance.android.ui.ec.widget.photodraweeview.gestures.GestureListener
    public /* bridge */ /* synthetic */ void onGestureUpdate(TransformGestureDetector r100) {
        onGestureUpdate(r100);
    }

    public ZoomableControllerImp(TransformGestureDetector r100, Context r101) {
        super(r100);
        this.mStartValues = new float[9];
        this.mStopValues = new float[9];
        this.mCurrentValues = new float[9];
        this.mNewTransform = new Matrix();
        this.mAnimeWorkingTransform = new Matrix();
        this.mFlingStartTempTransform = new Matrix();
        this.mHorizontalNestedScrollEnabled = false;
        this.animationDuration = 400;
        this.enableGestureWhenCompleted = new c(this);
        this.mTempRect = new RectF();
        this.mDisableGesture = false;
        ValueAnimator r102 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.mValueAnimator = r102;
        r102.setInterpolator(new DecelerateInterpolator(1.2f));
        this.mContext = r101;
        this.mScroller = new Scroller(this.mContext);
    }

    private /* synthetic */ void lambda$setTransformAnimated$2(ValueAnimator.AnimatorUpdateListener r100, ValueAnimator r101) {
        calculateInterpolation(this.mAnimeWorkingTransform, ((Float) r101.getAnimatedValue()).floatValue());
        setTransform(this.mAnimeWorkingTransform);
        if (r100 == null) goto L6;
        r100.onAnimationUpdate(r101);
        return;
    }

    public void calculateInterpolation(Matrix r100, float r101) {
        int r102 = 0;
    L4:
        if (r102 >= 9) goto L6;
        this.mCurrentValues[r102] = ((1.0f - r101) * this.mStartValues[r102]) + (this.mStopValues[r102] * r101);
        r102 = r102 + 1;
        goto L4
    L6:
        r100.setValues(this.mCurrentValues);
    }

    public void fling(int r110, int r111) {
        if (isAnimating() == false) goto L5;
        return;
    L5:
        if (isTranslationEnabled() == true) goto L8;
        return;
    L8:
        if (isScrolling() == false) goto L10;
        stopScrolling();
    L10:
        this.mScroller.fling(0, 0, r110, r111, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
        this.mFlingStartTempTransform.set(getActiveTransform());
        setTransform(getActiveTransform());
    }

    public void calculateTranslateToPointTransform(Matrix r100, float r101, float r102) {
        r100.postTranslate(r101, r102);
        limitTranslation(r100);
    }

    public void calculateZoomToPointTransform(Matrix r100, float r101, PointF r102) {
        PointF r103 = mapViewToImage(r102);
        r100.setScale(r101, r101, r103.x, r103.y);
        limitScale(r100, r103.x, r103.y);
        limitTranslation(r100);
    }

    public boolean limitScale(Matrix r100, float r101, float r102) {
        float r103 = getMatrixScaleFactor(r100);
        float r104 = Math.min(Math.max(getMinScaleFactor(), r103), getMaxScaleFactor());
        if (r104 == r103) goto L6;
        float r105 = r104 / r103;
        r100.postScale(r105, r105, r101, r102);
        return true;
    L6:
        return false;
    }

    public void setTransformAnimated(Matrix r100, long r101, final Runnable r102, final ValueAnimator.AnimatorUpdateListener r103) {
        if (isAnimating() == false) goto L5;
        stopAnimating();
    L5:
        this.mValueAnimator.setDuration(r101);
        getActiveTransform().getValues(this.mStartValues);
        r100.getValues(this.mStopValues);
        this.mValueAnimator.addUpdateListener(new a(this, r103));
        this.mValueAnimator.addListener(new AnonymousClass1(this, r102));
        this.mValueAnimator.start();
    }

    public void zoomToPoint(float r100, PointF r101, final Runnable r110, ValueAnimator.AnimatorUpdateListener r111) {
        if (isScaleEnabled() == true) goto L6;
        return;
    L6:
        if (isAnimating() == false) goto L8;
        stopAnimating();
    L8:
        setDisableGesture(true);
        Runnable r102 = new b(this, r110);
        this.mNewTransform.reset();
        calculateZoomToPointTransform(this.mNewTransform, r100, r101);
        setTransformAnimated(this.mNewTransform, getAnimationDuration(), r102, r111);
    }

    public float getOffset(float r100, float r101, float r102, float r103, float r104) {
        float r105 = r101 - r100;
        float r106 = r103 - r102;
        if (r105 >= (Math.min(r104 - r102, r103 - r104) * 2.0f)) goto L7;
        return r104 - ((r101 + r100) / 2.0f);
    L7:
        if (r105 >= r106) goto L15;
        if (r104 >= ((r102 + r103) / 2.0f)) goto L13;
        return r102 - r100;
    L13:
        return r103 - r101;
    L15:
        if (r100 <= r102) goto L19;
        return r102 - r100;
    L19:
        if (r101 < r103) goto L21;
        return 0.0f;
    L21:
        return r103 - r101;
    }
}
