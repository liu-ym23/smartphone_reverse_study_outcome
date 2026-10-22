package W3;

import i4.InterfaceC0772l;
import java.util.Collection;
import java.util.Iterator;
import k4.InterfaceC0814a;

/* renamed from: W3.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0391b<E> implements Collection<E>, InterfaceC0814a {
    protected AbstractC0391b() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence f(AbstractC0391b abstractC0391b, Object obj) {
        return obj == abstractC0391b ? "(this Collection)" : String.valueOf(obj);
    }

    @Override // java.util.Collection
    public boolean add(E e6) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean addAll(Collection<? extends E> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public abstract int c();

    @Override // java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean contains(Object obj) {
        if (isEmpty()) {
            return false;
        }
        Iterator<E> it = iterator();
        while (it.hasNext()) {
            if (j4.k.b(it.next(), obj)) {
                return true;
            }
        }
        return false;
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
        return size() == 0;
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
        return c();
    }

    @Override // java.util.Collection
    public Object[] toArray() {
        return j4.f.a(this);
    }

    public String toString() {
        return x.I(this, ", ", "[", "]", 0, null, new InterfaceC0772l() { // from class: W3.a
            @Override // i4.InterfaceC0772l
            public final Object invoke(Object obj) {
                return AbstractC0391b.f(this.f5746a, obj);
            }
        }, 24, null);
    }

    @Override // java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        j4.k.g(tArr, "array");
        return (T[]) j4.f.b(this, tArr);
    }
}
