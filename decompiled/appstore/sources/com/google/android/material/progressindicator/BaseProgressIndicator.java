package com.google.android.material.progressindicator;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ProgressBar;
import androidx.annotation.AttrRes;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.annotation.VisibleForTesting;
import androidx.core.view.ViewCompat;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import com.google.android.material.R;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.progressindicator.BaseProgressIndicatorSpec;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public abstract class BaseProgressIndicator<S extends BaseProgressIndicatorSpec> extends ProgressBar {
    static final float DEFAULT_OPACITY = 0.2f;
    static final int DEF_STYLE_RES = 0;
    public static final int HIDE_INWARD = 2;
    public static final int HIDE_NONE = 0;
    public static final int HIDE_OUTWARD = 1;
    static final int MAX_ALPHA = 255;
    static final int MAX_HIDE_DELAY = 1000;
    public static final int SHOW_INWARD = 2;
    public static final int SHOW_NONE = 0;
    public static final int SHOW_OUTWARD = 1;
    AnimatorDurationScaleProvider animatorDurationScaleProvider;
    private final Runnable delayedHide;
    private final Runnable delayedShow;
    private final Animatable2Compat.AnimationCallback hideAnimationCallback;
    private boolean isIndeterminateModeChangeRequested;
    private boolean isParentDoneInitializing;
    private long lastShowStartTime;
    private final int minHideDelay;
    private final int showDelay;
    S spec;
    private int storedProgress;
    private boolean storedProgressAnimated;
    private final Animatable2Compat.AnimationCallback switchIndeterminateModeCallback;
    private int visibilityAfterHide;

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface HideAnimationBehavior {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface ShowAnimationBehavior {
    }

    static {
        DEF_STYLE_RES = R.style.Widget_MaterialComponents_ProgressIndicator;
    }

    public BaseProgressIndicator(@NonNull Context r10, @Nullable AttributeSet r11, @AttrRes int r12, @StyleRes int r13) {
        super(MaterialThemeOverlay.wrap(r10, r11, r12, DEF_STYLE_RES), r11, r12);
        this.lastShowStartTime = -1;
        this.isIndeterminateModeChangeRequested = false;
        this.visibilityAfterHide = 4;
        this.delayedShow = new AnonymousClass1(this);
        this.delayedHide = new AnonymousClass2(this);
        this.switchIndeterminateModeCallback = new AnonymousClass3(this);
        this.hideAnimationCallback = new AnonymousClass4(this);
        Context r14 = getContext();
        this.spec = (S) createSpec(r14, r11);
        TypedArray r15 = ThemeEnforcement.obtainStyledAttributes(r14, r11, R.styleable.BaseProgressIndicator, r12, r13, new int[0]);
        this.showDelay = r15.getInt(R.styleable.BaseProgressIndicator_showDelay, -1);
        this.minHideDelay = Math.min(r15.getInt(R.styleable.BaseProgressIndicator_minHideDelay, -1), 1000);
        r15.recycle();
        this.animatorDurationScaleProvider = new AnimatorDurationScaleProvider();
        this.isParentDoneInitializing = true;
    }

    public static /* synthetic */ void access$000(BaseProgressIndicator r10) {
        r10.internalShow();
    }

    public static /* synthetic */ void access$100(BaseProgressIndicator r10) {
        r10.internalHide();
    }

    public static /* synthetic */ long access$202(BaseProgressIndicator r10, long r11) {
        r10.lastShowStartTime = r11;
        return r11;
    }

    public static /* synthetic */ int access$300(BaseProgressIndicator r10) {
        return r10.storedProgress;
    }

    public static /* synthetic */ boolean access$400(BaseProgressIndicator r10) {
        return r10.storedProgressAnimated;
    }

    public static /* synthetic */ boolean access$500(BaseProgressIndicator r10) {
        return r10.isIndeterminateModeChangeRequested;
    }

    public static /* synthetic */ int access$600(BaseProgressIndicator r10) {
        return r10.visibilityAfterHide;
    }

    @Nullable
    private DrawingDelegate<S> getCurrentDrawingDelegate() {
        if (isIndeterminate() == false) goto L10;
        if (getIndeterminateDrawable() != null) goto L8;
        return null;
    L8:
        return getIndeterminateDrawable().getDrawingDelegate();
    L10:
        if (getProgressDrawable() != null) goto L13;
        return null;
    L13:
        return getProgressDrawable().getDrawingDelegate();
    }

    private void internalHide() {
        ((DrawableWithAnimatedVisibilityChange) getCurrentDrawable()).setVisible(false, false, true);
        if (isNoLongerNeedToBeVisible() == false) goto L6;
        setVisibility(4);
        return;
    }

    private void internalShow() {
        if (this.minHideDelay <= 0) goto L5;
        this.lastShowStartTime = SystemClock.uptimeMillis();
    L5:
        setVisibility(0);
    }

    private boolean isNoLongerNeedToBeVisible() {
        if (getProgressDrawable() == null) goto L7;
        if (getProgressDrawable().isVisible() == false) goto L7;
    L11:
        return false;
    L7:
        if (getIndeterminateDrawable() != null) goto L9;
    L12:
        return true;
    L9:
        if (getIndeterminateDrawable().isVisible() == true) goto L11;
        goto L11
    }

    private void registerAnimationCallbacks() {
        if (getProgressDrawable() == null) goto L8;
        if (getIndeterminateDrawable() == null) goto L8;
        getIndeterminateDrawable().getAnimatorDelegate().registerAnimatorsCompleteCallback(this.switchIndeterminateModeCallback);
    L8:
        if (getProgressDrawable() == null) goto L11;
        getProgressDrawable().registerAnimationCallback(this.hideAnimationCallback);
    L11:
        if (getIndeterminateDrawable() == null) goto L14;
        getIndeterminateDrawable().registerAnimationCallback(this.hideAnimationCallback);
        return;
    }

    private void unregisterAnimationCallbacks() {
        if (getIndeterminateDrawable() == null) goto L6;
        getIndeterminateDrawable().unregisterAnimationCallback(this.hideAnimationCallback);
        getIndeterminateDrawable().getAnimatorDelegate().unregisterAnimatorsCompleteCallback();
    L6:
        if (getProgressDrawable() == null) goto L9;
        getProgressDrawable().unregisterAnimationCallback(this.hideAnimationCallback);
        return;
    }

    public void applyNewVisibility(boolean r10) {
        if (this.isParentDoneInitializing == true) goto L5;
        return;
    L5:
        ((DrawableWithAnimatedVisibilityChange) getCurrentDrawable()).setVisible(visibleToUser(), false, r10);
    }

    public abstract S createSpec(@NonNull Context r10, @NonNull AttributeSet r11);

    @Override // android.widget.ProgressBar
    @Nullable
    public Drawable getCurrentDrawable() {
        if (isIndeterminate() == false) goto L6;
        return getIndeterminateDrawable();
    L6:
        return getProgressDrawable();
    }

    public int getHideAnimationBehavior() {
        return this.spec.hideAnimationBehavior;
    }

    @Override // android.widget.ProgressBar
    @Nullable
    public /* bridge */ /* synthetic */ Drawable getIndeterminateDrawable() {
        return getIndeterminateDrawable();
    }

    @NonNull
    public int[] getIndicatorColor() {
        return this.spec.indicatorColors;
    }

    @Override // android.widget.ProgressBar
    @Nullable
    public /* bridge */ /* synthetic */ Drawable getProgressDrawable() {
        return getProgressDrawable();
    }

    public int getShowAnimationBehavior() {
        return this.spec.showAnimationBehavior;
    }

    @ColorInt
    public int getTrackColor() {
        return this.spec.trackColor;
    }

    @Px
    public int getTrackCornerRadius() {
        return this.spec.trackCornerRadius;
    }

    @Px
    public int getTrackThickness() {
        return this.spec.trackThickness;
    }

    public void hide() {
        if (getVisibility() == 0) goto L6;
        removeCallbacks(this.delayedShow);
        return;
    L6:
        removeCallbacks(this.delayedHide);
        long r10 = SystemClock.uptimeMillis() - this.lastShowStartTime;
        int r11 = this.minHideDelay;
        if (r10 < r11) goto L10;
        this.delayedHide.run();
        return;
    L10:
        postDelayed(this.delayedHide, ((long) r11) - r10);
    }

    @Override // android.view.View
    public void invalidate() {
        super.invalidate();
        if (getCurrentDrawable() == null) goto L6;
        getCurrentDrawable().invalidateSelf();
        return;
    }

    public boolean isEffectivelyVisible() {
        View r10 = this;
    L4:
        if (r10.getVisibility() != 0) goto L5;
        Object r11 = r10.getParent();
        if (r11 == null) goto L9;
        if ((r11 instanceof View) == false) goto L14;
        r10 = (View) r11;
        goto L4
    L14:
        return true;
    L9:
        if (getWindowVisibility() == 0) goto L11;
        return false;
    L11:
        return true;
    L5:
        return false;
    }

    @Override // android.widget.ProgressBar, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        registerAnimationCallbacks();
        if (visibleToUser() == false) goto L6;
        internalShow();
        return;
    }

    @Override // android.widget.ProgressBar, android.view.View
    public void onDetachedFromWindow() {
        removeCallbacks(this.delayedHide);
        removeCallbacks(this.delayedShow);
        ((DrawableWithAnimatedVisibilityChange) getCurrentDrawable()).hideNow();
        unregisterAnimationCallbacks();
        super.onDetachedFromWindow();
    }

    @Override // android.widget.ProgressBar, android.view.View
    public synchronized void onDraw(@NonNull Canvas r10) {
        monitor-enter(this);
        int r11 = r10.save();     // Catch: Throwable -> L8
        if (getPaddingLeft() == 0) goto L6;
    L10:
        r10.translate(getPaddingLeft(), getPaddingTop());     // Catch: Throwable -> L8
    L12:
        if (getPaddingRight() == 0) goto L14;
    L15:
        r10.clipRect(0, 0, getWidth() - (getPaddingLeft() + getPaddingRight()), getHeight() - (getPaddingTop() + getPaddingBottom()));     // Catch: Throwable -> L8
    L16:
        getCurrentDrawable().draw(r10);     // Catch: Throwable -> L8
        r10.restoreToCount(r11);     // Catch: Throwable -> L8
        monitor-exit(this);
        return;
    L14:
        if (getPaddingBottom() == 0) goto L16;
    L6:
        if (getPaddingTop() == 0) goto L12;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // android.widget.ProgressBar, android.view.View
    public synchronized void onMeasure(int r10, int r11) {
        monitor-enter(this);
        super.onMeasure(r10, r11);     // Catch: Throwable -> L10
        DrawingDelegate<S> r12 = getCurrentDrawingDelegate();     // Catch: Throwable -> L10
        if (r12 != null) goto L7;
        monitor-exit(this);
        return;
    L7:
        int r13 = r12.getPreferredWidth();     // Catch: Throwable -> L10
        int r14 = r12.getPreferredHeight();     // Catch: Throwable -> L10
        if (r13 >= 0) goto L12;
        int r15 = getMeasuredWidth();     // Catch: Throwable -> L10
    L13:
        if (r14 >= 0) goto L15;
        int r16 = getMeasuredHeight();     // Catch: Throwable -> L10
    L16:
        setMeasuredDimension(r15, r16);     // Catch: Throwable -> L10
        monitor-exit(this);
        return;
    L15:
        r16 = (r14 + getPaddingTop()) + getPaddingBottom();     // Catch: Throwable -> L10
        goto L16
    L12:
        r15 = (r13 + getPaddingLeft()) + getPaddingRight();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    @Override // android.view.View
    public void onVisibilityChanged(@NonNull View r10, int r11) {
        super.onVisibilityChanged(r10, r11);
        if (r11 != 0) goto L5;
        boolean r12 = true;
    L6:
        applyNewVisibility(r12);
        return;
    L5:
        r12 = false;
        goto L6
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int r10) {
        super.onWindowVisibilityChanged(r10);
        applyNewVisibility(false);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @VisibleForTesting
    public void setAnimatorDurationScaleProvider(@NonNull AnimatorDurationScaleProvider r10) {
        this.animatorDurationScaleProvider = r10;
        if (getProgressDrawable() == null) goto L6;
        getProgressDrawable().animatorDurationScaleProvider = r10;
    L6:
        if (getIndeterminateDrawable() == null) goto L9;
        getIndeterminateDrawable().animatorDurationScaleProvider = r10;
        return;
    }

    public void setHideAnimationBehavior(int r10) {
        this.spec.hideAnimationBehavior = r10;
        invalidate();
    }

    @Override // android.widget.ProgressBar
    public synchronized void setIndeterminate(boolean r10) {
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L4:
        if (r10 != isIndeterminate()) goto L8;
        monitor-exit(this);
        return;
    L8:
        if (visibleToUser() == false) goto L15;
        if (r10 == false) goto L15;
        throw new IllegalStateException("Cannot switch to indeterminate mode while the progress indicator is visible.");     // Catch: Throwable -> L13
    L15:
        DrawableWithAnimatedVisibilityChange r11 = (DrawableWithAnimatedVisibilityChange) getCurrentDrawable();     // Catch: Throwable -> L13
        if (r11 == null) goto L18;
        r11.hideNow();     // Catch: Throwable -> L13
    L18:
        super.setIndeterminate(r10);     // Catch: Throwable -> L13
        DrawableWithAnimatedVisibilityChange r12 = (DrawableWithAnimatedVisibilityChange) getCurrentDrawable();     // Catch: Throwable -> L13
        if (r12 == null) goto L21;
        r12.setVisible(visibleToUser(), false, false);     // Catch: Throwable -> L13
    L21:
        this.isIndeterminateModeChangeRequested = false;     // Catch: Throwable -> L13
        monitor-exit(this);
    }

    @Override // android.widget.ProgressBar
    public void setIndeterminateDrawable(@Nullable Drawable r10) {
        if (r10 != null) goto L6;
        super.setIndeterminateDrawable(null);
        return;
    L6:
        if ((r10 instanceof IndeterminateDrawable) == false) goto L10;
        ((DrawableWithAnimatedVisibilityChange) r10).hideNow();
        super.setIndeterminateDrawable(r10);
        return;
    L10:
        throw new IllegalArgumentException("Cannot set framework drawable as indeterminate drawable.");
    }

    public void setIndicatorColor(@ColorInt int... r10) {
        if (r10.length != 0) goto L6;
        r10 = new int[]{MaterialColors.getColor(getContext(), R.attr.colorPrimary, -1)};
    L6:
        if (Arrays.equals(getIndicatorColor(), r10) == true) goto L9;
        this.spec.indicatorColors = r10;
        getIndeterminateDrawable().getAnimatorDelegate().invalidateSpecValues();
        invalidate();
        return;
    }

    @Override // android.widget.ProgressBar
    public synchronized void setProgress(int r10) {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (isIndeterminate() == false) goto L8;
        monitor-exit(this);
        return;
    L8:
        setProgressCompat(r10, false);     // Catch: Throwable -> L11
        monitor-exit(this);
    }

    public void setProgressCompat(int r10, boolean r11) {
        if (isIndeterminate() == true) goto L5;
        super.setProgress(r10);
        if (getProgressDrawable() == null) goto L21;
        if (r11 == true) goto L22;
        getProgressDrawable().jumpToCurrentState();
        return;
    L22:
        return;
    L21:
        return;
    L5:
        if (getProgressDrawable() == null) goto L18;
        this.storedProgress = r10;
        this.storedProgressAnimated = r11;
        this.isIndeterminateModeChangeRequested = true;
        if (getIndeterminateDrawable().isVisible() == true) goto L9;
    L12:
        this.switchIndeterminateModeCallback.onAnimationEnd(getIndeterminateDrawable());
        return;
    L9:
        if (this.animatorDurationScaleProvider.getSystemAnimatorDurationScale(getContext().getContentResolver()) == 0.0f) goto L12;
        getIndeterminateDrawable().getAnimatorDelegate().requestCancelAnimatorAfterCurrentCycle();
        return;
    }

    @Override // android.widget.ProgressBar
    public void setProgressDrawable(@Nullable Drawable r10) {
        if (r10 != null) goto L6;
        super.setProgressDrawable(null);
        return;
    L6:
        if ((r10 instanceof DeterminateDrawable) == false) goto L10;
        DeterminateDrawable r11 = (DeterminateDrawable) r10;
        r11.hideNow();
        super.setProgressDrawable(r11);
        r11.setLevelByFraction(getProgress() / getMax());
        return;
    L10:
        throw new IllegalArgumentException("Cannot set framework drawable as progress drawable.");
    }

    public void setShowAnimationBehavior(int r10) {
        this.spec.showAnimationBehavior = r10;
        invalidate();
    }

    public void setTrackColor(@ColorInt int r10) {
        S r11 = this.spec;
        if (r11.trackColor == r10) goto L6;
        r11.trackColor = r10;
        invalidate();
        return;
    }

    public void setTrackCornerRadius(@Px int r10) {
        S r11 = this.spec;
        if (r11.trackCornerRadius == r10) goto L6;
        r11.trackCornerRadius = Math.min(r10, r11.trackThickness / 2);
        return;
    }

    public void setTrackThickness(@Px int r10) {
        S r11 = this.spec;
        if (r11.trackThickness == r10) goto L6;
        r11.trackThickness = r10;
        requestLayout();
        return;
    }

    public void setVisibilityAfterHide(int r10) {
        if (r10 != 0) goto L4;
    L10:
        this.visibilityAfterHide = r10;
        return;
    L4:
        if (r10 == 4) goto L10;
        if (r10 == 8) goto L10;
        throw new IllegalArgumentException("The component's visibility must be one of VISIBLE, INVISIBLE, and GONE defined in View.");
    }

    public void show() {
        if (this.showDelay <= 0) goto L5;
        removeCallbacks(this.delayedShow);
        postDelayed(this.delayedShow, this.showDelay);
        return;
    L5:
        this.delayedShow.run();
    }

    public boolean visibleToUser() {
        if (ViewCompat.S(this) == true) goto L5;
    L9:
        return false;
    L5:
        if (getWindowVisibility() != 0) goto L9;
        if (isEffectivelyVisible() == false) goto L9;
        return true;
    }

    @Override // android.widget.ProgressBar
    @Nullable
    public IndeterminateDrawable<S> getIndeterminateDrawable() {
        return (IndeterminateDrawable) super.getIndeterminateDrawable();
    }

    @Override // android.widget.ProgressBar
    @Nullable
    public DeterminateDrawable<S> getProgressDrawable() {
        return (DeterminateDrawable) super.getProgressDrawable();
    }
}
