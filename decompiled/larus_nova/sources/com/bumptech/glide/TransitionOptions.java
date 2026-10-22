package com.bumptech.glide;

import com.bumptech.glide.TransitionOptions;
import com.bumptech.glide.request.transition.NoTransition;
import com.bumptech.glide.request.transition.TransitionFactory;
import com.bumptech.glide.request.transition.ViewAnimationFactory;
import com.bumptech.glide.request.transition.ViewPropertyAnimationFactory;
import com.bumptech.glide.request.transition.ViewPropertyTransition;
import com.bumptech.glide.util.Preconditions;

/* JADX INFO: loaded from: classes39.dex */
public abstract class TransitionOptions<CHILD extends TransitionOptions<CHILD, TranscodeType>, TranscodeType> implements Cloneable {
    private TransitionFactory<? super TranscodeType> transitionFactory;

    private CHILD self() {
        return this;
    }

    public TransitionOptions() {
        this.transitionFactory = NoTransition.getFactory();
    }

    public final CHILD clone() {
        return (CHILD) super.clone();
    L4:
        e = move-exception;
        throw new RuntimeException(e);
    }

    public final CHILD dontTransition() {
        return (CHILD) transition(NoTransition.getFactory());
    }

    public final TransitionFactory<? super TranscodeType> getTransitionFactory() {
        return this.transitionFactory;
    }

    /* JADX INFO: renamed from: clone, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m8141clone() throws CloneNotSupportedException {
        return clone();
    }

    public final CHILD transition(TransitionFactory<? super TranscodeType> r100) {
        this.transitionFactory = (TransitionFactory) Preconditions.checkNotNull(r100);
        return (CHILD) self();
    }

    public final CHILD transition(int r100) {
        return (CHILD) transition(new ViewAnimationFactory(r100));
    }

    public final CHILD transition(ViewPropertyTransition.Animator r100) {
        return (CHILD) transition(new ViewPropertyAnimationFactory(r100));
    }
}
