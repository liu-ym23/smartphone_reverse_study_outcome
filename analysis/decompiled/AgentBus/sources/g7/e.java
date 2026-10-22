package g7;

import ia.w;

/* loaded from: classes.dex */
public abstract class e {
    public static <R> R fold(g gVar, R r10, p7.n nVar) {
        q7.k.e(nVar, "operation");
        return (R) i.fold(gVar, r10, nVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <E extends j> E get(g gVar, k kVar) {
        q7.k.e(kVar, "key");
        if (kVar instanceof w) {
            w wVar = (w) kVar;
            k kVar2 = ((a) gVar).f3861f;
            if (kVar2 != wVar && wVar.f5017g != kVar2) {
                return null;
            }
            q7.k.e(gVar, "element");
            E e10 = (E) wVar.f5016f.invoke(gVar);
            if (e10 != null) {
                return e10;
            }
        } else if (f.f3865f == kVar) {
            q7.k.c(gVar, "null cannot be cast to non-null type E of kotlin.coroutines.ContinuationInterceptor.get");
            return gVar;
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static l minusKey(g gVar, k kVar) {
        q7.k.e(kVar, "key");
        if (kVar instanceof w) {
            w wVar = (w) kVar;
            k kVar2 = ((a) gVar).f3861f;
            if (kVar2 != wVar && wVar.f5017g != kVar2) {
                return gVar;
            }
            q7.k.e(gVar, "element");
            if (((j) wVar.f5016f.invoke(gVar)) == null) {
                return gVar;
            }
        } else if (f.f3865f != kVar) {
            return gVar;
        }
        return m.f3866f;
    }

    public static l plus(g gVar, l lVar) {
        q7.k.e(lVar, "context");
        return i.plus(gVar, lVar);
    }

    public static void releaseInterceptedContinuation(g gVar, d dVar) {
        q7.k.e(dVar, "continuation");
    }
}
