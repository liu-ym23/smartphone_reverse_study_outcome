package okhttp3.internal.ws;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.IOException;
import java.util.Random;
import okio.Buffer;
import okio.BufferedSink;
import okio.ByteString;
import okio.Sink;
import okio.Timeout;

/* JADX INFO: loaded from: classes4.dex */
final class WebSocketWriter {
    boolean activeWriter;
    final Buffer buffer;
    final FrameSink frameSink;
    final boolean isClient;
    private final Buffer.UnsafeCursor maskCursor;
    private final byte[] maskKey;
    final Random random;
    final BufferedSink sink;
    final Buffer sinkBuffer;
    boolean writerClosed;

    public final class FrameSink implements Sink {
        boolean closed;
        long contentLength;
        int formatOpcode;
        boolean isFirstFrame;
        final /* synthetic */ WebSocketWriter this$0;

        public FrameSink(WebSocketWriter r10) {
            this.this$0 = r10;
        }

        @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.closed == true) goto L7;
            WebSocketWriter r10 = this.this$0;
            r10.writeMessageFrame(this.formatOpcode, r10.buffer.size(), this.isFirstFrame, true);
            this.closed = true;
            this.this$0.activeWriter = false;
            return;
        L7:
            throw new IOException("closed");
        }

        @Override // okio.Sink, java.io.Flushable
        public void flush() throws IOException {
            if (this.closed == true) goto L7;
            WebSocketWriter r10 = this.this$0;
            r10.writeMessageFrame(this.formatOpcode, r10.buffer.size(), this.isFirstFrame, false);
            this.isFirstFrame = false;
            return;
        L7:
            throw new IOException("closed");
        }

        @Override // okio.Sink
        public Timeout timeout() {
            return this.this$0.sink.timeout();
        }

        @Override // okio.Sink
        public void write(Buffer r10, long r11) throws IOException {
            if (this.closed == true) goto L18;
            this.this$0.buffer.write(r10, r11);
            if (this.isFirstFrame == true) goto L7;
        L11:
            boolean r12 = false;
        L12:
            long r13 = this.this$0.buffer.c();
            if (r13 <= 0) goto L19;
            if (r12 == true) goto L20;
            this.this$0.writeMessageFrame(this.formatOpcode, r13, this.isFirstFrame, false);
            this.isFirstFrame = false;
            return;
        L20:
            return;
        L19:
            return;
        L7:
            if (this.contentLength == (-1)) goto L11;
            if (this.this$0.buffer.size() <= (this.contentLength - PlaybackStateCompat.ACTION_PLAY_FROM_URI)) goto L11;
            r12 = true;
            goto L12
        L18:
            throw new IOException("closed");
        }
    }

    public WebSocketWriter(boolean r10, BufferedSink r11, Random r12) {
        this.buffer = new Buffer();
        this.frameSink = new FrameSink(this);
        if (r11 == null) goto L17;
        if (r12 == null) goto L15;
        this.isClient = r10;
        this.sink = r11;
        this.sinkBuffer = r11.buffer();
        this.random = r12;
        Buffer.UnsafeCursor r13 = null;
        if (r10 == false) goto L8;
        byte[] r14 = new byte[4];
    L9:
        this.maskKey = r14;
        if (r10 == false) goto L12;
        r13 = new Buffer.UnsafeCursor();
    L12:
        this.maskCursor = r13;
        return;
    L8:
        r14 = null;
        goto L9
    L15:
        throw new NullPointerException("random == null");
    L17:
        throw new NullPointerException("sink == null");
    }

    private void writeControlFrame(int r10, ByteString r11) throws IOException {
        if (this.writerClosed == true) goto L17;
        int r12 = r11.size();
        if (r12 > 125) goto L15;
        this.sinkBuffer.t(r10 | 128);
        if (this.isClient == false) goto L11;
        this.sinkBuffer.t(r12 | 128);
        this.random.nextBytes(this.maskKey);
        this.sinkBuffer.r(this.maskKey);
        if (r12 <= 0) goto L12;
        long r13 = this.sinkBuffer.size();
        this.sinkBuffer.q(r11);
        this.sinkBuffer.i(this.maskCursor);
        this.maskCursor.b(r13);
        WebSocketProtocol.toggleMask(this.maskCursor, this.maskKey);
        this.maskCursor.close();
    L12:
        this.sink.flush();
        return;
    L11:
        this.sinkBuffer.t(r12);
        this.sinkBuffer.q(r11);
        goto L12
    L15:
        throw new IllegalArgumentException("Payload size must be less than or equal to 125");
    L17:
        throw new IOException("closed");
    }

    public Sink newMessageSink(int r10, long r11) {
        if (this.activeWriter == true) goto L7;
        this.activeWriter = true;
        FrameSink r12 = this.frameSink;
        r12.formatOpcode = r10;
        r12.contentLength = r11;
        r12.isFirstFrame = true;
        r12.closed = false;
        return r12;
    L7:
        throw new IllegalStateException("Another message writer is active. Did you call close()?");
    }

    public void writeClose(int r10, ByteString r11) throws IOException {
        ByteString r12 = ByteString.EMPTY;
        if (r10 != 0) goto L5;
        if (r11 != null) goto L5;
    L18:
        writeControlFrame(8, r12);     // Catch: Throwable -> L15
        this.writerClosed = true;
        return;
    L15:
        th = move-exception;
        this.writerClosed = true;
        throw th;
    L5:
        if (r10 == 0) goto L7;
        WebSocketProtocol.validateCloseCode(r10);
    L7:
        Buffer r13 = new Buffer();
        r13.A(r10);
        if (r11 == null) goto L10;
        r13.q(r11);
    L10:
        r12 = r13.readByteString();
        goto L18
    }

    public void writeMessageFrame(int r10, long r11, boolean r12, boolean r13) throws IOException {
        if (this.writerClosed == true) goto L29;
        int r14 = 0;
        if (r12 == true) goto L8;
        r10 = 0;
    L8:
        if (r13 == false) goto L10;
        r10 = r10 | 128;
    L10:
        this.sinkBuffer.t(r10);
        if (this.isClient == false) goto L14;
        r14 = 128;
    L14:
        if (r11 > 125) goto L17;
        this.sinkBuffer.t(((int) r11) | r14);
    L21:
        if (this.isClient == false) goto L25;
        this.random.nextBytes(this.maskKey);
        this.sinkBuffer.r(this.maskKey);
        if (r11 <= 0) goto L26;
        long r15 = this.sinkBuffer.size();
        this.sinkBuffer.write(this.buffer, r11);
        this.sinkBuffer.i(this.maskCursor);
        this.maskCursor.b(r15);
        WebSocketProtocol.toggleMask(this.maskCursor, this.maskKey);
        this.maskCursor.close();
    L26:
        this.sink.emit();
        return;
    L25:
        this.sinkBuffer.write(this.buffer, r11);
        goto L26
    L17:
        if (r11 > 65535) goto L19;
        this.sinkBuffer.t(r14 | 126);
        this.sinkBuffer.A((int) r11);
        goto L21
    L19:
        this.sinkBuffer.t(r14 | 127);
        this.sinkBuffer.y(r11);
        goto L21
    L29:
        throw new IOException("closed");
    }

    public void writePing(ByteString r10) throws IOException {
        writeControlFrame(9, r10);
    }

    public void writePong(ByteString r10) throws IOException {
        writeControlFrame(10, r10);
    }
}
