package E9;

import ka.C4829i;
import ra.InterfaceC5238k;
import ya.AbstractC5990d0;

/* renamed from: E9.n, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0809n {
    public static final InterfaceC0799d a(InterfaceC0803h interfaceC0803h) {
        kotlin.jvm.internal.p.i(interfaceC0803h, "<this>");
        InterfaceC0803h interfaceC0803hB = interfaceC0803h.b();
        if (interfaceC0803hB != null && !(interfaceC0803h instanceof E)) {
            if (!b(interfaceC0803hB)) {
                return a(interfaceC0803hB);
            }
            if (interfaceC0803hB instanceof InterfaceC0799d) {
                return (InterfaceC0799d) interfaceC0803hB;
            }
        }
        return null;
    }

    public static final boolean b(InterfaceC0803h interfaceC0803h) {
        kotlin.jvm.internal.p.i(interfaceC0803h, "<this>");
        return interfaceC0803h.b() instanceof E;
    }

    public static final boolean c(kotlin.reflect.jvm.internal.impl.descriptors.e eVar) {
        AbstractC5990d0 abstractC5990d0N;
        ya.S sD;
        ya.S returnType;
        kotlin.jvm.internal.p.i(eVar, "<this>");
        InterfaceC0803h interfaceC0803hB = eVar.b();
        InterfaceC0797b interfaceC0797b = interfaceC0803hB instanceof InterfaceC0797b ? (InterfaceC0797b) interfaceC0803hB : null;
        if (interfaceC0797b != null) {
            InterfaceC0797b interfaceC0797b2 = C4829i.g(interfaceC0797b) ? interfaceC0797b : null;
            if (interfaceC0797b2 != null && (abstractC5990d0N = interfaceC0797b2.n()) != null && (sD = Da.d.D(abstractC5990d0N)) != null && (returnType = eVar.getReturnType()) != null && kotlin.jvm.internal.p.d(eVar.getName(), Fa.t.f2701e) && ((Da.d.s(returnType) || Da.d.t(returnType)) && eVar.i().size() == 1)) {
                ya.S type = eVar.i().get(0).getType();
                kotlin.jvm.internal.p.h(type, "getType(...)");
                if (kotlin.jvm.internal.p.d(Da.d.D(type), sD) && eVar.s0().isEmpty() && eVar.K() == null) {
                    return true;
                }
            }
        }
        return false;
    }

    public static final InterfaceC0797b d(InterfaceC0819y interfaceC0819y, ga.c fqName, M9.b lookupLocation) {
        InterfaceC5238k interfaceC5238kO;
        kotlin.jvm.internal.p.i(interfaceC0819y, "<this>");
        kotlin.jvm.internal.p.i(fqName, "fqName");
        kotlin.jvm.internal.p.i(lookupLocation, "lookupLocation");
        if (fqName.c()) {
            return null;
        }
        InterfaceC0799d interfaceC0799dD = interfaceC0819y.f0(fqName.d()).m().d(fqName.f(), lookupLocation);
        InterfaceC0797b interfaceC0797b = interfaceC0799dD instanceof InterfaceC0797b ? (InterfaceC0797b) interfaceC0799dD : null;
        if (interfaceC0797b != null) {
            return interfaceC0797b;
        }
        InterfaceC0797b interfaceC0797bD = d(interfaceC0819y, fqName.d(), lookupLocation);
        InterfaceC0799d interfaceC0799dD2 = (interfaceC0797bD == null || (interfaceC5238kO = interfaceC0797bD.O()) == null) ? null : interfaceC5238kO.d(fqName.f(), lookupLocation);
        if (interfaceC0799dD2 instanceof InterfaceC0797b) {
            return (InterfaceC0797b) interfaceC0799dD2;
        }
        return null;
    }
}
