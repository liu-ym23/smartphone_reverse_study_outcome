package org.brotli.wrapper.dec;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.ReadableByteChannel;

/* JADX INFO: loaded from: classes3.dex */
public class BrotliDecoderChannel extends Decoder implements ReadableByteChannel {
    private static final int DEFAULT_BUFFER_SIZE = 16384;
    private final Object mutex;

    public BrotliDecoderChannel(ReadableByteChannel source, int bufferSize) throws IOException {
        super(source, bufferSize);
        this.mutex = new Object();
    }

    public BrotliDecoderChannel(ReadableByteChannel source) throws IOException {
        this(source, 16384);
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

    @Override // org.brotli.wrapper.dec.Decoder, java.nio.channels.Channel, java.io.Closeable, java.lang.AutoCloseable
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

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer dst) throws IOException {
        Object r0 = this.mutex;
        monitor-enter(r0);
    L16:
        th = move-exception;
        throw th;
    L5:
        if (this.closed == true) goto L22;
        int result = 0;
    L8:
        if (dst.hasRemaining() == false) goto L19;
        int outputSize = decode();     // Catch: Throwable -> L16
        if (outputSize <= 0) goto L11;
        result = result + consume(dst);     // Catch: Throwable -> L16
        goto L8
    L11:
        if (result != 0) goto L13;
        int r3 = outputSize;
    L14:
        monitor-exit(r0);     // Catch: Throwable -> L16
        return r3;
    L13:
        r3 = result;
        goto L14
    L19:
        monitor-exit(r0);     // Catch: Throwable -> L16
        return result;
    L22:
        throw new ClosedChannelException();     // Catch: Throwable -> L16
    }
}
