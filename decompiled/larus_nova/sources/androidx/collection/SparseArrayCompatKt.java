package androidx.collection;

import androidx.collection.internal.ContainerHelpersKt;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.android.ec.slice.SliceInitService;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\u0010\u000b\n\u0002\b\u001d\n\u0002\u0010\u000e\n\u0000\u001a:\u0010\u0002\u001a\u0002H\u0003\"\u0004\b\u0000\u0010\u0004\"\n\b\u0001\u0010\u0003*\u0004\u0018\u0001H\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u0002H\u0003H\u0082\b¢\u0006\u0002\u0010\t\u001a'\u0010\n\u001a\u0004\u0018\u0001H\u0004\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0000¢\u0006\u0002\u0010\u000b\u001a-\u0010\n\u001a\u0002H\u0004\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u0002H\u0004H\u0000¢\u0006\u0002\u0010\t\u001a \u0010\f\u001a\u00020\r\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0000\u001a+\u0010\f\u001a\u00020\u000e\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001H\u0080\b\u001a!\u0010\u0010\u001a\u00020\r\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u00052\u0006\u0010\u0011\u001a\u00020\u0007H\u0080\b\u001a)\u0010\u0012\u001a\u00020\r\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u00052\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0007H\u0080\b\u001a0\u0010\u0014\u001a\u0004\u0018\u0001H\u0004\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u0002H\u0004H\u0080\b¢\u0006\u0002\u0010\t\u001a6\u0010\u0014\u001a\u00020\u000e\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u0002H\u00042\u0006\u0010\u0016\u001a\u0002H\u0004H\u0080\b¢\u0006\u0002\u0010\u0017\u001a\u0018\u0010\u0018\u001a\u00020\r\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u0005H\u0002\u001a.\u0010\u0019\u001a\u00020\r\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u0002H\u0004H\u0080\b¢\u0006\u0002\u0010\u001a\u001a)\u0010\u001b\u001a\u00020\r\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u00052\u000e\u0010\u001c\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00040\u0005H\u0080\b\u001a0\u0010\u001d\u001a\u0004\u0018\u0001H\u0004\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u0002H\u0004H\u0080\b¢\u0006\u0002\u0010\t\u001a\u0019\u0010\u001e\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u0005H\u0080\b\u001a\u0019\u0010\u001f\u001a\u00020\u000e\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u0005H\u0080\b\u001a!\u0010 \u001a\u00020\u0007\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u00052\u0006\u0010\u0011\u001a\u00020\u0007H\u0080\b\u001a&\u0010!\u001a\u0002H\u0004\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u00052\u0006\u0010\u0011\u001a\u00020\u0007H\u0080\b¢\u0006\u0002\u0010\u000b\u001a.\u0010\"\u001a\u00020\r\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u00052\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u0002H\u0004H\u0080\b¢\u0006\u0002\u0010\u001a\u001a!\u0010#\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0080\b\u001a&\u0010$\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u00052\u0006\u0010\u000f\u001a\u0002H\u0004H\u0080\b¢\u0006\u0002\u0010%\u001a!\u0010&\u001a\u00020\u000e\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0080\b\u001a&\u0010'\u001a\u00020\u000e\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u00052\u0006\u0010\u000f\u001a\u0002H\u0004H\u0080\b¢\u0006\u0002\u0010(\u001a\u0019\u0010)\u001a\u00020\r\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u0005H\u0080\b\u001a.\u0010*\u001a\u00020\r\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u0002H\u0004H\u0080\b¢\u0006\u0002\u0010\u001a\u001a\u0019\u0010+\u001a\u00020,\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u0005H\u0080\b\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"DELETED", "", "internalGet", ExifInterface.GPS_DIRECTION_TRUE, ExifInterface.LONGITUDE_EAST, "Landroidx/collection/SparseArrayCompat;", "key", "", "defaultValue", "(Landroidx/collection/SparseArrayCompat;ILjava/lang/Object;)Ljava/lang/Object;", "commonGet", "(Landroidx/collection/SparseArrayCompat;I)Ljava/lang/Object;", "commonRemove", "", "", "value", "commonRemoveAt", "index", "commonRemoveAtRange", "size", "commonReplace", "oldValue", "newValue", "(Landroidx/collection/SparseArrayCompat;ILjava/lang/Object;Ljava/lang/Object;)Z", "gc", "commonPut", "(Landroidx/collection/SparseArrayCompat;ILjava/lang/Object;)V", "commonPutAll", "other", "commonPutIfAbsent", "commonSize", "commonIsEmpty", "commonKeyAt", "commonValueAt", "commonSetValueAt", "commonIndexOfKey", "commonIndexOfValue", "(Landroidx/collection/SparseArrayCompat;Ljava/lang/Object;)I", "commonContainsKey", "commonContainsValue", "(Landroidx/collection/SparseArrayCompat;Ljava/lang/Object;)Z", "commonClear", "commonAppend", "commonToString", "", "collection"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class SparseArrayCompatKt {
    private static final Object DELETED = null;

    static {
        DELETED = new Object();
    }

    public static final /* synthetic */ Object access$getDELETED$p() {
        return DELETED;
    }

    public static final /* synthetic */ void access$gc(SparseArrayCompat r100) {
        gc(r100);
    }

    public static final <E> void commonClear(SparseArrayCompat<E> r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        int r101 = r100.size;
        Object[] r102 = r100.values;
        int r103 = 0;
    L3:
        if (r103 >= r101) goto L5;
        r102[r103] = null;
        r103 = r103 + 1;
        goto L3
    L5:
        r100.size = 0;
        r100.garbage = false;
    }

    public static final <E> boolean commonIsEmpty(SparseArrayCompat<E> r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r100.size() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static final <E> int commonSize(SparseArrayCompat<E> r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r100.garbage == false) goto L6;
        access$gc(r100);
    L6:
        return r100.size;
    }

    public static final <E> String commonToString(SparseArrayCompat<E> r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r100.size() > 0) goto L6;
        return SliceInitService.DEFAULT_SWITCH;
    L6:
        StringBuilder r101 = new StringBuilder(r100.size * 28);
        r101.append('{');
        int r102 = r100.size;
        int r103 = 0;
    L7:
        if (r103 >= r102) goto L15;
        if (r103 <= 0) goto L10;
        r101.append(", ");
    L10:
        r101.append(r100.keyAt(r103));
        r101.append(com.alipay.sdk.m.n.a.f25612h);
        E r104 = r100.valueAt(r103);
        if (r104 == r100) goto L13;
        r101.append(r104);
    L14:
        r103 = r103 + 1;
        goto L7
    L13:
        r101.append("(this Map)");
        goto L14
    L15:
        r101.append('}');
        return r101.toString();
    }

    private static final <E> void gc(SparseArrayCompat<E> r100) {
        int r101 = r100.size;
        int[] r102 = r100.keys;
        Object[] r103 = r100.values;
        int r104 = 0;
        int r105 = 0;
    L3:
        if (r104 >= r101) goto L10;
        Object r106 = r103[r104];
        if (r106 == DELETED) goto L9;
        if (r104 == r105) goto L8;
        r102[r105] = r102[r104];
        r103[r105] = r106;
        r103[r104] = null;
    L8:
        r105 = r105 + 1;
    L9:
        r104 = r104 + 1;
        goto L3
    L10:
        r100.garbage = false;
        r100.size = r105;
    }

    public static final <E> boolean commonContainsKey(SparseArrayCompat<E> r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r100.indexOfKey(r101) < 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static final <E> boolean commonContainsValue(SparseArrayCompat<E> r100, E r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r100.garbage == false) goto L5;
        access$gc(r100);
    L5:
        int r102 = r100.size;
        int r103 = 0;
    L6:
        if (r103 >= r102) goto L11;
        if (r100.values[r103] == r101) goto L12;
        r103 = r103 + 1;
    L12:
        if (r103 < 0) goto L17;
        return true;
    L17:
        return false;
    L11:
        r103 = -1;
        goto L12
    }

    public static final <E> E commonGet(SparseArrayCompat<E> r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        int r102 = ContainerHelpersKt.binarySearch(r100.keys, r100.size, r101);
        if (r102 < 0) goto L6;
        E r103 = (E) r100.values[r102];
        if (r103 == DELETED) goto L6;
        return r103;
    L6:
        return null;
    }

    public static final <E> int commonIndexOfKey(SparseArrayCompat<E> r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r100.garbage == false) goto L6;
        access$gc(r100);
    L6:
        return ContainerHelpersKt.binarySearch(r100.keys, r100.size, r101);
    }

    public static final <E> int commonIndexOfValue(SparseArrayCompat<E> r100, E r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r100.garbage == false) goto L5;
        access$gc(r100);
    L5:
        int r102 = r100.size;
        int r103 = 0;
    L6:
        if (r103 >= r102) goto L11;
        if (r100.values[r103] == r101) goto L9;
        r103 = r103 + 1;
        goto L6
    L9:
        return r103;
    L11:
        return -1;
    }

    public static final <E> int commonKeyAt(SparseArrayCompat<E> r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r100.garbage == false) goto L6;
        access$gc(r100);
    L6:
        return r100.keys[r101];
    }

    public static final <E> void commonPutAll(SparseArrayCompat<E> r100, SparseArrayCompat<? extends E> r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "other");
        int r102 = r101.size();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L25;
        int r104 = r101.keyAt(r103);
        E r105 = r101.valueAt(r103);
        int r106 = ContainerHelpersKt.binarySearch(r100.keys, r100.size, r104);
        if (r106 < 0) goto L7;
        r100.values[r106] = r105;
    L24:
        r103 = r103 + 1;
        goto L3
    L7:
        int r107 = ~r106;
        if (r107 >= r100.size) goto L13;
        if (r100.values[r107] != access$getDELETED$p()) goto L13;
        r100.keys[r107] = r104;
        r100.values[r107] = r105;
    L13:
        if (r100.garbage == true) goto L15;
    L17:
        int r108 = r100.size;
        if (r108 < r100.keys.length) goto L20;
        int r109 = ContainerHelpersKt.idealIntArraySize(r108 + 1);
        r100.keys = Arrays.copyOf(r100.keys, r109);
        r100.values = Arrays.copyOf(r100.values, r109);
    L20:
        int r110 = r100.size;
        if ((r110 - r107) == 0) goto L23;
        int[] r111 = r100.keys;
        int r112 = r107 + 1;
        ArraysKt.copyInto(r111, r111, r112, r107, r110);
        Object[] r113 = r100.values;
        ArraysKt.copyInto(r113, r113, r112, r107, r100.size);
    L23:
        r100.keys[r107] = r104;
        r100.values[r107] = r105;
        r100.size++;
        goto L24
    L15:
        if (r100.size < r100.keys.length) goto L17;
        access$gc(r100);
        r107 = ~ContainerHelpersKt.binarySearch(r100.keys, r100.size, r104);
        goto L17
    }

    public static final <E> void commonRemove(SparseArrayCompat<E> r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        int r102 = ContainerHelpersKt.binarySearch(r100.keys, r100.size, r101);
        if (r102 < 0) goto L8;
        Object[] r103 = r100.values;
        Object r104 = r103[r102];
        Object r105 = DELETED;
        if (r104 == r105) goto L9;
        r103[r102] = r105;
        r100.garbage = true;
        return;
    L9:
        return;
    }

    public static final <E> void commonRemoveAt(SparseArrayCompat<E> r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r100.values[r101] == access$getDELETED$p()) goto L6;
        r100.values[r101] = access$getDELETED$p();
        r100.garbage = true;
        return;
    }

    public static final <E> E commonValueAt(SparseArrayCompat<E> r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r100.garbage == false) goto L5;
        access$gc(r100);
    L5:
        Object[] r102 = r100.values;
        if (r101 < r102.length) goto L8;
        CollectionPlatformUtils r103 = CollectionPlatformUtils.INSTANCE;
        throw new ArrayIndexOutOfBoundsException();
    L8:
        return (E) r102[r101];
    }

    public static final <E> void commonAppend(SparseArrayCompat<E> r100, int r101, E r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        int r103 = r100.size;
        if (r103 == 0) goto L9;
        if (r101 > r100.keys[r103 - 1]) goto L9;
        r100.put(r101, r102);
        return;
    L9:
        if (r100.garbage == true) goto L11;
    L13:
        int r104 = r100.size;
        if (r104 < r100.keys.length) goto L16;
        int r105 = ContainerHelpersKt.idealIntArraySize(r104 + 1);
        r100.keys = Arrays.copyOf(r100.keys, r105);
        r100.values = Arrays.copyOf(r100.values, r105);
    L16:
        r100.keys[r104] = r101;
        r100.values[r104] = r102;
        r100.size = r104 + 1;
        return;
    L11:
        if (r103 < r100.keys.length) goto L13;
        access$gc(r100);
        goto L13
    }

    public static final <E> E commonGet(SparseArrayCompat<E> r100, int r101, E r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        int r103 = ContainerHelpersKt.binarySearch(r100.keys, r100.size, r101);
        if (r103 < 0) goto L9;
        E r104 = (E) r100.values[r103];
        if (r104 != DELETED) goto L8;
        return r102;
    L8:
        return r104;
    L9:
        return r102;
    }

    public static final <E> void commonPut(SparseArrayCompat<E> r100, int r101, E r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        int r103 = ContainerHelpersKt.binarySearch(r100.keys, r100.size, r101);
        if (r103 < 0) goto L5;
        r100.values[r103] = r102;
        return;
    L5:
        int r104 = ~r103;
        if (r104 >= r100.size) goto L12;
        if (r100.values[r104] != access$getDELETED$p()) goto L12;
        r100.keys[r104] = r101;
        r100.values[r104] = r102;
        return;
    L12:
        if (r100.garbage == true) goto L14;
    L16:
        int r105 = r100.size;
        if (r105 < r100.keys.length) goto L19;
        int r106 = ContainerHelpersKt.idealIntArraySize(r105 + 1);
        r100.keys = Arrays.copyOf(r100.keys, r106);
        r100.values = Arrays.copyOf(r100.values, r106);
    L19:
        int r107 = r100.size;
        if ((r107 - r104) == 0) goto L22;
        int[] r108 = r100.keys;
        int r109 = r104 + 1;
        ArraysKt.copyInto(r108, r108, r109, r104, r107);
        Object[] r110 = r100.values;
        ArraysKt.copyInto(r110, r110, r109, r104, r100.size);
    L22:
        r100.keys[r104] = r101;
        r100.values[r104] = r102;
        r100.size++;
        return;
    L14:
        if (r100.size < r100.keys.length) goto L16;
        access$gc(r100);
        r104 = ~ContainerHelpersKt.binarySearch(r100.keys, r100.size, r101);
        goto L16
    }

    public static final <E> E commonPutIfAbsent(SparseArrayCompat<E> r100, int r101, E r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        E r103 = (E) commonGet(r100, r101);
        if (r103 != null) goto L24;
        int r104 = ContainerHelpersKt.binarySearch(r100.keys, r100.size, r101);
        if (r104 < 0) goto L7;
        r100.values[r104] = r102;
        goto L24
    L7:
        int r105 = ~r104;
        if (r105 >= r100.size) goto L13;
        if (r100.values[r105] != access$getDELETED$p()) goto L13;
        r100.keys[r105] = r101;
        r100.values[r105] = r102;
    L13:
        if (r100.garbage == true) goto L15;
    L17:
        int r106 = r100.size;
        if (r106 < r100.keys.length) goto L20;
        int r107 = ContainerHelpersKt.idealIntArraySize(r106 + 1);
        r100.keys = Arrays.copyOf(r100.keys, r107);
        r100.values = Arrays.copyOf(r100.values, r107);
    L20:
        int r108 = r100.size;
        if ((r108 - r105) == 0) goto L23;
        int[] r109 = r100.keys;
        int r110 = r105 + 1;
        ArraysKt.copyInto(r109, r109, r110, r105, r108);
        Object[] r111 = r100.values;
        ArraysKt.copyInto(r111, r111, r110, r105, r100.size);
    L23:
        r100.keys[r105] = r101;
        r100.values[r105] = r102;
        r100.size++;
        goto L24
    L15:
        if (r100.size < r100.keys.length) goto L17;
        access$gc(r100);
        r105 = ~ContainerHelpersKt.binarySearch(r100.keys, r100.size, r101);
    L24:
        return r103;
    }

    public static final <E> boolean commonRemove(SparseArrayCompat<E> r100, int r101, Object r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        int r103 = r100.indexOfKey(r101);
        if (r103 >= 0) goto L5;
        return false;
    L5:
        if (Intrinsics.areEqual(r102, r100.valueAt(r103)) == false) goto L10;
        r100.removeAt(r103);
        return true;
    L10:
        return false;
    }

    public static final <E> void commonRemoveAtRange(SparseArrayCompat<E> r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        int r103 = Math.min(r102, r101 + r102);
    L3:
        if (r101 >= r103) goto L5;
        r100.removeAt(r101);
        r101 = r101 + 1;
        goto L3
    }

    public static final <E> E commonReplace(SparseArrayCompat<E> r100, int r101, E r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        int r103 = r100.indexOfKey(r101);
        if (r103 < 0) goto L6;
        Object[] r104 = r100.values;
        E r105 = (E) r104[r103];
        r104[r103] = r102;
        return r105;
    L6:
        return null;
    }

    public static final <E> void commonSetValueAt(SparseArrayCompat<E> r100, int r101, E r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r100.garbage == false) goto L5;
        access$gc(r100);
    L5:
        r100.values[r101] = r102;
    }

    private static final <E, T extends E> T internalGet(SparseArrayCompat<E> r100, int r101, T r102) {
        int r103 = ContainerHelpersKt.binarySearch(r100.keys, r100.size, r101);
        if (r103 < 0) goto L9;
        T r104 = (T) r100.values[r103];
        if (r104 != DELETED) goto L8;
        return r102;
    L8:
        return r104;
    L9:
        return r102;
    }

    public static final <E> boolean commonReplace(SparseArrayCompat<E> r100, int r101, E r102, E r103) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        int r104 = r100.indexOfKey(r101);
        if (r104 >= 0) goto L5;
        return false;
    L5:
        if (Intrinsics.areEqual(r100.values[r104], r102) == false) goto L10;
        r100.values[r104] = r103;
        return true;
    L10:
        return false;
    }
}
