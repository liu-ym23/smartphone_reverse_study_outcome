package kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil;

import D7.q;
import D7.v;
import G8.b;
import G8.e;
import G8.f;
import H4.o;
import N8.c;
import Y8.g;
import e8.i;
import g9.l;
import h8.InterfaceC1494B;
import h8.InterfaceC1500H;
import h8.InterfaceC1501I;
import h8.InterfaceC1520c;
import h8.InterfaceC1522e;
import h8.InterfaceC1524g;
import h8.InterfaceC1525h;
import h8.InterfaceC1527j;
import h8.InterfaceC1528k;
import h8.InterfaceC1540w;
import i8.InterfaceC1556b;
import java.util.Collection;
import k8.AbstractC1629B;
import k8.F;
import k8.Q;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.jvm.internal.k;

/* loaded from: classes4.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f5120a = 0;

    static {
        f.e("value");
    }

    public static final boolean a(Q q5) {
        Boolean boolI = l.i(o.M(q5), N8.a.b, DescriptorUtilsKt$declaresOrInheritsDefaultValue$2.f5119a);
        k.e(boolI, "ifAny(...)");
        return boolI.booleanValue();
    }

    public static InterfaceC1520c b(InterfaceC1520c interfaceC1520c, S7.k kVar) {
        k.f(interfaceC1520c, "<this>");
        return (InterfaceC1520c) l.g(o.M(interfaceC1520c), new N8.a(1), new c(kVar, new Ref$ObjectRef()));
    }

    public static final G8.c c(InterfaceC1528k interfaceC1528k) {
        k.f(interfaceC1528k, "<this>");
        e eVarH = h(interfaceC1528k);
        if (!eVarH.d()) {
            eVarH = null;
        }
        if (eVarH != null) {
            return eVarH.g();
        }
        return null;
    }

    public static final InterfaceC1522e d(InterfaceC1556b interfaceC1556b) {
        k.f(interfaceC1556b, "<this>");
        InterfaceC1524g interfaceC1524gD = interfaceC1556b.getType().Q().d();
        if (interfaceC1524gD instanceof InterfaceC1522e) {
            return (InterfaceC1522e) interfaceC1524gD;
        }
        return null;
    }

    public static final i e(InterfaceC1527j interfaceC1527j) {
        k.f(interfaceC1527j, "<this>");
        return j(interfaceC1527j).c();
    }

    public static final b f(InterfaceC1524g interfaceC1524g) {
        InterfaceC1527j interfaceC1527jD;
        b bVarF;
        if (interfaceC1524g == null || (interfaceC1527jD = interfaceC1524g.d()) == null) {
            return null;
        }
        if (interfaceC1527jD instanceof InterfaceC1494B) {
            G8.c cVar = ((AbstractC1629B) ((InterfaceC1494B) interfaceC1527jD)).e;
            f name = interfaceC1524g.getName();
            k.e(name, "getName(...)");
            return new b(cVar, name);
        }
        if (!(interfaceC1527jD instanceof InterfaceC1525h) || (bVarF = f((InterfaceC1524g) interfaceC1527jD)) == null) {
            return null;
        }
        f name2 = interfaceC1524g.getName();
        k.e(name2, "getName(...)");
        return bVarF.d(name2);
    }

    public static final G8.c g(InterfaceC1527j interfaceC1527j) {
        k.f(interfaceC1527j, "<this>");
        G8.c cVarH = J8.e.h(interfaceC1527j);
        return cVarH != null ? cVarH : J8.e.g(interfaceC1527j.d()).b(interfaceC1527j.getName()).g();
    }

    public static final e h(InterfaceC1527j interfaceC1527j) {
        k.f(interfaceC1527j, "<this>");
        e eVarG = J8.e.g(interfaceC1527j);
        k.e(eVarG, "getFqName(...)");
        return eVarG;
    }

    public static final void i(InterfaceC1540w interfaceC1540w) {
        k.f(interfaceC1540w, "<this>");
        if (interfaceC1540w.z(g.f1575a) != null) {
            throw new ClassCastException();
        }
    }

    public static final InterfaceC1540w j(InterfaceC1527j interfaceC1527j) {
        k.f(interfaceC1527j, "<this>");
        InterfaceC1540w interfaceC1540wD = J8.e.d(interfaceC1527j);
        k.e(interfaceC1540wD, "getContainingModule(...)");
        return interfaceC1540wD;
    }

    public static final InterfaceC1520c k(InterfaceC1520c interfaceC1520c) {
        k.f(interfaceC1520c, "<this>");
        if (!(interfaceC1520c instanceof InterfaceC1500H)) {
            return interfaceC1520c;
        }
        InterfaceC1501I interfaceC1501IR0 = ((F) ((InterfaceC1500H) interfaceC1520c)).R0();
        k.e(interfaceC1501IR0, "getCorrespondingProperty(...)");
        return interfaceC1501IR0;
    }

    public static final i9.g l(InterfaceC1520c interfaceC1520c) {
        k.f(interfaceC1520c, "<this>");
        i9.i iVarM = q.M(new InterfaceC1520c[]{interfaceC1520c});
        Collection collectionE = interfaceC1520c.e();
        k.e(collectionE, "getOverriddenDescriptors(...)");
        return kotlin.sequences.a.i0(q.M(new i9.i[]{iVarM, kotlin.sequences.a.h0(v.s0(collectionE), new N8.b(1))}));
    }
}
