package d.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: MapWithDefault.kt */
/* JADX INFO: loaded from: classes4.dex */
class ap {
    public static final <K, V> V a(Map<K, ? extends V> r2, K r3) {
        Map r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "<this>");
        if (ZeusTransformUtils.instanceOf(r4, an.class) == true) goto L5;
        V r0 = (V) r4.get(r3);
        if (r0 == null) goto L9;
    L13:
        return r0;
    L9:
        if (r4.containsKey(r3) == true) goto L13;
        throw new NoSuchElementException("Key " + r3 + " is missing in the map.");
    L5:
        return (V) ((an) ZeusTransformUtils.preCheckCast(r4, an.class, "com.obric.aiagent.plugin")).a(r3);
    }
}
