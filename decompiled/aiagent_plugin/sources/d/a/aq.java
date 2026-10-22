package d.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collections;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

/* JADX INFO: compiled from: MapsJVM.kt */
/* JADX INFO: loaded from: classes4.dex */
class aq extends ap {
    public static final int a(int r1) {
        if (r1 >= 0) goto L5;
        return r1;
    L5:
        if (r1 >= 3) goto L8;
        return r1 + 1;
    L8:
        if (r1 < 1073741824) goto L13;
        return Integer.MAX_VALUE;
    L13:
        return (int) ((r1 / 0.75f) + 1.0f);
    }

    public static final <K, V> Map<K, V> a(d.m<? extends K, ? extends V> r1) {
        d.h.b.o.e(r1, "pair");
        Map<K, V> r2 = Collections.singletonMap(r1.a(), r1.b());
        d.h.b.o.c(r2, "singletonMap(...)");
        return r2;
    }

    public static final <K, V> Map<K, V> a() {
        return (Map) ZeusTransformUtils.preCheckCast(new d.a.a.d(), Map.class, "com.obric.aiagent.plugin");
    }

    public static final <K, V> Map<K, V> a(Map<K, V> r2) {
        Map r3 = (Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "builder");
        return ((d.a.a.d) ZeusTransformUtils.preCheckCast(r3, d.a.a.d.class, "com.obric.aiagent.plugin")).b();
    }

    public static final <K extends Comparable<? super K>, V> SortedMap<K, V> b(Map<? extends K, ? extends V> r2) {
        Map r3 = (Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "<this>");
        return (SortedMap) ZeusTransformUtils.preCheckCast(new TreeMap(r3), SortedMap.class, "com.obric.aiagent.plugin");
    }

    public static final <K, V> Map<K, V> c(Map<? extends K, ? extends V> r2) {
        Map r3 = (Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "<this>");
        Map.Entry r4 = (Map.Entry) ZeusTransformUtils.preCheckCast(r3.entrySet().iterator().next(), Map.Entry.class, "com.obric.aiagent.plugin");
        Map<K, V> r5 = Collections.singletonMap(r4.getKey(), r4.getValue());
        d.h.b.o.c(r5, "with(...)");
        return r5;
    }
}
