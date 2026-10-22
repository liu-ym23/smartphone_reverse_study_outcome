package com.ttreader.tttext.lite;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes4.dex */
public class BBufferInputStream {
    private final byte[] buffer;
    private final ByteBuffer byteBuffer;

    public BBufferInputStream(byte[] r2) {
        this.byteBuffer = ByteBuffer.wrap(r2);
        this.buffer = r2;
    }

    public int available() {
        return this.byteBuffer.limit() - this.byteBuffer.position();
    }

    public int readInt() {
        return this.byteBuffer.getInt();
    }

    public float readFloat() {
        return this.byteBuffer.getFloat();
    }

    public byte readByte() {
        return this.byteBuffer.get();
    }

    public long readLong() {
        return this.byteBuffer.getLong();
    }

    public void read(byte[] r1, int r2, int r3) {
        this.byteBuffer.get(r1, r2, r3);
    }

    public String ReadCString() {
        int r0 = readInt();
        if (r0 != 0) goto L6;
        return "";
    L6:
        int r1 = this.byteBuffer.position();
        this.byteBuffer.position(r1 + r0);
        return new String(this.buffer, r1, r0, Charset.defaultCharset());
    }
}
