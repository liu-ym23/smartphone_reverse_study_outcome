package d.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/* JADX INFO: compiled from: _Sets.kt */
/* JADX INFO: loaded from: classes4.dex */
class ba extends az {
    public static final <T> Set<T> a(Set<? extends T> r7, T r8) {
        Set r9 = (Set) ZeusTransformUtils.wrapperContextForParams(r7, Set.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r9, "<this>");
        LinkedHashSet r0 = new LinkedHashSet(ao.a(r9.size()));
        Iterator<T> r10 = ((Iterable) ZeusTransformUtils.preCheckCast(r9, Iterable.class, "com.obric.aiagent.plugin")).iterator();
        boolean r3 = false;
    L4:
        if (r10.hasNext() == false) goto L13;
        T r4 = r10.next();
        boolean r5 = true;
        if (r3 == false) goto L8;
    L10:
        if (r5 == false) goto L4;
        ((Collection) ZeusTransformUtils.preCheckCast(r0, Collection.class, "com.obric.aiagent.plugin")).add(r4);
        goto L4
    L8:
        if (d.h.b.o.a(r4, r8) == false) goto L10;
        r3 = true;
        r5 = false;
        goto L10
    L13:
        return (Set) ZeusTransformUtils.preCheckCast((Collection) ZeusTransformUtils.preCheckCast(r0, Collection.class, "com.obric.aiagent.plugin"), Set.class, "com.obric.aiagent.plugin");
    }

    public static final <T> Set<T> a(Set<? extends T> r4, Iterable<? extends T> r5) {
        Set r6 = (Set) ZeusTransformUtils.wrapperContextForParams(r4, Set.class, "com.obric.aiagent.plugin");
        Iterable r7 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r5, Iterable.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r6, "<this>");
        d.h.b.o.e(r7, "elements");
        Collection<?> r8 = p.d(r7);
        if (r8.isEmpty() == false) goto L7;
        return p.q((Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.aiagent.plugin"));
    L7:
        if (ZeusTransformUtils.instanceOf(r8, Set.class) == false) goto L16;
        Iterable r9 = (Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.aiagent.plugin");
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Collection.class, "com.obric.aiagent.plugin");
        Iterator<T> r10 = r9.iterator();
    L10:
        if (r10.hasNext() == false) goto L15;
        T r2 = r10.next();
        if (r8.contains(r2) == true) goto L10;
        r0.add(r2);
        goto L10
    L15:
        return (Set) ZeusTransformUtils.preCheckCast(r0, Set.class, "com.obric.aiagent.plugin");
    L16:
        LinkedHashSet r1 = new LinkedHashSet((Collection) ZeusTransformUtils.preCheckCast(r6, Collection.class, "com.obric.aiagent.plugin"));
        r1.removeAll(r8);
        return (Set) ZeusTransformUtils.preCheckCast(r1, Set.class, "com.obric.aiagent.plugin");
    }

    public static final <T> Set<T> b(Set<? extends T> r3, T r4) {
        Set r5 = (Set) ZeusTransformUtils.wrapperContextForParams(r3, Set.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r5, "<this>");
        LinkedHashSet r0 = new LinkedHashSet(ao.a(r5.size() + 1));
        r0.addAll((Collection) ZeusTransformUtils.preCheckCast(r5, Collection.class, "com.obric.aiagent.plugin"));
        r0.add(r4);
        return (Set) ZeusTransformUtils.preCheckCast(r0, Set.class, "com.obric.aiagent.plugin");
    }

    public static final <T> Set<T> b(Set<? extends T> r3, Iterable<? extends T> r4) {
        Set r5 = (Set) ZeusTransformUtils.wrapperContextForParams(r3, Set.class, "com.obric.aiagent.plugin");
        Iterable r6 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r4, Iterable.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r5, "<this>");
        d.h.b.o.e(r6, "elements");
        Integer r0 = p.b(r6);
        if (r0 == null) goto L5;
        int r1 = ((Number) ZeusTransformUtils.preCheckCast(r0, Number.class, "com.obric.aiagent.plugin")).intValue();
        int r2 = r5.size() + r1;
    L6:
        LinkedHashSet r7 = new LinkedHashSet(ao.a(r2));
        r7.addAll((Collection) ZeusTransformUtils.preCheckCast(r5, Collection.class, "com.obric.aiagent.plugin"));
        p.a((Collection) ZeusTransformUtils.preCheckCast(r7, Collection.class, "com.obric.aiagent.plugin"), r6);
        return (Set) ZeusTransformUtils.preCheckCast(r7, Set.class, "com.obric.aiagent.plugin");
    L5:
        r2 = r5.size() * 2;
        goto L6
    }
}
