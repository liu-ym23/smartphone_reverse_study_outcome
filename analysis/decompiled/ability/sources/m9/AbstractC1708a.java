package m9;

import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.BaseContinuationImpl;
import kotlinx.coroutines.CompletionHandlerException;
import kotlinx.coroutines.CoroutineStart;
import s9.AbstractC1921a;

/* renamed from: m9.a, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC1708a extends kotlinx.coroutines.c implements H7.c, InterfaceC1733z {
    public final H7.h c;

    public AbstractC1708a(H7.h hVar, boolean z10) {
        super(z10);
        R((c0) hVar.get(b0.f5325a));
        this.c = hVar.plus(this);
    }

    @Override // kotlinx.coroutines.c
    public final String D() {
        return getClass().getSimpleName().concat(" was cancelled");
    }

    @Override // kotlinx.coroutines.c
    public final void Q(CompletionHandlerException completionHandlerException) {
        AbstractC1683A.k(this.c, completionHandlerException);
    }

    @Override // kotlinx.coroutines.c
    public final void Z(Object obj) {
        if (!(obj instanceof C1727t)) {
            h0(obj);
        } else {
            C1727t c1727t = (C1727t) obj;
            g0(c1727t.f5333a, C1727t.b.get(c1727t) != 0);
        }
    }

    public void g0(Throwable th, boolean z10) {
    }

    @Override // H7.c
    public final H7.h getContext() {
        return this.c;
    }

    @Override // m9.InterfaceC1733z
    public final H7.h getCoroutineContext() {
        return this.c;
    }

    public void h0(Object obj) {
    }

    public final void i0(CoroutineStart coroutineStart, AbstractC1708a abstractC1708a, S7.n nVar) {
        Object objInvoke;
        int iOrdinal = coroutineStart.ordinal();
        C7.r rVar = C7.r.f317a;
        if (iOrdinal == 0) {
            try {
                AbstractC1921a.h(U7.a.I(U7.a.u(abstractC1708a, this, nVar)), rVar);
                return;
            } finally {
                resumeWith(kotlin.b.a(th));
            }
        }
        if (iOrdinal != 1) {
            if (iOrdinal == 2) {
                kotlin.jvm.internal.k.f(nVar, "<this>");
                U7.a.I(U7.a.u(abstractC1708a, this, nVar)).resumeWith(rVar);
                return;
            }
            if (iOrdinal != 3) {
                throw new NoWhenBranchMatchedException();
            }
            try {
                H7.h hVar = this.c;
                Object objL = AbstractC1921a.l(hVar, null);
                try {
                    if (nVar instanceof BaseContinuationImpl) {
                        kotlin.jvm.internal.p.e(2, nVar);
                        objInvoke = nVar.invoke(abstractC1708a, this);
                    } else {
                        objInvoke = U7.a.b0(nVar, abstractC1708a, this);
                    }
                    AbstractC1921a.g(hVar, objL);
                    if (objInvoke != CoroutineSingletons.f4909a) {
                        resumeWith(objInvoke);
                    }
                } catch (Throwable th) {
                    AbstractC1921a.g(hVar, objL);
                    throw th;
                }
            } catch (Throwable th2) {
            }
        }
    }

    @Override // H7.c
    public final void resumeWith(Object obj) {
        Throwable thA = Result.a(obj);
        if (thA != null) {
            obj = new C1727t(thA, false);
        }
        Object objV = V(obj);
        if (objV == AbstractC1683A.e) {
            return;
        }
        y(objV);
    }
}
