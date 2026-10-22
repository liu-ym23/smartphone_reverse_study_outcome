package w;

import v.d;
import v.e;
import w.f;
import w.p;

/* loaded from: classes.dex */
public class l extends p {

    /* renamed from: k, reason: collision with root package name */
    private static int[] f23441k = new int[2];

    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f23442a;

        static {
            int[] iArr = new int[p.b.values().length];
            f23442a = iArr;
            try {
                iArr[p.b.START.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f23442a[p.b.END.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f23442a[p.b.CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public l(v.e eVar) {
        super(eVar);
        this.f23476h.f23420e = f.a.LEFT;
        this.f23477i.f23420e = f.a.RIGHT;
        this.f23474f = 0;
    }

    private void q(int[] iArr, int i5, int i6, int i7, int i8, float f5, int i9) {
        int i10 = i6 - i5;
        int i11 = i8 - i7;
        if (i9 != -1) {
            if (i9 == 0) {
                iArr[0] = (int) ((i11 * f5) + 0.5f);
                iArr[1] = i11;
                return;
            } else {
                if (i9 != 1) {
                    return;
                }
                iArr[0] = i10;
                iArr[1] = (int) ((i10 * f5) + 0.5f);
                return;
            }
        }
        int i12 = (int) ((i11 * f5) + 0.5f);
        int i13 = (int) ((i10 / f5) + 0.5f);
        if (i12 <= i10) {
            iArr[0] = i12;
            iArr[1] = i11;
        } else if (i13 <= i11) {
            iArr[0] = i10;
            iArr[1] = i13;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:122:0x02ca  */
    @Override // w.p, w.InterfaceC1198d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(w.InterfaceC1198d r14) {
        /*
            Method dump skipped, instructions count: 1067
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: w.l.a(w.d):void");
    }

    @Override // w.p
    void d() {
        v.e eVarK;
        v.e eVarK2;
        v.e eVar = this.f23470b;
        if (eVar.f23056a) {
            this.f23473e.d(eVar.W());
        }
        if (this.f23473e.f23425j) {
            e.b bVar = this.f23472d;
            e.b bVar2 = e.b.MATCH_PARENT;
            if (bVar == bVar2 && (eVarK = this.f23470b.K()) != null && (eVarK.A() == e.b.FIXED || eVarK.A() == bVar2)) {
                b(this.f23476h, eVarK.f23064e.f23476h, this.f23470b.f23044O.f());
                b(this.f23477i, eVarK.f23064e.f23477i, -this.f23470b.f23046Q.f());
                return;
            }
        } else {
            e.b bVarA = this.f23470b.A();
            this.f23472d = bVarA;
            if (bVarA != e.b.MATCH_CONSTRAINT) {
                e.b bVar3 = e.b.MATCH_PARENT;
                if (bVarA == bVar3 && (eVarK2 = this.f23470b.K()) != null && (eVarK2.A() == e.b.FIXED || eVarK2.A() == bVar3)) {
                    int iW = (eVarK2.W() - this.f23470b.f23044O.f()) - this.f23470b.f23046Q.f();
                    b(this.f23476h, eVarK2.f23064e.f23476h, this.f23470b.f23044O.f());
                    b(this.f23477i, eVarK2.f23064e.f23477i, -this.f23470b.f23046Q.f());
                    this.f23473e.d(iW);
                    return;
                }
                if (this.f23472d == e.b.FIXED) {
                    this.f23473e.d(this.f23470b.W());
                }
            }
        }
        g gVar = this.f23473e;
        if (gVar.f23425j) {
            v.e eVar2 = this.f23470b;
            if (eVar2.f23056a) {
                v.d[] dVarArr = eVar2.f23052W;
                v.d dVar = dVarArr[0];
                v.d dVar2 = dVar.f23004f;
                if (dVar2 != null && dVarArr[1].f23004f != null) {
                    if (eVar2.i0()) {
                        this.f23476h.f23421f = this.f23470b.f23052W[0].f();
                        this.f23477i.f23421f = -this.f23470b.f23052W[1].f();
                        return;
                    }
                    f fVarH = h(this.f23470b.f23052W[0]);
                    if (fVarH != null) {
                        b(this.f23476h, fVarH, this.f23470b.f23052W[0].f());
                    }
                    f fVarH2 = h(this.f23470b.f23052W[1]);
                    if (fVarH2 != null) {
                        b(this.f23477i, fVarH2, -this.f23470b.f23052W[1].f());
                    }
                    this.f23476h.f23417b = true;
                    this.f23477i.f23417b = true;
                    return;
                }
                if (dVar2 != null) {
                    f fVarH3 = h(dVar);
                    if (fVarH3 != null) {
                        b(this.f23476h, fVarH3, this.f23470b.f23052W[0].f());
                        b(this.f23477i, this.f23476h, this.f23473e.f23422g);
                        return;
                    }
                    return;
                }
                v.d dVar3 = dVarArr[1];
                if (dVar3.f23004f != null) {
                    f fVarH4 = h(dVar3);
                    if (fVarH4 != null) {
                        b(this.f23477i, fVarH4, -this.f23470b.f23052W[1].f());
                        b(this.f23476h, this.f23477i, -this.f23473e.f23422g);
                        return;
                    }
                    return;
                }
                if ((eVar2 instanceof v.i) || eVar2.K() == null || this.f23470b.o(d.b.CENTER).f23004f != null) {
                    return;
                }
                b(this.f23476h, this.f23470b.K().f23064e.f23476h, this.f23470b.X());
                b(this.f23477i, this.f23476h, this.f23473e.f23422g);
                return;
            }
        }
        if (this.f23472d == e.b.MATCH_CONSTRAINT) {
            v.e eVar3 = this.f23470b;
            int i5 = eVar3.f23100w;
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
            } else if (i5 == 3) {
                if (eVar3.f23102x == 3) {
                    this.f23476h.f23416a = this;
                    this.f23477i.f23416a = this;
                    n nVar = eVar3.f23066f;
                    nVar.f23476h.f23416a = this;
                    nVar.f23477i.f23416a = this;
                    gVar.f23416a = this;
                    if (eVar3.k0()) {
                        this.f23473e.f23427l.add(this.f23470b.f23066f.f23473e);
                        this.f23470b.f23066f.f23473e.f23426k.add(this.f23473e);
                        n nVar2 = this.f23470b.f23066f;
                        nVar2.f23473e.f23416a = this;
                        this.f23473e.f23427l.add(nVar2.f23476h);
                        this.f23473e.f23427l.add(this.f23470b.f23066f.f23477i);
                        this.f23470b.f23066f.f23476h.f23426k.add(this.f23473e);
                        this.f23470b.f23066f.f23477i.f23426k.add(this.f23473e);
                    } else if (this.f23470b.i0()) {
                        this.f23470b.f23066f.f23473e.f23427l.add(this.f23473e);
                        this.f23473e.f23426k.add(this.f23470b.f23066f.f23473e);
                    } else {
                        this.f23470b.f23066f.f23473e.f23427l.add(this.f23473e);
                    }
                } else {
                    g gVar4 = eVar3.f23066f.f23473e;
                    gVar.f23427l.add(gVar4);
                    gVar4.f23426k.add(this.f23473e);
                    this.f23470b.f23066f.f23476h.f23426k.add(this.f23473e);
                    this.f23470b.f23066f.f23477i.f23426k.add(this.f23473e);
                    g gVar5 = this.f23473e;
                    gVar5.f23417b = true;
                    gVar5.f23426k.add(this.f23476h);
                    this.f23473e.f23426k.add(this.f23477i);
                    this.f23476h.f23427l.add(this.f23473e);
                    this.f23477i.f23427l.add(this.f23473e);
                }
            }
        }
        v.e eVar4 = this.f23470b;
        v.d[] dVarArr2 = eVar4.f23052W;
        v.d dVar4 = dVarArr2[0];
        v.d dVar5 = dVar4.f23004f;
        if (dVar5 != null && dVarArr2[1].f23004f != null) {
            if (eVar4.i0()) {
                this.f23476h.f23421f = this.f23470b.f23052W[0].f();
                this.f23477i.f23421f = -this.f23470b.f23052W[1].f();
                return;
            }
            f fVarH5 = h(this.f23470b.f23052W[0]);
            f fVarH6 = h(this.f23470b.f23052W[1]);
            if (fVarH5 != null) {
                fVarH5.b(this);
            }
            if (fVarH6 != null) {
                fVarH6.b(this);
            }
            this.f23478j = p.b.CENTER;
            return;
        }
        if (dVar5 != null) {
            f fVarH7 = h(dVar4);
            if (fVarH7 != null) {
                b(this.f23476h, fVarH7, this.f23470b.f23052W[0].f());
                c(this.f23477i, this.f23476h, 1, this.f23473e);
                return;
            }
            return;
        }
        v.d dVar6 = dVarArr2[1];
        if (dVar6.f23004f != null) {
            f fVarH8 = h(dVar6);
            if (fVarH8 != null) {
                b(this.f23477i, fVarH8, -this.f23470b.f23052W[1].f());
                c(this.f23476h, this.f23477i, -1, this.f23473e);
                return;
            }
            return;
        }
        if ((eVar4 instanceof v.i) || eVar4.K() == null) {
            return;
        }
        b(this.f23476h, this.f23470b.K().f23064e.f23476h, this.f23470b.X());
        c(this.f23477i, this.f23476h, 1, this.f23473e);
    }

    @Override // w.p
    public void e() {
        f fVar = this.f23476h;
        if (fVar.f23425j) {
            this.f23470b.m1(fVar.f23422g);
        }
    }

    @Override // w.p
    void f() {
        this.f23471c = null;
        this.f23476h.c();
        this.f23477i.c();
        this.f23473e.c();
        this.f23475g = false;
    }

    @Override // w.p
    boolean m() {
        return this.f23472d != e.b.MATCH_CONSTRAINT || this.f23470b.f23100w == 0;
    }

    void r() {
        this.f23475g = false;
        this.f23476h.c();
        this.f23476h.f23425j = false;
        this.f23477i.c();
        this.f23477i.f23425j = false;
        this.f23473e.f23425j = false;
    }

    public String toString() {
        return "HorizontalRun " + this.f23470b.t();
    }
}
