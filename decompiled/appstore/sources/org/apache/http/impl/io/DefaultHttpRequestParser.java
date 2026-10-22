package org.apache.http.impl.io;

import java.io.IOException;
import org.apache.http.ConnectionClosedException;
import org.apache.http.HttpException;
import org.apache.http.HttpMessage;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestFactory;
import org.apache.http.ParseException;
import org.apache.http.RequestLine;
import org.apache.http.config.MessageConstraints;
import org.apache.http.impl.DefaultHttpRequestFactory;
import org.apache.http.io.SessionInputBuffer;
import org.apache.http.message.LineParser;
import org.apache.http.message.ParserCursor;
import org.apache.http.params.HttpParams;
import org.apache.http.util.Args;
import org.apache.http.util.CharArrayBuffer;

/* JADX INFO: loaded from: classes4.dex */
public class DefaultHttpRequestParser extends AbstractMessageParser<HttpRequest> {
    private final CharArrayBuffer lineBuf;
    private final HttpRequestFactory requestFactory;

    @Deprecated
    public DefaultHttpRequestParser(SessionInputBuffer r10, LineParser r11, HttpRequestFactory r12, HttpParams r13) {
        super(r10, r11, r13);
        this.requestFactory = (HttpRequestFactory) Args.notNull(r12, "Request factory");
        this.lineBuf = new CharArrayBuffer(128);
    }

    @Override // org.apache.http.impl.io.AbstractMessageParser
    public /* bridge */ /* synthetic */ HttpMessage parseHead(SessionInputBuffer r10) throws IOException, HttpException, ParseException {
        return parseHead(r10);
    }

    @Override // org.apache.http.impl.io.AbstractMessageParser
    public HttpRequest parseHead(SessionInputBuffer r10) throws IOException, HttpException, ParseException {
        this.lineBuf.clear();
        if (r10.readLine(this.lineBuf) == (-1)) goto L7;
        ParserCursor r11 = new ParserCursor(0, this.lineBuf.length());
        RequestLine r12 = this.lineParser.parseRequestLine(this.lineBuf, r11);
        return this.requestFactory.newHttpRequest(r12);
    L7:
        throw new ConnectionClosedException("Client closed connection");
    }

    public DefaultHttpRequestParser(SessionInputBuffer r10, LineParser r11, HttpRequestFactory r12, MessageConstraints r13) {
        super(r10, r11, r13);
        if (r12 != null) goto L6;
        r12 = DefaultHttpRequestFactory.INSTANCE;
    L6:
        this.requestFactory = r12;
        this.lineBuf = new CharArrayBuffer(128);
    }

    public DefaultHttpRequestParser(SessionInputBuffer r10, MessageConstraints r11) {
        this(r10, null, null, r11);
    }

    public DefaultHttpRequestParser(SessionInputBuffer r10) {
        this(r10, null, null, MessageConstraints.DEFAULT);
    }
}
