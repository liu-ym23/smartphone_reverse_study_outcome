package com.bumptech.glide.request.transition;

import com.bumptech.glide.load.DataSource;

/* JADX INFO: loaded from: classes39.dex */
public class ViewPropertyAnimationFactory<R> implements TransitionFactory<R> {
    private ViewPropertyTransition<R> animation;
    private final ViewPropertyTransition.Animator animator;

    public ViewPropertyAnimationFactory(ViewPropertyTransition.Animator r100) {
        this.animator = r100;
    }

    @Override // com.bumptech.glide.request.transition.TransitionFactory
    public Transition<R> build(DataSource r100, boolean r101) {
        if (r100 == DataSource.MEMORY_CACHE) goto L12;
        if (r101 == false) goto L12;
        if (this.animation != null) goto L10;
        this.animation = new ViewPropertyTransition(this.animator);
    L10:
        return this.animation;
    L12:
        return NoTransition.get();
    }
}
