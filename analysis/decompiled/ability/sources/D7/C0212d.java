package D7;

import java.util.ListIterator;
import java.util.NoSuchElementException;

/* renamed from: D7.d, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0212d extends C7.i implements ListIterator {
    public final /* synthetic */ AbstractC0214f d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0212d(AbstractC0214f abstractC0214f, int i) {
        super(abstractC0214f, 4);
        this.d = abstractC0214f;
        C0211c c0211c = AbstractC0214f.Companion;
        int size = abstractC0214f.size();
        c0211c.getClass();
        C0211c.c(i, size);
        this.b = i;
    }

    @Override // java.util.ListIterator
    public final void add(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.b > 0;
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.b;
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        if (!hasPrevious()) {
            throw new NoSuchElementException();
        }
        int i = this.b - 1;
        this.b = i;
        return this.d.get(i);
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.b - 1;
    }

    @Override // java.util.ListIterator
    public final void set(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
