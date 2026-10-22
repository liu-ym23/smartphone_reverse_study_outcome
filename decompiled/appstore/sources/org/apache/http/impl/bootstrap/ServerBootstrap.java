package org.apache.http.impl.bootstrap;

import java.net.InetAddress;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import javax.net.ServerSocketFactory;
import javax.net.ssl.SSLContext;
import org.apache.http.ConnectionReuseStrategy;
import org.apache.http.ExceptionLogger;
import org.apache.http.HttpConnectionFactory;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.HttpResponseFactory;
import org.apache.http.HttpResponseInterceptor;
import org.apache.http.config.ConnectionConfig;
import org.apache.http.config.SocketConfig;
import org.apache.http.impl.DefaultBHttpServerConnection;
import org.apache.http.impl.DefaultBHttpServerConnectionFactory;
import org.apache.http.impl.DefaultConnectionReuseStrategy;
import org.apache.http.impl.DefaultHttpResponseFactory;
import org.apache.http.protocol.HttpExpectationVerifier;
import org.apache.http.protocol.HttpProcessor;
import org.apache.http.protocol.HttpProcessorBuilder;
import org.apache.http.protocol.HttpRequestHandler;
import org.apache.http.protocol.HttpRequestHandlerMapper;
import org.apache.http.protocol.HttpService;
import org.apache.http.protocol.ResponseConnControl;
import org.apache.http.protocol.ResponseContent;
import org.apache.http.protocol.ResponseDate;
import org.apache.http.protocol.ResponseServer;
import org.apache.http.protocol.UriHttpRequestHandlerMapper;

/* JADX INFO: loaded from: classes4.dex */
public class ServerBootstrap {
    private ConnectionReuseStrategy connStrategy;
    private ConnectionConfig connectionConfig;
    private HttpConnectionFactory<? extends DefaultBHttpServerConnection> connectionFactory;
    private ExceptionLogger exceptionLogger;
    private HttpExpectationVerifier expectationVerifier;
    private Map<String, HttpRequestHandler> handlerMap;
    private HttpRequestHandlerMapper handlerMapper;
    private HttpProcessor httpProcessor;
    private int listenerPort;
    private InetAddress localAddress;
    private LinkedList<HttpRequestInterceptor> requestFirst;
    private LinkedList<HttpRequestInterceptor> requestLast;
    private HttpResponseFactory responseFactory;
    private LinkedList<HttpResponseInterceptor> responseFirst;
    private LinkedList<HttpResponseInterceptor> responseLast;
    private String serverInfo;
    private ServerSocketFactory serverSocketFactory;
    private SocketConfig socketConfig;
    private SSLContext sslContext;
    private SSLServerSetupHandler sslSetupHandler;

    private ServerBootstrap() {
    }

    public static ServerBootstrap bootstrap() {
        return new ServerBootstrap();
    }

    public final ServerBootstrap addInterceptorFirst(HttpResponseInterceptor r10) {
        if (r10 != null) goto L5;
        return this;
    L5:
        if (this.responseFirst != null) goto L7;
        this.responseFirst = new LinkedList();
    L7:
        this.responseFirst.addFirst(r10);
        return this;
    }

    public final ServerBootstrap addInterceptorLast(HttpResponseInterceptor r10) {
        if (r10 != null) goto L5;
        return this;
    L5:
        if (this.responseLast != null) goto L7;
        this.responseLast = new LinkedList();
    L7:
        this.responseLast.addLast(r10);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v2, types: [org.apache.http.protocol.HttpRequestHandlerMapper] */
    /* JADX WARN: Type inference failed for: r2v24, types: [org.apache.http.protocol.UriHttpRequestHandlerMapper] */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r7v0, types: [org.apache.http.protocol.HttpRequestHandlerMapper] */
    public HttpServer create() {
        HttpProcessor r10 = this.httpProcessor;
        if (r10 != null) goto L32;
        HttpProcessorBuilder r11 = HttpProcessorBuilder.create();
        LinkedList<HttpRequestInterceptor> r12 = this.requestFirst;
        if (r12 == null) goto L10;
        Iterator<HttpRequestInterceptor> r13 = r12.iterator();
    L8:
        if (r13.hasNext() == false) goto L10;
        r11.addFirst(r13.next());
    L10:
        LinkedList<HttpResponseInterceptor> r14 = this.responseFirst;
        if (r14 == null) goto L16;
        Iterator<HttpResponseInterceptor> r15 = r14.iterator();
    L14:
        if (r15.hasNext() == false) goto L16;
        r11.addFirst(r15.next());
    L16:
        String r16 = this.serverInfo;
        if (r16 != null) goto L19;
        r16 = "Apache-HttpCore/1.1";
    L19:
        r11.addAll(new HttpResponseInterceptor[]{new ResponseDate(), new ResponseServer(r16), new ResponseContent(), new ResponseConnControl()});
        LinkedList<HttpRequestInterceptor> r17 = this.requestLast;
        if (r17 == null) goto L25;
        Iterator<HttpRequestInterceptor> r18 = r17.iterator();
    L23:
        if (r18.hasNext() == false) goto L25;
        r11.addLast(r18.next());
    L25:
        LinkedList<HttpResponseInterceptor> r19 = this.responseLast;
        if (r19 == null) goto L31;
        Iterator<HttpResponseInterceptor> r20 = r19.iterator();
    L29:
        if (r20.hasNext() == false) goto L31;
        r11.addLast(r20.next());
    L31:
        r10 = r11.build();
    L32:
        HttpProcessor r21 = r10;
        ?? r22 = this.handlerMapper;
        if (r22 != 0) goto L40;
        r22 = new UriHttpRequestHandlerMapper();
        Map<String, HttpRequestHandler> r23 = this.handlerMap;
        if (r23 == null) goto L40;
        Iterator<Map.Entry<String, HttpRequestHandler>> r24 = r23.entrySet().iterator();
    L38:
        if (r24.hasNext() == false) goto L40;
        Map.Entry<String, HttpRequestHandler> r25 = r24.next();
        r22.register(r25.getKey(), r25.getValue());
    L40:
        ?? r26 = r22;
        ConnectionReuseStrategy r27 = this.connStrategy;
        if (r27 != null) goto L43;
        r27 = DefaultConnectionReuseStrategy.INSTANCE;
    L43:
        ConnectionReuseStrategy r28 = r27;
        HttpResponseFactory r29 = this.responseFactory;
        if (r29 != null) goto L46;
        r29 = DefaultHttpResponseFactory.INSTANCE;
    L46:
        HttpService r110 = new HttpService(r21, r28, r29, r26, this.expectationVerifier);
        ServerSocketFactory r30 = this.serverSocketFactory;
        if (r30 != null) goto L51;
        SSLContext r31 = this.sslContext;
        if (r31 == null) goto L52;
        r30 = r31.getServerSocketFactory();
        goto L51
    L52:
        r30 = ServerSocketFactory.getDefault();
    L51:
        ServerSocketFactory r111 = r30;
        HttpConnectionFactory r32 = this.connectionFactory;
        if (r32 == null) goto L56;
    L58:
        HttpConnectionFactory r112 = r32;
        ExceptionLogger r33 = this.exceptionLogger;
        if (r33 != null) goto L63;
        r33 = ExceptionLogger.NO_OP;
    L63:
        ExceptionLogger r113 = r33;
        int r34 = this.listenerPort;
        if (r34 <= 0) goto L66;
        int r35 = r34;
    L67:
        InetAddress r114 = this.localAddress;
        SocketConfig r36 = this.socketConfig;
        if (r36 != null) goto L72;
        r36 = SocketConfig.DEFAULT;
    L72:
        return new HttpServer(r35, r114, r36, r111, r110, r112, this.sslSetupHandler, r113);
    L66:
        r35 = 0;
        goto L67
    L56:
        if (this.connectionConfig == null) goto L59;
        r32 = new DefaultBHttpServerConnectionFactory(this.connectionConfig);
        goto L58
    L59:
        r32 = DefaultBHttpServerConnectionFactory.INSTANCE;
        goto L58
    }

    public final ServerBootstrap registerHandler(String r10, HttpRequestHandler r11) {
        if (r10 == null) goto L9;
        if (r11 == null) goto L9;
        if (this.handlerMap != null) goto L8;
        this.handlerMap = new HashMap();
    L8:
        this.handlerMap.put(r10, r11);
    L9:
        return this;
    }

    public final ServerBootstrap setConnectionConfig(ConnectionConfig r10) {
        this.connectionConfig = r10;
        return this;
    }

    public final ServerBootstrap setConnectionFactory(HttpConnectionFactory<? extends DefaultBHttpServerConnection> r10) {
        this.connectionFactory = r10;
        return this;
    }

    public final ServerBootstrap setConnectionReuseStrategy(ConnectionReuseStrategy r10) {
        this.connStrategy = r10;
        return this;
    }

    public final ServerBootstrap setExceptionLogger(ExceptionLogger r10) {
        this.exceptionLogger = r10;
        return this;
    }

    public final ServerBootstrap setExpectationVerifier(HttpExpectationVerifier r10) {
        this.expectationVerifier = r10;
        return this;
    }

    public final ServerBootstrap setHandlerMapper(HttpRequestHandlerMapper r10) {
        this.handlerMapper = r10;
        return this;
    }

    public final ServerBootstrap setHttpProcessor(HttpProcessor r10) {
        this.httpProcessor = r10;
        return this;
    }

    public final ServerBootstrap setListenerPort(int r10) {
        this.listenerPort = r10;
        return this;
    }

    public final ServerBootstrap setLocalAddress(InetAddress r10) {
        this.localAddress = r10;
        return this;
    }

    public final ServerBootstrap setResponseFactory(HttpResponseFactory r10) {
        this.responseFactory = r10;
        return this;
    }

    public final ServerBootstrap setServerInfo(String r10) {
        this.serverInfo = r10;
        return this;
    }

    public final ServerBootstrap setServerSocketFactory(ServerSocketFactory r10) {
        this.serverSocketFactory = r10;
        return this;
    }

    public final ServerBootstrap setSocketConfig(SocketConfig r10) {
        this.socketConfig = r10;
        return this;
    }

    public final ServerBootstrap setSslContext(SSLContext r10) {
        this.sslContext = r10;
        return this;
    }

    public final ServerBootstrap setSslSetupHandler(SSLServerSetupHandler r10) {
        this.sslSetupHandler = r10;
        return this;
    }

    public final ServerBootstrap addInterceptorFirst(HttpRequestInterceptor r10) {
        if (r10 != null) goto L5;
        return this;
    L5:
        if (this.requestFirst != null) goto L7;
        this.requestFirst = new LinkedList();
    L7:
        this.requestFirst.addFirst(r10);
        return this;
    }

    public final ServerBootstrap addInterceptorLast(HttpRequestInterceptor r10) {
        if (r10 != null) goto L5;
        return this;
    L5:
        if (this.requestLast != null) goto L7;
        this.requestLast = new LinkedList();
    L7:
        this.requestLast.addLast(r10);
        return this;
    }
}
