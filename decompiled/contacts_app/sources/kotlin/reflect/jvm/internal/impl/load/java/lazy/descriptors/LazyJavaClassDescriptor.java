package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.IntIterator;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.MappingUtilKt;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses;
import kotlin.reflect.jvm.internal.impl.descriptors.ScopesHolderForClass;
import kotlin.reflect.jvm.internal.impl.descriptors.SupertypeLoopChecker;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueClassRepresentation;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibility;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassDescriptorBase;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.load.java.FakePureImplementationsProvider;
import kotlin.reflect.jvm.internal.impl.load.java.JavaDescriptorVisibilities;
import kotlin.reflect.jvm.internal.impl.load.java.JvmAnnotationNames;
import kotlin.reflect.jvm.internal.impl.load.java.UtilsKt;
import kotlin.reflect.jvm.internal.impl.load.java.components.JavaResolverCache;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaClassDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.ContextKt;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaAnnotationsKt;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeAttributes;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeAttributesKt;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifierType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaType;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.FqNamesUtilKt;
import kotlin.reflect.jvm.internal.impl.resolve.constants.StringValue;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.InnerClassesScopeWrapper;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ErrorReporter;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.types.AbstractClassTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeAttributes;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.TypeUsage;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import kotlin.reflect.jvm.internal.impl.utils.CollectionsKt;

/* JADX INFO: compiled from: LazyJavaClassDescriptor.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class LazyJavaClassDescriptor extends ClassDescriptorBase implements JavaClassDescriptor {
    public static final Companion Companion = null;
    private static final Set<String> PUBLIC_METHOD_NAMES_IN_OBJECT = null;
    private final ClassDescriptor additionalSupertypeClassDescriptor;
    private final Annotations annotations;
    private final LazyJavaResolverContext c;
    private final NotNullLazyValue<List<TypeParameterDescriptor>> declaredParameters;
    private final InnerClassesScopeWrapper innerClassesScope;
    private final boolean isInner;
    private final JavaClass jClass;
    private final ClassKind kind;
    private final Modality modality;
    private final Lazy moduleAnnotations$delegate;
    private final LazyJavaResolverContext outerContext;
    private final ScopesHolderForClass<LazyJavaClassMemberScope> scopeHolder;
    private final LazyJavaStaticClassScope staticScope;
    private final LazyJavaClassTypeConstructor typeConstructor;
    private final LazyJavaClassMemberScope unsubstitutedMemberScope;
    private final Visibility visibility;

    /* JADX INFO: compiled from: LazyJavaClassDescriptor.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: LazyJavaClassDescriptor.kt */
    private final class LazyJavaClassTypeConstructor extends AbstractClassTypeConstructor {
        private final NotNullLazyValue<List<TypeParameterDescriptor>> parameters;
        final /* synthetic */ LazyJavaClassDescriptor this$0;

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        public boolean isDenotable() {
            return true;
        }

        public LazyJavaClassTypeConstructor(final LazyJavaClassDescriptor r3) {
            this.this$0 = r3;
            super(LazyJavaClassDescriptor.access$getC$p(r3).getStorageManager());
            this.parameters = LazyJavaClassDescriptor.access$getC$p(r3).getStorageManager().createLazyValue(new LazyJavaClassDescriptor$LazyJavaClassTypeConstructor$parameters$1(r3));
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.AbstractClassTypeConstructor, kotlin.reflect.jvm.internal.impl.types.ClassifierBasedTypeConstructor, kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        /* JADX INFO: renamed from: getDeclarationDescriptor */
        public /* bridge */ /* synthetic */ ClassifierDescriptor mo2083getDeclarationDescriptor() {
            return mo2083getDeclarationDescriptor();
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        public List<TypeParameterDescriptor> getParameters() {
            return this.parameters.invoke();
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor
        protected Collection<KotlinType> computeSupertypes() {
            Collection<JavaClassifierType> r0 = this.this$0.getJClass().getSupertypes();
            ArrayList r1 = new ArrayList(r0.size());
            ArrayList r2 = new ArrayList(0);
            KotlinType r3 = getPurelyImplementedSupertype();
            Iterator<JavaClassifierType> r4 = r0.iterator();
        L3:
            Object r5 = null;
            if (r4.hasNext() == false) goto L17;
            JavaClassifierType r6 = r4.next();
            KotlinType r7 = LazyJavaClassDescriptor.access$getC$p(this.this$0).getComponents().getSignatureEnhancement().enhanceSuperType(LazyJavaClassDescriptor.access$getC$p(this.this$0).getTypeResolver().transformJavaType(r6, JavaTypeAttributesKt.toAttributes$default(TypeUsage.SUPERTYPE, false, false, null, 7, null)), LazyJavaClassDescriptor.access$getC$p(this.this$0));
            if ((r7.getConstructor().mo2083getDeclarationDescriptor() instanceof NotFoundClasses.MockClassDescriptor) == false) goto L8;
            r2.add(r6);
        L8:
            TypeConstructor r8 = r7.getConstructor();
            if (r3 == null) goto L12;
            r5 = r3.getConstructor();
        L12:
            if (Intrinsics.areEqual(r8, r5) == true) goto L3;
            if (KotlinBuiltIns.isAnyOrNullableAny(r7) == true) goto L3;
            r1.add(r7);
            goto L3
        L17:
            ArrayList r9 = r1;
            ClassDescriptor r10 = LazyJavaClassDescriptor.access$getAdditionalSupertypeClassDescriptor$p(this.this$0);
            if (r10 == null) goto L20;
            r5 = MappingUtilKt.createMappedTypeParametersSubstitution(r10, this.this$0).buildSubstitutor().substitute(r10.getDefaultType(), Variance.INVARIANT);
        L20:
            CollectionsKt.addIfNotNull(r9, r5);
            CollectionsKt.addIfNotNull(r9, r3);
            if ((!r2.isEmpty()) == false) goto L28;
            ErrorReporter r11 = LazyJavaClassDescriptor.access$getC$p(this.this$0).getComponents().getErrorReporter();
            ClassDescriptor r12 = mo2083getDeclarationDescriptor();
            ArrayList r13 = r2;
            ArrayList r14 = new ArrayList(kotlin.collections.CollectionsKt.collectionSizeOrDefault(r13, 10));
            Iterator r15 = r13.iterator();
        L24:
            if (r15.hasNext() == false) goto L26;
            JavaType r16 = (JavaType) r15.next();
            Intrinsics.checkNotNull(r16, "null cannot be cast to non-null type org.jetbrains.kotlin.load.java.structure.JavaClassifierType");
            r14.add(((JavaClassifierType) r16).getPresentableText());
            goto L24
        L26:
            r11.reportIncompleteHierarchy(r12, r14);
        L28:
            if ((!r9.isEmpty()) == false) goto L30;
            List r17 = kotlin.collections.CollectionsKt.toList(r1);
        L32:
            return r17;
        L30:
            r17 = kotlin.collections.CollectionsKt.listOf(LazyJavaClassDescriptor.access$getC$p(this.this$0).getModule().getBuiltIns().getAnyType());
            goto L32
        }

        private final KotlinType getPurelyImplementedSupertype() {
            FqName r0 = getPurelyImplementsFqNameFromAnnotation();
            if (r0 != null) goto L5;
        L12:
            r0 = null;
        L13:
            if (r0 != null) goto L17;
            FqName r3 = FakePureImplementationsProvider.INSTANCE.getPurelyImplementedInterface(DescriptorUtilsKt.getFqNameSafe(this.this$0));
            if (r3 != null) goto L18;
            return null;
        L18:
            ClassDescriptor r4 = DescriptorUtilsKt.resolveTopLevelClass(LazyJavaClassDescriptor.access$getC$p(this.this$0).getModule(), r3, NoLookupLocation.FROM_JAVA_LOADER);
            if (r4 != null) goto L21;
            return null;
        L21:
            int r5 = r4.getTypeConstructor().getParameters().size();
            List<TypeParameterDescriptor> r7 = this.this$0.getTypeConstructor().getParameters();
            Intrinsics.checkNotNullExpressionValue(r7, "getTypeConstructor().parameters");
            int r6 = r7.size();
            if (r6 != r5) goto L28;
            List<TypeParameterDescriptor> r8 = r7;
            ArrayList r1 = new ArrayList(kotlin.collections.CollectionsKt.collectionSizeOrDefault(r8, 10));
            Iterator<T> r9 = r8.iterator();
        L25:
            if (r9.hasNext() == false) goto L27;
            r1.add(new TypeProjectionImpl(Variance.INVARIANT, ((TypeParameterDescriptor) r9.next()).getDefaultType()));
            goto L25
        L27:
            ArrayList r2 = r1;
        L37:
            return KotlinTypeFactory.simpleNotNullType(TypeAttributes.Companion.getEmpty(), r4, r2);
        L28:
            if (r6 != 1) goto L38;
            if (r5 <= 1) goto L38;
            if (r0 != null) goto L38;
            TypeProjectionImpl r10 = new TypeProjectionImpl(Variance.INVARIANT, ((TypeParameterDescriptor) kotlin.collections.CollectionsKt.single(r7)).getDefaultType());
            IntRange r11 = new IntRange(1, r5);
            ArrayList r12 = new ArrayList(kotlin.collections.CollectionsKt.collectionSizeOrDefault(r11, 10));
            Iterator<Integer> r13 = r11.iterator();
        L33:
            if (r13.hasNext() == false) goto L35;
            ((IntIterator) r13).nextInt();
            r12.add(r10);
            goto L33
        L35:
            r2 = r12;
        L38:
            return null;
        L17:
            r3 = r0;
            goto L18
        L5:
            if (r0.isRoot() == false) goto L7;
        L9:
            boolean r14 = false;
        L10:
            if (r14 == false) goto L12;
        L7:
            if (r0.startsWith(StandardNames.BUILT_INS_PACKAGE_NAME) == false) goto L9;
            r14 = true;
            goto L10
        }

        private final FqName getPurelyImplementsFqNameFromAnnotation() {
            Annotations r2 = this.this$0.getAnnotations();
            FqName r0 = JvmAnnotationNames.PURELY_IMPLEMENTS_ANNOTATION;
            Intrinsics.checkNotNullExpressionValue(r0, "PURELY_IMPLEMENTS_ANNOTATION");
            AnnotationDescriptor r3 = r2.mo2078findAnnotation(r0);
            if (r3 != null) goto L5;
            return null;
        L5:
            Object r4 = kotlin.collections.CollectionsKt.singleOrNull(r3.getAllValueArguments().values());
            if ((r4 instanceof StringValue) == false) goto L8;
            StringValue r5 = (StringValue) r4;
        L9:
            if (r5 == null) goto L18;
            String r6 = r5.getValue();
            if (r6 != null) goto L14;
            return null;
        L14:
            if (FqNamesUtilKt.isValidJavaFqName(r6) == true) goto L17;
            return null;
        L17:
            return new FqName(r6);
        L18:
            return null;
        L8:
            r5 = null;
            goto L9
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor
        protected SupertypeLoopChecker getSupertypeLoopChecker() {
            return LazyJavaClassDescriptor.access$getC$p(this.this$0).getComponents().getSupertypeLoopChecker();
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.AbstractClassTypeConstructor, kotlin.reflect.jvm.internal.impl.types.ClassifierBasedTypeConstructor, kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        /* JADX INFO: renamed from: getDeclarationDescriptor */
        public ClassDescriptor mo2083getDeclarationDescriptor() {
            return this.this$0;
        }

        public String toString() {
            String r1 = this.this$0.getName().asString();
            Intrinsics.checkNotNullExpressionValue(r1, "name.asString()");
            return r1;
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    /* JADX INFO: renamed from: getCompanionObjectDescriptor */
    public ClassDescriptor mo2076getCompanionObjectDescriptor() {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    /* JADX INFO: renamed from: getUnsubstitutedPrimaryConstructor */
    public ClassConstructorDescriptor mo2077getUnsubstitutedPrimaryConstructor() {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public ValueClassRepresentation<SimpleType> getValueClassRepresentation() {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public boolean isActual() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public boolean isCompanionObject() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public boolean isData() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public boolean isExpect() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public boolean isFun() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public boolean isInline() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public boolean isValue() {
        return false;
    }

    public /* synthetic */ LazyJavaClassDescriptor(LazyJavaResolverContext r1, DeclarationDescriptor r2, JavaClass r3, ClassDescriptor r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 8) == 0) goto L5;
        r4 = null;
    L5:
        this(r1, r2, r3, r4);
    }

    public static final /* synthetic */ ClassDescriptor access$getAdditionalSupertypeClassDescriptor$p(LazyJavaClassDescriptor r0) {
        return r0.additionalSupertypeClassDescriptor;
    }

    public static final /* synthetic */ LazyJavaResolverContext access$getC$p(LazyJavaClassDescriptor r0) {
        return r0.c;
    }

    public static final /* synthetic */ LazyJavaClassMemberScope access$getUnsubstitutedMemberScope$p(LazyJavaClassDescriptor r0) {
        return r0.unsubstitutedMemberScope;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public /* bridge */ /* synthetic */ Collection getConstructors() {
        return getConstructors();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractClassDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public /* bridge */ /* synthetic */ MemberScope getUnsubstitutedMemberScope() {
        return getUnsubstitutedMemberScope();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleAwareClassDescriptor
    public /* bridge */ /* synthetic */ MemberScope getUnsubstitutedMemberScope(KotlinTypeRefiner r1) {
        return getUnsubstitutedMemberScope(r1);
    }

    public final LazyJavaResolverContext getOuterContext() {
        return this.outerContext;
    }

    public final JavaClass getJClass() {
        return this.jClass;
    }

    public LazyJavaClassDescriptor(LazyJavaResolverContext r17, DeclarationDescriptor r18, JavaClass r19, ClassDescriptor r20) {
        Intrinsics.checkNotNullParameter(r17, "outerContext");
        Intrinsics.checkNotNullParameter(r18, "containingDeclaration");
        Intrinsics.checkNotNullParameter(r19, "jClass");
        super(r17.getStorageManager(), r18, r19.getName(), r17.getComponents().getSourceElementFactory().source(r19), false);
        this.outerContext = r17;
        this.jClass = r19;
        this.additionalSupertypeClassDescriptor = r20;
        LazyJavaResolverContext r0 = ContextKt.childForClassOrPackage$default(r17, this, r19, 0, 4, null);
        this.c = r0;
        LazyJavaClassDescriptor r2 = this;
        r0.getComponents().getJavaResolverCache().recordClass(r19, r2);
        r19.getLightClassOriginKind();
        this.moduleAnnotations$delegate = LazyKt.lazy(new LazyJavaClassDescriptor$moduleAnnotations$2(this));
        if (r19.isAnnotationType() == false) goto L6;
        ClassKind r1 = ClassKind.ANNOTATION_CLASS;
    L12:
        this.kind = r1;
        if (r19.isAnnotationType() == false) goto L15;
    L27:
        Modality r3 = Modality.FINAL;
    L28:
        this.modality = r3;
        this.visibility = r19.getVisibility();
        if (r19.getOuterClass() != null) goto L31;
    L33:
        boolean r4 = false;
    L34:
        this.isInner = r4;
        this.typeConstructor = new LazyJavaClassTypeConstructor(this);
        if (r20 == null) goto L37;
        boolean r11 = true;
    L38:
        LazyJavaClassMemberScope r5 = new LazyJavaClassMemberScope(r0, r2, r19, r11, null, 16, null);
        this.unsubstitutedMemberScope = r5;
        this.scopeHolder = ScopesHolderForClass.Companion.create(r2, r0.getStorageManager(), r0.getComponents().getKotlinTypeChecker().getKotlinTypeRefiner(), new LazyJavaClassDescriptor$scopeHolder$1(this));
        this.innerClassesScope = new InnerClassesScopeWrapper(r5);
        this.staticScope = new LazyJavaStaticClassScope(r0, r19, this);
        this.annotations = LazyJavaAnnotationsKt.resolveAnnotations(r0, r19);
        this.declaredParameters = r0.getStorageManager().createLazyValue(new LazyJavaClassDescriptor$declaredParameters$1(this));
        return;
    L37:
        r11 = false;
        goto L38
    L31:
        if (r19.isStatic() == true) goto L33;
        r4 = true;
        goto L34
    L15:
        if (r19.isEnum() == true) goto L27;
        Modality.Companion r6 = Modality.Companion;
        boolean r7 = r19.isSealed();
        if (r19.isSealed() == false) goto L20;
    L25:
        boolean r8 = true;
    L26:
        r3 = r6.convertFromFlags(r7, r8, !r19.isFinal());
        goto L28
    L20:
        if (r19.isAbstract() == true) goto L25;
        if (r19.isInterface() == true) goto L25;
        r8 = false;
        goto L26
    L6:
        if (r19.isInterface() == false) goto L9;
        r1 = ClassKind.INTERFACE;
        goto L12
    L9:
        if (r19.isEnum() == false) goto L11;
        r1 = ClassKind.ENUM_CLASS;
        goto L12
    L11:
        r1 = ClassKind.CLASS;
        goto L12
    }

    static {
        Companion = new Companion(null);
        PUBLIC_METHOD_NAMES_IN_OBJECT = SetsKt.setOf(new String[]{"equals", "hashCode", "getClass", "wait", "notify", "notifyAll", "toString"});
    }

    public final List<JavaAnnotation> getModuleAnnotations() {
        return (List) this.moduleAnnotations$delegate.getValue();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public ClassKind getKind() {
        return this.kind;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public Modality getModality() {
        return this.modality;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithVisibility, kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public DescriptorVisibility getVisibility() {
        if (Intrinsics.areEqual(this.visibility, DescriptorVisibilities.PRIVATE) == false) goto L8;
        if (this.jClass.getOuterClass() != null) goto L8;
        DescriptorVisibility r2 = JavaDescriptorVisibilities.PACKAGE_VISIBILITY;
        Intrinsics.checkNotNullExpressionValue(r2, "{\n            JavaDescri…KAGE_VISIBILITY\n        }");
        return r2;
    L8:
        return UtilsKt.toDescriptorVisibility(this.visibility);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters
    public boolean isInner() {
        return this.isInner;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor
    public TypeConstructor getTypeConstructor() {
        return this.typeConstructor;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleAwareClassDescriptor
    protected LazyJavaClassMemberScope getUnsubstitutedMemberScope(KotlinTypeRefiner r2) {
        Intrinsics.checkNotNullParameter(r2, "kotlinTypeRefiner");
        return (LazyJavaClassMemberScope) this.scopeHolder.getScope(r2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractClassDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public MemberScope getUnsubstitutedInnerClassesScope() {
        return this.innerClassesScope;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public MemberScope getStaticScope() {
        return this.staticScope;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractClassDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public LazyJavaClassMemberScope getUnsubstitutedMemberScope() {
        MemberScope r1 = super.getUnsubstitutedMemberScope();
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type org.jetbrains.kotlin.load.java.lazy.descriptors.LazyJavaClassMemberScope");
        return (LazyJavaClassMemberScope) r1;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public List<ClassConstructorDescriptor> getConstructors() {
        return this.unsubstitutedMemberScope.getConstructors$descriptors_jvm().invoke();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated
    public Annotations getAnnotations() {
        return this.annotations;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters
    public List<TypeParameterDescriptor> getDeclaredTypeParameters() {
        return this.declaredParameters.invoke();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public Collection<ClassDescriptor> getSealedSubclasses() {
        if (this.modality != Modality.SEALED) goto L15;
        JavaTypeAttributes r0 = JavaTypeAttributesKt.toAttributes$default(TypeUsage.COMMON, false, false, null, 7, null);
        Collection<JavaClassifierType> r1 = this.jClass.getPermittedTypes();
        ArrayList r2 = new ArrayList();
        Iterator<T> r3 = r1.iterator();
    L6:
        if (r3.hasNext() == false) goto L21;
        JavaClassifierType r4 = (JavaClassifierType) r3.next();
        ClassifierDescriptor r5 = this.c.getTypeResolver().transformJavaType(r4, r0).getConstructor().mo2083getDeclarationDescriptor();
        if ((r5 instanceof ClassDescriptor) == false) goto L10;
        ClassDescriptor r6 = (ClassDescriptor) r5;
    L11:
        if (r6 == null) goto L6;
        r2.add(r6);
        goto L6
    L10:
        r6 = null;
        goto L11
    L21:
        return kotlin.collections.CollectionsKt.sortedWith(r2, new LazyJavaClassDescriptor$getSealedSubclasses$$inlined$sortedBy$1());
    L15:
        return kotlin.collections.CollectionsKt.emptyList();
    }

    public String toString() {
        return "Lazy Java class " + DescriptorUtilsKt.getFqNameUnsafe(this);
    }

    public final LazyJavaClassDescriptor copy$descriptors_jvm(JavaResolverCache r4, ClassDescriptor r5) {
        Intrinsics.checkNotNullParameter(r4, "javaResolverCache");
        LazyJavaResolverContext r1 = this.c;
        LazyJavaResolverContext r6 = ContextKt.replaceComponents(r1, r1.getComponents().replace(r4));
        DeclarationDescriptor r2 = getContainingDeclaration();
        Intrinsics.checkNotNullExpressionValue(r2, "containingDeclaration");
        return new LazyJavaClassDescriptor(r6, r2, this.jClass, r5);
    }
}
