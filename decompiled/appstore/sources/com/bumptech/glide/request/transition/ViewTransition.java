package com.bumptech.glide.request.transition;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;

/* JADX INFO: loaded from: classes.dex */
public class ViewTransition<R> implements Transition<R> {
    private final ViewTransitionAnimationFactory viewTransitionAnimationFactory;

    public interface ViewTransitionAnimationFactory {
        Animation build(Context r10);
    }

    public ViewTransition(ViewTransitionAnimationFactory r10) {
        this.viewTransitionAnimationFactory = r10;
    }

    @Override // com.bumptech.glide.request.transition.Transition
    public boolean transition(R r10, Transition.ViewAdapter r11) {
        View r12 = r11.getView();
        if (r12 == null) goto L7;
        r12.clearAnimation();
        r12.startAnimation(this.viewTransitionAnimationFactory.build(r12.getContext()));
        return false;
    L7:
        return false;
    }
}
