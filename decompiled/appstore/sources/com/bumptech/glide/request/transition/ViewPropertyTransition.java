package com.bumptech.glide.request.transition;

import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public class ViewPropertyTransition<R> implements Transition<R> {
    private final Animator animator;

    public interface Animator {
        void animate(View r10);
    }

    public ViewPropertyTransition(Animator r10) {
        this.animator = r10;
    }

    @Override // com.bumptech.glide.request.transition.Transition
    public boolean transition(R r10, Transition.ViewAdapter r11) {
        if (r11.getView() == null) goto L7;
        this.animator.animate(r11.getView());
        return false;
    L7:
        return false;
    }
}
