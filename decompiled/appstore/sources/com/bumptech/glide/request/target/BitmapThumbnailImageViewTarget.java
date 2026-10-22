package com.bumptech.glide.request.target;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

/* JADX INFO: loaded from: classes.dex */
public class BitmapThumbnailImageViewTarget extends ThumbnailImageViewTarget<Bitmap> {
    public BitmapThumbnailImageViewTarget(ImageView r10) {
        super(r10);
    }

    @Override // com.bumptech.glide.request.target.ThumbnailImageViewTarget
    public /* bridge */ /* synthetic */ Drawable getDrawable(Bitmap r10) {
        return getDrawable2(r10);
    }

    @Deprecated
    public BitmapThumbnailImageViewTarget(ImageView r10, boolean r11) {
        super(r10, r11);
    }

    /* JADX INFO: renamed from: getDrawable, reason: avoid collision after fix types in other method */
    public Drawable getDrawable2(Bitmap r10) {
        return new BitmapDrawable(((ImageView) this.view).getResources(), r10);
    }
}
