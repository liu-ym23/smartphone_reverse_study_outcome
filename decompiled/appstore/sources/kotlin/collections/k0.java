package kotlin.collections;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;

/* JADX INFO: loaded from: classes4.dex */
public abstract class k0 extends j0 {
    public static Map h() {
        EmptyMap r10 = EmptyMap.INSTANCE;
        kotlin.jvm.internal.q.e(r10, "null cannot be cast to non-null type kotlin.collections.Map<K of kotlin.collections.MapsKt__MapsKt.emptyMap, V of kotlin.collections.MapsKt__MapsKt.emptyMap>");
        return r10;
    }

    public static Object i(Map r10, Object r11) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        return i0.a(r10, r11);
    }

    public static Map j(Pair... r10) {
        kotlin.jvm.internal.q.g(r10, "pairs");
        if (r10.length <= 0) goto L6;
        return t(r10, new LinkedHashMap(j0.e(r10.length)));
    L6:
        return h();
    }

    public static Map k(Map r10, Object r11) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        Map r12 = u(r10);
        r12.remove(r11);
        return m(r12);
    }

    public static Map l(Pair... r10) {
        kotlin.jvm.internal.q.g(r10, "pairs");
        LinkedHashMap r11 = new LinkedHashMap(j0.e(r10.length));
        p(r11, r10);
        return r11;
    }

    public static final Map m(Map r10) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        int r11 = r10.size();
        if (r11 == 0) goto L9;
        if (r11 == 1) goto L10;
        return r10;
    L10:
        return j0.g(r10);
    L9:
        return h();
    }

    public static Map n(Map r10, Pair r11) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        kotlin.jvm.internal.q.g(r11, "pair");
        if (r10.isEmpty() == true) goto L7;
        LinkedHashMap r12 = new LinkedHashMap(r10);
        r12.put(r11.getFirst(), r11.getSecond());
        return r12;
    L7:
        return j0.f(r11);
    }

    public static final void o(Map r10, Iterable r11) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        kotlin.jvm.internal.q.g(r11, "pairs");
        Iterator r12 = r11.iterator();
    L4:
        if (r12.hasNext() == false) goto L6;
        Pair r13 = (Pair) r12.next();
        r10.put(r13.component1(), r13.component2());
        goto L4
    }

    public static final void p(Map r10, Pair[] r11) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        kotlin.jvm.internal.q.g(r11, "pairs");
        int r12 = r11.length;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L5;
        Pair r14 = r11[r13];
        r10.put(r14.component1(), r14.component2());
        r13 = r13 + 1;
        goto L3
    }

    public static Map q(Iterable r10) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        if ((r10 instanceof Collection) == false) goto L18;
        Collection r11 = (Collection) r10;
        int r12 = r11.size();
        if (r12 == 0) goto L16;
        if (r12 == 1) goto L10;
        return r(r10, new LinkedHashMap(j0.e(r11.size())));
    L10:
        if ((r10 instanceof List) == false) goto L13;
        Object r13 = ((List) r10).get(0);
    L20:
        return j0.f((Pair) r13);
    L13:
        r13 = r10.iterator().next();
        goto L20
    L16:
        return h();
    L18:
        return m(r(r10, new LinkedHashMap()));
    }

    public static final Map r(Iterable r10, Map r11) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        kotlin.jvm.internal.q.g(r11, "destination");
        o(r11, r10);
        return r11;
    }

    public static Map s(Map r10) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        int r11 = r10.size();
        if (r11 == 0) goto L9;
        if (r11 == 1) goto L11;
        return u(r10);
    L11:
        return j0.g(r10);
    L9:
        return h();
    }

    public static final Map t(Pair[] r10, Map r11) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        kotlin.jvm.internal.q.g(r11, "destination");
        p(r11, r10);
        return r11;
    }

    public static Map u(Map r10) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        return new LinkedHashMap(r10);
    }
}
