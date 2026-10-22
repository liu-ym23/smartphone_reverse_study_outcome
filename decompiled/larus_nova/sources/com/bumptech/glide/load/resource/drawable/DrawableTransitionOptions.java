package com.bumptech.glide.load.resource.drawable;

import android.graphics.drawable.Drawable;
import com.bumptech.glide.TransitionOptions;
import com.bumptech.glide.request.transition.DrawableCrossFadeFactory;
import com.bumptech.glide.request.transition.TransitionFactory;

/* JADX INFO: loaded from: classes39.dex */
public final class DrawableTransitionOptions extends TransitionOptions<DrawableTransitionOptions, Drawable> {
    public static DrawableTransitionOptions withCrossFade() {
        return new DrawableTransitionOptions().crossFade();
    }

    public DrawableTransitionOptions crossFade() {
        return crossFade(new DrawableCrossFadeFactory.Builder());
    }

    public DrawableTransitionOptions() {
    }

    public static DrawableTransitionOptions with(TransitionFactory<Drawable> r100) {
        return new DrawableTransitionOptions().transition(r100);
    }

    public static DrawableTransitionOptions withCrossFade(int r100) {
        return new DrawableTransitionOptions().crossFade(r100);
    }

    public DrawableTransitionOptions crossFade(int r100) {
        return crossFade(new DrawableCrossFadeFactory.Builder(r100));
    }

    public static DrawableTransitionOptions withCrossFade(DrawableCrossFadeFactory.Builder r100) {
        return new DrawableTransitionOptions().crossFade(r100);
    }

    public DrawableTransitionOptions crossFade(DrawableCrossFadeFactory.Builder r100) {
        return crossFade(r100.build());
    }

    public static DrawableTransitionOptions withCrossFade(DrawableCrossFadeFactory r100) {
        return new DrawableTransitionOptions().crossFade(r100);
    }

    public DrawableTransitionOptions crossFade(DrawableCrossFadeFactory r100) {
        return transition(r100);
    }
}
