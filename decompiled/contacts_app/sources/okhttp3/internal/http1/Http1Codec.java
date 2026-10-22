package okhttp3.internal.http1;

import android.support.v4.media.session.PlaybackStateCompat;
import com.android.vcard.VCardBuilder;
import com.ss.android.http.legacy.protocol.HTTP;
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
import okio.Okio;
import okio.Sink;
import okio.Source;
import okio.Timeout;

/* JADX INFO: loaded from: classes5.dex */
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
    static /* synthetic */ class AnonymousClass1 {
    }

    private abstract class AbstractSource implements Source {
        protected long bytesRead;
        protected boolean closed;
        final /* synthetic */ Http1Codec this$0;
        protected final ForwardingTimeout timeout;

        private AbstractSource(Http1Codec r3) {
            this.this$0 = r3;
            this.timeout = new ForwardingTimeout(r3.source.timeout());
            this.bytesRead = 0;
        }

        /* synthetic */ AbstractSource(Http1Codec r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // okio.Source
        public Timeout timeout() {
            return this.timeout;
        }

        @Override // okio.Source
        public long read(Buffer r3, long r4) throws IOException {
            long r5 = this.this$0.source.read(r3, r4);     // Catch: IOException -> L6
            if (r5 <= 0) goto L5;
            this.bytesRead += r5;     // Catch: IOException -> L6
        L5:
            return r5;
        L6:
            e = move-exception;
            endOfInput(false, e);
            throw e;
        }

        protected final void endOfInput(boolean r8, IOException r9) throws IOException {
            if (this.this$0.state != 6) goto L6;
            return;
        L6:
            if (this.this$0.state != 5) goto L12;
            this.this$0.detachTimeout(this.timeout);
            this.this$0.state = 6;
            if (this.this$0.streamAllocation == null) goto L13;
            this.this$0.streamAllocation.streamFinished(!r8, this.this$0, this.bytesRead, r9);
            return;
        L13:
            return;
        L12:
            throw new IllegalStateException("state: " + this.this$0.state);
        }
    }

    private final class ChunkedSink implements Sink {
        private boolean closed;
        final /* synthetic */ Http1Codec this$0;
        private final ForwardingTimeout timeout;

        ChunkedSink(Http1Codec r2) {
            this.this$0 = r2;
            this.timeout = new ForwardingTimeout(r2.sink.timeout());
        }

        @Override // okio.Sink
        public Timeout timeout() {
            return this.timeout;
        }

        @Override // okio.Sink
        public void write(Buffer r3, long r4) throws IOException {
            if (this.closed == true) goto L10;
            if (r4 != 0) goto L7;
            return;
        L7:
            this.this$0.sink.writeHexadecimalUnsignedLong(r4);
            this.this$0.sink.writeUtf8(VCardBuilder.VCARD_END_OF_LINE);
            this.this$0.sink.write(r3, r4);
            this.this$0.sink.writeUtf8(VCardBuilder.VCARD_END_OF_LINE);
            return;
        L10:
            throw new IllegalStateException("closed");
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
    }

    private class ChunkedSource extends AbstractSource {
        private static final long NO_CHUNK_YET = -1;
        private long bytesRemainingInChunk;
        private boolean hasMoreChunks;
        final /* synthetic */ Http1Codec this$0;
        private final HttpUrl url;

        ChunkedSource(Http1Codec r3, HttpUrl r4) {
            this.this$0 = r3;
            super(r3, null);
            this.bytesRemainingInChunk = -1;
            this.hasMoreChunks = true;
            this.url = r4;
        }

        @Override // okhttp3.internal.http1.Http1Codec.AbstractSource, okio.Source
        public long read(Buffer r8, long r9) throws IOException {
            if (r9 < 0) goto L25;
            if (this.closed == true) goto L23;
            if (this.hasMoreChunks == true) goto L9;
            return -1;
        L9:
            long r5 = this.bytesRemainingInChunk;
            if (r5 != 0) goto L12;
        L13:
            readChunkSize();
            if (this.hasMoreChunks == true) goto L16;
            return -1;
        L16:
            long r10 = super.read(r8, Math.min(r9, this.bytesRemainingInChunk));
            if (r10 == (-1)) goto L20;
            this.bytesRemainingInChunk -= r10;
            return r10;
        L20:
            ProtocolException r11 = new ProtocolException("unexpected end of stream");
            endOfInput(false, r11);
            throw r11;
        L12:
            if (r5 != (-1)) goto L16;
        L23:
            throw new IllegalStateException("closed");
        L25:
            throw new IllegalArgumentException("byteCount < 0: " + r9);
        }

        private void readChunkSize() throws IOException {
            if (this.bytesRemainingInChunk == (-1)) goto L20;
            this.this$0.source.readUtf8LineStrict();
        L20:
            this.bytesRemainingInChunk = this.this$0.source.readHexadecimalUnsignedLong();     // Catch: NumberFormatException -> L17
            String r1 = this.this$0.source.readUtf8LineStrict().trim();     // Catch: NumberFormatException -> L17
            if (this.bytesRemainingInChunk < 0) goto L16;
            if (r1.isEmpty() == true) goto L12;
            if (r1.startsWith(";") == false) goto L16;
        L12:
            if (this.bytesRemainingInChunk != 0) goto L22;
            this.hasMoreChunks = false;
            HttpHeaders.receiveHeaders(this.this$0.client.cookieJar(), this.url, this.this$0.readHeaders());
            endOfInput(true, null);
            return;
        L22:
            return;
        L16:
            throw new ProtocolException("expected chunk size and optional extensions but was \"" + this.bytesRemainingInChunk + r1 + "\"");     // Catch: NumberFormatException -> L17
        L17:
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
    }

    private final class FixedLengthSink implements Sink {
        private long bytesRemaining;
        private boolean closed;
        final /* synthetic */ Http1Codec this$0;
        private final ForwardingTimeout timeout;

        FixedLengthSink(Http1Codec r2, long r3) {
            this.this$0 = r2;
            this.timeout = new ForwardingTimeout(r2.sink.timeout());
            this.bytesRemaining = r3;
        }

        @Override // okio.Sink
        public Timeout timeout() {
            return this.timeout;
        }

        @Override // okio.Sink
        public void write(Buffer r8, long r9) throws IOException {
            if (this.closed == true) goto L11;
            Util.checkOffsetAndCount(r8.size(), 0, r9);
            if (r9 > this.bytesRemaining) goto L9;
            this.this$0.sink.write(r8, r9);
            this.bytesRemaining -= r9;
            return;
        L9:
            throw new ProtocolException("expected " + this.bytesRemaining + " bytes but received " + r9);
        L11:
            throw new IllegalStateException("closed");
        }

        @Override // okio.Sink, java.io.Flushable
        public void flush() throws IOException {
            if (this.closed == false) goto L5;
            return;
        L5:
            this.this$0.sink.flush();
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
    }

    private class FixedLengthSource extends AbstractSource {
        private long bytesRemaining;
        final /* synthetic */ Http1Codec this$0;

        FixedLengthSource(Http1Codec r4, long r5) throws IOException {
            this.this$0 = r4;
            super(r4, null);
            this.bytesRemaining = r5;
            if (r5 != 0) goto L6;
            endOfInput(true, null);
            return;
        }

        @Override // okhttp3.internal.http1.Http1Codec.AbstractSource, okio.Source
        public long read(Buffer r8, long r9) throws IOException {
            if (r9 < 0) goto L20;
            if (this.closed == true) goto L18;
            long r2 = this.bytesRemaining;
            if (r2 != 0) goto L9;
            return -1;
        L9:
            long r10 = super.read(r8, Math.min(r2, r9));
            if (r10 == (-1)) goto L15;
            long r3 = this.bytesRemaining - r10;
            this.bytesRemaining = r3;
            if (r3 != 0) goto L14;
            endOfInput(true, null);
        L14:
            return r10;
        L15:
            ProtocolException r11 = new ProtocolException("unexpected end of stream");
            endOfInput(false, r11);
            throw r11;
        L18:
            throw new IllegalStateException("closed");
        L20:
            throw new IllegalArgumentException("byteCount < 0: " + r9);
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
    }

    private class UnknownLengthSource extends AbstractSource {
        private boolean inputExhausted;
        final /* synthetic */ Http1Codec this$0;

        UnknownLengthSource(Http1Codec r2) {
            this.this$0 = r2;
            super(r2, null);
        }

        @Override // okhttp3.internal.http1.Http1Codec.AbstractSource, okio.Source
        public long read(Buffer r4, long r5) throws IOException {
            if (r5 < 0) goto L17;
            if (this.closed == true) goto L15;
            if (this.inputExhausted == false) goto L9;
            return -1;
        L9:
            long r6 = super.read(r4, r5);
            if (r6 != (-1)) goto L13;
            this.inputExhausted = true;
            endOfInput(true, null);
            return -1;
        L13:
            return r6;
        L15:
            throw new IllegalStateException("closed");
        L17:
            throw new IllegalArgumentException("byteCount < 0: " + r5);
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
    }

    public Http1Codec(OkHttpClient r3, StreamAllocation r4, BufferedSource r5, BufferedSink r6) {
        this.state = 0;
        this.headerLimit = PlaybackStateCompat.ACTION_SET_REPEAT_MODE;
        this.client = r3;
        this.streamAllocation = r4;
        this.source = r5;
        this.sink = r6;
    }

    @Override // okhttp3.internal.http.HttpCodec
    public Sink createRequestBody(Request r3, long r4) {
        if (HTTP.CHUNK_CODING.equalsIgnoreCase(r3.header("Transfer-Encoding")) == false) goto L7;
        return newChunkedSink();
    L7:
        if (r4 == (-1)) goto L11;
        return newFixedLengthSink(r4);
    L11:
        throw new IllegalStateException("Cannot stream a request body without chunked encoding or a known content length!");
    }

    @Override // okhttp3.internal.http.HttpCodec
    public void cancel() {
        RealConnection r0 = this.streamAllocation.connection();
        if (r0 == null) goto L6;
        r0.cancel();
        return;
    }

    @Override // okhttp3.internal.http.HttpCodec
    public void writeRequestHeaders(Request r2) throws IOException {
        String r0 = RequestLine.get(r2, this.streamAllocation.connection().route().proxy().type());
        writeRequest(r2.headers(), r0);
    }

    @Override // okhttp3.internal.http.HttpCodec
    public ResponseBody openResponseBody(Response r7) throws IOException {
        this.streamAllocation.eventListener.responseBodyStart(this.streamAllocation.call);
        String r0 = r7.header("Content-Type");
        if (HttpHeaders.hasBody(r7) == true) goto L7;
        return new RealResponseBody(r0, 0, Okio.buffer(newFixedLengthSource(0)));
    L7:
        if (HTTP.CHUNK_CODING.equalsIgnoreCase(r7.header("Transfer-Encoding")) == true) goto L9;
        long r4 = HttpHeaders.contentLength(r7);
        if (r4 == (-1)) goto L15;
        return new RealResponseBody(r0, r4, Okio.buffer(newFixedLengthSource(r4)));
    L15:
        return new RealResponseBody(r0, -1, Okio.buffer(newUnknownLengthSource()));
    L9:
        return new RealResponseBody(r0, -1, Okio.buffer(newChunkedSource(r7.request().url())));
    }

    public boolean isClosed() {
        if (this.state != 6) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // okhttp3.internal.http.HttpCodec
    public void flushRequest() throws IOException {
        this.sink.flush();
    }

    @Override // okhttp3.internal.http.HttpCodec
    public void finishRequest() throws IOException {
        this.sink.flush();
    }

    public void writeRequest(Headers r5, String r6) throws IOException {
        if (this.state != 0) goto L10;
        this.sink.writeUtf8(r6).writeUtf8(VCardBuilder.VCARD_END_OF_LINE);
        int r7 = r5.size();
        int r1 = 0;
    L5:
        if (r1 >= r7) goto L7;
        this.sink.writeUtf8(r5.name(r1)).writeUtf8(": ").writeUtf8(r5.value(r1)).writeUtf8(VCardBuilder.VCARD_END_OF_LINE);
        r1 = r1 + 1;
        goto L5
    L7:
        this.sink.writeUtf8(VCardBuilder.VCARD_END_OF_LINE);
        this.state = 1;
        return;
    L10:
        throw new IllegalStateException("state: " + this.state);
    }

    @Override // okhttp3.internal.http.HttpCodec
    public Response.Builder readResponseHeaders(boolean r5) throws IOException {
        int r0 = this.state;
        if (r0 == 1) goto L23;
        if (r0 == 3) goto L23;
        throw new IllegalStateException("state: " + this.state);
    L23:
        StatusLine r1 = StatusLine.parse(readHeaderLine());     // Catch: EOFException -> L20
        Response.Builder r2 = new Response.Builder().protocol(r1.protocol).code(r1.code).message(r1.message).headers(readHeaders());     // Catch: EOFException -> L20
        if (r5 == false) goto L15;
        if (r1.code != 100) goto L15;
        return null;
    L15:
        if (r1.code != 100) goto L18;
        this.state = 3;     // Catch: EOFException -> L20
        return r2;
    L18:
        this.state = 4;     // Catch: EOFException -> L20
        return r2;
    L20:
        e = move-exception;
        IOException r3 = new IOException("unexpected end of stream on " + this.streamAllocation);
        r3.initCause(e);
        throw r3;
    }

    private String readHeaderLine() throws IOException {
        String r0 = this.source.readUtf8LineStrict(this.headerLimit);
        this.headerLimit -= (long) r0.length();
        return r0;
    }

    public Headers readHeaders() throws IOException {
        Headers.Builder r0 = new Headers.Builder();
    L3:
        String r1 = readHeaderLine();
        if (r1.length() == 0) goto L7;
        Internal.instance.addLenient(r0, r1);
        goto L3
    L7:
        return r0.build();
    }

    public Sink newChunkedSink() {
        if (this.state != 1) goto L7;
        this.state = 2;
        return new ChunkedSink(this);
    L7:
        throw new IllegalStateException("state: " + this.state);
    }

    public Sink newFixedLengthSink(long r3) {
        if (this.state != 1) goto L7;
        this.state = 2;
        return new FixedLengthSink(this, r3);
    L7:
        throw new IllegalStateException("state: " + this.state);
    }

    public Source newFixedLengthSource(long r3) throws IOException {
        if (this.state != 4) goto L7;
        this.state = 5;
        return new FixedLengthSource(this, r3);
    L7:
        throw new IllegalStateException("state: " + this.state);
    }

    public Source newChunkedSource(HttpUrl r3) throws IOException {
        if (this.state != 4) goto L7;
        this.state = 5;
        return new ChunkedSource(this, r3);
    L7:
        throw new IllegalStateException("state: " + this.state);
    }

    public Source newUnknownLengthSource() throws IOException {
        if (this.state != 4) goto L11;
        StreamAllocation r0 = this.streamAllocation;
        if (r0 == null) goto L9;
        this.state = 5;
        r0.noNewStreams();
        return new UnknownLengthSource(this);
    L9:
        throw new IllegalStateException("streamAllocation == null");
    L11:
        throw new IllegalStateException("state: " + this.state);
    }

    void detachTimeout(ForwardingTimeout r2) {
        Timeout r1 = r2.delegate();
        r2.setDelegate(Timeout.NONE);
        r1.clearDeadline();
        r1.clearTimeout();
    }
}
