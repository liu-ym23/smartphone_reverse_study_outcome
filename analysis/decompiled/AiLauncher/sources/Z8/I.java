package Z8;

import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref$IntRef;

@Metadata(d1 = {"\u0000\u0014\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\b\u0003\u001a7\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u00040\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "K", "LZ8/H;", "", "", Const.INTENT_KEY_APIKEY, "(LZ8/H;)Ljava/util/Map;", "kotlin-stdlib"}, k = 5, mv = {2, 2, 0}, xi = 49, xs = "kotlin/collections/GroupingKt")
/* loaded from: classes4.dex */
public class I {
    public static <T, K> Map<K, Integer> a(H<T, ? extends K> h10) {
        kotlin.jvm.internal.p.i(h10, "<this>");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<T> itB = h10.b();
        while (itB.hasNext()) {
            K kA = h10.a(itB.next());
            Object ref$IntRef = linkedHashMap.get(kA);
            if (ref$IntRef == null && !linkedHashMap.containsKey(kA)) {
                ref$IntRef = new Ref$IntRef();
            }
            Ref$IntRef ref$IntRef2 = (Ref$IntRef) ref$IntRef;
            ref$IntRef2.f34818a++;
            linkedHashMap.put(kA, ref$IntRef2);
        }
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            kotlin.jvm.internal.p.g(entry, "null cannot be cast to non-null type kotlin.collections.MutableMap.MutableEntry<K of kotlin.collections.GroupingKt__GroupingJVMKt.mapValuesInPlace, R of kotlin.collections.GroupingKt__GroupingJVMKt.mapValuesInPlace>");
            kotlin.jvm.internal.z.e(entry).setValue(Integer.valueOf(((Ref$IntRef) entry.getValue()).f34818a));
        }
        return kotlin.jvm.internal.z.d(linkedHashMap);
    }
}
