package H3;

import java.util.concurrent.atomic.AtomicReference;
import x3.InterfaceC1287c;

/* loaded from: classes.dex */
public final class b extends AtomicReference<A3.c> implements InterfaceC1287c, A3.c, D3.c<Throwable> {

    /* renamed from: a, reason: collision with root package name */
    final D3.c<? super Throwable> f2858a;

    /* renamed from: b, reason: collision with root package name */
    final D3.a f2859b;

    public b(D3.a aVar) {
        this.f2858a = this;
        this.f2859b = aVar;
    }

    @Override // x3.InterfaceC1287c, x3.k
    public void a() {
        try {
            this.f2859b.run();
        } catch (Throwable th) {
            B3.b.b(th);
            S3.a.r(th);
        }
        lazySet(E3.b.DISPOSED);
    }

    @Override // x3.InterfaceC1287c, x3.k
    public void b(A3.c cVar) {
        E3.b.j(this, cVar);
    }

    @Override // D3.c
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void accept(Throwable th) {
        S3.a.r(new B3.d(th));
    }

    @Override // A3.c
    public void dispose() {
        E3.b.b(this);
    }

    @Override // A3.c
    public boolean g() {
        return get() == E3.b.DISPOSED;
    }

    @Override // x3.InterfaceC1287c, x3.k
    public void onError(Throwable th) {
        try {
            this.f2858a.accept(th);
        } catch (Throwable th2) {
            B3.b.b(th2);
            S3.a.r(th2);
        }
        lazySet(E3.b.DISPOSED);
    }

    public b(D3.c<? super Throwable> cVar, D3.a aVar) {
        this.f2858a = cVar;
        this.f2859b = aVar;
    }
}
