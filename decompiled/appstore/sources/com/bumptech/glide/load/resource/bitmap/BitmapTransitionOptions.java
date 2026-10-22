package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import com.bumptech.glide.TransitionOptions;
import com.bumptech.glide.request.transition.BitmapTransitionFactory;
import com.bumptech.glide.request.transition.DrawableCrossFadeFactory;
import com.bumptech.glide.request.transition.TransitionFactory;

/* JADX INFO: loaded from: classes.dex */
public final class BitmapTransitionOptions extends TransitionOptions<BitmapTransitionOptions, Bitmap> {
    public BitmapTransitionOptions() {
    }

    @NonNull
    public static BitmapTransitionOptions with(@NonNull TransitionFactory<Bitmap> r10) {
        return new BitmapTransitionOptions().transition(r10);
    }

    @NonNull
    public static BitmapTransitionOptions withCrossFade() {
        return new BitmapTransitionOptions().crossFade();
    }

    @NonNull
    public static BitmapTransitionOptions withWrapped(@NonNull TransitionFactory<Drawable> r10) {
        return new BitmapTransitionOptions().transitionUsing(r10);
    }

    @NonNull
    public BitmapTransitionOptions crossFade() {
        return crossFade(new DrawableCrossFadeFactory.Builder());
    }

    @NonNull
    public BitmapTransitionOptions transitionUsing(@NonNull TransitionFactory<Drawable> r10) {
        return transition(new BitmapTransitionFactory(r10));
    }

    @NonNull
    public static BitmapTransitionOptions withCrossFade(int r10) {
        return new BitmapTransitionOptions().crossFade(r10);
    }

    @NonNull
    public BitmapTransitionOptions crossFade(int r10) {
        return crossFade(new DrawableCrossFadeFactory.Builder(r10));
    }

    @NonNull
    public static BitmapTransitionOptions withCrossFade(@NonNull DrawableCrossFadeFactory r10) {
        return new BitmapTransitionOptions().crossFade(r10);
    }

    @NonNull
    public BitmapTransitionOptions crossFade(@NonNull DrawableCrossFadeFactory r10) {
        return transitionUsing(r10);
    }

    @NonNull
    public static BitmapTransitionOptions withCrossFade(@NonNull DrawableCrossFadeFactory.Builder r10) {
        return new BitmapTransitionOptions().crossFade(r10);
    }

    @NonNull
    public BitmapTransitionOptions crossFade(@NonNull DrawableCrossFadeFactory.Builder r10) {
        return transitionUsing(r10.build());
    }
}
