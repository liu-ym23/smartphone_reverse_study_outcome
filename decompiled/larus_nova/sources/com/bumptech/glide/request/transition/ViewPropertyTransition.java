package com.bumptech.glide.request.transition;

import android.view.View;

/* JADX INFO: loaded from: classes39.dex */
public class ViewPropertyTransition<R> implements Transition<R> {
    private final Animator animator;

    public interface Animator {
        void animate(View r100);
    }

    public ViewPropertyTransition(Animator r100) {
        this.animator = r100;
    }

    @Override // com.bumptech.glide.request.transition.Transition
    public boolean transition(R r100, Transition.ViewAdapter r101) {
        if (r101.getView() == null) goto L7;
        this.animator.animate(r101.getView());
        return false;
    L7:
        return false;
    }
}
