package kotlin.reflect.jvm.internal.impl.types;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SupertypeLoopChecker;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;

/* JADX INFO: loaded from: classes4.dex */
public class ClassTypeConstructorImpl extends AbstractClassTypeConstructor implements TypeConstructor {
    private final ClassDescriptor classDescriptor;
    private final List<TypeParameterDescriptor> parameters;
    private final Collection<KotlinType> supertypes;

    private static /* synthetic */ void $$$reportNull$$$0(int r10) {
        if (r10 == 4) goto L8;
        if (r10 == 5) goto L8;
        if (r10 == 6) goto L8;
        if (r10 == 7) goto L8;
        String r4 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
    L10:
        if (r10 == 4) goto L15;
        if (r10 == 5) goto L15;
        if (r10 == 6) goto L15;
        if (r10 == 7) goto L15;
        int r6 = 3;
    L16:
        Object[] r7 = new Object[r6];
        switch(r10) {
            case 1: goto L22;
            case 2: goto L21;
            case 3: goto L20;
            case 4: goto L19;
            case 5: goto L19;
            case 6: goto L19;
            case 7: goto L19;
            default: goto L18;
        };
    L18:
        r7[0] = "classDescriptor";
    L24:
        if (r10 == 4) goto L32;
        if (r10 == 5) goto L31;
        if (r10 == 6) goto L30;
        if (r10 == 7) goto L29;
        r7[1] = "kotlin/reflect/jvm/internal/impl/types/ClassTypeConstructorImpl";
    L33:
        if (r10 == 4) goto L38;
        if (r10 == 5) goto L38;
        if (r10 == 6) goto L38;
        if (r10 == 7) goto L38;
        r7[2] = "<init>";
    L38:
        String r5 = String.format(r4, r7);
        if (r10 == 4) goto L45;
        if (r10 == 5) goto L45;
        if (r10 == 6) goto L45;
        if (r10 == 7) goto L45;
        throw new IllegalArgumentException(r5);
    L45:
        throw new IllegalStateException(r5);
    L29:
        r7[1] = "getSupertypeLoopChecker";
        goto L33
    L30:
        r7[1] = "computeSupertypes";
        goto L33
    L31:
        r7[1] = "getDeclarationDescriptor";
        goto L33
    L32:
        r7[1] = "getParameters";
        goto L33
    L19:
        r7[0] = "kotlin/reflect/jvm/internal/impl/types/ClassTypeConstructorImpl";
        goto L24
    L20:
        r7[0] = "storageManager";
        goto L24
    L21:
        r7[0] = "supertypes";
        goto L24
    L22:
        r7[0] = "parameters";
    L15:
        r6 = 2;
    L8:
        r4 = "@NotNull method %s.%s must not return null";
        goto L10
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    public boolean isDenotable() {
        return true;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.AbstractClassTypeConstructor, kotlin.reflect.jvm.internal.impl.types.ClassifierBasedTypeConstructor, kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    /* JADX INFO: renamed from: getDeclarationDescriptor */
    public /* bridge */ /* synthetic */ ClassifierDescriptor mo2083getDeclarationDescriptor() {
        return mo2083getDeclarationDescriptor();
    }

    public ClassTypeConstructorImpl(ClassDescriptor r2, List<? extends TypeParameterDescriptor> r3, Collection<KotlinType> r4, StorageManager r5) {
        if (r2 != null) goto L4;
        $$$reportNull$$$0(0);
    L4:
        if (r3 != null) goto L6;
        $$$reportNull$$$0(1);
    L6:
        if (r4 != null) goto L8;
        $$$reportNull$$$0(2);
    L8:
        if (r5 != null) goto L10;
        $$$reportNull$$$0(3);
    L10:
        super(r5);
        this.classDescriptor = r2;
        this.parameters = Collections.unmodifiableList(new ArrayList(r3));
        this.supertypes = Collections.unmodifiableCollection(r4);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    public List<TypeParameterDescriptor> getParameters() {
        List<TypeParameterDescriptor> r1 = this.parameters;
        if (r1 != null) goto L5;
        $$$reportNull$$$0(4);
    L5:
        return r1;
    }

    public String toString() {
        return DescriptorUtils.getFqName(this.classDescriptor).asString();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.AbstractClassTypeConstructor, kotlin.reflect.jvm.internal.impl.types.ClassifierBasedTypeConstructor, kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    /* JADX INFO: renamed from: getDeclarationDescriptor */
    public ClassDescriptor mo2083getDeclarationDescriptor() {
        ClassDescriptor r1 = this.classDescriptor;
        if (r1 != null) goto L5;
        $$$reportNull$$$0(5);
    L5:
        return r1;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor
    protected Collection<KotlinType> computeSupertypes() {
        Collection<KotlinType> r1 = this.supertypes;
        if (r1 != null) goto L5;
        $$$reportNull$$$0(6);
    L5:
        return r1;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor
    protected SupertypeLoopChecker getSupertypeLoopChecker() {
        SupertypeLoopChecker.EMPTY r1 = SupertypeLoopChecker.EMPTY.INSTANCE;
        if (r1 != null) goto L5;
        $$$reportNull$$$0(7);
    L5:
        return r1;
    }
}
