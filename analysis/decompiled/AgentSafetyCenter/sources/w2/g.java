package w2;

import java.util.ArrayList;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class g extends e {

    /* renamed from: p0, reason: collision with root package name */
    public float f15207p0 = -1.0f;

    /* renamed from: q0, reason: collision with root package name */
    public int f15208q0 = -1;

    /* renamed from: r0, reason: collision with root package name */
    public int f15209r0 = -1;

    /* renamed from: s0, reason: collision with root package name */
    public d f15210s0 = this.I;

    /* renamed from: t0, reason: collision with root package name */
    public int f15211t0 = 0;

    /* renamed from: u0, reason: collision with root package name */
    public boolean f15212u0;

    public g() {
        this.Q.clear();
        this.Q.add(this.f15210s0);
        int length = this.P.length;
        for (int i = 0; i < length; i++) {
            this.P[i] = this.f15210s0;
        }
    }

    @Override // w2.e
    public final void M(u2.c cVar, boolean z10) {
        if (this.S == null) {
            return;
        }
        d dVar = this.f15210s0;
        cVar.getClass();
        int iN = u2.c.n(dVar);
        if (this.f15211t0 == 1) {
            this.X = iN;
            this.Y = 0;
            H(this.S.i());
            K(0);
            return;
        }
        this.X = 0;
        this.Y = iN;
        K(this.S.o());
        H(0);
    }

    public final void N(int i) {
        this.f15210s0.i(i);
        this.f15212u0 = true;
    }

    public final void O(int i) {
        if (this.f15211t0 == i) {
            return;
        }
        this.f15211t0 = i;
        ArrayList arrayList = this.Q;
        arrayList.clear();
        if (this.f15211t0 == 1) {
            this.f15210s0 = this.H;
        } else {
            this.f15210s0 = this.I;
        }
        arrayList.add(this.f15210s0);
        d[] dVarArr = this.P;
        int length = dVarArr.length;
        for (int i3 = 0; i3 < length; i3++) {
            dVarArr[i3] = this.f15210s0;
        }
    }

    @Override // w2.e
    public final void b(u2.c cVar, boolean z10) {
        f fVar = (f) this.S;
        if (fVar == null) {
            return;
        }
        Object objG = fVar.g(2);
        Object objG2 = fVar.g(4);
        e eVar = this.S;
        boolean z11 = eVar != null && eVar.f15184o0[0] == 2;
        if (this.f15211t0 == 0) {
            objG = fVar.g(3);
            objG2 = fVar.g(5);
            e eVar2 = this.S;
            z11 = eVar2 != null && eVar2.f15184o0[1] == 2;
        }
        if (this.f15212u0) {
            d dVar = this.f15210s0;
            if (dVar.f15152c) {
                u2.e eVarK = cVar.k(dVar);
                cVar.d(eVarK, this.f15210s0.c());
                if (this.f15208q0 != -1) {
                    if (z11) {
                        cVar.f(cVar.k(objG2), eVarK, 0, 5);
                    }
                } else if (this.f15209r0 != -1 && z11) {
                    u2.e eVarK2 = cVar.k(objG2);
                    cVar.f(eVarK, cVar.k(objG), 0, 5);
                    cVar.f(eVarK2, eVarK, 0, 5);
                }
                this.f15212u0 = false;
                return;
            }
        }
        if (this.f15208q0 != -1) {
            u2.e eVarK3 = cVar.k(this.f15210s0);
            cVar.e(eVarK3, cVar.k(objG), this.f15208q0, 8);
            if (z11) {
                cVar.f(cVar.k(objG2), eVarK3, 0, 5);
                return;
            }
            return;
        }
        if (this.f15209r0 != -1) {
            u2.e eVarK4 = cVar.k(this.f15210s0);
            u2.e eVarK5 = cVar.k(objG2);
            cVar.e(eVarK4, eVarK5, -this.f15209r0, 8);
            if (z11) {
                cVar.f(eVarK4, cVar.k(objG), 0, 5);
                cVar.f(eVarK5, eVarK4, 0, 5);
                return;
            }
            return;
        }
        if (this.f15207p0 != -1.0f) {
            u2.e eVarK6 = cVar.k(this.f15210s0);
            u2.e eVarK7 = cVar.k(objG2);
            float f5 = this.f15207p0;
            u2.b bVarL = cVar.l();
            bVarL.f13993d.g(eVarK6, -1.0f);
            bVarL.f13993d.g(eVarK7, f5);
            cVar.c(bVarL);
        }
    }

    @Override // w2.e
    public final boolean c() {
        return true;
    }

    @Override // w2.e
    public final d g(int i) {
        int iC = s.f.c(i);
        if (iC != 1) {
            if (iC != 2) {
                if (iC != 3) {
                    if (iC != 4) {
                        return null;
                    }
                }
            }
            if (this.f15211t0 == 0) {
                return this.f15210s0;
            }
            return null;
        }
        if (this.f15211t0 == 1) {
            return this.f15210s0;
        }
        return null;
    }

    @Override // w2.e
    public final boolean y() {
        return this.f15212u0;
    }

    @Override // w2.e
    public final boolean z() {
        return this.f15212u0;
    }
}
