package com.bumptech.glide.request.transition;

import android.content.Context;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.bumptech.glide.load.DataSource;

/* JADX INFO: loaded from: classes.dex */
public class ViewAnimationFactory<R> implements TransitionFactory<R> {
    private Transition<R> transition;
    private final ViewTransition.ViewTransitionAnimationFactory viewTransitionAnimationFactory;

    public static class ConcreteViewTransitionAnimationFactory implements ViewTransition.ViewTransitionAnimationFactory {
        private final Animation animation;

        public ConcreteViewTransitionAnimationFactory(Animation r10) {
            this.animation = r10;
        }

        @Override // com.bumptech.glide.request.transition.ViewTransition.ViewTransitionAnimationFactory
        public Animation build(Context r10) {
            return this.animation;
        }
    }

    public static class ResourceViewTransitionAnimationFactory implements ViewTransition.ViewTransitionAnimationFactory {
        private final int animationId;

        public ResourceViewTransitionAnimationFactory(int r10) {
            this.animationId = r10;
        }

        @Override // com.bumptech.glide.request.transition.ViewTransition.ViewTransitionAnimationFactory
        public Animation build(Context r10) {
            return AnimationUtils.loadAnimation(r10, this.animationId);
        }
    }

    public ViewAnimationFactory(Animation r10) {
        this(new ConcreteViewTransitionAnimationFactory(r10));
    }

    @Override // com.bumptech.glide.request.transition.TransitionFactory
    public Transition<R> build(DataSource r10, boolean r11) {
        if (r10 == DataSource.MEMORY_CACHE) goto L12;
        if (r11 == false) goto L12;
        if (this.transition != null) goto L10;
        this.transition = new ViewTransition(this.viewTransitionAnimationFactory);
    L10:
        return this.transition;
    L12:
        return NoTransition.get();
    }

    public ViewAnimationFactory(int r10) {
        this(new ResourceViewTransitionAnimationFactory(r10));
    }

    public ViewAnimationFactory(ViewTransition.ViewTransitionAnimationFactory r10) {
        this.viewTransitionAnimationFactory = r10;
    }
}
