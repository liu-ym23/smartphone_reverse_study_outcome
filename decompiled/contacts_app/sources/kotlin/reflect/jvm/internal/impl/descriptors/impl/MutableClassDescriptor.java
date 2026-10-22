package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueClassRepresentation;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.ClassTypeConstructorImpl;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;

/* JADX INFO: loaded from: classes4.dex */
public class MutableClassDescriptor extends ClassDescriptorBase {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final boolean isInner;
    private final ClassKind kind;
    private Modality modality;
    private final StorageManager storageManager;
    private final Collection<KotlinType> supertypes;
    private TypeConstructor typeConstructor;
    private List<TypeParameterDescriptor> typeParameters;
    private DescriptorVisibility visibility;

    private static /* synthetic */ void $$$reportNull$$$0(int r6) {
        switch(r6) {
            case 5: goto L4;
            case 6: goto L3;
            case 7: goto L4;
            case 8: goto L4;
            case 9: goto L3;
            case 10: goto L4;
            case 11: goto L4;
            case 12: goto L3;
            case 13: goto L4;
            case 14: goto L3;
            case 15: goto L4;
            case 16: goto L3;
            case 17: goto L4;
            case 18: goto L4;
            case 19: goto L4;
            default: goto L3;
        };
    L3:
        String r0 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
    L6:
        switch(r6) {
            case 5: goto L8;
            case 6: goto L7;
            case 7: goto L8;
            case 8: goto L8;
            case 9: goto L7;
            case 10: goto L8;
            case 11: goto L8;
            case 12: goto L7;
            case 13: goto L8;
            case 14: goto L7;
            case 15: goto L8;
            case 16: goto L7;
            case 17: goto L8;
            case 18: goto L8;
            case 19: goto L8;
            default: goto L7;
        };
    L7:
        int r2 = 3;
    L9:
        Object[] r3 = new Object[r2];
        switch(r6) {
            case 1: goto L21;
            case 2: goto L20;
            case 3: goto L19;
            case 4: goto L18;
            case 5: goto L17;
            case 6: goto L16;
            case 7: goto L17;
            case 8: goto L17;
            case 9: goto L15;
            case 10: goto L17;
            case 11: goto L17;
            case 12: goto L14;
            case 13: goto L17;
            case 14: goto L13;
            case 15: goto L17;
            case 16: goto L12;
            case 17: goto L17;
            case 18: goto L17;
            case 19: goto L17;
            default: goto L11;
        };
    L11:
        r3[0] = "containingDeclaration";
    L23:
        switch(r6) {
            case 5: goto L34;
            case 6: goto L24;
            case 7: goto L33;
            case 8: goto L32;
            case 9: goto L24;
            case 10: goto L31;
            case 11: goto L30;
            case 12: goto L24;
            case 13: goto L29;
            case 14: goto L24;
            case 15: goto L28;
            case 16: goto L24;
            case 17: goto L27;
            case 18: goto L26;
            case 19: goto L25;
            default: goto L24;
        };
    L24:
        r3[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/MutableClassDescriptor";
    L35:
        switch(r6) {
            case 5: goto L42;
            case 6: goto L41;
            case 7: goto L42;
            case 8: goto L42;
            case 9: goto L40;
            case 10: goto L42;
            case 11: goto L42;
            case 12: goto L39;
            case 13: goto L42;
            case 14: goto L38;
            case 15: goto L42;
            case 16: goto L37;
            case 17: goto L42;
            case 18: goto L42;
            case 19: goto L42;
            default: goto L36;
        };
    L36:
        r3[2] = "<init>";
        goto L42
    L37:
        r3[2] = "getUnsubstitutedMemberScope";
        goto L42
    L38:
        r3[2] = "setTypeParameterDescriptors";
        goto L42
    L39:
        r3[2] = "addSupertype";
        goto L42
    L40:
        r3[2] = "setVisibility";
        goto L42
    L41:
        r3[2] = "setModality";
    L42:
        String r1 = String.format(r0, r3);
        switch(r6) {
            case 5: goto L46;
            case 6: goto L47;
            case 7: goto L46;
            case 8: goto L46;
            case 9: goto L47;
            case 10: goto L46;
            case 11: goto L46;
            case 12: goto L47;
            case 13: goto L46;
            case 14: goto L47;
            case 15: goto L46;
            case 16: goto L47;
            case 17: goto L46;
            case 18: goto L46;
            case 19: goto L46;
            default: goto L47;
        };
    L47:
        throw new IllegalArgumentException(r1);
    L46:
        throw new IllegalStateException(r1);
    L25:
        r3[1] = "getSealedSubclasses";
        goto L35
    L26:
        r3[1] = "getStaticScope";
        goto L35
    L27:
        r3[1] = "getUnsubstitutedMemberScope";
        goto L35
    L28:
        r3[1] = "getDeclaredTypeParameters";
        goto L35
    L29:
        r3[1] = "getConstructors";
        goto L35
    L30:
        r3[1] = "getTypeConstructor";
        goto L35
    L31:
        r3[1] = "getVisibility";
        goto L35
    L32:
        r3[1] = "getKind";
        goto L35
    L33:
        r3[1] = "getModality";
        goto L35
    L34:
        r3[1] = "getAnnotations";
        goto L35
    L12:
        r3[0] = "kotlinTypeRefiner";
        goto L23
    L13:
        r3[0] = "typeParameters";
        goto L23
    L14:
        r3[0] = "supertype";
        goto L23
    L15:
        r3[0] = "visibility";
        goto L23
    L16:
        r3[0] = "modality";
        goto L23
    L17:
        r3[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/MutableClassDescriptor";
        goto L23
    L18:
        r3[0] = "storageManager";
        goto L23
    L19:
        r3[0] = "source";
        goto L23
    L20:
        r3[0] = "name";
        goto L23
    L21:
        r3[0] = "kind";
        goto L23
    L8:
        r2 = 2;
        goto L9
    L4:
        r0 = "@NotNull method %s.%s must not return null";
        goto L6
    }

    static {
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

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public /* bridge */ /* synthetic */ Collection getConstructors() {
        return getConstructors();
    }

    public MutableClassDescriptor(DeclarationDescriptor r7, ClassKind r8, boolean r9, boolean r10, Name r11, SourceElement r12, StorageManager r13) {
        if (r7 != null) goto L4;
        $$$reportNull$$$0(0);
    L4:
        if (r8 != null) goto L6;
        $$$reportNull$$$0(1);
    L6:
        if (r11 != null) goto L8;
        $$$reportNull$$$0(2);
    L8:
        if (r12 != null) goto L10;
        $$$reportNull$$$0(3);
    L10:
        if (r13 != null) goto L12;
        $$$reportNull$$$0(4);
    L12:
        super(r13, r7, r11, r12, r10);
        this.supertypes = new ArrayList();
        this.storageManager = r13;
        this.kind = r8;
        this.isInner = r9;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated
    public Annotations getAnnotations() {
        Annotations r1 = Annotations.Companion.getEMPTY();
        if (r1 != null) goto L5;
        $$$reportNull$$$0(5);
    L5:
        return r1;
    }

    public void setModality(Modality r2) {
        if (r2 != null) goto L4;
        $$$reportNull$$$0(6);
    L4:
        this.modality = r2;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public Modality getModality() {
        Modality r1 = this.modality;
        if (r1 != null) goto L5;
        $$$reportNull$$$0(7);
    L5:
        return r1;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public ClassKind getKind() {
        ClassKind r1 = this.kind;
        if (r1 != null) goto L5;
        $$$reportNull$$$0(8);
    L5:
        return r1;
    }

    public void setVisibility(DescriptorVisibility r2) {
        if (r2 != null) goto L4;
        $$$reportNull$$$0(9);
    L4:
        this.visibility = r2;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithVisibility, kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public DescriptorVisibility getVisibility() {
        DescriptorVisibility r1 = this.visibility;
        if (r1 != null) goto L5;
        $$$reportNull$$$0(10);
    L5:
        return r1;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters
    public boolean isInner() {
        return this.isInner;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor
    public TypeConstructor getTypeConstructor() {
        TypeConstructor r1 = this.typeConstructor;
        if (r1 != null) goto L5;
        $$$reportNull$$$0(11);
    L5:
        return r1;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public Set<ClassConstructorDescriptor> getConstructors() {
        Set<ClassConstructorDescriptor> r1 = Collections.emptySet();
        if (r1 != null) goto L5;
        $$$reportNull$$$0(13);
    L5:
        return r1;
    }

    public void setTypeParameterDescriptors(List<TypeParameterDescriptor> r3) {
        if (r3 != null) goto L5;
        $$$reportNull$$$0(14);
    L5:
        if (this.typeParameters != null) goto L9;
        this.typeParameters = new ArrayList(r3);
        return;
    L9:
        throw new IllegalStateException("Type parameters are already set for " + getName());
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters
    public List<TypeParameterDescriptor> getDeclaredTypeParameters() {
        List<TypeParameterDescriptor> r1 = this.typeParameters;
        if (r1 != null) goto L5;
        $$$reportNull$$$0(15);
    L5:
        return r1;
    }

    public void createTypeConstructor() {
        this.typeConstructor = new ClassTypeConstructorImpl(this, this.typeParameters, this.supertypes, this.storageManager);
        Iterator<ClassConstructorDescriptor> r0 = getConstructors().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((ClassConstructorDescriptorImpl) r0.next()).setReturnType(getDefaultType());
        goto L4
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleAwareClassDescriptor
    public MemberScope getUnsubstitutedMemberScope(KotlinTypeRefiner r1) {
        if (r1 != null) goto L4;
        $$$reportNull$$$0(16);
    L4:
        MemberScope.Empty r0 = MemberScope.Empty.INSTANCE;
        if (r0 != null) goto L7;
        $$$reportNull$$$0(17);
    L7:
        return r0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public MemberScope getStaticScope() {
        MemberScope.Empty r1 = MemberScope.Empty.INSTANCE;
        if (r1 != null) goto L5;
        $$$reportNull$$$0(18);
    L5:
        return r1;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public Collection<ClassDescriptor> getSealedSubclasses() {
        List r1 = Collections.emptyList();
        if (r1 != null) goto L5;
        $$$reportNull$$$0(19);
    L5:
        return r1;
    }

    public String toString() {
        return DeclarationDescriptorImpl.toString(this);
    }
}
