package M3;

import java.util.concurrent.atomic.AtomicReference;
import x3.p;
import x3.q;
import x3.s;
import x3.u;

/* loaded from: classes.dex */
public final class h<T> extends q<T> {

    /* renamed from: a, reason: collision with root package name */
    final u<T> f4140a;

    /* renamed from: b, reason: collision with root package name */
    final p f4141b;

    static final class a<T> extends AtomicReference<A3.c> implements s<T>, A3.c, Runnable {

        /* renamed from: a, reason: collision with root package name */
        final s<? super T> f4142a;

        /* renamed from: b, reason: collision with root package name */
        final p f4143b;

        /* renamed from: c, reason: collision with root package name */
        T f4144c;

        /* renamed from: d, reason: collision with root package name */
        Throwable f4145d;

        a(s<? super T> sVar, p pVar) {
            this.f4142a = sVar;
            this.f4143b = pVar;
        }

        @Override // x3.s, x3.InterfaceC1287c, x3.k
        public void b(A3.c cVar) {
            if (E3.b.j(this, cVar)) {
                this.f4142a.b(this);
            }
        }

        @Override // x3.s, x3.k
        public void c(T t5) {
            this.f4144c = t5;
            E3.b.e(this, this.f4143b.b(this));
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
            this.f4145d = th;
            E3.b.e(this, this.f4143b.b(this));
        }

        @Override // java.lang.Runnable
        public void run() {
            Throwable th = this.f4145d;
            if (th != null) {
                this.f4142a.onError(th);
            } else {
                this.f4142a.c(this.f4144c);
            }
        }
    }

    public h(u<T> uVar, p pVar) {
        this.f4140a = uVar;
        this.f4141b = pVar;
    }

    @Override // x3.q
    protected void m(s<? super T> sVar) {
        this.f4140a.a(new a(sVar, this.f4141b));
    }
}
