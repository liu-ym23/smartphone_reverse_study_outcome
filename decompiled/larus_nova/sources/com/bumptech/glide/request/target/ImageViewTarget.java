package com.bumptech.glide.request.target;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.bumptech.glide.request.transition.Transition;

/* JADX INFO: loaded from: classes39.dex */
public abstract class ImageViewTarget<Z> extends ViewTarget<ImageView, Z> implements Transition.ViewAdapter {
    private Animatable animatable;

    public abstract void setResource(Z r100);

    @Override // com.bumptech.glide.request.transition.Transition.ViewAdapter
    public Drawable getCurrentDrawable() {
        return ((ImageView) this.view).getDrawable();
    }

    @Override // com.bumptech.glide.request.target.BaseTarget, com.bumptech.glide.manager.LifecycleListener
    public void onStart() {
        Animatable r100 = this.animatable;
        if (r100 == null) goto L6;
        r100.start();
        return;
    }

    @Override // com.bumptech.glide.request.target.BaseTarget, com.bumptech.glide.manager.LifecycleListener
    public void onStop() {
        Animatable r100 = this.animatable;
        if (r100 == null) goto L6;
        r100.stop();
        return;
    }

    public ImageViewTarget(ImageView r100) {
        super(r100);
    }

    private void maybeUpdateAnimatable(Z r100) {
        if ((r100 instanceof Animatable) == false) goto L5;
        Animatable r101 = (Animatable) r100;
        this.animatable = r101;
        r101.start();
        return;
    L5:
        this.animatable = null;
    }

    private void setResourceInternal(Z r100) {
        setResource(r100);
        maybeUpdateAnimatable(r100);
    }

    @Override // com.bumptech.glide.request.target.ViewTarget, com.bumptech.glide.request.target.BaseTarget, com.bumptech.glide.request.target.Target
    public void onLoadCleared(Drawable r100) {
        super.onLoadCleared(r100);
        Animatable r101 = this.animatable;
        if (r101 == null) goto L5;
        r101.stop();
    L5:
        setResourceInternal(null);
        setDrawable(r100);
    }

    @Override // com.bumptech.glide.request.target.BaseTarget, com.bumptech.glide.request.target.Target
    public void onLoadFailed(Drawable r100) {
        super.onLoadFailed(r100);
        setResourceInternal(null);
        setDrawable(r100);
    }

    @Override // com.bumptech.glide.request.target.ViewTarget, com.bumptech.glide.request.target.BaseTarget, com.bumptech.glide.request.target.Target
    public void onLoadStarted(Drawable r100) {
        super.onLoadStarted(r100);
        setResourceInternal(null);
        setDrawable(r100);
    }

    @Override // com.bumptech.glide.request.transition.Transition.ViewAdapter
    public void setDrawable(Drawable r100) {
        ((ImageView) this.view).setImageDrawable(r100);
    }

    public ImageViewTarget(ImageView r100, boolean r101) {
        super(r100, r101);
    }

    @Override // com.bumptech.glide.request.target.Target
    public void onResourceReady(Z r100, Transition<? super Z> r101) {
        if (r101 != null) goto L4;
    L7:
        setResourceInternal(r100);
        return;
    L4:
        if (r101.transition(r100, this) == false) goto L7;
        maybeUpdateAnimatable(r100);
    }
}
