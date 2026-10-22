package d.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.RandomAccess;

/* JADX INFO: compiled from: MutableCollections.kt */
/* JADX INFO: loaded from: classes4.dex */
class w extends v {
    public static final <T> boolean a(Collection<? super T> r2, Iterable<? extends T> r3) {
        Collection r4 = (Collection) ZeusTransformUtils.wrapperContextForParams(r2, Collection.class, "com.obric.aiagent.plugin");
        Iterable r5 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r3, Iterable.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "<this>");
        d.h.b.o.e(r5, "elements");
        if (ZeusTransformUtils.instanceOf(r5, Collection.class) == true) goto L5;
        boolean r0 = false;
        Iterator<T> r6 = r5.iterator();
    L8:
        if (r6.hasNext() == false) goto L12;
        if (r4.add(r6.next()) == false) goto L8;
        r0 = true;
        goto L8
    L12:
        return r0;
    L5:
        return r4.addAll((Collection) ZeusTransformUtils.preCheckCast(r5, Collection.class, "com.obric.aiagent.plugin"));
    }

    public static final <T> boolean a(Collection<? super T> r2, T[] r3) {
        Collection r4 = (Collection) ZeusTransformUtils.wrapperContextForParams(r2, Collection.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "<this>");
        d.h.b.o.e(r3, "elements");
        return r4.addAll((Collection) ZeusTransformUtils.preCheckCast(i.a(r3), Collection.class, "com.obric.aiagent.plugin"));
    }

    public static final <T> Collection<T> d(Iterable<? extends T> r2) {
        Iterable r3 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r2, Iterable.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "<this>");
        if (ZeusTransformUtils.instanceOf(r3, Collection.class) == true) goto L7;
        r3 = p.o(r3);
    L7:
        return (Collection) ZeusTransformUtils.preCheckCast(r3, Collection.class, "com.obric.aiagent.plugin");
    }

    public static final <T> boolean b(Collection<? super T> r2, Iterable<? extends T> r3) {
        Collection r4 = (Collection) ZeusTransformUtils.wrapperContextForParams(r2, Collection.class, "com.obric.aiagent.plugin");
        Iterable r5 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r3, Iterable.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "<this>");
        d.h.b.o.e(r5, "elements");
        return r4.retainAll(p.d(r5));
    }

    public static final <T> boolean a(Iterable<? extends T> r2, d.h.a.b<? super T, Boolean> r3) {
        Iterable r4 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r2, Iterable.class, "com.obric.aiagent.plugin");
        d.h.a.b r5 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "<this>");
        d.h.b.o.e(r5, "predicate");
        return a(r4, r5, true);
    }

    private static final <T> boolean a(Iterable<? extends T> r4, d.h.a.b<? super T, Boolean> r5, boolean r6) {
        Iterable r7 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r4, Iterable.class, "com.obric.aiagent.plugin");
        d.h.a.b r8 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r5, d.h.a.b.class, "com.obric.aiagent.plugin");
        Iterator<T> r9 = r7.iterator();
        boolean r0 = false;
    L4:
        if (r9.hasNext() == false) goto L8;
        if (((Boolean) ZeusTransformUtils.preCheckCast(r8.invoke(r9.next()), Boolean.class, "com.obric.aiagent.plugin")).booleanValue() != r6) goto L4;
        r9.remove();
        r0 = true;
        goto L4
    L8:
        return r0;
    }

    public static final <T> T e(List<T> r2) {
        List r3 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "<this>");
        if (r3.isEmpty() == true) goto L7;
        return (T) r3.remove(0);
    L7:
        throw new NoSuchElementException("List is empty.");
    }

    public static final <T> T f(List<T> r2) {
        List r3 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "<this>");
        if (r3.isEmpty() == false) goto L6;
        return null;
    L6:
        return (T) r3.remove(0);
    }

    public static final <T> T g(List<T> r2) {
        List r3 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "<this>");
        if (r3.isEmpty() == true) goto L7;
        return (T) r3.remove(p.b(r3));
    L7:
        throw new NoSuchElementException("List is empty.");
    }

    public static final <T> boolean a(List<T> r2, d.h.a.b<? super T, Boolean> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin");
        d.h.a.b r5 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "<this>");
        d.h.b.o.e(r5, "predicate");
        return a(r4, r5, true);
    }

    private static final <T> boolean a(List<T> r8, d.h.a.b<? super T, Boolean> r9, boolean r10) {
        List r11 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.aiagent.plugin");
        d.h.a.b r12 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r9, d.h.a.b.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r11, RandomAccess.class) == true) goto L6;
        d.h.b.o.a(r11, "null cannot be cast to non-null type kotlin.collections.MutableIterable<T of kotlin.collections.CollectionsKt__MutableCollectionsKt.filterInPlace>");
        return a(d.h.b.ae.a(r11), r12, r10);
    L6:
        int r0 = p.b(r11);
        if (r0 < 0) goto L17;
        int r3 = 0;
        int r4 = 0;
    L9:
        Object r5 = r11.get(r3);
        if (((Boolean) ZeusTransformUtils.preCheckCast(r12.invoke(r5), Boolean.class, "com.obric.aiagent.plugin")).booleanValue() == r10) goto L15;
        if (r4 == r3) goto L14;
        r11.set(r4, r5);
    L14:
        r4 = r4 + 1;
    L15:
        if (r3 == r0) goto L19;
        r3 = r3 + 1;
    L19:
        if (r4 >= r11.size()) goto L27;
        int r13 = p.b(r11);
        if (r4 > r13) goto L25;
    L22:
        r11.remove(r13);
        if (r13 == r4) goto L30;
        r13 = r13 - 1;
        goto L22
    L30:
        return true;
    L25:
        return true;
    L27:
        return false;
    L17:
        r4 = 0;
        goto L19
    }
}
