package androidx.compose.runtime.snapshots;

import D7.q;
import androidx.compose.runtime.internal.StabilityInferred;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0016\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\t\u0010\bJ\u001f\u0010\f\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000f\u0010\bJ\u000f\u0010\u0010\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0013\u0010\bJ\u001f\u0010\u0017\u001a\u00060\u0014j\u0002`\u00152\f\b\u0002\u0010\u0016\u001a\u00060\u0014j\u0002`\u0015¢\u0006\u0004\b\u0017\u0010\u0018J\u0019\u0010\u001a\u001a\u00020\u00042\n\u0010\u0019\u001a\u00060\u0014j\u0002`\u0015¢\u0006\u0004\b\u001a\u0010\u001bJ\u0015\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0004¢\u0006\u0004\b\u001c\u0010\bJ\u000f\u0010\u001d\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\u001d\u0010\u0003J#\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00042\n\u0010\u0019\u001a\u00060\u0014j\u0002`\u0015H\u0007¢\u0006\u0004\b\u001e\u0010\u001fR$\u0010 \u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00048\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010\u0011R\u001a\u0010%\u001a\u00060#j\u0002`$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010\u0005\u001a\u00020'8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010(R\u0016\u0010)\u001a\u00020'8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010(R\u0016\u0010*\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010!¨\u0006+"}, d2 = {"Landroidx/compose/runtime/snapshots/SnapshotDoubleIndexHeap;", "", AppAgent.CONSTRUCT, "()V", "", "index", "LC7/r;", "shiftUp", "(I)V", "shiftDown", "a", "b", "swap", "(II)V", "atLeast", "ensure", "allocateHandle", "()I", "handle", "freeHandle", "", "Landroidx/compose/runtime/snapshots/SnapshotId;", "default", "lowestOrDefault", "(J)J", "value", "add", "(J)I", "remove", "validate", "validateHandle", "(IJ)V", "size", "I", "getSize", "", "Landroidx/compose/runtime/snapshots/SnapshotIdArray;", "values", "[J", "", "[I", "handles", "firstFreeHandle", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SnapshotDoubleIndexHeap {
    public static final int $stable = 8;
    private int firstFreeHandle;
    private int[] handles;
    private int size;
    private long[] values = SnapshotId_jvmKt.snapshotIdArrayWithCapacity(16);
    private int[] index = new int[16];

    public SnapshotDoubleIndexHeap() {
        int[] iArr = new int[16];
        int i = 0;
        while (i < 16) {
            int i6 = i + 1;
            iArr[i] = i6;
            i = i6;
        }
        this.handles = iArr;
    }

    private final int allocateHandle() {
        int length = this.handles.length;
        if (this.firstFreeHandle >= length) {
            int i = length * 2;
            int[] iArr = new int[i];
            int i6 = 0;
            while (i6 < i) {
                int i10 = i6 + 1;
                iArr[i6] = i10;
                i6 = i10;
            }
            q.Y(0, 0, this.handles, iArr, 14);
            this.handles = iArr;
        }
        int i11 = this.firstFreeHandle;
        this.firstFreeHandle = this.handles[i11];
        return i11;
    }

    private final void ensure(int atLeast) {
        int length = this.values.length;
        if (atLeast <= length) {
            return;
        }
        int i = length * 2;
        long[] jArrSnapshotIdArrayWithCapacity = SnapshotId_jvmKt.snapshotIdArrayWithCapacity(i);
        int[] iArr = new int[i];
        long[] jArr = this.values;
        q.W(jArr, jArrSnapshotIdArrayWithCapacity, 0, 0, jArr.length);
        q.Y(0, 0, this.index, iArr, 14);
        this.values = jArrSnapshotIdArrayWithCapacity;
        this.index = iArr;
    }

    private final void freeHandle(int handle) {
        this.handles[handle] = this.firstFreeHandle;
        this.firstFreeHandle = handle;
    }

    public static /* synthetic */ long lowestOrDefault$default(SnapshotDoubleIndexHeap snapshotDoubleIndexHeap, long j5, int i, Object obj) {
        if ((i & 1) != 0) {
            j5 = 0;
        }
        return snapshotDoubleIndexHeap.lowestOrDefault(j5);
    }

    private final void shiftDown(int index) {
        long[] jArr = this.values;
        int i = this.size >> 1;
        while (index < i) {
            int i6 = (index + 1) << 1;
            int i10 = i6 - 1;
            if (i6 >= this.size || k.h(jArr[i6], jArr[i10]) >= 0) {
                if (k.h(jArr[i10], jArr[index]) >= 0) {
                    return;
                }
                swap(i10, index);
                index = i10;
            } else {
                if (k.h(jArr[i6], jArr[index]) >= 0) {
                    return;
                }
                swap(i6, index);
                index = i6;
            }
        }
    }

    private final void shiftUp(int index) {
        long[] jArr = this.values;
        long j5 = jArr[index];
        while (index > 0) {
            int i = ((index + 1) >> 1) - 1;
            if (k.h(jArr[i], j5) <= 0) {
                return;
            }
            swap(i, index);
            index = i;
        }
    }

    private final void swap(int a3, int b) {
        long[] jArr = this.values;
        int[] iArr = this.index;
        int[] iArr2 = this.handles;
        long j5 = jArr[a3];
        jArr[a3] = jArr[b];
        jArr[b] = j5;
        int i = iArr[a3];
        int i6 = iArr[b];
        iArr[a3] = i6;
        iArr[b] = i;
        iArr2[i6] = a3;
        iArr2[i] = b;
    }

    public final int add(long value) {
        ensure(this.size + 1);
        int i = this.size;
        this.size = i + 1;
        int iAllocateHandle = allocateHandle();
        this.values[i] = value;
        this.index[i] = iAllocateHandle;
        this.handles[iAllocateHandle] = i;
        shiftUp(i);
        return iAllocateHandle;
    }

    public final int getSize() {
        return this.size;
    }

    public final long lowestOrDefault(long j5) {
        return this.size > 0 ? this.values[0] : j5;
    }

    public final void remove(int handle) {
        int i = this.handles[handle];
        swap(i, this.size - 1);
        this.size--;
        shiftUp(i);
        shiftDown(i);
        freeHandle(handle);
    }

    public final void validate() {
        int i = this.size;
        int i6 = 1;
        while (i6 < i) {
            int i10 = i6 + 1;
            long[] jArr = this.values;
            if (k.h(jArr[(i10 >> 1) - 1], jArr[i6]) > 0) {
                throw new IllegalStateException(("Index " + i6 + " is out of place").toString());
            }
            i6 = i10;
        }
    }

    public final void validateHandle(int handle, long value) {
        int i = this.handles[handle];
        if (this.index[i] != handle) {
            throw new IllegalStateException(("Index for handle " + handle + " is corrupted").toString());
        }
        if (this.values[i] == value) {
            return;
        }
        StringBuilder sbU = B7.a.u(handle, "Value for handle ", " was ");
        sbU.append(this.values[i]);
        sbU.append(" but was supposed to be ");
        sbU.append(value);
        throw new IllegalStateException(sbU.toString().toString());
    }
}
