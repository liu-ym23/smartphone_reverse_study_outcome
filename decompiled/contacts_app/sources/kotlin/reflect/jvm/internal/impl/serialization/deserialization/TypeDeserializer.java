package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.FunctionTypesKt;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FindClassInModuleKt;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoTypeTableUtilKt;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedAnnotations;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedTypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.types.DefinitelyNotNullType;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeKt;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.SpecialTypesKt;
import kotlin.reflect.jvm.internal.impl.types.StarProjectionForAbsentTypeParameter;
import kotlin.reflect.jvm.internal.impl.types.StarProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.TypeAttribute;
import kotlin.reflect.jvm.internal.impl.types.TypeAttributeTranslator;
import kotlin.reflect.jvm.internal.impl.types.TypeAttributes;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import kotlin.sequences.SequencesKt;

/* JADX INFO: compiled from: TypeDeserializer.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class TypeDeserializer {
    private final DeserializationContext c;
    private final Function1<Integer, ClassifierDescriptor> classifierDescriptors;
    private final String containerPresentableName;
    private final String debugName;
    private final TypeDeserializer parent;
    private final Function1<Integer, ClassifierDescriptor> typeAliasDescriptors;
    private final Map<Integer, TypeParameterDescriptor> typeParameterDescriptors;

    public TypeDeserializer(DeserializationContext r5, TypeDeserializer r6, List<ProtoBuf.TypeParameter> r7, String r8, String r9) {
        Intrinsics.checkNotNullParameter(r5, "c");
        Intrinsics.checkNotNullParameter(r7, "typeParameterProtos");
        Intrinsics.checkNotNullParameter(r8, "debugName");
        Intrinsics.checkNotNullParameter(r9, "containerPresentableName");
        this.c = r5;
        this.parent = r6;
        this.debugName = r8;
        this.containerPresentableName = r9;
        this.classifierDescriptors = r5.getStorageManager().createMemoizedFunctionWithNullableValues(new TypeDeserializer$classifierDescriptors$1(this));
        this.typeAliasDescriptors = r5.getStorageManager().createMemoizedFunctionWithNullableValues(new TypeDeserializer$typeAliasDescriptors$1(this));
        if (r7.isEmpty() == false) goto L5;
        LinkedHashMap r10 = MapsKt.emptyMap();
    L10:
        this.typeParameterDescriptors = r10;
        return;
    L5:
        LinkedHashMap r11 = new LinkedHashMap();
        Iterator<ProtoBuf.TypeParameter> r12 = r7.iterator();
        int r13 = 0;
    L7:
        if (r12.hasNext() == false) goto L9;
        ProtoBuf.TypeParameter r14 = r12.next();
        r11.put(Integer.valueOf(r14.getId()), new DeserializedTypeParameterDescriptor(this.c, r14, r13));
        r13 = r13 + 1;
        goto L7
    L9:
        r10 = r11;
        goto L10
    }

    public static final /* synthetic */ ClassifierDescriptor access$computeClassifierDescriptor(TypeDeserializer r0, int r1) {
        return r0.computeClassifierDescriptor(r1);
    }

    public static final /* synthetic */ ClassifierDescriptor access$computeTypeAliasDescriptor(TypeDeserializer r0, int r1) {
        return r0.computeTypeAliasDescriptor(r1);
    }

    public static final /* synthetic */ DeserializationContext access$getC$p(TypeDeserializer r0) {
        return r0.c;
    }

    public final List<TypeParameterDescriptor> getOwnTypeParameters() {
        return CollectionsKt.toList(this.typeParameterDescriptors.values());
    }

    public final KotlinType type(ProtoBuf.Type r7) {
        Intrinsics.checkNotNullParameter(r7, "proto");
        if (r7.hasFlexibleTypeCapabilitiesId() == false) goto L7;
        String r0 = this.c.getNameResolver().getString(r7.getFlexibleTypeCapabilitiesId());
        SimpleType r4 = simpleType$default(this, r7, false, 2, null);
        ProtoBuf.Type r5 = ProtoTypeTableUtilKt.flexibleUpperBound(r7, this.c.getTypeTable());
        Intrinsics.checkNotNull(r5);
        SimpleType r1 = simpleType$default(this, r5, false, 2, null);
        return this.c.getComponents().getFlexibleTypeDeserializer().create(r7, r0, r4, r1);
    L7:
        return simpleType(r7, true);
    }

    private final TypeAttributes toAttributes(List<? extends TypeAttributeTranslator> r2, Annotations r3, TypeConstructor r4, DeclarationDescriptor r5) {
        List<? extends TypeAttributeTranslator> r6 = r2;
        ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r6, 10));
        Iterator<T> r7 = r6.iterator();
    L4:
        if (r7.hasNext() == false) goto L6;
        r1.add(((TypeAttributeTranslator) r7.next()).toAttributes(r3, r4, r5));
        goto L4
    L6:
        List<? extends TypeAttribute<?>> r8 = CollectionsKt.flatten(r1);
        return TypeAttributes.Companion.create(r8);
    }

    public static /* synthetic */ SimpleType simpleType$default(TypeDeserializer r0, ProtoBuf.Type r1, boolean r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = true;
    L6:
        return r0.simpleType(r1, r2);
    }

    public final SimpleType simpleType(final ProtoBuf.Type r14, boolean r15) {
        Intrinsics.checkNotNullParameter(r14, "proto");
        if (r14.hasClassName() == false) goto L6;
        SimpleType r0 = computeLocalClassifierReplacementType(r14.getClassName());
    L9:
        if (r0 == null) goto L11;
        return r0;
    L11:
        TypeConstructor r3 = typeConstructor(r14);
        boolean r2 = true;
        if (ErrorUtils.isError(r3.mo2083getDeclarationDescriptor()) == true) goto L14;
        DeserializedAnnotations r1 = new DeserializedAnnotations(this.c.getStorageManager(), new TypeDeserializer$simpleType$annotations$1(this, r14));
        TypeAttributes r4 = toAttributes(this.c.getComponents().getTypeAttributeTranslators(), r1, r3, this.c.getContainingDeclaration());
        List<ProtoBuf.Type.Argument> r5 = simpleType$collectAllArguments(r14, this);
        ArrayList r6 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r5, 10));
        Iterator<T> r7 = r5.iterator();
        int r8 = 0;
    L17:
        if (r7.hasNext() == false) goto L22;
        Object r9 = r7.next();
        int r10 = r8 + 1;
        if (r8 >= 0) goto L21;
        CollectionsKt.throwIndexOverflow();
    L21:
        List<TypeParameterDescriptor> r11 = r3.getParameters();
        Intrinsics.checkNotNullExpressionValue(r11, "constructor.parameters");
        r6.add(typeArgument((TypeParameterDescriptor) CollectionsKt.getOrNull(r11, r8), (ProtoBuf.Type.Argument) r9));
        r8 = r10;
        goto L17
    L22:
        List<? extends TypeProjection> r12 = CollectionsKt.toList(r6);
        ClassifierDescriptor r13 = r3.mo2083getDeclarationDescriptor();
        if (r15 == true) goto L25;
    L33:
        Boolean r16 = Flags.SUSPEND_TYPE.get(r14.getFlags());
        Intrinsics.checkNotNullExpressionValue(r16, "SUSPEND_TYPE.get(proto.flags)");
        if (r16.booleanValue() == false) goto L36;
        SimpleType r17 = createSuspendFunctionType(r4, r3, r12, r14.getNullable());
    L43:
        ProtoBuf.Type r18 = ProtoTypeTableUtilKt.abbreviatedType(r14, this.c.getTypeTable());
        if (r18 == null) goto L50;
        SimpleType r19 = SpecialTypesKt.withAbbreviation(r17, simpleType(r18, false));
        if (r19 == null) goto L50;
        r17 = r19;
    L50:
        if (r14.hasClassName() == true) goto L52;
        return r17;
    L52:
        return this.c.getComponents().getPlatformDependentTypeTransformer().transformPlatformType(NameResolverUtilKt.getClassId(this.c.getNameResolver(), r14.getClassName()), r17);
    L36:
        r17 = KotlinTypeFactory.simpleType$default(r4, r3, r12, r14.getNullable(), null, 16, null);
        Boolean r20 = Flags.DEFINITELY_NOT_NULL_TYPE.get(r14.getFlags());
        Intrinsics.checkNotNullExpressionValue(r20, "DEFINITELY_NOT_NULL_TYPE.get(proto.flags)");
        if (r20.booleanValue() == false) goto L43;
        DefinitelyNotNullType r21 = DefinitelyNotNullType.Companion.makeDefinitelyNotNull$default(DefinitelyNotNullType.Companion, r17, false, 2, null);
        if (r21 == null) goto L42;
        r17 = r21;
        goto L43
    L42:
        throw new IllegalStateException(("null DefinitelyNotNullType for '" + r17 + '\'').toString());
    L25:
        if ((r13 instanceof TypeAliasDescriptor) == false) goto L33;
        KotlinTypeFactory r110 = KotlinTypeFactory.INSTANCE;
        SimpleType r111 = KotlinTypeFactory.computeExpandedType((TypeAliasDescriptor) r13, r12);
        TypeAttributes r22 = toAttributes(this.c.getComponents().getTypeAttributeTranslators(), Annotations.Companion.create(CollectionsKt.plus(r1, r111.getAnnotations())), r3, this.c.getContainingDeclaration());
        if (KotlinTypeKt.isNullable(r111) == false) goto L29;
    L32:
        r17 = r111.makeNullableAsSpecified(r2).replaceAttributes(r22);
        goto L43
    L29:
        if (r14.getNullable() == true) goto L32;
        r2 = false;
        goto L32
    L14:
        return ErrorUtils.INSTANCE.createErrorType(ErrorTypeKind.TYPE_FOR_ERROR_TYPE_CONSTRUCTOR, r3, new String[]{r3.toString()});
    L6:
        if (r14.hasTypeAliasName() == false) goto L8;
        r0 = computeLocalClassifierReplacementType(r14.getTypeAliasName());
        goto L9
    L8:
        r0 = null;
        goto L9
    }

    private static final List<ProtoBuf.Type.Argument> simpleType$collectAllArguments(ProtoBuf.Type r2, TypeDeserializer r3) {
        List<ProtoBuf.Type.Argument> r0 = r2.getArgumentList();
        Intrinsics.checkNotNullExpressionValue(r0, "argumentList");
        List<ProtoBuf.Type.Argument> r1 = r0;
        ProtoBuf.Type r4 = ProtoTypeTableUtilKt.outerType(r2, r3.c.getTypeTable());
        if (r4 == null) goto L5;
        List<ProtoBuf.Type.Argument> r5 = simpleType$collectAllArguments(r4, r3);
    L6:
        if (r5 != null) goto L9;
        r5 = CollectionsKt.emptyList();
    L9:
        return CollectionsKt.plus(r1, r5);
    L5:
        r5 = null;
        goto L6
    }

    private static final ClassDescriptor typeConstructor$notFoundClass(final TypeDeserializer r2, ProtoBuf.Type r3, int r4) {
        ClassId r5 = NameResolverUtilKt.getClassId(r2.c.getNameResolver(), r4);
        List<Integer> r6 = SequencesKt.toMutableList(SequencesKt.map(SequencesKt.generateSequence(r3, new TypeDeserializer$typeConstructor$notFoundClass$typeParametersCount$1(r2)), TypeDeserializer$typeConstructor$notFoundClass$typeParametersCount$2.INSTANCE));
        int r0 = SequencesKt.count(SequencesKt.generateSequence(r5, TypeDeserializer$typeConstructor$notFoundClass$classNestingLevel$1.INSTANCE));
    L4:
        if (r6.size() >= r0) goto L7;
        r6.add(0);
        goto L4
    L7:
        return r2.c.getComponents().getNotFoundClasses().getClass(r5, r6);
    }

    private final TypeConstructor typeConstructor(ProtoBuf.Type r7) {
        if (r7.hasClassName() == false) goto L8;
        ClassDescriptor r0 = this.classifierDescriptors.invoke(Integer.valueOf(r7.getClassName()));
        if (r0 != null) goto L33;
        r0 = typeConstructor$notFoundClass(this, r7, r7.getClassName());
    L33:
        TypeConstructor r6 = r0.getTypeConstructor();
        Intrinsics.checkNotNullExpressionValue(r6, "classifier.typeConstructor");
        return r6;
    L8:
        if (r7.hasTypeParameter() == false) goto L15;
        TypeParameterDescriptor r1 = loadTypeParameter(r7.getTypeParameter());
        if (r1 == null) goto L12;
        r0 = r1;
        goto L33
    L12:
        return ErrorUtils.INSTANCE.createErrorTypeConstructor(ErrorTypeKind.CANNOT_LOAD_DESERIALIZE_TYPE_PARAMETER, new String[]{String.valueOf(r7.getTypeParameter()), this.containerPresentableName});
    L15:
        if (r7.hasTypeParameterName() == false) goto L29;
        String r8 = this.c.getNameResolver().getString(r7.getTypeParameterName());
        Iterator<T> r2 = getOwnTypeParameters().iterator();
    L18:
        if (r2.hasNext() == false) goto L22;
        Object r4 = r2.next();
        if (Intrinsics.areEqual(((TypeParameterDescriptor) r4).getName().asString(), r8) == false) goto L18;
    L23:
        TypeParameterDescriptor r5 = (TypeParameterDescriptor) r4;
        if (r5 == null) goto L26;
        r0 = r5;
        goto L33
    L26:
        return ErrorUtils.INSTANCE.createErrorTypeConstructor(ErrorTypeKind.CANNOT_LOAD_DESERIALIZE_TYPE_PARAMETER_BY_NAME, new String[]{r8, this.c.getContainingDeclaration().toString()});
    L22:
        r4 = null;
        goto L23
    L29:
        if (r7.hasTypeAliasName() == false) goto L36;
        r0 = this.typeAliasDescriptors.invoke(Integer.valueOf(r7.getTypeAliasName()));
        if (r0 != null) goto L33;
        r0 = typeConstructor$notFoundClass(this, r7, r7.getTypeAliasName());
        goto L33
    L36:
        return ErrorUtils.INSTANCE.createErrorTypeConstructor(ErrorTypeKind.UNKNOWN_TYPE, new String[0]);
    }

    private final SimpleType createSuspendFunctionType(TypeAttributes r8, TypeConstructor r9, List<? extends TypeProjection> r10, boolean r11) {
        int r0 = r9.getParameters().size() - r10.size();
        if (r0 == 0) goto L11;
        SimpleType r7 = null;
        if (r0 != 1) goto L12;
        int r1 = r10.size() - 1;
        if (r1 < 0) goto L10;
        TypeConstructor r2 = r9.getBuiltIns().getSuspendFunction(r1).getTypeConstructor();
        Intrinsics.checkNotNullExpressionValue(r2, "functionTypeConstructor.…on(arity).typeConstructor");
        r7 = KotlinTypeFactory.simpleType$default(r8, r2, r10, r11, null, 16, null);
        goto L12
    L10:
        SimpleType r12 = (SimpleType) null;
    L12:
        if (r7 == null) goto L14;
        return r7;
    L14:
        return ErrorUtils.INSTANCE.createErrorTypeWithArguments(ErrorTypeKind.INCONSISTENT_SUSPEND_FUNCTION, r10, r9, new String[0]);
    L11:
        r7 = createSuspendFunctionTypeForBasicCase(r8, r9, r10, r11);
        goto L12
    }

    private final SimpleType createSuspendFunctionTypeForBasicCase(TypeAttributes r8, TypeConstructor r9, List<? extends TypeProjection> r10, boolean r11) {
        SimpleType r12 = KotlinTypeFactory.simpleType$default(r8, r9, r10, r11, null, 16, null);
        if (FunctionTypesKt.isFunctionType(r12) == true) goto L6;
        return null;
    L6:
        return transformRuntimeFunctionTypeToSuspendFunction(r12);
    }

    private final SimpleType transformRuntimeFunctionTypeToSuspendFunction(KotlinType r6) {
        TypeProjection r0 = (TypeProjection) CollectionsKt.lastOrNull(FunctionTypesKt.getValueParameterTypesFromFunctionType(r6));
        FqName r1 = null;
        if (r0 == null) goto L32;
        KotlinType r2 = r0.getType();
        if (r2 == null) goto L32;
        ClassifierDescriptor r3 = r2.getConstructor().mo2083getDeclarationDescriptor();
        if (r3 == null) goto L10;
        FqName r4 = DescriptorUtilsKt.getFqNameSafe(r3);
    L12:
        if (r2.getArguments().size() != 1) goto L31;
        if (Intrinsics.areEqual(r4, StandardNames.CONTINUATION_INTERFACE_FQ_NAME) == false) goto L16;
    L18:
        KotlinType r5 = ((TypeProjection) CollectionsKt.single(r2.getArguments())).getType();
        Intrinsics.checkNotNullExpressionValue(r5, "continuationArgumentType.arguments.single().type");
        DeclarationDescriptor r7 = this.c.getContainingDeclaration();
        if ((r7 instanceof CallableDescriptor) == true) goto L21;
        r7 = null;
    L21:
        CallableDescriptor r8 = (CallableDescriptor) r7;
        if (r8 == null) goto L25;
        r1 = DescriptorUtilsKt.fqNameOrNull(r8);
    L25:
        if (Intrinsics.areEqual(r1, SuspendFunctionTypeUtilKt.KOTLIN_SUSPEND_BUILT_IN_FUNCTION_FQ_NAME) == false) goto L29;
        return createSimpleSuspendFunctionType(r6, r5);
    L29:
        return createSimpleSuspendFunctionType(r6, r5);
    L16:
        if (Intrinsics.areEqual(r4, TypeDeserializerKt.access$getEXPERIMENTAL_CONTINUATION_FQ_NAME$p()) == true) goto L18;
    L31:
        return (SimpleType) r6;
    L10:
        r4 = null;
    L32:
        return null;
    }

    private final SimpleType createSimpleSuspendFunctionType(KotlinType r9, KotlinType r10) {
        KotlinBuiltIns r0 = TypeUtilsKt.getBuiltIns(r9);
        Annotations r1 = r9.getAnnotations();
        KotlinType r2 = FunctionTypesKt.getReceiverTypeFromFunctionType(r9);
        List<KotlinType> r3 = FunctionTypesKt.getContextReceiverTypesFromFunctionType(r9);
        List r8 = CollectionsKt.dropLast(FunctionTypesKt.getValueParameterTypesFromFunctionType(r9), 1);
        ArrayList r4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r8, 10));
        Iterator r11 = r8.iterator();
    L4:
        if (r11.hasNext() == false) goto L7;
        r4.add(((TypeProjection) r11.next()).getType());
        goto L4
    L7:
        return FunctionTypesKt.createFunctionType(r0, r1, r2, r3, r4, null, r10, true).makeNullableAsSpecified(r9.isMarkedNullable());
    }

    private final TypeParameterDescriptor loadTypeParameter(int r3) {
        TypeParameterDescriptor r0 = this.typeParameterDescriptors.get(Integer.valueOf(r3));
        if (r0 != null) goto L9;
        TypeDeserializer r2 = this.parent;
        if (r2 != null) goto L10;
        return null;
    L10:
        return r2.loadTypeParameter(r3);
    L9:
        return r0;
    }

    private final ClassifierDescriptor computeClassifierDescriptor(int r2) {
        ClassId r3 = NameResolverUtilKt.getClassId(this.c.getNameResolver(), r2);
        if (r3.isLocal() == false) goto L7;
        return this.c.getComponents().deserializeClass(r3);
    L7:
        return FindClassInModuleKt.findClassifierAcrossModuleDependencies(this.c.getComponents().getModuleDescriptor(), r3);
    }

    private final SimpleType computeLocalClassifierReplacementType(int r2) {
        if (NameResolverUtilKt.getClassId(this.c.getNameResolver(), r2).isLocal() == true) goto L5;
        return null;
    L5:
        return this.c.getComponents().getLocalClassifierTypeSettings().getReplacementTypeForLocalClassifiers();
    }

    private final ClassifierDescriptor computeTypeAliasDescriptor(int r2) {
        ClassId r3 = NameResolverUtilKt.getClassId(this.c.getNameResolver(), r2);
        if (r3.isLocal() == false) goto L7;
        return null;
    L7:
        return FindClassInModuleKt.findTypeAliasAcrossModuleDependencies(this.c.getComponents().getModuleDescriptor(), r3);
    }

    private final TypeProjection typeArgument(TypeParameterDescriptor r3, ProtoBuf.Type.Argument r4) {
        if (r4.getProjection() != ProtoBuf.Type.Argument.Projection.STAR) goto L8;
        if (r3 != null) goto L7;
        return new StarProjectionForAbsentTypeParameter(this.c.getComponents().getModuleDescriptor().getBuiltIns());
    L7:
        return new StarProjectionImpl(r3);
    L8:
        ProtoEnumFlags r5 = ProtoEnumFlags.INSTANCE;
        ProtoBuf.Type.Argument.Projection r0 = r4.getProjection();
        Intrinsics.checkNotNullExpressionValue(r0, "typeArgumentProto.projection");
        Variance r6 = r5.variance(r0);
        ProtoBuf.Type r1 = ProtoTypeTableUtilKt.type(r4, this.c.getTypeTable());
        if (r1 != null) goto L13;
        return new TypeProjectionImpl(ErrorUtils.createErrorType(ErrorTypeKind.NO_RECORDED_TYPE, new String[]{r4.toString()}));
    L13:
        return new TypeProjectionImpl(r6, type(r1));
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder().append(this.debugName);
        if (this.parent != null) goto L5;
        String r3 = "";
    L7:
        return r0.append(r3).toString();
    L5:
        r3 = ". Child of " + this.parent.debugName;
        goto L7
    }
}
