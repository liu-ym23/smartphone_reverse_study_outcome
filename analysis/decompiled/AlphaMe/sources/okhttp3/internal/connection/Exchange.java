package okhttp3.internal.connection;

import androidx.exifinterface.media.ExifInterface;
import f1.AbstractC0557a;
import h3.B;
import h3.H;
import h3.V;
import h3.Z;
import h3.a0;
import h3.b0;
import h3.f0;
import java.io.IOException;
import java.net.ProtocolException;
import java.net.SocketException;
import k3.C0694i;
import k3.InterfaceC0680B;
import k3.n;
import k3.o;
import k3.z;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.http.ExchangeCodec;
import okhttp3.internal.http.RealResponseBody;
import okhttp3.internal.ws.RealWebSocket;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001:\u0002STB'\u0012\u0006\u00102\u001a\u000201\u0012\u0006\u00107\u001a\u000206\u0012\u0006\u0010<\u001a\u00020;\u0012\u0006\u0010A\u001a\u00020@¢\u0006\u0004\bQ\u0010RJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\u000e\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u000e\u0010\u000fJ\r\u0010\u0010\u001a\u00020\u0004¢\u0006\u0004\b\u0010\u0010\u0011J\r\u0010\u0012\u001a\u00020\u0004¢\u0006\u0004\b\u0012\u0010\u0011J\r\u0010\u0013\u001a\u00020\u0004¢\u0006\u0004\b\u0013\u0010\u0011J\u0017\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0014\u001a\u00020\u000b¢\u0006\u0004\b\u0016\u0010\u0017J\u0015\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u001a\u0010\u001bJ\u0015\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u001d\u0010\u001eJ\r\u0010 \u001a\u00020\u001f¢\u0006\u0004\b \u0010!J\r\u0010#\u001a\u00020\"¢\u0006\u0004\b#\u0010$J\r\u0010%\u001a\u00020\u0004¢\u0006\u0004\b%\u0010\u0011J\r\u0010&\u001a\u00020\u0004¢\u0006\u0004\b&\u0010\u0011J\r\u0010'\u001a\u00020\u0004¢\u0006\u0004\b'\u0010\u0011J\r\u0010(\u001a\u00020\u0004¢\u0006\u0004\b(\u0010\u0011J9\u0010.\u001a\u00028\u0000\"\n\b\u0000\u0010)*\u0004\u0018\u00010\u00022\u0006\u0010+\u001a\u00020*2\u0006\u0010,\u001a\u00020\u000b2\u0006\u0010-\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00028\u0000¢\u0006\u0004\b.\u0010/J\r\u00100\u001a\u00020\u0004¢\u0006\u0004\b0\u0010\u0011R\u001a\u00102\u001a\u0002018\u0000X\u0080\u0004¢\u0006\f\n\u0004\b2\u00103\u001a\u0004\b4\u00105R\u001a\u00107\u001a\u0002068\u0000X\u0080\u0004¢\u0006\f\n\u0004\b7\u00108\u001a\u0004\b9\u0010:R\u001a\u0010<\u001a\u00020;8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?R\u0014\u0010A\u001a\u00020@8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bA\u0010BR$\u0010D\u001a\u00020\u000b2\u0006\u0010C\u001a\u00020\u000b8\u0000@BX\u0080\u000e¢\u0006\f\n\u0004\bD\u0010E\u001a\u0004\bF\u0010GR$\u0010H\u001a\u00020\u000b2\u0006\u0010C\u001a\u00020\u000b8\u0000@BX\u0080\u000e¢\u0006\f\n\u0004\bH\u0010E\u001a\u0004\bI\u0010GR\u001a\u0010K\u001a\u00020J8\u0000X\u0080\u0004¢\u0006\f\n\u0004\bK\u0010L\u001a\u0004\bM\u0010NR\u0014\u0010P\u001a\u00020\u000b8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bO\u0010G¨\u0006U"}, d2 = {"Lokhttp3/internal/connection/Exchange;", "", "Ljava/io/IOException;", "e", "", "trackFailure", "(Ljava/io/IOException;)V", "Lh3/V;", "request", "writeRequestHeaders", "(Lh3/V;)V", "", "duplex", "Lk3/z;", "createRequestBody", "(Lh3/V;Z)Lk3/z;", "flushRequest", "()V", "finishRequest", "responseHeadersStart", "expectContinue", "Lh3/a0;", "readResponseHeaders", "(Z)Lh3/a0;", "Lh3/b0;", "response", "responseHeadersEnd", "(Lh3/b0;)V", "Lh3/f0;", "openResponseBody", "(Lh3/b0;)Lh3/f0;", "Lh3/H;", "trailers", "()Lh3/H;", "Lokhttp3/internal/ws/RealWebSocket$Streams;", "newWebSocketStreams", "()Lokhttp3/internal/ws/RealWebSocket$Streams;", "webSocketUpgradeFailed", "noNewExchangesOnConnection", "cancel", "detachWithViolence", ExifInterface.LONGITUDE_EAST, "", "bytesRead", "responseDone", "requestDone", "bodyComplete", "(JZZLjava/io/IOException;)Ljava/io/IOException;", "noRequestBody", "Lokhttp3/internal/connection/RealCall;", "call", "Lokhttp3/internal/connection/RealCall;", "getCall$okhttp", "()Lokhttp3/internal/connection/RealCall;", "Lh3/B;", "eventListener", "Lh3/B;", "getEventListener$okhttp", "()Lh3/B;", "Lokhttp3/internal/connection/ExchangeFinder;", "finder", "Lokhttp3/internal/connection/ExchangeFinder;", "getFinder$okhttp", "()Lokhttp3/internal/connection/ExchangeFinder;", "Lokhttp3/internal/http/ExchangeCodec;", "codec", "Lokhttp3/internal/http/ExchangeCodec;", "<set-?>", "isDuplex", "Z", "isDuplex$okhttp", "()Z", "hasFailure", "getHasFailure$okhttp", "Lokhttp3/internal/connection/RealConnection;", "connection", "Lokhttp3/internal/connection/RealConnection;", "getConnection$okhttp", "()Lokhttp3/internal/connection/RealConnection;", "isCoalescedConnection$okhttp", "isCoalescedConnection", "<init>", "(Lokhttp3/internal/connection/RealCall;Lh3/B;Lokhttp3/internal/connection/ExchangeFinder;Lokhttp3/internal/http/ExchangeCodec;)V", "RequestBodySink", "ResponseBodySource", "okhttp"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes2.dex */
public final class Exchange {

    @NotNull
    private final RealCall call;

    @NotNull
    private final ExchangeCodec codec;

    @NotNull
    private final RealConnection connection;

    @NotNull
    private final B eventListener;

    @NotNull
    private final ExchangeFinder finder;
    private boolean hasFailure;
    private boolean isDuplex;

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\u0006\u0010\u0011\u001a\u00020\t¢\u0006\u0004\b\u001a\u0010\u001bJ#\u0010\u0005\u001a\u00028\u0000\"\n\b\u0000\u0010\u0003*\u0004\u0018\u00010\u00022\u0006\u0010\u0004\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0010\u0010\u000fR\u0014\u0010\u0011\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0014\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0016\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0015¨\u0006\u001c"}, d2 = {"Lokhttp3/internal/connection/Exchange$RequestBodySink;", "Lk3/n;", "Ljava/io/IOException;", ExifInterface.LONGITUDE_EAST, "e", "complete", "(Ljava/io/IOException;)Ljava/io/IOException;", "Lk3/i;", "source", "", "byteCount", "", "write", "(Lk3/i;J)V", "flush", "()V", "close", "contentLength", "J", "", "completed", "Z", "bytesReceived", "closed", "Lk3/z;", "delegate", "<init>", "(Lokhttp3/internal/connection/Exchange;Lk3/z;J)V", "okhttp"}, k = 1, mv = {1, 6, 0})
    public final class RequestBodySink extends n {
        private long bytesReceived;
        private boolean closed;
        private boolean completed;
        private final long contentLength;
        final /* synthetic */ Exchange this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RequestBodySink(@NotNull Exchange this$0, z delegate, long j4) {
            super(delegate);
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(delegate, "delegate");
            this.this$0 = this$0;
            this.contentLength = j4;
        }

        private final <E extends IOException> E complete(E e4) {
            if (this.completed) {
                return e4;
            }
            this.completed = true;
            return (E) this.this$0.bodyComplete(this.bytesReceived, false, true, e4);
        }

        @Override // k3.n, k3.z, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.closed) {
                return;
            }
            this.closed = true;
            long j4 = this.contentLength;
            if (j4 != -1 && this.bytesReceived != j4) {
                throw new ProtocolException("unexpected end of stream");
            }
            try {
                super.close();
                complete(null);
            } catch (IOException e4) {
                throw complete(e4);
            }
        }

        @Override // k3.n, k3.z, java.io.Flushable
        public void flush() throws IOException {
            try {
                super.flush();
            } catch (IOException e4) {
                throw complete(e4);
            }
        }

        @Override // k3.n, k3.z
        public void write(@NotNull C0694i source, long byteCount) throws IOException {
            Intrinsics.checkNotNullParameter(source, "source");
            if (!(!this.closed)) {
                throw new IllegalStateException("closed".toString());
            }
            long j4 = this.contentLength;
            if (j4 == -1 || this.bytesReceived + byteCount <= j4) {
                try {
                    super.write(source, byteCount);
                    this.bytesReceived += byteCount;
                    return;
                } catch (IOException e4) {
                    throw complete(e4);
                }
            }
            throw new ProtocolException("expected " + this.contentLength + " bytes but received " + (this.bytesReceived + byteCount));
        }
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0080\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\u0006\u0010\u0010\u001a\u00020\u0004¢\u0006\u0004\b\u001a\u0010\u001bJ\u001f\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ!\u0010\u000e\u001a\u00028\u0000\"\n\b\u0000\u0010\f*\u0004\u0018\u00010\u000b2\u0006\u0010\r\u001a\u00028\u0000¢\u0006\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0012\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0011R\u0016\u0010\u0014\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0015R\u0016\u0010\u0017\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0015¨\u0006\u001c"}, d2 = {"Lokhttp3/internal/connection/Exchange$ResponseBodySource;", "Lk3/o;", "Lk3/i;", "sink", "", "byteCount", "read", "(Lk3/i;J)J", "", "close", "()V", "Ljava/io/IOException;", ExifInterface.LONGITUDE_EAST, "e", "complete", "(Ljava/io/IOException;)Ljava/io/IOException;", "contentLength", "J", "bytesReceived", "", "invokeStartEvent", "Z", "completed", "closed", "Lk3/B;", "delegate", "<init>", "(Lokhttp3/internal/connection/Exchange;Lk3/B;J)V", "okhttp"}, k = 1, mv = {1, 6, 0})
    public final class ResponseBodySource extends o {
        private long bytesReceived;
        private boolean closed;
        private boolean completed;
        private final long contentLength;
        private boolean invokeStartEvent;
        final /* synthetic */ Exchange this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ResponseBodySource(@NotNull Exchange this$0, InterfaceC0680B delegate, long j4) {
            super(delegate);
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(delegate, "delegate");
            this.this$0 = this$0;
            this.contentLength = j4;
            this.invokeStartEvent = true;
            if (j4 == 0) {
                complete(null);
            }
        }

        @Override // k3.o, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.closed) {
                return;
            }
            this.closed = true;
            try {
                super.close();
                complete(null);
            } catch (IOException e4) {
                throw complete(e4);
            }
        }

        public final <E extends IOException> E complete(E e4) {
            if (this.completed) {
                return e4;
            }
            this.completed = true;
            if (e4 == null && this.invokeStartEvent) {
                this.invokeStartEvent = false;
                B eventListener = this.this$0.getEventListener();
                RealCall call = this.this$0.getCall();
                eventListener.getClass();
                Intrinsics.checkNotNullParameter(call, "call");
            }
            return (E) this.this$0.bodyComplete(this.bytesReceived, true, false, e4);
        }

        @Override // k3.o, k3.InterfaceC0680B
        public long read(@NotNull C0694i sink, long byteCount) throws IOException {
            Intrinsics.checkNotNullParameter(sink, "sink");
            if (!(!this.closed)) {
                throw new IllegalStateException("closed".toString());
            }
            try {
                long j4 = delegate().read(sink, byteCount);
                if (this.invokeStartEvent) {
                    this.invokeStartEvent = false;
                    B eventListener = this.this$0.getEventListener();
                    RealCall call = this.this$0.getCall();
                    eventListener.getClass();
                    Intrinsics.checkNotNullParameter(call, "call");
                }
                if (j4 == -1) {
                    complete(null);
                    return -1L;
                }
                long j5 = this.bytesReceived + j4;
                long j6 = this.contentLength;
                if (j6 != -1 && j5 > j6) {
                    throw new ProtocolException("expected " + this.contentLength + " bytes but received " + j5);
                }
                this.bytesReceived = j5;
                if (j5 == j6) {
                    complete(null);
                }
                return j4;
            } catch (IOException e4) {
                throw complete(e4);
            }
        }
    }

    public Exchange(@NotNull RealCall call, @NotNull B eventListener, @NotNull ExchangeFinder finder, @NotNull ExchangeCodec codec) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(eventListener, "eventListener");
        Intrinsics.checkNotNullParameter(finder, "finder");
        Intrinsics.checkNotNullParameter(codec, "codec");
        this.call = call;
        this.eventListener = eventListener;
        this.finder = finder;
        this.codec = codec;
        this.connection = codec.getConnection();
    }

    private final void trackFailure(IOException e4) {
        this.hasFailure = true;
        this.finder.trackFailure(e4);
        this.codec.getConnection().trackFailure$okhttp(this.call, e4);
    }

    public final <E extends IOException> E bodyComplete(long bytesRead, boolean responseDone, boolean requestDone, E e4) {
        if (e4 != null) {
            trackFailure(e4);
        }
        if (requestDone) {
            if (e4 != null) {
                B b4 = this.eventListener;
                RealCall call = this.call;
                b4.getClass();
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(e4, "ioe");
            } else {
                B b5 = this.eventListener;
                RealCall call2 = this.call;
                b5.getClass();
                Intrinsics.checkNotNullParameter(call2, "call");
            }
        }
        if (responseDone) {
            if (e4 != null) {
                B b6 = this.eventListener;
                RealCall call3 = this.call;
                b6.getClass();
                Intrinsics.checkNotNullParameter(call3, "call");
                Intrinsics.checkNotNullParameter(e4, "ioe");
            } else {
                B b7 = this.eventListener;
                RealCall call4 = this.call;
                b7.getClass();
                Intrinsics.checkNotNullParameter(call4, "call");
            }
        }
        return (E) this.call.messageDone$okhttp(this, requestDone, responseDone, e4);
    }

    public final void cancel() {
        this.codec.cancel();
    }

    @NotNull
    public final z createRequestBody(@NotNull V request, boolean duplex) throws IOException {
        Intrinsics.checkNotNullParameter(request, "request");
        this.isDuplex = duplex;
        Z z4 = request.f12829d;
        Intrinsics.checkNotNull(z4);
        long jContentLength = z4.contentLength();
        B b4 = this.eventListener;
        RealCall call = this.call;
        b4.getClass();
        Intrinsics.checkNotNullParameter(call, "call");
        return new RequestBodySink(this, this.codec.createRequestBody(request, jContentLength), jContentLength);
    }

    public final void detachWithViolence() {
        this.codec.cancel();
        this.call.messageDone$okhttp(this, true, true, null);
    }

    public final void finishRequest() throws IOException {
        try {
            this.codec.finishRequest();
        } catch (IOException ioe) {
            B b4 = this.eventListener;
            RealCall call = this.call;
            b4.getClass();
            Intrinsics.checkNotNullParameter(call, "call");
            Intrinsics.checkNotNullParameter(ioe, "ioe");
            trackFailure(ioe);
            throw ioe;
        }
    }

    public final void flushRequest() throws IOException {
        try {
            this.codec.flushRequest();
        } catch (IOException ioe) {
            B b4 = this.eventListener;
            RealCall call = this.call;
            b4.getClass();
            Intrinsics.checkNotNullParameter(call, "call");
            Intrinsics.checkNotNullParameter(ioe, "ioe");
            trackFailure(ioe);
            throw ioe;
        }
    }

    @NotNull
    /* renamed from: getCall$okhttp, reason: from getter */
    public final RealCall getCall() {
        return this.call;
    }

    @NotNull
    /* renamed from: getConnection$okhttp, reason: from getter */
    public final RealConnection getConnection() {
        return this.connection;
    }

    @NotNull
    /* renamed from: getEventListener$okhttp, reason: from getter */
    public final B getEventListener() {
        return this.eventListener;
    }

    @NotNull
    /* renamed from: getFinder$okhttp, reason: from getter */
    public final ExchangeFinder getFinder() {
        return this.finder;
    }

    /* renamed from: getHasFailure$okhttp, reason: from getter */
    public final boolean getHasFailure() {
        return this.hasFailure;
    }

    public final boolean isCoalescedConnection$okhttp() {
        return !Intrinsics.areEqual(this.finder.getAddress().f12847i.f12725d, this.connection.getRoute().f12909a.f12847i.f12725d);
    }

    /* renamed from: isDuplex$okhttp, reason: from getter */
    public final boolean getIsDuplex() {
        return this.isDuplex;
    }

    @NotNull
    public final RealWebSocket.Streams newWebSocketStreams() throws SocketException {
        this.call.timeoutEarlyExit();
        return this.codec.getConnection().newWebSocketStreams$okhttp(this);
    }

    public final void noNewExchangesOnConnection() {
        this.codec.getConnection().noNewExchanges$okhttp();
    }

    public final void noRequestBody() {
        this.call.messageDone$okhttp(this, true, false, null);
    }

    @NotNull
    public final f0 openResponseBody(@NotNull b0 response) throws IOException {
        Intrinsics.checkNotNullParameter(response, "response");
        try {
            String strB = b0.b(response, "Content-Type");
            long jReportedContentLength = this.codec.reportedContentLength(response);
            return new RealResponseBody(strB, jReportedContentLength, AbstractC0557a.h(new ResponseBodySource(this, this.codec.openResponseBodySource(response), jReportedContentLength)));
        } catch (IOException ioe) {
            B b4 = this.eventListener;
            RealCall call = this.call;
            b4.getClass();
            Intrinsics.checkNotNullParameter(call, "call");
            Intrinsics.checkNotNullParameter(ioe, "ioe");
            trackFailure(ioe);
            throw ioe;
        }
    }

    @Nullable
    public final a0 readResponseHeaders(boolean expectContinue) throws IOException {
        try {
            a0 responseHeaders = this.codec.readResponseHeaders(expectContinue);
            if (responseHeaders != null) {
                Intrinsics.checkNotNullParameter(this, "deferredTrailers");
                responseHeaders.f12862m = this;
            }
            return responseHeaders;
        } catch (IOException ioe) {
            B b4 = this.eventListener;
            RealCall call = this.call;
            b4.getClass();
            Intrinsics.checkNotNullParameter(call, "call");
            Intrinsics.checkNotNullParameter(ioe, "ioe");
            trackFailure(ioe);
            throw ioe;
        }
    }

    public final void responseHeadersEnd(@NotNull b0 response) {
        Intrinsics.checkNotNullParameter(response, "response");
        B b4 = this.eventListener;
        RealCall call = this.call;
        b4.getClass();
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(response, "response");
    }

    public final void responseHeadersStart() {
        B b4 = this.eventListener;
        RealCall call = this.call;
        b4.getClass();
        Intrinsics.checkNotNullParameter(call, "call");
    }

    @NotNull
    public final H trailers() throws IOException {
        return this.codec.trailers();
    }

    public final void webSocketUpgradeFailed() {
        bodyComplete(-1L, true, true, null);
    }

    public final void writeRequestHeaders(@NotNull V request) throws IOException {
        Intrinsics.checkNotNullParameter(request, "request");
        try {
            B b4 = this.eventListener;
            RealCall call = this.call;
            b4.getClass();
            Intrinsics.checkNotNullParameter(call, "call");
            this.codec.writeRequestHeaders(request);
            B b5 = this.eventListener;
            RealCall call2 = this.call;
            b5.getClass();
            Intrinsics.checkNotNullParameter(call2, "call");
            Intrinsics.checkNotNullParameter(request, "request");
        } catch (IOException ioe) {
            B b6 = this.eventListener;
            RealCall call3 = this.call;
            b6.getClass();
            Intrinsics.checkNotNullParameter(call3, "call");
            Intrinsics.checkNotNullParameter(ioe, "ioe");
            trackFailure(ioe);
            throw ioe;
        }
    }
}
