package org.tukaani.xz.lz;

import android.hardware.tv.hdmi.cec.CecDeviceType;
import java.io.DataInputStream;
import java.io.IOException;
import org.tukaani.xz.ArrayCache;
import org.tukaani.xz.CorruptedInputException;

/* JADX INFO: loaded from: classes3.dex */
public final class LZDecoder {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final byte[] buf;
    private final int bufSize;
    private int full;
    private int limit;
    private int pendingDist;
    private int pendingLen;
    private int pos;
    private int start;

    static {
    }

    public LZDecoder(int dictSize, byte[] presetDict, ArrayCache arrayCache) {
        this.start = 0;
        this.pos = 0;
        this.full = 0;
        this.limit = 0;
        this.pendingLen = 0;
        this.pendingDist = 0;
        this.bufSize = dictSize;
        this.buf = arrayCache.getByteArray(this.bufSize, false);
        if (presetDict == null) goto L6;
        this.pos = Math.min(presetDict.length, dictSize);
        this.full = this.pos;
        this.start = this.pos;
        System.arraycopy(presetDict, presetDict.length - this.pos, this.buf, 0, this.pos);
        return;
    }

    public void putArraysToCache(ArrayCache arrayCache) {
        arrayCache.putArray(this.buf);
    }

    public void reset() {
        this.start = 0;
        this.pos = 0;
        this.full = 0;
        this.limit = 0;
        this.buf[this.bufSize - 1] = 0;
    }

    public void setLimit(int outMax) {
        if ((this.bufSize - this.pos) > outMax) goto L5;
        this.limit = this.bufSize;
        return;
    L5:
        this.limit = this.pos + outMax;
    }

    public boolean hasSpace() {
        if (this.pos >= this.limit) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean hasPending() {
        if (this.pendingLen <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public int getPos() {
        return this.pos;
    }

    public int getByte(int dist) {
        int offset = (this.pos - dist) - 1;
        if (dist < this.pos) goto L6;
        offset = offset + this.bufSize;
    L6:
        return this.buf[offset] & CecDeviceType.INACTIVE;
    }

    public void putByte(byte b) {
        byte[] r0 = this.buf;
        int r1 = this.pos;
        this.pos = r1 + 1;
        r0[r1] = b;
        if (this.full >= this.pos) goto L6;
        this.full = this.pos;
        return;
    }

    public void repeat(int dist, int len) throws IOException {
        if (dist < 0) goto L18;
        if (dist >= this.full) goto L18;
        int left = Math.min(this.limit - this.pos, len);
        this.pendingLen = len - left;
        this.pendingDist = dist;
        int back = (this.pos - dist) - 1;
        if (back >= 0) goto L11;
        int back2 = back + this.bufSize;
        int copySize = Math.min(this.bufSize - back2, left);
        System.arraycopy(this.buf, back2, this.buf, this.pos, copySize);
        this.pos += copySize;
        back = 0;
        left = left - copySize;
        if (left != 0) goto L11;
        return;
    L11:
        int copySize2 = Math.min(left, this.pos - back);
        System.arraycopy(this.buf, back, this.buf, this.pos, copySize2);
        this.pos += copySize2;
        left = left - copySize2;
        if (left > 0) goto L11;
        if (this.full >= this.pos) goto L22;
        this.full = this.pos;
        return;
    L22:
        return;
    L18:
        throw new CorruptedInputException();
    }

    public void repeatPending() throws IOException {
        if (this.pendingLen <= 0) goto L6;
        repeat(this.pendingDist, this.pendingLen);
        return;
    }

    public void copyUncompressed(DataInputStream inData, int len) throws IOException {
        int copySize = Math.min(this.bufSize - this.pos, len);
        inData.readFully(this.buf, this.pos, copySize);
        this.pos += copySize;
        if (this.full >= this.pos) goto L6;
        this.full = this.pos;
        return;
    }

    public int flush(byte[] out, int outOff) {
        int copySize = this.pos - this.start;
        if (this.pos != this.bufSize) goto L5;
        this.pos = 0;
    L5:
        System.arraycopy(this.buf, this.start, out, outOff, copySize);
        this.start = this.pos;
        return copySize;
    }
}
