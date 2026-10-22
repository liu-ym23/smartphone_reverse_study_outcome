package d7;

import java.util.ListIterator;
import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public final class d extends c implements ListIterator {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ f f2953i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(f fVar, int i2) {
        super(fVar);
        this.f2953i = fVar;
        int iA = fVar.a();
        if (i2 < 0 || i2 > iA) {
            throw new IndexOutOfBoundsException(m.x.k("index: ", i2, iA, ", size: "));
        }
        this.f2949g = i2;
    }

    @Override // java.util.ListIterator
    public final void add(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.f2949g > 0;
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.f2949g;
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        if (!hasPrevious()) {
            throw new NoSuchElementException();
        }
        int i2 = this.f2949g - 1;
        this.f2949g = i2;
        return this.f2953i.get(i2);
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.f2949g - 1;
    }

    @Override // java.util.ListIterator
    public final void set(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
