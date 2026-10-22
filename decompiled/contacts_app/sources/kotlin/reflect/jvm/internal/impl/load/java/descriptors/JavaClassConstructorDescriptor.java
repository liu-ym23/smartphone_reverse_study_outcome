package kotlin.reflect.jvm.internal.impl.load.java.descriptors;

import java.util.List;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassConstructorDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorFactory;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* JADX INFO: loaded from: classes4.dex */
public class JavaClassConstructorDescriptor extends ClassConstructorDescriptorImpl implements JavaCallableMemberDescriptor {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private Boolean hasStableParameterNames;
    private Boolean hasSynthesizedParameterNames;

    private static /* synthetic */ void $$$reportNull$$$0(int r9) {
        if (r9 == 11) goto L6;
        if (r9 == 18) goto L6;
        String r2 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
    L8:
        if (r9 == 11) goto L11;
        if (r9 == 18) goto L11;
        int r4 = 3;
    L12:
        Object[] r5 = new Object[r4];
        switch(r9) {
            case 1: goto L22;
            case 2: goto L21;
            case 3: goto L20;
            case 4: goto L14;
            case 5: goto L22;
            case 6: goto L20;
            case 7: goto L19;
            case 8: goto L21;
            case 9: goto L22;
            case 10: goto L20;
            case 11: goto L18;
            case 12: goto L19;
            case 13: goto L21;
            case 14: goto L17;
            case 15: goto L22;
            case 16: goto L16;
            case 17: goto L15;
            case 18: goto L18;
            default: goto L14;
        };
    L14:
        r5[0] = "containingDeclaration";
    L24:
        if (r9 == 11) goto L28;
        if (r9 == 18) goto L27;
        r5[1] = "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaClassConstructorDescriptor";
    L29:
        switch(r9) {
            case 4: goto L34;
            case 5: goto L34;
            case 6: goto L34;
            case 7: goto L33;
            case 8: goto L33;
            case 9: goto L33;
            case 10: goto L33;
            case 11: goto L35;
            case 12: goto L32;
            case 13: goto L32;
            case 14: goto L32;
            case 15: goto L32;
            case 16: goto L31;
            case 17: goto L31;
            case 18: goto L35;
            default: goto L30;
        };
    L30:
        r5[2] = "<init>";
        goto L35
    L31:
        r5[2] = "enhance";
        goto L35
    L32:
        r5[2] = "createDescriptor";
        goto L35
    L33:
        r5[2] = "createSubstitutedCopy";
        goto L35
    L34:
        r5[2] = "createJavaConstructor";
    L35:
        String r3 = String.format(r2, r5);
        if (r9 == 11) goto L40;
        if (r9 == 18) goto L40;
        throw new IllegalArgumentException(r3);
    L40:
        throw new IllegalStateException(r3);
    L27:
        r5[1] = "enhance";
        goto L29
    L28:
        r5[1] = "createSubstitutedCopy";
        goto L29
    L15:
        r5[0] = "enhancedReturnType";
        goto L24
    L16:
        r5[0] = "enhancedValueParameterTypes";
        goto L24
    L17:
        r5[0] = "sourceElement";
        goto L24
    L18:
        r5[0] = "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaClassConstructorDescriptor";
        goto L24
    L19:
        r5[0] = "newOwner";
        goto L24
    L20:
        r5[0] = "source";
        goto L24
    L21:
        r5[0] = "kind";
        goto L24
    L22:
        r5[0] = "annotations";
    L11:
        r4 = 2;
    L6:
        r2 = "@NotNull method %s.%s must not return null";
        goto L8
    }

    static {
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassConstructorDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl
    protected /* bridge */ /* synthetic */ ClassConstructorDescriptorImpl createSubstitutedCopy(DeclarationDescriptor r1, FunctionDescriptor r2, CallableMemberDescriptor.Kind r3, Name r4, Annotations r5, SourceElement r6) {
        return createSubstitutedCopy(r1, r2, r3, r4, r5, r6);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassConstructorDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl
    protected /* bridge */ /* synthetic */ FunctionDescriptorImpl createSubstitutedCopy(DeclarationDescriptor r1, FunctionDescriptor r2, CallableMemberDescriptor.Kind r3, Name r4, Annotations r5, SourceElement r6) {
        return createSubstitutedCopy(r1, r2, r3, r4, r5, r6);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaCallableMemberDescriptor
    public /* bridge */ /* synthetic */ JavaCallableMemberDescriptor enhance(KotlinType r1, List r2, KotlinType r3, Pair r4) {
        return enhance(r1, r2, r3, r4);
    }

    protected JavaClassConstructorDescriptor(ClassDescriptor r2, JavaClassConstructorDescriptor r3, Annotations r4, boolean r5, CallableMemberDescriptor.Kind r6, SourceElement r7) {
        if (r2 != null) goto L4;
        $$$reportNull$$$0(0);
    L4:
        if (r4 != null) goto L6;
        $$$reportNull$$$0(1);
    L6:
        if (r6 != null) goto L8;
        $$$reportNull$$$0(2);
    L8:
        if (r7 != null) goto L10;
        $$$reportNull$$$0(3);
    L10:
        super(r2, r3, r4, r5, r6, r7);
        this.hasStableParameterNames = null;
        this.hasSynthesizedParameterNames = null;
    }

    public static JavaClassConstructorDescriptor createJavaConstructor(ClassDescriptor r8, Annotations r9, boolean r10, SourceElement r11) {
        if (r8 != null) goto L4;
        $$$reportNull$$$0(4);
    L4:
        if (r9 != null) goto L6;
        $$$reportNull$$$0(5);
    L6:
        if (r11 != null) goto L9;
        $$$reportNull$$$0(6);
    L9:
        return new JavaClassConstructorDescriptor(r8, null, r9, r10, CallableMemberDescriptor.Kind.DECLARATION, r11);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl
    public boolean hasStableParameterNames() {
        return this.hasStableParameterNames.booleanValue();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl
    public void setHasStableParameterNames(boolean r1) {
        this.hasStableParameterNames = Boolean.valueOf(r1);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    public boolean hasSynthesizedParameterNames() {
        return this.hasSynthesizedParameterNames.booleanValue();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl
    public void setHasSynthesizedParameterNames(boolean r1) {
        this.hasSynthesizedParameterNames = Boolean.valueOf(r1);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassConstructorDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl
    protected JavaClassConstructorDescriptor createSubstitutedCopy(DeclarationDescriptor r7, FunctionDescriptor r8, CallableMemberDescriptor.Kind r9, Name r10, Annotations r11, SourceElement r12) {
        if (r7 != null) goto L4;
        $$$reportNull$$$0(7);
    L4:
        if (r9 != null) goto L6;
        $$$reportNull$$$0(8);
    L6:
        if (r11 != null) goto L8;
        $$$reportNull$$$0(9);
    L8:
        if (r12 != null) goto L11;
        $$$reportNull$$$0(10);
    L11:
        if (r9 != CallableMemberDescriptor.Kind.DECLARATION) goto L13;
    L17:
        JavaClassConstructorDescriptor r13 = createDescriptor((ClassDescriptor) r7, (JavaClassConstructorDescriptor) r8, r9, r12, r11);
        r13.setHasStableParameterNames(hasStableParameterNames());
        r13.setHasSynthesizedParameterNames(hasSynthesizedParameterNames());
        if (r13 != null) goto L20;
        $$$reportNull$$$0(11);
    L20:
        return r13;
    L13:
        if (r9 == CallableMemberDescriptor.Kind.SYNTHESIZED) goto L17;
        throw new IllegalStateException("Attempt at creating a constructor that is not a declaration: \ncopy from: " + this + "\nnewOwner: " + r7 + "\nkind: " + r9);
    }

    protected JavaClassConstructorDescriptor createDescriptor(ClassDescriptor r9, JavaClassConstructorDescriptor r10, CallableMemberDescriptor.Kind r11, SourceElement r12, Annotations r13) {
        if (r9 != null) goto L4;
        $$$reportNull$$$0(12);
    L4:
        if (r11 != null) goto L6;
        $$$reportNull$$$0(13);
    L6:
        if (r12 != null) goto L8;
        $$$reportNull$$$0(14);
    L8:
        if (r13 != null) goto L11;
        $$$reportNull$$$0(15);
    L11:
        return new JavaClassConstructorDescriptor(r9, r10, r13, this.isPrimary, r11, r12);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaCallableMemberDescriptor
    public JavaClassConstructorDescriptor enhance(KotlinType r13, List<KotlinType> r14, KotlinType r15, Pair<CallableDescriptor.UserDataKey<?>, ?> r16) {
        if (r14 != null) goto L5;
        $$$reportNull$$$0(16);
    L5:
        if (r15 != null) goto L7;
        $$$reportNull$$$0(17);
    L7:
        JavaClassConstructorDescriptor r2 = createSubstitutedCopy(getContainingDeclaration(), null, getKind(), null, getAnnotations(), getSource());
        if (r13 != null) goto L10;
        ReceiverParameterDescriptor r0 = null;
    L11:
        r2.initialize(r0, getDispatchReceiverParameter(), CollectionsKt.emptyList(), getTypeParameters(), UtilKt.copyValueParameters(r14, getValueParameters(), r2), r15, getModality(), getVisibility());
        if (r16 == null) goto L14;
        r2.putInUserDataMap(r16.getFirst(), r16.getSecond());
    L14:
        if (r2 != null) goto L16;
        $$$reportNull$$$0(18);
    L16:
        return r2;
    L10:
        r0 = DescriptorFactory.createExtensionReceiverParameterForCallable(r2, r13, Annotations.Companion.getEMPTY());
        goto L11
    }
}
