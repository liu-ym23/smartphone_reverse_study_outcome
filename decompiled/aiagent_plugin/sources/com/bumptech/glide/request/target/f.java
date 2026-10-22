package com.bumptech.glide.request.target;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

/* JADX INFO: compiled from: ImageViewTargetFactory.java */
/* JADX INFO: loaded from: classes.dex */
public class f {
    public f() {
    }

    public <Z> ViewTarget<ImageView, Z> a(ImageView r2, Class<Z> r3) {
        if (Bitmap.class.equals(r3) == false) goto L7;
        return new b(r2);
    L7:
        if (Drawable.class.isAssignableFrom(r3) == false) goto L11;
        return new d(r2);
    L11:
        throw new IllegalArgumentException("Unhandled class: " + r3 + ", try .as*(Class).transcode(ResourceTranscoder)");
    }
}
