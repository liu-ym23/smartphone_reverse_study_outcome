package M3;

import java.util.concurrent.atomic.AtomicReference;
import x3.p;
import x3.q;
import x3.s;
import x3.u;

/* loaded from: classes.dex */
public final class i<T> extends q<T> {

    /* renamed from: a, reason: collision with root package name */
    final u<? extends T> f4146a;

    /* renamed from: b, reason: collision with root package name */
    final p f4147b;

    static final class a<T> extends AtomicReference<A3.c> implements s<T>, A3.c, Runnable {

        /* renamed from: a, reason: collision with root package name */
        final s<? super T> f4148a;

        /* renamed from: b, reason: collision with root package name */
        final E3.f f4149b = new E3.f();

        /* renamed from: c, reason: collision with root package name */
        final u<? extends T> f4150c;

        a(s<? super T> sVar, u<? extends T> uVar) {
            this.f4148a = sVar;
            this.f4150c = uVar;
        }

        @Override // x3.s, x3.InterfaceC1287c, x3.k
        public void b(A3.c cVar) {
            E3.b.j(this, cVar);
        }

        @Override // x3.s, x3.k
        public void c(T t5) {
            this.f4148a.c(t5);
        }

        @Override // A3.c
        public void dispose() {
            E3.b.b(this);
            this.f4149b.dispose();
        }

        @Override // A3.c
        public boolean g() {
            return E3.b.d(get());
        }

        @Override // x3.s, x3.InterfaceC1287c, x3.k
        public void onError(Throwable th) {
            this.f4148a.onError(th);
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f4150c.a(this);
        }
    }

    public i(u<? extends T> uVar, p pVar) {
        this.f4146a = uVar;
        this.f4147b = pVar;
    }

    @Override // x3.q
    protected void m(s<? super T> sVar) {
        a aVar = new a(sVar, this.f4146a);
        sVar.b(aVar);
        aVar.f4149b.a(this.f4147b.b(aVar));
    }
}
