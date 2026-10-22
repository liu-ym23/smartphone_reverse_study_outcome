package lb;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class f implements Collection<e>, ac.a {

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f10397a;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a implements Iterator<e>, ac.a {

        /* renamed from: a, reason: collision with root package name */
        public final byte[] f10398a;

        /* renamed from: b, reason: collision with root package name */
        public int f10399b;

        public a(byte[] bArr) {
            this.f10398a = bArr;
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.f10399b < this.f10398a.length;
        }

        @Override // java.util.Iterator
        public final e next() {
            int i10 = this.f10399b;
            byte[] bArr = this.f10398a;
            if (i10 >= bArr.length) {
                throw new NoSuchElementException(String.valueOf(this.f10399b));
            }
            this.f10399b = i10 + 1;
            return new e(bArr[i10]);
        }

        @Override // java.util.Iterator
        public final void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    @Override // java.util.Collection
    public final /* bridge */ /* synthetic */ boolean add(e eVar) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final boolean addAll(Collection<? extends e> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final boolean contains(Object obj) {
        if (!(obj instanceof e)) {
            return false;
        }
        byte b10 = ((e) obj).f10396a;
        byte[] bArr = this.f10397a;
        int length = bArr.length;
        int i10 = 0;
        while (true) {
            if (i10 >= length) {
                i10 = -1;
                break;
            }
            if (b10 == bArr[i10]) {
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
                if (obj instanceof e) {
                    byte b10 = ((e) obj).f10396a;
                    byte[] bArr = this.f10397a;
                    int length = bArr.length;
                    int i10 = 0;
                    while (true) {
                        if (i10 >= length) {
                            i10 = -1;
                            break;
                        }
                        if (b10 == bArr[i10]) {
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
        if (obj instanceof f) {
            return kotlin.jvm.internal.g.b(this.f10397a, ((f) obj).f10397a);
        }
        return false;
    }

    @Override // java.util.Collection
    public final int hashCode() {
        return Arrays.hashCode(this.f10397a);
    }

    @Override // java.util.Collection
    public final boolean isEmpty() {
        return this.f10397a.length == 0;
    }

    @Override // java.util.Collection, java.lang.Iterable
    public final Iterator<e> iterator() {
        return new a(this.f10397a);
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
        return this.f10397a.length;
    }

    @Override // java.util.Collection
    public final Object[] toArray() {
        return kotlin.jvm.internal.d.a(this);
    }

    public final String toString() {
        return "UByteArray(storage=" + Arrays.toString(this.f10397a) + ')';
    }

    @Override // java.util.Collection
    public final <T> T[] toArray(T[] array) {
        kotlin.jvm.internal.g.f(array, "array");
        return (T[]) kotlin.jvm.internal.d.b(this, array);
    }
}
