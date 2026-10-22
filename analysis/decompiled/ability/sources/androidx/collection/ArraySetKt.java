package androidx.collection;

import D7.q;
import D7.v;
import androidx.appfunctions.metadata.a;
import androidx.collection.internal.ContainerHelpersKt;
import androidx.exifinterface.media.ExifInterface;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\b\u0007\u001a\u001c\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000H\u0086\b¢\u0006\u0004\b\u0002\u0010\u0003\u001a-\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u00002\u0012\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0004\"\u00028\u0000¢\u0006\u0004\b\u0002\u0010\u0006\u001a'\u0010\n\u001a\u00020\b\"\u0004\b\u0000\u0010\u0007*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\t\u001a\u00020\bH\u0000¢\u0006\u0004\b\n\u0010\u000b\u001a1\u0010\u000e\u001a\u00020\b\"\u0004\b\u0000\u0010\u0007*\b\u0012\u0004\u0012\u00028\u00000\u00012\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\t\u001a\u00020\bH\u0000¢\u0006\u0004\b\u000e\u0010\u000f\u001a\u001f\u0010\u0010\u001a\u00020\b\"\u0004\b\u0000\u0010\u0007*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0000¢\u0006\u0004\b\u0010\u0010\u0011\u001a'\u0010\u0014\u001a\u00020\u0013\"\u0004\b\u0000\u0010\u0007*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0012\u001a\u00020\bH\u0000¢\u0006\u0004\b\u0014\u0010\u0015\u001a \u0010\u0016\u001a\u00020\u0013\"\u0004\b\u0000\u0010\u0007*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0080\b¢\u0006\u0004\b\u0016\u0010\u0017\u001a(\u0010\u0019\u001a\u00020\u0013\"\u0004\b\u0000\u0010\u0007*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0018\u001a\u00020\bH\u0080\b¢\u0006\u0004\b\u0019\u0010\u0015\u001a(\u0010\u001c\u001a\u00020\u001b\"\u0004\b\u0000\u0010\u0007*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u001a\u001a\u00028\u0000H\u0080\b¢\u0006\u0004\b\u001c\u0010\u001d\u001a*\u0010\u001e\u001a\u00020\b\"\u0004\b\u0000\u0010\u0007*\b\u0012\u0004\u0012\u00028\u00000\u00012\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0080\b¢\u0006\u0004\b\u001e\u0010\u001f\u001a(\u0010!\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0007*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010 \u001a\u00020\bH\u0080\b¢\u0006\u0004\b!\u0010\"\u001a \u0010#\u001a\u00020\u001b\"\u0004\b\u0000\u0010\u0007*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0080\b¢\u0006\u0004\b#\u0010$\u001a(\u0010%\u001a\u00020\u001b\"\u0004\b\u0000\u0010\u0007*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u001a\u001a\u00028\u0000H\u0080\b¢\u0006\u0004\b%\u0010\u001d\u001a0\u0010'\u001a\u00020\u0013\"\u0004\b\u0000\u0010\u0007*\b\u0012\u0004\u0012\u00028\u00000\u00012\u000e\u0010&\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0001H\u0080\b¢\u0006\u0004\b'\u0010(\u001a(\u0010)\u001a\u00020\u001b\"\u0004\b\u0000\u0010\u0007*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u001a\u001a\u00028\u0000H\u0080\b¢\u0006\u0004\b)\u0010\u001d\u001a(\u0010*\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0007*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010 \u001a\u00020\bH\u0080\b¢\u0006\u0004\b*\u0010\"\u001a0\u0010+\u001a\u00020\u001b\"\u0004\b\u0000\u0010\u0007*\b\u0012\u0004\u0012\u00028\u00000\u00012\u000e\u0010&\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0001H\u0080\b¢\u0006\u0004\b+\u0010,\u001a*\u0010.\u001a\u00020\u001b\"\u0004\b\u0000\u0010\u0007*\b\u0012\u0004\u0012\u00028\u00000\u00012\b\u0010-\u001a\u0004\u0018\u00010\fH\u0080\b¢\u0006\u0004\b.\u0010\u001d\u001a \u0010/\u001a\u00020\b\"\u0004\b\u0000\u0010\u0007*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0080\b¢\u0006\u0004\b/\u0010\u0011\u001a \u00101\u001a\u000200\"\u0004\b\u0000\u0010\u0007*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0080\b¢\u0006\u0004\b1\u00102\u001a.\u00105\u001a\u00020\u001b\"\u0004\b\u0000\u0010\u0007*\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u00104\u001a\b\u0012\u0004\u0012\u00028\u000003H\u0080\b¢\u0006\u0004\b5\u00106\u001a.\u0010'\u001a\u00020\u001b\"\u0004\b\u0000\u0010\u0007*\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u00104\u001a\b\u0012\u0004\u0012\u00028\u000003H\u0080\b¢\u0006\u0004\b'\u00106\u001a.\u0010+\u001a\u00020\u001b\"\u0004\b\u0000\u0010\u0007*\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u00104\u001a\b\u0012\u0004\u0012\u00028\u000003H\u0080\b¢\u0006\u0004\b+\u00106\u001a.\u00107\u001a\u00020\u001b\"\u0004\b\u0000\u0010\u0007*\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u00104\u001a\b\u0012\u0004\u0012\u00028\u000003H\u0080\b¢\u0006\u0004\b7\u00106\"\u0014\u00108\u001a\u00020\b8\u0000X\u0080T¢\u0006\u0006\n\u0004\b8\u00109¨\u0006:"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/collection/ArraySet;", "arraySetOf", "()Landroidx/collection/ArraySet;", "", "values", "([Ljava/lang/Object;)Landroidx/collection/ArraySet;", ExifInterface.LONGITUDE_EAST, "", "hash", "binarySearchInternal", "(Landroidx/collection/ArraySet;I)I", "", "key", "indexOf", "(Landroidx/collection/ArraySet;Ljava/lang/Object;I)I", "indexOfNull", "(Landroidx/collection/ArraySet;)I", "size", "LC7/r;", "allocArrays", "(Landroidx/collection/ArraySet;I)V", "clearInternal", "(Landroidx/collection/ArraySet;)V", "minimumCapacity", "ensureCapacityInternal", "element", "", "containsInternal", "(Landroidx/collection/ArraySet;Ljava/lang/Object;)Z", "indexOfInternal", "(Landroidx/collection/ArraySet;Ljava/lang/Object;)I", "index", "valueAtInternal", "(Landroidx/collection/ArraySet;I)Ljava/lang/Object;", "isEmptyInternal", "(Landroidx/collection/ArraySet;)Z", "addInternal", "array", "addAllInternal", "(Landroidx/collection/ArraySet;Landroidx/collection/ArraySet;)V", "removeInternal", "removeAtInternal", "removeAllInternal", "(Landroidx/collection/ArraySet;Landroidx/collection/ArraySet;)Z", "other", "equalsInternal", "hashCodeInternal", "", "toStringInternal", "(Landroidx/collection/ArraySet;)Ljava/lang/String;", "", "elements", "containsAllInternal", "(Landroidx/collection/ArraySet;Ljava/util/Collection;)Z", "retainAllInternal", "ARRAY_SET_BASE_SIZE", "I", "collection"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ArraySetKt {
    public static final int ARRAY_SET_BASE_SIZE = 4;

    public static final <E> void addAllInternal(ArraySet<E> arraySet, ArraySet<? extends E> array) {
        k.f(arraySet, "<this>");
        k.f(array, "array");
        int i = array.get_size$collection();
        arraySet.ensureCapacity(arraySet.get_size$collection() + i);
        if (arraySet.get_size$collection() != 0) {
            for (int i6 = 0; i6 < i; i6++) {
                arraySet.add(array.valueAt(i6));
            }
        } else if (i > 0) {
            q.Y(0, i, array.getHashes(), arraySet.getHashes(), 6);
            q.b0(array.getArray(), arraySet.getArray(), 0, 0, i, 6);
            if (arraySet.get_size$collection() != 0) {
                throw new ConcurrentModificationException();
            }
            arraySet.set_size$collection(i);
        }
    }

    public static final <E> boolean addInternal(ArraySet<E> arraySet, E e) {
        int i;
        int iIndexOf;
        k.f(arraySet, "<this>");
        int i6 = arraySet.get_size$collection();
        if (e == null) {
            iIndexOf = indexOfNull(arraySet);
            i = 0;
        } else {
            int iHashCode = e.hashCode();
            i = iHashCode;
            iIndexOf = indexOf(arraySet, e, iHashCode);
        }
        if (iIndexOf >= 0) {
            return false;
        }
        int i10 = ~iIndexOf;
        if (i6 >= arraySet.getHashes().length) {
            int i11 = 8;
            if (i6 >= 8) {
                i11 = (i6 >> 1) + i6;
            } else if (i6 < 4) {
                i11 = 4;
            }
            int[] hashes = arraySet.getHashes();
            Object[] array = arraySet.getArray();
            allocArrays(arraySet, i11);
            if (i6 != arraySet.get_size$collection()) {
                throw new ConcurrentModificationException();
            }
            if (arraySet.getHashes().length != 0) {
                q.Y(0, hashes.length, hashes, arraySet.getHashes(), 6);
                q.b0(array, arraySet.getArray(), 0, 0, array.length, 6);
            }
        }
        if (i10 < i6) {
            int i12 = i10 + 1;
            q.R(i12, i10, arraySet.getHashes(), arraySet.getHashes(), i6);
            q.X(arraySet.getArray(), arraySet.getArray(), i12, i10, i6);
        }
        if (i6 != arraySet.get_size$collection() || i10 >= arraySet.getHashes().length) {
            throw new ConcurrentModificationException();
        }
        arraySet.getHashes()[i10] = i;
        arraySet.getArray()[i10] = e;
        arraySet.set_size$collection(arraySet.get_size$collection() + 1);
        return true;
    }

    public static final <E> void allocArrays(ArraySet<E> arraySet, int i) {
        k.f(arraySet, "<this>");
        arraySet.setHashes$collection(new int[i]);
        arraySet.setArray$collection(new Object[i]);
    }

    public static final <T> ArraySet<T> arraySetOf() {
        return new ArraySet<>(0, 1, null);
    }

    public static final <E> int binarySearchInternal(ArraySet<E> arraySet, int i) {
        k.f(arraySet, "<this>");
        try {
            return ContainerHelpersKt.binarySearch(arraySet.getHashes(), arraySet.get_size$collection(), i);
        } catch (IndexOutOfBoundsException unused) {
            throw new ConcurrentModificationException();
        }
    }

    public static final <E> void clearInternal(ArraySet<E> arraySet) {
        k.f(arraySet, "<this>");
        if (arraySet.get_size$collection() != 0) {
            arraySet.setHashes$collection(ContainerHelpersKt.EMPTY_INTS);
            arraySet.setArray$collection(ContainerHelpersKt.EMPTY_OBJECTS);
            arraySet.set_size$collection(0);
        }
        if (arraySet.get_size$collection() != 0) {
            throw new ConcurrentModificationException();
        }
    }

    public static final <E> boolean containsAllInternal(ArraySet<E> arraySet, Collection<? extends E> elements) {
        k.f(arraySet, "<this>");
        k.f(elements, "elements");
        Iterator<? extends E> it = elements.iterator();
        while (it.hasNext()) {
            if (!arraySet.contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    public static final <E> boolean containsInternal(ArraySet<E> arraySet, E e) {
        k.f(arraySet, "<this>");
        return arraySet.indexOf(e) >= 0;
    }

    public static final <E> void ensureCapacityInternal(ArraySet<E> arraySet, int i) {
        k.f(arraySet, "<this>");
        int i6 = arraySet.get_size$collection();
        if (arraySet.getHashes().length < i) {
            int[] hashes = arraySet.getHashes();
            Object[] array = arraySet.getArray();
            allocArrays(arraySet, i);
            if (arraySet.get_size$collection() > 0) {
                q.Y(0, arraySet.get_size$collection(), hashes, arraySet.getHashes(), 6);
                q.b0(array, arraySet.getArray(), 0, 0, arraySet.get_size$collection(), 6);
            }
        }
        if (arraySet.get_size$collection() != i6) {
            throw new ConcurrentModificationException();
        }
    }

    public static final <E> boolean equalsInternal(ArraySet<E> arraySet, Object obj) {
        k.f(arraySet, "<this>");
        if (arraySet == obj) {
            return true;
        }
        if (!(obj instanceof Set) || arraySet.size() != ((Set) obj).size()) {
            return false;
        }
        try {
            int i = arraySet.get_size$collection();
            for (int i6 = 0; i6 < i; i6++) {
                if (!((Set) obj).contains(arraySet.valueAt(i6))) {
                    return false;
                }
            }
            return true;
        } catch (ClassCastException | NullPointerException unused) {
            return false;
        }
    }

    public static final <E> int hashCodeInternal(ArraySet<E> arraySet) {
        k.f(arraySet, "<this>");
        int[] hashes = arraySet.getHashes();
        int i = arraySet.get_size$collection();
        int i6 = 0;
        for (int i10 = 0; i10 < i; i10++) {
            i6 += hashes[i10];
        }
        return i6;
    }

    public static final <E> int indexOf(ArraySet<E> arraySet, Object obj, int i) {
        k.f(arraySet, "<this>");
        int i6 = arraySet.get_size$collection();
        if (i6 == 0) {
            return -1;
        }
        int iBinarySearchInternal = binarySearchInternal(arraySet, i);
        if (iBinarySearchInternal < 0 || k.b(obj, arraySet.getArray()[iBinarySearchInternal])) {
            return iBinarySearchInternal;
        }
        int i10 = iBinarySearchInternal + 1;
        while (i10 < i6 && arraySet.getHashes()[i10] == i) {
            if (k.b(obj, arraySet.getArray()[i10])) {
                return i10;
            }
            i10++;
        }
        for (int i11 = iBinarySearchInternal - 1; i11 >= 0 && arraySet.getHashes()[i11] == i; i11--) {
            if (k.b(obj, arraySet.getArray()[i11])) {
                return i11;
            }
        }
        return ~i10;
    }

    public static final <E> int indexOfInternal(ArraySet<E> arraySet, Object obj) {
        k.f(arraySet, "<this>");
        return obj == null ? indexOfNull(arraySet) : indexOf(arraySet, obj, obj.hashCode());
    }

    public static final <E> int indexOfNull(ArraySet<E> arraySet) {
        k.f(arraySet, "<this>");
        return indexOf(arraySet, null, 0);
    }

    public static final <E> boolean isEmptyInternal(ArraySet<E> arraySet) {
        k.f(arraySet, "<this>");
        return arraySet.get_size$collection() <= 0;
    }

    public static final <E> boolean removeAllInternal(ArraySet<E> arraySet, ArraySet<? extends E> array) {
        k.f(arraySet, "<this>");
        k.f(array, "array");
        int i = array.get_size$collection();
        int i6 = arraySet.get_size$collection();
        for (int i10 = 0; i10 < i; i10++) {
            arraySet.remove(array.valueAt(i10));
        }
        return i6 != arraySet.get_size$collection();
    }

    public static final <E> E removeAtInternal(ArraySet<E> arraySet, int i) {
        int i6;
        k.f(arraySet, "<this>");
        int i10 = arraySet.get_size$collection();
        E e = (E) arraySet.getArray()[i];
        if (i10 <= 1) {
            arraySet.clear();
            return e;
        }
        int i11 = i10 - 1;
        if (arraySet.getHashes().length <= 8 || arraySet.get_size$collection() >= arraySet.getHashes().length / 3) {
            if (i < i11) {
                int i12 = i + 1;
                q.R(i, i12, arraySet.getHashes(), arraySet.getHashes(), i10);
                q.X(arraySet.getArray(), arraySet.getArray(), i, i12, i10);
            }
            arraySet.getArray()[i11] = null;
        } else {
            int i13 = arraySet.get_size$collection() > 8 ? arraySet.get_size$collection() + (arraySet.get_size$collection() >> 1) : 8;
            int[] hashes = arraySet.getHashes();
            Object[] array = arraySet.getArray();
            allocArrays(arraySet, i13);
            if (i > 0) {
                q.Y(0, i, hashes, arraySet.getHashes(), 6);
                i6 = i;
                q.b0(array, arraySet.getArray(), 0, 0, i6, 6);
            } else {
                i6 = i;
            }
            if (i6 < i11) {
                int i14 = i6 + 1;
                q.R(i6, i14, hashes, arraySet.getHashes(), i10);
                q.X(array, arraySet.getArray(), i6, i14, i10);
            }
        }
        if (i10 != arraySet.get_size$collection()) {
            throw new ConcurrentModificationException();
        }
        arraySet.set_size$collection(i11);
        return e;
    }

    public static final <E> boolean removeInternal(ArraySet<E> arraySet, E e) {
        k.f(arraySet, "<this>");
        int iIndexOf = arraySet.indexOf(e);
        if (iIndexOf < 0) {
            return false;
        }
        arraySet.removeAt(iIndexOf);
        return true;
    }

    public static final <E> boolean retainAllInternal(ArraySet<E> arraySet, Collection<? extends E> elements) {
        k.f(arraySet, "<this>");
        k.f(elements, "elements");
        boolean z10 = false;
        for (int i = arraySet.get_size$collection() - 1; -1 < i; i--) {
            if (!v.u0(elements, arraySet.getArray()[i])) {
                arraySet.removeAt(i);
                z10 = true;
            }
        }
        return z10;
    }

    public static final <E> String toStringInternal(ArraySet<E> arraySet) {
        k.f(arraySet, "<this>");
        if (arraySet.isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(arraySet.get_size$collection() * 14);
        sb.append('{');
        int i = arraySet.get_size$collection();
        for (int i6 = 0; i6 < i; i6++) {
            if (i6 > 0) {
                sb.append(", ");
            }
            E eValueAt = arraySet.valueAt(i6);
            if (eValueAt != arraySet) {
                sb.append(eValueAt);
            } else {
                sb.append("(this Set)");
            }
        }
        return a.h('}', "toString(...)", sb);
    }

    public static final <E> E valueAtInternal(ArraySet<E> arraySet, int i) {
        k.f(arraySet, "<this>");
        return (E) arraySet.getArray()[i];
    }

    public static final <T> ArraySet<T> arraySetOf(T... values) {
        k.f(values, "values");
        ArraySet<T> arraySet = new ArraySet<>(values.length);
        for (T t9 : values) {
            arraySet.add(t9);
        }
        return arraySet;
    }

    public static final <E> boolean removeAllInternal(ArraySet<E> arraySet, Collection<? extends E> elements) {
        k.f(arraySet, "<this>");
        k.f(elements, "elements");
        Iterator<? extends E> it = elements.iterator();
        boolean zRemove = false;
        while (it.hasNext()) {
            zRemove |= arraySet.remove(it.next());
        }
        return zRemove;
    }

    public static final <E> boolean addAllInternal(ArraySet<E> arraySet, Collection<? extends E> elements) {
        k.f(arraySet, "<this>");
        k.f(elements, "elements");
        arraySet.ensureCapacity(elements.size() + arraySet.get_size$collection());
        Iterator<? extends E> it = elements.iterator();
        boolean zAdd = false;
        while (it.hasNext()) {
            zAdd |= arraySet.add(it.next());
        }
        return zAdd;
    }
}
