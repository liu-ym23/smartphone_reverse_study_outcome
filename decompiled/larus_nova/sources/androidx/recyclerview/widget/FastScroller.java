package androidx.recyclerview.widget;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.view.MotionEvent;
import androidx.core.view.ViewCompat;

/* JADX INFO: loaded from: classes17.dex */
class FastScroller extends RecyclerView.ItemDecoration implements RecyclerView.OnItemTouchListener {
    private static final int ANIMATION_STATE_FADING_IN = 1;
    private static final int ANIMATION_STATE_FADING_OUT = 3;
    private static final int ANIMATION_STATE_IN = 2;
    private static final int ANIMATION_STATE_OUT = 0;
    private static final int DRAG_NONE = 0;
    private static final int DRAG_X = 1;
    private static final int DRAG_Y = 2;
    private static final int[] EMPTY_STATE_SET = null;
    private static final int HIDE_DELAY_AFTER_DRAGGING_MS = 1200;
    private static final int HIDE_DELAY_AFTER_VISIBLE_MS = 1500;
    private static final int HIDE_DURATION_MS = 500;
    private static final int[] PRESSED_STATE_SET = null;
    private static final int SCROLLBAR_FULL_OPAQUE = 255;
    private static final int SHOW_DURATION_MS = 500;
    private static final int STATE_DRAGGING = 2;
    private static final int STATE_HIDDEN = 0;
    private static final int STATE_VISIBLE = 1;
    int mAnimationState;
    private int mDragState;
    private final Runnable mHideRunnable;
    float mHorizontalDragX;
    private final int[] mHorizontalRange;
    int mHorizontalThumbCenterX;
    private final StateListDrawable mHorizontalThumbDrawable;
    private final int mHorizontalThumbHeight;
    int mHorizontalThumbWidth;
    private final Drawable mHorizontalTrackDrawable;
    private final int mHorizontalTrackHeight;
    private final int mMargin;
    private boolean mNeedHorizontalScrollbar;
    private boolean mNeedVerticalScrollbar;
    private final RecyclerView.OnScrollListener mOnScrollListener;
    private RecyclerView mRecyclerView;
    private int mRecyclerViewHeight;
    private int mRecyclerViewWidth;
    private final int mScrollbarMinimumRange;
    final ValueAnimator mShowHideAnimator;
    private int mState;
    float mVerticalDragY;
    private final int[] mVerticalRange;
    int mVerticalThumbCenterY;
    final StateListDrawable mVerticalThumbDrawable;
    int mVerticalThumbHeight;
    private final int mVerticalThumbWidth;
    final Drawable mVerticalTrackDrawable;
    private final int mVerticalTrackWidth;

    public class AnimatorListener extends AnimatorListenerAdapter {
        private boolean mCanceled;
        final /* synthetic */ FastScroller this$0;

        public AnimatorListener(FastScroller r100) {
            this.this$0 = r100;
            this.mCanceled = false;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator r100) {
            this.mCanceled = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator r100) {
            if (this.mCanceled == false) goto L7;
            this.mCanceled = false;
            return;
        L7:
            if (((Float) this.this$0.mShowHideAnimator.getAnimatedValue()).floatValue() != 0.0f) goto L9;
            FastScroller r101 = this.this$0;
            r101.mAnimationState = 0;
            r101.setState(0);
            return;
        L9:
            FastScroller r102 = this.this$0;
            r102.mAnimationState = 2;
            r102.requestRedraw();
        }
    }

    public class AnimatorUpdater implements ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ FastScroller this$0;

        public AnimatorUpdater(FastScroller r100) {
            this.this$0 = r100;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator r100) {
            int r101 = (int) (((Float) r100.getAnimatedValue()).floatValue() * 255.0f);
            this.this$0.mVerticalThumbDrawable.setAlpha(r101);
            this.this$0.mVerticalTrackDrawable.setAlpha(r101);
            this.this$0.requestRedraw();
        }
    }

    static {
        PRESSED_STATE_SET = new int[]{R.attr.state_pressed};
        EMPTY_STATE_SET = new int[0];
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
    public void onRequestDisallowInterceptTouchEvent(boolean r100) {
    }

    private void cancelHide() {
        this.mRecyclerView.removeCallbacks(this.mHideRunnable);
    }

    private void destroyCallbacks() {
        this.mRecyclerView.removeItemDecoration(this);
        this.mRecyclerView.removeOnItemTouchListener(this);
        this.mRecyclerView.removeOnScrollListener(this.mOnScrollListener);
        cancelHide();
    }

    private int[] getHorizontalRange() {
        int[] r100 = this.mHorizontalRange;
        int r101 = this.mMargin;
        r100[0] = r101;
        r100[1] = this.mRecyclerViewWidth - r101;
        return r100;
    }

    private int[] getVerticalRange() {
        int[] r100 = this.mVerticalRange;
        int r101 = this.mMargin;
        r100[0] = r101;
        r100[1] = this.mRecyclerViewHeight - r101;
        return r100;
    }

    private boolean isLayoutRTL() {
        if (ViewCompat.getLayoutDirection(this.mRecyclerView) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    private void setupCallbacks() {
        this.mRecyclerView.addItemDecoration(this);
        this.mRecyclerView.addOnItemTouchListener(this);
        this.mRecyclerView.addOnScrollListener(this.mOnScrollListener);
    }

    public boolean isDragging() {
        if (this.mState != 2) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isVisible() {
        if (this.mState == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public void requestRedraw() {
        this.mRecyclerView.invalidate();
    }

    public void show() {
        int r100 = this.mAnimationState;
        if (r100 != 0) goto L5;
    L8:
        this.mAnimationState = 1;
        ValueAnimator r101 = this.mShowHideAnimator;
        r101.setFloatValues(new float[]{((Float) r101.getAnimatedValue()).floatValue(), 1.0f});
        this.mShowHideAnimator.setDuration(500);
        this.mShowHideAnimator.setStartDelay(0);
        this.mShowHideAnimator.start();
        return;
    L5:
        if (r100 != 3) goto L10;
        this.mShowHideAnimator.cancel();
        goto L8
    }

    public Drawable getHorizontalThumbDrawable() {
        return this.mHorizontalThumbDrawable;
    }

    public Drawable getHorizontalTrackDrawable() {
        return this.mHorizontalTrackDrawable;
    }

    public Drawable getVerticalThumbDrawable() {
        return this.mVerticalThumbDrawable;
    }

    public Drawable getVerticalTrackDrawable() {
        return this.mVerticalTrackDrawable;
    }

    private void drawHorizontalScrollbar(Canvas r100) {
        int r101 = this.mRecyclerViewHeight;
        int r102 = this.mHorizontalThumbHeight;
        int r103 = r101 - r102;
        int r104 = this.mHorizontalThumbCenterX;
        int r105 = this.mHorizontalThumbWidth;
        int r106 = r104 - (r105 / 2);
        this.mHorizontalThumbDrawable.setBounds(0, 0, r105, r102);
        this.mHorizontalTrackDrawable.setBounds(0, 0, this.mRecyclerViewWidth, this.mHorizontalTrackHeight);
        r100.translate(0.0f, r103);
        this.mHorizontalTrackDrawable.draw(r100);
        r100.translate(r106, 0.0f);
        this.mHorizontalThumbDrawable.draw(r100);
        r100.translate(-r106, -r103);
    }

    private void drawVerticalScrollbar(Canvas r100) {
        int r101 = this.mRecyclerViewWidth;
        int r102 = this.mVerticalThumbWidth;
        int r103 = r101 - r102;
        int r104 = this.mVerticalThumbCenterY;
        int r105 = this.mVerticalThumbHeight;
        int r106 = r104 - (r105 / 2);
        this.mVerticalThumbDrawable.setBounds(0, 0, r102, r105);
        this.mVerticalTrackDrawable.setBounds(0, 0, this.mVerticalTrackWidth, this.mRecyclerViewHeight);
        if (isLayoutRTL() == false) goto L5;
        this.mVerticalTrackDrawable.draw(r100);
        r100.translate(this.mVerticalThumbWidth, r106);
        r100.scale(-1.0f, 1.0f);
        this.mVerticalThumbDrawable.draw(r100);
        r100.scale(-1.0f, 1.0f);
        r100.translate(-this.mVerticalThumbWidth, -r106);
        return;
    L5:
        r100.translate(r103, 0.0f);
        this.mVerticalTrackDrawable.draw(r100);
        r100.translate(0.0f, r106);
        this.mVerticalThumbDrawable.draw(r100);
        r100.translate(-r103, -r106);
    }

    private void horizontalScrollTo(float r100) {
        int[] r101 = getHorizontalRange();
        float r102 = Math.max(r101[0], Math.min(r101[1], r100));
        if (Math.abs(this.mHorizontalThumbCenterX - r102) >= 2.0f) goto L5;
        return;
    L5:
        int r103 = scrollTo(this.mHorizontalDragX, r102, r101, this.mRecyclerView.computeHorizontalScrollRange(), this.mRecyclerView.computeHorizontalScrollOffset(), this.mRecyclerViewWidth);
        if (r103 == 0) goto L8;
        this.mRecyclerView.scrollBy(r103, 0);
    L8:
        this.mHorizontalDragX = r102;
    }

    private void resetHideDelay(int r100) {
        cancelHide();
        this.mRecyclerView.postDelayed(this.mHideRunnable, r100);
    }

    private void verticalScrollTo(float r100) {
        int[] r101 = getVerticalRange();
        float r102 = Math.max(r101[0], Math.min(r101[1], r100));
        if (Math.abs(this.mVerticalThumbCenterY - r102) >= 2.0f) goto L5;
        return;
    L5:
        int r103 = scrollTo(this.mVerticalDragY, r102, r101, this.mRecyclerView.computeVerticalScrollRange(), this.mRecyclerView.computeVerticalScrollOffset(), this.mRecyclerViewHeight);
        if (r103 == 0) goto L8;
        this.mRecyclerView.scrollBy(0, r103);
    L8:
        this.mVerticalDragY = r102;
    }

    public void attachToRecyclerView(RecyclerView r100) {
        RecyclerView r101 = this.mRecyclerView;
        if (r101 != r100) goto L5;
        return;
    L5:
        if (r101 == null) goto L7;
        destroyCallbacks();
    L7:
        this.mRecyclerView = r100;
        if (r100 == null) goto L11;
        setupCallbacks();
        return;
    }

    public void hide(int r100) {
        int r101 = this.mAnimationState;
        if (r101 == 1) goto L6;
        if (r101 != 2) goto L9;
    L7:
        this.mAnimationState = 3;
        ValueAnimator r102 = this.mShowHideAnimator;
        r102.setFloatValues(new float[]{((Float) r102.getAnimatedValue()).floatValue(), 0.0f});
        this.mShowHideAnimator.setDuration(r100);
        this.mShowHideAnimator.start();
        return;
    L9:
        return;
    L6:
        this.mShowHideAnimator.cancel();
        goto L7
    }

    public void setState(int r100) {
        if (r100 == 2) goto L5;
    L7:
        if (r100 != 0) goto L9;
        requestRedraw();
    L11:
        if (this.mState != 2) goto L15;
        if (r100 == 2) goto L15;
        this.mVerticalThumbDrawable.setState(EMPTY_STATE_SET);
        resetHideDelay(1200);
    L17:
        this.mState = r100;
        return;
    L15:
        if (r100 != 1) goto L17;
        resetHideDelay(1500);
        goto L17
    L9:
        show();
        goto L11
    L5:
        if (this.mState == 2) goto L7;
        this.mVerticalThumbDrawable.setState(PRESSED_STATE_SET);
        cancelHide();
        goto L7
    }

    public boolean isPointInsideHorizontalThumb(float r100, float r101) {
        if (r101 < (this.mRecyclerViewHeight - this.mHorizontalThumbHeight)) goto L9;
        int r102 = this.mHorizontalThumbCenterX;
        int r103 = this.mHorizontalThumbWidth;
        if (r100 < (r102 - (r103 / 2))) goto L9;
        if (r100 > (r102 + (r103 / 2))) goto L9;
        return true;
    L9:
        return false;
    }

    public boolean isPointInsideVerticalThumb(float r100, float r101) {
        if (isLayoutRTL() == false) goto L8;
        if (r100 <= this.mVerticalThumbWidth) goto L9;
    L14:
        return false;
    L9:
        int r102 = this.mVerticalThumbCenterY;
        int r103 = this.mVerticalThumbHeight;
        if (r101 < (r102 - (r103 / 2))) goto L14;
        if (r101 > (r102 + (r103 / 2))) goto L14;
        return true;
    L8:
        if (r100 < (this.mRecyclerViewWidth - this.mVerticalThumbWidth)) goto L14;
        goto L9
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
    public boolean onInterceptTouchEvent(RecyclerView r100, MotionEvent r101) {
        int r102 = this.mState;
        if (r102 != 1) goto L13;
        boolean r103 = isPointInsideVerticalThumb(r101.getX(), r101.getY());
        boolean r104 = isPointInsideHorizontalThumb(r101.getX(), r101.getY());
        if (r101.getAction() != 0) goto L16;
        if (r103 == true) goto L8;
        if (r104 == true) goto L8;
        return false;
    L8:
        if (r104 == false) goto L10;
        this.mDragState = 1;
        this.mHorizontalDragX = (int) r101.getX();
    L12:
        setState(2);
    L14:
        return true;
    L10:
        if (r103 == false) goto L12;
        this.mDragState = 2;
        this.mVerticalDragY = (int) r101.getY();
        goto L12
    L16:
        return false;
    L13:
        if (r102 == 2) goto L14;
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
    public void onTouchEvent(RecyclerView r100, MotionEvent r101) {
        if (this.mState != 0) goto L6;
        return;
    L6:
        if (r101.getAction() != 0) goto L16;
        boolean r102 = isPointInsideVerticalThumb(r101.getX(), r101.getY());
        boolean r103 = isPointInsideHorizontalThumb(r101.getX(), r101.getY());
        if (r102 == true) goto L10;
        if (r103 == true) goto L10;
        return;
    L10:
        if (r103 == false) goto L12;
        this.mDragState = 1;
        this.mHorizontalDragX = (int) r101.getX();
    L14:
        setState(2);
        return;
    L12:
        if (r102 == false) goto L14;
        this.mDragState = 2;
        this.mVerticalDragY = (int) r101.getY();
        goto L14
    L16:
        if (r101.getAction() != 1) goto L21;
        if (this.mState != 2) goto L21;
        this.mVerticalDragY = 0.0f;
        this.mHorizontalDragX = 0.0f;
        setState(1);
        this.mDragState = 0;
        return;
    L21:
        if (r101.getAction() == 2) goto L23;
        return;
    L23:
        if (this.mState != 2) goto L35;
        show();
        if (this.mDragState != 1) goto L28;
        horizontalScrollTo(r101.getX());
    L28:
        if (this.mDragState != 2) goto L36;
        verticalScrollTo(r101.getY());
        return;
    L36:
        return;
    }

    public void updateScrollPosition(int r100, int r110) {
        int r101 = this.mRecyclerView.computeVerticalScrollRange();
        int r102 = this.mRecyclerViewHeight;
        if ((r101 - r102) > 0) goto L5;
    L7:
        boolean r103 = false;
    L8:
        this.mNeedVerticalScrollbar = r103;
        int r104 = this.mRecyclerView.computeHorizontalScrollRange();
        int r105 = this.mRecyclerViewWidth;
        if ((r104 - r105) > 0) goto L11;
    L13:
        boolean r106 = false;
    L14:
        this.mNeedHorizontalScrollbar = r106;
        boolean r107 = this.mNeedVerticalScrollbar;
        if (r107 == true) goto L22;
        if (r106 == true) goto L22;
        if (this.mState == 0) goto L32;
        setState(0);
        return;
    L32:
        return;
    L22:
        if (r107 == false) goto L25;
        float r108 = r102;
        this.mVerticalThumbCenterY = (int) ((r108 * (r110 + (r108 / 2.0f))) / r101);
        this.mVerticalThumbHeight = Math.min(r102, (r102 * r102) / r101);
    L25:
        if (this.mNeedHorizontalScrollbar == false) goto L27;
        float r111 = r105;
        this.mHorizontalThumbCenterX = (int) ((r111 * (r100 + (r111 / 2.0f))) / r104);
        this.mHorizontalThumbWidth = Math.min(r105, (r105 * r105) / r104);
    L27:
        int r109 = this.mState;
        if (r109 == 0) goto L30;
        if (r109 == 1) goto L30;
        return;
    L30:
        setState(1);
        return;
    L11:
        if (r105 < this.mScrollbarMinimumRange) goto L13;
        r106 = true;
        goto L14
    L5:
        if (r102 < this.mScrollbarMinimumRange) goto L7;
        r103 = true;
        goto L8
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDrawOver(Canvas r100, RecyclerView r101, RecyclerView.State r102) {
        if (this.mRecyclerViewWidth == this.mRecyclerView.getWidth()) goto L5;
    L16:
        this.mRecyclerViewWidth = this.mRecyclerView.getWidth();
        this.mRecyclerViewHeight = this.mRecyclerView.getHeight();
        setState(0);
        return;
    L5:
        if (this.mRecyclerViewHeight != this.mRecyclerView.getHeight()) goto L16;
        if (this.mAnimationState != 0) goto L10;
        return;
    L10:
        if (this.mNeedVerticalScrollbar == false) goto L13;
        drawVerticalScrollbar(r100);
    L13:
        if (this.mNeedHorizontalScrollbar == false) goto L19;
        drawHorizontalScrollbar(r100);
        return;
    }

    private int scrollTo(float r100, float r101, int[] r102, int r103, int r104, int r105) {
        int r106 = r102[1] - r102[0];
        if (r106 != 0) goto L5;
        return 0;
    L5:
        int r107 = r103 - r105;
        int r108 = (int) (((r101 - r100) / r106) * r107);
        int r109 = r104 + r108;
        if (r109 >= r107) goto L9;
        if (r109 < 0) goto L9;
        return r108;
    L9:
        return 0;
    }

    public FastScroller(RecyclerView r100, StateListDrawable r101, Drawable r102, StateListDrawable r103, Drawable r104, int r105, int r110, int r111) {
        this.mRecyclerViewWidth = 0;
        this.mRecyclerViewHeight = 0;
        this.mNeedVerticalScrollbar = false;
        this.mNeedHorizontalScrollbar = false;
        this.mState = 0;
        this.mDragState = 0;
        this.mVerticalRange = new int[2];
        this.mHorizontalRange = new int[2];
        ValueAnimator r106 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.mShowHideAnimator = r106;
        this.mAnimationState = 0;
        this.mHideRunnable = new AnonymousClass1(this);
        this.mOnScrollListener = new AnonymousClass2(this);
        this.mVerticalThumbDrawable = r101;
        this.mVerticalTrackDrawable = r102;
        this.mHorizontalThumbDrawable = r103;
        this.mHorizontalTrackDrawable = r104;
        this.mVerticalThumbWidth = Math.max(r105, r101.getIntrinsicWidth());
        this.mVerticalTrackWidth = Math.max(r105, r102.getIntrinsicWidth());
        this.mHorizontalThumbHeight = Math.max(r105, r103.getIntrinsicWidth());
        this.mHorizontalTrackHeight = Math.max(r105, r104.getIntrinsicWidth());
        this.mScrollbarMinimumRange = r110;
        this.mMargin = r111;
        r101.setAlpha(255);
        r102.setAlpha(255);
        r106.addListener(new AnimatorListener(this));
        r106.addUpdateListener(new AnimatorUpdater(this));
        attachToRecyclerView(r100);
    }
}
