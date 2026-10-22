package Z2;

import d3.AbstractC0539a;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: Z2.j, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0132j extends q0 {

    /* renamed from: e, reason: collision with root package name */
    public final C0128h f2223e;

    public C0132j(C0128h c0128h) {
        this.f2223e = c0128h;
    }

    @Override // kotlin.jvm.functions.Function1
    public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
        j((Throwable) obj);
        return Unit.INSTANCE;
    }

    @Override // Z2.s0
    public final void j(Throwable th) {
        x0 x0VarI = i();
        C0128h c0128h = this.f2223e;
        Throwable thS = c0128h.s(x0VarI);
        if (c0128h.x()) {
            Continuation continuation = c0128h.f2219d;
            Intrinsics.checkNotNull(continuation, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<*>");
            d3.i iVar = (d3.i) continuation;
            iVar.getClass();
            while (true) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = d3.i.f12454h;
                Object obj = atomicReferenceFieldUpdater.get(iVar);
                X.r rVar = AbstractC0539a.f12444c;
                if (Intrinsics.areEqual(obj, rVar)) {
                    if (atomicReferenceFieldUpdater.compareAndSet(iVar, rVar, thS)) {
                        return;
                    }
                } else {
                    if (obj instanceof Throwable) {
                        return;
                    }
                    if (atomicReferenceFieldUpdater.compareAndSet(iVar, obj, null)) {
                        break;
                    }
                }
            }
        }
        c0128h.i(thS);
        if (c0128h.x()) {
            return;
        }
        c0128h.p();
    }
}
