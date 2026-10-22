package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorNonRoot;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithSource;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyAccessorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;

/* JADX INFO: loaded from: classes4.dex */
public abstract class PropertyAccessorDescriptorImpl extends DeclarationDescriptorNonRootImpl implements PropertyAccessorDescriptor {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final PropertyDescriptor correspondingProperty;
    private FunctionDescriptor initialSignatureDescriptor;
    private boolean isDefault;
    private final boolean isExternal;
    private final boolean isInline;
    private final CallableMemberDescriptor.Kind kind;
    private final Modality modality;
    private DescriptorVisibility visibility;

    private static /* synthetic */ void $$$reportNull$$$0(int r6) {
        switch(r6) {
            case 6: goto L4;
            case 7: goto L3;
            case 8: goto L4;
            case 9: goto L4;
            case 10: goto L4;
            case 11: goto L4;
            case 12: goto L4;
            case 13: goto L4;
            case 14: goto L4;
            default: goto L3;
        };
    L3:
        String r0 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
    L6:
        switch(r6) {
            case 6: goto L8;
            case 7: goto L7;
            case 8: goto L8;
            case 9: goto L8;
            case 10: goto L8;
            case 11: goto L8;
            case 12: goto L8;
            case 13: goto L8;
            case 14: goto L8;
            default: goto L7;
        };
    L7:
        int r2 = 3;
    L9:
        Object[] r3 = new Object[r2];
        switch(r6) {
            case 1: goto L19;
            case 2: goto L18;
            case 3: goto L17;
            case 4: goto L16;
            case 5: goto L15;
            case 6: goto L14;
            case 7: goto L13;
            case 8: goto L14;
            case 9: goto L14;
            case 10: goto L14;
            case 11: goto L14;
            case 12: goto L14;
            case 13: goto L14;
            case 14: goto L14;
            case 15: goto L12;
            default: goto L11;
        };
    L11:
        r3[0] = "modality";
    L21:
        switch(r6) {
            case 6: goto L30;
            case 7: goto L22;
            case 8: goto L29;
            case 9: goto L28;
            case 10: goto L27;
            case 11: goto L26;
            case 12: goto L25;
            case 13: goto L24;
            case 14: goto L23;
            default: goto L22;
        };
    L22:
        r3[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyAccessorDescriptorImpl";
    L31:
        switch(r6) {
            case 6: goto L35;
            case 7: goto L34;
            case 8: goto L35;
            case 9: goto L35;
            case 10: goto L35;
            case 11: goto L35;
            case 12: goto L35;
            case 13: goto L35;
            case 14: goto L35;
            case 15: goto L33;
            default: goto L32;
        };
    L32:
        r3[2] = "<init>";
        goto L35
    L33:
        r3[2] = "setOverriddenDescriptors";
        goto L35
    L34:
        r3[2] = "substitute";
    L35:
        String r1 = String.format(r0, r3);
        switch(r6) {
            case 6: goto L39;
            case 7: goto L40;
            case 8: goto L39;
            case 9: goto L39;
            case 10: goto L39;
            case 11: goto L39;
            case 12: goto L39;
            case 13: goto L39;
            case 14: goto L39;
            default: goto L40;
        };
    L40:
        throw new IllegalArgumentException(r1);
    L39:
        throw new IllegalStateException(r1);
    L23:
        r3[1] = "getOverriddenDescriptors";
        goto L31
    L24:
        r3[1] = "getContextReceiverParameters";
        goto L31
    L25:
        r3[1] = "getCorrespondingProperty";
        goto L31
    L26:
        r3[1] = "getCorrespondingVariable";
        goto L31
    L27:
        r3[1] = "getVisibility";
        goto L31
    L28:
        r3[1] = "getModality";
        goto L31
    L29:
        r3[1] = "getTypeParameters";
        goto L31
    L30:
        r3[1] = "getKind";
        goto L31
    L12:
        r3[0] = "overriddenDescriptors";
        goto L21
    L13:
        r3[0] = "substitutor";
        goto L21
    L14:
        r3[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyAccessorDescriptorImpl";
        goto L21
    L15:
        r3[0] = "source";
        goto L21
    L16:
        r3[0] = "name";
        goto L21
    L17:
        r3[0] = "annotations";
        goto L21
    L18:
        r3[0] = "correspondingProperty";
        goto L21
    L19:
        r3[0] = "visibility";
        goto L21
    L8:
        r2 = 2;
        goto L9
    L4:
        r0 = "@NotNull method %s.%s must not return null";
        goto L6
    }

    static {
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorNonRootImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public abstract PropertyAccessorDescriptor getOriginal();

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    public <V> V getUserData(CallableDescriptor.UserDataKey<V> r1) {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    public boolean hasSynthesizedParameterNames() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public boolean isActual() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public boolean isExpect() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor
    public boolean isHiddenForResolutionEverywhereBesideSupercalls() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor
    public boolean isHiddenToOvercomeSignatureClash() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor
    public boolean isInfix() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor
    public boolean isOperator() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor
    public boolean isSuspend() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor
    public boolean isTailrec() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor
    public void setOverriddenDescriptors(Collection<? extends CallableMemberDescriptor> r1) {
        if (r1 != null) goto L5;
        $$$reportNull$$$0(15);
        return;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor
    public /* bridge */ /* synthetic */ CallableMemberDescriptor copy(DeclarationDescriptor r1, Modality r2, DescriptorVisibility r3, CallableMemberDescriptor.Kind r4, boolean r5) {
        return copy(r1, r2, r3, r4, r5);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorNonRootImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public /* bridge */ /* synthetic */ CallableDescriptor getOriginal() {
        return getOriginal();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorNonRootImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public /* bridge */ /* synthetic */ CallableMemberDescriptor getOriginal() {
        return getOriginal();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorNonRootImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public /* bridge */ /* synthetic */ DeclarationDescriptor getOriginal() {
        return getOriginal();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorNonRootImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public /* bridge */ /* synthetic */ DeclarationDescriptorWithSource getOriginal() {
        return getOriginal();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorNonRootImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public /* bridge */ /* synthetic */ FunctionDescriptor getOriginal() {
        return getOriginal();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.Substitutable
    public /* bridge */ /* synthetic */ DeclarationDescriptorNonRoot substitute(TypeSubstitutor r1) {
        return substitute(r1);
    }

    public PropertyAccessorDescriptorImpl(Modality r2, DescriptorVisibility r3, PropertyDescriptor r4, Annotations r5, Name r6, boolean r7, boolean r8, boolean r9, CallableMemberDescriptor.Kind r10, SourceElement r11) {
        if (r2 != null) goto L4;
        $$$reportNull$$$0(0);
    L4:
        if (r3 != null) goto L6;
        $$$reportNull$$$0(1);
    L6:
        if (r4 != null) goto L8;
        $$$reportNull$$$0(2);
    L8:
        if (r5 != null) goto L10;
        $$$reportNull$$$0(3);
    L10:
        if (r6 != null) goto L12;
        $$$reportNull$$$0(4);
    L12:
        if (r11 != null) goto L14;
        $$$reportNull$$$0(5);
    L14:
        super(r4.getContainingDeclaration(), r5, r6, r11);
        this.initialSignatureDescriptor = null;
        this.modality = r2;
        this.visibility = r3;
        this.correspondingProperty = r4;
        this.isDefault = r7;
        this.isExternal = r8;
        this.isInline = r9;
        this.kind = r10;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PropertyAccessorDescriptor
    public boolean isDefault() {
        return this.isDefault;
    }

    public void setDefault(boolean r1) {
        this.isDefault = r1;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor
    public CallableMemberDescriptor.Kind getKind() {
        CallableMemberDescriptor.Kind r1 = this.kind;
        if (r1 != null) goto L5;
        $$$reportNull$$$0(6);
    L5:
        return r1;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public boolean isExternal() {
        return this.isExternal;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor
    public boolean isInline() {
        return this.isInline;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.Substitutable
    public FunctionDescriptor substitute(TypeSubstitutor r1) {
        if (r1 != null) goto L5;
        $$$reportNull$$$0(7);
    L5:
        throw new UnsupportedOperationException();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    public List<TypeParameterDescriptor> getTypeParameters() {
        List<TypeParameterDescriptor> r1 = Collections.emptyList();
        if (r1 != null) goto L5;
        $$$reportNull$$$0(8);
    L5:
        return r1;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public Modality getModality() {
        Modality r1 = this.modality;
        if (r1 != null) goto L5;
        $$$reportNull$$$0(9);
    L5:
        return r1;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithVisibility, kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public DescriptorVisibility getVisibility() {
        DescriptorVisibility r1 = this.visibility;
        if (r1 != null) goto L5;
        $$$reportNull$$$0(10);
    L5:
        return r1;
    }

    public void setVisibility(DescriptorVisibility r1) {
        this.visibility = r1;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PropertyAccessorDescriptor
    public PropertyDescriptor getCorrespondingProperty() {
        PropertyDescriptor r1 = this.correspondingProperty;
        if (r1 != null) goto L5;
        $$$reportNull$$$0(12);
    L5:
        return r1;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    public List<ReceiverParameterDescriptor> getContextReceiverParameters() {
        List<ReceiverParameterDescriptor> r1 = getCorrespondingProperty().getContextReceiverParameters();
        if (r1 != null) goto L5;
        $$$reportNull$$$0(13);
    L5:
        return r1;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    public ReceiverParameterDescriptor getExtensionReceiverParameter() {
        return getCorrespondingProperty().getExtensionReceiverParameter();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    public ReceiverParameterDescriptor getDispatchReceiverParameter() {
        return getCorrespondingProperty().getDispatchReceiverParameter();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor
    public FunctionDescriptor.CopyBuilder<? extends FunctionDescriptor> newCopyBuilder() {
        throw new UnsupportedOperationException("Accessors must be copied by the corresponding property");
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor
    public PropertyAccessorDescriptor copy(DeclarationDescriptor r1, Modality r2, DescriptorVisibility r3, CallableMemberDescriptor.Kind r4, boolean r5) {
        throw new UnsupportedOperationException("Accessors must be copied by the corresponding property");
    }

    protected Collection<PropertyAccessorDescriptor> getOverriddenDescriptors(boolean r3) {
        ArrayList r0 = new ArrayList(0);
        Iterator<? extends PropertyDescriptor> r2 = getCorrespondingProperty().getOverriddenDescriptors().iterator();
    L4:
        if (r2.hasNext() == false) goto L11;
        PropertyDescriptor r1 = r2.next();
        if (r3 == false) goto L8;
        CallableDescriptor r4 = r1.getGetter();
    L9:
        if (r4 == null) goto L4;
        r0.add(r4);
        goto L4
    L8:
        r4 = r1.getSetter();
        goto L9
    L11:
        return r0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor
    public FunctionDescriptor getInitialSignatureDescriptor() {
        return this.initialSignatureDescriptor;
    }

    public void setInitialSignatureDescriptor(FunctionDescriptor r1) {
        this.initialSignatureDescriptor = r1;
    }
}
