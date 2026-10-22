package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ReceiverValue;

/* JADX INFO: loaded from: classes4.dex */
public class ReceiverParameterDescriptorImpl extends AbstractReceiverParameterDescriptor {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final DeclarationDescriptor containingDeclaration;
    private ReceiverValue value;

    private static /* synthetic */ void $$$reportNull$$$0(int r8) {
        if (r8 == 3) goto L6;
        if (r8 == 4) goto L6;
        String r2 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
    L8:
        if (r8 == 3) goto L11;
        if (r8 == 4) goto L11;
        int r4 = 3;
    L12:
        Object[] r5 = new Object[r4];
        switch(r8) {
            case 1: goto L19;
            case 2: goto L18;
            case 3: goto L17;
            case 4: goto L17;
            case 5: goto L16;
            case 6: goto L15;
            default: goto L14;
        };
    L14:
        r5[0] = "containingDeclaration";
    L21:
        if (r8 == 3) goto L25;
        if (r8 == 4) goto L24;
        r5[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/ReceiverParameterDescriptorImpl";
    L26:
        if (r8 == 3) goto L35;
        if (r8 == 4) goto L35;
        if (r8 != 5) goto L31;
        r5[2] = "copy";
        goto L35
    L31:
        if (r8 == 6) goto L33;
        r5[2] = "<init>";
        goto L35
    L33:
        r5[2] = "setOutType";
    L35:
        String r3 = String.format(r2, r5);
        if (r8 == 3) goto L40;
        if (r8 == 4) goto L40;
        throw new IllegalArgumentException(r3);
    L40:
        throw new IllegalStateException(r3);
    L24:
        r5[1] = "getContainingDeclaration";
        goto L26
    L25:
        r5[1] = "getValue";
        goto L26
    L15:
        r5[0] = "outType";
        goto L21
    L16:
        r5[0] = "newOwner";
        goto L21
    L17:
        r5[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/ReceiverParameterDescriptorImpl";
        goto L21
    L18:
        r5[0] = "annotations";
        goto L21
    L19:
        r5[0] = "value";
    L11:
        r4 = 2;
    L6:
        r2 = "@NotNull method %s.%s must not return null";
        goto L8
    }

    static {
    }

    public ReceiverParameterDescriptorImpl(DeclarationDescriptor r2, ReceiverValue r3, Annotations r4) {
        if (r2 != null) goto L4;
        $$$reportNull$$$0(0);
    L4:
        if (r3 != null) goto L6;
        $$$reportNull$$$0(1);
    L6:
        if (r4 != null) goto L8;
        $$$reportNull$$$0(2);
    L8:
        super(r4);
        this.containingDeclaration = r2;
        this.value = r3;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor
    public ReceiverValue getValue() {
        ReceiverValue r1 = this.value;
        if (r1 != null) goto L5;
        $$$reportNull$$$0(3);
    L5:
        return r1;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public DeclarationDescriptor getContainingDeclaration() {
        DeclarationDescriptor r1 = this.containingDeclaration;
        if (r1 != null) goto L5;
        $$$reportNull$$$0(4);
    L5:
        return r1;
    }
}
