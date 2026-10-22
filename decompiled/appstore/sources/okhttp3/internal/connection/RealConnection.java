package okhttp3.internal.connection;

import fg.j;
import io.reactivex.annotations.SchedulerSupport;
import java.io.IOException;
import java.lang.ref.Reference;
import java.net.ConnectException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownServiceException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import kotlinx.coroutines.channels.Channel;
import okhttp3.Address;
import okhttp3.Call;
import okhttp3.Connection;
import okhttp3.ConnectionPool;
import okhttp3.ConnectionSpec;
import okhttp3.EventListener;
import okhttp3.Handshake;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Route;
import okhttp3.b;
import okhttp3.internal.Internal;
import okhttp3.internal.Util;
import okhttp3.internal.Version;
import okhttp3.internal.http.HttpCodec;
import okhttp3.internal.http.HttpHeaders;
import okhttp3.internal.http1.Http1Codec;
import okhttp3.internal.http2.ErrorCode;
import okhttp3.internal.http2.Http2Codec;
import okhttp3.internal.http2.Http2Connection;
import okhttp3.internal.http2.Http2Stream;
import okhttp3.internal.platform.Platform;
import okhttp3.internal.tls.OkHostnameVerifier;
import okhttp3.internal.ws.RealWebSocket;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Source;
import okio.Timeout;
import org.apache.http.protocol.HTTP;

/* JADX INFO: loaded from: classes4.dex */
public final class RealConnection extends Http2Connection.Listener implements Connection {
    private static final int MAX_TUNNEL_ATTEMPTS = 21;
    private static final String NPE_THROW_WITH_NULL = "throw with null exception";
    public int allocationLimit;
    public final List<Reference<StreamAllocation>> allocations;
    private final ConnectionPool connectionPool;
    private Handshake handshake;
    private Http2Connection http2Connection;
    public long idleAtNanos;
    public boolean noNewStreams;
    private Protocol protocol;
    private Socket rawSocket;
    private final Route route;
    private BufferedSink sink;
    private Socket socket;
    private BufferedSource source;
    public int successCount;

    public RealConnection(ConnectionPool r10, Route r11) {
        this.allocationLimit = 1;
        this.allocations = new ArrayList();
        this.idleAtNanos = Long.MAX_VALUE;
        this.connectionPool = r10;
        this.route = r11;
    }

    private void connectSocket(int r10, int r11, Call r12, EventListener r13) throws IOException {
        Proxy r14 = this.route.b();     // Catch: Throwable -> L8
        Address r15 = this.route.a();     // Catch: Throwable -> L8
        if (r14.type() != Proxy.Type.DIRECT) goto L5;
    L10:
        Socket r16 = r15.j().createSocket();     // Catch: Throwable -> L8
    L11:
        this.rawSocket = r16;     // Catch: Throwable -> L8
        r13.connectStart(r12, this.route.d(), r14);     // Catch: Throwable -> L8
        this.rawSocket.setSoTimeout(r11);     // Catch: Throwable -> L8
        Platform.get().connectSocket(this.rawSocket, this.route.d(), r10);     // Catch: Throwable -> L8 ConnectException -> L21
    L29:
        this.source = j.d(j.m(this.rawSocket));     // Catch: Throwable -> L8 NullPointerException -> L15
        this.sink = j.c(j.i(this.rawSocket));     // Catch: Throwable -> L8 NullPointerException -> L15
    L31:
        return;
    L15:
        e = move-exception;
        if (NPE_THROW_WITH_NULL.equals(e.getMessage()) == true) goto L20;
        return;
    L20:
        throw new IOException(e);     // Catch: Throwable -> L8
    L21:
        e = move-exception;
        ConnectException r17 = new ConnectException("Failed to connect to " + this.route.d());     // Catch: Throwable -> L8
        r17.initCause(e);     // Catch: Throwable -> L8
        throw r17;     // Catch: Throwable -> L8
    L5:
        if (r14.type() == Proxy.Type.HTTP) goto L10;
        r16 = new Socket(r14);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        throw new IOException(th);
    }

    private void connectTls(ConnectionSpecSelector r10) throws IOException {
        Address r11 = this.route.a();
        SSLSocket r12 = null;
        String r13 = null;
        SSLSocket r14 = (SSLSocket) r11.k().createSocket(this.rawSocket, r11.l().m(), r11.l().z(), true);     // Catch: Throwable -> L29 AssertionError -> L31
        ConnectionSpec r15 = r10.configureSecureSocket(r14);     // Catch: Throwable -> L7 AssertionError -> L9
        if (r15.f() == false) goto L11;
        Platform.get().configureTlsExtensions(r14, r11.l().m(), r11.f());     // Catch: Throwable -> L7 AssertionError -> L9
    L11:
        r14.startHandshake();     // Catch: Throwable -> L7 AssertionError -> L9
        SSLSession r16 = r14.getSession();     // Catch: Throwable -> L7 AssertionError -> L9
        if (isValid(r16) == false) goto L28;
        Handshake r17 = Handshake.b(r16);     // Catch: Throwable -> L7 AssertionError -> L9
        if (r11.e().verify(r11.l().m(), r16) == false) goto L25;
        r11.a().a(r11.l().m(), r17.e());     // Catch: Throwable -> L7 AssertionError -> L9
        if (r15.f() == false) goto L18;
        r13 = Platform.get().getSelectedProtocol(r14);     // Catch: Throwable -> L7 AssertionError -> L9
    L18:
        this.socket = r14;     // Catch: Throwable -> L7 AssertionError -> L9
        this.source = j.d(j.m(r14));     // Catch: Throwable -> L7 AssertionError -> L9
        this.sink = j.c(j.i(this.socket));     // Catch: Throwable -> L7 AssertionError -> L9
        this.handshake = r17;     // Catch: Throwable -> L7 AssertionError -> L9
        if (r13 == null) goto L21;
        Protocol r18 = Protocol.get(r13);     // Catch: Throwable -> L7 AssertionError -> L9
    L22:
        this.protocol = r18;     // Catch: Throwable -> L7 AssertionError -> L9
        Platform.get().afterHandshake(r14);
        return;
    L21:
        r18 = Protocol.HTTP_1_1;     // Catch: Throwable -> L7 AssertionError -> L9
        goto L22
    L25:
        X509Certificate r19 = (X509Certificate) r17.e().get(0);     // Catch: Throwable -> L7 AssertionError -> L9
        throw new SSLPeerUnverifiedException("Hostname " + r11.l().m() + " not verified:\n    certificate: " + b.c(r19) + "\n    DN: " + r19.getSubjectDN().getName() + "\n    subjectAltNames: " + OkHostnameVerifier.allSubjectAltNames(r19));     // Catch: Throwable -> L7 AssertionError -> L9
    L28:
        throw new IOException("a valid ssl session was not established");     // Catch: Throwable -> L7 AssertionError -> L9
    L9:
        e = e;
    L33:
        if (Util.isAndroidGetsocknameError(e) == true) goto L35;
        throw e;     // Catch: Throwable -> L29
    L35:
        throw new IOException(e);     // Catch: Throwable -> L29
    L7:
        th = th;
        r12 = r14;
    L37:
        if (r12 == null) goto L39;
        Platform.get().afterHandshake(r12);
    L39:
        Util.closeQuietly(r12);
        throw th;
    L29:
        th = th;
    L31:
        e = e;
        goto L33
    }

    private void connectTunnel(int r10, int r11, int r12, Call r13, EventListener r14) throws IOException {
        Request r15 = createTunnelRequest();
        HttpUrl r16 = r15.k();
        int r17 = 0;
    L4:
        if (r17 >= 21) goto L9;
        connectSocket(r10, r11, r13, r14);
        r15 = createTunnel(r11, r12, r15, r16);
        if (r15 == null) goto L12;
        Util.closeQuietly(this.rawSocket);
        this.rawSocket = null;
        this.sink = null;
        this.source = null;
        r14.connectEnd(r13, this.route.d(), this.route.b(), null);
        r17 = r17 + 1;
        goto L4
    L12:
        return;
    }

    private Request createTunnel(int r10, int r11, Request r12, HttpUrl r13) throws IOException {
        String r14 = "CONNECT " + Util.hostHeader(r13, true) + " HTTP/1.1";
    L3:
        Http1Codec r15 = new Http1Codec(null, null, this.source, this.sink);
        TimeUnit r16 = TimeUnit.MILLISECONDS;
        this.source.timeout().timeout(r10, r16);
        this.sink.timeout().timeout(r11, r16);
        r15.writeRequest(r12.e(), r14);
        r15.finishRequest();
        Response r17 = r15.readResponseHeaders(false).p(r12).c();
        long r18 = HttpHeaders.contentLength(r17);
        if (r18 != (-1)) goto L6;
        r18 = 0;
    L6:
        Source r19 = r15.newFixedLengthSource(r18);
        Util.skipAll(r19, Channel.UNLIMITED, r16);
        r19.close();
        int r20 = r17.d();
        if (r20 == 200) goto L21;
        if (r20 != 407) goto L19;
        Request r21 = this.route.a().h().authenticate(this.route, r17);
        if (r21 == null) goto L17;
        if ("close".equalsIgnoreCase(r17.f("Connection")) == true) goto L14;
        r12 = r21;
        goto L3
    L14:
        return r21;
    L17:
        throw new IOException("Failed to authenticate with proxy");
    L19:
        throw new IOException("Unexpected response code for CONNECT: " + r17.d());
    L21:
        if (this.source.buffer().exhausted() == false) goto L26;
        if (this.sink.buffer().exhausted() == false) goto L26;
        return null;
    L26:
        throw new IOException("TLS tunnel buffered too many bytes!");
    }

    private Request createTunnelRequest() {
        return new Request.a().k(this.route.a().l()).d("Host", Util.hostHeader(this.route.a().l(), true)).d("Proxy-Connection", HTTP.CONN_KEEP_ALIVE).d("User-Agent", Version.userAgent()).b();
    }

    private void establishProtocol(ConnectionSpecSelector r10, int r11, Call r12, EventListener r13) throws IOException {
        if (this.route.a().k() != null) goto L6;
        this.protocol = Protocol.HTTP_1_1;
        this.socket = this.rawSocket;
        return;
    L6:
        r13.secureConnectStart(r12);
        connectTls(r10);
        r13.secureConnectEnd(r12, this.handshake);
        if (this.protocol != Protocol.HTTP_2) goto L10;
        this.socket.setSoTimeout(0);
        Http2Connection r14 = new Http2Connection.Builder(true).socket(this.socket, this.route.a().l().m(), this.source, this.sink).listener(this).pingIntervalMillis(r11).build();
        this.http2Connection = r14;
        r14.start();
        return;
    }

    private boolean isValid(SSLSession r10) {
        if ("NONE".equals(r10.getProtocol()) == false) goto L5;
    L7:
        return false;
    L5:
        if ("SSL_NULL_WITH_NULL_NULL".equals(r10.getCipherSuite()) == true) goto L7;
        return true;
    }

    public static RealConnection testConnection(ConnectionPool r10, Route r11, Socket r12, long r13) {
        RealConnection r14 = new RealConnection(r10, r11);
        r14.socket = r12;
        r14.idleAtNanos = r13;
        return r14;
    }

    public void cancel() {
        Util.closeQuietly(this.rawSocket);
    }

    public void connect(int r17, int r18, int r19, int r20, boolean r21, Call r22, EventListener r23) {
        if (this.protocol != null) goto L62;
        List r10 = this.route.a().b();
        ConnectionSpecSelector r11 = new ConnectionSpecSelector(r10);
        if (this.route.a().k() == null) goto L7;
    L15:
        RouteException r12 = null;
    L63:
    L23:
        e = e;
    L52:
        Util.closeQuietly(this.socket);
        Util.closeQuietly(this.rawSocket);
        this.socket = null;
        this.rawSocket = null;
        this.source = null;
        this.sink = null;
        this.handshake = null;
        this.protocol = null;
        this.http2Connection = null;
        r23.connectFailed(r22, this.route.d(), this.route.b(), null, e);
        if (r12 != null) goto L55;
        r12 = new RouteException(e);
    L56:
        if (r21 == false) goto L60;
        if (r11.connectionFailed(e) == true) goto L63;
        throw r12;
    L60:
        throw r12;
    L55:
        r12.addConnectException(e);
        goto L56
    L17:
        if (this.route.c() == false) goto L67;
        connectTunnel(r17, r18, r19, r22, r23);     // Catch: IOException -> L23
        if (this.rawSocket == null) goto L31;
    L69:
        establishProtocol(r11, r20, r22, r23);     // Catch: IOException -> L48
        r23.connectEnd(r22, this.route.d(), this.route.b(), this.protocol);     // Catch: IOException -> L48
    L48:
        e = e;
    L31:
        if (this.route.c() == false) goto L38;
        if (this.rawSocket != null) goto L38;
        throw new RouteException(new ProtocolException("Too many tunnel connections attempted: 21"));
    L38:
        if (this.http2Connection == null) goto L47;
        ConnectionPool r13 = this.connectionPool;
        monitor-enter(r13);
        this.allocationLimit = this.http2Connection.maxConcurrentStreams();     // Catch: Throwable -> L44
        monitor-exit(r13);     // Catch: Throwable -> L44
        return;
    L44:
        th = move-exception;
        throw th;
    L47:
        return;
    L67:
        connectSocket(r17, r18, r22, r23);     // Catch: IOException -> L50
    L50:
        e = e;
        goto L52
    L7:
        if (r10.contains(ConnectionSpec.f22683h) == false) goto L14;
        String r14 = this.route.a().l().m();
        if (Platform.get().isCleartextTrafficPermitted(r14) == true) goto L15;
        throw new RouteException(new UnknownServiceException("CLEARTEXT communication to " + r14 + " not permitted by network security policy"));
    L14:
        throw new RouteException(new UnknownServiceException("CLEARTEXT communication not enabled for client"));
    L62:
        throw new IllegalStateException("already connected");
    }

    @Override // okhttp3.Connection
    public Handshake handshake() {
        return this.handshake;
    }

    public boolean isEligible(Address r10, @Nullable Route r11) {
        if (this.allocations.size() < this.allocationLimit) goto L5;
    L35:
        return false;
    L5:
        if (this.noNewStreams == true) goto L35;
        if (Internal.instance.equalsNonHost(this.route.a(), r10) == true) goto L11;
        return false;
    L11:
        if (r10.l().m().equals(route().a().l().m()) == false) goto L14;
        return true;
    L14:
        if (this.http2Connection != null) goto L16;
        return false;
    L16:
        if (r11 != null) goto L18;
        return false;
    L18:
        Proxy.Type r12 = r11.b().type();
        Proxy.Type r13 = Proxy.Type.DIRECT;
        if (r12 == r13) goto L22;
        return false;
    L22:
        if (this.route.b().type() == r13) goto L25;
        return false;
    L25:
        if (this.route.d().equals(r11.d()) == true) goto L28;
        return false;
    L28:
        if (r11.a().e() == OkHostnameVerifier.INSTANCE) goto L31;
        return false;
    L31:
        if (supportsUrl(r10.l()) == true) goto L37;
        return false;
    L37:
        r10.a().a(r10.l().m(), handshake().e());     // Catch: SSLPeerUnverifiedException -> L36
        return true;
    }

    public boolean isHealthy(boolean r10) {
        if (this.socket.isClosed() == false) goto L5;
    L26:
        return false;
    L5:
        if (this.socket.isInputShutdown() == true) goto L26;
        if (this.socket.isOutputShutdown() == true) goto L26;
        Http2Connection r11 = this.http2Connection;
        if (r11 != null) goto L12;
        if (r10 == true) goto L30;
    L25:
        return true;
    L30:
        int r12 = this.socket.getSoTimeout();     // Catch: IOException -> L24 SocketTimeoutException -> L27
        this.socket.setSoTimeout(1);     // Catch: Throwable -> L21
        if (this.source.exhausted() == false) goto L19;
        this.socket.setSoTimeout(r12);     // Catch: IOException -> L24 SocketTimeoutException -> L27
        return false;
    L19:
        this.socket.setSoTimeout(r12);     // Catch: IOException -> L24 SocketTimeoutException -> L27
        return true;
    L21:
        th = move-exception;
        this.socket.setSoTimeout(r12);     // Catch: IOException -> L24 SocketTimeoutException -> L27
        throw th;     // Catch: IOException -> L24 SocketTimeoutException -> L27
    L24:
        return false;
    L12:
        return !r11.isShutdown();
    }

    public boolean isMultiplexed() {
        if (this.http2Connection == null) goto L5;
        return true;
    L5:
        return false;
    }

    public HttpCodec newCodec(OkHttpClient r10, Interceptor.Chain r11, StreamAllocation r12) throws SocketException {
        if (this.http2Connection != null) goto L5;
        this.socket.setSoTimeout(r11.readTimeoutMillis());
        Timeout r13 = this.source.timeout();
        long r14 = r11.readTimeoutMillis();
        TimeUnit r15 = TimeUnit.MILLISECONDS;
        r13.timeout(r14, r15);
        this.sink.timeout().timeout(r11.writeTimeoutMillis(), r15);
        return new Http1Codec(r10, r12, this.source, this.sink);
    L5:
        return new Http2Codec(r10, r11, r12, this.http2Connection);
    }

    public RealWebSocket.Streams newWebSocketStreams(final StreamAllocation r10) {
        final BufferedSource r11 = this.source;
        final BufferedSink r12 = this.sink;
        final boolean r13 = true;
        return new AnonymousClass1(this, r13, r11, r12, r10);
    }

    @Override // okhttp3.internal.http2.Http2Connection.Listener
    public void onSettings(Http2Connection r10) {
        ConnectionPool r11 = this.connectionPool;
        monitor-enter(r11);
        this.allocationLimit = r10.maxConcurrentStreams();     // Catch: Throwable -> L7
        monitor-exit(r11);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // okhttp3.internal.http2.Http2Connection.Listener
    public void onStream(Http2Stream r10) throws IOException {
        r10.close(ErrorCode.REFUSED_STREAM);
    }

    @Override // okhttp3.Connection
    public Protocol protocol() {
        return this.protocol;
    }

    @Override // okhttp3.Connection
    public Route route() {
        return this.route;
    }

    @Override // okhttp3.Connection
    public Socket socket() {
        return this.socket;
    }

    public boolean supportsUrl(HttpUrl r10) {
        if (r10.z() == this.route.a().l().z()) goto L6;
        return false;
    L6:
        if (r10.m().equals(this.route.a().l().m()) == false) goto L8;
        return true;
    L8:
        if (this.handshake != null) goto L10;
        return false;
    L10:
        if (OkHostnameVerifier.INSTANCE.verify(r10.m(), (X509Certificate) this.handshake.e().get(0)) == true) goto L12;
        return false;
    L12:
        return true;
    }

    public String toString() {
        StringBuilder r10 = new StringBuilder();
        r10.append("Connection{");
        r10.append(this.route.a().l().m());
        r10.append(":");
        r10.append(this.route.a().l().z());
        r10.append(", proxy=");
        r10.append(this.route.b());
        r10.append(" hostAddress=");
        r10.append(this.route.d());
        r10.append(" cipherSuite=");
        Handshake r11 = this.handshake;
        if (r11 == null) goto L5;
        Object r12 = r11.a();
    L6:
        r10.append(r12);
        r10.append(" protocol=");
        r10.append(this.protocol);
        r10.append('}');
        return r10.toString();
    L5:
        r12 = SchedulerSupport.NONE;
        goto L6
    }
}
