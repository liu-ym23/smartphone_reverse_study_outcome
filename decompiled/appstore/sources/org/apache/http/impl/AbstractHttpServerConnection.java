package org.apache.http.impl;

import java.io.IOException;
import org.apache.http.HttpConnectionMetrics;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpException;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestFactory;
import org.apache.http.HttpResponse;
import org.apache.http.HttpServerConnection;
import org.apache.http.impl.entity.DisallowIdentityContentLengthStrategy;
import org.apache.http.impl.entity.EntityDeserializer;
import org.apache.http.impl.entity.EntitySerializer;
import org.apache.http.impl.entity.LaxContentLengthStrategy;
import org.apache.http.impl.entity.StrictContentLengthStrategy;
import org.apache.http.impl.io.DefaultHttpRequestParser;
import org.apache.http.impl.io.HttpResponseWriter;
import org.apache.http.io.EofSensor;
import org.apache.http.io.HttpMessageParser;
import org.apache.http.io.HttpMessageWriter;
import org.apache.http.io.HttpTransportMetrics;
import org.apache.http.io.SessionInputBuffer;
import org.apache.http.io.SessionOutputBuffer;
import org.apache.http.params.HttpParams;
import org.apache.http.util.Args;

/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public abstract class AbstractHttpServerConnection implements HttpServerConnection {
    private final EntityDeserializer entitydeserializer;
    private final EntitySerializer entityserializer;
    private EofSensor eofSensor;
    private SessionInputBuffer inBuffer;
    private HttpConnectionMetricsImpl metrics;
    private SessionOutputBuffer outbuffer;
    private HttpMessageParser<HttpRequest> requestParser;
    private HttpMessageWriter<HttpResponse> responseWriter;

    public AbstractHttpServerConnection() {
        this.inBuffer = null;
        this.outbuffer = null;
        this.eofSensor = null;
        this.requestParser = null;
        this.responseWriter = null;
        this.metrics = null;
        this.entityserializer = createEntitySerializer();
        this.entitydeserializer = createEntityDeserializer();
    }

    public abstract void assertOpen() throws IllegalStateException;

    public HttpConnectionMetricsImpl createConnectionMetrics(HttpTransportMetrics r10, HttpTransportMetrics r11) {
        return new HttpConnectionMetricsImpl(r10, r11);
    }

    public EntityDeserializer createEntityDeserializer() {
        return new EntityDeserializer(new DisallowIdentityContentLengthStrategy(new LaxContentLengthStrategy(0)));
    }

    public EntitySerializer createEntitySerializer() {
        return new EntitySerializer(new StrictContentLengthStrategy());
    }

    public HttpRequestFactory createHttpRequestFactory() {
        return DefaultHttpRequestFactory.INSTANCE;
    }

    public HttpMessageParser<HttpRequest> createRequestParser(SessionInputBuffer r10, HttpRequestFactory r11, HttpParams r12) {
        return new DefaultHttpRequestParser(r10, null, r11, r12);
    }

    public HttpMessageWriter<HttpResponse> createResponseWriter(SessionOutputBuffer r10, HttpParams r11) {
        return new HttpResponseWriter(r10, null, r11);
    }

    public void doFlush() throws IOException {
        this.outbuffer.flush();
    }

    @Override // org.apache.http.HttpServerConnection
    public void flush() throws IOException {
        assertOpen();
        doFlush();
    }

    @Override // org.apache.http.HttpConnection
    public HttpConnectionMetrics getMetrics() {
        return this.metrics;
    }

    public void init(SessionInputBuffer r10, SessionOutputBuffer r11, HttpParams r12) {
        this.inBuffer = (SessionInputBuffer) Args.notNull(r10, "Input session buffer");
        this.outbuffer = (SessionOutputBuffer) Args.notNull(r11, "Output session buffer");
        if ((r10 instanceof EofSensor) == false) goto L5;
        this.eofSensor = (EofSensor) r10;
    L5:
        this.requestParser = createRequestParser(r10, createHttpRequestFactory(), r12);
        this.responseWriter = createResponseWriter(r11, r12);
        this.metrics = createConnectionMetrics(r10.getMetrics(), r11.getMetrics());
    }

    public boolean isEof() {
        EofSensor r10 = this.eofSensor;
        if (r10 != null) goto L5;
    L7:
        return false;
    L5:
        if (r10.isEof() == false) goto L7;
        return true;
    }

    @Override // org.apache.http.HttpConnection
    public boolean isStale() {
        if (isOpen() == true) goto L6;
        return true;
    L6:
        if (isEof() == false) goto L11;
        return true;
    L11:
        this.inBuffer.isDataAvailable(1);     // Catch: IOException -> L10
        return isEof();
    L10:
        return true;
    }

    @Override // org.apache.http.HttpServerConnection
    public void receiveRequestEntity(HttpEntityEnclosingRequest r10) throws HttpException, IOException {
        Args.notNull(r10, "HTTP request");
        assertOpen();
        r10.setEntity(this.entitydeserializer.deserialize(this.inBuffer, r10));
    }

    @Override // org.apache.http.HttpServerConnection
    public HttpRequest receiveRequestHeader() throws HttpException, IOException {
        assertOpen();
        HttpRequest r10 = (HttpRequest) this.requestParser.parse();
        this.metrics.incrementRequestCount();
        return r10;
    }

    @Override // org.apache.http.HttpServerConnection
    public void sendResponseEntity(HttpResponse r10) throws HttpException, IOException {
        if (r10.getEntity() != null) goto L5;
        return;
    L5:
        this.entityserializer.serialize(this.outbuffer, r10, r10.getEntity());
    }

    @Override // org.apache.http.HttpServerConnection
    public void sendResponseHeader(HttpResponse r10) throws HttpException, IOException {
        Args.notNull(r10, "HTTP response");
        assertOpen();
        this.responseWriter.write(r10);
        if (r10.getStatusLine().getStatusCode() < 200) goto L6;
        this.metrics.incrementResponseCount();
        return;
    }
}
