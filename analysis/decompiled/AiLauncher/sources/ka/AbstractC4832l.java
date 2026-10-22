package ka;

import java.util.Collection;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;

/* renamed from: ka.l, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC4832l {
    public abstract void a(CallableMemberDescriptor callableMemberDescriptor);

    public abstract void b(CallableMemberDescriptor callableMemberDescriptor, CallableMemberDescriptor callableMemberDescriptor2);

    public abstract void c(CallableMemberDescriptor callableMemberDescriptor, CallableMemberDescriptor callableMemberDescriptor2);

    public void d(CallableMemberDescriptor member, Collection<? extends CallableMemberDescriptor> overridden) {
        kotlin.jvm.internal.p.i(member, "member");
        kotlin.jvm.internal.p.i(overridden, "overridden");
        member.x0(overridden);
    }
}
