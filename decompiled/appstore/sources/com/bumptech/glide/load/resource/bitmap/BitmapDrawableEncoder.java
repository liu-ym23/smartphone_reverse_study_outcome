package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.EncodeStrategy;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public class BitmapDrawableEncoder implements ResourceEncoder<BitmapDrawable> {
    private final BitmapPool bitmapPool;
    private final ResourceEncoder<Bitmap> encoder;

    public BitmapDrawableEncoder(BitmapPool r10, ResourceEncoder<Bitmap> r11) {
        this.bitmapPool = r10;
        this.encoder = r11;
    }

    @Override // com.bumptech.glide.load.Encoder
    public /* bridge */ /* synthetic */ boolean encode(@NonNull Object r10, @NonNull File r11, @NonNull Options r12) {
        return encode((Resource) r10, r11, r12);
    }

    @Override // com.bumptech.glide.load.ResourceEncoder
    @NonNull
    public EncodeStrategy getEncodeStrategy(@NonNull Options r10) {
        return this.encoder.getEncodeStrategy(r10);
    }

    public boolean encode(@NonNull Resource<BitmapDrawable> r10, @NonNull File r11, @NonNull Options r12) {
        return this.encoder.encode((Bitmap) new BitmapResource(r10.get().getBitmap(), this.bitmapPool), r11, r12);
    }
}
