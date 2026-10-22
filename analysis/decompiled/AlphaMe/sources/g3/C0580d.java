package g3;

import X.r;
import Z2.C0128h;
import Z2.I;
import a3.C0157b;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.Volatile;
import org.jetbrains.annotations.Nullable;

/* renamed from: g3.d, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0580d extends h implements InterfaceC0577a {

    /* renamed from: h, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f12667h = AtomicReferenceFieldUpdater.newUpdater(C0580d.class, Object.class, "owner");

    @Volatile
    @Nullable
    private volatile Object owner;

    public C0580d(boolean z4) {
        super(z4 ? 1 : 0);
        this.owner = z4 ? null : AbstractC0581e.f12668a;
        new C0157b(1, this);
    }

    public final boolean c() {
        return Math.max(h.f12675g.get(this), 0) == 0;
    }

    public final Object d(Continuation continuation) {
        int i4;
        char c4;
        while (true) {
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = h.f12675g;
            int i5 = atomicIntegerFieldUpdater.get(this);
            int i6 = this.f12676a;
            if (i5 > i6) {
                do {
                    i4 = atomicIntegerFieldUpdater.get(this);
                    if (i4 > i6) {
                    }
                } while (!atomicIntegerFieldUpdater.compareAndSet(this, i4, i6));
            } else {
                if (i5 <= 0) {
                    c4 = 1;
                    break;
                }
                if (atomicIntegerFieldUpdater.compareAndSet(this, i5, i5 - 1)) {
                    f12667h.set(this, null);
                    c4 = 0;
                    break;
                }
            }
        }
        if (c4 == 0) {
            return Unit.INSTANCE;
        }
        if (c4 != 1) {
            if (c4 != 2) {
                throw new IllegalStateException("unexpected".toString());
            }
            throw new IllegalStateException("This mutex is already locked by the specified owner: null".toString());
        }
        C0128h c0128hQ = com.airbnb.lottie.h.q(IntrinsicsKt.intercepted(continuation));
        try {
            a(new C0579c(this, c0128hQ));
            Object objT = c0128hQ.t();
            if (objT == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(continuation);
            }
            if (objT != IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                objT = Unit.INSTANCE;
            }
            return objT == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objT : Unit.INSTANCE;
        } catch (Throwable th) {
            c0128hQ.A();
            throw th;
        }
    }

    public final void e(Object obj) {
        while (c()) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f12667h;
            Object obj2 = atomicReferenceFieldUpdater.get(this);
            r rVar = AbstractC0581e.f12668a;
            if (obj2 != rVar) {
                if (obj2 != obj && obj != null) {
                    throw new IllegalStateException(("This mutex is locked by " + obj2 + ", but " + obj + " is expected").toString());
                }
                if (atomicReferenceFieldUpdater.compareAndSet(this, obj2, rVar)) {
                    b();
                    return;
                }
            }
        }
        throw new IllegalStateException("This mutex is not locked".toString());
    }

    public final String toString() {
        return "Mutex@" + I.p(this) + "[isLocked=" + c() + ",owner=" + f12667h.get(this) + ']';
    }
}
