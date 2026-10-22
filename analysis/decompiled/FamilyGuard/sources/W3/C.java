package W3;

import java.util.Iterator;
import k4.InterfaceC0814a;

/* loaded from: classes.dex */
public abstract class C implements Iterator<Integer>, InterfaceC0814a {
    @Override // java.util.Iterator
    public /* bridge */ /* synthetic */ Integer next() {
        return Integer.valueOf(nextInt());
    }

    public abstract int nextInt();

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
