package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import com.bytedance.apm.battery.config.BatteryTypeInf;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyGetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassConstructorDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassDescriptorBase;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyGetterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertySetterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.SimpleFunctionDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ValueParameterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.load.java.BuiltinMethodsWithDifferentJvmName;
import kotlin.reflect.jvm.internal.impl.load.java.BuiltinMethodsWithSpecialGenericSignature;
import kotlin.reflect.jvm.internal.impl.load.java.ClassicBuiltinSpecialProperties;
import kotlin.reflect.jvm.internal.impl.load.java.JavaDescriptorVisibilities;
import kotlin.reflect.jvm.internal.impl.load.java.JavaIncompatibilityRulesOverridabilityCondition;
import kotlin.reflect.jvm.internal.impl.load.java.JvmAbi;
import kotlin.reflect.jvm.internal.impl.load.java.JvmAnnotationNames;
import kotlin.reflect.jvm.internal.impl.load.java.PropertiesConventionUtilKt;
import kotlin.reflect.jvm.internal.impl.load.java.SpecialBuiltinMembers;
import kotlin.reflect.jvm.internal.impl.load.java.SpecialGenericSignatures;
import kotlin.reflect.jvm.internal.impl.load.java.UtilsKt;
import kotlin.reflect.jvm.internal.impl.load.java.components.DescriptorResolverUtils;
import kotlin.reflect.jvm.internal.impl.load.java.components.SignaturePropagator;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaForKotlinOverridePropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaMethodDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaPropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.UtilKt;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.ContextKt;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaAnnotationsKt;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeAttributes;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeAttributesKt;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaArrayType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaConstructor;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaField;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMethod;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaRecordComponent;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameter;
import kotlin.reflect.jvm.internal.impl.load.kotlin.MethodSignatureMappingKt;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorFactory;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ErrorReporter;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNullable;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeUsage;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker;
import kotlin.reflect.jvm.internal.impl.utils.SmartSet;

/* JADX INFO: compiled from: LazyJavaClassMemberScope.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class LazyJavaClassMemberScope extends LazyJavaScope {
    private final NotNullLazyValue<List<ClassConstructorDescriptor>> constructors;
    private final NotNullLazyValue<Map<Name, JavaField>> enumEntryIndex;
    private final JavaClass jClass;
    private final NotNullLazyValue<Set<Name>> nestedClassIndex;
    private final MemoizedFunctionToNullable<Name, ClassDescriptorBase> nestedClasses;
    private final ClassDescriptor ownerDescriptor;
    private final boolean skipRefinement;

    /* JADX INFO: renamed from: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope$computeNonDeclaredFunctions$3, reason: invalid class name */
    /* JADX INFO: compiled from: LazyJavaClassMemberScope.kt */
    /* synthetic */ class AnonymousClass3 extends FunctionReference implements Function1<Name, Collection<? extends SimpleFunctionDescriptor>> {
        AnonymousClass3(Object r2) {
            super(1, r2);
        }

        @Override // kotlin.jvm.internal.CallableReference, kotlin.reflect.KCallable
        public final String getName() {
            return "searchMethodsByNameWithoutBuiltinMagic";
        }

        @Override // kotlin.jvm.internal.CallableReference
        public final String getSignature() {
            return "searchMethodsByNameWithoutBuiltinMagic(Lorg/jetbrains/kotlin/name/Name;)Ljava/util/Collection;";
        }

        @Override // kotlin.jvm.internal.CallableReference
        public final KDeclarationContainer getOwner() {
            return Reflection.getOrCreateKotlinClass(LazyJavaClassMemberScope.class);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Collection<? extends SimpleFunctionDescriptor> invoke(Name r1) {
            return invoke2(r1);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Collection<SimpleFunctionDescriptor> invoke2(Name r2) {
            Intrinsics.checkNotNullParameter(r2, "p0");
            return LazyJavaClassMemberScope.access$searchMethodsByNameWithoutBuiltinMagic((LazyJavaClassMemberScope) this.receiver, r2);
        }
    }

    /* JADX INFO: renamed from: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope$computeNonDeclaredFunctions$4, reason: invalid class name */
    /* JADX INFO: compiled from: LazyJavaClassMemberScope.kt */
    /* synthetic */ class AnonymousClass4 extends FunctionReference implements Function1<Name, Collection<? extends SimpleFunctionDescriptor>> {
        AnonymousClass4(Object r2) {
            super(1, r2);
        }

        @Override // kotlin.jvm.internal.CallableReference, kotlin.reflect.KCallable
        public final String getName() {
            return "searchMethodsInSupertypesWithoutBuiltinMagic";
        }

        @Override // kotlin.jvm.internal.CallableReference
        public final String getSignature() {
            return "searchMethodsInSupertypesWithoutBuiltinMagic(Lorg/jetbrains/kotlin/name/Name;)Ljava/util/Collection;";
        }

        @Override // kotlin.jvm.internal.CallableReference
        public final KDeclarationContainer getOwner() {
            return Reflection.getOrCreateKotlinClass(LazyJavaClassMemberScope.class);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Collection<? extends SimpleFunctionDescriptor> invoke(Name r1) {
            return invoke2(r1);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Collection<SimpleFunctionDescriptor> invoke2(Name r2) {
            Intrinsics.checkNotNullParameter(r2, "p0");
            return LazyJavaClassMemberScope.access$searchMethodsInSupertypesWithoutBuiltinMagic((LazyJavaClassMemberScope) this.receiver, r2);
        }
    }

    public /* synthetic */ LazyJavaClassMemberScope(LazyJavaResolverContext r7, ClassDescriptor r8, JavaClass r9, boolean r10, LazyJavaClassMemberScope r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 16) == 0) goto L5;
        r11 = null;
    L5:
        this(r7, r8, r9, r10, r11);
    }

    public static final /* synthetic */ ClassConstructorDescriptor access$createDefaultConstructor(LazyJavaClassMemberScope r0) {
        return r0.createDefaultConstructor();
    }

    public static final /* synthetic */ ClassConstructorDescriptor access$createDefaultRecordConstructor(LazyJavaClassMemberScope r0) {
        return r0.createDefaultRecordConstructor();
    }

    public static final /* synthetic */ NotNullLazyValue access$getEnumEntryIndex$p(LazyJavaClassMemberScope r0) {
        return r0.enumEntryIndex;
    }

    public static final /* synthetic */ JavaClass access$getJClass$p(LazyJavaClassMemberScope r0) {
        return r0.jClass;
    }

    public static final /* synthetic */ NotNullLazyValue access$getNestedClassIndex$p(LazyJavaClassMemberScope r0) {
        return r0.nestedClassIndex;
    }

    public static final /* synthetic */ JavaClassConstructorDescriptor access$resolveConstructor(LazyJavaClassMemberScope r0, JavaConstructor r1) {
        return r0.resolveConstructor(r1);
    }

    public static final /* synthetic */ Collection access$searchMethodsByNameWithoutBuiltinMagic(LazyJavaClassMemberScope r0, Name r1) {
        return r0.searchMethodsByNameWithoutBuiltinMagic(r1);
    }

    public static final /* synthetic */ Collection access$searchMethodsInSupertypesWithoutBuiltinMagic(LazyJavaClassMemberScope r0, Name r1) {
        return r0.searchMethodsInSupertypesWithoutBuiltinMagic(r1);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    public /* bridge */ /* synthetic */ Set computeFunctionNames(DescriptorKindFilter r1, Function1 r2) {
        return computeFunctionNames(r1, r2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    public /* bridge */ /* synthetic */ DeclaredMemberIndex computeMemberIndex() {
        return computeMemberIndex();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    public /* bridge */ /* synthetic */ DeclarationDescriptor getOwnerDescriptor() {
        return getOwnerDescriptor();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    protected ClassDescriptor getOwnerDescriptor() {
        return this.ownerDescriptor;
    }

    public LazyJavaClassMemberScope(final LazyJavaResolverContext r2, ClassDescriptor r3, JavaClass r4, boolean r5, LazyJavaClassMemberScope r6) {
        Intrinsics.checkNotNullParameter(r2, "c");
        Intrinsics.checkNotNullParameter(r3, "ownerDescriptor");
        Intrinsics.checkNotNullParameter(r4, "jClass");
        super(r2, r6);
        this.ownerDescriptor = r3;
        this.jClass = r4;
        this.skipRefinement = r5;
        this.constructors = r2.getStorageManager().createLazyValue(new LazyJavaClassMemberScope$constructors$1(this, r2));
        this.nestedClassIndex = r2.getStorageManager().createLazyValue(new LazyJavaClassMemberScope$nestedClassIndex$1(this));
        this.enumEntryIndex = r2.getStorageManager().createLazyValue(new LazyJavaClassMemberScope$enumEntryIndex$1(this));
        this.nestedClasses = r2.getStorageManager().createMemoizedFunctionWithNullableValues(new LazyJavaClassMemberScope$nestedClasses$1(this, r2));
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    protected ClassDeclaredMemberIndex computeMemberIndex() {
        return new ClassDeclaredMemberIndex(this.jClass, AnonymousClass1.INSTANCE);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    protected LinkedHashSet<Name> computeFunctionNames(DescriptorKindFilter r4, Function1<? super Name, Boolean> r5) {
        Intrinsics.checkNotNullParameter(r4, "kindFilter");
        Collection<KotlinType> r0 = getOwnerDescriptor().getTypeConstructor().mo2084getSupertypes();
        Intrinsics.checkNotNullExpressionValue(r0, "ownerDescriptor.typeConstructor.supertypes");
        LinkedHashSet<Name> r1 = new LinkedHashSet();
        Iterator<T> r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        CollectionsKt.addAll(r1, ((KotlinType) r2.next()).getMemberScope().getFunctionNames());
        goto L4
    L6:
        LinkedHashSet<Name> r3 = r1;
        r3.addAll(getDeclaredMemberIndex().invoke().getMethodNames());
        r3.addAll(getDeclaredMemberIndex().invoke().getRecordComponentNames());
        r3.addAll(computeClassNames(r4, r5));
        r3.addAll(getC().getComponents().getSyntheticPartsProvider().getMethodNames(getOwnerDescriptor()));
        return r3;
    }

    public final NotNullLazyValue<List<ClassConstructorDescriptor>> getConstructors$descriptors_jvm() {
        return this.constructors;
    }

    private final ClassConstructorDescriptor createDefaultRecordConstructor() {
        ClassDescriptor r0 = getOwnerDescriptor();
        JavaClassConstructorDescriptor r1 = JavaClassConstructorDescriptor.createJavaConstructor(r0, Annotations.Companion.getEMPTY(), true, getC().getComponents().getSourceElementFactory().source(this.jClass));
        Intrinsics.checkNotNullExpressionValue(r1, "createJavaConstructor(\n ….source(jClass)\n        )");
        List<ValueParameterDescriptor> r2 = createRecordConstructorParameters(r1);
        r1.setHasSynthesizedParameterNames(false);
        r1.initialize(r2, getConstructorVisibility(r0));
        r1.setHasStableParameterNames(false);
        r1.setReturnType(r0.getDefaultType());
        return r1;
    }

    private final List<ValueParameterDescriptor> createRecordConstructorParameters(ClassConstructorDescriptorImpl r20) {
        Collection<JavaRecordComponent> r1 = this.jClass.getRecordComponents();
        ArrayList r2 = new ArrayList(r1.size());
        JavaTypeAttributes r3 = JavaTypeAttributesKt.toAttributes$default(TypeUsage.COMMON, false, false, null, 6, null);
        Iterator<JavaRecordComponent> r4 = r1.iterator();
        int r5 = 0;
    L3:
        int r8 = r5;
        if (r4.hasNext() == false) goto L11;
        r5 = r8 + 1;
        JavaRecordComponent r6 = r4.next();
        KotlinType r11 = getC().getTypeResolver().transformJavaType(r6.getType(), r3);
        if (r6.isVararg() == false) goto L8;
        KotlinType r7 = getC().getComponents().getModule().getBuiltIns().getArrayElementType(r11);
    L9:
        KotlinType r15 = r7;
        r2.add(new ValueParameterDescriptorImpl(r20, null, r8, Annotations.Companion.getEMPTY(), r6.getName(), r11, false, false, false, r15, getC().getComponents().getSourceElementFactory().source(r6)));
        goto L3
    L8:
        r7 = null;
        goto L9
    L11:
        return r2;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    protected boolean isVisibleAsFunction(JavaMethodDescriptor r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        if (this.jClass.isAnnotationType() == false) goto L7;
        return false;
    L7:
        return isVisibleAsFunctionInCurrentClass(r2);
    }

    private final boolean isVisibleAsFunctionInCurrentClass(final SimpleFunctionDescriptor r7) {
        Name r0 = r7.getName();
        Intrinsics.checkNotNullExpressionValue(r0, "function.name");
        List<Name> r1 = PropertiesConventionUtilKt.getPropertyNamesCandidatesByAccessorName(r0);
        if ((r1 instanceof Collection) == true) goto L5;
    L7:
        Iterator<T> r2 = r1.iterator();
    L9:
        if (r2.hasNext() == false) goto L6;
        Set<PropertyDescriptor> r3 = getPropertiesFromSupertypes((Name) r2.next());
        if ((r3 instanceof Collection) == true) goto L13;
    L15:
        Iterator<T> r4 = r3.iterator();
    L17:
        if (r4.hasNext() == false) goto L14;
        PropertyDescriptor r5 = (PropertyDescriptor) r4.next();
        if (doesClassOverridesProperty(r5, new LazyJavaClassMemberScope$isVisibleAsFunctionInCurrentClass$1$1$1(r7, this)) == true) goto L21;
    L25:
        boolean r6 = false;
    L26:
        if (r6 == false) goto L17;
        boolean r8 = true;
    L28:
        if (r8 == false) goto L9;
        boolean r9 = true;
    L30:
        if (r9 == false) goto L33;
        return false;
    L33:
        if (doesOverrideRenamedBuiltins(r7) == true) goto L40;
        if (shouldBeVisibleAsOverrideOfBuiltInWithErasedValueParameters(r7) == true) goto L40;
        if (doesOverrideSuspendFunction(r7) == true) goto L40;
        return true;
    L40:
        return false;
    L21:
        if (r5.isVar() == true) goto L24;
        String r10 = r7.getName().asString();
        Intrinsics.checkNotNullExpressionValue(r10, "function.name.asString()");
        if (JvmAbi.isSetterName(r10) == true) goto L25;
    L24:
        r6 = true;
    L14:
        r8 = false;
        goto L28
    L13:
        if (r3.isEmpty() == false) goto L15;
    L6:
        r9 = false;
        goto L30
    L5:
        if (r1.isEmpty() == false) goto L7;
        goto L6
    }

    private final boolean shouldBeVisibleAsOverrideOfBuiltInWithErasedValueParameters(SimpleFunctionDescriptor r5) {
        BuiltinMethodsWithSpecialGenericSignature r0 = BuiltinMethodsWithSpecialGenericSignature.INSTANCE;
        Name r1 = r5.getName();
        Intrinsics.checkNotNullExpressionValue(r1, "name");
        if (r0.getSameAsBuiltinMethodWithErasedValueParameters(r1) == true) goto L5;
        return false;
    L5:
        Name r2 = r5.getName();
        Intrinsics.checkNotNullExpressionValue(r2, "name");
        Set<SimpleFunctionDescriptor> r3 = getFunctionsFromSupertypes(r2);
        ArrayList r4 = new ArrayList();
        Iterator<T> r6 = r3.iterator();
    L7:
        if (r6.hasNext() == false) goto L11;
        FunctionDescriptor r7 = BuiltinMethodsWithSpecialGenericSignature.getOverriddenBuiltinFunctionWithErasedValueParametersInJava((SimpleFunctionDescriptor) r6.next());
        if (r7 == null) goto L7;
        r4.add(r7);
        goto L7
    L11:
        ArrayList r8 = r4;
        if ((r8 instanceof Collection) == true) goto L14;
    L16:
        Iterator r9 = r8.iterator();
    L18:
        if (r9.hasNext() == false) goto L32;
        if (hasSameJvmDescriptorButDoesNotOverride(r5, (FunctionDescriptor) r9.next()) == false) goto L18;
        return true;
    L32:
        return false;
    L14:
        if (r8.isEmpty() == false) goto L16;
        return false;
    }

    private final Collection<SimpleFunctionDescriptor> searchMethodsByNameWithoutBuiltinMagic(Name r3) {
        Collection<JavaMethod> r4 = getDeclaredMemberIndex().invoke().findMethodsByName(r3);
        ArrayList r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r4, 10));
        Iterator<T> r5 = r4.iterator();
    L4:
        if (r5.hasNext() == false) goto L7;
        r0.add(resolveMethodToFunctionDescriptor((JavaMethod) r5.next()));
        goto L4
    L7:
        return r0;
    }

    private final Collection<SimpleFunctionDescriptor> searchMethodsInSupertypesWithoutBuiltinMagic(Name r4) {
        Set<SimpleFunctionDescriptor> r3 = getFunctionsFromSupertypes(r4);
        ArrayList r5 = new ArrayList();
        Iterator<T> r6 = r3.iterator();
    L4:
        if (r6.hasNext() == false) goto L15;
        Object r0 = r6.next();
        SimpleFunctionDescriptor r1 = (SimpleFunctionDescriptor) r0;
        if (SpecialBuiltinMembers.doesOverrideBuiltinWithDifferentJvmName(r1) == false) goto L8;
    L11:
        boolean r2 = true;
    L12:
        if (r2 == true) goto L4;
        r5.add(r0);
        goto L4
    L8:
        if (BuiltinMethodsWithSpecialGenericSignature.getOverriddenBuiltinFunctionWithErasedValueParametersInJava(r1) != null) goto L11;
        r2 = false;
        goto L12
    L15:
        return r5;
    }

    private final boolean doesOverrideRenamedBuiltins(SimpleFunctionDescriptor r7) {
        SpecialGenericSignatures.Companion r0 = SpecialGenericSignatures.Companion;
        Name r1 = r7.getName();
        Intrinsics.checkNotNullExpressionValue(r1, "name");
        Name r2 = r0.getBuiltinFunctionNamesByJvmName(r1);
        if (r2 != null) goto L5;
        return false;
    L5:
        Set<SimpleFunctionDescriptor> r3 = getFunctionsFromSupertypes(r2);
        ArrayList r4 = new ArrayList();
        Iterator<T> r5 = r3.iterator();
    L7:
        if (r5.hasNext() == false) goto L11;
        Object r6 = r5.next();
        if (SpecialBuiltinMembers.doesOverrideBuiltinWithDifferentJvmName((SimpleFunctionDescriptor) r6) == false) goto L7;
        r4.add(r6);
        goto L7
    L11:
        ArrayList r8 = r4;
        if (r8.isEmpty() == false) goto L14;
        return false;
    L14:
        SimpleFunctionDescriptor r9 = createRenamedCopy(r7, r2);
        ArrayList r10 = r8;
        if ((r10 instanceof Collection) == true) goto L17;
    L19:
        Iterator r11 = r10.iterator();
    L21:
        if (r11.hasNext() == false) goto L35;
        if (doesOverrideRenamedDescriptor((SimpleFunctionDescriptor) r11.next(), r9) == false) goto L21;
        return true;
    L35:
        return false;
    L17:
        if (r10.isEmpty() == false) goto L19;
        return false;
    }

    private final boolean doesOverrideSuspendFunction(SimpleFunctionDescriptor r6) {
        SimpleFunctionDescriptor r0 = createSuspendView(r6);
        if (r0 != null) goto L5;
        return false;
    L5:
        Name r7 = r6.getName();
        Intrinsics.checkNotNullExpressionValue(r7, "name");
        Set<SimpleFunctionDescriptor> r8 = getFunctionsFromSupertypes(r7);
        if ((r8 instanceof Collection) == true) goto L8;
    L10:
        Iterator<T> r9 = r8.iterator();
    L12:
        if (r9.hasNext() == false) goto L28;
        SimpleFunctionDescriptor r2 = (SimpleFunctionDescriptor) r9.next();
        if (r2.isSuspend() == true) goto L16;
    L18:
        boolean r3 = false;
    L19:
        if (r3 == false) goto L12;
        return true;
    L16:
        if (doesOverride(r0, r2) == false) goto L18;
        r3 = true;
        goto L19
    L28:
        return false;
    L8:
        if (r8.isEmpty() == false) goto L10;
        return false;
    }

    private final SimpleFunctionDescriptor createSuspendView(SimpleFunctionDescriptor r5) {
        List<ValueParameterDescriptor> r4 = r5.getValueParameters();
        Intrinsics.checkNotNullExpressionValue(r4, "valueParameters");
        ValueParameterDescriptor r6 = (ValueParameterDescriptor) CollectionsKt.lastOrNull(r4);
        if (r6 == null) goto L26;
        ClassifierDescriptor r2 = r6.getType().getConstructor().mo2083getDeclarationDescriptor();
        if (r2 == null) goto L14;
        FqNameUnsafe r3 = DescriptorUtilsKt.getFqNameUnsafe(r2);
        if (r3 == null) goto L14;
        if (r3.isSafe() == true) goto L12;
        r3 = null;
    L12:
        if (r3 == null) goto L14;
        FqName r7 = r3.toSafe();
    L16:
        if (Intrinsics.areEqual(r7, StandardNames.CONTINUATION_INTERFACE_FQ_NAME) == true) goto L19;
        r6 = null;
    L19:
        if (r6 == null) goto L26;
        FunctionDescriptor.CopyBuilder<? extends SimpleFunctionDescriptor> r1 = r5.newCopyBuilder();
        List<ValueParameterDescriptor> r8 = r5.getValueParameters();
        Intrinsics.checkNotNullExpressionValue(r8, "valueParameters");
        SimpleFunctionDescriptor r9 = (SimpleFunctionDescriptor) r1.setValueParameters(CollectionsKt.dropLast(r8, 1)).setReturnType(r6.getType().getArguments().get(0).getType()).build();
        SimpleFunctionDescriptorImpl r10 = (SimpleFunctionDescriptorImpl) r9;
        if (r10 == null) goto L25;
        r10.setSuspend(true);
    L25:
        return r9;
    L14:
        r7 = null;
    L26:
        return null;
    }

    private final SimpleFunctionDescriptor createRenamedCopy(SimpleFunctionDescriptor r1, Name r2) {
        FunctionDescriptor.CopyBuilder<? extends SimpleFunctionDescriptor> r0 = r1.newCopyBuilder();
        r0.setName(r2);
        r0.setSignatureChange();
        r0.setPreserveSourceElement();
        FunctionDescriptor r3 = r0.build();
        Intrinsics.checkNotNull(r3);
        return (SimpleFunctionDescriptor) r3;
    }

    private final boolean doesOverrideRenamedDescriptor(SimpleFunctionDescriptor r2, FunctionDescriptor r3) {
        if (BuiltinMethodsWithDifferentJvmName.INSTANCE.isRemoveAtByIndex(r2) == false) goto L5;
        r3 = r3.getOriginal();
    L5:
        Intrinsics.checkNotNullExpressionValue(r3, "if (superDescriptor.isRe…iginal else subDescriptor");
        return doesOverride(r3, r2);
    }

    private final boolean doesOverride(CallableDescriptor r3, CallableDescriptor r4) {
        OverridingUtil.OverrideCompatibilityInfo.Result r2 = OverridingUtil.DEFAULT.isOverridableByWithoutExternalConditions(r4, r3, true).getResult();
        Intrinsics.checkNotNullExpressionValue(r2, "DEFAULT.isOverridableByW…iptor, this, true).result");
        if (r2 == OverridingUtil.OverrideCompatibilityInfo.Result.OVERRIDABLE) goto L5;
    L7:
        return false;
    L5:
        if (JavaIncompatibilityRulesOverridabilityCondition.Companion.doesJavaOverrideHaveIncompatibleValueParameterKinds(r4, r3) == true) goto L7;
        return true;
    }

    private final SimpleFunctionDescriptor findGetterOverride(PropertyDescriptor r4, Function1<? super Name, ? extends Collection<? extends SimpleFunctionDescriptor>> r5) {
        PropertyGetterDescriptor r0 = r4.getGetter();
        String r1 = null;
        if (r0 == null) goto L5;
        PropertyGetterDescriptor r2 = (PropertyGetterDescriptor) SpecialBuiltinMembers.getOverriddenBuiltinWithDifferentJvmName(r0);
    L6:
        if (r2 == null) goto L8;
        r1 = ClassicBuiltinSpecialProperties.INSTANCE.getBuiltinSpecialPropertyGetterName(r2);
    L8:
        if (r1 != null) goto L10;
    L13:
        String r3 = r4.getName().asString();
        Intrinsics.checkNotNullExpressionValue(r3, "name.asString()");
        return findGetterByName(r4, JvmAbi.getterName(r3), r5);
    L10:
        if (SpecialBuiltinMembers.hasRealKotlinSuperClassWithOverrideOf(getOwnerDescriptor(), r2) == true) goto L13;
        return findGetterByName(r4, r1, r5);
    L5:
        r2 = null;
        goto L6
    }

    private final SimpleFunctionDescriptor findGetterByName(PropertyDescriptor r4, String r5, Function1<? super Name, ? extends Collection<? extends SimpleFunctionDescriptor>> r6) {
        Name r3 = Name.identifier(r5);
        Intrinsics.checkNotNullExpressionValue(r3, "identifier(getterName)");
        Iterator<T> r7 = r6.invoke(r3).iterator();
    L3:
        SimpleFunctionDescriptor r8 = null;
        if (r7.hasNext() == false) goto L15;
        SimpleFunctionDescriptor r9 = (SimpleFunctionDescriptor) r7.next();
        if (r9.getValueParameters().size() != 0) goto L14;
        KotlinTypeChecker r0 = KotlinTypeChecker.DEFAULT;
        KotlinType r1 = r9.getReturnType();
        if (r1 != null) goto L11;
        boolean r2 = false;
    L12:
        if (r2 == false) goto L14;
        r8 = r9;
        goto L14
    L11:
        r2 = r0.isSubtypeOf(r1, r4.getType());
    L14:
        if (r8 == null) goto L3;
    L15:
        return r8;
    }

    private final SimpleFunctionDescriptor findSetterOverride(PropertyDescriptor r5, Function1<? super Name, ? extends Collection<? extends SimpleFunctionDescriptor>> r6) {
        String r4 = r5.getName().asString();
        Intrinsics.checkNotNullExpressionValue(r4, "name.asString()");
        Name r7 = Name.identifier(JvmAbi.setterName(r4));
        Intrinsics.checkNotNullExpressionValue(r7, "identifier(JvmAbi.setterName(name.asString()))");
        Iterator<T> r8 = r6.invoke(r7).iterator();
    L3:
        SimpleFunctionDescriptor r0 = null;
        if (r8.hasNext() == false) goto L18;
        SimpleFunctionDescriptor r9 = (SimpleFunctionDescriptor) r8.next();
        if (r9.getValueParameters().size() != 1) goto L17;
        KotlinType r1 = r9.getReturnType();
        if (r1 == null) goto L17;
        if (KotlinBuiltIns.isUnit(r1) == false) goto L17;
        KotlinTypeChecker r2 = KotlinTypeChecker.DEFAULT;
        List<ValueParameterDescriptor> r3 = r9.getValueParameters();
        Intrinsics.checkNotNullExpressionValue(r3, "descriptor.valueParameters");
        if (r2.equalTypes(((ValueParameterDescriptor) CollectionsKt.single(r3)).getType(), r5.getType()) == false) goto L17;
        r0 = r9;
    L17:
        if (r0 == null) goto L3;
    L18:
        return r0;
    }

    private final boolean doesClassOverridesProperty(PropertyDescriptor r3, Function1<? super Name, ? extends Collection<? extends SimpleFunctionDescriptor>> r4) {
        if (JavaDescriptorUtilKt.isJavaField(r3) == false) goto L5;
        return false;
    L5:
        SimpleFunctionDescriptor r0 = findGetterOverride(r3, r4);
        SimpleFunctionDescriptor r2 = findSetterOverride(r3, r4);
        if (r0 != null) goto L9;
        return false;
    L9:
        if (r3.isVar() == true) goto L11;
        return true;
    L11:
        if (r2 != null) goto L13;
        return false;
    L13:
        if (r2.getModality() == r0.getModality()) goto L15;
        return false;
    L15:
        return true;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    protected void computeNonDeclaredFunctions(Collection<SimpleFunctionDescriptor> r11, Name r12) {
        Intrinsics.checkNotNullParameter(r11, "result");
        Intrinsics.checkNotNullParameter(r12, "name");
        Set<SimpleFunctionDescriptor> r6 = getFunctionsFromSupertypes(r12);
        if (SpecialGenericSignatures.Companion.getSameAsRenamedInJvmBuiltin(r12) == false) goto L5;
    L26:
        SmartSet r8 = SmartSet.Companion.create();
        Collection<? extends SimpleFunctionDescriptor> r9 = DescriptorResolverUtils.resolveOverridesForNonStaticMembers(r12, r6, CollectionsKt.emptyList(), getOwnerDescriptor(), ErrorReporter.DO_NOTHING, getC().getComponents().getKotlinTypeChecker().getOverridingUtil());
        Intrinsics.checkNotNullExpressionValue(r9, "resolveOverridesForNonSt….overridingUtil\n        )");
        addOverriddenSpecialMethods(r12, r11, r9, r11, new AnonymousClass3(this));
        addOverriddenSpecialMethods(r12, r11, r9, r8, new AnonymousClass4(this));
        ArrayList r0 = new ArrayList();
        Iterator<T> r1 = r6.iterator();
    L28:
        if (r1.hasNext() == false) goto L32;
        Object r2 = r1.next();
        if (isVisibleAsFunctionInCurrentClass((SimpleFunctionDescriptor) r2) == false) goto L28;
        r0.add(r2);
        goto L28
    L32:
        addFunctionFromSupertypes(r11, r12, CollectionsKt.plus(r0, r8), true);
        return;
    L5:
        if (BuiltinMethodsWithSpecialGenericSignature.INSTANCE.getSameAsBuiltinMethodWithErasedValueParameters(r12) == true) goto L26;
        Set<SimpleFunctionDescriptor> r3 = r6;
        if ((r3 instanceof Collection) == true) goto L9;
    L11:
        Iterator<T> r4 = r3.iterator();
    L13:
        if (r4.hasNext() == false) goto L10;
        if (((FunctionDescriptor) r4.next()).isSuspend() == false) goto L13;
        boolean r5 = false;
    L17:
        if (r5 == false) goto L26;
        ArrayList r7 = new ArrayList();
        Iterator<T> r10 = r3.iterator();
    L20:
        if (r10.hasNext() == false) goto L24;
        Object r13 = r10.next();
        if (isVisibleAsFunctionInCurrentClass((SimpleFunctionDescriptor) r13) == false) goto L20;
        r7.add(r13);
        goto L20
    L24:
        addFunctionFromSupertypes(r11, r12, r7, false);
        return;
    L10:
        r5 = true;
        goto L17
    L9:
        if (r3.isEmpty() == false) goto L11;
        goto L10
    }

    private final void addFunctionFromSupertypes(Collection<SimpleFunctionDescriptor> r7, Name r8, Collection<? extends SimpleFunctionDescriptor> r9, boolean r10) {
        Collection<? extends SimpleFunctionDescriptor> r11 = DescriptorResolverUtils.resolveOverridesForNonStaticMembers(r8, r9, r7, getOwnerDescriptor(), getC().getComponents().getErrorReporter(), getC().getComponents().getKotlinTypeChecker().getOverridingUtil());
        Intrinsics.checkNotNullExpressionValue(r11, "resolveOverridesForNonSt….overridingUtil\n        )");
        if (r10 == true) goto L5;
        r7.addAll(r11);
        return;
    L5:
        Collection<? extends SimpleFunctionDescriptor> r12 = r11;
        List r13 = CollectionsKt.plus(r7, r12);
        ArrayList r14 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r12, 10));
        Iterator<T> r15 = r12.iterator();
    L7:
        if (r15.hasNext() == false) goto L13;
        SimpleFunctionDescriptor r0 = (SimpleFunctionDescriptor) r15.next();
        SimpleFunctionDescriptor r1 = (SimpleFunctionDescriptor) SpecialBuiltinMembers.getOverriddenSpecialBuiltin(r0);
        if (r1 != null) goto L11;
        Intrinsics.checkNotNullExpressionValue(r0, "resolvedOverride");
    L12:
        r14.add(r0);
        goto L7
    L11:
        Intrinsics.checkNotNullExpressionValue(r0, "resolvedOverride");
        r0 = createHiddenCopyIfBuiltinAlreadyAccidentallyOverridden(r0, r1, r13);
        goto L12
    L13:
        r7.addAll(r14);
    }

    private final void addOverriddenSpecialMethods(Name r3, Collection<? extends SimpleFunctionDescriptor> r4, Collection<? extends SimpleFunctionDescriptor> r5, Collection<SimpleFunctionDescriptor> r6, Function1<? super Name, ? extends Collection<? extends SimpleFunctionDescriptor>> r7) {
        Iterator<? extends SimpleFunctionDescriptor> r8 = r5.iterator();
    L4:
        if (r8.hasNext() == false) goto L6;
        SimpleFunctionDescriptor r0 = r8.next();
        kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.addIfNotNull(r6, obtainOverrideForBuiltinWithDifferentJvmName(r0, r7, r3, r4));
        kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.addIfNotNull(r6, obtainOverrideForBuiltInWithErasedValueParametersInJava(r0, r7, r4));
        kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.addIfNotNull(r6, obtainOverrideForSuspend(r0, r7));
        goto L4
    }

    private final SimpleFunctionDescriptor obtainOverrideForBuiltInWithErasedValueParametersInJava(SimpleFunctionDescriptor r3, Function1<? super Name, ? extends Collection<? extends SimpleFunctionDescriptor>> r4, Collection<? extends SimpleFunctionDescriptor> r5) {
        FunctionDescriptor r6 = BuiltinMethodsWithSpecialGenericSignature.getOverriddenBuiltinFunctionWithErasedValueParametersInJava(r3);
        if (r6 != null) goto L5;
        return null;
    L5:
        SimpleFunctionDescriptor r7 = createOverrideForBuiltinFunctionWithErasedParameterIfNeeded(r6, r4);
        if (r7 != null) goto L8;
        return null;
    L8:
        if (isVisibleAsFunctionInCurrentClass(r7) == true) goto L11;
        r7 = null;
    L11:
        if (r7 != null) goto L13;
        return null;
    L13:
        return createHiddenCopyIfBuiltinAlreadyAccidentallyOverridden(r7, r6, r5);
    }

    private final SimpleFunctionDescriptor obtainOverrideForBuiltinWithDifferentJvmName(SimpleFunctionDescriptor r4, Function1<? super Name, ? extends Collection<? extends SimpleFunctionDescriptor>> r5, Name r6, Collection<? extends SimpleFunctionDescriptor> r7) {
        SimpleFunctionDescriptor r8 = (SimpleFunctionDescriptor) SpecialBuiltinMembers.getOverriddenBuiltinWithDifferentJvmName(r4);
        if (r8 != null) goto L5;
        return null;
    L5:
        String r1 = SpecialBuiltinMembers.getJvmMethodNameIfSpecial(r8);
        Intrinsics.checkNotNull(r1);
        Name r2 = Name.identifier(r1);
        Intrinsics.checkNotNullExpressionValue(r2, "identifier(nameInJava)");
        Iterator<? extends SimpleFunctionDescriptor> r9 = r5.invoke(r2).iterator();
    L7:
        if (r9.hasNext() == false) goto L12;
        SimpleFunctionDescriptor r3 = createRenamedCopy(r9.next(), r6);
        if (doesOverrideRenamedDescriptor(r8, r3) == false) goto L7;
        return createHiddenCopyIfBuiltinAlreadyAccidentallyOverridden(r3, r8, r7);
    L12:
        return null;
    }

    private final SimpleFunctionDescriptor obtainOverrideForSuspend(SimpleFunctionDescriptor r5, Function1<? super Name, ? extends Collection<? extends SimpleFunctionDescriptor>> r6) {
        if (r5.isSuspend() == true) goto L5;
        return null;
    L5:
        Name r0 = r5.getName();
        Intrinsics.checkNotNullExpressionValue(r0, "descriptor.name");
        Iterator<T> r7 = r6.invoke(r0).iterator();
    L7:
        if (r7.hasNext() == false) goto L22;
        SimpleFunctionDescriptor r1 = createSuspendView((SimpleFunctionDescriptor) r7.next());
        if (r1 != null) goto L11;
    L13:
        r1 = null;
    L14:
        if (r1 == null) goto L7;
        return r1;
    L11:
        if (doesOverride(r1, r5) == false) goto L13;
    L22:
        return null;
    }

    private final SimpleFunctionDescriptor createHiddenCopyIfBuiltinAlreadyAccidentallyOverridden(SimpleFunctionDescriptor r5, CallableDescriptor r6, Collection<? extends SimpleFunctionDescriptor> r7) {
        Collection<? extends SimpleFunctionDescriptor> r8 = r7;
        boolean r1 = true;
        if ((r8 instanceof Collection) == true) goto L5;
    L7:
        Iterator<T> r9 = r8.iterator();
    L9:
        if (r9.hasNext() == false) goto L20;
        SimpleFunctionDescriptor r0 = (SimpleFunctionDescriptor) r9.next();
        if (Intrinsics.areEqual(r5, r0) == false) goto L13;
    L17:
        boolean r2 = false;
    L18:
        if (r2 == false) goto L9;
        r1 = false;
        goto L20
    L13:
        if (r0.getInitialSignatureDescriptor() != null) goto L17;
        if (doesOverride(r0, r6) == false) goto L17;
        r2 = true;
    L20:
        if (r1 == true) goto L29;
        FunctionDescriptor r4 = r5.newCopyBuilder().setHiddenToOvercomeSignatureClash().build();
        Intrinsics.checkNotNull(r4);
        return (SimpleFunctionDescriptor) r4;
    L29:
        return r5;
    L5:
        if (r8.isEmpty() == false) goto L7;
        goto L7
    }

    private final SimpleFunctionDescriptor createOverrideForBuiltinFunctionWithErasedParameterIfNeeded(FunctionDescriptor r4, Function1<? super Name, ? extends Collection<? extends SimpleFunctionDescriptor>> r5) {
        Name r0 = r4.getName();
        Intrinsics.checkNotNullExpressionValue(r0, "overridden.name");
        Iterator<T> r6 = r5.invoke(r0).iterator();
    L4:
        if (r6.hasNext() == false) goto L8;
        Object r1 = r6.next();
        if (hasSameJvmDescriptorButDoesNotOverride((SimpleFunctionDescriptor) r1, r4) == false) goto L4;
    L9:
        SimpleFunctionDescriptor r2 = (SimpleFunctionDescriptor) r1;
        if (r2 == null) goto L21;
        FunctionDescriptor.CopyBuilder<? extends SimpleFunctionDescriptor> r3 = r2.newCopyBuilder();
        List<ValueParameterDescriptor> r7 = r4.getValueParameters();
        Intrinsics.checkNotNullExpressionValue(r7, "overridden.valueParameters");
        List<ValueParameterDescriptor> r8 = r7;
        ArrayList r9 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r8, 10));
        Iterator<T> r10 = r8.iterator();
    L13:
        if (r10.hasNext() == false) goto L15;
        r9.add(((ValueParameterDescriptor) r10.next()).getType());
        goto L13
    L15:
        List<ValueParameterDescriptor> r11 = r2.getValueParameters();
        Intrinsics.checkNotNullExpressionValue(r11, "override.valueParameters");
        r3.setValueParameters(UtilKt.copyValueParameters(r9, r11, r4));
        r3.setSignatureChange();
        r3.setPreserveSourceElement();
        r3.putUserData(JavaMethodDescriptor.HAS_ERASED_VALUE_PARAMETERS, true);
        return (SimpleFunctionDescriptor) r3.build();
    L21:
        return null;
    L8:
        r1 = null;
        goto L9
    }

    private final Set<SimpleFunctionDescriptor> getFunctionsFromSupertypes(Name r4) {
        Collection<KotlinType> r3 = computeSupertypes();
        LinkedHashSet r0 = new LinkedHashSet();
        Iterator<T> r5 = r3.iterator();
    L4:
        if (r5.hasNext() == false) goto L7;
        CollectionsKt.addAll(r0, ((KotlinType) r5.next()).getMemberScope().getContributedFunctions(r4, NoLookupLocation.WHEN_GET_SUPER_MEMBERS));
        goto L4
    L7:
        return r0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    protected void computeImplicitlyDeclaredFunctions(Collection<SimpleFunctionDescriptor> r4, Name r5) {
        Intrinsics.checkNotNullParameter(r4, "result");
        Intrinsics.checkNotNullParameter(r5, "name");
        if (this.jClass.isRecord() == true) goto L5;
    L17:
        getC().getComponents().getSyntheticPartsProvider().generateMethods(getOwnerDescriptor(), r5, r4);
        return;
    L5:
        if (getDeclaredMemberIndex().invoke().findRecordComponentByName(r5) == null) goto L17;
        Collection<SimpleFunctionDescriptor> r0 = r4;
        boolean r2 = true;
        if (r0.isEmpty() == true) goto L15;
        Iterator<T> r1 = r0.iterator();
    L11:
        if (r1.hasNext() == false) goto L15;
        if (((SimpleFunctionDescriptor) r1.next()).getValueParameters().isEmpty() == false) goto L11;
        r2 = false;
    L15:
        if (r2 == false) goto L17;
        JavaRecordComponent r3 = getDeclaredMemberIndex().invoke().findRecordComponentByName(r5);
        Intrinsics.checkNotNull(r3);
        r4.add(resolveRecordComponentToFunctionDescriptor(r3));
        goto L17
    }

    private final JavaMethodDescriptor resolveRecordComponentToFunctionDescriptor(JavaRecordComponent r16) {
        Annotations r0 = LazyJavaAnnotationsKt.resolveAnnotations(getC(), r16);
        JavaMethodDescriptor r1 = JavaMethodDescriptor.createJavaMethod(getOwnerDescriptor(), r0, r16.getName(), getC().getComponents().getSourceElementFactory().source(r16), true);
        Intrinsics.checkNotNullExpressionValue(r1, "createJavaMethod(\n      …omponent), true\n        )");
        JavaTypeAttributes r2 = JavaTypeAttributesKt.toAttributes$default(TypeUsage.COMMON, false, false, null, 6, null);
        KotlinType r11 = getC().getTypeResolver().transformJavaType(r16.getType(), r2);
        r1.initialize(null, getDispatchReceiverParameter(), CollectionsKt.emptyList(), CollectionsKt.emptyList(), CollectionsKt.emptyList(), r11, Modality.Companion.convertFromFlags(false, false, true), DescriptorVisibilities.PUBLIC, null);
        r1.setParameterNamesStatus(false, false);
        getC().getComponents().getJavaResolverCache().recordMethod(r16, r1);
        return r1;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    protected void computeNonDeclaredProperties(Name r8, Collection<PropertyDescriptor> r9) {
        Intrinsics.checkNotNullParameter(r8, "name");
        Intrinsics.checkNotNullParameter(r9, "result");
        if (this.jClass.isAnnotationType() == false) goto L5;
        computeAnnotationProperties(r8, r9);
    L5:
        Set<PropertyDescriptor> r0 = getPropertiesFromSupertypes(r8);
        if (r0.isEmpty() == false) goto L8;
        return;
    L8:
        SmartSet r1 = SmartSet.Companion.create();
        SmartSet r2 = SmartSet.Companion.create();
        addPropertyOverrideByMethod(r0, r9, r1, new C04681(this));
        addPropertyOverrideByMethod(SetsKt.minus(r0, r1), r2, null, new AnonymousClass2(this));
        Collection<? extends PropertyDescriptor> r7 = DescriptorResolverUtils.resolveOverridesForNonStaticMembers(r8, SetsKt.plus(r0, r2), r9, getOwnerDescriptor(), getC().getComponents().getErrorReporter(), getC().getComponents().getKotlinTypeChecker().getOverridingUtil());
        Intrinsics.checkNotNullExpressionValue(r7, "resolveOverridesForNonSt…rridingUtil\n            )");
        r9.addAll(r7);
    }

    private final void addPropertyOverrideByMethod(Set<? extends PropertyDescriptor> r3, Collection<PropertyDescriptor> r4, Set<PropertyDescriptor> r5, Function1<? super Name, ? extends Collection<? extends SimpleFunctionDescriptor>> r6) {
        Iterator<? extends PropertyDescriptor> r7 = r3.iterator();
    L4:
        if (r7.hasNext() == false) goto L15;
        PropertyDescriptor r0 = r7.next();
        JavaPropertyDescriptor r1 = createPropertyDescriptorByMethods(r0, r6);
        if (r1 == null) goto L4;
        r4.add(r1);
        if (r5 == null) goto L14;
        r5.add(r0);
        return;
    L14:
        return;
    }

    private final void computeAnnotationProperties(Name r7, Collection<PropertyDescriptor> r8) {
        JavaMethod r1 = (JavaMethod) CollectionsKt.singleOrNull(getDeclaredMemberIndex().invoke().findMethodsByName(r7));
        if (r1 != null) goto L5;
        return;
    L5:
        r8.add(createPropertyDescriptorWithDefaultGetter$default(this, r1, null, Modality.FINAL, 2, null));
    }

    static /* synthetic */ JavaPropertyDescriptor createPropertyDescriptorWithDefaultGetter$default(LazyJavaClassMemberScope r0, JavaMethod r1, KotlinType r2, Modality r3, int r4, Object r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = null;
    L6:
        return r0.createPropertyDescriptorWithDefaultGetter(r1, r2, r3);
    }

    private final JavaPropertyDescriptor createPropertyDescriptorWithDefaultGetter(JavaMethod r18, KotlinType r19, Modality r20) {
        Annotations r4 = LazyJavaAnnotationsKt.resolveAnnotations(getC(), r18);
        JavaPropertyDescriptor r1 = JavaPropertyDescriptor.create(getOwnerDescriptor(), r4, r20, UtilsKt.toDescriptorVisibility(r18.getVisibility()), false, r18.getName(), getC().getComponents().getSourceElementFactory().source(r18), false);
        Intrinsics.checkNotNullExpressionValue(r1, "create(\n            owne…inal = */ false\n        )");
        PropertyGetterDescriptorImpl r2 = DescriptorFactory.createDefaultGetter(r1, Annotations.Companion.getEMPTY());
        Intrinsics.checkNotNullExpressionValue(r2, "createDefaultGetter(prop…iptor, Annotations.EMPTY)");
        r1.initialize(r2, null);
        if (r19 != null) goto L5;
        KotlinType r0 = computeMethodReturnType(r18, ContextKt.childForMethod$default(getC(), r1, r18, 0, 4, null));
    L6:
        KotlinType r12 = r0;
        r1.setType(r12, CollectionsKt.emptyList(), getDispatchReceiverParameter(), null, CollectionsKt.emptyList());
        r2.initialize(r0);
        return r1;
    L5:
        r0 = r19;
        goto L6
    }

    private final JavaPropertyDescriptor createPropertyDescriptorByMethods(PropertyDescriptor r19, Function1<? super Name, ? extends Collection<? extends SimpleFunctionDescriptor>> r20) {
        PropertySetterDescriptorImpl r1 = null;
        if (doesClassOverridesProperty(r19, r20) == true) goto L5;
        return null;
    L5:
        SimpleFunctionDescriptor r0 = findGetterOverride(r19, r20);
        Intrinsics.checkNotNull(r0);
        if (r19.isVar() == false) goto L8;
        SimpleFunctionDescriptor r2 = findSetterOverride(r19, r20);
        Intrinsics.checkNotNull(r2);
    L9:
        if (r2 == null) goto L11;
        r2.getModality();
        r0.getModality();
    L11:
        JavaForKotlinOverridePropertyDescriptor r9 = new JavaForKotlinOverridePropertyDescriptor(getOwnerDescriptor(), r0, r2, r19);
        KotlinType r4 = r0.getReturnType();
        Intrinsics.checkNotNull(r4);
        r9.setType(r4, CollectionsKt.emptyList(), getDispatchReceiverParameter(), null, CollectionsKt.emptyList());
        JavaForKotlinOverridePropertyDescriptor r3 = r9;
        PropertyGetterDescriptorImpl r5 = DescriptorFactory.createGetter(r3, r0.getAnnotations(), false, false, false, r0.getSource());
        r5.setInitialSignatureDescriptor(r0);
        r5.initialize(r9.getType());
        Intrinsics.checkNotNullExpressionValue(r5, "createGetter(\n          …escriptor.type)\n        }");
        if (r2 == null) goto L18;
        List<ValueParameterDescriptor> r6 = r2.getValueParameters();
        Intrinsics.checkNotNullExpressionValue(r6, "setterMethod.valueParameters");
        ValueParameterDescriptor r7 = (ValueParameterDescriptor) CollectionsKt.firstOrNull(r6);
        if (r7 == null) goto L17;
        r1 = DescriptorFactory.createSetter(r3, r2.getAnnotations(), r7.getAnnotations(), false, false, false, r2.getVisibility(), r2.getSource());
        r1.setInitialSignatureDescriptor(r2);
        goto L18
    L17:
        throw new AssertionError("No parameter found for " + r2);
    L18:
        r9.initialize(r5, r1);
        return r9;
    L8:
        r2 = null;
        goto L9
    }

    private final Set<PropertyDescriptor> getPropertiesFromSupertypes(Name r5) {
        Collection<KotlinType> r4 = computeSupertypes();
        ArrayList r0 = new ArrayList();
        Iterator<T> r6 = r4.iterator();
    L4:
        if (r6.hasNext() == false) goto L11;
        Collection<? extends PropertyDescriptor> r1 = ((KotlinType) r6.next()).getMemberScope().getContributedVariables(r5, NoLookupLocation.WHEN_GET_SUPER_MEMBERS);
        ArrayList r2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r1, 10));
        Iterator<T> r3 = r1.iterator();
    L7:
        if (r3.hasNext() == false) goto L9;
        r2.add((PropertyDescriptor) r3.next());
        goto L7
    L9:
        CollectionsKt.addAll(r0, r2);
        goto L4
    L11:
        return CollectionsKt.toSet(r0);
    }

    private final Collection<KotlinType> computeSupertypes() {
        if (this.skipRefinement == false) goto L7;
        Collection<KotlinType> r1 = getOwnerDescriptor().getTypeConstructor().mo2084getSupertypes();
        Intrinsics.checkNotNullExpressionValue(r1, "ownerDescriptor.typeConstructor.supertypes");
        return r1;
    L7:
        return getC().getComponents().getKotlinTypeChecker().getKotlinTypeRefiner().refineSupertypes(getOwnerDescriptor());
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    protected LazyJavaScope.MethodSignatureData resolveMethodSignature(JavaMethod r9, List<? extends TypeParameterDescriptor> r10, KotlinType r11, List<? extends ValueParameterDescriptor> r12) {
        Intrinsics.checkNotNullParameter(r9, "method");
        Intrinsics.checkNotNullParameter(r10, "methodTypeParameters");
        Intrinsics.checkNotNullParameter(r11, "returnType");
        Intrinsics.checkNotNullParameter(r12, "valueParameters");
        SignaturePropagator.PropagatedSignature r8 = getC().getComponents().getSignaturePropagator().resolvePropagatedSignature(r9, getOwnerDescriptor(), r11, null, r12, r10);
        Intrinsics.checkNotNullExpressionValue(r8, "c.components.signaturePr…dTypeParameters\n        )");
        KotlinType r1 = r8.getReturnType();
        Intrinsics.checkNotNullExpressionValue(r1, "propagated.returnType");
        KotlinType r2 = r8.getReceiverType();
        List<ValueParameterDescriptor> r3 = r8.getValueParameters();
        Intrinsics.checkNotNullExpressionValue(r3, "propagated.valueParameters");
        List<TypeParameterDescriptor> r4 = r8.getTypeParameters();
        Intrinsics.checkNotNullExpressionValue(r4, "propagated.typeParameters");
        boolean r5 = r8.hasStableParameterNames();
        List<String> r6 = r8.getErrors();
        Intrinsics.checkNotNullExpressionValue(r6, "propagated.errors");
        return new LazyJavaScope.MethodSignatureData(r1, r2, r3, r4, r5, r6);
    }

    private final boolean hasSameJvmDescriptorButDoesNotOverride(SimpleFunctionDescriptor r7, FunctionDescriptor r8) {
        String r0 = MethodSignatureMappingKt.computeJvmDescriptor$default(r7, false, false, 2, null);
        FunctionDescriptor r4 = r8.getOriginal();
        Intrinsics.checkNotNullExpressionValue(r4, "builtinWithErasedParameters.original");
        if (Intrinsics.areEqual(r0, MethodSignatureMappingKt.computeJvmDescriptor$default(r4, false, false, 2, null)) == true) goto L5;
        return false;
    L5:
        if (doesOverride(r7, r8) == true) goto L9;
        return true;
    L9:
        return false;
    }

    private final JavaClassConstructorDescriptor resolveConstructor(JavaConstructor r11) {
        ClassDescriptor r0 = getOwnerDescriptor();
        JavaConstructor r3 = r11;
        JavaClassConstructorDescriptor r1 = JavaClassConstructorDescriptor.createJavaConstructor(r0, LazyJavaAnnotationsKt.resolveAnnotations(getC(), r11), false, getC().getComponents().getSourceElementFactory().source(r3));
        Intrinsics.checkNotNullExpressionValue(r1, "createJavaConstructor(\n …ce(constructor)\n        )");
        LazyJavaResolverContext r2 = ContextKt.childForMethod(getC(), r1, r11, r0.getDeclaredTypeParameters().size());
        LazyJavaScope.ResolvedValueParameters r10 = resolveValueParameters(r2, r1, r11.getValueParameters());
        List<TypeParameterDescriptor> r5 = r0.getDeclaredTypeParameters();
        Intrinsics.checkNotNullExpressionValue(r5, "classDescriptor.declaredTypeParameters");
        List<TypeParameterDescriptor> r6 = r5;
        List<JavaTypeParameter> r7 = r11.getTypeParameters();
        ArrayList r8 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r7, 10));
        Iterator<T> r9 = r7.iterator();
    L4:
        if (r9.hasNext() == false) goto L6;
        JavaTypeParameter r12 = (JavaTypeParameter) r9.next();
        TypeParameterDescriptor r13 = r2.getTypeParameterResolver().resolveTypeParameter(r12);
        Intrinsics.checkNotNull(r13);
        r8.add(r13);
        goto L4
    L6:
        List<TypeParameterDescriptor> r14 = CollectionsKt.plus(r6, r8);
        r1.initialize(r10.getDescriptors(), UtilsKt.toDescriptorVisibility(r11.getVisibility()), r14);
        r1.setHasStableParameterNames(false);
        r1.setHasSynthesizedParameterNames(r10.getHasSynthesizedNames());
        r1.setReturnType(r0.getDefaultType());
        r2.getComponents().getJavaResolverCache().recordConstructor(r3, r1);
        return r1;
    }

    private final ClassConstructorDescriptor createDefaultConstructor() {
        boolean r0 = this.jClass.isAnnotationType();
        if (this.jClass.isInterface() == false) goto L5;
    L6:
        if (r0 == true) goto L9;
        return null;
    L9:
        ClassDescriptor r1 = getOwnerDescriptor();
        JavaClassConstructorDescriptor r2 = JavaClassConstructorDescriptor.createJavaConstructor(r1, Annotations.Companion.getEMPTY(), true, getC().getComponents().getSourceElementFactory().source(this.jClass));
        Intrinsics.checkNotNullExpressionValue(r2, "createJavaConstructor(\n ….source(jClass)\n        )");
        if (r0 == false) goto L12;
        List<ValueParameterDescriptor> r3 = createAnnotationConstructorParameters(r2);
    L13:
        r2.setHasSynthesizedParameterNames(false);
        r2.initialize(r3, getConstructorVisibility(r1));
        r2.setHasStableParameterNames(true);
        r2.setReturnType(r1.getDefaultType());
        getC().getComponents().getJavaResolverCache().recordConstructor(this.jClass, r2);
        return r2;
    L12:
        r3 = Collections.emptyList();
        goto L13
    L5:
        if (this.jClass.hasDefaultConstructor() == true) goto L9;
        goto L6
    }

    private final DescriptorVisibility getConstructorVisibility(ClassDescriptor r1) {
        DescriptorVisibility r0 = r1.getVisibility();
        Intrinsics.checkNotNullExpressionValue(r0, "classDescriptor.visibility");
        if (Intrinsics.areEqual(r0, JavaDescriptorVisibilities.PROTECTED_STATIC_VISIBILITY) == false) goto L6;
        DescriptorVisibility r2 = JavaDescriptorVisibilities.PROTECTED_AND_PACKAGE;
        Intrinsics.checkNotNullExpressionValue(r2, "PROTECTED_AND_PACKAGE");
        return r2;
    L6:
        return r0;
    }

    private final List<ValueParameterDescriptor> createAnnotationConstructorParameters(ClassConstructorDescriptorImpl r16) {
        Collection<JavaMethod> r0 = this.jClass.getMethods();
        ArrayList r8 = new ArrayList(r0.size());
        JavaTypeAttributes r9 = JavaTypeAttributesKt.toAttributes$default(TypeUsage.COMMON, true, false, null, 6, null);
        ArrayList r1 = new ArrayList();
        ArrayList r2 = new ArrayList();
        Iterator<T> r3 = r0.iterator();
    L4:
        if (r3.hasNext() == false) goto L9;
        Object r4 = r3.next();
        if (Intrinsics.areEqual(((JavaMethod) r4).getName(), JvmAnnotationNames.DEFAULT_ANNOTATION_MEMBER_NAME) == true) goto L7;
        r2.add(r4);
        goto L4
    L7:
        r1.add(r4);
        goto L4
    L9:
        Pair r5 = new Pair(r1, r2);
        List r6 = (List) r5.component1();
        List r10 = (List) r5.component2();
        r6.size();
        JavaMethod r11 = (JavaMethod) CollectionsKt.firstOrNull(r6);
        int r12 = 1;
        if (r11 == null) goto L16;
        JavaType r7 = r11.getReturnType();
        if ((r7 instanceof JavaArrayType) == false) goto L14;
        JavaArrayType r13 = (JavaArrayType) r7;
        Pair r14 = new Pair(getC().getTypeResolver().transformArrayType(r13, r9, true), getC().getTypeResolver().transformJavaType(r13.getComponentType(), r9));
    L15:
        addAnnotationValueParameter(r8, r16, 0, r11, (KotlinType) r14.component1(), (KotlinType) r14.component2());
        goto L16
    L14:
        r14 = new Pair(getC().getTypeResolver().transformJavaType(r7, r9), null);
    L16:
        int r15 = 0;
        if (r11 != null) goto L20;
        r12 = 0;
    L20:
        Iterator r17 = r10.iterator();
    L22:
        if (r17.hasNext() == false) goto L25;
        JavaMethod r18 = (JavaMethod) r17.next();
        addAnnotationValueParameter(r8, r16, r15 + r12, r18, getC().getTypeResolver().transformJavaType(r18.getReturnType(), r9), null);
        r15 = r15 + 1;
        goto L22
    L25:
        return r8;
    }

    private final void addAnnotationValueParameter(List<ValueParameterDescriptor> r14, ConstructorDescriptor r15, int r16, JavaMethod r17, KotlinType r18, KotlinType r19) {
        ConstructorDescriptor r1 = r15;
        Annotations r4 = Annotations.Companion.getEMPTY();
        Name r5 = r17.getName();
        KotlinType r6 = TypeUtils.makeNotNullable(r18);
        Intrinsics.checkNotNullExpressionValue(r6, "makeNotNullable(returnType)");
        boolean r7 = r17.getHasAnnotationParameterDefaultValue();
        if (r19 == null) goto L5;
        KotlinType r0 = TypeUtils.makeNotNullable(r19);
    L6:
        r14.add(new ValueParameterDescriptorImpl(r1, null, r16, r4, r5, r6, r7, false, false, r0, getC().getComponents().getSourceElementFactory().source(r17)));
        return;
    L5:
        r0 = null;
        goto L6
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    protected ReceiverParameterDescriptor getDispatchReceiverParameter() {
        return DescriptorUtils.getDispatchReceiverParameterIfNeeded(getOwnerDescriptor());
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    /* JADX INFO: renamed from: getContributedClassifier */
    public ClassifierDescriptor mo2085getContributedClassifier(Name r2, LookupLocation r3) {
        Intrinsics.checkNotNullParameter(r2, "name");
        Intrinsics.checkNotNullParameter(r3, BatteryTypeInf.BATTERY_LOC_API);
        mo2089recordLookup(r2, r3);
        LazyJavaClassMemberScope r4 = (LazyJavaClassMemberScope) getMainScope();
        if (r4 == null) goto L10;
        MemoizedFunctionToNullable<Name, ClassDescriptorBase> r5 = r4.nestedClasses;
        if (r5 == null) goto L10;
        ClassDescriptorBase r6 = r5.invoke(r2);
        if (r6 == null) goto L10;
        return r6;
    L10:
        return this.nestedClasses.invoke(r2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public Collection<SimpleFunctionDescriptor> getContributedFunctions(Name r2, LookupLocation r3) {
        Intrinsics.checkNotNullParameter(r2, "name");
        Intrinsics.checkNotNullParameter(r3, BatteryTypeInf.BATTERY_LOC_API);
        mo2089recordLookup(r2, r3);
        return super.getContributedFunctions(r2, r3);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public Collection<PropertyDescriptor> getContributedVariables(Name r2, LookupLocation r3) {
        Intrinsics.checkNotNullParameter(r2, "name");
        Intrinsics.checkNotNullParameter(r3, BatteryTypeInf.BATTERY_LOC_API);
        mo2089recordLookup(r2, r3);
        return super.getContributedVariables(r2, r3);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    protected Set<Name> computeClassNames(DescriptorKindFilter r1, Function1<? super Name, Boolean> r2) {
        Intrinsics.checkNotNullParameter(r1, "kindFilter");
        return SetsKt.plus(this.nestedClassIndex.invoke(), this.enumEntryIndex.invoke().keySet());
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    protected Set<Name> computePropertyNames(DescriptorKindFilter r2, Function1<? super Name, Boolean> r3) {
        Intrinsics.checkNotNullParameter(r2, "kindFilter");
        if (this.jClass.isAnnotationType() == true) goto L5;
        LinkedHashSet r4 = new LinkedHashSet(getDeclaredMemberIndex().invoke().getFieldNames());
        Collection<KotlinType> r1 = getOwnerDescriptor().getTypeConstructor().mo2084getSupertypes();
        Intrinsics.checkNotNullExpressionValue(r1, "ownerDescriptor.typeConstructor.supertypes");
        Iterator<T> r5 = r1.iterator();
    L8:
        if (r5.hasNext() == false) goto L11;
        LinkedHashSet r0 = r4;
        CollectionsKt.addAll(r0, ((KotlinType) r5.next()).getMemberScope().getVariableNames());
        goto L8
    L11:
        return r4;
    L5:
        return getFunctionNames();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    /* JADX INFO: renamed from: recordLookup */
    public void mo2089recordLookup(Name r2, LookupLocation r3) {
        Intrinsics.checkNotNullParameter(r2, "name");
        Intrinsics.checkNotNullParameter(r3, BatteryTypeInf.BATTERY_LOC_API);
        kotlin.reflect.jvm.internal.impl.incremental.UtilsKt.record(getC().getComponents().getLookupTracker(), r3, getOwnerDescriptor(), r2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    public String toString() {
        return "Lazy Java member scope for " + this.jClass.getFqName();
    }
}
