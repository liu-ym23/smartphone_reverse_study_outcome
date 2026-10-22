package com.google.android.material.progressindicator;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.os.Build;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import com.google.android.material.progressindicator.b;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public final class IndeterminateDrawable<S extends b> extends DrawableWithAnimatedVisibilityChange {
    private g<ObjectAnimator> animatorDelegate;
    private f<S> drawingDelegate;

    @Override // com.google.android.material.progressindicator.DrawableWithAnimatedVisibilityChange, androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public /* bridge */ /* synthetic */ void clearAnimationCallbacks() {
        super.clearAnimationCallbacks();
    }

    @Override // com.google.android.material.progressindicator.DrawableWithAnimatedVisibilityChange, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getAlpha() {
        return super.getAlpha();
    }

    @Override // com.google.android.material.progressindicator.DrawableWithAnimatedVisibilityChange, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getOpacity() {
        return super.getOpacity();
    }

    @Override // com.google.android.material.progressindicator.DrawableWithAnimatedVisibilityChange
    public /* bridge */ /* synthetic */ boolean hideNow() {
        return super.hideNow();
    }

    @Override // com.google.android.material.progressindicator.DrawableWithAnimatedVisibilityChange
    public /* bridge */ /* synthetic */ boolean isHiding() {
        return super.isHiding();
    }

    @Override // com.google.android.material.progressindicator.DrawableWithAnimatedVisibilityChange, android.graphics.drawable.Animatable
    public /* bridge */ /* synthetic */ boolean isRunning() {
        return super.isRunning();
    }

    @Override // com.google.android.material.progressindicator.DrawableWithAnimatedVisibilityChange
    public /* bridge */ /* synthetic */ boolean isShowing() {
        return super.isShowing();
    }

    @Override // com.google.android.material.progressindicator.DrawableWithAnimatedVisibilityChange, androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public /* bridge */ /* synthetic */ void registerAnimationCallback(Animatable2Compat.a r1) {
        super.registerAnimationCallback(r1);
    }

    @Override // com.google.android.material.progressindicator.DrawableWithAnimatedVisibilityChange, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setAlpha(int r1) {
        super.setAlpha(r1);
    }

    @Override // com.google.android.material.progressindicator.DrawableWithAnimatedVisibilityChange, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setColorFilter(ColorFilter r1) {
        super.setColorFilter(r1);
    }

    @Override // com.google.android.material.progressindicator.DrawableWithAnimatedVisibilityChange, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean setVisible(boolean r1, boolean r2) {
        return super.setVisible(r1, r2);
    }

    @Override // com.google.android.material.progressindicator.DrawableWithAnimatedVisibilityChange
    public /* bridge */ /* synthetic */ boolean setVisible(boolean r1, boolean r2, boolean r3) {
        return super.setVisible(r1, r2, r3);
    }

    @Override // com.google.android.material.progressindicator.DrawableWithAnimatedVisibilityChange, android.graphics.drawable.Animatable
    public /* bridge */ /* synthetic */ void start() {
        super.start();
    }

    @Override // com.google.android.material.progressindicator.DrawableWithAnimatedVisibilityChange, android.graphics.drawable.Animatable
    public /* bridge */ /* synthetic */ void stop() {
        super.stop();
    }

    @Override // com.google.android.material.progressindicator.DrawableWithAnimatedVisibilityChange, androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public /* bridge */ /* synthetic */ boolean unregisterAnimationCallback(Animatable2Compat.a r1) {
        return super.unregisterAnimationCallback(r1);
    }

    IndeterminateDrawable(Context r3, b r4, f<S> r5, g<ObjectAnimator> r6) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), r4);
        setDrawingDelegate(r5);
        setAnimatorDelegate(r6);
    }

    public static IndeterminateDrawable<k> createLinearDrawable(Context r3, k r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        h r1 = new h(r4);
        if (r4.g != 0) goto L5;
        g r2 = new i(r4);
    L7:
        return new IndeterminateDrawable(r5, r4, r1, r2);
    L5:
        r2 = new j(r5, r4);
        goto L7
    }

    public static IndeterminateDrawable<e> createCircularDrawable(Context r3, e r4) {
        return new IndeterminateDrawable((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), r4, new c(r4), new d(r4));
    }

    @Override // com.google.android.material.progressindicator.DrawableWithAnimatedVisibilityChange
    boolean setVisibleInternal(boolean r3, boolean r4, boolean r5) {
        boolean r6 = super.setVisibleInternal(r3, r4, r5);
        if (isRunning() == true) goto L5;
        this.animatorDelegate.b();
    L5:
        float r0 = this.animatorDurationScaleProvider.a(this.context.getContentResolver());
        if (r3 == false) goto L13;
        if (r5 == false) goto L9;
    L12:
        this.animatorDelegate.a();
        goto L13
    L9:
        if (Build.VERSION.SDK_INT > 21) goto L13;
        if (r0 > 0.0f) goto L12;
    L13:
        return r6;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.drawingDelegate.a();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.drawingDelegate.b();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas r9) {
        Rect r0 = new Rect();
        if (getBounds().isEmpty() == false) goto L5;
        return;
    L5:
        if (isVisible() == true) goto L7;
        return;
    L7:
        if (r9.getClipBounds(r0) == false) goto L18;
        r9.save();
        this.drawingDelegate.b(r9, getGrowFraction());
        this.drawingDelegate.a(r9, this.paint);
        int r1 = 0;
    L11:
        if (r1 >= this.animatorDelegate.f13520d.length) goto L13;
        int r3 = r1 * 2;
        this.drawingDelegate.a(r9, this.paint, this.animatorDelegate.f13519c[r3], this.animatorDelegate.f13519c[r3 + 1], this.animatorDelegate.f13520d[r1]);
        r1 = r1 + 1;
        goto L11
    L13:
        r9.restore();
        return;
    }

    g<ObjectAnimator> getAnimatorDelegate() {
        return this.animatorDelegate;
    }

    void setAnimatorDelegate(g<ObjectAnimator> r1) {
        this.animatorDelegate = r1;
        r1.a(this);
    }

    f<S> getDrawingDelegate() {
        return this.drawingDelegate;
    }

    void setDrawingDelegate(f<S> r1) {
        this.drawingDelegate = r1;
        r1.a(this);
    }
}
