package com.bumptech.glide.request.target;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
public class ImageViewTargetFactory {
    public ImageViewTargetFactory() {
    }

    @NonNull
    public <Z> ViewTarget<ImageView, Z> buildTarget(@NonNull ImageView r10, @NonNull Class<Z> r11) {
        if (Bitmap.class.equals(r11) == false) goto L7;
        return new BitmapImageViewTarget(r10);
    L7:
        if (Drawable.class.isAssignableFrom(r11) == false) goto L11;
        return new DrawableImageViewTarget(r10);
    L11:
        throw new IllegalArgumentException("Unhandled class: " + r11 + ", try .as*(Class).transcode(ResourceTranscoder)");
    }
}
