package androidx.collection;

import androidx.collection.internal.ContainerHelpersKt;
import androidx.collection.internal.RuntimeHelpersKt;
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
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001a\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0016\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u001d\n\u0002\u0010\u000e\n\u0000\b\u0016\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0013\b\u0007\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u000e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000H\u0016J\u0018\u0010\u0011\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0012\u001a\u00020\u0013H\u0096\u0002¢\u0006\u0002\u0010\u0014J\u001d\u0010\u0011\u001a\u00028\u00002\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0012\u001a\u00020\u0013H\u0017J\u0010\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u001d\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u0004H\u0016J\u001f\u0010\u001e\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0016J%\u0010\u001e\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u001f\u001a\u00028\u00002\u0006\u0010 \u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010!J\u001d\u0010\"\u001a\u00020\u00182\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010#J\u0018\u0010$\u001a\u00020\u00182\u000e\u0010%\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0000H\u0016J\u001f\u0010&\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0016J\b\u0010\u000f\u001a\u00020\u0004H\u0016J\b\u0010'\u001a\u00020\bH\u0016J\u0010\u0010(\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u0004H\u0016J\u0015\u0010)\u001a\u00028\u00002\u0006\u0010\u001d\u001a\u00020\u0004H\u0016¢\u0006\u0002\u0010*J\u001d\u0010+\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010,J\u0010\u0010-\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0015\u0010.\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010/J\u0010\u00100\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0015\u00101\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00028\u0000H\u0016¢\u0006\u0002\u00102J\b\u00103\u001a\u00020\u0018H\u0016J\u001d\u00104\u001a\u00020\u00182\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010#J\b\u00105\u001a\u000206H\u0016R\u0012\u0010\u0007\u001a\u00020\b8\u0000@\u0000X\u0081\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00020\n8\u0000@\u0000X\u0081\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\f8\u0000@\u0000X\u0081\u000e¢\u0006\u0004\n\u0002\u0010\u000eR\u0012\u0010\u000f\u001a\u00020\u00048\u0000@\u0000X\u0081\u000e¢\u0006\u0002\n\u0000¨\u00067"}, d2 = {"Landroidx/collection/LongSparseArray;", ExifInterface.LONGITUDE_EAST, "", "initialCapacity", "", "<init>", "(I)V", "garbage", "", "keys", "", "values", "", "", "[Ljava/lang/Object;", "size", "clone", MonitorConstants.CONNECT_TYPE_GET, "key", "", "(J)Ljava/lang/Object;", "defaultValue", "(JLjava/lang/Object;)Ljava/lang/Object;", "delete", "", "remove", "value", "(JLjava/lang/Object;)Z", "removeAt", "index", "replace", "oldValue", "newValue", "(JLjava/lang/Object;Ljava/lang/Object;)Z", "put", "(JLjava/lang/Object;)V", "putAll", "other", "putIfAbsent", "isEmpty", "keyAt", "valueAt", "(I)Ljava/lang/Object;", "setValueAt", "(ILjava/lang/Object;)V", "indexOfKey", "indexOfValue", "(Ljava/lang/Object;)I", "containsKey", "containsValue", "(Ljava/lang/Object;)Z", "clear", "append", "toString", "", "collection"}, k = 1, mv = {2, 0, 0}, xi = 48)
public class LongSparseArray<E> implements Cloneable {
    public /* synthetic */ boolean garbage;
    public /* synthetic */ long[] keys;
    public /* synthetic */ int size;
    public /* synthetic */ Object[] values;

    public LongSparseArray() {
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
        if (this.garbage == false) goto L14;
        int r100 = this.size;
        long[] r101 = this.keys;
        Object[] r102 = this.values;
        int r103 = 0;
        int r104 = 0;
    L5:
        if (r103 >= r100) goto L12;
        Object r105 = r102[r103];
        if (r105 == LongSparseArrayKt.access$getDELETED$p()) goto L11;
        if (r103 == r104) goto L10;
        r101[r104] = r101[r103];
        r102[r104] = r105;
        r102[r103] = null;
    L10:
        r104 = r104 + 1;
    L11:
        r103 = r103 + 1;
        goto L5
    L12:
        this.garbage = false;
        this.size = r104;
    L14:
        return this.size;
    }

    public LongSparseArray<E> clone() {
        Object r100 = super.clone();
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type androidx.collection.LongSparseArray<E of androidx.collection.LongSparseArray>");
        LongSparseArray<E> r101 = (LongSparseArray) r100;
        r101.keys = (long[]) this.keys.clone();
        r101.values = (Object[]) this.values.clone();
        return r101;
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
        if (r103 == r100) goto L12;
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
    public /* bridge */ /* synthetic */ Object m26clone() {
        return clone();
    }

    public LongSparseArray(int r100) {
        if (r100 != 0) goto L5;
        this.keys = ContainerHelpersKt.EMPTY_LONGS;
        this.values = ContainerHelpersKt.EMPTY_OBJECTS;
        return;
    L5:
        int r101 = ContainerHelpersKt.idealLongArraySize(r100);
        this.keys = new long[r101];
        this.values = new Object[r101];
    }

    public boolean containsKey(long r100) {
        if (indexOfKey(r100) < 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean containsValue(E r100) {
        if (indexOfValue(r100) < 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Deprecated(message = "Alias for `remove(key)`.", replaceWith = @ReplaceWith(expression = "remove(key)", imports = {}))
    public void delete(long r100) {
        int r101 = ContainerHelpersKt.binarySearch(this.keys, this.size, r100);
        if (r101 >= 0) goto L5;
        return;
    L5:
        if (this.values[r101] == LongSparseArrayKt.access$getDELETED$p()) goto L9;
        this.values[r101] = LongSparseArrayKt.access$getDELETED$p();
        this.garbage = true;
        return;
    }

    public E get(long r100) {
        int r101 = ContainerHelpersKt.binarySearch(this.keys, this.size, r100);
        if (r101 >= 0) goto L5;
    L8:
        return null;
    L5:
        if (this.values[r101] == LongSparseArrayKt.access$getDELETED$p()) goto L8;
        return (E) this.values[r101];
    }

    public int indexOfKey(long r110) {
        if (this.garbage == false) goto L14;
        int r100 = this.size;
        long[] r101 = this.keys;
        Object[] r102 = this.values;
        int r103 = 0;
        int r104 = 0;
    L5:
        if (r103 >= r100) goto L12;
        Object r105 = r102[r103];
        if (r105 == LongSparseArrayKt.access$getDELETED$p()) goto L11;
        if (r103 == r104) goto L10;
        r101[r104] = r101[r103];
        r102[r104] = r105;
        r102[r103] = null;
    L10:
        r104 = r104 + 1;
    L11:
        r103 = r103 + 1;
        goto L5
    L12:
        this.garbage = false;
        this.size = r104;
    L14:
        return ContainerHelpersKt.binarySearch(this.keys, this.size, r110);
    }

    public int indexOfValue(E r110) {
        int r100 = 0;
        if (this.garbage == false) goto L13;
        int r101 = this.size;
        long[] r102 = this.keys;
        Object[] r103 = this.values;
        int r104 = 0;
        int r105 = 0;
    L5:
        if (r104 >= r101) goto L12;
        Object r106 = r103[r104];
        if (r106 == LongSparseArrayKt.access$getDELETED$p()) goto L11;
        if (r104 == r105) goto L10;
        r102[r105] = r102[r104];
        r103[r105] = r106;
        r103[r104] = null;
    L10:
        r105 = r105 + 1;
    L11:
        r104 = r104 + 1;
        goto L5
    L12:
        this.garbage = false;
        this.size = r105;
    L13:
        int r107 = this.size;
    L14:
        if (r100 >= r107) goto L19;
        if (this.values[r100] == r110) goto L26;
        r100 = r100 + 1;
        goto L14
    L26:
        return r100;
    L19:
        return -1;
    }

    public long keyAt(int r110) {
        if (r110 >= 0) goto L5;
    L7:
        boolean r100 = false;
    L8:
        if (r100 == true) goto L11;
        RuntimeHelpersKt.throwIllegalArgumentException("Expected index to be within 0..size()-1, but was " + r110);
    L11:
        if (this.garbage == false) goto L22;
        int r101 = this.size;
        long[] r102 = this.keys;
        Object[] r103 = this.values;
        int r104 = 0;
        int r105 = 0;
    L13:
        if (r104 >= r101) goto L20;
        Object r106 = r103[r104];
        if (r106 == LongSparseArrayKt.access$getDELETED$p()) goto L19;
        if (r104 == r105) goto L18;
        r102[r105] = r102[r104];
        r103[r105] = r106;
        r103[r104] = null;
    L18:
        r105 = r105 + 1;
    L19:
        r104 = r104 + 1;
        goto L13
    L20:
        this.garbage = false;
        this.size = r105;
    L22:
        return this.keys[r110];
    L5:
        if (r110 >= this.size) goto L7;
        r100 = true;
        goto L8
    }

    public void putAll(LongSparseArray<? extends E> r100) {
        Intrinsics.checkNotNullParameter(r100, "other");
        int r101 = r100.size();
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L5;
        put(r100.keyAt(r102), r100.valueAt(r102));
        r102 = r102 + 1;
        goto L3
    }

    public void remove(long r100) {
        int r101 = ContainerHelpersKt.binarySearch(this.keys, this.size, r100);
        if (r101 >= 0) goto L5;
        return;
    L5:
        if (this.values[r101] == LongSparseArrayKt.access$getDELETED$p()) goto L9;
        this.values[r101] = LongSparseArrayKt.access$getDELETED$p();
        this.garbage = true;
        return;
    }

    public void removeAt(int r100) {
        if (this.values[r100] == LongSparseArrayKt.access$getDELETED$p()) goto L6;
        this.values[r100] = LongSparseArrayKt.access$getDELETED$p();
        this.garbage = true;
        return;
    }

    public E valueAt(int r110) {
        if (r110 >= 0) goto L5;
    L7:
        boolean r100 = false;
    L8:
        if (r100 == true) goto L11;
        RuntimeHelpersKt.throwIllegalArgumentException("Expected index to be within 0..size()-1, but was " + r110);
    L11:
        if (this.garbage == false) goto L22;
        int r101 = this.size;
        long[] r102 = this.keys;
        Object[] r103 = this.values;
        int r104 = 0;
        int r105 = 0;
    L13:
        if (r104 >= r101) goto L20;
        Object r106 = r103[r104];
        if (r106 == LongSparseArrayKt.access$getDELETED$p()) goto L19;
        if (r104 == r105) goto L18;
        r102[r105] = r102[r104];
        r103[r105] = r106;
        r103[r104] = null;
    L18:
        r105 = r105 + 1;
    L19:
        r104 = r104 + 1;
        goto L13
    L20:
        this.garbage = false;
        this.size = r105;
    L22:
        return (E) this.values[r110];
    L5:
        if (r110 >= this.size) goto L7;
        r100 = true;
        goto L8
    }

    public void append(long r110, E r111) {
        int r100 = this.size;
        if (r100 == 0) goto L8;
        if (r110 > this.keys[r100 - 1]) goto L8;
        put(r110, r111);
        return;
    L8:
        if (this.garbage == false) goto L20;
        long[] r101 = this.keys;
        if (r100 < r101.length) goto L20;
        Object[] r102 = this.values;
        int r103 = 0;
        int r104 = 0;
    L12:
        if (r103 >= r100) goto L19;
        Object r105 = r102[r103];
        if (r105 == LongSparseArrayKt.access$getDELETED$p()) goto L18;
        if (r103 == r104) goto L17;
        r101[r104] = r101[r103];
        r102[r104] = r105;
        r102[r103] = null;
    L17:
        r104 = r104 + 1;
    L18:
        r103 = r103 + 1;
        goto L12
    L19:
        this.garbage = false;
        this.size = r104;
    L20:
        int r106 = this.size;
        if (r106 < this.keys.length) goto L23;
        int r107 = ContainerHelpersKt.idealLongArraySize(r106 + 1);
        this.keys = Arrays.copyOf(this.keys, r107);
        this.values = Arrays.copyOf(this.values, r107);
    L23:
        this.keys[r106] = r110;
        this.values[r106] = r111;
        this.size = r106 + 1;
    }

    public E get(long r100, E r101) {
        int r102 = ContainerHelpersKt.binarySearch(this.keys, this.size, r100);
        if (r102 >= 0) goto L5;
        return r101;
    L5:
        if (this.values[r102] != LongSparseArrayKt.access$getDELETED$p()) goto L8;
        return r101;
    L8:
        return (E) this.values[r102];
    }

    public void put(long r110, E r111) {
        int r100 = ContainerHelpersKt.binarySearch(this.keys, this.size, r110);
        if (r100 < 0) goto L5;
        this.values[r100] = r111;
        return;
    L5:
        int r101 = ~r100;
        if (r101 >= this.size) goto L11;
        if (this.values[r101] != LongSparseArrayKt.access$getDELETED$p()) goto L11;
        this.keys[r101] = r110;
        this.values[r101] = r111;
        return;
    L11:
        if (this.garbage == false) goto L23;
        int r102 = this.size;
        long[] r103 = this.keys;
        if (r102 < r103.length) goto L23;
        Object[] r104 = this.values;
        int r105 = 0;
        int r106 = 0;
    L15:
        if (r105 >= r102) goto L22;
        Object r107 = r104[r105];
        if (r107 == LongSparseArrayKt.access$getDELETED$p()) goto L21;
        if (r105 == r106) goto L20;
        r103[r106] = r103[r105];
        r104[r106] = r107;
        r104[r105] = null;
    L20:
        r106 = r106 + 1;
    L21:
        r105 = r105 + 1;
        goto L15
    L22:
        this.garbage = false;
        this.size = r106;
        r101 = ~ContainerHelpersKt.binarySearch(this.keys, r106, r110);
    L23:
        int r108 = this.size;
        if (r108 < this.keys.length) goto L26;
        int r109 = ContainerHelpersKt.idealLongArraySize(r108 + 1);
        this.keys = Arrays.copyOf(this.keys, r109);
        this.values = Arrays.copyOf(this.values, r109);
    L26:
        int r112 = this.size;
        if ((r112 - r101) == 0) goto L29;
        long[] r113 = this.keys;
        int r114 = r101 + 1;
        ArraysKt.copyInto(r113, r113, r114, r101, r112);
        Object[] r115 = this.values;
        ArraysKt.copyInto(r115, r115, r114, r101, this.size);
    L29:
        this.keys[r101] = r110;
        this.values[r101] = r111;
        this.size++;
    }

    public E putIfAbsent(long r100, E r101) {
        E r102 = get(r100);
        if (r102 != null) goto L5;
        put(r100, r101);
    L5:
        return r102;
    }

    public boolean remove(long r100, E r101) {
        int r102 = indexOfKey(r100);
        if (r102 >= 0) goto L5;
    L7:
        return false;
    L5:
        if (Intrinsics.areEqual(r101, valueAt(r102)) == false) goto L7;
        removeAt(r102);
        return true;
    }

    public E replace(long r100, E r101) {
        int r102 = indexOfKey(r100);
        if (r102 < 0) goto L5;
        Object[] r103 = this.values;
        E r104 = (E) r103[r102];
        r103[r102] = r101;
        return r104;
    L5:
        return null;
    }

    public void setValueAt(int r110, E r111) {
        if (r110 >= 0) goto L5;
    L7:
        boolean r100 = false;
    L8:
        if (r100 == true) goto L11;
        RuntimeHelpersKt.throwIllegalArgumentException("Expected index to be within 0..size()-1, but was " + r110);
    L11:
        if (this.garbage == false) goto L21;
        int r101 = this.size;
        long[] r102 = this.keys;
        Object[] r103 = this.values;
        int r104 = 0;
        int r105 = 0;
    L13:
        if (r104 >= r101) goto L20;
        Object r106 = r103[r104];
        if (r106 == LongSparseArrayKt.access$getDELETED$p()) goto L19;
        if (r104 == r105) goto L18;
        r102[r105] = r102[r104];
        r103[r105] = r106;
        r103[r104] = null;
    L18:
        r105 = r105 + 1;
    L19:
        r104 = r104 + 1;
        goto L13
    L20:
        this.garbage = false;
        this.size = r105;
    L21:
        this.values[r110] = r111;
        return;
    L5:
        if (r110 >= this.size) goto L7;
        r100 = true;
        goto L8
    }

    public /* synthetic */ LongSparseArray(int r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = 10;
    L5:
        this(r100);
    }

    public boolean replace(long r100, E r101, E r102) {
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
