package androidx.compose.runtime.snapshots;

import androidx.compose.runtime.internal.System_jvmKt;
import androidx.compose.runtime.internal.WeakReference;
import androidx.exifinterface.media.ExifInterface;
import faceverify.w;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0001\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0013\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00028\u0000¢\u0006\u0002\u0010\u001cJ\u001d\u0010\u001d\u001a\u00020\u001e2\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u001a0 H\u0086\bJ\u001d\u0010!\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00028\u00002\u0006\u0010\"\u001a\u00020\u0006H\u0002¢\u0006\u0002\u0010#J%\u0010$\u001a\u00020\u00062\u0006\u0010%\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00028\u00002\u0006\u0010&\u001a\u00020\u0006H\u0002¢\u0006\u0002\u0010'J\r\u0010(\u001a\u00020\u001aH\u0001¢\u0006\u0002\b)R\u001a\u0010\u0005\u001a\u00020\u0006X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R*\u0010\u0011\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00130\u0012X\u0080\u000e¢\u0006\u0010\n\u0002\u0010\u0018\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006*"}, d2 = {"Landroidx/compose/runtime/snapshots/SnapshotWeakSet;", ExifInterface.GPS_DIRECTION_TRUE, "", "<init>", "()V", "size", "", "getSize$runtime", "()I", "setSize$runtime", "(I)V", "hashes", "", "getHashes$runtime", "()[I", "setHashes$runtime", "([I)V", "values", "", "Landroidx/compose/runtime/internal/WeakReference;", "getValues$runtime", "()[Landroidx/compose/runtime/internal/WeakReference;", "setValues$runtime", "([Landroidx/compose/runtime/internal/WeakReference;)V", "[Landroidx/compose/runtime/internal/WeakReference;", "add", "", "value", "(Ljava/lang/Object;)Z", "removeIf", "", "block", "Lkotlin/Function1;", "find", w.BLOB_ELEM_IMAGE_HASHCODE, "(Ljava/lang/Object;I)I", "findExactIndex", "midIndex", "valueHash", "(ILjava/lang/Object;I)I", "isValid", "isValid$runtime", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SnapshotWeakSet<T> {
    public static final int $stable = 8;
    private int[] hashes;
    private int size;
    private WeakReference<T>[] values;

    public final boolean isValid$runtime() {
        int r100 = this.size;
        WeakReference<T>[] r101 = this.values;
        int[] r102 = this.hashes;
        int r103 = r101.length;
        if (r100 <= r103) goto L5;
        return false;
    L5:
        int r104 = Integer.MIN_VALUE;
        int r105 = 0;
    L6:
        if (r105 >= r100) goto L19;
        int r106 = r102[r105];
        if (r106 < r104) goto L9;
        WeakReference<T> r107 = r101[r105];
        if (r107 == null) goto L12;
        T r108 = r107.get();
        if (r108 == null) goto L18;
        if (r106 == System_jvmKt.identityHashCode(r108)) goto L18;
        return false;
    L18:
        r105 = r105 + 1;
        r104 = r106;
        goto L6
    L12:
        return false;
    L9:
        return false;
    L19:
        if (r100 >= r103) goto L27;
        if (r102[r100] != 0) goto L22;
        if (r101[r100] != null) goto L25;
        r100 = r100 + 1;
        goto L19
    L25:
        return false;
    L22:
        return false;
    L27:
        return true;
    }

    public SnapshotWeakSet() {
        this.hashes = new int[16];
        this.values = new WeakReference[16];
    }

    public final int[] getHashes$runtime() {
        return this.hashes;
    }

    public final int getSize$runtime() {
        return this.size;
    }

    public final WeakReference<T>[] getValues$runtime() {
        return this.values;
    }

    public final boolean add(T r110) {
        int r100 = this.size;
        int r101 = System_jvmKt.identityHashCode(r110);
        if (r100 <= 0) goto L7;
        int r102 = find(r110, r101);
        if (r102 < 0) goto L8;
        return false;
    L8:
        int r103 = -(r102 + 1);
        WeakReference<T>[] r104 = this.values;
        int r105 = r104.length;
        if (r100 != r105) goto L11;
        int r106 = r105 * 2;
        WeakReference<T>[] r111 = new WeakReference[r106];
        int[] r112 = new int[r106];
        int r107 = r103 + 1;
        System.arraycopy(r104, r103, r111, r107, r100 - r103);
        System.arraycopy(this.values, 0, r111, 0, r103 + 0);
        ArraysKt.copyInto(this.hashes, r112, r107, r103, r100);
        ArraysKt.copyInto$default(this.hashes, r112, 0, 0, r103, 6, null);
        this.values = r111;
        this.hashes = r112;
    L12:
        this.values[r103] = new WeakReference(r110);
        this.hashes[r103] = r101;
        this.size++;
        return true;
    L11:
        int r108 = r103 + 1;
        System.arraycopy(r104, r103, r104, r108, r100 - r103);
        int[] r109 = this.hashes;
        ArraysKt.copyInto(r109, r109, r108, r103, r100);
        goto L12
    L7:
        r102 = -1;
        goto L8
    }

    public final void removeIf(Function1<? super T, Boolean> r100) {
        int r101 = getSize$runtime();
        int r102 = 0;
        int r103 = 0;
    L3:
        T r104 = null;
        if (r102 >= r101) goto L15;
        WeakReference<T> r105 = getValues$runtime()[r102];
        if (r105 == null) goto L8;
        r104 = r105.get();
    L8:
        if (r104 == null) goto L14;
        if (r100.invoke(r104).booleanValue() == true) goto L14;
        if (r103 == r102) goto L13;
        getValues$runtime()[r103] = r105;
        getHashes$runtime()[r103] = getHashes$runtime()[r102];
    L13:
        r103 = r103 + 1;
    L14:
        r102 = r102 + 1;
        goto L3
    L15:
        int r106 = r103;
    L16:
        if (r106 >= r101) goto L18;
        getValues$runtime()[r106] = null;
        getHashes$runtime()[r106] = 0;
        r106 = r106 + 1;
        goto L16
    L18:
        if (r103 == r101) goto L26;
        setSize$runtime(r103);
        return;
    }

    public final void setHashes$runtime(int[] r100) {
        this.hashes = r100;
    }

    public final void setSize$runtime(int r100) {
        this.size = r100;
    }

    public final void setValues$runtime(WeakReference<T>[] r100) {
        this.values = r100;
    }

    private final int find(T r100, int r101) {
        int r102 = this.size - 1;
        int r103 = 0;
    L3:
        if (r103 > r102) goto L18;
        int r104 = (r103 + r102) >>> 1;
        int r105 = this.hashes[r104];
        if (r105 < r101) goto L6;
        if (r105 <= r101) goto L9;
        r102 = r104 - 1;
        goto L3
    L9:
        WeakReference<T> r106 = this.values[r104];
        if (r106 == null) goto L12;
        T r107 = r106.get();
    L13:
        if (r100 != r107) goto L16;
        return r104;
    L16:
        return findExactIndex(r104, r100, r101);
    L12:
        r107 = null;
        goto L13
    L6:
        r103 = r104 + 1;
        goto L3
    L18:
        return -(r103 + 1);
    }

    private final int findExactIndex(int r100, T r101, int r102) {
        int r103 = r100 - 1;
    L3:
        T r104 = null;
        if ((-1) >= r103) goto L14;
        if (this.hashes[r103] != r102) goto L14;
        WeakReference<T> r105 = this.values[r103];
        if (r105 == null) goto L11;
        r104 = r105.get();
    L11:
        if (r104 == r101) goto L12;
        r103 = r103 - 1;
        goto L3
    L12:
        return r103;
    L14:
        int r106 = r100 + 1;
        int r107 = this.size;
    L15:
        if (r106 >= r107) goto L27;
        if (this.hashes[r106] != r102) goto L19;
        WeakReference<T> r108 = this.values[r106];
        if (r108 == null) goto L23;
        T r109 = r108.get();
    L24:
        if (r109 == r101) goto L25;
        r106 = r106 + 1;
        goto L15
    L25:
        return r106;
    L23:
        r109 = null;
    L19:
        return -(r106 + 1);
    L27:
        r106 = this.size;
        goto L19
    }
}
