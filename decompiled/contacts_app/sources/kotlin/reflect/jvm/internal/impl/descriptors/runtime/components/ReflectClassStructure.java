package kotlin.reflect.jvm.internal.impl.descriptors.runtime.components;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMap;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.name.SpecialNames;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ClassLiteralValue;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;

/* JADX INFO: compiled from: ReflectKotlinClass.kt */
/* JADX INFO: loaded from: classes4.dex */
final class ReflectClassStructure {
    public static final ReflectClassStructure INSTANCE = null;

    static {
        INSTANCE = new ReflectClassStructure();
    }

    private ReflectClassStructure() {
    }

    public final void loadClassAnnotations(Class<?> r5, KotlinJvmBinaryClass.AnnotationVisitor r6) {
        Intrinsics.checkNotNullParameter(r5, "klass");
        Intrinsics.checkNotNullParameter(r6, "visitor");
        Annotation[] r7 = r5.getDeclaredAnnotations();
        Intrinsics.checkNotNullExpressionValue(r7, "klass.declaredAnnotations");
        int r0 = r7.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        Annotation r2 = r7[r1];
        Intrinsics.checkNotNullExpressionValue(r2, "annotation");
        processAnnotation(r6, r2);
        r1 = r1 + 1;
        goto L3
    L5:
        r6.visitEnd();
    }

    public final void visitMembers(Class<?> r2, KotlinJvmBinaryClass.MemberVisitor r3) {
        Intrinsics.checkNotNullParameter(r2, "klass");
        Intrinsics.checkNotNullParameter(r3, "memberVisitor");
        loadMethodAnnotations(r2, r3);
        loadConstructorAnnotations(r2, r3);
        loadFieldAnnotations(r2, r3);
    }

    private final void loadMethodAnnotations(Class<?> r18, KotlinJvmBinaryClass.MemberVisitor r19) {
        Method[] r0 = r18.getDeclaredMethods();
        Intrinsics.checkNotNullExpressionValue(r0, "klass.declaredMethods");
        int r1 = r0.length;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L22;
        Method r4 = r0[r3];
        Name r5 = Name.identifier(r4.getName());
        Intrinsics.checkNotNullExpressionValue(r5, "identifier(method.name)");
        SignatureSerializer r6 = SignatureSerializer.INSTANCE;
        Intrinsics.checkNotNullExpressionValue(r4, "method");
        KotlinJvmBinaryClass.MethodAnnotationVisitor r7 = r19.visitMethod(r5, r6.methodDesc(r4));
        if (r7 != null) goto L7;
        Method[] r16 = r0;
    L21:
        r3 = r3 + 1;
        r0 = r16;
        goto L3
    L7:
        Annotation[] r8 = r4.getDeclaredAnnotations();
        Intrinsics.checkNotNullExpressionValue(r8, "method.declaredAnnotations");
        int r9 = r8.length;
        int r10 = 0;
    L9:
        if (r10 >= r9) goto L11;
        Annotation r11 = r8[r10];
        Intrinsics.checkNotNullExpressionValue(r11, "annotation");
        processAnnotation(r7, r11);
        r10 = r10 + 1;
        goto L9
    L11:
        Annotation[][] r12 = r4.getParameterAnnotations();
        Intrinsics.checkNotNullExpressionValue(r12, "method.parameterAnnotations");
        Annotation[][] r13 = r12;
        int r14 = r13.length;
        int r15 = 0;
    L12:
        if (r15 >= r14) goto L20;
        Annotation[] r17 = r13[r15];
        Intrinsics.checkNotNullExpressionValue(r17, "annotations");
        int r110 = r17.length;
        int r111 = 0;
    L14:
        if (r111 >= r110) goto L19;
        Annotation r112 = r17[r111];
        Class<?> r113 = JvmClassMappingKt.getJavaClass(JvmClassMappingKt.getAnnotationClass(r112));
        ClassId r2 = ReflectClassUtilKt.getClassId(r113);
        Method[] r114 = r0;
        Intrinsics.checkNotNullExpressionValue(r112, "annotation");
        KotlinJvmBinaryClass.AnnotationArgumentVisitor r20 = r7.visitParameterAnnotation(r15, r2, new ReflectAnnotationSource(r112));
        if (r20 == null) goto L18;
        INSTANCE.processAnnotationArguments(r20, r112, r113);
    L18:
        r111 = r111 + 1;
        r0 = r114;
        goto L14
    L19:
        r15 = r15 + 1;
        goto L12
    L20:
        r16 = r0;
        r7.visitEnd();
        goto L21
    }

    private final void loadConstructorAnnotations(Class<?> r20, KotlinJvmBinaryClass.MemberVisitor r21) {
        Constructor<?>[] r0 = r20.getDeclaredConstructors();
        Intrinsics.checkNotNullExpressionValue(r0, "klass.declaredConstructors");
        int r1 = r0.length;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L28;
        Constructor<?> r4 = r0[r3];
        Name r5 = SpecialNames.INIT;
        SignatureSerializer r6 = SignatureSerializer.INSTANCE;
        Intrinsics.checkNotNullExpressionValue(r4, "constructor");
        KotlinJvmBinaryClass.MethodAnnotationVisitor r7 = r21.visitMethod(r5, r6.constructorDesc(r4));
        if (r7 != null) goto L7;
        Constructor<?>[] r16 = r0;
        int r17 = r1;
    L27:
        r3 = r3 + 1;
        r0 = r16;
        r1 = r17;
        goto L3
    L7:
        Annotation[] r8 = r4.getDeclaredAnnotations();
        Intrinsics.checkNotNullExpressionValue(r8, "constructor.declaredAnnotations");
        int r9 = r8.length;
        int r10 = 0;
    L9:
        if (r10 >= r9) goto L11;
        Annotation r11 = r8[r10];
        Intrinsics.checkNotNullExpressionValue(r11, "annotation");
        processAnnotation(r7, r11);
        r10 = r10 + 1;
        goto L9
    L11:
        Annotation[][] r12 = r4.getParameterAnnotations();
        Intrinsics.checkNotNullExpressionValue(r12, "parameterAnnotations");
        Annotation[][] r13 = r12;
        if (r13.length != 0) goto L14;
        boolean r14 = true;
    L16:
        if ((!r14) == false) goto L26;
        int r15 = r4.getParameterTypes().length - r13.length;
        int r18 = r13.length;
        int r19 = 0;
    L18:
        if (r19 >= r18) goto L26;
        Annotation[] r110 = r12[r19];
        Intrinsics.checkNotNullExpressionValue(r110, "annotations");
        int r111 = r110.length;
        int r112 = 0;
    L20:
        if (r112 >= r111) goto L25;
        Annotation r113 = r110[r112];
        Class<?> r2 = JvmClassMappingKt.getJavaClass(JvmClassMappingKt.getAnnotationClass(r113));
        Constructor<?>[] r114 = r0;
        int r115 = r1;
        ClassId r22 = ReflectClassUtilKt.getClassId(r2);
        int r116 = r15;
        Intrinsics.checkNotNullExpressionValue(r113, "annotation");
        KotlinJvmBinaryClass.AnnotationArgumentVisitor r23 = r7.visitParameterAnnotation(r19 + r15, r22, new ReflectAnnotationSource(r113));
        if (r23 == null) goto L24;
        INSTANCE.processAnnotationArguments(r23, r113, r2);
    L24:
        r112 = r112 + 1;
        r0 = r114;
        r1 = r115;
        r15 = r116;
        goto L20
    L25:
        r19 = r19 + 1;
    L26:
        r16 = r0;
        r17 = r1;
        r7.visitEnd();
        goto L27
    L14:
        r14 = false;
        goto L16
    }

    private final void loadFieldAnnotations(Class<?> r10, KotlinJvmBinaryClass.MemberVisitor r11) {
        Field[] r12 = r10.getDeclaredFields();
        Intrinsics.checkNotNullExpressionValue(r12, "klass.declaredFields");
        int r0 = r12.length;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L12;
        Field r3 = r12[r2];
        Name r4 = Name.identifier(r3.getName());
        Intrinsics.checkNotNullExpressionValue(r4, "identifier(field.name)");
        SignatureSerializer r5 = SignatureSerializer.INSTANCE;
        Intrinsics.checkNotNullExpressionValue(r3, "field");
        KotlinJvmBinaryClass.AnnotationVisitor r6 = r11.visitField(r4, r5.fieldDesc(r3), null);
        if (r6 == null) goto L11;
        Annotation[] r7 = r3.getDeclaredAnnotations();
        Intrinsics.checkNotNullExpressionValue(r7, "field.declaredAnnotations");
        int r8 = r7.length;
        int r9 = 0;
    L8:
        if (r9 >= r8) goto L10;
        Annotation r13 = r7[r9];
        Intrinsics.checkNotNullExpressionValue(r13, "annotation");
        processAnnotation(r6, r13);
        r9 = r9 + 1;
        goto L8
    L10:
        r6.visitEnd();
    L11:
        r2 = r2 + 1;
        goto L3
    }

    private final void processAnnotation(KotlinJvmBinaryClass.AnnotationVisitor r3, Annotation r4) {
        Class<?> r2 = JvmClassMappingKt.getJavaClass(JvmClassMappingKt.getAnnotationClass(r4));
        KotlinJvmBinaryClass.AnnotationArgumentVisitor r5 = r3.visitAnnotation(ReflectClassUtilKt.getClassId(r2), new ReflectAnnotationSource(r4));
        if (r5 == null) goto L6;
        INSTANCE.processAnnotationArguments(r5, r4, r2);
        return;
    }

    private final void processAnnotationArguments(KotlinJvmBinaryClass.AnnotationArgumentVisitor r7, Annotation r8, Class<?> r9) {
        Method[] r10 = r9.getDeclaredMethods();
        Intrinsics.checkNotNullExpressionValue(r10, "annotationType.declaredMethods");
        int r0 = r10.length;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L8;
        Method r3 = r10[r2];
        Object r4 = r3.invoke(r8, new Object[0]);     // Catch: IllegalAccessException -> L10
        Intrinsics.checkNotNull(r4);     // Catch: IllegalAccessException -> L10
        Name r5 = Name.identifier(r3.getName());
        Intrinsics.checkNotNullExpressionValue(r5, "identifier(method.name)");
        processAnnotationArgumentValue(r7, r5, r4);
    L7:
        r2 = r2 + 1;
        goto L3
    L8:
        r7.visitEnd();
    }

    private final ClassLiteralValue classLiteralValue(Class<?> r4) {
        int r3 = 0;
    L4:
        if (r4.isArray() == false) goto L7;
        r3 = r3 + 1;
        r4 = r4.getComponentType();
        Intrinsics.checkNotNullExpressionValue(r4, "currentClass.componentType");
        goto L4
    L7:
        if (r4.isPrimitive() == true) goto L9;
        ClassId r5 = ReflectClassUtilKt.getClassId(r4);
        JavaToKotlinClassMap r0 = JavaToKotlinClassMap.INSTANCE;
        FqName r1 = r5.asSingleFqName();
        Intrinsics.checkNotNullExpressionValue(r1, "javaClassId.asSingleFqName()");
        ClassId r2 = r0.mapJavaToKotlin(r1);
        if (r2 == null) goto L23;
        r5 = r2;
    L23:
        return new ClassLiteralValue(r5, r3);
    L9:
        if (Intrinsics.areEqual(r4, Void.TYPE) == false) goto L12;
        ClassId r6 = ClassId.topLevel(StandardNames.FqNames.unit.toSafe());
        Intrinsics.checkNotNullExpressionValue(r6, "topLevel(StandardNames.FqNames.unit.toSafe())");
        return new ClassLiteralValue(r6, r3);
    L12:
        PrimitiveType r7 = JvmPrimitiveType.get(r4.getName()).getPrimitiveType();
        Intrinsics.checkNotNullExpressionValue(r7, "get(currentClass.name).primitiveType");
        if (r3 <= 0) goto L16;
        ClassId r8 = ClassId.topLevel(r7.getArrayTypeFqName());
        Intrinsics.checkNotNullExpressionValue(r8, "topLevel(primitiveType.arrayTypeFqName)");
        return new ClassLiteralValue(r8, r3 - 1);
    L16:
        ClassId r9 = ClassId.topLevel(r7.getTypeFqName());
        Intrinsics.checkNotNullExpressionValue(r9, "topLevel(primitiveType.typeFqName)");
        return new ClassLiteralValue(r9, r3);
    }

    private final void processAnnotationArgumentValue(KotlinJvmBinaryClass.AnnotationArgumentVisitor r8, Name r9, Object r10) {
        Class<?> r0 = r10.getClass();
        if (Intrinsics.areEqual(r0, Class.class) == false) goto L6;
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type java.lang.Class<*>");
        r8.visitClassLiteral(r9, classLiteralValue((Class) r10));
        return;
    L6:
        if (ReflectKotlinClassKt.access$getTYPES_ELIGIBLE_FOR_SIMPLE_VISIT$p().contains(r0) == false) goto L9;
        r8.visit(r9, r10);
        return;
    L9:
        if (ReflectClassUtilKt.isEnumClassOrSpecializedEnumEntryClass(r0) == false) goto L16;
        if (r0.isEnum() == true) goto L14;
        r0 = r0.getEnclosingClass();
    L14:
        Intrinsics.checkNotNullExpressionValue(r0, "if (clazz.isEnum) clazz else clazz.enclosingClass");
        ClassId r7 = ReflectClassUtilKt.getClassId(r0);
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type kotlin.Enum<*>");
        Name r11 = Name.identifier(((Enum) r10).name());
        Intrinsics.checkNotNullExpressionValue(r11, "identifier((value as Enum<*>).name)");
        r8.visitEnum(r9, r7, r11);
        return;
    L16:
        if (Annotation.class.isAssignableFrom(r0) == false) goto L22;
        Class<?>[] r1 = r0.getInterfaces();
        Intrinsics.checkNotNullExpressionValue(r1, "clazz.interfaces");
        Class<?> r2 = (Class) ArraysKt.single(r1);
        Intrinsics.checkNotNullExpressionValue(r2, "annotationClass");
        KotlinJvmBinaryClass.AnnotationArgumentVisitor r12 = r8.visitAnnotation(r9, ReflectClassUtilKt.getClassId(r2));
        if (r12 != null) goto L20;
        return;
    L20:
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type kotlin.Annotation");
        processAnnotationArguments(r12, (Annotation) r10, r2);
        return;
    L22:
        if (r0.isArray() == false) goto L51;
        KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor r13 = r8.visitArray(r9);
        if (r13 != null) goto L26;
        return;
    L26:
        Class<?> r14 = r0.getComponentType();
        int r5 = 0;
        if (r14.isEnum() == false) goto L32;
        Intrinsics.checkNotNullExpressionValue(r14, "componentType");
        ClassId r15 = ReflectClassUtilKt.getClassId(r14);
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type kotlin.Array<*>");
        Object[] r16 = (Object[]) r10;
        int r17 = r16.length;
    L29:
        if (r5 >= r17) goto L48;
        Object r3 = r16[r5];
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type kotlin.Enum<*>");
        Name r4 = Name.identifier(((Enum) r3).name());
        Intrinsics.checkNotNullExpressionValue(r4, "identifier((element as Enum<*>).name)");
        r13.visitEnum(r15, r4);
        r5 = r5 + 1;
    L48:
        r13.visitEnd();
        return;
    L32:
        if (Intrinsics.areEqual(r14, Class.class) == false) goto L37;
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type kotlin.Array<*>");
        Object[] r18 = (Object[]) r10;
        int r19 = r18.length;
    L34:
        if (r5 >= r19) goto L48;
        Object r6 = r18[r5];
        Intrinsics.checkNotNull(r6, "null cannot be cast to non-null type java.lang.Class<*>");
        r13.visitClassLiteral(classLiteralValue((Class) r6));
        r5 = r5 + 1;
        goto L34
    L37:
        if (Annotation.class.isAssignableFrom(r14) == false) goto L45;
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type kotlin.Array<*>");
        Object[] r110 = (Object[]) r10;
        int r20 = r110.length;
    L39:
        if (r5 >= r20) goto L48;
        Object r21 = r110[r5];
        Intrinsics.checkNotNullExpressionValue(r14, "componentType");
        KotlinJvmBinaryClass.AnnotationArgumentVisitor r22 = r13.visitAnnotation(ReflectClassUtilKt.getClassId(r14));
        if (r22 == null) goto L44;
        Intrinsics.checkNotNull(r21, "null cannot be cast to non-null type kotlin.Annotation");
        processAnnotationArguments(r22, (Annotation) r21, r14);
    L44:
        r5 = r5 + 1;
        goto L39
    L45:
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type kotlin.Array<*>");
        Object[] r111 = (Object[]) r10;
        int r23 = r111.length;
    L46:
        if (r5 >= r23) goto L48;
        r13.visit(r111[r5]);
        r5 = r5 + 1;
        goto L46
    L51:
        throw new UnsupportedOperationException("Unsupported annotation argument value (" + r0 + "): " + r10);
    }
}
