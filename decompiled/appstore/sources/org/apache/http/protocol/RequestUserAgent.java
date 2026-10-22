package org.apache.http.protocol;

import java.io.IOException;
import org.apache.http.HttpException;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.annotation.Contract;
import org.apache.http.annotation.ThreadingBehavior;
import org.apache.http.params.HttpParams;
import org.apache.http.util.Args;

/* JADX INFO: loaded from: classes4.dex */
@Contract(threading = ThreadingBehavior.IMMUTABLE)
public class RequestUserAgent implements HttpRequestInterceptor {
    private final String userAgent;

    public RequestUserAgent(String r10) {
        this.userAgent = r10;
    }

    @Override // org.apache.http.HttpRequestInterceptor
    public void process(HttpRequest r10, HttpContext r11) throws HttpException, IOException {
        Args.notNull(r10, "HTTP request");
        if (r10.containsHeader("User-Agent") == true) goto L13;
        HttpParams r12 = r10.getParams();
        if (r12 == null) goto L7;
        String r13 = (String) r12.getParameter("http.useragent");
    L8:
        if (r13 != null) goto L10;
        r13 = this.userAgent;
    L10:
        if (r13 == null) goto L14;
        r10.addHeader("User-Agent", r13);
        return;
    L14:
        return;
    L7:
        r13 = null;
        goto L8
    }

    public RequestUserAgent() {
        this(null);
    }
}
