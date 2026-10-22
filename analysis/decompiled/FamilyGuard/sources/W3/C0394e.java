package W3;

import java.util.Collection;
import java.util.Iterator;
import k4.InterfaceC0814a;

/* renamed from: W3.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
final class C0394e<T> implements Collection<T>, InterfaceC0814a {

    /* renamed from: a, reason: collision with root package name */
    private final T[] f5754a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f5755b;

    public C0394e(T[] tArr, boolean z5) {
        j4.k.g(tArr, "values");
        this.f5754a = tArr;
        this.f5755b = z5;
    }

    public int a() {
        return this.f5754a.length;
    }

    @Override // java.util.Collection
    public boolean add(T t5) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean addAll(Collection<? extends T> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean contains(Object obj) {
        return C0400k.l(this.f5754a, obj);
    }

    @Override // java.util.Collection
    public boolean containsAll(Collection<?> collection) {
        j4.k.g(collection, "elements");
        if (collection.isEmpty()) {
            return true;
        }
        Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return this.f5754a.length == 0;
    }

    @Override // java.util.Collection, java.lang.Iterable
    public Iterator<T> iterator() {
        return j4.b.a(this.f5754a);
    }

    @Override // java.util.Collection
    public boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean removeAll(Collection<?> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean retainAll(Collection<?> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final /* bridge */ int size() {
        return a();
    }

    @Override // java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        j4.k.g(tArr, "array");
        return (T[]) j4.f.b(this, tArr);
    }

    @Override // java.util.Collection
    public final Object[] toArray() {
        return o.a(this.f5754a, this.f5755b);
    }
}
