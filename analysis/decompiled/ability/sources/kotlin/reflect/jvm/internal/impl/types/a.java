package kotlin.reflect.jvm.internal.impl.types;

import X8.C0284o;
import X8.F;
import X8.L;
import X8.N;
import X8.P;
import X8.S;
import X8.w;
import Z8.i;
import c9.C0889b;
import c9.C0890c;
import g9.l;
import kotlin.jvm.internal.k;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind;

/* loaded from: classes4.dex */
public final class a {
    public static final a b = new a(P.f1526a);

    /* renamed from: a, reason: collision with root package name */
    public final P f5144a;

    public a(P p) {
        this.f5144a = p;
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
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.types.a.a(int):void");
    }

    public static Variance b(Variance variance, Variance variance2) {
        if (variance == null) {
            a(38);
            throw null;
        }
        if (variance2 == null) {
            a(39);
            throw null;
        }
        Variance variance3 = Variance.c;
        if (variance == variance3) {
            if (variance2 != null) {
                return variance2;
            }
            a(40);
            throw null;
        }
        if (variance2 == variance3) {
            if (variance != null) {
                return variance;
            }
            a(41);
            throw null;
        }
        if (variance == variance2) {
            if (variance2 != null) {
                return variance2;
            }
            a(42);
            throw null;
        }
        throw new AssertionError("Variance conflict: type parameter variance '" + variance + "' and projection kind '" + variance2 + "' cannot be combined");
    }

    public static TypeSubstitutor$VarianceConflictType c(Variance variance, Variance variance2) {
        Variance variance3 = Variance.d;
        return (variance == variance3 && variance2 == Variance.e) ? TypeSubstitutor$VarianceConflictType.c : (variance == Variance.e && variance2 == variance3) ? TypeSubstitutor$VarianceConflictType.b : TypeSubstitutor$VarianceConflictType.f5141a;
    }

    public static a d(w wVar) {
        if (wVar == null) {
            a(6);
            throw null;
        }
        return new a(L.b.f(wVar.Q(), wVar.L()));
    }

    public static a e(P p, P p3) {
        if (p == null) {
            a(3);
            throw null;
        }
        if (p3 == null) {
            a(4);
            throw null;
        }
        if (p.e()) {
            p = p3;
        } else if (!p3.e()) {
            p = new C0284o(p, p3);
        }
        return new a(p);
    }

    public static String h(Object obj) {
        try {
            return obj.toString();
        } catch (Throwable th) {
            if (l.j(th)) {
                throw th;
            }
            return "[Exception while computing toString(): " + th + "]";
        }
    }

    public final P f() {
        P p = this.f5144a;
        if (p != null) {
            return p;
        }
        a(8);
        throw null;
    }

    public final w g(w wVar, Variance variance) {
        if (wVar == null) {
            a(9);
            throw null;
        }
        if (this.f5144a.e()) {
            return wVar;
        }
        try {
            w wVarB = j(new F(wVar, variance), null, 0).b();
            if (wVarB != null) {
                return wVarB;
            }
            a(12);
            throw null;
        } catch (TypeSubstitutor$SubstitutionException e) {
            return i.c(ErrorTypeKind.k, e.getMessage());
        }
    }

    public final w i(w wVar, Variance variance) {
        if (wVar == null) {
            a(14);
            throw null;
        }
        if (variance == null) {
            a(15);
            throw null;
        }
        N f = new F(f().f(wVar, variance), variance);
        P p = this.f5144a;
        if (!p.e()) {
            try {
                f = j(f, null, 0);
            } catch (TypeSubstitutor$SubstitutionException unused) {
                f = null;
            }
        }
        if (p.a() || p.b()) {
            boolean zB = p.b();
            if (f == null) {
                f = null;
            } else if (!f.c()) {
                w wVarB = f.b();
                k.e(wVarB, "getType(...)");
                if (S.c(wVarB, C0889b.f2104a, null)) {
                    Variance varianceA = f.a();
                    k.e(varianceA, "getProjectionKind(...)");
                    if (varianceA == Variance.e) {
                        f = new F((w) M.a.y(wVarB).b, varianceA);
                    } else if (zB) {
                        f = new F((w) M.a.y(wVarB).f2103a, varianceA);
                    } else {
                        C0890c c0890c = new C0890c();
                        a aVar = new a(c0890c);
                        if (!c0890c.e()) {
                            try {
                                f = aVar.j(f, null, 0);
                            } catch (TypeSubstitutor$SubstitutionException unused2) {
                            }
                        }
                    }
                }
            }
        }
        if (f == null) {
            return null;
        }
        return f.b();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0131  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final X8.N j(X8.N r17, h8.InterfaceC1507O r18, int r19) throws kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor$SubstitutionException {
        /*
            Method dump skipped, instructions count: 798
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.types.a.j(X8.N, h8.O, int):X8.N");
    }
}
