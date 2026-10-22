package L3;

import x3.j;
import x3.k;
import x3.n;
import x3.o;

/* loaded from: classes.dex */
public final class c<T> extends j<T> {

    /* renamed from: a, reason: collision with root package name */
    final n<T> f3906a;

    static final class a<T> implements o<T>, A3.c {

        /* renamed from: a, reason: collision with root package name */
        final k<? super T> f3907a;

        /* renamed from: b, reason: collision with root package name */
        A3.c f3908b;

        /* renamed from: c, reason: collision with root package name */
        T f3909c;

        /* renamed from: d, reason: collision with root package name */
        boolean f3910d;

        a(k<? super T> kVar) {
            this.f3907a = kVar;
        }

        @Override // x3.o
        public void a() {
            if (this.f3910d) {
                return;
            }
            this.f3910d = true;
            T t5 = this.f3909c;
            this.f3909c = null;
            if (t5 == null) {
                this.f3907a.a();
            } else {
                this.f3907a.c(t5);
            }
        }

        @Override // x3.o
        public void b(A3.c cVar) {
            if (E3.b.l(this.f3908b, cVar)) {
                this.f3908b = cVar;
                this.f3907a.b(this);
            }
        }

        @Override // x3.o
        public void d(T t5) {
            if (this.f3910d) {
                return;
            }
            if (this.f3909c == null) {
                this.f3909c = t5;
                return;
            }
            this.f3910d = true;
            this.f3908b.dispose();
            this.f3907a.onError(new IllegalArgumentException("Sequence contains more than one element!"));
        }

        @Override // A3.c
        public void dispose() {
            this.f3908b.dispose();
        }

        @Override // A3.c
        public boolean g() {
            return this.f3908b.g();
        }

        @Override // x3.o
        public void onError(Throwable th) {
            if (this.f3910d) {
                S3.a.r(th);
            } else {
                this.f3910d = true;
                this.f3907a.onError(th);
            }
        }
    }

    public c(n<T> nVar) {
        this.f3906a = nVar;
    }

    @Override // x3.j
    public void c(k<? super T> kVar) {
        this.f3906a.a(new a(kVar));
    }
}
