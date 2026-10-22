package ob;

import fi.iki.elonen.NanoHTTPD;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public abstract class g0 {

    /* renamed from: a, reason: collision with root package name */
    public static final f0 f7989a = new f0(new byte[0], 0, 0, false, false);

    /* renamed from: b, reason: collision with root package name */
    public static final int f7990b;

    /* renamed from: c, reason: collision with root package name */
    public static final AtomicReference[] f7991c;

    static {
        int iHighestOneBit = Integer.highestOneBit((Runtime.getRuntime().availableProcessors() * 2) - 1);
        f7990b = iHighestOneBit;
        AtomicReference[] atomicReferenceArr = new AtomicReference[iHighestOneBit];
        for (int i2 = 0; i2 < iHighestOneBit; i2++) {
            atomicReferenceArr[i2] = new AtomicReference();
        }
        f7991c = atomicReferenceArr;
    }

    public static final void a(f0 f0Var) {
        q7.k.e(f0Var, "segment");
        if (f0Var.f7980f != null || f0Var.f7981g != null) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        if (f0Var.f7978d) {
            return;
        }
        AtomicReference atomicReference = f7991c[(int) (Thread.currentThread().getId() & (f7990b - 1))];
        f0 f0Var2 = f7989a;
        f0 f0Var3 = (f0) atomicReference.getAndSet(f0Var2);
        if (f0Var3 == f0Var2) {
            return;
        }
        int i2 = f0Var3 != null ? f0Var3.f7977c : 0;
        if (i2 >= 65536) {
            atomicReference.set(f0Var3);
            return;
        }
        f0Var.f7980f = f0Var3;
        f0Var.f7976b = 0;
        f0Var.f7977c = i2 + NanoHTTPD.HTTPSession.BUFSIZE;
        atomicReference.set(f0Var);
    }

    public static final f0 b() {
        AtomicReference atomicReference = f7991c[(int) (Thread.currentThread().getId() & (f7990b - 1))];
        f0 f0Var = f7989a;
        f0 f0Var2 = (f0) atomicReference.getAndSet(f0Var);
        if (f0Var2 == f0Var) {
            return new f0();
        }
        if (f0Var2 == null) {
            atomicReference.set(null);
            return new f0();
        }
        atomicReference.set(f0Var2.f7980f);
        f0Var2.f7980f = null;
        f0Var2.f7977c = 0;
        return f0Var2;
    }
}
