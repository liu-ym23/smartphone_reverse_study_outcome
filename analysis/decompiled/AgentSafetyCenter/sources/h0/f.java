package h0;

import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class f implements s1.f0 {
    public static final void a(ArrayList arrayList, yb.s sVar, s1.h0 h0Var, ArrayList arrayList2, ArrayList arrayList3, yb.s sVar2, ArrayList arrayList4, yb.s sVar3, yb.s sVar4) {
        float f5 = m.f5062d;
        if (!arrayList.isEmpty()) {
            sVar.f16096c = h0Var.e0(f5) + sVar.f16096c;
        }
        arrayList.add(0, kb.l.L0(arrayList2));
        arrayList3.add(Integer.valueOf(sVar2.f16096c));
        arrayList4.add(Integer.valueOf(sVar.f16096c));
        sVar.f16096c += sVar2.f16096c;
        sVar3.f16096c = Math.max(sVar3.f16096c, sVar4.f16096c);
        arrayList2.clear();
        sVar4.f16096c = 0;
        sVar2.f16096c = 0;
    }

    @Override // s1.f0
    public final s1.g0 c(s1.h0 h0Var, List list, long j10) {
        ArrayList arrayList;
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        yb.s sVar = new yb.s();
        yb.s sVar2 = new yb.s();
        ArrayList arrayList5 = new ArrayList();
        yb.s sVar3 = new yb.s();
        yb.s sVar4 = new yb.s();
        float f5 = m.f5061c;
        float f10 = m.f5059a;
        int size = list.size();
        int i = 0;
        while (i < size) {
            s1.o0 o0VarQ = ((s1.e0) list.get(i)).q(j10);
            if (!arrayList5.isEmpty()) {
                ArrayList arrayList6 = arrayList2;
                yb.s sVar5 = sVar2;
                if (h0Var.e0(f5) + sVar3.f16096c + o0VarQ.f11277c <= o2.a.i(j10)) {
                    arrayList2 = arrayList6;
                    sVar2 = sVar5;
                } else {
                    arrayList2 = arrayList6;
                    sVar2 = sVar5;
                    a(arrayList2, sVar2, h0Var, arrayList5, arrayList3, sVar4, arrayList4, sVar, sVar3);
                }
            }
            ArrayList arrayList7 = arrayList2;
            if (!arrayList5.isEmpty()) {
                sVar3.f16096c = h0Var.e0(f5) + sVar3.f16096c;
            }
            arrayList5.add(o0VarQ);
            sVar3.f16096c += o0VarQ.f11277c;
            sVar4.f16096c = Math.max(sVar4.f16096c, o0VarQ.f11278f);
            i++;
            arrayList2 = arrayList7;
        }
        ArrayList arrayList8 = arrayList2;
        if (arrayList5.isEmpty()) {
            arrayList = arrayList8;
        } else {
            float f11 = m.f5059a;
            arrayList = arrayList8;
            a(arrayList, sVar2, h0Var, arrayList5, arrayList3, sVar4, arrayList4, sVar, sVar3);
        }
        int iMax = Math.max(sVar.f16096c, o2.a.k(j10));
        int iMax2 = Math.max(sVar2.f16096c, o2.a.j(j10));
        float f12 = m.f5059a;
        return h0Var.Y(iMax, iMax2, kb.t.f7405c, new e(arrayList, h0Var, iMax, arrayList4));
    }
}
