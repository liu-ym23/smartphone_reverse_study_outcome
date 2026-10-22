package h8;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.EmptyList;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;

/* renamed from: h8.u, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC1538u {

    /* renamed from: a, reason: collision with root package name */
    public static final A0.b f4589a = new A0.b("InvalidModuleNotifier", 5);

    public static final A5.c a(X8.A a3, InterfaceC1525h interfaceC1525h, int i) {
        if (interfaceC1525h == null || Z8.i.f(interfaceC1525h)) {
            return null;
        }
        int size = interfaceC1525h.h().size() + i;
        if (interfaceC1525h.q()) {
            List listSubList = a3.L().subList(i, size);
            InterfaceC1527j interfaceC1527jD = interfaceC1525h.d();
            return new A5.c(interfaceC1525h, listSubList, a(a3, interfaceC1527jD instanceof InterfaceC1525h ? (InterfaceC1525h) interfaceC1527jD : null, size));
        }
        if (size != a3.L().size()) {
            J8.e.o(interfaceC1525h);
        }
        return new A5.c(interfaceC1525h, a3.L().subList(i, a3.L().size()), (A5.c) null);
    }

    public static final void b(InterfaceC1497E interfaceC1497E, G8.c fqName, ArrayList arrayList) {
        kotlin.jvm.internal.k.f(interfaceC1497E, "<this>");
        kotlin.jvm.internal.k.f(fqName, "fqName");
        interfaceC1497E.a(fqName, arrayList);
    }

    public static final List c(InterfaceC1525h interfaceC1525h) {
        List parameters;
        Object next;
        X8.K kM;
        List listH = interfaceC1525h.h();
        kotlin.jvm.internal.k.e(listH, "getDeclaredTypeParameters(...)");
        if (!interfaceC1525h.q() && !(interfaceC1525h.d() instanceof InterfaceC1519b)) {
            return listH;
        }
        int i = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.f5120a;
        N8.b bVar = N8.b.b;
        List listO0 = kotlin.sequences.a.o0(kotlin.sequences.a.h0(kotlin.sequences.a.f0(new D7.t(kotlin.sequences.a.e0(kotlin.sequences.a.k0(bVar, interfaceC1525h), 1), 6), C1534q.d), C1534q.e));
        Iterator it = kotlin.sequences.a.e0(kotlin.sequences.a.k0(bVar, interfaceC1525h), 1).iterator();
        while (true) {
            parameters = null;
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (next instanceof InterfaceC1522e) {
                break;
            }
        }
        InterfaceC1522e interfaceC1522e = (InterfaceC1522e) next;
        if (interfaceC1522e != null && (kM = interfaceC1522e.m()) != null) {
            parameters = kM.getParameters();
        }
        if (parameters == null) {
            parameters = EmptyList.f4893a;
        }
        if (listO0.isEmpty() && parameters.isEmpty()) {
            List listH2 = interfaceC1525h.h();
            kotlin.jvm.internal.k.e(listH2, "getDeclaredTypeParameters(...)");
            return listH2;
        }
        ArrayList arrayListQ0 = D7.v.Q0(parameters, listO0);
        ArrayList arrayList = new ArrayList(D7.w.c0(arrayListQ0, 10));
        Iterator it2 = arrayListQ0.iterator();
        while (it2.hasNext()) {
            InterfaceC1507O interfaceC1507O = (InterfaceC1507O) it2.next();
            kotlin.jvm.internal.k.c(interfaceC1507O);
            arrayList.add(new C1521d(interfaceC1507O, interfaceC1525h, listH.size()));
        }
        return D7.v.Q0(arrayList, listH);
    }

    public static final InterfaceC1524g d(InterfaceC1527j interfaceC1527j) {
        kotlin.jvm.internal.k.f(interfaceC1527j, "<this>");
        InterfaceC1527j interfaceC1527jD = interfaceC1527j.d();
        if (interfaceC1527jD == null || (interfaceC1527j instanceof InterfaceC1494B)) {
            return null;
        }
        if (!(interfaceC1527jD.d() instanceof InterfaceC1494B)) {
            return d(interfaceC1527jD);
        }
        if (interfaceC1527jD instanceof InterfaceC1524g) {
            return (InterfaceC1524g) interfaceC1527jD;
        }
        return null;
    }

    public static final boolean e(InterfaceC1497E interfaceC1497E, G8.c fqName) {
        kotlin.jvm.internal.k.f(interfaceC1497E, "<this>");
        kotlin.jvm.internal.k.f(fqName, "fqName");
        return interfaceC1497E.b(fqName);
    }

    public static final ArrayList f(InterfaceC1497E interfaceC1497E, G8.c fqName) {
        kotlin.jvm.internal.k.f(interfaceC1497E, "<this>");
        kotlin.jvm.internal.k.f(fqName, "fqName");
        ArrayList arrayList = new ArrayList();
        b(interfaceC1497E, fqName, arrayList);
        return arrayList;
    }

    public static final InterfaceC1522e g(InterfaceC1540w interfaceC1540w, G8.c fqName) {
        InterfaceC1524g interfaceC1524gB;
        Q8.o oVarO;
        NoLookupLocation noLookupLocation = NoLookupLocation.f4986a;
        kotlin.jvm.internal.k.f(interfaceC1540w, "<this>");
        kotlin.jvm.internal.k.f(fqName, "fqName");
        if (!fqName.d()) {
            Q8.k kVar = ((k8.w) interfaceC1540w.V(fqName.e())).g;
            G8.f fVarF = fqName.f();
            kotlin.jvm.internal.k.e(fVarF, "shortName(...)");
            InterfaceC1524g interfaceC1524gB2 = kVar.b(fVarF, noLookupLocation);
            InterfaceC1522e interfaceC1522e = interfaceC1524gB2 instanceof InterfaceC1522e ? (InterfaceC1522e) interfaceC1524gB2 : null;
            if (interfaceC1522e != null) {
                return interfaceC1522e;
            }
            InterfaceC1522e interfaceC1522eG = g(interfaceC1540w, fqName.e());
            if (interfaceC1522eG == null || (oVarO = interfaceC1522eG.O()) == null) {
                interfaceC1524gB = null;
            } else {
                G8.f fVarF2 = fqName.f();
                kotlin.jvm.internal.k.e(fVarF2, "shortName(...)");
                interfaceC1524gB = oVarO.b(fVarF2, noLookupLocation);
            }
            if (interfaceC1524gB instanceof InterfaceC1522e) {
                return (InterfaceC1522e) interfaceC1524gB;
            }
        }
        return null;
    }
}
