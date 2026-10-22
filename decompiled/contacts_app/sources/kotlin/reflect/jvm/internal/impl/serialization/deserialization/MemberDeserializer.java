package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ValueParameterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoTypeTableUtilKt;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionRequirementTable;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorFactory;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedAnnotations;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedSimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedTypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.NonEmptyDeserializedAnnotations;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* JADX INFO: compiled from: MemberDeserializer.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class MemberDeserializer {
    private final AnnotationDeserializer annotationDeserializer;
    private final DeserializationContext c;

    private final int loadOldFlags(int r1) {
        return (r1 & 63) + ((r1 >> 8) << 6);
    }

    public MemberDeserializer(DeserializationContext r3) {
        Intrinsics.checkNotNullParameter(r3, "c");
        this.c = r3;
        this.annotationDeserializer = new AnnotationDeserializer(r3.getComponents().getModuleDescriptor(), r3.getComponents().getNotFoundClasses());
    }

    public static final /* synthetic */ ProtoContainer access$asProtoContainer(MemberDeserializer r0, DeclarationDescriptor r1) {
        return r0.asProtoContainer(r1);
    }

    public static final /* synthetic */ DeserializationContext access$getC$p(MemberDeserializer r0) {
        return r0.c;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r13v3 kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property
        	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:236)
        	at jadx.core.dex.visitors.ModVisitor.anonymousCallArgMod(ModVisitor.java:535)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
        	at jadx.core.dex.visitors.ModVisitor.processAnonymousConstructor(ModVisitor.java:528)
        	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:111)
        	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:96)
        */
    public final kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor loadProperty(final kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Property r37) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r37, "proto");
        boolean r1 = r37.hasFlags();
        if (r1 == false) goto L5;
        int r1 = r37.getFlags();
    L6:
        int r14 = r1;
        kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext r2 = r36.c;
        kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor r2 = r2.getContainingDeclaration();
        kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Property r12 = r37;
        kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotatedCallableKind r4 = kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotatedCallableKind.PROPERTY;
        kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations r4 = getAnnotations(r12, r14, r4);
        kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoEnumFlags r5 = kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoEnumFlags.INSTANCE;
        kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.FlagField<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Modality> r6 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.MODALITY;
        kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Modality r6 = r6.get(r14);
        kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Modality r6 = r6;
        kotlin.reflect.jvm.internal.impl.descriptors.Modality r5 = r5.modality(r6);
        kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoEnumFlags r6 = kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoEnumFlags.INSTANCE;
        kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.FlagField<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Visibility> r7 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.VISIBILITY;
        kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Visibility r7 = r7.get(r14);
        kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Visibility r7 = r7;
        kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility r6 = kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoEnumFlagsUtilsKt.descriptorVisibility(r6, r7);
        kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.BooleanFlagField r7 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.IS_VAR;
        java.lang.Boolean r7 = r7.get(r14);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, "IS_VAR.get(flags)");
        boolean r7 = r7.booleanValue();
        kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext r8 = r36.c;
        kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver r8 = r8.getNameResolver();
        int r9 = r37.getName();
        kotlin.reflect.jvm.internal.impl.name.Name r8 = kotlin.reflect.jvm.internal.impl.serialization.deserialization.NameResolverUtilKt.getName(r8, r9);
        kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoEnumFlags r9 = kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoEnumFlags.INSTANCE;
        kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.FlagField<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.MemberKind> r10 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.MEMBER_KIND;
        kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.MemberKind r10 = r10.get(r14);
        kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.MemberKind r10 = r10;
        kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind r9 = kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoEnumFlagsUtilsKt.memberKind(r9, r10);
        kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.BooleanFlagField r10 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.IS_LATEINIT;
        java.lang.Boolean r10 = r10.get(r14);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r10, "IS_LATEINIT.get(flags)");
        boolean r10 = r10.booleanValue();
        kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.BooleanFlagField r11 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.IS_CONST;
        java.lang.Boolean r11 = r11.get(r14);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r11, "IS_CONST.get(flags)");
        boolean r11 = r11.booleanValue();
        kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.BooleanFlagField r3 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.IS_EXTERNAL_PROPERTY;
        java.lang.Boolean r3 = r3.get(r14);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, "IS_EXTERNAL_PROPERTY.get(flags)");
        boolean r12 = r3.booleanValue();
        kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.BooleanFlagField r3 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.IS_DELEGATED;
        java.lang.Boolean r3 = r3.get(r14);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, "IS_DELEGATED.get(flags)");
        boolean r13 = r3.booleanValue();
        kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.BooleanFlagField r3 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.IS_EXPECT_PROPERTY;
        java.lang.Boolean r3 = r3.get(r14);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, "IS_EXPECT_PROPERTY.get(flags)");
        boolean r14 = r3.booleanValue();
        kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext r3 = r36.c;
        kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver r16 = r3.getNameResolver();
        kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext r3 = r36.c;
        kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable r17 = r3.getTypeTable();
        kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext r3 = r36.c;
        kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionRequirementTable r18 = r3.getVersionRequirementTable();
        kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext r3 = r36.c;
        kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerSource r19 = r3.getContainerSource();
        final kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedPropertyDescriptor r13 = new kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedPropertyDescriptor(r2, null, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r37, r16, r17, r18, r19);
        kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext r1 = r36.c;
        kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedPropertyDescriptor r28 = r13;
        java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.TypeParameter> r2 = r37.getTypeParameterList();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, "proto.typeParameterList");
        kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext r8 = kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext.childContext$default(r1, r28, r2, null, null, null, null, 60, null);
        kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.BooleanFlagField r1 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.HAS_GETTER;
        java.lang.Boolean r1 = r1.get(r14);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, "HAS_GETTER.get(flags)");
        boolean r9 = r1.booleanValue();
        if (r9 == false) goto L11;
        boolean r1 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoTypeTableUtilKt.hasReceiver(r37);
        if (r1 == false) goto L11;
        kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotatedCallableKind r1 = kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotatedCallableKind.PROPERTY_GETTER;
        kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Property r14 = r12;
        kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations r1 = getReceiverParameterAnnotations(r14, r1);
    L12:
        kotlin.reflect.jvm.internal.impl.serialization.deserialization.TypeDeserializer r2 = r8.getTypeDeserializer();
        kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext r3 = r36.c;
        kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable r3 = r3.getTypeTable();
        kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type r3 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoTypeTableUtilKt.returnType(r37, r3);
        kotlin.reflect.jvm.internal.impl.types.KotlinType r2 = r2.type(r3);
        kotlin.reflect.jvm.internal.impl.serialization.deserialization.TypeDeserializer r3 = r8.getTypeDeserializer();
        java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor> r3 = r3.getOwnTypeParameters();
        kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor r4 = getDispatchReceiverParameter();
        kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext r5 = r36.c;
        kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable r5 = r5.getTypeTable();
        kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type r5 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoTypeTableUtilKt.receiverType(r37, r5);
        kotlin.reflect.jvm.internal.impl.descriptors.ClassKind r17 = null;
        if (r5 == null) goto L17;
        kotlin.reflect.jvm.internal.impl.serialization.deserialization.TypeDeserializer r6 = r8.getTypeDeserializer();
        kotlin.reflect.jvm.internal.impl.types.KotlinType r5 = r6.type(r5);
        if (r5 == null) goto L17;
        kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedPropertyDescriptor r6 = r13;
        kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor r1 = kotlin.reflect.jvm.internal.impl.resolve.DescriptorFactory.createExtensionReceiverParameterForCallable(r6, r5, r1);
        kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor r5 = r1;
    L18:
        kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext r1 = r36.c;
        kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable r1 = r1.getTypeTable();
        java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type> r1 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoTypeTableUtilKt.contextReceiverTypes(r37, r1);
        java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type> r1 = r1;
        int r10 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r1, 10);
        java.util.ArrayList r6 = new java.util.ArrayList(r10);
        java.util.ArrayList r6 = r6;
        java.util.Iterator<T> r1 = r1.iterator();
    L19:
        boolean r10 = r1.hasNext();
        if (r10 == false) goto L22;
        java.lang.Object r10 = r1.next();
        kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type r10 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type) r10;
        kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedPropertyDescriptor r11 = r13;
        kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor r10 = toContextReceiver(r10, r8, r11);
        r6.add(r10);
        goto L19
    L22:
        java.util.ArrayList r6 = r6;
        r13.setType(r2, r3, r4, r5, r6);
        kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.BooleanFlagField r1 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.HAS_ANNOTATIONS;
        java.lang.Boolean r1 = r1.get(r14);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, "HAS_ANNOTATIONS.get(flags)");
        boolean r18 = r1.booleanValue();
        kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.FlagField<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Visibility> r1 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.VISIBILITY;
        kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Visibility r1 = r1.get(r14);
        kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Visibility r19 = r1;
        kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.FlagField<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Modality> r1 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.MODALITY;
        kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Modality r1 = r1.get(r14);
        kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Modality r20 = r1;
        int r1 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.getAccessorFlags(r18, r19, r20, false, false, false);
        if (r9 == false) goto L33;
        boolean r3 = r37.hasGetterFlags();
        if (r3 == false) goto L27;
        int r3 = r37.getGetterFlags();
    L28:
        kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.BooleanFlagField r4 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.IS_NOT_DEFAULT;
        java.lang.Boolean r4 = r4.get(r3);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, "IS_NOT_DEFAULT.get(getterFlags)");
        boolean r4 = r4.booleanValue();
        kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.BooleanFlagField r5 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.IS_EXTERNAL_ACCESSOR;
        java.lang.Boolean r5 = r5.get(r3);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, "IS_EXTERNAL_ACCESSOR.get(getterFlags)");
        boolean r24 = r5.booleanValue();
        kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.BooleanFlagField r5 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.IS_INLINE_ACCESSOR;
        java.lang.Boolean r5 = r5.get(r3);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, "IS_INLINE_ACCESSOR.get(getterFlags)");
        boolean r25 = r5.booleanValue();
        kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotatedCallableKind r5 = kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotatedCallableKind.PROPERTY_GETTER;
        kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations r5 = getAnnotations(r14, r3, r5);
        if (r4 == false) goto L31;
        kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedPropertyDescriptor r19 = r13;
        kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoEnumFlags r9 = kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoEnumFlags.INSTANCE;
        kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.FlagField<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Modality> r10 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.MODALITY;
        kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Modality r10 = r10.get(r3);
        kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Modality r10 = r10;
        kotlin.reflect.jvm.internal.impl.descriptors.Modality r21 = r9.modality(r10);
        kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoEnumFlags r9 = kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoEnumFlags.INSTANCE;
        kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.FlagField<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Visibility> r10 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.VISIBILITY;
        kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Visibility r3 = r10.get(r3);
        kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Visibility r3 = r3;
        kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility r22 = kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoEnumFlagsUtilsKt.descriptorVisibility(r9, r3);
        boolean r23 = r4 ^ true;
        kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind r26 = r13.getKind();
        kotlin.reflect.jvm.internal.impl.descriptors.SourceElement r28 = kotlin.reflect.jvm.internal.impl.descriptors.SourceElement.NO_SOURCE;
        kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyGetterDescriptorImpl r6 = new kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyGetterDescriptorImpl(r19, r5, r21, r22, r23, r24, r25, r26, null, r28);
    L32:
        kotlin.reflect.jvm.internal.impl.types.KotlinType r3 = r13.getReturnType();
        r6.initialize(r3);
    L34:
        kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.BooleanFlagField r3 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.HAS_SETTER;
        java.lang.Boolean r3 = r3.get(r14);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, "HAS_SETTER.get(flags)");
        boolean r3 = r3.booleanValue();
        if (r3 == false) goto L43;
        boolean r3 = r37.hasSetterFlags();
        if (r3 == false) goto L39;
        r1 = r37.getSetterFlags();
    L39:
        kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.BooleanFlagField r3 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.IS_NOT_DEFAULT;
        java.lang.Boolean r3 = r3.get(r1);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, "IS_NOT_DEFAULT.get(setterFlags)");
        boolean r3 = r3.booleanValue();
        kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.BooleanFlagField r4 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.IS_EXTERNAL_ACCESSOR;
        java.lang.Boolean r4 = r4.get(r1);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, "IS_EXTERNAL_ACCESSOR.get(setterFlags)");
        boolean r24 = r4.booleanValue();
        kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.BooleanFlagField r4 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.IS_INLINE_ACCESSOR;
        java.lang.Boolean r4 = r4.get(r1);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, "IS_INLINE_ACCESSOR.get(setterFlags)");
        boolean r25 = r4.booleanValue();
        kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotatedCallableKind r4 = kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotatedCallableKind.PROPERTY_SETTER;
        kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations r4 = getAnnotations(r14, r1, r4);
        if (r3 == false) goto L42;
        kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedPropertyDescriptor r19 = r13;
        kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoEnumFlags r9 = kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoEnumFlags.INSTANCE;
        kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.FlagField<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Modality> r10 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.MODALITY;
        kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Modality r10 = r10.get(r1);
        kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Modality r10 = r10;
        kotlin.reflect.jvm.internal.impl.descriptors.Modality r21 = r9.modality(r10);
        kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoEnumFlags r9 = kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoEnumFlags.INSTANCE;
        kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.FlagField<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Visibility> r10 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.VISIBILITY;
        kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Visibility r1 = r10.get(r1);
        kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Visibility r1 = r1;
        kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility r22 = kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoEnumFlagsUtilsKt.descriptorVisibility(r9, r1);
        boolean r23 = r3 ^ true;
        kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind r26 = r13.getKind();
        kotlin.reflect.jvm.internal.impl.descriptors.SourceElement r28 = kotlin.reflect.jvm.internal.impl.descriptors.SourceElement.NO_SOURCE;
        kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertySetterDescriptorImpl r5 = new kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertySetterDescriptorImpl(r19, r4, r21, r22, r23, r24, r25, r26, null, r28);
        kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertySetterDescriptorImpl r9 = r5;
        java.util.List r10 = kotlin.collections.CollectionsKt.emptyList();
        kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Property r1 = r14;
        kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext r4 = kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext.childContext$default(r8, r9, r10, null, null, null, null, 60, null);
        kotlin.reflect.jvm.internal.impl.serialization.deserialization.MemberDeserializer r4 = r4.getMemberDeserializer();
        kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.ValueParameter r8 = r37.getSetterValueParameter();
        java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.ValueParameter> r8 = kotlin.collections.CollectionsKt.listOf(r8);
        kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotatedCallableKind r9 = kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotatedCallableKind.PROPERTY_SETTER;
        java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor> r1 = r4.valueParameters(r8, r1, r9);
        java.lang.Object r1 = kotlin.collections.CollectionsKt.single(r1);
        kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor r1 = (kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor) r1;
        r5.initialize(r1);
    L44:
        kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.BooleanFlagField r1 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.HAS_CONSTANT;
        java.lang.Boolean r1 = r1.get(r14);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, "HAS_CONSTANT.get(flags)");
        boolean r1 = r1.booleanValue();
        if (r1 == false) goto L47;
        kotlin.Function r1 = new kotlin.reflect.jvm.internal.impl.serialization.deserialization.MemberDeserializer.AnonymousClass4(r36, r37, r13);
        kotlin.jvm.functions.Function0<kotlin.reflect.jvm.internal.impl.storage.NullableLazyValue<kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue<?>>> r1 = (kotlin.jvm.functions.Function0) r1;
        r13.setCompileTimeInitializerFactory(r1);
    L47:
        kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext r1 = r36.c;
        kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor r1 = r1.getContainingDeclaration();
        boolean r3 = r1 instanceof kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
        if (r3 == false) goto L50;
        kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r1 = (kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) r1;
    L51:
        if (r1 == null) goto L53;
        r17 = r1.getKind();
    L53:
        kotlin.reflect.jvm.internal.impl.descriptors.ClassKind r1 = r17;
        kotlin.reflect.jvm.internal.impl.descriptors.ClassKind r3 = kotlin.reflect.jvm.internal.impl.descriptors.ClassKind.ANNOTATION_CLASS;
        if (r1 != r3) goto L56;
        kotlin.Function r1 = new kotlin.reflect.jvm.internal.impl.serialization.deserialization.MemberDeserializer.AnonymousClass5(r36, r13, r13);
        kotlin.jvm.functions.Function0<kotlin.reflect.jvm.internal.impl.storage.NullableLazyValue<kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue<?>>> r1 = (kotlin.jvm.functions.Function0) r1;
        r13.setCompileTimeInitializerFactory(r1);
    L56:
        kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertySetterDescriptorImpl r5 = (kotlin.reflect.jvm.internal.impl.descriptors.PropertySetterDescriptor) r5;
        kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations r3 = getPropertyFieldAnnotations(r13, false);
        kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedPropertyDescriptor r13 = (kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor) r13;
        kotlin.reflect.jvm.internal.impl.descriptors.impl.FieldDescriptorImpl r1 = new kotlin.reflect.jvm.internal.impl.descriptors.impl.FieldDescriptorImpl(r3, r13);
        kotlin.reflect.jvm.internal.impl.descriptors.impl.FieldDescriptorImpl r1 = (kotlin.reflect.jvm.internal.impl.descriptors.FieldDescriptor) r1;
        kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations r0 = getPropertyFieldAnnotations(r13, true);
        kotlin.reflect.jvm.internal.impl.descriptors.impl.FieldDescriptorImpl r3 = new kotlin.reflect.jvm.internal.impl.descriptors.impl.FieldDescriptorImpl(r0, r13);
        kotlin.reflect.jvm.internal.impl.descriptors.impl.FieldDescriptorImpl r3 = (kotlin.reflect.jvm.internal.impl.descriptors.FieldDescriptor) r3;
        r13.initialize(r6, r5, r1, r3);
        return r13;
    L50:
        r1 = null;
        goto L51
    L42:
        kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedPropertyDescriptor r13 = (kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor) r13;
        kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.Companion r1 = kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.Companion;
        kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations r1 = r1.getEMPTY();
        r5 = kotlin.reflect.jvm.internal.impl.resolve.DescriptorFactory.createDefaultSetter(r13, r4, r1);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, "{\n                Descri…          )\n            }");
        goto L44
    L43:
        kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertySetterDescriptorImpl r1 = (kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertySetterDescriptorImpl) null;
        r5 = null;
        goto L44
    L31:
        kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedPropertyDescriptor r3 = (kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor) r13;
        r6 = kotlin.reflect.jvm.internal.impl.resolve.DescriptorFactory.createDefaultGetter(r3, r5);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, "{\n                Descri…nnotations)\n            }");
        goto L32
    L27:
        r3 = r1;
        goto L28
    L33:
        kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyGetterDescriptorImpl r3 = (kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyGetterDescriptorImpl) null;
        r6 = null;
    L17:
        r5 = null;
    L11:
        r14 = r12;
        kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.Companion r1 = kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.Companion;
        r1 = r1.getEMPTY();
        goto L12
    L5:
        int r1 = r37.getOldFlags();
        r1 = loadOldFlags(r1);
        goto L6
    }

    private final void initializeWithCoroutinesExperimentalityStatus(DeserializedSimpleFunctionDescriptor r1, ReceiverParameterDescriptor r2, ReceiverParameterDescriptor r3, List<? extends ReceiverParameterDescriptor> r4, List<? extends TypeParameterDescriptor> r5, List<? extends ValueParameterDescriptor> r6, KotlinType r7, Modality r8, DescriptorVisibility r9, Map<? extends CallableDescriptor.UserDataKey<?>, ?> r10) {
        r1.initialize(r2, r3, r4, r5, r6, r7, r8, r9, r10);
    }

    public final SimpleFunctionDescriptor loadFunction(ProtoBuf.Function r36) {
        Intrinsics.checkNotNullParameter(r36, "proto");
        if (r36.hasFlags() == false) goto L5;
        int r0 = r36.getFlags();
    L6:
        int r9 = r0;
        ProtoBuf.Function r1 = r36;
        Annotations r15 = getAnnotations(r1, r9, AnnotatedCallableKind.FUNCTION);
        if (ProtoTypeTableUtilKt.hasReceiver(r36) == false) goto L9;
        Annotations r2 = getReceiverParameterAnnotations(r1, AnnotatedCallableKind.FUNCTION);
    L11:
        if (Intrinsics.areEqual(DescriptorUtilsKt.getFqNameSafe(this.c.getContainingDeclaration()).child(NameResolverUtilKt.getName(this.c.getNameResolver(), r36.getName())), SuspendFunctionTypeUtilKt.KOTLIN_SUSPEND_BUILT_IN_FUNCTION_FQ_NAME) == false) goto L13;
        VersionRequirementTable r3 = VersionRequirementTable.Companion.getEMPTY();
    L14:
        DeserializedSimpleFunctionDescriptor r8 = new DeserializedSimpleFunctionDescriptor(this.c.getContainingDeclaration(), null, r15, NameResolverUtilKt.getName(this.c.getNameResolver(), r36.getName()), ProtoEnumFlagsUtilsKt.memberKind(ProtoEnumFlags.INSTANCE, Flags.MEMBER_KIND.get(r9)), r36, this.c.getNameResolver(), this.c.getTypeTable(), r3, this.c.getContainerSource(), null, 1024, null);
        List<ProtoBuf.TypeParameter> r4 = r36.getTypeParameterList();
        Intrinsics.checkNotNullExpressionValue(r4, "proto.typeParameterList");
        DeserializationContext r12 = DeserializationContext.childContext$default(this.c, r8, r4, null, null, null, null, 60, null);
        ProtoBuf.Type r5 = ProtoTypeTableUtilKt.receiverType(r36, this.c.getTypeTable());
        if (r5 == null) goto L19;
        KotlinType r6 = r12.getTypeDeserializer().type(r5);
        if (r6 == null) goto L19;
        ReceiverParameterDescriptor r7 = DescriptorFactory.createExtensionReceiverParameterForCallable(r8, r6, r2);
    L20:
        ReceiverParameterDescriptor r10 = r7;
        ReceiverParameterDescriptor r11 = getDispatchReceiverParameter();
        List<ProtoBuf.Type> r13 = ProtoTypeTableUtilKt.contextReceiverTypes(r36, this.c.getTypeTable());
        ArrayList r14 = new ArrayList();
        Iterator<T> r16 = r13.iterator();
    L22:
        if (r16.hasNext() == false) goto L26;
        ReceiverParameterDescriptor r17 = toContextReceiver((ProtoBuf.Type) r16.next(), r12, r8);
        if (r17 == null) goto L22;
        r14.add(r17);
        goto L22
    L26:
        List<TypeParameterDescriptor> r18 = r12.getTypeDeserializer().getOwnTypeParameters();
        MemberDeserializer r19 = r12.getMemberDeserializer();
        List<ProtoBuf.ValueParameter> r20 = r36.getValueParameterList();
        Intrinsics.checkNotNullExpressionValue(r20, "proto.valueParameterList");
        initializeWithCoroutinesExperimentalityStatus(r8, r10, r11, r14, r18, r19.valueParameters(r20, r1, AnnotatedCallableKind.FUNCTION), r12.getTypeDeserializer().type(ProtoTypeTableUtilKt.returnType(r36, this.c.getTypeTable())), ProtoEnumFlags.INSTANCE.modality(Flags.MODALITY.get(r9)), ProtoEnumFlagsUtilsKt.descriptorVisibility(ProtoEnumFlags.INSTANCE, Flags.VISIBILITY.get(r9)), MapsKt.emptyMap());
        Boolean r21 = Flags.IS_OPERATOR.get(r9);
        Intrinsics.checkNotNullExpressionValue(r21, "IS_OPERATOR.get(flags)");
        r8.setOperator(r21.booleanValue());
        Boolean r22 = Flags.IS_INFIX.get(r9);
        Intrinsics.checkNotNullExpressionValue(r22, "IS_INFIX.get(flags)");
        r8.setInfix(r22.booleanValue());
        Boolean r23 = Flags.IS_EXTERNAL_FUNCTION.get(r9);
        Intrinsics.checkNotNullExpressionValue(r23, "IS_EXTERNAL_FUNCTION.get(flags)");
        r8.setExternal(r23.booleanValue());
        Boolean r24 = Flags.IS_INLINE.get(r9);
        Intrinsics.checkNotNullExpressionValue(r24, "IS_INLINE.get(flags)");
        r8.setInline(r24.booleanValue());
        Boolean r25 = Flags.IS_TAILREC.get(r9);
        Intrinsics.checkNotNullExpressionValue(r25, "IS_TAILREC.get(flags)");
        r8.setTailrec(r25.booleanValue());
        Boolean r26 = Flags.IS_SUSPEND.get(r9);
        Intrinsics.checkNotNullExpressionValue(r26, "IS_SUSPEND.get(flags)");
        r8.setSuspend(r26.booleanValue());
        Boolean r27 = Flags.IS_EXPECT_FUNCTION.get(r9);
        Intrinsics.checkNotNullExpressionValue(r27, "IS_EXPECT_FUNCTION.get(flags)");
        r8.setExpect(r27.booleanValue());
        r8.setHasStableParameterNames(!Flags.IS_FUNCTION_WITH_NON_STABLE_PARAMETER_NAMES.get(r9).booleanValue());
        Pair<CallableDescriptor.UserDataKey<?>, Object> r28 = this.c.getComponents().getContractDeserializer().deserializeContractFromFunction(r36, r8, this.c.getTypeTable(), r12.getTypeDeserializer());
        if (r28 == null) goto L30;
        r8.putInUserDataMap(r28.getFirst(), r28.getSecond());
    L30:
        return r8;
    L19:
        r7 = null;
        goto L20
    L13:
        r3 = this.c.getVersionRequirementTable();
        goto L14
    L9:
        r2 = Annotations.Companion.getEMPTY();
        goto L11
    L5:
        r0 = loadOldFlags(r36.getOldFlags());
        goto L6
    }

    public final TypeAliasDescriptor loadTypeAlias(ProtoBuf.TypeAlias r24) {
        Intrinsics.checkNotNullParameter(r24, "proto");
        Annotations.Companion r1 = Annotations.Companion;
        List<ProtoBuf.Annotation> r2 = r24.getAnnotationList();
        Intrinsics.checkNotNullExpressionValue(r2, "proto.annotationList");
        List<ProtoBuf.Annotation> r3 = r2;
        ArrayList r4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r3, 10));
        Iterator<T> r5 = r3.iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        ProtoBuf.Annotation r6 = (ProtoBuf.Annotation) r5.next();
        AnnotationDeserializer r7 = this.annotationDeserializer;
        Intrinsics.checkNotNullExpressionValue(r6, "it");
        r4.add(r7.deserializeAnnotation(r6, this.c.getNameResolver()));
        goto L4
    L6:
        Annotations r8 = r1.create(r4);
        DescriptorVisibility r9 = ProtoEnumFlagsUtilsKt.descriptorVisibility(ProtoEnumFlags.INSTANCE, Flags.VISIBILITY.get(r24.getFlags()));
        DeserializedTypeAliasDescriptor r13 = new DeserializedTypeAliasDescriptor(this.c.getStorageManager(), this.c.getContainingDeclaration(), r8, NameResolverUtilKt.getName(this.c.getNameResolver(), r24.getName()), r9, r24, this.c.getNameResolver(), this.c.getTypeTable(), this.c.getVersionRequirementTable(), this.c.getContainerSource());
        List<ProtoBuf.TypeParameter> r10 = r24.getTypeParameterList();
        Intrinsics.checkNotNullExpressionValue(r10, "proto.typeParameterList");
        DeserializationContext r11 = DeserializationContext.childContext$default(this.c, r13, r10, null, null, null, null, 60, null);
        r13.initialize(r11.getTypeDeserializer().getOwnTypeParameters(), r11.getTypeDeserializer().simpleType(ProtoTypeTableUtilKt.underlyingType(r24, this.c.getTypeTable()), false), r11.getTypeDeserializer().simpleType(ProtoTypeTableUtilKt.expandedType(r24, this.c.getTypeTable()), false));
        return r13;
    }

    private final ReceiverParameterDescriptor getDispatchReceiverParameter() {
        DeclarationDescriptor r2 = this.c.getContainingDeclaration();
        if ((r2 instanceof ClassDescriptor) == false) goto L5;
        ClassDescriptor r3 = (ClassDescriptor) r2;
    L6:
        if (r3 != null) goto L8;
        return null;
    L8:
        return r3.getThisAsReceiverParameter();
    L5:
        r3 = null;
        goto L6
    }

    public final ClassConstructorDescriptor loadConstructor(ProtoBuf.Constructor r30, boolean r31) {
        Intrinsics.checkNotNullParameter(r30, "proto");
        DeclarationDescriptor r1 = this.c.getContainingDeclaration();
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
        ClassDescriptor r16 = (ClassDescriptor) r1;
        ProtoBuf.Constructor r13 = r30;
        DeserializedClassConstructorDescriptor r14 = new DeserializedClassConstructorDescriptor(r16, null, getAnnotations(r13, r30.getFlags(), AnnotatedCallableKind.FUNCTION), r31, CallableMemberDescriptor.Kind.DECLARATION, r30, this.c.getNameResolver(), this.c.getTypeTable(), this.c.getVersionRequirementTable(), this.c.getContainerSource(), null, 1024, null);
        MemberDeserializer r0 = DeserializationContext.childContext$default(this.c, r14, CollectionsKt.emptyList(), null, null, null, null, 60, null).getMemberDeserializer();
        List<ProtoBuf.ValueParameter> r2 = r30.getValueParameterList();
        Intrinsics.checkNotNullExpressionValue(r2, "proto.valueParameterList");
        r14.initialize(r0.valueParameters(r2, r13, AnnotatedCallableKind.FUNCTION), ProtoEnumFlagsUtilsKt.descriptorVisibility(ProtoEnumFlags.INSTANCE, Flags.VISIBILITY.get(r30.getFlags())));
        r14.setReturnType(r16.getDefaultType());
        r14.setExpect(r16.isExpect());
        r14.setHasStableParameterNames(!Flags.IS_CONSTRUCTOR_WITH_NON_STABLE_PARAMETER_NAMES.get(r30.getFlags()).booleanValue());
        return r14;
    }

    private final Annotations getAnnotations(final MessageLite r3, int r4, final AnnotatedCallableKind r5) {
        if (Flags.HAS_ANNOTATIONS.get(r4).booleanValue() == true) goto L7;
        return Annotations.Companion.getEMPTY();
    L7:
        return new NonEmptyDeserializedAnnotations(this.c.getStorageManager(), new AnonymousClass1(this, r3, r5));
    }

    private final Annotations getPropertyFieldAnnotations(final ProtoBuf.Property r4, final boolean r5) {
        if (Flags.HAS_ANNOTATIONS.get(r4.getFlags()).booleanValue() == true) goto L7;
        return Annotations.Companion.getEMPTY();
    L7:
        return new NonEmptyDeserializedAnnotations(this.c.getStorageManager(), new C04801(this, r5, r4));
    }

    private final Annotations getReceiverParameterAnnotations(final MessageLite r4, final AnnotatedCallableKind r5) {
        return new DeserializedAnnotations(this.c.getStorageManager(), new C04811(this, r4, r5));
    }

    private final List<ValueParameterDescriptor> valueParameters(List<ProtoBuf.ValueParameter> r26, final MessageLite r27, final AnnotatedCallableKind r28) {
        DeclarationDescriptor r0 = this.c.getContainingDeclaration();
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.CallableDescriptor");
        CallableDescriptor r20 = (CallableDescriptor) r0;
        DeclarationDescriptor r1 = r20.getContainingDeclaration();
        Intrinsics.checkNotNullExpressionValue(r1, "callableDescriptor.containingDeclaration");
        final ProtoContainer r21 = asProtoContainer(r1);
        List<ProtoBuf.ValueParameter> r2 = r26;
        ArrayList r15 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r2, 10));
        Iterator<T> r22 = r2.iterator();
        int r11 = 0;
    L4:
        if (r22.hasNext() == false) goto L23;
        Object r3 = r22.next();
        int r24 = r11 + 1;
        if (r11 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        final ProtoBuf.ValueParameter r8 = (ProtoBuf.ValueParameter) r3;
        if (r8.hasFlags() == false) goto L11;
        int r9 = r8.getFlags();
    L12:
        if (r21 == null) goto L16;
        Boolean r4 = Flags.HAS_ANNOTATIONS.get(r9);
        Intrinsics.checkNotNullExpressionValue(r4, "HAS_ANNOTATIONS.get(flags)");
        if (r4.booleanValue() == false) goto L16;
        final int r5 = r11;
        Annotations r12 = new NonEmptyDeserializedAnnotations(this.c.getStorageManager(), new MemberDeserializer$valueParameters$1$annotations$1(this, r21, r27, r28, r5, r8));
    L17:
        Name r13 = NameResolverUtilKt.getName(this.c.getNameResolver(), r8.getName());
        KotlinType r14 = this.c.getTypeDeserializer().type(ProtoTypeTableUtilKt.type(r8, this.c.getTypeTable()));
        Boolean r6 = Flags.DECLARES_DEFAULT_VALUE.get(r9);
        Intrinsics.checkNotNullExpressionValue(r6, "DECLARES_DEFAULT_VALUE.get(flags)");
        boolean r7 = r6.booleanValue();
        Boolean r10 = Flags.IS_CROSSINLINE.get(r9);
        Intrinsics.checkNotNullExpressionValue(r10, "IS_CROSSINLINE.get(flags)");
        boolean r16 = r10.booleanValue();
        Boolean r17 = Flags.IS_NOINLINE.get(r9);
        Intrinsics.checkNotNullExpressionValue(r17, "IS_NOINLINE.get(flags)");
        boolean r18 = r17.booleanValue();
        ProtoBuf.Type r19 = ProtoTypeTableUtilKt.varargElementType(r8, this.c.getTypeTable());
        if (r19 == null) goto L20;
        KotlinType r23 = this.c.getTypeDeserializer().type(r19);
    L21:
        KotlinType r110 = r23;
        SourceElement r25 = SourceElement.NO_SOURCE;
        Intrinsics.checkNotNullExpressionValue(r25, "NO_SOURCE");
        ArrayList r29 = r15;
        r29.add(new ValueParameterDescriptorImpl(r20, null, r11, r12, r13, r14, r7, r16, r18, r110, r25));
        r15 = r29;
        r11 = r24;
        goto L4
    L20:
        r23 = null;
    L16:
        r12 = Annotations.Companion.getEMPTY();
        goto L17
    L11:
        r9 = 0;
        goto L12
    L23:
        return CollectionsKt.toList(r15);
    }

    private final ProtoContainer asProtoContainer(DeclarationDescriptor r4) {
        if ((r4 instanceof PackageFragmentDescriptor) == false) goto L6;
        return new ProtoContainer.Package(((PackageFragmentDescriptor) r4).getFqName(), this.c.getNameResolver(), this.c.getTypeTable(), this.c.getContainerSource());
    L6:
        if ((r4 instanceof DeserializedClassDescriptor) == true) goto L11;
        return null;
    L11:
        return ((DeserializedClassDescriptor) r4).getThisAsProtoContainer$deserialization();
    }

    private final ReceiverParameterDescriptor toContextReceiver(ProtoBuf.Type r1, DeserializationContext r2, CallableDescriptor r3) {
        return DescriptorFactory.createContextReceiverParameterForCallable(r3, r2.getTypeDeserializer().type(r1), Annotations.Companion.getEMPTY());
    }
}
