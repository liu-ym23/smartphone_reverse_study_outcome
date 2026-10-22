package L3;

import java.util.NoSuchElementException;
import x3.n;
import x3.o;
import x3.q;
import x3.s;

/* loaded from: classes.dex */
public final class d<T> extends q<T> {

    /* renamed from: a, reason: collision with root package name */
    final n<? extends T> f3911a;

    /* renamed from: b, reason: collision with root package name */
    final T f3912b;

    static final class a<T> implements o<T>, A3.c {

        /* renamed from: a, reason: collision with root package name */
        final s<? super T> f3913a;

        /* renamed from: b, reason: collision with root package name */
        final T f3914b;

        /* renamed from: c, reason: collision with root package name */
        A3.c f3915c;

        /* renamed from: d, reason: collision with root package name */
        T f3916d;

        /* renamed from: e, reason: collision with root package name */
        boolean f3917e;

        a(s<? super T> sVar, T t5) {
            this.f3913a = sVar;
            this.f3914b = t5;
        }

        @Override // x3.o
        public void a() {
            if (this.f3917e) {
                return;
            }
            this.f3917e = true;
            T t5 = this.f3916d;
            this.f3916d = null;
            if (t5 == null) {
                t5 = this.f3914b;
            }
            if (t5 != null) {
                this.f3913a.c(t5);
            } else {
                this.f3913a.onError(new NoSuchElementException());
            }
        }

        @Override // x3.o
        public void b(A3.c cVar) {
            if (E3.b.l(this.f3915c, cVar)) {
                this.f3915c = cVar;
                this.f3913a.b(this);
            }
        }

        @Override // x3.o
        public void d(T t5) {
            if (this.f3917e) {
                return;
            }
            if (this.f3916d == null) {
                this.f3916d = t5;
                return;
            }
            this.f3917e = true;
            this.f3915c.dispose();
            this.f3913a.onError(new IllegalArgumentException("Sequence contains more than one element!"));
        }

        @Override // A3.c
        public void dispose() {
            this.f3915c.dispose();
        }

        @Override // A3.c
        public boolean g() {
            return this.f3915c.g();
        }

        @Override // x3.o
        public void onError(Throwable th) {
            if (this.f3917e) {
                S3.a.r(th);
            } else {
                this.f3917e = true;
                this.f3913a.onError(th);
            }
        }
    }

    public d(n<? extends T> nVar, T t5) {
        this.f3911a = nVar;
        this.f3912b = t5;
    }

    @Override // x3.q
    public void m(s<? super T> sVar) {
        this.f3911a.a(new a(sVar, this.f3912b));
    }
}
