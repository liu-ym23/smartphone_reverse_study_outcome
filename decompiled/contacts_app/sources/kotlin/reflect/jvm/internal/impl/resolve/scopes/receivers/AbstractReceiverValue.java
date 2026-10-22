package kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers;

import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* JADX INFO: loaded from: classes4.dex */
public abstract class AbstractReceiverValue implements ReceiverValue {
    private final ReceiverValue original;
    protected final KotlinType receiverType;

    private static /* synthetic */ void $$$reportNull$$$0(int r7) {
        if (r7 == 1) goto L6;
        if (r7 == 2) goto L6;
        String r2 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
    L7:
        if (r7 == 1) goto L10;
        if (r7 == 2) goto L10;
        int r3 = 3;
    L11:
        Object[] r4 = new Object[r3];
        if (r7 == 1) goto L15;
        if (r7 == 2) goto L15;
        r4[0] = "receiverType";
    L16:
        if (r7 == 1) goto L20;
        if (r7 == 2) goto L19;
        r4[1] = "kotlin/reflect/jvm/internal/impl/resolve/scopes/receivers/AbstractReceiverValue";
    L21:
        if (r7 == 1) goto L24;
        if (r7 == 2) goto L24;
        r4[2] = "<init>";
    L24:
        String r5 = String.format(r2, r4);
        if (r7 == 1) goto L29;
        if (r7 == 2) goto L29;
        throw new IllegalArgumentException(r5);
    L29:
        throw new IllegalStateException(r5);
    L19:
        r4[1] = "getOriginal";
        goto L21
    L20:
        r4[1] = "getType";
    L15:
        r4[0] = "kotlin/reflect/jvm/internal/impl/resolve/scopes/receivers/AbstractReceiverValue";
    L10:
        r3 = 2;
    L6:
        r2 = "@NotNull method %s.%s must not return null";
        goto L7
    }

    public AbstractReceiverValue(KotlinType r2, ReceiverValue r3) {
        if (r2 != null) goto L4;
        $$$reportNull$$$0(0);
    L4:
        this.receiverType = r2;
        if (r3 != null) goto L8;
        r3 = this;
    L8:
        this.original = r3;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ReceiverValue
    public KotlinType getType() {
        KotlinType r1 = this.receiverType;
        if (r1 != null) goto L5;
        $$$reportNull$$$0(1);
    L5:
        return r1;
    }
}
