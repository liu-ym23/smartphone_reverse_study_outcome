package okhttp3.internal.http1;

import android.support.v4.media.session.PlaybackStateCompat;
import fg.j;
import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.Internal;
import okhttp3.internal.Util;
import okhttp3.internal.connection.RealConnection;
import okhttp3.internal.connection.StreamAllocation;
import okhttp3.internal.http.HttpCodec;
import okhttp3.internal.http.HttpHeaders;
import okhttp3.internal.http.RealResponseBody;
import okhttp3.internal.http.RequestLine;
import okhttp3.internal.http.StatusLine;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ForwardingTimeout;
import okio.Sink;
import okio.Source;
import okio.Timeout;
import org.apache.http.protocol.HTTP;

/* JADX INFO: loaded from: classes4.dex */
public final class Http1Codec implements HttpCodec {
    private static final int HEADER_LIMIT = 262144;
    private static final int STATE_CLOSED = 6;
    private static final int STATE_IDLE = 0;
    private static final int STATE_OPEN_REQUEST_BODY = 1;
    private static final int STATE_OPEN_RESPONSE_BODY = 4;
    private static final int STATE_READING_RESPONSE_BODY = 5;
    private static final int STATE_READ_RESPONSE_HEADERS = 3;
    private static final int STATE_WRITING_REQUEST_BODY = 2;
    final OkHttpClient client;
    private long headerLimit;
    final BufferedSink sink;
    final BufferedSource source;
    int state;
    final StreamAllocation streamAllocation;

    /* JADX INFO: renamed from: okhttp3.internal.http1.Http1Codec$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public abstract class AbstractSource implements Source {
        protected long bytesRead;
        protected boolean closed;
        final /* synthetic */ Http1Codec this$0;
        protected final ForwardingTimeout timeout;

        private AbstractSource(Http1Codec r10) {
            this.this$0 = r10;
            this.timeout = new ForwardingTimeout(r10.source.timeout());
            this.bytesRead = 0;
        }

        public final void endOfInput(boolean r10, IOException r11) throws IOException {
            Http1Codec r12 = this.this$0;
            int r13 = r12.state;
            if (r13 != 6) goto L6;
            return;
        L6:
            if (r13 != 5) goto L12;
            r12.detachTimeout(this.timeout);
            Http1Codec r14 = this.this$0;
            r14.state = 6;
            StreamAllocation r15 = r14.streamAllocation;
            if (r15 == null) goto L13;
            r15.streamFinished(!r10, r14, this.bytesRead, r11);
            return;
        L13:
            return;
        L12:
            throw new IllegalStateException("state: " + this.this$0.state);
        }

        @Override // okio.Source
        public long read(Buffer r10, long r11) throws IOException {
            long r12 = this.this$0.source.read(r10, r11);     // Catch: IOException -> L6
            if (r12 <= 0) goto L8;
            this.bytesRead += r12;     // Catch: IOException -> L6
        L8:
            return r12;
        L6:
            e = move-exception;
            endOfInput(false, e);
            throw e;
        }

        @Override // okio.Source
        public Timeout timeout() {
            return this.timeout;
        }

        public /* synthetic */ AbstractSource(Http1Codec r10, AnonymousClass1 r11) {
            this(r10);
        }
    }

    public final class ChunkedSink implements Sink {
        private boolean closed;
        final /* synthetic */ Http1Codec this$0;
        private final ForwardingTimeout timeout;

        public ChunkedSink(Http1Codec r10) {
            this.this$0 = r10;
            this.timeout = new ForwardingTimeout(r10.sink.timeout());
        }

        @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
        public synchronized void close() throws IOException {
            monitor-enter(this);
        L11:
            th = move-exception;
            throw th;
        L4:
            if (this.closed == false) goto L8;
            monitor-exit(this);
            return;
        L8:
            this.closed = true;     // Catch: Throwable -> L11
            this.this$0.sink.writeUtf8("0\r\n\r\n");     // Catch: Throwable -> L11
            this.this$0.detachTimeout(this.timeout);     // Catch: Throwable -> L11
            this.this$0.state = 3;     // Catch: Throwable -> L11
            monitor-exit(this);
        }

        @Override // okio.Sink, java.io.Flushable
        public synchronized void flush() throws IOException {
            monitor-enter(this);
        L10:
            th = move-exception;
            throw th;
        L4:
            if (this.closed == false) goto L7;
            monitor-exit(this);
            return;
        L7:
            this.this$0.sink.flush();     // Catch: Throwable -> L10
            monitor-exit(this);
        }

        @Override // okio.Sink
        public Timeout timeout() {
            return this.timeout;
        }

        @Override // okio.Sink
        public void write(Buffer r10, long r11) throws IOException {
            if (this.closed == true) goto L10;
            if (r11 != 0) goto L7;
            return;
        L7:
            this.this$0.sink.writeHexadecimalUnsignedLong(r11);
            this.this$0.sink.writeUtf8("\r\n");
            this.this$0.sink.write(r10, r11);
            this.this$0.sink.writeUtf8("\r\n");
            return;
        L10:
            throw new IllegalStateException("closed");
        }
    }

    public class ChunkedSource extends AbstractSource {
        private static final long NO_CHUNK_YET = -1;
        private long bytesRemainingInChunk;
        private boolean hasMoreChunks;
        final /* synthetic */ Http1Codec this$0;
        private final HttpUrl url;

        public ChunkedSource(Http1Codec r10, HttpUrl r11) {
            this.this$0 = r10;
            super(r10, null);
            this.bytesRemainingInChunk = -1;
            this.hasMoreChunks = true;
            this.url = r11;
        }

        private void readChunkSize() throws IOException {
            if (this.bytesRemainingInChunk == (-1)) goto L22;
            this.this$0.source.readUtf8LineStrict();
        L22:
            this.bytesRemainingInChunk = this.this$0.source.readHexadecimalUnsignedLong();     // Catch: NumberFormatException -> L12
            String r10 = this.this$0.source.readUtf8LineStrict().trim();     // Catch: NumberFormatException -> L12
            if (this.bytesRemainingInChunk < 0) goto L19;
            if (r10.isEmpty() == true) goto L15;
            if (r10.startsWith(";") == false) goto L19;
        L15:
            if (this.bytesRemainingInChunk != 0) goto L24;
            this.hasMoreChunks = false;
            HttpHeaders.receiveHeaders(this.this$0.client.f(), this.url, this.this$0.readHeaders());
            endOfInput(true, null);
            return;
        L24:
            return;
        L19:
            throw new ProtocolException("expected chunk size and optional extensions but was \"" + this.bytesRemainingInChunk + r10 + "\"");     // Catch: NumberFormatException -> L12
        L12:
            e = move-exception;
            throw new ProtocolException(e.getMessage());
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.closed == false) goto L6;
            return;
        L6:
            if (this.hasMoreChunks == true) goto L8;
        L10:
            this.closed = true;
            return;
        L8:
            if (Util.discard(this, 100, TimeUnit.MILLISECONDS) == true) goto L10;
            endOfInput(false, null);
            goto L10
        }

        @Override // okhttp3.internal.http1.Http1Codec.AbstractSource, okio.Source
        public long read(Buffer r10, long r11) throws IOException {
            if (r11 < 0) goto L25;
            if (this.closed == true) goto L23;
            if (this.hasMoreChunks == true) goto L9;
            return -1;
        L9:
            long r12 = this.bytesRemainingInChunk;
            if (r12 != 0) goto L12;
        L13:
            readChunkSize();
            if (this.hasMoreChunks == true) goto L16;
            return -1;
        L16:
            long r13 = super.read(r10, Math.min(r11, this.bytesRemainingInChunk));
            if (r13 == (-1)) goto L20;
            this.bytesRemainingInChunk -= r13;
            return r13;
        L20:
            ProtocolException r14 = new ProtocolException("unexpected end of stream");
            endOfInput(false, r14);
            throw r14;
        L12:
            if (r12 != (-1)) goto L16;
        L23:
            throw new IllegalStateException("closed");
        L25:
            throw new IllegalArgumentException("byteCount < 0: " + r11);
        }
    }

    public final class FixedLengthSink implements Sink {
        private long bytesRemaining;
        private boolean closed;
        final /* synthetic */ Http1Codec this$0;
        private final ForwardingTimeout timeout;

        public FixedLengthSink(Http1Codec r10, long r11) {
            this.this$0 = r10;
            this.timeout = new ForwardingTimeout(r10.sink.timeout());
            this.bytesRemaining = r11;
        }

        @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.closed == false) goto L5;
            return;
        L5:
            this.closed = true;
            if (this.bytesRemaining > 0) goto L10;
            this.this$0.detachTimeout(this.timeout);
            this.this$0.state = 3;
            return;
        L10:
            throw new ProtocolException("unexpected end of stream");
        }

        @Override // okio.Sink, java.io.Flushable
        public void flush() throws IOException {
            if (this.closed == false) goto L5;
            return;
        L5:
            this.this$0.sink.flush();
        }

        @Override // okio.Sink
        public Timeout timeout() {
            return this.timeout;
        }

        @Override // okio.Sink
        public void write(Buffer r10, long r11) throws IOException {
            if (this.closed == true) goto L11;
            Util.checkOffsetAndCount(r10.size(), 0, r11);
            if (r11 > this.bytesRemaining) goto L9;
            this.this$0.sink.write(r10, r11);
            this.bytesRemaining -= r11;
            return;
        L9:
            throw new ProtocolException("expected " + this.bytesRemaining + " bytes but received " + r11);
        L11:
            throw new IllegalStateException("closed");
        }
    }

    public class FixedLengthSource extends AbstractSource {
        private long bytesRemaining;
        final /* synthetic */ Http1Codec this$0;

        public FixedLengthSource(Http1Codec r10, long r11) throws IOException {
            this.this$0 = r10;
            super(r10, null);
            this.bytesRemaining = r11;
            if (r11 != 0) goto L6;
            endOfInput(true, null);
            return;
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.closed == false) goto L6;
            return;
        L6:
            if (this.bytesRemaining != 0) goto L8;
        L10:
            this.closed = true;
            return;
        L8:
            if (Util.discard(this, 100, TimeUnit.MILLISECONDS) == true) goto L10;
            endOfInput(false, null);
            goto L10
        }

        @Override // okhttp3.internal.http1.Http1Codec.AbstractSource, okio.Source
        public long read(Buffer r10, long r11) throws IOException {
            if (r11 < 0) goto L20;
            if (this.closed == true) goto L18;
            long r12 = this.bytesRemaining;
            if (r12 != 0) goto L9;
            return -1;
        L9:
            long r13 = super.read(r10, Math.min(r12, r11));
            if (r13 == (-1)) goto L15;
            long r14 = this.bytesRemaining - r13;
            this.bytesRemaining = r14;
            if (r14 != 0) goto L14;
            endOfInput(true, null);
        L14:
            return r13;
        L15:
            ProtocolException r15 = new ProtocolException("unexpected end of stream");
            endOfInput(false, r15);
            throw r15;
        L18:
            throw new IllegalStateException("closed");
        L20:
            throw new IllegalArgumentException("byteCount < 0: " + r11);
        }
    }

    public class UnknownLengthSource extends AbstractSource {
        private boolean inputExhausted;
        final /* synthetic */ Http1Codec this$0;

        public UnknownLengthSource(Http1Codec r10) {
            this.this$0 = r10;
            super(r10, null);
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.closed == false) goto L6;
            return;
        L6:
            if (this.inputExhausted == true) goto L8;
            endOfInput(false, null);
        L8:
            this.closed = true;
        }

        @Override // okhttp3.internal.http1.Http1Codec.AbstractSource, okio.Source
        public long read(Buffer r10, long r11) throws IOException {
            if (r11 < 0) goto L17;
            if (this.closed == true) goto L15;
            if (this.inputExhausted == false) goto L9;
            return -1;
        L9:
            long r12 = super.read(r10, r11);
            if (r12 != (-1)) goto L13;
            this.inputExhausted = true;
            endOfInput(true, null);
            return -1;
        L13:
            return r12;
        L15:
            throw new IllegalStateException("closed");
        L17:
            throw new IllegalArgumentException("byteCount < 0: " + r11);
        }
    }

    public Http1Codec(OkHttpClient r10, StreamAllocation r11, BufferedSource r12, BufferedSink r13) {
        this.state = 0;
        this.headerLimit = PlaybackStateCompat.ACTION_SET_REPEAT_MODE;
        this.client = r10;
        this.streamAllocation = r11;
        this.source = r12;
        this.sink = r13;
    }

    private String readHeaderLine() throws IOException {
        String r10 = this.source.readUtf8LineStrict(this.headerLimit);
        this.headerLimit -= (long) r10.length();
        return r10;
    }

    @Override // okhttp3.internal.http.HttpCodec
    public void cancel() {
        RealConnection r10 = this.streamAllocation.connection();
        if (r10 == null) goto L6;
        r10.cancel();
        return;
    }

    @Override // okhttp3.internal.http.HttpCodec
    public Sink createRequestBody(Request r10, long r11) {
        if (HTTP.CHUNK_CODING.equalsIgnoreCase(r10.c("Transfer-Encoding")) == false) goto L7;
        return newChunkedSink();
    L7:
        if (r11 == (-1)) goto L11;
        return newFixedLengthSink(r11);
    L11:
        throw new IllegalStateException("Cannot stream a request body without chunked encoding or a known content length!");
    }

    public void detachTimeout(ForwardingTimeout r10) {
        Timeout r11 = r10.a();
        r10.b(Timeout.NONE);
        r11.clearDeadline();
        r11.clearTimeout();
    }

    @Override // okhttp3.internal.http.HttpCodec
    public void finishRequest() throws IOException {
        this.sink.flush();
    }

    @Override // okhttp3.internal.http.HttpCodec
    public void flushRequest() throws IOException {
        this.sink.flush();
    }

    public boolean isClosed() {
        if (this.state != 6) goto L5;
        return true;
    L5:
        return false;
    }

    public Sink newChunkedSink() {
        if (this.state != 1) goto L7;
        this.state = 2;
        return new ChunkedSink(this);
    L7:
        throw new IllegalStateException("state: " + this.state);
    }

    public Source newChunkedSource(HttpUrl r10) throws IOException {
        if (this.state != 4) goto L7;
        this.state = 5;
        return new ChunkedSource(this, r10);
    L7:
        throw new IllegalStateException("state: " + this.state);
    }

    public Sink newFixedLengthSink(long r10) {
        if (this.state != 1) goto L7;
        this.state = 2;
        return new FixedLengthSink(this, r10);
    L7:
        throw new IllegalStateException("state: " + this.state);
    }

    public Source newFixedLengthSource(long r10) throws IOException {
        if (this.state != 4) goto L7;
        this.state = 5;
        return new FixedLengthSource(this, r10);
    L7:
        throw new IllegalStateException("state: " + this.state);
    }

    public Source newUnknownLengthSource() throws IOException {
        if (this.state != 4) goto L11;
        StreamAllocation r10 = this.streamAllocation;
        if (r10 == null) goto L9;
        this.state = 5;
        r10.noNewStreams();
        return new UnknownLengthSource(this);
    L9:
        throw new IllegalStateException("streamAllocation == null");
    L11:
        throw new IllegalStateException("state: " + this.state);
    }

    @Override // okhttp3.internal.http.HttpCodec
    public ResponseBody openResponseBody(Response r10) throws IOException {
        StreamAllocation r11 = this.streamAllocation;
        r11.eventListener.responseBodyStart(r11.call);
        String r12 = r10.f("Content-Type");
        if (HttpHeaders.hasBody(r10) == true) goto L7;
        return new RealResponseBody(r12, 0, j.d(newFixedLengthSource(0)));
    L7:
        if (HTTP.CHUNK_CODING.equalsIgnoreCase(r10.f("Transfer-Encoding")) == true) goto L9;
        long r13 = HttpHeaders.contentLength(r10);
        if (r13 == (-1)) goto L15;
        return new RealResponseBody(r12, r13, j.d(newFixedLengthSource(r13)));
    L15:
        return new RealResponseBody(r12, -1, j.d(newUnknownLengthSource()));
    L9:
        return new RealResponseBody(r12, -1, j.d(newChunkedSource(r10.r().k())));
    }

    public Headers readHeaders() throws IOException {
        Headers.Builder r10 = new Headers.Builder();
    L3:
        String r11 = readHeaderLine();
        if (r11.length() == 0) goto L7;
        Internal.instance.addLenient(r10, r11);
        goto L3
    L7:
        return r10.d();
    }

    @Override // okhttp3.internal.http.HttpCodec
    public Response.Builder readResponseHeaders(boolean r10) throws IOException {
        int r11 = this.state;
        if (r11 == 1) goto L24;
        if (r11 == 3) goto L24;
        throw new IllegalStateException("state: " + this.state);
    L24:
        StatusLine r12 = StatusLine.parse(readHeaderLine());     // Catch: EOFException -> L14
        Response.Builder r13 = new Response.Builder().m(r12.protocol).g(r12.code).j(r12.message).i(readHeaders());     // Catch: EOFException -> L14
        if (r10 == false) goto L17;
        if (r12.code != 100) goto L17;
        return null;
    L17:
        if (r12.code != 100) goto L20;
        this.state = 3;     // Catch: EOFException -> L14
        return r13;
    L20:
        this.state = 4;     // Catch: EOFException -> L14
        return r13;
    L14:
        e = move-exception;
        IOException r14 = new IOException("unexpected end of stream on " + this.streamAllocation);
        r14.initCause(e);
        throw r14;
    }

    public void writeRequest(Headers r10, String r11) throws IOException {
        if (this.state != 0) goto L10;
        this.sink.writeUtf8(r11).writeUtf8("\r\n");
        int r12 = r10.h();
        int r13 = 0;
    L5:
        if (r13 >= r12) goto L7;
        this.sink.writeUtf8(r10.d(r13)).writeUtf8(": ").writeUtf8(r10.j(r13)).writeUtf8("\r\n");
        r13 = r13 + 1;
        goto L5
    L7:
        this.sink.writeUtf8("\r\n");
        this.state = 1;
        return;
    L10:
        throw new IllegalStateException("state: " + this.state);
    }

    @Override // okhttp3.internal.http.HttpCodec
    public void writeRequestHeaders(Request r10) throws IOException {
        String r11 = RequestLine.get(r10, this.streamAllocation.connection().route().b().type());
        writeRequest(r10.e(), r11);
    }
}
