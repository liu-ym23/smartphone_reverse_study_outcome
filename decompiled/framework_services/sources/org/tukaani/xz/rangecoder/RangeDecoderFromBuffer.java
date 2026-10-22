package org.tukaani.xz.rangecoder;

import android.hardware.audio.common.V2_0.AudioFormat;
import android.hardware.tv.hdmi.cec.CecDeviceType;
import java.io.DataInputStream;
import java.io.IOException;
import org.tukaani.xz.ArrayCache;
import org.tukaani.xz.CorruptedInputException;

/* JADX INFO: loaded from: classes3.dex */
public final class RangeDecoderFromBuffer extends RangeDecoder {
    private static final int INIT_SIZE = 5;
    private final byte[] buf;
    private int pos;

    public RangeDecoderFromBuffer(int inputSizeMax, ArrayCache arrayCache) {
        this.buf = arrayCache.getByteArray(inputSizeMax - 5, false);
        this.pos = this.buf.length;
    }

    public void putArraysToCache(ArrayCache arrayCache) {
        arrayCache.putArray(this.buf);
    }

    public void prepareInputBuffer(DataInputStream in, int len) throws IOException {
        if (len < 5) goto L11;
        if (in.readUnsignedByte() != 0) goto L9;
        this.code = in.readInt();
        this.range = -1;
        int len2 = len - 5;
        this.pos = this.buf.length - len2;
        in.readFully(this.buf, this.pos, len2);
        return;
    L9:
        throw new CorruptedInputException();
    L11:
        throw new CorruptedInputException();
    }

    public boolean isFinished() {
        if (this.pos == this.buf.length) goto L5;
    L7:
        return false;
    L5:
        if (this.code != 0) goto L7;
        return true;
    }

    @Override // org.tukaani.xz.rangecoder.RangeDecoder
    public void normalize() throws IOException {
        if ((this.range & AudioFormat.MAIN_MASK) == 0) goto L10;
        return;
    L10:
        int r0 = this.code << 8;     // Catch: ArrayIndexOutOfBoundsException -> L6
        byte[] r1 = this.buf;     // Catch: ArrayIndexOutOfBoundsException -> L6
        int r2 = this.pos;     // Catch: ArrayIndexOutOfBoundsException -> L6
        this.pos = r2 + 1;     // Catch: ArrayIndexOutOfBoundsException -> L6
        this.code = r0 | (r1[r2] & CecDeviceType.INACTIVE);     // Catch: ArrayIndexOutOfBoundsException -> L6
        this.range <<= 8;     // Catch: ArrayIndexOutOfBoundsException -> L6
        return;
    L8:
        throw new CorruptedInputException();
    }
}
