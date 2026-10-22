package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;

/* JADX INFO: compiled from: descriptorUtil.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class DescriptorUtilKt {
    public static final ClassDescriptor resolveClassByFqName(ModuleDescriptor r5, FqName r6, LookupLocation r7) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r6, "fqName");
        Intrinsics.checkNotNullParameter(r7, "lookupLocation");
        if (r6.isRoot() == false) goto L5;
        return null;
    L5:
        FqName r0 = r6.parent();
        Intrinsics.checkNotNullExpressionValue(r0, "fqName.parent()");
        MemberScope r1 = r5.getPackage(r0).getMemberScope();
        Name r3 = r6.shortName();
        Intrinsics.checkNotNullExpressionValue(r3, "fqName.shortName()");
        ClassifierDescriptor r2 = r1.mo2085getContributedClassifier(r3, r7);
        if ((r2 instanceof ClassDescriptor) == false) goto L8;
        ClassDescriptor r4 = (ClassDescriptor) r2;
    L9:
        if (r4 == null) goto L11;
        return r4;
    L11:
        FqName r8 = r6.parent();
        Intrinsics.checkNotNullExpressionValue(r8, "fqName.parent()");
        ClassDescriptor r9 = resolveClassByFqName(r5, r8, r7);
        if (r9 == null) goto L16;
        MemberScope r10 = r9.getUnsubstitutedInnerClassesScope();
        if (r10 == null) goto L16;
        Name r11 = r6.shortName();
        Intrinsics.checkNotNullExpressionValue(r11, "fqName.shortName()");
        ClassifierDescriptor r12 = r10.mo2085getContributedClassifier(r11, r7);
    L18:
        if ((r12 instanceof ClassDescriptor) == true) goto L20;
        return null;
    L20:
        return (ClassDescriptor) r12;
    L16:
        r12 = null;
        goto L18
    L8:
        r4 = null;
        goto L9
    }

    public static final boolean isTopLevelInPackage(DeclarationDescriptor r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return r1.getContainingDeclaration() instanceof PackageFragmentDescriptor;
    }

    public static final ClassifierDescriptor getTopLevelContainingClassifier(DeclarationDescriptor r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        DeclarationDescriptor r0 = r2.getContainingDeclaration();
        if (r0 != null) goto L5;
        return null;
    L5:
        if ((r2 instanceof PackageFragmentDescriptor) == false) goto L8;
        return null;
    L8:
        if (isTopLevelInPackage(r0) == true) goto L11;
        return getTopLevelContainingClassifier(r0);
    L11:
        if ((r0 instanceof ClassifierDescriptor) == true) goto L13;
        return null;
    L13:
        return (ClassifierDescriptor) r0;
    }
}
