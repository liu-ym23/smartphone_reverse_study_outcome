package M3;

import x3.q;
import x3.s;
import x3.u;

/* loaded from: classes.dex */
public final class g<T, R> extends q<R> {

    /* renamed from: a, reason: collision with root package name */
    final u<? extends T> f4136a;

    /* renamed from: b, reason: collision with root package name */
    final D3.h<? super T, ? extends R> f4137b;

    static final class a<T, R> implements s<T> {

        /* renamed from: a, reason: collision with root package name */
        final s<? super R> f4138a;

        /* renamed from: b, reason: collision with root package name */
        final D3.h<? super T, ? extends R> f4139b;

        a(s<? super R> sVar, D3.h<? super T, ? extends R> hVar) {
            this.f4138a = sVar;
            this.f4139b = hVar;
        }

        @Override // x3.s, x3.InterfaceC1287c, x3.k
        public void b(A3.c cVar) {
            this.f4138a.b(cVar);
        }

        @Override // x3.s, x3.k
        public void c(T t5) {
            try {
                this.f4138a.c(F3.b.d(this.f4139b.apply(t5), "The mapper function returned a null value."));
            } catch (Throwable th) {
                B3.b.b(th);
                onError(th);
            }
        }

        @Override // x3.s, x3.InterfaceC1287c, x3.k
        public void onError(Throwable th) {
            this.f4138a.onError(th);
        }
    }

    public g(u<? extends T> uVar, D3.h<? super T, ? extends R> hVar) {
        this.f4136a = uVar;
        this.f4137b = hVar;
    }

    @Override // x3.q
    protected void m(s<? super R> sVar) {
        this.f4136a.a(new a(sVar, this.f4137b));
    }
}
