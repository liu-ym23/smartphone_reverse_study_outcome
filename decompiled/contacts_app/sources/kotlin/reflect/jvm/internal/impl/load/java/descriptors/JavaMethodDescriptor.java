package kotlin.reflect.jvm.internal.impl.load.java.descriptors;

import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.SimpleFunctionDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorFactory;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.util.OperatorChecks;

/* JADX INFO: loaded from: classes4.dex */
public class JavaMethodDescriptor extends SimpleFunctionDescriptorImpl implements JavaCallableMemberDescriptor {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final CallableDescriptor.UserDataKey<Boolean> HAS_ERASED_VALUE_PARAMETERS = null;
    public static final CallableDescriptor.UserDataKey<ValueParameterDescriptor> ORIGINAL_VALUE_PARAMETER_FOR_EXTENSION_RECEIVER = null;
    private final boolean isForRecordComponent;
    private ParameterNamesStatus parameterNamesStatus;

    private static final enum ParameterNamesStatus extends Enum<ParameterNamesStatus> {
        private static final /* synthetic */ ParameterNamesStatus[] $VALUES = null;
        public static final ParameterNamesStatus NON_STABLE_DECLARED = null;
        public static final ParameterNamesStatus NON_STABLE_SYNTHESIZED = null;
        public static final ParameterNamesStatus STABLE_DECLARED = null;
        public static final ParameterNamesStatus STABLE_SYNTHESIZED = null;
        public final boolean isStable;
        public final boolean isSynthesized;

        private static /* synthetic */ void $$$reportNull$$$0(int r2) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaMethodDescriptor$ParameterNamesStatus", "get"}));
        }

        public static ParameterNamesStatus valueOf(String r1) {
            return (ParameterNamesStatus) Enum.valueOf(ParameterNamesStatus.class, r1);
        }

        public static ParameterNamesStatus[] values() {
            return (ParameterNamesStatus[]) $VALUES.clone();
        }

        static {
            ParameterNamesStatus r0 = new ParameterNamesStatus("NON_STABLE_DECLARED", 0, false, false);
            NON_STABLE_DECLARED = r0;
            ParameterNamesStatus r1 = new ParameterNamesStatus("STABLE_DECLARED", 1, true, false);
            STABLE_DECLARED = r1;
            ParameterNamesStatus r3 = new ParameterNamesStatus("NON_STABLE_SYNTHESIZED", 2, false, true);
            NON_STABLE_SYNTHESIZED = r3;
            ParameterNamesStatus r5 = new ParameterNamesStatus("STABLE_SYNTHESIZED", 3, true, true);
            STABLE_SYNTHESIZED = r5;
            $VALUES = new ParameterNamesStatus[]{r0, r1, r3, r5};
        }

        private ParameterNamesStatus(String r1, int r2, boolean r3, boolean r4) {
            super(r1, r2);
            this.isStable = r3;
            this.isSynthesized = r4;
        }

        public static ParameterNamesStatus get(boolean r0, boolean r1) {
            if (r0 == false) goto L6;
            if (r1 == false) goto L5;
            ParameterNamesStatus r2 = STABLE_SYNTHESIZED;
        L9:
            if (r2 != null) goto L11;
            $$$reportNull$$$0(0);
        L11:
            return r2;
        L5:
            r2 = STABLE_DECLARED;
            goto L9
        L6:
            if (r1 == false) goto L8;
            r2 = NON_STABLE_SYNTHESIZED;
            goto L9
        L8:
            r2 = NON_STABLE_DECLARED;
            goto L9
        }
    }

    private static /* synthetic */ void $$$reportNull$$$0(int r11) {
        if (r11 == 13) goto L7;
        if (r11 == 18) goto L7;
        if (r11 == 21) goto L7;
        String r3 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
    L9:
        if (r11 == 13) goto L13;
        if (r11 == 18) goto L13;
        if (r11 == 21) goto L13;
        int r5 = 3;
    L14:
        Object[] r6 = new Object[r5];
        switch(r11) {
            case 1: goto L28;
            case 2: goto L27;
            case 3: goto L26;
            case 4: goto L25;
            case 5: goto L16;
            case 6: goto L28;
            case 7: goto L27;
            case 8: goto L25;
            case 9: goto L24;
            case 10: goto L23;
            case 11: goto L22;
            case 12: goto L21;
            case 13: goto L20;
            case 14: goto L19;
            case 15: goto L26;
            case 16: goto L28;
            case 17: goto L25;
            case 18: goto L20;
            case 19: goto L18;
            case 20: goto L17;
            case 21: goto L20;
            default: goto L16;
        };
    L16:
        r6[0] = "containingDeclaration";
    L30:
        if (r11 == 13) goto L36;
        if (r11 == 18) goto L35;
        if (r11 == 21) goto L34;
        r6[1] = "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaMethodDescriptor";
    L37:
        switch(r11) {
            case 5: goto L42;
            case 6: goto L42;
            case 7: goto L42;
            case 8: goto L42;
            case 9: goto L41;
            case 10: goto L41;
            case 11: goto L41;
            case 12: goto L41;
            case 13: goto L43;
            case 14: goto L40;
            case 15: goto L40;
            case 16: goto L40;
            case 17: goto L40;
            case 18: goto L43;
            case 19: goto L39;
            case 20: goto L39;
            case 21: goto L43;
            default: goto L38;
        };
    L38:
        r6[2] = "<init>";
        goto L43
    L39:
        r6[2] = "enhance";
        goto L43
    L40:
        r6[2] = "createSubstitutedCopy";
        goto L43
    L41:
        r6[2] = "initialize";
        goto L43
    L42:
        r6[2] = "createJavaMethod";
    L43:
        String r4 = String.format(r3, r6);
        if (r11 == 13) goto L49;
        if (r11 == 18) goto L49;
        if (r11 == 21) goto L49;
        throw new IllegalArgumentException(r4);
    L49:
        throw new IllegalStateException(r4);
    L34:
        r6[1] = "enhance";
        goto L37
    L35:
        r6[1] = "createSubstitutedCopy";
        goto L37
    L36:
        r6[1] = "initialize";
        goto L37
    L17:
        r6[0] = "enhancedReturnType";
        goto L30
    L18:
        r6[0] = "enhancedValueParameterTypes";
        goto L30
    L19:
        r6[0] = "newOwner";
        goto L30
    L20:
        r6[0] = "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaMethodDescriptor";
        goto L30
    L21:
        r6[0] = "visibility";
        goto L30
    L22:
        r6[0] = "unsubstitutedValueParameters";
        goto L30
    L23:
        r6[0] = "typeParameters";
        goto L30
    L24:
        r6[0] = "contextReceiverParameters";
        goto L30
    L25:
        r6[0] = "source";
        goto L30
    L26:
        r6[0] = "kind";
        goto L30
    L27:
        r6[0] = "name";
        goto L30
    L28:
        r6[0] = "annotations";
    L13:
        r5 = 2;
    L7:
        r3 = "@NotNull method %s.%s must not return null";
        goto L9
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.SimpleFunctionDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl
    protected /* bridge */ /* synthetic */ FunctionDescriptorImpl createSubstitutedCopy(DeclarationDescriptor r1, FunctionDescriptor r2, CallableMemberDescriptor.Kind r3, Name r4, Annotations r5, SourceElement r6) {
        return createSubstitutedCopy(r1, r2, r3, r4, r5, r6);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaCallableMemberDescriptor
    public /* bridge */ /* synthetic */ JavaCallableMemberDescriptor enhance(KotlinType r1, List r2, KotlinType r3, Pair r4) {
        return enhance(r1, r2, r3, r4);
    }

    static {
        ORIGINAL_VALUE_PARAMETER_FOR_EXTENSION_RECEIVER = new AnonymousClass1();
        HAS_ERASED_VALUE_PARAMETERS = new AnonymousClass2();
    }

    protected JavaMethodDescriptor(DeclarationDescriptor r2, SimpleFunctionDescriptor r3, Annotations r4, Name r5, CallableMemberDescriptor.Kind r6, SourceElement r7, boolean r8) {
        if (r2 != null) goto L4;
        $$$reportNull$$$0(0);
    L4:
        if (r4 != null) goto L6;
        $$$reportNull$$$0(1);
    L6:
        if (r5 != null) goto L8;
        $$$reportNull$$$0(2);
    L8:
        if (r6 != null) goto L10;
        $$$reportNull$$$0(3);
    L10:
        if (r7 != null) goto L12;
        $$$reportNull$$$0(4);
    L12:
        super(r2, r3, r4, r5, r6, r7);
        this.parameterNamesStatus = null;
        this.isForRecordComponent = r8;
    }

    public static JavaMethodDescriptor createJavaMethod(DeclarationDescriptor r9, Annotations r10, Name r11, SourceElement r12, boolean r13) {
        if (r9 != null) goto L4;
        $$$reportNull$$$0(5);
    L4:
        if (r10 != null) goto L6;
        $$$reportNull$$$0(6);
    L6:
        if (r11 != null) goto L8;
        $$$reportNull$$$0(7);
    L8:
        if (r12 != null) goto L11;
        $$$reportNull$$$0(8);
    L11:
        return new JavaMethodDescriptor(r9, null, r10, r11, CallableMemberDescriptor.Kind.DECLARATION, r12, r13);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.SimpleFunctionDescriptorImpl
    public SimpleFunctionDescriptorImpl initialize(ReceiverParameterDescriptor r2, ReceiverParameterDescriptor r3, List<ReceiverParameterDescriptor> r4, List<? extends TypeParameterDescriptor> r5, List<ValueParameterDescriptor> r6, KotlinType r7, Modality r8, DescriptorVisibility r9, Map<? extends CallableDescriptor.UserDataKey<?>, ?> r10) {
        if (r4 != null) goto L4;
        $$$reportNull$$$0(9);
    L4:
        if (r5 != null) goto L6;
        $$$reportNull$$$0(10);
    L6:
        if (r6 != null) goto L8;
        $$$reportNull$$$0(11);
    L8:
        if (r9 != null) goto L10;
        $$$reportNull$$$0(12);
    L10:
        SimpleFunctionDescriptorImpl r11 = super.initialize(r2, r3, r4, r5, r6, r7, r8, r9, r10);
        setOperator(OperatorChecks.INSTANCE.check(r11).isSuccess());
        if (r11 != null) goto L13;
        $$$reportNull$$$0(13);
    L13:
        return r11;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl
    public boolean hasStableParameterNames() {
        return this.parameterNamesStatus.isStable;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    public boolean hasSynthesizedParameterNames() {
        return this.parameterNamesStatus.isSynthesized;
    }

    public void setParameterNamesStatus(boolean r1, boolean r2) {
        this.parameterNamesStatus = ParameterNamesStatus.get(r1, r2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.SimpleFunctionDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl
    protected JavaMethodDescriptor createSubstitutedCopy(DeclarationDescriptor r10, FunctionDescriptor r11, CallableMemberDescriptor.Kind r12, Name r13, Annotations r14, SourceElement r15) {
        if (r10 != null) goto L4;
        $$$reportNull$$$0(14);
    L4:
        if (r12 != null) goto L6;
        $$$reportNull$$$0(15);
    L6:
        if (r14 != null) goto L8;
        $$$reportNull$$$0(16);
    L8:
        if (r15 != null) goto L10;
        $$$reportNull$$$0(17);
    L10:
        SimpleFunctionDescriptor r3 = (SimpleFunctionDescriptor) r11;
        if (r13 != null) goto L14;
        r13 = getName();
    L14:
        JavaMethodDescriptor r0 = new JavaMethodDescriptor(r10, r3, r14, r13, r12, r15, this.isForRecordComponent);
        r0.setParameterNamesStatus(hasStableParameterNames(), hasSynthesizedParameterNames());
        return r0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaCallableMemberDescriptor
    public JavaMethodDescriptor enhance(KotlinType r2, List<KotlinType> r3, KotlinType r4, Pair<CallableDescriptor.UserDataKey<?>, ?> r5) {
        if (r3 != null) goto L4;
        $$$reportNull$$$0(19);
    L4:
        if (r4 != null) goto L6;
        $$$reportNull$$$0(20);
    L6:
        List<ValueParameterDescriptor> r6 = UtilKt.copyValueParameters(r3, getValueParameters(), this);
        if (r2 != null) goto L9;
        ReceiverParameterDescriptor r7 = null;
    L10:
        JavaMethodDescriptor r1 = (JavaMethodDescriptor) newCopyBuilder().setValueParameters(r6).setReturnType(r4).setExtensionReceiverParameter(r7).setDropOriginalInContainingParts().setPreserveSourceElement().build();
        if (r5 == null) goto L13;
        r1.putInUserDataMap(r5.getFirst(), r5.getSecond());
    L13:
        if (r1 != null) goto L15;
        $$$reportNull$$$0(21);
    L15:
        return r1;
    L9:
        r7 = DescriptorFactory.createExtensionReceiverParameterForCallable(this, r2, Annotations.Companion.getEMPTY());
        goto L10
    }
}
