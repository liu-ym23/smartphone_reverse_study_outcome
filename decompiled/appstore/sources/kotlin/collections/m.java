package kotlin.collections;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public abstract class m extends l {
    public static List d(Object[] r10) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        List r11 = o.a(r10);
        kotlin.jvm.internal.q.f(r11, "asList(...)");
        return r11;
    }

    public static Object[] e(Object[] r10, Object[] r11, int r12, int r13, int r14) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        kotlin.jvm.internal.q.g(r11, "destination");
        System.arraycopy(r10, r13, r11, r12, r14 - r13);
        return r11;
    }

    public static /* synthetic */ Object[] f(Object[] r10, Object[] r11, int r12, int r13, int r14, int r15, Object r16) {
        if ((r15 & 2) == 0) goto L6;
        r12 = 0;
    L6:
        if ((r15 & 4) == 0) goto L9;
        r13 = 0;
    L9:
        if ((r15 & 8) == 0) goto L12;
        r14 = r10.length;
    L12:
        return e(r10, r11, r12, r13, r14);
    }

    public static Object[] g(Object[] r10, int r11, int r12) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        k.b(r12, r10.length);
        Object[] r13 = Arrays.copyOfRange(r10, r11, r12);
        kotlin.jvm.internal.q.f(r13, "copyOfRange(...)");
        return r13;
    }

    public static void h(int[] r10, int r11, int r12, int r13) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        Arrays.fill(r10, r12, r13, r11);
    }

    public static final void i(Object[] r10, Object r11, int r12, int r13) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        Arrays.fill(r10, r12, r13, r11);
    }

    public static /* synthetic */ void j(Object[] r10, Object r11, int r12, int r13, int r14, Object r15) {
        if ((r14 & 2) == 0) goto L6;
        r12 = 0;
    L6:
        if ((r14 & 4) == 0) goto L8;
        r13 = r10.length;
    L8:
        i(r10, r11, r12, r13);
    }

    public static final void k(Object[] r10) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        if (r10.length <= 1) goto L6;
        Arrays.sort(r10);
        return;
    }

    public static final void l(Object[] r10, Comparator r11) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        kotlin.jvm.internal.q.g(r11, "comparator");
        if (r10.length <= 1) goto L6;
        Arrays.sort(r10, r11);
        return;
    }
}
