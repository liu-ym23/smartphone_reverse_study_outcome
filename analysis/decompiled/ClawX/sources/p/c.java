package p;

import java.util.ArrayList;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class c extends o {

    /* renamed from: k, reason: collision with root package name */
    public final ArrayList f4601k;

    /* renamed from: l, reason: collision with root package name */
    public int f4602l;

    public c(o.d dVar, int i8) {
        o.d dVar2;
        super(dVar);
        ArrayList arrayList = new ArrayList();
        this.f4601k = arrayList;
        this.f4637f = i8;
        o.d dVar3 = this.f4634b;
        o.d dVarM = dVar3.m(i8);
        while (true) {
            dVar2 = dVar3;
            dVar3 = dVarM;
            if (dVar3 == null) {
                break;
            } else {
                dVarM = dVar3.m(this.f4637f);
            }
        }
        this.f4634b = dVar2;
        int i9 = this.f4637f;
        arrayList.add(i9 == 0 ? dVar2.d : i9 == 1 ? dVar2.f4219e : null);
        o.d dVarL = dVar2.l(this.f4637f);
        while (dVarL != null) {
            int i10 = this.f4637f;
            arrayList.add(i10 == 0 ? dVarL.d : i10 == 1 ? dVarL.f4219e : null);
            dVarL = dVarL.l(this.f4637f);
        }
        int size = arrayList.size();
        int i11 = 0;
        while (i11 < size) {
            Object obj = arrayList.get(i11);
            i11++;
            o oVar = (o) obj;
            int i12 = this.f4637f;
            if (i12 == 0) {
                oVar.f4634b.f4214b = this;
            } else if (i12 == 1) {
                oVar.f4634b.f4216c = this;
            }
        }
        if (this.f4637f == 0 && ((o.e) this.f4634b.S).f4254u0 && arrayList.size() > 1) {
            this.f4634b = ((o) arrayList.get(arrayList.size() - 1)).f4634b;
        }
        this.f4602l = this.f4637f == 0 ? this.f4634b.f4226h0 : this.f4634b.f4228i0;
    }

    /* JADX WARN: Removed duplicated region for block: B:62:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00dd  */
    @Override // p.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(p.d r28) {
        /*
            Method dump skipped, instructions count: 943
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p.c.a(p.d):void");
    }

    @Override // p.o
    public final void d() {
        ArrayList arrayList = this.f4601k;
        int size = arrayList.size();
        int i8 = 0;
        while (i8 < size) {
            Object obj = arrayList.get(i8);
            i8++;
            ((o) obj).d();
        }
        int size2 = arrayList.size();
        if (size2 < 1) {
            return;
        }
        o.d dVar = ((o) arrayList.get(0)).f4634b;
        o.d dVar2 = ((o) arrayList.get(size2 - 1)).f4634b;
        int i9 = this.f4637f;
        f fVar = this.f4640i;
        f fVar2 = this.f4639h;
        if (i9 == 0) {
            o.c cVar = dVar.H;
            o.c cVar2 = dVar2.J;
            f fVarI = o.i(cVar, 0);
            int iE = cVar.e();
            o.d dVarM = m();
            if (dVarM != null) {
                iE = dVarM.H.e();
            }
            if (fVarI != null) {
                o.b(fVar2, fVarI, iE);
            }
            f fVarI2 = o.i(cVar2, 0);
            int iE2 = cVar2.e();
            o.d dVarN = n();
            if (dVarN != null) {
                iE2 = dVarN.J.e();
            }
            if (fVarI2 != null) {
                o.b(fVar, fVarI2, -iE2);
            }
        } else {
            o.c cVar3 = dVar.I;
            o.c cVar4 = dVar2.K;
            f fVarI3 = o.i(cVar3, 1);
            int iE3 = cVar3.e();
            o.d dVarM2 = m();
            if (dVarM2 != null) {
                iE3 = dVarM2.I.e();
            }
            if (fVarI3 != null) {
                o.b(fVar2, fVarI3, iE3);
            }
            f fVarI4 = o.i(cVar4, 1);
            int iE4 = cVar4.e();
            o.d dVarN2 = n();
            if (dVarN2 != null) {
                iE4 = dVarN2.K.e();
            }
            if (fVarI4 != null) {
                o.b(fVar, fVarI4, -iE4);
            }
        }
        fVar2.f4610a = this;
        fVar.f4610a = this;
    }

    @Override // p.o
    public final void e() {
        int i8 = 0;
        while (true) {
            ArrayList arrayList = this.f4601k;
            if (i8 >= arrayList.size()) {
                return;
            }
            ((o) arrayList.get(i8)).e();
            i8++;
        }
    }

    @Override // p.o
    public final void f() {
        this.f4635c = null;
        ArrayList arrayList = this.f4601k;
        int size = arrayList.size();
        int i8 = 0;
        while (i8 < size) {
            Object obj = arrayList.get(i8);
            i8++;
            ((o) obj).f();
        }
    }

    @Override // p.o
    public final long j() {
        ArrayList arrayList = this.f4601k;
        int size = arrayList.size();
        long j4 = 0;
        for (int i8 = 0; i8 < size; i8++) {
            j4 = r4.f4640i.f4614f + ((o) arrayList.get(i8)).j() + j4 + r4.f4639h.f4614f;
        }
        return j4;
    }

    @Override // p.o
    public final boolean k() {
        ArrayList arrayList = this.f4601k;
        int size = arrayList.size();
        for (int i8 = 0; i8 < size; i8++) {
            if (!((o) arrayList.get(i8)).k()) {
                return false;
            }
        }
        return true;
    }

    public final o.d m() {
        int i8 = 0;
        while (true) {
            ArrayList arrayList = this.f4601k;
            if (i8 >= arrayList.size()) {
                return null;
            }
            o.d dVar = ((o) arrayList.get(i8)).f4634b;
            if (dVar.f4222f0 != 8) {
                return dVar;
            }
            i8++;
        }
    }

    public final o.d n() {
        ArrayList arrayList = this.f4601k;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            o.d dVar = ((o) arrayList.get(size)).f4634b;
            if (dVar.f4222f0 != 8) {
                return dVar;
            }
        }
        return null;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("ChainRun ");
        sb.append(this.f4637f == 0 ? "horizontal : " : "vertical : ");
        ArrayList arrayList = this.f4601k;
        int size = arrayList.size();
        int i8 = 0;
        while (i8 < size) {
            Object obj = arrayList.get(i8);
            i8++;
            sb.append("<");
            sb.append((o) obj);
            sb.append("> ");
        }
        return sb.toString();
    }
}
