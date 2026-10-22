package v9;

/* loaded from: classes.dex */
public final class v0 {

    /* renamed from: b, reason: collision with root package name */
    public static final v0 f10595b = new v0(s0.f10589a);

    /* renamed from: a, reason: collision with root package name */
    public final s0 f10596a;

    public v0(s0 s0Var) {
        this.f10596a = s0Var;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0021 A[FALL_THROUGH] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x003b A[FALL_THROUGH] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00b8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static /* synthetic */ void a(int r13) {
        /*
            Method dump skipped, instructions count: 660
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: v9.v0.a(int):void");
    }

    public static int b(int i2, int i10) {
        if (i2 == 0) {
            a(38);
            throw null;
        }
        if (i10 == 0) {
            a(39);
            throw null;
        }
        if (i2 == 1) {
            if (i10 == 0) {
                a(40);
                throw null;
            }
        } else {
            if (i10 == 1) {
                if (i2 != 0) {
                    return i2;
                }
                a(41);
                throw null;
            }
            if (i2 != i10) {
                throw new AssertionError("Variance conflict: type parameter variance '" + m.x.z(i2) + "' and projection kind '" + m.x.z(i10) + "' cannot be combined");
            }
            if (i10 == 0) {
                a(42);
                throw null;
            }
        }
        return i10;
    }

    public static int c(int i2, int i10) {
        if (i2 == 2 && i10 == 3) {
            return 3;
        }
        return (i2 == 3 && i10 == 2) ? 2 : 1;
    }

    public static v0 d(v vVar) {
        if (vVar == null) {
            a(6);
            throw null;
        }
        return new v0(n0.f10575b.f(vVar.E0(), vVar.C0()));
    }

    public static v0 e(s0 s0Var, s0 s0Var2) {
        if (s0Var == null) {
            a(3);
            throw null;
        }
        if (s0Var2 == null) {
            a(4);
            throw null;
        }
        if (s0Var.e()) {
            s0Var = s0Var2;
        } else if (!s0Var2.e()) {
            s0Var = new o(s0Var, s0Var2);
        }
        return new v0(s0Var);
    }

    public static String h(Object obj) {
        try {
            return obj.toString();
        } catch (Throwable th) {
            if (ea.k.h(th)) {
                throw th;
            }
            return "[Exception while computing toString(): " + th + "]";
        }
    }

    public final s0 f() {
        s0 s0Var = this.f10596a;
        if (s0Var != null) {
            return s0Var;
        }
        a(8);
        throw null;
    }

    public final v g(int i2, v vVar) {
        if (vVar == null) {
            a(9);
            throw null;
        }
        if (i2 == 0) {
            a(10);
            throw null;
        }
        if (this.f10596a.e()) {
            return vVar;
        }
        try {
            v vVarB = j(new q0(i2, vVar), null, 0).b();
            if (vVarB != null) {
                return vVarB;
            }
            a(12);
            throw null;
        } catch (u0 e10) {
            return x9.i.c(x9.h.f11310p, e10.getMessage());
        }
    }

    public final v i(int i2, v vVar) {
        if (vVar == null) {
            a(14);
            throw null;
        }
        if (i2 == 0) {
            a(15);
            throw null;
        }
        p0 q0Var = new q0(i2, f().f(i2, vVar));
        s0 s0Var = this.f10596a;
        if (!s0Var.e()) {
            try {
                q0Var = j(q0Var, null, 0);
            } catch (u0 unused) {
                q0Var = null;
            }
        }
        if (s0Var.a() || s0Var.b()) {
            boolean zB = s0Var.b();
            if (q0Var == null) {
                q0Var = null;
            } else if (!q0Var.c()) {
                v vVarB = q0Var.b();
                q7.k.d(vVarB, "typeProjection.type");
                if (x0.c(vVarB, aa.b.f482g, null)) {
                    int iA = q0Var.a();
                    m.x.y(iA, "typeProjection.projectionKind");
                    if (iA == 3) {
                        q0Var = new q0(iA, (v) w7.e0.e(vVarB).f481b);
                    } else if (zB) {
                        q0Var = new q0(iA, (v) w7.e0.e(vVarB).f480a);
                    } else {
                        aa.c cVar = new aa.c();
                        v0 v0Var = new v0(cVar);
                        if (!cVar.e()) {
                            try {
                                q0Var = v0Var.j(q0Var, null, 0);
                            } catch (u0 unused2) {
                            }
                        }
                    }
                }
            }
        }
        if (q0Var == null) {
            return null;
        }
        return q0Var.b();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:119:0x023f  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0130  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final v9.p0 j(v9.p0 r17, f8.q0 r18, int r19) throws v9.u0 {
        /*
            Method dump skipped, instructions count: 785
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: v9.v0.j(v9.p0, f8.q0, int):v9.p0");
    }
}
