package kotlin.reflect.jvm.internal.impl.util.collectionUtils;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.utils.SmartList;

/* JADX INFO: compiled from: scopeUtils.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class ScopeUtilsKt {
    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> Collection<T> concat(Collection<? extends T> r1, Collection<? extends T> r2) {
        Intrinsics.checkNotNullParameter(r2, "collection");
        if (r2.isEmpty() == false) goto L5;
        return r1;
    L5:
        if (r1 != 0) goto L8;
        return r2;
    L8:
        if ((r1 instanceof LinkedHashSet) == false) goto L11;
        ((LinkedHashSet) r1).addAll(r2);
        return r1;
    L11:
        LinkedHashSet r0 = new LinkedHashSet(r1);
        r0.addAll(r2);
        return r0;
    }

    public static final SmartList<MemberScope> listOfNonEmptyScopes(Iterable<? extends MemberScope> r4) {
        Intrinsics.checkNotNullParameter(r4, "scopes");
        SmartList<MemberScope> r0 = new SmartList();
        Iterator<? extends MemberScope> r5 = r4.iterator();
    L4:
        if (r5.hasNext() == false) goto L14;
        MemberScope r1 = r5.next();
        MemberScope r2 = r1;
        if (r2 != null) goto L8;
    L10:
        boolean r3 = false;
    L11:
        if (r3 == false) goto L4;
        r0.add(r1);
        goto L4
    L8:
        if (r2 == MemberScope.Empty.INSTANCE) goto L10;
        r3 = true;
        goto L11
    L14:
        return r0;
    }
}
