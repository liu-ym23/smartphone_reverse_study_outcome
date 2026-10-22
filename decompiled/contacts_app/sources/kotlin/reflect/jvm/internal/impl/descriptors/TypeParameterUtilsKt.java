package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils;
import kotlin.sequences.SequencesKt;

/* JADX INFO: compiled from: typeParameterUtils.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class TypeParameterUtilsKt {
    public static final List<TypeParameterDescriptor> computeConstructorTypeParameters(ClassifierDescriptorWithTypeParameters r8) {
        Intrinsics.checkNotNullParameter(r8, "<this>");
        List<TypeParameterDescriptor> r0 = r8.getDeclaredTypeParameters();
        Intrinsics.checkNotNullExpressionValue(r0, "declaredTypeParameters");
        if (r8.isInner() == false) goto L5;
    L7:
        ClassifierDescriptorWithTypeParameters r2 = r8;
        List r3 = SequencesKt.toList(SequencesKt.flatMap(SequencesKt.filter(SequencesKt.takeWhile(DescriptorUtilsKt.getParents(r2), TypeParameterUtilsKt$computeConstructorTypeParameters$parametersFromContainingFunctions$1.INSTANCE), TypeParameterUtilsKt$computeConstructorTypeParameters$parametersFromContainingFunctions$2.INSTANCE), TypeParameterUtilsKt$computeConstructorTypeParameters$parametersFromContainingFunctions$3.INSTANCE));
        Iterator<DeclarationDescriptor> r4 = DescriptorUtilsKt.getParents(r2).iterator();
    L8:
        List<TypeParameterDescriptor> r6 = null;
        if (r4.hasNext() == false) goto L13;
        DeclarationDescriptor r5 = r4.next();
        if ((r5 instanceof ClassDescriptor) == false) goto L8;
    L14:
        ClassDescriptor r7 = (ClassDescriptor) r5;
        if (r7 == null) goto L19;
        TypeConstructor r9 = r7.getTypeConstructor();
        if (r9 == null) goto L19;
        r6 = r9.getParameters();
    L19:
        if (r6 != null) goto L22;
        r6 = CollectionsKt.emptyList();
    L22:
        if (r3.isEmpty() == true) goto L24;
    L27:
        List r10 = CollectionsKt.plus(r3, r6);
        ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r10, 10));
        Iterator r11 = r10.iterator();
    L29:
        if (r11.hasNext() == false) goto L32;
        TypeParameterDescriptor r12 = (TypeParameterDescriptor) r11.next();
        Intrinsics.checkNotNullExpressionValue(r12, "it");
        r1.add(capturedCopyForInnerDeclaration(r12, r2, r0.size()));
        goto L29
    L32:
        return CollectionsKt.plus(r0, r1);
    L24:
        if (r6.isEmpty() == false) goto L27;
        List<TypeParameterDescriptor> r13 = r8.getDeclaredTypeParameters();
        Intrinsics.checkNotNullExpressionValue(r13, "declaredTypeParameters");
        return r13;
    L13:
        r5 = null;
        goto L14
    L5:
        if ((r8.getContainingDeclaration() instanceof CallableDescriptor) == true) goto L7;
        return r0;
    }

    private static final CapturedTypeParameterDescriptor capturedCopyForInnerDeclaration(TypeParameterDescriptor r1, DeclarationDescriptor r2, int r3) {
        return new CapturedTypeParameterDescriptor(r1, r2, r3);
    }

    public static final PossiblyInnerType buildPossiblyInnerType(KotlinType r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        ClassifierDescriptor r0 = r2.getConstructor().mo2083getDeclarationDescriptor();
        if ((r0 instanceof ClassifierDescriptorWithTypeParameters) == false) goto L5;
        ClassifierDescriptorWithTypeParameters r1 = (ClassifierDescriptorWithTypeParameters) r0;
    L7:
        return buildPossiblyInnerType(r2, r1, 0);
    L5:
        r1 = null;
        goto L7
    }

    private static final PossiblyInnerType buildPossiblyInnerType(KotlinType r5, ClassifierDescriptorWithTypeParameters r6, int r7) {
        ClassifierDescriptorWithTypeParameters r0 = null;
        if (r6 == null) goto L19;
        ClassifierDescriptorWithTypeParameters r1 = r6;
        if (ErrorUtils.isError(r1) == true) goto L19;
        int r2 = r6.getDeclaredTypeParameters().size() + r7;
        if (r6.isInner() == false) goto L10;
        List<TypeProjection> r8 = r5.getArguments().subList(r7, r2);
        DeclarationDescriptor r3 = r6.getContainingDeclaration();
        if ((r3 instanceof ClassifierDescriptorWithTypeParameters) == false) goto L18;
        r0 = (ClassifierDescriptorWithTypeParameters) r3;
    L18:
        return new PossiblyInnerType(r6, r8, buildPossiblyInnerType(r5, r0, r2));
    L10:
        if (r2 == r5.getArguments().size()) goto L13;
        DescriptorUtils.isLocal(r1);
    L13:
        return new PossiblyInnerType(r6, r5.getArguments().subList(r7, r5.getArguments().size()), null);
    L19:
        return null;
    }
}
