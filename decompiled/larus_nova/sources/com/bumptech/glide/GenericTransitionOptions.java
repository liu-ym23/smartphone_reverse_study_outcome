package com.bumptech.glide;

import com.bumptech.glide.request.transition.TransitionFactory;
import com.bumptech.glide.request.transition.ViewPropertyTransition;

/* JADX INFO: loaded from: classes39.dex */
public final class GenericTransitionOptions<TranscodeType> extends TransitionOptions<GenericTransitionOptions<TranscodeType>, TranscodeType> {
    public static <TranscodeType> GenericTransitionOptions<TranscodeType> withNoTransition() {
        return new GenericTransitionOptions().dontTransition();
    }

    public GenericTransitionOptions() {
    }

    public static <TranscodeType> GenericTransitionOptions<TranscodeType> with(int r100) {
        return new GenericTransitionOptions().transition(r100);
    }

    public static <TranscodeType> GenericTransitionOptions<TranscodeType> with(TransitionFactory<? super TranscodeType> r100) {
        return new GenericTransitionOptions().transition(r100);
    }

    public static <TranscodeType> GenericTransitionOptions<TranscodeType> with(ViewPropertyTransition.Animator r100) {
        return new GenericTransitionOptions().transition(r100);
    }
}
