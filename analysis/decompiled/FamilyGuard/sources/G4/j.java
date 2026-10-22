package G4;

import C4.A;
import C4.D;
import C4.E;
import C4.F;
import C4.H;
import C4.w;
import C4.x;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.SocketTimeoutException;
import java.security.cert.CertificateException;
import javax.annotation.Nullable;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;

/* loaded from: classes.dex */
public final class j implements x {

    /* renamed from: a, reason: collision with root package name */
    private final A f1935a;

    public j(A a6) {
        this.f1935a = a6;
    }

    private D b(F f5, @Nullable H h5) throws ProtocolException {
        String strR;
        w wVarC;
        if (f5 == null) {
            throw new IllegalStateException();
        }
        int iM = f5.m();
        String strF = f5.I().f();
        if (iM == 307 || iM == 308) {
            if (!strF.equals("GET") && !strF.equals("HEAD")) {
                return null;
            }
        } else {
            if (iM == 401) {
                return this.f1935a.d().b(h5, f5);
            }
            if (iM == 503) {
                if ((f5.D() == null || f5.D().m() != 503) && f(f5, Integer.MAX_VALUE) == 0) {
                    return f5.I();
                }
                return null;
            }
            if (iM == 407) {
                if ((h5 != null ? h5.b() : this.f1935a.A()).type() == Proxy.Type.HTTP) {
                    return this.f1935a.B().b(h5, f5);
                }
                throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
            }
            if (iM == 408) {
                if (!this.f1935a.E()) {
                    return null;
                }
                E eA = f5.I().a();
                if (eA != null && eA.g()) {
                    return null;
                }
                if ((f5.D() == null || f5.D().m() != 408) && f(f5, 0) <= 0) {
                    return f5.I();
                }
                return null;
            }
            switch (iM) {
                case 300:
                case 301:
                case 302:
                case 303:
                    break;
                default:
                    return null;
            }
        }
        if (!this.f1935a.q() || (strR = f5.r("Location")) == null || (wVarC = f5.I().i().C(strR)) == null) {
            return null;
        }
        if (!wVarC.D().equals(f5.I().i().D()) && !this.f1935a.s()) {
            return null;
        }
        D.a aVarG = f5.I().g();
        if (f.a(strF)) {
            boolean zC = f.c(strF);
            if (f.b(strF)) {
                aVarG.e("GET", null);
            } else {
                aVarG.e(strF, zC ? f5.I().a() : null);
            }
            if (!zC) {
                aVarG.f("Transfer-Encoding");
                aVarG.f("Content-Length");
                aVarG.f("Content-Type");
            }
        }
        if (!D4.e.D(f5.I().i(), wVarC)) {
            aVarG.f("Authorization");
        }
        return aVarG.h(wVarC).b();
    }

    private boolean c(IOException iOException, boolean z5) {
        if (iOException instanceof ProtocolException) {
            return false;
        }
        return iOException instanceof InterruptedIOException ? (iOException instanceof SocketTimeoutException) && !z5 : (((iOException instanceof SSLHandshakeException) && (iOException.getCause() instanceof CertificateException)) || (iOException instanceof SSLPeerUnverifiedException)) ? false : true;
    }

    private boolean d(IOException iOException, F4.k kVar, boolean z5, D d6) {
        if (this.f1935a.E()) {
            return !(z5 && e(iOException, d6)) && c(iOException, z5) && kVar.c();
        }
        return false;
    }

    private boolean e(IOException iOException, D d6) {
        E eA = d6.a();
        return (eA != null && eA.g()) || (iOException instanceof FileNotFoundException);
    }

    private int f(F f5, int i5) {
        String strR = f5.r("Retry-After");
        if (strR == null) {
            return i5;
        }
        if (strR.matches("\\d+")) {
            return Integer.valueOf(strR).intValue();
        }
        return Integer.MAX_VALUE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0066, code lost:
    
        return r4;
     */
    @Override // C4.x
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public C4.F a(C4.x.a r9) throws java.io.IOException {
        /*
            r8 = this;
            C4.D r0 = r9.a()
            G4.g r9 = (G4.g) r9
            F4.k r1 = r9.h()
            r2 = 0
            r3 = 0
            r5 = r2
            r4 = r3
        Le:
            r1.m(r0)
            boolean r6 = r1.i()
            if (r6 != 0) goto Lbe
            C4.F r0 = r9.g(r0, r1, r3)     // Catch: java.lang.Throwable -> L96 java.io.IOException -> L98 F4.i -> La9
            if (r4 == 0) goto L35
            C4.F$a r0 = r0.C()
            C4.F$a r4 = r4.C()
            C4.F$a r4 = r4.b(r3)
            C4.F r4 = r4.c()
            C4.F$a r0 = r0.n(r4)
            C4.F r0 = r0.c()
        L35:
            r4 = r0
            D4.a r0 = D4.a.f1202a
            F4.c r0 = r0.f(r4)
            if (r0 == 0) goto L47
            F4.e r6 = r0.c()
            C4.H r6 = r6.q()
            goto L48
        L47:
            r6 = r3
        L48:
            C4.D r6 = r8.b(r4, r6)
            if (r6 != 0) goto L5a
            if (r0 == 0) goto L66
            boolean r8 = r0.h()
            if (r8 == 0) goto L66
            r1.o()
            goto L66
        L5a:
            C4.E r7 = r6.a()
            if (r7 == 0) goto L67
            boolean r7 = r7.g()
            if (r7 == 0) goto L67
        L66:
            return r4
        L67:
            C4.G r7 = r4.a()
            D4.e.g(r7)
            boolean r7 = r1.h()
            if (r7 == 0) goto L77
            r0.e()
        L77:
            int r5 = r5 + 1
            r0 = 20
            if (r5 > r0) goto L7f
            r0 = r6
            goto Le
        L7f:
            java.net.ProtocolException r8 = new java.net.ProtocolException
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r0 = "Too many follow-up requests: "
            r9.append(r0)
            r9.append(r5)
            java.lang.String r9 = r9.toString()
            r8.<init>(r9)
            throw r8
        L96:
            r8 = move-exception
            goto Lba
        L98:
            r6 = move-exception
            boolean r7 = r6 instanceof I4.a     // Catch: java.lang.Throwable -> L96
            r7 = r7 ^ 1
            boolean r7 = r8.d(r6, r1, r7, r0)     // Catch: java.lang.Throwable -> L96
            if (r7 == 0) goto La8
        La3:
            r1.f()
            goto Le
        La8:
            throw r6     // Catch: java.lang.Throwable -> L96
        La9:
            r6 = move-exception
            java.io.IOException r7 = r6.c()     // Catch: java.lang.Throwable -> L96
            boolean r7 = r8.d(r7, r1, r2, r0)     // Catch: java.lang.Throwable -> L96
            if (r7 == 0) goto Lb5
            goto La3
        Lb5:
            java.io.IOException r8 = r6.b()     // Catch: java.lang.Throwable -> L96
            throw r8     // Catch: java.lang.Throwable -> L96
        Lba:
            r1.f()
            throw r8
        Lbe:
            java.io.IOException r8 = new java.io.IOException
            java.lang.String r9 = "Canceled"
            r8.<init>(r9)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: G4.j.a(C4.x$a):C4.F");
    }
}
