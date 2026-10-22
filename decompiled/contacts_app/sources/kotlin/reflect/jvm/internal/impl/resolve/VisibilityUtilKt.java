package kotlin.reflect.jvm.internal.impl.resolve;

import java.util.Collection;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities;

/* JADX INFO: compiled from: VisibilityUtil.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class VisibilityUtilKt {
    public static final CallableMemberDescriptor findMemberWithMaxVisibility(Collection<? extends CallableMemberDescriptor> r4) {
        Intrinsics.checkNotNullParameter(r4, "descriptors");
        r4.isEmpty();
        Iterator<? extends CallableMemberDescriptor> r5 = r4.iterator();
        CallableMemberDescriptor r0 = null;
    L4:
        if (r5.hasNext() == false) goto L13;
        CallableMemberDescriptor r1 = r5.next();
        if (r0 == null) goto L12;
        Integer r2 = DescriptorVisibilities.compare(r0.getVisibility(), r1.getVisibility());
        if (r2 == null) goto L4;
        if (r2.intValue() >= 0) goto L4;
    L12:
        r0 = r1;
        goto L4
    L13:
        Intrinsics.checkNotNull(r0);
        return r0;
    }
}
