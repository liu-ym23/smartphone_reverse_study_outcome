package d.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: Maps.kt */
/* JADX INFO: loaded from: classes4.dex */
class ar extends aq {
    public static final <K, V> Map<K, V> b() {
        ac r0 = ac.f38346a;
        d.h.b.o.a(r0, "null cannot be cast to non-null type kotlin.collections.Map<K of kotlin.collections.MapsKt__MapsKt.emptyMap, V of kotlin.collections.MapsKt__MapsKt.emptyMap>");
        return (Map) ZeusTransformUtils.preCheckCast(r0, Map.class, "com.obric.aiagent.plugin");
    }

    public static final <K, V> Map<K, V> a(d.m<? extends K, ? extends V>... r3) {
        d.h.b.o.e(r3, "pairs");
        if (r3.length <= 0) goto L6;
        return ao.a(r3, (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(ao.a(r3.length)), Map.class, "com.obric.aiagent.plugin"));
    L6:
        return ao.b();
    }

    public static final <K, V> Map<K, V> b(d.m<? extends K, ? extends V>... r3) {
        d.h.b.o.e(r3, "pairs");
        LinkedHashMap r0 = new LinkedHashMap(ao.a(r3.length));
        ao.a((Map) ZeusTransformUtils.preCheckCast(r0, Map.class, "com.obric.aiagent.plugin"), r3);
        return (Map) ZeusTransformUtils.preCheckCast(r0, Map.class, "com.obric.aiagent.plugin");
    }

    public static final <K, V> HashMap<K, V> c(d.m<? extends K, ? extends V>... r3) {
        d.h.b.o.e(r3, "pairs");
        HashMap<K, V> r0 = new HashMap(ao.a(r3.length));
        ao.a((Map) ZeusTransformUtils.preCheckCast(r0, Map.class, "com.obric.aiagent.plugin"), r3);
        return r0;
    }

    public static final <K, V> LinkedHashMap<K, V> d(d.m<? extends K, ? extends V>... r3) {
        d.h.b.o.e(r3, "pairs");
        return (LinkedHashMap) ZeusTransformUtils.preCheckCast(ao.a(r3, (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(ao.a(r3.length)), Map.class, "com.obric.aiagent.plugin")), LinkedHashMap.class, "com.obric.aiagent.plugin");
    }

    public static final <K, V> V b(Map<K, ? extends V> r2, K r3) {
        Map r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "<this>");
        return (V) ao.a(r4, r3);
    }

    public static final <K, V> void a(Map<? super K, ? super V> r4, d.m<? extends K, ? extends V>[] r5) {
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r6, "<this>");
        d.h.b.o.e(r5, "pairs");
        int r0 = r5.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        d.m<? extends K, ? extends V> r2 = r5[r1];
        r6.put(r2.c(), r2.d());
        r1 = r1 + 1;
        goto L3
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, V> void a(Map<? super K, ? super V> r3, Iterable<? extends d.m<? extends K, ? extends V>> r4) {
        Map r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
        Iterable r6 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r4, Iterable.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r5, "<this>");
        d.h.b.o.e(r6, "pairs");
        Iterator r7 = r6.iterator();
    L4:
        if (r7.hasNext() == false) goto L6;
        d.m r0 = (d.m) ZeusTransformUtils.preCheckCast(r7.next(), d.m.class, "com.obric.aiagent.plugin");
        r5.put(r0.c(), r0.d());
        goto L4
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, V> void a(Map<? super K, ? super V> r3, d.n.j<? extends d.m<? extends K, ? extends V>> r4) {
        Map r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
        d.n.j r6 = (d.n.j) ZeusTransformUtils.wrapperContextForParams(r4, d.n.j.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r5, "<this>");
        d.h.b.o.e(r6, "pairs");
        Iterator r7 = r6.a();
    L4:
        if (r7.hasNext() == false) goto L6;
        d.m r0 = (d.m) ZeusTransformUtils.preCheckCast(r7.next(), d.m.class, "com.obric.aiagent.plugin");
        r5.put(r0.c(), r0.d());
        goto L4
    }

    public static final <K, V> Map<K, V> a(Iterable<? extends d.m<? extends K, ? extends V>> r3) {
        Iterable r4 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r3, Iterable.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "<this>");
        if (ZeusTransformUtils.instanceOf(r4, Collection.class) == false) goto L17;
        int r0 = ((Collection) ZeusTransformUtils.preCheckCast(r4, Collection.class, "com.obric.aiagent.plugin")).size();
        if (r0 == 0) goto L15;
        if (r0 == 1) goto L10;
        return ao.a(r4, (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(ao.a(((Collection) ZeusTransformUtils.preCheckCast(r4, Collection.class, "com.obric.aiagent.plugin")).size())), Map.class, "com.obric.aiagent.plugin"));
    L10:
        if (ZeusTransformUtils.instanceOf(r4, List.class) == false) goto L12;
        Object r5 = ((List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.aiagent.plugin")).get(0);
    L19:
        return ao.a((d.m) ZeusTransformUtils.preCheckCast(r5, d.m.class, "com.obric.aiagent.plugin"));
    L12:
        r5 = r4.iterator().next();
        goto L19
    L15:
        return ao.b();
    L17:
        return ao.f(ao.a(r4, (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin")));
    }

    public static final <K, V, M extends Map<? super K, ? super V>> M a(Iterable<? extends d.m<? extends K, ? extends V>> r2, M r3) {
        Iterable r4 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r2, Iterable.class, "com.obric.aiagent.plugin");
        M r5 = (M) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "<this>");
        d.h.b.o.e(r5, "destination");
        ao.a(r5, r4);
        return r5;
    }

    public static final <K, V, M extends Map<? super K, ? super V>> M a(d.m<? extends K, ? extends V>[] r2, M r3) {
        M r4 = (M) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r2, "<this>");
        d.h.b.o.e(r4, "destination");
        ao.a(r4, r2);
        return r4;
    }

    public static final <K, V> Map<K, V> a(d.n.j<? extends d.m<? extends K, ? extends V>> r3) {
        d.n.j r4 = (d.n.j) ZeusTransformUtils.wrapperContextForParams(r3, d.n.j.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "<this>");
        return ao.f(ao.a(r4, (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin")));
    }

    public static final <K, V, M extends Map<? super K, ? super V>> M a(d.n.j<? extends d.m<? extends K, ? extends V>> r2, M r3) {
        d.n.j r4 = (d.n.j) ZeusTransformUtils.wrapperContextForParams(r2, d.n.j.class, "com.obric.aiagent.plugin");
        M r5 = (M) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "<this>");
        d.h.b.o.e(r5, "destination");
        ao.a(r5, r4);
        return r5;
    }

    public static final <K, V> Map<K, V> d(Map<? extends K, ? extends V> r2) {
        Map r3 = (Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "<this>");
        int r0 = r3.size();
        if (r0 == 0) goto L9;
        if (r0 == 1) goto L11;
        return ao.e(r3);
    L11:
        return ao.c(r3);
    L9:
        return ao.b();
    }

    public static final <K, V> Map<K, V> e(Map<? extends K, ? extends V> r2) {
        Map r3 = (Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "<this>");
        return (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(r3), Map.class, "com.obric.aiagent.plugin");
    }

    public static final <K, V> Map<K, V> a(Map<? extends K, ? extends V> r2, d.m<? extends K, ? extends V> r3) {
        Map r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "<this>");
        d.h.b.o.e(r3, "pair");
        if (r4.isEmpty() == true) goto L7;
        LinkedHashMap r0 = new LinkedHashMap(r4);
        r0.put(r3.a(), r3.b());
        return (Map) ZeusTransformUtils.preCheckCast(r0, Map.class, "com.obric.aiagent.plugin");
    L7:
        return ao.a(r3);
    }

    public static final <K, V> Map<K, V> a(Map<? extends K, ? extends V> r2, Map<? extends K, ? extends V> r3) {
        Map r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.aiagent.plugin");
        Map<? extends K, ? extends V> r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "<this>");
        d.h.b.o.e(r5, "map");
        LinkedHashMap r0 = new LinkedHashMap(r4);
        r0.putAll(r5);
        return (Map) ZeusTransformUtils.preCheckCast(r0, Map.class, "com.obric.aiagent.plugin");
    }

    public static final <K, V> Map<K, V> f(Map<K, ? extends V> r2) {
        Map<K, V> r3 = (Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "<this>");
        int r0 = r3.size();
        if (r0 == 0) goto L9;
        if (r0 == 1) goto L10;
        return r3;
    L10:
        return ao.c(r3);
    L9:
        return ao.b();
    }
}
