package fg;

import java.io.EOFException;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import okio.Buffer;
import okio.BufferedSink;
import okio.ByteString;
import okio.Sink;
import okio.Source;
import okio.Timeout;

/* JADX INFO: loaded from: classes4.dex */
public final class n implements BufferedSink {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Buffer f19707a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f19708b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Sink f19709c;

    public static final class a extends OutputStream {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ n f19710a;

        public a(n r10) {
            this.f19710a = r10;
        }

        @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.f19710a.close();
        }

        @Override // java.io.OutputStream, java.io.Flushable
        public void flush() {
            n r10 = this.f19710a;
            if (r10.f19708b == true) goto L6;
            r10.flush();
            return;
        }

        public String toString() {
            return this.f19710a + ".outputStream()";
        }

        @Override // java.io.OutputStream
        public void write(int r10) {
            n r11 = this.f19710a;
            if (r11.f19708b == true) goto L7;
            r11.f19707a.t((byte) r10);
            this.f19710a.emitCompleteSegments();
            return;
        L7:
            throw new IOException("closed");
        }

        @Override // java.io.OutputStream
        public void write(byte[] r10, int r11, int r12) {
            kotlin.jvm.internal.q.h(r10, "data");
            n r13 = this.f19710a;
            if (r13.f19708b == true) goto L7;
            r13.f19707a.s(r10, r11, r12);
            this.f19710a.emitCompleteSegments();
            return;
        L7:
            throw new IOException("closed");
        }
    }

    public n(Sink r10) {
        kotlin.jvm.internal.q.h(r10, "sink");
        this.f19709c = r10;
        this.f19707a = new Buffer();
    }

    @Override // okio.BufferedSink
    public Buffer buffer() {
        return this.f19707a;
    }

    @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.f19708b == false) goto L23;
        return;
    L23:
    L9:
        th = th;
    L21:
        this.f19709c.close();     // Catch: Throwable -> L14
    L17:
        this.f19708b = true;
        if (th != null) goto L20;
        return;
    L20:
        throw th;
    L14:
        th = move-exception;
        if (th != null) goto L17;
        th = th;
        goto L17
    L6:
        if (this.f19707a.size() <= 0) goto L11;
        Sink r10 = this.f19709c;     // Catch: Throwable -> L9
        Buffer r11 = this.f19707a;     // Catch: Throwable -> L9
        r10.write(r11, r11.size());     // Catch: Throwable -> L9
    L11:
        th = null;
        goto L21
    }

    @Override // okio.BufferedSink
    public BufferedSink emit() {
        if (this.f19708b == true) goto L9;
        long r10 = this.f19707a.size();
        if (r10 <= 0) goto L7;
        this.f19709c.write(this.f19707a, r10);
    L7:
        return this;
    L9:
        throw new IllegalStateException("closed");
    }

    @Override // okio.BufferedSink
    public BufferedSink emitCompleteSegments() {
        if (this.f19708b == true) goto L9;
        long r10 = this.f19707a.c();
        if (r10 <= 0) goto L7;
        this.f19709c.write(this.f19707a, r10);
    L7:
        return this;
    L9:
        throw new IllegalStateException("closed");
    }

    @Override // okio.BufferedSink, okio.Sink, java.io.Flushable
    public void flush() {
        if (this.f19708b == true) goto L10;
        if (this.f19707a.size() <= 0) goto L7;
        Sink r10 = this.f19709c;
        Buffer r11 = this.f19707a;
        r10.write(r11, r11.size());
    L7:
        this.f19709c.flush();
        return;
    L10:
        throw new IllegalStateException("closed");
    }

    @Override // okio.BufferedSink
    public Buffer getBuffer() {
        return this.f19707a;
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return !this.f19708b;
    }

    @Override // okio.BufferedSink
    public OutputStream outputStream() {
        return new a(this);
    }

    @Override // okio.Sink
    public Timeout timeout() {
        return this.f19709c.timeout();
    }

    public String toString() {
        return "buffer(" + this.f19709c + ')';
    }

    @Override // okio.Sink
    public void write(Buffer r10, long r11) {
        kotlin.jvm.internal.q.h(r10, "source");
        if (this.f19708b == true) goto L7;
        this.f19707a.write(r10, r11);
        emitCompleteSegments();
        return;
    L7:
        throw new IllegalStateException("closed");
    }

    @Override // okio.BufferedSink
    public long writeAll(Source r10) {
        kotlin.jvm.internal.q.h(r10, "source");
        long r11 = 0;
    L3:
        long r12 = r10.read(this.f19707a, 8192);
        if (r12 == (-1)) goto L5;
        r11 = r11 + r12;
        emitCompleteSegments();
        goto L3
    L5:
        return r11;
    }

    @Override // okio.BufferedSink
    public BufferedSink writeByte(int r10) {
        if (this.f19708b == true) goto L7;
        this.f19707a.t(r10);
        return emitCompleteSegments();
    L7:
        throw new IllegalStateException("closed");
    }

    @Override // okio.BufferedSink
    public BufferedSink writeDecimalLong(long r10) {
        if (this.f19708b == true) goto L7;
        this.f19707a.u(r10);
        return emitCompleteSegments();
    L7:
        throw new IllegalStateException("closed");
    }

    @Override // okio.BufferedSink
    public BufferedSink writeHexadecimalUnsignedLong(long r10) {
        if (this.f19708b == true) goto L7;
        this.f19707a.v(r10);
        return emitCompleteSegments();
    L7:
        throw new IllegalStateException("closed");
    }

    @Override // okio.BufferedSink
    public BufferedSink writeInt(int r10) {
        if (this.f19708b == true) goto L7;
        this.f19707a.w(r10);
        return emitCompleteSegments();
    L7:
        throw new IllegalStateException("closed");
    }

    @Override // okio.BufferedSink
    public BufferedSink writeIntLe(int r10) {
        if (this.f19708b == true) goto L7;
        this.f19707a.x(r10);
        return emitCompleteSegments();
    L7:
        throw new IllegalStateException("closed");
    }

    @Override // okio.BufferedSink
    public BufferedSink writeLong(long r10) {
        if (this.f19708b == true) goto L7;
        this.f19707a.y(r10);
        return emitCompleteSegments();
    L7:
        throw new IllegalStateException("closed");
    }

    @Override // okio.BufferedSink
    public BufferedSink writeLongLe(long r10) {
        if (this.f19708b == true) goto L7;
        this.f19707a.z(r10);
        return emitCompleteSegments();
    L7:
        throw new IllegalStateException("closed");
    }

    @Override // okio.BufferedSink
    public BufferedSink writeShort(int r10) {
        if (this.f19708b == true) goto L7;
        this.f19707a.A(r10);
        return emitCompleteSegments();
    L7:
        throw new IllegalStateException("closed");
    }

    @Override // okio.BufferedSink
    public BufferedSink writeShortLe(int r10) {
        if (this.f19708b == true) goto L7;
        this.f19707a.B(r10);
        return emitCompleteSegments();
    L7:
        throw new IllegalStateException("closed");
    }

    @Override // okio.BufferedSink
    public BufferedSink writeString(String r10, Charset r11) {
        kotlin.jvm.internal.q.h(r10, "string");
        kotlin.jvm.internal.q.h(r11, "charset");
        if (this.f19708b == true) goto L7;
        this.f19707a.D(r10, r11);
        return emitCompleteSegments();
    L7:
        throw new IllegalStateException("closed");
    }

    @Override // okio.BufferedSink
    public BufferedSink writeUtf8(String r10) {
        kotlin.jvm.internal.q.h(r10, "string");
        if (this.f19708b == true) goto L7;
        this.f19707a.E(r10);
        return emitCompleteSegments();
    L7:
        throw new IllegalStateException("closed");
    }

    @Override // okio.BufferedSink
    public BufferedSink writeUtf8CodePoint(int r10) {
        if (this.f19708b == true) goto L7;
        this.f19707a.G(r10);
        return emitCompleteSegments();
    L7:
        throw new IllegalStateException("closed");
    }

    @Override // okio.BufferedSink
    public BufferedSink write(ByteString r10) {
        kotlin.jvm.internal.q.h(r10, "byteString");
        if (this.f19708b == true) goto L7;
        this.f19707a.q(r10);
        return emitCompleteSegments();
    L7:
        throw new IllegalStateException("closed");
    }

    @Override // okio.BufferedSink
    public BufferedSink writeString(String r10, int r11, int r12, Charset r13) {
        kotlin.jvm.internal.q.h(r10, "string");
        kotlin.jvm.internal.q.h(r13, "charset");
        if (this.f19708b == true) goto L7;
        this.f19707a.C(r10, r11, r12, r13);
        return emitCompleteSegments();
    L7:
        throw new IllegalStateException("closed");
    }

    @Override // okio.BufferedSink
    public BufferedSink writeUtf8(String r10, int r11, int r12) {
        kotlin.jvm.internal.q.h(r10, "string");
        if (this.f19708b == true) goto L7;
        this.f19707a.F(r10, r11, r12);
        return emitCompleteSegments();
    L7:
        throw new IllegalStateException("closed");
    }

    @Override // okio.BufferedSink
    public BufferedSink write(byte[] r10) {
        kotlin.jvm.internal.q.h(r10, "source");
        if (this.f19708b == true) goto L7;
        this.f19707a.r(r10);
        return emitCompleteSegments();
    L7:
        throw new IllegalStateException("closed");
    }

    @Override // okio.BufferedSink
    public BufferedSink write(byte[] r10, int r11, int r12) {
        kotlin.jvm.internal.q.h(r10, "source");
        if (this.f19708b == true) goto L7;
        this.f19707a.s(r10, r11, r12);
        return emitCompleteSegments();
    L7:
        throw new IllegalStateException("closed");
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer r10) {
        kotlin.jvm.internal.q.h(r10, "source");
        if (this.f19708b == true) goto L7;
        int r11 = this.f19707a.write(r10);
        emitCompleteSegments();
        return r11;
    L7:
        throw new IllegalStateException("closed");
    }

    @Override // okio.BufferedSink
    public BufferedSink write(Source r10, long r11) {
        kotlin.jvm.internal.q.h(r10, "source");
    L4:
        if (r11 <= 0) goto L10;
        long r12 = r10.read(this.f19707a, r11);
        if (r12 == (-1)) goto L9;
        r11 = r11 - r12;
        emitCompleteSegments();
        goto L4
    L9:
        throw new EOFException();
    L10:
        return this;
    }
}
