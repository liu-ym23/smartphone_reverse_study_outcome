package com.google.android.material.search;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.appcompat.graphics.drawable.DrawerArrowDrawable;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.internal.ClippableRoundedCornerLayout;
import com.google.android.material.internal.FadeThroughDrawable;
import com.google.android.material.internal.FadeThroughUpdateListener;
import com.google.android.material.internal.MultiViewUpdateListener;
import com.google.android.material.internal.RectEvaluator;
import com.google.android.material.internal.ReversableAnimatedValueInterpolator;
import com.google.android.material.internal.ToolbarUtils;
import com.google.android.material.internal.TouchObserverFrameLayout;
import com.google.android.material.internal.ViewUtils;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
class SearchViewAnimationHelper {
    private static final float CONTENT_FROM_SCALE = 0.95f;
    private static final long HIDE_CLEAR_BUTTON_ALPHA_DURATION_MS = 42;
    private static final long HIDE_CLEAR_BUTTON_ALPHA_START_DELAY_MS = 0;
    private static final long HIDE_CONTENT_ALPHA_DURATION_MS = 83;
    private static final long HIDE_CONTENT_ALPHA_START_DELAY_MS = 0;
    private static final long HIDE_CONTENT_SCALE_DURATION_MS = 250;
    private static final long HIDE_DURATION_MS = 250;
    private static final long HIDE_TRANSLATE_DURATION_MS = 300;
    private static final long SHOW_CLEAR_BUTTON_ALPHA_DURATION_MS = 50;
    private static final long SHOW_CLEAR_BUTTON_ALPHA_START_DELAY_MS = 250;
    private static final long SHOW_CONTENT_ALPHA_DURATION_MS = 150;
    private static final long SHOW_CONTENT_ALPHA_START_DELAY_MS = 75;
    private static final long SHOW_CONTENT_SCALE_DURATION_MS = 300;
    private static final long SHOW_DURATION_MS = 300;
    private static final long SHOW_TRANSLATE_DURATION_MS = 350;
    private static final long SHOW_TRANSLATE_KEYBOARD_START_DELAY_MS = 150;
    private final ImageButton clearButton;
    private final TouchObserverFrameLayout contentContainer;
    private final View divider;
    private final Toolbar dummyToolbar;
    private final EditText editText;
    private final FrameLayout headerContainer;
    private final ClippableRoundedCornerLayout rootView;
    private final View scrim;
    private SearchBar searchBar;
    private final TextView searchPrefix;
    private final SearchView searchView;
    private final Toolbar toolbar;
    private final FrameLayout toolbarContainer;

    static /* synthetic */ SearchView access$000(SearchViewAnimationHelper r0) {
        return r0.searchView;
    }

    static /* synthetic */ ClippableRoundedCornerLayout access$100(SearchViewAnimationHelper r0) {
        return r0.rootView;
    }

    static /* synthetic */ void access$200(SearchViewAnimationHelper r0, float r1) {
        r0.setContentViewsAlpha(r1);
    }

    static /* synthetic */ SearchBar access$300(SearchViewAnimationHelper r0) {
        return r0.searchBar;
    }

    SearchViewAnimationHelper(SearchView r2) {
        this.searchView = r2;
        this.scrim = r2.scrim;
        this.rootView = r2.rootView;
        this.headerContainer = r2.headerContainer;
        this.toolbarContainer = r2.toolbarContainer;
        this.toolbar = r2.toolbar;
        this.dummyToolbar = r2.dummyToolbar;
        this.searchPrefix = r2.searchPrefix;
        this.editText = r2.editText;
        this.clearButton = r2.clearButton;
        this.divider = r2.divider;
        this.contentContainer = r2.contentContainer;
    }

    void setSearchBar(SearchBar r1) {
        this.searchBar = r1;
    }

    void show() {
        if (this.searchBar == null) goto L5;
        startShowAnimationExpand();
        return;
    L5:
        startShowAnimationTranslate();
    }

    void hide() {
        if (this.searchBar == null) goto L5;
        startHideAnimationCollapse();
        return;
    L5:
        startHideAnimationTranslate();
    }

    private void startShowAnimationExpand() {
        if (this.searchView.isAdjustNothingSoftInputMode() == false) goto L5;
        this.searchView.requestFocusAndShowKeyboardIfNeeded();
    L5:
        this.searchView.setTransitionState(SearchView.TransitionState.SHOWING);
        setUpDummyToolbarIfNeeded();
        this.editText.setText(this.searchBar.getText());
        EditText r0 = this.editText;
        r0.setSelection(r0.getText().length());
        this.rootView.setVisibility(4);
        this.rootView.post(new SearchViewAnimationHelper$$ExternalSyntheticLambda2(this));
    }

    /* JADX INFO: renamed from: lambda$startShowAnimationExpand$0$com-google-android-material-search-SearchViewAnimationHelper, reason: not valid java name */
    /* synthetic */ void m264x94743afc() {
        AnimatorSet r0 = getExpandCollapseAnimatorSet(true);
        r0.addListener(new AnonymousClass1(this));
        r0.start();
    }

    private void startHideAnimationCollapse() {
        if (this.searchView.isAdjustNothingSoftInputMode() == false) goto L5;
        this.searchView.clearFocusAndHideKeyboard();
    L5:
        AnimatorSet r0 = getExpandCollapseAnimatorSet(false);
        r0.addListener(new AnonymousClass2(this));
        r0.start();
    }

    private void startShowAnimationTranslate() {
        if (this.searchView.isAdjustNothingSoftInputMode() == false) goto L5;
        final SearchView r0 = this.searchView;
        Objects.requireNonNull(r0);
        r0.postDelayed(new SearchViewAnimationHelper$$ExternalSyntheticLambda3(r0), 150);
    L5:
        this.rootView.setVisibility(4);
        this.rootView.post(new SearchViewAnimationHelper$$ExternalSyntheticLambda4(this));
    }

    /* JADX INFO: renamed from: lambda$startShowAnimationTranslate$1$com-google-android-material-search-SearchViewAnimationHelper, reason: not valid java name */
    /* synthetic */ void m265x4df249eb() {
        ClippableRoundedCornerLayout r0 = this.rootView;
        r0.setTranslationY(r0.getHeight());
        AnimatorSet r1 = getTranslateAnimatorSet(true);
        r1.addListener(new AnonymousClass3(this));
        r1.start();
    }

    private void startHideAnimationTranslate() {
        if (this.searchView.isAdjustNothingSoftInputMode() == false) goto L5;
        this.searchView.clearFocusAndHideKeyboard();
    L5:
        AnimatorSet r0 = getTranslateAnimatorSet(false);
        r0.addListener(new AnonymousClass4(this));
        r0.start();
    }

    private AnimatorSet getTranslateAnimatorSet(boolean r5) {
        AnimatorSet r0 = new AnimatorSet();
        r0.playTogether(new Animator[]{getTranslationYAnimator()});
        addBackButtonProgressAnimatorIfNeeded(r0);
        r0.setInterpolator(ReversableAnimatedValueInterpolator.of(r5, AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR));
        if (r5 == false) goto L5;
        long r4 = SHOW_TRANSLATE_DURATION_MS;
    L6:
        r0.setDuration(r4);
        return r0;
    L5:
        r4 = 300;
        goto L6
    }

    private Animator getTranslationYAnimator() {
        ValueAnimator r0 = ValueAnimator.ofFloat(new float[]{this.rootView.getHeight(), 0.0f});
        r0.addUpdateListener(MultiViewUpdateListener.translationYListener(new View[]{this.rootView}));
        return r0;
    }

    private AnimatorSet getExpandCollapseAnimatorSet(final boolean r5) {
        AnimatorSet r0 = new AnimatorSet();
        r0.playTogether(new Animator[]{getScrimAlphaAnimator(r5), getRootViewAnimator(r5), getClearButtonAnimator(r5), getContentAnimator(r5), getButtonsAnimator(r5), getHeaderContainerAnimator(r5), getDummyToolbarAnimator(r5), getActionMenuViewsAlphaAnimator(r5), getEditTextAnimator(r5), getSearchPrefixAnimator(r5)});
        r0.addListener(new AnonymousClass5(this, r5));
        return r0;
    }

    private void setContentViewsAlpha(float r2) {
        this.clearButton.setAlpha(r2);
        this.divider.setAlpha(r2);
        this.contentContainer.setAlpha(r2);
        setActionMenuViewAlphaIfNeeded(r2);
    }

    private void setActionMenuViewAlphaIfNeeded(float r2) {
        if (this.searchView.isMenuItemsAnimated() == false) goto L8;
        ActionMenuView r1 = ToolbarUtils.getActionMenuView(this.toolbar);
        if (r1 == null) goto L9;
        r1.setAlpha(r2);
        return;
    L9:
        return;
    }

    private Animator getScrimAlphaAnimator(boolean r5) {
        if (r5 == false) goto L4;
        TimeInterpolator r0 = AnimationUtils.LINEAR_INTERPOLATOR;
    L5:
        ValueAnimator r1 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        if (r5 == false) goto L8;
        long r2 = 300;
    L9:
        r1.setDuration(r2);
        r1.setInterpolator(ReversableAnimatedValueInterpolator.of(r5, r0));
        r1.addUpdateListener(MultiViewUpdateListener.alphaListener(new View[]{this.scrim}));
        return r1;
    L8:
        r2 = 250;
        goto L9
    L4:
        r0 = AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR;
        goto L5
    }

    private Animator getRootViewAnimator(boolean r8) {
        Rect r0 = ViewUtils.calculateRectFromBounds(this.searchView);
        Rect r1 = calculateFromClipBounds();
        final Rect r2 = new Rect(r1);
        final float r3 = this.searchBar.getCornerSize();
        ValueAnimator r4 = ValueAnimator.ofObject(new RectEvaluator(r2), new Object[]{r1, r0});
        r4.addUpdateListener(new SearchViewAnimationHelper$$ExternalSyntheticLambda5(this, r3, r2));
        if (r8 == false) goto L5;
        long r5 = 300;
    L6:
        r4.setDuration(r5);
        r4.setInterpolator(ReversableAnimatedValueInterpolator.of(r8, AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR));
        return r4;
    L5:
        r5 = 250;
        goto L6
    }

    /* JADX INFO: renamed from: lambda$getRootViewAnimator$2$com-google-android-material-search-SearchViewAnimationHelper, reason: not valid java name */
    /* synthetic */ void m263xa183b80f(float r2, Rect r3, ValueAnimator r4) {
        float r5 = r2 * (1.0f - r4.getAnimatedFraction());
        this.rootView.updateClipBoundsAndCornerRadius(r3, r5);
    }

    private Rect calculateFromClipBounds() {
        int[] r1 = new int[2];
        this.searchBar.getLocationOnScreen(r1);
        int r3 = r1[0];
        int r2 = r1[1];
        int[] r0 = new int[2];
        this.rootView.getLocationOnScreen(r0);
        int r4 = r0[0];
        int r5 = r3 - r4;
        int r6 = r2 - r0[1];
        return new Rect(r5, r6, this.searchBar.getWidth() + r5, this.searchBar.getHeight() + r6);
    }

    private Animator getClearButtonAnimator(boolean r4) {
        ValueAnimator r0 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        if (r4 == false) goto L5;
        long r1 = 50;
    L6:
        r0.setDuration(r1);
        if (r4 == false) goto L9;
        long r2 = 250;
    L10:
        r0.setStartDelay(r2);
        r0.setInterpolator(ReversableAnimatedValueInterpolator.of(r4, AnimationUtils.LINEAR_INTERPOLATOR));
        r0.addUpdateListener(MultiViewUpdateListener.alphaListener(new View[]{this.clearButton}));
        return r0;
    L9:
        r2 = 0;
        goto L10
    L5:
        r1 = HIDE_CLEAR_BUTTON_ALPHA_DURATION_MS;
        goto L6
    }

    private Animator getButtonsAnimator(boolean r4) {
        AnimatorSet r0 = new AnimatorSet();
        addBackButtonTranslationAnimatorIfNeeded(r0);
        addBackButtonProgressAnimatorIfNeeded(r0);
        addActionMenuViewAnimatorIfNeeded(r0);
        if (r4 == false) goto L5;
        long r1 = 300;
    L6:
        r0.setDuration(r1);
        r0.setInterpolator(ReversableAnimatedValueInterpolator.of(r4, AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR));
        return r0;
    L5:
        r1 = 250;
        goto L6
    }

    private void addBackButtonTranslationAnimatorIfNeeded(AnimatorSet r8) {
        ImageButton r0 = ToolbarUtils.getNavigationIconButton(this.toolbar);
        if (r0 != null) goto L5;
        return;
    L5:
        ValueAnimator r2 = ValueAnimator.ofFloat(new float[]{getFromTranslationXStart(r0), 0.0f});
        r2.addUpdateListener(MultiViewUpdateListener.translationXListener(new View[]{r0}));
        ValueAnimator r7 = ValueAnimator.ofFloat(new float[]{getFromTranslationY(), 0.0f});
        r7.addUpdateListener(MultiViewUpdateListener.translationYListener(new View[]{r0}));
        r8.playTogether(new Animator[]{r2, r7});
    }

    private void addBackButtonProgressAnimatorIfNeeded(AnimatorSet r3) {
        ImageButton r0 = ToolbarUtils.getNavigationIconButton(this.toolbar);
        if (r0 != null) goto L5;
        return;
    L5:
        Drawable r1 = DrawableCompat.unwrap(r0.getDrawable());
        if (this.searchView.isAnimatedNavigationIcon() == false) goto L8;
        addDrawerArrowDrawableAnimatorIfNeeded(r3, r1);
        addFadeThroughDrawableAnimatorIfNeeded(r3, r1);
        return;
    L8:
        setFullDrawableProgressIfNeeded(r1);
    }

    private void addDrawerArrowDrawableAnimatorIfNeeded(AnimatorSet r2, Drawable r3) {
        if ((r3 instanceof DrawerArrowDrawable) == false) goto L6;
        final DrawerArrowDrawable r4 = (DrawerArrowDrawable) r3;
        ValueAnimator r1 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r1.addUpdateListener(new SearchViewAnimationHelper$$ExternalSyntheticLambda1(r4));
        r2.playTogether(new Animator[]{r1});
        return;
    }

    static /* synthetic */ void lambda$addDrawerArrowDrawableAnimatorIfNeeded$3(DrawerArrowDrawable r0, ValueAnimator r1) {
        r0.setProgress(r1.getAnimatedFraction());
    }

    private void addFadeThroughDrawableAnimatorIfNeeded(AnimatorSet r2, Drawable r3) {
        if ((r3 instanceof FadeThroughDrawable) == false) goto L6;
        final FadeThroughDrawable r4 = (FadeThroughDrawable) r3;
        ValueAnimator r1 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r1.addUpdateListener(new SearchViewAnimationHelper$$ExternalSyntheticLambda0(r4));
        r2.playTogether(new Animator[]{r1});
        return;
    }

    static /* synthetic */ void lambda$addFadeThroughDrawableAnimatorIfNeeded$4(FadeThroughDrawable r0, ValueAnimator r1) {
        r0.setProgress(r1.getAnimatedFraction());
    }

    private void setFullDrawableProgressIfNeeded(Drawable r2) {
        if ((r2 instanceof DrawerArrowDrawable) == false) goto L6;
        ((DrawerArrowDrawable) r2).setProgress(1.0f);
    L6:
        if ((r2 instanceof FadeThroughDrawable) == false) goto L9;
        ((FadeThroughDrawable) r2).setProgress(1.0f);
        return;
    }

    private void addActionMenuViewAnimatorIfNeeded(AnimatorSet r8) {
        ActionMenuView r0 = ToolbarUtils.getActionMenuView(this.toolbar);
        if (r0 != null) goto L5;
        return;
    L5:
        ValueAnimator r2 = ValueAnimator.ofFloat(new float[]{getFromTranslationXEnd(r0), 0.0f});
        r2.addUpdateListener(MultiViewUpdateListener.translationXListener(new View[]{r0}));
        ValueAnimator r7 = ValueAnimator.ofFloat(new float[]{getFromTranslationY(), 0.0f});
        r7.addUpdateListener(MultiViewUpdateListener.translationYListener(new View[]{r0}));
        r8.playTogether(new Animator[]{r2, r7});
    }

    private Animator getDummyToolbarAnimator(boolean r3) {
        return getTranslationAnimator(r3, false, this.dummyToolbar);
    }

    private Animator getHeaderContainerAnimator(boolean r3) {
        return getTranslationAnimator(r3, false, this.headerContainer);
    }

    private Animator getActionMenuViewsAlphaAnimator(boolean r4) {
        ValueAnimator r0 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        if (r4 == false) goto L5;
        long r1 = 300;
    L6:
        r0.setDuration(r1);
        r0.setInterpolator(ReversableAnimatedValueInterpolator.of(r4, AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR));
        if (this.searchView.isMenuItemsAnimated() == false) goto L9;
        r0.addUpdateListener(new FadeThroughUpdateListener(ToolbarUtils.getActionMenuView(this.dummyToolbar), ToolbarUtils.getActionMenuView(this.toolbar)));
    L9:
        return r0;
    L5:
        r1 = 250;
        goto L6
    }

    private Animator getSearchPrefixAnimator(boolean r3) {
        return getTranslationAnimator(r3, true, this.searchPrefix);
    }

    private Animator getEditTextAnimator(boolean r3) {
        return getTranslationAnimator(r3, true, this.editText);
    }

    private Animator getContentAnimator(boolean r5) {
        AnimatorSet r0 = new AnimatorSet();
        r0.playTogether(new Animator[]{getContentAlphaAnimator(r5), getDividerAnimator(r5), getContentScaleAnimator(r5)});
        return r0;
    }

    private Animator getContentAlphaAnimator(boolean r5) {
        ValueAnimator r1 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        if (r5 == false) goto L5;
        long r2 = 150;
    L6:
        r1.setDuration(r2);
        if (r5 == false) goto L9;
        long r3 = 75;
    L10:
        r1.setStartDelay(r3);
        r1.setInterpolator(ReversableAnimatedValueInterpolator.of(r5, AnimationUtils.LINEAR_INTERPOLATOR));
        r1.addUpdateListener(MultiViewUpdateListener.alphaListener(new View[]{this.divider, this.contentContainer}));
        return r1;
    L9:
        r3 = 0;
        goto L10
    L5:
        r2 = HIDE_CONTENT_ALPHA_DURATION_MS;
        goto L6
    }

    private Animator getDividerAnimator(boolean r7) {
        ValueAnimator r0 = ValueAnimator.ofFloat(new float[]{(this.contentContainer.getHeight() * 0.050000012f) / 2.0f, 0.0f});
        if (r7 == false) goto L5;
        long r4 = 300;
    L6:
        r0.setDuration(r4);
        r0.setInterpolator(ReversableAnimatedValueInterpolator.of(r7, AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR));
        r0.addUpdateListener(MultiViewUpdateListener.translationYListener(new View[]{this.divider}));
        return r0;
    L5:
        r4 = 250;
        goto L6
    }

    private Animator getContentScaleAnimator(boolean r4) {
        ValueAnimator r0 = ValueAnimator.ofFloat(new float[]{CONTENT_FROM_SCALE, 1.0f});
        if (r4 == false) goto L5;
        long r1 = 300;
    L6:
        r0.setDuration(r1);
        r0.setInterpolator(ReversableAnimatedValueInterpolator.of(r4, AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR));
        r0.addUpdateListener(MultiViewUpdateListener.scaleListener(new View[]{this.contentContainer}));
        return r0;
    L5:
        r1 = 250;
        goto L6
    }

    private Animator getTranslationAnimator(boolean r6, boolean r7, View r8) {
        if (r7 == false) goto L4;
        int r9 = getFromTranslationXStart(r8);
    L5:
        ValueAnimator r1 = ValueAnimator.ofFloat(new float[]{r9, 0.0f});
        r1.addUpdateListener(MultiViewUpdateListener.translationXListener(new View[]{r8}));
        ValueAnimator r5 = ValueAnimator.ofFloat(new float[]{getFromTranslationY(), 0.0f});
        r5.addUpdateListener(MultiViewUpdateListener.translationYListener(new View[]{r8}));
        AnimatorSet r10 = new AnimatorSet();
        r10.playTogether(new Animator[]{r1, r5});
        if (r6 == false) goto L8;
        long r0 = 300;
    L9:
        r10.setDuration(r0);
        r10.setInterpolator(ReversableAnimatedValueInterpolator.of(r6, AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR));
        return r10;
    L8:
        r0 = 250;
        goto L9
    L4:
        r9 = getFromTranslationXEnd(r8);
        goto L5
    }

    private int getFromTranslationXStart(View r3) {
        int r4 = MarginLayoutParamsCompat.getMarginStart((ViewGroup.MarginLayoutParams) r3.getLayoutParams());
        int r0 = ViewCompat.getPaddingStart(this.searchBar);
        if (ViewUtils.isLayoutRtl(this.searchBar) == false) goto L6;
        return ((this.searchBar.getWidth() - this.searchBar.getRight()) + r4) - r0;
    L6:
        return (this.searchBar.getLeft() - r4) + r0;
    }

    private int getFromTranslationXEnd(View r2) {
        int r3 = MarginLayoutParamsCompat.getMarginEnd((ViewGroup.MarginLayoutParams) r2.getLayoutParams());
        if (ViewUtils.isLayoutRtl(this.searchBar) == false) goto L6;
        return this.searchBar.getLeft() - r3;
    L6:
        return (this.searchBar.getRight() - this.searchView.getWidth()) + r3;
    }

    private int getFromTranslationY() {
        int r0 = (this.toolbarContainer.getTop() + this.toolbarContainer.getBottom()) / 2;
        return ((this.searchBar.getTop() + this.searchBar.getBottom()) / 2) - r0;
    }

    private void setUpDummyToolbarIfNeeded() {
        Menu r0 = this.dummyToolbar.getMenu();
        if (r0 == null) goto L6;
        r0.clear();
    L6:
        if (this.searchBar.getMenuResId() != (-1)) goto L8;
    L10:
        this.dummyToolbar.setVisibility(8);
        return;
    L8:
        if (this.searchView.isMenuItemsAnimated() == false) goto L10;
        this.dummyToolbar.inflateMenu(this.searchBar.getMenuResId());
        setMenuItemsNotClickable(this.dummyToolbar);
        this.dummyToolbar.setVisibility(0);
    }

    private void setMenuItemsNotClickable(Toolbar r3) {
        ActionMenuView r2 = ToolbarUtils.getActionMenuView(r3);
        if (r2 == null) goto L8;
        int r0 = 0;
    L6:
        if (r0 >= r2.getChildCount()) goto L10;
        View r1 = r2.getChildAt(r0);
        r1.setClickable(false);
        r1.setFocusable(false);
        r1.setFocusableInTouchMode(false);
        r0 = r0 + 1;
        goto L6
    L10:
        return;
    }
}
