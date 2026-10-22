package org.tukaani.xz.lz;

import java.io.DataInputStream;
import java.io.IOException;
import org.tukaani.xz.ArrayCache;
import org.tukaani.xz.CorruptedInputException;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class LZDecoder {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final byte[] buf;
    private final int bufSize;
    private int full;
    private int pos;
    private int start;
    private int limit = 0;
    private int pendingLen = 0;
    private int pendingDist = 0;

    public LZDecoder(int i8, byte[] bArr, ArrayCache arrayCache) {
        this.start = 0;
        this.pos = 0;
        this.full = 0;
        this.bufSize = i8;
        byte[] byteArray = arrayCache.getByteArray(i8, false);
        this.buf = byteArray;
        if (bArr != null) {
            int iMin = Math.min(bArr.length, i8);
            this.pos = iMin;
            this.full = iMin;
            this.start = iMin;
            System.arraycopy(bArr, bArr.length - iMin, byteArray, 0, iMin);
        }
    }

    public void copyUncompressed(DataInputStream dataInputStream, int i8) throws IOException {
        int iMin = Math.min(this.bufSize - this.pos, i8);
        dataInputStream.readFully(this.buf, this.pos, iMin);
        int i9 = this.pos + iMin;
        this.pos = i9;
        if (this.full < i9) {
            this.full = i9;
        }
    }

    public int flush(byte[] bArr, int i8) {
        int i9 = this.pos;
        int i10 = this.start;
        int i11 = i9 - i10;
        if (i9 == this.bufSize) {
            this.pos = 0;
        }
        System.arraycopy(this.buf, i10, bArr, i8, i11);
        this.start = this.pos;
        return i11;
    }

    public int getByte(int i8) {
        int i9 = this.pos;
        int i10 = (i9 - i8) - 1;
        if (i8 >= i9) {
            i10 += this.bufSize;
        }
        return this.buf[i10] & 255;
    }

    public int getPos() {
        return this.pos;
    }

    public boolean hasPending() {
        return this.pendingLen > 0;
    }

    public boolean hasSpace() {
        return this.pos < this.limit;
    }

    public void putArraysToCache(ArrayCache arrayCache) {
        arrayCache.putArray(this.buf);
    }

    public void putByte(byte b9) {
        byte[] bArr = this.buf;
        int i8 = this.pos;
        int i9 = i8 + 1;
        this.pos = i9;
        bArr[i8] = b9;
        if (this.full < i9) {
            this.full = i9;
        }
    }

    public void repeat(int i8, int i9) throws CorruptedInputException {
        int i10;
        if (i8 < 0 || i8 >= this.full) {
            throw new CorruptedInputException();
        }
        int iMin = Math.min(this.limit - this.pos, i9);
        this.pendingLen = i9 - iMin;
        this.pendingDist = i8;
        int i11 = (this.pos - i8) - 1;
        if (i11 < 0) {
            int i12 = this.bufSize;
            int i13 = i11 + i12;
            int iMin2 = Math.min(i12 - i13, iMin);
            byte[] bArr = this.buf;
            System.arraycopy(bArr, i13, bArr, this.pos, iMin2);
            this.pos += iMin2;
            iMin -= iMin2;
            if (iMin == 0) {
                return;
            } else {
                i11 = 0;
            }
        }
        do {
            int iMin3 = Math.min(iMin, this.pos - i11);
            byte[] bArr2 = this.buf;
            System.arraycopy(bArr2, i11, bArr2, this.pos, iMin3);
            i10 = this.pos + iMin3;
            this.pos = i10;
            iMin -= iMin3;
        } while (iMin > 0);
        if (this.full < i10) {
            this.full = i10;
        }
    }

    public void repeatPending() throws CorruptedInputException {
        int i8 = this.pendingLen;
        if (i8 > 0) {
            repeat(this.pendingDist, i8);
        }
    }

    public void reset() {
        this.start = 0;
        this.pos = 0;
        this.full = 0;
        this.limit = 0;
        this.buf[this.bufSize - 1] = 0;
    }

    public void setLimit(int i8) {
        int i9 = this.bufSize;
        int i10 = this.pos;
        if (i9 - i10 <= i8) {
            this.limit = i9;
        } else {
            this.limit = i10 + i8;
        }
    }
}
