package S9;

import java.util.Collection;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;

/* renamed from: S9.j, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C1011j {

    /* renamed from: a, reason: collision with root package name */
    public static final C1011j f5756a = new C1011j();

    public static final boolean c(CallableMemberDescriptor it) {
        kotlin.jvm.internal.p.i(it, "it");
        return f5756a.d(it);
    }

    public final String b(CallableMemberDescriptor callableMemberDescriptor) {
        ga.e eVar;
        kotlin.jvm.internal.p.i(callableMemberDescriptor, "<this>");
        C9.j.h0(callableMemberDescriptor);
        CallableMemberDescriptor callableMemberDescriptorI = DescriptorUtilsKt.i(DescriptorUtilsKt.w(callableMemberDescriptor), false, C1010i.f5755a, 1, null);
        if (callableMemberDescriptorI == null || (eVar = C1008g.f5749a.a().get(DescriptorUtilsKt.o(callableMemberDescriptorI))) == null) {
            return null;
        }
        return eVar.b();
    }

    public final boolean d(CallableMemberDescriptor callableMemberDescriptor) {
        kotlin.jvm.internal.p.i(callableMemberDescriptor, "callableMemberDescriptor");
        if (C1008g.f5749a.d().contains(callableMemberDescriptor.getName())) {
            return e(callableMemberDescriptor);
        }
        return false;
    }

    public final boolean e(CallableMemberDescriptor callableMemberDescriptor) {
        if (Z8.F.f0(C1008g.f5749a.c(), DescriptorUtilsKt.k(callableMemberDescriptor)) && callableMemberDescriptor.i().isEmpty()) {
            return true;
        }
        if (!C9.j.h0(callableMemberDescriptor)) {
            return false;
        }
        Collection<? extends CallableMemberDescriptor> collectionD = callableMemberDescriptor.d();
        kotlin.jvm.internal.p.h(collectionD, "getOverriddenDescriptors(...)");
        Collection<? extends CallableMemberDescriptor> collection = collectionD;
        if (collection.isEmpty()) {
            return false;
        }
        for (CallableMemberDescriptor callableMemberDescriptor2 : collection) {
            C1011j c1011j = f5756a;
            kotlin.jvm.internal.p.f(callableMemberDescriptor2);
            if (c1011j.d(callableMemberDescriptor2)) {
                return true;
            }
        }
        return false;
    }
}
