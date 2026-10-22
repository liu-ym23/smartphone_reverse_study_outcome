package com.bumptech.glide.load.resource.bitmap;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.Initializable;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.util.Preconditions;

/* JADX INFO: loaded from: classes39.dex */
public final class LazyBitmapDrawableResource implements Resource<BitmapDrawable>, Initializable {
    private final Resource<Bitmap> bitmapResource;
    private final Resources resources;

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bumptech.glide.load.engine.Resource
    public BitmapDrawable get() {
        return new BitmapDrawable(this.resources, this.bitmapResource.get());
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public int getSize() {
        return this.bitmapResource.getSize();
    }

    @Override // com.bumptech.glide.load.engine.Initializable
    public void initialize() {
        Resource<Bitmap> r100 = this.bitmapResource;
        if ((r100 instanceof Initializable) == false) goto L6;
        ((Initializable) r100).initialize();
        return;
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public void recycle() {
        this.bitmapResource.recycle();
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public Class<BitmapDrawable> getResourceClass() {
        return BitmapDrawable.class;
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public /* bridge */ /* synthetic */ BitmapDrawable get() {
        return get();
    }

    private LazyBitmapDrawableResource(Resources r100, Resource<Bitmap> r101) {
        this.resources = (Resources) Preconditions.checkNotNull(r100);
        this.bitmapResource = (Resource) Preconditions.checkNotNull(r101);
    }

    public static LazyBitmapDrawableResource obtain(Context r100, Bitmap r101) {
        return (LazyBitmapDrawableResource) obtain(r100.getResources(), BitmapResource.obtain(r101, Glide.get(r100).getBitmapPool()));
    }

    public static Resource<BitmapDrawable> obtain(Resources r100, Resource<Bitmap> r101) {
        if (r101 != null) goto L6;
        return null;
    L6:
        return new LazyBitmapDrawableResource(r100, r101);
    }

    public static LazyBitmapDrawableResource obtain(Resources r100, BitmapPool r101, Bitmap r102) {
        return (LazyBitmapDrawableResource) obtain(r100, BitmapResource.obtain(r102, r101));
    }
}
