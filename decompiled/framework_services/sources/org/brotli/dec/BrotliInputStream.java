package org.brotli.dec;

import android.hardware.tv.hdmi.cec.CecDeviceType;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes3.dex */
public class BrotliInputStream extends InputStream {
    public static final int DEFAULT_INTERNAL_BUFFER_SIZE = 256;
    private byte[] buffer;
    private int bufferOffset;
    private int remainingBufferBytes;
    private final State state;

    public BrotliInputStream(InputStream source) throws IOException {
        this(source, 256);
    }

    public BrotliInputStream(InputStream source, int byteReadBufferSize) throws IOException {
        this.state = new State();
        if (byteReadBufferSize <= 0) goto L14;
        if (source == null) goto L12;
        this.buffer = new byte[byteReadBufferSize];
        this.remainingBufferBytes = 0;
        this.bufferOffset = 0;
        Decode.initState(this.state, source);     // Catch: BrotliRuntimeException -> L8
        return;
    L8:
        ex = move-exception;
        throw new IOException("Brotli decoder initialization failed", ex);
    L12:
        throw new IllegalArgumentException("source is null");
    L14:
        throw new IllegalArgumentException("Bad buffer size:" + byteReadBufferSize);
    }

    public void attachDictionaryChunk(byte[] data) {
        Decode.attachDictionaryChunk(this.state, data);
    }

    public void enableEagerOutput() {
        Decode.enableEagerOutput(this.state);
    }

    public void enableLargeWindow() {
        Decode.enableLargeWindow(this.state);
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        Decode.close(this.state);
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (this.bufferOffset < this.remainingBufferBytes) goto L7;
        this.remainingBufferBytes = read(this.buffer, 0, this.buffer.length);
        this.bufferOffset = 0;
        if (this.remainingBufferBytes != (-1)) goto L7;
        return -1;
    L7:
        byte[] r0 = this.buffer;
        int r1 = this.bufferOffset;
        this.bufferOffset = r1 + 1;
        return r0[r1] & CecDeviceType.INACTIVE;
    }

    @Override // java.io.InputStream
    public int read(byte[] destBuffer, int destOffset, int destLen) throws IOException {
        if (destOffset < 0) goto L29;
        if (destLen < 0) goto L27;
        if ((destOffset + destLen) > destBuffer.length) goto L25;
        if (destLen != 0) goto L9;
        return 0;
    L9:
        int copyLen = Math.max(this.remainingBufferBytes - this.bufferOffset, 0);
        if (copyLen == 0) goto L30;
        copyLen = Math.min(copyLen, destLen);
        System.arraycopy(this.buffer, this.bufferOffset, destBuffer, destOffset, copyLen);
        this.bufferOffset += copyLen;
        destOffset = destOffset + copyLen;
        destLen = destLen - copyLen;
        if (destLen != 0) goto L30;
        return copyLen;
    L30:
        this.state.output = destBuffer;     // Catch: BrotliRuntimeException -> L21
        this.state.outputOffset = destOffset;     // Catch: BrotliRuntimeException -> L21
        this.state.outputLength = destLen;     // Catch: BrotliRuntimeException -> L21
        this.state.outputUsed = 0;     // Catch: BrotliRuntimeException -> L21
        Decode.decompress(this.state);     // Catch: BrotliRuntimeException -> L21
        if (this.state.outputUsed != 0) goto L18;
        return -1;
    L18:
        return this.state.outputUsed + copyLen;
    L21:
        ex = move-exception;
        throw new IOException("Brotli stream decoding failed", ex);
    L25:
        throw new IllegalArgumentException("Buffer overflow: " + (destOffset + destLen) + " > " + destBuffer.length);
    L27:
        throw new IllegalArgumentException("Bad length: " + destLen);
    L29:
        throw new IllegalArgumentException("Bad offset: " + destOffset);
    }
}
