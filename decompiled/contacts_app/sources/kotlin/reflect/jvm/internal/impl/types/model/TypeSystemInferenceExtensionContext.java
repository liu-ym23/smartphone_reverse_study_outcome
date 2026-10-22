package kotlin.reflect.jvm.internal.impl.types.model;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TypeSystemContext.kt */
/* JADX INFO: loaded from: classes4.dex */
public interface TypeSystemInferenceExtensionContext extends TypeSystemCommonSuperTypesContext, TypeSystemContext {

    /* JADX INFO: compiled from: TypeSystemContext.kt */
    public static final class DefaultImpls {
        public static List<SimpleTypeMarker> fastCorrespondingSupertypes(TypeSystemInferenceExtensionContext r1, SimpleTypeMarker r2, TypeConstructorMarker r3) {
            Intrinsics.checkNotNullParameter(r2, "$receiver");
            Intrinsics.checkNotNullParameter(r3, "constructor");
            return TypeSystemContext.DefaultImpls.fastCorrespondingSupertypes(r1, r2, r3);
        }

        public static TypeArgumentMarker get(TypeSystemInferenceExtensionContext r1, TypeArgumentListMarker r2, int r3) {
            Intrinsics.checkNotNullParameter(r2, "$receiver");
            return TypeSystemContext.DefaultImpls.get(r1, r2, r3);
        }

        public static TypeArgumentMarker getArgumentOrNull(TypeSystemInferenceExtensionContext r1, SimpleTypeMarker r2, int r3) {
            Intrinsics.checkNotNullParameter(r2, "$receiver");
            return TypeSystemContext.DefaultImpls.getArgumentOrNull(r1, r2, r3);
        }

        public static boolean hasFlexibleNullability(TypeSystemInferenceExtensionContext r1, KotlinTypeMarker r2) {
            Intrinsics.checkNotNullParameter(r2, "$receiver");
            return TypeSystemContext.DefaultImpls.hasFlexibleNullability(r1, r2);
        }

        public static boolean isCapturedType(TypeSystemInferenceExtensionContext r1, KotlinTypeMarker r2) {
            Intrinsics.checkNotNullParameter(r2, "$receiver");
            return TypeSystemContext.DefaultImpls.isCapturedType(r1, r2);
        }

        public static boolean isClassType(TypeSystemInferenceExtensionContext r1, SimpleTypeMarker r2) {
            Intrinsics.checkNotNullParameter(r2, "$receiver");
            return TypeSystemContext.DefaultImpls.isClassType(r1, r2);
        }

        public static boolean isDefinitelyNotNullType(TypeSystemInferenceExtensionContext r1, KotlinTypeMarker r2) {
            Intrinsics.checkNotNullParameter(r2, "$receiver");
            return TypeSystemContext.DefaultImpls.isDefinitelyNotNullType(r1, r2);
        }

        public static boolean isDynamic(TypeSystemInferenceExtensionContext r1, KotlinTypeMarker r2) {
            Intrinsics.checkNotNullParameter(r2, "$receiver");
            return TypeSystemContext.DefaultImpls.isDynamic(r1, r2);
        }

        public static boolean isIntegerLiteralType(TypeSystemInferenceExtensionContext r1, SimpleTypeMarker r2) {
            Intrinsics.checkNotNullParameter(r2, "$receiver");
            return TypeSystemContext.DefaultImpls.isIntegerLiteralType(r1, r2);
        }

        public static boolean isMarkedNullable(TypeSystemInferenceExtensionContext r1, KotlinTypeMarker r2) {
            Intrinsics.checkNotNullParameter(r2, "$receiver");
            return TypeSystemContext.DefaultImpls.isMarkedNullable(r1, r2);
        }

        public static boolean isNothing(TypeSystemInferenceExtensionContext r1, KotlinTypeMarker r2) {
            Intrinsics.checkNotNullParameter(r2, "$receiver");
            return TypeSystemContext.DefaultImpls.isNothing(r1, r2);
        }

        public static SimpleTypeMarker lowerBoundIfFlexible(TypeSystemInferenceExtensionContext r1, KotlinTypeMarker r2) {
            Intrinsics.checkNotNullParameter(r2, "$receiver");
            return TypeSystemContext.DefaultImpls.lowerBoundIfFlexible(r1, r2);
        }

        public static int size(TypeSystemInferenceExtensionContext r1, TypeArgumentListMarker r2) {
            Intrinsics.checkNotNullParameter(r2, "$receiver");
            return TypeSystemContext.DefaultImpls.size(r1, r2);
        }

        public static TypeConstructorMarker typeConstructor(TypeSystemInferenceExtensionContext r1, KotlinTypeMarker r2) {
            Intrinsics.checkNotNullParameter(r2, "$receiver");
            return TypeSystemContext.DefaultImpls.typeConstructor(r1, r2);
        }

        public static SimpleTypeMarker upperBoundIfFlexible(TypeSystemInferenceExtensionContext r1, KotlinTypeMarker r2) {
            Intrinsics.checkNotNullParameter(r2, "$receiver");
            return TypeSystemContext.DefaultImpls.upperBoundIfFlexible(r1, r2);
        }
    }
}
