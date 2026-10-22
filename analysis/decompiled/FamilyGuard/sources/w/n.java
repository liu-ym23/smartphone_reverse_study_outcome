package w;

import v.d;
import v.e;
import w.f;
import w.p;

/* loaded from: classes.dex */
public class n extends p {

    /* renamed from: k, reason: collision with root package name */
    public f f23451k;

    /* renamed from: l, reason: collision with root package name */
    g f23452l;

    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f23453a;

        static {
            int[] iArr = new int[p.b.values().length];
            f23453a = iArr;
            try {
                iArr[p.b.START.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f23453a[p.b.END.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f23453a[p.b.CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public n(v.e eVar) {
        super(eVar);
        f fVar = new f(this);
        this.f23451k = fVar;
        this.f23452l = null;
        this.f23476h.f23420e = f.a.TOP;
        this.f23477i.f23420e = f.a.BOTTOM;
        fVar.f23420e = f.a.BASELINE;
        this.f23474f = 1;
    }

    @Override // w.p, w.InterfaceC1198d
    public void a(InterfaceC1198d interfaceC1198d) {
        float f5;
        float fV;
        float fV2;
        int i5;
        int i6 = a.f23453a[this.f23478j.ordinal()];
        if (i6 == 1) {
            p(interfaceC1198d);
        } else if (i6 == 2) {
            o(interfaceC1198d);
        } else if (i6 == 3) {
            v.e eVar = this.f23470b;
            n(interfaceC1198d, eVar.f23045P, eVar.f23047R, 1);
            return;
        }
        g gVar = this.f23473e;
        if (gVar.f23418c && !gVar.f23425j && this.f23472d == e.b.MATCH_CONSTRAINT) {
            v.e eVar2 = this.f23470b;
            int i7 = eVar2.f23102x;
            if (i7 == 2) {
                v.e eVarK = eVar2.K();
                if (eVarK != null) {
                    if (eVarK.f23066f.f23473e.f23425j) {
                        this.f23473e.d((int) ((r7.f23422g * this.f23470b.f23028E) + 0.5f));
                    }
                }
            } else if (i7 == 3 && eVar2.f23064e.f23473e.f23425j) {
                int iW = eVar2.w();
                if (iW == -1) {
                    v.e eVar3 = this.f23470b;
                    f5 = eVar3.f23064e.f23473e.f23422g;
                    fV = eVar3.v();
                } else if (iW == 0) {
                    fV2 = r7.f23064e.f23473e.f23422g * this.f23470b.v();
                    i5 = (int) (fV2 + 0.5f);
                    this.f23473e.d(i5);
                } else if (iW != 1) {
                    i5 = 0;
                    this.f23473e.d(i5);
                } else {
                    v.e eVar4 = this.f23470b;
                    f5 = eVar4.f23064e.f23473e.f23422g;
                    fV = eVar4.v();
                }
                fV2 = f5 / fV;
                i5 = (int) (fV2 + 0.5f);
                this.f23473e.d(i5);
            }
        }
        f fVar = this.f23476h;
        if (fVar.f23418c) {
            f fVar2 = this.f23477i;
            if (fVar2.f23418c) {
                if (fVar.f23425j && fVar2.f23425j && this.f23473e.f23425j) {
                    return;
                }
                if (!this.f23473e.f23425j && this.f23472d == e.b.MATCH_CONSTRAINT) {
                    v.e eVar5 = this.f23470b;
                    if (eVar5.f23100w == 0 && !eVar5.k0()) {
                        f fVar3 = this.f23476h.f23427l.get(0);
                        f fVar4 = this.f23477i.f23427l.get(0);
                        int i8 = fVar3.f23422g;
                        f fVar5 = this.f23476h;
                        int i9 = i8 + fVar5.f23421f;
                        int i10 = fVar4.f23422g + this.f23477i.f23421f;
                        fVar5.d(i9);
                        this.f23477i.d(i10);
                        this.f23473e.d(i10 - i9);
                        return;
                    }
                }
                if (!this.f23473e.f23425j && this.f23472d == e.b.MATCH_CONSTRAINT && this.f23469a == 1 && this.f23476h.f23427l.size() > 0 && this.f23477i.f23427l.size() > 0) {
                    f fVar6 = this.f23476h.f23427l.get(0);
                    int i11 = (this.f23477i.f23427l.get(0).f23422g + this.f23477i.f23421f) - (fVar6.f23422g + this.f23476h.f23421f);
                    g gVar2 = this.f23473e;
                    int i12 = gVar2.f23437m;
                    if (i11 < i12) {
                        gVar2.d(i11);
                    } else {
                        gVar2.d(i12);
                    }
                }
                if (this.f23473e.f23425j && this.f23476h.f23427l.size() > 0 && this.f23477i.f23427l.size() > 0) {
                    f fVar7 = this.f23476h.f23427l.get(0);
                    f fVar8 = this.f23477i.f23427l.get(0);
                    int i13 = fVar7.f23422g + this.f23476h.f23421f;
                    int i14 = fVar8.f23422g + this.f23477i.f23421f;
                    float fR = this.f23470b.R();
                    if (fVar7 == fVar8) {
                        i13 = fVar7.f23422g;
                        i14 = fVar8.f23422g;
                        fR = 0.5f;
                    }
                    this.f23476h.d((int) (i13 + 0.5f + (((i14 - i13) - this.f23473e.f23422g) * fR)));
                    this.f23477i.d(this.f23476h.f23422g + this.f23473e.f23422g);
                }
            }
        }
    }

    @Override // w.p
    void d() {
        v.e eVarK;
        v.e eVarK2;
        v.e eVar = this.f23470b;
        if (eVar.f23056a) {
            this.f23473e.d(eVar.x());
        }
        if (!this.f23473e.f23425j) {
            this.f23472d = this.f23470b.T();
            if (this.f23470b.Z()) {
                this.f23452l = new C1195a(this);
            }
            e.b bVar = this.f23472d;
            if (bVar != e.b.MATCH_CONSTRAINT) {
                if (bVar == e.b.MATCH_PARENT && (eVarK2 = this.f23470b.K()) != null && eVarK2.T() == e.b.FIXED) {
                    int iX = (eVarK2.x() - this.f23470b.f23045P.f()) - this.f23470b.f23047R.f();
                    b(this.f23476h, eVarK2.f23066f.f23476h, this.f23470b.f23045P.f());
                    b(this.f23477i, eVarK2.f23066f.f23477i, -this.f23470b.f23047R.f());
                    this.f23473e.d(iX);
                    return;
                }
                if (this.f23472d == e.b.FIXED) {
                    this.f23473e.d(this.f23470b.x());
                }
            }
        } else if (this.f23472d == e.b.MATCH_PARENT && (eVarK = this.f23470b.K()) != null && eVarK.T() == e.b.FIXED) {
            b(this.f23476h, eVarK.f23066f.f23476h, this.f23470b.f23045P.f());
            b(this.f23477i, eVarK.f23066f.f23477i, -this.f23470b.f23047R.f());
            return;
        }
        g gVar = this.f23473e;
        boolean z5 = gVar.f23425j;
        if (z5) {
            v.e eVar2 = this.f23470b;
            if (eVar2.f23056a) {
                v.d[] dVarArr = eVar2.f23052W;
                v.d dVar = dVarArr[2];
                v.d dVar2 = dVar.f23004f;
                if (dVar2 != null && dVarArr[3].f23004f != null) {
                    if (eVar2.k0()) {
                        this.f23476h.f23421f = this.f23470b.f23052W[2].f();
                        this.f23477i.f23421f = -this.f23470b.f23052W[3].f();
                    } else {
                        f fVarH = h(this.f23470b.f23052W[2]);
                        if (fVarH != null) {
                            b(this.f23476h, fVarH, this.f23470b.f23052W[2].f());
                        }
                        f fVarH2 = h(this.f23470b.f23052W[3]);
                        if (fVarH2 != null) {
                            b(this.f23477i, fVarH2, -this.f23470b.f23052W[3].f());
                        }
                        this.f23476h.f23417b = true;
                        this.f23477i.f23417b = true;
                    }
                    if (this.f23470b.Z()) {
                        b(this.f23451k, this.f23476h, this.f23470b.p());
                        return;
                    }
                    return;
                }
                if (dVar2 != null) {
                    f fVarH3 = h(dVar);
                    if (fVarH3 != null) {
                        b(this.f23476h, fVarH3, this.f23470b.f23052W[2].f());
                        b(this.f23477i, this.f23476h, this.f23473e.f23422g);
                        if (this.f23470b.Z()) {
                            b(this.f23451k, this.f23476h, this.f23470b.p());
                            return;
                        }
                        return;
                    }
                    return;
                }
                v.d dVar3 = dVarArr[3];
                if (dVar3.f23004f != null) {
                    f fVarH4 = h(dVar3);
                    if (fVarH4 != null) {
                        b(this.f23477i, fVarH4, -this.f23470b.f23052W[3].f());
                        b(this.f23476h, this.f23477i, -this.f23473e.f23422g);
                    }
                    if (this.f23470b.Z()) {
                        b(this.f23451k, this.f23476h, this.f23470b.p());
                        return;
                    }
                    return;
                }
                v.d dVar4 = dVarArr[4];
                if (dVar4.f23004f != null) {
                    f fVarH5 = h(dVar4);
                    if (fVarH5 != null) {
                        b(this.f23451k, fVarH5, 0);
                        b(this.f23476h, this.f23451k, -this.f23470b.p());
                        b(this.f23477i, this.f23476h, this.f23473e.f23422g);
                        return;
                    }
                    return;
                }
                if ((eVar2 instanceof v.i) || eVar2.K() == null || this.f23470b.o(d.b.CENTER).f23004f != null) {
                    return;
                }
                b(this.f23476h, this.f23470b.K().f23066f.f23476h, this.f23470b.Y());
                b(this.f23477i, this.f23476h, this.f23473e.f23422g);
                if (this.f23470b.Z()) {
                    b(this.f23451k, this.f23476h, this.f23470b.p());
                    return;
                }
                return;
            }
        }
        if (z5 || this.f23472d != e.b.MATCH_CONSTRAINT) {
            gVar.b(this);
        } else {
            v.e eVar3 = this.f23470b;
            int i5 = eVar3.f23102x;
            if (i5 == 2) {
                v.e eVarK3 = eVar3.K();
                if (eVarK3 != null) {
                    g gVar2 = eVarK3.f23066f.f23473e;
                    this.f23473e.f23427l.add(gVar2);
                    gVar2.f23426k.add(this.f23473e);
                    g gVar3 = this.f23473e;
                    gVar3.f23417b = true;
                    gVar3.f23426k.add(this.f23476h);
                    this.f23473e.f23426k.add(this.f23477i);
                }
            } else if (i5 == 3 && !eVar3.k0()) {
                v.e eVar4 = this.f23470b;
                if (eVar4.f23100w != 3) {
                    g gVar4 = eVar4.f23064e.f23473e;
                    this.f23473e.f23427l.add(gVar4);
                    gVar4.f23426k.add(this.f23473e);
                    g gVar5 = this.f23473e;
                    gVar5.f23417b = true;
                    gVar5.f23426k.add(this.f23476h);
                    this.f23473e.f23426k.add(this.f23477i);
                }
            }
        }
        v.e eVar5 = this.f23470b;
        v.d[] dVarArr2 = eVar5.f23052W;
        v.d dVar5 = dVarArr2[2];
        v.d dVar6 = dVar5.f23004f;
        if (dVar6 != null && dVarArr2[3].f23004f != null) {
            if (eVar5.k0()) {
                this.f23476h.f23421f = this.f23470b.f23052W[2].f();
                this.f23477i.f23421f = -this.f23470b.f23052W[3].f();
            } else {
                f fVarH6 = h(this.f23470b.f23052W[2]);
                f fVarH7 = h(this.f23470b.f23052W[3]);
                if (fVarH6 != null) {
                    fVarH6.b(this);
                }
                if (fVarH7 != null) {
                    fVarH7.b(this);
                }
                this.f23478j = p.b.CENTER;
            }
            if (this.f23470b.Z()) {
                c(this.f23451k, this.f23476h, 1, this.f23452l);
            }
        } else if (dVar6 != null) {
            f fVarH8 = h(dVar5);
            if (fVarH8 != null) {
                b(this.f23476h, fVarH8, this.f23470b.f23052W[2].f());
                c(this.f23477i, this.f23476h, 1, this.f23473e);
                if (this.f23470b.Z()) {
                    c(this.f23451k, this.f23476h, 1, this.f23452l);
                }
                e.b bVar2 = this.f23472d;
                e.b bVar3 = e.b.MATCH_CONSTRAINT;
                if (bVar2 == bVar3 && this.f23470b.v() > 0.0f) {
                    l lVar = this.f23470b.f23064e;
                    if (lVar.f23472d == bVar3) {
                        lVar.f23473e.f23426k.add(this.f23473e);
                        this.f23473e.f23427l.add(this.f23470b.f23064e.f23473e);
                        this.f23473e.f23416a = this;
                    }
                }
            }
        } else {
            v.d dVar7 = dVarArr2[3];
            if (dVar7.f23004f != null) {
                f fVarH9 = h(dVar7);
                if (fVarH9 != null) {
                    b(this.f23477i, fVarH9, -this.f23470b.f23052W[3].f());
                    c(this.f23476h, this.f23477i, -1, this.f23473e);
                    if (this.f23470b.Z()) {
                        c(this.f23451k, this.f23476h, 1, this.f23452l);
                    }
                }
            } else {
                v.d dVar8 = dVarArr2[4];
                if (dVar8.f23004f != null) {
                    f fVarH10 = h(dVar8);
                    if (fVarH10 != null) {
                        b(this.f23451k, fVarH10, 0);
                        c(this.f23476h, this.f23451k, -1, this.f23452l);
                        c(this.f23477i, this.f23476h, 1, this.f23473e);
                    }
                } else if (!(eVar5 instanceof v.i) && eVar5.K() != null) {
                    b(this.f23476h, this.f23470b.K().f23066f.f23476h, this.f23470b.Y());
                    c(this.f23477i, this.f23476h, 1, this.f23473e);
                    if (this.f23470b.Z()) {
                        c(this.f23451k, this.f23476h, 1, this.f23452l);
                    }
                    e.b bVar4 = this.f23472d;
                    e.b bVar5 = e.b.MATCH_CONSTRAINT;
                    if (bVar4 == bVar5 && this.f23470b.v() > 0.0f) {
                        l lVar2 = this.f23470b.f23064e;
                        if (lVar2.f23472d == bVar5) {
                            lVar2.f23473e.f23426k.add(this.f23473e);
                            this.f23473e.f23427l.add(this.f23470b.f23064e.f23473e);
                            this.f23473e.f23416a = this;
                        }
                    }
                }
            }
        }
        if (this.f23473e.f23427l.size() == 0) {
            this.f23473e.f23418c = true;
        }
    }

    @Override // w.p
    public void e() {
        f fVar = this.f23476h;
        if (fVar.f23425j) {
            this.f23470b.n1(fVar.f23422g);
        }
    }

    @Override // w.p
    void f() {
        this.f23471c = null;
        this.f23476h.c();
        this.f23477i.c();
        this.f23451k.c();
        this.f23473e.c();
        this.f23475g = false;
    }

    @Override // w.p
    boolean m() {
        return this.f23472d != e.b.MATCH_CONSTRAINT || this.f23470b.f23102x == 0;
    }

    void q() {
        this.f23475g = false;
        this.f23476h.c();
        this.f23476h.f23425j = false;
        this.f23477i.c();
        this.f23477i.f23425j = false;
        this.f23451k.c();
        this.f23451k.f23425j = false;
        this.f23473e.f23425j = false;
    }

    public String toString() {
        return "VerticalRun " + this.f23470b.t();
    }
}
