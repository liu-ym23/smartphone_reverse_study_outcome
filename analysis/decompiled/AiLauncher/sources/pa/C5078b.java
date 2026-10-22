package pa;

import C9.o;
import E9.C0810o;
import E9.InterfaceC0797b;
import E9.InterfaceC0799d;
import E9.InterfaceC0803h;
import E9.b0;
import E9.i0;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import ka.C4828h;
import ka.C4829i;
import kotlin.jvm.internal.p;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import ya.S;

/* renamed from: pa.b, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C5078b {
    public static final boolean a(InterfaceC0797b interfaceC0797b) {
        return p.d(DescriptorUtilsKt.o(interfaceC0797b), o.f1843x);
    }

    public static final boolean b(S s10, boolean z10) {
        InterfaceC0799d interfaceC0799dD = s10.H0().d();
        b0 b0Var = interfaceC0799dD instanceof b0 ? (b0) interfaceC0799dD : null;
        if (b0Var == null) {
            return false;
        }
        return (z10 || !C4829i.d(b0Var)) && e(Da.d.o(b0Var));
    }

    public static final boolean c(InterfaceC0803h interfaceC0803h) {
        p.i(interfaceC0803h, "<this>");
        return C4829i.g(interfaceC0803h) && !a((InterfaceC0797b) interfaceC0803h);
    }

    public static final boolean d(S s10) {
        p.i(s10, "<this>");
        InterfaceC0799d interfaceC0799dD = s10.H0().d();
        return interfaceC0799dD != null && ((C4829i.b(interfaceC0799dD) && c(interfaceC0799dD)) || C4829i.i(s10));
    }

    public static final boolean e(S s10) {
        return d(s10) || b(s10, true);
    }

    public static final boolean f(CallableMemberDescriptor descriptor) {
        p.i(descriptor, "descriptor");
        kotlin.reflect.jvm.internal.impl.descriptors.b bVar = descriptor instanceof kotlin.reflect.jvm.internal.impl.descriptors.b ? (kotlin.reflect.jvm.internal.impl.descriptors.b) descriptor : null;
        if (bVar == null || C0810o.g(bVar.getVisibility())) {
            return false;
        }
        InterfaceC0797b interfaceC0797bY = bVar.Y();
        p.h(interfaceC0797bY, "getConstructedClass(...)");
        if (C4829i.g(interfaceC0797bY) || C4828h.G(bVar.Y())) {
            return false;
        }
        List<i0> listI = bVar.i();
        p.h(listI, "getValueParameters(...)");
        List<i0> list = listI;
        if ((list instanceof Collection) && list.isEmpty()) {
            return false;
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            S type = ((i0) it.next()).getType();
            p.h(type, "getType(...)");
            if (e(type)) {
                return true;
            }
        }
        return false;
    }
}
