package com.android.contacts.quickcontact;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import com.android.contacts.R;
import com.android.contacts.util.SchedulingUtils;

/* JADX INFO: loaded from: classes2.dex */
public class FloatingChildLayout extends FrameLayout {
    private static final int DIM_BACKGROUND_ALPHA = 127;
    private static final String TAG = "FloatingChildLayout";
    private final int mAnimationDuration;
    private ObjectAnimator mBackgroundAnimator;
    private int mBackgroundPhase;
    private View mChild;
    private int mFixedTopPosition;
    private int mForegroundPhase;
    private View.OnTouchListener mOutsideTouchListener;
    private Rect mTargetScreen;

    private interface BackgroundPhase {
        public static final int APPEARING_OR_VISIBLE = 1;
        public static final int BEFORE = 0;
        public static final int DISAPPEARING_OR_GONE = 3;
    }

    private interface ForegroundPhase {
        public static final int AFTER = 4;
        public static final int APPEARING = 1;
        public static final int BEFORE = 0;
        public static final int DISAPPEARING = 3;
        public static final int IDLE = 2;
    }

    static /* synthetic */ int access$000(FloatingChildLayout r0) {
        return r0.mAnimationDuration;
    }

    static /* synthetic */ ObjectAnimator access$100(FloatingChildLayout r0) {
        return r0.mBackgroundAnimator;
    }

    static /* synthetic */ View access$200(FloatingChildLayout r0) {
        return r0.mChild;
    }

    static /* synthetic */ int access$300(FloatingChildLayout r0) {
        return r0.mForegroundPhase;
    }

    static /* synthetic */ int access$302(FloatingChildLayout r0, int r1) {
        r0.mForegroundPhase = r1;
        return r1;
    }

    public FloatingChildLayout(Context r2, AttributeSet r3) {
        super(r2, r3);
        this.mTargetScreen = new Rect();
        this.mBackgroundPhase = 0;
        this.mBackgroundAnimator = ObjectAnimator.ofInt(this, "backgroundColorAlpha", new int[]{0, 127});
        this.mForegroundPhase = 0;
        Resources r4 = getResources();
        this.mFixedTopPosition = r4.getDimensionPixelOffset(R.dimen.quick_contact_top_position);
        this.mAnimationDuration = r4.getInteger(android.R.integer.config_shortAnimTime);
        super.setBackground(new ColorDrawable(0));
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        View r0 = findViewById(android.R.id.content);
        this.mChild = r0;
        r0.setDuplicateParentStateEnabled(true);
        this.mChild.setScaleX(0.5f);
        this.mChild.setScaleY(0.5f);
        this.mChild.setAlpha(0.0f);
    }

    public View getChild() {
        return this.mChild;
    }

    @Override // android.view.View
    public void setBackground(Drawable r1) {
        Log.wtf(TAG, "don't setBackground(), it is managed internally");
    }

    public void setChildTargetScreen(Rect r1) {
        this.mTargetScreen = r1;
        requestLayout();
    }

    private Rect getTargetInWindow() {
        Rect r0 = new Rect();
        getWindowVisibleDisplayFrame(r0);
        Rect r1 = new Rect(this.mTargetScreen);
        r1.offset(-r0.left, -r0.top);
        return r1;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean r3, int r4, int r5, int r6, int r7) {
        View r8 = this.mChild;
        Rect r9 = getTargetInWindow();
        int r10 = r8.getMeasuredWidth();
        int r11 = r8.getMeasuredHeight();
        if (this.mFixedTopPosition == (-1)) goto L5;
        layoutChild(r8, (getWidth() - r10) / 2, this.mFixedTopPosition);
        return;
    L5:
        layoutChild(r8, clampDimension(r9.centerX() - (r10 / 2), r10, getWidth()), clampDimension(r9.centerY() - Math.round(r11 * 0.35f), r11, getHeight()));
    }

    private static int clampDimension(int r1, int r2, int r3) {
        if (r2 <= r3) goto L6;
        return (r3 - r2) / 2;
    L6:
        return Math.min(Math.max(r1, 0), r3 - r2);
    }

    private static void layoutChild(View r2, int r3, int r4) {
        r2.layout(r3, r4, r2.getMeasuredWidth() + r3, r2.getMeasuredHeight() + r4);
    }

    public void fadeInBackground() {
        if (this.mBackgroundPhase != 0) goto L6;
        this.mBackgroundPhase = 1;
        createChildLayer();
        SchedulingUtils.doAfterDraw(this, new AnonymousClass1(this));
        return;
    }

    public void fadeOutBackground() {
        if (this.mBackgroundPhase != 1) goto L9;
        this.mBackgroundPhase = 3;
        if (this.mBackgroundAnimator.isRunning() == false) goto L7;
        this.mBackgroundAnimator.reverse();
        return;
    L7:
        ObjectAnimator.ofInt(this, "backgroundColorAlpha", new int[]{127, 0}).setDuration(this.mAnimationDuration).start();
        return;
    }

    public boolean isContentFullyVisible() {
        if (this.mForegroundPhase != 2) goto L5;
        return true;
    L5:
        return false;
    }

    public void showContent(Runnable r2) {
        if (this.mForegroundPhase != 0) goto L6;
        this.mForegroundPhase = 1;
        animateScale(false, r2);
        return;
    }

    public boolean hideContent(Runnable r4) {
        int r0 = this.mForegroundPhase;
        if (r0 != 1) goto L5;
    L9:
        this.mForegroundPhase = 3;
        createChildLayer();
        animateScale(true, r4);
        return true;
    L5:
        if (r0 == 2) goto L9;
        return false;
    }

    private void createChildLayer() {
        this.mChild.invalidate();
        this.mChild.setLayerType(2, null);
        this.mChild.buildLayer();
    }

    private void animateScale(final boolean r7, final Runnable r8) {
        this.mChild.setPivotX(this.mTargetScreen.centerX() - this.mChild.getLeft());
        this.mChild.setPivotY(this.mTargetScreen.centerY() - this.mChild.getTop());
        if (r7 == false) goto L5;
        int r0 = android.R.interpolator.accelerate_quint;
    L6:
        float r1 = 1.0f;
        if (r7 == false) goto L9;
        float r2 = 0.5f;
    L10:
        ViewPropertyAnimator r3 = this.mChild.animate().setDuration(this.mAnimationDuration).setInterpolator(AnimationUtils.loadInterpolator(getContext(), r0)).scaleX(r2).scaleY(r2);
        if (r7 == false) goto L13;
        r1 = 0.0f;
    L13:
        r3.alpha(r1).setListener(new AnonymousClass2(this, r7, r8));
        return;
    L9:
        r2 = 1.0f;
        goto L10
    L5:
        r0 = android.R.interpolator.decelerate_quint;
        goto L6
    }

    public void setOnOutsideTouchListener(View.OnTouchListener r1) {
        this.mOutsideTouchListener = r1;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent r2) {
        View.OnTouchListener r0 = this.mOutsideTouchListener;
        if (r0 != null) goto L5;
        return false;
    L5:
        return r0.onTouch(this, r2);
    }
}
