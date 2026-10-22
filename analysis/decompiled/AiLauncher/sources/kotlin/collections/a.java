package kotlin.collections;

import Ka.j;
import Z8.A;
import Z8.P;
import Z8.Q;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.voice.support.C3081a;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000N\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001c\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001e\u001a%\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001¢\u0006\u0004\b\u0003\u0010\u0004\u001aQ\u0010\b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012*\u0010\u0007\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00060\u0005\"\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006¢\u0006\u0004\b\b\u0010\t\u001aQ\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\n\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012*\u0010\u0007\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00060\u0005\"\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006¢\u0006\u0004\b\u000b\u0010\t\u001aa\u0010\u000e\u001a\u001e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\fj\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001`\r\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012*\u0010\u0007\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00060\u0005\"\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006¢\u0006\u0004\b\u000e\u0010\u000f\u001aa\u0010\u0012\u001a\u001e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0010j\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001`\u0011\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012*\u0010\u0007\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00060\u0005\"\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006¢\u0006\u0004\b\u0012\u0010\u0013\u001a3\u0010\u0015\u001a\u00028\u0001\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022\u0006\u0010\u0014\u001a\u00028\u0000H\u0007¢\u0006\u0004\b\u0015\u0010\u0016\u001aI\u0010\u0018\u001a\u00020\u0017\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0012\u0012\u0006\b\u0000\u0012\u00028\u0000\u0012\u0006\b\u0000\u0012\u00028\u00010\n2\u001a\u0010\u0007\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00060\u0005¢\u0006\u0004\b\u0018\u0010\u0019\u001aG\u0010\u001b\u001a\u00020\u0017\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0012\u0012\u0006\b\u0000\u0012\u00028\u0000\u0012\u0006\b\u0000\u0012\u00028\u00010\n2\u0018\u0010\u0007\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00060\u001a¢\u0006\u0004\b\u001b\u0010\u001c\u001aG\u0010\u001e\u001a\u00020\u0017\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0012\u0012\u0006\b\u0000\u0012\u00028\u0000\u0012\u0006\b\u0000\u0012\u00028\u00010\n2\u0018\u0010\u0007\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00060\u001d¢\u0006\u0004\b\u001e\u0010\u001f\u001a;\u0010 \u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00060\u001a¢\u0006\u0004\b \u0010!\u001aQ\u0010$\u001a\u00028\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0018\b\u0002\u0010\"*\u0012\u0012\u0006\b\u0000\u0012\u00028\u0000\u0012\u0006\b\u0000\u0012\u00028\u00010\n*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00060\u001a2\u0006\u0010#\u001a\u00028\u0002¢\u0006\u0004\b$\u0010%\u001aS\u0010&\u001a\u00028\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0018\b\u0002\u0010\"*\u0012\u0012\u0006\b\u0000\u0012\u00028\u0000\u0012\u0006\b\u0000\u0012\u00028\u00010\n*\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00060\u00052\u0006\u0010#\u001a\u00028\u0002¢\u0006\u0004\b&\u0010'\u001a;\u0010(\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00060\u001d¢\u0006\u0004\b(\u0010)\u001aQ\u0010*\u001a\u00028\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0018\b\u0002\u0010\"*\u0012\u0012\u0006\b\u0000\u0012\u00028\u0000\u0012\u0006\b\u0000\u0012\u00028\u00010\n*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00060\u001d2\u0006\u0010#\u001a\u00028\u0002¢\u0006\u0004\b*\u0010+\u001a9\u0010,\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002H\u0007¢\u0006\u0004\b,\u0010-\u001a9\u0010.\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\n\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002H\u0007¢\u0006\u0004\b.\u0010-\u001aN\u00100\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022\u0012\u0010/\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006H\u0086\u0002¢\u0006\u0004\b0\u00101\u001aP\u00103\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022\u0014\u00102\u001a\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002H\u0086\u0002¢\u0006\u0004\b3\u00104\u001aB\u00105\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022\u0006\u0010\u0014\u001a\u00028\u0000H\u0087\u0002¢\u0006\u0004\b5\u00106\u001aH\u00108\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022\f\u00107\u001a\b\u0012\u0004\u0012\u00028\u00000\u001aH\u0087\u0002¢\u0006\u0004\b8\u00109\u001a7\u0010:\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002H\u0000¢\u0006\u0004\b:\u0010-¨\u0006;"}, d2 = {"K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "()Ljava/util/Map;", "", "Lkotlin/Pair;", "pairs", "m", "([Lkotlin/Pair;)Ljava/util/Map;", "", "p", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "k", "([Lkotlin/Pair;)Ljava/util/HashMap;", "Ljava/util/LinkedHashMap;", "Lkotlin/collections/LinkedHashMap;", "l", "([Lkotlin/Pair;)Ljava/util/LinkedHashMap;", "key", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Ljava/util/Map;Ljava/lang/Object;)Ljava/lang/Object;", "LY8/t;", "v", "(Ljava/util/Map;[Lkotlin/Pair;)V", "", "u", "(Ljava/util/Map;Ljava/lang/Iterable;)V", "LKa/j;", "t", "(Ljava/util/Map;LKa/j;)V", "y", "(Ljava/lang/Iterable;)Ljava/util/Map;", "M", "destination", "z", "(Ljava/lang/Iterable;Ljava/util/Map;)Ljava/util/Map;", "B", "([Lkotlin/Pair;Ljava/util/Map;)Ljava/util/Map;", "w", "(LKa/j;)Ljava/util/Map;", "x", "(LKa/j;Ljava/util/Map;)Ljava/util/Map;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(Ljava/util/Map;)Ljava/util/Map;", "C", "pair", "s", "(Ljava/util/Map;Lkotlin/Pair;)Ljava/util/Map;", C3081a.FOCUS_MAP_NAME, "r", "(Ljava/util/Map;Ljava/util/Map;)Ljava/util/Map;", "o", "(Ljava/util/Map;Ljava/lang/Object;)Ljava/util/Map;", "keys", "n", "(Ljava/util/Map;Ljava/lang/Iterable;)Ljava/util/Map;", "q", "kotlin-stdlib"}, k = 5, mv = {2, 2, 0}, xi = 49, xs = "kotlin/collections/MapsKt")
/* loaded from: classes4.dex */
public class a extends Q {
    public static <K, V> Map<K, V> A(Map<? extends K, ? extends V> map) {
        p.i(map, "<this>");
        int size = map.size();
        return size != 0 ? size != 1 ? C(map) : Q.g(map) : i();
    }

    public static final <K, V, M extends Map<? super K, ? super V>> M B(Pair<? extends K, ? extends V>[] pairArr, M destination) {
        p.i(pairArr, "<this>");
        p.i(destination, "destination");
        v(destination, pairArr);
        return destination;
    }

    public static <K, V> Map<K, V> C(Map<? extends K, ? extends V> map) {
        p.i(map, "<this>");
        return new LinkedHashMap(map);
    }

    public static <K, V> Map<K, V> i() {
        EmptyMap emptyMap = EmptyMap.f34709a;
        p.g(emptyMap, "null cannot be cast to non-null type kotlin.collections.Map<K of kotlin.collections.MapsKt__MapsKt.emptyMap, V of kotlin.collections.MapsKt__MapsKt.emptyMap>");
        return emptyMap;
    }

    public static <K, V> V j(Map<K, ? extends V> map, K k10) {
        p.i(map, "<this>");
        return (V) P.a(map, k10);
    }

    public static <K, V> HashMap<K, V> k(Pair<? extends K, ? extends V>... pairs) {
        p.i(pairs, "pairs");
        HashMap<K, V> map = new HashMap<>(Q.e(pairs.length));
        v(map, pairs);
        return map;
    }

    public static <K, V> LinkedHashMap<K, V> l(Pair<? extends K, ? extends V>... pairs) {
        p.i(pairs, "pairs");
        return (LinkedHashMap) B(pairs, new LinkedHashMap(Q.e(pairs.length)));
    }

    public static <K, V> Map<K, V> m(Pair<? extends K, ? extends V>... pairs) {
        p.i(pairs, "pairs");
        return pairs.length > 0 ? B(pairs, new LinkedHashMap(Q.e(pairs.length))) : i();
    }

    public static <K, V> Map<K, V> n(Map<? extends K, ? extends V> map, Iterable<? extends K> keys) {
        p.i(map, "<this>");
        p.i(keys, "keys");
        Map mapC = C(map);
        A.K(mapC.keySet(), keys);
        return q(mapC);
    }

    public static <K, V> Map<K, V> o(Map<? extends K, ? extends V> map, K k10) {
        p.i(map, "<this>");
        Map mapC = C(map);
        mapC.remove(k10);
        return q(mapC);
    }

    public static <K, V> Map<K, V> p(Pair<? extends K, ? extends V>... pairs) {
        p.i(pairs, "pairs");
        LinkedHashMap linkedHashMap = new LinkedHashMap(Q.e(pairs.length));
        v(linkedHashMap, pairs);
        return linkedHashMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, V> Map<K, V> q(Map<K, ? extends V> map) {
        p.i(map, "<this>");
        int size = map.size();
        return size != 0 ? size != 1 ? map : Q.g(map) : i();
    }

    public static <K, V> Map<K, V> r(Map<? extends K, ? extends V> map, Map<? extends K, ? extends V> map2) {
        p.i(map, "<this>");
        p.i(map2, "map");
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        linkedHashMap.putAll(map2);
        return linkedHashMap;
    }

    public static <K, V> Map<K, V> s(Map<? extends K, ? extends V> map, Pair<? extends K, ? extends V> pair) {
        p.i(map, "<this>");
        p.i(pair, "pair");
        if (map.isEmpty()) {
            return Q.f(pair);
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        linkedHashMap.put(pair.e(), pair.f());
        return linkedHashMap;
    }

    public static final <K, V> void t(Map<? super K, ? super V> map, j<? extends Pair<? extends K, ? extends V>> pairs) {
        p.i(map, "<this>");
        p.i(pairs, "pairs");
        for (Pair<? extends K, ? extends V> pair : pairs) {
            map.put(pair.a(), pair.b());
        }
    }

    public static <K, V> void u(Map<? super K, ? super V> map, Iterable<? extends Pair<? extends K, ? extends V>> pairs) {
        p.i(map, "<this>");
        p.i(pairs, "pairs");
        for (Pair<? extends K, ? extends V> pair : pairs) {
            map.put(pair.a(), pair.b());
        }
    }

    public static final <K, V> void v(Map<? super K, ? super V> map, Pair<? extends K, ? extends V>[] pairs) {
        p.i(map, "<this>");
        p.i(pairs, "pairs");
        for (Pair<? extends K, ? extends V> pair : pairs) {
            map.put(pair.a(), pair.b());
        }
    }

    public static <K, V> Map<K, V> w(j<? extends Pair<? extends K, ? extends V>> jVar) {
        p.i(jVar, "<this>");
        return q(x(jVar, new LinkedHashMap()));
    }

    public static final <K, V, M extends Map<? super K, ? super V>> M x(j<? extends Pair<? extends K, ? extends V>> jVar, M destination) {
        p.i(jVar, "<this>");
        p.i(destination, "destination");
        t(destination, jVar);
        return destination;
    }

    public static <K, V> Map<K, V> y(Iterable<? extends Pair<? extends K, ? extends V>> iterable) {
        p.i(iterable, "<this>");
        if (!(iterable instanceof Collection)) {
            return q(z(iterable, new LinkedHashMap()));
        }
        Collection collection = (Collection) iterable;
        int size = collection.size();
        if (size == 0) {
            return i();
        }
        if (size != 1) {
            return z(iterable, new LinkedHashMap(Q.e(collection.size())));
        }
        return Q.f((Pair) (iterable instanceof List ? ((List) iterable).get(0) : collection.iterator().next()));
    }

    public static final <K, V, M extends Map<? super K, ? super V>> M z(Iterable<? extends Pair<? extends K, ? extends V>> iterable, M destination) {
        p.i(iterable, "<this>");
        p.i(destination, "destination");
        u(destination, iterable);
        return destination;
    }
}
