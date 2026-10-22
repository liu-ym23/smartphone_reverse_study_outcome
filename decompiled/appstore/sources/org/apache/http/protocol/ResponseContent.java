package org.apache.http.protocol;

import com.bytedanceos.common.ad.param.AdReportParam;
import java.io.IOException;
import org.apache.http.HttpEntity;
import org.apache.http.HttpException;
import org.apache.http.HttpResponse;
import org.apache.http.HttpResponseInterceptor;
import org.apache.http.HttpVersion;
import org.apache.http.ProtocolException;
import org.apache.http.ProtocolVersion;
import org.apache.http.annotation.Contract;
import org.apache.http.annotation.ThreadingBehavior;
import org.apache.http.util.Args;

/* JADX INFO: loaded from: classes4.dex */
@Contract(threading = ThreadingBehavior.IMMUTABLE)
public class ResponseContent implements HttpResponseInterceptor {
    private final boolean overwrite;

    public ResponseContent() {
        this(false);
    }

    @Override // org.apache.http.HttpResponseInterceptor
    public void process(HttpResponse r10, HttpContext r11) throws HttpException, IOException {
        Args.notNull(r10, "HTTP response");
        if (this.overwrite == false) goto L6;
        r10.removeHeaders("Transfer-Encoding");
        r10.removeHeaders("Content-Length");
    L9:
        ProtocolVersion r12 = r10.getStatusLine().getProtocolVersion();
        HttpEntity r13 = r10.getEntity();
        if (r13 == null) goto L29;
        long r14 = r13.getContentLength();
        if (r13.isChunked() == false) goto L17;
        if (r12.lessEquals(HttpVersion.HTTP_1_0) == true) goto L17;
        r10.addHeader("Transfer-Encoding", HTTP.CHUNK_CODING);
    L20:
        if (r13.getContentType() == null) goto L25;
        if (r10.containsHeader("Content-Type") == true) goto L25;
        r10.addHeader(r13.getContentType());
    L25:
        if (r13.getContentEncoding() != null) goto L27;
        return;
    L27:
        if (r10.containsHeader("Content-Encoding") == true) goto L42;
        r10.addHeader(r13.getContentEncoding());
        return;
    L42:
        return;
    L17:
        if (r14 < 0) goto L20;
        r10.addHeader("Content-Length", Long.toString(r13.getContentLength()));
        goto L20
    L29:
        int r15 = r10.getStatusLine().getStatusCode();
        if (r15 != 204) goto L32;
        return;
    L32:
        if (r15 != 304) goto L34;
        return;
    L34:
        if (r15 == 205) goto L46;
        r10.addHeader("Content-Length", AdReportParam.ClickPosType.SKIP);
        return;
    L46:
        return;
    L6:
        if (r10.containsHeader("Transfer-Encoding") == true) goto L40;
        if (r10.containsHeader("Content-Length") == false) goto L9;
        throw new ProtocolException("Content-Length header already present");
    L40:
        throw new ProtocolException("Transfer-encoding header already present");
    }

    public ResponseContent(boolean r10) {
        this.overwrite = r10;
    }
}
