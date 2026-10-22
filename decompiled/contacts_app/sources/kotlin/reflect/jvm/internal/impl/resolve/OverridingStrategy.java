package kotlin.reflect.jvm.internal.impl.resolve;

import java.util.Collection;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;

/* JADX INFO: compiled from: OverridingStrategy.kt */
/* JADX INFO: loaded from: classes4.dex */
public abstract class OverridingStrategy {
    public abstract void addFakeOverride(CallableMemberDescriptor r1);

    public abstract void inheritanceConflict(CallableMemberDescriptor r1, CallableMemberDescriptor r2);

    public abstract void overrideConflict(CallableMemberDescriptor r1, CallableMemberDescriptor r2);

    public OverridingStrategy() {
    }

    public void setOverriddenDescriptors(CallableMemberDescriptor r1, Collection<? extends CallableMemberDescriptor> r2) {
        Intrinsics.checkNotNullParameter(r1, "member");
        Intrinsics.checkNotNullParameter(r2, "overridden");
        r1.setOverriddenDescriptors(r2);
    }
}
