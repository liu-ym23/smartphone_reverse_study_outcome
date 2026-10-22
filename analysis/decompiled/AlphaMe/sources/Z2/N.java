package Z2;

import d3.AbstractC0539a;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.Volatile;

/* loaded from: classes2.dex */
public final class N extends d3.u {

    /* renamed from: e, reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f2187e = AtomicIntegerFieldUpdater.newUpdater(N.class, "_decision");

    @Volatile
    private volatile int _decision;

    @Override // d3.u, Z2.x0
    public final void s(Object obj) {
        t(obj);
    }

    @Override // d3.u, Z2.x0
    public final void t(Object obj) {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater;
        do {
            atomicIntegerFieldUpdater = f2187e;
            int i4 = atomicIntegerFieldUpdater.get(this);
            if (i4 != 0) {
                if (i4 != 1) {
                    throw new IllegalStateException("Already resumed".toString());
                }
                AbstractC0539a.a(IntrinsicsKt.intercepted(this.f12479d), AbstractC0145t.a(obj), null);
                return;
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, 0, 2));
    }
}
