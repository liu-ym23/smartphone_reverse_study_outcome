package kotlin.reflect.jvm.internal.impl.types;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;

/* JADX INFO: compiled from: StarProjectionImpl.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class StarProjectionImplKt {
    private static final KotlinType buildStarProjectionTypeByTypeParameters(final List<? extends TypeConstructor> r1, List<? extends KotlinType> r2, KotlinBuiltIns r3) {
        SimpleType r4 = TypeSubstitutor.create(new AnonymousClass1(r1)).substitute((KotlinType) CollectionsKt.first(r2), Variance.OUT_VARIANCE);
        if (r4 != null) goto L5;
        r4 = r3.getDefaultBound();
    L5:
        Intrinsics.checkNotNullExpressionValue(r4, "typeParameters: List<Typ… ?: builtIns.defaultBound");
        return r4;
    }

    public static final KotlinType starProjectionType(TypeParameterDescriptor r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        DeclarationDescriptor r0 = r5.getContainingDeclaration();
        Intrinsics.checkNotNullExpressionValue(r0, "this.containingDeclaration");
        if ((r0 instanceof ClassifierDescriptorWithTypeParameters) == false) goto L10;
        List<TypeParameterDescriptor> r1 = ((ClassifierDescriptorWithTypeParameters) r0).getTypeConstructor().getParameters();
        Intrinsics.checkNotNullExpressionValue(r1, "descriptor.typeConstructor.parameters");
        List<TypeParameterDescriptor> r2 = r1;
        ArrayList r3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r2, 10));
        Iterator<T> r4 = r2.iterator();
    L6:
        if (r4.hasNext() == false) goto L8;
        TypeConstructor r6 = ((TypeParameterDescriptor) r4.next()).getTypeConstructor();
        Intrinsics.checkNotNullExpressionValue(r6, "it.typeConstructor");
        r3.add(r6);
        goto L6
    L8:
        List<KotlinType> r7 = r5.getUpperBounds();
        Intrinsics.checkNotNullExpressionValue(r7, "upperBounds");
        return buildStarProjectionTypeByTypeParameters(r3, r7, DescriptorUtilsKt.getBuiltIns(r5));
    L10:
        if ((r0 instanceof FunctionDescriptor) == false) goto L18;
        List<TypeParameterDescriptor> r8 = ((FunctionDescriptor) r0).getTypeParameters();
        Intrinsics.checkNotNullExpressionValue(r8, "descriptor.typeParameters");
        List<TypeParameterDescriptor> r9 = r8;
        ArrayList r10 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r9, 10));
        Iterator<T> r11 = r9.iterator();
    L13:
        if (r11.hasNext() == false) goto L15;
        TypeConstructor r12 = ((TypeParameterDescriptor) r11.next()).getTypeConstructor();
        Intrinsics.checkNotNullExpressionValue(r12, "it.typeConstructor");
        r10.add(r12);
        goto L13
    L15:
        List<KotlinType> r13 = r5.getUpperBounds();
        Intrinsics.checkNotNullExpressionValue(r13, "upperBounds");
        return buildStarProjectionTypeByTypeParameters(r10, r13, DescriptorUtilsKt.getBuiltIns(r5));
    L18:
        throw new IllegalArgumentException("Unsupported descriptor type to build star projection type based on type parameters of it");
    }
}
