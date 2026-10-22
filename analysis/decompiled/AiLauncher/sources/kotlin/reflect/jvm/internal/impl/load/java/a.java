package kotlin.reflect.jvm.internal.impl.load.java;

import C9.j;
import S9.C1005d;
import ba.u;
import ga.e;
import java.util.Map;
import kotlin.jvm.internal.p;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.g;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;

/* loaded from: classes5.dex */
public final class a extends SpecialGenericSignatures {

    /* renamed from: o, reason: collision with root package name */
    public static final a f35117o = new a();

    public static final boolean l(g gVar, CallableMemberDescriptor it) {
        p.i(it, "it");
        return SpecialGenericSignatures.f35098a.j().containsKey(u.d(gVar));
    }

    public final e j(g functionDescriptor) {
        p.i(functionDescriptor, "functionDescriptor");
        Map<String, e> mapJ = SpecialGenericSignatures.f35098a.j();
        String strD = u.d(functionDescriptor);
        if (strD == null) {
            return null;
        }
        return mapJ.get(strD);
    }

    public final boolean k(g functionDescriptor) {
        p.i(functionDescriptor, "functionDescriptor");
        return j.h0(functionDescriptor) && DescriptorUtilsKt.i(functionDescriptor, false, new C1005d(functionDescriptor), 1, null) != null;
    }

    public final boolean m(g gVar) {
        p.i(gVar, "<this>");
        return p.d(gVar.getName().b(), "removeAt") && p.d(u.d(gVar), SpecialGenericSignatures.f35098a.h().d());
    }
}
