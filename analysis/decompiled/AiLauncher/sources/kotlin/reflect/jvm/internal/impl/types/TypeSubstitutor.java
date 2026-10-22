package kotlin.reflect.jvm.internal.impl.types;

import Aa.i;
import C9.j;
import C9.o;
import Ca.p;
import Da.d;
import E9.b0;
import F9.g;
import F9.n;
import ga.c;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind;
import la.C4882e;
import p9.InterfaceC5074l;
import ya.AbstractC5974I;
import ya.AbstractC5990d0;
import ya.B0;
import ya.C5968C;
import ya.C5970E;
import ya.C5977L;
import ya.C5978M;
import ya.C5998h0;
import ya.D0;
import ya.E0;
import ya.F0;
import ya.H0;
import ya.I0;
import ya.InterfaceC5988c0;
import ya.InterfaceC6015v;
import ya.J0;
import ya.K0;
import ya.S;
import ya.V;
import ya.W;
import ya.u0;
import ya.v0;
import ya.w0;
import za.C6464j;

/* loaded from: classes5.dex */
public class TypeSubstitutor implements p {

    /* renamed from: b, reason: collision with root package name */
    public static final TypeSubstitutor f36088b = h(E0.f44017b);

    /* renamed from: a, reason: collision with root package name */
    public final E0 f36089a;

    public static final class SubstitutionException extends Exception {
        public SubstitutionException(String str) {
            super(str);
        }
    }

    public enum VarianceConflictType {
        NO_CONFLICT,
        IN_IN_OUT_POSITION,
        OUT_IN_IN_POSITION
    }

    public static class a implements InterfaceC5074l<c, Boolean> {
        private static /* synthetic */ void a(int i10) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "name", "kotlin/reflect/jvm/internal/impl/types/TypeSubstitutor$1", "invoke"));
        }

        @Override // p9.InterfaceC5074l
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Boolean invoke(c cVar) {
            if (cVar == null) {
                a(0);
            }
            return Boolean.valueOf(!cVar.equals(o.a.f1878Q));
        }
    }

    public static /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f36090a;

        static {
            int[] iArr = new int[VarianceConflictType.values().length];
            f36090a = iArr;
            try {
                iArr[VarianceConflictType.OUT_IN_IN_POSITION.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f36090a[VarianceConflictType.IN_IN_OUT_POSITION.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f36090a[VarianceConflictType.NO_CONFLICT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public TypeSubstitutor(E0 e02) {
        if (e02 == null) {
            a(7);
        }
        this.f36089a = e02;
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
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor.a(int):void");
    }

    public static void b(int i10, B0 b02, E0 e02) {
        if (i10 <= 100) {
            return;
        }
        throw new IllegalStateException("Recursion too deep. Most likely infinite loop while substituting " + p(b02) + "; substitution: " + p(e02));
    }

    public static Variance c(Variance variance, Variance variance2) {
        if (variance == null) {
            a(38);
        }
        if (variance2 == null) {
            a(39);
        }
        Variance variance3 = Variance.INVARIANT;
        if (variance == variance3) {
            if (variance2 == null) {
                a(40);
            }
            return variance2;
        }
        if (variance2 == variance3) {
            if (variance == null) {
                a(41);
            }
            return variance;
        }
        if (variance == variance2) {
            if (variance2 == null) {
                a(42);
            }
            return variance2;
        }
        throw new AssertionError("Variance conflict: type parameter variance '" + variance + "' and projection kind '" + variance2 + "' cannot be combined");
    }

    public static Variance d(Variance variance, B0 b02) {
        if (variance == null) {
            a(35);
        }
        if (b02 == null) {
            a(36);
        }
        if (!b02.b()) {
            return c(variance, b02.c());
        }
        Variance variance2 = Variance.OUT_VARIANCE;
        if (variance2 == null) {
            a(37);
        }
        return variance2;
    }

    public static VarianceConflictType e(Variance variance, Variance variance2) {
        Variance variance3 = Variance.IN_VARIANCE;
        return (variance == variance3 && variance2 == Variance.OUT_VARIANCE) ? VarianceConflictType.OUT_IN_IN_POSITION : (variance == Variance.OUT_VARIANCE && variance2 == variance3) ? VarianceConflictType.IN_IN_OUT_POSITION : VarianceConflictType.NO_CONFLICT;
    }

    public static TypeSubstitutor f(Map<v0, B0> map) {
        if (map == null) {
            a(5);
        }
        return h(w0.j(map));
    }

    public static TypeSubstitutor g(S s10) {
        if (s10 == null) {
            a(6);
        }
        return h(w0.i(s10.H0(), s10.F0()));
    }

    public static TypeSubstitutor h(E0 e02) {
        if (e02 == null) {
            a(0);
        }
        return new TypeSubstitutor(e02);
    }

    public static TypeSubstitutor i(E0 e02, E0 e03) {
        if (e02 == null) {
            a(3);
        }
        if (e03 == null) {
            a(4);
        }
        return h(C5968C.i(e02, e03));
    }

    public static g j(g gVar) {
        if (gVar == null) {
            a(33);
        }
        return !gVar.E(o.a.f1878Q) ? gVar : new F9.o(gVar, new a());
    }

    public static B0 m(S s10, B0 b02, b0 b0Var, B0 b03) {
        if (s10 == null) {
            a(26);
        }
        if (b02 == null) {
            a(27);
        }
        if (b03 == null) {
            a(28);
        }
        if (!s10.getAnnotations().E(o.a.f1878Q)) {
            if (b02 == null) {
                a(29);
            }
            return b02;
        }
        v0 v0VarH0 = b02.getType().H0();
        if (!(v0VarH0 instanceof C6464j)) {
            return b02;
        }
        B0 b0C = ((C6464j) v0VarH0).c();
        Variance varianceC = b0C.c();
        VarianceConflictType varianceConflictTypeE = e(b03.c(), varianceC);
        VarianceConflictType varianceConflictType = VarianceConflictType.OUT_IN_IN_POSITION;
        return varianceConflictTypeE == varianceConflictType ? new D0(b0C.getType()) : (b0Var != null && e(b0Var.l(), varianceC) == varianceConflictType) ? new D0(b0C.getType()) : b02;
    }

    public static String p(Object obj) {
        try {
            return obj.toString();
        } catch (Throwable th) {
            if (Ia.c.a(th)) {
                throw th;
            }
            return "[Exception while computing toString(): " + th + "]";
        }
    }

    public E0 k() {
        E0 e02 = this.f36089a;
        if (e02 == null) {
            a(8);
        }
        return e02;
    }

    public boolean l() {
        return this.f36089a.f();
    }

    public TypeSubstitutor n() {
        E0 e02 = this.f36089a;
        return ((e02 instanceof C5978M) && e02.b()) ? new TypeSubstitutor(new C5978M(((C5978M) this.f36089a).j(), ((C5978M) this.f36089a).i(), false)) : this;
    }

    public S o(S s10, Variance variance) {
        if (s10 == null) {
            a(9);
        }
        if (variance == null) {
            a(10);
        }
        if (l()) {
            if (s10 == null) {
                a(11);
            }
            return s10;
        }
        try {
            S type = v(new D0(variance, s10), null, 0).getType();
            if (type == null) {
                a(12);
            }
            return type;
        } catch (SubstitutionException e10) {
            Aa.g gVarD = i.d(ErrorTypeKind.UNABLE_TO_SUBSTITUTE_TYPE, e10.getMessage());
            if (gVarD == null) {
                a(13);
            }
            return gVarD;
        }
    }

    public S q(S s10, Variance variance) {
        if (s10 == null) {
            a(14);
        }
        if (variance == null) {
            a(15);
        }
        B0 b0R = r(new D0(variance, k().g(s10, variance)));
        if (b0R == null) {
            return null;
        }
        return b0R.getType();
    }

    public B0 r(B0 b02) {
        if (b02 == null) {
            a(16);
        }
        B0 b0U = u(b02);
        return (this.f36089a.a() || this.f36089a.b()) ? Ea.c.d(b0U, this.f36089a.b()) : b0U;
    }

    public final B0 s(B0 b02, int i10) throws SubstitutionException {
        S type = b02.getType();
        Variance varianceC = b02.c();
        if (type.H0().d() instanceof b0) {
            return b02;
        }
        AbstractC5990d0 abstractC5990d0B = C5998h0.b(type);
        S sQ = abstractC5990d0B != null ? n().q(abstractC5990d0B, Variance.INVARIANT) : null;
        S sB = F0.b(type, t(type.H0().getParameters(), type.F0(), i10), this.f36089a.d(type.getAnnotations()));
        if ((sB instanceof AbstractC5990d0) && (sQ instanceof AbstractC5990d0)) {
            sB = C5998h0.j((AbstractC5990d0) sB, (AbstractC5990d0) sQ);
        }
        return new D0(varianceC, sB);
    }

    public final List<B0> t(List<b0> list, List<B0> list2, int i10) throws SubstitutionException {
        ArrayList arrayList = new ArrayList(list.size());
        boolean z10 = false;
        for (int i11 = 0; i11 < list.size(); i11++) {
            b0 b0Var = list.get(i11);
            B0 b02 = list2.get(i11);
            B0 b0V = v(b02, b0Var, i10 + 1);
            int i12 = b.f36090a[e(b0Var.l(), b0V.c()).ordinal()];
            if (i12 == 1 || i12 == 2) {
                b0V = H0.s(b0Var);
            } else if (i12 == 3) {
                Variance varianceL = b0Var.l();
                Variance variance = Variance.INVARIANT;
                if (varianceL != variance && !b0V.b()) {
                    b0V = new D0(variance, b0V.getType());
                }
            }
            if (b0V != b02) {
                z10 = true;
            }
            arrayList.add(b0V);
        }
        return !z10 ? list2 : arrayList;
    }

    public B0 u(B0 b02) {
        if (b02 == null) {
            a(17);
        }
        if (l()) {
            return b02;
        }
        try {
            return v(b02, null, 0);
        } catch (SubstitutionException unused) {
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final B0 v(B0 b02, b0 b0Var, int i10) throws SubstitutionException {
        if (b02 == null) {
            a(18);
        }
        b(i10, b02, this.f36089a);
        if (!b02.b()) {
            S type = b02.getType();
            if (type instanceof I0) {
                I0 i02 = (I0) type;
                K0 k0A0 = i02.A0();
                S sC0 = i02.c0();
                B0 b0V = v(new D0(b02.c(), k0A0), b0Var, i10 + 1);
                return b0V.b() ? b0V : new D0(b0V.c(), J0.d(b0V.getType().K0(), q(sC0, b02.c())));
            }
            if (!C5970E.a(type) && !(type.K0() instanceof InterfaceC5988c0)) {
                B0 b0E = this.f36089a.e(type);
                B0 b0M = b0E != null ? m(type, b0E, b0Var, b02) : null;
                Variance varianceC = b02.c();
                if (b0M == null && C5977L.b(type) && !u0.b(type)) {
                    AbstractC5974I abstractC5974IA = C5977L.a(type);
                    int i11 = i10 + 1;
                    B0 b0V2 = v(new D0(varianceC, abstractC5974IA.P0()), b0Var, i11);
                    B0 b0V3 = v(new D0(varianceC, abstractC5974IA.Q0()), b0Var, i11);
                    Variance varianceC2 = b0V2.c();
                    if (b0V2.getType() != abstractC5974IA.P0() || b0V3.getType() != abstractC5974IA.Q0()) {
                        return new D0(varianceC2, V.e(F0.a(b0V2.getType()), F0.a(b0V3.getType())));
                    }
                } else if (!j.o0(type) && !W.a(type)) {
                    if (b0M == null) {
                        B0 b0S = s(b02, i10);
                        if (b0S == null) {
                            a(25);
                        }
                        return b0S;
                    }
                    VarianceConflictType varianceConflictTypeE = e(varianceC, b0M.c());
                    if (!C4882e.f(type)) {
                        int i12 = b.f36090a[varianceConflictTypeE.ordinal()];
                        if (i12 == 1) {
                            throw new SubstitutionException("Out-projection in in-position");
                        }
                        if (i12 == 2) {
                            return new D0(Variance.OUT_VARIANCE, type.H0().g().J());
                        }
                    }
                    InterfaceC6015v interfaceC6015vA = u0.a(type);
                    if (b0M.b()) {
                        return b0M;
                    }
                    S sT = interfaceC6015vA != null ? interfaceC6015vA.T(b0M.getType()) : H0.q(b0M.getType(), type.I0());
                    if (!type.getAnnotations().isEmpty()) {
                        sT = d.C(sT, new n(sT.getAnnotations(), j(this.f36089a.d(type.getAnnotations()))));
                    }
                    if (varianceConflictTypeE == VarianceConflictType.NO_CONFLICT) {
                        varianceC = c(varianceC, b0M.c());
                    }
                    return new D0(varianceC, sT);
                }
            }
        }
        return b02;
    }
}
