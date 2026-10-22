package b8;

import h8.InterfaceC1506N;
import h8.InterfaceC1507O;
import h8.InterfaceC1522e;
import h8.InterfaceC1524g;
import java.lang.reflect.Array;
import java.util.List;
import kotlin.NotImplementedError;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.jvm.internal.KotlinReflectionInternalError;
import n8.AbstractC1744c;

/* loaded from: classes4.dex */
public final class l0 implements Z7.u {
    public static final /* synthetic */ Z7.t[] e;

    /* renamed from: a, reason: collision with root package name */
    public final X8.w f2046a;
    public final p0 b;
    public final p0 c;
    public final p0 d;

    static {
        kotlin.jvm.internal.n nVar = kotlin.jvm.internal.m.f4928a;
        e = new Z7.t[]{nVar.g(new PropertyReference1Impl(nVar.b(l0.class), "classifier", "getClassifier()Lkotlin/reflect/KClassifier;")), nVar.g(new PropertyReference1Impl(nVar.b(l0.class), "arguments", "getArguments()Ljava/util/List;"))};
    }

    public l0(X8.w type, S7.a aVar) {
        kotlin.jvm.internal.k.f(type, "type");
        this.f2046a = type;
        p0 p0Var = aVar instanceof p0 ? (p0) aVar : null;
        this.b = p0Var == null ? aVar != null ? N9.j.E(null, aVar) : null : p0Var;
        this.c = N9.j.E(null, new j0(this, 0));
        this.d = N9.j.E(null, new J4.e(7, this, aVar));
    }

    @Override // Z7.u
    public final Z7.e a() {
        Z7.t tVar = e[0];
        return (Z7.e) this.c.invoke();
    }

    public final Z7.e b(X8.w wVar) {
        X8.w wVarB;
        InterfaceC1524g interfaceC1524gD = wVar.Q().d();
        if (interfaceC1524gD instanceof InterfaceC1522e) {
            Class clsK = v0.k((InterfaceC1522e) interfaceC1524gD);
            if (clsK != null) {
                if (!clsK.isArray()) {
                    if (X8.S.e(wVar)) {
                        return new kotlin.reflect.jvm.internal.a(clsK);
                    }
                    Class cls = (Class) AbstractC1744c.b.get(clsK);
                    if (cls != null) {
                        clsK = cls;
                    }
                    return new kotlin.reflect.jvm.internal.a(clsK);
                }
                X8.N n = (X8.N) D7.v.W0(wVar.L());
                if (n == null || (wVarB = n.b()) == null) {
                    return new kotlin.reflect.jvm.internal.a(clsK);
                }
                Z7.e eVarB = b(wVarB);
                if (eVarB != null) {
                    return new kotlin.reflect.jvm.internal.a(Array.newInstance((Class<?>) M.a.Z(com.stepos.statsrpk.d.A(eVarB)), 0).getClass());
                }
                throw new KotlinReflectionInternalError("Cannot determine classifier for array element type: " + this);
            }
        } else {
            if (interfaceC1524gD instanceof InterfaceC1507O) {
                return new m0(null, (InterfaceC1507O) interfaceC1524gD);
            }
            if (interfaceC1524gD instanceof InterfaceC1506N) {
                throw new NotImplementedError("An operation is not implemented: Type alias classifiers are not yet supported");
            }
        }
        return null;
    }

    @Override // Z7.u
    public final List c() {
        Z7.t tVar = e[1];
        Object objInvoke = this.d.invoke();
        kotlin.jvm.internal.k.e(objInvoke, "getValue(...)");
        return (List) objInvoke;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof l0)) {
            return false;
        }
        l0 l0Var = (l0) obj;
        return kotlin.jvm.internal.k.b(this.f2046a, l0Var.f2046a) && kotlin.jvm.internal.k.b(a(), l0Var.a()) && c().equals(l0Var.c());
    }

    public final int hashCode() {
        int iHashCode = this.f2046a.hashCode() * 31;
        Z7.e eVarA = a();
        return c().hashCode() + ((iHashCode + (eVarA != null ? eVarA.hashCode() : 0)) * 31);
    }

    public final String toString() {
        I8.g gVar = s0.f2054a;
        return s0.d(this.f2046a);
    }
}
