package kotlin.reflect.jvm.internal.impl.load.kotlin;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.SpecialJvmAnnotations;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.load.kotlin.AbstractBinaryClassAnnotationLoader.AnnotationsContainer;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoBufUtilKt;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoTypeTableUtilKt;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.ClassMapperLite;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMemberSignature;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmProtoBufUtil;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmClassName;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotatedCallableKind;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationLoader;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoContainer;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: AbstractBinaryClassAnnotationLoader.kt */
/* JADX INFO: loaded from: classes4.dex */
public abstract class AbstractBinaryClassAnnotationLoader<A, S extends AnnotationsContainer<? extends A>> implements AnnotationLoader<A> {
    private final KotlinClassFinder kotlinClassFinder;

    /* JADX INFO: compiled from: AbstractBinaryClassAnnotationLoader.kt */
    public static abstract class AnnotationsContainer<A> {
        public abstract Map<MemberSignature, List<A>> getMemberAnnotations();

        public AnnotationsContainer() {
        }
    }

    /* JADX INFO: compiled from: AbstractBinaryClassAnnotationLoader.kt */
    private static final enum PropertyRelatedElement extends Enum<PropertyRelatedElement> {
        private static final /* synthetic */ PropertyRelatedElement[] $VALUES = null;
        public static final PropertyRelatedElement BACKING_FIELD = null;
        public static final PropertyRelatedElement DELEGATE_FIELD = null;
        public static final PropertyRelatedElement PROPERTY = null;

        private static final /* synthetic */ PropertyRelatedElement[] $values() {
            return new PropertyRelatedElement[]{PROPERTY, BACKING_FIELD, DELEGATE_FIELD};
        }

        public static PropertyRelatedElement valueOf(String r1) {
            return (PropertyRelatedElement) Enum.valueOf(PropertyRelatedElement.class, r1);
        }

        public static PropertyRelatedElement[] values() {
            return (PropertyRelatedElement[]) $VALUES.clone();
        }

        private PropertyRelatedElement(String r1, int r2) {
            super(r1, r2);
        }

        static {
            PROPERTY = new PropertyRelatedElement("PROPERTY", 0);
            BACKING_FIELD = new PropertyRelatedElement("BACKING_FIELD", 1);
            DELEGATE_FIELD = new PropertyRelatedElement("DELEGATE_FIELD", 2);
            $VALUES = $values();
        }
    }

    /* JADX INFO: compiled from: AbstractBinaryClassAnnotationLoader.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r0 = new int[AnnotatedCallableKind.values().length];
            r0[AnnotatedCallableKind.PROPERTY_GETTER.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[AnnotatedCallableKind.PROPERTY_SETTER.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[AnnotatedCallableKind.PROPERTY.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            $EnumSwitchMapping$0 = r0;
        }
    }

    protected abstract S getAnnotationsContainer(KotlinJvmBinaryClass r1);

    protected byte[] getCachedFileContent(KotlinJvmBinaryClass r1) {
        Intrinsics.checkNotNullParameter(r1, "kotlinClass");
        return null;
    }

    protected abstract KotlinJvmBinaryClass.AnnotationArgumentVisitor loadAnnotation(ClassId r1, SourceElement r2, List<A> r3);

    protected abstract A loadTypeAnnotation(ProtoBuf.Annotation r1, NameResolver r2);

    public AbstractBinaryClassAnnotationLoader(KotlinClassFinder r2) {
        Intrinsics.checkNotNullParameter(r2, "kotlinClassFinder");
        this.kotlinClassFinder = r2;
    }

    protected final KotlinJvmBinaryClass.AnnotationArgumentVisitor loadAnnotationIfNotSpecial(ClassId r2, SourceElement r3, List<A> r4) {
        Intrinsics.checkNotNullParameter(r2, "annotationClassId");
        Intrinsics.checkNotNullParameter(r3, "source");
        Intrinsics.checkNotNullParameter(r4, "result");
        if (SpecialJvmAnnotations.INSTANCE.getSPECIAL_ANNOTATIONS().contains(r2) == false) goto L7;
        return null;
    L7:
        return loadAnnotation(r2, r3, r4);
    }

    private final KotlinJvmBinaryClass toBinaryClass(ProtoContainer.Class r2) {
        SourceElement r1 = r2.getSource();
        if ((r1 instanceof KotlinJvmBinarySourceElement) == false) goto L5;
        KotlinJvmBinarySourceElement r3 = (KotlinJvmBinarySourceElement) r1;
    L6:
        if (r3 != null) goto L8;
        return null;
    L8:
        return r3.getBinaryClass();
    L5:
        r3 = null;
        goto L6
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationLoader
    public List<A> loadClassAnnotations(ProtoContainer.Class r3) {
        Intrinsics.checkNotNullParameter(r3, "container");
        KotlinJvmBinaryClass r0 = toBinaryClass(r3);
        if (r0 == null) goto L7;
        final ArrayList r4 = new ArrayList(1);
        r0.loadClassAnnotations(new AnonymousClass1(this, r4), getCachedFileContent(r0));
        return r4;
    L7:
        throw new IllegalStateException(("Class for loading annotations is not found: " + r3.debugFqName()).toString());
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationLoader
    public List<A> loadCallableAnnotations(ProtoContainer r11, MessageLite r12, AnnotatedCallableKind r13) {
        Intrinsics.checkNotNullParameter(r11, "container");
        Intrinsics.checkNotNullParameter(r12, "proto");
        Intrinsics.checkNotNullParameter(r13, "kind");
        if (r13 == AnnotatedCallableKind.PROPERTY) goto L5;
        MemberSignature r2 = getCallableSignature$default(this, r12, r11.getNameResolver(), r11.getTypeTable(), r13, false, 16, null);
        if (r2 != null) goto L11;
        return CollectionsKt.emptyList();
    L11:
        return findClassAndLoadMemberAnnotations$default(this, r11, r2, false, false, null, false, 60, null);
    L5:
        return loadPropertyAnnotations(r11, (ProtoBuf.Property) r12, PropertyRelatedElement.PROPERTY);
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationLoader
    public List<A> loadPropertyBackingFieldAnnotations(ProtoContainer r2, ProtoBuf.Property r3) {
        Intrinsics.checkNotNullParameter(r2, "container");
        Intrinsics.checkNotNullParameter(r3, "proto");
        return loadPropertyAnnotations(r2, r3, PropertyRelatedElement.BACKING_FIELD);
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationLoader
    public List<A> loadPropertyDelegateFieldAnnotations(ProtoContainer r2, ProtoBuf.Property r3) {
        Intrinsics.checkNotNullParameter(r2, "container");
        Intrinsics.checkNotNullParameter(r3, "proto");
        return loadPropertyAnnotations(r2, r3, PropertyRelatedElement.DELEGATE_FIELD);
    }

    private final List<A> loadPropertyAnnotations(ProtoContainer r18, ProtoBuf.Property r19, PropertyRelatedElement r20) {
        Boolean r1 = Flags.IS_CONST.get(r19.getFlags());
        Intrinsics.checkNotNullExpressionValue(r1, "IS_CONST.get(proto.flags)");
        boolean r2 = r1.booleanValue();
        boolean r8 = JvmProtoBufUtil.isMovedFromInterfaceCompanion(r19);
        if (r20 != PropertyRelatedElement.PROPERTY) goto L10;
        MemberSignature r4 = AbstractBinaryClassAnnotationLoaderKt.getPropertySignature$default(r19, r18.getNameResolver(), r18.getTypeTable(), false, true, false, 40, null);
        if (r4 != null) goto L9;
        return CollectionsKt.emptyList();
    L9:
        return findClassAndLoadMemberAnnotations$default(this, r18, r4, true, false, Boolean.valueOf(r2), r8, 8, null);
    L10:
        MemberSignature r5 = AbstractBinaryClassAnnotationLoaderKt.getPropertySignature$default(r19, r18.getNameResolver(), r18.getTypeTable(), true, false, false, 48, null);
        if (r5 == null) goto L13;
        boolean r7 = false;
        boolean r3 = StringsKt.contains$default(r5.getSignature(), "$delegate", false, 2, null);
        if (r20 != PropertyRelatedElement.DELEGATE_FIELD) goto L17;
        r7 = true;
    L17:
        if (r3 == r7) goto L21;
        return CollectionsKt.emptyList();
    L21:
        return findClassAndLoadMemberAnnotations(r18, r5, true, true, Boolean.valueOf(r2), r8);
    L13:
        return CollectionsKt.emptyList();
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationLoader
    public List<A> loadEnumEntryAnnotations(ProtoContainer r12, ProtoBuf.EnumEntry r13) {
        Intrinsics.checkNotNullParameter(r12, "container");
        Intrinsics.checkNotNullParameter(r13, "proto");
        MemberSignature.Companion r0 = MemberSignature.Companion;
        String r14 = r12.getNameResolver().getString(r13.getName());
        String r1 = ((ProtoContainer.Class) r12).getClassId().asString();
        Intrinsics.checkNotNullExpressionValue(r1, "container as ProtoContai…Class).classId.asString()");
        return findClassAndLoadMemberAnnotations$default(this, r12, r0.fromFieldNameAndDesc(r14, ClassMapperLite.mapClass(r1)), false, false, null, false, 60, null);
    }

    static /* synthetic */ List findClassAndLoadMemberAnnotations$default(AbstractBinaryClassAnnotationLoader r9, ProtoContainer r10, MemberSignature r11, boolean r12, boolean r13, Boolean r14, boolean r15, int r16, Object r17) {
        if (r17 != null) goto L22;
        if ((r16 & 4) == 0) goto L6;
        boolean r5 = false;
    L8:
        if ((r16 & 8) == 0) goto L10;
        boolean r6 = false;
    L12:
        if ((r16 & 16) == 0) goto L14;
        Boolean r7 = null;
    L16:
        if ((r16 & 32) == 0) goto L18;
        boolean r8 = false;
    L20:
        return r9.findClassAndLoadMemberAnnotations(r10, r11, r5, r6, r7, r8);
    L18:
        r8 = r15;
        goto L20
    L14:
        r7 = r14;
        goto L16
    L10:
        r6 = r13;
        goto L12
    L6:
        r5 = r12;
        goto L8
    L22:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: findClassAndLoadMemberAnnotations");
    }

    private final List<A> findClassAndLoadMemberAnnotations(ProtoContainer r7, MemberSignature r8, boolean r9, boolean r10, Boolean r11, boolean r12) {
        KotlinJvmBinaryClass r13 = findClassWithAnnotationsAndInitializers(r7, getSpecialCaseContainerClass(r7, r9, r10, r11, r12));
        if (r13 == null) goto L5;
        List<A> r6 = getAnnotationsContainer(r13).getMemberAnnotations().get(r8);
        if (r6 == null) goto L9;
        return r6;
    L9:
        return CollectionsKt.emptyList();
    L5:
        return CollectionsKt.emptyList();
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationLoader
    public List<A> loadValueParameterAnnotations(ProtoContainer r10, MessageLite r11, AnnotatedCallableKind r12, int r13, ProtoBuf.ValueParameter r14) {
        Intrinsics.checkNotNullParameter(r10, "container");
        Intrinsics.checkNotNullParameter(r11, "callableProto");
        Intrinsics.checkNotNullParameter(r12, "kind");
        Intrinsics.checkNotNullParameter(r14, "proto");
        MemberSignature r15 = getCallableSignature$default(this, r11, r10.getNameResolver(), r10.getTypeTable(), r12, false, 16, null);
        if (r15 == null) goto L7;
        int r16 = r13 + computeJvmParameterIndexShift(r10, r11);
        return findClassAndLoadMemberAnnotations$default(this, r10, MemberSignature.Companion.fromMethodSignatureAndParameterIndex(r15, r16), false, false, null, false, 60, null);
    L7:
        return CollectionsKt.emptyList();
    }

    private final int computeJvmParameterIndexShift(ProtoContainer r3, MessageLite r4) {
        if ((r4 instanceof ProtoBuf.Function) == false) goto L9;
        if (ProtoTypeTableUtilKt.hasReceiver((ProtoBuf.Function) r4) == false) goto L20;
        return 1;
    L20:
        return 0;
    L9:
        if ((r4 instanceof ProtoBuf.Property) == false) goto L14;
        if (ProtoTypeTableUtilKt.hasReceiver((ProtoBuf.Property) r4) == false) goto L20;
        return 1;
    L14:
        if ((r4 instanceof ProtoBuf.Constructor) == false) goto L22;
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type org.jetbrains.kotlin.serialization.deserialization.ProtoContainer.Class");
        ProtoContainer.Class r5 = (ProtoContainer.Class) r3;
        if (r5.getKind() != ProtoBuf.Class.Kind.ENUM_CLASS) goto L19;
        return 2;
    L19:
        if (r5.isInner() == false) goto L20;
        return 1;
    L22:
        throw new UnsupportedOperationException("Unsupported message: " + r4.getClass());
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationLoader
    public List<A> loadExtensionReceiverParameterAnnotations(ProtoContainer r11, MessageLite r12, AnnotatedCallableKind r13) {
        Intrinsics.checkNotNullParameter(r11, "container");
        Intrinsics.checkNotNullParameter(r12, "proto");
        Intrinsics.checkNotNullParameter(r13, "kind");
        MemberSignature r14 = getCallableSignature$default(this, r12, r11.getNameResolver(), r11.getTypeTable(), r13, false, 16, null);
        if (r14 == null) goto L7;
        return findClassAndLoadMemberAnnotations$default(this, r11, MemberSignature.Companion.fromMethodSignatureAndParameterIndex(r14, 0), false, false, null, false, 60, null);
    L7:
        return CollectionsKt.emptyList();
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationLoader
    public List<A> loadTypeAnnotations(ProtoBuf.Type r4, NameResolver r5) {
        Intrinsics.checkNotNullParameter(r4, "proto");
        Intrinsics.checkNotNullParameter(r5, "nameResolver");
        Object r6 = r4.getExtension(JvmProtoBuf.typeAnnotation);
        Intrinsics.checkNotNullExpressionValue(r6, "proto.getExtension(JvmProtoBuf.typeAnnotation)");
        Iterable r7 = (Iterable) r6;
        ArrayList r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r7, 10));
        Iterator r8 = r7.iterator();
    L4:
        if (r8.hasNext() == false) goto L7;
        ProtoBuf.Annotation r1 = (ProtoBuf.Annotation) r8.next();
        Intrinsics.checkNotNullExpressionValue(r1, "it");
        r0.add(loadTypeAnnotation(r1, r5));
        goto L4
    L7:
        return r0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationLoader
    public List<A> loadTypeParameterAnnotations(ProtoBuf.TypeParameter r4, NameResolver r5) {
        Intrinsics.checkNotNullParameter(r4, "proto");
        Intrinsics.checkNotNullParameter(r5, "nameResolver");
        Object r6 = r4.getExtension(JvmProtoBuf.typeParameterAnnotation);
        Intrinsics.checkNotNullExpressionValue(r6, "proto.getExtension(JvmPr….typeParameterAnnotation)");
        Iterable r7 = (Iterable) r6;
        ArrayList r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r7, 10));
        Iterator r8 = r7.iterator();
    L4:
        if (r8.hasNext() == false) goto L7;
        ProtoBuf.Annotation r1 = (ProtoBuf.Annotation) r8.next();
        Intrinsics.checkNotNullExpressionValue(r1, "it");
        r0.add(loadTypeAnnotation(r1, r5));
        goto L4
    L7:
        return r0;
    }

    protected final KotlinJvmBinaryClass findClassWithAnnotationsAndInitializers(ProtoContainer r2, KotlinJvmBinaryClass r3) {
        Intrinsics.checkNotNullParameter(r2, "container");
        if (r3 == null) goto L5;
        return r3;
    L5:
        if ((r2 instanceof ProtoContainer.Class) == true) goto L10;
        return null;
    L10:
        return toBinaryClass((ProtoContainer.Class) r2);
    }

    protected final KotlinJvmBinaryClass getSpecialCaseContainerClass(ProtoContainer r7, boolean r8, boolean r9, Boolean r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r7, "container");
        if (r8 == false) goto L27;
        if (r10 == null) goto L26;
        if ((r7 instanceof ProtoContainer.Class) == false) goto L12;
        ProtoContainer.Class r12 = (ProtoContainer.Class) r7;
        if (r12.getKind() != ProtoBuf.Class.Kind.INTERFACE) goto L12;
        KotlinClassFinder r6 = this.kotlinClassFinder;
        ClassId r13 = r12.getClassId().createNestedClassId(Name.identifier("DefaultImpls"));
        Intrinsics.checkNotNullExpressionValue(r13, "container.classId.create…EFAULT_IMPLS_CLASS_NAME))");
        return KotlinClassFinderKt.findKotlinClass(r6, r13);
    L12:
        if (r10.booleanValue() == false) goto L27;
        if ((r7 instanceof ProtoContainer.Package) == false) goto L27;
        SourceElement r14 = r7.getSource();
        if ((r14 instanceof JvmPackagePartSource) == false) goto L18;
        JvmPackagePartSource r15 = (JvmPackagePartSource) r14;
    L19:
        if (r15 == null) goto L21;
        JvmClassName r16 = r15.getFacadeClassName();
    L22:
        if (r16 == null) goto L27;
        KotlinClassFinder r17 = this.kotlinClassFinder;
        String r0 = r16.getInternalName();
        Intrinsics.checkNotNullExpressionValue(r0, "facadeClassName.internalName");
        ClassId r18 = ClassId.topLevel(new FqName(StringsKt.replace$default(r0, '/', '.', false, 4, null)));
        Intrinsics.checkNotNullExpressionValue(r18, "topLevel(FqName(facadeCl…lName.replace('/', '.')))");
        return KotlinClassFinderKt.findKotlinClass(r17, r18);
    L21:
        r16 = null;
        goto L22
    L18:
        r15 = null;
        goto L19
    L26:
        throw new IllegalStateException(("isConst should not be null for property (container=" + r7 + ')').toString());
    L27:
        if (r9 == false) goto L46;
        if ((r7 instanceof ProtoContainer.Class) == false) goto L46;
        ProtoContainer.Class r19 = (ProtoContainer.Class) r7;
        if (r19.getKind() != ProtoBuf.Class.Kind.COMPANION_OBJECT) goto L46;
        ProtoContainer.Class r20 = r19.getOuterClass();
        if (r20 == null) goto L46;
        if (r20.getKind() == ProtoBuf.Class.Kind.CLASS) goto L44;
        if (r20.getKind() == ProtoBuf.Class.Kind.ENUM_CLASS) goto L44;
        if (r11 == false) goto L46;
        if (r20.getKind() == ProtoBuf.Class.Kind.INTERFACE) goto L44;
        if (r20.getKind() != ProtoBuf.Class.Kind.ANNOTATION_CLASS) goto L46;
    L44:
        return toBinaryClass(r20);
    L46:
        if ((r7 instanceof ProtoContainer.Package) == true) goto L48;
    L53:
        return null;
    L48:
        if ((r7.getSource() instanceof JvmPackagePartSource) == false) goto L53;
        SourceElement r21 = r7.getSource();
        Intrinsics.checkNotNull(r21, "null cannot be cast to non-null type org.jetbrains.kotlin.load.kotlin.JvmPackagePartSource");
        JvmPackagePartSource r22 = (JvmPackagePartSource) r21;
        KotlinJvmBinaryClass r23 = r22.getKnownJvmBinaryClass();
        if (r23 == null) goto L52;
        return r23;
    L52:
        return KotlinClassFinderKt.findKotlinClass(this.kotlinClassFinder, r22.getClassId());
    }

    public static /* synthetic */ MemberSignature getCallableSignature$default(AbstractBinaryClassAnnotationLoader r6, MessageLite r7, NameResolver r8, TypeTable r9, AnnotatedCallableKind r10, boolean r11, int r12, Object r13) {
        if (r13 != null) goto L9;
        if ((r12 & 16) == 0) goto L7;
        r11 = false;
    L7:
        return r6.getCallableSignature(r7, r8, r9, r10, r11);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getCallableSignature");
    }

    protected final MemberSignature getCallableSignature(MessageLite r8, NameResolver r9, TypeTable r10, AnnotatedCallableKind r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r8, "proto");
        Intrinsics.checkNotNullParameter(r9, "nameResolver");
        Intrinsics.checkNotNullParameter(r10, "typeTable");
        Intrinsics.checkNotNullParameter(r11, "kind");
        if ((r8 instanceof ProtoBuf.Constructor) == false) goto L9;
        MemberSignature.Companion r7 = MemberSignature.Companion;
        JvmMemberSignature.Method r13 = JvmProtoBufUtil.INSTANCE.getJvmConstructorSignature((ProtoBuf.Constructor) r8, r9, r10);
        if (r13 != null) goto L34;
        return null;
    L34:
        return r7.fromJvmMemberSignature(r13);
    L9:
        if ((r8 instanceof ProtoBuf.Function) == false) goto L15;
        MemberSignature.Companion r14 = MemberSignature.Companion;
        JvmMemberSignature.Method r15 = JvmProtoBufUtil.INSTANCE.getJvmMethodSignature((ProtoBuf.Function) r8, r9, r10);
        if (r15 != null) goto L35;
        return null;
    L35:
        return r14.fromJvmMemberSignature(r15);
    L15:
        if ((r8 instanceof ProtoBuf.Property) == false) goto L36;
        GeneratedMessageLite.GeneratedExtension<ProtoBuf.Property, JvmProtoBuf.JvmPropertySignature> r1 = JvmProtoBuf.propertySignature;
        Intrinsics.checkNotNullExpressionValue(r1, "propertySignature");
        JvmProtoBuf.JvmPropertySignature r16 = (JvmProtoBuf.JvmPropertySignature) ProtoBufUtilKt.getExtensionOrNull((GeneratedMessageLite.ExtendableMessage) r8, r1);
        if (r16 != null) goto L19;
        return null;
    L19:
        int r17 = WhenMappings.$EnumSwitchMapping$0[r11.ordinal()];
        if (r17 == 1) goto L31;
        if (r17 == 2) goto L28;
        if (r17 == 3) goto L37;
        return null;
    L37:
        return AbstractBinaryClassAnnotationLoaderKt.getPropertySignature((ProtoBuf.Property) r8, r9, r10, true, true, r12);
    L28:
        if (r16.hasSetter() == false) goto L38;
        MemberSignature.Companion r18 = MemberSignature.Companion;
        JvmProtoBuf.JvmMethodSignature r19 = r16.getSetter();
        Intrinsics.checkNotNullExpressionValue(r19, "signature.setter");
        return r18.fromMethod(r9, r19);
    L38:
        return null;
    L31:
        if (r16.hasGetter() == false) goto L40;
        MemberSignature.Companion r20 = MemberSignature.Companion;
        JvmProtoBuf.JvmMethodSignature r21 = r16.getGetter();
        Intrinsics.checkNotNullExpressionValue(r21, "signature.getter");
        return r20.fromMethod(r9, r21);
    L40:
        return null;
    L36:
        return null;
    }

    protected final boolean isImplicitRepeatableContainer(ClassId r4) {
        Intrinsics.checkNotNullParameter(r4, "classId");
        if (r4.getOuterClassId() != null) goto L5;
        return false;
    L5:
        if (Intrinsics.areEqual(r4.getShortClassName().asString(), "Container") == false) goto L16;
        KotlinJvmBinaryClass r3 = KotlinClassFinderKt.findKotlinClass(this.kotlinClassFinder, r4);
        if (r3 != null) goto L10;
        return false;
    L10:
        if (SpecialJvmAnnotations.INSTANCE.isAnnotatedWithContainerMetaAnnotation(r3) == false) goto L15;
        return true;
    L15:
        return false;
    L16:
        return false;
    }
}
