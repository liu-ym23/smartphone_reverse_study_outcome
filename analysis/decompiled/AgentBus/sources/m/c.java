package m;

import i1.l0;
import i1.m0;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class c implements g1.p {

    /* renamed from: a, reason: collision with root package name */
    public final k f6044a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f6045b;

    public c(k kVar) {
        this.f6044a = kVar;
    }

    @Override // g1.p
    public final l0 b(m0 m0Var, List list, long j2) {
        Object obj;
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            arrayList.add(((g1.o) list.get(i2)).b(j2));
        }
        Object obj2 = null;
        if (arrayList.isEmpty()) {
            obj = null;
        } else {
            obj = arrayList.get(0);
            int i10 = ((g1.s) obj).f3756f;
            int iT0 = d7.s.t0(arrayList);
            if (1 <= iT0) {
                int i11 = 1;
                while (true) {
                    Object obj3 = arrayList.get(i11);
                    int i12 = ((g1.s) obj3).f3756f;
                    if (i10 < i12) {
                        obj = obj3;
                        i10 = i12;
                    }
                    if (i11 == iT0) {
                        break;
                    }
                    i11++;
                }
            }
        }
        g1.s sVar = (g1.s) obj;
        int i13 = sVar != null ? sVar.f3756f : 0;
        if (!arrayList.isEmpty()) {
            obj2 = arrayList.get(0);
            int i14 = ((g1.s) obj2).f3757g;
            int iT02 = d7.s.t0(arrayList);
            if (1 <= iT02) {
                int i15 = 1;
                while (true) {
                    Object obj4 = arrayList.get(i15);
                    int i16 = ((g1.s) obj4).f3757g;
                    if (i14 < i16) {
                        obj2 = obj4;
                        i14 = i16;
                    }
                    if (i15 == iT02) {
                        break;
                    }
                    i15++;
                }
            }
        }
        g1.s sVar2 = (g1.s) obj2;
        int i17 = sVar2 != null ? sVar2.f3757g : 0;
        boolean zJ0 = m0Var.j0();
        k kVar = this.f6044a;
        if (zJ0) {
            this.f6045b = true;
            kVar.f6075a.setValue(new d2.k(ib.k.a(i13, i17)));
        } else if (!this.f6045b) {
            kVar.f6075a.setValue(new d2.k(ib.k.a(i13, i17)));
        }
        return m0Var.l0(i13, i17, d7.a0.f2944f, new g1.w(1, arrayList));
    }
}
