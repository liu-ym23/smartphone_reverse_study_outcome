package I3;

import java.util.concurrent.atomic.AtomicReference;
import x3.AbstractC1286b;
import x3.InterfaceC1287c;
import x3.InterfaceC1288d;
import x3.p;

/* loaded from: classes.dex */
public final class d extends AbstractC1286b {

    /* renamed from: a, reason: collision with root package name */
    final InterfaceC1288d f2961a;

    /* renamed from: b, reason: collision with root package name */
    final p f2962b;

    static final class a extends AtomicReference<A3.c> implements InterfaceC1287c, A3.c, Runnable {

        /* renamed from: a, reason: collision with root package name */
        final InterfaceC1287c f2963a;

        /* renamed from: b, reason: collision with root package name */
        final p f2964b;

        /* renamed from: c, reason: collision with root package name */
        Throwable f2965c;

        a(InterfaceC1287c interfaceC1287c, p pVar) {
            this.f2963a = interfaceC1287c;
            this.f2964b = pVar;
        }

        @Override // x3.InterfaceC1287c, x3.k
        public void a() {
            E3.b.e(this, this.f2964b.b(this));
        }

        @Override // x3.InterfaceC1287c, x3.k
        public void b(A3.c cVar) {
            if (E3.b.j(this, cVar)) {
                this.f2963a.b(this);
            }
        }

        @Override // A3.c
        public void dispose() {
            E3.b.b(this);
        }

        @Override // A3.c
        public boolean g() {
            return E3.b.d(get());
        }

        @Override // x3.InterfaceC1287c, x3.k
        public void onError(Throwable th) {
            this.f2965c = th;
            E3.b.e(this, this.f2964b.b(this));
        }

        @Override // java.lang.Runnable
        public void run() {
            Throwable th = this.f2965c;
            if (th == null) {
                this.f2963a.a();
            } else {
                this.f2965c = null;
                this.f2963a.onError(th);
            }
        }
    }

    public d(InterfaceC1288d interfaceC1288d, p pVar) {
        this.f2961a = interfaceC1288d;
        this.f2962b = pVar;
    }

    @Override // x3.AbstractC1286b
    protected void i(InterfaceC1287c interfaceC1287c) {
        this.f2961a.a(new a(interfaceC1287c, this.f2962b));
    }
}
