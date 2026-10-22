package okhttp3.internal.http;

import fg.e;
import fg.j;
import java.io.IOException;
import java.net.ProtocolException;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.Util;
import okhttp3.internal.connection.RealConnection;
import okhttp3.internal.connection.StreamAllocation;
import okio.Buffer;
import okio.BufferedSink;
import okio.Sink;
import org.apache.http.protocol.HTTP;

/* JADX INFO: loaded from: classes4.dex */
public final class CallServerInterceptor implements Interceptor {
    private final boolean forWebSocket;

    public static final class CountingSink extends e {
        long successfulCount;

        public CountingSink(Sink r10) {
            super(r10);
        }

        @Override // fg.e, okio.Sink
        public void write(Buffer r10, long r11) throws IOException {
            super.write(r10, r11);
            this.successfulCount += r11;
        }
    }

    public CallServerInterceptor(boolean r10) {
        this.forWebSocket = r10;
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain r12) throws IOException {
        RealInterceptorChain r13 = (RealInterceptorChain) r12;
        HttpCodec r10 = r13.httpStream();
        StreamAllocation r11 = r13.streamAllocation();
        RealConnection r14 = (RealConnection) r13.connection();
        Request r15 = r13.request();
        long r16 = System.currentTimeMillis();
        r13.eventListener().requestHeadersStart(r13.call());
        r10.writeRequestHeaders(r15);
        r13.eventListener().requestHeadersEnd(r13.call(), r15);
        Response.Builder r17 = null;
        if (HttpMethod.permitsRequestBody(r15.g()) == true) goto L5;
    L14:
        r10.finishRequest();
        if (r17 != null) goto L17;
        r13.eventListener().responseHeadersStart(r13.call());
        r17 = r10.readResponseHeaders(false);
    L17:
        Response r18 = r17.p(r15).h(r11.connection().handshake()).q(r16).n(System.currentTimeMillis()).c();
        int r19 = r18.d();
        if (r19 != 100) goto L20;
        r18 = r10.readResponseHeaders(false).p(r15).h(r11.connection().handshake()).q(r16).n(System.currentTimeMillis()).c();
        r19 = r18.d();
    L20:
        r13.eventListener().responseHeadersEnd(r13.call(), r18);
        if (this.forWebSocket == true) goto L23;
    L25:
        Response r110 = r18.n().b(r10.openResponseBody(r18)).c();
    L27:
        if ("close".equalsIgnoreCase(r110.r().c("Connection")) == false) goto L29;
    L30:
        r11.noNewStreams();
    L32:
        if (r19 == 204) goto L36;
        if (r19 == 205) goto L36;
    L37:
        return r110;
    L36:
        if (r110.a().contentLength() <= 0) goto L37;
        throw new ProtocolException("HTTP " + r19 + " had non-zero Content-Length: " + r110.a().contentLength());
    L29:
        if ("close".equalsIgnoreCase(r110.f("Connection")) == false) goto L32;
    L23:
        if (r19 != 101) goto L25;
        r110 = r18.n().b(Util.EMPTY_RESPONSE).c();
        goto L27
    L5:
        if (r15.a() == null) goto L14;
        if (HTTP.EXPECT_CONTINUE.equalsIgnoreCase(r15.c("Expect")) == false) goto L9;
        r10.flushRequest();
        r13.eventListener().responseHeadersStart(r13.call());
        r17 = r10.readResponseHeaders(true);
    L9:
        if (r17 != null) goto L12;
        r13.eventListener().requestBodyStart(r13.call());
        CountingSink r20 = new CountingSink(r10.createRequestBody(r15, r15.a().a()));
        BufferedSink r21 = j.c(r20);
        r15.a().g(r21);
        r21.close();
        r13.eventListener().requestBodyEnd(r13.call(), r20.successfulCount);
        goto L14
    L12:
        if (r14.isMultiplexed() == true) goto L14;
        r11.noNewStreams();
        goto L14
    }
}
