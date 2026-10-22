package V9;

import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes4.dex */
public abstract class t {

    /* renamed from: a, reason: collision with root package name */
    public static final s f1427a = new s(new byte[0], 0, 0, false);
    public static final int b;
    public static final AtomicReference[] c;

    static {
        int iHighestOneBit = Integer.highestOneBit((Runtime.getRuntime().availableProcessors() * 2) - 1);
        b = iHighestOneBit;
        AtomicReference[] atomicReferenceArr = new AtomicReference[iHighestOneBit];
        for (int i = 0; i < iHighestOneBit; i++) {
            atomicReferenceArr[i] = new AtomicReference();
        }
        c = atomicReferenceArr;
    }

    public static final void a(s segment) {
        kotlin.jvm.internal.k.f(segment, "segment");
        if (segment.f != null || segment.g != null) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        if (segment.d) {
            return;
        }
        AtomicReference atomicReference = c[(int) (Thread.currentThread().getId() & (b - 1))];
        s sVar = f1427a;
        s sVar2 = (s) atomicReference.getAndSet(sVar);
        if (sVar2 == sVar) {
            return;
        }
        int i = sVar2 != null ? sVar2.c : 0;
        if (i >= 65536) {
            atomicReference.set(sVar2);
            return;
        }
        segment.f = sVar2;
        segment.b = 0;
        segment.c = i + 8192;
        atomicReference.set(segment);
    }

    public static final s b() {
        AtomicReference atomicReference = c[(int) (Thread.currentThread().getId() & (b - 1))];
        s sVar = f1427a;
        s sVar2 = (s) atomicReference.getAndSet(sVar);
        if (sVar2 == sVar) {
            return new s();
        }
        if (sVar2 == null) {
            atomicReference.set(null);
            return new s();
        }
        atomicReference.set(sVar2.f);
        sVar2.f = null;
        sVar2.c = 0;
        return sVar2;
    }
}
