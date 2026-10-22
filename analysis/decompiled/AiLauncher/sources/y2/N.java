package y2;

import java.util.NoSuchElementException;

/* loaded from: classes2.dex */
public abstract class N extends AbstractC5927h {

    /* renamed from: a, reason: collision with root package name */
    public final int f43819a;

    /* renamed from: b, reason: collision with root package name */
    public int f43820b;

    public N(int i10, int i11) {
        L.b(i11, i10, "index");
        this.f43819a = i10;
        this.f43820b = i11;
    }

    public abstract Object a(int i10);

    @Override // java.util.Iterator, java.util.ListIterator
    public final boolean hasNext() {
        return this.f43820b < this.f43819a;
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.f43820b > 0;
    }

    @Override // java.util.Iterator, java.util.ListIterator
    public final Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int i10 = this.f43820b;
        this.f43820b = i10 + 1;
        return a(i10);
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.f43820b;
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        if (!hasPrevious()) {
            throw new NoSuchElementException();
        }
        int i10 = this.f43820b - 1;
        this.f43820b = i10;
        return a(i10);
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.f43820b - 1;
    }
}
