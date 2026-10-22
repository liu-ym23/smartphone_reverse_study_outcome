package kotlin.reflect.jvm.internal.impl.types;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.utils.SmartList;

/* JADX INFO: loaded from: classes4.dex */
public abstract class AbstractClassTypeConstructor extends AbstractTypeConstructor implements TypeConstructor {
    private static /* synthetic */ void $$$reportNull$$$0(int r9) {
        if (r9 == 1) goto L7;
        if (r9 == 3) goto L7;
        if (r9 == 4) goto L7;
        String r3 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
    L9:
        if (r9 == 1) goto L13;
        if (r9 == 3) goto L13;
        if (r9 == 4) goto L13;
        int r5 = 3;
    L14:
        Object[] r6 = new Object[r5];
        if (r9 == 1) goto L21;
        if (r9 == 2) goto L20;
        if (r9 == 3) goto L21;
        if (r9 == 4) goto L21;
        r6[0] = "storageManager";
    L22:
        if (r9 == 1) goto L27;
        if (r9 == 3) goto L26;
        if (r9 == 4) goto L26;
        r6[1] = "kotlin/reflect/jvm/internal/impl/types/AbstractClassTypeConstructor";
    L28:
        if (r9 == 1) goto L34;
        if (r9 == 2) goto L33;
        if (r9 == 3) goto L34;
        if (r9 == 4) goto L34;
        r6[2] = "<init>";
        goto L34
    L33:
        r6[2] = "isSameClassifier";
    L34:
        String r4 = String.format(r3, r6);
        if (r9 == 1) goto L40;
        if (r9 == 3) goto L40;
        if (r9 == 4) goto L40;
        throw new IllegalArgumentException(r4);
    L40:
        throw new IllegalStateException(r4);
    L26:
        r6[1] = "getAdditionalNeighboursInSupertypeGraph";
        goto L28
    L27:
        r6[1] = "getBuiltIns";
        goto L28
    L20:
        r6[0] = "classifier";
    L21:
        r6[0] = "kotlin/reflect/jvm/internal/impl/types/AbstractClassTypeConstructor";
    L13:
        r5 = 2;
    L7:
        r3 = "@NotNull method %s.%s must not return null";
        goto L9
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.ClassifierBasedTypeConstructor, kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    /* JADX INFO: renamed from: getDeclarationDescriptor */
    public abstract ClassDescriptor mo2083getDeclarationDescriptor();

    @Override // kotlin.reflect.jvm.internal.impl.types.ClassifierBasedTypeConstructor, kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    /* JADX INFO: renamed from: getDeclarationDescriptor */
    public /* bridge */ /* synthetic */ ClassifierDescriptor mo2083getDeclarationDescriptor() {
        return mo2083getDeclarationDescriptor();
    }

    public AbstractClassTypeConstructor(StorageManager r2) {
        if (r2 != null) goto L4;
        $$$reportNull$$$0(0);
    L4:
        super(r2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    public KotlinBuiltIns getBuiltIns() {
        KotlinBuiltIns r1 = DescriptorUtilsKt.getBuiltIns(mo2083getDeclarationDescriptor());
        if (r1 != null) goto L5;
        $$$reportNull$$$0(1);
    L5:
        return r1;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.ClassifierBasedTypeConstructor
    protected boolean isSameClassifier(ClassifierDescriptor r2) {
        if (r2 != null) goto L5;
        $$$reportNull$$$0(2);
    L5:
        if ((r2 instanceof ClassDescriptor) == true) goto L7;
    L9:
        return false;
    L7:
        if (areFqNamesEqual(mo2083getDeclarationDescriptor(), r2) == false) goto L9;
        return true;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor
    protected Collection<KotlinType> getAdditionalNeighboursInSupertypeGraph(boolean r3) {
        DeclarationDescriptor r2 = mo2083getDeclarationDescriptor().getContainingDeclaration();
        if ((r2 instanceof ClassDescriptor) == true) goto L8;
        List r4 = Collections.emptyList();
        if (r4 != null) goto L7;
        $$$reportNull$$$0(3);
    L7:
        return r4;
    L8:
        SmartList r0 = new SmartList();
        ClassDescriptor r5 = (ClassDescriptor) r2;
        r0.add(r5.getDefaultType());
        ClassDescriptor r6 = r5.mo2076getCompanionObjectDescriptor();
        if (r3 == false) goto L12;
        if (r6 == null) goto L12;
        r0.add(r6.getDefaultType());
    L12:
        return r0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor
    protected KotlinType defaultSupertypeIfEmpty() {
        if (KotlinBuiltIns.isSpecialClassWithNoSupertypes(mo2083getDeclarationDescriptor()) == false) goto L7;
        return null;
    L7:
        return getBuiltIns().getAnyType();
    }
}
