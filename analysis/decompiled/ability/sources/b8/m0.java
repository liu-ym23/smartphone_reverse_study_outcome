package b8;

import h8.InterfaceC1507O;
import h8.InterfaceC1520c;
import h8.InterfaceC1522e;
import h8.InterfaceC1527j;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.KVariance;
import kotlin.reflect.jvm.internal.KotlinReflectionInternalError;
import m8.C1682b;
import z8.C2197i;

/* loaded from: classes4.dex */
public final class m0 implements Z7.v {
    public static final /* synthetic */ Z7.t[] d;

    /* renamed from: a, reason: collision with root package name */
    public final InterfaceC1507O f2047a;
    public final p0 b;
    public final n0 c;

    static {
        kotlin.jvm.internal.n nVar = kotlin.jvm.internal.m.f4928a;
        d = new Z7.t[]{nVar.g(new PropertyReference1Impl(nVar.b(m0.class), "upperBounds", "getUpperBounds()Ljava/util/List;"))};
    }

    public m0(n0 n0Var, InterfaceC1507O descriptor) {
        Class cls;
        kotlin.reflect.jvm.internal.a aVarB;
        Object objN;
        kotlin.jvm.internal.k.f(descriptor, "descriptor");
        this.f2047a = descriptor;
        this.b = N9.j.E(null, new I8.e(this, 17));
        if (n0Var == null) {
            InterfaceC1527j interfaceC1527jD = descriptor.d();
            kotlin.jvm.internal.k.e(interfaceC1527jD, "getContainingDeclaration(...)");
            if (interfaceC1527jD instanceof InterfaceC1522e) {
                objN = b((InterfaceC1522e) interfaceC1527jD);
            } else {
                if (!(interfaceC1527jD instanceof InterfaceC1520c)) {
                    throw new KotlinReflectionInternalError("Unknown type parameter container: " + interfaceC1527jD);
                }
                InterfaceC1527j interfaceC1527jD2 = ((InterfaceC1520c) interfaceC1527jD).d();
                kotlin.jvm.internal.k.e(interfaceC1527jD2, "getContainingDeclaration(...)");
                if (interfaceC1527jD2 instanceof InterfaceC1522e) {
                    aVarB = b((InterfaceC1522e) interfaceC1527jD2);
                } else {
                    V8.k kVar = interfaceC1527jD instanceof V8.k ? (V8.k) interfaceC1527jD : null;
                    if (kVar == null) {
                        throw new KotlinReflectionInternalError("Non-class callable descriptor must be deserialized: " + interfaceC1527jD);
                    }
                    V8.j jVarB = kVar.B();
                    C2197i c2197i = jVarB instanceof C2197i ? (C2197i) jVarB : null;
                    C1682b c1682b = c2197i != null ? c2197i.c : null;
                    C1682b c1682b2 = c1682b instanceof C1682b ? c1682b : null;
                    if (c1682b2 == null || (cls = c1682b2.f5307a) == null) {
                        throw new KotlinReflectionInternalError("Container of deserialized member is not resolved: " + kVar);
                    }
                    aVarB = (kotlin.reflect.jvm.internal.a) M.a.c0(cls);
                }
                objN = interfaceC1527jD.N(new h2.d(aVarB), C7.r.f317a);
            }
            n0Var = (n0) objN;
        }
        this.c = n0Var;
    }

    public static kotlin.reflect.jvm.internal.a b(InterfaceC1522e interfaceC1522e) {
        Class clsK = v0.k(interfaceC1522e);
        kotlin.reflect.jvm.internal.a aVar = (kotlin.reflect.jvm.internal.a) (clsK != null ? M.a.c0(clsK) : null);
        if (aVar != null) {
            return aVar;
        }
        throw new KotlinReflectionInternalError("Type parameter container is not resolved: " + interfaceC1522e.d());
    }

    public final String a() {
        String strB = this.f2047a.getName().b();
        kotlin.jvm.internal.k.e(strB, "asString(...)");
        return strB;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof m0)) {
            return false;
        }
        m0 m0Var = (m0) obj;
        return kotlin.jvm.internal.k.b(this.c, m0Var.c) && a().equals(m0Var.a());
    }

    public final int hashCode() {
        return a().hashCode() + (this.c.hashCode() * 31);
    }

    public final String toString() {
        KVariance kVariance;
        StringBuilder sb = new StringBuilder();
        int iOrdinal = this.f2047a.r().ordinal();
        if (iOrdinal == 0) {
            kVariance = KVariance.f4931a;
        } else if (iOrdinal == 1) {
            kVariance = KVariance.b;
        } else {
            if (iOrdinal != 2) {
                throw new NoWhenBranchMatchedException();
            }
            kVariance = KVariance.c;
        }
        int iOrdinal2 = kVariance.ordinal();
        if (iOrdinal2 != 0) {
            if (iOrdinal2 == 1) {
                sb.append("in ");
            } else {
                if (iOrdinal2 != 2) {
                    throw new NoWhenBranchMatchedException();
                }
                sb.append("out ");
            }
        }
        sb.append(a());
        return sb.toString();
    }
}
