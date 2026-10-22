package org.apache.http.impl;

import java.io.IOException;
import java.net.SocketTimeoutException;
import org.apache.http.HttpClientConnection;
import org.apache.http.HttpConnectionMetrics;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpException;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.HttpResponseFactory;
import org.apache.http.impl.entity.EntityDeserializer;
import org.apache.http.impl.entity.EntitySerializer;
import org.apache.http.impl.entity.LaxContentLengthStrategy;
import org.apache.http.impl.entity.StrictContentLengthStrategy;
import org.apache.http.impl.io.DefaultHttpResponseParser;
import org.apache.http.impl.io.HttpRequestWriter;
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
public abstract class AbstractHttpClientConnection implements HttpClientConnection {
    private final EntityDeserializer entitydeserializer;
    private final EntitySerializer entityserializer;
    private EofSensor eofSensor;
    private SessionInputBuffer inBuffer;
    private HttpConnectionMetricsImpl metrics;
    private SessionOutputBuffer outbuffer;
    private HttpMessageWriter<HttpRequest> requestWriter;
    private HttpMessageParser<HttpResponse> responseParser;

    public AbstractHttpClientConnection() {
        this.inBuffer = null;
        this.outbuffer = null;
        this.eofSensor = null;
        this.responseParser = null;
        this.requestWriter = null;
        this.metrics = null;
        this.entityserializer = createEntitySerializer();
        this.entitydeserializer = createEntityDeserializer();
    }

    public abstract void assertOpen() throws IllegalStateException;

    public HttpConnectionMetricsImpl createConnectionMetrics(HttpTransportMetrics r10, HttpTransportMetrics r11) {
        return new HttpConnectionMetricsImpl(r10, r11);
    }

    public EntityDeserializer createEntityDeserializer() {
        return new EntityDeserializer(new LaxContentLengthStrategy());
    }

    public EntitySerializer createEntitySerializer() {
        return new EntitySerializer(new StrictContentLengthStrategy());
    }

    public HttpResponseFactory createHttpResponseFactory() {
        return DefaultHttpResponseFactory.INSTANCE;
    }

    public HttpMessageWriter<HttpRequest> createRequestWriter(SessionOutputBuffer r10, HttpParams r11) {
        return new HttpRequestWriter(r10, null, r11);
    }

    public HttpMessageParser<HttpResponse> createResponseParser(SessionInputBuffer r10, HttpResponseFactory r11, HttpParams r12) {
        return new DefaultHttpResponseParser(r10, null, r11, r12);
    }

    public void doFlush() throws IOException {
        this.outbuffer.flush();
    }

    @Override // org.apache.http.HttpClientConnection
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
        this.responseParser = createResponseParser(r10, createHttpResponseFactory(), r12);
        this.requestWriter = createRequestWriter(r11, r12);
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

    @Override // org.apache.http.HttpClientConnection
    public boolean isResponseAvailable(int r10) throws IOException {
        assertOpen();
        return this.inBuffer.isDataAvailable(r10);
    L5:
        return false;
    }

    @Override // org.apache.http.HttpConnection
    public boolean isStale() {
        if (isOpen() == true) goto L6;
        return true;
    L6:
        if (isEof() == false) goto L13;
        return true;
    L13:
        this.inBuffer.isDataAvailable(1);     // Catch: IOException -> L10 SocketTimeoutException -> L11
        return isEof();
    L11:
        return false;
    L10:
        return true;
    }

    @Override // org.apache.http.HttpClientConnection
    public void receiveResponseEntity(HttpResponse r10) throws HttpException, IOException {
        Args.notNull(r10, "HTTP response");
        assertOpen();
        r10.setEntity(this.entitydeserializer.deserialize(this.inBuffer, r10));
    }

    @Override // org.apache.http.HttpClientConnection
    public HttpResponse receiveResponseHeader() throws HttpException, IOException {
        assertOpen();
        HttpResponse r10 = (HttpResponse) this.responseParser.parse();
        if (r10.getStatusLine().getStatusCode() < 200) goto L5;
        this.metrics.incrementResponseCount();
    L5:
        return r10;
    }

    @Override // org.apache.http.HttpClientConnection
    public void sendRequestEntity(HttpEntityEnclosingRequest r10) throws HttpException, IOException {
        Args.notNull(r10, "HTTP request");
        assertOpen();
        if (r10.getEntity() != null) goto L5;
        return;
    L5:
        this.entityserializer.serialize(this.outbuffer, r10, r10.getEntity());
    }

    @Override // org.apache.http.HttpClientConnection
    public void sendRequestHeader(HttpRequest r10) throws HttpException, IOException {
        Args.notNull(r10, "HTTP request");
        assertOpen();
        this.requestWriter.write(r10);
        this.metrics.incrementRequestCount();
    }
}
