package D7;

import java.util.List;
import java.util.ListIterator;

/* loaded from: classes3.dex */
public final class I implements ListIterator, T7.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f395a = 0;
    public final ListIterator b;
    public final /* synthetic */ Object c;

    public I(K k, int i) {
        this.c = k;
        this.b = ((List) k.b).listIterator(v.q0(i, k));
    }

    @Override // java.util.ListIterator
    public final void add(Object obj) {
        switch (this.f395a) {
            case 0:
                ListIterator listIterator = this.b;
                listIterator.add(obj);
                listIterator.previous();
                return;
            default:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final boolean hasNext() {
        switch (this.f395a) {
        }
        return this.b.hasPrevious();
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        switch (this.f395a) {
        }
        return this.b.hasNext();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final Object next() {
        switch (this.f395a) {
        }
        return this.b.previous();
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        int iPreviousIndex;
        int iH;
        switch (this.f395a) {
            case 0:
                J j5 = (J) this.c;
                iPreviousIndex = this.b.previousIndex();
                iH = H4.o.H(j5);
                break;
            default:
                K k = (K) this.c;
                iPreviousIndex = this.b.previousIndex();
                iH = H4.o.H(k);
                break;
        }
        return iH - iPreviousIndex;
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        switch (this.f395a) {
        }
        return this.b.next();
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        int iNextIndex;
        int iH;
        switch (this.f395a) {
            case 0:
                J j5 = (J) this.c;
                iNextIndex = this.b.nextIndex();
                iH = H4.o.H(j5);
                break;
            default:
                K k = (K) this.c;
                iNextIndex = this.b.nextIndex();
                iH = H4.o.H(k);
                break;
        }
        return iH - iNextIndex;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final void remove() {
        switch (this.f395a) {
            case 0:
                this.b.remove();
                return;
            default:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    @Override // java.util.ListIterator
    public final void set(Object obj) {
        switch (this.f395a) {
            case 0:
                this.b.set(obj);
                return;
            default:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public I(J j5, int i) {
        this.c = j5;
        this.b = j5.f396a.listIterator(v.q0(i, j5));
    }
}
