package J8;

import X8.A;
import X8.S;
import X8.w;
import h8.AbstractC1508P;
import h8.C1537t;
import h8.C1541x;
import h8.InterfaceC1501I;
import h8.InterfaceC1510S;
import h8.InterfaceC1520c;
import h8.InterfaceC1522e;
import h8.InterfaceC1524g;
import h8.InterfaceC1527j;
import k8.I;

/* loaded from: classes4.dex */
public abstract class g {
    static {
        G8.c cVar = new G8.c("kotlin.jvm.JvmInline");
        cVar.e();
        G8.f fVarF = cVar.f();
        kotlin.jvm.internal.k.e(fVarF, "shortName(...)");
        G8.c.j(fVarF).d();
    }

    public static final boolean a(InterfaceC1520c interfaceC1520c) {
        AbstractC1508P abstractC1508PP;
        kotlin.jvm.internal.k.f(interfaceC1520c, "<this>");
        if (!(interfaceC1520c instanceof I)) {
            return false;
        }
        InterfaceC1501I interfaceC1501IR0 = ((I) interfaceC1520c).R0();
        kotlin.jvm.internal.k.e(interfaceC1501IR0, "getCorrespondingProperty(...)");
        if (interfaceC1501IR0.I() != null) {
            return false;
        }
        InterfaceC1527j interfaceC1527jD = interfaceC1501IR0.d();
        InterfaceC1522e interfaceC1522e = interfaceC1527jD instanceof InterfaceC1522e ? (InterfaceC1522e) interfaceC1527jD : null;
        if (interfaceC1522e == null || (abstractC1508PP = interfaceC1522e.P()) == null) {
            return false;
        }
        G8.f name = interfaceC1501IR0.getName();
        kotlin.jvm.internal.k.e(name, "getName(...)");
        return abstractC1508PP.a(name);
    }

    public static final boolean b(InterfaceC1527j interfaceC1527j) {
        kotlin.jvm.internal.k.f(interfaceC1527j, "<this>");
        return (interfaceC1527j instanceof InterfaceC1522e) && (((InterfaceC1522e) interfaceC1527j).P() instanceof C1537t);
    }

    public static final boolean c(w wVar) {
        kotlin.jvm.internal.k.f(wVar, "<this>");
        InterfaceC1524g interfaceC1524gD = wVar.Q().d();
        if (interfaceC1524gD != null) {
            return b(interfaceC1524gD);
        }
        return false;
    }

    public static final boolean d(InterfaceC1527j interfaceC1527j) {
        kotlin.jvm.internal.k.f(interfaceC1527j, "<this>");
        return (interfaceC1527j instanceof InterfaceC1522e) && (((InterfaceC1522e) interfaceC1527j).P() instanceof C1541x);
    }

    public static final boolean e(InterfaceC1510S interfaceC1510S) {
        if (interfaceC1510S.I() != null) {
            return false;
        }
        InterfaceC1527j interfaceC1527jD = interfaceC1510S.d();
        G8.f fVar = null;
        InterfaceC1522e interfaceC1522e = interfaceC1527jD instanceof InterfaceC1522e ? (InterfaceC1522e) interfaceC1527jD : null;
        if (interfaceC1522e != null) {
            int i = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.f5120a;
            AbstractC1508P abstractC1508PP = interfaceC1522e.P();
            C1537t c1537t = abstractC1508PP instanceof C1537t ? (C1537t) abstractC1508PP : null;
            if (c1537t != null) {
                fVar = c1537t.f4588a;
            }
        }
        return kotlin.jvm.internal.k.b(fVar, interfaceC1510S.getName());
    }

    public static final boolean f(InterfaceC1527j interfaceC1527j) {
        kotlin.jvm.internal.k.f(interfaceC1527j, "<this>");
        return b(interfaceC1527j) || d(interfaceC1527j);
    }

    public static final boolean g(w wVar) {
        InterfaceC1524g interfaceC1524gD = wVar.Q().d();
        if (interfaceC1524gD != null) {
            return f(interfaceC1524gD);
        }
        return false;
    }

    public static final boolean h(w wVar) {
        kotlin.jvm.internal.k.f(wVar, "<this>");
        InterfaceC1524g interfaceC1524gD = wVar.Q().d();
        return (interfaceC1524gD == null || !d(interfaceC1524gD) || S.e(wVar)) ? false : true;
    }

    public static final A i(w wVar) {
        kotlin.jvm.internal.k.f(wVar, "<this>");
        InterfaceC1524g interfaceC1524gD = wVar.Q().d();
        InterfaceC1522e interfaceC1522e = interfaceC1524gD instanceof InterfaceC1522e ? (InterfaceC1522e) interfaceC1524gD : null;
        if (interfaceC1522e != null) {
            int i = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.f5120a;
            AbstractC1508P abstractC1508PP = interfaceC1522e.P();
            C1537t c1537t = abstractC1508PP instanceof C1537t ? (C1537t) abstractC1508PP : null;
            if (c1537t != null) {
                return (A) c1537t.b;
            }
        }
        return null;
    }
}
