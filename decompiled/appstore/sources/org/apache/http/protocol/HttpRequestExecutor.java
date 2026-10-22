package org.apache.http.protocol;

import java.io.IOException;
import org.apache.http.HttpClientConnection;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpException;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.ProtocolException;
import org.apache.http.ProtocolVersion;
import org.apache.http.annotation.Contract;
import org.apache.http.annotation.ThreadingBehavior;
import org.apache.http.util.Args;

/* JADX INFO: loaded from: classes4.dex */
@Contract(threading = ThreadingBehavior.IMMUTABLE)
public class HttpRequestExecutor {
    public static final int DEFAULT_WAIT_FOR_CONTINUE = 3000;
    private final int waitForContinue;

    public HttpRequestExecutor(int r10) {
        this.waitForContinue = Args.positive(r10, "Wait for continue time");
    }

    private static void closeConnection(HttpClientConnection r10) {
        r10.close();     // Catch: IOException -> L4
        return;
    }

    public boolean canResponseHaveBody(HttpRequest r10, HttpResponse r11) {
        if ("HEAD".equalsIgnoreCase(r10.getRequestLine().getMethod()) == false) goto L5;
        return false;
    L5:
        int r12 = r11.getStatusLine().getStatusCode();
        if (r12 >= 200) goto L8;
        return false;
    L8:
        if (r12 != 204) goto L10;
        return false;
    L10:
        if (r12 != 304) goto L12;
        return false;
    L12:
        if (r12 == 205) goto L18;
        return true;
    L18:
        return false;
    }

    public HttpResponse doReceiveResponse(HttpRequest r10, HttpClientConnection r11, HttpContext r12) throws HttpException, IOException {
        Args.notNull(r10, "HTTP request");
        Args.notNull(r11, "Client connection");
        Args.notNull(r12, "HTTP context");
        HttpResponse r13 = null;
        int r14 = 0;
    L3:
        if (r13 != null) goto L5;
    L8:
        r13 = r11.receiveResponseHeader();
        r14 = r13.getStatusLine().getStatusCode();
        if (r14 < 100) goto L14;
        if (canResponseHaveBody(r10, r13) == false) goto L3;
        r11.receiveResponseEntity(r13);
        goto L3
    L14:
        throw new ProtocolException("Invalid response: " + r13.getStatusLine());
    L5:
        if (r14 < 200) goto L8;
        return r13;
    }

    public HttpResponse doSendRequest(HttpRequest r10, HttpClientConnection r11, HttpContext r12) throws IOException, HttpException {
        Args.notNull(r10, "HTTP request");
        Args.notNull(r11, "Client connection");
        Args.notNull(r12, "HTTP context");
        r12.setAttribute("http.connection", r11);
        r12.setAttribute("http.request_sent", Boolean.FALSE);
        r11.sendRequestHeader(r10);
        HttpResponse r13 = null;
        if ((r10 instanceof HttpEntityEnclosingRequest) == false) goto L23;
        ProtocolVersion r14 = r10.getRequestLine().getProtocolVersion();
        HttpEntityEnclosingRequest r15 = (HttpEntityEnclosingRequest) r10;
        boolean r16 = true;
        if (r15.expectContinue() == true) goto L7;
    L21:
        if (r16 == false) goto L23;
        r11.sendRequestEntity(r15);
        goto L23
    L7:
        if (r14.lessEquals(HttpVersion.HTTP_1_0) == true) goto L21;
        r11.flush();
        if (r11.isResponseAvailable(this.waitForContinue) == false) goto L21;
        HttpResponse r17 = r11.receiveResponseHeader();
        if (canResponseHaveBody(r10, r17) == false) goto L13;
        r11.receiveResponseEntity(r17);
    L13:
        int r18 = r17.getStatusLine().getStatusCode();
        if (r18 < 200) goto L16;
        r16 = false;
        r13 = r17;
        goto L21
    L16:
        if (r18 == 100) goto L21;
        throw new ProtocolException("Unexpected response: " + r17.getStatusLine());
    L23:
        r11.flush();
        r12.setAttribute("http.request_sent", Boolean.TRUE);
        return r13;
    }

    public HttpResponse execute(HttpRequest r10, HttpClientConnection r11, HttpContext r12) throws IOException, HttpException {
        Args.notNull(r10, "HTTP request");
        Args.notNull(r11, "Client connection");
        Args.notNull(r12, "HTTP context");
        HttpResponse r13 = doSendRequest(r10, r11, r12);     // Catch: RuntimeException -> L7 HttpException -> L9 IOException -> L11
        if (r13 != null) goto L13;
    L22:
        return doReceiveResponse(r10, r11, r12);
    L13:
        return r13;
    L11:
        e = move-exception;
        closeConnection(r11);
        throw e;
    L7:
        e = move-exception;
        closeConnection(r11);
        throw e;
    L9:
        e = move-exception;
        closeConnection(r11);
        throw e;
    }

    public void postProcess(HttpResponse r10, HttpProcessor r11, HttpContext r12) throws HttpException, IOException {
        Args.notNull(r10, "HTTP response");
        Args.notNull(r11, "HTTP processor");
        Args.notNull(r12, "HTTP context");
        r12.setAttribute("http.response", r10);
        r11.process(r10, r12);
    }

    public void preProcess(HttpRequest r10, HttpProcessor r11, HttpContext r12) throws HttpException, IOException {
        Args.notNull(r10, "HTTP request");
        Args.notNull(r11, "HTTP processor");
        Args.notNull(r12, "HTTP context");
        r12.setAttribute("http.request", r10);
        r11.process(r10, r12);
    }

    public HttpRequestExecutor() {
        this(DEFAULT_WAIT_FOR_CONTINUE);
    }
}
