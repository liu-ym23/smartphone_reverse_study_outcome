package kotlin.reflect.jvm.internal.impl.load.java;

import S9.C1006e;
import S9.C1007f;
import Z8.F;
import ba.u;
import kotlin.jvm.internal.p;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.e;
import kotlin.reflect.jvm.internal.impl.load.java.SpecialGenericSignatures;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;

/* loaded from: classes5.dex */
public final class b extends SpecialGenericSignatures {

    /* renamed from: o, reason: collision with root package name */
    public static final b f35118o = new b();

    public static final e l(e functionDescriptor) {
        p.i(functionDescriptor, "functionDescriptor");
        b bVar = f35118o;
        ga.e name = functionDescriptor.getName();
        p.h(name, "getName(...)");
        if (bVar.n(name)) {
            return (e) DescriptorUtilsKt.i(functionDescriptor, false, C1006e.f5747a, 1, null);
        }
        return null;
    }

    public static final boolean m(CallableMemberDescriptor it) {
        p.i(it, "it");
        return f35118o.k(it);
    }

    public static final SpecialGenericSignatures.SpecialSignatureInfo o(CallableMemberDescriptor callableMemberDescriptor) {
        CallableMemberDescriptor callableMemberDescriptorI;
        String strD;
        p.i(callableMemberDescriptor, "<this>");
        SpecialGenericSignatures.a aVar = SpecialGenericSignatures.f35098a;
        if (!aVar.d().contains(callableMemberDescriptor.getName()) || (callableMemberDescriptorI = DescriptorUtilsKt.i(callableMemberDescriptor, false, C1007f.f5748a, 1, null)) == null || (strD = u.d(callableMemberDescriptorI)) == null) {
            return null;
        }
        return aVar.l(strD);
    }

    public static final boolean p(CallableMemberDescriptor it) {
        p.i(it, "it");
        return (it instanceof e) && f35118o.k(it);
    }

    public final boolean k(CallableMemberDescriptor callableMemberDescriptor) {
        return F.f0(SpecialGenericSignatures.f35098a.e(), u.d(callableMemberDescriptor));
    }

    public final boolean n(ga.e eVar) {
        p.i(eVar, "<this>");
        return SpecialGenericSignatures.f35098a.d().contains(eVar);
    }
}
