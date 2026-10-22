package A3;

import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
abstract class e<T> extends AtomicReference<T> implements c {
    e(T t5) {
        super(F3.b.d(t5, "value is null"));
    }

    protected abstract void a(T t5);

    @Override // A3.c
    public final void dispose() {
        T andSet;
        if (get() == null || (andSet = getAndSet(null)) == null) {
            return;
        }
        a(andSet);
    }

    @Override // A3.c
    public final boolean g() {
        return get() == null;
    }
}
