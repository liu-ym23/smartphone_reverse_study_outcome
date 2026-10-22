package z2;

import java.util.Iterator;

/* renamed from: z2.O, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC6071O implements Iterator {

    /* renamed from: a, reason: collision with root package name */
    public final Iterator f44745a;

    public AbstractC6071O(Iterator it) {
        it.getClass();
        this.f44745a = it;
    }

    public abstract Object a(Object obj);

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f44745a.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        return a(this.f44745a.next());
    }

    @Override // java.util.Iterator
    public final void remove() {
        this.f44745a.remove();
    }
}
