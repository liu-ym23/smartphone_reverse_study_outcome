package com.bumptech.glide.load.model;

import android.util.Log;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.Encoder;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.util.ByteBufferUtil;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public class ByteBufferEncoder implements Encoder<ByteBuffer> {
    private static final String TAG = "ByteBufferEncoder";

    public ByteBufferEncoder() {
    }

    @Override // com.bumptech.glide.load.Encoder
    public /* bridge */ /* synthetic */ boolean encode(@NonNull ByteBuffer r10, @NonNull File r11, @NonNull Options r12) {
        return encode2(r10, r11, r12);
    }

    /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
    public boolean encode2(@NonNull ByteBuffer r10, @NonNull File r11, @NonNull Options r12) {
        ByteBufferUtil.toFile(r10, r11);     // Catch: IOException -> L4
        return true;
    L4:
        e = move-exception;
        if (Log.isLoggable(TAG, 3) == false) goto L8;
        Log.d(TAG, "Failed to write data", e);
    L8:
        return false;
    }
}
