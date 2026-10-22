package org.apache.http.protocol;

import java.io.IOException;
import org.apache.http.HttpException;
import org.apache.http.HttpResponse;
import org.apache.http.HttpResponseInterceptor;
import org.apache.http.annotation.Contract;
import org.apache.http.annotation.ThreadingBehavior;
import org.apache.http.util.Args;

/* JADX INFO: loaded from: classes4.dex */
@Contract(threading = ThreadingBehavior.IMMUTABLE)
public class ResponseServer implements HttpResponseInterceptor {
    private final String originServer;

    public ResponseServer(String r10) {
        this.originServer = r10;
    }

    @Override // org.apache.http.HttpResponseInterceptor
    public void process(HttpResponse r10, HttpContext r11) throws HttpException, IOException {
        Args.notNull(r10, "HTTP response");
        if (r10.containsHeader("Server") == true) goto L8;
        String r12 = this.originServer;
        if (r12 == null) goto L9;
        r10.addHeader("Server", r12);
        return;
    L9:
        return;
    }

    public ResponseServer() {
        this(null);
    }
}
