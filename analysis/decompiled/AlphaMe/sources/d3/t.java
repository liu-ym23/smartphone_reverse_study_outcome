package d3;

import f3.C0559a;
import java.util.concurrent.atomic.AtomicReferenceArray;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;

/* loaded from: classes2.dex */
public final class t {

    @NotNull
    private volatile AtomicReferenceArray<Object> array;

    public t(int i4) {
        this.array = new AtomicReferenceArray<>(i4);
    }

    public final int a() {
        return this.array.length();
    }

    public final Object b(int i4) {
        AtomicReferenceArray<Object> atomicReferenceArray = this.array;
        if (i4 < atomicReferenceArray.length()) {
            return atomicReferenceArray.get(i4);
        }
        return null;
    }

    public final void c(int i4, C0559a c0559a) {
        AtomicReferenceArray<Object> atomicReferenceArray = this.array;
        int length = atomicReferenceArray.length();
        if (i4 < length) {
            atomicReferenceArray.set(i4, c0559a);
            return;
        }
        AtomicReferenceArray<Object> atomicReferenceArray2 = new AtomicReferenceArray<>(RangesKt.coerceAtLeast(i4 + 1, length * 2));
        for (int i5 = 0; i5 < length; i5++) {
            atomicReferenceArray2.set(i5, atomicReferenceArray.get(i5));
        }
        atomicReferenceArray2.set(i4, c0559a);
        this.array = atomicReferenceArray2;
    }
}
