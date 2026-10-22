package R4;

import C4.D;
import C4.F;
import C4.G;
import C4.InterfaceC0275e;
import C4.InterfaceC0276f;
import java.io.IOException;
import java.util.Objects;
import javax.annotation.Nullable;

/* loaded from: classes.dex */
final class n<T> implements R4.b<T> {

    /* renamed from: a, reason: collision with root package name */
    private final s f5045a;

    /* renamed from: b, reason: collision with root package name */
    private final Object[] f5046b;

    /* renamed from: c, reason: collision with root package name */
    private final InterfaceC0275e.a f5047c;

    /* renamed from: d, reason: collision with root package name */
    private final f<G, T> f5048d;

    /* renamed from: e, reason: collision with root package name */
    private volatile boolean f5049e;

    /* renamed from: f, reason: collision with root package name */
    @Nullable
    private InterfaceC0275e f5050f;

    /* renamed from: g, reason: collision with root package name */
    @Nullable
    private Throwable f5051g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f5052h;

    class a implements InterfaceC0276f {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ d f5053a;

        a(d dVar) {
            this.f5053a = dVar;
        }

        private void a(Throwable th) {
            try {
                this.f5053a.b(n.this, th);
            } catch (Throwable th2) {
                y.s(th2);
                th2.printStackTrace();
            }
        }

        @Override // C4.InterfaceC0276f
        public void c(InterfaceC0275e interfaceC0275e, IOException iOException) {
            a(iOException);
        }

        @Override // C4.InterfaceC0276f
        public void f(InterfaceC0275e interfaceC0275e, F f5) {
            try {
                try {
                    this.f5053a.a(n.this, n.this.g(f5));
                } catch (Throwable th) {
                    y.s(th);
                    th.printStackTrace();
                }
            } catch (Throwable th2) {
                y.s(th2);
                a(th2);
            }
        }
    }

    static final class b extends G {

        /* renamed from: b, reason: collision with root package name */
        private final G f5055b;

        /* renamed from: c, reason: collision with root package name */
        private final L4.g f5056c;

        /* renamed from: d, reason: collision with root package name */
        @Nullable
        IOException f5057d;

        class a extends L4.j {
            a(L4.y yVar) {
                super(yVar);
            }

            @Override // L4.j, L4.y
            public long e(L4.e eVar, long j5) throws IOException {
                try {
                    return super.e(eVar, j5);
                } catch (IOException e6) {
                    b.this.f5057d = e6;
                    throw e6;
                }
            }
        }

        b(G g5) {
            this.f5055b = g5;
            this.f5056c = L4.o.b(new a(g5.w()));
        }

        void A() throws IOException {
            IOException iOException = this.f5057d;
            if (iOException != null) {
                throw iOException;
            }
        }

        @Override // C4.G, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.f5055b.close();
        }

        @Override // C4.G
        public long o() {
            return this.f5055b.o();
        }

        @Override // C4.G
        public C4.y r() {
            return this.f5055b.r();
        }

        @Override // C4.G
        public L4.g w() {
            return this.f5056c;
        }
    }

    static final class c extends G {

        /* renamed from: b, reason: collision with root package name */
        @Nullable
        private final C4.y f5059b;

        /* renamed from: c, reason: collision with root package name */
        private final long f5060c;

        c(@Nullable C4.y yVar, long j5) {
            this.f5059b = yVar;
            this.f5060c = j5;
        }

        @Override // C4.G
        public long o() {
            return this.f5060c;
        }

        @Override // C4.G
        public C4.y r() {
            return this.f5059b;
        }

        @Override // C4.G
        public L4.g w() {
            throw new IllegalStateException("Cannot read raw response body of a converted body.");
        }
    }

    n(s sVar, Object[] objArr, InterfaceC0275e.a aVar, f<G, T> fVar) {
        this.f5045a = sVar;
        this.f5046b = objArr;
        this.f5047c = aVar;
        this.f5048d = fVar;
    }

    private InterfaceC0275e d() {
        InterfaceC0275e interfaceC0275eB = this.f5047c.b(this.f5045a.a(this.f5046b));
        if (interfaceC0275eB != null) {
            return interfaceC0275eB;
        }
        throw new NullPointerException("Call.Factory returned null.");
    }

    private InterfaceC0275e e() throws IOException {
        InterfaceC0275e interfaceC0275e = this.f5050f;
        if (interfaceC0275e != null) {
            return interfaceC0275e;
        }
        Throwable th = this.f5051g;
        if (th != null) {
            if (th instanceof IOException) {
                throw ((IOException) th);
            }
            if (th instanceof RuntimeException) {
                throw ((RuntimeException) th);
            }
            throw ((Error) th);
        }
        try {
            InterfaceC0275e interfaceC0275eD = d();
            this.f5050f = interfaceC0275eD;
            return interfaceC0275eD;
        } catch (IOException | Error | RuntimeException e6) {
            y.s(e6);
            this.f5051g = e6;
            throw e6;
        }
    }

    @Override // R4.b
    public synchronized D a() {
        try {
        } catch (IOException e6) {
            throw new RuntimeException("Unable to create request.", e6);
        }
        return e().a();
    }

    @Override // R4.b
    /* renamed from: b, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public n<T> m1clone() {
        return new n<>(this.f5045a, this.f5046b, this.f5047c, this.f5048d);
    }

    @Override // R4.b
    public boolean c() {
        boolean z5 = true;
        if (this.f5049e) {
            return true;
        }
        synchronized (this) {
            try {
                InterfaceC0275e interfaceC0275e = this.f5050f;
                if (interfaceC0275e == null || !interfaceC0275e.c()) {
                    z5 = false;
                }
            } finally {
            }
        }
        return z5;
    }

    @Override // R4.b
    public void cancel() {
        InterfaceC0275e interfaceC0275e;
        this.f5049e = true;
        synchronized (this) {
            interfaceC0275e = this.f5050f;
        }
        if (interfaceC0275e != null) {
            interfaceC0275e.cancel();
        }
    }

    @Override // R4.b
    public t<T> execute() {
        InterfaceC0275e interfaceC0275eE;
        synchronized (this) {
            if (this.f5052h) {
                throw new IllegalStateException("Already executed.");
            }
            this.f5052h = true;
            interfaceC0275eE = e();
        }
        if (this.f5049e) {
            interfaceC0275eE.cancel();
        }
        return g(interfaceC0275eE.execute());
    }

    t<T> g(F f5) throws IOException {
        G gA = f5.a();
        F fC = f5.C().b(new c(gA.r(), gA.o())).c();
        int iM = fC.m();
        if (iM < 200 || iM >= 300) {
            try {
                return t.c(y.a(gA), fC);
            } finally {
                gA.close();
            }
        }
        if (iM == 204 || iM == 205) {
            gA.close();
            return t.g(null, fC);
        }
        b bVar = new b(gA);
        try {
            return t.g(this.f5048d.a(bVar), fC);
        } catch (RuntimeException e6) {
            bVar.A();
            throw e6;
        }
    }

    @Override // R4.b
    public void o(d<T> dVar) {
        InterfaceC0275e interfaceC0275e;
        Throwable th;
        Objects.requireNonNull(dVar, "callback == null");
        synchronized (this) {
            try {
                if (this.f5052h) {
                    throw new IllegalStateException("Already executed.");
                }
                this.f5052h = true;
                interfaceC0275e = this.f5050f;
                th = this.f5051g;
                if (interfaceC0275e == null && th == null) {
                    try {
                        InterfaceC0275e interfaceC0275eD = d();
                        this.f5050f = interfaceC0275eD;
                        interfaceC0275e = interfaceC0275eD;
                    } catch (Throwable th2) {
                        th = th2;
                        y.s(th);
                        this.f5051g = th;
                    }
                }
            } catch (Throwable th3) {
                throw th3;
            }
        }
        if (th != null) {
            dVar.b(this, th);
            return;
        }
        if (this.f5049e) {
            interfaceC0275e.cancel();
        }
        interfaceC0275e.m(new a(dVar));
    }
}
