package w;

import java.util.ArrayList;

/* renamed from: w.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1197c extends p {

    /* renamed from: k, reason: collision with root package name */
    ArrayList<p> f23405k;

    /* renamed from: l, reason: collision with root package name */
    private int f23406l;

    public C1197c(v.e eVar, int i5) {
        super(eVar);
        this.f23405k = new ArrayList<>();
        this.f23474f = i5;
        q();
    }

    private void q() {
        v.e eVar;
        v.e eVar2 = this.f23470b;
        v.e eVarL = eVar2.L(this.f23474f);
        while (true) {
            v.e eVar3 = eVarL;
            eVar = eVar2;
            eVar2 = eVar3;
            if (eVar2 == null) {
                break;
            } else {
                eVarL = eVar2.L(this.f23474f);
            }
        }
        this.f23470b = eVar;
        this.f23405k.add(eVar.N(this.f23474f));
        v.e eVarJ = eVar.J(this.f23474f);
        while (eVarJ != null) {
            this.f23405k.add(eVarJ.N(this.f23474f));
            eVarJ = eVarJ.J(this.f23474f);
        }
        ArrayList<p> arrayList = this.f23405k;
        int size = arrayList.size();
        int i5 = 0;
        while (i5 < size) {
            p pVar = arrayList.get(i5);
            i5++;
            p pVar2 = pVar;
            int i6 = this.f23474f;
            if (i6 == 0) {
                pVar2.f23470b.f23060c = this;
            } else if (i6 == 1) {
                pVar2.f23470b.f23062d = this;
            }
        }
        if (this.f23474f == 0 && ((v.f) this.f23470b.K()).P1() && this.f23405k.size() > 1) {
            ArrayList<p> arrayList2 = this.f23405k;
            this.f23470b = arrayList2.get(arrayList2.size() - 1).f23470b;
        }
        this.f23406l = this.f23474f == 0 ? this.f23470b.z() : this.f23470b.S();
    }

    private v.e r() {
        for (int i5 = 0; i5 < this.f23405k.size(); i5++) {
            p pVar = this.f23405k.get(i5);
            if (pVar.f23470b.V() != 8) {
                return pVar.f23470b;
            }
        }
        return null;
    }

    private v.e s() {
        for (int size = this.f23405k.size() - 1; size >= 0; size--) {
            p pVar = this.f23405k.get(size);
            if (pVar.f23470b.V() != 8) {
                return pVar.f23470b;
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:90:0x0160  */
    @Override // w.p, w.InterfaceC1198d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(w.InterfaceC1198d r27) {
        /*
            Method dump skipped, instructions count: 1054
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: w.C1197c.a(w.d):void");
    }

    @Override // w.p
    void d() {
        ArrayList<p> arrayList = this.f23405k;
        int size = arrayList.size();
        int i5 = 0;
        while (i5 < size) {
            p pVar = arrayList.get(i5);
            i5++;
            pVar.d();
        }
        int size2 = this.f23405k.size();
        if (size2 < 1) {
            return;
        }
        v.e eVar = this.f23405k.get(0).f23470b;
        v.e eVar2 = this.f23405k.get(size2 - 1).f23470b;
        if (this.f23474f == 0) {
            v.d dVar = eVar.f23044O;
            v.d dVar2 = eVar2.f23046Q;
            f fVarI = i(dVar, 0);
            int iF = dVar.f();
            v.e eVarR = r();
            if (eVarR != null) {
                iF = eVarR.f23044O.f();
            }
            if (fVarI != null) {
                b(this.f23476h, fVarI, iF);
            }
            f fVarI2 = i(dVar2, 0);
            int iF2 = dVar2.f();
            v.e eVarS = s();
            if (eVarS != null) {
                iF2 = eVarS.f23046Q.f();
            }
            if (fVarI2 != null) {
                b(this.f23477i, fVarI2, -iF2);
            }
        } else {
            v.d dVar3 = eVar.f23045P;
            v.d dVar4 = eVar2.f23047R;
            f fVarI3 = i(dVar3, 1);
            int iF3 = dVar3.f();
            v.e eVarR2 = r();
            if (eVarR2 != null) {
                iF3 = eVarR2.f23045P.f();
            }
            if (fVarI3 != null) {
                b(this.f23476h, fVarI3, iF3);
            }
            f fVarI4 = i(dVar4, 1);
            int iF4 = dVar4.f();
            v.e eVarS2 = s();
            if (eVarS2 != null) {
                iF4 = eVarS2.f23047R.f();
            }
            if (fVarI4 != null) {
                b(this.f23477i, fVarI4, -iF4);
            }
        }
        this.f23476h.f23416a = this;
        this.f23477i.f23416a = this;
    }

    @Override // w.p
    public void e() {
        for (int i5 = 0; i5 < this.f23405k.size(); i5++) {
            this.f23405k.get(i5).e();
        }
    }

    @Override // w.p
    void f() {
        this.f23471c = null;
        ArrayList<p> arrayList = this.f23405k;
        int size = arrayList.size();
        int i5 = 0;
        while (i5 < size) {
            p pVar = arrayList.get(i5);
            i5++;
            pVar.f();
        }
    }

    @Override // w.p
    public long j() {
        int size = this.f23405k.size();
        long j5 = 0;
        for (int i5 = 0; i5 < size; i5++) {
            j5 = j5 + r4.f23476h.f23421f + this.f23405k.get(i5).j() + r4.f23477i.f23421f;
        }
        return j5;
    }

    @Override // w.p
    boolean m() {
        int size = this.f23405k.size();
        for (int i5 = 0; i5 < size; i5++) {
            if (!this.f23405k.get(i5).m()) {
                return false;
            }
        }
        return true;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ChainRun ");
        sb.append(this.f23474f == 0 ? "horizontal : " : "vertical : ");
        ArrayList<p> arrayList = this.f23405k;
        int size = arrayList.size();
        int i5 = 0;
        while (i5 < size) {
            p pVar = arrayList.get(i5);
            i5++;
            sb.append("<");
            sb.append(pVar);
            sb.append("> ");
        }
        return sb.toString();
    }
}
