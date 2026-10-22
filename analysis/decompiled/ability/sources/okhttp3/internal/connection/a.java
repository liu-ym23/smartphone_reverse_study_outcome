package okhttp3.internal.connection;

import D7.v;
import F9.AbstractC0226d;
import F9.C0223a;
import F9.F;
import F9.Q;
import F9.t;
import F9.y;
import J9.b;
import J9.i;
import J9.j;
import J9.k;
import K9.e;
import K9.g;
import M9.B;
import M9.f;
import M9.h;
import M9.o;
import M9.p;
import M9.w;
import M9.x;
import N9.m;
import V9.q;
import V9.r;
import h2.d;
import j9.n;
import java.io.IOException;
import java.net.ConnectException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import okhttp3.Protocol;
import okhttp3.c;
import okhttp3.internal.http2.ErrorCode;

/* loaded from: classes4.dex */
public final class a extends h {
    public final Q b;
    public Socket c;
    public Socket d;
    public c e;
    public Protocol f;
    public o g;
    public r h;
    public q i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f5471j;
    public boolean k;
    public int l;
    public int m;
    public int n;
    public int o;
    public final ArrayList p;

    /* renamed from: q, reason: collision with root package name */
    public long f5472q;

    public a(k connectionPool, Q route) {
        kotlin.jvm.internal.k.f(connectionPool, "connectionPool");
        kotlin.jvm.internal.k.f(route, "route");
        this.b = route;
        this.o = 1;
        this.p = new ArrayList();
        this.f5472q = Long.MAX_VALUE;
    }

    public static void d(F f, Q failedRoute, IOException failure) {
        kotlin.jvm.internal.k.f(failedRoute, "failedRoute");
        kotlin.jvm.internal.k.f(failure, "failure");
        if (failedRoute.b.type() != Proxy.Type.DIRECT) {
            C0223a c0223a = failedRoute.f635a;
            c0223a.h.connectFailed(c0223a.i.i(), failedRoute.b.address(), failure);
        }
        d dVar = f.f615B;
        synchronized (dVar) {
            ((LinkedHashSet) dVar.f4555a).add(failedRoute);
        }
    }

    @Override // M9.h
    public final synchronized void a(o oVar, B settings) {
        kotlin.jvm.internal.k.f(settings, "settings");
        this.o = (settings.f975a & 16) != 0 ? settings.b[4] : Integer.MAX_VALUE;
    }

    @Override // M9.h
    public final void b(w wVar) {
        wVar.c(ErrorCode.REFUSED_STREAM, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:54:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0124 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void c(int r15, int r16, int r17, boolean r18, J9.i r19, F9.t r20) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 314
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.connection.a.c(int, int, int, boolean, J9.i, F9.t):void");
    }

    public final void e(int i, int i6, i iVar, t tVar) throws IOException {
        Socket socketCreateSocket;
        Q q5 = this.b;
        Proxy proxy = q5.b;
        InetSocketAddress inetSocketAddress = q5.c;
        C0223a c0223a = q5.f635a;
        Proxy.Type type = proxy.type();
        int i10 = type == null ? -1 : j.f900a[type.ordinal()];
        if (i10 == 1 || i10 == 2) {
            socketCreateSocket = c0223a.b.createSocket();
            kotlin.jvm.internal.k.c(socketCreateSocket);
        } else {
            socketCreateSocket = new Socket(proxy);
        }
        this.c = socketCreateSocket;
        tVar.i(iVar, inetSocketAddress, proxy);
        socketCreateSocket.setSoTimeout(i6);
        try {
            m.Companion.getClass();
            m.platform.connectSocket(socketCreateSocket, inetSocketAddress, i);
            try {
                this.h = new r(M0.i.H(socketCreateSocket));
                this.i = M0.i.p(M0.i.G(socketCreateSocket));
            } catch (NullPointerException e) {
                if (kotlin.jvm.internal.k.b(e.getMessage(), "throw with null exception")) {
                    throw new IOException(e);
                }
            }
        } catch (ConnectException e6) {
            ConnectException connectException = new ConnectException("Failed to connect to " + inetSocketAddress);
            connectException.initCause(e6);
            throw connectException;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0149, code lost:
    
        if (r12 != null) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x014c, code lost:
    
        r7 = r27.c;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x014e, code lost:
    
        if (r7 == null) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0150, code lost:
    
        G9.b.d(r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0153, code lost:
    
        r7 = null;
        r27.c = null;
        r27.i = null;
        r27.h = null;
        r32.g(r31, r5.c, r5.b, null);
        r10 = r20 + 1;
        r9 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:?, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void f(int r28, int r29, int r30, J9.i r31, F9.t r32) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 367
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.connection.a.f(int, int, int, J9.i, F9.t):void");
    }

    public final void g(b bVar, i iVar, t tVar) throws Throwable {
        String str;
        SSLSocket sSLSocket;
        Q q5 = this.b;
        C0223a c0223a = q5.f635a;
        SSLSocketFactory sSLSocketFactory = c0223a.c;
        Protocol protocolH = Protocol.HTTP_1_1;
        if (sSLSocketFactory == null) {
            List list = c0223a.f637j;
            Protocol protocol = Protocol.H2_PRIOR_KNOWLEDGE;
            if (!list.contains(protocol)) {
                this.d = this.c;
                this.f = protocolH;
                return;
            } else {
                this.d = this.c;
                this.f = protocol;
                l();
                return;
            }
        }
        tVar.x(iVar);
        final C0223a c0223a2 = q5.f635a;
        SSLSocketFactory sSLSocketFactory2 = c0223a2.c;
        y yVar = c0223a2.i;
        SSLSocket sSLSocket2 = null;
        String selectedProtocol = null;
        try {
            kotlin.jvm.internal.k.c(sSLSocketFactory2);
            Socket socket = this.c;
            str = yVar.d;
            Socket socketCreateSocket = sSLSocketFactory2.createSocket(socket, str, yVar.e, true);
            kotlin.jvm.internal.k.d(socketCreateSocket, "null cannot be cast to non-null type javax.net.ssl.SSLSocket");
            sSLSocket = (SSLSocket) socketCreateSocket;
        } catch (Throwable th) {
            th = th;
        }
        try {
            boolean z10 = bVar.a(sSLSocket).b;
            if (z10) {
                m.Companion.getClass();
                m.platform.configureTlsExtensions(sSLSocket, str, c0223a2.f637j);
            }
            sSLSocket.startHandshake();
            SSLSession sslSocketSession = sSLSocket.getSession();
            kotlin.jvm.internal.k.e(sslSocketSession, "sslSocketSession");
            final c cVarA = okhttp3.b.a(sslSocketSession);
            HostnameVerifier hostnameVerifier = c0223a2.d;
            kotlin.jvm.internal.k.c(hostnameVerifier);
            if (hostnameVerifier.verify(str, sslSocketSession)) {
                final okhttp3.a aVar = c0223a2.e;
                kotlin.jvm.internal.k.c(aVar);
                this.e = new c(cVarA.f5467a, cVarA.b, cVarA.c, new S7.a() { // from class: okhttp3.internal.connection.RealConnection$connectTls$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // S7.a
                    public final Object invoke() {
                        S9.c cVar = aVar.b;
                        kotlin.jvm.internal.k.c(cVar);
                        return cVar.a(c0223a2.i.d, cVarA.a());
                    }
                });
                aVar.b(str, new S7.a() { // from class: okhttp3.internal.connection.RealConnection$connectTls$2
                    {
                        super(0);
                    }

                    @Override // S7.a
                    public final Object invoke() {
                        c cVar = this.f5469a.e;
                        kotlin.jvm.internal.k.c(cVar);
                        List<Certificate> listA = cVar.a();
                        ArrayList arrayList = new ArrayList(D7.w.c0(listA, 10));
                        for (Certificate certificate : listA) {
                            kotlin.jvm.internal.k.d(certificate, "null cannot be cast to non-null type java.security.cert.X509Certificate");
                            arrayList.add((X509Certificate) certificate);
                        }
                        return arrayList;
                    }
                });
                if (z10) {
                    m.Companion.getClass();
                    selectedProtocol = m.platform.getSelectedProtocol(sSLSocket);
                }
                this.d = sSLSocket;
                this.h = new r(M0.i.H(sSLSocket));
                this.i = M0.i.p(M0.i.G(sSLSocket));
                if (selectedProtocol != null) {
                    protocolH = AbstractC0226d.h(selectedProtocol);
                }
                this.f = protocolH;
                m.Companion.getClass();
                m.platform.afterHandshake(sSLSocket);
                tVar.w(iVar, this.e);
                if (this.f == Protocol.HTTP_2) {
                    l();
                    return;
                }
                return;
            }
            List listA = cVarA.a();
            if (listA.isEmpty()) {
                throw new SSLPeerUnverifiedException("Hostname " + str + " not verified (no certificates)");
            }
            Object obj = listA.get(0);
            kotlin.jvm.internal.k.d(obj, "null cannot be cast to non-null type java.security.cert.X509Certificate");
            X509Certificate x509Certificate = (X509Certificate) obj;
            StringBuilder sb = new StringBuilder("\n              |Hostname ");
            sb.append(str);
            sb.append(" not verified:\n              |    certificate: ");
            okhttp3.a aVar2 = okhttp3.a.c;
            sb.append(AbstractC0226d.l(x509Certificate));
            sb.append("\n              |    DN: ");
            sb.append(x509Certificate.getSubjectDN().getName());
            sb.append("\n              |    subjectAltNames: ");
            sb.append(v.Q0(S9.d.a(x509Certificate, 2), S9.d.a(x509Certificate, 7)));
            sb.append("\n              ");
            throw new SSLPeerUnverifiedException(n.S(sb.toString()));
        } catch (Throwable th2) {
            th = th2;
            sSLSocket2 = sSLSocket;
            if (sSLSocket2 != null) {
                m.Companion.getClass();
                m.platform.afterHandshake(sSLSocket2);
            }
            if (sSLSocket2 != null) {
                G9.b.d(sSLSocket2);
            }
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:52:0x00b9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean h(F9.C0223a r10, java.util.List r11) {
        /*
            r9 = this;
            F9.y r0 = r10.i
            byte[] r1 = G9.b.f704a
            java.util.ArrayList r1 = r9.p
            int r1 = r1.size()
            int r2 = r9.o
            r3 = 0
            if (r1 >= r2) goto Lcb
            boolean r1 = r9.f5471j
            if (r1 == 0) goto L15
            goto Lcb
        L15:
            F9.Q r1 = r9.b
            F9.a r2 = r1.f635a
            F9.a r4 = r1.f635a
            boolean r2 = r2.a(r10)
            if (r2 != 0) goto L23
            goto Lcb
        L23:
            java.lang.String r2 = r0.d
            java.lang.String r5 = r0.d
            F9.y r6 = r4.i
            java.lang.String r6 = r6.d
            boolean r2 = kotlin.jvm.internal.k.b(r2, r6)
            r6 = 1
            if (r2 == 0) goto L33
            return r6
        L33:
            M9.o r2 = r9.g
            if (r2 != 0) goto L39
            goto Lcb
        L39:
            if (r11 == 0) goto Lcb
            java.lang.Iterable r11 = (java.lang.Iterable) r11
            boolean r2 = r11 instanceof java.util.Collection
            if (r2 == 0) goto L4c
            r2 = r11
            java.util.Collection r2 = (java.util.Collection) r2
            boolean r2 = r2.isEmpty()
            if (r2 == 0) goto L4c
            goto Lcb
        L4c:
            java.util.Iterator r11 = r11.iterator()
        L50:
            boolean r2 = r11.hasNext()
            if (r2 == 0) goto Lcb
            java.lang.Object r2 = r11.next()
            F9.Q r2 = (F9.Q) r2
            java.net.Proxy r7 = r2.b
            java.net.Proxy$Type r7 = r7.type()
            java.net.Proxy$Type r8 = java.net.Proxy.Type.DIRECT
            if (r7 != r8) goto L50
            java.net.Proxy r7 = r1.b
            java.net.Proxy$Type r7 = r7.type()
            if (r7 != r8) goto L50
            java.net.InetSocketAddress r7 = r1.c
            java.net.InetSocketAddress r2 = r2.c
            boolean r2 = kotlin.jvm.internal.k.b(r7, r2)
            if (r2 == 0) goto L50
            javax.net.ssl.HostnameVerifier r11 = r10.d
            S9.d r1 = S9.d.f1183a
            if (r11 == r1) goto L7f
            goto Lcb
        L7f:
            byte[] r11 = G9.b.f704a
            F9.y r11 = r4.i
            int r0 = r0.e
            int r1 = r11.e
            if (r0 == r1) goto L8a
            goto Lcb
        L8a:
            java.lang.String r11 = r11.d
            boolean r11 = kotlin.jvm.internal.k.b(r5, r11)
            if (r11 == 0) goto L93
            goto Lb9
        L93:
            boolean r11 = r9.k
            if (r11 != 0) goto Lcb
            okhttp3.c r11 = r9.e
            if (r11 == 0) goto Lcb
            java.util.List r11 = r11.a()
            r0 = r11
            java.util.Collection r0 = (java.util.Collection) r0
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto Lcb
            java.lang.Object r11 = r11.get(r3)
            java.lang.String r0 = "null cannot be cast to non-null type java.security.cert.X509Certificate"
            kotlin.jvm.internal.k.d(r11, r0)
            java.security.cert.X509Certificate r11 = (java.security.cert.X509Certificate) r11
            boolean r11 = S9.d.c(r5, r11)
            if (r11 == 0) goto Lcb
        Lb9:
            okhttp3.a r10 = r10.e     // Catch: javax.net.ssl.SSLPeerUnverifiedException -> Lcb
            kotlin.jvm.internal.k.c(r10)     // Catch: javax.net.ssl.SSLPeerUnverifiedException -> Lcb
            okhttp3.c r9 = r9.e     // Catch: javax.net.ssl.SSLPeerUnverifiedException -> Lcb
            kotlin.jvm.internal.k.c(r9)     // Catch: javax.net.ssl.SSLPeerUnverifiedException -> Lcb
            java.util.List r9 = r9.a()     // Catch: javax.net.ssl.SSLPeerUnverifiedException -> Lcb
            r10.a(r5, r9)     // Catch: javax.net.ssl.SSLPeerUnverifiedException -> Lcb
            return r6
        Lcb:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.connection.a.h(F9.a, java.util.List):boolean");
    }

    public final boolean i(boolean z10) throws SocketException {
        long j5;
        byte[] bArr = G9.b.f704a;
        long jNanoTime = System.nanoTime();
        Socket socket = this.c;
        kotlin.jvm.internal.k.c(socket);
        Socket socket2 = this.d;
        kotlin.jvm.internal.k.c(socket2);
        kotlin.jvm.internal.k.c(this.h);
        if (socket.isClosed() || socket2.isClosed() || socket2.isInputShutdown() || socket2.isOutputShutdown()) {
            return false;
        }
        o oVar = this.g;
        if (oVar != null) {
            synchronized (oVar) {
                if (oVar.f) {
                    return false;
                }
                if (oVar.n < oVar.m) {
                    if (jNanoTime >= oVar.o) {
                        return false;
                    }
                }
                return true;
            }
        }
        synchronized (this) {
            j5 = jNanoTime - this.f5472q;
        }
        if (j5 < 10000000000L || !z10) {
            return true;
        }
        try {
            int soTimeout = socket2.getSoTimeout();
            try {
                socket2.setSoTimeout(1);
                return !r4.b();
            } finally {
                socket2.setSoTimeout(soTimeout);
            }
        } catch (SocketTimeoutException unused) {
            return true;
        } catch (IOException unused2) {
            return false;
        }
    }

    public final e j(F f, g gVar) throws SocketException {
        int i = gVar.g;
        Socket socket = this.d;
        kotlin.jvm.internal.k.c(socket);
        r rVar = this.h;
        kotlin.jvm.internal.k.c(rVar);
        q qVar = this.i;
        kotlin.jvm.internal.k.c(qVar);
        o oVar = this.g;
        if (oVar != null) {
            return new p(f, this, gVar, oVar);
        }
        socket.setSoTimeout(i);
        V9.y yVarTimeout = rVar.f1425a.timeout();
        long j5 = i;
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        yVarTimeout.g(j5);
        qVar.f1424a.timeout().g(gVar.h);
        return new A8.a(f, this, rVar, qVar);
    }

    public final synchronized void k() {
        this.f5471j = true;
    }

    public final void l() throws SocketException {
        Socket socket = this.d;
        kotlin.jvm.internal.k.c(socket);
        r rVar = this.h;
        kotlin.jvm.internal.k.c(rVar);
        q qVar = this.i;
        kotlin.jvm.internal.k.c(qVar);
        socket.setSoTimeout(0);
        I9.e taskRunner = I9.e.h;
        kotlin.jvm.internal.k.f(taskRunner, "taskRunner");
        f fVar = new f();
        fVar.f981a = taskRunner;
        fVar.f = h.f982a;
        String peerName = this.b.f635a.i.d;
        kotlin.jvm.internal.k.f(peerName, "peerName");
        fVar.b = socket;
        String str = G9.b.h + ' ' + peerName;
        kotlin.jvm.internal.k.f(str, "<set-?>");
        fVar.c = str;
        fVar.d = rVar;
        fVar.e = qVar;
        fVar.f = this;
        o oVar = new o(fVar);
        this.g = oVar;
        B b = o.f983z;
        this.o = (b.f975a & 16) != 0 ? b.b[4] : Integer.MAX_VALUE;
        x xVar = oVar.f991w;
        synchronized (xVar) {
            try {
                if (xVar.d) {
                    throw new IOException("closed");
                }
                Logger logger = x.f;
                if (logger.isLoggable(Level.FINE)) {
                    logger.fine(G9.b.g(">> CONNECTION " + M9.e.f980a.d(), new Object[0]));
                }
                xVar.f1000a.A(M9.e.f980a);
                xVar.f1000a.flush();
            } finally {
            }
        }
        x xVar2 = oVar.f991w;
        B settings = oVar.p;
        synchronized (xVar2) {
            try {
                kotlin.jvm.internal.k.f(settings, "settings");
                if (xVar2.d) {
                    throw new IOException("closed");
                }
                xVar2.f(0, Integer.bitCount(settings.f975a) * 6, 4, 0);
                int i = 0;
                while (i < 10) {
                    boolean z10 = true;
                    if (((1 << i) & settings.f975a) == 0) {
                        z10 = false;
                    }
                    if (z10) {
                        xVar2.f1000a.writeShort(i != 4 ? i != 7 ? i : 4 : 3);
                        xVar2.f1000a.writeInt(settings.b[i]);
                    }
                    i++;
                }
                xVar2.f1000a.flush();
            } finally {
            }
        }
        if (oVar.p.a() != 65535) {
            oVar.f991w.n(0, r9 - 65535);
        }
        taskRunner.e().c(new I9.b(0, oVar.f992x, oVar.c), 0L);
    }

    public final String toString() {
        Object obj;
        StringBuilder sb = new StringBuilder("Connection{");
        Q q5 = this.b;
        sb.append(q5.f635a.i.d);
        sb.append(':');
        sb.append(q5.f635a.i.e);
        sb.append(", proxy=");
        sb.append(q5.b);
        sb.append(" hostAddress=");
        sb.append(q5.c);
        sb.append(" cipherSuite=");
        c cVar = this.e;
        if (cVar == null || (obj = cVar.b) == null) {
            obj = "none";
        }
        sb.append(obj);
        sb.append(" protocol=");
        sb.append(this.f);
        sb.append('}');
        return sb.toString();
    }
}
