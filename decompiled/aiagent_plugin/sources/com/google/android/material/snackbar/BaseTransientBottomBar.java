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
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.WindowInsets;
import android.view.accessibility.AccessibilityManager;
import android.widget.FrameLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import com.google.android.material.behavior.SwipeDismissBehavior;
import com.google.android.material.g.c;
import com.google.android.material.internal.r;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.obric.aiagent.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.WeakReference;
import java.util.List;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes2.dex */
public abstract class BaseTransientBottomBar<B extends BaseTransientBottomBar<B>> {
    private static final String TAG = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final Handler f13598a = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final boolean f13599d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int[] f13600e = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final SnackbarBaseLayout f13601b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    com.google.android.material.snackbar.b.a f13602c;
    private final ViewGroup f;
    private final Context g;
    private final com.google.android.material.snackbar.a h;
    private boolean i;
    private Anchor j;
    private boolean k;
    private final Runnable l;
    private int m;
    private int n;
    private int o;
    private int p;
    private int q;
    private boolean r;
    private List<a<B>> s;
    private Behavior t;
    private final AccessibilityManager u;

    static class Anchor implements View.OnAttachStateChangeListener, ViewTreeObserver.OnGlobalLayoutListener {
        private final WeakReference<View> anchorView;
        private final WeakReference<BaseTransientBottomBar> transientBottomBar;

        static Anchor anchor(BaseTransientBottomBar r1, View r2) {
            Anchor r0 = new Anchor(r1, r2);
            if (ViewCompat.I(r2) == false) goto L5;
            r.a(r2, r0);
        L5:
            r2.addOnAttachStateChangeListener(r0);
            return r0;
        }

        private Anchor(BaseTransientBottomBar r2, View r3) {
            this.transientBottomBar = new WeakReference(r2);
            this.anchorView = new WeakReference(r3);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View r2) {
            if (unanchorIfNoTransientBottomBar() == false) goto L5;
            return;
        L5:
            r.a(r2, this);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View r2) {
            if (unanchorIfNoTransientBottomBar() == false) goto L5;
            return;
        L5:
            r.b(r2, this);
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (unanchorIfNoTransientBottomBar() == false) goto L5;
            return;
        L5:
            if (BaseTransientBottomBar.e((BaseTransientBottomBar) ZeusTransformUtils.preCheckCast(this.transientBottomBar.get(), BaseTransientBottomBar.class, "com.obric.aiagent.plugin")) == false) goto L10;
            BaseTransientBottomBar.f((BaseTransientBottomBar) ZeusTransformUtils.preCheckCast(this.transientBottomBar.get(), BaseTransientBottomBar.class, "com.obric.aiagent.plugin"));
            return;
        }

        View getAnchorView() {
            return (View) ZeusTransformUtils.preCheckCast(this.anchorView.get(), View.class, "com.obric.aiagent.plugin");
        }

        private boolean unanchorIfNoTransientBottomBar() {
            if (this.transientBottomBar.get() != null) goto L6;
            unanchor();
            return true;
        L6:
            return false;
        }

        void unanchor() {
            if (this.anchorView.get() == null) goto L5;
            ((View) ZeusTransformUtils.preCheckCast(this.anchorView.get(), View.class, "com.obric.aiagent.plugin")).removeOnAttachStateChangeListener(this);
            r.b((View) ZeusTransformUtils.preCheckCast(this.anchorView.get(), View.class, "com.obric.aiagent.plugin"), this);
        L5:
            this.anchorView.clear();
            this.transientBottomBar.clear();
        }
    }

    public static class Behavior extends SwipeDismissBehavior<View> {
        private final b g;

        static /* synthetic */ void a(Behavior r0, BaseTransientBottomBar r1) {
            r0.a(r1);
        }

        public Behavior() {
            this.g = new b(this);
        }

        private void a(BaseTransientBottomBar<?> r1) {
            this.g.a(r1);
        }

        @Override // com.google.android.material.behavior.SwipeDismissBehavior
        public boolean a(View r1) {
            return this.g.a(r1);
        }

        @Override // com.google.android.material.behavior.SwipeDismissBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.b
        public boolean a(CoordinatorLayout r2, View r3, MotionEvent r4) {
            this.g.a(r2, r3, r4);
            return super.a(r2, r3, r4);
        }
    }

    protected static class SnackbarBaseLayout extends FrameLayout {
        private static final View.OnTouchListener consumeAllTouchListener = null;
        private final float actionTextColorAlpha;
        private boolean addingToTargetParent;
        private int animationMode;
        private final float backgroundOverlayColorAlpha;
        private ColorStateList backgroundTint;
        private PorterDuff.Mode backgroundTintMode;
        private BaseTransientBottomBar<?> baseTransientBottomBar;
        private final int maxInlineActionWidth;
        private final int maxWidth;
        private Rect originalMargins;

        static /* synthetic */ Rect access$1000(SnackbarBaseLayout r0) {
            return r0.originalMargins;
        }

        static /* synthetic */ void access$500(SnackbarBaseLayout r0, BaseTransientBottomBar r1) {
            r0.setBaseTransientBottomBar(r1);
        }

        static {
            consumeAllTouchListener = new AnonymousClass1();
        }

        public SnackbarBaseLayout(Context r3) {
            this((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), null);
        }

        public SnackbarBaseLayout(Context r5, AttributeSet r6) {
            Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
            AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r6, AttributeSet.class, "com.obric.aiagent.plugin");
            super((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.google.android.material.theme.a.a.a(r7, r8, 0, 0), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r8);
            Context r9 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
            TypedArray r10 = r9.obtainStyledAttributes(r8, R.styleable.SnackbarLayout);
            if (r10.hasValue(ZeusTransformUtils.mapRes(R.styleable.SnackbarLayout_elevation, "styleable", "SnackbarLayout_elevation")) == false) goto L5;
            ViewCompat.a(this, r10.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.SnackbarLayout_elevation, "styleable", "SnackbarLayout_elevation"), 0));
        L5:
            this.animationMode = r10.getInt(ZeusTransformUtils.mapRes(R.styleable.SnackbarLayout_animationMode, "styleable", "SnackbarLayout_animationMode"), 0);
            this.backgroundOverlayColorAlpha = r10.getFloat(ZeusTransformUtils.mapRes(R.styleable.SnackbarLayout_backgroundOverlayColorAlpha, "styleable", "SnackbarLayout_backgroundOverlayColorAlpha"), 1.0f);
            setBackgroundTintList(c.a(r9, r10, ZeusTransformUtils.mapRes(R.styleable.SnackbarLayout_backgroundTint, "styleable", "SnackbarLayout_backgroundTint")));
            setBackgroundTintMode(r.a(r10.getInt(ZeusTransformUtils.mapRes(R.styleable.SnackbarLayout_backgroundTintMode, "styleable", "SnackbarLayout_backgroundTintMode"), -1), PorterDuff.Mode.SRC_IN));
            this.actionTextColorAlpha = r10.getFloat(ZeusTransformUtils.mapRes(R.styleable.SnackbarLayout_actionTextColorAlpha, "styleable", "SnackbarLayout_actionTextColorAlpha"), 1.0f);
            this.maxWidth = r10.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.SnackbarLayout_android_maxWidth, "styleable", "SnackbarLayout_android_maxWidth"), -1);
            this.maxInlineActionWidth = r10.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.SnackbarLayout_maxActionInlineWidth, "styleable", "SnackbarLayout_maxActionInlineWidth"), -1);
            r10.recycle();
            setOnTouchListener(consumeAllTouchListener);
            setFocusable(true);
            if (getBackground() != null) goto L9;
            ViewCompat.a(this, createThemedBackground());
            return;
        }

        @Override // android.view.View
        public void setBackground(Drawable r1) {
            setBackgroundDrawable(r1);
        }

        @Override // android.view.View
        public void setBackgroundDrawable(Drawable r2) {
            if (r2 != null) goto L4;
        L6:
            super.setBackgroundDrawable(r2);
            return;
        L4:
            if (this.backgroundTint == null) goto L6;
            r2 = androidx.core.graphics.drawable.a.g(r2.mutate());
            androidx.core.graphics.drawable.a.a(r2, this.backgroundTint);
            androidx.core.graphics.drawable.a.a(r2, this.backgroundTintMode);
            goto L6
        }

        @Override // android.view.View
        public void setBackgroundTintList(ColorStateList r2) {
            this.backgroundTint = r2;
            if (getBackground() == null) goto L8;
            Drawable r0 = androidx.core.graphics.drawable.a.g(getBackground().mutate());
            androidx.core.graphics.drawable.a.a(r0, r2);
            androidx.core.graphics.drawable.a.a(r0, this.backgroundTintMode);
            if (r0 == getBackground()) goto L9;
            super.setBackgroundDrawable(r0);
            return;
        L9:
            return;
        }

        @Override // android.view.View
        public void setBackgroundTintMode(PorterDuff.Mode r2) {
            this.backgroundTintMode = r2;
            if (getBackground() == null) goto L8;
            Drawable r0 = androidx.core.graphics.drawable.a.g(getBackground().mutate());
            androidx.core.graphics.drawable.a.a(r0, r2);
            if (r0 == getBackground()) goto L9;
            super.setBackgroundDrawable(r0);
            return;
        L9:
            return;
        }

        @Override // android.view.View
        public void setOnClickListener(View.OnClickListener r3) {
            View.OnClickListener r4 = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r3, View.OnClickListener.class, "com.obric.aiagent.plugin");
            if (r4 == null) goto L5;
            View.OnTouchListener r0 = null;
        L6:
            setOnTouchListener(r0);
            super.setOnClickListener(r4);
            return;
        L5:
            r0 = consumeAllTouchListener;
            goto L6
        }

        @Override // android.widget.FrameLayout, android.view.View
        public void onMeasure(int r2, int r3) {
            super.onMeasure(r2, r3);
            if (this.maxWidth <= 0) goto L8;
            int r4 = getMeasuredWidth();
            int r0 = this.maxWidth;
            if (r4 <= r0) goto L9;
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(r0, 1073741824), r3);
            return;
        L9:
            return;
        }

        @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
        public void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
            super.onLayout(r1, r2, r3, r4, r5);
            BaseTransientBottomBar<?> r0 = this.baseTransientBottomBar;
            if (r0 == null) goto L6;
            r0.g();
            return;
        }

        @Override // android.view.ViewGroup, android.view.View
        public void onAttachedToWindow() {
            super.onAttachedToWindow();
            BaseTransientBottomBar<?> r0 = this.baseTransientBottomBar;
            if (r0 == null) goto L5;
            r0.e();
        L5:
            ViewCompat.u(this);
        }

        @Override // android.view.ViewGroup, android.view.View
        public void onDetachedFromWindow() {
            super.onDetachedFromWindow();
            BaseTransientBottomBar<?> r0 = this.baseTransientBottomBar;
            if (r0 == null) goto L6;
            r0.f();
            return;
        }

        @Override // android.view.View
        public void setLayoutParams(ViewGroup.LayoutParams r3) {
            super.setLayoutParams(r3);
            if (this.addingToTargetParent == false) goto L5;
            return;
        L5:
            if (ZeusTransformUtils.instanceOf(r3, ViewGroup.MarginLayoutParams.class) == false) goto L11;
            updateOriginalMargins((ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r3, ViewGroup.MarginLayoutParams.class, "com.obric.aiagent.plugin"));
            BaseTransientBottomBar<?> r2 = this.baseTransientBottomBar;
            if (r2 == null) goto L12;
            BaseTransientBottomBar.a(r2);
            return;
        L12:
            return;
        }

        int getAnimationMode() {
            return this.animationMode;
        }

        void setAnimationMode(int r1) {
            this.animationMode = r1;
        }

        float getBackgroundOverlayColorAlpha() {
            return this.backgroundOverlayColorAlpha;
        }

        float getActionTextColorAlpha() {
            return this.actionTextColorAlpha;
        }

        int getMaxWidth() {
            return this.maxWidth;
        }

        int getMaxInlineActionWidth() {
            return this.maxInlineActionWidth;
        }

        void addToTargetParent(ViewGroup r2) {
            this.addingToTargetParent = true;
            r2.addView(this);
            this.addingToTargetParent = false;
        }

        private void setBaseTransientBottomBar(BaseTransientBottomBar<?> r1) {
            this.baseTransientBottomBar = r1;
        }

        private void updateOriginalMargins(ViewGroup.MarginLayoutParams r5) {
            this.originalMargins = new Rect(r5.leftMargin, r5.topMargin, r5.rightMargin, r5.bottomMargin);
        }

        private Drawable createThemedBackground() {
            float r0 = ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin").getDimension(ZeusTransformUtils.mapRes(R.dimen.mtrl_snackbar_background_corner_radius, "dimen", "mtrl_snackbar_background_corner_radius"));
            GradientDrawable r1 = new GradientDrawable();
            r1.setShape(0);
            r1.setCornerRadius(r0);
            r1.setColor(com.google.android.material.color.b.a(this, ZeusTransformUtils.mapRes(R.attr.colorSurface, "attr", "colorSurface"), ZeusTransformUtils.mapRes(R.attr.colorOnSurface, "attr", "colorOnSurface"), getBackgroundOverlayColorAlpha()));
            if (this.backgroundTint == null) goto L7;
            Drawable r2 = androidx.core.graphics.drawable.a.g(r1);
            androidx.core.graphics.drawable.a.a(r2, this.backgroundTint);
            return r2;
        L7:
            return androidx.core.graphics.drawable.a.g(r1);
        }
    }

    public static abstract class a<B> {
        public void a(B r1) {
        }

        public void a(B r1, int r2) {
        }

        public a() {
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private com.google.android.material.snackbar.b.a f13606a;

        public b(SwipeDismissBehavior<?> r1) {
            r1.a(0.1f);
            r1.b(0.6f);
            r1.a(0);
        }

        public void a(BaseTransientBottomBar<?> r1) {
            this.f13606a = r1.f13602c;
        }

        public boolean a(View r1) {
            return ZeusTransformUtils.instanceOf(r1, SnackbarBaseLayout.class);
        }

        public void a(CoordinatorLayout r2, View r3, MotionEvent r4) {
            int r0 = r4.getActionMasked();
            if (r0 == 0) goto L11;
            if (r0 != 1) goto L7;
        L9:
            com.google.android.material.snackbar.b.a().d(this.f13606a);
            return;
        L7:
            if (r0 == 3) goto L9;
            return;
        L11:
            if (r2.isPointInChildBounds(r3, (int) r4.getX(), (int) r4.getY()) == false) goto L15;
            com.google.android.material.snackbar.b.a().c(this.f13606a);
            return;
        }
    }

    static /* synthetic */ void a(BaseTransientBottomBar r0) {
        r0.l();
    }

    static /* synthetic */ void b(BaseTransientBottomBar r0) {
        r0.r();
    }

    static /* synthetic */ void c(BaseTransientBottomBar r0) {
        r0.s();
    }

    static /* synthetic */ com.google.android.material.snackbar.a d(BaseTransientBottomBar r0) {
        return r0.h;
    }

    static /* synthetic */ boolean e(BaseTransientBottomBar r0) {
        return r0.k;
    }

    static /* synthetic */ void f(BaseTransientBottomBar r0) {
        r0.p();
    }

    static /* synthetic */ boolean k() {
        return f13599d;
    }

    static {
        if (Build.VERSION.SDK_INT >= 16) goto L5;
    L7:
        boolean r0 = false;
    L8:
        f13599d = r0;
        f13600e = new int[]{ZeusTransformUtils.mapRes(R.attr.snackbarStyle, "attr", "snackbarStyle")};
        TAG = BaseTransientBottomBar.class.getSimpleName();
        f13598a = new Handler(Looper.getMainLooper(), new AnonymousClass1());
        return;
    L5:
        if (Build.VERSION.SDK_INT > 19) goto L7;
        r0 = true;
        goto L8
    }

    private void l() {
        ViewGroup.LayoutParams r0 = this.f13601b.getLayoutParams();
        if (ZeusTransformUtils.instanceOf(r0, ViewGroup.MarginLayoutParams.class) == true) goto L5;
    L20:
        a(TAG, "Unable to update margins because layout params are not MarginLayoutParams");
        return;
    L5:
        if (SnackbarBaseLayout.access$1000(this.f13601b) == null) goto L20;
        if (this.f13601b.getParent() != null) goto L11;
        return;
    L11:
        if (a() == null) goto L13;
        int r1 = this.q;
    L14:
        ViewGroup.MarginLayoutParams r2 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r0, ViewGroup.MarginLayoutParams.class, "com.obric.aiagent.plugin");
        r2.bottomMargin = SnackbarBaseLayout.access$1000(this.f13601b).bottom + r1;
        r2.leftMargin = SnackbarBaseLayout.access$1000(this.f13601b).left + this.n;
        r2.rightMargin = SnackbarBaseLayout.access$1000(this.f13601b).right + this.o;
        r2.topMargin = SnackbarBaseLayout.access$1000(this.f13601b).top;
        this.f13601b.requestLayout();
        if (Build.VERSION.SDK_INT >= 29) goto L17;
        return;
    L17:
        if (m() == false) goto L23;
        this.f13601b.removeCallbacks(this.l);
        this.f13601b.post(this.l);
        return;
    L23:
        return;
    L13:
        r1 = this.m;
        goto L14
    }

    private boolean m() {
        if (this.p > 0) goto L5;
    L9:
        return false;
    L5:
        if (this.i == true) goto L9;
        if (n() == false) goto L9;
        return true;
    }

    private boolean n() {
        ViewGroup.LayoutParams r2 = this.f13601b.getLayoutParams();
        if (ZeusTransformUtils.instanceOf(r2, CoordinatorLayout.LayoutParams.class) == true) goto L5;
    L7:
        return false;
    L5:
        if (ZeusTransformUtils.instanceOf(((CoordinatorLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r2, CoordinatorLayout.LayoutParams.class, "com.obric.aiagent.plugin")).getBehavior(), SwipeDismissBehavior.class) == false) goto L7;
        return true;
    }

    public View a() {
        Anchor r0 = this.j;
        if (r0 != null) goto L6;
        return null;
    L6:
        return r0.getAnchorView();
    }

    public Context getContext() {
        return this.g;
    }

    public void a(int r2) {
        com.google.android.material.snackbar.b.a().a(this.f13602c, r2);
    }

    public boolean b() {
        return com.google.android.material.snackbar.b.a().e(this.f13602c);
    }

    public SwipeDismissBehavior<? extends View> c() {
        return new Behavior();
    }

    final void d() {
        if (this.f13601b.getParent() != null) goto L9;
        ViewGroup.LayoutParams r0 = this.f13601b.getLayoutParams();
        if (ZeusTransformUtils.instanceOf(r0, CoordinatorLayout.LayoutParams.class) == false) goto L7;
        a((CoordinatorLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r0, CoordinatorLayout.LayoutParams.class, "com.obric.aiagent.plugin"));
    L7:
        this.f13601b.addToTargetParent(this.f);
        p();
        this.f13601b.setVisibility(4);
    L9:
        if (ViewCompat.F(this.f13601b) == false) goto L12;
        o();
        return;
    L12:
        this.r = true;
    }

    void e() {
        if (Build.VERSION.SDK_INT < 29) goto L8;
        WindowInsets r0 = this.f13601b.getRootWindowInsets();
        if (r0 == null) goto L9;
        this.p = r0.getMandatorySystemGestureInsets().bottom;
        l();
        return;
    L9:
        return;
    }

    void f() {
        if (b() == false) goto L6;
        f13598a.post(new AnonymousClass2(this));
        return;
    }

    void g() {
        if (this.r == false) goto L6;
        o();
        this.r = false;
        return;
    }

    private void o() {
        if (j() == false) goto L6;
        h();
        return;
    L6:
        if (this.f13601b.getParent() == null) goto L8;
        this.f13601b.setVisibility(0);
    L8:
        i();
    }

    private void a(CoordinatorLayout.LayoutParams r4) {
        SwipeDismissBehavior<? extends View> r0 = this.t;
        if (r0 != null) goto L6;
        r0 = c();
    L6:
        if (ZeusTransformUtils.instanceOf(r0, Behavior.class) == false) goto L8;
        Behavior.a((Behavior) ZeusTransformUtils.preCheckCast(r0, Behavior.class, "com.obric.aiagent.plugin"), this);
    L8:
        r0.a(new AnonymousClass3(this));
        r4.setBehavior(r0);
        if (a() != null) goto L12;
        r4.insetEdge = 80;
        return;
    }

    private void p() {
        this.q = q();
        l();
    }

    private int q() {
        if (a() != null) goto L6;
        return 0;
    L6:
        int[] r1 = new int[2];
        a().getLocationOnScreen(r1);
        int r2 = r1[1];
        int[] r0 = new int[2];
        this.f.getLocationOnScreen(r0);
        return (r0[1] + this.f.getHeight()) - r2;
    }

    void h() {
        this.f13601b.post(new AnonymousClass4(this));
    }

    private void d(int r3) {
        if (this.f13601b.getAnimationMode() != 1) goto L5;
        e(r3);
        return;
    L5:
        f(r3);
    }

    private void r() {
        ValueAnimator r1 = a(new float[]{0.0f, 1.0f});
        ValueAnimator r2 = b(new float[]{0.8f, 1.0f});
        AnimatorSet r3 = new AnimatorSet();
        r3.playTogether(new Animator[]{r1, r2});
        r3.setDuration(150);
        r3.addListener(new AnonymousClass9(this));
        r3.start();
    }

    private void e(final int r4) {
        ValueAnimator r0 = a(new float[]{1.0f, 0.0f});
        r0.setDuration(75);
        r0.addListener(new AnonymousClass10(this, r4));
        r0.start();
    }

    private ValueAnimator a(float... r2) {
        ValueAnimator r3 = ValueAnimator.ofFloat(r2);
        r3.setInterpolator(com.google.android.material.animation.a.f13142a);
        r3.addUpdateListener(new AnonymousClass11(this));
        return r3;
    }

    private ValueAnimator b(float... r2) {
        ValueAnimator r3 = ValueAnimator.ofFloat(r2);
        r3.setInterpolator(com.google.android.material.animation.a.f13145d);
        r3.addUpdateListener(new AnonymousClass12(this));
        return r3;
    }

    private void s() {
        final int r0 = t();
        if (f13599d == false) goto L5;
        ViewCompat.f(this.f13601b, r0);
    L6:
        ValueAnimator r1 = new ValueAnimator();
        r1.setIntValues(new int[]{r0, 0});
        r1.setInterpolator(com.google.android.material.animation.a.f13143b);
        r1.setDuration(250);
        r1.addListener(new AnonymousClass13(this));
        r1.addUpdateListener(new AnonymousClass14(this, r0));
        r1.start();
        return;
    L5:
        this.f13601b.setTranslationY(r0);
        goto L6
    }

    private void f(final int r5) {
        ValueAnimator r0 = new ValueAnimator();
        r0.setIntValues(new int[]{0, t()});
        r0.setInterpolator(com.google.android.material.animation.a.f13143b);
        r0.setDuration(250);
        r0.addListener(new AnonymousClass15(this, r5));
        r0.addUpdateListener(new AnonymousClass16(this));
        r0.start();
    }

    private int t() {
        int r0 = this.f13601b.getHeight();
        ViewGroup.LayoutParams r3 = this.f13601b.getLayoutParams();
        if (ZeusTransformUtils.instanceOf(r3, ViewGroup.MarginLayoutParams.class) == true) goto L5;
        return r0;
    L5:
        return r0 + ((ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r3, ViewGroup.MarginLayoutParams.class, "com.obric.aiagent.plugin")).bottomMargin;
    }

    final void b(int r2) {
        if (j() == true) goto L5;
    L7:
        c(r2);
        return;
    L5:
        if (this.f13601b.getVisibility() != 0) goto L7;
        d(r2);
    }

    void i() {
        com.google.android.material.snackbar.b.a().b(this.f13602c);
        List<a<B>> r0 = this.s;
        if (r0 == null) goto L7;
        int r1 = r0.size() - 1;
    L5:
        if (r1 < 0) goto L9;
        ((a) ZeusTransformUtils.preCheckCast(this.s.get(r1), a.class, "com.obric.aiagent.plugin")).a(this);
        r1 = r1 - 1;
        goto L5
    L9:
        return;
    }

    void c(int r5) {
        com.google.android.material.snackbar.b.a().a(this.f13602c);
        List<a<B>> r0 = this.s;
        if (r0 == null) goto L7;
        int r1 = r0.size() - 1;
    L5:
        if (r1 < 0) goto L7;
        ((a) ZeusTransformUtils.preCheckCast(this.s.get(r1), a.class, "com.obric.aiagent.plugin")).a(this, r5);
        r1 = r1 - 1;
    L7:
        ViewParent r6 = this.f13601b.getParent();
        if (ZeusTransformUtils.instanceOf(r6, ViewGroup.class) == false) goto L12;
        ((ViewGroup) ZeusTransformUtils.preCheckCast(r6, ViewGroup.class, "com.obric.aiagent.plugin")).removeView(this.f13601b);
        return;
    }

    boolean j() {
        AccessibilityManager r1 = this.u;
        if (r1 != null) goto L5;
        return true;
    L5:
        List<AccessibilityServiceInfo> r2 = r1.getEnabledAccessibilityServiceList(1);
        if (r2 != null) goto L8;
    L10:
        return false;
    L8:
        if (r2.isEmpty() == false) goto L10;
        return true;
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.w(r1, r2);
    }
}
