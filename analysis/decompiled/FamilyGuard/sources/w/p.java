package w;

import v.d;
import v.e;

/* loaded from: classes.dex */
public abstract class p implements InterfaceC1198d {

    /* renamed from: a, reason: collision with root package name */
    public int f23469a;

    /* renamed from: b, reason: collision with root package name */
    v.e f23470b;

    /* renamed from: c, reason: collision with root package name */
    m f23471c;

    /* renamed from: d, reason: collision with root package name */
    protected e.b f23472d;

    /* renamed from: e, reason: collision with root package name */
    g f23473e = new g(this);

    /* renamed from: f, reason: collision with root package name */
    public int f23474f = 0;

    /* renamed from: g, reason: collision with root package name */
    boolean f23475g = false;

    /* renamed from: h, reason: collision with root package name */
    public f f23476h = new f(this);

    /* renamed from: i, reason: collision with root package name */
    public f f23477i = new f(this);

    /* renamed from: j, reason: collision with root package name */
    protected b f23478j = b.NONE;

    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f23479a;

        static {
            int[] iArr = new int[d.b.values().length];
            f23479a = iArr;
            try {
                iArr[d.b.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f23479a[d.b.RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f23479a[d.b.TOP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f23479a[d.b.BASELINE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f23479a[d.b.BOTTOM.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    enum b {
        NONE,
        START,
        END,
        CENTER
    }

    public p(v.e eVar) {
        this.f23470b = eVar;
    }

    private void l(int i5, int i6) {
        int i7 = this.f23469a;
        if (i7 == 0) {
            this.f23473e.d(g(i6, i5));
            return;
        }
        if (i7 == 1) {
            this.f23473e.d(Math.min(g(this.f23473e.f23437m, i5), i6));
            return;
        }
        if (i7 == 2) {
            v.e eVarK = this.f23470b.K();
            if (eVarK != null) {
                if ((i5 == 0 ? eVarK.f23064e : eVarK.f23066f).f23473e.f23425j) {
                    v.e eVar = this.f23470b;
                    this.f23473e.d(g((int) ((r9.f23422g * (i5 == 0 ? eVar.f23022B : eVar.f23028E)) + 0.5f), i5));
                    return;
                }
                return;
            }
            return;
        }
        if (i7 != 3) {
            return;
        }
        v.e eVar2 = this.f23470b;
        p pVar = eVar2.f23064e;
        e.b bVar = pVar.f23472d;
        e.b bVar2 = e.b.MATCH_CONSTRAINT;
        if (bVar == bVar2 && pVar.f23469a == 3) {
            n nVar = eVar2.f23066f;
            if (nVar.f23472d == bVar2 && nVar.f23469a == 3) {
                return;
            }
        }
        if (i5 == 0) {
            pVar = eVar2.f23066f;
        }
        if (pVar.f23473e.f23425j) {
            float fV = eVar2.v();
            this.f23473e.d(i5 == 1 ? (int) ((pVar.f23473e.f23422g / fV) + 0.5f) : (int) ((fV * pVar.f23473e.f23422g) + 0.5f));
        }
    }

    @Override // w.InterfaceC1198d
    public void a(InterfaceC1198d interfaceC1198d) {
    }

    protected final void b(f fVar, f fVar2, int i5) {
        fVar.f23427l.add(fVar2);
        fVar.f23421f = i5;
        fVar2.f23426k.add(fVar);
    }

    protected final void c(f fVar, f fVar2, int i5, g gVar) {
        fVar.f23427l.add(fVar2);
        fVar.f23427l.add(this.f23473e);
        fVar.f23423h = i5;
        fVar.f23424i = gVar;
        fVar2.f23426k.add(fVar);
        gVar.f23426k.add(fVar);
    }

    abstract void d();

    abstract void e();

    abstract void f();

    protected final int g(int i5, int i6) {
        if (i6 == 0) {
            v.e eVar = this.f23470b;
            int i7 = eVar.f23020A;
            int iMax = Math.max(eVar.f23106z, i5);
            if (i7 > 0) {
                iMax = Math.min(i7, i5);
            }
            if (iMax != i5) {
                return iMax;
            }
        } else {
            v.e eVar2 = this.f23470b;
            int i8 = eVar2.f23026D;
            int iMax2 = Math.max(eVar2.f23024C, i5);
            if (i8 > 0) {
                iMax2 = Math.min(i8, i5);
            }
            if (iMax2 != i5) {
                return iMax2;
            }
        }
        return i5;
    }

    protected final f h(v.d dVar) {
        v.d dVar2 = dVar.f23004f;
        if (dVar2 == null) {
            return null;
        }
        v.e eVar = dVar2.f23002d;
        int i5 = a.f23479a[dVar2.f23003e.ordinal()];
        if (i5 == 1) {
            return eVar.f23064e.f23476h;
        }
        if (i5 == 2) {
            return eVar.f23064e.f23477i;
        }
        if (i5 == 3) {
            return eVar.f23066f.f23476h;
        }
        if (i5 == 4) {
            return eVar.f23066f.f23451k;
        }
        if (i5 != 5) {
            return null;
        }
        return eVar.f23066f.f23477i;
    }

    protected final f i(v.d dVar, int i5) {
        v.d dVar2 = dVar.f23004f;
        if (dVar2 == null) {
            return null;
        }
        v.e eVar = dVar2.f23002d;
        p pVar = i5 == 0 ? eVar.f23064e : eVar.f23066f;
        int i6 = a.f23479a[dVar2.f23003e.ordinal()];
        if (i6 != 1) {
            if (i6 != 2) {
                if (i6 != 3) {
                    if (i6 != 5) {
                        return null;
                    }
                }
            }
            return pVar.f23477i;
        }
        return pVar.f23476h;
    }

    public long j() {
        if (this.f23473e.f23425j) {
            return r2.f23422g;
        }
        return 0L;
    }

    public boolean k() {
        return this.f23475g;
    }

    abstract boolean m();

    protected void n(InterfaceC1198d interfaceC1198d, v.d dVar, v.d dVar2, int i5) {
        f fVarH = h(dVar);
        f fVarH2 = h(dVar2);
        if (fVarH.f23425j && fVarH2.f23425j) {
            int iF = fVarH.f23422g + dVar.f();
            int iF2 = fVarH2.f23422g - dVar2.f();
            int i6 = iF2 - iF;
            if (!this.f23473e.f23425j && this.f23472d == e.b.MATCH_CONSTRAINT) {
                l(i5, i6);
            }
            g gVar = this.f23473e;
            if (gVar.f23425j) {
                if (gVar.f23422g == i6) {
                    this.f23476h.d(iF);
                    this.f23477i.d(iF2);
                    return;
                }
                v.e eVar = this.f23470b;
                float fY = i5 == 0 ? eVar.y() : eVar.R();
                if (fVarH == fVarH2) {
                    iF = fVarH.f23422g;
                    iF2 = fVarH2.f23422g;
                    fY = 0.5f;
                }
                this.f23476h.d((int) (iF + 0.5f + (((iF2 - iF) - this.f23473e.f23422g) * fY)));
                this.f23477i.d(this.f23476h.f23422g + this.f23473e.f23422g);
            }
        }
    }

    protected void o(InterfaceC1198d interfaceC1198d) {
    }

    protected void p(InterfaceC1198d interfaceC1198d) {
    }
}
