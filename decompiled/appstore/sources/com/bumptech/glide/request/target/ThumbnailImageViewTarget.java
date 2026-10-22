package com.bumptech.glide.request.target;

import android.graphics.drawable.Drawable;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
public abstract class ThumbnailImageViewTarget<T> extends ImageViewTarget<T> {
    public ThumbnailImageViewTarget(ImageView r10) {
        super(r10);
    }

    public abstract Drawable getDrawable(T r10);

    @Override // com.bumptech.glide.request.target.ImageViewTarget
    public void setResource(@Nullable T r10) {
        ViewGroup.LayoutParams r11 = ((ImageView) this.view).getLayoutParams();
        Drawable r12 = getDrawable(r10);
        if (r11 != null) goto L5;
    L9:
        ((ImageView) this.view).setImageDrawable(r12);
        return;
    L5:
        if (r11.width <= 0) goto L9;
        if (r11.height <= 0) goto L9;
        r12 = new FixedSizeDrawable(r12, r11.width, r11.height);
        goto L9
    }

    @Deprecated
    public ThumbnailImageViewTarget(ImageView r10, boolean r11) {
        super(r10, r11);
    }
}
