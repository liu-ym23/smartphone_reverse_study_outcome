package com.bumptech.glide.load.model;

import android.util.Log;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.Encoder;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public class StreamEncoder implements Encoder<InputStream> {
    private static final String TAG = "StreamEncoder";
    private final ArrayPool byteArrayPool;

    public StreamEncoder(ArrayPool r10) {
        this.byteArrayPool = r10;
    }

    @Override // com.bumptech.glide.load.Encoder
    public /* bridge */ /* synthetic */ boolean encode(@NonNull InputStream r10, @NonNull File r11, @NonNull Options r12) {
        return encode2(r10, r11, r12);
    }

    /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
    public boolean encode2(@NonNull InputStream r10, @NonNull File r11, @NonNull Options r12) {
        byte[] r13 = (byte[]) this.byteArrayPool.get(65536, byte[].class);
        FileOutputStream r14 = null;
        FileOutputStream r15 = new FileOutputStream(r11);     // Catch: Throwable -> L14 IOException -> L16
    L40:
        int r16 = r10.read(r13);     // Catch: Throwable -> L7 IOException -> L9
        if (r16 == (-1)) goto L11;
        r15.write(r13, 0, r16);     // Catch: Throwable -> L7 IOException -> L9
        goto L40
    L11:
        r15.close();     // Catch: Throwable -> L7 IOException -> L9
        r15.close();     // Catch: IOException -> L29
    L13:
        this.byteArrayPool.put(r13);
        return true;
    L9:
        e = e;
        r14 = r15;
    L19:
        if (Log.isLoggable(TAG, 3) == false) goto L21;
        Log.d(TAG, "Failed to encode data onto the OutputStream", e);     // Catch: Throwable -> L14
    L21:
        if (r14 != null) goto L32;
    L23:
        this.byteArrayPool.put(r13);
        return false;
    L32:
        r14.close();     // Catch: IOException -> L31
    L7:
        th = th;
        r14 = r15;
    L25:
        if (r14 != null) goto L36;
    L27:
        this.byteArrayPool.put(r13);
        throw th;
    L36:
        r14.close();     // Catch: IOException -> L30
    L14:
        th = th;
    L16:
        e = e;
        goto L19
    }
}
