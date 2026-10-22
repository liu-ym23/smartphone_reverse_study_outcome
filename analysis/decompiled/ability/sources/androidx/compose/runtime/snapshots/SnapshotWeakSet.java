package androidx.compose.runtime.snapshots;

import D7.q;
import S7.k;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.runtime.internal.System_jvmKt;
import androidx.compose.runtime.internal.WeakReference;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0015\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0001\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\b\u0010\tJ'\u0010\f\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00028\u00002\u0006\u0010\u000b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00028\u0000¢\u0006\u0004\b\u000f\u0010\u0010J$\u0010\u0014\u001a\u00020\u00132\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u000e0\u0011H\u0086\b¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0018\u001a\u00020\u000eH\u0001¢\u0006\u0004\b\u0016\u0010\u0017R\"\u0010\u0019\u001a\u00020\u00068\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\"\u0010 \u001a\u00020\u001f8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R0\u0010(\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010'0&8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-¨\u0006."}, d2 = {"Landroidx/compose/runtime/snapshots/SnapshotWeakSet;", "", ExifInterface.GPS_DIRECTION_TRUE, AppAgent.CONSTRUCT, "()V", "value", "", "hash", "find", "(Ljava/lang/Object;I)I", "midIndex", "valueHash", "findExactIndex", "(ILjava/lang/Object;I)I", "", "add", "(Ljava/lang/Object;)Z", "Lkotlin/Function1;", "block", "LC7/r;", "removeIf", "(LS7/k;)V", "isValid$runtime", "()Z", "isValid", "size", "I", "getSize$runtime", "()I", "setSize$runtime", "(I)V", "", "hashes", "[I", "getHashes$runtime", "()[I", "setHashes$runtime", "([I)V", "", "Landroidx/compose/runtime/internal/WeakReference;", "values", "[Landroidx/compose/runtime/internal/WeakReference;", "getValues$runtime", "()[Landroidx/compose/runtime/internal/WeakReference;", "setValues$runtime", "([Landroidx/compose/runtime/internal/WeakReference;)V", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SnapshotWeakSet<T> {
    public static final int $stable = 8;
    private int size;
    private int[] hashes = new int[16];
    private WeakReference<T>[] values = new WeakReference[16];

    private final int find(T value, int hash) {
        int i = this.size - 1;
        int i6 = 0;
        while (i6 <= i) {
            int i10 = (i6 + i) >>> 1;
            int i11 = this.hashes[i10];
            if (i11 < hash) {
                i6 = i10 + 1;
            } else {
                if (i11 <= hash) {
                    WeakReference<T> weakReference = this.values[i10];
                    return value == (weakReference != null ? weakReference.get() : null) ? i10 : findExactIndex(i10, value, hash);
                }
                i = i10 - 1;
            }
        }
        return -(i6 + 1);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x001d, code lost:
    
        r4 = r4 + 1;
        r0 = r3.size;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0021, code lost:
    
        if (r4 >= r0) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0027, code lost:
    
        if (r3.hashes[r4] == r6) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x002c, code lost:
    
        return -(r4 + 1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x002d, code lost:
    
        r2 = r3.values[r4];
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0031, code lost:
    
        if (r2 == null) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0033, code lost:
    
        r2 = r2.get();
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0038, code lost:
    
        r2 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0039, code lost:
    
        if (r2 != r5) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x003b, code lost:
    
        return r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x003c, code lost:
    
        r4 = r4 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0044, code lost:
    
        return -(r3.size + 1);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final int findExactIndex(int r4, T r5, int r6) {
        /*
            r3 = this;
            int r0 = r4 + (-1)
        L2:
            r1 = 0
            r2 = -1
            if (r2 >= r0) goto L1d
            int[] r2 = r3.hashes
            r2 = r2[r0]
            if (r2 == r6) goto Ld
            goto L1d
        Ld:
            androidx.compose.runtime.internal.WeakReference<T>[] r2 = r3.values
            r2 = r2[r0]
            if (r2 == 0) goto L17
            java.lang.Object r1 = r2.get()
        L17:
            if (r1 != r5) goto L1a
            return r0
        L1a:
            int r0 = r0 + (-1)
            goto L2
        L1d:
            int r4 = r4 + 1
            int r0 = r3.size
        L21:
            if (r4 >= r0) goto L3f
            int[] r2 = r3.hashes
            r2 = r2[r4]
            if (r2 == r6) goto L2d
            int r4 = r4 + 1
            int r3 = -r4
            return r3
        L2d:
            androidx.compose.runtime.internal.WeakReference<T>[] r2 = r3.values
            r2 = r2[r4]
            if (r2 == 0) goto L38
            java.lang.Object r2 = r2.get()
            goto L39
        L38:
            r2 = r1
        L39:
            if (r2 != r5) goto L3c
            return r4
        L3c:
            int r4 = r4 + 1
            goto L21
        L3f:
            int r3 = r3.size
            int r3 = r3 + 1
            int r3 = -r3
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.snapshots.SnapshotWeakSet.findExactIndex(int, java.lang.Object, int):int");
    }

    public final boolean add(T value) {
        int iFind;
        int i = this.size;
        int iIdentityHashCode = System_jvmKt.identityHashCode(value);
        if (i > 0) {
            iFind = find(value, iIdentityHashCode);
            if (iFind >= 0) {
                return false;
            }
        } else {
            iFind = -1;
        }
        int i6 = -(iFind + 1);
        WeakReference<T>[] weakReferenceArr = this.values;
        int length = weakReferenceArr.length;
        if (i == length) {
            int i10 = length * 2;
            WeakReference<T>[] weakReferenceArr2 = new WeakReference[i10];
            int[] iArr = new int[i10];
            int i11 = i6 + 1;
            System.arraycopy(weakReferenceArr, i6, weakReferenceArr2, i11, i - i6);
            System.arraycopy(this.values, 0, weakReferenceArr2, 0, i6);
            q.R(i11, i6, this.hashes, iArr, i);
            q.Y(0, i6, this.hashes, iArr, 6);
            this.values = weakReferenceArr2;
            this.hashes = iArr;
        } else {
            int i12 = i6 + 1;
            System.arraycopy(weakReferenceArr, i6, weakReferenceArr, i12, i - i6);
            int[] iArr2 = this.hashes;
            q.R(i12, i6, iArr2, iArr2, i);
        }
        this.values[i6] = new WeakReference<>(value);
        this.hashes[i6] = iIdentityHashCode;
        this.size++;
        return true;
    }

    /* renamed from: getHashes$runtime, reason: from getter */
    public final int[] getHashes() {
        return this.hashes;
    }

    /* renamed from: getSize$runtime, reason: from getter */
    public final int getSize() {
        return this.size;
    }

    public final WeakReference<T>[] getValues$runtime() {
        return this.values;
    }

    public final boolean isValid$runtime() {
        WeakReference<T> weakReference;
        int i = this.size;
        WeakReference<T>[] weakReferenceArr = this.values;
        int[] iArr = this.hashes;
        int length = weakReferenceArr.length;
        if (i > length) {
            return false;
        }
        int i6 = Integer.MIN_VALUE;
        int i10 = 0;
        while (i10 < i) {
            int i11 = iArr[i10];
            if (i11 < i6 || (weakReference = weakReferenceArr[i10]) == null) {
                return false;
            }
            T t9 = weakReference.get();
            if (t9 != null && i11 != System_jvmKt.identityHashCode(t9)) {
                return false;
            }
            i10++;
            i6 = i11;
        }
        while (i < length) {
            if (iArr[i] != 0 || weakReferenceArr[i] != null) {
                return false;
            }
            i++;
        }
        return true;
    }

    public final void removeIf(k block) {
        int size = getSize();
        int i = 0;
        int i6 = 0;
        while (true) {
            if (i >= size) {
                break;
            }
            WeakReference<T> weakReference = getValues$runtime()[i];
            T t9 = weakReference != null ? weakReference.get() : null;
            if (t9 != null && !((Boolean) block.invoke(t9)).booleanValue()) {
                if (i6 != i) {
                    getValues$runtime()[i6] = weakReference;
                    getHashes()[i6] = getHashes()[i];
                }
                i6++;
            }
            i++;
        }
        for (int i10 = i6; i10 < size; i10++) {
            getValues$runtime()[i10] = null;
            getHashes()[i10] = 0;
        }
        if (i6 != size) {
            setSize$runtime(i6);
        }
    }

    public final void setHashes$runtime(int[] iArr) {
        this.hashes = iArr;
    }

    public final void setSize$runtime(int i) {
        this.size = i;
    }

    public final void setValues$runtime(WeakReference<T>[] weakReferenceArr) {
        this.values = weakReferenceArr;
    }
}
