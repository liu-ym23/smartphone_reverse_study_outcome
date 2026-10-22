package s4;

import Z3.f;
import a4.C0428b;
import x4.C1290B;
import x4.C1298J;
import y4.C1327a;
import y4.C1328b;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: s4.i, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final /* synthetic */ class C1076i {
    public static final n0 a(I i5, Z3.i iVar, K k5, i4.p<? super I, ? super Z3.e<? super V3.v>, ? extends Object> pVar) {
        Z3.i iVarE = C1055D.e(i5, iVar);
        AbstractC1060a w0Var = k5.e() ? new w0(iVarE, pVar) : new D0(iVarE, true);
        w0Var.M0(k5, w0Var, pVar);
        return w0Var;
    }

    public static /* synthetic */ n0 b(I i5, Z3.i iVar, K k5, i4.p pVar, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            iVar = Z3.j.f6656a;
        }
        if ((i6 & 2) != 0) {
            k5 = K.f20307a;
        }
        return C1072g.a(i5, iVar, k5, pVar);
    }

    public static final <T> Object c(Z3.i iVar, i4.p<? super I, ? super Z3.e<? super T>, ? extends Object> pVar, Z3.e<? super T> eVar) throws Throwable {
        Object objN0;
        Z3.i context = eVar.getContext();
        Z3.i iVarD = C1055D.d(context, iVar);
        r0.e(iVarD);
        if (iVarD == context) {
            C1290B c1290b = new C1290B(iVarD, eVar);
            objN0 = C1328b.b(c1290b, c1290b, pVar);
        } else {
            f.b bVar = Z3.f.f6654N;
            if (j4.k.b(iVarD.a(bVar), context.a(bVar))) {
                J0 j02 = new J0(iVarD, eVar);
                Z3.i context2 = j02.getContext();
                Object objC = C1298J.c(context2, null);
                try {
                    Object objB = C1328b.b(j02, j02, pVar);
                    C1298J.a(context2, objC);
                    objN0 = objB;
                } catch (Throwable th) {
                    C1298J.a(context2, objC);
                    throw th;
                }
            } else {
                T t5 = new T(iVarD, eVar);
                C1327a.d(pVar, t5, t5, null, 4, null);
                objN0 = t5.N0();
            }
        }
        if (objN0 == C0428b.e()) {
            kotlin.coroutines.jvm.internal.h.c(eVar);
        }
        return objN0;
    }
}
