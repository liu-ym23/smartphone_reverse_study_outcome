package okhttp3.internal.ws;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.IOException;
import java.util.Random;
import kotlinx.coroutines.scheduling.WorkQueueKt;
import okio.Buffer;
import okio.BufferedSink;
import okio.ByteString;
import okio.Sink;
import okio.Timeout;

/* JADX INFO: loaded from: classes5.dex */
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

    final class FrameSink implements Sink {
        boolean closed;
        long contentLength;
        int formatOpcode;
        boolean isFirstFrame;
        final /* synthetic */ WebSocketWriter this$0;

        FrameSink(WebSocketWriter r1) {
            this.this$0 = r1;
        }

        @Override // okio.Sink
        public void write(Buffer r7, long r8) throws IOException {
            if (this.closed == true) goto L18;
            this.this$0.buffer.write(r7, r8);
            if (this.isFirstFrame == true) goto L7;
        L11:
            boolean r9 = false;
        L12:
            long r2 = this.this$0.buffer.completeSegmentByteCount();
            if (r2 <= 0) goto L19;
            if (r9 == true) goto L20;
            this.this$0.writeMessageFrame(this.formatOpcode, r2, this.isFirstFrame, false);
            this.isFirstFrame = false;
            return;
        L20:
            return;
        L19:
            return;
        L7:
            if (this.contentLength == (-1)) goto L11;
            if (this.this$0.buffer.size() <= (this.contentLength - PlaybackStateCompat.ACTION_PLAY_FROM_URI)) goto L11;
            r9 = true;
            goto L12
        L18:
            throw new IOException("closed");
        }

        @Override // okio.Sink, java.io.Flushable
        public void flush() throws IOException {
            if (this.closed == true) goto L7;
            WebSocketWriter r1 = this.this$0;
            r1.writeMessageFrame(this.formatOpcode, r1.buffer.size(), this.isFirstFrame, false);
            this.isFirstFrame = false;
            return;
        L7:
            throw new IOException("closed");
        }

        @Override // okio.Sink
        public Timeout timeout() {
            return this.this$0.sink.timeout();
        }

        @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.closed == true) goto L7;
            WebSocketWriter r1 = this.this$0;
            r1.writeMessageFrame(this.formatOpcode, r1.buffer.size(), this.isFirstFrame, true);
            this.closed = true;
            this.this$0.activeWriter = false;
            return;
        L7:
            throw new IOException("closed");
        }
    }

    WebSocketWriter(boolean r2, BufferedSink r3, Random r4) {
        this.buffer = new Buffer();
        this.frameSink = new FrameSink(this);
        if (r3 == null) goto L17;
        if (r4 == null) goto L15;
        this.isClient = r2;
        this.sink = r3;
        this.sinkBuffer = r3.buffer();
        this.random = r4;
        Buffer.UnsafeCursor r5 = null;
        if (r2 == false) goto L8;
        byte[] r6 = new byte[4];
    L9:
        this.maskKey = r6;
        if (r2 == false) goto L12;
        r5 = new Buffer.UnsafeCursor();
    L12:
        this.maskCursor = r5;
        return;
    L8:
        r6 = null;
        goto L9
    L15:
        throw new NullPointerException("random == null");
    L17:
        throw new NullPointerException("sink == null");
    }

    void writePing(ByteString r2) throws IOException {
        writeControlFrame(9, r2);
    }

    void writePong(ByteString r2) throws IOException {
        writeControlFrame(10, r2);
    }

    void writeClose(int r2, ByteString r3) throws IOException {
        ByteString r0 = ByteString.EMPTY;
        if (r2 != 0) goto L5;
        if (r3 != null) goto L5;
    L18:
        writeControlFrame(8, r0);     // Catch: Throwable -> L15
        this.writerClosed = true;
        return;
    L15:
        th = move-exception;
        this.writerClosed = true;
        throw th;
    L5:
        if (r2 == 0) goto L7;
        WebSocketProtocol.validateCloseCode(r2);
    L7:
        Buffer r1 = new Buffer();
        r1.writeShort(r2);
        if (r3 == null) goto L10;
        r1.write(r3);
    L10:
        r0 = r1.readByteString();
        goto L18
    }

    private void writeControlFrame(int r6, ByteString r7) throws IOException {
        if (this.writerClosed == true) goto L17;
        int r0 = r7.size();
        if (r0 > 125) goto L15;
        this.sinkBuffer.writeByte(r6 | 128);
        if (this.isClient == false) goto L11;
        this.sinkBuffer.writeByte(r0 | 128);
        this.random.nextBytes(this.maskKey);
        this.sinkBuffer.write(this.maskKey);
        if (r0 <= 0) goto L12;
        long r1 = this.sinkBuffer.size();
        this.sinkBuffer.write(r7);
        this.sinkBuffer.readAndWriteUnsafe(this.maskCursor);
        this.maskCursor.seek(r1);
        WebSocketProtocol.toggleMask(this.maskCursor, this.maskKey);
        this.maskCursor.close();
    L12:
        this.sink.flush();
        return;
    L11:
        this.sinkBuffer.writeByte(r0);
        this.sinkBuffer.write(r7);
        goto L12
    L15:
        throw new IllegalArgumentException("Payload size must be less than or equal to 125");
    L17:
        throw new IOException("closed");
    }

    Sink newMessageSink(int r3, long r4) {
        if (this.activeWriter == true) goto L7;
        this.activeWriter = true;
        this.frameSink.formatOpcode = r3;
        this.frameSink.contentLength = r4;
        this.frameSink.isFirstFrame = true;
        this.frameSink.closed = false;
        return this.frameSink;
    L7:
        throw new IllegalStateException("Another message writer is active. Did you call close()?");
    }

    void writeMessageFrame(int r2, long r3, boolean r5, boolean r6) throws IOException {
        if (this.writerClosed == true) goto L29;
        int r0 = 0;
        if (r5 == true) goto L8;
        r2 = 0;
    L8:
        if (r6 == false) goto L10;
        r2 = r2 | 128;
    L10:
        this.sinkBuffer.writeByte(r2);
        if (this.isClient == false) goto L14;
        r0 = 128;
    L14:
        if (r3 > 125) goto L17;
        this.sinkBuffer.writeByte(((int) r3) | r0);
    L21:
        if (this.isClient == false) goto L25;
        this.random.nextBytes(this.maskKey);
        this.sinkBuffer.write(this.maskKey);
        if (r3 <= 0) goto L26;
        long r7 = this.sinkBuffer.size();
        this.sinkBuffer.write(this.buffer, r3);
        this.sinkBuffer.readAndWriteUnsafe(this.maskCursor);
        this.maskCursor.seek(r7);
        WebSocketProtocol.toggleMask(this.maskCursor, this.maskKey);
        this.maskCursor.close();
    L26:
        this.sink.emit();
        return;
    L25:
        this.sinkBuffer.write(this.buffer, r3);
        goto L26
    L17:
        if (r3 > 65535) goto L19;
        this.sinkBuffer.writeByte(r0 | 126);
        this.sinkBuffer.writeShort((int) r3);
        goto L21
    L19:
        this.sinkBuffer.writeByte(r0 | WorkQueueKt.MASK);
        this.sinkBuffer.writeLong(r3);
        goto L21
    L29:
        throw new IOException("closed");
    }
}
