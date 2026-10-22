package kotlin.collections;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes4.dex */
public abstract class r0 extends q0 {
    public static Set e() {
        return EmptySet.INSTANCE;
    }

    public static HashSet f(Object... r10) {
        kotlin.jvm.internal.q.g(r10, "elements");
        return (HashSet) n.I(r10, new HashSet(j0.e(r10.length)));
    }

    public static Set g(Object... r10) {
        kotlin.jvm.internal.q.g(r10, "elements");
        return (Set) n.I(r10, new LinkedHashSet(j0.e(r10.length)));
    }

    public static final Set h(Set r10) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        int r11 = r10.size();
        if (r11 == 0) goto L9;
        if (r11 == 1) goto L10;
        return r10;
    L10:
        return q0.d(r10.iterator().next());
    L9:
        return e();
    }

    public static Set i(Object... r10) {
        kotlin.jvm.internal.q.g(r10, "elements");
        if (r10.length <= 0) goto L6;
        return n.O(r10);
    L6:
        return e();
    }
}
