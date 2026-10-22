package com.google.android.material.progressindicator;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import android.widget.ProgressBar;
import androidx.core.view.ViewCompat;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import com.google.android.material.internal.l;
import com.google.android.material.progressindicator.b;
import com.obric.aiagent.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public abstract class BaseProgressIndicator<S extends b> extends ProgressBar {
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
    a animatorDurationScaleProvider;
    private final Runnable delayedHide;
    private final Runnable delayedShow;
    private final Animatable2Compat.a hideAnimationCallback;
    private boolean isIndeterminateModeChangeRequested;
    private boolean isParentDoneInitializing;
    private long lastShowStartTime;
    private final int minHideDelay;
    private final int showDelay;
    S spec;
    private int storedProgress;
    private boolean storedProgressAnimated;
    private final Animatable2Compat.a switchIndeterminateModeCallback;
    private int visibilityAfterHide;

    abstract S createSpec(Context r1, AttributeSet r2);

    static /* synthetic */ void access$000(BaseProgressIndicator r0) {
        r0.internalShow();
    }

    static /* synthetic */ void access$100(BaseProgressIndicator r0) {
        r0.internalHide();
    }

    static /* synthetic */ long access$202(BaseProgressIndicator r0, long r1) {
        r0.lastShowStartTime = r1;
        return r1;
    }

    static /* synthetic */ int access$300(BaseProgressIndicator r0) {
        return r0.storedProgress;
    }

    static /* synthetic */ boolean access$400(BaseProgressIndicator r0) {
        return r0.storedProgressAnimated;
    }

    static /* synthetic */ boolean access$500(BaseProgressIndicator r0) {
        return r0.isIndeterminateModeChangeRequested;
    }

    static /* synthetic */ int access$600(BaseProgressIndicator r0) {
        return r0.visibilityAfterHide;
    }

    @Override // android.widget.ProgressBar
    public /* bridge */ /* synthetic */ Drawable getIndeterminateDrawable() {
        return getIndeterminateDrawable();
    }

    @Override // android.widget.ProgressBar
    public /* bridge */ /* synthetic */ Drawable getProgressDrawable() {
        return getProgressDrawable();
    }

    static {
        DEF_STYLE_RES = ZeusTransformUtils.mapRes(R.style.Widget_MaterialComponents_ProgressIndicator, "style", "Widget_MaterialComponents_ProgressIndicator");
    }

    public BaseProgressIndicator(Context r9, AttributeSet r10, int r11, int r12) {
        Context r13 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r3 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.aiagent.plugin");
        super((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.google.android.material.theme.a.a.a(r13, r3, r11, DEF_STYLE_RES), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r3, r11);
        this.lastShowStartTime = -1;
        this.isIndeterminateModeChangeRequested = false;
        this.visibilityAfterHide = 4;
        this.delayedShow = new AnonymousClass1(this);
        this.delayedHide = new AnonymousClass2(this);
        this.switchIndeterminateModeCallback = new AnonymousClass3(this);
        this.hideAnimationCallback = new AnonymousClass4(this);
        Context r2 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        this.spec = (S) createSpec(r2, r3);
        TypedArray r14 = l.a(r2, r3, R.styleable.BaseProgressIndicator, r11, r12, new int[0]);
        this.showDelay = r14.getInt(ZeusTransformUtils.mapRes(R.styleable.BaseProgressIndicator_showDelay, "styleable", "BaseProgressIndicator_showDelay"), -1);
        this.minHideDelay = Math.min(r14.getInt(ZeusTransformUtils.mapRes(R.styleable.BaseProgressIndicator_minHideDelay, "styleable", "BaseProgressIndicator_minHideDelay"), -1), 1000);
        r14.recycle();
        this.animatorDurationScaleProvider = new a();
        this.isParentDoneInitializing = true;
    }

    private void registerAnimationCallbacks() {
        if (getProgressDrawable() == null) goto L8;
        if (getIndeterminateDrawable() == null) goto L8;
        getIndeterminateDrawable().getAnimatorDelegate().a(this.switchIndeterminateModeCallback);
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
        getIndeterminateDrawable().getAnimatorDelegate().e();
    L6:
        if (getProgressDrawable() == null) goto L9;
        getProgressDrawable().unregisterAnimationCallback(this.hideAnimationCallback);
        return;
    }

    public void show() {
        if (this.showDelay <= 0) goto L5;
        removeCallbacks(this.delayedShow);
        postDelayed(this.delayedShow, this.showDelay);
        return;
    L5:
        this.delayedShow.run();
    }

    private void internalShow() {
        if (this.minHideDelay <= 0) goto L5;
        this.lastShowStartTime = SystemClock.uptimeMillis();
    L5:
        setVisibility(0);
    }

    public void hide() {
        if (getVisibility() == 0) goto L6;
        removeCallbacks(this.delayedShow);
        return;
    L6:
        removeCallbacks(this.delayedHide);
        long r0 = SystemClock.uptimeMillis() - this.lastShowStartTime;
        int r2 = this.minHideDelay;
        if (r0 < r2) goto L9;
        boolean r3 = true;
    L10:
        if (r3 == false) goto L13;
        this.delayedHide.run();
        return;
    L13:
        postDelayed(this.delayedHide, ((long) r2) - r0);
        return;
    L9:
        r3 = false;
        goto L10
    }

    private void internalHide() {
        ((DrawableWithAnimatedVisibilityChange) ZeusTransformUtils.preCheckCast(getCurrentDrawable(), DrawableWithAnimatedVisibilityChange.class, "com.obric.aiagent.plugin")).setVisible(false, false, true);
        if (isNoLongerNeedToBeVisible() == false) goto L6;
        setVisibility(4);
        return;
    }

    @Override // android.view.View
    public void onVisibilityChanged(View r1, int r2) {
        super.onVisibilityChanged(r1, r2);
        if (r2 != 0) goto L5;
        boolean r3 = true;
    L6:
        applyNewVisibility(r3);
        return;
    L5:
        r3 = false;
        goto L6
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int r1) {
        super.onWindowVisibilityChanged(r1);
        applyNewVisibility(false);
    }

    public void applyNewVisibility(boolean r4) {
        if (this.isParentDoneInitializing == true) goto L5;
        return;
    L5:
        ((DrawableWithAnimatedVisibilityChange) ZeusTransformUtils.preCheckCast(getCurrentDrawable(), DrawableWithAnimatedVisibilityChange.class, "com.obric.aiagent.plugin")).setVisible(visibleToUser(), false, r4);
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
        ((DrawableWithAnimatedVisibilityChange) ZeusTransformUtils.preCheckCast(getCurrentDrawable(), DrawableWithAnimatedVisibilityChange.class, "com.obric.aiagent.plugin")).hideNow();
        unregisterAnimationCallbacks();
        super.onDetachedFromWindow();
    }

    @Override // android.widget.ProgressBar, android.view.View
    public synchronized void onDraw(Canvas r6) {
        monitor-enter(this);
        int r0 = r6.save();     // Catch: Throwable -> L16
        if (getPaddingLeft() == 0) goto L6;
    L7:
        r6.translate(getPaddingLeft(), getPaddingTop());     // Catch: Throwable -> L16
    L9:
        if (getPaddingRight() == 0) goto L11;
    L12:
        r6.clipRect(0, 0, getWidth() - (getPaddingLeft() + getPaddingRight()), getHeight() - (getPaddingTop() + getPaddingBottom()));     // Catch: Throwable -> L16
    L13:
        getCurrentDrawable().draw(r6);     // Catch: Throwable -> L16
        r6.restoreToCount(r0);     // Catch: Throwable -> L16
        monitor-exit(this);
        return;
    L11:
        if (getPaddingBottom() == 0) goto L13;
    L6:
        if (getPaddingTop() == 0) goto L9;
    L16:
        th = move-exception;
        throw th;
    }

    @Override // android.widget.ProgressBar, android.view.View
    public synchronized void onMeasure(int r2, int r3) {
        monitor-enter(this);
        super.onMeasure(r2, r3);     // Catch: Throwable -> L17
        f<S> r4 = getCurrentDrawingDelegate();     // Catch: Throwable -> L17
        if (r4 != null) goto L7;
        monitor-exit(this);
        return;
    L7:
        int r5 = r4.a();     // Catch: Throwable -> L17
        int r6 = r4.b();     // Catch: Throwable -> L17
        if (r5 >= 0) goto L10;
        int r7 = getMeasuredWidth();     // Catch: Throwable -> L17
    L11:
        if (r6 >= 0) goto L13;
        int r8 = getMeasuredHeight();     // Catch: Throwable -> L17
    L14:
        setMeasuredDimension(r7, r8);     // Catch: Throwable -> L17
        monitor-exit(this);
        return;
    L13:
        r8 = (r6 + getPaddingTop()) + getPaddingBottom();     // Catch: Throwable -> L17
        goto L14
    L10:
        r7 = (r5 + getPaddingLeft()) + getPaddingRight();     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        throw th;
    }

    @Override // android.view.View
    public void invalidate() {
        super.invalidate();
        if (getCurrentDrawable() == null) goto L6;
        getCurrentDrawable().invalidateSelf();
        return;
    }

    @Override // android.widget.ProgressBar
    public Drawable getCurrentDrawable() {
        if (isIndeterminate() == false) goto L6;
        return getIndeterminateDrawable();
    L6:
        return getProgressDrawable();
    }

    private f<S> getCurrentDrawingDelegate() {
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

    @Override // android.widget.ProgressBar
    public void setProgressDrawable(Drawable r3) {
        if (r3 != null) goto L6;
        super.setProgressDrawable(null);
        return;
    L6:
        if (ZeusTransformUtils.instanceOf(r3, DeterminateDrawable.class) == false) goto L10;
        DeterminateDrawable r4 = (DeterminateDrawable) ZeusTransformUtils.preCheckCast(r3, DeterminateDrawable.class, "com.obric.aiagent.plugin");
        r4.hideNow();
        super.setProgressDrawable(r4);
        r4.setLevelByFraction(getProgress() / getMax());
        return;
    L10:
        throw new IllegalArgumentException("Cannot set framework drawable as progress drawable.");
    }

    @Override // android.widget.ProgressBar
    public void setIndeterminateDrawable(Drawable r3) {
        if (r3 != null) goto L6;
        super.setIndeterminateDrawable(null);
        return;
    L6:
        if (ZeusTransformUtils.instanceOf(r3, IndeterminateDrawable.class) == false) goto L10;
        ((DrawableWithAnimatedVisibilityChange) ZeusTransformUtils.preCheckCast(r3, DrawableWithAnimatedVisibilityChange.class, "com.obric.aiagent.plugin")).hideNow();
        super.setIndeterminateDrawable(r3);
        return;
    L10:
        throw new IllegalArgumentException("Cannot set framework drawable as indeterminate drawable.");
    }

    @Override // android.widget.ProgressBar
    public DeterminateDrawable<S> getProgressDrawable() {
        return (DeterminateDrawable) ZeusTransformUtils.preCheckCast(super.getProgressDrawable(), DeterminateDrawable.class, "com.obric.aiagent.plugin");
    }

    @Override // android.widget.ProgressBar
    public IndeterminateDrawable<S> getIndeterminateDrawable() {
        return (IndeterminateDrawable) ZeusTransformUtils.preCheckCast(super.getIndeterminateDrawable(), IndeterminateDrawable.class, "com.obric.aiagent.plugin");
    }

    boolean visibleToUser() {
        if (ViewCompat.I(this) == true) goto L5;
    L9:
        return false;
    L5:
        if (getWindowVisibility() != 0) goto L9;
        if (isEffectivelyVisible() == false) goto L9;
        return true;
    }

    boolean isEffectivelyVisible() {
        View r0 = this;
    L4:
        if (r0.getVisibility() != 0) goto L5;
        ViewParent r1 = r0.getParent();
        if (r1 == null) goto L9;
        if (ZeusTransformUtils.instanceOf(r1, View.class) == false) goto L14;
        r0 = (View) ZeusTransformUtils.preCheckCast(r1, View.class, "com.obric.aiagent.plugin");
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

    @Override // android.widget.ProgressBar
    public synchronized void setIndeterminate(boolean r4) {
        monitor-enter(this);
    L21:
        th = move-exception;
        throw th;
    L4:
        if (r4 != isIndeterminate()) goto L7;
        monitor-exit(this);
        return;
    L7:
        DrawableWithAnimatedVisibilityChange r0 = (DrawableWithAnimatedVisibilityChange) ZeusTransformUtils.preCheckCast(getCurrentDrawable(), DrawableWithAnimatedVisibilityChange.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L21
        if (r0 == null) goto L10;
        r0.hideNow();     // Catch: Throwable -> L21
    L10:
        super.setIndeterminate(r4);     // Catch: Throwable -> L21
        DrawableWithAnimatedVisibilityChange r5 = (DrawableWithAnimatedVisibilityChange) ZeusTransformUtils.preCheckCast(getCurrentDrawable(), DrawableWithAnimatedVisibilityChange.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L21
        if (r5 == null) goto L14;
        r5.setVisible(visibleToUser(), false, false);     // Catch: Throwable -> L21
    L14:
        if (ZeusTransformUtils.instanceOf(r5, IndeterminateDrawable.class) == true) goto L16;
    L18:
        this.isIndeterminateModeChangeRequested = false;     // Catch: Throwable -> L21
        monitor-exit(this);
        return;
    L16:
        if (visibleToUser() == false) goto L18;
        ((IndeterminateDrawable) ZeusTransformUtils.preCheckCast(r5, IndeterminateDrawable.class, "com.obric.aiagent.plugin")).getAnimatorDelegate().a();     // Catch: Throwable -> L21
        goto L18
    }

    public int getTrackThickness() {
        return this.spec.f13506a;
    }

    public void setTrackThickness(int r2) {
        if (this.spec.f13506a == r2) goto L6;
        this.spec.f13506a = r2;
        requestLayout();
        return;
    }

    public int[] getIndicatorColor() {
        return this.spec.f13508c;
    }

    public void setIndicatorColor(int... r6) {
        if (r6.length != 0) goto L6;
        r6 = new int[]{com.google.android.material.color.b.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), ZeusTransformUtils.mapRes(R.attr.colorPrimary, "attr", "colorPrimary"), -1)};
    L6:
        if (Arrays.equals(getIndicatorColor(), r6) == true) goto L9;
        this.spec.f13508c = r6;
        getIndeterminateDrawable().getAnimatorDelegate().d();
        invalidate();
        return;
    }

    public int getTrackColor() {
        return this.spec.f13509d;
    }

    public void setTrackColor(int r2) {
        if (this.spec.f13509d == r2) goto L6;
        this.spec.f13509d = r2;
        invalidate();
        return;
    }

    public int getTrackCornerRadius() {
        return this.spec.f13507b;
    }

    public void setTrackCornerRadius(int r2) {
        if (this.spec.f13507b == r2) goto L6;
        S r1 = this.spec;
        r1.f13507b = Math.min(r2, r1.f13506a / 2);
        return;
    }

    public int getShowAnimationBehavior() {
        return this.spec.f13510e;
    }

    public void setShowAnimationBehavior(int r2) {
        this.spec.f13510e = r2;
        invalidate();
    }

    public int getHideAnimationBehavior() {
        return this.spec.f;
    }

    public void setHideAnimationBehavior(int r2) {
        this.spec.f = r2;
        invalidate();
    }

    @Override // android.widget.ProgressBar
    public synchronized void setProgress(int r2) {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (isIndeterminate() == false) goto L8;
        monitor-exit(this);
        return;
    L8:
        setProgressCompat(r2, false);     // Catch: Throwable -> L11
        monitor-exit(this);
    }

    public void setProgressCompat(int r3, boolean r4) {
        if (isIndeterminate() == true) goto L5;
        super.setProgress(r3);
        if (getProgressDrawable() == null) goto L21;
        if (r4 == true) goto L22;
        getProgressDrawable().jumpToCurrentState();
        return;
    L22:
        return;
    L21:
        return;
    L5:
        if (getProgressDrawable() == null) goto L18;
        this.storedProgress = r3;
        this.storedProgressAnimated = r4;
        this.isIndeterminateModeChangeRequested = true;
        if (getIndeterminateDrawable().isVisible() == true) goto L9;
    L12:
        this.switchIndeterminateModeCallback.b(getIndeterminateDrawable());
        return;
    L9:
        if (this.animatorDurationScaleProvider.a(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getContentResolver()) == 0.0f) goto L12;
        getIndeterminateDrawable().getAnimatorDelegate().c();
        return;
    }

    public void setVisibilityAfterHide(int r2) {
        if (r2 != 0) goto L4;
    L10:
        this.visibilityAfterHide = r2;
        return;
    L4:
        if (r2 == 4) goto L10;
        if (r2 == 8) goto L10;
        throw new IllegalArgumentException("The component's visibility must be one of VISIBLE, INVISIBLE, and GONE defined in View.");
    }

    public void setAnimatorDurationScaleProvider(a r2) {
        this.animatorDurationScaleProvider = r2;
        if (getProgressDrawable() == null) goto L6;
        getProgressDrawable().animatorDurationScaleProvider = r2;
    L6:
        if (getIndeterminateDrawable() == null) goto L9;
        getIndeterminateDrawable().animatorDurationScaleProvider = r2;
        return;
    }
}
