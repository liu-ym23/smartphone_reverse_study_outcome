package Z8;

import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.builders.MapBuilder;

@Metadata(d1 = {"\u00000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a9\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006\u001a'\u0010\b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0007\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001H\u0001¢\u0006\u0004\b\b\u0010\t\u001a/\u0010\f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0007\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012\u0006\u0010\u000b\u001a\u00020\nH\u0001¢\u0006\u0004\b\f\u0010\r\u001a;\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0007H\u0001¢\u0006\u0004\b\u000f\u0010\u0010\u001aG\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0013\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00042\u000e\u0010\u0012\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u0011¢\u0006\u0004\b\u0014\u0010\u0015\u001a9\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004H\u0000¢\u0006\u0004\b\u0016\u0010\u0010\u001a\u0017\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\nH\u0001¢\u0006\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lkotlin/Pair;", "pair", "", "f", "(Lkotlin/Pair;)Ljava/util/Map;", "", "c", "()Ljava/util/Map;", "", "capacity", Const.INTENT_KEY_UMID, "(I)Ljava/util/Map;", "builder", Const.INTENT_KEY_PKGNAME, "(Ljava/util/Map;)Ljava/util/Map;", "Ljava/util/Comparator;", "comparator", "Ljava/util/SortedMap;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Ljava/util/Map;Ljava/util/Comparator;)Ljava/util/SortedMap;", Const.INTENT_KEY_BACKGROUND_COMMAND, "expectedSize", "e", "(I)I", "kotlin-stdlib"}, k = 5, mv = {2, 2, 0}, xi = 49, xs = "kotlin/collections/MapsKt")
/* loaded from: classes4.dex */
public class Q extends P {
    public static <K, V> Map<K, V> b(Map<K, V> builder) {
        kotlin.jvm.internal.p.i(builder, "builder");
        return ((MapBuilder) builder).s();
    }

    public static <K, V> Map<K, V> c() {
        return new MapBuilder();
    }

    public static <K, V> Map<K, V> d(int i10) {
        return new MapBuilder(i10);
    }

    public static int e(int i10) {
        if (i10 < 0) {
            return i10;
        }
        if (i10 < 3) {
            return i10 + 1;
        }
        if (i10 < 1073741824) {
            return (int) ((i10 / 0.75f) + 1.0f);
        }
        return Integer.MAX_VALUE;
    }

    public static <K, V> Map<K, V> f(Pair<? extends K, ? extends V> pair) {
        kotlin.jvm.internal.p.i(pair, "pair");
        Map<K, V> mapSingletonMap = Collections.singletonMap(pair.e(), pair.f());
        kotlin.jvm.internal.p.h(mapSingletonMap, "singletonMap(...)");
        return mapSingletonMap;
    }

    public static final <K, V> Map<K, V> g(Map<? extends K, ? extends V> map) {
        kotlin.jvm.internal.p.i(map, "<this>");
        Map.Entry<? extends K, ? extends V> next = map.entrySet().iterator().next();
        Map<K, V> mapSingletonMap = Collections.singletonMap(next.getKey(), next.getValue());
        kotlin.jvm.internal.p.h(mapSingletonMap, "with(...)");
        return mapSingletonMap;
    }

    public static <K, V> SortedMap<K, V> h(Map<? extends K, ? extends V> map, Comparator<? super K> comparator) {
        kotlin.jvm.internal.p.i(map, "<this>");
        kotlin.jvm.internal.p.i(comparator, "comparator");
        TreeMap treeMap = new TreeMap(comparator);
        treeMap.putAll(map);
        return treeMap;
    }
}
