package org.apache.http.impl.entity;

import org.apache.http.Header;
import org.apache.http.HttpException;
import org.apache.http.HttpMessage;
import org.apache.http.HttpVersion;
import org.apache.http.ProtocolException;
import org.apache.http.annotation.Contract;
import org.apache.http.annotation.ThreadingBehavior;
import org.apache.http.entity.ContentLengthStrategy;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.Args;

/* JADX INFO: loaded from: classes4.dex */
@Contract(threading = ThreadingBehavior.IMMUTABLE)
public class StrictContentLengthStrategy implements ContentLengthStrategy {
    public static final StrictContentLengthStrategy INSTANCE = null;
    private final int implicitLen;

    static {
        INSTANCE = new StrictContentLengthStrategy();
    }

    public StrictContentLengthStrategy(int r10) {
        this.implicitLen = r10;
    }

    @Override // org.apache.http.entity.ContentLengthStrategy
    public long determineLength(HttpMessage r10) throws HttpException {
        Args.notNull(r10, "HTTP message");
        Header r11 = r10.getFirstHeader("Transfer-Encoding");
        if (r11 == null) goto L18;
        String r12 = r11.getValue();
        if (HTTP.CHUNK_CODING.equalsIgnoreCase(r12) == false) goto L13;
        if (r10.getProtocolVersion().lessEquals(HttpVersion.HTTP_1_0) == true) goto L11;
        return -2;
    L11:
        throw new ProtocolException("Chunked transfer encoding not allowed for " + r10.getProtocolVersion());
    L13:
        if ("identity".equalsIgnoreCase(r12) == false) goto L17;
        return -1;
    L17:
        throw new ProtocolException("Unsupported transfer encoding: " + r12);
    L18:
        Header r13 = r10.getFirstHeader("Content-Length");
        if (r13 == null) goto L29;
        String r14 = r13.getValue();
        long r15 = Long.parseLong(r14);     // Catch: NumberFormatException -> L26
        if (r15 < 0) goto L25;
        return r15;
    L25:
        throw new ProtocolException("Negative content length: " + r14);     // Catch: NumberFormatException -> L26
    L27:
        throw new ProtocolException("Invalid content length: " + r14);
    L29:
        return this.implicitLen;
    }

    public StrictContentLengthStrategy() {
        this(-1);
    }
}
