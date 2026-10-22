package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.util.ExceptionCatchingInputStream;
import com.bumptech.glide.util.MarkEnforcingInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public class StreamBitmapDecoder implements ResourceDecoder<InputStream, Bitmap> {
    private final ArrayPool byteArrayPool;
    private final Downsampler downsampler;

    public static class UntrustedCallbacks implements Downsampler.DecodeCallbacks {
        private final RecyclableBufferedInputStream bufferedStream;
        private final ExceptionCatchingInputStream exceptionStream;

        public UntrustedCallbacks(RecyclableBufferedInputStream r10, ExceptionCatchingInputStream r11) {
            this.bufferedStream = r10;
            this.exceptionStream = r11;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.Downsampler.DecodeCallbacks
        public void onDecodeComplete(BitmapPool r10, Bitmap r11) throws IOException {
            IOException r12 = this.exceptionStream.getException();
            if (r12 == null) goto L7;
            if (r11 == null) goto L8;
            r10.put(r11);
            throw r12;
        L8:
            throw r12;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.Downsampler.DecodeCallbacks
        public void onObtainBounds() {
            this.bufferedStream.fixMarkLimit();
        }
    }

    public StreamBitmapDecoder(Downsampler r10, ArrayPool r11) {
        this.downsampler = r10;
        this.byteArrayPool = r11;
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public /* bridge */ /* synthetic */ Resource<Bitmap> decode(@NonNull InputStream r10, int r11, int r12, @NonNull Options r13) throws IOException {
        return decode2(r10, r11, r12, r13);
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public /* bridge */ /* synthetic */ boolean handles(@NonNull InputStream r10, @NonNull Options r11) throws IOException {
        return handles2(r10, r11);
    }

    /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
    public Resource<Bitmap> decode2(@NonNull InputStream r10, int r11, int r12, @NonNull Options r13) throws IOException {
        if ((r10 instanceof RecyclableBufferedInputStream) == false) goto L5;
        RecyclableBufferedInputStream r14 = (RecyclableBufferedInputStream) r10;
        boolean r15 = false;
    L6:
        ExceptionCatchingInputStream r16 = ExceptionCatchingInputStream.obtain(r14);
        Resource<Bitmap> r17 = this.downsampler.decode(new MarkEnforcingInputStream(r16), r11, r12, r13, new UntrustedCallbacks(r14, r16));     // Catch: Throwable -> L12
        r16.release();
        if (r15 == false) goto L11;
        r14.release();
    L11:
        return r17;
    L12:
        th = move-exception;
        r16.release();
        if (r15 == false) goto L16;
        r14.release();
    L16:
        throw th;
    L5:
        r15 = true;
        r14 = new RecyclableBufferedInputStream(r10, this.byteArrayPool);
        goto L6
    }

    /* JADX INFO: renamed from: handles, reason: avoid collision after fix types in other method */
    public boolean handles2(@NonNull InputStream r10, @NonNull Options r11) {
        return this.downsampler.handles(r10);
    }
}
