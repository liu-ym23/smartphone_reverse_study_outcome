package com.bumptech.glide;

import androidx.annotation.NonNull;
import com.bumptech.glide.TransitionOptions;
import com.bumptech.glide.request.transition.NoTransition;
import com.bumptech.glide.request.transition.TransitionFactory;
import com.bumptech.glide.request.transition.ViewAnimationFactory;
import com.bumptech.glide.request.transition.ViewPropertyAnimationFactory;
import com.bumptech.glide.request.transition.ViewPropertyTransition;
import com.bumptech.glide.util.Preconditions;

/* JADX INFO: loaded from: classes.dex */
public abstract class TransitionOptions<CHILD extends TransitionOptions<CHILD, TranscodeType>, TranscodeType> implements Cloneable {
    private TransitionFactory<? super TranscodeType> transitionFactory;

    public TransitionOptions() {
        this.transitionFactory = NoTransition.getFactory();
    }

    private CHILD self() {
        return this;
    }

    /* JADX INFO: renamed from: clone, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m6clone() throws CloneNotSupportedException {
        return clone();
    }

    @NonNull
    public final CHILD dontTransition() {
        return (CHILD) transition(NoTransition.getFactory());
    }

    public final TransitionFactory<? super TranscodeType> getTransitionFactory() {
        return this.transitionFactory;
    }

    @NonNull
    public final CHILD transition(int r10) {
        return (CHILD) transition(new ViewAnimationFactory(r10));
    }

    public final CHILD clone() {
        return (CHILD) super.clone();
    L4:
        e = move-exception;
        throw new RuntimeException(e);
    }

    @NonNull
    public final CHILD transition(@NonNull ViewPropertyTransition.Animator r10) {
        return (CHILD) transition(new ViewPropertyAnimationFactory(r10));
    }

    @NonNull
    public final CHILD transition(@NonNull TransitionFactory<? super TranscodeType> r10) {
        this.transitionFactory = (TransitionFactory) Preconditions.checkNotNull(r10);
        return (CHILD) self();
    }
}
