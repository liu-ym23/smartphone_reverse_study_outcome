package okhttp3.internal.http1;

import com.baidu.mapapi.http.HttpClient;
import com.baidu.platform.comapi.map.MapBundleKey;
import h3.H;
import h3.InterfaceC0613w;
import h3.J;
import h3.S;
import h3.T;
import h3.V;
import h3.Z;
import h3.a0;
import h3.b0;
import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.util.concurrent.TimeUnit;
import k3.C0683E;
import k3.C0694i;
import k3.InterfaceC0680B;
import k3.InterfaceC0695j;
import k3.InterfaceC0696k;
import k3.p;
import k3.z;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__StringsJVMKt;
import okhttp3.internal.Util;
import okhttp3.internal.connection.RealConnection;
import okhttp3.internal.http.ExchangeCodec;
import okhttp3.internal.http.HttpHeaders;
import okhttp3.internal.http.RequestLine;
import okhttp3.internal.http.StatusLine;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u0000 R2\u00020\u0001:\u0007STURVWXB)\u0012\b\u00107\u001a\u0004\u0018\u000106\u0012\u0006\u0010:\u001a\u000209\u0012\u0006\u0010?\u001a\u00020>\u0012\u0006\u0010B\u001a\u00020A¢\u0006\u0004\bP\u0010QJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\f\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0018\u0010\u000bJ\u000f\u0010\u0019\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0019\u0010\u000bJ\u001d\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b\u001d\u0010\u001eJ\u0019\u0010\"\u001a\u0004\u0018\u00010!2\u0006\u0010 \u001a\u00020\u001fH\u0016¢\u0006\u0004\b\"\u0010#J\u0015\u0010$\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b$\u0010%J\u000f\u0010&\u001a\u00020\u0006H\u0002¢\u0006\u0004\b&\u0010'J\u000f\u0010(\u001a\u00020\u0006H\u0002¢\u0006\u0004\b(\u0010'J\u0017\u0010*\u001a\u00020\u00122\u0006\u0010)\u001a\u00020\u0004H\u0002¢\u0006\u0004\b*\u0010+J\u0017\u0010.\u001a\u00020\u00122\u0006\u0010-\u001a\u00020,H\u0002¢\u0006\u0004\b.\u0010/J\u000f\u00100\u001a\u00020\u0012H\u0002¢\u0006\u0004\b0\u00101J\u0017\u00104\u001a\u00020\t2\u0006\u00103\u001a\u000202H\u0002¢\u0006\u0004\b4\u00105R\u0016\u00107\u001a\u0004\u0018\u0001068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b7\u00108R\u001a\u0010:\u001a\u0002098\u0016X\u0096\u0004¢\u0006\f\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=R\u0014\u0010?\u001a\u00020>8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b?\u0010@R\u0014\u0010B\u001a\u00020A8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bB\u0010CR\u0016\u0010E\u001a\u00020D8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bE\u0010FR\u0014\u0010H\u001a\u00020G8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bH\u0010IR\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010JR\u0011\u0010K\u001a\u00020\u001f8F¢\u0006\u0006\u001a\u0004\bK\u0010LR\u0018\u0010M\u001a\u00020\u001f*\u00020\u000e8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bM\u0010NR\u0018\u0010M\u001a\u00020\u001f*\u00020\u00028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bM\u0010O¨\u0006Y"}, d2 = {"Lokhttp3/internal/http1/Http1ExchangeCodec;", "Lokhttp3/internal/http/ExchangeCodec;", "Lh3/V;", "request", "", "contentLength", "Lk3/z;", "createRequestBody", "(Lh3/V;J)Lk3/z;", "", "cancel", "()V", "writeRequestHeaders", "(Lh3/V;)V", "Lh3/b0;", "response", "reportedContentLength", "(Lh3/b0;)J", "Lk3/B;", "openResponseBodySource", "(Lh3/b0;)Lk3/B;", "Lh3/H;", "trailers", "()Lh3/H;", "flushRequest", "finishRequest", "headers", "", "requestLine", "writeRequest", "(Lh3/H;Ljava/lang/String;)V", "", "expectContinue", "Lh3/a0;", "readResponseHeaders", "(Z)Lh3/a0;", "skipConnectBody", "(Lh3/b0;)V", "newChunkedSink", "()Lk3/z;", "newKnownLengthSink", "length", "newFixedLengthSource", "(J)Lk3/B;", "Lh3/J;", MapBundleKey.MapObjKey.OBJ_URL, "newChunkedSource", "(Lh3/J;)Lk3/B;", "newUnknownLengthSource", "()Lk3/B;", "Lk3/p;", "timeout", "detachTimeout", "(Lk3/p;)V", "Lh3/S;", "client", "Lh3/S;", "Lokhttp3/internal/connection/RealConnection;", "connection", "Lokhttp3/internal/connection/RealConnection;", "getConnection", "()Lokhttp3/internal/connection/RealConnection;", "Lk3/k;", "source", "Lk3/k;", "Lk3/j;", "sink", "Lk3/j;", "", "state", "I", "Lokhttp3/internal/http1/HeadersReader;", "headersReader", "Lokhttp3/internal/http1/HeadersReader;", "Lh3/H;", "isClosed", "()Z", "isChunked", "(Lh3/b0;)Z", "(Lh3/V;)Z", "<init>", "(Lh3/S;Lokhttp3/internal/connection/RealConnection;Lk3/k;Lk3/j;)V", "Companion", "AbstractSource", "ChunkedSink", "ChunkedSource", "FixedLengthSource", "KnownLengthSink", "UnknownLengthSource", "okhttp"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes2.dex */
public final class Http1ExchangeCodec implements ExchangeCodec {
    private static final long NO_CHUNK_YET = -1;
    private static final int STATE_CLOSED = 6;
    private static final int STATE_IDLE = 0;
    private static final int STATE_OPEN_REQUEST_BODY = 1;
    private static final int STATE_OPEN_RESPONSE_BODY = 4;
    private static final int STATE_READING_RESPONSE_BODY = 5;
    private static final int STATE_READ_RESPONSE_HEADERS = 3;
    private static final int STATE_WRITING_REQUEST_BODY = 2;

    @Nullable
    private final S client;

    @NotNull
    private final RealConnection connection;

    @NotNull
    private final HeadersReader headersReader;

    @NotNull
    private final InterfaceC0695j sink;

    @NotNull
    private final InterfaceC0696k source;
    private int state;

    @Nullable
    private H trailers;

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b¢\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\t\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\r\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rR\u001a\u0010\u0003\u001a\u00020\u000e8\u0004X\u0084\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\"\u0010\u0013\u001a\u00020\u00128\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006\u001b"}, d2 = {"Lokhttp3/internal/http1/Http1ExchangeCodec$AbstractSource;", "Lk3/B;", "Lk3/E;", "timeout", "()Lk3/E;", "Lk3/i;", "sink", "", "byteCount", "read", "(Lk3/i;J)J", "", "responseBodyComplete", "()V", "Lk3/p;", "Lk3/p;", "getTimeout", "()Lk3/p;", "", "closed", "Z", "getClosed", "()Z", "setClosed", "(Z)V", "<init>", "(Lokhttp3/internal/http1/Http1ExchangeCodec;)V", "okhttp"}, k = 1, mv = {1, 6, 0})
    public abstract class AbstractSource implements InterfaceC0680B {
        private boolean closed;
        final /* synthetic */ Http1ExchangeCodec this$0;

        @NotNull
        private final p timeout;

        public AbstractSource(Http1ExchangeCodec this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this.this$0 = this$0;
            this.timeout = new p(this$0.source.getTimeout());
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public abstract /* synthetic */ void close() throws IOException;

        public final boolean getClosed() {
            return this.closed;
        }

        @NotNull
        public final p getTimeout() {
            return this.timeout;
        }

        @Override // k3.InterfaceC0680B
        public long read(@NotNull C0694i sink, long byteCount) throws IOException {
            Intrinsics.checkNotNullParameter(sink, "sink");
            try {
                return this.this$0.source.read(sink, byteCount);
            } catch (IOException e4) {
                this.this$0.getConnection().noNewExchanges$okhttp();
                this.responseBodyComplete();
                throw e4;
            }
        }

        public final void responseBodyComplete() {
            if (this.this$0.state == 6) {
                return;
            }
            if (this.this$0.state != 5) {
                throw new IllegalStateException(Intrinsics.stringPlus("state: ", Integer.valueOf(this.this$0.state)));
            }
            this.this$0.detachTimeout(this.timeout);
            this.this$0.state = 6;
        }

        public final void setClosed(boolean z4) {
            this.closed = z4;
        }

        @Override // k3.InterfaceC0680B
        @NotNull
        /* renamed from: timeout */
        public C0683E getTimeout() {
            return this.timeout;
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000e\u0010\rR\u0014\u0010\u0003\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0010R\u0016\u0010\u0012\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0016"}, d2 = {"Lokhttp3/internal/http1/Http1ExchangeCodec$ChunkedSink;", "Lk3/z;", "Lk3/E;", "timeout", "()Lk3/E;", "Lk3/i;", "source", "", "byteCount", "", "write", "(Lk3/i;J)V", "flush", "()V", "close", "Lk3/p;", "Lk3/p;", "", "closed", "Z", "<init>", "(Lokhttp3/internal/http1/Http1ExchangeCodec;)V", "okhttp"}, k = 1, mv = {1, 6, 0})
    public final class ChunkedSink implements z {
        private boolean closed;
        final /* synthetic */ Http1ExchangeCodec this$0;

        @NotNull
        private final p timeout;

        public ChunkedSink(Http1ExchangeCodec this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this.this$0 = this$0;
            this.timeout = new p(this$0.sink.timeout());
        }

        @Override // k3.z, java.io.Closeable, java.lang.AutoCloseable
        public synchronized void close() {
            if (this.closed) {
                return;
            }
            this.closed = true;
            this.this$0.sink.G("0\r\n\r\n");
            this.this$0.detachTimeout(this.timeout);
            this.this$0.state = 3;
        }

        @Override // k3.z, java.io.Flushable
        public synchronized void flush() {
            if (this.closed) {
                return;
            }
            this.this$0.sink.flush();
        }

        @Override // k3.z
        @NotNull
        public C0683E timeout() {
            return this.timeout;
        }

        @Override // k3.z
        public void write(@NotNull C0694i source, long byteCount) {
            Intrinsics.checkNotNullParameter(source, "source");
            if (!(!this.closed)) {
                throw new IllegalStateException("closed".toString());
            }
            if (byteCount == 0) {
                return;
            }
            this.this$0.sink.g(byteCount);
            this.this$0.sink.G(HttpClient.NEWLINE);
            this.this$0.sink.write(source, byteCount);
            this.this$0.sink.G(HttpClient.NEWLINE);
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0082\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\n\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\f\u0010\u0005R\u0014\u0010\u000e\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0010\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0013\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0017"}, d2 = {"Lokhttp3/internal/http1/Http1ExchangeCodec$ChunkedSource;", "Lokhttp3/internal/http1/Http1ExchangeCodec$AbstractSource;", "Lokhttp3/internal/http1/Http1ExchangeCodec;", "", "readChunkSize", "()V", "Lk3/i;", "sink", "", "byteCount", "read", "(Lk3/i;J)J", "close", "Lh3/J;", MapBundleKey.MapObjKey.OBJ_URL, "Lh3/J;", "bytesRemainingInChunk", "J", "", "hasMoreChunks", "Z", "<init>", "(Lokhttp3/internal/http1/Http1ExchangeCodec;Lh3/J;)V", "okhttp"}, k = 1, mv = {1, 6, 0})
    public final class ChunkedSource extends AbstractSource {
        private long bytesRemainingInChunk;
        private boolean hasMoreChunks;
        final /* synthetic */ Http1ExchangeCodec this$0;

        @NotNull
        private final J url;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ChunkedSource(@NotNull Http1ExchangeCodec this$0, J url) {
            super(this$0);
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(url, "url");
            this.this$0 = this$0;
            this.url = url;
            this.bytesRemainingInChunk = -1L;
            this.hasMoreChunks = true;
        }

        private final void readChunkSize() throws ProtocolException, NumberFormatException {
            if (this.bytesRemainingInChunk != -1) {
                this.this$0.source.n();
            }
            try {
                this.bytesRemainingInChunk = this.this$0.source.J();
                String string = StringsKt.trim((CharSequence) this.this$0.source.n()).toString();
                if (this.bytesRemainingInChunk < 0 || (string.length() > 0 && !StringsKt.y(string, ";"))) {
                    throw new ProtocolException("expected chunk size and optional extensions but was \"" + this.bytesRemainingInChunk + string + '\"');
                }
                if (this.bytesRemainingInChunk == 0) {
                    this.hasMoreChunks = false;
                    Http1ExchangeCodec http1ExchangeCodec = this.this$0;
                    http1ExchangeCodec.trailers = http1ExchangeCodec.headersReader.readHeaders();
                    S s4 = this.this$0.client;
                    Intrinsics.checkNotNull(s4);
                    InterfaceC0613w interfaceC0613w = s4.f12796j;
                    J j4 = this.url;
                    H h4 = this.this$0.trailers;
                    Intrinsics.checkNotNull(h4);
                    HttpHeaders.receiveHeaders(interfaceC0613w, j4, h4);
                    responseBodyComplete();
                }
            } catch (NumberFormatException e4) {
                throw new ProtocolException(e4.getMessage());
            }
        }

        @Override // okhttp3.internal.http1.Http1ExchangeCodec.AbstractSource, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (getClosed()) {
                return;
            }
            if (this.hasMoreChunks && !Util.discard(this, 100, TimeUnit.MILLISECONDS)) {
                this.this$0.getConnection().noNewExchanges$okhttp();
                responseBodyComplete();
            }
            setClosed(true);
        }

        @Override // okhttp3.internal.http1.Http1ExchangeCodec.AbstractSource, k3.InterfaceC0680B
        public long read(@NotNull C0694i sink, long byteCount) throws IOException, NumberFormatException {
            Intrinsics.checkNotNullParameter(sink, "sink");
            if (byteCount < 0) {
                throw new IllegalArgumentException(Intrinsics.stringPlus("byteCount < 0: ", Long.valueOf(byteCount)).toString());
            }
            if (!(!getClosed())) {
                throw new IllegalStateException("closed".toString());
            }
            if (!this.hasMoreChunks) {
                return -1L;
            }
            long j4 = this.bytesRemainingInChunk;
            if (j4 == 0 || j4 == -1) {
                readChunkSize();
                if (!this.hasMoreChunks) {
                    return -1L;
                }
            }
            long j5 = super.read(sink, Math.min(byteCount, this.bytesRemainingInChunk));
            if (j5 != -1) {
                this.bytesRemainingInChunk -= j5;
                return j5;
            }
            this.this$0.getConnection().noNewExchanges$okhttp();
            ProtocolException protocolException = new ProtocolException("unexpected end of stream");
            responseBodyComplete();
            throw protocolException;
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0082\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\u000f\u0012\u0006\u0010\f\u001a\u00020\u0005¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\f\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0010"}, d2 = {"Lokhttp3/internal/http1/Http1ExchangeCodec$FixedLengthSource;", "Lokhttp3/internal/http1/Http1ExchangeCodec$AbstractSource;", "Lokhttp3/internal/http1/Http1ExchangeCodec;", "Lk3/i;", "sink", "", "byteCount", "read", "(Lk3/i;J)J", "", "close", "()V", "bytesRemaining", "J", "<init>", "(Lokhttp3/internal/http1/Http1ExchangeCodec;J)V", "okhttp"}, k = 1, mv = {1, 6, 0})
    public final class FixedLengthSource extends AbstractSource {
        private long bytesRemaining;
        final /* synthetic */ Http1ExchangeCodec this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public FixedLengthSource(Http1ExchangeCodec this$0, long j4) {
            super(this$0);
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this.this$0 = this$0;
            this.bytesRemaining = j4;
            if (j4 == 0) {
                responseBodyComplete();
            }
        }

        @Override // okhttp3.internal.http1.Http1ExchangeCodec.AbstractSource, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (getClosed()) {
                return;
            }
            if (this.bytesRemaining != 0 && !Util.discard(this, 100, TimeUnit.MILLISECONDS)) {
                this.this$0.getConnection().noNewExchanges$okhttp();
                responseBodyComplete();
            }
            setClosed(true);
        }

        @Override // okhttp3.internal.http1.Http1ExchangeCodec.AbstractSource, k3.InterfaceC0680B
        public long read(@NotNull C0694i sink, long byteCount) throws IOException {
            Intrinsics.checkNotNullParameter(sink, "sink");
            if (byteCount < 0) {
                throw new IllegalArgumentException(Intrinsics.stringPlus("byteCount < 0: ", Long.valueOf(byteCount)).toString());
            }
            if (!(!getClosed())) {
                throw new IllegalStateException("closed".toString());
            }
            long j4 = this.bytesRemaining;
            if (j4 == 0) {
                return -1L;
            }
            long j5 = super.read(sink, Math.min(j4, byteCount));
            if (j5 == -1) {
                this.this$0.getConnection().noNewExchanges$okhttp();
                ProtocolException protocolException = new ProtocolException("unexpected end of stream");
                responseBodyComplete();
                throw protocolException;
            }
            long j6 = this.bytesRemaining - j5;
            this.bytesRemaining = j6;
            if (j6 == 0) {
                responseBodyComplete();
            }
            return j5;
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000e\u0010\rR\u0014\u0010\u0003\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0010R\u0016\u0010\u0012\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0016"}, d2 = {"Lokhttp3/internal/http1/Http1ExchangeCodec$KnownLengthSink;", "Lk3/z;", "Lk3/E;", "timeout", "()Lk3/E;", "Lk3/i;", "source", "", "byteCount", "", "write", "(Lk3/i;J)V", "flush", "()V", "close", "Lk3/p;", "Lk3/p;", "", "closed", "Z", "<init>", "(Lokhttp3/internal/http1/Http1ExchangeCodec;)V", "okhttp"}, k = 1, mv = {1, 6, 0})
    public final class KnownLengthSink implements z {
        private boolean closed;
        final /* synthetic */ Http1ExchangeCodec this$0;

        @NotNull
        private final p timeout;

        public KnownLengthSink(Http1ExchangeCodec this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this.this$0 = this$0;
            this.timeout = new p(this$0.sink.timeout());
        }

        @Override // k3.z, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.closed) {
                return;
            }
            this.closed = true;
            this.this$0.detachTimeout(this.timeout);
            this.this$0.state = 3;
        }

        @Override // k3.z, java.io.Flushable
        public void flush() {
            if (this.closed) {
                return;
            }
            this.this$0.sink.flush();
        }

        @Override // k3.z
        @NotNull
        public C0683E timeout() {
            return this.timeout;
        }

        @Override // k3.z
        public void write(@NotNull C0694i source, long byteCount) {
            Intrinsics.checkNotNullParameter(source, "source");
            if (!(!this.closed)) {
                throw new IllegalStateException("closed".toString());
            }
            Util.checkOffsetAndCount(source.f13357b, 0L, byteCount);
            this.this$0.sink.write(source, byteCount);
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0082\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\r\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lokhttp3/internal/http1/Http1ExchangeCodec$UnknownLengthSource;", "Lokhttp3/internal/http1/Http1ExchangeCodec$AbstractSource;", "Lokhttp3/internal/http1/Http1ExchangeCodec;", "Lk3/i;", "sink", "", "byteCount", "read", "(Lk3/i;J)J", "", "close", "()V", "", "inputExhausted", "Z", "<init>", "(Lokhttp3/internal/http1/Http1ExchangeCodec;)V", "okhttp"}, k = 1, mv = {1, 6, 0})
    public final class UnknownLengthSource extends AbstractSource {
        private boolean inputExhausted;
        final /* synthetic */ Http1ExchangeCodec this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public UnknownLengthSource(Http1ExchangeCodec this$0) {
            super(this$0);
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this.this$0 = this$0;
        }

        @Override // okhttp3.internal.http1.Http1ExchangeCodec.AbstractSource, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (getClosed()) {
                return;
            }
            if (!this.inputExhausted) {
                responseBodyComplete();
            }
            setClosed(true);
        }

        @Override // okhttp3.internal.http1.Http1ExchangeCodec.AbstractSource, k3.InterfaceC0680B
        public long read(@NotNull C0694i sink, long byteCount) throws IOException {
            Intrinsics.checkNotNullParameter(sink, "sink");
            if (byteCount < 0) {
                throw new IllegalArgumentException(Intrinsics.stringPlus("byteCount < 0: ", Long.valueOf(byteCount)).toString());
            }
            if (!(!getClosed())) {
                throw new IllegalStateException("closed".toString());
            }
            if (this.inputExhausted) {
                return -1L;
            }
            long j4 = super.read(sink, byteCount);
            if (j4 != -1) {
                return j4;
            }
            this.inputExhausted = true;
            responseBodyComplete();
            return -1L;
        }
    }

    public Http1ExchangeCodec(@Nullable S s4, @NotNull RealConnection connection, @NotNull InterfaceC0696k source, @NotNull InterfaceC0695j sink) {
        Intrinsics.checkNotNullParameter(connection, "connection");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(sink, "sink");
        this.client = s4;
        this.connection = connection;
        this.source = source;
        this.sink = sink;
        this.headersReader = new HeadersReader(source);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void detachTimeout(p timeout) {
        C0683E c0683e = timeout.f13365a;
        C0683E delegate = C0683E.NONE;
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        timeout.f13365a = delegate;
        c0683e.clearDeadline();
        c0683e.clearTimeout();
    }

    private final boolean isChunked(b0 b0Var) {
        return StringsKt__StringsJVMKt.equals("chunked", b0.b(b0Var, "Transfer-Encoding"), true);
    }

    private final z newChunkedSink() {
        int i4 = this.state;
        if (i4 != 1) {
            throw new IllegalStateException(Intrinsics.stringPlus("state: ", Integer.valueOf(i4)).toString());
        }
        this.state = 2;
        return new ChunkedSink(this);
    }

    private final InterfaceC0680B newChunkedSource(J url) {
        int i4 = this.state;
        if (i4 != 4) {
            throw new IllegalStateException(Intrinsics.stringPlus("state: ", Integer.valueOf(i4)).toString());
        }
        this.state = 5;
        return new ChunkedSource(this, url);
    }

    private final InterfaceC0680B newFixedLengthSource(long length) {
        int i4 = this.state;
        if (i4 != 4) {
            throw new IllegalStateException(Intrinsics.stringPlus("state: ", Integer.valueOf(i4)).toString());
        }
        this.state = 5;
        return new FixedLengthSource(this, length);
    }

    private final z newKnownLengthSink() {
        int i4 = this.state;
        if (i4 != 1) {
            throw new IllegalStateException(Intrinsics.stringPlus("state: ", Integer.valueOf(i4)).toString());
        }
        this.state = 2;
        return new KnownLengthSink(this);
    }

    private final InterfaceC0680B newUnknownLengthSource() {
        int i4 = this.state;
        if (i4 != 4) {
            throw new IllegalStateException(Intrinsics.stringPlus("state: ", Integer.valueOf(i4)).toString());
        }
        this.state = 5;
        getConnection().noNewExchanges$okhttp();
        return new UnknownLengthSource(this);
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public void cancel() {
        getConnection().cancel();
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    @NotNull
    public z createRequestBody(@NotNull V request, long contentLength) throws ProtocolException {
        Intrinsics.checkNotNullParameter(request, "request");
        Z z4 = request.f12829d;
        if (z4 != null && z4.isDuplex()) {
            throw new ProtocolException("Duplex connections are not supported for HTTP/1");
        }
        if (isChunked(request)) {
            return newChunkedSink();
        }
        if (contentLength != -1) {
            return newKnownLengthSink();
        }
        throw new IllegalStateException("Cannot stream a request body without chunked encoding or a known content length!");
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public void finishRequest() {
        this.sink.flush();
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public void flushRequest() {
        this.sink.flush();
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    @NotNull
    public RealConnection getConnection() {
        return this.connection;
    }

    public final boolean isClosed() {
        return this.state == 6;
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    @NotNull
    public InterfaceC0680B openResponseBodySource(@NotNull b0 response) {
        Intrinsics.checkNotNullParameter(response, "response");
        if (!HttpHeaders.promisesBody(response)) {
            return newFixedLengthSource(0L);
        }
        if (isChunked(response)) {
            return newChunkedSource(response.f12864a.f12826a);
        }
        long jHeadersContentLength = Util.headersContentLength(response);
        return jHeadersContentLength != -1 ? newFixedLengthSource(jHeadersContentLength) : newUnknownLengthSource();
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    @Nullable
    public a0 readResponseHeaders(boolean expectContinue) {
        int i4 = this.state;
        if (i4 != 1 && i4 != 2 && i4 != 3) {
            throw new IllegalStateException(Intrinsics.stringPlus("state: ", Integer.valueOf(i4)).toString());
        }
        try {
            StatusLine statusLine = StatusLine.INSTANCE.parse(this.headersReader.readLine());
            a0 a0Var = new a0();
            T protocol = statusLine.protocol;
            Intrinsics.checkNotNullParameter(protocol, "protocol");
            a0Var.f12851b = protocol;
            a0Var.f12852c = statusLine.code;
            String message = statusLine.message;
            Intrinsics.checkNotNullParameter(message, "message");
            a0Var.f12853d = message;
            a0Var.c(this.headersReader.readHeaders());
            if (expectContinue && statusLine.code == 100) {
                return null;
            }
            int i5 = statusLine.code;
            if (i5 == 100) {
                this.state = 3;
                return a0Var;
            }
            if (102 > i5 || i5 >= 200) {
                this.state = 4;
                return a0Var;
            }
            this.state = 3;
            return a0Var;
        } catch (EOFException e4) {
            throw new IOException(Intrinsics.stringPlus("unexpected end of stream on ", getConnection().getRoute().f12909a.f12847i.h()), e4);
        }
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public long reportedContentLength(@NotNull b0 response) {
        Intrinsics.checkNotNullParameter(response, "response");
        if (!HttpHeaders.promisesBody(response)) {
            return 0L;
        }
        if (isChunked(response)) {
            return -1L;
        }
        return Util.headersContentLength(response);
    }

    public final void skipConnectBody(@NotNull b0 response) {
        Intrinsics.checkNotNullParameter(response, "response");
        long jHeadersContentLength = Util.headersContentLength(response);
        if (jHeadersContentLength == -1) {
            return;
        }
        InterfaceC0680B interfaceC0680BNewFixedLengthSource = newFixedLengthSource(jHeadersContentLength);
        Util.skipAll(interfaceC0680BNewFixedLengthSource, Integer.MAX_VALUE, TimeUnit.MILLISECONDS);
        interfaceC0680BNewFixedLengthSource.close();
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    @NotNull
    public H trailers() {
        if (this.state != 6) {
            throw new IllegalStateException("too early; can't read the trailers yet".toString());
        }
        H h4 = this.trailers;
        return h4 == null ? Util.EMPTY_HEADERS : h4;
    }

    public final void writeRequest(@NotNull H headers, @NotNull String requestLine) {
        Intrinsics.checkNotNullParameter(headers, "headers");
        Intrinsics.checkNotNullParameter(requestLine, "requestLine");
        int i4 = this.state;
        if (i4 != 0) {
            throw new IllegalStateException(Intrinsics.stringPlus("state: ", Integer.valueOf(i4)).toString());
        }
        this.sink.G(requestLine).G(HttpClient.NEWLINE);
        int size = headers.size();
        for (int i5 = 0; i5 < size; i5++) {
            this.sink.G(headers.c(i5)).G(": ").G(headers.f(i5)).G(HttpClient.NEWLINE);
        }
        this.sink.G(HttpClient.NEWLINE);
        this.state = 1;
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public void writeRequestHeaders(@NotNull V request) {
        Intrinsics.checkNotNullParameter(request, "request");
        RequestLine requestLine = RequestLine.INSTANCE;
        Proxy.Type type = getConnection().getRoute().f12910b.type();
        Intrinsics.checkNotNullExpressionValue(type, "connection.route().proxy.type()");
        writeRequest(request.f12828c, requestLine.get(request, type));
    }

    private final boolean isChunked(V v4) {
        return StringsKt__StringsJVMKt.equals("chunked", v4.b("Transfer-Encoding"), true);
    }
}
