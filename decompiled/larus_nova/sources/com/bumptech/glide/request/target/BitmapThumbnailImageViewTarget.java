package com.bumptech.glide.request.target;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

/* JADX INFO: loaded from: classes39.dex */
public class BitmapThumbnailImageViewTarget extends ThumbnailImageViewTarget<Bitmap> {
    public BitmapThumbnailImageViewTarget(ImageView r100) {
        super(r100);
    }

    /* JADX INFO: renamed from: getDrawable, reason: avoid collision after fix types in other method */
    public Drawable getDrawable2(Bitmap r100) {
        return new BitmapDrawable(((ImageView) this.view).getResources(), r100);
    }

    @Override // com.bumptech.glide.request.target.ThumbnailImageViewTarget
    public /* bridge */ /* synthetic */ Drawable getDrawable(Bitmap r100) {
        return getDrawable2(r100);
    }

    public BitmapThumbnailImageViewTarget(ImageView r100, boolean r101) {
        super(r100, r101);
    }
}
