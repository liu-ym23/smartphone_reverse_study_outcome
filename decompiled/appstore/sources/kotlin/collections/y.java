package kotlin.collections;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes4.dex */
public abstract class y extends x {
    public static boolean A(Iterable r10, Function1 r11) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        kotlin.jvm.internal.q.g(r11, "predicate");
        return y(r10, r11, true);
    }

    public static boolean B(List r10, Function1 r11) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        kotlin.jvm.internal.q.g(r11, "predicate");
        return z(r10, r11, true);
    }

    public static Object C(List r10) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        if (r10.isEmpty() == false) goto L6;
        return null;
    L6:
        return r10.remove(0);
    }

    public static Object D(List r10) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        if (r10.isEmpty() == true) goto L7;
        return r10.remove(t.k(r10));
    L7:
        throw new NoSuchElementException("List is empty.");
    }

    public static boolean E(Iterable r10, Function1 r11) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        kotlin.jvm.internal.q.g(r11, "predicate");
        return y(r10, r11, false);
    }

    public static final boolean F(Collection r10, Iterable r11) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        kotlin.jvm.internal.q.g(r11, "elements");
        return r10.retainAll(x(r11));
    }

    public static boolean v(Collection r10, Iterable r11) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        kotlin.jvm.internal.q.g(r11, "elements");
        if ((r11 instanceof Collection) == true) goto L5;
        Iterator r12 = r11.iterator();
        boolean r13 = false;
    L8:
        if (r12.hasNext() == false) goto L12;
        if (r10.add(r12.next()) == false) goto L8;
        r13 = true;
        goto L8
    L12:
        return r13;
    L5:
        return r10.addAll((Collection) r11);
    }

    public static boolean w(Collection r10, Object[] r11) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        kotlin.jvm.internal.q.g(r11, "elements");
        return r10.addAll(m.d(r11));
    }

    public static final Collection x(Iterable r10) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        if ((r10 instanceof Collection) == false) goto L6;
        return (Collection) r10;
    L6:
        return b0.x0(r10);
    }

    public static final boolean y(Iterable r10, Function1 r11, boolean r12) {
        Iterator r13 = r10.iterator();
        boolean r14 = false;
    L4:
        if (r13.hasNext() == false) goto L8;
        if (((Boolean) r11.invoke(r13.next())).booleanValue() != r12) goto L4;
        r13.remove();
        r14 = true;
        goto L4
    L8:
        return r14;
    }

    public static final boolean z(List r10, Function1 r11, boolean r12) {
        if ((r10 instanceof RandomAccess) == true) goto L6;
        kotlin.jvm.internal.q.e(r10, "null cannot be cast to non-null type kotlin.collections.MutableIterable<T of kotlin.collections.CollectionsKt__MutableCollectionsKt.filterInPlace>");
        return y(kotlin.jvm.internal.y.b(r10), r11, r12);
    L6:
        g0 r13 = new bg.c(0, t.k(r10)).d();
        int r14 = 0;
    L8:
        if (r13.hasNext() == false) goto L16;
        int r15 = r13.nextInt();
        Object r16 = r10.get(r15);
        if (((Boolean) r11.invoke(r16)).booleanValue() == r12) goto L8;
        if (r14 == r15) goto L14;
        r10.set(r14, r16);
    L14:
        r14 = r14 + 1;
        goto L8
    L16:
        if (r14 >= r10.size()) goto L24;
        int r17 = t.k(r10);
        if (r14 > r17) goto L22;
    L19:
        r10.remove(r17);
        if (r17 == r14) goto L31;
        r17 = r17 - 1;
        goto L19
    L31:
        return true;
    L22:
        return true;
    L24:
        return false;
    }
}
