package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.TransitionOptions;
import com.bumptech.glide.request.transition.BitmapTransitionFactory;
import com.bumptech.glide.request.transition.DrawableCrossFadeFactory;
import com.bumptech.glide.request.transition.TransitionFactory;

/* JADX INFO: loaded from: classes39.dex */
public final class BitmapTransitionOptions extends TransitionOptions<BitmapTransitionOptions, Bitmap> {
    public static BitmapTransitionOptions withCrossFade() {
        return new BitmapTransitionOptions().crossFade();
    }

    public BitmapTransitionOptions crossFade() {
        return crossFade(new DrawableCrossFadeFactory.Builder());
    }

    public BitmapTransitionOptions() {
    }

    public static BitmapTransitionOptions with(TransitionFactory<Bitmap> r100) {
        return new BitmapTransitionOptions().transition(r100);
    }

    public static BitmapTransitionOptions withCrossFade(int r100) {
        return new BitmapTransitionOptions().crossFade(r100);
    }

    public static BitmapTransitionOptions withWrapped(TransitionFactory<Drawable> r100) {
        return new BitmapTransitionOptions().transitionUsing(r100);
    }

    public BitmapTransitionOptions crossFade(int r100) {
        return crossFade(new DrawableCrossFadeFactory.Builder(r100));
    }

    public BitmapTransitionOptions transitionUsing(TransitionFactory<Drawable> r100) {
        return transition(new BitmapTransitionFactory(r100));
    }

    public static BitmapTransitionOptions withCrossFade(DrawableCrossFadeFactory.Builder r100) {
        return new BitmapTransitionOptions().crossFade(r100);
    }

    public BitmapTransitionOptions crossFade(DrawableCrossFadeFactory.Builder r100) {
        return transitionUsing(r100.build());
    }

    public static BitmapTransitionOptions withCrossFade(DrawableCrossFadeFactory r100) {
        return new BitmapTransitionOptions().crossFade(r100);
    }

    public BitmapTransitionOptions crossFade(DrawableCrossFadeFactory r100) {
        return transitionUsing(r100);
    }
}
