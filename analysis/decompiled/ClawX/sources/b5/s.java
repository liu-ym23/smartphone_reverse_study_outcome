package b5;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class s implements Collection, q5.a {

    /* renamed from: a, reason: collision with root package name */
    public final int[] f913a;

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
        if (!(obj instanceof r)) {
            return false;
        }
        int i8 = ((r) obj).f912a;
        int[] iArr = this.f913a;
        kotlin.jvm.internal.p.e(iArr, "<this>");
        int length = iArr.length;
        int i9 = 0;
        while (true) {
            if (i9 >= length) {
                i9 = -1;
                break;
            }
            if (i8 == iArr[i9]) {
                break;
            }
            i9++;
        }
        return i9 >= 0;
    }

    @Override // java.util.Collection
    public final boolean containsAll(Collection elements) {
        kotlin.jvm.internal.p.e(elements, "elements");
        if (!elements.isEmpty()) {
            for (Object obj : elements) {
                if (obj instanceof r) {
                    int i8 = ((r) obj).f912a;
                    int[] iArr = this.f913a;
                    kotlin.jvm.internal.p.e(iArr, "<this>");
                    int length = iArr.length;
                    int i9 = 0;
                    while (true) {
                        if (i9 >= length) {
                            i9 = -1;
                            break;
                        }
                        if (i8 == iArr[i9]) {
                            break;
                        }
                        i9++;
                    }
                    if (i9 >= 0) {
                    }
                }
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Collection
    public final boolean equals(Object obj) {
        if (obj instanceof s) {
            return kotlin.jvm.internal.p.a(this.f913a, ((s) obj).f913a);
        }
        return false;
    }

    @Override // java.util.Collection
    public final int hashCode() {
        return Arrays.hashCode(this.f913a);
    }

    @Override // java.util.Collection
    public final boolean isEmpty() {
        return this.f913a.length == 0;
    }

    @Override // java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        return new o(this.f913a);
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
        return this.f913a.length;
    }

    @Override // java.util.Collection
    public final Object[] toArray() {
        return kotlin.jvm.internal.p.m(this);
    }

    public final String toString() {
        return "UIntArray(storage=" + Arrays.toString(this.f913a) + ')';
    }

    @Override // java.util.Collection
    public final Object[] toArray(Object[] array) {
        kotlin.jvm.internal.p.e(array, "array");
        return kotlin.jvm.internal.p.n(this, array);
    }
}
