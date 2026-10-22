package org.apache.http.impl;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import org.apache.http.HttpClientConnection;
import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpException;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.config.MessageConstraints;
import org.apache.http.entity.ContentLengthStrategy;
import org.apache.http.impl.io.DefaultHttpRequestWriterFactory;
import org.apache.http.impl.io.DefaultHttpResponseParserFactory;
import org.apache.http.io.HttpMessageParser;
import org.apache.http.io.HttpMessageParserFactory;
import org.apache.http.io.HttpMessageWriter;
import org.apache.http.io.HttpMessageWriterFactory;
import org.apache.http.util.Args;

/* JADX INFO: loaded from: classes4.dex */
public class DefaultBHttpClientConnection extends BHttpConnectionBase implements HttpClientConnection {
    private final HttpMessageWriter<HttpRequest> requestWriter;
    private final HttpMessageParser<HttpResponse> responseParser;

    public DefaultBHttpClientConnection(int r10, int r11, CharsetDecoder r12, CharsetEncoder r13, MessageConstraints r14, ContentLengthStrategy r15, ContentLengthStrategy r16, HttpMessageWriterFactory<HttpRequest> r17, HttpMessageParserFactory<HttpResponse> r18) {
        super(r10, r11, r12, r13, r14, r15, r16);
        if (r17 != null) goto L6;
        r17 = DefaultHttpRequestWriterFactory.INSTANCE;
    L6:
        this.requestWriter = r17.create(getSessionOutputBuffer());
        if (r18 != null) goto L10;
        r18 = DefaultHttpResponseParserFactory.INSTANCE;
    L10:
        this.responseParser = r18.create(getSessionInputBuffer(), r14);
    }

    @Override // org.apache.http.impl.BHttpConnectionBase
    public void bind(Socket r10) throws IOException {
        super.bind(r10);
    }

    @Override // org.apache.http.HttpClientConnection
    public void flush() throws IOException {
        ensureOpen();
        doFlush();
    }

    @Override // org.apache.http.HttpClientConnection
    public boolean isResponseAvailable(int r10) throws IOException {
        ensureOpen();
        return awaitInput(r10);
    L5:
        return false;
    }

    public void onRequestSubmitted(HttpRequest r10) {
    }

    public void onResponseReceived(HttpResponse r10) {
    }

    @Override // org.apache.http.HttpClientConnection
    public void receiveResponseEntity(HttpResponse r10) throws HttpException, IOException {
        Args.notNull(r10, "HTTP response");
        ensureOpen();
        r10.setEntity(prepareInput(r10));
    }

    @Override // org.apache.http.HttpClientConnection
    public HttpResponse receiveResponseHeader() throws HttpException, IOException {
        ensureOpen();
        HttpResponse r10 = (HttpResponse) this.responseParser.parse();
        onResponseReceived(r10);
        if (r10.getStatusLine().getStatusCode() < 200) goto L5;
        incrementResponseCount();
    L5:
        return r10;
    }

    @Override // org.apache.http.HttpClientConnection
    public void sendRequestEntity(HttpEntityEnclosingRequest r10) throws HttpException, IOException {
        Args.notNull(r10, "HTTP request");
        ensureOpen();
        HttpEntity r11 = r10.getEntity();
        if (r11 != null) goto L5;
        return;
    L5:
        OutputStream r12 = prepareOutput(r10);
        r11.writeTo(r12);
        r12.close();
    }

    @Override // org.apache.http.HttpClientConnection
    public void sendRequestHeader(HttpRequest r10) throws HttpException, IOException {
        Args.notNull(r10, "HTTP request");
        ensureOpen();
        this.requestWriter.write(r10);
        onRequestSubmitted(r10);
        incrementRequestCount();
    }

    public DefaultBHttpClientConnection(int r11, CharsetDecoder r12, CharsetEncoder r13, MessageConstraints r14) {
        this(r11, r11, r12, r13, r14, null, null, null, null);
    }

    public DefaultBHttpClientConnection(int r11) {
        this(r11, r11, null, null, null, null, null, null, null);
    }
}
