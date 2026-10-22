package kotlin.reflect.jvm.internal.impl.load.java;

import C9.j;
import E9.InterfaceC0797b;
import E9.InterfaceC0799d;
import E9.InterfaceC0803h;
import E9.i0;
import Z8.F;
import ba.m;
import ba.u;
import java.util.List;
import kotlin.Pair;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.e;
import kotlin.reflect.jvm.internal.impl.load.java.SpecialGenericSignatures;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaMethodDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import ya.S;

/* loaded from: classes5.dex */
public final class c implements ExternalOverridabilityCondition {

    /* renamed from: a, reason: collision with root package name */
    public static final a f35119a = new a(null);

    public static final class a {
        public /* synthetic */ a(i iVar) {
            this();
        }

        public final boolean a(kotlin.reflect.jvm.internal.impl.descriptors.a superDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.a subDescriptor) {
            p.i(superDescriptor, "superDescriptor");
            p.i(subDescriptor, "subDescriptor");
            if ((subDescriptor instanceof JavaMethodDescriptor) && (superDescriptor instanceof e)) {
                JavaMethodDescriptor javaMethodDescriptor = (JavaMethodDescriptor) subDescriptor;
                javaMethodDescriptor.i().size();
                e eVar = (e) superDescriptor;
                eVar.i().size();
                List<i0> listI = javaMethodDescriptor.a().i();
                p.h(listI, "getValueParameters(...)");
                List<i0> listI2 = eVar.a().i();
                p.h(listI2, "getValueParameters(...)");
                for (Pair pair : F.w1(listI, listI2)) {
                    i0 i0Var = (i0) pair.a();
                    i0 i0Var2 = (i0) pair.b();
                    p.f(i0Var);
                    boolean z10 = c((e) subDescriptor, i0Var) instanceof m.d;
                    p.f(i0Var2);
                    if (z10 != (c(eVar, i0Var2) instanceof m.d)) {
                        return true;
                    }
                }
            }
            return false;
        }

        public final boolean b(e eVar) {
            if (eVar.i().size() != 1) {
                return false;
            }
            InterfaceC0803h interfaceC0803hB = eVar.b();
            InterfaceC0797b interfaceC0797b = interfaceC0803hB instanceof InterfaceC0797b ? (InterfaceC0797b) interfaceC0803hB : null;
            if (interfaceC0797b == null) {
                return false;
            }
            List<i0> listI = eVar.i();
            p.h(listI, "getValueParameters(...)");
            InterfaceC0799d interfaceC0799dD = ((i0) F.X0(listI)).getType().H0().d();
            InterfaceC0797b interfaceC0797b2 = interfaceC0799dD instanceof InterfaceC0797b ? (InterfaceC0797b) interfaceC0799dD : null;
            return interfaceC0797b2 != null && j.s0(interfaceC0797b) && p.d(DescriptorUtilsKt.o(interfaceC0797b), DescriptorUtilsKt.o(interfaceC0797b2));
        }

        public final m c(e eVar, i0 i0Var) {
            if (u.e(eVar) || b(eVar)) {
                S type = i0Var.getType();
                p.h(type, "getType(...)");
                return u.g(Da.d.B(type));
            }
            S type2 = i0Var.getType();
            p.h(type2, "getType(...)");
            return u.g(type2);
        }

        public a() {
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition
    public ExternalOverridabilityCondition.Contract a() {
        return ExternalOverridabilityCondition.Contract.CONFLICTS_ONLY;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition
    public ExternalOverridabilityCondition.Result b(kotlin.reflect.jvm.internal.impl.descriptors.a superDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.a subDescriptor, InterfaceC0797b interfaceC0797b) {
        p.i(superDescriptor, "superDescriptor");
        p.i(subDescriptor, "subDescriptor");
        if (!c(superDescriptor, subDescriptor, interfaceC0797b) && !f35119a.a(superDescriptor, subDescriptor)) {
            return ExternalOverridabilityCondition.Result.UNKNOWN;
        }
        return ExternalOverridabilityCondition.Result.INCOMPATIBLE;
    }

    public final boolean c(kotlin.reflect.jvm.internal.impl.descriptors.a aVar, kotlin.reflect.jvm.internal.impl.descriptors.a aVar2, InterfaceC0797b interfaceC0797b) {
        if ((aVar instanceof CallableMemberDescriptor) && (aVar2 instanceof e) && !j.h0(aVar2)) {
            b bVar = b.f35118o;
            e eVar = (e) aVar2;
            ga.e name = eVar.getName();
            p.h(name, "getName(...)");
            if (!bVar.n(name)) {
                SpecialGenericSignatures.a aVar3 = SpecialGenericSignatures.f35098a;
                ga.e name2 = eVar.getName();
                p.h(name2, "getName(...)");
                if (!aVar3.k(name2)) {
                    return false;
                }
            }
            CallableMemberDescriptor callableMemberDescriptorJ = d.j((CallableMemberDescriptor) aVar);
            boolean z10 = aVar instanceof e;
            e eVar2 = z10 ? (e) aVar : null;
            if (!(eVar2 != null && eVar.w0() == eVar2.w0()) && (callableMemberDescriptorJ == null || !eVar.w0())) {
                return true;
            }
            if ((interfaceC0797b instanceof U9.c) && eVar.m0() == null && callableMemberDescriptorJ != null && !d.l(interfaceC0797b, callableMemberDescriptorJ)) {
                if ((callableMemberDescriptorJ instanceof e) && z10 && b.l((e) callableMemberDescriptorJ) != null) {
                    String strC = u.c(eVar, false, false, 2, null);
                    e eVarA = ((e) aVar).a();
                    p.h(eVarA, "getOriginal(...)");
                    if (p.d(strC, u.c(eVarA, false, false, 2, null))) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }
}
