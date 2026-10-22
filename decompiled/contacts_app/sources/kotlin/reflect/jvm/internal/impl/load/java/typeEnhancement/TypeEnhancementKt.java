package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMapper;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.CompositeAnnotations;
import kotlin.reflect.jvm.internal.impl.load.java.JvmAnnotationNames;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.checker.SimpleClassicTypeSystemContext;

/* JADX INFO: compiled from: typeEnhancement.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class TypeEnhancementKt {
    private static final EnhancedTypeAnnotations ENHANCED_MUTABILITY_ANNOTATIONS = null;
    private static final EnhancedTypeAnnotations ENHANCED_NULLABILITY_ANNOTATIONS = null;

    /* JADX INFO: compiled from: typeEnhancement.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r0 = new int[NullabilityQualifier.values().length];
            r0[NullabilityQualifier.NULLABLE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[NullabilityQualifier.NOT_NULL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            $EnumSwitchMapping$0 = r0;
        }
    }

    public static final /* synthetic */ Annotations access$compositeAnnotationsOrSingle(List r0) {
        return compositeAnnotationsOrSingle(r0);
    }

    public static final /* synthetic */ ClassifierDescriptor access$enhanceMutability(ClassifierDescriptor r0, JavaTypeQualifiers r1, TypeComponentPosition r2) {
        return enhanceMutability(r0, r1, r2);
    }

    public static final /* synthetic */ EnhancedTypeAnnotations access$getENHANCED_MUTABILITY_ANNOTATIONS$p() {
        return ENHANCED_MUTABILITY_ANNOTATIONS;
    }

    public static final /* synthetic */ EnhancedTypeAnnotations access$getENHANCED_NULLABILITY_ANNOTATIONS$p() {
        return ENHANCED_NULLABILITY_ANNOTATIONS;
    }

    public static final /* synthetic */ Boolean access$getEnhancedNullability(JavaTypeQualifiers r0, TypeComponentPosition r1) {
        return getEnhancedNullability(r0, r1);
    }

    public static final boolean hasEnhancedNullability(KotlinType r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return TypeEnhancementUtilsKt.hasEnhancedNullability(SimpleClassicTypeSystemContext.INSTANCE, r1);
    }

    private static final Annotations compositeAnnotationsOrSingle(List<? extends Annotations> r2) {
        int r0 = r2.size();
        if (r0 == 0) goto L10;
        if (r0 == 1) goto L8;
        return new CompositeAnnotations(CollectionsKt.toList(r2));
    L8:
        return (Annotations) CollectionsKt.single(r2);
    L10:
        throw new IllegalStateException("At least one Annotations object expected".toString());
    }

    private static final ClassifierDescriptor enhanceMutability(ClassifierDescriptor r4, JavaTypeQualifiers r5, TypeComponentPosition r6) {
        JavaToKotlinClassMapper r0 = JavaToKotlinClassMapper.INSTANCE;
        if (TypeComponentPositionKt.shouldEnhance(r6) == true) goto L6;
        return null;
    L6:
        if ((r4 instanceof ClassDescriptor) == true) goto L9;
        return null;
    L9:
        if (r5.getMutability() != MutabilityQualifier.READ_ONLY) goto L16;
        if (r6 != TypeComponentPosition.FLEXIBLE_LOWER) goto L16;
        ClassDescriptor r1 = (ClassDescriptor) r4;
        if (r0.isMutable(r1) == false) goto L16;
        return r0.convertMutableToReadOnly(r1);
    L16:
        if (r5.getMutability() == MutabilityQualifier.MUTABLE) goto L18;
        return null;
    L18:
        if (r6 != TypeComponentPosition.FLEXIBLE_UPPER) goto L25;
        ClassDescriptor r7 = (ClassDescriptor) r4;
        if (r0.isReadOnly(r7) == true) goto L22;
        return null;
    L22:
        return r0.convertReadOnlyToMutable(r7);
    L25:
        return null;
    }

    private static final Boolean getEnhancedNullability(JavaTypeQualifiers r1, TypeComponentPosition r2) {
        if (TypeComponentPositionKt.shouldEnhance(r2) == true) goto L5;
        return null;
    L5:
        NullabilityQualifier r3 = r1.getNullability();
        if (r3 != null) goto L8;
        int r4 = -1;
    L10:
        if (r4 == 1) goto L16;
        if (r4 == 2) goto L17;
        return null;
    L17:
        return false;
    L16:
        return true;
    L8:
        r4 = WhenMappings.$EnumSwitchMapping$0[r3.ordinal()];
        goto L10
    }

    static {
        FqName r1 = JvmAnnotationNames.ENHANCED_NULLABILITY_ANNOTATION;
        Intrinsics.checkNotNullExpressionValue(r1, "ENHANCED_NULLABILITY_ANNOTATION");
        ENHANCED_NULLABILITY_ANNOTATIONS = new EnhancedTypeAnnotations(r1);
        FqName r2 = JvmAnnotationNames.ENHANCED_MUTABILITY_ANNOTATION;
        Intrinsics.checkNotNullExpressionValue(r2, "ENHANCED_MUTABILITY_ANNOTATION");
        ENHANCED_MUTABILITY_ANNOTATIONS = new EnhancedTypeAnnotations(r2);
    }
}
