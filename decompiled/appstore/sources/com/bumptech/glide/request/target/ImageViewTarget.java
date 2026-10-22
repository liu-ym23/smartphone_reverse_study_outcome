package com.bumptech.glide.request.target;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.request.transition.Transition;

/* JADX INFO: loaded from: classes.dex */
public abstract class ImageViewTarget<Z> extends ViewTarget<ImageView, Z> implements Transition.ViewAdapter {

    @Nullable
    private Animatable animatable;

    public ImageViewTarget(ImageView r10) {
        super(r10);
    }

    private void maybeUpdateAnimatable(@Nullable Z r10) {
        if ((r10 instanceof Animatable) == false) goto L5;
        Animatable r11 = (Animatable) r10;
        this.animatable = r11;
        r11.start();
        return;
    L5:
        this.animatable = null;
    }

    private void setResourceInternal(@Nullable Z r10) {
        setResource(r10);
        maybeUpdateAnimatable(r10);
    }

    @Override // com.bumptech.glide.request.transition.Transition.ViewAdapter
    @Nullable
    public Drawable getCurrentDrawable() {
        return ((ImageView) this.view).getDrawable();
    }

    @Override // com.bumptech.glide.request.target.ViewTarget, com.bumptech.glide.request.target.BaseTarget, com.bumptech.glide.request.target.Target
    public void onLoadCleared(@Nullable Drawable r10) {
        super.onLoadCleared(r10);
        Animatable r11 = this.animatable;
        if (r11 == null) goto L5;
        r11.stop();
    L5:
        setResourceInternal(null);
        setDrawable(r10);
    }

    @Override // com.bumptech.glide.request.target.BaseTarget, com.bumptech.glide.request.target.Target
    public void onLoadFailed(@Nullable Drawable r10) {
        super.onLoadFailed(r10);
        setResourceInternal(null);
        setDrawable(r10);
    }

    @Override // com.bumptech.glide.request.target.ViewTarget, com.bumptech.glide.request.target.BaseTarget, com.bumptech.glide.request.target.Target
    public void onLoadStarted(@Nullable Drawable r10) {
        super.onLoadStarted(r10);
        setResourceInternal(null);
        setDrawable(r10);
    }

    @Override // com.bumptech.glide.request.target.Target
    public void onResourceReady(@NonNull Z r10, @Nullable Transition<? super Z> r11) {
        if (r11 != null) goto L4;
    L7:
        setResourceInternal(r10);
        return;
    L4:
        if (r11.transition(r10, this) == false) goto L7;
        maybeUpdateAnimatable(r10);
    }

    @Override // com.bumptech.glide.request.target.BaseTarget, com.bumptech.glide.manager.LifecycleListener
    public void onStart() {
        Animatable r10 = this.animatable;
        if (r10 == null) goto L6;
        r10.start();
        return;
    }

    @Override // com.bumptech.glide.request.target.BaseTarget, com.bumptech.glide.manager.LifecycleListener
    public void onStop() {
        Animatable r10 = this.animatable;
        if (r10 == null) goto L6;
        r10.stop();
        return;
    }

    @Override // com.bumptech.glide.request.transition.Transition.ViewAdapter
    public void setDrawable(Drawable r10) {
        ((ImageView) this.view).setImageDrawable(r10);
    }

    public abstract void setResource(@Nullable Z r10);

    @Deprecated
    public ImageViewTarget(ImageView r10, boolean r11) {
        super(r10, r11);
    }
}
