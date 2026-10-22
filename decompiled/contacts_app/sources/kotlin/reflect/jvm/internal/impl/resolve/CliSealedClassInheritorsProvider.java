package kotlin.reflect.jvm.internal.impl.resolve;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope;

/* JADX INFO: compiled from: SealedClassInheritorsProvider.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class CliSealedClassInheritorsProvider extends SealedClassInheritorsProvider {
    public static final CliSealedClassInheritorsProvider INSTANCE = null;

    static {
        INSTANCE = new CliSealedClassInheritorsProvider();
    }

    private CliSealedClassInheritorsProvider() {
    }

    public Collection<ClassDescriptor> computeSealedSubclasses(ClassDescriptor r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r4, "sealedClass");
        if (r4.getModality() != Modality.SEALED) goto L5;
        LinkedHashSet r3 = new LinkedHashSet();
        if (r5 == true) goto L9;
        DeclarationDescriptor r0 = r4.getContainingDeclaration();
    L18:
        if ((r0 instanceof PackageFragmentDescriptor) == false) goto L20;
        computeSealedSubclasses$collectSubclasses(r4, r3, ((PackageFragmentDescriptor) r0).getMemberScope(), r5);
    L20:
        MemberScope r6 = r4.getUnsubstitutedInnerClassesScope();
        Intrinsics.checkNotNullExpressionValue(r6, "sealedClass.unsubstitutedInnerClassesScope");
        computeSealedSubclasses$collectSubclasses(r4, r3, r6, true);
        return CollectionsKt.sortedWith(r3, new CliSealedClassInheritorsProvider$computeSealedSubclasses$$inlined$sortedBy$1());
    L9:
        Iterator<DeclarationDescriptor> r1 = DescriptorUtilsKt.getParents(r4).iterator();
    L11:
        if (r1.hasNext() == false) goto L15;
        DeclarationDescriptor r2 = r1.next();
        if ((r2 instanceof PackageFragmentDescriptor) == false) goto L11;
    L16:
        r0 = r2;
        goto L18
    L15:
        r2 = null;
        goto L16
    L5:
        return CollectionsKt.emptyList();
    }

    private static final void computeSealedSubclasses$collectSubclasses(ClassDescriptor r4, LinkedHashSet<ClassDescriptor> r5, MemberScope r6, boolean r7) {
        Iterator r0 = ResolutionScope.DefaultImpls.getContributedDescriptors$default(r6, DescriptorKindFilter.CLASSIFIERS, null, 2, null).iterator();
    L4:
        if (r0.hasNext() == false) goto L23;
        DeclarationDescriptor r1 = (DeclarationDescriptor) r0.next();
        if ((r1 instanceof ClassDescriptor) == false) goto L4;
        ClassDescriptor r2 = (ClassDescriptor) r1;
        if (r2.isExpect() == false) goto L16;
        Name r3 = r2.getName();
        Intrinsics.checkNotNullExpressionValue(r3, "descriptor.name");
        ClassifierDescriptor r8 = r6.mo2085getContributedClassifier(r3, NoLookupLocation.WHEN_GET_ALL_DESCRIPTORS);
        if ((r8 instanceof ClassDescriptor) == false) goto L13;
        r2 = (ClassDescriptor) r8;
        goto L16
    L13:
        if ((r8 instanceof TypeAliasDescriptor) == false) goto L15;
        r2 = ((TypeAliasDescriptor) r8).getClassDescriptor();
        goto L16
    L15:
        r2 = null;
    L16:
        if (r2 == null) goto L4;
        if (DescriptorUtils.isDirectSubclass(r2, r4) == false) goto L21;
        r5.add(r2);
    L21:
        if (r7 == false) goto L4;
        MemberScope r9 = r2.getUnsubstitutedInnerClassesScope();
        Intrinsics.checkNotNullExpressionValue(r9, "refinedDescriptor.unsubstitutedInnerClassesScope");
        computeSealedSubclasses$collectSubclasses(r4, r5, r9, r7);
        goto L4
    }
}
