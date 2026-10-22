package F4;

import C4.D;
import C4.F;
import C4.G;
import C4.InterfaceC0275e;
import C4.s;
import L4.o;
import L4.w;
import L4.y;
import java.io.IOException;
import java.net.ProtocolException;
import javax.annotation.Nullable;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    final k f1760a;

    /* renamed from: b, reason: collision with root package name */
    final InterfaceC0275e f1761b;

    /* renamed from: c, reason: collision with root package name */
    final s f1762c;

    /* renamed from: d, reason: collision with root package name */
    final d f1763d;

    /* renamed from: e, reason: collision with root package name */
    final G4.c f1764e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f1765f;

    private final class a extends L4.i {

        /* renamed from: b, reason: collision with root package name */
        private boolean f1766b;

        /* renamed from: c, reason: collision with root package name */
        private long f1767c;

        /* renamed from: d, reason: collision with root package name */
        private long f1768d;

        /* renamed from: e, reason: collision with root package name */
        private boolean f1769e;

        a(w wVar, long j5) {
            super(wVar);
            this.f1767c = j5;
        }

        @Nullable
        private IOException a(@Nullable IOException iOException) {
            if (this.f1766b) {
                return iOException;
            }
            this.f1766b = true;
            return c.this.a(this.f1768d, false, true, iOException);
        }

        @Override // L4.i, L4.w, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.f1769e) {
                return;
            }
            this.f1769e = true;
            long j5 = this.f1767c;
            if (j5 != -1 && this.f1768d != j5) {
                throw new ProtocolException("unexpected end of stream");
            }
            try {
                super.close();
                a(null);
            } catch (IOException e6) {
                throw a(e6);
            }
        }

        @Override // L4.i, L4.w, java.io.Flushable
        public void flush() throws IOException {
            try {
                super.flush();
            } catch (IOException e6) {
                throw a(e6);
            }
        }

        @Override // L4.i, L4.w
        public void y0(L4.e eVar, long j5) throws IOException {
            if (this.f1769e) {
                throw new IllegalStateException("closed");
            }
            long j6 = this.f1767c;
            if (j6 == -1 || this.f1768d + j5 <= j6) {
                try {
                    super.y0(eVar, j5);
                    this.f1768d += j5;
                    return;
                } catch (IOException e6) {
                    throw a(e6);
                }
            }
            throw new ProtocolException("expected " + this.f1767c + " bytes but received " + (this.f1768d + j5));
        }
    }

    final class b extends L4.j {

        /* renamed from: b, reason: collision with root package name */
        private final long f1771b;

        /* renamed from: c, reason: collision with root package name */
        private long f1772c;

        /* renamed from: d, reason: collision with root package name */
        private boolean f1773d;

        /* renamed from: e, reason: collision with root package name */
        private boolean f1774e;

        b(y yVar, long j5) {
            super(yVar);
            this.f1771b = j5;
            if (j5 == 0) {
                c(null);
            }
        }

        @Nullable
        IOException c(@Nullable IOException iOException) {
            if (this.f1773d) {
                return iOException;
            }
            this.f1773d = true;
            return c.this.a(this.f1772c, true, false, iOException);
        }

        @Override // L4.j, L4.y, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.f1774e) {
                return;
            }
            this.f1774e = true;
            try {
                super.close();
                c(null);
            } catch (IOException e6) {
                throw c(e6);
            }
        }

        @Override // L4.j, L4.y
        public long e(L4.e eVar, long j5) throws IOException {
            if (this.f1774e) {
                throw new IllegalStateException("closed");
            }
            try {
                long jE = a().e(eVar, j5);
                if (jE == -1) {
                    c(null);
                    return -1L;
                }
                long j6 = this.f1772c + jE;
                long j7 = this.f1771b;
                if (j7 != -1 && j6 > j7) {
                    throw new ProtocolException("expected " + this.f1771b + " bytes but received " + j6);
                }
                this.f1772c = j6;
                if (j6 == j7) {
                    c(null);
                }
                return jE;
            } catch (IOException e6) {
                throw c(e6);
            }
        }
    }

    public c(k kVar, InterfaceC0275e interfaceC0275e, s sVar, d dVar, G4.c cVar) {
        this.f1760a = kVar;
        this.f1761b = interfaceC0275e;
        this.f1762c = sVar;
        this.f1763d = dVar;
        this.f1764e = cVar;
    }

    @Nullable
    IOException a(long j5, boolean z5, boolean z6, @Nullable IOException iOException) {
        if (iOException != null) {
            o(iOException);
        }
        if (z6) {
            if (iOException != null) {
                this.f1762c.o(this.f1761b, iOException);
            } else {
                this.f1762c.m(this.f1761b, j5);
            }
        }
        if (z5) {
            if (iOException != null) {
                this.f1762c.t(this.f1761b, iOException);
            } else {
                this.f1762c.r(this.f1761b, j5);
            }
        }
        return this.f1760a.g(this, z6, z5, iOException);
    }

    public void b() {
        this.f1764e.cancel();
    }

    public e c() {
        return this.f1764e.c();
    }

    public w d(D d6, boolean z5) {
        this.f1765f = z5;
        long jA = d6.a().a();
        this.f1762c.n(this.f1761b);
        return new a(this.f1764e.e(d6, jA), jA);
    }

    public void e() {
        this.f1764e.cancel();
        this.f1760a.g(this, true, true, null);
    }

    public void f() throws IOException {
        try {
            this.f1764e.a();
        } catch (IOException e6) {
            this.f1762c.o(this.f1761b, e6);
            o(e6);
            throw e6;
        }
    }

    public void g() throws IOException {
        try {
            this.f1764e.f();
        } catch (IOException e6) {
            this.f1762c.o(this.f1761b, e6);
            o(e6);
            throw e6;
        }
    }

    public boolean h() {
        return this.f1765f;
    }

    public void i() {
        this.f1764e.c().p();
    }

    public void j() {
        this.f1760a.g(this, true, false, null);
    }

    public G k(F f5) throws IOException {
        try {
            this.f1762c.s(this.f1761b);
            String strR = f5.r("Content-Type");
            long jH = this.f1764e.h(f5);
            return new G4.h(strR, jH, o.b(new b(this.f1764e.d(f5), jH)));
        } catch (IOException e6) {
            this.f1762c.t(this.f1761b, e6);
            o(e6);
            throw e6;
        }
    }

    @Nullable
    public F.a l(boolean z5) throws IOException {
        try {
            F.a aVarB = this.f1764e.b(z5);
            if (aVarB == null) {
                return aVarB;
            }
            D4.a.f1202a.g(aVarB, this);
            return aVarB;
        } catch (IOException e6) {
            this.f1762c.t(this.f1761b, e6);
            o(e6);
            throw e6;
        }
    }

    public void m(F f5) {
        this.f1762c.u(this.f1761b, f5);
    }

    public void n() {
        this.f1762c.v(this.f1761b);
    }

    void o(IOException iOException) {
        this.f1763d.h();
        this.f1764e.c().v(iOException);
    }

    public void p(D d6) throws IOException {
        try {
            this.f1762c.q(this.f1761b);
            this.f1764e.g(d6);
            this.f1762c.p(this.f1761b, d6);
        } catch (IOException e6) {
            this.f1762c.o(this.f1761b, e6);
            o(e6);
            throw e6;
        }
    }
}
