package com.amap.api.maps;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;

/* JADX INFO: loaded from: classes28.dex */
public class SwipeDismissTouchListener implements View.OnTouchListener {
    public static final int A_HALF = 2;
    public static final int MIN_VIEW_WIDTH = 2;
    public static final int ONE_THIRD = 3;
    private long mAnimationTime;
    private DismissCallbacks mCallbacks;
    private boolean mCanFinish;
    private float mDownX;
    private float mDownY;
    private int mMaxFlingVelocity;
    private int mMinFlingVelocity;
    private boolean mO;
    private int mSlop;
    private boolean mSwiping;
    private int mSwipingSlop;
    private Object mToken;
    private float mTranslationX;
    private VelocityTracker mVelocityTracker;
    private View mView;
    private int mViewWidth;

    public interface DismissCallbacks {
        boolean canDismiss(Object r100);

        void onDismiss(View r100, Object r101);

        void onNotifySwipe();
    }

    public class a extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ SwipeDismissTouchListener f28625a;

        public a(SwipeDismissTouchListener r100) {
            this.f28625a = r100;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator r100) {
            SwipeDismissTouchListener.a(this.f28625a);
        }
    }

    public static void a(SwipeDismissTouchListener r100) {
        r100.mCallbacks.onDismiss(r100.mView, r100.mToken);
        ViewGroup.LayoutParams r101 = r100.mView.getLayoutParams();
        int r102 = r100.mView.getHeight();
        ValueAnimator r103 = ValueAnimator.ofInt(new int[]{r102, 1}).setDuration(r100.mAnimationTime);
        r103.addListener(new e(r100, r101, r102));
        r103.addUpdateListener(new f(r100, r101));
        r103.start();
    }

    public static /* synthetic */ View b(SwipeDismissTouchListener r100) {
        return r100.mView;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View r110, MotionEvent r111) {
        r111.offsetLocation(this.mTranslationX, 0.0f);
        if (this.mViewWidth >= 2) goto L5;
        this.mViewWidth = this.mView.getWidth();
    L5:
        int r112 = r111.getActionMasked();
        boolean r100 = true;
        if (r112 != 0) goto L8;
        this.mDownX = r111.getRawX();
        this.mDownY = r111.getRawY();
        if (this.mCallbacks.canDismiss(this.mToken) == false) goto L90;
        this.mO = false;
        VelocityTracker r113 = VelocityTracker.obtain();
        this.mVelocityTracker = r113;
        r113.addMovement(r111);
    L90:
        return true;
    L8:
        if (r112 == 1) goto L43;
        if (r112 == 2) goto L17;
        if (r112 == 3) goto L14;
    L86:
        return false;
    L14:
        if (this.mVelocityTracker == null) goto L86;
        this.mView.animate().translationX(0.0f).alpha(1.0f).setDuration(this.mAnimationTime).setListener(null);
        this.mVelocityTracker.recycle();
        this.mVelocityTracker = null;
        this.mTranslationX = 0.0f;
        this.mDownX = 0.0f;
        this.mDownY = 0.0f;
        this.mSwiping = false;
        goto L86
    L17:
        VelocityTracker r114 = this.mVelocityTracker;
        if (r114 == null) goto L86;
        r114.addMovement(r111);
        float r115 = r111.getRawX() - this.mDownX;
        float r101 = r111.getRawY() - this.mDownY;
        if (Math.abs(r115) <= this.mSlop) goto L39;
        if (Math.abs(r101) >= (Math.abs(r115) / 2.0f)) goto L39;
        this.mSwiping = true;
        if (r115 <= 0.0f) goto L27;
        int r102 = this.mSlop;
    L28:
        this.mSwipingSlop = r102;
        this.mView.getParent().requestDisallowInterceptTouchEvent(true);
        if (this.mO == true) goto L32;
        this.mO = true;
        this.mCallbacks.onNotifySwipe();
    L32:
        if (Math.abs(r115) > (this.mViewWidth / 3)) goto L34;
        this.mCanFinish = false;
    L37:
        MotionEvent r103 = MotionEvent.obtain(r111);
        r103.setAction((r111.getActionIndex() << 8) | 3);
        this.mView.onTouchEvent(r103);
        r103.recycle();
        goto L39
    L34:
        if (this.mCanFinish == true) goto L37;
        this.mCanFinish = true;
        this.mCallbacks.onNotifySwipe();
        goto L37
    L27:
        r102 = -this.mSlop;
    L39:
        if (this.mSwiping == false) goto L86;
        this.mTranslationX = r115;
        this.mView.setTranslationX(r115 - this.mSwipingSlop);
        this.mView.setAlpha(Math.max(0.0f, Math.min(1.0f, 1.0f - ((Math.abs(r115) * 2.0f) / this.mViewWidth))));
        return true;
    L43:
        if (this.mVelocityTracker == null) goto L86;
        float r116 = r111.getRawX() - this.mDownX;
        this.mVelocityTracker.addMovement(r111);
        this.mVelocityTracker.computeCurrentVelocity(1000);
        float r117 = this.mVelocityTracker.getXVelocity();
        float r104 = Math.abs(r117);
        float r105 = Math.abs(this.mVelocityTracker.getYVelocity());
        if (Math.abs(r116) <= (this.mViewWidth / 2)) goto L53;
        if (this.mSwiping == false) goto L53;
        if (r116 > 0.0f) goto L73;
    L74:
        boolean r118 = false;
    L76:
        if (r100 == false) goto L83;
        ViewPropertyAnimator r119 = this.mView.animate();
        if (r118 == false) goto L80;
        int r120 = this.mViewWidth;
    L81:
        r119.translationX(r120).alpha(0.0f).setDuration(50).setListener(new a(this));
    L85:
        this.mVelocityTracker.recycle();
        this.mVelocityTracker = null;
        this.mTranslationX = 0.0f;
        this.mDownX = 0.0f;
        this.mDownY = 0.0f;
        this.mSwiping = false;
        goto L86
    L80:
        r120 = -this.mViewWidth;
        goto L81
    L83:
        if (this.mSwiping == false) goto L85;
        this.mView.animate().translationX(0.0f).alpha(1.0f).setDuration(this.mAnimationTime).setListener(null);
    L73:
        r118 = true;
    L53:
        if (this.mMinFlingVelocity <= r104) goto L55;
    L75:
        r118 = false;
        r100 = false;
        goto L76
    L55:
        if (r104 > this.mMaxFlingVelocity) goto L75;
        if (r105 >= r104) goto L75;
        if (this.mSwiping == false) goto L75;
        if (r117 >= 0.0f) goto L63;
        boolean r121 = true;
    L65:
        if (r116 >= 0.0f) goto L67;
        boolean r122 = true;
    L68:
        if (r121 != r122) goto L70;
        boolean r123 = true;
    L71:
        r100 = r123;
        if (this.mVelocityTracker.getXVelocity() <= 0.0f) goto L74;
    L70:
        r123 = false;
        goto L71
    L67:
        r122 = false;
        goto L68
    L63:
        r121 = false;
        goto L65
    }

    public SwipeDismissTouchListener(View r100, Object r101, DismissCallbacks r102) {
        this.mViewWidth = 1;
        ViewConfiguration r103 = ViewConfiguration.get(r100.getContext());
        this.mSlop = r103.getScaledTouchSlop();
        this.mMinFlingVelocity = r103.getScaledMinimumFlingVelocity() * 16;
        this.mMaxFlingVelocity = r103.getScaledMaximumFlingVelocity();
        this.mAnimationTime = r100.getContext().getResources().getInteger(R.integer.config_shortAnimTime);
        this.mView = r100;
        this.mToken = r101;
        this.mCallbacks = r102;
    }
}
