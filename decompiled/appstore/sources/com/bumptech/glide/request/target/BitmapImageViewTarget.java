package com.bumptech.glide.request.target;

import android.graphics.Bitmap;
import android.widget.ImageView;

/* JADX INFO: loaded from: classes.dex */
public class BitmapImageViewTarget extends ImageViewTarget<Bitmap> {
    public BitmapImageViewTarget(ImageView r10) {
        super(r10);
    }

    @Override // com.bumptech.glide.request.target.ImageViewTarget
    public /* bridge */ /* synthetic */ void setResource(Bitmap r10) {
        setResource2(r10);
    }

    @Deprecated
    public BitmapImageViewTarget(ImageView r10, boolean r11) {
        super(r10, r11);
    }

    /* JADX INFO: renamed from: setResource, reason: avoid collision after fix types in other method */
    public void setResource2(Bitmap r10) {
        ((ImageView) this.view).setImageBitmap(r10);
    }
}
