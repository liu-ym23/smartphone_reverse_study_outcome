package com.bumptech.glide.load.resource.bitmap;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.Initializable;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.util.Preconditions;

/* JADX INFO: loaded from: classes.dex */
public final class LazyBitmapDrawableResource implements Resource<BitmapDrawable>, Initializable {
    private final Resource<Bitmap> bitmapResource;
    private final Resources resources;

    private LazyBitmapDrawableResource(@NonNull Resources r10, @NonNull Resource<Bitmap> r11) {
        this.resources = (Resources) Preconditions.checkNotNull(r10);
        this.bitmapResource = (Resource) Preconditions.checkNotNull(r11);
    }

    @Deprecated
    public static LazyBitmapDrawableResource obtain(Context r10, Bitmap r11) {
        return (LazyBitmapDrawableResource) obtain(r10.getResources(), BitmapResource.obtain(r11, Glide.get(r10).getBitmapPool()));
    }

    @Override // com.bumptech.glide.load.engine.Resource
    @NonNull
    public /* bridge */ /* synthetic */ BitmapDrawable get() {
        return get();
    }

    @Override // com.bumptech.glide.load.engine.Resource
    @NonNull
    public Class<BitmapDrawable> getResourceClass() {
        return BitmapDrawable.class;
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public int getSize() {
        return this.bitmapResource.getSize();
    }

    @Override // com.bumptech.glide.load.engine.Initializable
    public void initialize() {
        Resource<Bitmap> r10 = this.bitmapResource;
        if ((r10 instanceof Initializable) == false) goto L6;
        ((Initializable) r10).initialize();
        return;
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public void recycle() {
        this.bitmapResource.recycle();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bumptech.glide.load.engine.Resource
    @NonNull
    public BitmapDrawable get() {
        return new BitmapDrawable(this.resources, this.bitmapResource.get());
    }

    @Deprecated
    public static LazyBitmapDrawableResource obtain(Resources r10, BitmapPool r11, Bitmap r12) {
        return (LazyBitmapDrawableResource) obtain(r10, BitmapResource.obtain(r12, r11));
    }

    @Nullable
    public static Resource<BitmapDrawable> obtain(@NonNull Resources r10, @Nullable Resource<Bitmap> r11) {
        if (r11 != null) goto L6;
        return null;
    L6:
        return new LazyBitmapDrawableResource(r10, r11);
    }
}
