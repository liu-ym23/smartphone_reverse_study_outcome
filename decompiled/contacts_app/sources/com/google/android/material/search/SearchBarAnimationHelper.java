package com.google.android.material.search;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.ActionMenuView;
import androidx.core.view.ViewCompat;
import com.google.android.material.animation.AnimatableView;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.internal.ExpandCollapseAnimationHelper;
import com.google.android.material.internal.MultiViewUpdateListener;
import com.google.android.material.internal.ToolbarUtils;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.shape.MaterialShapeDrawable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
class SearchBarAnimationHelper {
    private static final long COLLAPSE_DURATION_MS = 250;
    private static final long COLLAPSE_FADE_IN_CHILDREN_DURATION_MS = 100;
    private static final long EXPAND_DURATION_MS = 300;
    private static final long EXPAND_FADE_OUT_CHILDREN_DURATION_MS = 75;
    private static final long ON_LOAD_ANIM_CENTER_VIEW_DEFAULT_FADE_DURATION_MS = 250;
    private static final long ON_LOAD_ANIM_CENTER_VIEW_DEFAULT_FADE_IN_START_DELAY_MS = 500;
    private static final long ON_LOAD_ANIM_CENTER_VIEW_DEFAULT_FADE_OUT_START_DELAY_MS = 750;
    private static final long ON_LOAD_ANIM_SECONDARY_DURATION_MS = 250;
    private static final long ON_LOAD_ANIM_SECONDARY_START_DELAY_MS = 250;
    private final Set<AnimatorListenerAdapter> collapseAnimationListeners;
    private boolean collapsing;
    private Animator defaultCenterViewAnimator;
    private final Set<AnimatorListenerAdapter> expandAnimationListeners;
    private boolean expanding;
    private final Set<SearchBar.OnLoadAnimationCallback> onLoadAnimationCallbacks;
    private boolean onLoadAnimationFadeInEnabled;
    private Animator runningExpandOrCollapseAnimator;
    private Animator secondaryViewAnimator;

    private interface OnLoadAnimationInvocation {
        void invoke(SearchBar.OnLoadAnimationCallback r1);
    }

    public static /* synthetic */ void $r8$lambda$iABKJ6kyZ69puyOjwiq34DXz3r0(Animator r0) {
        r0.start();
    }

    SearchBarAnimationHelper() {
        this.onLoadAnimationCallbacks = new LinkedHashSet();
        this.expandAnimationListeners = new LinkedHashSet();
        this.collapseAnimationListeners = new LinkedHashSet();
        this.onLoadAnimationFadeInEnabled = true;
        this.runningExpandOrCollapseAnimator = null;
    }

    static /* synthetic */ void access$000(SearchBarAnimationHelper r0, OnLoadAnimationInvocation r1) {
        r0.dispatchOnLoadAnimation(r1);
    }

    static /* synthetic */ boolean access$102(SearchBarAnimationHelper r0, boolean r1) {
        r0.expanding = r1;
        return r1;
    }

    static /* synthetic */ Animator access$202(SearchBarAnimationHelper r0, Animator r1) {
        r0.runningExpandOrCollapseAnimator = r1;
        return r1;
    }

    static /* synthetic */ boolean access$302(SearchBarAnimationHelper r0, boolean r1) {
        r0.collapsing = r1;
        return r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    void startOnLoadAnimation(SearchBar r5) {
        dispatchOnLoadAnimation(new SearchBarAnimationHelper$$ExternalSyntheticLambda3());
        TextView r0 = r5.getTextView();
        final View r1 = r5.getCenterView();
        View r6 = ToolbarUtils.getSecondaryActionMenuItemView(r5);
        final Animator r2 = getSecondaryViewAnimator(r0, r6);
        r2.addListener(new AnonymousClass1(this));
        this.secondaryViewAnimator = r2;
        r0.setAlpha(0.0f);
        if (r6 == null) goto L6;
        r6.setAlpha(0.0f);
    L6:
        if ((r1 instanceof AnimatableView) == false) goto L8;
        Objects.requireNonNull(r2);
        ((AnimatableView) r1).startAnimation(new SearchBarAnimationHelper$$ExternalSyntheticLambda4(r2));
        return;
    L8:
        if (r1 == 0) goto L10;
        r1.setAlpha(0.0f);
        r1.setVisibility(0);
        Animator r7 = getDefaultCenterViewAnimator(r1);
        this.defaultCenterViewAnimator = r7;
        r7.addListener(new AnonymousClass2(this, r1, r2));
        r7.start();
        return;
    L10:
        r2.start();
    }

    /* JADX WARN: Multi-variable type inference failed */
    void stopOnLoadAnimation(SearchBar r2) {
        Animator r0 = this.secondaryViewAnimator;
        if (r0 == null) goto L5;
        r0.end();
    L5:
        Animator r1 = this.defaultCenterViewAnimator;
        if (r1 == null) goto L8;
        r1.end();
    L8:
        View r3 = r2.getCenterView();
        if ((r3 instanceof AnimatableView) == false) goto L11;
        ((AnimatableView) r3).stopAnimation();
    L11:
        if (r3 == 0) goto L14;
        r3.setAlpha(0.0f);
        return;
    }

    boolean isOnLoadAnimationFadeInEnabled() {
        return this.onLoadAnimationFadeInEnabled;
    }

    void setOnLoadAnimationFadeInEnabled(boolean r1) {
        this.onLoadAnimationFadeInEnabled = r1;
    }

    void addOnLoadAnimationCallback(SearchBar.OnLoadAnimationCallback r1) {
        this.onLoadAnimationCallbacks.add(r1);
    }

    boolean removeOnLoadAnimationCallback(SearchBar.OnLoadAnimationCallback r1) {
        return this.onLoadAnimationCallbacks.remove(r1);
    }

    private void dispatchOnLoadAnimation(OnLoadAnimationInvocation r2) {
        Iterator<SearchBar.OnLoadAnimationCallback> r1 = this.onLoadAnimationCallbacks.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r2.invoke(r1.next());
        goto L4
    }

    private Animator getDefaultCenterViewAnimator(View r12) {
        ValueAnimator r1 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r1.addUpdateListener(MultiViewUpdateListener.alphaListener(new View[]{r12}));
        r1.setInterpolator(AnimationUtils.LINEAR_INTERPOLATOR);
        long r7 = 0;
        if (this.onLoadAnimationFadeInEnabled == false) goto L5;
        long r9 = 250;
    L6:
        r1.setDuration(r9);
        if (this.onLoadAnimationFadeInEnabled == false) goto L9;
        r7 = 500;
    L9:
        r1.setStartDelay(r7);
        ValueAnimator r11 = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
        r11.addUpdateListener(MultiViewUpdateListener.alphaListener(new View[]{r12}));
        r11.setInterpolator(AnimationUtils.LINEAR_INTERPOLATOR);
        r11.setDuration(250);
        r11.setStartDelay(750);
        AnimatorSet r13 = new AnimatorSet();
        r13.playSequentially(new Animator[]{r1, r11});
        return r13;
    L5:
        r9 = 0;
        goto L6
    }

    private Animator getSecondaryViewAnimator(TextView r4, View r5) {
        AnimatorSet r0 = new AnimatorSet();
        r0.setStartDelay(250);
        r0.play(getTextViewAnimator(r4));
        if (r5 == null) goto L5;
        r0.play(getSecondaryActionMenuItemAnimator(r5));
    L5:
        return r0;
    }

    private Animator getTextViewAnimator(TextView r3) {
        ValueAnimator r2 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r2.addUpdateListener(MultiViewUpdateListener.alphaListener(new View[]{r3}));
        r2.setInterpolator(AnimationUtils.LINEAR_INTERPOLATOR);
        r2.setDuration(250);
        return r2;
    }

    private Animator getSecondaryActionMenuItemAnimator(View r3) {
        ValueAnimator r2 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r2.addUpdateListener(MultiViewUpdateListener.alphaListener(new View[]{r3}));
        r2.setInterpolator(AnimationUtils.LINEAR_INTERPOLATOR);
        r2.setDuration(250);
        return r2;
    }

    void startExpandAnimation(final SearchBar r8, final View r9, final AppBarLayout r10, final boolean r11) {
        if (isCollapsing() == false) goto L7;
        Animator r0 = this.runningExpandOrCollapseAnimator;
        if (r0 == null) goto L7;
        r0.cancel();
    L7:
        this.expanding = true;
        r9.setVisibility(4);
        r9.post(new SearchBarAnimationHelper$$ExternalSyntheticLambda0(this, r8, r9, r10, r11));
    }

    /* JADX INFO: renamed from: lambda$startExpandAnimation$0$com-google-android-material-search-SearchBarAnimationHelper, reason: not valid java name */
    /* synthetic */ void m254x1b96b119(SearchBar r3, View r4, AppBarLayout r5, boolean r6) {
        AnimatorSet r0 = new AnimatorSet();
        r0.playSequentially(new Animator[]{getFadeOutChildrenAnimator(r3, r4), getExpandAnimator(r3, r4, r5)});
        r0.addListener(new AnonymousClass3(this));
        Iterator<AnimatorListenerAdapter> r7 = this.expandAnimationListeners.iterator();
    L4:
        if (r7.hasNext() == false) goto L6;
        r0.addListener(r7.next());
        goto L4
    L6:
        if (r6 == false) goto L8;
        r0.setDuration(0);
    L8:
        r0.start();
        this.runningExpandOrCollapseAnimator = r0;
    }

    private Animator getExpandAnimator(final SearchBar r3, View r4, AppBarLayout r5) {
        return getExpandCollapseAnimationHelper(r3, r4, r5).setDuration(300).addListener(new AnonymousClass4(this, r3)).getExpandAnimator();
    }

    boolean isExpanding() {
        return this.expanding;
    }

    void addExpandAnimationListener(AnimatorListenerAdapter r1) {
        this.expandAnimationListeners.add(r1);
    }

    boolean removeExpandAnimationListener(AnimatorListenerAdapter r1) {
        return this.expandAnimationListeners.remove(r1);
    }

    void startCollapseAnimation(SearchBar r4, View r5, AppBarLayout r6, boolean r7) {
        if (isExpanding() == false) goto L7;
        Animator r0 = this.runningExpandOrCollapseAnimator;
        if (r0 == null) goto L7;
        r0.cancel();
    L7:
        this.collapsing = true;
        AnimatorSet r1 = new AnimatorSet();
        r1.playSequentially(new Animator[]{getCollapseAnimator(r4, r5, r6), getFadeInChildrenAnimator(r4)});
        r1.addListener(new AnonymousClass5(this));
        Iterator<AnimatorListenerAdapter> r8 = this.collapseAnimationListeners.iterator();
    L9:
        if (r8.hasNext() == false) goto L11;
        r1.addListener(r8.next());
        goto L9
    L11:
        if (r7 == false) goto L13;
        r1.setDuration(0);
    L13:
        r1.start();
        this.runningExpandOrCollapseAnimator = r1;
    }

    private Animator getCollapseAnimator(final SearchBar r3, View r4, AppBarLayout r5) {
        return getExpandCollapseAnimationHelper(r3, r4, r5).setDuration(250).addListener(new AnonymousClass6(this, r3)).getCollapseAnimator();
    }

    boolean isCollapsing() {
        return this.collapsing;
    }

    void addCollapseAnimationListener(AnimatorListenerAdapter r1) {
        this.collapseAnimationListeners.add(r1);
    }

    boolean removeCollapseAnimationListener(AnimatorListenerAdapter r1) {
        return this.collapseAnimationListeners.remove(r1);
    }

    private ExpandCollapseAnimationHelper getExpandCollapseAnimationHelper(SearchBar r2, View r3, AppBarLayout r4) {
        ExpandCollapseAnimationHelper r5 = new ExpandCollapseAnimationHelper(r2, r3).setAdditionalUpdateListener(getExpandedViewBackgroundUpdateListener(r2, r3));
        if (r4 == null) goto L5;
        int r6 = r4.getTop();
    L7:
        return r5.setCollapsedViewOffsetY(r6).addEndAnchoredViews(getEndAnchoredViews(r3));
    L5:
        r6 = 0;
        goto L7
    }

    private ValueAnimator.AnimatorUpdateListener getExpandedViewBackgroundUpdateListener(SearchBar r2, final View r3) {
        final MaterialShapeDrawable r1 = MaterialShapeDrawable.createWithElevationOverlay(r3.getContext());
        r1.setCornerSize(r2.getCornerSize());
        r1.setElevation(ViewCompat.getElevation(r2));
        return new SearchBarAnimationHelper$$ExternalSyntheticLambda1(r1, r3);
    }

    static /* synthetic */ void lambda$getExpandedViewBackgroundUpdateListener$1(MaterialShapeDrawable r1, View r2, ValueAnimator r3) {
        r1.setInterpolation(1.0f - r3.getAnimatedFraction());
        ViewCompat.setBackground(r2, r1);
        r2.setAlpha(1.0f);
    }

    private Animator getFadeOutChildrenAnimator(SearchBar r3, final View r4) {
        List<View> r2 = getFadeChildren(r3);
        ValueAnimator r5 = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
        r5.addUpdateListener(MultiViewUpdateListener.alphaListener(r2));
        r5.addUpdateListener(new SearchBarAnimationHelper$$ExternalSyntheticLambda2(r4));
        r5.setDuration(75);
        r5.setInterpolator(AnimationUtils.LINEAR_INTERPOLATOR);
        return r5;
    }

    static /* synthetic */ void lambda$getFadeOutChildrenAnimator$2(View r0, ValueAnimator r1) {
        r0.setAlpha(0.0f);
    }

    private Animator getFadeInChildrenAnimator(SearchBar r3) {
        List<View> r2 = getFadeChildren(r3);
        ValueAnimator r4 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r4.addUpdateListener(MultiViewUpdateListener.alphaListener(r2));
        r4.setDuration(100);
        r4.setInterpolator(AnimationUtils.LINEAR_INTERPOLATOR);
        return r4;
    }

    private List<View> getFadeChildren(SearchBar r2) {
        List<View> r1 = ViewUtils.getChildren(r2);
        if (r2.getCenterView() == null) goto L5;
        r1.remove(r2.getCenterView());
    L5:
        return r1;
    }

    private List<View> getEndAnchoredViews(View r5) {
        boolean r4 = ViewUtils.isLayoutRtl(r5);
        ArrayList r0 = new ArrayList();
        if ((r5 instanceof ViewGroup) == false) goto L16;
        ViewGroup r6 = (ViewGroup) r5;
        int r1 = 0;
    L6:
        if (r1 >= r6.getChildCount()) goto L16;
        View r2 = r6.getChildAt(r1);
        if (r4 == false) goto L10;
    L11:
        if (r4 == false) goto L15;
        if ((r2 instanceof ActionMenuView) == true) goto L15;
    L14:
        r0.add(r2);
    L15:
        r1 = r1 + 1;
        goto L6
    L10:
        if ((r2 instanceof ActionMenuView) == true) goto L14;
    L16:
        return r0;
    }
}
