package eb;

import ab.c0;
import ab.t;
import ab.u;
import ab.v;
import ab.w;
import ab.y;
import ab.z;
import d7.r;
import hb.b0;
import hb.q;
import hb.x;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ConnectException;
import java.net.InetSocketAddress;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownServiceException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import ob.e0;
import ob.m0;

/* loaded from: classes.dex */
public final class m extends hb.h {

    /* renamed from: b, reason: collision with root package name */
    public final c0 f3296b;

    /* renamed from: c, reason: collision with root package name */
    public Socket f3297c;

    /* renamed from: d, reason: collision with root package name */
    public Socket f3298d;

    /* renamed from: e, reason: collision with root package name */
    public ab.l f3299e;

    /* renamed from: f, reason: collision with root package name */
    public u f3300f;

    /* renamed from: g, reason: collision with root package name */
    public hb.p f3301g;

    /* renamed from: h, reason: collision with root package name */
    public e0 f3302h;

    /* renamed from: i, reason: collision with root package name */
    public ob.c0 f3303i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f3304j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f3305k;

    /* renamed from: l, reason: collision with root package name */
    public int f3306l;

    /* renamed from: m, reason: collision with root package name */
    public int f3307m;

    /* renamed from: n, reason: collision with root package name */
    public int f3308n;

    /* renamed from: o, reason: collision with root package name */
    public int f3309o;

    /* renamed from: p, reason: collision with root package name */
    public final ArrayList f3310p;

    /* renamed from: q, reason: collision with root package name */
    public long f3311q;

    public m(n nVar, c0 c0Var) {
        q7.k.e(nVar, "connectionPool");
        q7.k.e(c0Var, "route");
        this.f3296b = c0Var;
        this.f3309o = 1;
        this.f3310p = new ArrayList();
        this.f3311q = Long.MAX_VALUE;
    }

    public static void d(t tVar, c0 c0Var, IOException iOException) {
        q7.k.e(c0Var, "failedRoute");
        q7.k.e(iOException, "failure");
        if (c0Var.f516b.type() != Proxy.Type.DIRECT) {
            ab.a aVar = c0Var.f515a;
            aVar.f492g.connectFailed(aVar.f493h.g(), c0Var.f516b.address(), iOException);
        }
        a7.d dVar = tVar.F;
        synchronized (dVar) {
            ((LinkedHashSet) dVar.f411g).add(c0Var);
        }
    }

    @Override // hb.h
    public final synchronized void a(hb.p pVar, b0 b0Var) {
        q7.k.e(b0Var, "settings");
        this.f3309o = (b0Var.f4265a & 16) != 0 ? b0Var.f4266b[4] : Integer.MAX_VALUE;
    }

    @Override // hb.h
    public final void b(x xVar) {
        xVar.c(8, null);
    }

    public final void c(int i2, int i10, int i11, int i12, boolean z4, i iVar) throws Throwable {
        c0 c0Var;
        if (this.f3300f != null) {
            throw new IllegalStateException("already connected");
        }
        List list = this.f3296b.f515a.f495j;
        b bVar = new b(list);
        ab.a aVar = this.f3296b.f515a;
        if (aVar.f488c == null) {
            if (!list.contains(ab.i.f553f)) {
                throw new o(new UnknownServiceException("CLEARTEXT communication not enabled for client"));
            }
            String str = this.f3296b.f515a.f493h.f591d;
            ib.m mVar = ib.m.f5049a;
            if (!ib.m.f5049a.f(str)) {
                throw new o(new UnknownServiceException(a1.a.j("CLEARTEXT communication to ", str, " not permitted by network security policy")));
            }
        } else if (aVar.f494i.contains(u.H2_PRIOR_KNOWLEDGE)) {
            throw new o(new UnknownServiceException("H2_PRIOR_KNOWLEDGE cannot be used with HTTPS"));
        }
        o oVar = null;
        do {
            try {
                c0 c0Var2 = this.f3296b;
                if (c0Var2.f515a.f488c != null && c0Var2.f516b.type() == Proxy.Type.HTTP) {
                    f(i2, i10, i11, iVar);
                    if (this.f3297c == null) {
                    }
                    c0Var = this.f3296b;
                    if (c0Var.f515a.f488c == null && c0Var.f516b.type() == Proxy.Type.HTTP && this.f3297c == null) {
                        throw new o(new ProtocolException("Too many tunnel connections attempted: 21"));
                    }
                    this.f3311q = System.nanoTime();
                    return;
                }
                e(i2, i10, iVar);
                g(bVar, i12, iVar);
                q7.k.e(this.f3296b.f517c, "inetSocketAddress");
                c0Var = this.f3296b;
                if (c0Var.f515a.f488c == null) {
                }
                this.f3311q = System.nanoTime();
                return;
            } catch (IOException e10) {
                Socket socket = this.f3298d;
                if (socket != null) {
                    bb.b.e(socket);
                }
                Socket socket2 = this.f3297c;
                if (socket2 != null) {
                    bb.b.e(socket2);
                }
                this.f3298d = null;
                this.f3297c = null;
                this.f3302h = null;
                this.f3303i = null;
                this.f3299e = null;
                this.f3300f = null;
                this.f3301g = null;
                this.f3309o = 1;
                q7.k.e(this.f3296b.f517c, "inetSocketAddress");
                if (oVar == null) {
                    oVar = new o(e10);
                } else {
                    ib.k.e(oVar.f3316f, e10);
                    oVar.f3317g = e10;
                }
                if (!z4) {
                    throw oVar;
                }
                bVar.f3246d = true;
                if (!bVar.f3245c) {
                    throw oVar;
                }
                if (e10 instanceof ProtocolException) {
                    throw oVar;
                }
                if (e10 instanceof InterruptedIOException) {
                    throw oVar;
                }
                if ((e10 instanceof SSLHandshakeException) && (e10.getCause() instanceof CertificateException)) {
                    throw oVar;
                }
                if (e10 instanceof SSLPeerUnverifiedException) {
                    throw oVar;
                }
            }
        } while (e10 instanceof SSLException);
        throw oVar;
    }

    public final void e(int i2, int i10, i iVar) throws IOException {
        Socket socketCreateSocket;
        c0 c0Var = this.f3296b;
        Proxy proxy = c0Var.f516b;
        ab.a aVar = c0Var.f515a;
        Proxy.Type type = proxy.type();
        int i11 = type == null ? -1 : j.$EnumSwitchMapping$0[type.ordinal()];
        if (i11 == 1 || i11 == 2) {
            socketCreateSocket = aVar.f487b.createSocket();
            q7.k.b(socketCreateSocket);
        } else {
            socketCreateSocket = new Socket(proxy);
        }
        this.f3297c = socketCreateSocket;
        q7.k.e(this.f3296b.f517c, "inetSocketAddress");
        socketCreateSocket.setSoTimeout(i10);
        try {
            ib.m mVar = ib.m.f5049a;
            ib.m mVar2 = ib.m.f5049a;
            InetSocketAddress inetSocketAddress = this.f3296b.f517c;
            mVar2.getClass();
            q7.k.e(inetSocketAddress, "address");
            socketCreateSocket.connect(inetSocketAddress, i2);
            try {
                this.f3302h = ob.b.c(ob.b.i(socketCreateSocket));
                this.f3303i = ob.b.b(ob.b.h(socketCreateSocket));
            } catch (NullPointerException e10) {
                if (q7.k.a(e10.getMessage(), "throw with null exception")) {
                    throw new IOException(e10);
                }
            }
        } catch (ConnectException e11) {
            ConnectException connectException = new ConnectException("Failed to connect to " + this.f3296b.f517c);
            connectException.initCause(e11);
            throw connectException;
        }
    }

    public final void f(int i2, int i10, int i11, i iVar) throws IOException {
        v vVar = new v();
        c0 c0Var = this.f3296b;
        ab.p pVar = c0Var.f515a.f493h;
        q7.k.e(pVar, "url");
        vVar.f656a = pVar;
        vVar.c("CONNECT", null);
        ab.a aVar = c0Var.f515a;
        vVar.b("Host", bb.b.w(aVar.f493h, true));
        vVar.b("Proxy-Connection", "Keep-Alive");
        vVar.b("User-Agent", "okhttp/4.12.0");
        w wVarA = vVar.a();
        ab.m mVar = new ab.m();
        s7.a.g("Proxy-Authenticate");
        s7.a.i("OkHttp-Preemptive", "Proxy-Authenticate");
        mVar.e("Proxy-Authenticate");
        mVar.b("Proxy-Authenticate", "OkHttp-Preemptive");
        mVar.d();
        aVar.f491f.getClass();
        ab.p pVar2 = wVarA.f661a;
        e(i2, i10, iVar);
        String str = "CONNECT " + bb.b.w(pVar2, true) + " HTTP/1.1";
        e0 e0Var = this.f3302h;
        q7.k.b(e0Var);
        ob.c0 c0Var2 = this.f3303i;
        q7.k.b(c0Var2);
        gb.h hVar = new gb.h(null, this, e0Var, c0Var2);
        m0 m0VarTimeout = e0Var.f7964f.timeout();
        long j2 = i10;
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        m0VarTimeout.g(j2, timeUnit);
        c0Var2.f7954f.timeout().g(i11, timeUnit);
        hVar.j(wVarA.f663c, str);
        hVar.a();
        y yVarE = hVar.e(false);
        q7.k.b(yVarE);
        yVarE.f671a = wVarA;
        z zVarA = yVarE.a();
        int i12 = zVarA.f687i;
        long jK = bb.b.k(zVarA);
        if (jK != -1) {
            gb.e eVarI = hVar.i(jK);
            bb.b.u(eVarI, Integer.MAX_VALUE);
            eVarI.close();
        }
        if (i12 != 200) {
            if (i12 != 407) {
                throw new IOException(n.f.c(i12, "Unexpected response code for CONNECT: "));
            }
            aVar.f491f.getClass();
            throw new IOException("Failed to authenticate with proxy");
        }
        if (!e0Var.f7965g.e() || !c0Var2.f7955g.e()) {
            throw new IOException("TLS tunnel buffered too many bytes!");
        }
    }

    public final void g(b bVar, int i2, i iVar) throws Throwable {
        u uVarO = u.HTTP_1_1;
        ab.a aVar = this.f3296b.f515a;
        SSLSocketFactory sSLSocketFactory = aVar.f488c;
        if (sSLSocketFactory == null) {
            List list = aVar.f494i;
            u uVar = u.H2_PRIOR_KNOWLEDGE;
            if (!list.contains(uVar)) {
                this.f3298d = this.f3297c;
                this.f3300f = uVarO;
                return;
            } else {
                this.f3298d = this.f3297c;
                this.f3300f = uVar;
                l(i2);
                return;
            }
        }
        SSLSocket sSLSocket = null;
        String strE = null;
        try {
            q7.k.b(sSLSocketFactory);
            Socket socket = this.f3297c;
            ab.p pVar = aVar.f493h;
            Socket socketCreateSocket = sSLSocketFactory.createSocket(socket, pVar.f591d, pVar.f592e, true);
            q7.k.c(socketCreateSocket, "null cannot be cast to non-null type javax.net.ssl.SSLSocket");
            SSLSocket sSLSocket2 = (SSLSocket) socketCreateSocket;
            try {
                ab.i iVarA = bVar.a(sSLSocket2);
                if (iVarA.f555b) {
                    ib.m mVar = ib.m.f5049a;
                    ib.m.f5049a.d(sSLSocket2, aVar.f493h.f591d, aVar.f494i);
                }
                sSLSocket2.startHandshake();
                SSLSession session = sSLSocket2.getSession();
                q7.k.d(session, "sslSocketSession");
                ab.l lVarY = ib.k.y(session);
                HostnameVerifier hostnameVerifier = aVar.f489d;
                q7.k.b(hostnameVerifier);
                boolean zVerify = hostnameVerifier.verify(aVar.f493h.f591d, session);
                int i10 = 0;
                if (zVerify) {
                    ab.e eVar = aVar.f490e;
                    q7.k.b(eVar);
                    this.f3299e = new ab.l(lVarY.f573a, lVarY.f574b, lVarY.f575c, new k(eVar, lVarY, aVar, i10));
                    q7.k.e(aVar.f493h.f591d, "hostname");
                    Iterator it = eVar.f526a.iterator();
                    if (it.hasNext()) {
                        it.next().getClass();
                        throw new ClassCastException();
                    }
                    if (iVarA.f555b) {
                        ib.m mVar2 = ib.m.f5049a;
                        strE = ib.m.f5049a.e(sSLSocket2);
                    }
                    this.f3298d = sSLSocket2;
                    this.f3302h = ob.b.c(ob.b.i(sSLSocket2));
                    this.f3303i = ob.b.b(ob.b.h(sSLSocket2));
                    if (strE != null) {
                        uVarO = a.a.O(strE);
                    }
                    this.f3300f = uVarO;
                    ib.m mVar3 = ib.m.f5049a;
                    ib.m.f5049a.a(sSLSocket2);
                    if (this.f3300f == u.HTTP_2) {
                        l(i2);
                        return;
                    }
                    return;
                }
                List listA = lVarY.a();
                if (listA.isEmpty()) {
                    throw new SSLPeerUnverifiedException("Hostname " + aVar.f493h.f591d + " not verified (no certificates)");
                }
                Object obj = listA.get(0);
                q7.k.c(obj, "null cannot be cast to non-null type java.security.cert.X509Certificate");
                X509Certificate x509Certificate = (X509Certificate) obj;
                StringBuilder sb2 = new StringBuilder("\n              |Hostname ");
                sb2.append(aVar.f493h.f591d);
                sb2.append(" not verified:\n              |    certificate: ");
                ab.e eVar2 = ab.e.f525c;
                StringBuilder sb3 = new StringBuilder("sha256/");
                ob.k kVar = ob.k.f7997i;
                byte[] encoded = x509Certificate.getPublicKey().getEncoded();
                q7.k.d(encoded, "publicKey.encoded");
                sb3.append(h4.n.q(encoded).c("SHA-256").a());
                sb2.append(sb3.toString());
                sb2.append("\n              |    DN: ");
                sb2.append(x509Certificate.getSubjectDN().getName());
                sb2.append("\n              |    subjectAltNames: ");
                sb2.append(r.c1(mb.c.a(x509Certificate, 7), mb.c.a(x509Certificate, 2)));
                sb2.append("\n              ");
                throw new SSLPeerUnverifiedException(ga.l.Y(sb2.toString()));
            } catch (Throwable th) {
                th = th;
                sSLSocket = sSLSocket2;
                if (sSLSocket != null) {
                    ib.m mVar4 = ib.m.f5049a;
                    ib.m.f5049a.a(sSLSocket);
                }
                if (sSLSocket != null) {
                    bb.b.e(sSLSocket);
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x00af A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean h(ab.a r11, java.util.List r12) {
        /*
            r10 = this;
            java.lang.String r0 = "hostname"
            ab.p r1 = r11.f493h
            byte[] r2 = bb.b.f1659a
            java.util.ArrayList r2 = r10.f3310p
            int r2 = r2.size()
            int r3 = r10.f3309o
            r4 = 0
            if (r2 >= r3) goto Le1
            boolean r2 = r10.f3304j
            if (r2 == 0) goto L17
            goto Le1
        L17:
            ab.c0 r2 = r10.f3296b
            ab.a r3 = r2.f515a
            ab.a r5 = r2.f515a
            boolean r3 = r3.a(r11)
            if (r3 != 0) goto L25
            goto Le1
        L25:
            java.lang.String r3 = r1.f591d
            java.lang.String r6 = r1.f591d
            ab.p r7 = r5.f493h
            java.lang.String r7 = r7.f591d
            boolean r3 = q7.k.a(r3, r7)
            r7 = 1
            if (r3 == 0) goto L35
            return r7
        L35:
            hb.p r3 = r10.f3301g
            if (r3 != 0) goto L3b
            goto Le1
        L3b:
            if (r12 == 0) goto Le1
            boolean r3 = r12.isEmpty()
            if (r3 == 0) goto L45
            goto Le1
        L45:
            java.util.Iterator r12 = r12.iterator()
        L49:
            boolean r3 = r12.hasNext()
            if (r3 == 0) goto Le1
            java.lang.Object r3 = r12.next()
            ab.c0 r3 = (ab.c0) r3
            java.net.Proxy r8 = r3.f516b
            java.net.Proxy$Type r8 = r8.type()
            java.net.Proxy$Type r9 = java.net.Proxy.Type.DIRECT
            if (r8 != r9) goto L49
            java.net.Proxy r8 = r2.f516b
            java.net.Proxy$Type r8 = r8.type()
            if (r8 != r9) goto L49
            java.net.InetSocketAddress r8 = r2.f517c
            java.net.InetSocketAddress r3 = r3.f517c
            boolean r3 = q7.k.a(r8, r3)
            if (r3 == 0) goto L49
            javax.net.ssl.HostnameVerifier r12 = r11.f489d
            mb.c r2 = mb.c.f6519a
            if (r12 == r2) goto L78
            goto Le1
        L78:
            byte[] r12 = bb.b.f1659a
            ab.p r12 = r5.f493h
            int r1 = r1.f592e
            int r2 = r12.f592e
            if (r1 == r2) goto L83
            goto Le1
        L83:
            java.lang.String r12 = r12.f591d
            boolean r12 = q7.k.a(r6, r12)
            if (r12 == 0) goto L8c
            goto Laf
        L8c:
            boolean r12 = r10.f3305k
            if (r12 != 0) goto Le1
            ab.l r12 = r10.f3299e
            if (r12 == 0) goto Le1
            java.util.List r12 = r12.a()
            boolean r1 = r12.isEmpty()
            if (r1 != 0) goto Le1
            java.lang.Object r12 = r12.get(r4)
            java.lang.String r1 = "null cannot be cast to non-null type java.security.cert.X509Certificate"
            q7.k.c(r12, r1)
            java.security.cert.X509Certificate r12 = (java.security.cert.X509Certificate) r12
            boolean r12 = mb.c.c(r6, r12)
            if (r12 == 0) goto Le1
        Laf:
            ab.e r11 = r11.f490e     // Catch: javax.net.ssl.SSLPeerUnverifiedException -> Le1
            q7.k.b(r11)     // Catch: javax.net.ssl.SSLPeerUnverifiedException -> Le1
            ab.l r10 = r10.f3299e     // Catch: javax.net.ssl.SSLPeerUnverifiedException -> Le1
            q7.k.b(r10)     // Catch: javax.net.ssl.SSLPeerUnverifiedException -> Le1
            java.util.List r10 = r10.a()     // Catch: javax.net.ssl.SSLPeerUnverifiedException -> Le1
            q7.k.e(r6, r0)     // Catch: javax.net.ssl.SSLPeerUnverifiedException -> Le1
            java.lang.String r12 = "peerCertificates"
            q7.k.e(r10, r12)     // Catch: javax.net.ssl.SSLPeerUnverifiedException -> Le1
            java.util.Set r10 = r11.f526a     // Catch: javax.net.ssl.SSLPeerUnverifiedException -> Le1
            java.lang.Iterable r10 = (java.lang.Iterable) r10     // Catch: javax.net.ssl.SSLPeerUnverifiedException -> Le1
            java.util.Iterator r10 = r10.iterator()     // Catch: javax.net.ssl.SSLPeerUnverifiedException -> Le1
            boolean r11 = r10.hasNext()     // Catch: javax.net.ssl.SSLPeerUnverifiedException -> Le1
            if (r11 != 0) goto Ld4
            return r7
        Ld4:
            java.lang.Object r10 = r10.next()     // Catch: javax.net.ssl.SSLPeerUnverifiedException -> Le1
            r10.getClass()     // Catch: javax.net.ssl.SSLPeerUnverifiedException -> Le1
            java.lang.ClassCastException r10 = new java.lang.ClassCastException     // Catch: javax.net.ssl.SSLPeerUnverifiedException -> Le1
            r10.<init>()     // Catch: javax.net.ssl.SSLPeerUnverifiedException -> Le1
            throw r10     // Catch: javax.net.ssl.SSLPeerUnverifiedException -> Le1
        Le1:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: eb.m.h(ab.a, java.util.List):boolean");
    }

    public final boolean i(boolean z4) throws SocketException {
        long j2;
        byte[] bArr = bb.b.f1659a;
        long jNanoTime = System.nanoTime();
        Socket socket = this.f3297c;
        q7.k.b(socket);
        Socket socket2 = this.f3298d;
        q7.k.b(socket2);
        q7.k.b(this.f3302h);
        if (socket.isClosed() || socket2.isClosed() || socket2.isInputShutdown() || socket2.isOutputShutdown()) {
            return false;
        }
        hb.p pVar = this.f3301g;
        if (pVar != null) {
            synchronized (pVar) {
                if (pVar.f4319k) {
                    return false;
                }
                if (pVar.f4328t < pVar.f4327s) {
                    if (jNanoTime >= pVar.f4329u) {
                        return false;
                    }
                }
                return true;
            }
        }
        synchronized (this) {
            j2 = jNanoTime - this.f3311q;
        }
        if (j2 < 10000000000L || !z4) {
            return true;
        }
        try {
            int soTimeout = socket2.getSoTimeout();
            try {
                socket2.setSoTimeout(1);
                return !r4.a();
            } finally {
                socket2.setSoTimeout(soTimeout);
            }
        } catch (SocketTimeoutException unused) {
            return true;
        } catch (IOException unused2) {
            return false;
        }
    }

    public final fb.e j(t tVar, fb.g gVar) {
        int i2 = gVar.f3655g;
        Socket socket = this.f3298d;
        q7.k.b(socket);
        e0 e0Var = this.f3302h;
        q7.k.b(e0Var);
        ob.c0 c0Var = this.f3303i;
        q7.k.b(c0Var);
        hb.p pVar = this.f3301g;
        if (pVar != null) {
            return new q(tVar, this, gVar, pVar);
        }
        socket.setSoTimeout(i2);
        m0 m0VarTimeout = e0Var.f7964f.timeout();
        long j2 = i2;
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        m0VarTimeout.g(j2, timeUnit);
        c0Var.f7954f.timeout().g(gVar.f3656h, timeUnit);
        return new gb.h(tVar, this, e0Var, c0Var);
    }

    public final synchronized void k() {
        this.f3304j = true;
    }

    public final void l(int i2) throws SocketException {
        Socket socket = this.f3298d;
        q7.k.b(socket);
        e0 e0Var = this.f3302h;
        q7.k.b(e0Var);
        ob.c0 c0Var = this.f3303i;
        q7.k.b(c0Var);
        socket.setSoTimeout(0);
        db.e eVar = db.e.f3030h;
        gb.h hVar = new gb.h(eVar);
        String str = this.f3296b.f515a.f493h.f591d;
        q7.k.e(str, "peerName");
        hVar.f4054d = socket;
        String str2 = bb.b.f1665g + ' ' + str;
        q7.k.e(str2, "<set-?>");
        hVar.f4055e = str2;
        hVar.f4056f = e0Var;
        hVar.f4057g = c0Var;
        hVar.f4058h = this;
        hVar.f4052b = i2;
        hb.p pVar = new hb.p(hVar);
        this.f3301g = pVar;
        b0 b0Var = hb.p.F;
        this.f3309o = (b0Var.f4265a & 16) != 0 ? b0Var.f4266b[4] : Integer.MAX_VALUE;
        hb.y yVar = pVar.C;
        synchronized (yVar) {
            try {
                if (yVar.f4382i) {
                    throw new IOException("closed");
                }
                Logger logger = hb.y.f4378k;
                if (logger.isLoggable(Level.FINE)) {
                    logger.fine(bb.b.i(">> CONNECTION " + hb.f.f4285a.e(), new Object[0]));
                }
                yVar.f4379f.v(hb.f.f4285a);
                yVar.f4379f.flush();
            } finally {
            }
        }
        hb.y yVar2 = pVar.C;
        b0 b0Var2 = pVar.f4330v;
        synchronized (yVar2) {
            try {
                q7.k.e(b0Var2, "settings");
                if (yVar2.f4382i) {
                    throw new IOException("closed");
                }
                yVar2.d(0, Integer.bitCount(b0Var2.f4265a) * 6, 4, 0);
                int i10 = 0;
                while (i10 < 10) {
                    boolean z4 = true;
                    if (((1 << i10) & b0Var2.f4265a) == 0) {
                        z4 = false;
                    }
                    if (z4) {
                        yVar2.f4379f.writeShort(i10 != 4 ? i10 != 7 ? i10 : 4 : 3);
                        yVar2.f4379f.writeInt(b0Var2.f4266b[i10]);
                    }
                    i10++;
                }
                yVar2.f4379f.flush();
            } finally {
            }
        }
        if (pVar.f4330v.a() != 65535) {
            pVar.C.n(0, r8 - 65535);
        }
        eVar.e().c(new db.b(0, pVar.D, pVar.f4316h), 0L);
    }

    public final String toString() {
        Object obj;
        StringBuilder sb2 = new StringBuilder("Connection{");
        c0 c0Var = this.f3296b;
        sb2.append(c0Var.f515a.f493h.f591d);
        sb2.append(':');
        sb2.append(c0Var.f515a.f493h.f592e);
        sb2.append(", proxy=");
        sb2.append(c0Var.f516b);
        sb2.append(" hostAddress=");
        sb2.append(c0Var.f517c);
        sb2.append(" cipherSuite=");
        ab.l lVar = this.f3299e;
        if (lVar == null || (obj = lVar.f574b) == null) {
            obj = "none";
        }
        sb2.append(obj);
        sb2.append(" protocol=");
        sb2.append(this.f3300f);
        sb2.append('}');
        return sb2.toString();
    }
}
