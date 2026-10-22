package com.google.android.material.appbar;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.ViewCompat;
import androidx.core.view.al;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.google.android.material.internal.l;
import com.obric.aiagent.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public class CollapsingToolbarLayout extends FrameLayout {
    private static final int DEFAULT_SCRIM_ANIMATION_DURATION = 600;
    private static final int DEF_STYLE_RES = 0;
    public static final int TITLE_COLLAPSE_MODE_FADE = 1;
    public static final int TITLE_COLLAPSE_MODE_SCALE = 0;
    final com.google.android.material.internal.b collapsingTextHelper;
    private boolean collapsingTitleEnabled;
    private Drawable contentScrim;
    int currentOffset;
    private boolean drawCollapsingTitle;
    private View dummyView;
    final com.google.android.material.c.a elevationOverlayProvider;
    private int expandedMarginBottom;
    private int expandedMarginEnd;
    private int expandedMarginStart;
    private int expandedMarginTop;
    private int extraMultilineHeight;
    private boolean extraMultilineHeightEnabled;
    private boolean forceApplySystemWindowInsetTop;
    al lastInsets;
    private AppBarLayout.e onOffsetChangedListener;
    private boolean refreshToolbar;
    private int scrimAlpha;
    private long scrimAnimationDuration;
    private ValueAnimator scrimAnimator;
    private int scrimVisibleHeightTrigger;
    private boolean scrimsAreShown;
    Drawable statusBarScrim;
    private int titleCollapseMode;
    private final Rect tmpRect;
    private ViewGroup toolbar;
    private View toolbarDirectChild;
    private int toolbarId;
    private int topInsetApplied;

    public static class LayoutParams extends FrameLayout.LayoutParams {
        public static final int COLLAPSE_MODE_OFF = 0;
        public static final int COLLAPSE_MODE_PARALLAX = 2;
        public static final int COLLAPSE_MODE_PIN = 1;
        private static final float DEFAULT_PARALLAX_MULTIPLIER = 0.5f;
        int collapseMode;
        float parallaxMult;

        public LayoutParams(Context r5, AttributeSet r6) {
            Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
            AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r6, AttributeSet.class, "com.obric.aiagent.plugin");
            super(r7, r8);
            this.collapseMode = 0;
            this.parallaxMult = DEFAULT_PARALLAX_MULTIPLIER;
            TypedArray r9 = r7.obtainStyledAttributes(r8, R.styleable.CollapsingToolbarLayout_Layout);
            this.collapseMode = r9.getInt(ZeusTransformUtils.mapRes(R.styleable.CollapsingToolbarLayout_Layout_layout_collapseMode, "styleable", "CollapsingToolbarLayout_Layout_layout_collapseMode"), 0);
            setParallaxMultiplier(r9.getFloat(ZeusTransformUtils.mapRes(R.styleable.CollapsingToolbarLayout_Layout_layout_collapseParallaxMultiplier, "styleable", "CollapsingToolbarLayout_Layout_layout_collapseParallaxMultiplier"), DEFAULT_PARALLAX_MULTIPLIER));
            r9.recycle();
        }

        public LayoutParams(int r1, int r2) {
            super(r1, r2);
            this.collapseMode = 0;
            this.parallaxMult = DEFAULT_PARALLAX_MULTIPLIER;
        }

        public LayoutParams(int r1, int r2, int r3) {
            super(r1, r2, r3);
            this.collapseMode = 0;
            this.parallaxMult = DEFAULT_PARALLAX_MULTIPLIER;
        }

        public LayoutParams(ViewGroup.LayoutParams r1) {
            super(r1);
            this.collapseMode = 0;
            this.parallaxMult = DEFAULT_PARALLAX_MULTIPLIER;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams r1) {
            super(r1);
            this.collapseMode = 0;
            this.parallaxMult = DEFAULT_PARALLAX_MULTIPLIER;
        }

        public LayoutParams(FrameLayout.LayoutParams r1) {
            super(r1);
            this.collapseMode = 0;
            this.parallaxMult = DEFAULT_PARALLAX_MULTIPLIER;
        }

        public void setCollapseMode(int r1) {
            this.collapseMode = r1;
        }

        public int getCollapseMode() {
            return this.collapseMode;
        }

        public void setParallaxMultiplier(float r1) {
            this.parallaxMult = r1;
        }

        public float getParallaxMultiplier() {
            return this.parallaxMult;
        }
    }

    private class a implements AppBarLayout.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ CollapsingToolbarLayout f13174a;

        a(CollapsingToolbarLayout r1) {
            this.f13174a = r1;
        }

        @Override // com.google.android.material.appbar.AppBarLayout.a
        public void a(AppBarLayout r9, int r10) {
            this.f13174a.currentOffset = r10;
            if (this.f13174a.lastInsets == null) goto L5;
            int r11 = this.f13174a.lastInsets.b();
        L6:
            int r1 = this.f13174a.getChildCount();
            int r2 = 0;
        L7:
            if (r2 >= r1) goto L16;
            View r3 = this.f13174a.getChildAt(r2);
            LayoutParams r4 = (LayoutParams) ZeusTransformUtils.preCheckCast(r3.getLayoutParams(), LayoutParams.class, "com.obric.aiagent.plugin");
            d r5 = CollapsingToolbarLayout.getViewOffsetHelper(r3);
            int r6 = r4.collapseMode;
            if (r6 != 1) goto L11;
            r5.a(androidx.core.a.a.a(-r10, 0, this.f13174a.getMaxOffsetForPinChild(r3)));
        L15:
            r2 = r2 + 1;
            goto L7
        L11:
            if (r6 != 2) goto L15;
            r5.a(Math.round((-r10) * r4.parallaxMult));
            goto L15
        L16:
            this.f13174a.updateScrimVisibility();
            if (this.f13174a.statusBarScrim == null) goto L20;
            if (r11 <= 0) goto L20;
            ViewCompat.f(this.f13174a);
        L20:
            int r0 = this.f13174a.getHeight();
            int r7 = (r0 - ViewCompat.o(this.f13174a)) - r11;
            float r8 = r7;
            this.f13174a.collapsingTextHelper.c(Math.min(1.0f, (r0 - this.f13174a.getScrimVisibleHeightTrigger()) / r8));
            this.f13174a.collapsingTextHelper.a(this.f13174a.currentOffset + r7);
            this.f13174a.collapsingTextHelper.d(Math.abs(r10) / r8);
            return;
        L5:
            r11 = 0;
            goto L6
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return generateDefaultLayoutParams();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public /* bridge */ /* synthetic */ FrameLayout.LayoutParams generateDefaultLayoutParams() {
        return generateDefaultLayoutParams();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(AttributeSet r3) {
        return generateLayoutParams((AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.aiagent.plugin"));
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r1) {
        return generateLayoutParams(r1);
    }

    static {
        DEF_STYLE_RES = ZeusTransformUtils.mapRes(R.style.Widget_Design_CollapsingToolbar, "style", "Widget_Design_CollapsingToolbar");
    }

    public CollapsingToolbarLayout(Context r3) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), null);
    }

    public CollapsingToolbarLayout(Context r4, AttributeSet r5) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r5, AttributeSet.class, "com.obric.aiagent.plugin"), ZeusTransformUtils.mapRes(R.attr.collapsingToolbarLayoutStyle, "attr", "collapsingToolbarLayoutStyle"));
    }

    public CollapsingToolbarLayout(Context r10, AttributeSet r11, int r12) {
        Context r13 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r3 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r11, AttributeSet.class, "com.obric.aiagent.plugin");
        int r6 = DEF_STYLE_RES;
        super((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.google.android.material.theme.a.a.a(r13, r3, r12, r6), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r3, r12);
        this.refreshToolbar = true;
        this.tmpRect = new Rect();
        this.scrimVisibleHeightTrigger = -1;
        this.topInsetApplied = 0;
        this.extraMultilineHeight = 0;
        Context r1 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        com.google.android.material.internal.b r8 = new com.google.android.material.internal.b(this);
        this.collapsingTextHelper = r8;
        r8.a(com.google.android.material.animation.a.f13146e);
        r8.b(false);
        this.elevationOverlayProvider = new com.google.android.material.c.a(r1);
        TypedArray r14 = l.a(r1, r3, R.styleable.CollapsingToolbarLayout, r12, r6, new int[0]);
        r8.b(r14.getInt(ZeusTransformUtils.mapRes(R.styleable.CollapsingToolbarLayout_expandedTitleGravity, "styleable", "CollapsingToolbarLayout_expandedTitleGravity"), 8388691));
        r8.c(r14.getInt(ZeusTransformUtils.mapRes(R.styleable.CollapsingToolbarLayout_collapsedTitleGravity, "styleable", "CollapsingToolbarLayout_collapsedTitleGravity"), 8388627));
        int r2 = r14.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.CollapsingToolbarLayout_expandedTitleMargin, "styleable", "CollapsingToolbarLayout_expandedTitleMargin"), 0);
        this.expandedMarginBottom = r2;
        this.expandedMarginEnd = r2;
        this.expandedMarginTop = r2;
        this.expandedMarginStart = r2;
        if (r14.hasValue(ZeusTransformUtils.mapRes(R.styleable.CollapsingToolbarLayout_expandedTitleMarginStart, "styleable", "CollapsingToolbarLayout_expandedTitleMarginStart")) == false) goto L6;
        this.expandedMarginStart = r14.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.CollapsingToolbarLayout_expandedTitleMarginStart, "styleable", "CollapsingToolbarLayout_expandedTitleMarginStart"), 0);
    L6:
        if (r14.hasValue(ZeusTransformUtils.mapRes(R.styleable.CollapsingToolbarLayout_expandedTitleMarginEnd, "styleable", "CollapsingToolbarLayout_expandedTitleMarginEnd")) == false) goto L9;
        this.expandedMarginEnd = r14.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.CollapsingToolbarLayout_expandedTitleMarginEnd, "styleable", "CollapsingToolbarLayout_expandedTitleMarginEnd"), 0);
    L9:
        if (r14.hasValue(ZeusTransformUtils.mapRes(R.styleable.CollapsingToolbarLayout_expandedTitleMarginTop, "styleable", "CollapsingToolbarLayout_expandedTitleMarginTop")) == false) goto L12;
        this.expandedMarginTop = r14.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.CollapsingToolbarLayout_expandedTitleMarginTop, "styleable", "CollapsingToolbarLayout_expandedTitleMarginTop"), 0);
    L12:
        if (r14.hasValue(ZeusTransformUtils.mapRes(R.styleable.CollapsingToolbarLayout_expandedTitleMarginBottom, "styleable", "CollapsingToolbarLayout_expandedTitleMarginBottom")) == false) goto L14;
        this.expandedMarginBottom = r14.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.CollapsingToolbarLayout_expandedTitleMarginBottom, "styleable", "CollapsingToolbarLayout_expandedTitleMarginBottom"), 0);
    L14:
        this.collapsingTitleEnabled = r14.getBoolean(ZeusTransformUtils.mapRes(R.styleable.CollapsingToolbarLayout_titleEnabled, "styleable", "CollapsingToolbarLayout_titleEnabled"), true);
        setTitle(r14.getText(ZeusTransformUtils.mapRes(R.styleable.CollapsingToolbarLayout_title, "styleable", "CollapsingToolbarLayout_title")));
        r8.e(ZeusTransformUtils.mapRes(R.style.TextAppearance_Design_CollapsingToolbar_Expanded, "style", "TextAppearance_Design_CollapsingToolbar_Expanded"));
        r8.d(ZeusTransformUtils.mapRes(R.style.TextAppearance_AppCompat_Widget_ActionBar_Title, "style", "TextAppearance_AppCompat_Widget_ActionBar_Title"));
        if (r14.hasValue(ZeusTransformUtils.mapRes(R.styleable.CollapsingToolbarLayout_expandedTitleTextAppearance, "styleable", "CollapsingToolbarLayout_expandedTitleTextAppearance")) == false) goto L18;
        r8.e(r14.getResourceId(ZeusTransformUtils.mapRes(R.styleable.CollapsingToolbarLayout_expandedTitleTextAppearance, "styleable", "CollapsingToolbarLayout_expandedTitleTextAppearance"), 0));
    L18:
        if (r14.hasValue(ZeusTransformUtils.mapRes(R.styleable.CollapsingToolbarLayout_collapsedTitleTextAppearance, "styleable", "CollapsingToolbarLayout_collapsedTitleTextAppearance")) == false) goto L21;
        r8.d(r14.getResourceId(ZeusTransformUtils.mapRes(R.styleable.CollapsingToolbarLayout_collapsedTitleTextAppearance, "styleable", "CollapsingToolbarLayout_collapsedTitleTextAppearance"), 0));
    L21:
        if (r14.hasValue(ZeusTransformUtils.mapRes(R.styleable.CollapsingToolbarLayout_expandedTitleTextColor, "styleable", "CollapsingToolbarLayout_expandedTitleTextColor")) == false) goto L24;
        r8.b(com.google.android.material.g.c.a(r1, r14, ZeusTransformUtils.mapRes(R.styleable.CollapsingToolbarLayout_expandedTitleTextColor, "styleable", "CollapsingToolbarLayout_expandedTitleTextColor")));
    L24:
        if (r14.hasValue(ZeusTransformUtils.mapRes(R.styleable.CollapsingToolbarLayout_collapsedTitleTextColor, "styleable", "CollapsingToolbarLayout_collapsedTitleTextColor")) == false) goto L26;
        r8.a(com.google.android.material.g.c.a(r1, r14, ZeusTransformUtils.mapRes(R.styleable.CollapsingToolbarLayout_collapsedTitleTextColor, "styleable", "CollapsingToolbarLayout_collapsedTitleTextColor")));
    L26:
        this.scrimVisibleHeightTrigger = r14.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.CollapsingToolbarLayout_scrimVisibleHeightTrigger, "styleable", "CollapsingToolbarLayout_scrimVisibleHeightTrigger"), -1);
        if (r14.hasValue(ZeusTransformUtils.mapRes(R.styleable.CollapsingToolbarLayout_maxLines, "styleable", "CollapsingToolbarLayout_maxLines")) == false) goto L30;
        r8.f(r14.getInt(ZeusTransformUtils.mapRes(R.styleable.CollapsingToolbarLayout_maxLines, "styleable", "CollapsingToolbarLayout_maxLines"), 1));
    L30:
        if (r14.hasValue(ZeusTransformUtils.mapRes(R.styleable.CollapsingToolbarLayout_titlePositionInterpolator, "styleable", "CollapsingToolbarLayout_titlePositionInterpolator")) == false) goto L32;
        r8.b(AnimationUtils.loadInterpolator(r1, r14.getResourceId(ZeusTransformUtils.mapRes(R.styleable.CollapsingToolbarLayout_titlePositionInterpolator, "styleable", "CollapsingToolbarLayout_titlePositionInterpolator"), 0)));
    L32:
        this.scrimAnimationDuration = r14.getInt(ZeusTransformUtils.mapRes(R.styleable.CollapsingToolbarLayout_scrimAnimationDuration, "styleable", "CollapsingToolbarLayout_scrimAnimationDuration"), DEFAULT_SCRIM_ANIMATION_DURATION);
        setContentScrim(r14.getDrawable(ZeusTransformUtils.mapRes(R.styleable.CollapsingToolbarLayout_contentScrim, "styleable", "CollapsingToolbarLayout_contentScrim")));
        setStatusBarScrim(r14.getDrawable(ZeusTransformUtils.mapRes(R.styleable.CollapsingToolbarLayout_statusBarScrim, "styleable", "CollapsingToolbarLayout_statusBarScrim")));
        setTitleCollapseMode(r14.getInt(ZeusTransformUtils.mapRes(R.styleable.CollapsingToolbarLayout_titleCollapseMode, "styleable", "CollapsingToolbarLayout_titleCollapseMode"), 0));
        this.toolbarId = r14.getResourceId(ZeusTransformUtils.mapRes(R.styleable.CollapsingToolbarLayout_toolbarId, "styleable", "CollapsingToolbarLayout_toolbarId"), -1);
        this.forceApplySystemWindowInsetTop = r14.getBoolean(ZeusTransformUtils.mapRes(R.styleable.CollapsingToolbarLayout_forceApplySystemWindowInsetTop, "styleable", "CollapsingToolbarLayout_forceApplySystemWindowInsetTop"), false);
        this.extraMultilineHeightEnabled = r14.getBoolean(ZeusTransformUtils.mapRes(R.styleable.CollapsingToolbarLayout_extraMultilineHeightEnabled, "styleable", "CollapsingToolbarLayout_extraMultilineHeightEnabled"), false);
        r14.recycle();
        setWillNotDraw(false);
        ViewCompat.a(this, new AnonymousClass1(this));
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewParent r0 = getParent();
        if (ZeusTransformUtils.instanceOf(r0, AppBarLayout.class) == false) goto L9;
        AppBarLayout r1 = (AppBarLayout) ZeusTransformUtils.preCheckCast(r0, AppBarLayout.class, "com.obric.aiagent.plugin");
        disableLiftOnScrollIfNeeded(r1);
        ViewCompat.b(this, ViewCompat.v(r1));
        if (this.onOffsetChangedListener != null) goto L7;
        this.onOffsetChangedListener = new a(this);
    L7:
        r1.addOnOffsetChangedListener(this.onOffsetChangedListener);
        ViewCompat.u(this);
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        ViewParent r0 = getParent();
        if (this.onOffsetChangedListener != null) goto L5;
    L7:
        super.onDetachedFromWindow();
        return;
    L5:
        if (ZeusTransformUtils.instanceOf(r0, AppBarLayout.class) == false) goto L7;
        ((AppBarLayout) ZeusTransformUtils.preCheckCast(r0, AppBarLayout.class, "com.obric.aiagent.plugin")).removeOnOffsetChangedListener(this.onOffsetChangedListener);
        goto L7
    }

    al onWindowInsetChanged(al r3) {
        if (ViewCompat.v(this) == false) goto L5;
        al r0 = r3;
    L7:
        if (androidx.core.util.d.a(this.lastInsets, r0) == true) goto L10;
        this.lastInsets = r0;
        requestLayout();
    L10:
        return r3.g();
    L5:
        r0 = null;
        goto L7
    }

    @Override // android.view.View
    public void draw(Canvas r7) {
        super.draw(r7);
        ensureToolbar();
        if (this.toolbar != null) goto L10;
        Drawable r0 = this.contentScrim;
        if (r0 == null) goto L10;
        if (this.scrimAlpha <= 0) goto L10;
        r0.mutate().setAlpha(this.scrimAlpha);
        this.contentScrim.draw(r7);
    L10:
        if (this.collapsingTitleEnabled == false) goto L26;
        if (this.drawCollapsingTitle == false) goto L26;
        if (this.toolbar != null) goto L16;
    L24:
        this.collapsingTextHelper.a(r7);
        goto L26
    L16:
        if (this.contentScrim == null) goto L24;
        if (this.scrimAlpha <= 0) goto L24;
        if (isTitleCollapseFadeMode() == false) goto L24;
        if (this.collapsingTextHelper.l() >= this.collapsingTextHelper.k()) goto L24;
        int r1 = r7.save();
        r7.clipRect(this.contentScrim.getBounds(), Region.Op.DIFFERENCE);
        this.collapsingTextHelper.a(r7);
        r7.restoreToCount(r1);
    L26:
        if (this.statusBarScrim != null) goto L28;
        return;
    L28:
        if (this.scrimAlpha <= 0) goto L37;
        al r2 = this.lastInsets;
        if (r2 == null) goto L32;
        int r3 = r2.b();
    L33:
        if (r3 <= 0) goto L38;
        this.statusBarScrim.setBounds(0, -this.currentOffset, getWidth(), r3 - this.currentOffset);
        this.statusBarScrim.mutate().setAlpha(this.scrimAlpha);
        this.statusBarScrim.draw(r7);
        return;
    L38:
        return;
    L32:
        r3 = 0;
        goto L33
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration r1) {
        super.onConfigurationChanged(r1);
        this.collapsingTextHelper.a(r1);
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas r6, View r7, long r8) {
        if (this.contentScrim != null) goto L5;
    L9:
        boolean r0 = false;
    L11:
        if (super.drawChild(r6, r7, r8) == true) goto L16;
        if (r0 == false) goto L15;
        return true;
    L15:
        return false;
    L16:
        return true;
    L5:
        if (this.scrimAlpha <= 0) goto L9;
        if (isToolbarChild(r7) == false) goto L9;
        updateContentScrimBounds(this.contentScrim, r7, getWidth(), getHeight());
        this.contentScrim.mutate().setAlpha(this.scrimAlpha);
        this.contentScrim.draw(r6);
        r0 = true;
        goto L11
    }

    @Override // android.view.View
    public void onSizeChanged(int r1, int r2, int r3, int r4) {
        super.onSizeChanged(r1, r2, r3, r4);
        Drawable r5 = this.contentScrim;
        if (r5 == null) goto L6;
        updateContentScrimBounds(r5, r1, r2);
        return;
    }

    private boolean isTitleCollapseFadeMode() {
        if (this.titleCollapseMode == 1) goto L7;
        return false;
    L7:
        return true;
    }

    private void disableLiftOnScrollIfNeeded(AppBarLayout r1) {
        if (isTitleCollapseFadeMode() == false) goto L6;
        r1.setLiftOnScroll(false);
        return;
    }

    private void updateContentScrimBounds(Drawable r2, int r3, int r4) {
        updateContentScrimBounds(r2, this.toolbar, r3, r4);
    }

    private void updateContentScrimBounds(Drawable r2, View r3, int r4, int r5) {
        if (isTitleCollapseFadeMode() == false) goto L8;
        if (r3 == null) goto L8;
        if (this.collapsingTitleEnabled == false) goto L8;
        r5 = r3.getBottom();
    L8:
        r2.setBounds(0, 0, r4, r5);
    }

    private void ensureToolbar() {
        if (this.refreshToolbar == true) goto L5;
        return;
    L5:
        ViewGroup r0 = null;
        this.toolbar = null;
        this.toolbarDirectChild = null;
        int r1 = this.toolbarId;
        if (r1 == (-1)) goto L11;
        ViewGroup r2 = (ViewGroup) ZeusTransformUtils.preCheckCast(findViewById(r1), ViewGroup.class, "com.obric.aiagent.plugin");
        this.toolbar = r2;
        if (r2 == null) goto L11;
        this.toolbarDirectChild = findDirectChild(r2);
    L11:
        if (this.toolbar != null) goto L19;
        int r3 = getChildCount();
        int r4 = 0;
    L13:
        if (r4 >= r3) goto L18;
        View r5 = getChildAt(r4);
        if (isToolbar(r5) == true) goto L16;
        r4 = r4 + 1;
        goto L13
    L16:
        r0 = (ViewGroup) ZeusTransformUtils.preCheckCast(r5, ViewGroup.class, "com.obric.aiagent.plugin");
    L18:
        this.toolbar = r0;
    L19:
        updateDummyView();
        this.refreshToolbar = false;
    }

    private static boolean isToolbar(View r2) {
        if (ZeusTransformUtils.instanceOf(r2, Toolbar.class) == false) goto L5;
    L10:
        return true;
    L5:
        if (Build.VERSION.SDK_INT >= 21) goto L7;
    L9:
        return false;
    L7:
        if (ZeusTransformUtils.instanceOf(r2, android.widget.Toolbar.class) == false) goto L9;
        goto L9
    }

    private boolean isToolbarChild(View r4) {
        View r0 = this.toolbarDirectChild;
        if (r0 == null) goto L9;
        if (r0 == this) goto L9;
        if (r4 != r0) goto L12;
        return true;
    L12:
        return false;
    L9:
        if (r4 != this.toolbar) goto L12;
        return true;
    }

    private View findDirectChild(View r3) {
        ViewParent r0 = r3.getParent();
    L3:
        if (r0 == this) goto L9;
        if (r0 == null) goto L9;
        if (ZeusTransformUtils.instanceOf(r0, View.class) == false) goto L8;
        r3 = (View) ZeusTransformUtils.preCheckCast(r0, View.class, "com.obric.aiagent.plugin");
    L8:
        r0 = r0.getParent();
    L9:
        return r3;
    }

    private void updateDummyView() {
        if (this.collapsingTitleEnabled == true) goto L10;
        View r0 = this.dummyView;
        if (r0 == null) goto L10;
        ViewParent r1 = r0.getParent();
        if (ZeusTransformUtils.instanceOf(r1, ViewGroup.class) == false) goto L10;
        ((ViewGroup) ZeusTransformUtils.preCheckCast(r1, ViewGroup.class, "com.obric.aiagent.plugin")).removeView(this.dummyView);
    L10:
        if (this.collapsingTitleEnabled == true) goto L12;
        return;
    L12:
        if (this.toolbar != null) goto L14;
        return;
    L14:
        if (this.dummyView != null) goto L17;
        this.dummyView = new View((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
    L17:
        if (this.dummyView.getParent() != null) goto L22;
        this.toolbar.addView(this.dummyView, -1, -1);
        return;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int r9, int r10) {
        ensureToolbar();
        super.onMeasure(r9, r10);
        int r11 = View.MeasureSpec.getMode(r10);
        al r0 = this.lastInsets;
        if (r0 == null) goto L5;
        int r1 = r0.b();
    L7:
        if (r11 != 0) goto L9;
    L10:
        if (r1 <= 0) goto L13;
        this.topInsetApplied = r1;
        super.onMeasure(r9, View.MeasureSpec.makeMeasureSpec(getMeasuredHeight() + r1, 1073741824));
    L13:
        if (this.extraMultilineHeightEnabled == true) goto L15;
    L19:
        ViewGroup r12 = this.toolbar;
        if (r12 == null) goto L28;
        View r13 = this.toolbarDirectChild;
        if (r13 == null) goto L26;
        if (r13 == this) goto L26;
        setMinimumHeight(getHeightWithMargins(r13));
        return;
    L26:
        setMinimumHeight(getHeightWithMargins(r12));
        return;
    L28:
        return;
    L15:
        if (this.collapsingTextHelper.q() <= 1) goto L19;
        updateTitleFromToolbarIfNeeded();
        updateTextBounds(0, 0, getMeasuredWidth(), getMeasuredHeight(), true);
        int r14 = this.collapsingTextHelper.s();
        if (r14 <= 1) goto L19;
        this.extraMultilineHeight = Math.round(this.collapsingTextHelper.c()) * (r14 - 1);
        super.onMeasure(r9, View.MeasureSpec.makeMeasureSpec(getMeasuredHeight() + this.extraMultilineHeight, 1073741824));
        goto L19
    L9:
        if (this.forceApplySystemWindowInsetTop == false) goto L13;
    L5:
        r1 = 0;
        goto L7
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean r9, int r10, int r11, int r12, int r13) {
        super.onLayout(r9, r10, r11, r12, r13);
        al r14 = this.lastInsets;
        int r0 = 0;
        if (r14 == null) goto L12;
        int r15 = r14.b();
        int r1 = getChildCount();
        int r2 = 0;
    L5:
        if (r2 >= r1) goto L12;
        View r3 = getChildAt(r2);
        if (ViewCompat.v(r3) == true) goto L11;
        if (r3.getTop() >= r15) goto L11;
        ViewCompat.f(r3, r15);
    L11:
        r2 = r2 + 1;
    L12:
        int r16 = getChildCount();
        int r4 = 0;
    L13:
        if (r4 >= r16) goto L15;
        getViewOffsetHelper(getChildAt(r4)).a();
        r4 = r4 + 1;
        goto L13
    L15:
        updateTextBounds(r10, r11, r12, r13, false);
        updateTitleFromToolbarIfNeeded();
        updateScrimVisibility();
        int r17 = getChildCount();
    L16:
        if (r0 >= r17) goto L18;
        getViewOffsetHelper(getChildAt(r0)).b();
        r0 = r0 + 1;
        goto L16
    }

    private void updateTextBounds(int r6, int r7, int r8, int r9, boolean r10) {
        if (this.collapsingTitleEnabled == false) goto L28;
        View r0 = this.dummyView;
        if (r0 == null) goto L29;
        boolean r1 = false;
        if (ViewCompat.I(r0) == true) goto L9;
    L11:
        boolean r2 = false;
    L12:
        this.drawCollapsingTitle = r2;
        if (r2 == true) goto L16;
        if (r10 == true) goto L16;
        return;
    L16:
        if (ViewCompat.i(this) != 1) goto L18;
        r1 = true;
    L18:
        updateCollapsedBounds(r1);
        com.google.android.material.internal.b r3 = this.collapsingTextHelper;
        if (r1 == false) goto L21;
        int r4 = this.expandedMarginEnd;
    L22:
        int r5 = this.tmpRect.top + this.expandedMarginTop;
        int r11 = r8 - r6;
        if (r1 == false) goto L25;
        int r12 = this.expandedMarginStart;
    L26:
        r3.a(r4, r5, r11 - r12, (r9 - r7) - this.expandedMarginBottom);
        this.collapsingTextHelper.c(r10);
        return;
    L25:
        r12 = this.expandedMarginEnd;
        goto L26
    L21:
        r4 = this.expandedMarginStart;
        goto L22
    L9:
        if (this.dummyView.getVisibility() != 0) goto L11;
        r2 = true;
        goto L12
    L29:
        return;
    }

    private void updateTitleFromToolbarIfNeeded() {
        if (this.toolbar != null) goto L5;
        return;
    L5:
        if (this.collapsingTitleEnabled == true) goto L7;
        return;
    L7:
        if (TextUtils.isEmpty(this.collapsingTextHelper.p()) == false) goto L12;
        setTitle(getToolbarTitle(this.toolbar));
        return;
    }

    private void updateCollapsedBounds(boolean r9) {
        View r0 = this.toolbarDirectChild;
        if (r0 != null) goto L6;
        r0 = this.toolbar;
    L6:
        int r1 = getMaxOffsetForPinChild(r0);
        com.google.android.material.internal.d.b(this, this.dummyView, this.tmpRect);
        int r3 = 0;
        if (ZeusTransformUtils.instanceOf(this.toolbar, Toolbar.class) == false) goto L10;
        Toolbar r2 = (Toolbar) ZeusTransformUtils.preCheckCast(this.toolbar, Toolbar.class, "com.obric.aiagent.plugin");
        r3 = r2.getTitleMarginStart();
        int r4 = r2.getTitleMarginEnd();
        int r5 = r2.getTitleMarginTop();
        int r6 = r2.getTitleMarginBottom();
    L15:
        com.google.android.material.internal.b r7 = this.collapsingTextHelper;
        int r8 = this.tmpRect.left;
        if (r9 == false) goto L18;
        int r10 = r4;
    L19:
        int r11 = r8 + r10;
        int r12 = (this.tmpRect.top + r1) + r5;
        int r13 = this.tmpRect.right;
        if (r9 == true) goto L23;
        r3 = r4;
    L23:
        r7.b(r11, r12, r13 - r3, (this.tmpRect.bottom + r1) - r6);
        return;
    L18:
        r10 = r3;
        goto L19
    L10:
        if (Build.VERSION.SDK_INT >= 24) goto L12;
    L14:
        r6 = 0;
        r4 = 0;
        r5 = 0;
        goto L15
    L12:
        if (ZeusTransformUtils.instanceOf(this.toolbar, android.widget.Toolbar.class) == false) goto L14;
        android.widget.Toolbar r14 = (android.widget.Toolbar) ZeusTransformUtils.preCheckCast(this.toolbar, android.widget.Toolbar.class, "com.obric.aiagent.plugin");
        r3 = r14.getTitleMarginStart();
        r4 = r14.getTitleMarginEnd();
        r5 = r14.getTitleMarginTop();
        r6 = r14.getTitleMarginBottom();
        goto L15
    }

    private static CharSequence getToolbarTitle(View r3) {
        if (ZeusTransformUtils.instanceOf(r3, Toolbar.class) == false) goto L7;
        return ((Toolbar) ZeusTransformUtils.preCheckCast(r3, Toolbar.class, "com.obric.aiagent.plugin")).getTitle();
    L7:
        if (Build.VERSION.SDK_INT >= 21) goto L9;
        return null;
    L9:
        if (ZeusTransformUtils.instanceOf(r3, android.widget.Toolbar.class) == true) goto L11;
        return null;
    L11:
        return ((android.widget.Toolbar) ZeusTransformUtils.preCheckCast(r3, android.widget.Toolbar.class, "com.obric.aiagent.plugin")).getTitle();
    }

    private static int getHeightWithMargins(View r3) {
        ViewGroup.LayoutParams r0 = r3.getLayoutParams();
        if (ZeusTransformUtils.instanceOf(r0, ViewGroup.MarginLayoutParams.class) == false) goto L7;
        ViewGroup.MarginLayoutParams r1 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r0, ViewGroup.MarginLayoutParams.class, "com.obric.aiagent.plugin");
        return (r3.getMeasuredHeight() + r1.topMargin) + r1.bottomMargin;
    L7:
        return r3.getMeasuredHeight();
    }

    static d getViewOffsetHelper(View r5) {
        d r0 = (d) ZeusTransformUtils.preCheckCast(r5.getTag(ZeusTransformUtils.mapRes(R.id.view_offset_helper, DbHelper.COL_ID, "view_offset_helper")), d.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L6;
        d r1 = new d(r5);
        r5.setTag(ZeusTransformUtils.mapRes(R.id.view_offset_helper, DbHelper.COL_ID, "view_offset_helper"), r1);
        return r1;
    L6:
        return r0;
    }

    public void setTitle(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
        this.collapsingTextHelper.a(r4);
        updateContentDescriptionFromTitle();
    }

    public CharSequence getTitle() {
        if (this.collapsingTitleEnabled == true) goto L7;
        return null;
    L7:
        return this.collapsingTextHelper.p();
    }

    public void setTitleCollapseMode(int r4) {
        this.titleCollapseMode = r4;
        boolean r5 = isTitleCollapseFadeMode();
        this.collapsingTextHelper.a(r5);
        ViewParent r0 = getParent();
        if (ZeusTransformUtils.instanceOf(r0, AppBarLayout.class) == false) goto L5;
        disableLiftOnScrollIfNeeded((AppBarLayout) ZeusTransformUtils.preCheckCast(r0, AppBarLayout.class, "com.obric.aiagent.plugin"));
    L5:
        if (r5 == true) goto L7;
        return;
    L7:
        if (this.contentScrim != null) goto L11;
        float r6 = ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin").getDimension(ZeusTransformUtils.mapRes(R.dimen.design_appbar_elevation, "dimen", "design_appbar_elevation"));
        setContentScrimColor(this.elevationOverlayProvider.a(r6));
        return;
    }

    public int getTitleCollapseMode() {
        return this.titleCollapseMode;
    }

    public void setTitleEnabled(boolean r2) {
        if (r2 == this.collapsingTitleEnabled) goto L6;
        this.collapsingTitleEnabled = r2;
        updateContentDescriptionFromTitle();
        updateDummyView();
        requestLayout();
        return;
    }

    public boolean isTitleEnabled() {
        return this.collapsingTitleEnabled;
    }

    public void setScrimsShown(boolean r2) {
        if (ViewCompat.F(this) == true) goto L5;
    L7:
        boolean r0 = false;
    L8:
        setScrimsShown(r2, r0);
        return;
    L5:
        if (isInEditMode() == true) goto L7;
        r0 = true;
        goto L8
    }

    public void setScrimsShown(boolean r3, boolean r4) {
        if (this.scrimsAreShown == r3) goto L16;
        int r0 = 255;
        if (r4 == false) goto L10;
        if (r3 == true) goto L9;
        r0 = 0;
    L9:
        animateScrim(r0);
    L14:
        this.scrimsAreShown = r3;
        return;
    L10:
        if (r3 == true) goto L13;
        r0 = 0;
    L13:
        setScrimAlpha(r0);
        goto L14
    }

    private void animateScrim(int r5) {
        ensureToolbar();
        ValueAnimator r0 = this.scrimAnimator;
        if (r0 != null) goto L10;
        ValueAnimator r1 = new ValueAnimator();
        this.scrimAnimator = r1;
        if (r5 <= this.scrimAlpha) goto L7;
        TimeInterpolator r2 = com.google.android.material.animation.a.f13144c;
    L8:
        r1.setInterpolator(r2);
        this.scrimAnimator.addUpdateListener(new AnonymousClass2(this));
    L12:
        this.scrimAnimator.setDuration(this.scrimAnimationDuration);
        this.scrimAnimator.setIntValues(new int[]{this.scrimAlpha, r5});
        this.scrimAnimator.start();
        return;
    L7:
        r2 = com.google.android.material.animation.a.f13145d;
        goto L8
    L10:
        if (r0.isRunning() == false) goto L12;
        this.scrimAnimator.cancel();
        goto L12
    }

    void setScrimAlpha(int r2) {
        if (r2 != this.scrimAlpha) goto L5;
        return;
    L5:
        if (this.contentScrim == null) goto L9;
        ViewGroup r0 = this.toolbar;
        if (r0 == null) goto L9;
        ViewCompat.f(r0);
    L9:
        this.scrimAlpha = r2;
        ViewCompat.f(this);
    }

    int getScrimAlpha() {
        return this.scrimAlpha;
    }

    public void setContentScrim(Drawable r3) {
        Drawable r0 = this.contentScrim;
        if (r0 == r3) goto L14;
        Drawable r1 = null;
        if (r0 == null) goto L7;
        r0.setCallback(null);
    L7:
        if (r3 == null) goto L9;
        r1 = r3.mutate();
    L9:
        this.contentScrim = r1;
        if (r1 == null) goto L12;
        updateContentScrimBounds(r1, getWidth(), getHeight());
        this.contentScrim.setCallback(this);
        this.contentScrim.setAlpha(this.scrimAlpha);
    L12:
        ViewCompat.f(this);
        return;
    }

    public void setContentScrimColor(int r2) {
        setContentScrim(new ColorDrawable(r2));
    }

    public void setContentScrimResource(int r4) {
        setContentScrim(androidx.core.content.a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r4));
    }

    public Drawable getContentScrim() {
        return this.contentScrim;
    }

    public void setStatusBarScrim(Drawable r3) {
        Drawable r0 = this.statusBarScrim;
        if (r0 == r3) goto L21;
        Drawable r1 = null;
        if (r0 == null) goto L7;
        r0.setCallback(null);
    L7:
        if (r3 == null) goto L9;
        r1 = r3.mutate();
    L9:
        this.statusBarScrim = r1;
        if (r1 != null) goto L12;
    L19:
        ViewCompat.f(this);
        return;
    L12:
        if (r1.isStateful() == false) goto L14;
        this.statusBarScrim.setState(getDrawableState());
    L14:
        androidx.core.graphics.drawable.a.b(this.statusBarScrim, ViewCompat.i(this));
        Drawable r4 = this.statusBarScrim;
        if (getVisibility() != 0) goto L17;
        boolean r2 = true;
    L18:
        r4.setVisible(r2, false);
        this.statusBarScrim.setCallback(this);
        this.statusBarScrim.setAlpha(this.scrimAlpha);
        goto L19
    L17:
        r2 = false;
        goto L18
    }

    @Override // android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        int[] r0 = getDrawableState();
        Drawable r1 = this.statusBarScrim;
        boolean r2 = false;
        if (r1 != null) goto L5;
    L7:
        Drawable r3 = this.contentScrim;
        if (r3 != null) goto L10;
    L12:
        com.google.android.material.internal.b r4 = this.collapsingTextHelper;
        if (r4 == null) goto L15;
        r2 = r2 | r4.a(r0);
    L15:
        if (r2 == false) goto L18;
        invalidate();
        return;
    L18:
        return;
    L10:
        if (r3.isStateful() == false) goto L12;
        r2 = r2 | r3.setState(r0);
        goto L12
    L5:
        if (r1.isStateful() == false) goto L7;
        r2 = false | r1.setState(r0);
        goto L7
    }

    @Override // android.view.View
    public boolean verifyDrawable(Drawable r2) {
        if (super.verifyDrawable(r2) == false) goto L5;
    L10:
        return true;
    L5:
        if (r2 == this.contentScrim) goto L10;
        if (r2 == this.statusBarScrim) goto L10;
        return false;
    }

    @Override // android.view.View
    public void setVisibility(int r3) {
        super.setVisibility(r3);
        if (r3 != 0) goto L5;
        boolean r4 = true;
    L6:
        Drawable r1 = this.statusBarScrim;
        if (r1 != null) goto L9;
    L11:
        Drawable r2 = this.contentScrim;
        if (r2 != null) goto L14;
        return;
    L14:
        if (r2.isVisible() == r4) goto L18;
        this.contentScrim.setVisible(r4, false);
        return;
    L18:
        return;
    L9:
        if (r1.isVisible() == r4) goto L11;
        this.statusBarScrim.setVisible(r4, false);
        goto L11
    L5:
        r4 = false;
        goto L6
    }

    public void setStatusBarScrimColor(int r2) {
        setStatusBarScrim(new ColorDrawable(r2));
    }

    public void setStatusBarScrimResource(int r4) {
        setStatusBarScrim(androidx.core.content.a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r4));
    }

    public Drawable getStatusBarScrim() {
        return this.statusBarScrim;
    }

    public void setCollapsedTitleTextAppearance(int r1) {
        this.collapsingTextHelper.d(r1);
    }

    public void setCollapsedTitleTextColor(int r1) {
        setCollapsedTitleTextColor(ColorStateList.valueOf(r1));
    }

    public void setCollapsedTitleTextColor(ColorStateList r1) {
        this.collapsingTextHelper.a(r1);
    }

    public void setCollapsedTitleGravity(int r1) {
        this.collapsingTextHelper.c(r1);
    }

    public int getCollapsedTitleGravity() {
        return this.collapsingTextHelper.g();
    }

    public void setExpandedTitleTextAppearance(int r1) {
        this.collapsingTextHelper.e(r1);
    }

    public void setExpandedTitleColor(int r1) {
        setExpandedTitleTextColor(ColorStateList.valueOf(r1));
    }

    public void setExpandedTitleTextColor(ColorStateList r1) {
        this.collapsingTextHelper.b(r1);
    }

    public void setExpandedTitleGravity(int r1) {
        this.collapsingTextHelper.b(r1);
    }

    public int getExpandedTitleGravity() {
        return this.collapsingTextHelper.f();
    }

    public void setCollapsedTitleTypeface(Typeface r1) {
        this.collapsingTextHelper.a(r1);
    }

    public Typeface getCollapsedTitleTypeface() {
        return this.collapsingTextHelper.h();
    }

    public void setExpandedTitleTypeface(Typeface r1) {
        this.collapsingTextHelper.b(r1);
    }

    public Typeface getExpandedTitleTypeface() {
        return this.collapsingTextHelper.i();
    }

    public void setExpandedTitleMargin(int r1, int r2, int r3, int r4) {
        this.expandedMarginStart = r1;
        this.expandedMarginTop = r2;
        this.expandedMarginEnd = r3;
        this.expandedMarginBottom = r4;
        requestLayout();
    }

    public int getExpandedTitleMarginStart() {
        return this.expandedMarginStart;
    }

    public void setExpandedTitleMarginStart(int r1) {
        this.expandedMarginStart = r1;
        requestLayout();
    }

    public int getExpandedTitleMarginTop() {
        return this.expandedMarginTop;
    }

    public void setExpandedTitleMarginTop(int r1) {
        this.expandedMarginTop = r1;
        requestLayout();
    }

    public int getExpandedTitleMarginEnd() {
        return this.expandedMarginEnd;
    }

    public void setExpandedTitleMarginEnd(int r1) {
        this.expandedMarginEnd = r1;
        requestLayout();
    }

    public int getExpandedTitleMarginBottom() {
        return this.expandedMarginBottom;
    }

    public void setExpandedTitleMarginBottom(int r1) {
        this.expandedMarginBottom = r1;
        requestLayout();
    }

    public void setMaxLines(int r1) {
        this.collapsingTextHelper.f(r1);
    }

    public int getMaxLines() {
        return this.collapsingTextHelper.q();
    }

    public int getLineCount() {
        return this.collapsingTextHelper.r();
    }

    public void setLineSpacingAdd(float r1) {
        this.collapsingTextHelper.e(r1);
    }

    public float getLineSpacingAdd() {
        return this.collapsingTextHelper.t();
    }

    public void setLineSpacingMultiplier(float r1) {
        this.collapsingTextHelper.f(r1);
    }

    public float getLineSpacingMultiplier() {
        return this.collapsingTextHelper.u();
    }

    public void setHyphenationFrequency(int r1) {
        this.collapsingTextHelper.g(r1);
    }

    public int getHyphenationFrequency() {
        return this.collapsingTextHelper.v();
    }

    public void setRtlTextDirectionHeuristicsEnabled(boolean r1) {
        this.collapsingTextHelper.b(r1);
    }

    public boolean isRtlTextDirectionHeuristicsEnabled() {
        return this.collapsingTextHelper.m();
    }

    public void setForceApplySystemWindowInsetTop(boolean r1) {
        this.forceApplySystemWindowInsetTop = r1;
    }

    public boolean isForceApplySystemWindowInsetTop() {
        return this.forceApplySystemWindowInsetTop;
    }

    public void setExtraMultilineHeightEnabled(boolean r1) {
        this.extraMultilineHeightEnabled = r1;
    }

    public boolean isExtraMultilineHeightEnabled() {
        return this.extraMultilineHeightEnabled;
    }

    public void setScrimVisibleHeightTrigger(int r2) {
        if (this.scrimVisibleHeightTrigger == r2) goto L6;
        this.scrimVisibleHeightTrigger = r2;
        updateScrimVisibility();
        return;
    }

    public int getScrimVisibleHeightTrigger() {
        int r0 = this.scrimVisibleHeightTrigger;
        if (r0 >= 0) goto L5;
        al r1 = this.lastInsets;
        if (r1 == null) goto L9;
        int r2 = r1.b();
    L10:
        int r3 = ViewCompat.o(this);
        if (r3 <= 0) goto L15;
        return Math.min((r3 * 2) + r2, getHeight());
    L15:
        return getHeight() / 3;
    L9:
        r2 = 0;
        goto L10
    L5:
        return (r0 + this.topInsetApplied) + this.extraMultilineHeight;
    }

    public void setTitlePositionInterpolator(TimeInterpolator r3) {
        TimeInterpolator r4 = (TimeInterpolator) ZeusTransformUtils.wrapperContextForParams(r3, TimeInterpolator.class, "com.obric.aiagent.plugin");
        this.collapsingTextHelper.b(r4);
    }

    public TimeInterpolator getTitlePositionInterpolator() {
        return this.collapsingTextHelper.a();
    }

    public void setScrimAnimationDuration(long r1) {
        this.scrimAnimationDuration = r1;
    }

    public long getScrimAnimationDuration() {
        return this.scrimAnimationDuration;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams r1) {
        return ZeusTransformUtils.instanceOf(r1, LayoutParams.class);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -1);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public FrameLayout.LayoutParams generateLayoutParams(AttributeSet r4) {
        AttributeSet r5 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin");
        return new LayoutParams((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r5);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public FrameLayout.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r1) {
        return new LayoutParams(r1);
    }

    final void updateScrimVisibility() {
        if (this.contentScrim != null) goto L7;
        if (this.statusBarScrim != null) goto L7;
        return;
    L7:
        if ((getHeight() + this.currentOffset) >= getScrimVisibleHeightTrigger()) goto L9;
        boolean r0 = true;
    L10:
        setScrimsShown(r0);
        return;
    L9:
        r0 = false;
        goto L10
    }

    final int getMaxOffsetForPinChild(View r5) {
        d r0 = getViewOffsetHelper(r5);
        LayoutParams r1 = (LayoutParams) ZeusTransformUtils.preCheckCast(r5.getLayoutParams(), LayoutParams.class, "com.obric.aiagent.plugin");
        return ((getHeight() - r0.d()) - r5.getHeight()) - r1.bottomMargin;
    }

    private void updateContentDescriptionFromTitle() {
        setContentDescription(getTitle());
    }
}
