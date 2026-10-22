package x2;

import java.util.ArrayList;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class c extends n {

    /* renamed from: k, reason: collision with root package name */
    public final ArrayList f15532k;

    /* renamed from: l, reason: collision with root package name */
    public int f15533l;

    public c(w2.e eVar, int i) {
        w2.e eVar2;
        super(eVar);
        ArrayList arrayList = new ArrayList();
        this.f15532k = arrayList;
        this.f15563f = i;
        w2.e eVar3 = this.f15559b;
        w2.e eVarK = eVar3.k(i);
        while (true) {
            eVar2 = eVar3;
            eVar3 = eVarK;
            if (eVar3 == null) {
                break;
            } else {
                eVarK = eVar3.k(this.f15563f);
            }
        }
        this.f15559b = eVar2;
        int i3 = this.f15563f;
        arrayList.add(i3 == 0 ? eVar2.f15164d : i3 == 1 ? eVar2.f15166e : null);
        w2.e eVarJ = eVar2.j(this.f15563f);
        while (eVarJ != null) {
            int i10 = this.f15563f;
            arrayList.add(i10 == 0 ? eVarJ.f15164d : i10 == 1 ? eVarJ.f15166e : null);
            eVarJ = eVarJ.j(this.f15563f);
        }
        int size = arrayList.size();
        int i11 = 0;
        while (i11 < size) {
            Object obj = arrayList.get(i11);
            i11++;
            n nVar = (n) obj;
            int i12 = this.f15563f;
            if (i12 == 0) {
                nVar.f15559b.f15160b = this;
            } else if (i12 == 1) {
                nVar.f15559b.f15162c = this;
            }
        }
        if (this.f15563f == 0 && ((w2.f) this.f15559b.S).f15201u0 && arrayList.size() > 1) {
            this.f15559b = ((n) arrayList.get(arrayList.size() - 1)).f15559b;
        }
        int i13 = this.f15563f;
        w2.e eVar4 = this.f15559b;
        this.f15533l = i13 == 0 ? eVar4.f15171h0 : eVar4.f15172i0;
    }

    /* JADX WARN: Removed duplicated region for block: B:62:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00dd  */
    @Override // x2.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(x2.d r28) {
        /*
            Method dump skipped, instructions count: 943
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: x2.c.a(x2.d):void");
    }

    @Override // x2.n
    public final void d() {
        ArrayList arrayList = this.f15532k;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            ((n) obj).d();
        }
        int size2 = arrayList.size();
        if (size2 < 1) {
            return;
        }
        w2.e eVar = ((n) arrayList.get(0)).f15559b;
        w2.e eVar2 = ((n) arrayList.get(size2 - 1)).f15559b;
        int i3 = this.f15563f;
        e eVar3 = this.i;
        e eVar4 = this.f15565h;
        if (i3 == 0) {
            w2.d dVar = eVar.H;
            w2.d dVar2 = eVar2.J;
            e eVarI = n.i(dVar, 0);
            int iD = dVar.d();
            w2.e eVarM = m();
            if (eVarM != null) {
                iD = eVarM.H.d();
            }
            if (eVarI != null) {
                n.b(eVar4, eVarI, iD);
            }
            e eVarI2 = n.i(dVar2, 0);
            int iD2 = dVar2.d();
            w2.e eVarN = n();
            if (eVarN != null) {
                iD2 = eVarN.J.d();
            }
            if (eVarI2 != null) {
                n.b(eVar3, eVarI2, -iD2);
            }
        } else {
            w2.d dVar3 = eVar.I;
            w2.d dVar4 = eVar2.K;
            e eVarI3 = n.i(dVar3, 1);
            int iD3 = dVar3.d();
            w2.e eVarM2 = m();
            if (eVarM2 != null) {
                iD3 = eVarM2.I.d();
            }
            if (eVarI3 != null) {
                n.b(eVar4, eVarI3, iD3);
            }
            e eVarI4 = n.i(dVar4, 1);
            int iD4 = dVar4.d();
            w2.e eVarN2 = n();
            if (eVarN2 != null) {
                iD4 = eVarN2.K.d();
            }
            if (eVarI4 != null) {
                n.b(eVar3, eVarI4, -iD4);
            }
        }
        eVar4.f15534a = this;
        eVar3.f15534a = this;
    }

    @Override // x2.n
    public final void e() {
        int i = 0;
        while (true) {
            ArrayList arrayList = this.f15532k;
            if (i >= arrayList.size()) {
                return;
            }
            ((n) arrayList.get(i)).e();
            i++;
        }
    }

    @Override // x2.n
    public final void f() {
        this.f15560c = null;
        ArrayList arrayList = this.f15532k;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            ((n) obj).f();
        }
    }

    @Override // x2.n
    public final long j() {
        ArrayList arrayList = this.f15532k;
        int size = arrayList.size();
        long j10 = 0;
        for (int i = 0; i < size; i++) {
            j10 = r4.i.f15539f + ((n) arrayList.get(i)).j() + j10 + r4.f15565h.f15539f;
        }
        return j10;
    }

    @Override // x2.n
    public final boolean k() {
        ArrayList arrayList = this.f15532k;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (!((n) arrayList.get(i)).k()) {
                return false;
            }
        }
        return true;
    }

    public final w2.e m() {
        int i = 0;
        while (true) {
            ArrayList arrayList = this.f15532k;
            if (i >= arrayList.size()) {
                return null;
            }
            w2.e eVar = ((n) arrayList.get(i)).f15559b;
            if (eVar.f0 != 8) {
                return eVar;
            }
            i++;
        }
    }

    public final w2.e n() {
        ArrayList arrayList = this.f15532k;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            w2.e eVar = ((n) arrayList.get(size)).f15559b;
            if (eVar.f0 != 8) {
                return eVar;
            }
        }
        return null;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("ChainRun ");
        sb2.append(this.f15563f == 0 ? "horizontal : " : "vertical : ");
        ArrayList arrayList = this.f15532k;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            sb2.append("<");
            sb2.append((n) obj);
            sb2.append("> ");
        }
        return sb2.toString();
    }
}
