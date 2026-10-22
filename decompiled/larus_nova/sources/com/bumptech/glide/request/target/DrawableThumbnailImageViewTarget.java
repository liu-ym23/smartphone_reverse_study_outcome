package com.bumptech.glide.request.target;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;

/* JADX INFO: loaded from: classes39.dex */
public class DrawableThumbnailImageViewTarget extends ThumbnailImageViewTarget<Drawable> {
    /* JADX INFO: renamed from: getDrawable, reason: avoid collision after fix types in other method */
    public Drawable getDrawable2(Drawable r100) {
        return r100;
    }

    public DrawableThumbnailImageViewTarget(ImageView r100) {
        super(r100);
    }

    @Override // com.bumptech.glide.request.target.ThumbnailImageViewTarget
    public /* bridge */ /* synthetic */ Drawable getDrawable(Drawable r100) {
        return getDrawable2(r100);
    }

    public DrawableThumbnailImageViewTarget(ImageView r100, boolean r101) {
        super(r100, r101);
    }
}
