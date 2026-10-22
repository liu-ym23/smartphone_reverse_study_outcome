package com.bumptech.glide.load.resource.bitmap;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.util.Preconditions;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class BitmapDrawableDecoder<DataType> implements ResourceDecoder<DataType, BitmapDrawable> {
    private final ResourceDecoder<DataType, Bitmap> decoder;
    private final Resources resources;

    public BitmapDrawableDecoder(Context r10, ResourceDecoder<DataType, Bitmap> r11) {
        this(r10.getResources(), r11);
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public Resource<BitmapDrawable> decode(@NonNull DataType r10, int r11, int r12, @NonNull Options r13) throws IOException {
        Resource<Bitmap> r14 = this.decoder.decode(r10, r11, r12, r13);
        return LazyBitmapDrawableResource.obtain(this.resources, r14);
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public boolean handles(@NonNull DataType r10, @NonNull Options r11) throws IOException {
        return this.decoder.handles(r10, r11);
    }

    @Deprecated
    public BitmapDrawableDecoder(Resources r10, BitmapPool r11, ResourceDecoder<DataType, Bitmap> r12) {
        this(r10, r12);
    }

    public BitmapDrawableDecoder(@NonNull Resources r10, @NonNull ResourceDecoder<DataType, Bitmap> r11) {
        this.resources = (Resources) Preconditions.checkNotNull(r10);
        this.decoder = (ResourceDecoder) Preconditions.checkNotNull(r11);
    }
}
