package A2;

import java.util.NoSuchElementException;

/* loaded from: classes2.dex */
public abstract class H2 extends AbstractC0590d {

    /* renamed from: a, reason: collision with root package name */
    public final int f384a;

    /* renamed from: b, reason: collision with root package name */
    public int f385b;

    public H2(int i10, int i11) {
        F1.b(i11, i10, "index");
        this.f384a = i10;
        this.f385b = i11;
    }

    public abstract Object a(int i10);

    @Override // java.util.Iterator, java.util.ListIterator
    public final boolean hasNext() {
        return this.f385b < this.f384a;
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.f385b > 0;
    }

    @Override // java.util.Iterator, java.util.ListIterator
    public final Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int i10 = this.f385b;
        this.f385b = i10 + 1;
        return a(i10);
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.f385b;
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        if (!hasPrevious()) {
            throw new NoSuchElementException();
        }
        int i10 = this.f385b - 1;
        this.f385b = i10;
        return a(i10);
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.f385b - 1;
    }
}
