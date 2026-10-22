package d.a;

import java.util.Iterator;

/* JADX INFO: compiled from: PrimitiveIterators.kt */
/* JADX INFO: loaded from: classes4.dex */
public abstract class am implements d.h.b.a.a, Iterator<Long> {
    public abstract long a();

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public am() {
    }

    @Override // java.util.Iterator
    public /* synthetic */ Long next() {
        return Long.valueOf(a());
    }
}
