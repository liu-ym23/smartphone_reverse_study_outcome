package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.jvm.Volatile;

/* JADX INFO: loaded from: classes4.dex */
public final class i0 extends kotlinx.coroutines.internal.x {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f21566e = null;

    @Volatile
    private volatile int _decision;

    static {
        f21566e = AtomicIntegerFieldUpdater.newUpdater(i0.class, "_decision");
    }

    public i0(CoroutineContext r10, Continuation r11) {
        super(r10, r11);
    }

    private final boolean s0() {
        AtomicIntegerFieldUpdater r10 = f21566e;
    L3:
        int r11 = r10.get(this);
        if (r11 != 0) goto L5;
        if (f21566e.compareAndSet(this, 0, 2) == false) goto L3;
        return true;
    L5:
        if (r11 != 1) goto L8;
        return false;
    L8:
        throw new IllegalStateException("Already resumed");
    }

    private final boolean t0() {
        AtomicIntegerFieldUpdater r10 = f21566e;
    L3:
        int r11 = r10.get(this);
        if (r11 != 0) goto L6;
        if (f21566e.compareAndSet(this, 0, 1) == false) goto L3;
        return true;
    L6:
        if (r11 != 2) goto L9;
        return false;
    L9:
        throw new IllegalStateException("Already suspended");
    }

    @Override // kotlinx.coroutines.internal.x, kotlinx.coroutines.JobSupport
    public void h(Object r10) {
        n0(r10);
    }

    @Override // kotlinx.coroutines.internal.x, kotlinx.coroutines.a
    public void n0(Object r10) {
        if (s0() == false) goto L5;
        return;
    L5:
        kotlinx.coroutines.internal.j.c(IntrinsicsKt__IntrinsicsJvmKt.c(this.f21628d), z.a(r10, this.f21628d), null, 2, null);
    }

    public final Object r0() {
        if (t0() == true) goto L5;
        Object r10 = l1.h(E());
        if ((r10 instanceof w) == true) goto L10;
        return r10;
    L10:
        throw ((w) r10).f21768a;
    L5:
        return kotlin.coroutines.intrinsics.a.d();
    }
}
