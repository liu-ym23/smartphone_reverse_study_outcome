package lb;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class m implements Collection<l>, ac.a {

    /* renamed from: a, reason: collision with root package name */
    public final short[] f10410a;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a implements Iterator<l>, ac.a {

        /* renamed from: a, reason: collision with root package name */
        public final short[] f10411a;

        /* renamed from: b, reason: collision with root package name */
        public int f10412b;

        public a(short[] sArr) {
            this.f10411a = sArr;
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.f10412b < this.f10411a.length;
        }

        @Override // java.util.Iterator
        public final l next() {
            int i10 = this.f10412b;
            short[] sArr = this.f10411a;
            if (i10 >= sArr.length) {
                throw new NoSuchElementException(String.valueOf(this.f10412b));
            }
            this.f10412b = i10 + 1;
            return new l(sArr[i10]);
        }

        @Override // java.util.Iterator
        public final void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    @Override // java.util.Collection
    public final /* bridge */ /* synthetic */ boolean add(l lVar) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final boolean addAll(Collection<? extends l> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final boolean contains(Object obj) {
        if (!(obj instanceof l)) {
            return false;
        }
        short s8 = ((l) obj).f10409a;
        short[] sArr = this.f10410a;
        int length = sArr.length;
        int i10 = 0;
        while (true) {
            if (i10 >= length) {
                i10 = -1;
                break;
            }
            if (s8 == sArr[i10]) {
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
                if (obj instanceof l) {
                    short s8 = ((l) obj).f10409a;
                    short[] sArr = this.f10410a;
                    int length = sArr.length;
                    int i10 = 0;
                    while (true) {
                        if (i10 >= length) {
                            i10 = -1;
                            break;
                        }
                        if (s8 == sArr[i10]) {
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
        if (obj instanceof m) {
            return kotlin.jvm.internal.g.b(this.f10410a, ((m) obj).f10410a);
        }
        return false;
    }

    @Override // java.util.Collection
    public final int hashCode() {
        return Arrays.hashCode(this.f10410a);
    }

    @Override // java.util.Collection
    public final boolean isEmpty() {
        return this.f10410a.length == 0;
    }

    @Override // java.util.Collection, java.lang.Iterable
    public final Iterator<l> iterator() {
        return new a(this.f10410a);
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
        return this.f10410a.length;
    }

    @Override // java.util.Collection
    public final Object[] toArray() {
        return kotlin.jvm.internal.d.a(this);
    }

    public final String toString() {
        return "UShortArray(storage=" + Arrays.toString(this.f10410a) + ')';
    }

    @Override // java.util.Collection
    public final <T> T[] toArray(T[] array) {
        kotlin.jvm.internal.g.f(array, "array");
        return (T[]) kotlin.jvm.internal.d.b(this, array);
    }
}
