package com.bumptech.glide.load.resource.transcode;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.resource.bytes.BytesResource;
import java.io.ByteArrayOutputStream;

/* JADX INFO: loaded from: classes.dex */
public class BitmapBytesTranscoder implements ResourceTranscoder<Bitmap, byte[]> {
    private final Bitmap.CompressFormat compressFormat;
    private final int quality;

    public BitmapBytesTranscoder() {
        this(Bitmap.CompressFormat.JPEG, 100);
    }

    @Override // com.bumptech.glide.load.resource.transcode.ResourceTranscoder
    @Nullable
    public Resource<byte[]> transcode(@NonNull Resource<Bitmap> r10, @NonNull Options r11) {
        ByteArrayOutputStream r12 = new ByteArrayOutputStream();
        r10.get().compress(this.compressFormat, this.quality, r12);
        r10.recycle();
        return new BytesResource(r12.toByteArray());
    }

    public BitmapBytesTranscoder(@NonNull Bitmap.CompressFormat r10, int r11) {
        this.compressFormat = r10;
        this.quality = r11;
    }
}
