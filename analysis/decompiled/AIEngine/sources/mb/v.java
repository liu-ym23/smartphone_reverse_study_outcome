package mb;

import androidx.datastore.preferences.protobuf.b1;
import java.util.Collections;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.builders.MapBuilder;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class v extends b1 {
    public static MapBuilder Z(MapBuilder mapBuilder) {
        return mapBuilder.b();
    }

    public static int a0(int i10) {
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

    public static <K, V> Map<K, V> b0(Pair<? extends K, ? extends V> pair) {
        kotlin.jvm.internal.g.f(pair, "pair");
        Map<K, V> mapSingletonMap = Collections.singletonMap(pair.f9985a, pair.f9986b);
        kotlin.jvm.internal.g.e(mapSingletonMap, "singletonMap(...)");
        return mapSingletonMap;
    }

    public static final <K, V> Map<K, V> c0(Map<? extends K, ? extends V> map) {
        kotlin.jvm.internal.g.f(map, "<this>");
        Map.Entry<? extends K, ? extends V> next = map.entrySet().iterator().next();
        Map<K, V> mapSingletonMap = Collections.singletonMap(next.getKey(), next.getValue());
        kotlin.jvm.internal.g.e(mapSingletonMap, "with(...)");
        return mapSingletonMap;
    }
}
