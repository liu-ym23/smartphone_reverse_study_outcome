package com.fasterxml.jackson.core.io;

import java.io.IOException;
import java.io.InputStream;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class MergedStream extends InputStream {
    private byte[] _b;
    private final IOContext _ctxt;
    private final int _end;
    private final InputStream _in;
    private int _ptr;

    public MergedStream(IOContext iOContext, InputStream inputStream, byte[] bArr, int i, int i3) {
        this._ctxt = iOContext;
        this._in = inputStream;
        this._b = bArr;
        this._ptr = i;
        this._end = i3;
    }

    private void _free() {
        byte[] bArr = this._b;
        if (bArr != null) {
            this._b = null;
            IOContext iOContext = this._ctxt;
            if (iOContext != null) {
                iOContext.releaseReadIOBuffer(bArr);
            }
        }
    }

    @Override // java.io.InputStream
    public int available() {
        return this._b != null ? this._end - this._ptr : this._in.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        _free();
        this._in.close();
    }

    @Override // java.io.InputStream
    public synchronized void mark(int i) {
        if (this._b == null) {
            this._in.mark(i);
        }
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return this._b == null && this._in.markSupported();
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i3) {
        byte[] bArr2 = this._b;
        if (bArr2 == null) {
            return this._in.read(bArr, i, i3);
        }
        int i10 = this._end;
        int i11 = this._ptr;
        int i12 = i10 - i11;
        if (i3 > i12) {
            i3 = i12;
        }
        System.arraycopy(bArr2, i11, bArr, i, i3);
        int i13 = this._ptr + i3;
        this._ptr = i13;
        if (i13 >= this._end) {
            _free();
        }
        return i3;
    }

    @Override // java.io.InputStream
    public synchronized void reset() {
        if (this._b == null) {
            this._in.reset();
        }
    }

    @Override // java.io.InputStream
    public long skip(long j10) {
        long j11;
        if (this._b != null) {
            int i = this._end;
            int i3 = this._ptr;
            j11 = i - i3;
            if (j11 > j10) {
                this._ptr = i3 + ((int) j10);
                return j10;
            }
            _free();
            j10 -= j11;
        } else {
            j11 = 0;
        }
        return j10 > 0 ? this._in.skip(j10) + j11 : j11;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.InputStream
    public int read() {
        byte[] bArr = this._b;
        if (bArr != null) {
            int i = this._ptr;
            int i3 = i + 1;
            this._ptr = i3;
            int i10 = bArr[i] & 255;
            if (i3 >= this._end) {
                _free();
            }
            return i10;
        }
        return this._in.read();
    }
}
