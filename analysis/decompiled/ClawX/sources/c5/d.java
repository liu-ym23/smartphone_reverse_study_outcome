package c5;

import java.util.ListIterator;
import java.util.NoSuchElementException;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class d extends b5.o implements ListIterator {
    public final /* synthetic */ f d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(f fVar, int i8) {
        super(fVar);
        this.d = fVar;
        int iF = fVar.f();
        if (i8 < 0 || i8 > iF) {
            throw new IndexOutOfBoundsException(a8.b.i(i8, iF, "index: ", ", size: "));
        }
        this.f908b = i8;
    }

    @Override // java.util.ListIterator
    public final void add(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.f908b > 0;
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.f908b;
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        if (!hasPrevious()) {
            throw new NoSuchElementException();
        }
        int i8 = this.f908b - 1;
        this.f908b = i8;
        return this.d.get(i8);
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.f908b - 1;
    }

    @Override // java.util.ListIterator
    public final void set(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
