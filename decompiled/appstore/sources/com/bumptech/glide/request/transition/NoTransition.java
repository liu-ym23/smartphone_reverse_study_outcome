package com.bumptech.glide.request.transition;

import com.bumptech.glide.load.DataSource;

/* JADX INFO: loaded from: classes.dex */
public class NoTransition<R> implements Transition<R> {
    static final NoTransition<?> NO_ANIMATION = null;
    private static final TransitionFactory<?> NO_ANIMATION_FACTORY = null;

    public static class NoAnimationFactory<R> implements TransitionFactory<R> {
        public NoAnimationFactory() {
        }

        @Override // com.bumptech.glide.request.transition.TransitionFactory
        public Transition<R> build(DataSource r10, boolean r11) {
            return NoTransition.NO_ANIMATION;
        }
    }

    static {
        NO_ANIMATION = new NoTransition();
        NO_ANIMATION_FACTORY = new NoAnimationFactory();
    }

    public NoTransition() {
    }

    public static <R> Transition<R> get() {
        return NO_ANIMATION;
    }

    public static <R> TransitionFactory<R> getFactory() {
        return (TransitionFactory<R>) NO_ANIMATION_FACTORY;
    }

    @Override // com.bumptech.glide.request.transition.Transition
    public boolean transition(Object r10, Transition.ViewAdapter r11) {
        return false;
    }
}
