package z2;

import java.util.NoSuchElementException;

/* renamed from: z2.o, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC6215o extends AbstractC6073Q {

    /* renamed from: a, reason: collision with root package name */
    public final int f45076a;

    /* renamed from: b, reason: collision with root package name */
    public int f45077b;

    public AbstractC6215o(int i10, int i11) {
        C6195m.b(i11, i10, "index");
        this.f45076a = i10;
        this.f45077b = i11;
    }

    public abstract Object a(int i10);

    @Override // java.util.Iterator, java.util.ListIterator
    public final boolean hasNext() {
        return this.f45077b < this.f45076a;
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.f45077b > 0;
    }

    @Override // java.util.Iterator, java.util.ListIterator
    public final Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int i10 = this.f45077b;
        this.f45077b = i10 + 1;
        return a(i10);
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.f45077b;
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        if (!hasPrevious()) {
            throw new NoSuchElementException();
        }
        int i10 = this.f45077b - 1;
        this.f45077b = i10;
        return a(i10);
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.f45077b - 1;
    }
}
