package F4;

import C4.A;
import C4.C0271a;
import C4.C0277g;
import C4.D;
import C4.InterfaceC0275e;
import C4.s;
import C4.w;
import C4.x;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.ref.WeakReference;
import java.net.Socket;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;

/* loaded from: classes.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    private final A f1823a;

    /* renamed from: b, reason: collision with root package name */
    private final g f1824b;

    /* renamed from: c, reason: collision with root package name */
    private final InterfaceC0275e f1825c;

    /* renamed from: d, reason: collision with root package name */
    private final s f1826d;

    /* renamed from: e, reason: collision with root package name */
    private final L4.d f1827e;

    /* renamed from: f, reason: collision with root package name */
    @Nullable
    private Object f1828f;

    /* renamed from: g, reason: collision with root package name */
    private D f1829g;

    /* renamed from: h, reason: collision with root package name */
    private d f1830h;

    /* renamed from: i, reason: collision with root package name */
    public e f1831i;

    /* renamed from: j, reason: collision with root package name */
    @Nullable
    private c f1832j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f1833k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f1834l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f1835m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f1836n;

    /* renamed from: o, reason: collision with root package name */
    private boolean f1837o;

    class a extends L4.d {
        a() {
        }

        @Override // L4.d
        protected void y() throws IOException {
            k.this.d();
        }
    }

    static final class b extends WeakReference<k> {

        /* renamed from: a, reason: collision with root package name */
        final Object f1839a;

        b(k kVar, Object obj) {
            super(kVar);
            this.f1839a = obj;
        }
    }

    public k(A a6, InterfaceC0275e interfaceC0275e) {
        a aVar = new a();
        this.f1827e = aVar;
        this.f1823a = a6;
        this.f1824b = D4.a.f1202a.h(a6.i());
        this.f1825c = interfaceC0275e;
        this.f1826d = a6.p().a(interfaceC0275e);
        aVar.g(a6.e(), TimeUnit.MILLISECONDS);
    }

    private C0271a e(w wVar) {
        SSLSocketFactory sSLSocketFactoryG;
        HostnameVerifier hostnameVerifierT;
        C0277g c0277gG;
        if (wVar.n()) {
            sSLSocketFactoryG = this.f1823a.G();
            hostnameVerifierT = this.f1823a.t();
            c0277gG = this.f1823a.g();
        } else {
            sSLSocketFactoryG = null;
            hostnameVerifierT = null;
            c0277gG = null;
        }
        return new C0271a(wVar.m(), wVar.y(), this.f1823a.n(), this.f1823a.F(), sSLSocketFactoryG, hostnameVerifierT, c0277gG, this.f1823a.B(), this.f1823a.A(), this.f1823a.z(), this.f1823a.j(), this.f1823a.C());
    }

    @Nullable
    private IOException j(@Nullable IOException iOException, boolean z5) throws IOException {
        e eVar;
        Socket socketN;
        boolean z6;
        synchronized (this.f1824b) {
            if (z5) {
                try {
                    if (this.f1832j != null) {
                        throw new IllegalStateException("cannot release connection while it is in use");
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            eVar = this.f1831i;
            socketN = (eVar != null && this.f1832j == null && (z5 || this.f1837o)) ? n() : null;
            if (this.f1831i != null) {
                eVar = null;
            }
            z6 = this.f1837o && this.f1832j == null;
        }
        D4.e.h(socketN);
        if (eVar != null) {
            this.f1826d.i(this.f1825c, eVar);
        }
        if (z6) {
            boolean z7 = iOException != null;
            iOException = q(iOException);
            if (z7) {
                this.f1826d.c(this.f1825c, iOException);
                return iOException;
            }
            this.f1826d.b(this.f1825c);
        }
        return iOException;
    }

    @Nullable
    private IOException q(@Nullable IOException iOException) {
        if (this.f1836n || !this.f1827e.r()) {
            return iOException;
        }
        InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    void a(e eVar) {
        if (this.f1831i != null) {
            throw new IllegalStateException();
        }
        this.f1831i = eVar;
        eVar.f1800p.add(new b(this, this.f1828f));
    }

    public void b() {
        this.f1828f = okhttp3.internal.platform.f.get().getStackTraceForCloseable("response.body().close()");
        this.f1826d.d(this.f1825c);
    }

    public boolean c() {
        return this.f1830h.f() && this.f1830h.e();
    }

    public void d() throws IOException {
        c cVar;
        e eVarA;
        synchronized (this.f1824b) {
            try {
                this.f1835m = true;
                cVar = this.f1832j;
                d dVar = this.f1830h;
                eVarA = (dVar == null || dVar.a() == null) ? this.f1831i : this.f1830h.a();
            } catch (Throwable th) {
                throw th;
            }
        }
        if (cVar != null) {
            cVar.b();
        } else if (eVarA != null) {
            eVarA.c();
        }
    }

    public void f() {
        synchronized (this.f1824b) {
            try {
                if (this.f1837o) {
                    throw new IllegalStateException();
                }
                this.f1832j = null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Nullable
    IOException g(c cVar, boolean z5, boolean z6, @Nullable IOException iOException) {
        boolean z7;
        synchronized (this.f1824b) {
            try {
                c cVar2 = this.f1832j;
                if (cVar != cVar2) {
                    return iOException;
                }
                boolean z8 = true;
                if (z5) {
                    z7 = !this.f1833k;
                    this.f1833k = true;
                } else {
                    z7 = false;
                }
                if (z6) {
                    if (!this.f1834l) {
                        z7 = true;
                    }
                    this.f1834l = true;
                }
                if (this.f1833k && this.f1834l && z7) {
                    cVar2.c().f1797m++;
                    this.f1832j = null;
                } else {
                    z8 = false;
                }
                return z8 ? j(iOException, false) : iOException;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public boolean h() {
        boolean z5;
        synchronized (this.f1824b) {
            z5 = this.f1832j != null;
        }
        return z5;
    }

    public boolean i() {
        boolean z5;
        synchronized (this.f1824b) {
            z5 = this.f1835m;
        }
        return z5;
    }

    c k(x.a aVar, boolean z5) {
        synchronized (this.f1824b) {
            if (this.f1837o) {
                throw new IllegalStateException("released");
            }
            if (this.f1832j != null) {
                throw new IllegalStateException("cannot make a new request because the previous response is still open: please call response.close()");
            }
        }
        c cVar = new c(this, this.f1825c, this.f1826d, this.f1830h, this.f1830h.b(this.f1823a, aVar, z5));
        synchronized (this.f1824b) {
            this.f1832j = cVar;
            this.f1833k = false;
            this.f1834l = false;
        }
        return cVar;
    }

    @Nullable
    public IOException l(@Nullable IOException iOException) {
        synchronized (this.f1824b) {
            this.f1837o = true;
        }
        return j(iOException, false);
    }

    public void m(D d6) throws IOException {
        D d7 = this.f1829g;
        if (d7 != null) {
            if (D4.e.D(d7.i(), d6.i()) && this.f1830h.e()) {
                return;
            }
            if (this.f1832j != null) {
                throw new IllegalStateException();
            }
            if (this.f1830h != null) {
                j(null, true);
                this.f1830h = null;
            }
        }
        this.f1829g = d6;
        this.f1830h = new d(this, this.f1824b, e(d6.i()), this.f1825c, this.f1826d);
    }

    @Nullable
    Socket n() {
        int size = this.f1831i.f1800p.size();
        int i5 = 0;
        while (true) {
            if (i5 >= size) {
                i5 = -1;
                break;
            }
            if (this.f1831i.f1800p.get(i5).get() == this) {
                break;
            }
            i5++;
        }
        if (i5 == -1) {
            throw new IllegalStateException();
        }
        e eVar = this.f1831i;
        eVar.f1800p.remove(i5);
        this.f1831i = null;
        if (eVar.f1800p.isEmpty()) {
            eVar.f1801q = System.nanoTime();
            if (this.f1824b.d(eVar)) {
                return eVar.s();
            }
        }
        return null;
    }

    public void o() {
        if (this.f1836n) {
            throw new IllegalStateException();
        }
        this.f1836n = true;
        this.f1827e.r();
    }

    public void p() {
        this.f1827e.q();
    }
}
