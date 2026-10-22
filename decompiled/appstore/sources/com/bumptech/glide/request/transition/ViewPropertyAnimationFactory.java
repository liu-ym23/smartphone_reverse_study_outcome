package com.bumptech.glide.request.transition;

import com.bumptech.glide.load.DataSource;

/* JADX INFO: loaded from: classes.dex */
public class ViewPropertyAnimationFactory<R> implements TransitionFactory<R> {
    private ViewPropertyTransition<R> animation;
    private final ViewPropertyTransition.Animator animator;

    public ViewPropertyAnimationFactory(ViewPropertyTransition.Animator r10) {
        this.animator = r10;
    }

    @Override // com.bumptech.glide.request.transition.TransitionFactory
    public Transition<R> build(DataSource r10, boolean r11) {
        if (r10 == DataSource.MEMORY_CACHE) goto L12;
        if (r11 == false) goto L12;
        if (this.animation != null) goto L10;
        this.animation = new ViewPropertyTransition(this.animator);
    L10:
        return this.animation;
    L12:
        return NoTransition.get();
    }
}
