package org.bouncycastle.util.io;

import java.io.IOException;
import java.io.OutputStream;
import org.bouncycastle.util.Arrays;

/* loaded from: classes.dex */
public class BufferingOutputStream extends OutputStream {
    private final byte[] buf;
    private int bufOff;
    private final OutputStream other;

    public BufferingOutputStream(OutputStream outputStream) {
        this.other = outputStream;
        this.buf = new byte[4096];
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        flush();
        this.other.close();
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        this.other.write(this.buf, 0, this.bufOff);
        this.bufOff = 0;
        Arrays.fill(this.buf, (byte) 0);
    }

    @Override // java.io.OutputStream
    public void write(int i8) throws IOException {
        byte[] bArr = this.buf;
        int i9 = this.bufOff;
        int i10 = i9 + 1;
        this.bufOff = i10;
        bArr[i9] = (byte) i8;
        if (i10 == bArr.length) {
            flush();
        }
    }

    public BufferingOutputStream(OutputStream outputStream, int i8) {
        this.other = outputStream;
        this.buf = new byte[i8];
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i8, int i9) throws IOException {
        byte[] bArr2;
        byte[] bArr3 = this.buf;
        int length = bArr3.length;
        int i10 = this.bufOff;
        if (i9 < length - i10) {
            System.arraycopy(bArr, i8, bArr3, i10, i9);
        } else {
            int length2 = bArr3.length - i10;
            System.arraycopy(bArr, i8, bArr3, i10, length2);
            this.bufOff += length2;
            flush();
            int length3 = i8 + length2;
            i9 -= length2;
            while (true) {
                bArr2 = this.buf;
                if (i9 < bArr2.length) {
                    break;
                }
                this.other.write(bArr, length3, bArr2.length);
                byte[] bArr4 = this.buf;
                length3 += bArr4.length;
                i9 -= bArr4.length;
            }
            if (i9 <= 0) {
                return;
            } else {
                System.arraycopy(bArr, length3, bArr2, this.bufOff, i9);
            }
        }
        this.bufOff += i9;
    }
}
