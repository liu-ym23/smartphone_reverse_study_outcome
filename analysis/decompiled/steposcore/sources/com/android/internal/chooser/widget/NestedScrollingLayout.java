package com.android.internal.chooser.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
import com.android.internal.R;
import com.android.internal.chooser.BaseResolverHooker;
import com.android.internal.chooser.utils.LogUtils;
import com.android.internal.chooser.utils.Utils;
import com.android.internal.chooser.widget.LitePopup;
import com.android.internal.dynamicanimation.animation.DynamicAnimation;
import com.android.internal.dynamicanimation.animation.FloatValueHolder;
import com.android.internal.dynamicanimation.animation.SpringAnimation;
import com.android.internal.dynamicanimation.animation.SpringForce;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes.dex */
public class NestedScrollingLayout extends ViewGroup {
    public static final int POSITION_STATE_BOTTOM = 2;
    public static final int POSITION_STATE_INVALID = -1;
    public static final int POSITION_STATE_MIDDLE = 1;
    public static final int POSITION_STATE_TOP = 0;
    private static final Interpolator SCROLLER_INTERPOLATOR = new PathInterpolator(0.26f, 1.0f, 0.48f, 1.0f);
    private int cancelBtnOffset;
    private float mAbandonVelocity;
    private boolean mBeDragging;
    private int mCollapsibleHeight;
    private boolean mConsumedScrollEnable;
    private boolean mContentScrolled;
    private int mCurrentScrollY;
    private Drawable mDimBackground;
    private int mDismissTriggeredDistance;
    private boolean mDismissedOnTouchOutside;
    private float mDownY;
    private boolean mDragCanceled;
    private boolean mDragTriggerNotified;
    private boolean mDragTriggerNotifiedPosted;
    private int mExpectUncollapsibleHeight;
    private float mFlingDownVelocity;
    private int mFlingPositionState;
    private View mHitView;
    private boolean mIsAnimationRunning;
    private boolean mIsHitView;
    private float mLastY;
    private int mMaxHeight;
    private final float mMinFlingVelocity;
    private Runnable mNotifyDismissedListener;
    private LitePopup.OnDismissedListener mOnDismissedListener;
    private OnScrollListener mOnScrollListener;
    private int mOverScrollDistance;
    private TimeInterpolator mOverScrollInterpolator;
    private int mPortraitTopPadding;
    private int mPositionState;
    private int mScrollDownThreshold;
    private int mScrollSlop;
    private boolean mScrollToDismissEnabled;
    private SpringAnimation mSpringAnimation;
    private DynamicAnimation.OnAnimationUpdateListener mSpringAnimationUpdateListener;
    private int mStyle;
    private int mTopPadding;
    private int mUncollapsibleHeight;
    private final VelocityTracker mVelocityTracker;

    public interface OnScrollListener {
        void onScroll(int i);
    }

    @Retention(RetentionPolicy.SOURCE)
    private @interface PositionState {
    }

    public NestedScrollingLayout(Context context) {
        this(context, null);
    }

    public NestedScrollingLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public NestedScrollingLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mDragTriggerNotified = false;
        this.mPositionState = 1;
        this.mCurrentScrollY = 0;
        this.mScrollToDismissEnabled = true;
        this.mStyle = 0;
        this.mDismissedOnTouchOutside = true;
        this.mConsumedScrollEnable = false;
        this.mIsAnimationRunning = false;
        this.mOverScrollInterpolator = new PathInterpolator(0.12f, 0.0f, 0.33f, 1.0f);
        this.mSpringAnimationUpdateListener = new DynamicAnimation.OnAnimationUpdateListener() { // from class: com.android.internal.chooser.widget.NestedScrollingLayout.1
            public void onAnimationUpdate(DynamicAnimation animation, float value, float velocity) {
                NestedScrollingLayout.this.performScrollTo((int) value);
            }
        };
        this.mNotifyDismissedListener = new Runnable() { // from class: com.android.internal.chooser.widget.NestedScrollingLayout.2
            @Override // java.lang.Runnable
            public void run() {
                NestedScrollingLayout.this.notifyDragTriggered();
            }
        };
        this.mDragTriggerNotifiedPosted = false;
        this.cancelBtnOffset = 0;
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.NestedScrollingLayout, defStyleAttr, 0);
        this.mMaxHeight = a.getDimensionPixelSize(0, -1);
        this.mTopPadding = a.getDimensionPixelSize(1, getResources().getDimensionPixelSize(17106492));
        a.recycle();
        ViewConfiguration vc = ViewConfiguration.get(context);
        this.mMinFlingVelocity = vc.getScaledMinimumFlingVelocity();
        this.mAbandonVelocity = getResources().getDimensionPixelSize(17106140);
        this.mFlingDownVelocity = getResources().getDimensionPixelSize(17106139);
        this.mVelocityTracker = VelocityTracker.obtain();
        setClipToPadding(false);
        this.mScrollSlop = vc.getScaledTouchSlop();
        this.mOverScrollDistance = context.getResources().getDimensionPixelSize(17106490);
        this.mDismissTriggeredDistance = context.getResources().getDimensionPixelSize(17106488);
        this.mScrollDownThreshold = context.getResources().getDimensionPixelSize(17106493);
        this.mExpectUncollapsibleHeight = context.getResources().getDimensionPixelSize(17106489);
        this.mPortraitTopPadding = this.mTopPadding;
        if (Utils.isLandscape(context)) {
            this.mTopPadding = Utils.dp2px(context, 31.0f);
        }
        animate().setListener(new AnimatorListenerAdapter() { // from class: com.android.internal.chooser.widget.NestedScrollingLayout.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animation, boolean isReverse) {
                super.onAnimationStart(animation, isReverse);
                NestedScrollingLayout.this.mIsAnimationRunning = true;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation, boolean isReverse) {
                super.onAnimationEnd(animation, isReverse);
                NestedScrollingLayout.this.mIsAnimationRunning = false;
            }
        });
    }

    public void setConsumedScrollEnable(boolean enable) {
        this.mConsumedScrollEnable = enable;
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration newConfig) throws Resources.NotFoundException {
        super.onConfigurationChanged(newConfig);
        int hPadding = getResources().getDimensionPixelSize(17106491);
        this.mTopPadding = Utils.isLandscape(getContext()) ? Utils.dp2px(getContext(), 31.0f) : this.mPortraitTopPadding;
        setPadding(hPadding, this.mTopPadding, hPadding, getPaddingBottom());
        requestLayout();
    }

    @Override // android.view.View
    public WindowInsets onApplyWindowInsets(WindowInsets insets) {
        setPadding(getPaddingLeft(), this.mTopPadding, getPaddingRight(), 0);
        return insets.inset(insets.getSystemWindowInsetLeft(), insets.getSystemWindowInsetTop(), insets.getSystemWindowInsetRight(), 0);
    }

    public void setMaxHeight(int maxHeight) {
        this.mMaxHeight = maxHeight;
    }

    public void setScrollListener(OnScrollListener scrollListener) {
        this.mOnScrollListener = scrollListener;
    }

    public void setOnDismissedListener(LitePopup.OnDismissedListener onDismissedListener) {
        this.mOnDismissedListener = onDismissedListener;
    }

    public void setUncollapsibleHeight(int uncollapsibleHeight) {
        this.mExpectUncollapsibleHeight = uncollapsibleHeight;
        requestLayout();
    }

    public int getUncollapsibleHeight() {
        return this.mUncollapsibleHeight;
    }

    public int getCurrentScrollY() {
        return this.mCurrentScrollY;
    }

    public int getCurrentState() {
        return this.mPositionState;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onStartNestedScroll(View child, View target, int nestedScrollAxes) {
        this.mFlingPositionState = -1;
        return (nestedScrollAxes & 2) != 0;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedPreScroll(View target, int dx, int dy, int[] consumed) {
        boolean canScrollToBottom = false;
        boolean canScrollToTop = dy > 0 && ((this.mCurrentScrollY < this.mCollapsibleHeight && this.mStyle != 1) || (this.mCurrentScrollY < 0 && this.mStyle == 1));
        if (dy < 0 && !target.canScrollVertically(-1)) {
            canScrollToBottom = true;
        }
        if (this.mConsumedScrollEnable) {
            consumed[1] = dy;
            return;
        }
        if (canScrollToTop || (canScrollToBottom && !this.mContentScrolled)) {
            consumed[1] = limitedScrollBy(dy, true);
        } else if (dy != 0) {
            this.mContentScrolled = true;
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onStopNestedScroll(View child) {
        if (!this.mIsAnimationRunning) {
            int nextPositionState = getNextPositionState(this.mPositionState);
            if (this.mFlingPositionState != -1 && this.mFlingPositionState != 2) {
                nextPositionState = this.mFlingPositionState;
            }
            smoothScrollToPositionState(nextPositionState);
            dismissTriggerIfNeed();
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedPreFling(View target, float velocityX, float velocityY) {
        boolean handle = true;
        if (this.mConsumedScrollEnable) {
            return true;
        }
        if (this.mCurrentScrollY > this.mCollapsibleHeight && !isDismissTriggered()) {
            handle = false;
        }
        if (handle) {
            boolean canScrollingUp = target.canScrollVertically(-1);
            if (velocityY < 0.0f && canScrollingUp && this.mPositionState == 0) {
                return false;
            }
            if (shouldFling(velocityY)) {
                this.mFlingPositionState = getNextPositionState(this.mPositionState, -velocityY);
                if (this.mPositionState != this.mFlingPositionState) {
                    smoothScrollToPositionState(this.mFlingPositionState);
                    return handle;
                }
                if (!canScrollingUp) {
                    return true;
                }
                return false;
            }
            return handle;
        }
        return handle;
    }

    private int getNextPositionState(int currentState, float yVelocity) {
        if (!this.mScrollToDismissEnabled && this.mStyle != 0 && this.mStyle != 3) {
            return currentState;
        }
        if (this.mCurrentScrollY < (-this.mUncollapsibleHeight) || this.mCurrentScrollY >= 0) {
            return this.mStyle == 2 ? yVelocity > 0.0f ? 2 : 0 : (yVelocity >= 0.0f || !(this.mStyle == 0 || this.mStyle == 3)) ? 1 : 0;
        }
        if (this.mStyle == 1) {
            return yVelocity > 0.0f ? 2 : 1;
        }
        if (yVelocity < 0.0f || !this.mScrollToDismissEnabled) {
            return (yVelocity >= (-this.mAbandonVelocity) || currentState != 0) ? 1 : 0;
        }
        return 2;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        int action = ev.getActionMasked();
        switch (action) {
            case 0:
                resetTouch();
                this.mDownY = ev.getY();
                this.mLastY = ev.getY();
                this.mHitView = findChildUnder(this, ev.getX(), this.mDownY);
                this.mIsHitView = this.mHitView != null;
                break;
            case 1:
            case 3:
                endTouch();
                break;
            case 2:
                float dy = ev.getY() - this.mDownY;
                if (!this.mBeDragging && this.mHitView != null && !canScroll(this.mHitView, true) && Math.abs(dy) > this.mScrollSlop) {
                    this.mBeDragging = true;
                }
                this.mLastY = ev.getY();
                break;
        }
        return this.mBeDragging && !this.mDragCanceled;
    }

    protected boolean canScroll(View v, boolean checkV) {
        if (v instanceof ViewGroup) {
            ViewGroup group = (ViewGroup) v;
            v.getScrollX();
            v.getScrollY();
            int count = group.getChildCount();
            for (int i = count - 1; i >= 0; i--) {
                View child = group.getChildAt(i);
                if (canScroll(child, true)) {
                    return true;
                }
            }
        }
        return checkV && (v.canScrollVertically(-1) || v.canScrollVertically(1));
    }

    private void resetTouch() {
        this.mBeDragging = false;
        this.mDragTriggerNotified = false;
        this.mDragCanceled = false;
        this.mDragTriggerNotifiedPosted = false;
        this.mContentScrolled = false;
        this.mFlingPositionState = -1;
    }

    private void endTouch() {
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        if (this.mConsumedScrollEnable) {
            return true;
        }
        this.mVelocityTracker.addMovement(event);
        boolean canDismiss = false;
        switch (event.getAction()) {
            case 0:
            default:
                return true;
            case 1:
            case 3:
                if (this.mIsHitView) {
                    this.mVelocityTracker.computeCurrentVelocity(1000);
                    float yvel = this.mVelocityTracker.getYVelocity();
                    if (shouldFling(yvel)) {
                        smoothScrollToPositionState(getNextPositionState(this.mPositionState, yvel));
                    } else {
                        smoothScrollToPositionState(getNextPositionState(this.mPositionState));
                    }
                    dismissTriggerIfNeed();
                } else {
                    if (this.mDismissedOnTouchOutside && (getResources().getConfiguration().orientation == 2 || this.mPositionState == 1)) {
                        canDismiss = true;
                    }
                    if (this.mOnDismissedListener != null && canDismiss) {
                        this.mOnDismissedListener.onDismissed(true);
                    }
                }
                this.mVelocityTracker.clear();
                return true;
            case 2:
                if (this.mIsHitView) {
                    float dy = event.getY() - this.mLastY;
                    this.mLastY = event.getY();
                    limitedScrollBy((int) (-dy), false);
                }
                return true;
        }
    }

    private void dismissTriggerIfNeed() {
        if (this.mOnDismissedListener != null && !this.mScrollToDismissEnabled && isDismissTriggered()) {
            postNotifyDragTriggered();
        }
    }

    private boolean isDismissTriggered() {
        return (this.mStyle == 1 || this.mPositionState == 1) ? this.mCurrentScrollY <= (-(this.mDismissTriggeredDistance - this.mScrollSlop)) && !this.mDragTriggerNotified : this.mStyle == 2 && Math.abs(this.mCurrentScrollY - this.mCollapsibleHeight) >= this.mDismissTriggeredDistance - this.mScrollSlop && !this.mDragTriggerNotified;
    }

    private int getNextPositionState(int preState) {
        int preScrollY;
        if (!this.mScrollToDismissEnabled && this.mStyle != 0 && this.mStyle != 3) {
            return preState;
        }
        if (preState == 0) {
            preScrollY = this.mCollapsibleHeight;
        } else if (preState == 1) {
            preScrollY = 0;
        } else {
            int preScrollY2 = this.mUncollapsibleHeight;
            preScrollY = -preScrollY2;
        }
        int diff = this.mCurrentScrollY - preScrollY;
        int absDiff = Math.abs(diff);
        if (diff > 0) {
            if (preState == 2) {
                if (absDiff > this.mUncollapsibleHeight + this.mScrollDownThreshold) {
                    return 0;
                }
                return absDiff > this.mScrollDownThreshold ? 1 : 2;
            }
            if (preState != 1) {
                return 0;
            }
            if (absDiff <= this.mScrollDownThreshold || (this.mStyle != 0 && this.mStyle != 3)) {
                return 1;
            }
            return 0;
        }
        if (preState == 0) {
            if (this.mStyle == 2) {
                return (absDiff <= this.mScrollDownThreshold || !this.mScrollToDismissEnabled) ? 0 : 2;
            }
            if (absDiff > this.mCollapsibleHeight + this.mScrollDownThreshold && this.mScrollToDismissEnabled && !this.mContentScrolled) {
                return 2;
            }
            if (absDiff > this.mScrollDownThreshold) {
                return 1;
            }
            return 0;
        }
        if (preState == 1) {
            return (absDiff <= this.mScrollDownThreshold || !this.mScrollToDismissEnabled || this.mContentScrolled) ? 1 : 2;
        }
        return 2;
    }

    public void smoothScrollToPositionState(int state) {
        smoothScrollToPositionState(state, 300);
    }

    public void smoothScrollToPositionState(int state, int duration) {
        float dampingRatio;
        float stiffness;
        if (this.mSpringAnimation == null) {
            this.mSpringAnimation = new SpringAnimation(new FloatValueHolder());
            this.mSpringAnimation.addUpdateListener(this.mSpringAnimationUpdateListener);
            this.mSpringAnimation.setSpring(new SpringForce());
        }
        SpringAnimation springAnimation = this.mSpringAnimation;
        if (this.mPositionState == state) {
            dampingRatio = BaseResolverHooker.IN_THRESHOLD_DAMP;
            stiffness = BaseResolverHooker.IN_THRESHOLD_DAMP_STIFFNESS;
        } else {
            switch (state) {
                case 0:
                case 1:
                    dampingRatio = 0.88f;
                    stiffness = 340.0f;
                    break;
                case 2:
                    dampingRatio = 0.93f;
                    stiffness = 400.0f;
                    break;
                default:
                    dampingRatio = BaseResolverHooker.IN_THRESHOLD_DAMP;
                    stiffness = BaseResolverHooker.IN_THRESHOLD_DAMP_STIFFNESS;
                    break;
            }
        }
        springAnimation.getSpring().setDampingRatio(dampingRatio).setStiffness(stiffness);
        this.mPositionState = state;
        LogUtils.d("smoothScrollToPositionState = " + state);
        switch (state) {
            case 0:
                springScrollTo(this.mCollapsibleHeight, springAnimation);
                break;
            case 1:
                springScrollTo(0, springAnimation);
                break;
            case 2:
                clearAnimation();
                if (springAnimation.isRunning()) {
                    springAnimation.cancel();
                }
                if (this.mOnDismissedListener != null) {
                    this.mOnDismissedListener.onDismissed(true);
                    break;
                }
                break;
        }
    }

    private void updateScrollY() {
        boolean screenSizeChanged = this.mCurrentScrollY < (-this.mUncollapsibleHeight) || this.mCurrentScrollY > this.mCollapsibleHeight;
        this.mCurrentScrollY = Math.min(Math.max(this.mCurrentScrollY, -this.mUncollapsibleHeight), this.mCollapsibleHeight);
        if (this.mSpringAnimation != null && this.mSpringAnimation.isRunning()) {
            this.mSpringAnimation.getSpring().setFinalPosition(getScrollTargetForState(this.mPositionState));
        } else if (screenSizeChanged) {
            smoothScrollToPositionState(this.mPositionState);
        }
    }

    private int getScrollTargetForState(int state) {
        switch (state) {
            case 0:
                return this.mCollapsibleHeight;
            case 1:
                return 0;
            case 2:
                return -this.mUncollapsibleHeight;
            default:
                return this.mCurrentScrollY;
        }
    }

    public void scrollToPosition(int state) {
        this.mPositionState = state;
        switch (state) {
            case 0:
                performScrollTo(this.mCollapsibleHeight);
                break;
            case 1:
                performScrollTo(0);
                break;
            case 2:
                performScrollTo(-this.mUncollapsibleHeight);
                break;
        }
    }

    private void springScrollTo(int scrollTo, SpringAnimation springAnimation) {
        springAnimation.getSpring().setFinalPosition(scrollTo);
        if (springAnimation.isRunning() || this.mCurrentScrollY == scrollTo) {
            return;
        }
        springAnimation.setStartValue(this.mCurrentScrollY);
        try {
            springAnimation.start();
        } catch (IllegalStateException e) {
            Log.e("AnimationError", "启动弹簧动画失败", e);
        }
    }

    private int limitedScrollBy(int dy, boolean nestedScroll) {
        if (this.mCurrentScrollY + dy > this.mCollapsibleHeight) {
            dy = this.mCollapsibleHeight - this.mCurrentScrollY;
        }
        if (!this.mScrollToDismissEnabled) {
            if (this.mStyle == 1 && (dy < 0 || !nestedScroll)) {
                dy = updateIncrementalDelta(dy, this.mCurrentScrollY);
            } else if (this.mStyle == 2 && (dy < 0 || !nestedScroll)) {
                dy = updateIncrementalDelta(dy, this.mCurrentScrollY - this.mCollapsibleHeight);
            } else if (this.mPositionState == 1 && dy < 0) {
                dy = updateIncrementalDelta(dy, this.mCurrentScrollY);
            }
        } else if (this.mContentScrolled && dy < 0 && this.mCurrentScrollY <= 0) {
            dy = updateIncrementalDelta(dy, this.mCurrentScrollY);
        } else if (this.mStyle == 1 && dy > 0 && !nestedScroll) {
            dy = updateIncrementalDelta(dy, this.mCurrentScrollY);
        }
        clearAnimation();
        performScrollBy(dy);
        return dy;
    }

    private int updateIncrementalDelta(int delta, int currentScoll) {
        int overscrollDistance = this.mOverScrollDistance;
        if (currentScoll == 0 || overscrollDistance == 0) {
            return delta;
        }
        int incrementalDelta = 1;
        if ((this.mPositionState == 1 && currentScoll * delta > 0) || (this.mPositionState == 0 && currentScoll * delta > 0)) {
            float coeff = (Math.abs(currentScoll) * 1.0f) / overscrollDistance;
            float finalCoeff = 1.0f - this.mOverScrollInterpolator.getInterpolation(coeff);
            int incrementalDelta2 = (int) (delta * (finalCoeff >= 0.0f ? finalCoeff : 0.0f));
            if (delta > 0) {
                if (incrementalDelta2 != 0) {
                    incrementalDelta = incrementalDelta2;
                }
            } else {
                incrementalDelta = incrementalDelta2 == 0 ? -1 : incrementalDelta2;
            }
            int incrementalDelta3 = Math.abs(currentScoll);
            if (incrementalDelta3 < overscrollDistance) {
                return incrementalDelta;
            }
            return 0;
        }
        int incrementalDelta4 = delta / 2;
        return incrementalDelta4;
    }

    private void postNotifyDragTriggered() {
        if (!this.mDragTriggerNotifiedPosted && post(this.mNotifyDismissedListener)) {
            this.mDragTriggerNotifiedPosted = true;
        }
        if (!this.mDragTriggerNotifiedPosted) {
            notifyDragTriggered();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyDragTriggered() {
        if (this.mOnDismissedListener != null) {
            this.mOnDismissedListener.onDragTriggered();
        }
        this.mDragTriggerNotified = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void performScrollTo(int y) {
        performScrollBy(y - this.mCurrentScrollY);
    }

    private void performScrollBy(int y) {
        scrollBy(-y);
        this.mCurrentScrollY += y;
        if (this.mOnScrollListener != null) {
            this.mOnScrollListener.onScroll(this.mCurrentScrollY);
        }
        if (this.mCurrentScrollY < 0 && this.mOnDismissedListener != null) {
            float curY = Math.abs(this.mCurrentScrollY);
            this.mOnDismissedListener.onDismissProgress(curY / this.mUncollapsibleHeight);
        }
    }

    private void scrollBy(int dy) {
        int alignParentBottomDy = dy;
        if (this.mCurrentScrollY + (-dy) >= 0) {
            alignParentBottomDy = -this.cancelBtnOffset;
        } else if (this.mCurrentScrollY > 0 && dy > 0) {
            alignParentBottomDy = dy - this.mCurrentScrollY;
        }
        this.cancelBtnOffset += alignParentBottomDy;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View child = getChildAt(i);
            LayoutParams lp = (LayoutParams) child.getLayoutParams();
            if (lp.alignParentBottom) {
                child.offsetTopAndBottom(alignParentBottomDy);
            } else {
                child.offsetTopAndBottom(dy);
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int sourceWidth = View.MeasureSpec.getSize(widthMeasureSpec);
        int sourceHeight = View.MeasureSpec.getSize(heightMeasureSpec);
        if (this.mMaxHeight < sourceHeight) {
            this.mMaxHeight = sourceHeight;
        }
        int height = Math.min(sourceHeight, this.mMaxHeight);
        int widthSpec = View.MeasureSpec.makeMeasureSpec(sourceWidth, 1073741824);
        int heightSpec = View.MeasureSpec.makeMeasureSpec(height, 1073741824);
        int heightUsed = getPaddingTop() + getPaddingBottom();
        int childCount = getChildCount();
        int heightUsed2 = heightUsed;
        for (int i = 0; i < childCount; i++) {
            View child = getChildAt(i);
            LayoutParams lp = (LayoutParams) child.getLayoutParams();
            if (child.getVisibility() != 8 && !lp.listView) {
                measureChildWithMargins(child, widthSpec, 0, heightSpec, heightUsed2);
                if (!lp.ignoreParentPadding) {
                    heightUsed2 += child.getMeasuredHeight();
                }
            }
        }
        int remainingHeight = height - heightUsed2;
        for (int i2 = 0; i2 < childCount; i2++) {
            View child2 = getChildAt(i2);
            LayoutParams lp2 = (LayoutParams) child2.getLayoutParams();
            if (child2.getVisibility() != 8 && lp2.listView) {
                if (child2.getBackground() instanceof NinePatchDrawable) {
                    ((NinePatchDrawable) child2.getBackground()).setDither(true);
                }
                int childWidthMeasureSpec = getChildMeasureSpec(widthSpec, getPaddingLeft() + getPaddingRight() + lp2.leftMargin + lp2.rightMargin, lp2.width);
                int childHeightMeasureSpec = getChildMeasureSpec(heightSpec, getPaddingTop() + getPaddingBottom() + lp2.topMargin + lp2.bottomMargin + heightUsed2, remainingHeight);
                child2.measure(childWidthMeasureSpec, childHeightMeasureSpec);
                heightUsed2 += child2.getMeasuredHeight();
            }
        }
        this.mUncollapsibleHeight = Math.min(this.mExpectUncollapsibleHeight, (heightUsed2 - getPaddingTop()) - getPaddingBottom());
        this.mCollapsibleHeight = Math.max(0, ((heightUsed2 - getPaddingBottom()) - getPaddingTop()) - this.mUncollapsibleHeight);
        setMeasuredDimension(sourceWidth, sourceHeight);
        updateScrollY();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int i;
        int width = getWidth();
        int yPos = ((getMeasuredHeight() - this.mUncollapsibleHeight) - this.mCurrentScrollY) - getPaddingBottom();
        int leftEdge = getPaddingLeft();
        int rightEdge = width - getPaddingRight();
        int childCount = getChildCount();
        int i2 = 0;
        while (true) {
            i = 8;
            if (i2 >= childCount) {
                break;
            }
            View child = getChildAt(i2);
            LayoutParams lp = (LayoutParams) child.getLayoutParams();
            if (child.getVisibility() != 8 && !lp.alignParentBottom) {
                int top = lp.topMargin + yPos;
                int bottom = child.getMeasuredHeight() + top;
                int childWidth = child.getMeasuredWidth();
                int widthAvailable = rightEdge - leftEdge;
                int left = ((widthAvailable - childWidth) / 2) + leftEdge;
                int right = left + childWidth;
                child.layout(left, top, right, bottom);
                yPos = lp.bottomMargin + bottom;
            }
            i2++;
        }
        int i3 = 0;
        while (true) {
            if (i3 >= childCount) {
                break;
            }
            View child2 = getChildAt(i3);
            LayoutParams lp2 = (LayoutParams) child2.getLayoutParams();
            if (child2.getVisibility() != i && lp2.alignParentBottom) {
                int top2 = (((getHeight() - child2.getMeasuredHeight()) - (lp2.ignoreParentPadding ? 0 : getPaddingBottom())) - lp2.bottomMargin) + this.cancelBtnOffset;
                int bottom2 = child2.getMeasuredHeight() + top2;
                int childWidth2 = child2.getMeasuredWidth();
                int widthAvailable2 = rightEdge - leftEdge;
                int left2 = ((widthAvailable2 - childWidth2) / 2) + leftEdge;
                int right2 = left2 + childWidth2;
                child2.layout(left2, top2, right2, bottom2);
            }
            i3++;
            i = 8;
        }
        int i4 = this.mStyle;
        if (i4 == 2 || this.mStyle == 3) {
            scrollToPosition(0);
        }
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -2);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attrs) {
        return new LayoutParams(getContext(), attrs);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams p) {
        if (p instanceof LayoutParams) {
            return new LayoutParams((LayoutParams) p);
        }
        if (p instanceof ViewGroup.MarginLayoutParams) {
            return new LayoutParams((ViewGroup.MarginLayoutParams) p);
        }
        return new LayoutParams(p);
    }

    private boolean shouldFling(float yVel) {
        return Math.abs(yVel) > this.mMinFlingVelocity;
    }

    private View findChildUnder(float x, float y) {
        return findChildUnder(this, x, y);
    }

    private static View findChildUnder(ViewGroup parent, float x, float y) {
        int childCount = parent.getChildCount();
        for (int i = childCount - 1; i >= 0; i--) {
            View child = parent.getChildAt(i);
            if (isChildUnder(child, x, y)) {
                return child;
            }
        }
        return null;
    }

    private static boolean isChildUnder(View child, float x, float y) {
        float left = child.getX();
        float top = child.getY();
        float right = child.getWidth() + left;
        float bottom = child.getHeight() + top;
        return x >= left && y >= top && x < right && y < bottom;
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        boolean alignParentBottom;
        boolean ignoreParentPadding;
        boolean listView;

        public LayoutParams(Context c, AttributeSet attrs) {
            super(c, attrs);
            TypedArray a = c.obtainStyledAttributes(attrs, R.styleable.NestedScrollingLayout_LayoutParams);
            this.alignParentBottom = a.getBoolean(0, false);
            this.ignoreParentPadding = a.getBoolean(1, false);
            this.listView = a.getBoolean(2, false);
            a.recycle();
        }

        public LayoutParams(int width, int height) {
            super(width, height);
        }

        public LayoutParams(LayoutParams source) {
            super((ViewGroup.MarginLayoutParams) source);
            this.alignParentBottom = source.alignParentBottom;
            this.ignoreParentPadding = source.ignoreParentPadding;
            this.listView = source.listView;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams source) {
            super(source);
        }

        public LayoutParams(ViewGroup.LayoutParams source) {
            super(source);
        }
    }

    public void setScrollToDismissEnabled(boolean scrollToDismissEnabled) {
        this.mScrollToDismissEnabled = scrollToDismissEnabled;
    }

    public void setStyle(int style) {
        this.mStyle = style;
    }

    public void setDismissedOnTouchOutside(boolean dismiss) {
        this.mDismissedOnTouchOutside = dismiss;
    }

    public void cancelDrag() {
        ViewGroup parent = (ViewGroup) getParent();
        long now = SystemClock.uptimeMillis();
        MotionEvent event = MotionEvent.obtain(now, now, 3, 0.0f, 0.0f, 0);
        event.setSource(4098);
        parent.dispatchTouchEvent(event);
        event.recycle();
        this.mDragCanceled = true;
    }
}
