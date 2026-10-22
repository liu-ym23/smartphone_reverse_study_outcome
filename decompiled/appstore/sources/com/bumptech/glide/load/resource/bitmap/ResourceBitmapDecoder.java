package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.drawable.ResourceDrawableDecoder;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class ResourceBitmapDecoder implements ResourceDecoder<Uri, Bitmap> {
    private final BitmapPool bitmapPool;
    private final ResourceDrawableDecoder drawableDecoder;

    public ResourceBitmapDecoder(ResourceDrawableDecoder r10, BitmapPool r11) {
        this.drawableDecoder = r10;
        this.bitmapPool = r11;
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    @Nullable
    public /* bridge */ /* synthetic */ Resource<Bitmap> decode(@NonNull Uri r10, int r11, int r12, @NonNull Options r13) throws IOException {
        return decode2(r10, r11, r12, r13);
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public /* bridge */ /* synthetic */ boolean handles(@NonNull Uri r10, @NonNull Options r11) throws IOException {
        return handles2(r10, r11);
    }

    @Nullable
    /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
    public Resource<Bitmap> decode2(@NonNull Uri r10, int r11, int r12, @NonNull Options r13) {
        Resource<Drawable> r14 = this.drawableDecoder.decode2(r10, r11, r12, r13);
        if (r14 != null) goto L6;
        return null;
    L6:
        Drawable r15 = r14.get();
        return DrawableToBitmapConverter.convert(this.bitmapPool, r15, r11, r12);
    }

    /* JADX INFO: renamed from: handles, reason: avoid collision after fix types in other method */
    public boolean handles2(@NonNull Uri r10, @NonNull Options r11) {
        return "android.resource".equals(r10.getScheme());
    }
}
