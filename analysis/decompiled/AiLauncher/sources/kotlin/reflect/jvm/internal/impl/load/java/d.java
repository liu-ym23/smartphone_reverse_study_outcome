package kotlin.reflect.jvm.internal.impl.load.java;

import C9.j;
import E9.InterfaceC0797b;
import E9.InterfaceC0803h;
import E9.O;
import S9.C1008g;
import S9.C1011j;
import S9.L;
import S9.M;
import S9.N;
import ga.e;
import ka.C4828h;
import kotlin.jvm.internal.p;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.f;
import kotlin.reflect.jvm.internal.impl.descriptors.g;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import ya.AbstractC5990d0;
import za.C6472r;

/* loaded from: classes5.dex */
public final class d {
    public static final boolean d(CallableMemberDescriptor callableMemberDescriptor) {
        p.i(callableMemberDescriptor, "<this>");
        return g(callableMemberDescriptor) != null;
    }

    public static final String e(CallableMemberDescriptor callableMemberDescriptor) {
        CallableMemberDescriptor callableMemberDescriptorW;
        e eVarJ;
        p.i(callableMemberDescriptor, "callableMemberDescriptor");
        CallableMemberDescriptor callableMemberDescriptorF = f(callableMemberDescriptor);
        if (callableMemberDescriptorF != null && (callableMemberDescriptorW = DescriptorUtilsKt.w(callableMemberDescriptorF)) != null) {
            if (callableMemberDescriptorW instanceof O) {
                return C1011j.f5756a.b(callableMemberDescriptorW);
            }
            if ((callableMemberDescriptorW instanceof g) && (eVarJ = a.f35117o.j((g) callableMemberDescriptorW)) != null) {
                return eVarJ.b();
            }
        }
        return null;
    }

    public static final CallableMemberDescriptor f(CallableMemberDescriptor callableMemberDescriptor) {
        if (j.h0(callableMemberDescriptor)) {
            return g(callableMemberDescriptor);
        }
        return null;
    }

    public static final <T extends CallableMemberDescriptor> T g(T t10) {
        p.i(t10, "<this>");
        if (!SpecialGenericSignatures.f35098a.g().contains(t10.getName()) && !C1008g.f5749a.d().contains(DescriptorUtilsKt.w(t10).getName())) {
            return null;
        }
        if ((t10 instanceof O) || (t10 instanceof f)) {
            return (T) DescriptorUtilsKt.i(t10, false, L.f5738a, 1, null);
        }
        if (t10 instanceof g) {
            return (T) DescriptorUtilsKt.i(t10, false, M.f5739a, 1, null);
        }
        return null;
    }

    public static final boolean h(CallableMemberDescriptor it) {
        p.i(it, "it");
        return C1011j.f5756a.d(DescriptorUtilsKt.w(it));
    }

    public static final boolean i(CallableMemberDescriptor it) {
        p.i(it, "it");
        return a.f35117o.k((g) it);
    }

    public static final <T extends CallableMemberDescriptor> T j(T t10) {
        p.i(t10, "<this>");
        T t11 = (T) g(t10);
        if (t11 != null) {
            return t11;
        }
        b bVar = b.f35118o;
        e name = t10.getName();
        p.h(name, "getName(...)");
        if (bVar.n(name)) {
            return (T) DescriptorUtilsKt.i(t10, false, N.f5740a, 1, null);
        }
        return null;
    }

    public static final boolean k(CallableMemberDescriptor it) {
        p.i(it, "it");
        return j.h0(it) && b.o(it) != null;
    }

    public static final boolean l(InterfaceC0797b interfaceC0797b, kotlin.reflect.jvm.internal.impl.descriptors.a specialCallableDescriptor) {
        p.i(interfaceC0797b, "<this>");
        p.i(specialCallableDescriptor, "specialCallableDescriptor");
        InterfaceC0803h interfaceC0803hB = specialCallableDescriptor.b();
        p.g(interfaceC0803hB, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
        AbstractC5990d0 abstractC5990d0N = ((InterfaceC0797b) interfaceC0803hB).n();
        p.h(abstractC5990d0N, "getDefaultType(...)");
        for (InterfaceC0797b interfaceC0797bS = C4828h.s(interfaceC0797b); interfaceC0797bS != null; interfaceC0797bS = C4828h.s(interfaceC0797bS)) {
            if (!(interfaceC0797bS instanceof U9.c) && C6472r.b(interfaceC0797bS.n(), abstractC5990d0N) != null) {
                return !j.h0(interfaceC0797bS);
            }
        }
        return false;
    }

    public static final boolean m(CallableMemberDescriptor callableMemberDescriptor) {
        p.i(callableMemberDescriptor, "<this>");
        return DescriptorUtilsKt.w(callableMemberDescriptor).b() instanceof U9.c;
    }

    public static final boolean n(CallableMemberDescriptor callableMemberDescriptor) {
        p.i(callableMemberDescriptor, "<this>");
        return m(callableMemberDescriptor) || j.h0(callableMemberDescriptor);
    }
}
