package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorUtilKt;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ModalityUtilsKt;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.AdditionalClassPartsProvider;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.PlatformDependentDeclarationFilter;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.PlatformDependentDeclarationFilterKt;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PackageFragmentDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope;
import kotlin.reflect.jvm.internal.impl.load.kotlin.MethodSignatureBuildingUtilsKt;
import kotlin.reflect.jvm.internal.impl.load.kotlin.MethodSignatureMappingKt;
import kotlin.reflect.jvm.internal.impl.load.kotlin.SignatureBuildingComponents;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.NameResolverUtilKt;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor;
import kotlin.reflect.jvm.internal.impl.storage.CacheWithNotNullValues;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageKt;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.LazyWrappedType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.utils.DFS;
import kotlin.reflect.jvm.internal.impl.utils.SmartSet;

/* JADX INFO: compiled from: JvmBuiltInsCustomizer.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class JvmBuiltInsCustomizer implements AdditionalClassPartsProvider, PlatformDependentDeclarationFilter {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = null;
    private final NotNullLazyValue cloneableType$delegate;
    private final JavaToKotlinClassMapper j2kClassMapper;
    private final CacheWithNotNullValues<FqName, ClassDescriptor> javaAnalogueClassesWithCustomSupertypeCache;
    private final KotlinType mockSerializableType;
    private final ModuleDescriptor moduleDescriptor;
    private final NotNullLazyValue notConsideredDeprecation$delegate;
    private final NotNullLazyValue settings$delegate;

    /* JADX INFO: compiled from: JvmBuiltInsCustomizer.kt */
    private static final enum JDKMemberStatus extends Enum<JDKMemberStatus> {
        private static final /* synthetic */ JDKMemberStatus[] $VALUES = null;
        public static final JDKMemberStatus DROP = null;
        public static final JDKMemberStatus HIDDEN = null;
        public static final JDKMemberStatus NOT_CONSIDERED = null;
        public static final JDKMemberStatus VISIBLE = null;

        private static final /* synthetic */ JDKMemberStatus[] $values() {
            return new JDKMemberStatus[]{HIDDEN, VISIBLE, NOT_CONSIDERED, DROP};
        }

        public static JDKMemberStatus valueOf(String r1) {
            return (JDKMemberStatus) Enum.valueOf(JDKMemberStatus.class, r1);
        }

        public static JDKMemberStatus[] values() {
            return (JDKMemberStatus[]) $VALUES.clone();
        }

        private JDKMemberStatus(String r1, int r2) {
            super(r1, r2);
        }

        static {
            HIDDEN = new JDKMemberStatus("HIDDEN", 0);
            VISIBLE = new JDKMemberStatus("VISIBLE", 1);
            NOT_CONSIDERED = new JDKMemberStatus("NOT_CONSIDERED", 2);
            DROP = new JDKMemberStatus("DROP", 3);
            $VALUES = $values();
        }
    }

    /* JADX INFO: compiled from: JvmBuiltInsCustomizer.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r0 = new int[JDKMemberStatus.values().length];
            r0[JDKMemberStatus.HIDDEN.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r0[JDKMemberStatus.NOT_CONSIDERED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r0[JDKMemberStatus.DROP.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[JDKMemberStatus.VISIBLE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            $EnumSwitchMapping$0 = r0;
        }
    }

    public JvmBuiltInsCustomizer(ModuleDescriptor r2, final StorageManager r3, Function0<JvmBuiltIns.Settings> r4) {
        Intrinsics.checkNotNullParameter(r2, "moduleDescriptor");
        Intrinsics.checkNotNullParameter(r3, "storageManager");
        Intrinsics.checkNotNullParameter(r4, "settingsComputation");
        this.moduleDescriptor = r2;
        this.j2kClassMapper = JavaToKotlinClassMapper.INSTANCE;
        this.settings$delegate = r3.createLazyValue(r4);
        this.mockSerializableType = createMockJavaIoSerializableType(r3);
        this.cloneableType$delegate = r3.createLazyValue(new JvmBuiltInsCustomizer$cloneableType$2(this, r3));
        this.javaAnalogueClassesWithCustomSupertypeCache = r3.createCacheWithNotNullValues();
        this.notConsideredDeprecation$delegate = r3.createLazyValue(new JvmBuiltInsCustomizer$notConsideredDeprecation$2(this));
    }

    public static final /* synthetic */ JavaToKotlinClassMapper access$getJ2kClassMapper$p(JvmBuiltInsCustomizer r0) {
        return r0.j2kClassMapper;
    }

    public static final /* synthetic */ LazyJavaClassDescriptor access$getJavaAnalogue(JvmBuiltInsCustomizer r0, ClassDescriptor r1) {
        return r0.getJavaAnalogue(r1);
    }

    public static final /* synthetic */ ModuleDescriptor access$getModuleDescriptor$p(JvmBuiltInsCustomizer r0) {
        return r0.moduleDescriptor;
    }

    public static final /* synthetic */ JvmBuiltIns.Settings access$getSettings(JvmBuiltInsCustomizer r0) {
        return r0.getSettings();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.deserialization.AdditionalClassPartsProvider
    public /* bridge */ /* synthetic */ Collection getFunctionsNames(ClassDescriptor r1) {
        return getFunctionsNames(r1);
    }

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(JvmBuiltInsCustomizer.class), "settings", "getSettings()Lorg/jetbrains/kotlin/builtins/jvm/JvmBuiltIns$Settings;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(JvmBuiltInsCustomizer.class), "cloneableType", "getCloneableType()Lorg/jetbrains/kotlin/types/SimpleType;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(JvmBuiltInsCustomizer.class), "notConsideredDeprecation", "getNotConsideredDeprecation()Lorg/jetbrains/kotlin/descriptors/annotations/Annotations;"))};
    }

    private final JvmBuiltIns.Settings getSettings() {
        return (JvmBuiltIns.Settings) StorageKt.getValue(this.settings$delegate, this, $$delegatedProperties[0]);
    }

    private final SimpleType getCloneableType() {
        return (SimpleType) StorageKt.getValue(this.cloneableType$delegate, this, $$delegatedProperties[1]);
    }

    private final Annotations getNotConsideredDeprecation() {
        return (Annotations) StorageKt.getValue(this.notConsideredDeprecation$delegate, this, $$delegatedProperties[2]);
    }

    private final KotlinType createMockJavaIoSerializableType(StorageManager r13) {
        final ModuleDescriptor r0 = this.moduleDescriptor;
        final FqName r1 = new FqName("java.io");
        PackageFragmentDescriptorImpl r2 = new JvmBuiltInsCustomizer$createMockJavaIoSerializableType$mockJavaIoPackageFragment$1(r0, r1);
        List r12 = CollectionsKt.listOf(new LazyWrappedType(r13, new JvmBuiltInsCustomizer$createMockJavaIoSerializableType$superTypes$1(this)));
        ClassDescriptorImpl r3 = new ClassDescriptorImpl(r2, Name.identifier("Serializable"), Modality.ABSTRACT, ClassKind.INTERFACE, r12, SourceElement.NO_SOURCE, false, r13);
        r3.initialize(MemberScope.Empty.INSTANCE, SetsKt.emptySet(), null);
        SimpleType r14 = r3.getDefaultType();
        Intrinsics.checkNotNullExpressionValue(r14, "mockSerializableClass.defaultType");
        return r14;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.deserialization.AdditionalClassPartsProvider
    public Collection<KotlinType> getSupertypes(ClassDescriptor r3) {
        Intrinsics.checkNotNullParameter(r3, "classDescriptor");
        FqNameUnsafe r4 = DescriptorUtilsKt.getFqNameUnsafe(r3);
        if (JvmBuiltInsSignatures.INSTANCE.isArrayOrPrimitiveArray(r4) == false) goto L6;
        SimpleType r0 = getCloneableType();
        Intrinsics.checkNotNullExpressionValue(r0, "cloneableType");
        return CollectionsKt.listOf(new KotlinType[]{r0, this.mockSerializableType});
    L6:
        if (JvmBuiltInsSignatures.INSTANCE.isSerializableInJava(r4) == false) goto L9;
        return CollectionsKt.listOf(this.mockSerializableType);
    L9:
        return CollectionsKt.emptyList();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.deserialization.AdditionalClassPartsProvider
    public Collection<SimpleFunctionDescriptor> getFunctions(final Name r7, ClassDescriptor r8) {
        Intrinsics.checkNotNullParameter(r7, "name");
        Intrinsics.checkNotNullParameter(r8, "classDescriptor");
        boolean r1 = true;
        if (Intrinsics.areEqual(r7, CloneableClassScope.Companion.getCLONE_NAME()) == false) goto L24;
        if ((r8 instanceof DeserializedClassDescriptor) == false) goto L24;
        if (KotlinBuiltIns.isArrayOrPrimitiveArray(r8) == false) goto L24;
        DeserializedClassDescriptor r9 = (DeserializedClassDescriptor) r8;
        List<ProtoBuf.Function> r0 = r9.getClassProto().getFunctionList();
        Intrinsics.checkNotNullExpressionValue(r0, "classDescriptor.classProto.functionList");
        List<ProtoBuf.Function> r2 = r0;
        if ((r2 instanceof Collection) == true) goto L11;
    L13:
        Iterator<T> r3 = r2.iterator();
    L15:
        if (r3.hasNext() == false) goto L12;
        if (Intrinsics.areEqual(NameResolverUtilKt.getName(r9.getC().getNameResolver(), ((ProtoBuf.Function) r3.next()).getName()), CloneableClassScope.Companion.getCLONE_NAME()) == false) goto L15;
    L18:
        if (r1 == false) goto L22;
        return CollectionsKt.emptyList();
    L22:
        return CollectionsKt.listOf(createCloneForArray(r9, (SimpleFunctionDescriptor) CollectionsKt.single(getCloneableType().getMemberScope().getContributedFunctions(r7, NoLookupLocation.FROM_BUILTINS))));
    L12:
        r1 = false;
        goto L18
    L11:
        if (r2.isEmpty() == false) goto L13;
    L24:
        if (getSettings().isAdditionalBuiltInsFeatureSupported() == false) goto L26;
        Collection<SimpleFunctionDescriptor> r10 = getAdditionalFunctions(r8, new AnonymousClass2(r7));
        ArrayList r4 = new ArrayList();
        Iterator<T> r11 = r10.iterator();
    L29:
        if (r11.hasNext() == false) goto L46;
        SimpleFunctionDescriptor r5 = (SimpleFunctionDescriptor) r11.next();
        DeclarationDescriptor r6 = r5.getContainingDeclaration();
        Intrinsics.checkNotNull(r6, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
        FunctionDescriptor r12 = r5.substitute(MappingUtilKt.createMappedTypeParametersSubstitution((ClassDescriptor) r6, r8).buildSubstitutor());
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.SimpleFunctionDescriptor");
        FunctionDescriptor.CopyBuilder<? extends SimpleFunctionDescriptor> r13 = ((SimpleFunctionDescriptor) r12).newCopyBuilder();
        r13.setOwner(r8);
        r13.setDispatchReceiverParameter(r8.getThisAsReceiverParameter());
        r13.setPreserveSourceElement();
        int r14 = WhenMappings.$EnumSwitchMapping$0[getJdkMethodStatus(r5).ordinal()];
        SimpleFunctionDescriptor r15 = null;
        if (r14 == 1) goto L39;
        if (r14 != 2) goto L35;
        r13.setAdditionalAnnotations(getNotConsideredDeprecation());
    L42:
        FunctionDescriptor r16 = r13.build();
        Intrinsics.checkNotNull(r16);
        r15 = (SimpleFunctionDescriptor) r16;
    L43:
        if (r15 == null) goto L29;
        r4.add(r15);
        goto L29
    L35:
        if (r14 == 3) goto L43;
    L39:
        if (ModalityUtilsKt.isFinalClass(r8) == true) goto L43;
        r13.setHiddenForResolutionEverywhereBesideSupercalls();
        goto L42
    L46:
        return r4;
    L26:
        return CollectionsKt.emptyList();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.deserialization.AdditionalClassPartsProvider
    public Set<Name> getFunctionsNames(ClassDescriptor r2) {
        Intrinsics.checkNotNullParameter(r2, "classDescriptor");
        if (getSettings().isAdditionalBuiltInsFeatureSupported() == false) goto L5;
        LazyJavaClassDescriptor r1 = getJavaAnalogue(r2);
        if (r1 == null) goto L13;
        LazyJavaClassMemberScope r3 = r1.getUnsubstitutedMemberScope();
        if (r3 == null) goto L13;
        Set<Name> r4 = r3.getFunctionNames();
        if (r4 == null) goto L13;
        return r4;
    L13:
        return SetsKt.emptySet();
    L5:
        return SetsKt.emptySet();
    }

    private final Collection<SimpleFunctionDescriptor> getAdditionalFunctions(ClassDescriptor r10, Function1<? super MemberScope, ? extends Collection<? extends SimpleFunctionDescriptor>> r11) {
        final LazyJavaClassDescriptor r0 = getJavaAnalogue(r10);
        if (r0 == null) goto L5;
        LazyJavaClassDescriptor r2 = r0;
        Collection<ClassDescriptor> r1 = this.j2kClassMapper.mapPlatformClass(DescriptorUtilsKt.getFqNameSafe(r2), FallbackBuiltIns.Companion.getInstance());
        final ClassDescriptor r3 = (ClassDescriptor) CollectionsKt.lastOrNull(r1);
        if (r3 == null) goto L9;
        SmartSet.Companion r4 = SmartSet.Companion;
        ArrayList r5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r1, 10));
        Iterator<T> r6 = r1.iterator();
    L12:
        if (r6.hasNext() == false) goto L14;
        r5.add(DescriptorUtilsKt.getFqNameSafe((ClassDescriptor) r6.next()));
        goto L12
    L14:
        SmartSet r7 = r4.create(r5);
        boolean r12 = this.j2kClassMapper.isMutable(r10);
        MemberScope r8 = this.javaAnalogueClassesWithCustomSupertypeCache.computeIfAbsent(DescriptorUtilsKt.getFqNameSafe(r2), new JvmBuiltInsCustomizer$getAdditionalFunctions$fakeJavaClassDescriptor$1(r0, r3)).getUnsubstitutedMemberScope();
        Intrinsics.checkNotNullExpressionValue(r8, "fakeJavaClassDescriptor.unsubstitutedMemberScope");
        Collection<? extends SimpleFunctionDescriptor> r13 = r11.invoke(r8);
        ArrayList r9 = new ArrayList();
        Iterator<T> r14 = r13.iterator();
    L16:
        if (r14.hasNext() == false) goto L45;
        Object r15 = r14.next();
        SimpleFunctionDescriptor r16 = (SimpleFunctionDescriptor) r15;
        boolean r17 = false;
        if (r16.getKind() == CallableMemberDescriptor.Kind.DECLARATION) goto L21;
    L42:
        if (r17 == false) goto L16;
        r9.add(r15);
        goto L16
    L21:
        if (r16.getVisibility().isPublicAPI() == false) goto L42;
        if (KotlinBuiltIns.isDeprecated(r16) == true) goto L42;
        Collection<? extends FunctionDescriptor> r18 = r16.getOverriddenDescriptors();
        Intrinsics.checkNotNullExpressionValue(r18, "analogueMember.overriddenDescriptors");
        Collection<? extends FunctionDescriptor> r19 = r18;
        if ((r19 instanceof Collection) == true) goto L29;
    L31:
        Iterator<T> r20 = r19.iterator();
    L33:
        if (r20.hasNext() == false) goto L30;
        DeclarationDescriptor r21 = ((FunctionDescriptor) r20.next()).getContainingDeclaration();
        Intrinsics.checkNotNullExpressionValue(r21, "it.containingDeclaration");
        if (r7.contains(DescriptorUtilsKt.getFqNameSafe(r21)) == false) goto L33;
        boolean r22 = true;
    L37:
        if (r22 == true) goto L42;
        if (isMutabilityViolation(r16, r12) == true) goto L42;
        r17 = true;
    L30:
        r22 = false;
        goto L37
    L29:
        if (r19.isEmpty() == false) goto L31;
    L45:
        return r9;
    L9:
        return CollectionsKt.emptyList();
    L5:
        return CollectionsKt.emptyList();
    }

    private final SimpleFunctionDescriptor createCloneForArray(DeserializedClassDescriptor r1, SimpleFunctionDescriptor r2) {
        FunctionDescriptor.CopyBuilder<? extends SimpleFunctionDescriptor> r0 = r2.newCopyBuilder();
        r0.setOwner(r1);
        r0.setVisibility(DescriptorVisibilities.PUBLIC);
        r0.setReturnType(r1.getDefaultType());
        r0.setDispatchReceiverParameter(r1.getThisAsReceiverParameter());
        FunctionDescriptor r3 = r0.build();
        Intrinsics.checkNotNull(r3);
        return (SimpleFunctionDescriptor) r3;
    }

    private final boolean isMutabilityViolation(SimpleFunctionDescriptor r6, boolean r7) {
        DeclarationDescriptor r0 = r6.getContainingDeclaration();
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
        String r1 = MethodSignatureMappingKt.computeJvmDescriptor$default(r6, false, false, 3, null);
        Set<String> r2 = JvmBuiltInsSignatures.INSTANCE.getMUTABLE_METHOD_SIGNATURES();
        SignatureBuildingComponents r3 = SignatureBuildingComponents.INSTANCE;
        if ((r7 ^ r2.contains(MethodSignatureBuildingUtilsKt.signature(r3, (ClassDescriptor) r0, r1))) == false) goto L6;
        return true;
    L6:
        Boolean r5 = DFS.ifAny(CollectionsKt.listOf(r6), C04621.INSTANCE, new C04632(this));
        Intrinsics.checkNotNullExpressionValue(r5, "private fun SimpleFuncti…scriptor)\n        }\n    }");
        return r5.booleanValue();
    }

    private final JDKMemberStatus getJdkMethodStatus(FunctionDescriptor r5) {
        DeclarationDescriptor r0 = r5.getContainingDeclaration();
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
        final String r6 = MethodSignatureMappingKt.computeJvmDescriptor$default(r5, false, false, 3, null);
        final Ref.ObjectRef r1 = new Ref.ObjectRef();
        Object r4 = DFS.dfs(CollectionsKt.listOf((ClassDescriptor) r0), new AnonymousClass1(this), new C04612(r6, r1));
        Intrinsics.checkNotNullExpressionValue(r4, "private fun FunctionDesc…ERED\n            })\n    }");
        return (JDKMemberStatus) r4;
    }

    private final LazyJavaClassDescriptor getJavaAnalogue(ClassDescriptor r3) {
        if (KotlinBuiltIns.isAny(r3) == false) goto L5;
        return null;
    L5:
        ClassDescriptor r4 = r3;
        if (KotlinBuiltIns.isUnderKotlinPackage(r4) == true) goto L8;
        return null;
    L8:
        FqNameUnsafe r5 = DescriptorUtilsKt.getFqNameUnsafe(r4);
        if (r5.isSafe() == true) goto L11;
        return null;
    L11:
        ClassId r6 = JavaToKotlinClassMap.INSTANCE.mapKotlinToJava(r5);
        if (r6 == null) goto L20;
        FqName r7 = r6.asSingleFqName();
        if (r7 == null) goto L22;
        ClassDescriptor r2 = DescriptorUtilKt.resolveClassByFqName(getSettings().getOwnerModuleDescriptor(), r7, NoLookupLocation.FROM_BUILTINS);
        if ((r2 instanceof LazyJavaClassDescriptor) == true) goto L19;
        return null;
    L19:
        return (LazyJavaClassDescriptor) r2;
    L22:
        return null;
    L20:
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.deserialization.AdditionalClassPartsProvider
    public Collection<ClassConstructorDescriptor> getConstructors(ClassDescriptor r15) {
        Intrinsics.checkNotNullParameter(r15, "classDescriptor");
        if (r15.getKind() != ClassKind.CLASS) goto L51;
        if (getSettings().isAdditionalBuiltInsFeatureSupported() == false) goto L51;
        LazyJavaClassDescriptor r0 = getJavaAnalogue(r15);
        if (r0 == null) goto L10;
        ClassDescriptor r1 = JavaToKotlinClassMapper.mapJavaToKotlin$default(this.j2kClassMapper, DescriptorUtilsKt.getFqNameSafe(r0), FallbackBuiltIns.Companion.getInstance(), null, 4, null);
        if (r1 == null) goto L14;
        LazyJavaClassDescriptor r2 = r0;
        TypeSubstitutor r3 = MappingUtilKt.createMappedTypeParametersSubstitution(r1, r2).buildSubstitutor();
        List<ClassConstructorDescriptor> r4 = r0.getConstructors();
        ArrayList r5 = new ArrayList();
        Iterator<T> r6 = r4.iterator();
    L16:
        boolean r8 = false;
        if (r6.hasNext() == false) goto L41;
        Object r7 = r6.next();
        ClassConstructorDescriptor r9 = (ClassConstructorDescriptor) r7;
        if (r9.getVisibility().isPublicAPI() == false) goto L39;
        Collection<ClassConstructorDescriptor> r10 = r1.getConstructors();
        Intrinsics.checkNotNullExpressionValue(r10, "defaultKotlinVersion.constructors");
        Collection<ClassConstructorDescriptor> r11 = r10;
        if ((r11 instanceof Collection) == true) goto L23;
    L25:
        Iterator<T> r12 = r11.iterator();
    L27:
        if (r12.hasNext() == false) goto L24;
        ClassConstructorDescriptor r13 = (ClassConstructorDescriptor) r12.next();
        Intrinsics.checkNotNullExpressionValue(r13, "it");
        if (getConstructors$isEffectivelyTheSameAs(r13, r3, r9) == false) goto L27;
        boolean r14 = false;
    L31:
        if (r14 == false) goto L39;
        if (isTrivialCopyConstructorFor(r9, r15) == true) goto L39;
        if (KotlinBuiltIns.isDeprecated(r9) == true) goto L39;
        if (JvmBuiltInsSignatures.INSTANCE.getHIDDEN_CONSTRUCTOR_SIGNATURES().contains(MethodSignatureBuildingUtilsKt.signature(SignatureBuildingComponents.INSTANCE, r2, MethodSignatureMappingKt.computeJvmDescriptor$default(r9, false, false, 3, null))) == true) goto L39;
        r8 = true;
    L24:
        r14 = true;
        goto L31
    L23:
        if (r11.isEmpty() == false) goto L25;
    L39:
        if (r8 == false) goto L16;
        r5.add(r7);
        goto L16
    L41:
        ArrayList r16 = r5;
        ArrayList r17 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r16, 10));
        Iterator r18 = r16.iterator();
    L43:
        if (r18.hasNext() == false) goto L49;
        ClassConstructorDescriptor r19 = (ClassConstructorDescriptor) r18.next();
        FunctionDescriptor.CopyBuilder<? extends FunctionDescriptor> r20 = r19.newCopyBuilder();
        r20.setOwner(r15);
        r20.setReturnType(r15.getDefaultType());
        r20.setPreserveSourceElement();
        r20.setSubstitution(r3.getSubstitution());
        if (JvmBuiltInsSignatures.INSTANCE.getVISIBLE_CONSTRUCTOR_SIGNATURES().contains(MethodSignatureBuildingUtilsKt.signature(SignatureBuildingComponents.INSTANCE, r2, MethodSignatureMappingKt.computeJvmDescriptor$default(r19, false, false, 3, null))) == true) goto L47;
        r20.setAdditionalAnnotations(getNotConsideredDeprecation());
    L47:
        FunctionDescriptor r21 = r20.build();
        Intrinsics.checkNotNull(r21, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassConstructorDescriptor");
        r17.add((ClassConstructorDescriptor) r21);
        goto L43
    L49:
        return r17;
    L14:
        return CollectionsKt.emptyList();
    L10:
        return CollectionsKt.emptyList();
    L51:
        return CollectionsKt.emptyList();
    }

    private static final boolean getConstructors$isEffectivelyTheSameAs(ConstructorDescriptor r0, TypeSubstitutor r1, ConstructorDescriptor r2) {
        if (OverridingUtil.getBothWaysOverridability(r0, r2.substitute(r1)) != OverridingUtil.OverrideCompatibilityInfo.Result.OVERRIDABLE) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.deserialization.PlatformDependentDeclarationFilter
    public boolean isFunctionAvailable(ClassDescriptor r6, SimpleFunctionDescriptor r7) {
        Intrinsics.checkNotNullParameter(r6, "classDescriptor");
        Intrinsics.checkNotNullParameter(r7, "functionDescriptor");
        LazyJavaClassDescriptor r8 = getJavaAnalogue(r6);
        if (r8 != null) goto L6;
        return true;
    L6:
        if (r7.getAnnotations().hasAnnotation(PlatformDependentDeclarationFilterKt.getPLATFORM_DEPENDENT_ANNOTATION_FQ_NAME()) == true) goto L9;
        return true;
    L9:
        if (getSettings().isAdditionalBuiltInsFeatureSupported() == true) goto L11;
        return false;
    L11:
        String r5 = MethodSignatureMappingKt.computeJvmDescriptor$default(r7, false, false, 3, null);
        LazyJavaClassMemberScope r9 = r8.getUnsubstitutedMemberScope();
        Name r10 = r7.getName();
        Intrinsics.checkNotNullExpressionValue(r10, "functionDescriptor.name");
        Collection<SimpleFunctionDescriptor> r11 = r9.getContributedFunctions(r10, NoLookupLocation.FROM_BUILTINS);
        if ((r11 instanceof Collection) == true) goto L14;
    L16:
        Iterator<T> r12 = r11.iterator();
    L18:
        if (r12.hasNext() == false) goto L21;
        if (Intrinsics.areEqual(MethodSignatureMappingKt.computeJvmDescriptor$default((SimpleFunctionDescriptor) r12.next(), false, false, 3, null), r5) == false) goto L18;
        return true;
    L21:
        return false;
    L14:
        if (r11.isEmpty() == false) goto L16;
        goto L16
    }

    private final boolean isTrivialCopyConstructorFor(ConstructorDescriptor r2, ClassDescriptor r3) {
        if (r2.getValueParameters().size() != 1) goto L11;
        List<ValueParameterDescriptor> r1 = r2.getValueParameters();
        Intrinsics.checkNotNullExpressionValue(r1, "valueParameters");
        ClassifierDescriptor r4 = ((ValueParameterDescriptor) CollectionsKt.single(r1)).getType().getConstructor().mo2083getDeclarationDescriptor();
        if (r4 == null) goto L7;
        FqNameUnsafe r5 = DescriptorUtilsKt.getFqNameUnsafe(r4);
    L9:
        if (Intrinsics.areEqual(r5, DescriptorUtilsKt.getFqNameUnsafe(r3)) == false) goto L11;
        return true;
    L7:
        r5 = null;
    L11:
        return false;
    }
}
