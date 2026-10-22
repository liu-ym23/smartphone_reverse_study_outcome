package org.tukaani.xz.rangecoder;

import java.io.IOException;
import java.io.OutputStream;
import org.tukaani.xz.ArrayCache;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class RangeEncoderToBuffer extends RangeEncoder {
    private final byte[] buf;
    private int bufPos;

    public RangeEncoderToBuffer(int i8, ArrayCache arrayCache) {
        this.buf = arrayCache.getByteArray(i8, false);
        reset();
    }

    @Override // org.tukaani.xz.rangecoder.RangeEncoder
    public int finish() {
        try {
            super.finish();
            return this.bufPos;
        } catch (IOException unused) {
            throw new Error();
        }
    }

    @Override // org.tukaani.xz.rangecoder.RangeEncoder
    public int getPendingSize() {
        return this.bufPos + ((int) this.cacheSize) + 4;
    }

    public void putArraysToCache(ArrayCache arrayCache) {
        arrayCache.putArray(this.buf);
    }

    @Override // org.tukaani.xz.rangecoder.RangeEncoder
    public void reset() {
        super.reset();
        this.bufPos = 0;
    }

    public void write(OutputStream outputStream) throws IOException {
        outputStream.write(this.buf, 0, this.bufPos);
    }

    @Override // org.tukaani.xz.rangecoder.RangeEncoder
    public void writeByte(int i8) {
        byte[] bArr = this.buf;
        int i9 = this.bufPos;
        this.bufPos = i9 + 1;
        bArr[i9] = (byte) i8;
    }
}
