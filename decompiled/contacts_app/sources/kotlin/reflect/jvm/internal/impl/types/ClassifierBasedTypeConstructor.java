package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils;

/* JADX INFO: compiled from: ClassifierBasedTypeConstructor.kt */
/* JADX INFO: loaded from: classes4.dex */
public abstract class ClassifierBasedTypeConstructor implements TypeConstructor {
    private int hashCode;

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    /* JADX INFO: renamed from: getDeclarationDescriptor */
    public abstract ClassifierDescriptor mo2083getDeclarationDescriptor();

    protected abstract boolean isSameClassifier(ClassifierDescriptor r1);

    public ClassifierBasedTypeConstructor() {
    }

    public int hashCode() {
        int r0 = this.hashCode;
        if (r0 == 0) goto L5;
        return r0;
    L5:
        ClassifierDescriptor r1 = mo2083getDeclarationDescriptor();
        if (hasMeaningfulFqName(r1) == false) goto L8;
        int r2 = DescriptorUtils.getFqName(r1).hashCode();
    L9:
        this.hashCode = r2;
        return r2;
    L8:
        r2 = System.identityHashCode(this);
        goto L9
    }

    public boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof TypeConstructor) == true) goto L9;
        return false;
    L9:
        if (r4.hashCode() == hashCode()) goto L11;
        return false;
    L11:
        TypeConstructor r5 = (TypeConstructor) r4;
        if (r5.getParameters().size() == getParameters().size()) goto L14;
        return false;
    L14:
        ClassifierDescriptor r0 = mo2083getDeclarationDescriptor();
        ClassifierDescriptor r6 = r5.mo2083getDeclarationDescriptor();
        if (r6 != null) goto L18;
        return false;
    L18:
        if (hasMeaningfulFqName(r0) == true) goto L20;
    L24:
        return false;
    L20:
        if (hasMeaningfulFqName(r6) == false) goto L24;
        return isSameClassifier(r6);
    }

    protected final boolean areFqNamesEqual(ClassifierDescriptor r3, ClassifierDescriptor r4) {
        Intrinsics.checkNotNullParameter(r3, "first");
        Intrinsics.checkNotNullParameter(r4, "second");
        if (Intrinsics.areEqual(r3.getName(), r4.getName()) == true) goto L5;
        return false;
    L5:
        DeclarationDescriptor r2 = r3.getContainingDeclaration();
        DeclarationDescriptor r5 = r4.getContainingDeclaration();
    L7:
        if (r2 == null) goto L31;
        if (r5 == null) goto L31;
        if ((r2 instanceof ModuleDescriptor) == true) goto L12;
        if ((r5 instanceof ModuleDescriptor) == true) goto L15;
        if ((r2 instanceof PackageFragmentDescriptor) == true) goto L19;
        if ((r5 instanceof PackageFragmentDescriptor) == true) goto L26;
        if (Intrinsics.areEqual(r2.getName(), r5.getName()) == false) goto L29;
        r2 = r2.getContainingDeclaration();
        r5 = r5.getContainingDeclaration();
        goto L7
    L29:
        return false;
    L26:
        return false;
    L19:
        if ((r5 instanceof PackageFragmentDescriptor) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(((PackageFragmentDescriptor) r2).getFqName(), ((PackageFragmentDescriptor) r5).getFqName()) == true) goto L23;
        return false;
    L23:
        return true;
    L15:
        return false;
    L12:
        return r5 instanceof ModuleDescriptor;
    L31:
        return true;
    }

    private final boolean hasMeaningfulFqName(ClassifierDescriptor r1) {
        ClassifierDescriptor r2 = r1;
        if (ErrorUtils.isError(r2) == false) goto L5;
    L7:
        return false;
    L5:
        if (DescriptorUtils.isLocal(r2) == true) goto L7;
        return true;
    }
}
