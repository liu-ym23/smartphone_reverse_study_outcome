package od;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class e0 {

    /* renamed from: a, reason: collision with root package name */
    public static final d0 f9444a = new d0(new byte[0], 0, 0, false);

    /* renamed from: b, reason: collision with root package name */
    public static final int f9445b;

    /* renamed from: c, reason: collision with root package name */
    public static final AtomicReference[] f9446c;

    static {
        int iHighestOneBit = Integer.highestOneBit((Runtime.getRuntime().availableProcessors() * 2) - 1);
        f9445b = iHighestOneBit;
        AtomicReference[] atomicReferenceArr = new AtomicReference[iHighestOneBit];
        for (int i = 0; i < iHighestOneBit; i++) {
            atomicReferenceArr[i] = new AtomicReference();
        }
        f9446c = atomicReferenceArr;
    }

    public static final void a(d0 d0Var) {
        d0Var.getClass();
        if (d0Var.f9442f != null || d0Var.f9443g != null) {
            g5.f.s("Failed requirement.");
            return;
        }
        if (d0Var.f9440d) {
            return;
        }
        AtomicReference atomicReference = f9446c[(int) (Thread.currentThread().getId() & (f9445b - 1))];
        d0 d0Var2 = f9444a;
        d0 d0Var3 = (d0) atomicReference.getAndSet(d0Var2);
        if (d0Var3 == d0Var2) {
            return;
        }
        int i = d0Var3 != null ? d0Var3.f9439c : 0;
        if (i >= 65536) {
            atomicReference.set(d0Var3);
            return;
        }
        d0Var.f9442f = d0Var3;
        d0Var.f9438b = 0;
        d0Var.f9439c = i + 8192;
        atomicReference.set(d0Var);
    }

    public static final d0 b() {
        AtomicReference atomicReference = f9446c[(int) (Thread.currentThread().getId() & (f9445b - 1))];
        d0 d0Var = f9444a;
        d0 d0Var2 = (d0) atomicReference.getAndSet(d0Var);
        if (d0Var2 == d0Var) {
            return new d0();
        }
        if (d0Var2 == null) {
            atomicReference.set(null);
            return new d0();
        }
        atomicReference.set(d0Var2.f9442f);
        d0Var2.f9442f = null;
        d0Var2.f9439c = 0;
        return d0Var2;
    }
}
