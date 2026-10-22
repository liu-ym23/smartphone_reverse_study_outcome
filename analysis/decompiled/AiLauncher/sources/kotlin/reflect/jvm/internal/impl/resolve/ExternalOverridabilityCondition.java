package kotlin.reflect.jvm.internal.impl.resolve;

import E9.InterfaceC0797b;

/* loaded from: classes5.dex */
public interface ExternalOverridabilityCondition {

    public enum Contract {
        CONFLICTS_ONLY,
        SUCCESS_ONLY,
        BOTH
    }

    public enum Result {
        OVERRIDABLE,
        INCOMPATIBLE,
        UNKNOWN
    }

    Contract a();

    Result b(kotlin.reflect.jvm.internal.impl.descriptors.a aVar, kotlin.reflect.jvm.internal.impl.descriptors.a aVar2, InterfaceC0797b interfaceC0797b);
}
