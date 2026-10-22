package w;

import java.util.List;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class s implements s1.f0 {

    /* renamed from: a, reason: collision with root package name */
    public final w0.e f15042a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f15043b;

    public s(w0.e eVar, boolean z10) {
        this.f15042a = eVar;
        this.f15043b = z10;
    }

    @Override // s1.f0
    public final s1.g0 c(s1.h0 h0Var, List list, long j10) {
        int iK;
        int iJ;
        s1.o0 o0VarQ;
        boolean zIsEmpty = list.isEmpty();
        kb.t tVar = kb.t.f7405c;
        if (zIsEmpty) {
            return h0Var.Y(o2.a.k(j10), o2.a.j(j10), tVar, n.f15011g);
        }
        long jB = this.f15043b ? j10 : o2.a.b(j10, 0, 0, 0, 0, 10);
        if (list.size() == 1) {
            s1.e0 e0Var = (s1.e0) list.get(0);
            Object objV = e0Var.v();
            l lVar = objV instanceof l ? (l) objV : null;
            if (lVar != null ? lVar.f15001t : false) {
                iK = o2.a.k(j10);
                iJ = o2.a.j(j10);
                int iK2 = o2.a.k(j10);
                int iJ2 = o2.a.j(j10);
                if (!((iJ2 >= 0) & (iK2 >= 0))) {
                    o2.h.a("width and height must be >= 0");
                }
                o0VarQ = e0Var.q(o2.b.g(iK2, iK2, iJ2, iJ2));
            } else {
                o0VarQ = e0Var.q(jB);
                iK = Math.max(o2.a.k(j10), o0VarQ.f11277c);
                iJ = Math.max(o2.a.j(j10), o0VarQ.f11278f);
            }
            int i = iJ;
            int i3 = iK;
            return h0Var.Y(i3, i, tVar, new q(o0VarQ, e0Var, h0Var, i3, i, this));
        }
        s1.o0[] o0VarArr = new s1.o0[list.size()];
        yb.s sVar = new yb.s();
        sVar.f16096c = o2.a.k(j10);
        yb.s sVar2 = new yb.s();
        sVar2.f16096c = o2.a.j(j10);
        int size = list.size();
        boolean z10 = false;
        for (int i10 = 0; i10 < size; i10++) {
            s1.e0 e0Var2 = (s1.e0) list.get(i10);
            Object objV2 = e0Var2.v();
            l lVar2 = objV2 instanceof l ? (l) objV2 : null;
            if (lVar2 != null ? lVar2.f15001t : false) {
                z10 = true;
            } else {
                s1.o0 o0VarQ2 = e0Var2.q(jB);
                o0VarArr[i10] = o0VarQ2;
                sVar.f16096c = Math.max(sVar.f16096c, o0VarQ2.f11277c);
                sVar2.f16096c = Math.max(sVar2.f16096c, o0VarQ2.f11278f);
            }
        }
        if (z10) {
            int i11 = sVar.f16096c;
            int i12 = i11 != Integer.MAX_VALUE ? i11 : 0;
            int i13 = sVar2.f16096c;
            long jA = o2.b.a(i12, i11, i13 != Integer.MAX_VALUE ? i13 : 0, i13);
            int size2 = list.size();
            for (int i14 = 0; i14 < size2; i14++) {
                s1.e0 e0Var3 = (s1.e0) list.get(i14);
                Object objV3 = e0Var3.v();
                l lVar3 = objV3 instanceof l ? (l) objV3 : null;
                if (lVar3 != null ? lVar3.f15001t : false) {
                    o0VarArr[i14] = e0Var3.q(jA);
                }
            }
        }
        return h0Var.Y(sVar.f16096c, sVar2.f16096c, tVar, new r(o0VarArr, list, h0Var, sVar, sVar2, this));
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof s)) {
            return false;
        }
        s sVar = (s) obj;
        return this.f15042a.equals(sVar.f15042a) && this.f15043b == sVar.f15043b;
    }

    public final int hashCode() {
        return Boolean.hashCode(this.f15043b) + (this.f15042a.hashCode() * 31);
    }

    public final String toString() {
        return "BoxMeasurePolicy(alignment=" + this.f15042a + ", propagateMinConstraints=" + this.f15043b + ')';
    }
}
