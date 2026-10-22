package org.bouncycastle.util.io;

import java.io.OutputStream;

/* loaded from: classes.dex */
public class LimitedBuffer extends OutputStream {
    private final byte[] buf;
    private int count = 0;

    public LimitedBuffer(int i8) {
        this.buf = new byte[i8];
    }

    public int copyTo(byte[] bArr, int i8) {
        System.arraycopy(this.buf, 0, bArr, i8, this.count);
        return this.count;
    }

    public int limit() {
        return this.buf.length;
    }

    public void reset() {
        this.count = 0;
    }

    public int size() {
        return this.count;
    }

    @Override // java.io.OutputStream
    public void write(int i8) {
        byte[] bArr = this.buf;
        int i9 = this.count;
        this.count = i9 + 1;
        bArr[i9] = (byte) i8;
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) {
        System.arraycopy(bArr, 0, this.buf, this.count, bArr.length);
        this.count += bArr.length;
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i8, int i9) {
        System.arraycopy(bArr, i8, this.buf, this.count, i9);
        this.count += i9;
    }
}
