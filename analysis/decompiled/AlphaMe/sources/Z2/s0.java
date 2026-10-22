package Z2;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes2.dex */
public abstract class s0 extends d3.m implements T, InterfaceC0131i0, Function1 {

    /* renamed from: d, reason: collision with root package name */
    public x0 f2242d;

    @Override // Z2.InterfaceC0131i0
    public final boolean a() {
        return true;
    }

    @Override // Z2.InterfaceC0131i0
    public final z0 c() {
        return null;
    }

    @Override // Z2.T
    public final void dispose() {
        Object objG;
        Object objF;
        d3.m mVar;
        d3.s sVar;
        x0 x0VarI = i();
        do {
            objG = x0VarI.G();
            if (!(objG instanceof s0)) {
                if (!(objG instanceof InterfaceC0131i0) || ((InterfaceC0131i0) objG).c() == null) {
                    return;
                }
                do {
                    objF = f();
                    if (objF instanceof d3.s) {
                        d3.m mVar2 = ((d3.s) objF).f12478a;
                        return;
                    }
                    if (objF == this) {
                        return;
                    }
                    Intrinsics.checkNotNull(objF, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
                    mVar = (d3.m) objF;
                    mVar.getClass();
                    AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = d3.m.f12467c;
                    sVar = (d3.s) atomicReferenceFieldUpdater.get(mVar);
                    if (sVar == null) {
                        sVar = new d3.s(mVar);
                        atomicReferenceFieldUpdater.lazySet(mVar, sVar);
                    }
                } while (!d3.m.f12465a.compareAndSet(this, objF, sVar));
                mVar.d();
                return;
            }
            if (objG != this) {
                return;
            }
        } while (!x0.f2258a.compareAndSet(x0VarI, objG, I.f2179l));
    }

    public o0 getParent() {
        return i();
    }

    public final x0 i() {
        x0 x0Var = this.f2242d;
        if (x0Var != null) {
            return x0Var;
        }
        Intrinsics.throwUninitializedPropertyAccessException("job");
        return null;
    }

    public abstract void j(Throwable th);

    @Override // d3.m
    public final String toString() {
        return getClass().getSimpleName() + '@' + I.p(this) + "[job@" + I.p(i()) + ']';
    }
}
