package r;

import h0.s0;
import java.util.List;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class j implements s1.f0 {

    /* renamed from: a, reason: collision with root package name */
    public n f10307a;

    @Override // s1.f0
    public final s1.g0 c(s1.h0 h0Var, List list, long j10) {
        s1.o0 o0Var;
        s1.o0 o0Var2;
        int i;
        int size = list.size();
        s1.o0[] o0VarArr = new s1.o0[size];
        int size2 = list.size();
        long j11 = 0;
        int i3 = 0;
        int i10 = 0;
        while (true) {
            o0Var = null;
            if (i10 >= size2) {
                break;
            }
            s1.e0 e0Var = (s1.e0) list.get(i10);
            Object objV = e0Var.v();
            l lVar = objV instanceof l ? (l) objV : null;
            if (lVar != null && ((Boolean) lVar.f10312c.getValue()).booleanValue()) {
                s1.o0 o0VarQ = e0Var.q(j10);
                long jB = ac.a.b(o0VarQ.f11277c, o0VarQ.f11278f);
                o0VarArr[i10] = o0VarQ;
                j11 = jB;
            }
            i10++;
        }
        int size3 = list.size();
        for (int i11 = 0; i11 < size3; i11++) {
            s1.e0 e0Var2 = (s1.e0) list.get(i11);
            if (o0VarArr[i11] == null) {
                o0VarArr[i11] = e0Var2.q(j10);
            }
        }
        if (h0Var.V()) {
            i = (int) (j11 >> 32);
        } else {
            if (size == 0) {
                o0Var2 = null;
            } else {
                o0Var2 = o0VarArr[0];
                int i12 = size - 1;
                if (i12 != 0) {
                    int i13 = o0Var2 != null ? o0Var2.f11277c : 0;
                    ec.a it = new ec.g(1, i12, 1).iterator();
                    while (it.f3752h) {
                        s1.o0 o0Var3 = o0VarArr[it.nextInt()];
                        int i14 = o0Var3 != null ? o0Var3.f11277c : 0;
                        if (i13 < i14) {
                            o0Var2 = o0Var3;
                            i13 = i14;
                        }
                    }
                }
            }
            i = o0Var2 != null ? o0Var2.f11277c : 0;
        }
        if (h0Var.V()) {
            i3 = (int) (4294967295L & j11);
        } else {
            if (size != 0) {
                o0Var = o0VarArr[0];
                int i15 = size - 1;
                if (i15 != 0) {
                    int i16 = o0Var != null ? o0Var.f11278f : 0;
                    ec.a it2 = new ec.g(1, i15, 1).iterator();
                    while (it2.f3752h) {
                        s1.o0 o0Var4 = o0VarArr[it2.nextInt()];
                        int i17 = o0Var4 != null ? o0Var4.f11278f : 0;
                        if (i16 < i17) {
                            o0Var = o0Var4;
                            i16 = i17;
                        }
                    }
                }
            }
            if (o0Var != null) {
                i3 = o0Var.f11278f;
            }
        }
        if (!h0Var.V()) {
            this.f10307a.f10320b.setValue(o2.k.a(ac.a.b(i, i3)));
        }
        return h0Var.Y(i, i3, kb.t.f7405c, new s0(o0VarArr, this, i, i3));
    }
}
