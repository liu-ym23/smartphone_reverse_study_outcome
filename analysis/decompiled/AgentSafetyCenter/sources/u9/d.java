package u9;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public HashMap f14261a;

    public e a(ClassLoader classLoader, String str) throws ClassNotFoundException {
        HashMap map = this.f14261a;
        Map map2 = (Map) map.get(classLoader);
        if (map2 == null) {
            map2 = new HashMap();
            map.put(classLoader, map2);
        }
        e eVar = (e) map2.get(str);
        if (eVar != null) {
            return eVar;
        }
        Class<?> clsLoadClass = classLoader.loadClass(str);
        e eVar2 = new e();
        new HashMap();
        eVar2.f14263b = new HashMap();
        new HashMap();
        eVar2.f14262a = clsLoadClass;
        map2.put(str, eVar2);
        return eVar2;
    }

    public boolean b(String str, Boolean bool) {
        HashMap map = this.f14261a;
        Objects.requireNonNull(str, "keyword cannot be null");
        return ((Boolean) map.getOrDefault(str, bool)).booleanValue();
    }
}
