package kotlin.reflect.jvm.internal;

import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference;
import kotlin.jvm.internal.RepeatableContainer;
import kotlin.reflect.KCallable;
import kotlin.reflect.KType;
import kotlin.reflect.KVisibility;
import kotlin.reflect.jvm.internal.calls.AnnotationConstructorCallerKt;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMap;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.ReflectAnnotationSource;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.ReflectJavaClassFinderKt;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.ReflectKotlinClass;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.RuntimeModuleData;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.RuntimeSourceElementFactory;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaAnnotation;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaClass;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaElement;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinarySourceElement;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.BinaryVersion;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionRequirementTable;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.resolve.InlineClassesUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.constants.AnnotationValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ArrayValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.EnumValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ErrorValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.KClassValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.NullValue;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationComponents;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializedArrayValue;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.MemberDeserializer;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.text.StringsKt;
import kotlin.text.Typography;

/* JADX INFO: compiled from: util.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000Ê\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0012\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0000\u001al\u0010\u0011\u001a\u0002H\u0012\"\b\b\u0000\u0010\u0013*\u00020\u0014\"\b\b\u0001\u0010\u0012*\u00020\u00062\n\u0010\u0015\u001a\u0006\u0012\u0002\b\u00030\u00162\u0006\u0010\u0017\u001a\u0002H\u00132\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u001d\u0010\u001e\u001a\u0019\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u0002H\u0013\u0012\u0004\u0012\u0002H\u00120\u001f¢\u0006\u0002\b!H\u0000¢\u0006\u0002\u0010\"\u001a.\u0010#\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00162\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020'2\u0006\u0010)\u001a\u00020*H\u0002\u001a(\u0010#\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00162\u0006\u0010$\u001a\u00020%2\u0006\u0010+\u001a\u00020,2\b\b\u0002\u0010)\u001a\u00020*H\u0002\u001a%\u0010-\u001a\u0002H.\"\u0004\b\u0000\u0010.2\f\u0010/\u001a\b\u0012\u0004\u0012\u0002H.00H\u0080\bø\u0001\u0000¢\u0006\u0002\u00101\u001a\u0016\u00102\u001a\u0004\u0018\u00010\u000e*\u0002032\u0006\u0010$\u001a\u00020%H\u0002\u001a\u0014\u00104\u001a\b\u0012\u0002\b\u0003\u0018\u000105*\u0004\u0018\u00010\u000eH\u0000\u001a\u0010\u00106\u001a\u0004\u0018\u000107*\u0004\u0018\u00010\u000eH\u0000\u001a\u0014\u00108\u001a\b\u0012\u0002\b\u0003\u0018\u000109*\u0004\u0018\u00010\u000eH\u0000\u001a\u0012\u0010:\u001a\b\u0012\u0004\u0012\u00020<0;*\u00020=H\u0000\u001a\u0014\u0010>\u001a\u0006\u0012\u0002\b\u00030\u0016*\u0006\u0012\u0002\b\u00030\u0016H\u0000\u001a\u000e\u0010?\u001a\u0004\u0018\u00010<*\u00020@H\u0002\u001a\u0012\u0010A\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0016*\u00020BH\u0000\u001a\u000e\u0010C\u001a\u0004\u0018\u00010D*\u00020EH\u0000\u001a\u001a\u0010F\u001a\u0004\u0018\u00010\u000e*\u0006\u0012\u0002\b\u00030G2\u0006\u0010$\u001a\u00020%H\u0002\u001a\u0018\u0010H\u001a\b\u0012\u0004\u0012\u00020<0;*\b\u0012\u0004\u0012\u00020<0;H\u0002\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u0005*\u00020\u00068@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b\"\u0018\u0010\t\u001a\u00020\n*\u00020\u000b8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\f\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006I"}, d2 = {"JVM_STATIC", "Lkotlin/reflect/jvm/internal/impl/name/FqName;", "getJVM_STATIC", "()Lorg/jetbrains/kotlin/name/FqName;", "instanceReceiverParameter", "Lkotlin/reflect/jvm/internal/impl/descriptors/ReceiverParameterDescriptor;", "Lkotlin/reflect/jvm/internal/impl/descriptors/CallableDescriptor;", "getInstanceReceiverParameter", "(Lorg/jetbrains/kotlin/descriptors/CallableDescriptor;)Lorg/jetbrains/kotlin/descriptors/ReceiverParameterDescriptor;", "isInlineClassType", "", "Lkotlin/reflect/KType;", "(Lkotlin/reflect/KType;)Z", "defaultPrimitiveValue", "", "type", "Ljava/lang/reflect/Type;", "deserializeToDescriptor", "D", "M", "Lkotlin/reflect/jvm/internal/impl/protobuf/MessageLite;", "moduleAnchor", "Ljava/lang/Class;", "proto", "nameResolver", "Lkotlin/reflect/jvm/internal/impl/metadata/deserialization/NameResolver;", "typeTable", "Lkotlin/reflect/jvm/internal/impl/metadata/deserialization/TypeTable;", "metadataVersion", "Lkotlin/reflect/jvm/internal/impl/metadata/deserialization/BinaryVersion;", "createDescriptor", "Lkotlin/Function2;", "Lkotlin/reflect/jvm/internal/impl/serialization/deserialization/MemberDeserializer;", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/Class;Lorg/jetbrains/kotlin/protobuf/MessageLite;Lorg/jetbrains/kotlin/metadata/deserialization/NameResolver;Lorg/jetbrains/kotlin/metadata/deserialization/TypeTable;Lorg/jetbrains/kotlin/metadata/deserialization/BinaryVersion;Lkotlin/jvm/functions/Function2;)Lorg/jetbrains/kotlin/descriptors/CallableDescriptor;", "loadClass", "classLoader", "Ljava/lang/ClassLoader;", "packageName", "", "className", "arrayDimensions", "", "kotlinClassId", "Lkotlin/reflect/jvm/internal/impl/name/ClassId;", "reflectionCall", "R", "block", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "arrayToRuntimeValue", "Lkotlin/reflect/jvm/internal/impl/resolve/constants/ArrayValue;", "asKCallableImpl", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "asKFunctionImpl", "Lkotlin/reflect/jvm/internal/KFunctionImpl;", "asKPropertyImpl", "Lkotlin/reflect/jvm/internal/KPropertyImpl;", "computeAnnotations", "", "", "Lkotlin/reflect/jvm/internal/impl/descriptors/annotations/Annotated;", "createArrayType", "toAnnotationInstance", "Lkotlin/reflect/jvm/internal/impl/descriptors/annotations/AnnotationDescriptor;", "toJavaClass", "Lkotlin/reflect/jvm/internal/impl/descriptors/ClassDescriptor;", "toKVisibility", "Lkotlin/reflect/KVisibility;", "Lkotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibility;", "toRuntimeValue", "Lkotlin/reflect/jvm/internal/impl/resolve/constants/ConstantValue;", "unwrapRepeatableAnnotations", "kotlin-reflection"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class UtilKt {
    private static final FqName JVM_STATIC = null;

    /* JADX INFO: compiled from: util.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r0 = new int[PrimitiveType.values().length];
            r0[PrimitiveType.BOOLEAN.ordinal()] = 1;     // Catch: NoSuchFieldError -> L13
        L23:
            r0[PrimitiveType.CHAR.ordinal()] = 2;     // Catch: NoSuchFieldError -> L14
        L35:
            r0[PrimitiveType.BYTE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L15
        L25:
            r0[PrimitiveType.SHORT.ordinal()] = 4;     // Catch: NoSuchFieldError -> L16
        L27:
            r0[PrimitiveType.INT.ordinal()] = 5;     // Catch: NoSuchFieldError -> L17
        L21:
            r0[PrimitiveType.FLOAT.ordinal()] = 6;     // Catch: NoSuchFieldError -> L18
        L29:
            r0[PrimitiveType.LONG.ordinal()] = 7;     // Catch: NoSuchFieldError -> L19
        L31:
            r0[PrimitiveType.DOUBLE.ordinal()] = 8;     // Catch: NoSuchFieldError -> L20
        L11:
            $EnumSwitchMapping$0 = r0;
        }
    }

    static {
        JVM_STATIC = new FqName("kotlin.jvm.JvmStatic");
    }

    public static final FqName getJVM_STATIC() {
        return JVM_STATIC;
    }

    public static final Class<?> toJavaClass(ClassDescriptor r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        SourceElement r0 = r2.getSource();
        Intrinsics.checkNotNullExpressionValue(r0, "source");
        if ((r0 instanceof KotlinJvmBinarySourceElement) == false) goto L6;
        KotlinJvmBinaryClass r3 = ((KotlinJvmBinarySourceElement) r0).getBinaryClass();
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.runtime.components.ReflectKotlinClass");
        return ((ReflectKotlinClass) r3).getKlass();
    L6:
        if ((r0 instanceof RuntimeSourceElementFactory.RuntimeSourceElement) == false) goto L8;
        ReflectJavaElement r4 = ((RuntimeSourceElementFactory.RuntimeSourceElement) r0).getJavaElement();
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.runtime.structure.ReflectJavaClass");
        return ((ReflectJavaClass) r4).getElement();
    L8:
        ClassId r1 = DescriptorUtilsKt.getClassId(r2);
        if (r1 != null) goto L13;
        return null;
    L13:
        return loadClass(ReflectClassUtilKt.getSafeClassLoader(r2.getClass()), r1, 0);
    }

    static /* synthetic */ Class loadClass$default(ClassLoader r0, ClassId r1, int r2, int r3, Object r4) {
        if ((r3 & 4) == 0) goto L6;
        r2 = 0;
    L6:
        return loadClass(r0, r1, r2);
    }

    private static final Class<?> loadClass(ClassLoader r3, ClassId r4, int r5) {
        JavaToKotlinClassMap r0 = JavaToKotlinClassMap.INSTANCE;
        FqNameUnsafe r1 = r4.asSingleFqName().toUnsafe();
        Intrinsics.checkNotNullExpressionValue(r1, "kotlinClassId.asSingleFqName().toUnsafe()");
        ClassId r2 = r0.mapKotlinToJava(r1);
        if (r2 == null) goto L6;
        r4 = r2;
    L6:
        String r6 = r4.getPackageFqName().asString();
        Intrinsics.checkNotNullExpressionValue(r6, "javaClassId.packageFqName.asString()");
        String r7 = r4.getRelativeClassName().asString();
        Intrinsics.checkNotNullExpressionValue(r7, "javaClassId.relativeClassName.asString()");
        return loadClass(r3, r6, r7, r5);
    }

    private static final Class<?> loadClass(ClassLoader r6, String r7, String r8, int r9) {
        if (Intrinsics.areEqual(r7, "kotlin") == true) goto L5;
    L52:
        String r10 = r7 + '.' + StringsKt.replace$default(r8, '.', Typography.dollar, false, 4, null);
        if (r9 <= 0) goto L56;
        r10 = StringsKt.repeat("[", r9) + 'L' + r10 + ';';
    L56:
        return ReflectJavaClassFinderKt.tryLoadClass(r6, r10);
    L5:
        switch(r8.hashCode()) {
            case -901856463: goto L48;
            case -763279523: goto L43;
            case -755911549: goto L38;
            case -74930671: goto L33;
            case 22374632: goto L28;
            case 63537721: goto L23;
            case 601811914: goto L18;
            case 948852093: goto L13;
            case 2104330525: goto L8;
            default: goto L52;
        };
    L8:
        if (r8.equals("LongArray") == false) goto L52;
        return long[].class;
    L13:
        if (r8.equals("FloatArray") == false) goto L52;
        return float[].class;
    L18:
        if (r8.equals("IntArray") == false) goto L52;
        return int[].class;
    L23:
        if (r8.equals("Array") == false) goto L52;
        return Object[].class;
    L28:
        if (r8.equals("DoubleArray") == false) goto L52;
        return double[].class;
    L33:
        if (r8.equals("ByteArray") == false) goto L52;
        return byte[].class;
    L38:
        if (r8.equals("CharArray") == false) goto L52;
        return char[].class;
    L43:
        if (r8.equals("ShortArray") == false) goto L52;
        return short[].class;
    L48:
        if (r8.equals("BooleanArray") == false) goto L52;
        return boolean[].class;
    }

    public static final Class<?> createArrayType(Class<?> r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return Array.newInstance(r1, 0).getClass();
    }

    public static final KVisibility toKVisibility(DescriptorVisibility r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if (Intrinsics.areEqual(r1, DescriptorVisibilities.PUBLIC) == false) goto L6;
        return KVisibility.PUBLIC;
    L6:
        if (Intrinsics.areEqual(r1, DescriptorVisibilities.PROTECTED) == false) goto L9;
        return KVisibility.PROTECTED;
    L9:
        if (Intrinsics.areEqual(r1, DescriptorVisibilities.INTERNAL) == false) goto L12;
        return KVisibility.INTERNAL;
    L12:
        if (Intrinsics.areEqual(r1, DescriptorVisibilities.PRIVATE) == false) goto L14;
        boolean r2 = true;
    L15:
        if (r2 == true) goto L22;
        return null;
    L22:
        return KVisibility.PRIVATE;
    L14:
        r2 = Intrinsics.areEqual(r1, DescriptorVisibilities.PRIVATE_TO_THIS);
        goto L15
    }

    public static final List<Annotation> computeAnnotations(Annotated r4) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Annotations r5 = r4.getAnnotations();
        ArrayList r0 = new ArrayList();
        Iterator<AnnotationDescriptor> r6 = r5.iterator();
    L4:
        if (r6.hasNext() == false) goto L21;
        AnnotationDescriptor r1 = r6.next();
        SourceElement r2 = r1.getSource();
        if ((r2 instanceof ReflectAnnotationSource) == false) goto L9;
        Annotation r3 = ((ReflectAnnotationSource) r2).getAnnotation();
    L18:
        if (r3 == null) goto L4;
        r0.add(r3);
        goto L4
    L9:
        if ((r2 instanceof RuntimeSourceElementFactory.RuntimeSourceElement) == false) goto L17;
        ReflectJavaElement r7 = ((RuntimeSourceElementFactory.RuntimeSourceElement) r2).getJavaElement();
        if ((r7 instanceof ReflectJavaAnnotation) == false) goto L13;
        ReflectJavaAnnotation r8 = (ReflectJavaAnnotation) r7;
    L14:
        if (r8 == null) goto L16;
        r3 = r8.getAnnotation();
        goto L18
    L16:
        r3 = null;
        goto L18
    L13:
        r8 = null;
        goto L14
    L17:
        r3 = toAnnotationInstance(r1);
        goto L18
    L21:
        return unwrapRepeatableAnnotations(r0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final List<Annotation> unwrapRepeatableAnnotations(List<? extends Annotation> r7) {
        List<? extends Annotation> r0 = r7;
        if ((r0 instanceof Collection) == true) goto L5;
    L7:
        Iterator r1 = r0.iterator();
    L9:
        if (r1.hasNext() == false) goto L6;
        if (Intrinsics.areEqual(JvmClassMappingKt.getJavaClass(JvmClassMappingKt.getAnnotationClass((Annotation) r1.next())).getSimpleName(), "Container") == false) goto L9;
        boolean r2 = true;
    L13:
        if (r2 == false) goto L32;
        ArrayList r8 = new ArrayList();
        Iterator r3 = r0.iterator();
    L16:
        if (r3.hasNext() == false) goto L25;
        Annotation r4 = (Annotation) r3.next();
        Class r5 = JvmClassMappingKt.getJavaClass(JvmClassMappingKt.getAnnotationClass(r4));
        if (Intrinsics.areEqual(r5.getSimpleName(), "Container") == true) goto L20;
    L22:
        List r6 = CollectionsKt.listOf(r4);
    L23:
        CollectionsKt.addAll(r8, r6);
        goto L16
    L20:
        if (r5.getAnnotation(RepeatableContainer.class) == null) goto L22;
        Object r9 = r5.getDeclaredMethod("value", new Class[0]).invoke(r4, new Object[0]);
        Intrinsics.checkNotNull(r9, "null cannot be cast to non-null type kotlin.Array<out kotlin.Annotation>");
        r6 = ArraysKt.asList((Annotation[]) r9);
        goto L23
    L25:
        return r8;
    L32:
        return r7;
    L6:
        r2 = false;
        goto L13
    L5:
        if (r0.isEmpty() == false) goto L7;
        goto L6
    }

    private static final Annotation toAnnotationInstance(AnnotationDescriptor r7) {
        ClassDescriptor r0 = DescriptorUtilsKt.getAnnotationClass(r7);
        if (r0 == null) goto L5;
        Class<?> r1 = toJavaClass(r0);
    L7:
        if ((r1 instanceof Class) == true) goto L10;
        r1 = null;
    L10:
        if (r1 != null) goto L12;
        return null;
    L12:
        Set<Map.Entry<Name, ConstantValue<?>>> r8 = r7.getAllValueArguments().entrySet();
        ArrayList r2 = new ArrayList();
        Iterator<T> r9 = r8.iterator();
    L14:
        if (r9.hasNext() == false) goto L22;
        Map.Entry r3 = (Map.Entry) r9.next();
        Name r4 = (Name) r3.getKey();
        ConstantValue r5 = (ConstantValue) r3.getValue();
        ClassLoader r6 = r1.getClassLoader();
        Intrinsics.checkNotNullExpressionValue(r6, "annotationClass.classLoader");
        Object r10 = toRuntimeValue(r5, r6);
        if (r10 == null) goto L18;
        Pair r11 = TuplesKt.to(r4.asString(), r10);
    L19:
        if (r11 == null) goto L14;
        r2.add(r11);
        goto L14
    L18:
        r11 = null;
        goto L19
    L22:
        return (Annotation) AnnotationConstructorCallerKt.createAnnotationInstance$default(r1, MapsKt.toMap(r2), null, 4, null);
    L5:
        r1 = null;
        goto L7
    }

    private static final Object toRuntimeValue(ConstantValue<?> r4, ClassLoader r5) {
        if ((r4 instanceof AnnotationValue) == false) goto L6;
        return toAnnotationInstance(((AnnotationValue) r4).getValue());
    L6:
        if ((r4 instanceof ArrayValue) == false) goto L9;
        return arrayToRuntimeValue((ArrayValue) r4, r5);
    L9:
        if ((r4 instanceof EnumValue) == false) goto L15;
        Pair<? extends ClassId, ? extends Name> r6 = ((EnumValue) r4).getValue();
        ClassId r0 = r6.component1();
        Name r7 = r6.component2();
        Class r8 = loadClass$default(r5, r0, 0, 4, null);
        if (r8 == null) goto L40;
        return Util.getEnumConstantByName(r8, r7.asString());
    L40:
        return null;
    L15:
        if ((r4 instanceof KClassValue) == false) goto L30;
        KClassValue.Value r9 = ((KClassValue) r4).getValue();
        if ((r9 instanceof KClassValue.Value.NormalClass) == false) goto L20;
        KClassValue.Value.NormalClass r10 = (KClassValue.Value.NormalClass) r9;
        return loadClass(r5, r10.getClassId(), r10.getArrayDimensions());
    L20:
        if ((r9 instanceof KClassValue.Value.LocalClass) == false) goto L28;
        ClassifierDescriptor r11 = ((KClassValue.Value.LocalClass) r9).getType().getConstructor().mo2083getDeclarationDescriptor();
        if ((r11 instanceof ClassDescriptor) == false) goto L24;
        ClassDescriptor r12 = (ClassDescriptor) r11;
    L25:
        if (r12 == null) goto L40;
        return toJavaClass(r12);
    L24:
        r12 = null;
        goto L25
    L28:
        throw new NoWhenBranchMatchedException();
    L30:
        if ((r4 instanceof ErrorValue) == false) goto L32;
        boolean r13 = true;
    L33:
        if (r13 == true) goto L40;
        return r4.getValue();
    L32:
        r13 = r4 instanceof NullValue;
        goto L33
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v10, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r7v11, types: [java.lang.Class[]] */
    /* JADX WARN: Type inference failed for: r7v12, types: [java.lang.String[]] */
    /* JADX WARN: Type inference failed for: r7v17, types: [int[]] */
    /* JADX WARN: Type inference failed for: r7v18, types: [float[]] */
    /* JADX WARN: Type inference failed for: r7v19, types: [long[]] */
    /* JADX WARN: Type inference failed for: r7v21, types: [double[]] */
    private static final Object arrayToRuntimeValue(ArrayValue r6, ClassLoader r7) {
        if ((r6 instanceof DeserializedArrayValue) == false) goto L5;
        DeserializedArrayValue r0 = (DeserializedArrayValue) r6;
    L6:
        if (r0 == null) goto L77;
        KotlinType r1 = r0.getType();
        if (r1 == null) goto L77;
        List<? extends ConstantValue<?>> r2 = r6.getValue();
        ArrayList r3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r2, 10));
        Iterator<T> r4 = r2.iterator();
    L12:
        if (r4.hasNext() == false) goto L14;
        r3.add(toRuntimeValue((ConstantValue) r4.next(), r7));
        goto L12
    L14:
        ArrayList r5 = r3;
        PrimitiveType r8 = KotlinBuiltIns.getPrimitiveArrayElementType(r1);
        if (r8 != null) goto L17;
        int r9 = -1;
    L18:
        int r10 = 0;
        switch(r9) {
            case -1: goto L47;
            case 0: goto L21;
            case 1: goto L43;
            case 2: goto L40;
            case 3: goto L37;
            case 4: goto L34;
            case 5: goto L31;
            case 6: goto L28;
            case 7: goto L25;
            case 8: goto L22;
            default: goto L21;
        };
    L22:
        int r11 = r6.getValue().size();
        Object r12 = new double[r11];
    L23:
        if (r10 >= r11) goto L71;
        Object r13 = r5.get(r10);
        Intrinsics.checkNotNull(r13, "null cannot be cast to non-null type kotlin.Double");
        r12[r10] = ((Double) r13).doubleValue();
        r10 = r10 + 1;
    L71:
        return r12;
    L25:
        int r14 = r6.getValue().size();
        r12 = new long[r14];
    L26:
        if (r10 >= r14) goto L71;
        Object r15 = r5.get(r10);
        Intrinsics.checkNotNull(r15, "null cannot be cast to non-null type kotlin.Long");
        r12[r10] = ((Long) r15).longValue();
        r10 = r10 + 1;
        goto L26
    L28:
        int r16 = r6.getValue().size();
        r12 = new float[r16];
    L29:
        if (r10 >= r16) goto L71;
        Object r17 = r5.get(r10);
        Intrinsics.checkNotNull(r17, "null cannot be cast to non-null type kotlin.Float");
        r12[r10] = ((Float) r17).floatValue();
        r10 = r10 + 1;
        goto L29
    L31:
        int r18 = r6.getValue().size();
        r12 = new int[r18];
    L32:
        if (r10 >= r18) goto L71;
        Object r19 = r5.get(r10);
        Intrinsics.checkNotNull(r19, "null cannot be cast to non-null type kotlin.Int");
        r12[r10] = ((Integer) r19).intValue();
        r10 = r10 + 1;
        goto L32
    L34:
        int r20 = r6.getValue().size();
        r12 = new short[r20];
    L35:
        if (r10 >= r20) goto L71;
        Object r21 = r5.get(r10);
        Intrinsics.checkNotNull(r21, "null cannot be cast to non-null type kotlin.Short");
        r12[r10] = ((Short) r21).shortValue();
        r10 = r10 + 1;
        goto L35
    L37:
        int r22 = r6.getValue().size();
        r12 = new byte[r22];
    L38:
        if (r10 >= r22) goto L71;
        Object r23 = r5.get(r10);
        Intrinsics.checkNotNull(r23, "null cannot be cast to non-null type kotlin.Byte");
        r12[r10] = ((Byte) r23).byteValue();
        r10 = r10 + 1;
        goto L38
    L40:
        int r24 = r6.getValue().size();
        r12 = new char[r24];
    L41:
        if (r10 >= r24) goto L71;
        Object r25 = r5.get(r10);
        Intrinsics.checkNotNull(r25, "null cannot be cast to non-null type kotlin.Char");
        r12[r10] = ((Character) r25).charValue();
        r10 = r10 + 1;
        goto L41
    L43:
        int r26 = r6.getValue().size();
        r12 = new boolean[r26];
    L44:
        if (r10 >= r26) goto L71;
        Object r27 = r5.get(r10);
        Intrinsics.checkNotNull(r27, "null cannot be cast to non-null type kotlin.Boolean");
        r12[r10] = ((Boolean) r27).booleanValue();
        r10 = r10 + 1;
        goto L44
    L21:
        throw new NoWhenBranchMatchedException();
    L47:
        if (KotlinBuiltIns.isArray(r1) == false) goto L76;
        KotlinType r28 = ((TypeProjection) CollectionsKt.single(r1.getArguments())).getType();
        Intrinsics.checkNotNullExpressionValue(r28, "type.arguments.single().type");
        ClassifierDescriptor r29 = r28.getConstructor().mo2083getDeclarationDescriptor();
        if ((r29 instanceof ClassDescriptor) == false) goto L51;
        ClassDescriptor r30 = (ClassDescriptor) r29;
    L52:
        if (r30 == null) goto L74;
        if (KotlinBuiltIns.isString(r28) == false) goto L59;
        int r31 = r6.getValue().size();
        r12 = new String[r31];
    L56:
        if (r10 >= r31) goto L71;
        Object r32 = r5.get(r10);
        Intrinsics.checkNotNull(r32, "null cannot be cast to non-null type kotlin.String");
        r12[r10] = (String) r32;
        r10 = r10 + 1;
        goto L56
    L59:
        if (KotlinBuiltIns.isKClass(r30) == false) goto L63;
        int r33 = r6.getValue().size();
        r12 = new Class[r33];
    L61:
        if (r10 >= r33) goto L71;
        Object r34 = r5.get(r10);
        Intrinsics.checkNotNull(r34, "null cannot be cast to non-null type java.lang.Class<*>");
        r12[r10] = (Class) r34;
        r10 = r10 + 1;
        goto L61
    L63:
        ClassId r35 = DescriptorUtilsKt.getClassId(r30);
        if (r35 == null) goto L72;
        Class r36 = loadClass$default(r7, r35, 0, 4, null);
        if (r36 == null) goto L72;
        Object r37 = Array.newInstance(r36, r6.getValue().size());
        Intrinsics.checkNotNull(r37, "null cannot be cast to non-null type kotlin.Array<in kotlin.Any?>");
        r12 = (Object[]) r37;
        int r38 = r5.size();
    L69:
        if (r10 >= r38) goto L71;
        r12[r10] = r5.get(r10);
        r10 = r10 + 1;
    L72:
        return null;
    L74:
        throw new IllegalStateException(("Not a class type: " + r28).toString());
    L51:
        r30 = null;
        goto L52
    L76:
        throw new IllegalStateException(("Not an array type: " + r1).toString());
    L17:
        r9 = WhenMappings.$EnumSwitchMapping$0[r8.ordinal()];
    L77:
        return null;
    L5:
        r0 = null;
        goto L6
    }

    public static final KFunctionImpl asKFunctionImpl(Object r2) {
        if ((r2 instanceof KFunctionImpl) == false) goto L5;
        KFunctionImpl r0 = (KFunctionImpl) r2;
    L6:
        if (r0 != null) goto L18;
        if ((r2 instanceof FunctionReference) == false) goto L10;
        FunctionReference r3 = (FunctionReference) r2;
    L11:
        if (r3 == null) goto L13;
        KCallable r4 = r3.compute();
    L15:
        if ((r4 instanceof KFunctionImpl) == true) goto L20;
        return null;
    L20:
        return (KFunctionImpl) r4;
    L13:
        r4 = null;
        goto L15
    L10:
        r3 = null;
        goto L11
    L18:
        return r0;
    L5:
        r0 = null;
        goto L6
    }

    public static final KPropertyImpl<?> asKPropertyImpl(Object r2) {
        if ((r2 instanceof KPropertyImpl) == false) goto L5;
        KPropertyImpl<?> r0 = (KPropertyImpl) r2;
    L6:
        if (r0 != null) goto L18;
        if ((r2 instanceof PropertyReference) == false) goto L10;
        PropertyReference r3 = (PropertyReference) r2;
    L11:
        if (r3 == null) goto L13;
        KCallable r4 = r3.compute();
    L15:
        if ((r4 instanceof KPropertyImpl) == true) goto L20;
        return null;
    L20:
        return (KPropertyImpl) r4;
    L13:
        r4 = null;
        goto L15
    L10:
        r3 = null;
        goto L11
    L18:
        return r0;
    L5:
        r0 = null;
        goto L6
    }

    public static final KCallableImpl<?> asKCallableImpl(Object r1) {
        if ((r1 instanceof KCallableImpl) == false) goto L5;
        KCallableImpl<?> r0 = (KCallableImpl) r1;
    L6:
        if (r0 != null) goto L12;
        KFunctionImpl r2 = asKFunctionImpl(r1);
        if (r2 == null) goto L11;
        return r2;
    L11:
        return asKPropertyImpl(r1);
    L12:
        return r0;
    L5:
        r0 = null;
        goto L6
    }

    public static final ReceiverParameterDescriptor getInstanceReceiverParameter(CallableDescriptor r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if (r1.getDispatchReceiverParameter() == null) goto L5;
        DeclarationDescriptor r2 = r1.getContainingDeclaration();
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
        return ((ClassDescriptor) r2).getThisAsReceiverParameter();
    L5:
        return null;
    }

    public static final <M extends MessageLite, D extends CallableDescriptor> D deserializeToDescriptor(Class<?> r14, M r15, NameResolver r16, TypeTable r17, BinaryVersion r18, Function2<? super MemberDeserializer, ? super M, ? extends D> r19) {
        Intrinsics.checkNotNullParameter(r14, "moduleAnchor");
        Intrinsics.checkNotNullParameter(r15, "proto");
        Intrinsics.checkNotNullParameter(r16, "nameResolver");
        Intrinsics.checkNotNullParameter(r17, "typeTable");
        Intrinsics.checkNotNullParameter(r18, "metadataVersion");
        Intrinsics.checkNotNullParameter(r19, "createDescriptor");
        RuntimeModuleData r2 = ModuleByClassLoaderKt.getOrCreateModule(r14);
        if ((r15 instanceof ProtoBuf.Function) == false) goto L7;
        List<ProtoBuf.TypeParameter> r3 = ((ProtoBuf.Function) r15).getTypeParameterList();
    L5:
        List<ProtoBuf.TypeParameter> r12 = r3;
        DeserializationComponents r4 = r2.getDeserialization();
        ModuleDescriptor r6 = r2.getModule();
        VersionRequirementTable r8 = VersionRequirementTable.Companion.getEMPTY();
        Intrinsics.checkNotNullExpressionValue(r12, "typeParameters");
        return r19.invoke(new MemberDeserializer(new DeserializationContext(r4, r16, r6, r17, r8, r18, null, null, r12)), r15);
    L7:
        if ((r15 instanceof ProtoBuf.Property) == false) goto L12;
        r3 = ((ProtoBuf.Property) r15).getTypeParameterList();
        goto L5
    L12:
        throw new IllegalStateException(("Unsupported message: " + r15).toString());
    }

    public static final boolean isInlineClassType(KType r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        if ((r2 instanceof KTypeImpl) == false) goto L5;
        KTypeImpl r3 = (KTypeImpl) r2;
    L7:
        if (r3 == null) goto L14;
        KotlinType r4 = r3.getType();
        if (r4 != null) goto L11;
        return false;
    L11:
        if (InlineClassesUtilsKt.isInlineClassType(r4) == true) goto L13;
        return false;
    L13:
        return true;
    L14:
        return false;
    L5:
        r3 = null;
        goto L7
    }

    public static final Object defaultPrimitiveValue(Type r3) {
        Intrinsics.checkNotNullParameter(r3, "type");
        if ((r3 instanceof Class) == true) goto L5;
    L36:
        return null;
    L5:
        if (((Class) r3).isPrimitive() == false) goto L36;
        if (Intrinsics.areEqual(r3, Boolean.TYPE) == false) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(r3, Character.TYPE) == false) goto L13;
        return (char) 0;
    L13:
        if (Intrinsics.areEqual(r3, Byte.TYPE) == false) goto L16;
        return (byte) 0;
    L16:
        if (Intrinsics.areEqual(r3, Short.TYPE) == false) goto L19;
        return (short) 0;
    L19:
        if (Intrinsics.areEqual(r3, Integer.TYPE) == false) goto L22;
        return 0;
    L22:
        if (Intrinsics.areEqual(r3, Float.TYPE) == false) goto L25;
        return Float.valueOf(0.0f);
    L25:
        if (Intrinsics.areEqual(r3, Long.TYPE) == false) goto L28;
        return 0L;
    L28:
        if (Intrinsics.areEqual(r3, Double.TYPE) == false) goto L31;
        return Double.valueOf(0.0d);
    L31:
        if (Intrinsics.areEqual(r3, Void.TYPE) == false) goto L35;
        throw new IllegalStateException("Parameter with void type is illegal");
    L35:
        throw new UnsupportedOperationException("Unknown primitive: " + r3);
    }
}
