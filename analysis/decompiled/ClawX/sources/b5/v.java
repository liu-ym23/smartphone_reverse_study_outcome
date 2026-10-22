package b5;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class v implements Collection, q5.a {

    /* renamed from: a, reason: collision with root package name */
    public final long[] f916a;

    @Override // java.util.Collection
    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final boolean addAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final boolean contains(Object obj) {
        if (!(obj instanceof u)) {
            return false;
        }
        long j4 = ((u) obj).f915a;
        long[] jArr = this.f916a;
        kotlin.jvm.internal.p.e(jArr, "<this>");
        int length = jArr.length;
        int i8 = 0;
        while (true) {
            if (i8 >= length) {
                i8 = -1;
                break;
            }
            if (j4 == jArr[i8]) {
                break;
            }
            i8++;
        }
        return i8 >= 0;
    }

    @Override // java.util.Collection
    public final boolean containsAll(Collection elements) {
        kotlin.jvm.internal.p.e(elements, "elements");
        if (!elements.isEmpty()) {
            for (Object obj : elements) {
                if (obj instanceof u) {
                    long j4 = ((u) obj).f915a;
                    long[] jArr = this.f916a;
                    kotlin.jvm.internal.p.e(jArr, "<this>");
                    int length = jArr.length;
                    int i8 = 0;
                    while (true) {
                        if (i8 >= length) {
                            i8 = -1;
                            break;
                        }
                        if (j4 == jArr[i8]) {
                            break;
                        }
                        i8++;
                    }
                    if (i8 >= 0) {
                    }
                }
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Collection
    public final boolean equals(Object obj) {
        if (obj instanceof v) {
            return kotlin.jvm.internal.p.a(this.f916a, ((v) obj).f916a);
        }
        return false;
    }

    @Override // java.util.Collection
    public final int hashCode() {
        return Arrays.hashCode(this.f916a);
    }

    @Override // java.util.Collection
    public final boolean isEmpty() {
        return this.f916a.length == 0;
    }

    @Override // java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        return new o(this.f916a);
    }

    @Override // java.util.Collection
    public final boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final boolean removeAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final boolean retainAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final int size() {
        return this.f916a.length;
    }

    @Override // java.util.Collection
    public final Object[] toArray() {
        return kotlin.jvm.internal.p.m(this);
    }

    public final String toString() {
        return "ULongArray(storage=" + Arrays.toString(this.f916a) + ')';
    }

    @Override // java.util.Collection
    public final Object[] toArray(Object[] array) {
        kotlin.jvm.internal.p.e(array, "array");
        return kotlin.jvm.internal.p.n(this, array);
    }
}
