package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.SupertypeLoopChecker;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeKt;
import kotlin.reflect.jvm.internal.impl.types.Variance;

/* JADX INFO: loaded from: classes4.dex */
public class TypeParameterDescriptorImpl extends AbstractTypeParameterDescriptor {
    private boolean initialized;
    private final Function1<KotlinType, Void> reportCycleError;
    private final List<KotlinType> upperBounds;

    private static /* synthetic */ void $$$reportNull$$$0(int r8) {
        if (r8 == 5) goto L6;
        if (r8 == 28) goto L6;
        String r2 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
    L8:
        if (r8 == 5) goto L11;
        if (r8 == 28) goto L11;
        int r4 = 3;
    L12:
        Object[] r5 = new Object[r4];
        switch(r8) {
            case 1: goto L24;
            case 2: goto L23;
            case 3: goto L22;
            case 4: goto L21;
            case 5: goto L20;
            case 6: goto L14;
            case 7: goto L24;
            case 8: goto L23;
            case 9: goto L22;
            case 10: goto L19;
            case 11: goto L21;
            case 12: goto L14;
            case 13: goto L24;
            case 14: goto L23;
            case 15: goto L22;
            case 16: goto L19;
            case 17: goto L18;
            case 18: goto L21;
            case 19: goto L14;
            case 20: goto L24;
            case 21: goto L23;
            case 22: goto L22;
            case 23: goto L19;
            case 24: goto L17;
            case 25: goto L21;
            case 26: goto L16;
            case 27: goto L15;
            case 28: goto L20;
            default: goto L14;
        };
    L14:
        r5[0] = "containingDeclaration";
    L26:
        if (r8 == 5) goto L30;
        if (r8 == 28) goto L29;
        r5[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/TypeParameterDescriptorImpl";
    L31:
        switch(r8) {
            case 5: goto L37;
            case 6: goto L36;
            case 7: goto L36;
            case 8: goto L36;
            case 9: goto L36;
            case 10: goto L36;
            case 11: goto L36;
            case 12: goto L36;
            case 13: goto L36;
            case 14: goto L36;
            case 15: goto L36;
            case 16: goto L36;
            case 17: goto L36;
            case 18: goto L36;
            case 19: goto L35;
            case 20: goto L35;
            case 21: goto L35;
            case 22: goto L35;
            case 23: goto L35;
            case 24: goto L35;
            case 25: goto L35;
            case 26: goto L34;
            case 27: goto L33;
            case 28: goto L37;
            default: goto L32;
        };
    L32:
        r5[2] = "createWithDefaultBound";
        goto L37
    L33:
        r5[2] = "reportSupertypeLoopError";
        goto L37
    L34:
        r5[2] = "addUpperBound";
        goto L37
    L35:
        r5[2] = "<init>";
        goto L37
    L36:
        r5[2] = "createForFurtherModification";
    L37:
        String r3 = String.format(r2, r5);
        if (r8 == 5) goto L42;
        if (r8 == 28) goto L42;
        throw new IllegalArgumentException(r3);
    L42:
        throw new IllegalStateException(r3);
    L29:
        r5[1] = "resolveUpperBounds";
        goto L31
    L30:
        r5[1] = "createWithDefaultBound";
        goto L31
    L15:
        r5[0] = "type";
        goto L26
    L16:
        r5[0] = "bound";
        goto L26
    L17:
        r5[0] = "supertypeLoopsChecker";
        goto L26
    L18:
        r5[0] = "supertypeLoopsResolver";
        goto L26
    L19:
        r5[0] = "source";
        goto L26
    L20:
        r5[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/TypeParameterDescriptorImpl";
        goto L26
    L21:
        r5[0] = "storageManager";
        goto L26
    L22:
        r5[0] = "name";
        goto L26
    L23:
        r5[0] = "variance";
        goto L26
    L24:
        r5[0] = "annotations";
    L11:
        r4 = 2;
    L6:
        r2 = "@NotNull method %s.%s must not return null";
        goto L8
    }

    public static TypeParameterDescriptor createWithDefaultBound(DeclarationDescriptor r9, Annotations r10, boolean r11, Variance r12, Name r13, int r14, StorageManager r15) {
        if (r9 != null) goto L4;
        $$$reportNull$$$0(0);
    L4:
        if (r10 != null) goto L6;
        $$$reportNull$$$0(1);
    L6:
        if (r12 != null) goto L8;
        $$$reportNull$$$0(2);
    L8:
        if (r13 != null) goto L10;
        $$$reportNull$$$0(3);
    L10:
        if (r15 != null) goto L12;
        $$$reportNull$$$0(4);
    L12:
        TypeParameterDescriptorImpl r16 = createForFurtherModification(r9, r10, r11, r12, r13, r14, SourceElement.NO_SOURCE, r15);
        r16.addUpperBound(DescriptorUtilsKt.getBuiltIns(r9).getDefaultBound());
        r16.setInitialized();
        if (r16 != null) goto L15;
        $$$reportNull$$$0(5);
    L15:
        return r16;
    }

    public static TypeParameterDescriptorImpl createForFurtherModification(DeclarationDescriptor r10, Annotations r11, boolean r12, Variance r13, Name r14, int r15, SourceElement r16, StorageManager r17) {
        if (r10 != null) goto L4;
        $$$reportNull$$$0(6);
    L4:
        if (r11 != null) goto L6;
        $$$reportNull$$$0(7);
    L6:
        if (r13 != null) goto L8;
        $$$reportNull$$$0(8);
    L8:
        if (r14 != null) goto L10;
        $$$reportNull$$$0(9);
    L10:
        if (r16 != null) goto L12;
        $$$reportNull$$$0(10);
    L12:
        if (r17 != null) goto L15;
        $$$reportNull$$$0(11);
    L15:
        return createForFurtherModification(r10, r11, r12, r13, r14, r15, r16, null, SupertypeLoopChecker.EMPTY.INSTANCE, r17);
    }

    public static TypeParameterDescriptorImpl createForFurtherModification(DeclarationDescriptor r12, Annotations r13, boolean r14, Variance r15, Name r16, int r17, SourceElement r18, Function1<KotlinType, Void> r19, SupertypeLoopChecker r20, StorageManager r21) {
        if (r12 != null) goto L4;
        $$$reportNull$$$0(12);
    L4:
        if (r13 != null) goto L6;
        $$$reportNull$$$0(13);
    L6:
        if (r15 != null) goto L8;
        $$$reportNull$$$0(14);
    L8:
        if (r16 != null) goto L10;
        $$$reportNull$$$0(15);
    L10:
        if (r18 != null) goto L12;
        $$$reportNull$$$0(16);
    L12:
        if (r20 != null) goto L14;
        $$$reportNull$$$0(17);
    L14:
        if (r21 != null) goto L17;
        $$$reportNull$$$0(18);
    L17:
        return new TypeParameterDescriptorImpl(r12, r13, r14, r15, r16, r17, r18, r19, r20, r21);
    }

    private TypeParameterDescriptorImpl(DeclarationDescriptor r12, Annotations r13, boolean r14, Variance r15, Name r16, int r17, SourceElement r18, Function1<KotlinType, Void> r19, SupertypeLoopChecker r20, StorageManager r21) {
        if (r12 != null) goto L5;
        $$$reportNull$$$0(19);
    L5:
        if (r13 != null) goto L7;
        $$$reportNull$$$0(20);
    L7:
        if (r15 != null) goto L9;
        $$$reportNull$$$0(21);
    L9:
        if (r16 != null) goto L11;
        $$$reportNull$$$0(22);
    L11:
        if (r18 != null) goto L13;
        $$$reportNull$$$0(23);
    L13:
        if (r20 != null) goto L15;
        $$$reportNull$$$0(24);
    L15:
        if (r21 != null) goto L17;
        $$$reportNull$$$0(25);
    L17:
        super(r21, r12, r13, r16, r15, r14, r17, r18, r20);
        this.upperBounds = new ArrayList(1);
        this.initialized = false;
        this.reportCycleError = r19;
    }

    private void checkInitialized() {
        if (this.initialized == false) goto L6;
        return;
    L6:
        throw new IllegalStateException("Type parameter descriptor is not initialized: " + nameForAssertions());
    }

    private void checkUninitialized() {
        if (this.initialized == true) goto L6;
        return;
    L6:
        throw new IllegalStateException("Type parameter descriptor is already initialized: " + nameForAssertions());
    }

    private String nameForAssertions() {
        return getName() + " declared in " + DescriptorUtils.getFqName(getContainingDeclaration());
    }

    public void setInitialized() {
        checkUninitialized();
        this.initialized = true;
    }

    public boolean isInitialized() {
        return this.initialized;
    }

    public void addUpperBound(KotlinType r2) {
        if (r2 != null) goto L4;
        $$$reportNull$$$0(26);
    L4:
        checkUninitialized();
        doAddUpperBound(r2);
    }

    private void doAddUpperBound(KotlinType r2) {
        if (KotlinTypeKt.isError(r2) == false) goto L5;
        return;
    L5:
        this.upperBounds.add(r2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractTypeParameterDescriptor
    /* JADX INFO: renamed from: reportSupertypeLoopError */
    protected void mo2086reportSupertypeLoopError(KotlinType r2) {
        if (r2 != null) goto L4;
        $$$reportNull$$$0(27);
    L4:
        Function1<KotlinType, Void> r1 = this.reportCycleError;
        if (r1 != null) goto L7;
        return;
    L7:
        r1.invoke(r2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractTypeParameterDescriptor
    protected List<KotlinType> resolveUpperBounds() {
        checkInitialized();
        List<KotlinType> r1 = this.upperBounds;
        if (r1 != null) goto L5;
        $$$reportNull$$$0(28);
    L5:
        return r1;
    }
}
