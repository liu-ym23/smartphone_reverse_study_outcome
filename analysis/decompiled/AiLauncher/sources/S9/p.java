package S9;

import E9.InterfaceC0797b;
import W9.C1095d;
import kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition;

/* loaded from: classes5.dex */
public final class p implements ExternalOverridabilityCondition {
    @Override // kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition
    public ExternalOverridabilityCondition.Contract a() {
        return ExternalOverridabilityCondition.Contract.BOTH;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition
    public ExternalOverridabilityCondition.Result b(kotlin.reflect.jvm.internal.impl.descriptors.a superDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.a subDescriptor, InterfaceC0797b interfaceC0797b) {
        kotlin.jvm.internal.p.i(superDescriptor, "superDescriptor");
        kotlin.jvm.internal.p.i(subDescriptor, "subDescriptor");
        if (!(subDescriptor instanceof E9.O) || !(superDescriptor instanceof E9.O)) {
            return ExternalOverridabilityCondition.Result.UNKNOWN;
        }
        E9.O o10 = (E9.O) subDescriptor;
        E9.O o11 = (E9.O) superDescriptor;
        return !kotlin.jvm.internal.p.d(o10.getName(), o11.getName()) ? ExternalOverridabilityCondition.Result.UNKNOWN : (C1095d.a(o10) && C1095d.a(o11)) ? ExternalOverridabilityCondition.Result.OVERRIDABLE : (C1095d.a(o10) || C1095d.a(o11)) ? ExternalOverridabilityCondition.Result.INCOMPATIBLE : ExternalOverridabilityCondition.Result.UNKNOWN;
    }
}
