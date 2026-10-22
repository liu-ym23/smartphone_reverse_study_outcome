package W3;

import java.util.Iterator;
import k4.InterfaceC0814a;

/* loaded from: classes.dex */
public abstract class D implements Iterator<Long>, InterfaceC0814a {
    @Override // java.util.Iterator
    public /* bridge */ /* synthetic */ Long next() {
        return Long.valueOf(nextLong());
    }

    public abstract long nextLong();

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
