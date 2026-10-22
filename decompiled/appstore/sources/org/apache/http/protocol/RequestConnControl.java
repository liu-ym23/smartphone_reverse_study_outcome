package org.apache.http.protocol;

import java.io.IOException;
import org.apache.http.HttpException;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.annotation.Contract;
import org.apache.http.annotation.ThreadingBehavior;
import org.apache.http.util.Args;

/* JADX INFO: loaded from: classes4.dex */
@Contract(threading = ThreadingBehavior.IMMUTABLE)
public class RequestConnControl implements HttpRequestInterceptor {
    public RequestConnControl() {
    }

    @Override // org.apache.http.HttpRequestInterceptor
    public void process(HttpRequest r10, HttpContext r11) throws HttpException, IOException {
        Args.notNull(r10, "HTTP request");
        if (r10.getRequestLine().getMethod().equalsIgnoreCase("CONNECT") == false) goto L6;
        return;
    L6:
        if (r10.containsHeader("Connection") == true) goto L9;
        r10.addHeader("Connection", HTTP.CONN_KEEP_ALIVE);
        return;
    }
}
