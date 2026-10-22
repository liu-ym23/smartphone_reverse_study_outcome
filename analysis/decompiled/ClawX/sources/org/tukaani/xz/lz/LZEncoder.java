package org.tukaani.xz.lz;

import java.io.IOException;
import java.io.OutputStream;
import org.tukaani.xz.ArrayCache;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public abstract class LZEncoder {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int MF_BT4 = 20;
    public static final int MF_HC4 = 4;
    final byte[] buf;
    final int bufSize;
    private final int keepSizeAfter;
    private final int keepSizeBefore;
    final int matchLenMax;
    final int niceLen;
    int readPos = -1;
    private int readLimit = -1;
    private boolean finishing = false;
    private int writePos = 0;
    private int pendingSize = 0;

    public LZEncoder(int i8, int i9, int i10, int i11, int i12, ArrayCache arrayCache) {
        int bufSize = getBufSize(i8, i9, i10, i12);
        this.bufSize = bufSize;
        this.buf = arrayCache.getByteArray(bufSize, false);
        this.keepSizeBefore = i9 + i8;
        this.keepSizeAfter = i10 + i12;
        this.matchLenMax = i12;
        this.niceLen = i11;
    }

    private static int getBufSize(int i8, int i9, int i10, int i11) {
        return i9 + i8 + i10 + i11 + Math.min((i8 / 2) + 262144, 536870912);
    }

    public static LZEncoder getInstance(int i8, int i9, int i10, int i11, int i12, int i13, int i14, ArrayCache arrayCache) {
        if (i13 == 4) {
            return new HC4(i8, i9, i10, i11, i12, i14, arrayCache);
        }
        if (i13 == 20) {
            return new BT4(i8, i9, i10, i11, i12, i14, arrayCache);
        }
        throw new IllegalArgumentException();
    }

    public static int getMemoryUsage(int i8, int i9, int i10, int i11, int i12) {
        int memoryUsage;
        int bufSize = (getBufSize(i8, i9, i10, i11) / 1024) + 10;
        if (i12 == 4) {
            memoryUsage = HC4.getMemoryUsage(i8);
        } else {
            if (i12 != 20) {
                throw new IllegalArgumentException();
            }
            memoryUsage = BT4.getMemoryUsage(i8);
        }
        return bufSize + memoryUsage;
    }

    private void moveWindow() {
        int i8 = ((this.readPos + 1) - this.keepSizeBefore) & (-16);
        int i9 = this.writePos - i8;
        byte[] bArr = this.buf;
        System.arraycopy(bArr, i8, bArr, 0, i9);
        this.readPos -= i8;
        this.readLimit -= i8;
        this.writePos -= i8;
    }

    public static void normalize(int[] iArr, int i8, int i9) {
        for (int i10 = 0; i10 < i8; i10++) {
            int i11 = iArr[i10];
            if (i11 <= i9) {
                iArr[i10] = 0;
            } else {
                iArr[i10] = i11 - i9;
            }
        }
    }

    private void processPendingBytes() {
        int i8;
        int i9 = this.pendingSize;
        if (i9 <= 0 || (i8 = this.readPos) >= this.readLimit) {
            return;
        }
        this.readPos = i8 - i9;
        this.pendingSize = 0;
        skip(i9);
    }

    public void copyUncompressed(OutputStream outputStream, int i8, int i9) throws IOException {
        outputStream.write(this.buf, (this.readPos + 1) - i8, i9);
    }

    public int fillWindow(byte[] bArr, int i8, int i9) {
        if (this.readPos >= this.bufSize - this.keepSizeAfter) {
            moveWindow();
        }
        int i10 = this.bufSize;
        int i11 = this.writePos;
        if (i9 > i10 - i11) {
            i9 = i10 - i11;
        }
        System.arraycopy(bArr, i8, this.buf, i11, i9);
        int i12 = this.writePos + i9;
        this.writePos = i12;
        int i13 = this.keepSizeAfter;
        if (i12 >= i13) {
            this.readLimit = i12 - i13;
        }
        processPendingBytes();
        return i9;
    }

    public int getAvail() {
        return this.writePos - this.readPos;
    }

    public int getByte(int i8) {
        return this.buf[this.readPos - i8] & 255;
    }

    public int getMatchLen(int i8, int i9) {
        return MatchLength.getLen(this.buf, this.readPos, i8 + 1, 0, i9);
    }

    public abstract Matches getMatches();

    public int getPos() {
        return this.readPos;
    }

    public boolean hasEnoughData(int i8) {
        return this.readPos - i8 < this.readLimit;
    }

    public boolean isStarted() {
        return this.readPos != -1;
    }

    public int movePos(int i8, int i9) {
        int i10 = this.readPos + 1;
        this.readPos = i10;
        int i11 = this.writePos - i10;
        if (i11 >= i8 || (i11 >= i9 && this.finishing)) {
            return i11;
        }
        this.pendingSize++;
        return 0;
    }

    public void putArraysToCache(ArrayCache arrayCache) {
        arrayCache.putArray(this.buf);
    }

    public void setFinishing() {
        this.readLimit = this.writePos - 1;
        this.finishing = true;
        processPendingBytes();
    }

    public void setFlushing() {
        this.readLimit = this.writePos - 1;
        processPendingBytes();
    }

    public void setPresetDict(int i8, byte[] bArr) {
        if (bArr != null) {
            int iMin = Math.min(bArr.length, i8);
            System.arraycopy(bArr, bArr.length - iMin, this.buf, 0, iMin);
            this.writePos += iMin;
            skip(iMin);
        }
    }

    public abstract void skip(int i8);

    public boolean verifyMatches(Matches matches) {
        int iMin = Math.min(getAvail(), this.matchLenMax);
        for (int i8 = 0; i8 < matches.count; i8++) {
            if (getMatchLen(matches.dist[i8], iMin) != matches.len[i8]) {
                return false;
            }
        }
        return true;
    }

    public int getByte(int i8, int i9) {
        return this.buf[(this.readPos + i8) - i9] & 255;
    }

    public int getMatchLen(int i8, int i9, int i10) {
        return MatchLength.getLen(this.buf, this.readPos + i8, i9 + 1, 0, i10);
    }
}
