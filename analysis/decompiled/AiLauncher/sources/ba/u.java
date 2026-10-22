package ba;

import C9.o;
import E9.InterfaceC0797b;
import E9.InterfaceC0803h;
import E9.i0;
import Z8.F;
import androidx.exifinterface.media.ExifInterface;
import ba.m;
import java.util.Iterator;
import java.util.List;
import ka.C4828h;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;
import pa.C5080d;
import ya.S;

/* loaded from: classes5.dex */
public final class u {
    public static final void a(StringBuilder sb2, S s10) {
        sb2.append(g(s10));
    }

    public static final String b(kotlin.reflect.jvm.internal.impl.descriptors.e eVar, boolean z10, boolean z11) {
        String strB;
        kotlin.jvm.internal.p.i(eVar, "<this>");
        StringBuilder sb2 = new StringBuilder();
        if (z11) {
            if (eVar instanceof kotlin.reflect.jvm.internal.impl.descriptors.c) {
                strB = "<init>";
            } else {
                strB = eVar.getName().b();
                kotlin.jvm.internal.p.h(strB, "asString(...)");
            }
            sb2.append(strB);
        }
        sb2.append("(");
        E9.S sK = eVar.K();
        if (sK != null) {
            S type = sK.getType();
            kotlin.jvm.internal.p.h(type, "getType(...)");
            a(sb2, type);
        }
        Iterator<i0> it = eVar.i().iterator();
        while (it.hasNext()) {
            S type2 = it.next().getType();
            kotlin.jvm.internal.p.h(type2, "getType(...)");
            a(sb2, type2);
        }
        sb2.append(")");
        if (z10) {
            if (e.c(eVar)) {
                sb2.append(ExifInterface.GPS_MEASUREMENT_INTERRUPTED);
            } else {
                S returnType = eVar.getReturnType();
                kotlin.jvm.internal.p.f(returnType);
                a(sb2, returnType);
            }
        }
        return sb2.toString();
    }

    public static /* synthetic */ String c(kotlin.reflect.jvm.internal.impl.descriptors.e eVar, boolean z10, boolean z11, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = true;
        }
        if ((i10 & 2) != 0) {
            z11 = true;
        }
        return b(eVar, z10, z11);
    }

    public static final String d(kotlin.reflect.jvm.internal.impl.descriptors.a aVar) {
        kotlin.jvm.internal.p.i(aVar, "<this>");
        x xVar = x.f15368a;
        if (C4828h.E(aVar)) {
            return null;
        }
        InterfaceC0803h interfaceC0803hB = aVar.b();
        InterfaceC0797b interfaceC0797b = interfaceC0803hB instanceof InterfaceC0797b ? (InterfaceC0797b) interfaceC0803hB : null;
        if (interfaceC0797b == null || interfaceC0797b.getName().k()) {
            return null;
        }
        kotlin.reflect.jvm.internal.impl.descriptors.a aVarA = aVar.a();
        kotlin.reflect.jvm.internal.impl.descriptors.g gVar = aVarA instanceof kotlin.reflect.jvm.internal.impl.descriptors.g ? (kotlin.reflect.jvm.internal.impl.descriptors.g) aVarA : null;
        if (gVar == null) {
            return null;
        }
        return t.a(xVar, interfaceC0797b, c(gVar, false, false, 3, null));
    }

    public static final boolean e(kotlin.reflect.jvm.internal.impl.descriptors.a f10) {
        kotlin.reflect.jvm.internal.impl.descriptors.e eVarL;
        kotlin.jvm.internal.p.i(f10, "f");
        if (!(f10 instanceof kotlin.reflect.jvm.internal.impl.descriptors.e)) {
            return false;
        }
        kotlin.reflect.jvm.internal.impl.descriptors.e eVar = (kotlin.reflect.jvm.internal.impl.descriptors.e) f10;
        if (kotlin.jvm.internal.p.d(eVar.getName().b(), "remove") && eVar.i().size() == 1 && !kotlin.reflect.jvm.internal.impl.load.java.d.n((CallableMemberDescriptor) f10)) {
            List<i0> listI = eVar.a().i();
            kotlin.jvm.internal.p.h(listI, "getValueParameters(...)");
            S type = ((i0) F.X0(listI)).getType();
            kotlin.jvm.internal.p.h(type, "getType(...)");
            m mVarG = g(type);
            m.d dVar = mVarG instanceof m.d ? (m.d) mVarG : null;
            if ((dVar != null ? dVar.i() : null) != JvmPrimitiveType.INT || (eVarL = kotlin.reflect.jvm.internal.impl.load.java.b.l(eVar)) == null) {
                return false;
            }
            List<i0> listI2 = eVarL.a().i();
            kotlin.jvm.internal.p.h(listI2, "getValueParameters(...)");
            S type2 = ((i0) F.X0(listI2)).getType();
            kotlin.jvm.internal.p.h(type2, "getType(...)");
            m mVarG2 = g(type2);
            InterfaceC0803h interfaceC0803hB = eVarL.b();
            kotlin.jvm.internal.p.h(interfaceC0803hB, "getContainingDeclaration(...)");
            if (kotlin.jvm.internal.p.d(DescriptorUtilsKt.p(interfaceC0803hB), o.a.f1905f0.i()) && (mVarG2 instanceof m.c) && kotlin.jvm.internal.p.d(((m.c) mVarG2).i(), "java/lang/Object")) {
                return true;
            }
        }
        return false;
    }

    public static final String f(InterfaceC0797b interfaceC0797b) {
        kotlin.jvm.internal.p.i(interfaceC0797b, "<this>");
        ga.b bVarN = D9.a.f2270a.n(DescriptorUtilsKt.o(interfaceC0797b).i());
        if (bVarN == null) {
            return e.b(interfaceC0797b, null, 2, null);
        }
        String strH = C5080d.h(bVarN);
        kotlin.jvm.internal.p.h(strH, "internalNameByClassId(...)");
        return strH;
    }

    public static final m g(S s10) {
        kotlin.jvm.internal.p.i(s10, "<this>");
        return (m) e.e(s10, o.f15356a, C1463A.f15304q, z.f15369a, null, null, 32, null);
    }
}
