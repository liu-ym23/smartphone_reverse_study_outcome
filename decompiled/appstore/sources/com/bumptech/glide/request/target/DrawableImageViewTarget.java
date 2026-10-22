package com.bumptech.glide.request.target;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
public class DrawableImageViewTarget extends ImageViewTarget<Drawable> {
    public DrawableImageViewTarget(ImageView r10) {
        super(r10);
    }

    @Override // com.bumptech.glide.request.target.ImageViewTarget
    public /* bridge */ /* synthetic */ void setResource(@Nullable Drawable r10) {
        setResource2(r10);
    }

    @Deprecated
    public DrawableImageViewTarget(ImageView r10, boolean r11) {
        super(r10, r11);
    }

    /* JADX INFO: renamed from: setResource, reason: avoid collision after fix types in other method */
    public void setResource2(@Nullable Drawable r10) {
        ((ImageView) this.view).setImageDrawable(r10);
    }
}
