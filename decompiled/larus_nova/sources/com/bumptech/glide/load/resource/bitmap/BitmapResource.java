package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import com.bumptech.glide.load.engine.Initializable;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.Util;

/* JADX INFO: loaded from: classes39.dex */
public class BitmapResource implements Resource<Bitmap>, Initializable {
    private final Bitmap bitmap;
    private final BitmapPool bitmapPool;

    @Override // com.bumptech.glide.load.engine.Resource
    public int getSize() {
        return Util.getBitmapByteSize(this.bitmap);
    }

    @Override // com.bumptech.glide.load.engine.Initializable
    public void initialize() {
        this.bitmap.prepareToDraw();
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public void recycle() {
        this.bitmapPool.put(this.bitmap);
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public /* bridge */ /* synthetic */ Bitmap get() {
        return get();
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public Class<Bitmap> getResourceClass() {
        return Bitmap.class;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bumptech.glide.load.engine.Resource
    public Bitmap get() {
        return this.bitmap;
    }

    public BitmapResource(Bitmap r100, BitmapPool r101) {
        this.bitmap = (Bitmap) Preconditions.checkNotNull(r100, "Bitmap must not be null");
        this.bitmapPool = (BitmapPool) Preconditions.checkNotNull(r101, "BitmapPool must not be null");
    }

    public static BitmapResource obtain(Bitmap r100, BitmapPool r101) {
        if (r100 != null) goto L6;
        return null;
    L6:
        return new BitmapResource(r100, r101);
    }
}
