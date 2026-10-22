package v;

import java.util.ArrayList;

/* renamed from: v.h, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0948h extends C0944d {

    /* renamed from: q0, reason: collision with root package name */
    public float f15665q0 = -1.0f;

    /* renamed from: r0, reason: collision with root package name */
    public int f15666r0 = -1;

    /* renamed from: s0, reason: collision with root package name */
    public int f15667s0 = -1;

    /* renamed from: t0, reason: collision with root package name */
    public C0943c f15668t0 = this.f15533J;

    /* renamed from: u0, reason: collision with root package name */
    public int f15669u0 = 0;

    /* renamed from: v0, reason: collision with root package name */
    public boolean f15670v0;

    public C0948h() {
        this.f15541R.clear();
        this.f15541R.add(this.f15668t0);
        int length = this.f15540Q.length;
        for (int i4 = 0; i4 < length; i4++) {
            this.f15540Q[i4] = this.f15668t0;
        }
    }

    @Override // v.C0944d
    public final boolean B() {
        return this.f15670v0;
    }

    @Override // v.C0944d
    public final boolean C() {
        return this.f15670v0;
    }

    @Override // v.C0944d
    public final void R(t.e eVar, boolean z4) {
        if (this.T == null) {
            return;
        }
        C0943c c0943c = this.f15668t0;
        eVar.getClass();
        int iN = t.e.n(c0943c);
        if (this.f15669u0 == 1) {
            this.f15547Y = iN;
            this.f15548Z = 0;
            M(this.T.l());
            P(0);
            return;
        }
        this.f15547Y = 0;
        this.f15548Z = iN;
        P(this.T.r());
        M(0);
    }

    public final void S(int i4) {
        this.f15668t0.l(i4);
        this.f15670v0 = true;
    }

    public final void T(int i4) {
        if (this.f15669u0 == i4) {
            return;
        }
        this.f15669u0 = i4;
        ArrayList arrayList = this.f15541R;
        arrayList.clear();
        if (this.f15669u0 == 1) {
            this.f15668t0 = this.f15532I;
        } else {
            this.f15668t0 = this.f15533J;
        }
        arrayList.add(this.f15668t0);
        C0943c[] c0943cArr = this.f15540Q;
        int length = c0943cArr.length;
        for (int i5 = 0; i5 < length; i5++) {
            c0943cArr[i5] = this.f15668t0;
        }
    }

    @Override // v.C0944d
    public final void c(t.e eVar, boolean z4) {
        C0945e c0945e = (C0945e) this.T;
        if (c0945e == null) {
            return;
        }
        Object objJ = c0945e.j(2);
        Object objJ2 = c0945e.j(4);
        C0944d c0944d = this.T;
        boolean z5 = c0944d != null && c0944d.f15580p0[0] == 2;
        if (this.f15669u0 == 0) {
            objJ = c0945e.j(3);
            objJ2 = c0945e.j(5);
            C0944d c0944d2 = this.T;
            z5 = c0944d2 != null && c0944d2.f15580p0[1] == 2;
        }
        if (this.f15670v0) {
            C0943c c0943c = this.f15668t0;
            if (c0943c.f15517c) {
                t.i iVarK = eVar.k(c0943c);
                eVar.d(iVarK, this.f15668t0.d());
                if (this.f15666r0 != -1) {
                    if (z5) {
                        eVar.f(eVar.k(objJ2), iVarK, 0, 5);
                    }
                } else if (this.f15667s0 != -1 && z5) {
                    t.i iVarK2 = eVar.k(objJ2);
                    eVar.f(iVarK, eVar.k(objJ), 0, 5);
                    eVar.f(iVarK2, iVarK, 0, 5);
                }
                this.f15670v0 = false;
                return;
            }
        }
        if (this.f15666r0 != -1) {
            t.i iVarK3 = eVar.k(this.f15668t0);
            eVar.e(iVarK3, eVar.k(objJ), this.f15666r0, 8);
            if (z5) {
                eVar.f(eVar.k(objJ2), iVarK3, 0, 5);
                return;
            }
            return;
        }
        if (this.f15667s0 != -1) {
            t.i iVarK4 = eVar.k(this.f15668t0);
            t.i iVarK5 = eVar.k(objJ2);
            eVar.e(iVarK4, iVarK5, -this.f15667s0, 8);
            if (z5) {
                eVar.f(iVarK4, eVar.k(objJ), 0, 5);
                eVar.f(iVarK5, iVarK4, 0, 5);
                return;
            }
            return;
        }
        if (this.f15665q0 != -1.0f) {
            t.i iVarK6 = eVar.k(this.f15668t0);
            t.i iVarK7 = eVar.k(objJ2);
            float f4 = this.f15665q0;
            t.c cVarL = eVar.l();
            cVarL.f15270d.d(iVarK6, -1.0f);
            cVarL.f15270d.d(iVarK7, f4);
            eVar.c(cVarL);
        }
    }

    @Override // v.C0944d
    public final boolean d() {
        return true;
    }

    @Override // v.C0944d
    public final C0943c j(int i4) {
        int iA = t.h.a(i4);
        if (iA != 1) {
            if (iA != 2) {
                if (iA != 3) {
                    if (iA != 4) {
                        return null;
                    }
                }
            }
            if (this.f15669u0 == 0) {
                return this.f15668t0;
            }
            return null;
        }
        if (this.f15669u0 == 1) {
            return this.f15668t0;
        }
        return null;
    }
}
