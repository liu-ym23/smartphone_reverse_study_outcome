package W3;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class H extends G {
    public static <K, V> Map<K, V> d() {
        A a6 = A.f5744a;
        j4.k.e(a6, "null cannot be cast to non-null type kotlin.collections.Map<K of kotlin.collections.MapsKt__MapsKt.emptyMap, V of kotlin.collections.MapsKt__MapsKt.emptyMap>");
        return a6;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, V> Map<K, V> e(Map<K, ? extends V> map) {
        j4.k.g(map, "<this>");
        int size = map.size();
        return size != 0 ? size != 1 ? map : G.c(map) : d();
    }

    public static final <K, V> void f(Map<? super K, ? super V> map, Iterable<? extends V3.m<? extends K, ? extends V>> iterable) {
        j4.k.g(map, "<this>");
        j4.k.g(iterable, "pairs");
        for (V3.m<? extends K, ? extends V> mVar : iterable) {
            map.put(mVar.a(), mVar.b());
        }
    }

    public static <K, V> Map<K, V> g(Iterable<? extends V3.m<? extends K, ? extends V>> iterable) {
        j4.k.g(iterable, "<this>");
        if (!(iterable instanceof Collection)) {
            return e(h(iterable, new LinkedHashMap()));
        }
        Collection collection = (Collection) iterable;
        int size = collection.size();
        if (size == 0) {
            return d();
        }
        if (size != 1) {
            return h(iterable, new LinkedHashMap(G.a(collection.size())));
        }
        return G.b((V3.m) (iterable instanceof List ? ((List) iterable).get(0) : collection.iterator().next()));
    }

    public static final <K, V, M extends Map<? super K, ? super V>> M h(Iterable<? extends V3.m<? extends K, ? extends V>> iterable, M m5) {
        j4.k.g(iterable, "<this>");
        j4.k.g(m5, "destination");
        f(m5, iterable);
        return m5;
    }

    public static <K, V> Map<K, V> i(Map<? extends K, ? extends V> map) {
        j4.k.g(map, "<this>");
        int size = map.size();
        return size != 0 ? size != 1 ? j(map) : G.c(map) : d();
    }

    public static <K, V> Map<K, V> j(Map<? extends K, ? extends V> map) {
        j4.k.g(map, "<this>");
        return new LinkedHashMap(map);
    }
}
