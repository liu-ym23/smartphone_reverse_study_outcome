package M3;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import x3.s;
import x3.u;

/* loaded from: classes.dex */
public final class d<T, R> extends x3.f<R> {

    /* renamed from: b, reason: collision with root package name */
    final u<T> f4128b;

    /* renamed from: c, reason: collision with root package name */
    final D3.h<? super T, ? extends Q4.a<? extends R>> f4129c;

    static final class a<S, T> extends AtomicLong implements s<S>, x3.i<T>, Q4.c {

        /* renamed from: a, reason: collision with root package name */
        final Q4.b<? super T> f4130a;

        /* renamed from: b, reason: collision with root package name */
        final D3.h<? super S, ? extends Q4.a<? extends T>> f4131b;

        /* renamed from: c, reason: collision with root package name */
        final AtomicReference<Q4.c> f4132c = new AtomicReference<>();

        /* renamed from: d, reason: collision with root package name */
        A3.c f4133d;

        a(Q4.b<? super T> bVar, D3.h<? super S, ? extends Q4.a<? extends T>> hVar) {
            this.f4130a = bVar;
            this.f4131b = hVar;
        }

        @Override // Q4.b
        public void a() {
            this.f4130a.a();
        }

        @Override // x3.s, x3.InterfaceC1287c, x3.k
        public void b(A3.c cVar) {
            this.f4133d = cVar;
            this.f4130a.e(this);
        }

        @Override // x3.s, x3.k
        public void c(S s5) {
            try {
                ((Q4.a) F3.b.d(this.f4131b.apply(s5), "the mapper returned a null Publisher")).c(this);
            } catch (Throwable th) {
                B3.b.b(th);
                this.f4130a.onError(th);
            }
        }

        @Override // Q4.c
        public void cancel() {
            this.f4133d.dispose();
            Q3.g.b(this.f4132c);
        }

        @Override // Q4.b
        public void d(T t5) {
            this.f4130a.d(t5);
        }

        @Override // x3.i, Q4.b
        public void e(Q4.c cVar) {
            Q3.g.e(this.f4132c, this, cVar);
        }

        @Override // Q4.c
        public void h(long j5) {
            Q3.g.d(this.f4132c, this, j5);
        }

        @Override // x3.s, x3.InterfaceC1287c, x3.k
        public void onError(Throwable th) {
            this.f4130a.onError(th);
        }
    }

    public d(u<T> uVar, D3.h<? super T, ? extends Q4.a<? extends R>> hVar) {
        this.f4128b = uVar;
        this.f4129c = hVar;
    }

    @Override // x3.f
    protected void W(Q4.b<? super R> bVar) {
        this.f4128b.a(new a(bVar, this.f4129c));
    }
}
