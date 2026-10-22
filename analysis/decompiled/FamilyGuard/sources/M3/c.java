package M3;

import java.util.concurrent.atomic.AtomicReference;
import x3.q;
import x3.s;
import x3.u;

/* loaded from: classes.dex */
public final class c<T, R> extends q<R> {

    /* renamed from: a, reason: collision with root package name */
    final u<? extends T> f4122a;

    /* renamed from: b, reason: collision with root package name */
    final D3.h<? super T, ? extends u<? extends R>> f4123b;

    static final class a<T, R> extends AtomicReference<A3.c> implements s<T>, A3.c {

        /* renamed from: a, reason: collision with root package name */
        final s<? super R> f4124a;

        /* renamed from: b, reason: collision with root package name */
        final D3.h<? super T, ? extends u<? extends R>> f4125b;

        /* renamed from: M3.c$a$a, reason: collision with other inner class name */
        static final class C0060a<R> implements s<R> {

            /* renamed from: a, reason: collision with root package name */
            final AtomicReference<A3.c> f4126a;

            /* renamed from: b, reason: collision with root package name */
            final s<? super R> f4127b;

            C0060a(AtomicReference<A3.c> atomicReference, s<? super R> sVar) {
                this.f4126a = atomicReference;
                this.f4127b = sVar;
            }

            @Override // x3.s, x3.InterfaceC1287c, x3.k
            public void b(A3.c cVar) {
                E3.b.e(this.f4126a, cVar);
            }

            @Override // x3.s, x3.k
            public void c(R r5) {
                this.f4127b.c(r5);
            }

            @Override // x3.s, x3.InterfaceC1287c, x3.k
            public void onError(Throwable th) {
                this.f4127b.onError(th);
            }
        }

        a(s<? super R> sVar, D3.h<? super T, ? extends u<? extends R>> hVar) {
            this.f4124a = sVar;
            this.f4125b = hVar;
        }

        @Override // x3.s, x3.InterfaceC1287c, x3.k
        public void b(A3.c cVar) {
            if (E3.b.j(this, cVar)) {
                this.f4124a.b(this);
            }
        }

        @Override // x3.s, x3.k
        public void c(T t5) {
            try {
                u uVar = (u) F3.b.d(this.f4125b.apply(t5), "The single returned by the mapper is null");
                if (g()) {
                    return;
                }
                uVar.a(new C0060a(this, this.f4124a));
            } catch (Throwable th) {
                B3.b.b(th);
                this.f4124a.onError(th);
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

        @Override // x3.s, x3.InterfaceC1287c, x3.k
        public void onError(Throwable th) {
            this.f4124a.onError(th);
        }
    }

    public c(u<? extends T> uVar, D3.h<? super T, ? extends u<? extends R>> hVar) {
        this.f4123b = hVar;
        this.f4122a = uVar;
    }

    @Override // x3.q
    protected void m(s<? super R> sVar) {
        this.f4122a.a(new a(sVar, this.f4123b));
    }
}
