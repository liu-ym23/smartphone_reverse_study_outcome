package C9;

import E9.InterfaceC0797b;
import Z8.F;
import java.util.Set;
import ka.C4828h;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;

/* loaded from: classes5.dex */
public final class e {
    public static final boolean a(d dVar, InterfaceC0797b classDescriptor) {
        kotlin.jvm.internal.p.i(dVar, "<this>");
        kotlin.jvm.internal.p.i(classDescriptor, "classDescriptor");
        if (!C4828h.x(classDescriptor)) {
            return false;
        }
        Set<ga.b> setB = dVar.b();
        ga.b bVarN = DescriptorUtilsKt.n(classDescriptor);
        return F.f0(setB, bVarN != null ? bVarN.e() : null);
    }
}
