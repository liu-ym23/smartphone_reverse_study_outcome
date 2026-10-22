package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaMethodDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.RawSubstitution;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.RawTypeImpl;
import kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

/* JADX INFO: compiled from: ErasedOverridabilityCondition.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class ErasedOverridabilityCondition implements ExternalOverridabilityCondition {

    /* JADX INFO: compiled from: ErasedOverridabilityCondition.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r0 = new int[OverridingUtil.OverrideCompatibilityInfo.Result.values().length];
            r0[OverridingUtil.OverrideCompatibilityInfo.Result.OVERRIDABLE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L4:
            $EnumSwitchMapping$0 = r0;
        }
    }

    public ErasedOverridabilityCondition() {
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition
    public ExternalOverridabilityCondition.Result isOverridable(CallableDescriptor r5, CallableDescriptor r6, ClassDescriptor r7) {
        Intrinsics.checkNotNullParameter(r5, "superDescriptor");
        Intrinsics.checkNotNullParameter(r6, "subDescriptor");
        if ((r6 instanceof JavaMethodDescriptor) == false) goto L48;
        JavaMethodDescriptor r4 = (JavaMethodDescriptor) r6;
        List<TypeParameterDescriptor> r8 = r4.getTypeParameters();
        Intrinsics.checkNotNullExpressionValue(r8, "subDescriptor.typeParameters");
        if ((!r8.isEmpty()) == true) goto L48;
        OverridingUtil.OverrideCompatibilityInfo r9 = OverridingUtil.getBasicOverridabilityProblem(r5, r6);
        if (r9 == null) goto L10;
        OverridingUtil.OverrideCompatibilityInfo.Result r10 = r9.getResult();
    L11:
        if (r10 != null) goto L13;
        List<ValueParameterDescriptor> r11 = r4.getValueParameters();
        Intrinsics.checkNotNullExpressionValue(r11, "subDescriptor.valueParameters");
        Sequence r12 = SequencesKt.map(CollectionsKt.asSequence(r11), ErasedOverridabilityCondition$isOverridable$signatureTypes$1.INSTANCE);
        KotlinType r2 = r4.getReturnType();
        Intrinsics.checkNotNull(r2);
        Sequence r13 = SequencesKt.plus(r12, r2);
        ReceiverParameterDescriptor r14 = r4.getExtensionReceiverParameter();
        if (r14 == null) goto L17;
        KotlinType r15 = r14.getType();
    L18:
        Iterator r16 = SequencesKt.plus(r13, CollectionsKt.listOfNotNull(r15)).iterator();
    L20:
        if (r16.hasNext() == false) goto L29;
        KotlinType r17 = (KotlinType) r16.next();
        if ((!r17.getArguments().isEmpty()) == true) goto L24;
    L26:
        boolean r18 = false;
    L27:
        if (r18 == false) goto L20;
        boolean r19 = true;
    L30:
        if (r19 == true) goto L32;
        FunctionDescriptor r20 = r5.substitute(new RawSubstitution(null, 1, null).buildSubstitutor());
        if (r20 != null) goto L38;
        return ExternalOverridabilityCondition.Result.UNKNOWN;
    L38:
        if ((r20 instanceof SimpleFunctionDescriptor) == false) goto L42;
        SimpleFunctionDescriptor r21 = (SimpleFunctionDescriptor) r20;
        List<TypeParameterDescriptor> r22 = r21.getTypeParameters();
        Intrinsics.checkNotNullExpressionValue(r22, "erasedSuper.typeParameters");
        if ((!r22.isEmpty()) == false) goto L42;
        FunctionDescriptor r23 = r21.newCopyBuilder().setTypeParameters(CollectionsKt.emptyList()).build();
        Intrinsics.checkNotNull(r23);
        r20 = r23;
    L42:
        OverridingUtil.OverrideCompatibilityInfo.Result r24 = OverridingUtil.DEFAULT.isOverridableByWithoutExternalConditions(r20, r6, false).getResult();
        Intrinsics.checkNotNullExpressionValue(r24, "DEFAULT.isOverridableByW…Descriptor, false).result");
        if (WhenMappings.$EnumSwitchMapping$0[r24.ordinal()] != 1) goto L46;
        return ExternalOverridabilityCondition.Result.OVERRIDABLE;
    L46:
        return ExternalOverridabilityCondition.Result.UNKNOWN;
    L32:
        return ExternalOverridabilityCondition.Result.UNKNOWN;
    L24:
        if ((r17.unwrap() instanceof RawTypeImpl) == true) goto L26;
        r18 = true;
        goto L27
    L29:
        r19 = false;
        goto L30
    L17:
        r15 = null;
        goto L18
    L13:
        return ExternalOverridabilityCondition.Result.UNKNOWN;
    L10:
        r10 = null;
    L48:
        return ExternalOverridabilityCondition.Result.UNKNOWN;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition
    public ExternalOverridabilityCondition.Contract getContract() {
        return ExternalOverridabilityCondition.Contract.SUCCESS_ONLY;
    }
}
