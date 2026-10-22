package x2;

import java.util.ArrayList;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class i extends n {
    @Override // x2.d
    public final void a(d dVar) {
        w2.a aVar = (w2.a) this.f15559b;
        int i = aVar.f15130r0;
        e eVar = this.f15565h;
        ArrayList arrayList = eVar.f15544l;
        int size = arrayList.size();
        int i3 = 0;
        int i10 = -1;
        int i11 = 0;
        while (i11 < size) {
            Object obj = arrayList.get(i11);
            i11++;
            int i12 = ((e) obj).f15540g;
            if (i10 == -1 || i12 < i10) {
                i10 = i12;
            }
            if (i3 < i12) {
                i3 = i12;
            }
        }
        if (i == 0 || i == 2) {
            eVar.d(i10 + aVar.f15132t0);
        } else {
            eVar.d(i3 + aVar.f15132t0);
        }
    }

    @Override // x2.n
    public final void d() {
        w2.e eVar = this.f15559b;
        if (eVar instanceof w2.a) {
            e eVar2 = this.f15565h;
            eVar2.f15535b = true;
            ArrayList arrayList = eVar2.f15544l;
            w2.a aVar = (w2.a) eVar;
            int i = aVar.f15130r0;
            boolean z10 = aVar.f15131s0;
            int i3 = 0;
            if (i == 0) {
                eVar2.f15538e = 4;
                while (i3 < aVar.f15129q0) {
                    w2.e eVar3 = aVar.f15128p0[i3];
                    if (z10 || eVar3.f0 != 8) {
                        e eVar4 = eVar3.f15164d.f15565h;
                        eVar4.f15543k.add(eVar2);
                        arrayList.add(eVar4);
                    }
                    i3++;
                }
                m(this.f15559b.f15164d.f15565h);
                m(this.f15559b.f15164d.i);
                return;
            }
            if (i == 1) {
                eVar2.f15538e = 5;
                while (i3 < aVar.f15129q0) {
                    w2.e eVar5 = aVar.f15128p0[i3];
                    if (z10 || eVar5.f0 != 8) {
                        e eVar6 = eVar5.f15164d.i;
                        eVar6.f15543k.add(eVar2);
                        arrayList.add(eVar6);
                    }
                    i3++;
                }
                m(this.f15559b.f15164d.f15565h);
                m(this.f15559b.f15164d.i);
                return;
            }
            if (i == 2) {
                eVar2.f15538e = 6;
                while (i3 < aVar.f15129q0) {
                    w2.e eVar7 = aVar.f15128p0[i3];
                    if (z10 || eVar7.f0 != 8) {
                        e eVar8 = eVar7.f15166e.f15565h;
                        eVar8.f15543k.add(eVar2);
                        arrayList.add(eVar8);
                    }
                    i3++;
                }
                m(this.f15559b.f15166e.f15565h);
                m(this.f15559b.f15166e.i);
                return;
            }
            if (i != 3) {
                return;
            }
            eVar2.f15538e = 7;
            while (i3 < aVar.f15129q0) {
                w2.e eVar9 = aVar.f15128p0[i3];
                if (z10 || eVar9.f0 != 8) {
                    e eVar10 = eVar9.f15166e.i;
                    eVar10.f15543k.add(eVar2);
                    arrayList.add(eVar10);
                }
                i3++;
            }
            m(this.f15559b.f15166e.f15565h);
            m(this.f15559b.f15166e.i);
        }
    }

    @Override // x2.n
    public final void e() {
        w2.e eVar = this.f15559b;
        if (eVar instanceof w2.a) {
            int i = ((w2.a) eVar).f15130r0;
            e eVar2 = this.f15565h;
            if (i == 0 || i == 1) {
                eVar.X = eVar2.f15540g;
            } else {
                eVar.Y = eVar2.f15540g;
            }
        }
    }

    @Override // x2.n
    public final void f() {
        this.f15560c = null;
        this.f15565h.c();
    }

    @Override // x2.n
    public final boolean k() {
        return false;
    }

    public final void m(e eVar) {
        e eVar2 = this.f15565h;
        eVar2.f15543k.add(eVar);
        eVar.f15544l.add(eVar2);
    }
}
