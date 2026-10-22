package com.android.server.wm;

import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;

/* JADX INFO: loaded from: classes3.dex */
public class FadeAnimationController {
    static final int MEDIUM_DURATION_MS = 350;
    static final int SHORT_DURATION_MS = 200;
    protected final DisplayContent mDisplayContent;

    protected static class FadeAnimationAdapter extends LocalAnimationAdapter {
        protected final boolean mShow;
        protected final WindowToken mToken;

        FadeAnimationAdapter(LocalAnimationAdapter.AnimationSpec windowAnimationSpec, SurfaceAnimationRunner surfaceAnimationRunner, boolean show, WindowToken token) {
            super(windowAnimationSpec, surfaceAnimationRunner);
            this.mShow = show;
            this.mToken = token;
        }

        @Override // com.android.server.wm.AnimationAdapter
        public boolean shouldDeferAnimationFinish(Runnable endDeferFinishCallback) {
            return !this.mShow;
        }
    }

    public FadeAnimationController(DisplayContent displayContent) {
        this.mDisplayContent = displayContent;
    }

    public Animation getFadeInAnimation() {
        AlphaAnimation anim = new AlphaAnimation(0.0f, 1.0f);
        anim.setDuration(getScaledDuration(350));
        anim.setInterpolator(new DecelerateInterpolator());
        return anim;
    }

    public Animation getFadeOutAnimation() {
        AlphaAnimation anim = new AlphaAnimation(1.0f, 0.0f);
        anim.setDuration(getScaledDuration(200));
        anim.setInterpolator(new AccelerateInterpolator());
        return anim;
    }

    long getScaledDuration(int durationMs) {
        return (long) (durationMs * this.mDisplayContent.mWmService.getWindowAnimationScaleLocked());
    }

    public void fadeWindowToken(boolean show, WindowToken windowToken, int animationType) {
        fadeWindowToken(show, windowToken, animationType, null);
    }

    public void fadeWindowToken(boolean show, WindowToken windowToken, int animationType, SurfaceAnimator.OnAnimationFinishedCallback finishedCallback) {
        if (windowToken == null) goto L18;
        if (windowToken.getParent() == null) goto L19;
        if (show == false) goto L8;
        Animation animation = getFadeInAnimation();
    L9:
        if (animation == null) goto L11;
        FadeAnimationAdapter r1 = createAdapter(createAnimationSpec(animation), show, windowToken);
    L12:
        FadeAnimationAdapter animationAdapter = r1;
        if (animationAdapter != null) goto L15;
        return;
    L15:
        windowToken.startAnimation(windowToken.getPendingTransaction(), animationAdapter, show, animationType, finishedCallback);
        return;
    L11:
        r1 = null;
        goto L12
    L8:
        animation = getFadeOutAnimation();
        goto L9
    L19:
        return;
    }

    protected FadeAnimationAdapter createAdapter(LocalAnimationAdapter.AnimationSpec animationSpec, boolean show, WindowToken windowToken) {
        return new FadeAnimationAdapter(animationSpec, windowToken.getSurfaceAnimationRunner(), show, windowToken);
    }

    protected LocalAnimationAdapter.AnimationSpec createAnimationSpec(final Animation animation) {
        return new AnonymousClass1(this, animation);
    }
}
