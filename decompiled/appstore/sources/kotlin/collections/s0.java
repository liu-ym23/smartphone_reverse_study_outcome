package kotlin.collections;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes4.dex */
public abstract class s0 extends r0 {
    public static Set j(Set r10, Object r11) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        LinkedHashSet r12 = new LinkedHashSet(j0.e(r10.size()));
        Iterator r13 = r10.iterator();
        boolean r14 = false;
    L4:
        if (r13.hasNext() == false) goto L12;
        Object r15 = r13.next();
        boolean r16 = true;
        if (r14 == false) goto L8;
    L10:
        if (r16 == false) goto L4;
        r12.add(r15);
        goto L4
    L8:
        if (kotlin.jvm.internal.q.b(r15, r11) == false) goto L10;
        r14 = true;
        r16 = false;
        goto L10
    L12:
        return r12;
    }

    public static Set k(Set r10, Iterable r11) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        kotlin.jvm.internal.q.g(r11, "elements");
        Integer r12 = u.s(r11);
        if (r12 == null) goto L5;
        int r13 = r12.intValue();
        int r14 = r10.size() + r13;
    L6:
        LinkedHashSet r15 = new LinkedHashSet(j0.e(r14));
        r15.addAll(r10);
        y.v(r15, r11);
        return r15;
    L5:
        r14 = r10.size() * 2;
        goto L6
    }
}
