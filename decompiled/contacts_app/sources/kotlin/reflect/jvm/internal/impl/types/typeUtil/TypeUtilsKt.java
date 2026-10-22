package kotlin.reflect.jvm.internal.impl.types.typeUtil;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.types.AbstractStubType;
import kotlin.reflect.jvm.internal.impl.types.DefinitelyNotNullType;
import kotlin.reflect.jvm.internal.impl.types.FlexibleType;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.StarProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.StubTypeForBuilderInference;
import kotlin.reflect.jvm.internal.impl.types.TypeAttributesKt;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutionKt;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.TypeWithEnhancementKt;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorType;

/* JADX INFO: compiled from: TypeUtils.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class TypeUtilsKt {
    public static final boolean hasTypeParameterRecursiveBounds(TypeParameterDescriptor r2) {
        Intrinsics.checkNotNullParameter(r2, "typeParameter");
        return hasTypeParameterRecursiveBounds$default(r2, null, null, 6, null);
    }

    public static final KotlinBuiltIns getBuiltIns(KotlinType r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        KotlinBuiltIns r2 = r1.getConstructor().getBuiltIns();
        Intrinsics.checkNotNullExpressionValue(r2, "constructor.builtIns");
        return r2;
    }

    public static final KotlinType makeNullable(KotlinType r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        KotlinType r2 = TypeUtils.makeNullable(r1);
        Intrinsics.checkNotNullExpressionValue(r2, "makeNullable(this)");
        return r2;
    }

    public static final KotlinType makeNotNullable(KotlinType r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        KotlinType r2 = TypeUtils.makeNotNullable(r1);
        Intrinsics.checkNotNullExpressionValue(r2, "makeNotNullable(this)");
        return r2;
    }

    public static final boolean isTypeParameter(KotlinType r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return TypeUtils.isTypeParameter(r1);
    }

    public static final boolean containsTypeParameter(KotlinType r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return TypeUtils.contains(r1, C04841.INSTANCE);
    }

    public static final boolean isSubtypeOf(KotlinType r1, KotlinType r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "superType");
        return KotlinTypeChecker.DEFAULT.isSubtypeOf(r1, r2);
    }

    public static final KotlinType replaceAnnotations(KotlinType r1, Annotations r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "newAnnotations");
        if (r1.getAnnotations().isEmpty() == false) goto L8;
        if (r2.isEmpty() == false) goto L8;
        return r1;
    L8:
        return r1.unwrap().replaceAttributes(TypeAttributesKt.replaceAnnotations(r1.getAttributes(), r2));
    }

    public static final TypeProjection createProjection(KotlinType r1, Variance r2, TypeParameterDescriptor r3) {
        Intrinsics.checkNotNullParameter(r1, "type");
        Intrinsics.checkNotNullParameter(r2, "projectionKind");
        if (r3 == null) goto L5;
        Variance r4 = r3.getVariance();
    L6:
        if (r4 != r2) goto L9;
        r2 = Variance.INVARIANT;
    L9:
        return new TypeProjectionImpl(r2, r1);
    L5:
        r4 = null;
        goto L6
    }

    public static final TypeProjection asTypeProjection(KotlinType r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return new TypeProjectionImpl(r1);
    }

    public static final boolean contains(KotlinType r1, Function1<? super UnwrappedType, Boolean> r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "predicate");
        return TypeUtils.contains(r1, r2);
    }

    public static final Set<TypeParameterDescriptor> extractTypeParametersFromUpperBounds(KotlinType r1, Set<? extends TypeParameterDescriptor> r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        LinkedHashSet r0 = new LinkedHashSet();
        extractTypeParametersFromUpperBounds(r1, r1, r0, r2);
        return r0;
    }

    private static final void extractTypeParametersFromUpperBounds(KotlinType r7, KotlinType r8, Set<TypeParameterDescriptor> r9, Set<? extends TypeParameterDescriptor> r10) {
        ClassifierDescriptor r0 = r7.getConstructor().mo2083getDeclarationDescriptor();
        if ((r0 instanceof TypeParameterDescriptor) == true) goto L5;
        ClassifierDescriptor r1 = r7.getConstructor().mo2083getDeclarationDescriptor();
        if ((r1 instanceof ClassifierDescriptorWithTypeParameters) == false) goto L14;
        ClassifierDescriptorWithTypeParameters r2 = (ClassifierDescriptorWithTypeParameters) r1;
    L15:
        if (r2 == null) goto L17;
        List<TypeParameterDescriptor> r3 = r2.getDeclaredTypeParameters();
    L18:
        Iterator<TypeProjection> r11 = r7.getArguments().iterator();
        int r4 = 0;
    L20:
        if (r11.hasNext() == false) goto L51;
        int r5 = r4 + 1;
        TypeProjection r6 = r11.next();
        if (r3 == null) goto L24;
        TypeParameterDescriptor r12 = (TypeParameterDescriptor) CollectionsKt.getOrNull(r3, r4);
    L25:
        if (r12 == null) goto L30;
        if (r10 == null) goto L30;
        if (r10.contains(r12) == false) goto L30;
        boolean r13 = true;
    L31:
        if (r13 == true) goto L41;
        if (r6.isStarProjection() == true) goto L41;
        if (CollectionsKt.contains(r9, r6.getType().getConstructor().mo2083getDeclarationDescriptor()) == true) goto L41;
        if (Intrinsics.areEqual(r6.getType().getConstructor(), r8.getConstructor()) == true) goto L41;
        KotlinType r14 = r6.getType();
        Intrinsics.checkNotNullExpressionValue(r14, "argument.type");
        extractTypeParametersFromUpperBounds(r14, r8, r9, r10);
    L41:
        r4 = r5;
    L30:
        r13 = false;
        goto L31
    L24:
        r12 = null;
        goto L25
    L51:
        return;
    L17:
        r3 = null;
        goto L18
    L14:
        r2 = null;
        goto L15
    L5:
        if (Intrinsics.areEqual(r7.getConstructor(), r8.getConstructor()) == true) goto L7;
        r9.add(r0);
        return;
    L7:
        Iterator<KotlinType> r15 = ((TypeParameterDescriptor) r0).getUpperBounds().iterator();
    L9:
        if (r15.hasNext() == false) goto L50;
        KotlinType r16 = r15.next();
        Intrinsics.checkNotNullExpressionValue(r16, "upperBound");
        extractTypeParametersFromUpperBounds(r16, r8, r9, r10);
        goto L9
    }

    public static /* synthetic */ boolean hasTypeParameterRecursiveBounds$default(TypeParameterDescriptor r1, TypeConstructor r2, Set r3, int r4, Object r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 4) == 0) goto L9;
        r3 = null;
    L9:
        return hasTypeParameterRecursiveBounds(r1, r2, r3);
    }

    public static final boolean hasTypeParameterRecursiveBounds(TypeParameterDescriptor r5, TypeConstructor r6, Set<? extends TypeParameterDescriptor> r7) {
        Intrinsics.checkNotNullParameter(r5, "typeParameter");
        List<KotlinType> r0 = r5.getUpperBounds();
        Intrinsics.checkNotNullExpressionValue(r0, "typeParameter.upperBounds");
        List<KotlinType> r1 = r0;
        if ((r1 instanceof Collection) == true) goto L5;
    L7:
        Iterator<T> r2 = r1.iterator();
    L9:
        if (r2.hasNext() == false) goto L26;
        KotlinType r3 = (KotlinType) r2.next();
        Intrinsics.checkNotNullExpressionValue(r3, "upperBound");
        if (containsSelfTypeParameter(r3, r5.getDefaultType().getConstructor(), r7) == false) goto L16;
        if (r6 != null) goto L14;
    L15:
        boolean r4 = true;
    L17:
        if (r4 == false) goto L9;
        return true;
    L14:
        if (Intrinsics.areEqual(r3.getConstructor(), r6) == true) goto L15;
    L16:
        r4 = false;
        goto L17
    L26:
        return false;
    L5:
        if (r1.isEmpty() == false) goto L7;
        return false;
    }

    private static final boolean containsSelfTypeParameter(KotlinType r6, TypeConstructor r7, Set<? extends TypeParameterDescriptor> r8) {
        if (Intrinsics.areEqual(r6.getConstructor(), r7) == false) goto L5;
        return true;
    L5:
        ClassifierDescriptor r0 = r6.getConstructor().mo2083getDeclarationDescriptor();
        if ((r0 instanceof ClassifierDescriptorWithTypeParameters) == false) goto L8;
        ClassifierDescriptorWithTypeParameters r1 = (ClassifierDescriptorWithTypeParameters) r0;
    L9:
        if (r1 == null) goto L11;
        List<TypeParameterDescriptor> r2 = r1.getDeclaredTypeParameters();
    L12:
        Iterable r9 = CollectionsKt.withIndex(r6.getArguments());
        if ((r9 instanceof Collection) == true) goto L15;
    L17:
        Iterator r10 = r9.iterator();
    L19:
        if (r10.hasNext() == false) goto L37;
        IndexedValue r3 = (IndexedValue) r10.next();
        int r5 = r3.component1();
        TypeProjection r4 = (TypeProjection) r3.component2();
        if (r2 == null) goto L23;
        TypeParameterDescriptor r11 = (TypeParameterDescriptor) CollectionsKt.getOrNull(r2, r5);
    L24:
        if (r11 == null) goto L29;
        if (r8 == null) goto L29;
        if (r8.contains(r11) == false) goto L29;
        boolean r12 = true;
    L30:
        if (r12 == false) goto L32;
    L35:
        boolean r13 = false;
    L36:
        if (r13 == false) goto L19;
        return true;
    L32:
        if (r4.isStarProjection() == true) goto L35;
        KotlinType r14 = r4.getType();
        Intrinsics.checkNotNullExpressionValue(r14, "argument.type");
        r13 = containsSelfTypeParameter(r14, r7, r8);
    L29:
        r12 = false;
        goto L30
    L23:
        r11 = null;
    L37:
        return false;
    L15:
        if (((Collection) r9).isEmpty() == false) goto L17;
    L11:
        r2 = null;
        goto L12
    L8:
        r1 = null;
        goto L9
    }

    public static final boolean containsTypeAliasParameters(KotlinType r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return contains(r1, AnonymousClass1.INSTANCE);
    }

    public static final boolean isTypeAliasParameter(ClassifierDescriptor r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if ((r1 instanceof TypeParameterDescriptor) == true) goto L5;
    L7:
        return false;
    L5:
        if ((((TypeParameterDescriptor) r1).getContainingDeclaration() instanceof TypeAliasDescriptor) == false) goto L7;
        return true;
    }

    public static final boolean requiresTypeAliasExpansion(KotlinType r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return contains(r1, C04851.INSTANCE);
    }

    public static final KotlinType getRepresentativeUpperBound(TypeParameterDescriptor r7) {
        Intrinsics.checkNotNullParameter(r7, "<this>");
        List<KotlinType> r0 = r7.getUpperBounds();
        Intrinsics.checkNotNullExpressionValue(r0, "upperBounds");
        r0.isEmpty();
        List<KotlinType> r1 = r7.getUpperBounds();
        Intrinsics.checkNotNullExpressionValue(r1, "upperBounds");
        Iterator<T> r2 = r1.iterator();
    L3:
        Object r3 = null;
        ClassDescriptor r4 = null;
        if (r2.hasNext() == false) goto L18;
        Object r5 = r2.next();
        ClassifierDescriptor r6 = ((KotlinType) r5).getConstructor().mo2083getDeclarationDescriptor();
        if ((r6 instanceof ClassDescriptor) == false) goto L8;
        r4 = (ClassDescriptor) r6;
    L8:
        boolean r8 = false;
        if (r4 == null) goto L16;
        if (r4.getKind() == ClassKind.INTERFACE) goto L16;
        if (r4.getKind() == ClassKind.ANNOTATION_CLASS) goto L16;
        r8 = true;
    L16:
        if (r8 == false) goto L3;
        r3 = r5;
    L18:
        KotlinType r9 = (KotlinType) r3;
        if (r9 != null) goto L29;
        List<KotlinType> r10 = r7.getUpperBounds();
        Intrinsics.checkNotNullExpressionValue(r10, "upperBounds");
        Object r11 = CollectionsKt.first(r10);
        Intrinsics.checkNotNullExpressionValue(r11, "upperBounds.first()");
        return (KotlinType) r11;
    L29:
        return r9;
    }

    public static final boolean shouldBeUpdated(KotlinType r1) {
        if (r1 != null) goto L4;
    L7:
        return true;
    L4:
        if (contains(r1, C04861.INSTANCE) == true) goto L7;
        return false;
    }

    public static final boolean isStubType(KotlinType r3) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        if ((r3 instanceof AbstractStubType) == false) goto L5;
        return true;
    L5:
        if ((r3 instanceof DefinitelyNotNullType) == true) goto L7;
    L9:
        boolean r4 = false;
    L10:
        if (r4 == false) goto L13;
        return true;
    L13:
        return false;
    L7:
        if ((((DefinitelyNotNullType) r3).getOriginal() instanceof AbstractStubType) == false) goto L9;
        r4 = true;
        goto L10
    }

    public static final boolean isStubTypeForBuilderInference(KotlinType r3) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        if ((r3 instanceof StubTypeForBuilderInference) == false) goto L5;
        return true;
    L5:
        if ((r3 instanceof DefinitelyNotNullType) == true) goto L7;
    L9:
        boolean r4 = false;
    L10:
        if (r4 == false) goto L13;
        return true;
    L13:
        return false;
    L7:
        if ((((DefinitelyNotNullType) r3).getOriginal() instanceof StubTypeForBuilderInference) == false) goto L9;
        r4 = true;
        goto L10
    }

    public static final boolean isUnresolvedType(KotlinType r1) {
        Intrinsics.checkNotNullParameter(r1, "type");
        if ((r1 instanceof ErrorType) == true) goto L5;
    L7:
        return false;
    L5:
        if (((ErrorType) r1).getKind().isUnresolved() == false) goto L7;
        return true;
    }

    public static final KotlinType replaceArgumentsWithStarProjections(KotlinType r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        UnwrappedType r11 = r10.unwrap();
        if ((r11 instanceof FlexibleType) == false) goto L26;
        FlexibleType r0 = (FlexibleType) r11;
        SimpleType r5 = r0.getLowerBound();
        if (r5.getConstructor().getParameters().isEmpty() == false) goto L7;
    L14:
        SimpleType r1 = r0.getUpperBound();
        if (r1.getConstructor().getParameters().isEmpty() == false) goto L17;
    L24:
        SimpleType r2 = KotlinTypeFactory.flexibleType(r5, r1);
    L39:
        return TypeWithEnhancementKt.inheritEnhancement(r2, r11);
    L17:
        if (r1.getConstructor().mo2083getDeclarationDescriptor() == null) goto L24;
        List<TypeParameterDescriptor> r6 = r1.getConstructor().getParameters();
        Intrinsics.checkNotNullExpressionValue(r6, "constructor.parameters");
        List<TypeParameterDescriptor> r7 = r6;
        ArrayList r3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r7, 10));
        Iterator<T> r4 = r7.iterator();
    L21:
        if (r4.hasNext() == false) goto L23;
        r3.add(new StarProjectionImpl((TypeParameterDescriptor) r4.next()));
        goto L21
    L23:
        r1 = TypeSubstitutionKt.replace$default(r1, r3, null, 2, null);
        goto L24
    L7:
        if (r5.getConstructor().mo2083getDeclarationDescriptor() == null) goto L14;
        List<TypeParameterDescriptor> r8 = r5.getConstructor().getParameters();
        Intrinsics.checkNotNullExpressionValue(r8, "constructor.parameters");
        List<TypeParameterDescriptor> r9 = r8;
        ArrayList r12 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r9, 10));
        Iterator<T> r13 = r9.iterator();
    L11:
        if (r13.hasNext() == false) goto L13;
        r12.add(new StarProjectionImpl((TypeParameterDescriptor) r13.next()));
        goto L11
    L13:
        r5 = TypeSubstitutionKt.replace$default(r5, r12, null, 2, null);
        goto L14
    L26:
        if ((r11 instanceof SimpleType) == false) goto L41;
        SimpleType r14 = (SimpleType) r11;
        if (r14.getConstructor().getParameters().isEmpty() == false) goto L30;
    L37:
        r2 = r14;
        goto L39
    L30:
        if (r14.getConstructor().mo2083getDeclarationDescriptor() == null) goto L37;
        List<TypeParameterDescriptor> r15 = r14.getConstructor().getParameters();
        Intrinsics.checkNotNullExpressionValue(r15, "constructor.parameters");
        List<TypeParameterDescriptor> r16 = r15;
        ArrayList r17 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r16, 10));
        Iterator<T> r18 = r16.iterator();
    L34:
        if (r18.hasNext() == false) goto L36;
        r17.add(new StarProjectionImpl((TypeParameterDescriptor) r18.next()));
        goto L34
    L36:
        r14 = TypeSubstitutionKt.replace$default(r14, r17, null, 2, null);
        goto L37
    L41:
        throw new NoWhenBranchMatchedException();
    }
}
