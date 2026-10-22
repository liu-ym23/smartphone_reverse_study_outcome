package h9;

import d7.r;
import f8.e0;
import f8.n0;
import f8.q0;
import f8.w;
import i8.c0;
import java.util.Collection;
import p7.n;
import v9.m0;

/* loaded from: classes.dex */
public final class d implements w9.d {

    /* renamed from: a, reason: collision with root package name */
    public static final d f4235a = new d();

    public static /* synthetic */ void b(int i2) {
        Object[] objArr = new Object[3];
        if (i2 != 1) {
            objArr[0] = "a";
        } else {
            objArr[0] = "b";
        }
        objArr[1] = "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil$1";
        objArr[2] = "equals";
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
    }

    public static n0 e(f8.b bVar) {
        while (bVar instanceof f8.c) {
            f8.c cVar = (f8.c) bVar;
            if (cVar.getKind() != 2) {
                break;
            }
            Collection collectionR = cVar.r();
            q7.k.d(collectionR, "overriddenDescriptors");
            bVar = (f8.c) r.g1(collectionR);
            if (bVar == null) {
                return null;
            }
        }
        return bVar.q();
    }

    @Override // w9.d
    public boolean a(m0 m0Var, m0 m0Var2) {
        if (m0Var == null) {
            b(0);
            throw null;
        }
        if (m0Var2 != null) {
            return m0Var.equals(m0Var2);
        }
        b(1);
        throw null;
    }

    public boolean c(f8.j jVar, f8.j jVar2, boolean z4) {
        if ((jVar instanceof f8.e) && (jVar2 instanceof f8.e)) {
            return q7.k.a(((f8.e) jVar).h(), ((f8.e) jVar2).h());
        }
        if ((jVar instanceof q0) && (jVar2 instanceof q0)) {
            return d((q0) jVar, (q0) jVar2, z4, c.f4234g);
        }
        if (!(jVar instanceof f8.b) || !(jVar2 instanceof f8.b)) {
            return ((jVar instanceof e0) && (jVar2 instanceof e0)) ? q7.k.a(((c0) ((e0) jVar)).f4758j, ((c0) ((e0) jVar2)).f4758j) : q7.k.a(jVar, jVar2);
        }
        f8.b bVar = (f8.b) jVar;
        f8.b bVar2 = (f8.b) jVar2;
        if (!bVar.equals(bVar2)) {
            if (q7.k.a(bVar.getName(), bVar2.getName()) && ((!(bVar instanceof w) || !(bVar2 instanceof w) || ((w) bVar).Z() == ((w) bVar2).Z()) && ((!q7.k.a(bVar.p(), bVar2.p()) || (z4 && q7.k.a(e(bVar), e(bVar2)))) && !f.o(bVar) && !f.o(bVar2)))) {
                f8.j jVarP = bVar.p();
                f8.j jVarP2 = bVar2.p();
                if (((jVarP instanceof f8.c) || (jVarP2 instanceof f8.c)) ? false : c(jVarP, jVarP2, z4)) {
                    l lVar = new l(new a(bVar, bVar2, z4));
                    if (lVar.m(bVar, bVar2, null, true).c() != 1 || lVar.m(bVar2, bVar, null, true).c() != 1) {
                    }
                }
            }
            return false;
        }
        return true;
    }

    public boolean d(q0 q0Var, q0 q0Var2, boolean z4, n nVar) {
        q7.k.e(q0Var, "a");
        q7.k.e(q0Var2, "b");
        if (q0Var.equals(q0Var2)) {
            return true;
        }
        if (q7.k.a(q0Var.p(), q0Var2.p())) {
            return false;
        }
        f8.j jVarP = q0Var.p();
        f8.j jVarP2 = q0Var2.p();
        return (((jVarP instanceof f8.c) || (jVarP2 instanceof f8.c)) ? ((Boolean) nVar.invoke(jVarP, jVarP2)).booleanValue() : c(jVarP, jVarP2, z4)) && q0Var.getIndex() == q0Var2.getIndex();
    }
}
