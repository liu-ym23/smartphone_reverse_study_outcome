package org.apache.http.impl.pool;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import javax.net.SocketFactory;
import javax.net.ssl.SSLSocketFactory;
import org.apache.http.HttpClientConnection;
import org.apache.http.HttpConnectionFactory;
import org.apache.http.HttpHost;
import org.apache.http.annotation.Contract;
import org.apache.http.annotation.ThreadingBehavior;
import org.apache.http.config.ConnectionConfig;
import org.apache.http.config.SocketConfig;
import org.apache.http.impl.DefaultBHttpClientConnection;
import org.apache.http.impl.DefaultBHttpClientConnectionFactory;
import org.apache.http.params.CoreConnectionPNames;
import org.apache.http.params.HttpParamConfig;
import org.apache.http.params.HttpParams;
import org.apache.http.pool.ConnFactory;
import org.apache.http.util.Args;

/* JADX INFO: loaded from: classes4.dex */
@Contract(threading = ThreadingBehavior.IMMUTABLE_CONDITIONAL)
public class BasicConnFactory implements ConnFactory<HttpHost, HttpClientConnection> {
    private final HttpConnectionFactory<? extends HttpClientConnection> connFactory;
    private final int connectTimeout;
    private final SocketFactory plainfactory;
    private final SocketConfig sconfig;
    private final SSLSocketFactory sslfactory;

    @Deprecated
    public BasicConnFactory(SSLSocketFactory r10, HttpParams r11) {
        Args.notNull(r11, "HTTP params");
        this.plainfactory = null;
        this.sslfactory = r10;
        this.connectTimeout = r11.getIntParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, 0);
        this.sconfig = HttpParamConfig.getSocketConfig(r11);
        this.connFactory = new DefaultBHttpClientConnectionFactory(HttpParamConfig.getConnectionConfig(r11));
    }

    @Override // org.apache.http.pool.ConnFactory
    public /* bridge */ /* synthetic */ HttpClientConnection create(HttpHost r10) throws IOException {
        return create2(r10);
    }

    @Deprecated
    public HttpClientConnection create(Socket r10, HttpParams r11) throws IOException {
        DefaultBHttpClientConnection r12 = new DefaultBHttpClientConnection(r11.getIntParameter(CoreConnectionPNames.SOCKET_BUFFER_SIZE, 8192));
        r12.bind(r10);
        return r12;
    }

    /* JADX INFO: renamed from: create, reason: avoid collision after fix types in other method */
    public HttpClientConnection create2(HttpHost r10) throws IOException {
        String r11 = r10.getSchemeName();
        if (HttpHost.DEFAULT_SCHEME_NAME.equalsIgnoreCase(r11) == false) goto L8;
        SocketFactory r12 = this.plainfactory;
        if (r12 == null) goto L7;
        Socket r13 = r12.createSocket();
    L10:
        if ("https".equalsIgnoreCase(r11) == false) goto L16;
        SocketFactory r14 = this.sslfactory;
        if (r14 != null) goto L15;
        r14 = SSLSocketFactory.getDefault();
    L15:
        r13 = r14.createSocket();
    L16:
        if (r13 == null) goto L37;
        String r15 = r10.getHostName();
        int r16 = r10.getPort();
        if (r16 == (-1)) goto L20;
    L25:
        r13.setSoTimeout(this.sconfig.getSoTimeout());
        if (this.sconfig.getSndBufSize() <= 0) goto L29;
        r13.setSendBufferSize(this.sconfig.getSndBufSize());
    L29:
        if (this.sconfig.getRcvBufSize() <= 0) goto L31;
        r13.setReceiveBufferSize(this.sconfig.getRcvBufSize());
    L31:
        r13.setTcpNoDelay(this.sconfig.isTcpNoDelay());
        int r17 = this.sconfig.getSoLinger();
        if (r17 < 0) goto L34;
        r13.setSoLinger(true, r17);
    L34:
        r13.setKeepAlive(this.sconfig.isSoKeepAlive());
        r13.connect(new InetSocketAddress(r15, r16), this.connectTimeout);
        return (HttpClientConnection) this.connFactory.createConnection(r13);
    L20:
        if (r10.getSchemeName().equalsIgnoreCase(HttpHost.DEFAULT_SCHEME_NAME) == false) goto L23;
        r16 = 80;
        goto L25
    L23:
        if (r10.getSchemeName().equalsIgnoreCase("https") == false) goto L25;
        r16 = 443;
        goto L25
    L37:
        throw new IOException(r11 + " scheme is not supported");
    L7:
        r13 = new Socket();
        goto L10
    L8:
        r13 = null;
        goto L10
    }

    @Deprecated
    public BasicConnFactory(HttpParams r10) {
        this(null, r10);
    }

    public BasicConnFactory(SocketFactory r10, SSLSocketFactory r11, int r12, SocketConfig r13, ConnectionConfig r14) {
        this.plainfactory = r10;
        this.sslfactory = r11;
        this.connectTimeout = r12;
        if (r13 != null) goto L6;
        r13 = SocketConfig.DEFAULT;
    L6:
        this.sconfig = r13;
        if (r14 != null) goto L10;
        r14 = ConnectionConfig.DEFAULT;
    L10:
        this.connFactory = new DefaultBHttpClientConnectionFactory(r14);
    }

    public BasicConnFactory(int r10, SocketConfig r11, ConnectionConfig r12) {
        this(null, null, r10, r11, r12);
    }

    public BasicConnFactory(SocketConfig r10, ConnectionConfig r11) {
        this(null, null, 0, r10, r11);
    }

    public BasicConnFactory() {
        this(null, null, 0, SocketConfig.DEFAULT, ConnectionConfig.DEFAULT);
    }
}
