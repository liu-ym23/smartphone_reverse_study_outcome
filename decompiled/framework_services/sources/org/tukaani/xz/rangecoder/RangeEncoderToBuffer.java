package org.tukaani.xz.rangecoder;

import java.io.IOException;
import java.io.OutputStream;
import org.tukaani.xz.ArrayCache;

/* JADX INFO: loaded from: classes3.dex */
public final class RangeEncoderToBuffer extends RangeEncoder {
    private final byte[] buf;
    private int bufPos;

    public RangeEncoderToBuffer(int bufSize, ArrayCache arrayCache) {
        this.buf = arrayCache.getByteArray(bufSize, false);
        reset();
    }

    public void putArraysToCache(ArrayCache arrayCache) {
        arrayCache.putArray(this.buf);
    }

    @Override // org.tukaani.xz.rangecoder.RangeEncoder
    public void reset() {
        super.reset();
        this.bufPos = 0;
    }

    @Override // org.tukaani.xz.rangecoder.RangeEncoder
    public int getPendingSize() {
        return ((this.bufPos + ((int) this.cacheSize)) + 5) - 1;
    }

    @Override // org.tukaani.xz.rangecoder.RangeEncoder
    public int finish() {
        super.finish();     // Catch: IOException -> L5
        return this.bufPos;
    L7:
        throw new Error();
    }

    public void write(OutputStream out) throws IOException {
        out.write(this.buf, 0, this.bufPos);
    }

    @Override // org.tukaani.xz.rangecoder.RangeEncoder
    void writeByte(int b) {
        byte[] r0 = this.buf;
        int r1 = this.bufPos;
        this.bufPos = r1 + 1;
        r0[r1] = (byte) b;
    }
}
