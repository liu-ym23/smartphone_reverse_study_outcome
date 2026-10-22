package ka;

import E9.C0810o;
import java.util.Collection;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;

/* renamed from: ka.u, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C4841u {
    public static final CallableMemberDescriptor a(Collection<? extends CallableMemberDescriptor> descriptors) {
        Integer numD;
        kotlin.jvm.internal.p.i(descriptors, "descriptors");
        descriptors.isEmpty();
        CallableMemberDescriptor callableMemberDescriptor = null;
        for (CallableMemberDescriptor callableMemberDescriptor2 : descriptors) {
            if (callableMemberDescriptor == null || ((numD = C0810o.d(callableMemberDescriptor.getVisibility(), callableMemberDescriptor2.getVisibility())) != null && numD.intValue() < 0)) {
                callableMemberDescriptor = callableMemberDescriptor2;
            }
        }
        kotlin.jvm.internal.p.f(callableMemberDescriptor);
        return callableMemberDescriptor;
    }
}
