package s9;

import java.util.concurrent.atomic.AtomicReferenceArray;
import u9.C2051a;

/* loaded from: classes4.dex */
public final class n {
    private volatile AtomicReferenceArray<Object> array;

    public n(int i) {
        this.array = new AtomicReferenceArray<>(i);
    }

    public final int a() {
        return this.array.length();
    }

    public final Object b(int i) {
        AtomicReferenceArray<Object> atomicReferenceArray = this.array;
        if (i < atomicReferenceArray.length()) {
            return atomicReferenceArray.get(i);
        }
        return null;
    }

    public final void c(int i, C2051a c2051a) {
        AtomicReferenceArray<Object> atomicReferenceArray = this.array;
        int length = atomicReferenceArray.length();
        if (i < length) {
            atomicReferenceArray.set(i, c2051a);
            return;
        }
        int i6 = i + 1;
        int i10 = length * 2;
        if (i6 < i10) {
            i6 = i10;
        }
        AtomicReferenceArray<Object> atomicReferenceArray2 = new AtomicReferenceArray<>(i6);
        for (int i11 = 0; i11 < length; i11++) {
            atomicReferenceArray2.set(i11, atomicReferenceArray.get(i11));
        }
        atomicReferenceArray2.set(i, c2051a);
        this.array = atomicReferenceArray2;
    }
}
