package com.bumptech.glide.load.resource.gif;

import android.util.Log;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.EncodeStrategy;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.util.ByteBufferUtil;
import java.io.File;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class GifDrawableEncoder implements ResourceEncoder<GifDrawable> {
    private static final String TAG = "GifEncoder";

    public GifDrawableEncoder() {
    }

    @Override // com.bumptech.glide.load.Encoder
    public /* bridge */ /* synthetic */ boolean encode(@NonNull Object r10, @NonNull File r11, @NonNull Options r12) {
        return encode((Resource) r10, r11, r12);
    }

    @Override // com.bumptech.glide.load.ResourceEncoder
    @NonNull
    public EncodeStrategy getEncodeStrategy(@NonNull Options r10) {
        return EncodeStrategy.SOURCE;
    }

    public boolean encode(@NonNull Resource<GifDrawable> r10, @NonNull File r11, @NonNull Options r12) {
        ByteBufferUtil.toFile(r10.get().getBuffer(), r11);     // Catch: IOException -> L5
        return true;
    L5:
        e = move-exception;
        if (Log.isLoggable(TAG, 5) == false) goto L9;
        Log.w(TAG, "Failed to encode GIF drawable data", e);
    L9:
        return false;
    }
}
