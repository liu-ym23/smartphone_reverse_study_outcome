package F4;

import C4.A;
import C4.B;
import C4.C0271a;
import C4.C0277g;
import C4.D;
import C4.F;
import C4.H;
import C4.InterfaceC0275e;
import C4.l;
import C4.s;
import C4.u;
import C4.w;
import C4.x;
import I4.f;
import I4.n;
import L4.o;
import L4.z;
import java.io.IOException;
import java.lang.ref.Reference;
import java.net.ConnectException;
import java.net.Proxy;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;

/* loaded from: classes.dex */
public final class e extends f.j implements C4.j {

    /* renamed from: b, reason: collision with root package name */
    public final g f1786b;

    /* renamed from: c, reason: collision with root package name */
    private final H f1787c;

    /* renamed from: d, reason: collision with root package name */
    private Socket f1788d;

    /* renamed from: e, reason: collision with root package name */
    private Socket f1789e;

    /* renamed from: f, reason: collision with root package name */
    private u f1790f;

    /* renamed from: g, reason: collision with root package name */
    private B f1791g;

    /* renamed from: h, reason: collision with root package name */
    private I4.f f1792h;

    /* renamed from: i, reason: collision with root package name */
    private L4.g f1793i;

    /* renamed from: j, reason: collision with root package name */
    private L4.f f1794j;

    /* renamed from: k, reason: collision with root package name */
    boolean f1795k;

    /* renamed from: l, reason: collision with root package name */
    int f1796l;

    /* renamed from: m, reason: collision with root package name */
    int f1797m;

    /* renamed from: n, reason: collision with root package name */
    private int f1798n;

    /* renamed from: o, reason: collision with root package name */
    private int f1799o = 1;

    /* renamed from: p, reason: collision with root package name */
    final List<Reference<k>> f1800p = new ArrayList();

    /* renamed from: q, reason: collision with root package name */
    long f1801q = Long.MAX_VALUE;

    public e(g gVar, H h5) {
        this.f1786b = gVar;
        this.f1787c = h5;
    }

    private void e(int i5, int i6, InterfaceC0275e interfaceC0275e, s sVar) throws IOException {
        Proxy proxyB = this.f1787c.b();
        this.f1788d = (proxyB.type() == Proxy.Type.DIRECT || proxyB.type() == Proxy.Type.HTTP) ? this.f1787c.a().j().createSocket() : new Socket(proxyB);
        sVar.g(interfaceC0275e, this.f1787c.d(), proxyB);
        this.f1788d.setSoTimeout(i6);
        try {
            okhttp3.internal.platform.f.get().connectSocket(this.f1788d, this.f1787c.d(), i5);
            try {
                this.f1793i = o.b(o.f(this.f1788d));
                this.f1794j = o.a(o.d(this.f1788d));
            } catch (NullPointerException e6) {
                if ("throw with null exception".equals(e6.getMessage())) {
                    throw new IOException(e6);
                }
            }
        } catch (ConnectException e7) {
            ConnectException connectException = new ConnectException("Failed to connect to " + this.f1787c.d());
            connectException.initCause(e7);
            throw connectException;
        }
    }

    private void f(b bVar) throws Throwable {
        SSLSocket sSLSocket;
        C0271a c0271aA = this.f1787c.a();
        SSLSocket sSLSocket2 = null;
        try {
            try {
                sSLSocket = (SSLSocket) c0271aA.k().createSocket(this.f1788d, c0271aA.l().m(), c0271aA.l().y(), true);
            } catch (AssertionError e6) {
                e = e6;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            l lVarA = bVar.a(sSLSocket);
            if (lVarA.f()) {
                okhttp3.internal.platform.f.get().configureTlsExtensions(sSLSocket, c0271aA.l().m(), c0271aA.f());
            }
            sSLSocket.startHandshake();
            SSLSession session = sSLSocket.getSession();
            u uVarB = u.b(session);
            if (c0271aA.e().verify(c0271aA.l().m(), session)) {
                c0271aA.a().a(c0271aA.l().m(), uVarB.d());
                String selectedProtocol = lVarA.f() ? okhttp3.internal.platform.f.get().getSelectedProtocol(sSLSocket) : null;
                this.f1789e = sSLSocket;
                this.f1793i = o.b(o.f(sSLSocket));
                this.f1794j = o.a(o.d(this.f1789e));
                this.f1790f = uVarB;
                this.f1791g = selectedProtocol != null ? B.b(selectedProtocol) : B.HTTP_1_1;
                okhttp3.internal.platform.f.get().afterHandshake(sSLSocket);
                return;
            }
            List<Certificate> listD = uVarB.d();
            if (listD.isEmpty()) {
                throw new SSLPeerUnverifiedException("Hostname " + c0271aA.l().m() + " not verified (no certificates)");
            }
            X509Certificate x509Certificate = (X509Certificate) listD.get(0);
            throw new SSLPeerUnverifiedException("Hostname " + c0271aA.l().m() + " not verified:\n    certificate: " + C0277g.c(x509Certificate) + "\n    DN: " + x509Certificate.getSubjectDN().getName() + "\n    subjectAltNames: " + K4.d.a(x509Certificate));
        } catch (AssertionError e7) {
            e = e7;
            if (!D4.e.A(e)) {
                throw e;
            }
            throw new IOException(e);
        } catch (Throwable th2) {
            th = th2;
            sSLSocket2 = sSLSocket;
            if (sSLSocket2 != null) {
                okhttp3.internal.platform.f.get().afterHandshake(sSLSocket2);
            }
            D4.e.h(sSLSocket2);
            throw th;
        }
    }

    private void g(int i5, int i6, int i7, InterfaceC0275e interfaceC0275e, s sVar) throws IOException {
        D dI = i();
        w wVarI = dI.i();
        for (int i8 = 0; i8 < 21; i8++) {
            e(i5, i6, interfaceC0275e, sVar);
            dI = h(i6, i7, dI, wVarI);
            if (dI == null) {
                return;
            }
            D4.e.h(this.f1788d);
            this.f1788d = null;
            this.f1794j = null;
            this.f1793i = null;
            sVar.e(interfaceC0275e, this.f1787c.d(), this.f1787c.b(), null);
        }
    }

    private D h(int i5, int i6, D d6, w wVar) throws IOException {
        String str = "CONNECT " + D4.e.s(wVar, true) + " HTTP/1.1";
        while (true) {
            H4.a aVar = new H4.a(null, null, this.f1793i, this.f1794j);
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            this.f1793i.b().g(i5, timeUnit);
            this.f1794j.b().g(i6, timeUnit);
            aVar.B(d6.d(), str);
            aVar.a();
            F fC = aVar.b(false).q(d6).c();
            aVar.A(fC);
            int iM = fC.m();
            if (iM == 200) {
                if (this.f1793i.s().t() && this.f1794j.i().t()) {
                    return null;
                }
                throw new IOException("TLS tunnel buffered too many bytes!");
            }
            if (iM != 407) {
                throw new IOException("Unexpected response code for CONNECT: " + fC.m());
            }
            D dB = this.f1787c.a().h().b(this.f1787c, fC);
            if (dB == null) {
                throw new IOException("Failed to authenticate with proxy");
            }
            if ("close".equalsIgnoreCase(fC.r("Connection"))) {
                return dB;
            }
            d6 = dB;
        }
    }

    private D i() {
        D dB = new D.a().h(this.f1787c.a().l()).e("CONNECT", null).c("Host", D4.e.s(this.f1787c.a().l(), true)).c("Proxy-Connection", "Keep-Alive").c("User-Agent", D4.f.a()).b();
        D dB2 = this.f1787c.a().h().b(this.f1787c, new F.a().q(dB).o(B.HTTP_1_1).g(407).l("Preemptive Authenticate").b(D4.e.f1209d).r(-1L).p(-1L).i("Proxy-Authenticate", "OkHttp-Preemptive").c());
        return dB2 != null ? dB2 : dB;
    }

    private void j(b bVar, int i5, InterfaceC0275e interfaceC0275e, s sVar) throws Throwable {
        if (this.f1787c.a().k() != null) {
            sVar.x(interfaceC0275e);
            f(bVar);
            sVar.w(interfaceC0275e, this.f1790f);
            if (this.f1791g == B.HTTP_2) {
                t(i5);
                return;
            }
            return;
        }
        List<B> listF = this.f1787c.a().f();
        B b6 = B.H2_PRIOR_KNOWLEDGE;
        if (!listF.contains(b6)) {
            this.f1789e = this.f1788d;
            this.f1791g = B.HTTP_1_1;
        } else {
            this.f1789e = this.f1788d;
            this.f1791g = b6;
            t(i5);
        }
    }

    private boolean r(List<H> list) {
        int size = list.size();
        for (int i5 = 0; i5 < size; i5++) {
            H h5 = list.get(i5);
            Proxy.Type type = h5.b().type();
            Proxy.Type type2 = Proxy.Type.DIRECT;
            if (type == type2 && this.f1787c.b().type() == type2 && this.f1787c.d().equals(h5.d())) {
                return true;
            }
        }
        return false;
    }

    private void t(int i5) throws SocketException {
        this.f1789e.setSoTimeout(0);
        I4.f fVarA = new f.h(true).d(this.f1789e, this.f1787c.a().l().m(), this.f1793i, this.f1794j).b(this).c(i5).a();
        this.f1792h = fVarA;
        fVarA.d0();
    }

    @Override // I4.f.j
    public void a(I4.f fVar) {
        synchronized (this.f1786b) {
            this.f1799o = fVar.I();
        }
    }

    @Override // I4.f.j
    public void b(I4.i iVar) {
        iVar.d(I4.b.REFUSED_STREAM, null);
    }

    public void c() throws IOException {
        D4.e.h(this.f1788d);
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00f7 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0138  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0140 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void d(int r13, int r14, int r15, int r16, boolean r17, C4.InterfaceC0275e r18, C4.s r19) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 342
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: F4.e.d(int, int, int, int, boolean, C4.e, C4.s):void");
    }

    public u k() {
        return this.f1790f;
    }

    boolean l(C0271a c0271a, @Nullable List<H> list) {
        if (this.f1800p.size() >= this.f1799o || this.f1795k || !D4.a.f1202a.e(this.f1787c.a(), c0271a)) {
            return false;
        }
        if (c0271a.l().m().equals(q().a().l().m())) {
            return true;
        }
        if (this.f1792h == null || list == null || !r(list) || c0271a.e() != K4.d.f3670a || !u(c0271a.l())) {
            return false;
        }
        try {
            c0271a.a().a(c0271a.l().m(), k().d());
            return true;
        } catch (SSLPeerUnverifiedException unused) {
            return false;
        }
    }

    public boolean m(boolean z5) throws SocketException {
        if (this.f1789e.isClosed() || this.f1789e.isInputShutdown() || this.f1789e.isOutputShutdown()) {
            return false;
        }
        I4.f fVar = this.f1792h;
        if (fVar != null) {
            return fVar.G(System.nanoTime());
        }
        if (z5) {
            try {
                int soTimeout = this.f1789e.getSoTimeout();
                try {
                    this.f1789e.setSoTimeout(1);
                    return !this.f1793i.t();
                } finally {
                    this.f1789e.setSoTimeout(soTimeout);
                }
            } catch (SocketTimeoutException unused) {
            } catch (IOException unused2) {
                return false;
            }
        }
        return true;
    }

    public boolean n() {
        return this.f1792h != null;
    }

    G4.c o(A a6, x.a aVar) throws SocketException {
        if (this.f1792h != null) {
            return new I4.g(a6, this, aVar, this.f1792h);
        }
        this.f1789e.setSoTimeout(aVar.c());
        z zVarB = this.f1793i.b();
        long jC = aVar.c();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        zVarB.g(jC, timeUnit);
        this.f1794j.b().g(aVar.d(), timeUnit);
        return new H4.a(a6, this, this.f1793i, this.f1794j);
    }

    public void p() {
        synchronized (this.f1786b) {
            this.f1795k = true;
        }
    }

    public H q() {
        return this.f1787c;
    }

    public Socket s() {
        return this.f1789e;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Connection{");
        sb.append(this.f1787c.a().l().m());
        sb.append(":");
        sb.append(this.f1787c.a().l().y());
        sb.append(", proxy=");
        sb.append(this.f1787c.b());
        sb.append(" hostAddress=");
        sb.append(this.f1787c.d());
        sb.append(" cipherSuite=");
        u uVar = this.f1790f;
        sb.append(uVar != null ? uVar.a() : "none");
        sb.append(" protocol=");
        sb.append(this.f1791g);
        sb.append('}');
        return sb.toString();
    }

    public boolean u(w wVar) {
        if (wVar.y() != this.f1787c.a().l().y()) {
            return false;
        }
        if (wVar.m().equals(this.f1787c.a().l().m())) {
            return true;
        }
        return this.f1790f != null && K4.d.f3670a.c(wVar.m(), (X509Certificate) this.f1790f.d().get(0));
    }

    void v(@Nullable IOException iOException) {
        synchronized (this.f1786b) {
            try {
                if (iOException instanceof n) {
                    I4.b bVar = ((n) iOException).f3152a;
                    if (bVar == I4.b.REFUSED_STREAM) {
                        int i5 = this.f1798n + 1;
                        this.f1798n = i5;
                        if (i5 > 1) {
                            this.f1795k = true;
                            this.f1796l++;
                        }
                    } else if (bVar != I4.b.CANCEL) {
                        this.f1795k = true;
                        this.f1796l++;
                    }
                } else if (!n() || (iOException instanceof I4.a)) {
                    this.f1795k = true;
                    if (this.f1797m == 0) {
                        if (iOException != null) {
                            this.f1786b.c(this.f1787c, iOException);
                        }
                        this.f1796l++;
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
