package kotlin.reflect.jvm.internal.impl.types.model;

import java.util.Collection;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.jvm.internal.impl.types.TypeCheckerState;

/* JADX INFO: compiled from: TypeSystemContext.kt */
/* JADX INFO: loaded from: classes4.dex */
public interface TypeSystemContext extends TypeSystemOptimizationContext {

    /* JADX INFO: compiled from: TypeSystemContext.kt */
    public static final class DefaultImpls {
        public static List<SimpleTypeMarker> fastCorrespondingSupertypes(TypeSystemContext r0, SimpleTypeMarker r1, TypeConstructorMarker r2) {
            Intrinsics.checkNotNullParameter(r1, "$receiver");
            Intrinsics.checkNotNullParameter(r2, "constructor");
            return null;
        }

        public static boolean isCapturedType(TypeSystemContext r1, KotlinTypeMarker r2) {
            Intrinsics.checkNotNullParameter(r2, "$receiver");
            SimpleTypeMarker r3 = r1.asSimpleType(r2);
            if (r3 == null) goto L5;
            CapturedTypeMarker r4 = r1.asCapturedType(r3);
        L6:
            if (r4 == null) goto L8;
            return true;
        L8:
            return false;
        L5:
            r4 = null;
            goto L6
        }

        public static boolean isMarkedNullable(TypeSystemContext r1, KotlinTypeMarker r2) {
            Intrinsics.checkNotNullParameter(r2, "$receiver");
            if ((r2 instanceof SimpleTypeMarker) == true) goto L5;
        L7:
            return false;
        L5:
            if (r1.isMarkedNullable((SimpleTypeMarker) r2) == false) goto L7;
            return true;
        }

        public static TypeArgumentMarker getArgumentOrNull(TypeSystemContext r2, SimpleTypeMarker r3, int r4) {
            Intrinsics.checkNotNullParameter(r3, "$receiver");
            boolean r0 = false;
            if (r4 >= 0) goto L5;
        L7:
            if (r0 == true) goto L9;
            return null;
        L9:
            return r2.getArgument(r3, r4);
        L5:
            if (r4 >= r2.argumentsCount(r3)) goto L7;
            r0 = true;
            goto L7
        }

        public static SimpleTypeMarker lowerBoundIfFlexible(TypeSystemContext r1, KotlinTypeMarker r2) {
            Intrinsics.checkNotNullParameter(r2, "$receiver");
            FlexibleTypeMarker r0 = r1.asFlexibleType(r2);
            if (r0 == null) goto L6;
            SimpleTypeMarker r3 = r1.lowerBound(r0);
            if (r3 == null) goto L6;
            return r3;
        L6:
            SimpleTypeMarker r4 = r1.asSimpleType(r2);
            Intrinsics.checkNotNull(r4);
            return r4;
        }

        public static SimpleTypeMarker upperBoundIfFlexible(TypeSystemContext r1, KotlinTypeMarker r2) {
            Intrinsics.checkNotNullParameter(r2, "$receiver");
            FlexibleTypeMarker r0 = r1.asFlexibleType(r2);
            if (r0 == null) goto L6;
            SimpleTypeMarker r3 = r1.upperBound(r0);
            if (r3 == null) goto L6;
            return r3;
        L6:
            SimpleTypeMarker r4 = r1.asSimpleType(r2);
            Intrinsics.checkNotNull(r4);
            return r4;
        }

        public static boolean isDynamic(TypeSystemContext r1, KotlinTypeMarker r2) {
            Intrinsics.checkNotNullParameter(r2, "$receiver");
            FlexibleTypeMarker r3 = r1.asFlexibleType(r2);
            if (r3 == null) goto L5;
            DynamicTypeMarker r4 = r1.asDynamicType(r3);
        L6:
            if (r4 == null) goto L8;
            return true;
        L8:
            return false;
        L5:
            r4 = null;
            goto L6
        }

        public static boolean isDefinitelyNotNullType(TypeSystemContext r1, KotlinTypeMarker r2) {
            Intrinsics.checkNotNullParameter(r2, "$receiver");
            SimpleTypeMarker r3 = r1.asSimpleType(r2);
            if (r3 == null) goto L5;
            DefinitelyNotNullTypeMarker r4 = r1.asDefinitelyNotNullType(r3);
        L6:
            if (r4 == null) goto L8;
            return true;
        L8:
            return false;
        L5:
            r4 = null;
            goto L6
        }

        public static boolean hasFlexibleNullability(TypeSystemContext r1, KotlinTypeMarker r2) {
            Intrinsics.checkNotNullParameter(r2, "$receiver");
            if (r1.isMarkedNullable(r1.lowerBoundIfFlexible(r2)) == r1.isMarkedNullable(r1.upperBoundIfFlexible(r2))) goto L5;
            return true;
        L5:
            return false;
        }

        public static TypeConstructorMarker typeConstructor(TypeSystemContext r1, KotlinTypeMarker r2) {
            Intrinsics.checkNotNullParameter(r2, "$receiver");
            SimpleTypeMarker r0 = r1.asSimpleType(r2);
            if (r0 != null) goto L6;
            r0 = r1.lowerBoundIfFlexible(r2);
        L6:
            return r1.typeConstructor(r0);
        }

        public static boolean isNothing(TypeSystemContext r1, KotlinTypeMarker r2) {
            Intrinsics.checkNotNullParameter(r2, "$receiver");
            if (r1.isNothingConstructor(r1.typeConstructor(r2)) == true) goto L5;
        L7:
            return false;
        L5:
            if (r1.isNullableType(r2) == true) goto L7;
            return true;
        }

        public static boolean isClassType(TypeSystemContext r1, SimpleTypeMarker r2) {
            Intrinsics.checkNotNullParameter(r2, "$receiver");
            return r1.isClassTypeConstructor(r1.typeConstructor(r2));
        }

        public static boolean isIntegerLiteralType(TypeSystemContext r1, SimpleTypeMarker r2) {
            Intrinsics.checkNotNullParameter(r2, "$receiver");
            return r1.isIntegerLiteralTypeConstructor(r1.typeConstructor(r2));
        }

        public static TypeArgumentMarker get(TypeSystemContext r1, TypeArgumentListMarker r2, int r3) {
            Intrinsics.checkNotNullParameter(r2, "$receiver");
            if ((r2 instanceof SimpleTypeMarker) == false) goto L6;
            return r1.getArgument((KotlinTypeMarker) r2, r3);
        L6:
            if ((r2 instanceof ArgumentList) == false) goto L10;
            TypeArgumentMarker r4 = ((ArgumentList) r2).get(r3);
            Intrinsics.checkNotNullExpressionValue(r4, "get(index)");
            return r4;
        L10:
            throw new IllegalStateException(("unknown type argument list type: " + r2 + ", " + Reflection.getOrCreateKotlinClass(r2.getClass())).toString());
        }

        public static int size(TypeSystemContext r2, TypeArgumentListMarker r3) {
            Intrinsics.checkNotNullParameter(r3, "$receiver");
            if ((r3 instanceof SimpleTypeMarker) == false) goto L6;
            return r2.argumentsCount((KotlinTypeMarker) r3);
        L6:
            if ((r3 instanceof ArgumentList) == false) goto L10;
            return ((ArgumentList) r3).size();
        L10:
            throw new IllegalStateException(("unknown type argument list type: " + r3 + ", " + Reflection.getOrCreateKotlinClass(r3.getClass())).toString());
        }
    }

    boolean areEqualTypeConstructors(TypeConstructorMarker r1, TypeConstructorMarker r2);

    int argumentsCount(KotlinTypeMarker r1);

    TypeArgumentListMarker asArgumentList(SimpleTypeMarker r1);

    CapturedTypeMarker asCapturedType(SimpleTypeMarker r1);

    DefinitelyNotNullTypeMarker asDefinitelyNotNullType(SimpleTypeMarker r1);

    DynamicTypeMarker asDynamicType(FlexibleTypeMarker r1);

    FlexibleTypeMarker asFlexibleType(KotlinTypeMarker r1);

    RawTypeMarker asRawType(FlexibleTypeMarker r1);

    SimpleTypeMarker asSimpleType(KotlinTypeMarker r1);

    TypeArgumentMarker asTypeArgument(KotlinTypeMarker r1);

    SimpleTypeMarker captureFromArguments(SimpleTypeMarker r1, CaptureStatus r2);

    CaptureStatus captureStatus(CapturedTypeMarker r1);

    List<SimpleTypeMarker> fastCorrespondingSupertypes(SimpleTypeMarker r1, TypeConstructorMarker r2);

    TypeArgumentMarker get(TypeArgumentListMarker r1, int r2);

    TypeArgumentMarker getArgument(KotlinTypeMarker r1, int r2);

    TypeArgumentMarker getArgumentOrNull(SimpleTypeMarker r1, int r2);

    List<TypeArgumentMarker> getArguments(KotlinTypeMarker r1);

    TypeParameterMarker getParameter(TypeConstructorMarker r1, int r2);

    List<TypeParameterMarker> getParameters(TypeConstructorMarker r1);

    KotlinTypeMarker getType(TypeArgumentMarker r1);

    TypeParameterMarker getTypeParameter(TypeVariableTypeConstructorMarker r1);

    TypeParameterMarker getTypeParameterClassifier(TypeConstructorMarker r1);

    List<KotlinTypeMarker> getUpperBounds(TypeParameterMarker r1);

    TypeVariance getVariance(TypeArgumentMarker r1);

    TypeVariance getVariance(TypeParameterMarker r1);

    boolean hasFlexibleNullability(KotlinTypeMarker r1);

    boolean hasRecursiveBounds(TypeParameterMarker r1, TypeConstructorMarker r2);

    KotlinTypeMarker intersectTypes(List<? extends KotlinTypeMarker> r1);

    boolean isAnyConstructor(TypeConstructorMarker r1);

    boolean isCapturedType(KotlinTypeMarker r1);

    boolean isClassType(SimpleTypeMarker r1);

    boolean isClassTypeConstructor(TypeConstructorMarker r1);

    boolean isCommonFinalClassConstructor(TypeConstructorMarker r1);

    boolean isDefinitelyNotNullType(KotlinTypeMarker r1);

    boolean isDenotable(TypeConstructorMarker r1);

    boolean isDynamic(KotlinTypeMarker r1);

    boolean isError(KotlinTypeMarker r1);

    boolean isIntegerLiteralType(SimpleTypeMarker r1);

    boolean isIntegerLiteralTypeConstructor(TypeConstructorMarker r1);

    boolean isIntersection(TypeConstructorMarker r1);

    boolean isMarkedNullable(KotlinTypeMarker r1);

    boolean isMarkedNullable(SimpleTypeMarker r1);

    boolean isNotNullTypeParameter(KotlinTypeMarker r1);

    boolean isNothing(KotlinTypeMarker r1);

    boolean isNothingConstructor(TypeConstructorMarker r1);

    boolean isNullableType(KotlinTypeMarker r1);

    boolean isOldCapturedType(CapturedTypeMarker r1);

    boolean isPrimitiveType(SimpleTypeMarker r1);

    boolean isProjectionNotNull(CapturedTypeMarker r1);

    boolean isSingleClassifierType(SimpleTypeMarker r1);

    boolean isStarProjection(TypeArgumentMarker r1);

    boolean isStubType(SimpleTypeMarker r1);

    boolean isStubTypeForBuilderInference(SimpleTypeMarker r1);

    boolean isTypeVariableType(KotlinTypeMarker r1);

    SimpleTypeMarker lowerBound(FlexibleTypeMarker r1);

    SimpleTypeMarker lowerBoundIfFlexible(KotlinTypeMarker r1);

    KotlinTypeMarker lowerType(CapturedTypeMarker r1);

    KotlinTypeMarker makeDefinitelyNotNullOrNotNull(KotlinTypeMarker r1);

    SimpleTypeMarker original(DefinitelyNotNullTypeMarker r1);

    int parametersCount(TypeConstructorMarker r1);

    Collection<KotlinTypeMarker> possibleIntegerTypes(SimpleTypeMarker r1);

    TypeArgumentMarker projection(CapturedTypeConstructorMarker r1);

    int size(TypeArgumentListMarker r1);

    TypeCheckerState.SupertypesPolicy substitutionSupertypePolicy(SimpleTypeMarker r1);

    Collection<KotlinTypeMarker> supertypes(TypeConstructorMarker r1);

    CapturedTypeConstructorMarker typeConstructor(CapturedTypeMarker r1);

    TypeConstructorMarker typeConstructor(KotlinTypeMarker r1);

    TypeConstructorMarker typeConstructor(SimpleTypeMarker r1);

    SimpleTypeMarker upperBound(FlexibleTypeMarker r1);

    SimpleTypeMarker upperBoundIfFlexible(KotlinTypeMarker r1);

    KotlinTypeMarker withNullability(KotlinTypeMarker r1, boolean r2);

    SimpleTypeMarker withNullability(SimpleTypeMarker r1, boolean r2);
}
