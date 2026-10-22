package d.a;

import java.util.Iterator;

/* JADX INFO: compiled from: PrimitiveIterators.kt */
/* JADX INFO: loaded from: classes4.dex */
public abstract class al implements d.h.b.a.a, Iterator<Integer> {
    public abstract int a();

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public al() {
    }

    @Override // java.util.Iterator
    public /* synthetic */ Integer next() {
        return Integer.valueOf(a());
    }
}
