package org.apache.http.impl.entity;

import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.HttpException;
import org.apache.http.HttpMessage;
import org.apache.http.ParseException;
import org.apache.http.ProtocolException;
import org.apache.http.annotation.Contract;
import org.apache.http.annotation.ThreadingBehavior;
import org.apache.http.entity.ContentLengthStrategy;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.Args;

/* JADX INFO: loaded from: classes4.dex */
@Contract(threading = ThreadingBehavior.IMMUTABLE)
public class LaxContentLengthStrategy implements ContentLengthStrategy {
    public static final LaxContentLengthStrategy INSTANCE = null;
    private final int implicitLen;

    static {
        INSTANCE = new LaxContentLengthStrategy();
    }

    public LaxContentLengthStrategy(int r10) {
        this.implicitLen = r10;
    }

    @Override // org.apache.http.entity.ContentLengthStrategy
    public long determineLength(HttpMessage r10) throws HttpException {
        Args.notNull(r10, "HTTP message");
        Header r11 = r10.getFirstHeader("Transfer-Encoding");
        if (r11 == null) goto L18;
        HeaderElement[] r12 = r11.getElements();     // Catch: ParseException -> L14
        int r13 = r12.length;
        if ("identity".equalsIgnoreCase(r11.getValue()) == false) goto L8;
        return -1;
    L8:
        if (r13 > 0) goto L10;
    L13:
        return -1;
    L10:
        if (HTTP.CHUNK_CODING.equalsIgnoreCase(r12[r13 - 1].getName()) == false) goto L13;
        return -2;
    L14:
        e = move-exception;
        throw new ProtocolException("Invalid Transfer-Encoding header value: " + r11, e);
    L18:
        if (r10.getFirstHeader("Content-Length") == null) goto L31;
        Header[] r14 = r10.getHeaders("Content-Length");
        int r15 = r14.length - 1;
    L20:
        if (r15 < 0) goto L25;
        long r16 = Long.parseLong(r14[r15].getValue());     // Catch: NumberFormatException -> L24
    L27:
        if (r16 >= 0) goto L29;
        return -1;
    L29:
        return r16;
    L24:
        r15 = r15 - 1;
        goto L20
    L25:
        r16 = -1;
        goto L27
    L31:
        return this.implicitLen;
    }

    public LaxContentLengthStrategy() {
        this(-1);
    }
}
