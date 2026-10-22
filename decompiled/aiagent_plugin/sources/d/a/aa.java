package d.a;

import java.util.ListIterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: Collections.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class aa implements d.h.b.a.a, ListIterator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final aa f38344a = null;

    static {
        f38344a = new aa();
    }

    @Override // java.util.ListIterator
    public /* synthetic */ void add(Object r1) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public boolean hasNext() {
        return false;
    }

    @Override // java.util.ListIterator
    public boolean hasPrevious() {
        return false;
    }

    @Override // java.util.ListIterator
    public int nextIndex() {
        return 0;
    }

    @Override // java.util.ListIterator
    public int previousIndex() {
        return -1;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.ListIterator
    public /* synthetic */ void set(Object r1) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    private aa() {
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public /* synthetic */ Object next() {
        return a();
    }

    @Override // java.util.ListIterator
    public /* synthetic */ Object previous() {
        return b();
    }

    public Void a() {
        throw new NoSuchElementException();
    }

    public Void b() {
        throw new NoSuchElementException();
    }
}
