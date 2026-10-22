package okhttp3.internal.http2;

import com.bytedance.common.wschannel.WsConstants;
import fg.f;
import fg.j;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.Internal;
import okhttp3.internal.Util;
import okhttp3.internal.connection.StreamAllocation;
import okhttp3.internal.http.HttpCodec;
import okhttp3.internal.http.HttpHeaders;
import okhttp3.internal.http.RealResponseBody;
import okhttp3.internal.http.RequestLine;
import okhttp3.internal.http.StatusLine;
import okio.Buffer;
import okio.ByteString;
import okio.Sink;
import okio.Source;
import okio.Timeout;

/* JADX INFO: loaded from: classes4.dex */
public final class Http2Codec implements HttpCodec {
    private static final ByteString CONNECTION = null;
    private static final ByteString ENCODING = null;
    private static final ByteString HOST = null;
    private static final List<ByteString> HTTP_2_SKIPPED_REQUEST_HEADERS = null;
    private static final List<ByteString> HTTP_2_SKIPPED_RESPONSE_HEADERS = null;
    private static final ByteString KEEP_ALIVE = null;
    private static final ByteString PROXY_CONNECTION = null;
    private static final ByteString TE = null;
    private static final ByteString TRANSFER_ENCODING = null;
    private static final ByteString UPGRADE = null;
    private final Interceptor.Chain chain;
    private final OkHttpClient client;
    private final Http2Connection connection;
    private Http2Stream stream;
    final StreamAllocation streamAllocation;

    public class StreamFinishingSource extends f {
        long bytesRead;
        boolean completed;
        final /* synthetic */ Http2Codec this$0;

        public StreamFinishingSource(Http2Codec r10, Source r11) {
            this.this$0 = r10;
            super(r11);
            this.completed = false;
            this.bytesRead = 0;
        }

        private void endOfInput(IOException r10) {
            if (this.completed == false) goto L5;
            return;
        L5:
            this.completed = true;
            Http2Codec r11 = this.this$0;
            r11.streamAllocation.streamFinished(false, r11, this.bytesRead, r10);
        }

        @Override // fg.f, okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            super.close();
            endOfInput(null);
        }

        @Override // fg.f, okio.Source
        public long read(Buffer r10, long r11) throws IOException {
            long r12 = delegate().read(r10, r11);     // Catch: IOException -> L6
            if (r12 <= 0) goto L8;
            this.bytesRead += r12;     // Catch: IOException -> L6
        L8:
            return r12;
        L6:
            e = move-exception;
            endOfInput(e);
            throw e;
        }
    }

    static {
        ByteString r10 = ByteString.encodeUtf8(WsConstants.KEY_CONNECTION);
        CONNECTION = r10;
        ByteString r13 = ByteString.encodeUtf8("host");
        HOST = r13;
        ByteString r14 = ByteString.encodeUtf8("keep-alive");
        KEEP_ALIVE = r14;
        ByteString r15 = ByteString.encodeUtf8("proxy-connection");
        PROXY_CONNECTION = r15;
        ByteString r16 = ByteString.encodeUtf8("transfer-encoding");
        TRANSFER_ENCODING = r16;
        ByteString r17 = ByteString.encodeUtf8("te");
        TE = r17;
        ByteString r18 = ByteString.encodeUtf8("encoding");
        ENCODING = r18;
        ByteString r19 = ByteString.encodeUtf8("upgrade");
        UPGRADE = r19;
        HTTP_2_SKIPPED_REQUEST_HEADERS = Util.immutableList(new ByteString[]{r10, r13, r14, r15, r17, r16, r18, r19, Header.TARGET_METHOD, Header.TARGET_PATH, Header.TARGET_SCHEME, Header.TARGET_AUTHORITY});
        HTTP_2_SKIPPED_RESPONSE_HEADERS = Util.immutableList(new ByteString[]{r10, r13, r14, r15, r17, r16, r18, r19});
    }

    public Http2Codec(OkHttpClient r10, Interceptor.Chain r11, StreamAllocation r12, Http2Connection r13) {
        this.client = r10;
        this.chain = r11;
        this.streamAllocation = r12;
        this.connection = r13;
    }

    public static List<Header> http2HeadersList(Request r10) {
        Headers r11 = r10.e();
        ArrayList r12 = new ArrayList(r11.h() + 4);
        r12.add(new Header(Header.TARGET_METHOD, r10.g()));
        r12.add(new Header(Header.TARGET_PATH, RequestLine.requestPath(r10.k())));
        String r13 = r10.c("Host");
        if (r13 == null) goto L5;
        r12.add(new Header(Header.TARGET_AUTHORITY, r13));
    L5:
        r12.add(new Header(Header.TARGET_SCHEME, r10.k().G()));
        int r14 = r11.h();
        int r15 = 0;
    L6:
        if (r15 >= r14) goto L11;
        ByteString r16 = ByteString.encodeUtf8(r11.d(r15).toLowerCase(Locale.US));
        if (HTTP_2_SKIPPED_REQUEST_HEADERS.contains(r16) == true) goto L10;
        r12.add(new Header(r16, r11.j(r15)));
    L10:
        r15 = r15 + 1;
        goto L6
    L11:
        return r12;
    }

    public static Response.Builder readHttp2HeadersList(List<Header> r10) throws IOException {
        Headers.Builder r11 = new Headers.Builder();
        int r12 = r10.size();
        int r13 = 0;
        StatusLine r14 = null;
    L3:
        if (r13 >= r12) goto L17;
        Header r15 = r10.get(r13);
        if (r15 != null) goto L10;
        if (r14 == null) goto L16;
        if (r14.code != 100) goto L16;
        r11 = new Headers.Builder();
        r14 = null;
    L16:
        r13 = r13 + 1;
        goto L3
    L10:
        ByteString r16 = r15.name;
        String r17 = r15.value.utf8();
        if (r16.equals(Header.RESPONSE_STATUS) == false) goto L14;
        r14 = StatusLine.parse("HTTP/1.1 " + r17);
        goto L16
    L14:
        if (HTTP_2_SKIPPED_RESPONSE_HEADERS.contains(r16) == true) goto L16;
        Internal.instance.addLenient(r11, r16.utf8(), r17);
        goto L16
    L17:
        if (r14 == null) goto L21;
        return new Response.Builder().m(Protocol.HTTP_2).g(r14.code).j(r14.message).i(r11.d());
    L21:
        throw new ProtocolException("Expected ':status' header not present");
    }

    @Override // okhttp3.internal.http.HttpCodec
    public void cancel() {
        Http2Stream r10 = this.stream;
        if (r10 == null) goto L6;
        r10.closeLater(ErrorCode.CANCEL);
        return;
    }

    @Override // okhttp3.internal.http.HttpCodec
    public Sink createRequestBody(Request r10, long r11) {
        return this.stream.getSink();
    }

    @Override // okhttp3.internal.http.HttpCodec
    public void finishRequest() throws IOException {
        this.stream.getSink().close();
    }

    @Override // okhttp3.internal.http.HttpCodec
    public void flushRequest() throws IOException {
        this.connection.flush();
    }

    @Override // okhttp3.internal.http.HttpCodec
    public ResponseBody openResponseBody(Response r10) throws IOException {
        StreamAllocation r11 = this.streamAllocation;
        r11.eventListener.responseBodyStart(r11.call);
        return new RealResponseBody(r10.f("Content-Type"), HttpHeaders.contentLength(r10), j.d(new StreamFinishingSource(this, this.stream.getSource())));
    }

    @Override // okhttp3.internal.http.HttpCodec
    public Response.Builder readResponseHeaders(boolean r10) throws IOException {
        Response.Builder r11 = readHttp2HeadersList(this.stream.takeResponseHeaders());
        if (r10 == true) goto L5;
        return r11;
    L5:
        if (Internal.instance.code(r11) != 100) goto L9;
        return null;
    L9:
        return r11;
    }

    @Override // okhttp3.internal.http.HttpCodec
    public void writeRequestHeaders(Request r10) throws IOException {
        if (this.stream == null) goto L6;
        return;
    L6:
        if (r10.a() == null) goto L8;
        boolean r11 = true;
    L9:
        Http2Stream r12 = this.connection.newStream(http2HeadersList(r10), r11);
        this.stream = r12;
        Timeout r13 = r12.readTimeout();
        long r14 = this.chain.readTimeoutMillis();
        TimeUnit r15 = TimeUnit.MILLISECONDS;
        r13.timeout(r14, r15);
        this.stream.writeTimeout().timeout(this.chain.writeTimeoutMillis(), r15);
        return;
    L8:
        r11 = false;
        goto L9
    }
}
