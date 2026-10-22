package kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;

/* JADX INFO: compiled from: ImplicitClassReceiver.kt */
/* JADX INFO: loaded from: classes4.dex */
public class ImplicitClassReceiver implements ImplicitReceiver, ThisClassReceiver {
    private final ClassDescriptor classDescriptor;
    private final ClassDescriptor declarationDescriptor;
    private final ImplicitClassReceiver original;

    public ImplicitClassReceiver(ClassDescriptor r2, ImplicitClassReceiver r3) {
        Intrinsics.checkNotNullParameter(r2, "classDescriptor");
        this.classDescriptor = r2;
        if (r3 != null) goto L5;
        r3 = this;
    L5:
        this.original = r3;
        this.declarationDescriptor = r2;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ReceiverValue
    public /* bridge */ /* synthetic */ KotlinType getType() {
        return getType();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ThisClassReceiver
    public final ClassDescriptor getClassDescriptor() {
        return this.classDescriptor;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ReceiverValue
    public SimpleType getType() {
        SimpleType r1 = this.classDescriptor.getDefaultType();
        Intrinsics.checkNotNullExpressionValue(r1, "classDescriptor.defaultType");
        return r1;
    }

    public boolean equals(Object r3) {
        ClassDescriptor r2 = this.classDescriptor;
        ClassDescriptor r1 = null;
        if ((r3 instanceof ImplicitClassReceiver) == false) goto L5;
        ImplicitClassReceiver r4 = (ImplicitClassReceiver) r3;
    L6:
        if (r4 == null) goto L9;
        r1 = r4.classDescriptor;
    L9:
        return Intrinsics.areEqual(r2, r1);
    L5:
        r4 = null;
        goto L6
    }

    public int hashCode() {
        return this.classDescriptor.hashCode();
    }

    public String toString() {
        return "Class{" + getType() + '}';
    }
}
