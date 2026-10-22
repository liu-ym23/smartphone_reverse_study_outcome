package androidx.collection;

import androidx.collection.internal.ContainerHelpersKt;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.android.ec.slice.SliceInitService;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.util.Arrays;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001a\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u001d\n\u0002\u0010\u000e\n\u0000\b\u0016\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0013\b\u0007\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u000e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000H\u0016J\u0018\u0010\u0011\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0012\u001a\u00020\u0004H\u0096\u0002¢\u0006\u0002\u0010\u0013J\u001d\u0010\u0011\u001a\u00028\u00002\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0012\u001a\u00020\u0004H\u0017J\u0010\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0012\u001a\u00020\u0004H\u0016J\u001a\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u00042\b\u0010\u0019\u001a\u0004\u0018\u00010\rH\u0016J\u0010\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u0004H\u0016J\u0018\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0004H\u0016J\u001f\u0010\u001d\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0015J%\u0010\u001d\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00028\u00002\u0006\u0010\u001f\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010 J\u001d\u0010!\u001a\u00020\u00172\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\"J\u0018\u0010#\u001a\u00020\u00172\u000e\u0010$\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0000H\u0016J\u001f\u0010%\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0015J\b\u0010\u000f\u001a\u00020\u0004H\u0016J\b\u0010&\u001a\u00020\bH\u0016J\u0010\u0010)\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u0004H\u0016J\u0015\u0010*\u001a\u00028\u00002\u0006\u0010\u001b\u001a\u00020\u0004H\u0016¢\u0006\u0002\u0010\u0013J\u001d\u0010+\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\"J\u0010\u0010,\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0004H\u0016J\u0015\u0010-\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010.J\u0010\u0010/\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0004H\u0016J\u0015\u00100\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00028\u0000H\u0016¢\u0006\u0002\u00101J\b\u00102\u001a\u00020\u0017H\u0016J\u001d\u00103\u001a\u00020\u00172\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\"J\b\u00104\u001a\u000205H\u0016R\u0012\u0010\u0007\u001a\u00020\b8\u0000@\u0000X\u0081\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00020\n8\u0000@\u0000X\u0081\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\f8\u0000@\u0000X\u0081\u000e¢\u0006\u0004\n\u0002\u0010\u000eR\u0012\u0010\u000f\u001a\u00020\u00048\u0000@\u0000X\u0081\u000e¢\u0006\u0002\n\u0000R\u0011\u0010&\u001a\u00020\b8G¢\u0006\u0006\u001a\u0004\b'\u0010(¨\u00066"}, d2 = {"Landroidx/collection/SparseArrayCompat;", ExifInterface.LONGITUDE_EAST, "", "initialCapacity", "", "<init>", "(I)V", "garbage", "", "keys", "", "values", "", "", "[Ljava/lang/Object;", "size", "clone", MonitorConstants.CONNECT_TYPE_GET, "key", "(I)Ljava/lang/Object;", "defaultValue", "(ILjava/lang/Object;)Ljava/lang/Object;", "delete", "", "remove", "value", "removeAt", "index", "removeAtRange", "replace", "oldValue", "newValue", "(ILjava/lang/Object;Ljava/lang/Object;)Z", "put", "(ILjava/lang/Object;)V", "putAll", "other", "putIfAbsent", "isEmpty", "getIsEmpty", "()Z", "keyAt", "valueAt", "setValueAt", "indexOfKey", "indexOfValue", "(Ljava/lang/Object;)I", "containsKey", "containsValue", "(Ljava/lang/Object;)Z", "clear", "append", "toString", "", "collection"}, k = 1, mv = {2, 0, 0}, xi = 48)
public class SparseArrayCompat<E> implements Cloneable {
    public /* synthetic */ boolean garbage;
    public /* synthetic */ int[] keys;
    public /* synthetic */ int size;
    public /* synthetic */ Object[] values;

    public SparseArrayCompat() {
        int r100 = 0;
        this(r100, 1, null);
    }

    public void clear() {
        int r100 = this.size;
        Object[] r101 = this.values;
        int r102 = 0;
    L3:
        if (r102 >= r100) goto L5;
        r101[r102] = null;
        r102 = r102 + 1;
        goto L3
    L5:
        this.size = 0;
        this.garbage = false;
    }

    public int size() {
        if (this.garbage == false) goto L6;
        SparseArrayCompatKt.access$gc(this);
    L6:
        return this.size;
    }

    public SparseArrayCompat<E> clone() {
        Object r100 = super.clone();
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type androidx.collection.SparseArrayCompat<E of androidx.collection.SparseArrayCompat>");
        SparseArrayCompat<E> r101 = (SparseArrayCompat) r100;
        r101.keys = (int[]) this.keys.clone();
        r101.values = (Object[]) this.values.clone();
        return r101;
    }

    public final boolean getIsEmpty() {
        return isEmpty();
    }

    public boolean isEmpty() {
        if (size() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public String toString() {
        if (size() > 0) goto L5;
        return SliceInitService.DEFAULT_SWITCH;
    L5:
        StringBuilder r100 = new StringBuilder(this.size * 28);
        r100.append('{');
        int r101 = this.size;
        int r102 = 0;
    L6:
        if (r102 >= r101) goto L14;
        if (r102 <= 0) goto L9;
        r100.append(", ");
    L9:
        r100.append(keyAt(r102));
        r100.append(com.alipay.sdk.m.n.a.f25612h);
        E r103 = valueAt(r102);
        if (r103 == this) goto L12;
        r100.append(r103);
    L13:
        r102 = r102 + 1;
        goto L6
    L12:
        r100.append("(this Map)");
        goto L13
    L14:
        r100.append('}');
        return r100.toString();
    }

    /* JADX INFO: renamed from: clone, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m27clone() {
        return clone();
    }

    public SparseArrayCompat(int r100) {
        if (r100 != 0) goto L5;
        this.keys = ContainerHelpersKt.EMPTY_INTS;
        this.values = ContainerHelpersKt.EMPTY_OBJECTS;
        return;
    L5:
        int r101 = ContainerHelpersKt.idealIntArraySize(r100);
        this.keys = new int[r101];
        this.values = new Object[r101];
    }

    public boolean containsKey(int r100) {
        if (indexOfKey(r100) < 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean containsValue(E r100) {
        if (this.garbage == false) goto L5;
        SparseArrayCompatKt.access$gc(this);
    L5:
        int r101 = this.size;
        int r102 = 0;
    L6:
        if (r102 >= r101) goto L11;
        if (this.values[r102] == r100) goto L12;
        r102 = r102 + 1;
    L12:
        if (r102 < 0) goto L17;
        return true;
    L17:
        return false;
    L11:
        r102 = -1;
        goto L12
    }

    @Deprecated(message = "Alias for remove(int).", replaceWith = @ReplaceWith(expression = "remove(key)", imports = {}))
    public void delete(int r100) {
        remove(r100);
    }

    public E get(int r100) {
        return (E) SparseArrayCompatKt.commonGet(this, r100);
    }

    public int indexOfKey(int r100) {
        if (this.garbage == false) goto L6;
        SparseArrayCompatKt.access$gc(this);
    L6:
        return ContainerHelpersKt.binarySearch(this.keys, this.size, r100);
    }

    public int indexOfValue(E r100) {
        if (this.garbage == false) goto L5;
        SparseArrayCompatKt.access$gc(this);
    L5:
        int r101 = this.size;
        int r102 = 0;
    L6:
        if (r102 >= r101) goto L11;
        if (this.values[r102] == r100) goto L15;
        r102 = r102 + 1;
        goto L6
    L15:
        return r102;
    L11:
        return -1;
    }

    public int keyAt(int r100) {
        if (this.garbage == false) goto L6;
        SparseArrayCompatKt.access$gc(this);
    L6:
        return this.keys[r100];
    }

    public void putAll(SparseArrayCompat<? extends E> r100) {
        Intrinsics.checkNotNullParameter(r100, "other");
        int r101 = r100.size();
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L25;
        int r103 = r100.keyAt(r102);
        E r104 = r100.valueAt(r102);
        int r105 = ContainerHelpersKt.binarySearch(this.keys, this.size, r103);
        if (r105 < 0) goto L7;
        this.values[r105] = r104;
    L24:
        r102 = r102 + 1;
        goto L3
    L7:
        int r106 = ~r105;
        if (r106 >= this.size) goto L13;
        if (this.values[r106] != SparseArrayCompatKt.access$getDELETED$p()) goto L13;
        this.keys[r106] = r103;
        this.values[r106] = r104;
    L13:
        if (this.garbage == true) goto L15;
    L17:
        int r107 = this.size;
        if (r107 < this.keys.length) goto L20;
        int r108 = ContainerHelpersKt.idealIntArraySize(r107 + 1);
        this.keys = Arrays.copyOf(this.keys, r108);
        this.values = Arrays.copyOf(this.values, r108);
    L20:
        int r109 = this.size;
        if ((r109 - r106) == 0) goto L23;
        int[] r110 = this.keys;
        int r111 = r106 + 1;
        ArraysKt.copyInto(r110, r110, r111, r106, r109);
        Object[] r112 = this.values;
        ArraysKt.copyInto(r112, r112, r111, r106, this.size);
    L23:
        this.keys[r106] = r103;
        this.values[r106] = r104;
        this.size++;
        goto L24
    L15:
        if (this.size < this.keys.length) goto L17;
        SparseArrayCompatKt.access$gc(this);
        r106 = ~ContainerHelpersKt.binarySearch(this.keys, this.size, r103);
        goto L17
    }

    public void remove(int r100) {
        SparseArrayCompatKt.commonRemove(this, r100);
    }

    public void removeAt(int r100) {
        if (this.values[r100] == SparseArrayCompatKt.access$getDELETED$p()) goto L6;
        this.values[r100] = SparseArrayCompatKt.access$getDELETED$p();
        this.garbage = true;
        return;
    }

    public E valueAt(int r100) {
        if (this.garbage == false) goto L5;
        SparseArrayCompatKt.access$gc(this);
    L5:
        Object[] r101 = this.values;
        if (r100 < r101.length) goto L8;
        CollectionPlatformUtils r102 = CollectionPlatformUtils.INSTANCE;
        throw new ArrayIndexOutOfBoundsException();
    L8:
        return (E) r101[r100];
    }

    public void append(int r100, E r101) {
        int r102 = this.size;
        if (r102 == 0) goto L8;
        if (r100 > this.keys[r102 - 1]) goto L8;
        put(r100, r101);
        return;
    L8:
        if (this.garbage == true) goto L10;
    L12:
        int r103 = this.size;
        if (r103 < this.keys.length) goto L15;
        int r104 = ContainerHelpersKt.idealIntArraySize(r103 + 1);
        this.keys = Arrays.copyOf(this.keys, r104);
        this.values = Arrays.copyOf(this.values, r104);
    L15:
        this.keys[r103] = r100;
        this.values[r103] = r101;
        this.size = r103 + 1;
        return;
    L10:
        if (r102 < this.keys.length) goto L12;
        SparseArrayCompatKt.access$gc(this);
        goto L12
    }

    public E get(int r100, E r101) {
        return (E) SparseArrayCompatKt.commonGet(this, r100, r101);
    }

    public void put(int r100, E r101) {
        int r102 = ContainerHelpersKt.binarySearch(this.keys, this.size, r100);
        if (r102 < 0) goto L5;
        this.values[r102] = r101;
        return;
    L5:
        int r103 = ~r102;
        if (r103 >= this.size) goto L11;
        if (this.values[r103] != SparseArrayCompatKt.access$getDELETED$p()) goto L11;
        this.keys[r103] = r100;
        this.values[r103] = r101;
        return;
    L11:
        if (this.garbage == true) goto L13;
    L15:
        int r104 = this.size;
        if (r104 < this.keys.length) goto L18;
        int r105 = ContainerHelpersKt.idealIntArraySize(r104 + 1);
        this.keys = Arrays.copyOf(this.keys, r105);
        this.values = Arrays.copyOf(this.values, r105);
    L18:
        int r106 = this.size;
        if ((r106 - r103) == 0) goto L21;
        int[] r107 = this.keys;
        int r108 = r103 + 1;
        ArraysKt.copyInto(r107, r107, r108, r103, r106);
        Object[] r109 = this.values;
        ArraysKt.copyInto(r109, r109, r108, r103, this.size);
    L21:
        this.keys[r103] = r100;
        this.values[r103] = r101;
        this.size++;
        return;
    L13:
        if (this.size < this.keys.length) goto L15;
        SparseArrayCompatKt.access$gc(this);
        r103 = ~ContainerHelpersKt.binarySearch(this.keys, this.size, r100);
        goto L15
    }

    public E putIfAbsent(int r100, E r101) {
        E r102 = (E) SparseArrayCompatKt.commonGet(this, r100);
        if (r102 != null) goto L24;
        int r103 = ContainerHelpersKt.binarySearch(this.keys, this.size, r100);
        if (r103 < 0) goto L7;
        this.values[r103] = r101;
        goto L24
    L7:
        int r104 = ~r103;
        if (r104 >= this.size) goto L13;
        if (this.values[r104] != SparseArrayCompatKt.access$getDELETED$p()) goto L13;
        this.keys[r104] = r100;
        this.values[r104] = r101;
    L13:
        if (this.garbage == true) goto L15;
    L17:
        int r105 = this.size;
        if (r105 < this.keys.length) goto L20;
        int r106 = ContainerHelpersKt.idealIntArraySize(r105 + 1);
        this.keys = Arrays.copyOf(this.keys, r106);
        this.values = Arrays.copyOf(this.values, r106);
    L20:
        int r107 = this.size;
        if ((r107 - r104) == 0) goto L23;
        int[] r108 = this.keys;
        int r109 = r104 + 1;
        ArraysKt.copyInto(r108, r108, r109, r104, r107);
        Object[] r110 = this.values;
        ArraysKt.copyInto(r110, r110, r109, r104, this.size);
    L23:
        this.keys[r104] = r100;
        this.values[r104] = r101;
        this.size++;
        goto L24
    L15:
        if (this.size < this.keys.length) goto L17;
        SparseArrayCompatKt.access$gc(this);
        r104 = ~ContainerHelpersKt.binarySearch(this.keys, this.size, r100);
    L24:
        return r102;
    }

    public boolean remove(int r100, Object r101) {
        int r102 = indexOfKey(r100);
        if (r102 >= 0) goto L5;
    L7:
        return false;
    L5:
        if (Intrinsics.areEqual(r101, valueAt(r102)) == false) goto L7;
        removeAt(r102);
        return true;
    }

    public void removeAtRange(int r100, int r101) {
        int r102 = Math.min(r101, r100 + r101);
    L3:
        if (r100 >= r102) goto L5;
        removeAt(r100);
        r100 = r100 + 1;
        goto L3
    }

    public E replace(int r100, E r101) {
        int r102 = indexOfKey(r100);
        if (r102 < 0) goto L5;
        Object[] r103 = this.values;
        E r104 = (E) r103[r102];
        r103[r102] = r101;
        return r104;
    L5:
        return null;
    }

    public void setValueAt(int r100, E r101) {
        if (this.garbage == false) goto L5;
        SparseArrayCompatKt.access$gc(this);
    L5:
        this.values[r100] = r101;
    }

    public /* synthetic */ SparseArrayCompat(int r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = 10;
    L5:
        this(r100);
    }

    public boolean replace(int r100, E r101, E r102) {
        int r103 = indexOfKey(r100);
        if (r103 >= 0) goto L5;
    L7:
        return false;
    L5:
        if (Intrinsics.areEqual(this.values[r103], r101) == false) goto L7;
        this.values[r103] = r102;
        return true;
    }
}
