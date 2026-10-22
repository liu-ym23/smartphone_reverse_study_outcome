package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.constants.AnnotationValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ArrayValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.EnumValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.StringValue;

/* JADX INFO: compiled from: annotationUtil.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class AnnotationUtilKt {
    private static final Name DEPRECATED_LEVEL_NAME = null;
    private static final Name DEPRECATED_MESSAGE_NAME = null;
    private static final Name DEPRECATED_REPLACE_WITH_NAME = null;
    private static final Name REPLACE_WITH_EXPRESSION_NAME = null;
    private static final Name REPLACE_WITH_IMPORTS_NAME = null;

    public static /* synthetic */ AnnotationDescriptor createDeprecatedAnnotation$default(KotlinBuiltIns r0, String r1, String r2, String r3, int r4, Object r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = "";
    L6:
        if ((r4 & 4) == 0) goto L9;
        r3 = "WARNING";
    L9:
        return createDeprecatedAnnotation(r0, r1, r2, r3);
    }

    public static final AnnotationDescriptor createDeprecatedAnnotation(final KotlinBuiltIns r8, String r9, String r10, String r11) {
        Intrinsics.checkNotNullParameter(r8, "<this>");
        Intrinsics.checkNotNullParameter(r9, "message");
        Intrinsics.checkNotNullParameter(r10, "replaceWith");
        Intrinsics.checkNotNullParameter(r11, "level");
        BuiltInAnnotationDescriptor r0 = new BuiltInAnnotationDescriptor(r8, StandardNames.FqNames.replaceWith, MapsKt.mapOf(new Pair[]{TuplesKt.to(REPLACE_WITH_EXPRESSION_NAME, new StringValue(r10)), TuplesKt.to(REPLACE_WITH_IMPORTS_NAME, new ArrayValue(CollectionsKt.emptyList(), new AnnotationUtilKt$createDeprecatedAnnotation$replaceWithAnnotation$1(r8)))}));
        FqName r1 = StandardNames.FqNames.deprecated;
        Name r12 = DEPRECATED_LEVEL_NAME;
        ClassId r4 = ClassId.topLevel(StandardNames.FqNames.deprecationLevel);
        Intrinsics.checkNotNullExpressionValue(r4, "topLevel(StandardNames.FqNames.deprecationLevel)");
        Name r13 = Name.identifier(r11);
        Intrinsics.checkNotNullExpressionValue(r13, "identifier(level)");
        return new BuiltInAnnotationDescriptor(r8, r1, MapsKt.mapOf(new Pair[]{TuplesKt.to(DEPRECATED_MESSAGE_NAME, new StringValue(r9)), TuplesKt.to(DEPRECATED_REPLACE_WITH_NAME, new AnnotationValue(r0)), TuplesKt.to(r12, new EnumValue(r4, r13))}));
    }

    static {
        Name r0 = Name.identifier("message");
        Intrinsics.checkNotNullExpressionValue(r0, "identifier(\"message\")");
        DEPRECATED_MESSAGE_NAME = r0;
        Name r1 = Name.identifier("replaceWith");
        Intrinsics.checkNotNullExpressionValue(r1, "identifier(\"replaceWith\")");
        DEPRECATED_REPLACE_WITH_NAME = r1;
        Name r2 = Name.identifier("level");
        Intrinsics.checkNotNullExpressionValue(r2, "identifier(\"level\")");
        DEPRECATED_LEVEL_NAME = r2;
        Name r3 = Name.identifier("expression");
        Intrinsics.checkNotNullExpressionValue(r3, "identifier(\"expression\")");
        REPLACE_WITH_EXPRESSION_NAME = r3;
        Name r4 = Name.identifier("imports");
        Intrinsics.checkNotNullExpressionValue(r4, "identifier(\"imports\")");
        REPLACE_WITH_IMPORTS_NAME = r4;
    }
}
