package org.tukaani.xz.lz;

import android.hardware.tv.hdmi.cec.CecDeviceType;
import java.io.IOException;
import java.io.OutputStream;
import org.tukaani.xz.ArrayCache;

/* JADX INFO: loaded from: classes3.dex */
public abstract class LZEncoder {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int MF_BT4 = 20;
    public static final int MF_HC4 = 4;
    final byte[] buf;
    final int bufSize;
    private boolean finishing;
    private final int keepSizeAfter;
    private final int keepSizeBefore;
    final int matchLenMax;
    final int niceLen;
    private int pendingSize;
    private int readLimit;
    int readPos;
    private int writePos;

    public abstract Matches getMatches();

    public abstract void skip(int r1);

    static {
    }

    static void normalize(int[] positions, int positionsCount, int normalizationOffset) {
        int i = 0;
    L3:
        if (i >= positionsCount) goto L10;
        if (positions[i] > normalizationOffset) goto L7;
        positions[i] = 0;
    L8:
        i = i + 1;
        goto L3
    L7:
        positions[i] = positions[i] - normalizationOffset;
        goto L8
    }

    private static int getBufSize(int dictSize, int extraSizeBefore, int extraSizeAfter, int matchLenMax) {
        int keepSizeBefore = extraSizeBefore + dictSize;
        int keepSizeAfter = extraSizeAfter + matchLenMax;
        int reserveSize = Math.min((dictSize / 2) + 262144, 536870912);
        return (keepSizeBefore + keepSizeAfter) + reserveSize;
    }

    public static int getMemoryUsage(int dictSize, int extraSizeBefore, int extraSizeAfter, int matchLenMax, int mf) {
        int m = (getBufSize(dictSize, extraSizeBefore, extraSizeAfter, matchLenMax) / 1024) + 10;
        switch(mf) {
            case 4: goto L8;
            case 20: goto L9;
            default: goto L5;
        };
    L5:
        throw new IllegalArgumentException();
    L9:
        return m + BT4.getMemoryUsage(dictSize);
    L8:
        return m + HC4.getMemoryUsage(dictSize);
    }

    public static LZEncoder getInstance(int dictSize, int extraSizeBefore, int extraSizeAfter, int niceLen, int matchLenMax, int mf, int depthLimit, ArrayCache arrayCache) {
        switch(mf) {
            case 4: goto L8;
            case 20: goto L6;
            default: goto L4;
        };
    L4:
        throw new IllegalArgumentException();
    L6:
        return new BT4(dictSize, extraSizeBefore, extraSizeAfter, niceLen, matchLenMax, depthLimit, arrayCache);
    L8:
        return new HC4(dictSize, extraSizeBefore, extraSizeAfter, niceLen, matchLenMax, depthLimit, arrayCache);
    }

    LZEncoder(int dictSize, int extraSizeBefore, int extraSizeAfter, int niceLen, int matchLenMax, ArrayCache arrayCache) {
        this.readPos = -1;
        this.readLimit = -1;
        this.finishing = false;
        this.writePos = 0;
        this.pendingSize = 0;
        this.bufSize = getBufSize(dictSize, extraSizeBefore, extraSizeAfter, matchLenMax);
        this.buf = arrayCache.getByteArray(this.bufSize, false);
        this.keepSizeBefore = extraSizeBefore + dictSize;
        this.keepSizeAfter = extraSizeAfter + matchLenMax;
        this.matchLenMax = matchLenMax;
        this.niceLen = niceLen;
    }

    public void putArraysToCache(ArrayCache arrayCache) {
        arrayCache.putArray(this.buf);
    }

    public void setPresetDict(int dictSize, byte[] presetDict) {
        if (presetDict == null) goto L5;
        int copySize = Math.min(presetDict.length, dictSize);
        int offset = presetDict.length - copySize;
        System.arraycopy(presetDict, offset, this.buf, 0, copySize);
        this.writePos += copySize;
        skip(copySize);
        return;
    }

    private void moveWindow() {
        int moveOffset = ((this.readPos + 1) - this.keepSizeBefore) & (-16);
        int moveSize = this.writePos - moveOffset;
        System.arraycopy(this.buf, moveOffset, this.buf, 0, moveSize);
        this.readPos -= moveOffset;
        this.readLimit -= moveOffset;
        this.writePos -= moveOffset;
    }

    public int fillWindow(byte[] in, int off, int len) {
        if (this.readPos < (this.bufSize - this.keepSizeAfter)) goto L6;
        moveWindow();
    L6:
        if (len <= (this.bufSize - this.writePos)) goto L8;
        len = this.bufSize - this.writePos;
    L8:
        System.arraycopy(in, off, this.buf, this.writePos, len);
        this.writePos += len;
        if (this.writePos < this.keepSizeAfter) goto L11;
        this.readLimit = this.writePos - this.keepSizeAfter;
    L11:
        processPendingBytes();
        return len;
    }

    private void processPendingBytes() {
        if (this.pendingSize > 0) goto L5;
        return;
    L5:
        if (this.readPos >= this.readLimit) goto L9;
        this.readPos -= this.pendingSize;
        int oldPendingSize = this.pendingSize;
        this.pendingSize = 0;
        skip(oldPendingSize);
        return;
    }

    public boolean isStarted() {
        if (this.readPos == (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    public void setFlushing() {
        this.readLimit = this.writePos - 1;
        processPendingBytes();
    }

    public void setFinishing() {
        this.readLimit = this.writePos - 1;
        this.finishing = true;
        processPendingBytes();
    }

    public boolean hasEnoughData(int alreadyReadLen) {
        if ((this.readPos - alreadyReadLen) >= this.readLimit) goto L5;
        return true;
    L5:
        return false;
    }

    public void copyUncompressed(OutputStream out, int backward, int len) throws IOException {
        out.write(this.buf, (this.readPos + 1) - backward, len);
    }

    public int getAvail() {
        return this.writePos - this.readPos;
    }

    public int getPos() {
        return this.readPos;
    }

    public int getByte(int backward) {
        return this.buf[this.readPos - backward] & CecDeviceType.INACTIVE;
    }

    public int getByte(int forward, int backward) {
        return this.buf[(this.readPos + forward) - backward] & CecDeviceType.INACTIVE;
    }

    public int getMatchLen(int dist, int lenLimit) {
        int backPos = (this.readPos - dist) - 1;
        int len = 0;
    L3:
        if (len >= lenLimit) goto L7;
        if (this.buf[this.readPos + len] != this.buf[backPos + len]) goto L7;
        len = len + 1;
    L7:
        return len;
    }

    public int getMatchLen(int forward, int dist, int lenLimit) {
        int curPos = this.readPos + forward;
        int backPos = (curPos - dist) - 1;
        int len = 0;
    L3:
        if (len >= lenLimit) goto L7;
        if (this.buf[curPos + len] != this.buf[backPos + len]) goto L7;
        len = len + 1;
    L7:
        return len;
    }

    public boolean verifyMatches(Matches matches) {
        int lenLimit = Math.min(getAvail(), this.matchLenMax);
        int i = 0;
    L4:
        if (i >= matches.count) goto L10;
        if (getMatchLen(matches.dist[i], lenLimit) != matches.len[i]) goto L7;
        i = i + 1;
        goto L4
    L7:
        return false;
    L10:
        return true;
    }

    int movePos(int requiredForFlushing, int requiredForFinishing) {
        this.readPos++;
        int avail = this.writePos - this.readPos;
        if (avail >= requiredForFlushing) goto L9;
        if (avail >= requiredForFinishing) goto L6;
    L7:
        this.pendingSize++;
        return 0;
    L6:
        if (this.finishing == false) goto L7;
        return avail;
    L9:
        return avail;
    }
}
