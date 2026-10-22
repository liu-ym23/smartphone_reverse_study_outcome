package L3;

import java.util.concurrent.atomic.AtomicReference;
import x3.n;
import x3.o;
import x3.p;

/* loaded from: classes.dex */
public final class e<T> extends L3.a<T, T> {

    /* renamed from: b, reason: collision with root package name */
    final p f3918b;

    static final class a<T> extends AtomicReference<A3.c> implements o<T>, A3.c {

        /* renamed from: a, reason: collision with root package name */
        final o<? super T> f3919a;

        /* renamed from: b, reason: collision with root package name */
        final AtomicReference<A3.c> f3920b = new AtomicReference<>();

        a(o<? super T> oVar) {
            this.f3919a = oVar;
        }

        @Override // x3.o
        public void a() {
            this.f3919a.a();
        }

        @Override // x3.o
        public void b(A3.c cVar) {
            E3.b.j(this.f3920b, cVar);
        }

        void c(A3.c cVar) {
            E3.b.j(this, cVar);
        }

        @Override // x3.o
        public void d(T t5) {
            this.f3919a.d(t5);
        }

        @Override // A3.c
        public void dispose() {
            E3.b.b(this.f3920b);
            E3.b.b(this);
        }

        @Override // A3.c
        public boolean g() {
            return E3.b.d(get());
        }

        @Override // x3.o
        public void onError(Throwable th) {
            this.f3919a.onError(th);
        }
    }

    final class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private final a<T> f3921a;

        b(a<T> aVar) {
            this.f3921a = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.f3902a.a(this.f3921a);
        }
    }

    public e(n<T> nVar, p pVar) {
        super(nVar);
        this.f3918b = pVar;
    }

    @Override // x3.m
    public void e(o<? super T> oVar) {
        a aVar = new a(oVar);
        oVar.b(aVar);
        aVar.c(this.f3918b.b(new b(aVar)));
    }
}
