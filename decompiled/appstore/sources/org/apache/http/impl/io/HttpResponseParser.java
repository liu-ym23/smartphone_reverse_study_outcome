package org.apache.http.impl.io;

import java.io.IOException;
import org.apache.http.HttpException;
import org.apache.http.HttpMessage;
import org.apache.http.HttpResponseFactory;
import org.apache.http.NoHttpResponseException;
import org.apache.http.ParseException;
import org.apache.http.StatusLine;
import org.apache.http.io.SessionInputBuffer;
import org.apache.http.message.LineParser;
import org.apache.http.message.ParserCursor;
import org.apache.http.params.HttpParams;
import org.apache.http.util.Args;
import org.apache.http.util.CharArrayBuffer;

/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public class HttpResponseParser extends AbstractMessageParser<HttpMessage> {
    private final CharArrayBuffer lineBuf;
    private final HttpResponseFactory responseFactory;

    public HttpResponseParser(SessionInputBuffer r10, LineParser r11, HttpResponseFactory r12, HttpParams r13) {
        super(r10, r11, r13);
        this.responseFactory = (HttpResponseFactory) Args.notNull(r12, "Response factory");
        this.lineBuf = new CharArrayBuffer(128);
    }

    @Override // org.apache.http.impl.io.AbstractMessageParser
    public HttpMessage parseHead(SessionInputBuffer r10) throws IOException, HttpException, ParseException {
        this.lineBuf.clear();
        if (r10.readLine(this.lineBuf) == (-1)) goto L7;
        ParserCursor r11 = new ParserCursor(0, this.lineBuf.length());
        StatusLine r12 = this.lineParser.parseStatusLine(this.lineBuf, r11);
        return this.responseFactory.newHttpResponse(r12, null);
    L7:
        throw new NoHttpResponseException("The target server failed to respond");
    }
}
