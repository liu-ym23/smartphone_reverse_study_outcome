package C4;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicInteger;
import org.libpag.BuildConfig;

/* loaded from: classes.dex */
final class C implements InterfaceC0275e {

    /* renamed from: a, reason: collision with root package name */
    final A f671a;

    /* renamed from: b, reason: collision with root package name */
    private F4.k f672b;

    /* renamed from: c, reason: collision with root package name */
    final D f673c;

    /* renamed from: d, reason: collision with root package name */
    final boolean f674d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f675e;

    final class a extends D4.b {

        /* renamed from: b, reason: collision with root package name */
        private final InterfaceC0276f f676b;

        /* renamed from: c, reason: collision with root package name */
        private volatile AtomicInteger f677c;

        a(InterfaceC0276f interfaceC0276f) {
            super("OkHttp %s", C.this.h());
            this.f677c = new AtomicInteger(0);
            this.f676b = interfaceC0276f;
        }

        @Override // D4.b
        protected void k() {
            boolean z5;
            Throwable th;
            IOException e6;
            C.this.f672b.p();
            try {
                try {
                    z5 = true;
                    try {
                        this.f676b.f(C.this, C.this.e());
                    } catch (IOException e7) {
                        e6 = e7;
                        if (z5) {
                            okhttp3.internal.platform.f.get().log(4, "Callback failure for " + C.this.i(), e6);
                        } else {
                            this.f676b.c(C.this, e6);
                        }
                        C.this.f671a.l().e(this);
                    } catch (Throwable th2) {
                        th = th2;
                        C.this.cancel();
                        if (!z5) {
                            IOException iOException = new IOException("canceled due to " + th);
                            iOException.addSuppressed(th);
                            this.f676b.c(C.this, iOException);
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    C.this.f671a.l().e(this);
                    throw th3;
                }
            } catch (IOException e8) {
                z5 = false;
                e6 = e8;
            } catch (Throwable th4) {
                z5 = false;
                th = th4;
            }
            C.this.f671a.l().e(this);
        }

        AtomicInteger l() {
            return this.f677c;
        }

        void m(ExecutorService executorService) {
            try {
                try {
                    executorService.execute(this);
                } catch (RejectedExecutionException e6) {
                    InterruptedIOException interruptedIOException = new InterruptedIOException("executor rejected");
                    interruptedIOException.initCause(e6);
                    C.this.f672b.l(interruptedIOException);
                    this.f676b.c(C.this, interruptedIOException);
                    C.this.f671a.l().e(this);
                }
            } catch (Throwable th) {
                C.this.f671a.l().e(this);
                throw th;
            }
        }

        C n() {
            return C.this;
        }

        String o() {
            return C.this.f673c.i().m();
        }

        void p(a aVar) {
            this.f677c = aVar.f677c;
        }
    }

    private C(A a6, D d6, boolean z5) {
        this.f671a = a6;
        this.f673c = d6;
        this.f674d = z5;
    }

    static C g(A a6, D d6, boolean z5) {
        C c6 = new C(a6, d6, z5);
        c6.f672b = new F4.k(a6, c6);
        return c6;
    }

    @Override // C4.InterfaceC0275e
    public D a() {
        return this.f673c;
    }

    @Override // C4.InterfaceC0275e
    public boolean c() {
        return this.f672b.i();
    }

    @Override // C4.InterfaceC0275e
    public void cancel() throws IOException {
        this.f672b.d();
    }

    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C clone() {
        return g(this.f671a, this.f673c, this.f674d);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x00a3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    C4.F e() throws java.lang.Throwable {
        /*
            r11 = this;
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            C4.A r0 = r11.f671a
            java.util.List r0 = r0.u()
            r1.addAll(r0)
            G4.j r0 = new G4.j
            C4.A r2 = r11.f671a
            r0.<init>(r2)
            r1.add(r0)
            G4.a r0 = new G4.a
            C4.A r2 = r11.f671a
            C4.n r2 = r2.k()
            r0.<init>(r2)
            r1.add(r0)
            E4.a r0 = new E4.a
            C4.A r2 = r11.f671a
            r2.v()
            r10 = 0
            r0.<init>(r10)
            r1.add(r0)
            F4.a r0 = new F4.a
            C4.A r2 = r11.f671a
            r0.<init>(r2)
            r1.add(r0)
            boolean r0 = r11.f674d
            if (r0 != 0) goto L4b
            C4.A r0 = r11.f671a
            java.util.List r0 = r0.w()
            r1.addAll(r0)
        L4b:
            G4.b r0 = new G4.b
            boolean r2 = r11.f674d
            r0.<init>(r2)
            r1.add(r0)
            G4.g r0 = new G4.g
            F4.k r2 = r11.f672b
            C4.D r5 = r11.f673c
            C4.A r3 = r11.f671a
            int r7 = r3.h()
            C4.A r3 = r11.f671a
            int r8 = r3.D()
            C4.A r3 = r11.f671a
            int r9 = r3.H()
            r3 = 0
            r4 = 0
            r6 = r11
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9)
            r11 = 0
            C4.D r1 = r6.f673c     // Catch: java.lang.Throwable -> L93 java.io.IOException -> L95
            C4.F r0 = r0.b(r1)     // Catch: java.lang.Throwable -> L93 java.io.IOException -> L95
            F4.k r1 = r6.f672b     // Catch: java.lang.Throwable -> L93 java.io.IOException -> L95
            boolean r1 = r1.i()     // Catch: java.lang.Throwable -> L93 java.io.IOException -> L95
            if (r1 != 0) goto L88
            F4.k r11 = r6.f672b
            r11.l(r10)
            return r0
        L88:
            D4.e.g(r0)     // Catch: java.lang.Throwable -> L93 java.io.IOException -> L95
            java.io.IOException r0 = new java.io.IOException     // Catch: java.lang.Throwable -> L93 java.io.IOException -> L95
            java.lang.String r1 = "Canceled"
            r0.<init>(r1)     // Catch: java.lang.Throwable -> L93 java.io.IOException -> L95
            throw r0     // Catch: java.lang.Throwable -> L93 java.io.IOException -> L95
        L93:
            r0 = move-exception
            goto La1
        L95:
            r0 = move-exception
            r11 = r0
            r1 = 1
            F4.k r0 = r6.f672b     // Catch: java.lang.Throwable -> L9f
            java.io.IOException r11 = r0.l(r11)     // Catch: java.lang.Throwable -> L9f
            throw r11     // Catch: java.lang.Throwable -> L9f
        L9f:
            r0 = move-exception
            r11 = r1
        La1:
            if (r11 != 0) goto La8
            F4.k r11 = r6.f672b
            r11.l(r10)
        La8:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: C4.C.e():C4.F");
    }

    @Override // C4.InterfaceC0275e
    public F execute() {
        synchronized (this) {
            if (this.f675e) {
                throw new IllegalStateException("Already Executed");
            }
            this.f675e = true;
        }
        this.f672b.p();
        this.f672b.b();
        try {
            this.f671a.l().b(this);
            return e();
        } finally {
            this.f671a.l().f(this);
        }
    }

    String h() {
        return this.f673c.i().B();
    }

    String i() {
        StringBuilder sb = new StringBuilder();
        sb.append(c() ? "canceled " : BuildConfig.FLAVOR);
        sb.append(this.f674d ? "web socket" : "call");
        sb.append(" to ");
        sb.append(h());
        return sb.toString();
    }

    @Override // C4.InterfaceC0275e
    public void m(InterfaceC0276f interfaceC0276f) {
        synchronized (this) {
            if (this.f675e) {
                throw new IllegalStateException("Already Executed");
            }
            this.f675e = true;
        }
        this.f672b.b();
        this.f671a.l().a(new a(interfaceC0276f));
    }
}
