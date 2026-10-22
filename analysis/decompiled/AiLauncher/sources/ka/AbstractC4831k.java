package ka;

import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;

/* renamed from: ka.k, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC4831k extends AbstractC4832l {
    @Override // ka.AbstractC4832l
    public void b(CallableMemberDescriptor first, CallableMemberDescriptor second) {
        kotlin.jvm.internal.p.i(first, "first");
        kotlin.jvm.internal.p.i(second, "second");
        e(first, second);
    }

    @Override // ka.AbstractC4832l
    public void c(CallableMemberDescriptor fromSuper, CallableMemberDescriptor fromCurrent) {
        kotlin.jvm.internal.p.i(fromSuper, "fromSuper");
        kotlin.jvm.internal.p.i(fromCurrent, "fromCurrent");
        e(fromSuper, fromCurrent);
    }

    public abstract void e(CallableMemberDescriptor callableMemberDescriptor, CallableMemberDescriptor callableMemberDescriptor2);
}
