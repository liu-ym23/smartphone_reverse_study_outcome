package kotlin.reflect.jvm.internal.impl.builtins.functions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.FindClassInModuleKt;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.SupertypeLoopChecker;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueClassRepresentation;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.TypeParameterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.AbstractClassTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeAttributes;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;

/* JADX INFO: compiled from: FunctionClassDescriptor.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class FunctionClassDescriptor extends AbstractClassDescriptor {
    public static final Companion Companion = null;
    private static final ClassId functionClassId = null;
    private static final ClassId kFunctionClassId = null;
    private final int arity;
    private final PackageFragmentDescriptor containingDeclaration;
    private final FunctionClassKind functionKind;
    private final FunctionClassScope memberScope;
    private final List<TypeParameterDescriptor> parameters;
    private final StorageManager storageManager;
    private final FunctionTypeConstructor typeConstructor;

    /* JADX INFO: compiled from: FunctionClassDescriptor.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: FunctionClassDescriptor.kt */
    private final class FunctionTypeConstructor extends AbstractClassTypeConstructor {
        final /* synthetic */ FunctionClassDescriptor this$0;

        /* JADX INFO: compiled from: FunctionClassDescriptor.kt */
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

            static {
                int[] r0 = new int[FunctionClassKind.values().length];
                r0[FunctionClassKind.Function.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
            L13:
                r0[FunctionClassKind.KFunction.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
            L19:
                r0[FunctionClassKind.SuspendFunction.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
            L15:
                r0[FunctionClassKind.KSuspendFunction.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
            L7:
                $EnumSwitchMapping$0 = r0;
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        public boolean isDenotable() {
            return true;
        }

        public FunctionTypeConstructor(FunctionClassDescriptor r1) {
            this.this$0 = r1;
            super(FunctionClassDescriptor.access$getStorageManager$p(r1));
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.AbstractClassTypeConstructor, kotlin.reflect.jvm.internal.impl.types.ClassifierBasedTypeConstructor, kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        /* JADX INFO: renamed from: getDeclarationDescriptor */
        public /* bridge */ /* synthetic */ ClassDescriptor mo2083getDeclarationDescriptor() {
            return mo2083getDeclarationDescriptor();
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.AbstractClassTypeConstructor, kotlin.reflect.jvm.internal.impl.types.ClassifierBasedTypeConstructor, kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        /* JADX INFO: renamed from: getDeclarationDescriptor */
        public /* bridge */ /* synthetic */ ClassifierDescriptor mo2083getDeclarationDescriptor() {
            return mo2083getDeclarationDescriptor();
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor
        protected Collection<KotlinType> computeSupertypes() {
            int r0 = WhenMappings.$EnumSwitchMapping$0[this.this$0.getFunctionKind().ordinal()];
            if (r0 != 1) goto L5;
            List r1 = CollectionsKt.listOf(FunctionClassDescriptor.access$getFunctionClassId$cp());
        L16:
            ModuleDescriptor r2 = FunctionClassDescriptor.access$getContainingDeclaration$p(this.this$0).getContainingDeclaration();
            List r3 = r1;
            ArrayList r4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r3, 10));
            Iterator r5 = r3.iterator();
        L18:
            if (r5.hasNext() == false) goto L29;
            ClassId r6 = (ClassId) r5.next();
            ClassDescriptor r7 = FindClassInModuleKt.findClassAcrossModuleDependencies(r2, r6);
            if (r7 == null) goto L27;
            List r8 = CollectionsKt.takeLast(getParameters(), r7.getTypeConstructor().getParameters().size());
            ArrayList r9 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r8, 10));
            Iterator r10 = r8.iterator();
        L23:
            if (r10.hasNext() == false) goto L25;
            r9.add(new TypeProjectionImpl(((TypeParameterDescriptor) r10.next()).getDefaultType()));
            goto L23
        L25:
            r4.add(KotlinTypeFactory.simpleNotNullType(TypeAttributes.Companion.getEmpty(), r7, r9));
            goto L18
        L27:
            throw new IllegalStateException(("Built-in class " + r6 + " not found").toString());
        L29:
            return CollectionsKt.toList(r4);
        L5:
            if (r0 != 2) goto L7;
            r1 = CollectionsKt.listOf(new ClassId[]{FunctionClassDescriptor.access$getKFunctionClassId$cp(), new ClassId(StandardNames.BUILT_INS_PACKAGE_FQ_NAME, FunctionClassKind.Function.numberedClassName(this.this$0.getArity()))});
            goto L16
        L7:
            if (r0 != 3) goto L9;
            r1 = CollectionsKt.listOf(FunctionClassDescriptor.access$getFunctionClassId$cp());
            goto L16
        L9:
            if (r0 != 4) goto L12;
            r1 = CollectionsKt.listOf(new ClassId[]{FunctionClassDescriptor.access$getKFunctionClassId$cp(), new ClassId(StandardNames.COROUTINES_PACKAGE_FQ_NAME, FunctionClassKind.SuspendFunction.numberedClassName(this.this$0.getArity()))});
            goto L16
        L12:
            throw new NoWhenBranchMatchedException();
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        public List<TypeParameterDescriptor> getParameters() {
            return FunctionClassDescriptor.access$getParameters$p(this.this$0);
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.AbstractClassTypeConstructor, kotlin.reflect.jvm.internal.impl.types.ClassifierBasedTypeConstructor, kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        /* JADX INFO: renamed from: getDeclarationDescriptor */
        public FunctionClassDescriptor mo2083getDeclarationDescriptor() {
            return this.this$0;
        }

        public String toString() {
            return mo2083getDeclarationDescriptor().toString();
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor
        protected SupertypeLoopChecker getSupertypeLoopChecker() {
            return SupertypeLoopChecker.EMPTY.INSTANCE;
        }
    }

    public Void getCompanionObjectDescriptor() {
        return null;
    }

    public Void getUnsubstitutedPrimaryConstructor() {
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

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public boolean isExternal() {
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

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters
    public boolean isInner() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public boolean isValue() {
        return false;
    }

    public static final /* synthetic */ PackageFragmentDescriptor access$getContainingDeclaration$p(FunctionClassDescriptor r0) {
        return r0.containingDeclaration;
    }

    public static final /* synthetic */ ClassId access$getFunctionClassId$cp() {
        return functionClassId;
    }

    public static final /* synthetic */ ClassId access$getKFunctionClassId$cp() {
        return kFunctionClassId;
    }

    public static final /* synthetic */ List access$getParameters$p(FunctionClassDescriptor r0) {
        return r0.parameters;
    }

    public static final /* synthetic */ StorageManager access$getStorageManager$p(FunctionClassDescriptor r0) {
        return r0.storageManager;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    /* JADX INFO: renamed from: getCompanionObjectDescriptor, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ ClassDescriptor mo2076getCompanionObjectDescriptor() {
        return (ClassDescriptor) getCompanionObjectDescriptor();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public /* bridge */ /* synthetic */ Collection getConstructors() {
        return getConstructors();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorNonRoot, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public /* bridge */ /* synthetic */ DeclarationDescriptor getContainingDeclaration() {
        return getContainingDeclaration();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public /* bridge */ /* synthetic */ Collection getSealedSubclasses() {
        return getSealedSubclasses();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public /* bridge */ /* synthetic */ MemberScope getStaticScope() {
        return getStaticScope();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleAwareClassDescriptor
    public /* bridge */ /* synthetic */ MemberScope getUnsubstitutedMemberScope(KotlinTypeRefiner r1) {
        return getUnsubstitutedMemberScope(r1);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    /* JADX INFO: renamed from: getUnsubstitutedPrimaryConstructor, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ ClassConstructorDescriptor mo2077getUnsubstitutedPrimaryConstructor() {
        return (ClassConstructorDescriptor) getUnsubstitutedPrimaryConstructor();
    }

    public final FunctionClassKind getFunctionKind() {
        return this.functionKind;
    }

    public final int getArity() {
        return this.arity;
    }

    public FunctionClassDescriptor(StorageManager r4, PackageFragmentDescriptor r5, FunctionClassKind r6, int r7) {
        Intrinsics.checkNotNullParameter(r4, "storageManager");
        Intrinsics.checkNotNullParameter(r5, "containingDeclaration");
        Intrinsics.checkNotNullParameter(r6, "functionKind");
        super(r4, r6.numberedClassName(r7));
        this.storageManager = r4;
        this.containingDeclaration = r5;
        this.functionKind = r6;
        this.arity = r7;
        this.typeConstructor = new FunctionTypeConstructor(this);
        this.memberScope = new FunctionClassScope(r4, this);
        ArrayList r8 = new ArrayList();
        IntRange r9 = new IntRange(1, r7);
        ArrayList r10 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r9, 10));
        Iterator<Integer> r11 = r9.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        _init_$typeParameter(r8, this, Variance.IN_VARIANCE, "P" + ((IntIterator) r11).nextInt());
        r10.add(Unit.INSTANCE);
        goto L4
    L6:
        _init_$typeParameter(r8, this, Variance.OUT_VARIANCE, "R");
        this.parameters = CollectionsKt.toList(r8);
    }

    private static final void _init_$typeParameter(ArrayList<TypeParameterDescriptor> r7, FunctionClassDescriptor r8, Variance r9, String r10) {
        r7.add(TypeParameterDescriptorImpl.createWithDefaultBound(r8, Annotations.Companion.getEMPTY(), false, r9, Name.identifier(r10), r7.size(), r8.storageManager));
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorNonRoot, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public PackageFragmentDescriptor getContainingDeclaration() {
        return this.containingDeclaration;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public MemberScope.Empty getStaticScope() {
        return MemberScope.Empty.INSTANCE;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor
    public TypeConstructor getTypeConstructor() {
        return this.typeConstructor;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleAwareClassDescriptor
    protected FunctionClassScope getUnsubstitutedMemberScope(KotlinTypeRefiner r2) {
        Intrinsics.checkNotNullParameter(r2, "kotlinTypeRefiner");
        return this.memberScope;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public List<ClassConstructorDescriptor> getConstructors() {
        return CollectionsKt.emptyList();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public ClassKind getKind() {
        return ClassKind.INTERFACE;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public Modality getModality() {
        return Modality.ABSTRACT;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithVisibility, kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public DescriptorVisibility getVisibility() {
        DescriptorVisibility r1 = DescriptorVisibilities.PUBLIC;
        Intrinsics.checkNotNullExpressionValue(r1, "PUBLIC");
        return r1;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated
    public Annotations getAnnotations() {
        return Annotations.Companion.getEMPTY();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithSource
    public SourceElement getSource() {
        SourceElement r1 = SourceElement.NO_SOURCE;
        Intrinsics.checkNotNullExpressionValue(r1, "NO_SOURCE");
        return r1;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public List<ClassDescriptor> getSealedSubclasses() {
        return CollectionsKt.emptyList();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters
    public List<TypeParameterDescriptor> getDeclaredTypeParameters() {
        return this.parameters;
    }

    public String toString() {
        String r1 = getName().asString();
        Intrinsics.checkNotNullExpressionValue(r1, "name.asString()");
        return r1;
    }

    static {
        Companion = new Companion(null);
        functionClassId = new ClassId(StandardNames.BUILT_INS_PACKAGE_FQ_NAME, Name.identifier("Function"));
        kFunctionClassId = new ClassId(StandardNames.KOTLIN_REFLECT_FQ_NAME, Name.identifier("KFunction"));
    }
}
