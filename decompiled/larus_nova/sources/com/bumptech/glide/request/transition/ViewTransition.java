package com.bumptech.glide.request.transition;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;

/* JADX INFO: loaded from: classes39.dex */
public class ViewTransition<R> implements Transition<R> {
    private final ViewTransitionAnimationFactory viewTransitionAnimationFactory;

    public interface ViewTransitionAnimationFactory {
        Animation build(Context r100);
    }

    public ViewTransition(ViewTransitionAnimationFactory r100) {
        this.viewTransitionAnimationFactory = r100;
    }

    @Override // com.bumptech.glide.request.transition.Transition
    public boolean transition(R r100, Transition.ViewAdapter r101) {
        View r102 = r101.getView();
        if (r102 == null) goto L7;
        r102.clearAnimation();
        r102.startAnimation(this.viewTransitionAnimationFactory.build(r102.getContext()));
        return false;
    L7:
        return false;
    }
}
