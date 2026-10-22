package org.apache.http.impl.io;

import org.apache.http.HttpResponse;
import org.apache.http.HttpResponseFactory;
import org.apache.http.annotation.Contract;
import org.apache.http.annotation.ThreadingBehavior;
import org.apache.http.config.MessageConstraints;
import org.apache.http.impl.DefaultHttpResponseFactory;
import org.apache.http.io.HttpMessageParser;
import org.apache.http.io.HttpMessageParserFactory;
import org.apache.http.io.SessionInputBuffer;
import org.apache.http.message.BasicLineParser;
import org.apache.http.message.LineParser;

/* JADX INFO: loaded from: classes4.dex */
@Contract(threading = ThreadingBehavior.IMMUTABLE_CONDITIONAL)
public class DefaultHttpResponseParserFactory implements HttpMessageParserFactory<HttpResponse> {
    public static final DefaultHttpResponseParserFactory INSTANCE = null;
    private final LineParser lineParser;
    private final HttpResponseFactory responseFactory;

    static {
        INSTANCE = new DefaultHttpResponseParserFactory();
    }

    public DefaultHttpResponseParserFactory(LineParser r10, HttpResponseFactory r11) {
        if (r10 != null) goto L6;
        r10 = BasicLineParser.INSTANCE;
    L6:
        this.lineParser = r10;
        if (r11 != null) goto L10;
        r11 = DefaultHttpResponseFactory.INSTANCE;
    L10:
        this.responseFactory = r11;
    }

    @Override // org.apache.http.io.HttpMessageParserFactory
    public HttpMessageParser<HttpResponse> create(SessionInputBuffer r10, MessageConstraints r11) {
        return new DefaultHttpResponseParser(r10, this.lineParser, this.responseFactory, r11);
    }

    public DefaultHttpResponseParserFactory() {
        this(null, null);
    }
}
