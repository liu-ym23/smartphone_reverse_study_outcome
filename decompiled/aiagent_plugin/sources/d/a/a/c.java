package d.a.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/* JADX INFO: compiled from: ListBuilder.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class c {
    public static final /* synthetic */ String a(Object[] r2, int r3, int r4, Collection r5) {
        return b(r2, r3, r4, (Collection) ZeusTransformUtils.wrapperContextForParams(r5, Collection.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ boolean a(Object[] r2, int r3, int r4, List r5) {
        return b(r2, r3, r4, (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ int b(Object[] r0, int r1, int r2) {
        return c(r0, r1, r2);
    }

    public static final <E> E[] a(int r1) {
        if (r1 < 0) goto L4;
        boolean r0 = true;
    L5:
        if (r0 == false) goto L9;
        return (E[]) new Object[r1];
    L9:
        throw new IllegalArgumentException("capacity must be non-negative.".toString());
    L4:
        r0 = false;
        goto L5
    }

    private static final <T> String b(T[] r3, int r4, int r5, Collection<? extends T> r6) {
        Collection r7 = (Collection) ZeusTransformUtils.wrapperContextForParams(r6, Collection.class, "com.obric.aiagent.plugin");
        StringBuilder r0 = new StringBuilder((r5 * 3) + 2);
        r0.append("[");
        int r1 = 0;
    L3:
        if (r1 >= r5) goto L11;
        if (r1 <= 0) goto L6;
        r0.append(", ");
    L6:
        T r2 = r3[r4 + r1];
        if (r2 != r7) goto L9;
        r0.append("(this Collection)");
    L10:
        r1 = r1 + 1;
        goto L3
    L9:
        r0.append(r2);
        goto L10
    L11:
        r0.append("]");
        String r8 = r0.toString();
        o.c(r8, "toString(...)");
        return r8;
    }

    private static final <T> int c(T[] r4, int r5, int r6) {
        int r1 = 1;
        int r2 = 0;
    L3:
        if (r2 >= r6) goto L9;
        T r3 = r4[r5 + r2];
        int r7 = r1 * 31;
        if (r3 == null) goto L7;
        int r8 = r3.hashCode();
    L8:
        r1 = r7 + r8;
        r2 = r2 + 1;
        goto L3
    L7:
        r8 = 0;
        goto L8
    L9:
        return r1;
    }

    private static final <T> boolean b(T[] r4, int r5, int r6, List<?> r7) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.aiagent.plugin");
        if (r6 == r8.size()) goto L5;
        return false;
    L5:
        int r0 = 0;
    L6:
        if (r0 >= r6) goto L11;
        if (o.a(r4[r5 + r0], r8.get(r0)) == false) goto L9;
        r0 = r0 + 1;
        goto L6
    L9:
        return false;
    L11:
        return true;
    }

    public static final <T> T[] a(T[] r1, int r2) {
        o.e(r1, "<this>");
        T[] r3 = (T[]) Arrays.copyOf(r1, r2);
        o.c(r3, "copyOf(...)");
        return r3;
    }

    public static final <E> void b(E[] r1, int r2) {
        o.e(r1, "<this>");
        r1[r2] = null;
    }

    public static final <E> void a(E[] r1, int r2, int r3) {
        o.e(r1, "<this>");
    L3:
        if (r2 >= r3) goto L5;
        b(r1, r2);
        r2 = r2 + 1;
        goto L3
    }
}
