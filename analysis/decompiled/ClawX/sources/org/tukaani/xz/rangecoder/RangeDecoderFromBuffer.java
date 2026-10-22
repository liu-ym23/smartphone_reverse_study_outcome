package org.tukaani.xz.rangecoder;

import java.io.DataInputStream;
import java.io.IOException;
import org.tukaani.xz.ArrayCache;
import org.tukaani.xz.CorruptedInputException;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class RangeDecoderFromBuffer extends RangeDecoder {
    private static final int INIT_SIZE = 5;
    private final byte[] buf;
    private int pos;

    public RangeDecoderFromBuffer(int i8, ArrayCache arrayCache) {
        byte[] byteArray = arrayCache.getByteArray(i8 - 5, false);
        this.buf = byteArray;
        this.pos = byteArray.length;
    }

    public boolean isFinished() {
        return this.pos == this.buf.length && this.code == 0;
    }

    @Override // org.tukaani.xz.rangecoder.RangeDecoder
    public void normalize() throws CorruptedInputException {
        int i8 = this.range;
        if (((-16777216) & i8) == 0) {
            try {
                int i9 = this.code << 8;
                byte[] bArr = this.buf;
                int i10 = this.pos;
                this.pos = i10 + 1;
                this.code = i9 | (bArr[i10] & 255);
                this.range = i8 << 8;
            } catch (ArrayIndexOutOfBoundsException unused) {
                throw new CorruptedInputException();
            }
        }
    }

    public void prepareInputBuffer(DataInputStream dataInputStream, int i8) throws IOException {
        if (i8 < 5) {
            throw new CorruptedInputException();
        }
        if (dataInputStream.readUnsignedByte() != 0) {
            throw new CorruptedInputException();
        }
        this.code = dataInputStream.readInt();
        this.range = -1;
        int i9 = i8 - 5;
        byte[] bArr = this.buf;
        int length = bArr.length - i9;
        this.pos = length;
        dataInputStream.readFully(bArr, length, i9);
    }

    public void putArraysToCache(ArrayCache arrayCache) {
        arrayCache.putArray(this.buf);
    }
}
