package q8;

import h8.InterfaceC1519b;
import h8.InterfaceC1522e;
import i9.C1570e;
import java.util.List;
import k8.K;
import kotlin.collections.EmptyList;
import kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition$Contract;
import kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition$Result;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil$OverrideCompatibilityInfo$Result;
import v8.C2069e;
import v8.C2071g;

/* renamed from: q8.h, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1835h implements J8.f {
    @Override // J8.f
    public final ExternalOverridabilityCondition$Result a(InterfaceC1519b superDescriptor, InterfaceC1519b subDescriptor, InterfaceC1522e interfaceC1522e) {
        kotlin.jvm.internal.k.f(superDescriptor, "superDescriptor");
        kotlin.jvm.internal.k.f(subDescriptor, "subDescriptor");
        if (subDescriptor instanceof kotlin.reflect.jvm.internal.impl.load.java.descriptors.a) {
            kotlin.reflect.jvm.internal.impl.load.java.descriptors.a aVar = (kotlin.reflect.jvm.internal.impl.load.java.descriptors.a) subDescriptor;
            if (aVar.getTypeParameters().isEmpty()) {
                J8.j jVarI = J8.k.i(superDescriptor, subDescriptor);
                if ((jVarI != null ? jVarI.b() : null) == null) {
                    List listX = aVar.x();
                    kotlin.jvm.internal.k.e(listX, "getValueParameters(...)");
                    i9.o oVarM0 = kotlin.sequences.a.m0(D7.v.s0(listX), C1830c.e);
                    X8.w wVar = aVar.g;
                    kotlin.jvm.internal.k.c(wVar);
                    i9.g gVarI0 = kotlin.sequences.a.i0(D7.q.M(new i9.i[]{oVarM0, new D7.t(wVar, 5)}));
                    k8.u uVar = aVar.i;
                    List elements = H4.o.O(uVar != null ? uVar.getType() : null);
                    kotlin.jvm.internal.k.f(elements, "elements");
                    C1570e c1570e = new C1570e(kotlin.sequences.a.i0(D7.q.M(new i9.i[]{gVarI0, D7.v.s0(elements)})));
                    while (true) {
                        if (c1570e.hasNext()) {
                            X8.w wVar2 = (X8.w) c1570e.next();
                            if (!wVar2.L().isEmpty() && !(wVar2.Z() instanceof C2071g)) {
                                break;
                            }
                        } else {
                            InterfaceC1519b interfaceC1519bBuild = (InterfaceC1519b) superDescriptor.b(new kotlin.reflect.jvm.internal.impl.types.a(new C2069e()));
                            if (interfaceC1519bBuild != null) {
                                if (interfaceC1519bBuild instanceof K) {
                                    K k = (K) interfaceC1519bBuild;
                                    if (!k.getTypeParameters().isEmpty()) {
                                        interfaceC1519bBuild = k.x0().w(EmptyList.f4893a).build();
                                        kotlin.jvm.internal.k.c(interfaceC1519bBuild);
                                    }
                                }
                                OverridingUtil$OverrideCompatibilityInfo$Result overridingUtil$OverrideCompatibilityInfo$ResultB = J8.k.c.n(interfaceC1519bBuild, subDescriptor, false).b();
                                kotlin.jvm.internal.k.e(overridingUtil$OverrideCompatibilityInfo$ResultB, "getResult(...)");
                                if (AbstractC1834g.f5600a[overridingUtil$OverrideCompatibilityInfo$ResultB.ordinal()] == 1) {
                                    return ExternalOverridabilityCondition$Result.f5115a;
                                }
                            }
                        }
                    }
                }
            }
        }
        return ExternalOverridabilityCondition$Result.c;
    }

    @Override // J8.f
    public final ExternalOverridabilityCondition$Contract b() {
        return ExternalOverridabilityCondition$Contract.b;
    }
}
