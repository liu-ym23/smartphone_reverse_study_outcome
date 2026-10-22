package m9;

import kotlin.Pair;
import s9.AbstractC1921a;

/* loaded from: classes4.dex */
public final class w0 extends s9.o {
    public final ThreadLocal e;
    private volatile boolean threadLocalIsSet;

    /* JADX WARN: Illegal instructions before constructor call */
    public w0(H7.h hVar, H7.c cVar) {
        x0 x0Var = x0.f5338a;
        super(hVar.get(x0Var) == null ? hVar.plus(x0Var) : hVar, cVar);
        this.e = new ThreadLocal();
        if (cVar.getContext().get(H7.d.f758a) instanceof AbstractC1729v) {
            return;
        }
        Object objL = AbstractC1921a.l(hVar, null);
        AbstractC1921a.g(hVar, objL);
        k0(hVar, objL);
    }

    public final boolean j0() {
        boolean z10 = this.threadLocalIsSet && this.e.get() == null;
        this.e.remove();
        return !z10;
    }

    public final void k0(H7.h hVar, Object obj) {
        this.threadLocalIsSet = true;
        this.e.set(new Pair(hVar, obj));
    }

    @Override // s9.o, kotlinx.coroutines.c
    public final void y(Object obj) {
        if (this.threadLocalIsSet) {
            Pair pair = (Pair) this.e.get();
            if (pair != null) {
                AbstractC1921a.g((H7.h) pair.f4886a, pair.b);
            }
            this.e.remove();
        }
        Object objP = AbstractC1683A.p(obj);
        H7.c cVar = this.d;
        H7.h context = cVar.getContext();
        Object objL = AbstractC1921a.l(context, null);
        w0 w0VarV = objL != AbstractC1921a.d ? AbstractC1683A.v(cVar, context, objL) : null;
        try {
            this.d.resumeWith(objP);
            if (w0VarV == null || w0VarV.j0()) {
                AbstractC1921a.g(context, objL);
            }
        } catch (Throwable th) {
            if (w0VarV == null || w0VarV.j0()) {
                AbstractC1921a.g(context, objL);
            }
            throw th;
        }
    }
}
