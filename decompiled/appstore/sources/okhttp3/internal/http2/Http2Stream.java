package okhttp3.internal.http2;

import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;
import okio.AsyncTimeout;
import okio.Buffer;
import okio.BufferedSource;
import okio.Sink;
import okio.Source;
import okio.Timeout;

/* JADX INFO: loaded from: classes4.dex */
public final class Http2Stream {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    long bytesLeftInWriteWindow;
    final Http2Connection connection;
    ErrorCode errorCode;
    private boolean hasResponseHeaders;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    final int f23002id;
    final StreamTimeout readTimeout;
    private final List<Header> requestHeaders;
    private List<Header> responseHeaders;
    final FramingSink sink;
    private final FramingSource source;
    long unacknowledgedBytesRead;
    final StreamTimeout writeTimeout;

    public final class FramingSink implements Sink {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private static final long EMIT_BUFFER_SIZE = 16384;
        boolean closed;
        boolean finished;
        private final Buffer sendBuffer;
        final /* synthetic */ Http2Stream this$0;

        static {
        }

        public FramingSink(Http2Stream r10) {
            this.this$0 = r10;
            this.sendBuffer = new Buffer();
        }

        private void emitFrame(boolean r12) throws IOException {
            Http2Stream r10 = this.this$0;
            monitor-enter(r10);
            this.this$0.writeTimeout.enter();     // Catch: Throwable -> L34
        L42:
            Http2Stream r11 = this.this$0;     // Catch: Throwable -> L15
            if (r11.bytesLeftInWriteWindow > 0) goto L17;
            if (this.finished == true) goto L17;
            if (this.closed == true) goto L17;
            if (r11.errorCode != null) goto L17;
            r11.waitForIo();     // Catch: Throwable -> L15
        L17:
            r11.writeTimeout.exitAndThrowIfTimedOut();     // Catch: Throwable -> L34
            this.this$0.checkOutNotClosed();     // Catch: Throwable -> L34
            long r13 = Math.min(this.this$0.bytesLeftInWriteWindow, this.sendBuffer.size());     // Catch: Throwable -> L34
            Http2Stream r14 = this.this$0;     // Catch: Throwable -> L34
            r14.bytesLeftInWriteWindow -= r13;     // Catch: Throwable -> L34
            monitor-exit(r10);     // Catch: Throwable -> L34
            r14.writeTimeout.enter();
            Http2Stream r15 = this.this$0;     // Catch: Throwable -> L26
            Http2Connection r16 = r15.connection;     // Catch: Throwable -> L26
            int r17 = r15.f23002id;     // Catch: Throwable -> L26
            if (r12 == true) goto L23;
        L28:
            boolean r18 = false;
        L29:
            r16.writeData(r17, r18, this.sendBuffer, r13);     // Catch: Throwable -> L26
            this.this$0.writeTimeout.exitAndThrowIfTimedOut();
            return;
        L23:
            if (r13 != this.sendBuffer.size()) goto L28;
            r18 = true;
        L26:
            th = move-exception;
            this.this$0.writeTimeout.exitAndThrowIfTimedOut();
            throw th;
        L15:
            th = move-exception;
            this.this$0.writeTimeout.exitAndThrowIfTimedOut();     // Catch: Throwable -> L34
            throw th;     // Catch: Throwable -> L34
        L34:
            th = move-exception;
            throw th;
        }

        @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            Http2Stream r10 = this.this$0;
            monitor-enter(r10);
        L8:
            th = move-exception;
            throw th;
        L5:
            if (this.closed == false) goto L10;
            monitor-exit(r10);     // Catch: Throwable -> L8
            return;
        L10:
            monitor-exit(r10);     // Catch: Throwable -> L8
            if (this.this$0.sink.finished == false) goto L14;
        L19:
            Http2Stream r11 = this.this$0;
            monitor-enter(r11);
            this.closed = true;     // Catch: Throwable -> L25
            monitor-exit(r11);     // Catch: Throwable -> L25
            this.this$0.connection.flush();
            this.this$0.cancelStreamIfNecessary();
            return;
        L25:
            th = move-exception;
            throw th;
        L14:
            if (this.sendBuffer.size() > 0) goto L16;
            Http2Stream r12 = this.this$0;
            r12.connection.writeData(r12.f23002id, true, null, 0);
        L16:
            if (this.sendBuffer.size() <= 0) goto L19;
            emitFrame(true);
            goto L16
        }

        @Override // okio.Sink, java.io.Flushable
        public void flush() throws IOException {
            Http2Stream r10 = this.this$0;
            monitor-enter(r10);
            this.this$0.checkOutNotClosed();     // Catch: Throwable -> L10
            monitor-exit(r10);     // Catch: Throwable -> L10
        L7:
            if (this.sendBuffer.size() <= 0) goto L9;
            emitFrame(false);
            this.this$0.connection.flush();
            goto L7
        L9:
            return;
        L10:
            th = move-exception;
            throw th;
        }

        @Override // okio.Sink
        public Timeout timeout() {
            return this.this$0.writeTimeout;
        }

        @Override // okio.Sink
        public void write(Buffer r10, long r11) throws IOException {
            this.sendBuffer.write(r10, r11);
        L4:
            if (this.sendBuffer.size() < 16384) goto L6;
            emitFrame(false);
            goto L4
        }
    }

    public final class FramingSource implements Source {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        boolean closed;
        boolean finished;
        private final long maxByteCount;
        private final Buffer readBuffer;
        private final Buffer receiveBuffer;
        final /* synthetic */ Http2Stream this$0;

        static {
        }

        public FramingSource(Http2Stream r10, long r11) {
            this.this$0 = r10;
            this.receiveBuffer = new Buffer();
            this.readBuffer = new Buffer();
            this.maxByteCount = r11;
        }

        private void checkNotClosed() throws IOException {
            if (this.closed == true) goto L10;
            if (this.this$0.errorCode != null) goto L8;
            return;
        L8:
            throw new StreamResetException(this.this$0.errorCode);
        L10:
            throw new IOException("stream closed");
        }

        private void waitUntilReadable() throws IOException {
            this.this$0.readTimeout.enter();
        L19:
        L13:
            th = move-exception;
            this.this$0.readTimeout.exitAndThrowIfTimedOut();
            throw th;
        L4:
            if (this.readBuffer.size() != 0) goto L15;
            if (this.finished == true) goto L15;
            if (this.closed == true) goto L15;
            Http2Stream r10 = this.this$0;     // Catch: Throwable -> L13
            if (r10.errorCode != null) goto L15;
            r10.waitForIo();     // Catch: Throwable -> L13
        L15:
            this.this$0.readTimeout.exitAndThrowIfTimedOut();
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            Http2Stream r10 = this.this$0;
            monitor-enter(r10);
            this.closed = true;     // Catch: Throwable -> L9
            this.readBuffer.a();     // Catch: Throwable -> L9
            this.this$0.notifyAll();     // Catch: Throwable -> L9
            monitor-exit(r10);     // Catch: Throwable -> L9
            this.this$0.cancelStreamIfNecessary();
            return;
        L9:
            th = move-exception;
            throw th;
        }

        @Override // okio.Source
        public long read(Buffer r10, long r11) throws IOException {
            if (r11 < 0) goto L31;
            Http2Stream r12 = this.this$0;
            monitor-enter(r12);
            waitUntilReadable();     // Catch: Throwable -> L11
            checkNotClosed();     // Catch: Throwable -> L11
            if (this.readBuffer.size() != 0) goto L13;
            monitor-exit(r12);     // Catch: Throwable -> L11
            return -1;
        L13:
            Buffer r13 = this.readBuffer;     // Catch: Throwable -> L11
            long r14 = r13.read(r10, Math.min(r11, r13.size()));     // Catch: Throwable -> L11
            Http2Stream r15 = this.this$0;     // Catch: Throwable -> L11
            long r16 = r15.unacknowledgedBytesRead + r14;     // Catch: Throwable -> L11
            r15.unacknowledgedBytesRead = r16;     // Catch: Throwable -> L11
            if (r16 < (r15.connection.okHttpSettings.getInitialWindowSize() / 2)) goto L16;
            Http2Stream r17 = this.this$0;     // Catch: Throwable -> L11
            r17.connection.writeWindowUpdateLater(r17.f23002id, r17.unacknowledgedBytesRead);     // Catch: Throwable -> L11
            this.this$0.unacknowledgedBytesRead = 0;     // Catch: Throwable -> L11
        L16:
            monitor-exit(r12);     // Catch: Throwable -> L11
            Http2Connection r18 = this.this$0.connection;
            monitor-enter(r18);
            Http2Connection r19 = this.this$0.connection;     // Catch: Throwable -> L22
            long r20 = r19.unacknowledgedBytesRead + r14;     // Catch: Throwable -> L22
            r19.unacknowledgedBytesRead = r20;     // Catch: Throwable -> L22
            if (r20 < (r19.okHttpSettings.getInitialWindowSize() / 2)) goto L24;
            Http2Connection r21 = this.this$0.connection;     // Catch: Throwable -> L22
            r21.writeWindowUpdateLater(0, r21.unacknowledgedBytesRead);     // Catch: Throwable -> L22
            this.this$0.connection.unacknowledgedBytesRead = 0;     // Catch: Throwable -> L22
        L24:
            monitor-exit(r18);     // Catch: Throwable -> L22
            return r14;
        L22:
            th = move-exception;
            throw th;
        L11:
            th = move-exception;
            throw th;
        L31:
            throw new IllegalArgumentException("byteCount < 0: " + r11);
        }

        public void receive(BufferedSource r10, long r11) throws IOException {
        L3:
            if (r11 <= 0) goto L38;
            Http2Stream r12 = this.this$0;
            monitor-enter(r12);
            boolean r13 = this.finished;     // Catch: Throwable -> L35
            boolean r14 = false;
            if ((this.readBuffer.size() + r11) <= this.maxByteCount) goto L9;
            boolean r15 = true;
        L10:
            monitor-exit(r12);     // Catch: Throwable -> L35
            if (r15 == true) goto L12;
            if (r13 == true) goto L15;
            long r16 = r10.read(this.receiveBuffer, r11);
            if (r16 == (-1)) goto L34;
            r11 = r11 - r16;
            Http2Stream r17 = this.this$0;
            monitor-enter(r17);
            if (this.readBuffer.size() != 0) goto L24;
            r14 = true;
        L24:
            this.readBuffer.writeAll(this.receiveBuffer);     // Catch: Throwable -> L27
            if (r14 == false) goto L29;
            this.this$0.notifyAll();     // Catch: Throwable -> L27
        L29:
            monitor-exit(r17);     // Catch: Throwable -> L27
        L27:
            th = move-exception;
            throw th;
        L34:
            throw new EOFException();
        L15:
            r10.skip(r11);
            return;
        L12:
            r10.skip(r11);
            this.this$0.closeLater(ErrorCode.FLOW_CONTROL_ERROR);
            return;
        L9:
            r15 = false;
        L35:
            th = move-exception;
            throw th;
        }

        @Override // okio.Source
        public Timeout timeout() {
            return this.this$0.readTimeout;
        }
    }

    public class StreamTimeout extends AsyncTimeout {
        final /* synthetic */ Http2Stream this$0;

        public StreamTimeout(Http2Stream r10) {
            this.this$0 = r10;
        }

        public void exitAndThrowIfTimedOut() throws IOException {
            if (exit() == true) goto L6;
            return;
        L6:
            throw newTimeoutException(null);
        }

        @Override // okio.AsyncTimeout
        public IOException newTimeoutException(IOException r10) {
            SocketTimeoutException r11 = new SocketTimeoutException("timeout");
            if (r10 == null) goto L5;
            r11.initCause(r10);
        L5:
            return r11;
        }

        @Override // okio.AsyncTimeout
        public void timedOut() {
            this.this$0.closeLater(ErrorCode.CANCEL);
        }
    }

    static {
    }

    public Http2Stream(int r10, Http2Connection r11, boolean r12, boolean r13, List<Header> r14) {
        this.unacknowledgedBytesRead = 0;
        this.readTimeout = new StreamTimeout(this);
        this.writeTimeout = new StreamTimeout(this);
        this.errorCode = null;
        if (r11 == null) goto L10;
        if (r14 == null) goto L8;
        this.f23002id = r10;
        this.connection = r11;
        this.bytesLeftInWriteWindow = r11.peerSettings.getInitialWindowSize();
        FramingSource r15 = new FramingSource(this, r11.okHttpSettings.getInitialWindowSize());
        this.source = r15;
        FramingSink r16 = new FramingSink(this);
        this.sink = r16;
        r15.finished = r13;
        r16.finished = r12;
        this.requestHeaders = r14;
        return;
    L8:
        throw new NullPointerException("requestHeaders == null");
    L10:
        throw new NullPointerException("connection == null");
    }

    private boolean closeInternal(ErrorCode r10) {
        monitor-enter(this);
    L7:
        th = move-exception;
        throw th;
    L4:
        if (this.errorCode == null) goto L10;
        monitor-exit(this);     // Catch: Throwable -> L7
        return false;
    L10:
        if (this.source.finished == true) goto L12;
    L15:
        this.errorCode = r10;     // Catch: Throwable -> L7
        notifyAll();     // Catch: Throwable -> L7
        monitor-exit(this);     // Catch: Throwable -> L7
        this.connection.removeStream(this.f23002id);
        return true;
    L12:
        if (this.sink.finished == false) goto L15;
        monitor-exit(this);     // Catch: Throwable -> L7
        return false;
    }

    public void addBytesToWriteWindow(long r10) {
        this.bytesLeftInWriteWindow += r10;
        if (r10 <= 0) goto L6;
        notifyAll();
        return;
    }

    public void cancelStreamIfNecessary() throws IOException {
        monitor-enter(this);
        FramingSource r10 = this.source;     // Catch: Throwable -> L12
        if (r10.finished == false) goto L6;
    L15:
        boolean r11 = false;
    L16:
        boolean r12 = isOpen();     // Catch: Throwable -> L12
        monitor-exit(this);     // Catch: Throwable -> L12
        if (r11 == false) goto L20;
        close(ErrorCode.CANCEL);
        return;
    L20:
        if (r12 == true) goto L28;
        this.connection.removeStream(this.f23002id);
        return;
    L28:
        return;
    L6:
        if (r10.closed == false) goto L15;
        FramingSink r13 = this.sink;     // Catch: Throwable -> L12
        if (r13.finished == false) goto L10;
    L14:
        r11 = true;
        goto L16
    L10:
        if (r13.closed == false) goto L15;
    L12:
        th = move-exception;
        throw th;
    }

    public void checkOutNotClosed() throws IOException {
        FramingSink r10 = this.sink;
        if (r10.closed == true) goto L14;
        if (r10.finished == true) goto L12;
        if (this.errorCode != null) goto L10;
        return;
    L10:
        throw new StreamResetException(this.errorCode);
    L12:
        throw new IOException("stream finished");
    L14:
        throw new IOException("stream closed");
    }

    public void close(ErrorCode r10) throws IOException {
        if (closeInternal(r10) == true) goto L5;
        return;
    L5:
        this.connection.writeSynReset(this.f23002id, r10);
    }

    public void closeLater(ErrorCode r10) {
        if (closeInternal(r10) == true) goto L5;
        return;
    L5:
        this.connection.writeSynResetLater(this.f23002id, r10);
    }

    public Http2Connection getConnection() {
        return this.connection;
    }

    public synchronized ErrorCode getErrorCode() {
        monitor-enter(this);
        ErrorCode r10 = this.errorCode;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r10;
    L6:
        th = move-exception;
        throw th;
    }

    public int getId() {
        return this.f23002id;
    }

    public List<Header> getRequestHeaders() {
        return this.requestHeaders;
    }

    public Sink getSink() {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (this.hasResponseHeaders == false) goto L6;
    L12:
        monitor-exit(this);     // Catch: Throwable -> L10
        return this.sink;
    L6:
        if (isLocallyInitiated() == true) goto L12;
        throw new IllegalStateException("reply before requesting the sink");     // Catch: Throwable -> L10
    }

    public Source getSource() {
        return this.source;
    }

    public boolean isLocallyInitiated() {
        if ((this.f23002id & 1) != 1) goto L5;
        boolean r10 = true;
    L7:
        if (this.connection.client != r10) goto L10;
        return true;
    L10:
        return false;
    L5:
        r10 = false;
        goto L7
    }

    public synchronized boolean isOpen() {
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (this.errorCode == null) goto L8;
        monitor-exit(this);
        return false;
    L8:
        FramingSource r10 = this.source;     // Catch: Throwable -> L13
        if (r10.finished == false) goto L11;
    L15:
        FramingSink r11 = this.sink;     // Catch: Throwable -> L13
        if (r11.finished == false) goto L18;
    L19:
        if (this.hasResponseHeaders == false) goto L23;
        monitor-exit(this);
        return false;
    L23:
        monitor-exit(this);
        return true;
    L18:
        if (r11.closed == false) goto L23;
    L11:
        if (r10.closed == false) goto L23;
        goto L23
    }

    public Timeout readTimeout() {
        return this.readTimeout;
    }

    public void receiveData(BufferedSource r10, int r11) throws IOException {
        this.source.receive(r10, r11);
    }

    public void receiveFin() {
        monitor-enter(this);
        this.source.finished = true;     // Catch: Throwable -> L8
        boolean r10 = isOpen();     // Catch: Throwable -> L8
        notifyAll();     // Catch: Throwable -> L8
        monitor-exit(this);     // Catch: Throwable -> L8
        if (r10 == true) goto L13;
        this.connection.removeStream(this.f23002id);
        return;
    L13:
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public void receiveHeaders(List<Header> r10) {
        monitor-enter(this);
        boolean r11 = true;
        this.hasResponseHeaders = true;     // Catch: Throwable -> L7
        if (this.responseHeaders != null) goto L9;
        this.responseHeaders = r10;     // Catch: Throwable -> L7
        r11 = isOpen();     // Catch: Throwable -> L7
        notifyAll();     // Catch: Throwable -> L7
    L10:
        monitor-exit(this);     // Catch: Throwable -> L7
        if (r11 == true) goto L18;
        this.connection.removeStream(this.f23002id);
        return;
    L18:
        return;
    L9:
        ArrayList r12 = new ArrayList();     // Catch: Throwable -> L7
        r12.addAll(this.responseHeaders);     // Catch: Throwable -> L7
        r12.add(null);     // Catch: Throwable -> L7
        r12.addAll(r10);     // Catch: Throwable -> L7
        this.responseHeaders = r12;     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        throw th;
    }

    public synchronized void receiveRstStream(ErrorCode r10) {
        monitor-enter(this);
    L7:
        th = move-exception;
        throw th;
    L4:
        if (this.errorCode != null) goto L9;
        this.errorCode = r10;     // Catch: Throwable -> L7
        notifyAll();     // Catch: Throwable -> L7
    L9:
        monitor-exit(this);
    }

    public void sendResponseHeaders(List<Header> r10, boolean r11) throws IOException {
        if (r10 == null) goto L19;
        monitor-enter(this);
        boolean r12 = true;
        this.hasResponseHeaders = true;     // Catch: Throwable -> L8
        if (r11 == true) goto L10;
        this.sink.finished = true;     // Catch: Throwable -> L8
    L11:
        monitor-exit(this);     // Catch: Throwable -> L8
        this.connection.writeSynReply(this.f23002id, r12, r10);
        if (r12 == false) goto L22;
        this.connection.flush();
        return;
    L22:
        return;
    L10:
        r12 = false;
    L8:
        th = move-exception;
        throw th;
    L19:
        throw new NullPointerException("responseHeaders == null");
    }

    public synchronized List<Header> takeResponseHeaders() throws IOException {
        monitor-enter(this);
    L19:
        th = move-exception;
        throw th;
    L4:
        if (isLocallyInitiated() == false) goto L26;
        this.readTimeout.enter();     // Catch: Throwable -> L19
    L29:
    L12:
        th = move-exception;
        this.readTimeout.exitAndThrowIfTimedOut();     // Catch: Throwable -> L19
        throw th;     // Catch: Throwable -> L19
    L7:
        if (this.responseHeaders != null) goto L14;
        if (this.errorCode != null) goto L14;
        waitForIo();     // Catch: Throwable -> L12
    L14:
        this.readTimeout.exitAndThrowIfTimedOut();     // Catch: Throwable -> L19
        List<Header> r10 = this.responseHeaders;     // Catch: Throwable -> L19
        if (r10 == null) goto L22;
        this.responseHeaders = null;     // Catch: Throwable -> L19
        monitor-exit(this);
        return r10;
    L22:
        throw new StreamResetException(this.errorCode);     // Catch: Throwable -> L19
    L26:
        throw new IllegalStateException("servers cannot read response headers");     // Catch: Throwable -> L19
    }

    public void waitForIo() throws InterruptedIOException {
        wait();     // Catch: InterruptedException -> L4
        return;
    L5:
        throw new InterruptedIOException();
    }

    public Timeout writeTimeout() {
        return this.writeTimeout;
    }
}
