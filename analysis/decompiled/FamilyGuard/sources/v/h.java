package v;

import v.d;
import v.e;

/* loaded from: classes.dex */
public class h extends e {

    /* renamed from: L0, reason: collision with root package name */
    protected float f23188L0 = -1.0f;

    /* renamed from: M0, reason: collision with root package name */
    protected int f23189M0 = -1;

    /* renamed from: N0, reason: collision with root package name */
    protected int f23190N0 = -1;

    /* renamed from: O0, reason: collision with root package name */
    protected boolean f23191O0 = true;

    /* renamed from: P0, reason: collision with root package name */
    private d f23192P0 = this.f23045P;

    /* renamed from: Q0, reason: collision with root package name */
    private int f23193Q0 = 0;

    /* renamed from: R0, reason: collision with root package name */
    private int f23194R0 = 0;

    /* renamed from: S0, reason: collision with root package name */
    private boolean f23195S0;

    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f23196a;

        static {
            int[] iArr = new int[d.b.values().length];
            f23196a = iArr;
            try {
                iArr[d.b.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f23196a[d.b.RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f23196a[d.b.TOP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f23196a[d.b.BOTTOM.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f23196a[d.b.BASELINE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f23196a[d.b.CENTER.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f23196a[d.b.CENTER_X.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f23196a[d.b.CENTER_Y.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f23196a[d.b.NONE.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    public h() {
        this.f23053X.clear();
        this.f23053X.add(this.f23192P0);
        int length = this.f23052W.length;
        for (int i5 = 0; i5 < length; i5++) {
            this.f23052W[i5] = this.f23192P0;
        }
    }

    public void A1(int i5) {
        if (this.f23193Q0 == i5) {
            return;
        }
        this.f23193Q0 = i5;
        this.f23053X.clear();
        if (this.f23193Q0 == 1) {
            this.f23192P0 = this.f23044O;
        } else {
            this.f23192P0 = this.f23045P;
        }
        this.f23053X.add(this.f23192P0);
        int length = this.f23052W.length;
        for (int i6 = 0; i6 < length; i6++) {
            this.f23052W[i6] = this.f23192P0;
        }
    }

    @Override // v.e
    public void g(s.d dVar, boolean z5) {
        f fVar = (f) K();
        if (fVar == null) {
            return;
        }
        d dVarO = fVar.o(d.b.LEFT);
        d dVarO2 = fVar.o(d.b.RIGHT);
        e eVar = this.f23057a0;
        boolean z6 = eVar != null && eVar.f23055Z[0] == e.b.WRAP_CONTENT;
        if (this.f23193Q0 == 0) {
            dVarO = fVar.o(d.b.TOP);
            dVarO2 = fVar.o(d.b.BOTTOM);
            e eVar2 = this.f23057a0;
            z6 = eVar2 != null && eVar2.f23055Z[1] == e.b.WRAP_CONTENT;
        }
        if (this.f23195S0 && this.f23192P0.n()) {
            s.i iVarQ = dVar.q(this.f23192P0);
            dVar.f(iVarQ, this.f23192P0.e());
            if (this.f23189M0 != -1) {
                if (z6) {
                    dVar.h(dVar.q(dVarO2), iVarQ, 0, 5);
                }
            } else if (this.f23190N0 != -1 && z6) {
                s.i iVarQ2 = dVar.q(dVarO2);
                dVar.h(iVarQ, dVar.q(dVarO), 0, 5);
                dVar.h(iVarQ2, iVarQ, 0, 5);
            }
            this.f23195S0 = false;
            return;
        }
        if (this.f23189M0 != -1) {
            s.i iVarQ3 = dVar.q(this.f23192P0);
            dVar.e(iVarQ3, dVar.q(dVarO), this.f23189M0, 8);
            if (z6) {
                dVar.h(dVar.q(dVarO2), iVarQ3, 0, 5);
                return;
            }
            return;
        }
        if (this.f23190N0 == -1) {
            if (this.f23188L0 != -1.0f) {
                dVar.d(s.d.s(dVar, dVar.q(this.f23192P0), dVar.q(dVarO2), this.f23188L0));
                return;
            }
            return;
        }
        s.i iVarQ4 = dVar.q(this.f23192P0);
        s.i iVarQ5 = dVar.q(dVarO2);
        dVar.e(iVarQ4, iVarQ5, -this.f23190N0, 8);
        if (z6) {
            dVar.h(iVarQ4, dVar.q(dVarO), 0, 5);
            dVar.h(iVarQ5, iVarQ4, 0, 5);
        }
    }

    @Override // v.e
    public boolean h() {
        return true;
    }

    @Override // v.e
    public boolean n0() {
        return this.f23195S0;
    }

    @Override // v.e
    public d o(d.b bVar) {
        int i5 = a.f23196a[bVar.ordinal()];
        if (i5 == 1 || i5 == 2) {
            if (this.f23193Q0 == 1) {
                return this.f23192P0;
            }
            return null;
        }
        if ((i5 == 3 || i5 == 4) && this.f23193Q0 == 0) {
            return this.f23192P0;
        }
        return null;
    }

    @Override // v.e
    public boolean o0() {
        return this.f23195S0;
    }

    @Override // v.e
    public void q1(s.d dVar, boolean z5) {
        if (K() == null) {
            return;
        }
        int iX = dVar.x(this.f23192P0);
        if (this.f23193Q0 == 1) {
            m1(iX);
            n1(0);
            L0(K().x());
            k1(0);
            return;
        }
        m1(0);
        n1(iX);
        k1(K().W());
        L0(0);
    }

    public d r1() {
        return this.f23192P0;
    }

    public int s1() {
        return this.f23193Q0;
    }

    public int t1() {
        return this.f23189M0;
    }

    public int u1() {
        return this.f23190N0;
    }

    public float v1() {
        return this.f23188L0;
    }

    public void w1(int i5) {
        this.f23192P0.t(i5);
        this.f23195S0 = true;
    }

    public void x1(int i5) {
        if (i5 > -1) {
            this.f23188L0 = -1.0f;
            this.f23189M0 = i5;
            this.f23190N0 = -1;
        }
    }

    public void y1(int i5) {
        if (i5 > -1) {
            this.f23188L0 = -1.0f;
            this.f23189M0 = -1;
            this.f23190N0 = i5;
        }
    }

    public void z1(float f5) {
        if (f5 > -1.0f) {
            this.f23188L0 = f5;
            this.f23189M0 = -1;
            this.f23190N0 = -1;
        }
    }
}
