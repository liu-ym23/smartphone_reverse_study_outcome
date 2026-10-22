package org.apache.http.impl;

import java.io.IOException;
import java.net.Socket;
import org.apache.http.HttpConnection;
import org.apache.http.HttpConnectionFactory;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.annotation.Contract;
import org.apache.http.annotation.ThreadingBehavior;
import org.apache.http.config.ConnectionConfig;
import org.apache.http.entity.ContentLengthStrategy;
import org.apache.http.io.HttpMessageParserFactory;
import org.apache.http.io.HttpMessageWriterFactory;

/* JADX INFO: loaded from: classes4.dex */
@Contract(threading = ThreadingBehavior.IMMUTABLE_CONDITIONAL)
public class DefaultBHttpServerConnectionFactory implements HttpConnectionFactory<DefaultBHttpServerConnection> {
    public static final DefaultBHttpServerConnectionFactory INSTANCE = null;
    private final ConnectionConfig cconfig;
    private final ContentLengthStrategy incomingContentStrategy;
    private final ContentLengthStrategy outgoingContentStrategy;
    private final HttpMessageParserFactory<HttpRequest> requestParserFactory;
    private final HttpMessageWriterFactory<HttpResponse> responseWriterFactory;

    static {
        INSTANCE = new DefaultBHttpServerConnectionFactory();
    }

    public DefaultBHttpServerConnectionFactory(ConnectionConfig r10, ContentLengthStrategy r11, ContentLengthStrategy r12, HttpMessageParserFactory<HttpRequest> r13, HttpMessageWriterFactory<HttpResponse> r14) {
        if (r10 != null) goto L6;
        r10 = ConnectionConfig.DEFAULT;
    L6:
        this.cconfig = r10;
        this.incomingContentStrategy = r11;
        this.outgoingContentStrategy = r12;
        this.requestParserFactory = r13;
        this.responseWriterFactory = r14;
    }

    @Override // org.apache.http.HttpConnectionFactory
    public /* bridge */ /* synthetic */ HttpConnection createConnection(Socket r10) throws IOException {
        return createConnection(r10);
    }

    @Override // org.apache.http.HttpConnectionFactory
    public DefaultBHttpServerConnection createConnection(Socket r12) throws IOException {
        DefaultBHttpServerConnection r10 = new DefaultBHttpServerConnection(this.cconfig.getBufferSize(), this.cconfig.getFragmentSizeHint(), ConnSupport.createDecoder(this.cconfig), ConnSupport.createEncoder(this.cconfig), this.cconfig.getMessageConstraints(), this.incomingContentStrategy, this.outgoingContentStrategy, this.requestParserFactory, this.responseWriterFactory);
        r10.bind(r12);
        return r10;
    }

    public DefaultBHttpServerConnectionFactory(ConnectionConfig r10, HttpMessageParserFactory<HttpRequest> r11, HttpMessageWriterFactory<HttpResponse> r12) {
        this(r10, null, null, r11, r12);
    }

    public DefaultBHttpServerConnectionFactory(ConnectionConfig r10) {
        this(r10, null, null, null, null);
    }

    public DefaultBHttpServerConnectionFactory() {
        this(null, null, null, null, null);
    }
}
