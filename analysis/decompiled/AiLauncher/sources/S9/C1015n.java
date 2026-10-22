package S9;

import E9.InterfaceC0797b;
import E9.b0;
import E9.i0;
import Z8.C1173v;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaMethodDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil;
import kotlin.sequences.SequencesKt___SequencesKt;
import ya.A0;
import ya.S;

/* renamed from: S9.n, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C1015n implements ExternalOverridabilityCondition {

    /* renamed from: S9.n$a */
    public static final /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f5759a;

        static {
            int[] iArr = new int[OverridingUtil.OverrideCompatibilityInfo.Result.values().length];
            try {
                iArr[OverridingUtil.OverrideCompatibilityInfo.Result.OVERRIDABLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            f5759a = iArr;
        }
    }

    public static final S d(i0 i0Var) {
        return i0Var.getType();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition
    public ExternalOverridabilityCondition.Contract a() {
        return ExternalOverridabilityCondition.Contract.SUCCESS_ONLY;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition
    public ExternalOverridabilityCondition.Result b(kotlin.reflect.jvm.internal.impl.descriptors.a superDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.a subDescriptor, InterfaceC0797b interfaceC0797b) {
        kotlin.jvm.internal.p.i(superDescriptor, "superDescriptor");
        kotlin.jvm.internal.p.i(subDescriptor, "subDescriptor");
        if (subDescriptor instanceof JavaMethodDescriptor) {
            JavaMethodDescriptor javaMethodDescriptor = (JavaMethodDescriptor) subDescriptor;
            List<b0> typeParameters = javaMethodDescriptor.getTypeParameters();
            kotlin.jvm.internal.p.h(typeParameters, "getTypeParameters(...)");
            if (typeParameters.isEmpty()) {
                OverridingUtil.OverrideCompatibilityInfo overrideCompatibilityInfoW = OverridingUtil.w(superDescriptor, subDescriptor);
                A0 a02 = null;
                Object[] objArr = 0;
                if ((overrideCompatibilityInfoW != null ? overrideCompatibilityInfoW.c() : null) != null) {
                    return ExternalOverridabilityCondition.Result.UNKNOWN;
                }
                List<i0> listI = javaMethodDescriptor.i();
                kotlin.jvm.internal.p.h(listI, "getValueParameters(...)");
                Ka.j jVarR = SequencesKt___SequencesKt.R(Z8.F.d0(listI), C1014m.f5758a);
                S returnType = javaMethodDescriptor.getReturnType();
                kotlin.jvm.internal.p.f(returnType);
                Ka.j jVarX = SequencesKt___SequencesKt.X(jVarR, returnType);
                E9.S sK = javaMethodDescriptor.K();
                for (S s10 : SequencesKt___SequencesKt.W(jVarX, C1173v.q(sK != null ? sK.getType() : null))) {
                    if (!s10.F0().isEmpty() && !(s10.K0() instanceof X9.j)) {
                        return ExternalOverridabilityCondition.Result.UNKNOWN;
                    }
                }
                kotlin.reflect.jvm.internal.impl.descriptors.a aVarC = superDescriptor.c(new X9.h(a02, 1, objArr == true ? 1 : 0).c());
                if (aVarC == null) {
                    return ExternalOverridabilityCondition.Result.UNKNOWN;
                }
                if (aVarC instanceof kotlin.reflect.jvm.internal.impl.descriptors.g) {
                    kotlin.reflect.jvm.internal.impl.descriptors.g gVar = (kotlin.reflect.jvm.internal.impl.descriptors.g) aVarC;
                    List<b0> typeParameters2 = gVar.getTypeParameters();
                    kotlin.jvm.internal.p.h(typeParameters2, "getTypeParameters(...)");
                    if (!typeParameters2.isEmpty()) {
                        aVarC = gVar.s().p(C1173v.m()).build();
                        kotlin.jvm.internal.p.f(aVarC);
                    }
                }
                OverridingUtil.OverrideCompatibilityInfo.Result resultC = OverridingUtil.f35978f.F(aVarC, subDescriptor, false).c();
                kotlin.jvm.internal.p.h(resultC, "getResult(...)");
                return a.f5759a[resultC.ordinal()] == 1 ? ExternalOverridabilityCondition.Result.OVERRIDABLE : ExternalOverridabilityCondition.Result.UNKNOWN;
            }
        }
        return ExternalOverridabilityCondition.Result.UNKNOWN;
    }
}
