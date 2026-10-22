package com.fasterxml.jackson.databind.util;

import java.io.InputStream;
import java.nio.ByteBuffer;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class ByteBufferBackedInputStream extends InputStream {
    protected final ByteBuffer _b;

    public ByteBufferBackedInputStream(ByteBuffer byteBuffer) {
        this._b = byteBuffer;
    }

    @Override // java.io.InputStream
    public int available() {
        return this._b.remaining();
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i3) {
        if (!this._b.hasRemaining()) {
            return -1;
        }
        int iMin = Math.min(i3, this._b.remaining());
        this._b.get(bArr, i, iMin);
        return iMin;
    }

    @Override // java.io.InputStream
    public int read() {
        if (this._b.hasRemaining()) {
            return this._b.get() & 255;
        }
        return -1;
    }
}
