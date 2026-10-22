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
public class DefaultBHttpClientConnectionFactory implements HttpConnectionFactory<DefaultBHttpClientConnection> {
    public static final DefaultBHttpClientConnectionFactory INSTANCE = null;
    private final ConnectionConfig cconfig;
    private final ContentLengthStrategy incomingContentStrategy;
    private final ContentLengthStrategy outgoingContentStrategy;
    private final HttpMessageWriterFactory<HttpRequest> requestWriterFactory;
    private final HttpMessageParserFactory<HttpResponse> responseParserFactory;

    static {
        INSTANCE = new DefaultBHttpClientConnectionFactory();
    }

    public DefaultBHttpClientConnectionFactory(ConnectionConfig r10, ContentLengthStrategy r11, ContentLengthStrategy r12, HttpMessageWriterFactory<HttpRequest> r13, HttpMessageParserFactory<HttpResponse> r14) {
        if (r10 != null) goto L6;
        r10 = ConnectionConfig.DEFAULT;
    L6:
        this.cconfig = r10;
        this.incomingContentStrategy = r11;
        this.outgoingContentStrategy = r12;
        this.requestWriterFactory = r13;
        this.responseParserFactory = r14;
    }

    @Override // org.apache.http.HttpConnectionFactory
    public /* bridge */ /* synthetic */ HttpConnection createConnection(Socket r10) throws IOException {
        return createConnection(r10);
    }

    @Override // org.apache.http.HttpConnectionFactory
    public DefaultBHttpClientConnection createConnection(Socket r12) throws IOException {
        DefaultBHttpClientConnection r10 = new DefaultBHttpClientConnection(this.cconfig.getBufferSize(), this.cconfig.getFragmentSizeHint(), ConnSupport.createDecoder(this.cconfig), ConnSupport.createEncoder(this.cconfig), this.cconfig.getMessageConstraints(), this.incomingContentStrategy, this.outgoingContentStrategy, this.requestWriterFactory, this.responseParserFactory);
        r10.bind(r12);
        return r10;
    }

    public DefaultBHttpClientConnectionFactory(ConnectionConfig r10, HttpMessageWriterFactory<HttpRequest> r11, HttpMessageParserFactory<HttpResponse> r12) {
        this(r10, null, null, r11, r12);
    }

    public DefaultBHttpClientConnectionFactory(ConnectionConfig r10) {
        this(r10, null, null, null, null);
    }

    public DefaultBHttpClientConnectionFactory() {
        this(null, null, null, null, null);
    }
}
