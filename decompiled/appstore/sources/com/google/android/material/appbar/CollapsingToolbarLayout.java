package com.google.android.material.appbar;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.appcompat.R$style;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.core.util.b;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.elevation.ElevationOverlayProvider;
import com.google.android.material.internal.CollapsingTextHelper;
import com.google.android.material.internal.DescendantOffsetUtils;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import com.google.common.primitives.Ints;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import p.a;

/* JADX INFO: loaded from: classes3.dex */
public class CollapsingToolbarLayout extends FrameLayout {
    private static final int DEFAULT_SCRIM_ANIMATION_DURATION = 600;
    private static final int DEF_STYLE_RES = 0;
    public static final int TITLE_COLLAPSE_MODE_FADE = 1;
    public static final int TITLE_COLLAPSE_MODE_SCALE = 0;

    @NonNull
    final CollapsingTextHelper collapsingTextHelper;
    private boolean collapsingTitleEnabled;

    @Nullable
    private Drawable contentScrim;
    int currentOffset;
    private boolean drawCollapsingTitle;
    private View dummyView;

    @NonNull
    final ElevationOverlayProvider elevationOverlayProvider;
    private int expandedMarginBottom;
    private int expandedMarginEnd;
    private int expandedMarginStart;
    private int expandedMarginTop;
    private int extraMultilineHeight;
    private boolean extraMultilineHeightEnabled;
    private boolean forceApplySystemWindowInsetTop;

    @Nullable
    WindowInsetsCompat lastInsets;
    private AppBarLayout.OnOffsetChangedListener onOffsetChangedListener;
    private boolean refreshToolbar;
    private int scrimAlpha;
    private long scrimAnimationDuration;
    private ValueAnimator scrimAnimator;
    private int scrimVisibleHeightTrigger;
    private boolean scrimsAreShown;

    @Nullable
    Drawable statusBarScrim;
    private int titleCollapseMode;
    private final Rect tmpRect;

    @Nullable
    private ViewGroup toolbar;

    @Nullable
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

        public LayoutParams(Context r10, AttributeSet r11) {
            super(r10, r11);
            this.collapseMode = 0;
            this.parallaxMult = DEFAULT_PARALLAX_MULTIPLIER;
            TypedArray r12 = r10.obtainStyledAttributes(r11, R.styleable.CollapsingToolbarLayout_Layout);
            this.collapseMode = r12.getInt(R.styleable.CollapsingToolbarLayout_Layout_layout_collapseMode, 0);
            setParallaxMultiplier(r12.getFloat(R.styleable.CollapsingToolbarLayout_Layout_layout_collapseParallaxMultiplier, DEFAULT_PARALLAX_MULTIPLIER));
            r12.recycle();
        }

        public int getCollapseMode() {
            return this.collapseMode;
        }

        public float getParallaxMultiplier() {
            return this.parallaxMult;
        }

        public void setCollapseMode(int r10) {
            this.collapseMode = r10;
        }

        public void setParallaxMultiplier(float r10) {
            this.parallaxMult = r10;
        }

        public LayoutParams(int r10, int r11) {
            super(r10, r11);
            this.collapseMode = 0;
            this.parallaxMult = DEFAULT_PARALLAX_MULTIPLIER;
        }

        public LayoutParams(int r10, int r11, int r12) {
            super(r10, r11, r12);
            this.collapseMode = 0;
            this.parallaxMult = DEFAULT_PARALLAX_MULTIPLIER;
        }

        public LayoutParams(@NonNull ViewGroup.LayoutParams r10) {
            super(r10);
            this.collapseMode = 0;
            this.parallaxMult = DEFAULT_PARALLAX_MULTIPLIER;
        }

        public LayoutParams(@NonNull ViewGroup.MarginLayoutParams r10) {
            super(r10);
            this.collapseMode = 0;
            this.parallaxMult = DEFAULT_PARALLAX_MULTIPLIER;
        }

        @RequiresApi(19)
        public LayoutParams(@NonNull FrameLayout.LayoutParams r10) {
            super(r10);
            this.collapseMode = 0;
            this.parallaxMult = DEFAULT_PARALLAX_MULTIPLIER;
        }
    }

    public class OffsetUpdateListener implements AppBarLayout.OnOffsetChangedListener {
        final /* synthetic */ CollapsingToolbarLayout this$0;

        public OffsetUpdateListener(CollapsingToolbarLayout r10) {
            this.this$0 = r10;
        }

        @Override // com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener, com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
        public void onOffsetChanged(AppBarLayout r10, int r11) {
            CollapsingToolbarLayout r12 = this.this$0;
            r12.currentOffset = r11;
            WindowInsetsCompat r13 = r12.lastInsets;
            if (r13 == null) goto L5;
            int r14 = r13.m();
        L6:
            int r15 = this.this$0.getChildCount();
            int r16 = 0;
        L7:
            if (r16 >= r15) goto L16;
            View r17 = this.this$0.getChildAt(r16);
            LayoutParams r18 = (LayoutParams) r17.getLayoutParams();
            ViewOffsetHelper r19 = CollapsingToolbarLayout.getViewOffsetHelper(r17);
            int r20 = r18.collapseMode;
            if (r20 != 1) goto L11;
            r19.setTopAndBottomOffset(a.b(-r11, 0, this.this$0.getMaxOffsetForPinChild(r17)));
        L15:
            r16 = r16 + 1;
            goto L7
        L11:
            if (r20 != 2) goto L15;
            r19.setTopAndBottomOffset(Math.round((-r11) * r18.parallaxMult));
            goto L15
        L16:
            this.this$0.updateScrimVisibility();
            CollapsingToolbarLayout r21 = this.this$0;
            if (r21.statusBarScrim == null) goto L20;
            if (r14 <= 0) goto L20;
            ViewCompat.g0(r21);
        L20:
            int r22 = this.this$0.getHeight();
            int r23 = (r22 - ViewCompat.B(this.this$0)) - r14;
            float r24 = r23;
            this.this$0.collapsingTextHelper.setFadeModeStartFraction(Math.min(1.0f, (r22 - this.this$0.getScrimVisibleHeightTrigger()) / r24));
            CollapsingToolbarLayout r25 = this.this$0;
            r25.collapsingTextHelper.setCurrentOffsetY(r25.currentOffset + r23);
            this.this$0.collapsingTextHelper.setExpansionFraction(Math.abs(r11) / r24);
            return;
        L5:
            r14 = 0;
            goto L6
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface TitleCollapseMode {
    }

    static {
        DEF_STYLE_RES = R.style.Widget_Design_CollapsingToolbar;
    }

    public CollapsingToolbarLayout(@NonNull Context r10) {
        this(r10, null);
    }

    private void animateScrim(int r10) {
        ensureToolbar();
        ValueAnimator r11 = this.scrimAnimator;
        if (r11 != null) goto L10;
        ValueAnimator r12 = new ValueAnimator();
        this.scrimAnimator = r12;
        r12.setDuration(this.scrimAnimationDuration);
        ValueAnimator r13 = this.scrimAnimator;
        if (r10 <= this.scrimAlpha) goto L7;
        TimeInterpolator r14 = AnimationUtils.FAST_OUT_LINEAR_IN_INTERPOLATOR;
    L8:
        r13.setInterpolator(r14);
        this.scrimAnimator.addUpdateListener(new AnonymousClass2(this));
    L12:
        this.scrimAnimator.setIntValues(new int[]{this.scrimAlpha, r10});
        this.scrimAnimator.start();
        return;
    L7:
        r14 = AnimationUtils.LINEAR_OUT_SLOW_IN_INTERPOLATOR;
        goto L8
    L10:
        if (r11.isRunning() == false) goto L12;
        this.scrimAnimator.cancel();
        goto L12
    }

    private void disableLiftOnScrollIfNeeded(AppBarLayout r10) {
        if (isTitleCollapseFadeMode() == false) goto L6;
        r10.setLiftOnScroll(false);
        return;
    }

    private void ensureToolbar() {
        if (this.refreshToolbar == true) goto L5;
        return;
    L5:
        ViewGroup r10 = null;
        this.toolbar = null;
        this.toolbarDirectChild = null;
        int r11 = this.toolbarId;
        if (r11 == (-1)) goto L11;
        ViewGroup r12 = (ViewGroup) findViewById(r11);
        this.toolbar = r12;
        if (r12 == null) goto L11;
        this.toolbarDirectChild = findDirectChild(r12);
    L11:
        if (this.toolbar != null) goto L19;
        int r13 = getChildCount();
        int r14 = 0;
    L13:
        if (r14 >= r13) goto L18;
        View r15 = getChildAt(r14);
        if (isToolbar(r15) == true) goto L16;
        r14 = r14 + 1;
        goto L13
    L16:
        r10 = (ViewGroup) r15;
    L18:
        this.toolbar = r10;
    L19:
        updateDummyView();
        this.refreshToolbar = false;
    }

    @NonNull
    private View findDirectChild(@NonNull View r10) {
        ViewParent r11 = r10.getParent();
    L3:
        if (r11 == this) goto L9;
        if (r11 == null) goto L9;
        if ((r11 instanceof View) == false) goto L8;
        r10 = r11;
    L8:
        r11 = r11.getParent();
    L9:
        return r10;
    }

    private static int getHeightWithMargins(@NonNull View r10) {
        ViewGroup.LayoutParams r11 = r10.getLayoutParams();
        if ((r11 instanceof ViewGroup.MarginLayoutParams) == false) goto L7;
        ViewGroup.MarginLayoutParams r12 = (ViewGroup.MarginLayoutParams) r11;
        return (r10.getMeasuredHeight() + r12.topMargin) + r12.bottomMargin;
    L7:
        return r10.getMeasuredHeight();
    }

    private static CharSequence getToolbarTitle(View r10) {
        if ((r10 instanceof Toolbar) == false) goto L7;
        return ((Toolbar) r10).getTitle();
    L7:
        if ((r10 instanceof android.widget.Toolbar) == true) goto L9;
        return null;
    L9:
        return ((android.widget.Toolbar) r10).getTitle();
    }

    @NonNull
    public static ViewOffsetHelper getViewOffsetHelper(@NonNull View r10) {
        int r11 = R.id.view_offset_helper;
        ViewOffsetHelper r12 = (ViewOffsetHelper) r10.getTag(r11);
        if (r12 != null) goto L6;
        ViewOffsetHelper r13 = new ViewOffsetHelper(r10);
        r10.setTag(r11, r13);
        return r13;
    L6:
        return r12;
    }

    private boolean isTitleCollapseFadeMode() {
        if (this.titleCollapseMode == 1) goto L7;
        return false;
    L7:
        return true;
    }

    private static boolean isToolbar(View r10) {
        if ((r10 instanceof Toolbar) == false) goto L5;
    L8:
        return true;
    L5:
        if ((r10 instanceof android.widget.Toolbar) == true) goto L8;
        return false;
    }

    private boolean isToolbarChild(View r10) {
        View r11 = this.toolbarDirectChild;
        if (r11 == null) goto L9;
        if (r11 == this) goto L9;
        if (r10 == r11) goto L12;
        return false;
    L12:
        return true;
    L9:
        if (r10 == this.toolbar) goto L12;
        return false;
    }

    private void updateCollapsedBounds(boolean r10) {
        View r11 = this.toolbarDirectChild;
        if (r11 != null) goto L6;
        r11 = this.toolbar;
    L6:
        int r12 = getMaxOffsetForPinChild(r11);
        DescendantOffsetUtils.getDescendantRect(this, this.dummyView, this.tmpRect);
        ViewGroup r13 = this.toolbar;
        if ((r13 instanceof Toolbar) == false) goto L10;
        Toolbar r14 = (Toolbar) r13;
        int r15 = r14.getTitleMarginStart();
        int r16 = r14.getTitleMarginEnd();
        int r17 = r14.getTitleMarginTop();
        int r18 = r14.getTitleMarginBottom();
    L13:
        CollapsingTextHelper r19 = this.collapsingTextHelper;
        Rect r20 = this.tmpRect;
        int r21 = r20.left;
        if (r10 == false) goto L16;
        int r22 = r16;
    L17:
        int r23 = r21 + r22;
        int r24 = (r20.top + r12) + r17;
        int r25 = r20.right;
        if (r10 == true) goto L21;
        r15 = r16;
    L21:
        r19.setCollapsedBounds(r23, r24, r25 - r15, (r20.bottom + r12) - r18);
        return;
    L16:
        r22 = r15;
        goto L17
    L10:
        if ((r13 instanceof android.widget.Toolbar) == false) goto L12;
        android.widget.Toolbar r26 = (android.widget.Toolbar) r13;
        r15 = r26.getTitleMarginStart();
        r16 = r26.getTitleMarginEnd();
        r17 = r26.getTitleMarginTop();
        r18 = r26.getTitleMarginBottom();
        goto L13
    L12:
        r15 = 0;
        r18 = 0;
        r16 = 0;
        r17 = 0;
        goto L13
    }

    private void updateContentDescriptionFromTitle() {
        setContentDescription(getTitle());
    }

    private void updateContentScrimBounds(@NonNull Drawable r10, int r11, int r12) {
        updateContentScrimBounds(r10, this.toolbar, r11, r12);
    }

    private void updateDummyView() {
        if (this.collapsingTitleEnabled == true) goto L10;
        View r10 = this.dummyView;
        if (r10 == null) goto L10;
        ViewParent r11 = r10.getParent();
        if ((r11 instanceof ViewGroup) == false) goto L10;
        ((ViewGroup) r11).removeView(this.dummyView);
    L10:
        if (this.collapsingTitleEnabled == true) goto L12;
        return;
    L12:
        if (this.toolbar != null) goto L14;
        return;
    L14:
        if (this.dummyView != null) goto L17;
        this.dummyView = new View(getContext());
    L17:
        if (this.dummyView.getParent() != null) goto L22;
        this.toolbar.addView(this.dummyView, -1, -1);
        return;
    }

    private void updateTextBounds(int r10, int r11, int r12, int r13, boolean r14) {
        if (this.collapsingTitleEnabled == false) goto L28;
        View r15 = this.dummyView;
        if (r15 == null) goto L29;
        boolean r16 = false;
        if (ViewCompat.S(r15) == true) goto L9;
    L11:
        boolean r17 = false;
    L12:
        this.drawCollapsingTitle = r17;
        if (r17 == true) goto L16;
        if (r14 == true) goto L16;
        return;
    L16:
        if (ViewCompat.A(this) != 1) goto L18;
        r16 = true;
    L18:
        updateCollapsedBounds(r16);
        CollapsingTextHelper r18 = this.collapsingTextHelper;
        if (r16 == false) goto L21;
        int r19 = this.expandedMarginEnd;
    L22:
        int r20 = this.tmpRect.top + this.expandedMarginTop;
        int r21 = r12 - r10;
        if (r16 == false) goto L25;
        int r22 = this.expandedMarginStart;
    L26:
        r18.setExpandedBounds(r19, r20, r21 - r22, (r13 - r11) - this.expandedMarginBottom);
        this.collapsingTextHelper.recalculate(r14);
        return;
    L25:
        r22 = this.expandedMarginEnd;
        goto L26
    L21:
        r19 = this.expandedMarginStart;
        goto L22
    L9:
        if (this.dummyView.getVisibility() != 0) goto L11;
        r17 = true;
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
        if (TextUtils.isEmpty(this.collapsingTextHelper.getText()) == false) goto L12;
        setTitle(getToolbarTitle(this.toolbar));
        return;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams r10) {
        return r10 instanceof LayoutParams;
    }

    @Override // android.view.View
    public void draw(@NonNull Canvas r10) {
        super.draw(r10);
        ensureToolbar();
        if (this.toolbar != null) goto L10;
        Drawable r11 = this.contentScrim;
        if (r11 == null) goto L10;
        if (this.scrimAlpha <= 0) goto L10;
        r11.mutate().setAlpha(this.scrimAlpha);
        this.contentScrim.draw(r10);
    L10:
        if (this.collapsingTitleEnabled == false) goto L26;
        if (this.drawCollapsingTitle == false) goto L26;
        if (this.toolbar != null) goto L16;
    L24:
        this.collapsingTextHelper.draw(r10);
        goto L26
    L16:
        if (this.contentScrim == null) goto L24;
        if (this.scrimAlpha <= 0) goto L24;
        if (isTitleCollapseFadeMode() == false) goto L24;
        if (this.collapsingTextHelper.getExpansionFraction() >= this.collapsingTextHelper.getFadeModeThresholdFraction()) goto L24;
        int r12 = r10.save();
        r10.clipRect(this.contentScrim.getBounds(), Region.Op.DIFFERENCE);
        this.collapsingTextHelper.draw(r10);
        r10.restoreToCount(r12);
    L26:
        if (this.statusBarScrim != null) goto L28;
        return;
    L28:
        if (this.scrimAlpha <= 0) goto L37;
        WindowInsetsCompat r13 = this.lastInsets;
        if (r13 == null) goto L32;
        int r14 = r13.m();
    L33:
        if (r14 <= 0) goto L38;
        this.statusBarScrim.setBounds(0, -this.currentOffset, getWidth(), r14 - this.currentOffset);
        this.statusBarScrim.mutate().setAlpha(this.scrimAlpha);
        this.statusBarScrim.draw(r10);
        return;
    L38:
        return;
    L32:
        r14 = 0;
        goto L33
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas r10, View r11, long r12) {
        if (this.contentScrim != null) goto L5;
    L9:
        boolean r13 = false;
    L11:
        if (super.drawChild(r10, r11, r12) == true) goto L16;
        if (r13 == false) goto L15;
        return true;
    L15:
        return false;
    L16:
        return true;
    L5:
        if (this.scrimAlpha <= 0) goto L9;
        if (isToolbarChild(r11) == false) goto L9;
        updateContentScrimBounds(this.contentScrim, r11, getWidth(), getHeight());
        this.contentScrim.mutate().setAlpha(this.scrimAlpha);
        this.contentScrim.draw(r10);
        r13 = true;
        goto L11
    }

    @Override // android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        int[] r10 = getDrawableState();
        Drawable r11 = this.statusBarScrim;
        if (r11 != null) goto L5;
    L7:
        boolean r12 = false;
    L8:
        Drawable r13 = this.contentScrim;
        if (r13 != null) goto L11;
    L13:
        CollapsingTextHelper r14 = this.collapsingTextHelper;
        if (r14 == null) goto L16;
        r12 = r12 | r14.setState(r10);
    L16:
        if (r12 == false) goto L19;
        invalidate();
        return;
    L19:
        return;
    L11:
        if (r13.isStateful() == false) goto L13;
        r12 = r12 | r13.setState(r10);
        goto L13
    L5:
        if (r11.isStateful() == false) goto L7;
        r12 = r11.setState(r10);
        goto L8
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return generateDefaultLayoutParams();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(AttributeSet r10) {
        return generateLayoutParams(r10);
    }

    public int getCollapsedTitleGravity() {
        return this.collapsingTextHelper.getCollapsedTextGravity();
    }

    @NonNull
    public Typeface getCollapsedTitleTypeface() {
        return this.collapsingTextHelper.getCollapsedTypeface();
    }

    @Nullable
    public Drawable getContentScrim() {
        return this.contentScrim;
    }

    public int getExpandedTitleGravity() {
        return this.collapsingTextHelper.getExpandedTextGravity();
    }

    public int getExpandedTitleMarginBottom() {
        return this.expandedMarginBottom;
    }

    public int getExpandedTitleMarginEnd() {
        return this.expandedMarginEnd;
    }

    public int getExpandedTitleMarginStart() {
        return this.expandedMarginStart;
    }

    public int getExpandedTitleMarginTop() {
        return this.expandedMarginTop;
    }

    @NonNull
    public Typeface getExpandedTitleTypeface() {
        return this.collapsingTextHelper.getExpandedTypeface();
    }

    @RequiresApi(23)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public int getHyphenationFrequency() {
        return this.collapsingTextHelper.getHyphenationFrequency();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public int getLineCount() {
        return this.collapsingTextHelper.getLineCount();
    }

    @RequiresApi(23)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public float getLineSpacingAdd() {
        return this.collapsingTextHelper.getLineSpacingAdd();
    }

    @RequiresApi(23)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public float getLineSpacingMultiplier() {
        return this.collapsingTextHelper.getLineSpacingMultiplier();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public int getMaxLines() {
        return this.collapsingTextHelper.getMaxLines();
    }

    public final int getMaxOffsetForPinChild(@NonNull View r10) {
        ViewOffsetHelper r11 = getViewOffsetHelper(r10);
        LayoutParams r12 = (LayoutParams) r10.getLayoutParams();
        return ((getHeight() - r11.getLayoutTop()) - r10.getHeight()) - ((FrameLayout.LayoutParams) r12).bottomMargin;
    }

    public int getScrimAlpha() {
        return this.scrimAlpha;
    }

    public long getScrimAnimationDuration() {
        return this.scrimAnimationDuration;
    }

    public int getScrimVisibleHeightTrigger() {
        int r10 = this.scrimVisibleHeightTrigger;
        if (r10 >= 0) goto L5;
        WindowInsetsCompat r11 = this.lastInsets;
        if (r11 == null) goto L9;
        int r12 = r11.m();
    L10:
        int r13 = ViewCompat.B(this);
        if (r13 <= 0) goto L15;
        return Math.min((r13 * 2) + r12, getHeight());
    L15:
        return getHeight() / 3;
    L9:
        r12 = 0;
        goto L10
    L5:
        return (r10 + this.topInsetApplied) + this.extraMultilineHeight;
    }

    @Nullable
    public Drawable getStatusBarScrim() {
        return this.statusBarScrim;
    }

    @Nullable
    public CharSequence getTitle() {
        if (this.collapsingTitleEnabled == true) goto L7;
        return null;
    L7:
        return this.collapsingTextHelper.getText();
    }

    public int getTitleCollapseMode() {
        return this.titleCollapseMode;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean isExtraMultilineHeightEnabled() {
        return this.extraMultilineHeightEnabled;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean isForceApplySystemWindowInsetTop() {
        return this.forceApplySystemWindowInsetTop;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean isRtlTextDirectionHeuristicsEnabled() {
        return this.collapsingTextHelper.isRtlTextDirectionHeuristicsEnabled();
    }

    public boolean isTitleEnabled() {
        return this.collapsingTitleEnabled;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewParent r10 = getParent();
        if ((r10 instanceof AppBarLayout) == false) goto L9;
        AppBarLayout r11 = (AppBarLayout) r10;
        disableLiftOnScrollIfNeeded(r11);
        ViewCompat.y0(this, ViewCompat.x(r11));
        if (this.onOffsetChangedListener != null) goto L7;
        this.onOffsetChangedListener = new OffsetUpdateListener(this);
    L7:
        r11.addOnOffsetChangedListener(this.onOffsetChangedListener);
        ViewCompat.m0(this);
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        ViewParent r10 = getParent();
        AppBarLayout.OnOffsetChangedListener r11 = this.onOffsetChangedListener;
        if (r11 != null) goto L5;
    L7:
        super.onDetachedFromWindow();
        return;
    L5:
        if ((r10 instanceof AppBarLayout) == false) goto L7;
        ((AppBarLayout) r10).removeOnOffsetChangedListener(r11);
        goto L7
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean r10, int r11, int r12, int r13, int r14) {
        super.onLayout(r10, r11, r12, r13, r14);
        WindowInsetsCompat r15 = this.lastInsets;
        int r16 = 0;
        if (r15 == null) goto L12;
        int r17 = r15.m();
        int r18 = getChildCount();
        int r19 = 0;
    L5:
        if (r19 >= r18) goto L12;
        View r20 = getChildAt(r19);
        if (ViewCompat.x(r20) == true) goto L11;
        if (r20.getTop() >= r17) goto L11;
        ViewCompat.a0(r20, r17);
    L11:
        r19 = r19 + 1;
    L12:
        int r21 = getChildCount();
        int r22 = 0;
    L13:
        if (r22 >= r21) goto L15;
        getViewOffsetHelper(getChildAt(r22)).onViewLayout();
        r22 = r22 + 1;
        goto L13
    L15:
        updateTextBounds(r11, r12, r13, r14, false);
        updateTitleFromToolbarIfNeeded();
        updateScrimVisibility();
        int r23 = getChildCount();
    L16:
        if (r16 >= r23) goto L18;
        getViewOffsetHelper(getChildAt(r16)).applyOffsets();
        r16 = r16 + 1;
        goto L16
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int r10, int r11) {
        ensureToolbar();
        super.onMeasure(r10, r11);
        int r12 = View.MeasureSpec.getMode(r11);
        WindowInsetsCompat r13 = this.lastInsets;
        if (r13 == null) goto L5;
        int r14 = r13.m();
    L7:
        if (r12 != 0) goto L9;
    L10:
        if (r14 <= 0) goto L13;
        this.topInsetApplied = r14;
        super.onMeasure(r10, View.MeasureSpec.makeMeasureSpec(getMeasuredHeight() + r14, Ints.MAX_POWER_OF_TWO));
    L13:
        if (this.extraMultilineHeightEnabled == true) goto L15;
    L19:
        ViewGroup r15 = this.toolbar;
        if (r15 == null) goto L28;
        View r16 = this.toolbarDirectChild;
        if (r16 == null) goto L26;
        if (r16 == this) goto L26;
        setMinimumHeight(getHeightWithMargins(r16));
        return;
    L26:
        setMinimumHeight(getHeightWithMargins(r15));
        return;
    L28:
        return;
    L15:
        if (this.collapsingTextHelper.getMaxLines() <= 1) goto L19;
        updateTitleFromToolbarIfNeeded();
        updateTextBounds(0, 0, getMeasuredWidth(), getMeasuredHeight(), true);
        int r17 = this.collapsingTextHelper.getLineCount();
        if (r17 <= 1) goto L19;
        this.extraMultilineHeight = Math.round(this.collapsingTextHelper.getExpandedTextFullHeight()) * (r17 - 1);
        super.onMeasure(r10, View.MeasureSpec.makeMeasureSpec(getMeasuredHeight() + this.extraMultilineHeight, Ints.MAX_POWER_OF_TWO));
        goto L19
    L9:
        if (this.forceApplySystemWindowInsetTop == false) goto L13;
    L5:
        r14 = 0;
        goto L7
    }

    @Override // android.view.View
    public void onSizeChanged(int r10, int r11, int r12, int r13) {
        super.onSizeChanged(r10, r11, r12, r13);
        Drawable r14 = this.contentScrim;
        if (r14 == null) goto L6;
        updateContentScrimBounds(r14, r10, r11);
        return;
    }

    public WindowInsetsCompat onWindowInsetChanged(@NonNull WindowInsetsCompat r10) {
        if (ViewCompat.x(this) == false) goto L5;
        WindowInsetsCompat r11 = r10;
    L7:
        if (b.a(this.lastInsets, r11) == true) goto L10;
        this.lastInsets = r11;
        requestLayout();
    L10:
        return r10.c();
    L5:
        r11 = null;
        goto L7
    }

    public void setCollapsedTitleGravity(int r10) {
        this.collapsingTextHelper.setCollapsedTextGravity(r10);
    }

    public void setCollapsedTitleTextAppearance(@StyleRes int r10) {
        this.collapsingTextHelper.setCollapsedTextAppearance(r10);
    }

    public void setCollapsedTitleTextColor(@ColorInt int r10) {
        setCollapsedTitleTextColor(ColorStateList.valueOf(r10));
    }

    public void setCollapsedTitleTypeface(@Nullable Typeface r10) {
        this.collapsingTextHelper.setCollapsedTypeface(r10);
    }

    public void setContentScrim(@Nullable Drawable r10) {
        Drawable r11 = this.contentScrim;
        if (r11 == r10) goto L14;
        Drawable r12 = null;
        if (r11 == null) goto L7;
        r11.setCallback(null);
    L7:
        if (r10 == null) goto L9;
        r12 = r10.mutate();
    L9:
        this.contentScrim = r12;
        if (r12 == null) goto L12;
        updateContentScrimBounds(r12, getWidth(), getHeight());
        this.contentScrim.setCallback(this);
        this.contentScrim.setAlpha(this.scrimAlpha);
    L12:
        ViewCompat.g0(this);
        return;
    }

    public void setContentScrimColor(@ColorInt int r10) {
        setContentScrim(new ColorDrawable(r10));
    }

    public void setContentScrimResource(@DrawableRes int r10) {
        setContentScrim(ContextCompat.d(getContext(), r10));
    }

    public void setExpandedTitleColor(@ColorInt int r10) {
        setExpandedTitleTextColor(ColorStateList.valueOf(r10));
    }

    public void setExpandedTitleGravity(int r10) {
        this.collapsingTextHelper.setExpandedTextGravity(r10);
    }

    public void setExpandedTitleMargin(int r10, int r11, int r12, int r13) {
        this.expandedMarginStart = r10;
        this.expandedMarginTop = r11;
        this.expandedMarginEnd = r12;
        this.expandedMarginBottom = r13;
        requestLayout();
    }

    public void setExpandedTitleMarginBottom(int r10) {
        this.expandedMarginBottom = r10;
        requestLayout();
    }

    public void setExpandedTitleMarginEnd(int r10) {
        this.expandedMarginEnd = r10;
        requestLayout();
    }

    public void setExpandedTitleMarginStart(int r10) {
        this.expandedMarginStart = r10;
        requestLayout();
    }

    public void setExpandedTitleMarginTop(int r10) {
        this.expandedMarginTop = r10;
        requestLayout();
    }

    public void setExpandedTitleTextAppearance(@StyleRes int r10) {
        this.collapsingTextHelper.setExpandedTextAppearance(r10);
    }

    public void setExpandedTitleTextColor(@NonNull ColorStateList r10) {
        this.collapsingTextHelper.setExpandedTextColor(r10);
    }

    public void setExpandedTitleTypeface(@Nullable Typeface r10) {
        this.collapsingTextHelper.setExpandedTypeface(r10);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setExtraMultilineHeightEnabled(boolean r10) {
        this.extraMultilineHeightEnabled = r10;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setForceApplySystemWindowInsetTop(boolean r10) {
        this.forceApplySystemWindowInsetTop = r10;
    }

    @RequiresApi(23)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setHyphenationFrequency(int r10) {
        this.collapsingTextHelper.setHyphenationFrequency(r10);
    }

    @RequiresApi(23)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setLineSpacingAdd(float r10) {
        this.collapsingTextHelper.setLineSpacingAdd(r10);
    }

    @RequiresApi(23)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setLineSpacingMultiplier(@FloatRange(from = 0.0d) float r10) {
        this.collapsingTextHelper.setLineSpacingMultiplier(r10);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setMaxLines(int r10) {
        this.collapsingTextHelper.setMaxLines(r10);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setRtlTextDirectionHeuristicsEnabled(boolean r10) {
        this.collapsingTextHelper.setRtlTextDirectionHeuristicsEnabled(r10);
    }

    public void setScrimAlpha(int r10) {
        if (r10 != this.scrimAlpha) goto L5;
        return;
    L5:
        if (this.contentScrim == null) goto L9;
        ViewGroup r11 = this.toolbar;
        if (r11 == null) goto L9;
        ViewCompat.g0(r11);
    L9:
        this.scrimAlpha = r10;
        ViewCompat.g0(this);
    }

    public void setScrimAnimationDuration(@IntRange(from = 0) long r10) {
        this.scrimAnimationDuration = r10;
    }

    public void setScrimVisibleHeightTrigger(@IntRange(from = 0) int r10) {
        if (this.scrimVisibleHeightTrigger == r10) goto L6;
        this.scrimVisibleHeightTrigger = r10;
        updateScrimVisibility();
        return;
    }

    public void setScrimsShown(boolean r10) {
        if (ViewCompat.T(this) == true) goto L5;
    L7:
        boolean r11 = false;
    L8:
        setScrimsShown(r10, r11);
        return;
    L5:
        if (isInEditMode() == true) goto L7;
        r11 = true;
        goto L8
    }

    public void setStatusBarScrim(@Nullable Drawable r10) {
        Drawable r11 = this.statusBarScrim;
        if (r11 == r10) goto L21;
        Drawable r12 = null;
        if (r11 == null) goto L7;
        r11.setCallback(null);
    L7:
        if (r10 == null) goto L9;
        r12 = r10.mutate();
    L9:
        this.statusBarScrim = r12;
        if (r12 != null) goto L12;
    L19:
        ViewCompat.g0(this);
        return;
    L12:
        if (r12.isStateful() == false) goto L14;
        this.statusBarScrim.setState(getDrawableState());
    L14:
        o.a.g(this.statusBarScrim, ViewCompat.A(this));
        Drawable r13 = this.statusBarScrim;
        if (getVisibility() != 0) goto L17;
        boolean r14 = true;
    L18:
        r13.setVisible(r14, false);
        this.statusBarScrim.setCallback(this);
        this.statusBarScrim.setAlpha(this.scrimAlpha);
        goto L19
    L17:
        r14 = false;
        goto L18
    }

    public void setStatusBarScrimColor(@ColorInt int r10) {
        setStatusBarScrim(new ColorDrawable(r10));
    }

    public void setStatusBarScrimResource(@DrawableRes int r10) {
        setStatusBarScrim(ContextCompat.d(getContext(), r10));
    }

    public void setTitle(@Nullable CharSequence r10) {
        this.collapsingTextHelper.setText(r10);
        updateContentDescriptionFromTitle();
    }

    public void setTitleCollapseMode(int r10) {
        this.titleCollapseMode = r10;
        boolean r11 = isTitleCollapseFadeMode();
        this.collapsingTextHelper.setFadeModeEnabled(r11);
        ViewParent r12 = getParent();
        if ((r12 instanceof AppBarLayout) == false) goto L5;
        disableLiftOnScrollIfNeeded((AppBarLayout) r12);
    L5:
        if (r11 == true) goto L7;
        return;
    L7:
        if (this.contentScrim != null) goto L11;
        float r13 = getResources().getDimension(R.dimen.design_appbar_elevation);
        setContentScrimColor(this.elevationOverlayProvider.compositeOverlayWithThemeSurfaceColorIfNeeded(r13));
        return;
    }

    public void setTitleEnabled(boolean r10) {
        if (r10 == this.collapsingTitleEnabled) goto L6;
        this.collapsingTitleEnabled = r10;
        updateContentDescriptionFromTitle();
        updateDummyView();
        requestLayout();
        return;
    }

    @Override // android.view.View
    public void setVisibility(int r10) {
        super.setVisibility(r10);
        if (r10 != 0) goto L5;
        boolean r11 = true;
    L6:
        Drawable r12 = this.statusBarScrim;
        if (r12 != null) goto L9;
    L11:
        Drawable r13 = this.contentScrim;
        if (r13 != null) goto L14;
        return;
    L14:
        if (r13.isVisible() == r11) goto L18;
        this.contentScrim.setVisible(r11, false);
        return;
    L18:
        return;
    L9:
        if (r12.isVisible() == r11) goto L11;
        this.statusBarScrim.setVisible(r11, false);
        goto L11
    L5:
        r11 = false;
        goto L6
    }

    public final void updateScrimVisibility() {
        if (this.contentScrim != null) goto L7;
        if (this.statusBarScrim != null) goto L7;
        return;
    L7:
        if ((getHeight() + this.currentOffset) >= getScrimVisibleHeightTrigger()) goto L9;
        boolean r10 = true;
    L10:
        setScrimsShown(r10);
        return;
    L9:
        r10 = false;
        goto L10
    }

    @Override // android.view.View
    public boolean verifyDrawable(@NonNull Drawable r10) {
        if (super.verifyDrawable(r10) == false) goto L5;
    L10:
        return true;
    L5:
        if (r10 == this.contentScrim) goto L10;
        if (r10 == this.statusBarScrim) goto L10;
        return false;
    }

    public CollapsingToolbarLayout(@NonNull Context r10, @Nullable AttributeSet r11) {
        this(r10, r11, R.attr.collapsingToolbarLayoutStyle);
    }

    private void updateContentScrimBounds(@NonNull Drawable r10, @Nullable View r11, int r12, int r13) {
        if (isTitleCollapseFadeMode() == false) goto L8;
        if (r11 == null) goto L8;
        if (this.collapsingTitleEnabled == false) goto L8;
        r13 = r11.getBottom();
    L8:
        r10.setBounds(0, 0, r12, r13);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public /* bridge */ /* synthetic */ FrameLayout.LayoutParams generateDefaultLayoutParams() {
        return generateDefaultLayoutParams();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r10) {
        return generateLayoutParams(r10);
    }

    public void setCollapsedTitleTextColor(@NonNull ColorStateList r10) {
        this.collapsingTextHelper.setCollapsedTextColor(r10);
    }

    public void setScrimsShown(boolean r10, boolean r11) {
        if (this.scrimsAreShown == r10) goto L14;
        int r12 = 0;
        if (r11 == false) goto L9;
        if (r10 == false) goto L8;
        r12 = 255;
    L8:
        animateScrim(r12);
    L12:
        this.scrimsAreShown = r10;
        return;
    L9:
        if (r10 == false) goto L11;
        r12 = 255;
    L11:
        setScrimAlpha(r12);
        goto L12
    }

    public CollapsingToolbarLayout(@NonNull Context r10, @Nullable AttributeSet r11, int r12) {
        int r13 = DEF_STYLE_RES;
        super(MaterialThemeOverlay.wrap(r10, r11, r12, r13), r11, r12);
        this.refreshToolbar = true;
        this.tmpRect = new Rect();
        this.scrimVisibleHeightTrigger = -1;
        this.topInsetApplied = 0;
        this.extraMultilineHeight = 0;
        Context r14 = getContext();
        CollapsingTextHelper r15 = new CollapsingTextHelper(this);
        this.collapsingTextHelper = r15;
        r15.setTextSizeInterpolator(AnimationUtils.DECELERATE_INTERPOLATOR);
        r15.setRtlTextDirectionHeuristicsEnabled(false);
        this.elevationOverlayProvider = new ElevationOverlayProvider(r14);
        TypedArray r16 = ThemeEnforcement.obtainStyledAttributes(r14, r11, R.styleable.CollapsingToolbarLayout, r12, r13, new int[0]);
        r15.setExpandedTextGravity(r16.getInt(R.styleable.CollapsingToolbarLayout_expandedTitleGravity, BadgeDrawable.BOTTOM_START));
        r15.setCollapsedTextGravity(r16.getInt(R.styleable.CollapsingToolbarLayout_collapsedTitleGravity, 8388627));
        int r17 = r16.getDimensionPixelSize(R.styleable.CollapsingToolbarLayout_expandedTitleMargin, 0);
        this.expandedMarginBottom = r17;
        this.expandedMarginEnd = r17;
        this.expandedMarginTop = r17;
        this.expandedMarginStart = r17;
        int r18 = R.styleable.CollapsingToolbarLayout_expandedTitleMarginStart;
        if (r16.hasValue(r18) == false) goto L5;
        this.expandedMarginStart = r16.getDimensionPixelSize(r18, 0);
    L5:
        int r19 = R.styleable.CollapsingToolbarLayout_expandedTitleMarginEnd;
        if (r16.hasValue(r19) == false) goto L8;
        this.expandedMarginEnd = r16.getDimensionPixelSize(r19, 0);
    L8:
        int r110 = R.styleable.CollapsingToolbarLayout_expandedTitleMarginTop;
        if (r16.hasValue(r110) == false) goto L11;
        this.expandedMarginTop = r16.getDimensionPixelSize(r110, 0);
    L11:
        int r111 = R.styleable.CollapsingToolbarLayout_expandedTitleMarginBottom;
        if (r16.hasValue(r111) == false) goto L14;
        this.expandedMarginBottom = r16.getDimensionPixelSize(r111, 0);
    L14:
        this.collapsingTitleEnabled = r16.getBoolean(R.styleable.CollapsingToolbarLayout_titleEnabled, true);
        setTitle(r16.getText(R.styleable.CollapsingToolbarLayout_title));
        r15.setExpandedTextAppearance(R.style.TextAppearance_Design_CollapsingToolbar_Expanded);
        r15.setCollapsedTextAppearance(R$style.TextAppearance_AppCompat_Widget_ActionBar_Title);
        int r112 = R.styleable.CollapsingToolbarLayout_expandedTitleTextAppearance;
        if (r16.hasValue(r112) == false) goto L17;
        r15.setExpandedTextAppearance(r16.getResourceId(r112, 0));
    L17:
        int r113 = R.styleable.CollapsingToolbarLayout_collapsedTitleTextAppearance;
        if (r16.hasValue(r113) == false) goto L20;
        r15.setCollapsedTextAppearance(r16.getResourceId(r113, 0));
    L20:
        this.scrimVisibleHeightTrigger = r16.getDimensionPixelSize(R.styleable.CollapsingToolbarLayout_scrimVisibleHeightTrigger, -1);
        int r114 = R.styleable.CollapsingToolbarLayout_maxLines;
        if (r16.hasValue(r114) == false) goto L23;
        r15.setMaxLines(r16.getInt(r114, 1));
    L23:
        this.scrimAnimationDuration = r16.getInt(R.styleable.CollapsingToolbarLayout_scrimAnimationDuration, 600);
        setContentScrim(r16.getDrawable(R.styleable.CollapsingToolbarLayout_contentScrim));
        setStatusBarScrim(r16.getDrawable(R.styleable.CollapsingToolbarLayout_statusBarScrim));
        setTitleCollapseMode(r16.getInt(R.styleable.CollapsingToolbarLayout_titleCollapseMode, 0));
        this.toolbarId = r16.getResourceId(R.styleable.CollapsingToolbarLayout_toolbarId, -1);
        this.forceApplySystemWindowInsetTop = r16.getBoolean(R.styleable.CollapsingToolbarLayout_forceApplySystemWindowInsetTop, false);
        this.extraMultilineHeightEnabled = r16.getBoolean(R.styleable.CollapsingToolbarLayout_extraMultilineHeightEnabled, false);
        r16.recycle();
        setWillNotDraw(false);
        ViewCompat.C0(this, new AnonymousClass1(this));
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -1);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public FrameLayout.LayoutParams generateLayoutParams(AttributeSet r10) {
        return new LayoutParams(getContext(), r10);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public FrameLayout.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r10) {
        return new LayoutParams(r10);
    }
}
