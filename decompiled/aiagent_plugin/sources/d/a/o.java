package d.a;

import java.util.Iterator;

/* JADX INFO: compiled from: PrimitiveIterators.kt */
/* JADX INFO: loaded from: classes4.dex */
public abstract class o implements d.h.b.a.a, Iterator<Character> {
    public abstract char a();

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public o() {
    }

    @Override // java.util.Iterator
    public /* synthetic */ Character next() {
        return Character.valueOf(a());
    }
}
