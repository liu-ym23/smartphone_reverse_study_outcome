package kotlin.reflect.jvm.internal.impl.resolve;

import _COROUTINE.ArtificialStackFrames;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.utils.SmartSet;

/* JADX INFO: compiled from: overridingUtils.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class OverridingUtilsKt {
    /* JADX WARN: Multi-variable type inference failed */
    public static final <H> Collection<H> selectMostSpecificInEachOverridableGroup(Collection<? extends H> r8, Function1<? super H, ? extends CallableDescriptor> r9) {
        Intrinsics.checkNotNullParameter(r8, "<this>");
        Intrinsics.checkNotNullParameter(r9, "descriptorByHandle");
        if (r8.size() > 1) goto L5;
        return r8;
    L5:
        LinkedList r0 = new LinkedList(r8);
        SmartSet r10 = SmartSet.Companion.create();
    L6:
        LinkedList r2 = r0;
        if ((!r2.isEmpty()) == false) goto L24;
        Object r3 = CollectionsKt.first(r0);
        final SmartSet r4 = SmartSet.Companion.create();
        Collection r5 = OverridingUtil.extractMembersOverridableInBothWays(r3, r2, r9, new OverridingUtilsKt$selectMostSpecificInEachOverridableGroup$overridableGroup$1(r4));
        Intrinsics.checkNotNullExpressionValue(r5, "conflictedHandles = Smar…nflictedHandles.add(it) }");
        if (r5.size() != 1) goto L13;
        if (r4.isEmpty() == false) goto L13;
        Object r6 = CollectionsKt.single(r5);
        Intrinsics.checkNotNullExpressionValue(r6, "overridableGroup.single()");
        r10.add(r6);
    L13:
        ArtificialStackFrames r7 = (Object) OverridingUtil.selectMostSpecificMember(r5, r9);
        Intrinsics.checkNotNullExpressionValue(r7, "selectMostSpecificMember…roup, descriptorByHandle)");
        CallableDescriptor r11 = r9.invoke(r7);
        Iterator r12 = r5.iterator();
    L15:
        if (r12.hasNext() == false) goto L19;
        ArtificialStackFrames r13 = (Object) r12.next();
        Intrinsics.checkNotNullExpressionValue(r13, "it");
        if (OverridingUtil.isMoreSpecific(r11, r9.invoke(r13)) == true) goto L15;
        r4.add(r13);
        goto L15
    L19:
        SmartSet r14 = r4;
        if ((!r14.isEmpty()) == false) goto L22;
        r10.addAll(r14);
    L22:
        r10.add(r7);
        goto L6
    L24:
        return r10;
    }
}
