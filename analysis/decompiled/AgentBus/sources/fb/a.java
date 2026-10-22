package fb;

import ab.b0;
import ab.m;
import ab.n;
import ab.p;
import ab.q;
import ab.r;
import ab.t;
import ab.v;
import ab.w;
import ab.x;
import ab.y;
import ab.z;
import eb.i;
import eb.o;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import ob.s;
import q7.k;

/* loaded from: classes.dex */
public final class a implements q {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3644a = 0;

    /* renamed from: b, reason: collision with root package name */
    public final Object f3645b;

    public a(ab.b bVar) {
        k.e(bVar, "cookieJar");
        this.f3645b = bVar;
    }

    public static int d(z zVar, int i2) throws NumberFormatException {
        String strA = z.a(zVar, "Retry-After");
        if (strA == null) {
            return i2;
        }
        Pattern patternCompile = Pattern.compile("\\d+");
        k.d(patternCompile, "compile(...)");
        if (!patternCompile.matcher(strA).matches()) {
            return Integer.MAX_VALUE;
        }
        Integer numValueOf = Integer.valueOf(strA);
        k.d(numValueOf, "valueOf(header)");
        return numValueOf.intValue();
    }

    @Override // ab.q
    public final z a(g gVar) {
        b0 b0Var;
        SSLSocketFactory sSLSocketFactory;
        HostnameVerifier hostnameVerifier;
        ab.e eVar;
        switch (this.f3644a) {
            case 0:
                ab.b bVar = (ab.b) this.f3645b;
                w wVar = gVar.f3653e;
                v vVarA = wVar.a();
                n nVar = wVar.f663c;
                p pVar = wVar.f661a;
                x xVar = wVar.f664d;
                if (xVar != null) {
                    r rVar = (r) xVar.f669c;
                    if (rVar != null) {
                        vVarA.b("Content-Type", rVar.f599a);
                    }
                    long j2 = xVar.f668b;
                    if (j2 != -1) {
                        vVarA.b("Content-Length", String.valueOf(j2));
                        vVarA.f658c.e("Transfer-Encoding");
                    } else {
                        vVarA.b("Transfer-Encoding", "chunked");
                        vVarA.f658c.e("Content-Length");
                    }
                }
                boolean z4 = false;
                if (nVar.a("Host") == null) {
                    vVarA.b("Host", bb.b.w(pVar, false));
                }
                if (nVar.a("Connection") == null) {
                    vVarA.b("Connection", "Keep-Alive");
                }
                if (nVar.a("Accept-Encoding") == null && nVar.a("Range") == null) {
                    vVarA.b("Accept-Encoding", "gzip");
                    z4 = true;
                }
                bVar.getClass();
                k.e(pVar, "url");
                if (nVar.a("User-Agent") == null) {
                    vVarA.b("User-Agent", "okhttp/4.12.0");
                }
                z zVarB = gVar.b(vVarA.a());
                n nVar2 = zVarB.f689k;
                f.b(bVar, pVar, nVar2);
                y yVarD = zVarB.d();
                yVarD.f671a = wVar;
                if (z4 && "gzip".equalsIgnoreCase(z.a(zVarB, "Content-Encoding")) && f.a(zVarB) && (b0Var = zVarB.f690l) != null) {
                    s sVar = new s(b0Var.d());
                    m mVarH = nVar2.h();
                    mVarH.e("Content-Encoding");
                    mVarH.e("Content-Length");
                    yVarD.f676f = mVarH.d().h();
                    yVarD.f677g = new h(z.a(zVarB, "Content-Type"), -1L, ob.b.c(sVar));
                }
                return yVarD.a();
            default:
                w wVar2 = gVar.f3653e;
                i iVar = gVar.f3649a;
                List listD1 = d7.z.f2978f;
                z zVar = null;
                int i2 = 0;
                w wVarB = wVar2;
                while (true) {
                    boolean z10 = true;
                    while (true) {
                        k.e(wVarB, "request");
                        if (iVar.f3282p != null) {
                            throw new IllegalStateException("Check failed.");
                        }
                        synchronized (iVar) {
                            try {
                                if (iVar.f3284r) {
                                    throw new IllegalStateException("cannot make a new request because the previous response is still open: please call response.close()");
                                }
                                if (iVar.f3283q) {
                                    throw new IllegalStateException("Check failed.");
                                }
                            } catch (Throwable th) {
                                throw th;
                            }
                        }
                        if (z10) {
                            eb.n nVar3 = iVar.f3275i;
                            p pVar2 = wVarB.f661a;
                            t tVar = iVar.f3272f;
                            if (pVar2.f596i) {
                                SSLSocketFactory sSLSocketFactory2 = tVar.f641t;
                                if (sSLSocketFactory2 == null) {
                                    throw new IllegalStateException("CLEARTEXT-only client");
                                }
                                HostnameVerifier hostnameVerifier2 = tVar.f645x;
                                eVar = tVar.f646y;
                                sSLSocketFactory = sSLSocketFactory2;
                                hostnameVerifier = hostnameVerifier2;
                            } else {
                                sSLSocketFactory = null;
                                hostnameVerifier = null;
                                eVar = null;
                            }
                            iVar.f3279m = new eb.e(nVar3, new ab.a(pVar2.f591d, pVar2.f592e, tVar.f637p, tVar.f640s, sSLSocketFactory, hostnameVerifier, eVar, tVar.f639r, tVar.f644w, tVar.f643v, tVar.f638q), iVar);
                        }
                        try {
                            if (iVar.f3286t) {
                                throw new IOException("Canceled");
                            }
                            try {
                                z zVarB2 = gVar.b(wVarB);
                                if (zVar != null) {
                                    y yVarD2 = zVarB2.d();
                                    y yVarD3 = zVar.d();
                                    yVarD3.f677g = null;
                                    z zVarA = yVarD3.a();
                                    if (zVarA.f690l != null) {
                                        throw new IllegalArgumentException("priorResponse.body != null");
                                    }
                                    yVarD2.f680j = zVarA;
                                    zVarB2 = yVarD2.a();
                                }
                                zVar = zVarB2;
                                wVarB = b(zVar, iVar.f3282p);
                                if (wVarB == null) {
                                    iVar.h(false);
                                    return zVar;
                                }
                                b0 b0Var2 = zVar.f690l;
                                if (b0Var2 != null) {
                                    bb.b.d(b0Var2);
                                }
                                i2++;
                                if (i2 > 20) {
                                    throw new ProtocolException("Too many follow-up requests: " + i2);
                                }
                                iVar.h(true);
                            } catch (o e10) {
                                if (!c(e10.f3317g, iVar, wVarB, false)) {
                                    IOException iOException = e10.f3316f;
                                    k.e(iOException, "<this>");
                                    Iterator it = listD1.iterator();
                                    while (it.hasNext()) {
                                        ib.k.e(iOException, (Exception) it.next());
                                    }
                                    throw iOException;
                                }
                                listD1 = d7.r.d1(listD1, e10.f3316f);
                                iVar.h(true);
                                z10 = false;
                            } catch (IOException e11) {
                                if (!c(e11, iVar, wVarB, !(e11 instanceof hb.a))) {
                                    Iterator it2 = listD1.iterator();
                                    while (it2.hasNext()) {
                                        ib.k.e(e11, (Exception) it2.next());
                                    }
                                    throw e11;
                                }
                                listD1 = d7.r.d1(listD1, e11);
                                iVar.h(true);
                                z10 = false;
                            }
                        } catch (Throwable th2) {
                            iVar.h(true);
                            throw th2;
                        }
                    }
                }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:66:0x00c1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public ab.w b(ab.z r11, c1.o r12) throws java.net.ProtocolException {
        /*
            Method dump skipped, instructions count: 362
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: fb.a.b(ab.z, c1.o):ab.w");
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0085  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean c(java.io.IOException r3, eb.i r4, ab.w r5, boolean r6) {
        /*
            r2 = this;
            java.lang.Object r2 = r2.f3645b
            ab.t r2 = (ab.t) r2
            boolean r2 = r2.f632k
            r5 = 0
            if (r2 != 0) goto Lb
            goto L9d
        Lb:
            if (r6 == 0) goto L12
            boolean r2 = r3 instanceof java.io.FileNotFoundException
            if (r2 == 0) goto L12
            return r5
        L12:
            boolean r2 = r3 instanceof java.net.ProtocolException
            if (r2 == 0) goto L17
            return r5
        L17:
            boolean r2 = r3 instanceof java.io.InterruptedIOException
            if (r2 == 0) goto L22
            boolean r2 = r3 instanceof java.net.SocketTimeoutException
            if (r2 == 0) goto L9d
            if (r6 != 0) goto L9d
            goto L35
        L22:
            boolean r2 = r3 instanceof javax.net.ssl.SSLHandshakeException
            if (r2 == 0) goto L30
            java.lang.Throwable r2 = r3.getCause()
            boolean r2 = r2 instanceof java.security.cert.CertificateException
            if (r2 == 0) goto L30
            goto L9d
        L30:
            boolean r2 = r3 instanceof javax.net.ssl.SSLPeerUnverifiedException
            if (r2 == 0) goto L35
            return r5
        L35:
            eb.e r2 = r4.f3279m
            q7.k.b(r2)
            int r3 = r2.f3263f
            r4 = 1
            if (r3 != 0) goto L49
            int r6 = r2.f3264g
            if (r6 != 0) goto L49
            int r6 = r2.f3265h
            if (r6 != 0) goto L49
            r2 = r5
            goto L9b
        L49:
            ab.c0 r6 = r2.f3266i
            if (r6 == 0) goto L4e
            goto L96
        L4e:
            r6 = 0
            if (r3 > r4) goto L81
            int r3 = r2.f3264g
            if (r3 > r4) goto L81
            int r3 = r2.f3265h
            if (r3 <= 0) goto L5a
            goto L81
        L5a:
            eb.i r3 = r2.f3260c
            eb.m r3 = r3.f3280n
            if (r3 != 0) goto L61
            goto L81
        L61:
            monitor-enter(r3)
            int r0 = r3.f3306l     // Catch: java.lang.Throwable -> L7e
            if (r0 == 0) goto L68
            monitor-exit(r3)
            goto L81
        L68:
            ab.c0 r0 = r3.f3296b     // Catch: java.lang.Throwable -> L7e
            ab.a r0 = r0.f515a     // Catch: java.lang.Throwable -> L7e
            ab.p r0 = r0.f493h     // Catch: java.lang.Throwable -> L7e
            ab.a r1 = r2.f3259b     // Catch: java.lang.Throwable -> L7e
            ab.p r1 = r1.f493h     // Catch: java.lang.Throwable -> L7e
            boolean r0 = bb.b.a(r0, r1)     // Catch: java.lang.Throwable -> L7e
            if (r0 != 0) goto L7a
            monitor-exit(r3)
            goto L81
        L7a:
            ab.c0 r6 = r3.f3296b     // Catch: java.lang.Throwable -> L7e
            monitor-exit(r3)
            goto L81
        L7e:
            r2 = move-exception
            monitor-exit(r3)
            throw r2
        L81:
            if (r6 == 0) goto L87
            r2.f3266i = r6
        L85:
            r2 = r4
            goto L9b
        L87:
            d1.b r3 = r2.f3261d
            if (r3 == 0) goto L92
            boolean r3 = r3.g()
            if (r3 != r4) goto L92
            goto L96
        L92:
            eb.p r2 = r2.f3262e
            if (r2 != 0) goto L97
        L96:
            goto L85
        L97:
            boolean r2 = r2.m()
        L9b:
            if (r2 != 0) goto L9e
        L9d:
            return r5
        L9e:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: fb.a.c(java.io.IOException, eb.i, ab.w, boolean):boolean");
    }

    public a(t tVar) {
        this.f3645b = tVar;
    }
}
