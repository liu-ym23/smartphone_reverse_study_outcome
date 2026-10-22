package com.bumptech.glide.load.resource.bitmap;

import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes2.dex */
public class RecyclableBufferedInputStream extends FilterInputStream {
    private volatile byte[] buf;
    private final ArrayPool byteArrayPool;
    private int count;
    private int marklimit;
    private int markpos;
    private int pos;

    public static class InvalidMarkException extends IOException {
        private static final long serialVersionUID = -4338378848813561757L;

        public InvalidMarkException(String str) {
            super(str);
        }
    }

    public RecyclableBufferedInputStream(@NonNull InputStream inputStream, @NonNull ArrayPool arrayPool) {
        this(inputStream, arrayPool, 65536);
    }

    private int fillbuf(InputStream inputStream, byte[] bArr) throws IOException {
        int i = this.markpos;
        if (i != -1) {
            int i6 = this.pos - i;
            int i10 = this.marklimit;
            if (i6 < i10) {
                if (i == 0 && i10 > bArr.length && this.count == bArr.length) {
                    int length = bArr.length * 2;
                    if (length <= i10) {
                        i10 = length;
                    }
                    byte[] bArr2 = (byte[]) this.byteArrayPool.get(i10, byte[].class);
                    System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
                    this.buf = bArr2;
                    this.byteArrayPool.put(bArr);
                    bArr = bArr2;
                } else if (i > 0) {
                    System.arraycopy(bArr, i, bArr, 0, bArr.length - i);
                }
                int i11 = this.pos - this.markpos;
                this.pos = i11;
                this.markpos = 0;
                this.count = 0;
                int i12 = inputStream.read(bArr, i11, bArr.length - i11);
                int i13 = this.pos;
                if (i12 > 0) {
                    i13 += i12;
                }
                this.count = i13;
                return i12;
            }
        }
        int i14 = inputStream.read(bArr);
        if (i14 > 0) {
            this.markpos = -1;
            this.pos = 0;
            this.count = i14;
        }
        return i14;
    }

    private static IOException streamClosed() throws IOException {
        throw new IOException("BufferedInputStream is closed");
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int available() throws IOException {
        InputStream inputStream;
        inputStream = ((FilterInputStream) this).in;
        if (this.buf == null || inputStream == null) {
            throw streamClosed();
        }
        return (this.count - this.pos) + inputStream.available();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.buf != null) {
            this.byteArrayPool.put(this.buf);
            this.buf = null;
        }
        InputStream inputStream = ((FilterInputStream) this).in;
        ((FilterInputStream) this).in = null;
        if (inputStream != null) {
            inputStream.close();
        }
    }

    public synchronized void fixMarkLimit() {
        this.marklimit = this.buf.length;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void mark(int i) {
        this.marklimit = Math.max(this.marklimit, i);
        this.markpos = this.pos;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return true;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read() throws IOException {
        byte[] bArr = this.buf;
        InputStream inputStream = ((FilterInputStream) this).in;
        if (bArr == null || inputStream == null) {
            throw streamClosed();
        }
        if (this.pos >= this.count && fillbuf(inputStream, bArr) == -1) {
            return -1;
        }
        if (bArr != this.buf && (bArr = this.buf) == null) {
            throw streamClosed();
        }
        int i = this.count;
        int i6 = this.pos;
        if (i - i6 <= 0) {
            return -1;
        }
        this.pos = i6 + 1;
        return bArr[i6] & 255;
    }

    public synchronized void release() {
        if (this.buf != null) {
            this.byteArrayPool.put(this.buf);
            this.buf = null;
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void reset() throws IOException {
        if (this.buf == null) {
            throw new IOException("Stream is closed");
        }
        int i = this.markpos;
        if (-1 == i) {
            throw new InvalidMarkException("Mark has been invalidated, pos: " + this.pos + " markLimit: " + this.marklimit);
        }
        this.pos = i;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized long skip(long j5) throws IOException {
        if (j5 < 1) {
            return 0L;
        }
        byte[] bArr = this.buf;
        if (bArr == null) {
            throw streamClosed();
        }
        InputStream inputStream = ((FilterInputStream) this).in;
        if (inputStream == null) {
            throw streamClosed();
        }
        int i = this.count;
        int i6 = this.pos;
        if (i - i6 >= j5) {
            this.pos = (int) (i6 + j5);
            return j5;
        }
        long j6 = i - i6;
        this.pos = i;
        if (this.markpos == -1 || j5 > this.marklimit) {
            long jSkip = inputStream.skip(j5 - j6);
            if (jSkip > 0) {
                this.markpos = -1;
            }
            return j6 + jSkip;
        }
        if (fillbuf(inputStream, bArr) == -1) {
            return j6;
        }
        int i10 = this.count;
        int i11 = this.pos;
        if (i10 - i11 >= j5 - j6) {
            this.pos = (int) ((i11 + j5) - j6);
            return j5;
        }
        long j10 = (j6 + i10) - i11;
        this.pos = i10;
        return j10;
    }

    @VisibleForTesting
    public RecyclableBufferedInputStream(@NonNull InputStream inputStream, @NonNull ArrayPool arrayPool, int i) {
        super(inputStream);
        this.markpos = -1;
        this.byteArrayPool = arrayPool;
        this.buf = (byte[]) arrayPool.get(i, byte[].class);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read(@NonNull byte[] bArr, int i, int i6) throws IOException {
        int i10;
        int i11;
        byte[] bArr2 = this.buf;
        if (bArr2 == null) {
            throw streamClosed();
        }
        if (i6 == 0) {
            return 0;
        }
        InputStream inputStream = ((FilterInputStream) this).in;
        if (inputStream != null) {
            int i12 = this.pos;
            int i13 = this.count;
            if (i12 < i13) {
                int i14 = i13 - i12 >= i6 ? i6 : i13 - i12;
                System.arraycopy(bArr2, i12, bArr, i, i14);
                this.pos += i14;
                if (i14 == i6 || inputStream.available() == 0) {
                    return i14;
                }
                i += i14;
                i10 = i6 - i14;
            } else {
                i10 = i6;
            }
            while (true) {
                if (this.markpos == -1 && i10 >= bArr2.length) {
                    i11 = inputStream.read(bArr, i, i10);
                    if (i11 == -1) {
                        return i10 != i6 ? i6 - i10 : -1;
                    }
                } else {
                    if (fillbuf(inputStream, bArr2) == -1) {
                        return i10 != i6 ? i6 - i10 : -1;
                    }
                    if (bArr2 != this.buf && (bArr2 = this.buf) == null) {
                        throw streamClosed();
                    }
                    int i15 = this.count;
                    int i16 = this.pos;
                    i11 = i15 - i16 >= i10 ? i10 : i15 - i16;
                    System.arraycopy(bArr2, i16, bArr, i, i11);
                    this.pos += i11;
                }
                i10 -= i11;
                if (i10 == 0) {
                    return i6;
                }
                if (inputStream.available() == 0) {
                    return i6 - i10;
                }
                i += i11;
            }
        } else {
            throw streamClosed();
        }
    }
}
