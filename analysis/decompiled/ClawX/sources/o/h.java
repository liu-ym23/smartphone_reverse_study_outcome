package o;

import java.util.ArrayList;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class h extends d {

    /* renamed from: p0, reason: collision with root package name */
    public float f4287p0 = -1.0f;

    /* renamed from: q0, reason: collision with root package name */
    public int f4288q0 = -1;

    /* renamed from: r0, reason: collision with root package name */
    public int f4289r0 = -1;

    /* renamed from: s0, reason: collision with root package name */
    public c f4290s0 = this.I;

    /* renamed from: t0, reason: collision with root package name */
    public int f4291t0 = 0;

    /* renamed from: u0, reason: collision with root package name */
    public boolean f4292u0;

    public h() {
        this.Q.clear();
        this.Q.add(this.f4290s0);
        int length = this.P.length;
        for (int i8 = 0; i8 < length; i8++) {
            this.P[i8] = this.f4290s0;
        }
    }

    @Override // o.d
    public final void L(m.c cVar, boolean z) {
        if (this.S == null) {
            return;
        }
        c cVar2 = this.f4290s0;
        cVar.getClass();
        int iN = m.c.n(cVar2);
        if (this.f4291t0 == 1) {
            this.X = iN;
            this.Y = 0;
            G(this.S.k());
            J(0);
            return;
        }
        this.X = 0;
        this.Y = iN;
        J(this.S.n());
        G(0);
    }

    public final void M(int i8) {
        this.f4290s0.l(i8);
        this.f4292u0 = true;
    }

    public final void N(int i8) {
        if (this.f4291t0 == i8) {
            return;
        }
        this.f4291t0 = i8;
        ArrayList arrayList = this.Q;
        arrayList.clear();
        if (this.f4291t0 == 1) {
            this.f4290s0 = this.H;
        } else {
            this.f4290s0 = this.I;
        }
        arrayList.add(this.f4290s0);
        c[] cVarArr = this.P;
        int length = cVarArr.length;
        for (int i9 = 0; i9 < length; i9++) {
            cVarArr[i9] = this.f4290s0;
        }
    }

    @Override // o.d
    public final void b(m.c cVar, boolean z) {
        e eVar = (e) this.S;
        if (eVar == null) {
            return;
        }
        Object objI = eVar.i(2);
        Object objI2 = eVar.i(4);
        d dVar = this.S;
        boolean z2 = dVar != null && dVar.f4239o0[0] == 2;
        if (this.f4291t0 == 0) {
            objI = eVar.i(3);
            objI2 = eVar.i(5);
            d dVar2 = this.S;
            z2 = dVar2 != null && dVar2.f4239o0[1] == 2;
        }
        if (this.f4292u0) {
            c cVar2 = this.f4290s0;
            if (cVar2.f4206c) {
                m.g gVarK = cVar.k(cVar2);
                cVar.d(gVarK, this.f4290s0.d());
                if (this.f4288q0 != -1) {
                    if (z2) {
                        cVar.f(cVar.k(objI2), gVarK, 0, 5);
                    }
                } else if (this.f4289r0 != -1 && z2) {
                    m.g gVarK2 = cVar.k(objI2);
                    cVar.f(gVarK, cVar.k(objI), 0, 5);
                    cVar.f(gVarK2, gVarK, 0, 5);
                }
                this.f4292u0 = false;
                return;
            }
        }
        if (this.f4288q0 != -1) {
            m.g gVarK3 = cVar.k(this.f4290s0);
            cVar.e(gVarK3, cVar.k(objI), this.f4288q0, 8);
            if (z2) {
                cVar.f(cVar.k(objI2), gVarK3, 0, 5);
                return;
            }
            return;
        }
        if (this.f4289r0 != -1) {
            m.g gVarK4 = cVar.k(this.f4290s0);
            m.g gVarK5 = cVar.k(objI2);
            cVar.e(gVarK4, gVarK5, -this.f4289r0, 8);
            if (z2) {
                cVar.f(gVarK4, cVar.k(objI), 0, 5);
                cVar.f(gVarK5, gVarK4, 0, 5);
                return;
            }
            return;
        }
        if (this.f4287p0 != -1.0f) {
            m.g gVarK6 = cVar.k(this.f4290s0);
            m.g gVarK7 = cVar.k(objI2);
            float f3 = this.f4287p0;
            m.b bVarL = cVar.l();
            bVarL.d.g(gVarK6, -1.0f);
            bVarL.d.g(gVarK7, f3);
            cVar.c(bVarL);
        }
    }

    @Override // o.d
    public final boolean c() {
        return true;
    }

    @Override // o.d
    public final c i(int i8) {
        int iA = m.f.a(i8);
        if (iA != 1) {
            if (iA != 2) {
                if (iA != 3) {
                    if (iA != 4) {
                        return null;
                    }
                }
            }
            if (this.f4291t0 == 0) {
                return this.f4290s0;
            }
            return null;
        }
        if (this.f4291t0 == 1) {
            return this.f4290s0;
        }
        return null;
    }

    @Override // o.d
    public final boolean x() {
        return this.f4292u0;
    }

    @Override // o.d
    public final boolean y() {
        return this.f4292u0;
    }
}
