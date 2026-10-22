package kotlin.reflect.jvm.internal.impl.load.java;

import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.util.capitalizeDecapitalize.CapitalizeDecapitalizeKt;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: JvmAbi.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class JvmAbi {
    public static final JvmAbi INSTANCE = null;
    public static final ClassId JVM_FIELD_ANNOTATION_CLASS_ID = null;
    public static final FqName JVM_FIELD_ANNOTATION_FQ_NAME = null;
    private static final ClassId REFLECTION_FACTORY_IMPL = null;
    private static final ClassId REPEATABLE_ANNOTATION_CONTAINER_META_ANNOTATION = null;

    private JvmAbi() {
    }

    static {
        INSTANCE = new JvmAbi();
        FqName r0 = new FqName("kotlin.jvm.JvmField");
        JVM_FIELD_ANNOTATION_FQ_NAME = r0;
        ClassId r1 = ClassId.topLevel(r0);
        Intrinsics.checkNotNullExpressionValue(r1, "topLevel(JVM_FIELD_ANNOTATION_FQ_NAME)");
        JVM_FIELD_ANNOTATION_CLASS_ID = r1;
        ClassId r2 = ClassId.topLevel(new FqName("kotlin.reflect.jvm.internal.ReflectionFactoryImpl"));
        Intrinsics.checkNotNullExpressionValue(r2, "topLevel(FqName(\"kotlin.….ReflectionFactoryImpl\"))");
        REFLECTION_FACTORY_IMPL = r2;
        ClassId r3 = ClassId.fromString("kotlin/jvm/internal/RepeatableContainer");
        Intrinsics.checkNotNullExpressionValue(r3, "fromString(\"kotlin/jvm/i…nal/RepeatableContainer\")");
        REPEATABLE_ANNOTATION_CONTAINER_META_ANNOTATION = r3;
    }

    public final ClassId getREPEATABLE_ANNOTATION_CONTAINER_META_ANNOTATION() {
        return REPEATABLE_ANNOTATION_CONTAINER_META_ANNOTATION;
    }

    @JvmStatic
    public static final boolean isGetterName(String r4) {
        Intrinsics.checkNotNullParameter(r4, "name");
        if (StringsKt.startsWith$default(r4, "get", false, 2, null) == false) goto L5;
    L6:
        return true;
    L5:
        if (StringsKt.startsWith$default(r4, "is", false, 2, null) == true) goto L6;
        return false;
    }

    @JvmStatic
    public static final boolean isSetterName(String r4) {
        Intrinsics.checkNotNullParameter(r4, "name");
        return StringsKt.startsWith$default(r4, "set", false, 2, null);
    }

    @JvmStatic
    public static final String getterName(String r2) {
        Intrinsics.checkNotNullParameter(r2, "propertyName");
        if (startsWithIsPrefix(r2) == false) goto L6;
        return r2;
    L6:
        return "get" + CapitalizeDecapitalizeKt.capitalizeAsciiOnly(r2);
    }

    @JvmStatic
    public static final String setterName(String r2) {
        Intrinsics.checkNotNullParameter(r2, "propertyName");
        StringBuilder r0 = new StringBuilder("set");
        if (startsWithIsPrefix(r2) == false) goto L5;
        String r3 = r2.substring(2);
        Intrinsics.checkNotNullExpressionValue(r3, "this as java.lang.String).substring(startIndex)");
    L7:
        return r0.append(r3).toString();
    L5:
        r3 = CapitalizeDecapitalizeKt.capitalizeAsciiOnly(r2);
        goto L7
    }

    @JvmStatic
    public static final boolean startsWithIsPrefix(String r4) {
        Intrinsics.checkNotNullParameter(r4, "name");
        if (StringsKt.startsWith$default(r4, "is", false, 2, null) == true) goto L6;
        return false;
    L6:
        if (r4.length() != 2) goto L8;
        return false;
    L8:
        char r5 = r4.charAt(2);
        if (Intrinsics.compare(97, r5) <= 0) goto L11;
    L12:
        return true;
    L11:
        if (Intrinsics.compare(r5, 122) > 0) goto L12;
        return false;
    }
}
