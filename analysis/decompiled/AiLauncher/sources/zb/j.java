package zb;

import com.autonavi.aps.amapapi.config.Const;
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
import kotlin.jvm.internal.p;
import kotlin.text.Regex;
import okhttp3.internal.http2.ConnectionShutdownException;
import tb.AbstractC5529B;
import tb.C5528A;
import tb.C5530C;
import tb.C5532E;
import tb.v;
import tb.w;
import ub.q;
import yb.C6027h;
import yb.C6032m;
import yb.C6033n;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ/\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\n\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\n\u0010\u0012J\u001f\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0014\u0010\u0015J+\u0010\u0019\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0016\u001a\u00020\u00062\b\u0010\u0018\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ)\u0010\u001d\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u001f\u0010!\u001a\u00020\u001f2\u0006\u0010\u0016\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u001fH\u0002¢\u0006\u0004\b!\u0010\"¨\u0006#"}, d2 = {"Lzb/j;", "Ltb/w;", "<init>", "()V", "Ltb/w$a;", "chain", "Ltb/C;", "intercept", "(Ltb/w$a;)Ltb/C;", "Ljava/io/IOException;", "e", "Lyb/m;", "call", "Ltb/A;", "userRequest", "", Const.INTENT_KEY_UMID, "(Ljava/io/IOException;Lyb/m;Ltb/w$a;Ltb/A;)Z", "(Ljava/io/IOException;Ltb/A;)Z", "requestSendStarted", "c", "(Ljava/io/IOException;Z)Z", "userResponse", "Lyb/h;", "exchange", Const.INTENT_KEY_PKGNAME, "(Ltb/C;Lyb/h;Ltb/w$a;)Ltb/A;", "", "method", Const.INTENT_KEY_APIKEY, "(Ltb/C;Ljava/lang/String;Ltb/w$a;)Ltb/A;", "", "defaultDelay", "f", "(Ltb/C;I)I", "okhttp"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class j implements w {
    public final C5528A a(C5530C userResponse, String method, w.a chain) {
        String strJ;
        v vVarS;
        if (!chain.a() || (strJ = C5530C.J(userResponse, "Location", null, 2, null)) == null || (vVarS = userResponse.getRequest().getUrl().s(strJ)) == null) {
            return null;
        }
        if (!p.d(vVarS.getScheme(), userResponse.getRequest().getUrl().getScheme()) && !chain.k()) {
            return null;
        }
        C5528A.a aVarI = userResponse.getRequest().i();
        if (f.a(method)) {
            int code = userResponse.getCode();
            f fVar = f.f45437a;
            boolean z10 = fVar.c(method) || code == 308 || code == 307;
            if (!fVar.b(method) || code == 308 || code == 307) {
                aVarI.n(method, z10 ? userResponse.getRequest().getBody() : null);
            } else {
                aVarI.n("GET", null);
            }
            if (!z10) {
                aVarI.q(com.stepos.statsapp.v3.lib.plugin.net.multipart.e.f30846e);
                aVarI.q("Content-Length");
                aVarI.q("Content-Type");
            }
        }
        if (!q.f(userResponse.getRequest().getUrl(), vVarS)) {
            aVarI.q("Authorization");
        }
        return aVarI.u(vVarS).b();
    }

    public final C5528A b(C5530C userResponse, C6027h exchange, w.a chain) throws IOException {
        C6033n c6033nJ;
        C5532E c5532eU = (exchange == null || (c6033nJ = exchange.j()) == null) ? null : c6033nJ.u();
        int code = userResponse.getCode();
        String method = userResponse.getRequest().getMethod();
        if (code != 307 && code != 308) {
            if (code == 401) {
                return chain.getAuthenticator().authenticate(c5532eU, userResponse);
            }
            if (code == 421) {
                AbstractC5529B body = userResponse.getRequest().getBody();
                if ((body != null && body.f()) || exchange == null || !exchange.m()) {
                    return null;
                }
                exchange.j().t();
                return userResponse.getRequest();
            }
            if (code == 503) {
                C5530C priorResponse = userResponse.getPriorResponse();
                if ((priorResponse == null || priorResponse.getCode() != 503) && f(userResponse, Integer.MAX_VALUE) == 0) {
                    return userResponse.getRequest();
                }
                return null;
            }
            if (code == 407) {
                p.f(c5532eU);
                if (c5532eU.getProxy().type() == Proxy.Type.HTTP) {
                    return chain.getProxyAuthenticator().authenticate(c5532eU, userResponse);
                }
                throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
            }
            if (code == 408) {
                if (!chain.getRetryOnConnectionFailure()) {
                    return null;
                }
                AbstractC5529B body2 = userResponse.getRequest().getBody();
                if (body2 != null && body2.f()) {
                    return null;
                }
                C5530C priorResponse2 = userResponse.getPriorResponse();
                if ((priorResponse2 == null || priorResponse2.getCode() != 408) && f(userResponse, 0) <= 0) {
                    return userResponse.getRequest();
                }
                return null;
            }
            switch (code) {
                case 300:
                case 301:
                case 302:
                case 303:
                    break;
                default:
                    return null;
            }
        }
        return a(userResponse, method, chain);
    }

    public final boolean c(IOException e10, boolean requestSendStarted) {
        if (e10 instanceof ProtocolException) {
            return false;
        }
        return e10 instanceof InterruptedIOException ? (e10 instanceof SocketTimeoutException) && !requestSendStarted : (((e10 instanceof SSLHandshakeException) && (e10.getCause() instanceof CertificateException)) || (e10 instanceof SSLPeerUnverifiedException)) ? false : true;
    }

    public final boolean d(IOException e10, C6032m call, w.a chain, C5528A userRequest) {
        boolean z10 = e10 instanceof ConnectionShutdownException;
        boolean z11 = !z10;
        if (chain.getRetryOnConnectionFailure()) {
            return (z10 || !e(e10, userRequest)) && c(e10, z11) && call.C();
        }
        return false;
    }

    public final boolean e(IOException e10, C5528A userRequest) {
        AbstractC5529B body = userRequest.getBody();
        return (body != null && body.f()) || (e10 instanceof FileNotFoundException);
    }

    public final int f(C5530C userResponse, int defaultDelay) throws NumberFormatException {
        String strJ = C5530C.J(userResponse, "Retry-After", null, 2, null);
        if (strJ == null) {
            return defaultDelay;
        }
        if (!new Regex("\\d+").k(strJ)) {
            return Integer.MAX_VALUE;
        }
        Integer numValueOf = Integer.valueOf(strJ);
        p.h(numValueOf, "valueOf(...)");
        return numValueOf.intValue();
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0031, code lost:
    
        r7 = ub.i.a(r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x003a, code lost:
    
        r7 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x003b, code lost:
    
        r8 = r1.n(r7).c();
        r1 = r2.getInterceptorScopedExchange();
        r7 = b(r8, r1, r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x004b, code lost:
    
        if (r7 != null) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x004d, code lost:
    
        if (r1 == null) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0053, code lost:
    
        if (r1.n() == false) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0055, code lost:
    
        r2.D();
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0058, code lost:
    
        r2.getEventListener().p(r2, r8, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x005f, code lost:
    
        r2.k(false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0062, code lost:
    
        return r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0063, code lost:
    
        r12 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0066, code lost:
    
        r1 = r7.getBody();
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x006a, code lost:
    
        if (r1 == null) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0070, code lost:
    
        if (r1.f() == false) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0072, code lost:
    
        r2.getEventListener().p(r2, r8, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0079, code lost:
    
        r2.k(false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x007c, code lost:
    
        return r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x007d, code lost:
    
        ub.n.f(r8.getBody());
        r9 = r9 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0088, code lost:
    
        if (r9 > 20) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x008a, code lost:
    
        r2.getEventListener().p(r2, r8, r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0096, code lost:
    
        r2.getEventListener().p(r2, r8, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00b3, code lost:
    
        throw new java.net.ProtocolException("Too many follow-up requests: " + r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00db, code lost:
    
        r2.k(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00de, code lost:
    
        throw r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0027, code lost:
    
        r1 = r0.i(r1).e0().q(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x002f, code lost:
    
        if (r8 == null) goto L13;
     */
    @Override // tb.w
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public tb.C5530C intercept(tb.w.a r13) throws java.lang.Throwable {
        /*
            r12 = this;
            java.lang.String r0 = "chain"
            kotlin.jvm.internal.p.i(r13, r0)
            r0 = r13
            zb.g r0 = (zb.g) r0
            tb.A r1 = r0.y()
            yb.m r2 = r0.getCall()
            java.util.List r3 = Z8.C1173v.m()
            r4 = 0
            r5 = 0
            r6 = 1
            r9 = r4
            r8 = r5
        L19:
            r7 = r6
        L1a:
            r2.j(r1, r7, r0)
            boolean r7 = r2.getCanceled()     // Catch: java.lang.Throwable -> L36
            if (r7 != 0) goto Ld3
            tb.C r7 = r0.i(r1)     // Catch: java.lang.Throwable -> L36 java.io.IOException -> Lb4
            tb.C$a r7 = r7.e0()     // Catch: java.lang.Throwable -> L36
            tb.C$a r1 = r7.q(r1)     // Catch: java.lang.Throwable -> L36
            if (r8 == 0) goto L3a
            tb.C r7 = ub.i.a(r8)     // Catch: java.lang.Throwable -> L36
            goto L3b
        L36:
            r12 = move-exception
            r4 = r6
            goto Ldb
        L3a:
            r7 = r5
        L3b:
            tb.C$a r1 = r1.n(r7)     // Catch: java.lang.Throwable -> L36
            tb.C r8 = r1.c()     // Catch: java.lang.Throwable -> L36
            yb.h r1 = r2.getInterceptorScopedExchange()     // Catch: java.lang.Throwable -> L36
            tb.A r7 = r12.b(r8, r1, r13)     // Catch: java.lang.Throwable -> L36
            if (r7 != 0) goto L66
            if (r1 == 0) goto L58
            boolean r12 = r1.getIsDuplex()     // Catch: java.lang.Throwable -> L36
            if (r12 == 0) goto L58
            r2.D()     // Catch: java.lang.Throwable -> L36
        L58:
            tb.q r12 = r2.getEventListener()     // Catch: java.lang.Throwable -> L63
            r12.p(r2, r8, r5)     // Catch: java.lang.Throwable -> L63
            r2.k(r4)
            return r8
        L63:
            r12 = move-exception
            goto Ldb
        L66:
            tb.B r1 = r7.getBody()     // Catch: java.lang.Throwable -> L36
            if (r1 == 0) goto L7d
            boolean r1 = r1.f()     // Catch: java.lang.Throwable -> L36
            if (r1 == 0) goto L7d
            tb.q r12 = r2.getEventListener()     // Catch: java.lang.Throwable -> L63
            r12.p(r2, r8, r5)     // Catch: java.lang.Throwable -> L63
            r2.k(r4)
            return r8
        L7d:
            tb.D r1 = r8.getBody()     // Catch: java.lang.Throwable -> L36
            ub.n.f(r1)     // Catch: java.lang.Throwable -> L36
            int r9 = r9 + 1
            r1 = 20
            if (r9 > r1) goto L96
            tb.q r1 = r2.getEventListener()     // Catch: java.lang.Throwable -> L36
            r1.p(r2, r8, r7)     // Catch: java.lang.Throwable -> L36
            r2.k(r6)
            r1 = r7
            goto L19
        L96:
            tb.q r12 = r2.getEventListener()     // Catch: java.lang.Throwable -> L36
            r12.p(r2, r8, r5)     // Catch: java.lang.Throwable -> L36
            java.net.ProtocolException r12 = new java.net.ProtocolException     // Catch: java.lang.Throwable -> L36
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L36
            r13.<init>()     // Catch: java.lang.Throwable -> L36
            java.lang.String r0 = "Too many follow-up requests: "
            r13.append(r0)     // Catch: java.lang.Throwable -> L36
            r13.append(r9)     // Catch: java.lang.Throwable -> L36
            java.lang.String r13 = r13.toString()     // Catch: java.lang.Throwable -> L36
            r12.<init>(r13)     // Catch: java.lang.Throwable -> L36
            throw r12     // Catch: java.lang.Throwable -> L36
        Lb4:
            r7 = move-exception
            boolean r10 = r12.d(r7, r2, r13, r1)     // Catch: java.lang.Throwable -> L36
            tb.q r11 = r2.getEventListener()     // Catch: java.lang.Throwable -> L36
            r11.C(r2, r7, r10)     // Catch: java.lang.Throwable -> L36
            if (r10 == 0) goto Lce
            java.util.Collection r3 = (java.util.Collection) r3     // Catch: java.lang.Throwable -> L36
            java.util.List r3 = Z8.F.T0(r3, r7)     // Catch: java.lang.Throwable -> L36
            r2.k(r6)
            r7 = r4
            goto L1a
        Lce:
            java.lang.Throwable r12 = ub.n.D(r7, r3)     // Catch: java.lang.Throwable -> L36
            throw r12     // Catch: java.lang.Throwable -> L36
        Ld3:
            java.io.IOException r12 = new java.io.IOException     // Catch: java.lang.Throwable -> L36
            java.lang.String r13 = "Canceled"
            r12.<init>(r13)     // Catch: java.lang.Throwable -> L36
            throw r12     // Catch: java.lang.Throwable -> L36
        Ldb:
            r2.k(r4)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: zb.j.intercept(tb.w$a):tb.C");
    }
}
