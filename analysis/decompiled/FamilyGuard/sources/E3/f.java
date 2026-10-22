package E3;

import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public final class f extends AtomicReference<A3.c> implements A3.c {
    public f() {
    }

    public boolean a(A3.c cVar) {
        return b.e(this, cVar);
    }

    public boolean b(A3.c cVar) {
        return b.i(this, cVar);
    }

    @Override // A3.c
    public void dispose() {
        b.b(this);
    }

    @Override // A3.c
    public boolean g() {
        return b.d(get());
    }

    public f(A3.c cVar) {
        lazySet(cVar);
    }
}
