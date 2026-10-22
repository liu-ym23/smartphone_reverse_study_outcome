package okio;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.EOFException;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes5.dex */
final class RealBufferedSink implements BufferedSink {
    public final Buffer buffer;
    boolean closed;
    public final Sink sink;

    RealBufferedSink(Sink r2) {
        this.buffer = new Buffer();
        if (r2 == null) goto L7;
        this.sink = r2;
        return;
    L7:
        throw new NullPointerException("sink == null");
    }

    @Override // okio.BufferedSink
    public Buffer buffer() {
        return this.buffer;
    }

    @Override // okio.Sink
    public void write(Buffer r2, long r3) throws IOException {
        if (this.closed == true) goto L7;
        this.buffer.write(r2, r3);
        emitCompleteSegments();
        return;
    L7:
        throw new IllegalStateException("closed");
    }

    @Override // okio.BufferedSink
    public BufferedSink write(ByteString r2) throws IOException {
        if (this.closed == true) goto L7;
        this.buffer.write(r2);
        return emitCompleteSegments();
    L7:
        throw new IllegalStateException("closed");
    }

    @Override // okio.BufferedSink
    public BufferedSink writeUtf8(String r2) throws IOException {
        if (this.closed == true) goto L7;
        this.buffer.writeUtf8(r2);
        return emitCompleteSegments();
    L7:
        throw new IllegalStateException("closed");
    }

    @Override // okio.BufferedSink
    public BufferedSink writeUtf8(String r2, int r3, int r4) throws IOException {
        if (this.closed == true) goto L7;
        this.buffer.writeUtf8(r2, r3, r4);
        return emitCompleteSegments();
    L7:
        throw new IllegalStateException("closed");
    }

    @Override // okio.BufferedSink
    public BufferedSink writeUtf8CodePoint(int r2) throws IOException {
        if (this.closed == true) goto L7;
        this.buffer.writeUtf8CodePoint(r2);
        return emitCompleteSegments();
    L7:
        throw new IllegalStateException("closed");
    }

    @Override // okio.BufferedSink
    public BufferedSink writeString(String r2, Charset r3) throws IOException {
        if (this.closed == true) goto L7;
        this.buffer.writeString(r2, r3);
        return emitCompleteSegments();
    L7:
        throw new IllegalStateException("closed");
    }

    @Override // okio.BufferedSink
    public BufferedSink writeString(String r2, int r3, int r4, Charset r5) throws IOException {
        if (this.closed == true) goto L7;
        this.buffer.writeString(r2, r3, r4, r5);
        return emitCompleteSegments();
    L7:
        throw new IllegalStateException("closed");
    }

    @Override // okio.BufferedSink
    public BufferedSink write(byte[] r2) throws IOException {
        if (this.closed == true) goto L7;
        this.buffer.write(r2);
        return emitCompleteSegments();
    L7:
        throw new IllegalStateException("closed");
    }

    @Override // okio.BufferedSink
    public BufferedSink write(byte[] r2, int r3, int r4) throws IOException {
        if (this.closed == true) goto L7;
        this.buffer.write(r2, r3, r4);
        return emitCompleteSegments();
    L7:
        throw new IllegalStateException("closed");
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer r2) throws IOException {
        if (this.closed == true) goto L7;
        int r3 = this.buffer.write(r2);
        emitCompleteSegments();
        return r3;
    L7:
        throw new IllegalStateException("closed");
    }

    @Override // okio.BufferedSink
    public long writeAll(Source r7) throws IOException {
        if (r7 == null) goto L9;
        long r0 = 0;
    L4:
        long r2 = r7.read(this.buffer, PlaybackStateCompat.ACTION_PLAY_FROM_URI);
        if (r2 == (-1)) goto L7;
        r0 = r0 + r2;
        emitCompleteSegments();
        goto L4
    L7:
        return r0;
    L9:
        throw new IllegalArgumentException("source == null");
    }

    @Override // okio.BufferedSink
    public BufferedSink write(Source r5, long r6) throws IOException {
    L3:
        if (r6 <= 0) goto L9;
        long r0 = r5.read(this.buffer, r6);
        if (r0 == (-1)) goto L8;
        r6 = r6 - r0;
        emitCompleteSegments();
        goto L3
    L8:
        throw new EOFException();
    L9:
        return this;
    }

    @Override // okio.BufferedSink
    public BufferedSink writeByte(int r2) throws IOException {
        if (this.closed == true) goto L7;
        this.buffer.writeByte(r2);
        return emitCompleteSegments();
    L7:
        throw new IllegalStateException("closed");
    }

    @Override // okio.BufferedSink
    public BufferedSink writeShort(int r2) throws IOException {
        if (this.closed == true) goto L7;
        this.buffer.writeShort(r2);
        return emitCompleteSegments();
    L7:
        throw new IllegalStateException("closed");
    }

    @Override // okio.BufferedSink
    public BufferedSink writeShortLe(int r2) throws IOException {
        if (this.closed == true) goto L7;
        this.buffer.writeShortLe(r2);
        return emitCompleteSegments();
    L7:
        throw new IllegalStateException("closed");
    }

    @Override // okio.BufferedSink
    public BufferedSink writeInt(int r2) throws IOException {
        if (this.closed == true) goto L7;
        this.buffer.writeInt(r2);
        return emitCompleteSegments();
    L7:
        throw new IllegalStateException("closed");
    }

    @Override // okio.BufferedSink
    public BufferedSink writeIntLe(int r2) throws IOException {
        if (this.closed == true) goto L7;
        this.buffer.writeIntLe(r2);
        return emitCompleteSegments();
    L7:
        throw new IllegalStateException("closed");
    }

    @Override // okio.BufferedSink
    public BufferedSink writeLong(long r2) throws IOException {
        if (this.closed == true) goto L7;
        this.buffer.writeLong(r2);
        return emitCompleteSegments();
    L7:
        throw new IllegalStateException("closed");
    }

    @Override // okio.BufferedSink
    public BufferedSink writeLongLe(long r2) throws IOException {
        if (this.closed == true) goto L7;
        this.buffer.writeLongLe(r2);
        return emitCompleteSegments();
    L7:
        throw new IllegalStateException("closed");
    }

    @Override // okio.BufferedSink
    public BufferedSink writeDecimalLong(long r2) throws IOException {
        if (this.closed == true) goto L7;
        this.buffer.writeDecimalLong(r2);
        return emitCompleteSegments();
    L7:
        throw new IllegalStateException("closed");
    }

    @Override // okio.BufferedSink
    public BufferedSink writeHexadecimalUnsignedLong(long r2) throws IOException {
        if (this.closed == true) goto L7;
        this.buffer.writeHexadecimalUnsignedLong(r2);
        return emitCompleteSegments();
    L7:
        throw new IllegalStateException("closed");
    }

    @Override // okio.BufferedSink
    public BufferedSink emitCompleteSegments() throws IOException {
        if (this.closed == true) goto L9;
        long r0 = this.buffer.completeSegmentByteCount();
        if (r0 <= 0) goto L7;
        this.sink.write(this.buffer, r0);
    L7:
        return this;
    L9:
        throw new IllegalStateException("closed");
    }

    @Override // okio.BufferedSink
    public BufferedSink emit() throws IOException {
        if (this.closed == true) goto L9;
        long r0 = this.buffer.size();
        if (r0 <= 0) goto L7;
        this.sink.write(this.buffer, r0);
    L7:
        return this;
    L9:
        throw new IllegalStateException("closed");
    }

    @Override // okio.BufferedSink
    public OutputStream outputStream() {
        return new AnonymousClass1(this);
    }

    @Override // okio.BufferedSink, okio.Sink, java.io.Flushable
    public void flush() throws IOException {
        if (this.closed == true) goto L10;
        if (this.buffer.size <= 0) goto L7;
        Sink r0 = this.sink;
        Buffer r1 = this.buffer;
        r0.write(r1, r1.size);
    L7:
        this.sink.flush();
        return;
    L10:
        throw new IllegalStateException("closed");
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return !this.closed;
    }

    @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.closed == false) goto L21;
        return;
    L21:
    L9:
        th = th;
    L19:
        this.sink.close();     // Catch: Throwable -> L12
    L15:
        this.closed = true;
        if (th == null) goto L23;
        Util.sneakyRethrow(th);
        return;
    L23:
        return;
    L12:
        th = move-exception;
        if (th != null) goto L15;
        th = th;
        goto L15
    L6:
        if (this.buffer.size <= 0) goto L8;
        Sink r0 = this.sink;     // Catch: Throwable -> L9
        Buffer r1 = this.buffer;     // Catch: Throwable -> L9
        r0.write(r1, r1.size);     // Catch: Throwable -> L9
    L8:
        th = null;
        goto L19
    }

    @Override // okio.Sink
    public Timeout timeout() {
        return this.sink.timeout();
    }

    public String toString() {
        return "buffer(" + this.sink + ")";
    }
}
