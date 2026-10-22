package androidx.collection;

import androidx.collection.internal.ContainerHelpersKt;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.android.ec.slice.SliceInitService;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import faceverify.w;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\b\u0002\u001a\u0015\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002H\u0086\b\u001a+\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0012\u0010\u0003\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0004\"\u0002H\u0002¢\u0006\u0002\u0010\u0005\u001a \u0010\b\u001a\u00020\u0007\"\u0004\b\u0000\u0010\t*\b\u0012\u0004\u0012\u0002H\t0\u00012\u0006\u0010\n\u001a\u00020\u0007H\u0000\u001a*\u0010\u000b\u001a\u00020\u0007\"\u0004\b\u0000\u0010\t*\b\u0012\u0004\u0012\u0002H\t0\u00012\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\n\u001a\u00020\u0007H\u0000\u001a\u0018\u0010\u000e\u001a\u00020\u0007\"\u0004\b\u0000\u0010\t*\b\u0012\u0004\u0012\u0002H\t0\u0001H\u0000\u001a \u0010\u000f\u001a\u00020\u0010\"\u0004\b\u0000\u0010\t*\b\u0012\u0004\u0012\u0002H\t0\u00012\u0006\u0010\u0011\u001a\u00020\u0007H\u0000\u001a\u0019\u0010\u0012\u001a\u00020\u0010\"\u0004\b\u0000\u0010\t*\b\u0012\u0004\u0012\u0002H\t0\u0001H\u0080\b\u001a!\u0010\u0013\u001a\u00020\u0010\"\u0004\b\u0000\u0010\t*\b\u0012\u0004\u0012\u0002H\t0\u00012\u0006\u0010\u0014\u001a\u00020\u0007H\u0080\b\u001a&\u0010\u0015\u001a\u00020\u0016\"\u0004\b\u0000\u0010\t*\b\u0012\u0004\u0012\u0002H\t0\u00012\u0006\u0010\u0017\u001a\u0002H\tH\u0080\b¢\u0006\u0002\u0010\u0018\u001a#\u0010\u0019\u001a\u00020\u0007\"\u0004\b\u0000\u0010\t*\b\u0012\u0004\u0012\u0002H\t0\u00012\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0080\b\u001a&\u0010\u001a\u001a\u0002H\t\"\u0004\b\u0000\u0010\t*\b\u0012\u0004\u0012\u0002H\t0\u00012\u0006\u0010\u001b\u001a\u00020\u0007H\u0080\b¢\u0006\u0002\u0010\u001c\u001a\u0019\u0010\u001d\u001a\u00020\u0016\"\u0004\b\u0000\u0010\t*\b\u0012\u0004\u0012\u0002H\t0\u0001H\u0080\b\u001a&\u0010\u001e\u001a\u00020\u0016\"\u0004\b\u0000\u0010\t*\b\u0012\u0004\u0012\u0002H\t0\u00012\u0006\u0010\u0017\u001a\u0002H\tH\u0080\b¢\u0006\u0002\u0010\u0018\u001a)\u0010\u001f\u001a\u00020\u0010\"\u0004\b\u0000\u0010\t*\b\u0012\u0004\u0012\u0002H\t0\u00012\u000e\u0010 \u001a\n\u0012\u0006\b\u0001\u0012\u0002H\t0\u0001H\u0080\b\u001a&\u0010!\u001a\u00020\u0016\"\u0004\b\u0000\u0010\t*\b\u0012\u0004\u0012\u0002H\t0\u00012\u0006\u0010\u0017\u001a\u0002H\tH\u0080\b¢\u0006\u0002\u0010\u0018\u001a&\u0010\"\u001a\u0002H\t\"\u0004\b\u0000\u0010\t*\b\u0012\u0004\u0012\u0002H\t0\u00012\u0006\u0010\u001b\u001a\u00020\u0007H\u0080\b¢\u0006\u0002\u0010\u001c\u001a)\u0010#\u001a\u00020\u0016\"\u0004\b\u0000\u0010\t*\b\u0012\u0004\u0012\u0002H\t0\u00012\u000e\u0010 \u001a\n\u0012\u0006\b\u0001\u0012\u0002H\t0\u0001H\u0080\b\u001a#\u0010$\u001a\u00020\u0016\"\u0004\b\u0000\u0010\t*\b\u0012\u0004\u0012\u0002H\t0\u00012\b\u0010%\u001a\u0004\u0018\u00010\rH\u0080\b\u001a\u0019\u0010&\u001a\u00020\u0007\"\u0004\b\u0000\u0010\t*\b\u0012\u0004\u0012\u0002H\t0\u0001H\u0080\b\u001a\u0019\u0010'\u001a\u00020(\"\u0004\b\u0000\u0010\t*\b\u0012\u0004\u0012\u0002H\t0\u0001H\u0080\b\u001a'\u0010)\u001a\u00020\u0016\"\u0004\b\u0000\u0010\t*\b\u0012\u0004\u0012\u0002H\t0\u00012\f\u0010*\u001a\b\u0012\u0004\u0012\u0002H\t0+H\u0080\b\u001a'\u0010\u001f\u001a\u00020\u0016\"\u0004\b\u0000\u0010\t*\b\u0012\u0004\u0012\u0002H\t0\u00012\f\u0010*\u001a\b\u0012\u0004\u0012\u0002H\t0+H\u0080\b\u001a'\u0010#\u001a\u00020\u0016\"\u0004\b\u0000\u0010\t*\b\u0012\u0004\u0012\u0002H\t0\u00012\f\u0010*\u001a\b\u0012\u0004\u0012\u0002H\t0+H\u0080\b\u001a'\u0010,\u001a\u00020\u0016\"\u0004\b\u0000\u0010\t*\b\u0012\u0004\u0012\u0002H\t0\u00012\f\u0010*\u001a\b\u0012\u0004\u0012\u0002H\t0+H\u0080\b\"\u000e\u0010\u0006\u001a\u00020\u0007X\u0080T¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"arraySetOf", "Landroidx/collection/ArraySet;", ExifInterface.GPS_DIRECTION_TRUE, "values", "", "([Ljava/lang/Object;)Landroidx/collection/ArraySet;", "ARRAY_SET_BASE_SIZE", "", "binarySearchInternal", ExifInterface.LONGITUDE_EAST, w.BLOB_ELEM_IMAGE_HASHCODE, "indexOf", "key", "", "indexOfNull", "allocArrays", "", "size", "clearInternal", "ensureCapacityInternal", "minimumCapacity", "containsInternal", "", "element", "(Landroidx/collection/ArraySet;Ljava/lang/Object;)Z", "indexOfInternal", "valueAtInternal", "index", "(Landroidx/collection/ArraySet;I)Ljava/lang/Object;", "isEmptyInternal", "addInternal", "addAllInternal", "array", "removeInternal", "removeAtInternal", "removeAllInternal", "equalsInternal", "other", "hashCodeInternal", "toStringInternal", "", "containsAllInternal", SlcElement.KEY_ELEMENTS, "", "retainAllInternal", "collection"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class ArraySetKt {
    public static final int ARRAY_SET_BASE_SIZE = 4;

    public static final <T> ArraySet<T> arraySetOf() {
        return new ArraySet(0, 1, null);
    }

    public static final <T> ArraySet<T> arraySetOf(T... r100) {
        Intrinsics.checkNotNullParameter(r100, "values");
        ArraySet<T> r101 = new ArraySet(r100.length);
        int r102 = r100.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L5;
        r101.add(r100[r103]);
        r103 = r103 + 1;
        goto L3
    L5:
        return r101;
    }

    public static final <E> void clearInternal(ArraySet<E> r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r100.get_size$collection() == 0) goto L6;
        r100.setHashes$collection(ContainerHelpersKt.EMPTY_INTS);
        r100.setArray$collection(ContainerHelpersKt.EMPTY_OBJECTS);
        r100.set_size$collection(0);
    L6:
        if (r100.get_size$collection() != 0) goto L9;
        return;
    L9:
        throw new ConcurrentModificationException();
    }

    public static final <E> int hashCodeInternal(ArraySet<E> r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        int[] r101 = r100.getHashes$collection();
        int r102 = r100.get_size$collection();
        int r103 = 0;
        int r104 = 0;
    L3:
        if (r103 >= r102) goto L5;
        r104 = r104 + r101[r103];
        r103 = r103 + 1;
        goto L3
    L5:
        return r104;
    }

    public static final <E> int indexOfNull(ArraySet<E> r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return indexOf(r100, null, 0);
    }

    public static final <E> boolean isEmptyInternal(ArraySet<E> r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r100.get_size$collection() > 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static final <E> String toStringInternal(ArraySet<E> r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r100.isEmpty() == false) goto L6;
        return SliceInitService.DEFAULT_SWITCH;
    L6:
        StringBuilder r101 = new StringBuilder(r100.get_size$collection() * 14);
        r101.append('{');
        int r102 = r100.get_size$collection();
        int r103 = 0;
    L7:
        if (r103 >= r102) goto L15;
        if (r103 <= 0) goto L10;
        r101.append(", ");
    L10:
        E r104 = r100.valueAt(r103);
        if (r104 == r100) goto L13;
        r101.append(r104);
    L14:
        r103 = r103 + 1;
        goto L7
    L13:
        r101.append("(this Set)");
        goto L14
    L15:
        r101.append('}');
        return r101.toString();
    }

    public static final <E> void addAllInternal(ArraySet<E> r100, ArraySet<? extends E> r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "array");
        int r102 = r101.get_size$collection();
        r100.ensureCapacity(r100.get_size$collection() + r102);
        if (r100.get_size$collection() != 0) goto L10;
        if (r102 <= 0) goto L13;
        ArraysKt.copyInto$default(r101.getHashes$collection(), r100.getHashes$collection(), 0, 0, r102, 6, null);
        ArraysKt.copyInto$default(r101.getArray$collection(), r100.getArray$collection(), 0, 0, r102, 6, null);
        if (r100.get_size$collection() != 0) goto L9;
        r100.set_size$collection(r102);
        return;
    L9:
        throw new ConcurrentModificationException();
    L13:
        return;
    L10:
        int r103 = 0;
    L11:
        if (r103 >= r102) goto L16;
        r100.add(r101.valueAt(r103));
        r103 = r103 + 1;
        goto L11
    }

    public static final <E> boolean addInternal(ArraySet<E> r110, E r111) {
        Intrinsics.checkNotNullParameter(r110, "<this>");
        int r100 = r110.get_size$collection();
        boolean r101 = false;
        if (r111 != null) goto L5;
        int r102 = indexOfNull(r110);
        int r103 = 0;
    L6:
        if (r102 < 0) goto L8;
        return false;
    L8:
        int r104 = ~r102;
        if (r100 < r110.getHashes$collection().length) goto L27;
        int r105 = 8;
        if (r100 < 8) goto L14;
        r105 = (r100 >> 1) + r100;
    L17:
        int[] r106 = r110.getHashes$collection();
        Object[] r112 = r110.getArray$collection();
        allocArrays(r110, r105);
        if (r100 != r110.get_size$collection()) goto L26;
        if (r110.getHashes$collection().length != 0) goto L23;
        r101 = true;
    L23:
        if ((!r101) == false) goto L27;
        ArraysKt.copyInto$default(r106, r110.getHashes$collection(), 0, 0, r106.length, 6, null);
        ArraysKt.copyInto$default(r112, r110.getArray$collection(), 0, 0, r112.length, 6, null);
        goto L27
    L26:
        throw new ConcurrentModificationException();
    L14:
        if (r100 >= 4) goto L17;
        r105 = 4;
    L27:
        if (r104 >= r100) goto L30;
        int r107 = r104 + 1;
        ArraysKt.copyInto(r110.getHashes$collection(), r110.getHashes$collection(), r107, r104, r100);
        ArraysKt.copyInto(r110.getArray$collection(), r110.getArray$collection(), r107, r104, r100);
    L30:
        if (r100 != r110.get_size$collection()) goto L36;
        if (r104 >= r110.getHashes$collection().length) goto L36;
        r110.getHashes$collection()[r104] = r103;
        r110.getArray$collection()[r104] = r111;
        r110.set_size$collection(r110.get_size$collection() + 1);
        return true;
    L36:
        throw new ConcurrentModificationException();
    L5:
        int r108 = r111.hashCode();
        r103 = r108;
        r102 = indexOf(r110, r111, r108);
        goto L6
    }

    public static final <E> void allocArrays(ArraySet<E> r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        r100.setHashes$collection(new int[r101]);
        r100.setArray$collection(new Object[r101]);
    }

    public static final <E> int binarySearchInternal(ArraySet<E> r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return ContainerHelpersKt.binarySearch(r100.getHashes$collection(), r100.get_size$collection(), r101);
    L6:
        throw new ConcurrentModificationException();
    }

    public static final <E> boolean containsAllInternal(ArraySet<E> r100, Collection<? extends E> r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, SlcElement.KEY_ELEMENTS);
        Iterator<? extends E> r102 = r101.iterator();
    L4:
        if (r102.hasNext() == false) goto L9;
        if (r100.contains(r102.next()) == true) goto L4;
        return false;
    L9:
        return true;
    }

    public static final <E> boolean containsInternal(ArraySet<E> r100, E r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r100.indexOf(r101) < 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static final <E> void ensureCapacityInternal(ArraySet<E> r110, int r111) {
        Intrinsics.checkNotNullParameter(r110, "<this>");
        int r100 = r110.get_size$collection();
        if (r110.getHashes$collection().length >= r111) goto L8;
        int[] r101 = r110.getHashes$collection();
        Object[] r102 = r110.getArray$collection();
        allocArrays(r110, r111);
        if (r110.get_size$collection() <= 0) goto L8;
        ArraysKt.copyInto$default(r101, r110.getHashes$collection(), 0, 0, r110.get_size$collection(), 6, null);
        ArraysKt.copyInto$default(r102, r110.getArray$collection(), 0, 0, r110.get_size$collection(), 6, null);
    L8:
        if (r110.get_size$collection() != r100) goto L11;
        return;
    L11:
        throw new ConcurrentModificationException();
    }

    public static final <E> boolean equalsInternal(ArraySet<E> r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r100 != r101) goto L6;
        return true;
    L6:
        if ((r101 instanceof Set) == true) goto L8;
    L17:
        return false;
    L8:
        if (r100.size() == ((Set) r101).size()) goto L19;
        return false;
    L19:
        int r102 = r100.get_size$collection();     // Catch: Throwable -> L18
        int r103 = 0;
    L11:
        if (r103 >= r102) goto L16;
        Set r104 = (Set) r101;     // Catch: Throwable -> L18
        if (r104.contains(r100.valueAt(r103)) == false) goto L14;
        r103 = r103 + 1;
        goto L11
    L14:
        return false;
    L16:
        return true;
    }

    public static final <E> int indexOfInternal(ArraySet<E> r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r101 != null) goto L6;
        return indexOfNull(r100);
    L6:
        return indexOf(r100, r101, r101.hashCode());
    }

    public static final <E> boolean removeAllInternal(ArraySet<E> r100, ArraySet<? extends E> r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "array");
        int r102 = r101.get_size$collection();
        int r103 = r100.get_size$collection();
        int r104 = 0;
    L3:
        if (r104 >= r102) goto L6;
        r100.remove(r101.valueAt(r104));
        r104 = r104 + 1;
        goto L3
    L6:
        if (r103 == r100.get_size$collection()) goto L10;
        return true;
    L10:
        return false;
    }

    public static final <E> E removeAtInternal(ArraySet<E> r110, int r111) {
        Intrinsics.checkNotNullParameter(r110, "<this>");
        int r100 = r110.get_size$collection();
        E r101 = (E) r110.getArray$collection()[r111];
        if (r100 > 1) goto L5;
        r110.clear();
    L23:
        return r101;
    L5:
        int r102 = r100 - 1;
        int r103 = 8;
        if (r110.getHashes$collection().length > 8) goto L8;
    L17:
        if (r111 >= r102) goto L19;
        int r104 = r111 + 1;
        int r105 = r102 + 1;
        ArraysKt.copyInto(r110.getHashes$collection(), r110.getHashes$collection(), r111, r104, r105);
        ArraysKt.copyInto(r110.getArray$collection(), r110.getArray$collection(), r111, r104, r105);
    L19:
        r110.getArray$collection()[r102] = null;
    L21:
        if (r100 != r110.get_size$collection()) goto L25;
        r110.set_size$collection(r102);
        goto L23
    L25:
        throw new ConcurrentModificationException();
    L8:
        if (r110.get_size$collection() >= (r110.getHashes$collection().length / 3)) goto L17;
        if (r110.get_size$collection() <= 8) goto L12;
        r103 = r110.get_size$collection() + (r110.get_size$collection() >> 1);
    L12:
        int[] r106 = r110.getHashes$collection();
        Object[] r107 = r110.getArray$collection();
        allocArrays(r110, r103);
        if (r111 <= 0) goto L15;
        ArraysKt.copyInto$default(r106, r110.getHashes$collection(), 0, 0, r111, 6, null);
        ArraysKt.copyInto$default(r107, r110.getArray$collection(), 0, 0, r111, 6, null);
    L15:
        if (r111 >= r102) goto L21;
        int r108 = r111 + 1;
        int r109 = r102 + 1;
        ArraysKt.copyInto(r106, r110.getHashes$collection(), r111, r108, r109);
        ArraysKt.copyInto(r107, r110.getArray$collection(), r111, r108, r109);
        goto L21
    }

    public static final <E> boolean removeInternal(ArraySet<E> r100, E r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        int r102 = r100.indexOf(r101);
        if (r102 < 0) goto L6;
        r100.removeAt(r102);
        return true;
    L6:
        return false;
    }

    public static final <E> boolean retainAllInternal(ArraySet<E> r100, Collection<? extends E> r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, SlcElement.KEY_ELEMENTS);
        int r102 = r100.get_size$collection() - 1;
        boolean r103 = false;
    L4:
        if ((-1) >= r102) goto L9;
        if (CollectionsKt.contains(r101, r100.getArray$collection()[r102]) == true) goto L8;
        r100.removeAt(r102);
        r103 = true;
    L8:
        r102 = r102 - 1;
        goto L4
    L9:
        return r103;
    }

    public static final <E> E valueAtInternal(ArraySet<E> r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return (E) r100.getArray$collection()[r101];
    }

    public static final <E> boolean addAllInternal(ArraySet<E> r100, Collection<? extends E> r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, SlcElement.KEY_ELEMENTS);
        r100.ensureCapacity(r100.get_size$collection() + r101.size());
        Iterator<? extends E> r102 = r101.iterator();
        boolean r103 = false;
    L4:
        if (r102.hasNext() == false) goto L6;
        r103 = r103 | r100.add(r102.next());
        goto L4
    L6:
        return r103;
    }

    public static final <E> boolean removeAllInternal(ArraySet<E> r100, Collection<? extends E> r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, SlcElement.KEY_ELEMENTS);
        Iterator<? extends E> r102 = r101.iterator();
        boolean r103 = false;
    L4:
        if (r102.hasNext() == false) goto L6;
        r103 = r103 | r100.remove(r102.next());
        goto L4
    L6:
        return r103;
    }

    public static final <E> int indexOf(ArraySet<E> r100, Object r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        int r103 = r100.get_size$collection();
        if (r103 != 0) goto L6;
        return -1;
    L6:
        int r104 = binarySearchInternal(r100, r102);
        if (r104 >= 0) goto L10;
        return r104;
    L10:
        if (Intrinsics.areEqual(r101, r100.getArray$collection()[r104]) == false) goto L12;
        return r104;
    L12:
        int r105 = r104 + 1;
    L13:
        if (r105 >= r103) goto L20;
        if (r100.getHashes$collection()[r105] != r102) goto L20;
        if (Intrinsics.areEqual(r101, r100.getArray$collection()[r105]) == true) goto L18;
        r105 = r105 + 1;
        goto L13
    L18:
        return r105;
    L20:
        int r106 = r104 - 1;
    L21:
        if (r106 < 0) goto L29;
        if (r100.getHashes$collection()[r106] != r102) goto L29;
        if (Intrinsics.areEqual(r101, r100.getArray$collection()[r106]) == true) goto L26;
        r106 = r106 - 1;
        goto L21
    L26:
        return r106;
    L29:
        return ~r105;
    }
}
