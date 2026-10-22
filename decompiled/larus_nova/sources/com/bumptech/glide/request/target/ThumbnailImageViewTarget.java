package com.bumptech.glide.request.target;

import android.graphics.drawable.Drawable;
import android.view.ViewGroup;
import android.widget.ImageView;

/* JADX INFO: loaded from: classes39.dex */
public abstract class ThumbnailImageViewTarget<T> extends ImageViewTarget<T> {
    public abstract Drawable getDrawable(T r100);

    public ThumbnailImageViewTarget(ImageView r100) {
        super(r100);
    }

    @Override // com.bumptech.glide.request.target.ImageViewTarget
    public void setResource(T r100) {
        ViewGroup.LayoutParams r101 = ((ImageView) this.view).getLayoutParams();
        Drawable r102 = getDrawable(r100);
        if (r101 != null) goto L5;
    L9:
        ((ImageView) this.view).setImageDrawable(r102);
        return;
    L5:
        if (r101.width <= 0) goto L9;
        if (r101.height <= 0) goto L9;
        r102 = new FixedSizeDrawable(r102, r101.width, r101.height);
        goto L9
    }

    public ThumbnailImageViewTarget(ImageView r100, boolean r101) {
        super(r100, r101);
    }
}
