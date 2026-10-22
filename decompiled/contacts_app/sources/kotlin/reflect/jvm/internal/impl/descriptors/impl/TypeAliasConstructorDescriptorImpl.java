package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorNonRoot;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithSource;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.name.SpecialNames;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorFactory;
import kotlin.reflect.jvm.internal.impl.storage.NullableLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.FlexibleTypesKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.SpecialTypesKt;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.Variance;

/* JADX INFO: compiled from: TypeAliasConstructorDescriptor.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class TypeAliasConstructorDescriptorImpl extends FunctionDescriptorImpl implements TypeAliasConstructorDescriptor {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = null;
    public static final Companion Companion = null;
    private final StorageManager storageManager;
    private final TypeAliasDescriptor typeAliasDescriptor;
    private ClassConstructorDescriptor underlyingConstructorDescriptor;
    private final NullableLazyValue withDispatchReceiver$delegate;

    /* JADX INFO: compiled from: TypeAliasConstructorDescriptor.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }

        public static final /* synthetic */ TypeSubstitutor access$getTypeSubstitutorForUnderlyingClass(Companion r0, TypeAliasDescriptor r1) {
            return r0.getTypeSubstitutorForUnderlyingClass(r1);
        }

        private final TypeSubstitutor getTypeSubstitutorForUnderlyingClass(TypeAliasDescriptor r1) {
            if (r1.getClassDescriptor() != null) goto L7;
            return null;
        L7:
            return TypeSubstitutor.create(r1.getExpandedType());
        }

        public final TypeAliasConstructorDescriptor createIfAvailable(StorageManager r13, TypeAliasDescriptor r14, ClassConstructorDescriptor r15) {
            Intrinsics.checkNotNullParameter(r13, "storageManager");
            Intrinsics.checkNotNullParameter(r14, "typeAliasDescriptor");
            Intrinsics.checkNotNullParameter(r15, "constructor");
            TypeSubstitutor r12 = getTypeSubstitutorForUnderlyingClass(r14);
            ReceiverParameterDescriptor r0 = null;
            if (r12 != null) goto L5;
            return null;
        L5:
            ClassConstructorDescriptor r10 = r15.substitute(r12);
            if (r10 != null) goto L8;
            return null;
        L8:
            Annotations r6 = r15.getAnnotations();
            CallableMemberDescriptor.Kind r7 = r15.getKind();
            Intrinsics.checkNotNullExpressionValue(r7, "constructor.kind");
            SourceElement r8 = r14.getSource();
            Intrinsics.checkNotNullExpressionValue(r8, "typeAliasDescriptor.source");
            TypeAliasConstructorDescriptorImpl r11 = new TypeAliasConstructorDescriptorImpl(r13, r14, r10, null, r6, r7, r8, null);
            List<ValueParameterDescriptor> r9 = FunctionDescriptorImpl.getSubstitutedValueParameters(r11, r15.getValueParameters(), r12);
            if (r9 != null) goto L11;
            return null;
        L11:
            SimpleType r16 = FlexibleTypesKt.lowerIfFlexible(r10.getReturnType().unwrap());
            SimpleType r1 = r14.getDefaultType();
            Intrinsics.checkNotNullExpressionValue(r1, "typeAliasDescriptor.defaultType");
            SimpleType r17 = SpecialTypesKt.withAbbreviation(r16, r1);
            ReceiverParameterDescriptor r2 = r15.getDispatchReceiverParameter();
            if (r2 == null) goto L14;
            r0 = DescriptorFactory.createExtensionReceiverParameterForCallable(r11, r12.safeSubstitute(r2.getType(), Variance.INVARIANT), Annotations.Companion.getEMPTY());
        L14:
            ReceiverParameterDescriptor r3 = r0;
            ClassDescriptor r4 = r14.getClassDescriptor();
            if (r4 == null) goto L21;
            List<ReceiverParameterDescriptor> r18 = r15.getContextReceiverParameters();
            Intrinsics.checkNotNullExpressionValue(r18, "constructor.contextReceiverParameters");
            List<ReceiverParameterDescriptor> r19 = r18;
            ArrayList r5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r19, 10));
            Iterator<T> r110 = r19.iterator();
        L18:
            if (r110.hasNext() == false) goto L20;
            r5.add(DescriptorFactory.createContextReceiverParameterForClass(r4, r12.safeSubstitute(((ReceiverParameterDescriptor) r110.next()).getType(), Variance.INVARIANT), Annotations.Companion.getEMPTY()));
            goto L18
        L20:
            List<ReceiverParameterDescriptor> r20 = r5;
        L22:
            r11.initialize(r3, null, r20, r14.getDeclaredTypeParameters(), r9, r17, Modality.FINAL, r14.getVisibility());
            return r11;
        L21:
            r20 = CollectionsKt.emptyList();
            goto L22
        }
    }

    public /* synthetic */ TypeAliasConstructorDescriptorImpl(StorageManager r1, TypeAliasDescriptor r2, ClassConstructorDescriptor r3, TypeAliasConstructorDescriptor r4, Annotations r5, CallableMemberDescriptor.Kind r6, SourceElement r7, DefaultConstructorMarker r8) {
        this(r1, r2, r3, r4, r5, r6, r7);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor
    public /* bridge */ /* synthetic */ CallableMemberDescriptor copy(DeclarationDescriptor r1, Modality r2, DescriptorVisibility r3, CallableMemberDescriptor.Kind r4, boolean r5) {
        return copy(r1, r2, r3, r4, r5);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor
    public /* bridge */ /* synthetic */ FunctionDescriptor copy(DeclarationDescriptor r1, Modality r2, DescriptorVisibility r3, CallableMemberDescriptor.Kind r4, boolean r5) {
        return copy(r1, r2, r3, r4, r5);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl
    public /* bridge */ /* synthetic */ FunctionDescriptorImpl createSubstitutedCopy(DeclarationDescriptor r1, FunctionDescriptor r2, CallableMemberDescriptor.Kind r3, Name r4, Annotations r5, SourceElement r6) {
        return createSubstitutedCopy(r1, r2, r3, r4, r5, r6);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorNonRootImpl, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public /* bridge */ /* synthetic */ ClassifierDescriptorWithTypeParameters getContainingDeclaration() {
        return getContainingDeclaration();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorNonRootImpl, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public /* bridge */ /* synthetic */ DeclarationDescriptor getContainingDeclaration() {
        return getContainingDeclaration();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorNonRootImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public /* bridge */ /* synthetic */ CallableDescriptor getOriginal() {
        return getOriginal();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorNonRootImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public /* bridge */ /* synthetic */ CallableMemberDescriptor getOriginal() {
        return getOriginal();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorNonRootImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public /* bridge */ /* synthetic */ DeclarationDescriptor getOriginal() {
        return getOriginal();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorNonRootImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public /* bridge */ /* synthetic */ DeclarationDescriptorWithSource getOriginal() {
        return getOriginal();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorNonRootImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public /* bridge */ /* synthetic */ FunctionDescriptor getOriginal() {
        return getOriginal();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.Substitutable
    public /* bridge */ /* synthetic */ ConstructorDescriptor substitute(TypeSubstitutor r1) {
        return substitute(r1);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.Substitutable
    public /* bridge */ /* synthetic */ DeclarationDescriptorNonRoot substitute(TypeSubstitutor r1) {
        return substitute(r1);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.Substitutable
    public /* bridge */ /* synthetic */ FunctionDescriptor substitute(TypeSubstitutor r1) {
        return substitute(r1);
    }

    public final StorageManager getStorageManager() {
        return this.storageManager;
    }

    public TypeAliasDescriptor getTypeAliasDescriptor() {
        return this.typeAliasDescriptor;
    }

    private TypeAliasConstructorDescriptorImpl(StorageManager r8, TypeAliasDescriptor r9, final ClassConstructorDescriptor r10, TypeAliasConstructorDescriptor r11, Annotations r12, CallableMemberDescriptor.Kind r13, SourceElement r14) {
        super(r9, r11, r12, SpecialNames.INIT, r13, r14);
        this.storageManager = r8;
        this.typeAliasDescriptor = r9;
        setActual(getTypeAliasDescriptor().isActual());
        this.withDispatchReceiver$delegate = r8.createNullableLazyValue(new TypeAliasConstructorDescriptorImpl$withDispatchReceiver$2(this, r10));
        this.underlyingConstructorDescriptor = r10;
    }

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(TypeAliasConstructorDescriptorImpl.class), "withDispatchReceiver", "getWithDispatchReceiver()Lorg/jetbrains/kotlin/descriptors/impl/TypeAliasConstructorDescriptor;"))};
        Companion = new Companion(null);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.TypeAliasConstructorDescriptor
    public ClassConstructorDescriptor getUnderlyingConstructorDescriptor() {
        return this.underlyingConstructorDescriptor;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor
    public boolean isPrimary() {
        return getUnderlyingConstructorDescriptor().isPrimary();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorNonRootImpl, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public TypeAliasDescriptor getContainingDeclaration() {
        return getTypeAliasDescriptor();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor
    public ClassDescriptor getConstructedClass() {
        ClassDescriptor r1 = getUnderlyingConstructorDescriptor().getConstructedClass();
        Intrinsics.checkNotNullExpressionValue(r1, "underlyingConstructorDescriptor.constructedClass");
        return r1;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    public KotlinType getReturnType() {
        KotlinType r0 = super.getReturnType();
        Intrinsics.checkNotNull(r0);
        return r0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorNonRootImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public TypeAliasConstructorDescriptor getOriginal() {
        FunctionDescriptor r1 = super.getOriginal();
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.impl.TypeAliasConstructorDescriptor");
        return (TypeAliasConstructorDescriptor) r1;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.Substitutable
    public TypeAliasConstructorDescriptor substitute(TypeSubstitutor r3) {
        Intrinsics.checkNotNullParameter(r3, "substitutor");
        FunctionDescriptor r4 = super.substitute(r3);
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.impl.TypeAliasConstructorDescriptorImpl");
        TypeAliasConstructorDescriptorImpl r5 = (TypeAliasConstructorDescriptorImpl) r4;
        TypeSubstitutor r0 = TypeSubstitutor.create(r5.getReturnType());
        Intrinsics.checkNotNullExpressionValue(r0, "create(substitutedTypeAliasConstructor.returnType)");
        ClassConstructorDescriptor r2 = getUnderlyingConstructorDescriptor().getOriginal().substitute(r0);
        if (r2 != null) goto L6;
        return null;
    L6:
        r5.underlyingConstructorDescriptor = r2;
        return r5;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor
    public TypeAliasConstructorDescriptor copy(DeclarationDescriptor r2, Modality r3, DescriptorVisibility r4, CallableMemberDescriptor.Kind r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r2, "newOwner");
        Intrinsics.checkNotNullParameter(r3, "modality");
        Intrinsics.checkNotNullParameter(r4, "visibility");
        Intrinsics.checkNotNullParameter(r5, "kind");
        FunctionDescriptor r1 = newCopyBuilder().setOwner(r2).setModality(r3).setVisibility(r4).setKind(r5).setCopyOverrides(r6).build();
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.impl.TypeAliasConstructorDescriptor");
        return (TypeAliasConstructorDescriptor) r1;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl
    protected TypeAliasConstructorDescriptorImpl createSubstitutedCopy(DeclarationDescriptor r9, FunctionDescriptor r10, CallableMemberDescriptor.Kind r11, Name r12, Annotations r13, SourceElement r14) {
        Intrinsics.checkNotNullParameter(r9, "newOwner");
        Intrinsics.checkNotNullParameter(r11, "kind");
        Intrinsics.checkNotNullParameter(r13, "annotations");
        Intrinsics.checkNotNullParameter(r14, "source");
        if (r11 == CallableMemberDescriptor.Kind.DECLARATION) goto L6;
        CallableMemberDescriptor.Kind r15 = CallableMemberDescriptor.Kind.SYNTHESIZED;
    L6:
        return new TypeAliasConstructorDescriptorImpl(this.storageManager, getTypeAliasDescriptor(), getUnderlyingConstructorDescriptor(), this, r13, CallableMemberDescriptor.Kind.DECLARATION, r14);
    }
}
