package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.util.ExceptionCatchingInputStream;
import com.bumptech.glide.util.MarkEnforcingInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes39.dex */
public class StreamBitmapDecoder implements ResourceDecoder<InputStream, Bitmap> {
    private final ArrayPool byteArrayPool;
    private final Downsampler downsampler;

    public static class UntrustedCallbacks implements Downsampler.DecodeCallbacks {
        private final RecyclableBufferedInputStream bufferedStream;
        private final ExceptionCatchingInputStream exceptionStream;

        @Override // com.bumptech.glide.load.resource.bitmap.Downsampler.DecodeCallbacks
        public void onObtainBounds() {
            this.bufferedStream.fixMarkLimit();
        }

        public UntrustedCallbacks(RecyclableBufferedInputStream r100, ExceptionCatchingInputStream r101) {
            this.bufferedStream = r100;
            this.exceptionStream = r101;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.Downsampler.DecodeCallbacks
        public void onDecodeComplete(BitmapPool r100, Bitmap r101) throws IOException {
            IOException r102 = this.exceptionStream.getException();
            if (r102 == null) goto L7;
            if (r101 == null) goto L8;
            r100.put(r101);
            throw r102;
        L8:
            throw r102;
        }
    }

    public StreamBitmapDecoder(Downsampler r100, ArrayPool r101) {
        this.downsampler = r100;
        this.byteArrayPool = r101;
    }

    /* JADX INFO: renamed from: handles, reason: avoid collision after fix types in other method */
    public boolean handles2(InputStream r100, Options r101) {
        return this.downsampler.handles(r100);
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public /* bridge */ /* synthetic */ boolean handles(InputStream r100, Options r101) throws IOException {
        return handles2(r100, r101);
    }

    /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
    public Resource<Bitmap> decode2(InputStream r100, int r110, int r111, Options r112) throws IOException {
        if ((r100 instanceof RecyclableBufferedInputStream) == false) goto L5;
        RecyclableBufferedInputStream r101 = (RecyclableBufferedInputStream) r100;
        boolean r102 = false;
    L6:
        ExceptionCatchingInputStream r103 = ExceptionCatchingInputStream.obtain(r101);
        MarkEnforcingInputStream r104 = new MarkEnforcingInputStream(r103);
        UntrustedCallbacks r105 = new UntrustedCallbacks(r101, r103);
        Resource<Bitmap> r113 = this.downsampler.decode(r104, r110, r111, r112, r105);     // Catch: Throwable -> L12
        r103.release();
        if (r102 == false) goto L11;
        r101.release();
    L11:
        return r113;
    L12:
        th = move-exception;
        r103.release();
        if (r102 == false) goto L16;
        r101.release();
    L16:
        throw th;
    L5:
        r101 = new RecyclableBufferedInputStream(r100, this.byteArrayPool);
        r102 = true;
        goto L6
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public /* bridge */ /* synthetic */ Resource<Bitmap> decode(InputStream r100, int r101, int r102, Options r103) throws IOException {
        return decode2(r100, r101, r102, r103);
    }
}
