package androidx.compose.runtime.snapshots;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0016\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u000e\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\u0011\u001a\u00060\u0012j\u0002`\u00132\f\b\u0002\u0010\u0014\u001a\u00060\u0012j\u0002`\u0013¢\u0006\u0002\u0010\u0015J\u0017\u0010\u0016\u001a\u00020\u00052\n\u0010\u0004\u001a\u00060\u0012j\u0002`\u0013¢\u0006\u0002\u0010\u0017J\u000e\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0005J\b\u0010\u001b\u001a\u00020\u0019H\u0007J!\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00052\n\u0010\u0004\u001a\u00060\u0012j\u0002`\u0013H\u0007¢\u0006\u0002\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\u00192\u0006\u0010\r\u001a\u00020\u0005H\u0002J\u0010\u0010\u001f\u001a\u00020\u00192\u0006\u0010\r\u001a\u00020\u0005H\u0002J\u0018\u0010 \u001a\u00020\u00192\u0006\u0010!\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020\u0005H\u0002J\u0010\u0010#\u001a\u00020\u00192\u0006\u0010$\u001a\u00020\u0005H\u0002J\b\u0010%\u001a\u00020\u0005H\u0002J\u0010\u0010&\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0005H\u0002R\u001e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00060\nj\u0002`\u000bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Landroidx/compose/runtime/snapshots/SnapshotDoubleIndexHeap;", "", "<init>", "()V", "value", "", "size", "getSize", "()I", "values", "", "Landroidx/compose/runtime/snapshots/SnapshotIdArray;", "[J", "index", "", "handles", "firstFreeHandle", "lowestOrDefault", "", "Landroidx/compose/runtime/snapshots/SnapshotId;", "default", "(J)J", "add", "(J)I", "remove", "", "handle", com.alipay.sdk.m.l.c.f25505j, "validateHandle", "(IJ)V", "shiftUp", "shiftDown", "swap", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "ensure", "atLeast", "allocateHandle", "freeHandle", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SnapshotDoubleIndexHeap {
    public static final int $stable = 8;
    private int firstFreeHandle;
    private int[] handles;
    private int[] index;
    private int size;
    private long[] values;

    private final int allocateHandle() {
        int r100 = this.handles.length;
        if (this.firstFreeHandle < r100) goto L8;
        int r101 = r100 * 2;
        int[] r102 = new int[r101];
        int r103 = 0;
    L5:
        if (r103 >= r101) goto L7;
        int r104 = r103 + 1;
        r102[r103] = r104;
        r103 = r104;
        goto L5
    L7:
        ArraysKt.copyInto$default(this.handles, r102, 0, 0, 0, 14, null);
        this.handles = r102;
    L8:
        int r105 = this.firstFreeHandle;
        this.firstFreeHandle = this.handles[r105];
        return r105;
    }

    public final void validate() {
        int r100 = this.size;
        int r101 = 1;
    L3:
        if (r101 >= r100) goto L9;
        int r102 = r101 + 1;
        long[] r103 = this.values;
        if (Intrinsics.compare(r103[(r102 >> 1) - 1], r103[r101]) > 0) goto L8;
        r101 = r102;
        goto L3
    L8:
        throw new IllegalStateException(("Index " + r101 + " is out of place").toString());
    }

    public SnapshotDoubleIndexHeap() {
        this.values = SnapshotId_jvmKt.snapshotIdArrayWithCapacity(16);
        this.index = new int[16];
        int[] r100 = new int[16];
        int r101 = 0;
    L3:
        if (r101 >= 16) goto L5;
        int r102 = r101 + 1;
        r100[r101] = r102;
        r101 = r102;
        goto L3
    L5:
        this.handles = r100;
    }

    public final int getSize() {
        return this.size;
    }

    private final void ensure(int r100) {
        int r101 = this.values.length;
        if (r100 > r101) goto L5;
        return;
    L5:
        int r102 = r101 * 2;
        long[] r103 = SnapshotId_jvmKt.snapshotIdArrayWithCapacity(r102);
        int[] r104 = new int[r102];
        ArraysKt.copyInto$default(this.values, r103, 0, 0, 0, 12, null);
        ArraysKt.copyInto$default(this.index, r104, 0, 0, 0, 14, null);
        this.values = r103;
        this.index = r104;
    }

    private final void freeHandle(int r100) {
        this.handles[r100] = this.firstFreeHandle;
        this.firstFreeHandle = r100;
    }

    private final void shiftDown(int r100) {
        long[] r101 = this.values;
        int r102 = this.size >> 1;
    L3:
        if (r100 >= r102) goto L15;
        int r103 = (r100 + 1) << 1;
        int r104 = r103 - 1;
        if (r103 >= this.size) goto L13;
        if (Intrinsics.compare(r101[r103], r101[r104]) >= 0) goto L13;
        if (Intrinsics.compare(r101[r103], r101[r100]) >= 0) goto L11;
        swap(r103, r100);
        r100 = r103;
        goto L3
    L11:
        return;
    L13:
        if (Intrinsics.compare(r101[r104], r101[r100]) >= 0) goto L25;
        swap(r104, r100);
        r100 = r104;
        goto L3
    L25:
        return;
    }

    private final void shiftUp(int r100) {
        long[] r101 = this.values;
        long r102 = r101[r100];
    L3:
        if (r100 <= 0) goto L7;
        int r103 = ((r100 + 1) >> 1) - 1;
        if (Intrinsics.compare(r101[r103], r102) <= 0) goto L10;
        swap(r103, r100);
        r100 = r103;
        goto L3
    L10:
        return;
    }

    public final int add(long r100) {
        ensure(this.size + 1);
        int r101 = this.size;
        this.size = r101 + 1;
        int r102 = allocateHandle();
        this.values[r101] = r100;
        this.index[r101] = r102;
        this.handles[r102] = r101;
        shiftUp(r101);
        return r102;
    }

    public final long lowestOrDefault(long r100) {
        if (this.size > 0) goto L5;
        return r100;
    L5:
        return this.values[0];
    }

    public final void remove(int r100) {
        int r101 = this.handles[r100];
        swap(r101, this.size - 1);
        this.size--;
        shiftUp(r101);
        shiftDown(r101);
        freeHandle(r100);
    }

    private final void swap(int r100, int r101) {
        long[] r102 = this.values;
        int[] r103 = this.index;
        int[] r104 = this.handles;
        long r105 = r102[r100];
        r102[r100] = r102[r101];
        r102[r101] = r105;
        int r106 = r103[r100];
        int r107 = r103[r101];
        r103[r100] = r107;
        r103[r101] = r106;
        r104[r107] = r100;
        r104[r106] = r101;
    }

    public final void validateHandle(int r100, long r101) {
        int r102 = this.handles[r100];
        if (this.index[r102] != r100) goto L10;
        if (this.values[r102] != r101) goto L8;
        return;
    L8:
        throw new IllegalStateException(("Value for handle " + r100 + " was " + this.values[r102] + " but was supposed to be " + r101).toString());
    L10:
        throw new IllegalStateException(("Index for handle " + r100 + " is corrupted").toString());
    }

    public static /* synthetic */ long lowestOrDefault$default(SnapshotDoubleIndexHeap r100, long r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = 0;
    L6:
        return r100.lowestOrDefault(r101);
    }
}
