package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorNonRoot;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueClassRepresentation;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.SubstitutingScope;
import kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager;
import kotlin.reflect.jvm.internal.impl.types.ClassTypeConstructorImpl;
import kotlin.reflect.jvm.internal.impl.types.DefaultTypeAttributeTranslator;
import kotlin.reflect.jvm.internal.impl.types.DescriptorSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitution;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;

/* JADX INFO: loaded from: classes4.dex */
public class LazySubstitutingClassDescriptor extends ModuleAwareClassDescriptor {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private List<TypeParameterDescriptor> declaredTypeParameters;
    private TypeSubstitutor newSubstitutor;
    private final ModuleAwareClassDescriptor original;
    private final TypeSubstitutor originalSubstitutor;
    private TypeConstructor typeConstructor;
    private List<TypeParameterDescriptor> typeConstructorParameters;

    private static /* synthetic */ void $$$reportNull$$$0(int r15) {
        if (r15 == 2) goto L12;
        if (r15 == 3) goto L12;
        if (r15 == 5) goto L12;
        if (r15 == 6) goto L12;
        if (r15 == 8) goto L12;
        if (r15 == 10) goto L12;
        if (r15 == 13) goto L12;
        if (r15 == 23) goto L12;
        String r8 = "@NotNull method %s.%s must not return null";
    L13:
        if (r15 == 2) goto L22;
        if (r15 == 3) goto L22;
        if (r15 == 5) goto L22;
        if (r15 == 6) goto L22;
        if (r15 == 8) goto L22;
        if (r15 == 10) goto L22;
        if (r15 == 13) goto L22;
        if (r15 == 23) goto L22;
        int r9 = 2;
    L23:
        Object[] r10 = new Object[r9];
        if (r15 == 2) goto L36;
        if (r15 == 3) goto L35;
        if (r15 == 5) goto L34;
        if (r15 == 6) goto L35;
        if (r15 == 8) goto L36;
        if (r15 == 10) goto L34;
        if (r15 == 13) goto L35;
        if (r15 == 23) goto L33;
        r10[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/LazySubstitutingClassDescriptor";
    L38:
        switch(r15) {
            case 2: goto L58;
            case 3: goto L58;
            case 4: goto L57;
            case 5: goto L58;
            case 6: goto L58;
            case 7: goto L57;
            case 8: goto L58;
            case 9: goto L57;
            case 10: goto L58;
            case 11: goto L57;
            case 12: goto L56;
            case 13: goto L58;
            case 14: goto L56;
            case 15: goto L55;
            case 16: goto L54;
            case 17: goto L53;
            case 18: goto L52;
            case 19: goto L51;
            case 20: goto L50;
            case 21: goto L49;
            case 22: goto L48;
            case 23: goto L58;
            case 24: goto L47;
            case 25: goto L46;
            case 26: goto L45;
            case 27: goto L44;
            case 28: goto L43;
            case 29: goto L42;
            case 30: goto L41;
            case 31: goto L40;
            default: goto L39;
        };
    L39:
        r10[1] = "getTypeConstructor";
    L59:
        if (r15 == 2) goto L70;
        if (r15 == 3) goto L70;
        if (r15 == 5) goto L70;
        if (r15 == 6) goto L70;
        if (r15 == 8) goto L70;
        if (r15 == 10) goto L70;
        if (r15 == 13) goto L69;
        if (r15 != 23) goto L71;
        r10[2] = "substitute";
    L71:
        String r11 = String.format(r8, r10);
        if (r15 == 2) goto L82;
        if (r15 == 3) goto L82;
        if (r15 == 5) goto L82;
        if (r15 == 6) goto L82;
        if (r15 == 8) goto L82;
        if (r15 == 10) goto L82;
        if (r15 == 13) goto L82;
        if (r15 == 23) goto L82;
        throw new IllegalStateException(r11);
    L82:
        throw new IllegalArgumentException(r11);
    L69:
        r10[2] = "getUnsubstitutedMemberScope";
    L70:
        r10[2] = "getMemberScope";
        goto L71
    L40:
        r10[1] = "getSealedSubclasses";
        goto L59
    L41:
        r10[1] = "getDeclaredTypeParameters";
        goto L59
    L42:
        r10[1] = "getSource";
        goto L59
    L43:
        r10[1] = "getUnsubstitutedInnerClassesScope";
        goto L59
    L44:
        r10[1] = "getVisibility";
        goto L59
    L45:
        r10[1] = "getModality";
        goto L59
    L46:
        r10[1] = "getKind";
        goto L59
    L47:
        r10[1] = "substitute";
        goto L59
    L48:
        r10[1] = "getContainingDeclaration";
        goto L59
    L49:
        r10[1] = "getOriginal";
        goto L59
    L50:
        r10[1] = "getName";
        goto L59
    L51:
        r10[1] = "getAnnotations";
        goto L59
    L52:
        r10[1] = "getConstructors";
        goto L59
    L53:
        r10[1] = "getContextReceivers";
        goto L59
    L54:
        r10[1] = "getDefaultType";
        goto L59
    L55:
        r10[1] = "getStaticScope";
        goto L59
    L56:
        r10[1] = "getUnsubstitutedMemberScope";
        goto L59
    L57:
        r10[1] = "getMemberScope";
        goto L59
    L58:
        r10[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/LazySubstitutingClassDescriptor";
        goto L59
    L33:
        r10[0] = "substitutor";
    L34:
        r10[0] = "typeSubstitution";
    L35:
        r10[0] = "kotlinTypeRefiner";
    L36:
        r10[0] = "typeArguments";
    L22:
        r9 = 3;
    L12:
        r8 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        goto L13
    }

    static {
    }

    static /* synthetic */ SimpleType access$000(LazySubstitutingClassDescriptor r0, SimpleType r1) {
        return r0.substituteSimpleType(r1);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public /* bridge */ /* synthetic */ ClassifierDescriptor getOriginal() {
        return getOriginal();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public /* bridge */ /* synthetic */ DeclarationDescriptor getOriginal() {
        return getOriginal();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.Substitutable
    public /* bridge */ /* synthetic */ DeclarationDescriptorNonRoot substitute(TypeSubstitutor r1) {
        return substitute(r1);
    }

    public LazySubstitutingClassDescriptor(ModuleAwareClassDescriptor r1, TypeSubstitutor r2) {
        this.original = r1;
        this.originalSubstitutor = r2;
    }

    private TypeSubstitutor getSubstitutor() {
        if (this.newSubstitutor != null) goto L9;
        if (this.originalSubstitutor.isEmpty() == false) goto L7;
        this.newSubstitutor = this.originalSubstitutor;
        goto L9
    L7:
        List<TypeParameterDescriptor> r0 = this.original.getTypeConstructor().getParameters();
        this.typeConstructorParameters = new ArrayList(r0.size());
        this.newSubstitutor = DescriptorSubstitutor.substituteTypeParameters(r0, this.originalSubstitutor.getSubstitution(), this, this.typeConstructorParameters);
        this.declaredTypeParameters = CollectionsKt.filter(this.typeConstructorParameters, new AnonymousClass1(this));
    L9:
        return this.newSubstitutor;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor
    public TypeConstructor getTypeConstructor() {
        TypeConstructor r0 = this.original.getTypeConstructor();
        if (this.originalSubstitutor.isEmpty() == false) goto L8;
        if (r0 != null) goto L6;
        $$$reportNull$$$0(0);
    L6:
        return r0;
    L8:
        if (this.typeConstructor != null) goto L14;
        TypeSubstitutor r1 = getSubstitutor();
        Collection<KotlinType> r2 = r0.mo2084getSupertypes();
        ArrayList r3 = new ArrayList(r2.size());
        Iterator<KotlinType> r4 = r2.iterator();
    L11:
        if (r4.hasNext() == false) goto L13;
        r3.add(r1.substitute(r4.next(), Variance.INVARIANT));
        goto L11
    L13:
        this.typeConstructor = new ClassTypeConstructorImpl(this, this.typeConstructorParameters, r3, LockBasedStorageManager.NO_LOCKS);
    L14:
        TypeConstructor r5 = this.typeConstructor;
        if (r5 != null) goto L17;
        $$$reportNull$$$0(1);
    L17:
        return r5;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleAwareClassDescriptor
    public MemberScope getMemberScope(TypeSubstitution r2, KotlinTypeRefiner r3) {
        if (r2 != null) goto L4;
        $$$reportNull$$$0(5);
    L4:
        if (r3 != null) goto L6;
        $$$reportNull$$$0(6);
    L6:
        MemberScope r4 = this.original.getMemberScope(r2, r3);
        if (this.originalSubstitutor.isEmpty() == false) goto L12;
        if (r4 != null) goto L10;
        $$$reportNull$$$0(7);
    L10:
        return r4;
    L12:
        return new SubstitutingScope(r4, getSubstitutor());
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public MemberScope getMemberScope(TypeSubstitution r2) {
        if (r2 != null) goto L4;
        $$$reportNull$$$0(10);
    L4:
        MemberScope r1 = getMemberScope(r2, DescriptorUtilsKt.getKotlinTypeRefiner(DescriptorUtils.getContainingModule(this)));
        if (r1 != null) goto L7;
        $$$reportNull$$$0(11);
    L7:
        return r1;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public MemberScope getUnsubstitutedMemberScope() {
        MemberScope r1 = getUnsubstitutedMemberScope(DescriptorUtilsKt.getKotlinTypeRefiner(DescriptorUtils.getContainingModule(this.original)));
        if (r1 != null) goto L5;
        $$$reportNull$$$0(12);
    L5:
        return r1;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleAwareClassDescriptor
    public MemberScope getUnsubstitutedMemberScope(KotlinTypeRefiner r2) {
        if (r2 != null) goto L4;
        $$$reportNull$$$0(13);
    L4:
        MemberScope r3 = this.original.getUnsubstitutedMemberScope(r2);
        if (this.originalSubstitutor.isEmpty() == false) goto L10;
        if (r3 != null) goto L8;
        $$$reportNull$$$0(14);
    L8:
        return r3;
    L10:
        return new SubstitutingScope(r3, getSubstitutor());
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public MemberScope getStaticScope() {
        MemberScope r1 = this.original.getStaticScope();
        if (r1 != null) goto L5;
        $$$reportNull$$$0(15);
    L5:
        return r1;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor
    public SimpleType getDefaultType() {
        List<TypeProjection> r0 = TypeUtils.getDefaultTypeProjections(getTypeConstructor().getParameters());
        SimpleType r4 = KotlinTypeFactory.simpleTypeWithNonTrivialMemberScope(DefaultTypeAttributeTranslator.INSTANCE.toAttributes(getAnnotations(), null, null), getTypeConstructor(), r0, false, getUnsubstitutedMemberScope());
        if (r4 != null) goto L5;
        $$$reportNull$$$0(16);
    L5:
        return r4;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public ReceiverParameterDescriptor getThisAsReceiverParameter() {
        throw new UnsupportedOperationException();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public List<ReceiverParameterDescriptor> getContextReceivers() {
        List<ReceiverParameterDescriptor> r1 = Collections.emptyList();
        if (r1 != null) goto L5;
        $$$reportNull$$$0(17);
    L5:
        return r1;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public Collection<ClassConstructorDescriptor> getConstructors() {
        Collection<ClassConstructorDescriptor> r0 = this.original.getConstructors();
        ArrayList r1 = new ArrayList(r0.size());
        Iterator<ClassConstructorDescriptor> r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        ClassConstructorDescriptor r3 = r2.next();
        r1.add(((ClassConstructorDescriptor) r3.newCopyBuilder().setOriginal(r3.getOriginal()).setModality(r3.getModality()).setVisibility(r3.getVisibility()).setKind(r3.getKind()).setCopyOverrides(false).build()).substitute(getSubstitutor()));
        goto L4
    L6:
        return r1;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated
    public Annotations getAnnotations() {
        Annotations r1 = this.original.getAnnotations();
        if (r1 != null) goto L5;
        $$$reportNull$$$0(19);
    L5:
        return r1;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.Named
    public Name getName() {
        Name r1 = this.original.getName();
        if (r1 != null) goto L5;
        $$$reportNull$$$0(20);
    L5:
        return r1;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public ClassDescriptor getOriginal() {
        ClassDescriptor r1 = this.original.getOriginal();
        if (r1 != null) goto L5;
        $$$reportNull$$$0(21);
    L5:
        return r1;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorNonRoot, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public DeclarationDescriptor getContainingDeclaration() {
        DeclarationDescriptor r1 = this.original.getContainingDeclaration();
        if (r1 != null) goto L5;
        $$$reportNull$$$0(22);
    L5:
        return r1;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.Substitutable
    public ClassDescriptor substitute(TypeSubstitutor r3) {
        if (r3 != null) goto L5;
        $$$reportNull$$$0(23);
    L5:
        if (r3.isEmpty() == false) goto L8;
        return this;
    L8:
        return new LazySubstitutingClassDescriptor(this, TypeSubstitutor.createChainedSubstitutor(r3.getSubstitution(), getSubstitutor().getSubstitution()));
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    /* JADX INFO: renamed from: getCompanionObjectDescriptor */
    public ClassDescriptor mo2076getCompanionObjectDescriptor() {
        return this.original.mo2076getCompanionObjectDescriptor();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public ClassKind getKind() {
        ClassKind r1 = this.original.getKind();
        if (r1 != null) goto L5;
        $$$reportNull$$$0(25);
    L5:
        return r1;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public Modality getModality() {
        Modality r1 = this.original.getModality();
        if (r1 != null) goto L5;
        $$$reportNull$$$0(26);
    L5:
        return r1;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithVisibility, kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public DescriptorVisibility getVisibility() {
        DescriptorVisibility r1 = this.original.getVisibility();
        if (r1 != null) goto L5;
        $$$reportNull$$$0(27);
    L5:
        return r1;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters
    public boolean isInner() {
        return this.original.isInner();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public boolean isData() {
        return this.original.isData();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public boolean isInline() {
        return this.original.isInline();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public boolean isFun() {
        return this.original.isFun();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public boolean isValue() {
        return this.original.isValue();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public boolean isExternal() {
        return this.original.isExternal();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public boolean isCompanionObject() {
        return this.original.isCompanionObject();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public boolean isExpect() {
        return this.original.isExpect();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public boolean isActual() {
        return this.original.isActual();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public <R, D> R accept(DeclarationDescriptorVisitor<R, D> r1, D r2) {
        return r1.visitClassDescriptor(this, r2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public MemberScope getUnsubstitutedInnerClassesScope() {
        MemberScope r1 = this.original.getUnsubstitutedInnerClassesScope();
        if (r1 != null) goto L5;
        $$$reportNull$$$0(28);
    L5:
        return r1;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    /* JADX INFO: renamed from: getUnsubstitutedPrimaryConstructor */
    public ClassConstructorDescriptor mo2077getUnsubstitutedPrimaryConstructor() {
        return this.original.mo2077getUnsubstitutedPrimaryConstructor();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithSource
    public SourceElement getSource() {
        SourceElement r1 = SourceElement.NO_SOURCE;
        if (r1 != null) goto L5;
        $$$reportNull$$$0(29);
    L5:
        return r1;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters
    public List<TypeParameterDescriptor> getDeclaredTypeParameters() {
        getSubstitutor();
        List<TypeParameterDescriptor> r1 = this.declaredTypeParameters;
        if (r1 != null) goto L5;
        $$$reportNull$$$0(30);
    L5:
        return r1;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public Collection<ClassDescriptor> getSealedSubclasses() {
        Collection<ClassDescriptor> r1 = this.original.getSealedSubclasses();
        if (r1 != null) goto L5;
        $$$reportNull$$$0(31);
    L5:
        return r1;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public ValueClassRepresentation<SimpleType> getValueClassRepresentation() {
        ValueClassRepresentation<SimpleType> r0 = this.original.getValueClassRepresentation();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.mapUnderlyingType(new AnonymousClass2(this));
    }

    private SimpleType substituteSimpleType(SimpleType r2) {
        if (r2 != null) goto L4;
    L8:
        return r2;
    L4:
        if (this.originalSubstitutor.isEmpty() == true) goto L8;
        return (SimpleType) getSubstitutor().substitute(r2, Variance.INVARIANT);
    }
}
