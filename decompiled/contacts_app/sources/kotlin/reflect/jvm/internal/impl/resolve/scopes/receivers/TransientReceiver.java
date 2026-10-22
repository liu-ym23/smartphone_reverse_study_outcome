package kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers;

import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* JADX INFO: loaded from: classes4.dex */
public class TransientReceiver extends AbstractReceiverValue {
    private static /* synthetic */ void $$$reportNull$$$0(int r4) {
        Object[] r0 = new Object[3];
        if (r4 == 2) goto L5;
        r0[0] = "type";
    L6:
        r0[1] = "kotlin/reflect/jvm/internal/impl/resolve/scopes/receivers/TransientReceiver";
        if (r4 == 2) goto L9;
        r0[2] = "<init>";
    L11:
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", r0));
    L9:
        r0[2] = "replaceType";
        goto L11
    L5:
        r0[0] = "newType";
        goto L6
    }

    public TransientReceiver(KotlinType r2) {
        if (r2 != null) goto L4;
        $$$reportNull$$$0(0);
    L4:
        this(r2, null);
    }

    private TransientReceiver(KotlinType r2, ReceiverValue r3) {
        if (r2 != null) goto L4;
        $$$reportNull$$$0(1);
    L4:
        super(r2, r3);
    }

    public String toString() {
        return "{Transient} : " + getType();
    }
}
