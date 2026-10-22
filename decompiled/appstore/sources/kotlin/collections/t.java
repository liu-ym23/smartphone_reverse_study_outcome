package kotlin.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public abstract class t extends s {
    public static ArrayList g(Object... r10) {
        kotlin.jvm.internal.q.g(r10, "elements");
        if (r10.length != 0) goto L6;
        return new ArrayList();
    L6:
        return new ArrayList(new h(r10, true));
    }

    public static final Collection h(Object[] r10) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        return new h(r10, false);
    }

    public static List i() {
        return EmptyList.INSTANCE;
    }

    public static bg.c j(Collection r10) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        return new bg.c(0, r10.size() - 1);
    }

    public static int k(List r10) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        return r10.size() - 1;
    }

    public static List l(Object... r10) {
        kotlin.jvm.internal.q.g(r10, "elements");
        if (r10.length <= 0) goto L6;
        return m.d(r10);
    L6:
        return i();
    }

    public static List m(Object... r10) {
        kotlin.jvm.internal.q.g(r10, "elements");
        return n.q(r10);
    }

    public static List n(Object... r10) {
        kotlin.jvm.internal.q.g(r10, "elements");
        if (r10.length != 0) goto L6;
        return new ArrayList();
    L6:
        return new ArrayList(new h(r10, true));
    }

    public static final List o(List r10) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        int r11 = r10.size();
        if (r11 == 0) goto L9;
        if (r11 == 1) goto L10;
        return r10;
    L10:
        return s.e(r10.get(0));
    L9:
        return i();
    }

    public static void p() {
        throw new ArithmeticException("Count overflow has happened.");
    }

    public static void q() {
        throw new ArithmeticException("Index overflow has happened.");
    }
}
