package org.brotli.wrapper.enc;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.channels.Channels;

/* JADX INFO: loaded from: classes3.dex */
public class BrotliOutputStream extends OutputStream {
    private static final int DEFAULT_BUFFER_SIZE = 16384;
    private final Encoder encoder;

    public BrotliOutputStream(OutputStream destination, Encoder.Parameters params, int bufferSize) throws IOException {
        this.encoder = new Encoder(Channels.newChannel(destination), params, bufferSize);
    }

    public BrotliOutputStream(OutputStream destination, Encoder.Parameters params) throws IOException {
        this(destination, params, 16384);
    }

    public BrotliOutputStream(OutputStream destination) throws IOException {
        this(destination, new Encoder.Parameters());
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.encoder.close();
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        if (this.encoder.closed == true) goto L7;
        this.encoder.flush();
        return;
    L7:
        throw new IOException("write after close");
    }

    @Override // java.io.OutputStream
    public void write(int b) throws IOException {
        if (this.encoder.closed == true) goto L10;
    L5:
        if (this.encoder.encode(EncoderJNI.Operation.PROCESS) == false) goto L5;
        this.encoder.inputBuffer.put((byte) b);
        return;
    L10:
        throw new IOException("write after close");
    }

    @Override // java.io.OutputStream
    public void write(byte[] b) throws IOException {
        write(b, 0, b.length);
    }

    @Override // java.io.OutputStream
    public void write(byte[] b, int off, int len) throws IOException {
        if (this.encoder.closed == true) goto L11;
    L4:
        if (len <= 0) goto L9;
        if (this.encoder.encode(EncoderJNI.Operation.PROCESS) == false) goto L4;
        int limit = Math.min(len, this.encoder.inputBuffer.remaining());
        this.encoder.inputBuffer.put(b, off, limit);
        off = off + limit;
        len = len - limit;
        goto L4
    L9:
        return;
    L11:
        throw new IOException("write after close");
    }
}
