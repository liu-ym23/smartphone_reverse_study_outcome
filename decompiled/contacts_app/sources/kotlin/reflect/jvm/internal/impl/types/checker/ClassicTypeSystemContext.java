package kotlin.reflect.jvm.internal.impl.types.checker;

import java.util.Collection;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.InlineClassRepresentation;
import kotlin.reflect.jvm.internal.impl.descriptors.ModalityUtilsKt;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueClassRepresentation;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.resolve.InlineClassesUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedType;
import kotlin.reflect.jvm.internal.impl.resolve.constants.IntegerLiteralTypeConstructor;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.DefinitelyNotNullType;
import kotlin.reflect.jvm.internal.impl.types.DynamicType;
import kotlin.reflect.jvm.internal.impl.types.FlexibleType;
import kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeKt;
import kotlin.reflect.jvm.internal.impl.types.NotNullTypeParameter;
import kotlin.reflect.jvm.internal.impl.types.RawType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.SimpleTypeWithEnhancement;
import kotlin.reflect.jvm.internal.impl.types.TypeCheckerState;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructorSubstitution;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.TypeSystemCommonBackendContext;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import kotlin.reflect.jvm.internal.impl.types.Variance;
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
import kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContextKt;
import kotlin.reflect.jvm.internal.impl.types.model.TypeSystemInferenceExtensionContext;
import kotlin.reflect.jvm.internal.impl.types.model.TypeVariableTypeConstructorMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeVariance;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import obric.widget.search.data.GloableSearchConfig;

/* JADX INFO: compiled from: ClassicTypeSystemContext.kt */
/* JADX INFO: loaded from: classes4.dex */
public interface ClassicTypeSystemContext extends TypeSystemCommonBackendContext, TypeSystemInferenceExtensionContext {

    /* JADX INFO: compiled from: ClassicTypeSystemContext.kt */
    public static final class DefaultImpls {
        public static List<SimpleTypeMarker> fastCorrespondingSupertypes(ClassicTypeSystemContext r1, SimpleTypeMarker r2, TypeConstructorMarker r3) {
            Intrinsics.checkNotNullParameter(r2, "$receiver");
            Intrinsics.checkNotNullParameter(r3, "constructor");
            return TypeSystemInferenceExtensionContext.DefaultImpls.fastCorrespondingSupertypes(r1, r2, r3);
        }

        public static TypeArgumentMarker get(ClassicTypeSystemContext r1, TypeArgumentListMarker r2, int r3) {
            Intrinsics.checkNotNullParameter(r2, "$receiver");
            return TypeSystemInferenceExtensionContext.DefaultImpls.get(r1, r2, r3);
        }

        public static TypeArgumentMarker getArgumentOrNull(ClassicTypeSystemContext r1, SimpleTypeMarker r2, int r3) {
            Intrinsics.checkNotNullParameter(r2, "$receiver");
            return TypeSystemInferenceExtensionContext.DefaultImpls.getArgumentOrNull(r1, r2, r3);
        }

        public static boolean hasFlexibleNullability(ClassicTypeSystemContext r1, KotlinTypeMarker r2) {
            Intrinsics.checkNotNullParameter(r2, "$receiver");
            return TypeSystemInferenceExtensionContext.DefaultImpls.hasFlexibleNullability(r1, r2);
        }

        public static boolean isCapturedType(ClassicTypeSystemContext r1, KotlinTypeMarker r2) {
            Intrinsics.checkNotNullParameter(r2, "$receiver");
            return TypeSystemInferenceExtensionContext.DefaultImpls.isCapturedType(r1, r2);
        }

        public static boolean isClassType(ClassicTypeSystemContext r1, SimpleTypeMarker r2) {
            Intrinsics.checkNotNullParameter(r2, "$receiver");
            return TypeSystemInferenceExtensionContext.DefaultImpls.isClassType(r1, r2);
        }

        public static boolean isDefinitelyNotNullType(ClassicTypeSystemContext r1, KotlinTypeMarker r2) {
            Intrinsics.checkNotNullParameter(r2, "$receiver");
            return TypeSystemInferenceExtensionContext.DefaultImpls.isDefinitelyNotNullType(r1, r2);
        }

        public static boolean isDynamic(ClassicTypeSystemContext r1, KotlinTypeMarker r2) {
            Intrinsics.checkNotNullParameter(r2, "$receiver");
            return TypeSystemInferenceExtensionContext.DefaultImpls.isDynamic(r1, r2);
        }

        public static boolean isIntegerLiteralType(ClassicTypeSystemContext r1, SimpleTypeMarker r2) {
            Intrinsics.checkNotNullParameter(r2, "$receiver");
            return TypeSystemInferenceExtensionContext.DefaultImpls.isIntegerLiteralType(r1, r2);
        }

        public static boolean isMarkedNullable(ClassicTypeSystemContext r1, KotlinTypeMarker r2) {
            Intrinsics.checkNotNullParameter(r2, "$receiver");
            return TypeSystemInferenceExtensionContext.DefaultImpls.isMarkedNullable(r1, r2);
        }

        public static boolean isNothing(ClassicTypeSystemContext r1, KotlinTypeMarker r2) {
            Intrinsics.checkNotNullParameter(r2, "$receiver");
            return TypeSystemInferenceExtensionContext.DefaultImpls.isNothing(r1, r2);
        }

        public static SimpleTypeMarker lowerBoundIfFlexible(ClassicTypeSystemContext r1, KotlinTypeMarker r2) {
            Intrinsics.checkNotNullParameter(r2, "$receiver");
            return TypeSystemInferenceExtensionContext.DefaultImpls.lowerBoundIfFlexible(r1, r2);
        }

        public static KotlinTypeMarker makeNullable(ClassicTypeSystemContext r1, KotlinTypeMarker r2) {
            Intrinsics.checkNotNullParameter(r2, "$receiver");
            return TypeSystemCommonBackendContext.DefaultImpls.makeNullable(r1, r2);
        }

        public static int size(ClassicTypeSystemContext r1, TypeArgumentListMarker r2) {
            Intrinsics.checkNotNullParameter(r2, "$receiver");
            return TypeSystemInferenceExtensionContext.DefaultImpls.size(r1, r2);
        }

        public static TypeConstructorMarker typeConstructor(ClassicTypeSystemContext r1, KotlinTypeMarker r2) {
            Intrinsics.checkNotNullParameter(r2, "$receiver");
            return TypeSystemInferenceExtensionContext.DefaultImpls.typeConstructor(r1, r2);
        }

        public static SimpleTypeMarker upperBoundIfFlexible(ClassicTypeSystemContext r1, KotlinTypeMarker r2) {
            Intrinsics.checkNotNullParameter(r2, "$receiver");
            return TypeSystemInferenceExtensionContext.DefaultImpls.upperBoundIfFlexible(r1, r2);
        }

        public static boolean isDenotable(ClassicTypeSystemContext r1, TypeConstructorMarker r2) {
            Intrinsics.checkNotNullParameter(r2, "$receiver");
            if ((r2 instanceof TypeConstructor) == false) goto L7;
            return ((TypeConstructor) r2).isDenotable();
        L7:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r2 + ", " + Reflection.getOrCreateKotlinClass(r2.getClass())).toString());
        }

        public static boolean isIntegerLiteralTypeConstructor(ClassicTypeSystemContext r1, TypeConstructorMarker r2) {
            Intrinsics.checkNotNullParameter(r2, "$receiver");
            if ((r2 instanceof TypeConstructor) == false) goto L7;
            return r2 instanceof IntegerLiteralTypeConstructor;
        L7:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r2 + ", " + Reflection.getOrCreateKotlinClass(r2.getClass())).toString());
        }

        public static TypeParameterMarker getTypeParameter(ClassicTypeSystemContext r1, TypeVariableTypeConstructorMarker r2) {
            Intrinsics.checkNotNullParameter(r2, "$receiver");
            if ((r2 instanceof NewTypeVariableConstructor) == false) goto L7;
            return ((NewTypeVariableConstructor) r2).getOriginalTypeParameter();
        L7:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r2 + ", " + Reflection.getOrCreateKotlinClass(r2.getClass())).toString());
        }

        public static Collection<KotlinTypeMarker> possibleIntegerTypes(ClassicTypeSystemContext r1, SimpleTypeMarker r2) {
            Intrinsics.checkNotNullParameter(r2, "$receiver");
            TypeConstructorMarker r3 = r1.typeConstructor(r2);
            if ((r3 instanceof IntegerLiteralTypeConstructor) == false) goto L7;
            return ((IntegerLiteralTypeConstructor) r3).getPossibleTypes();
        L7:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r2 + ", " + Reflection.getOrCreateKotlinClass(r2.getClass())).toString());
        }

        public static SimpleTypeMarker withNullability(ClassicTypeSystemContext r0, SimpleTypeMarker r1, boolean r2) {
            Intrinsics.checkNotNullParameter(r1, "$receiver");
            if ((r1 instanceof SimpleType) == false) goto L7;
            return ((SimpleType) r1).makeNullableAsSpecified(r2);
        L7:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r1 + ", " + Reflection.getOrCreateKotlinClass(r1.getClass())).toString());
        }

        public static boolean isError(ClassicTypeSystemContext r1, KotlinTypeMarker r2) {
            Intrinsics.checkNotNullParameter(r2, "$receiver");
            if ((r2 instanceof KotlinType) == false) goto L7;
            return KotlinTypeKt.isError((KotlinType) r2);
        L7:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r2 + ", " + Reflection.getOrCreateKotlinClass(r2.getClass())).toString());
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static boolean isStubType(ClassicTypeSystemContext r1, SimpleTypeMarker r2) {
            Intrinsics.checkNotNullParameter(r2, "$receiver");
            if ((r2 instanceof SimpleType) == false) goto L7;
            return TypeUtilsKt.isStubType((KotlinType) r2);
        L7:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r2 + ", " + Reflection.getOrCreateKotlinClass(r2.getClass())).toString());
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static boolean isStubTypeForBuilderInference(ClassicTypeSystemContext r1, SimpleTypeMarker r2) {
            Intrinsics.checkNotNullParameter(r2, "$receiver");
            if ((r2 instanceof SimpleType) == false) goto L7;
            return TypeUtilsKt.isStubTypeForBuilderInference((KotlinType) r2);
        L7:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r2 + ", " + Reflection.getOrCreateKotlinClass(r2.getClass())).toString());
        }

        public static KotlinTypeMarker lowerType(ClassicTypeSystemContext r1, CapturedTypeMarker r2) {
            Intrinsics.checkNotNullParameter(r2, "$receiver");
            if ((r2 instanceof NewCapturedType) == false) goto L7;
            return ((NewCapturedType) r2).getLowerType();
        L7:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r2 + ", " + Reflection.getOrCreateKotlinClass(r2.getClass())).toString());
        }

        public static boolean isIntersection(ClassicTypeSystemContext r1, TypeConstructorMarker r2) {
            Intrinsics.checkNotNullParameter(r2, "$receiver");
            if ((r2 instanceof TypeConstructor) == false) goto L7;
            return r2 instanceof IntersectionTypeConstructor;
        L7:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r2 + ", " + Reflection.getOrCreateKotlinClass(r2.getClass())).toString());
        }

        public static boolean identicalArguments(ClassicTypeSystemContext r2, SimpleTypeMarker r3, SimpleTypeMarker r4) {
            Intrinsics.checkNotNullParameter(r3, "a");
            Intrinsics.checkNotNullParameter(r4, "b");
            if ((r3 instanceof SimpleType) == false) goto L14;
            if ((r4 instanceof SimpleType) == false) goto L12;
            if (((SimpleType) r3).getArguments() != ((SimpleType) r4).getArguments()) goto L9;
            return true;
        L9:
            return false;
        L12:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r4 + ", " + Reflection.getOrCreateKotlinClass(r4.getClass())).toString());
        L14:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r3 + ", " + Reflection.getOrCreateKotlinClass(r3.getClass())).toString());
        }

        public static SimpleTypeMarker asSimpleType(ClassicTypeSystemContext r1, KotlinTypeMarker r2) {
            Intrinsics.checkNotNullParameter(r2, "$receiver");
            if ((r2 instanceof KotlinType) == false) goto L11;
            UnwrappedType r3 = ((KotlinType) r2).unwrap();
            if ((r3 instanceof SimpleType) == false) goto L7;
            SimpleType r4 = (SimpleType) r3;
        L9:
            return r4;
        L7:
            r4 = null;
            goto L9
        L11:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r2 + ", " + Reflection.getOrCreateKotlinClass(r2.getClass())).toString());
        }

        public static FlexibleTypeMarker asFlexibleType(ClassicTypeSystemContext r1, KotlinTypeMarker r2) {
            Intrinsics.checkNotNullParameter(r2, "$receiver");
            if ((r2 instanceof KotlinType) == false) goto L11;
            UnwrappedType r3 = ((KotlinType) r2).unwrap();
            if ((r3 instanceof FlexibleType) == false) goto L7;
            FlexibleType r4 = (FlexibleType) r3;
        L9:
            return r4;
        L7:
            r4 = null;
            goto L9
        L11:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r2 + ", " + Reflection.getOrCreateKotlinClass(r2.getClass())).toString());
        }

        public static DynamicTypeMarker asDynamicType(ClassicTypeSystemContext r1, FlexibleTypeMarker r2) {
            Intrinsics.checkNotNullParameter(r2, "$receiver");
            if ((r2 instanceof FlexibleType) == false) goto L11;
            if ((r2 instanceof DynamicType) == false) goto L7;
            DynamicType r3 = (DynamicType) r2;
        L9:
            return r3;
        L7:
            r3 = null;
            goto L9
        L11:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r2 + ", " + Reflection.getOrCreateKotlinClass(r2.getClass())).toString());
        }

        public static RawTypeMarker asRawType(ClassicTypeSystemContext r1, FlexibleTypeMarker r2) {
            Intrinsics.checkNotNullParameter(r2, "$receiver");
            if ((r2 instanceof FlexibleType) == false) goto L11;
            if ((r2 instanceof RawType) == false) goto L7;
            RawType r3 = (RawType) r2;
        L9:
            return r3;
        L7:
            r3 = null;
            goto L9
        L11:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r2 + ", " + Reflection.getOrCreateKotlinClass(r2.getClass())).toString());
        }

        public static SimpleTypeMarker upperBound(ClassicTypeSystemContext r1, FlexibleTypeMarker r2) {
            Intrinsics.checkNotNullParameter(r2, "$receiver");
            if ((r2 instanceof FlexibleType) == false) goto L7;
            return ((FlexibleType) r2).getUpperBound();
        L7:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r2 + ", " + Reflection.getOrCreateKotlinClass(r2.getClass())).toString());
        }

        public static SimpleTypeMarker lowerBound(ClassicTypeSystemContext r1, FlexibleTypeMarker r2) {
            Intrinsics.checkNotNullParameter(r2, "$receiver");
            if ((r2 instanceof FlexibleType) == false) goto L7;
            return ((FlexibleType) r2).getLowerBound();
        L7:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r2 + ", " + Reflection.getOrCreateKotlinClass(r2.getClass())).toString());
        }

        public static CapturedTypeMarker asCapturedType(ClassicTypeSystemContext r1, SimpleTypeMarker r2) {
            Intrinsics.checkNotNullParameter(r2, "$receiver");
            if ((r2 instanceof SimpleType) == false) goto L14;
            if ((r2 instanceof SimpleTypeWithEnhancement) == false) goto L8;
            return r1.asCapturedType(((SimpleTypeWithEnhancement) r2).getOrigin());
        L8:
            if ((r2 instanceof NewCapturedType) == false) goto L10;
            NewCapturedType r3 = (NewCapturedType) r2;
        L12:
            return r3;
        L10:
            r3 = null;
            goto L12
        L14:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r2 + ", " + Reflection.getOrCreateKotlinClass(r2.getClass())).toString());
        }

        public static DefinitelyNotNullTypeMarker asDefinitelyNotNullType(ClassicTypeSystemContext r1, SimpleTypeMarker r2) {
            Intrinsics.checkNotNullParameter(r2, "$receiver");
            if ((r2 instanceof SimpleType) == false) goto L11;
            if ((r2 instanceof DefinitelyNotNullType) == false) goto L7;
            DefinitelyNotNullType r3 = (DefinitelyNotNullType) r2;
        L9:
            return r3;
        L7:
            r3 = null;
            goto L9
        L11:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r2 + ", " + Reflection.getOrCreateKotlinClass(r2.getClass())).toString());
        }

        public static boolean isNotNullTypeParameter(ClassicTypeSystemContext r0, KotlinTypeMarker r1) {
            Intrinsics.checkNotNullParameter(r1, "$receiver");
            return r1 instanceof NotNullTypeParameter;
        }

        public static boolean isMarkedNullable(ClassicTypeSystemContext r1, SimpleTypeMarker r2) {
            Intrinsics.checkNotNullParameter(r2, "$receiver");
            if ((r2 instanceof SimpleType) == false) goto L7;
            return ((SimpleType) r2).isMarkedNullable();
        L7:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r2 + ", " + Reflection.getOrCreateKotlinClass(r2.getClass())).toString());
        }

        public static TypeConstructorMarker typeConstructor(ClassicTypeSystemContext r1, SimpleTypeMarker r2) {
            Intrinsics.checkNotNullParameter(r2, "$receiver");
            if ((r2 instanceof SimpleType) == false) goto L7;
            return ((SimpleType) r2).getConstructor();
        L7:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r2 + ", " + Reflection.getOrCreateKotlinClass(r2.getClass())).toString());
        }

        public static CapturedTypeConstructorMarker typeConstructor(ClassicTypeSystemContext r1, CapturedTypeMarker r2) {
            Intrinsics.checkNotNullParameter(r2, "$receiver");
            if ((r2 instanceof NewCapturedType) == false) goto L7;
            return ((NewCapturedType) r2).getConstructor();
        L7:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r2 + ", " + Reflection.getOrCreateKotlinClass(r2.getClass())).toString());
        }

        public static TypeArgumentMarker projection(ClassicTypeSystemContext r1, CapturedTypeConstructorMarker r2) {
            Intrinsics.checkNotNullParameter(r2, "$receiver");
            if ((r2 instanceof NewCapturedTypeConstructor) == false) goto L7;
            return ((NewCapturedTypeConstructor) r2).getProjection();
        L7:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r2 + ", " + Reflection.getOrCreateKotlinClass(r2.getClass())).toString());
        }

        public static int argumentsCount(ClassicTypeSystemContext r1, KotlinTypeMarker r2) {
            Intrinsics.checkNotNullParameter(r2, "$receiver");
            if ((r2 instanceof KotlinType) == false) goto L7;
            return ((KotlinType) r2).getArguments().size();
        L7:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r2 + ", " + Reflection.getOrCreateKotlinClass(r2.getClass())).toString());
        }

        public static TypeArgumentMarker getArgument(ClassicTypeSystemContext r0, KotlinTypeMarker r1, int r2) {
            Intrinsics.checkNotNullParameter(r1, "$receiver");
            if ((r1 instanceof KotlinType) == false) goto L7;
            return ((KotlinType) r1).getArguments().get(r2);
        L7:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r1 + ", " + Reflection.getOrCreateKotlinClass(r1.getClass())).toString());
        }

        public static List<TypeArgumentMarker> getArguments(ClassicTypeSystemContext r1, KotlinTypeMarker r2) {
            Intrinsics.checkNotNullParameter(r2, "$receiver");
            if ((r2 instanceof KotlinType) == false) goto L7;
            return ((KotlinType) r2).getArguments();
        L7:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r2 + ", " + Reflection.getOrCreateKotlinClass(r2.getClass())).toString());
        }

        public static boolean isStarProjection(ClassicTypeSystemContext r1, TypeArgumentMarker r2) {
            Intrinsics.checkNotNullParameter(r2, "$receiver");
            if ((r2 instanceof TypeProjection) == false) goto L7;
            return ((TypeProjection) r2).isStarProjection();
        L7:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r2 + ", " + Reflection.getOrCreateKotlinClass(r2.getClass())).toString());
        }

        public static TypeVariance getVariance(ClassicTypeSystemContext r1, TypeArgumentMarker r2) {
            Intrinsics.checkNotNullParameter(r2, "$receiver");
            if ((r2 instanceof TypeProjection) == false) goto L7;
            Variance r3 = ((TypeProjection) r2).getProjectionKind();
            Intrinsics.checkNotNullExpressionValue(r3, "this.projectionKind");
            return TypeSystemContextKt.convertVariance(r3);
        L7:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r2 + ", " + Reflection.getOrCreateKotlinClass(r2.getClass())).toString());
        }

        public static KotlinTypeMarker getType(ClassicTypeSystemContext r1, TypeArgumentMarker r2) {
            Intrinsics.checkNotNullParameter(r2, "$receiver");
            if ((r2 instanceof TypeProjection) == false) goto L7;
            return ((TypeProjection) r2).getType().unwrap();
        L7:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r2 + ", " + Reflection.getOrCreateKotlinClass(r2.getClass())).toString());
        }

        public static int parametersCount(ClassicTypeSystemContext r1, TypeConstructorMarker r2) {
            Intrinsics.checkNotNullParameter(r2, "$receiver");
            if ((r2 instanceof TypeConstructor) == false) goto L7;
            return ((TypeConstructor) r2).getParameters().size();
        L7:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r2 + ", " + Reflection.getOrCreateKotlinClass(r2.getClass())).toString());
        }

        public static TypeParameterMarker getParameter(ClassicTypeSystemContext r0, TypeConstructorMarker r1, int r2) {
            Intrinsics.checkNotNullParameter(r1, "$receiver");
            if ((r1 instanceof TypeConstructor) == false) goto L7;
            TypeParameterDescriptor r3 = ((TypeConstructor) r1).getParameters().get(r2);
            Intrinsics.checkNotNullExpressionValue(r3, "this.parameters[index]");
            return r3;
        L7:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r1 + ", " + Reflection.getOrCreateKotlinClass(r1.getClass())).toString());
        }

        public static List<TypeParameterMarker> getParameters(ClassicTypeSystemContext r1, TypeConstructorMarker r2) {
            Intrinsics.checkNotNullParameter(r2, "$receiver");
            if ((r2 instanceof TypeConstructor) == false) goto L7;
            List<TypeParameterDescriptor> r3 = ((TypeConstructor) r2).getParameters();
            Intrinsics.checkNotNullExpressionValue(r3, "this.parameters");
            return r3;
        L7:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r2 + ", " + Reflection.getOrCreateKotlinClass(r2.getClass())).toString());
        }

        public static Collection<KotlinTypeMarker> supertypes(ClassicTypeSystemContext r1, TypeConstructorMarker r2) {
            Intrinsics.checkNotNullParameter(r2, "$receiver");
            if ((r2 instanceof TypeConstructor) == false) goto L7;
            Collection<KotlinType> r3 = ((TypeConstructor) r2).mo2084getSupertypes();
            Intrinsics.checkNotNullExpressionValue(r3, "this.supertypes");
            return r3;
        L7:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r2 + ", " + Reflection.getOrCreateKotlinClass(r2.getClass())).toString());
        }

        public static TypeVariance getVariance(ClassicTypeSystemContext r1, TypeParameterMarker r2) {
            Intrinsics.checkNotNullParameter(r2, "$receiver");
            if ((r2 instanceof TypeParameterDescriptor) == false) goto L7;
            Variance r3 = ((TypeParameterDescriptor) r2).getVariance();
            Intrinsics.checkNotNullExpressionValue(r3, "this.variance");
            return TypeSystemContextKt.convertVariance(r3);
        L7:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r2 + ", " + Reflection.getOrCreateKotlinClass(r2.getClass())).toString());
        }

        public static List<KotlinTypeMarker> getUpperBounds(ClassicTypeSystemContext r1, TypeParameterMarker r2) {
            Intrinsics.checkNotNullParameter(r2, "$receiver");
            if ((r2 instanceof TypeParameterDescriptor) == false) goto L7;
            List<KotlinType> r3 = ((TypeParameterDescriptor) r2).getUpperBounds();
            Intrinsics.checkNotNullExpressionValue(r3, "this.upperBounds");
            return r3;
        L7:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r2 + ", " + Reflection.getOrCreateKotlinClass(r2.getClass())).toString());
        }

        public static boolean hasRecursiveBounds(ClassicTypeSystemContext r2, TypeParameterMarker r3, TypeConstructorMarker r4) {
            Intrinsics.checkNotNullParameter(r3, "$receiver");
            if ((r3 instanceof TypeParameterDescriptor) == false) goto L13;
            if (r4 != null) goto L6;
            boolean r5 = true;
        L7:
            if (r5 == false) goto L11;
            return TypeUtilsKt.hasTypeParameterRecursiveBounds$default((TypeParameterDescriptor) r3, (TypeConstructor) r4, null, 4, null);
        L11:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r3 + ", " + Reflection.getOrCreateKotlinClass(r3.getClass())).toString());
        L6:
            r5 = r4 instanceof TypeConstructor;
            goto L7
        L13:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r3 + ", " + Reflection.getOrCreateKotlinClass(r3.getClass())).toString());
        }

        public static boolean areEqualTypeConstructors(ClassicTypeSystemContext r2, TypeConstructorMarker r3, TypeConstructorMarker r4) {
            Intrinsics.checkNotNullParameter(r3, "c1");
            Intrinsics.checkNotNullParameter(r4, "c2");
            if ((r3 instanceof TypeConstructor) == false) goto L11;
            if ((r4 instanceof TypeConstructor) == false) goto L9;
            return Intrinsics.areEqual(r3, r4);
        L9:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r4 + ", " + Reflection.getOrCreateKotlinClass(r4.getClass())).toString());
        L11:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r3 + ", " + Reflection.getOrCreateKotlinClass(r3.getClass())).toString());
        }

        public static boolean isClassTypeConstructor(ClassicTypeSystemContext r1, TypeConstructorMarker r2) {
            Intrinsics.checkNotNullParameter(r2, "$receiver");
            if ((r2 instanceof TypeConstructor) == false) goto L7;
            return ((TypeConstructor) r2).mo2083getDeclarationDescriptor() instanceof ClassDescriptor;
        L7:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r2 + ", " + Reflection.getOrCreateKotlinClass(r2.getClass())).toString());
        }

        public static boolean isCommonFinalClassConstructor(ClassicTypeSystemContext r2, TypeConstructorMarker r3) {
            Intrinsics.checkNotNullParameter(r3, "$receiver");
            if ((r3 instanceof TypeConstructor) == false) goto L20;
            ClassifierDescriptor r4 = ((TypeConstructor) r3).mo2083getDeclarationDescriptor();
            if ((r4 instanceof ClassDescriptor) == false) goto L7;
            ClassDescriptor r5 = (ClassDescriptor) r4;
        L9:
            if (r5 != null) goto L12;
            return false;
        L12:
            if (ModalityUtilsKt.isFinalClass(r5) == true) goto L14;
            return false;
        L14:
            if (r5.getKind() != ClassKind.ENUM_ENTRY) goto L16;
            return false;
        L16:
            if (r5.getKind() == ClassKind.ANNOTATION_CLASS) goto L23;
            return true;
        L23:
            return false;
        L7:
            r5 = null;
            goto L9
        L20:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r3 + ", " + Reflection.getOrCreateKotlinClass(r3.getClass())).toString());
        }

        public static TypeArgumentListMarker asArgumentList(ClassicTypeSystemContext r1, SimpleTypeMarker r2) {
            Intrinsics.checkNotNullParameter(r2, "$receiver");
            if ((r2 instanceof SimpleType) == false) goto L7;
            return (TypeArgumentListMarker) r2;
        L7:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r2 + ", " + Reflection.getOrCreateKotlinClass(r2.getClass())).toString());
        }

        public static SimpleTypeMarker captureFromArguments(ClassicTypeSystemContext r0, SimpleTypeMarker r1, CaptureStatus r2) {
            Intrinsics.checkNotNullParameter(r1, "type");
            Intrinsics.checkNotNullParameter(r2, "status");
            if ((r1 instanceof SimpleType) == false) goto L7;
            return NewCapturedTypeKt.captureFromArguments((SimpleType) r1, r2);
        L7:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r1 + ", " + Reflection.getOrCreateKotlinClass(r1.getClass())).toString());
        }

        public static boolean isAnyConstructor(ClassicTypeSystemContext r1, TypeConstructorMarker r2) {
            Intrinsics.checkNotNullParameter(r2, "$receiver");
            if ((r2 instanceof TypeConstructor) == false) goto L7;
            return KotlinBuiltIns.isTypeConstructorForGivenClass((TypeConstructor) r2, StandardNames.FqNames.any);
        L7:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r2 + ", " + Reflection.getOrCreateKotlinClass(r2.getClass())).toString());
        }

        public static boolean isNothingConstructor(ClassicTypeSystemContext r1, TypeConstructorMarker r2) {
            Intrinsics.checkNotNullParameter(r2, "$receiver");
            if ((r2 instanceof TypeConstructor) == false) goto L7;
            return KotlinBuiltIns.isTypeConstructorForGivenClass((TypeConstructor) r2, StandardNames.FqNames.nothing);
        L7:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r2 + ", " + Reflection.getOrCreateKotlinClass(r2.getClass())).toString());
        }

        public static TypeArgumentMarker asTypeArgument(ClassicTypeSystemContext r1, KotlinTypeMarker r2) {
            Intrinsics.checkNotNullParameter(r2, "$receiver");
            if ((r2 instanceof KotlinType) == false) goto L7;
            return TypeUtilsKt.asTypeProjection((KotlinType) r2);
        L7:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r2 + ", " + Reflection.getOrCreateKotlinClass(r2.getClass())).toString());
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static boolean isSingleClassifierType(ClassicTypeSystemContext r2, SimpleTypeMarker r3) {
            Intrinsics.checkNotNullParameter(r3, "$receiver");
            if ((r3 instanceof SimpleType) == false) goto L24;
            if (KotlinTypeKt.isError((KotlinType) r3) == true) goto L21;
            SimpleType r0 = (SimpleType) r3;
            if ((r0.getConstructor().mo2083getDeclarationDescriptor() instanceof TypeAliasDescriptor) == true) goto L21;
            if (r0.getConstructor().mo2083getDeclarationDescriptor() == null) goto L11;
        L20:
            return true;
        L11:
            if ((r3 instanceof CapturedType) == true) goto L20;
            if ((r3 instanceof NewCapturedType) == true) goto L20;
            if ((r3 instanceof DefinitelyNotNullType) == true) goto L20;
            if ((r0.getConstructor() instanceof IntegerLiteralTypeConstructor) == true) goto L20;
            if (isSingleClassifierTypeWithEnhancement(r2, r3) == true) goto L20;
        L21:
            return false;
        L24:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r3 + ", " + Reflection.getOrCreateKotlinClass(r3.getClass())).toString());
        }

        private static boolean isSingleClassifierTypeWithEnhancement(ClassicTypeSystemContext r1, SimpleTypeMarker r2) {
            if ((r2 instanceof SimpleTypeWithEnhancement) == true) goto L5;
        L7:
            return false;
        L5:
            if (r1.isSingleClassifierType(((SimpleTypeWithEnhancement) r2).getOrigin()) == false) goto L7;
            return true;
        }

        public static KotlinTypeMarker intersectTypes(ClassicTypeSystemContext r0, List<? extends KotlinTypeMarker> r1) {
            Intrinsics.checkNotNullParameter(r1, GloableSearchConfig.KEY_CONFIGS);
            return IntersectionTypeKt.intersectTypes(r1);
        }

        public static KotlinTypeMarker createFlexibleType(ClassicTypeSystemContext r3, SimpleTypeMarker r4, SimpleTypeMarker r5) {
            Intrinsics.checkNotNullParameter(r4, "lowerBound");
            Intrinsics.checkNotNullParameter(r5, "upperBound");
            if ((r4 instanceof SimpleType) == false) goto L11;
            if ((r5 instanceof SimpleType) == false) goto L9;
            return KotlinTypeFactory.flexibleType((SimpleType) r4, (SimpleType) r5);
        L9:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r3 + ", " + Reflection.getOrCreateKotlinClass(r3.getClass())).toString());
        L11:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r3 + ", " + Reflection.getOrCreateKotlinClass(r3.getClass())).toString());
        }

        public static KotlinTypeMarker withNullability(ClassicTypeSystemContext r1, KotlinTypeMarker r2, boolean r3) {
            Intrinsics.checkNotNullParameter(r2, "$receiver");
            if ((r2 instanceof SimpleTypeMarker) == false) goto L6;
            return r1.withNullability((SimpleTypeMarker) r2, r3);
        L6:
            if ((r2 instanceof FlexibleTypeMarker) == false) goto L10;
            FlexibleTypeMarker r4 = (FlexibleTypeMarker) r2;
            return r1.createFlexibleType(r1.withNullability(r1.lowerBound(r4), r3), r1.withNullability(r1.upperBound(r4), r3));
        L10:
            throw new IllegalStateException("sealed".toString());
        }

        public static TypeCheckerState newTypeCheckerState(ClassicTypeSystemContext r7, boolean r8, boolean r9) {
            return ClassicTypeCheckerStateKt.createClassicTypeCheckerState$default(r8, r9, r7, null, null, 24, null);
        }

        public static KotlinTypeMarker makeDefinitelyNotNullOrNotNull(ClassicTypeSystemContext r1, KotlinTypeMarker r2) {
            Intrinsics.checkNotNullParameter(r2, "$receiver");
            if ((r2 instanceof UnwrappedType) == false) goto L7;
            return ClassicTypeSystemContextKt.access$makeDefinitelyNotNullOrNotNullInternal((UnwrappedType) r2);
        L7:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r2 + ", " + Reflection.getOrCreateKotlinClass(r2.getClass())).toString());
        }

        public static boolean isProjectionNotNull(ClassicTypeSystemContext r1, CapturedTypeMarker r2) {
            Intrinsics.checkNotNullParameter(r2, "$receiver");
            if ((r2 instanceof NewCapturedType) == false) goto L7;
            return ((NewCapturedType) r2).isProjectionNotNull();
        L7:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r2 + ", " + Reflection.getOrCreateKotlinClass(r2.getClass())).toString());
        }

        public static CaptureStatus captureStatus(ClassicTypeSystemContext r1, CapturedTypeMarker r2) {
            Intrinsics.checkNotNullParameter(r2, "$receiver");
            if ((r2 instanceof NewCapturedType) == false) goto L7;
            return ((NewCapturedType) r2).getCaptureStatus();
        L7:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r2 + ", " + Reflection.getOrCreateKotlinClass(r2.getClass())).toString());
        }

        public static boolean isOldCapturedType(ClassicTypeSystemContext r0, CapturedTypeMarker r1) {
            Intrinsics.checkNotNullParameter(r1, "$receiver");
            return r1 instanceof CapturedType;
        }

        public static boolean isNullableType(ClassicTypeSystemContext r1, KotlinTypeMarker r2) {
            Intrinsics.checkNotNullParameter(r2, "$receiver");
            if ((r2 instanceof KotlinType) == false) goto L7;
            return TypeUtils.isNullableType((KotlinType) r2);
        L7:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r2 + ", " + Reflection.getOrCreateKotlinClass(r2.getClass())).toString());
        }

        public static SimpleTypeMarker original(ClassicTypeSystemContext r1, DefinitelyNotNullTypeMarker r2) {
            Intrinsics.checkNotNullParameter(r2, "$receiver");
            if ((r2 instanceof DefinitelyNotNullType) == false) goto L7;
            return ((DefinitelyNotNullType) r2).getOriginal();
        L7:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r2 + ", " + Reflection.getOrCreateKotlinClass(r2.getClass())).toString());
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static boolean isPrimitiveType(ClassicTypeSystemContext r1, SimpleTypeMarker r2) {
            Intrinsics.checkNotNullParameter(r2, "$receiver");
            if ((r2 instanceof KotlinType) == false) goto L7;
            return KotlinBuiltIns.isPrimitiveType((KotlinType) r2);
        L7:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r2 + ", " + Reflection.getOrCreateKotlinClass(r2.getClass())).toString());
        }

        public static boolean hasAnnotation(ClassicTypeSystemContext r0, KotlinTypeMarker r1, FqName r2) {
            Intrinsics.checkNotNullParameter(r1, "$receiver");
            Intrinsics.checkNotNullParameter(r2, "fqName");
            if ((r1 instanceof KotlinType) == false) goto L7;
            return ((KotlinType) r1).getAnnotations().hasAnnotation(r2);
        L7:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r1 + ", " + Reflection.getOrCreateKotlinClass(r1.getClass())).toString());
        }

        public static TypeParameterMarker getTypeParameterClassifier(ClassicTypeSystemContext r1, TypeConstructorMarker r2) {
            Intrinsics.checkNotNullParameter(r2, "$receiver");
            if ((r2 instanceof TypeConstructor) == false) goto L11;
            ClassifierDescriptor r3 = ((TypeConstructor) r2).mo2083getDeclarationDescriptor();
            if ((r3 instanceof TypeParameterDescriptor) == false) goto L7;
            TypeParameterDescriptor r4 = (TypeParameterDescriptor) r3;
        L9:
            return r4;
        L7:
            r4 = null;
            goto L9
        L11:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r2 + ", " + Reflection.getOrCreateKotlinClass(r2.getClass())).toString());
        }

        public static boolean isInlineClass(ClassicTypeSystemContext r1, TypeConstructorMarker r2) {
            Intrinsics.checkNotNullParameter(r2, "$receiver");
            if ((r2 instanceof TypeConstructor) == false) goto L13;
            ClassifierDescriptor r3 = ((TypeConstructor) r2).mo2083getDeclarationDescriptor();
            ValueClassRepresentation<SimpleType> r0 = null;
            if ((r3 instanceof ClassDescriptor) == false) goto L7;
            ClassDescriptor r4 = (ClassDescriptor) r3;
        L8:
            if (r4 == null) goto L11;
            r0 = r4.getValueClassRepresentation();
        L11:
            return r0 instanceof InlineClassRepresentation;
        L7:
            r4 = null;
            goto L8
        L13:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r2 + ", " + Reflection.getOrCreateKotlinClass(r2.getClass())).toString());
        }

        public static KotlinTypeMarker getRepresentativeUpperBound(ClassicTypeSystemContext r1, TypeParameterMarker r2) {
            Intrinsics.checkNotNullParameter(r2, "$receiver");
            if ((r2 instanceof TypeParameterDescriptor) == false) goto L7;
            return TypeUtilsKt.getRepresentativeUpperBound((TypeParameterDescriptor) r2);
        L7:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r2 + ", " + Reflection.getOrCreateKotlinClass(r2.getClass())).toString());
        }

        public static KotlinTypeMarker getUnsubstitutedUnderlyingType(ClassicTypeSystemContext r1, KotlinTypeMarker r2) {
            Intrinsics.checkNotNullParameter(r2, "$receiver");
            if ((r2 instanceof KotlinType) == false) goto L7;
            return InlineClassesUtilsKt.unsubstitutedUnderlyingType((KotlinType) r2);
        L7:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r2 + ", " + Reflection.getOrCreateKotlinClass(r2.getClass())).toString());
        }

        public static PrimitiveType getPrimitiveType(ClassicTypeSystemContext r1, TypeConstructorMarker r2) {
            Intrinsics.checkNotNullParameter(r2, "$receiver");
            if ((r2 instanceof TypeConstructor) == false) goto L7;
            ClassifierDescriptor r3 = ((TypeConstructor) r2).mo2083getDeclarationDescriptor();
            Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
            return KotlinBuiltIns.getPrimitiveType((ClassDescriptor) r3);
        L7:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r2 + ", " + Reflection.getOrCreateKotlinClass(r2.getClass())).toString());
        }

        public static PrimitiveType getPrimitiveArrayType(ClassicTypeSystemContext r1, TypeConstructorMarker r2) {
            Intrinsics.checkNotNullParameter(r2, "$receiver");
            if ((r2 instanceof TypeConstructor) == false) goto L7;
            ClassifierDescriptor r3 = ((TypeConstructor) r2).mo2083getDeclarationDescriptor();
            Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
            return KotlinBuiltIns.getPrimitiveArrayType((ClassDescriptor) r3);
        L7:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r2 + ", " + Reflection.getOrCreateKotlinClass(r2.getClass())).toString());
        }

        public static boolean isUnderKotlinPackage(ClassicTypeSystemContext r1, TypeConstructorMarker r2) {
            Intrinsics.checkNotNullParameter(r2, "$receiver");
            if ((r2 instanceof TypeConstructor) == false) goto L11;
            ClassifierDescriptor r3 = ((TypeConstructor) r2).mo2083getDeclarationDescriptor();
            if (r3 != null) goto L7;
            return false;
        L7:
            if (KotlinBuiltIns.isUnderKotlinPackage(r3) == true) goto L9;
            return false;
        L9:
            return true;
        L11:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r2 + ", " + Reflection.getOrCreateKotlinClass(r2.getClass())).toString());
        }

        public static FqNameUnsafe getClassFqNameUnsafe(ClassicTypeSystemContext r1, TypeConstructorMarker r2) {
            Intrinsics.checkNotNullParameter(r2, "$receiver");
            if ((r2 instanceof TypeConstructor) == false) goto L7;
            ClassifierDescriptor r3 = ((TypeConstructor) r2).mo2083getDeclarationDescriptor();
            Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
            return DescriptorUtilsKt.getFqNameUnsafe((ClassDescriptor) r3);
        L7:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r2 + ", " + Reflection.getOrCreateKotlinClass(r2.getClass())).toString());
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static TypeCheckerState.SupertypesPolicy substitutionSupertypePolicy(final ClassicTypeSystemContext r1, SimpleTypeMarker r2) {
            Intrinsics.checkNotNullParameter(r2, "type");
            if ((r2 instanceof SimpleType) == false) goto L7;
            final TypeSubstitutor r3 = TypeConstructorSubstitution.Companion.create((KotlinType) r2).buildSubstitutor();
            return new ClassicTypeSystemContext$substitutionSupertypePolicy$2(r1, r3);
        L7:
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + r2 + ", " + Reflection.getOrCreateKotlinClass(r2.getClass())).toString());
        }

        public static boolean isTypeVariableType(ClassicTypeSystemContext r0, KotlinTypeMarker r1) {
            Intrinsics.checkNotNullParameter(r1, "$receiver");
            if ((r1 instanceof UnwrappedType) == true) goto L5;
        L7:
            return false;
        L5:
            if ((((UnwrappedType) r1).getConstructor() instanceof NewTypeVariableConstructor) == false) goto L7;
            return true;
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    CapturedTypeMarker asCapturedType(SimpleTypeMarker r1);

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    SimpleTypeMarker asSimpleType(KotlinTypeMarker r1);

    KotlinTypeMarker createFlexibleType(SimpleTypeMarker r1, SimpleTypeMarker r2);

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    boolean isSingleClassifierType(SimpleTypeMarker r1);

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    SimpleTypeMarker lowerBound(FlexibleTypeMarker r1);

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    TypeConstructorMarker typeConstructor(SimpleTypeMarker r1);

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    SimpleTypeMarker upperBound(FlexibleTypeMarker r1);

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    SimpleTypeMarker withNullability(SimpleTypeMarker r1, boolean r2);
}
