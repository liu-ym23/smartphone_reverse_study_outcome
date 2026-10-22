package org.apache.http.protocol;

import java.io.IOException;
import org.apache.http.HttpException;
import org.apache.http.HttpResponse;
import org.apache.http.HttpResponseInterceptor;
import org.apache.http.annotation.Contract;
import org.apache.http.annotation.ThreadingBehavior;
import org.apache.http.util.Args;

/* JADX INFO: loaded from: classes4.dex */
@Contract(threading = ThreadingBehavior.SAFE)
public class ResponseDate implements HttpResponseInterceptor {
    private static final HttpDateGenerator DATE_GENERATOR = null;

    static {
        DATE_GENERATOR = new HttpDateGenerator();
    }

    public ResponseDate() {
    }

    @Override // org.apache.http.HttpResponseInterceptor
    public void process(HttpResponse r10, HttpContext r11) throws HttpException, IOException {
        Args.notNull(r10, "HTTP response");
        if (r10.getStatusLine().getStatusCode() >= 200) goto L5;
        return;
    L5:
        if (r10.containsHeader("Date") == true) goto L9;
        r10.setHeader("Date", DATE_GENERATOR.getCurrentDate());
        return;
    }
}
