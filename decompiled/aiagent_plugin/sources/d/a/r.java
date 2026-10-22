package d.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* JADX INFO: compiled from: Collections.kt */
/* JADX INFO: loaded from: classes4.dex */
class r extends q {
    public static final <T> Collection<T> a(T[] r2) {
        d.h.b.o.e(r2, "<this>");
        return (Collection) ZeusTransformUtils.preCheckCast(new g(r2, false), Collection.class, "com.obric.aiagent.plugin");
    }

    public static final <T> List<T> b() {
        return (List) ZeusTransformUtils.preCheckCast(ab.f38345a, List.class, "com.obric.aiagent.plugin");
    }

    public static final <T> List<T> b(T... r1) {
        d.h.b.o.e(r1, "elements");
        if (r1.length <= 0) goto L6;
        return i.a(r1);
    L6:
        return p.b();
    }

    public static final <T> List<T> c(T... r4) {
        d.h.b.o.e(r4, "elements");
        if (r4.length != 0) goto L5;
        Object r5 = ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
    L7:
        return (List) r5;
    L5:
        r5 = ZeusTransformUtils.preCheckCast(new ArrayList((Collection) ZeusTransformUtils.preCheckCast(new g(r4, true), Collection.class, "com.obric.aiagent.plugin")), List.class, "com.obric.aiagent.plugin");
        goto L7
    }

    public static final <T> ArrayList<T> d(T... r3) {
        d.h.b.o.e(r3, "elements");
        if (r3.length != 0) goto L6;
        return new ArrayList();
    L6:
        return new ArrayList((Collection) ZeusTransformUtils.preCheckCast(new g(r3, true), Collection.class, "com.obric.aiagent.plugin"));
    }

    public static final <T> List<T> b(T r0) {
        if (r0 == null) goto L5;
        return p.a(r0);
    L5:
        return p.b();
    }

    public static final <T> List<T> e(T... r1) {
        d.h.b.o.e(r1, "elements");
        return i.e(r1);
    }

    public static final d.l.j a(Collection<?> r2) {
        Collection r3 = (Collection) ZeusTransformUtils.wrapperContextForParams(r2, Collection.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "<this>");
        return new d.l.j(0, r3.size() - 1);
    }

    public static final <T> int b(List<? extends T> r2) {
        List r3 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "<this>");
        return r3.size() - 1;
    }

    public static final <T> List<T> c(List<? extends T> r2) {
        List<T> r3 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "<this>");
        int r0 = r3.size();
        if (r0 == 0) goto L9;
        if (r0 == 1) goto L10;
        return r3;
    L10:
        return p.a(r3.get(0));
    L9:
        return p.b();
    }

    public static /* synthetic */ int a(List r1, Comparable r2, int r3, int r4, int r5, Object r6) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r1, List.class, "com.obric.aiagent.plugin");
        Comparable r8 = (Comparable) ZeusTransformUtils.wrapperContextForParams(r2, Comparable.class, "com.obric.aiagent.plugin");
        if ((r5 & 2) == 0) goto L6;
        r3 = 0;
    L6:
        if ((r5 & 4) == 0) goto L9;
        r4 = r7.size();
    L9:
        return p.a(r7, r8, r3, r4);
    }

    public static final <T extends Comparable<? super T>> int a(List<? extends T> r4, T r5, int r6, int r7) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        Comparable r9 = (Comparable) ZeusTransformUtils.wrapperContextForParams(r5, Comparable.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r8, "<this>");
        a(r8.size(), r6, r7);
        int r10 = r7 - 1;
    L3:
        if (r6 > r10) goto L11;
        int r0 = (r6 + r10) >>> 1;
        int r2 = d.b.a.a((Comparable) ZeusTransformUtils.preCheckCast(r8.get(r0), Comparable.class, "com.obric.aiagent.plugin"), r9);
        if (r2 < 0) goto L6;
        if (r2 <= 0) goto L9;
        r10 = r0 - 1;
        goto L3
    L9:
        return r0;
    L6:
        r6 = r0 + 1;
        goto L3
    L11:
        return -(r6 + 1);
    }

    private static final void a(int r3, int r4, int r5) {
        if (r4 > r5) goto L12;
        if (r4 < 0) goto L10;
        if (r5 > r3) goto L8;
        return;
    L8:
        throw new IndexOutOfBoundsException("toIndex (" + r5 + ") is greater than size (" + r3 + ").");
    L10:
        throw new IndexOutOfBoundsException("fromIndex (" + r4 + ") is less than zero.");
    L12:
        throw new IllegalArgumentException("fromIndex (" + r4 + ") is greater than toIndex (" + r5 + ").");
    }

    public static final void c() {
        throw new ArithmeticException("Index overflow has happened.");
    }

    public static final void d() {
        throw new ArithmeticException("Count overflow has happened.");
    }
}
