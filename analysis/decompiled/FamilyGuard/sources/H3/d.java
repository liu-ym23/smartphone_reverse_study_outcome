package H3;

import java.util.concurrent.atomic.AtomicReference;
import x3.InterfaceC1287c;

/* loaded from: classes.dex */
public final class d extends AtomicReference<A3.c> implements InterfaceC1287c, A3.c {
    @Override // x3.InterfaceC1287c, x3.k
    public void a() {
        lazySet(E3.b.DISPOSED);
    }

    @Override // x3.InterfaceC1287c, x3.k
    public void b(A3.c cVar) {
        E3.b.j(this, cVar);
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
        lazySet(E3.b.DISPOSED);
        S3.a.r(new B3.d(th));
    }
}
