package kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* JADX INFO: compiled from: ContextReceiver.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class ContextReceiver extends AbstractReceiverValue implements ImplicitReceiver {
    private final CallableDescriptor declarationDescriptor;

    public CallableDescriptor getDeclarationDescriptor() {
        return this.declarationDescriptor;
    }

    public ContextReceiver(CallableDescriptor r2, KotlinType r3, ReceiverValue r4) {
        Intrinsics.checkNotNullParameter(r2, "declarationDescriptor");
        Intrinsics.checkNotNullParameter(r3, "receiverType");
        super(r3, r4);
        this.declarationDescriptor = r2;
    }

    public String toString() {
        return "Cxt { " + getDeclarationDescriptor() + " }";
    }
}
