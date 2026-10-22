package com.bumptech.glide.request.transition;

import android.content.Context;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.bumptech.glide.load.DataSource;

/* JADX INFO: loaded from: classes39.dex */
public class ViewAnimationFactory<R> implements TransitionFactory<R> {
    private Transition<R> transition;
    private final ViewTransition.ViewTransitionAnimationFactory viewTransitionAnimationFactory;

    public static class ConcreteViewTransitionAnimationFactory implements ViewTransition.ViewTransitionAnimationFactory {
        private final Animation animation;

        public ConcreteViewTransitionAnimationFactory(Animation r100) {
            this.animation = r100;
        }

        @Override // com.bumptech.glide.request.transition.ViewTransition.ViewTransitionAnimationFactory
        public Animation build(Context r100) {
            return this.animation;
        }
    }

    public static class ResourceViewTransitionAnimationFactory implements ViewTransition.ViewTransitionAnimationFactory {
        private final int animationId;

        public ResourceViewTransitionAnimationFactory(int r100) {
            this.animationId = r100;
        }

        @Override // com.bumptech.glide.request.transition.ViewTransition.ViewTransitionAnimationFactory
        public Animation build(Context r100) {
            return AnimationUtils.loadAnimation(r100, this.animationId);
        }
    }

    public ViewAnimationFactory(int r100) {
        this(new ResourceViewTransitionAnimationFactory(r100));
    }

    public ViewAnimationFactory(Animation r100) {
        this(new ConcreteViewTransitionAnimationFactory(r100));
    }

    public ViewAnimationFactory(ViewTransition.ViewTransitionAnimationFactory r100) {
        this.viewTransitionAnimationFactory = r100;
    }

    @Override // com.bumptech.glide.request.transition.TransitionFactory
    public Transition<R> build(DataSource r100, boolean r101) {
        if (r100 == DataSource.MEMORY_CACHE) goto L12;
        if (r101 == false) goto L12;
        if (this.transition != null) goto L10;
        this.transition = new ViewTransition(this.viewTransitionAnimationFactory);
    L10:
        return this.transition;
    L12:
        return NoTransition.get();
    }
}
