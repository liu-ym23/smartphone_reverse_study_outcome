package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;

/* JADX INFO: compiled from: TypeAliasExpansionReportStrategy.kt */
/* JADX INFO: loaded from: classes4.dex */
public interface TypeAliasExpansionReportStrategy {

    /* JADX INFO: compiled from: TypeAliasExpansionReportStrategy.kt */
    public static final class DO_NOTHING implements TypeAliasExpansionReportStrategy {
        public static final DO_NOTHING INSTANCE = null;

        static {
            INSTANCE = new DO_NOTHING();
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeAliasExpansionReportStrategy
        public void boundsViolationInSubstitution(TypeSubstitutor r1, KotlinType r2, KotlinType r3, TypeParameterDescriptor r4) {
            Intrinsics.checkNotNullParameter(r1, "substitutor");
            Intrinsics.checkNotNullParameter(r2, "unsubstitutedArgument");
            Intrinsics.checkNotNullParameter(r3, "argument");
            Intrinsics.checkNotNullParameter(r4, "typeParameter");
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeAliasExpansionReportStrategy
        public void conflictingProjection(TypeAliasDescriptor r1, TypeParameterDescriptor r2, KotlinType r3) {
            Intrinsics.checkNotNullParameter(r1, "typeAlias");
            Intrinsics.checkNotNullParameter(r3, "substitutedArgument");
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeAliasExpansionReportStrategy
        public void recursiveTypeAlias(TypeAliasDescriptor r1) {
            Intrinsics.checkNotNullParameter(r1, "typeAlias");
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeAliasExpansionReportStrategy
        public void repeatedAnnotation(AnnotationDescriptor r1) {
            Intrinsics.checkNotNullParameter(r1, "annotation");
        }

        private DO_NOTHING() {
        }
    }

    void boundsViolationInSubstitution(TypeSubstitutor r1, KotlinType r2, KotlinType r3, TypeParameterDescriptor r4);

    void conflictingProjection(TypeAliasDescriptor r1, TypeParameterDescriptor r2, KotlinType r3);

    void recursiveTypeAlias(TypeAliasDescriptor r1);

    void repeatedAnnotation(AnnotationDescriptor r1);
}
