package H4;

import C4.A;
import C4.D;
import C4.F;
import C4.v;
import G4.i;
import L4.k;
import L4.w;
import L4.y;
import L4.z;
import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public final class a implements G4.c {

    /* renamed from: a, reason: collision with root package name */
    private final A f2862a;

    /* renamed from: b, reason: collision with root package name */
    private final F4.e f2863b;

    /* renamed from: c, reason: collision with root package name */
    private final L4.g f2864c;

    /* renamed from: d, reason: collision with root package name */
    private final L4.f f2865d;

    /* renamed from: e, reason: collision with root package name */
    private int f2866e = 0;

    /* renamed from: f, reason: collision with root package name */
    private long f2867f = 262144;

    /* renamed from: g, reason: collision with root package name */
    private v f2868g;

    private abstract class b implements y {

        /* renamed from: a, reason: collision with root package name */
        protected final k f2869a;

        /* renamed from: b, reason: collision with root package name */
        protected boolean f2870b;

        private b() {
            this.f2869a = new k(a.this.f2864c.b());
        }

        final void a() {
            if (a.this.f2866e == 6) {
                return;
            }
            if (a.this.f2866e == 5) {
                a.this.s(this.f2869a);
                a.this.f2866e = 6;
            } else {
                throw new IllegalStateException("state: " + a.this.f2866e);
            }
        }

        @Override // L4.y
        public z b() {
            return this.f2869a;
        }

        @Override // L4.y
        public long e(L4.e eVar, long j5) throws IOException {
            try {
                return a.this.f2864c.e(eVar, j5);
            } catch (IOException e6) {
                a.this.f2863b.p();
                this.a();
                throw e6;
            }
        }
    }

    private final class c implements w {

        /* renamed from: a, reason: collision with root package name */
        private final k f2872a;

        /* renamed from: b, reason: collision with root package name */
        private boolean f2873b;

        c() {
            this.f2872a = new k(a.this.f2865d.b());
        }

        @Override // L4.w
        public z b() {
            return this.f2872a;
        }

        @Override // L4.w, java.io.Closeable, java.lang.AutoCloseable
        public synchronized void close() {
            if (this.f2873b) {
                return;
            }
            this.f2873b = true;
            a.this.f2865d.H("0\r\n\r\n");
            a.this.s(this.f2872a);
            a.this.f2866e = 3;
        }

        @Override // L4.w, java.io.Flushable
        public synchronized void flush() {
            if (this.f2873b) {
                return;
            }
            a.this.f2865d.flush();
        }

        @Override // L4.w
        public void y0(L4.e eVar, long j5) {
            if (this.f2873b) {
                throw new IllegalStateException("closed");
            }
            if (j5 == 0) {
                return;
            }
            a.this.f2865d.Q(j5);
            a.this.f2865d.H("\r\n");
            a.this.f2865d.y0(eVar, j5);
            a.this.f2865d.H("\r\n");
        }
    }

    private class d extends b {

        /* renamed from: d, reason: collision with root package name */
        private final C4.w f2875d;

        /* renamed from: e, reason: collision with root package name */
        private long f2876e;

        /* renamed from: f, reason: collision with root package name */
        private boolean f2877f;

        d(C4.w wVar) {
            super();
            this.f2876e = -1L;
            this.f2877f = true;
            this.f2875d = wVar;
        }

        private void c() throws ProtocolException {
            if (this.f2876e != -1) {
                a.this.f2864c.b0();
            }
            try {
                this.f2876e = a.this.f2864c.v0();
                String strTrim = a.this.f2864c.b0().trim();
                if (this.f2876e < 0 || !(strTrim.isEmpty() || strTrim.startsWith(";"))) {
                    throw new ProtocolException("expected chunk size and optional extensions but was \"" + this.f2876e + strTrim + "\"");
                }
                if (this.f2876e == 0) {
                    this.f2877f = false;
                    a aVar = a.this;
                    aVar.f2868g = aVar.z();
                    G4.e.e(a.this.f2862a.k(), this.f2875d, a.this.f2868g);
                    a();
                }
            } catch (NumberFormatException e6) {
                throw new ProtocolException(e6.getMessage());
            }
        }

        @Override // L4.y, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.f2870b) {
                return;
            }
            if (this.f2877f && !D4.e.p(this, 100, TimeUnit.MILLISECONDS)) {
                a.this.f2863b.p();
                a();
            }
            this.f2870b = true;
        }

        @Override // H4.a.b, L4.y
        public long e(L4.e eVar, long j5) throws IOException {
            if (j5 < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j5);
            }
            if (this.f2870b) {
                throw new IllegalStateException("closed");
            }
            if (!this.f2877f) {
                return -1L;
            }
            long j6 = this.f2876e;
            if (j6 == 0 || j6 == -1) {
                c();
                if (!this.f2877f) {
                    return -1L;
                }
            }
            long jE = super.e(eVar, Math.min(j5, this.f2876e));
            if (jE != -1) {
                this.f2876e -= jE;
                return jE;
            }
            a.this.f2863b.p();
            ProtocolException protocolException = new ProtocolException("unexpected end of stream");
            a();
            throw protocolException;
        }
    }

    private class e extends b {

        /* renamed from: d, reason: collision with root package name */
        private long f2879d;

        e(long j5) {
            super();
            this.f2879d = j5;
            if (j5 == 0) {
                a();
            }
        }

        @Override // L4.y, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.f2870b) {
                return;
            }
            if (this.f2879d != 0 && !D4.e.p(this, 100, TimeUnit.MILLISECONDS)) {
                a.this.f2863b.p();
                a();
            }
            this.f2870b = true;
        }

        @Override // H4.a.b, L4.y
        public long e(L4.e eVar, long j5) throws IOException {
            if (j5 < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j5);
            }
            if (this.f2870b) {
                throw new IllegalStateException("closed");
            }
            long j6 = this.f2879d;
            if (j6 == 0) {
                return -1L;
            }
            long jE = super.e(eVar, Math.min(j6, j5));
            if (jE == -1) {
                a.this.f2863b.p();
                ProtocolException protocolException = new ProtocolException("unexpected end of stream");
                a();
                throw protocolException;
            }
            long j7 = this.f2879d - jE;
            this.f2879d = j7;
            if (j7 == 0) {
                a();
            }
            return jE;
        }
    }

    private final class f implements w {

        /* renamed from: a, reason: collision with root package name */
        private final k f2881a;

        /* renamed from: b, reason: collision with root package name */
        private boolean f2882b;

        private f() {
            this.f2881a = new k(a.this.f2865d.b());
        }

        @Override // L4.w
        public z b() {
            return this.f2881a;
        }

        @Override // L4.w, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.f2882b) {
                return;
            }
            this.f2882b = true;
            a.this.s(this.f2881a);
            a.this.f2866e = 3;
        }

        @Override // L4.w, java.io.Flushable
        public void flush() {
            if (this.f2882b) {
                return;
            }
            a.this.f2865d.flush();
        }

        @Override // L4.w
        public void y0(L4.e eVar, long j5) {
            if (this.f2882b) {
                throw new IllegalStateException("closed");
            }
            D4.e.f(eVar.size(), 0L, j5);
            a.this.f2865d.y0(eVar, j5);
        }
    }

    private class g extends b {

        /* renamed from: d, reason: collision with root package name */
        private boolean f2884d;

        private g() {
            super();
        }

        @Override // L4.y, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.f2870b) {
                return;
            }
            if (!this.f2884d) {
                a();
            }
            this.f2870b = true;
        }

        @Override // H4.a.b, L4.y
        public long e(L4.e eVar, long j5) throws IOException {
            if (j5 < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j5);
            }
            if (this.f2870b) {
                throw new IllegalStateException("closed");
            }
            if (this.f2884d) {
                return -1L;
            }
            long jE = super.e(eVar, j5);
            if (jE != -1) {
                return jE;
            }
            this.f2884d = true;
            a();
            return -1L;
        }
    }

    public a(A a6, F4.e eVar, L4.g gVar, L4.f fVar) {
        this.f2862a = a6;
        this.f2863b = eVar;
        this.f2864c = gVar;
        this.f2865d = fVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(k kVar) {
        z zVarI = kVar.i();
        kVar.j(z.f3988d);
        zVarI.a();
        zVarI.b();
    }

    private w t() {
        if (this.f2866e == 1) {
            this.f2866e = 2;
            return new c();
        }
        throw new IllegalStateException("state: " + this.f2866e);
    }

    private y u(C4.w wVar) {
        if (this.f2866e == 4) {
            this.f2866e = 5;
            return new d(wVar);
        }
        throw new IllegalStateException("state: " + this.f2866e);
    }

    private y v(long j5) {
        if (this.f2866e == 4) {
            this.f2866e = 5;
            return new e(j5);
        }
        throw new IllegalStateException("state: " + this.f2866e);
    }

    private w w() {
        if (this.f2866e == 1) {
            this.f2866e = 2;
            return new f();
        }
        throw new IllegalStateException("state: " + this.f2866e);
    }

    private y x() {
        if (this.f2866e == 4) {
            this.f2866e = 5;
            this.f2863b.p();
            return new g();
        }
        throw new IllegalStateException("state: " + this.f2866e);
    }

    private String y() {
        String strY = this.f2864c.y(this.f2867f);
        this.f2867f -= strY.length();
        return strY;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public v z() {
        v.a aVar = new v.a();
        while (true) {
            String strY = y();
            if (strY.length() == 0) {
                return aVar.e();
            }
            D4.a.f1202a.a(aVar, strY);
        }
    }

    public void A(F f5) {
        long jB = G4.e.b(f5);
        if (jB == -1) {
            return;
        }
        y yVarV = v(jB);
        D4.e.E(yVarV, Integer.MAX_VALUE, TimeUnit.MILLISECONDS);
        yVarV.close();
    }

    public void B(v vVar, String str) {
        if (this.f2866e != 0) {
            throw new IllegalStateException("state: " + this.f2866e);
        }
        this.f2865d.H(str).H("\r\n");
        int iH = vVar.h();
        for (int i5 = 0; i5 < iH; i5++) {
            this.f2865d.H(vVar.e(i5)).H(": ").H(vVar.i(i5)).H("\r\n");
        }
        this.f2865d.H("\r\n");
        this.f2866e = 1;
    }

    @Override // G4.c
    public void a() {
        this.f2865d.flush();
    }

    @Override // G4.c
    public F.a b(boolean z5) throws NumberFormatException, IOException {
        int i5 = this.f2866e;
        if (i5 != 1 && i5 != 3) {
            throw new IllegalStateException("state: " + this.f2866e);
        }
        try {
            G4.k kVarA = G4.k.a(y());
            F.a aVarJ = new F.a().o(kVarA.f1936a).g(kVarA.f1937b).l(kVarA.f1938c).j(z());
            if (z5 && kVarA.f1937b == 100) {
                return null;
            }
            if (kVarA.f1937b == 100) {
                this.f2866e = 3;
                return aVarJ;
            }
            this.f2866e = 4;
            return aVarJ;
        } catch (EOFException e6) {
            F4.e eVar = this.f2863b;
            throw new IOException("unexpected end of stream on " + (eVar != null ? eVar.q().a().l().B() : "unknown"), e6);
        }
    }

    @Override // G4.c
    public F4.e c() {
        return this.f2863b;
    }

    @Override // G4.c
    public void cancel() throws IOException {
        F4.e eVar = this.f2863b;
        if (eVar != null) {
            eVar.c();
        }
    }

    @Override // G4.c
    public y d(F f5) {
        if (!G4.e.c(f5)) {
            return v(0L);
        }
        if ("chunked".equalsIgnoreCase(f5.r("Transfer-Encoding"))) {
            return u(f5.I().i());
        }
        long jB = G4.e.b(f5);
        return jB != -1 ? v(jB) : x();
    }

    @Override // G4.c
    public w e(D d6, long j5) throws ProtocolException {
        if (d6.a() != null && d6.a().f()) {
            throw new ProtocolException("Duplex connections are not supported for HTTP/1");
        }
        if ("chunked".equalsIgnoreCase(d6.c("Transfer-Encoding"))) {
            return t();
        }
        if (j5 != -1) {
            return w();
        }
        throw new IllegalStateException("Cannot stream a request body without chunked encoding or a known content length!");
    }

    @Override // G4.c
    public void f() {
        this.f2865d.flush();
    }

    @Override // G4.c
    public void g(D d6) {
        B(d6.d(), i.a(d6, this.f2863b.q().b().type()));
    }

    @Override // G4.c
    public long h(F f5) {
        if (!G4.e.c(f5)) {
            return 0L;
        }
        if ("chunked".equalsIgnoreCase(f5.r("Transfer-Encoding"))) {
            return -1L;
        }
        return G4.e.b(f5);
    }
}
