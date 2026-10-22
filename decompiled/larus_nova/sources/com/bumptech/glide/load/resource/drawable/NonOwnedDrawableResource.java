package com.bumptech.glide.load.resource.drawable;

import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.engine.Resource;

/* JADX INFO: loaded from: classes39.dex */
final class NonOwnedDrawableResource extends DrawableResource<Drawable> {
    @Override // com.bumptech.glide.load.engine.Resource
    public void recycle() {
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public Class<Drawable> getResourceClass() {
        return this.drawable.getClass();
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public int getSize() {
        return Math.max(1, (this.drawable.getIntrinsicWidth() * this.drawable.getIntrinsicHeight()) * 4);
    }

    private NonOwnedDrawableResource(Drawable r100) {
        super(r100);
    }

    public static Resource<Drawable> newInstance(Drawable r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        return new NonOwnedDrawableResource(r100);
    }
}
