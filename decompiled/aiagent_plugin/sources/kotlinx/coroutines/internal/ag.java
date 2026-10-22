package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicReferenceArray;

/* JADX INFO: compiled from: ResizableAtomicArray.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class ag<T> {
    private volatile AtomicReferenceArray<T> array;

    public ag(int r2) {
        this.array = new AtomicReferenceArray(r2);
    }

    public final int a() {
        return this.array.length();
    }

    public final T a(int r2) {
        AtomicReferenceArray<T> r1 = this.array;
        if (r2 < r1.length()) goto L7;
        return null;
    L7:
        return r1.get(r2);
    }

    public final void a(int r6, T r7) {
        AtomicReferenceArray<T> r0 = this.array;
        int r1 = r0.length();
        if (r6 >= r1) goto L6;
        r0.set(r6, r7);
        return;
    L6:
        AtomicReferenceArray<T> r2 = new AtomicReferenceArray(d.l.n.c(r6 + 1, r1 * 2));
        int r3 = 0;
    L7:
        if (r3 >= r1) goto L9;
        r2.set(r3, r0.get(r3));
        r3 = r3 + 1;
        goto L7
    L9:
        r2.set(r6, r7);
        this.array = r2;
    }
}
