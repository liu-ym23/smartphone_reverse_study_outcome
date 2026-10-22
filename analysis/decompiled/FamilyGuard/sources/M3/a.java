package M3;

import java.util.concurrent.atomic.AtomicReference;
import x3.q;
import x3.r;
import x3.s;
import x3.t;

/* loaded from: classes.dex */
public final class a<T> extends q<T> {

    /* renamed from: a, reason: collision with root package name */
    final t<T> f4119a;

    /* renamed from: M3.a$a, reason: collision with other inner class name */
    static final class C0059a<T> extends AtomicReference<A3.c> implements r<T>, A3.c {

        /* renamed from: a, reason: collision with root package name */
        final s<? super T> f4120a;

        C0059a(s<? super T> sVar) {
            this.f4120a = sVar;
        }

        public boolean a(Throwable th) {
            A3.c andSet;
            if (th == null) {
                th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
            }
            A3.c cVar = get();
            E3.b bVar = E3.b.DISPOSED;
            if (cVar == bVar || (andSet = getAndSet(bVar)) == bVar) {
                return false;
            }
            try {
                this.f4120a.onError(th);
            } finally {
                if (andSet != null) {
                    andSet.dispose();
                }
            }
        }

        @Override // x3.r
        public void c(T t5) {
            A3.c andSet;
            A3.c cVar = get();
            E3.b bVar = E3.b.DISPOSED;
            if (cVar == bVar || (andSet = getAndSet(bVar)) == bVar) {
                return;
            }
            try {
                if (t5 == null) {
                    this.f4120a.onError(new NullPointerException("onSuccess called with null. Null values are generally not allowed in 2.x operators and sources."));
                } else {
                    this.f4120a.c(t5);
                }
                if (andSet != null) {
                    andSet.dispose();
                }
            } catch (Throwable th) {
                if (andSet != null) {
                    andSet.dispose();
                }
                throw th;
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

        @Override // x3.r
        public void onError(Throwable th) {
            if (a(th)) {
                return;
            }
            S3.a.r(th);
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public String toString() {
            return String.format("%s{%s}", C0059a.class.getSimpleName(), super.toString());
        }
    }

    public a(t<T> tVar) {
        this.f4119a = tVar;
    }

    @Override // x3.q
    protected void m(s<? super T> sVar) {
        C0059a c0059a = new C0059a(sVar);
        sVar.b(c0059a);
        try {
            this.f4119a.a(c0059a);
        } catch (Throwable th) {
            B3.b.b(th);
            c0059a.onError(th);
        }
    }
}
