package androidx.compose.runtime;

import androidx.compose.runtime.internal.StabilityInferred;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.util.Arrays;
import kotlin.Metadata;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0016\n\u0002\b\u0006\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J,\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0006H\u0082\b¢\u0006\u0004\b\t\u0010\nJ\u0018\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0086\u0002¢\u0006\u0004\b\f\u0010\rJ \u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000bH\u0086\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0014\u0010\u0013J\u001d\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0004¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001c\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\u001e\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001dR\u0016\u0010 \u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010!R\u0011\u0010$\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\"\u0010#¨\u0006%"}, d2 = {"Landroidx/compose/runtime/BitVector;", "", AppAgent.CONSTRUCT, "()V", "", "index", "Lkotlin/Function1;", "", "valueSelector", "nextBit", "(ILS7/k;)I", "", "get", "(I)Z", "value", "LC7/r;", "set", "(IZ)V", "nextSet", "(I)I", "nextClear", "start", "end", "setRange", "(II)V", "", "toString", "()Ljava/lang/String;", "first", "J", "second", "", "others", "[J", "getSize", "()I", "size", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class BitVector {
    public static final int $stable = 8;
    private long first;
    private long[] others = SlotTableKt.EmptyLongArray;
    private long second;

    private final int nextBit(int index, S7.k valueSelector) {
        int iNumberOfTrailingZeros;
        if (index < 64 && (iNumberOfTrailingZeros = Long.numberOfTrailingZeros((((Number) valueSelector.invoke(Long.valueOf(this.first))).longValue() >>> index) << index)) < 64) {
            return iNumberOfTrailingZeros;
        }
        if (index < 128) {
            int i = index - 64;
            int iNumberOfTrailingZeros2 = Long.numberOfTrailingZeros((((Number) valueSelector.invoke(Long.valueOf(this.second))).longValue() >>> i) << i);
            if (iNumberOfTrailingZeros2 < 64) {
                return iNumberOfTrailingZeros2 + 64;
            }
        }
        int iMax = Math.max(index, 128);
        int i6 = (iMax / 64) - 2;
        long[] jArr = this.others;
        int length = jArr.length;
        for (int i10 = i6; i10 < length; i10++) {
            long jLongValue = ((Number) valueSelector.invoke(Long.valueOf(jArr[i10]))).longValue();
            if (i10 == i6) {
                int i11 = iMax % 64;
                jLongValue = (jLongValue >>> i11) << i11;
            }
            int iNumberOfTrailingZeros3 = Long.numberOfTrailingZeros(jLongValue);
            if (iNumberOfTrailingZeros3 < 64) {
                return (i10 * 64) + 128 + iNumberOfTrailingZeros3;
            }
        }
        return Integer.MAX_VALUE;
    }

    public final boolean get(int index) {
        int i;
        if (index < 64) {
            return ((1 << index) & this.first) != 0;
        }
        if (index < 128) {
            return ((1 << (index - 64)) & this.second) != 0;
        }
        long[] jArr = this.others;
        int length = jArr.length;
        if (length != 0 && (index / 64) - 2 < length) {
            return ((1 << (index % 64)) & jArr[i]) != 0;
        }
        return false;
    }

    public final int getSize() {
        return (this.others.length + 2) * 64;
    }

    public final int nextClear(int index) {
        int iNumberOfTrailingZeros;
        if (index < 64 && (iNumberOfTrailingZeros = Long.numberOfTrailingZeros(((~this.first) >>> index) << index)) < 64) {
            return iNumberOfTrailingZeros;
        }
        if (index < 128) {
            int i = index - 64;
            int iNumberOfTrailingZeros2 = Long.numberOfTrailingZeros(((~this.second) >>> i) << i);
            if (iNumberOfTrailingZeros2 < 64) {
                return iNumberOfTrailingZeros2 + 64;
            }
        }
        int iMax = Math.max(index, 128);
        int i6 = (iMax / 64) - 2;
        long[] jArr = this.others;
        int length = jArr.length;
        for (int i10 = i6; i10 < length; i10++) {
            long j5 = ~jArr[i10];
            if (i10 == i6) {
                int i11 = iMax % 64;
                j5 = (j5 >>> i11) << i11;
            }
            int iNumberOfTrailingZeros3 = Long.numberOfTrailingZeros(j5);
            if (iNumberOfTrailingZeros3 < 64) {
                return (i10 * 64) + 128 + iNumberOfTrailingZeros3;
            }
        }
        return Integer.MAX_VALUE;
    }

    public final int nextSet(int index) {
        int iNumberOfTrailingZeros;
        if (index < 64 && (iNumberOfTrailingZeros = Long.numberOfTrailingZeros((this.first >>> index) << index)) < 64) {
            return iNumberOfTrailingZeros;
        }
        if (index < 128) {
            int i = index - 64;
            int iNumberOfTrailingZeros2 = Long.numberOfTrailingZeros((this.second >>> i) << i);
            if (iNumberOfTrailingZeros2 < 64) {
                return iNumberOfTrailingZeros2 + 64;
            }
        }
        int iMax = Math.max(index, 128);
        int i6 = (iMax / 64) - 2;
        long[] jArr = this.others;
        int length = jArr.length;
        for (int i10 = i6; i10 < length; i10++) {
            long j5 = jArr[i10];
            if (i10 == i6) {
                int i11 = iMax % 64;
                j5 = (j5 >>> i11) << i11;
            }
            int iNumberOfTrailingZeros3 = Long.numberOfTrailingZeros(j5);
            if (iNumberOfTrailingZeros3 < 64) {
                return (i10 * 64) + 128 + iNumberOfTrailingZeros3;
            }
        }
        return Integer.MAX_VALUE;
    }

    public final void set(int index, boolean value) {
        if (index < 64) {
            this.first = ((value ? 1L : 0L) << index) | ((~(1 << index)) & this.first);
            return;
        }
        if (index < 128) {
            this.second = ((value ? 1L : 0L) << index) | ((~(1 << (index - 64))) & this.second);
            return;
        }
        int i = index / 64;
        int i6 = i - 2;
        int i10 = index % 64;
        long j5 = 1 << i10;
        long[] jArrCopyOf = this.others;
        if (i6 >= jArrCopyOf.length) {
            jArrCopyOf = Arrays.copyOf(jArrCopyOf, i - 1);
            kotlin.jvm.internal.k.e(jArrCopyOf, "copyOf(...)");
            this.others = jArrCopyOf;
        }
        jArrCopyOf[i6] = ((value ? 1L : 0L) << i10) | ((~j5) & jArrCopyOf[i6]);
    }

    public final void setRange(int start, int end) {
        long j5 = start < end ? -1L : 0L;
        this.first = ((((start < 64 ? 1 : 0) * j5) >>> (64 - (Math.min(64, end) - start))) << start) | this.first;
        if (end > 64) {
            int iMax = Math.max(start, 64);
            this.second = (((j5 * (iMax < 128 ? 1 : 0)) >>> (128 - (Math.min(128, end) - iMax))) << iMax) | this.second;
            if (end > 128) {
                for (int iMax2 = Math.max(iMax, 128); iMax2 < end; iMax2++) {
                    set(iMax2, true);
                }
            }
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("BitVector [");
        int size = getSize();
        boolean z10 = true;
        for (int i = 0; i < size; i++) {
            if (get(i)) {
                if (!z10) {
                    sb.append(", ");
                }
                sb.append(i);
                z10 = false;
            }
        }
        return androidx.appfunctions.metadata.a.h(']', "toString(...)", sb);
    }
}
