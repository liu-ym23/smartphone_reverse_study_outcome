package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaClassDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaMethodDescriptor;
import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType;
import kotlin.reflect.jvm.internal.impl.load.kotlin.MethodSignatureMappingKt;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;

/* JADX INFO: compiled from: JavaIncompatibilityRulesOverridabilityCondition.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class JavaIncompatibilityRulesOverridabilityCondition implements ExternalOverridabilityCondition {
    public static final Companion Companion = null;

    /* JADX INFO: compiled from: JavaIncompatibilityRulesOverridabilityCondition.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }

        public final boolean doesJavaOverrideHaveIncompatibleValueParameterKinds(CallableDescriptor r7, CallableDescriptor r8) {
            Intrinsics.checkNotNullParameter(r7, "superDescriptor");
            Intrinsics.checkNotNullParameter(r8, "subDescriptor");
            if ((r8 instanceof JavaMethodDescriptor) == true) goto L5;
        L14:
            return false;
        L5:
            if ((r7 instanceof FunctionDescriptor) == false) goto L14;
            JavaMethodDescriptor r0 = (JavaMethodDescriptor) r8;
            r0.getValueParameters().size();
            FunctionDescriptor r9 = (FunctionDescriptor) r7;
            r9.getValueParameters().size();
            List<ValueParameterDescriptor> r1 = r0.getOriginal().getValueParameters();
            Intrinsics.checkNotNullExpressionValue(r1, "subDescriptor.original.valueParameters");
            List<ValueParameterDescriptor> r2 = r9.getOriginal().getValueParameters();
            Intrinsics.checkNotNullExpressionValue(r2, "superDescriptor.original.valueParameters");
            Iterator r3 = CollectionsKt.zip(r1, r2).iterator();
        L9:
            if (r3.hasNext() == false) goto L14;
            Pair r4 = (Pair) r3.next();
            ValueParameterDescriptor r5 = (ValueParameterDescriptor) r4.component1();
            ValueParameterDescriptor r6 = (ValueParameterDescriptor) r4.component2();
            Intrinsics.checkNotNullExpressionValue(r5, "subParameter");
            boolean r10 = mapValueParameterType((FunctionDescriptor) r8, r5) instanceof JvmType.Primitive;
            Intrinsics.checkNotNullExpressionValue(r6, "superParameter");
            if (r10 == (mapValueParameterType(r9, r6) instanceof JvmType.Primitive)) goto L9;
            return true;
        }

        private final JvmType mapValueParameterType(FunctionDescriptor r3, ValueParameterDescriptor r4) {
            if (MethodSignatureMappingKt.forceSingleValueParameterBoxing(r3) == false) goto L5;
        L8:
            KotlinType r2 = r4.getType();
            Intrinsics.checkNotNullExpressionValue(r2, "valueParameterDescriptor.type");
            return MethodSignatureMappingKt.mapToJvmType(TypeUtilsKt.makeNullable(r2));
        L5:
            if (isPrimitiveCompareTo(r3) == true) goto L8;
            KotlinType r5 = r4.getType();
            Intrinsics.checkNotNullExpressionValue(r5, "valueParameterDescriptor.type");
            return MethodSignatureMappingKt.mapToJvmType(r5);
        }

        private final boolean isPrimitiveCompareTo(FunctionDescriptor r5) {
            if (r5.getValueParameters().size() == 1) goto L5;
            return false;
        L5:
            DeclarationDescriptor r4 = r5.getContainingDeclaration();
            ClassDescriptor r3 = null;
            if ((r4 instanceof ClassDescriptor) == false) goto L8;
            ClassDescriptor r6 = (ClassDescriptor) r4;
        L9:
            if (r6 != null) goto L11;
            return false;
        L11:
            List<ValueParameterDescriptor> r7 = r5.getValueParameters();
            Intrinsics.checkNotNullExpressionValue(r7, "f.valueParameters");
            ClassifierDescriptor r8 = ((ValueParameterDescriptor) CollectionsKt.single(r7)).getType().getConstructor().mo2083getDeclarationDescriptor();
            if ((r8 instanceof ClassDescriptor) == false) goto L14;
            r3 = (ClassDescriptor) r8;
        L14:
            if (r3 != null) goto L17;
            return false;
        L17:
            if (KotlinBuiltIns.isPrimitiveClass(r6) == true) goto L19;
            return false;
        L19:
            if (Intrinsics.areEqual(DescriptorUtilsKt.getFqNameSafe(r6), DescriptorUtilsKt.getFqNameSafe(r3)) == true) goto L21;
            return false;
        L21:
            return true;
        L8:
            r6 = null;
            goto L9
        }
    }

    static {
        Companion = new Companion(null);
    }

    public JavaIncompatibilityRulesOverridabilityCondition() {
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition
    public ExternalOverridabilityCondition.Result isOverridable(CallableDescriptor r2, CallableDescriptor r3, ClassDescriptor r4) {
        Intrinsics.checkNotNullParameter(r2, "superDescriptor");
        Intrinsics.checkNotNullParameter(r3, "subDescriptor");
        if (isIncompatibleInAccordanceWithBuiltInOverridabilityRules(r2, r3, r4) == false) goto L7;
        return ExternalOverridabilityCondition.Result.INCOMPATIBLE;
    L7:
        if (Companion.doesJavaOverrideHaveIncompatibleValueParameterKinds(r2, r3) == false) goto L11;
        return ExternalOverridabilityCondition.Result.INCOMPATIBLE;
    L11:
        return ExternalOverridabilityCondition.Result.UNKNOWN;
    }

    private final boolean isIncompatibleInAccordanceWithBuiltInOverridabilityRules(CallableDescriptor r7, CallableDescriptor r8, ClassDescriptor r9) {
        if ((r7 instanceof CallableMemberDescriptor) == true) goto L5;
    L48:
        return false;
    L5:
        if ((r8 instanceof FunctionDescriptor) == false) goto L48;
        if (KotlinBuiltIns.isBuiltIn(r8) == true) goto L48;
        BuiltinMethodsWithSpecialGenericSignature r6 = BuiltinMethodsWithSpecialGenericSignature.INSTANCE;
        FunctionDescriptor r10 = (FunctionDescriptor) r8;
        Name r1 = r10.getName();
        Intrinsics.checkNotNullExpressionValue(r1, "subDescriptor.name");
        if (r6.getSameAsBuiltinMethodWithErasedValueParameters(r1) == true) goto L14;
        SpecialGenericSignatures.Companion r11 = SpecialGenericSignatures.Companion;
        Name r2 = r10.getName();
        Intrinsics.checkNotNullExpressionValue(r2, "subDescriptor.name");
        if (r11.getSameAsRenamedInJvmBuiltin(r2) == true) goto L14;
        return false;
    L14:
        CallableMemberDescriptor r12 = SpecialBuiltinMembers.getOverriddenSpecialBuiltin((CallableMemberDescriptor) r7);
        boolean r3 = r7 instanceof FunctionDescriptor;
        if (r3 == false) goto L17;
        FunctionDescriptor r4 = (FunctionDescriptor) r7;
    L19:
        if (r4 != null) goto L21;
    L23:
        boolean r5 = false;
    L25:
        if ((!r5) == false) goto L31;
        if (r12 != null) goto L28;
    L29:
        return true;
    L28:
        if (r10.isHiddenToOvercomeSignatureClash() == false) goto L29;
    L31:
        if ((r9 instanceof JavaClassDescriptor) == false) goto L48;
        if (r10.getInitialSignatureDescriptor() != null) goto L48;
        if (r12 == null) goto L48;
        if (SpecialBuiltinMembers.hasRealKotlinSuperClassWithOverrideOf(r9, r12) == true) goto L48;
        if ((r12 instanceof FunctionDescriptor) == false) goto L47;
        if (r3 == false) goto L47;
        if (BuiltinMethodsWithSpecialGenericSignature.getOverriddenBuiltinFunctionWithErasedValueParametersInJava((FunctionDescriptor) r12) == null) goto L47;
        String r13 = MethodSignatureMappingKt.computeJvmDescriptor$default(r10, false, false, 2, null);
        FunctionDescriptor r14 = ((FunctionDescriptor) r7).getOriginal();
        Intrinsics.checkNotNullExpressionValue(r14, "superDescriptor.original");
        if (Intrinsics.areEqual(r13, MethodSignatureMappingKt.computeJvmDescriptor$default(r14, false, false, 2, null)) == false) goto L47;
        return false;
    L47:
        return true;
    L21:
        if (r10.isHiddenToOvercomeSignatureClash() != r4.isHiddenToOvercomeSignatureClash()) goto L23;
        r5 = true;
        goto L25
    L17:
        r4 = null;
        goto L19
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition
    public ExternalOverridabilityCondition.Contract getContract() {
        return ExternalOverridabilityCondition.Contract.CONFLICTS_ONLY;
    }
}
