package kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers;

import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* JADX INFO: loaded from: classes4.dex */
public class ExtensionReceiver extends AbstractReceiverValue implements ImplicitReceiver {
    private final CallableDescriptor descriptor;

    private static /* synthetic */ void $$$reportNull$$$0(int r8) {
        if (r8 == 2) goto L5;
        String r1 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
    L7:
        if (r8 == 2) goto L9;
        int r3 = 3;
    L10:
        Object[] r4 = new Object[r3];
        if (r8 == 1) goto L17;
        if (r8 == 2) goto L16;
        if (r8 == 3) goto L15;
        r4[0] = "callableDescriptor";
    L18:
        if (r8 == 2) goto L20;
        r4[1] = "kotlin/reflect/jvm/internal/impl/resolve/scopes/receivers/ExtensionReceiver";
    L21:
        if (r8 == 2) goto L25;
        if (r8 == 3) goto L24;
        r4[2] = "<init>";
        goto L25
    L24:
        r4[2] = "replaceType";
    L25:
        String r2 = String.format(r1, r4);
        if (r8 == 2) goto L29;
        throw new IllegalArgumentException(r2);
    L29:
        throw new IllegalStateException(r2);
    L20:
        r4[1] = "getDeclarationDescriptor";
        goto L21
    L15:
        r4[0] = "newType";
        goto L18
    L16:
        r4[0] = "kotlin/reflect/jvm/internal/impl/resolve/scopes/receivers/ExtensionReceiver";
        goto L18
    L17:
        r4[0] = "receiverType";
        goto L18
    L9:
        r3 = 2;
        goto L10
    L5:
        r1 = "@NotNull method %s.%s must not return null";
        goto L7
    }

    public ExtensionReceiver(CallableDescriptor r2, KotlinType r3, ReceiverValue r4) {
        if (r2 != null) goto L4;
        $$$reportNull$$$0(0);
    L4:
        if (r3 != null) goto L6;
        $$$reportNull$$$0(1);
    L6:
        super(r3, r4);
        this.descriptor = r2;
    }

    public String toString() {
        return getType() + ": Ext {" + this.descriptor + "}";
    }
}
