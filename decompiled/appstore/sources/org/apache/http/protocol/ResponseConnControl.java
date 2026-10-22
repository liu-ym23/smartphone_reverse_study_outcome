package org.apache.http.protocol;

import java.io.IOException;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpException;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.HttpResponseInterceptor;
import org.apache.http.HttpVersion;
import org.apache.http.ProtocolVersion;
import org.apache.http.annotation.Contract;
import org.apache.http.annotation.ThreadingBehavior;
import org.apache.http.util.Args;

/* JADX INFO: loaded from: classes4.dex */
@Contract(threading = ThreadingBehavior.IMMUTABLE)
public class ResponseConnControl implements HttpResponseInterceptor {
    public ResponseConnControl() {
    }

    @Override // org.apache.http.HttpResponseInterceptor
    public void process(HttpResponse r10, HttpContext r11) throws HttpException, IOException {
        Args.notNull(r10, "HTTP response");
        HttpCoreContext r12 = HttpCoreContext.adapt(r11);
        int r13 = r10.getStatusLine().getStatusCode();
        if (r13 != 400) goto L5;
    L41:
        r10.setHeader("Connection", HTTP.CONN_CLOSE);
        return;
    L5:
        if (r13 == 408) goto L41;
        if (r13 == 411) goto L41;
        if (r13 == 413) goto L41;
        if (r13 == 414) goto L41;
        if (r13 == 503) goto L41;
        if (r13 == 501) goto L41;
        Header r14 = r10.getFirstHeader("Connection");
        if (r14 != null) goto L20;
    L22:
        HttpEntity r15 = r10.getEntity();
        if (r15 == null) goto L32;
        ProtocolVersion r16 = r10.getStatusLine().getProtocolVersion();
        if (r15.getContentLength() >= 0) goto L32;
        if (r15.isChunked() == true) goto L29;
    L30:
        r10.setHeader("Connection", HTTP.CONN_CLOSE);
        return;
    L29:
        if (r16.lessEquals(HttpVersion.HTTP_1_0) == true) goto L30;
    L32:
        HttpRequest r17 = r12.getRequest();
        if (r17 == null) goto L43;
        Header r18 = r17.getFirstHeader("Connection");
        if (r18 == null) goto L38;
        r10.setHeader("Connection", r18.getValue());
        return;
    L38:
        if (r17.getProtocolVersion().lessEquals(HttpVersion.HTTP_1_0) == false) goto L45;
        r10.setHeader("Connection", HTTP.CONN_CLOSE);
        return;
    L45:
        return;
    L43:
        return;
    L20:
        if (HTTP.CONN_CLOSE.equalsIgnoreCase(r14.getValue()) == false) goto L22;
    }
}
