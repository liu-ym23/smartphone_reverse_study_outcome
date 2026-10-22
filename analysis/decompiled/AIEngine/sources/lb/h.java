package lb;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class h implements Collection<g>, ac.a {

    /* renamed from: a, reason: collision with root package name */
    public final int[] f10401a;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a implements Iterator<g>, ac.a {

        /* renamed from: a, reason: collision with root package name */
        public final int[] f10402a;

        /* renamed from: b, reason: collision with root package name */
        public int f10403b;

        public a(int[] iArr) {
            this.f10402a = iArr;
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.f10403b < this.f10402a.length;
        }

        @Override // java.util.Iterator
        public final g next() {
            int i10 = this.f10403b;
            int[] iArr = this.f10402a;
            if (i10 >= iArr.length) {
                throw new NoSuchElementException(String.valueOf(this.f10403b));
            }
            this.f10403b = i10 + 1;
            return new g(iArr[i10]);
        }

        @Override // java.util.Iterator
        public final void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    @Override // java.util.Collection
    public final /* bridge */ /* synthetic */ boolean add(g gVar) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final boolean addAll(Collection<? extends g> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final boolean contains(Object obj) {
        if (!(obj instanceof g)) {
            return false;
        }
        int i10 = ((g) obj).f10400a;
        int[] iArr = this.f10401a;
        int length = iArr.length;
        int i11 = 0;
        while (true) {
            if (i11 >= length) {
                i11 = -1;
                break;
            }
            if (i10 == iArr[i11]) {
                break;
            }
            i11++;
        }
        return i11 >= 0;
    }

    @Override // java.util.Collection
    public final boolean containsAll(Collection<? extends Object> elements) {
        kotlin.jvm.internal.g.f(elements, "elements");
        Collection<? extends Object> collection = elements;
        if (!collection.isEmpty()) {
            for (Object obj : collection) {
                if (obj instanceof g) {
                    int i10 = ((g) obj).f10400a;
                    int[] iArr = this.f10401a;
                    int length = iArr.length;
                    int i11 = 0;
                    while (true) {
                        if (i11 >= length) {
                            i11 = -1;
                            break;
                        }
                        if (i10 == iArr[i11]) {
                            break;
                        }
                        i11++;
                    }
                    if (i11 >= 0) {
                    }
                }
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Collection
    public final boolean equals(Object obj) {
        if (obj instanceof h) {
            return kotlin.jvm.internal.g.b(this.f10401a, ((h) obj).f10401a);
        }
        return false;
    }

    @Override // java.util.Collection
    public final int hashCode() {
        return Arrays.hashCode(this.f10401a);
    }

    @Override // java.util.Collection
    public final boolean isEmpty() {
        return this.f10401a.length == 0;
    }

    @Override // java.util.Collection, java.lang.Iterable
    public final Iterator<g> iterator() {
        return new a(this.f10401a);
    }

    @Override // java.util.Collection
    public final boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final boolean removeAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final boolean retainAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final int size() {
        return this.f10401a.length;
    }

    @Override // java.util.Collection
    public final Object[] toArray() {
        return kotlin.jvm.internal.d.a(this);
    }

    public final String toString() {
        return "UIntArray(storage=" + Arrays.toString(this.f10401a) + ')';
    }

    @Override // java.util.Collection
    public final <T> T[] toArray(T[] array) {
        kotlin.jvm.internal.g.f(array, "array");
        return (T[]) kotlin.jvm.internal.d.b(this, array);
    }
}
