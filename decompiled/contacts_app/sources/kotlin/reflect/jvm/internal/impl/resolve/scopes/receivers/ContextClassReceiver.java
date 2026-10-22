package kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* JADX INFO: compiled from: ContextClassReceiver.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class ContextClassReceiver extends AbstractReceiverValue implements ImplicitReceiver {
    private final ClassDescriptor classDescriptor;

    public ContextClassReceiver(ClassDescriptor r2, KotlinType r3, ReceiverValue r4) {
        Intrinsics.checkNotNullParameter(r2, "classDescriptor");
        Intrinsics.checkNotNullParameter(r3, "receiverType");
        super(r3, r4);
        this.classDescriptor = r2;
    }

    public String toString() {
        return getType() + ": Ctx { " + this.classDescriptor + " }";
    }
}
