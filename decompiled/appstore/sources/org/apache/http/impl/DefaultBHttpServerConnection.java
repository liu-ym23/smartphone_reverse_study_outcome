package org.apache.http.impl;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpException;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.HttpServerConnection;
import org.apache.http.config.MessageConstraints;
import org.apache.http.entity.ContentLengthStrategy;
import org.apache.http.impl.entity.DisallowIdentityContentLengthStrategy;
import org.apache.http.impl.io.DefaultHttpRequestParserFactory;
import org.apache.http.impl.io.DefaultHttpResponseWriterFactory;
import org.apache.http.io.HttpMessageParser;
import org.apache.http.io.HttpMessageParserFactory;
import org.apache.http.io.HttpMessageWriter;
import org.apache.http.io.HttpMessageWriterFactory;
import org.apache.http.util.Args;

/* JADX INFO: loaded from: classes4.dex */
public class DefaultBHttpServerConnection extends BHttpConnectionBase implements HttpServerConnection {
    private final HttpMessageParser<HttpRequest> requestParser;
    private final HttpMessageWriter<HttpResponse> responseWriter;

    public DefaultBHttpServerConnection(int r10, int r11, CharsetDecoder r12, CharsetEncoder r13, MessageConstraints r14, ContentLengthStrategy r15, ContentLengthStrategy r16, HttpMessageParserFactory<HttpRequest> r17, HttpMessageWriterFactory<HttpResponse> r18) {
        if (r15 == null) goto L5;
        ContentLengthStrategy r19 = r15;
    L6:
        super(r10, r11, r12, r13, r14, r19, r16);
        if (r17 == null) goto L9;
        HttpMessageParserFactory<HttpRequest> r20 = r17;
    L10:
        this.requestParser = r20.create(getSessionInputBuffer(), r14);
        if (r18 == null) goto L13;
        HttpMessageWriterFactory<HttpResponse> r21 = r18;
    L14:
        this.responseWriter = r21.create(getSessionOutputBuffer());
        return;
    L13:
        r21 = DefaultHttpResponseWriterFactory.INSTANCE;
        goto L14
    L9:
        r20 = DefaultHttpRequestParserFactory.INSTANCE;
        goto L10
    L5:
        r19 = DisallowIdentityContentLengthStrategy.INSTANCE;
        goto L6
    }

    @Override // org.apache.http.impl.BHttpConnectionBase
    public void bind(Socket r10) throws IOException {
        super.bind(r10);
    }

    @Override // org.apache.http.HttpServerConnection
    public void flush() throws IOException {
        ensureOpen();
        doFlush();
    }

    public void onRequestReceived(HttpRequest r10) {
    }

    public void onResponseSubmitted(HttpResponse r10) {
    }

    @Override // org.apache.http.HttpServerConnection
    public void receiveRequestEntity(HttpEntityEnclosingRequest r10) throws HttpException, IOException {
        Args.notNull(r10, "HTTP request");
        ensureOpen();
        r10.setEntity(prepareInput(r10));
    }

    @Override // org.apache.http.HttpServerConnection
    public HttpRequest receiveRequestHeader() throws HttpException, IOException {
        ensureOpen();
        HttpRequest r10 = (HttpRequest) this.requestParser.parse();
        onRequestReceived(r10);
        incrementRequestCount();
        return r10;
    }

    @Override // org.apache.http.HttpServerConnection
    public void sendResponseEntity(HttpResponse r10) throws HttpException, IOException {
        Args.notNull(r10, "HTTP response");
        ensureOpen();
        HttpEntity r11 = r10.getEntity();
        if (r11 != null) goto L5;
        return;
    L5:
        OutputStream r12 = prepareOutput(r10);
        r11.writeTo(r12);
        r12.close();
    }

    @Override // org.apache.http.HttpServerConnection
    public void sendResponseHeader(HttpResponse r10) throws HttpException, IOException {
        Args.notNull(r10, "HTTP response");
        ensureOpen();
        this.responseWriter.write(r10);
        onResponseSubmitted(r10);
        if (r10.getStatusLine().getStatusCode() < 200) goto L6;
        incrementResponseCount();
        return;
    }

    public DefaultBHttpServerConnection(int r11, CharsetDecoder r12, CharsetEncoder r13, MessageConstraints r14) {
        this(r11, r11, r12, r13, r14, null, null, null, null);
    }

    public DefaultBHttpServerConnection(int r11) {
        this(r11, r11, null, null, null, null, null, null, null);
    }
}
