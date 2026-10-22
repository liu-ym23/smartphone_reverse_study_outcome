package com.bumptech.glide.request.target;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

/* JADX INFO: loaded from: classes39.dex */
public class ImageViewTargetFactory {
    public ImageViewTargetFactory() {
    }

    public <Z> ViewTarget<ImageView, Z> buildTarget(ImageView r100, Class<Z> r101) {
        if (Bitmap.class.equals(r101) == false) goto L7;
        return new BitmapImageViewTarget(r100);
    L7:
        if (Drawable.class.isAssignableFrom(r101) == false) goto L11;
        return new DrawableImageViewTarget(r100);
    L11:
        throw new IllegalArgumentException("Unhandled class: " + r101 + ", try .as*(Class).transcode(ResourceTranscoder)");
    }
}
