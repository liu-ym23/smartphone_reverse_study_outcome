package com.android.ttcjpaysdk.base.ui;

import android.R;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import com.android.ttcjpaysdk.base.ktextension.CJPayColorHelper;
import com.larus.home.impl.utils.c;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;

/* JADX INFO: loaded from: classes28.dex */
public class SwipeToFinishView {
    private boolean isSwipeToFinish;
    private boolean isSwipeToStart;
    private MySwipeView mySwipeView;

    public class MySwipeView extends FrameLayout {
        private Activity activity;
        private View contentView;
        private ViewGroup decorView;
        private int horizontalDragRange;
        private float intercept_X;
        private float intercept_Y;
        private boolean mDrawShadow;
        private VelocityTracker mVelocityTracker;
        private boolean swipeEnabled;
        final /* synthetic */ SwipeToFinishView this$0;
        private int touchSlop;

        private void collapse() {
            this.contentView.clearAnimation();
            View r100 = this.contentView;
            ObjectAnimator r101 = ObjectAnimator.ofFloat(r100, View.TRANSLATION_X, new float[]{r100.getMeasuredWidth()});
            r101.addListener(new AnonymousClass1(this));
            r101.start();
        }

        private void initCoverView() {
            ViewGroup r100 = (ViewGroup) INVOKEVIRTUAL_com_android_ttcjpaysdk_base_ui_SwipeToFinishView$MySwipeView_com_larus_home_impl_utils_DecorViewLancet_getDecorView(this.activity.getWindow());
            this.decorView = r100;
            ViewGroup r101 = (ViewGroup) r100.findViewById(R.id.content);
            this.contentView = r101;
            if (r101 == null) goto L6;
            ViewGroup r102 = (ViewGroup) r101.getParent();
            r102.removeView(this.contentView);
            addView(this.contentView);
            this.contentView.setBackgroundColor(-1);
            r102.addView(this);
            return;
        }

        private void open() {
            this.contentView.clearAnimation();
            ObjectAnimator.ofFloat(this.contentView, View.TRANSLATION_X, new float[]{0.0f}).start();
        }

        private void releaseVelocityTracker() {
            VelocityTracker r100 = this.mVelocityTracker;
            if (r100 == null) goto L6;
            r100.clear();
            this.mVelocityTracker.recycle();
            this.mVelocityTracker = null;
            return;
        }

        public static View INVOKEVIRTUAL_com_android_ttcjpaysdk_base_ui_SwipeToFinishView$MySwipeView_com_larus_home_impl_utils_DecorViewLancet_getDecorView(Window r100) {
            View r101 = r100.getDecorView();
            if (c.f346345e == false) goto L7;
            FLogger.f375446a.i("DecorViewLancet", "getDecorView");
            Thread r102 = ThreadMethodProxy.currentThread();
            if (r102 == c.f346341a) goto L7;
            c.a(r102, "getDecorView");
        L7:
            return r101;
        }

        public static /* synthetic */ View access$000(MySwipeView r100) {
            return r100.contentView;
        }

        public static /* synthetic */ Activity access$300(MySwipeView r100) {
            return r100.activity;
        }

        private int getAlphaBlack(float r100) {
            return Color.argb((int) (((double) (r100 * 255.0f)) * 0.3d), 0, 0, 0);
        }

        private void hideSystemKeyboard(Context r100) {
            if ((r100 instanceof Activity) == true) goto L5;
            return;
        L5:
            Activity r101 = (Activity) r100;
            InputMethodManager r102 = (InputMethodManager) r100.getSystemService("input_method");
            if (r102 == null) goto L11;
            View r103 = r101.getCurrentFocus();
            if (r103 == null) goto L12;
            r102.hideSoftInputFromWindow(r103.getWindowToken(), 2);
            return;
        L12:
            return;
        }

        private void processTouchEvent(MotionEvent r100) {
            if (this.mVelocityTracker != null) goto L5;
            this.mVelocityTracker = VelocityTracker.obtain();
        L5:
            this.mVelocityTracker.addMovement(r100);
            int r101 = r100.getAction();
            if (r101 == 1) goto L18;
            if (r101 != 2) goto L28;
            this.mVelocityTracker.computeCurrentVelocity(1000);
            float r102 = r100.getX() - this.intercept_X;
            if (r102 > 0.0f) goto L13;
            return;
        L13:
            if (this.mDrawShadow == false) goto L15;
            setBackgroundColor(getAlphaBlack(1.0f - (r102 / this.horizontalDragRange)));
        L16:
            this.contentView.setTranslationX(r102);
            hideSystemKeyboard(getContext());
            return;
        L15:
            setBackgroundColor(0);
            goto L16
        L28:
            return;
        L18:
            if (this.contentView.getTranslationX() < (this.contentView.getMeasuredWidth() / 3)) goto L20;
        L23:
            collapse();
            releaseVelocityTracker();
            return;
        L20:
            if (this.mVelocityTracker.getXVelocity() > 4000.0f) goto L23;
            open();
        }

        private boolean shouldInterceptEvent(MotionEvent r100) {
            if (this.swipeEnabled == true) goto L5;
            return false;
        L5:
            int r101 = r100.getAction();
            if (r101 != 0) goto L8;
            this.intercept_X = r100.getX();
            this.intercept_Y = r100.getY();
            return false;
        L8:
            if (r101 != 1) goto L10;
            return false;
        L10:
            if (r101 != 2) goto L26;
            float r102 = Math.abs(r100.getY() - this.intercept_Y);
            float r103 = Math.abs(r100.getX() - this.intercept_X);
            if (r102 < (this.touchSlop * 3)) goto L15;
            return false;
        L15:
            if (r102 <= r103) goto L18;
            return false;
        L18:
            if ((r100.getX() - this.intercept_X) < (this.touchSlop * 3)) goto L24;
            return true;
        L24:
            return false;
        L26:
            return false;
        }

        @Override // android.view.ViewGroup
        public boolean onInterceptTouchEvent(MotionEvent r100) {
            return shouldInterceptEvent(r100);
        }

        @Override // android.view.View
        public boolean onTouchEvent(MotionEvent r100) {
            if (this.swipeEnabled == false) goto L6;
            processTouchEvent(r100);
            return true;
        L6:
            return false;
        }

        public void setActivity(Activity r100) {
            this.activity = r100;
            initCoverView();
        }

        public MySwipeView(SwipeToFinishView r100, Context r101) {
            this(r100, r101, null);
        }

        public static /* synthetic */ boolean access$102(MySwipeView r100, boolean r101) {
            r100.swipeEnabled = r101;
            return r101;
        }

        public MySwipeView(SwipeToFinishView r100, Context r101, AttributeSet r102) {
            this(r100, r101, r102, 0);
        }

        public MySwipeView(SwipeToFinishView r100, Context r101, AttributeSet r102, int r103) {
            this.this$0 = r100;
            super(r101, r102, r103);
            this.intercept_X = 0.0f;
            this.intercept_Y = 0.0f;
            this.touchSlop = 0;
            this.swipeEnabled = true;
            this.mDrawShadow = true;
            this.touchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
            setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        }

        @Override // android.view.View
        public void onSizeChanged(int r100, int r101, int r102, int r103) {
            super.onSizeChanged(r100, r101, r102, r103);
            this.horizontalDragRange = r100;
        }
    }

    public static /* synthetic */ void a(SwipeToFinishView r100, int r101) {
        r100.lambda$setBackgroundColor$0(r101);
    }

    public boolean isSwipeToFinish() {
        return this.isSwipeToFinish;
    }

    public SwipeToFinishView(Activity r100) {
        MySwipeView r101 = new MySwipeView(this, r100);
        this.mySwipeView = r101;
        r101.setActivity(r100);
    }

    private /* synthetic */ void lambda$setBackgroundColor$0(int r100) {
        MySwipeView.access$000(this.mySwipeView).setBackgroundColor(r100);
    }

    public void setBackgroundColor(String r100) {
        if (MySwipeView.access$000(this.mySwipeView) == null) goto L6;
        CJPayColorHelper.safeParseColor(r100, new a(this), null);
        return;
    }

    public void setEnableSwipe(boolean r100) {
        if (MySwipeView.access$000(this.mySwipeView) == null) goto L6;
        MySwipeView.access$102(this.mySwipeView, r100);
        return;
    }

    public static /* synthetic */ boolean access$202(SwipeToFinishView r100, boolean r101) {
        r100.isSwipeToFinish = r101;
        return r101;
    }
}
