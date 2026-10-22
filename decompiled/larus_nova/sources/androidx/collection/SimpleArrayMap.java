package androidx.collection;

import androidx.collection.internal.ContainerHelpersKt;
import androidx.collection.internal.RuntimeHelpersKt;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.android.ec.slice.SliceInitService;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import faceverify.w;
import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0011\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b#\n\u0002\u0010\u000e\n\u0000\b\u0016\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003B\u0013\b\u0007\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007B#\b\u0016\u0012\u0018\u0010\b\u001a\u0014\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0006\b\u0001\u0012\u00028\u0001\u0018\u00010\u0000¢\u0006\u0004\b\u0006\u0010\tJ\u001d\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00028\u00002\u0006\u0010\u0012\u001a\u00020\u0005H\u0002¢\u0006\u0002\u0010\u0013J\b\u0010\u0014\u001a\u00020\u0005H\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0005H\u0016J\u0015\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0011\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001bJ\u0015\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001dJ\u0017\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00028\u0001H\u0001¢\u0006\u0004\b \u0010\u001dJ\u0015\u0010!\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u001bJ\u0018\u0010\"\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0011\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010#J\u001f\u0010$\u001a\u00028\u00012\b\u0010\u0011\u001a\u0004\u0018\u00010\u00032\u0006\u0010%\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010&J,\u0010'\u001a\u0002H(\"\n\b\u0002\u0010(*\u0004\u0018\u00018\u00012\b\u0010\u0011\u001a\u0004\u0018\u00010\u00032\u0006\u0010%\u001a\u0002H(H\u0082\b¢\u0006\u0002\u0010&J\u0015\u0010)\u001a\u00028\u00002\u0006\u0010*\u001a\u00020\u0005H\u0016¢\u0006\u0002\u0010+J\u0015\u0010,\u001a\u00028\u00012\u0006\u0010*\u001a\u00020\u0005H\u0016¢\u0006\u0002\u0010+J\u001d\u0010-\u001a\u00028\u00012\u0006\u0010*\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010.J\b\u0010/\u001a\u00020\u001aH\u0016J\u001f\u00100\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0011\u001a\u00028\u00002\u0006\u0010\u001f\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010&J \u00101\u001a\u00020\u00162\u0016\u0010\b\u001a\u0012\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0006\b\u0001\u0012\u00028\u00010\u0000H\u0016J\u001f\u00102\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0011\u001a\u00028\u00002\u0006\u0010\u001f\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010&J\u0017\u00103\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0011\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010#J\u001d\u00103\u001a\u00020\u001a2\u0006\u0010\u0011\u001a\u00028\u00002\u0006\u0010\u001f\u001a\u00028\u0001H\u0016¢\u0006\u0002\u00104J\u0015\u00105\u001a\u00028\u00012\u0006\u0010*\u001a\u00020\u0005H\u0016¢\u0006\u0002\u0010+J\u001f\u00106\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0011\u001a\u00028\u00002\u0006\u0010\u001f\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010&J%\u00106\u001a\u00020\u001a2\u0006\u0010\u0011\u001a\u00028\u00002\u0006\u00107\u001a\u00028\u00012\u0006\u00108\u001a\u00028\u0001H\u0016¢\u0006\u0002\u00109J\b\u0010\u000f\u001a\u00020\u0005H\u0016J\u0013\u0010:\u001a\u00020\u001a2\b\u0010;\u001a\u0004\u0018\u00010\u0003H\u0096\u0002J\b\u0010<\u001a\u00020\u0005H\u0016J\b\u0010=\u001a\u00020>H\u0016R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\rX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006?"}, d2 = {"Landroidx/collection/SimpleArrayMap;", "K", "V", "", "capacity", "", "<init>", "(I)V", "map", "(Landroidx/collection/SimpleArrayMap;)V", "hashes", "", "array", "", "[Ljava/lang/Object;", "size", "indexOf", "key", w.BLOB_ELEM_IMAGE_HASHCODE, "(Ljava/lang/Object;I)I", "indexOfNull", "clear", "", "ensureCapacity", "minimumCapacity", "containsKey", "", "(Ljava/lang/Object;)Z", "indexOfKey", "(Ljava/lang/Object;)I", "indexOfValue", "value", "__restricted$indexOfValue", "containsValue", MonitorConstants.CONNECT_TYPE_GET, "(Ljava/lang/Object;)Ljava/lang/Object;", "getOrDefault", "defaultValue", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "getOrDefaultInternal", ExifInterface.GPS_DIRECTION_TRUE, "keyAt", "index", "(I)Ljava/lang/Object;", "valueAt", "setValueAt", "(ILjava/lang/Object;)Ljava/lang/Object;", "isEmpty", "put", "putAll", "putIfAbsent", "remove", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "removeAt", "replace", "oldValue", "newValue", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Z", "equals", "other", "hashCode", "toString", "", "collection"}, k = 1, mv = {2, 0, 0}, xi = 48)
public class SimpleArrayMap<K, V> {
    private Object[] array;
    private int[] hashes;
    private int size;

    public SimpleArrayMap() {
        int r100 = 0;
        this(r100, 1, null);
    }

    private final int indexOfNull() {
        int r100 = this.size;
        if (r100 != 0) goto L6;
        return -1;
    L6:
        int r101 = ContainerHelpersKt.binarySearch(this.hashes, r100, 0);
        if (r101 >= 0) goto L10;
        return r101;
    L10:
        if (this.array[r101 << 1] != null) goto L12;
        return r101;
    L12:
        int r102 = r101 + 1;
    L13:
        if (r102 >= r100) goto L20;
        if (this.hashes[r102] != 0) goto L20;
        if (this.array[r102 << 1] == null) goto L18;
        r102 = r102 + 1;
        goto L13
    L18:
        return r102;
    L20:
        int r103 = r101 - 1;
    L21:
        if (r103 < 0) goto L29;
        if (this.hashes[r103] != 0) goto L29;
        if (this.array[r103 << 1] == null) goto L26;
        r103 = r103 - 1;
        goto L21
    L26:
        return r103;
    L29:
        return ~r102;
    }

    public void clear() {
        if (this.size <= 0) goto L6;
        this.hashes = ContainerHelpersKt.EMPTY_INTS;
        this.array = ContainerHelpersKt.EMPTY_OBJECTS;
        this.size = 0;
    L6:
        if (this.size > 0) goto L9;
        return;
    L9:
        throw new ConcurrentModificationException();
    }

    public int hashCode() {
        int[] r100 = this.hashes;
        Object[] r101 = this.array;
        int r102 = this.size;
        int r103 = 1;
        int r104 = 0;
        int r105 = 0;
    L3:
        if (r104 >= r102) goto L9;
        Object r106 = r101[r103];
        int r107 = r100[r104];
        if (r106 == null) goto L7;
        int r108 = r106.hashCode();
    L8:
        r105 = r105 + (r108 ^ r107);
        r104 = r104 + 1;
        r103 = r103 + 2;
        goto L3
    L7:
        r108 = 0;
        goto L8
    L9:
        return r105;
    }

    public boolean isEmpty() {
        if (this.size > 0) goto L5;
        return true;
    L5:
        return false;
    }

    public String toString() {
        if (isEmpty() == false) goto L6;
        return SliceInitService.DEFAULT_SWITCH;
    L6:
        StringBuilder r100 = new StringBuilder(this.size * 28);
        r100.append('{');
        int r101 = this.size;
        int r102 = 0;
    L7:
        if (r102 >= r101) goto L19;
        if (r102 <= 0) goto L10;
        r100.append(", ");
    L10:
        K r103 = keyAt(r102);
        if (r103 == r100) goto L13;
        r100.append(r103);
    L14:
        r100.append(com.alipay.sdk.m.n.a.f25612h);
        V r104 = valueAt(r102);
        if (r104 == r100) goto L17;
        r100.append(r104);
    L18:
        r102 = r102 + 1;
        goto L7
    L17:
        r100.append("(this Map)");
        goto L18
    L13:
        r100.append("(this Map)");
        goto L14
    L19:
        r100.append('}');
        return r100.toString();
    }

    public int size() {
        return this.size;
    }

    public SimpleArrayMap(int r100) {
        if (r100 != 0) goto L5;
        int[] r101 = ContainerHelpersKt.EMPTY_INTS;
    L6:
        this.hashes = r101;
        if (r100 != 0) goto L9;
        Object[] r102 = ContainerHelpersKt.EMPTY_OBJECTS;
    L10:
        this.array = r102;
        return;
    L9:
        r102 = new Object[r100 << 1];
        goto L10
    L5:
        r101 = new int[r100];
        goto L6
    }

    public final int __restricted$indexOfValue(V r100) {
        int r101 = this.size * 2;
        Object[] r102 = this.array;
        if (r100 != null) goto L11;
        int r103 = 1;
    L5:
        if (r103 >= r101) goto L18;
        if (r102[r103] == null) goto L9;
        r103 = r103 + 2;
        goto L5
    L9:
        return r103 >> 1;
    L18:
        return -1;
    L11:
        int r104 = 1;
    L12:
        if (r104 >= r101) goto L24;
        if (Intrinsics.areEqual(r100, r102[r104]) == true) goto L16;
        r104 = r104 + 2;
        goto L12
    L16:
        return r104 >> 1;
    L24:
        return -1;
    }

    public boolean containsKey(K r100) {
        if (indexOfKey(r100) < 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean containsValue(V r100) {
        if (__restricted$indexOfValue(r100) < 0) goto L5;
        return true;
    L5:
        return false;
    }

    public void ensureCapacity(int r100) {
        int r101 = this.size;
        int[] r102 = this.hashes;
        if (r102.length >= r100) goto L6;
        this.hashes = Arrays.copyOf(r102, r100);
        this.array = Arrays.copyOf(this.array, r100 * 2);
    L6:
        if (this.size != r101) goto L9;
        return;
    L9:
        throw new ConcurrentModificationException();
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L44;
        return true;
    L44:
        if ((r100 instanceof SimpleArrayMap) == false) goto L25;
        if (size() == ((SimpleArrayMap) r100).size()) goto L11;
        return false;
    L11:
        SimpleArrayMap r101 = (SimpleArrayMap) r100;     // Catch: Throwable -> L43
        int r102 = this.size;     // Catch: Throwable -> L43
        int r103 = 0;
    L12:
        if (r103 >= r102) goto L23;
        K r104 = keyAt(r103);     // Catch: Throwable -> L43
        V r105 = valueAt(r103);     // Catch: Throwable -> L43
        Object r106 = r101.get(r104);     // Catch: Throwable -> L43
        if (r105 != null) goto L20;
        if (r106 != null) goto L18;
        if (r101.containsKey(r104) == false) goto L18;
    L22:
        r103 = r103 + 1;     // Catch: Throwable -> L43
    L18:
        return false;
    L20:
        if (Intrinsics.areEqual(r105, r106) == true) goto L22;
        return false;
    L23:
        return true;
    L25:
        if ((r100 instanceof Map) == false) goto L42;
        if (size() == ((Map) r100).size()) goto L29;
        return false;
    L29:
        int r107 = this.size;     // Catch: Throwable -> L43
        int r108 = 0;
    L30:
        if (r108 >= r107) goto L41;
        K r109 = keyAt(r108);     // Catch: Throwable -> L43
        V r110 = valueAt(r108);     // Catch: Throwable -> L43
        Object r111 = ((Map) r100).get(r109);     // Catch: Throwable -> L43
        if (r110 != null) goto L38;
        if (r111 != null) goto L36;
        if (((Map) r100).containsKey(r109) == false) goto L36;
    L40:
        r108 = r108 + 1;
    L36:
        return false;
    L38:
        if (Intrinsics.areEqual(r110, r111) == true) goto L40;
        return false;
    L41:
        return true;
    L42:
        return false;
    }

    public V get(K r100) {
        int r101 = indexOfKey(r100);
        if (r101 >= 0) goto L7;
        return null;
    L7:
        return (V) this.array[(r101 << 1) + 1];
    }

    public int indexOfKey(K r100) {
        if (r100 != null) goto L5;
        return indexOfNull();
    L5:
        return indexOf(r100, r100.hashCode());
    }

    public K keyAt(int r100) {
        boolean r101 = false;
        if (r100 >= 0) goto L5;
    L7:
        if (r101 == true) goto L10;
        RuntimeHelpersKt.throwIllegalArgumentException("Expected index to be within 0..size()-1, but was " + r100);
    L10:
        return (K) this.array[r100 << 1];
    L5:
        if (r100 >= this.size) goto L7;
        r101 = true;
        goto L7
    }

    public void putAll(SimpleArrayMap<? extends K, ? extends V> r100) {
        Intrinsics.checkNotNullParameter(r100, "map");
        int r101 = r100.size;
        ensureCapacity(this.size + r101);
        int r102 = 0;
        if (this.size != 0) goto L6;
        if (r101 <= 0) goto L8;
        ArraysKt.copyInto(r100.hashes, this.hashes, 0, 0, r101);
        ArraysKt.copyInto(r100.array, this.array, 0, 0, r101 << 1);
        this.size = r101;
        return;
    L8:
        return;
    L6:
        if (r102 >= r101) goto L11;
        put(r100.keyAt(r102), r100.valueAt(r102));
        r102 = r102 + 1;
        goto L6
    }

    public V remove(K r100) {
        int r101 = indexOfKey(r100);
        if (r101 >= 0) goto L7;
        return null;
    L7:
        return removeAt(r101);
    }

    public V removeAt(int r110) {
        if (r110 >= 0) goto L5;
    L7:
        boolean r100 = false;
    L8:
        if (r100 == true) goto L10;
        RuntimeHelpersKt.throwIllegalArgumentException("Expected index to be within 0..size()-1, but was " + r110);
    L10:
        Object[] r101 = this.array;
        int r102 = r110 << 1;
        V r103 = (V) r101[r102 + 1];
        int r104 = this.size;
        if (r104 > 1) goto L13;
        clear();
    L33:
        return r103;
    L13:
        int r105 = r104 - 1;
        int[] r106 = this.hashes;
        int r107 = 8;
        if (r106.length > 8) goto L16;
    L27:
        if (r110 >= r105) goto L29;
        int r108 = r110 + 1;
        int r109 = r105 + 1;
        ArraysKt.copyInto(r106, r106, r110, r108, r109);
        Object[] r111 = this.array;
        ArraysKt.copyInto(r111, r111, r102, r108 << 1, r109 << 1);
    L29:
        Object[] r112 = this.array;
        int r113 = r105 << 1;
        r112[r113] = null;
        r112[r113 + 1] = null;
    L31:
        if (r104 != this.size) goto L35;
        this.size = r105;
        goto L33
    L35:
        throw new ConcurrentModificationException();
    L16:
        if (r104 >= (r106.length / 3)) goto L27;
        if (r104 <= 8) goto L19;
        r107 = r104 + (r104 >> 1);
    L19:
        this.hashes = Arrays.copyOf(r106, r107);
        this.array = Arrays.copyOf(this.array, r107 << 1);
        if (r104 != this.size) goto L26;
        if (r110 <= 0) goto L23;
        ArraysKt.copyInto(r106, this.hashes, 0, 0, r110);
        ArraysKt.copyInto(r101, this.array, 0, 0, r102);
    L23:
        if (r110 >= r105) goto L31;
        int r114 = r110 + 1;
        int r115 = r105 + 1;
        ArraysKt.copyInto(r106, this.hashes, r110, r114, r115);
        ArraysKt.copyInto(r101, this.array, r102, r114 << 1, r115 << 1);
        goto L31
    L26:
        throw new ConcurrentModificationException();
    L5:
        if (r110 >= this.size) goto L7;
        r100 = true;
        goto L8
    }

    public V valueAt(int r100) {
        boolean r101 = false;
        if (r100 >= 0) goto L5;
    L7:
        if (r101 == true) goto L10;
        RuntimeHelpersKt.throwIllegalArgumentException("Expected index to be within 0..size()-1, but was " + r100);
    L10:
        return (V) this.array[(r100 << 1) + 1];
    L5:
        if (r100 >= this.size) goto L7;
        r101 = true;
        goto L7
    }

    public SimpleArrayMap(SimpleArrayMap<? extends K, ? extends V> r100) {
        int r101 = 0;
        this(r101, 1, null);
        if (r100 == null) goto L6;
        putAll(r100);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final <T extends V> T getOrDefaultInternal(Object r100, T r101) {
        int r102 = indexOfKey(r100);
        if (r102 >= 0) goto L5;
        return r101;
    L5:
        return (T) this.array[(r102 << 1) + 1];
    }

    private final int indexOf(K r100, int r101) {
        int r102 = this.size;
        if (r102 != 0) goto L6;
        return -1;
    L6:
        int r103 = ContainerHelpersKt.binarySearch(this.hashes, r102, r101);
        if (r103 >= 0) goto L10;
        return r103;
    L10:
        if (Intrinsics.areEqual(r100, this.array[r103 << 1]) == false) goto L12;
        return r103;
    L12:
        int r104 = r103 + 1;
    L13:
        if (r104 >= r102) goto L20;
        if (this.hashes[r104] != r101) goto L20;
        if (Intrinsics.areEqual(r100, this.array[r104 << 1]) == true) goto L18;
        r104 = r104 + 1;
        goto L13
    L18:
        return r104;
    L20:
        int r105 = r103 - 1;
    L21:
        if (r105 < 0) goto L29;
        if (this.hashes[r105] != r101) goto L29;
        if (Intrinsics.areEqual(r100, this.array[r105 << 1]) == true) goto L26;
        r105 = r105 - 1;
        goto L21
    L26:
        return r105;
    L29:
        return ~r104;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public V getOrDefault(Object r100, V r101) {
        int r102 = indexOfKey(r100);
        if (r102 >= 0) goto L5;
        return r101;
    L5:
        return (V) this.array[(r102 << 1) + 1];
    }

    public V put(K r100, V r101) {
        int r102 = this.size;
        if (r100 == null) goto L5;
        int r103 = r100.hashCode();
    L6:
        if (r100 == null) goto L8;
        int r104 = indexOf(r100, r103);
    L9:
        if (r104 < 0) goto L12;
        int r105 = (r104 << 1) + 1;
        Object[] r106 = this.array;
        V r107 = (V) r106[r105];
        r106[r105] = r101;
        return r107;
    L12:
        int r108 = ~r104;
        int[] r109 = this.hashes;
        if (r102 < r109.length) goto L26;
        int r110 = 8;
        if (r102 < 8) goto L18;
        r110 = (r102 >> 1) + r102;
    L21:
        this.hashes = Arrays.copyOf(r109, r110);
        this.array = Arrays.copyOf(this.array, r110 << 1);
        if (r102 == this.size) goto L26;
        throw new ConcurrentModificationException();
    L18:
        if (r102 >= 4) goto L21;
        r110 = 4;
    L26:
        if (r108 >= r102) goto L28;
        int[] r111 = this.hashes;
        int r112 = r108 + 1;
        ArraysKt.copyInto(r111, r111, r112, r108, r102);
        Object[] r113 = this.array;
        ArraysKt.copyInto(r113, r113, r112 << 1, r108 << 1, this.size << 1);
    L28:
        int r114 = this.size;
        if (r102 != r114) goto L35;
        int[] r115 = this.hashes;
        if (r108 >= r115.length) goto L35;
        r115[r108] = r103;
        Object[] r116 = this.array;
        int r117 = r108 << 1;
        r116[r117] = r100;
        r116[r117 + 1] = r101;
        this.size = r114 + 1;
        return null;
    L35:
        throw new ConcurrentModificationException();
    L8:
        r104 = indexOfNull();
        goto L9
    L5:
        r103 = 0;
        goto L6
    }

    public V putIfAbsent(K r100, V r101) {
        V r102 = get(r100);
        if (r102 == null) goto L5;
        return r102;
    L5:
        return put(r100, r101);
    }

    public boolean remove(K r100, V r101) {
        int r102 = indexOfKey(r100);
        if (r102 >= 0) goto L5;
        return false;
    L5:
        if (Intrinsics.areEqual(r101, valueAt(r102)) == false) goto L10;
        removeAt(r102);
        return true;
    L10:
        return false;
    }

    public V replace(K r100, V r101) {
        int r102 = indexOfKey(r100);
        if (r102 >= 0) goto L7;
        return null;
    L7:
        return setValueAt(r102, r101);
    }

    public V setValueAt(int r100, V r101) {
        boolean r102 = false;
        if (r100 >= 0) goto L5;
    L7:
        if (r102 == true) goto L9;
        RuntimeHelpersKt.throwIllegalArgumentException("Expected index to be within 0..size()-1, but was " + r100);
    L9:
        int r103 = (r100 << 1) + 1;
        Object[] r104 = this.array;
        V r105 = (V) r104[r103];
        r104[r103] = r101;
        return r105;
    L5:
        if (r100 >= this.size) goto L7;
        r102 = true;
        goto L7
    }

    public /* synthetic */ SimpleArrayMap(int r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = 0;
    L5:
        this(r100);
    }

    public boolean replace(K r100, V r101, V r102) {
        int r103 = indexOfKey(r100);
        if (r103 >= 0) goto L5;
        return false;
    L5:
        if (Intrinsics.areEqual(r101, valueAt(r103)) == false) goto L10;
        setValueAt(r103, r102);
        return true;
    L10:
        return false;
    }
}
