package lb;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class j implements Collection<i>, ac.a {

    /* renamed from: a, reason: collision with root package name */
    public final long[] f10405a;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a implements Iterator<i>, ac.a {

        /* renamed from: a, reason: collision with root package name */
        public final long[] f10406a;

        /* renamed from: b, reason: collision with root package name */
        public int f10407b;

        public a(long[] jArr) {
            this.f10406a = jArr;
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.f10407b < this.f10406a.length;
        }

        @Override // java.util.Iterator
        public final i next() {
            int i10 = this.f10407b;
            long[] jArr = this.f10406a;
            if (i10 >= jArr.length) {
                throw new NoSuchElementException(String.valueOf(this.f10407b));
            }
            this.f10407b = i10 + 1;
            return new i(jArr[i10]);
        }

        @Override // java.util.Iterator
        public final void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    @Override // java.util.Collection
    public final /* bridge */ /* synthetic */ boolean add(i iVar) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final boolean addAll(Collection<? extends i> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final boolean contains(Object obj) {
        if (!(obj instanceof i)) {
            return false;
        }
        long j10 = ((i) obj).f10404a;
        long[] jArr = this.f10405a;
        int length = jArr.length;
        int i10 = 0;
        while (true) {
            if (i10 >= length) {
                i10 = -1;
                break;
            }
            if (j10 == jArr[i10]) {
                break;
            }
            i10++;
        }
        return i10 >= 0;
    }

    @Override // java.util.Collection
    public final boolean containsAll(Collection<? extends Object> elements) {
        kotlin.jvm.internal.g.f(elements, "elements");
        Collection<? extends Object> collection = elements;
        if (!collection.isEmpty()) {
            for (Object obj : collection) {
                if (obj instanceof i) {
                    long j10 = ((i) obj).f10404a;
                    long[] jArr = this.f10405a;
                    int length = jArr.length;
                    int i10 = 0;
                    while (true) {
                        if (i10 >= length) {
                            i10 = -1;
                            break;
                        }
                        if (j10 == jArr[i10]) {
                            break;
                        }
                        i10++;
                    }
                    if (i10 >= 0) {
                    }
                }
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Collection
    public final boolean equals(Object obj) {
        if (obj instanceof j) {
            return kotlin.jvm.internal.g.b(this.f10405a, ((j) obj).f10405a);
        }
        return false;
    }

    @Override // java.util.Collection
    public final int hashCode() {
        return Arrays.hashCode(this.f10405a);
    }

    @Override // java.util.Collection
    public final boolean isEmpty() {
        return this.f10405a.length == 0;
    }

    @Override // java.util.Collection, java.lang.Iterable
    public final Iterator<i> iterator() {
        return new a(this.f10405a);
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
        return this.f10405a.length;
    }

    @Override // java.util.Collection
    public final Object[] toArray() {
        return kotlin.jvm.internal.d.a(this);
    }

    public final String toString() {
        return "ULongArray(storage=" + Arrays.toString(this.f10405a) + ')';
    }

    @Override // java.util.Collection
    public final <T> T[] toArray(T[] array) {
        kotlin.jvm.internal.g.f(array, "array");
        return (T[]) kotlin.jvm.internal.d.b(this, array);
    }
}
