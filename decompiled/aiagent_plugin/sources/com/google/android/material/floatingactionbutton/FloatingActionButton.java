package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.appcompat.widget.h;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.util.g;
import androidx.core.view.ViewCompat;
import androidx.core.view.y;
import androidx.core.widget.l;
import com.google.android.material.animation.f;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.internal.VisibilityAwareImageButton;
import com.google.android.material.internal.d;
import com.google.android.material.internal.r;
import com.google.android.material.shape.m;
import com.google.android.material.shape.q;
import com.google.android.material.stateful.ExtendableSavedState;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.obric.aiagent.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes2.dex */
public class FloatingActionButton extends VisibilityAwareImageButton implements CoordinatorLayout.a, y, l, com.google.android.material.d.a, q {
    private static final int AUTO_MINI_LARGEST_SCREEN_WIDTH = 470;
    private static final int DEF_STYLE_RES = 0;
    private static final String EXPANDABLE_WIDGET_HELPER_KEY = "expandableWidgetHelper";
    private static final String LOG_TAG = "FloatingActionButton";
    public static final int NO_CUSTOM_SIZE = 0;
    public static final int SIZE_AUTO = -1;
    public static final int SIZE_MINI = 1;
    public static final int SIZE_NORMAL = 0;
    private ColorStateList backgroundTint;
    private PorterDuff.Mode backgroundTintMode;
    private int borderWidth;
    boolean compatPadding;
    private int customSize;
    private final com.google.android.material.d.c expandableWidgetHelper;
    private final h imageHelper;
    private PorterDuff.Mode imageMode;
    private int imagePadding;
    private ColorStateList imageTint;
    private FloatingActionButtonImpl impl;
    private int maxImageSize;
    private ColorStateList rippleColor;
    final Rect shadowPadding;
    private int size;
    private final Rect touchArea;

    protected static class BaseBehavior<T extends FloatingActionButton> extends CoordinatorLayout.b<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Rect f13388a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private a f13389b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f13390c;

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
        public /* synthetic */ boolean a(CoordinatorLayout r3, View r4, int r5) {
            return a(r3, (FloatingActionButton) ZeusTransformUtils.preCheckCast(r4, FloatingActionButton.class, "com.obric.aiagent.plugin"), r5);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
        public /* synthetic */ boolean a(CoordinatorLayout r3, View r4, Rect r5) {
            return a(r3, (FloatingActionButton) ZeusTransformUtils.preCheckCast(r4, FloatingActionButton.class, "com.obric.aiagent.plugin"), r5);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
        public /* synthetic */ boolean b(CoordinatorLayout r3, View r4, View r5) {
            return a(r3, (FloatingActionButton) ZeusTransformUtils.preCheckCast(r4, FloatingActionButton.class, "com.obric.aiagent.plugin"), r5);
        }

        public BaseBehavior() {
            this.f13390c = true;
        }

        public BaseBehavior(Context r3, AttributeSet r4) {
            Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
            AttributeSet r6 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin");
            super(r5, r6);
            TypedArray r7 = r5.obtainStyledAttributes(r6, R.styleable.FloatingActionButton_Behavior_Layout);
            this.f13390c = r7.getBoolean(ZeusTransformUtils.mapRes(R.styleable.FloatingActionButton_Behavior_Layout_behavior_autoHide, "styleable", "FloatingActionButton_Behavior_Layout_behavior_autoHide"), true);
            r7.recycle();
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
        public void a(CoordinatorLayout.LayoutParams r1) {
            if (r1.dodgeInsetEdges != 0) goto L6;
            r1.dodgeInsetEdges = 80;
            return;
        }

        public boolean a(CoordinatorLayout r3, FloatingActionButton r4, View r5) {
            if (ZeusTransformUtils.instanceOf(r5, AppBarLayout.class) == false) goto L6;
            a(r3, (AppBarLayout) ZeusTransformUtils.preCheckCast(r5, AppBarLayout.class, "com.obric.aiagent.plugin"), r4);
            return false;
        L6:
            if (a(r5) == false) goto L11;
            b(r5, r4);
            return false;
        L11:
            return false;
        }

        private static boolean a(View r2) {
            ViewGroup.LayoutParams r3 = r2.getLayoutParams();
            if (ZeusTransformUtils.instanceOf(r3, CoordinatorLayout.LayoutParams.class) == true) goto L5;
            return false;
        L5:
            return ZeusTransformUtils.instanceOf(((CoordinatorLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r3, CoordinatorLayout.LayoutParams.class, "com.obric.aiagent.plugin")).getBehavior(), BottomSheetBehavior.class);
        }

        private boolean a(View r4, FloatingActionButton r5) {
            CoordinatorLayout.LayoutParams r0 = (CoordinatorLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r5.getLayoutParams(), CoordinatorLayout.LayoutParams.class, "com.obric.aiagent.plugin");
            if (this.f13390c == true) goto L6;
            return false;
        L6:
            if (r0.getAnchorId() == r4.getId()) goto L9;
            return false;
        L9:
            if (r5.getUserSetVisibility() == 0) goto L11;
            return false;
        L11:
            return true;
        }

        private boolean a(CoordinatorLayout r3, AppBarLayout r4, FloatingActionButton r5) {
            if (a(r4, r5) == true) goto L6;
            return false;
        L6:
            if (this.f13388a != null) goto L8;
            this.f13388a = new Rect();
        L8:
            Rect r0 = this.f13388a;
            d.b(r3, r4, r0);
            if (r0.bottom > r4.getMinimumHeightForVisibleOverlappingContent()) goto L11;
            r5.hide(this.f13389b, false);
            return true;
        L11:
            r5.show(this.f13389b, false);
            return true;
        }

        private boolean b(View r5, FloatingActionButton r6) {
            if (a(r5, r6) == true) goto L5;
            return false;
        L5:
            CoordinatorLayout.LayoutParams r0 = (CoordinatorLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r6.getLayoutParams(), CoordinatorLayout.LayoutParams.class, "com.obric.aiagent.plugin");
            if (r5.getTop() >= ((r6.getHeight() / 2) + r0.topMargin)) goto L8;
            r6.hide(this.f13389b, false);
            return true;
        L8:
            r6.show(this.f13389b, false);
            return true;
        }

        public boolean a(CoordinatorLayout r7, FloatingActionButton r8, int r9) {
            List<View> r0 = r7.getDependencies(r8);
            int r1 = r0.size();
            int r2 = 0;
        L3:
            if (r2 >= r1) goto L15;
            View r3 = (View) ZeusTransformUtils.preCheckCast(r0.get(r2), View.class, "com.obric.aiagent.plugin");
            if (ZeusTransformUtils.instanceOf(r3, AppBarLayout.class) == false) goto L10;
            if (a(r7, (AppBarLayout) ZeusTransformUtils.preCheckCast(r3, AppBarLayout.class, "com.obric.aiagent.plugin"), r8) == true) goto L15;
        L14:
            r2 = r2 + 1;
            goto L3
        L10:
            if (a(r3) == false) goto L14;
            if (b(r3, r8) == false) goto L14;
        L15:
            r7.onLayoutChild(r8, r9);
            a(r7, r8);
            return true;
        }

        public boolean a(CoordinatorLayout r4, FloatingActionButton r5, Rect r6) {
            Rect r3 = r5.shadowPadding;
            r6.set(r5.getLeft() + r3.left, r5.getTop() + r3.top, r5.getRight() - r3.right, r5.getBottom() - r3.bottom);
            return true;
        }

        private void a(CoordinatorLayout r6, FloatingActionButton r7) {
            Rect r5 = r7.shadowPadding;
            if (r5 != null) goto L5;
            return;
        L5:
            if (r5.centerX() > 0) goto L7;
            return;
        L7:
            if (r5.centerY() <= 0) goto L28;
            CoordinatorLayout.LayoutParams r0 = (CoordinatorLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r7.getLayoutParams(), CoordinatorLayout.LayoutParams.class, "com.obric.aiagent.plugin");
            int r3 = 0;
            if (r7.getRight() < (r6.getWidth() - r0.rightMargin)) goto L12;
            int r1 = r5.right;
        L16:
            if (r7.getBottom() < (r6.getHeight() - r0.bottomMargin)) goto L19;
            r3 = r5.bottom;
        L21:
            if (r3 == 0) goto L23;
            ViewCompat.f(r7, r3);
        L23:
            if (r1 == 0) goto L29;
            ViewCompat.g(r7, r1);
            return;
        L29:
            return;
        L19:
            if (r7.getTop() > r0.topMargin) goto L21;
            r3 = -r5.top;
            goto L21
        L12:
            if (r7.getLeft() > r0.leftMargin) goto L14;
            r1 = -r5.left;
            goto L16
        L14:
            r1 = 0;
            goto L16
        }
    }

    public static class Behavior extends BaseBehavior<FloatingActionButton> {
        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.BaseBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.b
        public /* bridge */ /* synthetic */ void a(CoordinatorLayout.LayoutParams r1) {
            super.a(r1);
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.BaseBehavior
        public /* bridge */ /* synthetic */ boolean a(CoordinatorLayout r1, FloatingActionButton r2, int r3) {
            return super.a(r1, r2, r3);
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.BaseBehavior
        public /* bridge */ /* synthetic */ boolean a(CoordinatorLayout r1, FloatingActionButton r2, Rect r3) {
            return super.a(r1, r2, r3);
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.BaseBehavior
        public /* bridge */ /* synthetic */ boolean a(CoordinatorLayout r1, FloatingActionButton r2, View r3) {
            return super.a(r1, r2, r3);
        }

        public Behavior() {
        }

        public Behavior(Context r3, AttributeSet r4) {
            super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin"));
        }
    }

    public static abstract class a {
        public void a(FloatingActionButton r1) {
        }

        public void b(FloatingActionButton r1) {
        }

        public a() {
        }
    }

    private class b implements com.google.android.material.h.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ FloatingActionButton f13391a;

        b(FloatingActionButton r1) {
            this.f13391a = r1;
        }

        @Override // com.google.android.material.h.b
        public void a(int r3, int r4, int r5, int r6) {
            this.f13391a.shadowPadding.set(r3, r4, r5, r6);
            FloatingActionButton r0 = this.f13391a;
            r0.setPadding(r3 + FloatingActionButton.access$000(r0), r4 + FloatingActionButton.access$000(this.f13391a), r5 + FloatingActionButton.access$000(this.f13391a), r6 + FloatingActionButton.access$000(this.f13391a));
        }

        @Override // com.google.android.material.h.b
        public void a(Drawable r1) {
            if (r1 == null) goto L5;
            FloatingActionButton.access$101(this.f13391a, r1);
            return;
        }

        @Override // com.google.android.material.h.b
        public boolean a() {
            return this.f13391a.compatPadding;
        }
    }

    class c<T extends FloatingActionButton> implements FloatingActionButtonImpl.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ FloatingActionButton f13392a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final f<T> f13393b;

        c(FloatingActionButton r3, f<T> r4) {
            f<T> r5 = (f) ZeusTransformUtils.wrapperContextForParams(r4, f.class, "com.obric.aiagent.plugin");
            this.f13392a = r3;
            this.f13393b = r5;
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.a
        public void a() {
            this.f13393b.a(this.f13392a);
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.a
        public void b() {
            this.f13393b.b(this.f13392a);
        }

        public boolean equals(Object r3) {
            if (ZeusTransformUtils.instanceOf(r3, c.class) == true) goto L5;
        L7:
            return false;
        L5:
            if (((c) ZeusTransformUtils.preCheckCast(r3, c.class, "com.obric.aiagent.plugin")).f13393b.equals(this.f13393b) == false) goto L7;
            return true;
        }

        public int hashCode() {
            return this.f13393b.hashCode();
        }
    }

    public static /* synthetic */ int access$001(String r0, String r1) {
        return Log.i(r0, r1);
    }

    static /* synthetic */ int access$000(FloatingActionButton r0) {
        return r0.imagePadding;
    }

    static /* synthetic */ void access$101(FloatingActionButton r0, Drawable r1) {
        super.setBackgroundDrawable(r1);
    }

    static {
        DEF_STYLE_RES = ZeusTransformUtils.mapRes(R.style.Widget_Design_FloatingActionButton, "style", "Widget_Design_FloatingActionButton");
    }

    public FloatingActionButton(Context r3) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), null);
    }

    public FloatingActionButton(Context r4, AttributeSet r5) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r5, AttributeSet.class, "com.obric.aiagent.plugin"), ZeusTransformUtils.mapRes(R.attr.floatingActionButtonStyle, "attr", "floatingActionButtonStyle"));
    }

    public FloatingActionButton(Context r12, AttributeSet r13, int r14) {
        Context r15 = (Context) ZeusTransformUtils.wrapperContextForParams(r12, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r16 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r13, AttributeSet.class, "com.obric.aiagent.plugin");
        int r0 = DEF_STYLE_RES;
        super((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.google.android.material.theme.a.a.a(r15, r16, r14, r0), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r16, r14);
        this.shadowPadding = new Rect();
        this.touchArea = new Rect();
        Context r17 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        TypedArray r2 = com.google.android.material.internal.l.a(r17, r16, R.styleable.FloatingActionButton, r14, r0, new int[0]);
        this.backgroundTint = com.google.android.material.g.c.a(r17, r2, ZeusTransformUtils.mapRes(R.styleable.FloatingActionButton_backgroundTint, "styleable", "FloatingActionButton_backgroundTint"));
        this.backgroundTintMode = r.a(r2.getInt(ZeusTransformUtils.mapRes(R.styleable.FloatingActionButton_backgroundTintMode, "styleable", "FloatingActionButton_backgroundTintMode"), -1), null);
        this.rippleColor = com.google.android.material.g.c.a(r17, r2, ZeusTransformUtils.mapRes(R.styleable.FloatingActionButton_rippleColor, "styleable", "FloatingActionButton_rippleColor"));
        this.size = r2.getInt(ZeusTransformUtils.mapRes(R.styleable.FloatingActionButton_fabSize, "styleable", "FloatingActionButton_fabSize"), -1);
        this.customSize = r2.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.FloatingActionButton_fabCustomSize, "styleable", "FloatingActionButton_fabCustomSize"), 0);
        this.borderWidth = r2.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.FloatingActionButton_borderWidth, "styleable", "FloatingActionButton_borderWidth"), 0);
        float r3 = r2.getDimension(ZeusTransformUtils.mapRes(R.styleable.FloatingActionButton_elevation, "styleable", "FloatingActionButton_elevation"), 0.0f);
        float r6 = r2.getDimension(ZeusTransformUtils.mapRes(R.styleable.FloatingActionButton_hoveredFocusedTranslationZ, "styleable", "FloatingActionButton_hoveredFocusedTranslationZ"), 0.0f);
        float r5 = r2.getDimension(ZeusTransformUtils.mapRes(R.styleable.FloatingActionButton_pressedTranslationZ, "styleable", "FloatingActionButton_pressedTranslationZ"), 0.0f);
        this.compatPadding = r2.getBoolean(ZeusTransformUtils.mapRes(R.styleable.FloatingActionButton_useCompatPadding, "styleable", "FloatingActionButton_useCompatPadding"), false);
        int r1 = ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin").getDimensionPixelSize(ZeusTransformUtils.mapRes(R.dimen.mtrl_fab_min_touch_target, "dimen", "mtrl_fab_min_touch_target"));
        setMaxImageSize(r2.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.FloatingActionButton_maxImageSize, "styleable", "FloatingActionButton_maxImageSize"), 0));
        com.google.android.material.animation.c r7 = com.google.android.material.animation.c.a(r17, r2, ZeusTransformUtils.mapRes(R.styleable.FloatingActionButton_showMotionSpec, "styleable", "FloatingActionButton_showMotionSpec"));
        com.google.android.material.animation.c r9 = com.google.android.material.animation.c.a(r17, r2, ZeusTransformUtils.mapRes(R.styleable.FloatingActionButton_hideMotionSpec, "styleable", "FloatingActionButton_hideMotionSpec"));
        m r18 = m.a(r17, r16, r14, r0, m.f13550a).a();
        boolean r4 = r2.getBoolean(ZeusTransformUtils.mapRes(R.styleable.FloatingActionButton_ensureMinTouchTargetSize, "styleable", "FloatingActionButton_ensureMinTouchTargetSize"), false);
        setEnabled(r2.getBoolean(ZeusTransformUtils.mapRes(R.styleable.FloatingActionButton_android_enabled, "styleable", "FloatingActionButton_android_enabled"), true));
        r2.recycle();
        h r8 = new h(this);
        this.imageHelper = r8;
        r8.a(r16, r14);
        this.expandableWidgetHelper = new com.google.android.material.d.c(this);
        getImpl().a(r18);
        getImpl().a(this.backgroundTint, this.backgroundTintMode, this.rippleColor, this.borderWidth);
        getImpl().a(r1);
        getImpl().a(r3);
        getImpl().b(r6);
        getImpl().c(r5);
        getImpl().a(r7);
        getImpl().b(r9);
        getImpl().a(r4);
        setScaleType(ImageView.ScaleType.MATRIX);
    }

    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int r3, int r4) {
        int r0 = getSizeDimension();
        this.imagePadding = (r0 - this.maxImageSize) / 2;
        getImpl().o();
        int r5 = Math.min(resolveAdjustedSize(r0, r3), resolveAdjustedSize(r0, r4));
        setMeasuredDimension((this.shadowPadding.left + r5) + this.shadowPadding.right, (r5 + this.shadowPadding.top) + this.shadowPadding.bottom);
    }

    @Deprecated
    public int getRippleColor() {
        ColorStateList r0 = this.rippleColor;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.getDefaultColor();
    }

    public ColorStateList getRippleColorStateList() {
        return this.rippleColor;
    }

    public void setRippleColor(int r1) {
        setRippleColor(ColorStateList.valueOf(r1));
    }

    public void setRippleColor(ColorStateList r2) {
        if (this.rippleColor == r2) goto L6;
        this.rippleColor = r2;
        getImpl().b(this.rippleColor);
        return;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.a
    public CoordinatorLayout.b<FloatingActionButton> getBehavior() {
        return new Behavior();
    }

    @Override // android.view.View
    public ColorStateList getBackgroundTintList() {
        return this.backgroundTint;
    }

    @Override // android.view.View
    public void setBackgroundTintList(ColorStateList r2) {
        if (this.backgroundTint == r2) goto L6;
        this.backgroundTint = r2;
        getImpl().a(r2);
        return;
    }

    @Override // android.view.View
    public PorterDuff.Mode getBackgroundTintMode() {
        return this.backgroundTintMode;
    }

    @Override // android.view.View
    public void setBackgroundTintMode(PorterDuff.Mode r2) {
        if (this.backgroundTintMode == r2) goto L6;
        this.backgroundTintMode = r2;
        getImpl().a(r2);
        return;
    }

    @Override // androidx.core.view.y
    public void setSupportBackgroundTintList(ColorStateList r1) {
        setBackgroundTintList(r1);
    }

    @Override // androidx.core.view.y
    public ColorStateList getSupportBackgroundTintList() {
        return getBackgroundTintList();
    }

    @Override // androidx.core.view.y
    public void setSupportBackgroundTintMode(PorterDuff.Mode r1) {
        setBackgroundTintMode(r1);
    }

    @Override // androidx.core.view.y
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        return getBackgroundTintMode();
    }

    @Override // androidx.core.widget.l
    public void setSupportImageTintList(ColorStateList r2) {
        if (this.imageTint == r2) goto L6;
        this.imageTint = r2;
        onApplySupportImageTint();
        return;
    }

    @Override // androidx.core.widget.l
    public ColorStateList getSupportImageTintList() {
        return this.imageTint;
    }

    @Override // androidx.core.widget.l
    public void setSupportImageTintMode(PorterDuff.Mode r2) {
        if (this.imageMode == r2) goto L6;
        this.imageMode = r2;
        onApplySupportImageTint();
        return;
    }

    @Override // androidx.core.widget.l
    public PorterDuff.Mode getSupportImageTintMode() {
        return this.imageMode;
    }

    private void onApplySupportImageTint() {
        Drawable r0 = getDrawable();
        if (r0 != null) goto L5;
        return;
    L5:
        ColorStateList r1 = this.imageTint;
        if (r1 != null) goto L9;
        androidx.core.graphics.drawable.a.f(r0);
        return;
    L9:
        int r2 = r1.getColorForState(getDrawableState(), 0);
        PorterDuff.Mode r4 = this.imageMode;
        if (r4 != null) goto L12;
        r4 = PorterDuff.Mode.SRC_IN;
    L12:
        r0.mutate().setColorFilter(androidx.appcompat.widget.d.a(r2, r4));
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable r1) {
        INVOKESTATIC_com_google_android_material_floatingactionbutton_FloatingActionButton_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_i(LOG_TAG, "Setting a custom background is not supported.");
    }

    @Override // android.view.View
    public void setBackgroundResource(int r1) {
        INVOKESTATIC_com_google_android_material_floatingactionbutton_FloatingActionButton_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_i(LOG_TAG, "Setting a custom background is not supported.");
    }

    @Override // android.view.View
    public void setBackgroundColor(int r1) {
        INVOKESTATIC_com_google_android_material_floatingactionbutton_FloatingActionButton_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_i(LOG_TAG, "Setting a custom background is not supported.");
    }

    @Override // android.widget.ImageView
    public void setImageResource(int r2) {
        this.imageHelper.a(r2);
        onApplySupportImageTint();
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable r2) {
        if (getDrawable() == r2) goto L8;
        super.setImageDrawable(r2);
        getImpl().d();
        if (this.imageTint == null) goto L9;
        onApplySupportImageTint();
        return;
    L9:
        return;
    }

    @Override // com.google.android.material.shape.q
    public void setShapeAppearanceModel(m r1) {
        getImpl().a(r1);
    }

    @Override // com.google.android.material.shape.q
    public m getShapeAppearanceModel() {
        return (m) ZeusTransformUtils.preCheckCast(g.a(getImpl().e()), m.class, "com.obric.aiagent.plugin");
    }

    public boolean shouldEnsureMinTouchTargetSize() {
        return getImpl().i();
    }

    public void setEnsureMinTouchTargetSize(boolean r2) {
        if (r2 == getImpl().i()) goto L6;
        getImpl().a(r2);
        requestLayout();
        return;
    }

    @Override // com.google.android.material.internal.VisibilityAwareImageButton, android.widget.ImageView, android.view.View
    public void setVisibility(int r1) {
        super.setVisibility(r1);
    }

    public void setMaxImageSize(int r1) {
        this.maxImageSize = r1;
        getImpl().b(r1);
    }

    public void show() {
        show(null);
    }

    public void show(a r2) {
        show(r2, true);
    }

    void show(a r2, boolean r3) {
        getImpl().b(wrapOnVisibilityChangedListener(r2), r3);
    }

    public void addOnShowAnimationListener(Animator.AnimatorListener r3) {
        Animator.AnimatorListener r4 = (Animator.AnimatorListener) ZeusTransformUtils.wrapperContextForParams(r3, Animator.AnimatorListener.class, "com.obric.aiagent.plugin");
        getImpl().a(r4);
    }

    public void removeOnShowAnimationListener(Animator.AnimatorListener r3) {
        Animator.AnimatorListener r4 = (Animator.AnimatorListener) ZeusTransformUtils.wrapperContextForParams(r3, Animator.AnimatorListener.class, "com.obric.aiagent.plugin");
        getImpl().b(r4);
    }

    public void hide() {
        hide(null);
    }

    public void hide(a r2) {
        hide(r2, true);
    }

    void hide(a r2, boolean r3) {
        getImpl().a(wrapOnVisibilityChangedListener(r2), r3);
    }

    public void addOnHideAnimationListener(Animator.AnimatorListener r3) {
        Animator.AnimatorListener r4 = (Animator.AnimatorListener) ZeusTransformUtils.wrapperContextForParams(r3, Animator.AnimatorListener.class, "com.obric.aiagent.plugin");
        getImpl().c(r4);
    }

    public void removeOnHideAnimationListener(Animator.AnimatorListener r3) {
        Animator.AnimatorListener r4 = (Animator.AnimatorListener) ZeusTransformUtils.wrapperContextForParams(r3, Animator.AnimatorListener.class, "com.obric.aiagent.plugin");
        getImpl().d(r4);
    }

    public boolean setExpanded(boolean r1) {
        return this.expandableWidgetHelper.a(r1);
    }

    @Override // com.google.android.material.d.b
    public boolean isExpanded() {
        return this.expandableWidgetHelper.a();
    }

    public void setExpandedComponentIdHint(int r1) {
        this.expandableWidgetHelper.a(r1);
    }

    public int getExpandedComponentIdHint() {
        return this.expandableWidgetHelper.c();
    }

    public void setUseCompatPadding(boolean r2) {
        if (this.compatPadding == r2) goto L6;
        this.compatPadding = r2;
        getImpl().n();
        return;
    }

    public boolean getUseCompatPadding() {
        return this.compatPadding;
    }

    public void setSize(int r2) {
        this.customSize = 0;
        if (r2 == this.size) goto L6;
        this.size = r2;
        requestLayout();
        return;
    }

    public int getSize() {
        return this.size;
    }

    private FloatingActionButtonImpl.b wrapOnVisibilityChangedListener(final a r2) {
        if (r2 != null) goto L6;
        return null;
    L6:
        return new AnonymousClass1(this, r2);
    }

    public boolean isOrWillBeHidden() {
        return getImpl().w();
    }

    public boolean isOrWillBeShown() {
        return getImpl().v();
    }

    public void setCustomSize(int r2) {
        if (r2 < 0) goto L8;
        if (r2 == this.customSize) goto L9;
        this.customSize = r2;
        requestLayout();
        return;
    L9:
        return;
    L8:
        throw new IllegalArgumentException("Custom size must be non-negative");
    }

    public int getCustomSize() {
        return this.customSize;
    }

    public void clearCustomSize() {
        setCustomSize(0);
    }

    int getSizeDimension() {
        return getSizeDimension(this.size);
    }

    private int getSizeDimension(int r4) {
        int r0 = this.customSize;
        if (r0 == 0) goto L5;
        return r0;
    L5:
        Resources r1 = ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin");
        if (r4 == (-1)) goto L14;
        if (r4 == 1) goto L12;
        return r1.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.dimen.design_fab_size_normal, "dimen", "design_fab_size_normal"));
    L12:
        return r1.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.dimen.design_fab_size_mini, "dimen", "design_fab_size_mini"));
    L14:
        if (Math.max(r1.getConfiguration().screenWidthDp, r1.getConfiguration().screenHeightDp) >= AUTO_MINI_LARGEST_SCREEN_WIDTH) goto L17;
        return getSizeDimension(1);
    L17:
        return getSizeDimension(0);
    }

    @Override // android.widget.ImageView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        getImpl().q();
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getImpl().r();
    }

    @Override // android.widget.ImageView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        getImpl().a(getDrawableState());
    }

    @Override // android.widget.ImageView, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        getImpl().j();
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        Parcelable r0 = super.onSaveInstanceState();
        if (r0 != null) goto L5;
        r0 = new Bundle();
    L5:
        ExtendableSavedState r1 = new ExtendableSavedState(r0);
        r1.extendableStates.put(EXPANDABLE_WIDGET_HELPER_KEY, this.expandableWidgetHelper.b());
        return r1;
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable r3) {
        Parcelable r4 = (Parcelable) ZeusTransformUtils.wrapperContextForParams(r3, Parcelable.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r4, ExtendableSavedState.class) == true) goto L6;
        super.onRestoreInstanceState(r4);
        return;
    L6:
        ExtendableSavedState r5 = (ExtendableSavedState) ZeusTransformUtils.preCheckCast(r4, ExtendableSavedState.class, "com.obric.aiagent.plugin");
        super.onRestoreInstanceState(r5.getSuperState());
        this.expandableWidgetHelper.a((Bundle) ZeusTransformUtils.preCheckCast(g.a(r5.extendableStates.get(EXPANDABLE_WIDGET_HELPER_KEY)), Bundle.class, "com.obric.aiagent.plugin"));
    }

    @Deprecated
    public boolean getContentRect(Rect r4) {
        if (ViewCompat.F(this) == false) goto L6;
        r4.set(0, 0, getWidth(), getHeight());
        offsetRectWithShadow(r4);
        return true;
    L6:
        return false;
    }

    public void getMeasuredContentRect(Rect r4) {
        r4.set(0, 0, getMeasuredWidth(), getMeasuredHeight());
        offsetRectWithShadow(r4);
    }

    private void offsetRectWithShadow(Rect r3) {
        r3.left += this.shadowPadding.left;
        r3.top += this.shadowPadding.top;
        r3.right -= this.shadowPadding.right;
        r3.bottom -= this.shadowPadding.bottom;
    }

    public Drawable getContentBackground() {
        return getImpl().m();
    }

    private static int resolveAdjustedSize(int r2, int r3) {
        int r0 = View.MeasureSpec.getMode(r3);
        int r4 = View.MeasureSpec.getSize(r3);
        if (r0 == Integer.MIN_VALUE) goto L11;
        if (r0 != 0) goto L6;
        return r2;
    L6:
        if (r0 != 1073741824) goto L9;
        return r4;
    L9:
        throw new IllegalArgumentException();
    L11:
        return Math.min(r2, r4);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent r4) {
        if (r4.getAction() != 0) goto L11;
        if (getContentRect(this.touchArea) == false) goto L11;
        if (this.touchArea.contains((int) r4.getX(), (int) r4.getY()) == true) goto L11;
        return false;
    L11:
        return super.onTouchEvent(r4);
    }

    @Override // android.view.View
    public void setElevation(float r1) {
        super.setElevation(r1);
        getImpl().e(r1);
    }

    public float getCompatElevation() {
        return getImpl().a();
    }

    public void setCompatElevation(float r1) {
        getImpl().a(r1);
    }

    public void setCompatElevationResource(int r2) {
        setCompatElevation(ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin").getDimension(r2));
    }

    public float getCompatHoveredFocusedTranslationZ() {
        return getImpl().b();
    }

    public void setCompatHoveredFocusedTranslationZ(float r1) {
        getImpl().b(r1);
    }

    public void setCompatHoveredFocusedTranslationZResource(int r2) {
        setCompatHoveredFocusedTranslationZ(ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin").getDimension(r2));
    }

    public float getCompatPressedTranslationZ() {
        return getImpl().c();
    }

    public void setCompatPressedTranslationZ(float r1) {
        getImpl().c(r1);
    }

    public void setCompatPressedTranslationZResource(int r2) {
        setCompatPressedTranslationZ(ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin").getDimension(r2));
    }

    public com.google.android.material.animation.c getShowMotionSpec() {
        return getImpl().f();
    }

    public void setShowMotionSpec(com.google.android.material.animation.c r1) {
        getImpl().a(r1);
    }

    public void setShowMotionSpecResource(int r4) {
        setShowMotionSpec(com.google.android.material.animation.c.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r4));
    }

    public com.google.android.material.animation.c getHideMotionSpec() {
        return getImpl().g();
    }

    public void setHideMotionSpec(com.google.android.material.animation.c r1) {
        getImpl().b(r1);
    }

    public void setHideMotionSpecResource(int r4) {
        setHideMotionSpec(com.google.android.material.animation.c.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r4));
    }

    public void addTransformationCallback(f<? extends FloatingActionButton> r3) {
        f r4 = (f) ZeusTransformUtils.wrapperContextForParams(r3, f.class, "com.obric.aiagent.plugin");
        getImpl().a(new c(this, r4));
    }

    public void removeTransformationCallback(f<? extends FloatingActionButton> r3) {
        f r4 = (f) ZeusTransformUtils.wrapperContextForParams(r3, f.class, "com.obric.aiagent.plugin");
        getImpl().b(new c(this, r4));
    }

    @Override // android.view.View
    public void setTranslationX(float r1) {
        super.setTranslationX(r1);
        getImpl().k();
    }

    @Override // android.view.View
    public void setTranslationY(float r1) {
        super.setTranslationY(r1);
        getImpl().k();
    }

    @Override // android.view.View
    public void setTranslationZ(float r1) {
        super.setTranslationZ(r1);
        getImpl().k();
    }

    @Override // android.view.View
    public void setScaleX(float r1) {
        super.setScaleX(r1);
        getImpl().l();
    }

    @Override // android.view.View
    public void setScaleY(float r1) {
        super.setScaleY(r1);
        getImpl().l();
    }

    public void setShadowPaddingEnabled(boolean r1) {
        getImpl().b(r1);
    }

    private FloatingActionButtonImpl getImpl() {
        if (this.impl != null) goto L6;
        this.impl = createImpl();
    L6:
        return this.impl;
    }

    private FloatingActionButtonImpl createImpl() {
        if (Build.VERSION.SDK_INT < 21) goto L7;
        return new FloatingActionButtonImplLollipop(this, new b(this));
    L7:
        return new FloatingActionButtonImpl(this, new b(this));
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_com_google_android_material_floatingactionbutton_FloatingActionButton_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_i(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.i(r1, r2);
    }
}
