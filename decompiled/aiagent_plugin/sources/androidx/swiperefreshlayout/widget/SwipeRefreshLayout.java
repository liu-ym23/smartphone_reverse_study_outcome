package androidx.swiperefreshlayout.widget;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.widget.AbsListView;
import android.widget.ListView;
import androidx.core.view.ViewCompat;
import androidx.core.view.l;
import androidx.core.view.o;
import androidx.core.view.p;
import androidx.core.view.s;
import androidx.core.widget.e;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes.dex */
public class SwipeRefreshLayout extends ViewGroup implements l, p {
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
    private static final String LOG_TAG = "SwipeRefreshLayout";
    private static final int MAX_ALPHA = 255;
    private static final float MAX_PROGRESS_ANGLE = 0.8f;
    private static final int SCALE_DOWN_DURATION = 150;
    private static final int STARTING_PROGRESS_ALPHA = 76;
    private int mActivePointerId;
    private Animation mAlphaMaxAnimation;
    private Animation mAlphaStartAnimation;
    private final Animation mAnimateToCorrectPosition;
    private final Animation mAnimateToStartPosition;
    private a mChildScrollUpCallback;
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
    b mListener;
    private int mMediumAnimationDuration;
    private boolean mNestedScrollInProgress;
    private final o mNestedScrollingChildHelper;
    private final s mNestedScrollingParentHelper;
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

    public interface a {
        boolean a(SwipeRefreshLayout r1, View r2);
    }

    public interface b {
        void a();
    }

    public static /* synthetic */ int access$000(String r0, String r1) {
        return Log.e(r0, r1);
    }

    static {
        LAYOUT_ATTRS = new int[]{R.attr.enabled};
    }

    void reset() {
        this.mCircleView.clearAnimation();
        this.mProgress.stop();
        this.mCircleView.setVisibility(8);
        setColorViewAlpha(MAX_ALPHA);
        if (this.mScale == false) goto L5;
        setAnimationProgress(0.0f);
    L6:
        this.mCurrentTargetOffsetTop = this.mCircleView.getTop();
        return;
    L5:
        setTargetOffsetTopAndBottom(this.mOriginalOffsetTop - this.mCurrentTargetOffsetTop);
        goto L6
    }

    @Override // android.view.View
    public void setEnabled(boolean r1) {
        super.setEnabled(r1);
        if (r1 == true) goto L6;
        reset();
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        reset();
    }

    private void setColorViewAlpha(int r2) {
        this.mCircleView.getBackground().setAlpha(r2);
        this.mProgress.setAlpha(r2);
    }

    public void setProgressViewOffset(boolean r1, int r2, int r3) {
        this.mScale = r1;
        this.mOriginalOffsetTop = r2;
        this.mSpinnerOffsetEnd = r3;
        this.mUsingCustomStart = true;
        reset();
        this.mRefreshing = false;
    }

    public int getProgressViewStartOffset() {
        return this.mOriginalOffsetTop;
    }

    public int getProgressViewEndOffset() {
        return this.mSpinnerOffsetEnd;
    }

    public void setProgressViewEndTarget(boolean r1, int r2) {
        this.mSpinnerOffsetEnd = r2;
        this.mScale = r1;
        this.mCircleView.invalidate();
    }

    public void setSlingshotDistance(int r1) {
        this.mCustomSlingshotDistance = r1;
    }

    public void setSize(int r3) {
        if (r3 != 0) goto L4;
    L6:
        DisplayMetrics r0 = ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin").getDisplayMetrics();
        if (r3 != 0) goto L9;
        this.mCircleDiameter = (int) (r0.density * 56.0f);
    L10:
        this.mCircleView.setImageDrawable(null);
        this.mProgress.setStyle(r3);
        this.mCircleView.setImageDrawable(this.mProgress);
        return;
    L9:
        this.mCircleDiameter = (int) (r0.density * 40.0f);
        goto L10
    L4:
        if (r3 == 1) goto L6;
    }

    public SwipeRefreshLayout(Context r3) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), null);
    }

    public SwipeRefreshLayout(Context r5, AttributeSet r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r6, AttributeSet.class, "com.obric.aiagent.plugin");
        super(r7, r8);
        this.mRefreshing = false;
        this.mTotalDragDistance = -1.0f;
        this.mParentScrollConsumed = new int[2];
        this.mParentOffsetInWindow = new int[2];
        this.mActivePointerId = -1;
        this.mCircleViewIndex = -1;
        this.mRefreshListener = new AnonymousClass1(this);
        this.mAnimateToCorrectPosition = new AnonymousClass6(this);
        this.mAnimateToStartPosition = new AnonymousClass7(this);
        this.mTouchSlop = ViewConfiguration.get(r7).getScaledTouchSlop();
        this.mMediumAnimationDuration = ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin").getInteger(R.integer.config_mediumAnimTime);
        setWillNotDraw(false);
        this.mDecelerateInterpolator = new DecelerateInterpolator(DECELERATE_INTERPOLATION_FACTOR);
        DisplayMetrics r1 = ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin").getDisplayMetrics();
        this.mCircleDiameter = (int) (r1.density * 40.0f);
        createProgressView();
        setChildrenDrawingOrderEnabled(true);
        int r2 = (int) (r1.density * 64.0f);
        this.mSpinnerOffsetEnd = r2;
        this.mTotalDragDistance = r2;
        this.mNestedScrollingParentHelper = new s(this);
        this.mNestedScrollingChildHelper = new o(this);
        setNestedScrollingEnabled(true);
        int r3 = -this.mCircleDiameter;
        this.mCurrentTargetOffsetTop = r3;
        this.mOriginalOffsetTop = r3;
        moveToStart(1.0f);
        TypedArray r9 = r7.obtainStyledAttributes(r8, LAYOUT_ATTRS);
        setEnabled(r9.getBoolean(0, true));
        r9.recycle();
    }

    @Override // android.view.ViewGroup
    public int getChildDrawingOrder(int r1, int r2) {
        int r0 = this.mCircleViewIndex;
        if (r0 >= 0) goto L6;
        return r2;
    L6:
        if (r2 != (r1 - 1)) goto L8;
        return r0;
    L8:
        if (r2 >= r0) goto L10;
        return r2;
    L10:
        return r2 + 1;
    }

    private void createProgressView() {
        this.mCircleView = new CircleImageView((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), CIRCLE_BG_LIGHT);
        CircularProgressDrawable r0 = new CircularProgressDrawable((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
        this.mProgress = r0;
        r0.setStyle(1);
        this.mCircleView.setImageDrawable(this.mProgress);
        this.mCircleView.setVisibility(8);
        addView(this.mCircleView);
    }

    public void setOnRefreshListener(b r3) {
        this.mListener = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.aiagent.plugin");
    }

    public void setRefreshing(boolean r3) {
        if (r3 == true) goto L5;
    L11:
        setRefreshing(r3, false);
        return;
    L5:
        if (this.mRefreshing == r3) goto L11;
        this.mRefreshing = r3;
        if (this.mUsingCustomStart == true) goto L9;
        int r4 = this.mSpinnerOffsetEnd + this.mOriginalOffsetTop;
    L10:
        setTargetOffsetTopAndBottom(r4 - this.mCurrentTargetOffsetTop);
        this.mNotify = false;
        startScaleUpAnimation(this.mRefreshListener);
        return;
    L9:
        r4 = this.mSpinnerOffsetEnd;
        goto L10
    }

    private void startScaleUpAnimation(Animation.AnimationListener r4) {
        Animation.AnimationListener r5 = (Animation.AnimationListener) ZeusTransformUtils.wrapperContextForParams(r4, Animation.AnimationListener.class, "com.obric.aiagent.plugin");
        this.mCircleView.setVisibility(0);
        this.mProgress.setAlpha(MAX_ALPHA);
        Animation r0 = new AnonymousClass2(this);
        this.mScaleAnimation = r0;
        r0.setDuration(this.mMediumAnimationDuration);
        if (r5 == null) goto L5;
        this.mCircleView.setAnimationListener(r5);
    L5:
        this.mCircleView.clearAnimation();
        this.mCircleView.startAnimation(this.mScaleAnimation);
    }

    void setAnimationProgress(float r2) {
        this.mCircleView.setScaleX(r2);
        this.mCircleView.setScaleY(r2);
    }

    private void setRefreshing(boolean r2, boolean r3) {
        if (this.mRefreshing == r2) goto L9;
        this.mNotify = r3;
        ensureTarget();
        this.mRefreshing = r2;
        if (r2 == false) goto L7;
        animateOffsetToCorrectPosition(this.mCurrentTargetOffsetTop, this.mRefreshListener);
        return;
    L7:
        startScaleDownAnimation(this.mRefreshListener);
        return;
    }

    void startScaleDownAnimation(Animation.AnimationListener r4) {
        Animation.AnimationListener r5 = (Animation.AnimationListener) ZeusTransformUtils.wrapperContextForParams(r4, Animation.AnimationListener.class, "com.obric.aiagent.plugin");
        Animation r0 = new AnonymousClass3(this);
        this.mScaleDownAnimation = r0;
        r0.setDuration(150);
        this.mCircleView.setAnimationListener(r5);
        this.mCircleView.clearAnimation();
        this.mCircleView.startAnimation(this.mScaleDownAnimation);
    }

    private void startProgressAlphaStartAnimation() {
        this.mAlphaStartAnimation = startAlphaAnimation(this.mProgress.getAlpha(), 76);
    }

    private void startProgressAlphaMaxAnimation() {
        this.mAlphaMaxAnimation = startAlphaAnimation(this.mProgress.getAlpha(), MAX_ALPHA);
    }

    private Animation startAlphaAnimation(final int r2, final int r3) {
        Animation r0 = new AnonymousClass4(this, r2, r3);
        r0.setDuration(300);
        this.mCircleView.setAnimationListener(null);
        this.mCircleView.clearAnimation();
        this.mCircleView.startAnimation(r0);
        return r0;
    }

    @Deprecated
    public void setProgressBackgroundColor(int r1) {
        setProgressBackgroundColorSchemeResource(r1);
    }

    public void setProgressBackgroundColorSchemeResource(int r4) {
        setProgressBackgroundColorSchemeColor(androidx.core.content.a.c((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r4));
    }

    public void setProgressBackgroundColorSchemeColor(int r1) {
        this.mCircleView.setBackgroundColor(r1);
    }

    @Deprecated
    public void setColorScheme(int... r1) {
        setColorSchemeResources(r1);
    }

    public void setColorSchemeResources(int... r5) {
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        int[] r1 = new int[r5.length];
        int r2 = 0;
    L4:
        if (r2 >= r5.length) goto L6;
        r1[r2] = androidx.core.content.a.c(r0, r5[r2]);
        r2 = r2 + 1;
        goto L4
    L6:
        setColorSchemeColors(r1);
    }

    public void setColorSchemeColors(int... r1) {
        ensureTarget();
        this.mProgress.setColorSchemeColors(r1);
    }

    public boolean isRefreshing() {
        return this.mRefreshing;
    }

    private void ensureTarget() {
        if (this.mTarget != null) goto L11;
        int r0 = 0;
    L6:
        if (r0 >= getChildCount()) goto L15;
        View r1 = getChildAt(r0);
        if (r1.equals(this.mCircleView) == false) goto L9;
        r0 = r0 + 1;
        goto L6
    L9:
        this.mTarget = r1;
        return;
    L15:
        return;
    }

    public void setDistanceToTriggerSync(int r1) {
        this.mTotalDragDistance = r1;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean r3, int r4, int r5, int r6, int r7) {
        int r8 = getMeasuredWidth();
        int r9 = getMeasuredHeight();
        if (getChildCount() != 0) goto L6;
        return;
    L6:
        if (this.mTarget != null) goto L8;
        ensureTarget();
    L8:
        View r10 = this.mTarget;
        if (r10 != null) goto L11;
        return;
    L11:
        int r11 = getPaddingLeft();
        int r12 = getPaddingTop();
        int r0 = (r8 - getPaddingLeft()) - getPaddingRight();
        r10.layout(r11, r12, r0 + r11, ((r9 - getPaddingTop()) - getPaddingBottom()) + r12);
        int r13 = this.mCircleView.getMeasuredWidth();
        int r14 = this.mCircleView.getMeasuredHeight();
        int r15 = r8 / 2;
        int r16 = r13 / 2;
        int r2 = this.mCurrentTargetOffsetTop;
        this.mCircleView.layout(r15 - r16, r2, r15 + r16, r14 + r2);
    }

    @Override // android.view.View
    public void onMeasure(int r4, int r5) {
        super.onMeasure(r4, r5);
        if (this.mTarget != null) goto L5;
        ensureTarget();
    L5:
        View r6 = this.mTarget;
        if (r6 != null) goto L8;
        return;
    L8:
        r6.measure(View.MeasureSpec.makeMeasureSpec((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), 1073741824), View.MeasureSpec.makeMeasureSpec((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), 1073741824));
        this.mCircleView.measure(View.MeasureSpec.makeMeasureSpec(this.mCircleDiameter, 1073741824), View.MeasureSpec.makeMeasureSpec(this.mCircleDiameter, 1073741824));
        this.mCircleViewIndex = -1;
        int r7 = 0;
    L10:
        if (r7 >= getChildCount()) goto L18;
        if (getChildAt(r7) == this.mCircleView) goto L13;
        r7 = r7 + 1;
        goto L10
    L13:
        this.mCircleViewIndex = r7;
        return;
    }

    public int getProgressCircleDiameter() {
        return this.mCircleDiameter;
    }

    public boolean canChildScrollUp() {
        a r0 = this.mChildScrollUpCallback;
        if (r0 == null) goto L7;
        return r0.a(this, this.mTarget);
    L7:
        if (ZeusTransformUtils.instanceOf(this.mTarget, ListView.class) == false) goto L11;
        return e.b((ListView) ZeusTransformUtils.preCheckCast(this.mTarget, ListView.class, "com.obric.aiagent.plugin"), -1);
    L11:
        return this.mTarget.canScrollVertically(-1);
    }

    public void setOnChildScrollUpCallback(a r3) {
        this.mChildScrollUpCallback = (a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.aiagent.plugin");
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent r5) {
        ensureTarget();
        int r0 = r5.getActionMasked();
        if (this.mReturningToStart == false) goto L7;
        if (r0 != 0) goto L7;
        this.mReturningToStart = false;
    L7:
        if (isEnabled() == true) goto L9;
    L43:
        return false;
    L9:
        if (this.mReturningToStart == true) goto L43;
        if (canChildScrollUp() == true) goto L43;
        if (this.mRefreshing == true) goto L43;
        if (this.mNestedScrollInProgress == true) goto L43;
        if (r0 != 0) goto L19;
        setTargetOffsetTopAndBottom(this.mOriginalOffsetTop - this.mCircleView.getTop());
        int r1 = r5.getPointerId(0);
        this.mActivePointerId = r1;
        this.mIsBeingDragged = false;
        int r2 = r5.findPointerIndex(r1);
        if (r2 >= 0) goto L40;
        return false;
    L40:
        this.mInitialDownY = r5.getY(r2);
    L42:
        return this.mIsBeingDragged;
    L19:
        if (r0 != 1) goto L21;
    L36:
        this.mIsBeingDragged = false;
        this.mActivePointerId = -1;
        goto L42
    L21:
        if (r0 != 2) goto L23;
        int r3 = this.mActivePointerId;
        if (r3 != (-1)) goto L32;
        INVOKESTATIC_androidx_swiperefreshlayout_widget_SwipeRefreshLayout_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(LOG_TAG, "Got ACTION_MOVE event but don't have an active pointer id.");
        return false;
    L32:
        int r4 = r5.findPointerIndex(r3);
        if (r4 >= 0) goto L35;
        return false;
    L35:
        startDragging(r5.getY(r4));
        goto L42
    L23:
        if (r0 == 3) goto L36;
        if (r0 != 6) goto L42;
        onSecondaryPointerUp(r5);
        goto L42
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean r3) {
        if (Build.VERSION.SDK_INT < 21) goto L5;
    L6:
        View r0 = this.mTarget;
        if (r0 != null) goto L9;
    L11:
        super.requestDisallowInterceptTouchEvent(r3);
        return;
    L9:
        if (ViewCompat.D(r0) == true) goto L11;
        return;
    L5:
        if (ZeusTransformUtils.instanceOf(this.mTarget, AbsListView.class) == false) goto L6;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.p
    public boolean onStartNestedScroll(View r1, View r2, int r3) {
        if (isEnabled() == true) goto L5;
    L11:
        return false;
    L5:
        if (this.mReturningToStart == true) goto L11;
        if (this.mRefreshing == true) goto L11;
        if ((r3 & 2) == 0) goto L11;
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.p
    public void onNestedScrollAccepted(View r2, View r3, int r4) {
        this.mNestedScrollingParentHelper.a(r2, r3, r4);
        startNestedScroll(r4 & 2);
        this.mTotalUnconsumed = 0.0f;
        this.mNestedScrollInProgress = true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.p
    public void onNestedPreScroll(View r5, int r6, int r7, int[] r8) {
        if (r7 <= 0) goto L12;
        float r1 = this.mTotalUnconsumed;
        if (r1 <= 0.0f) goto L12;
        float r2 = r7;
        if (r2 <= r1) goto L9;
        r8[1] = r7 - ((int) r1);
        this.mTotalUnconsumed = 0.0f;
    L10:
        moveSpinner(this.mTotalUnconsumed);
        goto L12
    L9:
        this.mTotalUnconsumed = r1 - r2;
        r8[1] = r7;
    L12:
        if (this.mUsingCustomStart == false) goto L19;
        if (r7 <= 0) goto L19;
        if (this.mTotalUnconsumed != 0.0f) goto L19;
        if (Math.abs(r7 - r8[1]) <= 0) goto L19;
        this.mCircleView.setVisibility(8);
    L19:
        int[] r9 = this.mParentScrollConsumed;
        if (dispatchNestedPreScroll(r6 - r8[0], r7 - r8[1], r9, null) == false) goto L23;
        r8[0] = r8[0] + r9[0];
        r8[1] = r8[1] + r9[1];
        return;
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        return this.mNestedScrollingParentHelper.a();
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.p
    public void onStopNestedScroll(View r3) {
        this.mNestedScrollingParentHelper.a(r3);
        this.mNestedScrollInProgress = false;
        float r4 = this.mTotalUnconsumed;
        if (r4 <= 0.0f) goto L5;
        finishSpinner(r4);
        this.mTotalUnconsumed = 0.0f;
    L5:
        stopNestedScroll();
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.p
    public void onNestedScroll(View r7, int r8, int r9, int r10, int r11) {
        dispatchNestedScroll(r8, r9, r10, r11, this.mParentOffsetInWindow);
        int r12 = r11 + this.mParentOffsetInWindow[1];
        if (r12 < 0) goto L5;
        return;
    L5:
        if (canChildScrollUp() == true) goto L9;
        float r13 = this.mTotalUnconsumed + Math.abs(r12);
        this.mTotalUnconsumed = r13;
        moveSpinner(r13);
        return;
    }

    @Override // android.view.View
    public void setNestedScrollingEnabled(boolean r1) {
        this.mNestedScrollingChildHelper.a(r1);
    }

    @Override // android.view.View, androidx.core.view.l
    public boolean isNestedScrollingEnabled() {
        return this.mNestedScrollingChildHelper.a();
    }

    @Override // android.view.View
    public boolean startNestedScroll(int r1) {
        return this.mNestedScrollingChildHelper.b(r1);
    }

    @Override // android.view.View, androidx.core.view.l
    public void stopNestedScroll() {
        this.mNestedScrollingChildHelper.c();
    }

    @Override // android.view.View
    public boolean hasNestedScrollingParent() {
        return this.mNestedScrollingChildHelper.b();
    }

    @Override // android.view.View
    public boolean dispatchNestedScroll(int r7, int r8, int r9, int r10, int[] r11) {
        return this.mNestedScrollingChildHelper.a(r7, r8, r9, r10, r11);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreScroll(int r1, int r2, int[] r3, int[] r4) {
        return this.mNestedScrollingChildHelper.a(r1, r2, r3, r4);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.p
    public boolean onNestedPreFling(View r1, float r2, float r3) {
        return dispatchNestedPreFling(r2, r3);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.p
    public boolean onNestedFling(View r1, float r2, float r3, boolean r4) {
        return dispatchNestedFling(r2, r3, r4);
    }

    @Override // android.view.View
    public boolean dispatchNestedFling(float r1, float r2, boolean r3) {
        return this.mNestedScrollingChildHelper.a(r1, r2, r3);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreFling(float r1, float r2) {
        return this.mNestedScrollingChildHelper.a(r1, r2);
    }

    private boolean isAnimationRunning(Animation r1) {
        if (r1 != null) goto L4;
    L8:
        return false;
    L4:
        if (r1.hasStarted() == false) goto L8;
        if (r1.hasEnded() == true) goto L8;
        return true;
    }

    private void moveSpinner(float r12) {
        this.mProgress.setArrowEnabled(true);
        float r0 = Math.min(1.0f, Math.abs(r12 / this.mTotalDragDistance));
        float r2 = (((float) Math.max(((double) r0) - 0.4d, 0.0d)) * 5.0f) / 3.0f;
        float r3 = Math.abs(r12) - this.mTotalDragDistance;
        int r4 = this.mCustomSlingshotDistance;
        if (r4 <= 0) goto L6;
    L4:
        float r5 = r4;
        double r7 = Math.max(0.0f, Math.min(r3, r5 * DECELERATE_INTERPOLATION_FACTOR) / r5) / 4.0f;
        float r6 = ((float) (r7 - Math.pow(r7, 2.0d))) * DECELERATE_INTERPOLATION_FACTOR;
        int r8 = this.mOriginalOffsetTop + ((int) ((r5 * r0) + ((r5 * r6) * DECELERATE_INTERPOLATION_FACTOR)));
        if (this.mCircleView.getVisibility() == 0) goto L13;
        this.mCircleView.setVisibility(0);
    L13:
        if (this.mScale == true) goto L16;
        this.mCircleView.setScaleX(1.0f);
        this.mCircleView.setScaleY(1.0f);
    L16:
        if (this.mScale == false) goto L19;
        setAnimationProgress(Math.min(1.0f, r12 / this.mTotalDragDistance));
    L19:
        if (r12 >= this.mTotalDragDistance) goto L26;
        if (this.mProgress.getAlpha() > 76) goto L23;
    L30:
        this.mProgress.setStartEndTrim(0.0f, Math.min(MAX_PROGRESS_ANGLE, r2 * MAX_PROGRESS_ANGLE));
        this.mProgress.setArrowScale(Math.min(1.0f, r2));
        this.mProgress.setProgressRotation((((r2 * 0.4f) - 0.25f) + (r6 * DECELERATE_INTERPOLATION_FACTOR)) * DRAG_RATE);
        setTargetOffsetTopAndBottom(r8 - this.mCurrentTargetOffsetTop);
        return;
    L23:
        if (isAnimationRunning(this.mAlphaStartAnimation) == true) goto L30;
        startProgressAlphaStartAnimation();
        goto L30
    L26:
        if (this.mProgress.getAlpha() >= MAX_ALPHA) goto L30;
        if (isAnimationRunning(this.mAlphaMaxAnimation) == true) goto L30;
        startProgressAlphaMaxAnimation();
        goto L30
    L6:
        if (this.mUsingCustomStart == false) goto L8;
        r4 = this.mSpinnerOffsetEnd - this.mOriginalOffsetTop;
        goto L4
    L8:
        r4 = this.mSpinnerOffsetEnd;
        goto L4
    }

    private void finishSpinner(float r3) {
        if (r3 <= this.mTotalDragDistance) goto L5;
        setRefreshing(true, true);
        return;
    L5:
        this.mRefreshing = false;
        this.mProgress.setStartEndTrim(0.0f, 0.0f);
        Animation.AnimationListener r0 = null;
        if (this.mScale == true) goto L8;
        r0 = new AnonymousClass5(this);
    L8:
        animateOffsetToStartPosition(this.mCurrentTargetOffsetTop, r0);
        this.mProgress.setArrowEnabled(false);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent r6) {
        int r0 = r6.getActionMasked();
        if (this.mReturningToStart == false) goto L7;
        if (r0 != 0) goto L7;
        this.mReturningToStart = false;
    L7:
        if (isEnabled() == true) goto L9;
    L58:
        return false;
    L9:
        if (this.mReturningToStart == true) goto L58;
        if (canChildScrollUp() == true) goto L58;
        if (this.mRefreshing == true) goto L58;
        if (this.mNestedScrollInProgress == true) goto L58;
        if (r0 != 0) goto L20;
        this.mActivePointerId = r6.getPointerId(0);
        this.mIsBeingDragged = false;
    L57:
        return true;
    L20:
        if (r0 != 1) goto L22;
        int r1 = r6.findPointerIndex(this.mActivePointerId);
        if (r1 >= 0) goto L52;
        INVOKESTATIC_androidx_swiperefreshlayout_widget_SwipeRefreshLayout_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(LOG_TAG, "Got ACTION_UP event but don't have an active pointer id.");
        return false;
    L52:
        if (this.mIsBeingDragged == false) goto L54;
        float r7 = (r6.getY(r1) - this.mInitialMotionY) * DRAG_RATE;
        this.mIsBeingDragged = false;
        finishSpinner(r7);
    L54:
        this.mActivePointerId = -1;
        return false;
    L22:
        if (r0 != 2) goto L24;
        int r2 = r6.findPointerIndex(this.mActivePointerId);
        if (r2 >= 0) goto L41;
        INVOKESTATIC_androidx_swiperefreshlayout_widget_SwipeRefreshLayout_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(LOG_TAG, "Got ACTION_MOVE event but have an invalid active pointer id.");
        return false;
    L41:
        float r8 = r6.getY(r2);
        startDragging(r8);
        if (this.mIsBeingDragged == false) goto L57;
        float r9 = (r8 - this.mInitialMotionY) * DRAG_RATE;
        if (r9 <= 0.0f) goto L46;
        moveSpinner(r9);
        goto L57
    L46:
        return false;
    L24:
        if (r0 != 3) goto L26;
        return false;
    L26:
        if (r0 != 5) goto L28;
        int r3 = r6.getActionIndex();
        if (r3 >= 0) goto L35;
        INVOKESTATIC_androidx_swiperefreshlayout_widget_SwipeRefreshLayout_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(LOG_TAG, "Got ACTION_POINTER_DOWN event but have an invalid action index.");
        return false;
    L35:
        this.mActivePointerId = r6.getPointerId(r3);
        goto L57
    L28:
        if (r0 != 6) goto L57;
        onSecondaryPointerUp(r6);
        goto L57
    }

    private void startDragging(float r4) {
        float r0 = this.mInitialDownY;
        float r5 = r4 - r0;
        int r1 = this.mTouchSlop;
        if (r5 > r1) goto L5;
        return;
    L5:
        if (this.mIsBeingDragged == true) goto L9;
        this.mInitialMotionY = r0 + r1;
        this.mIsBeingDragged = true;
        this.mProgress.setAlpha(76);
        return;
    }

    private void animateOffsetToCorrectPosition(int r3, Animation.AnimationListener r4) {
        Animation.AnimationListener r5 = (Animation.AnimationListener) ZeusTransformUtils.wrapperContextForParams(r4, Animation.AnimationListener.class, "com.obric.aiagent.plugin");
        this.mFrom = r3;
        this.mAnimateToCorrectPosition.reset();
        this.mAnimateToCorrectPosition.setDuration(200);
        this.mAnimateToCorrectPosition.setInterpolator(this.mDecelerateInterpolator);
        if (r5 == null) goto L5;
        this.mCircleView.setAnimationListener(r5);
    L5:
        this.mCircleView.clearAnimation();
        this.mCircleView.startAnimation(this.mAnimateToCorrectPosition);
    }

    private void animateOffsetToStartPosition(int r3, Animation.AnimationListener r4) {
        Animation.AnimationListener r5 = (Animation.AnimationListener) ZeusTransformUtils.wrapperContextForParams(r4, Animation.AnimationListener.class, "com.obric.aiagent.plugin");
        if (this.mScale == false) goto L5;
        startScaleDownReturnToStartAnimation(r3, r5);
        return;
    L5:
        this.mFrom = r3;
        this.mAnimateToStartPosition.reset();
        this.mAnimateToStartPosition.setDuration(200);
        this.mAnimateToStartPosition.setInterpolator(this.mDecelerateInterpolator);
        if (r5 == null) goto L8;
        this.mCircleView.setAnimationListener(r5);
    L8:
        this.mCircleView.clearAnimation();
        this.mCircleView.startAnimation(this.mAnimateToStartPosition);
    }

    void moveToStart(float r3) {
        int r0 = this.mFrom;
        setTargetOffsetTopAndBottom((r0 + ((int) ((this.mOriginalOffsetTop - r0) * r3))) - this.mCircleView.getTop());
    }

    private void startScaleDownReturnToStartAnimation(int r3, Animation.AnimationListener r4) {
        Animation.AnimationListener r5 = (Animation.AnimationListener) ZeusTransformUtils.wrapperContextForParams(r4, Animation.AnimationListener.class, "com.obric.aiagent.plugin");
        this.mFrom = r3;
        this.mStartingScale = this.mCircleView.getScaleX();
        Animation r6 = new AnonymousClass8(this);
        this.mScaleDownToStartAnimation = r6;
        r6.setDuration(150);
        if (r5 == null) goto L5;
        this.mCircleView.setAnimationListener(r5);
    L5:
        this.mCircleView.clearAnimation();
        this.mCircleView.startAnimation(this.mScaleDownToStartAnimation);
    }

    void setTargetOffsetTopAndBottom(int r2) {
        this.mCircleView.bringToFront();
        ViewCompat.f(this.mCircleView, r2);
        this.mCurrentTargetOffsetTop = this.mCircleView.getTop();
    }

    private void onSecondaryPointerUp(MotionEvent r4) {
        int r0 = r4.getActionIndex();
        if (r4.getPointerId(r0) != this.mActivePointerId) goto L9;
        if (r0 != 0) goto L6;
        int r1 = 1;
    L7:
        this.mActivePointerId = r4.getPointerId(r1);
        return;
    L6:
        r1 = 0;
        goto L7
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_androidx_swiperefreshlayout_widget_SwipeRefreshLayout_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(String r0, String r1) {
        return Log.e(r0, r1);
    }
}
