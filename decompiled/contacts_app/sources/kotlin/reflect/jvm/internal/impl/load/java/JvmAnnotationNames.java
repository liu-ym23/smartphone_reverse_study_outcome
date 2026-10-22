package kotlin.reflect.jvm.internal.impl.load.java;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmClassName;

/* JADX INFO: loaded from: classes4.dex */
public final class JvmAnnotationNames {
    public static final Name DEFAULT_ANNOTATION_MEMBER_NAME = null;
    public static final FqName DEPRECATED_ANNOTATION = null;
    public static final FqName DOCUMENTED_ANNOTATION = null;
    public static final FqName ELEMENT_TYPE_ENUM = null;
    public static final FqName ENHANCED_MUTABILITY_ANNOTATION = null;
    public static final FqName ENHANCED_NULLABILITY_ANNOTATION = null;
    public static final FqName JETBRAINS_MUTABLE_ANNOTATION = null;
    public static final FqName JETBRAINS_NOT_NULL_ANNOTATION = null;
    public static final FqName JETBRAINS_NULLABLE_ANNOTATION = null;
    public static final FqName JETBRAINS_READONLY_ANNOTATION = null;
    public static final FqName KOTLIN_JVM_INTERNAL = null;
    public static final String METADATA_DESC = null;
    public static final FqName METADATA_FQ_NAME = null;
    public static final FqName MUTABLE_ANNOTATION = null;
    public static final FqName PURELY_IMPLEMENTS_ANNOTATION = null;
    public static final FqName READONLY_ANNOTATION = null;
    public static final FqName REPEATABLE_ANNOTATION = null;
    public static final FqName RETENTION_ANNOTATION = null;
    public static final FqName RETENTION_POLICY_ENUM = null;
    public static final String SERIALIZED_IR_DESC = null;
    public static final FqName SERIALIZED_IR_FQ_NAME = null;
    public static final FqName TARGET_ANNOTATION = null;

    static {
        FqName r0 = new FqName("kotlin.Metadata");
        METADATA_FQ_NAME = r0;
        METADATA_DESC = "L" + JvmClassName.byFqNameWithoutInnerClasses(r0).getInternalName() + ";";
        DEFAULT_ANNOTATION_MEMBER_NAME = Name.identifier("value");
        TARGET_ANNOTATION = new FqName(Target.class.getName());
        ELEMENT_TYPE_ENUM = new FqName(ElementType.class.getName());
        RETENTION_ANNOTATION = new FqName(Retention.class.getName());
        RETENTION_POLICY_ENUM = new FqName(RetentionPolicy.class.getName());
        DEPRECATED_ANNOTATION = new FqName(Deprecated.class.getName());
        DOCUMENTED_ANNOTATION = new FqName(Documented.class.getName());
        REPEATABLE_ANNOTATION = new FqName("java.lang.annotation.Repeatable");
        JETBRAINS_NOT_NULL_ANNOTATION = new FqName("org.jetbrains.annotations.NotNull");
        JETBRAINS_NULLABLE_ANNOTATION = new FqName("org.jetbrains.annotations.Nullable");
        JETBRAINS_MUTABLE_ANNOTATION = new FqName("org.jetbrains.annotations.Mutable");
        JETBRAINS_READONLY_ANNOTATION = new FqName("org.jetbrains.annotations.ReadOnly");
        READONLY_ANNOTATION = new FqName("kotlin.annotations.jvm.ReadOnly");
        MUTABLE_ANNOTATION = new FqName("kotlin.annotations.jvm.Mutable");
        PURELY_IMPLEMENTS_ANNOTATION = new FqName("kotlin.jvm.PurelyImplements");
        KOTLIN_JVM_INTERNAL = new FqName("kotlin.jvm.internal");
        FqName r1 = new FqName("kotlin.jvm.internal.SerializedIr");
        SERIALIZED_IR_FQ_NAME = r1;
        SERIALIZED_IR_DESC = "L" + JvmClassName.byFqNameWithoutInnerClasses(r1).getInternalName() + ";";
        ENHANCED_NULLABILITY_ANNOTATION = new FqName("kotlin.jvm.internal.EnhancedNullability");
        ENHANCED_MUTABILITY_ANNOTATION = new FqName("kotlin.jvm.internal.EnhancedMutability");
    }
}
