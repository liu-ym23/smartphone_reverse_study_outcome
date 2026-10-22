package H3;

import java.util.concurrent.atomic.AtomicReference;
import x3.s;

/* loaded from: classes.dex */
public final class c<T> extends AtomicReference<A3.c> implements s<T>, A3.c {

    /* renamed from: a, reason: collision with root package name */
    final D3.c<? super T> f2860a;

    /* renamed from: b, reason: collision with root package name */
    final D3.c<? super Throwable> f2861b;

    public c(D3.c<? super T> cVar, D3.c<? super Throwable> cVar2) {
        this.f2860a = cVar;
        this.f2861b = cVar2;
    }

    @Override // x3.s, x3.InterfaceC1287c, x3.k
    public void b(A3.c cVar) {
        E3.b.j(this, cVar);
    }

    @Override // x3.s, x3.k
    public void c(T t5) {
        lazySet(E3.b.DISPOSED);
        try {
            this.f2860a.accept(t5);
        } catch (Throwable th) {
            B3.b.b(th);
            S3.a.r(th);
        }
    }

    @Override // A3.c
    public void dispose() {
        E3.b.b(this);
    }

    @Override // A3.c
    public boolean g() {
        return get() == E3.b.DISPOSED;
    }

    @Override // x3.s, x3.InterfaceC1287c, x3.k
    public void onError(Throwable th) {
        lazySet(E3.b.DISPOSED);
        try {
            this.f2861b.accept(th);
        } catch (Throwable th2) {
            B3.b.b(th2);
            S3.a.r(new B3.a(th, th2));
        }
    }
}
