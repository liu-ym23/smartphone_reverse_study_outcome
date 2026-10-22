package com.bumptech.glide.request.target;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;

/* JADX INFO: loaded from: classes.dex */
public class DrawableThumbnailImageViewTarget extends ThumbnailImageViewTarget<Drawable> {
    public DrawableThumbnailImageViewTarget(ImageView r10) {
        super(r10);
    }

    /* JADX INFO: renamed from: getDrawable, reason: avoid collision after fix types in other method */
    public Drawable getDrawable2(Drawable r10) {
        return r10;
    }

    @Deprecated
    public DrawableThumbnailImageViewTarget(ImageView r10, boolean r11) {
        super(r10, r11);
    }

    @Override // com.bumptech.glide.request.target.ThumbnailImageViewTarget
    public /* bridge */ /* synthetic */ Drawable getDrawable(Drawable r10) {
        return getDrawable2(r10);
    }
}
