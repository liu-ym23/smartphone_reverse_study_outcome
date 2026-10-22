package okhttp3.internal.http2;

import com.google.common.primitives.UnsignedBytes;
import com.ttnet.org.chromium.net.PrivateKeyType;
import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlinx.coroutines.channels.Channel;
import okhttp3.internal.Util;
import okio.Buffer;
import okio.BufferedSink;

/* JADX INFO: loaded from: classes4.dex */
final class Http2Writer implements Closeable {
    private static final Logger logger = null;
    private final boolean client;
    private boolean closed;
    private final Buffer hpackBuffer;
    final Hpack.Writer hpackWriter;
    private int maxFrameSize;
    private final BufferedSink sink;

    static {
        logger = Logger.getLogger(Http2.class.getName());
    }

    public Http2Writer(BufferedSink r10, boolean r11) {
        this.sink = r10;
        this.client = r11;
        Buffer r12 = new Buffer();
        this.hpackBuffer = r12;
        this.hpackWriter = new Hpack.Writer(r12);
        this.maxFrameSize = 16384;
    }

    private void writeContinuationFrames(int r10, long r11) throws IOException {
    L3:
        if (r11 <= 0) goto L9;
        int r12 = (int) Math.min(this.maxFrameSize, r11);
        long r13 = r12;
        r11 = r11 - r13;
        if (r11 != 0) goto L7;
        byte r14 = 4;
    L8:
        frameHeader(r10, r12, (byte) 9, r14);
        this.sink.write(this.hpackBuffer, r13);
        goto L3
    L7:
        r14 = 0;
        goto L8
    }

    private static void writeMedium(BufferedSink r10, int r11) throws IOException {
        r10.writeByte((r11 >>> 16) & PrivateKeyType.INVALID);
        r10.writeByte((r11 >>> 8) & PrivateKeyType.INVALID);
        r10.writeByte(r11 & PrivateKeyType.INVALID);
    }

    public synchronized void applyAndAckSettings(Settings r10) throws IOException {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (this.closed == true) goto L14;
        this.maxFrameSize = r10.getMaxFrameSize(this.maxFrameSize);     // Catch: Throwable -> L8
        if (r10.getHeaderTableSize() == (-1)) goto L10;
        this.hpackWriter.setHeaderTableSizeSetting(r10.getHeaderTableSize());     // Catch: Throwable -> L8
    L10:
        frameHeader(0, 0, (byte) 4, (byte) 1);     // Catch: Throwable -> L8
        this.sink.flush();     // Catch: Throwable -> L8
        monitor-exit(this);
        return;
    L14:
        throw new IOException("closed");     // Catch: Throwable -> L8
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        monitor-enter(this);
        this.closed = true;     // Catch: Throwable -> L7
        this.sink.close();     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public synchronized void connectionPreface() throws IOException {
        monitor-enter(this);
    L12:
        th = move-exception;
        throw th;
    L4:
        if (this.closed == true) goto L18;
        if (this.client == true) goto L9;
        monitor-exit(this);
        return;
    L9:
        Logger r10 = logger;     // Catch: Throwable -> L12
        if (r10.isLoggable(Level.FINE) == false) goto L14;
        r10.fine(Util.format(">> CONNECTION %s", new Object[]{Http2.CONNECTION_PREFACE.hex()}));     // Catch: Throwable -> L12
    L14:
        this.sink.write(Http2.CONNECTION_PREFACE.toByteArray());     // Catch: Throwable -> L12
        this.sink.flush();     // Catch: Throwable -> L12
        monitor-exit(this);
        return;
    L18:
        throw new IOException("closed");     // Catch: Throwable -> L12
    }

    public synchronized void data(boolean r10, int r11, Buffer r12, int r13) throws IOException {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (this.closed == true) goto L14;
        if (r10 == false) goto L7;
        byte r14 = (byte) 1;     // Catch: Throwable -> L11
    L8:
        dataFrame(r11, r14, r12, r13);     // Catch: Throwable -> L11
        monitor-exit(this);
        return;
    L7:
        r14 = 0;
        goto L8
    L14:
        throw new IOException("closed");     // Catch: Throwable -> L11
    }

    public void dataFrame(int r10, byte r11, Buffer r12, int r13) throws IOException {
        frameHeader(r10, r13, (byte) 0, r11);
        if (r13 <= 0) goto L6;
        this.sink.write(r12, r13);
        return;
    }

    public synchronized void flush() throws IOException {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (this.closed == true) goto L11;
        this.sink.flush();     // Catch: Throwable -> L8
        monitor-exit(this);
        return;
    L11:
        throw new IOException("closed");     // Catch: Throwable -> L8
    }

    public void frameHeader(int r10, int r11, byte r12, byte r13) throws IOException {
        Logger r14 = logger;
        if (r14.isLoggable(Level.FINE) == false) goto L5;
        r14.fine(Http2.frameLog(false, r10, r11, r12, r13));
    L5:
        int r15 = this.maxFrameSize;
        if (r11 > r15) goto L14;
        if ((Integer.MIN_VALUE & r10) != 0) goto L12;
        writeMedium(this.sink, r11);
        this.sink.writeByte(r12 & UnsignedBytes.MAX_VALUE);
        this.sink.writeByte(r13 & UnsignedBytes.MAX_VALUE);
        this.sink.writeInt(r10 & Channel.UNLIMITED);
        return;
    L12:
        throw Http2.illegalArgument("reserved bit set: %s", new Object[]{Integer.valueOf(r10)});
    L14:
        throw Http2.illegalArgument("FRAME_SIZE_ERROR length > %d: %d", new Object[]{Integer.valueOf(r15), Integer.valueOf(r11)});
    }

    public synchronized void goAway(int r10, ErrorCode r11, byte[] r12) throws IOException {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (this.closed == true) goto L18;
        if (r11.httpCode == (-1)) goto L16;
        frameHeader(0, r12.length + 8, (byte) 7, (byte) 0);     // Catch: Throwable -> L10
        this.sink.writeInt(r10);     // Catch: Throwable -> L10
        this.sink.writeInt(r11.httpCode);     // Catch: Throwable -> L10
        if (r12.length <= 0) goto L12;
        this.sink.write(r12);     // Catch: Throwable -> L10
    L12:
        this.sink.flush();     // Catch: Throwable -> L10
        monitor-exit(this);
        return;
    L16:
        throw Http2.illegalArgument("errorCode.httpCode == -1", new Object[0]);     // Catch: Throwable -> L10
    L18:
        throw new IOException("closed");     // Catch: Throwable -> L10
    }

    public synchronized void headers(int r10, List<Header> r11) throws IOException {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (this.closed == true) goto L11;
        headers(false, r10, r11);     // Catch: Throwable -> L8
        monitor-exit(this);
        return;
    L11:
        throw new IOException("closed");     // Catch: Throwable -> L8
    }

    public int maxDataLength() {
        return this.maxFrameSize;
    }

    public synchronized void ping(boolean r10, int r11, int r12) throws IOException {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (this.closed == true) goto L11;
        frameHeader(0, 8, (byte) 6, r10 ? 1 : 0);     // Catch: Throwable -> L8
        this.sink.writeInt(r11);     // Catch: Throwable -> L8
        this.sink.writeInt(r12);     // Catch: Throwable -> L8
        this.sink.flush();     // Catch: Throwable -> L8
        monitor-exit(this);
        return;
    L11:
        throw new IOException("closed");     // Catch: Throwable -> L8
    }

    public synchronized void pushPromise(int r10, int r11, List<Header> r12) throws IOException {
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L4:
        if (this.closed == true) goto L18;
        this.hpackWriter.writeHeaders(r12);     // Catch: Throwable -> L13
        long r13 = this.hpackBuffer.size();     // Catch: Throwable -> L13
        int r14 = (int) Math.min(this.maxFrameSize - 4, r13);     // Catch: Throwable -> L13
        long r15 = r14;
        if (r13 != r15) goto L8;
        byte r16 = 4;
    L9:
        frameHeader(r10, r14 + 4, (byte) 5, r16);     // Catch: Throwable -> L13
        this.sink.writeInt(r11 & Channel.UNLIMITED);     // Catch: Throwable -> L13
        this.sink.write(this.hpackBuffer, r15);     // Catch: Throwable -> L13
        if (r13 <= r15) goto L15;
        writeContinuationFrames(r10, r13 - r15);     // Catch: Throwable -> L13
    L15:
        monitor-exit(this);
        return;
    L8:
        r16 = 0;
        goto L9
    L18:
        throw new IOException("closed");     // Catch: Throwable -> L13
    }

    public synchronized void rstStream(int r10, ErrorCode r11) throws IOException {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (this.closed == true) goto L15;
        if (r11.httpCode == (-1)) goto L13;
        frameHeader(r10, 4, (byte) 3, (byte) 0);     // Catch: Throwable -> L10
        this.sink.writeInt(r11.httpCode);     // Catch: Throwable -> L10
        this.sink.flush();     // Catch: Throwable -> L10
        monitor-exit(this);
        return;
    L13:
        throw new IllegalArgumentException();     // Catch: Throwable -> L10
    L15:
        throw new IOException("closed");     // Catch: Throwable -> L10
    }

    public synchronized void settings(Settings r10) throws IOException {
        monitor-enter(this);
    L19:
        th = move-exception;
        throw th;
    L4:
        if (this.closed == true) goto L25;
        int r11 = 0;
        frameHeader(0, r10.size() * 6, (byte) 4, (byte) 0);     // Catch: Throwable -> L19
    L7:
        if (r11 >= 10) goto L21;
        if (r10.isSet(r11) == false) goto L18;
        if (r11 != 4) goto L14;
        int r12 = 3;
    L17:
        this.sink.writeShort(r12);     // Catch: Throwable -> L19
        this.sink.writeInt(r10.get(r11));     // Catch: Throwable -> L19
        goto L18
    L14:
        if (r11 != 7) goto L16;
        r12 = 4;
        goto L17
    L16:
        r12 = r11;
    L18:
        r11 = r11 + 1;     // Catch: Throwable -> L19
        goto L7
    L21:
        this.sink.flush();     // Catch: Throwable -> L19
        monitor-exit(this);
        return;
    L25:
        throw new IOException("closed");     // Catch: Throwable -> L19
    }

    public synchronized void synReply(boolean r10, int r11, List<Header> r12) throws IOException {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (this.closed == true) goto L11;
        headers(r10, r11, r12);     // Catch: Throwable -> L8
        monitor-exit(this);
        return;
    L11:
        throw new IOException("closed");     // Catch: Throwable -> L8
    }

    public synchronized void synStream(boolean r10, int r11, int r12, List<Header> r13) throws IOException {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (this.closed == true) goto L11;
        headers(r10, r11, r13);     // Catch: Throwable -> L8
        monitor-exit(this);
        return;
    L11:
        throw new IOException("closed");     // Catch: Throwable -> L8
    }

    public synchronized void windowUpdate(int r10, long r11) throws IOException {
        monitor-enter(this);
    L12:
        th = move-exception;
        throw th;
    L4:
        if (this.closed == true) goto L17;
        if (r11 == 0) goto L15;
        if (r11 > 2147483647L) goto L15;
        frameHeader(r10, 4, (byte) 8, (byte) 0);     // Catch: Throwable -> L12
        this.sink.writeInt((int) r11);     // Catch: Throwable -> L12
        this.sink.flush();     // Catch: Throwable -> L12
        monitor-exit(this);
        return;
    L15:
        throw Http2.illegalArgument("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: %s", new Object[]{Long.valueOf(r11)});     // Catch: Throwable -> L12
    L17:
        throw new IOException("closed");     // Catch: Throwable -> L12
    }

    public void headers(boolean r10, int r11, List<Header> r12) throws IOException {
        if (this.closed == true) goto L15;
        this.hpackWriter.writeHeaders(r12);
        long r13 = this.hpackBuffer.size();
        int r14 = (int) Math.min(this.maxFrameSize, r13);
        long r15 = r14;
        if (r13 != r15) goto L7;
        byte r16 = 4;
    L8:
        if (r10 == false) goto L10;
        r16 = (byte) (r16 | 1);
    L10:
        frameHeader(r11, r14, (byte) 1, r16);
        this.sink.write(this.hpackBuffer, r15);
        if (r13 <= r15) goto L16;
        writeContinuationFrames(r11, r13 - r15);
        return;
    L16:
        return;
    L7:
        r16 = 0;
        goto L8
    L15:
        throw new IOException("closed");
    }
}
