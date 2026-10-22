package org.brotli.wrapper.dec;

import android.hardware.tv.hdmi.cec.CecDeviceType;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.Channels;

/* JADX INFO: loaded from: classes3.dex */
public class BrotliInputStream extends InputStream {
    private static final int DEFAULT_BUFFER_SIZE = 16384;
    private final Decoder decoder;

    public BrotliInputStream(InputStream source, int bufferSize) throws IOException {
        this.decoder = new Decoder(Channels.newChannel(source), bufferSize);
    }

    public BrotliInputStream(InputStream source) throws IOException {
        this(source, 16384);
    }

    public void enableEagerOutput() {
        this.decoder.enableEagerOutput();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.decoder.close();
    }

    @Override // java.io.InputStream
    public int available() {
        if (this.decoder.buffer != null) goto L7;
        return 0;
    L7:
        return this.decoder.buffer.remaining();
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (this.decoder.closed == true) goto L12;
    L4:
        int decoded = this.decoder.decode();
        if (decoded == 0) goto L4;
        if (decoded != (-1)) goto L10;
        return -1;
    L10:
        return this.decoder.buffer.get() & CecDeviceType.INACTIVE;
    L12:
        throw new IOException("read after close");
    }

    @Override // java.io.InputStream
    public int read(byte[] b) throws IOException {
        return read(b, 0, b.length);
    }

    @Override // java.io.InputStream
    public int read(byte[] b, int off, int len) throws IOException {
        if (this.decoder.closed == true) goto L15;
        if (this.decoder.decode() != (-1)) goto L7;
        return -1;
    L7:
        int result = 0;
    L8:
        if (len <= 0) goto L13;
        int limit = Math.min(len, this.decoder.buffer.remaining());
        this.decoder.buffer.get(b, off, limit);
        off = off + limit;
        len = len - limit;
        result = result + limit;
        if (this.decoder.decode() != (-1)) goto L8;
    L13:
        return result;
    L15:
        throw new IOException("read after close");
    }

    @Override // java.io.InputStream
    public long skip(long n) throws IOException {
        if (this.decoder.closed == true) goto L13;
        long result = 0;
    L6:
        if (n <= 0) goto L11;
        if (this.decoder.decode() == (-1)) goto L11;
        int limit = (int) Math.min(n, this.decoder.buffer.remaining());
        this.decoder.discard(limit);
        result = result + ((long) limit);
        n = n - ((long) limit);
    L11:
        return result;
    L13:
        throw new IOException("read after close");
    }
}
