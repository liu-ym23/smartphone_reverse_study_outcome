package com.android.server.wm;

import android.view.SurfaceControl;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;

/* JADX INFO: loaded from: classes3.dex */
public class NavBarFadeAnimationController extends FadeAnimationController {
    private static final int FADE_IN_DURATION = 266;
    private static final Interpolator FADE_IN_INTERPOLATOR = null;
    private static final int FADE_OUT_DURATION = 133;
    private static final Interpolator FADE_OUT_INTERPOLATOR = null;
    private Animation mFadeInAnimation;
    private SurfaceControl mFadeInParent;
    private Animation mFadeOutAnimation;
    private SurfaceControl mFadeOutParent;
    private final WindowState mNavigationBar;
    private boolean mPlaySequentially;

    protected class NavFadeAnimationAdapter extends FadeAnimationController.FadeAnimationAdapter {
        private SurfaceControl mParent;
        final /* synthetic */ NavBarFadeAnimationController this$0;

        NavFadeAnimationAdapter(NavBarFadeAnimationController this$0, LocalAnimationAdapter.AnimationSpec windowAnimationSpec, SurfaceAnimationRunner surfaceAnimationRunner, boolean show, WindowToken token, SurfaceControl parent) {
            this.this$0 = this$0;
            super(windowAnimationSpec, surfaceAnimationRunner, show, token);
            this.mParent = parent;
        }

        @Override // com.android.server.wm.LocalAnimationAdapter, com.android.server.wm.AnimationAdapter
        public void startAnimation(SurfaceControl animationLeash, SurfaceControl.Transaction t, int type, SurfaceAnimator.OnAnimationFinishedCallback finishCallback) {
            super.startAnimation(animationLeash, t, type, finishCallback);
            if (this.mParent != null) goto L5;
            return;
        L5:
            if (this.mParent.isValid() == false) goto L9;
            t.reparent(animationLeash, this.mParent);
            t.setLayer(animationLeash, Integer.MAX_VALUE);
            return;
        }

        @Override // com.android.server.wm.FadeAnimationController.FadeAnimationAdapter, com.android.server.wm.AnimationAdapter
        public boolean shouldDeferAnimationFinish(Runnable endDeferFinishCallback) {
            if (NavBarFadeAnimationController.m10067$$Nest$fgetmPlaySequentially(this.this$0) == false) goto L10;
            if (this.mShow == true) goto L11;
            this.this$0.fadeWindowToken(true);
            return false;
        L11:
            return false;
        L10:
            return super.shouldDeferAnimationFinish(endDeferFinishCallback);
        }
    }

    public static /* synthetic */ void $r8$lambda$KSYs3yqTT0Il8dxY7XZLFA2UAz8(NavBarFadeAnimationController r0, boolean r1) {
        r0.lambda$fadeWindowToken$0(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmPlaySequentially, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m10067$$Nest$fgetmPlaySequentially(NavBarFadeAnimationController r0) {
        return r0.mPlaySequentially;
    }

    static {
        FADE_IN_INTERPOLATOR = new PathInterpolator(0.0f, 0.0f, 0.0f, 1.0f);
        FADE_OUT_INTERPOLATOR = new PathInterpolator(0.2f, 0.0f, 1.0f, 1.0f);
    }

    public NavBarFadeAnimationController(DisplayContent displayContent) {
        super(displayContent);
        this.mPlaySequentially = false;
        this.mNavigationBar = displayContent.getDisplayPolicy().getNavigationBar();
        this.mFadeInAnimation = new AlphaAnimation(0.0f, 1.0f);
        this.mFadeInAnimation.setDuration(266);
        this.mFadeInAnimation.setInterpolator(FADE_IN_INTERPOLATOR);
        this.mFadeOutAnimation = new AlphaAnimation(1.0f, 0.0f);
        this.mFadeOutAnimation.setDuration(133);
        this.mFadeOutAnimation.setInterpolator(FADE_OUT_INTERPOLATOR);
    }

    @Override // com.android.server.wm.FadeAnimationController
    public Animation getFadeInAnimation() {
        return this.mFadeInAnimation;
    }

    @Override // com.android.server.wm.FadeAnimationController
    public Animation getFadeOutAnimation() {
        return this.mFadeOutAnimation;
    }

    @Override // com.android.server.wm.FadeAnimationController
    protected FadeAnimationController.FadeAnimationAdapter createAdapter(LocalAnimationAdapter.AnimationSpec animationSpec, boolean show, WindowToken windowToken) {
        SurfaceAnimationRunner r3 = windowToken.getSurfaceAnimationRunner();
        if (show == false) goto L6;
        SurfaceControl r1 = this.mFadeInParent;
    L8:
        return new NavFadeAnimationAdapter(this, animationSpec, r3, show, windowToken, r1);
    L6:
        r1 = this.mFadeOutParent;
        goto L8
    }

    public void fadeWindowToken(final boolean show) {
        AsyncRotationController controller = this.mDisplayContent.getAsyncRotationController();
        Runnable fadeAnim = new NavBarFadeAnimationController$$ExternalSyntheticLambda0(this, show);
        if (controller != null) goto L6;
        fadeAnim.run();
        return;
    L6:
        if (controller.hasFadeOperation(this.mNavigationBar.mToken) == true) goto L12;
        if (show == false) goto L9;
        controller.setOnShowRunnable(fadeAnim);
        return;
    L9:
        fadeAnim.run();
        return;
    }

    private /* synthetic */ void lambda$fadeWindowToken$0(boolean show) {
        fadeWindowToken(show, this.mNavigationBar.mToken, 64);
    }

    void fadeOutAndInSequentially(long totalDuration, SurfaceControl fadeOutParent, SurfaceControl fadeInParent) {
        this.mPlaySequentially = true;
        if (totalDuration <= 0) goto L5;
        long fadeInDuration = (2 * totalDuration) / 3;
        this.mFadeOutAnimation.setDuration(totalDuration - fadeInDuration);
        this.mFadeInAnimation.setDuration(fadeInDuration);
    L5:
        this.mFadeOutParent = fadeOutParent;
        this.mFadeInParent = fadeInParent;
        fadeWindowToken(false);
    }
}
