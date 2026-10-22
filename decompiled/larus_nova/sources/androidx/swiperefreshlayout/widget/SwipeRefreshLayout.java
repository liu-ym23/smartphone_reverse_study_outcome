package androidx.swiperefreshlayout.widget;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.widget.ListView;
import androidx.camera.video.AudioStats;
import androidx.core.content.ContextCompat;
import androidx.core.view.NestedScrollingChild;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.NestedScrollingParent;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.core.view.ViewCompat;
import androidx.core.widget.ListViewCompat;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;

/* JADX INFO: loaded from: classes17.dex */
public class SwipeRefreshLayout extends ViewGroup implements NestedScrollingParent, NestedScrollingChild {
    private static final int ALPHA_ANIMATION_DURATION = 300;
    private static final int ANIMATE_TO_START_DURATION = 200;
    private static final int ANIMATE_TO_TRIGGER_DURATION = 200;
    private static final int CIRCLE_BG_LIGHT = -328966;
    static final int CIRCLE_DIAMETER = 40;
    static final int CIRCLE_DIAMETER_LARGE = 56;
    private static final float DECELERATE_INTERPOLATION_FACTOR = 2.0f;
    public static final int DEFAULT = 1;
    private static final int DEFAULT_CIRCLE_TARGET = 64;
    public static final int DEFAULT_SLINGSHOT_DISTANCE = -1;
    private static final float DRAG_RATE = 0.5f;
    private static final int INVALID_POINTER = -1;
    public static final int LARGE = 0;
    private static final int[] LAYOUT_ATTRS = null;
    private static final String LOG_TAG = null;
    private static final int MAX_ALPHA = 255;
    private static final float MAX_PROGRESS_ANGLE = 0.8f;
    private static final int SCALE_DOWN_DURATION = 150;
    private static final int STARTING_PROGRESS_ALPHA = 76;
    private int mActivePointerId;
    private Animation mAlphaMaxAnimation;
    private Animation mAlphaStartAnimation;
    private final Animation mAnimateToCorrectPosition;
    private final Animation mAnimateToStartPosition;
    private OnChildScrollUpCallback mChildScrollUpCallback;
    private int mCircleDiameter;
    CircleImageView mCircleView;
    private int mCircleViewIndex;
    int mCurrentTargetOffsetTop;
    int mCustomSlingshotDistance;
    private final DecelerateInterpolator mDecelerateInterpolator;
    protected int mFrom;
    private float mInitialDownY;
    private float mInitialMotionY;
    private boolean mIsBeingDragged;
    OnRefreshListener mListener;
    private int mMediumAnimationDuration;
    private boolean mNestedScrollInProgress;
    private final NestedScrollingChildHelper mNestedScrollingChildHelper;
    private final NestedScrollingParentHelper mNestedScrollingParentHelper;
    boolean mNotify;
    protected int mOriginalOffsetTop;
    private final int[] mParentOffsetInWindow;
    private final int[] mParentScrollConsumed;
    CircularProgressDrawable mProgress;
    private Animation.AnimationListener mRefreshListener;
    boolean mRefreshing;
    private boolean mReturningToStart;
    boolean mScale;
    private Animation mScaleAnimation;
    private Animation mScaleDownAnimation;
    private Animation mScaleDownToStartAnimation;
    int mSpinnerOffsetEnd;
    float mStartingScale;
    private View mTarget;
    private float mTotalDragDistance;
    private float mTotalUnconsumed;
    private int mTouchSlop;
    boolean mUsingCustomStart;

    public interface OnChildScrollUpCallback {
        boolean canChildScrollUp(SwipeRefreshLayout r100, View r101);
    }

    public interface OnRefreshListener {
        void onRefresh();
    }

    static {
        LOG_TAG = "SwipeRefreshLayout";
        LAYOUT_ATTRS = new int[]{R.attr.enabled};
    }

    private void createProgressView() {
        this.mCircleView = new CircleImageView(getContext(), CIRCLE_BG_LIGHT);
        CircularProgressDrawable r100 = new CircularProgressDrawable(getContext());
        this.mProgress = r100;
        r100.setStyle(1);
        this.mCircleView.setImageDrawable(this.mProgress);
        this.mCircleView.setVisibility(8);
        addView(this.mCircleView);
    }

    private void ensureTarget() {
        if (this.mTarget != null) goto L11;
        int r100 = 0;
    L6:
        if (r100 >= getChildCount()) goto L15;
        View r101 = getChildAt(r100);
        if (r101.equals(this.mCircleView) == false) goto L9;
        r100 = r100 + 1;
        goto L6
    L9:
        this.mTarget = r101;
        return;
    L15:
        return;
    }

    private void startProgressAlphaMaxAnimation() {
        this.mAlphaMaxAnimation = startAlphaAnimation(this.mProgress.getAlpha(), 255);
    }

    private void startProgressAlphaStartAnimation() {
        this.mAlphaStartAnimation = startAlphaAnimation(this.mProgress.getAlpha(), 76);
    }

    public boolean canChildScrollUp() {
        OnChildScrollUpCallback r100 = this.mChildScrollUpCallback;
        if (r100 != null) goto L5;
        View r101 = this.mTarget;
        if ((r101 instanceof ListView) == false) goto L11;
        return ListViewCompat.canScrollList((ListView) r101, -1);
    L11:
        return r101.canScrollVertically(-1);
    L5:
        return r100.canChildScrollUp(this, this.mTarget);
    }

    @Override // android.view.ViewGroup, androidx.core.view.NestedScrollingParent
    public int getNestedScrollAxes() {
        return this.mNestedScrollingParentHelper.getNestedScrollAxes();
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean hasNestedScrollingParent() {
        return this.mNestedScrollingChildHelper.hasNestedScrollingParent();
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean isNestedScrollingEnabled() {
        return this.mNestedScrollingChildHelper.isNestedScrollingEnabled();
    }

    public void reset() {
        this.mCircleView.clearAnimation();
        this.mProgress.stop();
        this.mCircleView.setVisibility(8);
        setColorViewAlpha(255);
        if (this.mScale == false) goto L5;
        setAnimationProgress(0.0f);
    L6:
        this.mCurrentTargetOffsetTop = this.mCircleView.getTop();
        return;
    L5:
        setTargetOffsetTopAndBottom(this.mOriginalOffsetTop - this.mCurrentTargetOffsetTop);
        goto L6
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void stopNestedScroll() {
        this.mNestedScrollingChildHelper.stopNestedScroll();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        reset();
    }

    public int getProgressCircleDiameter() {
        return this.mCircleDiameter;
    }

    public int getProgressViewEndOffset() {
        return this.mSpinnerOffsetEnd;
    }

    public int getProgressViewStartOffset() {
        return this.mOriginalOffsetTop;
    }

    public boolean isRefreshing() {
        return this.mRefreshing;
    }

    public SwipeRefreshLayout(Context r100) {
        this(r100, null);
    }

    public static DisplayMetrics INVOKEVIRTUAL_androidx_swiperefreshlayout_widget_SwipeRefreshLayout_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r100) {
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
    }

    private void finishSpinner(float r100) {
        if (r100 <= this.mTotalDragDistance) goto L5;
        setRefreshing(true, true);
        return;
    L5:
        this.mRefreshing = false;
        this.mProgress.setStartEndTrim(0.0f, 0.0f);
        if (this.mScale == true) goto L8;
        Animation.AnimationListener r101 = new AnonymousClass5(this);
    L9:
        animateOffsetToStartPosition(this.mCurrentTargetOffsetTop, r101);
        this.mProgress.setArrowEnabled(false);
        return;
    L8:
        r101 = null;
        goto L9
    }

    private boolean isAnimationRunning(Animation r100) {
        if (r100 != null) goto L4;
    L8:
        return false;
    L4:
        if (r100.hasStarted() == false) goto L8;
        if (r100.hasEnded() == true) goto L8;
        return true;
    }

    private void moveSpinner(float r110) {
        this.mProgress.setArrowEnabled(true);
        float r100 = Math.min(1.0f, Math.abs(r110 / this.mTotalDragDistance));
        float r101 = (((float) Math.max(((double) r100) - 0.4d, AudioStats.AUDIO_AMPLITUDE_NONE)) * 5.0f) / 3.0f;
        float r102 = Math.abs(r110) - this.mTotalDragDistance;
        int r103 = this.mCustomSlingshotDistance;
        if (r103 <= 0) goto L6;
    L4:
        float r104 = r103;
        double r105 = Math.max(0.0f, Math.min(r102, r104 * 2.0f) / r104) / 4.0f;
        float r106 = ((float) (r105 - Math.pow(r105, 2.0d))) * 2.0f;
        int r107 = this.mOriginalOffsetTop + ((int) ((r104 * r100) + ((r104 * r106) * 2.0f)));
        if (this.mCircleView.getVisibility() == 0) goto L13;
        this.mCircleView.setVisibility(0);
    L13:
        if (this.mScale == true) goto L16;
        this.mCircleView.setScaleX(1.0f);
        this.mCircleView.setScaleY(1.0f);
    L16:
        if (this.mScale == false) goto L19;
        setAnimationProgress(Math.min(1.0f, r110 / this.mTotalDragDistance));
    L19:
        if (r110 >= this.mTotalDragDistance) goto L26;
        if (this.mProgress.getAlpha() > 76) goto L23;
    L30:
        this.mProgress.setStartEndTrim(0.0f, Math.min(0.8f, r101 * 0.8f));
        this.mProgress.setArrowScale(Math.min(1.0f, r101));
        this.mProgress.setProgressRotation((((r101 * 0.4f) - 0.25f) + (r106 * 2.0f)) * 0.5f);
        setTargetOffsetTopAndBottom(r107 - this.mCurrentTargetOffsetTop);
        return;
    L23:
        if (isAnimationRunning(this.mAlphaStartAnimation) == true) goto L30;
        startProgressAlphaStartAnimation();
        goto L30
    L26:
        if (this.mProgress.getAlpha() >= 255) goto L30;
        if (isAnimationRunning(this.mAlphaMaxAnimation) == true) goto L30;
        startProgressAlphaMaxAnimation();
        goto L30
    L6:
        if (this.mUsingCustomStart == false) goto L8;
        r103 = this.mSpinnerOffsetEnd - this.mOriginalOffsetTop;
        goto L4
    L8:
        r103 = this.mSpinnerOffsetEnd;
        goto L4
    }

    private void onSecondaryPointerUp(MotionEvent r100) {
        int r101 = r100.getActionIndex();
        if (r100.getPointerId(r101) != this.mActivePointerId) goto L9;
        if (r101 != 0) goto L6;
        int r102 = 1;
    L7:
        this.mActivePointerId = r100.getPointerId(r102);
        return;
    L6:
        r102 = 0;
        goto L7
    }

    private void setColorViewAlpha(int r100) {
        this.mCircleView.getBackground().setAlpha(r100);
        this.mProgress.setAlpha(r100);
    }

    private void startDragging(float r100) {
        float r101 = this.mInitialDownY;
        float r102 = r100 - r101;
        int r103 = this.mTouchSlop;
        if (r102 > r103) goto L5;
        return;
    L5:
        if (this.mIsBeingDragged == true) goto L9;
        this.mInitialMotionY = r101 + r103;
        this.mIsBeingDragged = true;
        this.mProgress.setAlpha(76);
        return;
    }

    private void startScaleUpAnimation(Animation.AnimationListener r100) {
        this.mCircleView.setVisibility(0);
        this.mProgress.setAlpha(255);
        Animation r101 = new AnonymousClass2(this);
        this.mScaleAnimation = r101;
        r101.setDuration(this.mMediumAnimationDuration);
        if (r100 == null) goto L5;
        this.mCircleView.setAnimationListener(r100);
    L5:
        this.mCircleView.clearAnimation();
        this.mCircleView.startAnimation(this.mScaleAnimation);
    }

    public void moveToStart(float r100) {
        int r101 = this.mFrom;
        setTargetOffsetTopAndBottom((r101 + ((int) ((this.mOriginalOffsetTop - r101) * r100))) - this.mCircleView.getTop());
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent r100) {
        ensureTarget();
        int r101 = r100.getActionMasked();
        if (this.mReturningToStart == false) goto L7;
        if (r101 != 0) goto L7;
        this.mReturningToStart = false;
    L7:
        if (isEnabled() == true) goto L9;
    L42:
        return false;
    L9:
        if (this.mReturningToStart == true) goto L42;
        if (canChildScrollUp() == true) goto L42;
        if (this.mRefreshing == true) goto L42;
        if (this.mNestedScrollInProgress == true) goto L42;
        if (r101 != 0) goto L19;
        setTargetOffsetTopAndBottom(this.mOriginalOffsetTop - this.mCircleView.getTop());
        int r102 = r100.getPointerId(0);
        this.mActivePointerId = r102;
        this.mIsBeingDragged = false;
        int r103 = r100.findPointerIndex(r102);
        if (r103 >= 0) goto L39;
        return false;
    L39:
        this.mInitialDownY = r100.getY(r103);
    L41:
        return this.mIsBeingDragged;
    L19:
        if (r101 != 1) goto L21;
    L35:
        this.mIsBeingDragged = false;
        this.mActivePointerId = -1;
        goto L41
    L21:
        if (r101 != 2) goto L23;
        int r104 = this.mActivePointerId;
        if (r104 != (-1)) goto L31;
        return false;
    L31:
        int r105 = r100.findPointerIndex(r104);
        if (r105 >= 0) goto L34;
        return false;
    L34:
        startDragging(r100.getY(r105));
        goto L41
    L23:
        if (r101 == 3) goto L35;
        if (r101 != 6) goto L41;
        onSecondaryPointerUp(r100);
        goto L41
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onStopNestedScroll(View r100) {
        this.mNestedScrollingParentHelper.onStopNestedScroll(r100);
        this.mNestedScrollInProgress = false;
        float r101 = this.mTotalUnconsumed;
        if (r101 <= 0.0f) goto L5;
        finishSpinner(r101);
        this.mTotalUnconsumed = 0.0f;
    L5:
        stopNestedScroll();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent r100) {
        int r101 = r100.getActionMasked();
        if (this.mReturningToStart == false) goto L7;
        if (r101 != 0) goto L7;
        this.mReturningToStart = false;
    L7:
        if (isEnabled() == true) goto L9;
    L55:
        return false;
    L9:
        if (this.mReturningToStart == true) goto L55;
        if (canChildScrollUp() == true) goto L55;
        if (this.mRefreshing == true) goto L55;
        if (this.mNestedScrollInProgress == true) goto L55;
        if (r101 != 0) goto L20;
        this.mActivePointerId = r100.getPointerId(0);
        this.mIsBeingDragged = false;
    L54:
        return true;
    L20:
        if (r101 != 1) goto L22;
        int r102 = r100.findPointerIndex(this.mActivePointerId);
        if (r102 >= 0) goto L49;
        return false;
    L49:
        if (this.mIsBeingDragged == false) goto L51;
        float r103 = (r100.getY(r102) - this.mInitialMotionY) * 0.5f;
        this.mIsBeingDragged = false;
        finishSpinner(r103);
    L51:
        this.mActivePointerId = -1;
        return false;
    L22:
        if (r101 != 2) goto L24;
        int r104 = r100.findPointerIndex(this.mActivePointerId);
        if (r104 >= 0) goto L39;
        return false;
    L39:
        float r105 = r100.getY(r104);
        startDragging(r105);
        if (this.mIsBeingDragged == false) goto L54;
        float r106 = (r105 - this.mInitialMotionY) * 0.5f;
        if (r106 <= 0.0f) goto L44;
        moveSpinner(r106);
        goto L54
    L44:
        return false;
    L24:
        if (r101 != 3) goto L26;
        return false;
    L26:
        if (r101 != 5) goto L28;
        int r107 = r100.getActionIndex();
        if (r107 >= 0) goto L34;
        return false;
    L34:
        this.mActivePointerId = r100.getPointerId(r107);
        goto L54
    L28:
        if (r101 != 6) goto L54;
        onSecondaryPointerUp(r100);
        goto L54
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean r100) {
        View r101 = this.mTarget;
        if (r101 != null) goto L5;
    L7:
        super.requestDisallowInterceptTouchEvent(r100);
        return;
    L5:
        if (ViewCompat.isNestedScrollingEnabled(r101) == true) goto L7;
    }

    public void setAnimationProgress(float r100) {
        this.mCircleView.setScaleX(r100);
        this.mCircleView.setScaleY(r100);
    }

    public void setColorScheme(int... r100) {
        setColorSchemeResources(r100);
    }

    public void setColorSchemeColors(int... r100) {
        ensureTarget();
        this.mProgress.setColorSchemeColors(r100);
    }

    public void setColorSchemeResources(int... r100) {
        Context r101 = getContext();
        int[] r102 = new int[r100.length];
        int r103 = 0;
    L4:
        if (r103 >= r100.length) goto L6;
        r102[r103] = ContextCompat.getColor(r101, r100[r103]);
        r103 = r103 + 1;
        goto L4
    L6:
        setColorSchemeColors(r102);
    }

    public void setDistanceToTriggerSync(int r100) {
        this.mTotalDragDistance = r100;
    }

    @Override // android.view.View
    public void setEnabled(boolean r100) {
        super.setEnabled(r100);
        if (r100 == true) goto L6;
        reset();
        return;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void setNestedScrollingEnabled(boolean r100) {
        this.mNestedScrollingChildHelper.setNestedScrollingEnabled(r100);
    }

    public void setOnChildScrollUpCallback(OnChildScrollUpCallback r100) {
        this.mChildScrollUpCallback = r100;
    }

    public void setOnRefreshListener(OnRefreshListener r100) {
        this.mListener = r100;
    }

    public void setProgressBackgroundColor(int r100) {
        setProgressBackgroundColorSchemeResource(r100);
    }

    public void setProgressBackgroundColorSchemeColor(int r100) {
        this.mCircleView.setBackgroundColor(r100);
    }

    public void setProgressBackgroundColorSchemeResource(int r100) {
        setProgressBackgroundColorSchemeColor(ContextCompat.getColor(getContext(), r100));
    }

    public void setRefreshing(boolean r100) {
        if (r100 == true) goto L5;
    L11:
        setRefreshing(r100, false);
        return;
    L5:
        if (this.mRefreshing == r100) goto L11;
        this.mRefreshing = r100;
        if (this.mUsingCustomStart == true) goto L9;
        int r101 = this.mSpinnerOffsetEnd + this.mOriginalOffsetTop;
    L10:
        setTargetOffsetTopAndBottom(r101 - this.mCurrentTargetOffsetTop);
        this.mNotify = false;
        startScaleUpAnimation(this.mRefreshListener);
        return;
    L9:
        r101 = this.mSpinnerOffsetEnd;
        goto L10
    }

    public void setSize(int r100) {
        if (r100 != 0) goto L4;
    L6:
        DisplayMetrics r101 = INVOKEVIRTUAL_androidx_swiperefreshlayout_widget_SwipeRefreshLayout_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(getResources());
        if (r100 != 0) goto L9;
        this.mCircleDiameter = (int) (r101.density * 56.0f);
    L10:
        this.mCircleView.setImageDrawable(null);
        this.mProgress.setStyle(r100);
        this.mCircleView.setImageDrawable(this.mProgress);
        return;
    L9:
        this.mCircleDiameter = (int) (r101.density * 40.0f);
        goto L10
    L4:
        if (r100 == 1) goto L6;
    }

    public void setSlingshotDistance(int r100) {
        this.mCustomSlingshotDistance = r100;
    }

    public void setTargetOffsetTopAndBottom(int r100) {
        this.mCircleView.bringToFront();
        ViewCompat.offsetTopAndBottom(this.mCircleView, r100);
        this.mCurrentTargetOffsetTop = this.mCircleView.getTop();
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean startNestedScroll(int r100) {
        return this.mNestedScrollingChildHelper.startNestedScroll(r100);
    }

    public void startScaleDownAnimation(Animation.AnimationListener r100) {
        Animation r101 = new AnonymousClass3(this);
        this.mScaleDownAnimation = r101;
        r101.setDuration(150);
        this.mCircleView.setAnimationListener(r100);
        this.mCircleView.clearAnimation();
        this.mCircleView.startAnimation(this.mScaleDownAnimation);
    }

    public SwipeRefreshLayout(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.mRefreshing = false;
        this.mTotalDragDistance = -1.0f;
        this.mParentScrollConsumed = new int[2];
        this.mParentOffsetInWindow = new int[2];
        this.mActivePointerId = -1;
        this.mCircleViewIndex = -1;
        this.mRefreshListener = new AnonymousClass1(this);
        this.mAnimateToCorrectPosition = new AnonymousClass6(this);
        this.mAnimateToStartPosition = new AnonymousClass7(this);
        this.mTouchSlop = ViewConfiguration.get(r100).getScaledTouchSlop();
        this.mMediumAnimationDuration = getResources().getInteger(R.integer.config_mediumAnimTime);
        setWillNotDraw(false);
        this.mDecelerateInterpolator = new DecelerateInterpolator(2.0f);
        DisplayMetrics r102 = INVOKEVIRTUAL_androidx_swiperefreshlayout_widget_SwipeRefreshLayout_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(getResources());
        this.mCircleDiameter = (int) (r102.density * 40.0f);
        createProgressView();
        setChildrenDrawingOrderEnabled(true);
        int r103 = (int) (r102.density * 64.0f);
        this.mSpinnerOffsetEnd = r103;
        this.mTotalDragDistance = r103;
        this.mNestedScrollingParentHelper = new NestedScrollingParentHelper(this);
        this.mNestedScrollingChildHelper = new NestedScrollingChildHelper(this);
        setNestedScrollingEnabled(true);
        int r104 = -this.mCircleDiameter;
        this.mCurrentTargetOffsetTop = r104;
        this.mOriginalOffsetTop = r104;
        moveToStart(1.0f);
        TypedArray r105 = r100.obtainStyledAttributes(r101, LAYOUT_ATTRS);
        setEnabled(r105.getBoolean(0, true));
        r105.recycle();
    }

    private void animateOffsetToCorrectPosition(int r100, Animation.AnimationListener r101) {
        this.mFrom = r100;
        this.mAnimateToCorrectPosition.reset();
        this.mAnimateToCorrectPosition.setDuration(200);
        this.mAnimateToCorrectPosition.setInterpolator(this.mDecelerateInterpolator);
        if (r101 == null) goto L5;
        this.mCircleView.setAnimationListener(r101);
    L5:
        this.mCircleView.clearAnimation();
        this.mCircleView.startAnimation(this.mAnimateToCorrectPosition);
    }

    private void animateOffsetToStartPosition(int r100, Animation.AnimationListener r101) {
        if (this.mScale == false) goto L5;
        startScaleDownReturnToStartAnimation(r100, r101);
        return;
    L5:
        this.mFrom = r100;
        this.mAnimateToStartPosition.reset();
        this.mAnimateToStartPosition.setDuration(200);
        this.mAnimateToStartPosition.setInterpolator(this.mDecelerateInterpolator);
        if (r101 == null) goto L8;
        this.mCircleView.setAnimationListener(r101);
    L8:
        this.mCircleView.clearAnimation();
        this.mCircleView.startAnimation(this.mAnimateToStartPosition);
    }

    private void setRefreshing(boolean r100, boolean r101) {
        if (this.mRefreshing == r100) goto L9;
        this.mNotify = r101;
        ensureTarget();
        this.mRefreshing = r100;
        if (r100 == false) goto L7;
        animateOffsetToCorrectPosition(this.mCurrentTargetOffsetTop, this.mRefreshListener);
        return;
    L7:
        startScaleDownAnimation(this.mRefreshListener);
        return;
    }

    private Animation startAlphaAnimation(final int r100, final int r101) {
        Animation r102 = new AnonymousClass4(this, r100, r101);
        r102.setDuration(300);
        this.mCircleView.setAnimationListener(null);
        this.mCircleView.clearAnimation();
        this.mCircleView.startAnimation(r102);
        return r102;
    }

    private void startScaleDownReturnToStartAnimation(int r100, Animation.AnimationListener r101) {
        this.mFrom = r100;
        this.mStartingScale = this.mCircleView.getScaleX();
        Animation r102 = new AnonymousClass8(this);
        this.mScaleDownToStartAnimation = r102;
        r102.setDuration(150);
        if (r101 == null) goto L5;
        this.mCircleView.setAnimationListener(r101);
    L5:
        this.mCircleView.clearAnimation();
        this.mCircleView.startAnimation(this.mScaleDownToStartAnimation);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreFling(float r100, float r101) {
        return this.mNestedScrollingChildHelper.dispatchNestedPreFling(r100, r101);
    }

    @Override // android.view.ViewGroup
    public int getChildDrawingOrder(int r100, int r101) {
        int r102 = this.mCircleViewIndex;
        if (r102 >= 0) goto L6;
        return r101;
    L6:
        if (r101 != (r100 - 1)) goto L8;
        return r102;
    L8:
        if (r101 >= r102) goto L10;
        return r101;
    L10:
        return r101 + 1;
    }

    @Override // android.view.View
    public void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        if (this.mTarget != null) goto L5;
        ensureTarget();
    L5:
        View r102 = this.mTarget;
        if (r102 != null) goto L8;
        return;
    L8:
        r102.measure(View.MeasureSpec.makeMeasureSpec((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), 1073741824), View.MeasureSpec.makeMeasureSpec((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), 1073741824));
        this.mCircleView.measure(View.MeasureSpec.makeMeasureSpec(this.mCircleDiameter, 1073741824), View.MeasureSpec.makeMeasureSpec(this.mCircleDiameter, 1073741824));
        this.mCircleViewIndex = -1;
        int r103 = 0;
    L10:
        if (r103 >= getChildCount()) goto L18;
        if (getChildAt(r103) == this.mCircleView) goto L13;
        r103 = r103 + 1;
        goto L10
    L13:
        this.mCircleViewIndex = r103;
        return;
    }

    public void setProgressViewEndTarget(boolean r100, int r101) {
        this.mSpinnerOffsetEnd = r101;
        this.mScale = r100;
        this.mCircleView.invalidate();
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedFling(float r100, float r101, boolean r102) {
        return this.mNestedScrollingChildHelper.dispatchNestedFling(r100, r101, r102);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedPreFling(View r100, float r101, float r102) {
        return dispatchNestedPreFling(r101, r102);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScrollAccepted(View r100, View r101, int r102) {
        this.mNestedScrollingParentHelper.onNestedScrollAccepted(r100, r101, r102);
        startNestedScroll(r102 & 2);
        this.mTotalUnconsumed = 0.0f;
        this.mNestedScrollInProgress = true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onStartNestedScroll(View r100, View r101, int r102) {
        if (isEnabled() == true) goto L5;
    L11:
        return false;
    L5:
        if (this.mReturningToStart == true) goto L11;
        if (this.mRefreshing == true) goto L11;
        if ((r102 & 2) == 0) goto L11;
        return true;
    }

    public void setProgressViewOffset(boolean r100, int r101, int r102) {
        this.mScale = r100;
        this.mOriginalOffsetTop = r101;
        this.mSpinnerOffsetEnd = r102;
        this.mUsingCustomStart = true;
        reset();
        this.mRefreshing = false;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreScroll(int r100, int r101, int[] r102, int[] r103) {
        return this.mNestedScrollingChildHelper.dispatchNestedPreScroll(r100, r101, r102, r103);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedFling(View r100, float r101, float r102, boolean r103) {
        return dispatchNestedFling(r101, r102, r103);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedPreScroll(View r100, int r101, int r102, int[] r103) {
        if (r102 <= 0) goto L12;
        float r104 = this.mTotalUnconsumed;
        if (r104 <= 0.0f) goto L12;
        float r105 = r102;
        if (r105 <= r104) goto L9;
        r103[1] = r102 - ((int) r104);
        this.mTotalUnconsumed = 0.0f;
    L10:
        moveSpinner(this.mTotalUnconsumed);
        goto L12
    L9:
        this.mTotalUnconsumed = r104 - r105;
        r103[1] = r102;
    L12:
        if (this.mUsingCustomStart == false) goto L19;
        if (r102 <= 0) goto L19;
        if (this.mTotalUnconsumed != 0.0f) goto L19;
        if (Math.abs(r102 - r103[1]) <= 0) goto L19;
        this.mCircleView.setVisibility(8);
    L19:
        int[] r106 = this.mParentScrollConsumed;
        if (dispatchNestedPreScroll(r101 - r103[0], r102 - r103[1], r106, null) == false) goto L23;
        r103[0] = r103[0] + r106[0];
        r103[1] = r103[1] + r106[1];
        return;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedScroll(int r100, int r101, int r102, int r110, int[] r111) {
        return this.mNestedScrollingChildHelper.dispatchNestedScroll(r100, r101, r102, r110, r111);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        int r105 = getMeasuredWidth();
        int r106 = getMeasuredHeight();
        if (getChildCount() != 0) goto L6;
        return;
    L6:
        if (this.mTarget != null) goto L8;
        ensureTarget();
    L8:
        View r107 = this.mTarget;
        if (r107 != null) goto L11;
        return;
    L11:
        int r108 = getPaddingLeft();
        int r109 = getPaddingTop();
        int r110 = (r105 - getPaddingLeft()) - getPaddingRight();
        r107.layout(r108, r109, r110 + r108, ((r106 - getPaddingTop()) - getPaddingBottom()) + r109);
        int r111 = this.mCircleView.getMeasuredWidth();
        int r112 = this.mCircleView.getMeasuredHeight();
        int r113 = r105 / 2;
        int r114 = r111 / 2;
        int r115 = this.mCurrentTargetOffsetTop;
        this.mCircleView.layout(r113 - r114, r115, r113 + r114, r112 + r115);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScroll(View r100, int r101, int r102, int r110, int r111) {
        dispatchNestedScroll(r101, r102, r110, r111, this.mParentOffsetInWindow);
        int r112 = r111 + this.mParentOffsetInWindow[1];
        if (r112 < 0) goto L5;
        return;
    L5:
        if (canChildScrollUp() == true) goto L9;
        float r103 = this.mTotalUnconsumed + Math.abs(r112);
        this.mTotalUnconsumed = r103;
        moveSpinner(r103);
        return;
    }
}
