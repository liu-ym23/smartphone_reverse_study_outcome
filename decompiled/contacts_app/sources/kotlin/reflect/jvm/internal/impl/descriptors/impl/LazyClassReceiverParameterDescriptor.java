package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ImplicitClassReceiver;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ReceiverValue;

/* JADX INFO: loaded from: classes4.dex */
public class LazyClassReceiverParameterDescriptor extends AbstractReceiverParameterDescriptor {
    private final ClassDescriptor descriptor;
    private final ImplicitClassReceiver receiverValue;

    private static /* synthetic */ void $$$reportNull$$$0(int r8) {
        if (r8 == 1) goto L6;
        if (r8 == 2) goto L6;
        String r2 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
    L8:
        if (r8 == 1) goto L11;
        if (r8 == 2) goto L11;
        int r4 = 3;
    L12:
        Object[] r5 = new Object[r4];
        if (r8 == 1) goto L18;
        if (r8 == 2) goto L18;
        if (r8 == 3) goto L17;
        r5[0] = "descriptor";
    L19:
        if (r8 == 1) goto L23;
        if (r8 == 2) goto L22;
        r5[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/LazyClassReceiverParameterDescriptor";
    L24:
        if (r8 == 1) goto L29;
        if (r8 == 2) goto L29;
        if (r8 == 3) goto L28;
        r5[2] = "<init>";
        goto L29
    L28:
        r5[2] = "copy";
    L29:
        String r3 = String.format(r2, r5);
        if (r8 == 1) goto L34;
        if (r8 == 2) goto L34;
        throw new IllegalArgumentException(r3);
    L34:
        throw new IllegalStateException(r3);
    L22:
        r5[1] = "getContainingDeclaration";
        goto L24
    L23:
        r5[1] = "getValue";
        goto L24
    L17:
        r5[0] = "newOwner";
    L18:
        r5[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/LazyClassReceiverParameterDescriptor";
    L11:
        r4 = 2;
    L6:
        r2 = "@NotNull method %s.%s must not return null";
        goto L8
    }

    public LazyClassReceiverParameterDescriptor(ClassDescriptor r3) {
        if (r3 != null) goto L4;
        $$$reportNull$$$0(0);
    L4:
        super(Annotations.Companion.getEMPTY());
        this.descriptor = r3;
        this.receiverValue = new ImplicitClassReceiver(r3, null);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor
    public ReceiverValue getValue() {
        ImplicitClassReceiver r1 = this.receiverValue;
        if (r1 != null) goto L5;
        $$$reportNull$$$0(1);
    L5:
        return r1;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public DeclarationDescriptor getContainingDeclaration() {
        ClassDescriptor r1 = this.descriptor;
        if (r1 != null) goto L5;
        $$$reportNull$$$0(2);
    L5:
        return r1;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorImpl
    public String toString() {
        return "class " + this.descriptor.getName() + "::this";
    }
}
