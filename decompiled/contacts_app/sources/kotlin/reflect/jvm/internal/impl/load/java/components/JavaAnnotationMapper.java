package kotlin.reflect.jvm.internal.impl.load.java.components;

import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.JvmAnnotationNames;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaAnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* JADX INFO: compiled from: JavaAnnotationMapper.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class JavaAnnotationMapper {
    private static final Name DEPRECATED_ANNOTATION_MESSAGE = null;
    public static final JavaAnnotationMapper INSTANCE = null;
    private static final Name RETENTION_ANNOTATION_VALUE = null;
    private static final Name TARGET_ANNOTATION_ALLOWED_TARGETS = null;
    private static final Map<FqName, FqName> kotlinToJavaNameMap = null;

    private JavaAnnotationMapper() {
    }

    static {
        INSTANCE = new JavaAnnotationMapper();
        Name r0 = Name.identifier("message");
        Intrinsics.checkNotNullExpressionValue(r0, "identifier(\"message\")");
        DEPRECATED_ANNOTATION_MESSAGE = r0;
        Name r1 = Name.identifier("allowedTargets");
        Intrinsics.checkNotNullExpressionValue(r1, "identifier(\"allowedTargets\")");
        TARGET_ANNOTATION_ALLOWED_TARGETS = r1;
        Name r2 = Name.identifier("value");
        Intrinsics.checkNotNullExpressionValue(r2, "identifier(\"value\")");
        RETENTION_ANNOTATION_VALUE = r2;
        kotlinToJavaNameMap = MapsKt.mapOf(new Pair[]{TuplesKt.to(StandardNames.FqNames.target, JvmAnnotationNames.TARGET_ANNOTATION), TuplesKt.to(StandardNames.FqNames.retention, JvmAnnotationNames.RETENTION_ANNOTATION), TuplesKt.to(StandardNames.FqNames.mustBeDocumented, JvmAnnotationNames.DOCUMENTED_ANNOTATION)});
    }

    public final Name getDEPRECATED_ANNOTATION_MESSAGE$descriptors_jvm() {
        return DEPRECATED_ANNOTATION_MESSAGE;
    }

    public final Name getTARGET_ANNOTATION_ALLOWED_TARGETS$descriptors_jvm() {
        return TARGET_ANNOTATION_ALLOWED_TARGETS;
    }

    public final Name getRETENTION_ANNOTATION_VALUE$descriptors_jvm() {
        return RETENTION_ANNOTATION_VALUE;
    }

    public static /* synthetic */ AnnotationDescriptor mapOrResolveJavaAnnotation$default(JavaAnnotationMapper r0, JavaAnnotation r1, LazyJavaResolverContext r2, boolean r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L6;
        r3 = false;
    L6:
        return r0.mapOrResolveJavaAnnotation(r1, r2, r3);
    }

    public final AnnotationDescriptor mapOrResolveJavaAnnotation(JavaAnnotation r2, LazyJavaResolverContext r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "annotation");
        Intrinsics.checkNotNullParameter(r3, "c");
        ClassId r1 = r2.getClassId();
        if (Intrinsics.areEqual(r1, ClassId.topLevel(JvmAnnotationNames.TARGET_ANNOTATION)) == false) goto L6;
        return new JavaTargetAnnotationDescriptor(r2, r3);
    L6:
        if (Intrinsics.areEqual(r1, ClassId.topLevel(JvmAnnotationNames.RETENTION_ANNOTATION)) == false) goto L9;
        return new JavaRetentionAnnotationDescriptor(r2, r3);
    L9:
        if (Intrinsics.areEqual(r1, ClassId.topLevel(JvmAnnotationNames.DOCUMENTED_ANNOTATION)) == false) goto L12;
        return new JavaAnnotationDescriptor(r3, r2, StandardNames.FqNames.mustBeDocumented);
    L12:
        if (Intrinsics.areEqual(r1, ClassId.topLevel(JvmAnnotationNames.DEPRECATED_ANNOTATION)) == false) goto L15;
        return null;
    L15:
        return new LazyJavaAnnotationDescriptor(r3, r2, r4);
    }

    public final AnnotationDescriptor findMappedJavaAnnotation(FqName r7, JavaAnnotationOwner r8, LazyJavaResolverContext r9) {
        Intrinsics.checkNotNullParameter(r7, "kotlinName");
        Intrinsics.checkNotNullParameter(r8, "annotationOwner");
        Intrinsics.checkNotNullParameter(r9, "c");
        if (Intrinsics.areEqual(r7, StandardNames.FqNames.deprecated) == false) goto L10;
        FqName r6 = JvmAnnotationNames.DEPRECATED_ANNOTATION;
        Intrinsics.checkNotNullExpressionValue(r6, "DEPRECATED_ANNOTATION");
        JavaAnnotation r10 = r8.findAnnotation(r6);
        if (r10 != null) goto L9;
        if (r8.isDeprecatedInJavaDoc() == false) goto L10;
    L9:
        return new JavaDeprecatedAnnotationDescriptor(r10, r9);
    L10:
        FqName r11 = kotlinToJavaNameMap.get(r7);
        if (r11 == null) goto L16;
        JavaAnnotation r1 = r8.findAnnotation(r11);
        if (r1 != null) goto L15;
        return null;
    L15:
        return mapOrResolveJavaAnnotation$default(INSTANCE, r1, r9, false, 4, null);
    L16:
        return null;
    }
}
