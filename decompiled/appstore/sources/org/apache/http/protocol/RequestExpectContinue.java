package org.apache.http.protocol;

import java.io.IOException;
import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpException;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.HttpVersion;
import org.apache.http.ProtocolVersion;
import org.apache.http.annotation.Contract;
import org.apache.http.annotation.ThreadingBehavior;
import org.apache.http.util.Args;

/* JADX INFO: loaded from: classes4.dex */
@Contract(threading = ThreadingBehavior.IMMUTABLE)
public class RequestExpectContinue implements HttpRequestInterceptor {
    private final boolean activeByDefault;

    @Deprecated
    public RequestExpectContinue() {
        this(false);
    }

    @Override // org.apache.http.HttpRequestInterceptor
    public void process(HttpRequest r10, HttpContext r11) throws HttpException, IOException {
        Args.notNull(r10, "HTTP request");
        if (r10.containsHeader("Expect") == false) goto L5;
        return;
    L5:
        if ((r10 instanceof HttpEntityEnclosingRequest) == false) goto L17;
        ProtocolVersion r12 = r10.getRequestLine().getProtocolVersion();
        HttpEntity r13 = ((HttpEntityEnclosingRequest) r10).getEntity();
        if (r13 != null) goto L9;
        return;
    L9:
        if (r13.getContentLength() != 0) goto L11;
        return;
    L11:
        if (r12.lessEquals(HttpVersion.HTTP_1_0) == false) goto L13;
        return;
    L13:
        if (r10.getParams().getBooleanParameter("http.protocol.expect-continue", this.activeByDefault) == false) goto L21;
        r10.addHeader("Expect", HTTP.EXPECT_CONTINUE);
        return;
    L21:
        return;
    }

    public RequestExpectContinue(boolean r10) {
        this.activeByDefault = r10;
    }
}
