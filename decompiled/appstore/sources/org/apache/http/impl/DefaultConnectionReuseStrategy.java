package org.apache.http.impl;

import org.apache.http.ConnectionReuseStrategy;
import org.apache.http.Header;
import org.apache.http.HeaderIterator;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.ParseException;
import org.apache.http.ProtocolVersion;
import org.apache.http.TokenIterator;
import org.apache.http.annotation.Contract;
import org.apache.http.annotation.ThreadingBehavior;
import org.apache.http.message.BasicTokenIterator;
import org.apache.http.protocol.HTTP;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.Args;

/* JADX INFO: loaded from: classes4.dex */
@Contract(threading = ThreadingBehavior.IMMUTABLE)
public class DefaultConnectionReuseStrategy implements ConnectionReuseStrategy {
    public static final DefaultConnectionReuseStrategy INSTANCE = null;

    static {
        INSTANCE = new DefaultConnectionReuseStrategy();
    }

    public DefaultConnectionReuseStrategy() {
    }

    private boolean canResponseHaveBody(HttpRequest r10, HttpResponse r11) {
        if (r10 != null) goto L5;
    L7:
        int r12 = r11.getStatusLine().getStatusCode();
        if (r12 >= 200) goto L10;
        return false;
    L10:
        if (r12 != 204) goto L12;
        return false;
    L12:
        if (r12 != 304) goto L14;
        return false;
    L14:
        if (r12 == 205) goto L20;
        return true;
    L20:
        return false;
    L5:
        if (r10.getRequestLine().getMethod().equalsIgnoreCase("HEAD") == false) goto L7;
        return false;
    }

    public TokenIterator createTokenIterator(HeaderIterator r10) {
        return new BasicTokenIterator(r10);
    }

    @Override // org.apache.http.ConnectionReuseStrategy
    public boolean keepAlive(HttpResponse r10, HttpContext r11) {
        Args.notNull(r10, "HTTP response");
        Args.notNull(r11, "HTTP context");
        if (r10.getStatusLine().getStatusCode() != 204) goto L12;
        Header r12 = r10.getFirstHeader("Content-Length");
        if (r12 == null) goto L10;
        if (Integer.parseInt(r12.getValue()) <= 0) goto L10;
        return false;
    L10:
        if (r10.getFirstHeader("Transfer-Encoding") == null) goto L12;
        return false;
    L12:
        HttpRequest r13 = (HttpRequest) r11.getAttribute("http.request");
        if (r13 != null) goto L59;
    L20:
        ProtocolVersion r14 = r10.getStatusLine().getProtocolVersion();
        Header r15 = r10.getFirstHeader("Transfer-Encoding");
        if (r15 == null) goto L26;
        if (HTTP.CHUNK_CODING.equalsIgnoreCase(r15.getValue()) == true) goto L33;
        return false;
    L33:
        HeaderIterator r16 = r10.headerIterator("Connection");
        if (r16.hasNext() == true) goto L37;
        r16 = r10.headerIterator("Proxy-Connection");
    L37:
        if (r16.hasNext() == false) goto L51;
        BasicTokenIterator r17 = new BasicTokenIterator(r16);     // Catch: ParseException -> L49
        boolean r18 = false;
    L40:
        if (r17.hasNext() == false) goto L47;
        String r19 = r17.nextToken();     // Catch: ParseException -> L49
        if (HTTP.CONN_CLOSE.equalsIgnoreCase(r19) == true) goto L43;
        if (HTTP.CONN_KEEP_ALIVE.equalsIgnoreCase(r19) == false) goto L40;
        r18 = true;
        goto L40
    L43:
        return false;
    L47:
        if (r18 == false) goto L51;
        return true;
    L49:
        return false;
    L51:
        return !r14.lessEquals(HttpVersion.HTTP_1_0);
    L26:
        if (canResponseHaveBody(r13, r10) == false) goto L33;
        Header[] r20 = r10.getHeaders("Content-Length");
        if (r20.length == 1) goto L57;
    L32:
        return false;
    L57:
        if (Integer.parseInt(r20[0].getValue()) >= 0) goto L33;
    L59:
        BasicTokenIterator r21 = new BasicTokenIterator(r13.headerIterator("Connection"));     // Catch: ParseException -> L54
    L16:
        if (r21.hasNext() == false) goto L20;
        if (HTTP.CONN_CLOSE.equalsIgnoreCase(r21.nextToken()) == false) goto L16;
    L19:
        return false;
    }
}
