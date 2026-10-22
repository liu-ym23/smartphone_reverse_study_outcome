package com.google.android.material.snackbar;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityManager;
import android.widget.FrameLayout;
import androidx.annotation.IdRes;
import androidx.annotation.IntRange;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.behavior.SwipeDismissBehavior;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;
import o.a;

/* JADX INFO: loaded from: classes3.dex */
public abstract class BaseTransientBottomBar<B extends BaseTransientBottomBar<B>> {
    static final int ANIMATION_DURATION = 250;
    static final int ANIMATION_FADE_DURATION = 180;
    private static final int ANIMATION_FADE_IN_DURATION = 150;
    private static final int ANIMATION_FADE_OUT_DURATION = 75;
    public static final int ANIMATION_MODE_FADE = 1;
    public static final int ANIMATION_MODE_SLIDE = 0;
    private static final float ANIMATION_SCALE_FROM_VALUE = 0.8f;
    public static final int LENGTH_INDEFINITE = -2;
    public static final int LENGTH_LONG = 0;
    public static final int LENGTH_SHORT = -1;
    static final int MSG_DISMISS = 1;
    static final int MSG_SHOW = 0;
    private static final int[] SNACKBAR_STYLE_ATTR = null;
    private static final String TAG = null;
    private static final boolean USE_OFFSET_API = false;

    @NonNull
    static final Handler handler = null;

    @Nullable
    private final AccessibilityManager accessibilityManager;

    @Nullable
    private View anchorView;
    private final ViewTreeObserver.OnGlobalLayoutListener anchorViewLayoutListener;
    private boolean anchorViewLayoutListenerEnabled;
    private Behavior behavior;

    @RequiresApi(29)
    private final Runnable bottomMarginGestureInsetRunnable;
    private List<BaseCallback<B>> callbacks;

    @NonNull
    private final com.google.android.material.snackbar.ContentViewCallback contentViewCallback;
    private final Context context;
    private int duration;
    private int extraBottomMarginAnchorView;
    private int extraBottomMarginGestureInset;
    private int extraBottomMarginWindowInset;
    private int extraLeftMarginWindowInset;
    private int extraRightMarginWindowInset;
    private boolean gestureInsetBottomIgnored;

    @NonNull
    SnackbarManager.Callback managerCallback;

    @Nullable
    private Rect originalMargins;

    @NonNull
    private final ViewGroup targetParent;

    @NonNull
    protected final SnackbarBaseLayout view;

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface AnimationMode {
    }

    public static abstract class BaseCallback<B> {
        public static final int DISMISS_EVENT_ACTION = 1;
        public static final int DISMISS_EVENT_CONSECUTIVE = 4;
        public static final int DISMISS_EVENT_MANUAL = 3;
        public static final int DISMISS_EVENT_SWIPE = 0;
        public static final int DISMISS_EVENT_TIMEOUT = 2;

        @Retention(RetentionPolicy.SOURCE)
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public @interface DismissEvent {
        }

        public BaseCallback() {
        }

        public void onDismissed(B r10, int r11) {
        }

        public void onShown(B r10) {
        }
    }

    public static class Behavior extends SwipeDismissBehavior<View> {

        @NonNull
        private final BehaviorDelegate delegate;

        public Behavior() {
            this.delegate = new BehaviorDelegate(this);
        }

        public static /* synthetic */ void access$1300(Behavior r10, BaseTransientBottomBar r11) {
            r10.setBaseTransientBottomBar(r11);
        }

        private void setBaseTransientBottomBar(@NonNull BaseTransientBottomBar<?> r10) {
            this.delegate.setBaseTransientBottomBar(r10);
        }

        @Override // com.google.android.material.behavior.SwipeDismissBehavior
        public boolean canSwipeDismissView(View r10) {
            return this.delegate.canSwipeDismissView(r10);
        }

        @Override // com.google.android.material.behavior.SwipeDismissBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public boolean onInterceptTouchEvent(@NonNull CoordinatorLayout r10, @NonNull View r11, @NonNull MotionEvent r12) {
            this.delegate.onInterceptTouchEvent(r10, r11, r12);
            return super.onInterceptTouchEvent(r10, r11, r12);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static class BehaviorDelegate {
        private SnackbarManager.Callback managerCallback;

        public BehaviorDelegate(@NonNull SwipeDismissBehavior<?> r10) {
            r10.setStartAlphaSwipeDistance(0.1f);
            r10.setEndAlphaSwipeDistance(0.6f);
            r10.setSwipeDirection(0);
        }

        public boolean canSwipeDismissView(View r10) {
            return r10 instanceof SnackbarBaseLayout;
        }

        public void onInterceptTouchEvent(@NonNull CoordinatorLayout r10, @NonNull View r11, @NonNull MotionEvent r12) {
            int r13 = r12.getActionMasked();
            if (r13 == 0) goto L11;
            if (r13 != 1) goto L7;
        L9:
            SnackbarManager.getInstance().restoreTimeoutIfPaused(this.managerCallback);
            return;
        L7:
            if (r13 == 3) goto L9;
            return;
        L11:
            if (r10.isPointInChildBounds(r11, (int) r12.getX(), (int) r12.getY()) == false) goto L15;
            SnackbarManager.getInstance().pauseTimeout(this.managerCallback);
            return;
        }

        public void setBaseTransientBottomBar(@NonNull BaseTransientBottomBar<?> r10) {
            this.managerCallback = r10.managerCallback;
        }
    }

    @Deprecated
    public interface ContentViewCallback extends com.google.android.material.snackbar.ContentViewCallback {
    }

    @IntRange(from = 1)
    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface Duration {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public interface OnAttachStateChangeListener {
        void onViewAttachedToWindow(View r10);

        void onViewDetachedFromWindow(View r10);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public interface OnLayoutChangeListener {
        void onLayoutChange(View r10, int r11, int r12, int r13, int r14);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static class SnackbarBaseLayout extends FrameLayout {
        private static final View.OnTouchListener consumeAllTouchListener = null;
        private final float actionTextColorAlpha;
        private int animationMode;
        private final float backgroundOverlayColorAlpha;
        private ColorStateList backgroundTint;
        private PorterDuff.Mode backgroundTintMode;
        private OnAttachStateChangeListener onAttachStateChangeListener;
        private OnLayoutChangeListener onLayoutChangeListener;

        static {
            consumeAllTouchListener = new AnonymousClass1();
        }

        public SnackbarBaseLayout(@NonNull Context r10) {
            this(r10, null);
        }

        @NonNull
        private Drawable createThemedBackground() {
            float r10 = getResources().getDimension(R.dimen.mtrl_snackbar_background_corner_radius);
            GradientDrawable r11 = new GradientDrawable();
            r11.setShape(0);
            r11.setCornerRadius(r10);
            r11.setColor(MaterialColors.layer(this, R.attr.colorSurface, R.attr.colorOnSurface, getBackgroundOverlayColorAlpha()));
            if (this.backgroundTint == null) goto L7;
            Drawable r12 = a.l(r11);
            a.i(r12, this.backgroundTint);
            return r12;
        L7:
            return a.l(r11);
        }

        public float getActionTextColorAlpha() {
            return this.actionTextColorAlpha;
        }

        public int getAnimationMode() {
            return this.animationMode;
        }

        public float getBackgroundOverlayColorAlpha() {
            return this.backgroundOverlayColorAlpha;
        }

        @Override // android.view.ViewGroup, android.view.View
        public void onAttachedToWindow() {
            super.onAttachedToWindow();
            OnAttachStateChangeListener r10 = this.onAttachStateChangeListener;
            if (r10 == null) goto L5;
            r10.onViewAttachedToWindow(this);
        L5:
            ViewCompat.m0(this);
        }

        @Override // android.view.ViewGroup, android.view.View
        public void onDetachedFromWindow() {
            super.onDetachedFromWindow();
            OnAttachStateChangeListener r10 = this.onAttachStateChangeListener;
            if (r10 == null) goto L6;
            r10.onViewDetachedFromWindow(this);
            return;
        }

        @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
        public void onLayout(boolean r10, int r11, int r12, int r13, int r14) {
            super.onLayout(r10, r11, r12, r13, r14);
            OnLayoutChangeListener r15 = this.onLayoutChangeListener;
            if (r15 == null) goto L6;
            r15.onLayoutChange(this, r11, r12, r13, r14);
            return;
        }

        public void setAnimationMode(int r10) {
            this.animationMode = r10;
        }

        @Override // android.view.View
        public void setBackground(@Nullable Drawable r10) {
            setBackgroundDrawable(r10);
        }

        @Override // android.view.View
        public void setBackgroundDrawable(@Nullable Drawable r10) {
            if (r10 != null) goto L4;
        L6:
            super.setBackgroundDrawable(r10);
            return;
        L4:
            if (this.backgroundTint == null) goto L6;
            r10 = a.l(r10.mutate());
            a.i(r10, this.backgroundTint);
            a.j(r10, this.backgroundTintMode);
            goto L6
        }

        @Override // android.view.View
        public void setBackgroundTintList(@Nullable ColorStateList r10) {
            this.backgroundTint = r10;
            if (getBackground() == null) goto L8;
            Drawable r11 = a.l(getBackground().mutate());
            a.i(r11, r10);
            a.j(r11, this.backgroundTintMode);
            if (r11 == getBackground()) goto L9;
            super.setBackgroundDrawable(r11);
            return;
        L9:
            return;
        }

        @Override // android.view.View
        public void setBackgroundTintMode(@Nullable PorterDuff.Mode r10) {
            this.backgroundTintMode = r10;
            if (getBackground() == null) goto L8;
            Drawable r11 = a.l(getBackground().mutate());
            a.j(r11, r10);
            if (r11 == getBackground()) goto L9;
            super.setBackgroundDrawable(r11);
            return;
        L9:
            return;
        }

        public void setOnAttachStateChangeListener(OnAttachStateChangeListener r10) {
            this.onAttachStateChangeListener = r10;
        }

        @Override // android.view.View
        public void setOnClickListener(@Nullable View.OnClickListener r10) {
            if (r10 == null) goto L4;
            View.OnTouchListener r11 = null;
        L5:
            setOnTouchListener(r11);
            super.setOnClickListener(r10);
            return;
        L4:
            r11 = consumeAllTouchListener;
            goto L5
        }

        public void setOnLayoutChangeListener(OnLayoutChangeListener r10) {
            this.onLayoutChangeListener = r10;
        }

        public SnackbarBaseLayout(@NonNull Context r10, AttributeSet r11) {
            super(MaterialThemeOverlay.wrap(r10, r11, 0, 0), r11);
            Context r12 = getContext();
            TypedArray r13 = r12.obtainStyledAttributes(r11, R.styleable.SnackbarLayout);
            int r14 = R.styleable.SnackbarLayout_elevation;
            if (r13.hasValue(r14) == false) goto L5;
            ViewCompat.x0(this, r13.getDimensionPixelSize(r14, 0));
        L5:
            this.animationMode = r13.getInt(R.styleable.SnackbarLayout_animationMode, 0);
            this.backgroundOverlayColorAlpha = r13.getFloat(R.styleable.SnackbarLayout_backgroundOverlayColorAlpha, 1.0f);
            setBackgroundTintList(MaterialResources.getColorStateList(r12, r13, R.styleable.SnackbarLayout_backgroundTint));
            setBackgroundTintMode(ViewUtils.parseTintMode(r13.getInt(R.styleable.SnackbarLayout_backgroundTintMode, -1), PorterDuff.Mode.SRC_IN));
            this.actionTextColorAlpha = r13.getFloat(R.styleable.SnackbarLayout_actionTextColorAlpha, 1.0f);
            r13.recycle();
            setOnTouchListener(consumeAllTouchListener);
            setFocusable(true);
            if (getBackground() != null) goto L9;
            ViewCompat.t0(this, createThemedBackground());
            return;
        }
    }

    static {
        USE_OFFSET_API = false;
        SNACKBAR_STYLE_ATTR = new int[]{R.attr.snackbarStyle};
        TAG = BaseTransientBottomBar.class.getSimpleName();
        handler = new Handler(Looper.getMainLooper(), new AnonymousClass1());
    }

    public BaseTransientBottomBar(@NonNull ViewGroup r10, @NonNull View r11, @NonNull com.google.android.material.snackbar.ContentViewCallback r12) {
        this(r10.getContext(), r10, r11, r12);
    }

    public static /* synthetic */ boolean access$000(BaseTransientBottomBar r10) {
        return r10.anchorViewLayoutListenerEnabled;
    }

    public static /* synthetic */ int access$1002(BaseTransientBottomBar r10, int r11) {
        r10.extraLeftMarginWindowInset = r11;
        return r11;
    }

    public static /* synthetic */ int access$102(BaseTransientBottomBar r10, int r11) {
        r10.extraBottomMarginAnchorView = r11;
        return r11;
    }

    public static /* synthetic */ int access$1102(BaseTransientBottomBar r10, int r11) {
        r10.extraRightMarginWindowInset = r11;
        return r11;
    }

    public static /* synthetic */ void access$1200(BaseTransientBottomBar r10) {
        r10.showViewImpl();
    }

    public static /* synthetic */ void access$1400(BaseTransientBottomBar r10) {
        r10.startFadeInAnimation();
    }

    public static /* synthetic */ void access$1500(BaseTransientBottomBar r10) {
        r10.startSlideInAnimation();
    }

    public static /* synthetic */ com.google.android.material.snackbar.ContentViewCallback access$1600(BaseTransientBottomBar r10) {
        return r10.contentViewCallback;
    }

    public static /* synthetic */ boolean access$1700() {
        return USE_OFFSET_API;
    }

    public static /* synthetic */ int access$200(BaseTransientBottomBar r10) {
        return r10.calculateBottomMarginForAnchorView();
    }

    public static /* synthetic */ void access$300(BaseTransientBottomBar r10) {
        r10.updateMargins();
    }

    public static /* synthetic */ Context access$400(BaseTransientBottomBar r10) {
        return r10.context;
    }

    public static /* synthetic */ int access$500(BaseTransientBottomBar r10) {
        return r10.getScreenHeight();
    }

    public static /* synthetic */ int access$600(BaseTransientBottomBar r10) {
        return r10.getViewAbsoluteBottom();
    }

    public static /* synthetic */ int access$700(BaseTransientBottomBar r10) {
        return r10.extraBottomMarginGestureInset;
    }

    public static /* synthetic */ int access$702(BaseTransientBottomBar r10, int r11) {
        r10.extraBottomMarginGestureInset = r11;
        return r11;
    }

    public static /* synthetic */ String access$800() {
        return TAG;
    }

    public static /* synthetic */ int access$902(BaseTransientBottomBar r10, int r11) {
        r10.extraBottomMarginWindowInset = r11;
        return r11;
    }

    private void animateViewOut(int r10) {
        if (this.view.getAnimationMode() != 1) goto L5;
        startFadeOutAnimation(r10);
        return;
    L5:
        startSlideOutAnimation(r10);
    }

    private int calculateBottomMarginForAnchorView() {
        View r10 = this.anchorView;
        if (r10 != null) goto L6;
        return 0;
    L6:
        int[] r11 = new int[2];
        r10.getLocationOnScreen(r11);
        int r12 = r11[1];
        int[] r13 = new int[2];
        this.targetParent.getLocationOnScreen(r13);
        return (r13[1] + this.targetParent.getHeight()) - r12;
    }

    private ValueAnimator getAlphaAnimator(float... r10) {
        ValueAnimator r11 = ValueAnimator.ofFloat(r10);
        r11.setInterpolator(AnimationUtils.LINEAR_INTERPOLATOR);
        r11.addUpdateListener(new AnonymousClass13(this));
        return r11;
    }

    private ValueAnimator getScaleAnimator(float... r10) {
        ValueAnimator r11 = ValueAnimator.ofFloat(r10);
        r11.setInterpolator(AnimationUtils.LINEAR_OUT_SLOW_IN_INTERPOLATOR);
        r11.addUpdateListener(new AnonymousClass14(this));
        return r11;
    }

    @RequiresApi(17)
    private int getScreenHeight() {
        WindowManager r10 = (WindowManager) this.context.getSystemService("window");
        DisplayMetrics r11 = new DisplayMetrics();
        r10.getDefaultDisplay().getRealMetrics(r11);
        return r11.heightPixels;
    }

    private int getTranslationYBottom() {
        int r10 = this.view.getHeight();
        ViewGroup.LayoutParams r11 = this.view.getLayoutParams();
        if ((r11 instanceof ViewGroup.MarginLayoutParams) == true) goto L5;
        return r10;
    L5:
        return r10 + ((ViewGroup.MarginLayoutParams) r11).bottomMargin;
    }

    private int getViewAbsoluteBottom() {
        int[] r10 = new int[2];
        this.view.getLocationOnScreen(r10);
        return r10[1] + this.view.getHeight();
    }

    private boolean isSwipeDismissable() {
        ViewGroup.LayoutParams r10 = this.view.getLayoutParams();
        if ((r10 instanceof CoordinatorLayout.c) == true) goto L5;
    L7:
        return false;
    L5:
        if ((((CoordinatorLayout.c) r10).f() instanceof SwipeDismissBehavior) == false) goto L7;
        return true;
    }

    private void setUpBehavior(CoordinatorLayout.c r10) {
        SwipeDismissBehavior<? extends View> r11 = this.behavior;
        if (r11 != null) goto L6;
        r11 = getNewBehavior();
    L6:
        if ((r11 instanceof Behavior) == false) goto L8;
        Behavior.access$1300((Behavior) r11, this);
    L8:
        r11.setListener(new AnonymousClass9(this));
        r10.o(r11);
        if (this.anchorView != null) goto L12;
        r10.f2413g = 80;
        return;
    }

    private boolean shouldUpdateGestureInset() {
        if (this.extraBottomMarginGestureInset > 0) goto L5;
    L9:
        return false;
    L5:
        if (this.gestureInsetBottomIgnored == true) goto L9;
        if (isSwipeDismissable() == false) goto L9;
        return true;
    }

    private void showViewImpl() {
        if (shouldAnimate() == false) goto L6;
        animateViewIn();
        return;
    L6:
        if (this.view.getParent() == null) goto L8;
        this.view.setVisibility(0);
    L8:
        onViewShown();
    }

    private void startFadeInAnimation() {
        ValueAnimator r10 = getAlphaAnimator(new float[]{0.0f, 1.0f});
        ValueAnimator r11 = getScaleAnimator(new float[]{ANIMATION_SCALE_FROM_VALUE, 1.0f});
        AnimatorSet r12 = new AnimatorSet();
        r12.playTogether(new Animator[]{r10, r11});
        r12.setDuration(150);
        r12.addListener(new AnonymousClass11(this));
        r12.start();
    }

    private void startFadeOutAnimation(final int r10) {
        ValueAnimator r11 = getAlphaAnimator(new float[]{1.0f, 0.0f});
        r11.setDuration(75);
        r11.addListener(new AnonymousClass12(this, r10));
        r11.start();
    }

    private void startSlideInAnimation() {
        final int r10 = getTranslationYBottom();
        if (USE_OFFSET_API == false) goto L5;
        ViewCompat.a0(this.view, r10);
    L6:
        ValueAnimator r11 = new ValueAnimator();
        r11.setIntValues(new int[]{r10, 0});
        r11.setInterpolator(AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
        r11.setDuration(250);
        r11.addListener(new AnonymousClass15(this));
        r11.addUpdateListener(new AnonymousClass16(this, r10));
        r11.start();
        return;
    L5:
        this.view.setTranslationY(r10);
        goto L6
    }

    private void startSlideOutAnimation(final int r10) {
        ValueAnimator r11 = new ValueAnimator();
        r11.setIntValues(new int[]{0, getTranslationYBottom()});
        r11.setInterpolator(AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
        r11.setDuration(250);
        r11.addListener(new AnonymousClass17(this, r10));
        r11.addUpdateListener(new AnonymousClass18(this));
        r11.start();
    }

    private void updateMargins() {
        ViewGroup.LayoutParams r10 = this.view.getLayoutParams();
        if ((r10 instanceof ViewGroup.MarginLayoutParams) == false) goto L15;
        Rect r11 = this.originalMargins;
        if (r11 == null) goto L15;
        if (this.anchorView == null) goto L10;
        int r12 = this.extraBottomMarginAnchorView;
    L11:
        ViewGroup.MarginLayoutParams r13 = (ViewGroup.MarginLayoutParams) r10;
        r13.bottomMargin = r11.bottom + r12;
        r13.leftMargin = r11.left + this.extraLeftMarginWindowInset;
        r13.rightMargin = r11.right + this.extraRightMarginWindowInset;
        this.view.requestLayout();
        if (shouldUpdateGestureInset() == false) goto L17;
        this.view.removeCallbacks(this.bottomMarginGestureInsetRunnable);
        this.view.post(this.bottomMarginGestureInsetRunnable);
        return;
    L17:
        return;
    L10:
        r12 = this.extraBottomMarginWindowInset;
    L15:
        Log.w(TAG, "Unable to update margins because layout params are not MarginLayoutParams");
    }

    @NonNull
    public B addCallback(@Nullable BaseCallback<B> r10) {
        if (r10 != null) goto L5;
        return this;
    L5:
        if (this.callbacks != null) goto L7;
        this.callbacks = new ArrayList();
    L7:
        this.callbacks.add(r10);
        return this;
    }

    public void animateViewIn() {
        this.view.post(new AnonymousClass10(this));
    }

    public void dismiss() {
        dispatchDismiss(3);
    }

    public void dispatchDismiss(int r10) {
        SnackbarManager.getInstance().dismiss(this.managerCallback, r10);
    }

    @Nullable
    public View getAnchorView() {
        return this.anchorView;
    }

    public int getAnimationMode() {
        return this.view.getAnimationMode();
    }

    public Behavior getBehavior() {
        return this.behavior;
    }

    @NonNull
    public Context getContext() {
        return this.context;
    }

    public int getDuration() {
        return this.duration;
    }

    @NonNull
    public SwipeDismissBehavior<? extends View> getNewBehavior() {
        return new Behavior();
    }

    @LayoutRes
    public int getSnackbarBaseLayoutResId() {
        if (hasSnackbarStyleAttr() == false) goto L6;
        return R.layout.mtrl_layout_snackbar;
    L6:
        return R.layout.design_layout_snackbar;
    }

    @NonNull
    public View getView() {
        return this.view;
    }

    public boolean hasSnackbarStyleAttr() {
        TypedArray r10 = this.context.obtainStyledAttributes(SNACKBAR_STYLE_ATTR);
        int r11 = r10.getResourceId(0, -1);
        r10.recycle();
        if (r11 == (-1)) goto L6;
        return true;
    L6:
        return false;
    }

    public final void hideView(int r10) {
        if (shouldAnimate() == true) goto L5;
    L7:
        onViewHidden(r10);
        return;
    L5:
        if (this.view.getVisibility() != 0) goto L7;
        animateViewOut(r10);
    }

    public boolean isAnchorViewLayoutListenerEnabled() {
        return this.anchorViewLayoutListenerEnabled;
    }

    public boolean isGestureInsetBottomIgnored() {
        return this.gestureInsetBottomIgnored;
    }

    public boolean isShown() {
        return SnackbarManager.getInstance().isCurrent(this.managerCallback);
    }

    public boolean isShownOrQueued() {
        return SnackbarManager.getInstance().isCurrentOrNext(this.managerCallback);
    }

    public void onViewHidden(int r10) {
        SnackbarManager.getInstance().onDismissed(this.managerCallback);
        List<BaseCallback<B>> r11 = this.callbacks;
        if (r11 == null) goto L7;
        int r12 = r11.size() - 1;
    L5:
        if (r12 < 0) goto L7;
        this.callbacks.get(r12).onDismissed(this, r10);
        r12 = r12 - 1;
    L7:
        ViewParent r13 = this.view.getParent();
        if ((r13 instanceof ViewGroup) == false) goto L12;
        ((ViewGroup) r13).removeView(this.view);
        return;
    }

    public void onViewShown() {
        SnackbarManager.getInstance().onShown(this.managerCallback);
        List<BaseCallback<B>> r10 = this.callbacks;
        if (r10 == null) goto L7;
        int r11 = r10.size() - 1;
    L5:
        if (r11 < 0) goto L9;
        this.callbacks.get(r11).onShown(this);
        r11 = r11 - 1;
        goto L5
    L9:
        return;
    }

    @NonNull
    public B removeCallback(@Nullable BaseCallback<B> r10) {
        if (r10 != null) goto L4;
        return this;
    L4:
        List<BaseCallback<B>> r11 = this.callbacks;
        if (r11 != null) goto L7;
        return this;
    L7:
        r11.remove(r10);
        return this;
    }

    @NonNull
    public B setAnchorView(@Nullable View r10) {
        ViewUtils.removeOnGlobalLayoutListener(this.anchorView, this.anchorViewLayoutListener);
        this.anchorView = r10;
        ViewUtils.addOnGlobalLayoutListener(r10, this.anchorViewLayoutListener);
        return this;
    }

    public void setAnchorViewLayoutListenerEnabled(boolean r10) {
        this.anchorViewLayoutListenerEnabled = r10;
    }

    @NonNull
    public B setAnimationMode(int r10) {
        this.view.setAnimationMode(r10);
        return this;
    }

    @NonNull
    public B setBehavior(Behavior r10) {
        this.behavior = r10;
        return this;
    }

    @NonNull
    public B setDuration(int r10) {
        this.duration = r10;
        return this;
    }

    @NonNull
    public B setGestureInsetBottomIgnored(boolean r10) {
        this.gestureInsetBottomIgnored = r10;
        return this;
    }

    public boolean shouldAnimate() {
        AccessibilityManager r10 = this.accessibilityManager;
        if (r10 != null) goto L5;
        return true;
    L5:
        List<AccessibilityServiceInfo> r11 = r10.getEnabledAccessibilityServiceList(1);
        if (r11 != null) goto L8;
    L10:
        return false;
    L8:
        if (r11.isEmpty() == false) goto L10;
        return true;
    }

    public void show() {
        SnackbarManager.getInstance().show(getDuration(), this.managerCallback);
    }

    public final void showView() {
        this.view.setOnAttachStateChangeListener(new AnonymousClass7(this));
        if (this.view.getParent() != null) goto L9;
        ViewGroup.LayoutParams r10 = this.view.getLayoutParams();
        if ((r10 instanceof CoordinatorLayout.c) == false) goto L7;
        setUpBehavior((CoordinatorLayout.c) r10);
    L7:
        this.extraBottomMarginAnchorView = calculateBottomMarginForAnchorView();
        updateMargins();
        this.view.setVisibility(4);
        this.targetParent.addView(this.view);
    L9:
        if (ViewCompat.T(this.view) == false) goto L12;
        showViewImpl();
        return;
    L12:
        this.view.setOnLayoutChangeListener(new AnonymousClass8(this));
    }

    public BaseTransientBottomBar(@NonNull Context r10, @NonNull ViewGroup r11, @NonNull View r12, @NonNull com.google.android.material.snackbar.ContentViewCallback r13) {
        this.anchorViewLayoutListenerEnabled = false;
        this.anchorViewLayoutListener = new AnonymousClass2(this);
        this.bottomMarginGestureInsetRunnable = new AnonymousClass3(this);
        this.managerCallback = new AnonymousClass6(this);
        if (r11 == null) goto L19;
        if (r12 == null) goto L17;
        if (r13 == null) goto L15;
        this.targetParent = r11;
        this.contentViewCallback = r13;
        this.context = r10;
        ThemeEnforcement.checkAppCompatTheme(r10);
        SnackbarBaseLayout r14 = (SnackbarBaseLayout) LayoutInflater.from(r10).inflate(getSnackbarBaseLayoutResId(), r11, false);
        this.view = r14;
        if ((r12 instanceof SnackbarContentLayout) == false) goto L9;
        ((SnackbarContentLayout) r12).updateActionTextColorAlphaIfNeeded(r14.getActionTextColorAlpha());
    L9:
        r14.addView(r12);
        ViewGroup.LayoutParams r15 = r14.getLayoutParams();
        if ((r15 instanceof ViewGroup.MarginLayoutParams) == false) goto L12;
        ViewGroup.MarginLayoutParams r16 = (ViewGroup.MarginLayoutParams) r15;
        this.originalMargins = new Rect(r16.leftMargin, r16.topMargin, r16.rightMargin, r16.bottomMargin);
    L12:
        ViewCompat.r0(r14, 1);
        ViewCompat.A0(r14, 1);
        ViewCompat.y0(r14, true);
        ViewCompat.C0(r14, new AnonymousClass4(this));
        ViewCompat.p0(r14, new AnonymousClass5(this));
        this.accessibilityManager = (AccessibilityManager) r10.getSystemService("accessibility");
        return;
    L15:
        throw new IllegalArgumentException("Transient bottom bar must have non-null callback");
    L17:
        throw new IllegalArgumentException("Transient bottom bar must have non-null content");
    L19:
        throw new IllegalArgumentException("Transient bottom bar must have non-null parent");
    }

    @NonNull
    public B setAnchorView(@IdRes int r10) {
        View r11 = this.targetParent.findViewById(r10);
        if (r11 == null) goto L7;
        return (B) setAnchorView(r11);
    L7:
        throw new IllegalArgumentException("Unable to find anchor view with id: " + r10);
    }
}
