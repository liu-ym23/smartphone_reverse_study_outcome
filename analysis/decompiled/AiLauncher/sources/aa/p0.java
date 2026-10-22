package aa;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes5.dex */
public final class p0 {

    /* renamed from: a, reason: collision with root package name */
    public final Map<Integer, C1261i> f8173a;

    public p0(Map<Integer, C1261i> map) {
        kotlin.jvm.internal.p.i(map, "map");
        this.f8173a = map;
    }

    public final p0 a() {
        Map<Integer, C1261i> map = this.f8173a;
        LinkedHashMap linkedHashMap = new LinkedHashMap(Z8.Q.e(map.size()));
        Iterator<T> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            linkedHashMap.put(entry.getKey(), C1261i.c((C1261i) entry.getValue(), null, null, false, true, 7, null));
        }
        return new p0(linkedHashMap);
    }

    public final Map<Integer, C1261i> b() {
        return this.f8173a;
    }
}
