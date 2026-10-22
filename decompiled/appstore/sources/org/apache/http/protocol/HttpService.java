package org.apache.http.protocol;

import java.io.IOException;
import org.apache.http.ConnectionReuseStrategy;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpException;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.HttpResponseFactory;
import org.apache.http.HttpServerConnection;
import org.apache.http.HttpVersion;
import org.apache.http.MethodNotSupportedException;
import org.apache.http.ProtocolException;
import org.apache.http.UnsupportedHttpVersionException;
import org.apache.http.annotation.Contract;
import org.apache.http.annotation.ThreadingBehavior;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.DefaultConnectionReuseStrategy;
import org.apache.http.impl.DefaultHttpResponseFactory;
import org.apache.http.params.HttpParams;
import org.apache.http.util.Args;
import org.apache.http.util.EncodingUtils;
import org.apache.http.util.EntityUtils;

/* JADX INFO: loaded from: classes4.dex */
@Contract(threading = ThreadingBehavior.IMMUTABLE_CONDITIONAL)
public class HttpService {
    private volatile ConnectionReuseStrategy connStrategy;
    private volatile HttpExpectationVerifier expectationVerifier;
    private volatile HttpRequestHandlerMapper handlerMapper;
    private volatile HttpParams params;
    private volatile HttpProcessor processor;
    private volatile HttpResponseFactory responseFactory;

    @Deprecated
    public static class HttpRequestHandlerResolverAdapter implements HttpRequestHandlerMapper {
        private final HttpRequestHandlerResolver resolver;

        public HttpRequestHandlerResolverAdapter(HttpRequestHandlerResolver r10) {
            this.resolver = r10;
        }

        @Override // org.apache.http.protocol.HttpRequestHandlerMapper
        public HttpRequestHandler lookup(HttpRequest r10) {
            return this.resolver.lookup(r10.getRequestLine().getUri());
        }
    }

    @Deprecated
    public HttpService(HttpProcessor r10, ConnectionReuseStrategy r11, HttpResponseFactory r12, HttpRequestHandlerResolver r13, HttpExpectationVerifier r14, HttpParams r15) {
        this(r10, r11, r12, new HttpRequestHandlerResolverAdapter(r13), r14);
        this.params = r15;
    }

    private boolean canResponseHaveBody(HttpRequest r10, HttpResponse r11) {
        if (r10 != null) goto L5;
    L7:
        int r12 = r11.getStatusLine().getStatusCode();
        if (r12 >= 200) goto L10;
        return false;
    L10:
        if (r12 != 204) goto L12;
        return false;
    L12:
        if (r12 != 304) goto L14;
        return false;
    L14:
        if (r12 == 205) goto L20;
        return true;
    L20:
        return false;
    L5:
        if ("HEAD".equalsIgnoreCase(r10.getRequestLine().getMethod()) == false) goto L7;
        return false;
    }

    public void doService(HttpRequest r10, HttpResponse r11, HttpContext r12) throws HttpException, IOException {
        if (this.handlerMapper == null) goto L5;
        HttpRequestHandler r13 = this.handlerMapper.lookup(r10);
    L6:
        if (r13 == null) goto L8;
        r13.handle(r10, r11, r12);
        return;
    L8:
        r11.setStatusCode(501);
        return;
    L5:
        r13 = null;
        goto L6
    }

    @Deprecated
    public HttpParams getParams() {
        return this.params;
    }

    public void handleException(HttpException r10, HttpResponse r11) {
        if ((r10 instanceof MethodNotSupportedException) == false) goto L6;
        r11.setStatusCode(501);
    L12:
        String r12 = r10.getMessage();
        if (r12 != null) goto L15;
        r12 = r10.toString();
    L15:
        ByteArrayEntity r13 = new ByteArrayEntity(EncodingUtils.getAsciiBytes(r12));
        r13.setContentType("text/plain; charset=US-ASCII");
        r11.setEntity(r13);
        return;
    L6:
        if ((r10 instanceof UnsupportedHttpVersionException) == false) goto L9;
        r11.setStatusCode(505);
        goto L12
    L9:
        if ((r10 instanceof ProtocolException) == false) goto L11;
        r11.setStatusCode(400);
        goto L12
    L11:
        r11.setStatusCode(500);
        goto L12
    }

    public void handleRequest(HttpServerConnection r10, HttpContext r11) throws IOException, HttpException {
        r11.setAttribute("http.connection", r10);
        HttpResponse r12 = null;
        HttpRequest r13 = r10.receiveRequestHeader();     // Catch: HttpException -> L28
    L14:
        HttpException e10 = e;
    L30:
        HttpResponse r14 = this.responseFactory.newHttpResponse(HttpVersion.HTTP_1_0, 500, r11);
        handleException(e10, r14);
        r12 = r14;
    L31:
        r11.setAttribute("http.response", r12);
        this.processor.process(r12, r11);
        r10.sendResponseHeader(r12);
        if (canResponseHaveBody(r13, r12) == false) goto L34;
        r10.sendResponseEntity(r12);
    L34:
        r10.flush();
        if (this.connStrategy.keepAlive(r12, r11) == true) goto L44;
        r10.close();
        return;
    L44:
        return;
    L5:
        if ((r13 instanceof HttpEntityEnclosingRequest) == true) goto L7;
    L21:
        r11.setAttribute("http.request", r13);     // Catch: HttpException -> L14
        if (r12 != null) goto L25;
        r12 = this.responseFactory.newHttpResponse(HttpVersion.HTTP_1_1, 200, r11);     // Catch: HttpException -> L14
        this.processor.process(r13, r11);     // Catch: HttpException -> L14
        doService(r13, r12, r11);     // Catch: HttpException -> L14
    L25:
        if ((r13 instanceof HttpEntityEnclosingRequest) == false) goto L31;
        EntityUtils.consume(((HttpEntityEnclosingRequest) r13).getEntity());     // Catch: HttpException -> L14
        goto L31
    L7:
        if (((HttpEntityEnclosingRequest) r13).expectContinue() == false) goto L20;
        HttpResponse r15 = this.responseFactory.newHttpResponse(HttpVersion.HTTP_1_1, 100, r11);     // Catch: HttpException -> L14
        if (this.expectationVerifier == null) goto L17;
        this.expectationVerifier.verify(r13, r15, r11);     // Catch: HttpException -> L12
    L12:
        e = move-exception;
        HttpResponse r16 = this.responseFactory.newHttpResponse(HttpVersion.HTTP_1_0, 500, r11);     // Catch: HttpException -> L14
        handleException(e, r16);     // Catch: HttpException -> L14
        r15 = r16;
    L17:
        if (r15.getStatusLine().getStatusCode() >= 200) goto L19;
        r10.sendResponseHeader(r15);     // Catch: HttpException -> L14
        r10.flush();     // Catch: HttpException -> L14
        r10.receiveRequestEntity((HttpEntityEnclosingRequest) r13);     // Catch: HttpException -> L14
        goto L21
    L19:
        r12 = r15;
        goto L21
    L20:
        r10.receiveRequestEntity((HttpEntityEnclosingRequest) r13);     // Catch: HttpException -> L14
    L28:
        e = move-exception;
        r13 = null;
        e10 = e;
        goto L30
    }

    @Deprecated
    public void setConnReuseStrategy(ConnectionReuseStrategy r10) {
        Args.notNull(r10, "Connection reuse strategy");
        this.connStrategy = r10;
    }

    @Deprecated
    public void setExpectationVerifier(HttpExpectationVerifier r10) {
        this.expectationVerifier = r10;
    }

    @Deprecated
    public void setHandlerResolver(HttpRequestHandlerResolver r10) {
        this.handlerMapper = new HttpRequestHandlerResolverAdapter(r10);
    }

    @Deprecated
    public void setHttpProcessor(HttpProcessor r10) {
        Args.notNull(r10, "HTTP processor");
        this.processor = r10;
    }

    @Deprecated
    public void setParams(HttpParams r10) {
        this.params = r10;
    }

    @Deprecated
    public void setResponseFactory(HttpResponseFactory r10) {
        Args.notNull(r10, "Response factory");
        this.responseFactory = r10;
    }

    @Deprecated
    public HttpService(HttpProcessor r10, ConnectionReuseStrategy r11, HttpResponseFactory r12, HttpRequestHandlerResolver r13, HttpParams r14) {
        this(r10, r11, r12, new HttpRequestHandlerResolverAdapter(r13), null);
        this.params = r14;
    }

    @Deprecated
    public HttpService(HttpProcessor r10, ConnectionReuseStrategy r11, HttpResponseFactory r12) {
        this.params = null;
        this.processor = null;
        this.handlerMapper = null;
        this.connStrategy = null;
        this.responseFactory = null;
        this.expectationVerifier = null;
        setHttpProcessor(r10);
        setConnReuseStrategy(r11);
        setResponseFactory(r12);
    }

    public HttpService(HttpProcessor r10, ConnectionReuseStrategy r11, HttpResponseFactory r12, HttpRequestHandlerMapper r13, HttpExpectationVerifier r14) {
        this.params = null;
        this.processor = null;
        this.handlerMapper = null;
        this.connStrategy = null;
        this.responseFactory = null;
        this.expectationVerifier = null;
        this.processor = (HttpProcessor) Args.notNull(r10, "HTTP processor");
        if (r11 != null) goto L6;
        r11 = DefaultConnectionReuseStrategy.INSTANCE;
    L6:
        this.connStrategy = r11;
        if (r12 != null) goto L10;
        r12 = DefaultHttpResponseFactory.INSTANCE;
    L10:
        this.responseFactory = r12;
        this.handlerMapper = r13;
        this.expectationVerifier = r14;
    }

    public HttpService(HttpProcessor r10, ConnectionReuseStrategy r11, HttpResponseFactory r12, HttpRequestHandlerMapper r13) {
        this(r10, r11, r12, r13, null);
    }

    public HttpService(HttpProcessor r10, HttpRequestHandlerMapper r11) {
        this(r10, null, null, r11, null);
    }
}
