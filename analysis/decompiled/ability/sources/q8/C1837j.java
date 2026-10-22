package q8;

import h8.InterfaceC1501I;
import h8.InterfaceC1519b;
import h8.InterfaceC1522e;
import kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition$Contract;
import kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition$Result;

/* renamed from: q8.j, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1837j implements J8.f {
    @Override // J8.f
    public final ExternalOverridabilityCondition$Result a(InterfaceC1519b superDescriptor, InterfaceC1519b subDescriptor, InterfaceC1522e interfaceC1522e) {
        kotlin.jvm.internal.k.f(superDescriptor, "superDescriptor");
        kotlin.jvm.internal.k.f(subDescriptor, "subDescriptor");
        boolean z10 = subDescriptor instanceof InterfaceC1501I;
        ExternalOverridabilityCondition$Result externalOverridabilityCondition$Result = ExternalOverridabilityCondition$Result.c;
        if (!z10 || !(superDescriptor instanceof InterfaceC1501I)) {
            return externalOverridabilityCondition$Result;
        }
        InterfaceC1501I interfaceC1501I = (InterfaceC1501I) subDescriptor;
        InterfaceC1501I interfaceC1501I2 = (InterfaceC1501I) superDescriptor;
        return !kotlin.jvm.internal.k.b(interfaceC1501I.getName(), interfaceC1501I2.getName()) ? externalOverridabilityCondition$Result : (z2.l.B(interfaceC1501I) && z2.l.B(interfaceC1501I2)) ? ExternalOverridabilityCondition$Result.f5115a : (z2.l.B(interfaceC1501I) || z2.l.B(interfaceC1501I2)) ? ExternalOverridabilityCondition$Result.b : externalOverridabilityCondition$Result;
    }

    @Override // J8.f
    public final ExternalOverridabilityCondition$Contract b() {
        return ExternalOverridabilityCondition$Contract.c;
    }
}
