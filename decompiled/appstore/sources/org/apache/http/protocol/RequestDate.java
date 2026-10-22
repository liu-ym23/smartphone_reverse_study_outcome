package org.apache.http.protocol;

import java.io.IOException;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpException;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.annotation.Contract;
import org.apache.http.annotation.ThreadingBehavior;
import org.apache.http.util.Args;

/* JADX INFO: loaded from: classes4.dex */
@Contract(threading = ThreadingBehavior.SAFE)
public class RequestDate implements HttpRequestInterceptor {
    private static final HttpDateGenerator DATE_GENERATOR = null;

    static {
        DATE_GENERATOR = new HttpDateGenerator();
    }

    public RequestDate() {
    }

    @Override // org.apache.http.HttpRequestInterceptor
    public void process(HttpRequest r10, HttpContext r11) throws HttpException, IOException {
        Args.notNull(r10, "HTTP request");
        if ((r10 instanceof HttpEntityEnclosingRequest) == true) goto L5;
        return;
    L5:
        if (r10.containsHeader("Date") == true) goto L9;
        r10.setHeader("Date", DATE_GENERATOR.getCurrentDate());
        return;
    }
}
