package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import com.bytedance.apm.battery.config.BatteryTypeInf;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ValueParameterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.load.java.UtilsKt;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaMethodDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaPropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.ContextKt;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaAnnotationsKt;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeAttributes;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeAttributesKt;
import kotlin.reflect.jvm.internal.impl.load.java.sources.JavaSourceElement;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaArrayType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaField;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMethod;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameter;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaValueParameter;
import kotlin.reflect.jvm.internal.impl.load.kotlin.MethodSignatureMappingKt;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorFactory;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindExclude;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNotNull;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNullable;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeUsage;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;

/* JADX INFO: compiled from: LazyJavaScope.kt */
/* JADX INFO: loaded from: classes4.dex */
public abstract class LazyJavaScope extends MemberScopeImpl {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = null;
    private final NotNullLazyValue<Collection<DeclarationDescriptor>> allDescriptors;
    private final LazyJavaResolverContext c;
    private final NotNullLazyValue classNamesLazy$delegate;
    private final MemoizedFunctionToNullable<Name, PropertyDescriptor> declaredField;
    private final MemoizedFunctionToNotNull<Name, Collection<SimpleFunctionDescriptor>> declaredFunctions;
    private final NotNullLazyValue<DeclaredMemberIndex> declaredMemberIndex;
    private final NotNullLazyValue functionNamesLazy$delegate;
    private final MemoizedFunctionToNotNull<Name, Collection<SimpleFunctionDescriptor>> functions;
    private final LazyJavaScope mainScope;
    private final MemoizedFunctionToNotNull<Name, List<PropertyDescriptor>> properties;
    private final NotNullLazyValue propertyNamesLazy$delegate;

    /* JADX INFO: compiled from: LazyJavaScope.kt */
    protected static final class MethodSignatureData {
        private final List<String> errors;
        private final boolean hasStableParameterNames;
        private final KotlinType receiverType;
        private final KotlinType returnType;
        private final List<TypeParameterDescriptor> typeParameters;
        private final List<ValueParameterDescriptor> valueParameters;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof MethodSignatureData) == true) goto L8;
            return false;
        L8:
            MethodSignatureData r6 = (MethodSignatureData) r5;
            if (Intrinsics.areEqual(this.returnType, r6.returnType) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.receiverType, r6.receiverType) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.valueParameters, r6.valueParameters) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.typeParameters, r6.typeParameters) == true) goto L21;
            return false;
        L21:
            if (this.hasStableParameterNames == r6.hasStableParameterNames) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.errors, r6.errors) == true) goto L26;
            return false;
        L26:
            return true;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v9, types: [int] */
        /* JADX WARN: Type inference failed for: r1v11 */
        /* JADX WARN: Type inference failed for: r1v8, types: [int] */
        /* JADX WARN: Type inference failed for: r1v9 */
        public int hashCode() {
            int r0 = this.returnType.hashCode() * 31;
            KotlinType r1 = this.receiverType;
            if (r1 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = (((((r0 + r2) * 31) + this.valueParameters.hashCode()) * 31) + this.typeParameters.hashCode()) * 31;
            boolean r4 = this.hasStableParameterNames;
            ?? r5 = r4;
            if (r4 == false) goto L10;
            r5 = 1;
        L10:
            return ((r3 + r5) * 31) + this.errors.hashCode();
        L5:
            r2 = r1.hashCode();
            goto L6
        }

        public String toString() {
            return "MethodSignatureData(returnType=" + this.returnType + ", receiverType=" + this.receiverType + ", valueParameters=" + this.valueParameters + ", typeParameters=" + this.typeParameters + ", hasStableParameterNames=" + this.hasStableParameterNames + ", errors=" + this.errors + ')';
        }

        /* JADX WARN: Multi-variable type inference failed */
        public MethodSignatureData(KotlinType r2, KotlinType r3, List<? extends ValueParameterDescriptor> r4, List<? extends TypeParameterDescriptor> r5, boolean r6, List<String> r7) {
            Intrinsics.checkNotNullParameter(r2, "returnType");
            Intrinsics.checkNotNullParameter(r4, "valueParameters");
            Intrinsics.checkNotNullParameter(r5, "typeParameters");
            Intrinsics.checkNotNullParameter(r7, "errors");
            this.returnType = r2;
            this.receiverType = r3;
            this.valueParameters = r4;
            this.typeParameters = r5;
            this.hasStableParameterNames = r6;
            this.errors = r7;
        }

        public final KotlinType getReturnType() {
            return this.returnType;
        }

        public final KotlinType getReceiverType() {
            return this.receiverType;
        }

        public final List<ValueParameterDescriptor> getValueParameters() {
            return this.valueParameters;
        }

        public final List<TypeParameterDescriptor> getTypeParameters() {
            return this.typeParameters;
        }

        public final boolean getHasStableParameterNames() {
            return this.hasStableParameterNames;
        }

        public final List<String> getErrors() {
            return this.errors;
        }
    }

    /* JADX INFO: compiled from: LazyJavaScope.kt */
    protected static final class ResolvedValueParameters {
        private final List<ValueParameterDescriptor> descriptors;
        private final boolean hasSynthesizedNames;

        /* JADX WARN: Multi-variable type inference failed */
        public ResolvedValueParameters(List<? extends ValueParameterDescriptor> r2, boolean r3) {
            Intrinsics.checkNotNullParameter(r2, "descriptors");
            this.descriptors = r2;
            this.hasSynthesizedNames = r3;
        }

        public final List<ValueParameterDescriptor> getDescriptors() {
            return this.descriptors;
        }

        public final boolean getHasSynthesizedNames() {
            return this.hasSynthesizedNames;
        }
    }

    protected abstract Set<Name> computeClassNames(DescriptorKindFilter r1, Function1<? super Name, Boolean> r2);

    protected abstract Set<Name> computeFunctionNames(DescriptorKindFilter r1, Function1<? super Name, Boolean> r2);

    protected void computeImplicitlyDeclaredFunctions(Collection<SimpleFunctionDescriptor> r1, Name r2) {
        Intrinsics.checkNotNullParameter(r1, "result");
        Intrinsics.checkNotNullParameter(r2, "name");
    }

    protected abstract DeclaredMemberIndex computeMemberIndex();

    protected abstract void computeNonDeclaredFunctions(Collection<SimpleFunctionDescriptor> r1, Name r2);

    protected abstract void computeNonDeclaredProperties(Name r1, Collection<PropertyDescriptor> r2);

    protected abstract Set<Name> computePropertyNames(DescriptorKindFilter r1, Function1<? super Name, Boolean> r2);

    protected abstract ReceiverParameterDescriptor getDispatchReceiverParameter();

    protected abstract DeclarationDescriptor getOwnerDescriptor();

    protected boolean isVisibleAsFunction(JavaMethodDescriptor r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return true;
    }

    protected abstract MethodSignatureData resolveMethodSignature(JavaMethod r1, List<? extends TypeParameterDescriptor> r2, KotlinType r3, List<? extends ValueParameterDescriptor> r4);

    public /* synthetic */ LazyJavaScope(LazyJavaResolverContext r1, LazyJavaScope r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2);
    }

    public static final /* synthetic */ MemoizedFunctionToNullable access$getDeclaredField$p(LazyJavaScope r0) {
        return r0.declaredField;
    }

    public static final /* synthetic */ MemoizedFunctionToNotNull access$getDeclaredFunctions$p(LazyJavaScope r0) {
        return r0.declaredFunctions;
    }

    public static final /* synthetic */ PropertyDescriptor access$resolveProperty(LazyJavaScope r0, JavaField r1) {
        return r0.resolveProperty(r1);
    }

    public static final /* synthetic */ void access$retainMostSpecificMethods(LazyJavaScope r0, Set r1) {
        r0.retainMostSpecificMethods(r1);
    }

    protected final LazyJavaResolverContext getC() {
        return this.c;
    }

    protected final LazyJavaScope getMainScope() {
        return this.mainScope;
    }

    public LazyJavaScope(LazyJavaResolverContext r3, LazyJavaScope r4) {
        Intrinsics.checkNotNullParameter(r3, "c");
        this.c = r3;
        this.mainScope = r4;
        this.allDescriptors = r3.getStorageManager().createRecursionTolerantLazyValue(new LazyJavaScope$allDescriptors$1(this), CollectionsKt.emptyList());
        this.declaredMemberIndex = r3.getStorageManager().createLazyValue(new LazyJavaScope$declaredMemberIndex$1(this));
        this.declaredFunctions = r3.getStorageManager().createMemoizedFunction(new LazyJavaScope$declaredFunctions$1(this));
        this.declaredField = r3.getStorageManager().createMemoizedFunctionWithNullableValues(new LazyJavaScope$declaredField$1(this));
        this.functions = r3.getStorageManager().createMemoizedFunction(new LazyJavaScope$functions$1(this));
        this.functionNamesLazy$delegate = r3.getStorageManager().createLazyValue(new LazyJavaScope$functionNamesLazy$2(this));
        this.propertyNamesLazy$delegate = r3.getStorageManager().createLazyValue(new LazyJavaScope$propertyNamesLazy$2(this));
        this.classNamesLazy$delegate = r3.getStorageManager().createLazyValue(new LazyJavaScope$classNamesLazy$2(this));
        this.properties = r3.getStorageManager().createMemoizedFunction(new LazyJavaScope$properties$1(this));
    }

    protected final NotNullLazyValue<Collection<DeclarationDescriptor>> getAllDescriptors() {
        return this.allDescriptors;
    }

    protected final NotNullLazyValue<DeclaredMemberIndex> getDeclaredMemberIndex() {
        return this.declaredMemberIndex;
    }

    private final void retainMostSpecificMethods(Set<SimpleFunctionDescriptor> r7) {
        LinkedHashMap r0 = new LinkedHashMap();
        Iterator<T> r6 = r7.iterator();
    L4:
        if (r6.hasNext() == false) goto L9;
        Object r1 = r6.next();
        String r2 = MethodSignatureMappingKt.computeJvmDescriptor$default((SimpleFunctionDescriptor) r1, false, false, 2, null);
        Object r3 = r0.get(r2);
        if (r3 != null) goto L8;
        r3 = (List) new ArrayList();
        r0.put(r2, r3);
    L8:
        ((List) r3).add(r1);
        goto L4
    L9:
        Iterator r8 = r0.values().iterator();
    L11:
        if (r8.hasNext() == false) goto L15;
        List r4 = (List) r8.next();
        if (r4.size() == 1) goto L11;
        List r5 = r4;
        Collection<? extends SimpleFunctionDescriptor> r9 = OverridingUtilsKt.selectMostSpecificInEachOverridableGroup(r5, LazyJavaScope$retainMostSpecificMethods$mostSpecificMethods$1.INSTANCE);
        r7.removeAll(r5);
        r7.addAll(r9);
        goto L11
    }

    protected final JavaMethodDescriptor resolveMethodToFunctionDescriptor(JavaMethod r20) {
        Intrinsics.checkNotNullParameter(r20, "method");
        Annotations r2 = LazyJavaAnnotationsKt.resolveAnnotations(this.c, r20);
        DeclarationDescriptor r3 = getOwnerDescriptor();
        Name r4 = r20.getName();
        JavaSourceElement r5 = this.c.getComponents().getSourceElementFactory().source(r20);
        if (this.declaredMemberIndex.invoke().findRecordComponentByName(r20.getName()) != null) goto L5;
    L7:
        boolean r6 = false;
    L8:
        JavaMethodDescriptor r7 = JavaMethodDescriptor.createJavaMethod(r3, r2, r4, r5, r6);
        Intrinsics.checkNotNullExpressionValue(r7, "createJavaMethod(\n      …eters.isEmpty()\n        )");
        LazyJavaResolverContext r8 = ContextKt.childForMethod$default(this.c, r7, r20, 0, 4, null);
        List<JavaTypeParameter> r9 = r20.getTypeParameters();
        ArrayList r10 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r9, 10));
        Iterator<T> r11 = r9.iterator();
    L10:
        if (r11.hasNext() == false) goto L12;
        TypeParameterDescriptor r12 = r8.getTypeParameterResolver().resolveTypeParameter((JavaTypeParameter) r11.next());
        Intrinsics.checkNotNull(r12);
        r10.add(r12);
        goto L10
    L12:
        ResolvedValueParameters r13 = resolveValueParameters(r8, r7, r20.getValueParameters());
        MethodSignatureData r14 = resolveMethodSignature(r20, r10, computeMethodReturnType(r20, r8), r13.getDescriptors());
        KotlinType r15 = r14.getReceiverType();
        if (r15 == null) goto L15;
        ReceiverParameterDescriptor r16 = DescriptorFactory.createExtensionReceiverParameterForCallable(r7, r15, Annotations.Companion.getEMPTY());
    L16:
        ReceiverParameterDescriptor r17 = r16;
        ReceiverParameterDescriptor r18 = getDispatchReceiverParameter();
        List<ReceiverParameterDescriptor> r19 = CollectionsKt.emptyList();
        List<TypeParameterDescriptor> r110 = r14.getTypeParameters();
        List<ValueParameterDescriptor> r111 = r14.getValueParameters();
        KotlinType r112 = r14.getReturnType();
        Modality r113 = Modality.Companion.convertFromFlags(false, r20.isAbstract(), !r20.isFinal());
        DescriptorVisibility r114 = UtilsKt.toDescriptorVisibility(r20.getVisibility());
        if (r14.getReceiverType() == null) goto L19;
        Map<? extends CallableDescriptor.UserDataKey<?>, ?> r0 = MapsKt.mapOf(TuplesKt.to(JavaMethodDescriptor.ORIGINAL_VALUE_PARAMETER_FOR_EXTENSION_RECEIVER, CollectionsKt.first(r13.getDescriptors())));
    L20:
        r7.initialize(r17, r18, r19, r110, r111, r112, r113, r114, r0);
        r7.setParameterNamesStatus(r14.getHasStableParameterNames(), r13.getHasSynthesizedNames());
        if ((!r14.getErrors().isEmpty()) == false) goto L23;
        r8.getComponents().getSignaturePropagator().reportSignatureErrors(r7, r14.getErrors());
    L23:
        return r7;
    L19:
        r0 = MapsKt.emptyMap();
        goto L20
    L15:
        r16 = null;
        goto L16
    L5:
        if (r20.getValueParameters().isEmpty() == false) goto L7;
        r6 = true;
        goto L8
    }

    protected final KotlinType computeMethodReturnType(JavaMethod r7, LazyJavaResolverContext r8) {
        Intrinsics.checkNotNullParameter(r7, "method");
        Intrinsics.checkNotNullParameter(r8, "c");
        boolean r1 = r7.getContainingClass().isAnnotationType();
        JavaTypeAttributes r6 = JavaTypeAttributesKt.toAttributes$default(TypeUsage.COMMON, r1, false, null, 6, null);
        return r8.getTypeResolver().transformJavaType(r7.getReturnType(), r6);
    }

    protected final ResolvedValueParameters resolveValueParameters(LazyJavaResolverContext r21, FunctionDescriptor r22, List<? extends JavaValueParameter> r23) {
        Intrinsics.checkNotNullParameter(r21, "c");
        Intrinsics.checkNotNullParameter(r22, "function");
        Intrinsics.checkNotNullParameter(r23, "jValueParameters");
        Iterable r3 = CollectionsKt.withIndex(r23);
        ArrayList r4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r3, 10));
        Iterator r5 = r3.iterator();
        boolean r6 = false;
    L4:
        if (r5.hasNext() == false) goto L29;
        IndexedValue r7 = (IndexedValue) r5.next();
        int r10 = r7.component1();
        JavaValueParameter r8 = (JavaValueParameter) r7.component2();
        Annotations r11 = LazyJavaAnnotationsKt.resolveAnnotations(r21, r8);
        JavaTypeAttributes r9 = JavaTypeAttributesKt.toAttributes$default(TypeUsage.COMMON, false, false, null, 7, null);
        JavaArrayType r12 = null;
        if (r8.isVararg() == false) goto L14;
        JavaType r13 = r8.getType();
        if ((r13 instanceof JavaArrayType) == false) goto L10;
        r12 = (JavaArrayType) r13;
    L10:
        if (r12 == null) goto L13;
        KotlinType r14 = r21.getTypeResolver().transformArrayType(r12, r9, true);
        Pair r15 = TuplesKt.to(r14, r21.getModule().getBuiltIns().getArrayElementType(r14));
    L15:
        KotlinType r16 = (KotlinType) r15.component1();
        KotlinType r17 = (KotlinType) r15.component2();
        if (Intrinsics.areEqual(r22.getName().asString(), "equals") == true) goto L18;
    L22:
        Name r18 = r8.getName();
        if (r18 != null) goto L25;
        r6 = true;
    L25:
        if (r18 != null) goto L27;
        r18 = Name.identifier("p" + r10);
        Intrinsics.checkNotNullExpressionValue(r18, "identifier(\"p$index\")");
    L27:
        Name r19 = r18;
        Intrinsics.checkNotNullExpressionValue(r19, "if (function.name.asStri…(\"p$index\")\n            }");
        r4.add(new ValueParameterDescriptorImpl(r22, null, r10, r11, r19, r16, false, false, false, r17, r21.getComponents().getSourceElementFactory().source(r8)));
        goto L4
    L18:
        if (r23.size() != 1) goto L22;
        if (Intrinsics.areEqual(r21.getModule().getBuiltIns().getNullableAnyType(), r16) == false) goto L22;
        r18 = Name.identifier("other");
        goto L27
    L13:
        throw new AssertionError("Vararg parameter should be an array: " + r8);
    L14:
        r15 = TuplesKt.to(r21.getTypeResolver().transformJavaType(r8.getType(), r9), null);
        goto L15
    L29:
        return new ResolvedValueParameters(CollectionsKt.toList(r4), r6);
    }

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(LazyJavaScope.class), "functionNamesLazy", "getFunctionNamesLazy()Ljava/util/Set;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(LazyJavaScope.class), "propertyNamesLazy", "getPropertyNamesLazy()Ljava/util/Set;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(LazyJavaScope.class), "classNamesLazy", "getClassNamesLazy()Ljava/util/Set;"))};
    }

    private final Set<Name> getFunctionNamesLazy() {
        return (Set) StorageKt.getValue(this.functionNamesLazy$delegate, this, $$delegatedProperties[0]);
    }

    private final Set<Name> getPropertyNamesLazy() {
        return (Set) StorageKt.getValue(this.propertyNamesLazy$delegate, this, $$delegatedProperties[1]);
    }

    private final Set<Name> getClassNamesLazy() {
        return (Set) StorageKt.getValue(this.classNamesLazy$delegate, this, $$delegatedProperties[2]);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public Set<Name> getFunctionNames() {
        return getFunctionNamesLazy();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public Set<Name> getVariableNames() {
        return getPropertyNamesLazy();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public Set<Name> getClassifierNames() {
        return getClassNamesLazy();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public Collection<SimpleFunctionDescriptor> getContributedFunctions(Name r2, LookupLocation r3) {
        Intrinsics.checkNotNullParameter(r2, "name");
        Intrinsics.checkNotNullParameter(r3, BatteryTypeInf.BATTERY_LOC_API);
        if (getFunctionNames().contains(r2) == true) goto L7;
        return CollectionsKt.emptyList();
    L7:
        return this.functions.invoke(r2);
    }

    private final PropertyDescriptor resolveProperty(final JavaField r8) {
        final PropertyDescriptorImpl r6 = createPropertyDescriptor(r8);
        r6.initialize(null, null, null, null);
        r6.setType(getPropertyType(r8), CollectionsKt.emptyList(), getDispatchReceiverParameter(), null, CollectionsKt.emptyList());
        if (DescriptorUtils.shouldRecordInitializerForProperty(r6, r6.getType()) == false) goto L5;
        r6.setCompileTimeInitializerFactory((Function0) new AnonymousClass1(this, r8, r6));
    L5:
        PropertyDescriptorImpl r7 = r6;
        this.c.getComponents().getJavaResolverCache().recordField(r8, r7);
        return r7;
    }

    private final PropertyDescriptorImpl createPropertyDescriptor(JavaField r10) {
        boolean r5 = !r10.isFinal();
        JavaPropertyDescriptor r9 = JavaPropertyDescriptor.create(getOwnerDescriptor(), LazyJavaAnnotationsKt.resolveAnnotations(this.c, r10), Modality.FINAL, UtilsKt.toDescriptorVisibility(r10.getVisibility()), r5, r10.getName(), this.c.getComponents().getSourceElementFactory().source(r10), isFinalStatic(r10));
        Intrinsics.checkNotNullExpressionValue(r9, "create(\n            owne…d.isFinalStatic\n        )");
        return r9;
    }

    private final boolean isFinalStatic(JavaField r1) {
        if (r1.isFinal() == true) goto L5;
    L7:
        return false;
    L5:
        if (r1.isStatic() == false) goto L7;
        return true;
    }

    private final KotlinType getPropertyType(JavaField r9) {
        KotlinType r0 = this.c.getTypeResolver().transformJavaType(r9.getType(), JavaTypeAttributesKt.toAttributes$default(TypeUsage.COMMON, false, false, null, 7, null));
        if (KotlinBuiltIns.isPrimitiveType(r0) == true) goto L7;
        if (KotlinBuiltIns.isString(r0) == true) goto L7;
    L11:
        boolean r8 = false;
    L12:
        if (r8 == false) goto L15;
        KotlinType r10 = TypeUtils.makeNotNullable(r0);
        Intrinsics.checkNotNullExpressionValue(r10, "makeNotNullable(propertyType)");
        return r10;
    L15:
        return r0;
    L7:
        if (isFinalStatic(r9) == false) goto L11;
        if (r9.getHasConstantNotNullInitializer() == false) goto L11;
        r8 = true;
        goto L12
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public Collection<PropertyDescriptor> getContributedVariables(Name r2, LookupLocation r3) {
        Intrinsics.checkNotNullParameter(r2, "name");
        Intrinsics.checkNotNullParameter(r3, BatteryTypeInf.BATTERY_LOC_API);
        if (getVariableNames().contains(r2) == true) goto L7;
        return CollectionsKt.emptyList();
    L7:
        return this.properties.invoke(r2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public Collection<DeclarationDescriptor> getContributedDescriptors(DescriptorKindFilter r2, Function1<? super Name, Boolean> r3) {
        Intrinsics.checkNotNullParameter(r2, "kindFilter");
        Intrinsics.checkNotNullParameter(r3, "nameFilter");
        return this.allDescriptors.invoke();
    }

    protected final List<DeclarationDescriptor> computeDescriptors(DescriptorKindFilter r7, Function1<? super Name, Boolean> r8) {
        Intrinsics.checkNotNullParameter(r7, "kindFilter");
        Intrinsics.checkNotNullParameter(r8, "nameFilter");
        NoLookupLocation r0 = NoLookupLocation.WHEN_GET_ALL_DESCRIPTORS;
        LinkedHashSet r1 = new LinkedHashSet();
        if (r7.acceptsKinds(DescriptorKindFilter.Companion.getCLASSIFIERS_MASK()) == false) goto L11;
        Iterator<Name> r2 = computeClassNames(r7, r8).iterator();
    L6:
        if (r2.hasNext() == false) goto L11;
        Name r3 = r2.next();
        if (r8.invoke(r3).booleanValue() == false) goto L6;
        kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.addIfNotNull(r1, mo2085getContributedClassifier(r3, r0));
    L11:
        if (r7.acceptsKinds(DescriptorKindFilter.Companion.getFUNCTIONS_MASK()) == false) goto L21;
        if (r7.getExcludes().contains(DescriptorKindExclude.NonExtensions.INSTANCE) == true) goto L21;
        Iterator<Name> r4 = computeFunctionNames(r7, r8).iterator();
    L16:
        if (r4.hasNext() == false) goto L21;
        Name r5 = r4.next();
        if (r8.invoke(r5).booleanValue() == false) goto L16;
        r1.addAll(getContributedFunctions(r5, r0));
    L21:
        if (r7.acceptsKinds(DescriptorKindFilter.Companion.getVARIABLES_MASK()) == false) goto L31;
        if (r7.getExcludes().contains(DescriptorKindExclude.NonExtensions.INSTANCE) == true) goto L31;
        Iterator<Name> r9 = computePropertyNames(r7, r8).iterator();
    L26:
        if (r9.hasNext() == false) goto L31;
        Name r6 = r9.next();
        if (r8.invoke(r6).booleanValue() == false) goto L26;
        r1.addAll(getContributedVariables(r6, r0));
    L31:
        return CollectionsKt.toList(r1);
    }

    public String toString() {
        return "Lazy scope for " + getOwnerDescriptor();
    }
}
