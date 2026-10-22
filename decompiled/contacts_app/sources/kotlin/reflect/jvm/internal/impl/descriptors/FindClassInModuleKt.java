package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.ResolutionAnchorProviderKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.sequences.SequencesKt;

/* JADX INFO: compiled from: findClassInModule.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class FindClassInModuleKt {
    public static final ClassDescriptor findClassAcrossModuleDependencies(ModuleDescriptor r1, ClassId r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "classId");
        ClassifierDescriptor r3 = findClassifierAcrossModuleDependencies(r1, r2);
        if ((r3 instanceof ClassDescriptor) == true) goto L7;
        return null;
    L7:
        return (ClassDescriptor) r3;
    }

    public static final ClassDescriptor findNonGenericClassAcrossDependencies(ModuleDescriptor r1, ClassId r2, NotFoundClasses r3) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "classId");
        Intrinsics.checkNotNullParameter(r3, "notFoundClasses");
        ClassDescriptor r4 = findClassAcrossModuleDependencies(r1, r2);
        if (r4 == null) goto L6;
        return r4;
    L6:
        return r3.getClass(r2, SequencesKt.toList(SequencesKt.map(SequencesKt.generateSequence(r2, FindClassInModuleKt$findNonGenericClassAcrossDependencies$typeParametersCount$1.INSTANCE), FindClassInModuleKt$findNonGenericClassAcrossDependencies$typeParametersCount$2.INSTANCE)));
    }

    public static final TypeAliasDescriptor findTypeAliasAcrossModuleDependencies(ModuleDescriptor r1, ClassId r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "classId");
        ClassifierDescriptor r3 = findClassifierAcrossModuleDependencies(r1, r2);
        if ((r3 instanceof TypeAliasDescriptor) == true) goto L7;
        return null;
    L7:
        return (TypeAliasDescriptor) r3;
    }

    public static final ClassifierDescriptor findClassifierAcrossModuleDependencies(ModuleDescriptor r10, ClassId r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "classId");
        ModuleDescriptor r0 = ResolutionAnchorProviderKt.getResolutionAnchorIfAny(r10);
        if (r0 != null) goto L20;
        FqName r1 = r11.getPackageFqName();
        Intrinsics.checkNotNullExpressionValue(r1, "classId.packageFqName");
        PackageViewDescriptor r12 = r10.getPackage(r1);
        List<Name> r13 = r11.getRelativeClassName().pathSegments();
        Intrinsics.checkNotNullExpressionValue(r13, "classId.relativeClassName.pathSegments()");
        MemberScope r14 = r12.getMemberScope();
        Object r2 = CollectionsKt.first(r13);
        Intrinsics.checkNotNullExpressionValue(r2, "segments.first()");
        ClassDescriptor r15 = r14.mo2085getContributedClassifier((Name) r2, NoLookupLocation.FROM_DESERIALIZATION);
        if (r15 == null) goto L63;
        Iterator<Name> r16 = r13.subList(1, r13.size()).iterator();
    L9:
        if (r16.hasNext() == false) goto L62;
        Name r3 = r16.next();
        if ((r15 instanceof ClassDescriptor) == false) goto L66;
        MemberScope r17 = ((ClassDescriptor) r15).getUnsubstitutedInnerClassesScope();
        Intrinsics.checkNotNullExpressionValue(r3, "name");
        ClassifierDescriptor r18 = r17.mo2085getContributedClassifier(r3, NoLookupLocation.FROM_DESERIALIZATION);
        if ((r18 instanceof ClassDescriptor) == false) goto L16;
        ClassDescriptor r19 = (ClassDescriptor) r18;
    L17:
        if (r19 == null) goto L65;
        r15 = r19;
        goto L9
    L65:
        return null;
    L16:
        r19 = null;
        goto L17
    L66:
        return null;
    L62:
        return r15;
    L63:
        return null;
    L20:
        FqName r7 = r11.getPackageFqName();
        Intrinsics.checkNotNullExpressionValue(r7, "classId.packageFqName");
        PackageViewDescriptor r4 = r0.getPackage(r7);
        List<Name> r8 = r11.getRelativeClassName().pathSegments();
        Intrinsics.checkNotNullExpressionValue(r8, "classId.relativeClassName.pathSegments()");
        MemberScope r5 = r4.getMemberScope();
        Object r9 = CollectionsKt.first(r8);
        Intrinsics.checkNotNullExpressionValue(r9, "segments.first()");
        ClassDescriptor r6 = r5.mo2085getContributedClassifier((Name) r9, NoLookupLocation.FROM_DESERIALIZATION);
        if (r6 != null) goto L23;
    L22:
        r6 = null;
    L35:
        if (r6 != null) goto L52;
        FqName r20 = r11.getPackageFqName();
        Intrinsics.checkNotNullExpressionValue(r20, "classId.packageFqName");
        PackageViewDescriptor r110 = r10.getPackage(r20);
        List<Name> r111 = r11.getRelativeClassName().pathSegments();
        Intrinsics.checkNotNullExpressionValue(r111, "classId.relativeClassName.pathSegments()");
        MemberScope r112 = r110.getMemberScope();
        Object r21 = CollectionsKt.first(r111);
        Intrinsics.checkNotNullExpressionValue(r21, "segments.first()");
        r15 = r112.mo2085getContributedClassifier((Name) r21, NoLookupLocation.FROM_DESERIALIZATION);
        if (r15 == null) goto L64;
        Iterator<Name> r113 = r111.subList(1, r111.size()).iterator();
    L41:
        if (r113.hasNext() == false) goto L62;
        Name r22 = r113.next();
        if ((r15 instanceof ClassDescriptor) == false) goto L68;
        MemberScope r114 = ((ClassDescriptor) r15).getUnsubstitutedInnerClassesScope();
        Intrinsics.checkNotNullExpressionValue(r22, "name");
        ClassifierDescriptor r115 = r114.mo2085getContributedClassifier(r22, NoLookupLocation.FROM_DESERIALIZATION);
        if ((r115 instanceof ClassDescriptor) == false) goto L48;
        ClassDescriptor r116 = (ClassDescriptor) r115;
    L49:
        if (r116 == null) goto L67;
        r15 = r116;
        goto L41
    L67:
        return null;
    L48:
        r116 = null;
        goto L49
    L68:
        return null;
    L64:
        return null;
    L52:
        return r6;
    L23:
        Iterator<Name> r23 = r8.subList(1, r8.size()).iterator();
    L25:
        if (r23.hasNext() == false) goto L35;
        Name r24 = r23.next();
        if ((r6 instanceof ClassDescriptor) == false) goto L22;
        MemberScope r25 = ((ClassDescriptor) r6).getUnsubstitutedInnerClassesScope();
        Intrinsics.checkNotNullExpressionValue(r24, "name");
        ClassifierDescriptor r26 = r25.mo2085getContributedClassifier(r24, NoLookupLocation.FROM_DESERIALIZATION);
        if ((r26 instanceof ClassDescriptor) == false) goto L32;
        ClassDescriptor r27 = (ClassDescriptor) r26;
    L33:
        if (r27 == null) goto L22;
        r6 = r27;
        goto L25
    L32:
        r27 = null;
        goto L33
    }
}
