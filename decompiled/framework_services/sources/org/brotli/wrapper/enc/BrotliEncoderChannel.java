package org.brotli.wrapper.enc;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.WritableByteChannel;

/* JADX INFO: loaded from: classes3.dex */
public class BrotliEncoderChannel extends Encoder implements WritableByteChannel {
    private static final int DEFAULT_BUFFER_SIZE = 16384;
    private final Object mutex;

    public BrotliEncoderChannel(WritableByteChannel destination, Encoder.Parameters params, int bufferSize) throws IOException {
        super(destination, params, bufferSize);
        this.mutex = new Object();
    }

    public BrotliEncoderChannel(WritableByteChannel destination, Encoder.Parameters params) throws IOException {
        this(destination, params, 16384);
    }

    public BrotliEncoderChannel(WritableByteChannel destination) throws IOException {
        this(destination, new Encoder.Parameters());
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        Object r0 = this.mutex;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.closed == true) goto L7;
        boolean r1 = true;
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r1;
    L7:
        r1 = false;
        goto L8
    }

    @Override // org.brotli.wrapper.enc.Encoder, java.nio.channels.Channel, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        Object r0 = this.mutex;
        monitor-enter(r0);
        super.close();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer src) throws IOException {
        Object r0 = this.mutex;
        monitor-enter(r0);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (this.closed == true) goto L17;
        int result = 0;
    L8:
        if (src.hasRemaining() == false) goto L14;
        if (encode(EncoderJNI.Operation.PROCESS) == false) goto L14;
        int limit = Math.min(src.remaining(), this.inputBuffer.remaining());     // Catch: Throwable -> L12
        ByteBuffer slice = src.slice();     // Catch: Throwable -> L12
        slice.limit(limit);     // Catch: Throwable -> L12
        this.inputBuffer.put(slice);     // Catch: Throwable -> L12
        result = result + limit;     // Catch: Throwable -> L12
        src.position(src.position() + limit);     // Catch: Throwable -> L12
    L14:
        monitor-exit(r0);     // Catch: Throwable -> L12
        return result;
    L17:
        throw new ClosedChannelException();     // Catch: Throwable -> L12
    }
}
