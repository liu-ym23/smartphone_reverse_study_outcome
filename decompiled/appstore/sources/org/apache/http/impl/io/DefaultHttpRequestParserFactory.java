package org.apache.http.impl.io;

import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestFactory;
import org.apache.http.annotation.Contract;
import org.apache.http.annotation.ThreadingBehavior;
import org.apache.http.config.MessageConstraints;
import org.apache.http.impl.DefaultHttpRequestFactory;
import org.apache.http.io.HttpMessageParser;
import org.apache.http.io.HttpMessageParserFactory;
import org.apache.http.io.SessionInputBuffer;
import org.apache.http.message.BasicLineParser;
import org.apache.http.message.LineParser;

/* JADX INFO: loaded from: classes4.dex */
@Contract(threading = ThreadingBehavior.IMMUTABLE_CONDITIONAL)
public class DefaultHttpRequestParserFactory implements HttpMessageParserFactory<HttpRequest> {
    public static final DefaultHttpRequestParserFactory INSTANCE = null;
    private final LineParser lineParser;
    private final HttpRequestFactory requestFactory;

    static {
        INSTANCE = new DefaultHttpRequestParserFactory();
    }

    public DefaultHttpRequestParserFactory(LineParser r10, HttpRequestFactory r11) {
        if (r10 != null) goto L6;
        r10 = BasicLineParser.INSTANCE;
    L6:
        this.lineParser = r10;
        if (r11 != null) goto L10;
        r11 = DefaultHttpRequestFactory.INSTANCE;
    L10:
        this.requestFactory = r11;
    }

    @Override // org.apache.http.io.HttpMessageParserFactory
    public HttpMessageParser<HttpRequest> create(SessionInputBuffer r10, MessageConstraints r11) {
        return new DefaultHttpRequestParser(r10, this.lineParser, this.requestFactory, r11);
    }

    public DefaultHttpRequestParserFactory() {
        this(null, null);
    }
}
