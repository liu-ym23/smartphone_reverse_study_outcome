package I3;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import x3.AbstractC1286b;
import x3.InterfaceC1287c;
import x3.p;

/* loaded from: classes.dex */
public final class f extends AbstractC1286b {

    /* renamed from: a, reason: collision with root package name */
    final long f2971a;

    /* renamed from: b, reason: collision with root package name */
    final TimeUnit f2972b;

    /* renamed from: c, reason: collision with root package name */
    final p f2973c;

    static final class a extends AtomicReference<A3.c> implements A3.c, Runnable {

        /* renamed from: a, reason: collision with root package name */
        final InterfaceC1287c f2974a;

        a(InterfaceC1287c interfaceC1287c) {
            this.f2974a = interfaceC1287c;
        }

        void a(A3.c cVar) {
            E3.b.e(this, cVar);
        }

        @Override // A3.c
        public void dispose() {
            E3.b.b(this);
        }

        @Override // A3.c
        public boolean g() {
            return E3.b.d(get());
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f2974a.a();
        }
    }

    public f(long j5, TimeUnit timeUnit, p pVar) {
        this.f2971a = j5;
        this.f2972b = timeUnit;
        this.f2973c = pVar;
    }

    @Override // x3.AbstractC1286b
    protected void i(InterfaceC1287c interfaceC1287c) {
        a aVar = new a(interfaceC1287c);
        interfaceC1287c.b(aVar);
        aVar.a(this.f2973c.c(aVar, this.f2971a, this.f2972b));
    }
}
