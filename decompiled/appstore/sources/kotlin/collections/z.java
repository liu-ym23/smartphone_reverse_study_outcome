package kotlin.collections;

import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public abstract class z extends y {
    public static final /* synthetic */ int G(List r10, int r11) {
        return L(r10, r11);
    }

    public static final /* synthetic */ int H(List r10, int r11) {
        return M(r10, r11);
    }

    public static final /* synthetic */ int I(List r10, int r11) {
        return N(r10, r11);
    }

    public static List J(List r10) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        return new o0(r10);
    }

    public static List K(List r10) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        return new n0(r10);
    }

    public static final int L(List r10, int r11) {
        if (new bg.c(0, t.k(r10)).f(r11) == false) goto L7;
        return t.k(r10) - r11;
    L7:
        throw new IndexOutOfBoundsException("Element index " + r11 + " must be in range [" + new bg.c(0, t.k(r10)) + "].");
    }

    public static final int M(List r10, int r11) {
        return t.k(r10) - r11;
    }

    public static final int N(List r10, int r11) {
        if (new bg.c(0, r10.size()).f(r11) == false) goto L7;
        return r10.size() - r11;
    L7:
        throw new IndexOutOfBoundsException("Position index " + r11 + " must be in range [" + new bg.c(0, r10.size()) + "].");
    }
}
