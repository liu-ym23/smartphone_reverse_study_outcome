package g9;

import java.util.AbstractList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes4.dex */
public final class e implements Iterator {

    /* renamed from: a, reason: collision with root package name */
    public boolean f4503a;
    public final int b;
    public final /* synthetic */ f c;

    public e(f fVar) {
        this.c = fVar;
        this.b = ((AbstractList) fVar).modCount;
    }

    public final void a() {
        f fVar = this.c;
        int i = ((AbstractList) fVar).modCount;
        int i6 = this.b;
        if (i == i6) {
            return;
        }
        throw new ConcurrentModificationException("ModCount: " + ((AbstractList) fVar).modCount + "; expected: " + i6);
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return !this.f4503a;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (this.f4503a) {
            throw new NoSuchElementException();
        }
        this.f4503a = true;
        a();
        return this.c.b;
    }

    @Override // java.util.Iterator
    public final void remove() {
        a();
        this.c.clear();
    }
}
