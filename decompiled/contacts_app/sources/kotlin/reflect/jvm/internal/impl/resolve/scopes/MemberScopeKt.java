package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* JADX INFO: compiled from: MemberScope.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class MemberScopeKt {
    public static final Set<Name> flatMapClassifierNamesOrNull(Iterable<? extends MemberScope> r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        HashSet r0 = new HashSet();
        Iterator<? extends MemberScope> r3 = r2.iterator();
    L4:
        if (r3.hasNext() == false) goto L10;
        Set<Name> r1 = r3.next().getClassifierNames();
        if (r1 == null) goto L7;
        CollectionsKt.addAll(r0, r1);
        goto L4
    L7:
        r0 = null;
    L10:
        return r0;
    }
}
