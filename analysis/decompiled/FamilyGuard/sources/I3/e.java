package I3;

import java.util.concurrent.atomic.AtomicReference;
import x3.AbstractC1286b;
import x3.InterfaceC1287c;
import x3.InterfaceC1288d;
import x3.p;

/* loaded from: classes.dex */
public final class e extends AbstractC1286b {

    /* renamed from: a, reason: collision with root package name */
    final InterfaceC1288d f2966a;

    /* renamed from: b, reason: collision with root package name */
    final p f2967b;

    static final class a extends AtomicReference<A3.c> implements InterfaceC1287c, A3.c, Runnable {

        /* renamed from: a, reason: collision with root package name */
        final InterfaceC1287c f2968a;

        /* renamed from: b, reason: collision with root package name */
        final E3.f f2969b = new E3.f();

        /* renamed from: c, reason: collision with root package name */
        final InterfaceC1288d f2970c;

        a(InterfaceC1287c interfaceC1287c, InterfaceC1288d interfaceC1288d) {
            this.f2968a = interfaceC1287c;
            this.f2970c = interfaceC1288d;
        }

        @Override // x3.InterfaceC1287c, x3.k
        public void a() {
            this.f2968a.a();
        }

        @Override // x3.InterfaceC1287c, x3.k
        public void b(A3.c cVar) {
            E3.b.j(this, cVar);
        }

        @Override // A3.c
        public void dispose() {
            E3.b.b(this);
            this.f2969b.dispose();
        }

        @Override // A3.c
        public boolean g() {
            return E3.b.d(get());
        }

        @Override // x3.InterfaceC1287c, x3.k
        public void onError(Throwable th) {
            this.f2968a.onError(th);
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f2970c.a(this);
        }
    }

    public e(InterfaceC1288d interfaceC1288d, p pVar) {
        this.f2966a = interfaceC1288d;
        this.f2967b = pVar;
    }

    @Override // x3.AbstractC1286b
    protected void i(InterfaceC1287c interfaceC1287c) {
        a aVar = new a(interfaceC1287c, this.f2966a);
        interfaceC1287c.b(aVar);
        aVar.f2969b.a(this.f2967b.b(aVar));
    }
}
