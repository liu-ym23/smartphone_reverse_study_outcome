package okhttp3.internal.http;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.HttpRetryException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.SocketTimeoutException;
import java.security.cert.CertificateException;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocketFactory;
import kotlinx.coroutines.channels.Channel;
import okhttp3.Address;
import okhttp3.Call;
import okhttp3.EventListener;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.Route;
import okhttp3.b;
import okhttp3.internal.Util;
import okhttp3.internal.connection.RouteException;
import okhttp3.internal.connection.StreamAllocation;
import okhttp3.internal.http2.ConnectionShutdownException;

/* JADX INFO: loaded from: classes4.dex */
public final class RetryAndFollowUpInterceptor implements Interceptor {
    private static final int MAX_FOLLOW_UPS = 20;
    private Object callStackTrace;
    private volatile boolean canceled;
    private final OkHttpClient client;
    private final boolean forWebSocket;
    private volatile StreamAllocation streamAllocation;

    public RetryAndFollowUpInterceptor(OkHttpClient r10, boolean r11) {
        this.client = r10;
        this.forWebSocket = r11;
    }

    private Address createAddress(HttpUrl r15) {
        if (r15.n() == false) goto L5;
        SSLSocketFactory r10 = this.client.y();
        SSLSocketFactory r11 = r10;
        HostnameVerifier r12 = this.client.l();
        b r13 = this.client.b();
    L7:
        return new Address(r15.m(), r15.z(), this.client.h(), this.client.x(), r11, r12, r13, this.client.t(), this.client.s(), this.client.r(), this.client.e(), this.client.u());
    L5:
        r11 = null;
        r12 = null;
        r13 = null;
        goto L7
    }

    private Request followUpRequest(Response r10, Route r11) throws IOException {
        if (r10 == null) goto L91;
        int r12 = r10.d();
        String r13 = r10.r().g();
        boolean r14 = false;
        RequestBody r15 = null;
        if (r12 == 307) goto L55;
        if (r12 == 308) goto L55;
        if (r12 == 401) goto L53;
        if (r12 == 503) goto L43;
        if (r12 != 407) goto L14;
        if (r11 == null) goto L35;
        Proxy r16 = r11.b();
    L37:
        if (r16.type() != Proxy.Type.HTTP) goto L41;
        return this.client.t().authenticate(r11, r10);
    L41:
        throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
    L35:
        r16 = this.client.s();
        goto L37
    L14:
        if (r12 == 408) goto L18;
        switch(r12) {
            case 300: goto L55;
            case 301: goto L55;
            case 302: goto L55;
            case 303: goto L55;
            default: goto L16;
        };
    L16:
        return null;
    L18:
        if (this.client.w() == true) goto L21;
        return null;
    L21:
        if ((r10.r().a() instanceof UnrepeatableRequestBody) == false) goto L24;
        return null;
    L24:
        if (r10.o() == null) goto L29;
        if (r10.o().d() != 408) goto L29;
        return null;
    L29:
        if (retryAfter(r10, 0) <= 0) goto L32;
        return null;
    L32:
        return r10.r();
    L43:
        if (r10.o() == null) goto L48;
        if (r10.o().d() != 503) goto L48;
        return null;
    L48:
        if (retryAfter(r10, Channel.UNLIMITED) == 0) goto L50;
        return null;
    L50:
        return r10.r();
    L53:
        return this.client.a().authenticate(r11, r10);
    L55:
        if (this.client.j() == true) goto L57;
        return null;
    L57:
        String r17 = r10.f("Location");
        if (r17 != null) goto L60;
        return null;
    L60:
        HttpUrl r18 = r10.r().k().F(r17);
        if (r18 != null) goto L64;
        return null;
    L64:
        if (r18.G().equals(r10.r().k().G()) == false) goto L66;
    L68:
        Request.a r19 = r10.r().h();
        if (HttpMethod.permitsRequestBody(r13) == false) goto L86;
        if (HttpMethod.redirectsWithBody(r13) == false) goto L73;
    L74:
        r14 = true;
    L76:
        if (needRedirectToPost(r12) == false) goto L78;
    L80:
        if (r14 == false) goto L82;
        r15 = r10.r().a();
    L82:
        r19.f(r13, r15);
    L83:
        if (r14 == true) goto L86;
        r19.h("Transfer-Encoding");
        r19.h("Content-Length");
        r19.h("Content-Type");
        goto L86
    L78:
        if (HttpMethod.redirectsToGet(r13) == false) goto L80;
        r19.f("GET", null);
        goto L83
    L73:
        if (needRedirectToPost(r12) == false) goto L76;
    L86:
        if (sameConnection(r10, r18) == true) goto L89;
        r19.h("Authorization");
    L89:
        return r19.k(r18).b();
    L66:
        if (this.client.k() == true) goto L68;
        return null;
    L91:
        throw new IllegalStateException();
    }

    private boolean isRecoverable(IOException r10, boolean r11) {
        if ((r10 instanceof ProtocolException) == false) goto L6;
        return false;
    L6:
        if ((r10 instanceof InterruptedIOException) == false) goto L13;
        if ((r10 instanceof SocketTimeoutException) == false) goto L21;
        if (r11 == false) goto L11;
        return false;
    L11:
        return true;
    L21:
        return false;
    L13:
        if ((r10 instanceof SSLHandshakeException) == false) goto L18;
        if ((r10.getCause() instanceof CertificateException) == false) goto L18;
        return false;
    L18:
        if ((r10 instanceof SSLPeerUnverifiedException) == false) goto L20;
        return false;
    L20:
        return true;
    }

    private boolean needRedirectToPost(int r10) {
        if (r10 != 308) goto L5;
        return true;
    L5:
        if (r10 == 307) goto L11;
        return false;
    L11:
        return true;
    }

    private boolean recover(IOException r10, StreamAllocation r11, boolean r12, Request r13) {
        r11.streamFailed(r10);
        if (this.client.w() == true) goto L5;
        return false;
    L5:
        if (r12 == false) goto L10;
        if ((r13.a() instanceof UnrepeatableRequestBody) == false) goto L10;
        return false;
    L10:
        if (isRecoverable(r10, r12) == true) goto L13;
        return false;
    L13:
        if (r11.hasMoreRoutes() == true) goto L15;
        return false;
    L15:
        return true;
    }

    private int retryAfter(Response r10, int r11) {
        String r12 = r10.f("Retry-After");
        if (r12 != null) goto L6;
        return r11;
    L6:
        if (r12.matches("\\d+") == true) goto L8;
        return Channel.UNLIMITED;
    L8:
        return Integer.valueOf(r12).intValue();
    }

    private boolean sameConnection(Response r10, HttpUrl r11) {
        HttpUrl r12 = r10.r().k();
        if (r12.m().equals(r11.m()) == true) goto L5;
    L9:
        return false;
    L5:
        if (r12.z() != r11.z()) goto L9;
        if (r12.G().equals(r11.G()) == false) goto L9;
        return true;
    }

    public void cancel() {
        this.canceled = true;
        StreamAllocation r10 = this.streamAllocation;
        if (r10 == null) goto L6;
        r10.cancel();
        return;
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain r15) throws IOException {
        Request r10 = r15.request();
        RealInterceptorChain r16 = (RealInterceptorChain) r15;
        Call r11 = r16.call();
        EventListener r12 = r16.eventListener();
        StreamAllocation r13 = new StreamAllocation(this.client.d(), createAddress(r10.k()), r11, r12, this.callStackTrace);
        this.streamAllocation = r13;
        int r14 = 0;
        Response r17 = null;
    L4:
        if (this.canceled == true) goto L45;
        Response r18 = r16.proceed(r10, r13, null, null);     // Catch: Throwable -> L30 IOException -> L32 RouteException -> L37
    L6:
        if (r17 == null) goto L8;
        r18 = r18.n().l(r17.n().b(null).c()).c();
    L8:
        Request r19 = followUpRequest(r18, r13.route());
        if (r19 == null) goto L11;
        Util.closeQuietly(r18.a());
        int r110 = r14 + 1;
        if (r110 > 20) goto L28;
        if ((r19.a() instanceof UnrepeatableRequestBody) == true) goto L26;
        if (sameConnection(r18, r19.k()) == true) goto L22;
        r13.release();
        r13 = new StreamAllocation(this.client.d(), createAddress(r19.k()), r11, r12, this.callStackTrace);
        this.streamAllocation = r13;
    L23:
        r17 = r18;
        r10 = r19;
        r14 = r110;
        goto L4
    L22:
        if (r13.codec() == null) goto L23;
        throw new IllegalStateException("Closing the body of " + r18 + " didn't close its backing stream. Bad interceptor?");
    L26:
        r13.release();
        throw new HttpRetryException("Cannot retry streamed HTTP body", r18.d());
    L28:
        r13.release();
        throw new ProtocolException("Too many follow-up requests: " + r110);
    L11:
        if (this.forWebSocket == true) goto L13;
        r13.release();
    L13:
        return r18;
    L30:
        th = move-exception;
        r13.streamFailed(null);
        r13.release();
        throw th;
    L32:
        e = move-exception;
        if (recover(e, r13, !(e instanceof ConnectionShutdownException), r10) == true) goto L4;
        throw e;     // Catch: Throwable -> L30
    L37:
        e = move-exception;
        if (recover(e.getLastConnectException(), r13, false, r10) == true) goto L4;
        throw e.getLastConnectException();     // Catch: Throwable -> L30
    L45:
        r13.release();
        throw new IOException("Canceled");
    }

    public boolean isCanceled() {
        return this.canceled;
    }

    public void setCallStackTrace(Object r10) {
        this.callStackTrace = r10;
    }

    public StreamAllocation streamAllocation() {
        return this.streamAllocation;
    }
}
