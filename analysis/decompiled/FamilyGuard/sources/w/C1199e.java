package w;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import v.e;
import w.C1196b;

/* renamed from: w.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1199e {

    /* renamed from: a, reason: collision with root package name */
    private v.f f23407a;

    /* renamed from: d, reason: collision with root package name */
    private v.f f23410d;

    /* renamed from: b, reason: collision with root package name */
    private boolean f23408b = true;

    /* renamed from: c, reason: collision with root package name */
    private boolean f23409c = true;

    /* renamed from: e, reason: collision with root package name */
    private ArrayList<p> f23411e = new ArrayList<>();

    /* renamed from: f, reason: collision with root package name */
    private ArrayList<m> f23412f = new ArrayList<>();

    /* renamed from: g, reason: collision with root package name */
    private C1196b.InterfaceC0254b f23413g = null;

    /* renamed from: h, reason: collision with root package name */
    private C1196b.a f23414h = new C1196b.a();

    /* renamed from: i, reason: collision with root package name */
    ArrayList<m> f23415i = new ArrayList<>();

    public C1199e(v.f fVar) {
        this.f23407a = fVar;
        this.f23410d = fVar;
    }

    private void a(f fVar, int i5, int i6, f fVar2, ArrayList<m> arrayList, m mVar) {
        C1199e c1199e;
        int i7;
        f fVar3;
        ArrayList<m> arrayList2;
        p pVar = fVar.f23419d;
        if (pVar.f23471c == null) {
            v.f fVar4 = this.f23407a;
            if (pVar == fVar4.f23064e || pVar == fVar4.f23066f) {
                return;
            }
            if (mVar == null) {
                mVar = new m(pVar, i6);
                arrayList.add(mVar);
            }
            m mVar2 = mVar;
            pVar.f23471c = mVar2;
            mVar2.a(pVar);
            for (InterfaceC1198d interfaceC1198d : pVar.f23476h.f23426k) {
                if (interfaceC1198d instanceof f) {
                    c1199e = this;
                    i7 = i5;
                    fVar3 = fVar2;
                    arrayList2 = arrayList;
                    c1199e.a((f) interfaceC1198d, i7, 0, fVar3, arrayList2, mVar2);
                } else {
                    c1199e = this;
                    i7 = i5;
                    fVar3 = fVar2;
                    arrayList2 = arrayList;
                }
                this = c1199e;
                i5 = i7;
                fVar2 = fVar3;
                arrayList = arrayList2;
            }
            C1199e c1199e2 = this;
            int i8 = i5;
            f fVar5 = fVar2;
            ArrayList<m> arrayList3 = arrayList;
            for (InterfaceC1198d interfaceC1198d2 : pVar.f23477i.f23426k) {
                if (interfaceC1198d2 instanceof f) {
                    c1199e2.a((f) interfaceC1198d2, i8, 1, fVar5, arrayList3, mVar2);
                }
            }
            if (i8 == 1 && (pVar instanceof n)) {
                for (InterfaceC1198d interfaceC1198d3 : ((n) pVar).f23451k.f23426k) {
                    if (interfaceC1198d3 instanceof f) {
                        c1199e2.a((f) interfaceC1198d3, i8, 2, fVar5, arrayList3, mVar2);
                    }
                }
            }
            for (f fVar6 : pVar.f23476h.f23427l) {
                if (fVar6 == fVar5) {
                    mVar2.f23445b = true;
                }
                c1199e2.a(fVar6, i8, 0, fVar5, arrayList3, mVar2);
            }
            for (f fVar7 : pVar.f23477i.f23427l) {
                if (fVar7 == fVar5) {
                    mVar2.f23445b = true;
                }
                c1199e2.a(fVar7, i8, 1, fVar5, arrayList3, mVar2);
            }
            if (i8 == 1 && (pVar instanceof n)) {
                Iterator<f> it = ((n) pVar).f23451k.f23427l.iterator();
                while (it.hasNext()) {
                    c1199e2.a(it.next(), i8, 2, fVar5, arrayList3, mVar2);
                }
            }
        }
    }

    private boolean b(v.f fVar) {
        e.b bVar;
        int i5;
        e.b bVar2;
        float f5;
        float f6;
        e.b bVar3;
        e.b bVar4;
        e.b bVar5;
        ArrayList<v.e> arrayList = fVar.f23213L0;
        int size = arrayList.size();
        char c6 = 0;
        int i6 = 0;
        while (i6 < size) {
            v.e eVar = arrayList.get(i6);
            i6++;
            v.e eVar2 = eVar;
            e.b[] bVarArr = eVar2.f23055Z;
            e.b bVar6 = bVarArr[c6 == true ? 1 : 0];
            e.b bVar7 = bVarArr[1];
            if (eVar2.V() == 8) {
                eVar2.f23056a = true;
            } else {
                if (eVar2.f23022B < 1.0f && bVar6 == e.b.MATCH_CONSTRAINT) {
                    eVar2.f23100w = 2;
                }
                if (eVar2.f23028E < 1.0f && bVar7 == e.b.MATCH_CONSTRAINT) {
                    eVar2.f23102x = 2;
                }
                if (eVar2.v() > 0.0f) {
                    e.b bVar8 = e.b.MATCH_CONSTRAINT;
                    if (bVar6 == bVar8 && (bVar7 == e.b.WRAP_CONTENT || bVar7 == e.b.FIXED)) {
                        eVar2.f23100w = 3;
                    } else if (bVar7 == bVar8 && (bVar6 == e.b.WRAP_CONTENT || bVar6 == e.b.FIXED)) {
                        eVar2.f23102x = 3;
                    } else if (bVar6 == bVar8 && bVar7 == bVar8) {
                        if (eVar2.f23100w == 0) {
                            eVar2.f23100w = 3;
                        }
                        if (eVar2.f23102x == 0) {
                            eVar2.f23102x = 3;
                        }
                    }
                }
                e.b bVar9 = e.b.MATCH_CONSTRAINT;
                if (bVar6 == bVar9 && eVar2.f23100w == 1 && (eVar2.f23044O.f23004f == null || eVar2.f23046Q.f23004f == null)) {
                    bVar6 = e.b.WRAP_CONTENT;
                }
                if (bVar7 == bVar9 && eVar2.f23102x == 1 && (eVar2.f23045P.f23004f == null || eVar2.f23047R.f23004f == null)) {
                    bVar7 = e.b.WRAP_CONTENT;
                }
                l lVar = eVar2.f23064e;
                lVar.f23472d = bVar6;
                int i7 = eVar2.f23100w;
                lVar.f23469a = i7;
                n nVar = eVar2.f23066f;
                nVar.f23472d = bVar7;
                int i8 = eVar2.f23102x;
                nVar.f23469a = i8;
                e.b bVar10 = e.b.MATCH_PARENT;
                char c7 = c6 == true ? 1 : 0;
                if ((bVar6 == bVar10 || bVar6 == e.b.FIXED || bVar6 == e.b.WRAP_CONTENT) && (bVar7 == bVar10 || bVar7 == e.b.FIXED || bVar7 == e.b.WRAP_CONTENT)) {
                    e.b bVar11 = bVar7;
                    e.b bVar12 = bVar6;
                    int iW = eVar2.W();
                    if (bVar12 == bVar10) {
                        iW = (fVar.W() - eVar2.f23044O.f23005g) - eVar2.f23046Q.f23005g;
                        bVar12 = e.b.FIXED;
                    }
                    int i9 = iW;
                    int iX = eVar2.x();
                    if (bVar11 == bVar10) {
                        iX = (fVar.x() - eVar2.f23045P.f23005g) - eVar2.f23047R.f23005g;
                        bVar11 = e.b.FIXED;
                    }
                    l(eVar2, bVar12, i9, bVar11, iX);
                    eVar2.f23064e.f23473e.d(eVar2.W());
                    eVar2.f23066f.f23473e.d(eVar2.x());
                    eVar2.f23056a = true;
                } else {
                    if (bVar6 == bVar9) {
                        bVar2 = bVar9;
                        f6 = 0.5f;
                        e.b bVar13 = e.b.WRAP_CONTENT;
                        f5 = 1.0f;
                        if (bVar7 != bVar13 && bVar7 != e.b.FIXED) {
                            bVar = bVar7;
                            i5 = 3;
                        } else if (i7 == 3) {
                            if (bVar7 == bVar13) {
                                l(eVar2, bVar13, 0, bVar13, 0);
                            }
                            int iX2 = eVar2.x();
                            int i10 = (int) ((iX2 * eVar2.f23063d0) + 0.5f);
                            e.b bVar14 = e.b.FIXED;
                            l(eVar2, bVar14, i10, bVar14, iX2);
                            eVar2.f23064e.f23473e.d(eVar2.W());
                            eVar2.f23066f.f23473e.d(eVar2.x());
                            eVar2.f23056a = true;
                        } else if (i7 == 1) {
                            l(eVar2, bVar13, 0, bVar7, 0);
                            eVar2.f23064e.f23473e.f23437m = eVar2.W();
                        } else {
                            bVar = bVar7;
                            i5 = 3;
                            if (i7 == 2) {
                                e.b bVar15 = fVar.f23055Z[c7];
                                e.b bVar16 = e.b.FIXED;
                                if (bVar15 == bVar16 || bVar15 == bVar10) {
                                    l(eVar2, bVar16, (int) ((eVar2.f23022B * fVar.W()) + 0.5f), bVar, eVar2.x());
                                    eVar2.f23064e.f23473e.d(eVar2.W());
                                    eVar2.f23066f.f23473e.d(eVar2.x());
                                    eVar2.f23056a = true;
                                }
                            } else {
                                v.d[] dVarArr = eVar2.f23052W;
                                if (dVarArr[c7].f23004f == null || dVarArr[1].f23004f == null) {
                                    l(eVar2, bVar13, 0, bVar, 0);
                                    eVar2.f23064e.f23473e.d(eVar2.W());
                                    eVar2.f23066f.f23473e.d(eVar2.x());
                                    eVar2.f23056a = true;
                                }
                            }
                        }
                    } else {
                        bVar = bVar7;
                        i5 = 3;
                        bVar2 = bVar9;
                        f5 = 1.0f;
                        f6 = 0.5f;
                    }
                    if (bVar != bVar2 || (bVar6 != (bVar4 = e.b.WRAP_CONTENT) && bVar6 != e.b.FIXED)) {
                        bVar3 = bVar6;
                    } else if (i8 == i5) {
                        if (bVar6 == bVar4) {
                            l(eVar2, bVar4, 0, bVar4, 0);
                        }
                        int iW2 = eVar2.W();
                        float f7 = eVar2.f23063d0;
                        if (eVar2.w() == -1) {
                            f7 = f5 / f7;
                        }
                        e.b bVar17 = e.b.FIXED;
                        l(eVar2, bVar17, iW2, bVar17, (int) ((iW2 * f7) + f6));
                        eVar2.f23064e.f23473e.d(eVar2.W());
                        eVar2.f23066f.f23473e.d(eVar2.x());
                        eVar2.f23056a = true;
                    } else if (i8 == 1) {
                        l(eVar2, bVar6, 0, bVar4, 0);
                        eVar2.f23066f.f23473e.f23437m = eVar2.x();
                    } else {
                        bVar3 = bVar6;
                        if (i8 == 2) {
                            e.b bVar18 = fVar.f23055Z[1];
                            bVar5 = bVar;
                            e.b bVar19 = e.b.FIXED;
                            if (bVar18 == bVar19 || bVar18 == bVar10) {
                                l(eVar2, bVar3, eVar2.W(), bVar19, (int) ((eVar2.f23028E * fVar.x()) + f6));
                                eVar2.f23064e.f23473e.d(eVar2.W());
                                eVar2.f23066f.f23473e.d(eVar2.x());
                                eVar2.f23056a = true;
                            }
                            bVar = bVar5;
                        } else {
                            bVar5 = bVar;
                            v.d[] dVarArr2 = eVar2.f23052W;
                            if (dVarArr2[2].f23004f == null || dVarArr2[i5].f23004f == null) {
                                l(eVar2, bVar4, 0, bVar5, 0);
                                eVar2.f23064e.f23473e.d(eVar2.W());
                                eVar2.f23066f.f23473e.d(eVar2.x());
                                eVar2.f23056a = true;
                            }
                            bVar = bVar5;
                        }
                    }
                    if (bVar3 == bVar2 && bVar == bVar2) {
                        if (i7 == 1 || i8 == 1) {
                            e.b bVar20 = e.b.WRAP_CONTENT;
                            l(eVar2, bVar20, 0, bVar20, 0);
                            eVar2.f23064e.f23473e.f23437m = eVar2.W();
                            eVar2.f23066f.f23473e.f23437m = eVar2.x();
                        } else if (i8 == 2 && i7 == 2) {
                            e.b[] bVarArr2 = fVar.f23055Z;
                            e.b bVar21 = bVarArr2[c7];
                            e.b bVar22 = e.b.FIXED;
                            if (bVar21 == bVar22 && bVarArr2[1] == bVar22) {
                                l(eVar2, bVar22, (int) ((eVar2.f23022B * fVar.W()) + f6), bVar22, (int) ((eVar2.f23028E * fVar.x()) + f6));
                                eVar2.f23064e.f23473e.d(eVar2.W());
                                eVar2.f23066f.f23473e.d(eVar2.x());
                                eVar2.f23056a = true;
                            }
                        }
                    }
                }
                c6 = c7;
            }
        }
        return c6 == true ? 1 : 0;
    }

    private int e(v.f fVar, int i5) {
        int size = this.f23415i.size();
        long jMax = 0;
        for (int i6 = 0; i6 < size; i6++) {
            jMax = Math.max(jMax, this.f23415i.get(i6).b(fVar, i5));
        }
        return (int) jMax;
    }

    private void i(p pVar, int i5, ArrayList<m> arrayList) {
        for (InterfaceC1198d interfaceC1198d : pVar.f23476h.f23426k) {
            if (interfaceC1198d instanceof f) {
                a((f) interfaceC1198d, i5, 0, pVar.f23477i, arrayList, null);
            } else if (interfaceC1198d instanceof p) {
                a(((p) interfaceC1198d).f23476h, i5, 0, pVar.f23477i, arrayList, null);
            }
        }
        for (InterfaceC1198d interfaceC1198d2 : pVar.f23477i.f23426k) {
            if (interfaceC1198d2 instanceof f) {
                a((f) interfaceC1198d2, i5, 1, pVar.f23476h, arrayList, null);
            } else if (interfaceC1198d2 instanceof p) {
                a(((p) interfaceC1198d2).f23477i, i5, 1, pVar.f23476h, arrayList, null);
            }
        }
        int i6 = i5;
        if (i6 == 1) {
            for (InterfaceC1198d interfaceC1198d3 : ((n) pVar).f23451k.f23426k) {
                if (interfaceC1198d3 instanceof f) {
                    a((f) interfaceC1198d3, i6, 2, null, arrayList, null);
                }
                i6 = i5;
            }
        }
    }

    private void l(v.e eVar, e.b bVar, int i5, e.b bVar2, int i6) {
        C1196b.a aVar = this.f23414h;
        aVar.f23395a = bVar;
        aVar.f23396b = bVar2;
        aVar.f23397c = i5;
        aVar.f23398d = i6;
        this.f23413g.b(eVar, aVar);
        eVar.k1(this.f23414h.f23399e);
        eVar.L0(this.f23414h.f23400f);
        eVar.K0(this.f23414h.f23402h);
        eVar.A0(this.f23414h.f23401g);
    }

    public void c() {
        d(this.f23411e);
        this.f23415i.clear();
        m.f23443h = 0;
        i(this.f23407a.f23064e, 0, this.f23415i);
        i(this.f23407a.f23066f, 1, this.f23415i);
        this.f23408b = false;
    }

    public void d(ArrayList<p> arrayList) {
        arrayList.clear();
        this.f23410d.f23064e.f();
        this.f23410d.f23066f.f();
        arrayList.add(this.f23410d.f23064e);
        arrayList.add(this.f23410d.f23066f);
        ArrayList<v.e> arrayList2 = this.f23410d.f23213L0;
        int size = arrayList2.size();
        HashSet hashSet = null;
        int i5 = 0;
        int i6 = 0;
        while (i6 < size) {
            v.e eVar = arrayList2.get(i6);
            i6++;
            v.e eVar2 = eVar;
            if (eVar2 instanceof v.h) {
                arrayList.add(new j(eVar2));
            } else {
                if (eVar2.i0()) {
                    if (eVar2.f23060c == null) {
                        eVar2.f23060c = new C1197c(eVar2, 0);
                    }
                    if (hashSet == null) {
                        hashSet = new HashSet();
                    }
                    hashSet.add(eVar2.f23060c);
                } else {
                    arrayList.add(eVar2.f23064e);
                }
                if (eVar2.k0()) {
                    if (eVar2.f23062d == null) {
                        eVar2.f23062d = new C1197c(eVar2, 1);
                    }
                    if (hashSet == null) {
                        hashSet = new HashSet();
                    }
                    hashSet.add(eVar2.f23062d);
                } else {
                    arrayList.add(eVar2.f23066f);
                }
                if (eVar2 instanceof v.j) {
                    arrayList.add(new k(eVar2));
                }
            }
        }
        if (hashSet != null) {
            arrayList.addAll(hashSet);
        }
        int size2 = arrayList.size();
        int i7 = 0;
        while (i7 < size2) {
            p pVar = arrayList.get(i7);
            i7++;
            pVar.f();
        }
        int size3 = arrayList.size();
        while (i5 < size3) {
            p pVar2 = arrayList.get(i5);
            i5++;
            p pVar3 = pVar2;
            if (pVar3.f23470b != this.f23410d) {
                pVar3.d();
            }
        }
    }

    public boolean f(boolean z5) {
        boolean z6;
        boolean z7 = false;
        if (this.f23408b || this.f23409c) {
            ArrayList<v.e> arrayList = this.f23407a.f23213L0;
            int size = arrayList.size();
            int i5 = 0;
            while (i5 < size) {
                v.e eVar = arrayList.get(i5);
                i5++;
                v.e eVar2 = eVar;
                eVar2.n();
                eVar2.f23056a = false;
                eVar2.f23064e.r();
                eVar2.f23066f.q();
            }
            this.f23407a.n();
            v.f fVar = this.f23407a;
            fVar.f23056a = false;
            fVar.f23064e.r();
            this.f23407a.f23066f.q();
            this.f23409c = false;
        }
        if (b(this.f23410d)) {
            return false;
        }
        this.f23407a.m1(0);
        this.f23407a.n1(0);
        e.b bVarU = this.f23407a.u(0);
        e.b bVarU2 = this.f23407a.u(1);
        if (this.f23408b) {
            c();
        }
        int iX = this.f23407a.X();
        int iY = this.f23407a.Y();
        this.f23407a.f23064e.f23476h.d(iX);
        this.f23407a.f23066f.f23476h.d(iY);
        m();
        e.b bVar = e.b.WRAP_CONTENT;
        if (bVarU == bVar || bVarU2 == bVar) {
            if (z5) {
                ArrayList<p> arrayList2 = this.f23411e;
                int size2 = arrayList2.size();
                int i6 = 0;
                while (true) {
                    if (i6 >= size2) {
                        break;
                    }
                    p pVar = arrayList2.get(i6);
                    i6++;
                    if (!pVar.m()) {
                        z5 = false;
                        break;
                    }
                }
            }
            if (z5 && bVarU == e.b.WRAP_CONTENT) {
                this.f23407a.P0(e.b.FIXED);
                v.f fVar2 = this.f23407a;
                fVar2.k1(e(fVar2, 0));
                v.f fVar3 = this.f23407a;
                fVar3.f23064e.f23473e.d(fVar3.W());
            }
            if (z5 && bVarU2 == e.b.WRAP_CONTENT) {
                this.f23407a.g1(e.b.FIXED);
                v.f fVar4 = this.f23407a;
                fVar4.L0(e(fVar4, 1));
                v.f fVar5 = this.f23407a;
                fVar5.f23066f.f23473e.d(fVar5.x());
            }
        }
        v.f fVar6 = this.f23407a;
        e.b bVar2 = fVar6.f23055Z[0];
        e.b bVar3 = e.b.FIXED;
        if (bVar2 == bVar3 || bVar2 == e.b.MATCH_PARENT) {
            int iW = fVar6.W() + iX;
            this.f23407a.f23064e.f23477i.d(iW);
            this.f23407a.f23064e.f23473e.d(iW - iX);
            m();
            v.f fVar7 = this.f23407a;
            e.b bVar4 = fVar7.f23055Z[1];
            if (bVar4 == bVar3 || bVar4 == e.b.MATCH_PARENT) {
                int iX2 = fVar7.x() + iY;
                this.f23407a.f23066f.f23477i.d(iX2);
                this.f23407a.f23066f.f23473e.d(iX2 - iY);
            }
            m();
            z6 = true;
        } else {
            z6 = false;
        }
        ArrayList<p> arrayList3 = this.f23411e;
        int size3 = arrayList3.size();
        int i7 = 0;
        while (i7 < size3) {
            p pVar2 = arrayList3.get(i7);
            i7++;
            p pVar3 = pVar2;
            if (pVar3.f23470b != this.f23407a || pVar3.f23475g) {
                pVar3.e();
            }
        }
        ArrayList<p> arrayList4 = this.f23411e;
        int size4 = arrayList4.size();
        int i8 = 0;
        while (true) {
            if (i8 >= size4) {
                z7 = true;
                break;
            }
            p pVar4 = arrayList4.get(i8);
            i8++;
            p pVar5 = pVar4;
            if (z6 || pVar5.f23470b != this.f23407a) {
                if (!pVar5.f23476h.f23425j || ((!pVar5.f23477i.f23425j && !(pVar5 instanceof j)) || (!pVar5.f23473e.f23425j && !(pVar5 instanceof C1197c) && !(pVar5 instanceof j)))) {
                    break;
                }
            }
        }
        this.f23407a.P0(bVarU);
        this.f23407a.g1(bVarU2);
        return z7;
    }

    public boolean g(boolean z5) {
        if (this.f23408b) {
            ArrayList<v.e> arrayList = this.f23407a.f23213L0;
            int size = arrayList.size();
            int i5 = 0;
            while (i5 < size) {
                v.e eVar = arrayList.get(i5);
                i5++;
                v.e eVar2 = eVar;
                eVar2.n();
                eVar2.f23056a = false;
                l lVar = eVar2.f23064e;
                lVar.f23473e.f23425j = false;
                lVar.f23475g = false;
                lVar.r();
                n nVar = eVar2.f23066f;
                nVar.f23473e.f23425j = false;
                nVar.f23475g = false;
                nVar.q();
            }
            this.f23407a.n();
            v.f fVar = this.f23407a;
            fVar.f23056a = false;
            l lVar2 = fVar.f23064e;
            lVar2.f23473e.f23425j = false;
            lVar2.f23475g = false;
            lVar2.r();
            n nVar2 = this.f23407a.f23066f;
            nVar2.f23473e.f23425j = false;
            nVar2.f23475g = false;
            nVar2.q();
            c();
        }
        if (b(this.f23410d)) {
            return false;
        }
        this.f23407a.m1(0);
        this.f23407a.n1(0);
        this.f23407a.f23064e.f23476h.d(0);
        this.f23407a.f23066f.f23476h.d(0);
        return true;
    }

    public boolean h(boolean z5, int i5) {
        boolean z6;
        e.b bVar;
        boolean z7 = false;
        e.b bVarU = this.f23407a.u(0);
        e.b bVarU2 = this.f23407a.u(1);
        int iX = this.f23407a.X();
        int iY = this.f23407a.Y();
        if (z5 && (bVarU == (bVar = e.b.WRAP_CONTENT) || bVarU2 == bVar)) {
            ArrayList<p> arrayList = this.f23411e;
            int size = arrayList.size();
            int i6 = 0;
            while (true) {
                if (i6 >= size) {
                    break;
                }
                p pVar = arrayList.get(i6);
                i6++;
                p pVar2 = pVar;
                if (pVar2.f23474f == i5 && !pVar2.m()) {
                    z5 = false;
                    break;
                }
            }
            if (i5 == 0) {
                if (z5 && bVarU == e.b.WRAP_CONTENT) {
                    this.f23407a.P0(e.b.FIXED);
                    v.f fVar = this.f23407a;
                    fVar.k1(e(fVar, 0));
                    v.f fVar2 = this.f23407a;
                    fVar2.f23064e.f23473e.d(fVar2.W());
                }
            } else if (z5 && bVarU2 == e.b.WRAP_CONTENT) {
                this.f23407a.g1(e.b.FIXED);
                v.f fVar3 = this.f23407a;
                fVar3.L0(e(fVar3, 1));
                v.f fVar4 = this.f23407a;
                fVar4.f23066f.f23473e.d(fVar4.x());
            }
        }
        if (i5 == 0) {
            v.f fVar5 = this.f23407a;
            e.b bVar2 = fVar5.f23055Z[0];
            if (bVar2 == e.b.FIXED || bVar2 == e.b.MATCH_PARENT) {
                int iW = fVar5.W() + iX;
                this.f23407a.f23064e.f23477i.d(iW);
                this.f23407a.f23064e.f23473e.d(iW - iX);
                z6 = true;
            }
            z6 = false;
        } else {
            v.f fVar6 = this.f23407a;
            e.b bVar3 = fVar6.f23055Z[1];
            if (bVar3 == e.b.FIXED || bVar3 == e.b.MATCH_PARENT) {
                int iX2 = fVar6.x() + iY;
                this.f23407a.f23066f.f23477i.d(iX2);
                this.f23407a.f23066f.f23473e.d(iX2 - iY);
                z6 = true;
            }
            z6 = false;
        }
        m();
        ArrayList<p> arrayList2 = this.f23411e;
        int size2 = arrayList2.size();
        int i7 = 0;
        while (i7 < size2) {
            p pVar3 = arrayList2.get(i7);
            i7++;
            p pVar4 = pVar3;
            if (pVar4.f23474f == i5 && (pVar4.f23470b != this.f23407a || pVar4.f23475g)) {
                pVar4.e();
            }
        }
        ArrayList<p> arrayList3 = this.f23411e;
        int size3 = arrayList3.size();
        int i8 = 0;
        while (true) {
            if (i8 >= size3) {
                z7 = true;
                break;
            }
            p pVar5 = arrayList3.get(i8);
            i8++;
            p pVar6 = pVar5;
            if (pVar6.f23474f == i5 && (z6 || pVar6.f23470b != this.f23407a)) {
                if (!pVar6.f23476h.f23425j || !pVar6.f23477i.f23425j || (!(pVar6 instanceof C1197c) && !pVar6.f23473e.f23425j)) {
                    break;
                }
            }
        }
        this.f23407a.P0(bVarU);
        this.f23407a.g1(bVarU2);
        return z7;
    }

    public void j() {
        this.f23408b = true;
    }

    public void k() {
        this.f23409c = true;
    }

    public void m() {
        C1199e c1199e;
        g gVar;
        ArrayList<v.e> arrayList = this.f23407a.f23213L0;
        int size = arrayList.size();
        int i5 = 0;
        while (i5 < size) {
            v.e eVar = arrayList.get(i5);
            i5++;
            v.e eVar2 = eVar;
            if (!eVar2.f23056a) {
                e.b[] bVarArr = eVar2.f23055Z;
                e.b bVar = bVarArr[0];
                e.b bVar2 = bVarArr[1];
                int i6 = eVar2.f23100w;
                int i7 = eVar2.f23102x;
                e.b bVar3 = e.b.WRAP_CONTENT;
                boolean z5 = bVar == bVar3 || (bVar == e.b.MATCH_CONSTRAINT && i6 == 1);
                boolean z6 = bVar2 == bVar3 || (bVar2 == e.b.MATCH_CONSTRAINT && i7 == 1);
                g gVar2 = eVar2.f23064e.f23473e;
                boolean z7 = gVar2.f23425j;
                g gVar3 = eVar2.f23066f.f23473e;
                boolean z8 = gVar3.f23425j;
                if (z7 && z8) {
                    e.b bVar4 = e.b.FIXED;
                    c1199e = this;
                    c1199e.l(eVar2, bVar4, gVar2.f23422g, bVar4, gVar3.f23422g);
                    eVar2.f23056a = true;
                } else {
                    if (z7 && z6) {
                        this.l(eVar2, e.b.FIXED, gVar2.f23422g, bVar3, gVar3.f23422g);
                        if (bVar2 == e.b.MATCH_CONSTRAINT) {
                            eVar2.f23066f.f23473e.f23437m = eVar2.x();
                        } else {
                            eVar2.f23066f.f23473e.d(eVar2.x());
                            eVar2.f23056a = true;
                        }
                    } else if (z8 && z5) {
                        c1199e = this;
                        c1199e.l(eVar2, bVar3, gVar2.f23422g, e.b.FIXED, gVar3.f23422g);
                        if (bVar == e.b.MATCH_CONSTRAINT) {
                            eVar2.f23064e.f23473e.f23437m = eVar2.W();
                        } else {
                            eVar2.f23064e.f23473e.d(eVar2.W());
                            eVar2.f23056a = true;
                        }
                    }
                    c1199e = this;
                }
                if (eVar2.f23056a && (gVar = eVar2.f23066f.f23452l) != null) {
                    gVar.d(eVar2.p());
                }
                this = c1199e;
            }
        }
    }

    public void n(C1196b.InterfaceC0254b interfaceC0254b) {
        this.f23413g = interfaceC0254b;
    }
}
