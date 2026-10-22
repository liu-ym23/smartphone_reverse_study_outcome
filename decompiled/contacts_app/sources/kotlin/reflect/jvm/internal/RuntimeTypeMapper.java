package kotlin.reflect.jvm.internal;

import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.CloneableClassScope;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMap;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyGetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertySetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaClass;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaConstructor;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaField;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaMethod;
import kotlin.reflect.jvm.internal.impl.load.java.JvmAbi;
import kotlin.reflect.jvm.internal.impl.load.java.SpecialBuiltinMembers;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaMethodDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaPropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.sources.JavaSourceElement;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaElement;
import kotlin.reflect.jvm.internal.impl.load.kotlin.MethodSignatureMappingKt;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoBufUtilKt;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMemberSignature;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmProtoBufUtil;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorFactory;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.InlineClassesUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedCallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedPropertyDescriptor;

/* JADX INFO: compiled from: RuntimeTypeMapper.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002J\u0012\u0010\u000e\u001a\u00020\u00042\n\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\u0007J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\rH\u0002J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\u0014H\u0002J\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018J\u000e\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\rR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u0006*\u0006\u0012\u0002\b\u00030\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\u001c"}, d2 = {"Lkotlin/reflect/jvm/internal/RuntimeTypeMapper;", "", "()V", "JAVA_LANG_VOID", "Lkotlin/reflect/jvm/internal/impl/name/ClassId;", "primitiveType", "Lkotlin/reflect/jvm/internal/impl/builtins/PrimitiveType;", "Ljava/lang/Class;", "getPrimitiveType", "(Ljava/lang/Class;)Lorg/jetbrains/kotlin/builtins/PrimitiveType;", "isKnownBuiltInFunction", "", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor;", "mapJvmClassToKotlinClassId", "klass", "mapJvmFunctionSignature", "Lkotlin/reflect/jvm/internal/JvmFunctionSignature$KotlinFunction;", "mapName", "", "Lkotlin/reflect/jvm/internal/impl/descriptors/CallableMemberDescriptor;", "mapPropertySignature", "Lkotlin/reflect/jvm/internal/JvmPropertySignature;", "possiblyOverriddenProperty", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "mapSignature", "Lkotlin/reflect/jvm/internal/JvmFunctionSignature;", "possiblySubstitutedFunction", "kotlin-reflection"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class RuntimeTypeMapper {
    public static final RuntimeTypeMapper INSTANCE = null;
    private static final ClassId JAVA_LANG_VOID = null;

    private RuntimeTypeMapper() {
    }

    static {
        INSTANCE = new RuntimeTypeMapper();
        ClassId r0 = ClassId.topLevel(new FqName("java.lang.Void"));
        Intrinsics.checkNotNullExpressionValue(r0, "topLevel(FqName(\"java.lang.Void\"))");
        JAVA_LANG_VOID = r0;
    }

    public final JvmFunctionSignature mapSignature(FunctionDescriptor r8) {
        Intrinsics.checkNotNullParameter(r8, "possiblySubstitutedFunction");
        FunctionDescriptor r0 = ((FunctionDescriptor) DescriptorUtils.unwrapFakeOverride(r8)).getOriginal();
        Intrinsics.checkNotNullExpressionValue(r0, "unwrapFakeOverride(possi…titutedFunction).original");
        if ((r0 instanceof DeserializedCallableMemberDescriptor) == false) goto L21;
        DeserializedCallableMemberDescriptor r1 = (DeserializedCallableMemberDescriptor) r0;
        MessageLite r2 = r1.getProto();
        if ((r2 instanceof ProtoBuf.Function) == false) goto L11;
        JvmMemberSignature.Method r3 = JvmProtoBufUtil.INSTANCE.getJvmMethodSignature((ProtoBuf.Function) r2, r1.getNameResolver(), r1.getTypeTable());
        if (r3 == null) goto L11;
        return new JvmFunctionSignature.KotlinFunction(r3);
    L11:
        if ((r2 instanceof ProtoBuf.Constructor) == false) goto L20;
        JvmMemberSignature.Method r4 = JvmProtoBufUtil.INSTANCE.getJvmConstructorSignature((ProtoBuf.Constructor) r2, r1.getNameResolver(), r1.getTypeTable());
        if (r4 == null) goto L20;
        DeclarationDescriptor r7 = r8.getContainingDeclaration();
        Intrinsics.checkNotNullExpressionValue(r7, "possiblySubstitutedFunction.containingDeclaration");
        if (InlineClassesUtilsKt.isInlineClass(r7) == false) goto L18;
        return new JvmFunctionSignature.KotlinFunction(r4);
    L18:
        return new JvmFunctionSignature.KotlinConstructor(r4);
    L20:
        return mapJvmFunctionSignature(r0);
    L21:
        JavaElement r5 = null;
        ReflectJavaMethod r6 = null;
        if ((r0 instanceof JavaMethodDescriptor) == false) goto L41;
        SourceElement r9 = ((JavaMethodDescriptor) r0).getSource();
        if ((r9 instanceof JavaSourceElement) == false) goto L26;
        JavaSourceElement r10 = (JavaSourceElement) r9;
    L27:
        if (r10 == null) goto L29;
        JavaElement r11 = r10.getJavaElement();
    L31:
        if ((r11 instanceof ReflectJavaMethod) == false) goto L33;
        r6 = (ReflectJavaMethod) r11;
    L33:
        if (r6 == null) goto L39;
        Method r12 = r6.getMember();
        if (r12 == null) goto L39;
        return new JvmFunctionSignature.JavaMethod(r12);
    L39:
        throw new KotlinReflectionInternalError("Incorrect resolution sequence for Java method " + r0);
    L29:
        r11 = null;
        goto L31
    L26:
        r10 = null;
        goto L27
    L41:
        if ((r0 instanceof JavaClassConstructorDescriptor) == false) goto L60;
        SourceElement r13 = ((JavaClassConstructorDescriptor) r0).getSource();
        if ((r13 instanceof JavaSourceElement) == false) goto L45;
        JavaSourceElement r14 = (JavaSourceElement) r13;
    L46:
        if (r14 == null) goto L49;
        r5 = r14.getJavaElement();
    L49:
        if ((r5 instanceof ReflectJavaConstructor) == false) goto L52;
        return new JvmFunctionSignature.JavaConstructor(((ReflectJavaConstructor) r5).getMember());
    L52:
        if ((r5 instanceof ReflectJavaClass) == false) goto L58;
        ReflectJavaClass r15 = (ReflectJavaClass) r5;
        if (r15.isAnnotationType() == false) goto L58;
        return new JvmFunctionSignature.FakeJavaAnnotationConstructor(r15.getElement());
    L58:
        throw new KotlinReflectionInternalError("Incorrect resolution sequence for Java constructor " + r0 + " (" + r5 + ')');
    L45:
        r14 = null;
        goto L46
    L60:
        if (isKnownBuiltInFunction(r0) == false) goto L64;
        return mapJvmFunctionSignature(r0);
    L64:
        throw new KotlinReflectionInternalError("Unknown origin of " + r0 + " (" + r0.getClass() + ')');
    }

    public final JvmPropertySignature mapPropertySignature(PropertyDescriptor r7) {
        Intrinsics.checkNotNullParameter(r7, "possiblyOverriddenProperty");
        PropertyDescriptor r1 = ((PropertyDescriptor) DescriptorUtils.unwrapFakeOverride(r7)).getOriginal();
        Intrinsics.checkNotNullExpressionValue(r1, "unwrapFakeOverride(possi…rriddenProperty).original");
        Method r0 = null;
        JvmFunctionSignature.KotlinFunction r2 = null;
        if ((r1 instanceof DeserializedPropertyDescriptor) == false) goto L9;
        DeserializedPropertyDescriptor r8 = (DeserializedPropertyDescriptor) r1;
        ProtoBuf.Property r3 = r8.getProto();
        GeneratedMessageLite.GeneratedExtension<ProtoBuf.Property, JvmProtoBuf.JvmPropertySignature> r4 = JvmProtoBuf.propertySignature;
        Intrinsics.checkNotNullExpressionValue(r4, "propertySignature");
        JvmProtoBuf.JvmPropertySignature r5 = (JvmProtoBuf.JvmPropertySignature) ProtoBufUtilKt.getExtensionOrNull(r3, r4);
        if (r5 != null) goto L7;
    L43:
        PropertyGetterDescriptor r9 = r1.getGetter();
        Intrinsics.checkNotNull(r9);
        JvmFunctionSignature.KotlinFunction r10 = mapJvmFunctionSignature(r9);
        PropertySetterDescriptor r6 = r1.getSetter();
        if (r6 == null) goto L47;
        r2 = mapJvmFunctionSignature(r6);
    L47:
        return new JvmPropertySignature.MappedKotlinProperty(r10, r2);
    L7:
        return new JvmPropertySignature.KotlinProperty(r1, r3, r5, r8.getNameResolver(), r8.getTypeTable());
    L9:
        if ((r1 instanceof JavaPropertyDescriptor) == false) goto L43;
        SourceElement r11 = ((JavaPropertyDescriptor) r1).getSource();
        if ((r11 instanceof JavaSourceElement) == false) goto L13;
        JavaSourceElement r12 = (JavaSourceElement) r11;
    L14:
        if (r12 == null) goto L16;
        JavaElement r13 = r12.getJavaElement();
    L18:
        if ((r13 instanceof ReflectJavaField) == false) goto L21;
        return new JvmPropertySignature.JavaField(((ReflectJavaField) r13).getMember());
    L21:
        if ((r13 instanceof ReflectJavaMethod) == false) goto L42;
        Method r14 = ((ReflectJavaMethod) r13).getMember();
        PropertySetterDescriptor r15 = r1.getSetter();
        if (r15 == null) goto L25;
        SourceElement r16 = r15.getSource();
    L27:
        if ((r16 instanceof JavaSourceElement) == false) goto L29;
        JavaSourceElement r17 = (JavaSourceElement) r16;
    L30:
        if (r17 == null) goto L32;
        JavaElement r18 = r17.getJavaElement();
    L34:
        if ((r18 instanceof ReflectJavaMethod) == false) goto L36;
        ReflectJavaMethod r19 = (ReflectJavaMethod) r18;
    L37:
        if (r19 == null) goto L40;
        r0 = r19.getMember();
    L40:
        return new JvmPropertySignature.JavaMethodProperty(r14, r0);
    L36:
        r19 = null;
        goto L37
    L32:
        r18 = null;
        goto L34
    L29:
        r17 = null;
        goto L30
    L25:
        r16 = null;
        goto L27
    L42:
        throw new KotlinReflectionInternalError("Incorrect resolution sequence for Java field " + r1 + " (source = " + r13 + ')');
    L16:
        r13 = null;
        goto L18
    L13:
        r12 = null;
        goto L14
    }

    private final boolean isKnownBuiltInFunction(FunctionDescriptor r3) {
        if (DescriptorFactory.isEnumValueOfMethod(r3) == false) goto L5;
    L14:
        return true;
    L5:
        if (DescriptorFactory.isEnumValuesMethod(r3) == true) goto L14;
        if (Intrinsics.areEqual(r3.getName(), CloneableClassScope.Companion.getCLONE_NAME()) == true) goto L10;
        return false;
    L10:
        if (r3.getValueParameters().isEmpty() == false) goto L15;
        return true;
    L15:
        return false;
    }

    private final JvmFunctionSignature.KotlinFunction mapJvmFunctionSignature(FunctionDescriptor r6) {
        return new JvmFunctionSignature.KotlinFunction(new JvmMemberSignature.Method(mapName(r6), MethodSignatureMappingKt.computeJvmDescriptor$default(r6, false, false, 1, null)));
    }

    private final String mapName(CallableMemberDescriptor r2) {
        String r1 = SpecialBuiltinMembers.getJvmMethodNameIfSpecial(r2);
        if (r1 == null) goto L5;
        return r1;
    L5:
        if ((r2 instanceof PropertyGetterDescriptor) == false) goto L8;
        String r3 = DescriptorUtilsKt.getPropertyIfAccessor(r2).getName().asString();
        Intrinsics.checkNotNullExpressionValue(r3, "descriptor.propertyIfAccessor.name.asString()");
        return JvmAbi.getterName(r3);
    L8:
        if ((r2 instanceof PropertySetterDescriptor) == false) goto L10;
        String r4 = DescriptorUtilsKt.getPropertyIfAccessor(r2).getName().asString();
        Intrinsics.checkNotNullExpressionValue(r4, "descriptor.propertyIfAccessor.name.asString()");
        return JvmAbi.setterName(r4);
    L10:
        String r5 = r2.getName().asString();
        Intrinsics.checkNotNullExpressionValue(r5, "descriptor.name.asString()");
        return r5;
    }

    public final ClassId mapJvmClassToKotlinClassId(Class<?> r3) {
        Intrinsics.checkNotNullParameter(r3, "klass");
        if (r3.isArray() == false) goto L11;
        Class<?> r4 = r3.getComponentType();
        Intrinsics.checkNotNullExpressionValue(r4, "klass.componentType");
        PrimitiveType r2 = getPrimitiveType(r4);
        if (r2 != null) goto L7;
        ClassId r5 = ClassId.topLevel(StandardNames.FqNames.array.toSafe());
        Intrinsics.checkNotNullExpressionValue(r5, "topLevel(StandardNames.FqNames.array.toSafe())");
        return r5;
    L7:
        return new ClassId(StandardNames.BUILT_INS_PACKAGE_FQ_NAME, r2.getArrayTypeName());
    L11:
        if (Intrinsics.areEqual(r3, Void.TYPE) == true) goto L13;
        PrimitiveType r6 = getPrimitiveType(r3);
        if (r6 != null) goto L17;
        ClassId r7 = ReflectClassUtilKt.getClassId(r3);
        if (r7.isLocal() == true) goto L23;
        JavaToKotlinClassMap r8 = JavaToKotlinClassMap.INSTANCE;
        FqName r0 = r7.asSingleFqName();
        Intrinsics.checkNotNullExpressionValue(r0, "classId.asSingleFqName()");
        ClassId r9 = r8.mapJavaToKotlin(r0);
        if (r9 == null) goto L23;
        return r9;
    L23:
        return r7;
    L17:
        return new ClassId(StandardNames.BUILT_INS_PACKAGE_FQ_NAME, r6.getTypeName());
    L13:
        return JAVA_LANG_VOID;
    }

    private final PrimitiveType getPrimitiveType(Class<?> r1) {
        if (r1.isPrimitive() == true) goto L7;
        return null;
    L7:
        return JvmPrimitiveType.get(r1.getSimpleName()).getPrimitiveType();
    }
}
