package n3;

import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes2.dex */
public abstract class f {

    /* renamed from: a, reason: collision with root package name */
    public static final o3.b f13670a;

    static {
        try {
            f13670a = p3.b.f13936b.f13937a;
        } catch (Exception e4) {
            com.stepos.statsrpk.c.K("Unexpected failure while binding MarkerFactory", e4);
        } catch (NoClassDefFoundError unused) {
            f13670a = new o3.b(0);
        }
    }

    public static e a(String str) {
        o3.b bVar = f13670a;
        if (str == null) {
            bVar.getClass();
            throw new IllegalArgumentException("Marker name cannot be null");
        }
        ConcurrentHashMap concurrentHashMap = bVar.f13805a;
        e eVar = (e) concurrentHashMap.get(str);
        if (eVar != null) {
            return eVar;
        }
        o3.a aVar = new o3.a(str);
        e eVar2 = (e) concurrentHashMap.putIfAbsent(str, aVar);
        return eVar2 != null ? eVar2 : aVar;
    }
}
