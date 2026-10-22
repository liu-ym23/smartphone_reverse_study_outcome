package kotlin.collections.builders;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes4.dex */
public abstract class b {
    public static final /* synthetic */ boolean a(Object[] r10, int r11, int r12, List r13) {
        return h(r10, r11, r12, r13);
    }

    public static final /* synthetic */ int b(Object[] r10, int r11, int r12) {
        return i(r10, r11, r12);
    }

    public static final /* synthetic */ String c(Object[] r10, int r11, int r12, Collection r13) {
        return j(r10, r11, r12, r13);
    }

    public static final Object[] d(int r10) {
        if (r10 < 0) goto L6;
        return new Object[r10];
    L6:
        throw new IllegalArgumentException("capacity must be non-negative.");
    }

    public static final Object[] e(Object[] r10, int r11) {
        q.g(r10, "<this>");
        Object[] r12 = Arrays.copyOf(r10, r11);
        q.f(r12, "copyOf(...)");
        return r12;
    }

    public static final void f(Object[] r10, int r11) {
        q.g(r10, "<this>");
        r10[r11] = null;
    }

    public static final void g(Object[] r10, int r11, int r12) {
        q.g(r10, "<this>");
    L3:
        if (r11 >= r12) goto L5;
        f(r10, r11);
        r11 = r11 + 1;
        goto L3
    }

    public static final boolean h(Object[] r10, int r11, int r12, List r13) {
        if (r12 == r13.size()) goto L5;
        return false;
    L5:
        int r14 = 0;
    L6:
        if (r14 >= r12) goto L11;
        if (q.b(r10[r11 + r14], r13.get(r14)) == false) goto L9;
        r14 = r14 + 1;
        goto L6
    L9:
        return false;
    L11:
        return true;
    }

    public static final int i(Object[] r10, int r11, int r12) {
        int r13 = 1;
        int r14 = 0;
    L3:
        if (r14 >= r12) goto L9;
        Object r15 = r10[r11 + r14];
        int r16 = r13 * 31;
        if (r15 == null) goto L7;
        int r17 = r15.hashCode();
    L8:
        r13 = r16 + r17;
        r14 = r14 + 1;
        goto L3
    L7:
        r17 = 0;
        goto L8
    L9:
        return r13;
    }

    public static final String j(Object[] r10, int r11, int r12, Collection r13) {
        StringBuilder r14 = new StringBuilder((r12 * 3) + 2);
        r14.append("[");
        int r15 = 0;
    L3:
        if (r15 >= r12) goto L11;
        if (r15 <= 0) goto L6;
        r14.append(", ");
    L6:
        Object r16 = r10[r11 + r15];
        if (r16 != r13) goto L9;
        r14.append("(this Collection)");
    L10:
        r15 = r15 + 1;
        goto L3
    L9:
        r14.append(r16);
        goto L10
    L11:
        r14.append("]");
        String r17 = r14.toString();
        q.f(r17, "toString(...)");
        return r17;
    }
}
