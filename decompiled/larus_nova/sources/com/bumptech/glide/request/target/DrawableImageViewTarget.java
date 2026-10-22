package com.bumptech.glide.request.target;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;

/* JADX INFO: loaded from: classes39.dex */
public class DrawableImageViewTarget extends ImageViewTarget<Drawable> {
    public DrawableImageViewTarget(ImageView r100) {
        super(r100);
    }

    /* JADX INFO: renamed from: setResource, reason: avoid collision after fix types in other method */
    public void setResource2(Drawable r100) {
        ((ImageView) this.view).setImageDrawable(r100);
    }

    @Override // com.bumptech.glide.request.target.ImageViewTarget
    public /* bridge */ /* synthetic */ void setResource(Drawable r100) {
        setResource2(r100);
    }

    public DrawableImageViewTarget(ImageView r100, boolean r101) {
        super(r100, r101);
    }
}
