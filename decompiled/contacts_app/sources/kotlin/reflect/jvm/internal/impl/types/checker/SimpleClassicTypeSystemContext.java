package kotlin.reflect.jvm.internal.impl.types.checker;

import java.util.Collection;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.types.TypeCheckerState;
import kotlin.reflect.jvm.internal.impl.types.model.CaptureStatus;
import kotlin.reflect.jvm.internal.impl.types.model.CapturedTypeConstructorMarker;
import kotlin.reflect.jvm.internal.impl.types.model.CapturedTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.DefinitelyNotNullTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.DynamicTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.FlexibleTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.RawTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeArgumentListMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeArgumentMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeParameterMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeVariableTypeConstructorMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeVariance;

/* JADX INFO: compiled from: NewKotlinTypeChecker.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class SimpleClassicTypeSystemContext implements ClassicTypeSystemContext {
    public static final SimpleClassicTypeSystemContext INSTANCE = null;

    static {
        INSTANCE = new SimpleClassicTypeSystemContext();
    }

    private SimpleClassicTypeSystemContext() {
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public boolean areEqualTypeConstructors(TypeConstructorMarker r1, TypeConstructorMarker r2) {
        return ClassicTypeSystemContext.DefaultImpls.areEqualTypeConstructors(this, r1, r2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public int argumentsCount(KotlinTypeMarker r1) {
        return ClassicTypeSystemContext.DefaultImpls.argumentsCount(this, r1);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public TypeArgumentListMarker asArgumentList(SimpleTypeMarker r1) {
        return ClassicTypeSystemContext.DefaultImpls.asArgumentList(this, r1);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext, kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public CapturedTypeMarker asCapturedType(SimpleTypeMarker r1) {
        return ClassicTypeSystemContext.DefaultImpls.asCapturedType(this, r1);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public DefinitelyNotNullTypeMarker asDefinitelyNotNullType(SimpleTypeMarker r1) {
        return ClassicTypeSystemContext.DefaultImpls.asDefinitelyNotNullType(this, r1);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public DynamicTypeMarker asDynamicType(FlexibleTypeMarker r1) {
        return ClassicTypeSystemContext.DefaultImpls.asDynamicType(this, r1);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public FlexibleTypeMarker asFlexibleType(KotlinTypeMarker r1) {
        return ClassicTypeSystemContext.DefaultImpls.asFlexibleType(this, r1);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public RawTypeMarker asRawType(FlexibleTypeMarker r1) {
        return ClassicTypeSystemContext.DefaultImpls.asRawType(this, r1);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext, kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public SimpleTypeMarker asSimpleType(KotlinTypeMarker r1) {
        return ClassicTypeSystemContext.DefaultImpls.asSimpleType(this, r1);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public TypeArgumentMarker asTypeArgument(KotlinTypeMarker r1) {
        return ClassicTypeSystemContext.DefaultImpls.asTypeArgument(this, r1);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public SimpleTypeMarker captureFromArguments(SimpleTypeMarker r1, CaptureStatus r2) {
        return ClassicTypeSystemContext.DefaultImpls.captureFromArguments(this, r1, r2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public CaptureStatus captureStatus(CapturedTypeMarker r1) {
        return ClassicTypeSystemContext.DefaultImpls.captureStatus(this, r1);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext
    public KotlinTypeMarker createFlexibleType(SimpleTypeMarker r1, SimpleTypeMarker r2) {
        return ClassicTypeSystemContext.DefaultImpls.createFlexibleType(this, r1, r2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public List<SimpleTypeMarker> fastCorrespondingSupertypes(SimpleTypeMarker r1, TypeConstructorMarker r2) {
        return ClassicTypeSystemContext.DefaultImpls.fastCorrespondingSupertypes(this, r1, r2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public TypeArgumentMarker get(TypeArgumentListMarker r1, int r2) {
        return ClassicTypeSystemContext.DefaultImpls.get(this, r1, r2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public TypeArgumentMarker getArgument(KotlinTypeMarker r1, int r2) {
        return ClassicTypeSystemContext.DefaultImpls.getArgument(this, r1, r2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public TypeArgumentMarker getArgumentOrNull(SimpleTypeMarker r1, int r2) {
        return ClassicTypeSystemContext.DefaultImpls.getArgumentOrNull(this, r1, r2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public List<TypeArgumentMarker> getArguments(KotlinTypeMarker r1) {
        return ClassicTypeSystemContext.DefaultImpls.getArguments(this, r1);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeSystemCommonBackendContext
    public FqNameUnsafe getClassFqNameUnsafe(TypeConstructorMarker r1) {
        return ClassicTypeSystemContext.DefaultImpls.getClassFqNameUnsafe(this, r1);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public TypeParameterMarker getParameter(TypeConstructorMarker r1, int r2) {
        return ClassicTypeSystemContext.DefaultImpls.getParameter(this, r1, r2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public List<TypeParameterMarker> getParameters(TypeConstructorMarker r1) {
        return ClassicTypeSystemContext.DefaultImpls.getParameters(this, r1);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeSystemCommonBackendContext
    public PrimitiveType getPrimitiveArrayType(TypeConstructorMarker r1) {
        return ClassicTypeSystemContext.DefaultImpls.getPrimitiveArrayType(this, r1);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeSystemCommonBackendContext
    public PrimitiveType getPrimitiveType(TypeConstructorMarker r1) {
        return ClassicTypeSystemContext.DefaultImpls.getPrimitiveType(this, r1);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeSystemCommonBackendContext
    public KotlinTypeMarker getRepresentativeUpperBound(TypeParameterMarker r1) {
        return ClassicTypeSystemContext.DefaultImpls.getRepresentativeUpperBound(this, r1);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public KotlinTypeMarker getType(TypeArgumentMarker r1) {
        return ClassicTypeSystemContext.DefaultImpls.getType(this, r1);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public TypeParameterMarker getTypeParameter(TypeVariableTypeConstructorMarker r1) {
        return ClassicTypeSystemContext.DefaultImpls.getTypeParameter(this, r1);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public TypeParameterMarker getTypeParameterClassifier(TypeConstructorMarker r1) {
        return ClassicTypeSystemContext.DefaultImpls.getTypeParameterClassifier(this, r1);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeSystemCommonBackendContext
    public KotlinTypeMarker getUnsubstitutedUnderlyingType(KotlinTypeMarker r1) {
        return ClassicTypeSystemContext.DefaultImpls.getUnsubstitutedUnderlyingType(this, r1);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public List<KotlinTypeMarker> getUpperBounds(TypeParameterMarker r1) {
        return ClassicTypeSystemContext.DefaultImpls.getUpperBounds(this, r1);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public TypeVariance getVariance(TypeArgumentMarker r1) {
        return ClassicTypeSystemContext.DefaultImpls.getVariance(this, r1);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public TypeVariance getVariance(TypeParameterMarker r1) {
        return ClassicTypeSystemContext.DefaultImpls.getVariance(this, r1);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeSystemCommonBackendContext
    public boolean hasAnnotation(KotlinTypeMarker r1, FqName r2) {
        return ClassicTypeSystemContext.DefaultImpls.hasAnnotation(this, r1, r2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public boolean hasFlexibleNullability(KotlinTypeMarker r1) {
        return ClassicTypeSystemContext.DefaultImpls.hasFlexibleNullability(this, r1);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public boolean hasRecursiveBounds(TypeParameterMarker r1, TypeConstructorMarker r2) {
        return ClassicTypeSystemContext.DefaultImpls.hasRecursiveBounds(this, r1, r2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemOptimizationContext
    public boolean identicalArguments(SimpleTypeMarker r1, SimpleTypeMarker r2) {
        return ClassicTypeSystemContext.DefaultImpls.identicalArguments(this, r1, r2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public KotlinTypeMarker intersectTypes(List<? extends KotlinTypeMarker> r1) {
        return ClassicTypeSystemContext.DefaultImpls.intersectTypes(this, r1);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public boolean isAnyConstructor(TypeConstructorMarker r1) {
        return ClassicTypeSystemContext.DefaultImpls.isAnyConstructor(this, r1);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public boolean isCapturedType(KotlinTypeMarker r1) {
        return ClassicTypeSystemContext.DefaultImpls.isCapturedType(this, r1);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public boolean isClassType(SimpleTypeMarker r1) {
        return ClassicTypeSystemContext.DefaultImpls.isClassType(this, r1);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public boolean isClassTypeConstructor(TypeConstructorMarker r1) {
        return ClassicTypeSystemContext.DefaultImpls.isClassTypeConstructor(this, r1);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public boolean isCommonFinalClassConstructor(TypeConstructorMarker r1) {
        return ClassicTypeSystemContext.DefaultImpls.isCommonFinalClassConstructor(this, r1);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public boolean isDefinitelyNotNullType(KotlinTypeMarker r1) {
        return ClassicTypeSystemContext.DefaultImpls.isDefinitelyNotNullType(this, r1);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public boolean isDenotable(TypeConstructorMarker r1) {
        return ClassicTypeSystemContext.DefaultImpls.isDenotable(this, r1);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public boolean isDynamic(KotlinTypeMarker r1) {
        return ClassicTypeSystemContext.DefaultImpls.isDynamic(this, r1);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public boolean isError(KotlinTypeMarker r1) {
        return ClassicTypeSystemContext.DefaultImpls.isError(this, r1);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeSystemCommonBackendContext
    public boolean isInlineClass(TypeConstructorMarker r1) {
        return ClassicTypeSystemContext.DefaultImpls.isInlineClass(this, r1);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public boolean isIntegerLiteralType(SimpleTypeMarker r1) {
        return ClassicTypeSystemContext.DefaultImpls.isIntegerLiteralType(this, r1);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public boolean isIntegerLiteralTypeConstructor(TypeConstructorMarker r1) {
        return ClassicTypeSystemContext.DefaultImpls.isIntegerLiteralTypeConstructor(this, r1);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public boolean isIntersection(TypeConstructorMarker r1) {
        return ClassicTypeSystemContext.DefaultImpls.isIntersection(this, r1);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public boolean isMarkedNullable(KotlinTypeMarker r1) {
        return ClassicTypeSystemContext.DefaultImpls.isMarkedNullable(this, r1);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public boolean isMarkedNullable(SimpleTypeMarker r1) {
        return ClassicTypeSystemContext.DefaultImpls.isMarkedNullable(this, r1);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public boolean isNotNullTypeParameter(KotlinTypeMarker r1) {
        return ClassicTypeSystemContext.DefaultImpls.isNotNullTypeParameter(this, r1);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public boolean isNothing(KotlinTypeMarker r1) {
        return ClassicTypeSystemContext.DefaultImpls.isNothing(this, r1);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public boolean isNothingConstructor(TypeConstructorMarker r1) {
        return ClassicTypeSystemContext.DefaultImpls.isNothingConstructor(this, r1);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public boolean isNullableType(KotlinTypeMarker r1) {
        return ClassicTypeSystemContext.DefaultImpls.isNullableType(this, r1);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public boolean isOldCapturedType(CapturedTypeMarker r1) {
        return ClassicTypeSystemContext.DefaultImpls.isOldCapturedType(this, r1);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public boolean isPrimitiveType(SimpleTypeMarker r1) {
        return ClassicTypeSystemContext.DefaultImpls.isPrimitiveType(this, r1);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public boolean isProjectionNotNull(CapturedTypeMarker r1) {
        return ClassicTypeSystemContext.DefaultImpls.isProjectionNotNull(this, r1);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext, kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public boolean isSingleClassifierType(SimpleTypeMarker r1) {
        return ClassicTypeSystemContext.DefaultImpls.isSingleClassifierType(this, r1);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public boolean isStarProjection(TypeArgumentMarker r1) {
        return ClassicTypeSystemContext.DefaultImpls.isStarProjection(this, r1);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public boolean isStubType(SimpleTypeMarker r1) {
        return ClassicTypeSystemContext.DefaultImpls.isStubType(this, r1);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public boolean isStubTypeForBuilderInference(SimpleTypeMarker r1) {
        return ClassicTypeSystemContext.DefaultImpls.isStubTypeForBuilderInference(this, r1);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public boolean isTypeVariableType(KotlinTypeMarker r1) {
        return ClassicTypeSystemContext.DefaultImpls.isTypeVariableType(this, r1);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeSystemCommonBackendContext
    public boolean isUnderKotlinPackage(TypeConstructorMarker r1) {
        return ClassicTypeSystemContext.DefaultImpls.isUnderKotlinPackage(this, r1);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext, kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public SimpleTypeMarker lowerBound(FlexibleTypeMarker r1) {
        return ClassicTypeSystemContext.DefaultImpls.lowerBound(this, r1);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public SimpleTypeMarker lowerBoundIfFlexible(KotlinTypeMarker r1) {
        return ClassicTypeSystemContext.DefaultImpls.lowerBoundIfFlexible(this, r1);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public KotlinTypeMarker lowerType(CapturedTypeMarker r1) {
        return ClassicTypeSystemContext.DefaultImpls.lowerType(this, r1);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public KotlinTypeMarker makeDefinitelyNotNullOrNotNull(KotlinTypeMarker r1) {
        return ClassicTypeSystemContext.DefaultImpls.makeDefinitelyNotNullOrNotNull(this, r1);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeSystemCommonBackendContext
    public KotlinTypeMarker makeNullable(KotlinTypeMarker r1) {
        return ClassicTypeSystemContext.DefaultImpls.makeNullable(this, r1);
    }

    public TypeCheckerState newTypeCheckerState(boolean r1, boolean r2) {
        return ClassicTypeSystemContext.DefaultImpls.newTypeCheckerState(this, r1, r2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public SimpleTypeMarker original(DefinitelyNotNullTypeMarker r1) {
        return ClassicTypeSystemContext.DefaultImpls.original(this, r1);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public int parametersCount(TypeConstructorMarker r1) {
        return ClassicTypeSystemContext.DefaultImpls.parametersCount(this, r1);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public Collection<KotlinTypeMarker> possibleIntegerTypes(SimpleTypeMarker r1) {
        return ClassicTypeSystemContext.DefaultImpls.possibleIntegerTypes(this, r1);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public TypeArgumentMarker projection(CapturedTypeConstructorMarker r1) {
        return ClassicTypeSystemContext.DefaultImpls.projection(this, r1);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public int size(TypeArgumentListMarker r1) {
        return ClassicTypeSystemContext.DefaultImpls.size(this, r1);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public TypeCheckerState.SupertypesPolicy substitutionSupertypePolicy(SimpleTypeMarker r1) {
        return ClassicTypeSystemContext.DefaultImpls.substitutionSupertypePolicy(this, r1);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public Collection<KotlinTypeMarker> supertypes(TypeConstructorMarker r1) {
        return ClassicTypeSystemContext.DefaultImpls.supertypes(this, r1);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public CapturedTypeConstructorMarker typeConstructor(CapturedTypeMarker r1) {
        return ClassicTypeSystemContext.DefaultImpls.typeConstructor(this, r1);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public TypeConstructorMarker typeConstructor(KotlinTypeMarker r1) {
        return ClassicTypeSystemContext.DefaultImpls.typeConstructor(this, r1);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext, kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public TypeConstructorMarker typeConstructor(SimpleTypeMarker r1) {
        return ClassicTypeSystemContext.DefaultImpls.typeConstructor(this, r1);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext, kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public SimpleTypeMarker upperBound(FlexibleTypeMarker r1) {
        return ClassicTypeSystemContext.DefaultImpls.upperBound(this, r1);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public SimpleTypeMarker upperBoundIfFlexible(KotlinTypeMarker r1) {
        return ClassicTypeSystemContext.DefaultImpls.upperBoundIfFlexible(this, r1);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public KotlinTypeMarker withNullability(KotlinTypeMarker r1, boolean r2) {
        return ClassicTypeSystemContext.DefaultImpls.withNullability(this, r1, r2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext, kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public SimpleTypeMarker withNullability(SimpleTypeMarker r1, boolean r2) {
        return ClassicTypeSystemContext.DefaultImpls.withNullability(this, r1, r2);
    }
}
