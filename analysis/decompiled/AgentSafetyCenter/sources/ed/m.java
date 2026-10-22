package ed;

import ad.d0;
import ad.e0;
import ad.i0;
import ad.q;
import ad.w;
import ad.x;
import ad.y;
import ad.z;
import androidx.exifinterface.media.ExifInterface;
import com.google.crypto.tink.shaded.protobuf.Reader;
import h5.t;
import hd.p;
import hd.r;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.invoke.VarHandle;
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
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import od.b0;
import od.c0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class m extends hd.h {

    /* renamed from: a, reason: collision with root package name */
    public i0 f3820a;

    /* renamed from: b, reason: collision with root package name */
    public Socket f3821b;

    /* renamed from: c, reason: collision with root package name */
    public Socket f3822c;

    /* renamed from: d, reason: collision with root package name */
    public ad.m f3823d;

    /* renamed from: e, reason: collision with root package name */
    public x f3824e;

    /* renamed from: f, reason: collision with root package name */
    public hd.o f3825f;

    /* renamed from: g, reason: collision with root package name */
    public c0 f3826g;

    /* renamed from: h, reason: collision with root package name */
    public b0 f3827h;
    public boolean i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f3828j;

    /* renamed from: k, reason: collision with root package name */
    public int f3829k;

    /* renamed from: l, reason: collision with root package name */
    public int f3830l;

    /* renamed from: m, reason: collision with root package name */
    public int f3831m;

    /* renamed from: n, reason: collision with root package name */
    public int f3832n;

    /* renamed from: o, reason: collision with root package name */
    public ArrayList f3833o;

    /* renamed from: p, reason: collision with root package name */
    public long f3834p;

    public static void c(w wVar, i0 i0Var, IOException iOException) {
        wVar.getClass();
        iOException.getClass();
        if (i0Var.f519b.type() != Proxy.Type.DIRECT) {
            ad.a aVar = i0Var.f518a;
            aVar.f427g.connectFailed(aVar.f428h.g(), i0Var.f519b.address(), iOException);
        }
        a2.i iVar = wVar.D;
        synchronized (iVar) {
            ((LinkedHashSet) iVar.f49f).add(i0Var);
        }
    }

    public final void b(int i, int i3, int i10, boolean z10, j jVar) throws Throwable {
        i0 i0Var = this.f3820a;
        Proxy proxy = i0Var.f519b;
        ad.a aVar = i0Var.f518a;
        if (this.f3824e != null) {
            od.f.e("already connected");
            return;
        }
        List list = aVar.f429j;
        list.getClass();
        b bVar = new b();
        bVar.f3770a = list;
        VarHandle.storeStoreFence();
        if (aVar.f423c == null) {
            if (!list.contains(ad.i.f513f)) {
                UnknownServiceException unknownServiceException = new UnknownServiceException("CLEARTEXT communication not enabled for client");
                n nVar = new n(unknownServiceException);
                nVar.f3835c = unknownServiceException;
                nVar.f3836f = unknownServiceException;
                VarHandle.storeStoreFence();
                throw nVar;
            }
            String str = aVar.f428h.f562d;
            id.n.Companion.getClass();
            if (!id.n.platform.isCleartextTrafficPermitted(str)) {
                UnknownServiceException unknownServiceException2 = new UnknownServiceException(k0.a.C("CLEARTEXT communication to ", str, " not permitted by network security policy"));
                n nVar2 = new n(unknownServiceException2);
                nVar2.f3835c = unknownServiceException2;
                nVar2.f3836f = unknownServiceException2;
                VarHandle.storeStoreFence();
                throw nVar2;
            }
        } else if (aVar.i.contains(x.H2_PRIOR_KNOWLEDGE)) {
            UnknownServiceException unknownServiceException3 = new UnknownServiceException("H2_PRIOR_KNOWLEDGE cannot be used with HTTPS");
            n nVar3 = new n(unknownServiceException3);
            nVar3.f3835c = unknownServiceException3;
            nVar3.f3836f = unknownServiceException3;
            VarHandle.storeStoreFence();
            throw nVar3;
        }
        n nVar4 = null;
        do {
            try {
                if (aVar.f423c != null && proxy.type() == Proxy.Type.HTTP) {
                    e(i, i3, i10, jVar);
                    if (this.f3821b == null) {
                    }
                    if (aVar.f423c != null || proxy.type() != Proxy.Type.HTTP || this.f3821b != null) {
                        this.f3834p = System.nanoTime();
                        return;
                    }
                    ProtocolException protocolException = new ProtocolException("Too many tunnel connections attempted: 21");
                    n nVar5 = new n(protocolException);
                    nVar5.f3835c = protocolException;
                    nVar5.f3836f = protocolException;
                    VarHandle.storeStoreFence();
                    throw nVar5;
                }
                d(i, i3, jVar);
                f(bVar, jVar);
                if (aVar.f423c != null) {
                }
                this.f3834p = System.nanoTime();
                return;
            } catch (IOException e10) {
                Socket socket = this.f3822c;
                if (socket != null) {
                    bd.b.e(socket);
                }
                Socket socket2 = this.f3821b;
                if (socket2 != null) {
                    bd.b.e(socket2);
                }
                this.f3822c = null;
                this.f3821b = null;
                this.f3826g = null;
                this.f3827h = null;
                this.f3823d = null;
                this.f3824e = null;
                this.f3825f = null;
                this.f3832n = 1;
                if (nVar4 == null) {
                    nVar4 = new n(e10);
                    nVar4.f3835c = e10;
                    nVar4.f3836f = e10;
                    VarHandle.storeStoreFence();
                } else {
                    com.stepos.statsrpk.h.b(nVar4.f3835c, e10);
                    nVar4.f3836f = e10;
                }
                if (!z10) {
                    throw nVar4;
                }
                bVar.f3773d = true;
                if (!bVar.f3772c) {
                    throw nVar4;
                }
                if (e10 instanceof ProtocolException) {
                    throw nVar4;
                }
                if (e10 instanceof InterruptedIOException) {
                    throw nVar4;
                }
                if ((e10 instanceof SSLHandshakeException) && (e10.getCause() instanceof CertificateException)) {
                    throw nVar4;
                }
                if (e10 instanceof SSLPeerUnverifiedException) {
                    throw nVar4;
                }
            }
        } while (e10 instanceof SSLException);
        throw nVar4;
    }

    public final void d(int i, int i3, j jVar) throws IOException {
        Socket socketCreateSocket;
        i0 i0Var = this.f3820a;
        InetSocketAddress inetSocketAddress = i0Var.f520c;
        Proxy proxy = i0Var.f519b;
        ad.a aVar = i0Var.f518a;
        Proxy.Type type = proxy.type();
        int i10 = type == null ? -1 : k.f3815a[type.ordinal()];
        if (i10 == 1 || i10 == 2) {
            socketCreateSocket = aVar.f422b.createSocket();
            socketCreateSocket.getClass();
        } else {
            socketCreateSocket = new Socket(proxy);
        }
        this.f3821b = socketCreateSocket;
        socketCreateSocket.setSoTimeout(i3);
        try {
            id.n.Companion.getClass();
            id.n.platform.connectSocket(socketCreateSocket, inetSocketAddress, i);
            try {
                this.f3826g = new c0(ac.a.X(socketCreateSocket));
                this.f3827h = ac.a.j(ac.a.U(socketCreateSocket));
            } catch (NullPointerException e10) {
                if (yb.k.a(e10.getMessage(), "throw with null exception")) {
                    throw new IOException(e10);
                }
            }
        } catch (ConnectException e11) {
            ConnectException connectException = new ConnectException("Failed to connect to " + inetSocketAddress);
            connectException.initCause(e11);
            throw connectException;
        }
    }

    public final void e(int i, int i3, int i10, j jVar) throws IOException {
        y yVar = new y();
        ad.a aVar = this.f3820a.f518a;
        q qVar = aVar.f428h;
        qVar.getClass();
        yVar.f631a = qVar;
        yVar.l("CONNECT", null);
        yVar.j("Host", bd.b.w(aVar.f428h, true));
        yVar.j("Proxy-Connection", "Keep-Alive");
        yVar.j("User-Agent", "okhttp/4.12.0");
        z zVarE = yVar.e();
        d0 d0Var = new d0();
        d0Var.f453a = zVarE;
        d0Var.f454b = x.HTTP_1_1;
        d0Var.f455c = 407;
        d0Var.f456d = "Preemptive Authenticate";
        d0Var.f459g = bd.b.f2076c;
        d0Var.f462k = -1L;
        d0Var.f463l = -1L;
        ne.b bVar = d0Var.f458f;
        bVar.getClass();
        id.c.h("Proxy-Authenticate");
        id.c.i("OkHttp-Preemptive", "Proxy-Authenticate");
        bVar.h("Proxy-Authenticate");
        bVar.b("Proxy-Authenticate", "OkHttp-Preemptive");
        d0Var.a();
        aVar.f426f.getClass();
        q qVar2 = (q) zVarE.f637b;
        d(i, i3, jVar);
        String str = "CONNECT " + bd.b.w(qVar2, true) + " HTTP/1.1";
        c0 c0Var = this.f3826g;
        c0Var.getClass();
        b0 b0Var = this.f3827h;
        b0Var.getClass();
        gd.g gVar = new gd.g(null, this, c0Var, b0Var);
        c0Var.f9427c.b().g(i3);
        b0Var.f9421c.b().g(i10);
        gVar.j((ad.n) zVarE.f639d, str);
        gVar.a();
        d0 d0VarB = gVar.b(false);
        d0VarB.getClass();
        d0VarB.f453a = zVarE;
        e0 e0VarA = d0VarB.a();
        int i11 = e0VarA.f471h;
        long j10 = bd.b.j(e0VarA);
        if (j10 != -1) {
            gd.d dVarI = gVar.i(j10);
            bd.b.u(dVarI, Reader.READ_DONE);
            dVarI.close();
        }
        if (i11 == 200) {
            if (c0Var.f9428f.A() && b0Var.f9422f.A()) {
                return;
            }
            od.f.l("TLS tunnel buffered too many bytes!");
            return;
        }
        if (i11 != 407) {
            od.f.l(k0.a.j(i11, "Unexpected response code for CONNECT: "));
        } else {
            aVar.f426f.getClass();
            od.f.l("Failed to authenticate with proxy");
        }
    }

    public final void f(b bVar, j jVar) throws Throwable {
        ad.a aVar = this.f3820a.f518a;
        SSLSocketFactory sSLSocketFactory = aVar.f423c;
        x xVarW = x.HTTP_1_1;
        if (sSLSocketFactory == null) {
            List list = aVar.i;
            x xVar = x.H2_PRIOR_KNOWLEDGE;
            boolean zContains = list.contains(xVar);
            Socket socket = this.f3821b;
            if (!zContains) {
                this.f3822c = socket;
                this.f3824e = xVarW;
                return;
            } else {
                this.f3822c = socket;
                this.f3824e = xVar;
                k();
                return;
            }
        }
        q qVar = aVar.f428h;
        SSLSocket sSLSocket = null;
        String selectedProtocol = null;
        try {
            sSLSocketFactory.getClass();
            Socket socket2 = this.f3821b;
            String str = qVar.f562d;
            Socket socketCreateSocket = sSLSocketFactory.createSocket(socket2, str, qVar.f563e, true);
            socketCreateSocket.getClass();
            SSLSocket sSLSocket2 = (SSLSocket) socketCreateSocket;
            try {
                boolean z10 = bVar.a(sSLSocket2).f515b;
                if (z10) {
                    id.n.Companion.getClass();
                    id.n.platform.configureTlsExtensions(sSLSocket2, str, aVar.i);
                }
                sSLSocket2.startHandshake();
                SSLSession session = sSLSocket2.getSession();
                session.getClass();
                ad.m mVarX = t.x(session);
                HostnameVerifier hostnameVerifier = aVar.f424d;
                hostnameVerifier.getClass();
                boolean zVerify = hostnameVerifier.verify(str, session);
                int i = 0;
                if (!zVerify) {
                    List listA = mVarX.a();
                    if (listA.isEmpty()) {
                        throw new SSLPeerUnverifiedException("Hostname " + str + " not verified (no certificates)");
                    }
                    Object obj = listA.get(0);
                    obj.getClass();
                    X509Certificate x509Certificate = (X509Certificate) obj;
                    StringBuilder sb2 = new StringBuilder("\n              |Hostname ");
                    sb2.append(str);
                    sb2.append(" not verified:\n              |    certificate: ");
                    ad.e eVar = ad.e.f465c;
                    sb2.append(ac.a.M(x509Certificate));
                    sb2.append("\n              |    DN: ");
                    sb2.append(x509Certificate.getSubjectDN().getName());
                    sb2.append("\n              |    subjectAltNames: ");
                    sb2.append(kb.l.F0(md.d.a(x509Certificate, 7), md.d.a(x509Certificate, 2)));
                    sb2.append("\n              ");
                    throw new SSLPeerUnverifiedException(hc.i.O(sb2.toString()));
                }
                ad.e eVar2 = aVar.f425e;
                eVar2.getClass();
                this.f3823d = new ad.m(mVarX.f544a, mVarX.f545b, mVarX.f546c, new l(eVar2, mVarX, aVar, i));
                str.getClass();
                Iterator it = eVar2.f466a.iterator();
                if (it.hasNext()) {
                    it.next().getClass();
                    throw new ClassCastException();
                }
                if (z10) {
                    id.n.Companion.getClass();
                    selectedProtocol = id.n.platform.getSelectedProtocol(sSLSocket2);
                }
                this.f3822c = sSLSocket2;
                this.f3826g = new c0(ac.a.X(sSLSocket2));
                this.f3827h = ac.a.j(ac.a.U(sSLSocket2));
                if (selectedProtocol != null) {
                    xVarW = p5.f.w(selectedProtocol);
                }
                this.f3824e = xVarW;
                id.n.Companion.getClass();
                id.n.platform.afterHandshake(sSLSocket2);
                if (this.f3824e == x.HTTP_2) {
                    k();
                }
            } catch (Throwable th) {
                th = th;
                sSLSocket = sSLSocket2;
                if (sSLSocket != null) {
                    id.n.Companion.getClass();
                    id.n.platform.afterHandshake(sSLSocket);
                }
                if (sSLSocket != null) {
                    bd.b.e(sSLSocket);
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:54:0x00a9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean g(ad.a r9, java.util.List r10) {
        /*
            r8 = this;
            ad.i0 r0 = r8.f3820a
            ad.a r1 = r0.f518a
            ad.q r2 = r9.f428h
            byte[] r3 = bd.b.f2074a
            java.util.ArrayList r3 = r8.f3833o
            int r3 = r3.size()
            int r4 = r8.f3832n
            r5 = 0
            if (r3 >= r4) goto Lda
            boolean r3 = r8.i
            if (r3 == 0) goto L19
            goto Lda
        L19:
            boolean r3 = r1.a(r9)
            if (r3 != 0) goto L21
            goto Lda
        L21:
            java.lang.String r3 = r2.f562d
            java.lang.String r4 = r2.f562d
            ad.q r6 = r1.f428h
            java.lang.String r6 = r6.f562d
            boolean r3 = yb.k.a(r3, r6)
            if (r3 == 0) goto L31
            goto Lcb
        L31:
            hd.o r3 = r8.f3825f
            if (r3 != 0) goto L37
            goto Lda
        L37:
            if (r10 == 0) goto Lda
            boolean r3 = r10.isEmpty()
            if (r3 == 0) goto L41
            goto Lda
        L41:
            java.util.Iterator r10 = r10.iterator()
        L45:
            boolean r3 = r10.hasNext()
            if (r3 == 0) goto Lda
            java.lang.Object r3 = r10.next()
            ad.i0 r3 = (ad.i0) r3
            java.net.Proxy r6 = r3.f519b
            java.net.Proxy$Type r6 = r6.type()
            java.net.Proxy$Type r7 = java.net.Proxy.Type.DIRECT
            if (r6 != r7) goto L45
            java.net.Proxy r6 = r0.f519b
            java.net.Proxy$Type r6 = r6.type()
            if (r6 != r7) goto L45
            java.net.InetSocketAddress r6 = r0.f520c
            java.net.InetSocketAddress r3 = r3.f520c
            boolean r3 = r6.equals(r3)
            if (r3 == 0) goto L45
            javax.net.ssl.HostnameVerifier r10 = r9.f424d
            md.d r0 = md.d.f8608a
            if (r10 == r0) goto L74
            goto Lda
        L74:
            byte[] r10 = bd.b.f2074a
            ad.q r10 = r1.f428h
            int r0 = r2.f563e
            int r1 = r10.f563e
            if (r0 == r1) goto L7f
            goto Lda
        L7f:
            java.lang.String r10 = r10.f562d
            boolean r10 = yb.k.a(r4, r10)
            if (r10 == 0) goto L88
            goto La9
        L88:
            boolean r10 = r8.f3828j
            if (r10 != 0) goto Lda
            ad.m r10 = r8.f3823d
            if (r10 == 0) goto Lda
            java.util.List r10 = r10.a()
            boolean r0 = r10.isEmpty()
            if (r0 != 0) goto Lda
            java.lang.Object r10 = r10.get(r5)
            r10.getClass()
            java.security.cert.X509Certificate r10 = (java.security.cert.X509Certificate) r10
            boolean r10 = md.d.c(r4, r10)
            if (r10 == 0) goto Lda
        La9:
            ad.e r9 = r9.f425e     // Catch: javax.net.ssl.SSLPeerUnverifiedException -> Lda
            r9.getClass()     // Catch: javax.net.ssl.SSLPeerUnverifiedException -> Lda
            ad.m r8 = r8.f3823d     // Catch: javax.net.ssl.SSLPeerUnverifiedException -> Lda
            r8.getClass()     // Catch: javax.net.ssl.SSLPeerUnverifiedException -> Lda
            java.util.List r8 = r8.a()     // Catch: javax.net.ssl.SSLPeerUnverifiedException -> Lda
            r4.getClass()     // Catch: javax.net.ssl.SSLPeerUnverifiedException -> Lda
            r8.getClass()     // Catch: javax.net.ssl.SSLPeerUnverifiedException -> Lda
            java.util.Set r8 = r9.f466a     // Catch: javax.net.ssl.SSLPeerUnverifiedException -> Lda
            java.lang.Iterable r8 = (java.lang.Iterable) r8     // Catch: javax.net.ssl.SSLPeerUnverifiedException -> Lda
            java.util.Iterator r8 = r8.iterator()     // Catch: javax.net.ssl.SSLPeerUnverifiedException -> Lda
            boolean r9 = r8.hasNext()     // Catch: javax.net.ssl.SSLPeerUnverifiedException -> Lda
            if (r9 != 0) goto Lcd
        Lcb:
            r8 = 1
            return r8
        Lcd:
            java.lang.Object r8 = r8.next()     // Catch: javax.net.ssl.SSLPeerUnverifiedException -> Lda
            r8.getClass()     // Catch: javax.net.ssl.SSLPeerUnverifiedException -> Lda
            java.lang.ClassCastException r8 = new java.lang.ClassCastException     // Catch: javax.net.ssl.SSLPeerUnverifiedException -> Lda
            r8.<init>()     // Catch: javax.net.ssl.SSLPeerUnverifiedException -> Lda
            throw r8     // Catch: javax.net.ssl.SSLPeerUnverifiedException -> Lda
        Lda:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ed.m.g(ad.a, java.util.List):boolean");
    }

    public final boolean h(boolean z10) throws SocketException {
        long j10;
        byte[] bArr = bd.b.f2074a;
        long jNanoTime = System.nanoTime();
        Socket socket = this.f3821b;
        socket.getClass();
        Socket socket2 = this.f3822c;
        socket2.getClass();
        this.f3826g.getClass();
        if (socket.isClosed() || socket2.isClosed() || socket2.isInputShutdown() || socket2.isOutputShutdown()) {
            return false;
        }
        hd.o oVar = this.f3825f;
        if (oVar != null) {
            synchronized (oVar) {
                if (oVar.f5522j) {
                    return false;
                }
                if (oVar.f5530r < oVar.f5529q) {
                    if (jNanoTime >= oVar.f5531s) {
                        return false;
                    }
                }
                return true;
            }
        }
        synchronized (this) {
            j10 = jNanoTime - this.f3834p;
        }
        if (j10 < 10000000000L || !z10) {
            return true;
        }
        try {
            int soTimeout = socket2.getSoTimeout();
            try {
                socket2.setSoTimeout(1);
                return !r4.d();
            } finally {
                socket2.setSoTimeout(soTimeout);
            }
        } catch (SocketTimeoutException unused) {
            return true;
        } catch (IOException unused2) {
            return false;
        }
    }

    public final fd.d i(w wVar, fd.f fVar) throws SocketException {
        wVar.getClass();
        int i = fVar.f4068g;
        Socket socket = this.f3822c;
        socket.getClass();
        c0 c0Var = this.f3826g;
        c0Var.getClass();
        b0 b0Var = this.f3827h;
        b0Var.getClass();
        hd.o oVar = this.f3825f;
        if (oVar == null) {
            socket.setSoTimeout(i);
            c0Var.f9427c.b().g(i);
            b0Var.f9421c.b().g(fVar.f4069h);
            return new gd.g(wVar, this, c0Var, b0Var);
        }
        p pVar = new p();
        pVar.f5541a = this;
        pVar.f5542b = fVar;
        pVar.f5543c = oVar;
        List list = wVar.f619v;
        x xVar = x.H2_PRIOR_KNOWLEDGE;
        if (!list.contains(xVar)) {
            xVar = x.HTTP_2;
        }
        pVar.f5545e = xVar;
        VarHandle.storeStoreFence();
        return pVar;
    }

    public final synchronized void j() {
        this.i = true;
    }

    public final void k() throws SocketException {
        Socket socket = this.f3822c;
        socket.getClass();
        c0 c0Var = this.f3826g;
        c0Var.getClass();
        b0 b0Var = this.f3827h;
        b0Var.getClass();
        int i = 0;
        socket.setSoTimeout(0);
        dd.d dVar = dd.d.f3311h;
        dVar.getClass();
        hd.y yVar = hd.y.f5587a;
        String str = this.f3820a.f518a.f428h.f562d;
        str.getClass();
        String str2 = bd.b.f2080g + ' ' + str;
        hd.o oVar = new hd.o();
        oVar.f5518c = this;
        oVar.f5519f = new LinkedHashMap();
        oVar.f5520g = str2;
        oVar.i = 3;
        oVar.f5523k = dVar;
        oVar.f5524l = dVar.e();
        oVar.f5525m = dVar.e();
        oVar.f5526n = dVar.e();
        oVar.f5527o = yVar;
        hd.z zVar = new hd.z();
        zVar.b(7, 16777216);
        oVar.f5532t = zVar;
        hd.z zVar2 = hd.o.D;
        oVar.f5533u = zVar2;
        oVar.f5537y = zVar2.a();
        oVar.f5538z = socket;
        hd.w wVar = new hd.w();
        wVar.f5580c = b0Var;
        od.i iVar = new od.i();
        wVar.f5581f = iVar;
        wVar.f5582g = 16384;
        hd.d dVar2 = new hd.d();
        dVar2.f5483a = iVar;
        int i3 = Reader.READ_DONE;
        dVar2.f5484b = Reader.READ_DONE;
        dVar2.f5486d = 4096;
        dVar2.f5487e = new hd.b[8];
        dVar2.f5488f = 7;
        VarHandle.storeStoreFence();
        wVar.i = dVar2;
        VarHandle.storeStoreFence();
        oVar.A = wVar;
        r rVar = new r();
        rVar.f5553c = c0Var;
        hd.q qVar = new hd.q();
        qVar.f5547c = c0Var;
        VarHandle.storeStoreFence();
        rVar.f5554f = qVar;
        hd.c cVar = new hd.c();
        cVar.f5476a = 4096;
        cVar.f5477b = new ArrayList();
        cVar.f5478c = new c0(qVar);
        cVar.f5479d = new hd.b[8];
        cVar.f5480e = 7;
        VarHandle.storeStoreFence();
        rVar.f5555g = cVar;
        VarHandle.storeStoreFence();
        hd.k kVar = new hd.k(i);
        kVar.f5506g = oVar;
        kVar.f5505f = rVar;
        VarHandle.storeStoreFence();
        oVar.B = kVar;
        oVar.C = new LinkedHashSet();
        VarHandle.storeStoreFence();
        this.f3825f = oVar;
        if ((zVar2.f5588a & 16) != 0) {
            i3 = zVar2.f5589b[4];
        }
        this.f3832n = i3;
        synchronized (wVar) {
            try {
                if (wVar.f5583h) {
                    throw new IOException("closed");
                }
                Logger logger = hd.w.f5579j;
                if (logger.isLoggable(Level.FINE)) {
                    logger.fine(bd.b.h(">> CONNECTION " + hd.f.f5493a.d(), new Object[0]));
                }
                b0Var.t(hd.f.f5493a);
                b0Var.flush();
            } finally {
            }
        }
        synchronized (wVar) {
            try {
                if (wVar.f5583h) {
                    throw new IOException("closed");
                }
                wVar.g(0, Integer.bitCount(zVar.f5588a) * 6, 4, 0);
                int i10 = 0;
                while (i10 < 10) {
                    boolean z10 = true;
                    if (((1 << i10) & zVar.f5588a) == 0) {
                        z10 = false;
                    }
                    if (z10) {
                        int i11 = i10 != 4 ? i10 != 7 ? i10 : 4 : 3;
                        b0 b0Var2 = wVar.f5580c;
                        if (b0Var2.f9423g) {
                            throw new IllegalStateException("closed");
                        }
                        od.i iVar2 = b0Var2.f9422f;
                        od.d0 d0VarY = iVar2.Y(2);
                        byte[] bArr = d0VarY.f9437a;
                        int i12 = d0VarY.f9439c;
                        bArr[i12] = (byte) ((i11 >>> 8) & 255);
                        bArr[i12 + 1] = (byte) (i11 & 255);
                        d0VarY.f9439c = i12 + 2;
                        iVar2.f9454f += 2;
                        b0Var2.d();
                        wVar.f5580c.e(zVar.f5589b[i10]);
                    }
                    i10++;
                }
                wVar.f5580c.flush();
            } finally {
            }
        }
        if (oVar.f5532t.a() != 65535) {
            oVar.A.A(0, r0 - ExifInterface.COLOR_SPACE_UNCALIBRATED);
        }
        dVar.e().c(new dd.b(oVar.f5520g, i, oVar.B), 0L);
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("Connection{");
        i0 i0Var = this.f3820a;
        ad.a aVar = i0Var.f518a;
        sb2.append(aVar.f428h.f562d);
        sb2.append(':');
        sb2.append(aVar.f428h.f563e);
        sb2.append(", proxy=");
        sb2.append(i0Var.f519b);
        sb2.append(" hostAddress=");
        sb2.append(i0Var.f520c);
        sb2.append(" cipherSuite=");
        ad.m mVar = this.f3823d;
        sb2.append(mVar != null ? mVar.f545b : "none");
        sb2.append(" protocol=");
        sb2.append(this.f3824e);
        sb2.append('}');
        return sb2.toString();
    }
}
