package e9;

import d7.e0;
import d7.t;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public abstract class j {
    static {
        new c("java.lang").c(f.e("annotation"));
    }

    public static final b a(String str) {
        c cVar = i.f3207a;
        return new b(i.f3207a, f.e(str));
    }

    public static final b b(String str) {
        c cVar = i.f3207a;
        return new b(i.f3209c, f.e(str));
    }

    public static final void c(LinkedHashMap linkedHashMap) {
        Set<Map.Entry> setEntrySet = linkedHashMap.entrySet();
        int iS = e0.S(t.A0(setEntrySet, 10));
        if (iS < 16) {
            iS = 16;
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(iS);
        for (Map.Entry entry : setEntrySet) {
            linkedHashMap2.put(entry.getValue(), entry.getKey());
        }
    }

    public static final b d(f fVar) {
        c cVar = i.f3207a;
        b bVar = i.f3214h;
        return new b(bVar.g(), f.e(fVar.c().concat(bVar.i().c())));
    }

    public static final b e(String str) {
        c cVar = i.f3207a;
        return new b(i.f3208b, f.e(str));
    }

    public static final b f(b bVar) {
        c cVar = i.f3207a;
        return new b(i.f3207a, f.e("U".concat(bVar.i().c())));
    }
}
