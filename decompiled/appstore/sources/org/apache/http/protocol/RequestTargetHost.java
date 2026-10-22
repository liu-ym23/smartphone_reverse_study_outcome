package org.apache.http.protocol;

import java.io.IOException;
import java.net.InetAddress;
import org.apache.http.HttpConnection;
import org.apache.http.HttpException;
import org.apache.http.HttpHost;
import org.apache.http.HttpInetConnection;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.HttpVersion;
import org.apache.http.ProtocolException;
import org.apache.http.ProtocolVersion;
import org.apache.http.annotation.Contract;
import org.apache.http.annotation.ThreadingBehavior;
import org.apache.http.util.Args;

/* JADX INFO: loaded from: classes4.dex */
@Contract(threading = ThreadingBehavior.IMMUTABLE)
public class RequestTargetHost implements HttpRequestInterceptor {
    public RequestTargetHost() {
    }

    @Override // org.apache.http.HttpRequestInterceptor
    public void process(HttpRequest r10, HttpContext r11) throws HttpException, IOException {
        Args.notNull(r10, "HTTP request");
        HttpCoreContext r12 = HttpCoreContext.adapt(r11);
        ProtocolVersion r13 = r10.getRequestLine().getProtocolVersion();
        if (r10.getRequestLine().getMethod().equalsIgnoreCase("CONNECT") == false) goto L8;
        if (r13.lessEquals(HttpVersion.HTTP_1_0) == false) goto L8;
        return;
    L8:
        if (r10.containsHeader("Host") == true) goto L24;
        HttpHost r14 = r12.getTargetHost();
        if (r14 != null) goto L22;
        HttpConnection r15 = r12.getConnection();
        if ((r15 instanceof HttpInetConnection) == false) goto L16;
        HttpInetConnection r16 = (HttpInetConnection) r15;
        InetAddress r17 = r16.getRemoteAddress();
        int r18 = r16.getRemotePort();
        if (r17 == null) goto L16;
        r14 = new HttpHost(r17.getHostName(), r18);
    L16:
        if (r14 != null) goto L22;
        if (r13.lessEquals(HttpVersion.HTTP_1_0) == false) goto L21;
        return;
    L21:
        throw new ProtocolException("Target host missing");
    L22:
        r10.addHeader("Host", r14.toHostString());
        return;
    }
}
