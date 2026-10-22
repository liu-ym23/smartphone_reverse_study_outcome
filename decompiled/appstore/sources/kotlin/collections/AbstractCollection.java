package kotlin.collections;

import java.util.Collection;
import java.util.Iterator;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public abstract class AbstractCollection implements Collection, KMappedMarker {
    public AbstractCollection() {
    }

    @Override // java.util.Collection
    public boolean add(Object r10) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean addAll(Collection<Object> r10) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean contains(Object r10) {
        if (isEmpty() == true) goto L15;
        Iterator<E> r11 = iterator();
    L7:
        if (r11.hasNext() == false) goto L16;
        if (kotlin.jvm.internal.q.b(r11.next(), r10) == false) goto L7;
        return true;
    L16:
        return false;
    L15:
        return false;
    }

    @Override // java.util.Collection
    public boolean containsAll(@NotNull Collection<? extends Object> r10) {
        kotlin.jvm.internal.q.g(r10, "elements");
        Collection<? extends Object> r11 = r10;
        if (r11.isEmpty() == true) goto L15;
        Iterator<T> r12 = r11.iterator();
    L7:
        if (r12.hasNext() == false) goto L16;
        if (contains(r12.next()) == true) goto L7;
        return false;
    L16:
        return true;
    L15:
        return true;
    }

    public abstract int getSize();

    @Override // java.util.Collection
    public boolean isEmpty() {
        if (size() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.Collection
    public boolean remove(Object r10) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean removeAll(Collection<? extends Object> r10) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean retainAll(Collection<? extends Object> r10) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final /* bridge */ int size() {
        return getSize();
    }

    @Override // java.util.Collection
    @NotNull
    public Object[] toArray() {
        return kotlin.jvm.internal.m.a(this);
    }

    @NotNull
    public String toString() {
        return b0.h0(this, ", ", "[", "]", 0, null, new AnonymousClass1(this), 24, null);
    }

    @Override // java.util.Collection
    @NotNull
    public <T> T[] toArray(@NotNull T[] r10) {
        kotlin.jvm.internal.q.g(r10, "array");
        return (T[]) kotlin.jvm.internal.m.b(this, r10);
    }
}
