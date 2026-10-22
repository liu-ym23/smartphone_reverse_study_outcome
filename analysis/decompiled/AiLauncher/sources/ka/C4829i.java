package ka;

import E9.C0813s;
import E9.C0820z;
import E9.InterfaceC0797b;
import E9.InterfaceC0799d;
import E9.InterfaceC0803h;
import E9.O;
import E9.P;
import E9.g0;
import E9.j0;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import ya.AbstractC5990d0;
import ya.S;
import za.C6468n;

/* renamed from: ka.i, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C4829i {

    /* renamed from: a, reason: collision with root package name */
    public static final ga.c f34653a;

    /* renamed from: b, reason: collision with root package name */
    public static final ga.b f34654b;

    /* renamed from: c, reason: collision with root package name */
    public static final ga.c f34655c;

    static {
        ga.c cVar = new ga.c("kotlin.jvm.JvmInline");
        f34653a = cVar;
        f34654b = ga.b.f32721d.c(cVar);
        f34655c = new ga.c("kotlin.jvm.JvmName");
    }

    public static final boolean a(kotlin.reflect.jvm.internal.impl.descriptors.a aVar) {
        kotlin.jvm.internal.p.i(aVar, "<this>");
        if (!(aVar instanceof P)) {
            return false;
        }
        O oQ = ((P) aVar).Q();
        kotlin.jvm.internal.p.h(oQ, "getCorrespondingProperty(...)");
        return f(oQ);
    }

    public static final boolean b(InterfaceC0803h interfaceC0803h) {
        kotlin.jvm.internal.p.i(interfaceC0803h, "<this>");
        return (interfaceC0803h instanceof InterfaceC0797b) && (((InterfaceC0797b) interfaceC0803h).P() instanceof C0813s);
    }

    public static final boolean c(S s10) {
        kotlin.jvm.internal.p.i(s10, "<this>");
        InterfaceC0799d interfaceC0799dD = s10.H0().d();
        if (interfaceC0799dD != null) {
            return b(interfaceC0799dD);
        }
        return false;
    }

    public static final boolean d(InterfaceC0803h interfaceC0803h) {
        kotlin.jvm.internal.p.i(interfaceC0803h, "<this>");
        return (interfaceC0803h instanceof InterfaceC0797b) && (((InterfaceC0797b) interfaceC0803h).P() instanceof C0820z);
    }

    public static final boolean e(j0 j0Var) {
        C0813s<AbstractC5990d0> c0813sQ;
        kotlin.jvm.internal.p.i(j0Var, "<this>");
        if (j0Var.K() != null) {
            return false;
        }
        InterfaceC0803h interfaceC0803hB = j0Var.b();
        ga.e eVarC = null;
        InterfaceC0797b interfaceC0797b = interfaceC0803hB instanceof InterfaceC0797b ? (InterfaceC0797b) interfaceC0803hB : null;
        if (interfaceC0797b != null && (c0813sQ = DescriptorUtilsKt.q(interfaceC0797b)) != null) {
            eVarC = c0813sQ.c();
        }
        return kotlin.jvm.internal.p.d(eVarC, j0Var.getName());
    }

    public static final boolean f(j0 j0Var) {
        g0<AbstractC5990d0> g0VarP;
        kotlin.jvm.internal.p.i(j0Var, "<this>");
        if (j0Var.K() != null) {
            return false;
        }
        InterfaceC0803h interfaceC0803hB = j0Var.b();
        InterfaceC0797b interfaceC0797b = interfaceC0803hB instanceof InterfaceC0797b ? (InterfaceC0797b) interfaceC0803hB : null;
        if (interfaceC0797b == null || (g0VarP = interfaceC0797b.P()) == null) {
            return false;
        }
        ga.e name = j0Var.getName();
        kotlin.jvm.internal.p.h(name, "getName(...)");
        return g0VarP.a(name);
    }

    public static final boolean g(InterfaceC0803h interfaceC0803h) {
        kotlin.jvm.internal.p.i(interfaceC0803h, "<this>");
        return b(interfaceC0803h) || d(interfaceC0803h);
    }

    public static final boolean h(S s10) {
        kotlin.jvm.internal.p.i(s10, "<this>");
        InterfaceC0799d interfaceC0799dD = s10.H0().d();
        if (interfaceC0799dD != null) {
            return g(interfaceC0799dD);
        }
        return false;
    }

    public static final boolean i(S s10) {
        kotlin.jvm.internal.p.i(s10, "<this>");
        InterfaceC0799d interfaceC0799dD = s10.H0().d();
        return (interfaceC0799dD == null || !d(interfaceC0799dD) || C6468n.f45422a.p(s10)) ? false : true;
    }

    public static final S j(S s10) {
        C0813s<AbstractC5990d0> c0813sQ;
        kotlin.jvm.internal.p.i(s10, "<this>");
        InterfaceC0799d interfaceC0799dD = s10.H0().d();
        InterfaceC0797b interfaceC0797b = interfaceC0799dD instanceof InterfaceC0797b ? (InterfaceC0797b) interfaceC0799dD : null;
        if (interfaceC0797b == null || (c0813sQ = DescriptorUtilsKt.q(interfaceC0797b)) == null) {
            return null;
        }
        return (AbstractC5990d0) c0813sQ.d();
    }
}
