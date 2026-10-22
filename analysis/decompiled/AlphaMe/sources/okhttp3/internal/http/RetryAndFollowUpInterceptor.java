package okhttp3.internal.http;

import com.baidu.platform.comapi.UIMsg;
import com.stepos.activeview.utils.Constants;
import h3.I;
import h3.J;
import h3.L;
import h3.S;
import h3.U;
import h3.V;
import h3.Z;
import h3.b0;
import h3.g0;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.SocketTimeoutException;
import java.security.cert.CertificateException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import okhttp3.internal.Util;
import okhttp3.internal.connection.Exchange;
import okhttp3.internal.connection.RealCall;
import okhttp3.internal.connection.RealConnection;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 '2\u00020\u0001:\u0001'B\u000f\u0012\u0006\u0010#\u001a\u00020\"¢\u0006\u0004\b%\u0010&J/\u0010\n\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\f\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ#\u0010\u0014\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J!\u0010\u0018\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u001f\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\u001aH\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010 \u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020\u001eH\u0016¢\u0006\u0004\b \u0010!R\u0014\u0010#\u001a\u00020\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$¨\u0006("}, d2 = {"Lokhttp3/internal/http/RetryAndFollowUpInterceptor;", "Lh3/L;", "Ljava/io/IOException;", "e", "Lokhttp3/internal/connection/RealCall;", "call", "Lh3/V;", "userRequest", "", "requestSendStarted", "recover", "(Ljava/io/IOException;Lokhttp3/internal/connection/RealCall;Lh3/V;Z)Z", "requestIsOneShot", "(Ljava/io/IOException;Lh3/V;)Z", "isRecoverable", "(Ljava/io/IOException;Z)Z", "Lh3/b0;", "userResponse", "Lokhttp3/internal/connection/Exchange;", "exchange", "followUpRequest", "(Lh3/b0;Lokhttp3/internal/connection/Exchange;)Lh3/V;", "", "method", "buildRedirectRequest", "(Lh3/b0;Ljava/lang/String;)Lh3/V;", "", "defaultDelay", "retryAfter", "(Lh3/b0;I)I", "Lh3/K;", "chain", "intercept", "(Lh3/K;)Lh3/b0;", "Lh3/S;", "client", "Lh3/S;", "<init>", "(Lh3/S;)V", "Companion", "okhttp"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes2.dex */
public final class RetryAndFollowUpInterceptor implements L {
    private static final int MAX_FOLLOW_UPS = 20;

    @NotNull
    private final S client;

    public RetryAndFollowUpInterceptor(@NotNull S client) {
        Intrinsics.checkNotNullParameter(client, "client");
        this.client = client;
    }

    private final V buildRedirectRequest(b0 userResponse, String method) {
        String link;
        if (!this.client.f12794h || (link = b0.b(userResponse, "Location")) == null) {
            return null;
        }
        V v4 = userResponse.f12864a;
        J j4 = v4.f12826a;
        j4.getClass();
        Intrinsics.checkNotNullParameter(link, "link");
        I iG = j4.g(link);
        J url = iG == null ? null : iG.c();
        if (url == null) {
            return null;
        }
        J j5 = v4.f12826a;
        if (!Intrinsics.areEqual(url.f12722a, j5.f12722a) && !this.client.f12795i) {
            return null;
        }
        U uC = v4.c();
        if (HttpMethod.permitsRequestBody(method)) {
            HttpMethod httpMethod = HttpMethod.INSTANCE;
            boolean zRedirectsWithBody = httpMethod.redirectsWithBody(method);
            int i4 = userResponse.f12867d;
            boolean z4 = zRedirectsWithBody || i4 == 308 || i4 == 307;
            if (!httpMethod.redirectsToGet(method) || i4 == 308 || i4 == 307) {
                uC.d(method, z4 ? v4.f12829d : null);
            } else {
                uC.d("GET", null);
            }
            if (!z4) {
                uC.e("Transfer-Encoding");
                uC.e("Content-Length");
                uC.e("Content-Type");
            }
        }
        if (!Util.canReuseConnectionFor(j5, url)) {
            uC.e("Authorization");
        }
        Intrinsics.checkNotNullParameter(url, "url");
        uC.f12821a = url;
        return uC.b();
    }

    private final V followUpRequest(b0 userResponse, Exchange exchange) throws IOException {
        RealConnection connection;
        g0 route = (exchange == null || (connection = exchange.getConnection()) == null) ? null : connection.getRoute();
        int i4 = userResponse.f12867d;
        V v4 = userResponse.f12864a;
        String str = v4.f12827b;
        if (i4 != 307 && i4 != 308) {
            if (i4 == 401) {
                return this.client.f12793g.authenticate(route, userResponse);
            }
            if (i4 == 421) {
                Z z4 = v4.f12829d;
                if ((z4 != null && z4.isOneShot()) || exchange == null || !exchange.isCoalescedConnection$okhttp()) {
                    return null;
                }
                exchange.getConnection().noCoalescedConnections$okhttp();
                return v4;
            }
            b0 b0Var = userResponse.f12873j;
            if (i4 == 503) {
                if ((b0Var == null || b0Var.f12867d != 503) && retryAfter(userResponse, Integer.MAX_VALUE) == 0) {
                    return v4;
                }
                return null;
            }
            if (i4 == 407) {
                Intrinsics.checkNotNull(route);
                if (route.f12910b.type() == Proxy.Type.HTTP) {
                    return this.client.f12801o.authenticate(route, userResponse);
                }
                throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
            }
            if (i4 == 408) {
                if (!this.client.f12792f) {
                    return null;
                }
                Z z5 = v4.f12829d;
                if (z5 != null && z5.isOneShot()) {
                    return null;
                }
                if ((b0Var == null || b0Var.f12867d != 408) && retryAfter(userResponse, 0) <= 0) {
                    return v4;
                }
                return null;
            }
            switch (i4) {
                case UIMsg.MsgDefine.RENDER_STATE_FIRST_FRAME /* 300 */:
                case Constants.RESPONSE_CODE_RELOCATE /* 301 */:
                case Constants.RESPONSE_CODE_TEMP_RELOCATION /* 302 */:
                case 303:
                    break;
                default:
                    return null;
            }
        }
        return buildRedirectRequest(userResponse, str);
    }

    private final boolean isRecoverable(IOException e4, boolean requestSendStarted) {
        if (e4 instanceof ProtocolException) {
            return false;
        }
        return e4 instanceof InterruptedIOException ? (e4 instanceof SocketTimeoutException) && !requestSendStarted : (((e4 instanceof SSLHandshakeException) && (e4.getCause() instanceof CertificateException)) || (e4 instanceof SSLPeerUnverifiedException)) ? false : true;
    }

    private final boolean recover(IOException e4, RealCall call, V userRequest, boolean requestSendStarted) {
        if (this.client.f12792f) {
            return !(requestSendStarted && requestIsOneShot(e4, userRequest)) && isRecoverable(e4, requestSendStarted) && call.retryAfterFailure();
        }
        return false;
    }

    private final boolean requestIsOneShot(IOException e4, V userRequest) {
        Z z4 = userRequest.f12829d;
        return (z4 != null && z4.isOneShot()) || (e4 instanceof FileNotFoundException);
    }

    private final int retryAfter(b0 userResponse, int defaultDelay) throws NumberFormatException {
        String strB = b0.b(userResponse, "Retry-After");
        if (strB == null) {
            return defaultDelay;
        }
        if (!new Regex("\\d+").matches(strB)) {
            return Integer.MAX_VALUE;
        }
        Integer numValueOf = Integer.valueOf(strB);
        Intrinsics.checkNotNullExpressionValue(numValueOf, "valueOf(header)");
        return numValueOf.intValue();
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0038, code lost:
    
        if (r6.f12870g != null) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x003a, code lost:
    
        r0.f12859j = r6;
        r0 = r0.a();
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0040, code lost:
    
        r7 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0050, code lost:
    
        throw new java.lang.IllegalArgumentException("priorResponse.body != null".toString());
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0051, code lost:
    
        r0 = r1.getInterceptorScopedExchange();
        r6 = followUpRequest(r7, r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0059, code lost:
    
        if (r6 != null) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x005b, code lost:
    
        if (r0 == null) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0061, code lost:
    
        if (r0.getIsDuplex() == false) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0063, code lost:
    
        r1.timeoutEarlyExit();
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0066, code lost:
    
        r1.exitNetworkInterceptorExchange$okhttp(false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0069, code lost:
    
        return r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x006a, code lost:
    
        r0 = r6.f12829d;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x006c, code lost:
    
        if (r0 == null) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0072, code lost:
    
        if (r0.isOneShot() == false) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0074, code lost:
    
        r1.exitNetworkInterceptorExchange$okhttp(false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0077, code lost:
    
        return r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0078, code lost:
    
        r0 = r7.f12870g;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x007a, code lost:
    
        if (r0 != null) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x007d, code lost:
    
        okhttp3.internal.Util.closeQuietly(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0080, code lost:
    
        r8 = r8 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0084, code lost:
    
        if (r8 > 20) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x009a, code lost:
    
        throw new java.net.ProtocolException(kotlin.jvm.internal.Intrinsics.stringPlus("Too many follow-up requests: ", java.lang.Integer.valueOf(r8)));
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0026, code lost:
    
        if (r7 == null) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0028, code lost:
    
        r0 = r0.e();
        r6 = r7.e();
        r6.f12856g = null;
        r6 = r6.a();
     */
    @Override // h3.L
    @org.jetbrains.annotations.NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public h3.b0 intercept(@org.jetbrains.annotations.NotNull h3.K r11) throws java.io.IOException {
        /*
            r10 = this;
            java.lang.String r0 = "chain"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            okhttp3.internal.http.RealInterceptorChain r11 = (okhttp3.internal.http.RealInterceptorChain) r11
            h3.V r0 = r11.getRequest()
            okhttp3.internal.connection.RealCall r1 = r11.getCall()
            java.util.List r2 = kotlin.collections.CollectionsKt.emptyList()
            r3 = 0
            r4 = 0
            r5 = 1
            r8 = r3
            r7 = r4
        L18:
            r6 = r5
        L19:
            r1.enterNetworkInterceptorExchange(r0, r6)
            boolean r6 = r1.getCanceled()     // Catch: java.lang.Throwable -> L42
            if (r6 != 0) goto Ld5
            h3.b0 r0 = r11.proceed(r0)     // Catch: java.lang.Throwable -> L42 java.io.IOException -> L9b okhttp3.internal.connection.RouteException -> Lb6
            if (r7 == 0) goto L40
            h3.a0 r0 = r0.e()     // Catch: java.lang.Throwable -> L42
            h3.a0 r6 = r7.e()     // Catch: java.lang.Throwable -> L42
            r6.f12856g = r4     // Catch: java.lang.Throwable -> L42
            h3.b0 r6 = r6.a()     // Catch: java.lang.Throwable -> L42
            h3.f0 r7 = r6.f12870g     // Catch: java.lang.Throwable -> L42
            if (r7 != 0) goto L45
            r0.f12859j = r6     // Catch: java.lang.Throwable -> L42
            h3.b0 r0 = r0.a()     // Catch: java.lang.Throwable -> L42
        L40:
            r7 = r0
            goto L51
        L42:
            r10 = move-exception
            goto Ldd
        L45:
            java.lang.IllegalArgumentException r10 = new java.lang.IllegalArgumentException     // Catch: java.lang.Throwable -> L42
            java.lang.String r11 = "priorResponse.body != null"
            java.lang.String r11 = r11.toString()     // Catch: java.lang.Throwable -> L42
            r10.<init>(r11)     // Catch: java.lang.Throwable -> L42
            throw r10     // Catch: java.lang.Throwable -> L42
        L51:
            okhttp3.internal.connection.Exchange r0 = r1.getInterceptorScopedExchange()     // Catch: java.lang.Throwable -> L42
            h3.V r6 = r10.followUpRequest(r7, r0)     // Catch: java.lang.Throwable -> L42
            if (r6 != 0) goto L6a
            if (r0 == 0) goto L66
            boolean r10 = r0.getIsDuplex()     // Catch: java.lang.Throwable -> L42
            if (r10 == 0) goto L66
            r1.timeoutEarlyExit()     // Catch: java.lang.Throwable -> L42
        L66:
            r1.exitNetworkInterceptorExchange$okhttp(r3)
            return r7
        L6a:
            h3.Z r0 = r6.f12829d     // Catch: java.lang.Throwable -> L42
            if (r0 == 0) goto L78
            boolean r0 = r0.isOneShot()     // Catch: java.lang.Throwable -> L42
            if (r0 == 0) goto L78
            r1.exitNetworkInterceptorExchange$okhttp(r3)
            return r7
        L78:
            h3.f0 r0 = r7.f12870g     // Catch: java.lang.Throwable -> L42
            if (r0 != 0) goto L7d
            goto L80
        L7d:
            okhttp3.internal.Util.closeQuietly(r0)     // Catch: java.lang.Throwable -> L42
        L80:
            int r8 = r8 + 1
            r0 = 20
            if (r8 > r0) goto L8b
            r1.exitNetworkInterceptorExchange$okhttp(r5)
            r0 = r6
            goto L18
        L8b:
            java.net.ProtocolException r10 = new java.net.ProtocolException     // Catch: java.lang.Throwable -> L42
            java.lang.String r11 = "Too many follow-up requests: "
            java.lang.Integer r0 = java.lang.Integer.valueOf(r8)     // Catch: java.lang.Throwable -> L42
            java.lang.String r11 = kotlin.jvm.internal.Intrinsics.stringPlus(r11, r0)     // Catch: java.lang.Throwable -> L42
            r10.<init>(r11)     // Catch: java.lang.Throwable -> L42
            throw r10     // Catch: java.lang.Throwable -> L42
        L9b:
            r6 = move-exception
            boolean r9 = r6 instanceof okhttp3.internal.http2.ConnectionShutdownException     // Catch: java.lang.Throwable -> L42
            r9 = r9 ^ r5
            boolean r9 = r10.recover(r6, r1, r0, r9)     // Catch: java.lang.Throwable -> L42
            if (r9 == 0) goto Lb1
            java.util.Collection r2 = (java.util.Collection) r2     // Catch: java.lang.Throwable -> L42
            java.util.List r2 = kotlin.collections.CollectionsKt.l(r2, r6)     // Catch: java.lang.Throwable -> L42
        Lab:
            r1.exitNetworkInterceptorExchange$okhttp(r5)
            r6 = r3
            goto L19
        Lb1:
            java.lang.Throwable r10 = okhttp3.internal.Util.withSuppressed(r6, r2)     // Catch: java.lang.Throwable -> L42
            throw r10     // Catch: java.lang.Throwable -> L42
        Lb6:
            r6 = move-exception
            java.io.IOException r9 = r6.getLastConnectException()     // Catch: java.lang.Throwable -> L42
            boolean r9 = r10.recover(r9, r1, r0, r3)     // Catch: java.lang.Throwable -> L42
            if (r9 == 0) goto Lcc
            java.util.Collection r2 = (java.util.Collection) r2     // Catch: java.lang.Throwable -> L42
            java.io.IOException r6 = r6.getFirstConnectException()     // Catch: java.lang.Throwable -> L42
            java.util.List r2 = kotlin.collections.CollectionsKt.l(r2, r6)     // Catch: java.lang.Throwable -> L42
            goto Lab
        Lcc:
            java.io.IOException r10 = r6.getFirstConnectException()     // Catch: java.lang.Throwable -> L42
            java.lang.Throwable r10 = okhttp3.internal.Util.withSuppressed(r10, r2)     // Catch: java.lang.Throwable -> L42
            throw r10     // Catch: java.lang.Throwable -> L42
        Ld5:
            java.io.IOException r10 = new java.io.IOException     // Catch: java.lang.Throwable -> L42
            java.lang.String r11 = "Canceled"
            r10.<init>(r11)     // Catch: java.lang.Throwable -> L42
            throw r10     // Catch: java.lang.Throwable -> L42
        Ldd:
            r1.exitNetworkInterceptorExchange$okhttp(r5)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http.RetryAndFollowUpInterceptor.intercept(h3.K):h3.b0");
    }
}
