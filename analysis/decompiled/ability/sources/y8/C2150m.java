package y8;

import java.util.LinkedHashMap;
import java.util.Map;

/* renamed from: y8.m, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2150m {

    /* renamed from: a, reason: collision with root package name */
    public final LinkedHashMap f6920a;

    public C2150m(LinkedHashMap linkedHashMap) {
        this.f6920a = linkedHashMap;
    }

    public final C2150m a() {
        LinkedHashMap linkedHashMap = this.f6920a;
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(kotlin.collections.a.P(linkedHashMap.size()));
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            Object key = entry.getKey();
            C2141d c2141d = (C2141d) entry.getValue();
            linkedHashMap2.put(key, new C2141d(c2141d.f6912a, c2141d.b, c2141d.c, true));
        }
        return new C2150m(linkedHashMap2);
    }
}
