package org.apache.http.protocol;

import com.bytedanceos.common.ad.param.AdReportParam;
import java.io.IOException;
import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpException;
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
public class RequestContent implements HttpRequestInterceptor {
    private final boolean overwrite;

    public RequestContent() {
        this(false);
    }

    @Override // org.apache.http.HttpRequestInterceptor
    public void process(HttpRequest r10, HttpContext r11) throws HttpException, IOException {
        Args.notNull(r10, "HTTP request");
        if ((r10 instanceof HttpEntityEnclosingRequest) == true) goto L5;
        return;
    L5:
        if (this.overwrite == false) goto L8;
        r10.removeHeaders("Transfer-Encoding");
        r10.removeHeaders("Content-Length");
    L11:
        ProtocolVersion r12 = r10.getRequestLine().getProtocolVersion();
        HttpEntity r13 = ((HttpEntityEnclosingRequest) r10).getEntity();
        if (r13 != null) goto L16;
        r10.addHeader("Content-Length", AdReportParam.ClickPosType.SKIP);
        return;
    L16:
        if (r13.isChunked() == true) goto L22;
        if (r13.getContentLength() < 0) goto L22;
        r10.addHeader("Content-Length", Long.toString(r13.getContentLength()));
    L25:
        if (r13.getContentType() == null) goto L30;
        if (r10.containsHeader("Content-Type") == true) goto L30;
        r10.addHeader(r13.getContentType());
    L30:
        if (r13.getContentEncoding() != null) goto L32;
        return;
    L32:
        if (r10.containsHeader("Content-Encoding") == true) goto L42;
        r10.addHeader(r13.getContentEncoding());
        return;
    L42:
        return;
    L22:
        if (r12.lessEquals(HttpVersion.HTTP_1_0) == true) goto L35;
        r10.addHeader("Transfer-Encoding", HTTP.CHUNK_CODING);
        goto L25
    L35:
        throw new ProtocolException("Chunked transfer encoding not allowed for " + r12);
    L8:
        if (r10.containsHeader("Transfer-Encoding") == true) goto L39;
        if (r10.containsHeader("Content-Length") == false) goto L11;
        throw new ProtocolException("Content-Length header already present");
    L39:
        throw new ProtocolException("Transfer-encoding header already present");
    }

    public RequestContent(boolean r10) {
        this.overwrite = r10;
    }
}
