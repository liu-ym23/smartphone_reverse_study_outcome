package com.bumptech.glide.request.target;

import android.graphics.Bitmap;
import android.widget.ImageView;

/* JADX INFO: loaded from: classes39.dex */
public class BitmapImageViewTarget extends ImageViewTarget<Bitmap> {
    public BitmapImageViewTarget(ImageView r100) {
        super(r100);
    }

    /* JADX INFO: renamed from: setResource, reason: avoid collision after fix types in other method */
    public void setResource2(Bitmap r100) {
        ((ImageView) this.view).setImageBitmap(r100);
    }

    @Override // com.bumptech.glide.request.target.ImageViewTarget
    public /* bridge */ /* synthetic */ void setResource(Bitmap r100) {
        setResource2(r100);
    }

    public BitmapImageViewTarget(ImageView r100, boolean r101) {
        super(r100, r101);
    }
}
