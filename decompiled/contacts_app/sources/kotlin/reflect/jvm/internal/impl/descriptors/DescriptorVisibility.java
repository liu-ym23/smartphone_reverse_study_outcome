package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ReceiverValue;

/* JADX INFO: compiled from: DescriptorVisibility.kt */
/* JADX INFO: loaded from: classes4.dex */
public abstract class DescriptorVisibility {
    public abstract Visibility getDelegate();

    public abstract String getInternalDisplayName();

    public abstract boolean isVisible(ReceiverValue r1, DeclarationDescriptorWithVisibility r2, DeclarationDescriptor r3, boolean r4);

    public abstract DescriptorVisibility normalize();

    protected DescriptorVisibility() {
    }

    public final boolean isPublicAPI() {
        return getDelegate().isPublicAPI();
    }

    public final Integer compareTo(DescriptorVisibility r2) {
        Intrinsics.checkNotNullParameter(r2, "visibility");
        return getDelegate().compareTo(r2.getDelegate());
    }

    public final String toString() {
        return getDelegate().toString();
    }
}
